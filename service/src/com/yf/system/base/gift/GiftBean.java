/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.gift;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *礼品
 */
public class GiftBean implements java.io.Serializable{

	/**
	  *礼品 表名
	  */
	public static final String TABLE  = "T_GIFT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *礼品名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *礼品编号 列名 
	  */
    public static final String COL_giftcode  = "C_GIFTCODE";
	
	/**
	  *礼品概述 列名 
	  */
    public static final String COL_giftdesc  = "C_GIFTDESC";
	
	/**
	  *礼品品牌 列名 
	  */
    public static final String COL_brand  = "C_BRAND";
	
	/**
	  *旧所需积分 列名 
	  */
    public static final String COL_oldintegral  = "C_OLDINTEGRAL";
	
	/**
	  *所需积分 列名 
	  */
    public static final String COL_useintegral  = "C_USEINTEGRAL";
	
	/**
	  *礼品图片 列名 
	  */
    public static final String COL_picsrc  = "C_PICSRC";
	
	/**
	  *是否在线 列名 
	  */
    public static final String COL_online  = "C_ONLINE";
	
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
	  *礼品目录 列名 
	  */
    public static final String COL_giftcatalogid  = "C_GIFTCATALOGID";
	
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
    

	//礼品名称
	private String name;    
    

	//礼品编号
	private String giftcode;    
    

	//礼品概述
	private String giftdesc;    
    

	//礼品品牌
	private String brand;    
    

	//旧所需积分
	private Long oldintegral;    
    

	//所需积分
	private Long useintegral;    
    

	//礼品图片
	private String picsrc;    
    

	//是否在线
	private Long online;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//礼品目录
	private Long giftcatalogid;    
    

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
	 * get礼品名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set礼品名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get礼品编号
	 */
    public String getGiftcode(){
         return giftcode;
    }

	/**
	 * set礼品编号
	 */
    public void setGiftcode(String giftcode){
         this.giftcode=giftcode;
    }

	/**
	 * get礼品概述
	 */
    public String getGiftdesc(){
         return giftdesc;
    }

	/**
	 * set礼品概述
	 */
    public void setGiftdesc(String giftdesc){
         this.giftdesc=giftdesc;
    }

	/**
	 * get礼品品牌
	 */
    public String getBrand(){
         return brand;
    }

	/**
	 * set礼品品牌
	 */
    public void setBrand(String brand){
         this.brand=brand;
    }

	/**
	 * get旧所需积分
	 */
    public Long getOldintegral(){
         return oldintegral;
    }

	/**
	 * set旧所需积分
	 */
    public void setOldintegral(Long oldintegral){
         this.oldintegral=oldintegral;
    }

	/**
	 * get所需积分
	 */
    public Long getUseintegral(){
         return useintegral;
    }

	/**
	 * set所需积分
	 */
    public void setUseintegral(Long useintegral){
         this.useintegral=useintegral;
    }

	/**
	 * get礼品图片
	 */
    public String getPicsrc(){
         return picsrc;
    }

	/**
	 * set礼品图片
	 */
    public void setPicsrc(String picsrc){
         this.picsrc=picsrc;
    }

	/**
	 * get是否在线
	 */
    public Long getOnline(){
         return online;
    }

	/**
	 * set是否在线
	 */
    public void setOnline(Long online){
         this.online=online;
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
	 * get礼品目录
	 */
    public Long getGiftcatalogid(){
         return giftcatalogid;
    }

	/**
	 * set礼品目录
	 */
    public void setGiftcatalogid(Long giftcatalogid){
         this.giftcatalogid=giftcatalogid;
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
	   
	 + name +"|"
	   
	 + giftcode +"|"
	   
	 + giftdesc +"|"
	   
	 + brand +"|"
	   
	 + oldintegral +"|"
	   
	 + useintegral +"|"
	   
	 + picsrc +"|"
	   
	 + online +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + giftcatalogid +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
