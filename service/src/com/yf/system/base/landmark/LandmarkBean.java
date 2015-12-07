/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.landmark;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *地标
 */
public class LandmarkBean implements java.io.Serializable{

	/**
	  *地标 表名
	  */
	public static final String TABLE  = "T_LANDMARK";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *区域ID 列名 
	  */
    public static final String COL_regionid  = "C_REGIONID";
	
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
    

	//城市ID
	private Long cityid;    
    

	//类型
	private String type;    
    

	//区域ID
	private Long regionid;    
    

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
	 * get城市ID
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set城市ID
	 */
    public void setCityid(Long cityid){
         this.cityid=cityid;
    }

	/**
	 * get类型
	 */
    public String getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(String type){
         this.type=type;
    }

	/**
	 * get区域ID
	 */
    public Long getRegionid(){
         return regionid;
    }

	/**
	 * set区域ID
	 */
    public void setRegionid(Long regionid){
         this.regionid=regionid;
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
	   
	 + cityid +"|"
	   
	 + type +"|"
	   
	 + regionid +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
