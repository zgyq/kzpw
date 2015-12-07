/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 */
package com.yf.system.base.hotelorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import com.yf.system.base.guest.Guest;


/**
 *酒店订单
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Hotelorder extends HotelorderBean{

	private List<Guest> guests ;

	private String opsername ;
	
	private String opmobile ;
	
	private String firstDayPrice ;//首日价
	
	private String orderStates ;//订单状态
	
	private String hotelConfirmTel ;//电话确认酒店
	
	private String hotelConfirmFax ;//传真确认酒店
	
	private String hotelConfirmFaxReturn ;//酒店回传真
	
	private String auditStates ;//日审状态
	
	
	
	private String modifiedtime ;//订单修改时间
	
	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public String getOpsername() {
		return opsername;
	}

	public void setOpsername(String opsername) {
		this.opsername = opsername;
	}

	public String getOpmobile() {
		return opmobile;
	}

	public void setOpmobile(String opmobile) {
		this.opmobile = opmobile;
	}

	public String getFirstDayPrice() {
		return firstDayPrice;
	}

	public void setFirstDayPrice(String firstDayPrice) {
		this.firstDayPrice = firstDayPrice;
	}

	public String getOrderStates() {
		return orderStates;
	}

	public void setOrderStates(String orderStates) {
		this.orderStates = orderStates;
	}

	public String getHotelConfirmTel() {
		return hotelConfirmTel;
	}

	public void setHotelConfirmTel(String hotelConfirmTel) {
		this.hotelConfirmTel = hotelConfirmTel;
	}

	public String getHotelConfirmFax() {
		return hotelConfirmFax;
	}

	public void setHotelConfirmFax(String hotelConfirmFax) {
		this.hotelConfirmFax = hotelConfirmFax;
	}

	public String getHotelConfirmFaxReturn() {
		return hotelConfirmFaxReturn;
	}

	public void setHotelConfirmFaxReturn(String hotelConfirmFaxReturn) {
		this.hotelConfirmFaxReturn = hotelConfirmFaxReturn;
	}

	public String getAuditStates() {
		return auditStates;
	}

	public void setAuditStates(String auditStates) {
		this.auditStates = auditStates;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	
}
