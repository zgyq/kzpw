/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.insuruser;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *被保人列表
 */
public class InsuruserBean implements java.io.Serializable{

	/**
	  *被保人列表 表名
	  */
	public static final String TABLE  = "T_INSURUSER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *保险订单id 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *保险单号 列名 
	  */
    public static final String COL_policyno  = "C_POLICYNO";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_sex  = "C_SEX";
	
	/**
	  *证件类型 列名 
	  */
    public static final String COL_codetype  = "C_CODETYPE";
	
	/**
	  *证件号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *手机号码 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *出生日期 列名 
	  */
    public static final String COL_birthday  = "C_BIRTHDAY";
	
	/**
	  *电子邮箱 列名 
	  */
    public static final String COL_email  = "C_EMAIL";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flyno  = "C_FLYNO";
	
	/**
	  *所在城市 列名 
	  */
    public static final String COL_city  = "C_CITY";
	
	/**
	  *航班起飞时间 列名 
	  */
    public static final String COL_flytime  = "C_FLYTIME";
	
	/**
	  *起保时间 列名 
	  */
    public static final String COL_begintime  = "C_BEGINTIME";

	//ID
	private long id;    
    

	//保险订单id
	private Long orderid;    
    

	//保险单号
	private String policyno;    
    

	//姓名
	private String name;    
    

	//性别
	private Long sex;    
    

	//证件类型
	private Long codetype;    
    

	//证件号
	private String code;    
    

	//手机号码
	private String mobile;    
    

	//出生日期
	private Timestamp birthday;    
    

	//电子邮箱
	private String email;    
    

	//航班号
	private String flyno;    
    

	//所在城市
	private String city;    
    

	//航班起飞时间
	private Timestamp flytime;    
    

	//起保时间
	private Timestamp begintime;    
    

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
	 * get保险订单id
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set保险订单id
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get保险单号
	 */
    public String getPolicyno(){
         return policyno;
    }

	/**
	 * set保险单号
	 */
    public void setPolicyno(String policyno){
         this.policyno=policyno;
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
    public Long getSex(){
         return sex;
    }

	/**
	 * set性别
	 */
    public void setSex(Long sex){
         this.sex=sex;
    }

	/**
	 * get证件类型
	 */
    public Long getCodetype(){
         return codetype;
    }

	/**
	 * set证件类型
	 */
    public void setCodetype(Long codetype){
         this.codetype=codetype;
    }

	/**
	 * get证件号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set证件号
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get手机号码
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机号码
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get出生日期
	 */
    public Timestamp getBirthday(){
         return birthday;
    }

	/**
	 * set出生日期
	 */
    public void setBirthday(Timestamp birthday){
         this.birthday=birthday;
    }

	/**
	 * get电子邮箱
	 */
    public String getEmail(){
         return email;
    }

	/**
	 * set电子邮箱
	 */
    public void setEmail(String email){
         this.email=email;
    }

	/**
	 * get航班号
	 */
    public String getFlyno(){
         return flyno;
    }

	/**
	 * set航班号
	 */
    public void setFlyno(String flyno){
         this.flyno=flyno;
    }

	/**
	 * get所在城市
	 */
    public String getCity(){
         return city;
    }

	/**
	 * set所在城市
	 */
    public void setCity(String city){
         this.city=city;
    }

	/**
	 * get航班起飞时间
	 */
    public Timestamp getFlytime(){
         return flytime;
    }

	/**
	 * set航班起飞时间
	 */
    public void setFlytime(Timestamp flytime){
         this.flytime=flytime;
    }

	/**
	 * get起保时间
	 */
    public Timestamp getBegintime(){
         return begintime;
    }

	/**
	 * set起保时间
	 */
    public void setBegintime(Timestamp begintime){
         this.begintime=begintime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + policyno +"|"
	   
	 + name +"|"
	   
	 + sex +"|"
	   
	 + codetype +"|"
	   
	 + code +"|"
	   
	 + mobile +"|"
	   
	 + birthday +"|"
	   
	 + email +"|"
	   
	 + flyno +"|"
	   
	 + city +"|"
	   
	 + flytime +"|"
	   
	 + begintime
	 + "]";
 } 

}
