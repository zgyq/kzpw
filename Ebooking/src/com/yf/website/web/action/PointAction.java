package com.yf.website.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.base.customerintegralrecord.Customerintegralrecord;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.customeruser.CustomeruserBean;
import com.yf.system.base.gift.Gift;
import com.yf.system.base.giftcatalog.Giftcatalog;
import com.yf.system.base.redeem.Redeem;
import com.yf.system.base.useraddress.Useraddress;
import com.yf.system.base.util.PageInfo;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class PointAction extends B2b2cbackAction {
	private List<Giftcatalog> listGiftcatalog;
	private List<Gift> listGiftInfo;
	//常用配送地址list
	private List<Useraddress> listUseraddress;
	//我的兑换记录LIST
	private List<Redeem> ListRedeem;
	//当前登陆者积分来源记录
	private List<Customerintegralrecord> ListCustomerintegralrecord;
	private Gift gift =new Gift();
	private String items;
	private String point;
	private long Giftid;
	private long UserAddressID;
	
	//积分来源查询条件开始
	private String c_ordernum;
	private String c_ordertext;
	
	//结束
	
	//当前登陆者可用积分
	private int UserIntegral;
	
	//目录树用
	private String treestr="";
	private String str1="";
	//兑换记录用字段
	
	private String c_username;//收货人
	private String c_giftname;//礼品名称
	private String c_stime;//兑换开始时间
	private String c_endtime;//兑换结束时间
	
	//积分兑换,商品检索用字段
	private String c_selectValue;//积分分类
	

	private void getString(long id) {
		List<Giftcatalog> list;
		String where = " WHERE  "
				+ Giftcatalog.COL_parentid + " = " + id;
    	list = Server.getInstance().getSystemService().findAllGiftcatalog(where, "ORDER BY ID", -1, 0);     
		if (!list.isEmpty()) {
			for (Giftcatalog m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";
					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId());
			}
		}
	}
	/**
	 * 异步查询当前登录会员的积分 2012-01-10 陈星
	 * 
	 * @throws IOException 
	 */

	public void SeacUserUseintegral() throws IOException {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		Customeruser customeruser = getLoginUser();
		customeruser=Server.getInstance().getMemberService().findCustomeruser(customeruser.getId());
		if(customeruser!=null&&customeruser.getTotalscore()!=null&&customeruser.getTotalscore()>0){
			sb.append(customeruser.getTotalscore());
		}
		out.print(sb.toString());
		out.flush();
		out.close();
		
	}
	/**
	 * 根据常用配送地址ID查询详细信息 2012-01-10 陈星
	 * 参数1 UserAddressID  配送地址ID
	 * @throws IOException 
	 */

	public void GetUserAddressById() throws IOException {
		System.out.println("根据常用配送地址ID查询详细信息:"+UserAddressID);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		Useraddress useraddress =Server.getInstance().getMemberService().findUseraddress(UserAddressID);
		if(useraddress!=null){
			sb.append(useraddress.getName()+"?");
			sb.append(useraddress.getAreacode()+"?");
			sb.append(useraddress.getTel()+"?");
			sb.append(useraddress.getMobile()+"?");
			sb.append(useraddress.getProvince()+"?");
			sb.append(useraddress.getCity()+"?");
			sb.append(useraddress.getArea()+"?");
			sb.append(useraddress.getPostalcode()+"?");
		}
		
		out.print(sb.toString());
		out.flush();
		out.close();
	}
	/**
	 * 积分记录 2011-12-27 陈星
	 */

	public String toPointRecord() {
		System.out.println("查看积分记录");
		String where =" where 1=1 and "+Customerintegralrecord.COL_refuid+" ="+getLoginUser().getId();
		if(c_ordernum!=null&&c_ordernum.length()>0){
			
			where+=" and "+Customerintegralrecord.COL_refordernumber+" like '%"+c_ordernum+"%'";
		}
		if(c_ordertext!=null&&c_ordertext.length()>0){
			
			where+=" and "+Customerintegralrecord.COL_scorememo+" like '%"+c_ordertext+"%'";
		}
		if(c_stime!=null&&c_stime.length()>0){
			
			where+=" and "+Customerintegralrecord.COL_createtime+" >='"+c_stime+"'";
		}
		if(c_endtime!=null&&c_endtime.length()>0){
			
			where+=" and "+Customerintegralrecord.COL_createtime+" <='"+c_endtime+"'";
		}
		
		
		List list=Server.getInstance().getMemberService().findAllCustomerintegralrecordForPageinfo(where, " ORDER BY ID DESC ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		ListCustomerintegralrecord=list;
		if (pageinfo.getTotalrow() > 0 && ListCustomerintegralrecord.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomerintegralrecordForPageinfo(where, " ORDER BY ID DESC ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			ListCustomerintegralrecord = list;
		}
		if(getLoginUser()!=null&&getLoginUser().getTotalscore()!=null&&getLoginUser().getTotalscore()>0){
			UserIntegral=getLoginUser().getTotalscore();
			}
		return "exchange";

	}

	

	/**
	 * 兑换记录 2011-12-27 陈星
	 */
	public String toIntegral() {
		
		String where=" where 1=1 and "+Redeem.COL_userid+" ="+getLoginUser().getId();
		if(c_username!=null&&c_username.length()>0){
			
			where+=" and "+Redeem.COL_name+" like '%"+c_username.trim()+"%'";
		}
		if(c_giftname!=null&&c_giftname.length()>0){
			
			where+=" and "+Redeem.COL_giftname+" like '%"+c_giftname.trim()+"%'";
		}
		if(c_stime!=null&&c_stime.length()>0){
			
			where+=" and "+Redeem.COL_createtime+" >='"+c_stime+"'";
		}
		if(c_endtime!=null&&c_endtime.length()>0){
			
			where+=" and "+Redeem.COL_createtime+" <='"+c_endtime+"'";
		}
		
		
		ListRedeem=Server.getInstance().getSystemService().findAllRedeem(where, " ORDER BY ID DESC ", -1, 0);
		
		if(getLoginUser()!=null&&getLoginUser().getTotalscore()!=null&&getLoginUser().getTotalscore()>0){
		UserIntegral=getLoginUser().getTotalscore();
		}
		
		return "integral";

	}

	/**
	 * 积分商城 2011-12-27 陈星
	 */
	public String toPointsmall() {
		String where = " WHERE  " + Giftcatalog.COL_state + " = 0";
		listGiftcatalog = Server.getInstance().getSystemService()
				.findAllGiftcatalog(where, "ORDER BY ID", 3, 0);
		getString(-1);
		return "pointsmall";
	}
   /***
    * 根据分类id查询积分商品
    * 2011-12-27
    * 陈星*/
	public List<Gift> getGiftInfoById(long id,String c_selectValue){
		String where=" WHERE "+Gift.COL_giftcatalogid +" = "+id +" AND "+Gift.COL_online + " = 0";
		if(c_selectValue!=null&&!c_selectValue.equals("-1")){
			if(c_selectValue.equals("1")){
				where+=" and "+Gift.COL_useintegral+" >0 and "+Gift.COL_useintegral+" <=1000";
			}
			if(c_selectValue.equals("2")){
				where+=" and "+Gift.COL_useintegral+" >1000 and "+Gift.COL_useintegral+" <=5000";
			}
			if(c_selectValue.equals("3")){
				where+=" and "+Gift.COL_useintegral+" >50000 and "+Gift.COL_useintegral+" <=10000";
			}
			if(c_selectValue.equals("4")){
				where+=" and "+Gift.COL_useintegral+" >10000";
			}
			
		}
		return Server.getInstance().getSystemService().findAllGift(where, "ORDER BY ID", 4, 0);
		}
	
	/**
	 * 条件查询积分商品 2011-12-27 陈星
	 */
	public String searchGiftcatalog() {
		System.out.println("查询内容" + items);
		String where = " WHERE " + Giftcatalog.COL_state + "= 0 ";
		if(c_selectValue!=null&&!c_selectValue.equals("-1")){
			if(c_selectValue.equals("1")){
				where+=" and "+Giftcatalog.COL_id+" in ( SELECT "+Gift.COL_giftcatalogid+" FROM "+Gift.TABLE+" where "+Gift.COL_useintegral+" >0 and "+Gift.COL_useintegral+" <=1000)";
			}
			if(c_selectValue.equals("2")){
				where+=" and "+Giftcatalog.COL_id+" in ( SELECT "+Gift.COL_giftcatalogid+" FROM "+Gift.TABLE+" where "+Gift.COL_useintegral+" >1000 and "+Gift.COL_useintegral+" <=5000)";
			}
			if(c_selectValue.equals("3")){
				where+=" and "+Giftcatalog.COL_id+" in ( SELECT "+Gift.COL_giftcatalogid+" FROM "+Gift.TABLE+" where "+Gift.COL_useintegral+" >50000 and "+Gift.COL_useintegral+" <=10000)";
			}
			if(c_selectValue.equals("4")){
				where+=" and "+Giftcatalog.COL_id+" in ( SELECT "+Gift.COL_giftcatalogid+" FROM "+Gift.TABLE+" where "+Gift.COL_useintegral+" >10000)";
			}
			
		}
		System.out.println("where="+where);
		
		/*if (items != null && point == null) {
			where += " AND " + Giftcatalog.COL_name + " like '%" + items.trim()
					+ "%'";
		} else if (point != null && items == null) {
			where += " AND " + Giftcatalog.COL_name + " like '%" + items.trim()
					+ "%'";
		} else if (point == null && items == null) {
			where += " AND " + Giftcatalog.COL_name + " like '%" + items.trim()
					+ "%'";
		} else {
			where += " AND " + Giftcatalog.COL_name + " like '%" + items.trim()
					+ "%'";
		}*/
		listGiftcatalog = Server.getInstance().getSystemService()
		.findAllGiftcatalog(where, "ORDER BY ID", -1, 0);	
		
		System.out.println("listGiftcatalog=="+listGiftcatalog.size());
		return "pointsmall";

	}

	/**
	 * 积分兑换 下单 2011-12-27 陈星
	 */
	public String toPointOrder() {
		gift=Server.getInstance().getSystemService().findGift(Giftid);
		
		
		String where = " where 1=1 and "+Useraddress.COL_memberid+" ="+getLoginUser().getId();
		listUseraddress=Server.getInstance().getMemberService().findAllUseraddress(where, " order by id", -1, 0);
	
		return "pointorder";
	}

	/**
	 * 积分兑换成功 2012-02-10 陈星
	 * @throws Exception 
	 */
	public String toPointSuccess() throws Exception {
		
		
		
		
		Customeruser customeruser = getLoginUser();
		if(customeruser==null){
			return "toLogin";
		}
		
			AddAddress();
		
		 gift = Server.getInstance().getSystemService().findGift(Giftid);
		Useraddress useraddress =Server.getInstance().getMemberService().findUseraddress(UserAddressID);
		
		if(customeruser.getTotalscore()!=null&&customeruser.getTotalscore()>gift.getUseintegral()){
			Redeem redeem = new Redeem();
			redeem.setAddress(UserAddressID+"");
			redeem.setGiftid(Giftid);
			redeem.setCreatetime(new Timestamp(System.currentTimeMillis()));
			redeem.setCreateuser(getLoginUser().getLoginname());
			redeem.setUserid(getLoginUser().getId());
			redeem.setIntegral(gift.getUseintegral());
			redeem.setState(0l);
			redeem.setProvince(useraddress.getProvince());
			redeem.setCity(useraddress.getCity());
			redeem.setArea(useraddress.getArea());
			redeem.setPostcode(useraddress.getPostalcode());
			redeem.setGiftname(gift.getName());
			redeem.setName(useraddress.getName());
			redeem.setMobile(useraddress.getMobile());
			Server.getInstance().getSystemService().createRedeem(redeem);
			
			
			Customeruser user=Server.getInstance().getMemberService().findCustomeruser(customeruser.getId());
			Integer GiftUseintegral=Integer.parseInt(gift.getUseintegral().toString());
			user.setTotalscore(user.getTotalscore()-GiftUseintegral);
			Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(user);
			
			
			ActionContext.getContext().getSession().remove("loginuser");
			ActionContext.getContext().getSession().put("loginuser", user);
		}
		
		
		
		
		
		
		
		return "points";
	}
	
	private String col_name;
	private String col_province;
	private String col_city;
	private String col_area;
	private String col_address;
	private String col_areacode;
	
	private String col_tel;
	private String col_mobile;
	private String col_mail;
	private String col_postalcode;
	
	public void AddAddress() throws Exception{
		
		Useraddress useraddress = new Useraddress();
			if(UserAddressID>0){
			useraddress=Server.getInstance().getMemberService().findUseraddress(UserAddressID);
			}
			useraddress.setName(col_name);
			useraddress.setProvince(col_province);
			useraddress.setCity(col_city);
			useraddress.setArea(col_area);
			if(col_province!=null&&col_city!=null&&col_area!=null){
			col_address=col_province+"-"+col_city+"-"+col_area;
			}
			useraddress.setAddress(col_address);
			useraddress.setAreacode(col_areacode);
			useraddress.setTel(col_tel);
			useraddress.setMobile(col_mobile);
			useraddress.setMail(col_mail);
			useraddress.setPostalcode(col_postalcode);
			useraddress.setMemberid(getLoginUser().getId());
			if(UserAddressID>0){
				Server.getInstance().getMemberService().updateUseraddressIgnoreNull(useraddress);
				
			}else{
				useraddress = Server.getInstance().getMemberService().createUseraddress(useraddress);
			}
			
			System.out.println("useraddress=="+useraddress);
			
	}
	
	public String getCol_name() {
		return col_name;
	}
	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}
	public String getCol_province() {
		return col_province;
	}
	public void setCol_province(String col_province) {
		this.col_province = col_province;
	}
	public String getCol_city() {
		return col_city;
	}
	public void setCol_city(String col_city) {
		this.col_city = col_city;
	}
	public String getCol_area() {
		return col_area;
	}
	public void setCol_area(String col_area) {
		this.col_area = col_area;
	}
	public String getCol_address() {
		return col_address;
	}
	public void setCol_address(String col_address) {
		this.col_address = col_address;
	}
	public String getCol_areacode() {
		return col_areacode;
	}
	public void setCol_areacode(String col_areacode) {
		this.col_areacode = col_areacode;
	}
	public String getCol_tel() {
		return col_tel;
	}
	public void setCol_tel(String col_tel) {
		this.col_tel = col_tel;
	}
	public String getCol_mobile() {
		return col_mobile;
	}
	public void setCol_mobile(String col_mobile) {
		this.col_mobile = col_mobile;
	}
	public String getCol_mail() {
		return col_mail;
	}
	public void setCol_mail(String col_mail) {
		this.col_mail = col_mail;
	}
	public String getCol_postalcode() {
		return col_postalcode;
	}
	public void setCol_postalcode(String col_postalcode) {
		this.col_postalcode = col_postalcode;
	}
	/**
	 * 跳转到成功页面 2012-02-11 陈星
	 */
	public String toSuccess() {
		
		return "";
	}

	/**
	 * 积分商品信息 2011-12-27 陈星
	 */
	public String toPointProInfo() {
		gift=Server.getInstance().getSystemService().findGift(Giftid);
		
		return "pointproinfo";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Giftcatalog> getListGiftcatalog() {
		return listGiftcatalog;
	}

	public void setListGiftcatalog(List<Giftcatalog> listGiftcatalog) {
		this.listGiftcatalog = listGiftcatalog;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	public List<Gift> getListGiftInfo() {
		return listGiftInfo;
	}

	public void setListGiftInfo(List<Gift> listGiftInfo) {
		this.listGiftInfo = listGiftInfo;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public long getGiftid() {
		return Giftid;
	}

	public void setGiftid(long giftid) {
		Giftid = giftid;
	}

	public List<Useraddress> getListUseraddress() {
		return listUseraddress;
	}

	public void setListUseraddress(List<Useraddress> listUseraddress) {
		this.listUseraddress = listUseraddress;
	}
	public long getUserAddressID() {
		return UserAddressID;
	}
	public void setUserAddressID(long userAddressID) {
		UserAddressID = userAddressID;
	}
	public List<Redeem> getListRedeem() {
		return ListRedeem;
	}
	public void setListRedeem(List<Redeem> listRedeem) {
		ListRedeem = listRedeem;
	}
	public int getUserIntegral() {
		return UserIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		UserIntegral = userIntegral;
	}
	public List<Customerintegralrecord> getListCustomerintegralrecord() {
		return ListCustomerintegralrecord;
	}
	public void setListCustomerintegralrecord(
			List<Customerintegralrecord> listCustomerintegralrecord) {
		ListCustomerintegralrecord = listCustomerintegralrecord;
	}
	public String getC_ordernum() {
		return c_ordernum;
	}
	public void setC_ordernum(String c_ordernum) {
		this.c_ordernum = c_ordernum;
	}
	public String getC_ordertext() {
		return c_ordertext;
	}
	public void setC_ordertext(String c_ordertext) {
		this.c_ordertext = c_ordertext;
	}
	public String getTreestr() {
		return treestr;
	}
	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	public String getC_username() {
		return c_username;
	}
	public void setC_username(String c_username) {
		this.c_username = c_username;
	}
	public String getC_giftname() {
		return c_giftname;
	}
	public void setC_giftname(String c_giftname) {
		this.c_giftname = c_giftname;
	}
	public String getC_selectValue() {
		return c_selectValue;
	}
	public void setC_selectValue(String value) {
		c_selectValue = value;
	}
	public String getC_stime() {
		return c_stime;
	}
	public void setC_stime(String c_stime) {
		this.c_stime = c_stime;
	}
	public String getC_endtime() {
		return c_endtime;
	}
	public void setC_endtime(String c_endtime) {
		this.c_endtime = c_endtime;
	}
}
