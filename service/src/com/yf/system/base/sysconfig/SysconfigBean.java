/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.sysconfig;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *系统配置表
 */
public class SysconfigBean implements java.io.Serializable{

	/**
	  *系统配置表 表名
	  */
	public static final String TABLE  = "T_SYSCONFIG";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *值 列名 
	  */
    public static final String COL_value  = "C_VALUE";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//值
	private String value;    
    

	//描述
	private String description;    
    

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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get值
	 */
    public String getValue(){
         return value;
    }

	/**
	 * set值
	 */
    public void setValue(String value){
         this.value=value;
    }

	/**
	 * get描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set描述
	 */
    public void setDescription(String description){
         this.description=description;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + value +"|"
	   
	 + description
	 + "]";
 } 

}
