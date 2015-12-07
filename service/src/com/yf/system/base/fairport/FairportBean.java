/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fairport;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票机场
 */
public class FairportBean implements java.io.Serializable{

	/**
	  *国际机票机场 表名
	  */
	public static final String TABLE  = "T_FAIRPORT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *机场名称 列名 
	  */
    public static final String COL_airportname  = "C_AIRPORTNAME";
	
	/**
	  *城市三字码 列名 
	  */
    public static final String COL_citycode  = "C_CITYCODE";
	
	/**
	  *机场三字码 列名 
	  */
    public static final String COL_airportcode  = "C_AIRPORTCODE";
	
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
    

	//机场名称
	private String airportname;    
    

	//城市三字码
	private String citycode;    
    

	//机场三字码
	private String airportcode;    
    

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
	 * get机场名称
	 */
    public String getAirportname(){
         return airportname;
    }

	/**
	 * set机场名称
	 */
    public void setAirportname(String airportname){
         this.airportname=airportname;
    }

	/**
	 * get城市三字码
	 */
    public String getCitycode(){
         return citycode;
    }

	/**
	 * set城市三字码
	 */
    public void setCitycode(String citycode){
         this.citycode=citycode;
    }

	/**
	 * get机场三字码
	 */
    public String getAirportcode(){
         return airportcode;
    }

	/**
	 * set机场三字码
	 */
    public void setAirportcode(String airportcode){
         this.airportcode=airportcode;
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
	   
	 + airportname +"|"
	   
	 + citycode +"|"
	   
	 + airportcode +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
