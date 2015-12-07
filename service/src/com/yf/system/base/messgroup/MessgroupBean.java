/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.messgroup;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *短信用户组
 */
public class MessgroupBean implements java.io.Serializable{

	/**
	  *短信用户组 表名
	  */
	public static final String TABLE  = "T_MESSGROUP";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *组名 列名 
	  */
    public static final String COL_messname  = "C_MESSNAME";
	
	/**
	  *用户组号码 列名 
	  */
    public static final String COL_messnums  = "C_MESSNUMS";
	
	/**
	  *日期 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *所属用户id 列名 
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
    

	//组名
	private String messname;    
    

	//用户组号码
	private String messnums;    
    

	//日期
	private Timestamp createtime;    
    

	//所属用户id
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
	 * get组名
	 */
    public String getMessname(){
         return messname;
    }

	/**
	 * set组名
	 */
    public void setMessname(String messname){
         this.messname=messname;
    }

	/**
	 * get用户组号码
	 */
    public String getMessnums(){
         return messnums;
    }

	/**
	 * set用户组号码
	 */
    public void setMessnums(String messnums){
         this.messnums=messnums;
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
	 * get所属用户id
	 */
    public Long getCreateuserid(){
         return createuserid;
    }

	/**
	 * set所属用户id
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
	   
	 + messname +"|"
	   
	 + messnums +"|"
	   
	 + createtime +"|"
	   
	 + createuserid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
