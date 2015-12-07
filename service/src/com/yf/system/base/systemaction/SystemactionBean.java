/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.systemaction;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *系统用户行为
 */
public class SystemactionBean implements java.io.Serializable{

	/**
	  *系统用户行为 表名
	  */
	public static final String TABLE  = "T_SYSTEMACTION";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *用户名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *操作名称 列名 
	  */
    public static final String COL_actionname  = "C_ACTIONNAME";
	
	/**
	  *操作代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *操作参数 列名 
	  */
    public static final String COL_para  = "C_PARA";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *用户IP 列名 
	  */
    public static final String COL_ip  = "C_IP";
	
	/**
	  *行为描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *级别 列名 
	  */
    public static final String COL_lever  = "C_LEVER";
	
	/**
	  *类别 列名 
	  */
    public static final String COL_type  = "C_TYPE";

	//ID
	private long id;    
    

	//用户名
	private String username;    
    

	//操作名称
	private String actionname;    
    

	//操作代码
	private String code;    
    

	//操作参数
	private String para;    
    

	//创建时间
	private Timestamp createtime;    
    

	//用户IP
	private String ip;    
    

	//行为描述
	private String description;    
    

	//级别
	private Integer lever;    
    

	//类别
	private Integer type;    
    

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
	 * get用户名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set用户名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get操作名称
	 */
    public String getActionname(){
         return actionname;
    }

	/**
	 * set操作名称
	 */
    public void setActionname(String actionname){
         this.actionname=actionname;
    }

	/**
	 * get操作代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set操作代码
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get操作参数
	 */
    public String getPara(){
         return para;
    }

	/**
	 * set操作参数
	 */
    public void setPara(String para){
         this.para=para;
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
	 * get用户IP
	 */
    public String getIp(){
         return ip;
    }

	/**
	 * set用户IP
	 */
    public void setIp(String ip){
         this.ip=ip;
    }

	/**
	 * get行为描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set行为描述
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get级别
	 */
    public Integer getLever(){
         return lever;
    }

	/**
	 * set级别
	 */
    public void setLever(Integer lever){
         this.lever=lever;
    }

	/**
	 * get类别
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set类别
	 */
    public void setType(Integer type){
         this.type=type;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + username +"|"
	   
	 + actionname +"|"
	   
	 + code +"|"
	   
	 + para +"|"
	   
	 + createtime +"|"
	   
	 + ip +"|"
	   
	 + description +"|"
	   
	 + lever +"|"
	   
	 + type
	 + "]";
 } 

}
