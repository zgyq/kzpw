/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.website.web.action;

import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.yf.system.base.buying.Buying;
import com.yf.system.base.buyingimg.Buyingimg;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotline.Spotline;
import com.yf.system.base.spotlineorder.Spotlineorder;
import com.yf.system.base.util.PageInfo;
import com.yf.website.web.date.CnToSpell;
import com.yf.website.web.server.Server;



/**
 *旅游门票
 * @author Administrator
 *
 */
public class BuyingAction extends B2b2cbackAction {
	
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	//城市ID
	private String CityID;
	
	//搜索关键字
	private String SeachName;
	
	
	
	//跳转用
	private String forword;

	
	
	//下单用参数联系人信息
	
	//总价
	private String price;
	
	//邮箱
	private String LinkMail;
	//电话
	private String LinkMobile;
	//联系人姓名
	private String LinkName;
	//备注
	private String LinkDesc;
	
	private String buyingNum;
	//下单用游客信息
	
	private String pName;//游客姓名
	private String pType;//游客类型
	private String pSex;//游客性别
	private String pIdtype;//证件类型
	private String pIdNo;//证件号码
	private String pMobile;//电话
	
	
	private long buyingid;
	//团购list
	private List<Buying>ListBuying;
	private List<Buyingimg>ListBuyingimg;
	private Buying buying=new Buying();
	private Spotlineorder spotlineorder=new Spotlineorder();
	private long OrderID;
	
	public BuyingAction() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		endDate = sdf.format(calendar.getTime());
		
	}
	
	public String Seachbuying(){
		
		String where=" WHERE 1=1 ";
		//ListSpotmes=Server.getInstance().getTripService().findAllSpotmes(where, " ORDER BY ID ", 10, 0);
		if(CityID!=null&&CityID.trim().length()>0){
			
			
			where +=" AND "+Buying.COL_cityid+" ='"+CityID.trim()+"'";
		}
		if(SeachName!=null&&SeachName.trim().length()>0){
			
			where +=" AND ( "+Buying.COL_name+" like '%"+SeachName.trim()+"%' OR "+Buying.COL_address+" like '%"+SeachName.trim()+"%' )";
		}
		
		pageinfo.setPagerow(5);
		List list = Server.getInstance().getTripService()
			.findAllBuyingForPageinfo(where.toString(), " ORDER BY ID DESC ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		ListBuying = list;
		
		if(pageinfo.getTotalrow()>0 &&   ListBuying.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllBuyingForPageinfo(where.toString()," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			ListBuying = list;
		}
		
		return "tolist";
	}
	
	public String tobuyingInfo(){
		buying=Server.getInstance().getTripService().findBuying(buyingid);
		ListBuyingimg=Server.getInstance().getTripService().findAllBuyingimg(" where 1=1 and "+Buyingimg.COL_buyingid+" ="+buyingid, "", -1, 0);
		return "toinfo";
	}
	public String tobook(){
		
		if(getLoginUser()==null){
			//未登录时，保存当前参数，跳转至登录页面
			ActionContext.getContext().getSession().put("BuyingParam",buyingid);
			ActionContext.getContext().getSession().put("pageUrl","buying!tobook.jspx?buyingid="+buyingid);
		
			return "toLogin";// 从新登陆
		}else{
			
			if(ActionContext.getContext().getSession().get("BuyingParam")!=null)
			{
				long SpotLineParam=Long.parseLong(ActionContext.getContext().getSession().get("BuyingParam").toString());
				System.out.println("SpotLineParam=="+SpotLineParam);
				
				if(buyingid==0){
					buyingid=SpotLineParam;
				}
				
				
			}
		}
		
		
		
		
		buying=Server.getInstance().getTripService().findBuying(buyingid);
		ListBuyingimg=Server.getInstance().getTripService().findAllBuyingimg(" where 1=1 and "+Buyingimg.COL_buyingid+" ="+buyingid, "", -1, 0);
		return "tobook";
	}
	public String createOrder(){
		System.out.println("createorder:"+buyingid);
		buying=Server.getInstance().getTripService().findBuying(buyingid);
		spotlineorder=new Spotlineorder();
		spotlineorder.setSpotlineid(buyingid+"");
		spotlineorder.setLinkemail(LinkMail);
		spotlineorder.setLinkname(LinkName);
		spotlineorder.setLinktel(LinkMobile);
		spotlineorder.setMemberid(getLoginUser().getId());
		spotlineorder.setBeizhu(LinkDesc);
		spotlineorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		//spotlineorder.setStime(spotline.getStime());
		if(buying.getCityid()!=null){
		spotlineorder.setCityid(buying.getCityid()+"");
		}
		if(buying.getPid()!=null){
		spotlineorder.setProvineid(buying.getPid()+"");
		}
		spotlineorder.setName(buying.getName());
		spotlineorder.setPaystate(0l);//0未支付  1已支付
		spotlineorder.setState(0l);//0新订单 1已确认 2已完成 3已取消
		spotlineorder.setPrice(price);
		spotlineorder.setSnum(buyingNum);
		spotlineorder.setParam1("buying");
		try {
			spotlineorder=Server.getInstance().getTripService().createSpotlineorder(spotlineorder);
			spotlineorder.setOrderno("B"+(spotlineorder.getId()+10000));
			Server.getInstance().getTripService().updateSpotlineorderIgnoreNull(spotlineorder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("createorder:"+spotlineorder.getOrderno());
		
		forword="buying!toShowOrder.jspx?OrderID="+spotlineorder.getId();
		System.out.println("forword:"+forword);
		return "toorder";
	}
	public String toShowOrder(){
		System.out.println("toShowOrder:"+OrderID);
		spotlineorder=Server.getInstance().getTripService().findSpotlineorder(OrderID);
		
		if(spotlineorder!=null&&spotlineorder.getMemberid()!=null&&spotlineorder.getMemberid()==getLoginUser().getId()){
			
			return "toShowOrder";
		}
		
		return "toERR";
	}
    public Float GetYouFei(String price1,String price2){
		
		
		return Float.parseFloat(price1)-Float.parseFloat(price2);
	}

	public String ShowHTML(String info,String type){
		System.out.println(type);
		String htmlStr = info; //含html标签的字符串 
        String textStr =""; 
        
        java.util.regex.Pattern p_script; 
        java.util.regex.Matcher m_script; 
        java.util.regex.Pattern p_style; 
        java.util.regex.Matcher m_style; 
        java.util.regex.Pattern p_html; 
        java.util.regex.Matcher m_html; 
     


		 try { 
	           String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> } 
	           String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> } 
	              String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式 
	          
	              p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
	              m_script = p_script.matcher(htmlStr); 
	              htmlStr = m_script.replaceAll(""); //过滤script标签 

	              p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
	              m_style = p_style.matcher(htmlStr); 
	              htmlStr = m_style.replaceAll(""); //过滤style标签 
	          
	              p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
	              m_html = p_html.matcher(htmlStr); 
	              htmlStr = m_html.replaceAll(""); //过滤html标签 
	          
	           textStr = htmlStr; 
	          
	          }catch(Exception e) { 
	                   System.err.println("Html2Text: " + e.getMessage()); 
	          } 

	          if(type.equals("list")){
	        	  
	        	  System.err.println(textStr);
	      		return textStr;
	          }else{
	        	  
	        	  return info.replaceAll("/uploads", "http://www.bzezt.com/uploads");
	          }
		
		//return info.replaceAll("/uploads", "http://www.bzezt.com/uploads");
	}
	
	/**
	 * AJAX读取酒店城市
	 * 
	 * @throws
	 */
	public void GetSpotCity() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere = "WHERE 1=1 and " + Spotcity.COL_parentid+ " in ( select "+Spotcity.COL_id+" from "+Spotcity.TABLE+" where "+Spotcity.COL_parentid+" =1)";
	
		List<Spotcity> listSpotcity = Server.getInstance().getTripService()
				.findAllSpotcity(strwhere, "ORDER BY ID ", -1, 0);
		for (Spotcity airPort : listSpotcity) {
			sb.append(airPort.getName() + "#" + CnToSpell.getFullSpell(airPort.getName()) + "%"
					+ CnToSpell.getFullSpell(airPort.getName()) + "&" + airPort.getId() + ",");
		}
		// return strRetData;
		System.out.println("SB=" + sb);
		out.print(sb);
		out.flush();
		out.close();
		
	}

	
	/**
	 * AJAX读取线路推荐信息 2013-08-20 陈星
	 * 
	 * @throws
	 */
	public void GetSpotmesByCityid() throws Exception {
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		StringBuilder sber = new StringBuilder();
		String where=" where 1=1 ";
		if(CityID!=null&&CityID.trim().length()>0){
		//where+=	" and "+Spotmes.COL_cityid+" ='"+CityID+"'";
		}
		List<Spotline>ListSpotline=Server.getInstance().getTripService().findAllSpotline(where, " ORDER BY ID DESC ", 18, 0);
		int size=ListSpotline.size();
		sber.append("<div class='box content'>");
		for(int a=0;a<ListSpotline.size();a++){
			if((a+1)<size){
				sber.append("<ul class='box_botm_xu'>");
				}else{
					
				sber.append("<ul class=' mt7'>");	
				}
		
		sber.append("<li>");
		//sber.append("<span class='f'>("+(a+1)+").</span>");
		//sber.append("<img width='50' height='40' src='http://www.bzezt.com/uploads/"+ListSpotmes.get(a).getMinipics()+"' />");
		sber.append("<a href='spotline!toSpotLineInfo.jspx?SpotLineID="+ListSpotline.get(a).getId()+"&startDate="+startDate+"'>"+ListSpotline.get(a).getName()+"</a>");
		sber.append("<font class='r font_f60_c'></font>");//起价
		sber.append("<div class='c'></div>");
		sber.append("</li>");
		
		if((a+1)<size){
		sber.append("<div class='nohave6 c'>&nbsp;</div>");
		}else{
			
			
			
		}
		sber.append("</ul>");
		}
		sber.append("</div>");
		
		Writer writer = response.getWriter();
		writer.write(sber.toString());
		writer.flush();
		writer.close();
	}
	
	/**
	 * 团购首页
	 */
	public String execute() {

		return "index";
	}
	
	
	

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCityID() {
		return CityID;
	}

	public void setCityID(String cityID) {
		CityID = cityID;
	}

	public String getSeachName() {
		return SeachName;
	}

	public void setSeachName(String seachName) {
		SeachName = seachName;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLinkMail() {
		return LinkMail;
	}

	public void setLinkMail(String linkMail) {
		LinkMail = linkMail;
	}

	public String getLinkMobile() {
		return LinkMobile;
	}

	public void setLinkMobile(String linkMobile) {
		LinkMobile = linkMobile;
	}

	public String getLinkName() {
		return LinkName;
	}

	public void setLinkName(String linkName) {
		LinkName = linkName;
	}

	public String getLinkDesc() {
		return LinkDesc;
	}

	public void setLinkDesc(String linkDesc) {
		LinkDesc = linkDesc;
	}



	public String getBuyingNum() {
		return buyingNum;
	}

	public void setBuyingNum(String buyingNum) {
		this.buyingNum = buyingNum;
	}

	public Spotlineorder getSpotlineorder() {
		return spotlineorder;
	}

	public void setSpotlineorder(Spotlineorder spotlineorder) {
		this.spotlineorder = spotlineorder;
	}

	public long getOrderID() {
		return OrderID;
	}

	public void setOrderID(long orderID) {
		OrderID = orderID;
	}

	public String getPName() {
		return pName;
	}

	public void setPName(String name) {
		pName = name;
	}

	public String getPType() {
		return pType;
	}

	public void setPType(String type) {
		pType = type;
	}

	public String getPSex() {
		return pSex;
	}

	public void setPSex(String sex) {
		pSex = sex;
	}

	public String getPIdtype() {
		return pIdtype;
	}

	public void setPIdtype(String idtype) {
		pIdtype = idtype;
	}

	public String getPIdNo() {
		return pIdNo;
	}

	public void setPIdNo(String idNo) {
		pIdNo = idNo;
	}

	public String getPMobile() {
		return pMobile;
	}

	public void setPMobile(String mobile) {
		pMobile = mobile;
	}

	public List<Buying> getListBuying() {
		return ListBuying;
	}

	public void setListBuying(List<Buying> listBuying) {
		ListBuying = listBuying;
	}

	public long getBuyingid() {
		return buyingid;
	}

	public void setBuyingid(long buyingid) {
		this.buyingid = buyingid;
	}

	public List<Buyingimg> getListBuyingimg() {
		return ListBuyingimg;
	}

	public void setListBuyingimg(List<Buyingimg> listBuyingimg) {
		ListBuyingimg = listBuyingimg;
	}

	public Buying getBuying() {
		return buying;
	}

	public void setBuying(Buying buying) {
		this.buying = buying;
	}

}