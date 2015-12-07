/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.advertisement;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *广告表
 */
public class AdvertisementBean implements java.io.Serializable{

	/**
	  *广告表 表名
	  */
	public static final String TABLE  = "T_ADVERTISEMENT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *图片地址 列名 
	  */
    public static final String COL_picsrc  = "C_PICSRC";
	
	/**
	  *连接地址 列名 
	  */
    public static final String COL_urlsrc  = "C_URLSRC";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_sort  = "C_SORT";
	
	/**
	  *位置 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";

	//ID
	private long id;    
    

	//图片地址
	private String picsrc;    
    

	//连接地址
	private String urlsrc;    
    

	//排序
	private Long sort;    
    

	//位置
	private Long type;    
    

	//描述
	private String description;    
    

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
	 * get图片地址
	 */
    public String getPicsrc(){
         return picsrc;
    }

	/**
	 * set图片地址
	 */
    public void setPicsrc(String picsrc){
         this.picsrc=picsrc;
    }

	/**
	 * get连接地址
	 */
    public String getUrlsrc(){
         return urlsrc;
    }

	/**
	 * set连接地址
	 */
    public void setUrlsrc(String urlsrc){
         this.urlsrc=urlsrc;
    }

	/**
	 * get排序
	 */
    public Long getSort(){
         return sort;
    }

	/**
	 * set排序
	 */
    public void setSort(Long sort){
         this.sort=sort;
    }

	/**
	 * get位置
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set位置
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set描述
	 */
    public void setDescription(String description){
         this.description=description;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + picsrc +"|"
	   
	 + urlsrc +"|"
	   
	 + sort +"|"
	   
	 + type +"|"
	   
	 + description
	 + "]";
 } 

}
