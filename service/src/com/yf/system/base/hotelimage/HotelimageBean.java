/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelimage;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店图片
 */
public class HotelimageBean implements java.io.Serializable{

	/**
	  *酒店图片 表名
	  */
	public static final String TABLE  = "T_HOTELIMAGE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_path  = "C_PATH";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
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
    

	//地址
	private String path;    
    

	//类型
	private Integer type;    
    

	//描述
	private String description;    
    

	//酒店ID
	private Long hotelid;    
    

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
	 * get地址
	 */
    public String getPath(){
         return path;
    }

	/**
	 * set地址
	 */
    public void setPath(String path){
         this.path=path;
    }

	/**
	 * get类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set描述
	 */
    public void setDescription(String description){
         this.description=description;
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
	   
	 + path +"|"
	   
	 + type +"|"
	   
	 + description +"|"
	   
	 + hotelid +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
