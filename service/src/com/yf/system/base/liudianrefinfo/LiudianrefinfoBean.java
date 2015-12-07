/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.liudianrefinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *留点设置关联表
 */
public class LiudianrefinfoBean implements java.io.Serializable{

	/**
	  *留点设置关联表 表名
	  */
	public static final String TABLE  = "T_LIUDIANREFINFO";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *加盟商id 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID"; 
	
	/**
	  *留点记录id 列名 
	  */
    public static final String COL_liudianrecid  = "C_LIUDIANRECID";
	
	/**
	  *结算分类 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";

	//id
	private long id;    
    

	//加盟商id
	private Long agentid;    
    

	//留点记录id
	private Long liudianrecid;    
    

	//结算分类
	private Long typeid;    
    

	/**
	 * getid
	 */
    public long getId(){
         return id;
    }

	/**
	 * setid
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get加盟商id
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set加盟商id
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get留点记录id
	 */
    public Long getLiudianrecid(){
         return liudianrecid;
    }

	/**
	 * set留点记录id
	 */
    public void setLiudianrecid(Long liudianrecid){
         this.liudianrecid=liudianrecid;
    }

	/**
	 * get结算分类
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set结算分类
	 */
    public void setTypeid(Long typeid){
         this.typeid=typeid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + agentid +"|"
	   
	 + liudianrecid +"|"
	   
	 + typeid
	 + "]";
 } 

}
