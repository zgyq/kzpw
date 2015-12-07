package com.yf.system.base.interflightinfo;

import java.io.Serializable;

public class InterPrice implements Serializable{
	// 运价ID
	private String Pid;
	// 航程序号
	private String Fxuhao;
	// 航程班期
	private String Banqi;
	// 票价客票类
	private String TicketType;
	// 票价
	private String Price;
	// 基建(税)
	private String AirPrice;
	// 燃油
	private String FuelFee;
	// OFFICE
	private String Office;
	// 价格路由
	private String Priceinfo;
	
	// 携程价格
	private String xcprice;
	// 航司价格
	private String hsprice;
	// 航司结算价
	private String hsjsprice;
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getFxuhao() {
		return Fxuhao;
	}
	public void setFxuhao(String fxuhao) {
		Fxuhao = fxuhao;
	}
	public String getBanqi() {
		return Banqi;
	}
	public void setBanqi(String banqi) {
		Banqi = banqi;
	}
	public String getTicketType() {
		return TicketType;
	}
	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getAirPrice() {
		return AirPrice;
	}
	public void setAirPrice(String airPrice) {
		AirPrice = airPrice;
	}
	public String getFuelFee() {
		return FuelFee;
	}
	public void setFuelFee(String fuelFee) {
		FuelFee = fuelFee;
	}
	public String getOffice() {
		return Office;
	}
	public void setOffice(String office) {
		Office = office;
	}
	public String getPriceinfo() {
		return Priceinfo;
	}
	public void setPriceinfo(String priceinfo) {
		Priceinfo = priceinfo;
	}
	public String getXcprice() {
		return xcprice;
	}
	public void setXcprice(String xcprice) {
		this.xcprice = xcprice;
	}
	public String getHsprice() {
		return hsprice;
	}
	public void setHsprice(String hsprice) {
		this.hsprice = hsprice;
	}
	public String getHsjsprice() {
		return hsjsprice;
	}
	public void setHsjsprice(String hsjsprice) {
		this.hsjsprice = hsjsprice;
	}
	
}
