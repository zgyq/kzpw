/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.fairport.Fairport;
import com.yf.system.base.fairway.Fairway;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.fflight.AllFlight;
import com.yf.system.base.fflight.AllRouteInfo;
import com.yf.system.base.fflight.Fflight;
import com.yf.system.base.fflight.Route;
import com.yf.system.base.fflight.RouteDetailInfo;
import com.yf.system.base.interflightinfo.InterFlightInfo;
import com.yf.system.base.interflightinfo.InterFlightSearch;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;


public class InterticketAction extends B2b2cbackAction {
	
	AllRouteInfo allroteinfo=new AllRouteInfo();
	// 航程信息List
	private List<Segmentinfo> listsegmentinfo=new ArrayList<Segmentinfo>();
	
	private List<Segmentinfo> lissegtempt=new ArrayList<Segmentinfo>();
	
	
	
	
	//航程类型
	private int intTravelType=1;
	//出发城市
	private String fromCity;
	//到达城市
	private String toCity;
	//出发城市三字码
	private String StartAirportCode;
	//到达城市三字码
	private String EndAirportCode;
	//出发日期
	private String fromDate;
	//返程日期
	private String returnDate;
	//乘机人类型 0成人 1留学生
	private String passengerType;
	//乘客人数
	private String adultCount;
	//舱位等级 Y=经济舱 C商务舱 F=头等舱
	private String seatType;
	
	//中转类型  0所有  1直飞  2非直飞  
	private String TypeFlag;
	
	//排序类型  Price,DepartureTime,ArrivalTime,FlightDuration
	private String SortingField="Price";
	//排序顺序  ASC,DESC
	private String Direction="ASC";//
	
	
	
	//航班列表页面Html
	private String s_listpagehtml;
	//选中的航段ID
	private String s_HfSelectRoutID;
	//选中的航班ID
	private String s_HfFlightID;
	private String s_HfSelectFligID;
	private List<Fflight> FlightWebList=new ArrayList<Fflight>();
	//取得常用旅客信息
	private List<Customeruser> listcustomeruser;
    private String s_totalPrice="0";
    //国际信息
    private  List<Fcountry> listcountry;
    //国籍信息下拉框
    private String s_Country;
    //联系人姓名
    private String s_contactname;
    //联系手机
    private String s_contactmobile;
    //联系电话
    private String s_contactphone;
    //联系电子邮件
    private String s_contactemail;
    //备注说明
    private String s_memo;
    
    
    private int s_iscreateorder=0;//是否创建外部订单   0不创建  1创建
    
    
    //临时ID
	Long idtemp = 0l;
    //隐藏域
    private String s_hidname;
    private String s_hidstudent;
    private String s_hidcardtype;
    private String s_hidcardnumber;
    private String s_hidcardvaldate;
    private String s_hidcountry;
    private String s_hidcountryname;
    private String s_hidgender;
    private String s_hidbirthday;
    private String s_hidzipcode;
    private String s_hidtargetaddress;
    private String s_hidliveaddress;
    private String s_hidcitycode;
    private String s_hidguesttype;
    private String s_price="0";
    private String s_tax="0";
    private String s_chlidprice="0";
    
    
    private int s_seachtype=0;//0为今日查询   1为携程查询
    //订单详细信息
    private Orderinfo orderinfo=new Orderinfo();
    //航程详细信息
    private List<Fflight> listsegment;
    //乘机人详细信息
	private List<Passenger> listpassenger;
	private String forword;
	private Long s_orderid;
    
    
	// 航程信息Jason字符串
	private String s_jasonsegmentinfo;
	
	private String s_jsonpassengers;
	
	
	private  List<InterFlightInfo> listInterFlightInfo=new ArrayList<InterFlightInfo>();
	
	/**
	 * 国际机票首页
	 */	
	public String execute()throws Exception{
		return "index";
	}
	
	/**
	 * 国际航班查询
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception
	{
		//调用国际机票接口查询航班
		//修改单反航程类别 高亮 2011-12-23
		String type1=String.valueOf(intTravelType);
		//AllRouteInfo listrouteinfo=Server.getInstance().getAtomService().interTicketSearch(StartAirportCode, EndAirportCode, fromDate,returnDate, seatType,type1);
		//ActionContext.getContext().getSession().put("AllRouteInfo",listrouteinfo);
		//将航班数据显示在页面上
		//loadDataToList(listrouteinfo,fromCity,toCity,StartAirportCode, EndAirportCode, fromDate,returnDate, seatType,adultCount,passengerType);
		
		InterFlightSearch interFlightSearch=new InterFlightSearch();
		System.out.println(StartAirportCode+EndAirportCode+fromDate);
		interFlightSearch.setFromDate(fromDate.replaceAll("-", "/"));//出发日期
		if(intTravelType==2){
			interFlightSearch.setBackDate(returnDate.replaceAll("-", "/"));//返回日期
		}
		interFlightSearch.setTravelType(intTravelType+"");
		//TravelType
		//interFlightSearch.settr
		
		interFlightSearch.setStartAirportCode(StartAirportCode);
		interFlightSearch.setEndAirportCode(EndAirportCode);
		interFlightSearch.setTransferType(TypeFlag);
		interFlightSearch.setSortingField(SortingField);
		interFlightSearch.setDirection(Direction);
		String cabinClass="Economy";
		if(seatType.equals("Y")){
			cabinClass="Economy";
		}
		if(seatType.equals("C")){
			cabinClass="Business";
		}
		if(seatType.equals("F")){
			cabinClass="First";
		}
		if(s_seachtype==1){
			interFlightSearch.setCabinClass(cabinClass);//经济舱Economy/超级经济舱Premium/商务舱Business/头等舱First  
		}else{
			interFlightSearch.setCabinClass(seatType);//经济舱Economy/超级经济舱Premium/商务舱Business/头等舱First  
		}
		
		interFlightSearch.setFromTime(s_seachtype+"");//用作判断接口类型了
		
		/*interFlightSearch.setFromDate("2014/10/28");//出发日期
		interFlightSearch.setStartAirportCode("SIA");
		interFlightSearch.setEndAirportCode("HKG");
		interFlightSearch.setTransferType("0");*/
		if(s_seachtype==1){
			//Server.getInstance().setUrlAtom("http://www.90youxue.com:8080/interface/service/");
		}
		Server.getInstance().setUrlAtom("http://www.90youxue.com:8080/interface/service/");
		listInterFlightInfo=Server.getInstance().getAtomService().interTicketSearchNew(interFlightSearch);
		
		if(s_seachtype==1){
			Server.getInstance().setUrlAtom("http://127.0.0.1:8080/interface/service/");
		}
		
		
		
		System.out.println(SortingField+"----"+Direction);
		
		if(s_seachtype==1){
			return "ticketlist_ctrip";
		}else{
		return "ticketlist";
		}
	}
	
	/**
	 * 国际航班查询
	 * @return
	 * @throws Exception
	 */
	public String search_cx() throws Exception
	{
		//调用国际机票接口查询航班
		//修改单反航程类别 高亮 2011-12-23
		String type1=String.valueOf(intTravelType);
		AllRouteInfo listrouteinfo=Server.getInstance().getAtomService().interTicketSearch(StartAirportCode, EndAirportCode, fromDate,returnDate, seatType,type1);
		ActionContext.getContext().getSession().put("AllRouteInfo",listrouteinfo);
		//将航班数据显示在页面上
		loadDataToList(listrouteinfo,fromCity,toCity,StartAirportCode, EndAirportCode, fromDate,returnDate, seatType,adultCount,passengerType);
		return "ticketlist";
	}
	

     /**
      * 航班数据显示在页面上
      * @param listrouteinfo  航班查询结果
      * @param StartAirportCode 出发城市三字码
      * @param EndAirportCode   到达城市三字码
      * @param fromDate         出发日期
      * @param returnDate       返程日期
      * @param seatType         舱位等级
      * @param adultCount       成人数量
      * @param passengerType    乘机人类型
      */
     public void loadDataToList(AllRouteInfo listrouteinfo,String fromCity,String toCity,String StartAirportCode,String EndAirportCode,String fromDate,String returnDate,String seatType,String adultCount,String passengerType)
     {
    	 intTravelType=1;
    	 //航程类型
    	 if(!returnDate.equals(""))
    	 {
    		 intTravelType=2;
    	 }
    	 StringBuilder sbHtmlList = new StringBuilder("");
    	 try
    	 {
	    	 sbHtmlList.append("<table width='75%' border='0' cellspacing='0' cellpadding='0' class='csstab' id='ordert'>");
	    	 String strTravelType="单程";
	    	 String strReturn=" ";
	    	 String strCityPair="";
	    	 if(intTravelType==1)
	    	 {
	    		 
	    		 strTravelType="单程";
	    		 strCityPair=fromCity+"-"+toCity;
	    		 
	    	 }
	    	 else if(intTravelType==2)
	    	 {
	    		 strTravelType="往返程";
	    		 strReturn="返程日期:"+returnDate;
	    		 strCityPair=fromCity+"-"+toCity+" "+toCity+"-"+fromCity;
	    		 
	    	 }
	    	 sbHtmlList.append("<tr style='background-color:#F5F2DF;height:40px'><td colspan='5'><font size='3px'  weight='bold'>"+strTravelType+":"+strCityPair+" 出发日期："+fromDate+" "+strReturn+"</font></td></tr>");
	    	 sbHtmlList.append("<tr style='background-color:#198BC9;color:white;font-weight:bold'><td align='center' width='20'><font color='white' weight='bold'>价格</font></td><td align='center' width='25%'><font color='white'>航空公司</font></td><td align='center' width='15%'><font color='white' >乘客类型</font></td><td align='center' width='25%'><font color='white'>中转城市</font></td><td align='center'><font color='white'>操作</font></td></tr>");
	    	 if(listrouteinfo.getRoutes().size()>0)
	    	 {
	    		 //循环出所有航班
	    		 int introutetIndex = 0;
	    		 for(Route routeeach:listrouteinfo.getRoutes())
	    		 {
	    			 introutetIndex++;
	                 sbHtmlList.append("<tr><td colspan='5' class='postbgnew'><input id='routeID_" + introutetIndex + "' type='hidden' value='" + introutetIndex + "'></td></tr>");
	                 sbHtmlList.append("<tr height='30px' style='background-color:#F8F8F0;'><td align='center' width='20%'><font color='#F48000'><b>￥" + routeeach.getTotalFare() + "</b></font></td>");
	                 //航空公司名称
	                 String strAirCo = getAirCompanyNamebyCode(routeeach.getAirCompany());
	                 sbHtmlList.append("<td align='center' width='25%'><span class='airco_"+routeeach.getAirCompany()+"'>" + strAirCo + "</span></td>");
	                  //乘客类型
	                 String strGuestTName = "";
	                 if (passengerType.equals("0"))
	                 {
	                     strGuestTName = "成人";
	                 }
	                 else if (passengerType.equals("1"))
	                 {
	                     strGuestTName = "留学生";
	                 }
	                 sbHtmlList.append("<td align='center' width='15%'>" + strGuestTName + "</td>");
	                 //取得中转地
	                 String strChangeCity = "";
	                 if (routeeach.getIsChangeFlight()>=1)
	                 {
	                     strChangeCity = getCityNamebyCode(routeeach.getRouteDetailInfos().get(0).getDestCity());
	                 }
	                 else
	                 {
	                     strChangeCity = "直飞";
	                 }
	                 String strHideCss = "";
	                 String strZhan = "";
	                 String src = "";
	                 String strFlag="0";
	                 if (introutetIndex == 1)
	                 {
	                     strHideCss = "";
	                     strZhan = "收起";
	                     src = "images/nofollow.gif";
	                     strFlag="1";
	                 }
	                 else
	                 {
	                     strHideCss = "style='display:none'";
	                     strZhan = "详细";
	                     src = "images/plus.gif";
	                     strFlag="0";
	                 }
	                 sbHtmlList.append("<td align='center' width='25%'>中转地：" + strChangeCity + "</td>");
	                 sbHtmlList.append("<td align='center' width='20%'><a href='javascript:showrouteInfo(" + introutetIndex + ")'><img id='img" + introutetIndex + "' src='" + src + "' width='13px' height='13px' />&nbsp;<span id='span_" + introutetIndex + "'><b>" + strZhan + "</b></span></a></td></tr>");
	                 sbHtmlList.append("<tr><td colspan='5'><hr class='hr2' /></td></tr>");
	                 sbHtmlList.append("<tr id='route_" + introutetIndex + "'><td colspan='5' align='center'><input type='hidden' value='"+strFlag+"' id='routeflag_"+introutetIndex+"' />");
	                 //航班详细信息隐藏层
	                 //循环所有航班信息
	                 int intFlightIndex = 0;
	                 sbHtmlList.append("<table width='90%' style='background-color:#FEFFD7' border='0' class='csstab' cellspacing='0' cellpadding='0'>");
	                 sbHtmlList.append("<tr><td valign='top'>");
	                 for(RouteDetailInfo routeDetailEach:routeeach.getRouteDetailInfos())
	                 {
	                	 intFlightIndex++;
	                	 
	                     sbHtmlList.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='tdrouteDetail_" + intFlightIndex + "'>");
	                     //去程信息
	                	 if(intTravelType==2 && routeDetailEach.getFromCity().equals(StartAirportCode))
	                	 {
	                		 sbHtmlList.append("<tr><td colspan='3' align='left'><span style=' background:url(images/icon_num.gif) no-repeat; height:17px; width:17px; color:#FFFFFF;margin-right:5px; padding:1px 5px;'>1</span><b>去程:"+fromCity+"-"+toCity+" "+fromDate+"</b></td><td></td></tr>");
	                	 }
	                	 else if(intTravelType==2 && routeDetailEach.getFromCity().equals(EndAirportCode))
	                	 {
	                		 sbHtmlList.append("<tr><td colspan='3' align='left'><span style=' background:url(images/icon_num.gif) no-repeat; height:17px; width:17px; color:#FFFFFF;margin-right:5px; padding:1px 5px;'>2</span><b>返程:"+toCity+"-"+fromCity+" "+returnDate+"</b></td><td></td></tr>");
	                	 }
	                     sbHtmlList.append("<tr style='background-color:#DDF1AA;height:30px'><td>航班号</td><td>起抵时间</td><td>起抵机场</td><td></td></tr>");
	                     sbHtmlList.append("<tr id='trrouteDetail_" + introutetIndex + "_" + intFlightIndex + "' style='background-color:#FEFFD7'>");
	                     sbHtmlList.append("<td align='center' width='20%'>" + routeDetailEach.getFlightNumber() + "<input id='HidFlightNo_" + intFlightIndex + "' type='hidden' value='1' /></td>");
                         String[] strFromDateArr = routeDetailEach.getFromDate().split(",");
                         String strFrDate = strFromDateArr[0].toString();
                         String strFrTime = strFromDateArr[1].toString().substring(0, 2)+":"+strFromDateArr[1].toString().substring(2, 4);
                         
                         String[] strToDateArr = routeDetailEach.getToDate().split(",");
                         String strTDate = strToDateArr[0].toString();
                         String strTTime = strToDateArr[1].toString().substring(0, 2)+":"+strToDateArr[1].toString().substring(2, 4);
	                     sbHtmlList.append("<td align='center' width='30%'>" + strFrDate+" "+strFrTime + "<br />" + strTDate+" "+strTTime + " </td>");
	                     //起飞抵达机场
	                     String strFormAirport = getAirPortNamebyCode(routeDetailEach.getFromAirport());
	                     String strEndAirPort = getAirPortNamebyCode(routeDetailEach.getToAirport());
	                     sbHtmlList.append("<td align='center' width='30%'>" + strFormAirport + "<br />" + strEndAirPort + "</td>");
	                     if (routeDetailEach.getTotalFlightNo()!=0 && routeDetailEach.getTotalFlightNo() != 1 && routeDetailEach.getTotalFlightNo() != -1)
	                     {
	                         sbHtmlList.append("<td align='center' width='20%'><span style='cursor:pointer' id='divOther_" + introutetIndex + "_" + intFlightIndex + "'><a style='color:#F48000' onclick=\"showOtherFlight(" + intFlightIndex + "," + routeDetailEach.getTotalFlightNo() + "," + introutetIndex + ",'divOther_" + introutetIndex + "_" + intFlightIndex + "');\" >选择其他" + routeDetailEach.getTotalFlightNo() + "个航班</a></span></td>");
	                     }
	                     else
	                     {
	                         sbHtmlList.append("<td align='center' width='20%'></td>");
	                     }
	                     
	                     sbHtmlList.append("</tr>");
	                     int intdex=intFlightIndex-1;
	                     if(intdex!=routeeach.getRouteDetailInfos().size()-1)
	                     {
	                        sbHtmlList.append("<tr height='5px'><td colspan='4'><hr class='hr1' /></td></tr>");
	                     }
	                     sbHtmlList.append("</table>");
	                 }
	                 sbHtmlList.append("</td><td valign='top'>");
	                 
	                 sbHtmlList.append("<table border='0' cellspacing='0' cellpadding='0' width='100%' height='100%'>");
	               //去程信息
                	 if(intTravelType==2)
                	 {
                		 sbHtmlList.append("<tr style='background-color:#FEFFD7;'><td>&nbsp;</td></td></tr>");
                	 }
                	
	                 sbHtmlList.append("<tr style='background-color:#DDF1AA;height:30px'><td>预订</td></tr>");

	                 sbHtmlList.append("<tr style='background-color:#FEFFD7;'><td>成人价：￥"+routeeach.getTotalFare()+"(不含税)</td></tr>");
	                 sbHtmlList.append("<tr style='background-color:#FEFFD7;'><td>儿童价：￥"+routeeach.getTotalChlidFare()+"(不含税)</td></tr>");
	                 sbHtmlList.append("<tr style='background-color:#FEFFD7;'><td>税费：￥"+routeeach.getTotalTax()+"</td></tr>");
	                 sbHtmlList.append("<tr style='background-color:#FEFFD7' id='routeb_" + introutetIndex + "'><td><input type='button' class='button_tj' value='预订此价格' onclick='javascript:gotoBook(" + introutetIndex + "," + intFlightIndex + ")'>&nbsp;</td></tr>");
	                 sbHtmlList.append("<tr style='background-color:#FEFFD7;'><td><a id='limit_"+introutetIndex+"' style='color:#F48000' href=\"javascript:showLimit('"+introutetIndex+"','"+routeeach.getPolicyInfo()+"')\">查看订票规则</a></td></tr></table></td></tr>");
	                 sbHtmlList.append("</table>");
	                 sbHtmlList.append("</td></tr>");
	                 
	                
	                 sbHtmlList.append("</td></tr>");
	                 
	                 sbHtmlList.append("<tr><td colspan='5'>");
	                 int intHidFlightIndex = 0;
	                 int intIsShowFlightNum=0;
	                 String strFlightNums="";
	                 for(RouteDetailInfo routeDetailEach:routeeach.getRouteDetailInfos())
	                 {
	                	 intHidFlightIndex++;
	                	 strFlightNums+=routeDetailEach.getFlightNumber()+",";
	                     if (routeDetailEach.getTotalFlightNo() !=1)
	                     {
	                    	 sbHtmlList.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='tbHidFlight_" + introutetIndex + "_" + intHidFlightIndex + "'  style='display:none;margin-bottom:10px'><tr style='background-color:#f6f9fc' height='30px'><td style='width:25%' align='center'>航空公司</td><td style='width:10%' align='center'>航班号</td><td style='width:15%' align='center'>出发时间</td><td style='width:15%' align='center'>到达时间</td><td style='width:15%' align='center'>出发机场</td><td style='width:15%' align='center'>到达机场</td><td  align='center'>选择</td></tr>");
	                         //循环出航段内所有的可选航班信息
	                    	 for(AllFlight FlightEach:routeDetailEach.getFlightInfos())
	                    	 {
	                    		 intIsShowFlightNum++;
	                    		 if(strFlightNums.indexOf(FlightEach.getFlightNumber())<0)
	                    		 {
	                    		  //拼出弹出层
	                             sbHtmlList.append("<tr height='4px'>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("</tr>");
	                             sbHtmlList.append("<tr id='trOtherFlight_" + FlightEach.getNo() + "'>");
	                             
	                             //航空公司名称
	                             String strAirCoName = getAirCompanyNamebyCode(FlightEach.getAirCompany());
	                             sbHtmlList.append("<td align='center'>" + strAirCoName + "<input type='hidden' id='txthidAN_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strAirCoName + "' /></td>");
	                             sbHtmlList.append("<td align='center'>" + FlightEach.getFlightNumber() + "<input type='hidden' id='txthidFN_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + FlightEach.getFlightNumber() + "' /></td>");
	                             String[] strFromDateArr = FlightEach.getFromDate().split(",");
	                             String strFrDate = strFromDateArr[0].toString();
	                             String strFrTime = strFromDateArr[1].toString().substring(0, 2)+":"+strFromDateArr[1].toString().substring(2, 4);
	                             
	                             String[] strToDateArr = FlightEach.getToDate().split(",");
	                             String strTDate = strToDateArr[0].toString();
	                             String strTTime = strToDateArr[1].toString().substring(0, 2)+":"+strToDateArr[1].toString().substring(2, 4);
	                             sbHtmlList.append("<td align='center'>" + strFrDate + "<input type='hidden' id='txthidFD_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strFrDate + "' /><br />" + strFrTime + "<input type='hidden' id='txthidFT_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strFrTime + "' /></td>");
	                             sbHtmlList.append("<td align='center'>" + strTDate + "<input type='hidden' id='txthidTD_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strTDate + "' /><br />" + strTTime + "<input type='hidden' id='txthidTT_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strTTime + "' /></td>");
	                             
	                             String strFormAirport = getAirPortNamebyCode(routeDetailEach.getFromAirport());
	                             String strEndAirPort = getAirPortNamebyCode(routeDetailEach.getToAirport());
	                             sbHtmlList.append("<td align='center'>" + strFormAirport + "<input type='hidden' id='txthidFA_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strFormAirport + "' /></td>");
	                             sbHtmlList.append("<td align='center'>" + strEndAirPort + "<input type='hidden' id='txthidEA_" + introutetIndex + "_" + intHidFlightIndex + "_" + FlightEach.getNo() + "' value='" + strEndAirPort + "' /></td>");
	                             String strChecked = "";
	                             if (intIsShowFlightNum== 1)
	                             {
	                                 strChecked = "checked='checked'";
	                             }
	                             else
	                             {
	                                 strChecked = "";
	                             }
	                             sbHtmlList.append("<td align='center'><input type='radio' id='rdoCheck_" + FlightEach.getNo() + "' "+strChecked+" name='rdoCheck' value='" + FlightEach.getNo() + "' onclick='BindRdoValue(this," + introutetIndex + "," + intHidFlightIndex + "," + FlightEach.getNo() + ");'></td>");
	                             sbHtmlList.append("</tr>");
	                             sbHtmlList.append("<tr height='10px'>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("<td align='center'></td>");
	                             sbHtmlList.append("</tr>");
	                    		 }
	                    	 }
	                    	 sbHtmlList.append("<tr>");
	                         sbHtmlList.append("<td align='center' colspan='7'><table border='0' width='80%'><tr><td align='right'><input type='button' class='button_tj' value='预订选中航班' onclick='BindOtherFlight(" + routeDetailEach.getTotalFlightNo() + ");' />&nbsp;&nbsp;&nbsp;</td><td align='left'><input type='button' class='button_tj' value='返回列表页面' onclick='closeOtherFlight();' /></td></tr></table></td>");
	                         sbHtmlList.append("</tr>");
	                         sbHtmlList.append("</table>");
	                     }
	                 }
	                 sbHtmlList.append("</td></tr>");
	                 sbHtmlList.append("<tr class='postbgnew'><td colspan='5' align='right'></td></tr>");
	                 
	    		 }
	    	 }
	    	 else
	    	 {
	    		 sbHtmlList.append("<tr class='postbgnew'><td colspan='5'><font color='red' size='4px'>抱歉！没有您要查找的航线...</font></td></tr>");
	    	 }
	    	 sbHtmlList.append("</table>");
	    	 s_listpagehtml=sbHtmlList.toString();
    	 }
    	 catch(Exception ex)
    	 {
    		 s_listpagehtml = "<font size='4px' color='red'>非常抱歉，您查询的 "+fromCity+" 至 "+toCity+" 的航线目前无法进行查询和预订！</font>";
    	 }
     }
     /**
      * 绑定选中航班信息，跳转到下单页面
      * @return
      * @throws Exception
      */
     public String toCreateInterTicketOrder2() throws Exception
     {
    	
    	  listsegmentinfo=new ArrayList<Segmentinfo>();
    	  listsegmentinfo=getSelectedSegment(s_jasonsegmentinfo);
 		  System.out.println("Json转换完成:"+listsegmentinfo.toString());
 		
    	 
    	 return "createorder";
     }
     public List<Segmentinfo> getSelectedSegment(String strJson)
 	{
 		String[] ArrSegment={};
 		// 字符串转换成Json对象
 		ArrSegment=strJson.split("@");
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
 				String sday=segmentJson.getString("sday");
 				
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
 				//segment.setDeparttime(dateToTimestamp(sday.substring(0, 4)+"-"+segmentJson.getString("departtime")+":00"));
 				segment.setDeparttime(dateToTimestamp(segmentJson.getString("departtime")));
 				// 到达时间
 				//segment.setArrivaltime(dateToTimestamp(sday.substring(0, 4)+"-"+segmentJson.getString("arrivaltime")+":00"));
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
 				segment.setFlightdesc(segmentJson.getString("flightdesc"));//现在存放验仓信息
 				// 价格
 				segment.setParvalue(Float.parseFloat(converNull(segmentJson.getString("yprice"),0f).toString()));
 				
 				segment.setPrice(Float.parseFloat(converNull(segmentJson.getString("price"),0f).toString()));
 				
 				// 退改签规定
 				segment.setRules(segmentJson.getString("rules"));//现在存放ED了-下单用
 				// 航程类型
 				segment.setTraveltype(Integer.parseInt(segmentJson.getString("traveltype")));
 				// 全价价格
 				segment.setYprice(Float.parseFloat(converNull(segmentJson.getString("yprice"),0f).toString()));
 				
 				//出发航站楼
 				segment.setBorderpointat(segmentJson.getString("borderpointat"));
 				
 				//到达航站楼
 				segment.setOffpointat(segmentJson.getString("offpointat"));
 				//政策ID
 				
 				//当前返点
 				String ZrateValue="0";
 				ZrateValue=segmentJson.getString("parvalue");
 				
 				//segment.setZrateid(Long.parseLong(Zrateid));
 				//System.out.println("Zrateid:"+Zrateid);
 				//segment.setZrateid(Long.parseLong(Zrateid));//普通政策id
 				//segment.setAgentid(Long.parseLong(Zrateid.split("-")[1]));//特殊政策id
 				segment.setRatevalue(Float.parseFloat(ZrateValue));
 				
 				String qiangzhibaoxian=segmentJson.getString("qiangzhibaoxian");
 				segment.setIsspecial(Integer.parseInt(qiangzhibaoxian));
 				
 				
 				
 				
 				// 价格
 				//segment.setPrice(Float.parseFloat(formatMoney_string(segment.getParvalue()-segment.getParvalue()*segment.getRatevalue()/100-segment.getIsspecial()+"")));
 				System.out.println("票面价:"+segment.getParvalue()+",结算价:"+segment.getPrice()+",ED:"+segment.getRules());
 				
 				//ZrateServer.getInstance().setUrl("http://211.149.173.11:28080");
 				
 				
 				
 			    //String ret=	GetRestrictions(segment.getAircomapnycode(), segment.getCabincode(), formatStringTimetoyyyymmdd(segment.getDeparttime()+""));
 				
 			   /* String ret="";
 			    
 				 Zrate zrate_bendi=ZrateServer.getInstance().findZrate(0l, segment.getZrateid()+"$*");
 				if(zrate_bendi!=null&&zrate_bendi.getRemark()!=null&&zrate_bendi.getGeneral()==2){
 					segment.setRules(zrate_bendi.getRemark());
 					segment.setRules(ret);
 					segment.setZrate(zrate_bendi);
 				}else{
 					if(ret!=null&&ret.trim().length()>0){
 						segment.setRules(ret);
 					}else{
 					segment.setRules("按照航空公司规定退改签!!!");
 					}
 				}*/
 				
 				lissegtempt.add(segment);
 			}
         }
 		return lissegtempt;
 	}
     
     
   //授权
 	public void Valada_Cabin_Pice() throws Exception {
 			System.out.println("验证仓位价格");
 			String strReturn="";
 			
 			listsegmentinfo=getSelectedSegment(s_jasonsegmentinfo);
 			strReturn=Server.getInstance().getAtomService().interTicket_valadateprice(listsegmentinfo);
 			HttpServletResponse response = ServletActionContext.getResponse();
 			response.setContentType("text/plain; charset=utf-8");
 			PrintWriter out = response.getWriter();
 			StringBuilder sb = new StringBuilder();
 			sb.append(strReturn);
 			out.print(sb);
 			out.flush();     
 			out.close();
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
 			if(passenger.getIdtype()==1){//身份证
 				if(passenger.getIdnumber().length()>=16){
 				String birthday = passenger.getIdnumber().substring(6,14);
 				passenger.setBirthday(birthday.substring(0, 4)+"-"+birthday.substring(4, 6)+"-"+birthday.substring(6, 8));
 				}
 			}else{
 				passenger.setBirthday(passJson.getString("shengri").toString());
 			}
 			//passenger.setAnjianfee(Float.parseFloat(converNull(passJson.getString("oneprice"),0).toString()));//
 			//passenger.setTuifee(Float.parseFloat(converNull(passJson.getString("twoprice"),0).toString()));//
 			passenger.setLanguage(0);
 			passenger.setCountry(passJson.getString("guoji").toString());
 			passenger.setCardvaliddate(passJson.getString("youxiaoqi").toString());//证件有效期
 			passenger.setDestzipcode(passJson.getString("sex").toString());//性别
 			list.add(passenger);
 		}
 		return list;
 	}
 	
     /**
      * 绑定选中航班信息，跳转到下单页面
      * @return
      * @throws Exception
      */
     public String toCreateInterTicketOrder() throws Exception
     {
    	 int intRouteID =Integer.parseInt(s_HfSelectRoutID);
         int intFlightID =Integer.parseInt(s_HfFlightID);
         String[] strFligIDArr=s_HfSelectFligID.replace("|", ",").split(",");
         int intFlightLength = strFligIDArr.length;
         //查询出的航班数据
         AllRouteInfo listrouteinfo=(AllRouteInfo)ActionContext.getContext().getSession().get("AllRouteInfo");
         
         List<Route> RouteWeb=listrouteinfo.getRoutes();
         List<RouteDetailInfo> RouteDetailWeb=RouteWeb.get(intRouteID-1).getRouteDetailInfos();
         Double dtotalpare=0d;
         for (int i = 0; i < RouteDetailWeb.size(); i++)
         {
        	 List<AllFlight> AllFlightWeb=RouteDetailWeb.get(i).getFlightInfos();
        	 Fflight FlightWebClass=new Fflight();
        	 FlightWebClass.setTotalfare(RouteWeb.get(intRouteID - 1).getTotalFare()); //销售价
        	 FlightWebClass.setTotaltax(RouteWeb.get(intRouteID - 1).getTotalTax()); //税费
        	 FlightWebClass.setPolicymark(RouteWeb.get(intRouteID - 1).getPolicyInfo()); // 政策
        	 int intOIndex = Integer.parseInt(strFligIDArr[i].toString());
        	 FlightWebClass.setAircom(RouteWeb.get(intRouteID - 1).getAirCompany());  //航空公司
        	 FlightWebClass.setCw(RouteDetailWeb.get(i).getCabin());
        	 FlightWebClass.setFromairport(RouteDetailWeb.get(i).getFromAirport());
        	 FlightWebClass.setToairport(RouteDetailWeb.get(i).getToAirport());
        	 String[] strFromDateArr =RouteDetailWeb.get(i).getFromDate().split(",");  //起飞时间
        	 String strFrDate = strFromDateArr[0].toString();
             String strFrTime = strFromDateArr[1].toString().substring(0, 2)+":"+strFromDateArr[1].toString().substring(2, 4);
             String strFromDate=strFrDate+" "+strFrTime;
        	 FlightWebClass.setFromdate(dateToTimestamp2(strFromDate));
        	 String[] strToDateArr = RouteDetailWeb.get(i).getToDate().split(",");  //到达时间
             String strTDate = strToDateArr[0].toString();
             String strTTime = strToDateArr[1].toString().substring(0, 2)+":"+strToDateArr[1].toString().substring(2, 4);
             String strToDate=strTDate+" "+strTTime;
        	 FlightWebClass.setTodate(dateToTimestamp2(strToDate));
        	 FlightWebClass.setFlightnumber(RouteDetailWeb.get(i).getFlightNumber());
        	 FlightWebList.add(FlightWebClass);
         }
         
         //取得常用旅客信息--取出当前登录代理商所有会员信息
         String strwhere="where "+Customeruser.COL_membertype+"=1 and "+Customeruser.COL_isenable+"=1 and "+Customeruser.COL_agentid+"="+getLoginUser().getAgentid()+" and "+Customeruser.COL_membername+" is not null";
         listcustomeruser=Server.getInstance().getMemberService().findAllCustomeruser(strwhere, "ORDER BY ID DESC", 5, 0);
         if( RouteDetailWeb.size()>0)
         {
        	 dtotalpare=RouteWeb.get(intRouteID - 1).getTotalFare()+RouteWeb.get(intRouteID - 1).getTotalTax();
         }
         
         s_totalPrice=dtotalpare.toString();
         s_price=String.valueOf(RouteWeb.get(intRouteID - 1).getTotalFare());//销售价
         s_tax=String.valueOf(RouteWeb.get(intRouteID - 1).getTotalTax()); //税费
         s_chlidprice=String.valueOf(RouteWeb.get(intRouteID - 1).getTotalChlidFare()); //儿童票价
         //取得国籍信息
         getAllCountry();
         
         ActionContext.getContext().getSession().put("FlightList",FlightWebList);
         
         
    	 return "createorder";
     }
     
     /**
      * 创建国际机票订单
      * @return
      * @throws Exception
      */
     public String CreateOrder() throws Exception
     {
    	 System.out.println("CreateOrder");
    	 //****************************1.国际订单信息赋值开始****************************//
    	 //联系人姓名
    	 orderinfo.setContactname(s_contactname);
    	 //联系人手机
    	 orderinfo.setContactmobile(s_contactmobile);
    	 //联系人电子邮件
    	 orderinfo.setContactemail(s_contactemail);
    	 //联系人座机
    	 orderinfo.setContacttel(s_contactphone);
    	 //备注说明
    	 orderinfo.setMemo(s_memo);
    	 orderinfo.setPnr("123456");
    	 orderinfo.setBigpnr("123456");
    	 //采购商ID
    	 orderinfo.setBuyagentid(getLoginUser().getAgentid());
    	 //供应商ID
    	 orderinfo.setSaleagentid(46l);
    	 //创建时间
    	 orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
    	 //采购商员工id
    	 orderinfo.setCustomeruserid(getLoginUser().getId());
    	 //订单状态
    	 orderinfo.setOrderstatus(1); //待确认状态
    	 //订单类型-后台订单
    	 orderinfo.setOrdertype(2l);
    	 //支付方式
    	 orderinfo.setPaymethod(1);
    	 //支付状态
    	 orderinfo.setPaystatus(0);
    	 orderinfo.setPolicyagentid(6l);
    	 orderinfo.setPolicyid(0l);
    	 orderinfo.setLanguage(0);
    	 orderinfo.setTotalairportfee(0f);
    	// orderinfo.setTotalfuelfee(Float.parseFloat(s_tax));
    	// orderinfo.setTotalticketprice(Float.parseFloat(s_price));
    	 orderinfo.setInternal(1l);  //是否是国际票
    	 
    	 orderinfo.setRatevalue(0f);
    	 
    	 orderinfo.setFenxiaoshangfandian(0f);
    	 
    	 orderinfo.setRebatemoney(0f);
    	 
    	 //创建订单信息
    	 orderinfo =Server.getInstance().getAirService().createOrderinfo(orderinfo);
    	 idtemp = orderinfo.getId();
    	 //取得订单号
    	 orderinfo.setOrdernumber(Server.getInstance().getServiceCenter().getOrderinfoCode(orderinfo));
    	 //更新订单信息
    	
    	 
    	 
    	 //****************************2.航程信息赋值开始****************************//
    	 //读取航程信息
    	listsegmentinfo=new ArrayList<Segmentinfo>();
   	  	listsegmentinfo=getSelectedSegment(s_jasonsegmentinfo);
   	  	
    	 //循环所有航程
    	 if(listsegmentinfo!=null && listsegmentinfo.size()>0)
    	 {
    		 for(int a=0;a<listsegmentinfo.size();a++)
    		 {
	    		 Segmentinfo segmeng=listsegmentinfo.get(a);
	    		 segmeng.setAgentid(getLoginUser().getAgentid());
	    		 segmeng.setIsspecial(0);
	    		 segmeng.setOrderid(orderinfo.getId()); //订单ID
	    		 //segmeng.setParvalue(0f);
	    		 segmeng.setRatevalue(0f);
	    		 segmeng.setTraveltype(1); //单程
	    		 segmeng.setLanguage(0);
	    		 //创建航程信息
	    		 Server.getInstance().getAirService().createSegmentinfo(segmeng);
    		 }
    	 }
    	 
    	 
    	//****************************3.乘机人信息赋值开始****************************//
    	 
    	 List<Passenger>listpass=getSelectedPassenger(s_jsonpassengers);
    	 
    	 Float allticketprice=0f;
    	 Float allfueeprice=0f;
    	 Float totalinsurprice=0f;
    	 for (int i = 0; i < listpass.size(); i++)
    	 {
    		 Passenger passenger=listpass.get(i);
    		 passenger.setDiscount(0f);
    		 passenger.setState(0);
    		 passenger.setOrderid(orderinfo.getId()); //订单ID
    		 allticketprice+=passenger.getPrice();
    		 allfueeprice+=passenger.getAirportfee();
    		 totalinsurprice+=passenger.getInsurprice();
    		 //创建乘机人信息
    		 Server.getInstance().getAirService().createPassenger(passenger);
    		 
    		 
    	 }
    	 
    	 
    	 orderinfo.setTotalfuelfee(allfueeprice);
     	 orderinfo.setTotalticketprice(allticketprice);
     	 orderinfo.setTotalinsurprice(totalinsurprice);
     	 
     	orderinfo.setReceipt(1);//政策类型  普通 特殊
     	//****************************乘机人信息赋值结束****************************//
     	
     	
     	if(s_iscreateorder==1){//创建外部订单
     		System.out.println("开始创建国际机票订单外部订单");
    		 String ret=Server.getInstance().getAtomService().interTicket_createorder(listsegmentinfo, listpass, orderinfo);
    		 System.out.println("创建国际机票订单外部订单返回:"+ret);
    		 if(!ret.equals("-1")){
    			 orderinfo.setPnr(ret.split("@")[1].trim());
    			 orderinfo.setBigpnr(ret.split("@")[1].trim());
    			 orderinfo.setExtorderid(ret.split("@")[0].trim());
    		 }
    	 }
     	
     	
    	 
     	 Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
     	 
    	// forword = "interticket!toSuccess.action?s_orderid="+ orderinfo.getId();
     	 
     	 
     	 
     	 
     	 
     	 
     	 
     	forword = "b2bticketorder!topayorder.action?id="+ orderinfo.getId();
    	
    	 return "forword";
     }
     /**
      * 创建国际机票订单
      * @return
      * @throws Exception
      */
     public String CreateOrder2() throws Exception
     {
    	 //****************************1.国际订单信息赋值开始****************************//
    	 //联系人姓名
    	 orderinfo.setContactname(s_contactname);
    	 //联系人手机
    	 orderinfo.setContactmobile(s_contactmobile);
    	 //联系人电子邮件
    	 orderinfo.setContactemail(s_contactemail);
    	 //联系人座机
    	 orderinfo.setContacttel(s_contactphone);
    	 //备注说明
    	 orderinfo.setMemo(s_memo);
    	 orderinfo.setPnr("NOPNR");
    	 orderinfo.setBigpnr("NOPNR");
    	 //采购商ID
    	 orderinfo.setBuyagentid(getLoginUser().getAgentid());
    	 //供应商ID
    	 orderinfo.setSaleagentid(46l);
    	 //创建时间
    	 orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
    	 //采购商员工id
    	 orderinfo.setCustomeruserid(getLoginUser().getId());
    	 //订单状态
    	 orderinfo.setOrderstatus(27); //待确认状态
    	 //订单类型-后台订单
    	 orderinfo.setOrdertype(2l);
    	 //支付方式
    	 orderinfo.setPaymethod(1);
    	 //支付状态
    	 orderinfo.setPaystatus(0);
    	 orderinfo.setPolicyagentid(6l);
    	 orderinfo.setPolicyid(0l);
    	 orderinfo.setLanguage(0);
    	 orderinfo.setTotalairportfee(0f);
    	 orderinfo.setTotalfuelfee(Float.parseFloat(s_tax));
    	 orderinfo.setTotalticketprice(Float.parseFloat(s_price));
    	 orderinfo.setInternal(1l);  //是否是国际票
    	 //创建订单信息
    	 orderinfo =Server.getInstance().getAirService().createOrderinfo(orderinfo);
    	 idtemp = orderinfo.getId();
    	 //取得订单号
    	 orderinfo.setOrdernumber(Server.getInstance().getServiceCenter().getOrderinfoCode(orderinfo));
    	 //更新订单信息
    	 Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
    	 
    	 
    	 //****************************2.航程信息赋值开始****************************//
    	 //读取航程信息
    	 listsegment=(List<Fflight>)ActionContext.getContext().getSession().get("FlightList");
    	 //循环所有航程
    	 if(listsegment!=null && listsegment.size()>0)
    	 {
    		 for(Fflight flight:listsegment)
    		 {
	    		 Segmentinfo segmeng=new Segmentinfo();
	    		 segmeng.setAgentid(getLoginUser().getAgentid());
	    		 segmeng.setAircomapnycode(flight.getAircom());
	    		 segmeng.setAircompanyname(getAirCompanyNamebyCode(flight.getAircom()));
	    		 segmeng.setAirportfee(0f);
	    		 segmeng.setFuelfee(Float.parseFloat(s_tax));
	    		 segmeng.setPrice(Float.parseFloat(s_price));
	    		 segmeng.setDeparttime(flight.getFromdate());
	    		 segmeng.setArrivaltime(flight.getTodate());
	    		 segmeng.setCabincode(flight.getCw());
	    		 segmeng.setDiscount(0f);
	    		 segmeng.setStartairport(flight.getFromairport());
	    		 segmeng.setEndairport(flight.getToairport());
	    		 segmeng.setFlightmodelnum("");
	    		 segmeng.setFlightnumber(flight.getFlightnumber());
	    		 segmeng.setIsspecial(0);
	    		 segmeng.setOrderid(orderinfo.getId()); //订单ID
	    		 segmeng.setParvalue(0f);
	    		 segmeng.setRatevalue(0f);
	    		 segmeng.setTraveltype(1); //单程
	    		 segmeng.setLanguage(0);
	    		 segmeng.setYprice(Float.parseFloat(s_price));
	    		 //创建航程信息
	    		 Server.getInstance().getAirService().createSegmentinfo(segmeng);
    		 }
    	 }
    	 
    	 
    	//****************************3.乘机人信息赋值开始****************************//
    	 int guestCount = s_hidname.split(",").length;
    	 for (int i = 0; i < guestCount; i++)
    	 {
    		 Passenger passenger=new Passenger();
    		 passenger.setName(s_hidname.split(",")[i].trim());
    		 passenger.setIdtype(Integer.parseInt(s_hidcardtype.split(",")[i].trim()));
    		 passenger.setIdnumber(s_hidcardnumber.trim().split(",")[i].trim());
    		 passenger.setPtype(Integer.parseInt(s_hidguesttype.split(",")[i].trim()));
    		 passenger.setDiscount(0f);
    		 passenger.setState(0);
    		 passenger.setOrderid(orderinfo.getId()); //订单ID
    		 passenger.setAirportfee(0f);
    		 passenger.setFuelprice(Float.parseFloat(s_tax));
    		 passenger.setPrice(Float.parseFloat(s_price));
    		 passenger.setLanguage(0);
    		 passenger.setIsstudent(Integer.parseInt(s_hidstudent.split(",")[i].trim()));
    		 passenger.setCardvaliddate(s_hidcardvaldate.split(",")[i].trim());
    		 passenger.setCountry(s_hidcountry.split(",")[i].trim());
    		 passenger.setBirthday(s_hidbirthday.split(",")[i].trim());
    		 try
    		 {
    		    passenger.setDestadress(s_hidtargetaddress.split(",")[i].trim());
    		 }
    		 catch(Exception ex)
    		 {
    			 
    		 }
    		 try
    		 {
    		 passenger.setDestzipcode(s_hidzipcode.split(",")[i].trim());
    		 }
    		 catch(Exception ex)
    		 {
    			 
    		 }
    		 try
    		 {
    		 passenger.setLiveaddress(s_hidliveaddress.split(",")[i].trim());
    		 }
    		 catch(Exception ex)
    		 {
    			 
    		 }
    		
    		 //创建乘机人信息
    		 Server.getInstance().getAirService().createPassenger(passenger);
    		 
    		 
    	 }
     	//****************************乘机人信息赋值结束****************************//
    	 
    	 
    	 forword = "interticket!toSuccess.action?s_orderid="+ orderinfo.getId();
    	 
    	 return "forword";
     }
     
     /**
      * 跳转到预订成功页面
      * @return
      * @throws Exception
      */
     public String toSuccess() throws Exception
     {
    	 orderinfo=Server.getInstance().getAirService().findOrderinfo(s_orderid);
    	 listpassenger=Server.getInstance().getAirService().findAllPassenger(" where "+Passenger.COL_orderid+"="+s_orderid, "", -1, 0);
    	 listsegment=Server.getInstance().getAirService().findAllSegmentinfo(" where "+Passenger.COL_orderid+"="+s_orderid, "", -1, 0);
    	 return "success";
     }
     
    
     
     
     /**
      * 取得所有国家信息
      */
     public void getAllCountry()
     {
        String strCountry = "";
         //加载国籍信息
        listcountry=Server.getInstance().getInterticketService().findAllFcountry("", "ORDER BY ID", -1, 0);
        if(listcountry.size()>0)
        {
            for(int i=0;i<listcountry.size();i++)
            {
                if (listcountry.get(i).getCountryname() == "中国")
                    strCountry += "<option value='" + listcountry.get(i).getCountrycode() + "' selected='selected'>" + listcountry.get(i).getCountryname() + "</option>";
                else
                    strCountry += "<option value='" + listcountry.get(i).getCountrycode() + "'>"+listcountry.get(i).getCountrycode()+" " + listcountry.get(i).getCountryname() + "</option>";
            }
        }
        strCountry += "";
        s_Country=strCountry;
     }
     

       /**
		 * 根据国际航空公司获取航空公司名称
		 * 
		 * @param aircompany
		 * @return
		 */
		public String getAirCompanyNamebyCode(String code) {
			String where = "where " + Fairway.COL_airlinercode + "='" + code
					+ "'";
			List<Fairway> list = Server.getInstance().getInterticketService().findAllFairway(where, "ORDER BY ID", -1, 0);
			return list != null && list.size() > 0 ? list.get(0).getAirlinername() : "";

		}
		
		/**
		 * 根据机场三字码获取机场名称
		 * 
		 * @param aircompany
		 * @return
		 */
		public String getAirPortNamebyCode(String code) {
			String where = "where " + Fairport.COL_airportcode + "='" + code
					+ "'";
			List<Fairport> list = Server.getInstance().getInterticketService().findAllFairport(where, "ORDER BY ID", -1, 0);
			return list != null && list.size() > 0 ? list.get(0).getAirportname() : "";

		}
		
		/**
		 * 根据城市三字码获取城市名称
		 * 
		 * @param aircompany
		 * @return
		 */
		public String getCityNamebyCode(String code) {
			String where = "where " + Fcity.COL_citycode + "='" + code
					+ "'";
			List<Fcity> list = Server.getInstance().getInterticketService().findAllFcity(where, "ORDER BY ID", -1, 0);
			return list != null && list.size() > 0 ? list.get(0).getCityname() : "";

		}
		
		 

	/**
	 *  返回国际机票表对象
	 */		
	
	public Object getModel() {
		return allroteinfo;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
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

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getS_listpagehtml() {
		return s_listpagehtml;
	}

	public void setS_listpagehtml(String s_listpagehtml) {
		this.s_listpagehtml = s_listpagehtml;
	}

	public String getS_HfSelectRoutID() {
		return s_HfSelectRoutID;
	}

	public void setS_HfSelectRoutID(String hfSelectRoutID) {
		s_HfSelectRoutID = hfSelectRoutID;
	}

	public String getS_HfFlightID() {
		return s_HfFlightID;
	}

	public void setS_HfFlightID(String hfFlightID) {
		s_HfFlightID = hfFlightID;
	}

	public String getS_HfSelectFligID() {
		return s_HfSelectFligID;
	}

	public void setS_HfSelectFligID(String hfSelectFligID) {
		s_HfSelectFligID = hfSelectFligID;
	}

	public List<Fflight> getFlightWebList() {
		return FlightWebList;
	}

	public void setFlightWebList(List<Fflight> flightWebList) {
		FlightWebList = flightWebList;
	}

	public List<Customeruser> getListcustomeruser() {
		return listcustomeruser;
	}

	public void setListcustomeruser(List<Customeruser> listcustomeruser) {
		this.listcustomeruser = listcustomeruser;
	}

	public String getS_totalPrice() {
		return s_totalPrice;
	}

	public void setS_totalPrice(String price) {
		s_totalPrice = price;
	}

	public String getS_Country() {
		return s_Country;
	}

	public void setS_Country(String country) {
		s_Country = country;
	}

	public List<Fcountry> getListcountry() {
		return listcountry;
	}

	public void setListcountry(List<Fcountry> listcountry) {
		this.listcountry = listcountry;
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

	public String getS_contactphone() {
		return s_contactphone;
	}

	public void setS_contactphone(String s_contactphone) {
		this.s_contactphone = s_contactphone;
	}

	public String getS_contactemail() {
		return s_contactemail;
	}

	public void setS_contactemail(String s_contactemail) {
		this.s_contactemail = s_contactemail;
	}

	public String getS_memo() {
		return s_memo;
	}

	public void setS_memo(String s_memo) {
		this.s_memo = s_memo;
	}

	public String getS_hidname() {
		return s_hidname;
	}

	public void setS_hidname(String s_hidname) {
		this.s_hidname = s_hidname;
	}

	public String getS_hidstudent() {
		return s_hidstudent;
	}

	public void setS_hidstudent(String s_hidstudent) {
		this.s_hidstudent = s_hidstudent;
	}

	public String getS_hidcardtype() {
		return s_hidcardtype;
	}

	public void setS_hidcardtype(String s_hidcardtype) {
		this.s_hidcardtype = s_hidcardtype;
	}

	public String getS_hidcardnumber() {
		return s_hidcardnumber;
	}

	public void setS_hidcardnumber(String s_hidcardnumber) {
		this.s_hidcardnumber = s_hidcardnumber;
	}

	public String getS_hidcardvaldate() {
		return s_hidcardvaldate;
	}

	public void setS_hidcardvaldate(String s_hidcardvaldate) {
		this.s_hidcardvaldate = s_hidcardvaldate;
	}

	public String getS_hidcountry() {
		return s_hidcountry;
	}

	public void setS_hidcountry(String s_hidcountry) {
		this.s_hidcountry = s_hidcountry;
	}

	public String getS_hidcountryname() {
		return s_hidcountryname;
	}

	public void setS_hidcountryname(String s_hidcountryname) {
		this.s_hidcountryname = s_hidcountryname;
	}

	public String getS_hidgender() {
		return s_hidgender;
	}

	public void setS_hidgender(String s_hidgender) {
		this.s_hidgender = s_hidgender;
	}

	public String getS_hidbirthday() {
		return s_hidbirthday;
	}

	public void setS_hidbirthday(String s_hidbirthday) {
		this.s_hidbirthday = s_hidbirthday;
	}

	public String getS_hidzipcode() {
		return s_hidzipcode;
	}

	public void setS_hidzipcode(String s_hidzipcode) {
		this.s_hidzipcode = s_hidzipcode;
	}

	public String getS_hidtargetaddress() {
		return s_hidtargetaddress;
	}

	public void setS_hidtargetaddress(String s_hidtargetaddress) {
		this.s_hidtargetaddress = s_hidtargetaddress;
	}

	public String getS_hidliveaddress() {
		return s_hidliveaddress;
	}

	public void setS_hidliveaddress(String s_hidliveaddress) {
		this.s_hidliveaddress = s_hidliveaddress;
	}

	public String getS_hidcitycode() {
		return s_hidcitycode;
	}

	public void setS_hidcitycode(String s_hidcitycode) {
		this.s_hidcitycode = s_hidcitycode;
	}

	public String getS_hidguesttype() {
		return s_hidguesttype;
	}

	public void setS_hidguesttype(String s_hidguesttype) {
		this.s_hidguesttype = s_hidguesttype;
	}

	public String getS_price() {
		return s_price;
	}

	public void setS_price(String s_price) {
		this.s_price = s_price;
	}

	public String getS_tax() {
		return s_tax;
	}

	public void setS_tax(String s_tax) {
		this.s_tax = s_tax;
	}

	public Long getIdtemp() {
		return idtemp;
	}

	public void setIdtemp(Long idtemp) {
		this.idtemp = idtemp;
	}

	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public List<Fflight> getListsegment() {
		return listsegment;
	}

	public void setListsegment(List<Fflight> listsegment) {
		this.listsegment = listsegment;
	}

	public List<Passenger> getListpassenger() {
		return listpassenger;
	}

	public void setListpassenger(List<Passenger> listpassenger) {
		this.listpassenger = listpassenger;
	}

	public Long getS_orderid() {
		return s_orderid;
	}

	public void setS_orderid(Long s_orderid) {
		this.s_orderid = s_orderid;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public int getIntTravelType() {
		return intTravelType;
	}

	public void setIntTravelType(int intTravelType) {
		this.intTravelType = intTravelType;
	}

	public String getS_chlidprice() {
		return s_chlidprice;
	}

	public void setS_chlidprice(String s_chlidprice) {
		this.s_chlidprice = s_chlidprice;
	}

	public List<InterFlightInfo> getListInterFlightInfo() {
		return listInterFlightInfo;
	}

	public void setListInterFlightInfo(List<InterFlightInfo> listInterFlightInfo) {
		this.listInterFlightInfo = listInterFlightInfo;
	}

	public String getTypeFlag() {
		return TypeFlag;
	}

	public void setTypeFlag(String typeFlag) {
		TypeFlag = typeFlag;
	}

	public String getSortingField() {
		return SortingField;
	}

	public void setSortingField(String sortingField) {
		SortingField = sortingField;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public List<Segmentinfo> getListsegmentinfo() {
		return listsegmentinfo;
	}

	public void setListsegmentinfo(List<Segmentinfo> listsegmentinfo) {
		this.listsegmentinfo = listsegmentinfo;
	}

	public List<Segmentinfo> getLissegtempt() {
		return lissegtempt;
	}

	public void setLissegtempt(List<Segmentinfo> lissegtempt) {
		this.lissegtempt = lissegtempt;
	}

	public String getS_jasonsegmentinfo() {
		return s_jasonsegmentinfo;
	}

	public void setS_jasonsegmentinfo(String s_jasonsegmentinfo) {
		this.s_jasonsegmentinfo = s_jasonsegmentinfo;
	}

	public String getS_jsonpassengers() {
		return s_jsonpassengers;
	}

	public void setS_jsonpassengers(String s_jsonpassengers) {
		this.s_jsonpassengers = s_jsonpassengers;
	}

	public int getS_iscreateorder() {
		return s_iscreateorder;
	}

	public void setS_iscreateorder(int s_iscreateorder) {
		this.s_iscreateorder = s_iscreateorder;
	}

	public int getS_seachtype() {
		return s_seachtype;
	}

	public void setS_seachtype(int s_seachtype) {
		this.s_seachtype = s_seachtype;
	}
	
	
}