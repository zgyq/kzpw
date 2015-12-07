/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.starrecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *星级留点记录
 */
public class StarrecordBean implements java.io.Serializable{

	/**
	  *星级留点记录 表名
	  */
	public static final String TABLE  = "T_STARRECORD";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *返点始 列名 
	  */
    public static final String COL_sfandianstart  = "C_SFANDIANSTART";
	
	/**
	  *返点止 列名 
	  */
    public static final String COL_sfandianend  = "C_SFANDIANEND";
	
	/**
	  *留点值 列名 
	  */
    public static final String COL_sliudian  = "C_SLIUDIAN";
	
	/**
	  *加盟商id 列名 
	  */
    public static final String COL_sagentid  = "C_SAGENTID";
	
	/**
	  *类型id 列名 
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
    

	//返点始
	private String sfandianstart;    
    

	//返点止
	private String sfandianend;    
    

	//留点值
	private String sliudian;    
    

	//加盟商id
	private Long sagentid;    
    

	//类型id
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
	 * get返点始
	 */
    public String getSfandianstart(){
         return sfandianstart;
    }

	/**
	 * set返点始
	 */
    public void setSfandianstart(String sfandianstart){
         this.sfandianstart=sfandianstart;
    }

	/**
	 * get返点止
	 */
    public String getSfandianend(){
         return sfandianend;
    }

	/**
	 * set返点止
	 */
    public void setSfandianend(String sfandianend){
         this.sfandianend=sfandianend;
    }

	/**
	 * get留点值
	 */
    public String getSliudian(){
         return sliudian;
    }

	/**
	 * set留点值
	 */
    public void setSliudian(String sliudian){
         this.sliudian=sliudian;
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
	 * get类型id
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set类型id
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
	   
	 + sfandianstart +"|"
	   
	 + sfandianend +"|"
	   
	 + sliudian +"|"
	   
	 + sagentid +"|"
	   
	 + typeid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
