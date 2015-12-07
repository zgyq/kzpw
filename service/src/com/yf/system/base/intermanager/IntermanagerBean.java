/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.intermanager;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *接口管理
 */
public class IntermanagerBean implements java.io.Serializable{

	/**
	  *接口管理 表名
	  */
	public static final String TABLE  = "T_INTERMANAGER";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *接口地址 列名 
	  */
    public static final String COL_interurl  = "C_INTERURL";
	
	/**
	  *来源ip 列名 
	  */
    public static final String COL_resourceip  = "C_RESOURCEIP";
	
	/**
	  *限制类型 列名 
	  */
    public static final String COL_limittype  = "C_LIMITTYPE";
	
	/**
	  *限制次数 列名 
	  */
    public static final String COL_limittimes  = "C_LIMITTIMES";
	
	/**
	  *有效次数 列名 
	  */
    public static final String COL_effecttimes  = "C_EFFECTTIMES";
	
	/**
	  *使用开始时间 列名 
	  */
    public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";
	
	/**
	  *当前使用时期 列名 
	  */
    public static final String COL_curtime  = "C_CURTIME";
	
	/**
	  *规则状态 0启用 1禁用 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//id
	private long id;    
    

	//接口地址
	private String interurl;    
    

	//来源ip
	private String resourceip;    
    

	//限制类型
	private Integer limittype;    
    

	//限制次数
	private Integer limittimes;    
    

	//有效次数
	private Integer effecttimes;    
    

	//使用开始时间
	private Timestamp starttime;    
    

	//结束时间
	private Timestamp endtime;    
    

	//当前使用时期
	private Timestamp curtime;    
    

	//规则状态 0启用 1禁用
	private Integer state;    
    

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
	 * get接口地址
	 */
    public String getInterurl(){
         return interurl;
    }

	/**
	 * set接口地址
	 */
    public void setInterurl(String interurl){
         this.interurl=interurl;
    }

	/**
	 * get来源ip
	 */
    public String getResourceip(){
         return resourceip;
    }

	/**
	 * set来源ip
	 */
    public void setResourceip(String resourceip){
         this.resourceip=resourceip;
    }

	/**
	 * get限制类型
	 */
    public Integer getLimittype(){
         return limittype;
    }

	/**
	 * set限制类型
	 */
    public void setLimittype(Integer limittype){
         this.limittype=limittype;
    }

	/**
	 * get限制次数
	 */
    public Integer getLimittimes(){
         return limittimes;
    }

	/**
	 * set限制次数
	 */
    public void setLimittimes(Integer limittimes){
         this.limittimes=limittimes;
    }

	/**
	 * get有效次数
	 */
    public Integer getEffecttimes(){
         return effecttimes;
    }

	/**
	 * set有效次数
	 */
    public void setEffecttimes(Integer effecttimes){
         this.effecttimes=effecttimes;
    }

	/**
	 * get使用开始时间
	 */
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set使用开始时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
    }

	/**
	 * get结束时间
	 */
    public Timestamp getEndtime(){
         return endtime;
    }

	/**
	 * set结束时间
	 */
    public void setEndtime(Timestamp endtime){
         this.endtime=endtime;
    }

	/**
	 * get当前使用时期
	 */
    public Timestamp getCurtime(){
         return curtime;
    }

	/**
	 * set当前使用时期
	 */
    public void setCurtime(Timestamp curtime){
         this.curtime=curtime;
    }

	/**
	 * get规则状态 0启用 1禁用
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set规则状态 0启用 1禁用
	 */
    public void setState(Integer state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + interurl +"|"
	   
	 + resourceip +"|"
	   
	 + limittype +"|"
	   
	 + limittimes +"|"
	   
	 + effecttimes +"|"
	   
	 + starttime +"|"
	   
	 + endtime +"|"
	   
	 + curtime +"|"
	   
	 + state
	 + "]";
 } 

}
