/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.lowestprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机票低价数据表
 */
public class LowestpriceBean implements java.io.Serializable{

	/**
	  *机票低价数据表 表名
	  */
	public static final String TABLE  = "T_LOWESTPRICE";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_fromcity  = "C_FROMCITY";
	
	/**
	  *到达城市 列名 
	  */
    public static final String COL_tocity  = "C_TOCITY";
	
	/**
	  *航空公司名称 列名 
	  */
    public static final String COL_aircompanyname  = "C_AIRCOMPANYNAME";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *折扣 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *出发日期 列名 
	  */
    public static final String COL_fromdate  = "C_FROMDATE";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_fromtime  = "C_FROMTIME";
	
	/**
	  *更新时间 列名 
	  */
    public static final String COL_updatetime  = "C_UPDATETIME";
    
    /**
	  *出发三字码 列名 
	  */
   public static final String COL_scitycode  = "C_SCITYCODE";
   /**
	  *到达三字码 列名 
	  */
   public static final String COL_ecitycode  = "C_ECITYCODE";

	//id
	private long id;    
    

	//出发城市
	private String fromcity;    
    

	//到达城市
	private String tocity;    
    

	//航空公司名称
	private String aircompanyname;    
    

	//价格
	private Float price;    
    

	//折扣
	private String discount;    
    

	//出发日期
	private String fromdate;    
    

	//起飞时间
	private String fromtime;    
    

	//更新时间
	private Timestamp updatetime;    
	
	//出发三字码
	private String scitycode; 
	
	
	//到达三字码
	private String ecitycode; 

	/**
	 * getid
	 */
    public long getId(){
         return id;
    }

	/**
	 * setid
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get出发城市
	 */
    public String getFromcity(){
         return fromcity;
    }

	/**
	 * set出发城市
	 */
    public void setFromcity(String fromcity){
         this.fromcity=fromcity;
    }

	/**
	 * get到达城市
	 */
    public String getTocity(){
         return tocity;
    }

	/**
	 * set到达城市
	 */
    public void setTocity(String tocity){
         this.tocity=tocity;
    }

	/**
	 * get航空公司名称
	 */
    public String getAircompanyname(){
         return aircompanyname;
    }

	/**
	 * set航空公司名称
	 */
    public void setAircompanyname(String aircompanyname){
         this.aircompanyname=aircompanyname;
    }

	/**
	 * get价格
	 */
    public Float getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(Float price){
         this.price=price;
    }

	/**
	 * get折扣
	 */
    public String getDiscount(){
         return discount;
    }

	/**
	 * set折扣
	 */
    public void setDiscount(String discount){
         this.discount=discount;
    }

	/**
	 * get出发日期
	 */
    public String getFromdate(){
         return fromdate;
    }

	/**
	 * set出发日期
	 */
    public void setFromdate(String fromdate){
         this.fromdate=fromdate;
    }

	/**
	 * get起飞时间
	 */
    public String getFromtime(){
         return fromtime;
    }

	/**
	 * set起飞时间
	 */
    public void setFromtime(String fromtime){
         this.fromtime=fromtime;
    }

	/**
	 * get更新时间
	 */
    public Timestamp getUpdatetime(){
         return updatetime;
    }

	/**
	 * set更新时间
	 */
    public void setUpdatetime(Timestamp updatetime){
         this.updatetime=updatetime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + fromcity +"|"
	   
	 + tocity +"|"
	   
	 + aircompanyname +"|"
	   
	 + price +"|"
	   
	 + discount +"|"
	   
	 + fromdate +"|"
	   
	 + fromtime +"|"
	 
	 + scitycode +"|"
	 
	 + ecitycode +"|"
	   
	 + updatetime
	 + "]";
 }

	public String getScitycode() {
		return scitycode;
	}

	public void setScitycode(String scitycode) {
		this.scitycode = scitycode;
	}

	public String getEcitycode() {
		return ecitycode;
	}

	public void setEcitycode(String ecitycode) {
		this.ecitycode = ecitycode;
	} 

}
