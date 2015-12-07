/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.txuserinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *用户信息
 */
public class TxuserinfoBean implements java.io.Serializable{

	/**
	  *用户信息 表名
	  */
	public static final String TABLE  = "T_TXUSERINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *登陆账号 列名 
	  */
    public static final String COL_loginname  = "C_LOGINNAME";
	
	/**
	  *登陆密码 列名 
	  */
    public static final String COL_loginpwd  = "C_LOGINPWD";
	
	/**
	  *父ID 列名 
	  */
    public static final String COL_pid  = "C_PID";
	
	/**
	  *父ID串 列名 
	  */
    public static final String COL_pidstr  = "C_PIDSTR";
	
	/**
	  *费率 列名 
	  */
    public static final String COL_feilv  = "C_FEILV";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *支付宝账号 列名 
	  */
    public static final String COL_alipayname  = "C_ALIPAYNAME";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_beizhu  = "C_BEIZHU";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//登陆账号
	private String loginname;    
    

	//登陆密码
	private String loginpwd;    
    

	//父ID
	private Long pid;    
    

	//父ID串
	private String pidstr;    
    

	//费率
	private String feilv;    
    

	//姓名
	private String name;    
    

	//支付宝账号
	private String alipayname;    
    

	//备注
	private String beizhu;    
    

	//地址
	private String address;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

	//会员ID
	private Long memberid;    
    

	//类型
	private Long type;    
    

	//状态
	private Long state;    
    

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
	 * get登陆账号
	 */
    public String getLoginname(){
         return loginname;
    }

	/**
	 * set登陆账号
	 */
    public void setLoginname(String loginname){
         this.loginname=loginname;
    }

	/**
	 * get登陆密码
	 */
    public String getLoginpwd(){
         return loginpwd;
    }

	/**
	 * set登陆密码
	 */
    public void setLoginpwd(String loginpwd){
         this.loginpwd=loginpwd;
    }

	/**
	 * get父ID
	 */
    public Long getPid(){
         return pid;
    }

	/**
	 * set父ID
	 */
    public void setPid(Long pid){
         this.pid=pid;
    }

	/**
	 * get父ID串
	 */
    public String getPidstr(){
         return pidstr;
    }

	/**
	 * set父ID串
	 */
    public void setPidstr(String pidstr){
         this.pidstr=pidstr;
    }

	/**
	 * get费率
	 */
    public String getFeilv(){
         return feilv;
    }

	/**
	 * set费率
	 */
    public void setFeilv(String feilv){
         this.feilv=feilv;
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
	 * get支付宝账号
	 */
    public String getAlipayname(){
         return alipayname;
    }

	/**
	 * set支付宝账号
	 */
    public void setAlipayname(String alipayname){
         this.alipayname=alipayname;
    }

	/**
	 * get备注
	 */
    public String getBeizhu(){
         return beizhu;
    }

	/**
	 * set备注
	 */
    public void setBeizhu(String beizhu){
         this.beizhu=beizhu;
    }

	/**
	 * get地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
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
	 * get会员ID
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set会员ID
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
    }

	/**
	 * get类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Long type){
         this.type=type;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + loginname +"|"
	   
	 + loginpwd +"|"
	   
	 + pid +"|"
	   
	 + pidstr +"|"
	   
	 + feilv +"|"
	   
	 + name +"|"
	   
	 + alipayname +"|"
	   
	 + beizhu +"|"
	   
	 + address +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + type +"|"
	   
	 + state
	 + "]";
 } 

}
