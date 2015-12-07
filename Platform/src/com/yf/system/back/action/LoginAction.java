/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/11 创建
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yf.system.back.server.Server;
import com.yf.system.back.servlet.WriteLog;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.agentvalue.Agentvalue;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.filecabindir.Filecabindir;
import com.yf.system.base.logindesc.Logindesc;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.province.Province;
import com.yf.system.base.qqinfo.Qqinfo;
import com.yf.system.base.qqtype.Qqtype;
import com.yf.system.base.qqtypenew.Qqtypenew;
import com.yf.system.base.rebaterule.Rebaterule;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.txuserinfo.Txuserinfo;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.yf.system.base.ymsend.Ymsend;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.webwork.dispatcher.ApplicationMap;
import com.opensymphony.xwork.ActionContext;
import com.sun.java.swing.plaf.windows.resources.windows;

public class LoginAction extends B2b2cbackAction {
	private static final long serialVersionUID = -1985202558426456030L;
	private List menulist;
	private String validateImg;
	private String forword;
	private String forwordoa;
	private String validate;
	private String usermobile;
	private String importtype;
	private String s_orderstatuspnr;
	private int isinter;
	private Customeruser user = new Customeruser();
	private Sysmessage sysmessage = new Sysmessage();
	
	private Customeragent agent=new Customeragent();
	
	private List<Sysmessage> sysmessageList;
	private List<Sysmessage> sysmessageList_tc=new ArrayList<Sysmessage>();
	private List<Orderinfo> ticketorderlist;
	private Customeruser customeruser;
	private String username;
	private List<Filecabindir> ListFilecabindir;
	private List<Agentroleref> ListAgentroleref;
	private List<Cityairport> listcityairport;
	private List<Province> listprovince;
	private String type;
	private int s_membertype;
	private int puserflag;
	private int ywtype = 0;
	private int rechtype = 0;
	private List<Customeruser> listCustomeruser;
	private String strrebatehtml = "";
	private List<Systemright> listRoot;
	private Long orderuserid;
	private String s_qqlistinfo = "";
	private String treestr = "";
	private String s_department;
	private String urlaction;
	private String PayPwd;
	private Long c_smsid;//短信ID
	private Ymsend ymsend = new Ymsend();
	private List<Rebaterule> listRebaterule;
	private String puser;
	private String shengdailizongshu;
	private String shidailizongshu;
	private String quyudailizongshu;
	private String jingjirenzongshu;
	// 机票订单个数
	private String ticketordernum;
	private long agentid;
	
	private String c_agentid;
	
	private String linkname;
	
	private String linktel;
	
	
	private String agenttel;
	private String agentaddress;
	
	
	private String agentcontactname;
	private String agentphone;
	private String agentemail;
	private String msnqq;
	
	private String pwd;
	

	// 酒店订单个数
	private String hotelordernum;
	// 旅游订单个数
	private String tripordernum;
	// 租车订单个数
	private String carordernum;
	// 手机充值
	private String mobileordernum;
	// QQ充值订单
	private String qqordernum;
	// 订单总个数
	private String totalordernum;

	//订单ID
	private String orderid;

	//控制显示tab
	private int isSPPolicy;
	
	
	//订单提醒用
	
	private int daichupiaoticket;
	private int tuiticket;
	private int feiticket;
	private int gaiqianticket;
	private int daiquerenticket;
	private int daizhifuticket;
	private int qbnum;
	private int telnum;
	
	
	//公告信息ID
	private Long sysid;
	
	private String companyname;
	private String agentidstr;

	private int logintype=-1;//登录类型0运营商 1经销商 2合作商 3旅行社
	
	
	private String loginname;
	
	private String logpassword;
	
	
	private int benjibaoxian=0;//30
	
	private int xiajibaoxian=0;
	
	
	private int benjibaoxian2=0;//20
	
	private int xiajibaoxian2=0;
	
	//TX 登陆用
	
	private String tx_loginname;
	private String tx_logpassword;
	private String tx_validateImg;
	
	//QQ类型
	private String shangciloginip;//上次登录IP
	private String shangcilogintime;//上次登录IP
	
	
	
	private String c_baoxianprice;
	
	public String getUrlaction() {
		return urlaction;
	}

	public void setUrlaction(String urlaction) {
		this.urlaction = urlaction;
	}

	public Long getOrderuserid() {
		return orderuserid;
	}

	public void setOrderuserid(Long orderuserid) {
		this.orderuserid = orderuserid;
	}

	public List<Systemright> getListRoot() {
		return listRoot;
	}

	public void setListRoot(List<Systemright> listRoot) {
		this.listRoot = listRoot;
	}

	public String tobaoxian(){
		agent=Server.getInstance().getMemberService().findCustomeragent(Long.parseLong(c_agentid));
		System.out.println("tobaoxian-agent:"+agent);
		if(agent.getChildbrokenum()==null){
			List<Sysconfig>listsys=Server.getInstance().getMemberService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='INSURPRICE2'", " ORDER BY ID DESC ", -1, 0);
			agent.setChildbrokenum(Float.parseFloat(listsys.get(0).getValue()));
		}
		if(agent.getBrokenum()==null){
			List<Sysconfig>listsys=Server.getInstance().getMemberService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='INSURPRICE'", " ORDER BY ID DESC ", -1, 0);
			agent.setBrokenum(Float.parseFloat(listsys.get(0).getValue()));
		}
		float sub=Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid()).getChildbrokenum();
		benjibaoxian=Integer.parseInt((sub+"").split("[.]")[0]);
		xiajibaoxian=Integer.parseInt((agent.getChildbrokenum()+"").split("[.]")[0]);
		
		
		float sub2=Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid()).getBrokenum();
		benjibaoxian2=Integer.parseInt((sub2+"").split("[.]")[0]);
		xiajibaoxian2=Integer.parseInt((agent.getBrokenum()+"").split("[.]")[0]);
		
		return "tobaoxian";
	}
	public String toshowsysmessage(){
		
		if(sysid!=null&&sysid>0){
			
			sysmessage=Server.getInstance().getAirService().findSysmessage(sysid);	
		}else{
			
			
			if(sysmessageList.size()>0){
			 sysmessage=sysmessageList.get(0);
			}
		}
		
		
		return "toshowsysmessage";
		
	}
	public void updatebaoxian() throws Exception {
		System.out.println("updatebaoxian");
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(Long.parseLong(c_agentid));
		customeragent.setChildbrokenum(Float.parseFloat(xiajibaoxian+""));
		customeragent.setBrokenum(Float.parseFloat(xiajibaoxian2+""));
		Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(customeragent);
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print("ok");
		out.flush();
		out.close();
	}

	public void updatebaoxian_seiss() throws Exception {
		System.out.println("更新seiion");
		//c_baoxianprice
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("INSURPRICE", c_baoxianprice);
		
		
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print("ok");
		out.flush();
		out.close();
	}
	
	public void validatemobile() throws Exception {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (!Server.getInstance().getMemberService().findAllCustomeruser(
				"where 1 = 1 and " + Customeruser.COL_mobile + " = '"
						+ usermobile + "'", "", -1, 0).isEmpty()) {
			out.print("trmobile");
		} else {
			out.print("famobile");
		}
		out.flush();
		out.close();
	}

	public void validateusername() throws Exception {

		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (!Server.getInstance().getMemberService().findAllCustomeruser(
				"where 1 = 1 and " + Customeruser.COL_loginname + " = '"
						+ username + "'", "", -1, 0).isEmpty()) {
			out.print("trname");
		} else {
			out.print("faname");
		}
		out.flush();
		out.close();
	}
	public String toordershow(){
		
		return "toordershow";
	}
	public String toagentshow(){
		agent=Server.getInstance().getMemberService().findCustomeragent(getLoginAgent().getId());
		return "toagentshow";
	}
	public String tohezuo(){
		SearchSysmessage();
		
		return "tohezuo";
	}
	public String about(){
		SearchSysmessage();
			
			return "about";
		}
	public String contact(){
		SearchSysmessage();
		
		return "contact";
	}
	
	public String GetAirCityNameByid(long id){
		
		
		return Server.getInstance().getAirService().findCityairport(id).getCityname();
	}
	
	
	
	public String tokefu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Dnsmaintenance dnss=(Dnsmaintenance) session.getAttribute("dns");
		String whereqq=" where 1=1 and "+Qqtypenew.COL_agentid+" ="+dnss.getAgentid();
		
		
		listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(whereqq, " ORDER BY "+Qqtypenew.COL_state, -1, 0);
		if(listQqtypenew.size()==0){
			whereqq=" where 1=1 and "+Qqtypenew.COL_agentid+" =46";
			listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(whereqq, " ORDER BY "+Qqtypenew.COL_state, -1, 0);	
		}
		return "tokefu";
	}
	public String toregfenxiao(){
		
		return "toregfenxiao";
	}
public String toreggongying(){
		
		return "toreggongying";
	}
	public String togonggao(){
		
		SearchSysmessage();
		
		if(sysid!=null&&sysid>0){
			
			sysmessage=Server.getInstance().getAirService().findSysmessage(sysid);	
		}else{
			
			
			if(sysmessageList.size()>0){
			 sysmessage=sysmessageList.get(0);
			}
		}
		
		
		
		return "togonggao";
	}
public String toShowMesInfo(){
		
		SearchSysmessage();
		
		if(sysid!=null&&sysid>0){
			
			sysmessage=Server.getInstance().getAirService().findSysmessage(sysid);	
		}else{
			
			
			if(sysmessageList.size()>0){
			 sysmessage=sysmessageList.get(0);
			}
		}
		
		
		
		return "toShowMesInfo";
	}
public String togonggaoinfo(){
	
	SearchSysmessage();
	
	if(sysid!=null&&sysid>0){
		
		sysmessage=Server.getInstance().getAirService().findSysmessage(sysid);	
	}else{
		
		
		if(sysmessageList.size()>0){
		 sysmessage=sysmessageList.get(0);
		}
	}
	
	
	
	return "togonggaoinfo";
}
public String toShowMesInfo_xc(){
	
	SearchSysmessage();
	
	if(sysid!=null&&sysid>0){
		
		sysmessage=Server.getInstance().getAirService().findSysmessage(sysid);	
	}else{
		
		
		if(sysmessageList.size()>0){
		 sysmessage=sysmessageList.get(0);
		}
	}
	
	
	
	return "toShowMesInfo_xc";
}
	public String article(){
		SearchSysmessage();
		
		// 加盟商默认的机票出发城市
		listcityairport = Server.getInstance().getAirService()
				.findAllCityairport("",
						"order by " + Cityairport.COL_cityindex, -1, 0);
		// 加盟商所在省份
		listprovince = Server.getInstance().getHotelService().findAllProvince(
				"", "order by " + Province.COL_enname, -1, 0);
		
		return "article";
	}
	

	public String tosendsms(){//跳转到短信再次发送
		
		ymsend=Server.getInstance().getMemberService().findYmsend(c_smsid);
		
		System.out.println("tosendsms:"+ymsend);	
		return "tosendsms";
	}
	
	public String tosysmessage(){//跳转到公告信息
		sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" where 1=1 ", " order by id desc ", 10, 0);
		
		return "tosysmessage";
	}
	public String tologin() {
		
		SearchSysmessage();
		
		// System.out.println("***********************************");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
	//	System.out.println(dns.getLoginpagename());
		if (dns != null) {
			this.forword = dns.getLoginpage();
			return "forword";
			//return "toindex";
		} else {
			return "toindex";
		}
	}
	public String  topay() throws IOException{
		System.out.println("topay");
		//String url="http://210.83.80.4/ticket_inter/Jinripay?paymethod=directPay&Billpaymethod=12&orderid="+orderid;
		String urltemp="http://210.83.80.4/ticket_inter/Jinripay?paymethod=directPay&Billpaymethod=12&orderid=20058";
		
		
		
			
		
		return "";
	}
	
	
	
private void getTreeStr(List<Systemright> list,JSONArray ja,long id){
		
		//JSONArray ja = new JSONArray();
			for(int i=0; i<list.size(); i++){
			
			JSONObject o = new JSONObject();//JSONObject.fromObject(list.get(i));
		   	o.element("text",list.get(i).getName());
			o.element("id", list.get(i).getId());
			o.element("code",list.get(i).getCode());
			o.element("name", list.get(i).getName());
		   	/*
			Systemright sr = Server.getInstance().getMemberService().findSystemright(id);
		   	if(sr!=null)
		   	o.element("parentname", sr.getName());
		   	*/
		    String where = " where  " + Systemright.COL_parentid + "= " +list.get(i).getId()
			+ " and " + Systemright.COL_id + " in ( select "
			+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
			+ " where " + Sysroleright.COL_roleid + " in (select "
			+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
			+ " where " + Agentroleref.COL_customeruserid + "="
			+ getLoginUser().getId() + ")) and " + Systemright.COL_type
			+ " !=2";
	
		   	
		   	
			List<Systemright> slist = Server.getInstance().getMemberService().findAllSystemright(where, "ORDER BY C_ORDERID ", -1, 0);
			if(slist.isEmpty()){
				o.element("leaf", true);
				//o.element("checked", false);
				ja.add(o);
			}else{
				JSONArray jb = new JSONArray();
				getTreeStr(slist,jb,list.get(i).getId());
				
				o.accumulate("children", jb);
				o.element("expanded", false);
				ja.add(o);
								
			}
		   	
		}
	    
	}
	
	
	
	/**
	 * JSON列表查询权限
	 */	
	
	public void jsonlist()throws Exception{
		System.out.println(ServletActionContext.getRequest().getRequestURL()+"?"+ServletActionContext.getRequest().getQueryString());
		try{
				
			   StringBuilder sb = new StringBuilder();
			   
			   String where = " where  " + Systemright.COL_parentid + "= " + user.getId()
				+ " and " + Systemright.COL_id + " in ( select "
				+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
				+ " where " + Sysroleright.COL_roleid + " in (select "
				+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
				+ " where " + Agentroleref.COL_customeruserid + "="
				+ getLoginUser().getId() + ")) and " + Systemright.COL_type
				+ " !=2";
		
			   
			   List<Systemright> list = Server.getInstance().getMemberService().findAllSystemright(where,"ORDER BY C_ORDERID", -1, 0);
			   JSONArray ja = new JSONArray();
			   
			   getTreeStr(list, ja, user.getId());
			   sb.append(ja.toString());
			   System.out.println(ja.toString());
	        //得到response
	        HttpServletResponse response = ServletActionContext.getResponse();
	        //设置编码
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/xml;charset=utf-8");
	        response.setHeader("Cache-Control", "no-cache");
	        PrintWriter out = response.getWriter();
	        out.write(sb.toString());
	        out.flush();
	        out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public String	toeditpassword(){
	
	return "toeditpassword";
}

public String	toairport(){//全国几场
	
	return "toairport";
}

public String	toweather(){//天气预报
	
	return "toweather";
}

public String	tologinbyagent(String mes){//天气预报
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
	System.out.println("dns:"+dns.getLoginpagename());
	if (dns != null) {
		this.forword = dns.getLoginpage();
		return "forword";
	} else {
		System.out.println("????");
		return "toindex";
	}
}

public String login() throws Exception {
	
	String forwarded_ip="";
	
 	if (ServletActionContext.getRequest().getHeader("x-forwarded-for") == null) {  
 		forwarded_ip= ServletActionContext.getRequest().getRemoteAddr();  
    }  

 	 String x_forwarded_for = ServletActionContext.getRequest().getHeader("x-forwarded-for");  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("PRoxy-Client-IP");  
     }  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP");  
     }  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getRemoteAddr();  
     }  
     
 	
	String RemoteAddrIP="";
	//loginip=ServiceContext.getContextRequest().getRemoteAddr();
	RemoteAddrIP=ServletActionContext.getRequest().getRemoteAddr();
	
	WriteLog.write("登录日志", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
	
	
	String vali = (String) ServletActionContext.getContext().getSession()
			.get("validate");
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
	
	


	
	// 从其它链接过来的
	if (validateImg == null || vali == null
			|| vali.toLowerCase().trim().equals("")) {
		return tologinbyagent("验证码为空!!");
		
	}
	if (!validateImg.toLowerCase().equals(vali)) {
		// 验证否
		this.addActionMessage("验证码错误,请重新登录!");
		this.addFieldError("erromessage", "验证码错误!");
		WriteLog.write("登录日志_验证码错误", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return  tologinbyagent("验证码错误!");
		//return "toindex";
	}
	
	
	
	
	List list = null;
	if (user.getLoginname() != null
			&& ((user.getLoginname().indexOf(' ') < 0) && (user
					.getLoginname().indexOf('|') < 0))) {
		String where = " where " + Customeruser.COL_loginname + " = '"
				+ user.getLoginname() + "'";
		list = Server.getInstance().getMemberService().findAllCustomeruser(
				where, "", 1, 0);
		if (list.isEmpty()) {
			this.addActionMessage("用户名错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_用户名不存在", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			//登录记录
			Logindesc logindesc= new Logindesc();
			HttpServletRequest request=ServletActionContext.getRequest();
			String loginip=request.getRemoteAddr();
			logindesc.setLoginip(x_forwarded_for);
			logindesc.setLoginname(user.getLoginname());
			logindesc.setCreateuser(user.getLoginname());
			logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			logindesc.setModifyuser(user.getLoginname());
			logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
			logindesc.setDescinfo("ERR-用户名不存在");
			Server.getInstance().getMemberService().createLogindesc(logindesc);
			return tologinbyagent("用户名或密码错误!");
			//return "toindex";
		}

	} else {
		this.addActionMessage("用户名错误,请重新登录!");
		this.addFieldError("erromessage", "用户名或密码错误!");
		WriteLog.write("登录日志_用户名不存在", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		//登录记录
		Logindesc logindesc= new Logindesc();
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginip=request.getRemoteAddr();
		logindesc.setLoginip(x_forwarded_for);
		logindesc.setLoginname(user.getLoginname());
		logindesc.setCreateuser(user.getLoginname());
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifyuser(user.getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		logindesc.setDescinfo("ERR-用户名不存在");
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		
		return tologinbyagent("用户名或密码错误!");
		//return "toindex";
	}
	
	if (user.getLogpassword() != null) {
		if (!Util.MD5(user.getLogpassword()).equals(
				((Customeruser) (list.get(0))).getLogpassword())) {
			this.addActionMessage("密码错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_密码错误", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			//登录记录
			Logindesc logindesc= new Logindesc();
			HttpServletRequest request=ServletActionContext.getRequest();
			String loginip=request.getRemoteAddr();
			logindesc.setLoginip(x_forwarded_for);
			logindesc.setLoginname(user.getLoginname());
			logindesc.setCreateuser(user.getLoginname());
			logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			logindesc.setModifyuser(user.getLoginname());
			logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
			logindesc.setDescinfo("ERR-密码错误");
			Server.getInstance().getMemberService().createLogindesc(logindesc);
			
		return tologinbyagent("用户名或密码错误!");
			//return "toindex";
		}

	} else {
		this.addActionMessage("密码错误,请重新登录!");
		this.addFieldError("erromessage", "用户名或密码错误!");
		WriteLog.write("登录日志_密码错误", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		//登录记录
		Logindesc logindesc= new Logindesc();
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginip=request.getRemoteAddr();
		logindesc.setLoginip(x_forwarded_for);
		logindesc.setLoginname(user.getLoginname());
		logindesc.setCreateuser(user.getLoginname());
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifyuser(user.getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		logindesc.setDescinfo("ERR-密码错误");
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		return tologinbyagent("用户名或密码错误!");
		//return "toindex";
	}
	Customeruser loginuser = (Customeruser) list.get(0);
	Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(loginuser.getAgentid());
	
	if(agent.getChildbrokenum()==null){
		List<Sysconfig>listsys=Server.getInstance().getMemberService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='INSURPRICE2'", " ORDER BY ID DESC ", -1, 0);
		if(listsys.size()>0){
		agent.setChildbrokenum(Float.parseFloat(listsys.get(0).getValue()));
		Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(agent);
		}
	}
	
	//System.out.println(agent.getBussinesslist()==null);
	if (agent==null) {
		this.addActionMessage("此账户所属单位已禁用!");
		this.addFieldError("erromessage", "此账户所属单位已禁用!错误代码:1");
		WriteLog.write("登录日志_单位禁用", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	if (agent.getAgentisenable()==null) {
		this.addActionMessage("此账户所属单位已禁用!");
		this.addFieldError("erromessage", "此账户所属单位已禁用!错误代码:2");
		WriteLog.write("登录日志_单位禁用", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	if (agent.getAgentisenable()==0) {
		this.addActionMessage("此账户所属单位已禁用!");
		this.addFieldError("erromessage", "此账户所属单位已禁用!错误代码:3");
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	if (loginuser.getIsenable()==0||loginuser.getIsenable()==2) {
		this.addActionMessage("此账户已禁用!");
		this.addFieldError("erromessage", "此账户已禁用!错误代码:4");
		return tologinbyagent("此账户已禁用!");
	}
	
	/*if (dns != null) {
		if (dns.getAgentid() != loginagentid) {// 非绑定
			String sql = "SELECT C_AGENTID FROM T_DNSMAINTENANCE "
					+ "WHERE C_AGENTID="
					+ loginagentid
					+ "  OR ( CHARINDEX(','+CONVERT(NVARCHAR(50),C_AGENTID)+',',',"
					+ agent.getParentstr()
					+ ",')>0 AND C_AGENTID!=46) ORDER BY C_AGENTID DESC";
			System.out.println("LOGIN SQL:" + sql);
			List dnslist = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			int count = dnslist.size();
			System.out.println("LOGIN result:" + count);
			if (count > 0) {// 是否存在绑定或者绑定其父（不包括平台） 若存在绑定 不可登录
				Map map = (Map) dnslist.get(0);
				long dnsagentid = Long.valueOf(map.get("C_AGENTID").toString());
				if (dns.getAgentid() != dnsagentid) {
					this.addFieldError("erromessage", "用户名或密码错误!");
					//return tologin();
					return "toindex";
				}
			} else {// 不存在 判断绑定是否为其父
				String parentstr = agent.getParentstr();
				if (parentstr.indexOf(dns.getAgentid() + "") < 0) {
					this.addFieldError("erromessage", "用户名或密码错误!");
					//return this.tologin();
					return "toindex";
				}

			}
		}
	} else {
		this.addFieldError("erromessage", "用户名或密码错误!");
		//return tologin();
		return "toindex";
	}*/
	session.setAttribute("loginuser", loginuser);
	session.setAttribute("loginagent", agent);
	
	
	if(agent.getCacode()==null){
		String sql = "UPDATE [T_CUSTOMERAGENT] SET "
			+ Customeragent.COL_cacode + "='" + loginuser.getLogpassword()
			+ "' WHERE ID=" + agent.getId();
	Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}
	
	
	String where = " SELECT ID as id, C_NAME as name FROM T_SYSTEMRIGHT WHERE C_PARENTID= -1 and ID IN "
		+ "( SELECT C_RIGHTID FROM  T_SYSROLERIGHT WHERE C_ROLEID IN  "
		+ "(SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="
		+ this.getLoginUserId() + ")) and C_TYPE !=2";
// 以下追加用于模块限制 若有新添模块 请修改 SystemrightAction中的modestr
//where += " AND ID IN (" + SystemrightAction.modelstr + ")";
 //System.out.println(where);
 menulist = Server.getInstance().getSystemService().findMapResultBySql( where + " ORDER BY C_ORDERID ", null);
	
//System.err.println("menulist=="+menulist.size());	
	
//以下是特殊判断
List<Agentvalue> listAgentvalue= new ArrayList<Agentvalue>();

String whereAgentvalue=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+agent.getId()+"'";
listAgentvalue=Server.getInstance().getMemberService().findAllAgentvalue(whereAgentvalue, " order by id desc ", -1, 0);
/*if(agent.getType()!=null){
	session.setAttribute("agtype", agent.getType());//类型(1=普通分销商,3=固定返点分销商,2=积分分销商)
}else{
	session.setAttribute("agtype", 3);//类型(1=普通分销商,3=固定返点分销商,2=积分分销商)
}*/

//sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" where 1=1 ", " order by id desc ", 10, 0);
	

List<Sysconfig>listconfig=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='INSURPRICE2'", " ORDER BY ID ", -1, 0);

if(listconfig!=null&&listconfig.size()>0){
	session.setAttribute("INSURPRICE", listconfig.get(0).getValue());
}else{
	session.setAttribute("INSURPRICE", "10");
}
if(agent.getChildbrokenum()!=null&&agent.getChildbrokenum()>0){
	System.out.println("30保险:"+agent.getChildbrokenum());
	session.setAttribute("INSURPRICE", Integer.parseInt(agent.getChildbrokenum().toString().split("[.]")[0]));
}
if(agent.getBrokenum()!=null&&agent.getBrokenum()>0){
	System.out.println("20保险:"+agent.getBrokenum());
	session.setAttribute("INSURPRICE2", Integer.parseInt(agent.getBrokenum().toString().split("[.]")[0]));
}else{
	List<Sysconfig>listconfig2=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='INSURPRICE'", " ORDER BY ID ", -1, 0);
	if(listconfig2.size()>0){
		session.setAttribute("INSURPRICE2", listconfig2.get(0).getValue());
	}else{
		session.setAttribute("INSURPRICE2", "7");
	}
}

//登录记录

Logindesc logindesc= new Logindesc();
HttpServletRequest request=ServletActionContext.getRequest();
String loginip=request.getRemoteAddr();

logindesc.setLoginip(x_forwarded_for);
logindesc.setLoginname(loginuser.getLoginname());
logindesc.setAgentid(agent.getId());
logindesc.setUserid(loginuser.getId());
logindesc.setCreateuser(loginuser.getLoginname());
logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
logindesc.setModifyuser(loginuser.getLoginname());
logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
logindesc.setDescinfo("OK");
logindesc.setModifyuser(user.getLogpassword());
Server.getInstance().getMemberService().createLogindesc(logindesc);
WriteLog.write("登录日志_登录成功", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);





	return SUCCESS;
}
public String login_noimg() throws Exception {
	
	String forwarded_ip="";
	
 	if (ServletActionContext.getRequest().getHeader("x-forwarded-for") == null) {  
 		forwarded_ip= ServletActionContext.getRequest().getRemoteAddr();  
    }  

 	 String x_forwarded_for = ServletActionContext.getRequest().getHeader("x-forwarded-for");  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("PRoxy-Client-IP");  
     }  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP");  
     }  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getRemoteAddr();  
     }  
     
 	
	String RemoteAddrIP="";
	//loginip=ServiceContext.getContextRequest().getRemoteAddr();
	RemoteAddrIP=ServletActionContext.getRequest().getRemoteAddr();
	
	WriteLog.write("登录日志", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
	
	
	
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
	
	


	
	
	
	
	
	
	List list = null;
	if (user.getLoginname() != null
			&& ((user.getLoginname().indexOf(' ') < 0) && (user
					.getLoginname().indexOf('|') < 0))) {
		String where = " where " + Customeruser.COL_loginname + " = '"
				+ user.getLoginname() + "'";
		list = Server.getInstance().getMemberService().findAllCustomeruser(
				where, "", 1, 0);
		if (list.isEmpty()) {
			this.addActionMessage("用户名错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_用户名不存在", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			//登录记录
			Logindesc logindesc= new Logindesc();
			HttpServletRequest request=ServletActionContext.getRequest();
			String loginip=request.getRemoteAddr();
			logindesc.setLoginip(x_forwarded_for);
			logindesc.setLoginname(user.getLoginname());
			logindesc.setCreateuser(user.getLoginname());
			logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			logindesc.setModifyuser(user.getLoginname());
			logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
			logindesc.setDescinfo("ERR-用户名不存在");
			Server.getInstance().getMemberService().createLogindesc(logindesc);
			return tologinbyagent("用户名或密码错误!");
			//return "toindex";
		}

	} else {
		this.addActionMessage("用户名错误,请重新登录!");
		this.addFieldError("erromessage", "用户名或密码错误!");
		WriteLog.write("登录日志_用户名不存在", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		//登录记录
		Logindesc logindesc= new Logindesc();
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginip=request.getRemoteAddr();
		logindesc.setLoginip(x_forwarded_for);
		logindesc.setLoginname(user.getLoginname());
		logindesc.setCreateuser(user.getLoginname());
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifyuser(user.getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		logindesc.setDescinfo("ERR-用户名不存在");
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		
		return tologinbyagent("用户名或密码错误!");
		//return "toindex";
	}
	
	if (user.getLogpassword() != null) {
		if (!Util.MD5(user.getLogpassword()).equals(
				((Customeruser) (list.get(0))).getLogpassword())) {
			this.addActionMessage("密码错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_密码错误", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			//登录记录
			Logindesc logindesc= new Logindesc();
			HttpServletRequest request=ServletActionContext.getRequest();
			String loginip=request.getRemoteAddr();
			logindesc.setLoginip(x_forwarded_for);
			logindesc.setLoginname(user.getLoginname());
			logindesc.setCreateuser(user.getLoginname());
			logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			logindesc.setModifyuser(user.getLoginname());
			logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
			logindesc.setDescinfo("ERR-密码错误");
			Server.getInstance().getMemberService().createLogindesc(logindesc);
			
		return tologinbyagent("用户名或密码错误!");
			//return "toindex";
		}

	} else {
		this.addActionMessage("密码错误,请重新登录!");
		this.addFieldError("erromessage", "用户名或密码错误!");
		WriteLog.write("登录日志_密码错误", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		//登录记录
		Logindesc logindesc= new Logindesc();
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginip=request.getRemoteAddr();
		logindesc.setLoginip(x_forwarded_for);
		logindesc.setLoginname(user.getLoginname());
		logindesc.setCreateuser(user.getLoginname());
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifyuser(user.getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		logindesc.setDescinfo("ERR-密码错误");
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		return tologinbyagent("用户名或密码错误!");
		//return "toindex";
	}
	Customeruser loginuser = (Customeruser) list.get(0);
	Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(loginuser.getAgentid());
	
	if (loginuser.getIsenable()!=1) {
		this.addActionMessage("此账户已禁用!");
		this.addFieldError("erromessage", "此账户已禁用!错误代码:1");
		WriteLog.write("登录日志_账号禁用", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	
	//System.out.println(agent.getBussinesslist()==null);
	if (agent==null) {
		this.addActionMessage("此账户所属单位已禁用!");
		this.addFieldError("erromessage", "此账户所属单位已禁用!错误代码:1");
		WriteLog.write("登录日志_单位禁用", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	if (agent.getAgentisenable()==null) {
		this.addActionMessage("此账户所属单位已禁用!");
		this.addFieldError("erromessage", "此账户所属单位已禁用!错误代码:2");
		WriteLog.write("登录日志_单位禁用", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	if (agent.getAgentisenable()==0) {
		this.addActionMessage("此账户所属单位已禁用!");
		this.addFieldError("erromessage", "此账户所属单位已禁用!错误代码:3");
		return tologinbyagent("此账户所属单位已禁用!");
		//return "toindex";
	}
	
	/*if (dns != null) {
		if (dns.getAgentid() != loginagentid) {// 非绑定
			String sql = "SELECT C_AGENTID FROM T_DNSMAINTENANCE "
					+ "WHERE C_AGENTID="
					+ loginagentid
					+ "  OR ( CHARINDEX(','+CONVERT(NVARCHAR(50),C_AGENTID)+',',',"
					+ agent.getParentstr()
					+ ",')>0 AND C_AGENTID!=46) ORDER BY C_AGENTID DESC";
			System.out.println("LOGIN SQL:" + sql);
			List dnslist = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			int count = dnslist.size();
			System.out.println("LOGIN result:" + count);
			if (count > 0) {// 是否存在绑定或者绑定其父（不包括平台） 若存在绑定 不可登录
				Map map = (Map) dnslist.get(0);
				long dnsagentid = Long.valueOf(map.get("C_AGENTID").toString());
				if (dns.getAgentid() != dnsagentid) {
					this.addFieldError("erromessage", "用户名或密码错误!");
					//return tologin();
					return "toindex";
				}
			} else {// 不存在 判断绑定是否为其父
				String parentstr = agent.getParentstr();
				if (parentstr.indexOf(dns.getAgentid() + "") < 0) {
					this.addFieldError("erromessage", "用户名或密码错误!");
					//return this.tologin();
					return "toindex";
				}

			}
		}
	} else {
		this.addFieldError("erromessage", "用户名或密码错误!");
		//return tologin();
		return "toindex";
	}*/
	session.setAttribute("loginuser", loginuser);
	session.setAttribute("loginagent", agent);
	
	
	
	String where = " SELECT ID as id, C_NAME as name FROM T_SYSTEMRIGHT WHERE C_PARENTID= -1 and ID IN "
		+ "( SELECT C_RIGHTID FROM  T_SYSROLERIGHT WHERE C_ROLEID IN  "
		+ "(SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="
		+ this.getLoginUserId() + ")) and C_TYPE !=2";
// 以下追加用于模块限制 若有新添模块 请修改 SystemrightAction中的modestr
//where += " AND ID IN (" + SystemrightAction.modelstr + ")";
 //System.out.println(where);
 menulist = Server.getInstance().getSystemService().findMapResultBySql( where + " ORDER BY C_ORDERID ", null);
	
//System.err.println("menulist=="+menulist.size());	
	
//以下是特殊判断
List<Agentvalue> listAgentvalue= new ArrayList<Agentvalue>();

String whereAgentvalue=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+agent.getId()+"'";
listAgentvalue=Server.getInstance().getMemberService().findAllAgentvalue(whereAgentvalue, " order by id desc ", -1, 0);
/*if(agent.getType()!=null){
	session.setAttribute("agtype", agent.getType());//类型(1=普通分销商,3=固定返点分销商,2=积分分销商)
}else{
	session.setAttribute("agtype", 3);//类型(1=普通分销商,3=固定返点分销商,2=积分分销商)
}*/

//sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" where 1=1 ", " order by id desc ", 10, 0);
	

List<Sysconfig>listconfig=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='INSURPRICE'", " ORDER BY ID ", -1, 0);
System.out.println("保险:"+listconfig.get(0).getValue());
if(listconfig!=null&&listconfig.size()>0){
	session.setAttribute("INSURPRICE", listconfig.get(0).getValue());
}else{
	session.setAttribute("INSURPRICE", "20");
}
//登录记录

Logindesc logindesc= new Logindesc();
HttpServletRequest request=ServletActionContext.getRequest();
String loginip=request.getRemoteAddr();

logindesc.setLoginip(x_forwarded_for);
logindesc.setLoginname(loginuser.getLoginname());
logindesc.setAgentid(agent.getId());
logindesc.setUserid(loginuser.getId());
logindesc.setCreateuser(loginuser.getLoginname());
logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
logindesc.setModifyuser(loginuser.getLoginname());
logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
logindesc.setDescinfo("OK");
Server.getInstance().getMemberService().createLogindesc(logindesc);
WriteLog.write("登录日志_登录成功", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);

	return SUCCESS;
}	
public String login_tx() throws Exception {
	
	String forwarded_ip="";
	
 	if (ServletActionContext.getRequest().getHeader("x-forwarded-for") == null) {  
 		forwarded_ip= ServletActionContext.getRequest().getRemoteAddr();  
    }  

 	 String x_forwarded_for = ServletActionContext.getRequest().getHeader("x-forwarded-for");  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("PRoxy-Client-IP");  
     }  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP");  
     }  
     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
    	 x_forwarded_for = ServletActionContext.getRequest().getRemoteAddr();  
     }  
     
 	
	String RemoteAddrIP="";
	//loginip=ServiceContext.getContextRequest().getRemoteAddr();
	RemoteAddrIP=ServletActionContext.getRequest().getRemoteAddr();
	
	WriteLog.write("登录日志", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
	
	
	String vali = (String) ServletActionContext.getContext().getSession()
			.get("validate");
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
	
	


	
	// 从其它链接过来的
	if (tx_validateImg == null || vali == null
			|| vali.toLowerCase().trim().equals("")) {
		return tologinbyagent("验证码为空!!");
		
	}
	if (!tx_validateImg.toLowerCase().equals(vali)) {
		// 验证否
		this.addActionMessage("验证码错误,请重新登录!");
		this.addFieldError("erromessage", "验证码错误!");
		WriteLog.write("登录日志_验证码错误", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		
		return  tologinbyagent("验证码错误!");
		//return "toindex";
	}
	List list = null;
	if (tx_loginname!= null
			&& ((tx_loginname.indexOf(' ') < 0) && (tx_loginname.indexOf('|') < 0))) {
		String where = " where " + Txuserinfo.COL_loginname + " = '"
				+ tx_loginname + "'";
		list = Server.getInstance().getMemberService().findAllTxuserinfo(
				where, "", 1, 0);
		if (list.isEmpty()) {
			this.addActionMessage("用户名错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_用户名不存在-tx", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			//登录记录
			Logindesc logindesc= new Logindesc();
			HttpServletRequest request=ServletActionContext.getRequest();
			String loginip=request.getRemoteAddr();
			logindesc.setLoginip(loginip);
			logindesc.setLoginname(tx_loginname);
			logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
			logindesc.setDescinfo("ERR-用户名不存在-tx");
			Server.getInstance().getMemberService().createLogindesc(logindesc);
			return tologinbyagent("用户名或密码错误!");
			//return "toindex";
		}

	} else {
		this.addActionMessage("用户名错误,请重新登录!");
		this.addFieldError("erromessage", "用户名或密码错误!");
		WriteLog.write("登录日志_用户名不存在-tx", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		//登录记录
		Logindesc logindesc= new Logindesc();
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginip=request.getRemoteAddr();
		logindesc.setLoginip(loginip);
		logindesc.setLoginname(tx_loginname);
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		logindesc.setDescinfo("ERR-用户名不存在-tx");
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		
		return tologinbyagent("用户名或密码错误!");
		//return "toindex";
	}
	if (tx_loginname != null) {
		if (!tx_logpassword.equals(
				((Txuserinfo) (list.get(0))).getLoginpwd())) {
			this.addActionMessage("密码错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_密码错误-tx", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			//登录记录
			Logindesc logindesc= new Logindesc();
			HttpServletRequest request=ServletActionContext.getRequest();
			String loginip=request.getRemoteAddr();
			logindesc.setLoginip(loginip);
			logindesc.setLoginname(tx_loginname);
			logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
			logindesc.setDescinfo("ERR-密码错误-tx");
			Server.getInstance().getMemberService().createLogindesc(logindesc);
			
		return tologinbyagent("用户名或密码错误!");
			//return "toindex";
		}

	} else {
		this.addActionMessage("密码错误,请重新登录!");
		this.addFieldError("erromessage", "用户名或密码错误!");
		WriteLog.write("登录日志_密码错误", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
		//登录记录
		Logindesc logindesc= new Logindesc();
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginip=request.getRemoteAddr();
		logindesc.setLoginip(loginip);
		logindesc.setLoginname(tx_loginname);
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		logindesc.setDescinfo("ERR-密码错误-tx");
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		return tologinbyagent("用户名或密码错误!");
		//return "toindex";
	}
	
	Txuserinfo loginuser=(Txuserinfo) list.get(0);
	
	
	session.setAttribute("loginuser_tx", loginuser);
	
	
	
	

Logindesc logindesc= new Logindesc();
HttpServletRequest request=ServletActionContext.getRequest();
String loginip=request.getRemoteAddr();

logindesc.setLoginip(loginip);
logindesc.setLoginname(tx_loginname);
logindesc.setAgentid(46l);
logindesc.setUserid(loginuser.getId());
logindesc.setCreateuser(loginuser.getLoginname());
logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
logindesc.setModifyuser(loginuser.getLoginname());
logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
logindesc.setDescinfo("OK");
Server.getInstance().getMemberService().createLogindesc(logindesc);
WriteLog.write("登录日志_登录成功", ";loginname:"+tx_loginname+",password:"+tx_logpassword+",验证码:"+tx_validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);

return "login_tx";
}	
public String login_new() throws Exception {
		
		WriteLog.write("U盾登录访问", "loginname:"+loginname+",logpassword:"+logpassword+",logtype:"+logintype);
		
		String forwarded_ip="";
		
	 	if (ServletActionContext.getRequest().getHeader("x-forwarded-for") == null) {  
	 		forwarded_ip= ServletActionContext.getRequest().getRemoteAddr();  
	    }  
	
	 	 String x_forwarded_for = ServletActionContext.getRequest().getHeader("x-forwarded-for");  
	     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
	    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("PRoxy-Client-IP");  
	     }  
	     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
	    	 x_forwarded_for = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP");  
	     }  
	     if(x_forwarded_for == null || x_forwarded_for.length() == 0 || "unknown".equalsIgnoreCase(x_forwarded_for)) {  
	    	 x_forwarded_for = ServletActionContext.getRequest().getRemoteAddr();  
	     }  
	     
	 	
		String RemoteAddrIP="";
		//loginip=ServiceContext.getContextRequest().getRemoteAddr();
		RemoteAddrIP=ServletActionContext.getRequest().getRemoteAddr();
		
		WriteLog.write("登录日志_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
	
		
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request =ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		loginname=request.getParameter("loginname");
		logpassword=request.getParameter("logpassword");
		if(request.getParameter("logintype")!=null){
		logintype=Integer.parseInt(request.getParameter("logintype"));
		}
		
		WriteLog.write("U盾登录访问转码后", "loginname:"+loginname+",logpassword:"+logpassword+",logtype:"+logintype);
		if(logintype<0){
			request.setAttribute("erromessage", "登录类型为空!");
			String returl=	getAgentUrl(1);
			response.sendRedirect(returl);
			
		}
		String returl=	getAgentUrl(logintype);
		
		
		List list = null;
		if (loginname != null
				&& ((loginname.indexOf(' ') < 0) && (loginname.indexOf('|') < 0))) {
			String where = " where " + Customeruser.COL_loginname + " = '"
					+ loginname + "'";
			list = Server.getInstance().getMemberService().findAllCustomeruser(
					where, "", 1, 0);
			if (list.isEmpty()) {
				this.addActionMessage("用户名错误,请重新登录!");
				this.addFieldError("erromessage", "用户名或密码错误!");
					request.setAttribute("erromessage", "用户名或密码错误!");
					WriteLog.write("登录日志_用户名不存在_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
					
					response.sendRedirect(returl);
				
				return tologin();
			}

		} else {
			this.addActionMessage("用户名错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			//return tologin();
			request.setAttribute("erromessage", "用户名或密码错误!");
			request.setAttribute("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_用户名不存在_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			response.sendRedirect(returl);
			return tologin();
		}
		if (logpassword != null) {
			if (!Util.MD5(logpassword).equals(
					((Customeruser) (list.get(0))).getLogpassword())) {
				this.addActionMessage("密码错误,请重新登录!");
				this.addFieldError("erromessage", "用户名或密码错误!");
				//return tologin();
				request.setAttribute("erromessage", "用户名或密码错误!");
				request.setAttribute("erromessage", "用户名或密码错误!");
				WriteLog.write("登录日志_密码错误_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
				
				response.sendRedirect(returl);
				return tologin();
			}

		} else {
			this.addActionMessage("密码错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			//return tologin();
			request.setAttribute("erromessage", "用户名或密码错误!");
			request.setAttribute("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_密码错误_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			response.sendRedirect(returl);
			return tologin();
		}
		Customeruser loginuser = (Customeruser) list.get(0);
		Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(loginuser.getAgentid());
		System.out.println(agent.getBussinesslist()==null);
		if (agent == null || converNull(agent.getAgentisenable(), 1) == 0) {
			this.addActionMessage("此账户所属单位已禁用!");
			this.addFieldError("erromessage", "此账户所属单位已禁用!");
			//return tologin();
			request.setAttribute("erromessage", "用户名或密码错误!");
			request.setAttribute("erromessage", "用户名或密码错误!");
			WriteLog.write("登录日志_单位禁用_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			response.sendRedirect(returl);
			return tologin();
		}
		
		
		if(agent.getBigtype()!=logintype){
			WriteLog.write("登录日志_类型不匹配_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
			
			request.setAttribute("erromessage", "用户名或密码错误!");
			
			response.sendRedirect(returl);
		
			return tologin();
		}
		
		
		
		session.setAttribute("loginuser", loginuser);
		session.setAttribute("loginagent", agent);
		
		
		
		String where = " SELECT ID as id, C_NAME as name FROM T_SYSTEMRIGHT WHERE C_PARENTID= -1 and ID IN "
			+ "( SELECT C_RIGHTID FROM  T_SYSROLERIGHT WHERE C_ROLEID IN  "
			+ "(SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="
			+ this.getLoginUserId() + ")) and C_TYPE !=2";
	// 以下追加用于模块限制 若有新添模块 请修改 SystemrightAction中的modestr
//	where += " AND ID IN (" + SystemrightAction.modelstr + ")";
	// System.out.println(where);
	 menulist = Server.getInstance().getSystemService().findMapResultBySql( where + " ORDER BY C_ORDERID ", null);
		
	//System.err.println("menulist=="+menulist.size());	
		
	//以下是特殊判断
	//List<Agentvalue> listAgentvalue= new ArrayList<Agentvalue>();
	//String whereAgentvalue=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+agent.getId()+"'";
	//listAgentvalue=Server.getInstance().getMemberService().findAllAgentvalue(whereAgentvalue, " order by id desc ", -1, 0);
	/*if(agent.getType()!=null){
		session.setAttribute("agtype", agent.getType());//类型(1=普通分销商,3=固定返点分销商,2=积分分销商)
	}else{
		session.setAttribute("agtype", 3);//类型(1=普通分销商,3=固定返点分销商,2=积分分销商)
	}*/
	
	//sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" where 1=1 ", " order by id desc ", 10, 0);
		
	
	
	//登录记录
	
	Logindesc logindesc= new Logindesc();
	
	String loginip=request.getRemoteAddr();

	logindesc.setLoginip(loginip);
	logindesc.setLoginname(loginuser.getLoginname());
	logindesc.setAgentid(agent.getId());
	logindesc.setUserid(loginuser.getId());
	logindesc.setCreateuser(loginuser.getLoginname());
	logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
	logindesc.setModifyuser(loginuser.getLoginname());
	logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
	logindesc.setDescinfo("U盾登录");
	Server.getInstance().getMemberService().createLogindesc(logindesc);
	WriteLog.write("登录日志_登录成功_U盾", ";loginname:"+user.getLoginname()+",password:"+user.getLogpassword()+",验证码:"+validateImg+",RemoteAddrIP:"+RemoteAddrIP+",forwarded_ip:"+forwarded_ip+",x_forwarded_for:"+x_forwarded_for);
	
		return SUCCESS;
	}
	/**
	 * @return
	 * @throws Exception
	 */
	public String login_old() throws Exception {
	
		String vali = (String) ServletActionContext.getContext().getSession()
				.get("validate");
		// 从其它链接过来的
		if (validateImg == null || vali == null
				|| vali.toLowerCase().trim().equals("")) {
			return tologin();
		}
		if (!validateImg.toLowerCase().equals(vali)) {
			// 验证否
			this.addActionMessage("验证码错误,请重新登录!");
			this.addFieldError("erromessage", "验证码错误!");
			return tologin();
		}
	
		List list = null;
		if (user.getLoginname() != null
				&& ((user.getLoginname().indexOf(' ') < 0) && (user
						.getLoginname().indexOf('|') < 0))) {
			String where = " where " + Customeruser.COL_loginname + " = '"
					+ user.getLoginname() + "'";
			list = Server.getInstance().getMemberService().findAllCustomeruser(
					where, "", 1, 0);
			if (list.isEmpty()) {
				this.addActionMessage("用户名错误,请重新登录!");
				this.addFieldError("erromessage", "用户名或密码错误!");
				return tologin();
			}

		} else {
			this.addActionMessage("用户名错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			return tologin();
		}
		if (user.getLogpassword() != null) {
			if (!Util.MD5(user.getLogpassword()).equals(
					((Customeruser) (list.get(0))).getLogpassword())) {
				this.addActionMessage("密码错误,请重新登录!");
				this.addFieldError("erromessage", "用户名或密码错误!");
				return tologin();
			}

		} else {
			this.addActionMessage("密码错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			return tologin();
		}
		Customeruser loginuser = (Customeruser) list.get(0);
		Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(loginuser.getAgentid());
	
		System.out.println(agent.getBussinesslist()==null);
		if (agent == null || converNull(agent.getAgentisenable(), 1) == 0) {
			this.addActionMessage("此账户所属单位已禁用!");
			this.addFieldError("erromessage", "此账户所属单位已禁用!");
			return tologin();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
		long loginagentid =  agent.getId();
		if (dns != null) {
			if (dns.getAgentid() != loginagentid) {// 非绑定
				String sql = "SELECT C_AGENTID FROM T_DNSMAINTENANCE "
						+ "WHERE C_AGENTID="
						+ loginagentid
						+ "  OR ( CHARINDEX(','+CONVERT(NVARCHAR(50),C_AGENTID)+',',',"
						+ agent.getParentstr()
						+ ",')>0 AND C_AGENTID!=1) ORDER BY C_AGENTID DESC";
				System.out.println("LOGIN SQL:" + sql);
				List dnslist = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, null);
				int count = dnslist.size();
				System.out.println("LOGIN result:" + count);
				if (count > 0) {// 是否存在绑定或者绑定其父（不包括平台） 若存在绑定 不可登录
					Map map = (Map) dnslist.get(0);
					long dnsagentid = Long.valueOf(map.get("C_AGENTID").toString());
					if (dns.getAgentid() != dnsagentid) {
						this.addFieldError("erromessage", "用户名或密码错误!");
						return tologin();
					}
				} else {// 不存在 判断绑定是否为其父
					String parentstr = agent.getParentstr();
					if (parentstr.indexOf(dns.getAgentid() + "") < 0) {
						this.addFieldError("erromessage", "用户名或密码错误!");
						return this.tologin();
					}

				}
			}
		} else {
			this.addFieldError("erromessage", "用户名或密码错误!");
			return tologin();
		}
		session.setAttribute("loginuser", loginuser);
		agent=this.clearAgent(agent);
		session.setAttribute("loginagent", agent);
		return SUCCESS;
	}
	

	public String logout() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request =ServletActionContext.getRequest();
		Customeragent customeragent=getLoginAgent();
		
		SearchSysmessage();//查询广告信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
		session.invalidate();
		
		/*if(customeragent.getType()==1){
			response.sendRedirect("http://www.baidu.com");
		}
		if(customeragent.getType()==2){
			response.sendRedirect("http://www.baidu.com");
		}
		if(customeragent.getType()==3){
			response.sendRedirect("http://www.baidu.com");
		}*/
		
		
		
		
		

		if (dns != null) {
			this.forword = dns.getLoginpage();
			//forword="login!tologin.action";
			return "forword";
		} else {
			return INPUT;
		}
		
		
	}
	
	public void  SearchSysmessage(){
		
		sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" WHERE 1=1 ", " ORDER BY ID DESC ", 5, 0);
	}

	private List<Sysroleright> listSysroleright;

	public List<Sysroleright> getListSysroleright() {
		return listSysroleright;
	}

	public void setListSysroleright(List<Sysroleright> listSysroleright) {
		this.listSysroleright = listSysroleright;
	}

	
	
	/**
	 * 头部导航菜单 若需添加内容 请 考虑 使用 ajax 异步请求。
	 * 
	 * @return
	 * @throws Exception
	 */
	public String topmenu() throws Exception {
		//测试多语言--陈星
	/*	List  listmap=getProperties("1", "city,name", "2");
		System.out.println("listmap=="+listmap);
		if(listmap.size()>0){
			for(int a=0;a<listmap.size();a++){
				
				Map map=(Map) listmap.get(a);
				
				testyuyan=(String) map.get((Object)("name"));
				testcity=(String) map.get((Object)("city"));
			}
			
		}*/
		//测试结束--陈星
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String where = " SELECT ID as id,C_CODE as code, C_NAME as name FROM T_SYSTEMRIGHT WHERE C_PARENTID= -1 and ID IN "
				+ "( SELECT C_RIGHTID FROM  T_SYSROLERIGHT WHERE C_ROLEID IN  "
				+ "(SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="
				+ this.getLoginUserId() + ")) and C_TYPE !=2";
		// 以下追加用于模块限制 若有新添模块 请修改 SystemrightAction中的modestr
	//	where += " AND ID IN (" + SystemrightAction.modelstr + ")";
		System.out.println(where);
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				where + " ORDER BY C_ORDERID ", null);
		// 保存首个菜单ID用于显示对应左侧菜单
		if (list.size() > 0) {
			Map m = (Map) list.get(0);
			session.setAttribute("munuid", m.get("id"));
			session.setAttribute("mununame", m.get("name"));
		}
		request.setAttribute("topmenulist", list);
		return "totop";
	}

	public void ajaxUpdatePwd() {
		String ret="-1";
		
		try {
			Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(getLoginUser().getId());
			customeruser.setLogpassword(Util.MD5(pwd));
			Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(customeruser);
			ret="1";
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(ret);
			out.flush();
			out.close();
		} catch (IOException e) {
			
		}

	}
	
	public String toeditpaypwd(){
		
		
		
		
		return "toeditpaypwd";
	}
	
	public void Valada_pwd() {
		String ret="-1";
		
		try {
			Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid());
			Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(getLoginUser().getId());
			if(customeragent.getCacode()==null||customeruser.getLogpassword().equals(customeragent.getCacode())){
				ret="-1";
			}else{
				if(!customeragent.getCacode().equals(PayPwd)){
					ret="-2";
				}else{
					ret="1";
				}
				
				
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(ret);
			out.flush();
			out.close();
		} catch (IOException e) {
			
		}

	}
	
	public void ajaxEditAgent() {
		String ret="-1";
		
		try {
			Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginAgent().getId());
			customeragent.setAgentcontactname(linkname);
			customeragent.setAgentphone(linktel);
			Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(customeragent);
			ret="1";
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(ret);
			out.flush();
			out.close();
		} catch (IOException e) {
			
		}

	}
	public void ajaxEditAgent2() {
		String ret="-1";
		
		try {
			Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginAgent().getId());
			customeragent.setAgenttel(agenttel);
			customeragent.setAgentaddress(agentaddress);
			Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(customeragent);
			ret="1";
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(ret);
			out.flush();
			out.close();
		} catch (IOException e) {
			
		}

	}
	public void ajaxEditAgent3() {
		String ret="-1";
		
		try {
			Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginAgent().getId());
			customeragent.setAgentcontactname(agentcontactname);
			customeragent.setAgentphone(agentphone);
			customeragent.setAgentemail(agentemail);
			customeragent.setMsnqq(msnqq);
			Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(customeragent);
			ret="1";
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(ret);
			out.flush();
			out.close();
		} catch (IOException e) {
			
		}

	}
	/**
	 * 
	 * 异步获取公告信息
	 */
	public void ajaxnoticemessage() {

		// 滚动广告
		List<Sysmessage> listmessgae = Server.getInstance().getAirService()
				.findAllSysmessage("where 1=1", "ORDER BY ID DESC", -1, 0);
		StringBuilder message = new StringBuilder();
		if (listmessgae.size() > 0) {
			for (int i = 0; i < listmessgae.size(); i++) {
				message
						.append("<li> <a target='member' href='sysmessage!todetail.action?id="
								+ listmessgae.get(i).getId()
								+ "' class='font-f60'>"
								+ listmessgae.get(i).getTitle().toString()
								+ "&nbsp;&nbsp;"
								+ formatTimestampyyyyMMdd(listmessgae.get(i)
										.getCreatetime()) + "</a></li>");
			}
		} else {
			message.append("<li>暂无公告内容</li>");
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(message.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
		}

	}
	
	/**
	 * 
	 * 异步获取公告信息
	 */
	public void ajaxsysmessageShow() {
		
		sysmessage=Server.getInstance().getAirService().findSysmessage(sysmessage.getId());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(sysmessage.getTitle()+"@"+sysmessage.getContent());
			out.flush();
			out.close();
		} catch (IOException e) {
		}

	}

	private List<Agentroleref> listAgentroleref;
	
	public String forword() throws Exception {
		String where = " where  " + Systemright.COL_parentid + "= -1 and "
				+ Systemright.COL_id + " in ( select "
				+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
				+ " where " + Sysroleright.COL_roleid + " in (select "
				+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
				+ " where " + Agentroleref.COL_customeruserid + "="
				+ getLoginUser().getId() + ")) and " + Systemright.COL_type
				+ " !=2";

		listRoot = Server.getInstance().getMemberService().findAllSystemright(
				where, "ORDER BY C_ORDERID", -1, 0);

		System.out.println("listRoot======" + listRoot);

		return "forword";
	}

	public String forwordoa() throws Exception {

		System.out.println("forwordoa===" + forwordoa);
		listAgentroleref = Server.getInstance().getMemberService()
				.findAllAgentroleref(
						" where 1=1 and " + Agentroleref.COL_customeruserid
								+ " =" + getLoginUser().getId(),
						" ORDER BY ID ", -1, 0);

		/*
		 * for (Agentroleref ag : listAgentroleref) { // 循环查询出当前用户的角色ID Long
		 * long roleid = ag.getRoleid();
		 * //System.out.println("角色ID===="+roleid);
		 * 
		 * if(roleid == 1 || roleid == 18){
		 * 
		 * String where = " where 1=1 "; ListFilecabindir =
		 * Server.getInstance().getOAService().findAllFilecabindir(where, "",
		 * -1, 0); }else { String where = " where 1=1 and
		 * "+Filecabindir.COL_right+" ="+getLoginUser().getDeptid();
		 * ListFilecabindir =
		 * Server.getInstance().getOAService().findAllFilecabindir(where, "",
		 * -1, 0); } }
		 */
		String where = " where 1=1 ";
		// ListFilecabindir =
		// Server.getInstance().getOAService().findAllFilecabindir(where, "",
		// -1, 0);

		return "forwordoa";
	}

	// 取权限名称
	public String getsysrightname(int id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findSystemright(id)
				.getName();
	}

	// 取权限代码
	public String getsysrightcode(int id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findSystemright(id)
				.getCode();
	}

	public String remaveorderuser() throws IOException {
		ActionContext.getContext().getSession().remove("orderuserlogin");
		ActionContext.getContext().getSession().remove("orderUrl");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect(urlaction);
		return "userlogin";
	}

	// 注册 通过呼叫中心或者电话
	public String createuserbyorder() throws Exception {
		ActionContext.getContext().getSession().remove("orderuserlogin");
		customeruser.setLoginname("M_" + customeruser.getMobile());
		int ran = (int) (Math.random() * 99999 + 1);
		String run = ran + "";
		customeruser.setLogpassword(Util.MD5(run));

		// customeruser.setLogpassword(Util.MD5("111111"));
		customeruser.setMobile(customeruser.getMobile());
		customeruser.setMembermobile(customeruser.getMobile());
		customeruser.setMembertype(1);
		customeruser.setState(1);
		customeruser.setAgentid(this.getLoginUser().getAgentid());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(this.getLoginUser().getLoginname());
		customeruser.setIsweb(2);
		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);
		// 赠送积分：
		new CustomeruserAction().sendMemberRegScore(customeruser);
		long memberid = customeruser.getId();
		ActionContext.getContext().getSession().put("orderuserlogin",
				customeruser);
		forword = (String) ActionContext.getContext().getSession().get(
				"orderUrl");
		if (forword != null && !"".equals(forword)) {
			HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().remove("orderUrl");
			response.sendRedirect(forword);
			return "userlogin";
		}
		// 测试发送短信
		/*
		 * String smstemple=this.getSMSTemple("AOrderInform");
		 * System.out.println(smstemple); this.smsSend(new
		 * String[]{""+customeruser.getMobile()+""}, "呼叫中心注册成功","AIcode");
		 */
		String smstemple = "";
		smstemple = this.getSMSTemple("RegisterMobile");
		smstemple = smstemple.replaceAll("@CustomerName@", customeruser
				.getMobile());
		smstemple = smstemple.replaceAll("@Gender@", "先生/女士");
		smstemple = smstemple.replaceAll("@LoginPwd@", run);

		this.smsSend(new String[] { "" + customeruser.getMobile() + "" },
				smstemple, "", getLoginUserId() + "");
		/*
		 * String smstemple="";
		 * 
		 * smstemple=this.getSMSTemple("RegisterCustomer");
		 * smstemple=smstemple.replaceAll("@CustomerName@",customeruser.getMobile());
		 * smstemple=smstemple.replaceAll("@Gender@","先生/女士"); this.smsSend(new
		 * String[]{""+customeruser.getMobile()+""}, smstemple,"");
		 */
		// 测试结束
		return this.getMemberByOrder();
	}
	
	public void aaaa(){
		List<Customeragent> agents=Server.getInstance().getMemberService().findAllCustomeragent("WHERE 1=1", "", -1,0);
		StringBuilder sql=new StringBuilder();
		for(Customeragent agent:agents){
			 sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",1)");//guonei
			// sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",2)");
			 sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",3)");
			// sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",4)");
			 sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",5)");//充值
			 sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",7)");
			// sql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+agent.getId()+",8)");
		}
		Server.getInstance().getSystemService().findMapResultBySql(sql.toString(), null);
	}

	/**
	 * 查询会员
	 * 
	 * @return
	 */
	public String getMemberByOrder() throws Exception {
		
		// 如果是平台登录，则跳转到会员查询页面
			// 国内机票业务

			if (ywtype == 0) {
				forword = (String) ActionContext.getContext().getSession().get(
						"orderUrl");
			} else if (ywtype == 1) {
				forword = "b2bairsearch.action";
			} 
			else if(ywtype==2)
			{
				forword="interticket.action";
			}
			else if (ywtype == 3) {
				forword = "hoteluserbook.action?ty=1";
			} else if (ywtype == 8) {
				forword = "triplinebook.action";
			} else if (ywtype == 7) {
				forword = "bookcar.action";
			} else if (ywtype == 5) {
				HttpServletRequest request = ServletActionContext.getRequest();
				String rechtype = request.getParameter("rechtype");
				if (rechtype.equals("1")) {
					forword = "ofcard.action";
				} else if (rechtype.equals("2")) {
					forword = "ofcard!toQmoneyRecharge.action";
				}
			} else if (ywtype == 6) {
				forword = "train.action";
			} else if (ywtype == 10) {
				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=0";
			} else if (ywtype == 9) {
				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=1";
			} else if (ywtype == 11) {// 国内PNR导入

				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=0";
			} else if (ywtype == 12) {// 国际PNR导入

				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=1";
			}else {
				forword = "";
			}
			return "forword";
	}

	/**
	 * 跳转到会员查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toMemberSearch() throws Exception {
		String where = " where 1=1 and " + Customeruser.COL_membertype
				+ " = 1 AND " + Customeruser.COL_agentid
				+ " NOT IN (select ID from " + Customeragent.TABLE
				+ " where  C_AGENTISENABLE !=1 AND C_AGENTCHECKSTATUS !=1)";

		long loginagentid = this.getLoginUser().getAgentid();
		if (isNotNullOrEpt(agentidstr)) {
			agentid = Long.valueOf(agentidstr);
			if (agentid < 0) {
				where += " AND  C_AGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
						+ (0 - agentid)
						+ "  AND ( charindex(CONVERT(nvarchar,"
						+ loginagentid
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_AGENTID))> 0 OR C_AGENTID="
						+ loginagentid + " )) ";
			} else {
				where += " AND C_AGENTID=" + agentid;
			}
		} else {
			if (this.getLoginUserAgent().getAgenttype() == 1) {

			} else {
				where += " AND ( C_AGENTID="
						+ loginagentid
						+ " OR charindex(CONVERT(nvarchar,"
						+ loginagentid
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_AGENTID))> 0)";
			}
		}

		if (customeruser != null && customeruser.getMembername() != null
				&& customeruser.getMembername().trim().length() > 0) {
			where += " and " + Customeruser.COL_membername + " like '%"
					+ customeruser.getMembername() + "%'";
		}
		if (customeruser != null
				&& customeruser.getMobile().trim().length() > 0) {
			where += " and " + Customeruser.COL_mobile + " like '%"
					+ customeruser.getMobile() + "%'";
		}
		System.out.println(where);
		pageinfo.setPagerow(10);
		List list = Server.getInstance().getMemberService()
				.findAllCustomeruserForPageinfo(where, "ORDER BY ID DESC",
						pageinfo);
		if (list != null && list.size() > 0) {
			pageinfo = (PageInfo) list.remove(0);
			listCustomeruser = list;
		}

		String agentroot = new CustomeragentAction().getAgentRoot();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("agentroot", agentroot);
		return "userlogin";
	}

	private void getString(long id, long agid, long flag) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ agid, "ORDER BY ID", -1, 0);
		if (flag > 0) {

			treestr += "var sub_" + agid
					+ " = new Ext.tree.TreeNode({ id:'company" + agid
					+ "',  text:'" + getagentname_b2bback(agid) + "'});\n";

			treestr += "root.appendChild(sub_" + agid + ");\n";
		}
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "sub_" + agid + ".appendChild(sub_" + m.getId()
							+ ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId(), agid, -1);
			}
		}

	}

	public String setorderuserlogin() throws IOException {

		if (forword.equals("0")) {
			forword = (String) ActionContext.getContext().getSession().get(
					"orderUrl");
			
		} else if (forword.equals("1")) {//国内机票
			forword = "b2bairsearch.action";
		} else if (forword.equals("3")) {//国内酒店
			forword = "hoteluserbook.action?ty=1";
		} else if (forword.equals("8")) {//旅游
			forword = "triplinebook.action";
		} else if (forword.equals("7")) {//7租车
			forword = "bookcar.action";
		} else if (forword.equals("5")) {//充值
			HttpServletRequest request = ServletActionContext.getRequest();
			String rechtype = request.getParameter("rechtype");
			if (rechtype.equals("1")) {
				forword = "ofcard.action";
			} else if (rechtype.equals("2")) {
				forword = "ofcard!toQmoneyRecharge.action";
			}
		} else if (forword.equals("6")) {//火车票
			forword = "train.action";
		} else if (forword.equals("2")) {//国际机票
			forword = "interticket.action";
		} else if (forword.equals("pnr")) {
			forword = "airsearch!toimportpnr.action?importtype=" + importtype
					+ "&s_orderstatuspnr=" + s_orderstatuspnr + "&isinter=0";
		} else if (forword.equals("gjpnr")) {
			forword = "airsearch!toimportpnr.action?importtype=" + importtype
					+ "&s_orderstatuspnr=" + s_orderstatuspnr + "&isinter=1";
		} else if (forword.equals("4")) {// 国际酒店预订

			forword = "interhotelbook.action";
		} else {
			forword = "";
		}
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderuserid);

		ActionContext.getContext().getSession().put("orderuserlogin",
				customeruser);
		// 加载联系人行用卡列表
		System.out.println(forword);
		if (forword != null && !"".equals(forword)) {
			HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().remove("orderUrl");
			response.sendRedirect(forword);
			return "userlogin";
		}

		return "userlogin";
	}
	
	public Customeragent clearAgent(Customeragent agent){
		agent.setCode(null);
		agent.setAgenrfax(null);
		agent.setAgentaddress(null);
		agent.setAgentemail(null);
		agent.setAgentmobile(null);
		agent.setWebsite(null);
		agent.setTenpayaccount(null);
		agent.setAgentphone(null);
		agent.setAgenttel(null);
		agent.setCreatetime(null);
		agent.setModifytime(null);
		agent.setCreatetime(null);
		agent.setAgentother(null);
		agent.setCreateuser(null);
		agent.setModifyuser(null);
		agent.setAgentcontactname(null);
		return agent;
	}

	public String getContentitemName(String id) {
		if (id.indexOf("company") >= 0) {
			return Server.getInstance().getMemberService().findCustomeragent(
					Long.parseLong(id.replace("company", "")))
					.getAgentcompanyname();
		} else {
			return Server.getInstance().getMemberService().findDepartment(
					Long.parseLong(id)).getName();
		}
	}
	//默认出发机场
	private String s_sAirPort;
	//默认出发机场城市名称
	private String s_sAirPortName;
	private List<Aircompany> listAircompany;
	//QQ类型
	private List<Qqtypenew> listQqtypenew=new ArrayList<Qqtypenew>();
	
	public String getS_sAirPort() {
		return s_sAirPort;
	}

	public void setS_sAirPort(String airPort) {
		s_sAirPort = airPort;
	}

	public String getS_sAirPortName() {
		return s_sAirPortName;
	}

	public void setS_sAirPortName(String airPortName) {
		s_sAirPortName = airPortName;
	}

	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}

	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}

	public List<Qqtypenew> getListQqtypenew() {
		return listQqtypenew;
	}

	public void setListQqtypenew(List<Qqtypenew> listQqtypenew) {
		this.listQqtypenew = listQqtypenew;
	}

	public String towelcome_xc() throws Exception {
		
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		//取得代理商的默认城市.
		s_sAirPort=Server.getInstance().getMemberService().findCustomeragent(getLoginUserAgent().getId()).getAirportcode();
		if(s_sAirPort!=null && !s_sAirPort.equals(""))
		{
			
		}
		else
		{
			s_sAirPort="PEK";
		}
		s_sAirPortName=getCitynameByAirport(s_sAirPort);
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);

		ActionContext.getContext().getSession().remove(this.getLoginUserId() + "zrateone");
		ActionContext.getContext().getSession().remove(this.getLoginUserId() + "zratetwo");
		
		sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" WHERE 1=1 ", " ORDER BY ID DESC ", 10, 0);
		System.out.println("sysmessageList:"+sysmessageList.size());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Dnsmaintenance dnss=(Dnsmaintenance) session.getAttribute("dns");
		String whereqq=" where 1=1 and "+Qqtypenew.COL_agentid+" ="+dnss.getAgentid();
		listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(whereqq, " ORDER BY "+Qqtypenew.COL_state, -1, 0);
		if(listQqtypenew.size()==0){
			whereqq=" where 1=1 and "+Qqtypenew.COL_agentid+" =46";
			listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(whereqq, " ORDER BY "+Qqtypenew.COL_state, -1, 0);	
		}
		
		
		return "towelcome_xc";
	}
	/**
	 * 转向至欢迎页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String towelcome() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		// 客服QQ信息
		/*List<Qqtype> listqqtype = Server.getInstance().getMemberService()
				.findAllQqtype("where 1=1", "ORDER BY " + Qqtype.COL_index, -1,
						0);
		for (int i = 0; i < listqqtype.size(); i++) {
			s_qqlistinfo += "<tr><td class='tableheader2'><b>"
					+ listqqtype.get(i).getTypename() + "</b></td></tr>";
			List<Qqinfo> listqqinfo = Server.getInstance().getMemberService()
					.findAllQqinfo(
							"where " + Qqinfo.COL_qqtype + "="
									+ listqqtype.get(i).getId(),
							"Order by " + Qqinfo.COL_qqnumberindex, -1, 0);
			s_qqlistinfo += "<tr onmouseout='this.className=&#39;listresult&#39;;' onmouseover='this.className=&#39;listresultMouseOver&#39;' class='listresult'><td>";
			for (int j = 0; j < listqqinfo.size(); j++) {
				s_qqlistinfo += "&nbsp;&nbsp;<a href='#'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="
						+ listqqinfo.get(j).getQqnumber()
						+ "&site=qq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"
						+ listqqinfo.get(j).getQqnumber()
						+ ":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a>";

			}
			s_qqlistinfo += "</td></tr>";
		}*/
		
		sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" WHERE 1=1 ", " ORDER BY ID DESC ", 10, 0);
		
		String first=request.getParameter("first");
		if(first!=null){
			request.setAttribute("first", "true");
		}
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);
		
		
		agent=Server.getInstance().getMemberService().findCustomeragent(getLoginAgent().getId());
		
		return "welcome";
	}

	/**
	 * 转向至欢迎页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String towelcome2() throws Exception {
		
		
		return "welcome2";
	}
public String towelcome_cx() throws Exception {
		
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		//取得代理商的默认城市.
		s_sAirPort=Server.getInstance().getMemberService().findCustomeragent(getLoginUserAgent().getId()).getAirportcode();
		if(s_sAirPort!=null && !s_sAirPort.equals(""))
		{
			
		}
		else
		{
			s_sAirPort="PEK";
		}
		s_sAirPortName=getCitynameByAirport(s_sAirPort);
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);

		ActionContext.getContext().getSession().remove(this.getLoginUserId() + "zrateone");
		ActionContext.getContext().getSession().remove(this.getLoginUserId() + "zratetwo");
		
		sysmessageList=Server.getInstance().getAirService().findAllSysmessage(" WHERE 1=1 ", " ORDER BY ID DESC ", 10, 0);
		System.out.println("sysmessageList:"+sysmessageList.size());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Dnsmaintenance dnss=(Dnsmaintenance) session.getAttribute("dns");
		String whereqq=" where 1=1 and "+Qqtypenew.COL_agentid+" ="+dnss.getAgentid();
		listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(whereqq, " ORDER BY "+Qqtypenew.COL_state, -1, 0);
		if(listQqtypenew.size()==0){
			whereqq=" where 1=1 and "+Qqtypenew.COL_agentid+" =46";
			listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(whereqq, " ORDER BY "+Qqtypenew.COL_state, -1, 0);	
		}
		List<Logindesc>listlogo=Server.getInstance().getMemberService().findAllLogindesc(" WHERE 1=1 AND "+Logindesc.COL_userid+" ="+getLoginUser().getId(), " ORDER BY ID DESC ", 1, 0);
		if(listlogo!=null&&listlogo.size()>0){
			shangciloginip=listlogo.get(0).getLoginip();
			shangcilogintime=formatTimestampHHmm2(listlogo.get(0).getCreatetime());
		}
		
		
		sysmessageList_tc=Server.getInstance().getAirService().findAllSysmessage(" WHERE 1=1 AND "+Sysmessage.COL_type+" =2", " ORDER BY ID DESC ", 1, 0);
		if(sysmessageList_tc!=null&&sysmessageList_tc.size()>0){
			
			sysmessage=sysmessageList_tc.get(0);
		}
		
		
		return "towelcome_cx";
	}
	




	public String getTripOrderState(Integer id) {
		String streturn = "";
		if (id == 0) {
			streturn = "待确认";
		} else if (id == 1) {
			streturn = "完成";
		}
		return streturn;
	}

	public String getStateToString(Integer id) {
		switch (id) {
		case 0:

			return "新订单等待支付";

		case 1:

			return "采购商取消交易，交易结束";

		case 2:

			return "已经付款，等待出票";

		case 3:

			return "已经出票，交易结束";

		case 4:

			return "取消出票，等待退款";

		case 5:

			return "改签订单，等待审核";

		case 6:

			return "改签审核通过，机票被挂起，等待支付";

		case 7:

			return "已经付款，等待解挂";

		case 8:

			return "已经解挂，交易结束";

		case 9:

			return "改签订单审核不通过，交易结束";

		case 10:

			return "退票订单，等待审核";

		case 11:

			return "已经退款，交易结束";

		case 12:

			return "退票订单审核不通过，交易结束";

		case 13:

			return "废票订单，等待审核";

		case 14:

			return "废票审核通过，等待退款";

		case 15:

			return "废退票订单审核不通过，交易结束";

		case 16:

			return "退款订单，延迟处理";

		case 17:

			return "线下订单待确认";

		case 18:

			return "线下订单审核不通过，交易结束";

		case 19:

			return "暂不能出票，等待处理";

		default:
			return "未知状态";
		}
	}
	
	
	public String getAgentUrl(Integer id) {
		String strUrl="";
		if(id==0){
			strUrl="http://www.100ticket.com/indexudhzs.asp";	
		}
		if(id==1){
			strUrl="http://www.100ticket.com/indexudhzs.asp";	
		}
		if(id==2){
			strUrl="http://www.100ticket.com/indexudjxs.asp";	
		}
		
		
	return strUrl;
		
	}
	
	/**
	 * 截取字符串
	 * 
	 * @param str
	 * @return
	 */
	public String subString(String str) {
		return (str == null || "".equals(str)) ? "" : str.length() <= 10 ? str
				: str.substring(0, 10) + "…";
	}

	public Object getModel() {
		return user;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getValidateImg() {
		return validateImg;
	}

	public void setValidateImg(String validateImg) {
		this.validateImg = validateImg;
	}

	public Customeruser getUser() {
		return user;
	}

	public void setUser(Customeruser user) {
		this.user = user;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public Customeragent getAgent() {
		return agent;
	}

	public void setAgent(Customeragent agent) {
		this.agent = agent;
	}

	public List<Sysmessage> getSysmessageList() {
		return sysmessageList;
	}

	public void setSysmessageList(List<Sysmessage> sysmessageList) {
		this.sysmessageList = sysmessageList;
	}

	public String getForwordoa() {
		return forwordoa;
	}

	public void setForwordoa(String forwordoa) {
		this.forwordoa = forwordoa;
	}

	public List<Filecabindir> getListFilecabindir() {
		return ListFilecabindir;
	}

	public void setListFilecabindir(List<Filecabindir> listFilecabindir) {
		ListFilecabindir = listFilecabindir;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Orderinfo> getTicketorderlist() {
		return ticketorderlist;
	}

	public void setTicketorderlist(List<Orderinfo> ticketorderlist) {
		this.ticketorderlist = ticketorderlist;
	}

	public Customeruser getCustomeruser() {
		return customeruser;
	}

	public void setCustomeruser(Customeruser customeruser) {
		this.customeruser = customeruser;
	}

	public List<Customeruser> getListCustomeruser() {
		return listCustomeruser;
	}

	public void setListCustomeruser(List<Customeruser> listCustomeruser) {
		this.listCustomeruser = listCustomeruser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Agentroleref> getListAgentroleref() {
		return ListAgentroleref;
	}

	public void setListAgentroleref(List<Agentroleref> listAgentroleref) {
		ListAgentroleref = listAgentroleref;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public int getS_membertype() {
		return s_membertype;
	}

	public void setS_membertype(int s_membertype) {
		this.s_membertype = s_membertype;
	}

	public boolean agentAble(long agenid, long id) {
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(agenid);
		int able = agent.getAgentisenable();// 是否启用
		Customeruser user = Server.getInstance().getMemberService()
				.findCustomeruser(id);

		if (user.getIsenable() == null) {
			user.setIsenable(1);
		}
		int userable = user.getIsenable();
		if (userable != 1) {
			return false;
		}
		if (able != 1) {
			return false;
		}
		return true;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

	public String getImporttype() {
		return importtype;
	}

	public void setImporttype(String importtype) {
		this.importtype = importtype;
	}

	public int getPuserflag() {
		return puserflag;
	}

	public void setPuserflag(int puserflag) {
		this.puserflag = puserflag;
	}

	public String getS_orderstatuspnr() {
		return s_orderstatuspnr;
	}

	public void setS_orderstatuspnr(String s_orderstatuspnr) {
		this.s_orderstatuspnr = s_orderstatuspnr;
	}

	public int getIsinter() {
		return isinter;
	}

	public void setIsinter(int isinter) {
		this.isinter = isinter;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStrrebatehtml() {
		return strrebatehtml;
	}

	public void setStrrebatehtml(String strrebatehtml) {
		this.strrebatehtml = strrebatehtml;
	}

	public String getS_qqlistinfo() {
		return s_qqlistinfo;
	}

	public void setS_qqlistinfo(String s_qqlistinfo) {
		this.s_qqlistinfo = s_qqlistinfo;
	}

	public int getYwtype() {
		return ywtype;
	}

	public void setYwtype(int ywtype) {
		this.ywtype = ywtype;
	}

	public List<Rebaterule> getListRebaterule() {
		return listRebaterule;
	}

	public void setListRebaterule(List<Rebaterule> listRebaterule) {
		this.listRebaterule = listRebaterule;
	}

	public String getShengdailizongshu() {
		return shengdailizongshu;
	}

	public void setShengdailizongshu(String shengdailizongshu) {
		this.shengdailizongshu = shengdailizongshu;
	}

	public String getShidailizongshu() {
		return shidailizongshu;
	}

	public void setShidailizongshu(String shidailizongshu) {
		this.shidailizongshu = shidailizongshu;
	}

	public String getQuyudailizongshu() {
		return quyudailizongshu;
	}

	public void setQuyudailizongshu(String quyudailizongshu) {
		this.quyudailizongshu = quyudailizongshu;
	}

	public String getJingjirenzongshu() {
		return jingjirenzongshu;
	}

	public void setJingjirenzongshu(String jingjirenzongshu) {
		this.jingjirenzongshu = jingjirenzongshu;
	}

	public String getTicketordernum() {
		return ticketordernum;
	}

	public void setTicketordernum(String ticketordernum) {
		this.ticketordernum = ticketordernum;
	}

	public String getHotelordernum() {
		return hotelordernum;
	}

	public void setHotelordernum(String hotelordernum) {
		this.hotelordernum = hotelordernum;
	}

	public String getTripordernum() {
		return tripordernum;
	}

	public void setTripordernum(String tripordernum) {
		this.tripordernum = tripordernum;
	}

	public String getCarordernum() {
		return carordernum;
	}

	public void setCarordernum(String carordernum) {
		this.carordernum = carordernum;
	}

	public String getMobileordernum() {
		return mobileordernum;
	}

	public void setMobileordernum(String mobileordernum) {
		this.mobileordernum = mobileordernum;
	}

	public String getQqordernum() {
		return qqordernum;
	}

	public void setQqordernum(String qqordernum) {
		this.qqordernum = qqordernum;
	}

	public String getTotalordernum() {
		return totalordernum;
	}

	public void setTotalordernum(String totalordernum) {
		this.totalordernum = totalordernum;
	}

	public int getRechtype() {
		return rechtype;
	}

	public void setRechtype(int rechtype) {
		this.rechtype = rechtype;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public String getAgentidstr() {
		return agentidstr;
	}

	public void setAgentidstr(String agentidstr) {
		this.agentidstr = agentidstr;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public List getMenulist() {
		return menulist;
	}

	public void setMenulist(List menulist) {
		this.menulist = menulist;
	}

	public Long getC_smsid() {
		return c_smsid;
	}

	public void setC_smsid(Long c_smsid) {
		this.c_smsid = c_smsid;
	}

	public Ymsend getYmsend() {
		return ymsend;
	}

	public void setYmsend(Ymsend ymsend) {
		this.ymsend = ymsend;
	}

	public Sysmessage getSysmessage() {
		return sysmessage;
	}

	public void setSysmessage(Sysmessage sysmessage) {
		this.sysmessage = sysmessage;
	}

	public Long getSysid() {
		return sysid;
	}

	public void setSysid(Long sysid) {
		this.sysid = sysid;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<Cityairport> getListcityairport() {
		return listcityairport;
	}

	public void setListcityairport(List<Cityairport> listcityairport) {
		this.listcityairport = listcityairport;
	}

	public List<Province> getListprovince() {
		return listprovince;
	}

	public void setListprovince(List<Province> listprovince) {
		this.listprovince = listprovince;
	}

	public int getLogintype() {
		return logintype;
	}

	public void setLogintype(int logintype) {
		this.logintype = logintype;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLogpassword() {
		return logpassword;
	}

	public void setLogpassword(String logpassword) {
		this.logpassword = logpassword;
	}

	public String getTx_loginname() {
		return tx_loginname;
	}

	public void setTx_loginname(String tx_loginname) {
		this.tx_loginname = tx_loginname;
	}

	public String getTx_logpassword() {
		return tx_logpassword;
	}

	public void setTx_logpassword(String tx_logpassword) {
		this.tx_logpassword = tx_logpassword;
	}

	public String getTx_validateImg() {
		return tx_validateImg;
	}

	public void setTx_validateImg(String tx_validateImg) {
		this.tx_validateImg = tx_validateImg;
	}

	public int getIsSPPolicy() {
		return isSPPolicy;
	}

	public void setIsSPPolicy(int isSPPolicy) {
		this.isSPPolicy = isSPPolicy;
	}

	public String getLinkname() {
		return linkname;
	}

	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public int getDaichupiaoticket() {
		return daichupiaoticket;
	}

	public void setDaichupiaoticket(int daichupiaoticket) {
		this.daichupiaoticket = daichupiaoticket;
	}

	public int getTuiticket() {
		return tuiticket;
	}

	public void setTuiticket(int tuiticket) {
		this.tuiticket = tuiticket;
	}

	public int getFeiticket() {
		return feiticket;
	}

	public void setFeiticket(int feiticket) {
		this.feiticket = feiticket;
	}

	public int getGaiqianticket() {
		return gaiqianticket;
	}

	public void setGaiqianticket(int gaiqianticket) {
		this.gaiqianticket = gaiqianticket;
	}

	public int getDaiquerenticket() {
		return daiquerenticket;
	}

	public void setDaiquerenticket(int daiquerenticket) {
		this.daiquerenticket = daiquerenticket;
	}

	public int getDaizhifuticket() {
		return daizhifuticket;
	}

	public void setDaizhifuticket(int daizhifuticket) {
		this.daizhifuticket = daizhifuticket;
	}

	public int getQbnum() {
		return qbnum;
	}

	public void setQbnum(int qbnum) {
		this.qbnum = qbnum;
	}

	public int getTelnum() {
		return telnum;
	}

	public void setTelnum(int telnum) {
		this.telnum = telnum;
	}

	public String getAgenttel() {
		return agenttel;
	}

	public void setAgenttel(String agenttel) {
		this.agenttel = agenttel;
	}

	public String getAgentaddress() {
		return agentaddress;
	}

	public void setAgentaddress(String agentaddress) {
		this.agentaddress = agentaddress;
	}

	public String getAgentcontactname() {
		return agentcontactname;
	}

	public void setAgentcontactname(String agentcontactname) {
		this.agentcontactname = agentcontactname;
	}

	public String getAgentphone() {
		return agentphone;
	}

	public void setAgentphone(String agentphone) {
		this.agentphone = agentphone;
	}

	public String getAgentemail() {
		return agentemail;
	}

	public void setAgentemail(String agentemail) {
		this.agentemail = agentemail;
	}

	public String getMsnqq() {
		return msnqq;
	}

	public void setMsnqq(String msnqq) {
		this.msnqq = msnqq;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getShangciloginip() {
		return shangciloginip;
	}

	public void setShangciloginip(String shangciloginip) {
		this.shangciloginip = shangciloginip;
	}

	public String getShangcilogintime() {
		return shangcilogintime;
	}

	public void setShangcilogintime(String shangcilogintime) {
		this.shangcilogintime = shangcilogintime;
	}

	public List<Sysmessage> getSysmessageList_tc() {
		return sysmessageList_tc;
	}

	public void setSysmessageList_tc(List<Sysmessage> sysmessageList_tc) {
		this.sysmessageList_tc = sysmessageList_tc;
	}

	public int getBenjibaoxian() {
		return benjibaoxian;
	}

	public void setBenjibaoxian(int benjibaoxian) {
		this.benjibaoxian = benjibaoxian;
	}

	public int getXiajibaoxian() {
		return xiajibaoxian;
	}

	public void setXiajibaoxian(int xiajibaoxian) {
		this.xiajibaoxian = xiajibaoxian;
	}

	public String getC_agentid() {
		return c_agentid;
	}

	public void setC_agentid(String c_agentid) {
		this.c_agentid = c_agentid;
	}

	public String getC_baoxianprice() {
		return c_baoxianprice;
	}

	public void setC_baoxianprice(String c_baoxianprice) {
		this.c_baoxianprice = c_baoxianprice;
	}

	public int getBenjibaoxian2() {
		return benjibaoxian2;
	}

	public void setBenjibaoxian2(int benjibaoxian2) {
		this.benjibaoxian2 = benjibaoxian2;
	}

	public int getXiajibaoxian2() {
		return xiajibaoxian2;
	}

	public void setXiajibaoxian2(int xiajibaoxian2) {
		this.xiajibaoxian2 = xiajibaoxian2;
	}

	public String getPayPwd() {
		return PayPwd;
	}

	public void setPayPwd(String payPwd) {
		PayPwd = payPwd;
	}








}