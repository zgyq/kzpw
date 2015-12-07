/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.cityairport;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机场城市
 */
public class CityairportBean implements java.io.Serializable{

	/**
	  *机场城市 表名
	  */
	public static final String TABLE  = "T_CITYAIRPORT";

	
	/**
	  *机场城市ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *城市名称 列名 
	  */
    public static final String COL_cityname  = "C_CITYNAME";
	
	/**
	  *城市拼音 列名 
	  */
    public static final String COL_pinyin  = "C_PINYIN";
	
	/**
	  *城市简拼 列名 
	  */
    public static final String COL_shortpinyin  = "C_SHORTPINYIN";
	
	/**
	  *机场三字代码 列名 
	  */
    public static final String COL_airportcode  = "C_AIRPORTCODE";
	
	/**
	  *机场名称 列名 
	  */
    public static final String COL_airportname  = "C_AIRPORTNAME";
	
	/**
	  *排序字段 列名 
	  */
    public static final String COL_cityindex  = "C_CITYINDEX";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改人 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *是否启用(0=禁用,1=启用) 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
    
    public static final String COL_countrycode="C_COUNTRYCODE";

	//机场城市ID
	private long id;    
    

	//城市名称
	private String cityname;    
    

	//城市拼音
	private String pinyin;    
    

	//城市简拼
	private String shortpinyin;    
    

	//机场三字代码
	private String airportcode;    
    

	//机场名称
	private String airportname;    
    

	//排序字段
	private Integer cityindex;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//是否启用(0=禁用,1=启用)
	private Integer isenable;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;  
	
	//城市代码
	private String countrycode;
    

	/**
	 * get机场城市ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set机场城市ID
	 */
    public void setId(long id){
         this.id=id;
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
	 * get城市拼音
	 */
    public String getPinyin(){
         return pinyin;
    }

	/**
	 * set城市拼音
	 */
    public void setPinyin(String pinyin){
         this.pinyin=pinyin;
    }

	/**
	 * get城市简拼
	 */
    public String getShortpinyin(){
         return shortpinyin;
    }

	/**
	 * set城市简拼
	 */
    public void setShortpinyin(String shortpinyin){
         this.shortpinyin=shortpinyin;
    }

	/**
	 * get机场三字代码
	 */
    public String getAirportcode(){
         return airportcode;
    }

	/**
	 * set机场三字代码
	 */
    public void setAirportcode(String airportcode){
         this.airportcode=airportcode;
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
	 * get排序字段
	 */
    public Integer getCityindex(){
         return cityindex;
    }

	/**
	 * set排序字段
	 */
    public void setCityindex(Integer cityindex){
         this.cityindex=cityindex;
    }

	/**
	 * get创建人
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
	 */
    public void setCreateuser(String createuser){
         this.createuser=createuser;
    }

	/**
	 * get创建时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set创建时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get修改人
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改人
	 */
    public void setModifyuser(String modifyuser){
         this.modifyuser=modifyuser;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getModifytime(){
         return modifytime;
    }

	/**
	 * set修改时间
	 */
    public void setModifytime(Timestamp modifytime){
         this.modifytime=modifytime;
    }

	/**
	 * get是否启用(0=禁用,1=启用)
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set是否启用(0=禁用,1=启用)
	 */
    public void setIsenable(Integer isenable){
         this.isenable=isenable;
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
	   
	 + cityname +"|"
	   
	 + pinyin +"|"
	   
	 + shortpinyin +"|"
	   
	 + airportcode +"|"
	   
	 + airportname +"|"
	   
	 + cityindex +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + isenable +"|"
	   
	 + ucode +"|"
	 
	 + countrycode +"|"
	   
	 + language
	 + "]";
 }

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	} 

}
