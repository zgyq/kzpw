/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.passengerrepayrc;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机票还款记录
 */
public class PassengerrepayrcBean implements java.io.Serializable{

	/**
	  *机票还款记录 表名
	  */
	public static final String TABLE  = "T_PASSENGERREPAYRC";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *还款人id 列名 
	  */
    public static final String COL_hkuserid  = "C_HKUSERID";
	
	/**
	  *还款金额 列名 
	  */
    public static final String COL_hkmoney  = "C_HKMONEY";
	
	/**
	  *还款时间 列名 
	  */
    public static final String COL_hkdatetime  = "C_HKDATETIME";
	
	/**
	  *乘机人id 列名 
	  */
    public static final String COL_passenger  = "C_PASSENGER";
    public static final String COL_bigpriceid  = "C_BIGPRICEID";

	//id
	private long id;    
    

	//还款人id
	private long hkuserid;    
    

	//还款金额
	private Float hkmoney;    
    

	//还款时间
	private Timestamp hkdatetime;    
    

	//乘机人id
	private long passenger;    
	
	
	private long bigpriceid;
    

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
	 * get还款人id
	 */
    public long getHkuserid(){
         return hkuserid;
    }

	/**
	 * set还款人id
	 */
    public void setHkuserid(long hkuserid){
         this.hkuserid=hkuserid;
    }

	/**
	 * get还款金额
	 */
    public Float getHkmoney(){
         return hkmoney;
    }

	/**
	 * set还款金额
	 */
    public void setHkmoney(Float hkmoney){
         this.hkmoney=hkmoney;
    }

	/**
	 * get还款时间
	 */
    public Timestamp getHkdatetime(){
         return hkdatetime;
    }

	/**
	 * set还款时间
	 */
    public void setHkdatetime(Timestamp hkdatetime){
         this.hkdatetime=hkdatetime;
    }

	/**
	 * get乘机人id
	 */
    public long getPassenger(){
         return passenger;
    }

	/**
	 * set乘机人id
	 */
    public void setPassenger(long passenger){
         this.passenger=passenger;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + hkuserid +"|"
	   
	 + hkmoney +"|"
	   
	 + hkdatetime +"|"
	   
	 + passenger
	 + "]";
 }

	public long getBigpriceid() {
		return bigpriceid;
	}

	public void setBigpriceid(long bigpriceid) {
		this.bigpriceid = bigpriceid;
	} 

}
