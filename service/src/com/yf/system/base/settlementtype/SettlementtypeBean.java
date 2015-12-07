/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.settlementtype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *结算分类表
 */
public class SettlementtypeBean implements java.io.Serializable{

	/**
	  *结算分类表 表名
	  */
	public static final String TABLE  = "T_SETTLEMENTTYPE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *类型名称 列名 
	  */
    public static final String COL_typename  = "C_TYPENAME";
	
	/**
	  *留点记录id 列名 
	  */
    public static final String COL_liudianid  = "C_LIUDIANID";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
    
    /**
	  *所属加盟商ID 列名 
	  */
    public static final String COL_agentid="C_AGENTID";

	//ID
	private long id;    
    

	//类型名称
	private String typename;    
    

	//留点记录id
	private Long liudianid;    
    

	//创建人
	private Long createuser;    
    

	//创建时间
	private Timestamp createtime;   
	
	
	private Long agentid;
    

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
	 * get留点记录id
	 */
    public Long getLiudianid(){
         return liudianid;
    }

	/**
	 * set留点记录id
	 */
    public void setLiudianid(Long liudianid){
         this.liudianid=liudianid;
    }

	/**
	 * get创建人
	 */
    public Long getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
	 */
    public void setCreateuser(Long createuser){
         this.createuser=createuser;
    }

	/**
	 * get创建时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set创建时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + typename +"|"
	   
	 + liudianid +"|"
	   
	 + createuser +"|"
	 
	 + agentid +"|"
	 
	 
	 + createtime
	 + "]";
 }

	public Long getAgentid() {
		return agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}

}
