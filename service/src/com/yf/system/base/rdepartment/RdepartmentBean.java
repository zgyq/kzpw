/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rdepartment;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *部门销售汇总表
 */
public class RdepartmentBean implements java.io.Serializable{

	/**
	  *部门销售汇总表 表名
	  */
	public static final String TABLE  = "T_RDEPARTMENT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *张数 列名 
	  */
    public static final String COL_ticketnumber  = "C_TICKETNUMBER";
	
	/**
	  *销售额 列名 
	  */
    public static final String COL_ticketmoney  = "C_TICKETMONEY";
	
	/**
	  *利润 列名 
	  */
    public static final String COL_profitmoney  = "C_PROFITMONEY";
	
	/**
	  *采购数量 列名 
	  */
    public static final String COL_purchase  = "C_PURCHASE";
	
	/**
	  *供应数量 列名 
	  */
    public static final String COL_supply  = "C_SUPPLY";
	
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
    

	//张数
	private Long ticketnumber;    
    

	//销售额
	private Double ticketmoney;    
    

	//利润
	private Double profitmoney;    
    

	//采购数量
	private Long purchase;    
    

	//供应数量
	private Long supply;    
    

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
	 * get销售额
	 */
    public Double getTicketmoney(){
         return ticketmoney;
    }

	/**
	 * set销售额
	 */
    public void setTicketmoney(Double ticketmoney){
         this.ticketmoney=ticketmoney;
    }

	/**
	 * get利润
	 */
    public Double getProfitmoney(){
         return profitmoney;
    }

	/**
	 * set利润
	 */
    public void setProfitmoney(Double profitmoney){
         this.profitmoney=profitmoney;
    }

	/**
	 * get采购数量
	 */
    public Long getPurchase(){
         return purchase;
    }

	/**
	 * set采购数量
	 */
    public void setPurchase(Long purchase){
         this.purchase=purchase;
    }

	/**
	 * get供应数量
	 */
    public Long getSupply(){
         return supply;
    }

	/**
	 * set供应数量
	 */
    public void setSupply(Long supply){
         this.supply=supply;
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
	   
	 + ticketnumber +"|"
	   
	 + ticketmoney +"|"
	   
	 + profitmoney +"|"
	   
	 + purchase +"|"
	   
	 + supply +"|"
	   
	 + department +"|"
	   
	 + datetime
	 + "]";
 } 

}
