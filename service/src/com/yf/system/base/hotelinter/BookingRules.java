package com.yf.system.base.hotelinter;

import java.io.Serializable;

public class BookingRules implements Serializable,Comparable{
	public	String hotelid;//对应酒店id
	
	public	String hotelcode;//对应酒店编号
	
	public	String TypeCode;//规则类型
	//NeedNationality、务必提供客人国籍 
	//PerRoomPerName、您预订了N间房，请您提供不少于N的入住客人姓名 
	//ForeignerNeedEnName 此酒店要求外宾务必留英文拼写
	// RejectCheckinTime、几点到几点酒店不接受预订 , 此处校验的是下单时的预订时间 
	//NeedPhoneNo、务必提供客人手机号(请加在联系人结点Contact上)
	
	public	String BookingRuleId;//预订规则编号
	
	public	String Description;//预订规则描述
	
	public	String DateType;//日期类型 BookDay -预定日期
	
	public	String StartDate;//开始日期
	
	public	String EndDate;//结束日期
	
	public	String StartHour;//每天开始时间
	
	public	String EndHour;//每天结束时间
	
	//针对日期段内每天生效, 当TypeCode 为4时表示StartHour到EndHour 酒店不接受预订
	
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

	public String getTypeCode() {
		return TypeCode;
	}

	public void setTypeCode(String typeCode) {
		TypeCode = typeCode;
	}

	public String getBookingRuleId() {
		return BookingRuleId;
	}

	public void setBookingRuleId(String bookingRuleId) {
		BookingRuleId = bookingRuleId;
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

	public String getStartHour() {
		return StartHour;
	}

	public void setStartHour(String startHour) {
		StartHour = startHour;
	}

	public String getEndHour() {
		return EndHour;
	}

	public void setEndHour(String endHour) {
		EndHour = endHour;
	}

}
