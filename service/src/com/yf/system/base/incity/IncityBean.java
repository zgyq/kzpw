/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.incity;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际城市表
 */
public class IncityBean implements java.io.Serializable{

	/**
	  *国际城市表 表名
	  */
	public static final String TABLE  = "T_INCITY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名字 列名 
	  */
    public static final String COL_name  = "C_NAME";
    
    /**
	  *	中文名字 列名 
	  */
   public static final String COL_zhname  = "C_	ZHNAME";
   
	
	/**
	  *简介 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
	/**
	  *MRegion 列名 
	  */
    public static final String COL_mregion  = "C_MREGION";
	
	/**
	  *Nr 列名 
	  */
    public static final String COL_nr  = "C_NR";
	
	/**
	  *PCRange 列名 
	  */
    public static final String COL_pcrRange  = "C_PCRANGE";
	
	/**
	  *lat_long 列名 
	  */
    public static final String COL_latlong  = "C_LATLONG";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *国家ID 列名 
	  */
    public static final String COL_countryid  = "C_COUNTRYID";

	//ID
	private long id;    
    

	//名字
	private String name;    
    
	
	//中文名字
	private String zhname;  

	//简介
	private String desc;    
    

	//MRegion
	private String mregion;    
    

	//Nr
	private String nr;    
    

	//PCRange
	private String pcrRange;    
    

	//lat_long
	private String latlong;    
    

	//创建时间
	private Timestamp createtime;    
    

	//类型
	private Long type;    
    

	//国家ID
	private Long countryid;    
    

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
	 * get名字
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名字
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get简介
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set简介
	 */
    public void setDesc(String desc){
         this.desc=desc;
    }

	/**
	 * getMRegion
	 */
    public String getMregion(){
         return mregion;
    }

	/**
	 * setMRegion
	 */
    public void setMregion(String mregion){
         this.mregion=mregion;
    }

	/**
	 * getNr
	 */
    public String getNr(){
         return nr;
    }

	/**
	 * setNr
	 */
    public void setNr(String nr){
         this.nr=nr;
    }

	/**
	 * getPCRange
	 */
    public String getPcrange(){
         return pcrRange;
    }

	/**
	 * setPCRange
	 */
    public void setPcrange(String pcrRange){
         this.pcrRange=pcrRange;
    }

	/**
	 * getlat_long
	 */
    public String getLatlong(){
         return latlong;
    }

	/**
	 * setlat_long
	 */
    public void setLatlong(String latlong){
         this.latlong=latlong;
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
	 * get类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get国家ID
	 */
    public Long getCountryid(){
         return countryid;
    }

	/**
	 * set国家ID
	 */
    public void setCountryid(Long countryid){
         this.countryid=countryid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	 
	 + zhname +"|"
	   
	 + desc +"|"
	   
	 + mregion +"|"
	   
	 + nr +"|"
	   
	 + pcrRange +"|"
	   
	 + latlong +"|"
	   
	 + createtime +"|"
	   
	 + type +"|"
	   
	 + countryid
	 + "]";
 }

	public String getZhname() {
		return zhname;
	}

	public void setZhname(String zhname) {
		this.zhname = zhname;
	} 

}
