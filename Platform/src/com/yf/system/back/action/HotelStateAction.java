package com.yf.system.back.action;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotellinkman.Hotellinkman;

public class HotelStateAction extends B2b2cbackAction {
	private Hotel hotel = new Hotel();
	private Long hotelId;
	private Integer hotelstate;
	private String des;
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			hotelstate = hotel.getState();
			des = hotel.getStatedesc();
			//getInstance().getHotellinkmanManager().findAllHotellinkman(where, " ORDER BY " + Hotellinkman.COL_id, -1 , 0) ;
		}		
		return SUCCESS;
	}
	/**
	 * 跳转到酒店状态页面
	 */
	
	public String toadd()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			hotelstate = hotel.getState();
			des= hotel.getStatedesc();
		}
		return SUCCESS;
	}
	/**
	 * 跳转到酒店状态修改页面
	 */
	public String toedit()throws Exception{
		hotel=Server.getInstance().getHotelService().findHotel(hotelId);
		hotelstate = hotel.getState();
		System.out.println(hotelstate);
		des= hotel.getStatedesc();
		System.out.println(des);
		return EDIT;
	}

	/**
	 * 转向到tabs
	 */		
	public String tabs()throws Exception{	
		return "tabs";
	}
	/**
	 * 转向到酒店状态审核页面
	 */	
	public String tocheck()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			hotelstate = hotel.getState();
			des = hotel.getStatedesc();
			//getInstance().getHotellinkmanManager().findAllHotellinkman(where, " ORDER BY " + Hotellinkman.COL_id, -1 , 0) ;
		}		
		
		return CHECK;
	}
	/**
	 * 转向酒店状态查看页面
	 */
	public String tolook()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			hotelstate = hotel.getState();
			des = hotel.getStatedesc();
			//getInstance().getHotellinkmanManager().findAllHotellinkman(where, " ORDER BY " + Hotellinkman.COL_id, -1 , 0) ;
		}	
		
		
		return "look";
	}
	//返回到状态页面
	public String goback()throws Exception{
		return SUCCESS;
	}
	//修改酒店状态、
	public String edit()throws Exception{
		
		String where = " where 1=1";
		if(hotelId != null) {
		//	where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			hotel=Server.getInstance().getHotelService().findHotel(hotelId);
			//hotel.setState(Integer.decode(state));
			hotel.setState(hotelstate);
			hotel.setStatedesc(des);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
			//getHotellinkmanManager().findAllHotellinkman(where, " ORDER BY " + Hotellinkman.COL_id, -1 , 0) ;
		}
		System.out.println("HotelStateAction-----hotelName::::::::"+hotel.getName());
		System.out.println("HotelStateAction-----state::::::"+hotelstate);
		System.out.println("HotelStateAction-----hotelId:::::::"+ hotelId);
		return "editsuccess";
	}
	public Object getModel() {
		// TODO Auto-generated method stub
		return hotel;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getHotelstate() {
		return hotelstate;
	}

	public void setHotelstate(Integer hotelstate) {
		this.hotelstate = hotelstate;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	

}
