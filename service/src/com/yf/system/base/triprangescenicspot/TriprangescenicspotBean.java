/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.triprangescenicspot;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *行程景点关联
 */
public class TriprangescenicspotBean implements java.io.Serializable{

	/**
	  *行程景点关联 表名
	  */
	public static final String TABLE  = "T_TRIPRANGESCENICSPOT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *行程ID 列名 
	  */
    public static final String COL_triprangeid  = "C_TRIPRANGEID";
	
	/**
	  *景点ID 列名 
	  */
    public static final String COL_scenicspotid  = "C_SCENICSPOTID";
	
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
    

	//行程ID
	private Long triprangeid;    
    

	//景点ID
	private Long scenicspotid;    
    

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
	 * get行程ID
	 */
    public Long getTriprangeid(){
         return triprangeid;
    }

	/**
	 * set行程ID
	 */
    public void setTriprangeid(Long triprangeid){
         this.triprangeid=triprangeid;
    }

	/**
	 * get景点ID
	 */
    public Long getScenicspotid(){
         return scenicspotid;
    }

	/**
	 * set景点ID
	 */
    public void setScenicspotid(Long scenicspotid){
         this.scenicspotid=scenicspotid;
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
	   
	 + triprangeid +"|"
	   
	 + scenicspotid +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
