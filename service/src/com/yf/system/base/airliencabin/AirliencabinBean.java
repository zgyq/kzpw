/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.airliencabin;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航线仓位信息
 */
public class AirliencabinBean implements java.io.Serializable{

	/**
	  *航线仓位信息 表名
	  */
	public static final String TABLE  = "T_AIRLIENCABIN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航线ID 列名 
	  */
    public static final String COL_airlineid  = "C_AIRLINEID";
	
	/**
	  *起飞三字码 列名 
	  */
    public static final String COL_scode  = "C_SCODE";
	
	/**
	  *到达三字码 列名 
	  */
    public static final String COL_ecode  = "C_ECODE";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_airno  = "C_AIRNO";
	
	/**
	  *仓位代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//航线ID
	private Long airlineid;    
    

	//起飞三字码
	private String scode;    
    

	//到达三字码
	private String ecode;    
    

	//航班号
	private String airno;    
    

	//仓位代码
	private String code;    
    

	//价格
	private String price;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//状态
	private Long state;    
    

	/**
	 * getID
	 */
    public long getId(){
         return id;
    }

	/**
	 * setID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get航线ID
	 */
    public Long getAirlineid(){
         return airlineid;
    }

	/**
	 * set航线ID
	 */
    public void setAirlineid(Long airlineid){
         this.airlineid=airlineid;
    }

	/**
	 * get起飞三字码
	 */
    public String getScode(){
         return scode;
    }

	/**
	 * set起飞三字码
	 */
    public void setScode(String scode){
         this.scode=scode;
    }

	/**
	 * get到达三字码
	 */
    public String getEcode(){
         return ecode;
    }

	/**
	 * set到达三字码
	 */
    public void setEcode(String ecode){
         this.ecode=ecode;
    }

	/**
	 * get航班号
	 */
    public String getAirno(){
         return airno;
    }

	/**
	 * set航班号
	 */
    public void setAirno(String airno){
         this.airno=airno;
    }

	/**
	 * get仓位代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set仓位代码
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get价格
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
    }

	/**
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + airlineid +"|"
	   
	 + scode +"|"
	   
	 + ecode +"|"
	   
	 + airno +"|"
	   
	 + code +"|"
	   
	 + price +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + state
	 + "]";
 } 

}
