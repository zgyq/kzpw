package com.yf.system.base.fflight;

import java.sql.Timestamp;
import java.util.List;
import java.io.Serializable;

public class AllFlight implements Serializable{
	//鑸彮镓€鍦ㄥ簭鍙?
	private int No;
	//鍑哄彂鍩庡竞
	private String FromCity;
	//鍒拌揪鍩庡竞
	private String DestCity;
	//鑸┖鍏徃浠ｇ爜
	private String AirCompany;
	//鍑哄彂镞ユ湡
	private String FromDate;
	//鍒拌揪镞ユ湡
	private String ToDate;
	
	private String FlightNumber;
	
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getFromCity() {
		return FromCity;
	}
	public void setFromCity(String fromCity) {
		FromCity = fromCity;
	}
	public String getDestCity() {
		return DestCity;
	}
	public void setDestCity(String destCity) {
		DestCity = destCity;
	}
	public String getAirCompany() {
		return AirCompany;
	}
	public void setAirCompany(String airCompany) {
		AirCompany = airCompany;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public String getFlightNumber() {
		return FlightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}
	
}
