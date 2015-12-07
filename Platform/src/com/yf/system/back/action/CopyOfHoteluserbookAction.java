package com.yf.system.back.action;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.lang.StringUtils;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.base.advertisement.Advertisement;
import com.yf.system.base.chaininfo.Chaininfo;
import com.yf.system.base.city.City;
import com.yf.system.base.creditcard.Creditcard;
import com.yf.system.base.creditcard.CreditcardBean;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelinter.BookingRules;
import com.yf.system.base.hotelinter.GuaranteeRule;
import com.yf.system.base.hotelinter.NightlyRate;
import com.yf.system.base.hotelinter.PrepayRule;
import com.yf.system.base.hotelinter.RatePlan;
import com.yf.system.base.hotelinter.SeachHotelBean;
import com.yf.system.base.hotellandmark.Hotellandmark;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.hotelspec.Hotelspec;
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.region.Region;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.specialprice.Specialprice;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.ymsend.Ymsend;

/**
 * 
 * 酒店预订Action
 * 
 */
public class CopyOfHoteluserbookAction extends B2b2cbackAction {
	//预订酒店
	private String roomcode;
	private String roomname;
	
	private List<Chaininfo> listchain;
	private List<Hotel> listhotelbj;
	private List<Hotel> listhotelsh;
	private List<Hotel> listhotelgz;
    private List<Hotel> listhotelsz;
    
    
    private String EarliestArrivalTime;	//保留开始时间
	private String LatestArrivalTime;	//保留结束时间
	private int  NumberOfRooms;//房间数 
	//
	private Float  rebvaule=1f;
	private int zongjia;
	private String forword;	
	private String hoteldaohang;	
	
	private String pricecode;
	private Long hotelorderid;	
	private int add=0;	
	private int type=0;
	private int usertype=0;
	private int typ=1;
	private List<Sysmessage> listsysmessage;
	//国家类型
	private int guojia=1;
	//排序
	private int orderType;
	private int orderMode;
	//每日平均价格
	private Double junjia;	
	
	
	private Double Hotelrebate;//酒店返点比例
	private Guest guest = new Guest();
	// 酒店
	private Hotel hotel = new Hotel();
	//房型
	private Roomtype roomtype = new Roomtype();
	private Roomtype NEWroomtype = new Roomtype();
	// 城市名称
    private String regionid;
	private Long cityId;
	
	private String s_cityid;

	//单间总价返利
	private Float HotelPos;
	
	// 酒店ID
	private Long hotelid;
	// 酒店房型ID
	private Long roomid;
	// 区域
	private String regionvalue;
	// 酒店位置类型
	private String regiontype;
	// 星级
	private String[] s_star;
	
	private String s_hotelstar;
	
	// 装修
	private String[] s_repair;
	// 酒店价格类型
	private int priceType = 0;
	// 入住日期
	private String startDate;
	// 离店日期
	private String endDate;
	// 酒店名称 
	private String hotelName;
	private String s_hotelName;
	private String bradnhotelid;
	
	// 酒店列表
	private List<Hotel> hotelList;
	//特别推广酒店
	private List<Hotel> hotelList_tebie;
	private List<Specialprice> listspe;
	private String s_price;
	//酒店导航
	private List<Hotel> hotelList_daohang;
	// 酒店列表
	private List<Roomtype> listRoomtype;
	// 酒店常用旅客
	private List<Customerpassenger> listCustomerpassenger;
	private List<Hotellandmark> listHotellandmark;

	// 酒店常用旅客
	private List<Guest> listGuest;
	// 客房类型列表
	private Map<Long,List<Roomtype>> mapRoom = new HashMap<Long,List<Roomtype>>();//酒店--房型
	private Map<Long,Integer> RoomPrice = new HashMap<Long,Integer>();//房型--价格
	private Map<Long,List> RoomListPrice = new HashMap<Long,List>();//房型--价格list
	private Map<Long,List<Hotelprice>> mappice = new HashMap<Long,List<Hotelprice>>();
	private Map<String,List> mappicemack = new HashMap<String,List>();//门市价,首日价
	private Map<Long,List> mapserviceItem = new HashMap<Long,List>();//
	private Map<Long,List> mapfootItems = new HashMap<Long,List>();//
	private Map<Long,List> mapplayItems = new HashMap<Long,List>();//
	private List Listmackrice = new ArrayList();
	// 城市列表
	private List<City> cityList = new ArrayList<City>();
	
	//存放酒店session得list

    //private String listhotelsession="";
    private List listhotelsession = new ArrayList();
    //
	//区域
	private List<Region> listAdmin;
	// 所有星级
	//private Map<String, String> starList = new HashMap<String, String>();
	// 酒店订单操作日志列表
	private List<Hotelprice> hotelpriceList= new ArrayList<Hotelprice>();
	
	private List listserviceItem = new ArrayList();
	private List listfootItems = new ArrayList();
	private List listplayItems = new ArrayList();
	private List Listroomtypeprice = new ArrayList();
	private List Listprice = new ArrayList();
	
	private List<Hotelimage> ListHotelimage;
	private List<Roomtype> ListRoomtype1;
	private List<Roomtype> ListRoomtype;
	private List<Hotelprice> ListHotelprice;
	// 客房类型列表
	
	private Map<Long,List<Hotelprice>> mapPrice = new HashMap<Long,List<Hotelprice>>();
	//房型对应的价格
	private Map<Long,List<Hotelprice>> mapRoomprice = new HashMap<Long,List<Hotelprice>>();
	
	private String InRoomPeople;
	private String InRoommobile;
	private String hidsex;
	private String InRoomCountry;
	
	//多语言
	private String language;
	
	private long s_num;
	private String username0;
	private String mobile0;
	private String username1;
	private String mobile1;
	private String username2;
	private String mobile2;
	private String username3;
	private String mobile3;
	private String username4;
	private String mobile4;
	private String username5;
	private String mobile5;
	private String username6;
	private String mobile6;
	private String username7;
	private String mobile7;
	private String Date1;
	private String Date2;
	private String Date3;
	private String Date4;
	private String Date5;
	private String Date6;
	private String Date7;
	private StringBuffer searchInfo;
	
	public StringBuffer getSearchInfo(){
		return this.searchInfo;
	}
	public CopyOfHoteluserbookAction() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE , 1);
		endDate = sdf.format(calendar.getTime());
	/*	
		starList.put("1", "经济型");
		starList.put("3", "二星级");
		starList.put("4", "准三星");
		starList.put("5", "三星级");
		starList.put("6", "准四星");
		starList.put("7", "四星级");
		starList.put("8", "准五星");
		starList.put("9", "五星级");*/
	}

	
	//
	private String s_citycode;//城市代码
	private String s_hotelcode;
	private String s_hotelid;
	private String s_stime;
	private String s_endtime;
	
	
	/**
	 * 获取酒店列表,
	 * 跳转至酒店列表页面
	 */
	private List<Hotel> hotelListbeijzuid;
	private List<Hotel> hotelListshanghzuid;
	private List<Hotel> hotelListguangzzuid;
	private List<Hotel> hotelListwuhzuid;
	private List<Hotel> hotelListnanjzuid;
	
	
	private List<Hotel> hotelListbeijtuij;
	private List<Hotel> hotelListshanghtuij;
	private List<Hotel> hotelListguangztuij;
	private List<Hotel> hotelListwuhtuij;
	private List<Hotel> hotelListnanjtuij;
	
	
	private List<Hotel> hotelListtuijian;
	private List<Hotel> hotelListdijia;
	private List<Roomstate> listRoomstate;
	//酒店攻略
	private List<Infocontent> ListInfocontent;
	private List<Infocontent> ListInfocontentfuwu;
	
	private List <  Advertisement  >  listAdvertisement;
	
	
	//专门用来存放elong酒店的规则开始
	private List <  BookingRules  >  listBookingRules;//预订规则
	private List <  GuaranteeRule  > listGuaranteeRule;//担保规则
	private List <  PrepayRule  > listPrepayRule;//预付规则
	private List <  RatePlan  > listRatePlan;//价格政策
	private List <  NightlyRate  > listNightlyRate;//每日价格
	
	
	
	//专门用来存放elong酒店的规则结束
	//信用卡信息开始
	private String cardno;
	private String cardcvv;
	private int cardyear;
	private int cardmonth;
	private String cardname;
	private String idtype;
	private String idno;
	private String cardyhangname;//银行名字
	
	//信用卡信息结束
	
	
	 public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCardcvv() {
		return cardcvv;
	}
	public void setCardcvv(String cardcvv) {
		this.cardcvv = cardcvv;
	}
	public int getCardyear() {
		return cardyear;
	}
	public void setCardyear(int cardyear) {
		this.cardyear = cardyear;
	}
	public int getCardmonth() {
		return cardmonth;
	}
	public void setCardmonth(int cardmonth) {
		this.cardmonth = cardmonth;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getCardyhangname() {
		return cardyhangname;
	}
	public void setCardyhangname(String cardyhangname) {
		this.cardyhangname = cardyhangname;
	}
	public List<Chaininfo> getListchain(){
		 return this.listchain;
	 }
	 public void setListchain(List<Chaininfo> chs){
		 this.listchain=chs;
	 }
	
	public List<Advertisement> getListAdvertisement() {
		return listAdvertisement;
	}

	public void setListAdvertisement(List<Advertisement> listAdvertisement) {
		this.listAdvertisement = listAdvertisement;
	}
	
	
	//到店时间-2
	
	public String getDaoDianTime(String time){
		String ret="14:00";
		if(time!=null&&time.trim().length()>0){
			ret=(Integer.parseInt(time.split(":")[0].trim())-2)+":00";
		}
		
		
		return ret;
	}
			
			
			

	// 获取首日价
	public String getshouri(long rmid,String statetime) throws Exception{
		int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
		System.out.println("startmethod=="+startmethod);
		int s=	Integer.parseInt(startDate.substring(8,10));//开始天
		System.out.println("开始天ssss=="+s);
		int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
		System.out.println("结束月endDatemethod=="+endDatemethod);
		int f=	Integer.parseInt(endDate.substring(8,10));//结束天
		int d = f-1;
		System.out.println("结束天dddd=="+d);
		
		String snian=	startDate.substring(0,7);//开始yue
		String enian=	endDate.substring(0,7);//开始yue
		StringBuilder wher = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+rmid +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");
		
		ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wher.toString(), "", -1, 0);	
		
		String mnane = "getNo"+s;
		Class[] types = new Class[]{};
		Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
		
		Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
		Double price = ((Double)aa).doubleValue();
		int pp=	(int)Math.floor(price);
		//Double	pric = price;
		zongjia +=pp;
		String	asas =pp+"";
		System.out.println(asas);
		
		long hid = Server.getInstance().getHotelService().findRoomtype(rmid).getHotelid();
		if(Server.getInstance().getHotelService().findHotel(hid).getStar()!=null){
			
		int star = Server.getInstance().getHotelService().findHotel(hid).getStar();
		
			Double pr = gethotelstateprice(star);
			
			Double fprice = Long.parseLong(asas)*pr;
			
			Double pric = Long.parseLong(asas)-fprice;
			
			return pric+"";
		}
		
		
		return asas;
				
	}
	// 获取首日价,实际价格..没加返点得价格
	public String getshiji(long rmid,String statetime) throws Exception{
		int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
		System.out.println("startmethod=="+startmethod);
		int s=	Integer.parseInt(startDate.substring(8,10));//开始天
		System.out.println("开始天ssss=="+s);
		int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
		System.out.println("结束月endDatemethod=="+endDatemethod);
		int f=	Integer.parseInt(endDate.substring(8,10));//结束天
		int d = f-1;
		System.out.println("结束天dddd=="+d);
		
		String snian=	startDate.substring(0,7);//开始yue
		String enian=	endDate.substring(0,7);//开始yue
		StringBuilder wher = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+rmid +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");
		
		ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wher.toString(), "", -1, 0);	
		
		String mnane = "getNo"+s;
		Class[] types = new Class[]{};
		Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
		
		Object obj = method.invoke(ListHotelprice.get(0), new Object[0]);
		Double price = ((Double)obj).doubleValue();
		int pp=	(int)Math.floor(price);
		//Double	pric = price;
		zongjia +=pp;
		String	asas =pp+"";
		System.out.println(asas);
		
		
		
		
		return asas;
				
	}
	
	//判断房态
	public boolean isroomstate(long roomid,String statetime,String endtime){
		String where = "where 1=1 and "+Roomstate.COL_roomtypeid+" ="+roomid+" and ( '"+statetime+"' BETWEEN substring(convert(varchar,C_STARTDATE,23),1,10) AND substring(convert(varchar,C_ENDDATE,23),1,10))  and ( '"+endtime+"' BETWEEN substring(convert(varchar,C_STARTDATE,23),1,10) AND substring(convert(varchar,C_ENDDATE,23),1,10)) and "+Roomstate.COL_state+" =2";
		System.out.println("where=="+where);
		//Roomstate roomstate = new Roomstate();
		listRoomstate = Server.getInstance().getHotelService().findAllRoomstate(where, "", -1, 0)	;
		//Roomstate roomstate= listRoomstate.get(0);
	System.out.println("daxiao"+listRoomstate.size());
		//Roomtype roomtype = (Roomtype)Server.getInstance().getHotelService().findRoomtype(roomid);
		//int	roomstate = roomtype.getState();
		if(listRoomstate.size()>0 )
		{
			return false;
		}
		return true;
	}
	public String execute() throws Exception {
		
		//listAdvertisement=Server.getInstance().getSystemService().findAllAdvertisement(" where "+Advertisement.COL_type+"= 2 and "+Advertisement.COL_language+" = "+sessionlanguage(), " ORDER BY "+Advertisement.COL_sort, 1, 0);
		
		if(ActionContext.getContext().getSession().get("language")!=null)
		{
			String where1 ="where 1=1 and "+Infocontent.COL_typeid+" =3 ";
		
		ListInfocontent = Server.getInstance().getMemberService().findAllInfocontent(where1, "order by ID", 5, 0);
		//酒店优惠服务
		String where2 ="where 1=1 and "+Infocontent.COL_typeid+" =5 ";
		ListInfocontentfuwu = Server.getInstance().getMemberService().findAllInfocontent(where2, "order by ID", 2, 0);
		}else{
			ListInfocontent = Server.getInstance().getMemberService().findAllInfocontent("where 1=1 and "+Infocontent.COL_typeid+" =3", "order by ID", 5, 0);
			//酒店优惠服务
			ListInfocontentfuwu = Server.getInstance().getMemberService().findAllInfocontent("where 1=1 and "+Infocontent.COL_typeid+" =5", "order by ID", 2, 0);
			
			
		}
		if(ActionContext.getContext().getSession().get("language")!=null)
		{
		List<Infocontent> list=Server.getInstance().getMemberService().findAllInfocontent(" where 1=1 and "+Infocontent.COL_title+ " ='酒店导航' "  , "", -1, 0);
		if(list!=null && list.size()>0){
			hoteldaohang =list.get(0).getContent();
			}
		
		}else{
			List<Infocontent> list=Server.getInstance().getMemberService().findAllInfocontent(" where 1=1 and "+Infocontent.COL_title+ " ='酒店导航' "  , "", -1, 0);
			if(list!=null && list.size()>0){
				hoteldaohang =list.get(0).getContent();
				}
		}
		
		return SUCCESS;
	}
	public void gethotel() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		if(ActionContext.getContext().getSession().get("language")!=null)
		{
				if(ActionContext.getContext().getSession().get("language").equals(0)){
					cityId =cityId;
				}else{
			Integer lag =Integer.parseInt(ActionContext.getContext().getSession().get("language").toString());
			cityId = Server.getInstance().getHotelService().findCitybylanguage(cityId, lag).getId();
				}
		hotelListdijia = Server.getInstance().getHotelService().findAllHotel("where 1=1 and "+Hotel.COL_cityid+" ="+cityId+" and "+Hotel.COL_language+" ="+ActionContext.getContext().getSession().get("language").toString(), "order by C_STARTPRICE", 8, 0)	;
		hotelListtuijian =Server.getInstance().getHotelService().findAllHotel("where 1=1 and "+Hotel.COL_cityid+" ="+cityId+" and "+Hotel.COL_hot+" =1 and "+Hotel.COL_language+" ="+ActionContext.getContext().getSession().get("language").toString(), "order by C_STARTPRICE", 8, 0);
		}else{
			hotelListdijia = Server.getInstance().getHotelService().findAllHotel("where 1=1 and "+Hotel.COL_cityid+" ="+cityId+" and "+Hotel.COL_language+" =0", "order by C_STARTPRICE", 8, 0)	;
			hotelListtuijian =Server.getInstance().getHotelService().findAllHotel("where 1=1 and "+Hotel.COL_cityid+" ="+cityId+" and "+Hotel.COL_hot+" =1 and "+Hotel.COL_language+" =0", "order by C_STARTPRICE", 8, 0);
			
		}

		StringBuffer hd = new StringBuffer();
		StringBuffer ht = new StringBuffer();
		StringBuffer hthd = new StringBuffer();
		if(hotelListdijia.size()>0){
			/*for(int a=0;a<hotelListdijia.size();a++){
				
				
				
			}*/
		
			for (Hotel hoteldijia : hotelListdijia) {
				String temp = hoteldijia.getId() + "_" + hoteldijia.getName() +"_" +hoteldijia.getStartprice();
				if (hd.length() == 0) {
					hd.append(temp);
				} else {
					hd.append("," + temp);
				}
			}
		}
		
		if(hotelListtuijian.size()>0){
				for (Hotel hoteltuijian : hotelListtuijian) {
				String temp = hoteltuijian.getId() + "_" + hoteltuijian.getName() + "_" +hoteltuijian.getStartprice();
				if (ht.length() == 0) {
					ht.append(temp);
				} else {
					ht.append("," + temp);
				}
			}
		}
		if(hotelListtuijian.size()>0){
			hthd=ht.append("/" + hd);
		}else {
			hthd=hd;
		}
		if(hotelListdijia.size()>0){
			hthd=ht.append("/" + hd);
		}else {
			hthd=ht;
		}
		
		Writer writer = response.getWriter();
		writer.write(hthd.toString());
		//writer.write(ht.toString());
		System.out.println("酒店=="+hthd);
		//System.out.println("推荐酒店=="+ht);
		writer.flush();
		writer.close();
	}
	//获取中国的城市
	public String getCityAirPortData() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere="WHERE 1=1 ";
		if(ActionContext.getContext().getSession().get("language")!=null)
		{
			language=ActionContext.getContext().getSession().get("language").toString();
			if(language!=null && !language.equals(""))
			{
				strwhere+="and "+City.COL_language+" ="+language;
			}
			
		}
		else
		{
			strwhere+="and "+City.COL_language+" =0";
		}
		List<City> listAirport = Server.getInstance().getHotelService()
				.findAllCity(strwhere, "ORDER BY C_SORT", -1, 0);
		for (City airPort : listAirport) {
			sb.append(airPort.getName() + "#" + airPort.getEnname() + "%"
					+ airPort.getSname() + "&" + airPort.getId()
					+ ",");
		}
		// return strRetData;
		System.out.println("SB=="+sb);
		out.print(sb);
		out.flush();
		out.close();
		return SUCCESS;
	}
	/**
	 * 根据城市ID获取城市行政区
	 * @return
	 * @throws Exception
	 * Created by sunbin 
	 */
	public String getRegionByCityId() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		if(s_cityid==null || s_cityid.equals(""))
		{
			s_cityid="607";
		}
		String strwhere="WHERE 1=1 and "+Region.COL_cityid+" ="+s_cityid+" and "+Region. COL_id+" in ( SELECT "+Hotel.COL_regionid2+" FROM "+Hotel.TABLE+" where 1=1 )";
		List<Region> listregion = Server.getInstance().getHotelService().findAllRegion(strwhere, "ORDER BY ID", -1, 0);
		for (Region region : listregion) {
			sb.append(region.getName().replace("、", " ").replace(",", " ") + "#" + region.getId() + "%"
					+ region.getId() + "&" + region.getId()
					+ ",");
		}
		out.print(sb);
		System.out.println(sb.toString());
		out.flush();
		out.close();
		return SUCCESS;
	}
	//获取外国的城市
	public String geta() throws Exception {
		System.out.println("来到了查询外国城市的方法...");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		List<City> listAirport = Server.getInstance().getHotelService()
				.findAllCity("WHERE 1=1 and "+City.COL_countryid+" !=168", "", -1, 0);
		for (City airPort : listAirport) {
			sb.append(airPort.getName() + "#" + airPort.getEnname() + "%"
					+ airPort.getSname() + "&" + airPort.getId()
					+ ",");
		}
		// return strRetData;
		System.out.println("SB=="+sb);
		out.print(sb);
		out.flush();
		out.close();
		return SUCCESS;
	}
	
	/**
	 * 获得推荐酒店列表
	 */
	private void getCommandHotelList(long cityid){
		listhotelbj=Server.getInstance().getHotelService().findAllHotel("WHERE "+Hotel.COL_cityid+" ="+cityid, "ORDER BY ID DESC", 4, 0);
		//listhotelsh=Server.getInstance().getHotelService().findAllHotel("WHERE "+Hotel.COL_cityid+"=321", "ORDER BY ID DESC", 4, 0);
		//listhotelgz=Server.getInstance().getHotelService().findAllHotel("WHERE "+Hotel.COL_cityid+"=80", "ORDER BY ID DESC", 4, 0);
		//listhotelsz=Server.getInstance().getHotelService().findAllHotel("WHERE "+Hotel.COL_cityid+"=91", "ORDER BY ID DESC", 4, 0);
	}
	
	//详细信息页面
	public void findHotelRoomPriceInfo() {
		//星期信息开始
//周几信息
		
		SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd");        
        try {
			Date InDate1 =df.parse(s_stime.trim());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Date1=s_stime.trim();
        
        Calendar d11=new GregorianCalendar();
        Date   d1=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
        String baseDate=s_stime.trim() ;//入住日期
        try{ //一定要放到try里面,不然会报错的
            d1   =   sdf.parse(baseDate);  
         }
         catch(Exception e){
         }
         d11.setTime(d1);
         
         //第二天日期
         d11.add(Calendar.DAY_OF_MONTH, 1);
         Date2=df.format(d11.getTime()).toString();
         System.out.println(Date2);
         //第三天日期
         Calendar d22=new GregorianCalendar();
         Date   d2=null;
         try{ //一定要放到try里面,不然会报错的
             d2   =   sdf.parse(Date2);  
          }
          catch(Exception e){
          }
          d22.setTime(d2);
         d22.add(Calendar.DAY_OF_MONTH, 1);
         Date3=df.format(d22.getTime()).toString();
         //第四天日期
         Calendar d33=new GregorianCalendar();
         Date   d3=null;
         try{ //一定要放到try里面,不然会报错的
             d3   =   sdf.parse(Date3);  
          }
          catch(Exception e){
          }
         d33.setTime(d3);
         d33.add(Calendar.DAY_OF_MONTH, 1);
         Date4=df.format(d33.getTime()).toString();
         //第五天日期
         Calendar d44=new GregorianCalendar();
         Date   d4=null;
         try{ //一定要放到try里面,不然会报错的
             d4   =   sdf.parse(Date4);  
          }
          catch(Exception e){
          }
         d44.setTime(d4);
         d44.add(Calendar.DAY_OF_MONTH, 1);
         Date5=df.format(d44.getTime()).toString();
         //第六天日期
         Calendar d55=new GregorianCalendar();
         Date   d5=null;
         try{ //一定要放到try里面,不然会报错的
             d5   =   sdf.parse(Date5);  
          }
          catch(Exception e){
          }
         d55.setTime(d5);
         d55.add(Calendar.DAY_OF_MONTH, 1);
         Date6=df.format(d55.getTime()).toString();
         //第七天日期
         Calendar d66=new GregorianCalendar();
         Date   d6=null;
         try{ //一定要放到try里面,不然会报错的
             d6   =   sdf.parse(Date6);  
          }
          catch(Exception e){
          }
         d66.setTime(d6);
         d66.add(Calendar.DAY_OF_MONTH, 1);
         Date7=df.format(d66.getTime()).toString();
		//结束
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Hotel hot=new Hotel();
		hot=Server.getInstance().getHotelService().findHotel(Long.parseLong(s_hotelid));
		
		hot.setId(Long.parseLong(s_hotelid));
		hot.setHotelcode(s_hotelcode);
		
		SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hot, s_stime, s_endtime,"");
		
		
		
		/*if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();//返回房型
			List<BookingRules>ListBookingRules=seachHotelBean.getListBookingRules();//预订规则
			List<GuaranteeRule>ListGuaranteeRule=seachHotelBean.getListGuaranteeRule();//担保规则
			List<PrepayRule>ListPrepayRule=seachHotelBean.getListPrepayRule();//担保规则
			
			List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
			for(int a=0;a<listroom.size();a++){
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				//取价格
				//List<Object>listprice=listroom.get(a).getListPrice();
				List<RatePlan>listRoomRatePlan=listroom.get(a).getListRatePlan();
				
				String menshijia=(Double.parseDouble(listRoomRatePlan.get(0).getAverageRate())+50)+"";
				String shourijia=listRoomRatePlan.get(0).getAverageRate();
				
				String BED="";
				if(listroom.get(a).getBed()!=null){
					BED=listroom.get(a).getBed();
				}
				String Breakfast="不含早";
				if(listroom.get(a).getBreakfast()!=null){
					Breakfast=listroom.get(a).getBreakfast();
				}
				String Wideband="";
				if(listroom.get(a).getWideband()!=null){
					Wideband=listroom.get(a).getWideband();
				}
				String idstr="id="+s_hotelid+"_"+(a+1);
				if(a>=2){
				str.append("<tr style='display: none; ' "+idstr+" "+ret+" >");
				}else{
				str.append("<tr style='display: block; ' "+idstr+" "+ret+" >");	
				}
				str.append("<td class='box_r'>"+listroom.get(a).getName()+"</td>");
				str.append("<td class='box_r' style='text-decoration: line-through'>￥"+menshijia+"</td>");
				str.append("<td class='box_r'>￥"+shourijia+"</td>");
				str.append("<td class='box_r'>"+BED+"</td>");
				str.append("<td class='box_r'>"+Breakfast+"</td>");
				str.append("<td class='box_r'>"+Wideband+"</td>");
				System.out.println(listroom.get(a).getListRatePlan().get(0).getStatus());
				if(listroom.get(a).getListRatePlan().get(0).getStatus().equals("true")){
					str.append("<td class='box_r'><input type='button'  class='button_yuding' value='预订' onclick='yud("+listroom.get(a).getId()+","+hot.getId()+");'  /></td>");
				}else{
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='满房'  /></td>");
				}
				
				str.append("</tr>");
			}
			
			str.append("<tr>");
			str.append("<td align='right' id='"+s_hotelid+"_td1' colspan='7' style='height: 16px; line-height: 16px;'>");
			str.append("<span onclick='showrooom("+s_hotelid+","+listroom.size()+");' >展开房型▼</span>");
			str.append("</td>");
			str.append("<td align='right' id='"+s_hotelid+"_td2' colspan='7' style='height: 16px; line-height: 16px; display: none'>");
			str.append("<span onclick='hidrooom("+s_hotelid+","+listroom.size()+");' >收起房型▼</span>");
			str.append("</td>");
			str.append("</tr>");
			if(ListBookingRules!=null){
			str.append("<tr style='color: red'>");
			str.append("<td colspan='7' align='left'>");
			if(ListBookingRules!=null){
				str.append("预定须知:");
				for(int b=0;b<ListBookingRules.size();b++){
					str.append(ListBookingRules.get(b).getDescription()+"</br>");
				}
				
			}
			str.append("</td>");
			str.append("</tr>");
			}
			if(ListGuaranteeRule!=null){
			str.append("<tr style='color: red'>");
			str.append("<td colspan='7' align='left'>");
			if(ListGuaranteeRule!=null){
				str.append("");
				for(int b=0;b<ListGuaranteeRule.size();b++){
					str.append(ListGuaranteeRule.get(b).getDescription()+"</br>");
				}
				
			}
			
			str.append("</td>");
			str.append("</tr>");
			}
		}*/
		
		
		if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();//返回房型
			List<BookingRules>ListBookingRules=seachHotelBean.getListBookingRules();//预订规则
			List<GuaranteeRule>ListGuaranteeRule=seachHotelBean.getListGuaranteeRule();//担保规则
			List<PrepayRule>ListPrepayRule=seachHotelBean.getListPrepayRule();//担保规则
			
			List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
			
			for(int a=0;a<listroom.size();a++){
				
				List<Roomtype>listRoom=Server.getInstance().getHotelService().findAllRoomtype(" WHERE 1=1 AND "+Roomtype.COL_hotelid+" ="+s_hotelid+" AND "+Roomtype.COL_roomcode+" ='"+listroom.get(a).getRoomcode()+"'", " ORDER BY ID DESC ", -1, 0);
				if(listRoom.size()>0){
					listroom.get(a).setId(listRoom.get(0).getId());
					listroom.get(a).setBed(listRoom.get(0).getBed());
					if(listRoom.get(0).getBreakfast()==null){
					listroom.get(a).setBreakfast("不含早");	
					}else{
					listroom.get(a).setBreakfast(listRoom.get(0).getBreakfast());
					}
					if(listRoom.get(0).getWideband()==null){
					listroom.get(a).setWideband("无宽带");
					}else{
					listroom.get(a).setWideband(listRoom.get(0).getWideband());	
					}
				}
				
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				
				//取价格
				List<RatePlan>listRoomRatePlan=listroom.get(a).getListRatePlan();
				
				String menshijia=(Double.parseDouble(listRoomRatePlan.get(0).getAverageRate())+50)+"";
				String shourijia=listRoomRatePlan.get(0).getAverageRate();
				List<NightlyRate>listNightlyRate =listRoomRatePlan.get(0).getListNightlyRate();//价格数组
				
				
				
				
				int aa=1;
				StringBuffer strPriceTxt = new StringBuffer();
				strPriceTxt.append("<div style='position: relative;'>");
				strPriceTxt.append("<div id='ccc"+a+"' style='border: 2px solid #ff6600; position: absolute; background: #fff; right:3px; top:-10px;display: none;'>");
				strPriceTxt.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' style='line-height: 22px; border: 1px solid #fff' >");
				strPriceTxt.append("<tr bgcolor='#fbdcc9'><td ><div style='width: 40px;'></div></td><td><div style='width: 40px;'>"+getWeekStr(startDate)+"</div></td><td><div style='width: 40px;'>"+getWeekStr(Date2)+"</div></td><td><div style='width: 40px;'>"+getWeekStr(Date3)+"</div></td><td><div style='width: 40px;'>"+getWeekStr(Date4)+"</div></td><td><div style='width: 40px;'>"+getWeekStr(Date5)+"</div></td><td><div style='width: 40px;'>"+getWeekStr(Date6)+"</div></td><td><div style='width: 40px;'>"+getWeekStr(Date7)+"</div></td></tr>");
				strPriceTxt.append("<tr><td>第"+aa+"周</td>");
				//listprtxt=listroom.get(a).getListPrice();//直接从房型对应的价格取   
				if(listNightlyRate!=null&&listNightlyRate.size()>0){
					for(int p=0;p<listNightlyRate.size();p++){
						String dprice=listNightlyRate.get(p).getDate().substring(5, 10)+"</br>"+listNightlyRate.get(p).getMember();
						
						strPriceTxt.append("<td class='huang_12'>"+dprice+"</td>");
						if(p!=0&&(p+1)%7==0){
							aa++;
							strPriceTxt.append("</tr>");
							strPriceTxt.append("<tr><td colspan='7' class='xuxian_x'></td></tr>");
							strPriceTxt.append("<tr>");
							strPriceTxt.append("<td>第"+aa+"周</td>");
						}
						
					}
				}
				strPriceTxt.append("</tr></table></div></div>"); 
				
				str.append("<tr "+ret+">");
				str.append("<td class='box_r'>"+listroom.get(a).getName()+"</td>");
				str.append("<td class='box_r' style='text-decoration: line-through'>￥"+menshijia+"</td>");
				str.append("<td class='box_r'>￥"+shourijia+"</td>");
				str.append("<td class='box_r'><a href='#' onmouseover='xianshi("+a+");' onmouseout='yingcang("+a+");'>￥"+shourijia+"</a>");
				str.append(strPriceTxt.toString());
				str.append("</td>");
				
				str.append("<td class='box_r'>"+listroom.get(a).getBed()+"</td>");
				str.append("<td class='box_r'>"+listroom.get(a).getBreakfast()+"</td>");
				str.append("<td class='box_r'>"+listroom.get(a).getWideband()+"</td>");
				//boolean valadataroom=ValadateRoomBackState(seachHotelBean.getListRoomstateback(), s_stime, s_endtime, listroom.get(a));
				
				if(listroom.get(a).getListRatePlan().get(0).getStatus().equals("true")){
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='预订' onclick='yud("+listroom.get(a).getId()+","+s_hotelid+","+hot.getCityid()+");'  /></td>");
				}else{
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='满房'  /></td>");
				}
				
				str.append("</tr>");
				
			}
			if(ListBookingRules!=null){
				str.append("<tr style='color: red'>");
				str.append("<td colspan='7' align='left'>");
				if(ListBookingRules!=null){
					str.append("预定须知:");
					for(int b=0;b<ListBookingRules.size();b++){
						str.append(ListBookingRules.get(b).getDescription()+"</br>");
					}
					
				}
				str.append("</td>");
				str.append("</tr>");
				}
				if(ListGuaranteeRule!=null){
				str.append("<tr style='color: red'>");
				str.append("<td colspan='7' align='left'>");
				if(ListGuaranteeRule!=null){
					str.append("");
					for(int b=0;b<ListGuaranteeRule.size();b++){
						str.append(ListGuaranteeRule.get(b).getDescription()+"</br>");
					}
					
				}
				
				str.append("</td>");
				str.append("</tr>");
				}
		}
		
		
		
		
		System.out.println(str.toString());
		
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
	//验证信用卡号
	public void valadateElongHotelCardNO() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String sub="-1";
		
		sub=Server.getInstance().getHotelInterService().validateCreditcard(cardno.trim());
		
		
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(sub.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//验证elong酒店是否可以预定
	public void valadateElongHotelIsBook() {
		
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		//Hotel hot=new Hotel();
		//hot=Server.getInstance().getHotelService().findHotel(Long.parseLong(s_hotelid));
		//roomtype=Server.getInstance().getHotelService().findRoomtype(roomid);
		Hotelorder hotelorder=new Hotelorder();
		
		hotelorder.setHotelid(Long.parseLong(s_hotelid));
		hotelorder.setRoomid(roomid);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date time = df.parse(startDate);
			Date time2 = df.parse(endDate);
			hotelorder.setComedate((new Timestamp(time.getTime())));
			hotelorder.setLeavedate((new Timestamp(time2.getTime())));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(NumberOfRooms);
		hotelorder.setReservstart(EarliestArrivalTime);
		hotelorder.setReservend(LatestArrivalTime);
		hotelorder.setPricecodeid(pricecode);
		hotelorder.setPrerooms(NumberOfRooms);
		hotelorder.setPrice(s_price);
		List<Guest>ListGuest=new ArrayList<Guest>();
		String sub=	Server.getInstance().getHotelInterService().validateHotelIsBook(hotelorder, ListGuest);
		System.out.println("sub:"+sub);
		
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(sub.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findHotelRoomPrice_ELONG() {
		String hotelZrateValue="5";
		
		
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Hotel hot=new Hotel();
		hot=Server.getInstance().getHotelService().findHotel(Long.parseLong(s_hotelid));
		
		hot.setId(Long.parseLong(s_hotelid));
		hot.setHotelcode(s_hotelcode);
		SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hot, s_stime, s_endtime,"");
		
		/*String mnane = "getNo"+a;
		Class[] types = new Class[]{};
		Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
		Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
		Double price = ((Double)aa).doubleValue();
		int pp=	(int)Math.floor(price);*/
		
		if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();//返回房型
			List<BookingRules>ListBookingRules=seachHotelBean.getListBookingRules();//预订规则
			List<GuaranteeRule>ListGuaranteeRule=seachHotelBean.getListGuaranteeRule();//担保规则
			List<PrepayRule>ListPrepayRule=seachHotelBean.getListPrepayRule();//担保规则
			
			//List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
			for(int a=0;a<listroom.size();a++){
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				
				Float roomZrateValue=0f;//初始化房型利润
				
				//取价格
				//List<Object>listprice=listroom.get(a).getListPrice();
				List<RatePlan>listRoomRatePlan=listroom.get(a).getListRatePlan();
				
				String menshijia=(Double.parseDouble(listRoomRatePlan.get(0).getAverageRate())+50)+"";
				String shourijia=listRoomRatePlan.get(0).getAverageRate();
				
				String BED="";
				if(listroom.get(a).getBed()!=null){
					BED=listroom.get(a).getBed();
				}
				String Breakfast="不含早";
				if(listroom.get(a).getBreakfast()!=null){
					Breakfast=listroom.get(a).getBreakfast();
				}
				String Wideband="";
				if(listroom.get(a).getWideband()!=null){
					Wideband=listroom.get(a).getWideband();
				}
				String idstr="id="+s_hotelid+"_"+(a+1);
				if(a>=2){
				str.append("<tr style='display: none; ' "+idstr+" "+ret+" >");
				}else{
				str.append("<tr style='display: block; ' "+idstr+" "+ret+" >");	
				}
				str.append("<td class='box_r'>"+listroom.get(a).getName()+"</td>");
				str.append("<td class='box_r' style='text-decoration: line-through'>￥"+menshijia+"</td>");
				str.append("<td class='box_r'>￥"+shourijia+"</td>");
				Float AllroomZrateValue=Float.parseFloat(shourijia)*Float.parseFloat(hotelZrateValue)/100;
				try
				 {
					 
					 roomZrateValue= Getliudianvalue_hotel(AllroomZrateValue);
				 }
				 catch(Exception ex)
				 {
					 roomZrateValue=0f;
				 }
				 str.append("<td class='box_r'>￥"+roomZrateValue+"</td>");
				//str.append("<td class='box_r'>￥"+Float.parseFloat(shourijia)*Float.parseFloat(hotelZrateValue)/100+"</td>");
				str.append("<td class='box_r'>"+BED+"</td>");
				str.append("<td class='box_r'>"+Breakfast+"</td>");
				str.append("<td class='box_r'>"+Wideband+"</td>");
				System.out.println(listroom.get(a).getListRatePlan().get(0).getStatus());
				if(listroom.get(a).getListRatePlan().get(0).getStatus().equals("true")){
					str.append("<td class='box_r'><input type='button'  class='button_yuding' value='预订' onclick='yud("+listroom.get(a).getId()+","+hot.getId()+");'  /></td>");
				}else{
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='满房'  /></td>");
				}
				
				str.append("</tr>");
			}
			
			str.append("<tr>");
			str.append("<td align='right' id='"+s_hotelid+"_td1' colspan='7' style='height: 16px; line-height: 16px;'>");
			str.append("<span onclick='showrooom("+s_hotelid+","+listroom.size()+");' >展开房型▼</span>");
			str.append("</td>");
			str.append("<td align='right' id='"+s_hotelid+"_td2' colspan='7' style='height: 16px; line-height: 16px; display: none'>");
			str.append("<span onclick='hidrooom("+s_hotelid+","+listroom.size()+");' >收起房型▼</span>");
			str.append("</td>");
			str.append("</tr>");
			if(ListBookingRules!=null){
			str.append("<tr style='color: red'>");
			str.append("<td colspan='7' align='left'>");
			if(ListBookingRules!=null){
				str.append("预定须知:");
				for(int b=0;b<ListBookingRules.size();b++){
					str.append(ListBookingRules.get(b).getDescription()+"</br>");
					break;
				}
				
			}
			str.append("</td>");
			str.append("</tr>");
			}
			if(ListGuaranteeRule!=null){
			str.append("<tr style='color: red'>");
			str.append("<td colspan='7' align='left'>");
			if(ListGuaranteeRule!=null){
				str.append("");
				for(int b=0;b<ListGuaranteeRule.size();b++){
					str.append(ListGuaranteeRule.get(b).getDescription()+"</br>");
					break;
				}
				
			}
			
			str.append("</td>");
			str.append("</tr>");
			}
		}
		
		
		
		
		
		System.out.println(str.toString());
		
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
	//列表页面
	public void findHotelRoomPrice_ELONG_old() {
		String hotelZrateValue="5";
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Hotel hot=new Hotel();
		hot=Server.getInstance().getHotelService().findHotel(Long.parseLong(s_hotelid));
		
		hot.setId(Long.parseLong(s_hotelid));
		hot.setHotelcode(s_hotelcode);
		SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hot, s_stime, s_endtime,"");
		
		
		
		/*String mnane = "getNo"+a;
		Class[] types = new Class[]{};
		Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
		Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
		Double price = ((Double)aa).doubleValue();
		int pp=	(int)Math.floor(price);*/
		
		if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();//返回房型
			List<BookingRules>ListBookingRules=seachHotelBean.getListBookingRules();//预订规则
			List<GuaranteeRule>ListGuaranteeRule=seachHotelBean.getListGuaranteeRule();//担保规则
			List<PrepayRule>ListPrepayRule=seachHotelBean.getListPrepayRule();//担保规则
			
			//List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
			for(int a=0;a<listroom.size();a++){
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				//取价格
				//List<Object>listprice=listroom.get(a).getListPrice();
				List<RatePlan>listRoomRatePlan=listroom.get(a).getListRatePlan();
				
				String menshijia=(Double.parseDouble(listRoomRatePlan.get(0).getAverageRate())+50)+"";
				String shourijia=listRoomRatePlan.get(0).getAverageRate();
				
				String BED="";
				if(listroom.get(a).getBed()!=null){
					BED=listroom.get(a).getBed();
				}
				String Breakfast="不含早";
				if(listroom.get(a).getBreakfast()!=null){
					Breakfast=listroom.get(a).getBreakfast();
				}
				String Wideband="";
				if(listroom.get(a).getWideband()!=null){
					Wideband=listroom.get(a).getWideband();
				}
				String idstr="id="+s_hotelid+"_"+(a+1);
				if(a>=2){
				str.append("<tr style='display: none; ' "+idstr+" "+ret+" >");
				}else{
				str.append("<tr style='display: block; ' "+idstr+" "+ret+" >");	
				}
				str.append("<td class='box_r'>"+listroom.get(a).getName()+"</td>");
				str.append("<td class='box_r' style='text-decoration: line-through'>￥"+menshijia+"</td>");
				str.append("<td class='box_r'>￥"+shourijia+"</td>");
				str.append("<td class='box_r'>"+BED+"</td>");
				str.append("<td class='box_r'>"+Breakfast+"</td>");
				str.append("<td class='box_r'>"+Wideband+"</td>");
				System.out.println(listroom.get(a).getListRatePlan().get(0).getStatus());
				if(listroom.get(a).getListRatePlan().get(0).getStatus().equals("true")){
					str.append("<td class='box_r'><input type='button'  class='button_yuding' value='预订' onclick='yud("+listroom.get(a).getId()+","+hot.getId()+");'  /></td>");
				}else{
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='满房'  /></td>");
				}
				
				str.append("</tr>");
			}
			
			str.append("<tr>");
			str.append("<td align='right' id='"+s_hotelid+"_td1' colspan='7' style='height: 16px; line-height: 16px;'>");
			str.append("<a><span style='cursor:pointer;' onclick='showrooom("+s_hotelid+","+listroom.size()+");' >展开房型▼</span></a>");
			str.append("</td>");
			str.append("<td align='right' id='"+s_hotelid+"_td2' colspan='7' style='height: 16px; line-height: 16px; display: none'>");
			str.append("<a><span style='cursor:pointer;' onclick='hidrooom("+s_hotelid+","+listroom.size()+");' >收起房型▼</span></a>");
			str.append("</td>");
			str.append("</tr>");
			if(ListBookingRules!=null){
			str.append("<tr style='color: red'>");
			str.append("<td colspan='7' align='left'>");
			if(ListBookingRules!=null){
				str.append("预定须知:");
				for(int b=0;b<ListBookingRules.size();b++){
					str.append(ListBookingRules.get(b).getDescription()+"</br>");
					break;
				}
				
			}
			str.append("</td>");
			str.append("</tr>");
			}
			if(ListGuaranteeRule!=null){
			str.append("<tr style='color: red'>");
			str.append("<td colspan='7' align='left'>");
			if(ListGuaranteeRule!=null){
				str.append("");
				for(int b=0;b<ListGuaranteeRule.size();b++){
					str.append(ListGuaranteeRule.get(b).getDescription()+"</br>");
					break;
				}
				
			}
			
			str.append("</td>");
			str.append("</tr>");
			}
		}
		
		
		
		
		
		System.out.println(str.toString());
		
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
	//列表页面
	public void findHotelRoomPrice() {
		
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Hotel hot=new Hotel();
		hot=Server.getInstance().getHotelService().findHotel(Long.parseLong(s_hotelid));
		
		//hot.setId(Long.parseLong(s_hotelid));
		//hot.setHotelcode(s_hotelcode);
		SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hot, s_stime, s_endtime,"");
		
		/*String mnane = "getNo"+a;
		Class[] types = new Class[]{};
		Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
		Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
		Double price = ((Double)aa).doubleValue();
		int pp=	(int)Math.floor(price);*/
		
		if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();
			List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
			for(int a=0;a<listroom.size();a++){
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				//取价格
				List list=	GetRoomPriceBy(listroomprice, s_stime, s_endtime, listroom.get(a));
				List listpr=(List) list.get(0);//价格list
				List listprtxt=(List) list.get(1);//价格描述list
				String menshijia="";
				String shourijia="";
				if(listpr!=null&&listpr.size()>0){
					menshijia=listpr.get(0).toString();
				}
				if(listpr!=null&&listpr.size()>0){
					shourijia=listpr.get(1).toString();
				}
				
				str.append("<tr "+ret+">");
				str.append("<td class='box_r'>"+listroom.get(a).getName()+"</td>");
				str.append("<td class='box_r' style='text-decoration: line-through'>￥"+menshijia+"</td>");
				str.append("<td class='box_r'>￥"+shourijia+"</td>");
				str.append("<td class='box_r'>"+listroom.get(a).getBed()+"</td>");
				str.append("<td class='box_r'>"+listroom.get(a).getBreakfast()+"</td>");
				str.append("<td class='box_r'>"+listroom.get(a).getWideband()+"</td>");
				boolean valadataroom=ValadateRoomBackState(seachHotelBean.getListRoomstateback(), s_stime, s_endtime, listroom.get(a));
				if(valadataroom){
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='预订' onclick='yud("+listroom.get(a).getId()+","+hot.getId()+");'  /></td>");
				}else{
					str.append("<td class='box_r'><input type='button' class='button_yuding' value='满房'  /></td>");
				}
				
				str.append("</tr>");
			}
			
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
	//获取价格
	public List GetRoomPriceBy(List<Hotelprice>listroomprice,String stime,String endtime,Roomtype roomtype){
		List list=new ArrayList();
		List listprice=new ArrayList();
		List listpricetxt=new ArrayList();
		
		
		boolean ret=true;
		List<Hotelprice>listHotelprice=new ArrayList<Hotelprice>();
		
		if(listroomprice!=null&&listroomprice.size()>0){
			for(int a=0;a<listroomprice.size();a++){
				if(listroomprice.get(a).getRoomid()==roomtype.getId()){
					listHotelprice.add(listroomprice.get(a));
				}
			}
		}else{
			ret=false;
		}
		if(listHotelprice!=null&&listHotelprice.size()>0){
			int s_num=GetOneTwoTimeNum(stime, endtime);
			for(int a=0;a<s_num;a++){
				String newtime=	getdaybyNum(stime, a);
				String nianyue=newtime.substring(0, 7);
				String ri=newtime.substring(8, 10);
				int	yue = Integer.parseInt(newtime.trim().substring(5,7));//月份
				if(ri.substring(0,1).equals("0")){
					ri=ri.substring(1);
				}
				for(int r=0;r<listHotelprice.size();r++){
					if(listHotelprice.get(r).getDatenumber().equals(nianyue.trim())&&listHotelprice.get(r).getRoomid()==roomtype.getId()){
						
						//反射取值 剩下房间数
						//String mnane = "getBack"+ri;
						String mnane = "getNo"+ri;
						Class[] types = new Class[]{};
						Method method = null;
						try {
							method = listHotelprice.get(r).getClass().getMethod(mnane, types);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						Object aa = null;
						try {
							aa = method.invoke(listHotelprice.get(r), new Object[0]);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						System.out.println("aa:"+aa.toString());
						Double price=Double.parseDouble(aa.toString().trim());
						listprice.add(listHotelprice.get(r).getDeptprice());
						listprice.add(price);
						
						
						//String	asas =yue+"/"+ri+":<font class='font14'></font>"+price;
						String	asas ="<font class='font14'>"+price+"</font>";
						System.out.println(asas);
						listpricetxt.add(asas);
					}
					
				}
				
				
				
			}
			list.add(listprice);
			list.add(listpricetxt);
			
		}else{
			ret=false;
		}
		
		
		
		
		
		return list;
	}
	//判断房态
	public boolean ValadateRoomBackState(List<Roomstateback>listRoomstateback,String stime,String endtime,Roomtype roomtype){
		boolean ret=true;
		List<Roomstateback>listRoomstate=new ArrayList<Roomstateback>();
		
		if(listRoomstateback!=null&&listRoomstateback.size()>0){
			for(int a=0;a<listRoomstateback.size();a++){
				if(listRoomstateback.get(a).getRoomid()==roomtype.getId()){
					listRoomstate.add(listRoomstateback.get(a));
				}
			}
		}else{
			ret=false;
		}
		if(listRoomstate!=null&&listRoomstate.size()>0){
			int s_num=GetOneTwoTimeNum(stime, endtime);
			for(int a=0;a<s_num;a++){
				String newtime=	getdaybyNum(stime, a);
				String nianyue=newtime.substring(0, 7);
				String ri=newtime.substring(8, 10);
				if(ri.substring(0,1).equals("0")){
					ri=ri.substring(1);
				}
				for(int r=0;r<listRoomstate.size();r++){
					if(listRoomstate.get(r).getDatenumber().equals(nianyue.trim())){
						
						//反射取值 剩下房间数
						//String mnane = "getBack"+ri;
						String mnane = "getNo"+ri;
						Class[] types = new Class[]{};
						Method method = null;
						try {
							method = listRoomstate.get(r).getClass().getMethod(mnane, types);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						Object aa = null;
						try {
							aa = method.invoke(listRoomstate.get(r), new Object[0]);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
						int sum=Integer.parseInt(aa.toString().trim());
						
						if(sum>=0){
							ret=true;
						}else{
							ret=false;
							break;
						}
						
					}
					
				}
				
				
				
			}
			
		}else{
			ret=false;
		}
		
		
		
		
		
		return ret;
	}
	
	 public String getdaybyNum(String startDate,int days){
    	 String Date2="";
    	 Calendar d11=new GregorianCalendar();
         Date   d1=null;
         SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
         String baseDate=startDate.trim() ;//入住日期
         try{ //一定要放到try里面,不然会报错的
             d1   =   sdf.parse(baseDate);  
          }
          catch(Exception e){
          }
          d11.setTime(d1);
          
    	 d11.add(Calendar.DAY_OF_MONTH, days);
         Date2=df.format(d11.getTime()).toString();
    	 
    	 return Date2;
    	 
     }
	 
	 public int GetOneTwoTimeNum(String stime,String endtime){
		 
		 	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date time = null;
			try {
				time = df.parse(stime);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Date time2 = null;
			try {
				time2 = df.parse(endtime);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int manyday = (int) ((time2.getTime()-time.getTime())/(24*3600*1000));
			
			return manyday;
	 }
	 
	/**
	 * 搜索酒店  中国的
	 * @return
	 * @throws Exception
	 */
	public String sousuo() throws Exception {
		//listCampaign = Server.getInstance().getMemberService().findAllCampaign("", " ORDER BY C_ONLINE", 3, 0);
		//获得用户搜索信息
		if(s_hotelName!=null&&s_hotelName.length()>0){
    		String expr = new String(s_hotelName.getBytes("ISO-8859-1"),"UTF-8");
    		System.out.println("expr=="+expr);
    		s_hotelName=expr;
    		hotelName=s_hotelName;
    	}
		
		String ucityname="";
		if(cityId!=null)
		{
			City city = Server.getInstance().getHotelService().findCity(cityId);
			
			
		ucityname=city.getName();
		s_citycode=city.getCarcode();
		}
		
		
		String uhotelName=getHotelName();
		String upricearea=s_price;

		searchInfo=new StringBuffer("");
		if(ucityname!=null&&!ucityname.equals(""))
		{
			searchInfo.append(ucityname);
		}
		if(uhotelName!=null&&!uhotelName.equals("")){
			searchInfo.append(" + "+uhotelName);
		}
		if(regionid!=null&&!regionid.equals("")){
			searchInfo.append(" + "+ getRegionNameByStr(regionid));
		}
		if(s_price!=null&&!"".equals(s_price))
		{
			searchInfo.append(" + "+upricearea);
		}
		//推荐酒店信息
	//	getCommandHotelList(cityId);
		StringBuilder where = new StringBuilder(" where C_STATE=3  AND C_TYPE=1 ");
		
	//	listchain=Server.getInstance().getHotelService().findAllChaininfo("WHERE 1=1", " ORDER BY C_SORT ", 3, 0);

		// 酒店名称
		
		
		if (null != hotelName && !"".equals(hotelName.trim())) {
			where.append(" and C_NAME like '%");
			where.append(hotelName.trim());
			where.append("%' ");
		}
/*if(cityId==null){
	
	cityId=80l;	
}*/
		// 酒店所在城市
		if( cityId != null && cityId > 0) {
			where.append(" and C_CITYID =").append(cityId);
		}
		
		// 星级
		if (s_hotelstar!=null&&!s_hotelstar.equals("0")) {
			
				where.append(" and C_STAR =").append(s_hotelstar);;
				
			
		}
		// 装修
		if (null != s_repair && s_repair.length > 0) {
			String s = StringUtils.join(s_repair, ',');
			if (s != null && !"".equals(s.trim())) {
				where.append("and C_REPAIR in(");
				where.append(s);
				where.append(") ");
			}
		}
		//按照品牌酒店ID查询
		if(bradnhotelid!=null && !bradnhotelid.equals(""))
		{
			where.append("and C_CHAININFOID="+bradnhotelid);
		}

		// 区域
//		if (null != regiontype && !"".equals(regiontype)) {
//			if (null != regionvalue && !"".equals(regionvalue.trim()) && !regionvalue.equals("--请选择--")) {
//				if (regiontype.equals("0")) {
//					where.append(" and C_REGIONID2 =").append(regionvalue);
//				} else if (regiontype.equals("1")) {
//					where.append(" and C_REGIONID1 =").append(regionvalue);
//				} else if (regiontype.equals("2")) {
//					where.append(" and C_REGIONID3 =").append(regionvalue);
//				}
//			}
//		}
		
		//按照区域进行查询
		if(regionid!=null && !regionid.equals(""))
		{
			where.append(" and (C_REGIONID1 ="+regionid+" or C_REGIONID2 ="+regionid+" or C_REGIONID3 ="+regionid+")");
		}
		
/*
		// 地标
		if(landmarkId != 0){
			where.append("  and ID in (select C_HOTELID from b2b2c.T_HOTELLANDMARK where C_LANDMARKID = ").append(landmarkId);
			if(null != range && !range.equals("0") && !range.trim().equals("")){
				where.append("  and C_RANGE = ").append(range).append(" )");
			}else{
				where.append(" )");
			}
		}
*/
		//按照价格进行查询
		if(s_price!=null && !s_price.equals("不限"))
		{
			//RMB 250以下
			if(s_price.equals("RMB 250以下"))
			{
				where.append(" and C_STARTPRICE<250");
			}
			//RMB 250-400
			else if(s_price.equals("RMB 250-400"))
			{
				where.append(" and C_STARTPRICE>250 and C_STARTPRICE<400 ");
			}
			//RMB 400-600
			else if(s_price.equals("RMB 400-600"))
			{
				where.append(" and C_STARTPRICE>400  and C_STARTPRICE<600 ");
			}
			//RMB 600-800
			else if(s_price.equals("RMB 600-800"))
			{
				where.append(" and C_STARTPRICE>600 and C_STARTPRICE<800 ");
			}
			//RMB 800以上
			else if(s_price.equals("RMB 800以上"))
			{
				where.append(" and C_STARTPRICE>800");
			}
			
		}
		s_num = dateDiff(endDate.trim(), startDate.trim());
		// 价格 p[0]最低价格  p[1]最高价格
	/*	String[] p = null;
		if(priceType != -1) {
			p = getPrice(priceType).split("\\-");
		}*/
		// 入住日期
		/*if (null != startDate && !"".equals(startDate.trim())
				&& null != endDate && !"".equals(endDate.trim())) {
			
			
			s_num = dateDiff(endDate.trim(), startDate.trim());
			System.out.println("s_num=="+s_num);
			
			where.append("  and ID in (select C_HOTELID from "+Hotelprice.TABLE+" where C_DATENUMBER ='");
			where.append(startDate.trim().substring(0, 7));
			where.append("' and C_NO");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(" >= 1");
			//where.append(p[0]);
			where.append(" and C_NO");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(" <= 100000");
			
			
			
			//where.append(p[1]);

		
			//where.append(" and charindex('1',substring(C_ISVALID,");
			//where.append(Integer.parseInt(startDate.substring(8, 10)));
			//where.append(",").append(s_num).append(")) = 0");

			// where.append(" and INSTR(SUBSTR(C_ISVALID,");
			// where.append(Integer.parseInt(s_startdate.substring(8,10)));
			// where.append(",");
			// where.append(s_num).append("),'1') != 0");

			// substring(convert(varchar,C_STARTDATE,23),1,10) > '2009-09-02'

					//where.append(" and C_ROOMID not in " +
					//				"( select C_ROOMTYPEID from "+Roomstate.TABLE+" " +
					//					"where C_STATE = 2 and substring(convert(varchar,C_STARTDATE,23),1,10)<= '");
					//where.append(startDate);
					//where.append("' or substring(convert(varchar,C_ENDDATE,23),1,10) >= '");
					//where.append(endDate);
						where.append(")");
		//	where.append(" and C_ROOMID in (select ID from "+Roomtype.TABLE+" where C_STATE=1))");
			
			// SQL语句
			where C_STATE=3  and C_CITYID =607  
			 	and ID in 
			 (select C_HOTELID from b2b2c.T_HOTELPRICE 
				 where C_DATENUMBER ='2010-01' 
					and C_NO12 >= 0 and C_NO12 <= 1000000 
						and charindex('1',substring(C_ISVALID,12,1)) = 0 
							and C_ROOMID not in 
							(select C_ROOMTYPEID from b2b2c.T_ROOMSTATE 
								where C_STATE = 2 
									and substring(convert(varchar,C_STARTDATE,23),1,10)<= '2010-01-12' 
										or substring(convert(varchar,C_ENDDATE,23),1,10) >= '2010-01-13') 
								and C_ROOMID in (select ID from b2b2c.T_ROOMTYPE where C_STATE=1) )
			
		}*/
		
		// 排序
		String orderStr = "ORDER BY C_STAR";
		
		if (orderType == 1) {
			if (orderMode != 2) {
				orderStr = "order by C_STARTPRICE";
			} else {
				orderStr = "order by C_STARTPRICE DESC";
			}
		} else if (orderType == 2) {
			if (orderMode != 2) {
				orderStr = "order by C_STAR";
			} else {
				orderStr = "order by C_STAR DESC";
			}
		}
		//where.append(" AND "+Hotel.COL_id+" in ( SELECT "+Roomtype.COL_hotelid+" FROM "+Roomtype.TABLE+")");
		//where.append(" AND "+Hotel.COL_id+" in ( SELECT "+Hotelimage.COL_hotelid+" FROM "+Hotelimage.TABLE+")");
		System.out.println("where==="+where.toString()+",orderStr:"+orderStr);
		pageinfo.setPagerow(5);
		
		List list = Server.getInstance().getHotelService()
			.findAllHotelForPageinfo(where.toString(), orderStr, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		hotelList = list;
		
		if(pageinfo.getTotalrow()>0 &&   hotelList.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelForPageinfo(where.toString()," ORDER BY C_HOT ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			hotelList = list;
		}
		String snian=	startDate.substring(0,7);//开始yue
		String enian=	endDate.substring(0,7);//开始yue
		
		
		System.out.println("hotelsize:"+hotelList.size());
		
		/*for(Hotel h : hotelList){
			List<Roomtype> listR= new ArrayList<Roomtype>();
			
			
			String response=GetZhuNaHotelRoomPriceByHotelcode(h.getHotelcode(), startDate, endDate);
			
			
			if(response.indexOf("zid")!=-1&&response.indexOf("rid")!=-1&&response.indexOf("day")!=-1&&response.indexOf("price")!=-1&&response.indexOf("title")!=-1){
				
				
				response=response.replace("锘縱ar _Data=", "");
				response=response.replace(";if(callback){callback(_Data)}else{alert('Err:callback')}", "");
				JSONArray jsonObject = new JSONArray(response); 
				JSONObject josnobj = (JSONObject) jsonObject.get(0);
				String hid=josnobj.getString("zid");//酒店ID
			    String stime=josnobj.getString("tm1");//入住时间
			    String etime=josnobj.getString("tm2"); //离店时间  
			    String state=josnobj.getString("status"); //酒店状态  0是正常
			    String[] stingroom = response.split("\"rooms\":");
			    //解析房型
			    String josnroom=stingroom[1];
				    josnroom=josnroom.replace("}%", "");
			    JSONArray jsonObjectroom = new JSONArray(josnroom); 
			    
			    //初始化房型list
			    	
				    for(int a=0;a<jsonObjectroom.length();a++){
					    JSONObject josnobjroom = (JSONObject) jsonObjectroom.get(a);
					  
					    String pricestring =jsonObjectroom.get(a).toString();
					   
					    pricestring=pricestring.replace("{\"plans\":", "");
					    String[] stingroompr = pricestring.split(",\"title\"");
					    pricestring=stingroompr[0];
					    
					    JSONArray jsonObjectprice = new JSONArray(pricestring); 
					    JSONObject josnobjpr = (JSONObject) jsonObjectprice.get(0);
					
					
					    
					    String pricrsr=pricestring.toString();
					    
					 
					    
					    String[] dateprice = pricrsr.split(",\"date\":");
					    pricrsr=dateprice[1];
					    
					  //  String[] datepricedeletemenshi = pricrsr.split(",\"jiangjin\"");
					  //  pricrsr=datepricedeletemenshi[0];
					    //陈星关闭
					    
					   // System.out.println("pricrsr=="+pricrsr);
					    
					    //解析每天的价格
					    JSONArray jsonObjectdataprice = new JSONArray(pricrsr); 
					    JSONObject josnobjprdate = (JSONObject) jsonObjectdataprice.get(0);
					  //  System.out.println("jsonObjectdataprice的大小=="+jsonObjectdataprice.length());
					    
					    //房型开始
					    Roomtype roomtype = new Roomtype();
					    String whereroom=" where 1=1 and "+Roomtype.COL_name+" ='"+josnobjroom.get("title")+"' and "+Roomtype.COL_hotelid+" ="+h.getId()+" and "+Roomtype.COL_roomcode+" ='"+josnobjroom.get("rid")+"'";
					    List<Roomtype>listroomtype=Server.getInstance().getHotelService().findAllRoomtype(whereroom, " ORDER BY ID ", -1, 0);
					    if(listroomtype.size()>0){
					    	
					    	roomtype=listroomtype.get(0);
					    }
					    
					    roomtype.setName(josnobjroom.get("title").toString().trim());
					    roomtype.setHotelid(h.getId());
					    roomtype.setRoomcode(josnobjroom.get("rid").toString().trim());
					    String roomstatus="0";
					    if(josnobjroom.get("status").toString()!=null){
					    	roomstatus=josnobjroom.get("status").toString();//房型状态
					     System.out.println("roomstatus:"+roomstatus+",roomname:"+roomtype.getName()+",hotelname:"+h.getName());
					    }
					    roomtype.setState(Integer.parseInt(roomstatus));
					    String chuan = josnobjroom.get("bed").toString();
							roomtype.setBed(chuan);
						String kuan = josnobjroom.get("adsl").toString();
							roomtype.setWideband(kuan);
						String zao = josnobjpr.get("planname").toString();
							roomtype.setBreakfast(zao);
						roomtype.setLanguage(0);
						
						String planid = josnobjpr.get("planid").toString();//价格计划ID
						
						
						  if(listroomtype.size()>0){
						    	
							  Server.getInstance().getHotelService().updateRoomtypeIgnoreNull(roomtype);
						    }else{
						      roomtype=Server.getInstance().getHotelService().createRoomtype(roomtype);
						    }
						  
						  listR.add(roomtype);
					    
					    //房型结束
						 //价格开始
						  
						  //初始化价格list
						  List listpr= new ArrayList();
						  for(int p=0;p<jsonObjectdataprice.length();p++){

					    	  JSONObject josnobjroomdayprice = (JSONObject) jsonObjectdataprice.get(p);
					    	  
					    	 // System.out.println("day=="+josnobjroomdayprice.getString("day"));
					    	//  System.out.println("price=="+josnobjroomdayprice.getString("price"));
					    	//  System.out.println("menshi=="+josnobjroomdayprice.getString("menshi"));
					    	  String pr=josnobjroomdayprice.getString("price");
					    	  String menshi=josnobjroomdayprice.getString("menshi");
					    	  String datenum=josnobjroomdayprice.getString("day");
					    	  String datenumber=datenum.substring(0, 7);
					    	  
					    	  
					    	  String[] datearray=datenum.trim().split("-");
					    	  String day="";
								if(datearray[2].substring(0,1).equals("0"))
								{
									day=datearray[2].substring(1);
								}else
								{
									day=datearray[2];
								}
								//
								Double price=0.0;
								System.out.println("hid:"+h.getId()+",roomid:"+roomtype.getId()+",day:"+day+",price:"+pr);
								if(pr.trim().equals("×")){
									if(menshi.toString().trim().equals("×")){
										
										pr="0.0";
									}else{
										pr=menshi.toString().trim();
									}
								}else{
									
									pr=pr.toString().trim();
								}
								//
								
								
								long hotelid=h.getId();
								long roomid=roomtype.getId();
								
								Hotelprice hotelprice = new Hotelprice();
								List<Hotelprice>listhotelprice=Server.getInstance().getHotelService().findAllHotelprice(" where 1=1 and "+Hotelprice.COL_hotelid+" ="+hotelid+" and "+Hotelprice.COL_datenumber+" ='"+datenumber+"' and "+Hotelprice.COL_roomid+" ="+roomid, "", -1, 0);
								if(listhotelprice.size()>0){
									hotelprice=listhotelprice.get(0);
									
								}
								hotelprice.setRateplancode(planid);//价格计划ID
								
								hotelprice.setDeptprice(menshi);
								hotelprice.setDatenumber(datenumber);
								hotelprice.setRoomid(roomid);
								hotelprice.setHotelid(hotelid);
								hotelprice.setLanguage(0);
								
								 try {
										Hotelprice.class.getMethod("setNo"+day,Double.class).invoke(hotelprice,Double.parseDouble(pr));
									} catch (NumberFormatException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IllegalArgumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (SecurityException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IllegalAccessException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InvocationTargetException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (NoSuchMethodException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
										
								if(listhotelprice.size()>0){
									Server.getInstance().getHotelService().updateHotelpriceIgnoreNull(hotelprice);
									
									
								}else{
									
									Server.getInstance().getHotelService().createHotelprice(hotelprice);
								}
								System.out.println("hotelprice:"+hotelprice);
								listpr.add(pr);
								
								//RoomPrice.put(roomtype.getId(), pp);
					    }
					  
						  RoomListPrice.put(roomtype.getId(), listpr); 
				    }
				
				
			}
			
			mapRoom.put(new Long(h.getId()),listR);
			
		
			
		}*/
		
			return "sousuo";
	}
	
	
	public String GetZhuNaHotelRoomPriceByHotelcode(String hotelcode,String startDate,String endDate){
		
		String urltemp="http://www.api.zhuna.cn/e/json.php?hid="+hotelcode+"&tm1="+startDate+"&tm2="+endDate+"&orderfrom=0&call=";
		System.out.println(urltemp);
		URL url;
		try {
			url = new URL(urltemp);
			URLConnection connection = url.openConnection();  
			connection.setDoOutput(true);
			connection.setConnectTimeout(600);
			connection.setReadTimeout(600);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.flush();  
		    out.close();  
		    String sCurrentLine;  
		    String sTotalString;  
		    sCurrentLine = "";  
		    sTotalString = "";  
		    InputStream l_urlStream;  
		    l_urlStream = connection.getInputStream();  
		    BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));  
		    while ((sCurrentLine = l_reader.readLine()) != null) {  
		    sTotalString += sCurrentLine + "\r\n";  
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
	
	
	public String sousuobrad() throws Exception {
		//获得用户搜索信息
		String ucityname="";
		if(cityId!=null)
		{
		ucityname=getCityNameByStr(cityId.toString());
		}
		String uhotelName=getHotelName();
		String upricearea=s_price;

		searchInfo=new StringBuffer("");
		if(ucityname!=null&&!ucityname.equals(""))
		{
			searchInfo.append(ucityname);
		}
		if(uhotelName!=null&&!uhotelName.equals("")){
			searchInfo.append(" + "+uhotelName);
		}
		if(regionid!=null&&!regionid.equals("")){
			searchInfo.append(" + "+ getRegionNameByStr(regionid));
		}
		if(s_price!=null&&!"".equals(s_price))
		{
			searchInfo.append(" + "+upricearea);
		}
		//推荐酒店信息
		//getCommandHotelList(cityId);
		StringBuilder where = new StringBuilder(" where C_STATE=3 ");
		
		listchain=Server.getInstance().getHotelService().findAllChaininfo("WHERE 1=1", " ORDER BY C_SORT ", 3, 0);

		// 酒店名称
		if (null != hotelName && !"".equals(hotelName.trim())) {
			where.append(" and C_NAME like '%");
			where.append(hotelName.trim());
			where.append("%' ");
		}

		// 酒店所在城市
		if( cityId != null && cityId > 0) {
			where.append(" and C_CITYID =").append(cityId);
		}
		
		// 星级
		if (null != s_star && s_star.length > 0) {
			String s = StringUtils.join(s_star, ',');
			if (s != null && !"".equals(s.trim())) {
				where.append(" and C_STAR in(");
				where.append(s);
				where.append(") ");
			}
		}
		// 装修
		if (null != s_repair && s_repair.length > 0) {
			String s = StringUtils.join(s_repair, ',');
			if (s != null && !"".equals(s.trim())) {
				where.append("and C_REPAIR in(");
				where.append(s);
				where.append(") ");
			}
		}
		//按照品牌酒店ID查询
		if(bradnhotelid!=null && !bradnhotelid.equals(""))
		{
			where.append("and C_CHAININFOID="+bradnhotelid);
		}

		// 区域
//		if (null != regiontype && !"".equals(regiontype)) {
//			if (null != regionvalue && !"".equals(regionvalue.trim()) && !regionvalue.equals("--请选择--")) {
//				if (regiontype.equals("0")) {
//					where.append(" and C_REGIONID2 =").append(regionvalue);
//				} else if (regiontype.equals("1")) {
//					where.append(" and C_REGIONID1 =").append(regionvalue);
//				} else if (regiontype.equals("2")) {
//					where.append(" and C_REGIONID3 =").append(regionvalue);
//				}
//			}
//		}
		
		//按照区域进行查询
		if(regionid!=null && !regionid.equals(""))
		{
			where.append(" and (C_REGIONID1 ="+regionid+" or C_REGIONID2 ="+regionid+" or C_REGIONID3 ="+regionid+")");
		}
		
/*
		// 地标
		if(landmarkId != 0){
			where.append("  and ID in (select C_HOTELID from b2b2c.T_HOTELLANDMARK where C_LANDMARKID = ").append(landmarkId);
			if(null != range && !range.equals("0") && !range.trim().equals("")){
				where.append("  and C_RANGE = ").append(range).append(" )");
			}else{
				where.append(" )");
			}
		}
*/
		//按照价格进行查询
		if(s_price!=null && !s_price.equals("0"))
		{
			//RMB 250以下
			if(s_price.equals("1"))
			{
				where.append(" and C_STARTPRICE<250");
			}
			//RMB 250-400
			else if(s_price.equals("2"))
			{
				where.append(" and C_STARTPRICE>250 and and C_STARTPRICE<400 ");
			}
			//RMB 400-600
			else if(s_price.equals("3"))
			{
				where.append(" and C_STARTPRICE>400 and and C_STARTPRICE<600 ");
			}
			//RMB 600-800
			else if(s_price.equals("4"))
			{
				where.append(" and C_STARTPRICE>600 and and C_STARTPRICE<800 ");
			}
			//RMB 800以上
			else if(s_price.equals("5"))
			{
				where.append(" and C_STARTPRICE>800");
			}
			
		}
		
		// 价格 p[0]最低价格  p[1]最高价格
		String[] p = null;
		if(priceType != -1) {
			p = getPrice(priceType).split("\\-");
		}
		// 入住日期
		if (null != startDate && !"".equals(startDate.trim())
				&& null != endDate && !"".equals(endDate.trim())) {
			s_num = dateDiff(endDate.trim(), startDate.trim());
		//	System.out.println("s_num=="+s_num);
			/*where.append("  and ID in (select C_HOTELID from "+Hotelprice.TABLE+" where C_DATENUMBER ='");
			where.append(startDate.trim().substring(0, 7));
			where.append("' and C_NO");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(" >= ");
			where.append(p[0]);
			where.append(" and C_NO");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(" <= ");
			where.append(p[1]);

		
			where.append(" and charindex('1',substring(C_ISVALID,");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(",").append(s_num).append(")) = 0");*/

			// where.append(" and INSTR(SUBSTR(C_ISVALID,");
			// where.append(Integer.parseInt(s_startdate.substring(8,10)));
			// where.append(",");
			// where.append(s_num).append("),'1') != 0");

			// substring(convert(varchar,C_STARTDATE,23),1,10) > '2009-09-02'

					//where.append(" and C_ROOMID not in " +
					//				"( select C_ROOMTYPEID from "+Roomstate.TABLE+" " +
					//					"where C_STATE = 2 and substring(convert(varchar,C_STARTDATE,23),1,10)<= '");
					//where.append(startDate);
					//where.append("' or substring(convert(varchar,C_ENDDATE,23),1,10) >= '");
					//where.append(endDate);
					//	where.append("') " 
		//	where.append(" and C_ROOMID in (select ID from "+Roomtype.TABLE+" where C_STATE=1))");
			/*
			// SQL语句
			where C_STATE=3  and C_CITYID =607  
			 	and ID in 
			 (select C_HOTELID from b2b2c.T_HOTELPRICE 
				 where C_DATENUMBER ='2010-01' 
					and C_NO12 >= 0 and C_NO12 <= 1000000 
						and charindex('1',substring(C_ISVALID,12,1)) = 0 
							and C_ROOMID not in 
							(select C_ROOMTYPEID from b2b2c.T_ROOMSTATE 
								where C_STATE = 2 
									and substring(convert(varchar,C_STARTDATE,23),1,10)<= '2010-01-12' 
										or substring(convert(varchar,C_ENDDATE,23),1,10) >= '2010-01-13') 
								and C_ROOMID in (select ID from b2b2c.T_ROOMTYPE where C_STATE=1) )
			*/
		}
		
		// 排序
		String orderStr = "ORDER BY C_HOT";
		
		if (orderType == 1) {
			if (orderMode != 2) {
				orderStr = "order by C_STARTPRICE";
			} else {
				orderStr = "order by C_STARTPRICE DESC";
			}
		} else if (orderType == 2) {
			if (orderMode != 2) {
				orderStr = "order by C_STAR";
			} else {
				orderStr = "order by C_STAR DESC";
			}
		}
	//	System.out.println("where==="+where.toString());
		pageinfo.setPagerow(9);
		List list = Server.getInstance().getHotelService()
			.findAllHotelForPageinfo(where.toString(), orderStr, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		hotelList = list;
		
		if(pageinfo.getTotalrow()>0 &&   hotelList.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelForPageinfo(where.toString()," ORDER BY C_HOT ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			hotelList = list;
		}
		
		for(Hotel h : hotelList){
			
			
			long id = h.getId();
			StringBuilder wh = new StringBuilder(" where C_STATE=1  and ID in (select C_ROOMID from "+Hotelprice.TABLE+" where C_HOTELID= ");
			wh.append(id);
			wh.append(" and C_DATENUMBER ='");
			wh.append(startDate.trim().substring(0,7));
			wh.append("' and C_NO");
			wh.append(Integer.parseInt(startDate.substring(8,10)));
			wh.append(" >= ");
			wh.append(p[0]);
			wh.append(" and C_NO");
			wh.append(Integer.parseInt(startDate.substring(8,10)));
			wh.append(" <= ");
			wh.append(p[1]);
					//wh.append("  and C_ROOMID not in ( select C_ROOMTYPEID from "+Roomstate.TABLE+" where C_STATE = 2 and (substring(convert(varchar,C_STARTDATE,23),1,10)  <= '");
					//wh.append(startDate);
					//wh.append("' or substring(convert(varchar,C_ENDDATE,23),1,10) >= '");
					//wh.append(endDate);
					//wh.append("'))" +
			wh.append(")");
		//	System.out.println("wh==="+wh.toString());
			List<Roomtype> li = Server.getInstance().getHotelService().findAllRoomtype(wh.toString()," ORDER BY ID ",-1,0);
				////
			mapRoom.put(new Long(id),li);
			if(li.size()>0){
			for(Roomtype r : li){
				
		//	System.out.println("li==="+li);
			long Roomtypeid = li.get(0).getId();
			long Hotelid = h.getId();
			
			int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
		//	System.out.println("startmethod=="+startmethod);
			int s=	Integer.parseInt(startDate.substring(8,10));//开始天
		//	System.out.println("开始天ssss=="+s);
			int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
		//	System.out.println("结束月endDatemethod=="+endDatemethod);
			int f=	Integer.parseInt(endDate.substring(8,10));//结束天
			int d = f-1;
	//		System.out.println("结束天dddd=="+d);
			
			String snian=	startDate.substring(0,7);//开始yue
			String enian=	endDate.substring(0,7);//开始yue
			
			StringBuilder wher = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+Roomtypeid+" and "+Hotelprice.COL_hotelid+"= "+Hotelid +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");
			//where.append(" and "+Hotelprice.COL_datenumber +" BETWEEN "+"'"+startDate.trim().substring(0,7)+"' and '"+endDate.trim().substring(0,7)+"'");
			//Hotelprice hotelpice = Server.getInstance().getHotelService().findHotelprice(Roomtypeid);
			
			
			//System.out.println("where==="+where);
			ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wher.toString()," ORDER BY C_DATENUMBER ",-1,0);
			
			if(ListHotelprice.size()>0){
			
			if(startmethod == endDatemethod){//如果在相同月份的话
				
				
		//	System.out.println("月份相同");
			
				for(int a=s;a<=d;a++){
					
					String mnane = "getNo"+a;
					Class[] types = new Class[]{};
					Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
					
					Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
					Double price = ((Double)aa).doubleValue();
					int pp=	(int)Math.floor(price);
					
					if(sessionlanguage()==1)
					{
						String	asas =startmethod+"月"+ a+"號:<font class='font14'>￥</font>"+pp;
						Listroomtypeprice.add(asas);
					}else if(sessionlanguage()==2)
					{
						String	asas =startmethod+"月"+ a+"番号:<font class='font14'>￥</font>"+pp;
						Listroomtypeprice.add(asas);
					}else if(sessionlanguage()==3)
					{
						String	asas =startmethod+"Month"+ a+"Number:<font class='font14'>￥</font>"+pp;
						Listroomtypeprice.add(asas);
					}else
					{
						String	asas =startmethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
						Listroomtypeprice.add(asas);
					}
					
		//			System.out.println(asas);
					//int romid =(int) Roomtypeid;
					
					
				
					}
				
			}else{//开始月分份和结束月份不在一个月
				
		//		System.out.println("月份不不不相同");
				if(endDatemethod > startmethod){
		//			System.out.println("月份不不不相同并且结束月大如开始月份");
					java.util.GregorianCalendar c =(GregorianCalendar) GregorianCalendar.getInstance();
					c.isLeapYear(c.get(c.YEAR));
					int startdate=31;
					if(startmethod==1){
						
						 startdate=31;
					}
					
					if(startmethod==2){
						if(c.isLeapYear(c.get(c.YEAR))==true){
						
						  startdate=29;
						}else{
							
							 startdate=28;
						}
					}
					
					if(startmethod==3){
						
						  startdate=31;
					}
					if(startmethod==4){
						
						  startdate=30;
					}
					if(startmethod==5){
						
						  startdate=31;
					}
					if(startmethod==6){
						
						  startdate=30;
					}
					if(startmethod==7){
						
						  startdate=31;
					}
					if(startmethod==8){
						
						  startdate=31;
					}
					if(startmethod==9){
						
						  startdate=30;
					}
					if(startmethod==10){
						
						  startdate=31;
					}
					if(startmethod==11){
						
						  startdate=30;
					}
					if(startmethod==12){
						
						  startdate=30;
					}
					for(int a=s;a<=startdate;a++){
						
						String mnane = "getNo"+a;
						Class[] types = new Class[]{};
						Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
						
						Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
						Double price = ((Double)aa).doubleValue();
						int pp=	(int)Math.floor(price);
						//String	asas =startmethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
						
						if(sessionlanguage()==1)
						{
							String	asas =startmethod+"月"+ a+"號:<font class='font14'>￥</font>"+pp;
							Listroomtypeprice.add(asas);
						}else if(sessionlanguage()==2)
						{
							String	asas =startmethod+"月"+ a+"番号:<font class='font14'>￥</font>"+pp;
							Listroomtypeprice.add(asas);
						}else if(sessionlanguage()==3)
						{
							String	asas =startmethod+"Month"+ a+"Number:<font class='font14'>￥</font>"+pp;
							Listroomtypeprice.add(asas);
						}else
						{
							String	asas =startmethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
							Listroomtypeprice.add(asas);
						}
						
						
				//		System.out.println(asas);
						//int romid =(int) Roomtypeid;
						
						//Listroomtypeprice.add(asas);
					
						}
				for(int a=1;a<=d;a++){
						
						String mnane = "getNo"+a;
						Class[] types = new Class[]{};
						Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
						//这报错了
							if(ListHotelprice.size()>1){
									Object aa = method.invoke(ListHotelprice.get(1), new Object[0]);
									
									Double price = ((Double)aa).doubleValue();
									int pp=	(int)Math.floor(price);
									
								
									
									if(sessionlanguage()==1)
									{
										String	asas =endDatemethod+"月"+ a+"號:<font class='font14'>￥</font>"+pp;
										Listroomtypeprice.add(asas);
									}else if(sessionlanguage()==2)
									{
										String	asas =endDatemethod+"月"+ a+"番号:<font class='font14'>￥</font>"+pp;
										Listroomtypeprice.add(asas);
									}else if(sessionlanguage()==3)
									{
										String	asas =endDatemethod+"Month"+ a+"Number:<font class='font14'>￥</font>"+pp;
										Listroomtypeprice.add(asas);
									}else
									{
										String	asas =endDatemethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
										Listroomtypeprice.add(asas);
									}
									
									
								//	System.out.println(asas);
									//int romid =(int) Roomtypeid;
									
									
							}
						}	
					
				}
				
				
			}
			}
			////
			
				mappice.put(Roomtypeid, Listroomtypeprice);
			}
			}
		//	System.out.println("mappice=="+mappice);
			
		
		}
		//特别推广的酒店
		hotelList_tebie = Server.getInstance().getHotelService().findAllHotel("where 1=1 and "+Hotel.COL_cityid+" ="+cityId+" and "+Hotel.COL_hot+" =1 and "+Hotel.COL_state+" =3 and "+Hotel.COL_language+" ="+sessionlanguage()," ORDER BY ID DESC", 5, 0);
	
//区域
		listAdmin = Server.getInstance().getHotelService().findAllRegion(" WHERE " + Region.COL_cityid + " = " + cityId +" AND "+Region.COL_type+"='行政区' and "+Region.COL_language+" ="+sessionlanguage()," ORDER BY ID",-1,0);
	//	System.out.println("国家类型==="+guojia);
		return "sousuobrad";
	}
	/**
	 * 搜索酒店  国际的
	 * @return
	 * @throws Exception
	 */
	public String search_international_hotel() throws Exception {
		StringBuilder where = new StringBuilder(" where C_STATE=3 ");
		
		//System.out.println("城市=="+cityId+"   酒店=="+hotelName+"  装修="+s_repair[0]+"  星级=="+s_star+"=="+startDate+"=="+endDate);
		// 查询所有的城市
	/*	cityList = (List<City>)ActionContext.getContext().getSession().get("cityList");
		if(cityList == null || cityList.size() ==0) {
			cityList = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
			ActionContext.getContext().getSession().put("cityList", cityList);
		}*/

		// 酒店名称
		if (null != hotelName && !"".equals(hotelName.trim())) {
			where.append(" and C_NAME like '%");
			where.append(hotelName.trim());
			where.append("%' ");
		}

		// 酒店所在城市
		if( cityId != null && cityId > 0) {
			where.append(" and C_CITYID =").append(cityId);
		}
		
		//	where.append(" and C_CITYID =");
		


		// 星级
		if (null != s_star && s_star.length > 0) {
			String s = StringUtils.join(s_star, ',');
			if (s != null && !"".equals(s.trim())) {
				where.append(" and C_STAR in(");
				where.append(s);
				where.append(") ");
			}
		}
		// 装修
		if (null != s_repair && s_repair.length > 0) {
			String s = StringUtils.join(s_repair, ',');
			if (s != null && !"".equals(s.trim())) {
				where.append("and C_REPAIR in(");
				where.append(s);
				where.append(") ");
			}
		}

		// 区域
		if (null != regiontype && !"".equals(regiontype)) {
			if (null != regionvalue && !"".equals(regionvalue.trim()) && !regionvalue.equals("--请选择--")) {
				if (regiontype.equals("0")) {
					where.append(" and C_REGIONID2 =").append(regionvalue);
				} else if (regiontype.equals("1")) {
					where.append(" and C_REGIONID1 =").append(regionvalue);
				} else if (regiontype.equals("2")) {
					where.append(" and C_REGIONID3 =").append(regionvalue);
				}
			}
		}
		
/*
		// 地标
		if(landmarkId != 0){
			where.append("  and ID in (select C_HOTELID from b2b2c.T_HOTELLANDMARK where C_LANDMARKID = ").append(landmarkId);
			if(null != range && !range.equals("0") && !range.trim().equals("")){
				where.append("  and C_RANGE = ").append(range).append(" )");
			}else{
				where.append(" )");
			}
		}
*/
		
		// 价格 p[0]最低价格  p[1]最高价格
		String[] p = null;
		if(priceType != -1) {
			p = getPrice(priceType).split("\\-");
		}
		// 入住日期
		if (null != startDate && !"".equals(startDate.trim())
				&& null != endDate && !"".equals(endDate.trim())) {
			s_num = dateDiff(endDate.trim(), startDate.trim());
			System.out.println("s_num=="+s_num);
			where.append("  and ID in (select C_HOTELID from "+Hotelprice.TABLE+" where C_DATENUMBER ='");
			where.append(startDate.trim().substring(0, 7));
			where.append("' and C_NO");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(" >= ");
			where.append(p[0]);
			where.append(" and C_NO");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(" <= ");
			where.append(p[1]);

			// 价格禁用判断
			where.append(" and charindex('1',substring(C_ISVALID,");
			where.append(Integer.parseInt(startDate.substring(8, 10)));
			where.append(",").append(s_num).append(")) = 0");

			// where.append(" and INSTR(SUBSTR(C_ISVALID,");
			// where.append(Integer.parseInt(s_startdate.substring(8,10)));
			// where.append(",");
			// where.append(s_num).append("),'1') != 0");

			// substring(convert(varchar,C_STARTDATE,23),1,10) > '2009-09-02'

			where.append(" and C_ROOMID not in " +
							"( select C_ROOMTYPEID from "+Roomstate.TABLE+" " +
								"where C_STATE = 2 and substring(convert(varchar,C_STARTDATE,23),1,10)<= '");
			where.append(startDate);
			where.append("' or substring(convert(varchar,C_ENDDATE,23),1,10) >= '");
			where.append(endDate);
			where.append("') and C_ROOMID in (select ID from "+Roomtype.TABLE+" where C_STATE=1) )");
			/*
			// SQL语句
			where C_STATE=3  and C_CITYID =607  
			 	and ID in 
			 (select C_HOTELID from b2b2c.T_HOTELPRICE 
				 where C_DATENUMBER ='2010-01' 
					and C_NO12 >= 0 and C_NO12 <= 1000000 
						and charindex('1',substring(C_ISVALID,12,1)) = 0 
							and C_ROOMID not in 
							(select C_ROOMTYPEID from b2b2c.T_ROOMSTATE 
								where C_STATE = 2 
									and substring(convert(varchar,C_STARTDATE,23),1,10)<= '2010-01-12' 
										or substring(convert(varchar,C_ENDDATE,23),1,10) >= '2010-01-13') 
								and C_ROOMID in (select ID from b2b2c.T_ROOMTYPE where C_STATE=1) )
			*/
		}
		
		// 排序
		String orderStr = "ORDER BY ID";
		
		if (orderType == 1) {
			if (orderMode != 2) {
				orderStr = "order by C_STARTPRICE";
			} else {
				orderStr = "order by C_STARTPRICE DESC";
			}
		} else if (orderType == 2) {
			if (orderMode != 2) {
				orderStr = "order by C_STAR";
			} else {
				orderStr = "order by C_STAR DESC";
			}
		}
		System.out.println("where==="+where.toString());
		pageinfo.setPagerow(8);
		List list = Server.getInstance().getHotelService()
			.findAllHotelForPageinfo(where.toString(), orderStr, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		hotelList = list;
		
		if(pageinfo.getTotalrow()>0 &&   hotelList.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelForPageinfo(where.toString()," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			hotelList = list;
		}
		
		for(Hotel h : hotelList){
			long id = h.getId();
			StringBuilder wh = new StringBuilder(" where C_STATE=1 and ID in (select C_ROOMID from "+Hotelprice.TABLE+" where C_HOTELID= ");
			wh.append(id);
			wh.append(" and C_DATENUMBER ='");
			wh.append(startDate.trim().substring(0,7));
			wh.append("' and C_NO");
			wh.append(Integer.parseInt(startDate.substring(8,10)));
			wh.append(" >= ");
			wh.append(p[0]);
			wh.append(" and C_NO");
			wh.append(Integer.parseInt(startDate.substring(8,10)));
			wh.append(" <= ");
			wh.append(p[1]);
			wh.append("  and C_ROOMID not in ( select C_ROOMTYPEID from "+Roomstate.TABLE+" where C_STATE = 2 and (substring(convert(varchar,C_STARTDATE,23),1,10)  <= '");
			wh.append(startDate);
			wh.append("' or substring(convert(varchar,C_ENDDATE,23),1,10) >= '");
			wh.append(endDate);
			wh.append("')))");
			System.out.println("wh==="+wh.toString());
			List<Roomtype> li = Server.getInstance().getHotelService().findAllRoomtype(wh.toString()," ORDER BY ID ",-1,0);
				////
			long Roomtypeid = li.get(0).getId();
			long Hotelid = h.getId();
			StringBuilder wher = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+Roomtypeid+" and "+Hotelprice.COL_hotelid+"= "+Hotelid);
			where.append(" and "+Hotelprice.COL_datenumber +" BETWEEN "+"'"+startDate.trim().substring(0,7)+"' and '"+endDate.trim().substring(0,7)+"'");
		
			System.out.println("where==="+where);
			ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wher.toString()," ORDER BY ID ",-1,0);
			
			int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
			System.out.println("startmethod=="+startmethod);
			int s=	Integer.parseInt(startDate.substring(8,10));//开始天
			System.out.println("开始天ssss=="+s);
			int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
			System.out.println("结束月endDatemethod=="+endDatemethod);
			int f=	Integer.parseInt(endDate.substring(8,10));//结束天
			int d = f-1;
			System.out.println("结束天dddd=="+d);
			if(startmethod == endDatemethod){//如果在相同月份的话
				
				
			System.out.println("月份相同");
			
				for(int a=s;a<=d;a++){
					
					String mnane = "getNo"+a;
					Class[] types = new Class[]{};
					Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
					
					Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
					Double price = ((Double)aa).doubleValue();
					int pp=	(int)Math.floor(price);
					String	asas =startmethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
					System.out.println(asas);
					//int romid =(int) Roomtypeid;
					
					Listroomtypeprice.add(asas);
					}
				
			}else{//开始月分份和结束月份不在一个月
				
				System.out.println("月份不不不相同");
				if(endDatemethod > startmethod){
					System.out.println("月份不不不相同并且结束月大如开始月份");
					for(int a=s;a<=31;a++){
						
						String mnane = "getNo"+a;
						Class[] types = new Class[]{};
						Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
						
						Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
						Double price = ((Double)aa).doubleValue();
						int pp=	(int)Math.floor(price);
						String	asas =startmethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
						System.out.println(asas);
						//int romid =(int) Roomtypeid;
						
						Listroomtypeprice.add(asas);
						}
					for(int a=1;a<=d;a++){
						
						String mnane = "getNo"+a;
						Class[] types = new Class[]{};
						Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
						
						Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
						Double price = ((Double)aa).doubleValue();
						int pp=	(int)Math.floor(price);
						String	asas =endDatemethod+"月"+ a+"号:<font class='font14'>￥</font>"+pp;
						System.out.println(asas);
						//int romid =(int) Roomtypeid;
						
						Listroomtypeprice.add(asas);
						}	
					
				}
				
				
			}
			
			////
			System.out.println("li=="+li);
			mapRoom.put(new Long(id),li);
		}
		
		s_num = dateDiff(endDate.trim(), startDate.trim());
		return "sousuo";
	}

	
	//elong预订
	public String toyuding()throws Exception{
	Customeruser  customeruser =getLoginUser();
	Customeragent customeragent = Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());//当前登录者所属
	//周几信息
	
	SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd");        
    Date InDate1 =df.parse(startDate.trim());
    Date1=startDate.trim();
    
    Calendar d11=new GregorianCalendar();
    Date   d1=null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
    String baseDate=startDate.trim() ;//入住日期
    try{ //一定要放到try里面,不然会报错的
        d1   =   sdf.parse(baseDate);  
     }
     catch(Exception e){
     }
     d11.setTime(d1);
     
     //第二天日期
     d11.add(Calendar.DAY_OF_MONTH, 1);
     Date2=df.format(d11.getTime()).toString();
     System.out.println(Date2);
     //第三天日期
     Calendar d22=new GregorianCalendar();
     Date   d2=null;
     try{ //一定要放到try里面,不然会报错的
         d2   =   sdf.parse(Date2);  
      }
      catch(Exception e){
      }
      d22.setTime(d2);
     d22.add(Calendar.DAY_OF_MONTH, 1);
     Date3=df.format(d22.getTime()).toString();
     //第四天日期
     Calendar d33=new GregorianCalendar();
     Date   d3=null;
     try{ //一定要放到try里面,不然会报错的
         d3   =   sdf.parse(Date3);  
      }
      catch(Exception e){
      }
     d33.setTime(d3);
     d33.add(Calendar.DAY_OF_MONTH, 1);
     Date4=df.format(d33.getTime()).toString();
     //第五天日期
     Calendar d44=new GregorianCalendar();
     Date   d4=null;
     try{ //一定要放到try里面,不然会报错的
         d4   =   sdf.parse(Date4);  
      }
      catch(Exception e){
      }
     d44.setTime(d4);
     d44.add(Calendar.DAY_OF_MONTH, 1);
     Date5=df.format(d44.getTime()).toString();
     //第六天日期
     Calendar d55=new GregorianCalendar();
     Date   d5=null;
     try{ //一定要放到try里面,不然会报错的
         d5   =   sdf.parse(Date5);  
      }
      catch(Exception e){
      }
     d55.setTime(d5);
     d55.add(Calendar.DAY_OF_MONTH, 1);
     Date6=df.format(d55.getTime()).toString();
     //第七天日期
     Calendar d66=new GregorianCalendar();
     Date   d6=null;
     try{ //一定要放到try里面,不然会报错的
         d6   =   sdf.parse(Date6);  
      }
      catch(Exception e){
      }
     d66.setTime(d6);
     d66.add(Calendar.DAY_OF_MONTH, 1);
     Date7=df.format(d66.getTime()).toString();
                
//
     hotel = Server.getInstance().getHotelService().findHotel(hotelid) ;
     cityId = hotel.getCityid();
		
		     
     listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" where 1=1 and "+Roomtype.COL_hotelid+" ="+hotelid+" and "+Roomtype.COL_id+" ="+roomid, " ORDER BY ID ", -1, 0);
     NEWroomtype = listRoomtype.get(0);
     System.out.println("NEWroomtype=="+NEWroomtype);  
 	
     SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hotel, startDate, endDate,NEWroomtype.getRoomcode()); 
     
     List<Object> listprice=new ArrayList<Object>();//存放价格
	if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
		List<Roomtype>listroom=seachHotelBean.getListRoomtype();
		List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
		
		
		listBookingRules=seachHotelBean.getListBookingRules();
		List<GuaranteeRule>listDanBao=seachHotelBean.getListGuaranteeRule();
		//listGuaranteeRule=seachHotelBean.getListGuaranteeRule();
		listPrepayRule=seachHotelBean.getListPrepayRule();
		listRatePlan=listroom.get(0).getListRatePlan();
		listNightlyRate=listRatePlan.get(0).getListNightlyRate();
		zongjia=Integer.parseInt(listRatePlan.get(0).getTotalRate().split("[.]")[0]);
		pricecode=listRatePlan.get(0).getRatePlanId();
		
		String GuaranteeRuleIds=listRatePlan.get(0).getGuaranteeRuleIds();
		listGuaranteeRule=new ArrayList<GuaranteeRule>();
		System.out.println("GuaranteeRuleIds:"+GuaranteeRuleIds);
		for(int a=0;a<listDanBao.size();a++){
			if(listDanBao.get(a).getGuranteeRuleId().equals(GuaranteeRuleIds)){
				
				listGuaranteeRule.add(listDanBao.get(a));
			}
		}
		
		if(listGuaranteeRule.size()==0){
			listGuaranteeRule=seachHotelBean.getListGuaranteeRule();
		}
	}

System.out.println("总价:"+zongjia);	



s_num = dateDiff(endDate.trim(), startDate.trim());

//算出开始天数到结束天数的总价
String snian=	startDate.substring(0,7);//开始yue
String enian=	endDate.substring(0,7);//开始yue

int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
int s=	Integer.parseInt(startDate.substring(8,10));//开始天
int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
int f=	Integer.parseInt(endDate.substring(8,10));//结束天
int d = f-1;

///
City city=Server.getInstance().getHotelService().findCity(cityId);







HotelPos=GetHotelValueByStar(hotel.getStar().toString(), Float.parseFloat(zongjia+""));
HotelPos=0f;
System.out.println("HotelPos=="+HotelPos);

	return "toyuding";
	
	
	
	}
	//转到预订页面
	// 开始天数到结束天数的总价
	
	public String toyuding_ziyou()throws Exception{
		
		Customeruser  customeruser =getLoginUser();
		Customeragent customeragent = Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());//当前登录者所属
	
		System.out.println(ActionContext.getContext().getSession().get("orderUrl"));
		//周几信息
		
		SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd");        
        Date InDate1 =df.parse(startDate.trim());
        Date1=startDate.trim();
        
        Calendar d11=new GregorianCalendar();
        Date   d1=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
        String baseDate=startDate.trim() ;//入住日期
        try{ //一定要放到try里面,不然会报错的
            d1   =   sdf.parse(baseDate);  
         }
         catch(Exception e){
         }
         d11.setTime(d1);
         
         //第二天日期
         d11.add(Calendar.DAY_OF_MONTH, 1);
         Date2=df.format(d11.getTime()).toString();
         System.out.println(Date2);
         //第三天日期
         Calendar d22=new GregorianCalendar();
         Date   d2=null;
         try{ //一定要放到try里面,不然会报错的
             d2   =   sdf.parse(Date2);  
          }
          catch(Exception e){
          }
          d22.setTime(d2);
         d22.add(Calendar.DAY_OF_MONTH, 1);
         Date3=df.format(d22.getTime()).toString();
         //第四天日期
         Calendar d33=new GregorianCalendar();
         Date   d3=null;
         try{ //一定要放到try里面,不然会报错的
             d3   =   sdf.parse(Date3);  
          }
          catch(Exception e){
          }
         d33.setTime(d3);
         d33.add(Calendar.DAY_OF_MONTH, 1);
         Date4=df.format(d33.getTime()).toString();
         //第五天日期
         Calendar d44=new GregorianCalendar();
         Date   d4=null;
         try{ //一定要放到try里面,不然会报错的
             d4   =   sdf.parse(Date4);  
          }
          catch(Exception e){
          }
         d44.setTime(d4);
         d44.add(Calendar.DAY_OF_MONTH, 1);
         Date5=df.format(d44.getTime()).toString();
         //第六天日期
         Calendar d55=new GregorianCalendar();
         Date   d5=null;
         try{ //一定要放到try里面,不然会报错的
             d5   =   sdf.parse(Date5);  
          }
          catch(Exception e){
          }
         d55.setTime(d5);
         d55.add(Calendar.DAY_OF_MONTH, 1);
         Date6=df.format(d55.getTime()).toString();
         //第七天日期
         Calendar d66=new GregorianCalendar();
         Date   d6=null;
         try{ //一定要放到try里面,不然会报错的
             d6   =   sdf.parse(Date6);  
          }
          catch(Exception e){
          }
         d66.setTime(d6);
         d66.add(Calendar.DAY_OF_MONTH, 1);
         Date7=df.format(d66.getTime()).toString();
                    
//
         hotel = Server.getInstance().getHotelService().findHotel(hotelid) ;
         cityId = hotel.getCityid();
 		
 		     
         
         
         

       
	
		
		
	s_num = dateDiff(endDate.trim(), startDate.trim());
	hotel = Server.getInstance().getHotelService().findHotel(hotelid);
	//long	cityId = hotel.getCityid();
	listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" where 1=1 and "+Roomtype.COL_hotelid+" ="+hotelid+" and "+Roomtype.COL_id+" ="+roomid, " ORDER BY ID ", -1, 0);
	roomtype = listRoomtype.get(0);
	System.out.println("roomtype=="+roomtype);
	//算出开始天数到结束天数的总价
	String snian=	startDate.substring(0,7);//开始yue
	String enian=	endDate.substring(0,7);//开始yue
	
	StringBuilder wher = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+roomid+" and "+Hotelprice.COL_hotelid+"= "+hotelid +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");

	//StringBuilder wher = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+roomid+" and "+Hotelprice.COL_hotelid+"= "+hotelid);
	System.out.println("wher==="+wher);
	ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wher.toString()," ORDER BY C_DATENUMBER ",-1,0);
	int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
	System.out.println("startmethod=="+startmethod);
	int s=	Integer.parseInt(startDate.substring(8,10));//开始天
	System.out.println("开始天ssss=="+s);
	int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
	System.out.println("结束月endDatemethod=="+endDatemethod);
	int f=	Integer.parseInt(endDate.substring(8,10));//结束天
	int d = f-1;
	System.out.println("结束天dddd=="+d);
	zongjia =0;
	///
	City city=Server.getInstance().getHotelService().findCity(cityId);
	

	
	
		
		
		
		/*if(hotel.getRulesback()!=null){
		Hotelrebate =Double.parseDouble(hotel.getRulesback())/100;
		}*/
		pricecode="NO";
		System.out.println("本地酒店,返点==="+Hotelrebate);
	if(startmethod == endDatemethod){//如果在相同月份的话
	System.out.println("月份相同");
		for(int a=s;a<=d;a++){
			
			String mnane = "getNo"+a;
			Class[] types = new Class[]{};
			Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
			Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
			Double price = ((Double)aa).doubleValue();
			int pp=	(int)Math.floor(price);
			//Double	pric = price;
			zongjia +=pp;
			System.out.println("zongjia=="+zongjia);
			
		
				String	asas ="<td align=\"center\" width=\"68\" title="+startmethod+"月"+ a+"号 style=\"color:#000;background-color:#fff;width:59px;background-image:url(images/dateimg/"+a+".gif);height:28px;background-repeat:no-repeat;background-position:left top;  \"><b><font class='font14'>￥</font>&nbsp;"+pp+"</b></td>";
				Listroomtypeprice.add(asas);
			
			
			
				Listprice.add(pp);
			}
	}else{//开始月分份和结束月份不在一个月
		
		System.out.println("月份不不不相同");
		if(endDatemethod > startmethod){
			System.out.println("月份不不不相同并且结束月大如开始月份");
			java.util.GregorianCalendar c =(GregorianCalendar) GregorianCalendar.getInstance();
			c.isLeapYear(c.get(c.YEAR));
			int startdate=31;
			if(startmethod==1){
				
				 startdate=31;
			}
			
			if(startmethod==2){
				if(c.isLeapYear(c.get(c.YEAR))==true){
				
				  startdate=29;
				}else{
					
					 startdate=28;
				}
			}
			
			if(startmethod==3){
				
				  startdate=31;
			}
			if(startmethod==4){
				
				  startdate=30;
			}
			if(startmethod==5){
				
				  startdate=31;
			}
			if(startmethod==6){
				
				  startdate=30;
			}
			if(startmethod==7){
				
				  startdate=31;
			}
			if(startmethod==8){
				
				  startdate=31;
			}
			if(startmethod==9){
				
				  startdate=30;
			}
			if(startmethod==10){
				
				  startdate=31;
			}
			if(startmethod==11){
				
				  startdate=30;
			}
			if(startmethod==12){
				
				  startdate=30;
			}
			
			for(int a=s;a<=startdate;a++){
				
				String mnane = "getNo"+a;
				Class[] types = new Class[]{};
				Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
				Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
				Double price = ((Double)aa).doubleValue();
				
			//	String	asas =startmethod+"月"+ a+"号:"+price;
			//	System.out.println(asas);
				//int romid =(int) Roomtypeid;
				int pp=	(int)Math.floor(price);
				//Double	pric = price;
				zongjia +=pp;
				System.out.println("zongjia1=="+zongjia);
			//	Listroomtypeprice.add(asas);
			//	String	asas =startmethod+"月"+ a+"号"+"<br/><span style=\"color:#ff0000; font-weight: bold;\"><font class='font14'>￥</font>"+pp+"</span>";
				
				
				
					String	asas ="<td align=\"center\" width=\"68\" title="+startmethod+"月"+ a+"号 style=\"color:#000;background-color:#fff;width:59px;background-image:url(images/dateimg/"+a+".gif);height:28px;background-repeat:no-repeat;background-position:left top;  \"><b><font class='font14'>￥</font>&nbsp;"+pp+"</b></td>";
					Listroomtypeprice.add(asas);
				
				
				
				Listprice.add(pp);
				}
			for(int a=1;a<=d;a++){
				
				String mnane = "getNo"+a;
				Class[] types = new Class[]{};
				Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
				
				Object aa = method.invoke(ListHotelprice.get(1), new Object[0]);
				Double price = ((Double)aa).doubleValue();
				
			//	String	asas =endDatemethod+"月"+ a+"号:"+price;
			//	System.out.println(asas);
				//int romid =(int) Roomtypeid;
				int pp=	(int)Math.floor(price);
				//Double	pric = price;
				zongjia +=pp;
				System.out.println("zongjia2=="+zongjia);
			//	Listroomtypeprice.add(asas);
				//String	asas =endDatemethod+"月"+ a+"号"+"<br/><span style=\"color:#ff0000; font-weight: bold;\"><font class='font14'>￥</font>"+pp+"</span>";
				
			
					String	asas ="<td align=\"center\" width=\"68\" title="+startmethod+"月"+ a+"号 style=\"color:#000;background-color:#fff;width:59px;background-image:url(images/dateimg/"+a+".gif);height:28px;background-repeat:no-repeat;background-position:left top;  \"><b><font class='font14'>￥</font>&nbsp;"+pp+"</b></td>";
					Listroomtypeprice.add(asas);
				
				Listprice.add(pp);
				}	
			
		}
		
		
	}
	
	
	System.out.println("zongjia=="+zongjia);
	
	HotelPos=GetHotelValueByStar(hotel.getStar().toString(), Float.parseFloat(zongjia+""));
	System.out.println("HotelPos=="+HotelPos);
	//HotelPos
	//
	//System.out.println("hotel=="+hotel);
	//System.out.println("Listroomtypeprice=="+Listroomtypeprice);
 		
 		
 		//
	//Object memberid = ActionContext.getContext().getSession().get("memberid");
	//取出常用旅客list...目前写死的ID=62...以后从session里面取
	//listCustomerpassenger = Server.getInstance().getMemberService().findAllCustomerpassenger(" where 1=1 and "+Customerpassenger.COL_type+" =2"+" and "+Customerpassenger.COL_customeruserid+" ="+getOrderUserLogin().getId(), " ORDER BY ID ", 8, 0);
	
		return "toyuding";
	}
	
	
//预订酒店
// 预订酒店的入住人名字
private String username;
//预订酒店的入住人电话
private String mobile;
//
private Timestamp startDate2;
private Timestamp endDate2;
//
private String qiday;
private Hotelorder hotelorder = new Hotelorder();
public String yuding()throws Exception {
	Customeruser muser = new Customeruser();

		 muser = Server.getInstance().getMemberService().findCustomeruser(getLoginUser().getId());

		
	

	/*if(muser.getMembername()==null){
		
		muser.setMembername(hotelorder.getLinkname());
		
	}
	if(muser.getMemberemail()==null){
		
		muser.setMemberemail(hotelorder.getLinkmail());
		
	}
	
	muser.setMobile(hotelorder.getLinkmobile());
	if(muser.getMembersex()==null){
		
		muser.setMembersex(hotelorder.getSex());
	}
	Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(muser);*/
	muser= Server.getInstance().getMemberService().findCustomeruser(muser.getId());
	ActionContext.getContext().getSession().put("orderuserlogin", muser);
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date time = df.parse(startDate);
Date time2 = df.parse(endDate);
long manyday = (time2.getTime()-time.getTime())/(24*3600*1000);
int  many = (int)manyday;
Roomtype rm= Server.getInstance().getHotelService().findRoomtype(hotelorder.getRoomid());
//String roomcode = rm.getRoomdesc();
Hotel hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
cityId=hotel.getCityid();
Float rvaule =1F;
Float pr=0f;
Customeruser  customeruser =getOrderUserLogin();
Customeragent customeragent = Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());//当前登录者所属
//List<Rebaterule>list=Server.getInstance().getMemberService().findAllRebaterule(" where 1=1 and "+Rebaterule.COL_ruletypeid+" =2 and "+Rebaterule.COL_agenttypeid+" ="+customeragent.getAgentjibie(), "", -1, 0);
//if(list.size()>0){
//	rvaule = list.get(0).getRebatvalue();	
//}

//pr=Double.valueOf(formatMoney_short(Double.valueOf(hotelorder.getPrice())*6/100+""));

//pr=	GetHotelPriceValueByStar(hotel.getStar().toString(), Float.parseFloat(hotelorder.getPrice()));

	hotelorder.setManyday(many);
	hotelorder.setNumber(hotelorder.getNumber());
	hotelorder.setDanbao(0);
	hotelorder.setYestate(0);//0,未夜审 1,已夜审,全部正常 2,已也审,非正常 
	hotelorder.setSex(hotelorder.getSex());
	hotelorder.setRoomtypename(rm.getName());
	hotelorder.setPaystate(0l);//0未支付,1已支付,2已退款
	hotelorder.setRoomid(rm.getId());
	hotelorder.setComedate((new Timestamp(time.getTime())));
	hotelorder.setLeavedate((new Timestamp(time2.getTime())));
	hotelorder.setConfirmmethod(hotelorder.getConfirmmethod());
	hotelorder.setLinkmail(hotelorder.getLinkmail());
	hotelorder.setSpecreq(hotelorder.getSpecreq());
	hotelorder.setLinkmobile(hotelorder.getLinkmobile());
	hotelorder.setLinkname(hotelorder.getLinkname());
	hotelorder.setLinktell(hotelorder.getLinktell());
	Float uservaleu=GetHotelValueByStar(hotel.getStar().toString(), Float.parseFloat(hotelorder.getPrice()));
	hotelorder.setFanprice(Double.parseDouble(uservaleu.toString()));//Createuserid的利润
	hotelorder.setPrice(Double.valueOf(hotelorder.getPrice())+"");
	hotelorder.setActualmount(Double.parseDouble(hotelorder.getPrice()));
	hotelorder.setCreateuserid(getLoginUser().getId());
	

	hotelorder.setMembername(getLoginUser().getMembername()+"");
	hotelorder.setMemberid(getLoginUser().getId());
	hotelorder.setType(2);//1.B2C  2.B2B
	
	hotelorder.setReservstart(hotelorder.getReservstart());
	hotelorder.setReservend(hotelorder.getReservend());
	hotelorder.setPretime(new Timestamp(System.currentTimeMillis()));
	hotelorder.setHotelid(hotelorder.getHotelid());
	//hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
	hotelorder.setPaytype(1l);//1现付,2预付
	hotelorder.setChecktype(hotel.getChecktype());
	hotelorder.setReservstart(hotelorder.getReservstart());
	hotelorder.setReservend(hotelorder.getReservend());
	hotelorder.setDayprice(hotelorder.getDayprice());
	hotelorder.setRoomid(hotelorder.getRoomid());
	hotelorder.setPrerooms(hotelorder.getPrerooms());
	hotelorder.setState(0);
	hotelorder.setName(hotel.getName());
	hotelorder.setRoomtypename(hotelorder.getRoomtypename());
	String[] strarrGuest=InRoomPeople.split(",");
	String[] strarrGuestmobile=InRoommobile.split(",");
	//String[] strarrInRoomCountry=InRoomCountry.split(",");
	//String[] strarrGuestsex=hidsex.split(",");
	for(int i=0;i<strarrGuest.length;i++)
	{   
		if(strarrGuest[i]!=null && !strarrGuest[i].toString().equals(" "))
		{
			add++;
		}
	}
	hotelorder.setOrderpeaple(add);
	
	
	hotelorder.setPricecodeid(pricecode);//价格计划ID
	hotelorder=Server.getInstance().getHotelService().createHotelorder(hotelorder);
	
	//测试下单返利采用...以后返利在定时任务才执行..
	//getrebatetouser(hotelorder.getProfits()+"", hotelorder.getId()+"", "2");//添加各级返利记录
	
	
	//Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
	List<Guest>listgu=new ArrayList<Guest>();
	for(int i=0;i<strarrGuest.length;i++)
	{   
		if(strarrGuest[i]!=null && !strarrGuest[i].toString().equals(" "))
		{	Guest guest=new Guest();
			guest.setMemo(hotelorder.getConfirmmethod()+"");
			guest.setLanguage(0);
			guest.setOrderid(hotelorder.getId());
			guest.setMobile(strarrGuestmobile[i]);
			guest.setSex(2l);
			guest.setName(strarrGuest[i]);
			guest.setCountry("中国");
			guest.setRuzhutime(hotelorder.getComedate());
			guest.setLikaitime(hotelorder.getLeavedate());
			guest.setState(1l); //1，正常 2,提前离店 3,延住 4,取消
			guest.setPrice(hotelorder.getDayprice());
			guest=Server.getInstance().getHotelService().createGuest(guest);
			listgu.add(guest);
		}
	}
	
//添加信用卡信息
	
	
	if(cardno!=null&&cardno.trim().length()>0){
	Creditcard creditcard=new Creditcard();
	
	creditcard.setHotelorderid(hotelorder.getId());
	creditcard.setCardmonth(cardmonth);
	creditcard.setCardyear(cardyear);
	creditcard.setCardname(cardname);
	creditcard.setIdno(idno);
	creditcard.setIdtype(idtype);
	creditcard.setCreditbank(cardyhangname);//
	creditcard.setCreditnumber(cardno);
	creditcard.setCreditcheckcode(cardcvv);//CVV
	Server.getInstance().getMemberService().createCreditcard(creditcard);
	}
	
String hoteladdress = hotel.getAddress();
String hoteltel = hotel.getTortell();
if(hoteltel==null){
	hoteltel="";
}

//String wcode=Server.getInstance().getHotelInterService().CreateHotelOrder(hotelorder, listgu);
/*if(wcode!=null&&!wcode.equals("-1")&&wcode.indexOf("@")!=-1){
	System.out.println("今日酒店下单成功:");
	hotelorder.setState(1);
	hotelorder.setWaicode(wcode.split("@")[0].trim());
	hotelorder.setProfits(Double.parseDouble(wcode.split("@")[1].trim()));//订单总利润
	
}else{
	hotelorder.setWaicode(wcode);
	hotelorder.setState(88);
	System.out.println("今日酒店下单失败:");
}*/
String wcode=Server.getInstance().getHotelInterService().CreateHotelOrder(hotelorder, listgu);
System.out.println("waicode:"+wcode);

if(wcode!=null&&!wcode.equals("-1")){
	System.out.println("elong酒店下单成功:");
	hotelorder.setState(1);
	hotelorder.setWaicode(wcode.trim());
//	hotelorder.setProfits(Double.parseDouble(wcode.split("@")[1].trim()));//订单总利润
	
}else{
	hotelorder.setWaicode(wcode);
	hotelorder.setState(88);
	System.out.println("elong酒店下单失败:");
}

Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);



	
	

	
	/*String smstemple="";
	smstemple=this.getSMSTemple("HOrderSuccess");
	smstemple=smstemple.replaceAll("@CustomerName@", hotelorder.getLinkname().replace("$", "\\$"));

	smstemple=smstemple.replaceAll("@reserve_date@",formatDate(hotelorder.getComedate()).toString());
	smstemple=smstemple.replaceAll("@hotel_name@",hotelorder.getName()+"("+hotelorder.getRoomtypename()+")");
	smstemple=smstemple.replaceAll("@room_type_rmdy@",hotelorder.getManyday()+"间"+hotelorder.getManyday());

	smstemple=smstemple.replaceAll("@OrderId@", hotelorder.getOrderid());

	this.smsSend(new String[] { "" + hotelorder.getLinkmobile() + "" },smstemple, "", getLoginUserId() + "");
	*/
	String smstemple="您的酒店已预订成功!";
	//this.smsSend(new String[]{""+orderinfo.getContactmobile()+""} , smstemple, orderinfo.getOrdernumber()+"-"+orderinfo2.getOrdernumber());
	Ymsend ymsend=new Ymsend();
	ymsend.setContent(smstemple);
	ymsend.setCreatetime(new Timestamp(System.currentTimeMillis()));
	ymsend.setOrdercode("");
	ymsend.setPhone(hotelorder.getLinkmobile());
	ymsend.setType(2);
	ymsend.setState(0l);
	//Server.getInstance().getMemberService().createYmsend(ymsend);
	//System.out.println(smstemple);
	//forword ="hoteluserbook!took.action?hotelid="+hotelorder.getHotelid()+"&hotelorderid="+hotelorder.getId()+"&endDate="+endDate+"&startDate="+startDate;

	//getgejifan(2, hotelorder);
	
	
	if(hotelorder.getState()==1){
		forword ="hoteluserbook!took.action?hotelid="+hotelorder.getHotelid()+"&hotelorderid="+hotelorder.getId()+"&endDate="+endDate+"&startDate="+startDate;
		}else{
			Server.getInstance().getHotelService().deleteHotelorder(hotelorder.getId());
			Server.getInstance().getHotelService().excuteGuestBySql(" DELETE "+Guest.TABLE+" where "+Guest.COL_orderid+" ="+hotelorder.getId());
			
		forword ="hoteluserbook!toshibai.action";
		
		}
	

	return "took";
//}










//return "yudingok";
		
	}
public String toshibai()throws Exception{
	
		return "shibai";
}

public String took()throws Exception{
	
	
	hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorderid);
	hotel = Server.getInstance().getHotelService().findHotel(hotelid);

	s_num = dateDiff(endDate.trim(), startDate.trim());
	
	junjia=Double.parseDouble(hotelorder.getPrice())/s_num;
	listGuest = Server.getInstance().getHotelService().findAllGuest("where 1=1 and "+Guest.COL_orderid+" ="+hotelorderid, " ORDER BY ID ", -1, 0);
	
	
	cityId = hotel.getCityid();


		return "yudingok";
		
	
	
	
	
}
	
	
	public String getBiz(Long id){
		List<Region> list = Server.getInstance().getHotelService().findAllRegion(" WHERE " + Region.COL_regionid + " = " + id +" AND "+Region.COL_type+"='商业区'"," ORDER BY ID",3,0);
		StringBuilder sb = new StringBuilder();
		for (Region r : list) {
			sb.append(r.getName()).append(" ");
		}
		return sb.toString();
	}
	//获取酒店优惠信息
	public String gethotelspec(Long id,String startDate,String endDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		if(startDate == null) {
			startDate = sdf.format(new Date()) ;
		}
		if(endDate == null) {
			endDate = sdf.format(new Date()) ;
		}
		List<Hotelspec> list = Server.getInstance().getHotelService().findAllHotelspec(" where 1=1 and "+Hotelspec.COL_startdate+" <'"+startDate+"' and "+Hotelspec.COL_enddate+" >'"+endDate+"' and "+Hotelspec.COL_hotelid+" ="+id," ORDER BY ID",-1,0);
		String	hotelspec="";
		if(list.size()>0){
			hotelspec =list.get(0).getDescription();
		}
		
		/*StringBuilder sb = new StringBuilder();
		for (Hotelspec r : list) {
			sb.append(r.getName()).append(" ");
		}*/
		return hotelspec;
	}

	// 根据房型ID取价格说明
	public String getpricedescription(int id) {
		
		List<Hotelprice> list=	Server.getInstance().getHotelService().findAllHotelprice("where 1=1 and "+Hotelprice.COL_roomid+" = "+id, " ORDER BY ID ", -1, 0);
		
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return list.get(0).getDescription();
				
	}
	// 根据房型ID取,门市价
	public String getdeptprice(int id) {//目前改成 当前价格*1.2
		
		List<Hotelprice> list=	Server.getInstance().getHotelService().findAllHotelprice("where 1=1 and "+Hotelprice.COL_roomid+" = "+id+"and "+Hotelprice.COL_hotelid+" ="+hotelid, " ORDER BY ID ", -1, 0);
		
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return list.get(0).getDeptprice();
				
	}
	public Double getdeptprice2(String price) {//目前改成 当前价格*1.2
		//System.out.println("==="+price);
		//price = price.trim().replace("￥", "");
		Double p = Double.parseDouble(price);
		
		return p*1.2;
				
	}
	public Double getfandian(String price) {//目前改成 当前价格*1.2
		price = price.trim().replace("￥", "");
		Double p = Double.parseDouble(price);
		
		return p*0.05;
				
	}
	public List getView(Long id){
		return Server.getInstance().getHotelService().findAllRegion(" WHERE " + Region.COL_regionid + " = " + id +" AND "+Region.COL_type+"='景区'"," ORDER BY ID",5,0);
	}
	/**
	 * 跳转至酒店详细信息页面
	 * @return
	 * @throws Exception
	 */

	public String toDetail() throws Exception {
		//周几信息
		
		SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd");        
        Date InDate1 =df.parse(startDate.trim());
        Date1=startDate.trim();
        
        Calendar d11=new GregorianCalendar();
        Date   d1=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
        String baseDate=startDate.trim() ;//入住日期
        try{ //一定要放到try里面,不然会报错的
            d1   =   sdf.parse(baseDate);  
         }
         catch(Exception e){
         }
         d11.setTime(d1);
         
         //第二天日期
         d11.add(Calendar.DAY_OF_MONTH, 1);
         Date2=df.format(d11.getTime()).toString();
         System.out.println(Date2);
         //第三天日期
         Calendar d22=new GregorianCalendar();
         Date   d2=null;
         try{ //一定要放到try里面,不然会报错的
             d2   =   sdf.parse(Date2);  
          }
          catch(Exception e){
          }
          d22.setTime(d2);
         d22.add(Calendar.DAY_OF_MONTH, 1);
         Date3=df.format(d22.getTime()).toString();
         //第四天日期
         Calendar d33=new GregorianCalendar();
         Date   d3=null;
         try{ //一定要放到try里面,不然会报错的
             d3   =   sdf.parse(Date3);  
          }
          catch(Exception e){
          }
         d33.setTime(d3);
         d33.add(Calendar.DAY_OF_MONTH, 1);
         Date4=df.format(d33.getTime()).toString();
         //第五天日期
         Calendar d44=new GregorianCalendar();
         Date   d4=null;
         try{ //一定要放到try里面,不然会报错的
             d4   =   sdf.parse(Date4);  
          }
          catch(Exception e){
          }
         d44.setTime(d4);
         d44.add(Calendar.DAY_OF_MONTH, 1);
         Date5=df.format(d44.getTime()).toString();
         //第六天日期
         Calendar d55=new GregorianCalendar();
         Date   d5=null;
         try{ //一定要放到try里面,不然会报错的
             d5   =   sdf.parse(Date5);  
          }
          catch(Exception e){
          }
         d55.setTime(d5);
         d55.add(Calendar.DAY_OF_MONTH, 1);
         Date6=df.format(d55.getTime()).toString();
         //第七天日期
         Calendar d66=new GregorianCalendar();
         Date   d6=null;
         try{ //一定要放到try里面,不然会报错的
             d6   =   sdf.parse(Date6);  
          }
          catch(Exception e){
          }
         d66.setTime(d6);
         d66.add(Calendar.DAY_OF_MONTH, 1);
         Date7=df.format(d66.getTime()).toString();
                    
//
		//getCommandHotelList(cityId);
		hotel = Server.getInstance().getHotelService().findHotel(hotelid) ;
		List<Hotelimage> ListHotelimg =Server.getInstance().getHotelService().findAllHotelimage("where 1=1 and "+Hotelimage.COL_hotelid+" ="+hotelid, " ORDER BY ID ", -1, 0);
		if(ListHotelimg!=null){
			for(int a=0;a<ListHotelimg.size();a++){
				String imges[] =ListHotelimg.get(a).getPath().split("@");
				if(imges!=null&&imges.length>0){
					for(int b=0;b<imges.length;b++){
						if(imges[b]!=null&&imges[b].trim().length()>0){
						Hotelimage hotelimage=new Hotelimage();
						hotelimage.setPath(imges[b]);
						ListHotelimage.add(hotelimage);
						}
					}
				}
			}
		}
		
		
		
		
		s_citycode=Server.getInstance().getHotelService().findCity(cityId).getCarcode();
		s_num = dateDiff(endDate.trim(), startDate.trim());
		
		
	
		
	
		
		//结束
		
	
	
		

		
		return "detail";
	}
	/**
	 * 跳转至酒店详细信息页面
	 * @return
	 * @throws Exception
	 */

	public String toDetail_zhuna() throws Exception {
		//周几信息
		
		SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd");        
        Date InDate1 =df.parse(startDate.trim());
        Date1=startDate.trim();
        
        Calendar d11=new GregorianCalendar();
        Date   d1=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
        String baseDate=startDate.trim() ;//入住日期
        try{ //一定要放到try里面,不然会报错的
            d1   =   sdf.parse(baseDate);  
         }
         catch(Exception e){
         }
         d11.setTime(d1);
         
         //第二天日期
         d11.add(Calendar.DAY_OF_MONTH, 1);
         Date2=df.format(d11.getTime()).toString();
         System.out.println(Date2);
         //第三天日期
         Calendar d22=new GregorianCalendar();
         Date   d2=null;
         try{ //一定要放到try里面,不然会报错的
             d2   =   sdf.parse(Date2);  
          }
          catch(Exception e){
          }
          d22.setTime(d2);
         d22.add(Calendar.DAY_OF_MONTH, 1);
         Date3=df.format(d22.getTime()).toString();
         //第四天日期
         Calendar d33=new GregorianCalendar();
         Date   d3=null;
         try{ //一定要放到try里面,不然会报错的
             d3   =   sdf.parse(Date3);  
          }
          catch(Exception e){
          }
         d33.setTime(d3);
         d33.add(Calendar.DAY_OF_MONTH, 1);
         Date4=df.format(d33.getTime()).toString();
         //第五天日期
         Calendar d44=new GregorianCalendar();
         Date   d4=null;
         try{ //一定要放到try里面,不然会报错的
             d4   =   sdf.parse(Date4);  
          }
          catch(Exception e){
          }
         d44.setTime(d4);
         d44.add(Calendar.DAY_OF_MONTH, 1);
         Date5=df.format(d44.getTime()).toString();
         //第六天日期
         Calendar d55=new GregorianCalendar();
         Date   d5=null;
         try{ //一定要放到try里面,不然会报错的
             d5   =   sdf.parse(Date5);  
          }
          catch(Exception e){
          }
         d55.setTime(d5);
         d55.add(Calendar.DAY_OF_MONTH, 1);
         Date6=df.format(d55.getTime()).toString();
         //第七天日期
         Calendar d66=new GregorianCalendar();
         Date   d6=null;
         try{ //一定要放到try里面,不然会报错的
             d6   =   sdf.parse(Date6);  
          }
          catch(Exception e){
          }
         d66.setTime(d6);
         d66.add(Calendar.DAY_OF_MONTH, 1);
         Date7=df.format(d66.getTime()).toString();
                    
//
		//getCommandHotelList(cityId);
		hotel = Server.getInstance().getHotelService().findHotel(hotelid) ;
		ListHotelimage =Server.getInstance().getHotelService().findAllHotelimage("where 1=1 and "+Hotelimage.COL_hotelid+" ="+hotelid, " ORDER BY ID ", -1, 0);
	
		
		s_num = dateDiff(endDate.trim(), startDate.trim());
		
		
	
		/*long id = hotel.getId();
		// 价格 p[0]最低价格  p[1]最高价格
		String[] p = null;
		if(priceType != -1) {
			p = getPrice(priceType).split("\\-");
		}
		StringBuilder wh = new StringBuilder(" where 1=1 and ID in (select C_ROOMID from "+Hotelprice.TABLE+" where C_HOTELID= ");
		wh.append(id);
		wh.append(" and C_DATENUMBER ='");
		wh.append(startDate.trim().substring(0,7));
		wh.append("' and C_NO");
		wh.append(Integer.parseInt(startDate.substring(8,10)));
		wh.append(" >= ");
		wh.append(p[0]);
		wh.append(" and C_NO");
		wh.append(Integer.parseInt(startDate.substring(8,10)));
		wh.append(" <= ");
		wh.append(p[1]);
		
		wh.append(")");
		System.out.println("wh==="+wh.toString());
		ListRoomtype1 = Server.getInstance().getHotelService().findAllRoomtype(wh.toString()," ORDER BY ID ",-1,0);
		String snian=	startDate.substring(0,7);//开始yue
		String enian=	endDate.substring(0,7);//开始yue
		s_num = dateDiff(endDate.trim(), startDate.trim());*/
		
		/*for(Roomtype r : ListRoomtype1){
			Listroomtypeprice=new ArrayList();
			long Roomtypeid = r.getId();
			long Hotelid = r.getHotelid();
			
			StringBuilder where = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+Roomtypeid+" and "+Hotelprice.COL_hotelid+"= "+Hotelid +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");
				System.out.println("where==="+where);
			ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(where.toString()," ORDER BY C_DATENUMBER ",-1,0);
			System.out.println("ListHotelprice=="+ListHotelprice);
			int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
			System.out.println("startmethod=="+startmethod);
			int s=	Integer.parseInt(startDate.substring(8,10));//开始天
			System.out.println("开始天ssss=="+s);
			int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
			System.out.println("结束月endDatemethod=="+endDatemethod);
			int f=	Integer.parseInt(endDate.substring(8,10));//结束天
			int d = f-1;
			System.out.println("结束天dddd=="+d);
			if(startmethod == endDatemethod){//如果在相同月份的话
				if(ListHotelprice.size()>0){
			System.out.println("月份相同");
				for(int a=s;a<=d;a++){
					String mnane = "getNo"+a;
					Class[] types = new Class[]{};
					Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
					Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
					Double price = ((Double)aa).doubleValue();
					int pp=	(int)Math.floor(price);
						String	asas =startmethod+"月"+ a+"号:￥"+pp;
						Listroomtypeprice.add(asas);
					}
				mapRoomprice.put(Roomtypeid, Listroomtypeprice);//房型对应的价格
				System.out.println("mapRoomprice==等于="+mapRoomprice);
				}
			}else{//开始月分份和结束月份不在一个月
				if(ListHotelprice.size()>0){
				System.out.println("月份不不不相同");
				if(endDatemethod > startmethod){
					System.out.println("月份不不不相同并且结束月大如开始月份");
					
					java.util.GregorianCalendar c =(GregorianCalendar) GregorianCalendar.getInstance();
					c.isLeapYear(c.get(c.YEAR));
					int startdate=31;
					if(startmethod==1){
						
						 startdate=31;
					}
					if(startmethod==2){
						if(c.isLeapYear(c.get(c.YEAR))==true){
						
						  startdate=29;
						}else{
							
							 startdate=28;
						}
					}
					if(startmethod==3){
						
						  startdate=31;
					}
					if(startmethod==4){
						
						  startdate=30;
					}
					if(startmethod==5){
						
						  startdate=31;
					}
					if(startmethod==6){
						
						  startdate=30;
					}
					if(startmethod==7){
						
						  startdate=31;
					}
					if(startmethod==8){
						
						  startdate=31;
					}
					if(startmethod==9){
						
						  startdate=30;
					}
					if(startmethod==10){
						
						  startdate=31;
					}
					if(startmethod==11){
						
						  startdate=30;
					}
					if(startmethod==12){
						
						  startdate=30;
					}
					
					
					
					
					for(int a=s;a<=startdate;a++){
						
						String mnane = "getNo"+a;
						Class[] types = new Class[]{};
						Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
						
						Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
						Double price = ((Double)aa).doubleValue();
						int pp=	(int)Math.floor(price);
						
					
							String	asas =startmethod+"月"+ a+"号:￥"+pp;
							
							Listroomtypeprice.add(asas);
						
						
						
						
						}
					mapRoomprice.put(Roomtypeid, Listroomtypeprice);//房型对应的价格
					System.out.println("mapRoomprice1==等于="+mapRoomprice);
					for(int a=1;a<=d;a++){
						
						String mnane = "getNo"+a;
						Class[] types = new Class[]{};
						Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
						//000
						if(ListHotelprice.size()>1){
								Object aa = method.invoke(ListHotelprice.get(1), new Object[0]);
								Double price = ((Double)aa).doubleValue();
								int pp=	(int)Math.floor(price);
								
							
									String	asas =endDatemethod+"月"+ a+"号:￥"+pp;
									
									Listroomtypeprice.add(asas);
								
						}
					
						}	
					mapRoomprice.put(Roomtypeid, Listroomtypeprice);//房型对应的价格
					System.out.println("mapRoomprice2==等于="+mapRoomprice);
					}
				}
			
			}
			
			mapRoomprice.put(Roomtypeid, Listroomtypeprice);//房型对应的价格
			System.out.println("mapRoomprice==等于="+mapRoomprice);	
			mapPrice.put(new Long(Roomtypeid),ListHotelprice);
		}*/
		
	
		
		//以下为住哪实时价格查询
	/*	String response=GetZhuNaHotelRoomPriceByHotelcode(hotel.getHotelcode(), startDate, endDate);
		
		
		if(response.indexOf("zid")!=-1&&response.indexOf("rid")!=-1&&response.indexOf("day")!=-1&&response.indexOf("price")!=-1&&response.indexOf("title")!=-1){
			
			
			response=response.replace("锘縱ar _Data=", "");
			response=response.replace(";if(callback){callback(_Data)}else{alert('Err:callback')}", "");
			JSONArray jsonObject = new JSONArray(response); 
			JSONObject josnobj = (JSONObject) jsonObject.get(0);
			String hid=josnobj.getString("zid");//酒店ID
		    String stime=josnobj.getString("tm1");//入住时间
		    String etime=josnobj.getString("tm2"); //离店时间  
		    String state=josnobj.getString("status"); //酒店状态  0是正常
		    String[] stingroom = response.split("\"rooms\":");
		    //解析房型
		    String josnroom=stingroom[1];
			    josnroom=josnroom.replace("}%", "");
		    JSONArray jsonObjectroom = new JSONArray(josnroom); 
		    
		    //初始化房型list
		    List<Roomtype> listR= new ArrayList<Roomtype>();
			    for(int a=0;a<jsonObjectroom.length();a++){
			    	Listroomtypeprice=new ArrayList();
				    JSONObject josnobjroom = (JSONObject) jsonObjectroom.get(a);
				  
				    String pricestring =jsonObjectroom.get(a).toString();
				   
				    pricestring=pricestring.replace("{\"plans\":", "");
				    String[] stingroompr = pricestring.split(",\"title\"");
				    pricestring=stingroompr[0];
				    
				    JSONArray jsonObjectprice = new JSONArray(pricestring); 
				    JSONObject josnobjpr = (JSONObject) jsonObjectprice.get(0);
				
				
				    
				    String pricrsr=pricestring.toString();
				    
				 
				    
				    String[] dateprice = pricrsr.split(",\"date\":");
				    pricrsr=dateprice[1];
				   // String[] datepricedeletemenshi = pricrsr.split(",\"jiangjin\"");
				   // pricrsr=datepricedeletemenshi[0];
				    //陈星关闭
				    
				    
				    
				   // System.out.println("pricrsr=="+pricrsr);
				    
				    //解析每天的价格
				    JSONArray jsonObjectdataprice = new JSONArray(pricrsr); 
				    JSONObject josnobjprdate = (JSONObject) jsonObjectdataprice.get(0);
				  //  System.out.println("jsonObjectdataprice的大小=="+jsonObjectdataprice.length());
				    
				    //房型开始
				    Roomtype roomtype = new Roomtype();
				    String whereroom=" where 1=1 and "+Roomtype.COL_name+" ='"+josnobjroom.get("title")+"' and "+Roomtype.COL_hotelid+" ="+hotel.getId()+" and "+Roomtype.COL_roomcode+" ='"+josnobjroom.get("rid")+"'";
				    List<Roomtype>listroomtype=Server.getInstance().getHotelService().findAllRoomtype(whereroom, " ORDER BY ID ", -1, 0);
				    if(listroomtype.size()>0){
				    	
				    	roomtype=listroomtype.get(0);
				    }
				    
				    roomtype.setName(josnobjroom.get("title").toString().trim());
				    roomtype.setHotelid(hotel.getId());
				    roomtype.setRoomcode(josnobjroom.get("rid").toString().trim());
				    String roomstatus="0";
				    if(josnobjroom.get("status").toString()!=null){
				    	roomstatus=josnobjroom.get("status").toString();//房型状态
				     System.out.println("roomstatus:"+roomstatus+",roomname:"+roomtype.getName()+",hotelname:"+hotel.getName());
				    }
				    roomtype.setState(Integer.parseInt(roomstatus));
				    String chuan = josnobjroom.get("bed").toString();
						roomtype.setBed(chuan);
					String kuan = josnobjroom.get("adsl").toString();
						roomtype.setWideband(kuan);
					String zao = josnobjpr.get("planname").toString();
						roomtype.setBreakfast(zao);
					roomtype.setLanguage(0);
					
					String planid = josnobjpr.get("planid").toString();//价格计划ID
					
					roomtype.setRoomset(planid);//价格计划ID
					  if(listroomtype.size()>0){
					    	
						  Server.getInstance().getHotelService().updateRoomtypeIgnoreNull(roomtype);
					    }else{
					      roomtype=Server.getInstance().getHotelService().createRoomtype(roomtype);
					    }
					  
					  listR.add(roomtype);
					 
				    //房型结束
					 //价格开始
					  
					  //初始化价格list
					  List listpr= new ArrayList();
					  for(int prlist=0;prlist<jsonObjectdataprice.length();prlist++){
				    	  JSONObject josnobjroomdayprice = (JSONObject) jsonObjectdataprice.get(prlist);
				    	  String pr=josnobjroomdayprice.getString("price");
				    	  String menshi=josnobjroomdayprice.getString("menshi");
				    	  String datenum=josnobjroomdayprice.getString("day");
				    	  String datenumber=datenum.substring(0, 7);
				    	  
				    	  
				    	  String[] datearray=datenum.trim().split("-");
				    	  String day="";
							if(datearray[2].substring(0,1).equals("0"))
							{
								day=datearray[2].substring(1);
							}else
							{
								day=datearray[2];
							}
							//
							Double price=0.0;
							System.out.println("hid:"+hotel.getId()+",roomid:"+roomtype.getId()+",day:"+day+",price:"+pr);
							if(pr.trim().equals("×")){
								if(menshi.toString().trim().equals("×")){
									
									pr="0.0";
								}else{
									pr=menshi.toString().trim();
								}
							}else{
								
								pr=pr.toString().trim();
							}
							//
							
							
							long hotelid=hotel.getId();
							long roomid=roomtype.getId();
							
							Hotelprice hotelprice = new Hotelprice();
							List<Hotelprice>listhotelprice=Server.getInstance().getHotelService().findAllHotelprice(" where 1=1 and "+Hotelprice.COL_hotelid+" ="+hotelid+" and "+Hotelprice.COL_datenumber+" ='"+datenumber+"' and "+Hotelprice.COL_roomid+" ="+roomid, "", -1, 0);
							if(listhotelprice.size()>0){
								hotelprice=listhotelprice.get(0);
								
							}
							hotelprice.setRateplancode(planid);//价格计划ID
							
							hotelprice.setDeptprice(menshi);
							hotelprice.setDatenumber(datenumber);
							hotelprice.setRoomid(roomid);
							hotelprice.setHotelid(hotelid);
							hotelprice.setLanguage(0);
							
							 try {
									Hotelprice.class.getMethod("setNo"+day,Double.class).invoke(hotelprice,Double.parseDouble(pr));
								} catch (NumberFormatException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SecurityException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (NoSuchMethodException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									
							if(listhotelprice.size()>0){
								Server.getInstance().getHotelService().updateHotelpriceIgnoreNull(hotelprice);
								
								
							}else{
								
								Server.getInstance().getHotelService().createHotelprice(hotelprice);
							}
							System.out.println("hotelprice:"+hotelprice);
							listpr.add(pr);
							//Listroomtypeprice.add(datenum.substring(5, datenum.length()).toString()+":"+pr);
							Listroomtypeprice.add("￥:"+pr);
							
							mapRoomprice.put(roomtype.getId(), Listroomtypeprice);//房型对应的价格
				    }
					  mapRoom.put(new Long(hotel.getId()),listR);
					
					  RoomListPrice.put(roomtype.getId(), listpr); 
			    }
			
			
		}*/
		
		//结束
		
		
		int index = 0 ;
		String 	serviceItem	= hotel.getServiceitem();
		if(serviceItem != null ) {
     		 String[] serviceItems = serviceItem.split("\\|") ;
     		 for(int i=index; i<serviceItems.length; i++) {
     			
     			listserviceItem.add(serviceItems[i]);
     			
     		}
     		System.out.println("listserviceItem=="+listserviceItem);
     	 }
		String 	footItem=	hotel.getFootitem();
		if(footItem != null ) {
     		 String[] footItems = footItem.split("\\|") ;
     		 for(int i=index; i<footItems.length; i++) {
     			
     			listfootItems.add(footItems[i]);
     			
     		}
     	System.out.println("listfootItems==="+listfootItems);
     		
     	 }
		String 	playItem =	hotel.getPlayitem();
		if(playItem != null ) {
     		 String[] playItems = playItem.split("\\|") ;
     		 for(int i=index; i<playItems.length; i++) {
     			
     			listplayItems.add(playItems[i]);
     			
     		}
     		System.out.println("listplayItems=="+listplayItems);
     	 }
	
		

		
		return "detail";
	}
	
	private int getMaxdate(String dateStr){
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("yyyy-MM").parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		return day;
	}
	/**
	 * 根据酒店ID获取对应图片路径
	 * @param hotelid
	 * @return  图片路径
	 */
	public String getImage(long hid) {
		Hotel hot = Server.getInstance().getHotelService().findHotel(hid);
		long hd;
		if(hot.getLanguage()!=0){
			if(Server.getInstance().getHotelService().findHotelbylanguage(hid, 0)==null){
				hd=hid;
			}else{
			 hd = Server.getInstance().getHotelService().findHotelbylanguage(hid, 0).getId();
			}
		}else{
			 hd = hid;
		}
		
		String where=" WHERE " + Hotelimage.COL_hotelid +" ="+hd;
		List<Hotelimage> listImages = Server.getInstance().getHotelService().findAllHotelimage(where, " ORDER BY ID" , -1, 0) ;
		if(listImages.size() > 0) {
			return listImages.get(0).getPath() ;
		}
		return "NoImage.gif" ;
	}
	/**
	 * 根据酒店ID获取对应图片路径
	 * @param hotelid
	 * @return  图片路径
	 */
	public String getImageWG(long hid) {
		
		
		String where=" WHERE " + Hotelimage.COL_hotelid +" ="+hid+" AND "+Hotelimage.COL_description+" like '%外观%'";
		List<Hotelimage> listImages = Server.getInstance().getHotelService().findAllHotelimage(where, " ORDER BY ID" , -1, 0) ;
		if(listImages.size() > 0) {
			return listImages.get(0).getPath() ;
		}else{
			
			String where2=" WHERE " + Hotelimage.COL_hotelid +" ="+hid+" AND "+Hotelimage.COL_description+" like '%大堂%'";
			List<Hotelimage> listImages2 = Server.getInstance().getHotelService().findAllHotelimage(where2, " ORDER BY ID" , -1, 0) ;
			if(listImages2.size() > 0) {
				return listImages2.get(0).getPath() ;
			}else{
				String where3=" WHERE " + Hotelimage.COL_hotelid +" ="+hid;
				List<Hotelimage> listImages3 = Server.getInstance().getHotelService().findAllHotelimage(where3, " ORDER BY ID" , -1, 0) ;
				if(listImages3.size()>0){
				return listImages3.get(0).getPath() ;
				}else{
					return "images/NoImage.gif" ;
				}
			}
		}
		
	}
	public String getStarico(Integer index)
	{
		/*StringBuffer buffer=new StringBuffer();
		for(int i=0;i<index/2;i++)
		{
			buffer.append("<img src=\"images/shixing.gif\" />");
		}
		if(index%2==0){
			buffer.append("<img src=\"images/kongxing.gif\" />");
		}else{
			buffer.append("<img src=\"images/shixing.gif\" />");
		} */
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<index;i++)
		{
			buffer.append("<img src=\"images/shixing.gif\" />");
		}
		return buffer.toString();
	}
	public String getshourijia(String shouri,long id)
	{
		System.out.println("id=="+id);
		String shourijia[] = shouri.split(":");
		System.out.println("shourijia[1]=="+shourijia[1].split("￥")[1]);
		//return shouri.substring(7,13);
		long hid = Server.getInstance().getHotelService().findRoomtype(id).getHotelid();
		if(Server.getInstance().getHotelService().findHotel(hid).getStar()!=null){
		int star = Server.getInstance().getHotelService().findHotel(hid).getStar();
			Double pr = gethotelstateprice(star);
			
			Double fprice = Long.parseLong(shourijia[1].split("￥")[1])*pr;
			
			Double pric = Long.parseLong(shourijia[1].split("￥")[1])-fprice;
			
			return pric+"";
		}
		
		return shourijia[1];
	}
	public String getshourijiashiji(String shouri)
	{
		
		String shourijia[] = shouri.split(":");
		
		//return shouri.substring(7,13);
		
		
		return shourijia[1].split("￥")[1];
	}
	public String getfan(String fanprice,String shijiprice)
	{
		
		
		
		return (Double.parseDouble(shijiprice)-Double.parseDouble(fanprice))+"";
	}
	////预付返利
	public String getyufan(String price)
	{
		
		
		
		return (Double.parseDouble(price)*0.1)+"";
	}
	//预付返利后价格
	public String getyufanprice(String price)
	{
		
		
		
		return (Double.parseDouble(price)-Double.parseDouble(getyufan(price)))+"";
	}
	//前台现付返利
	public String getxianfan(String price)
	{
		
		
		
		return (Double.parseDouble(price)*0.05)+"";
	}
	//现付返利后价格
	public String getxianfanprice(String price)
	{
		
		
		
		return (Double.parseDouble(price)-Double.parseDouble(getxianfan(price)))+"";
	}
	/**
	 * 根据酒店ID获取客房类型列表
	 * @param id
	 * @throws Exception
	 */
	public void setMapRoom(Long id) throws Exception {
		List<Roomtype> listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" WHERE "
				+ Roomtype.COL_hotelid + "=" + id, "", -1, 0) ;
		mapRoom.put(id, listRoomtype);
		for(Iterator<Roomtype> iter = listRoomtype.iterator(); iter.hasNext() ; ) {
     		Roomtype roomtype = iter.next() ;
     		if(roomtype.getState().intValue() != 1) {
     			continue ;
     		}
     		int daynum = 0 ; //天数
     		float salesroomPrice = 0f ; //门市价
     		float firstdayPrice = 0f ; //首日价 
			boolean isbid = false ; //是否被禁用
     		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    		Calendar comeCal = Calendar.getInstance() ;
    		comeCal.setTime(sdf.parse(startDate)) ;
    		Calendar leaveCal = Calendar.getInstance() ;
    		leaveCal.setTime(sdf.parse(endDate)) ;
    		String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
    				"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
    		String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
    				"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
    		String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
    			comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
    			"=" + roomtype.getId() ;
    		List<Hotelprice> prices = Server.getInstance().getHotelService().findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
    		Float priceSum = new Float(0) ;
    		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
    			daynum ++ ;
    			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
    			//是否设置值
    			Float priceValue = 0f ;
    			isbid = false ;
    			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
    				Hotelprice price = iterator.next() ;
    				if(price.getDeptprice() != null) {
    					salesroomPrice = Float.parseFloat(price.getDeptprice()) ;
    				}
    				if(price.getDatenumber().equals(comeStr)) {
    					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
    					priceValue = (Float)method.invoke(price, new Object[]{}) ;
    					if(sdf.format(comeCal.getTime()).equals(startDate)) {
    						firstdayPrice = priceValue ;
        				}
    					//判断该日期的价格是否被禁用
    					if(price.getIsvalid().charAt(day-1) == '1') {
							isbid = true ;
						}
    					break ;
    				}
    			}
    			if(priceValue == 0 || isbid) {
    				isbid = true ;
    				break ;
    			}
    			priceSum += priceValue ;
    			comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
    			comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
    					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
    		}
    		if(isbid) {
    			continue ;	
    		}
    		
    		//判断是否是满房
         	String where2 = " WHERE " + Roomstate.COL_roomtypeid + "=" + roomtype.getId() ;
			where2 += " AND " + Roomstate.COL_state + "=2 " + " AND (" 
				+ "(" + Roomstate.COL_startdate + ">=" + "CONVERT(date, '" + startDate + "')" + " AND " 
				+ Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + endDate + "'))"
				+ " OR (" + Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + startDate + "')" + " AND " 
				+ Roomstate.COL_enddate + "<=" + "CONVERT(date, '" + endDate + "'))"
				+ " OR (" + Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + startDate + "')" + " AND " 
				+ Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + endDate + "'))"
				+ ")" ;
				List<Roomstate> listRoomstates = Server.getInstance().getHotelService().findAllRoomstate(where2,"", -1, 0) ;
			if(listRoomstates != null && listRoomstates.size() > 0) {
				continue ;
			}
		}
	}
	
	/**
	 * 根据酒店星级获取对应字符串
	 * @param star
	 * @return
	 */
	public String outputStar(int star) {
		String temp = "";
		
		for (int i=0; i < star/2; i++) {
			temp += "★";
		}
		
		if (star%2 == 0) {
			temp += "☆";
		} else {
			temp += "★";
		}
		
		return temp;
	}
	/**
	 *  根据相应价格类型获取价格范围
	 * @param s 价格类型
	 * @return  价格范围
	 */
	public String getPrice(int s){
		if (s==0){
			return "0-1000000";
		} else if (s==1){
			return "0-200";
		} else if (s==2){
			return "200-400";
		} else if (s==3){
			return "400-600";
		} else if (s==4){
			return "600-100000";
		} else {
			return "0-1000000";
		}
	}
	
	/**
	 * 获取两个日期相减剩余天数
	 * @param d1 
	 * @param d2
	 * @return  天数
	 * @throws ParseException 
	 */
	public long dateDiff(String d1,String d2) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 =  df.parse(d1);
		Date date2 =  df.parse(d2);
		return (date1.getTime() - date2.getTime())/86400000; 
	}
	
	/**
	 * 
	 * 获取商业区名称
	 * @param id  地区代码
	 * @return  商业区名称
	 */
	public String getBizName(Long id){
		List<Region> list = Server.getInstance().getHotelService().findAllRegion
		(" WHERE " + Region.COL_id + " = " + id +" AND "+Region.COL_type+"='商业区'"," ORDER BY ID",1,0);
		if(!list.isEmpty()){
			return list.get(0).getName();
		}
		return "";
	}
	
	public String getctname(Long id){
		
		
		
			return Server.getInstance().getHotelService().findCity(id).getName();
	
	}

	public String quxiaoorder() throws Exception{
		
	Hotelorder hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorderid);
	Hotel hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());

		hotelorder.setState(6);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
	
		return "quxiao";
	}
	/**
	 * 根据酒店ID和客房ID获取会员价
	 * @param hotelId
	 * @param roomId
	 * @return 会员价
	 * @throws Exception
	 */
	public Integer getDatePrice(int hotelId,int roomId) throws Exception{
		if(hotelpriceList == null || hotelpriceList.isEmpty()){
			getDeptPrice(hotelId,roomId);
		}
		Hotelprice p =  hotelpriceList.get(0);
		BeanInfo info = Introspector.getBeanInfo(p.getClass());
		PropertyDescriptor descs[]=info.getPropertyDescriptors();
		String getName = "no"+Integer.parseInt(startDate.substring(8,10)); 
		for (int i=0; i<descs.length; i++){
			if(descs[i].getName().equalsIgnoreCase(getName)){
				Object o =  descs[i].getReadMethod().invoke(p);
				if(null == o)
					return null;
				else
					return ((Float)o).intValue();
			}
		}
		return null;
	}
	
	/**
	 * 根据酒店ID和客房ID获取门市价
	 * @param hotelId
	 * @param roomId
	 * @return  门市价
	 */
	public Integer getDeptPrice(int hotelId,int roomId){
		StringBuilder where = new StringBuilder(" where C_HOTELID = ");
		where.append(hotelId);
		where.append(" and C_ROOMID = ");
		where.append(roomId);
		hotelpriceList = Server.getInstance().getHotelService().findAllHotelprice(where.toString()," ORDER BY ID ",-1,0);
		if(!hotelpriceList.isEmpty())
			return Integer.valueOf(hotelpriceList.get(0).getDeptprice());
		return null;
	}
	/**
	 * 根据酒店ID和客房ID获取首日价
	 * @param hotelId
	 * @param roomId
	 * @return  首日价
	 */
	public Integer getshouriPrice(int hotelId)throws Exception{
		/*StringBuilder where = new StringBuilder(" where C_HOTELID = ");
		where.append(hotelId);
		where.append(" and C_ROOMID = ");
		where.append(roomId);
		hotelpriceList = Server.getInstance().getHotelService().findAllHotelprice(where.toString()," ORDER BY ID ",-1,0);
		if(!hotelpriceList.isEmpty())
			return Integer.valueOf(hotelpriceList.get(0).getDeptprice());*/
		return null;
	}
	
	public Integer Price(int hotelId,int roomId, String startDate,String endDate)throws Exception{
		
		//String hotelid = request.getParameter("hotelid") ;
		Hotel hotel = Server.getInstance().getHotelService().findHotel(new Long(hotelId)) ;
		List<Roomtype> listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" WHERE "
				+ Roomtype.COL_hotelid + "=" + hotelId, "", -1, 0) ;
	//	endDate startDate
		HttpServletRequest request;
		//String h_comedate = request.getParameter("h_comedate") ;
	//	String h_leavedate = request.getParameter("h_leavedate") ;
		if(startDate == null || startDate.trim().length() == 0 || endDate == null || endDate.trim().length() == 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
			Calendar now =  Calendar.getInstance() ;
			startDate = sdf.format(now.getTime()) ;
			now.add(Calendar.DAY_OF_MONTH, 1) ;
			endDate = sdf.format(now.getTime()) ;
		}
		
      	for(Iterator<Roomtype> iter = listRoomtype.iterator(); iter.hasNext() ; ) {
     		Roomtype roomtype = iter.next() ;
     		if(roomtype.getState().intValue() != 1) {
     			continue ;
     		}
     		int daynum = 0 ; //天数
     		float salesroomPrice = 0f ; //门市价
     		float firstdayPrice = 0f ; //首日价 
			boolean isbid = false ; //是否被禁用
     		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    		Calendar comeCal = Calendar.getInstance() ;
    		comeCal.setTime(sdf.parse(startDate)) ;
    		Calendar leaveCal = Calendar.getInstance() ;
    		leaveCal.setTime(sdf.parse(endDate)) ;
    		String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
    				"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
    		String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
    				"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
    		String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
    			comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
    			"=" + roomtype.getId() ;
    		List<Hotelprice> prices = Server.getInstance().getHotelService().findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
    		Float priceSum = new Float(0) ;
    		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
    			daynum ++ ;
    			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
    			//是否设置值
    			Float priceValue = 0f ;
    			isbid = false ;
    			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
    				Hotelprice price = iterator.next() ;
    				if(price.getDeptprice() != null) {
    					salesroomPrice = Float.parseFloat(price.getDeptprice()) ;
    				}
    				if(price.getDatenumber().equals(comeStr)) {
    					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
    					priceValue = (Float)method.invoke(price, new Object[]{}) ;
    					if(sdf.format(comeCal.getTime()).equals(startDate)) {
    						firstdayPrice = priceValue ;
        				}
    					//判断该日期的价格是否被禁用
    					if(price.getIsvalid().charAt(day-1) == '1') {
							isbid = true ;
						}
    					break ;
    				}
    			}
    			if(priceValue == 0 || isbid) {
    				isbid = true ;
    				break ;
    			}
    			priceSum += priceValue ;
    			comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
    			comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
    					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
    		}
    		if(isbid) {
    			continue ;	
    		}
    		
    		//判断是否是满房
         	String where2 = " WHERE " + Roomstate.COL_roomtypeid + "=" + roomtype.getId() ;
			where2 += " AND " + Roomstate.COL_state + "=2 " + " AND (" 
				+ "(" + Roomstate.COL_startdate + ">=" + "CONVERT(date, '" + startDate + "')" + " AND " 
				+ Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + endDate + "'))"
				+ " OR (" + Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + startDate + "')" + " AND " 
				+ Roomstate.COL_enddate + "<=" + "CONVERT(date, '" + endDate + "'))"
				+ " OR (" + Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + startDate + "')" + " AND " 
				+ Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + endDate + "'))"
				+ ")" ;
				List<Roomstate> listRoomstates = Server.getInstance().getHotelService().findAllRoomstate(where2,"", -1, 0) ;
			if(listRoomstates != null && listRoomstates.size() > 0) {
				continue ;
			}
		return null;
	}
      	return null;
	}
	/**
	 * 获取客房类型早餐对应字符串
	 * @param i
	 * @return
	 */
	public String getBreakfast(int i){
		switch (i) {
			case 1: return "无早";
			case 2:	return "单早";
			case 3:	return "双早";
			default:return "无早";
		}
	}
	
	/**
	 * 获取客房类型床型对应字符串
	 * @param i
	 * @return
	 */
	public String getBed(int i){
		switch (i) {
			case 1: return "单人床";
			case 2:	return "大床";
			case 3:	return "双人床";
			case 4:	return "大或双";
			case 5:	return "其他";
			default:return "";
		}
	}
	
	/**
	 * 获取客房类型宽带对应字符串
	 * @param i
	 * @return
	 */
	public String getWideband(int i){
		switch (i) {
			case 0: return "无";
			case 1:	return "免费";
			case 2:	return "收费";
			default:return "无";
		}
	}
	
	/**
	 * 将数组变为字符串
	 * @param arr
	 * @return
	 */
	public String arrayToString(String[] arr) {
		StringBuffer sb = new StringBuffer();
		for(String str : arr) {
			sb.append(str + ",");
		}
		return sb.toString();
	}
	public Boolean panduanjiage(Double jia) {
		//Integer ji = Integer.parseInt(jia.substring(1, 2));
		if(jia<1){
			return false;
		}
		
		return true;
	}
	/**
	 * 截取字符串
	 * @param str
	 * @param len
	 * @return
	 */
	public String subString(String str,int len){
		if(str==null)
			return str;
		if(str.length()<=len)
			return str;
		
		return str.substring(0,Math.abs(len));
	}
	/**
	 * 根据酒店ID得到订单数量
	 */
	public String strOrderCount(long id)
	{
		String strReturn="";
	    List<Hotelorder> listorder=Server.getInstance().getHotelService().findAllHotelorder("where "+Hotelorder.COL_hotelid+"="+id, "", -1, 0);
		strReturn=listorder.size()+"";
	    return strReturn;
	}
	
	public String getimgPath()
	{
		return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue()+"/";
	}
	
	public Object getModel() {
		return hotel;
	}
	
	/*--GETTER SETTER 方法 --*/
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getRegionvalue() {
		return regionvalue;
	}

	public void setRegionvalue(String regionvalue) {
		this.regionvalue = regionvalue;
	}

	public String getRegiontype() {
		return regiontype;
	}

	public void setRegiontype(String regiontype) {
		this.regiontype = regiontype;
	}

	public String[] getS_star() {
		return s_star;
	}

	public void setS_star(String[] s_star) {
		this.s_star = s_star;
	}

	public String[] getS_repair() {
		return s_repair;
	}

	public void setS_repair(String[] s_repair) {
		this.s_repair = s_repair;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	
	public Map<Long, List<Roomtype>> getMapRoom() {
		return mapRoom;
	}

	public void setMapRoom(Map<Long, List<Roomtype>> mapRoom) {
		this.mapRoom = mapRoom;
	}

	public List<Hotelprice> getHotelpriceList() {
		return hotelpriceList;
	}

	public void setHotelpriceList(List<Hotelprice> hotelpriceList) {
		this.hotelpriceList = hotelpriceList;
	}
/*
	public Map<String, String> getStarList() {
		return starList;
	}

	public void setStarList(Map<String, String> starList) {
		this.starList = starList;
	}*/

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Hotel> getHotelListbeijzuid() {
		return hotelListbeijzuid;
	}

	public void setHotelListbeijzuid(List<Hotel> hotelListbeijzuid) {
		this.hotelListbeijzuid = hotelListbeijzuid;
	}

	public List<Hotel> getHotelListshanghzuid() {
		return hotelListshanghzuid;
	}

	public void setHotelListshanghzuid(List<Hotel> hotelListshanghzuid) {
		this.hotelListshanghzuid = hotelListshanghzuid;
	}

	public List<Hotel> getHotelListguangzzuid() {
		return hotelListguangzzuid;
	}

	public void setHotelListguangzzuid(List<Hotel> hotelListguangzzuid) {
		this.hotelListguangzzuid = hotelListguangzzuid;
	}

	public List<Hotel> getHotelListwuhzuid() {
		return hotelListwuhzuid;
	}

	public void setHotelListwuhzuid(List<Hotel> hotelListwuhzuid) {
		this.hotelListwuhzuid = hotelListwuhzuid;
	}

	public List<Hotel> getHotelListnanjzuid() {
		return hotelListnanjzuid;
	}

	public void setHotelListnanjzuid(List<Hotel> hotelListnanjzuid) {
		this.hotelListnanjzuid = hotelListnanjzuid;
	}

	public List<Hotel> getHotelListbeijtuij() {
		return hotelListbeijtuij;
	}

	public void setHotelListbeijtuij(List<Hotel> hotelListbeijtuij) {
		this.hotelListbeijtuij = hotelListbeijtuij;
	}

	public List<Hotel> getHotelListshanghtuij() {
		return hotelListshanghtuij;
	}

	public void setHotelListshanghtuij(List<Hotel> hotelListshanghtuij) {
		this.hotelListshanghtuij = hotelListshanghtuij;
	}

	public List<Hotel> getHotelListguangztuij() {
		return hotelListguangztuij;
	}

	public void setHotelListguangztuij(List<Hotel> hotelListguangztuij) {
		this.hotelListguangztuij = hotelListguangztuij;
	}

	public List<Hotel> getHotelListwuhtuij() {
		return hotelListwuhtuij;
	}

	public void setHotelListwuhtuij(List<Hotel> hotelListwuhtuij) {
		this.hotelListwuhtuij = hotelListwuhtuij;
	}

	public List<Hotel> getHotelListnanjtuij() {
		return hotelListnanjtuij;
	}

	public void setHotelListnanjtuij(List<Hotel> hotelListnanjtuij) {
		this.hotelListnanjtuij = hotelListnanjtuij;
	}

	public List<Infocontent> getListInfocontent() {
		return ListInfocontent;
	}

	public void setListInfocontent(List<Infocontent> listInfocontent) {
		ListInfocontent = listInfocontent;
	}

	public List<Infocontent> getListInfocontentfuwu() {
		return ListInfocontentfuwu;
	}

	public void setListInfocontentfuwu(List<Infocontent> listInfocontentfuwu) {
		ListInfocontentfuwu = listInfocontentfuwu;
	}
	public long getS_num() {
		return s_num;
	}
	public void setS_num(long s_num) {
		this.s_num = s_num;
	}
	public Long getHotelid() {
		return hotelid;
	}
	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}
	public List<Roomtype> getListRoomtype() {
		return listRoomtype;
	}
	public void setListRoomtype(List<Roomtype> listRoomtype) {
		this.listRoomtype = listRoomtype;
	}
	public List getListserviceItem() {
		return listserviceItem;
	}
	public void setListserviceItem(List listserviceItem) {
		this.listserviceItem = listserviceItem;
	}
	public List getListfootItems() {
		return listfootItems;
	}
	public void setListfootItems(List listfootItems) {
		this.listfootItems = listfootItems;
	}
	public List getListplayItems() {
		return listplayItems;
	}
	public void setListplayItems(List listplayItems) {
		this.listplayItems = listplayItems;
	}
	public List<Hotelimage> getListHotelimage() {
		return ListHotelimage;
	}
	public void setListHotelimage(List<Hotelimage> listHotelimage) {
		ListHotelimage = listHotelimage;
	}
	public List getListroomtypeprice() {
		return Listroomtypeprice;
	}
	public void setListroomtypeprice(List listroomtypeprice) {
		Listroomtypeprice = listroomtypeprice;
	}
	public List<Hotelprice> getListHotelprice() {
		return ListHotelprice;
	}
	public void setListHotelprice(List<Hotelprice> listHotelprice) {
		ListHotelprice = listHotelprice;
	}
	public Map<Long, List<Hotelprice>> getMapPrice() {
		return mapPrice;
	}
	public void setMapPrice(Map<Long, List<Hotelprice>> mapPrice) {
		this.mapPrice = mapPrice;
	}
	public Map<Long, List<Hotelprice>> getMapRoomprice() {
		return mapRoomprice;
	}
	public void setMapRoomprice(Map<Long, List<Hotelprice>> mapRoomprice) {
		this.mapRoomprice = mapRoomprice;
	}
	public Long getRoomid() {
		return roomid;
	}
	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
	public Roomtype getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public int getZongjia() {
		return zongjia;
	}

	public void setZongjia(int zongjia) {
		this.zongjia = zongjia;
	}

	public List<Customerpassenger> getListCustomerpassenger() {
		return listCustomerpassenger;
	}
	public void setListCustomerpassenger(
			List<Customerpassenger> listCustomerpassenger) {
		this.listCustomerpassenger = listCustomerpassenger;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Hotelorder getHotelorder() {
		return hotelorder;
	}
	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
	}
	public String getUsername0() {
		return username0;
	}
	public void setUsername0(String username0) {
		this.username0 = username0;
	}
	public String getMobile0() {
		return mobile0;
	}
	public void setMobile0(String mobile0) {
		this.mobile0 = mobile0;
	}
	public String getUsername1() {
		return username1;
	}
	public void setUsername1(String username1) {
		this.username1 = username1;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getUsername2() {
		return username2;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getUsername3() {
		return username3;
	}
	public void setUsername3(String username3) {
		this.username3 = username3;
	}
	public String getMobile3() {
		return mobile3;
	}
	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}
	public String getUsername4() {
		return username4;
	}
	public void setUsername4(String username4) {
		this.username4 = username4;
	}
	public String getMobile4() {
		return mobile4;
	}
	public void setMobile4(String mobile4) {
		this.mobile4 = mobile4;
	}
	public String getUsername5() {
		return username5;
	}
	public void setUsername5(String username5) {
		this.username5 = username5;
	}
	public String getMobile5() {
		return mobile5;
	}
	public void setMobile5(String mobile5) {
		this.mobile5 = mobile5;
	}
	public String getUsername6() {
		return username6;
	}
	public void setUsername6(String username6) {
		this.username6 = username6;
	}
	public String getMobile6() {
		return mobile6;
	}
	public void setMobile6(String mobile6) {
		this.mobile6 = mobile6;
	}
	public String getUsername7() {
		return username7;
	}
	public void setUsername7(String username7) {
		this.username7 = username7;
	}
	public String getMobile7() {
		return mobile7;
	}
	public void setMobile7(String mobile7) {
		this.mobile7 = mobile7;
	}
	public Timestamp getStartDate2() {
		return startDate2;
	}
	public void setStartDate2(Timestamp startDate2) {
		this.startDate2 = startDate2;
	}
	public Timestamp getEndDate2() {
		return endDate2;
	}
	public void setEndDate2(Timestamp endDate2) {
		this.endDate2 = endDate2;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public String getForword() {
		return forword;
	}
	public void setForword(String forword) {
		this.forword = forword;
	}
	public Long getHotelorderid() {
		return hotelorderid;
	}
	public void setHotelorderid(Long hotelorderid) {
		this.hotelorderid = hotelorderid;
	}
	public Double getJunjia() {
		return junjia;
	}
	public void setJunjia(Double junjia) {
		this.junjia = junjia;
	}
	public List<Guest> getListGuest() {
		return listGuest;
	}
	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}
	public int getAdd() {
		return add;
	}
	public void setAdd(int add) {
		this.add = add;
	}
	public List<Hotel> getHotelList_tebie() {
		return hotelList_tebie;
	}
	public void setHotelList_tebie(List<Hotel> hotelList_tebie) {
		this.hotelList_tebie = hotelList_tebie;
	}
	public List<Hotel> getHotelList_daohang() {
		return hotelList_daohang;
	}
	public void setHotelList_daohang(List<Hotel> hotelList_daohang) {
		this.hotelList_daohang = hotelList_daohang;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public int getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(int orderMode) {
		this.orderMode = orderMode;
	}
	public List<Region> getListAdmin() {
		return listAdmin;
	}
	public void setListAdmin(List<Region> listAdmin) {
		this.listAdmin = listAdmin;
	}
	public int getGuojia() {
		return guojia;
	}
	public void setGuojia(int guojia) {
		this.guojia = guojia;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getTyp() {
		return typ;
	}
	public void setTyp(int typ) {
		this.typ = typ;
	}

	public String getInRoomPeople() {
		return InRoomPeople;
	}
	public void setInRoomPeople(String inRoomPeople) {
		InRoomPeople = inRoomPeople;
	}

	public List<Hotel> getHotelListtuijian() {
		return hotelListtuijian;
	}
	public void setHotelListtuijian(List<Hotel> hotelListtuijian) {
		this.hotelListtuijian = hotelListtuijian;
	}
	public List<Hotel> getHotelListdijia() {
		return hotelListdijia;
	}
	public void setHotelListdijia(List<Hotel> hotelListdijia) {
		this.hotelListdijia = hotelListdijia;
	}
	public List<Roomstate> getListRoomstate() {
		return listRoomstate;
	}
	public void setListRoomstate(List<Roomstate> listRoomstate) {
		this.listRoomstate = listRoomstate;
	}
	public List<Roomtype> getListRoomtype1() {
		return ListRoomtype1;
	}
	public void setListRoomtype1(List<Roomtype> listRoomtype1) {
		ListRoomtype1 = listRoomtype1;
	}
	public Map<Long, List<Hotelprice>> getMappice() {
		return mappice;
	}
	public void setMappice(Map<Long, List<Hotelprice>> mappice) {
		this.mappice = mappice;
	}

	public String getDate1() {
		return Date1;
	}

	public void setDate1(String date1) {
		Date1 = date1;
	}

	public String getDate2() {
		return Date2;
	}

	public void setDate2(String date2) {
		Date2 = date2;
	}

	public String getDate3() {
		return Date3;
	}

	public void setDate3(String date3) {
		Date3 = date3;
	}

	public String getDate4() {
		return Date4;
	}

	public void setDate4(String date4) {
		Date4 = date4;
	}

	public String getDate5() {
		return Date5;
	}

	public void setDate5(String date5) {
		Date5 = date5;
	}

	public String getDate6() {
		return Date6;
	}

	public void setDate6(String date6) {
		Date6 = date6;
	}

	public String getDate7() {
		return Date7;
	}

	public void setDate7(String date7) {
		Date7 = date7;
	}

	public List<Specialprice> getListspe() {
		return listspe;
	}

	public void setListspe(List<Specialprice> listspe) {
		this.listspe = listspe;
	}

	public String getHoteldaohang() {
		return hoteldaohang;
	}

	public void setHoteldaohang(String hoteldaohang) {
		this.hoteldaohang = hoteldaohang;
	}



	public Map<String, List> getMappicemack() {
		return mappicemack;
	}

	public void setMappicemack(Map<String, List> mappicemack) {
		this.mappicemack = mappicemack;
	}

	public List getListmackrice() {
		return Listmackrice;
	}

	public void setListmackrice(List listmackrice) {
		Listmackrice = listmackrice;
	}

	public String getRoomcode() {
		return roomcode;
	}

	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Map<Long, List> getMapserviceItem() {
		return mapserviceItem;
	}

	public void setMapserviceItem(Map<Long, List> mapserviceItem) {
		this.mapserviceItem = mapserviceItem;
	}

	public Map<Long, List> getMapfootItems() {
		return mapfootItems;
	}

	public void setMapfootItems(Map<Long, List> mapfootItems) {
		this.mapfootItems = mapfootItems;
	}

	public Map<Long, List> getMapplayItems() {
		return mapplayItems;
	}

	public void setMapplayItems(Map<Long, List> mapplayItems) {
		this.mapplayItems = mapplayItems;
	}

	public List getListprice() {
		return Listprice;
	}

	public void setListprice(List listprice) {
		Listprice = listprice;
	}

	public List<Hotellandmark> getListHotellandmark() {
		return listHotellandmark;
	}

	public void setListHotellandmark(List<Hotellandmark> listHotellandmark) {
		this.listHotellandmark = listHotellandmark;
	}

	public String getS_cityid() {
		return s_cityid;
	}

	public void setS_cityid(String s_cityid) {
		this.s_cityid = s_cityid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Hotel> getListhotelbj() {
		return listhotelbj;
	}
	public void setListhotelbj(List<Hotel> listhotelbj) {
		this.listhotelbj = listhotelbj;
	}
	public List<Hotel> getListhotelsh() {
		return listhotelsh;
	}
	public void setListhotelsh(List<Hotel> listhotelsh) {
		this.listhotelsh = listhotelsh;
	}
	public List<Hotel> getListhotelgz() {
		return listhotelgz;
	}
	public void setListhotelgz(List<Hotel> listhotelgz) {
		this.listhotelgz = listhotelgz;
	}
	public List<Hotel> getListhotelsz() {
		return listhotelsz;
	}
	public void setListhotelsz(List<Hotel> listhotelsz) {
		this.listhotelsz = listhotelsz;
	}

	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public String getS_price() {
		return s_price;
	}
	public void setS_price(String s_price) {
		this.s_price = s_price;
	}
	public String getBradnhotelid() {
		return bradnhotelid;
	}
	public void setBradnhotelid(String bradnhotelid) {
		this.bradnhotelid = bradnhotelid;
	}
	public String getQiday() {
		return qiday;
	}
	public void setQiday(String qiday) {
		this.qiday = qiday;
	}
	public List<Sysmessage> getListsysmessage() {
		return listsysmessage;
	}
	public void setListsysmessage(List<Sysmessage> listsysmessage) {
		this.listsysmessage = listsysmessage;
	}
	public String getS_hotelName() {
		return s_hotelName;
	}
	public void setS_hotelName(String name) {
		s_hotelName = name;
	}

	public List getListhotelsession() {
		return listhotelsession;
	}
	public void setListhotelsession(List listhotelsession) {
		this.listhotelsession = listhotelsession;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getInRoommobile() {
		return InRoommobile;
	}
	public void setInRoommobile(String inRoommobile) {
		InRoommobile = inRoommobile;
	}
	public Float getRebvaule() {
		return rebvaule;
	}
	public void setRebvaule(Float rebvaule) {
		this.rebvaule = rebvaule;
	}
	public String getHidsex() {
		return hidsex;
	}
	public void setHidsex(String hidsex) {
		this.hidsex = hidsex;
	}
	public Map<Long, Integer> getRoomPrice() {
		return RoomPrice;
	}
	public void setRoomPrice(Map<Long, Integer> roomPrice) {
		RoomPrice = roomPrice;
	}
	public String getPricecode() {
		return pricecode;
	}
	public void setPricecode(String pricecode) {
		this.pricecode = pricecode;
	}
	public Double getHotelrebate() {
		return Hotelrebate;
	}
	public void setHotelrebate(Double hotelrebate) {
		Hotelrebate = hotelrebate;
	}
	public void setSearchInfo(StringBuffer searchInfo) {
		this.searchInfo = searchInfo;
	}
	public Float getHotelPos() {
		return HotelPos;
	}
	public void setHotelPos(Float hotelPos) {
		HotelPos = hotelPos;
	}
	public Map<Long, List> getRoomListPrice() {
		return RoomListPrice;
	}
	public void setRoomListPrice(Map<Long, List> roomListPrice) {
		RoomListPrice = roomListPrice;
	}
	public String getS_citycode() {
		return s_citycode;
	}
	public void setS_citycode(String s_citycode) {
		this.s_citycode = s_citycode;
	}
	public String getS_hotelcode() {
		return s_hotelcode;
	}
	public void setS_hotelcode(String s_hotelcode) {
		this.s_hotelcode = s_hotelcode;
	}
	public String getS_stime() {
		return s_stime;
	}
	public void setS_stime(String s_stime) {
		this.s_stime = s_stime;
	}
	public String getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}
	public String getS_hotelid() {
		return s_hotelid;
	}
	public void setS_hotelid(String s_hotelid) {
		this.s_hotelid = s_hotelid;
	}
	public Roomtype getNEWroomtype() {
		return NEWroomtype;
	}
	public void setNEWroomtype(Roomtype wroomtype) {
		NEWroomtype = wroomtype;
	}
	public String getS_hotelstar() {
		return s_hotelstar;
	}
	public void setS_hotelstar(String s_hotelstar) {
		this.s_hotelstar = s_hotelstar;
	}
	public List<BookingRules> getListBookingRules() {
		return listBookingRules;
	}
	public void setListBookingRules(List<BookingRules> listBookingRules) {
		this.listBookingRules = listBookingRules;
	}
	public List<GuaranteeRule> getListGuaranteeRule() {
		return listGuaranteeRule;
	}
	public void setListGuaranteeRule(List<GuaranteeRule> listGuaranteeRule) {
		this.listGuaranteeRule = listGuaranteeRule;
	}
	public List<PrepayRule> getListPrepayRule() {
		return listPrepayRule;
	}
	public void setListPrepayRule(List<PrepayRule> listPrepayRule) {
		this.listPrepayRule = listPrepayRule;
	}
	public List<RatePlan> getListRatePlan() {
		return listRatePlan;
	}
	public void setListRatePlan(List<RatePlan> listRatePlan) {
		this.listRatePlan = listRatePlan;
	}
	public List<NightlyRate> getListNightlyRate() {
		return listNightlyRate;
	}
	public void setListNightlyRate(List<NightlyRate> listNightlyRate) {
		this.listNightlyRate = listNightlyRate;
	}
	public String getInRoomCountry() {
		return InRoomCountry;
	}
	public void setInRoomCountry(String inRoomCountry) {
		InRoomCountry = inRoomCountry;
	}
	public String getEarliestArrivalTime() {
		return EarliestArrivalTime;
	}
	public void setEarliestArrivalTime(String earliestArrivalTime) {
		EarliestArrivalTime = earliestArrivalTime;
	}
	public String getLatestArrivalTime() {
		return LatestArrivalTime;
	}
	public void setLatestArrivalTime(String latestArrivalTime) {
		LatestArrivalTime = latestArrivalTime;
	}
	public int getNumberOfRooms() {
		return NumberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		NumberOfRooms = numberOfRooms;
	}





}
