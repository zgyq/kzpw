package com.yf.system.back.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.system.back.server.Server;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;

import com.yf.system.base.insurorder.Insurorder;
import com.yf.system.base.insuruser.Insuruser;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.Insurances;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class NewInsuranceAction extends B2b2cbackAction{

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	private String membername[];//保存被保人姓名
    private String membersex[];//保存性别
    private Long cardtype[];//保存证件
    private String cardnunber[];//保存证件号
    private String mobile[];//保存电话号码
    private String birthday[];//保存出生日期
    private String memberemail[];//保存电子邮箱
    private String [] flyno;//保存被保人的航班号
    private String [] city;//保存城市信息
    private String begintime;//保存起保时间
    private String begintime1;
    private String flytime;//保存起飞时间
    private Insuruser insuruser=new Insuruser();//保存被保人信息
    private List<Insuruser> inuserlist=new ArrayList<Insuruser>();//用来保存被保人信息
    private Insurorder inorder=new Insurorder();//保存订单信息
    private List orderlist;//保存订单的集合
    private Insuruser inusers=new Insuruser();//保存被保人信息
    private List userslist;//保存被保人列表
    private long oid;//保存订单编号
    private  List passengerlist;//保存乘机人列表信息
     //保存订单id
	public long orderId;// 订单Id
	private Orderinfo orderinfo=new Orderinfo();
	private Segmentinfo segmentinfo=new Segmentinfo();
	private Passenger passenger=new Passenger();
	private List<Passenger>listpass=new ArrayList<Passenger>();
	
	private long passid;
	
	 private String shengri;//生日
	
	private long insuiuserid;
	private long BaoXianCODE;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public List getPassengerlist() {
		return passengerlist;
	}
	public void setPassengerlist(List passengerlist) {
		this.passengerlist = passengerlist;
	}
	public List<Insuruser> getInuserlist() {
		return inuserlist;
	}
	public void setInuserlist(List<Insuruser> inuserlist) {
		this.inuserlist = inuserlist;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public List getUserslist() {
		return userslist;
	}
	public void setUserslist(List userslist) {
		this.userslist = userslist;
	}
	public Insuruser getInusers() {
		return inusers;
	}
	public void setInusers(Insuruser inusers) {
		this.inusers = inusers;
	}
	public Insurorder getInorder() {
		return inorder;
	}
	public void setInorder(Insurorder inorder) {
		this.inorder = inorder;
	}
	public List getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List orderlist) {
		this.orderlist = orderlist;
	}
	public String[] getMembername() {
		return membername;
	}
	public void setMembername(String[] membername) {
		this.membername = membername;
	}
	public String[] getMembersex() {
		return membersex;
	}
	public void setMembersex(String[] membersex) {
		this.membersex = membersex;
	}
	public Long[] getCardtype() {
		return cardtype;
	}
	public void setCardtype(Long[] cardtype) {
		this.cardtype = cardtype;
	}
	public String[] getCardnunber() {
		return cardnunber;
	}
	public void setCardnunber(String[] cardnunber) {
		this.cardnunber = cardnunber;
	}
	public String[] getMobile() {
		return mobile;
	}
	public void setMobile(String[] mobile) {
		this.mobile = mobile;
	}
	public String[] getBirthday() {
		return birthday;
	}
	public void setBirthday(String[] birthday) {
		this.birthday = birthday;
	}
	public String[] getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String[] memberemail) {
		this.memberemail = memberemail;
	}
	public String[] getFlyno() {
		return flyno;
	}
	public void setFlyno(String[] flyno) {
		this.flyno = flyno;
	}
	public String[] getCity() {
		return city;
	}
	public void setCity(String[] city) {
		this.city = city;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getBegintime1() {
		return begintime1;
	}
	public void setBegintime1(String begintime1) {
		this.begintime1 = begintime1;
	}
	public String getFlytime() {
		return flytime;
	}
	public void setFlytime(String flytime) {
		this.flytime = flytime;
	}
	public Insuruser getInsuruser() {
		return insuruser;
	}
	public void setInsuruser(Insuruser insuruser) {
		this.insuruser = insuruser;
	}
	
	
	
	/**
	 * 跳转到保险服务页面
	 */
	public String toservicepass(){
	System.out.println(orderId+","+passid);	
	String where =" where 1=1 and "+Passenger.COL_orderid+" ="+orderId+" and "+Passenger.COL_liveaddress+" is null ";
	List<Passenger>list=Server.getInstance().getAirService().findAllPassenger(where, " ORDER BY ID ", -1, 0);
	if(list!=null&&list.size()>0){
		for(int a=0;a<list.size();a++){
			if(list.get(a).getInsurprice()>0){
				listpass.add(list.get(a));
			}
		}
	}
		
	return "toservicepass";
	}
	
	
	/**
	 * AJAX读取酒店推荐信息 2012-02-14 陈星
	 * 
	 * @throws
	 */
	public void AJAXCanBaoXianOrder() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		int ret=-1;
		Insuruser insuruser=Server.getInstance().getAirService().findInsuruser(insuiuserid);
	    List<Insurances> list2=Server.getInstance().getAtomService().orderAply(insuruser.getPolicyno().toString().trim(), null, null, null, null);
		if(list2!=null&&list2.size()>0){
			ret=list2.get(0).getStatus();
		}
		 if(ret!=-1){
			 insuruser.setCity("2");//取消成功
			 Server.getInstance().getAirService().updateInsuruserIgnoreNull(insuruser);
		 }
		Writer writer = response.getWriter();
		writer.write(ret+"");
		writer.flush();
		writer.close();
	}
	
	
	
	
	
	
	
	/*
	 * 当前年月日
	 * @return
	 */
	private static String getDateString(){
		try {
			return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
			
		} catch (Exception e) {
			return "000000";
		}
		
	}
	public static String getNumString(long num,int len){
		StringBuffer code =  new StringBuffer(len);
		for(int i=0;i<len ;i++){
			code.append('0');
		}
		String snum = (""+num);
		int slen = snum.length();
		if(slen>len){
			snum = snum.substring(0,len);
		}
		code.replace(len-snum.length(),len,snum);
		
		return code.toString();
	}
	
	/**
	 * 列表查询隐扣设置
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Backpoint.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		inuserlist = list;
		  if(pageinfo.getTotalrow()>0 &&   inuserlist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			inuserlist = list;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 跳转到购买页面
	 */
	public String toservice(){
		System.out.println(passid);
		if(passid>0){
		passenger=Server.getInstance().getAirService().findPassenger(passid);
		orderinfo=Server.getInstance().getAirService().findOrderinfo(passenger.getOrderid());
		List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
		segmentinfo=listseg.get(0);
		}
		
		if(passenger.getIdtype()==1){//身份证
			if(passenger.getIdnumber().length()>=16){
			String birthday = passenger.getIdnumber().substring(6,14);
			passenger.setBirthday(birthday.substring(0, 4)+"-"+birthday.substring(4, 6)+"-"+birthday.substring(6, 8));
			String xb= passenger.getIdnumber().substring(16,17);
			passenger.setState(Integer.parseInt(xb));
			}
		}
		
		
		
		
		return "toservice";
	}
	/**
	 * 跳转到保险单页面
	 */
	public String toInsurancelist(){
		return "toInsurancelist";
	}
	
	public String GetOrderNuberByPassID(String passid){
		Passenger pa=Server.getInstance().getAirService().findPassenger(Long.parseLong(passid));
		Orderinfo or=Server.getInstance().getAirService().findOrderinfo(pa.getOrderid());
		
		return or.getOrdernumber();
	}
	public long GetOrderIDByPassID(String passid){
		Passenger pa=Server.getInstance().getAirService().findPassenger(Long.parseLong(passid));
		Orderinfo or=Server.getInstance().getAirService().findOrderinfo(pa.getOrderid());
		
		return or.getId();
	}
	
	/**
	 * 跳转到订单页面
	 */
	public String toOrderlist(){
		return "toOrderlist";
	}
	
	/**
	 * 创建保单
	 */
	public String OrderApply(){
		
		Passenger pass=Server.getInstance().getAirService().findPassenger(passid);
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(pass.getOrderid());
		
		
		List list=new ArrayList(); 
		int mark=0;
		List<Insurances> listinsurance=new ArrayList<Insurances>();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String [] jyno=null;
		String [] flighttime=flytime.split(",");
		Insuruser users=new Insuruser();
        for(int i=0;i<membername.length;i++){
        	
			users.setName(membername[i]);
			users.setSex(Long.parseLong((membersex[i])));
			users.setCodetype((cardtype[i]));
			users.setCode((cardnunber[i]));
			users.setMobile(orderinfo.getContactmobile());
			
			users.setFlyno(flyno[i]);
			users.setOrderid(passid);
			try {
				users.setFlytime(new Timestamp(format.parse(flighttime[i]).getTime()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Timestamp ts=null;
			try {
				ts = new Timestamp((format.parse(birthday[i]).getTime()));
				users.setBegintime(new Timestamp(format.parse(begintime).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			users.setBirthday(ts);
			users.setEmail((memberemail[i]));
			
			users.setCity("0");//0失败 1成功  2取消  
			
			
			try {
				users=Server.getInstance().getAirService().createInsuruser(users);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
     
        //pass.setMobile(mobile[0]);
        pass.setBirthday(birthday[0]);
        pass.setState(Integer.parseInt((membersex[0])));
		list.add(pass);
		
		
		
        
		    List list2=Server.getInstance().getAtomService().newOrderAplylist(jyno, list);
		
		   // System.out.println(listinsurance.get(0));
		    
		    if(list2!=null&&list2.size()>0&&!list2.get(0).equals("-1")){
		    	users.setPolicyno((String) list2.get(0).toString().trim());
		    	users.setCity("1");//成功
		    	Server.getInstance().getAirService().updateInsuruserIgnoreNull(users);
		    	pass.setLiveaddress(list2.get(0).toString());
		    	
		 		Server.getInstance().getAirService().updatePassengerIgnoreNull(pass);
		    }
		    inuserlist.add(users);
		    insuruser=users;
     
		    
		    
		return "OrderApply";
	}
	/**
	 * 查询订单根据条件查询
	 * 订单号，订单状态，订单创建时间，服务公司
	 * 保存到对象中
	 */
	public String selectOrder(){
		StringBuilder sb=new StringBuilder("WHERE 1=1");
		//判断订单号
		if(inorder.getLiushuino()!=null&&!inorder.getLiushuino().equals("")){
		sb.append(" AND C_LIUSHUINO like '%"+inorder.getLiushuino()+"%'");
		}
		//判断订单状态（分为未支付,已支付，失败）
		if(inorder.getStatus()!=null&&!inorder.getStatus().equals("")){
			sb.append(" AND C_STATUS="+inorder.getStatus());
		}
		//判断时间
		if(begintime!=null&&!begintime.equals("")&&begintime1!=null&&!begintime1.equals("")){
			sb.append(" AND C_TIME between '"+begintime+"' and '"+begintime1+"'");
		}
		System.out.println(sb.toString());
		List list=Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		  orderlist = list;
		  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			orderlist = list;
		}
		System.out.println(orderlist.size());
		return "selectOrder";
	}
	/**
	 * 查询保险单根据条件查询
	 * 被保人姓名，航班号，保险单号，起保日期
	 */
	public String selectInsurance(){
		StringBuilder sb=new StringBuilder("WHERE 1=1");
		//判断保险单号
		if(inusers.getPolicyno()!=null&&!inusers.getPolicyno().equals("")){
			sb.append(" AND C_POLICYNO like '%"+inusers.getPolicyno()+"%'");
		}
		//判断被保人姓名
		if(inusers.getName()!=null&&!inusers.getName().equals("")){
			sb.append(" AND C_NAME LIKE '%"+inusers.getName()+"%'");
		}
		//判断航班号
		if(inusers.getFlyno()!=null&&!inusers.getFlyno().equals("")){
			sb.append(" AND C_FLYNO LIKE '%"+inusers.getFlyno()+"%'");
		}
		//判断起保日期(范围)
		if(begintime!=null&&!begintime.equals("")&&begintime1!=null&&!begintime1.equals("")){
			sb.append(" AND C_BEGINTIME between '"+begintime+"' and '"+begintime1+"'");
		}
		System.out.println(sb.toString());
		List list=Server.getInstance().getAirService().findAllInsuruserForPageinfo(sb.toString()," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		  userslist = list;
		  if(pageinfo.getTotalrow()>0 && userslist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(sb.toString()," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			userslist = list;
		}
		return "selectInsurance";
	}
	
	/**
	 * 查看订单（根据订单id查询insuranceuser表中的详细信息）
	 * 传过来一个订单id
	 * id（insuorder表中）
	 */
	public String searchOrder(){
		StringBuilder sb=new StringBuilder("WHERE 1=1");
		if(oid!=0){
		   sb.append(" AND C_ORDERID ="+oid);
		}
		List list=Server.getInstance().getAirService().findAllInsuruserForPageinfo(sb.toString()," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		  userslist = list;
		  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(sb.toString()," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			userslist = list;
		}
		return "searchOrder";
	}
	
	/**
	 * 支付保险订单
	 */
	public String payInsurOrder(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//根据订单id查询订单
		this.setInorder(Server.getInstance().getAirService().findInsurorder(oid));
		//获得总价
		Double totalprice=inorder.getTotalmoney();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("billname", "InsurancepayHelper");// 对应接口中 支付辅助类 必传
		map.put("orderid", oid);// 订单id 必传
		if (ServletActionContext.getServletContext().getAttribute(
				"vmoneyservice") != null) {// 判断是否有虚拟账户业务
			map.put("actionname", "insurance!vmoneyInsurancetpay.action");
			System.out.println(oid);
			boolean vpay = true;
			float vmoney=new CustomeragentServiceImpl().getTotalVmoney(this
					.getLoginUser().getAgentid());
			if (totalprice > vmoney) {
				vpay = false;
			}
			map.put("vmoney", vmoney);
			map.put("vmpayenable", vpay);// 如果可虚拟账户支付 传入当前账户余额
		}
		map.put("orderprice", totalprice);
		request.setAttribute("ordermap", map);// 传值....
		return "payInsurOrder";
	}
	
	/**
	 * 虚拟货币进行支付
	 */
	public String vmoneyInsurancetpay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int paystate = 1;// 成功
		String message = "订单支付成功!";
		//获得订单编号
		String orderid = ServletActionContext.getRequest().getParameter(
				"orderid");
		try {
			//根据id获得订单信息
			Insurorder orderinfo = Server.getInstance().getAirService().findInsurorder(Long.valueOf(orderid));	
			//获得订单的总价钱
			double totleprice=orderinfo.getTotalmoney();
			//获得用户的虚拟货币
			long loginagentid=this.getLoginUser().getAgentid();
			double vmoney=new CustomeragentServiceImpl().getTotalVmoney(loginagentid);
			//判断是否能够支付
			if (totleprice > vmoney) {
				paystate = 2;// 失败
				message = "订单支付失败！原因：当前账户余额不足与订单支付！";
			} else {
				orderinfo.setStatus(Long.parseLong("2")); // 已支付
				//相应的扣除虚拟货币的金额
				String price=Double.toString(0-totleprice);
				this.createRebateRecord(orderinfo.getOrderno(),
						Float.parseFloat(price), 9, loginagentid, loginagentid, 2,null);

				//更新订单的状态
				Server.getInstance().getAirService().updateInsurorderIgnoreNull(orderinfo);
				
				//支付成功跳转到保险单查询页面
				StringBuilder sb=new StringBuilder("WHERE 1=1");
				List list=Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
				pageinfo = (PageInfo)list.remove(0);
			      orderlist = list;
				  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
					pageinfo.setPagenum(1);
					list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
					pageinfo = (PageInfo)list.remove(0);
					orderlist = list;
				}

			}
		} catch (Exception e) {
			paystate = 2;// 失败
			message = "订单支付失败！原因：网络连接失败！";
			e.printStackTrace();
		}
		request.setAttribute("paystate", paystate);
		request.setAttribute("message", message);
		System.out.println("air/airpaysuccess.jsp");
		return "cancelOrder";
	}
	
	/**
	 * 查看保险单返回的是pdf格式的文档
	 * 查看电子保单
	 */
	public String searchInsurance(){
		//根据订单编号得到订单对象
		this.setInorder(Server.getInstance().getAirService().findInsurorder(oid));
		//调用保险单接口
		try {
			DataHandler returnpdf=Server.getInstance().getAtomService().PolicyReprint(this.inorder);	
			InputStream is=null;
             if(returnpdf!=null&&!returnpdf.equals("")){
            	is= returnpdf.getInputStream();
             }				 
			 byte[]dataHandler =new byte[is.available()];//将服务器端返回的dh转为byte数组
			 //byte[] dataHandler = (byte[]) returnpdf;//
			 HttpServletResponse response = ServletActionContext.getResponse();
			  try {
			   response.reset();
			   response.setContentType("application/pdf");   
			   response.setHeader("Content-Disposition","attachment;filename=insurance2011-12-20.pdf"); 
			   response.getOutputStream().write(dataHandler);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据订单id查询保险单的详细信息
	 */
	public String getInsuranceByid(){
		//根据订单id查询订单
		this.setInorder(Server.getInstance().getAirService().findInsurorder(oid));
		//获得保险单的信息，循环获得
		String uid=inorder.getInsuruserid().toString();
		if(uid!=null&&!uid.equals("")){
			String [] id=uid.split(",");
			for(int i=0;i<id.length-1;i++){
				inusers=Server.getInstance().getAirService().findInsuruser(Long.parseLong(id[i]));
				inuserlist.add(inusers);
			}
		}
		return "getInsuranceByid";
	}
	/**
	 * 根据订单查询乘机人给乘机人购买保险
	 */
	public String buyInsurance(){
		//查询乘机人信息（被保人信息）根据订单号
		String pwhere = " WHERE " + Passenger.COL_orderid + "=" + orderId;
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(pwhere, "", -1, 0);
		this.setPassengerlist(passengers);
		return "buyInsurance";
	}
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	public Segmentinfo getSegmentinfo() {
		return segmentinfo;
	}
	public void setSegmentinfo(Segmentinfo segmentinfo) {
		this.segmentinfo = segmentinfo;
	}
	public List<Passenger> getListpass() {
		return listpass;
	}
	public void setListpass(List<Passenger> listpass) {
		this.listpass = listpass;
	}
	public long getPassid() {
		return passid;
	}
	public void setPassid(long passid) {
		this.passid = passid;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public long getInsuiuserid() {
		return insuiuserid;
	}
	public void setInsuiuserid(long insuiuserid) {
		this.insuiuserid = insuiuserid;
	}
	public long getBaoXianCODE() {
		return BaoXianCODE;
	}
	public void setBaoXianCODE(long baoXianCODE) {
		BaoXianCODE = baoXianCODE;
	}

}
