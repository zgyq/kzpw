/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotellinkman;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店联系人
 */
public class HotellinkmanBean implements java.io.Serializable{

	/**
	  *酒店联系人 表名
	  */
	public static final String TABLE  = "T_HOTELLINKMAN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_sex  = "C_SEX";
	
	/**
	  *职务 列名 
	  */
    public static final String COL_duty  = "C_DUTY";
	
	/**
	  *座机 列名 
	  */
    public static final String COL_tell  = "C_TELL";
	
	/**
	  *手机 列名 
	  */
    public static final String COL_mobil  = "C_MOBIL";
	
	/**
	  *传真 列名 
	  */
    public static final String COL_fax  = "C_FAX";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
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
    

	//姓名
	private String name;    
    

	//性别
	private Integer sex;    
    

	//职务
	private String duty;    
    

	//座机
	private String tell;    
    

	//手机
	private String mobil;    
    

	//传真
	private String fax;    
    

	//酒店ID
	private Long hotelid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建者
	private String createuser;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//状态
	private Integer state;    
    

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
	 * get姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set姓名
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get性别
	 */
    public Integer getSex(){
         return sex;
    }

	/**
	 * set性别
	 */
    public void setSex(Integer sex){
         this.sex=sex;
    }

	/**
	 * get职务
	 */
    public String getDuty(){
         return duty;
    }

	/**
	 * set职务
	 */
    public void setDuty(String duty){
         this.duty=duty;
    }

	/**
	 * get座机
	 */
    public String getTell(){
         return tell;
    }

	/**
	 * set座机
	 */
    public void setTell(String tell){
         this.tell=tell;
    }

	/**
	 * get手机
	 */
    public String getMobil(){
         return mobil;
    }

	/**
	 * set手机
	 */
    public void setMobil(String mobil){
         this.mobil=mobil;
    }

	/**
	 * get传真
	 */
    public String getFax(){
         return fax;
    }

	/**
	 * set传真
	 */
    public void setFax(String fax){
         this.fax=fax;
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
	 * get状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Integer state){
         this.state=state;
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
	   
	 + sex +"|"
	   
	 + duty +"|"
	   
	 + tell +"|"
	   
	 + mobil +"|"
	   
	 + fax +"|"
	   
	 + hotelid +"|"
	   
	 + createtime +"|"
	   
	 + createuser +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + state +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
