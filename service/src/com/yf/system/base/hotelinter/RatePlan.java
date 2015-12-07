package com.yf.system.base.hotelinter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RatePlan implements Serializable,Comparable{
	public	String hotelid;//对应酒店id
	
	public	String hotelcode;//对应酒店编号
	
	public	String roomid;//对应房型ID
	
	public	String roomcode;//对应房型code
	
	public	String RatePlanId;//规则编号
	
	public	String RatePlanName;//名称
	
	public	String Status;//销售状态 false--不可销售（可能是满房、部分日期满房、缺少价格）、true--可销售
	
	public	String CustomerType;//客人类型 All=统一价；Chinese =内宾价；OtherForeign =外宾价；HongKong =港澳台客人价Japanese=日本客人价
	
	public	String CurrentAlloment;//房量限额 入住时间内不能超售的最小值。当大于0小于5时，表示目前仅剩的房量;0表示房量充足
	
	public	String InstantConfirmation;//是否支持即时确认 Boolean  表示这个产品是否支持即时确认。最终的订单是否是即时确认还需调用即时确认接口来验证
	
	public	String PaymentType;//付款类型 SelfPay-前台现付、Prepay-预付
	
	public	String BookingRuleIds;//对应的预订规则编号 
	
	public	String GuaranteeRuleIds;//对应的担保规则编号
	
	public	String PrepayRuleIds;//对应的预付规则编号
	
	public	String DrrRuleIds;//对应的促销规则编号
	
	public	String ValueAddIds;//对应的增值服务编号
	
	public	String IsLastMinuteSale;//是否今日特价  Boolean
	
	public	String StartTime;//每天可以销售的开始时间
	public	String EndTime;//每天可以销售的结束时间
	public	String MinAmount;//预定最少数量  默认1
	public	String MinDays;//最少入住天数  默认1
	public	String MaxDays;//最多入住天数  默认365
	
	public	String TotalRate;//总价  已经通过DRR的计算可以直接显示给客人。价格为-1表示不能销售
	public	String AverageRate;//日均价  已经通过DRR的计算可以直接显示给客人。价格为-1表示不能销售
	
	public	String CurrencyCode;//货币
	public	String Coupon;//优惠劵
	
	public List<NightlyRate> ListNightlyRate;//每天价格数组
	
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


	public String getRoomid() {
		return roomid;
	}


	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}


	public String getRoomcode() {
		return roomcode;
	}


	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}


	public String getRatePlanId() {
		return RatePlanId;
	}


	public void setRatePlanId(String ratePlanId) {
		RatePlanId = ratePlanId;
	}


	public String getRatePlanName() {
		return RatePlanName;
	}


	public void setRatePlanName(String ratePlanName) {
		RatePlanName = ratePlanName;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public String getCustomerType() {
		return CustomerType;
	}


	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}


	public String getCurrentAlloment() {
		return CurrentAlloment;
	}


	public void setCurrentAlloment(String currentAlloment) {
		CurrentAlloment = currentAlloment;
	}


	public String getInstantConfirmation() {
		return InstantConfirmation;
	}


	public void setInstantConfirmation(String instantConfirmation) {
		InstantConfirmation = instantConfirmation;
	}


	public String getPaymentType() {
		return PaymentType;
	}


	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}


	public String getBookingRuleIds() {
		return BookingRuleIds;
	}


	public void setBookingRuleIds(String bookingRuleIds) {
		BookingRuleIds = bookingRuleIds;
	}


	public String getGuaranteeRuleIds() {
		return GuaranteeRuleIds;
	}


	public void setGuaranteeRuleIds(String guaranteeRuleIds) {
		GuaranteeRuleIds = guaranteeRuleIds;
	}


	public String getPrepayRuleIds() {
		return PrepayRuleIds;
	}


	public void setPrepayRuleIds(String prepayRuleIds) {
		PrepayRuleIds = prepayRuleIds;
	}


	public String getDrrRuleIds() {
		return DrrRuleIds;
	}


	public void setDrrRuleIds(String drrRuleIds) {
		DrrRuleIds = drrRuleIds;
	}


	public String getValueAddIds() {
		return ValueAddIds;
	}


	public void setValueAddIds(String valueAddIds) {
		ValueAddIds = valueAddIds;
	}


	public String getIsLastMinuteSale() {
		return IsLastMinuteSale;
	}


	public void setIsLastMinuteSale(String isLastMinuteSale) {
		IsLastMinuteSale = isLastMinuteSale;
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


	public String getMinAmount() {
		return MinAmount;
	}


	public void setMinAmount(String minAmount) {
		MinAmount = minAmount;
	}


	public String getMinDays() {
		return MinDays;
	}


	public void setMinDays(String minDays) {
		MinDays = minDays;
	}


	public String getMaxDays() {
		return MaxDays;
	}


	public void setMaxDays(String maxDays) {
		MaxDays = maxDays;
	}


	public String getTotalRate() {
		return TotalRate;
	}


	public void setTotalRate(String totalRate) {
		TotalRate = totalRate;
	}


	public String getAverageRate() {
		return AverageRate;
	}


	public void setAverageRate(String averageRate) {
		AverageRate = averageRate;
	}


	public String getCurrencyCode() {
		return CurrencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}


	public String getCoupon() {
		return Coupon;
	}


	public void setCoupon(String coupon) {
		Coupon = coupon;
	}


	public List<NightlyRate> getListNightlyRate() {
		return ListNightlyRate;
	}


	public void setListNightlyRate(List<NightlyRate> listNightlyRate) {
		ListNightlyRate = listNightlyRate;
	}

	

}
