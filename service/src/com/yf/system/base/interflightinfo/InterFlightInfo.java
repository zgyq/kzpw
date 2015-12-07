package com.yf.system.base.interflightinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InterFlightInfo implements Serializable{
	private String ftype;//航程类型  1直飞   2中转
	
	// 起飞机场
	private String StartAirport;
	// 起飞起场名称
	private String StartAirportName;

	// 到达机场
	private String EndAirport;

	// 到达机场名称
	private String EndAirportName;
	
	// 航空公司
	private String AirCompany;
	// 航空公司名称
	private String AirCompanyName;
	
	
	// 出发时间
	private String Statrday;
	
	
	//航班组合
	private List<InterFlight> FlightInfos = new ArrayList<InterFlight>();
	//价格组合
	private List<InterPrice> interPricelist = new ArrayList<InterPrice>();
	//价格信息
	private InterPrice interPrice=new InterPrice();
	
	//最低仓位
	private InterCarbinInfo LowCarbin;

	public List<InterFlight> getFlightInfos() {
		return FlightInfos;
	}

	public void setFlightInfos(List<InterFlight> flightInfos) {
		FlightInfos = flightInfos;
	}

	public InterCarbinInfo getLowCarbin() {
		return LowCarbin;
	}

	public void setLowCarbin(InterCarbinInfo lowCarbin) {
		LowCarbin = lowCarbin;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getStartAirport() {
		return StartAirport;
	}

	public void setStartAirport(String startAirport) {
		StartAirport = startAirport;
	}

	public String getStartAirportName() {
		return StartAirportName;
	}

	public void setStartAirportName(String startAirportName) {
		StartAirportName = startAirportName;
	}

	public String getEndAirport() {
		return EndAirport;
	}

	public void setEndAirport(String endAirport) {
		EndAirport = endAirport;
	}

	public String getEndAirportName() {
		return EndAirportName;
	}

	public void setEndAirportName(String endAirportName) {
		EndAirportName = endAirportName;
	}

	public String getAirCompany() {
		return AirCompany;
	}

	public void setAirCompany(String airCompany) {
		AirCompany = airCompany;
	}

	public String getAirCompanyName() {
		return AirCompanyName;
	}

	public void setAirCompanyName(String airCompanyName) {
		AirCompanyName = airCompanyName;
	}

	public String getStatrday() {
		return Statrday;
	}

	public void setStatrday(String statrday) {
		Statrday = statrday;
	}

	public InterPrice getInterPrice() {
		return interPrice;
	}

	public void setInterPrice(InterPrice interPrice) {
		this.interPrice = interPrice;
	}

	public List<InterPrice> getInterPricelist() {
		return interPricelist;
	}

	public void setInterPricelist(List<InterPrice> interPricelist) {
		this.interPricelist = interPricelist;
	}

	
	
}
