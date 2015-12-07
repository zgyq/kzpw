/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.noterecorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *通知记录
 */
public class NoterecorderBean implements java.io.Serializable{

	/**
	  *通知记录 表名
	  */
	public static final String TABLE  = "T_NOTERECORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改人 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *发送发 列名 
	  */
    public static final String COL_sender  = "C_SENDER";
	
	/**
	  *接收方 列名 
	  */
    public static final String COL_reciver  = "C_RECIVER";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *标题 列名 
	  */
    public static final String COL_title  = "C_TITLE";
	
	/**
	  *模板ID 列名 
	  */
    public static final String COL_templateid  = "C_TEMPLATEID";
	
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
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//发送发
	private String sender;    
    

	//接收方
	private String reciver;    
    

	//类型
	private Integer type;    
    

	//状态
	private Integer state;    
    

	//内容
	private String content;    
    

	//标题
	private String title;    
    

	//模板ID
	private Long templateid;    
    

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
	 * get创建人
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
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
	 * get修改人
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改人
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
	 * get发送发
	 */
    public String getSender(){
         return sender;
    }

	/**
	 * set发送发
	 */
    public void setSender(String sender){
         this.sender=sender;
    }

	/**
	 * get接收方
	 */
    public String getReciver(){
         return reciver;
    }

	/**
	 * set接收方
	 */
    public void setReciver(String reciver){
         this.reciver=reciver;
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
	 * get模板ID
	 */
    public Long getTemplateid(){
         return templateid;
    }

	/**
	 * set模板ID
	 */
    public void setTemplateid(Long templateid){
         this.templateid=templateid;
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
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + sender +"|"
	   
	 + reciver +"|"
	   
	 + type +"|"
	   
	 + state +"|"
	   
	 + content +"|"
	   
	 + title +"|"
	   
	 + templateid +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
