/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.eaccount;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *外部账号
 */
public class EaccountBean implements java.io.Serializable{

	/**
	  *外部账号 表名
	  */
	public static final String TABLE  = "T_EACCOUNT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *简介 列名 
	  */
    public static final String COL_edesc  = "C_EDESC";
	
	/**
	  *链接地址 列名 
	  */
    public static final String COL_url  = "C_URL";
	
	/**
	  *通知地址 列名 
	  */
    public static final String COL_nourl  = "C_NOURL";
	
	/**
	  *支付后返回地址 列名 
	  */
    public static final String COL_payurl  = "C_PAYURL";
	
	/**
	  *自动代扣 列名 
	  */
    public static final String COL_ispay  = "C_ISPAY";
	
	/**
	  *账号 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *下级账号(今日) 列名 
	  */
    public static final String COL_xiausername  = "C_XIAUSERNAME";
	
	/**
	  *密钥(今日) 列名 
	  */
    public static final String COL_key  = "C_KEY";
	
	/**
	  *密码 列名 
	  */
    public static final String COL_password  = "C_PASSWORD";
	
	/**
	  *安全码 列名 
	  */
    public static final String COL_pwd  = "C_PWD";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
    
    /**
	  *加盟商ID 列名 
	  */
   public static final String COL_angentid  = "C_ANGENTID";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//简介
	private String edesc;    
    

	//链接地址
	private String url;    
    

	//通知地址
	private String nourl;    
    

	//支付后返回地址
	private String payurl;    
    

	//自动代扣
	private String ispay;    
    

	//账号
	private String username;    
    

	//下级账号(今日)
	private String xiausername;    
    

	//密钥(今日)
	private String key;    
    

	//密码
	private String password;    
    

	//安全码
	private String pwd;    
    

	//状态
	private String state;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
	
	//加盟商ID
	private Integer angentid;    
    

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
	 * get简介
	 */
    public String getEdesc(){
         return edesc;
    }

	/**
	 * set简介
	 */
    public void setEdesc(String edesc){
         this.edesc=edesc;
    }

	/**
	 * get链接地址
	 */
    public String getUrl(){
         return url;
    }

	/**
	 * set链接地址
	 */
    public void setUrl(String url){
         this.url=url;
    }

	/**
	 * get通知地址
	 */
    public String getNourl(){
         return nourl;
    }

	/**
	 * set通知地址
	 */
    public void setNourl(String nourl){
         this.nourl=nourl;
    }

	/**
	 * get支付后返回地址
	 */
    public String getPayurl(){
         return payurl;
    }

	/**
	 * set支付后返回地址
	 */
    public void setPayurl(String payurl){
         this.payurl=payurl;
    }

	/**
	 * get自动代扣
	 */
    public String getIspay(){
         return ispay;
    }

	/**
	 * set自动代扣
	 */
    public void setIspay(String ispay){
         this.ispay=ispay;
    }

	/**
	 * get账号
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set账号
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get下级账号(今日)
	 */
    public String getXiausername(){
         return xiausername;
    }

	/**
	 * set下级账号(今日)
	 */
    public void setXiausername(String xiausername){
         this.xiausername=xiausername;
    }

	/**
	 * get密钥(今日)
	 */
    public String getKey(){
         return key;
    }

	/**
	 * set密钥(今日)
	 */
    public void setKey(String key){
         this.key=key;
    }

	/**
	 * get密码
	 */
    public String getPassword(){
         return password;
    }

	/**
	 * set密码
	 */
    public void setPassword(String password){
         this.password=password;
    }

	/**
	 * get安全码
	 */
    public String getPwd(){
         return pwd;
    }

	/**
	 * set安全码
	 */
    public void setPwd(String pwd){
         this.pwd=pwd;
    }

	/**
	 * get状态
	 */
    public String getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(String state){
         this.state=state;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + edesc +"|"
	   
	 + url +"|"
	   
	 + nourl +"|"
	   
	 + payurl +"|"
	   
	 + ispay +"|"
	   
	 + username +"|"
	   
	 + xiausername +"|"
	   
	 + key +"|"
	   
	 + password +"|"
	   
	 + pwd +"|"
	   
	 + state +"|"
	   
	 + createuser +"|"
	 
	 + angentid +"|"
	   
	 + createtime
	 + "]";
 }

	public Integer getAngentid() {
		return angentid;
	}

	public void setAngentid(Integer angentid) {
		this.angentid = angentid;
	} 

}
