/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelpass;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店常用入住人表
 */
public class HotelpassBean implements java.io.Serializable{

	/**
	  *酒店常用入住人表 表名
	  */
	public static final String TABLE  = "T_HOTELPASS";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_sex  = "C_SEX";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//姓名
	private String name;    
    

	//电话
	private String mobile;    
    

	//性别
	private Long sex;    
    

	//创建人
	private Long createuserid;    
    

	//备注
	private String comment;    
    

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
	 * get姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set姓名
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get电话
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set电话
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get性别
	 */
    public Long getSex(){
         return sex;
    }

	/**
	 * set性别
	 */
    public void setSex(Long sex){
         this.sex=sex;
    }

	/**
	 * get创建人
	 */
    public Long getCreateuserid(){
         return createuserid;
    }

	/**
	 * set创建人
	 */
    public void setCreateuserid(Long createuserid){
         this.createuserid=createuserid;
    }

	/**
	 * get备注
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set备注
	 */
    public void setComment(String comment){
         this.comment=comment;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + mobile +"|"
	   
	 + sex +"|"
	   
	 + createuserid +"|"
	   
	 + comment
	 + "]";
 } 

}
