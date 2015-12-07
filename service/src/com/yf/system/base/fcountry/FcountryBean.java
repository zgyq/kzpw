/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fcountry;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票国家
 */
public class FcountryBean implements java.io.Serializable{

	/**
	  *国际机票国家 表名
	  */
	public static final String TABLE  = "T_FCOUNTRY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *国家代码 列名 
	  */
    public static final String COL_countrycode  = "C_COUNTRYCODE";
	
	/**
	  *国家名称 列名 
	  */
    public static final String COL_countryname  = "C_COUNTRYNAME";
	
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
    

	//国家代码
	private String countrycode;    
    

	//国家名称
	private String countryname;    
    

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
	 * get国家代码
	 */
    public String getCountrycode(){
         return countrycode;
    }

	/**
	 * set国家代码
	 */
    public void setCountrycode(String countrycode){
         this.countrycode=countrycode;
    }

	/**
	 * get国家名称
	 */
    public String getCountryname(){
         return countryname;
    }

	/**
	 * set国家名称
	 */
    public void setCountryname(String countryname){
         this.countryname=countryname;
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
	   
	 + countrycode +"|"
	   
	 + countryname +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
