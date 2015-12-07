/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.liudianrecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *留点记录表
 */
public class LiudianrecordBean implements java.io.Serializable{

	/**
	  *留点记录表 表名
	  */
	public static final String TABLE  = "T_LIUDIANRECORD";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *返点始 列名 
	  */
    public static final String COL_fandianstart  = "C_FANDIANSTART";
	
	/**
	  *返点止 列名 
	  */
    public static final String COL_fandianend  = "C_FANDIANEND";
	
	/**
	  *留点值 列名 
	  */
    public static final String COL_liudian  = "C_LIUDIAN";
    
    /**
     * 加盟商id
     */
    public static final String COL_agentid="C_AGENTID";
    
    public static final String COL_typeid="C_TYPEID";

	//id
	private long id;    
    

	//返点始
	private Float fandianstart;    
    

	//返点止
	private Float fandianend;    
    

	//留点值
	private Float liudian;   
	
	//加盟商id
	private Long agentid;
	
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + fandianstart +"|"
	 
	 + agentid +"|"
	   
	 + fandianend +"|"
	 
	 + typeid +"|"
	   
	 + liudian
	 + "]";
 }

	public Long getAgentid() {
		return agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}

	public Float getFandianstart() {
		return fandianstart;
	}

	public void setFandianstart(Float fandianstart) {
		this.fandianstart = fandianstart;
	}

	public Float getFandianend() {
		return fandianend;
	}

	public void setFandianend(Float fandianend) {
		this.fandianend = fandianend;
	}

	public Float getLiudian() {
		return liudian;
	}

	public void setLiudian(Float liudian) {
		this.liudian = liudian;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

}
