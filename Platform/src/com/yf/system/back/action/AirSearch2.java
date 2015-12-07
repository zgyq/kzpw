package com.yf.system.back.action;

import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.flightinfo.CarbinInfo;
import com.yf.system.base.flightinfo.FlightInfo;
import com.yf.system.base.flightinfo.FlightSearch;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.opensymphony.xwork.ActionContext;

public class AirSearch2 extends B2b2cbackAction {

	private List <Aircompany>  listAircompany;
	private String s_SAirPortCodeH;
	private String s_EAirPortCodeH;
	private String s_SDate;
	private String s_BDate;
	private String s_FlightType;
	private String s_AirCom;
	private List<FlightInfo> listFlightInfoAll;
	
	private String listStrHtml;
	private String strHeaderHtml;
	private String strPassHtml;
	
	private FlightSearch flightSearch=new FlightSearch();
	private FlightInfo flightInfo=new FlightInfo();
	private CarbinInfo carbinInfo=new CarbinInfo();
	private String s_DepartTime;
	private String s_ArriveTime;
	private String s_HfFligIndex;
    private String HfCabinid;
    private String HfFligIndex2;
    private String HfCabinid2;
      
    private FlightInfo flightOne;
    private CarbinInfo cabinOne;
    private FlightInfo flightTwo;
    private CarbinInfo cabinTwo;
    private Segmentinfo segmentOne= new Segmentinfo();
    private Segmentinfo segmentTwo=new Segmentinfo();
    private List<Customerpassenger> listCustPassenger;
   


	public FlightInfo getFlightTwo() {
		return flightTwo;
	}

	public void setFlightTwo(FlightInfo flightTwo) {
		this.flightTwo = flightTwo;
	}

	public CarbinInfo getCabinTwo() {
		return cabinTwo;
	}

	public void setCabinTwo(CarbinInfo cabinTwo) {
		this.cabinTwo = cabinTwo;
	}

	public CarbinInfo getCabinOne() {
		return cabinOne;
	}

	public void setCabinOne(CarbinInfo cabinOne) {
		this.cabinOne = cabinOne;
	}

	public FlightInfo getFlightOne() {
		return flightOne;
	}

	public void setFlightOne(FlightInfo flightOne) {
		this.flightOne = flightOne;
	}

	public String getS_DepartTime() {
		return s_DepartTime;
	}

	public void setS_DepartTime(String departTime) {
		s_DepartTime = departTime;
	}

	public String getS_ArriveTime() {
		return s_ArriveTime;
	}

	public void setS_ArriveTime(String arriveTime) {
		s_ArriveTime = arriveTime;
	}

	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	public CarbinInfo getCarbinInfo() {
		return carbinInfo;
	}

	public void setCarbinInfo(CarbinInfo carbinInfo) {
		this.carbinInfo = carbinInfo;
	}
	
	public String toimportpnr() throws Exception{
		return "importpnr";
	}

	/**
	 * 列表查询航空公司基础信息表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
	
		listAircompany = Server.getInstance().getAirService().findAllAircompany(where," ORDER BY ID ",-1,0);
		return LIST;
	}
	
	public String tSearch() throws Exception{
		
		searchAV(flightSearch,1);
		
		return SUCCESS;
	}
	public  void searchAV(FlightSearch flightSearch,int intType)
	{
		//航班信息提示
		strHeaderHtml="<table width='100%' border='0' cellspacing='0' cellpadding='0' ><tr><td width='70%'>&nbsp;&nbsp;<b>航程信息：出发城市：" +flightSearch.getStartAirPortName()  + " 到达城市：" + flightSearch.getEndAirPortName() + " 出发日期：" + flightSearch.getFromDate() + "</b></td><td align='right' width='30%'>&nbsp;&nbsp;<span onClick='javascript:orderbyprice();' style='cursor:pointer'><font color='#ff6600'><img src='images/down.gif' width='16px' height='16px'>价格排序</font></span></td></tr></table>";
		StringBuilder sbHtml = new StringBuilder();
		ActionContext.getContext().getSession().remove("segmentTwo");
		ActionContext.getContext().getSession().remove("segmentOne");
		ActionContext.getContext().getSession().remove("travelTypeSession");
		ActionContext.getContext().getSession().remove("travelFlag");
		listFlightInfoAll = Server.getInstance().getTicketSearchService().findAllFlightinfo(flightSearch);
		ActionContext.getContext().getSession().put("travelTypeSession", flightSearch.getTravelType()); //航程类型
		if(intType==1)
		{
		 ActionContext.getContext().getSession().put("travelFlag", 1);
		 ActionContext.getContext().getSession().put("FlightListOne", listFlightInfoAll); //去
		}
		else if(intType==2)
		{
			ActionContext.getContext().getSession().put("travelFlag", 2);
			ActionContext.getContext().getSession().put("FlightListTwo", listFlightInfoAll); //返
		}
		ActionContext.getContext().getSession().put("FlightSearch", flightSearch);

		sbHtml.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center' class='csstab' id='ordert'>  ");
		sbHtml.append("<tr height='30px' style='background:url(images/center1.gif)'><td align='center' width='100px'><b>航班</b></td><td align='center' width='70px'><b>起降时间</b></td><td align='center' width='150px'><b>起降机场</b></td>");
		sbHtml.append("<td align='center' width='50px'><b>机型</b></td><td align='center' width='80px'><b>机建/燃油</b></td><td align='center' width='50px'><b>价格</b></td><td align='center' width='100px'><b>舱位</b></td>");
		sbHtml.append("<td align='center' width='70px'><b>退改签</b></td><td align='center'><b>返佣政策</b></td><td align='center'><b>预订</b></td></tr>");
		int orderid = -1;//用于js排序
		if(listFlightInfoAll.size()>0)
		{
		for(FlightInfo flightinfo:listFlightInfoAll)
		{	
			orderid++; //循环一次Order加1
			String strStartTime=flightinfo.getDepartTime().toString().split(" ")[1].substring(0, 5);
			String strEndTime=flightinfo.getArriveTime().toString().split(" ")[1].substring(0, 5);
			//航班信息和最低价舱位信息
			sbHtml.append("<tr height='50px' id='order_" + orderid + "' class='postbg1'>");
			sbHtml.append("<td align='center'><img src='images/airComlogo/" + flightinfo.getAirCompany()+ ".gif'>" + flightinfo.getAirCompanyName() + "<br>" + flightinfo.getAirline() + "</td>");
			sbHtml.append("<td align='center' >" + strStartTime + "<br>" + strEndTime + "</td>");
			sbHtml.append("<td align='center' ><img src='images/plane1.gif'>" + flightinfo.getStartAirportName() + "<br><img src='images/plane2.gif'>" + flightinfo.getEndAirportName() + "</td>");
			//机型描述信息
            String strPlaneTypeDesc;
            String strPlanePic;
            if (flightinfo.getAirplaneTypeDesc() != null && !flightinfo.getAirplaneTypeDesc().equals("")) 
            {
                strPlaneTypeDesc = flightinfo.getAirplaneTypeDesc().split("#")[0];
                //strPlanePic=flightinfo.getAirplaneTypeDesc().split("#")[1];
            }
            else
            {
            	strPlaneTypeDesc = "暂无机型描述信息";
            	//strPlanePic="images/upload/nopic.jpg";
            }
            sbHtml.append("<td align='center'><span onmouseover=\"showtg(eval(event),'" + strPlaneTypeDesc+"')\" onmouseout=\"HiddenTg();\" style='cursor:hand; color:#ff6600; TEXT-DECORATION: none'>" + flightinfo.getAirplaneType() + "</span></td>");
            sbHtml.append("<td align='center'>" + flightinfo.getAirportFee() + "/" + flightinfo.getFuelFee() + "</td>");
            sbHtml.append("<td align='center' style='color:#d11f1d'><b>￥" + flightinfo.getLowCarbin().getPrice() + "</b></td>");
            
            //舱位名称
            Float floDiscount=flightinfo.getLowCarbin().getDiscount();
            String strDiscount = "";
            if(flightinfo.getLowCarbin().getDiscount()!=null && !flightinfo.getLowCarbin().getDiscount().equals(""))
            {
               Float floDis=floDiscount*10;
               //int intDiscount =Integer.parseInt(floDis.toString());
            
            if (floDis >= 100)
            {
                strDiscount = "";
            }
            else if(floDis >0)
            {
                strDiscount += floDis.toString().substring(0, floDis.toString().length()-2) + "折";
            }
            }
            else
            {
            	strDiscount = "";
            }
        
            String strCabName = strDiscount +flightinfo.getLowCarbin().getCabintypename();
            String lowratevalue="";
            if(flightinfo.getLowCarbin().getRatevalue()!=null)
            {
            	lowratevalue=(flightinfo.getLowCarbin().getRatevalue()*100)+"%"+" "+flightinfo.getLowCarbin().getRatevalue()*100*flightinfo.getLowCarbin().getPrice();
            }else
            {
            	lowratevalue="无";
            }
            sbHtml.append("<td align='center'>" + strCabName + "<br><a href=\"javascript:showAllberth('" + orderid + "');\">所有舱位▼</a></td>");
            String strCB =flightinfo.getLowCarbin().getCabinRules();
            sbHtml.append("<td align='center'><span onmouseover=\"showtg(eval(event),'" + strCB + "')\" onmouseout=\"HiddenTg();\" style='cursor:hand;color:#ff6600; TEXT-DECORATION: none'>退改签</span></td>");
            sbHtml.append("<td align='center'><span style='color:red;font-weight:bold;font-size:20px'>"+lowratevalue+"</span></td>");
            //判断预订按钮（单程直接到下单页面，往返直接查询返程航班信息）
            String strBookUrlString = "";
            if (ActionContext.getContext().getSession().get("travelTypeSession").equals("1"))//单程
            {
                //gotoBook()  1标示第一条最低舱位，2其他舱位
                strBookUrlString = "<a href=\"javascript:gotoBookto('1','" + orderid + "','');\"><img src='images/gouml.gif' width='55px' height='20px' border='0' /></a>";
            }
            else if (ActionContext.getContext().getSession().get("travelTypeSession").equals("2")) //往返
            {
                if (ActionContext.getContext().getSession().get("travelFlag").toString().equals("1"))//去程
                {
                    strBookUrlString = "<a href=\"javascript:onnext('TicketList.jsp?customerId=1','1','" + orderid + "','')\"><img src='images/gouml.gif' width='55px' height='20px' border='0' /></a>";
                }
                else if (ActionContext.getContext().getSession().get("travelFlag").toString().equals("2"))//返程
                {
                    strBookUrlString = "<a href=\"javascript:gotoBookback('1','" + orderid + "','');\"><img src='images/gouml.gif' width='55px' height='20px' border='0' /></a>";
                }
            }
            sbHtml.append("<td align='center'>" + strBookUrlString + "</td>");
            sbHtml.append("</tr>");
            sbHtml.append("<tr><td colspan='10' align='center'>");
            sbHtml.append(" <table width='100%' border='0' cellspacing='0' cellpadding='0' align='center' style='display:none' id='cabin_" + orderid + "' class='bordertable'>");
            
            int cabinid = -1;
            for(CarbinInfo cabininfo:flightinfo.getCarbins())
            {
            	cabinid++; //循环一次Cabinid加1
            	String strCabinC=cabininfo.getCabin();
            	String strCabinF=flightinfo.getLowCarbin().getCabin();
            	if (!strCabinC.equals(strCabinF))
            	{
            		//String strCabinlName = "经济舱";
            		sbHtml.append("<tr height='50px'>");
            		sbHtml.append("<td align='center' width='100px'></td>");
            		sbHtml.append(" <td align='center' width='70px'></td>");
            		sbHtml.append("<td align='center' width='150px'></td>");
            		sbHtml.append("<td align='center' width='50px'></td>");
            		sbHtml.append("<td align='center' width='80px'>" + flightinfo.getAirportFee() + "/" + flightinfo.getFuelFee() + "</td>");
            		if(cabininfo.getPrice()!=null)
            		{
            		  sbHtml.append("<td align='center' width='50px' style='color:#d11f1d'><b>￥" + cabininfo.getPrice() + "</b></td>");
            		}
            		else
            		{
            			sbHtml.append("<td align='center' width='50px' style='color:#d11f1d'><b>暂无数据</b></td>");
            		}
            		if(cabininfo.getDiscount()!=null)
            		{
            		Float floDis=cabininfo.getDiscount();
                    //int intDiscount =Integer.parseInt(floDis.toString());
            		String strCName =floDis.toString().substring(0, floDis.toString().length()-2)+"折 " + "经济舱";
            		sbHtml.append("<td align='center' width='100px'>" + strCName + "</td>");
            		}
            		else
            		{
            			sbHtml.append("<td align='center' width='100px'>暂无数据</td>");
            		}
            		String strCBs;
            		if(cabininfo.getCabinRules()!=null && !cabininfo.getCabinRules().equals(""))
            		{
            			strCBs=cabininfo.getCabinRules();
            		}
            		else
            		{
            			strCBs="暂无退改签规定";
            		}
            		String ratevalue="";
                    if(cabininfo.getRatevalue()!=null)
                    {
                    	ratevalue=(cabininfo.getRatevalue()*100)+"%"+" "+flightinfo.getLowCarbin().getRatevalue()*100*cabininfo.getPrice();;
                    }else
                    {
                    	ratevalue="无";
                    }
                    sbHtml.append("<td align='center' width='70px'><span onmouseover=\"showtg(eval(event),'" + strCBs + "')\" onmouseout=\"HiddenTg();\" style='cursor:hand;color:#ff6600; TEXT-DECORATION: none'>退改签</span></td>");
                    sbHtml.append("<td align='center'><span style='color:red;font-weight:bold;font-size:20px'>"+ratevalue+"</span></td>");
                    //判断预订按钮（单程直接到下单页面，往返直接查询返程航班信息）
                    String strBookUrl = "";
                    if (ActionContext.getContext().getSession().get("travelTypeSession").equals("1"))//单程
                    {
                        strBookUrl = "<a href=\"javascript:gotoBookto('2','" + orderid + "','" + cabinid + "');\"><img src='images/gouml.gif' width='55px' height='20px' border='0' /></a>";
                    }
                    else if (ActionContext.getContext().getSession().get("travelTypeSession").equals("2")) //往返
                    {
                        if (ActionContext.getContext().getSession().get("travelFlag").toString().equals("1"))//去程
                        {
                            strBookUrl = "<a href=\"javascript:onnext('TicketList.jsp?customerId=1','2','" + orderid + "','" + cabinid + "')\"><img src='images/gouml.gif' width='55px' height='20px' border='0' /></a>";
                        }
                        else if (ActionContext.getContext().getSession().get("travelFlag").toString().equals("2") )//返程
                        {
                            strBookUrl = "<a href=\"javascript:gotoBookback('2','" + orderid + "','" + cabinid + "');\"><img src='images/gouml.gif' width='55px' height='20px' border='0' /></a>";
                        }
                    }
                    sbHtml.append("<td align='center'>" + strBookUrl + "</td>");
                    sbHtml.append("</tr>");
                    
            	}
            }
            sbHtml.append(" </table></td></tr><tr height='5px'><td colspan='10'><hr class='hr1' /></td></tr>");
		}
		}
		else
		{
			sbHtml.append("<tr height='10px'><td colspan='10'><br/><font color='red' size='4px'>抱歉！没有您要查找的航线...</font></td></tr>");
		}
		sbHtml.append(" </table>");
		listStrHtml=sbHtml.toString();
	}
	
	public String tobookback()
	{
//		ActionContext.getContext().getSession().remove("travelFlag");
//		ActionContext.getContext().getSession().put("travelFlag", 2); //返程
		//航班提示信息
		strHeaderHtml="<table width='100%' border='0' cellspacing='0' cellpadding='0' ><tr><td width='70%'>&nbsp;&nbsp;<b>航程信息：出发城市：" +flightSearch.getStartAirPortName()  + " 到达城市：" + flightSearch.getEndAirPortName() + " 出发日期：" + flightSearch.getFromDate() + "</b></td><td align='right' width='30%'>&nbsp;&nbsp;<span onClick='javascript:orderbyprice();' style='cursor:pointer'><font color='#ff6600'><img src='images/down.gif' width='16px' height='16px'>价格排序</font></span></td></tr></table>";
		String strTableName = s_HfFligIndex.split("_")[0]; //表id前缀
        int intSelFliIndex =Integer.parseInt(s_HfFligIndex.split("_")[1]); //表id值 选中的航班ID
        int intCabinIndex = 0;
        if (HfCabinid.equals(""))
        {
            intCabinIndex = 0;
        }
        else
        {
            intCabinIndex = Integer.parseInt(HfCabinid);
        }
        String strAirComName = "";//选中的航空公司名称
        String strAirLine = "";//选中的航班号
        String strCabin = "";//选中的舱位
        String strPrice = "";//选中的舱位价格
        List<FlightInfo> listFlightInfoOne = (List<FlightInfo>)ActionContext.getContext().getSession().get("FlightListOne");
        FlightInfo flightOne=listFlightInfoOne.get(intSelFliIndex);
        CarbinInfo cabinOne=listFlightInfoOne.get(intSelFliIndex).getCarbins().get(intCabinIndex);
        strAirComName = flightOne.getAirCompanyName(); //选中的航空公司名称
        strAirLine = flightOne.getAirline(); //选中的航班号
        if (strTableName.equals("order"))
        {

            strCabin = flightOne.getLowCarbin().getCabin(); //选中的舱位
            strPrice = flightOne.getLowCarbin().getPrice().toString(); //选中的舱位价格
        }
        else if (strTableName.equals("cabin"))
        {
            strCabin = cabinOne.getCabin(); //选中的舱位
            strPrice = cabinOne.getPrice().toString(); //选中的舱位价格
        }
        
        //查询返程航班
		FlightSearch flightSearch=(FlightSearch)ActionContext.getContext().getSession().get("FlightSearch");
		FlightSearch flightSearchBack=new FlightSearch();
		flightSearchBack.setAirCompanyCode(flightSearch.getAirCompanyCode());
		flightSearchBack.setBackDate(flightSearch.getBackDate());
		flightSearchBack.setEndAirportCode(flightSearch.getStartAirportCode());
		flightSearchBack.setStartAirportCode(flightSearch.getEndAirportCode());
		flightSearchBack.setFromDate(flightSearch.getFromDate());
		flightSearchBack.setStartAirPortName(flightSearch.getEndAirPortName());
		flightSearchBack.setEndAirPortName(flightSearch.getStartAirPortName());
		flightSearchBack.setTravelType(flightSearch.getTravelType());
		strHeaderHtml+="<br />所选航空公司：" + strAirComName + " &nbsp;&nbsp;所选航班号：" + strAirLine + "&nbsp;&nbsp;<br />所选舱位：" + strCabin + "&nbsp;&nbsp;舱位价格：" + strPrice;
		searchAV(flightSearchBack,2);
        
        return SUCCESS;
	}
	
	
	
	/**
	 * 跳转到预订
	 * @return
	 */
	public String tocreateorder()
	{
		//查询常用旅客
		listCustPassenger=Server.getInstance().getMemberService().findAllCustomerpassenger("WHERE "+Customerpassenger.COL_customeruserid+"='1'", "", -1, 0);
		
		//System.out.println(s_HfFligIndex);
		//flightInfo.setDepartTime(dateToTimestamp(s_DepartTime));
		//flightInfo.setArriveTime(dateToTimestamp(s_ArriveTime));
		//航程赋值
        String strTableName = s_HfFligIndex.split("_")[0]; //表id前缀
        int intSelFliIndex = Integer.parseInt(s_HfFligIndex.split("_")[1]); //表id值 选中的航班ID
        int intCabinIndex = 0;
        if (HfCabinid.equals("") || HfCabinid==null)
        {
            intCabinIndex = 0;
        }
        else
        {
            intCabinIndex = Integer.parseInt(HfCabinid);
        }
        if (ActionContext.getContext().getSession().get("travelTypeSession").equals("1")) //单程
        {
        	//Segmentinfo segmentOne=new Segmentinfo(); // 航程类
        	List<FlightInfo> listFlightInfoOne;
        	listFlightInfoOne=(List<FlightInfo>)ActionContext.getContext().getSession().get("FlightListOne");
        	flightOne=listFlightInfoOne.get(intSelFliIndex);
        	cabinOne=listFlightInfoOne.get(intSelFliIndex).getCarbins().get(intCabinIndex);
        	segmentOne.setAircomapnycode(flightOne.getAirCompany());
        	System.out.println(segmentOne.getAircomapnycode());
        	segmentOne.setAircompanyname(flightOne.getAirCompanyName()); //选中航空公司名称
        	segmentOne.setFlightnumber(flightOne.getAirline()); //选中航班号
        	segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee().toString())); //机建费
        	segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee().toString())); //燃油费
        	segmentOne.setDeparttime(flightOne.getDepartTime());//起飞时间
        	segmentOne.setArrivaltime(flightOne.getArriveTime()); //到达时间
        	segmentOne.setYprice(flightOne.getYPrice()); //全价价格
        	segmentOne.setTraveltype(Integer.parseInt(ActionContext.getContext().getSession().get("travelTypeSession").toString())); //航程类型
        	segmentOne.setStartairport(flightOne.getStartAirport());
        	segmentOne.setEndairport(flightOne.getEndAirport());
        	segmentOne.setFlightmodelnum(flightOne.getAirplaneType());//机型 
        	//segmentOne.setRatevalue(flightOne.getLowCarbin().getRatevalue()); //返佣值
        	
            if (strTableName.equals("order"))
            {
            	segmentOne.setCabincode(flightOne.getLowCarbin().getCabin());
            	segmentOne.setPrice(flightOne.getLowCarbin().getPrice());
            	System.out.println(segmentOne.getPrice());
            	segmentOne.setDiscount(flightOne.getLowCarbin().getDiscount());
            	if(flightOne.getLowCarbin().getZrateid()!=null)
            	{
            	  segmentOne.setZrateid(flightOne.getLowCarbin().getZrateid());
            	}
            	if(flightOne.getLowCarbin().getRatevalue()!=null)
            	{
            	   segmentOne.setRatevalue(flightOne.getLowCarbin().getRatevalue()); 
            	}
            	if(flightOne.getLowCarbin().isSpecial())
            	{
            	   segmentOne.setIsspecial(1);
            	}
            	else
            	{
            		segmentOne.setIsspecial(0);
            	}
            	segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());
            }
            else if (strTableName.equals("cabin"))
            {
            	segmentOne.setCabincode(cabinOne.getCabin());
            	segmentOne.setPrice(cabinOne.getPrice());
            	segmentOne.setDiscount(cabinOne.getDiscount());
            	segmentOne.setZrateid(cabinOne.getZrateid());
            	if(cabinOne.getRatevalue()!=null)
            	{
            	   segmentOne.setRatevalue(cabinOne.getRatevalue()); 
            	}
            	if(cabinOne.isSpecial())
            	{
            	   segmentOne.setIsspecial(1);
            	}
            	else
            	{
            		segmentOne.setIsspecial(0);
            	}
            	segmentOne.setRules(cabinOne.getCabinRules());
            }
            ActionContext.getContext().getSession().put("segmentOne", segmentOne);
        }
        else if(ActionContext.getContext().getSession().get("travelTypeSession").equals("2")) //返程
        {
        	String strTableName2 = HfFligIndex2.split("_")[0]; //表id前缀
            int intSelFliIndex2 =Integer.parseInt(HfFligIndex2.split("_")[1]); //表id值 选中的航班ID
            int intCabinIndex2 = 0;
            if (HfCabinid2.equals(""))
            {
                intCabinIndex2 = 0;
            }
            else
            {
                intCabinIndex2 = Integer.parseInt(HfCabinid2);
            }
            
            //Segmentinfo segmentOne=new Segmentinfo(); // 航程类
        	List<FlightInfo> listFlightInfoOne;
        	listFlightInfoOne=(List<FlightInfo>)ActionContext.getContext().getSession().get("FlightListOne");
        	flightOne=listFlightInfoOne.get(intSelFliIndex);
        	cabinOne=listFlightInfoOne.get(intSelFliIndex).getCarbins().get(intCabinIndex);
        	segmentOne.setAircomapnycode(flightOne.getAirCompany());//航空公司2字码
        	segmentOne.setAircompanyname(flightOne.getAirCompanyName()); //选中航空公司名称
        	segmentOne.setFlightnumber(flightOne.getAirline()); //选中航班号
        	segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee().toString())); //机建费
        	segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee().toString())); //燃油费
        	segmentOne.setDeparttime(flightOne.getDepartTime());//起飞时间
        	segmentOne.setArrivaltime(flightOne.getArriveTime()); //到达时间
        	segmentOne.setYprice(flightOne.getYPrice()); //全价价格
        	segmentOne.setTraveltype(Integer.parseInt(ActionContext.getContext().getSession().get("travelTypeSession").toString())); //航程类型
        	segmentOne.setStartairport(flightOne.getStartAirport());
        	segmentOne.setEndairport(flightOne.getEndAirport());
        	segmentOne.setFlightmodelnum(flightOne.getAirplaneType());//机型
        	if(flightOne.getLowCarbin().getZrateid()!=null)
        	{
        	  segmentOne.setZrateid(flightOne.getLowCarbin().getZrateid());
        	}
            if (strTableName.equals("order"))
            {
            	segmentOne.setCabincode(flightOne.getLowCarbin().getCabin());
            	segmentOne.setPrice(flightOne.getLowCarbin().getPrice());
            	segmentOne.setDiscount(flightOne.getLowCarbin().getDiscount());
            	segmentOne.setZrateid(flightOne.getLowCarbin().getZrateid());
            	if(flightOne.getLowCarbin().getRatevalue()!=null)
            	{
            		segmentOne.setRatevalue(flightOne.getLowCarbin().getRatevalue());
            	}
            	 
            	if(flightOne.getLowCarbin().isSpecial())
            	{
            	   segmentOne.setIsspecial(1);
            	}
            	else
            	{
            		segmentOne.setIsspecial(0);
            	}
            	segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());
            }
            else if (strTableName.equals("cabin"))
            {
            	segmentOne.setCabincode(cabinOne.getCabin());
            	segmentOne.setPrice(cabinOne.getPrice());
            	segmentOne.setDiscount(cabinOne.getDiscount());
            	if(cabinOne.getRatevalue()!=null)
            	{
            		segmentOne.setRatevalue(cabinOne.getRatevalue()); 
            	}
            	
            	if(cabinOne.isSpecial())
            	{
            	   segmentOne.setIsspecial(1);
            	}
            	else
            	{
            		segmentOne.setIsspecial(0);
            	}
            	segmentOne.setRules(cabinOne.getCabinRules());
            }
            ActionContext.getContext().getSession().put("segmentOne", segmentOne);
            
            //第二程
            //Segmentinfo segmentTwo=new Segmentinfo(); // 航程类
        	List<FlightInfo> listFlightInfoTwo;
        	listFlightInfoTwo=(List<FlightInfo>)ActionContext.getContext().getSession().get("FlightListTwo");
        	flightTwo=listFlightInfoTwo.get(intSelFliIndex2);
        	cabinTwo=listFlightInfoTwo.get(intSelFliIndex2).getCarbins().get(intCabinIndex2);

        	segmentTwo.setAircomapnycode(flightTwo.getAirCompany());//航空公司2字码
        	segmentTwo.setAircompanyname(flightTwo.getAirCompanyName()); //选中航空公司名称
        	segmentTwo.setFlightnumber(flightTwo.getAirline()); //选中航班号
        	segmentTwo.setAirportfee(Float.parseFloat(flightTwo.getAirportFee().toString())); //机建费
        	segmentTwo.setFuelfee(Float.parseFloat(flightTwo.getFuelFee().toString())); //燃油费
        	segmentTwo.setDeparttime(flightTwo.getDepartTime());//起飞时间
        	segmentTwo.setArrivaltime(flightTwo.getArriveTime()); //到达时间
        	segmentTwo.setYprice(flightTwo.getYPrice()); //全价价格
        	segmentTwo.setTraveltype(Integer.parseInt(ActionContext.getContext().getSession().get("travelTypeSession").toString())); //航程类型
        	segmentTwo.setStartairport(flightTwo.getStartAirport());
        	segmentTwo.setEndairport(flightTwo.getEndAirport());
        	segmentTwo.setFlightmodelnum(flightTwo.getAirplaneType());//机型
        	if(flightTwo.getLowCarbin().getZrateid()!=null)
        	{
        		segmentTwo.setZrateid(flightTwo.getLowCarbin().getZrateid());
        	}
            if (strTableName2.equals("order"))
            {
            	segmentTwo.setCabincode(flightTwo.getLowCarbin().getCabin());
            	segmentTwo.setPrice(flightTwo.getLowCarbin().getPrice());
            	segmentTwo.setDiscount(flightTwo.getLowCarbin().getDiscount());
            	segmentTwo.setZrateid(flightTwo.getLowCarbin().getZrateid());
            	if(flightTwo.getLowCarbin().getRatevalue()!=null)
            	{
            	  segmentTwo.setRatevalue(flightTwo.getLowCarbin().getRatevalue()); //返佣值
            	}
            	if(flightTwo.getLowCarbin().isSpecial())
            	{
            	   segmentTwo.setIsspecial(1);
            	}
            	else
            	{
            		segmentTwo.setIsspecial(0);
            	}
            	segmentTwo.setRules(flightTwo.getLowCarbin().getCabinRules());
            }
            else if (strTableName2.equals("cabin"))
            {
            	segmentTwo.setCabincode(cabinTwo.getCabin());
            	segmentTwo.setPrice(cabinTwo.getPrice());
            	segmentTwo.setDiscount(cabinTwo.getDiscount());
            	segmentTwo.setZrateid(cabinTwo.getZrateid());
            	if(cabinTwo.getRatevalue()!=null)
            	{
            		segmentTwo.setRatevalue(cabinTwo.getRatevalue()); //返佣值
            	}
            	
            	if(cabinTwo.isSpecial())
            	{
            	   segmentTwo.setIsspecial(1);
            	}
            	else
            	{
            		segmentTwo.setIsspecial(0);
            	}
            	segmentTwo.setRules(cabinTwo.getCabinRules());
            }
            ActionContext.getContext().getSession().put("segmentTwo", segmentTwo);
        }
        //创建乘机人Table
        StringBuilder sbPassHtml = new StringBuilder();
        sbPassHtml.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='table_0'>");
        sbPassHtml.append("<tr >");
        sbPassHtml.append("<td colspan='8' align='center'>");
        sbPassHtml.append("<table width='98%' border='0' cellspacing='0' cellpadding='0'>");
        sbPassHtml.append(" <tr><td width='40%' align='left'>新登机人<input type='hidden' value='' id='checkboxID_0' /></td>");
        sbPassHtml.append("<td width='23%'>");
        sbPassHtml.append("");
        sbPassHtml.append("</td>");
        sbPassHtml.append("<td width='20%'>");
        sbPassHtml.append("&nbsp;</td>");
        sbPassHtml.append("<td width='8%' align='center'>");
        sbPassHtml.append("</td>");
        sbPassHtml.append("<td width='9%' align='center'>");
        sbPassHtml.append("<a href='#' onclick='javascript:return delTable(0);'>删除</a></td>");
        sbPassHtml.append(" </tr>");
        sbPassHtml.append(" </table></td></tr>");

        sbPassHtml.append("<tr class='GridViewRowStyle'>");
        sbPassHtml.append("<td align='right'>姓名:</td>");
        sbPassHtml.append("<td><input type='text'runat='server' id='txtPassName0' width='150px' onblur='BindPassInfoHiden();'></td>");
        sbPassHtml.append("<td align='right'>登机人类型:</td>");
        sbPassHtml.append("<td><select id='ddlPassType0' width='100px' onchange='BindPassInfoHiden();showTotalPassInfo();'><option value='0'>成人</option><option value='2'>儿童</option><option value='3'>婴儿</option></select></td>");
        sbPassHtml.append("<td align='right'>证件类型:</td>");
        sbPassHtml.append("<td><select id='ddlIdType0' width='100px' onchange='BindPassInfoHiden();'><option value='1'>身份证</option><option value='2'>护照</option><option value='6'>其他</option></select></td>");
        sbPassHtml.append("<td align='right'>证件号码:</td>");
        sbPassHtml.append(" <td><input type='text' id='txtIdNumber0' width='30px' onblur='BindPassInfoHiden();'></td>");
        sbPassHtml.append("</tr>");
        sbPassHtml.append("<tr height='10px'><td></td></tr>");
        sbPassHtml.append("</table>");
        sbPassHtml.append("<div id='newtable'></div>");
        strPassHtml=sbPassHtml.toString();
		return "ticketorder";
	}
	
	/**
	 */		
	public List < Aircompany >   getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List <  Aircompany  >  listAircompany) {
		this.listAircompany = listAircompany;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return flightSearch;
	}

	public String getS_EAirPortCode() {
		return s_EAirPortCodeH;
	}

	public void setS_EAirPortCode(String airPortCode) {
		s_EAirPortCodeH = airPortCode;
	}

	public String getS_SDate() {
		return s_SDate;
	}

	public void setS_SDate(String date) {
		s_SDate = date;
	}

	public String getS_FlightType() {
		return s_FlightType;
	}

	public void setS_FlightType(String flightType) {
		s_FlightType = flightType;
	}

	public String getS_AirCom() {
		return s_AirCom;
	}

	public void setS_AirCom(String airCom) {
		s_AirCom = airCom;
	}

	public String getS_SAirPortCodeH() {
		return s_SAirPortCodeH;
	}

	public void setS_SAirPortCodeH(String airPortCodeH) {
		s_SAirPortCodeH = airPortCodeH;
	}

	public String getS_EAirPortCodeH() {
		return s_EAirPortCodeH;
	}

	public void setS_EAirPortCodeH(String airPortCodeH) {
		s_EAirPortCodeH = airPortCodeH;
	}

	public String getS_BDate() {
		return s_BDate;
	}

	public void setS_BDate(String date) {
		s_BDate = date;
	}
	
	public List<FlightInfo> getListFlightInfoAll() {
		return listFlightInfoAll;
	}

	public void setListFlightInfoAll(List<FlightInfo> listFlightInfoAll) {
		this.listFlightInfoAll = listFlightInfoAll;
	}

	public FlightSearch getFlightSearch() {
		return flightSearch;
	}

	public void setFlightSearch(FlightSearch flightSearch) {
		this.flightSearch = flightSearch;
	}

	public String getListStrHtml() {
		return listStrHtml;
	}

	public void setListStrHtml(String listStrHtml) {
		this.listStrHtml = listStrHtml;
	}

	public String getStrHeaderHtml() {
		return strHeaderHtml;
	}

	public void setStrHeaderHtml(String strHeaderHtml) {
		this.strHeaderHtml = strHeaderHtml;
	}

	

	public String getHfCabinid() {
		return HfCabinid;
	}

	public void setHfCabinid(String hfCabinid) {
		HfCabinid = hfCabinid;
	}

	public String getHfFligIndex2() {
		return HfFligIndex2;
	}

	public void setHfFligIndex2(String hfFligIndex2) {
		HfFligIndex2 = hfFligIndex2;
	}

	public String getHfCabinid2() {
		return HfCabinid2;
	}

	public void setHfCabinid2(String hfCabinid2) {
		HfCabinid2 = hfCabinid2;
	}

	public String getS_HfFligIndex() {
		return s_HfFligIndex;
	}

	public void setS_HfFligIndex(String hfFligIndex) {
		s_HfFligIndex = hfFligIndex;
	}

	public Segmentinfo getSegmentOne() {
		return segmentOne;
	}

	public void setSegmentOne(Segmentinfo segmentOne) {
		this.segmentOne = segmentOne;
	}

	public Segmentinfo getSegmentTwo() {
		return segmentTwo;
	}

	public void setSegmentTwo(Segmentinfo segmentTwo) {
		this.segmentTwo = segmentTwo;
	}

	public List<Customerpassenger> getListCustPassenger() {
		return listCustPassenger;
	}

	public void setListCustPassenger(List<Customerpassenger> listCustPassenger) {
		this.listCustPassenger = listCustPassenger;
	}

	public String getStrPassHtml() {
		return strPassHtml;
	}

	public void setStrPassHtml(String strPassHtml) {
		this.strPassHtml = strPassHtml;
	}

	
	
	

}
