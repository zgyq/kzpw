/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rgroupcustomers;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *集团客户环比统计表
 */
public class RgroupcustomersBean implements java.io.Serializable{

	/**
	  *集团客户环比统计表 表名
	  */
	public static final String TABLE  = "T_RGROUPCUSTOMERS";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *集团客户ID 列名 
	  */
    public static final String COL_groupcusid  = "C_GROUPCUSID";
	
	/**
	  *集团客户名称 列名 
	  */
    public static final String COL_groupname  = "C_GROUPNAME";
	
	/**
	  *金额 列名 
	  */
    public static final String COL_money  = "C_MONEY";
	
	/**
	  *时间 列名 
	  */
    public static final String COL_datetime  = "C_DATETIME";

	//ID
	private long id;    
    

	//集团客户ID
	private Long groupcusid;    
    

	//集团客户名称
	private String groupname;    
    

	//金额
	private Double money;    
    

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
	 * get集团客户ID
	 */
    public Long getGroupcusid(){
         return groupcusid;
    }

	/**
	 * set集团客户ID
	 */
    public void setGroupcusid(Long groupcusid){
         this.groupcusid=groupcusid;
    }

	/**
	 * get集团客户名称
	 */
    public String getGroupname(){
         return groupname;
    }

	/**
	 * set集团客户名称
	 */
    public void setGroupname(String groupname){
         this.groupname=groupname;
    }

	/**
	 * get金额
	 */
    public Double getMoney(){
         return money;
    }

	/**
	 * set金额
	 */
    public void setMoney(Double money){
         this.money=money;
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
	   
	 + groupcusid +"|"
	   
	 + groupname +"|"
	   
	 + money +"|"
	   
	 + datetime
	 + "]";
 } 

}
