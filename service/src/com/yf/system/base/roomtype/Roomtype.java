/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.roomtype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import com.yf.system.base.hotelinter.RatePlan;

/**
 *酒店房型
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Roomtype extends RoomtypeBean{

	public List<RatePlan>ListRatePlan;//价格政策
	
	
	
	public List<Object>ListPrice;//价格
	public List<Object>ListPriceTXT;//价格描述
	public Double ToAllPrice;//总价格
	public Double MenShiPrice;//总价格
	public String BookDesc;//预定要求
	public String DanBaoDesc;//担保要求
	public String RatePlanID;//价格RP
	public String getRatePlanID() {
		return RatePlanID;
	}

	public void setRatePlanID(String ratePlanID) {
		RatePlanID = ratePlanID;
	}

	public List<Object> getListPrice() {
		return ListPrice;
	}

	public void setListPrice(List<Object> listPrice) {
		ListPrice = listPrice;
	}

	public Double getToAllPrice() {
		return ToAllPrice;
	}

	public void setToAllPrice(Double toAllPrice) {
		ToAllPrice = toAllPrice;
	}

	public String getBookDesc() {
		return BookDesc;
	}

	public void setBookDesc(String bookDesc) {
		BookDesc = bookDesc;
	}

	public String getDanBaoDesc() {
		return DanBaoDesc;
	}

	public void setDanBaoDesc(String danBaoDesc) {
		DanBaoDesc = danBaoDesc;
	}

	public List<Object> getListPriceTXT() {
		return ListPriceTXT;
	}

	public void setListPriceTXT(List<Object> listPriceTXT) {
		ListPriceTXT = listPriceTXT;
	}

	public Double getMenShiPrice() {
		return MenShiPrice;
	}

	public void setMenShiPrice(Double menShiPrice) {
		MenShiPrice = menShiPrice;
	}

	public List<RatePlan> getListRatePlan() {
		return ListRatePlan;
	}

	public void setListRatePlan(List<RatePlan> listRatePlan) {
		ListRatePlan = listRatePlan;
	}
}
