/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.conferencehotel;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *会议酒店
 */
public class ConferencehotelBean implements java.io.Serializable{

	/**
	  *会议酒店 表名
	  */
	public static final String TABLE  = "T_CONFERENCEHOTEL";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *星级 列名 
	  */
    public static final String COL_star  = "C_STAR";
	
	/**
	  *会议厅个数 列名 
	  */
    public static final String COL_hallnum  = "C_HALLNUM";
	
	/**
	  *城市 列名 
	  */
    public static final String COL_city  = "C_CITY";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_phone  = "C_PHONE";
	
	/**
	  *介绍 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_pic  = "C_PIC";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//星级
	private String star;    
    

	//会议厅个数
	private Long hallnum;    
    

	//城市
	private String city;    
    

	//地址
	private String address;    
    

	//电话
	private String phone;    
    

	//介绍
	private String desc;    
    

	//图片
	private String pic;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

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
	 * get星级
	 */
    public String getStar(){
         return star;
    }

	/**
	 * set星级
	 */
    public void setStar(String star){
         this.star=star;
    }

	/**
	 * get会议厅个数
	 */
    public Long getHallnum(){
         return hallnum;
    }

	/**
	 * set会议厅个数
	 */
    public void setHallnum(Long hallnum){
         this.hallnum=hallnum;
    }

	/**
	 * get城市
	 */
    public String getCity(){
         return city;
    }

	/**
	 * set城市
	 */
    public void setCity(String city){
         this.city=city;
    }

	/**
	 * get地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get电话
	 */
    public String getPhone(){
         return phone;
    }

	/**
	 * set电话
	 */
    public void setPhone(String phone){
         this.phone=phone;
    }

	/**
	 * get介绍
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set介绍
	 */
    public void setDesc(String desc){
         this.desc=desc;
    }

	/**
	 * get图片
	 */
    public String getPic(){
         return pic;
    }

	/**
	 * set图片
	 */
    public void setPic(String pic){
         this.pic=pic;
    }

	/**
	 * get父编号
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * set父编号
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语言类型
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + star +"|"
	   
	 + hallnum +"|"
	   
	 + city +"|"
	   
	 + address +"|"
	   
	 + phone +"|"
	   
	 + desc +"|"
	   
	 + pic +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
