package com.yf.system.base.interflightinfo;

public class InterFlightSearch implements java.io.Serializable
 {
	 private static final long serialVersionUID = 3224332633725166982L;
	    //所有实现Serializable接口的类都需要增加　serialVersionUID

	// 起飞机场
	private String StartAirportCode;
	// 到达机场
	private String EndAirportCode;
	// 第三机场
	private String ThirdAirportCode;
	//出发日期
	private String FromDate;
	//出发时间
	private String FromTime;
	//航程类型
	private String TravelType;
	//返程日期
	private String BackDate;
	//航空公司代码
	private String AirCompanyCode;
	//航程
	private String TypeFlag;
	//中转类型  0所有  1直飞  2非直飞  
	private String TransferType;
	//舱等：经济舱Economy/超级经济舱Premium/商务舱Business/头等舱First  
	private String CabinClass;
	
	
	private String StartAirPortName;
	private String EndAirPortName;
	
	//排序类型  Price,DepartureTime,ArrivalTime,FlightDuration
	private String SortingField;
	//排序顺序  ASC,DESC
	private String Direction;//
	
	public String getTypeFlag() {
		return TypeFlag;
	}
	public void setTypeFlag(String typeFlag) {
		TypeFlag = typeFlag;
	}
	public String getStartAirportCode() {
		return StartAirportCode;
	}
	public void setStartAirportCode(String startAirportCode) {
		StartAirportCode	 = startAirportCode;
	}

	public String getEndAirportCode()
	{
		return EndAirportCode;
	}
	public void setEndAirportCode(String endAirportCode)
	{
		EndAirportCode=endAirportCode;
	}
	
	public String getFromDate()
	{
		return FromDate;
	}
	public void setFromDate(String fromDate)
	{
	    	FromDate=fromDate;
	}
	
	public String getFromTime(){
		return FromTime;
	}
	public void setFromTime(String fromTime)
	{
		FromTime=fromTime;
	}
	
	public String getTravelType()
	{
		return TravelType;
	}
	public void setTravelType(String travelType)
	{
		TravelType=travelType;
	}
	
	public String getBackDate()
	{
		return BackDate;
	}
	public void setBackDate(String backDate)
	{
		BackDate=backDate;
	}
	
	public String getAirCompanyCode()
	{
		return  AirCompanyCode;
	}
	public void setAirCompanyCode(String airCompanyCode)
	{
		AirCompanyCode=airCompanyCode;
	}
	public String getStartAirPortName() {
		return StartAirPortName;
	}
	public void setStartAirPortName(String startAirPortName) {
		StartAirPortName = startAirPortName;
	}
	public String getEndAirPortName() {
		return EndAirPortName;
	}
	public void setEndAirPortName(String endAirPortName) {
		EndAirPortName = endAirPortName;
	}
	public String getThirdAirportCode() {
		return ThirdAirportCode;
	}
	public void setThirdAirportCode(String thirdAirportCode) {
		ThirdAirportCode = thirdAirportCode;
	}
	public String getTransferType() {
		return TransferType;
	}
	public void setTransferType(String transferType) {
		TransferType = transferType;
	}
	public String getCabinClass() {
		return CabinClass;
	}
	public void setCabinClass(String cabinClass) {
		CabinClass = cabinClass;
	}
	public String getSortingField() {
		return SortingField;
	}
	public void setSortingField(String sortingField) {
		SortingField = sortingField;
	}
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}

}
