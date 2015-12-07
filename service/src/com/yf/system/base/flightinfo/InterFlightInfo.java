package com.yf.system.base.flightinfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.Serializable;

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
	
	
	
	private List<FlightInfo> FlightInfos = new ArrayList<FlightInfo>();
	private CarbinInfo LowCarbin;

	public List<FlightInfo> getFlightInfos() {
		return FlightInfos;
	}

	public void setFlightInfos(List<FlightInfo> flightInfos) {
		FlightInfos = flightInfos;
	}

	public CarbinInfo getLowCarbin() {
		return LowCarbin;
	}

	public void setLowCarbin(CarbinInfo lowCarbin) {
		LowCarbin = lowCarbin;
	}

	
	
}
