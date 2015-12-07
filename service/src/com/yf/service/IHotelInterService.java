package com.yf.service;

import java.util.List;

import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelinter.SeachHotelBean;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.roomtype.Roomtype;

public interface IHotelInterService {

	//创建酒店订单
	public String CreateHotelOrder(Hotelorder hotelorder,List<Guest> ListGuest);
	
	//查询订单状态
	public String SerchHotelOrderStaus(Hotelorder hotelorder);
	
	
	//查询单个房型价格和状态
	public SeachHotelBean SerchHotelOneRoomAndPriceByHotelIDAndRoomID(Hotel hot,Roomtype roomtype,String stime,String endtime);
	
	//取消订单
	public String  CancelHotelOrder(Hotelorder hotelorder);
	
	//单个订单详细信息查询
	
	public Hotelorder SerchHotelInfo(Hotelorder hotelorder);
	
	//查询酒店所有房型价格和状态
	public SeachHotelBean SerchHotelAllRoomAndPriceByHotelID(Hotel hot,String stime,String endtime,String Roomcode);
	
	public String validateHotelIsBook(Hotelorder hotelorder,List<Guest> ListGuest);
	
	//验证信用卡
	public String validateCreditcard(String CredNO);//-1表示不可用  0表示要CVV  1表示不要CVV
}
