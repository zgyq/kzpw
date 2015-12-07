/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.agentroleref;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *会员角色关联
 */
public class AgentrolerefBean implements java.io.Serializable{

	/**
	  *会员角色关联 表名
	  */
	public static final String TABLE  = "T_AGENTROLEREF";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *角色ID 列名 
	  */
    public static final String COL_roleid  = "C_ROLEID";
	
	/**
	  *用户ID 列名 
	  */
    public static final String COL_customeruserid  = "C_CUSTOMERUSERID";

	//ID
	private long id;    
    

	//角色ID
	private Long roleid;    
    

	//用户ID
	private Long customeruserid;    
    

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
	 * get角色ID
	 */
    public Long getRoleid(){
         return roleid;
    }

	/**
	 * set角色ID
	 */
    public void setRoleid(Long roleid){
         this.roleid=roleid;
    }

	/**
	 * get用户ID
	 */
    public Long getCustomeruserid(){
         return customeruserid;
    }

	/**
	 * set用户ID
	 */
    public void setCustomeruserid(Long customeruserid){
         this.customeruserid=customeruserid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + roleid +"|"
	   
	 + customeruserid
	 + "]";
 } 

}
