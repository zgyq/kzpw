package com.yf.website.web.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.caucho.services.server.ServiceContext;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.yf.service.ZrateServer;
import com.yf.system.atom.component.WriteLog;
import com.yf.system.base.agentvalue.Agentvalue;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.flightinfo.CarbinInfo;
import com.yf.system.base.flightinfo.FlightInfo;
import com.yf.system.base.flightinfo.FlightSearch;
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.helpcenterinfo.Helpcenterinfo;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.useraddress.Useraddress;
import com.yf.system.base.zrate.Zrate;
import com.yf.website.web.date.IpUtil;
import com.yf.website.web.server.Server;

/**
 * 国内机票Action
 * 
 * @Date 2011-11-14
 * @author 陈星
 * 
 */

public class DomesticTicketAction extends TicketCommonAction {

	/**
	 * *定义公共变量*************************开始*************************************
	 * 
	 * @author 陈星
	 * @Date 2011-11-14
	 * 
	 */
	// 航程类型 1单程 2往返 3联程
	public int s_traveltype = 1;
	// 出发城市三字码
	public String s_depcitycode;
	// 出发城市名称
	public String s_depcityname;
	// 到达城市名称
	public String s_arrcityname;
	// 到达城市三字码
	public String s_arrcitycode;
	// 出发时间
	public String s_startdate;
	// 返程时间
	public String s_backdate;
	// 航空公司代码
	public String s_aircompanycode;
	// 第一程标识
	private int s_travelflag=1;
	// 航空公司信息
	public List<Aircompany> listAirCompany;
	// 航班信息List
	private List<FlightInfo> listFlightInfoAll;
	// 航程信息Jason字符串
	private String s_jasonsegmentinfo;
	private String randno;
	private Integer isBackOrTo;
	private FlightSearch flightSearch=new FlightSearch();
	private String lowersegmentstr = "";
	private List lowersegment = new ArrayList();
	// 航程信息List
	private List<Segmentinfo> listsegmentinfo=new ArrayList<Segmentinfo>();
	private List<Segmentinfo> lissegtempt=new ArrayList<Segmentinfo>();
	// 前一天长日期格式
	private String s_prevdate;
	// 后一天长日期格式
	private String s_nextdate;
	// 前一天短日期格式
	private String s_prevshortdate;
	// 后一天短日期格式
	private String s_nextshortdate;
	//前五个常用乘机人
	private List<Customerpassenger> listcommonpassenger=new ArrayList<Customerpassenger>();
	//剩余所有常用乘机人
	private List<Customerpassenger> listallcommonpassenger=new ArrayList<Customerpassenger>();
	private long id;
	private int idcardtype;
	/*************************************************************************************
	 * 生成订单页面*/
	private String s_jsonpassengers;
	//联系人姓名
	private String s_contactname;
	//联系手机号
	private String s_contactmobile;
	//联系人邮箱
	private String s_contactemail;
	//确认方式 1=不用确认 2=手机短消息确认 3.电话确认
	private int s_contacttype=1;
	//出票方式 1.立即出票 2.暂缓出票
	private int s_rrtickettype=1;
	//支付方式 1=网上支付 3=票到付款 （B2C只用到网上支付和票到付款）
	private int s_paymethod=1;
	//送票方式  1=不需要行程单 2=邮寄行程单 3机场自取 4市内配送 5门市自取
	private int s_sendtickettype=1;
	//送票方式 其他信息
	//--------邮寄行程单
	private String s_postname;
	private String s_postmobile;
	private String s_postaddress;
	private String s_postprovince;
	private String s_postzipcode;
	//--------邮寄行程单
	private String s_ziquaddress;
	//--------配送行程单
	private String s_sendaddress;
	private String s_senddate;
	private String s_sendtime;
	private String s_sendhour;
	
	
	private List<Useraddress> listaddress=new ArrayList<Useraddress>();
	/*********************/
	//跳转地址
	private String forword;
	//订单对象
	private Orderinfo orderinfo;
	//订单id
	private long orderid;
	//订单价格详情
	private String orderpricedtail;
	//乘机人
	private List<Passenger> listpassenger;
	/*********************/
	
	 
	

  
	/**
	 * *定义机票相关帮助信息*************************开始*************************************
	 * 
	 * @author 陈星
	 * @Date 2011-11-21
	 * 
	 */
		// 帮助信息list
		public List<Helpcenterinfo> Listhelpcenterinfo;
		// 资讯信息list
		public List<Informationinfo> ListInformationinfo;
		// 帮助类型 ID
		public long typeid;
		
		
		
		public String s_cabincode;//仓位
		
		public String s_flightnumber;//航班号
		
		private String z_price;//传递来的当前价格
		
		
		
		public void findcabinlowBY() {//listOrderPrice
			long lagentid=46l;
			
		    StringBuffer str = new StringBuffer();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			List<Agentvalue> list= new ArrayList<Agentvalue>();
			
			
			//getLoginAgent().getFixedvalue()
			Float fratevalue=0f;
		    String isgaofan="1";
			
				//政策值
				
				Calendar cal=Calendar.getInstance(); 
			    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
			    String mDateTime=formatter.format(cal.getTime());
			    
			    Calendar calYYYYMMDD=Calendar.getInstance(); 
			    SimpleDateFormat formatterYYYYMMDD=new SimpleDateFormat("yyyy-MM-dd"); 
			    String mDateTimeYYYYMMDD=formatterYYYYMMDD.format(calYYYYMMDD.getTime());
			    
			    if(s_flightnumber.indexOf(s_aircompanycode.trim())!=-1){
			    	s_flightnumber=s_flightnumber.replaceAll(s_aircompanycode.trim(), "");
			    }
			    
			    
			    String strSP="[dbo].[sp_GetZrateByFlight] "+
				"@chufajichang = N'"+s_depcitycode+"',@daodajichang = N'"+s_arrcitycode+"',"+
				"@chufariqi = N'"+formatStringTimetoyyyymmdd(s_startdate)+"',@dangqianshijian= N'"+mDateTime+"',"+
				"@hangkonggongsi= N'"+s_aircompanycode+"',"+
				"@cangwei= N'"+s_cabincode+"',@hangbanhao= N'"+s_flightnumber+"',@ismulity=0,@isgaofan=1,@agentid=0";
			    System.out.println(strSP);
			    //List listzrate=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
			    
			   // System.out.println("URL:"+ZrateServer.getInstance().getUrl());
			   // ZrateServer.getInstance().setUrl("http://127.0.0.1:28080");
			    List<Zrate> listzrate=ZrateServer.getInstance().searchZrate(s_depcitycode, s_arrcitycode, s_aircompanycode, s_cabincode, formatStringTimetoyyyymmdd(s_startdate), 0, s_flightnumber, 0);
			    System.out.println("URL:"+ZrateServer.getInstance().getUrl()+",size:"+listzrate.size());
			    Zrate zratemodel=new Zrate();
				//List listzrate = Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
				//获取最高的政策信息
			    
			    
			    
			    //返佣金额
				 Float freturnmoney=0f;
				 
				 
				 //政策ID
				 Long zrateid=0l;
				if(listzrate.size()>0)
				{
					//Map listzratemap = (Map) listzrate.get(0);
					Zrate zrate=listzrate.get(0);
					fratevalue=zrate.getRatevalue();
					fratevalue=Getliudianvalue(fratevalue);
					zrateid=zrate.getId();
					//zratemodel=Server.getInstance().getAirService().findZrate(Long.parseLong(listzratemap.get("zrateid").toString()));
					isgaofan=zrate.getGeneral()+"";
				    freturnmoney=(Float.parseFloat(z_price)* dceimalFormat(fratevalue) / 100);
				
				    str.append(z_price+"@");
				    str.append(freturnmoney+"@");
				    str.append(formatMoneyToInt((Float.parseFloat(z_price)-freturnmoney))+"@");
				    str.append(fratevalue+"@");
				    str.append(zrateid+"@");
				    
				}else{
					
					  str.append(z_price+"@");
					  str.append(freturnmoney+"@");
					  str.append(formatMoneyToInt(Float.parseFloat(z_price))+"@");
					  str.append("0@");
					  str.append(zrateid+"@");
				}
				
			
				
		  Writer writer;
			try {
				writer = response.getWriter();
				writer.write(str.toString());
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		
		
		private String z_zratevalue;//传递来的返点
		private String z_zrateid;//传递来的政策ID
		

		public void GetNewvalue(){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			
			Float fratevalue=Float.parseFloat(z_zratevalue);
			
			fratevalue=Getliudianvalue(Float.parseFloat(z_zratevalue));
			
			
			
			Float fratevalue2=Getliudianvalue_b2c(fratevalue);
			
			System.out.println("原始:"+z_zratevalue+",匹配代理后:"+fratevalue+",代理扣点B2C后:"+fratevalue2+",票面价:"+z_price);
			//返佣金额
			 Float freturnmoney=0f;

				freturnmoney=(Float.parseFloat(z_price)* dceimalFormat(fratevalue2) / 100);
				StringBuffer str = new StringBuffer();
			    str.append(z_price+"@");
			    str.append(freturnmoney+"@");
			    str.append(formatMoneyToInt((Float.parseFloat(z_price)-freturnmoney))+"@");
			    str.append(fratevalue2+"@");
			    str.append(z_zrateid+"@");
			
			
			 Writer writer;
				try {
					writer = response.getWriter();
					writer.write(str+"");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
		
		
		

    /***************************************************************************
	 * 定义机票相关帮助信息**************************结束
	 * 
	 * 
	 * 
	 * /** 机票查询方法
	 * 
	 * @return 返回到列表页面
	 * @throws Exception
	 * @author 陈星
	 * @Date 2011-11-14
	 */
	public String toTicketList() throws Exception {
		if(s_arrcityname==null||s_arrcityname.equals("null")){
		s_arrcityname=getAirCityNamebySZM(s_arrcitycode);
		}
		if(s_depcityname==null||s_depcityname.equals("null")){
			s_depcityname=getAirCityNamebySZM(s_depcitycode);
		}
		
		System.out.println("执行机票查询方法"+s_depcitycode+"-"+s_arrcitycode+"-"+s_startdate+"-"+s_traveltype);
		// 航班查询条件赋值
		FlightSearch searchParam = new FlightSearch();
		// 出发城市三字码
		searchParam.setStartAirportCode(s_depcitycode);
		// 出发城市名称
		searchParam.setStartAirPortName(s_depcityname);
		// 到达城市三字码
		searchParam.setEndAirportCode(s_arrcitycode);
		// 到达城市名称
		searchParam.setEndAirPortName(s_arrcityname);
		// 出发日期
		searchParam.setFromDate(s_startdate);
		// 出发时间
		searchParam.setFromTime("");
		// 返程日期
		searchParam.setBackDate(s_backdate);
		// 航空公司代码
		searchParam.setAirCompanyCode(s_aircompanycode);
		// 航程类型
		searchParam.setTravelType(String.valueOf(s_traveltype));
		if(s_traveltype==2 && s_travelflag==2)
		{
			// 将json字符串转换程Segmentinfo集合
			listsegmentinfo=getSelectedSegment(s_jasonsegmentinfo);
			String strFromCity=searchParam.getStartAirportCode();
			String strToCity=searchParam.getEndAirportCode();
			searchParam.setStartAirportCode(strToCity);
			searchParam.setEndAirportCode(strFromCity);
			searchParam.setFromDate(searchParam.getBackDate());
			searchParam.setAirCompanyCode(listsegmentinfo.get(0).getAircomapnycode());
			
		}
		// 调用查询航班方法
		listFlightInfoAll = AVOpen(searchParam, s_traveltype);

		System.out.println("===========航班查询结束===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		//从缓存中得到航空公司信息
		listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		// 前一天后一天日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		SimpleDateFormat sdfMMdd = new SimpleDateFormat("MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		// 起飞日期
		java.util.Date flightdate = new java.util.Date();
		 try
		 {
           flightdate = sdf.parse(searchParam.getFromDate());
         }
		 catch (Exception e) 
		 {
              System.out.println("String to Date error");
         }
		// 起飞日期
        calendar.setTime(flightdate);
        calendar.add(Calendar.DATE , -1);
        s_prevdate = sdf.format(calendar.getTime());
        s_prevshortdate=sdfMMdd.format(calendar.getTime());
		calendar.add(Calendar.DATE , 2);
		s_nextdate = sdf.format(calendar.getTime());
		s_nextshortdate=sdfMMdd.format(calendar.getTime());
		System.out.println("===========航班查询结束3===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		
		// 前一天后一天日期
		// 查询帮助信息
		// 添加人:陈星
		// 添加时间:2011-11-21
		
		
		//for(Object object:listFlightInfoAll){
		//}
		
		Iterator iteratorL=null;//用于退改签
		Iterator iterator= listFlightInfoAll.iterator();
		
		Float zhekou=0.8f;
		List<Sysconfig> listsys=Server.getInstance().getSystemService().findAllSysconfig(" where 1=1 and "+Sysconfig.COL_name+" ='B2CPRICE'", " ORDER BY ID DESC ", -1, 0);
		if(listsys!=null&&listsys.size()>0){
			zhekou=Float.parseFloat(listsys.get(0).getValue());
		}
		
		while(iterator.hasNext())
		{
			FlightInfo flightInfo =(FlightInfo)iterator.next();
			CarbinInfo carbinInfo= flightInfo.getLowCarbin();
			Float newprice=	carbinInfo.getPrice()-(carbinInfo.getPrice()/carbinInfo.getDiscount()*10*zhekou);
			carbinInfo.setPrice(newprice);
			carbinInfo.setDiscount(Float.parseFloat(formatZrate(carbinInfo.getDiscount()-zhekou*10)));
			
			//carbinInfo.setDiscount(carbinInfo.getDiscount()-zhekou);
			
			//用于退改签 Begin  获取 sql where 条件
			/*if(flightInfo.getCarbins().size()>0)
			iteratorL= flightInfo.getCarbins().iterator();
			while(iteratorL.hasNext())
			{
				
				CarbinInfo cabin = (CarbinInfo)iteratorL.next();
				
			}*/
			//用于退改签 End
		}
		
		seachInfocontent();
		System.out.println("===========航班查询结束4===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		return "tolist";

	}

	/**
	 * 调用接口查询航班信息
	 * 
	 * @author 陈星
	 * @Date 2011-11-14
	 * @param flightSearch
	 *            航班查询条件
	 * @param intType
	 *            航程类型
	 * @return 航班信息列表
	 */
	public List<FlightInfo> AVOpen(FlightSearch flightSearch, int intType) {
		System.out.println("===========航班查询开始===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		List<FlightInfo> list = Server.getInstance().getTicketSearchService()
				.findAllFlightinfo(flightSearch);
		
		return list;
	}

	
	/**
	 * 跳转到创建订单页面
	 * 
	 * @param s_jasonsegmentinfo
	 *            Json格式的Segmentinfo
	 * @author 陈星
	 * @createtime:2011-11-21
	 * @return
	 */
	public String toCreateOrder()
	{
		System.out.println("输出Json选中航程信息："+s_jasonsegmentinfo);
		//拦截登录
		Customeruser loginuser = (Customeruser)ActionContext.getContext().getSession().get("loginuser");
		if (loginuser==null) 
		{
			//未登录时，保存当前参数，跳转至登录页面
			ActionContext.getContext().getSession().put("pageParam",s_jasonsegmentinfo);
			ActionContext.getContext().getSession().put("pageUrl","ticticket!toCreateOrder.jspx");
			return "toLogin";
		} 
		else
		{
			//加载当前登录会员常用旅客信息
			String where=" where "+Customerpassenger.COL_customeruserid+"="+loginuser.getId();
			List<Customerpassenger> listpass=Server.getInstance().getMemberService().findAllCustomerpassenger(where, "order by "+Customerpassenger.COL_id+" desc", -1, 0);
			if(listpass.size()>5)
			{
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
						}
						listallcommonpassenger.add(listpass.get(i));
					}
				}
			}
			else
			{
				listcommonpassenger=listpass;
			}
			//对联系人信息赋值
			s_contactname=loginuser.getMembername();
			s_contactmobile=loginuser.getMobile();
			s_contactemail=loginuser.getMemberemail();
			//取得常用配送地址
			listaddress=Server.getInstance().getMemberService().findAllUseraddress("WHERE "+Useraddress.COL_memberid+"="+loginuser.getId(), "ORDER BY "+Useraddress.COL_id+" DESC", -1, 0);
			
		}
		//拦截登录
		listsegmentinfo=null;
		if(ActionContext.getContext().getSession().get("pageParam")!=null)
		{
			s_jasonsegmentinfo=(String)ActionContext.getContext().getSession().get("pageParam");
		}
		// 将json字符串转换程Segmentinfo集合
		listsegmentinfo=getSelectedSegment(s_jasonsegmentinfo);
		System.out.println("Json转换完成:"+listsegmentinfo.toString());
		
		// 从缓存中得到航空公司信息
		listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		ActionContext.getContext().getSession().remove("pageParam");
		// 陈星更新,读取相关信息 更新时间:2011-11-23
		seachInfocontent();
		return "tocreateorder";
	}
	
	/**
	 * 生成订单方法
	 * @return
	 */
	public String createorder()
	{
		
		
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 1;
		//是否生成PNR
		int intIsCreatePNR=0;//0不生成PNR   1生成PNR
		//是否生成外部订单
		int intIsCreateOuterOrder=0;//0不生成外部订单   1生成外部订单
		//是否按照原政策信息已经生成外部订单
		int intIsCreated=0;
		int  isok=1;//0失败  1成功
		List<Passenger> listpass=new ArrayList<Passenger>();
		List<Segmentinfo> listsegment=new ArrayList<Segmentinfo>();
		Orderinfo orderinfo=new Orderinfo();
		//航程信息
		listsegment=getSelectedSegment(s_jasonsegmentinfo);
		System.out.println(listsegment.size());
		//乘机人信息
		listpass=getSelectedPassenger(s_jsonpassengers);
		//订单信息
		//联系人姓名
		orderinfo.setContactname(s_contactname);
		//联系手机号
		orderinfo.setContactmobile(s_contactmobile);
		//确认方式
		orderinfo.setNotetype(s_contacttype);
		//支付方式
		orderinfo.setPaymethod(s_paymethod);
		//出票方式
		orderinfo.setFkmethod(s_rrtickettype);
		//订单类型 1=网站订单 2=b2b后台订单
		orderinfo.setOrdertype(1l);
		//订单状态 待确认
		orderinfo.setOrderstatus(1);
		//支付状态
		orderinfo.setPaystatus(0); 
		orderinfo.setLanguage(0);
		//创建时间
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		//会员id
		Customeruser loginuser = (Customeruser)ActionContext.getContext().getSession().get("loginuser");
		if (loginuser==null) 
		{
			return "toLogin";
		} 
		orderinfo.setCustomeruserid(loginuser.getId());
		
		
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Long agentid=46l;
		//取session里面agentid
		if(session.getAttribute("b2cdns")!=null){
			Dnsmaintenance dns=(Dnsmaintenance)session.getAttribute("b2cdns");
			if(dns.getAgentid()>0){
				agentid=dns.getAgentid();
			}
		}
		
		
		
		
		//采购商id
		orderinfo.setSaleagentid(agentid);
		//供应商id
		orderinfo.setBuyagentid(agentid);
		//是否是国际订单，0国内，1国际
		orderinfo.setInternal(0l);
		/****************政策信息**********************/
		//政策id
		orderinfo.setPolicyid(listsegment.get(0).getZrateid());
		
		orderinfo.setPolicyagentid(46l);
		/*Zrate zrate=Server.getInstance().getAirService().findZrate(listsegment.get(0).getZrateid());
		if(zrate!=null){
			orderinfo.setPolicyagentid(zrate.getAgentid());
		}else{
			
			orderinfo.setPolicyagentid(6l);
		}*/
		
		/****************政策信息**********************/
		/****************配送信息**********************/
		//送票方式 1=不需要行程单 2=邮寄行程单 3机场自取 4市内配送 5门市自取
		orderinfo.setReceipt(s_sendtickettype);
		//邮寄行程单
		if(s_sendtickettype==2)
		{
			orderinfo.setPostname(s_postname);
			orderinfo.setPostmobile(s_postmobile);
			if(s_postprovince==null)
			{
				s_postprovince="";
			}
			else
			{
				s_postprovince+="|";
			}
			orderinfo.setAddresa(s_postprovince+s_postaddress);
			orderinfo.setPostcode(s_postzipcode);
		}
		else if(s_sendtickettype==3)
		{
			orderinfo.setAddresa(s_ziquaddress);
		}
		else if(s_sendtickettype==4)
		{
			orderinfo.setAddresa(s_postaddress);
			String strsenddate=s_senddate+" "+s_sendtime;
			orderinfo.setPeisongdate(dateToTimestamp2(strsenddate));
		}
		/****************配送信息**********************/
		//生成小PNR
		if(intIsCreatePNR==1){
			//String strpnr=Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegment, listpass, "");
				String strpnr="";
				if (intCreatePNRType == 1) {
				strpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegment, listpass, orderinfo.getNewpnr());
				//strpnr="JQM4FW";
				} else {
				strpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegment, listpass, orderinfo);
					//strpnr="JQM4FW";
				}
				if(strpnr.equals("-1")){
					intIsCreateOuterOrder=0;
					intIsCreatePNR=0;
					strpnr="123456";
					isok=0;
				}else{
					
					if(intCreatePNRType==2){//51创建PNR
						/*String newpnr="";
						String pnrtxt="";
						String pattxt="";
						
						newpnr=strpnr.split("@")[0];
						pattxt=strpnr.split("@")[1];
						pnrtxt=strpnr.split("@")[2];
						orderinfo.setPattxt(pattxt);
						orderinfo.setPnrtxt(pnrtxt);
						orderinfo.setPnr(newpnr);
						if(pattxt.indexOf("没有符合条件的运价")!=-1){
							System.out.println("没有符合条件的运价,订单创建失败");
							
							isok=0;
						}*/
						String newpnr="";
						String pnrtxt="";
						String pattxt="";
						if(strpnr.indexOf("@")!=-1){
						newpnr=strpnr.split("@")[0];
						pattxt=strpnr.split("@")[1];
						pnrtxt=strpnr.split("@")[2];
						}else{
							newpnr=strpnr;
						}
						WriteLog.write("第三方生成PNR信息", "PNR:"+newpnr+",RTTXT:"+pnrtxt+",PATTXT:"+pattxt);
						orderinfo.setPattxt(pattxt);
						orderinfo.setPnrtxt(pnrtxt);
						orderinfo.setPnr(newpnr);
						if(pattxt.indexOf("没有符合条件的运价")!=-1){
							System.out.println("没有符合条件的运价,订单创建失败");
							
							isok=0;
						}
					}else{//黑屏创建
						
						String pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strpnr, "", "");
						int ind=0;
						
						if(pnrtxt.indexOf("+")>0){
							ind=pnrtxt.indexOf("+");
							pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strpnr+"$PN", "", "");
						}
						if(pnrtxt.indexOf("+")>ind){
							ind=pnrtxt.indexOf("+");
							pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strpnr+"$PN$PN", "", "");
						}
						if(pnrtxt.indexOf("+")>ind){
							ind=pnrtxt.indexOf("+");
							pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strpnr+"$PN$PN$PN", "", "");
						}
						
						if(pnrtxt!=null&&pnrtxt.indexOf("HGH280")!=-1){
							
							pnrtxt=pnrtxt.split("[.]HGH280")[0]+".HGH280";
						}
						
						String pattxt=Server.getInstance().getTicketSearchService().commandFunction2("PAT:A", "", "");
						orderinfo.setPattxt(pattxt);
						orderinfo.setPnrtxt(pnrtxt);
						orderinfo.setPnr(strpnr);
						if(pattxt.indexOf("没有符合条件的运价")!=-1){
							System.out.println("没有符合条件的运价,订单创建失败");
							Server.getInstance().getTicketSearchService().commandFunction2("RT"+strpnr+"$XEPNR@", "", "");
							isok=0;
						}
						
					}
					
				}
				
				
				
			
			System.out.println("小PNR已生成："+strpnr);
			//orderinfo.setPnr(strpnr);
			
			
			
		}
		else{
			orderinfo.setPnr("123456");
			//isok=0;//测试完删除
		}
		//生成大PNR
		//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
		/*if(!orderinfo.getPnr().equals("NOPNR") || !orderinfo.getPnr().equals("123456")){
			orderinfo.setBigpnr(Server.getInstance().getTicketSearchService().getBigPNRInfo(orderinfo.getPnr()));
		}
		else{
			orderinfo.setBigpnr("");
		}*/
		//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
		float forderairportfee=0;
		float forderfulefee=0;
		float forderticketprice=0;
		for(Passenger pass:listpass){
			forderairportfee+=pass.getAirportfee();
			forderfulefee+=pass.getFuelprice();
			forderticketprice+=pass.getPrice();
		}
		//订单总机建费
		orderinfo.setTotalairportfee(forderairportfee);
		//订单总燃油费
		orderinfo.setTotalfuelfee(forderfulefee);
		//订单总票面价
		orderinfo.setTotalticketprice(forderticketprice);
		String strorderid=Server.getInstance().getAtomService().createticketorder(listsegment, listpass, orderinfo);
		
		orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(strorderid));
		
		if(intIsCreateOuterOrder==1){//创建外部订单
		
			Zrate bestzrate = new Zrate();
			orderinfo.setPolicyagentid(6l);
			//匹配最优政策
			bestzrate = Server.getInstance().getRateService().FindZrateByFlight(orderinfo, listsegment.get(0),listpass);
			/*bestzrate.setId(1l);
			bestzrate.setAgentid(5l);
			bestzrate.setRatevalue(11.8f);
			bestzrate.setOutid("2121212");*/
			if (bestzrate != null
					&& bestzrate.getRatevalue() != null
					&& bestzrate.getAgentid() != null) {
				try {
					// 计算价格
					orderinfo
							.setPolicyid(bestzrate.getId());// 政策ID
					/*orderinfo
							.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
									.getRatevalue())));// 分销商返点
*/					
					orderinfo.setFenxiaoshangfandian(0f);// 分销商返点
					orderinfo.setPolicyagentid(bestzrate
							.getAgentid());// 政策提供商id
					
					
						if(bestzrate.getWorkstatus()!=null){
							orderinfo.setPickonename(bestzrate.getWorkstatus());//office
						}
						
						if(bestzrate.getSpeed()!=null){
							if(bestzrate.getAgentid()==5){
								orderinfo.setPickonephone(bestzrate.getSpeed());//出票速度
							}
							if(bestzrate.getAgentid()==6){
								orderinfo.setPickonephone(bestzrate.getSpeed()+"分钟");//出票速度
							}
							}
						
						
						orderinfo
							.setRatevalue(bestzrate
									.getRatevalue());// 折扣
						orderinfo.setExtpolicyid(bestzrate
							.getOutid()); // 外部政策id
					System.out.println("调用最优政策方法,成功,政策为=="
							+ bestzrate);
					
					
					//外部下单
					int IsWhy=1; //0不分润接口   1分润接口
					
					String B2cWebPrice="";//B2C网站利润
					String WebPayPrice="";//C端支付价
					Float Zratevalue=bestzrate.getRatevalue();
					Float Zvalue=Getliudianvalue(bestzrate.getRatevalue());//B2C用户的返点
					System.out.println("Zvalue:"+Zvalue);
					int chengrenNUM=0;
					float baoxianprice=0f;
					float newprice=0f;
					
					listpass=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID DESC ", -1, 0);
					List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
					Segmentinfo seginfo=listseg.get(0);
					for(int p=0;p<listpass.size();p++){
						if (listpass.get(p).getPtype() == 1) {
							chengrenNUM++;
						}
						Passenger passeng=listpass.get(p);
						seginfo.setParvalue(listsegment.get(0).getParvalue());
						if (passeng.getPtype() == 1) {
							/*passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
									.getRatevalue()))/100);*/
							passeng.setPrice(Float.parseFloat(formatMoney_string(listsegment.get(0).getParvalue()-listsegment.get(0).getParvalue()*dceimalFormat(Zvalue)/100+"")));
							seginfo.setPrice(passeng.getPrice());
							
						} else if (passeng.getPtype() == 2) {
							passeng.setAirportfee(0f);
							
							
								passeng.setFuelprice(getRoundPrice(seginfo
										.getFuelfee(), 2));
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(seginfo
											.getParvalue(), 2));
								} else {
									passeng.setPrice(getRoundPrice(seginfo
											.getYprice(), 2));
								}
							
							
						} else {
							passeng.setAirportfee(0f);
							passeng.setFuelprice(0f);
							// 儿童婴儿价
							
							if (seginfo.getDiscount() > 100) {
								passeng.setPrice(getRoundPrice(seginfo
										.getParvalue(), 10));
							} else {
								passeng.setPrice(getRoundPrice(seginfo
										.getYprice(), 10));
							}
							
							
						}
						newprice += passeng.getPrice();
						if(passeng.getInsurprice()!=null){
						baoxianprice+=passeng.getInsurprice();
						}
						
						Server.getInstance().getAirService().updatePassengerIgnoreNull(passeng);
					}
					//seginfo
					Server.getInstance().getAirService().updateSegmentinfoIgnoreNull(seginfo);
					WebPayPrice=chengrenNUM*listsegment.get(0).getParvalue()*(Zratevalue-Zvalue)/100+"";
					if(WebPayPrice.equals("0.0")){
						WebPayPrice="0";
					}else{
						WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
					}
					
					B2cWebPrice=newprice+ orderinfo.getTotalfuelfee()+ orderinfo.getTotalairportfee()+"";
					
					B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
					
					System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice+",baoxianprice:"+baoxianprice);
					
					String bxprice="0";
					if(baoxianprice==0){
						bxprice="0";
					}else{
						bxprice=(Math.floor(Float.parseFloat(baoxianprice+""))+"").substring(0, (Math.floor(Float.parseFloat(baoxianprice+""))+"").indexOf("."));
						
					}
					
					
					WriteLog.write("B2C下单前记录价格信息-匹配最优政策","C支付价格:"+B2cWebPrice+",利润:"+WebPayPrice+",保险价格:"+bxprice);
					orderinfo.setB2cprofit(Integer.parseInt(WebPayPrice)+Integer.parseInt(bxprice)+"");//B2C利润
					orderinfo.setCclientpayprice(B2cWebPrice);//c端支付价
					orderinfo.setIspayhthy(IsWhy);
					//orderinfo.setPolicyagentid(5l);
					orderinfo.setTotalticketprice(newprice);//从新更新票面价
					orderinfo.setFenxiaoshangfandian(Zvalue);
					Segmentinfo segmentinfo=listsegment.get(0);
					segmentinfo.setZrate(bestzrate);
					String strExtOrderNumber = Server.getInstance().getRateService().CreateOrder(orderinfo,segmentinfo, listpass);
					
					if (!strExtOrderNumber.equals("-1")) {
						intIsCreated = 1;
						if (orderinfo.getPolicyagentid() == 5 || orderinfo.getPolicyagentid() == 2) {
							// 返回格式：S|订单号|支付url
							// 外部订单号

							if (strExtOrderNumber.indexOf("|") > 0) {
								String[] strExtOrderArr = strExtOrderNumber
										.split("[|]");
								if (strExtOrderArr.length == 3) {
									if (strExtOrderArr[0].equals("S")) {
										orderinfo
												.setExtorderid(strExtOrderArr[1]);
										orderinfo
												.setPaymenturl(strExtOrderArr[2]);
									}
								}
							}

						} else {
							// 外部订单号
							orderinfo.setExtorderid(strExtOrderNumber);
						}
						// 外部订单状态
						orderinfo.setExtorderstatus(0);
						// 外部订单创建时间
						orderinfo.setExtordercreatetime(new Timestamp(
								System.currentTimeMillis()));
					
						// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
					} else {
						intIsCreated = 0;
						System.out.println("按照本地政策，创建外部订单失败，返回结果:"
								+ strExtOrderNumber);
						isok=0;
						Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfo.getPnr()+"$XEPNR@", "", "");
					}
					
					Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
							
							
							
				} catch (RuntimeException e) {
					System.out
							.println("调用最优政策方法,出现异常,异常信息："
									+ e.getMessage());
					e.printStackTrace();
					isok=0;
					Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfo.getPnr()+"$XEPNR@", "", "");
				}
			}else{
				isok=0;
				
				Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfo.getPnr()+"$XEPNR@", "", "");
			}
			
			
			
		
		}
		
		
		if(isok==1){
			 forword="ticticket!payorder.jspx?orderid=" + Long.parseLong(strorderid);
		}
		else{
			Server.getInstance().getAirService().excutePassengerBySql(" DELETE "+Passenger.TABLE+" where "+Passenger.COL_orderid+" ="+orderinfo.getId());
			Server.getInstance().getAirService().excuteSegmentinfoBySql(" DELETE "+Segmentinfo.TABLE+" where "+Segmentinfo.COL_orderid+" ="+orderinfo.getId());
			Server.getInstance().getAirService().deleteOrderinfo(orderinfo.getId());
			
			forword="ticticket!toerrinfo.jspx";
		}
		return "forword";
	}
	
	public String toerrinfo()
	{
		System.out.println("创建订单失败");
		return "toerrinfo";
	}
	
	
	public String payorder()
	{
		//取得订单信息
		/* orderinfo = this.findBySql(Orderinfo.class, "SELECT ID id,C_RELATIONORDERID relationorderid,C_ORDERSTATUS orderstatus ,C_ORDERNUMBER ordernumber ,C_CONTACTNAME contactname,C_CONTACTMOBILE contactmobile,C_NOTETYPE notetype, ISNULL(C_TOTALTICKETPRICE,0) totalticketprice,C_FKMETHOD fkmethod," +
				"ISNULL(C_TOTALAIRPORTFEE,0) totalairportfee,ISNULL(C_TOTALFUELFEE,0) totalfuelfee," +
				"C_PNR pnr,C_BIGPNR bigpnr,ISNULL(C_CURRPLATFEE,0) currplatfee,ISNULL(INSURANCEPRICE,0) as totalinsurprice" +
				" FROM view_orderinfo WHERE ID="+orderid);*/
		
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderid);
		
		
		//取得乘机人信息
		listpassenger = Server.getInstance().getAirService().findAllPassenger(
				"where 1=1 and " + Passenger.COL_orderid + " ="
				+ orderid, "", -1, 0);
		//成人数量
		int intadultnum=0;
		//儿童数量
		int intchildnum=0;
		//婴儿数量
		int intbabynum=0;
		//成人价格
		float adultprice=0;
		//儿童价格
		float childprice=0;
		//婴儿价格
		float babyprice=0;
		//保险总数量
		int intinsurancenum=0;
		float baoxianprice=0f;
		for(Passenger passenger:listpassenger)
		{
			if(passenger.getPtype()==1)
			{
				intadultnum++;
				adultprice=passenger.getPrice()+passenger.getAirportfee()+passenger.getFuelprice();
				//intinsurancenum+=passenger.getInsurance();
				
			}
			else if(passenger.getPtype()==2)
			{
				intchildnum++;
				childprice=passenger.getPrice()+passenger.getAirportfee()+passenger.getFuelprice();
				//intinsurancenum+=passenger.getInsurance();
			}
			else if(passenger.getPtype()==3)
			{
				intbabynum++;
				babyprice=passenger.getPrice()+passenger.getAirportfee()+passenger.getFuelprice();
				//intinsurancenum+=passenger.getInsurance();
			}
			if(passenger.getInsurprice()!=null){
			baoxianprice+=passenger.getInsurprice();
			}
		}
		
		 //取得订单总价格
		orderinfo.setOrderprice(orderinfo.getTotalticketprice()+baoxianprice+orderinfo.getTotalfuelfee()+orderinfo.getTotalairportfee()); 
		
		
		
		//取得价格详情
		orderpricedtail=intadultnum+"成人×"+formatMoneyToInt(adultprice);
		if(intchildnum>0)
		{
			orderpricedtail+="+"+intchildnum+"儿童×"+formatMoneyToInt(childprice);
		}
		if(intbabynum>0)
		{
			orderpricedtail+="+"+intbabynum+"婴儿×"+formatMoneyToInt(babyprice);
		}
			orderpricedtail+="+"+intinsurancenum+"保险×20";
		//取得航程信息
		listsegmentinfo = Server.getInstance().getAirService().findAllSegmentinfo(
				"where 1=1 and " + Segmentinfo.COL_orderid + " ="
						+ orderid, "", -1, 0);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("billname", "Airpayhelper");//对应接口中 支付辅助类 必传
		map.put("orderid", orderinfo.getId());//订单id 必传
	    if(ServletActionContext.getServletContext().getAttribute("vmoneyservice")!=null){//判断是否有虚拟账户业务
		map.put("actionname", "b2bticketorder!vmoneyAirticketpay.action");		
		System.out.println(orderinfo.getId());
		boolean vpay=false;//虚拟账户支付禁用
		float totalprice=this.orderinfo.getOrderprice();
		
		map.put("vmpayenable", vpay);//如果可虚拟账户支付 传入当前账户余额 
	    }
	    map.put("orderprice", orderinfo.getOrderprice());
		request.setAttribute("ordermap", map);//传值....
		
		return "success";
	}
	
	
	
	/**
	 * 将json字符串转换程Segmentinfo集合
	 * 
	 * @param strJson
	 *            json字符串,选中航程信息
	 * @return Segmentinfo集合
	 * @author 陈星
	 * @createtime 2011-11-21
	 */
	public List<Segmentinfo> getSelectedSegment(String strJson)
	{
		String[] ArrSegment={};
		// 字符串转换成Json对象
		ArrSegment=s_jasonsegmentinfo.split("@");
        for(int j=0;j<ArrSegment.length;j++)
        {
			JSONObject jsonSegmentinfo = JSONObject.fromObject(ArrSegment[j].toString());
			JSONArray jsons = jsonSegmentinfo.getJSONArray("segmentinfos");
			System.out.println("Json航程个数:"+jsonSegmentinfo.size());
			// 循环对航程信息类赋值
			for(int i=0;i<jsons.size();i++)
			{
				JSONObject segmentJson = JSONObject.fromObject(jsons.get(i));
				System.out.println("Segment个数:"+segmentJson.getString("flightnumber"));
				// 航程赋值
				Segmentinfo segment=new Segmentinfo();
				// 航空公司代码
				segment.setAircomapnycode(segmentJson.getString("aircomapnycode"));
				// 航班号
				segment.setFlightnumber(segmentJson.getString("flightnumber"));
				// 航空公司名称
				segment.setAircompanyname(segmentJson.getString("airname"));
				// 机建费
				segment.setAirportfee(Float.parseFloat(converNull(segmentJson.getString("airportfee"),0f).toString()));
				// 燃油费
				segment.setFuelfee(Float.parseFloat(converNull(segmentJson.getString("fuelfee"),0f).toString()));
				// 出发时间
				segment.setDeparttime(dateToTimestamp(segmentJson.getString("departtime")));
				// 到达时间
				segment.setArrivaltime(dateToTimestamp(segmentJson.getString("arrivaltime")));
				// 舱位代码
				segment.setCabincode(segmentJson.getString("cabincode"));
				// 折扣
				segment.setDiscount(Float.parseFloat(converNull(segmentJson.getString("discount"),0f).toString()));
				// 出发机场三字代码
				segment.setStartairport(segmentJson.getString("startairport"));
				// 出发机场名称
				segment.setStartairportname(segmentJson.getString("startairportname"));
				// 到达机场三字代码
				segment.setEndairport(segmentJson.getString("endairport"));
				// 到达机场名称
				segment.setEndairportname(segmentJson.getString("endairportname"));
				// 机型
				segment.setFlightmodel(segmentJson.getString("flightmodel"));
				// 机型描述
				segment.setFlightdesc(segmentJson.getString("flightdesc"));
				// 价格
				segment.setParvalue(Float.parseFloat(converNull(segmentJson.getString("price"),0f).toString()));
				
				
				// 退改签规定
				segment.setRules(segmentJson.getString("rules"));
				// 航程类型
				segment.setTraveltype(Integer.parseInt(segmentJson.getString("traveltype")));
				// 全价价格
				segment.setYprice(Float.parseFloat(converNull(segmentJson.getString("yprice"),0f).toString()));
				
				//出发航站楼
				segment.setBorderpointat(segmentJson.getString("borderpointat"));
				
				//到达航站楼
				segment.setOffpointat(segmentJson.getString("offpointat"));
				//政策ID
				String Zrateid="1";
				Zrateid=segmentJson.getString("zrateid");
				//当前返点
				String ZrateValue="0";
				ZrateValue=segmentJson.getString("parvalue");
				
				segment.setZrateid(Long.parseLong(Zrateid));
				segment.setRatevalue(Float.parseFloat(ZrateValue));
				
				// 价格
				segment.setPrice(Float.parseFloat(formatMoney_string(segment.getParvalue()-segment.getParvalue()*segment.getRatevalue()/100+"")));
				System.out.println("票面价:"+segment.getParvalue()+",结算价:"+segment.getPrice());
				
				lissegtempt.add(segment);
			}
        }
		return lissegtempt;
	}
	
	public List<Passenger>  getSelectedPassenger(String strJson)
	{
		List<Passenger> list=new ArrayList<Passenger>();
		//字符串转换成Json对象
		s_jsonpassengers=s_jsonpassengers.replace("[", "{\"passengers\":[").toString().replace("]", "]}");
    	JSONObject jsonSegmentinfo = JSONObject.fromObject(s_jsonpassengers);
		JSONArray jsons = jsonSegmentinfo.getJSONArray("passengers");
		for(int i=0;i<jsons.size();i++)
		{
			JSONObject passJson = JSONObject.fromObject(jsons.get(i));
			System.out.println("Passenger姓名:"+passJson.getString("Name"));
			Passenger passenger=new Passenger();
			passenger.setName(passJson.getString("Name"));
			passenger.setPtype(Integer.parseInt(converNull(passJson.getString("Type"),1).toString()));
			passenger.setIdtype(Integer.parseInt(converNull(passJson.getString("Idcardtype"),1).toString()));
			passenger.setIdnumber(passJson.getString("Idcardnumber"));
			//passenger.setInsurance(Long.parseLong(converNull(passJson.getString("Insurancenum"),0).toString()));
			passenger.setInsurprice(Float.parseFloat(converNull(passJson.getString("Insurancemoney"),0).toString()));
			passenger.setPrice(Float.parseFloat(converNull(passJson.getString("Ticketprice"),0).toString()));
			passenger.setAirportfee(Float.parseFloat(converNull(passJson.getString("Airportprice"),0).toString()));
			passenger.setFuelprice(Float.parseFloat(converNull(passJson.getString("Fuelprice"),0).toString()));
			passenger.setIssave(Integer.parseInt(converNull(passJson.getString("Issave"),1).toString()));
			list.add(passenger);
		}
		return list;
	}
	
	/**
	 * 异步取得常用旅客Json格式数据
	 * @throws Exception
	 */
	public void getPassCredit() throws Exception
	{
		String idnumber="";
		
		try {
			String strwhere="where "+Customercredit.COL_refid+"="+id;
			List<Customercredit> listcredit=Server.getInstance().getMemberService().findAllCustomercredit(strwhere, "order by "+Customercredit.COL_credittypeid+" desc", -1, 0);
			if(listcredit.size()>0)
			{
				for(Customercredit credit:listcredit)
				{
					if(idcardtype==credit.getCredittypeid())
					{
					 idnumber=credit.getCreditnumber();
					}
				}
			}
			else
			{
				idnumber="";
			}
			HttpServletResponse response=ServletActionContext.getResponse();
			PrintWriter out=response.getWriter();
			out.print(idnumber);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 进入国内机票页面
	 * 
	 * @author gaoliang
	 * @Date 2011-11-21
	 * @return 国内机票页面
	 * @throws Exception
	 */
	public String toTicket() throws Exception {

		/*IpUtil ipUtil=new IpUtil();
		ipUtil.GetIpByAdders();*/
		String RemoteAddrIP="";
		//RemoteAddrIP= ServletActionContext.getRequest().getRemoteAddr(); 
		RemoteAddrIP=GetIpByAdders();
		System.out.println("来到了国内机票页面!!!"+RemoteAddrIP);
		// 从缓存中得到航空公司信息
		listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		// 查询帮助信息
		// 添加人:陈星
		// 添加时间:2011-11-21
		seachInfocontent();
		// 查询资讯信息
		// 添加人:陈星
		// 添加时间:2011-11-21
		seachInformationinfo();
		return "toticket";

	}
	
	

	/**
	 * 未来30天最低价查询
	 * 
	 * @return 未来30天数据
	 * @author gaoliang
	 * @Date 2011-11-21
	 * @throws Exception
	 */
	public void getflashdata() throws Exception {

		HttpServletRequest requestIP = ServletActionContext.getRequest();
		String userip = getRemortIP(requestIP);
		//System.out.println("访问IP===" + userip);
		userip = "183.60.161.17:8800";
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();// 获得本机IP
		String date = "";
		StringBuffer buffer = new StringBuffer();
		try {

			URL url = new URL(
					"http://jipiao.quna.com/ShowChartServlet?srcCity="
							+ s_depcitycode + "&dstCity=" + s_arrcitycode
							+ "&randno=" + randno);

			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Accept-Charset", "utf-8");
			InputStream inputStream = urlConnection.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream, "utf-8"));

			while ((date = reader.readLine()) != null) {
				buffer.append(date + "\n");
			}

			// JSONObject o = JSONObject.fromObject(buffer.toString());
			System.out.println("date===" + date);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		String strReturn = "";
		strReturn = buffer.toString();
		// 正则表达式替换url链接
		
		/*s_arrcityname=getAirCityNamebySZM(s_arrcitycode);
		s_depcityname=getAirCityNamebySZM(s_depcitycode);
		
		String sname = new String(s_arrcityname.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("sname=="+sname);
		s_arrcityname=sname;
		
		String ename = new String(s_depcityname.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("ename=="+ename);
		s_depcityname=ename;*/
		
		strReturn = strReturn
				.replaceAll(
						"[h][t][t][p][:][/][/][j][i][p][i][a][o][.][q][u][n][a][.][c][o][m][/][a-zA-Z]{1,}[/][a-zA-Z]{3}[_][a-zA-Z]{3}[_][0-9]{8}[.][h][t][m][l]",
						"http://"
								+ "www.yusyak.com:8088"
								+ "/Ebooking/ticticket!toTicketList.jspx?s_depcitycode="
								+ s_depcitycode + "&s_arrcitycode=" + s_arrcitycode
								+ "&s_startdate=2011-5-6&s_traveltype=1"+"&s_depcityname="+s_depcityname+"&s_arrcityname="+s_arrcityname);

		strReturn = strReturn.replace("dc3912", "0066FF").replace("红点", "蓝点");

		// 将代理商名称替换
		String[] strarr = getAgentName(strReturn, s_depcitycode, s_arrcitycode).split(",");
		for (int i = 0; i < strarr.length; i++) {
			if (strarr[i].length() > 0) {
				strReturn = strReturn.replace(strarr[i], "");
			}
		}
		out.print(getRightFlightDate(strReturn));
		out.flush();
		out.close();
		
	}
   
	  public String getAgentName(String strData, String strFromCity, String strToCity)
	    {
	        String strReturn = "";
	        // 正则表达式解析
	        String strPrice = "";
	        String strAirCompanyCode = "";
	        String strAirCompanyName = "";
	        String strTime = "";
	        String strDate = "";
	        String strDiscount = "";
	        String strAgentName = "";

	        // 第一步 使用values来分，第一项：样式信息，第二项：所有低价信息
	        Pattern pairAll = Pattern.compile("[v][a][l][u][e][s]");
			String[] airAll=pairAll.split(strData);

	        // 第二步 使用value来分，将第二项低价信息拆分成数组
			Pattern pairdetails=Pattern.compile("[v][a][l][u][e]");
			
	        String[] airdetails = pairdetails.split(airAll[1]);

	        for (int i = 1; i < airdetails.length; i++)
	        {
	            // 第三步 使用,来拆分每一项
	            String[] airItems = airdetails[i].split(",");
	            if (airItems.length >= 2)
	            {
	                strPrice = airItems[0].replace("\":", "");
	                Pattern pairotheritem=Pattern.compile("\n");
	                String[] airotheritem = pairotheritem.split(airItems[1]);
	                try
	                {
	                    // 中国联合航空公司KN2948
	                    strAirCompanyName = airotheritem[0].replace("\"tip\":\"", "");
	                    // 折扣
	                    String[] strTemp1 = airotheritem[1].split("[(]");
	                    strDiscount = strTemp1[1].replace(")", "");
	                    // 日期
	                    String[] strTemp2 = airotheritem[2].split("[(]");
	                    strDate = strTemp2[0].replace("[)]", "");
	                    // 时间
	                    strTime = airotheritem[4];
	                    strAgentName = airotheritem[5];

	                    strReturn += strAgentName.replace("\"", "") + ",";
	                }
	                catch(Exception ex)
	                {
	                }

	            }
	        }

	        return strReturn;

	    }
	
	
	public String getRemortIP(HttpServletRequest request) {

		if (request.getHeader("x-forwarded-for") == null) {
			//System.out.println("IP==" + request.getRemoteAddr());
			return request.getRemoteAddr();

		}
		//System.out.println("IP2==" + request.getHeader("x-forwarded-for"));
		return request.getHeader("x-forwarded-for");

	}

	protected String getRightFlightDate(String strData) {
		String strReturn = "";
		// 正则表达式解析
		String strPrice = "";
		String strAirCompanyCode = "";
		String strAirCompanyName = "";
		String strTime = "";
		String strDate = "";
		String strDiscount = "";
		String strAgentName = "";
		String strTemp = "";

		// 第一步 使用values来分，第一项：样式信息，第二项：所有低价信息
		Pattern pairAll = Pattern.compile("[v][a][l][u][e][s]");
		String[] airAll = pairAll.split(strData);

		// 第二步 使用value来分，将第二项低价信息拆分成数组
		Pattern pairdetails = Pattern.compile("[v][a][l][u][e]");
		String[] airdetails = pairdetails.split(airAll[1]);
		strTemp += airdetails[0] + "value";
		for (int i = 1; i < airdetails.length; i++) {
			// 第三步 使用,来拆分每一项
			String[] airItems = airdetails[i].split(",");
			if (airItems.length >= 2) {
				strPrice = airItems[0].replace("\":", "");
				Pattern pairotheritem = Pattern.compile("\n");
				String[] airotheritem = pairotheritem.split(airItems[1]);
				try {
					// 中国联合航空公司KN2948
					strAirCompanyName = airotheritem[0].replace("\"tip\":\"",
							"");
					// 折扣
					String[] strTemp1 = airotheritem[1].split("[(]");
					strDiscount = strTemp1[1].replace("[)]", "");
					// 日期
					String[] strTemp2 = airotheritem[2].split("[(]");
					strDate = strTemp2[0].replace("[)]", "");
					// 时间
					strTime = airotheritem[4];
					strAgentName = airotheritem[5];
				} catch (Exception ex) {
				}
			}

			strTemp += airdetails[i].replace("2011-5-6", strDate) + "value";

		}
		strReturn = airAll[0] + "values" + strTemp;
		return strReturn;

	}
	
	public void ajaxgetLowersegment() throws Exception {
		getLowsegment();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(this.lowersegmentstr);
		out.flush();
		out.close();
	}
	
	public void getLowsegment() throws Exception{
		HttpServletRequest rquest = ServletActionContext.getRequest();
		s_depcitycode = rquest.getParameter("fromcity");
		if (!isNotNullOrEpt(s_depcitycode)) {
			s_depcitycode = "PEK";// 默认北京。
		}
		Timestamp today = new Timestamp(System.currentTimeMillis());
		Timestamp tomorrowafter = new Timestamp(System.currentTimeMillis());
		tomorrowafter.setDate(today.getDate() + 3);
		this.setS_startdate(super.formatTimestamp(today));
		this.setS_backdate(super.formatTimestamp(tomorrowafter));
		this.setS_depcitycode(s_depcitycode);
		this.pageinfo.setPagerow(30);
		this.setPageinfo(pageinfo);
		List listlower = this.getLowerSegment();
		String currenycity = "";
		for (Object obj : listlower) {
			Map<String, List<Map>> lowermap = new HashMap<String, List<Map>>();
			Map map = (HashMap) obj;
			String tocity = converNull(map.get("TOCITY"), "").toString();
			if (currenycity.equals(tocity) || tocity.equals("")) {
				continue;
			} else {
				List<Map> list = new ArrayList<Map>();
				for (Object objs : listlower) {
					Map m = (HashMap) objs;
					if (tocity.equals(converNull(m.get("TOCITY"), "-1")
							.toString())) {
						list.add(m);
					}
					if (list.size() == 3)
						break;
				}
				currenycity = tocity;
				lowermap.put(tocity, list);
				lowersegment.add(lowermap);

			}

		}
			this.lowersegmentstr = this.getLowsegmentHtml();	

		
		
	}
	/**
	 * @return 获得特价机票
	 */
	public List getLowerSegment(){
		String sql="SELECT TOP 30 * FROM view_lowestprice WHERE 1=1";
		if(isNotNullOrEpt(s_arrcitycode)){
			sql+=" AND C_TOCITY='"+s_arrcitycode+"'";
		}
		if(isNotNullOrEpt(s_depcitycode)){
			sql+=" AND C_FROMCITY='"+s_depcitycode+"'";
		}
		String time=this.getCheckTime(s_startdate, s_backdate, "C_FROMDATE");
		if(isNotNullOrEpt(time)){
			sql+=" AND ("+time +")";
		}	
		System.out.println("sql=="+sql);
	  List list= Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	  return list;
	}
	public String getLowsegmentHtml() throws Exception {
		StringBuffer buffer = new StringBuffer();
		System.out.println(lowersegment.size());
		if (lowersegment.size() == 0) {
			buffer
					.append("<td width=\"660\" height=\"150\" align='center'>暂无数据"
							+ "</td>");
		} else {
			for (int i = 0; i < 2; i++) {
				buffer.append("<td width=\"220\" valign='top'>");
				buffer
						.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"line-height:16px;\">");
				for (int j = 0; j < 3; j++) {
					Map map = new HashMap();
					try {
						map = (HashMap) lowersegment.remove(0);
					} catch (Exception e) {
						break;
					}
					Map.Entry<String, List> entry = (Map.Entry<String, List>) map
							.entrySet().iterator().next();
					buffer.append("<tr>");
					buffer
							.append("<td rowspan=\"2\"><img src=\"images/sanjiao.gif\" width=\"13\" height=\"31\" align=\"absmiddle\" />");
					buffer.append(entry.getKey());
					buffer.append("</td>");
					List list = entry.getValue();
					String date = "";

					for (Object obj : list) {
						Map m = (HashMap) obj;

						buffer
								.append("<td class=\"huangf60_x\"  style=\"cursor: pointer;color:red;\""
										+ " onclick=\"loading('航班信息');window.location.href='ticticket!toTicketList.jspx?s_depcitycode="
										+ s_depcitycode
										+ "&s_arrcitycode="
										+ m.get("C_TOCITY").toString()
										+ "&s_startdate="
										+ formatStringTimetoyyyymmdd(m.get(
												"C_FROMDATE").toString())
										+ "&s_traveltype=1'\">&yen;"
										+ formatMoneytoone(Float
												.valueOf(converNull(
														m.get("C_PRICE"), 0)
														.toString())) + "</td>");
						date += "<td class=\"lan06c\">"
								+ formatStringTime(m.get("C_FROMDATE")
										.toString()) + "</td>";
					}
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append(date);
					buffer.append("</tr>");
					buffer
							.append("<tr><td class=\"he16\" colspan=\"4\">&nbsp;</td></tr>");
				}
				buffer.append("</table>");
				buffer.append("</td>");
			}
		}
		return buffer.toString();
	}
	

	/**
	 * 根据帮助信息类型ID查询NAME
	 * 
	 * @author 陈星
	 * @Date 2011-11-21
	 * @param id
	 *            帮助信息类型ID
	 * @param
	 * @return 帮助信息类型name
	 */
	public String GetInfoTypeNameById(long id){
		
		return Server.getInstance().getMemberService().findHelpcenter(id).getName();
	}
	/**
	 * 查询帮助信息
	 * 
	 * @author 陈星
	 * @Date 2011-11-21
	 * @param
	 * @param
	 * @return 帮助信息列表
	 */
	public void seachInfocontent(){
		
		String where =" where 1=1 and "+Helpcenterinfo.COL_typeid+" = ( SELECT "+Helpcenter.COL_id+" FROM "+Helpcenter.TABLE+" where "+Helpcenter.COL_name+" ='相关信息')";
		Listhelpcenterinfo =Server.getInstance().getMemberService().findAllHelpcenterinfo(where, " ORDER BY ID DESC ", 20, 0);
		if(Listhelpcenterinfo.size()>0){
		typeid=Listhelpcenterinfo.get(0).getTypeid();
		}
	}
	/**
	 * 查询最新资讯信息
	 * 
	 * @author 陈星
	 * @Date 2011-11-21
	 * @param
	 * @param
	 * @return 资讯信息列表
	 */
	public void seachInformationinfo(){
		
		/*String where=" where 1=1 ";
		ListInformationinfo=Server.getInstance().getMemberService().findAllInformationinfo(where, " ORDER BY ID DESC ", 7, 0);*/
		String where = " where 1=1 and " + Helpcenterinfo.COL_typeid
		+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
		+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
		+ " ='机票最新资讯')";
		
		ListInformationinfo=Server.getInstance().getMemberService().findAllHelpcenterinfo(where, " ORDER BY ID DESC ", 7, 0);
	
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getS_traveltype() {
		return s_traveltype;
	}

	public void setS_traveltype(int s_traveltype) {
		this.s_traveltype = s_traveltype;
	}

	public String getS_depcitycode() {
		return s_depcitycode;
	}

	public void setS_depcitycode(String s_depcitycode) {
		this.s_depcitycode = s_depcitycode;
	}

	public String getS_arrcitycode() {
		return s_arrcitycode;
	}

	public void setS_arrcitycode(String s_arrcitycode) {
		this.s_arrcitycode = s_arrcitycode;
	}

	public String getS_startdate() {
		return s_startdate;
	}

	public void setS_startdate(String s_startdate) {
		this.s_startdate = s_startdate;
	}

	public String getS_backdate() {
		return s_backdate;
	}

	public void setS_backdate(String s_backdate) {
		this.s_backdate = s_backdate;
	}

	public List<FlightInfo> getListFlightInfoAll() {
		return listFlightInfoAll;
	}

	public void setListFlightInfoAll(List<FlightInfo> listFlightInfoAll) {
		this.listFlightInfoAll = listFlightInfoAll;
	}

	public String getS_aircompanycode() {
		return s_aircompanycode;
	}

	public void setS_aircompanycode(String s_aircompanycode) {
		this.s_aircompanycode = s_aircompanycode;
	}

	public List<Aircompany> getListAirCompany() {
		return listAirCompany;
	}

	public void setListAirCompany(List<Aircompany> listAirCompany) {
		this.listAirCompany = listAirCompany;
	}


		public List<Helpcenterinfo> getListhelpcenterinfo() {
		return Listhelpcenterinfo;
	}

	public void setListhelpcenterinfo(List<Helpcenterinfo> listhelpcenterinfo) {
		Listhelpcenterinfo = listhelpcenterinfo;
	}

		public long getTypeid() {
			return typeid;
		}

		public void setTypeid(long typeid) {
			this.typeid = typeid;
		}

		public List<Informationinfo> getListInformationinfo() {
			return ListInformationinfo;
		}

		public void setListInformationinfo(List<Informationinfo> listInformationinfo) {
			ListInformationinfo = listInformationinfo;
		}

		public String getS_jasonsegmentinfo() {
			return s_jasonsegmentinfo;
		}

		public void setS_jasonsegmentinfo(String s_jasonsegmentinfo) {
			this.s_jasonsegmentinfo = s_jasonsegmentinfo;
		}

		public String getS_depcityname() {
			return s_depcityname;
		}

		public void setS_depcityname(String s_depcityname) {
			this.s_depcityname = s_depcityname;
		}

		public String getS_arrcityname() {
			return s_arrcityname;
		}

		public void setS_arrcityname(String s_arrcityname) {
			this.s_arrcityname = s_arrcityname;
		}

		public String getRandno() {
			return randno;
		}

		public void setRandno(String randno) {
			this.randno = randno;
		}

		public Integer getIsBackOrTo() {
			return isBackOrTo;
		}

		public void setIsBackOrTo(Integer isBackOrTo) {
			this.isBackOrTo = isBackOrTo;
		}

		public FlightSearch getFlightSearch() {
			return flightSearch;
		}

		public void setFlightSearch(FlightSearch flightSearch) {
			this.flightSearch = flightSearch;
		}

		public List<Segmentinfo> getListsegmentinfo() {
			return listsegmentinfo;
		}

		public void setListsegmentinfo(List<Segmentinfo> listsegmentinfo) {
			this.listsegmentinfo = listsegmentinfo;
		}

		public int getS_travelflag() {
			return s_travelflag;
		}

		public void setS_travelflag(int s_travelflag) {
			this.s_travelflag = s_travelflag;
		}

		public String getLowersegmentstr() {
			return lowersegmentstr;
		}

		public void setLowersegmentstr(String lowersegmentstr) {
			this.lowersegmentstr = lowersegmentstr;
		}

		public List getLowersegment() {
			return lowersegment;
		}

		public void setLowersegment(List lowersegment) {
			this.lowersegment = lowersegment;
		}

		public String getS_prevdate() {
			return s_prevdate;
		}

		public void setS_prevdate(String s_prevdate) {
			this.s_prevdate = s_prevdate;
		}

		public String getS_nextdate() {
			return s_nextdate;
		}

		public void setS_nextdate(String s_nextdate) {
			this.s_nextdate = s_nextdate;
		}

		public String getS_prevshortdate() {
			return s_prevshortdate;
		}

		public void setS_prevshortdate(String s_prevshortdate) {
			this.s_prevshortdate = s_prevshortdate;
		}

		public String getS_nextshortdate() {
			return s_nextshortdate;
		}

		public void setS_nextshortdate(String s_nextshortdate) {
			this.s_nextshortdate = s_nextshortdate;
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

		public String getS_contactname() {
			return s_contactname;
		}

		public void setS_contactname(String s_contactname) {
			this.s_contactname = s_contactname;
		}

		public String getS_contactmobile() {
			return s_contactmobile;
		}

		public void setS_contactmobile(String s_contactmobile) {
			this.s_contactmobile = s_contactmobile;
		}

		public String getS_contactemail() {
			return s_contactemail;
		}

		public void setS_contactemail(String s_contactemail) {
			this.s_contactemail = s_contactemail;
		}

		public int getS_contacttype() {
			return s_contacttype;
		}

		public void setS_contacttype(int s_contacttype) {
			this.s_contacttype = s_contacttype;
		}

		public int getS_rrtickettype() {
			return s_rrtickettype;
		}

		public void setS_rrtickettype(int s_rrtickettype) {
			this.s_rrtickettype = s_rrtickettype;
		}

		public int getS_paymethod() {
			return s_paymethod;
		}

		public void setS_paymethod(int s_paymethod) {
			this.s_paymethod = s_paymethod;
		}

		public int getS_sendtickettype() {
			return s_sendtickettype;
		}

		public void setS_sendtickettype(int s_sendtickettype) {
			this.s_sendtickettype = s_sendtickettype;
		}

		public String getS_jsonpassengers() {
			return s_jsonpassengers;
		}

		public void setS_jsonpassengers(String s_jsonpassengers) {
			this.s_jsonpassengers = s_jsonpassengers;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public int getIdcardtype() {
			return idcardtype;
		}

		public void setIdcardtype(int idcardtype) {
			this.idcardtype = idcardtype;
		}

		public String getForword() {
			return forword;
		}

		public void setForword(String forword) {
			this.forword = forword;
		}

		public Orderinfo getOrderinfo() {
			return orderinfo;
		}

		public void setOrderinfo(Orderinfo orderinfo) {
			this.orderinfo = orderinfo;
		}

		public List<Passenger> getListpassenger() {
			return listpassenger;
		}

		public void setListpassenger(List<Passenger> listpassenger) {
			this.listpassenger = listpassenger;
		}

		public long getOrderid() {
			return orderid;
		}

		public void setOrderid(long orderid) {
			this.orderid = orderid;
		}

		public String getOrderpricedtail() {
			return orderpricedtail;
		}

		public void setOrderpricedtail(String orderpricedtail) {
			this.orderpricedtail = orderpricedtail;
		}

		public List<Useraddress> getListaddress() {
			return listaddress;
		}

		public void setListaddress(List<Useraddress> listaddress) {
			this.listaddress = listaddress;
		}

		public String getS_postname() {
			return s_postname;
		}

		public void setS_postname(String s_postname) {
			this.s_postname = s_postname;
		}

		public String getS_postmobile() {
			return s_postmobile;
		}

		public void setS_postmobile(String s_postmobile) {
			this.s_postmobile = s_postmobile;
		}

		public String getS_postaddress() {
			return s_postaddress;
		}

		public void setS_postaddress(String s_postaddress) {
			this.s_postaddress = s_postaddress;
		}

		public String getS_postprovince() {
			return s_postprovince;
		}

		public void setS_postprovince(String s_postprovince) {
			this.s_postprovince = s_postprovince;
		}

		public String getS_postzipcode() {
			return s_postzipcode;
		}

		public void setS_postzipcode(String s_postzipcode) {
			this.s_postzipcode = s_postzipcode;
		}

		public String getS_sendaddress() {
			return s_sendaddress;
		}

		public void setS_sendaddress(String s_sendaddress) {
			this.s_sendaddress = s_sendaddress;
		}

		public String getS_senddate() {
			return s_senddate;
		}

		public void setS_senddate(String s_senddate) {
			this.s_senddate = s_senddate;
		}

		public String getS_sendtime() {
			return s_sendtime;
		}

		public void setS_sendtime(String s_sendtime) {
			this.s_sendtime = s_sendtime;
		}

		public String getS_sendhour() {
			return s_sendhour;
		}

		public void setS_sendhour(String s_sendhour) {
			this.s_sendhour = s_sendhour;
		}

		public String getS_ziquaddress() {
			return s_ziquaddress;
		}

		public void setS_ziquaddress(String s_ziquaddress) {
			this.s_ziquaddress = s_ziquaddress;
		}













		public List<Segmentinfo> getLissegtempt() {
			return lissegtempt;
		}













		public void setLissegtempt(List<Segmentinfo> lissegtempt) {
			this.lissegtempt = lissegtempt;
		}













		public String getS_cabincode() {
			return s_cabincode;
		}













		public void setS_cabincode(String s_cabincode) {
			this.s_cabincode = s_cabincode;
		}













		public String getS_flightnumber() {
			return s_flightnumber;
		}













		public void setS_flightnumber(String s_flightnumber) {
			this.s_flightnumber = s_flightnumber;
		}













		public String getZ_price() {
			return z_price;
		}













		public void setZ_price(String z_price) {
			this.z_price = z_price;
		}

		public String getZ_zratevalue() {
			return z_zratevalue;
		}








		public void setZ_zratevalue(String z_zratevalue) {
			this.z_zratevalue = z_zratevalue;
		}








		public String getZ_zrateid() {
			return z_zrateid;
		}








		public void setZ_zrateid(String z_zrateid) {
			this.z_zrateid = z_zrateid;
		}







}
