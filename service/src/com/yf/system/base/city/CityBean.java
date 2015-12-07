/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.city;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *地级市
 */
public class CityBean implements java.io.Serializable{

	/**
	  *地级市 表名
	  */
	public static final String TABLE  = "T_CITY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *英文全拼 列名 
	  */
    public static final String COL_enname  = "C_ENNAME";
	
	/**
	  *英文简称 列名 
	  */
    public static final String COL_sname  = "C_SNAME";
	
	/**
	  *酒店城市ID 列名 
	  */
    public static final String COL_sort  = "C_SORT";
	
	/**
	  *省份id 列名 
	  */
    public static final String COL_provinceid  = "C_PROVINCEID";
	
	/**
	  *区号 列名 
	  */
    public static final String COL_areacode  = "C_AREACODE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *国家ID 列名 
	  */
    public static final String COL_countryid  = "C_COUNTRYID";
    
    /**
	  *类型 列名 
	  */
   public static final String COL_type  = "C_TYPE";
   
   /**
	  *租车城市编码  列名 
	  */
   public static final String COL_carcode  = "C_CARCODE";
   
   /**
	  *租车城市有无上门送车  列名 
	  */
   public static final String COL_iscode  = "C_ISCODE";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//英文全拼
	private String enname;    
    

	//英文简称
	private String sname;    
    

	//酒店城市ID
	private Integer sort;    
    

	//省份id
	private Long provinceid;    
    

	//区号
	private String areacode;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//国家ID
	private Long countryid;    
	
	//类型1，酒店 2 ,租车 3,旅游
	private Long type;   
    
	
	//租车城市编码
	private String carcode ; 
	
	
	//租车城市有无送车上门服务   Y  N
	private String iscode ; 

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
	 * get英文全拼
	 */
    public String getEnname(){
         return enname;
    }

	/**
	 * set英文全拼
	 */
    public void setEnname(String enname){
         this.enname=enname;
    }

	/**
	 * get英文简称
	 */
    public String getSname(){
         return sname;
    }

	/**
	 * set英文简称
	 */
    public void setSname(String sname){
         this.sname=sname;
    }

	/**
	 * get优先级
	 */
    public Integer getSort(){
         return sort;
    }

	/**
	 * set优先级
	 */
    public void setSort(Integer sort){
         this.sort=sort;
    }

	/**
	 * get省份id
	 */
    public Long getProvinceid(){
         return provinceid;
    }

	/**
	 * set省份id
	 */
    public void setProvinceid(Long provinceid){
         this.provinceid=provinceid;
    }

	/**
	 * get区号
	 */
    public String getAreacode(){
         return areacode;
    }

	/**
	 * set区号
	 */
    public void setAreacode(String areacode){
         this.areacode=areacode;
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

	/**
	 * get国家ID
	 */
    public Long getLountryid(){
         return countryid;
    }

	/**
	 * set国家ID
	 */
    public void setLountryid(Long countryid){
         this.countryid=countryid;
    }


	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}



	public String getCarcode() {
		return carcode;
	}

	public void setCarcode(String carcode) {
		this.carcode = carcode;
	}

	public String getIscode() {
		return iscode;
	}

	public void setIscode(String iscode) {
		this.iscode = iscode;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + enname +"|"
	   
	 + sname +"|"
	   
	 + sort +"|"
	   
	 + provinceid +"|"
	   
	 + areacode +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	 
	 + type +"|"
	 
	 + carcode +"|"
	 
	 + iscode +"|"
	   
	 + countryid
	 + "]";
 } 

}
