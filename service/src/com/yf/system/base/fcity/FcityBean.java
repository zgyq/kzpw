/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fcity;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票城市
 */
public class FcityBean implements java.io.Serializable{

	/**
	  *国际机票城市 表名
	  */
	public static final String TABLE  = "T_FCITY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *城市代码 列名 
	  */
    public static final String COL_citycode  = "C_CITYCODE";
	
	/**
	  *城市名称 列名 
	  */
    public static final String COL_cityname  = "C_CITYNAME";
	
	/**
	  *城市英文名称 列名 
	  */
    public static final String COL_citynameen  = "C_CITYNAMEEN";
	
	/**
	  *国家两字代码 列名 
	  */
    public static final String COL_countrycode  = "C_COUNTRYCODE";
	
	/**
	  *排序字段 列名 
	  */
    public static final String COL_index  = "C_INDEX";
	
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
    

	//城市代码
	private String citycode;    
    

	//城市名称
	private String cityname;    
    

	//城市英文名称
	private String citynameen;    
    

	//国家两字代码
	private String countrycode;    
    

	//排序字段
	private Integer index;    
    

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
	 * get城市代码
	 */
    public String getCitycode(){
         return citycode;
    }

	/**
	 * set城市代码
	 */
    public void setCitycode(String citycode){
         this.citycode=citycode;
    }

	/**
	 * get城市名称
	 */
    public String getCityname(){
         return cityname;
    }

	/**
	 * set城市名称
	 */
    public void setCityname(String cityname){
         this.cityname=cityname;
    }

	/**
	 * get城市英文名称
	 */
    public String getCitynameen(){
         return citynameen;
    }

	/**
	 * set城市英文名称
	 */
    public void setCitynameen(String citynameen){
         this.citynameen=citynameen;
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
	 * get排序字段
	 */
    public Integer getIndex(){
         return index;
    }

	/**
	 * set排序字段
	 */
    public void setIndex(Integer index){
         this.index=index;
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
	   
	 + citycode +"|"
	   
	 + cityname +"|"
	   
	 + citynameen +"|"
	   
	 + countrycode +"|"
	   
	 + index +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
