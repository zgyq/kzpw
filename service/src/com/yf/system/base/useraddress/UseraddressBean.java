/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.useraddress;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *会员常用配送地址
 */
public class UseraddressBean implements java.io.Serializable{

	/**
	  *会员常用配送地址 表名
	  */
	public static final String TABLE  = "T_USERADDRESS";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *省份 列名 
	  */
    public static final String COL_province  = "C_PROVINCE";
	
	/**
	  *市 列名 
	  */
    public static final String COL_city  = "C_CITY";
	
	/**
	  *区域 列名 
	  */
    public static final String COL_area  = "C_AREA";
	
	/**
	  *完整地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
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
    

	//名称
	private String name;    
    
	//省份
	private String province;    
    

	//市
	private String city;    
    

	//区域
	private String area;    
    

	//完整地址
	private String address;    
    

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
	 * get省份
	 */
    public String getProvince(){
         return province;
    }

	/**
	 * set省份
	 */
    public void setProvince(String province){
         this.province=province;
    }

	/**
	 * get市
	 */
    public String getCity(){
         return city;
    }

	/**
	 * set市
	 */
    public void setCity(String city){
         this.city=city;
    }

	/**
	 * get区域
	 */
    public String getArea(){
         return area;
    }

	/**
	 * set区域
	 */
    public void setArea(String area){
         this.area=area;
    }

	/**
	 * get完整地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set完整地址
	 */
    public void setAddress(String address){
         this.address=address;
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
	   
	 + province +"|"
	   
	 + city +"|"
	   
	 + area +"|"
	   
	 + address +"|"
	   
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
