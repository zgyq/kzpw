/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.starreinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *星级返点设置关联
 */
public class StarreinfoBean implements java.io.Serializable{

	/**
	  *星级返点设置关联 表名
	  */
	public static final String TABLE  = "T_STARREINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *加盟商id 列名 
	  */
    public static final String COL_sagentid  = "C_SAGENTID";
	
	/**
	  *星级留点记录id 列名 
	  */
    public static final String COL_sliudianrecid  = "C_SLIUDIANRECID";
	
	/**
	  *结算分类 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";

	//ID
	private long id;    
    

	//加盟商id
	private Long sagentid;    
    

	//星级留点记录id
	private Long sliudianrecid;    
    

	//结算分类
	private Long typeid;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

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
	 * get加盟商id
	 */
    public Long getSagentid(){
         return sagentid;
    }

	/**
	 * set加盟商id
	 */
    public void setSagentid(Long sagentid){
         this.sagentid=sagentid;
    }

	/**
	 * get星级留点记录id
	 */
    public Long getSliudianrecid(){
         return sliudianrecid;
    }

	/**
	 * set星级留点记录id
	 */
    public void setSliudianrecid(Long sliudianrecid){
         this.sliudianrecid=sliudianrecid;
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

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + sagentid +"|"
	   
	 + sliudianrecid +"|"
	   
	 + typeid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
