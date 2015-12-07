/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rsector;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *部门绩效表
 */
public class RsectorBean implements java.io.Serializable{

	/**
	  *部门绩效表 表名
	  */
	public static final String TABLE  = "T_RSECTOR";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *绩效合约ID 列名 
	  */
    public static final String COL_performanceid  = "C_PERFORMANCEID";
	
	/**
	  *金额万元 列名 
	  */
    public static final String COL_money  = "C_MONEY";
	
	/**
	  *时间 列名 
	  */
    public static final String COL_date  = "C_DATE";
	
	/**
	  *最低目标百分 列名 
	  */
    public static final String COL_low  = "C_LOW";
	
	/**
	  *正常目标百分 列名 
	  */
    public static final String COL_normal  = "C_NORMAL";
	
	/**
	  *优秀目标百分 列名 
	  */
    public static final String COL_high  = "C_HIGH";

	//ID
	private long id;    
    

	//绩效合约ID
	private Long performanceid;    
    

	//金额万元
	private Double money;    
    

	//时间
	private Timestamp date;    
    

	//最低目标百分
	private Double low;    
    

	//正常目标百分
	private Double normal;    
    

	//优秀目标百分
	private Double high;    
    

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
	 * get绩效合约ID
	 */
    public Long getPerformanceid(){
         return performanceid;
    }

	/**
	 * set绩效合约ID
	 */
    public void setPerformanceid(Long performanceid){
         this.performanceid=performanceid;
    }

	/**
	 * get金额万元
	 */
    public Double getMoney(){
         return money;
    }

	/**
	 * set金额万元
	 */
    public void setMoney(Double money){
         this.money=money;
    }

	/**
	 * get时间
	 */
    public Timestamp getDate(){
         return date;
    }

	/**
	 * set时间
	 */
    public void setDate(Timestamp date){
         this.date=date;
    }

	/**
	 * get最低目标百分
	 */
    public Double getLow(){
         return low;
    }

	/**
	 * set最低目标百分
	 */
    public void setLow(Double low){
         this.low=low;
    }

	/**
	 * get正常目标百分
	 */
    public Double getNormal(){
         return normal;
    }

	/**
	 * set正常目标百分
	 */
    public void setNormal(Double normal){
         this.normal=normal;
    }

	/**
	 * get优秀目标百分
	 */
    public Double getHigh(){
         return high;
    }

	/**
	 * set优秀目标百分
	 */
    public void setHigh(Double high){
         this.high=high;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + performanceid +"|"
	   
	 + money +"|"
	   
	 + date +"|"
	   
	 + low +"|"
	   
	 + normal +"|"
	   
	 + high
	 + "]";
 } 

}
