/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.eterminfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *配置表
 */
public class EterminfoBean implements java.io.Serializable{

	/**
	  *配置表 表名
	  */
	public static final String TABLE  = "T_ETERMINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *账号类别 列名 
	  */
    public static final String COL_etermtype  = "C_ETERMTYPE";
	
	/**
	  *配置帐号 列名 
	  */
    public static final String COL_etermaccount  = "C_ETERMACCOUNT";
	
	/**
	  *账号密码 列名 
	  */
    public static final String COL_password  = "C_PASSWORD";
	
	/**
	  *服务器地址 列名 
	  */
    public static final String COL_serverip  = "C_SERVERIP";
	
	/**
	  *服务器端口号 列名 
	  */
    public static final String COL_portnum  = "C_PORTNUM";
	
	/**
	  *SI 列名 
	  */
    public static final String COL_sinum  = "C_SINUM";
	
	/**
	  *打印机序号 列名 
	  */
    public static final String COL_printnum  = "C_PRINTNUM";
	
	/**
	  *所属代理商 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *账号账号 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
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
    

	//账号类别
	private Long etermtype;    
    

	//配置帐号
	private String etermaccount;    
    

	//账号密码
	private String password;    
    

	//服务器地址
	private String serverip;    
    

	//服务器端口号
	private String portnum;    
    

	//SI
	private String sinum;    
    

	//打印机序号
	private String printnum;    
    

	//所属代理商
	private Long agentid;    
    

	//账号账号
	private Long status;    
    

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
	 * get账号类别
	 */
    public Long getEtermtype(){
         return etermtype;
    }

	/**
	 * set账号类别
	 */
    public void setEtermtype(Long etermtype){
         this.etermtype=etermtype;
    }

	/**
	 * get配置帐号
	 */
    public String getEtermaccount(){
         return etermaccount;
    }

	/**
	 * set配置帐号
	 */
    public void setEtermaccount(String etermaccount){
         this.etermaccount=etermaccount;
    }

	/**
	 * get账号密码
	 */
    public String getPassword(){
         return password;
    }

	/**
	 * set账号密码
	 */
    public void setPassword(String password){
         this.password=password;
    }

	/**
	 * get服务器地址
	 */
    public String getServerip(){
         return serverip;
    }

	/**
	 * set服务器地址
	 */
    public void setServerip(String serverip){
         this.serverip=serverip;
    }

	/**
	 * get服务器端口号
	 */
    public String getPortnum(){
         return portnum;
    }

	/**
	 * set服务器端口号
	 */
    public void setPortnum(String portnum){
         this.portnum=portnum;
    }

	/**
	 * getSI
	 */
    public String getSinum(){
         return sinum;
    }

	/**
	 * setSI
	 */
    public void setSinum(String sinum){
         this.sinum=sinum;
    }

	/**
	 * get打印机序号
	 */
    public String getPrintnum(){
         return printnum;
    }

	/**
	 * set打印机序号
	 */
    public void setPrintnum(String printnum){
         this.printnum=printnum;
    }

	/**
	 * get所属代理商
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set所属代理商
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get账号账号
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set账号账号
	 */
    public void setStatus(Long status){
         this.status=status;
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
	   
	 + etermtype +"|"
	   
	 + etermaccount +"|"
	   
	 + password +"|"
	   
	 + serverip +"|"
	   
	 + portnum +"|"
	   
	 + sinum +"|"
	   
	 + printnum +"|"
	   
	 + agentid +"|"
	   
	 + status +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
