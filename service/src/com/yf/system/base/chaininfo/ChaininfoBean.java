/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.chaininfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *连锁酒店类型
 */
public class ChaininfoBean implements java.io.Serializable{

	/**
	  *连锁酒店类型 表名
	  */
	public static final String TABLE  = "T_CHAININFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *图片地址 列名 
	  */
    public static final String COL_imagepic  = "C_IMAGEPIC";
	
	/**
	  *总数 列名 
	  */
    public static final String COL_total  = "C_TOTAL";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_sort  = "C_SORT";
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityidstr  = "C_CITYIDSTR";
	
	/**
	  *图片地址2 列名 
	  */
    public static final String COL_imagepic2  = "C_IMAGEPIC2";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//描述...code
	private String description;    
    

	//图片地址
	private String imagepic;    
    

	//总数
	private String total;    
    

	//排序
	private Long sort;    
    

	//城市ID
	private String cityidstr;
    

	//图片地址2
	private String imagepic2;
    

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

	/**
	 * get图片地址
	 */
    public String getImagepic(){
         return imagepic;
    }

	/**
	 * set图片地址
	 */
    public void setImagepic(String imagepic){
         this.imagepic=imagepic;
    }

	/**
	 * get总数
	 */
    public String getTotal(){
         return total;
    }

	/**
	 * set总数
	 */
    public void setTotal(String total){
         this.total=total;
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
	 * get城市ID
	 */
    public String getCityidstr(){
         return cityidstr;
    }

	/**
	 * set城市ID
	 */
    public void setCityidstr(String cityidstr){
         this.cityidstr=cityidstr;
    }

	/**
	 * get图片地址2
	 */
    public String getImagepic2(){
         return imagepic2;
    }

	/**
	 * set图片地址2
	 */
    public void setImagepic2(String imagepic2){
         this.imagepic2=imagepic2;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + description +"|"
	   
	 + imagepic +"|"
	   
	 + total +"|"
	   
	 + sort +"|"
	   
	 + cityidstr +"|"
	   
	 + imagepic2
	 + "]";
 } 

}
