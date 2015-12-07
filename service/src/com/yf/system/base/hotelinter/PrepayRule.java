package com.yf.system.base.hotelinter;

import java.io.Serializable;

public class PrepayRule implements Serializable,Comparable{
	public	String hotelid;//对应酒店id
	
	public	String hotelcode;//对应酒店编号
	
	
	public	String PrepayRuleId;//规则编号
	
	public	String Description;//规则描述
	
	public	String DateType;//日期类型 CheckInDay-入住日期
	
	public	String StartDate;//开始日期
	
	public	String EndDate;//结束日期
	
	public	String WeekSet;//周有效天数， 一般为周一到周日都有效， 判断日期符合日期段同时也要满足周设置的有效 周一对应为1，周二对应为2， 依次类推;逗号分隔
	
	
	public	String ChangeRule;// 变更规则  
	//PrepayNoChange：不允许变更取消，
	//PrepayNeedSomeDay：允许变更/取消,在到店日24点之前N个小时，
	//PrepayNeedOneTime：允许变更/取消,在约定日
	public	String CashScaleFirstAfter;// 时间点后扣款类型  Money：金额  Percent：比例   FristNight：首晚
	public	String CashScaleFirstBefore;// 时间点前扣款类型  Money：金额  Percent：比例   FristNight：首晚
	public	String DateNum;// 具体取消时间日期部分
	
	public	String Time;// 具体取消时间小时部分
	
	public	String DeductFeesAfter;// 在变更时间点后是否扣费
	public	String DeductFeesBefore;// 在变更时间点前是否扣费
	public	String DeductNumAfter;// 时间点后扣费的金额或比例
	public	String DeductNumBefore;// 时间点前扣费的金额或比例
	public	String Hour;// 第一阶段提前几小时
	public	String Hour2;// 第二阶段提前几小时
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getHotelid() {
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelcode() {
		return hotelcode;
	}

	public void setHotelcode(String hotelcode) {
		this.hotelcode = hotelcode;
	}

	public String getPrepayRuleId() {
		return PrepayRuleId;
	}

	public void setPrepayRuleId(String prepayRuleId) {
		PrepayRuleId = prepayRuleId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDateType() {
		return DateType;
	}

	public void setDateType(String dateType) {
		DateType = dateType;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getWeekSet() {
		return WeekSet;
	}

	public void setWeekSet(String weekSet) {
		WeekSet = weekSet;
	}

	public String getChangeRule() {
		return ChangeRule;
	}

	public void setChangeRule(String changeRule) {
		ChangeRule = changeRule;
	}

	public String getCashScaleFirstAfter() {
		return CashScaleFirstAfter;
	}

	public void setCashScaleFirstAfter(String cashScaleFirstAfter) {
		CashScaleFirstAfter = cashScaleFirstAfter;
	}

	public String getCashScaleFirstBefore() {
		return CashScaleFirstBefore;
	}

	public void setCashScaleFirstBefore(String cashScaleFirstBefore) {
		CashScaleFirstBefore = cashScaleFirstBefore;
	}

	public String getDateNum() {
		return DateNum;
	}

	public void setDateNum(String dateNum) {
		DateNum = dateNum;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDeductFeesAfter() {
		return DeductFeesAfter;
	}

	public void setDeductFeesAfter(String deductFeesAfter) {
		DeductFeesAfter = deductFeesAfter;
	}

	public String getDeductFeesBefore() {
		return DeductFeesBefore;
	}

	public void setDeductFeesBefore(String deductFeesBefore) {
		DeductFeesBefore = deductFeesBefore;
	}

	public String getDeductNumAfter() {
		return DeductNumAfter;
	}

	public void setDeductNumAfter(String deductNumAfter) {
		DeductNumAfter = deductNumAfter;
	}

	public String getDeductNumBefore() {
		return DeductNumBefore;
	}

	public void setDeductNumBefore(String deductNumBefore) {
		DeductNumBefore = deductNumBefore;
	}

	public String getHour() {
		return Hour;
	}

	public void setHour(String hour) {
		Hour = hour;
	}

	public String getHour2() {
		return Hour2;
	}

	public void setHour2(String hour2) {
		Hour2 = hour2;
	}
	

}
