package com.yf.website.web.action;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.fairport.Fairport;
import com.yf.system.base.fairway.Fairway;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.fflight.AllRouteInfo;
import com.yf.system.base.fflight.Fflight;
import com.yf.system.base.fflight.Route;
import com.yf.system.base.fflight.RouteDetailInfo;
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.helpcenterinfo.Helpcenterinfo;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.service.IAirService;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class InterNationalTicketAction extends TicketCommonAction {

	/** 定义国际航班查询条件* */
	private String fromCity;// 出发机场
	private String arrCity;// 到达机场
	private int intertype;// 类型，1单程，2返程
	private String hideFromCityCode;// 出发城市三字码
	private String hideArrCityCode;// 到达城市三字码
	private String fromTime;// 出发时间
	private String returnTime;// 返回时间
	private String airCompany;// 航空公司
	private String passengerType;// 乘机人类型 //乘机人类型 0成人 1留学生
	private String passengerNum;// 乘客人数
	private String Lvspace;// 

	private AllRouteInfo allroteinfo;// 国际机票数据返回
	private List<RouteDetailInfo> routeDetailInfo;
	private List<Segmentinfo> listSegmentinfo;
	private List<Route> routs=new ArrayList<Route>();
	private String fromDate;// 列表起飞页时间
	private String toDate;// 列表到达页时间
	private String RoutesId;// 航程id
	private String RouteDetailInfoId;// 航程详细信息ID
	private double TotalFare;
	private String commitorder;// 乘机人信息
	private String TotalPrice;//订单总价
	// 乘机人详细信息
	private List<Passenger> listpassenger;
	private String s_tax;// 税费
	private double childTotalFare;//儿童价格 
	long idtemp = 0l;
	private long s_orderid;
	// 订单详细信息
	private Orderinfo orderinfo = new Orderinfo();
	private String forword;

	//联系人信息
	private String Contact;
	private String MobilPhone;
	private String Email;
	private String comfileType;
	
	private String fcity;
	private String acity;
	private String fdate;
	 private  List<Fcountry> listcountry;
	private  List<Customerpassenger> listcommonpassenger=new ArrayList<Customerpassenger>();//常用乘机人
	//剩余所有常用乘机人
	private List<Customerpassenger> listallcommonpassenger=new ArrayList<Customerpassenger>();
	/** 定义国际航班查询条件 end* */


	// 最新资讯
	private List<Informationinfo> listZX;
	public List<Informationinfo> getListZX() {
		return listZX;
	}

	public void setListZX(List<Informationinfo> listZX) {
		this.listZX = listZX;
	}

	/***************************************************************************
	 * 进入国际机票查询也面页面
	 * 
	 * @date 2011-12-02
	 * @author 高亮
	 **************************************************************************/
	public String toInterNational() throws Exception {
		System.out.println("进入国际机票查询页面");
		String where = " where 1=1 and " + Helpcenterinfo.COL_typeid
		+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
		+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
		+ " ='国际航线信息')";
		listZX = Server.getInstance().getMemberService().findAllHelpcenterinfo(where, " ORDER BY ID DESC ", 7, 0);
		
		return "tointernational";
	}

	/***************************************************************************
	 * 国际机票查询列表
	 * 
	 * @date 2011-12-02
	 * @author 高亮
	 **************************************************************************/
	public String toInterNationalList() throws Exception{
		System.out.println("******开始查询国际机票信息******");
		// 查询返回数据AllRouteInfo
		try {
			
		 String type1=String.valueOf(intertype);
			allroteinfo = Server.getInstance().getAtomService()
					.interTicketSearch(hideFromCityCode, hideArrCityCode,
							fromTime, returnTime, Lvspace,type1);
			// 放入seesion
			ActionContext.getContext().getSession().put("AllRouteInfo",
					allroteinfo);
			if (allroteinfo.getRoutes().size() > 0) {
				routs = allroteinfo.getRoutes();
			} else {
				routs = null;	
			}
		} catch (Exception e) {
			routs = null;
		}
		return "tointerlist";
	}

	/***************************************************************************
	 * 日期格式化
	 * 
	 * @author gaoliang
	 * @date 2011-12-05
	 **************************************************************************/
	public String getTimeByDate(String date) {

		String str1[] = date.split(",");
		String str = str1[0].toString() + " " + str1[1].substring(0, 2)
				+ ":" + str1[1].substring(2, 4);
		return str;
	}
 //判断航班是否过也；仅仅判断了 日 月以前没判断
    public int getTimeGY(String date1,String date2){
    	int a=0;
    	String str1[] = date1.split(",");
    	String str2[]=date2.split(",");
    	String strone=str1[0].substring(8,10);

    	String strtwo=str2[0].substring(8,10);
    	if(strone.equals(strtwo)){
    		a=0;
    	}else{
    		a=1;
    	}
		return a;
    	
    	
    }
	/***************************************************************************
	 * 国际机票订单预定
	 * 
	 * @date 2011-12-14
	 * @author 高亮
	 **************************************************************************/
	public String toOrder() {
		

		Customeruser loginuser = (Customeruser)ActionContext.getContext().getSession().get("loginuser");	
		//加载国籍信息
       listcountry=Server.getInstance().getInterticketService().findAllFcountry("", "ORDER BY ID", -1, 0);
		// 页面隐藏数据
		HttpServletRequest request = ServletActionContext.getRequest();
		hideFromCityCode = request.getParameter("hideFromCityCode");
		hideArrCityCode = request.getParameter("hideArrCityCode");
		fromTime = request.getParameter("fromTime");
		returnTime = request.getParameter("returnTime");
		intertype = Integer.parseInt(request.getParameter("intertype"));
		ActionContext.getContext().getSession().put("fcity",hideFromCityCode);
		ActionContext.getContext().getSession().put("acity",hideArrCityCode);
		ActionContext.getContext().getSession().put("fdate",fromTime);
		// 页面隐藏数据 end
		// 从session中获取数据
		AllRouteInfo listrouteinfo = (AllRouteInfo) ActionContext.getContext()
				.getSession().get("AllRouteInfo");
		String str[] = RoutesId.split(",");	
			int routesid = Integer.parseInt(str[0].trim());	
	
		routs = listrouteinfo.getRoutes();
		if(routs.size()==0){
			return "error";
		}else{
			for (int i = 0; i < routs.size(); i++) {
				if (routs.get(i).getID() == routesid) {
					routeDetailInfo = routs.get(i).getRouteDetailInfos();// 得到Id内容
					airCompany = routs.get(i).getAirCompany();// 赋值给航空公司
					TotalFare = routs.get(i).getTotalFare();// 赋值机票价格
					childTotalFare=routs.get(i).getTotalChlidFare();
					RoutesId = String.valueOf(routs.get(i).getID());
					s_tax = String.valueOf(routs.get(i).getTotalTax());// 税费
					// 保存到session航班信息
					ActionContext.getContext().getSession().put("RouteDetailInfo",
							routeDetailInfo);
					System.out.println(routeDetailInfo.get(0).getFromDate()+"放入的时候的时间");
				}
				
			}
		}
		
		//添加常用联系人
		
		if (loginuser==null) 
		{   
			ActionContext.getContext().getSession().put("RouteDetailInfo",
					routeDetailInfo);
			ActionContext.getContext().getSession()
			.put("pageUrl","international!toOrder.jspx?routeDetailInfo="
					+routeDetailInfo+"&airCompany="+airCompany
					+"&TotalFare="+TotalFare+"&childTotalFare="+childTotalFare+"&RoutesId="+RoutesId
					+"&s_tax="+s_tax+"&hideFromCityCode="+hideFromCityCode
					+"&hideArrCityCode="+hideArrCityCode+"&fromTime="+fromTime
					+"&returnTime="+returnTime+"&intertype="+intertype+"&passengerType="+passengerType);
			return "toLogin";
		} else{
		String where=" where "+Customerpassenger.COL_customeruserid+"="+loginuser.getId();
		List<Customerpassenger> listpass=Server.getInstance().getMemberService().findAllCustomerpassenger(where, "order by "+Customerpassenger.COL_id+" desc", -1, 0);
		
			for(int i=0;i<listpass.size();i++)
			{
				if(i<=4)
				{
					//绑定证件类型和证件号码
					String strwherecredit=" where "+Customercredit.COL_refid+"="+listpass.get(i).getId();
					List<Customercredit> listcredit=Server.getInstance().getMemberService().findAllCustomercredit(strwherecredit, "order by "+Customercredit.COL_credittypeid, 1, 0);
					if(listcredit.size()>0)
					{
						listpass.get(i).setLivingcardtype(listcredit.get(0).getCredittypeid()+"");
						listpass.get(i).setLivingcardnum(listcredit.get(0).getCreditnumber());
						listpass.get(i).setLivingperiod(listcredit.get(0).getPassportvalidity());
						
					}
					listcommonpassenger.add(listpass.get(i));
				}
				else
				{
					String strwherecredit=" where "+Customercredit.COL_refid+"="+listpass.get(i).getId();
					List<Customercredit> listcredit=Server.getInstance().getMemberService().findAllCustomercredit(strwherecredit, "order by "+Customercredit.COL_credittypeid, 1, 0);
					if(listcredit.size()>0)
					{
						listpass.get(i).setLivingcardtype(listcredit.get(0).getCredittypeid()+"");
						listpass.get(i).setLivingcardnum(listcredit.get(0).getCreditnumber());
						listpass.get(i).setLivingperiod(listcredit.get(0).getPassportvalidity());
						
					}
					listallcommonpassenger.add(listpass.get(i));
				}

			}
		}
		//添加常用联系人 end 
		
		
		return "tobooking";
	}

	/***************************************************************************
	 * 创建国际机票订单  
	 * 
	 * @date 2011-12-8
	 * @author gaoliang
	 * @throws Exception
	 **************************************************************************/
	public String createOrder() throws Exception {
		// ***************************1、国际订单信息赋值开始***********************************/
		HttpServletRequest request = ServletActionContext.getRequest();
		hideFromCityCode = request.getParameter("hideFromCityCode");
		hideArrCityCode = request.getParameter("hideArrCityCode");
		fromTime = request.getParameter("fromTime");
		String t=String.valueOf(TotalFare);
		float totalFare = Float.parseFloat(t);
		
		System.out.println(RoutesId + "=======航班ID");
		System.out.println(commitorder + "字符串内容");

		// 联系人姓名
		orderinfo.setContactname(Contact);
		// 联系人手机
		orderinfo.setContactmobile(MobilPhone);
		// 联系人电子邮件
		orderinfo.setContactemail(Email);
		
		// 备注 确认方式
		orderinfo.setMemo(comfileType);
		orderinfo.setPnr("NOPNR");
		orderinfo.setBigpnr("NOPNR");
		Customeruser loginuser = (Customeruser) ActionContext.getContext()
				.getSession().get("loginuser");
		if (loginuser == null) {
			return "toLogin";
		}
		// 采购商ID
		long a=461;
		orderinfo.setBuyagentid(a);
		// 供应商ID
		orderinfo.setSaleagentid(46l);
		// 创建时间
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// 采购商员工id
		orderinfo.setCustomeruserid(loginuser.getId());
		// 订单状态
		orderinfo.setOrderstatus(27); // 待确认状态
		// 订单类型-后台订单
		orderinfo.setOrdertype(2l);
		// 支付方式
		orderinfo.setPaymethod(1);
		// 支付状态
		orderinfo.setPaystatus(0);
		orderinfo.setPolicyagentid(6l);
		orderinfo.setPolicyid(0l);
		orderinfo.setLanguage(0);
		orderinfo.setTotalairportfee(0f);

		orderinfo.setTotalfuelfee(Float.parseFloat(s_tax));// 税费
		orderinfo.setTotalticketprice(Float.parseFloat(TotalPrice));// 价格
    
		orderinfo.setOrderprice(Float.parseFloat(TotalPrice)); //
		orderinfo.setInternal(1l); // 是否是国际票
	
//			// 创建订单信息
//			orderinfo = Server.getInstance().getAirService().createOrderinfo(
//					orderinfo);
//			// 取得订单号
//			idtemp = orderinfo.getId();
//			// 更新订单信息
//			orderinfo.setOrdernumber(Server.getInstance().getServiceCenter()
//					.getOrderinfoCode(orderinfo));
//			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
//					orderinfo);
		
		
		// ***************************国际订单信息赋值结束***********************************//
       List<Segmentinfo> listSegmentinfo=new ArrayList();
		// ****************************2.航程信息赋值开始************************************//
		// 获取航程信息
		routeDetailInfo = (List<RouteDetailInfo>) ActionContext.getContext()
				.getSession().get("RouteDetailInfo");
		// 循环航程
		if (routeDetailInfo != null && routeDetailInfo.size() > 0) {

			for (RouteDetailInfo detailinfo : routeDetailInfo) {
				Segmentinfo segmeng = new Segmentinfo();
				segmeng.setAgentid(getLoginUser().getAgentid());
				segmeng.setAircomapnycode(detailinfo.getAirCompany());
				segmeng.setAircompanyname(AirCompanyNamebyCode(detailinfo
						.getAirCompany()));
				segmeng.setAirportfee(0f);
				segmeng.setFuelfee(0f);
				segmeng.setPrice(totalFare);
				segmeng.setDeparttime(dateToTimestamp(getTimeByDate(detailinfo.getFromDate())));
				segmeng.setArrivaltime(dateToTimestamp(getTimeByDate(detailinfo.getToDate())));
                System.out.println(dateToTimestamp(getTimeByDate(detailinfo.getFromDate()))+"时间"+detailinfo.getFromAirport());
				segmeng.setCabincode(detailinfo.getCabin());
				segmeng.setDiscount(0f);
				segmeng.setStartairport(detailinfo.getFromAirport());
				segmeng.setEndairport(detailinfo.getToAirport());
				segmeng.setFlightmodelnum("");
				segmeng.setFlightnumber(detailinfo.getFlightNumber());
				segmeng.setIsspecial(0);
				segmeng.setOrderid(orderinfo.getId()); // 订单ID
				segmeng.setParvalue(0f);
				segmeng.setRatevalue(0f);
				segmeng.setTraveltype(1); // 单程
				segmeng.setLanguage(0);
				segmeng.setYprice(totalFare);
				// 创建航程信息
				listSegmentinfo.add(segmeng);
				//Server.getInstance().getAirService().createSegmentinfo(segmeng);
			}

		}else{
			System.out.println("订单创建失败航班信息错误！");
			return "error";
		}
		//清楚session内容
		ActionContext.getContext()
		.getSession().remove("RouteDetailInfo");
		// ****************************航程信息赋值结束************************************//
        List<Passenger> listPassenger=new ArrayList();
		// ***************************3、解析乘机人信息开始***********************************/
		try {
	
		commitorder = commitorder.replace("[", "{\"passengers\":[").toString()
				.replace("]", "]}");
		JSONObject jsonPassengerinfo = JSONObject.fromObject(commitorder);
		JSONArray jsons = jsonPassengerinfo.getJSONArray("passengers");
		for (int i = 0; i < jsons.size(); i++) {
			JSONObject passJson = JSONObject.fromObject(jsons.get(i));
			System.out.println("Passenger姓名:" + passJson.getString("Name"));
			Passenger passenger = new Passenger();
			passenger.setName(passJson.getString("Name"));// 乘机人姓名
			passenger.setPtype(Integer.parseInt(passJson.getString("Type")));// 乘机人类型，1：成人，2：儿童，3：婴儿
			passenger
					.setIdtype(Integer.parseInt(passJson.getString("Docment")));// 证件类型
			passenger.setIdnumber(passJson.getString("Number"));// 证件号码
			passenger.setDiscount(0f);
			passenger.setState(0);
			passenger.setOrderid(orderinfo.getId()); // 订单ID 
			passenger.setAirportfee(0f);
			passenger.setFuelprice(Float.parseFloat("0"));
			if(passenger.getIdtype()==1){
				passenger.setPrice(totalFare);// 成人价格	
			}
			
			if(passenger.getIdtype()==2){
				passenger.setPrice(Float.parseFloat(String.valueOf(childTotalFare)));// 儿童价格价格
			}
			passenger.setLanguage(0);
			passenger.setIsstudent(Integer.parseInt(passJson
					.getString("student_type")));// 是否是留学生
			passenger.setCardvaliddate(passJson.getString("Period"));//证件有效期
			passenger.setCountry(passJson.getString("Nationality"));// 国籍
			passenger.setBirthday(passJson.getString("BirthDate"));// 生日
			passenger.setDestadress(""); // 地址
			passenger.setDestzipcode("");// 邮编
			passenger.setLiveaddress("");// 现居地地址
			System.out.println(Integer.parseInt(passJson.getString("Issave"))+"保存不保存");
			passenger.setIssave(Integer.parseInt(passJson.getString("Issave")));
			listPassenger.add(passenger);
			
			//Server.getInstance().getAirService().createPassenger(passenger);

		}
		
		} catch (Exception e) {
			System.out.println("乘机人信息创建失败");
			return "error";
		}
		
		// ***************************结束解析乘机人信息并保存***********************************/
		String strorderid=Server.getInstance().getAtomService().createticketorder(listSegmentinfo, listPassenger, orderinfo);
        
        if(!strorderid.equals("-1")){
        	System.out.println("订单创建成功");
        	forword = "international!toSuccess.jspx?s_orderid="  + Long.parseLong(strorderid);
        }else{
			forword="failorder";
		}
		

		return "forword";

	}

	/***************************************************************************
	 * 订单成功页面
	 * 
	 * @date 2011-12-8
	 * @author 高亮
	 **************************************************************************/
	public String toSuccess() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		fcity=(String) ActionContext.getContext().getSession().get("fcity");
		acity=(String) ActionContext.getContext().getSession().get("acity");
		fdate=(String) ActionContext.getContext().getSession().get("fdate");
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				s_orderid);
		listpassenger = Server.getInstance().getAirService().findAllPassenger(
				" where " + Passenger.COL_orderid + "=" + s_orderid, "", -1, 0);
		listSegmentinfo=Server.getInstance().getAirService().findAllSegmentinfo(" where "+Passenger.COL_orderid+"="+s_orderid, "", -1, 0);

		ActionContext.getContext().getSession().remove("fcity");
		ActionContext.getContext().getSession().remove("acity");
		ActionContext.getContext().getSession().remove("fdate");

		return "success";

	}
	/**
	 * 根据国际航空公司获取航空公司名称
	 * 
	 * @param aircompany
	 * @return
	 */
	public String AirCompanyNamebyCode(String code) {
		String where = "where " + Aircompany.COL_aircomcode + "='" + code
				+ "'";
		List<Aircompany> list=Server.getInstance().getAirService().findAllAircompany(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getAircomcnname() : code;

	}




	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getHideFromCityCode() {
		return hideFromCityCode;
	}

	public void setHideFromCityCode(String hideFromCityCode) {
		this.hideFromCityCode = hideFromCityCode;
	}

	public String getHideArrCityCode() {
		return hideArrCityCode;
	}

	public void setHideArrCityCode(String hideArrCityCode) {
		this.hideArrCityCode = hideArrCityCode;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getAirCompany() {
		return airCompany;
	}

	public void setAirCompany(String airCompany) {
		this.airCompany = airCompany;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(String passengerNum) {
		this.passengerNum = passengerNum;
	}

	public String getLvspace() {
		return Lvspace;
	}

	public void setLvspace(String lvspace) {
		Lvspace = lvspace;
	}

	public AllRouteInfo getAllroteinfo() {
		return allroteinfo;
	}

	public void setAllroteinfo(AllRouteInfo allroteinfo) {
		this.allroteinfo = allroteinfo;
	}

	public List<Route> getRouts() {
		return routs;
	}

	public void setRouts(List<Route> routs) {
		this.routs = routs;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public List<RouteDetailInfo> getRouteDetailInfo() {
		return routeDetailInfo;
	}

	public void setRouteDetailInfo(List<RouteDetailInfo> routeDetailInfo) {
		this.routeDetailInfo = routeDetailInfo;
	}

	public String getRoutesId() {
		return RoutesId;
	}

	public void setRoutesId(String routesId) {
		RoutesId = routesId;
	}

	public String getRouteDetailInfoId() {
		return RouteDetailInfoId;
	}

	public void setRouteDetailInfoId(String routeDetailInfoId) {
		RouteDetailInfoId = routeDetailInfoId;
	}

	public double getTotalFare() {
		return TotalFare;
	}

	public void setTotalFare(double totalFare) {
		TotalFare = totalFare;
	}

	public String getCommitorder() {
		return commitorder;
	}

	public void setCommitorder(String commitorder) {
		this.commitorder = commitorder;
	}

	public String getS_tax() {
		return s_tax;
	}

	public void setS_tax(String s_tax) {
		this.s_tax = s_tax;
	}

	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public long getIdtemp() {
		return idtemp;
	}

	public void setIdtemp(long idtemp) {
		this.idtemp = idtemp;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public Long getS_orderid() {
		return s_orderid;
	}

	public void setS_orderid(Long s_orderid) {
		this.s_orderid = s_orderid;
	}

	public List<Passenger> getListpassenger() {
		return listpassenger;
	}

	public void setListpassenger(List<Passenger> listpassenger) {
		this.listpassenger = listpassenger;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getMobilPhone() {
		return MobilPhone;
	}

	public void setMobilPhone(String mobilPhone) {
		MobilPhone = mobilPhone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getComfileType() {
		return comfileType;
	}

	public void setComfileType(String comfileType) {
		this.comfileType = comfileType;
	}

	public List<Segmentinfo> getListSegmentinfo() {
		return listSegmentinfo;
	}

	public void setListSegmentinfo(List<Segmentinfo> listSegmentinfo) {
		this.listSegmentinfo = listSegmentinfo;
	}

	public void setS_orderid(long s_orderid) {
		this.s_orderid = s_orderid;
	}

	public List<Fcountry> getListcountry() {
		return listcountry;
	}

	public void setListcountry(List<Fcountry> listcountry) {
		this.listcountry = listcountry;
	}


	
	public String getFcity() {
		return fcity;
	}

	public void setFcity(String fcity) {
		this.fcity = fcity;
	}

	public String getAcity() {
		return acity;
	}

	public void setAcity(String acity) {
		this.acity = acity;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public List<Customerpassenger> getListcommonpassenger() {
		return listcommonpassenger;
	}

	public void setListcommonpassenger(List<Customerpassenger> listcommonpassenger) {
		this.listcommonpassenger = listcommonpassenger;
	}

	public List<Customerpassenger> getListallcommonpassenger() {
		return listallcommonpassenger;
	}

	public void setListallcommonpassenger(
			List<Customerpassenger> listallcommonpassenger) {
		this.listallcommonpassenger = listallcommonpassenger;
	}

	public double getChildTotalFare() {
		return childTotalFare;
	}

	public void setChildTotalFare(double childTotalFare) {
		this.childTotalFare = childTotalFare;
	}

	public String getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}

	public int getIntertype() {
		return intertype;
	}

	public void setIntertype(int intertype) {
		this.intertype = intertype;
	}



}
