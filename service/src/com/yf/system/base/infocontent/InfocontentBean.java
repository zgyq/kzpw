/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.infocontent;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *信息
 */
public class InfocontentBean implements java.io.Serializable{

	/**
	  *信息 表名
	  */
	public static final String TABLE  = "T_INFOCONTENT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *标题 列名 
	  */
    public static final String COL_title  = "C_TITLE";
	
	/**
	  *内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *信息类型 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
	
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

	//ID
	private long id;    
    

	//标题
	private String title;    
    

	//内容
	private String content;    
    

	//信息类型
	private Integer typeid;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

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
	 * get标题
	 */
    public String getTitle(){
         return title;
    }

	/**
	 * set标题
	 */
    public void setTitle(String title){
         this.title=title;
    }

	/**
	 * get内容
	 */
    public String getContent(){
         return content;
    }

	/**
	 * set内容
	 */
    public void setContent(String content){
         this.content=content;
    }

	/**
	 * get信息类型
	 */
    public Integer getTypeid(){
         return typeid;
    }

	/**
	 * set信息类型
	 */
    public void setTypeid(Integer typeid){
         this.typeid=typeid;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + title +"|"
	   
	 + content +"|"
	   
	 + typeid +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
