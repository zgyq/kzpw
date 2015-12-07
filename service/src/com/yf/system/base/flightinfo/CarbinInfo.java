package com.yf.system.base.flightinfo;

import java.io.Serializable;

public class CarbinInfo implements Serializable{
	// 仓位码
	private String Cabin;
	// 坐位数
	private String SeatNum;
	// 是否特价
	private boolean IsSpecial;
	// 价格
	private Float Price;
	// 折扣
	private Float Discount;
	// 级别
	private Integer Level;

	// 仓位规定
	private String CabinRules;

	// 仓位说明
	private String CabinRemark;
	//返点
	private Float ratevalue;
	//政策id
	private Long zrateid;
	//仓位名称
	private String cabintypename;

	public Float getRatevalue() {
		return ratevalue;
	}

	public void setRatevalue(Float ratevalue) {
		this.ratevalue = ratevalue;
	}

	public String getCabin() {
		return Cabin;
	}

	public void setCabin(String cabin) {
		Cabin = cabin;
	}

	public String getSeatNum() {
		return SeatNum;
	}

	public void setSeatNum(String seatNum) {
		SeatNum = seatNum;
	}

	public boolean isSpecial() {
		return IsSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		IsSpecial = isSpecial;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public Float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
	}

	public Integer getLevel() {
		return Level;
	}

	public void setLevel(Integer level) {
		Level = level;
	}

	public String getCabinRules() {
		return CabinRules;
	}

	public void setCabinRules(String cabinRules) {
		CabinRules = cabinRules;
	}

	public String getCabinRemark() {
		return CabinRemark;
	}

	public void setCabinRemark(String cabinRemark) {
		CabinRemark = cabinRemark;
	}

	public Long getZrateid() {
		return zrateid;
	}

	public void setZrateid(Long zrateid) {
		this.zrateid = zrateid;
	}

	public String getCabintypename() {
		return cabintypename;
	}

	public void setCabintypename(String cabintypename) {
		this.cabintypename = cabintypename;
	}

	
	
}
