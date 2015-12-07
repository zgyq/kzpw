package com.yf.system.base.hotelinter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Review implements Serializable,Comparable{
	public	String hotelid;//对应酒店id
	
	public	String hotelcode;//对应酒店编号
	
	public	String Good;//好评数
	
	public	String Poor;//差评数
	
	public	String Count;//评论总数
	
	public	String Score;//好评率
	
	
	
	
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




	public String getGood() {
		return Good;
	}




	public void setGood(String good) {
		Good = good;
	}




	public String getPoor() {
		return Poor;
	}




	public void setPoor(String poor) {
		Poor = poor;
	}




	public String getCount() {
		return Count;
	}




	public void setCount(String count) {
		Count = count;
	}




	public String getScore() {
		return Score;
	}




	public void setScore(String score) {
		Score = score;
	}



}
