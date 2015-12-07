/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.flightmodel;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机型信息表
 */
public class FlightmodelBean implements java.io.Serializable{

	/**
	  *机型信息表 表名
	  */
	public static final String TABLE  = "T_FLIGHTMODEL";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *机型号 列名 
	  */
    public static final String COL_modelnum  = "C_MODELNUM";
	
	/**
	  *机型名称 列名 
	  */
    public static final String COL_modelname  = "C_MODELNAME";
	
	/**
	  *乘坐人数说明 列名 
	  */
    public static final String COL_ridenum  = "C_RIDENUM";
	
	/**
	  *机型描述 列名 
	  */
    public static final String COL_modeldesc  = "C_MODELDESC";
	
	/**
	  *是否是大飞机 列名 
	  */
    public static final String COL_isbig  = "C_ISBIG";
	
	/**
	  *图片路径 列名 
	  */
    public static final String COL_picpath  = "C_PICPATH";
	
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
    

	//机型号
	private String modelnum;    
    

	//机型名称
	private String modelname;    
    

	//乘坐人数说明
	private String ridenum;    
    

	//机型描述
	private String modeldesc;    
    

	//是否是大飞机
	private Integer isbig;    
    

	//图片路径
	private String picpath;    
    

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
	 * get机型号
	 */
    public String getModelnum(){
         return modelnum;
    }

	/**
	 * set机型号
	 */
    public void setModelnum(String modelnum){
         this.modelnum=modelnum;
    }

	/**
	 * get机型名称
	 */
    public String getModelname(){
         return modelname;
    }

	/**
	 * set机型名称
	 */
    public void setModelname(String modelname){
         this.modelname=modelname;
    }

	/**
	 * get乘坐人数说明
	 */
    public String getRidenum(){
         return ridenum;
    }

	/**
	 * set乘坐人数说明
	 */
    public void setRidenum(String ridenum){
         this.ridenum=ridenum;
    }

	/**
	 * get机型描述
	 */
    public String getModeldesc(){
         return modeldesc;
    }

	/**
	 * set机型描述
	 */
    public void setModeldesc(String modeldesc){
         this.modeldesc=modeldesc;
    }

	/**
	 * get是否是大飞机
	 */
    public Integer getIsbig(){
         return isbig;
    }

	/**
	 * set是否是大飞机
	 */
    public void setIsbig(Integer isbig){
         this.isbig=isbig;
    }

	/**
	 * get图片路径
	 */
    public String getPicpath(){
         return picpath;
    }

	/**
	 * set图片路径
	 */
    public void setPicpath(String picpath){
         this.picpath=picpath;
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
	   
	 + modelnum +"|"
	   
	 + modelname +"|"
	   
	 + ridenum +"|"
	   
	 + modeldesc +"|"
	   
	 + isbig +"|"
	   
	 + picpath +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
