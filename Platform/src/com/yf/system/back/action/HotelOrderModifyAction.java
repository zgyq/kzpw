/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.roomtype.Roomtype;

public class HotelOrderModifyAction extends HotelorderAction {

	private List <Hotelorderrc> listHotelorderrc ;
	private List <Roomtype> listRoomtype ;
	private List <Guest> listGuest ;
	private Hotelorder hotelorder = new Hotelorder();
	private Hotel hotel = new Hotel() ;
	
	//酒店城市
	private Integer h_hotelCityId ; 
	
	//订单号
	private String h_orderId ;
	
	//联系人姓名
	private String h_linkname ;
	
	//联系人手机
	private String h_linkmobile ;
	
	//预订的开始时间
	private String h_prestarttime ;
	
	//预订的结束时间
	private String h_preendtime ;
	
	//是否是酒店的英文名
	private Integer h_isEnglishName ;
	
	//酒店名称
	private String h_hotelName ;
	
	//入住日期
	private String h_comedate_edit ;
	
	//离店日期
	private String h_leavedate_edit ;
	
	//保留的开始时间
	private String h_savestarttime_edit ;
	
	//保留结束的时间
	private String h_saveendtime_edit ;
	
	//入住人
	private String[] h_guest_edit ;
	
	//房型的id
	private Long h_roomid_edit ;

	//要跳转的页面
	private String forwardall ;
	
	//重定向
	private String forward ;

	/**
	 * 转向到酒店订单修改页面
	 */	
	public String toedit()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId());
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" WHERE " + Roomtype.COL_hotelid 
				+ "=" + hotelorder.getHotelid(), "", -1, 0) ;
		listGuest = Server.getInstance().getHotelService().findAllGuest(" WHERE " + Guest.COL_orderid + "=" + hotelorder.getId()
				, "", -1, 0) ;
		return EDIT;
	}
	

	/**
	 * 编辑酒店订单
	 */		
	/**
	 * @return
	 * @throws Exception
	 */
	public String edit()throws Exception{
		//设置入住日期和离店日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		hotelorder.setComedate(new Timestamp(sdf.parse(h_comedate_edit).getTime())) ;
		hotelorder.setLeavedate(new Timestamp(sdf.parse(h_leavedate_edit).getTime())) ;
		//设置保留时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
		hotelorder.setReservstart(h_savestarttime_edit) ;
		hotelorder.setReservend(h_saveendtime_edit) ;
		List<Guest> guests = new ArrayList<Guest>() ;
		//设置入住人
		if(h_guest_edit != null) {
			for(String guest : h_guest_edit) {
				Guest gbak = new Guest() ;
				gbak.setName(guest) ;
				guests.add(gbak) ;
			}
		}
		hotelorder.setGuests(guests) ;
		hotelorder.setOpsername(this.getLoginUser().getLoginname()) ;
		hotelorder.setOpmobile(this.getLoginUser().getMobile()) ;
		Server.getInstance().getHotelService().updateHotelorder(hotelorder) ;
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId()) ;
//		try {
//			hotelorder = (Hotelorder) Server.getInstance().getHotelorderManager().findAllHotelorder("WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() 
//					+ "'", "ORDER BY " + Hotelorder.COL_id + " DESC", -1, 0).get(0) ;
//			Server.getInstance().getAtomServiceProject().sendModifyOrderFax(hotelorder, hotel) ;
//		} catch(Exception e) {
//			hotelorder.setResultcode(new Integer(1)) ;
//			Server.getInstance().getHotelorderManager().updateHotelorderIgnoreNull(hotelorder) ;
//		}
		if(forwardall != null && "whole".equals(forwardall.trim())) {
			forward = "hotelwholeorder.action?h_hotelCityId=" + h_hotelCityId + "&h_orderId=" + h_orderId +
			"&h_linkname=" + this.getUrlEncode(this.getUrlEncode(h_linkname)) + "&h_linkmobile=" + h_linkmobile +
			"&h_prestarttime=" + h_prestarttime + "&h_preendtime=" + h_preendtime + "&h_hotelName=" + 
			this.getUrlEncode(this.getUrlEncode(h_hotelName)) + "&h_isEnglishName=" + h_isEnglishName + "&h_type=ce&" + getUrl();
		} else {
			forward = "hotelnoauditingorder.action?h_hotelCityId=" + h_hotelCityId + "&h_orderId=" + h_orderId +
				"&h_linkname=" + this.getUrlEncode(this.getUrlEncode(h_linkname)) + "&h_linkmobile=" + h_linkmobile +
				"&h_prestarttime=" + h_prestarttime + "&h_preendtime=" + h_preendtime + "&h_hotelName=" + 
				this.getUrlEncode(this.getUrlEncode(h_hotelName)) + "&h_isEnglishName=" + h_isEnglishName + "&h_type=ce&" + getUrl();
		}
		return LIST ;
	}


	/**
	 * 根据房型 入住日期 和离店日期得到价格
	 * @return
	 */
	public String getEditPrices() throws Exception {
		//判断酒店是否上网
		Hotel hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		if(hotel.getState().intValue() == 4) {
			this.addActionError("该酒店已经下网不能在更改") ;
		} else if(hotel.getState().intValue() == 2) {
			this.addActionError("该酒店正在审核中") ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar comeCal = Calendar.getInstance() ;
		comeCal.setTime(sdf.parse(h_comedate_edit)) ;
		Calendar leaveCal = Calendar.getInstance() ;
		leaveCal.setTime(sdf.parse(h_leavedate_edit)) ;
		String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
				"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
				"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
		String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
			comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
			"=" + hotelorder.getRoomid() ;
		List<Hotelprice> prices = Server.getInstance().getHotelService().findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
		StringBuffer buf = new StringBuffer("") ;
		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
			//是否设置值
			Float priceValue = 0f ;
			//是否被禁用
			boolean isbid = false ;
			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
				Hotelprice price = iterator.next() ;
				if(price.getDatenumber().equals(comeStr)) {
					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
					priceValue = (Float)method.invoke(price, new Object[]{}) ;
					if(price.getIsvalid().charAt(day-1) == '1') {
						isbid = true ;
					}
					break ;
				}
			}
			if(priceValue == 0 || isbid) {
				this.addActionError("在"+h_comedate_edit + "到" + h_leavedate_edit + "之间的价格不存在或者被禁用") ;
				buf = new StringBuffer("") ;
				break ;
			}
			buf.append(priceValue + "|") ;
			comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
			comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		}
		Hotelorder hotelorderBak = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId()) ;
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" WHERE " + Roomtype.COL_hotelid 
				+ "=" + hotelorder.getHotelid(), "", -1, 0) ;
		listGuest = Server.getInstance().getHotelService().findAllGuest(" WHERE " + Guest.COL_orderid + "=" + hotelorder.getId()
				, "", -1, 0) ;
		if(buf.length() > 0) {
			hotelorderBak.setPrice(buf.substring(0, buf.length()-1)) ;
		} else {
			hotelorderBak.setPrice(buf.toString()) ;
		}
		hotelorderBak.setComedate(new Timestamp(sdf.parse(h_comedate_edit).getTime())) ;
		hotelorderBak.setLeavedate(new Timestamp(leaveCal.getTimeInMillis())) ;
		hotelorderBak.setRoomid(hotelorder.getRoomid()) ;
		hotelorderBak.setRoomtypename(Server.getInstance().getHotelService().findRoomtype(hotelorder.getRoomid()).getName()) ;
		hotelorderBak.setPrerooms(hotelorder.getPrerooms()) ;
		hotelorder = hotelorderBak ;
		return EDIT ;
	}


	/**
	 *  返回酒店订单对象
	 */		
	
	public Object getModel() {
		return hotelorder;
	}
	
	public Hotelorder getHotelorder() {
		return hotelorder;
	}
	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
	}
	

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getForwardall() {
		return forwardall;
	}

	public void setForwardall(String forwardall) {
		this.forwardall = forwardall;
	}

	public List<Hotelorderrc> getListHotelorderrc() {
		return listHotelorderrc;
	}

	public void setListHotelorderrc(List<Hotelorderrc> listHotelorderrc) {
		this.listHotelorderrc = listHotelorderrc;
	}

	public List<Roomtype> getListRoomtype() {
		return listRoomtype;
	}

	public void setListRoomtype(List<Roomtype> listRoomtype) {
		this.listRoomtype = listRoomtype;
	}


	public List<Guest> getListGuest() {
		return listGuest;
	}


	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}


	public String getH_comedate_edit() {
		return h_comedate_edit;
	}


	public void setH_comedate_edit(String h_comedate_edit) {
		this.h_comedate_edit = h_comedate_edit;
	}


	public String[] getH_guest_edit() {
		return h_guest_edit;
	}


	public void setH_guest_edit(String[] h_guest_edit) {
		this.h_guest_edit = h_guest_edit;
	}


	public String getH_leavedate_edit() {
		return h_leavedate_edit;
	}


	public void setH_leavedate_edit(String h_leavedate_edit) {
		this.h_leavedate_edit = h_leavedate_edit;
	}


	public Long getH_roomid_edit() {
		return h_roomid_edit;
	}


	public void setH_roomid_edit(Long h_roomid_edit) {
		this.h_roomid_edit = h_roomid_edit;
	}


	public String getH_saveendtime_edit() {
		return h_saveendtime_edit;
	}


	public void setH_saveendtime_edit(String h_saveendtime_edit) {
		this.h_saveendtime_edit = h_saveendtime_edit;
	}


	public String getH_savestarttime_edit() {
		return h_savestarttime_edit;
	}


	public void setH_savestarttime_edit(String h_savestarttime_edit) {
		this.h_savestarttime_edit = h_savestarttime_edit;
	}


	public String getForward() {
		return forward;
	}


	public void setForward(String forward) {
		this.forward = forward;
	}


	public Integer getH_hotelCityId() {
		return h_hotelCityId;
	}


	public void setH_hotelCityId(Integer cityId) {
		h_hotelCityId = cityId;
	}


	public String getH_hotelName() {
		return h_hotelName;
	}


	public void setH_hotelName(String name) {
		h_hotelName = name;
	}


	public Integer getH_isEnglishName() {
		return h_isEnglishName;
	}


	public void setH_isEnglishName(Integer englishName) {
		h_isEnglishName = englishName;
	}


	public String getH_linkmobile() {
		return h_linkmobile;
	}


	public void setH_linkmobile(String h_linkmobile) {
		this.h_linkmobile = h_linkmobile;
	}


	public String getH_linkname() {
		return h_linkname;
	}


	public void setH_linkname(String h_linkname) {
		this.h_linkname = h_linkname;
	}


	public String getH_orderId() {
		return h_orderId;
	}


	public void setH_orderId(String id) {
		h_orderId = id;
	}


	public String getH_preendtime() {
		return h_preendtime;
	}


	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}


	public String getH_prestarttime() {
		return h_prestarttime;
	}


	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}


}