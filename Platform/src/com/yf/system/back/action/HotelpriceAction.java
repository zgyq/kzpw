

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.province.Province;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class HotelpriceAction extends B2b2cbackAction {
	private List listHotelprice;

	private Hotelprice hotelprice = new Hotelprice();

	private List listHotel;

	private Hotel hotel = new Hotel();

	private List<Province> listProvinces;
	
	private List<City> listCities;

	private List<Roomtype> listRoomtype;

	private Roomtype roomtype = new Roomtype();

	private String begintime;

	private String endtime;
	private String hotelpr;
	

	private Double p_day1 = 1D;

	private Double p_day2 = 1D;

	private Double p_day3 = 1D;

	private Double p_day4 = 1D;

	private Double p_day5 = 1D;

	private Double p_day6 = 1D;

	private Double p_day7 = 1D;
	
	private List<Province> listProvince;	
	
	private String[] showPrices ;
	private Integer h_provinceId; //所在的省
	private Integer h_cityId=-1; //所在的市
	private Integer h_cityId2; //所在的市
	private Integer checkrad;
	List<Double> list = new ArrayList<Double>(31);

	// 这个集合是存放价格的 1号到31号

	// private List < Roomtype > listRoomtype;
	// private Roomtype roomtype=new Roomtype();
	//	
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	private int lan;
	//酒店名称
	private String hotelName;
	
	//省份编号
	private String provinceid;
	
	//地市ID
	private String citiesid;
	// search
	// private String s_name;
	
	private String selectTypeid;
	
	private String updateDate;
	
	private String success;
	
	private String u_name[];
	
	private String u_mobile[];
	
	private String u_email[];
	
	

	public String[] getU_email() {
		return u_email;
	}

	public void setU_email(String[] u_email) {
		this.u_email = u_email;
	}

	public String[] getU_mobile() {
		return u_mobile;
	}

	public void setU_mobile(String[] u_mobile) {
		this.u_mobile = u_mobile;
	}

	public String[] getU_name() {
		return u_name;
	}

	public void setU_name(String[] u_name) {
		this.u_name = u_name;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * 列表查询酒店价格
	 */
	public String execute() throws Exception {
	/*	String where = " where 1=1";
	 	

		listProvince = listProvinces = Server.getInstance().getProvinceManager().findAllProvince("","ORDER BY " + Province.COL_id , -1, 0);
		listCities = Server.getInstance().getCityManager().findAllCity("", "ORDER BY " + City.COL_id, -1 ,0) ;
		
//		 if(pageinfo.getTotalrow()>0 &&   listProvince.size()==0){
//			pageinfo.setPagenum(1);
//			listProvince = Server.getInstance().getProvinceManager().findAllProvince(where," ORDER BY ID ",pageinfo);	
//		}*/
		listProvinces = Server.getInstance().getHotelService().findAllProvince("","ORDER BY " + Province.COL_id , -1, 0) ;
		//查询所有的国际市
		listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 ", "ORDER BY " + City.COL_id, -1 ,0) ;
		
		
		String where = " where 1=1 and "+Hotel.COL_type+" =1";
		
		List l=Server.getInstance().getHotelService().findAllHotelForPageinfo(where,"ORDER BY ID DESC",pageinfo);
		
		pageinfo =(PageInfo)l.remove(0);
		listHotel = l;
		return SUCCESS;
	}

	/**
	 * 转向到酒店价格添加页面
	 */
	public String toadd() throws Exception {
//		System.out.println(hotelprice.getRoomid()+"  "+hotelprice.getHotelid());
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"));
//		this.hotelprice.setRoomid(roomtype.getId());
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);
		return this.EDIT;
	}

	/**
	 * 转向到酒店价格修改页面
	 */
	public String toedit() throws Exception {

		hotel = Server.getInstance().getHotelService().findHotel(hotel.getId());

		roomtype = Server.getInstance().getHotelService().findRoomtype(
				hotelprice.getRoomid());
		String where = " where 1 =1 ";

		if (hotelprice.getRoomid() != null && hotelprice.getRoomid() > 0) {
			where += "and " + hotelprice.COL_roomid + "="
					+ hotelprice.getRoomid();
		}
		if (hotelprice.getDatenumber() != null
				&& hotelprice.getDatenumber().trim().length() > 0) {
			where += " and " + hotelprice.COL_datenumber + " = '"
					+ hotelprice.getDatenumber() + "'";
		}
		 List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(where, " ORDER BY ID ", pageinfo);
		 pageinfo =(PageInfo)l.remove(0);
		 listHotelprice = l;

		if (listHotelprice != null) {

			hotelprice = (Hotelprice) listHotelprice.toArray()[0];

		}
		return "detail";
	}

	/**
	 * 转向到酒店价格审核页面
	 */
	public String tocheck() throws Exception {
		hotelprice = Server.getInstance().getHotelService()
				.findHotelprice(hotelprice.getId());
		return CHECK;
	}

	/**
	 * 酒店价格查询
	 */
	
	public String priceQuery() throws Exception{
		getDate=0;
		/////////////////
		this.hotelName = new String(hotelName.getBytes("ISO8859-1"),"GBK");
		/////////
		String roomTypwhere = " where 1=1 and "+Roomtype.COL_hotelid+" = "+this.hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(roomTypwhere,"ORDER BY ID",-1,0);
		
		//////////////////
		String where =" where 1=1 and "+Hotelprice.COL_hotelid+"="+this.hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+hotelprice.getRoomid()+" and "+Hotelprice.COL_datenumber+"= '"+hotelprice.getDatenumber()+"'";
		this.listHotelprice = Server.getInstance().getHotelService().findAllHotelprice(where,"ORDER BY ID",-1,0);
		if(listHotelprice.size()>0){
			this.hotelprice = (Hotelprice)listHotelprice.get(0);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(hotelprice.getDatenumber()+"-01"));
			int day = cal.get(Calendar.DAY_OF_WEEK)-1;;
			int maxDay = this.getMaxdate(hotelprice.getDatenumber());
			this.showPrices = new String[day+maxDay];
			Method[] methods = Hotelprice.class.getDeclaredMethods();
			int count =1;
			for (Method method : methods) {
				if(method.getName().equals("getNo"+count)){
					if(count>maxDay){
						break;
					}
					showPrices[day] = method.invoke(this.hotelprice).toString();
					day++;
					count++;
				}
			}
			String timeList = " where 1=1 and "+Hotelprice.COL_hotelid+"="+this.hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+hotelprice.getRoomid();
			this.listHotelprice = Server.getInstance().getHotelService().findAllHotelprice(timeList,"ORDER BY ID",-1,0);
		}else{
			this.success="lack";
		}
		return "show";
	}
	
	
	
	/**
	 * 返回酒店信息，并显示按月份查询功能
	 */

	public String todetails() throws Exception {
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+this.roomtype.getHotelid();
		
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);
		where =" where 1=1 and "+hotelprice.COL_hotelid +"=" + this.roomtype.getHotelid()+" and "+hotelprice.COL_roomid +"=" +this.roomtype.getId()+" and "+hotelprice.COL_datenumber+"= '"+this.hotelprice.getDatenumber()+"'";
		
		roomtype = Server.getInstance().getHotelService().findRoomtype(this.roomtype.getId());
		
		Server.getInstance().getHotelService().findAllHotelprice(where,"ORDER BY ID",-1,0);
		
		
		return "vindicatePrice";
	}

	/**
	 * *查询需要维护的酒店
	 * 
	 * @return
	 * @throws Exception
	 */
	public String tosearch() throws Exception {
		String where = " where "+Hotel.COL_language+" ="+lan;
		//System.out.println(this.hotel.getProvinceid()+" "+this.hotel.getCityid());
	
		
		/*if(this.h_provinceId!=-1){
			where += " and "+ Hotel.COL_provinceid+" = "+h_provinceId;
		}*/
		/*if(lan!=-1){
			where +=" and "+Hotel.COL_language+" ="+lan;
		}*/
		
		if(this.checkrad==1){
			if(h_cityId !=-1){
				
				where +=" and "+Hotel.COL_cityid+"="+h_cityId;
			}else {
				where +="";
			}
		}
		if(this.checkrad==2){
			
			where +=" and "+Hotel.COL_cityid+"="+h_cityId2;
		}
		if(this.hotelName !=null&&this.hotelName.trim().length()>0){
			where +=" and " +Hotel.COL_name +" like '%"+this.hotelName.trim() +"%'";
		}
		System.out.println(where);
		 List l= Server.getInstance().getHotelService().findAllHotelForPageinfo(where,"ORDER BY C_UCODE DESC", pageinfo);
		pageinfo = (PageInfo)l.remove(0);
		listHotel = l ;
		listProvince = listProvinces = Server.getInstance().getHotelService().findAllProvince("","ORDER BY " + Province.COL_id , -1, 0);
		listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168", "ORDER BY " + City.COL_id, -1 ,0) ;
			return SUCCESS;
	}

	public List getAllRoomType(long id){
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+id;
		List<Roomtype> listRoomType= Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);
		return listRoomType;
	}
	
	
	
	public String toPriceVindicate()throws Exception{
//		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+this.roomtype.getHotelid();
		//this.hotelName = Server.getInstance().getHotelManager().findHotel(this.roomtype.getHotelid()).getName();
		this.hotelName = new String(hotelName.getBytes("ISO8859-1"),"UTF-8");
//		listRoomtype = Server.getInstance().getRoomtypeManager().findAllRoomtype(where,"ORDER BY ID",-1,0);
		//return "vindicatePrice";
		this.hotelprice.setHotelid(roomtype.getHotelid());
		return "to_tab";
	}
	/**
	 * 修改tab
	 */
	
	public String updatetab() throws Exception{
		this.hotelName = new String(hotelName.getBytes("ISO8859-1"),"UTF-8");
		return "update_tab";
	}
	
	
	public String showtab()throws Exception{
		this.hotelName = new String(hotelName.getBytes("ISO8859-1"),"UTF-8");
		return "show_tab";
	}
	
	
	/*
	 * 根据酒店ID getAllPrice
	 */
	
	public String getAllpricebyid() throws Exception{

		
	
		String where = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
		
		this.hotelName=Server.getInstance().getHotelService().findHotel(hotelprice.getHotelid()).getName();
		List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(where,"order by ID DESC",pageinfo);
		pageinfo = (PageInfo)l.remove(0);
		this.listHotelprice = l;
		return "topricelist";
	}
	
	
	public String getroomnamebyroomid(long id){
		//System.out.println(id);
		return Server.getInstance().getHotelService().findRoomtype(id).getName();
	}
	
	
	
	
	
	public String getcity() throws IOException
	{
		listCities = Server.getInstance().getHotelService().findAllCity(" where "+City.COL_provinceid+" = "+h_provinceId," ORDER BY " + City.COL_id , -1, 0) ;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		String ym ="<select id=\"h_cityId\" style=\"WIDTH: 120px\" name=\"h_cityId\">"+"<option value='-1'>---请选择---</option>";
		for(int i=0;i<listCities.size();i++)
		{	if(this.h_cityId!=null&&this.h_cityId>0)
			{
				if(this.h_cityId==listCities.get(i).getId())
				{
					ym+="<option value='"+listCities.get(i).getId()+"' selected>"+listCities.get(i).getName()+"</option>";
				}else
				{
					ym+="<option value='"+listCities.get(i).getId()+"'>"+listCities.get(i).getName()+"</option>";	
				}
			}
			else
				{
					ym+="<option value='"+listCities.get(i).getId()+"'>"+listCities.get(i).getName()+"</option>";
				}
				}
		ym+="</select>";
		out.println(ym) ;
		out.flush();
		out.close();
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * update酒店价格
	 * @throws UnsupportedEncodingException 
	 */
	
	public String update() throws Exception{
			prosceniumNo=0;
			getDate=0;
//			roomtype.setHotelid(this.hotelprice.getHotelid());
//			String roomWhere = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
//			listRoomtype = Server.getInstance().getRoomtypeManager().findAllRoomtype(roomWhere,"ORDER BY ID",-1,0);
			
			String datenumberWhere = " where 1=1 and "+hotelprice.COL_roomid+" = "+hotelprice.getRoomid()+" and "+hotelprice.COL_hotelid+"="+hotelprice.getHotelid();
//			listHotelprice = Server.getInstance().getHotelpriceManager().findAllHotelprice(datenumberWhere,"ORDER BY ID",-1,0);
			hotelprice.setLanguage(0);
			hotelprice.setDeptprice(hotelpr);
			Server.getInstance().getHotelService().updateHotelprice(hotelprice);
			Server.getInstance().getHotelService().findHotel(hotelprice.getHotelid()).setState(4);
			String updateWhere = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
			List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(updateWhere,"order by C_ROOMID",pageinfo);
			pageinfo =(PageInfo)l.remove(0);
			this.listHotelprice = l;
			return "to_tab";
	}
	
	/**
	 * 批量启用
	 * @return
	 */
	public String unlock() throws Exception{
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"),"UTF-8");
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);	
		String[] begintimeArr = this.begintime.split("-");	
		String[] endtimeArr = this.endtime.split("-");
		
		this.lockOrunlock(begintimeArr,endtimeArr,false);
		//this.success ="success";
		Server.getInstance().getHotelService().findHotel(hotelprice.getHotelid()).setState(4);
		String priceWhere = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
		List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(priceWhere,"order by "+Hotelprice.COL_datenumber+" desc",pageinfo);
		pageinfo =(PageInfo)l.remove(0);
		this.listHotelprice = l;
		return "to_tab";
	}
	
	
	/**
	 * 转向添加酒店价格
	 * 
	 * @throws ParseException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public String addprice() throws Exception {
		System.out.println("addprice1");
//
//		Float[] prices = new Float[] { p_day1, p_day2, p_day3, p_day4, p_day5,
//				p_day6, p_day7 };
//
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm");
//		Date begindate = format.parse(begintime);
//		Date enddate = format.parse(endtime);
//
//		Calendar beginCal = Calendar.getInstance();
//		beginCal.setTime(begindate);
//
//		Calendar endCal = Calendar.getInstance();
//		endCal.setTime(enddate);
//
//		// Hotelprice hotelprice = new Hotelprice() ;
//		while (beginCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
//			int week = beginCal.get(Calendar.DAY_OF_WEEK);
//			int day = beginCal.get(Calendar.DAY_OF_MONTH);
//			Float price = prices[week - 1];
//			Method[] methods = hotelprice.getClass().getMethods();
//			for (Method m : methods) {
//				if (m.getName().equals("setNo" + day)) {
//					m.invoke(hotelprice, price);
//				}
//			}
//			int month = beginCal.get(Calendar.MONTH);
//			int year = beginCal.get(Calendar.YEAR);
//			beginCal.add(Calendar.DAY_OF_MONTH, 1);
//			int monthbak = beginCal.get(Calendar.MONTH);
//			if (month != monthbak
//					|| beginCal.getTimeInMillis() == endCal.getTimeInMillis()) {
//				hotelprice.setDatenumber(year + "-" + (month + 1));
//				Server.getInstance().getHotelpriceManager().createHotelprice(
//						hotelprice);
//				hotelprice = new Hotelprice();
//			}
//		}
		//System.out.println(this.begintime+"开始时间"+" "+this.endtime+":结束时间");
		
		
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);
		
		//根据酒店ID，房型ID，获取现有价格list
		
		String existpriceWhere =" where 1=1 and "+Hotelprice.COL_hotelid+"="+hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+hotelprice.getRoomid()+" and "+Hotelprice.COL_datenumber +" between '"+this.begintime+"' and '"+this.endtime+"'";
		List<Hotelprice> existsPrice = Server.getInstance().getHotelService().findAllHotelprice(existpriceWhere,"ORDER BY ID",-1,0);
		Map<String,Long> map = new HashMap<String,Long>();
		if(existsPrice.size()>0){
			for(Hotelprice price:existsPrice){
				map.put(price.getDatenumber(),price.getId());
			}
		}
		StringBuffer beginAndendstr = new StringBuffer(this.begintime+"|"+this.endtime);
		
		List<String> especiallyList = new ArrayList<String>();
		
		if(this.u_name[0]!="" && this.u_mobile[0]!="" && this.u_email[0]!=""){
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<this.u_name.length;i++){
				StringBuffer sb = new StringBuffer();
				sb.append(String.valueOf(sim.parse(this.u_name[i]).getTime())+"|"+String.valueOf(sim.parse(this.u_mobile[i]).getTime())+"|"+this.u_email[i]);
				especiallyList.add(sb.toString());
			}
		}

		String[] begintimeArr = this.begintime.split("-");
		
		String[] endtimeArr = this.endtime.split("-");

		if(begintimeArr[1].startsWith("0")){
			this.begintime = begintimeArr[0]+"-"+begintimeArr[1].substring(1);
		}
		
		if(endtimeArr[1].startsWith("0")){
			this.endtime = endtimeArr[0]+"-"+endtimeArr[1].substring(1);
		}
		int beginyyyy = Integer.parseInt(this.begintime.split("-")[0]);
		
		int endyyyy = Integer.parseInt(this.endtime.split("-")[0]);
		
		int beginMm = Integer.parseInt(this.begintime.split("-")[1]);
		
		int endMm = Integer.parseInt(this.endtime.split("-")[1]);
		
		if(beginyyyy == endyyyy){
			int count = endMm - beginMm;
			for(int i=0;i<=count;i++){
				String tempBegintime = beginyyyy+"-"+(beginMm+i);
				this.addPrice(tempBegintime,especiallyList,map);
			}
			this.success="success";
		}else{
			int count = 12 -beginMm;
			for(int i=0;i<=count;i++){
				String tempBegintime = beginyyyy+"-"+(beginMm+i);
				this.addPrice(tempBegintime,especiallyList,map);
			}
			int yyyy = endyyyy - beginyyyy;
			if(yyyy==1){
				for(int i=1;i<=endMm;i++){
					String tempBegintime = endyyyy+"-"+i;
					this.addPrice(tempBegintime,especiallyList,map);
				}
			}else{
				for(int i=1;i<=yyyy;i++){
					for(int j=1;j<=12;j++){
						String tempBegintime = beginyyyy+i+"-"+j;
						if(beginyyyy+i==endyyyy){
							if(endMm<j){
								break;
							}
						}
						this.addPrice(tempBegintime,especiallyList,map);
					}
				}
				
			}
			this.success="success";
		}
		
		//System.out.println(this.hotelprice);
		//System.out.println(this.roomtype.getHotelid()+"酒店ID"+" "+this.roomtype.getId()+"房型ID");
		Server.getInstance().getHotelService().findHotel(hotelprice.getHotelid()).setState(4);

		this.begintime = beginAndendstr.toString().split("\\|")[0];
		this.endtime = beginAndendstr.toString().split("\\|")[1];

		String priceWhere = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
		List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(priceWhere,"order by "+Hotelprice.COL_datenumber+" desc",pageinfo);
		pageinfo = (PageInfo)l.remove(0);
		this.listHotelprice= l;

		return "to_tab";
	}
	
	
	
	/**
	 * 返回价格维护界面
	 */
	public String toBack() throws Exception{
		//this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"),"UTF-8");
		//this.listRoomtype = Server.getInstance().getRoomtypeManager().findAllRoomtype(" where "+Roomtype.COL_hotelid+"="+roomtype.getHotelid(),"ORDER BY ID",-1,0);
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"),"UTF-8");
		String where = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
		List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(where,"order by "+Hotelprice.COL_datenumber+","+Hotelprice.COL_roomid+" asc",pageinfo);
		pageinfo = (PageInfo)l.remove(0);
		this.listHotelprice = l;
		return "to_tab";
	}
	
	//跳转第七个
	public String toPricequeryandview() throws Exception{
		//this.hotelName = new String(hotelName.getBytes("ISO8859-1"),"UTF-8");
		return "to_query";
	}
	
	public String toShow ()throws Exception{
		this.priceQuerybydatenumber();
		return "show";
	}
	

	/**
	 * 查看过期酒店
	 */
	public String overdue(){
		System.out.println(this.h_provinceId+" .,.,.,., "+this.h_cityId);
		String where = " where 1=1 ";
		/*if(this.h_provinceId!=-1){
			where += " and "+ Hotel.COL_provinceid+" = "+this.h_provinceId;
		}*/
		
		if(checkrad==1){
			if(h_cityId !=-1){
				where +=" and "+Hotel.COL_cityid+" = "+h_cityId;
			}
			
		}
		if(checkrad==2){
			
				where +=" and "+Hotel.COL_cityid+" = "+h_cityId2;
			
			
		}
		//////////////////////////////////////////////////////////////////////////
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String mmStr="";
		if(cal.get(Calendar.MONTH)+1==12){
			mmStr=cal.get(Calendar.YEAR+1)+"-01";
		}else{
			mmStr=String.valueOf(cal.get(Calendar.YEAR));
			int mmInt = cal.get(Calendar.MONTH)+2;
			if(mmInt<10){
				mmStr+="-0"+mmInt;
			}else{
				mmStr+="-"+mmInt;
			}
			
		}
		
		String hoteWhere = where + " and C_STATE=3 and ID in(select C_HOTELID from T_ROOMTYPE where ID not in(select C_ROOMID from T_HOTELPRICE where C_DATENUMBER = '"+mmStr+"'))";
		List l = Server.getInstance().getHotelService().findAllHotelForPageinfo(hoteWhere,"order by C_PROVINCEID",pageinfo);
		pageinfo = (PageInfo)l.remove(0);
		this.listHotel =l;
		listProvince = listProvinces = Server.getInstance().getHotelService().findAllProvince("","ORDER BY " + Province.COL_id , -1, 0);
		listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168", "ORDER BY " + City.COL_id, -1 ,0) ;
		
		return SUCCESS;
		
	}

	/**
	 * 酒店价格延期
	 */
	public String defer() throws Exception {
	
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"));
		
		String where =" where 1=1 and "+Hotelprice.COL_hotelid+"="+hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+hotelprice.getRoomid()+" and "+Hotelprice.COL_datenumber+"="+
		"( select max("+Hotelprice.COL_datenumber+") from "+Hotelprice.TABLE+" where "+Hotelprice.COL_hotelid+"="+hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+hotelprice.getRoomid()+")";
		List<Hotelprice> list =  Server.getInstance().getHotelService().findAllHotelprice(where,"ORDER BY ID",-1,0);
		if(list.size()>0){
			Double[] price = {p_day1,p_day2,p_day3,p_day4,p_day5,p_day6,p_day7};
			this.hotelprice = list.get(0);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(hotelprice.getDatenumber()+"-01"));
			int week = cal.get(Calendar.DAY_OF_WEEK);
			for(int i=1;i<=7;i++){
				if(week>7){
					week=1;
				}
				price[week-1] = (Double)Hotelprice.class.getMethod("getNo"+i).invoke(this.hotelprice);
				week++;
			}
			int[] beginIntarr = this.getDateinttype((this.hotelprice.getDatenumber()+"-00").split("-"));
			int[] endIntarr = this.getDateinttype((this.endtime+"-00").split("-"));
			String [] beginArr = this.hotelprice.getDatenumber().split("-");
			String [] endArr = this.endtime.split("-");
			int mmCount = -1;
			if(beginArr[0].equals(endArr[0])){
				mmCount = endIntarr[1]-beginIntarr[1];
			}else{
				mmCount = (12-beginIntarr[1]) + (endIntarr[0]-beginIntarr[0]-1)*12 +endIntarr[1];
			}
			int j =0;
			int k =1;
			
			for(int i=1;i<=mmCount;i++){
				StringBuffer beginStr = new StringBuffer();
				if(j==1){
					k=12;
				}
				if(j+beginIntarr[1]+k>12){
					k=0;
					j=1;
					beginIntarr[1]=0;
					beginStr.append(++beginIntarr[0]);
				}else{
					beginStr.append(beginIntarr[0]);
					if(j==0){
						k=0;
						j=1;
					}
				}
				if(j+beginIntarr[1]<10){	
					beginStr.append("-0"+(j+beginIntarr[1]));
				}else{
					beginStr.append("-"+(j+beginIntarr[1]));
					if(j+beginIntarr[1]>12){
						beginIntarr[1]=0;
					}
				}
				if(j==12){
					j=0;
				}
				j++;
				//System.out.println(beginStr.toString());
				Hotelprice newPrice = new Hotelprice();
				newPrice.setDatenumber(beginStr.toString());
				newPrice.setHotelid(this.hotelprice.getHotelid());
				newPrice.setRoomid(this.hotelprice.getRoomid());
				newPrice.setDescription(this.hotelprice.getDescription());
				newPrice.setDeptprice(this.hotelprice.getDeptprice());
				newPrice.setIsvalid(this.hotelprice.getIsvalid());
				int maxDay = this.getMaxdate(beginStr.toString());
				for(int day=1;day<=maxDay;day++){
					//System.out.println(beginStr.toString());
					Calendar newCal = Calendar.getInstance();
					if(day<10){
						
						newCal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(beginStr.toString()+"-0"+day));
					}else{
						
						newCal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(beginStr.toString()+"-"+day));
					}
					int newWeek = newCal.get(Calendar.DAY_OF_WEEK);
					
					Hotelprice.class.getMethod("setNo"+day,Double.class).invoke(newPrice,price[newWeek-1]);
				}
				Server.getInstance().getHotelService().createHotelprice(newPrice);	
			}
			Server.getInstance().getHotelService().findHotel(hotelprice.getHotelid()).setState(4);
		}
		String priceWhere = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
		List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(priceWhere,"order by "+Hotelprice.COL_datenumber+" desc",pageinfo);
		pageinfo =(PageInfo)l.remove(0);
		this.listHotelprice =l;
		return "to_tab";
	}

	/**
	 * 编辑酒店价格
	 */
	public String edit() throws Exception {

		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"));
		
		//roomtype = Server.getInstance().getRoomtypeManager().findRoomtype(this.roomtype.getId());
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);
		
		where  = " where 1=1 and "+hotelprice.COL_roomid+" = "+this.hotelprice.getRoomid()+" and "+hotelprice.COL_hotelid+"="+this.hotelprice.getHotelid();
		
		listHotelprice = Server.getInstance().getHotelService().findAllHotelprice(where,"ORDER BY ID",-1,0);
//		this.hotelprice.setRoomid(roomid);
		return "update";
	}

	/**
	 * 查询酒店价格
	 */
	public String query() throws Exception {
		//System.out.println(this.hotelprice.getHotelid()+" "+this.hotelprice.getRoomid()+" "+this.hotelprice.getDatenumber());
//		prosceniumNo=0;
//		this.hotelName = new String(hotelName.getBytes("ISO8859-1"),"UTF-8");
//		String where =" where 1=1 and "+hotelprice.COL_datenumber+"= '"+hotelprice.getDatenumber()+"' and "+hotelprice.COL_hotelid+"="+hotelprice.getHotelid()+" and "+hotelprice.COL_roomid+"="+hotelprice.getRoomid();
//		
//		String roomWhere = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
//		listRoomtype = Server.getInstance().getRoomtypeManager().findAllRoomtype(roomWhere,"ORDER BY ID",-1,0);
//		
//		String datenumberWhere = " where 1=1 and "+hotelprice.COL_roomid+" = "+hotelprice.getRoomid()+" and "+hotelprice.COL_hotelid+"="+hotelprice.getHotelid();
//		listHotelprice = Server.getInstance().getHotelpriceManager().findAllHotelprice(datenumberWhere,"ORDER BY ID",-1,0);
//
//		List<Hotelprice> list = Server.getInstance().getHotelpriceManager().findAllHotelprice(where,"ORDER BY ID",-1,0);
//		if(list.size()!=0){
//			this.hotelprice = list.get(0);
//			//System.out.println(this.hotelprice);
//			roomtype.setHotelid(hotelprice.getHotelid());
//			Calendar cal  = Calendar.getInstance() ;
//			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(hotelprice.getDatenumber() + "-01")) ;
//			
//			showPrices = new String[cal.get(Calendar.DAY_OF_WEEK)-1 + cal.getActualMaximum(Calendar.DAY_OF_MONTH)] ;
//			int count =1;
//			for(int i=cal.get(Calendar.DAY_OF_WEEK)-1; i<showPrices.length; i++) {
//				showPrices[i] = ((Float)hotelprice.getClass().getMethod("getNo"+count).invoke(hotelprice)).toString();
//				count++;
//			}
//		}
		this.priceQuerybydatenumber();
		return "update";
	}

	/**
	 * 转向批量禁用酒店价格
	 * 
	 * @return
	 * @throws Exception
	 */
	public String tobatchlock() throws Exception {

		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+this.hotelprice.getHotelid();
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"));

		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);
		
		return "batchlock";
	}

	/**
	 * 批量禁用酒店房间价格，以月份为单位??
	 */

	public String batchlock() throws Exception{
		  //SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
// Date begindate = format.parse("2008-2-3");
// Date enddate = format.parse("2008-3-1");
//				java.sql.Date begindate = java.sql.Date.valueOf(begintime);
//				java.sql.Date enddate = java.sql.Date.valueOf(endtime);
//
//				Calendar begin = Calendar.getInstance();
//				begin.setTime(begindate);
//
//				Calendar end = Calendar.getInstance();
//				end.setTime(enddate);
//				StringBuffer sb = new StringBuffer();
//				// 是否是同一年
//				int year = begin.get(Calendar.YEAR);
//				int year1 = end.get(Calendar.YEAR);
//				int month=0;
//				int month1=0;
//				System.out.println(begintime);
//				System.out.println(endtime);
//				// 同年
//				if(year == year1){
//					month = begin.get(Calendar.MONTH);
//					month1 = end.get(Calendar.MONTH);
//					if(month == month1){// 同月
//						int d = begin.get(Calendar.DAY_OF_MONTH);
//						int maxDay = begin.getMaximum(Calendar.DAY_OF_MONTH);
//						while(d<maxDay){
//							sb.append(d).append(".");
//							begin.add(Calendar.DAY_OF_MONTH,1);
//							d = begin.get(Calendar.DAY_OF_MONTH);
//						}
//						// 插入数据库
//						System.out.println(sb.toString());
//						System.out.println(hotelprice.getId());
//						hotelprice.setIsvalid(sb.toString());
//						Server.getInstance().getHotelpriceManager().updateHotelprice(hotelprice);
//					}else{// 不同月
//						while(month<month1){
//							
//						}
//					}
//					
//				}else{// 不同年
//					
//				}
//				
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"),"UTF-8");
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);	

		//String beginWhere = " where 1=1 and "+hotelprice.COL_datenumber+"= '"+this.begintime.substring(0,this.begintime.lastIndexOf("-"))+"' and "+hotelprice.COL_hotelid+"="+hotelprice.getHotelid()+" and "+hotelprice.COL_roomid+"="+roomtype.getId();
		//List<Hotelprice> tempList  = Server.getInstance().getHotelpriceManager().findAllHotelprice(beginWhere,"ORDER BY ID",-1,0);
//		if(tempList.size()!=0){
//			hotelprice = tempList.get(0);
//		}else{
//			this.success ="开始日期没有价格";
//			return "batchlock";
//		}

		String[] beginArr = this.begintime.split("-");
		String[] endArr = this.endtime.split("-");
		//System.out.println(begintime+" "+endtime+" "+this.hotelprice.getHotelid()+" "+hotelprice.getRoomid());
		this.lockOrunlock(beginArr,endArr,true);
		//this.success ="success";
		Server.getInstance().getHotelService().findHotel(hotelprice.getHotelid()).setState(4);
		String priceWhere = " where 1=1 and "+hotelprice.COL_hotelid+" = "+hotelprice.getHotelid();
		List l = Server.getInstance().getHotelService().findAllHotelpriceForPageinfo(priceWhere,"order by "+Hotelprice.COL_datenumber+" desc",pageinfo);
		pageinfo =(PageInfo)l.remove(0);
		this.listHotelprice =l;
		return "to_tab";
	}
	
	/* * 转向批量启用酒店价格
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toqiyong() throws Exception {

		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+this.hotelprice.getHotelid();
		this.hotelName = new String(this.hotelName.getBytes("ISO8859-1"));

		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);

		return "qiyong";
	}
	
	/* * 转向酒店价格延期
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toyanqi() throws Exception {
		this.hotelName = new String(hotelName.getBytes("ISO8859-1"));
		String where = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(where,"ORDER BY ID",-1,0);	
		return "yanqi";
	}
	

	/**
	 * 返回酒店价格对象
	 */

	public Object getModel() {
		return listHotelprice;
	}

	public List<Hotelprice> getListHotelprice() {
		return listHotelprice;
	}



	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}

	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}

	public Hotelprice getHotelprice() {
		return hotelprice;
	}

	public void setHotelprice(Hotelprice hotelprice) {
		this.hotelprice = hotelprice;
	}

	public List<Hotel> getListHotel() {
		return listHotel;
	}

	public void setListHotel(List<Hotel> listHotel) {
		this.listHotel = listHotel;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<City> getListCities() {
		return listCities;
	}

	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}

	public List<Province> getListProvinces() {
		return listProvinces;
	}

	public void setListProvinces(List<Province> listProvinces) {
		this.listProvinces = listProvinces;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public List<Double> getList() {
		return list;
	}

	public void setList(List<Double> list) {
		this.list = list;
	}

	public Double getP_day1() {
		return p_day1;
	}

	public void setP_day1(Double p_day1) {
		this.p_day1 = p_day1;
	}

	public Double getP_day2() {
		return p_day2;
	}

	public void setP_day2(Double p_day2) {
		this.p_day2 = p_day2;
	}

	public Double getP_day3() {
		return p_day3;
	}

	public void setP_day3(Double p_day3) {
		this.p_day3 = p_day3;
	}

	public Double getP_day4() {
		return p_day4;
	}

	public void setP_day4(Double p_day4) {
		this.p_day4 = p_day4;
	}

	public Double getP_day5() {
		return p_day5;
	}

	public void setP_day5(Double p_day5) {
		this.p_day5 = p_day5;
	}

	public Double getP_day6() {
		return p_day6;
	}

	public void setP_day6(Double p_day6) {
		this.p_day6 = p_day6;
	}

	public Double getP_day7() {
		return p_day7;
	}

	public void setP_day7(Double p_day7) {
		this.p_day7 = p_day7;
	}

	public List<Roomtype> getListRoomtype() {
		return listRoomtype;
	}

	public void setListRoomtype(List<Roomtype> listRoomtype) {
		this.listRoomtype = listRoomtype;
	}

	public Roomtype getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public List<Province> getListProvince() {
		return listProvince;
	}

	public void setListProvince(List<Province> listProvince) {
		this.listProvince = listProvince;
	}

	public String getCitiesid() {
		return citiesid;
	}

	public void setCitiesid(String citiesid) {
		this.citiesid = citiesid;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}


	public String[] getShowPrices() {
		return showPrices;
	}

	public void setShowPrices(String[] showPrices) {
		this.showPrices = showPrices;
	}

	private void addPrice(String beginTime,List<String> parameterList,Map<String,Long> map)throws Exception{
		Hotelprice temphotelprice = new Hotelprice();
		Double[] price = {p_day1,p_day2,p_day3,p_day4,p_day5,p_day6,p_day7};
		System.out.println("addPrice2");
		System.out.println("price==");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M");
		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(sdf.parse(beginTime));
		int maxDate = beginCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int week = -1;
		
		StringBuffer isvalid = new StringBuffer();;
		for (int i = 1; i <= maxDate; i++) {
			try {
				Method method = Hotelprice.class.getMethod("setNo"+i,Double.class);
				SimpleDateFormat strDate = new SimpleDateFormat("yyyy-M-d");
				Date tempDate = strDate.parse(beginTime+"-"+i);
//				if(i<10){
//					isvalid.append("0"+i+"|0|");
//				}else{
//					isvalid.append(i+"|0|");
//				}
				isvalid.append("0");
				long newTime = tempDate.getTime();
				boolean flag = true;
				if(parameterList.size()>0){
					for(int par =0;par<parameterList.size();par++){
						String[] tempTimearr = parameterList.get(par).split("\\|");
						if(Double.parseDouble(tempTimearr[0])<=newTime && Double.parseDouble(tempTimearr[1])>=newTime){
							method.invoke(temphotelprice,Double.parseDouble(tempTimearr[2]));
							flag = false;
							break;
						}
						
					}
					if(flag){
						Calendar tempCal = Calendar.getInstance();
						tempCal.setTime(tempDate);
						week = tempCal.get(Calendar.DAY_OF_WEEK);
						method.invoke(temphotelprice,price[week-1]);
					}
				}else{
					Calendar tempCal = Calendar.getInstance();
					tempCal.setTime(tempDate);
					week = tempCal.get(Calendar.DAY_OF_WEEK);
					method.invoke(temphotelprice,price[week-1]);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(beginTime.split("-")[1].length()<2){
			beginTime = beginTime.split("-")[0]+"-"+"0"+beginTime.split("-")[1];
		}
		temphotelprice.setDatenumber(beginTime);
		temphotelprice.setHotelid(hotelprice.getHotelid());
		temphotelprice.setRoomid(hotelprice.getRoomid());
		temphotelprice.setDescription(hotelprice.getDescription());
		temphotelprice.setDeptprice(hotelprice.getDeptprice());
		temphotelprice.setIsvalid(isvalid.toString());
		temphotelprice.setLanguage(0);
			try {
				if(map.size()>0){
					if(map.containsKey(beginTime)){
						temphotelprice.setId(map.get(beginTime));
						System.out.println("创建");
						Server.getInstance().getHotelService().updateHotelprice(temphotelprice);
					}else{
						Server.getInstance().getHotelService().createHotelprice(temphotelprice);
					}
				}else{
					System.out.println("创建");
					temphotelprice=Server.getInstance().getHotelService().createHotelprice(temphotelprice);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	static int prosceniumNo=0;
	public int getNo(){
		return ++prosceniumNo;
	}
	static int getDate=0;
	public int getDate(){
		return ++getDate;
	}
	private void lockDay(String where,int beginDatenum,int maxDate,boolean isNot){

		StringBuffer isValid = new StringBuffer();
		StringBuffer lockBuff = new StringBuffer();
		where = " where 1=1 and "+Hotelprice.COL_hotelid+" = "+hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+hotelprice.getRoomid()+" and "+Hotelprice.COL_datenumber+"= '"+where+"'";

//		for(int i = beginDatenum;i<=maxDate;i++){
//			if(i<10){
//				isValid.append("0"+i+"|0|");
//			}else{
//				isValid.append(i+"|0|");
//			}
//		}
//		System.out.println(isValid.toString()+" 禁用的字符串------");
		
		List<Hotelprice> oldList = Server.getInstance().getHotelService().findAllHotelprice(where,"ORDER BY ID",-1,0);

		if(oldList.size()>0){
			//System.out.println("可以查到==");
			List<String> validList = new ArrayList<String>();;
			Hotelprice temp = oldList.get(0);
			String oldIsvalid = temp.getIsvalid();
			//int index=1000;
			//if(oldIsvalid != null && oldIsvalid.length()>0){
//				if(isNot){
					//禁用部分
					isValid.append(oldIsvalid);
//				}else{
//					//启用部分
//					String[] oldValid = oldIsvalid.split("\\|");
//					for (int i = 0; i < oldValid.length; i+=2) {
//						validList.add(oldValid[i]);
//					}
//				}
				//int cycle = maxDate-beginDatenum;
//					if(isNot){
						if(beginDatenum != 1){
							lockBuff.append(isValid.substring(0,beginDatenum-1));
						}

						if(isNot){
							for(int i=beginDatenum;i<=maxDate;i++){
								lockBuff.append("1");
							}	
						}else{
							for(int i=beginDatenum;i<=maxDate;i++){
								lockBuff.append("0");
							}
						}
						if(maxDate<isValid.length()){	
							lockBuff.append(isValid.substring(maxDate));
						}

//						禁用部分
//						if(beginDatenum<10){
//							index = oldIsvalid.indexOf("0"+beginDatenum);
//						}else{
//							index = oldIsvalid.indexOf(String.valueOf(beginDatenum));
//						}
//						if(index < 0){
//							if(beginDatenum<10){
//								isValid.append("0"+beginDatenum+"|0|");
//							}else{
//								isValid.append(beginDatenum+"|0|");
//							}
//						}
						
						
//					}else{
////						启用部分
//						String beginStr="";
//						if(beginDatenum<10){
//							beginStr ="0"+beginDatenum;
//						}else{
//							beginStr = String.valueOf(beginDatenum);
//						}
//						if(validList.contains(beginStr)){
//							validList.remove(beginStr);
//						}
//					}
//				if(isNot){
//					禁用部分
					//temp.setIsvalid(isValid.toString().substring(0,isValid.length()-1));
					temp.setIsvalid(lockBuff.toString());
//				}else{
////					启用部分
//					for (int i = 0; i < validList.size(); i++) {
//						isValid.append(validList.get(i));
//						isValid.append("|0|");
//					}
//					if(isValid.length()==0){
//						temp.setIsvalid("");
//					}else{
//						temp.setIsvalid(isValid.toString().substring(0,isValid.length()-1));
//					}
//					
//				}
				
//			}
//			else{
//				if(isNot){
			/////////////////////////////////////////////////修改前代码		
//					禁用部分
//					for(int i = beginDatenum;i<=maxDate;i++){
//						if(i<10){
//							isValid.append("0"+i+"|0|");
//						}else{
//							isValid.append(i+"|0|");
//						}
//					}
					
	
					//temp.setIsvalid(isValid.toString().substring(0,isValid.length()-1));
				//}
			//}
			Server.getInstance().getHotelService().updateHotelprice(temp);
		}
			
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

	private int[] getMaxandmin(String[] beginArr,String[] endArr,int i){
		int maxDate = -1;
		int minDate = -1;
			if(beginArr[i].startsWith("0")){
				minDate = Integer.parseInt(beginArr[i].substring(1));
			}else{
				minDate = Integer.parseInt(beginArr[i]);
			}
			if(endArr[i].startsWith("0")){
				maxDate = Integer.parseInt(endArr[i].substring(1));
			}else{
				maxDate = Integer.parseInt(endArr[i]);
			}
		//int[] maxAndmin = {minDate,maxDate};
		return new int[]{minDate,maxDate};
	}
	
	
	
	
	
	public int[] getDateinttype(String[] date){
		int[] inttype = new int[3];
		inttype[0] = Integer.parseInt(date[0]);
		if(date[1].startsWith("0")){
			inttype[1] = Integer.parseInt(date[1].substring(1));
		}else{
			inttype[1] = Integer.parseInt(date[1]);
		}
		if(date[2].startsWith("0")){
			inttype[2] = Integer.parseInt(date[2].substring(1));
		}else{
			inttype[2] = Integer.parseInt(date[2]);
		}
		return inttype;
	}
	
	private void lockOrunlock(String[] beginArr,String[] endArr,boolean isNot){
		if(beginArr[0].equals(endArr[0]) && beginArr[1].equals(endArr[1])){

			String whereStr = beginArr[0]+"-"+beginArr[1];

			int[] maxAndmin = this.getMaxandmin(beginArr,endArr,2);

			this.lockDay(whereStr,maxAndmin[0],maxAndmin[1],isNot);
		
	    }else if(beginArr[0].equals(endArr[0]) && (!beginArr[1].equals(endArr[1]))){

	    	int maxDate = this.getMaxdate(begintime.substring(0,begintime.lastIndexOf("-")));

	    	int factDate =-1;
	    	if(beginArr[2].startsWith("0")){
	    		factDate = Integer.parseInt(beginArr[2].substring(1));
	    	}else{
	    		factDate = Integer.parseInt(beginArr[2]);
	    	}
	    	if(factDate < maxDate){
	    		//String whereStr = " where 1=1 and "+Hotelprice.COL_hotelid+" = "+hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+roomtype.getId()+" and "+Hotelprice.COL_datenumber+"= '"+begintime.substring(0,begintime.lastIndexOf("-"))+"'";
				//int[] maxAndmindate = this.getMaxandmin(beginArr,endArr,2);
				this.lockDay(begintime.substring(0,begintime.lastIndexOf("-")),factDate,maxDate,isNot);
	    	}
	    	int[] maxAndmindate = this.getMaxandmin(beginArr,endArr,1);
	    	for(int i=1;i<maxAndmindate[1]-maxAndmindate[0];i++){
	    		String lockDate = beginArr[0];
	    		int mm = -1;
	    		if(beginArr[1].startsWith("0")){
	    			mm = Integer.parseInt(beginArr[1].substring(1));
	    			if(mm+i>=10){lockDate+="-"+(mm+i);}else{lockDate+="-0"+(mm+i);}
	    			
	    		}else{
	    			mm = Integer.parseInt(beginArr[1]);
	    			lockDate+="-"+(mm+i);
	    		}
	    		int nextMaxDate = this.getMaxdate(lockDate);
	    		this.lockDay(lockDate,1,nextMaxDate,isNot);
	    	}
	    	int day = -1;

	    	if(endArr[2].startsWith("0")){
    			day = Integer.parseInt(endArr[2].substring(1));
    		}else{
    			day = Integer.parseInt(endArr[2]);
    		}
	    	this.lockDay(endtime.substring(0,endtime.lastIndexOf("-")),1,day,isNot);
	    }else if(!beginArr[0].equals(endArr[0])){
	    	int maxDate = this.getMaxdate(begintime.substring(0,begintime.lastIndexOf("-")));
	    	int factDate =-1;
	    	if(beginArr[2].startsWith("0")){
	    		factDate = Integer.parseInt(beginArr[2].substring(1));
	    	}else{
	    		factDate = Integer.parseInt(beginArr[2]);
	    	}
	    	if(factDate < maxDate){
	    		//String whereStr = " where 1=1 and "+Hotelprice.COL_hotelid+" = "+hotelprice.getHotelid()+" and "+Hotelprice.COL_roomid+"="+roomtype.getId()+" and "+Hotelprice.COL_datenumber+"= '"+begintime.substring(0,begintime.lastIndexOf("-"))+"'";
				//int[] maxAndmindate = this.getMaxandmin(beginArr,endArr,2);
				this.lockDay(begintime.substring(0,begintime.lastIndexOf("-")),factDate,maxDate,isNot);
	    	}
	    	
	    	/////////////////////////////
	    	int mmNum = -1;
	    	if(beginArr[1].startsWith("0")){
	    		mmNum = Integer.parseInt(beginArr[1].substring(1));
	    	}else{
	    		mmNum = Integer.parseInt(beginArr[1]);
	    	}
	    	for(int i=1;i<=12-mmNum;i++){
	    		StringBuffer sb = new StringBuffer();
	    		sb.append(beginArr[0]);
	    		if(beginArr[1].startsWith("0")){
	    			if(Integer.parseInt(beginArr[1].substring(1))+i<10){
	    				sb.append("-0"+(Integer.parseInt(beginArr[1].substring(1))+i));
	    			}else{
	    				sb.append("-"+(Integer.parseInt(beginArr[1].substring(1))+i));
	    			}
	    			
	    		}else{
	    			sb.append("-"+(Integer.parseInt(beginArr[1].substring(1))+i));
	    		}
	    		int mmMaxDate = this.getMaxdate(sb.toString());
	    		this.lockDay(sb.toString(),1,mmMaxDate,isNot);
	    	}
	    	/////////////////////////////////////////////
	    	int beginYyyy = Integer.parseInt(beginArr[0]);
	    	int endYyyy = Integer.parseInt(endArr[0]);
	    	for(int i=1;i<endYyyy-beginYyyy;i++){
	    		for(int j=1;j<=12;j++){
	    			StringBuffer sb = new StringBuffer();
	    			sb.append(Integer.parseInt(beginArr[0])+i);
	    			if(j<10){
	    				sb.append("-0"+j);
	    			}else{
	    				sb.append("-"+j);
	    			}
	    			int newMaxday = this.getMaxdate(sb.toString());
	    			this.lockDay(sb.toString(),1,newMaxday,isNot);
	    		}
	    	}
	    	//////////////////////////////
	    	//boolean flag = false;
	    	int endMm =-1;
	    	if(endArr[1].startsWith("0")){
	    		//flag = true;
	    		endMm = Integer.parseInt(endArr[1].substring(1));
	    	
	    	}else{
	    		endMm = Integer.parseInt(endArr[1]);
	    	}
	    	for(int i=1;i<endMm;i++){
	    		StringBuffer sb = new StringBuffer();
	    		sb.append(endArr[0]+"-");

	    		if(i<10){
	    			sb.append("0"+i);
	    		}else{
	    			sb.append(i);
	    		}
	    		int endMaxDay = this.getMaxdate(sb.toString());
	    		this.lockDay(sb.toString(),1,endMaxDay,isNot);
	    	}
	    	/////////////////////////////////////////
	    	int endDay = -1;
	    	if(endArr[2].startsWith("0")){
	    		endDay = Integer.parseInt(endArr[2].substring(1));
	    	}else{
	    		endDay = Integer.parseInt(endArr[2]);
	    	}
	    	this.lockDay(endtime.substring(0,endtime.lastIndexOf("-")),1,endDay,isNot);
	    }
	}
	public void priceQuerybydatenumber ()throws Exception{
		System.out.println("priceQuerybydatenumber");
		prosceniumNo=0;
		getDate=0;
		
		this.hotelName = new String(hotelName.getBytes("ISO8859-1"));
		String where =" where 1=1 and "+hotelprice.COL_datenumber+"= '"+hotelprice.getDatenumber()+"' and "+hotelprice.COL_hotelid+"="+hotelprice.getHotelid()+" and "+hotelprice.COL_roomid+"="+hotelprice.getRoomid();
		
		String roomWhere = " where 1=1 and "+Roomtype.COL_hotelid+" = "+hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(roomWhere,"ORDER BY ID",-1,0);
		
		String datenumberWhere = " where 1=1 and "+hotelprice.COL_roomid+" = "+hotelprice.getRoomid()+" and "+hotelprice.COL_hotelid+"="+hotelprice.getHotelid();
		listHotelprice = Server.getInstance().getHotelService().findAllHotelprice(datenumberWhere,"ORDER BY ID",-1,0);

		List<Hotelprice> list = Server.getInstance().getHotelService().findAllHotelprice(where,"ORDER BY ID",-1,0);
		if(list.size()!=0){
			this.hotelprice = list.get(0);
			//System.out.println(this.hotelprice);
			roomtype.setHotelid(hotelprice.getHotelid());
			Calendar cal  = Calendar.getInstance() ;
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(hotelprice.getDatenumber() + "-01")) ;
			
			showPrices = new String[cal.get(Calendar.DAY_OF_WEEK)-1 + cal.getActualMaximum(Calendar.DAY_OF_MONTH)] ;
			int count =1;
			for(int i=cal.get(Calendar.DAY_OF_WEEK)-1; i<showPrices.length; i++) {
				System.out.println("count=="+count);
				if(hotelprice.getClass().getMethod("getNo"+count).invoke(hotelprice)!=null){
				showPrices[i] = ((Double)hotelprice.getClass().getMethod("getNo"+count).invoke(hotelprice)).toString();
				count++;
				}
			}
		}
	}
	public int islock(int dayss){
		return Integer.parseInt(this.hotelprice.getIsvalid().substring(dayss-1,dayss));
	}

	public Integer getH_cityId() {
		return h_cityId;
	}

	public void setH_cityId(Integer id) {
		h_cityId = id;
	}

	public Integer getH_provinceId() {
		return h_provinceId;
	}

	public void setH_provinceId(Integer id) {
		h_provinceId = id;
	}

	public Integer getH_cityId2() {
		return h_cityId2;
	}

	public void setH_cityId2(Integer id2) {
		h_cityId2 = id2;
	}

	public Integer getCheckrad() {
		return checkrad;
	}

	public void setCheckrad(Integer checkrad) {
		this.checkrad = checkrad;
	}

	public void setListHotelprice(List listHotelprice) {
		this.listHotelprice = listHotelprice;
	}

	public String getHotelpr() {
		return hotelpr;
	}

	public void setHotelpr(String hotelpr) {
		this.hotelpr = hotelpr;
	}

	public int getLan() {
		return lan;
	}

	public void setLan(int lan) {
		this.lan = lan;
	}
	
}