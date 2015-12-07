/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.ymreceive;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *短信接收表
 */
public class YmreceiveBean implements java.io.Serializable{

	/**
	  *短信接收表 表名
	  */
	public static final String TABLE  = "T_YMRECEIVE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *手机号码 列名 
	  */
    public static final String COL_phone  = "C_PHONE";
	
	/**
	  *短信内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *发送时间 列名 
	  */
    public static final String COL_sendtime  = "C_SENDTIME";
	
	/**
	  *系统时间 列名 
	  */
    public static final String COL_systemtime  = "C_SYSTEMTIME";

	//ID
	private Long id;    
    

	//手机号码
	private String phone;    
    

	//短信内容
	private String content;    
    

	//发送时间
	private Timestamp sendtime;    
    

	//系统时间
	private Timestamp systemtime;    
    

	/**
	 * getID
	 */
    public Long getId(){
         return id;
    }

	/**
	 * setID
	 */
    public void setId(Long id){
         this.id=id;
    }

	/**
	 * get手机号码
	 */
    public String getPhone(){
         return phone;
    }

	/**
	 * set手机号码
	 */
    public void setPhone(String phone){
         this.phone=phone;
    }

	/**
	 * get短信内容
	 */
    public String getContent(){	
         return content;
    }

	/**
	 * set短信内容
	 */
    public void setContent(String content){
         this.content=content;
    }

	/**
	 * get发送时间
	 */
    public Timestamp getSendtime(){
         return sendtime;
    }

	/**
	 * set发送时间
	 */
    public void setSendtime(Timestamp sendtime){
         this.sendtime=sendtime;
    }

	/**
	 * get系统时间
	 */
    public Timestamp getSystemtime(){
         return systemtime;
    }

	/**
	 * set系统时间
	 */
    public void setSystemtime(Timestamp systemtime){
         this.systemtime=systemtime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + phone +"|"
	   
	 + content +"|"
	   
	 + sendtime +"|"
	   
	 + systemtime
	 + "]";
 } 

}
