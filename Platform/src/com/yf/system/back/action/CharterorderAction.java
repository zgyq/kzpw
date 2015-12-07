/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import com.opensymphony.xwork.ActionContext;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.charterorder.Charterorder;
import com.yf.system.base.customeruser.Customeruser;


public class CharterorderAction extends B2b2cbackAction {
	private List <  Charterorder  >  listCharterorder;
	private Charterorder charterorder = new Charterorder();
	
	private List<Aircompany> listAircompany;
	
	//批量操作ID数组
	private int[]selectid;
	
	// 子分隔符 vic
	private String strSubSplit = ",";
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	//以下为下单用属性
	//行程信息
	private String StartAirportCode;
	private String EndAirportCode;
	private String FromDate;
	private String AirCompanyCode;
	private String c_airno;
	private String c_cabincode;
	//联系人信息
	private String c_linkname;
	private String c_linktel;
	private String c_linkemail;
	
	private String c_memo;
	
	//乘机人
	private String p_username;
	private String p_usertype;
	private String p_idtype;
	private String p_idno;
	private String p_shengri;
	
	
	private String forward;
	/**
	 * 列表查询包机订单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Charterorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllCharterorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCharterorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listCharterorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllCharterorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCharterorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到包机订单添加页面
	 */	
	public String toadd()throws Exception{
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到包机订单修改页面
	 */	
	public String toedit()throws Exception{
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);
	charterorder = Server.getInstance().getAirService().findCharterorder(charterorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到包机订单审核页面
	 */	
	public String tocheck()throws Exception{
	charterorder = Server.getInstance().getAirService().findCharterorder(charterorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加包机订单
	 */		
	public String add()throws Exception{
		//charterorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		//Server.getInstance().getAirService().createCharterorder(charterorder);
		
		
		// 航程list
		List<Segmentinfo> listsegmenginfo = new ArrayList<Segmentinfo>();
		// 乘机人list
		List<Passenger> listpassenger = new ArrayList<Passenger>();
		
		//订单对象赋值
		
		Orderinfo orderinfo=new Orderinfo();
		//订单备注
		if(c_memo!=null&&c_memo.trim().length()>0){
		orderinfo.setMemo(c_memo.trim());
		}
		// 创建时间
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// 会员ID
		
		orderinfo.setCustomeruserid(getLoginUser().getId());
		
		// 分销商员工ID,即预订人ID
		orderinfo.setSaleagentid(getLoginUser().getId());
		// 分销商单位ID,加盟商ID
		orderinfo.setBuyagentid(getLoginUser().getAgentid());
		// 联系手机号
		orderinfo.setContactmobile(c_linktel);
		orderinfo.setContactname(c_linkname);
		orderinfo.setPolicyagentid(46l);
		orderinfo.setPnr("123456");
		orderinfo.setLanguage(0);
		// 订单类型 b2b后台订单
		orderinfo.setOrdertype(5l);
		/** **订单信息赋值结束*********************************************************** */

	
		
		orderinfo.setOrderstatus(27);
		
		orderinfo.setContactemail(c_linkemail);//旅客邮箱
		orderinfo.setContacttel(c_linktel);//采购商联系电话
		orderinfo.setTotalairportfee(0f);
		orderinfo.setTotalfuelfee(0f);
		orderinfo.setTotalticketprice(0f);
		orderinfo.setPostmoney(0);
		orderinfo=Server.getInstance().getAirService().createOrderinfo(orderinfo);
		
		
		
		// 取得乘机人信息
		String[] h_ptypes = p_usertype.trim().split(strSubSplit);
		String[] h_names = p_username.trim().split(strSubSplit);
		String[] h_idtypes = p_idtype.trim().split(strSubSplit);
		String[] h_idnumbers = p_idno.trim().split(strSubSplit);
		String[] h_birthdays = p_shengri.trim().split(strSubSplit);
		/** **乘机人信息赋值开始*********************************************************** */
		for (int i = 0; i < h_names.length; i++) {
			if (h_names[i].trim().length() > 0) {
				Passenger passenger = new Passenger();
				passenger.setPtype(Integer.parseInt(h_ptypes[i].trim()));
				passenger.setName(h_names[i]);
				if(!h_ptypes[i].trim().equals("3")){
				passenger.setIdtype(Integer.parseInt(h_idtypes[i].trim()));
				passenger.setIdnumber(h_idnumbers[i].trim());
				}
				try {
					passenger.setBirthday(h_birthdays[i].trim());
				} catch (Exception ex) {
				}
				passenger.setState(0);
				passenger.setLanguage(0);
				passenger.setOrderid(orderinfo.getId());
				passenger=Server.getInstance().getAirService().createPassenger(passenger);
				listpassenger.add(passenger);
			}
		}
		/** **乘机人信息赋值结束*********************************************************** */
		
		//开始赋值行程
		Segmentinfo segmentinfo=new Segmentinfo();
		segmentinfo.setStartairport(StartAirportCode);
		segmentinfo.setEndairport(EndAirportCode);
		segmentinfo.setAircomapnycode(AirCompanyCode);
		segmentinfo.setDeparttime(dateToTimestamp(FromDate));
		segmentinfo.setCabincode(c_cabincode);
		segmentinfo.setFlightnumber(c_airno);
		segmentinfo.setYprice(0f);
		segmentinfo.setParvalue(0f);
		segmentinfo.setPrice(0f);
		segmentinfo.setRatevalue(0f);
		segmentinfo.setFuelfee(0f);
		segmentinfo.setAirportfee(0f);
		segmentinfo.setLanguage(0);
		segmentinfo.setOrderid(orderinfo.getId());
		segmentinfo=Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		//行程结束
		forward="b2bticketorder.action";
		return "forward";
	}

	/**
	 * 审核包机订单
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateCharterorderIgnoreNull(charterorder);
		return LIST;
	}
	


	/**
	 * 编辑包机订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateCharterorderIgnoreNull(charterorder);
		return LIST;
	}

	/**
	 * 删除包机订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteCharterorder(charterorder.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getAirService().deleteCharterorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}


	//包机订单状态
	public String GetCharterOrderStaus(String type) {
		
		if (type.equals("1")) {

			return "新订单待审核";
		}
		if (type.equals("2")) {

			return "已审核,待报价";
		}
		if (type.equals("3")) {

			return "审核不通过";
		}
		if (type.equals("4")) {

			return "已报价";
		}
		if (type.equals("5")) {

			return "报价不接受";
		}
		if (type.equals("6")) {

			return "报价接受,待支付";
		}
		if (type.equals("7")) {

			return "支付成功";
		}
		if (type.equals("8")) {

			return "支付不成功";
		}
		if (type.equals("9")) {

			return "支付成功,未乘机";
		}
		if (type.equals("10")) {

			return "交易结束";
		}
		if (type.equals("11")) {

			return "已取消";
		}
		return "";
	}



	/**
	 *  返回包机订单对象
	 */		
	
	public Object getModel() {
		return charterorder;
	}
	public List < Charterorder >   getListCharterorder() {
		return listCharterorder;
	}
	public void setListCharterorder(List <  Charterorder  >  listCharterorder) {
		this.listCharterorder = listCharterorder;
	}
	public Charterorder getCharterorder() {
		return charterorder;
	}
	public void setCharterorder(Charterorder charterorder) {
		this.charterorder = charterorder;
	}
	
	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}
	public String getStrSubSplit() {
		return strSubSplit;
	}
	public void setStrSubSplit(String strSubSplit) {
		this.strSubSplit = strSubSplit;
	}
	public String getStartAirportCode() {
		return StartAirportCode;
	}
	public void setStartAirportCode(String startAirportCode) {
		StartAirportCode = startAirportCode;
	}
	public String getEndAirportCode() {
		return EndAirportCode;
	}
	public void setEndAirportCode(String endAirportCode) {
		EndAirportCode = endAirportCode;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getAirCompanyCode() {
		return AirCompanyCode;
	}
	public void setAirCompanyCode(String airCompanyCode) {
		AirCompanyCode = airCompanyCode;
	}
	public String getC_airno() {
		return c_airno;
	}
	public void setC_airno(String c_airno) {
		this.c_airno = c_airno;
	}
	public String getC_cabincode() {
		return c_cabincode;
	}
	public void setC_cabincode(String c_cabincode) {
		this.c_cabincode = c_cabincode;
	}
	public String getC_linkname() {
		return c_linkname;
	}
	public void setC_linkname(String c_linkname) {
		this.c_linkname = c_linkname;
	}
	public String getC_linktel() {
		return c_linktel;
	}
	public void setC_linktel(String c_linktel) {
		this.c_linktel = c_linktel;
	}
	public String getC_linkemail() {
		return c_linkemail;
	}
	public void setC_linkemail(String c_linkemail) {
		this.c_linkemail = c_linkemail;
	}
	public String getC_memo() {
		return c_memo;
	}
	public void setC_memo(String c_memo) {
		this.c_memo = c_memo;
	}
	public String getP_username() {
		return p_username;
	}
	public void setP_username(String p_username) {
		this.p_username = p_username;
	}
	public String getP_usertype() {
		return p_usertype;
	}
	public void setP_usertype(String p_usertype) {
		this.p_usertype = p_usertype;
	}
	public String getP_idtype() {
		return p_idtype;
	}
	public void setP_idtype(String p_idtype) {
		this.p_idtype = p_idtype;
	}
	public String getP_idno() {
		return p_idno;
	}
	public void setP_idno(String p_idno) {
		this.p_idno = p_idno;
	}
	public String getP_shengri() {
		return p_shengri;
	}
	public void setP_shengri(String p_shengri) {
		this.p_shengri = p_shengri;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	
	
}