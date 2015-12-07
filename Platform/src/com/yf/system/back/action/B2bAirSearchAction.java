package com.yf.system.back.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.yf.service.ZrateServer;
import com.yf.system.atom.component.CacheBaseData;
import com.yf.system.atom.component.WriteLog;
import com.yf.system.atom.interticket.HttpClient;
import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.agentvalue.Agentvalue;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.eaccount.Eaccount;
import com.yf.system.base.flightinfo.CarbinInfo;
import com.yf.system.base.flightinfo.FlightInfo;
import com.yf.system.base.flightinfo.FlightSearch;
import com.yf.system.base.flightmodel.Flightmodel;
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.qqtypenew.Qqtypenew;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.specialprice.Specialprice;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;

public class B2bAirSearchAction extends B2b2cbackAction {

	private int s_type=0;//柜台版=1  
	private List<Aircompany> listAircompany;
	private String s_SAirPortCodeH;
	private String s_EAirPortCodeH;
	private String s_SDate;
	private String s_BDate;
	private String s_FlightType;
	private String s_AirCom;
	private List<FlightInfo> listFlightInfoAll;
    private String s_rebatepoint="0";
	private FlightSearch flightSearch = new FlightSearch();
	private FlightInfo flightInfo = new FlightInfo();
	private CarbinInfo carbinInfo = new CarbinInfo();
	private String s_DepartTime;
	private String s_ArriveTime;
	private String s_HfFligIndex;
	private String HfCabinid;
	private String HfFligIndex2;
	private String HfCabinid2;
	private float s_spcabinprice;
	private float s_spdiscount;
	private List<Sysmessage> sysmessageList;
	private CacheBaseData cachebasedata=new CacheBaseData();
	
	// 航班信息List
	private List<FlightInfo> listFlightInfoAll_9c=new ArrayList<FlightInfo>();
	
	//是否是特殊政策
	private int isSPPolicy=0;
	//查询常用旅客用字段
	private String s_name;
	private String s_number;
	private String c_index;
	private String customerusername;
	private int c_type=0;
	
	//取得下订单政策列表参数定义
	//出发日期
	public String z_fromdate;
	//是否取得特殊政策
	public int intflag=1;
	//航空公司代码
	public String strAirCompany;
	//航班号
	public String strAirline;
	//舱位码
	public String strCabin;
	//舱位价（未匹配政策前的价格）
	public Float z_parvalue=0f;
	//航程序号 1=单程 2=往返程或联程
	public int z_segmentindex=1;
	//取得下订单政策列表参数定义

	private FlightInfo flightOne;
	private CarbinInfo cabinOne;
	private FlightInfo flightTwo;
	private CarbinInfo cabinTwo;
	private Segmentinfo segmentOne = new Segmentinfo();
	private Segmentinfo segmentTwo = new Segmentinfo();
	private List<Customerpassenger> listCustPassenger;
	private Integer isBackOrTo;
	//政策使用
	private String s_fromcity;
	private String s_tocity;
	private String s_fromdate;
	private String s_aircompanycode;
	private String s_flightnumber;
	private String s_cabincode;
	//政策使用
	private String historysum;

	private List<Infocontent> listSysmenssage2 = new ArrayList<Infocontent>();

	private Integer issession = 1;

	private List<Specialprice> listspe;
	private String spestr;
	
	//获取特价
	private String flightnub;//航班号
	private String citycode;//三字码串
	private String cabincode;//仓位吗
	private String stime;//出发时间
	
	private String htjprice;

	//联程查询条件
	//出发城市
	private String StartAirportCode_lc;
	//目的城市
	private String EndAirportCode_lc;
	//联程出发日期
	private String FromDate_lc;
	//联程查询条件
	private FlightSearch flightSearch_lc = new FlightSearch();

	// 政策
	private String z_startcity;
	private String z_endcity;
	private String z_date;
	private String z_airline;
	private String z_aircode;
	private String z_price;
	//默认出发机场
	private String s_sAirPort;
	//默认出发机场城市名称
	private String s_sAirPortName;

	private LinkedList<Zrate> listdzrate = new LinkedList<Zrate>();
	private LinkedList<Zrate> listgzrate = new LinkedList<Zrate>();
	private LinkedList<Zrate> listdzratetwo = new LinkedList<Zrate>();
	private LinkedList<Zrate> listgzratetwo = new LinkedList<Zrate>();
	
	//QQ类型
	private List<Qqtypenew> listQqtypenew=new ArrayList<Qqtypenew>();
	
	//显示列表排序方式
	private int orderKey=0;
	
	//平台费
	private float orderPlat=0f;
	
	// 行程单费用
	private int xcdPlat = 0;
	
	// 配送费用
	private int xcdpsPlat = 0;
	public B2bAirSearchAction()
	{
		
		Sysconfig sysconfig = Server.getInstance().getMemberService().findSysconfig(10022L);
		if(sysconfig!=null){
			this.orderPlat=Float.parseFloat(sysconfig.getValue());
		}
		List<Sysconfig>listsys=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='xcdprice'", " ORDER BY ID ", -1, 0);
		if (listsys!=null){
			this.xcdPlat = Integer.parseInt(listsys.get(0).getValue().trim());
		}
		List<Sysconfig>listsys2=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='xcdpsprice'", " ORDER BY ID ", -1, 0);
		if (listsys2!=null){
			this.xcdpsPlat = Integer.parseInt(listsys2.get(0).getValue().trim());
		}
		
	}

	
	private static Map<Integer, String> orderItemMap = new HashMap<Integer, String>();
	static{
		orderItemMap.put(0, "出发时间从早到晚");
		orderItemMap.put(1, "出发时间从晚到早");
		//orderItemMap.put(2, "返点从低到高");
		//orderItemMap.put(3, "返点从高到低");
		orderItemMap.put(4, "价格从低到高");
		orderItemMap.put(5, "价格从高到低");
	}
	
	public String getZ_startcity() {
		return z_startcity;
	}

	public void setZ_startcity(String z_startcity) {
		this.z_startcity = z_startcity;
	}

	public String getZ_endcity() {
		return z_endcity;
	}

	public void setZ_endcity(String z_endcity) {
		this.z_endcity = z_endcity;
	}

	public String getZ_date() {
		return z_date;
	}

	public void setZ_date(String z_date) {
		this.z_date = z_date;
	}

	public List<Specialprice> getListspe() {
		return listspe;
	}

	public void setListspe(List<Specialprice> listspe) {
		this.listspe = listspe;
	}

	public String getSpestr() {
		return spestr;
	}

	public void setSpestr(String spestr) {
		this.spestr = spestr;
	}

	/**
	 * 列表查询航空公司基础信息表
	 */
	public String execute() throws Exception {
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
		return "ticket";
	}
	
	
	public boolean isInInsrutime(Timestamp onetime,Timestamp twotime){
		Timestamp time=new Timestamp(onetime.getTime());
		
		time.setDate(onetime.getDate()+6);
		if(time.after(twotime)){
			return true;
		}
			return false;
	}
	/**
	 * 从接口获取数据
	 * @return
	 */
	public static String getDateString(String hangban,String cangwei,String citys,String time)
	{
		int ran = (int) (Math.random() * 99999 + 1);
		String run = ran + "";
		
		String urltemp="http://api.flymain.com/Api_Module/PATEX/Return.asp?action=patex&uid=87130000com&Flight="+hangban+"|"+cangwei+"|"+citys+"|"+time+"$&rnd="+run;
		//String urltemp="http://api.flymain.com/Api_Module/PATEX/Return.asp?action=patex&uid=87130000com&Flight=CA1701|T|hghpek|2011-04-22$";
		URL url;
		System.out.println("urltemp=="+urltemp);
		try {
			url = new URL(urltemp);
			URLConnection connection = url.openConnection();  
			connection.setDoOutput(true);  
			/*OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			out.flush();  
		    out.close(); */ 
		    String sCurrentLine;  
		    String sTotalString;  
		    sCurrentLine = "";  
		    sTotalString = "";  
		    InputStream l_urlStream;  
		    l_urlStream = connection.getInputStream();  
		    BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream,"utf-8"));  
		    while ((sCurrentLine = l_reader.readLine()) != null) {  
		    sTotalString += sCurrentLine;  
		    }
		    return sTotalString;
			
		    
		   
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "";
	}
	/**
	 * 获取特价
	 */
	public void getTJprice() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		
		
		WriteLog.write("getTJprice", "citycode:"+citycode+",flightnub:"+flightnub+",cabincode:"+cabincode+",stime:"+stime);
		
		System.out.println(citycode);
		System.out.println(flightnub);
		System.out.println(cabincode);
		System.out.println(stime);
		String ret="-1";
		
			//ret=getTJpriceByETM(citycode.replaceAll(",", ""), flightnub, cabincode, stime);
			ret=getTJpriceByETMSS(citycode.replaceAll(",", ""), flightnub, cabincode, stime);
			System.out.println("NFD返回:"+ret);
		
		
		if(!ret.equals("")&&!ret.equals("-1")&&ret.length()<8){
			Writer writer;
			try {
				writer = response.getWriter();
				writer.write(ret);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
			Writer writer;
			try {
				writer = response.getWriter();
				writer.write("-1");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*String sub =getDateString(flightnub,cabincode,citycode,stime);
		System.out.println("sub=="+sub);
		
		try {
			Document document = DocumentHelper.parseText(sub);
			org.dom4j.Element root =  document.getRootElement();
			System.out.println("ret_value=="+root.attributeValue("ret_value"));
			if(root.attributeValue("ret_value")!=null&&!root.attributeValue("ret_value").equals("0")){//有数据
				List<org.dom4j.Element> listflights = root.elements("price");//获取价格list
				if(listflights.size()==0){//没有价格
					
					
					Writer writer;
					try {
						writer = response.getWriter();
						writer.write("-1");
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				String price =listflights.get(0).elementText("cnyf");
				System.out.println("价格=="+price);
				
				Writer writer;
				try {
					writer = response.getWriter();
					if(price==null||price.length()==0||price.equals("")){
					writer.write("-1");
					}else{
						
						//匹配政策开始
						String scitycode=citycode.substring(0, 3);//起飞机场
						String ecitycode=citycode.substring(3, 6);//到达机场
						String aircompanycode=flightnub.substring(0, 2);//到达机场
						
					//Double zceprice=getZrate(stime,scitycode,ecitycode,cabincode,aircompanycode,flightnub,Double.parseDouble(price));
					
						
						//匹配结束
					writer.write(price.toString());
					
					
					}
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}else{//没有价格
				
				Writer writer;
				try {
					writer = response.getWriter();
					writer.write("-1");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Writer writer;
			try {
				writer = response.getWriter();
				writer.write("-1");
				writer.flush();
				writer.close();
			} catch (IOException ew) {
				// TODO Auto-generated catch block
				ew.printStackTrace();
			}
		}*/	
		
		/*CacheBaseData cacheBaseData=new CacheBaseData();
		
		List list=	cacheBaseData.GetListNFDCarbinInfo("PEK@SHA@2013-03-18");
		System.out.println(list.size());*/
		
	}
	/**
	 * 获取特价--本地黑屏
	 */
	public String getTJpriceByETMSS(String citycode,String fligthnum,String cabincode,String stime) {
		String cmd="SS MU5118/Y/25JUN/PEKSHANN1/$pat:a";
		
		  String pat_Price="-1";
		  String pat_Fuleprice="";
		  String pat_airportfee="";
		
		WriteLog writeLog = new WriteLog();
		if(citycode.indexOf(",")!=-1){
			citycode=citycode.replace(",", "");
		}
		String SHHMM="";//出发时间
		String ENDHHMM="";//到达时间
		String sday="";//日期 
		
		String scode="";
		String endcode="";
		
		String aircode="";
		String fnumber="";
		
		aircode=fligthnum.trim().substring(0, 2);
		fnumber=fligthnum.trim().replace(aircode, "");
		
		if(stime.indexOf("@")!=-1){
			sday=stime.split("@")[0].trim();
			SHHMM=stime.split("@")[1].trim();
			ENDHHMM=stime.split("@")[2].trim();
		}
		
		
		if(citycode.indexOf("@")!=-1){
			scode=citycode.split(",")[0].trim();
			endcode=citycode.split(",")[1].trim();
		}
		
		System.out.println(sday+" "+SHHMM);
		
		String sub="";
		
		
		
			if(cabincode.length()>1){
			 sub="IG$SS:"+fligthnum+" "+cabincode+" "+ChangeDateMode(stime.toString())+" "+citycode+" 1/$pat:a";
			}else{
		     sub="IG$SS "+fligthnum+"/"+cabincode+"/"+ChangeDateMode(stime.toString())+"/"+citycode+"NN1/$pat:a";
			}
		
	     //sub="SS "+fligthnum+"/"+cabincode+"/"+ChangeDateMode(sday.toString())+"/"+citycode+"N1/$pat:a";
		
		System.out.println(sub);
		
		String strRetrun="";
		try {
			strRetrun = Server.getInstance().getTicketSearchService().commandFunction2(sub, "", "");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("strRetrun:"+strRetrun);
		
			writeLog.write("NFD生成PNR日志", "特价请求字符串:"+sub);
		    
		    writeLog.write("NFD生成PNR日志", "特价返回字符串:"+strRetrun);

		    	 
		    	 Pattern pat = Pattern.compile("[P][A][T][:][A]");
				  String[] strPatarr = pat.split(strRetrun);
				  
				  
				  if(strPatarr.length>=2)
				  {
					  String strpat=strPatarr[1];//pat信息
					  
					  Pattern patmiles=Pattern.compile("\\n");
					  
					  String[] strpats=patmiles.split(strpat);//pat换行对象
					  for(int p=0;p<strpats.length;p++){
						  System.out.println("?"+strpats[p]);
						  if(strpats[p]!=null&&strpats[p].indexOf(cabincode)!=-1){
							  
							  Pattern patitem=Pattern.compile("\\s{1,}");
							  String[] strpatItem=patitem.split(strpats[p]);
							  for(int i=0;i<strpatItem.length;i++) 
							  {
								  if(!strpatItem[i].trim().equals(""))
								  {
									  //票价
									  if(strpatItem[i].trim().indexOf("FARE:")>=0)
									  {
										  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
										  break;
									  }
									  //燃油费
									  if(strpatItem[i].trim().indexOf("YQ:")>=0)
									  {
										  pat_Fuleprice=strpatItem[i].trim().replace("YQ:CNY", "");
									  }
									  //机建费
									  if(strpatItem[i].trim().indexOf("TAX:")>=0)
									  {
										  pat_airportfee=strpatItem[i].trim().replace("TAX:CNY", "");
									  }
								  }
							  }
						  }
						  
					  }
					  
					  
					  
					  
				  }
		    	 System.out.println(pat_Price+","+pat_Fuleprice+","+pat_airportfee);
		    	 writeLog.write("NFD生成特价日志", "返回信息:"+strRetrun.trim()+",价格:"+pat_Price+",燃油:"+pat_Fuleprice+",基建:"+pat_airportfee);
		    	
		    
		   
		
		    
		    
		   
		    
		    
		    return pat_Price;
		
	}
	/**
	 * 获取特价--本地黑屏
	 */
	public String getTJpriceByETM(String citycode,String fligthnum,String cabincode,String stime) {
		/*HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");*/
		
		  String pat_Price="-1";
		  String pat_Fuleprice="";
		  String pat_airportfee="";
		
		WriteLog writeLog = new WriteLog();
		if(citycode.indexOf(",")!=-1){
			citycode=citycode.replace(",", "");
		}
		String SHHMM="";//出发时间
		String ENDHHMM="";//到达时间
		String sday="";//日期 
		
		String scode="";
		String endcode="";
		
		String aircode="";
		String fnumber="";
		
		aircode=fligthnum.trim().substring(0, 2);
		fnumber=fligthnum.trim().replace(aircode, "");
		
		if(stime.indexOf("@")!=-1){
			sday=stime.split("@")[0].trim();
			SHHMM=stime.split("@")[1].trim();
			ENDHHMM=stime.split("@")[2].trim();
		}
		
		
		if(citycode.indexOf("@")!=-1){
			scode=citycode.split(",")[0].trim();
			endcode=citycode.split(",")[1].trim();
		}
		
		System.out.println(sday+" "+SHHMM);
		String	TKTLTime=formatTimestampPID(dateToTimestamp(GetMintue((sday+" "+SHHMM+":00"),-30)));
		System.out.println(TKTLTime);
		String sub="";
		if(cabincode.length()>1){
		sub="IG$SS:"+fligthnum+" "+cabincode.substring(0, 1)+" "+ChangeDateMode(sday.toString())+" "+citycode+" 1"+"\r";
		}else{
		 sub="IG$SS "+fligthnum+"/"+cabincode+"/"+ChangeDateMode(sday.toString())+"/"+citycode+"/NN1/"+SHHMM.replaceAll(":", "")+" "+ENDHHMM.replaceAll(":", "")+"\r";
		}
		 //SS:HU7238 M 06MAY XIYPEK 1
		sub+="NM1陈晓\r";
		sub+="SSR FOID "+aircode+" HK/NI420983198605131412/P1\r";
		sub+="TKTL"+TKTLTime+"/"+ChangeDateMode(sday.toString())+"/YIW110\r";
		sub+=" OSI "+aircode+" CTCT13157140100\r";
		sub+="\\";
		System.out.println(sub);
		
		String strRetrun="";
		try {
			strRetrun = Server.getInstance().getTicketSearchService().commandFunction2(sub, "", "");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("strRetrun:"+strRetrun);
		
		 writeLog.write("NFD生成PNR日志", "创建PNR请求字符串:"+sub);
		    
		    writeLog.write("NFD生成PNR日志", "创建PNR返回字符串:"+strRetrun);
		    
			//对返回值进行解析
		    // 以换行符将字符串拆分
		    Pattern pattern = Pattern.compile("[\\r\\n]");
		    String[] strReturnarr=pattern.split(strRetrun);
		    for(int i=0;i<strReturnarr.length;i++)
		    {
		    	if(strReturnarr[i].toString().indexOf("UNABLE TO SELL")>=0)
		    	{
		    		strRetrun="NOPNR";
		    	}
		    	else if(strReturnarr[i].toString().indexOf("TKT TIME LIMIT, PLEASE CHECK PNR")>=0)
		    	{
		    		if(strReturnarr[i].toString().indexOf("-")>=0)
		    		{
			    		String[] strPNRarr=strReturnarr[i].toString().split("-");
			    		String strPNR=strPNRarr[0];
			    		strRetrun=strPNR;
			    		break;
		    		}
		    	}
		    	else if(strReturnarr[i].toString().indexOf("EOT SUCCESSFUL, BUT ASR UNUSED FOR 1 OR MORE SEGMENTS")>=0)
		    	{
		    		if(strReturnarr[i].toString().indexOf("-")>=0)
		    		{
			    		String[] strPNRarr=strReturnarr[i].toString().split("-");
			    		String strPNR=strPNRarr[0];
			    		strRetrun=strPNR;
			    		break;
		    		}
		    	}
		    	else if(strReturnarr[i].toString().indexOf("航空公司使用自动出票时限")>=0)
		    	{
		    		if(strReturnarr[i].toString().indexOf("-")>=0)
		    		{
			    		String[] strPNRarr=strReturnarr[i].toString().split("-");
			    		String strPNR=strPNRarr[0];
			    		if(strPNR.length()>6)
			    		{
			    			Pattern patternnew = Pattern.compile("\\s{1,}");
			    		    String[] strReturnarrnew=patternnew.split(strPNR);
			    		    strPNR=strReturnarrnew[strReturnarrnew.length-1].toString();
			    		    strRetrun=strPNR;
			    		    break;
			    		}
			    		else
			    		{
			    		    strRetrun=strPNR;
			    		    break;
			    		}
			    		
			    		
		    		}
		    	}
		    	else if(strReturnarr[i].toString().trim().length()==6&&(!(strReturnarr[i].toString().trim().equals("NO PNR")))&&(!(strReturnarr[i].toString().trim().equals("FORMAT"))))
		    	{
		    		//System.out.println("???????????????");
		    		strRetrun=strReturnarr[i].trim();
		    		  break;
		    	}
		    	else
		    	{
		    		strRetrun="NOPNR";
		    	}
		    }
			//strRetrun="123456";
		    
		    writeLog.write("NFD生成PNR日志", "生成PNR编码:"+strRetrun.trim());
		    
		    if(strRetrun.equals("NOPNR")||strRetrun.equals("NO PNR"))
		    {
		    	Server.getInstance().getTicketSearchService().commandFunction2("IG","","");
		    }else{
		    	 String rtpat=  Server.getInstance().getTicketSearchService().commandFunction2("RT"+strRetrun.trim()+"$PAT:A","","");
		    	 
		    	 writeLog.write("NFD生成PNR日志", "生成PNR编码:"+strRetrun.trim()+",RT信息:"+rtpat);
		    	 
		    	 Pattern pat = Pattern.compile("[P][A][T][:][A]");
				  String[] strPatarr = pat.split(rtpat);
				  
				  
				  if(strPatarr.length>=2)
				  {
					  String strpat=strPatarr[1];//pat信息
					  
					  Pattern patmiles=Pattern.compile("\\n");
					  
					  String[] strpats=patmiles.split(strpat);//pat换行对象
					  for(int p=0;p<strpats.length;p++){
						  System.out.println("?"+strpats[p]);
						  if(strpats[p]!=null&&strpats[p].indexOf(cabincode)!=-1){
							  
							  Pattern patitem=Pattern.compile("\\s{1,}");
							  String[] strpatItem=patitem.split(strpats[p]);
							  for(int i=0;i<strpatItem.length;i++) 
							  {
								  if(!strpatItem[i].trim().equals(""))
								  {
									  //票价
									  if(strpatItem[i].trim().indexOf("FARE:")>=0)
									  {
										  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
										  break;
									  }
									  //燃油费
									  if(strpatItem[i].trim().indexOf("YQ:")>=0)
									  {
										  pat_Fuleprice=strpatItem[i].trim().replace("YQ:CNY", "");
									  }
									  //机建费
									  if(strpatItem[i].trim().indexOf("TAX:")>=0)
									  {
										  pat_airportfee=strpatItem[i].trim().replace("TAX:CNY", "");
									  }
								  }
							  }
						  }
						  
					  }
					  
					  
					  
					  
				  }
		    	 System.out.println(pat_Price+","+pat_Fuleprice+","+pat_airportfee);
		    	 writeLog.write("NFD生成PNR日志", "生成PNR编码:"+strRetrun.trim()+",RT信息:"+rtpat+",价格:"+pat_Price+",燃油:"+pat_Fuleprice+",基建:"+pat_airportfee);
		    	 Server.getInstance().getTicketSearchService().commandFunction2("RT"+strRetrun.trim()+"$XEPNR@","","");
		    }
		   
		
		    
		    
		   
		    
		    
		    return pat_Price;
		
	}
	/**
	 * 获取特价
	 */
	public void getTJprice_old() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		//StringBuffer str = new StringBuffer();
		if(citycode.indexOf(",")!=-1){
			citycode=citycode.replace(",", "");
		}
		String sub =getDateString(flightnub,cabincode,citycode,stime);
		//System.out.println("sub=="+sub);
		
		try {
			Document document = DocumentHelper.parseText(sub);
			org.dom4j.Element root =  document.getRootElement();
			System.out.println("ret_value=="+root.attributeValue("ret_value"));
			if(root.attributeValue("ret_value")!=null&&!root.attributeValue("ret_value").equals("0")){//有数据
				List<org.dom4j.Element> listflights = root.elements("price");//获取价格list
				if(listflights.size()==0){//没有价格
					
					
					Writer writer;
					try {
						writer = response.getWriter();
						writer.write("-1");
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				String price =listflights.get(0).elementText("cnyf");
				System.out.println("价格=="+price);
				
				Writer writer;
				try {
					writer = response.getWriter();
					if(price==null||price.length()==0||price.equals("")){
					writer.write("-1");
					}else{
						
						//匹配政策开始
						String scitycode=citycode.substring(0, 3);//起飞机场
						String ecitycode=citycode.substring(3, 6);//到达机场
						String aircompanycode=flightnub.substring(0, 2);//到达机场
						
					//Double zceprice=getZrate(stime,scitycode,ecitycode,cabincode,aircompanycode,flightnub,Double.parseDouble(price));
					
						
						//匹配结束
					writer.write(price.toString());
					
					
					}
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}else{//没有价格
				
				Writer writer;
				try {
					writer = response.getWriter();
					writer.write("-1");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

		
		
	}
	
	/**
	 * 获取特价
	 */
	public void getTJpriceByNFD() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		System.out.println("出发城市=="+citycode);
		String scity=citycode.split(",")[0];
		System.out.println("出发城市=="+citycode.split(",")[0]+",到达城市=="+citycode.split(",")[1]);
		System.out.println("航班=="+flightnub.substring(0, 2));
		System.out.println("出发时间=="+stime);
		System.out.println("仓位=="+cabincode);
	String NFDpirce=	Server.getInstance().getTicketSearchService().GetPriceAndDiscountByNFD(citycode.split(",")[0], citycode.split(",")[1], stime, flightnub.substring(0, 2), cabincode);
	System.out.println("NFDpirce=="+NFDpirce);	
	
	if(NFDpirce.equals("0|0")){//没有价格
		
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write("-1");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}else{
		
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(NFDpirce);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
	//跳转到常用旅客选择页面
	public String seachpass()throws Exception {
		// 查询常用旅客
	   
		
		//String where = " where 1=1 and "+Customerpassenger.COL_customeruserid+"  in ( select "+Customeruser.COL_id+" from "+Customeruser.TABLE + " where "+ Customeruser.COL_agentid +" = "+getLoginUser().getAgentid() +")";
		
		//String where = " where 1=1 ";
		String where = " where 1=1 and "+Customerpassenger.COL_customeruserid+"  in ( select "+Customeruser.COL_id+" from "+Customeruser.TABLE + " where "+ Customeruser.COL_agentid +" = "+getLoginUser().getAgentid() +")";
		String sql=" SELECT * FROM [T_AGENTROLEREF] WHERE C_CUSTOMERUSERID="+this.getLoginUser().getId();
		List<Agentroleref> roles=Server.getInstance().getMemberService().findAllAgentrolerefBySql(sql, -1, 0);
		if(roles!=null&&roles.size()>0){
			Agentroleref agenrole=roles.get(0);
			if(agenrole.getRoleid()==1){
				where="where 1=1";
			}
		}
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Customerpassenger.COL_username +" like '%" + s_name.trim()+"%'";	
		}
		if (c_type>0) {
			
			where += " and " + Customerpassenger.COL_type+" ="+c_type;
		}
		if (s_number!=null && s_number.trim().length()!=0) {
			
			where += " and " + Customerpassenger.COL_mobile +" like '%" + s_number.trim()+"%'";	
		}
		if(customerusername!=null&&customerusername.trim().length()>0){
			where+=" AND "+Customerpassenger.COL_customeruserid+" IN ( SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"+customerusername+"%')";
		}
		pageinfo.setPagerow(5);
	    List list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustPassenger = list;
		  if(pageinfo.getTotalrow()>0 &&   listCustPassenger.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCustPassenger = list;
		}
		System.out.println("c_index:"+c_index);
		return "seachpass";
	}
public String tSearch_old() throws Exception {
		
		if(flightSearch==null || flightSearch.getTravelType()==null)
			flightSearch=(FlightSearch)ActionContext.getContext().getSession().get("FlightSearch");
		
			//flightSearch.setEndAirportCode(flightSearch.getEndAirportCode().trim());
			//flightSearch.setStartAirportCode(flightSearch.getStartAirportCode().trim());
		searchAV(flightSearch, 1);
		if (flightSearch.getTravelType().equals("1")) {
			isBackOrTo = 1;
		}
		
		ActionContext.getContext().getSession().remove("FlightSearch");
		ActionContext.getContext().getSession().put("FlightSearch",flightSearch);
		//如果是联程，将第二成查询条件放入Session
		if(flightSearch.getTravelType().equals("3"))
		{
			flightSearch_lc.setAirCompanyCode(flightSearch.getAirCompanyCode());
			flightSearch_lc.setEndAirportCode(EndAirportCode_lc);
			flightSearch_lc.setStartAirportCode(StartAirportCode_lc);
			flightSearch_lc.setFromDate(FromDate_lc);
			flightSearch_lc.setTravelType(flightSearch.getTravelType());
			ActionContext.getContext().getSession().put("FlightSearch_lc",flightSearch_lc);
		}
		
		System.gc();
		//
		
		
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		//取得代理商的默认城市.
		s_sAirPort=Server.getInstance().getMemberService().findCustomeragent(getLoginUserAgent().getId()).getAirportcode();
		if(s_sAirPort!=null && !s_sAirPort.equals(""))
		{
			
		}
		else
		{
			s_sAirPort="XIY";
		}
		s_sAirPortName=getCitynameByAirport(s_sAirPort);
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);
		
		System.out.println("isBackOrTo:"+isBackOrTo);
		
		if(s_type>0){
			ActionContext.getContext().getSession().remove("s_type");
			ActionContext.getContext().getSession().put("s_type", 1);
		}else{
			
			ActionContext.getContext().getSession().remove("s_type");
			ActionContext.getContext().getSession().put("s_type", 0);
		}
		
		 //ZrateServer.getInstance().startQuery();//
		
		return SUCCESS;
	}
	public String tSearch() throws Exception {
		
		if(flightSearch.getTravelType()!=null
				&&flightSearch.getTravelType().equals("3"))
		{
			
			
			flightSearch_lc.setAirCompanyCode(flightSearch.getAirCompanyCode());
			flightSearch_lc.setEndAirportCode(flightSearch.getEndAirportCode());
			flightSearch_lc.setStartAirportCode(StartAirportCode_lc);
			flightSearch_lc.setFromDate(flightSearch.getBackDate());
			flightSearch_lc.setTravelType(flightSearch.getTravelType());
			ActionContext.getContext().getSession().put("FlightSearch_lc",flightSearch_lc);
			flightSearch.setEndAirportCode(StartAirportCode_lc);
			
		}
		
		
		
		if(flightSearch==null || flightSearch.getTravelType()==null)
			flightSearch=(FlightSearch)ActionContext.getContext().getSession().get("FlightSearch");
		searchAV(flightSearch, 1);
		if (flightSearch.getTravelType().equals("1")) {
			isBackOrTo = 1;
		}
		
		ActionContext.getContext().getSession().remove("FlightSearch");
		ActionContext.getContext().getSession().put("FlightSearch",flightSearch);
		//如果是联程，将第二成查询条件放入Session
		/*if(flightSearch.getTravelType().equals("3"))
		{
			flightSearch_lc.setAirCompanyCode(flightSearch.getAirCompanyCode());
			flightSearch_lc.setEndAirportCode(EndAirportCode_lc);
			flightSearch_lc.setStartAirportCode(StartAirportCode_lc);
			flightSearch_lc.setFromDate(FromDate_lc);
			flightSearch_lc.setTravelType(flightSearch.getTravelType());
			ActionContext.getContext().getSession().put("FlightSearch_lc",flightSearch_lc);
		}*/
		
		System.gc();
		//
		
		
		String where = " where 1=1 and "+Aircompany.COL_countrycode+"='CN'";
		//取得代理商的默认城市.
		s_sAirPort=Server.getInstance().getMemberService().findCustomeragent(getLoginUserAgent().getId()).getAirportcode();
		if(s_sAirPort!=null && !s_sAirPort.equals(""))
		{
			
		}
		else
		{
			s_sAirPort="XIY";
		}
		s_sAirPortName=getCitynameByAirport(s_sAirPort);
		listAircompany = Server.getInstance().getAirService()
				.findAllAircompany(where, " ORDER BY ID ", -1, 0);
		
		System.out.println("isBackOrTo:"+isBackOrTo);
		
		if(s_type>0){
			ActionContext.getContext().getSession().remove("s_type");
			ActionContext.getContext().getSession().put("s_type", 1);
		}else{
			
			ActionContext.getContext().getSession().remove("s_type");
			ActionContext.getContext().getSession().put("s_type", 0);
		}
		
		 //ZrateServer.getInstance().startQuery();//
		
		return SUCCESS;
	}
	
	public void searchAV(FlightSearch flightSearch, int intType) {

		ActionContext.getContext().getSession().remove("segmentTwo");
		ActionContext.getContext().getSession().remove("segmentOne");
		ActionContext.getContext().getSession().remove("travelTypeSession");
		ActionContext.getContext().getSession().remove("travelFlag");
		flightSearch.setFromTime("1");
		listFlightInfoAll = Server.getInstance().getTicketSearchService()
				.findAllFlightinfo(flightSearch);
		
		
		 try
		 {
			 //listFlightInfoAll_9c=AVOpen_9c(flightSearch, intType);
         }
		 catch (Exception e) 
		 {
              System.out.println("9c av error");
         }
		 if(listFlightInfoAll_9c!=null&&listFlightInfoAll_9c.size()>0){
			 for(int u=0;u<listFlightInfoAll_9c.size();u++){
				 listFlightInfoAll.add(listFlightInfoAll_9c.get(u));
			 }
		 }
		 
		 
		 
		/*String comcode=flightSearch.getAirCompanyCode();
		if(comcode==null&&comcode.length()==0){
			comcode="ALL";
		}*/
		//listFlightInfoAll = Server.getInstance().getRateService().IBESeachFlightInfo(flightSearch.getStartAirportCode(), flightSearch.getEndAirportCode(), flightSearch.getFromDate(), comcode);
		//listFlightInfoAll=Server.getInstance().getticketWebService().IBESeachFlightInfo(flightSearch.getStartAirportCode(), flightSearch.getEndAirportCode(), flightSearch.getFromDate(), comcode);
		
		String strSplit=" or ";
		StringBuilder sbWhere=new StringBuilder();//拼接Sql语句，查询临时性质的 退改签 内容(由于不能从接口获取退改签内容)。
		sbWhere.append(" where 1=1 ");
		
		// 临时变量
		Boolean bValueL=false;
		Boolean bValue = listFlightInfoAll.size() > 0;
		if (bValue)
			sbWhere.append(" and (");
		
			/************临时排序Begin措施(后期调整成算法)**************/
			Iterator iteratorL=null;//用于退改签
			
			Iterator iterator= listFlightInfoAll.iterator();
			
			while(iterator.hasNext())
			{
				FlightInfo flightInfo =(FlightInfo)iterator.next();
				this.listOrderPrice(flightInfo.getCarbins());//点击其它舱的时候的排序
				
				//用于退改签 Begin  获取 sql where 条件
				if(flightInfo.getCarbins().size()>0)
					bValueL=true;
				
				iteratorL= flightInfo.getCarbins().iterator();
				while(iteratorL.hasNext())
				{
					CarbinInfo cabin = (CarbinInfo)iteratorL.next();
					sbWhere.append("("+Cabin.COL_aircompanycode+"='"+flightInfo.getAirCompany()+"' and "+Cabin.COL_cabincode+"='"+cabin.getCabin()+"')"+strSplit);
				}
				//用于退改签 End
			}
			if(sbWhere.substring(sbWhere.length()-strSplit.length()).equals(strSplit))
				sbWhere.delete(sbWhere.length()-strSplit.length(), sbWhere.length()-1);
			
			/**
		 		orderItemMap.put(0, "出发时间从早到晚");
				orderItemMap.put(1, "出发时间从晚到早");
				orderItemMap.put(2, "返点从低到高");
				orderItemMap.put(3, "返点从高到低");
				orderItemMap.put(4, "价格从低到高");
				orderItemMap.put(5, "价格从高到低");
			 */
			
			
			//按用户要求排序(系统啊，俺想用枚举...)
			switch(this.orderKey)
			{
				case 1:
					this.listOrderByTime(listFlightInfoAll,false);//起飞时间从晚到早
				break;
				/* 暂时去掉返点的排序--因为页面返点是异步即时读取的，无法有效比较
				case 2:
					//this.listOrderByDiscount(listFlightInfoAll,true);//折扣从低到高
					this.listOrderByRatevalue(listFlightInfoAll,true);//返点从低到高
				break;
				case 3:
					//this.listOrderByDiscount(listFlightInfoAll,false);//折扣从高到低
					this.listOrderByRatevalue(listFlightInfoAll,false);//返点从低到高
				break;
				*/
				case 4:
					this.listOrderByPrice(listFlightInfoAll,true);//价格从低到高
				break;
				case 5:
					this.listOrderByPrice(listFlightInfoAll,false);//价格从高到低
				break;
				case 0://起飞时间从早到晚
					this.listOrderByTime(listFlightInfoAll,true);//默认按照 起飞时间从早到晚
				default:
					this.listOrderByTime(listFlightInfoAll,true);//默认按照 起飞时间从早到晚
				break;
			}
			/************临时排序End措施(后期调整成算法)**************/
			
		if (bValue)
			sbWhere.append(") ");
			
			//System.out.println(sbWhere.toString());
			List<Cabin> myList=(List<Cabin>)Server.getInstance().getAirService().findAllCabin(sbWhere.toString(), "", -1, 0);
		
			/************退改签内容（由于不能从接口获取，因此手动输入的方式临时实现）Begin措施(后期调整成算法)**************/
			iterator= listFlightInfoAll.iterator();
			while(iterator.hasNext())
			{
				FlightInfo flightInfo =(FlightInfo)iterator.next();
				flightInfo.getLowCarbin().setCabinRules(this.stringCabinInfo(myList, flightInfo));
			}
			
			myList=null;

			/************退改签内容（由于不能从接口获取，因此手动输入的方式临时实现）End措施(后期调整成算法)**************/
		/************临时算法 Created by Vic/Wong End **************/
		
		//匹配航空公司名字
		try
		{
	       this.showAirCompayName(listFlightInfoAll);
		}
		catch(Exception ex)
		{
			System.out.println("查询航空公司名称出错");
		}
		
		ActionContext.getContext().getSession().put("travelTypeSession",
				flightSearch.getTravelType()); // 航程类型
		if (intType == 1) {
			ActionContext.getContext().getSession().put("travelFlag", 1);
			ActionContext.getContext().getSession().put("FlightListOne",
					listFlightInfoAll); // 去
		} else if (intType == 2) {
			ActionContext.getContext().getSession().put("travelFlag", 2);
			ActionContext.getContext().getSession().put("FlightListTwo",
					listFlightInfoAll); // 返
		}

		//-------------
		System.gc();
	}
	
	public List<FlightInfo> AVOpen_9c(FlightSearch flightSearch, int intType) {
		System.out.println("===========春秋航班查询开始===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		List<FlightInfo> list = new ArrayList<FlightInfo>();
		
		if(flightSearch.getStartAirportCode().equals("SZX")&&flightSearch.getEndAirportCode().equals("DLC")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SZX")&&flightSearch.getStartAirportCode().equals("LZH")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("JHG")&&flightSearch.getStartAirportCode().equals("CSX")){
			return list;
		}

		if(flightSearch.getStartAirportCode().equals("SHE")&&flightSearch.getStartAirportCode().equals("DYG")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHE")&&flightSearch.getStartAirportCode().equals("KWL")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHE")&&flightSearch.getStartAirportCode().equals("SYX")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("KWL")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("LYA")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("SYX")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("DYG")){
			return list;
		}
		
		if(flightSearch.getStartAirportCode().equals("DLC")&&flightSearch.getStartAirportCode().equals("NBS")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("HGH")&&flightSearch.getStartAirportCode().equals("KWL")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("HGH")&&flightSearch.getStartAirportCode().equals("SYX")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("HGH")&&flightSearch.getStartAirportCode().equals("DYG")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("DYG")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("LYA")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SJW")&&flightSearch.getStartAirportCode().equals("SYX")){
			return list;
		}
		
		if(flightSearch.getStartAirportCode().equals("SHA")&&flightSearch.getStartAirportCode().equals("REP")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHA")&&flightSearch.getStartAirportCode().equals("SYX")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHA")&&flightSearch.getStartAirportCode().equals("NZH")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHA")&&flightSearch.getStartAirportCode().equals("DYG")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHA")&&flightSearch.getStartAirportCode().equals("NBS")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("SHA")&&flightSearch.getStartAirportCode().equals("KWL")){
			return list;
		}
		if(flightSearch.getStartAirportCode().equals("LYA")&&flightSearch.getStartAirportCode().equals("HKG")){
			return list;
		}
		
		
		
		String agentCode = "CX10528";
		String where=" where 1=1 and "+Eaccount.COL_name+" ='9C'";
		List<Eaccount>listEaccount9c=Server.getInstance().getSystemService().findAllEaccount(where, " ORDER BY ID ", -1, 0);
		if(listEaccount9c!=null&&listEaccount9c.size()>0){
			agentCode=listEaccount9c.get(0).getUsername();
		}
		
		String fromCity = flightSearch.getStartAirportCode();
		String toCity = flightSearch.getEndAirportCode();
		String sDate = flightSearch.getFromDate();
		String url = "http://www.cxpw168.com/interface/SearchAir?AgentCode="
				+ agentCode + "&FromCity=" + fromCity + "&ToCity=" + toCity
				+ "&sDate=" + sDate;
		String ret = HttpClient.httpget(url, "GBK");
		
		// 获得dom4j以SAX方式处理xml文档的管道
		SAXReader reader = new SAXReader();
		// 通过管道获得xml文档对象
		InputStream inputStream = (InputStream) (new ByteArrayInputStream(
				ret.getBytes()));
		try {
			Document document = reader.read(inputStream);
			// 获取根节点
			Element root = document.getRootElement();
			Iterator i = root.elementIterator("Flights");
			while (i.hasNext()) {
				Element element = (Element) i.next();
				// <Flights>
				Iterator flight = element.elementIterator("Flight");
				while (flight.hasNext()) {
					Element flightElement = (Element) flight.next();
					// 获得属性值
					String scity = flightElement.attributeValue("scity");
					String ecity = flightElement.attributeValue("ecity");
					String shzl = flightElement.attributeValue("shzl");
					String ehzl = flightElement.attributeValue("ehzl");
					
					String stime = flightElement.attributeValue("stime");
					String etime = flightElement.attributeValue("etime");
					String airtype = flightElement.attributeValue("airtype");
					String airno = flightElement.attributeValue("airno");
					String airportfuee = flightElement
							.attributeValue("airportfuee");
					String fuelfee = flightElement.attributeValue("fuelfee");
					String yprice = flightElement.attributeValue("Yprice");
					System.out.println("-------flight-------");
					System.out.println("scity:" + scity);
					System.out.println("ecity:" + ecity);
					System.out.println("stime:" + stime);
					System.out.println("etime:" + etime);
					System.out.println("airtype:" + airtype);
					System.out.println("airno:" + airno);
					System.out.println("airportfuee:" + airportfuee);
					System.out.println("fuelfee:" + fuelfee);
					System.out.println("Yprice:" + yprice);
					System.out.println("-------cabin-------");
					
					FlightInfo flightInfo1=new FlightInfo();	
					flightInfo1.setAirCompany("9C");
					flightInfo1.setAirCompanyName("春秋");
					flightInfo1.setAirline(airno);
					flightInfo1.setStartAirport(scity);
					flightInfo1.setEndAirport(ecity);
					flightInfo1.setStartAirportHZL(shzl);
					flightInfo1.setEndAirportHZL(ehzl);
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					java.util.Date startDate = dateFormat.parse(stime);
					java.util.Date endDate = dateFormat.parse(etime);
					
					
					flightInfo1.setDepartTime(new Timestamp(startDate.getTime()));//起飞
					flightInfo1.setArriveTime(new Timestamp(endDate.getTime()));//降落
					flightInfo1.setAirplaneType(airtype);
					flightInfo1.setYPrice(Float.parseFloat(yprice));
					flightInfo1.setAirportFee(Integer.parseInt(airportfuee));//基建
					flightInfo1.setFuelFee(Integer.parseInt(fuelfee));//燃油
					
					// 起飞机场名称
					List<Cityairport> listAirPort = Server.getInstance().getAirService().findAllCityairport(
									"WHERE "+ Cityairport.COL_airportcode+ " ='"+ flightInfo1.getStartAirport()+ "'", "", -1, 0);
					if (listAirPort != null && listAirPort.size() > 0) {
						String strSAirPort = listAirPort.get(0).getAirportname();
						flightInfo1.setStartAirportName(strSAirPort);
						String strSCity = listAirPort.get(0).getCityname();
						flightInfo1.setStartAirportCity(strSCity);
					}
					// 到达机场名称
					List<Cityairport> listEAirPort = Server.getInstance().getAirService().findAllCityairport(
									"WHERE "+ Cityairport.COL_airportcode+ " ='"+ flightInfo1.getEndAirport()+ "'", "", -1, 0);
					if (listEAirPort != null && listEAirPort.size() > 0) {
						String strEAirPort = listEAirPort.get(0).getAirportname();
						flightInfo1.setEndAirportName(strEAirPort);
					}
					
					
					List<CarbinInfo> Carbins = new ArrayList<CarbinInfo>();
					
					
					Iterator cabins = flightElement.elementIterator("Cabins");
					while (cabins.hasNext()) {
						Element cabin = (Element) cabins.next();
						Iterator cabinIterator = cabin.elementIterator("cabin");
						while (cabinIterator.hasNext()) {
							Element cabinElement = (Element) cabinIterator
									.next();
							String code = cabinElement.attributeValue("code");
							String price = cabinElement.attributeValue("price");
							String sunm = cabinElement.attributeValue("snum");
							String discount = cabinElement
									.attributeValue("discount");
							String baoxian = cabinElement
									.attributeValue("baoxian");
							String xuanzuo = cabinElement
									.attributeValue("xuanzuo");
							String zratevalue = cabinElement
									.attributeValue("zratevalue");
							System.out.println("code:" + code);
							System.out.println("price:" + price);
							System.out.println("sunm:" + sunm);
							System.out.println("discount:" + discount);
							System.out.println("baoxian:" + baoxian);
							System.out.println("xuanzuo:" + xuanzuo);
							System.out.println("zratevalue:" + zratevalue);
							
							CarbinInfo cabininfo=new CarbinInfo();
							
							cabininfo.setCabin(code);
							cabininfo.setSeatNum(sunm);
							cabininfo.setPrice(Float.parseFloat(price));
							cabininfo.setRatevalue(Float.parseFloat(zratevalue));
							
							Float nfdprice=cabininfo.getPrice();
							if(flightInfo1.getYPrice()!=0){
							Float fdiscount=flightInfo1.getYPrice()*nfdprice/1000;
							
							Double z=Double.parseDouble(nfdprice+"")/Double.parseDouble(flightInfo1.getYPrice()+"");
							BigDecimal   big   =   new   BigDecimal(z);
							double   f1   =   big.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
							String zhekou=f1*100+"";
							cabininfo.setDiscount(Float.parseFloat(zhekou));
							}else{
								
							cabininfo.setDiscount(0f);	
							}
							Carbins.add(cabininfo);
							
							flightInfo1.setCarbins(Carbins);
							flightInfo1.setLowCarbin(Carbins.get(0));
							
						}
					}
					list.add(flightInfo1);
				}
				
			}
			// 通过Xpath的方式寻找节点
			// List<Node>
			// list=element.selectNodes("//OTResponse/Flights/Flight");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	/**
	 * 
	 * @param myList 读取的航空信息中需要匹配的数据并替换对应数据
	 */
	private void showAirCompayName(List<FlightInfo> myList)
	{
		//如果没有数据就不去执行这部分操作了
 		if(myList==null || myList.size()<=0)
 			return;
		try
		{
		FlightInfo fii=null;
		String str="";
		StringBuilder sb=new StringBuilder();
		
		sb.append("select "+Aircompany.COL_id+" as id,"+Aircompany.COL_aircomcode+" as code ,"
				+Aircompany.COL_aircomjname+" as name from " 
				+Aircompany.TABLE + " where 1=1 and "
				+Aircompany.COL_aircomcode+" in (");
		
		Iterator iterator = myList.iterator();
		while(iterator.hasNext())
		{
			fii=(FlightInfo)iterator.next();
			str=fii.getAirCompanyName().trim();
			if(!str.equals(""))
				sb.append("'"+str+"',");
		}

		fii=null;
		str="";
		
		String sql = (sb.substring(sb.length()-1).equals(",")?sb.substring(0,sb.length()-1):sb.toString())+")";

		sb=null;
		//System.out.println(sql);
		//Server.getInstance().getAirService().findAircompany(0l);
		List list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		
		if(list==null && list.size()<=0)
			return;
		
		Object obj=null;
		iterator=null;
		iterator = myList.iterator();
		while(iterator.hasNext())
		{
			fii=(FlightInfo)iterator.next();
			str=fii.getAirCompanyName().trim();
			if(!str.equals(""))
			{
				obj=this.findAirName(list,"code","name",str);
				if(obj!=null)
					fii.setAirCompanyName(String.valueOf(obj));
			}
		}
		
		iterator=null;
		}
		catch(Exception ex)
		{
			System.out.println("取得航空公司名称出错");
		}
	}
	
	/**
	 *@param List list 查找数据的目标列表
	 *@param String keyCode 查找sql语句中对应的字段名
	 *@param String valueCode 查找sql语句中对应的字段名
	 *@return 返回对应航空公司名称的字符串值 或者返回null值
	 * */
	private Object findAirName(List list,String keyCode,String valueCode,String compareValue)
	{
		Object obj=null;
		Map _map=null;
		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		{
			_map=(Map)iterator.next();
			if(String.valueOf(_map.get(keyCode)).equals(compareValue))
			{
				obj=_map.get(valueCode);
				break;
			}
		}

		_map=null;
		return obj;
	}

	/**
	 * 排序(按照折扣)
	 */
	private void listOrderByDiscount(List<FlightInfo> myList,Boolean theValue)
	{
		if (theValue) {//升序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					return arg0.getLowCarbin().getDiscount().compareTo(
							arg1.getLowCarbin().getDiscount());
				}
			});
		} else {//降序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					return arg1.getLowCarbin().getDiscount().compareTo(
							arg0.getLowCarbin().getDiscount());
				}
			});
		}
	
	}
	
	/**
	 * 排序(按照返点)
	 */
	private void listOrderByRatevalue(List<FlightInfo> myList, Boolean theValue) {
		if (theValue) {// 升序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					// System.out.println(arg0.getLowCarbin().getRatevalue()+"==============="+arg1.getLowCarbin().getRatevalue());
					Float arg0proxy = arg0.getLowCarbin().getRatevalue();
					Float arg1proxy = arg1.getLowCarbin().getRatevalue();

					if (arg0proxy == null)
						arg0proxy = 0f;

					if (arg1proxy == null)
						arg1proxy = 0f;

					return arg0proxy.compareTo(arg1proxy);
				}
			});
		} else {// 降序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					// System.out.println(arg0.getLowCarbin().getRatevalue()+"==============="+arg1.getLowCarbin().getRatevalue());
					Float arg0proxy = arg0.getLowCarbin().getRatevalue();
					Float arg1proxy = arg1.getLowCarbin().getRatevalue();

					if (arg0proxy == null)
						arg0proxy = 0f;

					if (arg1proxy == null)
						arg1proxy = 0f;

					return arg1proxy.compareTo(arg0proxy);
				}
			});
		}

	}
	
	/**
	 * 排序(按照价格)
	 */
	private void listOrderByPrice(List<FlightInfo> myList,Boolean theValue)
	{
		if (theValue) {//升序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					return arg0.getLowCarbin().getPrice().compareTo(
							arg1.getLowCarbin().getPrice());
				}
			});
		} else {//降序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					return arg1.getLowCarbin().getPrice().compareTo(
							arg0.getLowCarbin().getPrice());
				}
			});
		}
	
	}
	
	/**
	 * 排序(按照起飞时间)
	 */
	private void listOrderByTime(List<FlightInfo> myList,Boolean theValue)
	{
		if (theValue) {//升序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					return arg0.getDepartTime().compareTo(
							arg1.getDepartTime());
				}
			});
		} else {//降序
			Collections.sort(myList, new Comparator<FlightInfo>() {
				public int compare(FlightInfo arg0, FlightInfo arg1) {
					return arg1.getDepartTime().compareTo(
							arg0.getDepartTime());
				}
			});
		}
	
	}
	
	/**
	 * 排序(按照价格升序)---其它舱位排序
	 */
	private void listOrderPrice(List<CarbinInfo> myList)
	{
		Collections.sort(myList,new Comparator<CarbinInfo>(){    
			     public int compare(CarbinInfo arg0, CarbinInfo arg1) {    
			        return arg0.getPrice().compareTo(arg1.getPrice());    
			       }
			  });  
	}
	
	/**
	 * 
	 * @return 返回退改签内容
	 */
	private String strInfo="暂时没有相关数据";
	private String stringCabinInfo(List<Cabin> myList,FlightInfo myFlightInfo)
	{
		String strRule="";
		for(Cabin cb : myList)
			if (cb.getAircompanycode().equals(myFlightInfo.getAirCompany())
					&& cb.getCabincode().equals(
							myFlightInfo.getLowCarbin().getCabin())) {
				strRule = cb.getCabinrule().trim();
				return strRule.length() > 0 ? strRule : strInfo;
			}
		return strInfo;
	}
	
	public String tobookback() {
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
		String strTableName = HfFligIndex2.split("_")[0]; // 表id前缀
		int intSelFliIndex = Integer.parseInt(HfFligIndex2.split("_")[1]); // 表id值
																			// 选中的航班ID
		int intCabinIndex = 0;
		if (HfCabinid2==null || HfCabinid2.equals("")) {
			intCabinIndex = 0;
		} else {
			intCabinIndex = Integer.parseInt(HfCabinid2);
		}
		List<FlightInfo> listFlightInfoOne = (List<FlightInfo>) ActionContext
				.getContext().getSession().get("FlightListOne");
		flightOne = listFlightInfoOne.get(intSelFliIndex);
		if (strTableName.equals("order")) {
			cabinOne = flightOne.getLowCarbin();
		} else {
			cabinOne = flightOne.getCarbins().get(intCabinIndex);
		}

		String strAirComName = "";// 选中的航空公司名称
		String strAirLine = "";// 选中的航班号
		String strCabin = "";// 选中的舱位
		String strPrice = "";// 选中的舱位价格

		segmentOne.setAircomapnycode(flightOne.getAirCompany());
		segmentOne.setAircompanyname(flightOne.getAirCompanyName()); // 选中航空公司名称
		segmentOne.setFlightnumber(flightOne.getAirline()); // 选中航班号
		segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee()
				.toString())); // 机建费
		segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee()
				.toString())); // 燃油费
		segmentOne.setDeparttime(flightOne.getDepartTime());// 起飞时间
		segmentOne.setArrivaltime(flightOne.getArriveTime()); // 到达时间
		try
		{
		segmentOne.setTraveltype(Integer.parseInt(ActionContext.getContext()
				.getSession().get("travelTypeSession").toString())); // 航程类型
		}
		catch(Exception ex)
		{
			segmentOne.setTraveltype(1);
		}
		segmentOne.setStartairport(flightOne.getStartAirport());
		segmentOne.setEndairport(flightOne.getEndAirport());
		segmentOne.setFlightmodelnum(flightOne.getAirplaneType());// 机型
		segmentOne.setBorderpointat(flightOne.getBorderPointAT());
		segmentOne.setOffpointat(flightOne.getOffPointAT());
		
		segmentOne.setBorderpointat(flightOne.getStartAirportHZL());
		segmentOne.setOffpointat(flightOne.getEndAirportHZL());
		
		segmentOne.setYprice(flightOne.getYPrice());
		segmentOne.setDiscount(cabinOne.getDiscount());

		Zrate zratetemp = null;
		 String fnumber=flightOne.getAirline().substring(2, flightOne.getAirline().length());
		//取得政策信息
		 Float fratevalue=0f;
		Calendar cal1=Calendar.getInstance(); 
	    SimpleDateFormat formatter1=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime1=formatter1.format(cal1.getTime());
	    String strSP="[dbo].[sp_GetZrateByFlight] "+
		"@chufajichang = N'"+segmentOne.getStartairport()+"',@daodajichang = N'"+segmentOne.getEndairport()+"',"+
		"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentOne.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
		"@hangkonggongsi= N'"+segmentOne.getAircomapnycode()+"',"+
		"@cangwei= N'"+cabinOne.getCabin()+"',@hangbanhao= N'"+fnumber+"',@ismulity=1,@isgaofan=1,@agentid=0";
	    System.out.println(strSP);
	   // List listzratesp=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
		
	    
	    List<Zrate> listdzrate=ZrateServer.getInstance().searchZrate(segmentOne.getStartairport(), 
	    		segmentOne.getEndairport(), segmentOne.getAircomapnycode(),
	    		cabinOne.getCabin(), formatTimestampyyyyMMdd(segmentOne.getDeparttime()), 0, fnumber, 1);
	    
	
		Float fvalue=null;
		if(listdzrate.size()>0&&listdzrate.get(0).getRatevalue()!=null&&listdzrate.get(0).getRatevalue()>0&&listdzrate.get(0).getRatevalue().toString().trim().length()>0){
			//开始
			zratetemp=listdzrate.get(0);
		}
		
		
		segmentOne.setParvalue(cabinOne.getPrice());
		segmentOne.setPrice(cabinOne.getPrice());
		if (zratetemp != null) {
			segmentOne.setAgentid(zratetemp.getAgentid());
			segmentOne.setRatevalue( Getliudianvalue(zratetemp.getRatevalue()));
			segmentOne.setParvalue(cabinOne.getPrice());
			//取得返佣值
			 long lagentid=getLoginUser().getAgentid();
			 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
			 String strRabateString="0";
			 try
			 {
				 strRabateString=getAgentRebatevalue(lagentid,cabinOne.getPrice()* Getliudianvalue(zratetemp.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
			 }
			 catch(Exception ex)
			 {
				 strRabateString="0";
			 }
			
			 //计算当前登录代理商的返佣金额
			 Float frabatemoney=0f;
			 String strrabatemoney="0";
//			 if(!strRabateString.equals("0"))
//			 {
			    frabatemoney=Float.parseFloat(strRabateString);
			    strrabatemoney=formatMoney_short(frabatemoney.toString());
//			 }
//			 else
//			 {
//				 frabatemoney=cabinOne.getPrice()* Getliudianvalue(zratetemp.getRatevalue()) / 100;
//			 }
			//取的返佣值结束
			segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
			segmentOne.setZrateid(zratetemp.getId());
		}
		segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());
		ActionContext.getContext().getSession().put("segmentOne", segmentOne);

		// 查询返程航班
		if (issession > 0) {
			flightSearch = (FlightSearch) ActionContext.getContext()
					.getSession().get("FlightSearch");
		}
		FlightSearch flightSearchBack = new FlightSearch();
		if(flightSearch.getTravelType().equals("2"))
		{
			flightSearchBack.setAirCompanyCode(flightSearch.getAirCompanyCode());
			flightSearchBack.setBackDate(flightSearch.getFromDate());
			flightSearchBack.setEndAirportCode(flightSearch.getStartAirportCode());
			flightSearchBack.setStartAirportCode(flightSearch.getEndAirportCode());
			flightSearchBack.setFromDate(flightSearch.getBackDate());
			flightSearchBack.setStartAirPortName(flightSearch.getEndAirPortName());
			flightSearchBack.setEndAirPortName(flightSearch.getStartAirPortName());
			flightSearchBack.setTravelType(flightSearch.getTravelType());
			//设置返程航段的航空公司
			flightSearchBack.setAirCompanyCode(flightOne.getAirCompany());
		}
		else if(flightSearch.getTravelType().equals("3"))
		{
			flightSearchBack=(FlightSearch)ActionContext.getContext().getSession().get("FlightSearch_lc");
			/*flightSearchBack.setBackDate(flightSearchBack.getFromDate());
			flightSearchBack.setFromTime(formatTimestampHHmm_B2B( new Timestamp(reportGetDate(segmentOne.getDeparttime(),"HOUR",5).getTime())));*/
			//flightSearchBack.setFromTime(flightSearchBack.getFromDate());
			flightSearchBack.setFromTime(formatTimestampHHmm_B2B( new Timestamp(reportGetDate(segmentOne.getDeparttime(),"HOUR",5).getTime())));
			flightSearch=flightSearchBack;
		}
		searchAV(flightSearchBack, 2);
		isBackOrTo = 1;
		intCabinIndex = 0;
		return SUCCESS;
	}

	/**
	 * 通过常用旅客id获取证件类型和证件号码
	 * 
	 * @param id
	 *            常用旅客ID
	 * @return 证件对象
	 */
	public Customercredit getCardbyPassengeId(long id) {
		String where = " where 1=1 and " + Customercredit.COL_refid + " = "
				+ id + " and " + Customercredit.COL_type + " = 1";
		List<Customercredit> list = Server.getInstance().getMemberService()
				.findAllCustomercredit(where, "", -1, 0);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 跳转到预订
	 * 
	 * @return
	 */
	public String tocreateorder() {
		
		//判断加盟商
		long lagentid=getLoginUser().getAgentid();
		int isGD=1;//1不是固定  2是固定
		List<Agentvalue> list= new ArrayList<Agentvalue>();
		
		String where=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+lagentid+"'";
		list=Server.getInstance().getMemberService().findAllAgentvalue(where, " order by id desc ", -1, 0);
	
		
		//清空航程Session
		ActionContext.getContext().getSession().remove("segmentTwo");
		ActionContext.getContext().getSession().remove("segmentOne");
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
		// 查询常用旅客
	    String strwhere="WHERE C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_AgentID in ( select C_AGENTID from T_CUSTOMERUSER where ID='"+getLoginUser().getId()+"')) and "+Customerpassenger.COL_type+" = 1";
		//String strwhere="";
			
	    
	    listCustPassenger=Server.getInstance().getMemberService().findAllCustomerpassenger(strwhere, "", -1, 0);
		 System.out.println(strwhere);
		// 航程赋
		//加盟商返佣汇总
		String strCustomgeragentBackPointInfo="";
		String strTableName = s_HfFligIndex.split("_")[0]; // 表id前缀
		int intSelFliIndex = Integer.parseInt(s_HfFligIndex.split("_")[1]); // 表id值
																			// 选中的航班ID
		int intCabinIndex = 0;
		if (HfCabinid.equals("") || HfCabinid == null) {
			intCabinIndex = 0;
		} else {
			intCabinIndex = Integer.parseInt(HfCabinid);
		}
		if (ActionContext.getContext().getSession().get("travelTypeSession").equals("1")) // 单程
		{
			List<FlightInfo> listFlightInfoOne = (List<FlightInfo>) ActionContext
					.getContext().getSession().get("FlightListOne");
			flightOne = listFlightInfoOne.get(intSelFliIndex);
			if (strTableName.equals("order")) {
				cabinOne = flightOne.getLowCarbin();
			} else {
				cabinOne = flightOne.getCarbins().get(intCabinIndex);
			}

			String strAirComName = "";// 选中的航空公司名称
			String strAirLine = "";// 选中的航班号
			String strCabin = "";// 选中的舱位
			String strPrice = "";// 选中的舱位价格
			int intfmoney=0;
			segmentOne.setAircomapnycode(flightOne.getAirCompany());
			segmentOne.setAircompanyname(flightOne.getAirCompanyName()); // 选中航空公司名称
			segmentOne.setFlightnumber(flightOne.getAirline()); // 选中航班号
			segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee()
					.toString())); // 机建费
			segmentOne.setFlightmodel(flightOne.getAirplaneType());
			segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee()
					.toString())); // 燃油费
			segmentOne.setDeparttime(flightOne.getDepartTime());// 起飞时间
			segmentOne.setArrivaltime(flightOne.getArriveTime()); // 到达时间
			segmentOne.setTraveltype(Integer.parseInt(ActionContext
					.getContext().getSession().get("travelTypeSession")
					.toString())); // 航程类型
			segmentOne.setStartairport(flightOne.getStartAirport());
			segmentOne.setEndairport(flightOne.getEndAirport());
			segmentOne.setFlightmodelnum(flightOne.getAirplaneType());// 机型
			segmentOne.setBorderpointat(flightOne.getBorderPointAT());
			segmentOne.setOffpointat(flightOne.getOffPointAT());
			segmentOne.setYprice(flightOne.getYPrice());
			segmentOne.setDiscount(cabinOne.getDiscount());
			segmentOne.setBorderpointat(flightOne.getStartAirportHZL());//起飞航站楼
			segmentOne.setOffpointat(flightOne.getEndAirportHZL());//到达航站楼
			Zrate zratetemp = new Zrate();
			
			 String fnumber=flightOne.getAirline().substring(2, flightOne.getAirline().length());
			//取得政策信息
			 Float fratevalue=0f;
			Calendar cal1=Calendar.getInstance(); 
		    SimpleDateFormat formatter1=new SimpleDateFormat( "HH:mm"); 
		    String mDateTime1=formatter1.format(cal1.getTime());
		    String strSP="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentOne.getStartairport()+"',@daodajichang = N'"+segmentOne.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentOne.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentOne.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinOne.getCabin()+"',@hangbanhao= N'"+fnumber+"',@ismulity=1,@isgaofan=1,@agentid=0";
		    System.out.println(strSP);
		    //List listzratesp=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
			
		    /*List<Zrate> listdzrate=ZrateServer.getInstance().searchZrate(segmentOne.getStartairport(), 
		    		segmentOne.getEndairport(), segmentOne.getAircomapnycode(),
		    		cabinOne.getCabin(), formatTimestampyyyyMMdd(segmentOne.getDeparttime()), 0, fnumber, 1);
		    
		   
		    System.out.println(listdzrate.size());
		    if(listdzrate.size()>0){
		    System.out.println(listdzrate.get(0).getRatevalue());	
		    }else{
		    	
		    	 listdzrate=ZrateServer.getInstance().searchZrate(segmentOne.getStartairport(), 
				    		segmentOne.getEndairport(), segmentOne.getAircomapnycode(),
				    		cabinOne.getCabin(), formatTimestampyyyyMMdd(segmentOne.getDeparttime()), 0, fnumber, 2);
		    }*/
		    
		    
			Float fvalue=null;
			if(listdzrate.size()>0&&listdzrate.get(0).getRatevalue()!=null&&listdzrate.get(0).getRatevalue()>0&&listdzrate.get(0).getRatevalue().toString().trim().length()>0){
				//开始
				zratetemp=listdzrate.get(0);
			}
			
			
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
				zratetemp.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
			}
		    
		    
			//isSPPolicy=listgzratecount.size();
			//查询特殊高政策数量
			segmentOne.setParvalue(cabinOne.getPrice());
			segmentOne.setCabincode(cabinOne.getCabin());
			segmentOne.setPrice(cabinOne.getPrice());
			if (zratetemp != null&&zratetemp.getRatevalue()!=null) {
				segmentOne.setAgentid(zratetemp.getAgentid());
				if(zratetemp!=null&&zratetemp.getRatevalue()!=null){
				segmentOne.setRatevalue(Getliudianvalue(zratetemp.getRatevalue()));
				}
				segmentOne.setParvalue(cabinOne.getPrice());
				segmentOne.setZrateid(zratetemp.getId());
				segmentOne.setRules(cabinOne.getCabinRules());
				//取得返佣值
				 
				 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
				 String strRabateString="0";
				 try
				 {
					 strRabateString=getAgentRebatevalue(lagentid,cabinOne.getPrice()* Getliudianvalue(zratetemp.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
				 }
				 catch(Exception ex)
				 {
					 strRabateString="0";
				 }
				
				 //计算当前登录代理商的返佣金额
				 Float frabatemoney=0f;
				 String strrabatemoney="0";

				 frabatemoney=Float.parseFloat(strRabateString);
				 strrabatemoney=formatMoney_short(frabatemoney.toString());
				
				//取的返佣值结束
				segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
				
				//取得加盟商返佣总计
				//strCustomgeragentBackPointInfo=getCustomerBackPointString(getLoginUserAgent(),zratetemp.getRatevalue(),Getliudianvalue(zratetemp.getRatevalue()),cabinOne.getPrice());
			}
			//segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());
			
			//获取该航班匹配的所有政策
			ActionContext.getContext().getSession().put("segmentOne",segmentOne);

		} 
		else if (ActionContext.getContext().getSession().get("travelTypeSession").equals("2") || ActionContext.getContext().getSession().get("travelTypeSession").equals("3")) // 返程
		{
			String strTableName2 = HfFligIndex2.split("_")[0]; // 表id前缀
			int intSelFliIndex2 = Integer.parseInt(HfFligIndex2.split("_")[1]); // 表id值
																				// 选中的航班ID
			int intCabinIndex2 = 0;
			if (HfCabinid2.equals("")) {
				intCabinIndex2 = 0;
			} else {
				intCabinIndex2 = Integer.parseInt(HfCabinid2);
			}
			List<FlightInfo> listFlightInfoOne = (List<FlightInfo>) ActionContext
					.getContext().getSession().get("FlightListOne");
			flightOne = listFlightInfoOne.get(intSelFliIndex2);
			if (strTableName2.equals("order")) {
				cabinOne = flightOne.getLowCarbin();
			} else {
				cabinOne = flightOne.getCarbins().get(intCabinIndex2);
			}

			String strAirComName = "";// 选中的航空公司名称
			String strAirLine = "";// 选中的航班号
			String strCabin = "";// 选中的舱位
			String strPrice = "";// 选中的舱位价格
			int intfmoney=0;
			segmentOne.setAircomapnycode(flightOne.getAirCompany());
			segmentOne.setAircompanyname(flightOne.getAirCompanyName()); // 选中航空公司名称
			segmentOne.setFlightnumber(flightOne.getAirline()); // 选中航班号
			segmentOne.setFlightmodel(flightOne.getAirplaneType());
			segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee()
					.toString())); // 机建费
			segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee()
					.toString())); // 燃油费
			segmentOne.setDeparttime(flightOne.getDepartTime());// 起飞时间
			segmentOne.setArrivaltime(flightOne.getArriveTime()); // 到达时间
			segmentOne.setTraveltype(Integer.parseInt(ActionContext
					.getContext().getSession().get("travelTypeSession")
					.toString())); // 航程类型
			segmentOne.setStartairport(flightOne.getStartAirport());
			segmentOne.setEndairport(flightOne.getEndAirport());
			segmentOne.setFlightmodelnum(flightOne.getAirplaneType());// 机型
			segmentOne.setBorderpointat(flightOne.getBorderPointAT());
			segmentOne.setOffpointat(flightOne.getOffPointAT());
			segmentOne.setBorderpointat(flightOne.getStartAirportHZL());//起飞航站楼
			segmentOne.setOffpointat(flightOne.getEndAirportHZL());//到达航站楼
			
			segmentOne.setYprice(flightOne.getYPrice());
			segmentOne.setDiscount(cabinOne.getDiscount());
			/*List<Zrate> listzrate = (List<Zrate>) ActionContext.getContext()
					.getSession().get(this.getLoginUserId() + "zrateone");*/
			Zrate zratetemp = null;
			
			String fnumber=flightOne.getAirline().substring(2, flightOne.getAirline().length());
			
			//取得政策信息
			 Float fratevalue=0f;
			Calendar cal1=Calendar.getInstance(); 
		    SimpleDateFormat formatter1=new SimpleDateFormat( "HH:mm"); 
		    String mDateTime1=formatter1.format(cal1.getTime());
		    String strSP="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentOne.getStartairport()+"',@daodajichang = N'"+segmentOne.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentOne.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentOne.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinOne.getCabin()+"',@hangbanhao= N'"+fnumber+"',@ismulity=1,@isgaofan=1,@agentid=0";
		    System.out.println(strSP);
		    //List listzratesp=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
		    
		    
		    List<Zrate> listdzrate=ZrateServer.getInstance().searchZrate(segmentOne.getStartairport(), 
		    		segmentOne.getEndairport(), segmentOne.getAircomapnycode(),
		    		cabinOne.getCabin(), formatTimestampyyyyMMdd(segmentOne.getDeparttime()), 0, fnumber, 1);
		    
			
			
			Float fvalue=null;
			if(listdzrate.size()>0&&listdzrate.get(0).getRatevalue()!=null&&listdzrate.get(0).getRatevalue()>0&&listdzrate.get(0).getRatevalue().toString().trim().length()>0){
				//开始
				zratetemp=listdzrate.get(0);
			}
			
			
			//判断开始
			
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
				zratetemp.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
			}
			//判断结束
			
			segmentOne.setParvalue(cabinOne.getPrice());
			segmentOne.setCabincode(cabinOne.getCabin());
			segmentOne.setPrice(cabinOne.getPrice());
			if (zratetemp != null&&zratetemp.getRatevalue()!=null) {
				segmentOne.setAgentid(zratetemp.getAgentid());
				segmentOne.setRatevalue(Getliudianvalue(zratetemp.getRatevalue()));
				segmentOne.setParvalue(cabinOne.getPrice());
				segmentOne.setZrateid(zratetemp.getId());
				segmentOne.setRules(cabinOne.getCabinRules());
				//取得返佣值
				
				 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
				 String strRabateString="0";
				 try
				 {
					 strRabateString=getAgentRebatevalue(lagentid,cabinOne.getPrice()* Getliudianvalue(zratetemp.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
				 }
				 catch(Exception ex)
				 {
					 strRabateString="0";
				 }
				
				 //计算当前登录代理商的返佣金额
				 Float frabatemoney=0f;
				 String strrabatemoney="0";
				 frabatemoney=Float.parseFloat(strRabateString);
				 strrabatemoney=formatMoney_short(frabatemoney.toString());
				//取的返佣值结束
				//segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
				segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
				segmentOne.setZrateid(zratetemp.getId());
				//取得加盟商返佣总计
				//strCustomgeragentBackPointInfo=getCustomerBackPointString(getLoginUserAgent(),zratetemp.getRatevalue(),Getliudianvalue(zratetemp.getRatevalue()),cabinOne.getPrice());
			} else {
			}
			//segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());

			ActionContext.getContext().getSession().put("segmentOne",
					segmentOne);

			// 第二程
			List<FlightInfo> listFlightInfoTwo = (List<FlightInfo>) ActionContext
					.getContext().getSession().get("FlightListTwo");
			flightTwo = listFlightInfoTwo.get(intSelFliIndex);
			if (strTableName.equals("order")) {
				cabinTwo = flightTwo.getLowCarbin();
			} else {
				cabinTwo = flightTwo.getCarbins().get(intCabinIndex);
			}

			segmentTwo.setAircomapnycode(flightTwo.getAirCompany());
			segmentTwo.setAircompanyname(flightTwo.getAirCompanyName()); // 选中航空公司名称
			segmentTwo.setFlightnumber(flightTwo.getAirline()); // 选中航班号
			segmentTwo.setFlightmodel(flightOne.getAirplaneType());
			segmentTwo.setAirportfee(Float.parseFloat(flightTwo.getAirportFee()
					.toString())); // 机建费
			segmentTwo.setFuelfee(Float.parseFloat(flightTwo.getFuelFee()
					.toString())); // 燃油费
			segmentTwo.setDeparttime(flightTwo.getDepartTime());// 起飞时间
			segmentTwo.setArrivaltime(flightTwo.getArriveTime()); // 到达时间
			segmentTwo.setTraveltype(Integer.parseInt(ActionContext
					.getContext().getSession().get("travelTypeSession")
					.toString())); // 航程类型
			segmentTwo.setStartairport(flightTwo.getStartAirport());
			segmentTwo.setEndairport(flightTwo.getEndAirport());
			segmentTwo.setFlightmodelnum(flightTwo.getAirplaneType());// 机型
			segmentTwo.setBorderpointat(flightTwo.getBorderPointAT());
			segmentTwo.setOffpointat(flightTwo.getOffPointAT());
			segmentTwo.setYprice(flightTwo.getYPrice());
			segmentTwo.setDiscount(cabinTwo.getDiscount());
			
			segmentTwo.setBorderpointat(flightTwo.getStartAirportHZL());//起飞航站楼
			segmentTwo.setOffpointat(flightTwo.getEndAirportHZL());//到达航站楼
			
			String fnumber2=flightTwo.getAirline().substring(2, flightTwo.getAirline().length());
			
			    
			//取得政策信息
		    String strSP2="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentTwo.getStartairport()+"',@daodajichang = N'"+segmentTwo.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentTwo.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentTwo.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinTwo.getCabin()+"',@hangbanhao= N'"+fnumber2+"',@ismulity=1,@isgaofan=1,@agentid=0";
		    System.out.println(strSP2);
		   // List listzratesp2=Server.getInstance().getSystemService().findMapResultByProcedure(strSP2);
			
			//获取政策列表信息
		    List<Zrate> listdzratetwo=ZrateServer.getInstance().searchZrate(segmentTwo.getStartairport(), 
		    		segmentTwo.getEndairport(), segmentTwo.getAircomapnycode(),
		    		cabinTwo.getCabin(), formatTimestampyyyyMMdd(segmentTwo.getDeparttime()), 0, fnumber2, 1);
		    
		    
			
			Zrate zratetemp2 = null;
			if(listdzratetwo.size()>0)
			{
			   zratetemp2=listdzratetwo.get(0);
			}
			else
			{
				zratetemp2=listdzrate.get(0);
			}
			
			//判断开始
			
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
				zratetemp2.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
			}
			//判断结束
			
			segmentTwo.setParvalue(cabinTwo.getPrice());
			segmentTwo.setPrice(cabinTwo.getPrice());
			segmentTwo.setCabincode(cabinTwo.getCabin());
			if (zratetemp2 != null&&zratetemp2.getRatevalue()!=null) {
				segmentTwo.setAgentid(zratetemp2.getAgentid());
				segmentTwo.setRatevalue(Getliudianvalue(zratetemp2.getRatevalue()));
				segmentTwo.setParvalue(cabinTwo.getPrice());
				segmentTwo.setZrateid(zratetemp2.getId());
				segmentTwo.setRules(cabinTwo.getCabinRules());
				
				//取得返佣值
				
				 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
				 String strRabateString="0";
				 try
				 {
					 strRabateString=getAgentRebatevalue(lagentid,cabinTwo.getPrice()* Getliudianvalue(zratetemp2.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
				 }
				 catch(Exception ex)
				 {
					 strRabateString="0";
				 }
				
				 //计算当前登录代理商的返佣金额
				 Float frabatemoney=0f;
				 String strrabatemoney="0";
				 frabatemoney=Float.parseFloat(strRabateString);
				 strrabatemoney=formatMoney_short(frabatemoney.toString());
				//取的返佣值结束
				 
				segmentTwo.setPrice(cabinTwo.getPrice() - frabatemoney);
				//取得加盟商返佣总计
				//strCustomgeragentBackPointInfo+=getCustomerBackPointString(getLoginUserAgent(),zratetemp2.getRatevalue(),Getliudianvalue(zratetemp2.getRatevalue()),cabinTwo.getPrice());
			}
			//segmentTwo.setRules(flightTwo.getLowCarbin().getCabinRules());
			ActionContext.getContext().getSession().put("segmentTwo",segmentTwo);
			
		}
//        System.out.println("加盟商返佣明细："+strCustomgeragentBackPointInfo);
//        //将加盟商返佣明细保存
//        ActionContext.getContext().getSession().put("BackPointInfo",strCustomgeragentBackPointInfo);
		return "ticketorder";
	}
	/**
	 * 跳转到预订-查询本地数据库
	 * 
	 * @return
	 */
	public String tocreateorder_todb() {
		
		//判断加盟商
		long lagentid=getLoginUser().getAgentid();
		int isGD=1;//1不是固定  2是固定
		List<Agentvalue> list= new ArrayList<Agentvalue>();
		
		String where=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+lagentid+"'";
		list=Server.getInstance().getMemberService().findAllAgentvalue(where, " order by id desc ", -1, 0);
	
		
		//清空航程Session
		ActionContext.getContext().getSession().remove("segmentTwo");
		ActionContext.getContext().getSession().remove("segmentOne");
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
		// 查询常用旅客
	    String strwhere="WHERE C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_AgentID in ( select C_AGENTID from T_CUSTOMERUSER where ID='"+getLoginUser().getId()+"')) and "+Customerpassenger.COL_type+" = 1";
		//String strwhere="";
			
	    
	    listCustPassenger=Server.getInstance().getMemberService().findAllCustomerpassenger(strwhere, "", -1, 0);
		 System.out.println(strwhere);
		// 航程赋
		//加盟商返佣汇总
		String strCustomgeragentBackPointInfo="";
		String strTableName = s_HfFligIndex.split("_")[0]; // 表id前缀
		int intSelFliIndex = Integer.parseInt(s_HfFligIndex.split("_")[1]); // 表id值
																			// 选中的航班ID
		int intCabinIndex = 0;
		if (HfCabinid.equals("") || HfCabinid == null) {
			intCabinIndex = 0;
		} else {
			intCabinIndex = Integer.parseInt(HfCabinid);
		}
		if (ActionContext.getContext().getSession().get("travelTypeSession").equals("1")) // 单程
		{
			List<FlightInfo> listFlightInfoOne = (List<FlightInfo>) ActionContext
					.getContext().getSession().get("FlightListOne");
			flightOne = listFlightInfoOne.get(intSelFliIndex);
			if (strTableName.equals("order")) {
				cabinOne = flightOne.getLowCarbin();
			} else {
				cabinOne = flightOne.getCarbins().get(intCabinIndex);
			}

			String strAirComName = "";// 选中的航空公司名称
			String strAirLine = "";// 选中的航班号
			String strCabin = "";// 选中的舱位
			String strPrice = "";// 选中的舱位价格
			int intfmoney=0;
			segmentOne.setAircomapnycode(flightOne.getAirCompany());
			segmentOne.setAircompanyname(flightOne.getAirCompanyName()); // 选中航空公司名称
			segmentOne.setFlightnumber(flightOne.getAirline()); // 选中航班号
			segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee()
					.toString())); // 机建费
			segmentOne.setFlightmodel(flightOne.getAirplaneType());
			segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee()
					.toString())); // 燃油费
			segmentOne.setDeparttime(flightOne.getDepartTime());// 起飞时间
			segmentOne.setArrivaltime(flightOne.getArriveTime()); // 到达时间
			segmentOne.setTraveltype(Integer.parseInt(ActionContext
					.getContext().getSession().get("travelTypeSession")
					.toString())); // 航程类型
			segmentOne.setStartairport(flightOne.getStartAirport());
			segmentOne.setEndairport(flightOne.getEndAirport());
			segmentOne.setFlightmodelnum(flightOne.getAirplaneType());// 机型
			segmentOne.setBorderpointat(flightOne.getBorderPointAT());
			segmentOne.setOffpointat(flightOne.getOffPointAT());
			segmentOne.setYprice(flightOne.getYPrice());
			segmentOne.setDiscount(cabinOne.getDiscount());
			segmentOne.setBorderpointat(flightOne.getStartAirportHZL());//起飞航站楼
			segmentOne.setOffpointat(flightOne.getEndAirportHZL());//到达航站楼
			Zrate zratetemp = new Zrate();
			
			 String fnumber=flightOne.getAirline().substring(2, flightOne.getAirline().length());
			//取得政策信息
			 Float fratevalue=0f;
			Calendar cal1=Calendar.getInstance(); 
		    SimpleDateFormat formatter1=new SimpleDateFormat( "HH:mm"); 
		    String mDateTime1=formatter1.format(cal1.getTime());
		    String strSP="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentOne.getStartairport()+"',@daodajichang = N'"+segmentOne.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentOne.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentOne.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinOne.getCabin()+"',@hangbanhao= N'"+fnumber+"',@ismulity=1,@isgaofan=1,@agentid=0";
		    System.out.println(strSP);
		    List listzratesp=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
			
			//获取政策列表信息
			for(int i=0;i<listzratesp.size();i++)
			{
				Map listzratemap = (Map) listzratesp.get(i);
				long lzrateid=Long.parseLong(listzratemap.get("zrateid").toString());
				Zrate zrateinfo = Server.getInstance().getAirService().findZrate(lzrateid);
				listdzrate.add(zrateinfo);
			}
			Float fvalue=null;
			if(listdzrate.size()>0&&listdzrate.get(0).getRatevalue()!=null&&listdzrate.get(0).getRatevalue()>0&&listdzrate.get(0).getRatevalue().toString().trim().length()>0){
				//开始
				zratetemp=listdzrate.get(0);
			}
			
			
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
				zratetemp.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
			}
			
			
			
			//查询特殊高政策数量
			Calendar cal2=Calendar.getInstance(); 
		    String strSPSppolicy="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentOne.getStartairport()+"',@daodajichang = N'"+segmentOne.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentOne.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentOne.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinOne.getCabin()+"',@hangbanhao= N'"+fnumber+"',@ismulity=1,@isgaofan=2,@agentid=0";
		    List listgzratecount=Server.getInstance().getSystemService().findMapResultByProcedure(strSPSppolicy);
			//isSPPolicy=listgzratecount.size();
			//查询特殊高政策数量
			segmentOne.setParvalue(cabinOne.getPrice());
			segmentOne.setCabincode(cabinOne.getCabin());
			segmentOne.setPrice(cabinOne.getPrice());
			if (zratetemp != null) {
				segmentOne.setAgentid(zratetemp.getAgentid());
				segmentOne.setRatevalue(Getliudianvalue(zratetemp.getRatevalue()));
				segmentOne.setParvalue(cabinOne.getPrice());
				segmentOne.setZrateid(zratetemp.getId());
				segmentOne.setRules(zratetemp.getRemark());
				//取得返佣值
				
				 
				 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
				 String strRabateString="0";
				 try
				 {
					 strRabateString=getAgentRebatevalue(lagentid,cabinOne.getPrice()* Getliudianvalue(zratetemp.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
				 }
				 catch(Exception ex)
				 {
					 strRabateString="0";
				 }
				
				 //计算当前登录代理商的返佣金额
				 Float frabatemoney=0f;
				 String strrabatemoney="0";

				 frabatemoney=Float.parseFloat(strRabateString);
				 strrabatemoney=formatMoney_short(frabatemoney.toString());
				
				//取的返佣值结束
				segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
				
				//取得加盟商返佣总计
				//strCustomgeragentBackPointInfo=getCustomerBackPointString(getLoginUserAgent(),zratetemp.getRatevalue(),Getliudianvalue(zratetemp.getRatevalue()),cabinOne.getPrice());
			}
			//segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());
			
			//获取该航班匹配的所有政策
			ActionContext.getContext().getSession().put("segmentOne",segmentOne);

		} 
		else if (ActionContext.getContext().getSession().get("travelTypeSession").equals("2") || ActionContext.getContext().getSession().get("travelTypeSession").equals("3")) // 返程
		{
			String strTableName2 = HfFligIndex2.split("_")[0]; // 表id前缀
			int intSelFliIndex2 = Integer.parseInt(HfFligIndex2.split("_")[1]); // 表id值
																				// 选中的航班ID
			int intCabinIndex2 = 0;
			if (HfCabinid2.equals("")) {
				intCabinIndex2 = 0;
			} else {
				intCabinIndex2 = Integer.parseInt(HfCabinid2);
			}
			List<FlightInfo> listFlightInfoOne = (List<FlightInfo>) ActionContext
					.getContext().getSession().get("FlightListOne");
			flightOne = listFlightInfoOne.get(intSelFliIndex2);
			if (strTableName2.equals("order")) {
				cabinOne = flightOne.getLowCarbin();
			} else {
				cabinOne = flightOne.getCarbins().get(intCabinIndex2);
			}

			String strAirComName = "";// 选中的航空公司名称
			String strAirLine = "";// 选中的航班号
			String strCabin = "";// 选中的舱位
			String strPrice = "";// 选中的舱位价格
			int intfmoney=0;
			segmentOne.setAircomapnycode(flightOne.getAirCompany());
			segmentOne.setAircompanyname(flightOne.getAirCompanyName()); // 选中航空公司名称
			segmentOne.setFlightnumber(flightOne.getAirline()); // 选中航班号
			segmentOne.setFlightmodel(flightOne.getAirplaneType());
			segmentOne.setAirportfee(Float.parseFloat(flightOne.getAirportFee()
					.toString())); // 机建费
			segmentOne.setFuelfee(Float.parseFloat(flightOne.getFuelFee()
					.toString())); // 燃油费
			segmentOne.setDeparttime(flightOne.getDepartTime());// 起飞时间
			segmentOne.setArrivaltime(flightOne.getArriveTime()); // 到达时间
			segmentOne.setTraveltype(Integer.parseInt(ActionContext
					.getContext().getSession().get("travelTypeSession")
					.toString())); // 航程类型
			segmentOne.setStartairport(flightOne.getStartAirport());
			segmentOne.setEndairport(flightOne.getEndAirport());
			segmentOne.setFlightmodelnum(flightOne.getAirplaneType());// 机型
			segmentOne.setBorderpointat(flightOne.getBorderPointAT());
			segmentOne.setOffpointat(flightOne.getOffPointAT());
			segmentOne.setBorderpointat(flightOne.getStartAirportHZL());//起飞航站楼
			segmentOne.setOffpointat(flightOne.getEndAirportHZL());//到达航站楼
			
			segmentOne.setYprice(flightOne.getYPrice());
			segmentOne.setDiscount(cabinOne.getDiscount());
			/*List<Zrate> listzrate = (List<Zrate>) ActionContext.getContext()
					.getSession().get(this.getLoginUserId() + "zrateone");*/
			Zrate zratetemp = null;
			
			String fnumber=flightOne.getAirline().substring(2, flightOne.getAirline().length());
			
			//取得政策信息
			 Float fratevalue=0f;
			Calendar cal1=Calendar.getInstance(); 
		    SimpleDateFormat formatter1=new SimpleDateFormat( "HH:mm"); 
		    String mDateTime1=formatter1.format(cal1.getTime());
		    String strSP="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentOne.getStartairport()+"',@daodajichang = N'"+segmentOne.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentOne.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentOne.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinOne.getCabin()+"',@hangbanhao= N'"+fnumber+"',@ismulity=1,@isgaofan=1,@agentid=0";
		    System.out.println(strSP);
		    List listzratesp=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
			
			//获取政策列表信息
			for(int i=0;i<listzratesp.size();i++)
			{
				Map listzratemap = (Map) listzratesp.get(i);
				long lzrateid=Long.parseLong(listzratemap.get("zrateid").toString());
				Zrate zrateinfo = Server.getInstance().getAirService().findZrate(lzrateid);
				listdzrate.add(zrateinfo);
			}
			Float fvalue=null;
			if(listdzrate.size()>0&&listdzrate.get(0).getRatevalue()!=null&&listdzrate.get(0).getRatevalue()>0&&listdzrate.get(0).getRatevalue().toString().trim().length()>0){
				//开始
				zratetemp=listdzrate.get(0);
			}
			
			
			//判断开始
			
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
				zratetemp.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
			}
			//判断结束
			
			segmentOne.setParvalue(cabinOne.getPrice());
			segmentOne.setCabincode(cabinOne.getCabin());
			segmentOne.setPrice(cabinOne.getPrice());
			if (zratetemp != null) {
				segmentOne.setAgentid(zratetemp.getAgentid());
				segmentOne.setRatevalue(Getliudianvalue(zratetemp.getRatevalue()));
				segmentOne.setParvalue(cabinOne.getPrice());
				segmentOne.setZrateid(zratetemp.getId());
				segmentOne.setRules(zratetemp.getRemark());
				//取得返佣值
				
				 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
				 String strRabateString="0";
				 try
				 {
					 strRabateString=getAgentRebatevalue(lagentid,cabinOne.getPrice()* Getliudianvalue(zratetemp.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
				 }
				 catch(Exception ex)
				 {
					 strRabateString="0";
				 }
				
				 //计算当前登录代理商的返佣金额
				 Float frabatemoney=0f;
				 String strrabatemoney="0";
				 frabatemoney=Float.parseFloat(strRabateString);
				 strrabatemoney=formatMoney_short(frabatemoney.toString());
				//取的返佣值结束
				//segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
				segmentOne.setPrice(cabinOne.getPrice() - frabatemoney);
				segmentOne.setZrateid(zratetemp.getId());
				//取得加盟商返佣总计
				//strCustomgeragentBackPointInfo=getCustomerBackPointString(getLoginUserAgent(),zratetemp.getRatevalue(),Getliudianvalue(zratetemp.getRatevalue()),cabinOne.getPrice());
			} else {
			}
			//segmentOne.setRules(flightOne.getLowCarbin().getCabinRules());

			ActionContext.getContext().getSession().put("segmentOne",
					segmentOne);

			// 第二程
			List<FlightInfo> listFlightInfoTwo = (List<FlightInfo>) ActionContext
					.getContext().getSession().get("FlightListTwo");
			flightTwo = listFlightInfoTwo.get(intSelFliIndex);
			if (strTableName.equals("order")) {
				cabinTwo = flightTwo.getLowCarbin();
			} else {
				cabinTwo = flightTwo.getCarbins().get(intCabinIndex);
			}

			segmentTwo.setAircomapnycode(flightTwo.getAirCompany());
			segmentTwo.setAircompanyname(flightTwo.getAirCompanyName()); // 选中航空公司名称
			segmentTwo.setFlightnumber(flightTwo.getAirline()); // 选中航班号
			segmentTwo.setFlightmodel(flightOne.getAirplaneType());
			segmentTwo.setAirportfee(Float.parseFloat(flightTwo.getAirportFee()
					.toString())); // 机建费
			segmentTwo.setFuelfee(Float.parseFloat(flightTwo.getFuelFee()
					.toString())); // 燃油费
			segmentTwo.setDeparttime(flightTwo.getDepartTime());// 起飞时间
			segmentTwo.setArrivaltime(flightTwo.getArriveTime()); // 到达时间
			segmentTwo.setTraveltype(Integer.parseInt(ActionContext
					.getContext().getSession().get("travelTypeSession")
					.toString())); // 航程类型
			segmentTwo.setStartairport(flightTwo.getStartAirport());
			segmentTwo.setEndairport(flightTwo.getEndAirport());
			segmentTwo.setFlightmodelnum(flightTwo.getAirplaneType());// 机型
			segmentTwo.setBorderpointat(flightTwo.getBorderPointAT());
			segmentTwo.setOffpointat(flightTwo.getOffPointAT());
			segmentTwo.setYprice(flightTwo.getYPrice());
			segmentTwo.setDiscount(cabinTwo.getDiscount());
			
			segmentTwo.setBorderpointat(flightTwo.getStartAirportHZL());//起飞航站楼
			segmentTwo.setOffpointat(flightTwo.getEndAirportHZL());//到达航站楼
			
			String fnumber2=flightTwo.getAirline().substring(2, flightTwo.getAirline().length());
			
			    
			//取得政策信息
		    String strSP2="[dbo].[sp_GetZrateByFlight] "+
			"@chufajichang = N'"+segmentTwo.getStartairport()+"',@daodajichang = N'"+segmentTwo.getEndairport()+"',"+
			"@chufariqi = N'"+formatTimestampyyyyMMdd(segmentTwo.getDeparttime())+"',@dangqianshijian= N'"+mDateTime1+"',"+
			"@hangkonggongsi= N'"+segmentTwo.getAircomapnycode()+"',"+
			"@cangwei= N'"+cabinTwo.getCabin()+"',@hangbanhao= N'"+fnumber2+"',@ismulity=1,@isgaofan=1,@agentid=0";
		    System.out.println(strSP2);
		    List listzratesp2=Server.getInstance().getSystemService().findMapResultByProcedure(strSP2);
			
			//获取政策列表信息
			for(int i=0;i<listzratesp2.size();i++)
			{
				Map listzratemap = (Map) listzratesp2.get(i);
				long lzrateid=Long.parseLong(listzratemap.get("zrateid").toString());
				Zrate zrateinfo = Server.getInstance().getAirService().findZrate(lzrateid);
				listdzratetwo.add(zrateinfo);
			}
			
			Zrate zratetemp2 = null;
			if(listdzratetwo.size()>0)
			{
			   zratetemp2=listdzratetwo.get(0);
			}
			else
			{
				zratetemp2=listdzrate.get(0);
			}
			
			//判断开始
			
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
				zratetemp2.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
			}
			//判断结束
			
			segmentTwo.setParvalue(cabinTwo.getPrice());
			segmentTwo.setPrice(cabinTwo.getPrice());
			segmentTwo.setCabincode(cabinTwo.getCabin());
			if (zratetemp2 != null) {
				segmentTwo.setAgentid(zratetemp2.getAgentid());
				segmentTwo.setRatevalue(Getliudianvalue(zratetemp2.getRatevalue()));
				segmentTwo.setParvalue(cabinTwo.getPrice());
				segmentTwo.setZrateid(zratetemp2.getId());
				segmentTwo.setRules(zratetemp2.getRemark());
				
				//取得返佣值
				
				 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
				 String strRabateString="0";
				 try
				 {
					 strRabateString=getAgentRebatevalue(lagentid,cabinTwo.getPrice()* Getliudianvalue(zratetemp2.getRatevalue())/ 100,1,getLoginUserAgent().getAgentjibie());
				 }
				 catch(Exception ex)
				 {
					 strRabateString="0";
				 }
				
				 //计算当前登录代理商的返佣金额
				 Float frabatemoney=0f;
				 String strrabatemoney="0";
				 frabatemoney=Float.parseFloat(strRabateString);
				 strrabatemoney=formatMoney_short(frabatemoney.toString());
				//取的返佣值结束
				 
				segmentTwo.setPrice(cabinTwo.getPrice() - frabatemoney);
				//取得加盟商返佣总计
				//strCustomgeragentBackPointInfo+=getCustomerBackPointString(getLoginUserAgent(),zratetemp2.getRatevalue(),Getliudianvalue(zratetemp2.getRatevalue()),cabinTwo.getPrice());
			}
			//segmentTwo.setRules(flightTwo.getLowCarbin().getCabinRules());
			ActionContext.getContext().getSession().put("segmentTwo",segmentTwo);
			
		}
//        System.out.println("加盟商返佣明细："+strCustomgeragentBackPointInfo);
//        //将加盟商返佣明细保存
//        ActionContext.getContext().getSession().put("BackPointInfo",strCustomgeragentBackPointInfo);
		return "ticketorder";
	}

	// 通过航空公司二字码和仓位吗获取名称
	public String getynamebycode(float discount) {
		if (discount >= 150) {
			return "头等舱";
		} else if (discount >= 130) {
			return "商务舱";
		} else {
			return "经济舱";
		}
	}

	// 获取机场城市数据
	public void getCityAirPortData() throws Exception {
		String strRetData = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strWhere = "where 1=1";
		String language = "";
		if (ActionContext.getContext().getSession().get("language") != null) {
			language = ActionContext.getContext().getSession().get("language")
					.toString();
			if (language != null && !language.equals("")) {
				strWhere += "and " + Cityairport.COL_language + " =0 and "+Cityairport.COL_countrycode+"='CN'";
			}
		} else {
			strWhere += "and " + Cityairport.COL_language + " =0 and "+Cityairport.COL_countrycode+"='CN'";
		}
		List<Cityairport> listAirport = Server.getInstance().getAirService()
		.findAllCityairport("WHERE 1=1 ", "ORDER BY C_CITYINDEX", -1, 0);
		for (Cityairport airPort : listAirport) {
			sb.append(airPort.getCityname() + "#" + airPort.getAirportcode()+airPort.getShortpinyin()+airPort.getPinyin() + "%"
					+ airPort.getAirportcode() + "&" + airPort.getAirportcode()
					+ ",");
		}
		// return strRetData;
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 根据机场代码获取城市名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getCitynameByAirport(String airport) {
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getCityname() : "";

	}

	/**
	 * 通过飞机型号获取信息
	 * 
	 */
	public String getflightmodeldes(String num) {
		List<Flightmodel> list = Server.getInstance().getAirService()
				.findAllFlightmodel(
						" where 1=1 and " + Flightmodel.COL_modelnum + " = '"
								+ num + "'", "", -1, 0);
		if (list != null && list.size() > 0) {
			return list.get(0).getModeldesc() + "#" + list.get(0).getPicpath();
		}
		return "";
	}

	public String gettejia() {
		listspe = Server.getInstance().getAirService().findAllSpecialprice(
				" where 1=1 and " + Specialprice.COL_startport + " = '"
						+ spestr + "'", "", -1, 0);
		listSysmenssage2 = Server.getInstance().getMemberService()
				.findAllInfocontent(
						" where 1=1 and " + Infocontent.COL_typeid + " = 4",
						"", 6, 0);
		return "tticket";
	}

	public void findallzrate() {
//		Date dateNow=new Date(System.currentTimeMillis());
//		Calendar cal=Calendar.getInstance(); 
//	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
//	    String mDateTime=formatter.format(cal.getTime());
//	    
//		if (isBackOrTo == 1) {
//
//			flightSearch = (FlightSearch) ActionContext.getContext()
//					.getSession().get("FlightSearch");
//			
//		    
//			String sql = "where C_DEPARTUREPORT like '%"
//				+ z_endcity
//				+ "%'"
//				+ " and C_ARRIVALPORT like '%"
//				+ z_startcity
//				+ "%'"
//				+ " AND C_ISENABLE =1"
//				+ " and '"+flightSearch.getFromDate()+"' between C_BEGINDATE and C_ENDDATE  AND '"+mDateTime+"' between C_WORKTIME and C_AFTERWORKTIME  and C_RATEVALUE>0";
//			System.out.println(sql);
//			List<Zrate> listzrate = Server
//					.getInstance()
//					.getAirService()
//					.findAllZrate(sql,
//							" ORDER BY " + Zrate.COL_ratevalue + " DESC", -1, 0);
//			ActionContext.getContext().getSession().put(
//					this.getLoginUserId() + "zratetwo", listzrate);
//
//		} else {
//			
//
//			flightSearch = (FlightSearch) ActionContext.getContext()
//					.getSession().get("FlightSearch");
//			String sql = "where C_DEPARTUREPORT like '%"
//				+ z_startcity
//				+ "%'"
//				+ " and C_ARRIVALPORT like '%"
//				+ z_endcity
//				+ "%'"
//				+ " AND C_ISENABLE =1"
//				+ " AND C_GENERAL =1"
//				+ " and '"+flightSearch.getFromDate()+"' between C_BEGINDATE and C_ENDDATE  AND '"+mDateTime+"' between C_WORKTIME and C_AFTERWORKTIME  and C_RATEVALUE>0";
//			List<Zrate> listzrate = Server
//					.getInstance()
//					.getAirService()
//					.findAllZrate(sql,
//							" ORDER BY " + Zrate.COL_ratevalue + " DESC", -1, 0);
//			ActionContext.getContext().getSession().put(
//					this.getLoginUserId() + "zrateone", listzrate);
//		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		StringBuffer str = new StringBuffer();
		str.append("ok");
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
	
	public void findallzrateBY() {
		Date dateNow=new Date(System.currentTimeMillis());
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
		if (isBackOrTo == 1) {
		
			String sql = "where C_DEPARTUREPORT like '%"
				+ z_endcity
				+ "%'"
				+ " and C_ARRIVALPORT like '%"
				+ z_startcity
			+ "%'"
				+ " AND C_ISENABLE =1"
				+ " and '"+z_date+"' between C_BEGINDATE and C_ENDDATE  AND '"+mDateTime+"' between C_WORKTIME and C_AFTERWORKTIME  and C_RATEVALUE>0";
			System.out.println(sql);
			List<Zrate> listzrate = Server
					.getInstance()
					.getAirService()
					.findAllZrate(sql,
							" ORDER BY " + Zrate.COL_ratevalue + " DESC", -1, 0);

			
			
			
		}else{
			
		
		String sql = "where C_DEPARTUREPORT like '%"
			+ z_startcity
			+ "%'"
			+ " and C_ARRIVALPORT like '%"
			+ z_endcity
			+ "%'"
			+ " AND C_ISENABLE =1"
			+ " AND C_GENERAL =1"
			+ " and '"+z_date+"' between C_BEGINDATE and C_ENDDATE  AND '"+mDateTime+"' between C_WORKTIME and C_AFTERWORKTIME  and C_RATEVALUE>0";
		List<Zrate> listzrate = Server
				.getInstance()
				.getAirService()
				.findAllZrate(sql,
						" ORDER BY " + Zrate.COL_ratevalue + " DESC", -1, 0);
		
			
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		StringBuffer str = new StringBuffer();
		str.append("ok");
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
	
	public void findcabinlowBY() {//listOrderPrice
		
		if(s_aircompanycode.indexOf("9C")!=-1){
			System.out.println("春秋航班");
		}
		
		
		//System.out.println("111");
			long lagentid=getLoginUser().getAgentid();
			int isGD=1;//1不是固定  2是固定
		    StringBuffer str = new StringBuffer();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			List<Agentvalue> list= new ArrayList<Agentvalue>();
			
			//String where=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+lagentid+"'";
			//list=Server.getInstance().getMemberService().findAllAgentvalue(where, " order by id desc ", -1, 0);
		
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
				isGD=2;
			}
			//getLoginAgent().getFixedvalue()
			Float fratevalue=0f;
		    String isgaofan="1";
			if(isGD==1){ 
				//政策值
				
				Calendar cal=Calendar.getInstance(); 
			    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
			    String mDateTime=formatter.format(cal.getTime());
			    String strSP="[dbo].[sp_GetZrateByFlight] "+
				"@chufajichang = N'"+s_fromcity+"',@daodajichang = N'"+s_tocity+"',"+
				"@chufariqi = N'"+s_fromdate+"',@dangqianshijian= N'"+mDateTime+"',"+
				"@hangkonggongsi= N'"+s_aircompanycode+"',"+
				"@cangwei= N'"+s_cabincode+"',@hangbanhao= N'"+s_flightnumber+"',@ismulity=0,@isgaofan=1,@agentid=0";
			    System.out.println(strSP);
			   
			    
			    
			    List<Zrate> listzrate=new ArrayList<Zrate>();
			    
			  /* List<Zrate>listzrateJR=GetJinriListZrate(s_fromcity, s_tocity, s_aircompanycode, s_cabincode, s_fromdate, 6, s_flightnumber, 0,1);//航程匹配
			   List<Zrate> listzrate8000=ZrateServer.getInstance().searchZrate(s_fromcity, s_tocity, s_aircompanycode, s_cabincode, s_fromdate, 3, s_flightnumber, 0);
			   List<Zrate> listzratePM=ZrateServer.getInstance().searchZrate(s_fromcity, s_tocity, s_aircompanycode, s_cabincode, s_fromdate, 2, s_flightnumber, 0);
			   
			
			   for(int a=0;a<listzrateJR.size();a++){
				   listzrate.add(listzrateJR.get(a));
			   }
			   for(int a=0;a<listzrate8000.size();a++){
				   listzrate.add(listzrate8000.get(a));
			   }
			   for(int a=0;a<listzratePM.size();a++){
				   listzrate.add(listzratePM.get(a));
			   }*/
			    
			    
			    
			    
			    
			    listzrate=GetJinriListZrate(s_fromcity, s_tocity, s_aircompanycode, s_cabincode, s_fromdate, 6, s_flightnumber, 0,1);//航程匹配
			   // listzrate=ZrateServer.getInstance().searchZrate(s_fromcity, s_tocity, s_aircompanycode, s_cabincode, s_fromdate, 0, s_flightnumber, 0);//本地匹配RED
			 
			  // System.out.println("size:"+listzrate.size());
			   //System.out.println("333");
			    //0 所有    1普通  2高反
			   // Zrate zratemodel=new Zrate();
			    
			    
			    List listzrat_bendi=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);//本地数据库
			    if(listzrat_bendi.size()>0)
				{
			    	Map listzratemap = (Map) listzrat_bendi.get(0);
			    	Zrate zrate=new Zrate();
			    	zrate=Server.getInstance().getAirService().findZrateByDB(Long.parseLong(listzratemap.get("zrateid").toString()));
			    	listzrate.add(zrate);
				}
			     
			    System.out.println("size:"+listzrate.size());
			    
			    java.util.Collections.sort(listzrate);
			    if(listzrate.size()>0)
				{
			    	 
					//zratemodel=listzrate.get(0);
					fratevalue=listzrate.get(0).getRatevalue();
					isgaofan=listzrate.get(0).getGeneral()+"";
				}
				//List listzrate = Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
				//获取最高的政策信息
				/*if(listzrate.size()>0)
				{
					Map listzratemap = (Map) listzrate.get(0);
					fratevalue=Float.parseFloat(listzratemap.get("zratevalue").toString());
					
					zratemodel=Server.getInstance().getAirService().findZrate(Long.parseLong(listzratemap.get("zrateid").toString()));
					isgaofan=zratemodel.getGeneral()+"";
				}
				else
				{
					zratemodel=Server.getInstance().getAirService().findZrate(1l);
					if(zratemodel!=null)
					{
					fratevalue=zratemodel.getRatevalue();
					isgaofan=zratemodel.getGeneral()+"";
					}
				}*/
			    
			    
			}
		//如果是固定返点.从新赋值
		if(isGD==2){
			fratevalue=Float.parseFloat(getLoginAgent().getFixedvalue());
			isgaofan="1";
		}
		
		//取得返佣值
	  
		 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
		 String strRabateString="0";
		 //返佣金额
		 Float freturnmoney=0f;
		 freturnmoney=(Float.parseFloat(z_price)* dceimalFormat(Getliudianvalue(fratevalue)) / 100);
		 try{//更具留点设置计算返佣
			 strRabateString=getAgentRebatevalue(lagentid,freturnmoney,1,getLoginUserAgent().getAgentjibie());
		 }
		 catch(Exception ex)
		 {
			 strRabateString="0";
		 }
		
		 //计算当前登录代理商的返佣金额
		 Float frabatemoney=0f;
		 String strrabatemoney="0";
		 if(!strRabateString.equals("0"))
		 {
		    frabatemoney=Float.parseFloat(strRabateString);
		    strrabatemoney=formatMoney_B2BBack(frabatemoney.toString());
		 }
		 else
		 {
			 try
			 {
			   frabatemoney=(Float .parseFloat(z_price)* Getliudianvalue(fratevalue) / 100);
			 }
			 catch(Exception ex)
			 {
				 frabatemoney=0f;
			 }
		 }
		
		//对利润值进行进到个位，保留整数
		int intfmoney=frabatemoney.intValue();
		frabatemoney=Float.parseFloat(intfmoney+"");

		
		String strGaofan="";
		if(isgaofan.equals("2"))
		{
			strGaofan="<span style='display:none'><font><b>★特殊高</b></font></span>";
		}

		if (fratevalue != null&&fratevalue>0) {
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid());
		
			String s_type = (String) ServletActionContext.getContext().getSession().get("s_type").toString();
		
			
				
				
				str.append(""+formatZrate(Getliudianvalue(fratevalue))+ "%"+strGaofan);
				str.append("|"
						+ ((Float)(Float.parseFloat(z_price) - frabatemoney)));
			    str.append("|￥"+String.valueOf(intfmoney+".00"));
				
			
			
			
		    
		    
		} else {
			str.append("<font>动态</font>");
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
		  
		
	
	
	public void findcabinlowBYGaoFan() {//listOrderPrice高反的
		 long lagentid=getLoginUser().getAgentid();
		 
		//政策值
		Float fratevalue=0f;
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
	    String strSP="[dbo].[sp_GetZrateByFlight] "+
		"@chufajichang = N'"+s_fromcity+"',@daodajichang = N'"+s_tocity+"',"+
		"@chufariqi = N'"+s_fromdate+"',@dangqianshijian= N'"+mDateTime+"',"+
		"@hangkonggongsi= N'"+s_aircompanycode+"',"+
		"@cangwei= N'"+s_cabincode+"',@hangbanhao= N'"+s_flightnumber+"',@ismulity=0,@isgaofan=2,@agentid=0";
	    System.out.println(strSP);
	   // List listzrate=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
	    
		//List listzrate = Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
	    
	    
	    List<Zrate> listzrate=ZrateServer.getInstance().searchZrate(s_fromcity, s_tocity, s_aircompanycode, s_cabincode, s_fromdate, 0, s_flightnumber, 0);
		   System.out.println("size:"+listzrate.size());
	    
	    
		//获取最高的政策信息
		if(listzrate.size()>0)
		{
			
			fratevalue=listzrate.get(0).getRatevalue();
		}
		//取得返佣值
	
		 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
		 String strRabateString="0";
		 try{//更具留点设置计算返佣
			 strRabateString=getAgentRebatevalue(lagentid,(Float)((Float.parseFloat(z_price)* Getliudianvalue(fratevalue) / 100)),1,getLoginUserAgent().getAgentjibie());
		 }
		 catch(Exception ex)
		 {
			 
			 strRabateString="0";
		 }
		
		 //计算当前登录代理商的返佣金额
		 Float frabatemoney=0f;
		 String strrabatemoney="0";
		 if(!strRabateString.equals("0"))
		 {
		    frabatemoney=Float.parseFloat(strRabateString);
		    strrabatemoney=formatMoney_B2BBack(frabatemoney.toString());
		 }
		 else
		 {
			 try
			 {
			   frabatemoney=(Float .parseFloat(z_price)* Getliudianvalue(fratevalue) / 100);
			 }
			 catch(Exception ex)
			 {
				 frabatemoney=0f;
			 }
		 }
		
		//对利润值进行进到个位，保留整数
		int intfmoney=frabatemoney.intValue();
		frabatemoney=Float.parseFloat(intfmoney+"");

		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		
		if (fratevalue != null&&fratevalue>0) {
			str.append(""+formatZrate(Getliudianvalue(fratevalue))+ "%");
			str.append("|"
					+ ((Float)(Float.parseFloat(z_price) - frabatemoney)));
		    str.append("|￥"+String.valueOf(intfmoney+".00"));
		} else {
			str.append("<font >动态</font>");
		}
		//color='red'
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
	

	public void findcabinlow() {
//		List<Zrate> listzrate;
//		if (isBackOrTo == 1) {
//			listzrate = (List<Zrate>) ActionContext.getContext().getSession()
//					.get(this.getLoginUserId() + "zratetwo");
//		} else {
//			listzrate = (List<Zrate>) ActionContext.getContext().getSession()
//					.get(this.getLoginUserId() + "zrateone");
//		}
//		Zrate zratetemp = null;
//		for (Zrate zrate : listzrate) {
//
//			if (zrate.getIsenable()==1 && z_airline.substring(0, 2).trim().equals(zrate.getAircompanycode())) {
//				
//				//if (	(zrate.getType()== null || zrate.getType() == 0  ) 
//						//|| (zrate.getType() == 1 && zrate.getFlightnumber() != null && zrate.getFlightnumber().indexOf(z_airline.substring(2)) > 0))
//						//|| (zrate.getType() == 1 && zrate.getFlightnumber() != null && zrate.getFlightnumber().indexOf(	z_airline.substring(2)) < 0)) 
//			if(zrate.getFlightisuse()!=null)
//				{
//				    if(zrate.getFlightisuse()==1 && zrate.getFlightnumber() != null && zrate.getFlightnumber().indexOf(z_airline.substring(2)) > 0 )
//				    {
//						if (zrate.getCabincode().indexOf(z_aircode) >= 0) {
//							if (zratetemp == null|| zratetemp.getRatevalue() < zrate.getRatevalue()) {
//								zratetemp = zrate;
//							}
//						}
//				    }
//				    else
//				    {
//				    	if (zrate.getCabincode().indexOf(z_aircode) >= 0) {
//							if (zratetemp == null|| zratetemp.getRatevalue() < zrate.getRatevalue()) {
//								zratetemp = zrate;
//							}
//						}
//				    }
//				}
//			}
//		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
//		//取得返佣值
//		 long lagentid=getLoginUser().getAgentid();
//		 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
		 String strRabateString="0";
//		 try
//		 {
//			 strRabateString=getAgentRebatevalue(lagentid,(Float)((Float.parseFloat(z_price)* Getliudianvalue(zratetemp.getRatevalue()) / 100)),1,getLoginUserAgent().getAgentjibie());
//		 }
//		 catch(Exception ex)
//		 {
//			 strRabateString="0";
//		 }
//		
		 //计算当前登录代理商的返佣金额
		 Float frabatemoney=0f;
		 String strrabatemoney="0";
//		 if(!strRabateString.equals("0"))
//		 {
		    frabatemoney=Float.parseFloat(strRabateString);
		    strrabatemoney=formatMoney_B2BBack(frabatemoney.toString());
//		 }
//		 else
//		 {
//			 try
//			 {
//			   frabatemoney=(Float .parseFloat(z_price)* Getliudianvalue(zratetemp.getRatevalue()) / 100);
//			 }
//			 catch(Exception ex)
//			 {
//				 frabatemoney=0f;
//			 }
//		 }
		    
		//对利润值进行进到个位，保留整数
		  int intfmoney=frabatemoney.intValue();
		  frabatemoney=Float.parseFloat(intfmoney+"");
		//取的返佣值结束
		StringBuffer str = new StringBuffer();
//		if (zratetemp != null) {
//			if (zratetemp.getIstype()==null || zratetemp.getIstype()==0) {
//				str.append("");
//			} else {
//				str.append("");
//			}
//			str.append("返点:"+formatZrate(Getliudianvalue(zratetemp.getRatevalue()))+ "%");
//			//str.append("(" + zratetemp.getAgentid() + ")");
//			str.append("|"
//					+ (formatMoney((Float)(Float.parseFloat(z_price) - frabatemoney))));
//		    str.append("|￥"+String.valueOf(intfmoney+".00"));
//		} else {
//			str.append(-1);
//		}
		str.append(-1);
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
	
	/**
	 * 根据航班号，只取得航班号的具体数字，而不要航空公司代码
	 * @param strAriLine  CA4533
	 * @return  4533
	 */
	public String getAirLineNumber(String strAriLine)
	{
		String strReturn="";
		strReturn=strAriLine.substring(2, strAriLine.length());
		return strReturn;
	}
	
	/**
	 * 显示下订单页面或者PNR导入页面的匹配政策表格
	 * @throws Exception
	 */
	public void DisplayZrateList() throws Exception
	{
		
		
		int isGD=1;//1不是固定  2是固定
		/*long lagentid=getLoginUser().getAgentid();
		
		List<Agentvalue> list= new ArrayList<Agentvalue>();
		
		String where=" where 1=1 and "+Agentvalue.COL_angentid+" ='"+lagentid+"'";
		list=Server.getInstance().getMemberService().findAllAgentvalue(where, " order by id desc ", -1, 0);
	*/
		if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点  或者积分的
			isGD=2;
		}
		//getLoginAgent().getBigtype()==2
		
		
		//取得政策数据
		List<Zrate> listzrate = Getallzrate(z_startcity, z_endcity, z_fromdate,intflag, strAirCompany, strAirline, strCabin);
		StringBuilder sb=new StringBuilder();
		//显示政策列表
		if(listzrate.size()>0)
		{
			String strBgcolor="background:#ffffcc;";
			if(intflag==1)
			{
				strBgcolor="background:#DDECF3;";
			}
			else if(intflag==2)
			{
				strBgcolor="background:#ffffcc;";
			}
			sb.append("<table border='0' cellpadding='0' cellspacing='0' width='100%' id='tb_zrateinfo_one'>");
			sb.append("<tr>");
			if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
			sb.append("<input type='hidden' value='1' id='zratelength'><td style='width: 15%; "+strBgcolor+"'>适用政策条数</td>");
			}else{
			sb.append("<input type='hidden' value='"+listzrate.size()+"' id='zratelength'><td style='width: 15%; "+strBgcolor+"'>适用政策条数</td>");
			}
			sb.append("<td style='width: 15%;  "+strBgcolor+" display: none'>普通返点</td>");
			
			if(getLoginAgent().getType()==2){//积分加盟商
				
			sb.append("<td style='width: 15%;  "+strBgcolor+"'>积分</td>");
			}else{
			sb.append("<td style='width: 15%;  "+strBgcolor+"'>优惠/返点</td>");
			}
			
			
			
			sb.append("<td style='width: 15%;  "+strBgcolor+"'>票面结算价</td>");
			sb.append("<td style='width: 10%;  "+strBgcolor+"'>出票时间</td>");
			sb.append("<td style='width: 10%;  "+strBgcolor+"'>废票时间</td>");
			sb.append("<td style='width: 10%;  "+strBgcolor+"'>出票速度(类型)</td>");
			sb.append("<td style='width: 10%;  "+strBgcolor+"'>选择</td>");
			sb.append("</tr>");
			
			
			int listzratesize=listzrate.size();
			if(isGD==2||getLoginUserAgent().getType()==2){
				listzratesize=1;
			}
			
			//循环政策数据
			for(int i=0;i<listzratesize;i++)
			{
				Zrate zrate=listzrate.get(i);
				
				if(isGD==2){
					zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
				}
				
				int index=i;
				int policyindex=i+1;
				String strStyle="";
				String strCheck="";
				String strPolicyDesc="";
				if(i>3)
				{
					strStyle="style='display:none'";
				}
				if(i==0)
				{
					strCheck="checked='checked'";
				}
				else
				{
					strPolicyDesc="style='display:none'";
				}
				if(z_segmentindex==1)
				{
				  sb.append("<tr id='onezrate_"+policyindex+"' "+strStyle+" >");
				}
				else if(z_segmentindex==2)
				{
			      sb.append("<tr id='twozrate_"+policyindex+"' "+strStyle+" >");
				}
				sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>政策"+policyindex+getZrateAgentName(zrate.getAgentid())+"</td>");
				
				if(z_segmentindex==1)
				{
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999; display: none'><span id='test_zate_1_"+policyindex+"_value'>"+formatZrate(Getliudianvalue(zrate.getRatevalue()))+"</span></td>");
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999'><span id='zate_1_"+policyindex+"_youhui'>"+formatMoney_int(gethuiyouprice(Getliudianvalue(zrate.getRatevalue())/100,1f,z_parvalue)+"")+"</span>");
					if(getLoginAgent().getType()!=2){//不是积分加盟商
					sb.append("(<font color='red'>返点：<span id='zate_1_"+policyindex+"_value'>"+formatZrate(Getliudianvalue(zrate.getRatevalue()))+"</span>%</font>)");
					}
					if(zrate.getGeneral().equals("2"))
					{
						sb.append("<br /><font color='red'><b>★特殊高</b></font>");
					}
					sb.append("</td>");
					if(getLoginAgent().getType()==2){//积分加盟商
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999' class='huang14_c'>￥<span id='zate_1_"+policyindex+"_price'>"+formatMoney_short(z_parvalue+"")+"</span></td>");
					}else{
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999' class='huang14_c'>￥<span id='zate_1_"+policyindex+"_price'>"+formatMoney_short(z_parvalue-gethuiyouprice(Getliudianvalue(zrate.getRatevalue())/100,1f,z_parvalue)+"")+"</span></td>");
					}
					//<!-- 隐藏域,政策值 ,默认是加载值,点击后AJAX取值后更改赋值-->
					sb.append("<input type='hidden' id='ratevalue1_1_"+zrate.getId()+"' value='"+formatZrate(Getliudianvalue(zrate.getRatevalue()))+"' />");
				}
				else if(z_segmentindex==2)
				{
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999; display: none'><span id='test_zate_2_"+policyindex+"_value'>"+formatZrate(Getliudianvalue(zrate.getRatevalue()))+"</span></td>");
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999'><span id='zate_2_"+policyindex+"_youhui'>"+formatMoney_int(gethuiyouprice(Getliudianvalue(zrate.getRatevalue())/100,1f,z_parvalue)+"")+"</span>");
					if(getLoginAgent().getType()!=2){//不是积分加盟商
					sb.append("(<font color='red'>返点：<span id='zate_2_"+policyindex+"_value'>"+formatZrate(Getliudianvalue(zrate.getRatevalue()))+"</span>%</font>)");
					}
					if(zrate.getGeneral().equals("2"))
					{
						sb.append("<br /><font color='red'><b>★特殊高</b></font>");
					}
					sb.append("</td>");
					if(getLoginAgent().getType()==2){//积分加盟商
						sb.append("<td style='width: 15%; border-top: 1px dashed #999999' class='huang14_c'>￥<span id='zate_2_"+policyindex+"_price'>"+formatMoney_short(z_parvalue+"")+"</span></td>");
							
					}else{
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999' class='huang14_c'>￥<span id='zate_2_"+policyindex+"_price'>"+formatMoney_short(z_parvalue-gethuiyouprice(Getliudianvalue(zrate.getRatevalue())/100,1f,z_parvalue)+"")+"</span></td>");
					}
					//<!-- 隐藏域,政策值 ,默认是加载值,点击后AJAX取值后更改赋值-->
					sb.append("<input type='hidden' id='ratevalue2_2_"+zrate.getId()+"' value='"+formatZrate(Getliudianvalue(zrate.getRatevalue()))+"' />");
				}
                 String strWorkTime=zrate.getWorktime();
                 String strWorkafterTime=zrate.getAfterworktime();
                 if(strWorkTime==null || strWorkTime.equals(""))
                 {
                	 strWorkTime="08:00";
                 }
                 if(strWorkafterTime==null || strWorkafterTime.equals(""))
                 {
                	 strWorkTime="20:00";
                 }
				sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>"+zrate.getWorktime()+"-"+zrate.getAfterworktime()+"</td>");
				sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>"+zrate.getAfterworktime()+"</td>");
				
				
				String type="B2B";
				if(zrate.getTickettype()!=null&&zrate.getTickettype()==2){
					type="B2B";
				}else{
					type="BSP";
				}
				if(zrate.getSpeed()!=null && !zrate.getSpeed().equals(""))
				{
					
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>"+zrate.getSpeed()+"分钟("+type+")</td>");
				}
				else
				{
					sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>暂无数据("+type+")</td>");
					
				}
				
				if(z_segmentindex==1)
				{
					sb.append("<td style='width: 10%; border-top: 1px dashed #999999'><input type='radio' "+strCheck+" id='rdo_zrate1_"+index+"' name='zrate_one' onclick=\"showzratedesc1_1('"+index+"');updatezate('zate_1_"+policyindex+"_','"+zrate.getId()+"','"+z_startcity+"','"+z_endcity+"','"+strAirline+"','"+zrate.getOutid()+"','"+zrate.getAgentid()+"','"+z_parvalue+"',1);jisuanjiage();\" value='"+zrate.getId()+"' />&nbsp;</td>");
					sb.append("</tr>");
					sb.append("<tr id='zrate1_1_"+index+"' "+strPolicyDesc+">");
				}
				else if(z_segmentindex==2)
				{
					sb.append("<td style='width: 10%; border-top: 1px dashed #999999'><input type='radio' "+strCheck+" id='rdo_zrate2_"+index+"' name='zrate_two' onclick=\"showzratedesc3_2('"+index+"');updatezate('zate_2_"+policyindex+"_','"+zrate.getId()+"','"+z_startcity+"','"+z_endcity+"','"+strAirline+"','"+zrate.getOutid()+"','"+zrate.getAgentid()+"','"+z_parvalue+"',2);jisuanjiage();\" value='"+zrate.getId()+"' />&nbsp;</td>");
					sb.append("</tr>");
					sb.append("<tr id='zrate2_2_"+index+"' "+strPolicyDesc+">");
				}
				sb.append("<td colspan='7' style='width: 100%; border-top: 1px dashed #999999; color: red; font-weight: bold;align:left'>");
				if(zrate.getRemark()!=null && !zrate.getRemark().equals(""))
				{
					sb.append("<span style='float:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+zrate.getRemark()+"</span>");
				}
				else
				{
					sb.append("<span style='float:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;暂无政策备注信息</span>");
				}
				sb.append("</td>");
                sb.append("</tr>");
			}
			
			sb.append("<tr>");
			sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>&nbsp;</td>");
			sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>&nbsp;</td>");
			sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>&nbsp;</td>");
			sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>&nbsp;</td>");
			sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>&nbsp;</td>");
			sb.append("<td style='width: 15%; border-top: 1px dashed #999999'>&nbsp;</td>");
			if(z_segmentindex==1)
			{
				sb.append("<td style='width: 10%; border-top: 1px dashed #999999'><span id='onezrate_show'><a href=\"javascript:showtable('"+listzrate.size()+"','onezrate_')\">+更多</a></span>");
				sb.append("<span id='onezrate_close' style='display: none;'><a href=\"javascript:closetable('"+listzrate.size()+"','onezrate_')\">-缩起</a></span>");
			}
			else if(z_segmentindex==1)
			{
				sb.append("<td style='width: 10%; border-top: 1px dashed #999999'><span id='onezrate_show'><a href=\"javascript:showtable('"+listzrate.size()+"','twozrate_')\">+更多</a></span>");
				sb.append("<span id='onezrate_close' style='display: none;'><a href=\"javascript:closetable('"+listzrate.size()+"','twozrate_')\">-缩起</a></span>");
			}
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
		else
		{
			sb.append("<font color='red' size='5px'>暂无政策数据</font>");
		}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			StringBuilder sbhtml=new StringBuilder();
			PrintWriter out = response.getWriter();
			sbhtml.append(sb.toString());
			
			//System.out.println(sb.toString());
			out.print(sb);
			out.flush();
			out.close();
	}
	
	
	/**
	 * 获取特价时，将特价价格更改到航程信息中
	 * @throws Exception
	 */
	public void AjaxChangeSPPriceSession()throws Exception
	{
		String[] strIndexArr=s_HfFligIndex.split("_");
		int intflag=1;
		if(ActionContext.getContext().getSession().get("travelFlag")!=null)
		{
			intflag=Integer.parseInt(ActionContext.getContext().getSession().get("travelFlag").toString());
		}
		if(intflag==2)
		{
			
			List<FlightInfo> listFlightInfoTwo = (List<FlightInfo>) ActionContext.getContext().getSession().get("FlightListTwo");
			listFlightInfoTwo.get(Integer.parseInt(strIndexArr[0])).getCarbins().get(Integer.parseInt(strIndexArr[1])).setDiscount(Float.parseFloat(formatZrate(s_spdiscount*10)));
			listFlightInfoTwo.get(Integer.parseInt(strIndexArr[0])).getCarbins().get(Integer.parseInt(strIndexArr[1])).setPrice(s_spcabinprice);
			ActionContext.getContext().getSession().put("FlightListTwo",listFlightInfoTwo); // 往返或联程
		}
		else
		{
			List<FlightInfo> listFlightInfoOne = (List<FlightInfo>) ActionContext.getContext().getSession().get("FlightListOne");
			listFlightInfoOne.get(Integer.parseInt(strIndexArr[0])).getCarbins().get(Integer.parseInt(strIndexArr[1])).setDiscount(Float.parseFloat(formatZrate(s_spdiscount*10)));
			listFlightInfoOne.get(Integer.parseInt(strIndexArr[0])).getCarbins().get(Integer.parseInt(strIndexArr[1])).setPrice(s_spcabinprice);
			ActionContext.getContext().getSession().put("FlightListOne",listFlightInfoOne); // 去
		}
		
		
		StringBuilder sb=new StringBuilder();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		StringBuilder sbhtml=new StringBuilder();
		PrintWriter out = response.getWriter();
		sbhtml.append(sb.toString());
		out.print(sb);
		out.flush();
		out.close();
	}
	

	/**
	 */
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}

	public void setListAircompany(List<Aircompany> listAircompany) {
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

	public String toimportpnr() throws Exception {
		return "importpnr";
	}

	public Integer getIsBackOrTo() {
		return isBackOrTo;
	}

	public void setIsBackOrTo(Integer isBackOrTo) {
		this.isBackOrTo = isBackOrTo;
	}

	public Integer getIssession() {
		return issession;
	}

	public void setIssession(Integer issession) {
		this.issession = issession;
	}

	public List<Infocontent> getListSysmenssage2() {
		return listSysmenssage2;
	}

	public void setListSysmenssage2(List<Infocontent> listSysmenssage2) {
		this.listSysmenssage2 = listSysmenssage2;
	}

	public String getHistorysum() {
		return historysum;
	}

	public void setHistorysum(String historysum) {
		this.historysum = historysum;
	}

	public String getZ_airline() {
		return z_airline;
	}

	public void setZ_airline(String z_airline) {
		this.z_airline = z_airline;
	}

	public String getZ_aircode() {
		return z_aircode;
	}

	public void setZ_aircode(String z_aircode) {
		this.z_aircode = z_aircode;
	}

	public LinkedList<Zrate> getListdzrate() {
		return listdzrate;
	}

	public void setListdzrate(LinkedList<Zrate> listdzrate) {
		this.listdzrate = listdzrate;
	}

	public LinkedList<Zrate> getListgzrate() {
		return listgzrate;
	}

	public void setListgzrate(LinkedList<Zrate> listgzrate) {
		this.listgzrate = listgzrate;
	}

	public String getZ_price() {
		return z_price;
	}

	public void setZ_price(String z_price) {
		this.z_price = z_price;
	}

	public LinkedList<Zrate> getListdzratetwo() {
		return listdzratetwo;
	}

	public void setListdzratetwo(LinkedList<Zrate> listdzratetwo) {
		this.listdzratetwo = listdzratetwo;
	}

	public LinkedList<Zrate> getListgzratetwo() {
		return listgzratetwo;
	}

	public void setListgzratetwo(LinkedList<Zrate> listgzratetwo) {
		this.listgzratetwo = listgzratetwo;
	}

	public String getS_rebatepoint() {
		return s_rebatepoint;
	}

	public void setS_rebatepoint(String s_rebatepoint) {
		this.s_rebatepoint = s_rebatepoint;
	}

	public String getStartAirportCode_lc() {
		return StartAirportCode_lc;
	}

	public void setStartAirportCode_lc(String startAirportCode_lc) {
		StartAirportCode_lc = startAirportCode_lc;
	}

	public String getEndAirportCode_lc() {
		return EndAirportCode_lc;
	}

	public void setEndAirportCode_lc(String endAirportCode_lc) {
		EndAirportCode_lc = endAirportCode_lc;
	}

	public String getFromDate_lc() {
		return FromDate_lc;
	}

	public void setFromDate_lc(String fromDate_lc) {
		FromDate_lc = fromDate_lc;
	}

	public FlightSearch getFlightSearch_lc() {
		return flightSearch_lc;
	}

	public void setFlightSearch_lc(FlightSearch flightSearch_lc) {
		this.flightSearch_lc = flightSearch_lc;
	}

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


	public String getS_fromcity() {
		return s_fromcity;
	}

	public void setS_fromcity(String s_fromcity) {
		this.s_fromcity = s_fromcity;
	}

	public String getS_tocity() {
		return s_tocity;
	}

	public void setS_tocity(String s_tocity) {
		this.s_tocity = s_tocity;
	}

	public String getS_fromdate() {
		return s_fromdate;
	}

	public void setS_fromdate(String s_fromdate) {
		this.s_fromdate = s_fromdate;
	}

	public String getS_aircompanycode() {
		return s_aircompanycode;
	}

	public void setS_aircompanycode(String s_aircompanycode) {
		this.s_aircompanycode = s_aircompanycode;
	}

	public String getS_flightnumber() {
		return s_flightnumber;
	}

	public void setS_flightnumber(String s_flightnumber) {
		this.s_flightnumber = s_flightnumber;
	}

	public String getS_cabincode() {
		return s_cabincode;
	}

	public void setS_cabincode(String s_cabincode) {
		this.s_cabincode = s_cabincode;
	}

	public String getFlightnub() {
		return flightnub;
	}

	public void setFlightnub(String flightnub) {
		this.flightnub = flightnub;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCabincode() {
		return cabincode;
	}

	public void setCabincode(String cabincode) {
		this.cabincode = cabincode;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getHtjprice() {
		return htjprice;
	}

	public void setHtjprice(String htjprice) {
		this.htjprice = htjprice;
	}

	public float getOrderPlat() {
		return orderPlat;
	}

	public static Map<Integer, String> getOrderItemMap() {
		return orderItemMap;
	}

	public int getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(int orderKey) {
		this.orderKey = orderKey;
	}

	public String getZ_fromdate() {
		return z_fromdate;
	}

	public void setZ_fromdate(String z_fromdate) {
		this.z_fromdate = z_fromdate;
	}

	public int getIntflag() {
		return intflag;
	}

	public void setIntflag(int intflag) {
		this.intflag = intflag;
	}

	public String getStrAirCompany() {
		return strAirCompany;
	}

	public void setStrAirCompany(String strAirCompany) {
		this.strAirCompany = strAirCompany;
	}

	public String getStrAirline() {
		return strAirline;
	}

	public void setStrAirline(String strAirline) {
		this.strAirline = strAirline;
	}

	public String getStrCabin() {
		return strCabin;
	}

	public void setStrCabin(String strCabin) {
		this.strCabin = strCabin;
	}

	public Float getZ_parvalue() {
		return z_parvalue;
	}

	public void setZ_parvalue(Float z_parvalue) {
		this.z_parvalue = z_parvalue;
	}

	public int getZ_segmentindex() {
		return z_segmentindex;
	}

	public void setZ_segmentindex(int z_segmentindex) {
		this.z_segmentindex = z_segmentindex;
	}

	public float getS_spcabinprice() {
		return s_spcabinprice;
	}

	public void setS_spcabinprice(float s_spcabinprice) {
		this.s_spcabinprice = s_spcabinprice;
	}

	public float getS_spdiscount() {
		return s_spdiscount;
	}

	public void setS_spdiscount(float s_spdiscount) {
		this.s_spdiscount = s_spdiscount;
	}

	public int getIsSPPolicy() {
		return isSPPolicy;
	}

	public void setIsSPPolicy(int isSPPolicy) {
		this.isSPPolicy = isSPPolicy;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_number() {
		return s_number;
	}

	public void setS_number(String s_number) {
		this.s_number = s_number;
	}

	public String getCustomerusername() {
		return customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	public String getStrInfo() {
		return strInfo;
	}

	public void setStrInfo(String strInfo) {
		this.strInfo = strInfo;
	}

	public void setOrderPlat(float orderPlat) {
		this.orderPlat = orderPlat;
	}

	public static void setOrderItemMap(Map<Integer, String> orderItemMap) {
		B2bAirSearchAction.orderItemMap = orderItemMap;
	}

	public String getC_index() {
		return c_index;
	}

	public void setC_index(String c_index) {
		this.c_index = c_index;
	}

	public int getC_type() {
		return c_type;
	}

	public void setC_type(int c_type) {
		this.c_type = c_type;
	}

	public int getS_type() {
		return s_type;
	}

	public void setS_type(int s_type) {
		this.s_type = s_type;
	}

	public List<Sysmessage> getSysmessageList() {
		return sysmessageList;
	}

	public void setSysmessageList(List<Sysmessage> sysmessageList) {
		this.sysmessageList = sysmessageList;
	}

	public int getXcdPlat() {
		return xcdPlat;
	}

	public void setXcdPlat(int xcdPlat) {
		this.xcdPlat = xcdPlat;
	}

	public int getXcdpsPlat() {
		return xcdpsPlat;
	}

	public void setXcdpsPlat(int xcdpsPlat) {
		this.xcdpsPlat = xcdpsPlat;
	}

	public List<Qqtypenew> getListQqtypenew() {
		return listQqtypenew;
	}

	public void setListQqtypenew(List<Qqtypenew> listQqtypenew) {
		this.listQqtypenew = listQqtypenew;
	}
	/**
	 * 获取指定时间的前几小时
	 * @param time		指定时间
	 * @param intDay	指定时间的前几小时
	 * @return
	 */
	public String GetMintue(String time, int intMinute) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date;
		String strReturn = "";
		try {
			date = sdf.parse(time);
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.MINUTE, intMinute);// 分钟相加减
			date = cd.getTime();
			strReturn = sdf.format(date).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strReturn;
	}
	//转化时间格式 HH:MM
	public String formatTimestampPID(Timestamp date){
		try {
			return (new SimpleDateFormat("HHmm").format(date));
			
		} catch (Exception e) {
			return "";
		}
		
	}
//	/**
//	 * @deprecated 内部类
//	 * @author created by vic
//	 *
//	 */
//	private class InnerAirInfo
//	{
//		public InnerAirInfo(String _twoCode,String _cabinCode)
//		{
//			this._twoCode=_twoCode;
//			this._cabinCode=_cabinCode;
//		}
//		
//		private String _twoCode;
//		private String _cabinCode;
//		
//		/**
//		 * @deprecated 获取 航空公司二字码 
//		 * @return
//		 */
//		public String get_twoCode() {
//			return _twoCode;
//		}
//		
//		/**
//		 * @deprecated 获取舱位码
//		 * @return
//		 */
//		public String get_cabinCode() {
//			return _cabinCode;
//		}
//	}

	public CacheBaseData getCachebasedata() {
		return cachebasedata;
	}

	public void setCachebasedata(CacheBaseData cachebasedata) {
		this.cachebasedata = cachebasedata;
	}

	public List<FlightInfo> getListFlightInfoAll_9c() {
		return listFlightInfoAll_9c;
	}

	public void setListFlightInfoAll_9c(List<FlightInfo> listFlightInfoAll_9c) {
		this.listFlightInfoAll_9c = listFlightInfoAll_9c;
	}
	
//	/**
//	 * 内部类，用于排序选择的初始化内容
//	 */
//	private class innerOrder
//	{
//		private String _key;//对应排序方式
//		private String _value;//
//		private String _Title;
//	}
	
	
}
