package com.yf.system.base.hotelinter;

import java.io.Serializable;

public class NightlyRate implements Serializable,Comparable{

	public String Date;//当天日期
	
	public String Member;//会员价 已经通过DRR的计算可以直接显示给客人.。价格为-1表示不能销售。
	
	public String Cost;//结算价 仅结算价模式下的预付产品
	
	public String Status;//库存状态 Boolean 表示当天库存是否可用
	
	public String AddBed;//加床价 -1表示不能加床
	
	
	
	
	
	
	
	public String getDate() {
		return Date;
	}







	public void setDate(String date) {
		Date = date;
	}







	public String getMember() {
		return Member;
	}







	public void setMember(String member) {
		Member = member;
	}







	public String getCost() {
		return Cost;
	}







	public void setCost(String cost) {
		Cost = cost;
	}







	public String getStatus() {
		return Status;
	}







	public void setStatus(String status) {
		Status = status;
	}







	public String getAddBed() {
		return AddBed;
	}







	public void setAddBed(String addBed) {
		AddBed = addBed;
	}







	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
