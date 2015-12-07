/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotel;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Hotel extends HotelBean{

	//币种
	private String Currency;   
	
	//价格
	private Double AmountAfterTax;
	
	//早餐价
	private Double BreakfastPrice;
	
	//房型
	private int roomtype;

	public int getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(int roomtype) {
		this.roomtype = roomtype;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public Double getAmountAfterTax() {
		return AmountAfterTax;
	}

	public void setAmountAfterTax(Double amountAfterTax) {
		AmountAfterTax = amountAfterTax;
	}

	public Double getBreakfastPrice() {
		return BreakfastPrice;
	}

	public void setBreakfastPrice(Double breakfastPrice) {
		BreakfastPrice = breakfastPrice;
	}
}
