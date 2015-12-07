/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.adcooperate;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *广告合作表
 */
public class AdcooperateBean implements java.io.Serializable{

	/**
	  *广告合作表 表名
	  */
	public static final String TABLE  = "T_ADCOOPERATE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *单位名称 列名 
	  */
    public static final String COL_copname  = "C_COPNAME";
	
	/**
	  *单位地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *联系人手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *业务内容 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//单位名称
	private String copname;    
    

	//单位地址
	private String address;    
    

	//创建时间
	private Timestamp createtime;    
    

	//联系人姓名
	private String username;    
    

	//联系人手机
	private String mobile;    
    

	//业务内容
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
	 * get单位名称
	 */
    public String getCopname(){
         return copname;
    }

	/**
	 * set单位名称
	 */
    public void setCopname(String copname){
         this.copname=copname;
    }

	/**
	 * get单位地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set单位地址
	 */
    public void setAddress(String address){
         this.address=address;
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

	/**
	 * get联系人姓名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set联系人姓名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get联系人手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set联系人手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get业务内容
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set业务内容
	 */
    public void setComment(String comment){
         this.comment=comment;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + copname +"|"
	   
	 + address +"|"
	   
	 + createtime +"|"
	   
	 + username +"|"
	   
	 + mobile +"|"
	   
	 + comment
	 + "]";
 } 

}
