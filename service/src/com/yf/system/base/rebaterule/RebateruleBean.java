/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rebaterule;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *返佣规则
 */
public class RebateruleBean implements java.io.Serializable{

	/**
	  *返佣规则 表名
	  */
	public static final String TABLE  = "T_REBATERULE";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *业务返佣类型 列名 
	  */
    public static final String COL_ruletypeid  = "C_RULETYPEID";
	
	/**
	  *代理商类型 列名 
	  */
    public static final String COL_agenttypeid  = "C_AGENTTYPEID";
	
	/**
	  *返佣值 列名 
	  */
    public static final String COL_rebatvalue  = "C_REBATVALUE";

	//id
	private long id;    
    

	//业务返佣类型
	private Long ruletypeid;    
    

	//代理商类型
	private Long agenttypeid;    
    

	//返佣值
	private Float rebatvalue;    
    

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
	 * get业务返佣类型
	 */
    public Long getRuletypeid(){
         return ruletypeid;
    }

	/**
	 * set业务返佣类型
	 */
    public void setRuletypeid(Long ruletypeid){
         this.ruletypeid=ruletypeid;
    }

	/**
	 * get代理商类型
	 */
    public Long getAgenttypeid(){
         return agenttypeid;
    }

	/**
	 * set代理商类型
	 */
    public void setAgenttypeid(Long agenttypeid){
         this.agenttypeid=agenttypeid;
    }

	/**
	 * get返佣值
	 */
    public Float getRebatvalue(){
         return rebatvalue;
    }

	/**
	 * set返佣值
	 */
    public void setRebatvalue(Float rebatvalue){
         this.rebatvalue=rebatvalue;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + ruletypeid +"|"
	   
	 + agenttypeid +"|"
	   
	 + rebatvalue
	 + "]";
 } 

}
