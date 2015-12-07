/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.tickctspa;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *票务温泉
 */
public class TickctspaBean implements java.io.Serializable{

	/**
	  *票务温泉 表名
	  */
	public static final String TABLE  = "T_TICKCTSPA";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *有效期 列名 
	  */
    public static final String COL_period  = "C_PERIOD";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *门市价 列名 
	  */
    public static final String COL_homeprice  = "C_HOMEPRICE";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_pic  = "C_PIC";
	
	/**
	  *图片2 列名 
	  */
    public static final String COL_pic2  = "C_PIC2";
	
	/**
	  *图片3 列名 
	  */
    public static final String COL_pic3  = "C_PIC3";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//价格
	private Double price;    
    

	//有效期
	private String period;    
    

	//备注
	private String desc;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建者
	private String createuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//修改者
	private String modifyuser;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//门市价
	private Long homeprice;    
    

	//图片
	private String pic;    
    

	//图片2
	private String pic2;    
    

	//图片3
	private String pic3;    
    

	//描述
	private String description;    
    

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
	 * get价格
	 */
    public Double getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(Double price){
         this.price=price;
    }

	/**
	 * get有效期
	 */
    public String getPeriod(){
         return period;
    }

	/**
	 * set有效期
	 */
    public void setPeriod(String period){
         this.period=period;
    }

	/**
	 * get备注
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set备注
	 */
    public void setDesc(String desc){
         this.desc=desc;
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
	 * get门市价
	 */
    public Long getHomeprice(){
         return homeprice;
    }

	/**
	 * set门市价
	 */
    public void setHomeprice(Long homeprice){
         this.homeprice=homeprice;
    }

	/**
	 * get图片
	 */
    public String getPic(){
         return pic;
    }

	/**
	 * set图片
	 */
    public void setPic(String pic){
         this.pic=pic;
    }

	/**
	 * get图片2
	 */
    public String getPic2(){
         return pic2;
    }

	/**
	 * set图片2
	 */
    public void setPic2(String pic2){
         this.pic2=pic2;
    }

	/**
	 * get图片3
	 */
    public String getPic3(){
         return pic3;
    }

	/**
	 * set图片3
	 */
    public void setPic3(String pic3){
         this.pic3=pic3;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + price +"|"
	   
	 + period +"|"
	   
	 + desc +"|"
	   
	 + createtime +"|"
	   
	 + createuser +"|"
	   
	 + modifytime +"|"
	   
	 + modifyuser +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + homeprice +"|"
	   
	 + pic +"|"
	   
	 + pic2 +"|"
	   
	 + pic3 +"|"
	   
	 + description
	 + "]";
 } 

}
