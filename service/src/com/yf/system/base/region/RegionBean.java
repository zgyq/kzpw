/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.region;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *区域
 */
public class RegionBean implements java.io.Serializable{

	/**
	  *区域 表名
	  */
	public static final String TABLE  = "T_REGION";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *城市id 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *区县类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *区域id 列名 
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
    

	//城市id
	private Long cityid;    
    

	//区县类型
	private String type;    
    

	//区域id
	private String regionid;    
    

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
	 * get城市id
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set城市id
	 */
    public void setCityid(Long cityid){
         this.cityid=cityid;
    }

	/**
	 * get区县类型
	 */
    public String getType(){
         return type;
    }

	/**
	 * set区县类型
	 */
    public void setType(String type){
         this.type=type;
    }

	/**
	 * get区域id
	 */
    public String getRegionid(){
         return regionid;
    }

	/**
	 * set区域id
	 */
    public void setRegionid(String regionid){
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
