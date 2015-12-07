package com.yf.system.back.action;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.yf.system.base.city.City;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.region.Region;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.back.server.Server;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

/**
 * 
 * 酒店预订Action
 * 
 */
public class HotelSubscribeAction extends B2b2cbackAction {
	// 酒店
	private Hotel hotel = new Hotel();
	// 城市名称
	private Long cityId;
	private Long incityId;
	private int checkrad;
	// 区域
	private String regionvalue;
	// 酒店位置类型
	private String regiontype;
	// 星级
	private String[] s_star;
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
	// 酒店列表
	private List<Hotel> hotelList;
	// 客房类型列表
	private Map<Long,List<Roomtype>> mapRoom = new HashMap<Long,List<Roomtype>>();
	// 国内城市列表
	private List<City> cityList = new ArrayList<City>();
	// 国际城市列表
	private List<City> incityList = new ArrayList<City>();
	// 所有星级
	//private Map<String, String> starList = new HashMap<String, String>();
	// 酒店订单操作日志列表
	private List<Hotelprice> hotelpriceList= new ArrayList<Hotelprice>();
	
	private long s_num;
	private String language;
	public HotelSubscribeAction() {
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
	//获取中国的城市
	public String getCityAirPortData() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere="WHERE 1=1 and "+City.COL_countryid+" =168";
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
				.findAllCity(strwhere, "", -1, 0);
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
	 * 获取酒店列表,
	 * 跳转至酒店列表页面
	 */
	public String execute() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		if(startDate == null) {
			startDate = sdf.format(new Date()) ;
		}
		if(endDate == null) {
			endDate = getDatestr(1) ;
		}
		
		StringBuilder where = new StringBuilder(" where C_STATE=3 ");
		
		// 查询所有的城市
		/*cityList = (List<City>)ActionContext.getContext().getSession().get("cityList");
		if(cityList == null || cityList.size() ==0) {
			cityList = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
			ActionContext.getContext().getSession().put("cityList", cityList);
		}*/
		cityList = Server.getInstance().getHotelService().findAllCity("where 1=1  and "+City.COL_countryid+" =168", "ORDER BY " + City.COL_sort, -1, 0);
		incityList = Server.getInstance().getHotelService().findAllCity("where 1=1  and "+City.COL_countryid+" !=168", "ORDER BY " + City.COL_sort, -1, 0);
		// 酒店名称
		if (null != hotelName && !"".equals(hotelName.trim())) {
			where.append(" and C_NAME like '%");
			where.append(hotelName.trim());
			where.append("%' ");
		}

		// 酒店所在城市
		if(checkrad==1){
			if( cityId != null && cityId > 0) {
				where.append(" and C_CITYID =").append(cityId);
			}
		}
		if(checkrad==2){
				if( incityId != null && incityId > 0) {
					where.append(" and C_CITYID =").append(incityId);
				}
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
		where.append(",").append(s_num).append(")) =0 )");
								//没用....
								// where.append(" and INSTR(SUBSTR(C_ISVALID,");
								// where.append(Integer.parseInt(s_startdate.substring(8,10)));
								// where.append(",");
								// where.append(s_num).append("),'1') != 0");
					
								// substring(convert(varchar,C_STARTDATE,23),1,10) > '2009-09-02'
								//没用...
	//		where.append(" and C_ROOMID not in " +
	//					"( select C_ROOMTYPEID from "+Roomstate.TABLE+" " +
	//							"where C_STATE = 2 and substring(convert(varchar,C_STARTDATE,23),1,10)<= '");
	//		where.append(startDate);
	//		where.append("' or substring(convert(varchar,C_ENDDATE,23),1,10) >= '");
	//		where.append(endDate);
	//		where.append("') and C_ROOMID in (select ID from "+Roomtype.TABLE+" where C_STATE=1) )");
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
		/*
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
		}*/
		System.out.println("where=="+where.toString());
		pageinfo.setPagerow(10);
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
			List<Roomtype> li = Server.getInstance().getHotelService().findAllRoomtype(wh.toString(),"  ORDER BY ID ",-1,0);
			mapRoom.put(new Long(id),li);
		}

		return SUCCESS;
	}

	/**
	 * 跳转至酒店详细信息页面
	 * @return
	 * @throws Exception
	 */
	public String toDetail() throws Exception {
		hotel = Server.getInstance().getHotelService().findHotel(Long.valueOf(hotel.getId())) ;
		setMapRoom(hotel.getId());
		return "detail";
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
     		Double salesroomPrice = 0d ; //门市价
     		Double firstdayPrice = 0d ; //首日价 
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
    		Double priceSum = new Double(0) ;
    		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
    			daynum ++ ;
    			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
    			//是否设置值
    			Double priceValue = 0d ;
    			isbid = false ;
    			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
    				Hotelprice price = iterator.next() ;
    				if(price.getDeptprice() != null) {
    					salesroomPrice = Double.parseDouble(price.getDeptprice()) ;
    				}
    				if(price.getDatenumber().equals(comeStr)) {
    					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
    					priceValue = (Double)method.invoke(price, new Object[]{}) ;
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
         /*	String where2 = " WHERE " + Roomstate.COL_roomtypeid + "=" + roomtype.getId() ;
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
			}*/
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
	
	/**
	 * 根据酒店ID获取对应图片路径
	 * @param hotelid
	 * @return  图片路径
	 */
	public String getImage(String hotelid) {
		List<Hotelimage> listImages = Server.getInstance().getHotelService().findAllHotelimage(" WHERE " 
				+ Hotelimage.COL_hotelid + "=" + hotelid + " AND " + Hotelimage.COL_type + "=1", " ORDER BY " +Hotelimage.COL_id, -1, 0) ;
		if(listImages.size() > 0) {
			return listImages.get(0).getPath() ;
		}
		return "" ;
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
					return ((Double)o).intValue();
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
	public long getS_num() {
		return s_num;
	}
	public void setS_num(long s_num) {
		this.s_num = s_num;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<City> getIncityList() {
		return incityList;
	}
	public void setIncityList(List<City> incityList) {
		this.incityList = incityList;
	}
	public Long getIncityId() {
		return incityId;
	}
	public void setIncityId(Long incityId) {
		this.incityId = incityId;
	}
	public int getCheckrad() {
		return checkrad;
	}
	public void setCheckrad(int checkrad) {
		this.checkrad = checkrad;
	}
}
