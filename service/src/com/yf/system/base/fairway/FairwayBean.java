/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fairway;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票航空公司
 */
public class FairwayBean implements java.io.Serializable{

	/**
	  *国际机票航空公司 表名
	  */
	public static final String TABLE  = "T_FAIRWAY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航空公司名称 列名 
	  */
    public static final String COL_airlinername  = "C_AIRLINERNAME";
	
	/**
	  *航空公司两字代码 列名 
	  */
    public static final String COL_airlinercode  = "C_AIRLINERCODE";
	
	/**
	  *国家两字代码 列名 
	  */
    public static final String COL_countrycode  = "C_COUNTRYCODE";
	
	/**
	  *UCODE 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语种 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//ID
	private long id;    
    

	//航空公司名称
	private String airlinername;    
    

	//航空公司两字代码
	private String airlinercode;    
    

	//国家两字代码
	private String countrycode;    
    

	//UCODE
	private Long ucode;    
    

	//语种
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
	 * get航空公司名称
	 */
    public String getAirlinername(){
         return airlinername;
    }

	/**
	 * set航空公司名称
	 */
    public void setAirlinername(String airlinername){
         this.airlinername=airlinername;
    }

	/**
	 * get航空公司两字代码
	 */
    public String getAirlinercode(){
         return airlinercode;
    }

	/**
	 * set航空公司两字代码
	 */
    public void setAirlinercode(String airlinercode){
         this.airlinercode=airlinercode;
    }

	/**
	 * get国家两字代码
	 */
    public String getCountrycode(){
         return countrycode;
    }

	/**
	 * set国家两字代码
	 */
    public void setCountrycode(String countrycode){
         this.countrycode=countrycode;
    }

	/**
	 * getUCODE
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * setUCODE
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语种
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语种
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + airlinername +"|"
	   
	 + airlinercode +"|"
	   
	 + countrycode +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
