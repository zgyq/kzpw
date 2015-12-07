/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.sysroleright;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *系统角色权限关联
 */
public class SysrolerightBean implements java.io.Serializable{

	/**
	  *系统角色权限关联 表名
	  */
	public static final String TABLE  = "T_SYSROLERIGHT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *角色ID 列名 
	  */
    public static final String COL_roleid  = "C_ROLEID";
	
	/**
	  *权限ID 列名 
	  */
    public static final String COL_rightid  = "C_RIGHTID";

	//ID
	private long id;    
    

	//角色ID
	private Long roleid;    
    

	//权限ID
	private Long rightid;    
    

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
	 * get权限ID
	 */
    public Long getRightid(){
         return rightid;
    }

	/**
	 * set权限ID
	 */
    public void setRightid(Long rightid){
         this.rightid=rightid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + roleid +"|"
	   
	 + rightid
	 + "]";
 } 

}
