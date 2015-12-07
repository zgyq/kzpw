/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.trainroom;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *火车售票点
 */
public class TrainroomBean implements java.io.Serializable{

	/**
	  *火车售票点 表名
	  */
	public static final String TABLE  = "T_TRAINROOM";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *地点 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *营业时间 列名 
	  */
    public static final String COL_opentime  = "C_OPENTIME";
    /**
     *营业时间 列名 
     */
    public static final String COL_closetime  = "C_CLOSETIME";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//地点
	private String address;    
    

	//电话
	private String tel;    
    

	//营业时间
	private String opentime;    
	//营业时间
	private String closetime;    
    

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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get地点
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set地点
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get电话
	 */
    public String getTel(){
         return tel;
    }

	/**
	 * set电话
	 */
    public void setTel(String tel){
         this.tel=tel;
    }

	/**
	 * get营业时间
	 */
    public String getOpentime(){
         return opentime;
    }

	/**
	 * set营业时间
	 */
    public void setOpentime(String opentime){
         this.opentime=opentime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + address +"|"
	   
	 + tel +"|"
	   
	 + opentime
	 + "]";
 }

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	} 

}
