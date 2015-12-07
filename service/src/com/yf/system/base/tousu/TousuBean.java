/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.tousu;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *投诉建议表
 */
public class TousuBean implements java.io.Serializable{

	/**
	  *投诉建议表 表名
	  */
	public static final String TABLE  = "T_TOUSU";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
    /**
	  *投诉建议内容 列名   --使用，反馈内容
	  */
   public static final String COL_comment  = "C_COMMENT";
	
	
	
	/**
	  *创建时间 列名  ---使用
	  */
   public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  * 投诉人ID列名 ---使用  
	  */
    public static final String COL_username  = "C_USERNAME";
    
    /**
	  *投诉代理商ID ---使用  投诉代理商ID
	  */
   public static final String COL_dainame  = "C_DAINAME";
   
   
   
   
   
	
	/**
	  *当事人性别 列名 ---不使用
	  */
    public static final String COL_sex  = "C_SEX";
	
	
	
	/**
	  *代办人手机 列名 ---不使用
	  */
    public static final String COL_daimobile  = "C_DAIMOBILE";
	
	/**
	  *当事人证件类型 列名 ---不使用
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *当事人证件号码 列名 ---不使用
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *会员卡号 列名 ---不使用
	  */
    public static final String COL_kahao  = "C_KAHAO";
	
	/**
	  *联系电话 列名 ---不使用
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *其他电话 列名 ---不使用
	  */
    public static final String COL_qitamobile  = "C_QITAMOBILE";
	
	/**
	  *邮政编码 列名 ---不使用
	  */
    public static final String COL_youbian  = "C_YOUBIAN";
	
	/**
	  *联系地址 列名 ---不使用
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *传真 列名 ---不使用
	  */
    public static final String COL_fax  = "C_FAX";
	
	/**
	  *邮箱 列名 ---不使用
	  */
    public static final String COL_postbox  = "C_POSTBOX";
	
	/**
	  *工作单位 列名 ---不使用
	  */
    public static final String COL_units  = "C_UNITS";
	
	/**
	  *是否通过其他途径已投诉 列名 ---不使用
	  */
    public static final String COL_iftype  = "C_IFTYPE";
	
	
    
    /**
	  *航班时间 列名 ---不使用
	  */
   public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *小时 列名  ---不使用
	  */
   public static final String COL_hour  = "C_HOUR";
	
	/**
	  *分钟 列名  ---不使用
	  */
   public static final String COL_minute  = "C_MINUTE";
	
	/**
	  *出发城市 列名 ---不使用
	  */
   public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *到达城市 列名 ---不使用
	  */
   public static final String COL_endcity  = "C_ENDCITY";
	
	/**
	  *航班号 列名 ---不使用
	  */
   public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *事发日期 列名 ---不使用
	  */
   public static final String COL_happentime  = "C_HAPPENTIME";
   
   
   /**
	  *你的要求 列名  ---不使用
	  */
 public static final String COL_yaoqiu  = "C_YAOQIU";

	//ID
	private long id;    
    

	//航班时间
	private Timestamp starttime;    
    

	//小时
	private String hour;    
    

	//分钟
	private String minute;    
    

	//出发城市
	private String startcity;    
    

	//到达城市
	private String endcity;    
    

	//航班号
	private String flightnumber;    
    

	//事发日期
	private Timestamp happentime;    
    

	//当事人姓名
	private String username;    
    

	//当事人性别
	private Long sex;    
    

	//代办人姓名
	private String dainame;    
    

	//代办人手机
	private String daimobile;    
    

	//当事人证件类型
	private Long type;    
    

	//当事人证件号码
	private String number;    
    

	//会员卡号
	private String kahao;    
    

	//联系电话
	private String mobile;    
    

	//其他电话
	private String qitamobile;    
    

	//邮政编码
	private String youbian;    
    

	//联系地址
	private String address;    
    

	//传真
	private String fax;    
    

	//邮箱
	private String postbox;    
    

	//工作单位
	private String units;    
    

	//是否通过其他途径已投诉
	private Long iftype;    
    

	//投诉建议内容
	private String comment;    
    

	//你的要求
	private String yaoqiu;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get航班时间
	 */
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set航班时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
    }

	/**
	 * get小时
	 */
    public String getHour(){
         return hour;
    }

	/**
	 * set小时
	 */
    public void setHour(String hour){
         this.hour=hour;
    }

	/**
	 * get分钟
	 */
    public String getMinute(){
         return minute;
    }

	/**
	 * set分钟
	 */
    public void setMinute(String minute){
         this.minute=minute;
    }

	

	public String getStartcity() {
		return startcity;
	}

	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}

	public String getEndcity() {
		return endcity;
	}

	public void setEndcity(String endcity) {
		this.endcity = endcity;
	}

	/**
	 * get航班号
	 */
    public String getFlightnumber(){
         return flightnumber;
    }

	/**
	 * set航班号
	 */
    public void setFlightnumber(String flightnumber){
         this.flightnumber=flightnumber;
    }

	/**
	 * get事发日期
	 */
    public Timestamp getHappentime(){
         return happentime;
    }

	/**
	 * set事发日期
	 */
    public void setHappentime(Timestamp happentime){
         this.happentime=happentime;
    }

	/**
	 * get当事人姓名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set当事人姓名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get当事人性别
	 */
    public Long getSex(){
         return sex;
    }

	/**
	 * set当事人性别
	 */
    public void setSex(Long sex){
         this.sex=sex;
    }

	/**
	 * get代办人姓名
	 */
    public String getDainame(){
         return dainame;
    }

	/**
	 * set代办人姓名
	 */
    public void setDainame(String dainame){
         this.dainame=dainame;
    }

	/**
	 * get代办人手机
	 */
    public String getDaimobile(){
         return daimobile;
    }

	/**
	 * set代办人手机
	 */
    public void setDaimobile(String daimobile){
         this.daimobile=daimobile;
    }

	/**
	 * get当事人证件类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set当事人证件类型
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get当事人证件号码
	 */
    public String getNumber(){
         return number;
    }

	/**
	 * set当事人证件号码
	 */
    public void setNumber(String number){
         this.number=number;
    }

	/**
	 * get会员卡号
	 */
    public String getKahao(){
         return kahao;
    }

	/**
	 * set会员卡号
	 */
    public void setKahao(String kahao){
         this.kahao=kahao;
    }

	/**
	 * get联系电话
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set联系电话
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get其他电话
	 */
    public String getQitamobile(){
         return qitamobile;
    }

	/**
	 * set其他电话
	 */
    public void setQitamobile(String qitamobile){
         this.qitamobile=qitamobile;
    }

	/**
	 * get邮政编码
	 */
    public String getYoubian(){
         return youbian;
    }

	/**
	 * set邮政编码
	 */
    public void setYoubian(String youbian){
         this.youbian=youbian;
    }

	/**
	 * get联系地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set联系地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get传真
	 */
    public String getFax(){
         return fax;
    }

	/**
	 * set传真
	 */
    public void setFax(String fax){
         this.fax=fax;
    }

	/**
	 * get邮箱
	 */
    public String getPostbox(){
         return postbox;
    }

	/**
	 * set邮箱
	 */
    public void setPostbox(String postbox){
         this.postbox=postbox;
    }

	/**
	 * get工作单位
	 */
    public String getUnits(){
         return units;
    }

	/**
	 * set工作单位
	 */
    public void setUnits(String units){
         this.units=units;
    }

	/**
	 * get是否通过其他途径已投诉
	 */
    public Long getIftype(){
         return iftype;
    }

	/**
	 * set是否通过其他途径已投诉
	 */
    public void setIftype(Long iftype){
         this.iftype=iftype;
    }

	/**
	 * get投诉建议内容
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set投诉建议内容
	 */
    public void setComment(String comment){
         this.comment=comment;
    }

	/**
	 * get你的要求
	 */
    public String getYaoqiu(){
         return yaoqiu;
    }

	/**
	 * set你的要求
	 */
    public void setYaoqiu(String yaoqiu){
         this.yaoqiu=yaoqiu;
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
	   
	 + starttime +"|"
	   
	 + hour +"|"
	   
	 + minute +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + flightnumber +"|"
	   
	 + happentime +"|"
	   
	 + username +"|"
	   
	 + sex +"|"
	   
	 + dainame +"|"
	   
	 + daimobile +"|"
	   
	 + type +"|"
	   
	 + number +"|"
	   
	 + kahao +"|"
	   
	 + mobile +"|"
	   
	 + qitamobile +"|"
	   
	 + youbian +"|"
	   
	 + address +"|"
	   
	 + fax +"|"
	   
	 + postbox +"|"
	   
	 + units +"|"
	   
	 + iftype +"|"
	   
	 + comment +"|"
	   
	 + yaoqiu +"|"
	   
	 + createtime
	 + "]";
 } 

}
