package com.yf.system.back.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.mango.hotel.Order;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.ModelDriven;
import com.yf.service.ZrateServer;
import com.yf.system.atom.interticket.HttpClient;
import com.yf.system.back.server.Server;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.back.servlet.WriteLog;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.biguser.Biguser;
import com.yf.system.base.city.City;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerintegralrecord.Customerintegralrecord;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.gift.Gift;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelstart.Hotelstart;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.integral.Integral;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.peisong.Peisong;
import com.yf.system.base.province.Province;
import com.yf.system.base.qqinfonew.Qqinfonew;
import com.yf.system.base.rebaterecord.Rebaterecord;
import com.yf.system.base.rebaterule.Rebaterule;
import com.yf.system.base.region.Region;
import com.yf.system.base.scang.Scang;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.service.IMemberService;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.starrecord.Starrecord;
import com.yf.system.base.supteam.Supteam;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triplinetype.Triplinetype;
import com.yf.system.base.txuserinfo.Txuserinfo;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;

/**
 * @author Administrator 基于此为其它Action之父类，非公有方法和字段禁止在此类中声明。
 */
public abstract class B2b2cbackAction extends ActionSupport implements
		ModelDriven {

	// testduoyuyanBean bean= new testduoyuyanBean();
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String SEARCH = "search";
	
	public static final String CHECK = "check";
	public static final String ADDORDER = "addorder";
	protected String url;
	// pro
	

	// 测试多语言
	private String testyuyan;
	private String testcity;
	private String propPath;
	private String lang;

	private Orderinfo orderinfo2 = new Orderinfo();
	private Orderinfo orderinfo1 = new Orderinfo();

	protected PageInfo pageinfo = new PageInfo();

	protected PageInfo pageother = new PageInfo();
	protected PageInfo pagezafei = new PageInfo();

	public PageInfo getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(PageInfo pageinfo) {
		this.pageinfo = pageinfo;
	}

	protected boolean trancode;

	public boolean isTrancode() {
		return trancode;
	}

	public void setTrancode(boolean trancode) {
		this.trancode = trancode;
	}
	
	public String formatTimestampyyyyMMddHHmm(Timestamp date){
		try {
			return (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
			
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	public String GetFeiPiaoTime(String time){
		String rettime="18:00";
		if(time.equals("")||time.trim().length()==0){
			rettime="18:00";
			
		}else{
			if(time.indexOf("-")!=-1){
				
				rettime=time.split("-")[1];
			}else{
				
				rettime=time;
			}
			
			
		}
		String xiaoshi=rettime.split(":")[0];
		String fen=rettime.split(":")[1];
		
		return (Integer.parseInt(xiaoshi)-1)+":"+fen;
	}
	
	
	/**
	 * @param value
	 * @throws ParseException 
	 * @return获取飞行时间
	 */
	public String GetFeiXingTime(String stime,String etime) throws ParseException {
		//System.out.println("GetFeiXingTime:"+stime+"--"+etime);
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date begin=dfs.parse(stime);
		java.util.Date end = dfs.parse(etime);
		long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒

		long day1=between/(24*3600);
		long hour1=between%(24*3600)/3600;
		long minute1=between%3600/60;
		long second1=between%60/60;
		
		//System.out.println(""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
		
		return hour1+"小时"+minute1+"分";
	}
	/**
	 * @param value
	 * @throws ParseException 
	 * @return获取飞行时间
	 */
	public String GetchupiaoTime(String zhifutime,String chuptime) throws ParseException {
		//System.out.println("GetFeiXingTime:"+zhifutime+"--"+chuptime);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar calendar = Calendar.getInstance();
		String dangqiantime = sdf.format(calendar.getTime());
		if(chuptime!=null&&chuptime.length()>0){
			dangqiantime=chuptime;
		}else{
			
			dangqiantime=zhifutime;
		}
		
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date begin=dfs.parse(zhifutime);
		java.util.Date end = dfs.parse(dangqiantime);
		long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒

		long day1=between/(24*3600);
		long hour1=between%(24*3600)/3600;
		long minute1=between%3600/60;
		long second1=between%60/60;
		
		//System.out.println(""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
		
		return minute1+"分";
	}
	/**
	 * 根据航空公司代码取得航空公司名称
	 * @param code
	 * @return
	 */
	public String getAirCompanyNameByCode(String code)
	{
		String AirCompanyName=code;
		//从缓存中得到航空公司信息
		List<Aircompany> listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		for(Aircompany aircompany:listAirCompany)
		{
			if(aircompany.getAircomcode().equals(code))
			{
				AirCompanyName=aircompany.getAircomjname();
			}
		}
		return AirCompanyName;
	}
	

	public List<Zrate> GetJinriListZrate(String s_depcitycode,String s_arrcitycode,String s_aircompanycode,String s_cabincode,String sday, int agentid,String s_flightnumber,int zratetype,int num){
		List<Zrate> listjinrizrate=new ArrayList<Zrate>();
		Segmentinfo segmentinfo=new Segmentinfo();
		
		segmentinfo.setStartairport(s_depcitycode);
		segmentinfo.setEndairport(s_arrcitycode);
		segmentinfo.setAircomapnycode(s_aircompanycode);
		segmentinfo.setCabincode(s_cabincode);
		segmentinfo.setFlightnumber(s_flightnumber);
		segmentinfo.setTraveltype(num);
		if(agentid==6){//今日
			
			Server.getInstance().setInter("http://211.149.173.11:8080/ticket_inter/service/");
			//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
			
			//Server.getInstance().setInter("http://www.cxpw168.com:8080/ticket_inter/service/");
			//ZrateServer.getInstance().setUrl("http://www.cxpw168.com:28080");
			listjinrizrate=Server.getInstance().getRateService().GetJinRiRateList(segmentinfo, sday, zratetype+"");
			Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
		}
		
		if(agentid==3){//8000yi
			
			//Server.getInstance().setInter("http://211.149.173.11:8080/ticket_inter/service/");
			//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
			//Server.getInstance().setInter("http://www.cxpw168.com:8080/ticket_inter/service/");
			//ZrateServer.getInstance().setUrl("http://www.cxpw168.com:28080");
			listjinrizrate=Server.getInstance().getRateService().GetJinRiRateList(segmentinfo, sday, zratetype+"");
			//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
		}
		
		return listjinrizrate;
	}
	
	
	public List<Zrate> GetJinriListZrate2(String s_depcitycode,String s_arrcitycode,String s_aircompanycode,String s_cabincode,String sday, int agentid,String s_flightnumber,int zratetype,int num,String stime){
		System.out.println("日期:"+sday+" "+stime+":00");
		System.out.println(stime+":00");
		List<Zrate> listjinrizrate=new ArrayList<Zrate>();
		Segmentinfo segmentinfo=new Segmentinfo();
		
		segmentinfo.setStartairport(s_depcitycode);
		segmentinfo.setEndairport(s_arrcitycode);
		segmentinfo.setAircomapnycode(s_aircompanycode);
		segmentinfo.setCabincode(s_cabincode);
		segmentinfo.setFlightnumber(s_flightnumber);
		segmentinfo.setTraveltype(num);
		segmentinfo.setDeparttime(dateToTimestamp22(stime+":00"));
		segmentinfo.setAgentid(Long.parseLong(agentid+""));
		if(agentid==6){//今日
			Server.getInstance().setInter("http://www.cxpw168.com:8080/ticket_inter/service/");
			ZrateServer.getInstance().setUrl("http://www.cxpw168.com:28080");
			//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
			listjinrizrate=Server.getInstance().getRateService().GetJinRiRateList(segmentinfo, sday, zratetype+"");
			Server.getInstance().setInter("http://127.0.0.1:8888/ticket_inter/service/");
		}
		if(agentid==3){//8000yi
			//Server.getInstance().setInter("http://www.cxpw168.com:8080/ticket_inter/service/");
			ZrateServer.getInstance().setUrl("http://www.cxpw168.com:28080");
			//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
			listjinrizrate=Server.getInstance().getRateService().GetJinRiRateList(segmentinfo, sday, zratetype+"");
			Server.getInstance().setInter("http://127.0.0.1:8888/ticket_inter/service/");
		}
		
		return listjinrizrate;
	}
	
	
	/**
	 * 将价格格式化成不带有小数的价格
	 * @param money
	 * @return
	 */
	public String formatMoneyToInt( Float money ){
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern( "###0" );
		try{
			String result = format.format( money );
			return result;
		}catch ( Exception e ){
			return Float.toString( money );
		}
	}
	
	/**
	 * 根据机场代码获取城市名称--国内
	 * 
	 * @param airport
	 * @return
	 */
	public String getAirCityNamebySZM(String airport) {
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getCityname(): "";

	}
	public String GetRestrictions(String aircode,String cabin,String stime){
		String Change="";
		String Refund="";
		String Remark="";
		try {
			String url="http://ws.jinri.cn/JinRiFlightServer.asmx/GetRestrictions?xml=";
			
			String sub="<?xml version='1.0' encoding='gb2312'?>";
			sub+="<JinRiRuleRequest>";
			sub+="<Request UserName='yyhkpw01' AirLine='"+aircode+"' Cabin='"+cabin+"' Sdate='"+stime+"' Systemid=''/>";
			sub+="</JinRiRuleRequest>";
			
			String newurl=url+URLEncoder.encode(sub,"GBK");
			System.out.println(newurl);
			String ret = HttpClient.httpget(newurl, "UTF-8");
			//String ret = HttpClient.httpget("http://101.226.196.26:18080/ticket_inter/testjr_tgq.jsp?xml="+URLEncoder.encode(sub,"GBK"), "GB2312");
			System.out.println(ret);
			
			org.dom4j.Document document2 = DocumentHelper.parseText(ret.trim());	
			org.dom4j.Element root2 =  document2.getRootElement();
			
			org.dom4j.Document document = DocumentHelper.parseText(root2.getText());	
			org.dom4j.Element root =  document.getRootElement();
			org.dom4j.Element PolicyResponse =root.element("JinRiRuleResponse");
			if(root.element("Response")!=null){
				org.dom4j.Element Response=root.element("Response");
				org.dom4j.Element Rules=Response.element("Rules");
				
				
				Change=Rules.elementText("Change");
				Refund=Rules.elementText("Refund");
				Remark=Rules.elementText("Remark");
				System.out.println("Change:"+Change);
				System.out.println("Refund:"+Refund);
				System.out.println("Remark:"+Remark);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return Change+Refund+Remark;
	}
	public String GetIpByAdders(){
		
		String RemoteAddrIP="";
		//RemoteAddrIP=ServiceContext.getContextRequest().getRemoteAddr();
		
		if (ServletActionContext.getRequest().getHeader("x-forwarded-for") == null) {  
			RemoteAddrIP= ServletActionContext.getRequest().getRemoteAddr();  
	    }
		//System.out.println();
		return RemoteAddrIP;
	}

	public String formatMoneytoone(Float money) {
		format.applyPattern("###0.0");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			if (money != null) {
				return Float.toString(money);
			} else {
				return "0";
			}
		}
	}
	
	private SimpleDateFormat simplefromatyymmdd = new SimpleDateFormat(
	"yyyy-MM-dd");

	public String formatStringTimetoyyyymmdd(String date) {
		try {
			return this.simplefromatyymmdd.format((simplefromat.parse(date)));
	
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public String getRoomTypeNameByRoomType(String type) {
		if (type.equals("1")) {

			return "SingleRoom";
		}
		if (type.equals("2")) {

			return "DoubleRoom";
		}
		if (type.equals("3")) {

			return "TripleRoom";
		}
		if (type.equals("4")) {

			return "FamilyRoom";
		}
		return "";
	}

	public Float FrmatJinYi(double c){
	 int d = (int) Math.ceil(c);
	 return Float.parseFloat(d+"");
	}
	public Float FrmatJianYi(double c){
		 int d = (int) Math.ceil(c);
		 return Float.parseFloat(d+"");
		}
	public String getima(String url) {
		if (url.indexOf(",") != -1) {

			return url.split(",")[0];
		} else {

			return url;
		}

	}
	private List <Customercredit>  listCustomercredit;
	// 取会证件号
	public String getnumbyid(long id) {
		
		
		
		String where2 = " where 1=1 and "+Customercredit.COL_refid +" = "+id;
		listCustomercredit = Server.getInstance().getMemberService().findAllCustomercredit(where2, " ORDER BY ID ", -1, 0);
		String num="";
		
		if(listCustomercredit.size()>0){
			num=listCustomercredit.get(0).getCreditnumber();
			/*for(int a=0;a<listCustomercredit.size();a++){
				
				if(listCustomercredit.get(a).getCreditnumber()!=null&&listCustomercredit.get(a).getCreditnumber().length()>0){
					
					num=	listCustomercredit.get(a).getCreditnumber();
				}
				
			}*/
			return  num;
			
		}else{
			return  "";
		}
	}
	
	
	//获取当前加盟商的类型type
	
	
	//GetIsChaJia判断是否有差价单
	public Scang GetIsChaJia(long id) {
		Scang scang=new Scang();
		List<Scang>list=Server.getInstance().getAirService().findAllScang(" where 1=1 and "+Scang.COL_orderid+" ="+id, " order by id ", -1, 0);
		if(list.size()>0){
			scang=list.get(0);
		}
		return scang;
	}
	
	// 取会证件号
	public int getnumtypebyid(long id) {
		String where2 = " where 1=1 and "+Customercredit.COL_refid +" = "+id;
		listCustomercredit = Server.getInstance().getMemberService().findAllCustomercredit(where2, " ORDER BY ID ", -1, 0);
		int num=1;
		
		if(listCustomercredit.size()>0){
			num=listCustomercredit.get(0).getCredittypeid();
			/*for(int a=0;a<listCustomercredit.size();a++){
				
				if(listCustomercredit.get(a).getCreditnumber()!=null&&listCustomercredit.get(a).getCreditnumber().length()>0){
					
					num=	listCustomercredit.get(a).getCreditnumber();
				}
				
			}*/
			return  num;
			
		}else{
			return  num;
		}
	}
	public String getTypeToString(Integer id) {
		switch (id) {
		case 1:
			return "身份证";
		case 2:
			return "驾驶证";
		case 3:
			return "护照";
		case 4:
			return "港澳通行证";
		case 5:
			return "台湾通行证";
		case 6:
			return "台胞证";
		case 7:
			return "回乡证";
		case 8:
			return "军官证";
		default:
			return "其他";
		}
	}
	public String getlianxiren(){
		long id = getLoginUser().getAgentid();
		return Server.getInstance().getMemberService().findCustomeragent(id).getAgentcontactname();
	}
	public String getshouji(){
		long id = getLoginUser().getAgentid();
		return Server.getInstance().getMemberService().findCustomeragent(id).getAgentphone();
	}
	public String getPropertiesss(String type, String key, String lan)
			throws Exception {

		// DaoManager daoManager = DaoManagerBuilder.buildDaoManager(reader);

		String language = "1";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("language");
		request.getSession().setAttribute("language", "1");
		if (ActionContext.getContext().getSession().get("language") != null) {
			System.out.println("language is not null ");
			language = (String) ActionContext.getContext().getSession().get(
					"language");
		} else {
			language = "1";
			System.out.println("language is  null ");
		}
		lan = language;
		lang = language;
		String typeXml = "";
		if (lan.equals("1")) {// 中文

			propPath = "C:/testZH.xml";
		}
		if (lan.equals("2")) {// 英文

			propPath = "C:/testEN.xml";
		}
		if (type.equals("1")) {// 酒店
			typeXml = "hotel";
		}
		if (type.equals("2")) {// 机票
			typeXml = "tickt";
		}
		File f = new File(propPath);
		SAXReader reader = new SAXReader();
		org.dom4j.Document doc = reader.read(f);
		org.dom4j.Element root = doc.getRootElement();
		// List<org.dom4j.Element> list = root.elements("hotel");
		List<org.dom4j.Element> list = root.elements(typeXml);
		String sub = "";
		List listmap = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();//
		if (key.indexOf(",") != -1) {
			String[] keys = key.split(",");

			for (int a = 0; a < keys.length; a++) {
				if (keys[a] != null && !keys[a].toString().equals(" ")) {
					sub = list.get(0).elementText(keys[a]);
					map.put(keys[a], sub);
				}
			}
		} else {
			// System.out.println(key+"=="+list.get(0).elementText(key));
			sub = list.get(0).elementText(key);
			map.put(key, sub);
		}
		listmap.add(map);
		System.out.println("sub=" + sub);
		return sub;
	}

	public List getProperties_map(String type, String key, String lan)
			throws Exception {
		// DaoManager daoManager = DaoManagerBuilder.buildDaoManager(reader);

		String language = "1";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("language");
		request.getSession().setAttribute("language", "2");
		if (ActionContext.getContext().getSession().get("language") != null) {
			System.out.println("language is not null ");
			language = (String) ActionContext.getContext().getSession().get(
					"language");
		} else {
			language = "1";
			System.out.println("language is  null ");
		}
		lan = language;
		lang = language;
		String typeXml = "";
		if (lan.equals("1")) {// 中文

			propPath = "C:/testZH.xml";
		}
		if (lan.equals("2")) {// 英文

			propPath = "C:/testEN.xml";
		}
		if (type.equals("1")) {// 酒店
			typeXml = "hotel";
		}
		if (type.equals("2")) {// 机票
			typeXml = "tickt";
		}
		File f = new File(propPath);
		SAXReader reader = new SAXReader();
		org.dom4j.Document doc = reader.read(f);
		org.dom4j.Element root = doc.getRootElement();
		// List<org.dom4j.Element> list = root.elements("hotel");
		List<org.dom4j.Element> list = root.elements(typeXml);
		String sub = "";
		List listmap = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();//
		if (key.indexOf(",") != -1) {
			String[] keys = key.split(",");

			for (int a = 0; a < keys.length; a++) {
				if (keys[a] != null && !keys[a].toString().equals(" ")) {
					sub = list.get(0).elementText(keys[a]);
					map.put(keys[a], sub);
				}
			}
		} else {
			System.out.println(key + "==" + list.get(0).elementText(key));
			sub = list.get(0).elementText(key);
			map.put(key, sub);
		}
		listmap.add(map);
		return listmap;
	}

	public String getintercitynamebyid(long id) {

		return Server.getInstance().getInterHotelService().findIncity(id)
				.getName();
	}

	public String getguojianameBYid(long id) {

		return Server.getInstance().getInterHotelService().findCountry(id)
				.getName();
	}

	// 根据汽车ID查询汽车名字
	public String getcarnameBYid(long id) {

		return Server.getInstance().getCarService().findCars(id).getName();
	}

	public String getroomnamebyid(long id) {

		return Server.getInstance().getHotelService().findRoomtype(id)
				.getName();
	}

	public Double getinterhotelprice(double price) {

		return price + price * 0.03;
	}

	public String getGBKString(String str) {
		if (str != null) {
			try {
				return new String(str.getBytes("ISO8859-1"), "GBK");
			} catch (Exception e) {

			}
		}
		return str;
	}

	/**
	 * @param
	 * @return 返利价格
	 */
	public String getUserPriceByCar(String Jprice) {
		System.out.println("Jprice==" + Jprice);
		Float rvaule = 1F;

		List<Rebaterule> list = Server.getInstance().getMemberService()
				.findAllRebaterule(
						" where 1=1 and " + Rebaterule.COL_ruletypeid
								+ " =4 and " + Rebaterule.COL_agenttypeid
								+ " =5", "", -1, 0);
		if (list.size() > 0) {
			rvaule = list.get(0).getRebatvalue();
		}
		System.out.println("rvaule==" + rvaule);
		System.out.println("价格==" + Float.parseFloat(Jprice) * 0.08 * rvaule
				+ "");
		return Float.parseFloat(Jprice) * 0.08 * rvaule + "";
	}

	/**
	 * 龙泰b2c 积分操作。
	 * 
	 * @param user
	 *            会员
	 * @param type
	 *            业务类型：1：机票。2：酒店，3：旅游，4：租车，5，充值。6：注册，7：积分兑换，8：违约处罚
	 * @param ordenumber
	 *            关联订单号 无则传值 null。
	 * @param gift
	 *            礼品, 若非礼品兑换 则传值null。
	 */
	public int updateIntegral(Customeruser user, int type, String ordenumber,
			Float ordermoney, Gift gift) {
		int score = 0;
		Customerintegralrecord record = new Customerintegralrecord();
		record.setRefuid(user.getId());
		record.setCreatetime(new Timestamp(System.currentTimeMillis()));
		record.setRefordernumber(converNull(ordenumber, "无"));
		if (type != 7) {
			score = this.getScoreByBusiness(user, type, ordermoney);
			record.setScore(score);
			String str = type == 1 ? "机票预订" : type == 2 ? "酒店预订"
					: type == 3 ? "旅游预订" : type == 4 ? "租车预订"
							: type == 5 ? "话费充值" : type == 6 ? "会员注册"
									: type == 8 ? "违约处罚" : "";
			record.setScoresource(str);
			if (type != 8) {
				record.setScorememo(str + "-" + str + "赠送积分" + score);
			} else {
				record.setScorememo(str + "-" + str + "扣减积分" + score);
			}
		} else {
			score = 0 - Integer.valueOf(gift.getUseintegral().toString());
			record.setScore(score);
			record.setScoresource("礼品兑换");
			record.setScorememo("礼品兑换" + "-" + "礼品兑换" + "折减积分"
					+ gift.getUseintegral());

		}
		try {
			Server.getInstance().getMemberService()
					.createCustomerintegralrecord(record);
		} catch (SQLException e) {
			System.out.append("b2c--updateIntegral  积分计算出错。");
			e.printStackTrace();
		}
		if (this.getLoginUser().getId() == user.getId()) {
			Customeruser loginuser = getLoginUser();
			loginuser.setTotalscore(converNull(loginuser.getTotalscore(), 0)
					+ score);
			ServletActionContext.getRequest().getSession().setAttribute(
					"loginuser", loginuser);
		}
		return score;
	}

	public String getcarstoreAddresByID(String carstoreid) {

		return Server.getInstance().getCarService().findCarstore(
				Long.parseLong(carstoreid)).getAddress();
	}

	private int getScoreByBusiness(Customeruser user, int type, Float ordermoney) {
		double score = 0;
		String where = "";
		where = " WHERE C_AGENTTYPE =(SELECT C_AGENTJIBIE FROM T_CUSTOMERAGENT WHERE ID="
				+ user.getAgentid() + ") ";

		List<Integral> integrallist = Server.getInstance().getMemberService()
				.findAllIntegral(where, "", -1, 0);
		if (integrallist.size() > 0) {
			Integral integral = integrallist.get(0);
			if (type == 1) {
				score = ordermoney * integral.getAircoeft()
						* integral.getWeborderscore();
			}
			if (type == 2) {
				score = ordermoney * integral.getHotelcoeft()
						* integral.getWeborderscore();
			}
			if (type == 3) {
				score = ordermoney * integral.getTravelcoeft()
						* integral.getWeborderscore();
			}
			if (type == 4) {
				score = ordermoney * integral.getCarrentalcoeft()
						* integral.getWeborderscore();
			}

			if (type == 5) {
				score = ordermoney * integral.getRechargecoeft()
						* integral.getWeborderscore();
			}
			if (type == 6) {
				score = integral.getRegisterscore();
			}
			if (type == 8) {
				score = 0 - integral.getPunishscore();
			}

		}
		return (int) score;
	}

	public Boolean panduanjiage(Double jia) {
		// Integer ji = Integer.parseInt(jia.substring(1, 2));
		if (jia < 1) {
			return false;
		}

		return true;
	}

	public boolean isLogin() {
		Customeruser platformuser = (Customeruser) ActionContext.getContext()
				.getSession().get("loginuser");
		if (platformuser != null) {
			return true;
		}
		return false;
	}

	public String getcardnumberstr(long id) {
		List<Customercredit> list = Server.getInstance().getMemberService()
				.findAllCustomercredit(
						" where " + Customercredit.COL_refid + " = " + id,
						" order by " + Customercredit.COL_credittypeid, -1, 0);
		if (list != null && list.size() > 0) {
			return list.get(0).getCreditnumber();
		}
		return "无";
	}

	// 根据会员ID 查找加盟商名字
	public String getAngetNameByUserId(long userid) {
		Customeruser cu = Server.getInstance().getMemberService()
				.findCustomeruser(userid);
		// System.out.println("cu="+cu);
		return Server.getInstance().getMemberService().findCustomeragent(
				cu.getAgentid()).getAgentcompanyname();
	}

	public Customercredit getCustomercredit(long customeruserid) {
		List<Customercredit> list = Server.getInstance().getMemberService()
				.findAllCustomercredit(
						" where " + Customercredit.COL_refid + " = "
								+ customeruserid,
						" order by " + Customercredit.COL_credittypeid, -1, 0);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return new Customercredit();
	}

	public boolean checkright(String code) {
		String where = " SELECT COUNT(*) FROM T_Systemright where  " + Systemright.COL_id + " in ( select "
				+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
				+ " where " + Sysroleright.COL_roleid + " in (select "
				+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
				+ " where " + Agentroleref.COL_customeruserid + "="
				+ getLoginUser().getId() + ")) and " + Systemright.COL_type
				+ " =2 and " + Systemright.COL_code + " ='" + code + "'";
		// System.out.println("where=="+where);
      int i= Server.getInstance().getMemberService().countSystemrightBySql(where);
		if (i > 0) {
			return true;
		}
		return false;
	}


	public static Timestamp dateToTimestamp2(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat();
			if (date.length() == 10) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			}
			return (new Timestamp(dateFormat.parse(date).getTime()));

		} catch (Exception e) {
			return null;
		}

	}
	public static Timestamp dateToTimestamp_HHMM(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat();
			if (date.length() == 10) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			}
			return (new Timestamp(dateFormat.parse(date).getTime()));

		} catch (Exception e) {
			return null;
		}

	}
	
	public String formatTimestampMMddHHmm(Timestamp date){
		try {
			return (new SimpleDateFormat("MM-dd HH:mm").format(date));
			
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	public static Timestamp dateToTimestamp22(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat();
			if (date.length() == 10) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
			return (new Timestamp(dateFormat.parse(date).getTime()));

		} catch (Exception e) {
			return null;
		}

	}

	public Double gethotelfantouser(String hotelprice, String star, long hotelid)
			throws Exception {

		System.out.println("价格==" + hotelprice + "--星级==" + star);
		Float rebvaule = 1F;
		Customeruser customeruser = getOrderUserLogin();
		List<Rebaterule> list = Server.getInstance().getMemberService()
				.findAllRebaterule(
						" where 1=1 and " + Rebaterule.COL_ruletypeid
								+ " =2 and " + Rebaterule.COL_agenttypeid
								+ " =5", "", -1, 0);
		if (list.size() > 0) {
			rebvaule = list.get(0).getRebatvalue();
			System.out.println("rebvaule==" + rebvaule);
		}
		Hotel hotel = Server.getInstance().getHotelService().findHotel(hotelid);

		if (hotel.getSourcetype() == 1) {
			if (star.equals("8") || star.equals("9")) {// 5星级得,,返9%
				return Double.valueOf(formatMoney_short(Double
						.parseDouble(hotelprice)
						* 9 / 100 * rebvaule + ""));
			} else {// 其他星级得 返12%
				return Double.valueOf(formatMoney_short(Double
						.parseDouble(hotelprice)
						* 12 / 100 * rebvaule + ""));
			}
		} else {

			return Double.valueOf(formatMoney_short(Double
					.parseDouble(hotelprice)
					* Double.parseDouble(hotel.getRulesback())
					/ 100
					* rebvaule
					+ ""));

		}
	}

	// 传入酒店价格.计算出利润,传入酒店id 得到酒店星级..在根据酒店id得到酒店返点
	public Double gethotelfan(String hotelprice, String star) throws Exception {
		Float rebvaule = 1F;
		Object obj = ActionContext.getContext().getSession()
				.get("fandianvalue");
		Object fanvalue = null;
		fanvalue = obj;
		if (fanvalue == null) {
			Customeruser customeruser = getOrderUserLogin();
			Customeragent customeragent = Server.getInstance()
					.getMemberService().findCustomeragent(
							customeruser.getAgentid());// 当前登录者所属

			if (customeragent.getAgentjibie() == 4) {// 如果是平台,吧利润减去会员的后.其他都都给平台
				List<Rebaterule> list = Server.getInstance().getMemberService()
						.findAllRebaterule(
								" where 1=1 and " + Rebaterule.COL_ruletypeid
										+ " =2 and "
										+ Rebaterule.COL_agenttypeid + " =5",
								"", -1, 0);
				if (list.size() > 0) {
					rebvaule = list.get(0).getRebatvalue();
					ActionContext.getContext().getSession().put("fandianvalue",
							rebvaule);

					if (star.equals("8") || star.equals("9")) {// 5星级得,,返9%
						return Double.parseDouble(hotelprice)
								* 9
								/ 100
								- Double.valueOf(formatMoney_short(Double
										.parseDouble(hotelprice)
										* 9 / 100 * rebvaule + ""));
					} else {// 其他星级得 返12%
						return Double.parseDouble(hotelprice)
								* 12
								/ 100
								- Double.valueOf(formatMoney_short(Double
										.parseDouble(hotelprice)
										* 12 / 100 * rebvaule + ""));
					}

				}

			} else {
				List<Rebaterule> list = Server.getInstance().getMemberService()
						.findAllRebaterule(
								" where 1=1 and " + Rebaterule.COL_ruletypeid
										+ " =2 and "
										+ Rebaterule.COL_agenttypeid + " ="
										+ customeragent.getAgentjibie(), "",
								-1, 0);
				if (list.size() > 0) {
					rebvaule = list.get(0).getRebatvalue();
					ActionContext.getContext().getSession().put("fandianvalue",
							rebvaule);
				}

			}

		} else {
			rebvaule = (Float) fanvalue;
		}
		double price = Double.parseDouble(hotelprice);
		// Hotel hotel
		// =Server.getInstance().getHotelService().findHotel(hotelid);
		if (star == null) {
			return Double.valueOf(formatMoney_short(price * 12 / 100 * rebvaule
					+ ""));
		}
		if (star.equals("8") || star.equals("9")) {// 5星级得,,返9%
			return Double.valueOf(formatMoney_short(price * 9 / 100 * rebvaule
					+ ""));
		} else {// 其他星级得 返12%
			return Double.valueOf(formatMoney_short(price * 12 / 100 * rebvaule
					+ ""));
		}
		/*
		 * List<Hotelstar>liststar=Server.getInstance().getHotelService().findAllHotelstar("
		 * where 1=1 and "+Hotelstar.COL_starid+" ="+hotel.getStar(), "", -1,
		 * 0); double price = Double.parseDouble(hotelprice);
		 * 
		 * if(liststar.size()>0){ Double va=liststar.get(0).getVal();
		 * System.out.println(price*va/100); return price*va/100;
		 * 
		 * }else{ System.out.println(price); return price; }
		 */
	}

	// 传入酒店价格.计算出利润,传入酒店id 得到酒店星级..在根据酒店id得到酒店返点
	public Double gethotelfantoorder(String hotelprice, long hotelid,
			long memberid) throws Exception {
		String star = Server.getInstance().getHotelService().findHotel(hotelid)
				.getStar()
				+ "";
		Float rebvaule = 1F;

		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(memberid);

		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(getLoginUser().getAgentid());// 当前登录者所属

		if (customeragent.getAgentjibie() == 4) {// 如果是平台,吧利润减去会员的后.其他都都给平台
			List<Rebaterule> list = Server.getInstance().getMemberService()
					.findAllRebaterule(
							" where 1=1 and " + Rebaterule.COL_ruletypeid
									+ " =2 and " + Rebaterule.COL_agenttypeid
									+ " =5", "", -1, 0);
			if (list.size() > 0) {
				rebvaule = list.get(0).getRebatvalue();

				if (star.equals("8") || star.equals("9")) {// 5星级得,,返9%
					return Double.parseDouble(hotelprice)
							- Double.valueOf(formatMoney_short(Double
									.parseDouble(hotelprice)
									* rebvaule + ""));
				} else {// 其他星级得 返12%
					return Double.parseDouble(hotelprice)
							- Double.valueOf(formatMoney_short(Double
									.parseDouble(hotelprice)
									* rebvaule + ""));
				}

			}

		} else {
			List<Rebaterule> list = Server.getInstance().getMemberService()
					.findAllRebaterule(
							" where 1=1 and " + Rebaterule.COL_ruletypeid
									+ " =2 and " + Rebaterule.COL_agenttypeid
									+ " =" + customeragent.getAgentjibie(), "",
							-1, 0);
			if (list.size() > 0) {
				rebvaule = list.get(0).getRebatvalue();

			}

		}

		double price = Double.parseDouble(hotelprice);
		// Hotel hotel
		// =Server.getInstance().getHotelService().findHotel(hotelid);
		if (star == null) {
			return Double.valueOf(formatMoney_short(price * rebvaule + ""));
		}
		if (star.equals("8") || star.equals("9")) {// 5星级得,,返9%
			return Double.valueOf(formatMoney_short(price * rebvaule + ""));
		} else {// 其他星级得 返12%
			return Double.valueOf(formatMoney_short(price * rebvaule + ""));
		}
		/*
		 * List<Hotelstar>liststar=Server.getInstance().getHotelService().findAllHotelstar("
		 * where 1=1 and "+Hotelstar.COL_starid+" ="+hotel.getStar(), "", -1,
		 * 0); double price = Double.parseDouble(hotelprice);
		 * 
		 * if(liststar.size()>0){ Double va=liststar.get(0).getVal();
		 * System.out.println(price*va/100); return price*va/100;
		 * 
		 * }else{ System.out.println(price); return price; }
		 */
	}

	// 传入zuche价格.计算出利润,
	public Double getcarfantoorder(String orderfee, long memberid)
			throws Exception {

		Float rebvaule = 1F;

		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(memberid);

		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(getLoginUser().getAgentid());// 当前登录者所属

		if (customeragent.getAgentjibie() == 4) {// 如果是平台,吧利润减去会员的后.其他都都给平台
			List<Rebaterule> list = Server.getInstance().getMemberService()
					.findAllRebaterule(
							" where 1=1 and " + Rebaterule.COL_ruletypeid
									+ " =4 and " + Rebaterule.COL_agenttypeid
									+ " =5", "", -1, 0);
			if (list.size() > 0) {
				rebvaule = list.get(0).getRebatvalue();

				return Double.parseDouble(orderfee)
						- Double.valueOf(formatMoney_short(Double
								.parseDouble(orderfee)
								* rebvaule + ""));

			}

		} else {
			List<Rebaterule> list = Server.getInstance().getMemberService()
					.findAllRebaterule(
							" where 1=1 and " + Rebaterule.COL_ruletypeid
									+ " =4 and " + Rebaterule.COL_agenttypeid
									+ " =" + customeragent.getAgentjibie(), "",
							-1, 0);
			if (list.size() > 0) {
				rebvaule = list.get(0).getRebatvalue();

			}

		}

		double price = Double.parseDouble(orderfee);
		// Hotel hotel
		// =Server.getInstance().getHotelService().findHotel(hotelid);

		return Double.valueOf(formatMoney_short(price * rebvaule + ""));

	}

	/*
	 * hotelprice 总利润 orderid 订单ID yewutype 业务类型
	 */
	public void getrebatetouser(String hotelprice, String orderid,
			String yewutype) throws Exception {

		float lirun = 0f;// 初始化一个利润...每返利一个就增加一个...最后平台得利润等于总利润减去这个利润
		Customeruser customeruser = new Customeruser();
		// 机票业务
		if (yewutype.equals("1")) {
			Orderinfo orderinfo = Server.getInstance().getAirService()
					.findOrderinfo(Long.parseLong(orderid));
			customeruser = Server.getInstance().getMemberService()
					.findCustomeruser(orderinfo.getCustomeruserid());// 查询出来那个会员预订得
		}
		// 酒店业务
		else if (yewutype.equals("2")) {
			Hotelorder hotelorder = Server.getInstance().getHotelService()
					.findHotelorder(Long.parseLong(orderid));// 查询出来订单
			customeruser = Server.getInstance().getMemberService()
					.findCustomeruser(hotelorder.getMemberid());// 查询出来那个会员预订得
		} else if (yewutype.equals("4")) {

		} else if (yewutype.equals("5")) {

		}

		// 取出会员返利
		Float userrebvaule = 0f;// 初始化会员的返利比例
		Float userfan = 0f;// 初始化会员得返利值
		List<Rebaterule> listuserrebate = Server
				.getInstance()
				.getMemberService()
				.findAllRebaterule(
						" where 1=1 and " + Rebaterule.COL_ruletypeid + " ="
								+ yewutype + " and "
								+ Rebaterule.COL_agenttypeid + " =5", "", -1, 0);
		if (listuserrebate.size() > 0) {
			userrebvaule = listuserrebate.get(0).getRebatvalue(); // 会员的返利比例
			userfan = userrebvaule * Float.parseFloat(hotelprice);// 会员的返利比例*总利润=会员的返利值
		}
		if (customeruser.getProfits() == null) {
			customeruser.setProfits(0.0f);
		}
		customeruser.setProfits(customeruser.getProfits() + userfan);// 增加会员的返利
		// 机票不需要对会员进行后返，因为机票直接把对会员的返佣，体现在了预订的机票价格
		if (!yewutype.equals("1")) {
			Server.getInstance().getMemberService()
					.updateCustomeruserIgnoreNull(customeruser);
		}
		ActionContext.getContext().getSession().remove("orderuserlogin");// 返利增加了...清除以前sesiion值
		ActionContext.getContext().getSession().put("orderuserlogin",
				customeruser);// 把增加了返利值得最新用户信息放到session里面

		// 创建会员返利记录开始

		Rebaterecord rebaterecord_user = new Rebaterecord();
		rebaterecord_user.setOrdernumber(orderid);
		rebaterecord_user.setRebateagentid(customeruser.getId());
		rebaterecord_user.setChildagentid(getLoginUserAgent().getId());
		rebaterecord_user.setRebatetime(new Timestamp(System
				.currentTimeMillis()));
		rebaterecord_user.setYewutype(Long.parseLong(yewutype));
		rebaterecord_user.setRebatemoney(userfan);
		rebaterecord_user.setRebateagentjibie(5);
		String strAgentName = getLoginUserAgent().getAgentcompanyname();
		if (getLoginUserAgent().getId() == 46) {
			strAgentName = "平台";
		}
		rebaterecord_user.setRebatememo("会员的返利记录-会员："
				+ customeruser.getMembername() + "得到" + strAgentName + "返佣"
				+ userfan + "元");
		Server.getInstance().getMemberService().createRebaterecord(
				rebaterecord_user);

		lirun += userfan;
		// 创建会员返利记录结束

		// 得到平台加盟商开始
		Customeragent customerag = new Customeragent();
		List<Customeragent> listcustom = Server.getInstance()
				.getMemberService().findAllCustomeragent(
						" where 1=1 and " + Customeragent.COL_agentjibie
								+ " =4", "", -1, 0);// 取出平台
		if (listcustom.size() > 0) {
			customerag = listcustom.get(0);// 平台

		}
		// 得到平台加盟商结束

		float price = Float.valueOf(hotelprice);
		Float rebvaule = 1F;

		long andid = customeruser.getAgentid();// 初始化为会员的加盟商ID

		// 当前级返记录
		Customeragent cu = Server.getInstance().getMemberService()
				.findCustomeragent(andid);
		if (cu.getAgentjibie() != 4) {// 如果是平台.当前级不返利
			List<Rebaterule> listcc = Server.getInstance().getMemberService()
					.findAllRebaterule(
							" where 1=1 and " + Rebaterule.COL_ruletypeid
									+ " =" + yewutype + " and "
									+ Rebaterule.COL_agenttypeid + " ="
									+ cu.getAgentjibie(), "", -1, 0);

			if (listcc.size() > 0) {
				rebvaule = listcc.get(0).getRebatvalue();
			}
			Rebaterecord rebaterecord2 = new Rebaterecord();
			rebaterecord2.setOrdernumber(orderid);
			rebaterecord2.setRebateagentid(cu.getId());
			rebaterecord2.setRebatetime(new Timestamp(System
					.currentTimeMillis()));
			rebaterecord2.setYewutype(Long.parseLong(yewutype));
			rebaterecord2.setRebateagentjibie(cu.getAgentjibie());
			rebaterecord2.setRebatemoney(Float
					.parseFloat(price * rebvaule + ""));
			rebaterecord2.setRebatememo(getAgentTypeName(cu.getAgentjibie())
					+ "的返利记录-" + cu.getAgentcompanyname() + "得到返佣"
					+ rebaterecord2.getRebatemoney() + "元");
			List<Customeragent> listcus = Server.getInstance()
					.getMemberService().findAllCustomeragent(
							" where 1=1 and " + Customeragent.COL_parentid
									+ " =" + cu.getId(), "", -1, 0);
			if (listcus.size() > 0) {
				rebaterecord2.setChildagentid(listcus.get(0).getId());
			}
			rebaterecord2.setChildagentid(andid);
			Server.getInstance().getMemberService().createRebaterecord(
					rebaterecord2);

			cu.setVmoney(cu.getVmoney() + price * rebvaule);
			Server.getInstance().getMemberService()
					.updateCustomeragentIgnoreNull(cu);
			lirun += price * rebvaule;
		}
		for (int a = 1; a > 0; a++) {
			Customeragent customeragent = Server.getInstance()
					.getMemberService().findCustomeragent(andid);

			if (customeragent.getParentid() != null
					&& customeragent.getParentid() != 0) {// 说明改加盟商还有父加盟商
				Customeragent cus = Server.getInstance().getMemberService()
						.findCustomeragent(customeragent.getParentid());// 当前登陆者得父加盟商

				List<Rebaterule> list = Server.getInstance().getMemberService()
						.findAllRebaterule(
								" where 1=1 and " + Rebaterule.COL_ruletypeid
										+ " =" + yewutype + " and "
										+ Rebaterule.COL_agenttypeid + " ="
										+ cus.getAgentjibie(), "", -1, 0);
				if (list.size() > 0) {
					rebvaule = list.get(0).getRebatvalue();
				}
				Rebaterecord rebaterecord = new Rebaterecord();
				rebaterecord.setOrdernumber(orderid);
				rebaterecord.setRebateagentid(cus.getId());
				rebaterecord.setRebateagentjibie(cus.getAgentjibie());
				rebaterecord.setRebatetime(new Timestamp(System
						.currentTimeMillis()));
				rebaterecord.setYewutype(Long.parseLong(yewutype));
				rebaterecord.setRebatemoney(Float.parseFloat(price * rebvaule
						+ ""));
				rebaterecord
						.setRebatememo(getAgentTypeName(cus.getAgentjibie())
								+ "的返利记录-" + cus.getAgentcompanyname() + "得到返佣"
								+ rebaterecord.getRebatemoney() + "元");

				rebaterecord.setChildagentid(getLoginUser().getAgentid());
				Server.getInstance().getMemberService().createRebaterecord(
						rebaterecord);

				System.out.println(cus.getVmoney());
				cus.setVmoney(cus.getVmoney() + price * rebvaule);
				Server.getInstance().getMemberService()
						.updateCustomeragentIgnoreNull(cus);

				lirun += price * rebvaule;
				andid = cus.getId();// 说明有父加盟商,把父加盟商ID赋予给andid,初始化为当前加盟商ID继续寻找上级父加盟商,直到没有.
			} else {// 没有父加盟商了...

				break;
			}

		}
		customerag.setVmoney(customerag.getVmoney() + price - lirun);

		Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(
				customerag);

		Rebaterecord rebaterecord_ptai = new Rebaterecord();
		rebaterecord_ptai.setOrdernumber(orderid);
		rebaterecord_ptai.setRebateagentid(customerag.getId());
		rebaterecord_ptai.setRebatetime(new Timestamp(System
				.currentTimeMillis()));
		rebaterecord_ptai.setYewutype(Long.parseLong(yewutype));
		rebaterecord_ptai.setRebateagentjibie(customerag.getAgentjibie());
		rebaterecord_ptai.setRebatemoney(Float
				.parseFloat(price * rebvaule + ""));
		rebaterecord_ptai.setRebatememo("平台的返利记录-平台得到返佣"
				+ rebaterecord_ptai.getRebatemoney() + "元");
		rebaterecord_ptai.setRebatemoney(Float.parseFloat(price - lirun + ""));
		rebaterecord_ptai.setChildagentid(getLoginUser().getAgentid());

		Server.getInstance().getMemberService().createRebaterecord(
				rebaterecord_ptai);

	}

	// 得出旅游返点得价格
	public Double gettravefan(String traveprice) throws Exception {
		double price = Double.parseDouble(traveprice);

		String fvalue = travefan();
		Double a = Double.parseDouble(fvalue);
		fvalue = (a / 1000) + "";

		return Double.parseDouble(SubString(
				(price * Double.parseDouble(fvalue)) + "", 3));
	}

	// 获取旅游返点值
	public String travefan() throws Exception {
		List<Sysconfig> list = Server.getInstance().getSystemService()
				.findAllSysconfig(
						" where 1=1 and " + Sysconfig.COL_name + " = '旅游返点'",
						"", -1, 0);

		return list.get(0).getValue();
	}

	public boolean checkcode(long id) {
		Systemright sys = Server.getInstance().getMemberService()
				.findSystemright(id);

		if (sys.getType() == 2) {
			return true;
		}
		return false;
	}

	public String formatTimestampyyyyMMdd(Timestamp date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public String formatTimestampyyMMdd(Timestamp date) {
		try {
			return (new SimpleDateFormat("yy-MM-dd").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 根据机场代码获取城市名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getCitynameByAirport(String airport) {
		/*String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getCityname() : "";*/
		
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
		+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		if(list.size()>0){
			if(list.get(0).getCityname()!=null){
				return list.get(0).getCityname();
			}else{
				return "";
			}
			
		}else{
			String whereinter = "where " + Fcity.COL_citycode + "='" + airport
			+ "'";
				List<Fcity> listinter = Server.getInstance().getInterticketService()
						.findAllFcity(whereinter, "ORDER BY ID", -1, 0);
				if(listinter.size()>0){
					if(listinter.get(0).getCityname()!=null){
						return listinter.get(0).getCityname();
					}else{
						return "";
					}
					
				}
			
		}

return "";

	}

	public float getRoundPrice(float price, int f) {
		//return (float) Math.round(price / 10 / f + 0.00001) * 10;
		return (float) Math.round(price / 10 / f + 0.00001) * 10;
	}

	public String getdepartmentNamebyId(long id) {
		Department department = Server.getInstance().getMemberService()
				.findDepartment(id);
		if (department != null) {
			return department.getName();
		}
		return "";
	}

	public String ziquaddress() {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='ziquaddresss'", "", -1, 0)
				.get(0)).getValue();
	}

	public String getcususercode(long id) {
		String strReturn = ",";
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());
		if (customeragent != null && customeragent.getCode().length() > 0) {

			if (customeragent.getMucode() != null
					&& !customeragent.getMucode().equals("")) {
				strReturn += customeragent.getMucode() + ",";
			}
			if (customeragent.getCzcode() != null
					&& !customeragent.getCzcode().equals("")) {
				strReturn += customeragent.getCzcode() + ",";
			}
			if (customeragent.getCacode() != null
					&& !customeragent.getCacode().equals("")) {
				strReturn += customeragent.getCacode() + ",";
			}

			return customeragent.getMucode() + "," + customeragent.getCzcode()
					+ "," + customeragent.getCacode();
		} else {
			return "";
		}
	}

	/**
	 * 获得用户单位
	 * 
	 * @param id
	 * @return
	 */
	public String getcususeragentname(long customerid) {
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customerid);
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());
		if (customeragent != null && customeragent.getCode().length() > 0) {
			return customeragent.getAgentcompanyname();
		} else {
			return "";
		}
	}

	/**
	 * 取得集团客户名称简称
	 * 
	 * @param customerid
	 * @return
	 */
	public String getcususeragentsname(long customerid) {
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customerid);
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());
		if (customeragent != null && customeragent.getCode().length() > 0) {
			return customeragent.getAgentshortname();
		} else {
			return "";
		}
	}

	public String getCustagentNameById(long agentid) {
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(agentid);
		if (agent != null) {
			return agent.getAgentcompanyname();
		}
		return "";

	}// 根据ID查询登录账号

	public String getloginnamebyid(long id) {

		return Server.getInstance().getMemberService().findCustomeruser(id)
				.getLoginname();

	}

	public String getCustagentNameBystr(String agentid) {
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(Long.parseLong(agentid));
		if (agent != null) {
			return agent.getAgentcompanyname();
		}
		return "";

	}

	public boolean arrayexist(int number, int[] numbers) {
		boolean rtv = false;
		for (int n : numbers) {
			if (n == number) {
				rtv = true;
			}
		}
		return rtv;

	}

	public String formatTimestamporderbydate(Timestamp date) {

		try {
			return (new SimpleDateFormat("yyyyMMddHHmm").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 获取短信模板
	 * 
	 * @param nodest
	 * @return
	 */
	public String getSMSTemple(String nodecode) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(
				"MessageTemple.xml");
		InputStream is;
		try {
			is = new FileInputStream(url.getFile());
			SAXBuilder build = new SAXBuilder();
			Document document = build.build(is);
			Element root = document.getRootElement();
			return root.getChildText(nodecode);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取是否是大客户
	 * 
	 * @param id
	 * @return
	 */
	public boolean getbiguser(long id) {
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		if (customeruser != null) {
			Customeragent customeragent = Server.getInstance()
					.getMemberService().findCustomeragent(
							customeruser.getAgentid());
			if (customeruser != null) {
				if (customeragent.getBigtype() != null
						&& customeragent.getBigtype() == 1) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 调用短信接口发送短信
	 * 
	 * @param mobiles
	 *            手机号码组
	 * @param content
	 *            短信内容
	 * @param ordercode
	 *            订单号 可选
	 * @return
	 */
	public int smsSend(String[] mobiles, String content, String ordercode,
			String strUserID) {
		return Server.getInstance().getAtomService().sendSms(mobiles, content,
				ordercode, strUserID);
	}

	public String SubString(String str, int len) {
		if (str == null)
			return str;
		if (str.length() <= len)
			return str;

		return str.substring(0, Math.abs(len));
	}

	/**
	 * 截取字符串带...
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public String subStringstr(String str, int len) {
		if (str == null)
			return str;
		if (str.length() <= len)
			return str;

		return str.substring(0, Math.abs(len) - 3) + "...";
	}

	/**
	 * 截取字符串带...
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public String subfightimg(String str) {
		if (str == null)
			return str;
		String a = str.substring(0, str.indexOf("#"));
		String b = str.substring(str.indexOf("#") + 1);
		return "<span style='width: 100%;text-align: center;'><img src='images/flight/"
				+ b
				+ "' align='left' width='100' height='64' style='margin-right: :5px'/></span>"
				+ a;
	}

	public String formatTimestampHHmm(Timestamp date) {
		try {
			return (new SimpleDateFormat("HH:mm").format(date));

		} catch (Exception e) {
			return "";
		}
	}

	public String formatTimestampHHmm_B2B(Timestamp date) {
		try {
			return (new SimpleDateFormat("HHmm").format(date));

		} catch (Exception e) {
			return "";
		}
	}

	public String formatTimestampHHmm2(Timestamp date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));

		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取保险金额
	 * 
	 * @param sum
	 * @return
	 */
	public float getInsurancPrice(Long insruid) {
		if(insruid!=null){
		float price = 0f;
		if (insruid != null && insruid > 0l) {
			Insuranceinfo insurance = Server.getInstance().getMemberService()
					.findInsuranceinfo(insruid);
			price = Float.valueOf(insurance.getInsurancefee());
		}
		return price;
		}else{
			return 0f;
		}
	}

	/**
	 * 根据订单号获得保险金额
	 * 
	 * @param orderid
	 * @return
	 */
	public float getIssurByOrderid(Long orderid) {
		float price = 0f;
		if (orderid != null && orderid > 0l) {
			List<Passenger> listpassenger = Server.getInstance()
					.getAirService().findAllPassenger(
							"where " + Passenger.COL_orderid + "=" + orderid,
							"", -1, 0);
			if (listpassenger.size() > 0) {
				for (Passenger pass : listpassenger) {
					if(pass.getInsurprice()!=null&&pass.getInsurprice()>0){
					price += pass.getInsurprice();
					}
				}
			}
		}
		
		//System.out.println("orderid:"+orderid+",,,price:"+price);
		return price;
	}
	public float getxuanzuoByOrderid(Long orderid) {
		float price = 0f;
		if (orderid != null && orderid > 0l) {
			List<Passenger> listpassenger = Server.getInstance()
					.getAirService().findAllPassenger(
							"where " + Passenger.COL_orderid + "=" + orderid,
							"", -1, 0);
			if (listpassenger.size() > 0) {
				for (Passenger pass : listpassenger) {
					if(pass.getAnjianfee()!=null&&pass.getAnjianfee()>0){
					price += pass.getAnjianfee();
					}
				}
			}
		}
		
		//System.out.println("orderid:"+orderid+",,,price:"+price);
		return price;
	}
	/**
	 * 根据订单号获得是否选择行程单
	 * 
	 * @param orderid
	 * @return
	 */
	public int getXCDByOrderid(Long orderid) {
		int re=0;
		List list=Server.getInstance().getAirService().findAllPeisong(" WHERE 1=1 AND "+Peisong.COL_orderid+" ="+orderid, " ORDER BY ID DESC ", -1, 0);
		re=list.size();
		return re;
	}

	/**
	 * 取得Session中的用户
	 * 
	 * @return
	 */
	public Customeruser getLoginUser() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("loginuser");
		// Customeruser user =
		// Server.getInstance().getMemberService().findCustomeruser(1l);
		
		
		return user;
	}
	/**
	 * 取得Session中的用户
	 * 
	 * @return
	 */
	public Txuserinfo getLoginUser_tx() {
		Txuserinfo user = (Txuserinfo) ActionContext.getContext()
				.getSession().get("loginuser_tx");
		// Customeruser user =
		// Server.getInstance().getMemberService().findCustomeruser(1l);
		
		
		return user;
	}
	/**
	 * 取得Session中的用户的加盟商
	 * 
	 * @return
	 */
	public Customeragent getLoginAgent() {
		Customeragent customeragent = (Customeragent) ActionContext.getContext()
				.getSession().get("loginagent");
		// Customeruser user =
		// Server.getInstance().getMemberService().findCustomeruser(1l);

		return customeragent;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Customeragent getLoginUserAgent() {
		return this.getLoginsessionagent();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Customeragent getLoginsessionagent() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("loginagent") != null) {
			return (Customeragent) session.getAttribute("loginagent");
		} else {
			Customeruser user = (Customeruser) ActionContext.getContext()
					.getSession().get("loginuser");
			// String sql = "SELECT ID AS id,C_PARENTID AS parentid, C_SELFCODE
			// AS selfcode, C_AGENTCOMPANYNAME AS agentcompanyname ,"
			// + "C_AGENTSHORTNAME AS agentshortname, C_AGENTTYPE AS
			// agenttype,C_AGENTJIBIE AS agentjibie,"
			// + "C_AGENTISENABLE AS agentisenable,C_AGENTCHECKSTATUS AS
			// agentcheckstatus FROM T_CUSTOMERAGENT WHERE ID="
			// + user.getAgentid();
			//			
			Customeragent agent = Server.getInstance().getSystemService()
					.getTObject(Customeragent.class, user.getAgentid(),
							Customeragent.COL_id, Customeragent.COL_parentid,
							Customeragent.COL_agentcompanyname,
							Customeragent.COL_agentshortname,
							Customeragent.COL_agenttype,
							Customeragent.COL_industry,
							Customeragent.COL_agentjibie,
							Customeragent.COL_agentisenable,
							Customeragent.COL_agentcheckstatus);
			session.setAttribute("loginagent", agent);

			return agent;
		}
	}

	/**
	 * 通过会员的id,得到加盟商的id
	 * 
	 * @param memberid
	 * @return
	 */
	public String getCustagentidByMemberId_b2b(String memberid) {
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(Long.parseLong(memberid));
		if (customeruser != null) {
			return customeruser.getAgentid() + "";
		}
		return "";

	}

	/**
	 * 取得Session为预订的客户的用户
	 * 
	 * @return
	 */
	public Customeruser getOrderUserLogin() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		return user;
	}

	public Systemrole getLoginRole() {

		Systemrole role = (Systemrole) ActionContext.getContext().getSession()
				.get("loginrole");

		return role;
	}

	/**
	 * 转换null
	 * 
	 * @param <T>
	 * @param t
	 * @param v
	 * @return
	 */
	public <T> T converNull(T t, T v) {
		if (t != null&&!t.equals("")&&!t.equals(" ")&&!t.equals("null")&&!t.equals("0")) {
			//System.out.println("??????????????????????????");
			//System.out.println("t:"+t);
			return t;
		}
		return v;
	}

	/**
	 * @return roes;返回当前登录用户的所有角色List<Long>
	 */
	public List<Long> getLoginUserRoleNumber() {
		List<Long> roes = new ArrayList<Long>();
		String sql = " SELECT * FROM [T_AGENTROLEREF] WHERE C_CUSTOMERUSERID="
				+ this.getLoginUserId();
		List<Agentroleref> roles = Server.getInstance().getMemberService()
				.findAllAgentrolerefBySql(sql, -1, 0);
		if (roles != null && roles.size() > 0) {
			for (Agentroleref role : roles) {
				roes.add(role.getRoleid());
			}
		}
		return roes;
	}

	private String deptstring;

	/**
	 * @param deptid
	 * @return 根据部门Id返回其所有子部门
	 */
	protected String getSubDetpt(long deptid) {
		deptstring = "" + deptid;
		this.getDept(deptid);
		return deptstring;
	}

	private void getDept(long deptid) {
		String where = "  WHERE C_PARENTID=" + deptid;
		List<Department> depts = Server.getInstance().getMemberService()
				.findAllDepartment(where, "", -1, 0);
		if (depts != null && depts.size() > 0) {
			for (Department dept : depts) {
				deptstring += "," + dept.getId();
				getDept(dept.getId());
			}

		}
	}

	public String getAllDeptIdByAgentId(long agentid) {
		String deptstr = String.valueOf(agentid);
		String sql = " SELECT ID FROM T_DEPARTMENT WHERE C_AGENTID=" + agentid;
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		for (Object obj : list) {
			Map map = (HashMap) obj;
			deptstr += "," + map.get("ID").toString();
		}
		return deptstr;
	}

	public String getorderusermobile() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		if (user != null) {
			String strtle = user.getMobile();
			if (user.getId() != 0) {
				return user.getMobile();
			}
			if (strtle != null && !strtle.equals("")) {
				return strtle;
			}
		}
		return "无";
	}

	public String getorderusername() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		if (user != null) {
			return user.getMembername();
		}
		return "无";
	}

	public String getorderuserdepartment() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		if (user != null) {
			Department department = Server.getInstance().getMemberService()
					.findDepartment(user.getDeptid());
			if (department != null) {
				return department.getName();
			}
		}
		return "无";
	}

	public String getorderusercompany() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		if (user != null && user.getAgentid() != 46) {
			Customeragent customeragent = Server.getInstance()
					.getMemberService().findCustomeragent(user.getAgentid());
			if (customeragent != null) {
				return customeragent.getAgentcompanyname();
			}
		}
		return "无";
	}

	public String getorderusercompanybyid(long id) {
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(id);
		if (customeragent != null) {
			return customeragent.getAgentcompanyname();
		}
		return "无";
	}

	public String getemployeenamebyid(long id) {
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		if (customeruser != null) {
			return customeruser.getMembername();
		}
		return "无";
	}

	public String getorderuserdepartmentbyid(long id) {
		Department department = Server.getInstance().getMemberService()
				.findDepartment(id);
		if (department != null) {
			return department.getName();
		}
		return "无";
	}

	/**
	 * 取得Session中的用户ID
	 */
	public long getLoginUserId() {
		try {
			return getLoginUser().getId();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//
	/*
	 * public boolean hasACL(String code){
	 * 
	 * try { Systemrole role = this.getLoginRole(); List<Systemright> listright =
	 * Server.getInstance().getSystemrightManager().findAllSystemright(" where " +
	 * Systemright.COL_code +" = '" +code+"'","",1,0); if(listright.isEmpty()){
	 * return false; }
	 * 
	 * List<Sysroleright> list=
	 * Server.getInstance().getSysrolerightManager().findAllSysroleright("where " +
	 * Sysroleright.COL_roleid + "=" + role.getId() + " and "+
	 * Sysroleright.COL_rightid + "="+listright.get(0).getId(),"",-1,0 ) ;
	 * 
	 * if(list.isEmpty()){ return false; }
	 * 
	 * return true; } catch (Exception e) { e.printStackTrace(); return false; } }
	 */

	public String getPagination() {
		return getPagination("\""
				+ this.getClass().getSimpleName().toLowerCase().replaceFirst(
						"action", "") + ".action?pageinfo.pagenum=\"+pageno");
	}

	/**
	 * twocold
	 * 
	 * @param pageinfo
	 * @param pagename
	 *            用于在不同的实例名字
	 * @param action
	 *            所要访问的action
	 * @param formname
	 *            所提交的form
	 * @return String 通过不同PageInfo实例 进行分页
	 */
	public String getPagetwo(PageInfo pageinfo, String pagename, String action,
			String formname) {
		return getPageself("\"" + action + "?" + pagename
				+ ".pagenum=\"+pageno", pageinfo, formname);
	}

	public String getandKeepParamPagination(String strUrl, String strParam) {
		String strReturn = strUrl + strParam;
		return strReturn;
	}

	public String getPagination(String action) {
		StringBuffer sb = new StringBuffer();

		sb.append("共&nbsp;" + pageinfo.getTotalrow() + "&nbsp;条记录&nbsp;");

		if (pageinfo.getTotalrow() == 0) {
			return sb.toString();
		}
		sb.append("当前" + pageinfo.getPagenum() + "/" + pageinfo.getTotalpage()
				+ "页&nbsp;");

		sb
				.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(1);'>首页</a>&nbsp;<span class=\"font_grey_001\">");

		if (pageinfo.hasFront()) {
			sb
					.append(
							" <a href='#' class=\"font_grey_001\" onclick='javascript:go(")
					.append(pageinfo.getPagenum() - 1).append(
							");'>上一页</a>&nbsp;");
		}

		if (pageinfo.getTotalpage() == 1) {

			sb.append(" <strong>1</strong> ");
		} else {

			int pre = pageinfo.getPagenum() - 5; // 前页数
			int bac = pageinfo.getTotalpage() - pageinfo.getPagenum(); // 后页数

			if (pre >= 1 && bac >= 5) {
				for (int i = pageinfo.getPagenum() - 5; i < pageinfo
						.getPagenum() + 5; i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
										+ i + ");'>" + i + "</a>");
					}
				}
			} else if (pre <= 0) { // 前页数不够5页

				for (int i = 1; i <= 10 && i <= pageinfo.getTotalpage(); i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
										+ i + ");'>" + i + "</a>");
					}
				}

			} else if (bac < 5) { // 后页数不够5页
				int i = 1;
				if (pageinfo.getTotalpage() > 10) {
					i = pageinfo.getPagenum() - (9 - bac);
				}

				for (; i > 0 && i <= pageinfo.getTotalpage(); i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
										+ i + ");'>" + i + "</a>");
					}
				}

			}

		}

		if (pageinfo.hasBack()) {
			sb
					.append(
							" <a href='#' class=\"font_grey_001\" onclick='javascript:go(")
					.append((pageinfo.getPagenum() + 1)).append(");'>下一页</a>");
		}
		if (pageinfo.hasBack()) {
			sb.append("<input  type='text' size='3' id='tiaozhuan' name='tiaozhuan' /><a href='#'  onclick='javascript:go2();return false;' >跳转</a>");
		}
		
		if (pageinfo.getTotalpage() > 0) {
			sb
					.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
							+ pageinfo.getTotalpage() + ");'>尾页</a></span>");
		}
		

		sb.append("<script>" + "function go(pageno){"
				+ "document.form1.action=" + action + ";"
				+ "document.form1.submit();}" +
						"function go2(){var una = document.getElementById('tiaozhuan').value;go(una);}" + "</script>");

		return sb.toString();
	}
	public String getPagination2(String action) {
		StringBuffer sb = new StringBuffer();

		sb.append("共&nbsp;" + pageinfo.getTotalrow() + "&nbsp;条记录&nbsp;");

		if (pageinfo.getTotalrow() == 0) {
			return sb.toString();
		}
		sb.append("当前" + pageinfo.getPagenum() + "/" + pageinfo.getTotalpage()
				+ "页&nbsp;");

		sb
				.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(1);'>首页</a>&nbsp;<span class=\"font_grey_001\">");

		if (pageinfo.hasFront()) {
			sb
					.append(
							" <a href='#' class=\"font_grey_001\" onclick='javascript:go(")
					.append(pageinfo.getPagenum() - 1).append(
							");'>上一页</a>&nbsp;");
		}

		if (pageinfo.getTotalpage() == 1) {

			sb.append(" <strong>1</strong> ");
		} else {

			int pre = pageinfo.getPagenum() - 5; // 前页数
			int bac = pageinfo.getTotalpage() - pageinfo.getPagenum(); // 后页数

			if (pre >= 1 && bac >= 5) {
				for (int i = pageinfo.getPagenum() - 5; i < pageinfo
						.getPagenum() + 5; i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
										+ i + ");'>" + i + "</a>");
					}
				}
			} else if (pre <= 0) { // 前页数不够5页

				for (int i = 1; i <= 10 && i <= pageinfo.getTotalpage(); i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
										+ i + ");'>" + i + "</a>");
					}
				}

			} else if (bac < 5) { // 后页数不够5页
				int i = 1;
				if (pageinfo.getTotalpage() > 10) {
					i = pageinfo.getPagenum() - (9 - bac);
				}

				for (; i > 0 && i <= pageinfo.getTotalpage(); i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
										+ i + ");'>" + i + "</a>");
					}
				}

			}

		}

		if (pageinfo.hasBack()) {
			sb
					.append(
							" <a href='#' class=\"font_grey_001\" onclick='javascript:go(")
					.append((pageinfo.getPagenum() + 1)).append(");'>下一页</a>");
		}

		if (pageinfo.getTotalpage() > 0) {
			sb
					.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("
							+ pageinfo.getTotalpage() + ");'>尾页</a></span>");
		}

		sb.append("<script>" + "function go(pageno){"
				+ "document.form1.action=" + action + ";"
				+ "document.form1.submit();" + "}" + "</script>");

		return sb.toString();
	}

	/**
	 * twocold
	 * 
	 * @param action
	 *            所调用的action
	 * @param pageinfo
	 *            所使用PageInfo 实例
	 * @param formname
	 *            所提交的form 名字
	 * @return
	 */
	public String getPageself(String action, PageInfo pageinfo, String formname) {
		StringBuffer sb = new StringBuffer();
		sb.append("共&nbsp;" + pageinfo.getTotalrow() + "&nbsp;条记录&nbsp;");

		if (pageinfo.getTotalrow() == 0) {
			return sb.toString();
		}
		sb.append("当前" + pageinfo.getPagenum() + "/" + pageinfo.getTotalpage()
				+ "页&nbsp;");

		sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:"
				+ formname
				+ "go(1);'>首页</a>&nbsp;<span class=\"font_grey_001\">");

		if (pageinfo.hasFront()) {
			sb.append(
					" <a href='#' class=\"font_grey_001\" onclick='javascript:"
							+ formname + "go(").append(
					pageinfo.getPagenum() - 1).append(");'>上一页</a>&nbsp;");
		}

		if (pageinfo.getTotalpage() == 1) {

			sb.append(" <strong>1</strong> ");
		} else {

			int pre = pageinfo.getPagenum() - 5; // 前页数
			int bac = pageinfo.getTotalpage() - pageinfo.getPagenum(); // 后页数

			if (pre >= 1 && bac >= 5) {
				for (int i = pageinfo.getPagenum() - 5; i < pageinfo
						.getPagenum() + 5; i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:"
										+ formname
										+ "go("
										+ i
										+ ");'>"
										+ i
										+ "</a>");
					}
				}
			} else if (pre <= 0) { // 前页数不够5页

				for (int i = 1; i <= 10 && i <= pageinfo.getTotalpage(); i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:"
										+ formname
										+ "go("
										+ i
										+ ");'>"
										+ i
										+ "</a>");
					}
				}

			} else if (bac < 5) { // 后页数不够5页
				int i = 1;
				if (pageinfo.getTotalpage() > 10) {
					i = pageinfo.getPagenum() - (9 - bac);
				}

				for (; i > 0 && i <= pageinfo.getTotalpage(); i++) {
					if (i == pageinfo.getPagenum()) {
						sb.append(" <strong>" + i + "</strong> ");
					} else {
						sb
								.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:"
										+ formname
										+ "go("
										+ i
										+ ");'>"
										+ i
										+ "</a>");
					}
				}

			}

		}

		if (pageinfo.hasBack()) {
			sb.append(
					" <a href='#' class=\"font_grey_001\" onclick='javascript:"
							+ formname + "go(").append(
					(pageinfo.getPagenum() + 1)).append(");'>下一页</a>");
		}

		if (pageinfo.getTotalpage() > 0) {
			sb
					.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:"
							+ formname
							+ "go("
							+ pageinfo.getTotalpage()
							+ ");'>尾页</a></span>");
		}

		sb.append("<script>" + "function " + formname + "go(pageno){"
				+ "document." + formname + ".action=" + action + ";"
				+ "document." + formname + ".submit();" + "}" + "</script>");
		return sb.toString();
	}

	public static String formatDate(Date date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public static String formatDateyyyyHHmm(Date date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public String formatDatetoMinute(Date date) {
		return minuteformat.format(date);
	}

	/**
	 * 取得机票信息
	 * 
	 * @param strTicketNumber
	 * @return
	 */
	public static String getTicketInfo(String strTicketNumber) {
		String strReturn = "";
		if (!strTicketNumber.equals("")) {
			strReturn = Server.getInstance().getTicketSearchService()
					.commandFunction2("DETR:TN/" + strTicketNumber, "", "");
		}
		return strReturn;
	}

	public String encoder(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return url;
		}
	}

	public String decoder(String url) {
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return url;
		}
	}

	private SimpleDateFormat simplefromat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public String formatTimestamp(Timestamp date) {
		try {
			return (simplefromat.format(date));

		} catch (Exception e) {
			return "";
		}

	}

	private SimpleDateFormat minuteformat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	public String formatTimestamptoMinute(Timestamp date) {
		try {
			return (minuteformat.format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public String formatTimestamp3(Timestamp date) {
		try {
			return (new SimpleDateFormat("HH:mm").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public String formatTimestamp4(Timestamp date) {
		try {
			return (new SimpleDateFormat("MM-dd").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public static Timestamp dateToTimestampyyyyMM(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat();
			dateFormat = new SimpleDateFormat("yyyy-MM");
			return (new Timestamp(dateFormat.parse(date).getTime()));

		} catch (Exception e) {
			return null;
		}

	}

	public String formatTimestampyyyyMM(Timestamp date) {
		try {
			return (new SimpleDateFormat("yyyy-MM").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	public String formatTimestamp2(Timestamp date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	// 将时间格式转变为 小时，分 Created by vic @ 20110902
	public String formatTimestampToHm(Timestamp date) {
		try {
			return (new SimpleDateFormat("HH:mm").format(date));

		} catch (Exception e) {
			return "";
		}

	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat();

	public static Timestamp dateToTimestamp(String date) {
		try {

			if (date.length() == 10) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
			return (new Timestamp(dateFormat.parse(date).getTime()));

		} catch (Exception e) {
			return null;
		}

	}

	public String formatStringTime(String date) {
		try {
			return this.formatDatetoMinute(simplefromat.parse(date));

		} catch (Exception e) {
			e.printStackTrace();
			return date;
		}
	}

	public String formatStringTime(String date, String format) {
		try {
			SimpleDateFormat simplefromat = new SimpleDateFormat(format);
			return this.formatDatetoMinute(simplefromat.parse(date));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String formatMoney_string(String s) {

		// String s = "123.456 ";

		float money = 0f;
		try {
			money = Float.valueOf(s).floatValue();
		} catch (Exception e) {

		}

		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			return Float.toString(money);
		}
	}

	public String formatMoney_short(String s) {

		// String s = "123.456 ";
		float money = Float.valueOf(s).floatValue();

		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.00");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			return Float.toString(money);
		}
	}
	public String formatMoney_int(String s) {

		// String s = "123.456 ";
		float money = Float.valueOf(s).floatValue();

		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			return Float.toString(money);
		}
	}

	public String formatMoney_B2BBack(String s) {

		// String s = "123.456 ";
		float money = Float.valueOf(s).floatValue();

		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.00");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			return Float.toString(money);
		}
	}

	/**
	 * 将money格式化为类似于2,243,234.00的格式
	 * 
	 * @param money
	 * @return
	 */
	DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();

	public String formatMoney(Float money) {
		format.applyPattern("#,##0.00");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			if (money != null) {
				return Float.toString(money);
			} else {
				return "0";
			}
		}
	}

	/**
	 * 根据酒店ID获取对应图片路径
	 * 
	 * @param hotelid
	 * @return 图片路径
	 */
	public String getImage(long hid) {
		// Hotel hot = Server.getInstance().getHotelService().findHotel(hid);

		String where = " WHERE " + Hotelimage.COL_hotelid + " =" + hid;
		List<Hotelimage> listImages = Server.getInstance().getHotelService()
				.findAllHotelimage(where, " ORDER BY ID", -1, 0);
		if (listImages.size() > 0) {
			return listImages.get(0).getPath();
		}
		return "/NoImage.gif";
		
	}

	/**
	 * 将money格式化为类似于2,243,234的格式
	 * 
	 * @param money
	 * @return
	 */
	public String formatMoneyShort(Float money) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("#,##0.0");
		try {
			String result = format.format(money);
			return result;
		} catch (Exception e) {
			return Float.toString(money);
		}
	}

	// public void abateMemberVmoney(Customeruser user, String ordernumber,
	// int type, float money, String memo) {
	// try {
	// Customeragent agent = this.getLoginUserAgent();
	// float cmoney = agent.getVmoney() + money;
	// agent.setVmoney(cmoney);
	// Server.getInstance().getMemberService()
	// .updateCustomeragentIgnoreNull(agent);
	// Vmoneyrecord record = new Vmoneyrecord();
	// record.set
	// record.setAgentid(agent.getId());
	// record.setCreatetime(new Timestamp(System.currentTimeMillis()));
	// record.setCreateuserid(this.getLoginUserId());
	// record.setMemo(memo);
	// record.setType(String.valueOf(type));
	// record.setOrdernumber(ordernumber);
	// record.setMoney(money);
	// Server.getInstance().getMemberService().createVmoneyrecord(record);
	// } catch (Exception e) {
	//
	// }
	//
	// }

	public String ChangeDateMode(String dateStr) {
		// 2009-03-19
		String newmon = "";
		System.out.println(dateStr);
		String daystr = dateStr.substring(8, 10);
		// String yearstr = dateStr.substring(2, 3);
		String monstr = dateStr.substring(5, 7);
		if (monstr.equals("01")) {
			newmon = "JAN";
		} else if (monstr.equals("02")) {
			newmon = "FEB";
		} else if (monstr.equals("03")) {
			newmon = "MAR";
		} else if (monstr.equals("04")) {
			newmon = "APR";
		} else if (monstr.equals("05")) {
			newmon = "MAY";
		} else if (monstr.equals("06")) {
			newmon = "JUN";
		} else if (monstr.equals("07")) {
			newmon = "JUL";
		} else if (monstr.equals("08")) {
			newmon = "AUG";
		} else if (monstr.equals("09")) {
			newmon = "SEP";
		} else if (monstr.equals("10")) {
			newmon = "OCT";
		} else if (monstr.equals("11")) {
			newmon = "NOV";
		} else if (monstr.equals("12")) {
			newmon = "DEC";
		}
		return daystr + newmon;
	}

	/**
	 * 将float格式化支持4伟小数
	 * 
	 * @param money
	 * @return
	 */
	public String formatFloat(Float num) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.0000");
		try {
			String result = format.format(num);
			return result;
		} catch (Exception e) {
			return Float.toString(num);
		}
	}

	/**
	 * 将float格式化支持2伟小数
	 * 
	 * @param money
	 * @return
	 */
	public String formatFloatZrate(Float num) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.00");
		try {
			String result = format.format(num);
			return result;
		} catch (Exception e) {
			return Float.toString(num);
		}
	}

	/**
	 * 将float格式化支持2伟小数
	 * 
	 * @param money
	 * @return
	 */
	public String formatPaymoney(Double num) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.00");
		try {
			String result = format.format(num);
			return result;
		} catch (Exception e) {
			return Double.toString(num);
		}
	}

	/**
	 * 将float格式化支持2伟小数
	 * 
	 * @param money
	 * @return
	 */
	public String formatPaymoneyNew(Double num) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.00");
		try {
			String result = format.format(num);
			return result;
		} catch (Exception e) {
			return Double.toString(num);
		}
	}

	/**
	 * 写操作日志
	 * 
	 * @param user
	 * @param request
	 * @param method
	 * @param action
	 * @param desc
	 */
	/*
	 * public void writeLog(Systemuser user, HttpServletRequest request, String
	 * method,String action,String desc) { try{
	 * 
	 * Systemaction systemlog = new Systemaction(); systemlog.setCode(method);
	 * systemlog.setCreatetime(new Timestamp(System.currentTimeMillis()));
	 * 
	 * systemlog.setActionname(action); systemlog.setDescription(desc);
	 * 
	 * try{systemlog.setIp(request.getRemoteAddr());}catch(Exception e){}
	 * try{systemlog.setUsername(user.getUsername());}catch(Exception e){} //
	 * Server.getInstance().getSystemactionManager().createSystemaction(systemlog);
	 * 
	 * }catch (Exception e){ e.printStackTrace(); } }
	 */
	public String getordercode(long id) {

		return Server.getInstance().getAirService().findOrderinfo(id)
				.getOrdernumber();
	}

	public String getpassname(long id) {

		return Server.getInstance().getAirService().findPassenger(id).getName();
	}

	public String getzhifutime(String ordercode) {
		List<Traderecord> list = Server.getInstance().getMemberService()
				.findAllTraderecord(
						" where  1=1 and " + Traderecord.COL_ordercode + " ='"
								+ ordercode + "'", "", -1, 0);
		if (list.size() > 0 && list.get(0).getCreatetime() != null) {
			return list.get(0).getCreatetime().toString();

		} else {

			return "";
		}

	}

	/**
	 * 显示文件
	 * 
	 * @param filePath
	 * @return
	 */
	public String getImgPath(String filePath) {

		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='weppath'", "", -1, 0).get(0))
				.getValue()
				+ filePath;
	}

	public String getagentname_b2bback(long id) {
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(id);
		return this.getagentname(agent);
	}

	public String getagentname(Customeragent agent) {
		String agentname = "";
		if (this.isNotNullOrEpt(agent.getAgentshortname())) {
			agentname = agent.getAgentshortname();
		} else {
			agentname = agent.getAgentcompanyname();
		}
		return agentname;
	}

	public Float getprice(long id) {// 根据乘机人ID取票价

		return Server.getInstance().getAirService().findPassenger(id)
				.getPrice();
	}

	public String getkscity(long id) {

		return "";// Server.getInstance().getAirService().findKweifabu(id).getStartcity();
	}

	public String getkecity(long id) {

		return Server.getInstance().getAirService().findKweifabu(id)
				.getEndcity();
	}

	public Timestamp getkstime(long id) {

		return Server.getInstance().getAirService().findKweifabu(id)
				.getStarttime();
	}

	public String getkca(long id) {

		return Server.getInstance().getAirService().findKweifabu(id).getCa();
	}

	//
	public String getscity(long id) {

		return Server.getInstance().getAirService().findTeamapply(id)
				.getStartcity();
	}

	public String getecity(long id) {

		return Server.getInstance().getAirService().findTeamapply(id)
				.getEndcity();
	}

	public String getca(long id) {

		return Server.getInstance().getAirService().findTeamapply(id).getCa();
	}

	public Timestamp getstime(long id) {

		return Server.getInstance().getAirService().findTeamapply(id)
				.getStarttime();
	}

	// 根据登录名取所属供应商
	public String getangname(long id) {

		Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(id);
		if(agent.getAgentshortname()!=null){
			return agent.getAgentshortname();
		}else{
			return agent.getAgentcompanyname();
		}
		
		/*return Server.getInstance().getMemberService().findCustomeragent(id)
				.getAgentcompanyname();*/
	}

	// 根据登录名取所属供应商级别
	public int getangtjibie(long id) {

		return Server.getInstance().getMemberService().findCustomeragent(id)
				.getAgentjibie();
	}

	// 根据乘机人表ID查找乘机人姓名
	public String getchengjiren(long id) {

		return Server.getInstance().getAirService().findPassenger(id).getName()
				.trim();
	}

	public String getangentname(long id) {// 根据加盟商ID获取加盟商名称

		return Server.getInstance().getMemberService().findCustomeragent(id)
				.getAgentcompanyname();
	}

	public Double getxinyongprice(long id) {// 根据加盟商ID获取加盟商信用额度
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						"where 1=1 and " + Biguser.COL_agentid + " =" + id, "",
						-1, 0);
		if (list.size() > 0) {
			return list.get(0).getCreditprice();
		} else {
			return 0.00;
		}

	}

	public Double getyiyongprice(long id) {// 根据加盟商ID获取加盟商已用额度
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						"where 1=1 and " + Biguser.COL_agentid + " =" + id, "",
						-1, 0);
		if (list.size() > 0) {
			return list.get(0).getYyongprice();
		} else {
			return 0.00;
		}

	}

	public long getcreateuserid(long id) {// 根据加盟商ID获取大客户客户经理
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						"where 1=1 and " + Biguser.COL_agentid + " =" + id, "",
						-1, 0);
		if (list.size() > 0) {
			return list.get(0).getCreateuserid();
		} else {

			return 0;
		}

	}

	/**
	 * 绝对路径
	 * 
	 * @param filePath
	 * @return
	 */
	public String getoaPath(String filePath) {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='oafileuppath'", "", -1, 0)
				.get(0)).getValue()
				+ filePath;
	}

	public String getRealPath(String filePath) {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='uploadpath'", "", -1, 0)
				.get(0)).getValue()
				+ filePath;
	}

	public String getlogoPath() {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='logopath'", "", -1, 0).get(0))
				.getValue();
	}

	public String getlogoShowPath() {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='logoshowpath'", "", -1, 0)
				.get(0)).getValue();
	}

	public long getagentId() {
		return Long.parseLong(((Sysconfig) Server.getInstance()
				.getSystemService().findAllSysconfig("where C_NAME='agentid'",
						"", -1, 0).get(0)).getValue());
	}

	/**
	 * 得到订单的状态
	 */
	public String getInterHotelorderState(Integer state) {
		System.out.println("state==" + state);

		if (state == 1) {
			return "待确认";
		}
		if (state == 2) {
			return "已确认,待支付";
		}
		if (state == 3) {
			return "已支付";
		}
		if (state == 4) {
			return "已入住";
		}
		if (state == 5) {
			return "已离店";
		}
		if (state == 6) {
			return "已取消";
		}
		if (state == 7) {
			return "满房";
		}
		if (state == 8) {
			return "变更";
		}
		if (state == 9) {
			return "No Show";
		}
		if (state == 88) {
			return "问题订单";
		} else {
			return "未知订单";
		}

	}

	/**
	 * 得到订单的状态
	 */
	public String getHotelorderState(Integer state) {
		System.out.println("state==" + state);
		String[] states = new String[] { "待审核", "审核未通过", "待确认", "入住待确认", "满房",
				"入住", "预订未入住", "No Show", "取消", "取消", "取消", "预留房自动确认" };

		if (state == 1) {
			return "待确认";
		}
		if (state == 2) {
			return "已确认";
		}
		if (state == 3) {
			return "已发确认单";
		}
		if (state == 4) {
			return "确认已回传";
		}
		if (state == 5) {
			return "预订完成";
		}
		if (state == 6) {
			return "已取消";
		}
		if (state == 7) {
			return "满房";
		}
		if (state == 8) {
			return "变更";
		}
		if (state == 9) {
			return "入住";
		}
		if (state == 10) {
			return "No Show";
		}
		if (state == 88) {
			return "问题订单";
		} else {
			return "未知订单";
		}

	}

	/**
	 * 得到订单的状态
	 */
	public String getMangGoHotelorderState(String state) {
		System.out.println("state==" + state);
		// 1.前台订单未提交 2.已提交订单 3.已提交中台 4.已入住 5.提前退房
		// 6，,正常退房 7.延住 8.已付款 9.已创建退款单 10.退款单已审批 11.财务已经退款
		// 12.退款成功 13.NOSHOW 14 已取消

		if (state.equals("1")) {
			return "前台订单未提交";
		}

		if (state.equals("2")) {
			return "已提交订单";
		}
		if (state.equals("3")) {
			return "已提交中台";
		}
		if (state.equals("4")) {
			return "已入住";
		}

		if (state.equals("5")) {
			return "提前退房";
		}
		if (state.equals("6")) {
			return "正常退房";
		}
		if (state.equals("7")) {
			return "延住";
		}
		if (state.equals("8")) {
			return "已付款";
		}
		if (state.equals("9")) {
			return "已创建退款单";
		}
		if (state.equals("10")) {
			return "退款单已审批";
		}

		if (state.equals("11")) {
			return "财务已经退款";
		}

		if (state.equals("12")) {
			return "退款成功";
		}

		if (state.equals("13")) {
			return "NOSHOW ";
		}

		if (state.equals("14")) {
			return "取消";
		} else {

			return "未知";
		}

	}

	/**
	 * 获取当前时间传入0 昨天-1 明天1
	 * 
	 * @param date
	 * @return
	 */
	public String getDatestr(int date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DAY_OF_MONTH, date);
		System.out.println(cd.toString());
		return sdf.format(cd.getTime()).toString();
	}

	public String getdate(String da, int a) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date cd = new Date();
		try {
			cd = sdf.parse(da);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(cd);

		c.add(Calendar.DAY_OF_MONTH, a);
		return new SimpleDateFormat("MM-dd").format(new Date(c
				.getTimeInMillis()));

	}

	public String getStarico(Integer index) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < index / 2; i++) {
			buffer.append("<img src=\"images/shixing.gif\" />");
		}
		if (index % 2 == 0) {
			buffer.append("<img src=\"images/kongxing.gif\" />");
		} else {
			buffer.append("<img src=\"images/shixing.gif\" />");
		}
		return buffer.toString();
	}

	/**
	 * 通过时间获取星期几
	 * 
	 * @param time
	 * @return
	 */
	public String getWeekStr(String time) {
		String strReturn = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int weekday = cal.get(cal.DAY_OF_WEEK);

		if (weekday == 1) {
			strReturn = "星期日";
		} else if (weekday == 2) {
			strReturn = "星期一";
		} else if (weekday == 3) {
			strReturn = "星期二";
		} else if (weekday == 4) {
			strReturn = "星期三";
		} else if (weekday == 5) {
			strReturn = "星期四";
		} else if (weekday == 6) {
			strReturn = "星期五";
		} else if (weekday == 7) {
			strReturn = "星期六";
		}
		return strReturn;
	}

	/**
	 * 获取指定时间的后几天
	 * 
	 * @param time
	 *            指定时间
	 * @param intDay
	 *            指定时间的后几天天数
	 * @return
	 */
	public boolean companyDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String strReturn = "";
		try {
			date = sdf.parse(time);
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			if (Calendar.getInstance().before(cd)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取指定时间的后几天
	 * 
	 * @param time
	 *            指定时间
	 * @param intDay
	 *            指定时间的后几天天数
	 * @return
	 */
	public String GetDate2(String time, int intDay) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		Date date;
		String strReturn = "";
		try {
			date = sdf.parse(time);
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.DATE, intDay);// 增加一天
			date = cd.getTime();
			strReturn = sdf.format(date).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strReturn;
	}
	/**
	 * 获取指定时间的后几天
	 * 
	 * @param time
	 *            指定时间
	 * @param intDay
	 *            指定时间的后几天天数
	 * @return
	 */
	public String GetDate(String time, int intDay) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String strReturn = "";
		try {
			date = sdf.parse(time);
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.DATE, intDay);// 增加一天
			date = cd.getTime();
			strReturn = sdf.format(date).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strReturn;
	}

	// 根据ID取供应商的报价list
	// private List < Supteam > listSupteam;
	private List<Supteam> listSupteam = new ArrayList<Supteam>();

	public List<Supteam> getListsup(long id) {
		listSupteam.clear();
		List<Supteam> cs = Server.getInstance().getAirService().findAllSupteam(
				" where " + Supteam.COL_teamid + "=" + id,
				"order by " + Supteam.COL_id + " desc ", -1, 0);
		for (Supteam c : cs) {
			listSupteam.add(c);
		}

		return listSupteam;
	}

	/**
	 * 根据机场代码获取城市名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getAirportbySZM(String airport) {
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		
		
		
		return list != null && list.size() > 0 ? list.get(0).getAirportname()
				: "";

	}

	/*
	 * 
	 */
	public void insetIntegral(long yewutype, long orderid) throws SQLException {
		Customeragent customeragent = new Customeragent();
		Customeruser customeruser = new Customeruser();

		Customerintegralrecord customerintegralrecord = new Customerintegralrecord();

		int backorder = 1;// 前台或者后台预订得积分体系
		String price = "";// 订单总价
		Float xishu = 1f;// 积分系数
		List<Integral> listIntegral = Server.getInstance().getMemberService()
				.findAllIntegral(
						" where 1=1 and " + Integral.COL_agenttype + " =5", "",
						-1, 0);// 取出用户计别得

		if (yewutype == 1) {// 机票

		}
		if (yewutype == 2) {// 酒店

			Hotelorder hotelorder = Server.getInstance().getHotelService()
					.findHotelorder(orderid);
			customeruser = Server.getInstance().getMemberService()
					.findCustomeruser(hotelorder.getMemberid());
			customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
			List<Integral> list = Server.getInstance().getMemberService()
					.findAllIntegral(
							" where 1=1 and " + Integral.COL_agenttype + " ="
									+ customeragent.getAgentjibie(), "", -1, 0);

			xishu = list.get(0).getHotelcoeft();

			price = hotelorder.getPrice();
			if (hotelorder.getType() == 1) {// 后台预订

				backorder = listIntegral.get(0).getBackorderscore();
			} else {// 网站预订

				backorder = listIntegral.get(0).getWeborderscore();
			}

			customerintegralrecord.setRefordernumber(hotelorder.getOrderid());

		}
		customerintegralrecord.setCreatetime(new Timestamp(System
				.currentTimeMillis()));
		customerintegralrecord.setRefuid(customeruser.getId());
		customerintegralrecord.setScore(Integer.parseInt(Float
				.parseFloat(price)
				* xishu * backorder + ""));
		Float pr = Float.parseFloat(price) * xishu * backorder;

		Server.getInstance().getMemberService().createCustomerintegralrecord(
				customerintegralrecord);
		if (customeruser.getTotalscore() == null) {

			customeruser.setTotalscore(0);
		}
		customeruser.setTotalscore(customeruser.getTotalscore()
				+ customerintegralrecord.getScore());
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);

	}

	/**
	 * 根据机场代码获取城市名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getAirnamebySZM(String airport) {
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getCityname() : "";

	}

	/**
	 * 根据部门id获取部门名称名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getDeptNameByID(String ID) {
		String where = "where " + Department.COL_id + "='" + ID + "'";
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getName() : "";

	}

	/**
	 * 根据航空公司代码取得航空公司
	 * 
	 * @param airport
	 * @return
	 */
	public String getAircomapnycodeByEZM(String companycode) {
		String where = "where " + Aircompany.COL_aircomcode + "='"
				+ companycode + "'";
		List<Aircompany> list = Server.getInstance().getAirService()
				.findAllAircompany(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getAircomjname()
				: "";

	}

	/**
	 * 根据航空公司取得航空公司代码
	 * 
	 * @param airport
	 * @return
	 */
	public List<String> getAircomapnyCodeByName(String companyname) {
		String where = "where " + Aircompany.COL_aircomcnname + " LIKE '%"
				+ companyname + "%' OR " + Aircompany.COL_aircomjname
				+ " LIKE '%" + companyname + "%'";
		List<Aircompany> list = Server.getInstance().getAirService()
				.findAllAircompany(where, "ORDER BY ID", -1, 0);
		List<String> codelist = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (Aircompany company : list) {
				codelist.add(company.getAircomcode());
			}
		}
		return codelist;

	}

	public String getAgentname22(long id) {
		return Server.getInstance().getMemberService().findCustomeragent(id)
				.getAgentcompanyname();

	}

	public String getusername(long id) {
		if (id > 0) {
			Customeruser user = Server.getInstance().getMemberService()
					.findCustomeruser(id);
			if (user != null)
				if(user.getMembername()!=null){
					return user.getMembername();
				}else{
					
					return user.getLoginname();
				}
				
			}
		return "";

	}

	public Customeruser getCustomeruser(long id) {
		Customeruser user = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		if (user != null)
			return user;
		return new Customeruser();

	}

	public long getangenid(long id) {// 取分销商ID
		return Server.getInstance().getAirService().findOrderinfo(id)
				.getBuyagentid();

	}

	public long getuserid(long id) {// 取会员ID
		return Server.getInstance().getAirService().findOrderinfo(id)
				.getCustomeruserid();

	}

	public String getrolename(String roleid) {
		StringBuffer roname = new StringBuffer();
		if (roleid.indexOf(",") > 0) {

			String[] role = roleid.split(",");
			if (role.toString().trim().length() > 0) {
				for (int a = 0; a < role.length; a++) {

					long rid = Long.parseLong(role[a]);
					String name = Server.getInstance().getMemberService()
							.findSystemrole(rid).getName();
					roname.append(name + ",");

				}

			}

		}
		return roname.toString();// 根据角色ID取名称
	}

	/**
	 * 取报价
	 * 
	 * @param airport
	 * @return
	 */
	public String getbaojia(long id) {
		List<Supteam> listSupteam = Server.getInstance().getAirService()
				.findAllSupteam(
						"where 1=1 and " + Supteam.COL_supplierid + " ="
								+ getLoginUser().getAgentid() + " and "
								+ Supteam.COL_teamid + " =" + id, "", -1, 0);
		if (listSupteam.size() != 0) {
			return listSupteam.get(0).getOffer();
		} else {
			return "";
		}

	}

	public String ChangeDateModeToInt(String dateStr) {
		// 2009-03-19
		String newmon = "";
		String monstr = dateStr;
		if (monstr.equals("JAN")) {
			newmon = "01";
		} else if (monstr.equals("FEB")) {
			newmon = "02";
		} else if (monstr.equals("MAR")) {
			newmon = "03";
		} else if (monstr.equals("APR")) {
			newmon = "04";
		} else if (monstr.equals("MAY")) {
			newmon = "05";
		} else if (monstr.equals("JUN")) {
			newmon = "06";
		} else if (monstr.equals("JUL")) {
			newmon = "07";
		} else if (monstr.equals("AUG")) {
			newmon = "08";
		} else if (monstr.equals("SEP")) {
			newmon = "09";
		} else if (monstr.equals("OCT")) {
			newmon = "10";
		} else if (monstr.equals("NOV")) {
			newmon = "11";
		} else if (monstr.equals("DEC")) {
			newmon = "12";
		}
		return newmon;
	}

	public String getorderRelation(long id) {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(id);
		if (orderinfo != null) {
			if (orderinfo.getRelationorderid() != null) {
				Double pricesum = 0d;
				Orderinfo orderinfo2 = Server.getInstance().getAirService()
						.findOrderinfo(orderinfo.getRelationorderid());
				if (orderinfo2.getTotalticketprice() != null
						&& orderinfo2.getTotalticketprice() > 0) {
					pricesum += orderinfo2.getTotalticketprice();
				}
				if (orderinfo2.getTotalfuelfee() != null) {
					pricesum += orderinfo2.getTotalfuelfee();
				}
				if (orderinfo2.getTotalairportfee() != null) {
					pricesum += orderinfo2.getTotalairportfee();
				}
				if (orderinfo2.getPostmoney() != null) {
					pricesum += orderinfo2.getPostmoney();
				}

				String str = "";
				DecimalFormat format = null;
				format = (DecimalFormat) NumberFormat.getInstance();
				format.applyPattern("###0.00");
				try {
					str = format.format(pricesum);
				} catch (Exception e) {
					str = Double.toString(pricesum);
				}
				return "<span style=\"color:red;\" >  您的多程订单同时会支付，订单号："
						+ orderinfo2.getOrdernumber() + " 金额是：" + str
						+ "</span>";
			}
		}
		return "";
	}

	/**
	 * 通过订单ID获取订单总金额
	 * 
	 * @param id
	 * @return
	 */
	public String getorderpricesum(long id) {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(id);
		if (orderinfo != null) {
			Double pricesum = 0d;
			if (orderinfo.getTotalticketprice() != null
					&& orderinfo.getTotalticketprice() > 0) {
				pricesum += orderinfo.getTotalticketprice();
			}
			if (orderinfo.getTotalfuelfee() != null) {
				pricesum += orderinfo.getTotalfuelfee();
			}
			if (orderinfo.getTotalairportfee() != null) {
				pricesum += orderinfo.getTotalairportfee();
			}
			if (orderinfo.getPostmoney() != null) {
				pricesum += orderinfo.getPostmoney();
			}
			if (orderinfo.getRelationorderid() != null) {
				Orderinfo orderinfo2 = Server.getInstance().getAirService()
						.findOrderinfo(orderinfo.getRelationorderid());
				if (orderinfo2.getTotalticketprice() != null
						&& orderinfo2.getTotalticketprice() > 0) {
					pricesum += orderinfo2.getTotalticketprice();
				}
				if (orderinfo2.getTotalfuelfee() != null) {
					pricesum += orderinfo2.getTotalfuelfee();
				}
				if (orderinfo2.getTotalairportfee() != null) {
					pricesum += orderinfo2.getTotalairportfee();
				}
				if (orderinfo2.getPostmoney() != null) {
					pricesum += orderinfo2.getPostmoney();
				}
			}
			DecimalFormat format = null;
			format = (DecimalFormat) NumberFormat.getInstance();
			format.applyPattern("###0.00");
			try {
				String result = format.format(pricesum);
				return result;
			} catch (Exception e) {
				return Double.toString(pricesum);
			}
		}
		return "";
	}

	// 乘机人票状态 乘机人票状态 0=未出票 1=已出票 2=已废票
	// 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=废票失败9=改签成功10=改签失败11=已取消12=已分离

	public String getpassstate(Integer id) {// 乘机人状态
		switch (id) {

		case 0:

			return "未出票";
		case 1:

			return "已出票";

		case 2:

			return "已废票未退款";

		case 3:

			return "已退票未退款";
		case 4:

			return "申请退票";

		case 5:

			return "申请废票";

		case 6:

			return "申请改签";

		case 7:

			return "退票失败";

		case 8:

			return "废票失败";

		case 9:

			return "改签成功";

		case 10:

			return "改签失败";

		case 11:

			return "已取消订单";

		case 12:

			return "已分离";

			// /乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=

			// /废票失败9=改签成功10=改签失败11=已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失,16,废票退款成功,17,退票退款成功

			// 败
		case 13:
			return "申请升舱换开";
		case 14:
			return "升舱换开成功";
		case 15:
			return "升舱换开失败";
		case 16:
			return "废票退款成功";
		case 17:
			return "退票退款成功";
		case 19:
			return "拒单-等待退款";
		case 20:
			return "拒单-已经退款";
			
		default:
			return "";
		}
	}

	public String getfenruntype(Integer id) {// 分润类型
		switch (id) {

		case 1:

			return "按千分比";

		case 2:

			return "按票数";

		case 3:

			return "不分润";

		default:
			return "";
		}

	}

	public String getjibie(Integer id) {// 取阁下级别
		switch (id) {

		case 1:

			return "司局级";

		case 2:

			return "行政主任/行政总监";

		case 3:

			return "部门经理";

		case 4:

			return "行政人员";

		case 5:

			return "总经理/副总裁";

		case 6:

			return "部长";

		case 7:

			return "其他";

		case 8:

			return "企业拥有者/私人业主/合作经营者";

		case 9:

			return "总监/总裁";

		case 10:

			return "地区/分区经理";

		case 11:

			return "职员";

		case 12:

			return "学生";

		default:
			return "";
		}

	}

	public String getchenghu(Integer id) {// 取称呼
		switch (id) {

		case 1:

			return "先生";

		case 2:

			return "太太";

		case 3:

			return "小姐";

		case 4:

			return "女士";

		default:
			return "";
		}

	}

	public String getCarOrderByState(String state) {// 取称呼
		String strStateName = "";
		if (state.equals("1")) {
			strStateName = "新订单,待确认";
		} else if (state.equals("2")) {

			strStateName = "已确认";
		} else if (state.equals("3")) {

			strStateName = "已取车";
		} else if (state.equals("4")) {

			strStateName = "已还车,交易结束";
		} else if (state.equals("5")) {

			strStateName = "已取消";

		} else if (state.equals("6")) {

			strStateName = "已过期";
		} else {

			strStateName = "未知";
		}

		return strStateName;
	}

	// 根据国家ID取国家名称
	public String getguojianame(long id) {
		return Server.getInstance().getAirService().findFcountry(id)
				.getCountryname();

	}

	/**
	 * 取得两个天数差
	 * 
	 * @param time
	 * @param intDay
	 * @return
	 */
	public int Calculate(String date) {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.HOUR_OF_DAY, 0); // 小时取0
		ca.set(Calendar.MINUTE, 0); // 分取0
		ca.set(Calendar.SECOND, 0); // 秒取0
		ca.set(Calendar.MILLISECOND, 0); // 毫秒取0
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = null;
		try {
			time = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			time = new Date();
			e.printStackTrace();
		}
		long c = time.getTime() - ca.getTime().getTime();
		return (int) (c / 1000 / 60 / 60 / 24);
	}

	public String getUrl() {
		return "pageinfo.pagenum=" + pageinfo.getPagenum()
				+ "&pageinfo.pagerow=" + pageinfo.getPagerow();
	}

	public void setUrl(String url) {

		this.url = this.getGBKString(url);
	}

	public List<Supteam> getListSupteam() {
		return listSupteam;
	}

	public void setListSupteam(List<Supteam> listSupteam) {
		this.listSupteam = listSupteam;
	}

	public boolean isAdmin() {
		String sql = " SELECT * FROM [T_AGENTROLEREF] WHERE C_CUSTOMERUSERID="
				+ this.getLoginUser().getId();
		List<Agentroleref> roles = Server.getInstance().getMemberService()
				.findAllAgentrolerefBySql(sql, -1, 0);
		if (roles != null && roles.size() > 0) {
			for (Agentroleref role : roles) {
				System.out.println(role.getId());
				if (role.getRoleid() == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public PageInfo getPageother() {
		return pageother;
	}

	public void setPageother(PageInfo pageother) {
		this.pageother = pageother;
	}

	public PageInfo getPagezafei() {
		return pagezafei;
	}

	public void setPagezafei(PageInfo pagezafei) {
		this.pagezafei = pagezafei;
	}

	public void setDeptstr(StringBuffer deptstr) {
		this.deptstr = deptstr;
	}

	/**
	 * 导出报表
	 * 
	 * @param sheet
	 *            WritableSheet
	 * @param tile
	 *            head title ，example 'XXXXX报表'
	 * @param line
	 *            从第几行开始
	 * @param titlels
	 *            titles即th
	 * @param valuelist
	 *            内容 Map<Integer, List<Object>> valuelist 例如<0,list<>>
	 * @return
	 * @throws Exception
	 */
	public int reportExpExcel(WritableSheet sheet, String tile, int line,
			String[] titlels, Map<Integer, List<Object>> valuelist)
			throws Exception {
		if (line == 0)
			line = 1;
		sheet.mergeCells(0, 0, titlels.length, 0);// //合并单元格，参数格式（开始列，开始行，结束列，结束行）
		WritableFont font = new WritableFont(WritableFont.TIMES, 16,
				WritableFont.BOLD);
		WritableCellFormat format = new WritableCellFormat(font);
		format.setAlignment(jxl.format.Alignment.CENTRE);
		// sheet.mergeCells(0, 1, titlels.length-1, 1);
		Label toubu = new Label(0, 0, tile, format);
		sheet.addCell(toubu);
		int i = 0;
		for (String title : titlels) {
			Label label = new Label(i, line, title);
			sheet.addCell(label);
			i++;
		}
		int j = line;
		int key = 0;
		for (; key < valuelist.size(); key++) {
			List values = valuelist.get(key);
			int k = 0;
			for (Object obj : values) {
				String str = String.valueOf(obj);
				Label l = new Label(k, j + 1, str);
				sheet.addCell(l);
				k++;
			}
			j++;
		}
		return j;
	}

	/**
	 * 为报表添加查询条件
	 * 
	 * @param sheet
	 *            WritableSheet
	 * @param line
	 *            从第几行开始
	 * @param options
	 *            ,Map<tname,tvalue> 例如：<姓名,username>
	 * @param length
	 *            到第几列时结束
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public int addExcelOptions(WritableSheet sheet, int line,
			Map<String, String> options, int length)
			throws RowsExceededException, WriteException {

		if (line == 0)
			line = 1;
		Label cxtj = new Label(0, ++line, "查询条件：");
		sheet.addCell(cxtj);
		++line;
		int i = 1;
		int j = 0;
		Iterator<Entry<String, String>> iterator = options.entrySet()
				.iterator();
		WritableFont font = new WritableFont(WritableFont.TIMES, 11,
				WritableFont.BOLD);
		WritableCellFormat format = new WritableCellFormat(font);
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			String tname = entry.getKey();
			String tvalue = entry.getValue();
			if (isNotNullOrEpt(tvalue)) {
				Label label0 = new Label(++j, line, tname + "：", format);
				Label label1 = new Label(++j, line, tvalue);
				sheet.addCell(label0);
				sheet.addCell(label1);
				if (i % length == 0) {
					++line;
					j = 0;
				}
				i += 3;
			}
		}

		return line + 1;
	}

	/**
	 * @param str
	 * @return 是否为null或""
	 */
	public boolean isNotNullOrEpt(String str) {
		if (str != null && str.trim().trim().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据时间参数的有无返回不同时间检索条件 韩 例如 filename between '2011-01-01' and ''
	 * 
	 * @param s_begintime
	 * @param s_endtime
	 * @param filename
	 * @return
	 */
	public String getCheckTime(String s_begintime, String s_endtime,
			String filename) {

		String timewhere = "";
		if (s_begintime != null && s_begintime.trim().length() > 0
				&& s_begintime.length() < 19) {
			s_begintime = s_begintime + " 00:00:00";
		}
		if (s_endtime != null && s_endtime.trim().length() > 0
				&& s_endtime.length() < 19) {
			s_endtime = s_endtime + " 23:59:59";
		}
		if (s_begintime != null && s_begintime.trim().length() > 0
				&& s_endtime.trim().length() > 0) {
			timewhere += filename + " BETWEEN '" + s_begintime + "'  AND '"
					+ s_endtime + "' ";
		} else if (s_begintime != null && s_begintime.trim().length() > 0) {
			timewhere += filename + " >= '" + s_begintime + "'";
		} else if (s_endtime != null && s_endtime.trim().length() > 0) {
			timewhere += filename + " <= '" + s_endtime + "'";
		}

		return timewhere;

	}
	public String getSPCheckTime(String s_begintime, String s_endtime,
			String filename) {
		
		String timewhere = "";
		if (s_begintime != null && s_begintime.trim().length() > 0
				&& s_begintime.length() < 19) {
			s_begintime = s_begintime + " 00:00:00";
		}
		if (s_endtime != null && s_endtime.trim().length() > 0
				&& s_endtime.length() < 19) {
			s_endtime = s_endtime + " 23:59:59";
		}
		if (s_begintime != null && s_begintime.trim().length() > 0
				&& s_endtime.trim().length() > 0) {
			timewhere += filename + " BETWEEN ''" + s_begintime + "''  AND ''"
			+ s_endtime + "'' ";
		} else if (s_begintime != null && s_begintime.trim().length() > 0) {
			timewhere += filename + " >= ''" + s_begintime + "''";
		} else if (s_endtime != null && s_endtime.trim().length() > 0) {
			timewhere += filename + " <= ''" + s_endtime + "''";
		}
		
		return timewhere;
		
	}

	public boolean sendTXTSmstoLinkuser(String[] mobiles,
			List<Passenger> passengers, List<Segmentinfo> listseg) {
		DateFormat dateformat = new SimpleDateFormat("MM-dd");
		DateFormat datetimeformat = new SimpleDateFormat("MM-dd HH:mm");
		// AOrderInform
		int state = 0;
		try {
			String smstemple = this.getSMSTemple("TISSUEMSG");
			Passenger firstpassenger = passengers.get(0);
			String passengernames = firstpassenger.getName()
					+ firstpassenger.getIdnumber();
			float totalticketprice = converNull(firstpassenger.getPrice(), 0f);
			float duty = converNull(firstpassenger.getAirportfee(), 0f)
					+ converNull(firstpassenger.getFuelprice(), 0f)
					+ converNull(firstpassenger.getAnjianfee(), 0f)
					+ converNull(firstpassenger.getOtherfee(), 0f);
			for (int i = 1; i < passengers.size(); i++) {
				Passenger passenger = passengers.get(i);
				totalticketprice += converNull(passenger.getPrice(), 0f);
				duty += converNull(passenger.getAirportfee(), 0f)
						+ converNull(passenger.getFuelprice(), 0f)
						+ converNull(passenger.getAnjianfee(), 0f)
						+ converNull(passenger.getOtherfee(), 0f);
				if (i == 1) {
					passengernames += "," + passenger.getName()
							+ passenger.getIdnumber();
				}

				if (i == 1 && passengers.size() > 2) {
					passengernames += "等" + passengers.size() + "人.";
				}
			}
			smstemple = smstemple.replace("@passenger@", passengernames);
			String flightinfoold = smstemple.substring(smstemple.indexOf("#"),
					smstemple.lastIndexOf("#") + 1);
			String flightinfonew = smstemple.substring(
					smstemple.indexOf("#") + 1, smstemple.lastIndexOf("#") - 1);
			String flight = flightinfonew;
			StringBuffer flightinfo = new StringBuffer("");
			System.out.println(flightinfonew);
			for (int i = 0; i < listseg.size(); i++) {
				Segmentinfo segmentinfo = listseg.get(i);
				flightinfonew = flightinfonew.replace("@flightdate@",
						dateformat.format(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@flightvoyage@", this
						.getCitynameByAirport(segmentinfo.getStartairport())
						+ "-"
						+ this
								.getCitynameByAirport(segmentinfo
										.getEndairport()));
				flightinfonew = flightinfonew.replace("@aircompanyname@",
						this.getAircomapnycodeByEZM(segmentinfo
								.getAircomapnycode()));
				flightinfonew = flightinfonew.replace("@flightnumber@",
						segmentinfo.getFlightnumber());
				flightinfonew = flightinfonew.replace("@flighttime@", this
						.formatTimestampHHmm(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@startcity@", this
						.getCitynameByAirport(segmentinfo.getStartairport()));
				flightinfonew = flightinfonew.replace("@borderpointat@",
						converNull(segmentinfo.getBorderpointat(), ""));
				flightinfonew = flightinfonew.replace("@arrivaltime@",
						datetimeformat.format(segmentinfo.getArrivaltime()));
				flightinfonew = flightinfonew.replace("@arrivalcity@", this
						.getCitynameByAirport(segmentinfo.getEndairport()));
				flightinfonew = flightinfonew.replace("@offpointat@",
						converNull(segmentinfo.getOffpointat(), ""));
				flightinfo.append(flightinfonew);
				if (i == 1) {
					break;
				}
				flightinfonew = flight;

			}
			if (listseg.size() > 2) {
				flightinfo.append("以及其它航段。");
			}

			smstemple = smstemple.replace(flightinfoold, flightinfo.toString());
			smstemple = smstemple.replace("@ticketprice@", String
					.valueOf(totalticketprice));
			smstemple = smstemple.replace("@duty@", String.valueOf(duty));
			System.out.println(smstemple);

			String orderid = "";
			if (passengers.size() > 0) {
				orderid = String.valueOf(passengers.get(0).getOrderid());
			}
			state = Server.getInstance().getAtomService().sendSms(mobiles,
					smstemple, orderid, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (state == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sendTXTSmstoConfirm(String[] mobiles,
			List<Passenger> passengers, List<Segmentinfo> listseg) {
		DateFormat dateformat = new SimpleDateFormat("MM-dd");
		DateFormat datetimeformat = new SimpleDateFormat("MM-dd HH:mm");
		// AOrderInform
		int state = 0;
		try {
			String smstemple = this.getSMSTemple("CONFIRMMSG");
			Passenger firstpassenger = passengers.get(0);
			String passengernames = firstpassenger.getName()
					+ firstpassenger.getIdnumber();
			float totalticketprice = converNull(firstpassenger.getPrice(), 0f);
			float duty = converNull(firstpassenger.getAirportfee(), 0f)
					+ converNull(firstpassenger.getFuelprice(), 0f)
					+ converNull(firstpassenger.getAnjianfee(), 0f)
					+ converNull(firstpassenger.getOtherfee(), 0f);
			for (int i = 1; i < passengers.size(); i++) {
				Passenger passenger = passengers.get(i);
				totalticketprice += converNull(passenger.getPrice(), 0f);
				duty += converNull(passenger.getAirportfee(), 0f)
						+ converNull(passenger.getFuelprice(), 0f)
						+ converNull(passenger.getAnjianfee(), 0f)
						+ converNull(passenger.getOtherfee(), 0f);
				if (i == 1) {
					passengernames += "," + passenger.getName()
							+ passenger.getIdnumber();
				}

				if (i == 1 && passengers.size() > 2) {
					passengernames += "等" + passengers.size() + "人.";
				}
			}
			smstemple = smstemple.replace("@passenger@", passengernames);
			String flightinfoold = smstemple.substring(smstemple.indexOf("#"),
					smstemple.lastIndexOf("#") + 1);
			String flightinfonew = smstemple.substring(
					smstemple.indexOf("#") + 1, smstemple.lastIndexOf("#") - 1);
			String flight = flightinfonew;
			StringBuffer flightinfo = new StringBuffer("");
			System.out.println(flightinfonew);
			for (int i = 0; i < listseg.size(); i++) {
				Segmentinfo segmentinfo = listseg.get(i);
				flightinfonew = flightinfonew.replace("@flightdate@",
						dateformat.format(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@flightvoyage@", this
						.getCitynameByAirport(segmentinfo.getStartairport())
						+ "-"
						+ this
								.getCitynameByAirport(segmentinfo
										.getEndairport()));
				flightinfonew = flightinfonew.replace("@aircompanyname@",
						this.getAircomapnycodeByEZM(segmentinfo
								.getAircomapnycode()));
				flightinfonew = flightinfonew.replace("@flightnumber@",
						segmentinfo.getFlightnumber());
				flightinfonew = flightinfonew.replace("@flighttime@", this
						.formatTimestampHHmm(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@startcity@", this
						.getCitynameByAirport(segmentinfo.getStartairport()));
				flightinfonew = flightinfonew.replace("@borderpointat@",
						converNull(segmentinfo.getBorderpointat(), ""));
				flightinfonew = flightinfonew.replace("@arrivaltime@",
						datetimeformat.format(segmentinfo.getArrivaltime()));
				flightinfonew = flightinfonew.replace("@arrivalcity@", this
						.getCitynameByAirport(segmentinfo.getEndairport()));
				flightinfonew = flightinfonew.replace("@offpointat@",
						converNull(segmentinfo.getOffpointat(), ""));
				flightinfo.append(flightinfonew);
				if (i == 1) {
					break;
				}
				flightinfonew = flight;

			}
			if (listseg.size() > 2) {
				flightinfo.append("以及其它航段。");
			}

			smstemple = smstemple.replace(flightinfoold, flightinfo.toString());
			smstemple = smstemple.replace("@ticketprice@", String
					.valueOf(totalticketprice));
			smstemple = smstemple.replace("@duty@", String.valueOf(duty));
			System.out.println(smstemple);

			String orderid = "";
			if (passengers.size() > 0) {
				orderid = String.valueOf(passengers.get(0).getOrderid());
			}
			state = Server.getInstance().getAtomService().sendSms(mobiles,
					smstemple, orderid, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (state == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 发送国际机票确认短信
	 */
	public boolean sendInterConfirmSms(String[] mobiles, long orderid) {
		DateFormat dateformat = new SimpleDateFormat("MM-dd");
		DateFormat datetimeformat = new SimpleDateFormat("MM-dd HH:mm");
		// AOrderInform
		int state = 0;
		try {
			String smstemple = this.getSMSTemple("InterOrderConfirm");
			List<Segmentinfo> listsegment = Server.getInstance()
					.getAirService().findAllSegmentinfo(
							"where " + Segmentinfo.COL_orderid + "=" + orderid,
							"", -1, 0);
			String strSegmentDeail = "";
			// 订单号
			String strOrderNumber = "";
			// PNR编码
			String strPNR = "";
			// 总票价
			String strTotalTicketPrice = "";
			// 总税费
			String strTotalTax = "";
			// 总费用
			String strTotalPrice = "";
			for (Segmentinfo segment : listsegment) {
				strSegmentDeail += getCitynameByAirport(segment
						.getStartairport())
						+ "-"
						+ getCitynameByAirport(segment.getEndairport())
						+ ",";
			}

			Orderinfo orderinfo = Server.getInstance().getAirService()
					.findOrderinfo(orderid);

			smstemple = smstemple.replace("@SegmentDeails@", strSegmentDeail);
			smstemple = smstemple.replace("@OrderId@", orderinfo
					.getOrdernumber());
			smstemple = smstemple.replace("@PNRCode@", orderinfo.getPnr());
			smstemple = smstemple.replace("@TotalTicketPrice@", String
					.valueOf(orderinfo.getTotalticketprice()));
			smstemple = smstemple.replace("@TotalTax@", String
					.valueOf(orderinfo.getTotalfuelfee()));
			smstemple = smstemple.replace("@TotalPrice@", String
					.valueOf(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalfuelfee()));
			System.out.println(smstemple);

			state = Server.getInstance().getAtomService().sendSms(mobiles,
					smstemple, orderinfo.getOrdernumber(),
					getLoginUser().getId() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (state == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sendTXTSmstoPassenger2(List<Passenger> listpassenger,
			List<Segmentinfo> listseg) {
		System.out.println(listseg.size());
		
		Segmentinfo segmentinfo=listseg.get(0);
		int state = 0;
		DateFormat dateformat = new SimpleDateFormat("MM-dd");
		DateFormat datetimeformat = new SimpleDateFormat("MM-dd HH:mm");
		DateFormat datetimeformatHHMM = new SimpleDateFormat("HH:mm");
		try {
			String airtime=dateformat.format(segmentinfo.getDeparttime());//出发日期
			String hangcheng=getCitynameByAirport(segmentinfo.getStartairport())+segmentinfo.getBorderpointat()+"-"+getCitynameByAirport(segmentinfo.getEndairport())+segmentinfo.getOffpointat()+"";//行程
			String airname=getAircomapnycodeByEZM(segmentinfo
					.getAircomapnycode());//航空公司
			String airnum=segmentinfo.getFlightnumber();//航班号
			String stime=datetimeformatHHMM.format(segmentinfo.getDeparttime());//起飞时间
			String endtime=datetimeformatHHMM.format(segmentinfo.getArrivaltime());//到达时间
			
			String passengername = "";
			int size=listpassenger.size();
			for(int a=0;a<listpassenger.size();a++){
				passengername += listpassenger.get(a).getName();
				if((a+1)!=size){
					passengername+=";";
				}
				
			}
			
			
		/*	smstemple = smstemple.replace("@ticketprice@", String
					.valueOf(passenger.getPrice()));
			smstemple = smstemple.replace("@duty@", String.valueOf(converNull(
					passenger.getFuelprice(), 0f)
					+ converNull(passenger.getAirportfee(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)));*/
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(listpassenger.get(0).getOrderid());
			
			String content=passengername+"/"+airtime.replace("-", "月")+"日"+"/"+airname+airnum+"/"+hangcheng+"/"+stime+"起飞-"+endtime+"到达/已出票!";//一票联盟
			
			state = Server
					.getInstance()
					.getAtomService()
					.sendSms(
							new String[] { converNull(orderinfo.getContactmobile(), "")
									.trim() }, content,
							String.valueOf(listpassenger.get(0).getOrderid()),"2");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if (state == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean sendTXTSmstoPassenger(List<Passenger> listpassenger,
			List<Segmentinfo> listseg) {
		int state = 0;
		DateFormat dateformat = new SimpleDateFormat("MM-dd");
		DateFormat datetimeformat = new SimpleDateFormat("MM-dd HH:mm");
		DateFormat datetimeformatHHMM = new SimpleDateFormat("HH:mm");
		try {
			String smstemple = this.getSMSTemple("TISSUEMSG");
			
			String flightinfoold = smstemple.substring(smstemple.indexOf("#"),
					smstemple.lastIndexOf("#") + 1);
			String flightinfonew = smstemple.substring(
					smstemple.indexOf("#") + 1, smstemple.lastIndexOf("#") - 1);
			String flight = flightinfonew;
			StringBuffer flightinfo = new StringBuffer("");
			for (int i = 0; i < listseg.size(); i++) {
				Segmentinfo segmentinfo = listseg.get(i);
				flightinfonew = flightinfonew.replace("@flightdate@",
						(dateformat.format(segmentinfo.getDeparttime()).replace("-", "月"))+"日");
				flightinfonew = flightinfonew.replace("@flightvoyage@", this
						.getCitynameByAirport(segmentinfo.getStartairport())+segmentinfo.getBorderpointat()
						+ "-"
						+ this.getCitynameByAirport(segmentinfo.getEndairport()))+segmentinfo.getOffpointat();
				flightinfonew = flightinfonew.replace("@aircompanyname@",
						this.getAircomapnycodeByEZM(segmentinfo
								.getAircomapnycode()));
				flightinfonew = flightinfonew.replace("@flightnumber@",
						segmentinfo.getFlightnumber());
				flightinfonew = flightinfonew.replace("@flighttime@", this
						.formatTimestampHHmm(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@startcity@", this
						.getCitynameByAirport(segmentinfo.getStartairport()));
				flightinfonew = flightinfonew.replace("@borderpointat@",
						converNull(segmentinfo.getBorderpointat(), ""));
				flightinfonew = flightinfonew.replace("@arrivaltime@",
						datetimeformatHHMM.format(segmentinfo.getArrivaltime()));
				flightinfonew = flightinfonew.replace("@arrivalcity@", this
						.getCitynameByAirport(segmentinfo.getEndairport()));
				flightinfonew = flightinfonew.replace("@offpointat@",
						converNull(segmentinfo.getOffpointat(), ""));
				flightinfo.append(flightinfonew);
				System.out.println(flightinfonew);
				if (i == 1) {
					break;
				}
				flightinfonew = flight;

			}
			if (listseg.size() > 2) {
				flightinfo.append("以及其它航段。");
			}
			/*String passengername = passenger.getName()
					+ passenger.getIdnumber();*/
			
			String passengername = "";
			String ticketno="";
			int size=listpassenger.size();
			for(int a=0;a<listpassenger.size();a++){
				passengername += listpassenger.get(a).getName()+"("+listpassenger.get(a).getIdnumber()+")";
				if((a+1)!=size){
					passengername+=";";
					ticketno+=listpassenger.get(a).getTicketnum()+";";
				}
				
			}
			
			smstemple = smstemple.replace("@passenger@", passengername);
			smstemple = smstemple.replace("@TicketNo@", ticketno);
			
			
			smstemple = smstemple.replace(flightinfoold, flightinfo.toString());
		/*	smstemple = smstemple.replace("@ticketprice@", String
					.valueOf(passenger.getPrice()));
			smstemple = smstemple.replace("@duty@", String.valueOf(converNull(
					passenger.getFuelprice(), 0f)
					+ converNull(passenger.getAirportfee(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)));*/
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(listpassenger.get(0).getOrderid());
			
			
			System.out.println("smstemple:"+smstemple.trim());
			state = Server
					.getInstance()
					.getAtomService()
					.sendSms(
							new String[] { converNull(orderinfo.getContactmobile(), "")
									.trim() }, smstemple.trim(),
							String.valueOf(listpassenger.get(0).getOrderid()), "2");

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (state == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean sendCreateOrderTXTSmstoPassenger(List<Passenger> listpassenger,
			List<Segmentinfo> listseg,Orderinfo orderinfo) {
		int state = 0;
		DateFormat dateformat = new SimpleDateFormat("MM-dd");
		DateFormat datetimeformat = new SimpleDateFormat("MM-dd HH:mm");
		DateFormat datetimeformatHHMM = new SimpleDateFormat("HH:mm");
		try {
			String smstemple = this.getSMSTemple("CONFIRMMSG");

			String flightinfoold = smstemple.substring(smstemple.indexOf("#"),
					smstemple.lastIndexOf("#") + 1);
			String flightinfonew = smstemple.substring(
					smstemple.indexOf("#") + 1, smstemple.lastIndexOf("#") - 1);
			String flight = flightinfonew;
			StringBuffer flightinfo = new StringBuffer("");
			for (int i = 0; i < listseg.size(); i++) {
				Segmentinfo segmentinfo = listseg.get(i);
				flightinfonew = flightinfonew.replace("@flightdate@",
						dateformat.format(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@flightvoyage@", this
						.getCitynameByAirport(segmentinfo.getStartairport())
						+ "-"
						+ this
								.getCitynameByAirport(segmentinfo
										.getEndairport()));
				flightinfonew = flightinfonew.replace("@aircompanyname@",
						this.getAircomapnycodeByEZM(segmentinfo
								.getAircomapnycode()));
				flightinfonew = flightinfonew.replace("@flightnumber@",
						segmentinfo.getFlightnumber());
				flightinfonew = flightinfonew.replace("@flighttime@", this
						.formatTimestampHHmm(segmentinfo.getDeparttime()));
				flightinfonew = flightinfonew.replace("@startcity@", this
						.getCitynameByAirport(segmentinfo.getStartairport()));
				flightinfonew = flightinfonew.replace("@borderpointat@",
						converNull(segmentinfo.getBorderpointat(), ""));
				flightinfonew = flightinfonew.replace("@arrivaltime@",
						datetimeformatHHMM.format(segmentinfo.getArrivaltime()));
				flightinfonew = flightinfonew.replace("@arrivalcity@", this
						.getCitynameByAirport(segmentinfo.getEndairport()));
				flightinfonew = flightinfonew.replace("@offpointat@",
						converNull(segmentinfo.getOffpointat(), ""));
				flightinfo.append(flightinfonew);
				System.out.println(flightinfonew);
				if (i == 1) {
					break;
				}
				flightinfonew = flight;

			}
			if (listseg.size() > 2) {
				flightinfo.append("以及其它航段。");
			}
			/*String passengername = passenger.getName()
					+ passenger.getIdnumber();*/
			
			String passengername = "";
			int size=listpassenger.size();
			for(int a=0;a<listpassenger.size();a++){
				passengername += listpassenger.get(a).getName();
				if((a+1)!=size){
					passengername+=";";
				}
				
			}
			
			smstemple = smstemple.replace("@passenger@", passengername);
			smstemple = smstemple.replace(flightinfoold, flightinfo.toString());
		/*	smstemple = smstemple.replace("@ticketprice@", String
					.valueOf(passenger.getPrice()));
			smstemple = smstemple.replace("@duty@", String.valueOf(converNull(
					passenger.getFuelprice(), 0f)
					+ converNull(passenger.getAirportfee(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)));*/
			
			
			System.out.println("smstemple:"+smstemple.trim());
			state = Server
					.getInstance()
					.getAtomService()
					.sendSms(
							new String[] { converNull(orderinfo.getContactmobile(), "")
									.trim() }, smstemple.trim(),
							String.valueOf(listpassenger.get(0).getOrderid()), "2");

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (state == 1) {
			return true;
		} else {
			return false;
		}
	}
	public int sendFYsms(String mobile, String name, Segmentinfo segment,
			long orderid) {
		// 起飞日期 航班号 出发地 到大地 乘客姓\//订单号
		return Server.getInstance().getAtomService().sendFeiyouSms(
				converNull(mobile, "").trim(),
				this.formatTimestamp2(segment.getDeparttime()),
				segment.getFlightnumber(), segment.getStartairport(),
				segment.getEndairport(), name, "0", null,
				String.valueOf(orderid));
	}

	/**
	 * 取消定制短信。
	 * 
	 * @param mobile
	 * @param name
	 * @param segment
	 * @param orderid
	 * @return
	 */
	public int removeFYsms(String mobile, String name, Segmentinfo segment,
			long orderid) {
		// 起飞日期 航班号 出发地 到大地 乘客姓\//订单号
		return Server.getInstance().getAtomService().sendFeiyouSms(
				converNull(mobile, "").trim(),
				this.formatTimestamp2(segment.getDeparttime()),
				segment.getFlightnumber(), segment.getStartairport(),
				segment.getEndairport(), name, "0", "1",
				String.valueOf(orderid));
	}

	public String getCheckTime(String s_begintime, String s_endtime) {
		String timewhere = "";
		if (s_begintime != null && s_begintime.trim().length() > 0
				&& s_begintime.length() < 19) {
			s_begintime = s_begintime + " 00:00:00";
		}
		if (s_endtime != null && s_endtime.trim().length() > 0
				&& s_endtime.length() < 19) {
			s_endtime = s_endtime + " 23:59:59";
		}
		if (s_begintime != null && s_begintime.trim().length() > 0
				&& s_endtime.trim().length() > 0) {
			timewhere = s_begintime + "--" + s_endtime;
		} else if (s_begintime != null && s_begintime.trim().length() > 0) {
			timewhere = s_begintime + "后";
		} else if (s_endtime != null && s_endtime.trim().length() > 0) {
			timewhere += s_endtime + "前";
		}
		return timewhere;
	}

	public String getDeptstr() {
		return this.deptstr.toString();
	}

	private StringBuffer deptstr = new StringBuffer("");
	private List<Department> deptlist;

	/**
	 * @param pdept
	 *            服务于方法：getDepttreestr()
	 * 
	 * private void deptsort(Department pdept, Customeragent cage) { for
	 * (Department dept : deptlist) { if (dept.getParentid() == pdept.getId()) {
	 * deptstr.append("var sub_" + dept.getId() + " = new Ext.tree.TreeNode({
	 * id:'" + dept.getId() + "@" + cage.getId() + "', text:'" + dept.getName() +
	 * "'});\n"); deptstr.append("sub_" + pdept.getId() + ".appendChild(sub_" +
	 * dept.getId() + ");\n"); } } }
	 */
	/**
	 * @return deptstr 部门树字符串
	 * @param agentype
	 *            加盟商类型 可以为null
	 * @param agentid
	 *            单位id 可以为nul
	 * @param isdept
	 *            是否显示部门 true：显示，fasle：不显示 其结果单位Id标识：c111111 单位部门 部门id@单位id
	 *            例如：11114@46004 附带解析方法： if(s_department.indexOf("c")>=0){ long
	 *            agentid=Long.valueOf(s_department.substring(1));
	 *            companyname=Server.getInstance().getMemberService().findCustomeragent(agentid).getAgentcompanyname();
	 *            deptstr=getSubDetpt(deptid); }else{ long
	 *            deptid=Long.valueOf(s_department.substring(0,s_department.indexOf("@")));
	 *            this.departname=Server.getInstance().getMemberService().findDepartment(deptid).getName();
	 *            deptstr=getSubDetpt(deptid); }
	 * 
	 * 
	 * 
	 * protected void getDepttreestr(Long agentype, long[] arrayagentid, boolean
	 * extendDept) { deptstr .append("var root = new Ext.tree.TreeNode({text:\"所
	 * 有\",id:'-1'});\n"); // AND "+Customeragent.COL_agentisenable+"=1
	 * 暂不限制单位是否禁用 twocold
	 * 
	 * String csql = "SELECT * FROM [T_CUSTOMERAGENT] WHERE C_AGENTCHECKSTATUS=1
	 * AND C_AGENTTYPE=" + agentype; if (agentype == null) { csql = "SELECT *
	 * FROM [T_CUSTOMERAGENT] WHERE C_AGENTCHECKSTATUS=1"; } if (arrayagentid !=
	 * null && arrayagentid.length >= 0) { if (arrayagentid.length == 0) {
	 * arrayagentid = new long[1]; arrayagentid[0] = 0; } String str = ""; for
	 * (long id : arrayagentid) { if (str.length() > 0) str += "," + id; else {
	 * str += id; } } csql += " AND ID IN ( " + str + " )"; } List<Customeragent>
	 * customeragents = Server.getInstance()
	 * .getMemberService().findAllCustomeragentBySql(csql, -1, 0); //
	 * System.out.println(customeragents.size()); for (Customeragent cage :
	 * customeragents) {
	 * 
	 * deptstr.append(" var root_" + cage.getId() + " = new
	 * Ext.tree.TreeNode({text:\"" + cage.getAgentcompanyname() + "\",id:'c" +
	 * cage.getId() + "'});\n" + " root.appendChild(root_" + cage.getId() +
	 * ");\n "); if (extendDept) {// 供应商只显示其单位，不显示到其部门 String sql = "SELECT *
	 * FROM [T_DEPARTMENT] WHERE C_AGENTID=" + cage.getId(); deptlist =
	 * Server.getInstance().getMemberService() .findAllDepartmentBySql(sql, -1,
	 * 0); if (!deptlist.isEmpty()) { for (Department dept : deptlist) { if
	 * (dept.getParentid() == -1) { deptstr.append("var sub_" + dept.getId() + " =
	 * new Ext.tree.TreeNode({ id:'" + dept.getId() + "@" + cage.getId() + "',
	 * text:'" + dept.getName() + "'});\n"); deptstr.append("root_" +
	 * cage.getId() + ".appendChild(sub_" + dept.getId() + ");\n");
	 * this.deptsort(dept, cage); } } for (Department dept : deptlist) { if
	 * (dept.getParentid() != -1) { this.deptsort(dept, cage); } } } } } }
	 */
	/**
	 * 根据票号提取行程单号
	 * 
	 * @ticketnumber 票号
	 * @return 行程单号
	 */
	public String getReptNumber(String ticketnumber) {
		String strRet = "";
		if (ticketnumber.indexOf("781-") >= 0
				|| ticketnumber.indexOf("774-") >= 0) {
			strRet = Server.getInstance().getTicketSearchService()
					.commandFunction("DETR:tn/" + ticketnumber + ",f", "");
			if (strRet.length() > 0) {
				String strreg = "[R][P][0-9]{10}";
				Pattern pattFlight = Pattern.compile(strreg);
				Matcher mFlight = pattFlight.matcher(strRet);
				if (mFlight.find()) {
					strRet = mFlight.group().toString().replace("RP", "")
							.trim();
				} else {
					strRet = "";
				}
			}
		} else {
			strRet = Server.getInstance().getTicketSearchService().getRpNumber(
					ticketnumber);
		}
		return strRet;
	}

	/**
	 * 在黑屏中FD查询基础价格
	 * 
	 * @param strSPort
	 *            出发机场三字码
	 * @param strEPort
	 *            到达机场三字码
	 * @param strDate
	 *            航空公司代码
	 * @return 基础价格
	 */
	public String getYPriceBycmd(String strSPort, String strEPort,
			String strAirCompany) {
		String strReturn = "";
		String strcmd = "FD:" + strSPort + strEPort + "/" + strAirCompany;
		strReturn = Server.getInstance().getTicketSearchService()
				.commandFunction2(strcmd, "", "");
		return strReturn;
	}

	public float getchildrate() {
		float childrate = 0.98f;
		String rolestr = ActionContext.getContext().getSession()
				.get("ListAgid").toString();

		if (rolestr.indexOf(",") >= 0) {
			String[] strarr = rolestr.split(",");
			if (strarr.length > 0) {
				for (int i = 0; i < strarr.length; i++) {
					if (strarr[i].equals("1")) {
						childrate = 0.97f;
						break;
					}
				}
			}

		} else {
			childrate = 0.98f;
		}
		return childrate;
	}

	/**
	 * 取得政策列表公共方法--读取本地数据库
	 * 
	 * @param z_startcity
	 *            出发城市
	 * @param z_endcity
	 *            到达城市
	 * @param z_fromdate
	 *            出发日期
	 * @return 政策列表
	 */
	public List<Zrate> Getallzrate_todb(String z_startcity, String z_endcity,
			String z_fromdate, int intflag, String strAirCompany,
			String strAirline, String strCabin) {
		// 返回值 List<Zrate>
		if(z_fromdate==null || z_fromdate.equals(""))
		{
			z_fromdate=formatTimestamp2(new Timestamp(System.currentTimeMillis()));
		}
		List<Zrate> listreturn = new ArrayList<Zrate>();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");
		String mDateTime1 = formatter1.format(cal1.getTime());
		String strSP = "";
		if(strAirline.length()>4){
		strAirline=strAirline.substring(2, strAirline.length());
		}
		
		// 取得普通政策
		if (intflag == 1) {
			strSP = "[dbo].[sp_GetZrateByFlight] " + "@chufajichang = N'"
					+ z_startcity + "',@daodajichang = N'" + z_endcity + "',"
					+ "@chufariqi = N'" + z_fromdate + "',@dangqianshijian= N'"
					+ mDateTime1 + "'," + "@hangkonggongsi= N'" + strAirCompany
					+ "'," + "@cangwei= N'" + strCabin + "',@hangbanhao= N'"
					+ strAirline + "',@ismulity=1,@isgaofan=1,@agentid=0";
		} else if (intflag == 2) {
			strSP = "[dbo].[sp_GetZrateByFlight] " + "@chufajichang = N'"
					+ z_startcity + "',@daodajichang = N'" + z_endcity + "',"
					+ "@chufariqi = N'" + z_fromdate + "',@dangqianshijian= N'"
					+ mDateTime1 + "'," + "@hangkonggongsi= N'" + strAirCompany
					+ "'," + "@cangwei= N'" + strCabin + "',@hangbanhao= N'"
					+ strAirline + "',@ismulity=1,@isgaofan=2,@agentid=0";
		}
		// 取得特殊政策

		System.out.println(strSP);
		List<Zrate> listzrate = Server.getInstance().getSystemService()
				.findMapResultByProcedure(strSP);

		// 获取政策列表信息
		if(listzrate.size()>0)
		{
		for (int i = 0; i < listzrate.size(); i++) {
			Map listzratemap = (Map) listzrate.get(i);
			long lzrateid = Long.parseLong(listzratemap.get("zrateid")
					.toString());
			Zrate zrateinfo = Server.getInstance().getAirService().findZrate(
					lzrateid);
			listreturn.add(zrateinfo);
		}
			//添加上默认政策
			Zrate zratemodel=Server.getInstance().getAirService().findZrate(1l);
			if(zratemodel!=null)
			{
			listreturn.add(zratemodel);
			}
		}
		else
		{
			Zrate zrateinfo =Server.getInstance().getAirService().findZrate(1l);
			if(zrateinfo!=null)
			{
	    	listreturn.add(zrateinfo);
			}
		}

		return listreturn;
	}
	/**
	 * 取得政策列表公共方法--读取缓存
	 * 
	 * @param z_startcity
	 *            出发城市
	 * @param z_endcity
	 *            到达城市
	 * @param z_fromdate
	 *            出发日期
	 * @return 政策列表
	 */
	public List<Zrate> Getallzrate(String z_startcity, String z_endcity,
			String z_fromdate, int intflag, String strAirCompany,
			String strAirline, String strCabin) {
		// 返回值 List<Zrate>
		if(z_fromdate==null || z_fromdate.equals(""))
		{
			z_fromdate=formatTimestamp2(new Timestamp(System.currentTimeMillis()));
		}
		List<Zrate> listreturn = new ArrayList<Zrate>();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");
		String mDateTime1 = formatter1.format(cal1.getTime());
		String strSP = "";
		if(strAirline.length()>4){
		strAirline=strAirline.substring(2, strAirline.length());
		}
		
		// 取得普通政策
		if (intflag == 1) {
			strSP = "[dbo].[sp_GetZrateByFlight] " + "@chufajichang = N'"
					+ z_startcity + "',@daodajichang = N'" + z_endcity + "',"
					+ "@chufariqi = N'" + z_fromdate + "',@dangqianshijian= N'"
					+ mDateTime1 + "'," + "@hangkonggongsi= N'" + strAirCompany
					+ "'," + "@cangwei= N'" + strCabin + "',@hangbanhao= N'"
					+ strAirline + "',@ismulity=1,@isgaofan=1,@agentid=0";
		} else if (intflag == 2) {
			strSP = "[dbo].[sp_GetZrateByFlight] " + "@chufajichang = N'"
					+ z_startcity + "',@daodajichang = N'" + z_endcity + "',"
					+ "@chufariqi = N'" + z_fromdate + "',@dangqianshijian= N'"
					+ mDateTime1 + "'," + "@hangkonggongsi= N'" + strAirCompany
					+ "'," + "@cangwei= N'" + strCabin + "',@hangbanhao= N'"
					+ strAirline + "',@ismulity=1,@isgaofan=2,@agentid=0";
		}
		// 取得特殊政策
		List<Zrate> listzrate =new ArrayList<Zrate>();
		/*List<Zrate> listzrate8000=new ArrayList<Zrate>();
		List<Zrate> listzratePM=new ArrayList<Zrate>();
		List<Zrate> listzrateJR=new ArrayList<Zrate>();
		 if (intflag == 1) {
			 listzrate8000=ZrateServer.getInstance().searchZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 3, strAirline, 1);
			 listzratePM=ZrateServer.getInstance().searchZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 2, strAirline, 1);
			 listzrateJR=GetJinriListZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 6, strAirline, 1,10);//航程匹配
			
		}
		if (intflag == 2) {
			 listzrate8000=ZrateServer.getInstance().searchZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 3, strAirline, 2);
			 listzratePM=ZrateServer.getInstance().searchZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 2, strAirline, 2);
			listzrateJR=GetJinriListZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 6, strAirline, 2,10);//航程匹配
			
		}
		
		 for(int a=0;a<listzrateJR.size();a++){
			   listzrate.add(listzrateJR.get(a));
		   }
		   for(int a=0;a<listzrate8000.size();a++){
			   listzrate.add(listzrate8000.get(a));
		   }
		   for(int a=0;a<listzratePM.size();a++){
			   listzrate.add(listzratePM.get(a));
		   }*/
		   

		  System.out.println(strSP);
		 
		  
		  //System.out.println(ZrateServer.getInstance().getUrl());
		  
		
		     if (intflag == 1) {
			  listzrate=GetJinriListZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 6, strAirline, 1,10);//航程匹配
				
			}
			if (intflag == 2) {
				listzrate=GetJinriListZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 6, strAirline, 2,10);//航程匹配
				
			}
		   
			 //罗总用
			  //ZrateServer.getInstance().setUrl("http://118.244.212.62:28080");
			  //List<Zrate>  listzratered=ZrateServer.getInstance().searchZrate(z_startcity, z_endcity, strAirCompany, strCabin, z_fromdate, 0, strAirline, intflag);//本地
			
			  
			  
			List listzrat_bendi=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);//本地数据库
			 if(listzrat_bendi.size()>0)
				{
				 for(int a=0;a<listzrat_bendi.size();a++){
			    	Map listzratemap = (Map) listzrat_bendi.get(a);
			    	Zrate zrate=new Zrate();
			    	zrate=Server.getInstance().getAirService().findZrateByDB(Long.parseLong(listzratemap.get("zrateid").toString()));
			    	Zrate redrate = ZrateServer.getInstance().findZrate(zrate.getAgentid(), "*$"+zrate.getOutid());
					listzrate.add(redrate);
			    	
				 }
				}
			
		  
		   java.util.Collections.sort(listzrate);
		
		

		return listzrate;
	}


	/**
	 * 根据政策值得到分销商留点设置值 各级代理商根据留点设置得到不同的返点。如果是平台进行查询，则不进行返点匹配，所有返点直接留给加盟商。
	 * 
	 * @return 如果配置到留点设置值就返回留点设置值，否则返回原来的政策值
	 */
	public float Getliudianvalue_old(float fvalue) {
		float freturn = fvalue;
		// 得到当前登录代理商ID
		Customeragent customeragent = getLoginUserAgent();
		long lcurrentagentid = customeragent.getId();
		// 如果当前登录的代理商不是平台，则通过返点计算出代理商的返点
		if (lcurrentagentid != 46) {
			// 取得此代理商上级代理商id串,逗号分隔
			String strParentIds = customeragent.getParentstr();

			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
//				Customeragent tempcustomeragent = Server.getInstance()
//						.getMemberService().findCustomeragent(
//								Long.parseLong(strParentIds.split(",")[i]));
				// 取得各级留点值
				fvalue = GetAgentBackPoint(Long.parseLong(strParentIds.split(",")[i]), fvalue);

			}
			freturn = fvalue;
		}

		return freturn;

	}
	
	public int GetOrderZrateAgentid(long id){
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(id);
		if(orderinfo.getPolicyagentid()<=10){
			return 1;
		}else{
			return 0;
		}
		 
	}
	public float Getliudianvalue_hotel(float fvalue) {
		float freturn = fvalue;
		if(getLoginAgent().getBigtype()==2){
			return Float.parseFloat(getLoginAgent().getFixedvalue());
		}
		
		// 得到当前登录代理商ID
		Customeragent customeragent = getLoginUserAgent();
		long lcurrentagentid = customeragent.getId();
		// 如果当前登录的代理商不是平台，则通过返点计算出代理商的返点
		if (lcurrentagentid != 46) {
			// 取得此代理商上级代理商id串,逗号分隔
			String strParentIds = customeragent.getParentstr();

			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
//				Customeragent tempcustomeragent = Server.getInstance()
//						.getMemberService().findCustomeragent(
//								Long.parseLong(strParentIds.split(",")[i]));
				String strAgentid=strParentIds.split(",")[i];
				// 取得各级留点值
				fvalue = GetAgentBackPoint_hotel(Long.parseLong(strParentIds.split(",")[i]), fvalue);

			}
			freturn = fvalue;

			freturn = dceimalFormat(GetAgentBackPoint_hotel(customeragent.getId(), freturn));

		}

		return freturn;

	}
	public float Getliudianvalue2(float fvalue,Customeragent cus) {
		float freturn = fvalue;
		// 得到当前登录代理商ID
		Customeragent customeragent = cus;
		long lcurrentagentid = customeragent.getId();
		// 如果当前登录的代理商不是平台，则通过返点计算出代理商的返点
		if (lcurrentagentid != 46) {
			// 取得此代理商上级代理商id串,逗号分隔
			String strParentIds = customeragent.getParentstr();

			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
//				Customeragent tempcustomeragent = Server.getInstance()
//						.getMemberService().findCustomeragent(
//								Long.parseLong(strParentIds.split(",")[i]));
				String strAgentid=strParentIds.split(",")[i];
				// 取得各级留点值
				fvalue = GetAgentBackPoint(Long.parseLong(strParentIds.split(",")[i]), fvalue);

			}
			freturn = fvalue;

			freturn = dceimalFormat(GetAgentBackPoint(customeragent.getId(), freturn));

		}

		return freturn;

	}
	public float Getliudianvalue(float fvalue) {
		float freturn = fvalue;
		if(getLoginAgent().getBigtype()==2){
			return Float.parseFloat(getLoginAgent().getFixedvalue());
		}
		
		// 得到当前登录代理商ID
		Customeragent customeragent = getLoginUserAgent();
		long lcurrentagentid = customeragent.getId();
		// 如果当前登录的代理商不是平台，则通过返点计算出代理商的返点
		if (lcurrentagentid != 46) {
			// 取得此代理商上级代理商id串,逗号分隔
			String strParentIds = customeragent.getParentstr();

			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
//				Customeragent tempcustomeragent = Server.getInstance()
//						.getMemberService().findCustomeragent(
//								Long.parseLong(strParentIds.split(",")[i]));
				String strAgentid=strParentIds.split(",")[i];
				// 取得各级留点值
				fvalue = GetAgentBackPoint(Long.parseLong(strParentIds.split(",")[i]), fvalue);

			}
			freturn = fvalue;

			freturn = dceimalFormat(GetAgentBackPoint(customeragent.getId(), freturn));

		}

		return freturn;

	}

	/**
	 * 计算各级返点值
	 * 
	 * @param customeragent
	 *            代理商
	 * @param fpoint
	 *            返点值
	 * @return 最终返点值
	 */
	public float GetAgentBackPoint(long agentid, float fpoint) {
		float freturn = fpoint;
		List<Liudianrecord> liudianinfolist = new ArrayList<Liudianrecord>();
		// 取得代理商返点设置列表
		String strwhere = " WHERE 1=1 AND C_TYPEID = (select top 1 C_TYPEID from T_LIUDIANREFINFO where C_AGENTID="
				+ agentid + ")";
		liudianinfolist = Server.getInstance().getMemberService()
				.findAllLiudianrecord(strwhere, "ORDER BY ID", -1, 0);

		if (liudianinfolist != null) {
			String strBackPoint = "";
			for (Liudianrecord ld : liudianinfolist) {
				if (fpoint > ld.getFandianstart() && fpoint <= ld.getFandianend()) {
					freturn = fpoint - ld.getLiudian();

					// 开始
					String freturnStr = freturn + "";
					if (freturnStr.indexOf("-") != -1) {
						freturn = 0;
					}
					// 结束

					break;
				}

			}
		}
		return freturn;
	}
	/**
	 * 计算各级返点值
	 * 
	 * @param customeragent
	 *            代理商
	 * @param fpoint
	 *            返点值
	 * @return 最终返点值
	 */
	public float GetAgentBackPoint_hotel(long agentid, float fpoint) {
		System.out.println("agentid:"+agentid+",fpoint:"+fpoint);
		float freturn = fpoint;
		List<Starrecord> StarrecordList = new ArrayList<Starrecord>();
		// 取得代理商返点设置列表
		String strwhere = " WHERE 1=1 AND C_TYPEID = (select top 1 C_TYPEID from T_STARREINFO where C_SAGENTID='"
				+ agentid + "')";
		StarrecordList = Server.getInstance().getHotelService()
				.findAllStarrecord(strwhere, "ORDER BY ID", -1, 0);

		if (StarrecordList != null) {
			String strBackPoint = "";
			for (Starrecord ld : StarrecordList) {
				if (fpoint > Float.parseFloat(ld.getSfandianstart()) && fpoint <= Float.parseFloat(ld.getSfandianend())) {
					freturn = fpoint - Float.parseFloat(ld.getSliudian());
					System.out.println("agentid:"+agentid+",fpoint:"+fpoint+",freturn:"+freturn);
					// 开始
					String freturnStr = freturn + "";
					if (freturnStr.indexOf("-") != -1) {
						freturn = 0;
					}
					// 结束

					break;
				}

			}
		}
		System.out.println("return_agentid:"+agentid+",fpoint:"+fpoint+",freturn:"+freturn);
		return freturn;
	}

	float fliudianvalue = 0f;
	
	
	/**酒店分润方法
	 * @param 酒店订单ID  
	 * @return  
	 */
	public void LubricatingByHotelorderID(long id){
	Hotelorder horder=Server.getInstance().getHotelService().findHotelorder(id)	;
		if(horder.getProfits()!=null&&horder.getProfits()>0){
			Double orderValue=horder.getProfits();//订单总利润
			Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(Server.getInstance().getMemberService().findCustomeruser(horder.getMemberid()).getAgentid());
			System.out.println("总利润=="+orderValue);
			String strParentIds = agent.getParentstr();
			
			//临时
			Double orderva=orderValue;
			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
				String strAgentid=strParentIds.split(",")[i];
				// 取得各级留点值
				if(!strAgentid.equals("1")){
					Float agnetvalue = GetAgentHotelBackPoint(Long.parseLong(strParentIds.split(",")[i]), Float.parseFloat(orderva.toString()));
					orderva=Double.parseDouble(agnetvalue.toString());
					Float agentva=Float.parseFloat(orderva.toString())-agnetvalue;//当前加盟商利润
					System.out.println("加盟商"+strAgentid+"的利润=="+agentva);
				}

			}
		
		}
	}
	/**传入酒店星级,计算总利润
	 * 
	 * @param star  传入的值
	 * @return  总利润
	 */
	
	public Float GetHotelPriceValueByStar(String star,Float price){
		StringBuffer where = new StringBuffer();
		where.append(" where 1=1 ");
		if(star.equals("1")){//经济型
			where.append(" and "+Hotelstart.COL_startcode+" ='经济型'");
		}
		if(star.equals("2")||star.equals("3")){//二星级
			where.append(" and "+Hotelstart.COL_startcode+" ='二星级'");	
		}
		if(star.equals("4")||star.equals("5")){//三星级
			where.append(" and "+Hotelstart.COL_startcode+" ='三星级'");			
		}
		if(star.equals("6")||star.equals("7")){//四星级
			where.append(" and "+Hotelstart.COL_startcode+" ='四星级'");	
		}
		if(star.equals("8")||star.equals("9")){//五星级
			where.append(" and "+Hotelstart.COL_startcode+" ='五星级'");	
		}
		List<Hotelstart>list=Server.getInstance().getHotelService().findAllHotelstart(where.toString(), " ORDER BY ID ", -1, 0);
		if(list.size()>0&&list.get(0).getMargin()!=null&&list.get(0).getMargin().length()>0){
			
			Float hotelvalue=Integer.parseInt(star)*price/100;
			return hotelvalue;
		}
		
		
		return 0f;
	}
	
	/**传入酒店星级,计算总利润
	 * 
	 * @param star  传入的值
	 * @return  总利润
	 */
	
	public Float GetHotelValueByStar(String star,Float price){
		StringBuffer where = new StringBuffer();
		where.append(" where 1=1 ");
		if(star.equals("1")){//经济型
			where.append(" and "+Hotelstart.COL_startcode+" ='经济型'");
		}
		if(star.equals("2")||star.equals("3")){//二星级
			where.append(" and "+Hotelstart.COL_startcode+" ='二星级'");	
		}
		if(star.equals("4")||star.equals("5")){//三星级
			where.append(" and "+Hotelstart.COL_startcode+" ='三星级'");			
		}
		if(star.equals("6")||star.equals("7")){//四星级
			where.append(" and "+Hotelstart.COL_startcode+" ='四星级'");	
		}
		if(star.equals("8")||star.equals("9")){//五星级
			where.append(" and "+Hotelstart.COL_startcode+" ='五星级'");	
		}
		List<Hotelstart>list=Server.getInstance().getHotelService().findAllHotelstart(where.toString(), " ORDER BY ID ", -1, 0);
		if(list.size()>0&&list.get(0).getMargin()!=null&&list.get(0).getMargin().length()>0){
			
			Float hotelvalue=Integer.parseInt(star)*price/100;
			return GetAgentHotelValue(hotelvalue);
		}
		
		
		return 0f;
	}
	
	/**
	 * 计算加盟商匹配留点后的值
	 * 
	 * @param value  传入的值
	 * 
	 * @return  value   匹配留点后返回的值
	 */
	public float GetAgentHotelValue(float hotelvalue){
		float freturn = hotelvalue;
		// 得到当前登录代理商ID
		Customeragent customeragent = getLoginUserAgent();
		long lcurrentagentid = customeragent.getId();
		// 如果当前登录的代理商不是平台，则通过返点计算出代理商的返点
		if (lcurrentagentid != 1) {
			// 取得此代理商上级代理商id串,逗号分隔
			String strParentIds = customeragent.getParentstr();

			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
//				Customeragent tempcustomeragent = Server.getInstance()
//						.getMemberService().findCustomeragent(
//								Long.parseLong(strParentIds.split(",")[i]));
				String strAgentid=strParentIds.split(",")[i];
				// 取得各级留点值
				hotelvalue = GetAgentHotelBackPoint(Long.parseLong(strParentIds.split(",")[i]), hotelvalue);

			}
			freturn = hotelvalue;

			freturn = dceimalFormat(GetAgentHotelBackPoint(customeragent.getId(), freturn));

		}

		return freturn;

		
	}

	/**
	 * 计算各级返点值--	Hotel
	 * 
	 * @param customeragent
	 *            代理商
	 * @param fpoint
	 *            返点值
	 * @return 最终返点值
	 */
	public float GetAgentHotelBackPoint(long agentid, float fpoint) {
		float freturn = fpoint;
		List<Starrecord> liudianinfolist = new ArrayList<Starrecord>();
		// 取得代理商返点设置列表
		String strwhere = " WHERE 1=1 AND C_TYPEID = (select top 1 C_TYPEID from T_STARREINFO where C_SAGENTID="
				+ agentid + ")";
		liudianinfolist = Server.getInstance().getHotelService()
				.findAllStarrecord(strwhere, "ORDER BY ID", -1, 0);

		if (liudianinfolist != null) {
			String strBackPoint = "";
			for (Starrecord ld : liudianinfolist) {
				if (fpoint > Float.parseFloat(ld.getSfandianstart()) && fpoint <= Float.parseFloat(ld.getSfandianend())) {
					freturn = fpoint - Float.parseFloat(ld.getSliudian());

					// 开始
					String freturnStr = freturn + "";
					if (freturnStr.indexOf("-") != -1) {
						freturn = 0;
					}
					// 结束

					break;
				}

			}
		}
		return freturn;
	}
	

	/**
	 * 保存订单所有返佣代理商记录，下单时计算返佣
	 * 
	 * @param customeragent
	 * @param totalpoint
	 * @param currentpoint
	 * @param dticketprice
	 * @param insurprice
	 *            保险
	 * @return
	 */
	public String getCustomerBackPointString(Customeragent customeragent,
			float totalpoint, float currentpoint, float dticketprice,
			float insurprice) {
		//WriteLog.write("getCustomerBackPointString", "预订代理ID:"+customeragent.getId()+",返点:"+totalpoint+",留点后返点:"+currentpoint+",票面价:"+dticketprice+",保险:"+insurprice);
		System.out.println("预订代理ID:"+customeragent.getId()+",返点:"+totalpoint+",留点后返点:"+currentpoint+",票面价:"+dticketprice+",保险:"+insurprice);
		String strReturn = "";
		// float freturn = 0f;
		currentpoint = totalpoint;
		//
		// 如果当前登录的代理商不是平台，则通过返点计算出代理商的返点
		if (customeragent.getId() != 46) {
			// 取得此代理商上级代理商id串,逗号分隔
			// 当前
			String strParentIds = customeragent.getParentstr();
			//System.out.println("代理id串:"+strParentIds);
			// 留点类型的值
			long intSegType = 0;
			// 当前代理商ID
			long currentAgentId = 0;

			for (int i = strParentIds.split(",").length - 1; i >= 0; i--) {
				fliudianvalue = 0f;
				if (i == 0) {
					currentAgentId = customeragent.getId();
				} else {
					currentAgentId = Long
							.parseLong(strParentIds.split(",")[i - 1]);
				}
				//System.out.println("当前代理ID:"+currentAgentId);
				// 根据代理商id取得他上级对他的留点类型Id
				List<Liudianrefinfo> listref = Server.getInstance()
						.getMemberService().findAllLiudianrefinfo(
								"where " + Liudianrefinfo.COL_agentid + "="
										+ currentAgentId, "", -1, 0);
				if (listref.size() > 0) {
					intSegType = listref.get(0).getTypeid();
				}else{
					intSegType=0;
				}
				
				//System.out.println("strParentIds.split):"+strParentIds.split(",")[i]);
				
				Customeragent tempcustomeragent = Server.getInstance()
						.getMemberService().findCustomeragent(
								Long.parseLong(strParentIds.split(",")[i]));
				//System.out.println("tempcustomeragent:"+tempcustomeragent.getId());
				// 取得各级留点值
				currentpoint = GetAgentBackPointLiuDian(tempcustomeragent,
						currentpoint, intSegType);
				//System.out.println("currentpoint:"+currentpoint);
				
				strReturn += tempcustomeragent.getId() + ","+ formatFloatZrate(fliudianvalue) + "," + dticketprice+ "," + totalpoint + "@";
				
			}
			strReturn += customeragent.getId() + "," + dceimalFormat(currentpoint) + ","
					+ dticketprice + "," + totalpoint + "@";
			// freturn = currentpoint;
		} else {
			strReturn += customeragent.getId() + "," + totalpoint + ","
					+ dticketprice + "," + totalpoint + "@";
		}
		Sysconfig sys = Server.getInstance().getSystemService()
				.findSysconfig(1);
		// 保存当前 保险成本 与购买数量
		strReturn += sys.getValue() + "|" + insurprice;
		return strReturn;
	}

	/**
	 * 计算各级留值
	 * 
	 * @param customeragent
	 *            代理商
	 * @param fpoint
	 *            返点值
	 * @return 最终返点值
	 */
	public float GetAgentBackPointLiuDian(Customeragent customeragent,
			float fpoint, long ltype) {
		float freturn = fpoint;
		List<Liudianrecord> liudianinfolist = new ArrayList<Liudianrecord>();
		// 取得代理商返点设置列表
		String strwhere = " WHERE 1=1 AND C_TYPEID =" + ltype;
		// + Liudianrefinfo.COL_agentid + "=" + customeragent.getId();
		liudianinfolist = Server.getInstance().getMemberService()
				.findAllLiudianrecord(strwhere, "ORDER BY ID", -1, 0);

		if (liudianinfolist != null) {
			String strBackPoint = "";
			for (Liudianrecord ld : liudianinfolist) {
				if (fpoint > ld.getFandianstart() && fpoint <= ld.getFandianend()) {
					freturn = fpoint - ld.getLiudian();
					fliudianvalue = ld.getLiudian();
					break;
				}

			}
		}
		return freturn;
	}

	/**
	 * 格式政策
	 * 
	 * @param num
	 * @return
	 */
	public String formatZrate(Float num) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.0");
		try {
			String result = format.format(num);
			return result;
		} catch (Exception e) {
			return Float.toString(num);
		}
	}

	public String getzhekoujine(Float amt, Float zhekoubili) {
		String strRet = "0";
		// Math.round(parseFloat(amtmoney)*fandian*0.01*0.1)*10
		try {
			double dret = Math.round(amt * zhekoubili * 0.01 * 0.1) * 10;
			strRet = dret + "";
		} catch (Exception ex) {
			strRet = "0";
		}

		return strRet;
	}

	/*
	 * 根据PNR取得证件信息
	 */
	public String getIDNumberbypnr(String strPnrInfo, String strPnmber) {
		String strIDNumber = "";
		Pattern pticketinfo = Pattern.compile("<br>");
		String[] strpnrinfo = pticketinfo.split(strPnrInfo);
		String[] strTemptic = null;
		boolean isbaby = false;
		if (strPnmber.indexOf("INF") >= 0) {
			strPnmber = "P1";
			isbaby = true;
		}
		for (int i = 0; i < strpnrinfo.length; i++) {
			if (strpnrinfo[i].indexOf("SSR FOID") >= 0
					&& strpnrinfo[i].indexOf(strPnmber) >= 0) {
				Pattern pidnumber1 = Pattern.compile("\\s");
				String[] strIdArr1 = pidnumber1.split(strpnrinfo[i]);
				if (strIdArr1.length > 0) {
					for (int w = 0; w < strIdArr1.length; w++) {
						if (strIdArr1[w].length() != 0
								&& strIdArr1[w].indexOf(strPnmber) >= 0) {
							Pattern pidnumber = Pattern
									.compile("[N][I]|[I][D]|[P][P]");
							String[] strIdArr = pidnumber.split(strIdArr1[w]);
							if (strIdArr.length == 2) {
								if (strIdArr[1].indexOf("/") >= 0) {
									String[] strIDNumberdetail = strIdArr[1]
											.split("/");
									if (strIDNumberdetail.length == 2) {
										strIDNumber = strIDNumberdetail[0];
									}
								}
							}
						}
					}
				}

			}
		}
		return strIDNumber;
	}

	public String getRealPath_tripline(String filePath) {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='oafileuppath'", "", -1,
						0).get(0)).getValue()
				+ filePath;
	}
	
	public String getRealPath_bytype(String type,String filePath) {
		return ((Sysconfig) Server.getInstance().getSystemService()
				.findAllSysconfig("where C_NAME='"+type+"'", "", -1,
						0).get(0)).getValue()
				+ filePath;
	}
	
	
	/**
	 * 根据线路ID获取线路名称
	 */		
	public String GetSpotlinenameByid(String id)throws Exception{
	
		return Server.getInstance().getTripService().findSpotline(Long.parseLong(id)).getName();
	}
	

	/**
	 * 根据行政区ID获取行政区名称
	 */
	public String getRegionNameByStr(String regionid) {
		Region region = Server.getInstance().getHotelService().findRegion(
				Long.parseLong(regionid));
		return region != null && !"".equals(region.getName()) ? region
				.getName() : "";
	}

	public Double gethotelstateprice(Integer id) {// 取酒店星级对应的返点
		switch (id) {

		case 1:

			return 0.01;

		case 2:

			return 0.02;

		case 3:

			return 0.03;

		case 4:

			return 0.04;

		case 5:

			return 0.05;

		default:
			return 1.0;
		}

	}

	// 获取session的语言类型
	public Integer sessionlanguage() {
		if (ActionContext.getContext().getSession().get("language") == null) {
			return 1;
		}
		return (Integer) ActionContext.getContext().getSession()
				.get("language");
	}

	/**
	 * 根据城市ID获取城市名称
	 */
	public String getCityNameByStr(String cityid) {
		City city = Server.getInstance().getHotelService().findCity(
				Long.parseLong(cityid));
		return city != null && city.getName() != null
				&& !"".equals(city.getName()) ? city.getName() : "";
	}
	
	/**
	 * 根据城市ID获取旅游城市名称
	 */
	public String getSpotCityNameByStr(String cityid) {
		Spotcity city = Server.getInstance().getTripService().findSpotcity(
				Long.parseLong(cityid));
		return city != null && city.getName() != null
				&& !"".equals(city.getName()) ? city.getName() : "";
	}
	
	

	public String getFamousAgentName(long id) {
		String strret = "";
		if (id == 3) {
			strret = "8000yi";
		} else if (id == 4) {
			strret = "允风文化";
		} else if (id == 5) {
			strret = "51book";
		} else if (id == 6) {
			strret = "今日天下通";
		} else if (id == 7) {
			strret = "517NA";
		}else {
			strret = getorderusercompanybyid(id);
		}
		return strret;
	}

	
	public String getZrateAgentName(long id) {
		String strret = "";
		if (this.getLoginUserAgent().getId() == 46) {
			strret += "(<font color='red'>";
			if (id == 3) {
				strret += "8000yi";
			} else if (id == 46) {
				strret += getorderusercompanybyid(id);
			} else if (id == 5) {
				strret += "51book";
			} else if (id == 6) {
				strret += "今日天下通";
			}else if (id == 2) {
				strret += "票盟";
			}else if (id == 7) {
				strret += "517NA";
			}  else {
				strret += getorderusercompanybyid(id);
			}
			strret += "</font>)";
		}
		return strret;
	}

	/**
	 * 获取两个日期相减剩余天数
	 * 
	 * @param d1
	 * @param d2
	 * @return 天数
	 * @throws ParseException
	 */
	public long dateDiff(String d1, String d2) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = df.parse(d1);
		Date date2 = df.parse(d2);
		return (date1.getTime() - date2.getTime()) / 86400000;
	}

	/**
	 * 
	 * @param d
	 * @param type
	 * @param number
	 * @return
	 */
	public static Date reportGetDate(Date d, String type, int number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		if (type.equals("YEAR"))
			calendar.add(Calendar.YEAR, number);
		if (type.equals("MONTH"))
			calendar.add(Calendar.MONTH, number);
		if (type.equals("DAY"))
			calendar.add(Calendar.DAY_OF_MONTH, number);
		if (type.equals("HOUR"))
			calendar.add(Calendar.HOUR_OF_DAY, number);
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 根据省份id取得省份名称
	 * 
	 * @param provinceid
	 * @return
	 */
	public String getProcinceNamebyId(long provinceid) {
		Province province = Server.getInstance().getHotelService()
				.findProvince(provinceid);
		return province != null && province.getName() != null
				&& !"".equals(province.getName()) ? province.getName() : "";
	}

	public String getcityNamebyId(long cityid) {
		// System.out.println(cityid);
		City city = Server.getInstance().getHotelService().findCity(cityid);

		if (city != null) {

			return city.getName();
		} else {

			return "";
		}
		/*
		 * return city != null && city.getName() != null &&
		 * !"".equals(city.getName()) ? city.getName() : "";
		 */
	}

	public String getPavNamebycityId(long cityid) {

		City city = Server.getInstance().getHotelService().findCity(cityid);

		if (city != null && city.getProvinceid() != null) {

			Province province = Server.getInstance().getHotelService()
					.findProvince(city.getProvinceid());
			System.out.println(province);
			if (province != null) {

				return province.getName();
			} else {

				return "";
			}

		} else {

			return "";
		}
		/*
		 * return city != null && city.getName() != null &&
		 * !"".equals(city.getName()) ? city.getName() : "";
		 */
	}

	public String gethotelname(long id) {

		return Server.getInstance().getHotelService().findHotel(id).getName();
	}

	public String getcarstorenameByID(String carstoreid) {

		return Server.getInstance().getCarService().findCarstore(
				Long.parseLong(carstoreid)).getAbbrname();
	}

	// 取得下级帐号的个数信息
	public String getxiajishidaili(long agentid) {
		String strReturn = "0";
		// 取得下级帐号的个数信息
		List listcount = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"select count(*) as zongshu from T_CUSTOMERAGENT where C_PARENTID='"
								+ agentid + "'", null);
		Map map = (HashMap) listcount.get(0);
		strReturn = map.get("zongshu").toString();
		return strReturn;
	}

	// 取得下级分销商的个数信息
	public String getxiajifenxiaoshang(long agentid) {
		String strReturn = "0";
		// 取得下级帐号的个数信息
		List listcount = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"select count(*) as zongshu from T_CUSTOMERAGENT where C_PARENTID='"
								+ agentid + "' and C_AGENTJIBIE=2 ", null);
		Map map = (HashMap) listcount.get(0);
		strReturn = map.get("zongshu").toString();
		return strReturn;
	}

	/**
	 * 根据代理商的类型id得到代理商是属于省代理，市代理，分销商 。
	 * 
	 * @return
	 */
	public String getAgentTypeName(int jibie) {
		int id = jibie;
		String strReturn = "";
		if (id == 4) {
			strReturn += "平台";
		} else if (id == 5) {
			strReturn += "会员";
		} else {
			if (jibie < 4) {
				jibie += 1;
			}
			if (jibie > 5) {
				jibie -= 1;
			}
			strReturn = convertNumber(jibie) + "级";
		}

		return strReturn;
	}

	/**
	 * 暂只支持十位内转换。待扩展。
	 * 
	 * @param number
	 * @return
	 */
	public String convertNumber(int number) {
		String retstr = "";
		String[] numstr = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九",
				"十" };
		if (number > 10) {
			String[] bstr = { "十", "百", "千", "万" };
			String num = String.valueOf(number);
			for (int i = num.length(); i > 0; i--) {
				char x = num.charAt(i);
			}

		} else {
			retstr = numstr[number];
		}
		return retstr;
	}

	/**
	 * String 转换为Number
	 * 
	 * @param numstr
	 * @param clas
	 * @return
	 */
	public <T> T numberValueof(Object numstr, Class<T> clas) {

		try {
			Method method = clas.getMethod("valueOf", String.class);
			T number = (T) clas.newInstance();
			return (T) method.invoke(number, numstr.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object ret = 0;
		return (T) ret;
	}

	/**
	 * 根据类型，sql 查询 或取所需信息
	 * 
	 * @param <T>
	 * @param cls
	 * @param sql
	 * @return
	 */
	public <T> T findBySql(Class<T> cls, String sql) {
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		if (list.size() > 0) {
			Map m = (Map) list.get(0);
			try {
				return (T) this.setFiledfrommap(cls, m);
			} catch (Exception e) {
				System.out.println("B2b2backAction:findBySql ERROR:");
				e.printStackTrace();
				return null;
			}
		}
		return null;

	}

	// 得到业务系统类型定义
	public String getyewuleixing(int leixingid) {
		switch (leixingid) {
		case 0:
			return "虚拟账户充值";
		case 1:
			return "国内机票";
		case 2:
			return "国际机票";
		case 3:
			return "国内酒店";
		case 4:
			return "国际酒店";
		case 5:
			return "充值业务";
		case 6:
			return "火车票业务";
		case 7:
			return "租车业务";
		case 8:
			return "旅游业务";
		case 9:
			return "加盟奖励";
		}
		return "";
	}

	public Map<Integer, String> getRebatbusinessTypes() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 1; i <= 5; i++) {
			map.put(i, getyewuleixing(i));
		}
		return map;
	}

	/**
	 * @return 获取当前时间
	 */
	public Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());

	}

	public String getrebatevalue(long index_type, long index_agenttype,
			List<Rebaterule> listrebate) {
		String strReturn = "";
		for (int i = 0; i < listrebate.size(); i++) {
			if (listrebate.get(i).getAgenttypeid() == index_type
					&& listrebate.get(i).getRuletypeid() == index_agenttype) {
				strReturn = listrebate.get(i).getRebatvalue().toString();
			}
		}
		return strReturn;
	}

	// /**
	// * 取得B2B支付方式
	// *
	// * @param paymethod
	// * @return
	// */
	// public static String getB2BPayMethod(int paymethod) {
	// switch (paymethod) {
	// case 1:
	// return "网上支付";
	// case 2:
	// return "门市付款";
	// case 3:
	// return "票到付款";
	// case 4:
	// return "虚拟账户支付";
	// case 5:
	// return "月结";
	// }
	// return "";
	//
	// }

	// 得到业务系统类型定义
	public String getVmoneyType(String leixingid) {
		String strTypeName = "";
		if (leixingid.equals("0")) {
			strTypeName = "虚拟账户充值";
		} else if (leixingid.equals("1")) {
			strTypeName = "机票订单消费";
		} else if (leixingid.equals("2")) {
			strTypeName = "酒店订单消费";
		} else if (leixingid.equals("3")) {
			strTypeName = "旅游订单消费";
		} else if (leixingid.equals("4")) {
			strTypeName = "租车订单消费";
		} else if (leixingid.equals("5")) {
			strTypeName = "手机充值订单消费";
		}
		return strTypeName;
	}

	/**
	 * 得到登录代理商能够得到的返佣金额
	 * 
	 * @param agentid
	 *            代理商id
	 * @param ftotalLiRun
	 *            总利润
	 * @param intYeWuType
	 *            业务类型id
	 * @return
	 */
	public String getAgentRebatevalue(long agentid, Float ftotalLiRun,
			int intYeWuType, int agentjiebie) {
		String strReturn = "";
		// Customeragent customeragent = Server.getInstance().getMemberService()
		// .findCustomeragent(agentid);
		//
		// // 读取返佣规则
		// List<Rebaterule> listrebaterule = Server.getInstance()
		// .getMemberService().findAllRebaterule("", " ORDER BY ID DESC",
		// -1, 0);
		// List<Rebaterule> listrebateTicket = new ArrayList<Rebaterule>();
		// try {
		// for (int i = 0; i < listrebaterule.size(); i++) {
		// if (listrebaterule.get(i).getRuletypeid() == intYeWuType) {
		// // 只取得机票业务的返佣规则，并放入新的list当中
		// listrebateTicket.add(listrebaterule.get(i));
		// }
		// }
		// // 会员的返佣值
		// Float fMembervalue = 0f;
		// for (int i = 0; i < listrebateTicket.size(); i++) {
		// if (listrebateTicket.get(i).getAgenttypeid() == 5) {
		// fMembervalue = listrebateTicket.get(i).getRebatvalue();
		// break;
		// }
		// }
		// // 循环机票返佣规则List,并取出当前登录人所属代理商返佣值
		// // for(int i=0;i<listrebateTicket.size();i++)
		// // {
		// //
		// // if(listrebateTicket.get(i).getAgenttypeid()==agentjiebie)
		// // {
		// // //当前登录人所属代理商的返佣值
		// // Float frebate=listrebateTicket.get(i).getRebatvalue();
		// // //如果当前登录人所属代理商为运营商，则返利100%
		// // if(getLoginUserAgent().getId()==46)
		// // {
		// // //取得会员的返佣值
		// // frebate=fMembervalue;
		// // }
		// // Float fMoney=frebate*ftotalLiRun;
		// // strReturn=fMoney.toString();
		// // }
		// // }
		//
		// Float fMoney = fMembervalue * ftotalLiRun;
		// // 对利润值进行进到个位，保留整数
		// int intfmoney = fMoney.intValue();
		strReturn = ftotalLiRun.intValue() + "";
		// } catch (Exception ex) {
		// strReturn = "0";
		// }
		return strReturn;
	}

	/**
	 * @param value
	 * @return###0.00 数字格式化保留两位小数
	 */
	public float dceimalFormat(float value) {
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("###0.00");
		String v = format.format(value);
		return Float.valueOf(v);
	}

	/**
	 * 从map转换为对象
	 * 
	 * @param <T>
	 * @param t
	 * @param map
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException
	 */
	public <T> T setFiledfrommap(Class t, Map map) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException, NoSuchFieldException {
		Iterator<Map.Entry<String, String>> iterator = map.entrySet()
				.iterator();
		T tt = (T) t.newInstance();
		System.out.println(map.size());
		for (Map.Entry<String, String> entry = null; iterator.hasNext();) {
			entry = iterator.next();
			String paraname = entry.getKey();
			Object val = entry.getValue();
			paraname = paraname.substring(0, 1).toUpperCase()
					+ paraname.substring(1);
			Method getm = t.getMethod("get" + paraname, null);
			String type = getm.getReturnType().getSimpleName();
			if (type.equals("Integer") || type.equals("int")) {
				val = Integer.valueOf(val.toString());
			}
			if (type.equals("long") || type.equals("Long")) {
				val = Long.valueOf(converNull(val, '0').toString());
			}
			if (type.equals("float") || type.equals("Float")) {
				val = Float.valueOf(val.toString());
			}
			Method method = t.getMethod("set" + paraname, getm.getReturnType());

			method.invoke(tt, val);
		}
		return tt;
	}

	public void getgejifan(int type, Hotelorder hotelorder) throws Exception {
		Double lirun = 0.00;// 初始化一个利润...每返利一个就增加一个...最后平台得利润等于总利润减去这个利润

		Customeruser cust = Server.getInstance().getMemberService()
				.findCustomeruser(hotelorder.getMemberid());// 取创建人ID..相当如当前人

		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(cust.getAgentid());// 当前加盟商ID
		String login_jibie = customeragent.getAgentjibie() + "";// 当前加盟商级别

		Double price = hotelorder.getProfits();// 订单总利润
		System.out.println("总利润==" + price);
		// 取出会员返利
		Float userrebvaule = 0f;// 初始化会员的返利比例
		Float userfan = 0f;// 初始化会员得返利值

		List<Rebaterule> listuserrebate = Server.getInstance()
				.getMemberService().findAllRebaterule(
						" where 1=1 and " + Rebaterule.COL_ruletypeid
								+ " =2 and " + Rebaterule.COL_agenttypeid
								+ " =5", "", -1, 0);
		if (listuserrebate.size() > 0) {
			userrebvaule = listuserrebate.get(0).getRebatvalue(); // 会员的返利比例
			userfan = userrebvaule
					* Float.parseFloat(hotelorder.getProfits() + "");// 会员的返利比例*总利润=会员的返利值
		}
		if (cust.getProfits() == null) {
			cust.setProfits(0.0f);
		}
		cust.setProfits(cust.getProfits() + userfan);// 增加会员的返利
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				cust);
		System.out.println("会员利润==" + userfan);
		lirun += userfan;

		// 会员返利结束,开始添加记录
		Rebaterecord record = new Rebaterecord();
		record.setOrdernumber(String.valueOf(hotelorder.getId()));
		record.setRebatemoney(userfan);
		record.setYewutype(2);
		record.setRebateagentjibie(Integer.parseInt(login_jibie));
		record.setRebateagentid(customeragent.getId());
		record.setRebatetime(getCurrentTime());
		record.setChildagentid(0);
		String memo = "通过" + getyewuleixing(type) + ",会员:"
				+ cust.getLoginname();

		memo += "得到返佣" + userfan + "元";
		record.setRebatememo(memo);
		Server.getInstance().getMemberService().createRebaterecord(record);

		// 添加记录结束
		// 添加订单记录开始
		List<Guest> listGuest = Server.getInstance().getHotelService()
				.findAllGuest(
						" WHERE 1=1 AND " + Guest.COL_orderid + " ="
								+ hotelorder.getId(), " ORDER BY ID DESC ", -1,
						0);
		if (listGuest.size() > 0) {
			for (int a = 0; a < listGuest.size(); a++) {
				Guest guest = listGuest.get(a);
				guest.setUserfan(Double.parseDouble(userfan / listGuest.size()
						+ ""));
				Server.getInstance().getHotelService().updateGuestIgnoreNull(
						guest);
			}
		}

		//
		if (login_jibie.endsWith("4")) {// 如果当前登陆者所属平台会员

			// System.out.println("判断加盟商级别,当前为平台");
			// if (customeragent.getRebatemoney() == null) {
			// customeragent.setRebatemoney(0.00);
			// }
			// customeragent.setRebatemoney(customeragent.getRebatemoney()
			// + Double.parseDouble(price - lirun + ""));
			// Server.getInstance().getMemberService().updateCustomeragent(
			// customeragent);

			// 返利结束,开始添加记录
			Rebaterecord record_cu = new Rebaterecord();
			record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
			record_cu.setRebatemoney(Float.parseFloat(price - lirun + ""));
			record_cu.setYewutype(2);
			record_cu.setRebateagentjibie(customeragent.getAgentjibie());
			record_cu.setRebateagentid(customeragent.getId());
			record_cu.setRebatetime(getCurrentTime());
			record_cu.setChildagentid(0);
			String memo_cu = "通过" + getyewuleixing(type) + ","
					+ getAgentTypeName(customeragent.getAgentjibie());

			memo_cu += "得到返佣" + Double.parseDouble(price - lirun + "") + "元";

			record_cu.setRebatememo(memo_cu);
			Server.getInstance().getMemberService().createRebaterecord(
					record_cu);

			// 添加记录结束
			// 添加订单记录开始
			// List<Guest> listGuest=
			// Server.getInstance().getHotelService().findAllGuest(" WHERE 1=1
			// AND "+Guest.COL_orderid+" ="+hotelorder.getId(), " ORDER BY ID
			// DESC ", -1, 0);
			if (listGuest.size() > 0) {
				for (int a = 0; a < listGuest.size(); a++) {
					Guest guest = listGuest.get(a);
					guest.setPlatfan(Double.parseDouble(price - lirun + "")
							/ listGuest.size());
					Server.getInstance().getHotelService()
							.updateGuestIgnoreNull(guest);
				}
			}
			//

		} else {
			System.out.println("判断加盟商级别,当前不是平台");
			String angenId = customeragent.getParentstr();// 得到当前会员所属加盟商的ID串
			if (angenId.indexOf(",") != -1) {// 说明上级不是平台
				String[] listangent = angenId.split(",");

				for (int a = 0; a < listangent.length; a++) {

					if (listangent[a] != null
							&& !listangent[a].toString().equals(" ")) {

						Customeragent cus = Server.getInstance()
								.getMemberService().findCustomeragent(
										Long.parseLong(listangent[a].trim()));

						List<Rebaterule> listangentrebate = Server
								.getInstance().getMemberService()
								.findAllRebaterule(
										" where 1=1 and "
												+ Rebaterule.COL_ruletypeid
												+ " =" + type + " and "
												+ Rebaterule.COL_agenttypeid
												+ " =" + cus.getAgentjibie(),
										"", -1, 0);
						System.out.println("判断加盟商级别,当前不是平台,当前是"
								+ getAgentTypeName(cus.getAgentjibie()));

						if (listangentrebate.size() > 0) {
							Float angentRebatvalue = listangentrebate.get(0)
									.getRebatvalue();// 循环时候,当前加盟商返利比例
							Float angentfan = angentRebatvalue
									* Float.parseFloat(hotelorder.getProfits()
											+ "");// 循环时候,当前加盟商返利比例计算出来得返利值

							// if (cus.getRebatemoney() == null) {
							//
							// cus.setRebatemoney(0.00);
							// }

							// cus
							// .setRebatemoney(cus.getRebatemoney()
							// + angentfan);
							Server.getInstance().getMemberService()
									.updateCustomeragent(cus);
							// 返利结束,开始添加记录
							Rebaterecord record_cu = new Rebaterecord();
							record_cu.setOrdernumber(String.valueOf(hotelorder
									.getId()));
							record_cu.setRebatemoney(angentfan);
							record_cu.setYewutype(2);
							record_cu.setRebateagentjibie(cus.getAgentjibie());
							record_cu.setRebateagentid(cus.getId());
							record_cu.setRebatetime(getCurrentTime());
							record_cu.setChildagentid(0);
							String memo_cu = "通过" + getyewuleixing(type) + ","
									+ getAgentTypeName(cus.getAgentjibie());

							memo_cu += "得到返佣" + angentfan + "元";

							record_cu.setRebatememo(memo_cu);
							Server.getInstance().getMemberService()
									.createRebaterecord(record_cu);

							// 添加记录结束

							System.out.println("当前是"
									+ getAgentTypeName(cus.getAgentjibie())
									+ ",利润==" + angentfan);

							lirun += angentfan;
							// 添加订单记录

							/*
							 * if (id == 0) { strReturn = "一级代理"; } else if (id ==
							 * 1) { strReturn = "二级代理"; } else if (id == 2) {
							 * strReturn = "三级代理"; } else if (id == 4) {
							 * strReturn = "平台"; } else if (id == 5) { strReturn =
							 * "会员"; }
							 * 
							 */
							if (listGuest.size() > 0) {
								for (int b = 0; b < listGuest.size(); b++) {
									Guest guest = listGuest.get(b);
									if (cus.getAgentjibie() == 0) {// 一级代理

										guest
												.setOnefan(Double
														.parseDouble(angentfan
																/ listGuest
																		.size()
																+ ""));
									}
									if (cus.getAgentjibie() == 1) {// 二级代理

										guest
												.setTwofan(Double
														.parseDouble(angentfan
																/ listGuest
																		.size()
																+ ""));
									}
									if (cus.getAgentjibie() == 2) {// 三级代理

										guest
												.setThreefan(Double
														.parseDouble(angentfan
																/ listGuest
																		.size()
																+ ""));
									}

									Server.getInstance().getHotelService()
											.updateGuestIgnoreNull(guest);
								}
							}

						}

					}

				}

			}

			// 剩下全部返给当前加盟商

			// if (customeragent.getRebatemoney() == null) {
			// customeragent.setRebatemoney(0.00);
			// }
			// customeragent.setRebatemoney(customeragent.getRebatemoney()
			// + Double.parseDouble(price - lirun + ""));
			Server.getInstance().getMemberService().updateCustomeragent(
					customeragent);
			// 返利结束,开始添加记录
			Rebaterecord record_cu = new Rebaterecord();
			record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
			record_cu.setRebatemoney(Float.parseFloat((price - lirun + "")));
			record_cu.setYewutype(2);
			record_cu.setRebateagentjibie(customeragent.getAgentjibie());
			record_cu.setRebateagentid(customeragent.getId());
			record_cu.setRebatetime(getCurrentTime());
			record_cu.setChildagentid(0);
			String memo_cu = "通过" + getyewuleixing(type) + ","
					+ getAgentTypeName(customeragent.getAgentjibie());

			memo_cu += "得到返佣" + Float.parseFloat((price - lirun + "")) + "元";

			record_cu.setRebatememo(memo_cu);
			Server.getInstance().getMemberService().createRebaterecord(
					record_cu);

			// 添加记录结束

			if (listGuest.size() > 0) {
				for (int b = 0; b < listGuest.size(); b++) {
					Guest guest = listGuest.get(b);
					if (customeragent.getAgentjibie() == 0) {// 一级代理

						guest.setOnefan(Double.parseDouble(price - lirun
								/ listGuest.size() + ""));
					}
					if (customeragent.getAgentjibie() == 1) {// 二级代理

						guest.setTwofan(Double.parseDouble(price - lirun
								/ listGuest.size() + ""));
					}
					if (customeragent.getAgentjibie() == 2) {// 三级代理

						guest.setThreefan(Double.parseDouble(price - lirun
								/ listGuest.size() + ""));
					}

					Server.getInstance().getHotelService()
							.updateGuestIgnoreNull(guest);
				}
			}

		}

	}

	// 获取总保险费用
	public float getINSURMONEYPrice(Long orderinfoId) {

		float money = 0f;

		String sql = "SELECT ISNULL(SUM(C_INSURPRICE),0) AS INSURMONEY FROM " +
				"T_PASSENGER  WHERE C_ORDERID ="
				+ orderinfoId + " AND C_STATE<>12 ";

		System.out.println(sql);

		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		if (list.size() > 0) {
			Map map = (Map) list.get(0);
			String imoney = map.get("INSURMONEY").toString();
			money += Float.valueOf(imoney);
		}

		return money;
	}

	/**
	 * @param orderinfo
	 *            订单
	 * @param count
	 *            退废人数
	 * @param sxf
	 *            手续费
	 * @param takeinsur
	 *            是否退保险
	 * @throws Exception
	 */
	public void takeoutRebate(Orderinfo orderinfo, float sxf, boolean takeinsur)
			throws Exception {
		int type = 1;
		if (ServletActionContext.getServletContext().getAttribute(
				"vmoneyservice") != null) {
			type = 2;
		}

		String ordernumber = orderinfo.getOrdernumber();

		String countsql = "SELECT TOP 1 (SELECT COUNT(*)  FROM T_PASSENGER WHERE C_ORDERID="
				+ orderinfo.getId()
				+ " AND C_STATE=12) AS PCOUNT,"
				+ "(SELECT COUNT(*)  FROM T_REBATERECORD WHERE C_ORDERNUMBER='"
				+ orderinfo.getOrdernumber()
				+ "') AS RCOUNT FROM T_REBATERECORD";
		Map cmap = (Map) Server.getInstance().getSystemService()
				.findMapResultBySql(countsql, null).get(0);
		int tfpcount = Integer.valueOf(cmap.get("PCOUNT").toString());
		int rcount = Integer.valueOf(cmap.get("RCOUNT").toString());
		if (rcount != 0 && tfpcount == 0) {// 表示订单乘机人全部退废
			String where = " WHERE  " + Rebaterecord.COL_ordernumber + "='"
					+ ordernumber + "' AND " + Rebaterecord.COL_rebatemoney
					+ ">0   AND " + Rebaterecord.COL_rebateagentid + "!="
					+ orderinfo.getBuyagentid();
			List<Rebaterecord> listrecord = null;
			IMemberService service = Server.getInstance().getMemberService();
			listrecord = service.findAllRebaterecord(where, "", -1, 0);// 不包含机票采购商。
			for (Rebaterecord record : listrecord) {
				record.setId(0);
				record.setRebatetype(type);
				System.out.println(record.getRebatemoney());
				record.setRebatemoney(0 - record.getRebatemoney());

				record.setRebatetime(this.getCurrentTime());
				record.setRebatememo("订单"
						+ orderinfo.getOrdernumber()
						+ " "
						+ B2borderinfoAction.getStateToString(orderinfo
								.getOrderstatus()) + ",扣除账户 "
						+ record.getRebatemoney() + "元");
				service.createRebaterecord(record);
				if (record.getRebatetype() == 2) {// 如果是虚拟账户记录
					new CustomeragentServiceImpl().addAgentvmoney(record
							.getRebateagentid(), record.getRebatemoney());
				}
			}
		} else {// 部分乘机人退费票
			String sql = " SELECT COUNT(*) count FROM T_PASSENGER WHERE C_ORDERID="
					+ orderinfo.getId() + " AND C_STATE<>12";
			Map infomap = (Map) Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null).get(0);
			int pcount = Integer.valueOf(infomap.get("count").toString());
			Map<Long, float[]> map = this.getAgentlevelrebate(orderinfo
					.getBackpointinfo(), pcount);

			for (Map.Entry<Long, float[]> entry : map.entrySet()) {
				long key = entry.getKey();
				float value = entry.getValue()[0];
				if (orderinfo.getBuyagentid() != key) {// 订单采购商支付时已留点故不计入虚拟账户
					String memo = "订单"
							+ orderinfo.getOrdernumber()
							+ B2borderinfoAction.getStateToString(orderinfo
									.getOrderstatus()) + ",扣除账户 " + value + "元";
					createRebateRecord(orderinfo.getOrdernumber(), 0 - value,
							1, key, orderinfo.getBuyagentid(), 2, memo);
				}

			}
		}
		String statusstr=B2borderinfoAction.getStateToString(orderinfo.getOrderstatus());
		
		String memo = "订单"
				+ orderinfo.getOrdernumber()+  statusstr + ",手续费共计："+sxf+"元。账户返还 "
				+ orderinfo.getReturnprice()+"元";
        if(orderinfo.getIsbackinsur()==2){
        	float bxcb=this.getInsurcb(orderinfo.getBackpointinfo());
			memo+="（退还保险："+bxcb+"/人）";
		}
		this.createRebateRecord(orderinfo.getOrdernumber(), orderinfo
				.getReturnprice(), 1, orderinfo.getBuyagentid(), orderinfo
				.getBuyagentid(), type, memo);// 机票采购商 退 票款。
		this.createRebateRecord(orderinfo.getOrdernumber(), sxf, 1, 46, orderinfo
				.getBuyagentid(), type, "订单"+orderinfo.getOrdernumber()+statusstr+",扣取手续费"+sxf+"元");// 机票采购商 退 票款。
		

	}

	public boolean vmoneyService() {
		if (ServletActionContext.getServletContext().getAttribute(
				"vmoneyservice") != null) {
			return true;
		}
		return false;
	}

	/**
	 * 此方法用于为各级别分润。
	 * 
	 * @param orderinfo
	 *            订单
	 * @param businesstype
	 *            业务类型
	 * @param paymethod
	 *            支付方式
	 * @throws Exception
	 */
	public void sharingRebate(Orderinfo orderinfo, int pcount) throws Exception {
		System.out.println(orderinfo.getPaymethod());

		int i = 1;
		if (orderinfo.getPaymethod() == 4) {
			i = 2;
		}
		Map<Long, float[]> map = this.getAgentlevelrebate(orderinfo
				.getBackpointinfo(), pcount);

		for (Map.Entry<Long, float[]> entry : map.entrySet()) {
			long key = entry.getKey();
			float ticketrebate = entry.getValue()[0];
			float insurrebate = entry.getValue()[1];
			if (orderinfo.getBuyagentid() == key) {// 订单采购商支付时已留点故不计入虚拟账户
				createRebateRecord(orderinfo.getOrdernumber(), ticketrebate, 1,
						key, orderinfo.getBuyagentid(), 1, null);// 机票利润不算入虚拟账户
				//陈星修改...保险不返
				
				//createRebateRecord(orderinfo.getOrdernumber(), insurrebate,1, 
				//		key, orderinfo.getBuyagentid(), i, null);// 保险利润算入虚拟账户
			} else {

				createRebateRecord(orderinfo.getOrdernumber(), insurrebate
						+ ticketrebate, 1, key, orderinfo.getBuyagentid(), i,
						null);
			}

		}
	}

	/**
	 * 创建返佣将记录
	 * 
	 * @param ordernumber
	 *            订单好
	 * @param rebatmoney
	 *            返佣金额
	 * @param bustype
	 *            业务类型
	 * @param agentid
	 *            加盟商ID 扣除或增加的加盟商
	 * @param type
	 *            类型。1.网银支付，不计入账户。2.虚拟账户充值或支付，记入。3.网银虚拟账户充值
	 * @throws Exception
	 */
	public void createRebateRecord(String ordernumber, float rebatmoney,
			int bustype, long agentid, long fromagentid, int type, String memo)
			throws Exception {
		
		float vmoney_a = new CustomeragentServiceImpl().getTotalVmoney(agentid);
		if (rebatmoney != 0) {
			Rebaterecord record = new Rebaterecord();
			if (ordernumber != null) {
				record.setOrdernumber(ordernumber);
			} else {
				record.setOrdernumber("");
			}
			record.setRebatemoney(rebatmoney);
			record.setCustomerid(this.getLoginUserId());
			record.setRebatetype(type);
			record.setYewutype(bustype);
			// record.setRebateagentjibie(getrebatagent.getAgentjibie());
			record.setRebateagentid(agentid);
			record.setChildagentid(fromagentid);
			record.setRebatetime(this.getCurrentTime());
			record.setChildagentid(0);
			if (memo == null)
				memo = "通过" + getyewuleixing(bustype)
						+ (rebatmoney > 0 ? "获得" : "扣除") + rebatmoney + "元";
			
			
			if (type != 1) {
				float vmoney = new CustomeragentServiceImpl()
						.getTotalVmoney(agentid);
				memo += ".当前账户余额：" + (vmoney + rebatmoney);
				new CustomeragentServiceImpl().addAgentvmoney(agentid,
						rebatmoney);
			}
			record.setRebatememo(memo);
			Server.getInstance().getMemberService().createRebaterecord(record);
			
			if(bustype==1||bustype==2){
			long orderid=Long.parseLong(ordernumber.replaceAll("A", ""))-10000;
			//创建操作记录
			Orderinfo orderinfonew=Server.getInstance().getAirService().findOrderinfo(orderid);
			float newvmoney = new CustomeragentServiceImpl().getTotalVmoney(agentid);
			try{
				Orderinforc orderinforc = new Orderinforc();
				orderinforc.setCustomeruserid(getLoginUserId());
				orderinforc.setOrderinfoid(orderinfonew.getId());
				orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
				orderinforc.setContent("虚拟账户支付--" + this.getLoginUser().getLoginname()+ "执行了虚拟账户支付,支付前余额:"+vmoney_a+",支付金额:"+rebatmoney+",当前余额:"+newvmoney);
				orderinforc.setSuouserid(orderinfonew.getUserid());
				orderinforc.setState(orderinfonew.getOrderstatus());
				orderinforc.setCustomeruserid(getLoginUserId());
				Server.getInstance().getAirService().createOrderinforc(orderinforc);
			}
			catch(Exception ex){
				System.out.println("创建操作记录异常："+ex.getMessage());
			}
			}
		}

	}

	/**
	 * 
	 * 待改进。韩 得到登录代理商能够得到的返佣金额
	 * 
	 * @param agentid
	 *            要查看的代理商id
	 * @param totalLiRun
	 *            总利润
	 * @param intYeWuType
	 *            业务类型id
	 * @param agentjiebie
	 *            订单所属加盟商。
	 * @return
	 */
	public String getAgentRebatevalue_info(long agentid, float totalLiRun,
			int intYeWuType, int agentjiebie) {
		List<Rebaterule> listrebaterule = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object listrebate = session.getAttribute("listrebaterule");
		if (listrebate == null) {
			listrebaterule = Server.getInstance().getMemberService()
					.findAllRebaterule(" WHERE C_RULETYPEID=" + intYeWuType,
							" ORDER BY ID DESC", -1, 0);
		} else {
			listrebaterule = (List<Rebaterule>) listrebate;
		}
		int cjibie = this.getLoginUserAgent().getAgentjibie();
		Map<Integer, Float> allrebat = new HashMap<Integer, Float>();
		float mlirun = 0f;
		float plirun = 0f;
		for (Rebaterule rule : listrebaterule) {
			if (rule.getAgenttypeid() == 5) {
				mlirun = rule.getRebatvalue() * totalLiRun;
			}
			if (rule.getAgenttypeid() == 4) {
				plirun = rule.getRebatvalue() * totalLiRun;

			}
		}
		if (agentjiebie == 4) {
			plirun = totalLiRun - mlirun;
		}
		allrebat.put(5, mlirun);
		allrebat.put(4, plirun);
		if (agentjiebie != 4) {
			float otherliru = mlirun + plirun;
			for (int i = 0; i < agentjiebie; i++) {
				if (i != 4 && i != 5) {
					for (Rebaterule rule : listrebaterule) {
						if (rule.getAgenttypeid() == i) {
							float lirun = rule.getRebatvalue() * totalLiRun;
							otherliru += lirun;
							// allrebat.put(i, lirun);
						}
					}
				}

			}
			if (cjibie != 4) {
				allrebat.put(cjibie, totalLiRun - otherliru);
			}
		}

		return formatZrate(allrebat.get(cjibie));

	}

	public float formatfloatMoney(Number money) {
		format.applyPattern("###0.00");
		try {
			String result = format.format(money);
			return Float.valueOf(result);
		} catch (Exception e) {
			if (money != null) {
				return Float.valueOf(money.toString());
			} else {
				return 0;
			}
		}
	}
	
	public int formatflotMoneyB2B(Float money){
		if(money.toString().indexOf(".")!=-1){
		String m=money.toString();
			m=m.replace(".", "@");
			return Integer.parseInt(m.split("@")[0]);
		}else{
			
			return 0;
		}
		
	}

	/**
	 * 获取登录者应得利润
	 * 
	 * @param fdstr
	 * @return[0：订单利润][1: 保险利润]
	 */

	public float[] getNationTicketrebat(String fdstr, int pcount) {
		Customeragent agent = this.getLoginsessionagent();
		Map<Long, float[]> rebate = getAgentlevelrebate(fdstr, pcount, agent
				.getId());
		float[] moneys = rebate.get(agent.getId());
		return moneys;
		// float otherrebate = 0f;
		// float totalrebate = 0f;
		// long loginagentid = agent.getId();
		// // 46 加盟商id ,3.3：自己留点,1850.0 ：价格：,3.3：总返点：
		// String[] agentstrs = fdstr.split("@");
		// for (String agentstr : agentstrs) {
		// String[] infos = agentstr.split(",");
		// String agentid = infos[0];// 加盟商id
		// String fd = infos[1];// 自己留点
		// String ordermoney = infos[2];// 订单价格
		// String allrebat = infos[3];// 总返点
		// float totalmoney = Float.valueOf(ordermoney);
		// totalrebate = totalmoney * Float.valueOf(allrebat) / 100;// 总利润
		// float agentfd = Float.valueOf(fd);
		// try {
		// float agentmoney = totalmoney * agentfd / 100;
		// if (this.getLoginsessionagent().getAgenttype() != 1) {
		// if (Long.valueOf(agentid) == loginagentid) {
		//
		// return formatfloatMoney(Math.floor(1.00 * agentmoney));
		// }
		// } else {
		// if (Long.valueOf(agentid) != getLoginsessionagent().getId()) {
		// otherrebate += formatfloatMoney(Math
		// .floor(1.00 * agentmoney));
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// return formatfloatMoney(Math.floor(totalrebate) - otherrebate);

	}

	/**
	 * @param fdstr
	 * @param pcount
	 * @param ids
	 * @return
	 */
	public Map<Long, float[]> getAgentlevelrebate(String fdstr, int pcount,
			long... ids) {
		return getAgentlevelrebate(fdstr, null, pcount, ids);
	}

	/**
	 * @return 获取各级别获取返佣MAP
	 */
	/**
	 * @param fdstr
	 *            订单返利记录
	 * @param pcount
	 *            //订单人数
	 * @param ids
	 *            //要获取的加盟商。
	 * @return
	 */
	public Map<Long, float[]> getAgentlevelrebate(String fdstr,
			Float theordermoney, int pcount, long... ids) {
		long currentagentid = 0;
		if (ids != null && ids.length > 0) {
			currentagentid = ids[0];
		}
		Map<Long, float[]> map = new HashMap<Long, float[]>();
		float otherrebate = 0f;
		// 46 加盟商id ,3.3：自己留点,1850.0 ：价格：,3.3：总返点：
		try {
			String[] agentstrs = fdstr.split("@");
			boolean first = true;
			float totalmoney = 0.0f;// 订单总金额
			float totalrebate = 0.0f;// 订单总利润
			float insurrebate = 0f;// 保险利润
			try {
				String insurstrs = agentstrs[agentstrs.length - 1];
				String[] insrusinfos = insurstrs.split("[|]");
				float insurcost = Float.valueOf(insrusinfos[0]);// 保险成本
				float insruprice = Float.valueOf(insrusinfos[1]);// 保险金额
				
				int bxp=20;
				HttpSession session = ServletActionContext.getRequest().getSession();
				if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
					bxp=Integer.parseInt(session.getAttribute("INSURPRICE").toString().trim());
				}
				
				int count = (int) insruprice / bxp;// 保险份数
				insurrebate = insruprice - (count * insurcost);
				agentstrs[agentstrs.length - 1] = "";// 去掉最后一项
			} catch (Exception e) {

			}
			long buyagentid = 0l;
			int i = 0;
			for (String agentstr : agentstrs) {
				if (agentstr.length() > 0) {
					String[] infos = agentstr.split(",");
					long agentid = Long.valueOf(infos[0]);// 加盟商id
					if (i == agentstrs.length - 2) {
						buyagentid = agentid;
					}
					String fd = infos[1];// 自己留点
					if (first) {
						String allrebat = infos[3];// 总返点
						String ordermoney = infos[2];// 订单价格
						if (theordermoney != null && theordermoney > 0) {
							ordermoney = theordermoney + "";
						}
						totalmoney = Float.valueOf(ordermoney) * pcount;
						totalrebate = totalmoney * Float.valueOf(allrebat)/ 100;// 总利润
					}
					float agentfd = Float.valueOf(fd);// 返点

					float agentmoney = totalmoney * agentfd / 100;
					float[] rebate = new float[2];
					if (agentid != 46l) {// 此处绑定了运营商ID 各级返点所去小数归平台所有
						float money = formatfloatMoney(Math
								.floor(1.00 * agentmoney));
						if(agentid==1){//我们暗扣不去小数，避免出现运营对账多出我们所去小数。
							 money = formatfloatMoney(agentmoney);
						}
						rebate[0] = money;
						if (agentid == buyagentid) {
							rebate[1] = insurrebate;
						}
						map.put(agentid, rebate);
						if (currentagentid > 0 && agentid == currentagentid) {
							return map;
						}
						otherrebate += money;
						
					}

					first = false;
					i++;
				}
			}
			float[] yyrebate = new float[2];
			yyrebate[0] = formatfloatMoney(Math.floor(totalrebate
					- otherrebate));
			if (46 == buyagentid) {
				yyrebate[1] = insurrebate;
			}
			map.put(46l, yyrebate);// 此处绑定了运营商ID
			// return formatfloatMoney(Math.floor(totalrebate) - otherrebate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取保险成本
	 * @return
	 */
	public float getInsurcb(String fdstr){
		try{
		String[] agentstrs = fdstr.split("@");
		String insurstrs = agentstrs[agentstrs.length - 1];
		String[] insrusinfos = insurstrs.split("[|]");
		float insurcost = Float.valueOf(insrusinfos[0]);// 保险成本
		return insurcost;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 10f;
	}
	public float gethuiyouprice(Float zreate, Float reatevalue, Float price) {
		//System.out.println("zreate:"+zreate+",reatevalue:"+reatevalue+",price:"+price);
		Float fmoney = zreate * reatevalue;
		fmoney = fmoney * price;
		// 对利润值进行进到个位，保留整数
		int intfmoney = fmoney.intValue();
		fmoney = Float.parseFloat(intfmoney + "");
		
		
		return fmoney;	
		
		
	}

	/**
	 * 得到登录代理商能够得到的返佣值
	 * 
	 * @param agentid
	 *            代理商id
	 * @param ftotalLiRun
	 *            总利润
	 * @param intYeWuType
	 *            业务类型id
	 * @return
	 */
	public String getAgentRebatePoint(long agentid, int intYeWuType,
			int agentjiebie) {
		String strReturn = "";
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(agentid);

		List<Rebaterule> listrebaterule = (List<Rebaterule>) ActionContext
				.getContext().getSession().get("rabaterule");
		List<Rebaterule> listrebateTicket = new ArrayList<Rebaterule>();
		try {
			for (int i = 0; i < listrebaterule.size(); i++) {
				if (listrebaterule.get(i).getRuletypeid() == intYeWuType) {
					// 只取得机票业务的返佣规则，并放入新的list当中
					listrebateTicket.add(listrebaterule.get(i));
				}
			}
			// 会员的返佣值
			Float fMembervalue = 0f;
			for (int i = 0; i < listrebateTicket.size(); i++) {
				if (listrebateTicket.get(i).getAgenttypeid() == 5) {
					fMembervalue = listrebateTicket.get(i).getRebatvalue();
					break;
				}
			}
			// 循环机票返佣规则List,并取出当前登录人所属代理商返佣值
			// for(int i=0;i<listrebateTicket.size();i++)
			// {
			//		 
			// if(listrebateTicket.get(i).getAgenttypeid()==agentjiebie)
			// {
			// //当前登录人所属代理商的返佣值
			// Float frebate=listrebateTicket.get(i).getRebatvalue();
			// //如果当前登录人所属代理商为运营商，则返利100%
			// if(getLoginUserAgent().getId()==46)
			// {
			// //取得会员的返佣值
			// frebate=1-fMembervalue;
			// }
			Float fMoney = fMembervalue;
			strReturn = fMoney.toString();
			// }
			// }
		} catch (Exception ex) {
			strReturn = "0";
		}
		return strReturn;
	}

	/**
	 * 根据代理商id得到虚拟账户余额
	 * 
	 * @param id
	 *            代理商id
	 * @return 虚拟账户余额
	 * @throws Exception
	 */
	public String getAgentMoney_B2B(long id) throws Exception {
		String strret = "0";
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(id);
		if (customeragent != null) {
			strret = converNull(customeragent.getVmoney(), 0) + "";
		}
		return strret;
	}

	/**
	 * 会员退票从代理商虚拟账户中减去之前的返佣值
	 * 
	 * @param strOrderID
	 *            订单编号
	 * @param strMemo
	 *            订单备注
	 * @return 是否成功 0=失败，1=成功
	 * @throws Exception
	 */
	public void delrebatefromagent(String strOrderID, String strMemo)
			throws Exception {
		List<Rebaterecord> listrecord = Server.getInstance().getMemberService()
				.findAllRebaterecord(
						"where C_ORDERNUMBER='" + strOrderID
								+ "' and C_REBATEMONEY>0", "", -1, 0);
		for (int i = 0; i < listrecord.size(); i++) {
			Rebaterecord rebaterecord = new Rebaterecord();
			Customeragent customeragent = Server.getInstance()
					.getMemberService().findCustomeragent(
							listrecord.get(i).getRebateagentid());
			// 减去返佣值
			customeragent.setVmoney(customeragent.getVmoney()
					- listrecord.get(i).getRebatemoney());
			Server.getInstance().getMemberService()
					.updateCustomeragentIgnoreNull(customeragent);

			// 返佣记录里面添加相应的负的返佣值
			rebaterecord = listrecord.get(i);
			rebaterecord.setId(0);
			rebaterecord
					.setRebatetime(new Timestamp(System.currentTimeMillis()));
			rebaterecord.setRebatemoney(-rebaterecord.getRebatemoney());
			rebaterecord.setRebatememo(strMemo);
			Server.getInstance().getMemberService().createRebaterecord(
					rebaterecord);
		}
	}

	public String getTripnamebyid(long id) {
		Tripline tripline = Server.getInstance().getTripService().findTripline(
				id);
		return tripline.getName();
	}

	public String getTripFcitybyid(long id) {
		Tripline tripline = Server.getInstance().getTripService().findTripline(
				id);
		return getCityName_b2b(tripline.getCityid());
	}

	public String getTripEcitybyid(long id) {
		Tripline tripline = Server.getInstance().getTripService().findTripline(
				id);
		return getCityName_b2b(tripline.getEndcityid());
	}

	public String getTripTypeName_B2B(long id) {
		Tripline tripline = Server.getInstance().getTripService().findTripline(
				id);
		Triplinetype triptype = Server.getInstance().getTripService()
				.findTriplinetype(tripline.getTypeid());
		return triptype.getName();
	}

	/**
	 * 根据城市ID获取城市名称
	 * 
	 * @param cityId
	 * @return
	 */
	public String getCityName_b2b(long cityId) {
		String strLanguage = "";
		if (ActionContext.getContext().getSession().get("language") != null) {
			strLanguage = ActionContext.getContext().getSession().get(
					"language").toString();
		} else {
			strLanguage = "0";
		}
		City city = Server.getInstance().getHotelService().findCitybylanguage(
				cityId, Integer.parseInt(strLanguage));
		return city != null && !"".equals(city.getName()) ? city.getName() : "";
	}

	public Double getUserFanByOrderID(long id) {

		Hotelorder hotelorder = Server.getInstance().getHotelService()
				.findHotelorder(id);
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(hotelorder.getMemberid());
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());

		List<Rebaterule> listuserrebate = Server.getInstance()
				.getMemberService().findAllRebaterule(
						" where 1=1 and " + Rebaterule.COL_ruletypeid
								+ " =2 and " + Rebaterule.COL_agenttypeid
								+ " =5", "", -1, 0);
		if (listuserrebate.size() > 0) {

			return hotelorder.getProfits()
					* listuserrebate.get(0).getRebatvalue();
		}

		return 0.0;
	}

	/**
	 * 获取订单各级返点，利润
	 * 
	 * @param strBackPointInfo
	 *            订单返点信息
	 * @param type
	 *            1=获取返点 2=获取金额
	 * @return
	 */
	public String GetBenJiLiudian(String strBackPointInfo, int type) {
		Customeragent agent = this.getLoginsessionagent();
		long loginid = agent.getId();
		String strReturn = "";
		String[] strarr = strBackPointInfo.split("@");
		if (strarr.length > 0) {
			for (int i = 0; i < strarr.length; i++) {
				String strTemp = strarr[i].replace(",", "|");
				String[] strarrinfo = strTemp.split("[|]");
				if (strarrinfo.length > 0) {
					for (int j = 0; j < strarrinfo.length; j++) {
						// 如果当前登录的代理商ID==返点记录里面的代理商ID
						String id = strarrinfo[0];
						if (id.equals(loginid + "")) {
							if (type == 1) {
								strReturn = strarrinfo[1];
							} else if (type == 2) {
								// 票面价
								float fprice = Float.parseFloat(strarrinfo[2]);
								float frate = Float.parseFloat(strarrinfo[1]);
								strReturn = String.valueOf(fprice * frate);
							}
							break;
						}
					}
				}
			}

		}
		return strReturn;
	}
	public String getPayOrderNum(String orderno){
		String ret="暂无交易信息";
		String where=" WHERE 1=1 AND "+Traderecord.COL_ordercode+" ='"+orderno+"' and "+Traderecord.COL_state+" =1";
		List<Traderecord>list=Server.getInstance().getMemberService().findAllTraderecord(where, "", -1, 0);
		if(list.size()>0&&list.get(0).getBankcode()!=null){
			ret=list.get(0).getBankcode();
		}else{
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo((Long.parseLong(orderno.replace("A", ""))-10000));
			if(orderinfo.getRelationorderid()!=null&&orderinfo.getRelationorderid()>0){
				Orderinfo orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
				
				String where2=" WHERE 1=1 AND "+Traderecord.COL_ordercode+" ='"+orderinfo2.getOrdernumber()+"' and "+Traderecord.COL_state+" =1";
				List<Traderecord>list2=Server.getInstance().getMemberService().findAllTraderecord(where2, "", -1, 0);
				if(list2.size()>0&&list2.get(0).getBankcode()!=null){
					ret=list2.get(0).getBankcode();
				}
			}
			
		}
		return ret;
	}
	//根据QQ类型id获取QQ类型名称
	public String GetQQtypeNameByTypeID(long id){
		
		return Server.getInstance().getMemberService().findQqtypenew(id).getName();
		
	}
	//根据QQ类型id获取QQ号码list
	public List<Qqinfonew> GetQQinfoNEWListbyQQtypeID(long id){
		
		return Server.getInstance().getMemberService().findAllQqinfonew(" where 1=1 and "+Qqinfonew.COL_typeid+" ="+id, " ORDER BY "+Qqinfonew.COL_state, -1, 0);
		
	}
	
	/**
	 * 新生成订单方法
	 * @param listsegmenginfo  航程信息
	 * @param listpassenger    乘机人信息
	 * @param orderinfo        订单信息
	 * @param zratelist        政策信息
	 * @param insurances       保险信息
	 * @param issavepassenger  是否保存常用旅客
	 * @param orderflag        订单创建类型  1=查询预订下订单，2=PNR导入创建订单，3=b2c网站创建订单
	 * @return
	 * @throws Exception
	 */
	public String CreateOrder_back(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{
		String strReturn="NOPNR";
		
		String s_returnpnr="";
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 2;
		// 是否生成PNR
		int intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
	
		// 是否生成外部订单
		int intIsCreateOuterOrder =1; //0不生成外部订单   1生成外部订单
		// 是否按照原政策信息已经生成外订单
		int intIsCreated = 1;//0按照本地政策   1按照最优政策
		
		int IsWhy=1; //0不分润接口   1分润接口
		
		String B2cWebPrice="";//B2C网站利润
		String WebPayPrice="";//C端支付价
		
		int chengrenNUM=0;//成人数量
		
		if(orderflag==2){//PNR导入的,不生成PNR
			intIsCreatePNR=0;
		}
		
		
		
		Zrate zrate2 = Server.getInstance().getAirService().findZrate(zratelist.get(0));
		if(zrate2.getAgentid()>10){//如果是本地政策供应商 不生成外部订单  使用本地政策
			intIsCreated=0;
			intIsCreateOuterOrder=0;
		}
		
		//如果是今日政策,不生成PNR,今日会生成PNR
		
		/*if(zrate2.getAgentid()==6){//如果是本地政策供应商 不生成外部订单  使用本地政策
			
			intIsCreated=0;
			intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
		}*/
		
		//如果是票盟  不匹配最优政策--成人
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==1){//如果是票盟
			System.out.println("票盟的政策,成人订单,不匹配最优了,按照本地政策");
			intIsCreated=0;
			intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		//如果是票盟  不匹配最优政策--儿童  下单到今日
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==2){//如果是票盟
			System.out.println("票盟的政策,儿童订单,下单给今日");
			intIsCreated=1;
			intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		
		
		//开始判断是否生成pnr和外部订单
		String wherefig=" where 1=1 and "+Sysconfig.COL_name+" ='ispnrandorder'";
		List<Sysconfig>listfig=Server.getInstance().getSystemService().findAllSysconfig(wherefig, " ORDER BY ID ", -1, 0);
		if(listfig!=null&&listfig.size()>0){
			if(listfig.get(0).getValue().equals("-1")){
				System.out.println("不生成PNR和外部订单了");
				intIsCreatePNR=0;
				intIsCreateOuterOrder=0;
				intIsCreated=0;
			}
			
		}
		//
		
		
	//----------------------------------------------------------------------------------------------------------------
		
		
		String jinriprice="";
	
	
		
		// 最优政策
		Zrate bestzrate = new Zrate();
		String[] bxcounts = insurances.trim().split(",");
		//本地订单旧政策
		String strOldZrateValue="0";
		//最优政策
		String strBestZrateValue="0";
		//黑屏PAT票价，燃油，机建
		String pat_Price="0";
		String pat_Fuleprice="0";
		String pat_airportfee="0";
		//用于PAT:A价格发生变化时，订单提醒
		String strOldTotalPrice="0";
		String strNewTotalPrice="0";
		
		try{
			//订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			
			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize=listsegmenginfo.size();
			/******************循环航程list,并创建订单开始*************************/
			for(int s=0;s<intsegmentsize;s++)
			{
				List<Passenger> listpassengermodel=new ArrayList<Passenger>();
				Orderinfo orderinfomodel = new Orderinfo();
				orderinfomodel.setCreatetime(orderinfo.getCreatetime());
				orderinfomodel.setCustomeruserid(orderinfo.getCustomeruserid());
				orderinfomodel.setSaleagentid(orderinfo.getSaleagentid());
				orderinfomodel.setBuyagentid(orderinfo.getBuyagentid());
				orderinfomodel.setContactmobile(orderinfo.getContactmobile());
				orderinfomodel.setPaystatus(orderinfo.getPaystatus());
				orderinfomodel.setOrderstatus(orderinfo.getOrderstatus());
				orderinfomodel.setPaymethod(orderinfo.getPaymethod());
				orderinfomodel.setCurrplatfee(orderinfo.getCurrplatfee());
				orderinfomodel.setLanguage(orderinfo.getLanguage());
				orderinfomodel.setOrdertype(orderinfo.getOrdertype());
				orderinfomodel.setPnr(orderinfo.getPnr());
				
				if(orderinfo.getContactemail()!=null){
				orderinfomodel.setContactemail(orderinfo.getContactemail());
				}
				if(orderinfo.getContacttel()!=null){
					orderinfomodel.setContacttel(orderinfo.getContacttel());
				}
				
				if(orderinfo.getPostmoney()!=null){
				orderinfomodel.setPostmoney(orderinfo.getPostmoney());
				}
				if(orderflag==2){
					orderinfomodel.setPnrtxt(orderinfo.getPnrtxt());
					orderinfomodel.setPattxt(orderinfo.getPattxt());
				}
				orderinfomodel.setBigpnr(orderinfo.getBigpnr());
				orderinfomodel.setContactname(orderinfo.getContactname());
				if(orderinfo.getMemo()!=null){
				orderinfomodel.setMemo(orderinfo.getMemo());
				}
				Segmentinfo segmentinfo=listsegmenginfo.get(s);
				/*****订单信息赋值开始************************************************************/
				/****本地政策赋值开始*****************************************/
				Zrate zrate = Server.getInstance().getAirService().findZrate(zratelist.get(s));
				
				orderinfo.setPolicyid(zrate.getId());
				orderinfo.setPolicyagentid(zrate.getAgentid());
				orderinfo.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
				//判断开始.判断是否是固定饭店用户;
				
				/*if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
					zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
				}*/
				if(zrate.getWorkstatus()!=null){
				orderinfomodel.setPickonename(zrate.getWorkstatus());//office
				}
				if(zrate.getSpeed()!=null){
					if(zrate.getAgentid()==5){
					orderinfomodel.setPickonephone(zrate.getSpeed());//出票速度
					}
					if(zrate.getAgentid()==6){
					orderinfomodel.setPickonephone(zrate.getSpeed()+"分钟");//出票速度
					}
				}
				orderinfomodel.setPolicyid(zrate.getId());//政策ID
				if(getLoginAgent().getBigtype()==2){//固定返点
					orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(getLoginAgent().getFixedvalue())));// 分销商返点
				}else{
					orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate.getRatevalue())));// 分销商返点
				}
				
				
			
				
				//记录当前政策值
				strOldZrateValue=String.valueOf(orderinfomodel.getFenxiaoshangfandian());
				orderinfomodel.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfomodel.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfomodel.setExtpolicyid(zrate.getOutid()); // 外部政策id
				orderinfomodel.setPostmobile(zrate.getWorktime()+"-"+zrate.getAfterworktime());
				segmentinfo.setAgentid(zrate.getAgentid());
				segmentinfo.setRatevalue(zrate.getRatevalue());
				
				segmentinfo.setZrateid(zrate.getId());
				segmentinfo.setLanguage(0);
				segmentinfo.setZrate(zrate);
				/****本地政策赋值结束*****************************************/ 
				
				/****订单信息赋值结束************************************************************/
				float subfuelfee = 0;
				float subairportfee = 0;
				float subprice = 0;
				/****乘机人信息赋值开始************************************************************/
				for (int i = 0; i < listpassenger.size(); i++) {
					if (listpassenger.get(i).getName().trim().length() > 0) {
						
						 if (listpassenger.get(i).getPtype() == 1) {
								chengrenNUM++;
							}
							int bxcount = 0;
							   bxcount=Integer.valueOf(bxcounts[i].trim());
						
						   Passenger passenger =new Passenger();
						   
						   Float bxp=20f;
						   HttpSession session = ServletActionContext.getRequest().getSession();
							if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
								bxp=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
							}
						   
						   passenger.setInsurprice(bxcount*bxp);
					       passenger.setName(listpassenger.get(i).getName());
					       passenger.setPtype(listpassenger.get(i).getPtype());
					       passenger.setIdnumber(listpassenger.get(i).getIdnumber());
					       passenger.setIdtype(listpassenger.get(i).getIdtype());
					       passenger.setState(listpassenger.get(i).getState());
					       passenger.setLanguage(listpassenger.get(i).getLanguage());
					       passenger.setAirportfee(listpassenger.get(i).getAirportfee());
					       passenger.setFuelprice(listpassenger.get(i).getFuelprice());
					       passenger.setPrice(listpassenger.get(i).getPrice());
					       passenger.setBirthday(listpassenger.get(i).getBirthday());
						if (passenger.getPtype() == 1  && orderflag!=2) {
							passenger.setPrice(segmentinfo.getPrice());
							passenger.setAirportfee(segmentinfo.getAirportfee());
							passenger.setFuelprice(segmentinfo.getFuelfee());
						} else if (passenger.getPtype() == 2 && orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(getRoundPrice(segmentinfo.getFuelfee(), 2));
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
							}
						} else if(orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(0f);
							// 儿童婴儿价
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 10));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 10));
							}
						}
						subprice += passenger.getPrice();
						subfuelfee += passenger.getFuelprice();
						subairportfee += passenger.getAirportfee();
						passenger.setDiscount(segmentinfo.getDiscount());
						listpassengermodel.add(passenger);
					}
				}
				/****乘机人信息赋值结束************************************************************/
				if(orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().equals(""))
				{
					System.out.println("小PNR导入，创建订单 PNR:"+orderinfomodel.getPnr());
					s_returnpnr=orderinfo.getPnr();
				}
				else if(orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().equals(""))
				{
					System.out.println("大PNR导入，创建订单  PNR:"+orderinfomodel.getBigpnr());
					s_returnpnr=orderinfomodel.getBigpnr();
				}
				else if(intIsCreatePNR==1)
				{
					if (intCreatePNRType == 1) {
					s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					} else {
					//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
						s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassengermodel, orderinfo);
					}
					System.out.println("**********************生成的PNR编码："+ s_returnpnr);
					if(s_returnpnr.equals("-1")||s_returnpnr.equals("NOPNR")){
					//如果没有生成PNR...不创建外部订单,创建内部订单
						intIsCreateOuterOrder=0;
						intIsCreatePNR=0;
						s_returnpnr="123456";
						 return "NOPNR";
					}else{
						
						if(intCreatePNRType==2){//51创建PNR
							String newpnr="";
							String pnrtxt="";
							String pattxt="";
							
							if(s_returnpnr.indexOf("@")!=-1){
							newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];
							}else{
							newpnr=	s_returnpnr;
							}
							orderinfomodel.setPattxt(pattxt);
							orderinfomodel.setPnrtxt(pnrtxt);
							orderinfomodel.setPnr(newpnr);
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								 return "NOPNR";
							}
						}else{//黑屏创建
							
							String pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr, "", "");
							
							
							
							//原始的用
							int ind=0;
							
							if(pnrtxt.indexOf("+")>0){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							//放大不规范的用
							
							/*for(int a=0;a<4;a++){
							pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							if(pnrtxt.indexOf("      -")!=-1){
								break;
							}
							}
							
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							if(pnrtxt.indexOf(" -")!=-1){
								System.out.println("pnrtxt:"+pnrtxt);
								pnrtxt=pnrtxt.replaceAll(" -", "");
							}*/
							
							
							System.out.println("pnrtxt:"+pnrtxt);
							
							//NKG170
							/*if(pnrtxt!=null&&pnrtxt.indexOf("NKG170")!=-1){
								
								pnrtxt=pnrtxt.split("[.]NKG170")[0]+".NKG170";
							}*/
							
							String strPat="PAT:A";
							String str=""+listpassenger.get(0).getName()+"CHD";
							for(int w=0;w<listpassenger.size();w++){
								if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
									strPat="PAT:A*CH";
									orderflag=4;
									break;
								}
							}
								
					
							
							/*if(pnrtxt.indexOf(str)!=-1){
								strPat="PAT:A*CH";
								
							}*/
							
							
							
							String pattxt=Server.getInstance().getTicketSearchService().commandFunction2(strPat, "", "");
							System.out.println("pattxt:"+pattxt);
							if(pattxt.indexOf(">")!=-1){
								pattxt=pattxt.replaceAll(">", "");
							}
							
							
							if(pnrtxt!=null&&pnrtxt.indexOf("URC220")!=-1){
								pnrtxt=pnrtxt.split("[.]URC220")[0]+".URC220";
							}
							
							
							System.out.println("pattxt:"+pattxt);
							/*newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];*/
							orderinfomodel.setPattxt(pattxt);
							orderinfomodel.setPnrtxt(pnrtxt);
							orderinfomodel.setPnr(s_returnpnr);
							
							
							String	strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
						
							orderinfomodel.setBigpnr(strBigPNR);
							
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								//生成外部订单失败,取消PNR
								Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
								
								 return "NOPNR";
							}
							
							
						}
					}
				}
				else
				{
					s_returnpnr="123456";
				}
				
				// 判断是否生成PNR
				if (s_returnpnr.equals("NOPNR")) {
					strReturn = "NOPNR";
					
					break;
				}
				// 机建费
				orderinfomodel.setTotalairportfee(subairportfee);
				// 燃油费
				orderinfomodel.setTotalfuelfee(subfuelfee);
				// 总机票价格+平台费用
				orderinfomodel.setTotalticketprice(subprice);// 存入数据库中的数据
				//
				float totalallprice=orderinfomodel.getTotalairportfee()+orderinfomodel.getTotalfuelfee()+orderinfomodel.getTotalticketprice();
				strOldTotalPrice=String.valueOf(totalallprice);
				if((orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().trim().equals("")) || (orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().trim().equals("")))
				{
					System.out.println("PNR导入订单信息");
				}
				else
				{
					
					String strBigPNR = "无";
					//只有51book才获取大PNR
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
					/*if (orderinfomodel.getPolicyagentid() == 5) {
						strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
					}
					orderinfomodel.setBigpnr(strBigPNR);*/
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
				}
				
				//orderinfomodel.setPostmoney(0);
				orderinfomodel.setPassengerlist(listpassengermodel);
				listOrderinfo.add(orderinfomodel);
			}
			/******************循环航程list,并创建订单结束*************************/
			
			//如果生成PNR则创建订单，否则提示创建订单失败
			if (!s_returnpnr.equals("NOPNR")) {
				for (int j = 0; j < listOrderinfo.size(); j++) {
				  Orderinfo	orderinfonew = listOrderinfo.get(j);

					Segmentinfo seginfo = listsegmenginfo.get(j);
					//*****************************************************//
					//Pat:a取得黑屏中票价--------------------------------------PAT-------------------------------------------------------
					String strPatInfo="";
		
					//if(intIsCreatePNR==1 && orderflag==4){//old
					if(intIsCreatePNR==1){
						
						 System.out.println("核对黑屏价格-原来价格:"+seginfo.getParvalue());
						
						 strPatInfo=orderinfonew.getPattxt();
					
					try
					{
					
					
						  
						  String[] strpatItem=strPatInfo.split(" ");
						  for(int i=0;i<strpatItem.length;i++) 
						  {
							  if(!strpatItem[i].trim().equals(""))
							  {
								  //票价
								  if(strpatItem[i].trim().indexOf("FARE:")>=0 && pat_Price.equals("0"))
								  {
									  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
								  }
								  //燃油费
								  if(strpatItem[i].trim().indexOf("YQ:")>=0)
								  {
									  pat_Fuleprice=strpatItem[i].trim().replace("YQ:CNY", "");
								  }
								  /*//机建费
								  if(strpatItem[i].trim().indexOf("TAX:")>=0)
								  {
									  pat_airportfee=strpatItem[i].trim().replace("TAX:CNY", "");
								  }*/
							  }
						  }
					  
					  //核对黑屏中价格信息与航程中价格信息是否一样
					  Float f_segmentprice=0f;
					  Float f_segmentfuelprice=0f;
					  Float f_segmentairportfee=0f;
				      f_segmentprice=Float.parseFloat(pat_Price);
				      f_segmentfuelprice=Float.parseFloat(pat_Fuleprice);
				      f_segmentairportfee=Float.parseFloat(pat_airportfee);
				      
				    
				    	
				    	  
				    	  float sub_price=0;
				    	  float sub_fuelfee=0;
				    	  float sub_airportfee=0;
				    	 
				    	 for (Passenger passenger:orderinfonew.getPassengerlist()) 
				    	  {
				    		  System.out.println("循环");
				    		 
				    		  
				    		  passenger.setAirportfee(f_segmentairportfee);
				    		  passenger.setFuelprice(f_segmentfuelprice);
				    		  passenger.setPrice(f_segmentprice);
				    		  sub_price += passenger.getPrice();
							  sub_fuelfee += passenger.getFuelprice();
						      sub_airportfee += passenger.getAirportfee();
				    	  }
				    	  
				    	  
				    	/*  for(int p=0;p<orderinfonew.getPassengerlist().size();p++){
				    		  System.out.println("循环");
				    		 
				    		  
				    		  orderinfonew.getPassengerlist().get(p).setAirportfee(f_segmentairportfee);
				    		  orderinfonew.getPassengerlist().get(p).setFuelprice(f_segmentfuelprice);
				    		  orderinfonew.getPassengerlist().get(p).setPrice(f_segmentprice);
				    		  sub_price +=  orderinfonew.getPassengerlist().get(p).getPrice();
							  sub_fuelfee +=  orderinfonew.getPassengerlist().get(p).getFuelprice();
						      sub_airportfee +=  orderinfonew.getPassengerlist().get(p).getAirportfee();
				    	  }*/
				    	  
				    	  //修改订单中的价格信息
				    	  // 机建费
				    	  orderinfonew.setTotalairportfee(sub_airportfee);
					      // 燃油费
				    	  orderinfonew.setTotalfuelfee(sub_fuelfee);
						  // 总机票价格+平台费用
				    	  orderinfonew.setTotalticketprice(sub_price);
				    	  
				    	  
				    	  System.out.println("?????????????:"+sub_airportfee+","+sub_fuelfee+","+sub_price);
				    	  
				    	  
				    	  
				    	  
					  
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
					System.out.println("**********************PAT:A："+ strPatInfo);
					System.out.println("**********************黑屏中：票价"+ pat_Price+"|||燃油："+pat_Fuleprice+"||||机建"+pat_airportfee);
					}
					
					//************************pat-----------------------------------------------PAT-------------------****************************//
					
					
					
					
					// 如果是其他供应商政策，则不生成外部订单-----------------------判断是否创建外部------------------------------------------
					if ((orderinfonew.getPolicyagentid() == 3 ||orderinfonew.getPolicyagentid() == 6
							|| orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2 || orderinfonew.getPolicyagentid() == 46)
							&& intIsCreateOuterOrder == 1) {
						intIsCreateOuterOrder = 1;
						System.out.println("属于平台政策：是否创建外部订单："+ intIsCreateOuterOrder);
					} else {
						intIsCreateOuterOrder = 0;
						// 不属于平台政策，则可以直接支付订单
						if(orderinfonew.getPaymethod()==2 || orderinfonew.getPaymethod()==3)
						{
							orderinfonew.setOrderstatus(2);
						}
						else
						{
						   orderinfonew.setOrderstatus(1);
						}
						System.out.println("不属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
						
						
					}
					
					
					
					
					
					//是否创建外部订单开始----------------------------------------------------------------------------------------------
					if (intIsCreateOuterOrder == 1) {
						try {
							//如果是普通政策，则直接按照最优政策生成订单
							if(intIsCreated==0)
							{
								
								bestzrate=seginfo.getZrate();
								//计算利润
								System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
								WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
								
								if(WebPayPrice.equals("0.0")){
									WebPayPrice="0";
								}else{
									
									WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
									
								}
								
								//从新计算价格开始
								
								float newprice=0f;
								float baoxianprice=0f;
								int l = 0;
								for (Passenger passeng : orderinfonew.getPassengerlist()) {
									passeng.setOrderid(orderinfonew.getId());
									
									
									// 获取最优政策，更新乘机人信息
									// Created 
									// 2011-10-18
									if (bestzrate != null
											&& bestzrate.getRatevalue() != null
											&& bestzrate.getAgentid() != null) {
										
										
										
										
										//计算保险
										float bxcb=20f;
										HttpSession session = ServletActionContext.getRequest().getSession();
										if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
											bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
										}
										
										
										
										int bxcount = 0;
										try{
										bxcount=Integer.valueOf(bxcounts[l].trim());
										}catch(Exception e){
										}
										if (bxcount> 0) {							
											passeng.setInsurprice(bxcount*bxcb);
											if (listsegmenginfo.size()==2) {
												if (!new B2bAirSearchAction().isInInsrutime(
														listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
													if (j == 0) {
														int count = 1;
														if (Integer.valueOf(bxcount) > 1) {
															count = (int) Math.ceil(Integer
																	.valueOf(bxcount) / 2.0);
														}
													
														passeng.setInsurprice(bxcb*count);
													} else {
														int count = 1;
														if (Integer.valueOf(bxcount) > 1) {
															count = (int) Math.floor(Integer
																	.valueOf(bxcount) / 2.0);
						
															passeng.setInsurprice(bxcb*count);
														}
													}

												} else {//在一个保险期内
													if (j == 0) {
														
													//	passeng.setInsurance(insurance.getId());
														passeng.setInsurprice(bxcount*bxcb);
													}
												}
											} else {
												passeng.setInsurprice(bxcount*bxcb);

											}
											
										}
										
										//计算保险结束
										
										
										
										
										
										
										if (passeng.getPtype() == 1) {
											passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
													.getRatevalue()))/100);
											
										} else if (passeng.getPtype() == 2) {
											passeng.setAirportfee(0f);
											
											//平台创建儿童订单
											if(orderflag!=2)
											{
												/*passeng.setFuelprice(getRoundPrice(seginfo
														.getFuelfee(), 2));*/
												if (seginfo.getDiscount() > 100) {
													passeng.setPrice(getRoundPrice(seginfo
															.getParvalue(), 2));
												} else {
													passeng.setPrice(getRoundPrice(seginfo
															.getYprice(), 2));
												}
											}
											
										} else {
											passeng.setAirportfee(0f);
											passeng.setFuelprice(0f);
											// 儿童婴儿价
											if(orderflag!=2)
											{
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 10));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 10));
											}
											}
											
										}
										newprice += passeng.getPrice();
										// 获取最优政策，更新乘机人信息
										// 结束
										baoxianprice+=passeng.getInsurprice();
									}
									l++;
									
								}
								
								//计算结束
								
								B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
								
								
								B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
								
								System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice+",baoxianprice:"+baoxianprice);
								String bxprice="0";
								if(baoxianprice==0){
									bxprice="0";
								}else{
									bxprice=(Math.floor(Float.parseFloat(baoxianprice+""))+"").substring(0, (Math.floor(Float.parseFloat(baoxianprice+""))+"").indexOf("."));
								}
								WriteLog.write("下单前记录价格信息-未匹配最优政策","C支付价格:"+B2cWebPrice+",利润:"+WebPayPrice+",保险价格:"+bxprice);
								orderinfonew.setB2cprofit(Integer.parseInt(WebPayPrice)+Integer.parseInt(bxprice)+"");//B2C利润
								orderinfonew.setCclientpayprice(Integer.parseInt(B2cWebPrice)+Integer.parseInt(bxprice)+"");//c端支付价
								orderinfonew.setIspayhthy(IsWhy);
								
								
								//如果是儿童 创建51
								for(int w=0;w<listpassenger.size();w++){
									if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
										orderinfonew.setPolicyagentid(6l);
										break;
									}
								}
								
								
								
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							
							
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								intIsCreated = 0;
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else if(orderinfonew.getPolicyagentid() == 6){
									if (strExtOrderNumber.indexOf("@") != -1) {
										String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
										orderinfonew.setExtorderid(strExtOrderArrpnr[0].trim());
										orderinfonew.setPnr(strExtOrderArrpnr[1].trim());
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
								
										jinriprice=strExtOrderArrpnr[3].trim();
										
										/*	if(!strExtOrderArrpnr[2].trim().equals(orderinfonew.getRatevalue())){//如果政策返点和下单返点不一致,更新价格
										System.out.println("今日生成订单的返点和下单的返点不一致,下单时候的返点=="+orderinfonew.getRatevalue()+",生成订单的返点=="+strExtOrderArrpnr[2].trim()+",订单总价=="+strExtOrderArrpnr[3].trim());
										orderinfonew.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										orderinfonew.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue())));
										
										//从新计算价格开始
										bestzrate.setAgentid(6l);
										bestzrate.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										
										//float newprice=0f;
										for (Passenger passeng : orderinfonew.getPassengerlist()) {
											passeng.setOrderid(orderinfonew.getId());
											
											
											// 获取最优政策，更新乘机人信息
											// Created By:sunbin
											// 2011-10-18
											if (bestzrate != null
													&& bestzrate.getRatevalue() != null
													&& bestzrate.getAgentid() != null) {
												if (passeng.getPtype() == 1) {
													passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
															.getRatevalue()))/100);
													
												} else if (passeng.getPtype() == 2) {
													passeng.setAirportfee(0f);
													
													//平台创建儿童订单
													if(orderflag!=2)
													{
														passeng.setFuelprice(getRoundPrice(seginfo
																.getFuelfee(), 2));
														if (seginfo.getDiscount() > 100) {
															passeng.setPrice(getRoundPrice(seginfo
																	.getParvalue(), 2));
														} else {
															passeng.setPrice(getRoundPrice(seginfo
																	.getYprice(), 2));
														}
													}
													
												} else {
													passeng.setAirportfee(0f);
													passeng.setFuelprice(0f);
													// 儿童婴儿价
													if(orderflag!=2)
													{
													if (seginfo.getDiscount() > 100) {
														passeng.setPrice(getRoundPrice(seginfo
																.getParvalue(), 10));
													} else {
														passeng.setPrice(getRoundPrice(seginfo
																.getYprice(), 10));
													}
													}
													
												}
												newprice += passeng.getPrice();
												// 获取最优政策，更新乘机人信息
												// 结束
											}
											
											
										}
										
										//计算结束
										
										}*/
										intIsCreated =0;
									}
								}else{
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								//orderinfonew.setReceipt(Integer.parseInt(bestzrate.getGeneral()+""));//政策类型  普通 特殊
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
								System.out.println("按照本地政策，创建外部订单成功，返回结果订单号:"+ strExtOrderNumber);
							} else {
								intIsCreated = 1;
								System.out.println("按照本地政策，创建外部订单失败，返回结果:"+ strExtOrderNumber);
								
								intIsCreateOuterOrder=0;
								System.out.println("按照本地政策，创建外部订单失败，创建本地订单:intIsCreateOuterOrder:"+intIsCreateOuterOrder);
							}
							
							
							}
							else//匹配最优政策
							{
							
								intIsCreated = 1;
							}
						} catch (Exception ex) {
							intIsCreated = 0;
							System.out.println("按照本地政策，创建外部订单失败，异常结果:"
									+ ex.getMessage());
						}
						/*System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						System.out.println("是否生成外部订单标记：" + intIsCreateOuterOrder
								+ " 是否已按照原始政策生成外部订单：" + intIsCreated);*/
					}
					
					//创建外部订单结束---------------------------------------------------------------------------------------------------------
					
					
					// 如果没有按照原始政策，生成外部订单，则按照最优政策信息，再次生成外部订单
					
					//if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
					if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
						// 匹配最优政策，并生成外部订单
						
						System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						try {
							try {
								if(orderinfonew.getPassengerlist().get(0).getPtype()==1)
								{
								bestzrate = Server.getInstance()
										.getRateService().FindZrateByFlight(
												orderinfonew, seginfo,
												orderinfonew.getPassengerlist());
								}else if(orderinfonew.getPassengerlist().get(0).getPtype()==2)
								{
									orderinfonew.setPolicyagentid(6l);
									bestzrate = Server.getInstance()
											.getRateService().FindZrateByFlight(
													orderinfonew, seginfo,
													orderinfonew.getPassengerlist());
									}
								else
								{
									bestzrate =Server.getInstance().getAirService().findZrate(1l);
								}
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									try {
										// 计算价格
										orderinfonew
												.setPolicyid(bestzrate.getId());// 政策ID
										
										if(getLoginAgent().getBigtype()==2){//如果是固定返点
											orderinfonew
											.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(getLoginAgent().getFixedvalue())));// 分销商返点
											
										}else{
											orderinfonew
											.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
													.getRatevalue())));// 分销商返点
											
										}
										
										//记录最优政策返销商返点
										strBestZrateValue=String.valueOf(orderinfonew.getFenxiaoshangfandian());
										orderinfonew.setPolicyagentid(bestzrate
												.getAgentid());// 政策提供商id
										
										
											if(bestzrate.getWorkstatus()!=null){
											orderinfonew.setPickonename(bestzrate.getWorkstatus());//office
											}
											
											if(bestzrate.getSpeed()!=null){
												if(bestzrate.getAgentid()==5){
												orderinfonew.setPickonephone(bestzrate.getSpeed());//出票速度
												}
												if(bestzrate.getAgentid()==6){
													orderinfonew.setPickonephone(bestzrate.getSpeed()+"分钟");//出票速度
												}
											}
											
											
										orderinfonew
												.setRatevalue(dceimalFormat(bestzrate
														.getRatevalue()));// 折扣
										orderinfonew.setExtpolicyid(bestzrate
												.getOutid()); // 外部政策id
										System.out.println("调用最优政策方法,成功,政策为=="
												+ bestzrate);
									} catch (RuntimeException e) {
										System.out
												.println("调用最优政策方法,出现异常,异常信息："
														+ e.getMessage());
										e.printStackTrace();
									}
								}else{
									
									
									bestzrate=Server.getInstance().getAirService().findZrate(zratelist.get(j));
								}

							} catch (RuntimeException e) {
								System.out.println("调用最优政策方法,出现异常,异常信息："
										+ e.getMessage());
								e.printStackTrace();
							}
							seginfo.setZrate(bestzrate);
							// 创建外部订单，方法调用
							
							System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
							WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
							
							if(WebPayPrice.equals("0.0")){
								WebPayPrice="0";
							}else{
								WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
								
							}
							
							//从新计算价格开始
							
							float newprice=0f;
							float baoxianprice=0f;
							int l = 0;
							
							for (Passenger passeng : orderinfonew.getPassengerlist()) {
								passeng.setOrderid(orderinfonew.getId());
								
								
								// 获取最优政策，更新乘机人信息
								// Created By:cxx
								// 2011-10-18
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									
									
									//计算保险
									float bxcb=20f;
									HttpSession session = ServletActionContext.getRequest().getSession();
									if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
										bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
									}
									int bxcount = 0;
									try{
									bxcount=Integer.valueOf(bxcounts[l].trim());
									}catch(Exception e){
									}
									if (bxcount> 0) {							
										passeng.setInsurprice(bxcount*bxcb);
										if (listsegmenginfo.size()==2) {
											if (!new B2bAirSearchAction().isInInsrutime(
													listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
												if (j == 0) {
													int count = 1;
													if (Integer.valueOf(bxcount) > 1) {
														count = (int) Math.ceil(Integer
																.valueOf(bxcount) / 2.0);
													}
												
													passeng.setInsurprice(bxcb*count);
												} else {
													int count = 1;
													if (Integer.valueOf(bxcount) > 1) {
														count = (int) Math.floor(Integer
																.valueOf(bxcount) / 2.0);
					
														passeng.setInsurprice(bxcb*count);
													}
												}

											} else {//在一个保险期内
												if (j == 0) {
													
												//	passeng.setInsurance(insurance.getId());
													passeng.setInsurprice(bxcount*bxcb);
												}
											}
										} else {
											passeng.setInsurprice(bxcount*bxcb);

										}
										
									}
									
									//计算保险结束
									
									
									
									
									
									
									
									if (passeng.getPtype() == 1) {
										passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue()))/100);
										
									} else if (passeng.getPtype() == 2) {
										passeng.setAirportfee(0f);
										
										//平台创建儿童订单
										if(orderflag!=2)
										{
											/*passeng.setFuelprice(getRoundPrice(seginfo
													.getFuelfee(), 2));*/
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 2));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 2));
											}
										}
										
									} else {
										passeng.setAirportfee(0f);
										passeng.setFuelprice(0f);
										// 儿童婴儿价
										if(orderflag!=2)
										{
										if (seginfo.getDiscount() > 100) {
											passeng.setPrice(getRoundPrice(seginfo
													.getParvalue(), 10));
										} else {
											passeng.setPrice(getRoundPrice(seginfo
													.getYprice(), 10));
										}
										}
										
									}
									newprice += passeng.getPrice();
									// 获取最优政策，更新乘机人信息
									// 结束
									
									if(passeng.getInsurprice()!=null){
									baoxianprice+=passeng.getInsurprice();
									}
									
								}
								l++;
								
							}
							
							//计算结束
							
							B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
							
							
							B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
							
							System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice+",baoxianprice:"+baoxianprice);
							
							String bxprice="0";
							if(baoxianprice==0){
								bxprice="0";
							}else{
								bxprice=(Math.floor(Float.parseFloat(baoxianprice+""))+"").substring(0, (Math.floor(Float.parseFloat(baoxianprice+""))+"").indexOf("."));
								
							}
							
							WriteLog.write("下单前记录价格信息-匹配最优政策","C支付价格:"+B2cWebPrice+",利润:"+WebPayPrice+",保险价格:"+bxprice);
							
							orderinfonew.setB2cprofit(Integer.parseInt(WebPayPrice)+Integer.parseInt(bxprice)+"");//B2C利润
							orderinfonew.setCclientpayprice(Integer.parseInt(B2cWebPrice)+Integer.parseInt(bxprice)+"");//c端支付价
							orderinfonew.setIspayhthy(IsWhy);
							
							/*//如果是儿童 创建51  8000yi
							for(int w=0;w<listpassenger.size();w++){
								if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
									orderinfonew.setPolicyagentid(6l);
									break;
								}
							}*/
							
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								}else if(orderinfonew.getPolicyagentid() == 6){
									if (strExtOrderNumber.indexOf("@") != -1) {
										String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
										orderinfonew.setExtorderid(strExtOrderArrpnr[0].trim());
										orderinfonew.setPnr(strExtOrderArrpnr[1].trim());
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
								
										jinriprice=strExtOrderArrpnr[3].trim();
										
										/*	if(!strExtOrderArrpnr[2].trim().equals(orderinfonew.getRatevalue())){//如果政策返点和下单返点不一致,更新价格
										System.out.println("今日生成订单的返点和下单的返点不一致,下单时候的返点=="+orderinfonew.getRatevalue()+",生成订单的返点=="+strExtOrderArrpnr[2].trim()+",订单总价=="+strExtOrderArrpnr[3].trim());
										orderinfonew.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										orderinfonew.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue())));
										
										//从新计算价格开始
										bestzrate.setAgentid(6l);
										bestzrate.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										
										//float newprice=0f;
										for (Passenger passeng : orderinfonew.getPassengerlist()) {
											passeng.setOrderid(orderinfonew.getId());
											
											
											// 获取最优政策，更新乘机人信息
											// Created By:sunbin
											// 2011-10-18
											if (bestzrate != null
													&& bestzrate.getRatevalue() != null
													&& bestzrate.getAgentid() != null) {
												if (passeng.getPtype() == 1) {
													passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
															.getRatevalue()))/100);
													
												} else if (passeng.getPtype() == 2) {
													passeng.setAirportfee(0f);
													
													//平台创建儿童订单
													if(orderflag!=2)
													{
														passeng.setFuelprice(getRoundPrice(seginfo
																.getFuelfee(), 2));
														if (seginfo.getDiscount() > 100) {
															passeng.setPrice(getRoundPrice(seginfo
																	.getParvalue(), 2));
														} else {
															passeng.setPrice(getRoundPrice(seginfo
																	.getYprice(), 2));
														}
													}
													
												} else {
													passeng.setAirportfee(0f);
													passeng.setFuelprice(0f);
													// 儿童婴儿价
													if(orderflag!=2)
													{
													if (seginfo.getDiscount() > 100) {
														passeng.setPrice(getRoundPrice(seginfo
																.getParvalue(), 10));
													} else {
														passeng.setPrice(getRoundPrice(seginfo
																.getYprice(), 10));
													}
													}
													
												}
												newprice += passeng.getPrice();
												// 获取最优政策，更新乘机人信息
												// 结束
											}
											
											
										}
										
										//计算结束
										
										}*/
										intIsCreated =0;
									}
								} else {
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								System.out.println("按照最优政策创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
								
								//生成外部订单失败,取消PNR
								 //Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfonew.getPnr()+"$XEPNR@", "", "");
								 //return "ERROR";
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("按照最优政策创建外部订单失败，异常信息"
									+ e.getMessage());
							//生成外部订单失败,取消PNR
							//Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfonew.getPnr()+"$XEPNR@", "", "");
							//return "ERROR";
						}
					}

					// 计算总利润，以及留点记录信息
					// 成人总数
					int intadult = 0;
					//儿童总数
					int intchlid=0;
					for (int i = 0; i < orderinfonew.getPassengerlist().size(); i++) {
						if (orderinfonew.getPassengerlist().get(i).getPtype() == 1) {
							intadult++;
						}
						else if (orderinfonew.getPassengerlist().get(i).getPtype() == 2) {
							intchlid++;
						}
						
					}
					Float fzonglirun=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fzonglirun = orderinfonew.getRatevalue()
						* seginfo.getParvalue() / 100 * intadult;
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
						   fzonglirun=0.025f* seginfo.getYprice()/2 * intchlid;
						}
						else
						{
							fzonglirun=listsegmenginfo.get(0).getParvalue()*0.025f*intchlid;
						}
					}
					
					int intzonglirun = fzonglirun.intValue();
					orderinfonew.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));

					// 生成本地订单信息
					orderinfonew.setPaystatus(0);
					
					orderinfonew.setOrderstatus(1);
					
					String str=""+listpassenger.get(0).getName()+"CHD";
					if(orderinfonew.getPnrtxt()!=null&&orderinfonew.getPnrtxt().indexOf(str)!=-1){
						orderinfonew.setRatevalue(0f);	
						orderinfonew.setFenxiaoshangfandian(0f);
					}
					
					if(orderinfonew.getPolicyid()!=null&&orderinfonew.getPolicyagentid()!=null){
						Zrate zrate=ZrateServer.getInstance().findZrate(orderinfonew.getPolicyagentid(), orderinfonew.getPolicyid()+"$*");
						if(zrate!=null&&zrate.getGeneral()!=null){
							orderinfonew.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
						}
					}
					
					
					WriteLog.write("订单信息","订单:"+orderinfonew.toString());
					orderinfonew = Server.getInstance().getAirService().createOrderinfo(orderinfonew);
					
					System.out.println("订单详细信息");
					System.out.println(orderinfonew.toString());
					System.out.println("订单详细信息============");
					System.out.println(orderinfonew.getOrdernumber());
					System.out.println("订单信息==" + orderinfonew);
					System.out.println("订单ID==" + orderinfonew.getId());
					System.out.println("外部订单ID==" + orderinfonew.getExtorderid());

					Segmentinfo segmetemp = listsegmenginfo.get(j);
					segmetemp.setOrderid(orderinfonew.getId());
					// 获取新政策，更新航程信息
					// 
					// 
					if (bestzrate != null && bestzrate.getRatevalue() != null
							&& bestzrate.getAgentid() != null&&orderinfonew.getPassengerlist().get(0).getPtype()==1) {
						Float fsegmentprice=0f;
						if(segmetemp.getParvalue()!=null)
						{
							fsegmentprice= segmetemp.getParvalue();
						}
						else
						{
							fsegmentprice=0f;
						}
						//计算优惠价格
				    	Float fdiscountprice=fsegmentprice*Getliudianvalue(bestzrate.getRatevalue())/100;
				    	int intdiscountprice=fdiscountprice.intValue();
				    	//计算实际结算价格
				    	fsegmentprice =fsegmentprice-intdiscountprice;

						int intsegmentprice = fsegmentprice.intValue();
						segmetemp.setAgentid(bestzrate.getAgentid());
						segmetemp.setRatevalue(bestzrate.getRatevalue());
						segmetemp.setZrateid(bestzrate.getId());
						segmetemp.setPrice(Float.parseFloat(String
								.valueOf(intsegmentprice)));
						segmetemp.setRules(bestzrate.getRemark());
					}
					// 获取新政策，更新航程信息
					// 结束
					segmetemp = Server.getInstance().getAirService()
							.createSegmentinfo(segmetemp);

					System.out.println(orderinfonew.getPassengerlist().size());
					int l = 0;
					float subpricenew = 0;
					float insurprice = 0f;// 保险价格
					Sysconfig sysconfig=Server.getInstance().getSystemService().findSysconfig(1);
					float bxcb=20;
					HttpSession session = ServletActionContext.getRequest().getSession();
					if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
						bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
					}
					for (Passenger passeng : orderinfonew.getPassengerlist()) {
						passeng.setOrderid(orderinfonew.getId());
						int bxcount = 0;
						try{
						bxcount=Integer.valueOf(bxcounts[l].trim());
						}catch(Exception e){
						}
						if (bxcount> 0) {							
							passeng.setInsurprice(bxcount*bxcb);
							if (listsegmenginfo.size()==2) {
								if (!new B2bAirSearchAction().isInInsrutime(
										listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
									if (j == 0) {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.ceil(Integer
													.valueOf(bxcount) / 2.0);
										}
									
										passeng.setInsurprice(bxcb*count);
									} else {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.floor(Integer
													.valueOf(bxcount) / 2.0);
		
											passeng.setInsurprice(bxcb*count);
										}
									}

								} else {//在一个保险期内
									if (j == 0) {
										
									//	passeng.setInsurance(insurance.getId());
										passeng.setInsurprice(bxcount*bxcb);
									}
								}
							} else {
								passeng.setInsurprice(bxcount*bxcb);

							}
							insurprice += passeng.getInsurprice();
						}
						// 获取最优政策，更新乘机人信息
						// Created By:sunbin
						// 2011-10-18
						if (bestzrate != null
								&& bestzrate.getRatevalue() != null
								&& bestzrate.getAgentid() != null) {
							if (passeng.getPtype() == 1) {
								passeng.setPrice(segmetemp.getPrice());
								passeng.setAirportfee(segmetemp
										.getAirportfee());
								passeng.setFuelprice(segmetemp.getFuelfee());
							} else if (passeng.getPtype() == 2) {
								passeng.setAirportfee(0f);
								
								//平台创建儿童订单
								if(orderflag!=2)
								{
									/*passeng.setFuelprice(getRoundPrice(segmetemp
											.getFuelfee(), 2));*/
									if (seginfo.getDiscount() > 100) {
										passeng.setPrice(getRoundPrice(segmetemp
												.getParvalue(), 2));
									} else {
										passeng.setPrice(getRoundPrice(segmetemp
												.getYprice(), 2));
									}
								}
								
							} else {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(0f);
								// 儿童婴儿价
								if(orderflag!=2)
								{
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmetemp
											.getParvalue(), 10));
								} else {
									passeng.setPrice(getRoundPrice(segmetemp
											.getYprice(), 10));
								}
								}
								
							}
							subpricenew += passeng.getPrice();
							// 获取最优政策，更新乘机人信息
							// 结束
						}
						Server.getInstance().getAirService().createPassenger(
								passeng);
						l++;
					}

					// 更新订单总价信息
					if (subpricenew != 0f) {
						// 总机票价格+平台费用
						orderinfonew.setTotalticketprice(subpricenew);// 存入数据库中的数据
					}
					
					//如果是今日,按照今日返回价格
					/*if (orderinfonew.getPolicyagentid()==6) {
						if(jinriprice!=null&&!jinriprice.equals("")){
						Float newprice=	Float.parseFloat(jinriprice)-orderinfonew.getTotalairportfee()-orderinfonew.getTotalfuelfee();
						orderinfonew.setTotalticketprice(newprice);// 存入数据库中的数据
						}
					}*/
					
					
					
					if (j == 0) {
						this.orderinfo1 = orderinfonew;
					} else {
						this.orderinfo2 = orderinfonew;
					}
					System.out.println("***************************返佣信息**************************************");
					System.out.println(orderinfonew.getId());
					
					System.out.println(orderinfonew.getRatevalue());
					Float fparvalue=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fparvalue=seginfo.getParvalue();
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
							fparvalue=getRoundPrice(seginfo.getYprice(), 2);
						}
						else
						{
							fparvalue=seginfo.getParvalue();
						}
					}
					String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfonew.getRatevalue(),
							Getliudianvalue(orderinfonew.getRatevalue()), fparvalue, insurprice);
					
					if(getLoginAgent().getBigtype()==2){
						
						Sysconfig sys = Server.getInstance().getSystemService()
						.findSysconfig(1);
				// 保存当前 保险成本 与购买数量
						String strsub = sys.getValue() + "|" + insurprice;
						strCustomgeragentBackPointInfo="1,0.00,"+fparvalue+","+orderinfonew.getRatevalue()+"@46,"+(orderinfonew.getRatevalue()-Float.parseFloat(getLoginAgent().getFixedvalue()))+","+fparvalue+","+orderinfonew.getRatevalue()+"@"+getLoginAgent().getId()+","+getLoginAgent().getFixedvalue()+","+fparvalue+","+orderinfonew.getRatevalue()+"@"+strsub;
					}
					
					System.out.println(strCustomgeragentBackPointInfo);
					orderinfonew.setFenxiaoshangfandian(Getliudianvalue(orderinfonew.getRatevalue()));
					orderinfonew.setBackpointinfo(strCustomgeragentBackPointInfo);
					//如果是PNR导入创建订单，则所有订单都需要平台确认价格后，才能够进行支付
					String strOrderPnr="";
					if(orderinfonew.getPnr()!=null)
					{
						strOrderPnr=orderinfonew.getPnr();
					}
					else if(orderinfonew.getBigpnr()!=null)
					{
						strOrderPnr=orderinfonew.getBigpnr();
					}
					if((orderflag==2 && getLoginUserAgent().getAgenttype()!=1) || strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456"))
					{
						//待确认订单状态
						//orderinfonew.setOrderstatus(27);
						if(strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456")){
							
							
						}else{
						orderinfonew.setOrderstatus(1);
						}
					}
					//记录是否是PNR导入创建的订单
					if(orderflag==2)
					{
						if(orderinfonew.getMemo()!=null && !orderinfonew.getMemo().equals(""))
						{
						   orderinfonew.setMemo(orderinfonew.getMemo()+"[PNR导入创建]");
						}
						else
						{
							orderinfonew.setMemo("[PNR导入创建]");
						}
					}
					
					//发送短信
					//sendCreateOrderTXTSmstoPassenger(listpassenger, listsegmenginfo,orderinfonew);
					
					
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfonew);
					//创建操作记录
					try{
						Orderinforc orderinforc = new Orderinforc();
						orderinforc.setCustomeruserid(getLoginUserId());
						orderinforc.setOrderinfoid(orderinfonew.getId());
						orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						orderinforc.setContent("创建订单--" + this.getLoginUser().getMembername()+ "创建了订单");
						orderinforc.setSuouserid(orderinfonew.getUserid());
						orderinforc.setState(orderinfonew.getOrderstatus());
						orderinforc.setCustomeruserid(getLoginUserId());
						Server.getInstance().getAirService().createOrderinforc(orderinforc);
					}
					catch(Exception ex){
						System.out.println("创建操作记录异常："+ex.getMessage());
					}
					//最终订单价格
					float totalnewprice=orderinfonew.getTotalairportfee()+orderinfonew.getTotalfuelfee()+orderinfonew.getTotalticketprice();
					strNewTotalPrice=String.valueOf(totalnewprice);
				}
				
				
				if(orderinfo2.getId()>0){
					String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo1.getId() + " WHERE ID=" + orderinfo2.getId()+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo2.getId() + " WHERE ID=" + orderinfo1.getId();
				Server.getInstance().getSystemService().findMapResultBySql(sql,	null);

				}
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zrateone");
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zratetwo");
				
				 //是否保存常用乘机人信息
				if(!issavepassenger.equals(""))
				{
				String[] ArrIsSaveNew = issavepassenger.split(",");
				//String strTempPassenger = "";
//				for (int i = ArrIsSave.length - 1; i >= 0; i--) {
//					strTempPassenger += ArrIsSave[i] + ",";
//				}
				//String[] ArrIsSaveNew = strTempPassenger.split(",");

				for (int i = 0; i < listpassenger.size(); i++) {
					String where = " where 1=1 and "
							+ Customerpassenger.COL_customeruserid + " = "
							+ getLoginUser().getId() + " and "
							+ Customerpassenger.COL_username + " = '"
							+ listpassenger.get(i).getName().trim() + "'";

					List<Customerpassenger> list = Server.getInstance()
							.getMemberService().findAllCustomerpassenger(where,
									"", -1, 0);
					// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
					if (ArrIsSaveNew[i].equals("0")
							|| (list != null && list.size() > 0)) {
						continue;
					}
					try {
						// 当前登录员工
						Customeruser loginEmployee = getLoginUser();
						Customerpassenger customerpassenger = new Customerpassenger();
						customerpassenger.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customerpassenger.setCreateuser(getLoginUser()
								.getLoginname());
						customerpassenger.setUsername(listpassenger.get(i)
								.getName().trim());
						customerpassenger.setType(1);
						customerpassenger.setCustomeruserid(loginEmployee
								.getId());
						customerpassenger = Server.getInstance()
								.getMemberService().createCustomerpassenger(
										customerpassenger);
						// 添加证件
						Customercredit customercredit = new Customercredit();
						customercredit.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setCreateuser(loginEmployee
								.getMembername());
						if(listpassenger.get(i).getPtype()==1){
						customercredit.setCreditnumber(listpassenger.get(i)
								.getIdnumber().trim());
						customercredit.setCredittypeid(listpassenger.get(i)
								.getIdtype());
						}
						customercredit.setModifytime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setModifyuser(loginEmployee
								.getMembername());
						customercredit.setRefid(customerpassenger.getId());
						customercredit.setType(1);
						Server.getInstance().getMemberService()
								.createCustomercredit(customercredit);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				}
				System.out.println(orderinfo1.getId());
				System.out.println(orderinfo2.getId());
				strReturn = "b2bticketorder!payorder.action?orderinfo.id="
						+ orderinfo1.getId()+"&s_oldzratevalue="+strOldZrateValue+"&s_bestzratevalue="+strBestZrateValue+"&s_oldorderprice="+strOldTotalPrice+"&s_neworderprice="+strNewTotalPrice;
			
				if(getLoginAgent().getType()==2){
					strReturn = "b2bticketorder!payorder2.action?orderinfo.id="
						+ orderinfo1.getId();
				}
				
				 
			}

			//
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误:"+e.toString());
			strReturn = "ERROR";
		}
			
		return strReturn;
	}
	
	public List GetRtPatPNR(String s_returnpnr,List<Passenger>listpassenger){
		String pnrtxt="";
		String pattxt="";
		String bigpnr="";
		
		List listpnrinfo=new ArrayList<String>();
		
		 pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr, "","");
		 
		 
		 
		 	String ig="";
			if(pnrtxt.indexOf("授权")!=-1){
				ig="back";
				pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr, "", ig);
			}
		 
		 
		 
		//原始的用
		int ind=0;
		if(pnrtxt.indexOf("+")>0){
			ind=pnrtxt.indexOf("+");
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "",ig);
		}
		if(pnrtxt.indexOf("+")>ind){
			ind=pnrtxt.indexOf("+");
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "",ig);
		}
		if(pnrtxt.indexOf("+")>ind){
			ind=pnrtxt.indexOf("+");
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "",ig);
		}
		
		//放大不规范的用
		
		/*for(int a=0;a<4;a++){
		pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
		if(pnrtxt.indexOf("      -")!=-1){
			break;
		}
		}
		
		if(pnrtxt.indexOf("      -")==-1){
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
		}
		if(pnrtxt.indexOf("      -")==-1){
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
		}
		if(pnrtxt.indexOf("      -")==-1){
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
		}
		
		if(pnrtxt.indexOf(" -")!=-1){
			System.out.println("pnrtxt:"+pnrtxt);
			pnrtxt=pnrtxt.replaceAll(" -", "");
		}*/
		
		
		System.out.println("GetRtPatPNR-pnrtxt:"+pnrtxt);
		
		//NKG170
		/*if(pnrtxt!=null&&pnrtxt.indexOf("NKG170")!=-1){
			
			pnrtxt=pnrtxt.split("[.]NKG170")[0]+".NKG170";
		}*/
		
		String strPat="PAT:A";
		for(int w=0;w<listpassenger.size();w++){
			if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
				strPat="PAT:A*CH";
				break;
			}
		}
		 pattxt=Server.getInstance().getTicketSearchService().commandFunction2(strPat, "",ig);
		System.out.println("GetRtPatPNR-pattxt:"+pattxt);
		if(pattxt.indexOf(">")!=-1){
			pattxt=pattxt.replaceAll(">", "");
		}
		if(pnrtxt!=null&&pnrtxt.indexOf("BJS182")!=-1){
			pnrtxt=pnrtxt.split("[.]BJS182")[0]+".BJS182";
		}
		if(pnrtxt!=null&&pnrtxt.indexOf("PEK868")!=-1){
			pnrtxt=pnrtxt.split("[.]PEK868")[0]+".PEK868";
		}
		System.out.println("pattxt:"+pattxt);
		bigpnr = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
		if(pattxt.indexOf("没有符合条件的运价")!=-1){
			System.out.println("没有符合条件的运价,订单创建失败");
			//生成外部订单失败,取消PNR
			Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "",ig);
		}
		listpnrinfo.add(pnrtxt.replace(" b ", ""));
		listpnrinfo.add(pattxt.replace(" b ", ""));
		listpnrinfo.add(bigpnr);
		return listpnrinfo;
	}
	public List GetRtPatPNR2(String s_returnpnr,List<Passenger>listpassenger){
		String pnrtxt="";
		String pattxt="";
		String bigpnr="";
		
		List listpnrinfo=new ArrayList<String>();
		
		 pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr, "");
		//原始的用
		int ind=0;
		if(pnrtxt.indexOf("+")>0){
			ind=pnrtxt.indexOf("+");
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PN", "");
		}
		if(pnrtxt.indexOf("+")>ind){
			ind=pnrtxt.indexOf("+");
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PN$PN", "");
		}
		if(pnrtxt.indexOf("+")>ind){
			ind=pnrtxt.indexOf("+");
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PN$PN$PN", "");
		}
		
		//放大不规范的用
		
		/*for(int a=0;a<4;a++){
		pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
		if(pnrtxt.indexOf("      -")!=-1){
			break;
		}
		}
		
		if(pnrtxt.indexOf("      -")==-1){
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
		}
		if(pnrtxt.indexOf("      -")==-1){
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
		}
		if(pnrtxt.indexOf("      -")==-1){
			pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
		}
		
		if(pnrtxt.indexOf(" -")!=-1){
			System.out.println("pnrtxt:"+pnrtxt);
			pnrtxt=pnrtxt.replaceAll(" -", "");
		}*/
		
		
		System.out.println("GetRtPatPNR-pnrtxt:"+pnrtxt);
		
		//NKG170
		/*if(pnrtxt!=null&&pnrtxt.indexOf("NKG170")!=-1){
			
			pnrtxt=pnrtxt.split("[.]NKG170")[0]+".NKG170";
		}*/
		
		String strPat="PAT:A";
		for(int w=0;w<listpassenger.size();w++){
			if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
				strPat="PAT:A*CH";
				break;
			}
		}
		 pattxt=Server.getInstance().getTicketSearchService().commandFunction(strPat, "");
		System.out.println("GetRtPatPNR-pattxt:"+pattxt);
		if(pattxt.indexOf(">")!=-1){
			pattxt=pattxt.replaceAll(">", "");
		}
		if(pnrtxt!=null&&pnrtxt.indexOf("BJS182")!=-1){
			pnrtxt=pnrtxt.split("[.]BJS182")[0]+".BJS182";
		}
		if(pnrtxt!=null&&pnrtxt.indexOf("PEK868")!=-1){
			pnrtxt=pnrtxt.split("[.]PEK868")[0]+".PEK868";
		}
		System.out.println("pattxt:"+pattxt);
		bigpnr = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
		if(pattxt.indexOf("没有符合条件的运价")!=-1){
			System.out.println("没有符合条件的运价,订单创建失败");
			//生成外部订单失败,取消PNR
			Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$XEPNR@", "");
		}
		listpnrinfo.add(pnrtxt);
		listpnrinfo.add(pattxt);
		listpnrinfo.add(bigpnr);
		return listpnrinfo;
	}
	
	/**
	 * 新生成订单方法
	 * @param listsegmenginfo  航程信息
	 * @param listpassenger    乘机人信息
	 * @param orderinfo        订单信息
	 * @param zratelist        政策信息
	 * @param insurances       保险信息
	 * @param issavepassenger  是否保存常用旅客
	 * @param orderflag        订单创建类型  1=查询预订下订单，2=PNR导入创建订单，3=b2c网站创建订单
	 * @return
	 * @throws Exception
	 */
	public String CreateOrder_new(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{
		String strReturn="NOPNR";
		
		
		
		
		
		
		String s_returnpnr="123456";
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 1;
		// 是否生成PNR
		int intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
	
		// 是否生成外部订单
		int intIsCreateOuterOrder =1; //0不生成外部订单   1生成外部订单
		// 是否按照原政策信息已经生成外订单
		int intIsCreated = 0;//0按照本地政策   1按照最优政策
		
		int IsWhy=1; //0不分润接口   1分润接口
		
		if(orderflag==2){//PNR导入的,不生成PNR
			intIsCreatePNR=0;
		}
		
		
		
		//本地订单旧政策
		String strOldZrateValue="0";
		//最优政策
		String strBestZrateValue="0";
		
		//用于PAT:A价格发生变化时，订单提醒
		String strOldTotalPrice="0";
		String strNewTotalPrice="0";
		
		System.out.println("zratelist:"+zratelist.get(0));
		
		Zrate zrate2 = Server.getInstance().getAirService().findZrate(zratelist.get(0));
		System.out.println("zrate2:"+zrate2);
		if(zrate2==null){
			zrate2=new Zrate();
			zrate2.setAgentid(6l);
		}
		if(zrate2.getAgentid()>10){//如果是本地政策供应商 不生成外部订单  使用本地政策
			intIsCreated=0;
			intIsCreateOuterOrder=0;
		}
		
		//如果是今日政策,不生成PNR,今日会生成PNR
		
		/*if(zrate2.getAgentid()==6){//如果是本地政策供应商 不生成外部订单  使用本地政策
			
			intIsCreated=0;
			intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
		}*/
		
		//如果是票盟  不匹配最优政策--成人
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==1){//如果是票盟
			System.out.println("票盟的政策,成人订单,不匹配最优了,按照本地政策");
			intIsCreated=0;
			//intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		//如果是票盟  不匹配最优政策--儿童  下单到今日
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==2){//如果是票盟
			System.out.println("票盟的政策,儿童订单,下单给今日");
			intIsCreated=1;
			//intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		
		
		//开始判断是否生成pnr和外部订单
		String wherefig=" where 1=1 and "+Sysconfig.COL_name+" ='ispnrandorder'";
		List<Sysconfig>listfig=Server.getInstance().getSystemService().findAllSysconfig(wherefig, " ORDER BY ID ", -1, 0);
		if(listfig!=null&&listfig.size()>0){
			if(listfig.get(0).getValue().equals("-1")){
				System.out.println("不生成PNR和外部订单了");
				intIsCreatePNR=0;
				intIsCreateOuterOrder=0;
				intIsCreated=0;
			}
			
		}
		
		
		
		//开始创建订单
		
		try{
			//订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			
			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize=listsegmenginfo.size();
			/******************循环航程list,并创建订单开始*************************/
			for(int s=0;s<intsegmentsize;s++)
			{
				if(s==0){
					strOldTotalPrice=listsegmenginfo.get(0).getParvalue()+"";
				}
				
				String pat_Price="0";
				String pat_Fuleprice="0";
				String pat_airportfee="0";
				
				Zrate zrate_bendi = Server.getInstance().getAirService().findZrate(zratelist.get(s));//本地政策
				if(zrate_bendi==null){
					zrate_bendi=new Zrate();
					zrate_bendi.setAgentid(6l);
				}
				orderinfo.setPolicyagentid(zrate_bendi.getAgentid());
				
				if(intIsCreatePNR==1){
					//先生成PNR
					if (intCreatePNRType == 1) {
						//往返不在同1PNR
						List<Segmentinfo>listseg=new ArrayList<Segmentinfo>();
						listseg.add(listsegmenginfo.get(s));
						s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listseg, listpassenger, orderinfo.getNewpnr());	
						//往返在同1PNR
					    //s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					} else {
					//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
						s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassenger, orderinfo);
					}
				}
				
				if(intIsCreatePNR==1){
					if(s_returnpnr.equals("NOPRICE")){
						intIsCreatePNR=0;
						intIsCreateOuterOrder=0;
						intIsCreated=0;
						
						// return "NOPRICE";
					}
					if(s_returnpnr.equals("NAMEERR")){
						intIsCreatePNR=0;
						intIsCreateOuterOrder=0;
						intIsCreated=0;
						// return "NAMEERR";
					}
				
				       if(s_returnpnr.equals("-1")||s_returnpnr.equals("NOPNR")||s_returnpnr.equals("NOPRICE")||s_returnpnr.equals("NAMEERR")){
						//如果没有生成PNR...不创建外部订单,创建内部订单
							intIsCreatePNR=0;
							intIsCreateOuterOrder=0;
							intIsCreated=0;
							s_returnpnr="123456";
							// return "NOPNR";
						}else{
							if(intCreatePNRType==2){//51创建PNR
								String newpnr="";
								String pnrtxt="";
								String pattxt="";
								if(s_returnpnr.indexOf("@")!=-1){
								newpnr=s_returnpnr.split("@")[0];
								pattxt=s_returnpnr.split("@")[1];
								pnrtxt=s_returnpnr.split("@")[2];
								}else{
								newpnr=	s_returnpnr;
								}
								orderinfo.setPattxt(pattxt);
								orderinfo.setPnrtxt(pnrtxt);
								orderinfo.setPnr(newpnr);
								if(pattxt.indexOf("没有符合条件的运价")!=-1){
									System.out.println("没有符合条件的运价,订单创建失败");
									intIsCreatePNR=0;
									intIsCreateOuterOrder=0;
									intIsCreated=0;
									//return "NOPNR";
								}
							}else{//黑屏创建
								
							List listonrinfo=GetRtPatPNR(s_returnpnr, listpassenger);//0pnrinfo 1patinfo 2bigpnr
								if(listonrinfo.get(1).toString().indexOf("没有符合条件的运价")!=-1){
									System.out.println("没有符合条件的运价,订单创建失败");
									Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
									intIsCreatePNR=0;
									intIsCreateOuterOrder=0;
									intIsCreated=0;
									
									//return "NOPRICE";
								}else{
									
									orderinfo.setPattxt(listonrinfo.get(1).toString());
									orderinfo.setPnrtxt(listonrinfo.get(0).toString());
									orderinfo.setBigpnr(listonrinfo.get(2).toString());
									
									//
									  String[] strpatItem=orderinfo.getPattxt().split(" ");
									  System.out.println("核对黑屏价格-数组:"+strpatItem.length);
									  for(int i=0;i<strpatItem.length;i++) 
									  {
										  if(!strpatItem[i].trim().equals(""))
										  {
											  //票价
											  if(strpatItem[i].trim().indexOf("FARE:")>=0)
											  {
												  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
												  
												  System.out
														.println("pat_Price:"+pat_Price);
											  }
											  //燃油费
											  /*if(strpatItem[i].trim().indexOf("YQ:")>=0)
											  {
												 
												  
												  if(strpatItem[i].trim().indexOf("YQ:TE")>=0||strpatItem[i].trim().indexOf("YQ:CNY-")>=0){
													  pat_Fuleprice="0"; 
												  }else{
													  pat_Fuleprice=strpatItem[i].trim().replace("YQ:CNY", "");
												  }
											  }*/
											  //机建费
											  /*if(strpatItem[i].trim().indexOf("TAX:")>=0)
											  {
												  if(strpatItem[i].trim().indexOf("TAX:TEXE")>=0){
													  pat_airportfee="0"; 
												  }else{
													  pat_airportfee=strpatItem[i].trim().replace("TAX:CNY", "");
												  }
												  
											  }*/
											  
											  if(!pat_Price.equals("0")){//&&!pat_Fuleprice.equals("0")&&!pat_airportfee.equals("0")
												  
												  break;
											  }
											  
										  }
									  }
								}
							
							
							}
						}
				 
				}
				
				//开始订单
				 Orderinfo orderinfomodel = new Orderinfo();
				
				 orderinfomodel=orderinfo;
				 orderinfomodel.setPnr(s_returnpnr);
				 Segmentinfo segmentinfo=listsegmenginfo.get(s);
				 if(!pat_Price.equals("0")){
				 segmentinfo.setParvalue(Float.parseFloat(pat_Price));
				 }
				 //segmentinfo.setAirportfee(Float.parseFloat(pat_airportfee));
				 //segmentinfo.setFuelfee(Float.parseFloat(pat_Fuleprice));
				 
				 segmentinfo.setZrate(zrate_bendi);
				 
					/*****订单信息赋值开始************************************************************/
					/****本地政策赋值开始*****************************************/
					//Zrate zrate_bendi = Server.getInstance().getAirService().findZrate(zratelist.get(s));//本地政策
					strOldZrateValue=zrate_bendi.getRatevalue()+"";
					Zrate bestzrate=new Zrate();//最优政策
					Zrate zrate=new Zrate();//临时
					if(intIsCreated==1){//;匹配最优政策
						orderinfomodel.setPassengerlist(listpassenger);
						if(orderinfomodel.getPassengerlist().get(0).getPtype()==1)
						{
							
							/*if(orderinfomodel.getPolicyagentid()==3){
								System.out.println("8000yi的,切换到今日");
								orderinfomodel.setPolicyagentid(6l);
							}*/
							
							//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
						bestzrate = Server.getInstance()
								.getRateService().FindZrateByFlight(
										orderinfomodel, segmentinfo,
										orderinfomodel.getPassengerlist());
						
						
						
						
					/*	Orderinfo ord_ctyd=orderinfomodel;
						ord_ctyd.setPolicyagentid(7l);
						Zrate	ctyd_zrate = Server.getInstance().getRateService().FindZrateByFlight(ord_ctyd, segmentinfo,orderinfomodel.getPassengerlist());	
						System.err.println("辰通返点:"+ctyd_zrate.getRatevalue());
						System.err.println("平台返点:"+bestzrate.getRatevalue());
						if(ctyd_zrate!=null&&ctyd_zrate.getRatevalue()!=null&&ctyd_zrate.getOutid()!=null&&bestzrate!=null&&bestzrate.getRatevalue()!=null&&bestzrate.getOutid()!=null){
							if(bestzrate.getRatevalue()<=ctyd_zrate.getRatevalue()){
								bestzrate=ctyd_zrate;
								orderinfomodel.setPolicyagentid(ctyd_zrate.getAgentid());
								orderinfomodel.setExtpolicyid(ctyd_zrate.getOutid());
								
							}
							
						}*/
						
								
						
						
						
						}else if(orderinfomodel.getPassengerlist().get(0).getPtype()==2)
						{
							orderinfomodel.setPolicyagentid(6l);
						
							bestzrate = Server.getInstance()
									.getRateService().FindZrateByFlight(
											orderinfomodel, segmentinfo,
											orderinfomodel.getPassengerlist());
							}
						else
						{
							bestzrate =Server.getInstance().getAirService().findZrate(1l);
						}
						
						if(bestzrate!=null&&bestzrate.getOutid()!=null&&bestzrate.getRatevalue()!=null){
							System.out.println("按照最优的匹配政策成功,返点:"+bestzrate.getRatevalue());
							
							orderinfomodel.setExtpolicyid(bestzrate.getOutid());//外部政策ID
							orderinfomodel.setExtorderepolicyid(bestzrate.getAgentcode());//外部政策供应商代码
							
							zrate=zrate_bendi;
						}else{
							zrate=zrate_bendi;
							System.out.println("按照最优的匹配政策失败,用本地政策,返点:"+zrate.getRatevalue());
							
						}
						
						
						strBestZrateValue=bestzrate.getRatevalue()+"";
						strBestZrateValue=Getliudianvalue(Float.parseFloat(strBestZrateValue))+"";
					}else{
						
						zrate=zrate_bendi;
					}
					
					
					orderinfo.setPolicyid(zrate.getId());
					orderinfo.setPolicyagentid(zrate.getAgentid());
					
					String zratermak="特殊高政策备注：换编码，换舱出票，出票票面与实际票面不同。差价不退。不得退票，不得改期，不得签转。不能当日作废。不能打印行程单。可能二次更新票号。";
					
					if(zrate.getGeneral()!=null){
						orderinfo.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
					}else{
						zratermak="以航空公司退改签为参考!实际以出票商为准!!!";
						orderinfo.setReceipt(1);
					}
					
					if(orderinfo.getReceipt()==1){
						zratermak="以航空公司退改签为参考!实际以出票商为准!!!";
					}else{
						zratermak="特殊高政策备注：换编码，换舱出票，出票票面与实际票面不同。差价不退。不得退票，不得改期，不得签转。不能当日作废。不能打印行程单。可能二次更新票号。";
					}
					
					//判断开始.判断是否是固定饭店用户;
					
					/*if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
						zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
					}*/
					if(zrate.getWorkstatus()!=null){
					orderinfomodel.setPickonename(zrate.getWorkstatus());//office
					}
					if(zrate.getSpeed()!=null){
						if(zrate.getAgentid()==5){
						orderinfomodel.setPickonephone(zrate.getSpeed());//出票速度
						}
						if(zrate.getAgentid()==6){
						orderinfomodel.setPickonephone(zrate.getSpeed()+"分钟");//出票速度
						}
					}
					orderinfomodel.setPolicyid(zrate.getId());//政策ID
					if(getLoginAgent().getBigtype()==2){//固定返点
						orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(getLoginAgent().getFixedvalue())));// 分销商返点
					}else{
						orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate.getRatevalue())));// 分销商返点
					}
					
					//记录当前政策值
					orderinfomodel.setPolicyagentid(zrate.getAgentid());// 政策提供商id
					orderinfomodel.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
					if(orderinfomodel.getExtpolicyid()==null){
					orderinfomodel.setExtpolicyid(zrate.getOutid()); // 外部政策id
					}
					orderinfomodel.setPostmobile(zrate.getWorktime()+"-"+zrate.getAfterworktime());
					
					segmentinfo.setAgentid(zrate.getAgentid());
					segmentinfo.setRatevalue(zrate.getRatevalue());
					segmentinfo.setPrice(FrmatJinYi(segmentinfo.getParvalue()-(segmentinfo.getParvalue()*orderinfomodel.getFenxiaoshangfandian()/100)));
					segmentinfo.setZrateid(zrate.getId());
					segmentinfo.setLanguage(0);
					segmentinfo.setZrate(zrate);
					/****本地政策赋值结束*****************************************/ 
					
					/****订单信息赋值结束************************************************************/
					
					float subfuelfee = 0;
					float subairportfee = 0;
					float subprice = 0;
					int chengrenNUM=0;//成人数量
					int intchlid=0;//儿童数量
					String[] bxcounts = insurances.trim().split(",");//保险信息
					/****乘机人信息赋值开始************************************************************/
					List<Passenger> listpass=new ArrayList<Passenger>();
					for (int i = 0; i < listpassenger.size(); i++) {
						if (listpassenger.get(i).getName().trim().length() > 0) {
							
							 if (listpassenger.get(i).getPtype() == 1) {
									chengrenNUM++;
								}
							 if (listpassenger.get(i).getPtype() == 2) {
								 intchlid++;
								}
								int bxcount = 0;
								   bxcount=Integer.valueOf(bxcounts[i].trim());
							
							   Passenger passenger =new Passenger();
							   
							   Float bxp=20f;
							   HttpSession session = ServletActionContext.getRequest().getSession();
								if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
									bxp=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
								}
							   
								  //PNR联系方式
							    passenger.setMobile(orderinfomodel.getContactmobile());
							       
							   passenger.setInsurprice(bxcount*bxp);
						       passenger.setName(listpassenger.get(i).getName());
						       passenger.setPtype(listpassenger.get(i).getPtype());
						       passenger.setIdnumber(listpassenger.get(i).getIdnumber());
						       passenger.setIdtype(listpassenger.get(i).getIdtype());
						       passenger.setState(listpassenger.get(i).getState());
						       passenger.setLanguage(listpassenger.get(i).getLanguage());
						       passenger.setAirportfee(segmentinfo.getAirportfee());
						       passenger.setFuelprice(segmentinfo.getFuelfee());
						       passenger.setPrice(listpassenger.get(i).getPrice());
						       passenger.setBirthday(listpassenger.get(i).getBirthday());
							if (passenger.getPtype() == 1) {
								passenger.setPrice(segmentinfo.getPrice());
								passenger.setAirportfee(segmentinfo.getAirportfee());
								passenger.setFuelprice(segmentinfo.getFuelfee());
							} else if (passenger.getPtype() == 2) {
								passenger.setAirportfee(0f);
								passenger.setFuelprice(getRoundPrice(segmentinfo.getFuelfee(), 2));
								if (segmentinfo.getDiscount() > 100) {
									passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
								} else {
									passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
								}
							} else if(orderflag!=2) {
								passenger.setAirportfee(0f);
								passenger.setFuelprice(0f);
								// 儿童婴儿价
								if (segmentinfo.getDiscount() > 100) {
									passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 10));
								} else {
									passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 10));
								}
							}
							subprice += passenger.getPrice();
							subfuelfee += passenger.getFuelprice();
							subairportfee += passenger.getAirportfee();
							passenger.setDiscount(segmentinfo.getDiscount());
							listpass.add(passenger);
							
						}
					}
					/****乘机人信息赋值结束************************************************************/
					  // 机建费
					orderinfomodel.setTotalairportfee(subairportfee);
				      // 燃油费
					orderinfomodel.setTotalfuelfee(subfuelfee);
					  // 总机票价格+平台费用
					orderinfomodel.setTotalticketprice(subprice);
			    	 System.out.println("?????????????:"+subairportfee+","+subfuelfee+","+subprice);
			    	 
			    	orderinfomodel.setB2cprofit(FrmatJinYi((segmentinfo.getParvalue()*orderinfomodel.getFenxiaoshangfandian()/100))+"");
			    	orderinfomodel.setCclientpayprice(FrmatJinYi((subairportfee+subfuelfee+subprice))+"") ;
			    	 
			    	orderinfomodel.setPaystatus(0);
				    orderinfomodel.setOrderstatus(1);
			    	orderinfomodel.setPassengerlist(listpass);
			        listOrderinfo.add(orderinfomodel);
			    	
			       
			    	 
			    	 if(intIsCreateOuterOrder==1){
			    	//Server.getInstance().setInter("http://127.0.0.1:8080/ticket_inter/service/");
			    	String strExtOrderNumber = Server.getInstance().getRateService().CreateOrder(orderinfomodel,
			    			segmentinfo, orderinfomodel.getPassengerlist());
			    	WriteLog.write("外部订单返回", strExtOrderNumber);
					// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
					if (!strExtOrderNumber.equals("-1")) {
						if (orderinfomodel.getPolicyagentid() == 5 || orderinfomodel.getPolicyagentid() == 2||orderinfomodel.getPolicyagentid() == 7) {
						// 返回格式：S|订单号|支付url
						// 外部订单号
							

						if (strExtOrderNumber.indexOf("|") > 0) {
							String[] strExtOrderArr = strExtOrderNumber
									.split("[|]");
							if (strExtOrderArr.length == 3) {
								if (strExtOrderArr[0].equals("S")) {
									orderinfomodel
											.setExtorderid(strExtOrderArr[1]);
									orderinfomodel
											.setPaymenturl(strExtOrderArr[2]);
								}
							}
						}

					}else if(orderinfomodel.getPolicyagentid() == 6){
						if (strExtOrderNumber.indexOf("@") != -1) {
							String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfomodel.getPolicyagentid());
							orderinfomodel.setExtorderid(strExtOrderArrpnr[0].trim());
							//orderinfomodel.setPnr(strExtOrderArrpnr[1].trim());
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfomodel.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
					
							
							
							
							intIsCreated =0;
						}
					} else {
						// 外部订单号
						orderinfomodel.setExtorderid(strExtOrderNumber);
					}
					// 外部订单状态
					orderinfomodel.setExtorderstatus(0);
					// 外部订单创建时间
					orderinfomodel.setExtordercreatetime(new Timestamp(
							System.currentTimeMillis()));
					// 本地订单状态为待支付
					if (orderinfomodel.getPaymethod()==2
							|| orderinfomodel.getPaymethod()==3) {
						orderinfomodel.setPaystatus(0); // 已支付
						// 门市付款或者票到付款，则订单状态为等待出票
						orderinfomodel.setOrderstatus(1);
					} else {
						orderinfomodel.setOrderstatus(1);
					}
					// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
				} else {
					System.out.println("按照最优政策创建外部订单失败，返回结果:"
							+ strExtOrderNumber);
				}
			  } 
			//外部订单创建结束
			    	
					
					Float insurprice=0.0f;
					Float fparvalue=0f;
					if(segmentinfo.getParvalue()!=null && chengrenNUM>0)
					{
						fparvalue=segmentinfo.getParvalue();
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
							fparvalue=getRoundPrice(segmentinfo.getYprice(), 2);
						}
						else
						{
							fparvalue=segmentinfo.getParvalue();
						}
					}
					
					
					//返佣信息
			        String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfomodel.getRatevalue(),
							Getliudianvalue(orderinfomodel.getRatevalue()), fparvalue, insurprice);
					
					if(getLoginAgent().getBigtype()==2){
						
						Sysconfig sys = Server.getInstance().getSystemService()
						.findSysconfig(1);
				// 保存当前 保险成本 与购买数量
						String strsub = sys.getValue() + "|" + insurprice;
						strCustomgeragentBackPointInfo="1,0.00,"+fparvalue+","+orderinfomodel.getRatevalue()+"@46,"+(orderinfomodel.getRatevalue()-Float.parseFloat(getLoginAgent().getFixedvalue()))+","+fparvalue+","+orderinfomodel.getRatevalue()+"@"+getLoginAgent().getId()+","+getLoginAgent().getFixedvalue()+","+fparvalue+","+orderinfomodel.getRatevalue()+"@"+strsub;
					}
					
					System.out.println(strCustomgeragentBackPointInfo);
					//orderinfomodel.setFenxiaoshangfandian(Getliudianvalue(orderinfomodel.getRatevalue()));
					orderinfomodel.setBackpointinfo(strCustomgeragentBackPointInfo);
					
					
					WriteLog.write("订单信息","订单:"+orderinfomodel.toString());
					orderinfomodel = Server.getInstance().getAirService().createOrderinfo(orderinfomodel);
					
					System.out.println("订单详细信息");
					System.out.println(orderinfomodel.toString());
					System.out.println("订单详细信息============");
					System.out.println(orderinfomodel.getOrdernumber());
					System.out.println("订单信息==" + orderinfomodel);
					System.out.println("订单ID==" + orderinfomodel.getId());
					System.out.println("外部订单ID==" + orderinfomodel.getExtorderid());

					segmentinfo.setOrderid(orderinfomodel.getId());
					
					if(s==0){
						strNewTotalPrice=segmentinfo.getParvalue()+"";
					}
					
					segmentinfo.setRules(zratermak);
					
					// 获取新政策，更新航程信息
					Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
					 for(int p=0;p<listpass.size();p++){
				        	Passenger passenger=listpass.get(p);
				        	passenger.setOrderid(orderinfomodel.getId());
				        	Server.getInstance().getAirService().createPassenger(passenger);
				     }
						//创建操作记录
						try{
							Orderinforc orderinforc = new Orderinforc();
							orderinforc.setCustomeruserid(getLoginUserId());
							orderinforc.setOrderinfoid(orderinfomodel.getId());
							orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
							orderinforc.setContent("创建订单--" + this.getLoginUser().getMembername()+ "创建了订单");
							orderinforc.setSuouserid(orderinfomodel.getUserid());
							orderinforc.setState(orderinfomodel.getOrderstatus());
							orderinforc.setCustomeruserid(getLoginUserId());
							Server.getInstance().getAirService().createOrderinforc(orderinforc);
						}
						catch(Exception ex){
							System.out.println("创建操作记录异常："+ex.getMessage());
						}
						
						
						
						
						
						
						if (s == 0) {
							this.orderinfo1 = orderinfomodel;
						} else {
							this.orderinfo2 = orderinfomodel;
						}
						
						
						if(orderinfo2.getId()>0){
							String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
								+ orderinfo1.getId() + " WHERE ID=" + orderinfo2.getId()+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
								+ orderinfo2.getId() + " WHERE ID=" + orderinfo1.getId();
						Server.getInstance().getSystemService().findMapResultBySql(sql,	null);

						}
						ActionContext.getContext().getSession().remove(
								this.getLoginUserId() + "zrateone");
						ActionContext.getContext().getSession().remove(
								this.getLoginUserId() + "zratetwo");
						
						
						 //是否保存常用乘机人信息
						if(!issavepassenger.equals(""))
						{
						String[] ArrIsSaveNew = issavepassenger.split(",");
						
						for (int i = 0; i < listpassenger.size(); i++) {
							String where = " where 1=1 and "
									+ Customerpassenger.COL_customeruserid + " = "
									+ getLoginUser().getId() + " and "
									+ Customerpassenger.COL_username + " = '"
									+ listpassenger.get(i).getName().trim() + "'";

							List<Customerpassenger> list = Server.getInstance()
									.getMemberService().findAllCustomerpassenger(where,
											"", -1, 0);
							// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
							if (ArrIsSaveNew[i].equals("0")
									|| (list != null && list.size() > 0)) {
								continue;
							}
							try {
								// 当前登录员工
								Customeruser loginEmployee = getLoginUser();
								Customerpassenger customerpassenger = new Customerpassenger();
								customerpassenger.setCreatetime(new Timestamp(System
										.currentTimeMillis()));
								customerpassenger.setCreateuser(getLoginUser()
										.getLoginname());
								customerpassenger.setUsername(listpassenger.get(i)
										.getName().trim());
								customerpassenger.setType(1);
								customerpassenger.setCustomeruserid(loginEmployee
										.getId());
								customerpassenger = Server.getInstance()
										.getMemberService().createCustomerpassenger(
												customerpassenger);
								// 添加证件
								Customercredit customercredit = new Customercredit();
								customercredit.setCreatetime(new Timestamp(System
										.currentTimeMillis()));
								customercredit.setCreateuser(loginEmployee
										.getMembername());
								if(listpassenger.get(i).getPtype()==1){
								customercredit.setCreditnumber(listpassenger.get(i)
										.getIdnumber().trim());
								customercredit.setCredittypeid(listpassenger.get(i)
										.getIdtype());
								}
								customercredit.setModifytime(new Timestamp(System
										.currentTimeMillis()));
								customercredit.setModifyuser(loginEmployee
										.getMembername());
								customercredit.setRefid(customerpassenger.getId());
								customercredit.setType(1);
								Server.getInstance().getMemberService()
										.createCustomercredit(customercredit);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						}
						}
						//保存常用联系人结束
						
						System.out.println(orderinfo1.getId());
						System.out.println(orderinfo2.getId());
						strReturn = "b2bticketorder!payorder.action?orderinfo.id="
								+ orderinfo1.getId()+"&s_oldzratevalue="+strOldZrateValue+"&s_bestzratevalue="+strBestZrateValue+"&s_oldorderprice="+strOldTotalPrice+"&s_neworderprice="+strNewTotalPrice;
					
						if(getLoginAgent().getType()==2){
							strReturn = "b2bticketorder!payorder2.action?orderinfo.id="
								+ orderinfo1.getId();
						}
						
						
						//sendCreateOrderTXTSmstoPassenger(listpass, listsegmenginfo,orderinfo1);
				
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			System.out.println("错误:"+e.toString());
			//Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
			strReturn="ERRER";
			}
		
		
		
		
		
		
		
		
		
		
		
		

		return strReturn;
	}
	
	public String CreateOrder_new_new(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{
		String strReturn="NOPNR";
		
		
		
		
		
		String s_returnpnr="123456";
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 1;
		// 是否生成PNR
		int intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
	
		// 是否生成外部订单
		int intIsCreateOuterOrder =1; //0不生成外部订单   1生成外部订单
		// 是否按照原政策信息已经生成外订单
		int intIsCreated = 1;//0按照本地政策   1按照最优政策
		
		int IsWhy=1; //0不分润接口   1分润接口
		
		if(orderflag==2){//PNR导入的,不生成PNR
			intIsCreatePNR=0;
		}
		
		
		//本地订单旧政策
		String strOldZrateValue="0";
		//最优政策
		String strBestZrateValue="0";
		
		//用于PAT:A价格发生变化时，订单提醒
		String strOldTotalPrice="0";
		String strNewTotalPrice="0";
		
		System.out.println("zratelist:"+zratelist.get(0));
		
		Zrate zrate2 = Server.getInstance().getAirService().findZrate(zratelist.get(0));
		System.out.println("zrate2:"+zrate2);
		
		if(zrate2.getAgentid()>10){//如果是本地政策供应商 不生成外部订单  使用本地政策
			intIsCreated=0;
			intIsCreateOuterOrder=0;
		}
		
		//如果是今日政策,不生成PNR,今日会生成PNR
		
		/*if(zrate2.getAgentid()==6){//如果是本地政策供应商 不生成外部订单  使用本地政策
			
			intIsCreated=0;
			intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
		}*/
		
		//如果是票盟  不匹配最优政策--成人
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==1){//如果是票盟
			System.out.println("票盟的政策,成人订单,不匹配最优了,按照本地政策");
			intIsCreated=0;
			//intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		//如果是票盟  不匹配最优政策--儿童  下单到今日
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==2){//如果是票盟
			System.out.println("票盟的政策,儿童订单,下单给今日");
			intIsCreated=1;
			//intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		
		
		//开始判断是否生成pnr和外部订单
		String wherefig=" where 1=1 and "+Sysconfig.COL_name+" ='ispnrandorder'";
		List<Sysconfig>listfig=Server.getInstance().getSystemService().findAllSysconfig(wherefig, " ORDER BY ID ", -1, 0);
		if(listfig!=null&&listfig.size()>0){
			if(listfig.get(0).getValue().equals("-1")){
				System.out.println("不生成PNR和外部订单了");
				intIsCreatePNR=0;
				intIsCreateOuterOrder=0;
				intIsCreated=0;
			}
			
		}
		
		
		
		//开始创建订单
		
		try{
			//订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			
			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize=listsegmenginfo.size();
			/******************循环航程list,并创建订单开始*************************/
			for(int s=0;s<intsegmentsize;s++)
			{
				if(s==0){
					strOldTotalPrice=listsegmenginfo.get(0).getParvalue()+"";
				}
				
				String pat_Price="0";
				String pat_Fuleprice="0";
				String pat_airportfee="0";
				
				Zrate zrate_bendi = Server.getInstance().getAirService().findZrate(zratelist.get(s));//本地政策
				orderinfo.setPolicyagentid(zrate_bendi.getAgentid());
				
				//先生成PNR
				if (intCreatePNRType == 1) {
					//往返不在同1PNR
					List<Segmentinfo>listseg=new ArrayList<Segmentinfo>();
					listseg.add(listsegmenginfo.get(s));
					s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listseg, listpassenger, orderinfo.getNewpnr());	
					//往返在同1PNR
				    //s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
				} else {
				//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassenger, orderinfo);
				}
				
				if(intIsCreatePNR==1){
				
				 if(s_returnpnr.equals("-1")||s_returnpnr.equals("NOPNR")){
						//如果没有生成PNR...不创建外部订单,创建内部订单
							intIsCreateOuterOrder=0;
							intIsCreatePNR=0;
							s_returnpnr="123456";
							 return "NOPNR";
						}else{
							if(intCreatePNRType==2){//51创建PNR
								String newpnr="";
								String pnrtxt="";
								String pattxt="";
								if(s_returnpnr.indexOf("@")!=-1){
								newpnr=s_returnpnr.split("@")[0];
								pattxt=s_returnpnr.split("@")[1];
								pnrtxt=s_returnpnr.split("@")[2];
								}else{
								newpnr=	s_returnpnr;
								}
								orderinfo.setPattxt(pattxt);
								orderinfo.setPnrtxt(pnrtxt);
								orderinfo.setPnr(newpnr);
								if(pattxt.indexOf("没有符合条件的运价")!=-1){
									System.out.println("没有符合条件的运价,订单创建失败");
									return "NOPNR";
								}
							}else{//黑屏创建
								
							List listonrinfo=GetRtPatPNR(s_returnpnr, listpassenger);//0pnrinfo 1patinfo 2bigpnr
								if(listonrinfo.get(1).toString().indexOf("没有符合条件的运价")!=-1){
									System.out.println("没有符合条件的运价,订单创建失败");
									Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
									return "NOPNR";
								}else{
									
									orderinfo.setPattxt(listonrinfo.get(1).toString());
									orderinfo.setPnrtxt(listonrinfo.get(0).toString());
									orderinfo.setBigpnr(listonrinfo.get(2).toString());
									
									//
									  String[] strpatItem=orderinfo.getPattxt().split(" ");
									  System.out.println("核对黑屏价格-数组:"+strpatItem.length);
									  for(int i=0;i<strpatItem.length;i++) 
									  {
										  if(!strpatItem[i].trim().equals(""))
										  {
											  //票价
											  if(strpatItem[i].trim().indexOf("FARE:")>=0)
											  {
												  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
												  
												  System.out
														.println("pat_Price:"+pat_Price);
											  }
											  //燃油费
											  /*if(strpatItem[i].trim().indexOf("YQ:")>=0)
											  {
												 
												  
												  if(strpatItem[i].trim().indexOf("YQ:TE")>=0||strpatItem[i].trim().indexOf("YQ:CNY-")>=0){
													  pat_Fuleprice="0"; 
												  }else{
													  pat_Fuleprice=strpatItem[i].trim().replace("YQ:CNY", "");
												  }
											  }*/
											  //机建费
											  /*if(strpatItem[i].trim().indexOf("TAX:")>=0)
											  {
												  if(strpatItem[i].trim().indexOf("TAX:TEXE")>=0){
													  pat_airportfee="0"; 
												  }else{
													  pat_airportfee=strpatItem[i].trim().replace("TAX:CNY", "");
												  }
												  
											  }*/
											  
											  if(!pat_Price.equals("0")){//&&!pat_Fuleprice.equals("0")&&!pat_airportfee.equals("0")
												  
												  break;
											  }
											  
										  }
									  }
								}
							
							
							}
						}
				 
				}
				
				//开始订单
				 Orderinfo orderinfomodel = new Orderinfo();
				
				 orderinfomodel=orderinfo;
				 orderinfomodel.setPnr(s_returnpnr);
				 Segmentinfo segmentinfo=listsegmenginfo.get(s);
				 if(!pat_Price.equals("0")){
				 segmentinfo.setParvalue(Float.parseFloat(pat_Price));
				 }
				 //segmentinfo.setAirportfee(Float.parseFloat(pat_airportfee));
				 //segmentinfo.setFuelfee(Float.parseFloat(pat_Fuleprice));
				 
				 segmentinfo.setZrate(zrate_bendi);
				 
					/*****订单信息赋值开始************************************************************/
					/****本地政策赋值开始*****************************************/
					//Zrate zrate_bendi = Server.getInstance().getAirService().findZrate(zratelist.get(s));//本地政策
					strOldZrateValue=zrate_bendi.getRatevalue()+"";
					Zrate bestzrate=new Zrate();//最优政策
					Zrate zrate=new Zrate();//临时
					if(intIsCreated==1){//;匹配最优政策
						orderinfomodel.setPassengerlist(listpassenger);
						if(orderinfomodel.getPassengerlist().get(0).getPtype()==1)
						{
							
							/*if(orderinfomodel.getPolicyagentid()==3){
								System.out.println("8000yi的,切换到今日");
								orderinfomodel.setPolicyagentid(6l);
							}*/
							
							
						bestzrate = Server.getInstance()
								.getRateService().FindZrateByFlight(
										orderinfomodel, segmentinfo,
										orderinfomodel.getPassengerlist());
						
						
						
						
					/*	Orderinfo ord_ctyd=orderinfomodel;
						ord_ctyd.setPolicyagentid(7l);
						Zrate	ctyd_zrate = Server.getInstance().getRateService().FindZrateByFlight(ord_ctyd, segmentinfo,orderinfomodel.getPassengerlist());	
						System.err.println("辰通返点:"+ctyd_zrate.getRatevalue());
						System.err.println("平台返点:"+bestzrate.getRatevalue());
						if(ctyd_zrate!=null&&ctyd_zrate.getRatevalue()!=null&&ctyd_zrate.getOutid()!=null&&bestzrate!=null&&bestzrate.getRatevalue()!=null&&bestzrate.getOutid()!=null){
							if(bestzrate.getRatevalue()<=ctyd_zrate.getRatevalue()){
								bestzrate=ctyd_zrate;
								orderinfomodel.setPolicyagentid(ctyd_zrate.getAgentid());
								orderinfomodel.setExtpolicyid(ctyd_zrate.getOutid());
								
							}
							
						}*/
						
								
						
						
						
						}else if(orderinfomodel.getPassengerlist().get(0).getPtype()==2)
						{
							orderinfomodel.setPolicyagentid(6l);
							bestzrate = Server.getInstance()
									.getRateService().FindZrateByFlight(
											orderinfomodel, segmentinfo,
											orderinfomodel.getPassengerlist());
							}
						else
						{
							bestzrate =Server.getInstance().getAirService().findZrate(1l);
						}
						
						if(bestzrate!=null&&bestzrate.getOutid()!=null&&bestzrate.getRatevalue()!=null){
							System.out.println("按照最优的匹配政策成功,返点:"+bestzrate.getRatevalue());
							zrate=bestzrate;
						}else{
							zrate=zrate_bendi;
							System.out.println("按照最优的匹配政策失败,用本地政策,返点:"+zrate.getRatevalue());
							
						}
						
						
						strBestZrateValue=bestzrate.getRatevalue()+"";
						strBestZrateValue=Getliudianvalue(Float.parseFloat(strBestZrateValue))+"";
					}else{
						
						zrate=zrate_bendi;
					}
					
					
					orderinfo.setPolicyid(zrate.getId());
					orderinfo.setPolicyagentid(zrate.getAgentid());
					if(zrate.getGeneral()!=null){
						orderinfo.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
					}else{
						
						orderinfo.setReceipt(1);
					}
					
					//判断开始.判断是否是固定饭店用户;
					
					/*if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
						zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
					}*/
					if(zrate.getWorkstatus()!=null){
					orderinfomodel.setPickonename(zrate.getWorkstatus());//office
					}
					if(zrate.getSpeed()!=null){
						if(zrate.getAgentid()==5){
						orderinfomodel.setPickonephone(zrate.getSpeed());//出票速度
						}
						if(zrate.getAgentid()==6){
						orderinfomodel.setPickonephone(zrate.getSpeed()+"分钟");//出票速度
						}
					}
					orderinfomodel.setPolicyid(zrate.getId());//政策ID
					if(getLoginAgent().getBigtype()==2){//固定返点
						orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(getLoginAgent().getFixedvalue())));// 分销商返点
					}else{
						orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate.getRatevalue())));// 分销商返点
					}
					
					//记录当前政策值
					orderinfomodel.setPolicyagentid(zrate.getAgentid());// 政策提供商id
					orderinfomodel.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
					orderinfomodel.setExtpolicyid(zrate.getOutid()); // 外部政策id
					orderinfomodel.setPostmobile(zrate.getWorktime()+"-"+zrate.getAfterworktime());
					segmentinfo.setAgentid(zrate.getAgentid());
					segmentinfo.setRatevalue(zrate.getRatevalue());
					segmentinfo.setPrice(FrmatJinYi(segmentinfo.getParvalue()-(segmentinfo.getParvalue()*orderinfomodel.getFenxiaoshangfandian()/100)));
					segmentinfo.setZrateid(zrate.getId());
					segmentinfo.setLanguage(0);
					segmentinfo.setZrate(zrate);
					/****本地政策赋值结束*****************************************/ 
					
					/****订单信息赋值结束************************************************************/
					
					float subfuelfee = 0;
					float subairportfee = 0;
					float subprice = 0;
					int chengrenNUM=0;//成人数量
					int intchlid=0;//儿童数量
					String[] bxcounts = insurances.trim().split(",");//保险信息
					/****乘机人信息赋值开始************************************************************/
					List<Passenger> listpass=new ArrayList<Passenger>();
					for (int i = 0; i < listpassenger.size(); i++) {
						if (listpassenger.get(i).getName().trim().length() > 0) {
							
							 if (listpassenger.get(i).getPtype() == 1) {
									chengrenNUM++;
								}
							 if (listpassenger.get(i).getPtype() == 2) {
								 intchlid++;
								}
								int bxcount = 0;
								   bxcount=Integer.valueOf(bxcounts[i].trim());
							
							   Passenger passenger =new Passenger();
							   
							   Float bxp=20f;
							   HttpSession session = ServletActionContext.getRequest().getSession();
								if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
									bxp=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
								}
							   
								  //PNR联系方式
							    passenger.setMobile(orderinfomodel.getContactmobile());
							       
							   passenger.setInsurprice(bxcount*bxp);
						       passenger.setName(listpassenger.get(i).getName());
						       passenger.setPtype(listpassenger.get(i).getPtype());
						       passenger.setIdnumber(listpassenger.get(i).getIdnumber());
						       passenger.setIdtype(listpassenger.get(i).getIdtype());
						       passenger.setState(listpassenger.get(i).getState());
						       passenger.setLanguage(listpassenger.get(i).getLanguage());
						       passenger.setAirportfee(segmentinfo.getAirportfee());
						       passenger.setFuelprice(segmentinfo.getFuelfee());
						       passenger.setPrice(listpassenger.get(i).getPrice());
						       passenger.setBirthday(listpassenger.get(i).getBirthday());
							if (passenger.getPtype() == 1) {
								passenger.setPrice(segmentinfo.getPrice());
								passenger.setAirportfee(segmentinfo.getAirportfee());
								passenger.setFuelprice(segmentinfo.getFuelfee());
							} else if (passenger.getPtype() == 2) {
								passenger.setAirportfee(0f);
								passenger.setFuelprice(getRoundPrice(segmentinfo.getFuelfee(), 2));
								if (segmentinfo.getDiscount() > 100) {
									passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
								} else {
									passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
								}
							} else if(orderflag!=2) {
								passenger.setAirportfee(0f);
								passenger.setFuelprice(0f);
								// 儿童婴儿价
								if (segmentinfo.getDiscount() > 100) {
									passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 10));
								} else {
									passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 10));
								}
							}
							subprice += passenger.getPrice();
							subfuelfee += passenger.getFuelprice();
							subairportfee += passenger.getAirportfee();
							passenger.setDiscount(segmentinfo.getDiscount());
							listpass.add(passenger);
							
						}
					}
					/****乘机人信息赋值结束************************************************************/
					  // 机建费
					orderinfomodel.setTotalairportfee(subairportfee);
				      // 燃油费
					orderinfomodel.setTotalfuelfee(subfuelfee);
					  // 总机票价格+平台费用
					orderinfomodel.setTotalticketprice(subprice);
			    	 System.out.println("?????????????:"+subairportfee+","+subfuelfee+","+subprice);
			    	 
			    	orderinfomodel.setB2cprofit(FrmatJinYi((segmentinfo.getParvalue()*orderinfomodel.getFenxiaoshangfandian()/100))+"");
			    	orderinfomodel.setCclientpayprice(FrmatJinYi((subairportfee+subfuelfee+subprice))+"") ;
			    	 
			    	orderinfomodel.setPaystatus(0);
				    orderinfomodel.setOrderstatus(1);
			    	orderinfomodel.setPassengerlist(listpass);
			        listOrderinfo.add(orderinfomodel);
			    	
			       
			    	 
			    	 if(intIsCreateOuterOrder==1){
			    		
			    	String strExtOrderNumber = Server.getInstance().getRateService().CreateOrder(orderinfomodel,
			    			segmentinfo, orderinfomodel.getPassengerlist());
			    	WriteLog.write("外部订单返回", strExtOrderNumber);
					// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
					if (!strExtOrderNumber.equals("-1")) {
						if (orderinfomodel.getPolicyagentid() == 5 || orderinfomodel.getPolicyagentid() == 2||orderinfomodel.getPolicyagentid() == 7) {
						// 返回格式：S|订单号|支付url
						// 外部订单号
							

						if (strExtOrderNumber.indexOf("|") > 0) {
							String[] strExtOrderArr = strExtOrderNumber
									.split("[|]");
							if (strExtOrderArr.length == 3) {
								if (strExtOrderArr[0].equals("S")) {
									orderinfomodel
											.setExtorderid(strExtOrderArr[1]);
									orderinfomodel
											.setPaymenturl(strExtOrderArr[2]);
								}
							}
						}

					}else if(orderinfomodel.getPolicyagentid() == 6){
						if (strExtOrderNumber.indexOf("@") != -1) {
							String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfomodel.getPolicyagentid());
							orderinfomodel.setExtorderid(strExtOrderArrpnr[0].trim());
							//orderinfomodel.setPnr(strExtOrderArrpnr[1].trim());
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfomodel.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
					
							
							
							
							intIsCreated =0;
						}
					} else {
						// 外部订单号
						orderinfomodel.setExtorderid(strExtOrderNumber);
					}
					// 外部订单状态
					orderinfomodel.setExtorderstatus(0);
					// 外部订单创建时间
					orderinfomodel.setExtordercreatetime(new Timestamp(
							System.currentTimeMillis()));
					// 本地订单状态为待支付
					if (orderinfomodel.getPaymethod()==2
							|| orderinfomodel.getPaymethod()==3) {
						orderinfomodel.setPaystatus(0); // 已支付
						// 门市付款或者票到付款，则订单状态为等待出票
						orderinfomodel.setOrderstatus(1);
					} else {
						orderinfomodel.setOrderstatus(1);
					}
					// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
				} else {
					System.out.println("按照最优政策创建外部订单失败，返回结果:"
							+ strExtOrderNumber);
				}
			  } 
			//外部订单创建结束
			    	
					
					Float insurprice=0.0f;
					Float fparvalue=0f;
					if(segmentinfo.getParvalue()!=null && chengrenNUM>0)
					{
						fparvalue=segmentinfo.getParvalue();
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
							fparvalue=getRoundPrice(segmentinfo.getYprice(), 2);
						}
						else
						{
							fparvalue=segmentinfo.getParvalue();
						}
					}
					
					
					//返佣信息
			        String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfomodel.getRatevalue(),
							Getliudianvalue(orderinfomodel.getRatevalue()), fparvalue, insurprice);
					
					if(getLoginAgent().getBigtype()==2){
						
						Sysconfig sys = Server.getInstance().getSystemService()
						.findSysconfig(1);
				// 保存当前 保险成本 与购买数量
						String strsub = sys.getValue() + "|" + insurprice;
						strCustomgeragentBackPointInfo="1,0.00,"+fparvalue+","+orderinfomodel.getRatevalue()+"@46,"+(orderinfomodel.getRatevalue()-Float.parseFloat(getLoginAgent().getFixedvalue()))+","+fparvalue+","+orderinfomodel.getRatevalue()+"@"+getLoginAgent().getId()+","+getLoginAgent().getFixedvalue()+","+fparvalue+","+orderinfomodel.getRatevalue()+"@"+strsub;
					}
					
					System.out.println(strCustomgeragentBackPointInfo);
					//orderinfomodel.setFenxiaoshangfandian(Getliudianvalue(orderinfomodel.getRatevalue()));
					orderinfomodel.setBackpointinfo(strCustomgeragentBackPointInfo);
					
					
					WriteLog.write("订单信息","订单:"+orderinfomodel.toString());
					orderinfomodel = Server.getInstance().getAirService().createOrderinfo(orderinfomodel);
					
					System.out.println("订单详细信息");
					System.out.println(orderinfomodel.toString());
					System.out.println("订单详细信息============");
					System.out.println(orderinfomodel.getOrdernumber());
					System.out.println("订单信息==" + orderinfomodel);
					System.out.println("订单ID==" + orderinfomodel.getId());
					System.out.println("外部订单ID==" + orderinfomodel.getExtorderid());

					segmentinfo.setOrderid(orderinfomodel.getId());
					
					if(s==0){
						strNewTotalPrice=segmentinfo.getParvalue()+"";
					}
					
					// 获取新政策，更新航程信息
					Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
					 for(int p=0;p<listpass.size();p++){
				        	Passenger passenger=listpass.get(p);
				        	passenger.setOrderid(orderinfomodel.getId());
				        	Server.getInstance().getAirService().createPassenger(passenger);
				     }
						//创建操作记录
						try{
							Orderinforc orderinforc = new Orderinforc();
							orderinforc.setCustomeruserid(getLoginUserId());
							orderinforc.setOrderinfoid(orderinfomodel.getId());
							orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
							orderinforc.setContent("创建订单--" + this.getLoginUser().getMembername()+ "创建了订单");
							orderinforc.setSuouserid(orderinfomodel.getUserid());
							orderinforc.setState(orderinfomodel.getOrderstatus());
							orderinforc.setCustomeruserid(getLoginUserId());
							Server.getInstance().getAirService().createOrderinforc(orderinforc);
						}
						catch(Exception ex){
							System.out.println("创建操作记录异常："+ex.getMessage());
						}
						
						
						
						
						
						
						if (s == 0) {
							this.orderinfo1 = orderinfomodel;
						} else {
							this.orderinfo2 = orderinfomodel;
						}
						
						
						if(orderinfo2.getId()>0){
							String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
								+ orderinfo1.getId() + " WHERE ID=" + orderinfo2.getId()+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
								+ orderinfo2.getId() + " WHERE ID=" + orderinfo1.getId();
						Server.getInstance().getSystemService().findMapResultBySql(sql,	null);

						}
						ActionContext.getContext().getSession().remove(
								this.getLoginUserId() + "zrateone");
						ActionContext.getContext().getSession().remove(
								this.getLoginUserId() + "zratetwo");
						
						
						 //是否保存常用乘机人信息
						if(!issavepassenger.equals(""))
						{
						String[] ArrIsSaveNew = issavepassenger.split(",");
						
						for (int i = 0; i < listpassenger.size(); i++) {
							String where = " where 1=1 and "
									+ Customerpassenger.COL_customeruserid + " = "
									+ getLoginUser().getId() + " and "
									+ Customerpassenger.COL_username + " = '"
									+ listpassenger.get(i).getName().trim() + "'";

							List<Customerpassenger> list = Server.getInstance()
									.getMemberService().findAllCustomerpassenger(where,
											"", -1, 0);
							// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
							if (ArrIsSaveNew[i].equals("0")
									|| (list != null && list.size() > 0)) {
								continue;
							}
							try {
								// 当前登录员工
								Customeruser loginEmployee = getLoginUser();
								Customerpassenger customerpassenger = new Customerpassenger();
								customerpassenger.setCreatetime(new Timestamp(System
										.currentTimeMillis()));
								customerpassenger.setCreateuser(getLoginUser()
										.getLoginname());
								customerpassenger.setUsername(listpassenger.get(i)
										.getName().trim());
								customerpassenger.setType(1);
								customerpassenger.setCustomeruserid(loginEmployee
										.getId());
								customerpassenger = Server.getInstance()
										.getMemberService().createCustomerpassenger(
												customerpassenger);
								// 添加证件
								Customercredit customercredit = new Customercredit();
								customercredit.setCreatetime(new Timestamp(System
										.currentTimeMillis()));
								customercredit.setCreateuser(loginEmployee
										.getMembername());
								if(listpassenger.get(i).getPtype()==1){
								customercredit.setCreditnumber(listpassenger.get(i)
										.getIdnumber().trim());
								customercredit.setCredittypeid(listpassenger.get(i)
										.getIdtype());
								}
								customercredit.setModifytime(new Timestamp(System
										.currentTimeMillis()));
								customercredit.setModifyuser(loginEmployee
										.getMembername());
								customercredit.setRefid(customerpassenger.getId());
								customercredit.setType(1);
								Server.getInstance().getMemberService()
										.createCustomercredit(customercredit);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						}
						}
						//保存常用联系人结束
						
						System.out.println(orderinfo1.getId());
						System.out.println(orderinfo2.getId());
						strReturn = "b2bticketorder!payorder.action?orderinfo.id="
								+ orderinfo1.getId()+"&s_oldzratevalue="+strOldZrateValue+"&s_bestzratevalue="+strBestZrateValue+"&s_oldorderprice="+strOldTotalPrice+"&s_neworderprice="+strNewTotalPrice;
					
						if(getLoginAgent().getType()==2){
							strReturn = "b2bticketorder!payorder2.action?orderinfo.id="
								+ orderinfo1.getId();
						}
						
						
						//sendCreateOrderTXTSmstoPassenger(listpass, listsegmenginfo,orderinfo1);
				
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			System.out.println("错误:"+e.toString());
			//Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
			strReturn="ERRER";
			}
		
		
		
		
		
		
		
		
		
		
		
		

		return strReturn;
	}
	
	public String CreateOrder(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{
		String strReturn="NOPNR";
		
		String s_returnpnr="";
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 1;
		// 是否生成PNR
		int intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
	
		// 是否生成外部订单
		int intIsCreateOuterOrder =0; //0不生成外部订单   1生成外部订单
		// 是否按照原政策信息已经生成外订单
		int intIsCreated = 1;//0按照本地政策   1按照最优政策
		
		int IsWhy=1; //0不分润接口   1分润接口
		
		String B2cWebPrice="";//B2C网站利润
		String WebPayPrice="";//C端支付价
		
		int chengrenNUM=0;//成人数量
		
		if(orderflag==2){//PNR导入的,不生成PNR
			intIsCreatePNR=0;
		}
		
		
		
		Zrate zrate2 = Server.getInstance().getAirService().findZrate(zratelist.get(0));
		if(zrate2.getAgentid()>10){//如果是本地政策供应商 不生成外部订单  使用本地政策
			intIsCreated=0;
			intIsCreateOuterOrder=0;
		}
		
		//如果是今日政策,不生成PNR,今日会生成PNR
		
		/*if(zrate2.getAgentid()==6){//如果是本地政策供应商 不生成外部订单  使用本地政策
			
			intIsCreated=0;
			intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
		}*/
		
		//如果是票盟  不匹配最优政策--成人
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==1){//如果是票盟
			System.out.println("票盟的政策,成人订单,不匹配最优了,按照本地政策");
			intIsCreated=0;
			intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		//如果是票盟  不匹配最优政策--儿童  下单到今日
		if(zrate2.getAgentid()==2&&listpassenger.get(0).getPtype()==2){//如果是票盟
			System.out.println("票盟的政策,儿童订单,下单给今日");
			intIsCreated=1;
			intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		}
		
		
		//开始判断是否生成pnr和外部订单
		String wherefig=" where 1=1 and "+Sysconfig.COL_name+" ='ispnrandorder'";
		List<Sysconfig>listfig=Server.getInstance().getSystemService().findAllSysconfig(wherefig, " ORDER BY ID ", -1, 0);
		if(listfig!=null&&listfig.size()>0){
			if(listfig.get(0).getValue().equals("-1")){
				System.out.println("不生成PNR和外部订单了");
				intIsCreatePNR=0;
				intIsCreateOuterOrder=0;
				intIsCreated=0;
			}
			
		}
		//
		
		
	//----------------------------------------------------------------------------------------------------------------
		
		
		String jinriprice="";
	
	
		
		// 最优政策
		Zrate bestzrate = new Zrate();
		String[] bxcounts = insurances.trim().split(",");
		//本地订单旧政策
		String strOldZrateValue="0";
		//最优政策
		String strBestZrateValue="0";
		//黑屏PAT票价，燃油，机建
		String pat_Price="0";
		String pat_Fuleprice="0";
		String pat_airportfee="0";
		//用于PAT:A价格发生变化时，订单提醒
		String strOldTotalPrice="0";
		String strNewTotalPrice="0";
		
		try{
			//订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			
			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize=listsegmenginfo.size();
			/******************循环航程list,并创建订单开始*************************/
			for(int s=0;s<intsegmentsize;s++)
			{
				
				
				
				//先生成PNR
				if (intCreatePNRType == 1) {
					//往返不在同1PNR
					List<Segmentinfo>listseg=new ArrayList<Segmentinfo>();
					listseg.add(listsegmenginfo.get(0));
					s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listseg, listpassenger, orderinfo.getNewpnr());	
					//往返在同1PNR
				    //s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
				} else {
				//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassenger, orderinfo);
				}
				
				   if(s_returnpnr.equals("-1")||s_returnpnr.equals("NOPNR")){
					//如果没有生成PNR...不创建外部订单,创建内部订单
						intIsCreateOuterOrder=0;
						intIsCreatePNR=0;
						s_returnpnr="123456";
						 return "NOPNR";
					}else{
						
						if(intCreatePNRType==2){//51创建PNR
							String newpnr="";
							String pnrtxt="";
							String pattxt="";
							
							if(s_returnpnr.indexOf("@")!=-1){
							newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];
							}else{
							newpnr=	s_returnpnr;
							}
							orderinfo.setPattxt(pattxt);
							orderinfo.setPnrtxt(pnrtxt);
							orderinfo.setPnr(newpnr);
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								 return "NOPNR";
							}
						}else{//黑屏创建
							
							String pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr, "", "");
							
							
							
							//原始的用
							int ind=0;
							
							if(pnrtxt.indexOf("+")>0){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							//放大不规范的用
							
							/*for(int a=0;a<4;a++){
							pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							if(pnrtxt.indexOf("      -")!=-1){
								break;
							}
							}
							
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							if(pnrtxt.indexOf(" -")!=-1){
								System.out.println("pnrtxt:"+pnrtxt);
								pnrtxt=pnrtxt.replaceAll(" -", "");
							}*/
							
							
							System.out.println("pnrtxt:"+pnrtxt);
							
							//NKG170
							/*if(pnrtxt!=null&&pnrtxt.indexOf("NKG170")!=-1){
								
								pnrtxt=pnrtxt.split("[.]NKG170")[0]+".NKG170";
							}*/
							
							String strPat="PAT:A";
							String str=""+listpassenger.get(0).getName()+"CHD";
							for(int w=0;w<listpassenger.size();w++){
								if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
									strPat="PAT:A*CH";
									orderflag=4;
									break;
								}
							}
								
					
							
							/*if(pnrtxt.indexOf(str)!=-1){
								strPat="PAT:A*CH";
								
							}*/
							
							
							
							String pattxt=Server.getInstance().getTicketSearchService().commandFunction2(strPat, "", "");
							System.out.println("pattxt:"+pattxt);
							if(pattxt.indexOf(">")!=-1){
								pattxt=pattxt.replaceAll(">", "");
							}
							
							
							if(pnrtxt!=null&&pnrtxt.indexOf("URC220")!=-1){
								pnrtxt=pnrtxt.split("[.]URC220")[0]+".URC220";
							}
							
							
							System.out.println("pattxt:"+pattxt);
							/*newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];*/
							orderinfo.setPattxt(pattxt);
							orderinfo.setPnrtxt(pnrtxt);
							orderinfo.setPnr(s_returnpnr);
							
							
							String	strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
						
							orderinfo.setBigpnr(strBigPNR);
							
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								//生成外部订单失败,取消PNR
								Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
								
								 return "NOPNR";
							}
							
							
						}
					}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				List<Passenger> listpassengermodel=new ArrayList<Passenger>();
				Orderinfo orderinfomodel = new Orderinfo();
				orderinfomodel.setCreatetime(orderinfo.getCreatetime());
				orderinfomodel.setCustomeruserid(orderinfo.getCustomeruserid());
				orderinfomodel.setSaleagentid(orderinfo.getSaleagentid());
				orderinfomodel.setBuyagentid(orderinfo.getBuyagentid());
				orderinfomodel.setContactmobile(orderinfo.getContactmobile());
				orderinfomodel.setPaystatus(orderinfo.getPaystatus());
				orderinfomodel.setOrderstatus(orderinfo.getOrderstatus());
				orderinfomodel.setPaymethod(orderinfo.getPaymethod());
				orderinfomodel.setCurrplatfee(orderinfo.getCurrplatfee());
				orderinfomodel.setLanguage(orderinfo.getLanguage());
				orderinfomodel.setOrdertype(orderinfo.getOrdertype());
				orderinfomodel.setPnr(orderinfo.getPnr());
				
				if(orderinfo.getContactemail()!=null){
				orderinfomodel.setContactemail(orderinfo.getContactemail());
				}
				if(orderinfo.getContacttel()!=null){
					orderinfomodel.setContacttel(orderinfo.getContacttel());
				}
				
				if(orderinfo.getPostmoney()!=null){
				orderinfomodel.setPostmoney(orderinfo.getPostmoney());
				}
				if(orderflag==2){
					orderinfomodel.setPnrtxt(orderinfo.getPnrtxt());
					orderinfomodel.setPattxt(orderinfo.getPattxt());
				}
				orderinfomodel.setBigpnr(orderinfo.getBigpnr());
				orderinfomodel.setContactname(orderinfo.getContactname());
				if(orderinfo.getMemo()!=null){
				orderinfomodel.setMemo(orderinfo.getMemo());
				}
				Segmentinfo segmentinfo=listsegmenginfo.get(s);
				/*****订单信息赋值开始************************************************************/
				/****本地政策赋值开始*****************************************/
				Zrate zrate = Server.getInstance().getAirService().findZrate(zratelist.get(s));
				
				orderinfo.setPolicyid(zrate.getId());
				orderinfo.setPolicyagentid(zrate.getAgentid());
				orderinfo.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
				//判断开始.判断是否是固定饭店用户;
				
				/*if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
					zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
				}*/
				if(zrate.getWorkstatus()!=null){
				orderinfomodel.setPickonename(zrate.getWorkstatus());//office
				}
				if(zrate.getSpeed()!=null){
					if(zrate.getAgentid()==5){
					orderinfomodel.setPickonephone(zrate.getSpeed());//出票速度
					}
					if(zrate.getAgentid()==6){
					orderinfomodel.setPickonephone(zrate.getSpeed()+"分钟");//出票速度
					}
				}
				orderinfomodel.setPolicyid(zrate.getId());//政策ID
				if(getLoginAgent().getBigtype()==2){//固定返点
					orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(getLoginAgent().getFixedvalue())));// 分销商返点
				}else{
					orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate.getRatevalue())));// 分销商返点
				}
				
				
			
				
				//记录当前政策值
				strOldZrateValue=String.valueOf(orderinfomodel.getFenxiaoshangfandian());
				orderinfomodel.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfomodel.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfomodel.setExtpolicyid(zrate.getOutid()); // 外部政策id
				orderinfomodel.setPostmobile(zrate.getWorktime()+"-"+zrate.getAfterworktime());
				segmentinfo.setAgentid(zrate.getAgentid());
				segmentinfo.setRatevalue(zrate.getRatevalue());
				
				segmentinfo.setZrateid(zrate.getId());
				segmentinfo.setLanguage(0);
				segmentinfo.setZrate(zrate);
				/****本地政策赋值结束*****************************************/ 
				
				/****订单信息赋值结束************************************************************/
				float subfuelfee = 0;
				float subairportfee = 0;
				float subprice = 0;
				/****乘机人信息赋值开始************************************************************/
				for (int i = 0; i < listpassenger.size(); i++) {
					if (listpassenger.get(i).getName().trim().length() > 0) {
						
						 if (listpassenger.get(i).getPtype() == 1) {
								chengrenNUM++;
							}
							int bxcount = 0;
							   bxcount=Integer.valueOf(bxcounts[i].trim());
						
						   Passenger passenger =new Passenger();
						   
						   Float bxp=20f;
						   HttpSession session = ServletActionContext.getRequest().getSession();
							if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
								bxp=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
							}
						   
						   passenger.setInsurprice(bxcount*bxp);
					       passenger.setName(listpassenger.get(i).getName());
					       passenger.setPtype(listpassenger.get(i).getPtype());
					       passenger.setIdnumber(listpassenger.get(i).getIdnumber());
					       passenger.setIdtype(listpassenger.get(i).getIdtype());
					       passenger.setState(listpassenger.get(i).getState());
					       passenger.setLanguage(listpassenger.get(i).getLanguage());
					       passenger.setAirportfee(listpassenger.get(i).getAirportfee());
					       passenger.setFuelprice(listpassenger.get(i).getFuelprice());
					       passenger.setPrice(listpassenger.get(i).getPrice());
					       passenger.setBirthday(listpassenger.get(i).getBirthday());
						if (passenger.getPtype() == 1  && orderflag!=2) {
							passenger.setPrice(segmentinfo.getPrice());
							passenger.setAirportfee(segmentinfo.getAirportfee());
							passenger.setFuelprice(segmentinfo.getFuelfee());
						} else if (passenger.getPtype() == 2 && orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(getRoundPrice(segmentinfo.getFuelfee(), 2));
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
							}
						} else if(orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(0f);
							// 儿童婴儿价
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 10));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 10));
							}
						}
						subprice += passenger.getPrice();
						subfuelfee += passenger.getFuelprice();
						subairportfee += passenger.getAirportfee();
						passenger.setDiscount(segmentinfo.getDiscount());
						listpassengermodel.add(passenger);
					}
				}
				/****乘机人信息赋值结束************************************************************/
				if(orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().equals(""))
				{
					System.out.println("小PNR导入，创建订单 PNR:"+orderinfomodel.getPnr());
					s_returnpnr=orderinfo.getPnr();
				}
				else if(orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().equals(""))
				{
					System.out.println("大PNR导入，创建订单  PNR:"+orderinfomodel.getBigpnr());
					s_returnpnr=orderinfomodel.getBigpnr();
				}
				else if(intIsCreatePNR==1)
				{
					if (intCreatePNRType == 1) {
						//往返不在同1PNR
						List<Segmentinfo>listseg=new ArrayList<Segmentinfo>();
						listseg.add(listsegmenginfo.get(s));
						s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listseg, listpassengermodel, orderinfo.getNewpnr());	
						//往返在同1PNR
					    //s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					} else {
					//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
						s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassengermodel, orderinfo);
					}
					System.out.println("**********************生成的PNR编码："+ s_returnpnr);
					if(s_returnpnr.equals("-1")||s_returnpnr.equals("NOPNR")){
					//如果没有生成PNR...不创建外部订单,创建内部订单
						intIsCreateOuterOrder=0;
						intIsCreatePNR=0;
						s_returnpnr="123456";
						 return "NOPNR";
					}else{
						
						if(intCreatePNRType==2){//51创建PNR
							String newpnr="";
							String pnrtxt="";
							String pattxt="";
							
							if(s_returnpnr.indexOf("@")!=-1){
							newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];
							}else{
							newpnr=	s_returnpnr;
							}
							orderinfomodel.setPattxt(pattxt);
							orderinfomodel.setPnrtxt(pnrtxt);
							orderinfomodel.setPnr(newpnr);
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								 return "NOPNR";
							}
						}else{//黑屏创建
							
							String pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr, "", "");
							
							
							
							//原始的用
							int ind=0;
							
							if(pnrtxt.indexOf("+")>0){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							//放大不规范的用
							
							/*for(int a=0;a<4;a++){
							pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							if(pnrtxt.indexOf("      -")!=-1){
								break;
							}
							}
							
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("      -")==-1){
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							if(pnrtxt.indexOf(" -")!=-1){
								System.out.println("pnrtxt:"+pnrtxt);
								pnrtxt=pnrtxt.replaceAll(" -", "");
							}*/
							
							
							System.out.println("pnrtxt:"+pnrtxt);
							
							//NKG170
							/*if(pnrtxt!=null&&pnrtxt.indexOf("NKG170")!=-1){
								
								pnrtxt=pnrtxt.split("[.]NKG170")[0]+".NKG170";
							}*/
							
							String strPat="PAT:A";
							String str=""+listpassenger.get(0).getName()+"CHD";
							for(int w=0;w<listpassenger.size();w++){
								if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
									strPat="PAT:A*CH";
									orderflag=4;
									break;
								}
							}
								
					
							
							/*if(pnrtxt.indexOf(str)!=-1){
								strPat="PAT:A*CH";
								
							}*/
							
							
							
							String pattxt=Server.getInstance().getTicketSearchService().commandFunction2(strPat, "", "");
							System.out.println("pattxt:"+pattxt);
							if(pattxt.indexOf(">")!=-1){
								pattxt=pattxt.replaceAll(">", "");
							}
							
							
							if(pnrtxt!=null&&pnrtxt.indexOf("URC220")!=-1){
								pnrtxt=pnrtxt.split("[.]URC220")[0]+".URC220";
							}
							
							
							System.out.println("pattxt:"+pattxt);
							/*newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];*/
							orderinfomodel.setPattxt(pattxt);
							orderinfomodel.setPnrtxt(pnrtxt);
							orderinfomodel.setPnr(s_returnpnr);
							
							
							String	strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
						
							orderinfomodel.setBigpnr(strBigPNR);
							
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								//生成外部订单失败,取消PNR
								Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
								
								 return "NOPNR";
							}
							
							
						}
					}
				}
				else
				{
					s_returnpnr="123456";
				}
				
				// 判断是否生成PNR
				if (s_returnpnr.equals("NOPNR")) {
					strReturn = "NOPNR";
					
					break;
				}
				// 机建费
				orderinfomodel.setTotalairportfee(subairportfee);
				// 燃油费
				orderinfomodel.setTotalfuelfee(subfuelfee);
				// 总机票价格+平台费用
				orderinfomodel.setTotalticketprice(subprice);// 存入数据库中的数据
				//
				float totalallprice=orderinfomodel.getTotalairportfee()+orderinfomodel.getTotalfuelfee()+orderinfomodel.getTotalticketprice();
				strOldTotalPrice=String.valueOf(totalallprice);
				if((orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().trim().equals("")) || (orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().trim().equals("")))
				{
					System.out.println("PNR导入订单信息");
				}
				else
				{
					
					String strBigPNR = "无";
					//只有51book才获取大PNR
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
					/*if (orderinfomodel.getPolicyagentid() == 5) {
						strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
					}
					orderinfomodel.setBigpnr(strBigPNR);*/
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
				}
				
				//orderinfomodel.setPostmoney(0);
				orderinfomodel.setPassengerlist(listpassengermodel);
				listOrderinfo.add(orderinfomodel);
			}
			/******************循环航程list,并创建订单结束*************************/
			
			//如果生成PNR则创建订单，否则提示创建订单失败
			
			List<Segmentinfo> seglist=new ArrayList<Segmentinfo>();
			
			if (!s_returnpnr.equals("NOPNR")) {
				for (int j = 0; j < listOrderinfo.size(); j++) {
				  Orderinfo	orderinfonew = listOrderinfo.get(j);

					Segmentinfo seginfo = listsegmenginfo.get(j);
					//*****************************************************//
					//Pat:a取得黑屏中票价--------------------------------------PAT-------------------------------------------------------
					String strPatInfo="";
		
					//if(intIsCreatePNR==1 && orderflag==4){//old
					if(intIsCreatePNR==1&&intCreatePNRType==1&&1==2){
						
						 System.out.println("核对黑屏价格-原来价格:"+seginfo.getParvalue());
						
						 strPatInfo=orderinfonew.getPattxt();
						 System.out.println("核对黑屏价格-PAT:"+strPatInfo);
					try
					{
					
					
						  
						  String[] strpatItem=strPatInfo.split(" ");
						  System.out.println("核对黑屏价格-数组:"+strpatItem.length);
						  for(int i=0;i<strpatItem.length;i++) 
						  {
							  if(!strpatItem[i].trim().equals(""))
							  {
								  //票价
								  if(strpatItem[i].trim().indexOf("FARE:")>=0)
								  {
									  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
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
								  
								  if(!pat_Price.equals("0")&&!pat_Fuleprice.equals("0")&&!pat_airportfee.equals("0")){
									  
									  break;
								  }
								  
							  }
						  }
					  
					  //核对黑屏中价格信息与航程中价格信息是否一样
					  Float f_segmentprice=0f;
					  Float f_segmentfuelprice=0f;
					  Float f_segmentairportfee=0f;
				      f_segmentprice=Float.parseFloat(pat_Price);
				      f_segmentfuelprice=Float.parseFloat(pat_Fuleprice);
				      f_segmentairportfee=Float.parseFloat(pat_airportfee);
				      
				    
				    	
				    	  
				    	  float sub_price=0;
				    	  float sub_fuelfee=0;
				    	  float sub_airportfee=0;
				    	 
				    	 for (Passenger passenger:orderinfonew.getPassengerlist()) 
				    	  {
				    		  System.out.println("循环");
				    		 
				    		  
				    		  passenger.setAirportfee(f_segmentairportfee);
				    		  passenger.setFuelprice(f_segmentfuelprice);
				    		  passenger.setPrice(f_segmentprice);
				    		  sub_price += passenger.getPrice();
							  sub_fuelfee += passenger.getFuelprice();
						      sub_airportfee += passenger.getAirportfee();
				    	  }
				    	  
				    	  
				    	/*  for(int p=0;p<orderinfonew.getPassengerlist().size();p++){
				    		  System.out.println("循环");
				    		 
				    		  
				    		  orderinfonew.getPassengerlist().get(p).setAirportfee(f_segmentairportfee);
				    		  orderinfonew.getPassengerlist().get(p).setFuelprice(f_segmentfuelprice);
				    		  orderinfonew.getPassengerlist().get(p).setPrice(f_segmentprice);
				    		  sub_price +=  orderinfonew.getPassengerlist().get(p).getPrice();
							  sub_fuelfee +=  orderinfonew.getPassengerlist().get(p).getFuelprice();
						      sub_airportfee +=  orderinfonew.getPassengerlist().get(p).getAirportfee();
				    	  }*/
				    	  
				    	  //修改订单中的价格信息
				    	  // 机建费
				    	  orderinfonew.setTotalairportfee(sub_airportfee);
					      // 燃油费
				    	  orderinfonew.setTotalfuelfee(sub_fuelfee);
						  // 总机票价格+平台费用
				    	  orderinfonew.setTotalticketprice(sub_price);
				    	  
				    	  
				    	  System.out.println("?????????????:"+sub_airportfee+","+sub_fuelfee+","+sub_price);
				    	  
				    	  seginfo.setParvalue(Float.parseFloat(pat_Price));
				    	  
				    	  seglist.add(seginfo);
					  
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
					System.out.println("**********************PAT:A："+ strPatInfo);
					System.out.println("**********************黑屏中：票价"+ pat_Price+"|||燃油："+pat_Fuleprice+"||||机建"+pat_airportfee);
				}
					
					//************************pat-----------------------------------------------PAT-------------------****************************//
					
					
					
					
					// 如果是其他供应商政策，则不生成外部订单-----------------------判断是否创建外部------------------------------------------
					if ((orderinfonew.getPolicyagentid() == 3 ||orderinfonew.getPolicyagentid() == 6
							|| orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2 || orderinfonew.getPolicyagentid() == 46)
							&& intIsCreateOuterOrder == 1) {
						intIsCreateOuterOrder = 1;
						System.out.println("属于平台政策：是否创建外部订单："+ intIsCreateOuterOrder);
					} else {
						intIsCreateOuterOrder = 0;
						// 不属于平台政策，则可以直接支付订单
						if(orderinfonew.getPaymethod()==2 || orderinfonew.getPaymethod()==3)
						{
							orderinfonew.setOrderstatus(2);
						}
						else
						{
						   orderinfonew.setOrderstatus(1);
						}
						System.out.println("不属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
						
						
					}
					
					
					
					
					
					//是否创建外部订单开始----------------------------------------------------------------------------------------------
					if (intIsCreateOuterOrder == 1) {
						try {
							//如果是普通政策，则直接按照最优政策生成订单
							if(intIsCreated==0)
							{
								
								bestzrate=seginfo.getZrate();
								//计算利润
								System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
								WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
								
								if(WebPayPrice.equals("0.0")){
									WebPayPrice="0";
								}else{
									
									WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
									
								}
								
								//从新计算价格开始
								
								float newprice=0f;
								float baoxianprice=0f;
								int l = 0;
								for (Passenger passeng : orderinfonew.getPassengerlist()) {
									passeng.setOrderid(orderinfonew.getId());
									
									
									// 获取最优政策，更新乘机人信息
									// Created 
									// 2011-10-18
									if (bestzrate != null
											&& bestzrate.getRatevalue() != null
											&& bestzrate.getAgentid() != null) {
										
										
										
										
										//计算保险
										float bxcb=20f;
										HttpSession session = ServletActionContext.getRequest().getSession();
										if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
											bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
										}
										
										
										
										int bxcount = 0;
										try{
										bxcount=Integer.valueOf(bxcounts[l].trim());
										}catch(Exception e){
										}
										if (bxcount> 0) {							
											passeng.setInsurprice(bxcount*bxcb);
											if (listsegmenginfo.size()==2) {
												if (!new B2bAirSearchAction().isInInsrutime(
														listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
													if (j == 0) {
														int count = 1;
														if (Integer.valueOf(bxcount) > 1) {
															count = (int) Math.ceil(Integer
																	.valueOf(bxcount) / 2.0);
														}
													
														passeng.setInsurprice(bxcb*count);
													} else {
														int count = 1;
														if (Integer.valueOf(bxcount) > 1) {
															count = (int) Math.floor(Integer
																	.valueOf(bxcount) / 2.0);
						
															passeng.setInsurprice(bxcb*count);
														}
													}

												} else {//在一个保险期内
													if (j == 0) {
														
													//	passeng.setInsurance(insurance.getId());
														passeng.setInsurprice(bxcount*bxcb);
													}
												}
											} else {
												passeng.setInsurprice(bxcount*bxcb);

											}
											
										}
										
										//计算保险结束
										
										
										
										
										
										
										if (passeng.getPtype() == 1) {
											passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
													.getRatevalue()))/100);
											
										} else if (passeng.getPtype() == 2) {
											passeng.setAirportfee(0f);
											
											//平台创建儿童订单
											if(orderflag!=2)
											{
												/*passeng.setFuelprice(getRoundPrice(seginfo
														.getFuelfee(), 2));*/
												if (seginfo.getDiscount() > 100) {
													passeng.setPrice(getRoundPrice(seginfo
															.getParvalue(), 2));
												} else {
													passeng.setPrice(getRoundPrice(seginfo
															.getYprice(), 2));
												}
											}
											
										} else {
											passeng.setAirportfee(0f);
											passeng.setFuelprice(0f);
											// 儿童婴儿价
											if(orderflag!=2)
											{
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 10));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 10));
											}
											}
											
										}
										newprice += passeng.getPrice();
										// 获取最优政策，更新乘机人信息
										// 结束
										baoxianprice+=passeng.getInsurprice();
									}
									l++;
									
								}
								
								//计算结束
								
								B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
								
								
								B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
								
								System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice+",baoxianprice:"+baoxianprice);
								String bxprice="0";
								if(baoxianprice==0){
									bxprice="0";
								}else{
									bxprice=(Math.floor(Float.parseFloat(baoxianprice+""))+"").substring(0, (Math.floor(Float.parseFloat(baoxianprice+""))+"").indexOf("."));
								}
								WriteLog.write("下单前记录价格信息-未匹配最优政策","C支付价格:"+B2cWebPrice+",利润:"+WebPayPrice+",保险价格:"+bxprice);
								orderinfonew.setB2cprofit(Integer.parseInt(WebPayPrice)+Integer.parseInt(bxprice)+"");//B2C利润
								orderinfonew.setCclientpayprice(Integer.parseInt(B2cWebPrice)+Integer.parseInt(bxprice)+"");//c端支付价
								orderinfonew.setIspayhthy(IsWhy);
								
								
								//如果是儿童 创建51
								for(int w=0;w<listpassenger.size();w++){
									if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
										orderinfonew.setPolicyagentid(6l);
										break;
									}
								}
								
								
								
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							
							
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								intIsCreated = 0;
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else if(orderinfonew.getPolicyagentid() == 6){
									if (strExtOrderNumber.indexOf("@") != -1) {
										String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
										orderinfonew.setExtorderid(strExtOrderArrpnr[0].trim());
										orderinfonew.setPnr(strExtOrderArrpnr[1].trim());
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
								
										jinriprice=strExtOrderArrpnr[3].trim();
										
										/*	if(!strExtOrderArrpnr[2].trim().equals(orderinfonew.getRatevalue())){//如果政策返点和下单返点不一致,更新价格
										System.out.println("今日生成订单的返点和下单的返点不一致,下单时候的返点=="+orderinfonew.getRatevalue()+",生成订单的返点=="+strExtOrderArrpnr[2].trim()+",订单总价=="+strExtOrderArrpnr[3].trim());
										orderinfonew.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										orderinfonew.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue())));
										
										//从新计算价格开始
										bestzrate.setAgentid(6l);
										bestzrate.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										
										//float newprice=0f;
										for (Passenger passeng : orderinfonew.getPassengerlist()) {
											passeng.setOrderid(orderinfonew.getId());
											
											
											// 获取最优政策，更新乘机人信息
											// Created By:sunbin
											// 2011-10-18
											if (bestzrate != null
													&& bestzrate.getRatevalue() != null
													&& bestzrate.getAgentid() != null) {
												if (passeng.getPtype() == 1) {
													passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
															.getRatevalue()))/100);
													
												} else if (passeng.getPtype() == 2) {
													passeng.setAirportfee(0f);
													
													//平台创建儿童订单
													if(orderflag!=2)
													{
														passeng.setFuelprice(getRoundPrice(seginfo
																.getFuelfee(), 2));
														if (seginfo.getDiscount() > 100) {
															passeng.setPrice(getRoundPrice(seginfo
																	.getParvalue(), 2));
														} else {
															passeng.setPrice(getRoundPrice(seginfo
																	.getYprice(), 2));
														}
													}
													
												} else {
													passeng.setAirportfee(0f);
													passeng.setFuelprice(0f);
													// 儿童婴儿价
													if(orderflag!=2)
													{
													if (seginfo.getDiscount() > 100) {
														passeng.setPrice(getRoundPrice(seginfo
																.getParvalue(), 10));
													} else {
														passeng.setPrice(getRoundPrice(seginfo
																.getYprice(), 10));
													}
													}
													
												}
												newprice += passeng.getPrice();
												// 获取最优政策，更新乘机人信息
												// 结束
											}
											
											
										}
										
										//计算结束
										
										}*/
										intIsCreated =0;
									}
								}else{
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								//orderinfonew.setReceipt(Integer.parseInt(bestzrate.getGeneral()+""));//政策类型  普通 特殊
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
								System.out.println("按照本地政策，创建外部订单成功，返回结果订单号:"+ strExtOrderNumber);
							} else {
								intIsCreated = 1;
								System.out.println("按照本地政策，创建外部订单失败，返回结果:"+ strExtOrderNumber);
								
								intIsCreateOuterOrder=0;
								System.out.println("按照本地政策，创建外部订单失败，创建本地订单:intIsCreateOuterOrder:"+intIsCreateOuterOrder);
							}
							
							
							}
							else//匹配最优政策
							{
							
								intIsCreated = 1;
							}
						} catch (Exception ex) {
							intIsCreated = 0;
							System.out.println("按照本地政策，创建外部订单失败，异常结果:"
									+ ex.getMessage());
						}
						/*System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						System.out.println("是否生成外部订单标记：" + intIsCreateOuterOrder
								+ " 是否已按照原始政策生成外部订单：" + intIsCreated);*/
					}
					
					//创建外部订单结束---------------------------------------------------------------------------------------------------------
					
					
					// 如果没有按照原始政策，生成外部订单，则按照最优政策信息，再次生成外部订单
					
					//if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
					if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
						// 匹配最优政策，并生成外部订单
						
						System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						try {
							try {
								if(orderinfonew.getPassengerlist().get(0).getPtype()==1)
								{
								bestzrate = Server.getInstance()
										.getRateService().FindZrateByFlight(
												orderinfonew, seginfo,
												orderinfonew.getPassengerlist());
								}else if(orderinfonew.getPassengerlist().get(0).getPtype()==2)
								{
									orderinfonew.setPolicyagentid(6l);
									bestzrate = Server.getInstance()
											.getRateService().FindZrateByFlight(
													orderinfonew, seginfo,
													orderinfonew.getPassengerlist());
									}
								else
								{
									bestzrate =Server.getInstance().getAirService().findZrate(1l);
								}
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									try {
										// 计算价格
										orderinfonew
												.setPolicyid(bestzrate.getId());// 政策ID
										
										if(getLoginAgent().getBigtype()==2){//如果是固定返点
											orderinfonew
											.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(getLoginAgent().getFixedvalue())));// 分销商返点
											
										}else{
											orderinfonew
											.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
													.getRatevalue())));// 分销商返点
											
										}
										
										//记录最优政策返销商返点
										strBestZrateValue=String.valueOf(orderinfonew.getFenxiaoshangfandian());
										orderinfonew.setPolicyagentid(bestzrate
												.getAgentid());// 政策提供商id
										
										
											if(bestzrate.getWorkstatus()!=null){
											orderinfonew.setPickonename(bestzrate.getWorkstatus());//office
											}
											
											if(bestzrate.getSpeed()!=null){
												if(bestzrate.getAgentid()==5){
												orderinfonew.setPickonephone(bestzrate.getSpeed());//出票速度
												}
												if(bestzrate.getAgentid()==6){
													orderinfonew.setPickonephone(bestzrate.getSpeed()+"分钟");//出票速度
												}
											}
											
											
										orderinfonew
												.setRatevalue(dceimalFormat(bestzrate
														.getRatevalue()));// 折扣
										orderinfonew.setExtpolicyid(bestzrate
												.getOutid()); // 外部政策id
										System.out.println("调用最优政策方法,成功,政策为=="
												+ bestzrate);
									} catch (RuntimeException e) {
										System.out
												.println("调用最优政策方法,出现异常,异常信息："
														+ e.getMessage());
										e.printStackTrace();
									}
								}else{
									
									
									bestzrate=Server.getInstance().getAirService().findZrate(zratelist.get(j));
								}

							} catch (RuntimeException e) {
								System.out.println("调用最优政策方法,出现异常,异常信息："
										+ e.getMessage());
								e.printStackTrace();
							}
							seginfo.setZrate(bestzrate);
							// 创建外部订单，方法调用
							
							System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
							WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
							
							if(WebPayPrice.equals("0.0")){
								WebPayPrice="0";
							}else{
								WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
								
							}
							
							//从新计算价格开始
							
							float newprice=0f;
							float baoxianprice=0f;
							int l = 0;
							
							for (Passenger passeng : orderinfonew.getPassengerlist()) {
								passeng.setOrderid(orderinfonew.getId());
								
								
								// 获取最优政策，更新乘机人信息
								// Created By:cxx
								// 2011-10-18
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									
									
									//计算保险
									float bxcb=20f;
									HttpSession session = ServletActionContext.getRequest().getSession();
									if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
										bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
									}
									int bxcount = 0;
									try{
									bxcount=Integer.valueOf(bxcounts[l].trim());
									}catch(Exception e){
									}
									if (bxcount> 0) {							
										passeng.setInsurprice(bxcount*bxcb);
										if (listsegmenginfo.size()==2) {
											if (!new B2bAirSearchAction().isInInsrutime(
													listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
												if (j == 0) {
													int count = 1;
													if (Integer.valueOf(bxcount) > 1) {
														count = (int) Math.ceil(Integer
																.valueOf(bxcount) / 2.0);
													}
												
													passeng.setInsurprice(bxcb*count);
												} else {
													int count = 1;
													if (Integer.valueOf(bxcount) > 1) {
														count = (int) Math.floor(Integer
																.valueOf(bxcount) / 2.0);
					
														passeng.setInsurprice(bxcb*count);
													}
												}

											} else {//在一个保险期内
												if (j == 0) {
													
												//	passeng.setInsurance(insurance.getId());
													passeng.setInsurprice(bxcount*bxcb);
												}
											}
										} else {
											passeng.setInsurprice(bxcount*bxcb);

										}
										
									}
									
									//计算保险结束
									
									
									
									
									
									
									
									if (passeng.getPtype() == 1) {
										passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue()))/100);
										
									} else if (passeng.getPtype() == 2) {
										passeng.setAirportfee(0f);
										
										//平台创建儿童订单
										if(orderflag!=2)
										{
											/*passeng.setFuelprice(getRoundPrice(seginfo
													.getFuelfee(), 2));*/
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 2));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 2));
											}
										}
										
									} else {
										passeng.setAirportfee(0f);
										passeng.setFuelprice(0f);
										// 儿童婴儿价
										if(orderflag!=2)
										{
										if (seginfo.getDiscount() > 100) {
											passeng.setPrice(getRoundPrice(seginfo
													.getParvalue(), 10));
										} else {
											passeng.setPrice(getRoundPrice(seginfo
													.getYprice(), 10));
										}
										}
										
									}
									newprice += passeng.getPrice();
									// 获取最优政策，更新乘机人信息
									// 结束
									
									if(passeng.getInsurprice()!=null){
									baoxianprice+=passeng.getInsurprice();
									}
									
								}
								l++;
								
							}
							
							//计算结束
							
							B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
							
							
							B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
							
							System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice+",baoxianprice:"+baoxianprice);
							
							String bxprice="0";
							if(baoxianprice==0){
								bxprice="0";
							}else{
								bxprice=(Math.floor(Float.parseFloat(baoxianprice+""))+"").substring(0, (Math.floor(Float.parseFloat(baoxianprice+""))+"").indexOf("."));
								
							}
							
							WriteLog.write("下单前记录价格信息-匹配最优政策","C支付价格:"+B2cWebPrice+",利润:"+WebPayPrice+",保险价格:"+bxprice);
							
							orderinfonew.setB2cprofit(Integer.parseInt(WebPayPrice)+Integer.parseInt(bxprice)+"");//B2C利润
							orderinfonew.setCclientpayprice(Integer.parseInt(B2cWebPrice)+Integer.parseInt(bxprice)+"");//c端支付价
							orderinfonew.setIspayhthy(IsWhy);
							
							/*//如果是儿童 创建51  8000yi
							for(int w=0;w<listpassenger.size();w++){
								if(listpassenger.get(w).getPtype()!=null&&listpassenger.get(w).getPtype()==2){
									orderinfonew.setPolicyagentid(6l);
									break;
								}
							}*/
							
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								}else if(orderinfonew.getPolicyagentid() == 6){
									if (strExtOrderNumber.indexOf("@") != -1) {
										String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
										orderinfonew.setExtorderid(strExtOrderArrpnr[0].trim());
										orderinfonew.setPnr(strExtOrderArrpnr[1].trim());
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
								
										jinriprice=strExtOrderArrpnr[3].trim();
										
										/*	if(!strExtOrderArrpnr[2].trim().equals(orderinfonew.getRatevalue())){//如果政策返点和下单返点不一致,更新价格
										System.out.println("今日生成订单的返点和下单的返点不一致,下单时候的返点=="+orderinfonew.getRatevalue()+",生成订单的返点=="+strExtOrderArrpnr[2].trim()+",订单总价=="+strExtOrderArrpnr[3].trim());
										orderinfonew.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										orderinfonew.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue())));
										
										//从新计算价格开始
										bestzrate.setAgentid(6l);
										bestzrate.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										
										//float newprice=0f;
										for (Passenger passeng : orderinfonew.getPassengerlist()) {
											passeng.setOrderid(orderinfonew.getId());
											
											
											// 获取最优政策，更新乘机人信息
											// Created By:sunbin
											// 2011-10-18
											if (bestzrate != null
													&& bestzrate.getRatevalue() != null
													&& bestzrate.getAgentid() != null) {
												if (passeng.getPtype() == 1) {
													passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
															.getRatevalue()))/100);
													
												} else if (passeng.getPtype() == 2) {
													passeng.setAirportfee(0f);
													
													//平台创建儿童订单
													if(orderflag!=2)
													{
														passeng.setFuelprice(getRoundPrice(seginfo
																.getFuelfee(), 2));
														if (seginfo.getDiscount() > 100) {
															passeng.setPrice(getRoundPrice(seginfo
																	.getParvalue(), 2));
														} else {
															passeng.setPrice(getRoundPrice(seginfo
																	.getYprice(), 2));
														}
													}
													
												} else {
													passeng.setAirportfee(0f);
													passeng.setFuelprice(0f);
													// 儿童婴儿价
													if(orderflag!=2)
													{
													if (seginfo.getDiscount() > 100) {
														passeng.setPrice(getRoundPrice(seginfo
																.getParvalue(), 10));
													} else {
														passeng.setPrice(getRoundPrice(seginfo
																.getYprice(), 10));
													}
													}
													
												}
												newprice += passeng.getPrice();
												// 获取最优政策，更新乘机人信息
												// 结束
											}
											
											
										}
										
										//计算结束
										
										}*/
										intIsCreated =0;
									}
								} else {
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								System.out.println("按照最优政策创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
								
								//生成外部订单失败,取消PNR
								 //Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfonew.getPnr()+"$XEPNR@", "", "");
								 //return "ERROR";
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("按照最优政策创建外部订单失败，异常信息"
									+ e.getMessage());
							//生成外部订单失败,取消PNR
							//Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfonew.getPnr()+"$XEPNR@", "", "");
							//return "ERROR";
						}
					}

					// 计算总利润，以及留点记录信息
					// 成人总数
					int intadult = 0;
					//儿童总数
					int intchlid=0;
					for (int i = 0; i < orderinfonew.getPassengerlist().size(); i++) {
						if (orderinfonew.getPassengerlist().get(i).getPtype() == 1) {
							intadult++;
						}
						else if (orderinfonew.getPassengerlist().get(i).getPtype() == 2) {
							intchlid++;
						}
						
					}
					Float fzonglirun=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fzonglirun = orderinfonew.getRatevalue()
						* seginfo.getParvalue() / 100 * intadult;
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
						   fzonglirun=0.025f* seginfo.getYprice()/2 * intchlid;
						}
						else
						{
							fzonglirun=listsegmenginfo.get(0).getParvalue()*0.025f*intchlid;
						}
					}
					
					int intzonglirun = fzonglirun.intValue();
					orderinfonew.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));

					// 生成本地订单信息
					orderinfonew.setPaystatus(0);
					
					orderinfonew.setOrderstatus(1);
					
					String str=""+listpassenger.get(0).getName()+"CHD";
					if(orderinfonew.getPnrtxt()!=null&&orderinfonew.getPnrtxt().indexOf(str)!=-1){
						orderinfonew.setRatevalue(0f);	
						orderinfonew.setFenxiaoshangfandian(0f);
					}
					
					if(orderinfonew.getPolicyid()!=null&&orderinfonew.getPolicyagentid()!=null){
						Zrate zrate=ZrateServer.getInstance().findZrate(orderinfonew.getPolicyagentid(), orderinfonew.getPolicyid()+"$*");
						if(zrate!=null&&zrate.getGeneral()!=null){
							orderinfonew.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
						}
					}
					
					
					WriteLog.write("订单信息","订单:"+orderinfonew.toString());
					orderinfonew = Server.getInstance().getAirService().createOrderinfo(orderinfonew);
					
					System.out.println("订单详细信息");
					System.out.println(orderinfonew.toString());
					System.out.println("订单详细信息============");
					System.out.println(orderinfonew.getOrdernumber());
					System.out.println("订单信息==" + orderinfonew);
					System.out.println("订单ID==" + orderinfonew.getId());
					System.out.println("外部订单ID==" + orderinfonew.getExtorderid());

					Segmentinfo segmetemp = listsegmenginfo.get(j);
					segmetemp.setOrderid(orderinfonew.getId());
					// 获取新政策，更新航程信息
					// 
					// 
					if (bestzrate != null && bestzrate.getRatevalue() != null
							&& bestzrate.getAgentid() != null&&orderinfonew.getPassengerlist().get(0).getPtype()==1) {
						Float fsegmentprice=0f;
						if(segmetemp.getParvalue()!=null)
						{
							fsegmentprice= segmetemp.getParvalue();
						}
						else
						{
							fsegmentprice=0f;
						}
						//计算优惠价格
				    	Float fdiscountprice=fsegmentprice*Getliudianvalue(bestzrate.getRatevalue())/100;
				    	int intdiscountprice=fdiscountprice.intValue();
				    	//计算实际结算价格
				    	fsegmentprice =fsegmentprice-intdiscountprice;

						int intsegmentprice = fsegmentprice.intValue();
						segmetemp.setAgentid(bestzrate.getAgentid());
						segmetemp.setRatevalue(bestzrate.getRatevalue());
						segmetemp.setZrateid(bestzrate.getId());
						segmetemp.setPrice(Float.parseFloat(String
								.valueOf(intsegmentprice)));
						segmetemp.setRules(bestzrate.getRemark());
					}
					// 获取新政策，更新航程信息
					// 结束
					segmetemp = Server.getInstance().getAirService()
							.createSegmentinfo(segmetemp);

					System.out.println(orderinfonew.getPassengerlist().size());
					int l = 0;
					float subpricenew = 0;
					float insurprice = 0f;// 保险价格
					Sysconfig sysconfig=Server.getInstance().getSystemService().findSysconfig(1);
					float bxcb=20;
					HttpSession session = ServletActionContext.getRequest().getSession();
					if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
						bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
					}
					for (Passenger passeng : orderinfonew.getPassengerlist()) {
						passeng.setOrderid(orderinfonew.getId());
						int bxcount = 0;
						try{
						bxcount=Integer.valueOf(bxcounts[l].trim());
						}catch(Exception e){
						}
						if (bxcount> 0) {							
							passeng.setInsurprice(bxcount*bxcb);
							if (listsegmenginfo.size()==2) {
								if (!new B2bAirSearchAction().isInInsrutime(
										listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
									if (j == 0) {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.ceil(Integer
													.valueOf(bxcount) / 2.0);
										}
									
										passeng.setInsurprice(bxcb*count);
									} else {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.floor(Integer
													.valueOf(bxcount) / 2.0);
		
											passeng.setInsurprice(bxcb*count);
										}
									}

								} else {//在一个保险期内
									if (j == 0) {
										
									//	passeng.setInsurance(insurance.getId());
										passeng.setInsurprice(bxcount*bxcb);
									}
								}
							} else {
								passeng.setInsurprice(bxcount*bxcb);

							}
							insurprice += passeng.getInsurprice();
						}
						// 获取最优政策，更新乘机人信息
						// Created By:sunbin
						// 2011-10-18
						if (bestzrate != null
								&& bestzrate.getRatevalue() != null
								&& bestzrate.getAgentid() != null) {
							if (passeng.getPtype() == 1) {
								passeng.setPrice(segmetemp.getPrice());
								passeng.setAirportfee(segmetemp
										.getAirportfee());
								passeng.setFuelprice(segmetemp.getFuelfee());
							} else if (passeng.getPtype() == 2) {
								passeng.setAirportfee(0f);
								
								//平台创建儿童订单
								if(orderflag!=2)
								{
									/*passeng.setFuelprice(getRoundPrice(segmetemp
											.getFuelfee(), 2));*/
									if (seginfo.getDiscount() > 100) {
										passeng.setPrice(getRoundPrice(segmetemp
												.getParvalue(), 2));
									} else {
										passeng.setPrice(getRoundPrice(segmetemp
												.getYprice(), 2));
									}
								}
								
							} else {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(0f);
								// 儿童婴儿价
								if(orderflag!=2)
								{
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmetemp
											.getParvalue(), 10));
								} else {
									passeng.setPrice(getRoundPrice(segmetemp
											.getYprice(), 10));
								}
								}
								
							}
							subpricenew += passeng.getPrice();
							// 获取最优政策，更新乘机人信息
							// 结束
						}
						Server.getInstance().getAirService().createPassenger(
								passeng);
						l++;
					}

					// 更新订单总价信息
					if (subpricenew != 0f) {
						// 总机票价格+平台费用
						orderinfonew.setTotalticketprice(subpricenew);// 存入数据库中的数据
					}
					
					//如果是今日,按照今日返回价格
					/*if (orderinfonew.getPolicyagentid()==6) {
						if(jinriprice!=null&&!jinriprice.equals("")){
						Float newprice=	Float.parseFloat(jinriprice)-orderinfonew.getTotalairportfee()-orderinfonew.getTotalfuelfee();
						orderinfonew.setTotalticketprice(newprice);// 存入数据库中的数据
						}
					}*/
					
					
					
					if (j == 0) {
						this.orderinfo1 = orderinfonew;
					} else {
						this.orderinfo2 = orderinfonew;
					}
					System.out.println("***************************返佣信息**************************************");
					System.out.println(orderinfonew.getId());
					
					System.out.println(orderinfonew.getRatevalue());
					Float fparvalue=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fparvalue=seginfo.getParvalue();
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
							fparvalue=getRoundPrice(seginfo.getYprice(), 2);
						}
						else
						{
							fparvalue=seginfo.getParvalue();
						}
					}
					String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfonew.getRatevalue(),
							Getliudianvalue(orderinfonew.getRatevalue()), fparvalue, insurprice);
					
					if(getLoginAgent().getBigtype()==2){
						
						Sysconfig sys = Server.getInstance().getSystemService()
						.findSysconfig(1);
				// 保存当前 保险成本 与购买数量
						String strsub = sys.getValue() + "|" + insurprice;
						strCustomgeragentBackPointInfo="1,0.00,"+fparvalue+","+orderinfonew.getRatevalue()+"@46,"+(orderinfonew.getRatevalue()-Float.parseFloat(getLoginAgent().getFixedvalue()))+","+fparvalue+","+orderinfonew.getRatevalue()+"@"+getLoginAgent().getId()+","+getLoginAgent().getFixedvalue()+","+fparvalue+","+orderinfonew.getRatevalue()+"@"+strsub;
					}
					
					System.out.println(strCustomgeragentBackPointInfo);
					orderinfonew.setFenxiaoshangfandian(Getliudianvalue(orderinfonew.getRatevalue()));
					orderinfonew.setBackpointinfo(strCustomgeragentBackPointInfo);
					//如果是PNR导入创建订单，则所有订单都需要平台确认价格后，才能够进行支付
					String strOrderPnr="";
					if(orderinfonew.getPnr()!=null)
					{
						strOrderPnr=orderinfonew.getPnr();
					}
					else if(orderinfonew.getBigpnr()!=null)
					{
						strOrderPnr=orderinfonew.getBigpnr();
					}
					if((orderflag==2 && getLoginUserAgent().getAgenttype()!=1) || strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456"))
					{
						//待确认订单状态
						//orderinfonew.setOrderstatus(27);
						if(strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456")){
							
							
						}else{
						orderinfonew.setOrderstatus(1);
						}
					}
					//记录是否是PNR导入创建的订单
					if(orderflag==2)
					{
						if(orderinfonew.getMemo()!=null && !orderinfonew.getMemo().equals(""))
						{
						   orderinfonew.setMemo(orderinfonew.getMemo()+"[PNR导入创建]");
						}
						else
						{
							orderinfonew.setMemo("[PNR导入创建]");
						}
					}
					
					//发送短信
					//sendCreateOrderTXTSmstoPassenger(listpassenger, listsegmenginfo,orderinfonew);
					
					
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfonew);
					//创建操作记录
					try{
						Orderinforc orderinforc = new Orderinforc();
						orderinforc.setCustomeruserid(getLoginUserId());
						orderinforc.setOrderinfoid(orderinfonew.getId());
						orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						orderinforc.setContent("创建订单--" + this.getLoginUser().getMembername()+ "创建了订单");
						orderinforc.setSuouserid(orderinfonew.getUserid());
						orderinforc.setState(orderinfonew.getOrderstatus());
						orderinforc.setCustomeruserid(getLoginUserId());
						Server.getInstance().getAirService().createOrderinforc(orderinforc);
					}
					catch(Exception ex){
						System.out.println("创建操作记录异常："+ex.getMessage());
					}
					//最终订单价格
					float totalnewprice=orderinfonew.getTotalairportfee()+orderinfonew.getTotalfuelfee()+orderinfonew.getTotalticketprice();
					strNewTotalPrice=String.valueOf(totalnewprice);
				}
				
				
				
				
				
				
				
				
				
				
				//创建结束
				
				
				
				
				
				
				if(orderinfo2.getId()>0){
					String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo1.getId() + " WHERE ID=" + orderinfo2.getId()+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo2.getId() + " WHERE ID=" + orderinfo1.getId();
				Server.getInstance().getSystemService().findMapResultBySql(sql,	null);

				}
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zrateone");
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zratetwo");
				
				 //是否保存常用乘机人信息
				if(!issavepassenger.equals(""))
				{
				String[] ArrIsSaveNew = issavepassenger.split(",");
				//String strTempPassenger = "";
//				for (int i = ArrIsSave.length - 1; i >= 0; i--) {
//					strTempPassenger += ArrIsSave[i] + ",";
//				}
				//String[] ArrIsSaveNew = strTempPassenger.split(",");

				for (int i = 0; i < listpassenger.size(); i++) {
					String where = " where 1=1 and "
							+ Customerpassenger.COL_customeruserid + " = "
							+ getLoginUser().getId() + " and "
							+ Customerpassenger.COL_username + " = '"
							+ listpassenger.get(i).getName().trim() + "'";

					List<Customerpassenger> list = Server.getInstance()
							.getMemberService().findAllCustomerpassenger(where,
									"", -1, 0);
					// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
					if (ArrIsSaveNew[i].equals("0")
							|| (list != null && list.size() > 0)) {
						continue;
					}
					try {
						// 当前登录员工
						Customeruser loginEmployee = getLoginUser();
						Customerpassenger customerpassenger = new Customerpassenger();
						customerpassenger.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customerpassenger.setCreateuser(getLoginUser()
								.getLoginname());
						customerpassenger.setUsername(listpassenger.get(i)
								.getName().trim());
						customerpassenger.setType(1);
						customerpassenger.setCustomeruserid(loginEmployee
								.getId());
						customerpassenger = Server.getInstance()
								.getMemberService().createCustomerpassenger(
										customerpassenger);
						// 添加证件
						Customercredit customercredit = new Customercredit();
						customercredit.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setCreateuser(loginEmployee
								.getMembername());
						if(listpassenger.get(i).getPtype()==1){
						customercredit.setCreditnumber(listpassenger.get(i)
								.getIdnumber().trim());
						customercredit.setCredittypeid(listpassenger.get(i)
								.getIdtype());
						}
						customercredit.setModifytime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setModifyuser(loginEmployee
								.getMembername());
						customercredit.setRefid(customerpassenger.getId());
						customercredit.setType(1);
						Server.getInstance().getMemberService()
								.createCustomercredit(customercredit);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				}
				System.out.println(orderinfo1.getId());
				System.out.println(orderinfo2.getId());
				strReturn = "b2bticketorder!payorder.action?orderinfo.id="
						+ orderinfo1.getId()+"&s_oldzratevalue="+strOldZrateValue+"&s_bestzratevalue="+strBestZrateValue+"&s_oldorderprice="+strOldTotalPrice+"&s_neworderprice="+strNewTotalPrice;
			
				if(getLoginAgent().getType()==2){
					strReturn = "b2bticketorder!payorder2.action?orderinfo.id="
						+ orderinfo1.getId();
				}
				
				 
			}

			//
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误:"+e.toString());
			strReturn = "ERROR";
		}
			
		return strReturn;
	}
	
	
	
	
	public String CreateOrder2(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
		
		String strReturn="NOPNR";
		String s_returnpnr="";
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 1;
		// 是否生成PNR
		int intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
	
		// 是否生成外部订单
		int intIsCreateOuterOrder =1; //0不生成外部订单   1生成外部订单
		// 是否按照原政策信息已经生成外部订单
		int intIsCreated = 0;//0按照本地政策   1按照最优政策
		
		int IsWhy=1; //0不分润接口   1分润接口
		
		String B2cWebPrice="";//B2C网站利润
		String WebPayPrice="";//C端支付价
		
		int chengrenNUM=0;//成人数量
		
		if(orderflag==2){//PNR导入的,不生成PNR
			intIsCreatePNR=0;
		}
		
		//ZrateServer.getInstance().findZrate(Long.parseLong(zr[z].split("@")[1].trim()), "*$"+zr[z].split("@")[0].trim());
		Zrate zrate2 = Server.getInstance().getAirService().findZrate(zratelist.get(0));
		if(zrate2.getAgentid()>10){//如果是本地政策供应商 不生成外部订单  使用本地政策
			
			intIsCreated=0;
			intIsCreateOuterOrder=0;
		}
		
		//如果是今日政策,不生成PNR,今日会生成PNR
		
		/*if(zrate2.getAgentid()==6){//如果是本地政策供应商 不生成外部订单  使用本地政策
			
			intIsCreated=0;
			intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
		}*/
	//----------------------------------------------------------------------------------------------------------------
		
		
		if(zrate2.getGeneral()!=null){
			orderinfo.setReceipt(Integer.parseInt(zrate2.getGeneral()+""));//政策类型  普通 特殊
		}else{
			
			orderinfo.setReceipt(1);
		}
		
		
		
		String jinriprice="";
	
	
		
		// 最优政策
		Zrate bestzrate = new Zrate();
		String[] bxcounts = insurances.trim().split(",");
		//本地订单旧政策
		String strOldZrateValue="0";
		//最优政策
		String strBestZrateValue="0";
		//黑屏PAT票价，燃油，机建
		String pat_Price="0";
		String pat_Fuleprice="0";
		String pat_airportfee="0";
		//用于PAT:A价格发生变化时，订单提醒
		String strOldTotalPrice="0";
		String strNewTotalPrice="0";
		
		try{
			//订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			
			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize=listsegmenginfo.size();
			/******************循环航程list,并创建订单开始*************************/
			for(int s=0;s<intsegmentsize;s++)
			{
				List<Passenger> listpassengermodel=new ArrayList<Passenger>();
				Orderinfo orderinfomodel = new Orderinfo();
				orderinfomodel.setCreatetime(orderinfo.getCreatetime());
				orderinfomodel.setCustomeruserid(orderinfo.getCustomeruserid());
				orderinfomodel.setSaleagentid(orderinfo.getSaleagentid());
				orderinfomodel.setBuyagentid(orderinfo.getBuyagentid());
				orderinfomodel.setContactmobile(orderinfo.getContactmobile());
				orderinfomodel.setPaystatus(orderinfo.getPaystatus());
				orderinfomodel.setOrderstatus(orderinfo.getOrderstatus());
				orderinfomodel.setPaymethod(orderinfo.getPaymethod());
				orderinfomodel.setCurrplatfee(orderinfo.getCurrplatfee());
				orderinfomodel.setLanguage(orderinfo.getLanguage());
				orderinfomodel.setOrdertype(orderinfo.getOrdertype());
				orderinfomodel.setPnr(orderinfo.getPnr());
				if(orderinfo.getPostmoney()!=null){
					orderinfomodel.setPostmoney(orderinfo.getPostmoney());
				}
				
				if(orderflag==2){
					orderinfomodel.setPnrtxt(orderinfo.getPnrtxt());
					orderinfomodel.setPattxt(orderinfo.getPattxt());
				}
				orderinfomodel.setBigpnr(orderinfo.getBigpnr());
				orderinfomodel.setContactname(orderinfo.getContactname());
				if(orderinfo.getMemo()!=null){
				orderinfomodel.setMemo(orderinfo.getMemo());
				}
				Segmentinfo segmentinfo=listsegmenginfo.get(s);
				/*****订单信息赋值开始************************************************************/
				/****本地政策赋值开始*****************************************/
				Zrate zrate = Server.getInstance().getAirService().findZrate(zratelist.get(s));
				
				//判断开始.判断是否是固定饭店用户
				/*if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
					zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
				}*/
				if(zrate.getWorkstatus()!=null){
				orderinfomodel.setPickonename(zrate.getWorkstatus());//office
				}
				if(zrate.getSpeed()!=null){
					if(zrate.getAgentid()==5){
					orderinfomodel.setPickonephone(zrate.getSpeed());//出票速度
					}
					if(zrate.getAgentid()==6){
						orderinfomodel.setPickonephone(zrate.getSpeed()+"分钟");//出票速度
					}
				}
				orderinfomodel.setPolicyid(zrate.getId());//政策ID
				
				if(customeragent.getBigtype()==2){//固定返点
					orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(customeragent.getFixedvalue())));// 分销商返点
				}else{
					orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue2(zrate.getRatevalue(),customeragent)));// 分销商返点
				}
				
				//记录当前政策值
				strOldZrateValue=String.valueOf(orderinfomodel.getFenxiaoshangfandian());
				orderinfomodel.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfomodel.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfomodel.setExtpolicyid(zrate.getOutid()); // 外部政策id
				orderinfomodel.setPostmobile(zrate.getWorktime()+"-"+zrate.getAfterworktime());
				segmentinfo.setAgentid(zrate.getAgentid());
				segmentinfo.setRatevalue(zrate.getRatevalue());
				
				segmentinfo.setZrateid(zrate.getId());
				segmentinfo.setLanguage(0);
				segmentinfo.setZrate(zrate);
				/****本地政策赋值结束*****************************************/ 
				
				/****订单信息赋值结束************************************************************/
				float subfuelfee = 0;
				float subairportfee = 0;
				float subprice = 0;
				/****乘机人信息赋值开始************************************************************/
				for (int i = 0; i < listpassenger.size(); i++) {
					if (listpassenger.get(i).getName().trim().length() > 0) {
						
						 if (listpassenger.get(i).getPtype() == 1) {
								chengrenNUM++;
							}
						 
						
						   Passenger passenger =new Passenger();
					       passenger.setName(listpassenger.get(i).getName());
					       passenger.setPtype(listpassenger.get(i).getPtype());
					       passenger.setIdnumber(listpassenger.get(i).getIdnumber());
					       passenger.setIdtype(listpassenger.get(i).getIdtype());
					       passenger.setState(listpassenger.get(i).getState());
					       passenger.setLanguage(listpassenger.get(i).getLanguage());
					       passenger.setAirportfee(listpassenger.get(i).getAirportfee());
					       passenger.setFuelprice(listpassenger.get(i).getFuelprice());
					       passenger.setPrice(listpassenger.get(i).getPrice());
					       passenger.setBirthday(listpassenger.get(i).getBirthday());
					     
					       
						if (passenger.getPtype() == 1  && orderflag!=2) {
							passenger.setPrice(segmentinfo.getPrice());
							passenger.setAirportfee(segmentinfo.getAirportfee());
							passenger.setFuelprice(segmentinfo.getFuelfee());
						} else if (passenger.getPtype() == 2 && orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(getRoundPrice(segmentinfo.getFuelfee(), 2));
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
							}
						} else if(orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(0f);
							// 儿童婴儿价
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 10));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 10));
							}
						}
						subprice += passenger.getPrice();
						subfuelfee += passenger.getFuelprice();
						subairportfee += passenger.getAirportfee();
						passenger.setDiscount(segmentinfo.getDiscount());
						listpassengermodel.add(passenger);
					}
				}
				/****乘机人信息赋值结束************************************************************/
				if(orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().equals(""))
				{
					System.out.println("小PNR导入，创建订单 PNR:"+orderinfomodel.getPnr());
					s_returnpnr=orderinfo.getPnr();
				}
				else if(orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().equals(""))
				{
					System.out.println("大PNR导入，创建订单  PNR:"+orderinfomodel.getBigpnr());
					s_returnpnr=orderinfomodel.getBigpnr();
				}
				else if(intIsCreatePNR==1)
				{
					if (intCreatePNRType == 1) {
					s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					} else {
					//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
						s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassengermodel, orderinfo);
					}
					System.out.println("**********************生成的PNR编码："+ s_returnpnr);
					if(s_returnpnr.equals("-1")){
					//如果没有生成PNR...不创建外部订单,创建内部订单
						intIsCreateOuterOrder=0;
						intIsCreatePNR=0;
						s_returnpnr="123456";
						 return "NOPNR";
					}else{
						
						if(intCreatePNRType==2){//51创建PNR
							String newpnr="";
							String pnrtxt="";
							String pattxt="";
							
							newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];
							orderinfomodel.setPattxt(pattxt);
							orderinfomodel.setPnrtxt(pnrtxt);
							orderinfomodel.setPnr(newpnr);
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								 return "NOPNR";
							}
						}else{//黑屏创建
							
							String pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr, "", "");
							
							
							
							
							int ind=0;
							
							if(pnrtxt.indexOf("+")>0){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN", "", "");
							}
							if(pnrtxt.indexOf("+")>ind){
								ind=pnrtxt.indexOf("+");
								pnrtxt=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PN$PN$PN", "", "");
							}
							
							
							String strPat="PAT:A";
							String str=""+listpassenger.get(0).getName()+"CHD";
							if(pnrtxt.indexOf(str)!=-1){
								strPat="PAT:A*CH";
								
							}
							
							String pattxt=Server.getInstance().getTicketSearchService().commandFunction2(strPat, "", "");
							
							/*newpnr=s_returnpnr.split("@")[0];
							pattxt=s_returnpnr.split("@")[1];
							pnrtxt=s_returnpnr.split("@")[2];*/
							orderinfomodel.setPattxt(pattxt);
							orderinfomodel.setPnrtxt(pnrtxt);
							orderinfomodel.setPnr(s_returnpnr);
							
							
							String	strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
						
							if(strBigPNR.length()>6){
								strBigPNR=strBigPNR.substring(0, 6);
							}
							orderinfomodel.setBigpnr(strBigPNR);
							
							if(pattxt.indexOf("没有符合条件的运价")!=-1){
								System.out.println("没有符合条件的运价,订单创建失败");
								
								//生成外部订单失败,取消PNR
								Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
								
								 return "NOPRICE";
							}
							
						}
					}
				}
				else
				{
					s_returnpnr="123456";
				}
				
				// 判断是否生成PNR
				if (s_returnpnr.equals("NOPNR")) {
					strReturn = "NOPNR";
					
					break;
				}
				// 机建费
				orderinfomodel.setTotalairportfee(subairportfee);
				// 燃油费
				orderinfomodel.setTotalfuelfee(subfuelfee);
				// 总机票价格+平台费用
				orderinfomodel.setTotalticketprice(subprice);// 存入数据库中的数据
				//
				float totalallprice=orderinfomodel.getTotalairportfee()+orderinfomodel.getTotalfuelfee()+orderinfomodel.getTotalticketprice();
				strOldTotalPrice=String.valueOf(totalallprice);
				if((orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().trim().equals("")) || (orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().trim().equals("")))
				{
					System.out.println("PNR导入订单信息");
				}
				else
				{
					
					String strBigPNR = "无";
					//只有51book才获取大PNR
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
					/*if (orderinfomodel.getPolicyagentid() == 5) {
						strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
					}
					orderinfomodel.setBigpnr(strBigPNR);*/
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
				}
				
				//orderinfomodel.setPostmoney(0);
				orderinfomodel.setPassengerlist(listpassengermodel);
				listOrderinfo.add(orderinfomodel);
			}
			/******************循环航程list,并创建订单结束*************************/
			
			//如果生成PNR则创建订单，否则提示创建订单失败
			if (!s_returnpnr.equals("NOPNR")) {
				for (int j = 0; j < listOrderinfo.size(); j++) {
				  Orderinfo	orderinfonew = listOrderinfo.get(j);

					Segmentinfo seginfo = listsegmenginfo.get(j);
					//*****************************************************//
					//Pat:a取得黑屏中票价--------------------------------------PAT-------------------------------------------------------
					String strPatInfo="";
		
			if(intIsCreatePNR==1 && orderflag==4){
					//if(intIsCreatePNR==1 && orderflag!=2)
					
					try
					{
					  strPatInfo=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PAT:A", "", "");
						
						Pattern pat = Pattern.compile("[P][A][T][:][A]");
					  String[] strPatarr = pat.split(strPatInfo);
					  if(strPatarr.length>=2)
					  {
						  Pattern patitem=Pattern.compile("\\s{1,}");
						  String[] strpatItem=patitem.split(strPatarr[1]);
						  for(int i=0;i<strpatItem.length;i++) 
						  {
							  if(!strpatItem[i].trim().equals(""))
							  {
								  //票价
								  if(strpatItem[i].trim().indexOf("FARE:")>=0 && pat_Price.equals("0"))
								  {
									  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
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
					  //核对黑屏中价格信息与航程中价格信息是否一样
					  Float f_segmentprice=0f;
					  Float f_segmentfuelprice=0f;
					  Float f_segmentairportfee=0f;
				      f_segmentprice=Float.parseFloat(pat_Price);
				      f_segmentfuelprice=Float.parseFloat(pat_Fuleprice);
				      f_segmentairportfee=Float.parseFloat(pat_airportfee);
				      
				      if(orderinfonew.getPassengerlist().get(0).getPtype()==1)
				      {   //票价不一致
					      if(f_segmentprice.floatValue()!=listsegmenginfo.get(0).getParvalue() || f_segmentfuelprice.floatValue()!=listsegmenginfo.get(0).getFuelfee() || f_segmentairportfee.floatValue()!=listsegmenginfo.get(0).getAirportfee())
					      {
					    	  float sub_price=0;
					    	  float sub_fuelfee=0;
					    	  float sub_airportfee=0;
					    	  //修改航程信息中的价格信息
					    	  seginfo.setParvalue(f_segmentprice);//未匹配政策票面价
					    	  //计算优惠价格
					    	  Float fdiscountprice=f_segmentprice*orderinfonew.getFenxiaoshangfandian()/100;
					    	  int intdiscountprice=fdiscountprice.intValue();
					    	  //计算实际结算价格
					    	  f_segmentprice =f_segmentprice-intdiscountprice;
					    	  seginfo.setPrice(f_segmentprice); //匹配政策票面价
					    	  //修改乘机人中的价格信息
					    	  for (Passenger passenger:orderinfonew.getPassengerlist()) 
					    	  {
					    		  
					    		 
					    		  
					    		  passenger.setAirportfee(f_segmentairportfee);
					    		  passenger.setFuelprice(f_segmentfuelprice);
					    		  passenger.setPrice(f_segmentprice);
					    		  sub_price += passenger.getPrice();
								  sub_fuelfee += passenger.getFuelprice();
							      sub_airportfee += passenger.getAirportfee();
					    	  }
					    	  //修改订单中的价格信息
					    	  // 机建费
					    	  orderinfonew.setTotalairportfee(sub_airportfee);
						      // 燃油费
					    	  orderinfonew.setTotalfuelfee(sub_fuelfee);
							  // 总机票价格+平台费用
					    	  orderinfonew.setTotalticketprice(sub_price);
					    	  
					      }
				      }
					  
					}
					catch(Exception ex){
						
					}
					System.out.println("**********************PAT:A："+ strPatInfo);
					System.out.println("**********************黑屏中：票价"+ pat_Price+"|||燃油："+pat_Fuleprice+"||||机建"+pat_airportfee);
					}
					
					//************************pat-----------------------------------------------PAT-------------------****************************//
					
					
					
					
					// 如果是其他供应商政策，则不生成外部订单-----------------------判断是否创建外部------------------------------------------
					if ((orderinfonew.getPolicyagentid() == 3 ||orderinfonew.getPolicyagentid() == 6
							|| orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2 || orderinfonew.getPolicyagentid() == 46)
							&& intIsCreateOuterOrder == 1) {
						intIsCreateOuterOrder = 1;
						System.out.println("属于平台政策：是否创建外部订单："+ intIsCreateOuterOrder);
					} else {
						intIsCreateOuterOrder = 0;
						// 不属于平台政策，则可以直接支付订单
						if(orderinfonew.getPaymethod()==2 || orderinfonew.getPaymethod()==3)
						{
							orderinfonew.setOrderstatus(2);
						}
						else
						{
						   orderinfonew.setOrderstatus(1);
						}
						System.out.println("不属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
						
						
					}
					
					
					
					
					
					//是否创建外部订单开始----------------------------------------------------------------------------------------------
					if (intIsCreateOuterOrder == 1) {
						try {
							//如果是普通政策，则直接按照最优政策生成订单
							if(intIsCreated==0)
							{
								
								bestzrate=seginfo.getZrate();
								//计算利润
								System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
								WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
								
								if(WebPayPrice.equals("0.0")){
									WebPayPrice="0";
								}else{
									
									WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
									
								}
								
								//从新计算价格开始
								
								float newprice=0f;
								for (Passenger passeng : orderinfonew.getPassengerlist()) {
									passeng.setOrderid(orderinfonew.getId());
									
									
									// 获取最优政策，更新乘机人信息
									// Created By:sunbin
									// 2011-10-18
									if (bestzrate != null
											&& bestzrate.getRatevalue() != null
											&& bestzrate.getAgentid() != null) {
										if (passeng.getPtype() == 1) {
											passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue2(bestzrate
													.getRatevalue(),customeragent))/100);
											
										} else if (passeng.getPtype() == 2) {
											passeng.setAirportfee(0f);
											
											//平台创建儿童订单
											if(orderflag!=2)
											{
												passeng.setFuelprice(getRoundPrice(seginfo
														.getFuelfee(), 2));
												if (seginfo.getDiscount() > 100) {
													passeng.setPrice(getRoundPrice(seginfo
															.getParvalue(), 2));
												} else {
													passeng.setPrice(getRoundPrice(seginfo
															.getYprice(), 2));
												}
											}
											
										} else {
											passeng.setAirportfee(0f);
											passeng.setFuelprice(0f);
											// 儿童婴儿价
											if(orderflag!=2)
											{
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 10));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 10));
											}
											}
											
										}
										newprice += passeng.getPrice();
										// 获取最优政策，更新乘机人信息
										// 结束
									}
									
									
								}
								
								//计算结束
								
								B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
								
								
								B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
								
								System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice);
								
								orderinfonew.setB2cprofit(WebPayPrice);//B2C利润
								orderinfonew.setCclientpayprice(B2cWebPrice);//c端支付价
								orderinfonew.setIspayhthy(IsWhy);
								
								
								
								
								
								
								
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							
							
							WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								intIsCreated = 0;
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else if(orderinfonew.getPolicyagentid() == 6){
									if (strExtOrderNumber.indexOf("@") != -1) {
										String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
										orderinfonew.setExtorderid(strExtOrderArrpnr[0].trim());
										orderinfonew.setPnr(strExtOrderArrpnr[1].trim());
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
								
										jinriprice=strExtOrderArrpnr[3].trim();
										
										/*	if(!strExtOrderArrpnr[2].trim().equals(orderinfonew.getRatevalue())){//如果政策返点和下单返点不一致,更新价格
										System.out.println("今日生成订单的返点和下单的返点不一致,下单时候的返点=="+orderinfonew.getRatevalue()+",生成订单的返点=="+strExtOrderArrpnr[2].trim()+",订单总价=="+strExtOrderArrpnr[3].trim());
										orderinfonew.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										orderinfonew.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue())));
										
										//从新计算价格开始
										bestzrate.setAgentid(6l);
										bestzrate.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										
										//float newprice=0f;
										for (Passenger passeng : orderinfonew.getPassengerlist()) {
											passeng.setOrderid(orderinfonew.getId());
											
											
											// 获取最优政策，更新乘机人信息
											// Created By:sunbin
											// 2011-10-18
											if (bestzrate != null
													&& bestzrate.getRatevalue() != null
													&& bestzrate.getAgentid() != null) {
												if (passeng.getPtype() == 1) {
													passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
															.getRatevalue()))/100);
													
												} else if (passeng.getPtype() == 2) {
													passeng.setAirportfee(0f);
													
													//平台创建儿童订单
													if(orderflag!=2)
													{
														passeng.setFuelprice(getRoundPrice(seginfo
																.getFuelfee(), 2));
														if (seginfo.getDiscount() > 100) {
															passeng.setPrice(getRoundPrice(seginfo
																	.getParvalue(), 2));
														} else {
															passeng.setPrice(getRoundPrice(seginfo
																	.getYprice(), 2));
														}
													}
													
												} else {
													passeng.setAirportfee(0f);
													passeng.setFuelprice(0f);
													// 儿童婴儿价
													if(orderflag!=2)
													{
													if (seginfo.getDiscount() > 100) {
														passeng.setPrice(getRoundPrice(seginfo
																.getParvalue(), 10));
													} else {
														passeng.setPrice(getRoundPrice(seginfo
																.getYprice(), 10));
													}
													}
													
												}
												newprice += passeng.getPrice();
												// 获取最优政策，更新乘机人信息
												// 结束
											}
											
											
										}
										
										//计算结束
										
										}*/
										intIsCreated =0;
									}
								}else{
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
								System.out.println("按照本地政策，创建外部订单成功，返回结果订单号:"+ strExtOrderNumber);
							
								intIsCreated = 0;
								System.out.println("按照本地政策，创建外部订单成功，返回结果订单号:"+ strExtOrderNumber+",初始化intIsCreated:0,按照本地政策");
								
							} else {
								intIsCreated = 1;
								System.out.println("按照本地政策，创建外部订单失败，返回结果:"+ strExtOrderNumber);
							}
							
							
							}
							else//匹配最优政策
							{
							
								intIsCreated = 1;
							}
						} catch (Exception ex) {
							intIsCreated = 1;
							System.out.println("按照本地政策，创建外部订单失败，异常结果:"
									+ ex.getMessage());
						}
						/*System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						System.out.println("是否生成外部订单标记：" + intIsCreateOuterOrder
								+ " 是否已按照原始政策生成外部订单：" + intIsCreated);*/
					}
					
					//创建外部订单结束---------------------------------------------------------------------------------------------------------
					
					
					// 如果没有按照原始政策，生成外部订单，则按照最优政策信息，再次生成外部订单
					
					//if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
					if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
						// 匹配最优政策，并生成外部订单
						
						System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						try {
							try {
								if(orderinfonew.getPassengerlist().get(0).getPtype()==1)
								{
								bestzrate = Server.getInstance()
										.getRateService().FindZrateByFlight(
												orderinfonew, seginfo,
												orderinfonew.getPassengerlist());
								}
								else
								{
									bestzrate =Server.getInstance().getAirService().findZrate(1l);
								}
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									try {
										// 计算价格
										orderinfonew
												.setPolicyid(bestzrate.getId());// 政策ID
										
										if(customeragent.getBigtype()==2){//如果是固定返点
											orderinfonew
											.setFenxiaoshangfandian(dceimalFormat(Float.parseFloat(customeragent.getFixedvalue())));// 分销商返点
											
										}else{
											orderinfonew
											.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue2(bestzrate
													.getRatevalue(),customeragent)));// 分销商返点
											
										}
										
										//记录最优政策返销商返点
										strBestZrateValue=String.valueOf(orderinfonew.getFenxiaoshangfandian());
										orderinfonew.setPolicyagentid(bestzrate
												.getAgentid());// 政策提供商id
										
										
											if(bestzrate.getWorkstatus()!=null){
											orderinfonew.setPickonename(bestzrate.getWorkstatus());//office
											}
											
											if(bestzrate.getSpeed()!=null){
												if(bestzrate.getAgentid()==5){
												orderinfonew.setPickonephone(bestzrate.getSpeed());//出票速度
												}
												if(bestzrate.getAgentid()==6){
													orderinfonew.setPickonephone(bestzrate.getSpeed()+"分钟");//出票速度
												}
												}
											
											
										orderinfonew
												.setRatevalue(dceimalFormat(bestzrate
														.getRatevalue()));// 折扣
										orderinfonew.setExtpolicyid(bestzrate
												.getOutid()); // 外部政策id
										System.out.println("调用最优政策方法,成功,政策为=="
												+ bestzrate);
									} catch (RuntimeException e) {
										System.out
												.println("调用最优政策方法,出现异常,异常信息："
														+ e.getMessage());
										e.printStackTrace();
									}
								}else{
									
									
									bestzrate=Server.getInstance().getAirService().findZrate(zratelist.get(j));
								}

							} catch (RuntimeException e) {
								System.out.println("调用最优政策方法,出现异常,异常信息："
										+ e.getMessage());
								e.printStackTrace();
							}
							seginfo.setZrate(bestzrate);
							// 创建外部订单，方法调用
							
							System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
							WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
							
							if(WebPayPrice.equals("0.0")){
								WebPayPrice="0";
							}else{
								WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
								
							}
							
							//从新计算价格开始
							
							float newprice=0f;
							for (Passenger passeng : orderinfonew.getPassengerlist()) {
								passeng.setOrderid(orderinfonew.getId());
								
								
								// 获取最优政策，更新乘机人信息
								// Created By:sunbin
								// 2011-10-18
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									if (passeng.getPtype() == 1) {
										passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue2(bestzrate
												.getRatevalue(),customeragent))/100);
										
									} else if (passeng.getPtype() == 2) {
										passeng.setAirportfee(0f);
										
										//平台创建儿童订单
										if(orderflag!=2)
										{
											passeng.setFuelprice(getRoundPrice(seginfo
													.getFuelfee(), 2));
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 2));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 2));
											}
										}
										
									} else {
										passeng.setAirportfee(0f);
										passeng.setFuelprice(0f);
										// 儿童婴儿价
										if(orderflag!=2)
										{
										if (seginfo.getDiscount() > 100) {
											passeng.setPrice(getRoundPrice(seginfo
													.getParvalue(), 10));
										} else {
											passeng.setPrice(getRoundPrice(seginfo
													.getYprice(), 10));
										}
										}
										
									}
									newprice += passeng.getPrice();
									// 获取最优政策，更新乘机人信息
									// 结束
								}
								
								
							}
							
							//计算结束
							
							B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
							
							
							B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
							
							System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice);
							
							orderinfonew.setB2cprofit(WebPayPrice);//B2C利润
							orderinfonew.setCclientpayprice(B2cWebPrice);//c端支付价
							orderinfonew.setIspayhthy(IsWhy);
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								}else if(orderinfonew.getPolicyagentid() == 6){
									if (strExtOrderNumber.indexOf("@") != -1) {
										String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid());
										orderinfonew.setExtorderid(strExtOrderArrpnr[0].trim());
										orderinfonew.setPnr(strExtOrderArrpnr[1].trim());
										WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfonew.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
								
										jinriprice=strExtOrderArrpnr[3].trim();
										
										/*	if(!strExtOrderArrpnr[2].trim().equals(orderinfonew.getRatevalue())){//如果政策返点和下单返点不一致,更新价格
										System.out.println("今日生成订单的返点和下单的返点不一致,下单时候的返点=="+orderinfonew.getRatevalue()+",生成订单的返点=="+strExtOrderArrpnr[2].trim()+",订单总价=="+strExtOrderArrpnr[3].trim());
										orderinfonew.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										orderinfonew.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue())));
										
										//从新计算价格开始
										bestzrate.setAgentid(6l);
										bestzrate.setRatevalue(Float.parseFloat(strExtOrderArrpnr[2].trim()));
										
										//float newprice=0f;
										for (Passenger passeng : orderinfonew.getPassengerlist()) {
											passeng.setOrderid(orderinfonew.getId());
											
											
											// 获取最优政策，更新乘机人信息
											// Created By:sunbin
											// 2011-10-18
											if (bestzrate != null
													&& bestzrate.getRatevalue() != null
													&& bestzrate.getAgentid() != null) {
												if (passeng.getPtype() == 1) {
													passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
															.getRatevalue()))/100);
													
												} else if (passeng.getPtype() == 2) {
													passeng.setAirportfee(0f);
													
													//平台创建儿童订单
													if(orderflag!=2)
													{
														passeng.setFuelprice(getRoundPrice(seginfo
																.getFuelfee(), 2));
														if (seginfo.getDiscount() > 100) {
															passeng.setPrice(getRoundPrice(seginfo
																	.getParvalue(), 2));
														} else {
															passeng.setPrice(getRoundPrice(seginfo
																	.getYprice(), 2));
														}
													}
													
												} else {
													passeng.setAirportfee(0f);
													passeng.setFuelprice(0f);
													// 儿童婴儿价
													if(orderflag!=2)
													{
													if (seginfo.getDiscount() > 100) {
														passeng.setPrice(getRoundPrice(seginfo
																.getParvalue(), 10));
													} else {
														passeng.setPrice(getRoundPrice(seginfo
																.getYprice(), 10));
													}
													}
													
												}
												newprice += passeng.getPrice();
												// 获取最优政策，更新乘机人信息
												// 结束
											}
											
											
										}
										
										//计算结束
										
										}*/
										intIsCreated =0;
									}
								} else {
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								System.out.println("按照最优政策创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
								
								//生成外部订单失败,取消PNR
								//Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfonew.getPnr()+"$XEPNR@", "", "");
								
								 return "ERROR";
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("按照最优政策创建外部订单失败，异常信息"
									+ e.getMessage());
							//生成外部订单失败,取消PNR
							//Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfonew.getPnr()+"$XEPNR@", "", "");
						}
					}

					// 计算总利润，以及留点记录信息
					// 成人总数
					int intadult = 0;
					//儿童总数
					int intchlid=0;
					for (int i = 0; i < orderinfonew.getPassengerlist().size(); i++) {
						if (orderinfonew.getPassengerlist().get(i).getPtype() == 1) {
							intadult++;
						}
						else if (orderinfonew.getPassengerlist().get(i).getPtype() == 2) {
							intchlid++;
						}
						
					}
					Float fzonglirun=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fzonglirun = orderinfonew.getRatevalue()
						* seginfo.getParvalue() / 100 * intadult;
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
						   fzonglirun=0.025f* seginfo.getYprice()/2 * intchlid;
						}
						else
						{
							fzonglirun=listsegmenginfo.get(0).getParvalue()*0.025f*intchlid;
						}
					}
					
					int intzonglirun = fzonglirun.intValue();
					orderinfonew.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));

					// 生成本地订单信息
					orderinfonew.setPaystatus(0);
					
					orderinfonew.setOrderstatus(1);
					
					String str=""+listpassenger.get(0).getName()+"CHD";
					if(orderinfonew.getPnrtxt()!=null&&orderinfonew.getPnrtxt().indexOf(str)!=-1){
						orderinfonew.setRatevalue(0f);	
						orderinfonew.setFenxiaoshangfandian(0f);
					}
					
					orderinfonew.setExtorderstatus(0);
					WriteLog.write("订单信息","订单:"+orderinfonew.toString());
					orderinfonew = Server.getInstance().getAirService().createOrderinfo(orderinfonew);
					
					System.out.println("订单详细信息");
					System.out.println(orderinfonew.toString());
					System.out.println("订单详细信息============");
					System.out.println(orderinfonew.getOrdernumber());
					System.out.println("订单信息==" + orderinfonew);
					System.out.println("订单ID==" + orderinfonew.getId());
					System.out.println("外部订单ID==" + orderinfonew.getExtorderid());

					Segmentinfo segmetemp = listsegmenginfo.get(j);
					segmetemp.setOrderid(orderinfonew.getId());
					// 获取新政策，更新航程信息
					// 
					// 
					if (bestzrate != null && bestzrate.getRatevalue() != null
							&& bestzrate.getAgentid() != null) {
						Float fsegmentprice=0f;
						if(segmetemp.getParvalue()!=null)
						{
							fsegmentprice= segmetemp.getParvalue();
						}
						else
						{
							fsegmentprice=0f;
						}
						//计算优惠价格
				    	Float fdiscountprice=fsegmentprice*Getliudianvalue2(bestzrate.getRatevalue(),customeragent)/100;
				    	int intdiscountprice=fdiscountprice.intValue();
				    	//计算实际结算价格
				    	fsegmentprice =fsegmentprice-intdiscountprice;

						int intsegmentprice = fsegmentprice.intValue();
						segmetemp.setAgentid(bestzrate.getAgentid());
						segmetemp.setRatevalue(bestzrate.getRatevalue());
						segmetemp.setZrateid(bestzrate.getId());
						segmetemp.setPrice(Float.parseFloat(String
								.valueOf(intsegmentprice)));
						segmetemp.setRules(bestzrate.getRemark());
					}
					// 获取新政策，更新航程信息
					// 结束
					segmetemp = Server.getInstance().getAirService()
							.createSegmentinfo(segmetemp);

					System.out.println(orderinfonew.getPassengerlist().size());
					int l = 0;
					float subpricenew = 0;
					float insurprice = 0f;// 保险价格
					Sysconfig sysconfig=Server.getInstance().getSystemService().findSysconfig(1);
					float bxcb=20;
					HttpSession session = ServletActionContext.getRequest().getSession();
					if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
						bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
					}
					
					for (Passenger passeng : orderinfonew.getPassengerlist()) {
						passeng.setOrderid(orderinfonew.getId());
						int bxcount = 0;
						try{
						bxcount=Integer.valueOf(bxcounts[l].trim());
						}catch(Exception e){
						}
						if (bxcount> 0) {							
							passeng.setInsurprice(bxcount*bxcb);
							if (listsegmenginfo.size()==2) {
								if (!new B2bAirSearchAction().isInInsrutime(
										listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
									if (j == 0) {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.ceil(Integer
													.valueOf(bxcount) / 2.0);
										}
									
										passeng.setInsurprice(bxcb*count);
									} else {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.floor(Integer
													.valueOf(bxcount) / 2.0);
		
											passeng.setInsurprice(bxcb*count);
										}
									}

								} else {//在一个保险期内
									if (j == 0) {
										
									//	passeng.setInsurance(insurance.getId());
										passeng.setInsurprice(bxcount*bxcb);
									}
								}
							} else {
								passeng.setInsurprice(bxcount*bxcb);

							}
							insurprice += passeng.getInsurprice();
						}
						// 获取最优政策，更新乘机人信息
						// Created By:
						// 2011-10-18
						if (bestzrate != null
								&& bestzrate.getRatevalue() != null
								&& bestzrate.getAgentid() != null) {
							if (passeng.getPtype() == 1) {
								passeng.setPrice(segmetemp.getPrice());
								passeng.setAirportfee(segmetemp
										.getAirportfee());
								passeng.setFuelprice(segmetemp.getFuelfee());
							} else if (passeng.getPtype() == 2) {
								passeng.setAirportfee(0f);
								
								//平台创建儿童订单
								if(orderflag!=2)
								{
									passeng.setFuelprice(getRoundPrice(segmetemp
											.getFuelfee(), 2));
									if (seginfo.getDiscount() > 100) {
										passeng.setPrice(getRoundPrice(segmetemp
												.getParvalue(), 2));
									} else {
										passeng.setPrice(getRoundPrice(segmetemp
												.getYprice(), 2));
									}
								}
								
							} else {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(0f);
								// 儿童婴儿价
								if(orderflag!=2)
								{
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmetemp
											.getParvalue(), 10));
								} else {
									passeng.setPrice(getRoundPrice(segmetemp
											.getYprice(), 10));
								}
								}
								
							}
							subpricenew += passeng.getPrice();
							// 获取最优政策，更新乘机人信息
							// 结束
						}
						Server.getInstance().getAirService().createPassenger(
								passeng);
						l++;
					}

					// 更新订单总价信息
					if (subpricenew != 0f) {
						// 总机票价格+平台费用
						orderinfonew.setTotalticketprice(subpricenew);// 存入数据库中的数据
					}
					
					//如果是今日,按照今日返回价格
					if (orderinfonew.getPolicyagentid()==6) {
						
						//jinriprice=strExtOrderArrpnr[3].trim();
					//Float newprice=	Float.parseFloat(jinriprice)-orderinfonew.getTotalairportfee()-orderinfonew.getTotalfuelfee();
					//	orderinfonew.setTotalticketprice(newprice);// 存入数据库中的数据
					}
					
					
					
					if (j == 0) {
						this.orderinfo1 = orderinfonew;
					} else {
						this.orderinfo2 = orderinfonew;
					}
					System.out.println("***************************返佣信息**************************************");
					System.out.println(orderinfonew.getId());
					
					System.out.println(orderinfonew.getRatevalue());
					Float fparvalue=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fparvalue=seginfo.getParvalue();
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
							fparvalue=getRoundPrice(seginfo.getYprice(), 2);
						}
						else
						{
							fparvalue=seginfo.getParvalue();
						}
					}
					String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							customeragent, orderinfonew.getRatevalue(),
							Getliudianvalue2(orderinfonew.getRatevalue(),customeragent), fparvalue, insurprice);
					
					if(customeragent.getBigtype()==2){
						
						Sysconfig sys = Server.getInstance().getSystemService()
						.findSysconfig(1);
				// 保存当前 保险成本 与购买数量
						String strsub = sys.getValue() + "|" + insurprice;
						strCustomgeragentBackPointInfo="1,0.00,"+fparvalue+","+orderinfonew.getRatevalue()+"@46,"+(orderinfonew.getRatevalue()-Float.parseFloat(customeragent.getFixedvalue()))+","+fparvalue+","+orderinfonew.getRatevalue()+"@"+customeragent.getId()+","+customeragent.getFixedvalue()+","+fparvalue+","+orderinfonew.getRatevalue()+"@"+strsub;
					}
					
					System.out.println(strCustomgeragentBackPointInfo);
					orderinfonew.setFenxiaoshangfandian(Getliudianvalue2(orderinfonew.getRatevalue(),customeragent));
					orderinfonew.setBackpointinfo(strCustomgeragentBackPointInfo);
					//如果是PNR导入创建订单，则所有订单都需要平台确认价格后，才能够进行支付
					String strOrderPnr="";
					if(orderinfonew.getPnr()!=null)
					{
						strOrderPnr=orderinfonew.getPnr();
					}
					else if(orderinfonew.getBigpnr()!=null)
					{
						strOrderPnr=orderinfonew.getBigpnr();
					}
					if((orderflag==2 && getLoginUserAgent().getAgenttype()!=1) || strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456"))
					{
						//待确认订单状态
						//orderinfonew.setOrderstatus(27);
						if(strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456")){
							
							
						}else{
						orderinfonew.setOrderstatus(1);
						}
					}
					//记录是否是PNR导入创建的订单
					if(orderflag==2)
					{
						if(orderinfonew.getMemo()!=null && !orderinfonew.getMemo().equals(""))
						{
						   orderinfonew.setMemo(orderinfonew.getMemo()+"[PNR导入创建]");
						}
						else
						{
							orderinfonew.setMemo("[PNR导入创建]");
						}
					}
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfonew);
					//创建操作记录
					try{
						Orderinforc orderinforc = new Orderinforc();
						orderinforc.setCustomeruserid(getLoginUserId());
						orderinforc.setOrderinfoid(orderinfonew.getId());
						orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						orderinforc.setContent("创建订单--" + this.getLoginUser().getMembername()+ "创建了订单");
						orderinforc.setSuouserid(orderinfonew.getUserid());
						orderinforc.setState(orderinfonew.getOrderstatus());
						orderinforc.setCustomeruserid(getLoginUserId());
						Server.getInstance().getAirService().createOrderinforc(orderinforc);
					}
					catch(Exception ex){
						System.out.println("创建操作记录异常："+ex.getMessage());
					}
					//最终订单价格
					float totalnewprice=orderinfonew.getTotalairportfee()+orderinfonew.getTotalfuelfee()+orderinfonew.getTotalticketprice();
					strNewTotalPrice=String.valueOf(totalnewprice);
				}
				
				
				if(orderinfo2.getId()>0){
					String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo1.getId() + " WHERE ID=" + orderinfo2.getId()+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo2.getId() + " WHERE ID=" + orderinfo1.getId();
				Server.getInstance().getSystemService().findMapResultBySql(sql,	null);

				}
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zrateone");
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zratetwo");
				
				 //是否保存常用乘机人信息
				if(!issavepassenger.equals(""))
				{
				String[] ArrIsSaveNew = issavepassenger.split(",");
				//String strTempPassenger = "";
//				for (int i = ArrIsSave.length - 1; i >= 0; i--) {
//					strTempPassenger += ArrIsSave[i] + ",";
//				}
				//String[] ArrIsSaveNew = strTempPassenger.split(",");

				for (int i = 0; i < listpassenger.size(); i++) {
					String where = " where 1=1 and "
							+ Customerpassenger.COL_customeruserid + " = "
							+ getLoginUser().getId() + " and "
							+ Customerpassenger.COL_username + " = '"
							+ listpassenger.get(i).getName().trim() + "'";

					List<Customerpassenger> list = Server.getInstance()
							.getMemberService().findAllCustomerpassenger(where,
									"", -1, 0);
					// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
					if (ArrIsSaveNew[i].equals("0")
							|| (list != null && list.size() > 0)) {
						continue;
					}
					try {
						// 当前登录员工
						Customeruser loginEmployee = getLoginUser();
						Customerpassenger customerpassenger = new Customerpassenger();
						customerpassenger.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customerpassenger.setCreateuser(getLoginUser()
								.getLoginname());
						customerpassenger.setUsername(listpassenger.get(i)
								.getName().trim());
						customerpassenger.setType(1);
						customerpassenger.setCustomeruserid(loginEmployee
								.getId());
						customerpassenger = Server.getInstance()
								.getMemberService().createCustomerpassenger(
										customerpassenger);
						// 添加证件
						Customercredit customercredit = new Customercredit();
						customercredit.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setCreateuser(loginEmployee
								.getMembername());
						if(listpassenger.get(i).getPtype()==1){
						customercredit.setCreditnumber(listpassenger.get(i)
								.getIdnumber().trim());
						customercredit.setCredittypeid(listpassenger.get(i)
								.getIdtype());
						}
						customercredit.setModifytime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setModifyuser(loginEmployee
								.getMembername());
						customercredit.setRefid(customerpassenger.getId());
						customercredit.setType(1);
						Server.getInstance().getMemberService()
								.createCustomercredit(customercredit);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				}
				System.out.println(orderinfo1.getId());
				System.out.println(orderinfo2.getId());
				strReturn = "b2bticketorder!payorder.action?orderinfo.id="
						+ orderinfo1.getId()+"&s_oldzratevalue="+strOldZrateValue+"&s_bestzratevalue="+strBestZrateValue+"&s_oldorderprice="+strOldTotalPrice+"&s_neworderprice="+strNewTotalPrice;
			
			if(customeragent.getType()==2){
				strReturn = "b2bticketorder!payorder2.action?orderinfo.id="
					+ orderinfo1.getId();
			}
			
			}

			//
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误:"+e.toString());
			strReturn = "ERROR";
		}
			
		return strReturn;
	}
	
	/**
	 * 新生成订单方法
	 * @param listsegmenginfo  航程信息
	 * @param listpassenger    乘机人信息
	 * @param orderinfo        订单信息
	 * @param zratelist        政策信息
	 * @param insurances       保险信息
	 * @param issavepassenger  是否保存常用旅客
	 * @param orderflag        订单创建类型  1=查询预订下订单，2=PNR导入创建订单，3=b2c网站创建订单
	 * @return
	 * @throws Exception
	 */
	public String CreateOrder_old(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{
		String strReturn="NOPNR";
		String s_returnpnr="";
		// 是否黑屏帐号创建PNR，1=使用黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 2;
		
		
		// 是否生成PNR
		int intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
		
		
	
		// 是否生成外部订单
		int intIsCreateOuterOrder =1; //0不生成外部订单   1生成外部订单
		// 是否按照原政策信息已经生成外部订单
		int intIsCreated = 1;//0按照本地政策   1按照最优政策
		
		int IsWhy=1; //0不分润接口   1分润接口
		
		String B2cWebPrice="";//B2C网站利润
		String WebPayPrice="";//C端支付价
		
		int chengrenNUM=0;
		
		if(orderflag==2){//PNR导入的
			
			intIsCreatePNR=0;
			intIsCreated=1;
		}
		
		//判断开始
		int isPASS=0;
		for(int p=0;p<listpassenger.size();p++){
			//if(listpassenger.get(p).getPtype()==2||listpassenger.get(p).getPtype()==3){
			if(listpassenger.get(p).getPtype()==3){
				isPASS=1;
				break;
			}
		}
		
		
		
		if(isPASS==1){//有儿童,不下单
			System.out.println("有婴儿,不生成PNR,不下外部订单");
			intIsCreatePNR = 0;  //0不生成PNR   1生成PNR
			intIsCreateOuterOrder =0; //0不生成外部订单   1生成外部订单
		}
		if(orderinfo.getPolicyagentid()!=null&&orderinfo.getPolicyagentid()==6){//今日政策...
			
			System.out.println("今日政策,不生成PNR,不下外部订单");
			intIsCreatePNR = 1;  //0不生成PNR   1生成PNR
			intIsCreateOuterOrder =0; //0不生成外部订单   1生成外部订单
			
		}
		
		// 最优政策
		Zrate bestzrate = new Zrate();
		String[] bxcounts = insurances.trim().split(",");
		//本地订单旧政策
		String strOldZrateValue="0";
		//最优政策
		String strBestZrateValue="0";
		//黑屏PAT票价，燃油，机建
		String pat_Price="0";
		String pat_Fuleprice="0";
		String pat_airportfee="0";
		//用于PAT:A价格发生变化时，订单提醒
		String strOldTotalPrice="0";
		String strNewTotalPrice="0";
		
		try{
			//订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			
			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize=listsegmenginfo.size();
			/******************循环航程list,并创建订单开始*************************/
			for(int s=0;s<intsegmentsize;s++)
			{
				List<Passenger> listpassengermodel=new ArrayList<Passenger>();
				Orderinfo orderinfomodel = new Orderinfo();
				orderinfomodel.setCreatetime(orderinfo.getCreatetime());
				orderinfomodel.setCustomeruserid(orderinfo.getCustomeruserid());
				orderinfomodel.setSaleagentid(orderinfo.getSaleagentid());
				orderinfomodel.setBuyagentid(orderinfo.getBuyagentid());
				orderinfomodel.setContactmobile(orderinfo.getContactmobile());
				orderinfomodel.setPaystatus(orderinfo.getPaystatus());
				orderinfomodel.setOrderstatus(orderinfo.getOrderstatus());
				orderinfomodel.setPaymethod(orderinfo.getPaymethod());
				orderinfomodel.setCurrplatfee(orderinfo.getCurrplatfee());
				orderinfomodel.setLanguage(orderinfo.getLanguage());
				orderinfomodel.setOrdertype(orderinfo.getOrdertype());
				orderinfomodel.setPnr(orderinfo.getPnr());
				if(orderinfo.getPostmoney()!=null){
					orderinfomodel.setPostmoney(orderinfo.getPostmoney());
					}
				if(orderflag==2){
					orderinfomodel.setPnrtxt(orderinfo.getPnrtxt());
					orderinfomodel.setPattxt(orderinfo.getPattxt());
				}
				orderinfomodel.setBigpnr(orderinfo.getBigpnr());
				orderinfomodel.setContactname(orderinfo.getContactname());
				if(orderinfo.getMemo()!=null){
				orderinfomodel.setMemo(orderinfo.getMemo());
				}
				Segmentinfo segmentinfo=listsegmenginfo.get(s);
				/*****订单信息赋值开始************************************************************/
				/****本地政策赋值开始*****************************************/
				Zrate zrate = Server.getInstance().getAirService().findZrate(zratelist.get(s));
				
				//判断开始.判断是否是固定饭店用户
				if(getLoginAgent().getBigtype()==2){//说明该加盟商是固定返点
					zrate.setRatevalue(Float.parseFloat(getLoginAgent().getFixedvalue()));
				}
				
				orderinfomodel.setPolicyid(zrate.getId());//政策ID
				orderinfomodel.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate.getRatevalue())));// 分销商返点
				//记录当前政策值
				strOldZrateValue=String.valueOf(orderinfomodel.getFenxiaoshangfandian());
				orderinfomodel.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfomodel.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfomodel.setExtpolicyid(zrate.getOutid()); // 外部政策id
				orderinfomodel.setPostmobile(zrate.getWorktime()+"-"+zrate.getAfterworktime());//供应商工作时间
				//orderinfomodel.setPostcode(zrate.getf);//废票时间
				
				segmentinfo.setAgentid(zrate.getAgentid());
				segmentinfo.setRatevalue(zrate.getRatevalue());
				
				segmentinfo.setZrateid(zrate.getId());
				segmentinfo.setLanguage(0);
				segmentinfo.setZrate(zrate);
				/****本地政策赋值结束*****************************************/ 
				
				/****订单信息赋值结束************************************************************/
				float subfuelfee = 0;
				float subairportfee = 0;
				float subprice = 0;
				/****乘机人信息赋值开始************************************************************/
				for (int i = 0; i < listpassenger.size(); i++) {
					if (listpassenger.get(i).getName().trim().length() > 0) {
						
						 if (listpassenger.get(i).getPtype() == 1) {
								chengrenNUM++;
							}
						 
						
					    Passenger passenger =new Passenger();
					       passenger.setName(listpassenger.get(i).getName());
					       passenger.setPtype(listpassenger.get(i).getPtype());
					       passenger.setIdnumber(listpassenger.get(i).getIdnumber());
					       passenger.setIdtype(listpassenger.get(i).getIdtype());
					       passenger.setState(listpassenger.get(i).getState());
					       passenger.setLanguage(listpassenger.get(i).getLanguage());
					       passenger.setAirportfee(listpassenger.get(i).getAirportfee());
					       passenger.setFuelprice(listpassenger.get(i).getFuelprice());
					       passenger.setPrice(listpassenger.get(i).getPrice());
					       passenger.setBirthday(listpassenger.get(i).getBirthday());
						if (passenger.getPtype() == 1  && orderflag!=2) {
							passenger.setPrice(segmentinfo.getPrice());
							passenger.setAirportfee(segmentinfo.getAirportfee());
							passenger.setFuelprice(segmentinfo.getFuelfee());
						} else if (passenger.getPtype() == 2 && orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(getRoundPrice(segmentinfo.getFuelfee(), 2));
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
							}
						} else if(orderflag!=2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(0f);
							// 儿童婴儿价
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 10));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 10));
							}
						}
						subprice += passenger.getPrice();
						subfuelfee += passenger.getFuelprice();
						subairportfee += passenger.getAirportfee();
						passenger.setDiscount(segmentinfo.getDiscount());
						listpassengermodel.add(passenger);
					}
				}
				/****乘机人信息赋值结束************************************************************/
				if(orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().equals(""))
				{
					System.out.println("小PNR导入，创建订单 PNR:"+orderinfomodel.getPnr());
					s_returnpnr=orderinfo.getPnr();
				}
				else if(orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().equals(""))
				{
					System.out.println("大PNR导入，创建订单  PNR:"+orderinfomodel.getBigpnr());
					s_returnpnr=orderinfomodel.getBigpnr();
				}
				else if(intIsCreatePNR==1)
				{
					if (intCreatePNRType == 1) {
					s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
					} else {
					//s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByInterFace(listsegmenginfo, listpassengermodel, orderinfo.getNewpnr());
						s_returnpnr=Server.getInstance().getRateService().createPNRByGDSBook(listsegmenginfo, listpassengermodel, orderinfo);
					}
					System.out.println("**********************生成的PNR编码："+ s_returnpnr);
					if(s_returnpnr.equals("-1")){
					//如果没有生成PNR...不创建外部订单,创建内部订单
						intIsCreateOuterOrder=0;
						intIsCreatePNR=0;
						s_returnpnr="123456";
						 return "NOPNR";
					}else{
						String newpnr="";
						String pnrtxt="";
						String pattxt="";
						
						newpnr=s_returnpnr.split("@")[0];
						pattxt=s_returnpnr.split("@")[1];
						pnrtxt=s_returnpnr.split("@")[2];
						orderinfomodel.setPattxt(pattxt);
						orderinfomodel.setPnrtxt(pnrtxt);
						orderinfomodel.setPnr(newpnr);
						if(pattxt.indexOf("没有符合条件的运价")!=-1){
							System.out.println("没有符合条件的运价,订单创建失败");
							
							 return "NOPNR";
						}
						
					}
				}
				else
				{
					s_returnpnr="123456";
				}
				
				// 判断是否生成PNR
				if (s_returnpnr.equals("NOPNR")) {
					strReturn = "NOPNR";
					
					break;
				}
				// 机建费
				orderinfomodel.setTotalairportfee(subairportfee);
				// 燃油费
				orderinfomodel.setTotalfuelfee(subfuelfee);
				// 总机票价格+平台费用
				orderinfomodel.setTotalticketprice(subprice);// 存入数据库中的数据
				//
				float totalallprice=orderinfomodel.getTotalairportfee()+orderinfomodel.getTotalfuelfee()+orderinfomodel.getTotalticketprice();
				strOldTotalPrice=String.valueOf(totalallprice);
				if((orderinfomodel.getPnr()!=null && !orderinfomodel.getPnr().trim().equals("")) || (orderinfomodel.getBigpnr()!=null && !orderinfomodel.getBigpnr().trim().equals("")))
				{
					System.out.println("PNR导入订单信息");
				}
				else
				{
					//PNR赋值
					
					//吉祥航空公司判断
					/*if(s_returnpnr.length()>7){
						
						
						s_returnpnr=s_returnpnr.replaceAll(" ", "");
							
							int max=s_returnpnr.length();
							int min=max-6;
							
							s_returnpnr=s_returnpnr.substring(min, max);
							System.out.println(s_returnpnr);
						
					}
					
					orderinfomodel.setPnr(s_returnpnr.trim());*/
					String strBigPNR = "无";
					//只有51book才获取大PNR
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
					/*if (orderinfomodel.getPolicyagentid() == 5) {
						strBigPNR = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
					}
					orderinfomodel.setBigpnr(strBigPNR);*/
					
					//陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
				}
				
				//orderinfomodel.setPostmoney(0);
				orderinfomodel.setPassengerlist(listpassengermodel);
				listOrderinfo.add(orderinfomodel);
			}
			/******************循环航程list,并创建订单结束*************************/
			
			//如果生成PNR则创建订单，否则提示创建订单失败
			if (!s_returnpnr.equals("NOPNR")) {
				for (int j = 0; j < listOrderinfo.size(); j++) {
				  Orderinfo	orderinfonew = listOrderinfo.get(j);

					Segmentinfo seginfo = listsegmenginfo.get(j);
					//*****************************************************//
					//Pat:a取得黑屏中票价
					String strPatInfo="";
					if(intIsCreatePNR==1 && orderflag==4)
					//if(intIsCreatePNR==1 && orderflag!=2)
					{
					try
					{
					  strPatInfo=Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$PAT:A", "", "");
						
						Pattern pat = Pattern.compile("[P][A][T][:][A]");
					  String[] strPatarr = pat.split(strPatInfo);
					  if(strPatarr.length>=2)
					  {
						  Pattern patitem=Pattern.compile("\\s{1,}");
						  String[] strpatItem=patitem.split(strPatarr[1]);
						  for(int i=0;i<strpatItem.length;i++) 
						  {
							  if(!strpatItem[i].trim().equals(""))
							  {
								  //票价
								  if(strpatItem[i].trim().indexOf("FARE:")>=0 && pat_Price.equals("0"))
								  {
									  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
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
					  //核对黑屏中价格信息与航程中价格信息是否一样
					  Float f_segmentprice=0f;
					  Float f_segmentfuelprice=0f;
					  Float f_segmentairportfee=0f;
				      f_segmentprice=Float.parseFloat(pat_Price);
				      f_segmentfuelprice=Float.parseFloat(pat_Fuleprice);
				      f_segmentairportfee=Float.parseFloat(pat_airportfee);
				      
				      if(orderinfonew.getPassengerlist().get(0).getPtype()==1)
				      {   //票价不一致
					      if(f_segmentprice.floatValue()!=listsegmenginfo.get(0).getParvalue() || f_segmentfuelprice.floatValue()!=listsegmenginfo.get(0).getFuelfee() || f_segmentairportfee.floatValue()!=listsegmenginfo.get(0).getAirportfee())
					      {
					    	  float sub_price=0;
					    	  float sub_fuelfee=0;
					    	  float sub_airportfee=0;
					    	  //修改航程信息中的价格信息
					    	  seginfo.setParvalue(f_segmentprice);//未匹配政策票面价
					    	  //计算优惠价格
					    	  Float fdiscountprice=f_segmentprice*orderinfonew.getFenxiaoshangfandian()/100;
					    	  int intdiscountprice=fdiscountprice.intValue();
					    	  //计算实际结算价格
					    	  f_segmentprice =f_segmentprice-intdiscountprice;
					    	  seginfo.setPrice(f_segmentprice); //匹配政策票面价
					    	  //修改乘机人中的价格信息
					    	  for (Passenger passenger:orderinfonew.getPassengerlist()) 
					    	  {
					    		  
					    		 
					    		  
					    		  passenger.setAirportfee(f_segmentairportfee);
					    		  passenger.setFuelprice(f_segmentfuelprice);
					    		  passenger.setPrice(f_segmentprice);
					    		  sub_price += passenger.getPrice();
								  sub_fuelfee += passenger.getFuelprice();
							      sub_airportfee += passenger.getAirportfee();
					    	  }
					    	  //修改订单中的价格信息
					    	  // 机建费
					    	  orderinfonew.setTotalairportfee(sub_airportfee);
						      // 燃油费
					    	  orderinfonew.setTotalfuelfee(sub_fuelfee);
							  // 总机票价格+平台费用
					    	  orderinfonew.setTotalticketprice(sub_price);
					    	  
					      }
				      }
					  
					}
					catch(Exception ex){
						
					}
					System.out.println("**********************PAT:A："+ strPatInfo);
					System.out.println("**********************黑屏中：票价"+ pat_Price+"|||燃油："+pat_Fuleprice+"||||机建"+pat_airportfee);
					}
					
					//************************pat****************************//
					
					// 如果是其他供应商政策，则不生成外部订单
					if ((orderinfonew.getPolicyagentid() == 3
							|| orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2 || orderinfonew.getPolicyagentid() == 46)
							&& intIsCreateOuterOrder == 1) {
						intIsCreateOuterOrder = 1;
						System.out.println("属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
					} else {
						intIsCreateOuterOrder = 0;
						// 不属于平台政策，则可以直接支付订单
						if(orderinfonew.getPaymethod()==2 || orderinfonew.getPaymethod()==3)
						{
							orderinfonew.setOrderstatus(2);
						}
						else
						{
						   orderinfonew.setOrderstatus(1);
						}
						System.out.println("不属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
						
						if(orderinfonew.getPolicyagentid() == 6){
							System.out.println("今日政策...不生成外部订单");
						}
					}
					
					//是否创建外部订单开始----------------------------------------------------------------------------------------------
					if (intIsCreateOuterOrder == 1) {
						try {
							//如果是普通政策，则直接按照最优政策生成订单
							if(seginfo.getZrate().getGeneral()==2)
							{
								
								bestzrate=seginfo.getZrate();
								//计算利润
								System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
								WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
								
								if(WebPayPrice.equals("0.0")){
									WebPayPrice="0";
								}else{
									WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
									
								}
								
								//从新计算价格开始
								
								float newprice=0f;
								for (Passenger passeng : orderinfonew.getPassengerlist()) {
									passeng.setOrderid(orderinfonew.getId());
									
									
									// 获取最优政策，更新乘机人信息
									// Created By:sunbin
									// 2011-10-18
									if (bestzrate != null
											&& bestzrate.getRatevalue() != null
											&& bestzrate.getAgentid() != null) {
										if (passeng.getPtype() == 1) {
											passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
													.getRatevalue()))/100);
											
										} else if (passeng.getPtype() == 2) {
											passeng.setAirportfee(0f);
											
											//平台创建儿童订单
											if(orderflag!=2)
											{
												passeng.setFuelprice(getRoundPrice(seginfo
														.getFuelfee(), 2));
												if (seginfo.getDiscount() > 100) {
													passeng.setPrice(getRoundPrice(seginfo
															.getParvalue(), 2));
												} else {
													passeng.setPrice(getRoundPrice(seginfo
															.getYprice(), 2));
												}
											}
											
										} else {
											passeng.setAirportfee(0f);
											passeng.setFuelprice(0f);
											// 儿童婴儿价
											if(orderflag!=2)
											{
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 10));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 10));
											}
											}
											
										}
										newprice += passeng.getPrice();
										// 获取最优政策，更新乘机人信息
										// 结束
									}
									
									
								}
								
								//计算结束
								
								B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
								
								
								B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
								
								System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice);
								
								orderinfonew.setB2cprofit(WebPayPrice);//B2C利润
								orderinfonew.setCclientpayprice(B2cWebPrice);//c端支付价
								orderinfonew.setIspayhthy(IsWhy);
								
								
								
								
								
								
								
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								intIsCreated = 1;
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else {
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								intIsCreated = 0;
								System.out.println("按照本地政策，创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
							}
							}
							else//匹配最优政策
							{
								if(orderflag==2){
								intIsCreated = 0;	
									
								}else{
								
								intIsCreated = 1;
								}
								
								intIsCreated = 1;
							}
						} catch (Exception ex) {
							intIsCreated = 0;
							System.out.println("按照本地政策，创建外部订单失败，异常结果:"
									+ ex.getMessage());
						}
						System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
						System.out.println("是否生成外部订单标记：" + intIsCreateOuterOrder
								+ " 是否已按照原始政策生成外部订单：" + intIsCreated);
					}
					
					//创建外部订单结束---------------------------------------------------------------------------------------------------------
					
					
					// 如果没有按照原始政策，生成外部订单，则按照最优政策信息，再次生成外部订单
					
					//if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
					if (intIsCreateOuterOrder == 1 && intIsCreated == 1) {
						// 匹配最优政策，并生成外部订单
						try {
							try {
								if(orderinfonew.getPassengerlist().get(0).getPtype()==1)
								{
								bestzrate = Server.getInstance()
										.getRateService().FindZrateByFlight(
												orderinfonew, seginfo,
												orderinfonew.getPassengerlist());
								}
								else
								{
									bestzrate =Server.getInstance().getAirService().findZrate(1l);
								}
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									try {
										// 计算价格
										orderinfonew
												.setPolicyid(bestzrate.getId());// 政策ID
										orderinfonew
												.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
														.getRatevalue())));// 分销商返点
										//记录最优政策返销商返点
										strBestZrateValue=String.valueOf(orderinfonew.getFenxiaoshangfandian());
										orderinfonew.setPolicyagentid(bestzrate
												.getAgentid());// 政策提供商id
										orderinfonew
												.setRatevalue(dceimalFormat(bestzrate
														.getRatevalue()));// 折扣
										orderinfonew.setExtpolicyid(bestzrate
												.getOutid()); // 外部政策id
										System.out.println("调用最优政策方法,成功,政策为=="
												+ bestzrate);
									} catch (RuntimeException e) {
										System.out
												.println("调用最优政策方法,出现异常,异常信息："
														+ e.getMessage());
										e.printStackTrace();
									}
								}else{
									
									
									bestzrate=Server.getInstance().getAirService().findZrate(zratelist.get(j));
								}

							} catch (RuntimeException e) {
								System.out.println("调用最优政策方法,出现异常,异常信息："
										+ e.getMessage());
								e.printStackTrace();
							}
							seginfo.setZrate(bestzrate);
							// 创建外部订单，方法调用
							
							System.out.println("成人数:"+chengrenNUM+",政策返点:"+orderinfonew.getRatevalue()+",分销商返点:"+orderinfonew.getFenxiaoshangfandian()+",票面价:"+seginfo.getParvalue());
							WebPayPrice=chengrenNUM*seginfo.getParvalue()*(orderinfonew.getRatevalue()-orderinfonew.getFenxiaoshangfandian())/100+"";
							
							if(WebPayPrice.equals("0.0")){
								WebPayPrice="0";
							}else{
								WebPayPrice=(Math.floor(Float.parseFloat(WebPayPrice))+"").substring(0, (Math.floor(Float.parseFloat(WebPayPrice))+"").indexOf("."));
								
							}
							
							//从新计算价格开始
							
							float newprice=0f;
							for (Passenger passeng : orderinfonew.getPassengerlist()) {
								passeng.setOrderid(orderinfonew.getId());
								
								
								// 获取最优政策，更新乘机人信息
								// Created By:sunbin
								// 2011-10-18
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									if (passeng.getPtype() == 1) {
										passeng.setPrice(seginfo.getParvalue()-seginfo.getParvalue()*dceimalFormat(Getliudianvalue(bestzrate
												.getRatevalue()))/100);
										
									} else if (passeng.getPtype() == 2) {
										passeng.setAirportfee(0f);
										
										//平台创建儿童订单
										if(orderflag!=2)
										{
											passeng.setFuelprice(getRoundPrice(seginfo
													.getFuelfee(), 2));
											if (seginfo.getDiscount() > 100) {
												passeng.setPrice(getRoundPrice(seginfo
														.getParvalue(), 2));
											} else {
												passeng.setPrice(getRoundPrice(seginfo
														.getYprice(), 2));
											}
										}
										
									} else {
										passeng.setAirportfee(0f);
										passeng.setFuelprice(0f);
										// 儿童婴儿价
										if(orderflag!=2)
										{
										if (seginfo.getDiscount() > 100) {
											passeng.setPrice(getRoundPrice(seginfo
													.getParvalue(), 10));
										} else {
											passeng.setPrice(getRoundPrice(seginfo
													.getYprice(), 10));
										}
										}
										
									}
									newprice += passeng.getPrice();
									// 获取最优政策，更新乘机人信息
									// 结束
								}
								
								
							}
							
							//计算结束
							
							B2cWebPrice=newprice+ orderinfonew.getTotalfuelfee()+ orderinfonew.getTotalairportfee()+"";
							
							
							B2cWebPrice=Math.round(Float.parseFloat(B2cWebPrice)+0.4)+"";
							
							System.out.println("B2cWebPrice:"+B2cWebPrice+",WebPayPrice:"+WebPayPrice);
							
							orderinfonew.setB2cprofit(WebPayPrice);//B2C利润
							orderinfonew.setCclientpayprice(B2cWebPrice);//c端支付价
							orderinfonew.setIspayhthy(IsWhy);
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfonew,
											seginfo, orderinfonew.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								if (orderinfonew.getPolicyagentid() == 5 || orderinfonew.getPolicyagentid() == 2) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfonew
														.setExtorderid(strExtOrderArr[1]);
												orderinfonew
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else {
									// 外部订单号
									orderinfonew.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfonew.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfonew.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (orderinfonew.getPaymethod()==2
										|| orderinfonew.getPaymethod()==3) {
									orderinfonew.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfonew.setOrderstatus(2);
								} else {
									orderinfonew.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								System.out.println("按照最优政策创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
								 return "ERROR";
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("按照最优政策创建外部订单失败，异常信息"
									+ e.getMessage());
						}
					}

					// 计算总利润，以及留点记录信息
					// 成人总数
					int intadult = 0;
					//儿童总数
					int intchlid=0;
					for (int i = 0; i < orderinfonew.getPassengerlist().size(); i++) {
						if (orderinfonew.getPassengerlist().get(i).getPtype() == 1) {
							intadult++;
						}
						else if (orderinfonew.getPassengerlist().get(i).getPtype() == 2) {
							intchlid++;
						}
						
					}
					Float fzonglirun=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fzonglirun = orderinfonew.getRatevalue()
						* seginfo.getParvalue() / 100 * intadult;
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
						   fzonglirun=0.025f* seginfo.getYprice()/2 * intchlid;
						}
						else
						{
							fzonglirun=listsegmenginfo.get(0).getParvalue()*0.025f*intchlid;
						}
					}
					
					int intzonglirun = fzonglirun.intValue();
					orderinfonew.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));

					// 生成本地订单信息
					orderinfonew.setPaystatus(0);
					
					orderinfonew.setOrderstatus(1);
					orderinfonew = Server.getInstance().getAirService().createOrderinfo(orderinfonew);
					
					System.out.println("订单详细信息");
					System.out.println(orderinfonew.toString());
					System.out.println("订单详细信息============");
					System.out.println(orderinfonew.getOrdernumber());
					System.out.println("订单信息==" + orderinfonew);
					System.out.println("订单ID==" + orderinfonew.getId());
					System.out.println("外部订单ID==" + orderinfonew.getExtorderid());

					Segmentinfo segmetemp = listsegmenginfo.get(j);
					segmetemp.setOrderid(orderinfonew.getId());
					// 获取新政策，更新航程信息
					// Creater by:sunbin
					// 2011-10-18
					if (bestzrate != null && bestzrate.getRatevalue() != null
							&& bestzrate.getAgentid() != null) {
						Float fsegmentprice=0f;
						if(segmetemp.getParvalue()!=null)
						{
							fsegmentprice= segmetemp.getParvalue();
						}
						else
						{
							fsegmentprice=0f;
						}
						//计算优惠价格
				    	Float fdiscountprice=fsegmentprice*Getliudianvalue(bestzrate.getRatevalue())/100;
				    	int intdiscountprice=fdiscountprice.intValue();
				    	//计算实际结算价格
				    	fsegmentprice =fsegmentprice-intdiscountprice;

						int intsegmentprice = fsegmentprice.intValue();
						segmetemp.setAgentid(bestzrate.getAgentid());
						segmetemp.setRatevalue(bestzrate.getRatevalue());
						segmetemp.setZrateid(bestzrate.getId());
						segmetemp.setPrice(Float.parseFloat(String
								.valueOf(intsegmentprice)));
						segmetemp.setRules(bestzrate.getRemark());
					}
					// 获取新政策，更新航程信息
					// 结束
					segmetemp = Server.getInstance().getAirService()
							.createSegmentinfo(segmetemp);

					System.out.println(orderinfonew.getPassengerlist().size());
					int l = 0;
					float subpricenew = 0;
					float insurprice = 0f;// 保险价格
					Sysconfig sysconfig=Server.getInstance().getSystemService().findSysconfig(1);
					float bxcb=20;
					HttpSession session = ServletActionContext.getRequest().getSession();
					if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
						bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
					}
					for (Passenger passeng : orderinfonew.getPassengerlist()) {
						passeng.setOrderid(orderinfonew.getId());
						int bxcount = 0;
						try{
						bxcount=Integer.valueOf(bxcounts[l].trim());
						}catch(Exception e){
						}
						if (bxcount> 0) {							
							passeng.setInsurprice(bxcount*bxcb);
							if (listsegmenginfo.size()==2) {
								if (!new B2bAirSearchAction().isInInsrutime(
										listsegmenginfo.get(0).getDeparttime(), listsegmenginfo.get(1).getDeparttime())) {//不在一个保险期内。
									if (j == 0) {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.ceil(Integer
													.valueOf(bxcount) / 2.0);
										}
									
										passeng.setInsurprice(bxcb*count);
									} else {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.floor(Integer
													.valueOf(bxcount) / 2.0);
		
											passeng.setInsurprice(bxcb*count);
										}
									}

								} else {//在一个保险期内
									if (j == 0) {
										
									//	passeng.setInsurance(insurance.getId());
										passeng.setInsurprice(bxcount*bxcb);
									}
								}
							} else {
								passeng.setInsurprice(bxcount*bxcb);

							}
							insurprice += passeng.getInsurprice();
						}
						// 获取最优政策，更新乘机人信息
						// Created By:sunbin
						// 2011-10-18
						if (bestzrate != null
								&& bestzrate.getRatevalue() != null
								&& bestzrate.getAgentid() != null) {
							if (passeng.getPtype() == 1) {
								passeng.setPrice(segmetemp.getPrice());
								passeng.setAirportfee(segmetemp
										.getAirportfee());
								passeng.setFuelprice(segmetemp.getFuelfee());
							} else if (passeng.getPtype() == 2) {
								passeng.setAirportfee(0f);
								
								//平台创建儿童订单
								if(orderflag!=2)
								{
									passeng.setFuelprice(getRoundPrice(segmetemp
											.getFuelfee(), 2));
									if (seginfo.getDiscount() > 100) {
										passeng.setPrice(getRoundPrice(segmetemp
												.getParvalue(), 2));
									} else {
										passeng.setPrice(getRoundPrice(segmetemp
												.getYprice(), 2));
									}
								}
								
							} else {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(0f);
								// 儿童婴儿价
								if(orderflag!=2)
								{
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmetemp
											.getParvalue(), 10));
								} else {
									passeng.setPrice(getRoundPrice(segmetemp
											.getYprice(), 10));
								}
								}
								
							}
							subpricenew += passeng.getPrice();
							// 获取最优政策，更新乘机人信息
							// 结束
						}
						Server.getInstance().getAirService().createPassenger(
								passeng);
						l++;
					}

					// 更新订单总价信息
					if (subpricenew != 0f) {
						// 总机票价格+平台费用
						orderinfonew.setTotalticketprice(subpricenew);// 存入数据库中的数据
					}
					if (j == 0) {
						this.orderinfo1 = orderinfonew;
					} else {
						this.orderinfo2 = orderinfonew;
					}
					System.out.println("***************************返佣信息**************************************");
					System.out.println(orderinfonew.getId());
					
					System.out.println(orderinfonew.getRatevalue());
					Float fparvalue=0f;
					if(seginfo.getParvalue()!=null && intadult>0)
					{
						fparvalue=seginfo.getParvalue();
					}
					else if(intchlid>0)
					{
						if(orderflag!=2)
						{
							fparvalue=getRoundPrice(seginfo.getYprice(), 2);
						}
						else
						{
							fparvalue=seginfo.getParvalue();
						}
					}
					String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfonew.getRatevalue(),
							Getliudianvalue(orderinfonew.getRatevalue()), fparvalue, insurprice);
					System.out.println(strCustomgeragentBackPointInfo);
					orderinfonew.setFenxiaoshangfandian(Getliudianvalue(orderinfonew.getRatevalue()));
					orderinfonew.setBackpointinfo(strCustomgeragentBackPointInfo);
					//如果是PNR导入创建订单，则所有订单都需要平台确认价格后，才能够进行支付
					String strOrderPnr="";
					if(orderinfonew.getPnr()!=null)
					{
						strOrderPnr=orderinfonew.getPnr();
					}
					else if(orderinfonew.getBigpnr()!=null)
					{
						strOrderPnr=orderinfonew.getBigpnr();
					}
					if((orderflag==2 && getLoginUserAgent().getAgenttype()!=1) || strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456"))
					{
						//待确认订单状态
						//orderinfonew.setOrderstatus(27);
						if(strOrderPnr.equals("NOPNR")||strOrderPnr.equals("123456")){
							
							
						}else{
						orderinfonew.setOrderstatus(1);
						}
					}
					//记录是否是PNR导入创建的订单
					if(orderflag==2)
					{
						if(orderinfonew.getMemo()!=null && !orderinfonew.getMemo().equals(""))
						{
						   orderinfonew.setMemo(orderinfonew.getMemo()+"[PNR导入创建]");
						}
						else
						{
							orderinfonew.setMemo("[PNR导入创建]");
						}
					}
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfonew);
					//创建操作记录
					try{
						Orderinforc orderinforc = new Orderinforc();
						orderinforc.setCustomeruserid(getLoginUserId());
						orderinforc.setOrderinfoid(orderinfonew.getId());
						orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						orderinforc.setContent("创建订单--" + this.getLoginUser().getMembername()+ "创建了订单");
						orderinforc.setSuouserid(orderinfonew.getUserid());
						orderinforc.setState(orderinfonew.getOrderstatus());
						orderinforc.setCustomeruserid(getLoginUserId());
						Server.getInstance().getAirService().createOrderinforc(orderinforc);
					}
					catch(Exception ex){
						System.out.println("创建操作记录异常："+ex.getMessage());
					}
					//最终订单价格
					float totalnewprice=orderinfonew.getTotalairportfee()+orderinfonew.getTotalfuelfee()+orderinfonew.getTotalticketprice();
					strNewTotalPrice=String.valueOf(totalnewprice);
				}
				
				
				if(orderinfo2.getId()>0){
					String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo1.getId() + " WHERE ID=" + orderinfo2.getId()+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
						+ orderinfo2.getId() + " WHERE ID=" + orderinfo1.getId();
				Server.getInstance().getSystemService().findMapResultBySql(sql,	null);

				}
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zrateone");
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zratetwo");
				
				 //是否保存常用乘机人信息
				if(!issavepassenger.equals(""))
				{
				String[] ArrIsSaveNew = issavepassenger.split(",");
				//String strTempPassenger = "";
//				for (int i = ArrIsSave.length - 1; i >= 0; i--) {
//					strTempPassenger += ArrIsSave[i] + ",";
//				}
				//String[] ArrIsSaveNew = strTempPassenger.split(",");

				for (int i = 0; i < listpassenger.size(); i++) {
					String where = " where 1=1 and "
							+ Customerpassenger.COL_customeruserid + " = "
							+ getLoginUser().getId() + " and "
							+ Customerpassenger.COL_username + " = '"
							+ listpassenger.get(i).getName().trim() + "'";

					List<Customerpassenger> list = Server.getInstance()
							.getMemberService().findAllCustomerpassenger(where,
									"", -1, 0);
					// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
					if (ArrIsSaveNew[i].equals("0")
							|| (list != null && list.size() > 0)) {
						continue;
					}
					try {
						// 当前登录员工
						Customeruser loginEmployee = getLoginUser();
						Customerpassenger customerpassenger = new Customerpassenger();
						customerpassenger.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customerpassenger.setCreateuser(getLoginUser()
								.getLoginname());
						customerpassenger.setUsername(listpassenger.get(i)
								.getName().trim());
						customerpassenger.setType(1);
						customerpassenger.setCustomeruserid(loginEmployee
								.getId());
						customerpassenger = Server.getInstance()
								.getMemberService().createCustomerpassenger(
										customerpassenger);
						// 添加证件
						Customercredit customercredit = new Customercredit();
						customercredit.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setCreateuser(loginEmployee
								.getMembername());
						if(listpassenger.get(i).getPtype()==1){
						customercredit.setCreditnumber(listpassenger.get(i)
								.getIdnumber().trim());
						customercredit.setCredittypeid(listpassenger.get(i)
								.getIdtype());
						}
						customercredit.setModifytime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setModifyuser(loginEmployee
								.getMembername());
						customercredit.setRefid(customerpassenger.getId());
						customercredit.setType(1);
						Server.getInstance().getMemberService()
								.createCustomercredit(customercredit);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				}
				System.out.println(orderinfo1.getId());
				System.out.println(orderinfo2.getId());
				strReturn = "b2bticketorder!payorder.action?orderinfo.id="
						+ orderinfo1.getId()+"&s_oldzratevalue="+strOldZrateValue+"&s_bestzratevalue="+strBestZrateValue+"&s_oldorderprice="+strOldTotalPrice+"&s_neworderprice="+strNewTotalPrice;
			
			if(getLoginAgent().getType()==2){
				strReturn = "b2bticketorder!payorder2.action?orderinfo.id="
					+ orderinfo1.getId();
			}
			
			}

			//
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误:"+e.toString());
			strReturn = "ERROR";
		}
			
		return strReturn;
		
	}

	
	
	/**
	 * 更新订单方法
	 * @param listsegmenginfo  航程信息
	 * @param listpassenger    乘机人信息
	 * @param orderinfo        订单信息
	 * @param zratelist        政策信息
	 * @param insurances       保险信息
	 * @param issavepassenger  是否保存常用旅客
	 * @param orderflag        订单创建类型  1=查询预订下订单，2=PNR导入创建订单，3=b2c网站创建订单
	 * @return
	 * @throws Exception
	 */
	public String UpdateOrder(List<Segmentinfo> listsegmenginfo,List<Passenger> listpassenger,Orderinfo orderinfo,List<Long> zratelist,String insurances,String issavepassenger,int orderflag) throws Exception{

		return "";
	}
	
	
	public String getTestyuyan() {
		return testyuyan;
	}

	public void setTestyuyan(String testyuyan) {
		this.testyuyan = testyuyan;
	}

	public String getTestcity() {
		return testcity;
	}

	public void setTestcity(String testcity) {
		this.testcity = testcity;
	}

	public String getPropPath() {
		return propPath;
	}

	public void setPropPath(String propPath) {
		this.propPath = propPath;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Orderinfo getOrderinfo2() {
		return orderinfo2;
	}

	
	public void setOrderinfo2(Orderinfo orderinfo2) {
		this.orderinfo2 = orderinfo2;
	}

	public Orderinfo getOrderinfo1() {
		return orderinfo1;
	}

	public void setOrderinfo1(Orderinfo orderinfo1) {
		this.orderinfo1 = orderinfo1;
	}
	public static void main(String[] args) throws MalformedURLException {
		/*String url = " http://localhost:8080/interface/service/" ;

		HessianProxyFactory factory = new HessianProxyFactory();
		ITicketSearchService servier = (ITicketSearchService) factory.create(ITicketSearchService.class,
				url + ITicketSearchService.class.getSimpleName());
		String[] mobiles = { "15110289787" };
		List<Passenger> listpassenger =Server.getInstance().getAirService().findAllPassenger("where 1=1", "", -1, 0) ;
		List<Segmentinfo> listsegmentinfo = Server.getInstance().getAirService().findAllSegmentinfo("where 1=1", "", -1, 0);
		B2b2cbackAction action = null;*/
		//action.sendTXTSmstoLinkuser1(mobiles, listpassenger, listsegmentinfo);
		B2b2cbackAction action = null;
		action.LubricatingByHotelorderID(10492);
		
	}
}
