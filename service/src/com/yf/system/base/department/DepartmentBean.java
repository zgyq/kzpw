/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.department;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *部门
 */
public class DepartmentBean implements java.io.Serializable{

	/**
	  *部门 表名
	  */
	public static final String TABLE  = "T_DEPARTMENT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *部门名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *上级部门 列名 
	  */
    public static final String COL_parentid  = "C_PARENTID";
	
	/**
	  *所属加盟商 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
    
    
    public static final String COL_type="C_TYPE";
    
    public static final String COL_deptmemo="C_DEPTMEMO";

	//ID
	private long id;    
    

	//部门名称
	private String name;    
    

	//上级部门
	private Long parentid;    
    

	//所属加盟商
	private Long agentid;
	
	private Integer type;
	
	private String deptmemo;
    

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDeptmemo() {
		return deptmemo;
	}

	public void setDeptmemo(String deptmemo) {
		this.deptmemo = deptmemo;
	}

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
	 * get部门名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set部门名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get上级部门
	 */
    public Long getParentid(){
         return parentid;
    }

	/**
	 * set上级部门
	 */
    public void setParentid(Long parentid){
         this.parentid=parentid;
    }

	/**
	 * get所属加盟商
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set所属加盟商
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + parentid +"|"
	   
	 + agentid
	 + "]";
 } 

}
