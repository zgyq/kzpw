package com.yf.system.base.hotelinter;

import java.io.Serializable;
import java.util.List;

import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.Roomtype;

public class SeachHotelBean implements Serializable,Comparable {

	public String Status;//状态
	
	public Hotel hotel;//酒店
	
	public List<Hotelprice>ListHotelprice;//价格
	
	public List<Roomtype>ListRoomtype;//房型
	
	public List<Roomstateback>ListRoomstateback;//房态
	
	public List<BookingRules>ListBookingRules;//预订规则
	public List<GuaranteeRule>ListGuaranteeRule;//担保规则
	public List<PrepayRule>ListPrepayRule;//预付规则
	
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Hotelprice> getListHotelprice() {
		return ListHotelprice;
	}

	public void setListHotelprice(List<Hotelprice> listHotelprice) {
		ListHotelprice = listHotelprice;
	}

	public List<Roomtype> getListRoomtype() {
		return ListRoomtype;
	}

	public void setListRoomtype(List<Roomtype> listRoomtype) {
		ListRoomtype = listRoomtype;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Roomstateback> getListRoomstateback() {
		return ListRoomstateback;
	}

	public void setListRoomstateback(List<Roomstateback> listRoomstateback) {
		ListRoomstateback = listRoomstateback;
	}

	public List<BookingRules> getListBookingRules() {
		return ListBookingRules;
	}

	public void setListBookingRules(List<BookingRules> listBookingRules) {
		ListBookingRules = listBookingRules;
	}

	public List<GuaranteeRule> getListGuaranteeRule() {
		return ListGuaranteeRule;
	}

	public void setListGuaranteeRule(List<GuaranteeRule> listGuaranteeRule) {
		ListGuaranteeRule = listGuaranteeRule;
	}

	public List<PrepayRule> getListPrepayRule() {
		return ListPrepayRule;
	}

	public void setListPrepayRule(List<PrepayRule> listPrepayRule) {
		ListPrepayRule = listPrepayRule;
	}
	
	
	
	
	
	
	
}
