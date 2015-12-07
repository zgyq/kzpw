package com.yf.system.base.fflight;

import java.sql.Timestamp;
import java.util.List;
import java.io.Serializable;

public class RouteDetailInfo implements Serializable{
	//鍑哄彂鍩庡竞浠ｇ爜
	private String FromCity;
	//鍒拌揪鍩庡竞浠ｇ爜
	private String DestCity;
	//鑸┖鍏徃浠ｇ爜
	private String AirCompany;
	//鑸变綅镰?
	private String Cabin;
	//鍑哄彂链哄満
	private String FromAirport;
	//鍒拌揪链哄満
	private String ToAirport;
	//鍑哄彂镞ユ湡
	private String FromDate;
	//鍒拌揪镞ユ湡
	private String ToDate;
	//鑸彮鍙?
	private String FlightNumber;
	//鍏辨湁澶氩皯鑸彮
	private int TotalFlightNo;
	
	private String FlyTime;//飞行时长
	
	private String Plane;//飞机型号
	
	private List<AllFlight> FlightInfos;

	
	public String getFlyTime() {
		return FlyTime;
	}

	public void setFlyTime(String flyTime) {
		FlyTime = flyTime;
	}

	public String getPlane() {
		return Plane;
	}

	public void setPlane(String plane) {
		Plane = plane;
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

	public String getCabin() {
		return Cabin;
	}

	public void setCabin(String cabin) {
		Cabin = cabin;
	}

	public String getFromAirport() {
		return FromAirport;
	}

	public void setFromAirport(String fromAirport) {
		FromAirport = fromAirport;
	}

	public String getToAirport() {
		return ToAirport;
	}

	public void setToAirport(String toAirport) {
		ToAirport = toAirport;
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

	public int getTotalFlightNo() {
		return TotalFlightNo;
	}

	public void setTotalFlightNo(int totalFlightNo) {
		TotalFlightNo = totalFlightNo;
	}

	public List<AllFlight> getFlightInfos() {
		return FlightInfos;
	}

	public void setFlightInfos(List<AllFlight> flightInfos) {
		FlightInfos = flightInfos;
	}
	
}
