/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rzhixiao;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *直销汇总表
 */
public class RzhixiaoBean implements java.io.Serializable{

	/**
	  *直销汇总表 表名
	  */
	public static final String TABLE  = "T_RZHIXIAO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *张数 列名 
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *销售额 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *毛利 列名 
	  */
    public static final String COL_maoriprice  = "C_MAORIPRICE";
	
	/**
	  *类型国内国际 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
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
	private Long number;    
    

	//销售额
	private Double price;    
    

	//毛利
	private Double maoriprice;    
    

	//类型国内国际
	private Long type;    
    

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
    public Long getNumber(){
         return number;
    }

	/**
	 * set张数
	 */
    public void setNumber(Long number){
         this.number=number;
    }

	/**
	 * get销售额
	 */
    public Double getPrice(){
         return price;
    }

	/**
	 * set销售额
	 */
    public void setPrice(Double price){
         this.price=price;
    }

	/**
	 * get毛利
	 */
    public Double getMaoriprice(){
         return maoriprice;
    }

	/**
	 * set毛利
	 */
    public void setMaoriprice(Double maoriprice){
         this.maoriprice=maoriprice;
    }

	/**
	 * get类型国内国际
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型国内国际
	 */
    public void setType(Long type){
         this.type=type;
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
	   
	 + number +"|"
	   
	 + price +"|"
	   
	 + maoriprice +"|"
	   
	 + type +"|"
	   
	 + department +"|"
	   
	 + datetime
	 + "]";
 } 

}
