/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.logindesc;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *登录信息
 */
public class LogindescBean implements java.io.Serializable{

	/**
	  *登录信息 表名
	  */
	public static final String TABLE  = "T_LOGINDESC";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *登录名字 列名 
	  */
    public static final String COL_loginname  = "C_LOGINNAME";
	
	/**
	  *登录ID 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
	/**
	  *登录IP 列名 
	  */
    public static final String COL_loginip  = "C_LOGINIP";
	
	/**
	  *加盟商 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_descinfo  = "C_DESCINFO";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *登录时间 列名 
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
    

	//登录名字
	private String loginname;    
    

	//登录ID
	private Long userid;    
    

	//登录IP
	private String loginip;    
    

	//加盟商
	private Long agentid;    
    

	//备注
	private String descinfo;    
    

	//创建者
	private String createuser;    
    

	//登录时间
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
	 * get登录名字
	 */
    public String getLoginname(){
         return loginname;
    }

	/**
	 * set登录名字
	 */
    public void setLoginname(String loginname){
         this.loginname=loginname;
    }

	/**
	 * get登录ID
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set登录ID
	 */
    public void setUserid(Long userid){
         this.userid=userid;
    }

	/**
	 * get登录IP
	 */
    public String getLoginip(){
         return loginip;
    }

	/**
	 * set登录IP
	 */
    public void setLoginip(String loginip){
         this.loginip=loginip;
    }

	/**
	 * get加盟商
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set加盟商
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get备注
	 */
    public String getDescinfo(){
         return descinfo;
    }

	/**
	 * set备注
	 */
    public void setDescinfo(String descinfo){
         this.descinfo=descinfo;
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
	 * get登录时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set登录时间
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
	   
	 + loginname +"|"
	   
	 + userid +"|"
	   
	 + loginip +"|"
	   
	 + agentid +"|"
	   
	 + descinfo +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
