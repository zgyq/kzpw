package com.yf.system.base.fflight;

import java.sql.Timestamp;
import java.util.List;
import java.io.Serializable;

public class Route implements Serializable{
	//鑸彮绾胯矾搴忓佛
	private int ID;
	//鏀跨瓥绫诲瀷镙囱瘑 鏆傛椂镞犵敤锛屽彧鏄笅璁㈠崟镞舵彃鍏ュ埌鏁版嵁搴扑腑
	private String PolicyInfo;
	//镐婚噾棰?
	private double TotalFare;
	//镐荤◣璐?
	private double TotalTax;
	//鏀跨瓥绫诲瀷镙囱瘑 鏆傛椂镞犵敤锛屽彧鏄笅璁㈠崟镞舵彃鍏ュ埌鏁版嵁搴扑腑
	private String PolicyMark;
	//鍑哄彂鍩庡竞
	private String FromCity;
	//鍒拌揪鍩庡竞
	private String DestCity;
	//鑸┖鍏徃浠ｇ爜
	private String AirCompany;
	//鑸彮绾胯矾 濡傦细BJS-HKG-SFO
	private String RouteStr;
	//是否转机
	private int IsChangeFlight;
	
	//儿童票价
	private double TotalChlidFare;
	
	private String DepdateTime;//出发时间
	
	private String ArrdateTime;//到达时间
	
	
	//鑸彮绾胯矾璇︽儏
	private List<RouteDetailInfo> RouteDetailInfos;
	
	
	public String getDepdateTime() {
		return DepdateTime;
	}
	public void setDepdateTime(String depdateTime) {
		DepdateTime = depdateTime;
	}
	public String getArrdateTime() {
		return ArrdateTime;
	}
	public void setArrdateTime(String arrdateTime) {
		ArrdateTime = arrdateTime;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getPolicyInfo() {
		return PolicyInfo;
	}
	public void setPolicyInfo(String policyInfo) {
		PolicyInfo = policyInfo;
	}
	public double getTotalFare() {
		return TotalFare;
	}
	public void setTotalFare(double totalFare) {
		TotalFare = totalFare;
	}
	public double getTotalTax() {
		return TotalTax;
	}
	public void setTotalTax(double totalTax) {
		TotalTax = totalTax;
	}
	public String getPolicyMark() {
		return PolicyMark;
	}
	public void setPolicyMark(String policyMark) {
		PolicyMark = policyMark;
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
	public String getRouteStr() {
		return RouteStr;
	}
	public void setRouteStr(String routeStr) {
		RouteStr = routeStr;
	}
	public List<RouteDetailInfo> getRouteDetailInfos() {
		return RouteDetailInfos;
	}
	public void setRouteDetailInfos(List<RouteDetailInfo> routeDetailInfos) {
		RouteDetailInfos = routeDetailInfos;
	}
	public int getIsChangeFlight() {
		return IsChangeFlight;
	}
	public void setIsChangeFlight(int isChangeFlight) {
		IsChangeFlight = isChangeFlight;
	}
	public double getTotalChlidFare() {
		return TotalChlidFare;
	}
	public void setTotalChlidFare(double totalChlidFare) {
		TotalChlidFare = totalChlidFare;
	}
	
}
