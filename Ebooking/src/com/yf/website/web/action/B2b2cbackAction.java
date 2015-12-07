﻿package com.yf.website.web.action;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.city.City;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.fairport.Fairport;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.incity.Incity;
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.liudianrecord.Liudianrecord;

import com.yf.system.base.rebaterecord.Rebaterecord;
import com.yf.system.base.rebaterule.Rebaterule;

import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;

import com.yf.system.base.region.Region;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotlineimg.Spotlineimg;
import com.yf.system.base.spotmes.Spotmes;
import com.yf.system.base.spotticket.Spotticket;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.base.train.Train;
import com.yf.system.base.trainpassenger.Trainpassenger;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.ModelDriven;

public abstract class B2b2cbackAction extends ActionSupport implements ModelDriven{
		public static final String LIST = "list";
		public static final String EDIT = "edit";
		public static final String SEARCH = "search";
		public static final String CHECK = "check";
		public static final String ADDORDER = "addorder";
		
		
		 
		
		protected  String url ; 
		//pro
		
		protected PageInfo pageinfo = new PageInfo();
		
		
		public PageInfo getPageinfo(){
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
		
		public Timestamp getCurrentTime(){
			return new Timestamp(System.currentTimeMillis());
		}
		
		
		/**
		 * 根据酒店ID获取对应图片路径
		 * @param hotelid
		 * @return  图片路径
		 */
		public String getImageSRc(long hid) {
		//	Hotel hot = Server.getInstance().getHotelService().findHotel(hid);
			
			String where=" WHERE " + Hotelimage.COL_hotelid +" ="+hid;
			List<Hotelimage> listImages = Server.getInstance().getHotelService().findAllHotelimage(where, " ORDER BY ID" , -1, 0) ;
			if(listImages.size() > 0) {
				if(listImages.get(0).getPath()==null||listImages.get(0).getPath().trim().length()==0){
					return "images/NoImage.gif" ;
				}else
				if(!listImages.get(0).getPath().substring(0, 4).equals("http")){
				return "http://www.elongstatic.com/imageapp/hotels/hotelimages"+listImages.get(0).getPath().split("@")[0] ;
				}else{
					
				return listImages.get(0).getPath().split("@")[0] ;	
				}
				
			}
			return "images/NoImage.gif" ;
		}
		/**
		 * 根据机场三字码获取机场名称
		 * 
		 * @param aircompany
		 * @return
		 */
		public String getAirPortNamebyCode(String code) {
			String where = "where " + Fairport.COL_airportcode + "='" + code + "'";
			List<Fairport> list = Server.getInstance().getInterticketService()
					.findAllFairport(where, "ORDER BY ID", -1, 0);
			return list != null && list.size() > 0 ? list.get(0).getAirportname()
					: "";

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
		 * 根据酒店ID获取对应图片路径
		 * @param hotelid
		 * @return  图片路径
		 */
		public String getImage(long hid) {
		//	Hotel hot = Server.getInstance().getHotelService().findHotel(hid);
			
			String where=" WHERE " + Hotelimage.COL_hotelid +" ="+hid;
			List<Hotelimage> listImages = Server.getInstance().getHotelService().findAllHotelimage(where, " ORDER BY ID" , -1, 0) ;
			if(listImages.size() > 0) {
				return listImages.get(0).getPath() ;
			}
			return "/NoImage.gif" ;
		}
		/**
		 * 得到订单的状态
		 */
		public String getInterHotelorderState(Integer state) {
			System.out.println("state==" + state);
			

			if(state==1){
				return "待确认";
			}
			if(state==2){
				return "已确认,待支付";
			}
			if(state==3){
				return "已支付";
			}
			if(state==4){
				return "已入住";
			}
			if(state==5){
				return "已离店";
			}
			if(state==6){
				return "已取消";
			}
			if(state==7){
				return "满房";
			}
			if(state==8){
				return "变更";
			}
			if(state==9){
				return "No Show";
			}
			if(state==88){
				return "问题订单";
			}else{
				return "未知订单";
			}

		}

		public static Timestamp dateToTimestamp2(String date){
			try {
				SimpleDateFormat dateFormat=new SimpleDateFormat();
				if(date.length()==10)
				{
				dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				}else
				{
				dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
				}
				return (new Timestamp(dateFormat.parse(date).getTime()));
				
			} catch (Exception e) {
				return null;
			}
			
		}
		public String getroomnamebyid(long id ){
			
			return Server.getInstance().getHotelService().findRoomtype(id).getName();
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
		/**
		 * 根据政策值得到分销商留点设置值
		 * @return 如果配置到留点设置值就返回留点设置值，否则返回原来的政策值
		 */
		public float Getliudianvalue_b2c(float fvalue)
		{
			Long agentid=46l;//初始化id
			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			
			//取session里面agentid
			if(session.getAttribute("b2cdns")!=null){
				Dnsmaintenance dns=(Dnsmaintenance)session.getAttribute("b2cdns");
				if(dns.getAgentid()>0){
					agentid=dns.getAgentid();
				}
			}
			
			
			float freturn=fvalue;
			List<Liudianrecord> Fliudianinfolist = new ArrayList<Liudianrecord>();
			List <Settlementtype>  list=Server.getInstance().getMemberService().findAllSettlementtype(" WHERE 1=1 AND "+Settlementtype.COL_agentid+" ="+agentid+" AND "+Settlementtype.COL_typename+" ='B2C留点'", " ORDER BY ID ", -1, 0);
			if(list!=null&&list.size()>0){
				String strwhere=" where 1=1";
				strwhere+=" and "+Liudianrecord.COL_typeid+"="+list.get(0).getId();
				Fliudianinfolist=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);
			}
			
			
			
			
			
			
			
			//ActionContext.getContext().getSession().put("Fliudianvalue",Fliudianinfolist);//父登陆者得留点
			
			if(Fliudianinfolist!=null&&Fliudianinfolist.size()>0)
				{
						for(Liudianrecord ld :Fliudianinfolist){
								if(fvalue>= ld.getFandianstart() && fvalue< ld.getFandianend()){
									freturn = fvalue-ld.getLiudian();
									fvalue=freturn;
									break;
								}
							
						}
				}
			
		
			
			
			
			
			return fvalue;
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
			if (t != null && !t.equals("")) {
				return t;
			}
			return v;
		}
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();

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
		private SimpleDateFormat simplefromat = new SimpleDateFormat("yy-MM-dd");

		public String formatStringTime(String date) {
			try {
				return this.simplefromat.format((simplefromat.parse(date)));

			} catch (Exception e) {
				return null;
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

		public String getGBKString(String str){
			if(str!=null){
				try {
					return new String(str.getBytes("ISO8859-1"),"GBK");
				} catch (Exception e) {
				
				}
			}
			return str;
		}
		public float getRoundPrice(float price,int f)
		{
			return (float)Math.round(price/10/f+0.00001)*10;
		}
		public Double getdeptprice2(String price) {//目前改成 当前价格*1.2
			price = price.trim().replace("￥", "");
			Double p = Double.parseDouble(price);
			
			return p*1.2;
					
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
		public String getinfotypenamebyid(long id){
			
			return Server.getInstance().getMemberService().findInfotype(id).getTypename();
		}
		public String getChaininfoNameById(long id){
			
			return Server.getInstance().getHotelService().findChaininfo(id).getName();
		}
	/*	//获取会员级别名字
		public String getlevelname(long id) {
			
			return Server.getInstance().getMemberService().findLevel(id).getName(); 
		}
		//根据级别id取级别值
		public Double getlevelvalueBYid(long id) {
			
			return Server.getInstance().getMemberService().findLevel(id).getLvalue(); 
		}*/
		/**
		 * @param str
		 * @return 是否为null或""
		 */
		protected boolean isNotNullOrEpt(String str) {
			if (str != null && str.trim().trim().length() > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		
		public Long GetAgentID(){
			Long agentid=46l;
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			
			//取session里面agentid
			if(session.getAttribute("b2cdns")!=null){
				Dnsmaintenance dns=(Dnsmaintenance)session.getAttribute("b2cdns");
				if(dns.getAgentid()>0){
					agentid=dns.getAgentid();
				}
			}
			
			return agentid;
		}
		
		
		/**
		 * 根据政策值得到分销商留点设置值
		 * @return 如果配置到留点设置值就返回留点设置值，否则返回原来的政策值
		 */
		public float Getliudianvalue(float fvalue)
		{
			Long agentid=46l;//初始化id
			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			
			//取session里面agentid
			if(session.getAttribute("b2cdns")!=null){
				Dnsmaintenance dns=(Dnsmaintenance)session.getAttribute("b2cdns");
				if(dns.getAgentid()>0){
					agentid=dns.getAgentid();
				}
			}
			
			
			
			float freturn=fvalue;
			
		
		
			//List<Customeragent> li=Server.getInstance().getMemberService().findAllCustomeragent(" where 1=1 and "+Customeragent.COL_code+" ='B2CANGENT'", "", -1, 0);
			//long andid =li.get(0).getId();//初始化B2C用户的加盟商
			
			
			
			
			
			List<Liudianrecord> Fliudianinfolist = null;
			agentid=48l;
			String str=" WHERE 1=1 AND C_TYPEID = (select top 1 C_TYPEID from T_LIUDIANREFINFO where C_AGENTID="+agentid+")";
			Fliudianinfolist=Server.getInstance().getMemberService().findAllLiudianrecord(str, "ORDER BY ID", -1, 0);
			
			//ActionContext.getContext().getSession().put("Fliudianvalue",Fliudianinfolist);//父登陆者得留点
			
			if(Fliudianinfolist!=null)
				{
						for(Liudianrecord ld :Fliudianinfolist){
								if(fvalue>= ld.getFandianstart() && fvalue< ld.getFandianend()){
									freturn = fvalue-ld.getLiudian();
									fvalue=freturn;
									break;
								}
							
						}
				}
			
		
			
			
			
			
			return fvalue;
		}
		
		public void remotinRequest(String urlstr){
			try {
				URL url=new URL(urlstr);
				HttpURLConnection connection=(HttpURLConnection) url.openConnection();
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.setRequestProperty("Accept-Charset", "gb2312");
				connection.connect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//根据B2C会员级别取出对应返点值,计算出返点后价格
		public Double getpriceBYlevelid(Double price,String z_startcity,String z_endcity,String fromtime,String flightnumber,String cabincode) {
			System.out.println("进来了!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Calendar cal=Calendar.getInstance(); 
		    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
		    String mDateTime=formatter.format(cal.getTime());
		    String fnumber=flightnumber.substring(2, flightnumber.length());
			//匹配政策开始
			String sql = "where C_DEPARTUREPORT like '%"
				+ z_startcity
				+ "%'"
				+ " and C_ARRIVALPORT like '%"
				+ z_endcity
				+ "%'"
				+ " and C_AIRCOMPANYCODE like '%"
				+ flightnumber.substring(0, 2)
				+ "%'"
				
				+ " AND C_ISENABLE =1"
				+ " AND C_GENERAL =1"
							
				+" and ((c_type is NULL or c_type=0)or (C_TYPE=1 and C_FLIGHTNUMBER like '%"+fnumber+"%')or (C_TYPE=2 and C_FLIGHTNUMBER not like '%"+fnumber+"%'))"
						
				//+ " and C_FLIGHTNUMBER like '%"
				//+ flightnumber.substring(2, flightnumber.length())
				//+ "%'"
				+ " and C_CABINCODE like '%"
				+ cabincode
				+ "%'"
				+ " and '"+fromtime+"' between C_BEGINDATE and C_ENDDATE  AND '"+mDateTime+"' between C_WORKTIME and C_AFTERWORKTIME  and C_RATEVALUE>0";
		List<Zrate> listzrate = Server
				.getInstance()
				.getAirService()
				.findAllZrate(sql,
						" ORDER BY " + Zrate.COL_ratevalue + " DESC ", -1, 0);
			//结束
		Float fvalue=null;
		if(listzrate.size()>0&&listzrate.get(0).getRatevalue()!=null&&listzrate.get(0).getRatevalue()>0&&listzrate.get(0).getRatevalue().toString().trim().length()>0){
			//开始
			
			Zrate zrate=listzrate.get(0);
			//取出B2C用户返点值
			
				fvalue=zrate.getRatevalue();
				float freturn=fvalue;	
				List<Customeragent> li=Server.getInstance().getMemberService().findAllCustomeragent(" where 1=1 and "+Customeragent.COL_code+" ='B2CANGENT'", "", -1, 0);
				long andid =li.get(0).getId();//B2C用户的加盟商
				List<Liudianrecord> Fliudianinfolist = null;
				String str=" WHERE 1=1 AND C_AGENTID = (select top 1 C_TYPEID from T_LIUDIANREFINFO where C_AGENTID="+andid+")";
				Fliudianinfolist=Server.getInstance().getMemberService().findAllLiudianrecord(str, "ORDER BY ID", -1, 0);
				if(Fliudianinfolist!=null)
					{
							for(Liudianrecord ld :Fliudianinfolist){
									if(fvalue>= ld.getFandianstart() && fvalue< ld.getFandianend()){
										freturn = fvalue-ld.getLiudian();
										fvalue=freturn;
										//break;
										//结束
										ActionContext.getContext().getSession().put("uservalue",fvalue);
										System.out.println("政策点数=="+zrate.getRatevalue());
										Double ZProfit=price*zrate.getRatevalue()/100;//总利润
										System.out.println("政策利润=="+ZProfit);
										System.out.println("B2C用户留点=="+(zrate.getRatevalue()-fvalue));
										System.out.println("B2C用户看见价格shi=="+(price-(zrate.getRatevalue()-fvalue)*price/100));
										return (price-(zrate.getRatevalue()-fvalue)*price/100);
									}
							}
							
							
					}else{
						return price;
					}
			
		
			
			
			
		}else{
			
			return price;
		}
		
			
		
		
		
			return price;
		}
		//根据B2C会员级别取出对应返点值,计算出返点后价格
		public Double getpriceBYlevelid__(Double price,String z_startcity,String z_endcity,String fromtime,String flightnumber,String cabincode) {
			
			System.out.println("价格=="+price+"--出发机场=="+z_startcity+"--到达机场=="+z_endcity+"--出发时间=="+fromtime+"--航班号=="+flightnumber+"--仓位吗=="+cabincode);
			
			//取出B2C用户返点值
			Object obj =  ActionContext.getContext().getSession().get("uservalue");
			
			String uservalue="1";
			
			if(obj!=null){
				uservalue = (String) obj;
			}else{
				//取得B2C用户返点
				
				
			String Swhere=" where 1=1 and "+Sysconfig.COL_name+" ='B2C用户返点'";	
			List<Sysconfig>listsys=Server.getInstance().getMemberService().findAllSysconfig(Swhere, "", -1, 0);
				if(listsys.size()>0){
					
					ActionContext.getContext().getSession().put("uservalue",listsys.get(0).getValue());
					
				}
			
				
			}
			
			
			
			String sql = "where C_DEPARTUREPORT like '%"
				+ z_startcity
				+ "%'"
				
				+ " and C_ARRIVALPORT like '%"
				+ z_endcity
				+ "%'"
				
				
				+ " and C_AIRCOMPANYCODE like '%"
				+ flightnumber.substring(0, 2)
				+ "%'"
				
				+ " and C_FLIGHTNUMBER like '%"
				+ flightnumber.substring(2, flightnumber.length())
				+ "%'"
				
				+ " and C_CABINCODE like '%"
				+ cabincode
				+ "%'"
				
				+ " and '"+fromtime+"' between C_BEGINDATE and C_ENDDATE";
				
		System.out.println(sql);
		List<Zrate> listzrate = Server
				.getInstance()
				.getAirService()
				.findAllZrate(sql,
						" ORDER BY " + Zrate.COL_ratevalue + " DESC ", -1, 0);
		
		if(listzrate.size()>0&&listzrate.get(0).getRatevalue()!=null&&listzrate.get(0).getRatevalue()>0&&listzrate.get(0).getRatevalue().toString().trim().length()>0){
			
			
			Zrate zrate=listzrate.get(0);
			System.out.println("政策点数=="+zrate.getRatevalue());
			Double ZProfit=price*zrate.getRatevalue()/100;//总利润
			System.out.println("政策利润=="+ZProfit);
			Double UserProfit=ZProfit*Double.parseDouble(uservalue)/100;//用户利润
			System.out.println("用户利润=="+UserProfit);
			Double PTProfit=ZProfit-UserProfit;//平台利润
			System.out.println("平台利润=="+PTProfit);
			return price-UserProfit;
			
		}else{
			
			return price;
		}
		
			
		
		
		
			//return price;
		}
		public String getB2CZateId(String z_startcity,String z_endcity,String fromtime,String flightnumber,String cabincode) {
			
			System.out.println("--出发机场=="+z_startcity+"--到达机场=="+z_endcity+"--出发时间=="+fromtime+"--航班号=="+flightnumber+"--仓位吗=="+cabincode);
			
			
			
			
			
			String sql = "where C_DEPARTUREPORT like '%"
				+ z_startcity
				+ "%'"
				
				+ " and C_ARRIVALPORT like '%"
				+ z_endcity
				+ "%'"
				
				
				+ " and C_AIRCOMPANYCODE like '%"
				+ flightnumber.substring(0, 2)
				+ "%'"
				
				+ " and C_FLIGHTNUMBER like '%"
				+ flightnumber.substring(2, flightnumber.length())
				+ "%'"
				
				+ " and C_CABINCODE like '%"
				+ cabincode
				+ "%'"
				
				+ " and '"+fromtime+"' between C_BEGINDATE and C_ENDDATE";
				
		System.out.println(sql);
		List<Zrate> listzrate = Server
				.getInstance()
				.getAirService()
				.findAllZrate(sql,
						" ORDER BY " + Zrate.COL_ratevalue + " DESC ", -1, 0);
		
		if(listzrate.size()>0&&listzrate.get(0).getRatevalue()!=null&&listzrate.get(0).getRatevalue()>0&&listzrate.get(0).getRatevalue().toString().trim().length()>0){
			
			
		 return listzrate.get(0).getId()+"";
			
		}
		
			
		
		
		return "0";
		
		}
		
		/**
		 * 通过订单ID获取行程
		 * @param id
		 * @return
		 */
		public Segmentinfo getsegmentinfobyid(long id)
		{
			List<Segmentinfo> list=Server.getInstance().getAirService().findAllSegmentinfo(" where "+Segmentinfo.COL_orderid+" = "+id, "", -1, 0);
			if(list!=null&&list.size()>0)
			{
				return list.get(0);
			}
			return null;
		}
		public boolean isLogin(){
			Customeruser platformuser = (Customeruser)ActionContext.getContext().getSession().get("loginuser");		
			if(platformuser!=null)
			{
				return true;
			}
			return false;
		}
		//根据区域ID查找酒店数量
		public long gethotelnumbyregion(long id,String hotelName,long cityid){
			String where =" where 1=1 ";
			if(hotelName!=null&&hotelName.length()>0){
	    		/*String expr = new String(hotelName.getBytes("ISO-8859-1"),"UTF-8");
	    		System.out.println("expr=="+expr);
	    		hotelName=expr;*/
				System.out.println("区域有参数=="+hotelName);
				where +="and ("+Hotel.COL_regionid1+" ="+id+" OR "+Hotel.COL_regionid2+" ="+id+" OR "+Hotel.COL_regionid3+" ="+id+" ) and "+Hotel.COL_name+" like '%"+hotelName+"%' and "+Hotel.COL_cityid+" ="+cityid;
	    	}else{
	    		System.out.println("区域无参数==");
	    		where +="and ("+Hotel.COL_regionid1+" ="+id+" OR "+Hotel.COL_regionid2+" ="+id+" OR "+Hotel.COL_regionid3+" ="+id+" and "+Hotel.COL_cityid+" ="+cityid+")";
	    		
	    	}
			
			List<Hotel>listhotel=Server.getInstance().getHotelService().findAllHotel(where, "", -1, 0);
			if(listhotel.size()>0){
				return listhotel.size();
			}else{
				
				return 0;
			}
			
		}
		//根据酒店id得到该酒店的一个房型的首日价
		public Double getchanginfo(long hid) throws Exception{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
			String h_starttime = sdf.format(new Date());
			String snian=	h_starttime.substring(0,7);//开始yue
			int sday=	Integer.parseInt(h_starttime.substring(8,10));//开始天
			
			List<Roomtype>listroom=Server.getInstance().getHotelService().findAllRoomtype(" where 1=1 and "+Roomtype.COL_hotelid+" ="+hid+" and "+Roomtype.COL_id+" in ( SELECT "+Hotelprice.COL_roomid+" FROM "+Hotelprice.TABLE+" where "+Hotelprice.COL_hotelid+" ="+hid+" and "+Hotelprice.COL_datenumber+" ='"+snian+"'"+" AND C_NO"+sday+">0)", " ORDER BY ID DESC", -1, 0);
			
			if(listroom.size()>0){
				
				long roomid = listroom.get(0).getId();
				String where =" where 1=1 and "+Hotelprice.COL_hotelid+" ="+hid+" and "+Hotelprice.COL_roomid+" ="+roomid+" and "+Hotelprice.COL_datenumber+" ='"+snian+"'";
				List<Hotelprice>listprice = Server.getInstance().getHotelService().findAllHotelprice(where, "", -1, 0);
				if(listprice.size()>0){
					String mnane = "getNo"+sday;
					Class[] types = new Class[]{};
					Method method = listprice.get(0).getClass().getMethod(mnane, types);
					
					Object aa = method.invoke(listprice.get(0), new Object[0]);
					if(aa!=null&&!aa.equals("null")&&aa.toString().trim().length()>0){
					Double price = ((Double)aa).doubleValue();
					return price*0.05;
					}
					
				}
			}
			
			
			return 10.0;
					
		}	
		public String getima(String url){
			if(url==null||url.equals("")){
				
				return "images/NoImage.gif";
			}
			
			if(url.indexOf(",")!=-1){
				
				return url.split(",")[0];
			}else{
				
				
				return url;
			}
			
			
		}
		
		/**
		 * 根据代理商的类型id得到代理商是属于省代理，市代理，分销商
		 * 
		 * @return
		 */
		/**
		 * 根据代理商的类型id得到代理商是属于省代理，市代理，分销商
		 * 
		 * @return
		 */
		public String getAgentTypeName(int jibie,int spcieal) {
			int id = jibie;
			String strReturn = "";

				if (spcieal>0) {
					id = spcieal;
					strReturn = "特";
				}
			
			if (id == 0) {
				strReturn += "一级代理";
			} else if (id == 1) {
				strReturn += "二级代理";
			} else if (id == 2) {
				strReturn += "三级代理";
			} else if (id == 4) {
				strReturn += "平台";
			} else if (id == 5) {
				strReturn += "会员";
			}

			return strReturn;
		}
//		public String getAgentTypeName(long id) {
//			String strReturn = "";
//			if (id == 0) {
//				strReturn = "一级代理";
//			} else if (id == 1) {
//				strReturn = "二级代理";
//			} else if (id == 2) {
//				strReturn = "三级代理";
//			} else if (id == 4) {
//				strReturn = "平台";
//			} else if (id == 5) {
//				strReturn = "会员";
//			}
//
//			return strReturn;
//		}
		// 得到业务系统类型定义
		public String getyewuleixing(long leixingid) {
			String strTypeName = "";
			if (leixingid == 1) {
				strTypeName = "国际机票业务";
			} else if (leixingid == 2) {
				strTypeName = "国内酒店业务";
			} else if (leixingid == 3) {
				strTypeName = "国际酒店业务";
			} else if (leixingid == 4) {
				strTypeName = "租车业务";
			} else if (leixingid == 5) {
				strTypeName = "充值业务";
			}
			return strTypeName;
		}
		

	/*	public void getgejifan(int type,Hotelorder hotelorder) throws Exception{
			Double lirun=0.00;//初始化一个利润...每返利一个就增加一个...最后平台得利润等于总利润减去这个利润
			
			
			Customeruser cust=Server.getInstance().getMemberService().findCustomeruser(hotelorder.getMemberid());//取创建人ID..相当如当前人
			
			Customeragent customeragent =Server.getInstance().getMemberService().findCustomeragent(cust.getAgentid());//当前加盟商ID
			String login_jibie=customeragent.getAgentjibie()+"";//当前加盟商级别
			
			Double  price=hotelorder.getProfits();//订单总利润
			System.out.println("总利润=="+price);
			//取出会员返利
			Float userrebvaule=0f;//初始化会员的返利比例
			Float userfan =0f;//初始化会员得返利值
			
			List<Rebaterule>listuserrebate=Server.getInstance().getMemberService().findAllRebaterule(" where 1=1 and "+Rebaterule.COL_ruletypeid+" =2 and "+Rebaterule.COL_agenttypeid+" =5", "", -1, 0);
			if(listuserrebate.size()>0){
			 userrebvaule = listuserrebate.get(0).getRebatvalue();	//会员的返利比例
			 userfan=userrebvaule*Float.parseFloat(hotelorder.getProfits()+"");//会员的返利比例*总利润=会员的返利值
			}
			if(cust.getProfits()==null){
				cust.setProfits(0.0f);
			}
			cust.setProfits(cust.getProfits()+userfan);//增加会员的返利
			Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(cust);
			System.out.println("会员利润=="+userfan);
			lirun+=userfan;
			
			//会员返利结束,开始添加记录
			Rebaterecord record = new Rebaterecord();
			record.setOrdernumber(String.valueOf(hotelorder.getId()));
			record.setRebatemoney(userfan);
			record.setYewutype(2);
			record.setRebateagentjibie(Integer.parseInt(login_jibie));
			record.setRebateagentid(customeragent.getId());
			record.setRebatetime(getCurrentTime());
			record.setChildagentid(0);
			String memo="通过"+getyewuleixing(type)+",会员:"+cust.getLoginname();
			
				memo+="得到返佣"+userfan+"元";
			record.setRebatememo(memo);
			Server.getInstance().getMemberService().createRebaterecord(record);
			
			//添加记录结束
			//添加订单记录开始
			List<Guest> listGuest= Server.getInstance().getHotelService().findAllGuest(" WHERE 1=1 AND "+Guest.COL_orderid+" ="+hotelorder.getId(), " ORDER BY ID DESC ", -1, 0);
			if(listGuest.size()>0){
				for(int a=0;a<listGuest.size();a++){
					Guest guest =listGuest.get(a);
					guest.setUserfan(Double.parseDouble(userfan/listGuest.size()+""));
					Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
				}
			}
			
			
			//
			if(login_jibie.endsWith("4")){//如果当前登陆者所属平台会员
				
				System.out.println("判断加盟商级别,当前为平台");
				if(customeragent.getRebatemoney()==null){
					customeragent.setRebatemoney(0.00);
				}
				customeragent.setRebatemoney(customeragent.getRebatemoney()+Double.parseDouble(price-lirun+""));
				Server.getInstance().getMemberService().updateCustomeragent(customeragent);
				
				//返利结束,开始添加记录
				Rebaterecord record_cu = new Rebaterecord();
				record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
				record_cu.setRebatemoney(Float.parseFloat(price-lirun+""));
				record_cu.setYewutype(2);
				record_cu.setRebateagentjibie(customeragent.getAgentjibie());
				record_cu.setRebateagentid(customeragent.getId());
				record_cu.setRebatetime(getCurrentTime());
				record_cu.setChildagentid(0);
				String memo_cu="通过"+getyewuleixing(type)+","+getAgentTypeName(customeragent.getAgentjibie(),customeragent.getSpecial());
			
					memo_cu+="得到返佣"+Double.parseDouble(price-lirun+"")+"元";
					
					record_cu.setRebatememo(memo_cu);
				Server.getInstance().getMemberService().createRebaterecord(record_cu);
				
				//添加记录结束
				//添加订单记录开始
				//List<Guest> listGuest= Server.getInstance().getHotelService().findAllGuest(" WHERE 1=1 AND "+Guest.COL_orderid+" ="+hotelorder.getId(), " ORDER BY ID DESC ", -1, 0);
				if(listGuest.size()>0){
					for(int a=0;a<listGuest.size();a++){
						Guest guest =listGuest.get(a);
						guest.setPlatfan(Double.parseDouble(price-lirun+"")/listGuest.size());
						Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
					}
				}
				//
				
			}else{
				System.out.println("判断加盟商级别,当前不是平台");
				String angenId=customeragent.getParentstr();//得到当前会员所属加盟商的ID串
				if(angenId.indexOf(",")!=-1){//说明上级不是平台
				String[] listangent=angenId.split(",");
				
					for(int a=0;a<listangent.length;a++){
						
						if(listangent[a]!=null && !listangent[a].toString().equals(" ")){
							
							Customeragent cus=Server.getInstance().getMemberService().findCustomeragent(Long.parseLong(listangent[a].trim()));
							
							List<Rebaterule>listangentrebate=Server.getInstance().getMemberService().findAllRebaterule(" where 1=1 and "+Rebaterule.COL_ruletypeid+" ="+type+" and "+Rebaterule.COL_agenttypeid+" ="+cus.getAgentjibie(), "", -1, 0);
							System.out.println("判断加盟商级别,当前不是平台,当前是"+getAgentTypeName(cus.getAgentjibie(),cus.getSpecial()));
							
							if(listangentrebate.size()>0){
									Float angentRebatvalue=listangentrebate.get(0).getRebatvalue();//循环时候,当前加盟商返利比例
									Float angentfan=angentRebatvalue*Float.parseFloat(hotelorder.getProfits()+"");//循环时候,当前加盟商返利比例计算出来得返利值
									
									if(cus.getRebatemoney()==null){
										
										cus.setRebatemoney(0.00);
									}
									
									cus.setRebatemoney(cus.getRebatemoney()+angentfan);
									Server.getInstance().getMemberService().updateCustomeragent(cus);
									//返利结束,开始添加记录
									Rebaterecord record_cu = new Rebaterecord();
									record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
									record_cu.setRebatemoney(angentfan);
									record_cu.setYewutype(2);
									record_cu.setRebateagentjibie(cus.getAgentjibie());
									record_cu.setRebateagentid(cus.getId());
									record_cu.setRebatetime(getCurrentTime());
									record_cu.setChildagentid(0);
									String memo_cu="通过"+getyewuleixing(type)+","+getAgentTypeName(cus.getAgentjibie(),cus.getSpecial());
								
										memo_cu+="得到返佣"+angentfan+"元";
										
										record_cu.setRebatememo(memo_cu);
									Server.getInstance().getMemberService().createRebaterecord(record_cu);
									
									//添加记录结束
									
									System.out.println("当前是"+getAgentTypeName(cus.getAgentjibie(),cus.getSpecial())+",利润=="+angentfan);
									
									lirun+=angentfan;
									//添加订单记录
									
									
									 if (id == 0) {
											strReturn = "一级代理";
										} else if (id == 1) {
											strReturn = "二级代理";
										} else if (id == 2) {
											strReturn = "三级代理";
										} else if (id == 4) {
											strReturn = "平台";
										} else if (id == 5) {
											strReturn = "会员";
										}

									 
									if(listGuest.size()>0){
										for(int b=0;b<listGuest.size();b++){
											Guest guest =listGuest.get(b);
											if(cus.getAgentjibie()==0){//一级代理
												
												
												guest.setOnefan(Double.parseDouble(angentfan/listGuest.size()+""));
											}
											if(cus.getAgentjibie()==1){//二级代理
												
												guest.setTwofan(Double.parseDouble(angentfan/listGuest.size()+""));
											}
											if(cus.getAgentjibie()==2){//三级代理
												
												guest.setThreefan(Double.parseDouble(angentfan/listGuest.size()+""));
											}
											
											Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
										}
									}
									
								}
							
						}
						
					}
				
					
					
				
				}
				
				//剩下全部返给当前加盟商
				

				if(customeragent.getRebatemoney()==null){
					customeragent.setRebatemoney(0.00);
				}
				customeragent.setRebatemoney(customeragent.getRebatemoney()+Double.parseDouble(price-lirun+""));
				Server.getInstance().getMemberService().updateCustomeragent(customeragent);
				//返利结束,开始添加记录
				Rebaterecord record_cu = new Rebaterecord();
				record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
				record_cu.setRebatemoney(Float.parseFloat((price-lirun+"")));
				record_cu.setYewutype(2);
				record_cu.setRebateagentjibie(customeragent.getAgentjibie());
				record_cu.setRebateagentid(customeragent.getId());
				record_cu.setRebatetime(getCurrentTime());
				record_cu.setChildagentid(0);
				String memo_cu="通过"+getyewuleixing(type)+","+getAgentTypeName(customeragent.getAgentjibie(),customeragent.getSpecial());
				
					memo_cu+="得到返佣"+Float.parseFloat((price-lirun+""))+"元";
					
					record_cu.setRebatememo(memo_cu);
				Server.getInstance().getMemberService().createRebaterecord(record_cu);
				
				//添加记录结束
				
				if(listGuest.size()>0){
					for(int b=0;b<listGuest.size();b++){
						Guest guest =listGuest.get(b);
						if(customeragent.getAgentjibie()==0){//一级代理
							
							
							guest.setOnefan(Double.parseDouble(price-lirun/listGuest.size()+""));
						}
						if(customeragent.getAgentjibie()==1){//二级代理
							
							guest.setTwofan(Double.parseDouble(price-lirun/listGuest.size()+""));
						}
						if(customeragent.getAgentjibie()==2){//三级代理
							
							guest.setThreefan(Double.parseDouble(price-lirun/listGuest.size()+""));
						}
						
						Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
					}
				}
				
			}
			
			
		
			
			
			
			
			
			
			
			
			
		}*/

		public void getgejifan(int type,Hotelorder hotelorder) throws Exception{
//			Double lirun=0.00;//初始化一个利润...每返利一个就增加一个...最后平台得利润等于总利润减去这个利润
//			
//			
//			Customeruser cust=Server.getInstance().getMemberService().findCustomeruser(hotelorder.getMemberid());//取创建人ID..相当如当前人
//			
//			Customeragent customeragent =Server.getInstance().getMemberService().findCustomeragent(cust.getAgentid());//当前加盟商ID
//			String login_jibie=customeragent.getAgentjibie()+"";//当前加盟商级别
//			
//			Double  price=hotelorder.getProfits();//订单总利润
//			System.out.println("总利润=="+price);
//			//取出会员返利
//			Float userrebvaule=0f;//初始化会员的返利比例
//			Float userfan =0f;//初始化会员得返利值
//			
//			List<Rebaterule>listuserrebate=Server.getInstance().getMemberService().findAllRebaterule(" where 1=1 and "+Rebaterule.COL_ruletypeid+" =2 and "+Rebaterule.COL_agenttypeid+" =5", "", -1, 0);
//			if(listuserrebate.size()>0){
//			 userrebvaule = listuserrebate.get(0).getRebatvalue();	//会员的返利比例
//			 userfan=userrebvaule*Float.parseFloat(hotelorder.getProfits()+"");//会员的返利比例*总利润=会员的返利值
//			}
//			if(cust.getProfits()==null){
//				cust.setProfits(0.0f);
//			}
//			cust.setProfits(cust.getProfits()+userfan);//增加会员的返利
//			Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(cust);
//			System.out.println("会员利润=="+userfan);
//			lirun+=userfan;
//			
//			//会员返利结束,开始添加记录
//			Rebaterecord record = new Rebaterecord();
//			record.setOrdernumber(String.valueOf(hotelorder.getId()));
//			record.setRebatemoney(userfan);
//			record.setYewutype(2);
//			record.setRebateagentjibie(Integer.parseInt(login_jibie));
//			record.setRebateagentid(customeragent.getId());
//			record.setRebatetime(getCurrentTime());
//			record.setChildagentid(0);
//			String memo="通过"+getyewuleixing(type)+",会员:"+cust.getLoginname();
//			
//				memo+="得到返佣"+userfan+"元";
//			record.setRebatememo(memo);
//			Server.getInstance().getMemberService().createRebaterecord(record);
//			
//			//添加记录结束
//			//添加订单记录开始
//			List<Guest> listGuest= Server.getInstance().getHotelService().findAllGuest(" WHERE 1=1 AND "+Guest.COL_orderid+" ="+hotelorder.getId(), " ORDER BY ID DESC ", -1, 0);
//			if(listGuest.size()>0){
//				for(int a=0;a<listGuest.size();a++){
//					Guest guest =listGuest.get(a);
//					guest.setUserfan(Double.parseDouble(userfan/listGuest.size()+""));
//					Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
//				}
//			}
//			
//			
//			//
//			if(login_jibie.endsWith("4")){//如果当前登陆者所属平台会员
//				
//				System.out.println("判断加盟商级别,当前为平台");
//				if(customeragent.getRebatemoney()==null){
//					customeragent.setRebatemoney(0.00);
//				}
//				customeragent.setRebatemoney(customeragent.getRebatemoney()+Double.parseDouble(price-lirun+""));
//				Server.getInstance().getMemberService().updateCustomeragent(customeragent);
//				
//				//返利结束,开始添加记录
//				Rebaterecord record_cu = new Rebaterecord();
//				record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
//				record_cu.setRebatemoney(Float.parseFloat(price-lirun+""));
//				record_cu.setYewutype(2);
//				record_cu.setRebateagentjibie(customeragent.getAgentjibie());
//				record_cu.setRebateagentid(customeragent.getId());
//				record_cu.setRebatetime(getCurrentTime());
//				record_cu.setChildagentid(0);
//				String memo_cu="通过"+getyewuleixing(type)+","+getAgentTypeName(customeragent.getAgentjibie(),customeragent.getSpecial());
//			
//					memo_cu+="得到返佣"+Double.parseDouble(price-lirun+"")+"元";
//					
//					record_cu.setRebatememo(memo_cu);
//				Server.getInstance().getMemberService().createRebaterecord(record_cu);
//				
//				//添加记录结束
//				//添加订单记录开始
//				//List<Guest> listGuest= Server.getInstance().getHotelService().findAllGuest(" WHERE 1=1 AND "+Guest.COL_orderid+" ="+hotelorder.getId(), " ORDER BY ID DESC ", -1, 0);
//				if(listGuest.size()>0){
//					for(int a=0;a<listGuest.size();a++){
//						Guest guest =listGuest.get(a);
//						guest.setPlatfan(Double.parseDouble(price-lirun+"")/listGuest.size());
//						Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
//					}
//				}
//				//
//				
//			}else{
//				System.out.println("判断加盟商级别,当前不是平台");
//				String angenId=customeragent.getParentstr();//得到当前会员所属加盟商的ID串
//				if(angenId.indexOf(",")!=-1){//说明上级不是平台
//				String[] listangent=angenId.split(",");
//				
//					for(int a=0;a<listangent.length;a++){
//						
//						if(listangent[a]!=null && !listangent[a].toString().equals(" ")){
//							
//							Customeragent cus=Server.getInstance().getMemberService().findCustomeragent(Long.parseLong(listangent[a].trim()));
//							
//							List<Rebaterule>listangentrebate=Server.getInstance().getMemberService().findAllRebaterule(" where 1=1 and "+Rebaterule.COL_ruletypeid+" ="+type+" and "+Rebaterule.COL_agenttypeid+" ="+cus.getAgentjibie(), "", -1, 0);
//							System.out.println("判断加盟商级别,当前不是平台,当前是"+getAgentTypeName(cus.getAgentjibie(),cus.getSpecial()));
//							
//							if(listangentrebate.size()>0){
//									Float angentRebatvalue=listangentrebate.get(0).getRebatvalue();//循环时候,当前加盟商返利比例
//									Float angentfan=angentRebatvalue*Float.parseFloat(hotelorder.getProfits()+"");//循环时候,当前加盟商返利比例计算出来得返利值
//									
//									if(cus.getRebatemoney()==null){
//										
//										cus.setRebatemoney(0.00);
//									}
//									
//									cus.setRebatemoney(cus.getRebatemoney()+angentfan);
//									Server.getInstance().getMemberService().updateCustomeragent(cus);
//									//返利结束,开始添加记录
//									Rebaterecord record_cu = new Rebaterecord();
//									record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
//									record_cu.setRebatemoney(angentfan);
//									record_cu.setYewutype(2);
//									record_cu.setRebateagentjibie(cus.getAgentjibie());
//									record_cu.setRebateagentid(cus.getId());
//									record_cu.setRebatetime(getCurrentTime());
//									record_cu.setChildagentid(0);
//									String memo_cu="通过"+getyewuleixing(type)+","+getAgentTypeName(cus.getAgentjibie(),cus.getSpecial());
//								
//										memo_cu+="得到返佣"+angentfan+"元";
//										
//										record_cu.setRebatememo(memo_cu);
//									Server.getInstance().getMemberService().createRebaterecord(record_cu);
//									
//									//添加记录结束
//									
//									System.out.println("当前是"+getAgentTypeName(cus.getAgentjibie(),cus.getSpecial())+",利润=="+angentfan);
//									
//									lirun+=angentfan;
//									//添加订单记录
//									
//									/*
//									 if (id == 0) {
//											strReturn = "一级代理";
//										} else if (id == 1) {
//											strReturn = "二级代理";
//										} else if (id == 2) {
//											strReturn = "三级代理";
//										} else if (id == 4) {
//											strReturn = "平台";
//										} else if (id == 5) {
//											strReturn = "会员";
//										}
//
//									 */
//									if(listGuest.size()>0){
//										for(int b=0;b<listGuest.size();b++){
//											Guest guest =listGuest.get(b);
//											if(cus.getAgentjibie()==0){//一级代理
//												
//												
//												guest.setOnefan(Double.parseDouble(angentfan/listGuest.size()+""));
//											}
//											if(cus.getAgentjibie()==1){//二级代理
//												
//												guest.setTwofan(Double.parseDouble(angentfan/listGuest.size()+""));
//											}
//											if(cus.getAgentjibie()==2){//三级代理
//												
//												guest.setThreefan(Double.parseDouble(angentfan/listGuest.size()+""));
//											}
//											
//											Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
//										}
//									}
//									
//								}
//							
//						}
//						
//					}
//				
//					
//					
//				
//				}
//				
//				//剩下全部返给当前加盟商
//				
//
//				if(customeragent.getRebatemoney()==null){
//					customeragent.setRebatemoney(0.00);
//				}
//				customeragent.setRebatemoney(customeragent.getRebatemoney()+Double.parseDouble(price-lirun+""));
//				Server.getInstance().getMemberService().updateCustomeragent(customeragent);
//				//返利结束,开始添加记录
//				Rebaterecord record_cu = new Rebaterecord();
//				record_cu.setOrdernumber(String.valueOf(hotelorder.getId()));
//				record_cu.setRebatemoney(Float.parseFloat((price-lirun+"")));
//				record_cu.setYewutype(2);
//				record_cu.setRebateagentjibie(customeragent.getAgentjibie());
//				record_cu.setRebateagentid(customeragent.getId());
//				record_cu.setRebatetime(getCurrentTime());
//				record_cu.setChildagentid(0);
//				String memo_cu="通过"+getyewuleixing(type)+","+getAgentTypeName(customeragent.getAgentjibie(),customeragent.getSpecial());
//				
//					memo_cu+="得到返佣"+Float.parseFloat((price-lirun+""))+"元";
//					
//					record_cu.setRebatememo(memo_cu);
//				Server.getInstance().getMemberService().createRebaterecord(record_cu);
//				
//				//添加记录结束
//				
//				if(listGuest.size()>0){
//					for(int b=0;b<listGuest.size();b++){
//						Guest guest =listGuest.get(b);
//						if(customeragent.getAgentjibie()==0){//一级代理
//							
//							
//							guest.setOnefan(Double.parseDouble(price-lirun/listGuest.size()+""));
//						}
//						if(customeragent.getAgentjibie()==1){//二级代理
//							
//							guest.setTwofan(Double.parseDouble(price-lirun/listGuest.size()+""));
//						}
//						if(customeragent.getAgentjibie()==2){//三级代理
//							
//							guest.setThreefan(Double.parseDouble(price-lirun/listGuest.size()+""));
//						}
//						
//						Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
//					}
//				}
//				
//			}
//			
//			
//		
//			
//			
//			
//			
//			
//			
//			
//			
//			
		}
		
		//根据线路ID取图片
		public String GetSpotLineImgPathByID(String id){
			List<Spotlineimg>list=Server.getInstance().getTripService().findAllSpotlineimg(" WHERE 1=1 AND "+Spotlineimg.COL_spotlineid+" ='"+id+"'", " ORDER BY ID ", 1, 0);
			if(list!=null&&list.size()>0){
				return list.get(0).getImgurl();	
			}
			return "NoImage.gif";
		}
		
		/**
		 * 根据门票ID获取景区名称
		 */
		public String getSpotmesNameBySpotticketIDStr(String SpotticketID)
		{
			Spotticket spotticket=Server.getInstance().getTripService().findSpotticket(Long.parseLong(SpotticketID.trim()));
			Spotmes spotmes=Server.getInstance().getTripService().findSpotmes(Long.parseLong(spotticket.getSid()));
			return spotmes != null && spotmes.getName()!=null&& !"".equals(spotmes.getName()) ? spotmes.getName() : "";
		}

		/**
		 * 根据城市ID获取城市名称
		 */
		public String getCityNameByStr(String cityid)
		{
			City city=Server.getInstance().getHotelService().findCity(Long.parseLong(cityid));
			return city != null && city.getName()!=null&& !"".equals(city.getName()) ? city.getName() : "";
		}
		/**
		 * 根据城市ID获取旅游城市名称
		 */
		public String getSpotCityNameByStr(String cityid)
		{
			Spotcity city=Server.getInstance().getTripService().findSpotcity(Long.parseLong(cityid));
			return city != null && city.getName()!=null&& !"".equals(city.getName()) ? city.getName() : "";
		}
		/**
		 * 根据城市ID获取城市名称--国际
		 */
		public String getInterCityNameByStr(String cityid)
		{
			Incity city=Server.getInstance().getInterHotelService().findIncity(Long.parseLong(cityid));
			return city != null && city.getName()!=null&& !"".equals(city.getName()) ? city.getName() : "";
		}
		/**
		 * 根据行政区ID获取行政区名称
		 */
		public String getRegionNameByStr(String regionid)
		{
			Region region=Server.getInstance().getHotelService().findRegion(Long.parseLong(regionid));
			return region != null && !"".equals(region.getName()) ? region.getName() : "";
		}
		public String SubString(String str,int len){
			if(str==null)
				return str;
			if(str.length()<=len)
				return str;
			
			return str.substring(0,Math.abs(len));
		}
		public long getagentId(){
			
			
			//return Long.parseLong(((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='agentid'","",-1,0).get(0)).getValue());
			return GetAgentID();
		
		}
		public String ziquaddress(){
			return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='ziquaddresss'","",-1,0).get(0)).getValue();
		}
		
		public String getcususercode(long id)
		{
			Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(id);
			Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());
			if(customeragent!=null&&customeragent.getCode().length()>0)
			{
				return customeragent.getCode();
			}else
			{
				return "";
			}
		}
		/**
		 * 截取字符串带...
		 * @param str
		 * @param len
		 * @return
		 */
		public String subStringstr(String str,int len){
			if(str==null)
				return str;
			if(str.length()<=len)
				return str;
			
			return str.substring(0,Math.abs(len)-3)+"...";
		}
		/**
		 * 获取短信模板
		 * @param nodest
		 * @return
		 */
		public String getSMSTemple(String nodecode)
		{
			URL url = Thread.currentThread().getContextClassLoader().getResource("MessageTemple.xml"); 
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
		 * 调用短信接口发送短信
		 * @param mobiles 手机号码组
		 * @param content 短信内容
		 * @param ordercode 订单号 可选
		 * @return
		 */
		public int smsSend(String[] mobiles, String content,String ordercode)
		{
			return Server.getInstance().getAtomService().sendSms(mobiles,content,ordercode,"");
		}
		/**
		 * 获取是否是大客户
		 * @param id
		 * @return
		 */
		public boolean getbiguser(long id)
		{
			Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(id);
			if(customeruser!=null)
			{
				Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());
				if(customeruser!=null)
				{
					if(customeragent.getBigtype()==1)
					{
						return true;
					}
				}
			}
			return false;
		}
		/**
		 * 截取字符串带...
		 * @param str
		 * @param len
		 * @return
		 */
		public String subfightimg(String str){
			if(str==null)
				return str;
			String a=str.substring(0,str.indexOf("#"));
			String b=str.substring(str.indexOf("#")+1);
			return "<span style='width: 100%;text-align: center;'><img src='images/flight/"+b+"' align='left' width='100' height='64' style='margin-right: :5px'/></span>"+a;
		}
		
		/**
		 * 获取保险金额
		 * @param sum
		 * @return
		 */
		public int getsuminsurance(int sum){
			int i=Integer.parseInt(((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='insurance'","",-1,0).get(0)).getValue());
			return i*sum;
		}
		/**
		 * 根据订单号获得保险金额
		 * 
		 * @param orderid
		 * @return
		 */
		public float getIssurByOrderid_B2b(Long orderid) {
			float price = 0f;
			if (orderid != null && orderid > 0l) {
				List<Passenger> listpassenger = Server.getInstance()
						.getAirService().findAllPassenger(
								"where " + Passenger.COL_orderid + "=" + orderid,
								"", -1, 0);
				if (listpassenger.size() > 0) {
					for (Passenger pass : listpassenger) {
						price += pass.getInsurprice();
					}
				}
			}
			return price;
		}
		
		/**
		 * 获取保险金额
		 * 
		 * @param sum
		 * @return
		 */
		public float getInsurancPrice_B2b(Long insruid) {
			float price = 0f;
			if (insruid != null && insruid > 0l) {
				Insuranceinfo insurance = Server.getInstance().getMemberService()
						.findInsuranceinfo(insruid);
				price = Float.valueOf(insurance.getInsurancefee());
			}
			return price;
		}

		/**
		 * 取得Session中的用户
		 * @return
		 */
		public Customeruser getLoginUser(){
			
			Customeruser user = (Customeruser)ActionContext.getContext().getSession().get("loginuser");
			
			
				return user;
			
			//return user;
		}
		public String getca(long id){
			return Server.getInstance().getMemberService().findCustomeragent(id).getCacode();
		}
		public String getcz(long id){
			return Server.getInstance().getMemberService().findCustomeragent(id).getCzcode();
		}
		public String getmu(long id){
			return Server.getInstance().getMemberService().findCustomeragent(id).getMucode();
		}
		/**
		 * 取得Session中的对象
		 * @return
		 */
		public Customeruser getLogin(){
			Customeruser user = (Customeruser)ActionContext.getContext().getSession().get("loginuser");
			Customeruser user2 = (Customeruser)ActionContext.getContext().getSession().get("loginuser_shanglv");
			Customeruser user3 = (Customeruser)ActionContext.getContext().getSession().get("loginuser3");
			if(user!=null){
				return user;
			}
			if(user2!=null){
				return user2;
			}
			if(user3!=null){
				return user3;
			}
			return null;
			//Customeruser user = Server.getInstance().getMemberService().findCustomeruser(1l);
		}
		public Customeruser getLogin3(){
			Customeruser user = (Customeruser)ActionContext.getContext().getSession().get("loginuser3");
			//Customeruser user = Server.getInstance().getMemberService().findCustomeruser(1l);
			
			return user;
		}
		/**
		 * 取得Session中的对象
		 * @return
		 */
		public long getLoginid(){
			Customeruser user = (Customeruser)ActionContext.getContext().getSession().get("loginuser");
			Customeruser user2 = (Customeruser)ActionContext.getContext().getSession().get("loginuser3");
			Customeruser user3 = (Customeruser)ActionContext.getContext().getSession().get("loginuser_shanglv");
			if(user!=null)
			{
				return user.getId();
			}
			if(user2!=null)
			{
				return user2.getId();
			}
			if(user3!=null)
			{
				return user3.getId();
			}
			return -1;
		}
		/**
		 * 取得Session中的对象
		 * @return
		 */
		public Customeruser getLogin_shanglv(){
			Customeruser user = (Customeruser)ActionContext.getContext().getSession().get("loginuser_shanglv");
			//Customeruser user = Server.getInstance().getMemberService().findCustomeruser(1l);
			
			return user;
		}
		public Systemrole getLoginRole(){
			
			Systemrole role = (Systemrole)ActionContext.getContext().getSession().get("loginrole");
			
			return role;
		}
		/**
		 * 取得Session中的用户ID
		 */
		public long getLoginUserId(){
			try {
				Customeruser user = (Customeruser)ActionContext.getContext().getSession().get("loginuser");
				Customeruser user3 = (Customeruser)ActionContext.getContext().getSession().get("loginuser3");
				if(user==null){
					return user3.getId();
				}else{
					return user.getId();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		public Float GetTrainPrice(long id){
			Float allprice=0f;
			Train train=Server.getInstance().getTrainService().findTrain(id);
			allprice=train.getTotalprice()+train.getPsprice();
			
			int bxprice=0;
			List<Trainpassenger>list=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+id, " ORDER BY ID ", -1, 0);
			if(list!=null&&list.size()>0){
				for(int a=0;a<list.size();a++){
					if(list.get(a).getBxprice()>0){
						bxprice+=list.get(a).getBxprice();
					}
					
				}
			} 
			
			
			
			return allprice+bxprice;
		}
		
		public String GetTrainPassName(long id){
			String ret="";
			List<Trainpassenger>list=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+id, " ORDER BY ID ", -1, 0);
			if(list!=null&&list.size()>0){
				for(int a=0;a<list.size();a++){
					
					ret+=list.get(a).getName()+"</br>";
				}
			} 
			
			return ret;
		}
		public String GetXiBieTypeByCode(int code){
			String ret="无座";
			if(code==0){
				ret="无座";
			}
			if(code==1){
				ret="硬座";
			}
			if(code==2){
				ret="软卧";
			}
			if(code==3){
				ret="硬卧";
			}
			if(code==4){
				ret="软卧";
			}
			if(code==5){
				ret="高卧";
			}
			if(code==6){
				ret="二等";
			}
			if(code==7){
				ret="一等";
			}
			if(code==8){
				ret="商务";
			}
			if(code==9){
				ret="特等";
			}
			return ret;
		}
		public String GetTrainOrderStausByCode(int code){
			String ret="等待支付";
			if(code==-1){
				ret="已经取消";
			}
			if(code==0){
				ret="等待确认";
			}
			if(code==1){
				ret="等待支付";
			}
			if(code==2){
				ret="已支付,待出票";
			}
			if(code==3){
				ret="已出票,交易完成";
			}
			
			if(code==4){
				ret="已出票,已配送";
			}
			if(code==5){
				ret="拒单-等待退款";
			}
			if(code==6){
				ret="拒单-已退款";
			}
			if(code==14){
				ret="申请退票";
			}
			
			if(code==15){
				ret="已退票,已退款";
			}
			if(code==16){
				ret="退票失败";
			}
			if(code==17){
				ret="申请改签";
			}
			if(code==18){
				ret="改签成功";
			}
			if(code==9){
				ret="改签失败";
			}
			return ret;
		}
		//
		/*public boolean hasACL(String code){
			
			try {
				Systemrole role = this.getLoginRole();
				List<Systemright> listright = Server.getInstance().getSystemrightManager().findAllSystemright(" where " + Systemright.COL_code +" = '" +code+"'","",1,0);
				if(listright.isEmpty()){
					return false;
				}
					
				List<Sysroleright> list= Server.getInstance().getSysrolerightManager().findAllSysroleright("where "  + Sysroleright.COL_roleid + "=" + role.getId() + " and "+ Sysroleright.COL_rightid + "="+listright.get(0).getId(),"",-1,0 ) ; 
																					   
				if(list.isEmpty()){
					return false;
				}
					
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}*/
		public String gethangbanhaobyorderid(long id){
			List<Segmentinfo>list =Server.getInstance().getAirService().findAllSegmentinfo("where 1=1 and "+Segmentinfo.COL_orderid+" ="+id, "", -1, 0);
			
			return list.get(0).getFlightnumber();
		}
		public String getcodebyorderid(long id){//根据订单ID取航空公司二字码
			List<Segmentinfo>list =Server.getInstance().getAirService().findAllSegmentinfo("where 1=1 and "+Segmentinfo.COL_orderid+" ="+id, "", -1, 0);
			
			return list.get(0).getAircomapnycode();
		}
		public String getserviceItem(long id){
			return Server.getInstance().getHotelService().findHotel(id).getServiceitem();
		}
		public String getfootItems(long id){
			return Server.getInstance().getHotelService().findHotel(id).getFootitem();
		}
		public String getplayItems(long id){
			return Server.getInstance().getHotelService().findHotel(id).getPlayitem();
		}
		public String getPagination(){
			return getPagination("\""+this.getClass().getSimpleName().toLowerCase().replaceFirst("action","")+".action?pageinfo.pagenum=\"+pageno");
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
		public String getStarico2(Integer index)
		{
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<index/2;i++)
			{
				buffer.append("<img src=\"newimages/shixing.gif\" />");
			}
			if(index%2==0){
				buffer.append("<img src=\"images/kongxing.gif\" />");
			}else{
				buffer.append("<img src=\"newimages/shixing.gif\" />");
			} 
			return buffer.toString();
		}
		public String getPagination(String action){
			StringBuffer sb = new StringBuffer();

			sb.append("(共&nbsp;"+pageinfo.getTotalrow()+"&nbsp;条数据)&nbsp;");
			
			if(pageinfo.getTotalrow()==0){
				return sb.toString();
			}
			sb.append(" "+pageinfo.getPagenum()+"/"+pageinfo.getTotalpage()+"页&nbsp;");
			
			//sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(1);'>首页</a>&nbsp;<span class=\"font_grey_001\">");
			
			if(pageinfo.hasFront()){
				sb.append("<a href='#' class=\"font_grey_001\" onclick='javascript:go(").append(pageinfo.getPagenum()-1).append(");'>上一页</a>&nbsp;");
			}
			
			
			if(pageinfo.getTotalpage()==1){
				
				sb.append(" <strong>1</strong> ");
			}else {
				
				int pre =pageinfo.getPagenum()-5; //前页数
				int bac =pageinfo.getTotalpage()-pageinfo.getPagenum(); //后页数
				
				if(pre>=1 && bac>=5){
					for(int i= pageinfo.getPagenum()-5;i< pageinfo.getPagenum()+5;i++){
						if(i==pageinfo.getPagenum()){
							sb.append(" <strong>"+i+"</strong> ");
						}else{
							sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("+i+");'>"+i+"</a>");
						}
					}
				}else if(pre<=0){ //前页数不够5页
					
					for(int i=1; i<=8 &&  i<= pageinfo.getTotalpage();i++){
						if(i==pageinfo.getPagenum()){
							sb.append(" <strong>"+i+"</strong> ");
						}else{
							sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("+i+");'>"+i+"</a>");
						}
					}
					
				}else if(bac<5){ //后页数不够5页
					int i=1;
					if(pageinfo.getTotalpage()>10){
						i = pageinfo.getPagenum()-(9-bac);
					}
					
					for(;i>0 && i<= pageinfo.getTotalpage();i++){
						if(i==pageinfo.getPagenum()){
							sb.append(" <strong>"+i+"</strong> ");
						}else{
							sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("+i+");'>"+i+"</a>");
						}
					}
					
				}
						
				
			}	
			
			
			
			if(pageinfo.hasBack()){
				sb.append(" <a href='#' class=\"font_grey_001\" onclick='javascript:go(").append((pageinfo.getPagenum()+1)).append(");'>下一页</a>");
			}

			if(pageinfo.getTotalpage()>0){
				//sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go("+pageinfo.getTotalpage()+");'>尾页</a></span>");
			}
			
			
			sb.append("<script>"
			+"function go(pageno){"
			+	"document.form1.action="+action+";"
			+	"document.form1.submit();"
			+"}"
			+"</script>");
			
			return sb.toString();
		}
		
		public static String formatDate(Date date){
			try {
				return (new SimpleDateFormat("yyyy-MM-dd").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public String encoder(String url) {
			try {
				return URLEncoder.encode(url, "UTF-8") ;
			} catch (UnsupportedEncodingException e) {
				return url ;
			}
		}
		
		public String decoder(String url) {
			try {
				return URLDecoder.decode(url, "UTF-8") ;
			} catch (UnsupportedEncodingException e) {
				return url ;
			}
		}
		public String formatTimestamp(Timestamp date){
			try {
				return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public String formatTimestampHHmm(Timestamp date){
			try {
				return (new SimpleDateFormat("HH:mm").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public String formatTimestampyyyyMMddHHmm(Timestamp date){
			try {
				return (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public String formatTimestamporderbydate(Timestamp date){
			try {
				return (new SimpleDateFormat("yyyyMMddHHmm").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public String formatTimestampyyyyMMdd(Timestamp date){
			try {
				return (new SimpleDateFormat("yyyy-MM-dd").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public String formatTimestampMMdd(Timestamp date){
			try {
				return (new SimpleDateFormat("MM-dd").format(date));
				
			} catch (Exception e) {
				return "";
			}
			
		}
		public static Timestamp dateToTimestamp(String date){
			try {
				SimpleDateFormat dateFormat=new SimpleDateFormat();
				if(date.length()==10)
				{
				dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				}else if(date.length()==16){
					dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
				}else
				{
				dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				}
				return (new Timestamp(dateFormat.parse(date).getTime()));
				
			} catch (Exception e) {
				return null;
			}
			
		}
		
		public String formatlog( String s ){
			
			//String   s   =   "123.456 "; 
			float   money   =   Float.valueOf(s).floatValue();
			
			DecimalFormat format = null;
			format = (DecimalFormat) NumberFormat.getInstance();
			format.applyPattern( "#0" );
			try{
				String result = format.format( money );
				return result;
			}catch ( Exception e ){
				return Float.toString( money );
			}
		}
		
		public String formatMoney_string( String s ){
			
			//String   s   =   "123.456 "; 
			float   money   =   Float.valueOf(s).floatValue();
			
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
		 * 将money格式化为类似于2,243,234.00的格式
		 * 
		 * @param money
		 * @return
		 */
		public String formatMoney( Float money ){
			DecimalFormat format = null;
			format = (DecimalFormat) NumberFormat.getInstance();
			format.applyPattern( "#,##0.00" );
			try{
				String result = format.format( money );
				return result;
			}catch ( Exception e ){
				return Float.toString( money );
			}
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
		 * 将money格式化为类似于2,243,234的格式
		 * 
		 * @param money
		 * @return
		 */
		public String formatMoneyShort( Float money ){
			DecimalFormat format = null;
			format = (DecimalFormat) NumberFormat.getInstance();
			format.applyPattern( "#,###" );
			try{
				String result = format.format( money );
				return result;
			}catch ( Exception e ){
				return Float.toString( money );
			}
		}
		public String ChangeDateMode(String dateStr)
	    {
	        //2009-03-19
		     String newmon="";
		     System.out.println(dateStr);
		     String daystr = dateStr.substring(8, 10);
		   //  String yearstr = dateStr.substring(2, 3);
		     String monstr = dateStr.substring(5, 7);
		     if(monstr.equals("01"))
		     {
		    	 newmon = "JAN";
		     }
		     else if(monstr.equals("02"))
		     {
		    	 newmon = "FEB";
		     }
		     else if(monstr.equals("03"))
		     {
		    	 newmon = "MAR";
		     }
		     else if(monstr.equals("04"))
		     {
		    	 newmon = "APR";
		     }
		     else if(monstr.equals("05"))
		     {
		    	 newmon = "MAY";
		     }
		     else if(monstr.equals("06"))
		     {
		    	 newmon = "JUN";
		     }
		     else if(monstr.equals("07"))
		     {
		    	 newmon = "JUL";
		     }
		     else if(monstr.equals("08"))
		     {
		    	 newmon = "AUG";
		     }
		     else if(monstr.equals("09"))
		     {
		    	 newmon = "SEP";
		     }
		     else if(monstr.equals("10"))
		     {
		    	 newmon = "OCT";
		     }
		     else if(monstr.equals("11"))
		     {
		    	 newmon = "NOV";
		     }
		     else if(monstr.equals("12"))
		     {
		    	 newmon = "DEC";
		     }
	        return daystr + newmon ;
	    }

		/**
		 * 将float格式化支持4伟小数
		 * 
		 * @param money
		 * @return
		 */
		public String formatFloat(Float num ){
			DecimalFormat format = null;
			format = (DecimalFormat) NumberFormat.getInstance();
			format.applyPattern( "###0.0000" );
			try{
				String result = format.format( num );
				return result;
			}catch ( Exception e ){
				return Float.toString( num );
			}
		}
		
		/**
		 * 写操作日志
		 * @param user
		 * @param request
		 * @param method
		 * @param action
		 * @param desc
		 */
	/*	public void writeLog(Systemuser user, HttpServletRequest request, String method,String action,String desc) {
			try{
				
				Systemaction systemlog = new Systemaction();
				systemlog.setCode(method);
				systemlog.setCreatetime(new Timestamp(System.currentTimeMillis()));
				
				systemlog.setActionname(action);
				systemlog.setDescription(desc);
				
				try{systemlog.setIp(request.getRemoteAddr());}catch(Exception e){}
				try{systemlog.setUsername(user.getUsername());}catch(Exception e){}
//				Server.getInstance().getSystemactionManager().createSystemaction(systemlog);
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}*/
		/**
		 * 获取编辑的信息
		 * @param title
		 * @return
		 */
		public String getInfocontent(String title)
		{
			List<Infocontent> list=Server.getInstance().getMemberService().findAllInfocontent(" where 1=1 and "+Infocontent.COL_title+" = '"+title+"' ", "", -1, 0);
			if(list!=null&&list.size()>0)
			{
				return list.get(0).getContent();
			}
			return "";
		}
		/**
		 * 显示文件
		 * @param filePath
		 * @return
		 */
		public String getImgPath(String filePath) {
			
			return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue() + filePath; 
		}
		/**
		 * 显示文件
		 * @param filePath
		 * @return
		 */
		public String getImgPathByCode(String code,String filePath) {
			
			return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='"+code+"'","",-1,0).get(0)).getValue() + filePath; 
		}
		/**
		 * 显示文件
		 * @param filePath
		 * @return
		 */
		public String getImgPath2(String filePath) {
			
			return filePath; 
		}
		/**
		 * 绝对路径
		 * @param filePath
		 * @return
		 */
		
		public String getRealPath(String filePath){
			return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='uploadpath'","",-1,0).get(0)).getValue()+filePath;
		}
		/**
		 * 获取当前时间传入0
		 * 昨天-1
		 * 明天1
		 * @param date
		 * @return
		 */
		public String getDatestr(int date)
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.add(Calendar.DAY_OF_MONTH, date);
			System.out.println(cd.toString());
			return sdf.format(cd.getTime()).toString();
		}
		public String getdate(String da, int a)
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
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
			return new SimpleDateFormat("MM-dd").format(new Date(c.getTimeInMillis()));
			
		}
		/**
		 * 	通过时间获取星期几
		 * @param time
		 * @return
		 */
		public String getWeekStr(String time) {
			String strReturn="";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
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
		 * @param time		指定时间
		 * @param intDay	指定时间的后几天天数
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
				if(Calendar.getInstance().before(cd))
				{
					return true;
				}
				else
				{
					return false;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return false;
		}
		/**
		 * 获取指定时间的后几天
		 * @param time		指定时间
		 * @param intDay	指定时间的后几天天数
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
			return list != null && list.size() > 0 ? list.get(0).getAirportname(): "";

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
		/**
		 * 根据机场代码获取城市名称--国际
		 * 
		 * @param airport
		 * @return
		 */
		public String getInterAirCityNamebySZM(String airport) {
			String where = "where " + Fcity.COL_citycode + "='" + airport
					+ "'";
			List<Fcity> list = Server.getInstance().getInterticketService()
					.findAllFcity(where, "ORDER BY ID", -1, 0);
			
			/*if(list.size()==0){
				
				getAirCityNamebySZM(airport);
			}*/
			
			
			return list.get(0).getCityname();

		}
		/**
		 * 根据航空公司代码取得航空公司
		 * 
		 * @param airport
		 * @return
		 */
		public String getAircomapnycodeByEZM(String companycode) {
			String where = "where " + Aircompany.COL_aircomcode + "='" + companycode
					+ "'";
			List<Aircompany> list = Server.getInstance().getAirService()
					.findAllAircompany(where, "ORDER BY ID", -1, 0);
			return list != null && list.size() > 0 ? list.get(0).getAircomcnname(): "";

		}
		public String gethotelname(long id){
			
			return Server.getInstance().getHotelService().findHotel(id).getName();
		}
		public String getRoomTypeNameByRoomType(String type) {
			if(type.equals("1")){
				
				return "SingleRoom";
			}
			if(type.equals("2")){
							
			   return "DoubleRoom";
						}
			if(type.equals("3")){
				
				return "TripleRoom";
			}
			if(type.equals("4")){
				
				return "FamilyRoom";
			}
			return "";
		}
		public String getHotelStasName(String type) {
			if(type.equals("1")){
				
				return "1星";
			}
			if(type.equals("2")){
							
			   return "1星";
						}
			if(type.equals("3")){
				
				return "2星";
			}
			if(type.equals("4")){
				
				return "准3星";
			}
			if(type.equals("5")){
				
				return "3星";
			}
			if(type.equals("6")){
				
				return "准4星";
			}
			if(type.equals("7")){
				
				return "4星";
			}
			if(type.equals("8")){
				
				return "准5星";
			}
			if(type.equals("9")){
				
				return "5星";
			}
			return "";
		}
		public String getStateToString(Integer id) {
			switch (id) {
				

			case 1:
				return "等待支付";
			case 2:
				return "等待出票";
			case 3:
				return "出票完成";
			case 4:
				return "申请退票";
			case 5:
				return "申请废票";
			case 6:
				return "取消订单";
			case 7:
				return "废票不成功";
			case 8:
				return "审核失败";
			case 9:
				return "废票退款成功";
			case 10:
				return "订单关闭";
			case 11:
				return "废票未退款";
			case 12:
				return "退票未退款";
			case 13:
				return "申请改签";
			case 14:
				return "已经改签";
			case 15:
				return "改签失败";
			case 16:
				return "暂不能出票";
			case 17:
				return "退票不成功";
			case 18:
				return "退票退款成功";
			case 19:
				return "问题订单";
			case 23:
				return "申请升舱";
			case 24:
				return "已换开";
			case 25:
				return "升舱换开成功";
			case 26:
				return "升舱失败";
			case 27:
				return "待确认";
			case 28:
				return "在途订单";
			case 29:
				return "待收银";
			case 30:
				return "申请换开";
			case 31:
				return "换开失败";
			default:
				return "";
				}
			}
		
		public String getNameByDiscount(Double discount)
		{
			if(discount>=150)
			{
				return "头等舱";
			}else if(discount>=120)
			{
				return "公务舱";
			}else
			{
				return "经济舱";
			}
		}
		/**
		 * 根据机场代码获取城市名称(国内)
		 * 
		 * @param airport
		 * @return
		 */
		public String getCitynameByAirport(String airport) {
			String where = "where " + Cityairport.COL_airportcode + "='" + airport
					+ "'";
			List<Cityairport> list = Server.getInstance().getAirService()
					.findAllCityairport(where, "ORDER BY ID", -1, 0);
			//return list != null && list.size() > 0 ? list.get(0).getCityname() : "";
			return list != null && list.size() > 0 ? list.get(0).getAirportname() : "";

		}
		/**
		 * 根据机场代码获取城市名称(国际)
		 * 
		 * @param airport
		 * @return
		 */
		public String getInterCitynameByAirport(String airport) {
			String where = "where " + Fairport.COL_airportcode + "='" + airport
					+ "'";
			List<Fairport> list = Server.getInstance().getInterticketService()
					.findAllFairport(where, "ORDER BY ID", -1, 0);
			//return list != null && list.size() > 0 ? list.get(0).getCityname() : "";
			return list != null && list.size() > 0 ? list.get(0).getAirportname() : "";

		}
		
		/**
		 * 根据国际编码 查询国家名称
		 * 2011-12-20
		 * 高亮
		 * */
		public String getCountyNameByCode(String code) {
			String where = "where " + Fcountry.COL_countrycode + "='" + code
					+ "'";
			List<Fcountry> list=Server.getInstance().getInterticketService().findAllFcountry(where, "ORDER BY ID", -1, 0);
			return list != null && list.size() > 0 ? list.get(0).getCountryname() : "";

		}
		/**
		 * 获取当前时间比起飞时间是否早一个小时
		 * @param date
		 * @return
		 */
		public boolean comtimetoflight(String date)
		{
			Calendar ca = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date time=null;
			try {
				time=sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				time=new Date();
				e.printStackTrace();
			}
			long c = time.getTime()-ca.getTime().getTime(); 
			double temp=(c /1000/60); 
			if(temp>60)
			{
				return true;
			}
			return false;
		}
		public String formatTimestampHHmm2(Timestamp date) {
			try {
				return (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));

			} catch (Exception e) {
				return "";
			}
		}
		/**
		 * 取得两个天数差
		 * @param time
		 * @param intDay
		 * @return
		 */
		public int Calculate(String date){
			Calendar ca = Calendar.getInstance(); 
			ca.set(Calendar.HOUR_OF_DAY, 0);    //小时取0 
			ca.set(Calendar.MINUTE, 0);        //分取0 
			ca.set(Calendar.SECOND, 0);        //秒取0 
			ca.set(Calendar.MILLISECOND, 0);    //毫秒取0 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				time=sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				time=new Date();
				e.printStackTrace();
			}
			long c = time.getTime()-ca.getTime().getTime(); 
			return (int)(c / 1000 / 60 / 60 / 24); 
		} 
		public String getUrl() {
			return "pageinfo.pagenum="+pageinfo.getPagenum()
			
			+"&pageinfo.pagerow="+pageinfo.getPagerow();
		}
		
		public void setUrl(String url) {
			
			this.url = this.getGBKString(url);
		}
		/*public String getorderRelation(long id)
		{
			String str="";
			String str2="";
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(id);
			if(orderinfo!=null)
			{
				Double pricesum=0d;
				if(orderinfo.getTotalticketprice()!=null&&orderinfo.getTotalticketprice()>0){
					pricesum+=orderinfo.getTotalticketprice();
					}
					if(orderinfo.getTotalfuelfee()!=null){
					pricesum+=orderinfo.getTotalfuelfee();
					}
					if(orderinfo.getTotalairportfee()!=null){
					pricesum+=orderinfo.getTotalairportfee();
					}
					if(orderinfo.getPostmoney()!=null){
					pricesum+=orderinfo.getPostmoney();
					}
					if(orderinfo.getInsurance()!=null){
					pricesum+=getsuminsurance(orderinfo.getInsurance());
					}
					DecimalFormat format = null;
					format = (DecimalFormat) NumberFormat.getInstance();
					format.applyPattern( "###0.00" );
					try{
						str = format.format( pricesum );
					}catch ( Exception e ){
						str= Double.toString( pricesum );
					}
				if(orderinfo.getRelationorderid()!=null)
				{
					pricesum=0d;
					Orderinfo orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
					if(orderinfo2.getTotalticketprice()!=null&&orderinfo2.getTotalticketprice()>0){
					pricesum+=orderinfo2.getTotalticketprice();
					}
					if(orderinfo2.getTotalfuelfee()!=null){
					pricesum+=orderinfo2.getTotalfuelfee();
					}
					if(orderinfo2.getTotalairportfee()!=null){
					pricesum+=orderinfo2.getTotalairportfee();
					}
					if(orderinfo2.getPostmoney()!=null){
					pricesum+=orderinfo2.getPostmoney();
					}
					if(orderinfo2.getInsurance()!=null){
					pricesum+=getsuminsurance(orderinfo2.getInsurance());
					}
					DecimalFormat format2 = null;
					format2 = (DecimalFormat) NumberFormat.getInstance();
					format2.applyPattern( "###0.00" );
					try{
						str2 = format.format( pricesum );
					}catch ( Exception e ){
						str2= Double.toString( pricesum );
					}
					return "<span style=\"color:red;\" >  您的多程订单同时会支付，订单号："+orderinfo.getOrdernumber()+" 金额是："+str+"&nbsp;订单号："+orderinfo2.getOrdernumber()+" 金额是："+str2+"</span>";
				}
			}
			return "";
		}*/
		/**
		 * 通过订单ID获取订单总金额
		 * @param id
		 * @return
		 */
		public String getorderpricesum(long id)
		{
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(id);
		
			if(orderinfo!=null)
			{
				Double pricesum=0d;
				if(orderinfo.getTotalticketprice()!=null&&orderinfo.getTotalticketprice()>0){
				pricesum+=orderinfo.getTotalticketprice();
				}
				if(orderinfo.getTotalfuelfee()!=null){
				pricesum+=orderinfo.getTotalfuelfee();
				}
				if(orderinfo.getTotalairportfee()!=null){
				pricesum+=orderinfo.getTotalairportfee();
				}
				String orderid=orderinfo.getId()+"";
				if(orderinfo.getRelationorderid()!=null){
					orderid+=","+orderinfo.getRelationorderid();
				}
				String sql="SELECT SUM(C_INSURANCEFEE) AS INSURPRICE FROM T_INSURANCEINFO WHERE ID IN " +
						"(SELECT C_INSURANCE FROM T_PASSENGER WHERE C_ORDERID IN ("+orderid+"))";
				List list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
				Map m=(Map)list.get(0);
				if(m.get("INSURPRICE")!=null){
					pricesum+=Float.valueOf(m.get("INSURPRICE").toString());
				}
				
				if(orderinfo.getRelationorderid()!=null)
				{
					Orderinfo orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
					if(orderinfo2.getTotalticketprice()!=null&&orderinfo2.getTotalticketprice()>0){
					pricesum+=orderinfo2.getTotalticketprice();
					}
					if(orderinfo2.getTotalfuelfee()!=null){
					pricesum+=orderinfo2.getTotalfuelfee();
					}
					if(orderinfo2.getTotalairportfee()!=null){
					pricesum+=orderinfo2.getTotalairportfee();
					}
					
				}
				DecimalFormat format = null;
				format = (DecimalFormat) NumberFormat.getInstance();
				format.applyPattern( "###0.00" );
				try{
					String result = format.format( pricesum );
					return result;
				}catch ( Exception e ){
					return Double.toString( pricesum );
				}
			}
			return "";
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
		/**
		 * 根据订单ID获取行程数据_降落机场
		 * 
		 * @param orderId
		 * @return
		 */
		public String getSeg_endairport(long orderId) {
			String where = "where " + Segmentinfo.COL_orderid + "=" + orderId;
			List<Segmentinfo> list = Server.getInstance().getAirService()
					.findAllSegmentinfo(where, "ORDER BY ID", -1, 0);
			return list.get(0).getEndairport();
		}
		/**
		 * 根据订单ID获取行程数据_起飞机场
		 * 
		 * @param orderId
		 * @return
		 */
		public String getSeg_startairport(long orderId) {
			String where = "where " + Segmentinfo.COL_orderid + "=" + orderId;
			List<Segmentinfo> list = Server.getInstance().getAirService()
					.findAllSegmentinfo(where, "ORDER BY ID", -1, 0);
			return list.get(0).getStartairport();
		}
		
		
		
		
		/**
		 * 证件类型定义
		 * @param id
		 * @return
		 */
		public String getIDTypeToString(Integer id) {
			switch (id) {
			case 1:
				return "身份证";
			case 2:
				return "护照";
			case 3:
				return "港澳通行证";
			case 4:
				return "台湾通行证";
			case 5:
				return "台胞证";
			case 6:
				return "回乡证";
			case 7:
				return "出生日期";
			default:
				return "其他";
			}
		}
		/**
		 * 乘机人类型
		 * @param id
		 * @return
		 */
		public String getPassengerTypeToString(Integer id)
		{
			switch (id) {
			case 1:
				return "成人";
			case 2:
				return "儿童";
			case 3:
				return "婴儿";
			default:
				return "成人";
			}
		}
		/**
		 * 确认方式
		 * @param id
		 * @return
		 */
		public String getNoteTypeToString(Integer id)
		{
			switch (id) {
			case 1:
				return "不需要确认";
			case 2:
				return "手机短消息确认";
			case 3:
				return "电话确认";
			default:
				return "手机短消息确认";
			}
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
	}
