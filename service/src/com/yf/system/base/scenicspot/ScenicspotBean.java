/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.scenicspot;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *景点
 */
public class ScenicspotBean implements java.io.Serializable{

	/**
	  *景点 表名
	  */
	public static final String TABLE  = "T_SCENICSPOT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *介绍 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_image  = "C_IMAGE";
	
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
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *区域ID 列名 
	  */
    public static final String COL_regionid  = "C_REGIONID";
    
    /**
	  *价格 列名 
	  */
  public static final String COL_price  = "C_PRICE";
	
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//介绍
	private String description;    
    

	//图片
	private String image;    
    

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
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//区域ID
	private Long regionid;    
    
	//价格
	private Double price;    
    
	//城市ID
	private Long cityid;    
    

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
	 * get图片
	 */
    public String getImage(){
         return image;
    }

	/**
	 * set图片
	 */
    public void setImage(String image){
         this.image=image;
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
	 * get区域ID
	 */
    public Long getRegionid(){
         return regionid;
    }

	/**
	 * set区域ID
	 */
    public void setRegionid(Long regionid){
         this.regionid=regionid;
    }

	/**
	 * get城市ID
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set城市ID
	 */
    public void setCityid(Long cityid){
         this.cityid=cityid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + description +"|"
	   
	 + image +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + sort +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + regionid +"|"
	   
	 + cityid
	 + "]";
 }

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	} 

}
