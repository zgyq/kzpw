/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.triprange;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *行程
 */
public class TriprangeBean implements java.io.Serializable{

	/**
	  *行程 表名
	  */
	public static final String TABLE  = "T_TRIPRANGE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *线路ID 列名 
	  */
    public static final String COL_triplineid  = "C_TRIPLINEID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_sort  = "C_SORT";
	
	/**
	  *介绍 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_imagepath  = "C_IMAGEPATH";

	//ID
	private long id;    
    

	//线路ID
	private Long triplineid;    
    

	//名称
	private String name;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//排序
	private Long sort;    
    

	//介绍
	private String description;    
    

	//类型
	private Integer type;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//图片
	private String imagepath;    
    

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
	 * get线路ID
	 */
    public Long getTriplineid(){
         return triplineid;
    }

	/**
	 * set线路ID
	 */
    public void setTriplineid(Long triplineid){
         this.triplineid=triplineid;
    }

	/**
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
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
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
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
	 * get排序
	 */
    public Long getSort(){
         return sort;
    }

	/**
	 * set排序
	 */
    public void setSort(Long sort){
         this.sort=sort;
    }

	/**
	 * get介绍
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set介绍
	 */
    public void setDescription(String description){
         this.description=description;
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

	/**
	 * get图片
	 */
    public String getImagepath(){
         return imagepath;
    }

	/**
	 * set图片
	 */
    public void setImagepath(String imagepath){
         this.imagepath=imagepath;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + triplineid +"|"
	   
	 + name +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + sort +"|"
	   
	 + description +"|"
	   
	 + type +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + imagepath
	 + "]";
 } 

}
