/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.tickettype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机票类型
 */
public class TickettypeBean implements java.io.Serializable{

	/**
	  *机票类型 表名
	  */
	public static final String TABLE  = "T_TICKETTYPE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *类型名称 列名 
	  */
    public static final String COL_typename  = "C_TYPENAME";
	
	/**
	  *类型描述 列名 
	  */
    public static final String COL_typedesc  = "C_TYPEDESC";

	//ID
	private long id;    
    

	//类型名称
	private String typename;    
    

	//类型描述
	private String typedesc;    
    

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
	 * get类型名称
	 */
    public String getTypename(){
         return typename;
    }

	/**
	 * set类型名称
	 */
    public void setTypename(String typename){
         this.typename=typename;
    }

	/**
	 * get类型描述
	 */
    public String getTypedesc(){
         return typedesc;
    }

	/**
	 * set类型描述
	 */
    public void setTypedesc(String typedesc){
         this.typedesc=typedesc;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + typename +"|"
	   
	 + typedesc
	 + "]";
 } 

}
