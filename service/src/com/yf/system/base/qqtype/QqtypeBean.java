/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qqtype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *QQ类型
 */
public class QqtypeBean implements java.io.Serializable{

	/**
	  *QQ类型 表名
	  */
	public static final String TABLE  = "T_QQTYPE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *类型名称 列名 
	  */
    public static final String COL_typename  = "C_TYPENAME";
	
	/**
	  *类型排序 列名 
	  */
    public static final String COL_index  = "C_INDEX";

	//ID
	private long id;    
    

	//类型名称
	private String typename;    
    

	//类型排序
	private Long index;    
    

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
	 * get类型排序
	 */
    public Long getIndex(){
         return index;
    }

	/**
	 * set类型排序
	 */
    public void setIndex(Long index){
         this.index=index;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + typename +"|"
	   
	 + index
	 + "]";
 } 

}
