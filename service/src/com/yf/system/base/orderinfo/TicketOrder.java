package com.yf.system.base.orderinfo;

import java.util.List;

import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;

public class TicketOrder implements java.io.Serializable{
	public String code;
	public Orderinfo orderinfo;
	public List<Passenger> listPassenger;
	public List<Segmentinfo> listSegmentinfo;
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	public List<Passenger> getListPassenger() {
		return listPassenger;
	}
	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}
	public List<Segmentinfo> getListSegmentinfo() {
		return listSegmentinfo;
	}
	public void setListSegmentinfo(List<Segmentinfo> listSegmentinfo) {
		this.listSegmentinfo = listSegmentinfo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
