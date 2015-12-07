/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.giftcatalog;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *礼品目录
 */
public class GiftcatalogBean implements java.io.Serializable{

	/**
	  *礼品目录 表名
	  */
	public static final String TABLE  = "T_GIFTCATALOG";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *目录名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *目录编码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *父目录ID 列名 
	  */
    public static final String COL_parentid  = "C_PARENTID";
	
	/**
	  *父目录ID串 列名 
	  */
    public static final String COL_parentidstr  = "C_PARENTIDSTR";
	
	/**
	  *目录描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
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
    

	//目录名称
	private String name;    
    

	//目录编码
	private String code;    
    

	//父目录ID
	private Long parentid;    
    

	//父目录ID串
	private String parentidstr;    
    

	//目录描述
	private String description;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//状态
	private Long state;    
    

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
	 * get目录名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set目录名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get目录编码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set目录编码
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get父目录ID
	 */
    public Long getParentid(){
         return parentid;
    }

	/**
	 * set父目录ID
	 */
    public void setParentid(Long parentid){
         this.parentid=parentid;
    }

	/**
	 * get父目录ID串
	 */
    public String getParentidstr(){
         return parentidstr;
    }

	/**
	 * set父目录ID串
	 */
    public void setParentidstr(String parentidstr){
         this.parentidstr=parentidstr;
    }

	/**
	 * get目录描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set目录描述
	 */
    public void setDescription(String description){
         this.description=description;
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
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
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
	   
	 + code +"|"
	   
	 + parentid +"|"
	   
	 + parentidstr +"|"
	   
	 + description +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + state +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
