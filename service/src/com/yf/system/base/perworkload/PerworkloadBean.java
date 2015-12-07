/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.perworkload;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *人均工作量统计
 */
public class PerworkloadBean implements java.io.Serializable{

	/**
	  *人均工作量统计 表名
	  */
	public static final String TABLE  = "T_PERWORKLOAD";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *员工号 列名 
	  */
    public static final String COL_usernumber  = "C_USERNUMBER";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *张数 列名 
	  */
    public static final String COL_ticketnumber  = "C_TICKETNUMBER";
	
	/**
	  *金额 列名 
	  */
    public static final String COL_ticketmoney  = "C_TICKETMONEY";
	
	/**
	  *废票张数 列名 
	  */
    public static final String COL_tuinumber  = "C_TUINUMBER";
	
	/**
	  *废票金额 列名 
	  */
    public static final String COL_tuimoney  = "C_TUIMONEY";
	
	/**
	  *部门 列名 
	  */
    public static final String COL_department  = "C_DEPARTMENT";
	
	/**
	  *时间 列名 
	  */
    public static final String COL_datetime  = "C_DATETIME";

	//ID
	private long id;    
    

	//员工号
	private String usernumber;    
    

	//姓名
	private String name;    
    

	//张数
	private Long ticketnumber;    
    

	//金额
	private Double ticketmoney;    
    

	//废票张数
	private Long tuinumber;    
    

	//废票金额
	private Double tuimoney;    
    

	//部门
	private Long department;    
    

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
	 * get员工号
	 */
    public String getUsernumber(){
         return usernumber;
    }

	/**
	 * set员工号
	 */
    public void setUsernumber(String usernumber){
         this.usernumber=usernumber;
    }

	/**
	 * get姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set姓名
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get张数
	 */
    public Long getTicketnumber(){
         return ticketnumber;
    }

	/**
	 * set张数
	 */
    public void setTicketnumber(Long ticketnumber){
         this.ticketnumber=ticketnumber;
    }

	/**
	 * get金额
	 */
    public Double getTicketmoney(){
         return ticketmoney;
    }

	/**
	 * set金额
	 */
    public void setTicketmoney(Double ticketmoney){
         this.ticketmoney=ticketmoney;
    }

	/**
	 * get废票张数
	 */
    public Long getTuinumber(){
         return tuinumber;
    }

	/**
	 * set废票张数
	 */
    public void setTuinumber(Long tuinumber){
         this.tuinumber=tuinumber;
    }

	/**
	 * get废票金额
	 */
    public Double getTuimoney(){
         return tuimoney;
    }

	/**
	 * set废票金额
	 */
    public void setTuimoney(Double tuimoney){
         this.tuimoney=tuimoney;
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
	   
	 + usernumber +"|"
	   
	 + name +"|"
	   
	 + ticketnumber +"|"
	   
	 + ticketmoney +"|"
	   
	 + tuinumber +"|"
	   
	 + tuimoney +"|"
	   
	 + department +"|"
	   
	 + datetime
	 + "]";
 } 

}
