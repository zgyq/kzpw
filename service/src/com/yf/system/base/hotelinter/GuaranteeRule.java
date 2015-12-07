package com.yf.system.base.hotelinter;

import java.io.Serializable;

public class GuaranteeRule implements Serializable,Comparable{
	public	String hotelid;//对应酒店id
	
	public	String hotelcode;//对应酒店编号
	
	
	public	String GuranteeRuleId;//担保规则编号
	
	public	String Description;//规则描述
	
	public	String DateType;//日期类型 CheckInDay-入住日期 StayDay-在店日期
	
	public	String StartDate;//开始日期
	//举例：datetype为StayDay
	//表示当前订单的入住日期落在startdate 和 enddate之间，并且入住日期符合周设置时才需要判断其它条件是否担保，否则不需要担保
	public	String EndDate;//结束日期
	
	public	String WeekSet;//周有效天数， 一般为周一到周日都有效， 判断日期符合日期段同时也要满足周设置的有效 周一对应为1，周二对应为2， 依次类推;逗号分隔
	
	
	public	String IsTimeGuarantee;//是否到店时间担保 False:为不校验到店时间 True:为需要校验到店时间
	
	
	//一下3属性 用于 isTimeGuarantee=1
	public	String StartTime;// 到店担保开始时间
	
	public	String EndTime;// 到店担保结束时间
	
	public	String IsTomorrow;// 到店担保的结束时间是否为第二天 ; 0为当天，1为次日
	
	public	String IsAmountGuarantee;// 是否房量担保 False:为不校验房量条件 True:为校验房量条件
	
	public	String Amount;// 担保的房间数,预定几间房以上
	
	public	String GuaranteeType;// 担保类型  FirstNightCost为首晚房费担保  FullNightCost为全额房费担保
	
	public	String ChangeRule;// 变更规则  担保规则条数，规则
	//NoChange、不允许变更取消 
	//NeedSomeDay、允许变更/取消,需在XX日YY时之前通知
	//NeedCheckinTime、允许变更/取消,需在最早到店时间之前几小时通知
	//NeedCheckin24hour、允许变更/取消,需在到店日期的24点之前几小时通知
	public	String Day;// 日期参数 
	public	String Time;// 时间参数 ChangeRule= NeedSomeDay时，对应规则2描述中 “允许变更/取消,需在XX日YY时之前通知” 中的XX日，YY时 
	public	String Hour;// 小时参数  ChangeRule= NeedCheckinTime时，对应规则3描述中 “ 允许变更/取消,需在最早到店时间之前几小时通知” 中的几小时 
				//         ChangeRule= NeedCheckin24hour时，对应规则4描述中“ 允许变更/取消,需在到店日期的24点之前几小时通知” 中的几小时
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
	public String getGuranteeRuleId() {
		return GuranteeRuleId;
	}
	public void setGuranteeRuleId(String guranteeRuleId) {
		GuranteeRuleId = guranteeRuleId;
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
	public String getIsTimeGuarantee() {
		return IsTimeGuarantee;
	}
	public void setIsTimeGuarantee(String isTimeGuarantee) {
		IsTimeGuarantee = isTimeGuarantee;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getIsTomorrow() {
		return IsTomorrow;
	}
	public void setIsTomorrow(String isTomorrow) {
		IsTomorrow = isTomorrow;
	}
	public String getIsAmountGuarantee() {
		return IsAmountGuarantee;
	}
	public void setIsAmountGuarantee(String isAmountGuarantee) {
		IsAmountGuarantee = isAmountGuarantee;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getGuaranteeType() {
		return GuaranteeType;
	}
	public void setGuaranteeType(String guaranteeType) {
		GuaranteeType = guaranteeType;
	}
	public String getChangeRule() {
		return ChangeRule;
	}
	public void setChangeRule(String changeRule) {
		ChangeRule = changeRule;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getHour() {
		return Hour;
	}
	public void setHour(String hour) {
		Hour = hour;
	}

	

}
