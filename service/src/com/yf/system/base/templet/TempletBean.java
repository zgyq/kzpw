/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.templet;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *模板
 */
public class TempletBean implements java.io.Serializable{

	/**
	  *模板 表名
	  */
	public static final String TABLE  = "T_TEMPLET";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *模板名称 列名 
	  */
    public static final String COL_templetname  = "C_TEMPLETNAME";
	
	/**
	  *模板内容 列名 
	  */
    public static final String COL_templetmess  = "C_TEMPLETMESS";
	
	/**
	  *模板类型 列名 
	  */
    public static final String COL_templettype  = "C_TEMPLETTYPE";
	
	/**
	  *模板所属业务 列名 
	  */
    public static final String COL_templetyewu  = "C_TEMPLETYEWU";
	
	/**
	  *日期 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
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
    

	//模板名称
	private String templetname;    
    

	//模板内容
	private String templetmess;    
    

	//模板类型
	private String templettype;    
    

	//模板所属业务
	private String templetyewu;    
    

	//日期
	private Timestamp createtime;    
    

	//创建人id
	private Long createuserid;    
    

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
	 * get模板名称
	 */
    public String getTempletname(){
         return templetname;
    }

	/**
	 * set模板名称
	 */
    public void setTempletname(String templetname){
         this.templetname=templetname;
    }

	/**
	 * get模板内容
	 */
    public String getTempletmess(){
         return templetmess;
    }

	/**
	 * set模板内容
	 */
    public void setTempletmess(String templetmess){
         this.templetmess=templetmess;
    }

	/**
	 * get模板类型
	 */
    public String getTemplettype(){
         return templettype;
    }

	/**
	 * set模板类型
	 */
    public void setTemplettype(String templettype){
         this.templettype=templettype;
    }

	/**
	 * get模板所属业务
	 */
    public String getTempletyewu(){
         return templetyewu;
    }

	/**
	 * set模板所属业务
	 */
    public void setTempletyewu(String templetyewu){
         this.templetyewu=templetyewu;
    }

	/**
	 * get日期
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set日期
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get创建人id
	 */
    public Long getCreateuserid(){
         return createuserid;
    }

	/**
	 * set创建人id
	 */
    public void setCreateuserid(Long createuserid){
         this.createuserid=createuserid;
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
	   
	 + templetname +"|"
	   
	 + templetmess +"|"
	   
	 + templettype +"|"
	   
	 + templetyewu +"|"
	   
	 + createtime +"|"
	   
	 + createuserid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
