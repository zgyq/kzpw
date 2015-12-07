/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotellandmark;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店地标
 */
public class HotellandmarkBean implements java.io.Serializable{

	/**
	  *酒店地标 表名
	  */
	public static final String TABLE  = "T_HOTELLANDMARK";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *地标ID 列名 
	  */
    public static final String COL_landmarkid  = "C_LANDMARKID";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *信息 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *距离 列名 
	  */
    public static final String COL_range  = "C_RANGE";
	
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
    

	//地标ID
	private Long landmarkid;    
    

	//酒店ID
	private Long hotelid;    
    

	//信息
	private String description;    
    

	//距离
	private Integer range;    
    

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
	 * get地标ID
	 */
    public Long getLandmarkid(){
         return landmarkid;
    }

	/**
	 * set地标ID
	 */
    public void setLandmarkid(Long landmarkid){
         this.landmarkid=landmarkid;
    }

	/**
	 * get酒店ID
	 */
    public Long getHotelid(){
         return hotelid;
    }

	/**
	 * set酒店ID
	 */
    public void setHotelid(Long hotelid){
         this.hotelid=hotelid;
    }

	/**
	 * get信息
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set信息
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get距离
	 */
    public Integer getRange(){
         return range;
    }

	/**
	 * set距离
	 */
    public void setRange(Integer range){
         this.range=range;
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
	   
	 + landmarkid +"|"
	   
	 + hotelid +"|"
	   
	 + description +"|"
	   
	 + range +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
