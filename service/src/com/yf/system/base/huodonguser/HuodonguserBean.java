/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.huodonguser;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *活动会员
 */
public class HuodonguserBean implements java.io.Serializable{

	/**
	  *活动会员 表名
	  */
	public static final String TABLE  = "T_HUODONGUSER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *登录名 列名 
	  */
    public static final String COL_loginname  = "C_LOGINNAME";
	
	/**
	  *密码 列名 
	  */
    public static final String COL_loginpwd  = "C_LOGINPWD";
	
	/**
	  *证件类型 列名 
	  */
    public static final String COL_idtype  = "C_IDTYPE";
	
	/**
	  *证件号码 列名 
	  */
    public static final String COL_idnumber  = "C_IDNUMBER";
	
	/**
	  *区号 列名 
	  */
    public static final String COL_areacode  = "C_AREACODE";
	
	/**
	  *号码 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *手机号 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *电子邮件 列名 
	  */
    public static final String COL_mail  = "C_MAIL";
	
	/**
	  *邮政编码 列名 
	  */
    public static final String COL_postalcode  = "C_POSTALCODE";
	
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
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//姓名
	private String name;    
    

	//登录名
	private String loginname;    
    

	//密码
	private String loginpwd;    
    

	//证件类型
	private Long idtype;    
    

	//证件号码
	private String idnumber;    
    

	//区号
	private String areacode;    
    

	//号码
	private String tel;    
    

	//手机号
	private String mobile;    
    

	//电子邮件
	private String mail;    
    

	//邮政编码
	private String postalcode;    
    

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
	 * get登录名
	 */
    public String getLoginname(){
         return loginname;
    }

	/**
	 * set登录名
	 */
    public void setLoginname(String loginname){
         this.loginname=loginname;
    }

	/**
	 * get密码
	 */
    public String getLoginpwd(){
         return loginpwd;
    }

	/**
	 * set密码
	 */
    public void setLoginpwd(String loginpwd){
         this.loginpwd=loginpwd;
    }

	/**
	 * get证件类型
	 */
    public Long getIdtype(){
         return idtype;
    }

	/**
	 * set证件类型
	 */
    public void setIdtype(Long idtype){
         this.idtype=idtype;
    }

	/**
	 * get证件号码
	 */
    public String getIdnumber(){
         return idnumber;
    }

	/**
	 * set证件号码
	 */
    public void setIdnumber(String idnumber){
         this.idnumber=idnumber;
    }

	/**
	 * get区号
	 */
    public String getAreacode(){
         return areacode;
    }

	/**
	 * set区号
	 */
    public void setAreacode(String areacode){
         this.areacode=areacode;
    }

	/**
	 * get号码
	 */
    public String getTel(){
         return tel;
    }

	/**
	 * set号码
	 */
    public void setTel(String tel){
         this.tel=tel;
    }

	/**
	 * get手机号
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机号
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get电子邮件
	 */
    public String getMail(){
         return mail;
    }

	/**
	 * set电子邮件
	 */
    public void setMail(String mail){
         this.mail=mail;
    }

	/**
	 * get邮政编码
	 */
    public String getPostalcode(){
         return postalcode;
    }

	/**
	 * set邮政编码
	 */
    public void setPostalcode(String postalcode){
         this.postalcode=postalcode;
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
	   
	 + name +"|"
	   
	 + loginname +"|"
	   
	 + loginpwd +"|"
	   
	 + idtype +"|"
	   
	 + idnumber +"|"
	   
	 + areacode +"|"
	   
	 + tel +"|"
	   
	 + mobile +"|"
	   
	 + mail +"|"
	   
	 + postalcode +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + state
	 + "]";
 } 

}
