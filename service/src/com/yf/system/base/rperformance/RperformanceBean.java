/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rperformance;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *绩效合约统计
 */
public class RperformanceBean implements java.io.Serializable{

	/**
	  *绩效合约统计 表名
	  */
	public static final String TABLE  = "T_RPERFORMANCE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *最低目标 列名 
	  */
    public static final String COL_low  = "C_LOW";
	
	/**
	  *正常目标 列名 
	  */
    public static final String COL_normal  = "C_NORMAL";
	
	/**
	  *优秀目标 列名 
	  */
    public static final String COL_high  = "C_HIGH";
	
	/**
	  *部门 列名 
	  */
    public static final String COL_department  = "C_DEPARTMENT";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *时间 列名 
	  */
    public static final String COL_datetime  = "C_DATETIME";

	//ID
	private long id;    
    

	//最低目标
	private Double low;    
    

	//正常目标
	private Double normal;    
    

	//优秀目标
	private Double high;    
    

	//部门
	private Long department;    
    

	//类型
	private Long type;    
    

	//时间
	private Timestamp datetime;    
    

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
	 * get最低目标
	 */
    public Double getLow(){
         return low;
    }

	/**
	 * set最低目标
	 */
    public void setLow(Double low){
         this.low=low;
    }

	/**
	 * get正常目标
	 */
    public Double getNormal(){
         return normal;
    }

	/**
	 * set正常目标
	 */
    public void setNormal(Double normal){
         this.normal=normal;
    }

	/**
	 * get优秀目标
	 */
    public Double getHigh(){
         return high;
    }

	/**
	 * set优秀目标
	 */
    public void setHigh(Double high){
         this.high=high;
    }

	/**
	 * get部门
	 */
    public Long getDepartment(){
         return department;
    }

	/**
	 * set部门
	 */
    public void setDepartment(Long department){
         this.department=department;
    }

	/**
	 * get类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get时间
	 */
    public Timestamp getDatetime(){
         return datetime;
    }

	/**
	 * set时间
	 */
    public void setDatetime(Timestamp datetime){
         this.datetime=datetime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + low +"|"
	   
	 + normal +"|"
	   
	 + high +"|"
	   
	 + department +"|"
	   
	 + type +"|"
	   
	 + datetime
	 + "]";
 } 

}
