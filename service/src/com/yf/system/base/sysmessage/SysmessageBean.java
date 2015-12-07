/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.sysmessage;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *消息公告
 */
public class SysmessageBean implements java.io.Serializable{

	/**
	  *消息公告 表名
	  */
	public static final String TABLE  = "T_SYSMESSAGE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
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
	  *创建者ID 列名 
	  */
    public static final String COL_customeruserid  = "C_CUSTOMERUSERID";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *标题 列名 
	  */
    public static final String COL_title  = "C_TITLE";
	
	/**
	  *内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *可见 列名 
	  */
    public static final String COL_users  = "C_USERS";
	
	/**
	  *发布时间 列名 
	  */
    public static final String COL_pubtime  = "C_PUBTIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *截止时间 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";

	//ID
	private long id;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//创建者ID
	private Long customeruserid;    
    

	//类型
	private Integer type;    
    

	//标题
	private String title;    
    

	//内容
	private String content;    
    

	//可见
	private String users;    
    

	//发布时间
	private Timestamp pubtime;    
    

	//状态
	private Integer state;    
    

	//截止时间
	private Timestamp endtime;    
    

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
	 * get创建者ID
	 */
    public Long getCustomeruserid(){
         return customeruserid;
    }

	/**
	 * set创建者ID
	 */
    public void setCustomeruserid(Long customeruserid){
         this.customeruserid=customeruserid;
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
	 * get可见
	 */
    public String getUsers(){
         return users;
    }

	/**
	 * set可见
	 */
    public void setUsers(String users){
         this.users=users;
    }

	/**
	 * get发布时间
	 */
    public Timestamp getPubtime(){
         return pubtime;
    }

	/**
	 * set发布时间
	 */
    public void setPubtime(Timestamp pubtime){
         this.pubtime=pubtime;
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
	 * get截止时间
	 */
    public Timestamp getEndtime(){
         return endtime;
    }

	/**
	 * set截止时间
	 */
    public void setEndtime(Timestamp endtime){
         this.endtime=endtime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + customeruserid +"|"
	   
	 + type +"|"
	   
	 + title +"|"
	   
	 + content +"|"
	   
	 + users +"|"
	   
	 + pubtime +"|"
	   
	 + state +"|"
	   
	 + endtime
	 + "]";
 } 

}
