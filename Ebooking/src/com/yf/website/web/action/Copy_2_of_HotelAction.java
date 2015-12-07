/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.website.web.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.yf.system.base.chaininfo.Chaininfo;
import com.yf.system.base.city.City;
import com.yf.system.base.creditcard.Creditcard;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelinter.BookingRules;
import com.yf.system.base.hotelinter.GuaranteeRule;
import com.yf.system.base.hotelinter.NightlyRate;
import com.yf.system.base.hotelinter.PrepayRule;
import com.yf.system.base.hotelinter.RatePlan;
import com.yf.system.base.hotelinter.SeachHotelBean;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.information.Information;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.region.Region;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.util.PageInfo;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class Copy_2_of_HotelAction extends B2b2cbackAction {
	//房型对应的价格
	private Map<Long,List<Hotelprice>> mapRoomprice = new HashMap<Long,List<Hotelprice>>();
	//酒店对象
	private Hotel hotel = new Hotel();
	//酒店订单对象
	private Hotelorder hotelorder= new Hotelorder();
	//酒店入住人LIST
	private List<Guest>ListGuest;
	//session中hotel
	
	private List<Hotel>ListSessionHotel;
	//入住人对象
	private Guest guest = new Guest();
	
	//s_citycode
	private String s_citycode;//今日酒店城市编码
	
	//入住人数
	private int add=0;
	//入住人字符串
	private String InRoomPeople;
	//房型对象
	private Roomtype roomtype=new Roomtype();
	//异步传递来得酒店ID
	private String strHotelCity;
	
	//异步传递来得酒店星级
	private String strHotelStar;
	
	//异步传递来得酒店区域id
	private String strHotelRegion;
	
	//异步传递来得index
	private String strHotelIndex;
	
	
	private List Listroomtypeprice = new ArrayList();
	
	//区域ID
	private int RegionID;
	
	// 入住日期
	private String startDate;
	// 离店日期
	private String endDate;
	// 价格范围
	private String s_price;
	// 星级
	private String s_star;
	//酒店名字
	private String hotelName;
	//城市ID
	private Long cityId;
	
	//城市名字
	private String CityName;
	
	//联系人电话
	private String LinkMobile;
	//联系人邮箱
	private String LinkMail;
	//联系人姓名
	private String LinkName;
	
	//排序
	private int orderType=1;
	
	//酒店ID
	private Long HotelId;
	
	//酒店订单ID
	private Long HotelOrderID;
	
	//房型ID
	private Long RoomTypeid;
	
	//城市数
	private int citynum;
	
	//酒店数
	private int hotelnum;
	//总价格(单间)
	private int zongjia;
	
	//总价格(间数*总价)
	private int HotelPrice;
	//房间数
	private int RoomTypeNum;
	//每日价格记录
	private String HotelDayPrice;

	// 最新资讯
	private List<Informationinfo> listZX;
	//品牌酒店
	private List<Chaininfo>ListChaininfo;
	//酒店图片
	private List<Hotelimage> ListHotelimage=new ArrayList<Hotelimage>();;
	
	// 酒店列表
	private List<Hotel> hotelList;
	
	private long s_num;
	
	
	//城市区域
	private List<Region> ListRegion;
	//酒店房型
	private List<Roomtype>ListRoomType;
	
	//价格列表
	private List<Hotelprice>ListHotelprice;
	
	// 客房类型列表
	private Map<Long,List<Roomtype>> mapRoom = new HashMap<Long,List<Roomtype>>();//酒店--房型
	
	private Map<Long,List> RoomListPrice = new HashMap<Long,List>();//房型--价格list
	
	//客房价格map
	private Map<Long,Integer> RoomPrice = new HashMap<Long,Integer>();//房型--价格
	//价格LIST
	private List Listprice = new ArrayList();
	
	//session
	private List<Hotel> Listsessionhotel = new ArrayList();
	//日期LIST
	private List Listday = new ArrayList();
	
	//以下为星期信息
	private String Date1;
	private String Date2;
	private String Date3;
	private String Date4;
	private String Date5;
	private String Date6;
	private String Date7;
	//星期信息结束
	
	//专门用来存放elong酒店的规则开始
	private List <  BookingRules  >  listBookingRules;//预订规则
	private List <  GuaranteeRule  > listGuaranteeRule;//担保规则
	private List <  PrepayRule  > listPrepayRule;//预付规则
	private List <  RatePlan  > listRatePlan;//价格政策
	private List <  NightlyRate  > listNightlyRate;//每日价格
	private String pricecode;//价格计划ID
	
	//信用卡信息开始
	private String cardno;
	private String cardcvv;
	private int cardyear;
	private int cardmonth;
	private String cardname;
	private String idtype;
	private String idno;
	private String cardyhangname;//银行名字
	
	private String forword;
	
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
	
//到店时间-2
	
	public String getDaoDianTime(String time){
		String ret="14:00";
		if(time!=null&&time.trim().length()>0){
			ret=(Integer.parseInt(time.split(":")[0].trim())-2)+":00";
		}
		
		
		return ret;
	}
			

	public Copy_2_of_HotelAction() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		endDate = sdf.format(calendar.getTime());
		String citysql=" SELECT COUNT(ID) FROM "+City.TABLE;
		citynum=Server.getInstance().getHotelService().countCityBySql(citysql);
		String hotelsql=" SELECT COUNT(ID) FROM "+Hotel.TABLE;
		hotelnum=Server.getInstance().getHotelService().countHotelBySql(hotelsql);
		//System.out.println("hotelnum:"+hotelnum);
		/*
		 * starList.put("1", "经济型"); starList.put("3", "二星级"); starList.put("4",
		 * "准三星"); starList.put("5", "三星级"); starList.put("6", "准四星");
		 * starList.put("7", "四星级"); starList.put("8", "准五星"); starList.put("9",
		 * "五星级");
		 */
	}
	
	/**
	 * AJAX读取酒店推荐信息 2012-02-14 陈星
	 * 
	 * @throws
	 */
	public void GetHotel() throws Exception {
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		StringBuilder sber = new StringBuilder();
		String where=" where 1=1 and "+Hotel.COL_type+" =1 and "+Hotel.COL_state+" =3  and "+Hotel.COL_cityid+" ='"+strHotelCity+"'";
		List<Hotel>ListHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY C_STARTPRICE", 5, 0);
		int size=ListHotel.size();
		sber.append("<div class='box content'>");
		for(int a=0;a<ListHotel.size();a++){
			if((a+1)<size){
				sber.append("<ul class='box_botm_xu'>");
				}else{
					
				sber.append("<ul class=' mt7'>");	
				}
		
		sber.append("<li>");
		sber.append("<span class='f number font_fff_09'>"+(a+1)+"</span>");
		sber.append("<a href='hotel!toHotelInfo.jspx?HotelId="+ListHotel.get(a).getId()+"&startDate="+startDate+"&endDate="+endDate+"' class='f'>"+ListHotel.get(a).getName()+"</a>");
		sber.append("<font class='r font_f60_c'></font>");//起价
		sber.append("<div class='c'></div>");
		sber.append("</li>");
		sber.append("<li class='content_lh'>");
		sber.append("<span class='f pf25'>共<font class='f90'>98条</font>评论</span>");
		sber.append("<span class='r pr20'><font class='f90'>99%</font>满意度</span>");
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
	 * AJAX读取酒店推荐信息 2012-02-14 陈星
	 * 
	 * @throws
	 */
	public void GetIndexHotel() throws Exception {
		//System.out.println("酒店ID:"+strHotelCity);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String where=" where 1=1 and "+Hotel.COL_type+" =1 and "+Hotel.COL_state+" =3  and "+Hotel.COL_cityid+" ='"+strHotelCity+"'";
		List<Hotel>ListHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY C_STARTPRICE", 8, 0);
		
		StringBuilder sb = new StringBuilder();

		sb.append("<div>");
		sb.append("<ul>");
		sb.append("<li class='titlehot box_over' style='background-color:#eee; color:#555454;'>经济型酒店</li>");
		sb.append("</ul>");
		sb.append("<ul class='main'>");
		sb.append("<div class='nohave5'></div>");
		if(ListHotel.size()>0){
			for(int a=0;a<ListHotel.size();a++){
			sb.append("<li class='f main_left'>");
			sb.append("<ul>");
			sb.append("<li class='f main_name'><a href='hotel!toHotelInfo.jspx?HotelId="+ListHotel.get(a).getId()+"&startDate="+startDate+"&endDate="+endDate+"'>"+ListHotel.get(a).getName()+"</a></li>");
			sb.append("<li class='f main_morny f90c'></li>");
			//sb.append("<li class='f main_give f90'>&yen;20</li>");
			sb.append("</ul>");
			sb.append("</li>");
			}
		}
		sb.append("<div class='c nohave5'></div>");
		sb.append("</ul>");
		
		
		
		sb.append("<ul class='c'>");
		sb.append("<li class='titlehot box_over box_over_top' style='background-color:#eee; color:#555454;'>");
		sb.append("<font class='f'>星级酒店</font>");
		sb.append("<span class='r mr15'>");
		//sb.append("<a href='#' class='l06c'>五星</a><font class='mlr8'>|</font>");
		//sb.append("<a href='#' >四星</a><font class='mlr8'>|</font>");
		//sb.append("<a href='#'>三星</a><font class='mlr8'>|</font>");
		//sb.append("<a href='#'>经济</a>");
		sb.append("</span>");
		sb.append("<div class='c'></div>");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("<ul class='main'>");
		sb.append("<div class='nohave5'></div>");
		List<Hotel>ListStarHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY C_STAR DESC", 6, 0);
		if(ListStarHotel.size()>0){
			for(int h=0;h<ListStarHotel.size();h++){
				sb.append("<li class='f main_left'>");
				sb.append("<ul>");
				sb.append("<li class='f main_name'><a href='hotel!toHotelInfo.jspx?HotelId="+ListStarHotel.get(h).getId()+"&startDate="+startDate+"&endDate="+endDate+"'>"+ListStarHotel.get(h).getName()+"</a></li>");
				sb.append("<li class='f main_morny f90c'></li>");
				//sb.append("<li class='f main_give f90'>&yen;20</li>");
				sb.append("</ul>");
				sb.append("</li>");
			}
		}
		sb.append("<div class='c nohave5'></div>");
		sb.append("</ul>");
		
		
		
		
		sb.append("<ul class='c'>");
		sb.append("<li class='titlehot box_over box_over_top' style='background-color:#eee; color:#555454;'>");
		sb.append("<font class='f'>热门区域酒店</font>");
		sb.append("<span class='r mr15'>");
		
		
		/*List<Region>Listregion=Server.getInstance().getHotelService().findAllRegion(" WHERE 1=1 AND "+Region.COL_cityid+" ='"+strHotelCity+"'", " ORDER BY ID DESC ", 7, 0);
		int size=Listregion.size();
		if(Listregion.size()>0){
			for(int r=0;r<Listregion.size();r++){
				if(r+1==size){
					//sb.append("<a href='javascript:void(0)' onmouseover='selecthotel("+strHotelIndex+","+strHotelCity+","+strHotelStar+","+strHotelRegion+")' class='l06c'>"+Listregion.get(r).getName()+"</a>");
					sb.append("<a href='javascript:void(0)'  class='l06c'>"+Listregion.get(r).getName()+"</a>");
					
				}else{
					sb.append("<a href='javascript:void(0)'  class='l06c'>"+Listregion.get(r).getName()+"</a><font class='mlr8'>|</font>");		
				}
			}
		}*/
		/*sb.append("<a href='#' class='l06c'>天安门</a><font class='mlr8'>|</font>");
		sb.append("<a href='#' >王府井</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>国展中心</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>中关村</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>西客站</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>永定门</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>南站</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>北京周边度假</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>上地</a>");*/
		sb.append("</span>");
		sb.append("<div class='c'></div>");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("<ul class='main'>");
		sb.append("<div class='nohave5'></div>");
		where+=" and "+Hotel.COL_regionid2+" in ( SELECT "+Region.COL_id+" FROM "+Region.TABLE+" where "+Region.COL_cityid+" ='"+strHotelCity+"')";
		if(strHotelRegion!=null&&strHotelRegion.length()>0){
			where+=" and "+Hotel.COL_regionid2+" ='"+strHotelRegion+"'";
		}
		
		List<Hotel>ListRegionHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY ID ", 8, 0);
		if(ListRegionHotel.size()>0){
			for(int r=0;r<ListRegionHotel.size();r++){
				
				sb.append("<li class='f main_left'>");
				sb.append("<ul>");
				sb.append("<li class='f main_name'><a href='hotel!toHotelInfo.jspx?HotelId="+ListRegionHotel.get(r).getId()+"&startDate="+startDate+"&endDate="+endDate+"'>"+ListRegionHotel.get(r).getName()+"</a></li>");
				sb.append("<li class='f main_morny f90c'></li>");
				//sb.append("<li class='f main_give f90'>&yen;20</li>");
				sb.append("</ul>");
				sb.append("</li>");
			}
			
		}
		
		
		
		sb.append("<div class='c nohave5'></div>");
		sb.append("</ul>");
		sb.append("</div>");

		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	/**
	 * 异步获取星级酒店 2012-02-13 陈星
	 * 
	 * @throws
	 */
	
	public void GetIndexHotelStar() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		StringBuilder sb = new StringBuilder();
		sb.append("<ul class='c'>");
		sb.append("<li class='titlehot box_over box_over_top'>");
		sb.append("<font class='f dd2626'>星级酒店</font>");
		sb.append("<span class='r mr15'>");
		sb.append("<a href='#' class='l06c'>五星</a><font class='mlr8'>|</font>");
		sb.append("<a href='#' >四星</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>三星</a><font class='mlr8'>|</font>");
		sb.append("<a href='#'>经济</a>");
		sb.append("</span>");
		sb.append("<div class='c'></div>");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("<ul class='main'>");
		sb.append("<div class='nohave5'></div>");
		List<Hotel>ListStarHotel=Server.getInstance().getHotelService().findAllHotel("", " ORDER BY C_STAR DESC", 6, 0);
		if(ListStarHotel.size()>0){
			for(int h=0;h<ListStarHotel.size();h++){
				sb.append("<li class='f main_left'>");
				sb.append("<ul>");
				sb.append("<li class='f main_name'>"+ListStarHotel.get(h).getName()+"</li>");
				sb.append("<li class='f main_morny f90c'>&yen;"+ListStarHotel.get(h).getStartprice()+"</li>");
				sb.append("<li class='f main_give f90'>&yen;20</li>");
				sb.append("</ul>");
				sb.append("</li>");
			}
		}
		sb.append("<div class='c nohave5'></div>");
		sb.append("</ul>");
		
		
		
	}
	
	

	/**
	 * 酒店预订首页 2012-02-13 陈星
	 * 
	 * @throws
	 */

	public String toindex() {
		String where = " where 1=1 and " + Informationinfo.COL_typeid
		+ " in ( SELECT " + Information.COL_id + " FROM "
		+ Information.TABLE + " where " + Information.COL_name
		+ " ='最新资讯')";
listZX = Server.getInstance().getMemberService().findAllInformationinfo(where, " ORDER BY ID DESC ", 7, 0);
String whereChaininfo=" where 1=1 and "+Chaininfo.COL_total+" >30";
ListChaininfo=Server.getInstance().getHotelService().findAllChaininfo(whereChaininfo, " ORDER BY C_TOTAL    ", 14, 0);
		return "toindex";
	}

	/**
	 * 酒店检索 2012-02-13 陈星
	 * @throws UnsupportedEncodingException 
	 * 
	 * @throws
	 */

	public String Seach() throws Exception{
		
		/*if(hotelName!=null&&hotelName.length()>0){
    		String expr = new String(hotelName.getBytes("ISO-8859-1"),"UTF-8");
    		System.out.println("expr=="+expr);
    		hotelName=expr;
    		
    	}	*/
		//StringBuilder where = new StringBuilder(" where "+Hotel.COL_type+" =1 and  C_STATE=3 and "+Hotel.COL_id+" in ( select "+Roomtype.COL_hotelid+" from "+Roomtype.TABLE+")");
		StringBuilder where = new StringBuilder(" where "+Hotel.COL_sourcetype+" =2 and  C_STATE=3 and "+Hotel.COL_hotelcode+" is not null ");
		
		if (null != hotelName && !"".equals(hotelName.trim())) {
			where.append(" and C_NAME like '%");
			where.append(hotelName.trim());
			where.append("%' ");
		}
		
		// 酒店所在城市
		if( cityId != null && cityId > 0) {
			where.append(" and C_CITYID =").append(cityId);
			City city=Server.getInstance().getHotelService().findCity(cityId);
			CityName =city.getName();
			s_citycode=city.getCarcode();
		}

		// 星级
		if (null != s_star && s_star.length() > 0&&!s_star.endsWith("0")) {
				where.append(" and C_STAR in( ");
				where.append(s_star);
				where.append(") ");
		}
		
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
				where.append(" and C_STARTPRICE>250 and C_STARTPRICE<400 ");
			}
			//RMB 400-600
			else if(s_price.equals("3"))
			{
				where.append(" and C_STARTPRICE>400  and C_STARTPRICE<600 ");
			}
			//RMB 600-800
			else if(s_price.equals("4"))
			{
				where.append(" and C_STARTPRICE>600 and C_STARTPRICE<800 ");
			}
			//RMB 800以上
			else if(s_price.equals("5"))
			{
				where.append(" and C_STARTPRICE>800");
			}
			
		}
		
		// 排序
		String orderStr = "ORDER BY C_HOT";
		if(orderType == 1){
			
			orderStr = "order by C_STARTPRICE ";
		}
		if(orderType == 2){
			
			orderStr = "order by C_STARTPRICE DESC";
		}
		
		if(orderType == 3){
			
			orderStr = "order by C_STAR ";
		}
		
		if(orderType == 4){
			
			orderStr = "order by C_STAR DESC";
		}
		if(orderType == 5){
			
			orderStr = "order by C_STAR ";
		}
		
		if(orderType == 6){
			
			orderStr = "order by C_STAR DESC";
		}
		
		System.out.println("where==="+where.toString());
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
		String snian=	startDate.substring(0,7);//开始年月
		String enian=	endDate.substring(0,7);//结束年月
		
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
					 //   pricrsr=datepricedeletemenshi[0];
					    System.out.println("pricrsr=="+pricrsr);
					    
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
		String whereRegion=" where 1=1 and "+Region.COL_cityid+" ="+cityId+" and "+Region.COL_name.length()+" <70";
		ListRegion =Server.getInstance().getHotelService().findAllRegion(whereRegion, " ORDER BY ID DESC ", 10, 0);
		
		String whereChaininfo=" where 1=1 and "+Chaininfo.COL_total+" >30";
		ListChaininfo=Server.getInstance().getHotelService().findAllChaininfo(whereChaininfo, " ORDER BY C_TOTAL    ", 14, 0);
		
		return "tolist";
	}
	
	//详细页面
	public void findHotelRoomPriceInfo() {
		
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Hotel hot=new Hotel();
		hot=Server.getInstance().getHotelService().findHotel(HotelId);
		
		//hot.setId(Long.parseLong(s_hotelid));
		//hot.setHotelcode(s_hotelcode);
		SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hot, startDate, endDate,"");
		
		/*String mnane = "getNo"+a;
		Class[] types = new Class[]{};
		Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
		Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
		Double price = ((Double)aa).doubleValue();
		int pp=	(int)Math.floor(price);*/
		
		//if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
		if(1==1){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();
			List<Hotelprice>listroomprice=seachHotelBean.getListHotelprice();
			
			str.append("<table width='710' border='1' cellspacing='0' cellpadding='0' class='box'>");
			str.append("<tr>");
			str.append("<th class='hadow' width='20%' scope='col'>房型</th>");
			str.append("<th class='hadow' width='10%' scope='col'>门市价</th>");
			str.append("<th class='hadow' width='10%' scope='col'>前台价</th>");
			str.append("<th class='hadow' width='25%' scope='col'>床型</th>");
			str.append("<th class='hadow' width='10%' scope='col'>早餐</th>");
			str.append("<th class='hadow' width='10%' scope='col'>宽带</th>");
			str.append("<th class='hadow' width='15%' scope='col'>预定</th>");
			str.append("</tr>");
			
			for(int a=0;a<5;a++){
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				
				String menshijia="";
				String shourijia="";
				//取价格
				/*List list=	GetRoomPriceBy(listroomprice, startDate, endDate, listroom.get(a));
				List listpr=(List) list.get(0);//价格list
				List listprtxt=(List) list.get(1);//价格描述list
				
				if(listpr!=null&&listpr.size()>0){
					menshijia=listpr.get(0).toString();
				}
				if(listpr!=null&&listpr.size()>0){
					shourijia=listpr.get(1).toString();
				}*/
				
		      
		        str.append("<tr id='room' >");
		        str.append("<td class='floatall'>");
		        str.append("<a href='#' class='l06c'>aaaa</a>");
		        str.append("<!-- 床型图片 -->");
		        str.append("<div class='float_room msg' style='display:none;'>");
		        str.append("<ul class='msgul'>");
		        str.append("<li class=' pt5'><img src='images/hotel.jpg' width='90' height='80' /></li>");
		        str.append("<li>高级双人床</li>");
		        str.append("</ul>");
		        str.append("</div>");    
		        str.append("<!-- 床型图片 -->");
		        str.append("</td>");
		        str.append("<td class='font-f60-del'>&yen;111</td>");
		        str.append("<td class='font-f60-16'>&yen;29</td>");
		        str.append("<!--<td><span class='main_give f90 f mf15'>&yen;20</span></td>-->");
		        str.append("<td>爱爱爱</td>");
		        str.append("<td>嘻嘻嘻</td>");
		        str.append("<td>啊啊啊</td>");
		        str.append("<td>");
		           
		        str.append("<input type='button' class='bnt' value='预定' onclick='bookhotel('roomid',"+hot.getId()+")'");
		           
		        str.append("</td>");
		        str.append("</tr>");
		        
		           
		        
				
				
				
				
				
				
				
				
				
			}
			
			str.append("<tr>");
	        str.append("<td colspan='6' align='left'><span class='ico_tips f'>&nbsp;</span>");
	        //str.append("<!-- 11.1至12.15入住，全部房型均含早餐（以房型介绍信息为准）-->");
	        str.append("</td>");
	        str.append("<td><a href='javascript:void(0)' onclick='showAllroom()'>全部房型</a>");
	        str.append("<span id='show_"+hot.getId()+"' class='allshow'>&nbsp;</span>");
	        str.append("<span id='hide_"+hot.getId()+"' class='allnoshow' style='display: none'>&nbsp;</span>");
	        str.append("<input type='hidden' id='' name='' value='1' />");
	        str.append("</td>");
	        str.append("</tr>");
	        str.append("</table>");
			
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
	
	
	//列表页面
	public void findHotelRoomPrice() {
		
		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Hotel hot=new Hotel();
		hot=Server.getInstance().getHotelService().findHotel(HotelId);
		
	
		SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hot, startDate, endDate,"");
		
		
		
		//if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
		if(seachHotelBean!=null&&seachHotelBean.getListRoomtype()!=null){
			List<Roomtype>listroom=seachHotelBean.getListRoomtype();//返回房型
			List<BookingRules>ListBookingRules=seachHotelBean.getListBookingRules();//预订规则
			List<GuaranteeRule>ListGuaranteeRule=seachHotelBean.getListGuaranteeRule();//担保规则
			List<PrepayRule>ListPrepayRule=seachHotelBean.getListPrepayRule();//担保规则
			
			
			str.append("<table width='710' border='1' cellspacing='0' cellpadding='0' class='box'>");
			str.append("<tr>");
			str.append("<th class='hadow' width='20%' scope='col'>房型</th>");
			str.append("<th class='hadow' width='10%' scope='col'>门市价</th>");
			str.append("<th class='hadow' width='10%' scope='col'>前台价</th>");
			str.append("<th class='hadow' width='25%' scope='col'>床型</th>");
			str.append("<th class='hadow' width='10%' scope='col'>早餐</th>");
			str.append("<th class='hadow' width='10%' scope='col'>宽带</th>");
			str.append("<th class='hadow' width='15%' scope='col'>预定</th>");
			str.append("</tr>");
			
			for(int a=0;a<listroom.size();a++){
				String ret="bgcolor='#e6edf6'";
				if(a%2==0){
					ret="bgcolor='#c5d4e9'";
				}
				
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
				
		      
		        str.append("<tr id='room' "+ret+" >");
		        
		        str.append("<td class='floatall'>");
		        str.append("<a href='#' class='l06c'>"+listroom.get(a).getName()+"</a>");
		        str.append("<!-- 床型图片 -->");
		        str.append("<div class='float_room msg' style='display:none;'>");
		        str.append("<ul class='msgul'>");
		        str.append("<li class=' pt5'><img src='images/hotel.jpg' width='90' height='80' /></li>");
		        str.append("<li>高级双人床</li>");
		        str.append("</ul>");
		        str.append("</div>");    
		        str.append("<!-- 床型图片 -->");
		        str.append("</td>");
		        str.append("<td class='font-f60-del'>&yen;"+menshijia+"</td>");
		        str.append("<td class='font-f60-16'>&yen;"+shourijia+"</td>");
		        str.append("<!--<td><span class='main_give f90 f mf15'>&yen;20</span></td>-->");
		        str.append("<td>"+BED+"</td>");
		        str.append("<td>"+Breakfast+"</td>");
		        str.append("<td>"+Wideband+"</td>");
		        str.append("<td>");
		    	System.out.println(listroom.get(a).getListRatePlan().get(0).getStatus());
				if(listroom.get(a).getListRatePlan().get(0).getStatus().equals("true")){  
		        str.append("<input type='button' class='bnt' value='预定' onclick='bookhotel("+listroom.get(a).getId()+","+hot.getId()+")'");
				}else{
			    str.append("<input type='button' disabled='disabled' class='bnt' value='满房' ");	
				}
		        str.append("</td>");
		        str.append("</tr>");
		        
		           
		        
				
				
				
				
				
				
				
				
				
			}
			if(ListGuaranteeRule!=null&&ListGuaranteeRule.size()>0){
			str.append("<tr>");
	        str.append("<td colspan='7' align='left'><span class='ico_tips f'>&nbsp;</span>");
	        for(int b=0;b<ListGuaranteeRule.size();b++){
				str.append(ListGuaranteeRule.get(b).getDescription()+"</br>");
				break;
			}
	        str.append("</td>");
	        str.append("</tr>");
			}
	        
			str.append("<tr>");
	        str.append("<td colspan='6' align='left'><span class='ico_tips f'>&nbsp;</span>");
	        //str.append("<!-- 11.1至12.15入住，全部房型均含早餐（以房型介绍信息为准）-->");
	        if(ListBookingRules!=null&&ListBookingRules.size()>0){
				str.append("预定须知:");
				for(int b=0;b<ListBookingRules.size();b++){
					str.append(ListBookingRules.get(b).getDescription()+"</br>");
					break;
				}
				
			}
	        str.append("</td>");
	        str.append("<td><a style='cursor:pointer;' href='javascript:void(0)' onclick='showAllroom()'>全部房型</a>");
	        str.append("<span id='show_"+hot.getId()+"' class='allshow'>&nbsp;</span>");
	        str.append("<span id='hide_"+hot.getId()+"' class='allnoshow' style='display: none'>&nbsp;</span>");
	        str.append("<input type='hidden' id='' name='' value='1' />");
	        str.append("</td>");
	        str.append("</tr>");
	        str.append("</table>");
			
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
	/**
	 * 获取session中酒店 2012-02-13 陈星
	 * 
	 * @throws
	 */

	public List GetSessionHotel(long id)throws Exception {
		Hotel seesionHotel=new Hotel();
		Listsessionhotel=(List) ActionContext.getContext().getSession().get("HotelList");
		if(Listsessionhotel!=null&&Listsessionhotel.size()>0){
			for(int h=0;h<Listsessionhotel.size();h++){
				
				if(Listsessionhotel.get(h).getId()==id){//有重复的
					
					
				}else{//没重复的
					seesionHotel=Server.getInstance().getHotelService().findHotel(id);
					
					Listsessionhotel.remove(Listsessionhotel.size()-1);
					Listsessionhotel.add(seesionHotel);
					
				}
				
			}
			
		}else{
			seesionHotel=Server.getInstance().getHotelService().findHotel(id);
			Listsessionhotel.set(0, seesionHotel);
		}
		
		
		return ListSessionHotel;
	}
	
	/**
	 * 删除session中重复酒店 2012-02-13 陈星
	 * 
	 * @throws
	 */
	public List DeleteSessionHotel(long id)throws Exception {
		List list = null;
		return  list;
		
	}
	/**
	 * 酒店详细信息 2012-02-13 陈星
	 * 
	 * @throws
	 */

	public String toHotelInfo() throws Exception {
		hotel=Server.getInstance().getHotelService().findHotel(HotelId);
		
	
		
		//GetSessionHotel(HotelId);
		//session
		
		String wher="";
		List<Hotel> listhotelsess=(List<Hotel>) ActionContext.getContext().getSession().get("listhotelsession");
		if(listhotelsess!=null&&listhotelsess.size()>0){
			if(listhotelsess.size()>4){
				
				listhotelsess.remove(0);
			}
			for(int s=0;s<listhotelsess.size();s++){
				long hid = listhotelsess.get(s).getId();
				wher+=","+hid;
				
			}
			
			if(wher.indexOf(hotel.getId()+"")==-1){
				//listh=listhotelsess;
				listhotelsess.add(hotel);
				ActionContext.getContext().getSession().put("listhotelsession", listhotelsess);
			}
			
		}else{
			
			 listhotelsess = new ArrayList();
			
			listhotelsess.add(hotel);
			ActionContext.getContext().getSession().put("listhotelsession", listhotelsess);
			
		}
		
		//
		
		cityId=hotel.getCityid();
		City city=Server.getInstance().getHotelService().findCity(cityId);
		CityName =city.getName();
		s_citycode=city.getCarcode();
		
		
		/*String snian=	startDate.substring(0,7);//开始年月
		String enian=	endDate.substring(0,7);//结束年月
		StringBuilder where = new StringBuilder(" where 1=1 and ID in (select C_ROOMID from "+Hotelprice.TABLE+" where C_HOTELID= ");
		where.append(hotel.getId());
		where.append(" and C_DATENUMBER ='");
		where.append(startDate.trim().substring(0,7));
		where.append("' and C_NO");
		where.append(Integer.parseInt(startDate.substring(8,10)));
		where.append(" >= 0");
		where.append(" and C_NO");
		where.append(Integer.parseInt(startDate.substring(8,10)));
		where.append(" <= 10000");
		where.append(")");
		ListRoomType=Server.getInstance().getHotelService().findAllRoomtype(where.toString(), " ORDER BY ID ", -1, 0);
		
		for(Roomtype roomtype : ListRoomType){
			
			
			String whereroom=" where 1=1 and "+Hotelprice.COL_roomid+" ="+roomtype.getId();
			List<Hotelprice>listprice=Server.getInstance().getHotelService().findAllHotelprice(" WHERE 1=1 AND "+Hotelprice.COL_hotelid+" ="+hotel.getId()+" and "+Hotelprice.COL_roomid+" ="+roomtype.getId()+" and "+Hotelprice.COL_datenumber+" ='"+snian+"'" , " ORDER BY ID  ", -1, 0);
			if(listprice.size()>0){
				String mnane="";
				if(startDate.substring(8,10).substring(0,1).equals("0")){
					 mnane = "getNo"+startDate.substring(8,10).substring(1);
				}else{
					 mnane = "getNo"+startDate.substring(8,10);
				}
				Class[] types = new Class[]{};
				Method method = listprice.get(0).getClass().getMethod(mnane, types);
				Object aa = method.invoke(listprice.get(0), new Object[0]);
				if(aa!=null&&!aa.equals("null")&&aa.toString().trim().length()>0){
				Double price = ((Double)aa).doubleValue();
				int pp=	(int)Math.floor(price);
				RoomPrice.put(roomtype.getId(), pp);
				}
			}else{
				RoomPrice.put(roomtype.getId(), 0);
				
			}
			
			
			
		}*/
		
		/*//以下为住哪实时价格查询
		String response=GetZhuNaHotelRoomPriceByHotelcode(hotel.getHotelcode(), startDate, endDate);
		
		
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
		
		
		List<Hotelimage> ListHotelimg =Server.getInstance().getHotelService().findAllHotelimage("where 1=1 and "+Hotelimage.COL_hotelid+" ="+hotel.getId(), " ORDER BY ID ", -1, 0);
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
		
		
		return "toHotelInfo";
	}

	/**
	 * 酒店所有图片 2012-02-13 陈星
	 * 
	 * @throws
	 */

	public String toallimages() {
		ListHotelimage =Server.getInstance().getHotelService().findAllHotelimage("where 1=1 and "+Hotelimage.COL_hotelid+" ="+HotelId, " ORDER BY ID ", -1, 0);
		System.out.println("ListHotelimage=="+ListHotelimage.size());
		return "toallimages";
	}
	/**
	 * 酒店预订 2012-02-13 陈星
	 * @throws Exception 
	 * 
	 * @throws
	 */

	public String tobook() throws Exception {
		if(getLoginUser()==null){
			//未登录时，保存当前参数，跳转至登录页面
			ActionContext.getContext().getSession().put("HotelParam",HotelId+"@"+RoomTypeid+"@"+startDate+"@"+endDate);
			ActionContext.getContext().getSession().put("pageUrl","hotel!tobook.jspx");
		
			return "toLogin";// 从新登陆
		}else{
			
			if(ActionContext.getContext().getSession().get("HotelParam")!=null)
			{
				String HotelParam=(String)ActionContext.getContext().getSession().get("HotelParam");
				System.out.println("HotelParam=="+HotelParam);
				String[] HotelParams=HotelParam.split("@");
				if(HotelId==null){
				HotelId=Long.parseLong(HotelParams[0]);
				}
				if(RoomTypeid==null){
				RoomTypeid=Long.parseLong(HotelParams[1]);
				}
				if(startDate==null&&startDate.length()==0){
				startDate=HotelParams[2];
				}
				if(endDate==null&&endDate.length()==0){
				endDate=HotelParams[3];
				}
			}
			
			
			
		}
		ActionContext.getContext().getSession().remove("HotelParam");
		ActionContext.getContext().getSession().remove("pageUrl");
		
		
		hotel=Server.getInstance().getHotelService().findHotel(HotelId);
		cityId=hotel.getCityid();
		roomtype =Server.getInstance().getHotelService().findRoomtype(RoomTypeid);
		//以下是解析星期信息
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
         
         //解析结束
		
         String snian=	startDate.substring(0,7);//开始yue
     	String enian=	endDate.substring(0,7);//开始yue
     	
     //	StringBuilder wherprice = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+roomtype.getId()+" and "+Hotelprice.COL_hotelid+"= "+hotel.getId() +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");
     //	ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wherprice.toString()," ORDER BY C_DATENUMBER ",-1,0);

     	int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
    	int startday=	Integer.parseInt(startDate.substring(8,10));//开始天
    	System.out.println("开始天:"+startday);
    	int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
    	System.out.println("结束月endDatemethod=="+endDatemethod);
    	int endday=	Integer.parseInt(endDate.substring(8,10))-1;//结束天
    	//int d = endday-1;
    	
    	
    		
    	
     	
         SeachHotelBean seachHotelBean=Server.getInstance().getHotelInterService().SerchHotelAllRoomAndPriceByHotelID(hotel, startDate, endDate,roomtype.getRoomcode()); 
         
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



    s_num=GetOneTwoTimeNum(startDate, endDate);
    
		
		return "tobook";
	}
	public String tobook_old() throws Exception {
		if(getLoginUser()==null){
			//未登录时，保存当前参数，跳转至登录页面
			ActionContext.getContext().getSession().put("HotelParam",HotelId+"@"+RoomTypeid+"@"+startDate+"@"+endDate);
			ActionContext.getContext().getSession().put("pageUrl","hotel!tobook.jspx");
		
			return "toLogin";// 从新登陆
		}else{
			
			if(ActionContext.getContext().getSession().get("HotelParam")!=null)
			{
				String HotelParam=(String)ActionContext.getContext().getSession().get("HotelParam");
				System.out.println("HotelParam=="+HotelParam);
				String[] HotelParams=HotelParam.split("@");
				if(HotelId==null){
				HotelId=Long.parseLong(HotelParams[0]);
				}
				if(RoomTypeid==null){
				RoomTypeid=Long.parseLong(HotelParams[1]);
				}
				if(startDate==null&&startDate.length()==0){
				startDate=HotelParams[2];
				}
				if(endDate==null&&endDate.length()==0){
				endDate=HotelParams[3];
				}
			}
			
			
			
		}
		ActionContext.getContext().getSession().remove("HotelParam");
		ActionContext.getContext().getSession().remove("pageUrl");
		
		
		hotel=Server.getInstance().getHotelService().findHotel(HotelId);
		cityId=hotel.getCityid();
		roomtype =Server.getInstance().getHotelService().findRoomtype(RoomTypeid);
		//以下是解析星期信息
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
         
         //解析结束
		
         String snian=	startDate.substring(0,7);//开始yue
     	String enian=	endDate.substring(0,7);//开始yue
     	
     	StringBuilder wherprice = new StringBuilder("where 1=1 and "+Hotelprice.COL_roomid+" ="+roomtype.getId()+" and "+Hotelprice.COL_hotelid+"= "+hotel.getId() +" and ("+Hotelprice.COL_datenumber+ " between '"+snian+"' and '"+ enian+"')");
     	ListHotelprice = Server.getInstance().getHotelService().findAllHotelprice(wherprice.toString()," ORDER BY C_DATENUMBER ",-1,0);

     	int	startmethod = Integer.parseInt(startDate.trim().substring(5,7));//开始月份
    	int startday=	Integer.parseInt(startDate.substring(8,10));//开始天
    	System.out.println("开始天:"+startday);
    	int	endDatemethod = Integer.parseInt(endDate.trim().substring(5,7));//结束月份
    	System.out.println("结束月endDatemethod=="+endDatemethod);
    	int endday=	Integer.parseInt(endDate.substring(8,10))-1;//结束天
    	//int d = endday-1;
    	
    	if(startmethod == endDatemethod){//如果在相同月份的话
    		System.out.println("月份相同");
    			for(int a=startday;a<=endday;a++){
    				
    				String mnane = "getNo"+a;
    				Class[] types = new Class[]{};
    				Method method = ListHotelprice.get(0).getClass().getMethod(mnane, types);
    				Object aa = method.invoke(ListHotelprice.get(0), new Object[0]);
    					if(aa!=null&&!aa.equals("null")&&aa.toString().trim().length()>0){
    						Double price = ((Double)aa).doubleValue();
    						int dayprice=	(int)Math.floor(price);
    						zongjia +=dayprice;
    						System.out.println("zongjia=="+zongjia);
    						
    							String	sday =startmethod+"-"+a;
    							String sub="<td align='center' class='font-f60-16'>&yen;"+dayprice+"<span class='time'>"+sday+"</span></td>";
    							//Listroomtypeprice.add(asas);
    							Listprice.add(dayprice);
    							Listday.add(sub);
    					}
    				}
    		}
		
		return "tobook";
	}
	/**
	 * 酒店下单 2012-02-13 陈星
	 * @throws Exception 
	 * 
	 * @throws
	 */
	public String book() throws Exception{
		if(getLoginUser()==null){
			
			return "toLogin";// 从新登陆
		}
		hotel=Server.getInstance().getHotelService().findHotel(HotelId);
		Roomtype room= Server.getInstance().getHotelService().findRoomtype(RoomTypeid);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date time = df.parse(startDate);
		Date time2 = df.parse(endDate);
		long manyday = (time2.getTime()-time.getTime())/(24*3600*1000);
		int  many = (int)manyday;
		hotelorder.setHotelid(hotel.getId());
		hotelorder.setName(hotel.getName()) ;
		hotelorder.setManyday(many);
		hotelorder.setDayprice(HotelDayPrice);
		int pric=HotelPrice*RoomTypeNum;
		hotelorder.setPrice(pric+"");
		hotelorder.setPrerooms(RoomTypeNum);
		hotelorder.setDanbao(0);
		hotelorder.setYestate(0);//0,未夜审 1,已夜审,全部正常 2,已也审,非正常 
		hotelorder.setRoomtypename(room.getName());
		hotelorder.setProperty("1");
		hotelorder.setPaystate(0l);//0未支付,1已支付,2已退款
		hotelorder.setRoomid(room.getId());
		hotelorder.setComedate((new Timestamp(time.getTime())));
		hotelorder.setLeavedate((new Timestamp(time2.getTime())));
		hotelorder.setCreateuserid(getLoginUser().getId());
		hotelorder.setMembername(getLoginUser().getMembername());
		hotelorder.setMemberid(getLoginUser().getId());
		hotelorder.setType(1);
		hotelorder.setChecktype(hotel.getChecktype());
		hotelorder.setState(0);
		hotelorder.setLinkmobile(LinkMobile);
		hotelorder.setLinkmail(LinkMail);
		hotelorder.setLinkname(LinkName);
		hotelorder.setPricecodeid(pricecode);//价格计划ID
		
		
		String[] strarrGuest=InRoomPeople.split(",");
		for(int i=0;i<strarrGuest.length;i++)
		{   
			if(strarrGuest[i]!=null && !strarrGuest[i].toString().equals(" "))
			{
				add++;
			}
		}
		hotelorder.setOrderpeaple(add);
		
		hotelorder=Server.getInstance().getHotelService().createHotelorder(hotelorder);
		List<Guest>listgu=new ArrayList<Guest>();
		for(int i=0;i<strarrGuest.length;i++)
		{   
			Guest guest=new Guest();
			if(strarrGuest[i]!=null && !strarrGuest[i].toString().equals(" "))
			{
				 guest=new Guest(); 
				guest.setMemo(hotelorder.getConfirmmethod()+"");
				guest.setLanguage(0);
				guest.setOrderid(hotelorder.getId());
				guest.setMobile(hotelorder.getLinkmobile());
				//guest.setSex(1l);
				guest.setName(strarrGuest[i]);
				guest.setRuzhutime(hotelorder.getComedate());
				guest.setLikaitime(hotelorder.getLeavedate());
				guest.setState(1l); //1，正常 2,提前离店 3,延住 4,取消
				guest.setPrice(hotelorder.getDayprice());
				guest.setCountry("中国");
				guest=Server.getInstance().getHotelService().createGuest(guest);
				listgu.add(guest);
			}
		}
		//添加信用卡信息
		/*if(cardno!=null&&cardno.trim().length()>0){
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
		}*/
		
		String wcode=Server.getInstance().getHotelInterService().CreateHotelOrder(hotelorder, listgu);
		System.out.println("waicode:"+wcode);

		if(wcode!=null&&!wcode.equals("-1")){
			System.out.println("elong酒店下单成功:");
			hotelorder.setState(1);
			hotelorder.setWaicode(wcode.trim());
//			hotelorder.setProfits(Double.parseDouble(wcode.split("@")[1].trim()));//订单总利润
			
		}else{
			hotelorder.setWaicode(wcode);
			hotelorder.setState(88);
			System.out.println("elong酒店下单失败:");
		}
		
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		if(hotelorder.getState()==1){
			forword ="hotel!tosuccess.jspx?HotelId="+hotelorder.getHotelid()+"&HotelOrderID="+hotelorder.getId()+"&endDate="+endDate+"&startDate="+startDate;
			}else{
				Server.getInstance().getHotelService().deleteHotelorder(hotelorder.getId());
				Server.getInstance().getHotelService().excuteGuestBySql(" DELETE "+Guest.TABLE+" where "+Guest.COL_orderid+" ="+hotelorder.getId());
				//Server.getInstance().getMemberService().excuteCreditcardBySql(" DELETE "+Creditcard.TABLE+" WHERE "+Creditcard.COL_hotelorderid+" ="+hotelorder.getId());
			forword ="hotel!toErr.jspx";
			
			}
		
		
		return "toorder";
	}
	public String tosuccess()throws Exception{
		System.out.println(HotelId);
		hotelorder = Server.getInstance().getHotelService().findHotelorder(HotelOrderID);
		
		if(hotelorder!=null&&hotelorder.getMemberid()==getLoginUser().getId()){
			hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
			ListGuest = Server.getInstance().getHotelService().findAllGuest("where 1=1 and "+Guest.COL_orderid+" ="+hotelorder.getId(), " ORDER BY ID ", -1, 0);
			cityId = hotel.getCityid();
		   return "tosuccess";
		}else{
			
			forword="hotel!toindex.jspx";
			 return "toorder";
		}
		
		
	}
	public String toErr()throws Exception{
		System.out.println("预订失败");
		return "toErr";
}
	/**
	 * AJAX读取酒店城市
	 * 
	 * @throws
	 */
	public void getHotelCity() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere = "WHERE 1=1 and " + City.COL_countryid + " =168";
		strwhere += "and " + City.COL_language + " =0";

		List<City> listAirport = Server.getInstance().getHotelService()
				.findAllCity(strwhere, "ORDER BY C_SORT", -1, 0);
		for (City airPort : listAirport) {
			sb.append(airPort.getName() + "#" + airPort.getEnname() + "%"
					+ airPort.getSname() + "&" + airPort.getId() + ",");
		}
		// return strRetData;
		//System.out.println("SB==" + sb);
		out.print(sb);
		out.flush();
		out.close();
		
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return hotelorder;
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

	public String getS_price() {
		return s_price;
	}

	public void setS_price(String s_price) {
		this.s_price = s_price;
	}

	public String getS_star() {
		return s_star;
	}

	public void setS_star(String s_star) {
		this.s_star = s_star;
	}

	public String getStrHotelCity() {
		return strHotelCity;
	}

	public void setStrHotelCity(String strHotelCity) {
		this.strHotelCity = strHotelCity;
	}

	public List<Informationinfo> getListZX() {
		return listZX;
	}

	public void setListZX(List<Informationinfo> listZX) {
		this.listZX = listZX;
	}

	public List<Chaininfo> getListChaininfo() {
		return ListChaininfo;
	}

	public void setListChaininfo(List<Chaininfo> listChaininfo) {
		ListChaininfo = listChaininfo;
	}

	public int getCitynum() {
		return citynum;
	}

	public void setCitynum(int citynum) {
		this.citynum = citynum;
	}

	public int getHotelnum() {
		return hotelnum;
	}

	public void setHotelnum(int hotelnum) {
		this.hotelnum = hotelnum;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
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

	public Map<Long, Integer> getRoomPrice() {
		return RoomPrice;
	}

	public void setRoomPrice(Map<Long, Integer> roomPrice) {
		RoomPrice = roomPrice;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public List<Region> getListRegion() {
		return ListRegion;
	}

	public void setListRegion(List<Region> listRegion) {
		ListRegion = listRegion;
	}

	public Long getHotelId() {
		return HotelId;
	}

	public void setHotelId(Long hotelId) {
		HotelId = hotelId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Roomtype> getListRoomType() {
		return ListRoomType;
	}

	public void setListRoomType(List<Roomtype> listRoomType) {
		ListRoomType = listRoomType;
	}

	public List<Hotelimage> getListHotelimage() {
		return ListHotelimage;
	}

	public void setListHotelimage(List<Hotelimage> listHotelimage) {
		ListHotelimage = listHotelimage;
	}

	public Long getRoomTypeid() {
		return RoomTypeid;
	}

	public void setRoomTypeid(Long roomTypeid) {
		RoomTypeid = roomTypeid;
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

	public List<Hotelprice> getListHotelprice() {
		return ListHotelprice;
	}

	public void setListHotelprice(List<Hotelprice> listHotelprice) {
		ListHotelprice = listHotelprice;
	}

	public List getListprice() {
		return Listprice;
	}

	public void setListprice(List listprice) {
		Listprice = listprice;
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

	public List getListday() {
		return Listday;
	}

	public void setListday(List listday) {
		Listday = listday;
	}

	public Hotelorder getHotelorder() {
		return hotelorder;
	}

	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
	}

	public List<Guest> getListGuest() {
		return ListGuest;
	}

	public void setListGuest(List<Guest> listGuest) {
		ListGuest = listGuest;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}

	public String getInRoomPeople() {
		return InRoomPeople;
	}

	public void setInRoomPeople(String inRoomPeople) {
		InRoomPeople = inRoomPeople;
	}

	public String getLinkMobile() {
		return LinkMobile;
	}

	public void setLinkMobile(String linkMobile) {
		LinkMobile = linkMobile;
	}

	public String getLinkMail() {
		return LinkMail;
	}

	public void setLinkMail(String linkMail) {
		LinkMail = linkMail;
	}

	public int getHotelPrice() {
		return HotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		HotelPrice = hotelPrice;
	}

	public int getRoomTypeNum() {
		return RoomTypeNum;
	}

	public void setRoomTypeNum(int roomTypeNum) {
		RoomTypeNum = roomTypeNum;
	}

	public String getHotelDayPrice() {
		return HotelDayPrice;
	}

	public void setHotelDayPrice(String hotelDayPrice) {
		HotelDayPrice = hotelDayPrice;
	}

	public List<Hotel> getListSessionHotel() {
		return ListSessionHotel;
	}

	public void setListSessionHotel(List<Hotel> listSessionHotel) {
		ListSessionHotel = listSessionHotel;
	}

	public List<Hotel> getListsessionhotel() {
		return Listsessionhotel;
	}

	public void setListsessionhotel(List<Hotel> listsessionhotel) {
		Listsessionhotel = listsessionhotel;
	}

	public String getStrHotelStar() {
		return strHotelStar;
	}

	public void setStrHotelStar(String strHotelStar) {
		this.strHotelStar = strHotelStar;
	}

	public String getStrHotelRegion() {
		return strHotelRegion;
	}

	public void setStrHotelRegion(String strHotelRegion) {
		this.strHotelRegion = strHotelRegion;
	}

	public String getStrHotelIndex() {
		return strHotelIndex;
	}

	public void setStrHotelIndex(String strHotelIndex) {
		this.strHotelIndex = strHotelIndex;
	}

	public int getRegionID() {
		return RegionID;
	}

	public void setRegionID(int regionID) {
		RegionID = regionID;
	}

	public String getLinkName() {
		return LinkName;
	}

	public void setLinkName(String linkName) {
		LinkName = linkName;
	}

	public Map<Long, List> getRoomListPrice() {
		return RoomListPrice;
	}

	public void setRoomListPrice(Map<Long, List> roomListPrice) {
		RoomListPrice = roomListPrice;
	}

	public Map<Long, List<Hotelprice>> getMapRoomprice() {
		return mapRoomprice;
	}

	public void setMapRoomprice(Map<Long, List<Hotelprice>> mapRoomprice) {
		this.mapRoomprice = mapRoomprice;
	}

	public List getListroomtypeprice() {
		return Listroomtypeprice;
	}

	public void setListroomtypeprice(List listroomtypeprice) {
		Listroomtypeprice = listroomtypeprice;
	}

	public String getS_citycode() {
		return s_citycode;
	}

	public void setS_citycode(String s_citycode) {
		this.s_citycode = s_citycode;
	}

	public long getS_num() {
		return s_num;
	}

	public void setS_num(long s_num) {
		this.s_num = s_num;
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

	public String getPricecode() {
		return pricecode;
	}

	public void setPricecode(String pricecode) {
		this.pricecode = pricecode;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public Long getHotelOrderID() {
		return HotelOrderID;
	}

	public void setHotelOrderID(Long hotelOrderID) {
		HotelOrderID = hotelOrderID;
	}



}