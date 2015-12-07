/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.guest;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *客人信息表
 */
public class GuestBean implements java.io.Serializable{

	/**
	  *客人信息表 表名
	  */
	public static final String TABLE  = "T_GUEST";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *客人名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *房间号 列名 
	  */
    public static final String COL_roomno  = "C_ROOMNO";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *确认信息 列名 
	  */
    public static final String COL_memo  = "C_MEMO";
	
	/**
	  *版本号 列名 
	  */
    public static final String COL_version  = "C_VERSION";
	
	/**
	  *客人手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
    
    
    /**
     *实际离店日期 列名 
     */
    public static final String COL_shijitime  = "C_SHIJITIME";
    
    /**
     *正常离店日期 列名 
     */
    public static final String COL_likaitime  = "C_LIKAITIME";
    
    
    /**
     *正常入住日期 列名 
     */
    public static final String COL_ruzhutime  = "C_RUZHUTIME";
    
    
    /**
     *单价 列名 
     */
    public static final String COL_price  = "C_PRICE";
    
    /**
     *状态 列名 
     */
    public static final String COL_state  = "C_STATE";
    
    
    /**
     *性别 列名 
     */
    public static final String COL_sex  = "C_SEX";
    
    /**
     *会员返利 列名 
     */
    public static final String COL_userfan  = "C_USERFAN";
    
    /**
     *平台返利 列名 
     */
    public static final String COL_platfan  = "C_PLATFAN";
    
    
    /**
     *一级代理返利 列名 
     */
    public static final String COL_onefan  = "C_ONEFAN";
    
    /**
     *二级代理返利 列名 
     */
    public static final String COL_twofan  = "C_TWOFAN";
    
    /**
     *三级代理返利 列名 
     */
    public static final String COL_threefan  = "C_THREEFAN";
    
    
    /**
     *国籍 列名 
     */
    public static final String COL_country  = "C_COUNTRY";
   

	//ID
	private long id;    
    

	//客人名称
	private String name;    
    

	//客人国籍
	private String country; 
	
	
	//房间号
	private String roomno;    
    

	//订单ID
	private Long orderid;    
    

	//确认信息
	private String memo;    
    

	//版本号
	private Integer version;    
    

	//客人手机
	private String mobile;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;  
	

	//正常入住时间
	private Timestamp ruzhutime;    
	
	
	//正常离店时间
	private Timestamp likaitime;  
	
	
	//实际离店时间
	private Timestamp shijitime;  
	
	//单价
	private String price; 
    
	//状态
	private Long state;   //1，正常 2,提前离店 3,延住 4,取消
	
	//性别
	private Long sex;    //1男  2女
	
	
	//会员返利
	private Double userfan; 
	
	//平台返利
	private Double platfan; 
	
	//一级代理返利
	private Double onefan; 
	
	//二级代理返利
	private Double twofan; 
	
	//三级代理返利
	private Double threefan; 

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
	 * get客人名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set客人名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get房间号
	 */
    public String getRoomno(){
         return roomno;
    }

	/**
	 * set房间号
	 */
    public void setRoomno(String roomno){
         this.roomno=roomno;
    }

	/**
	 * get订单ID
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set订单ID
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get确认信息
	 */
    public String getMemo(){
         return memo;
    }

	/**
	 * set确认信息
	 */
    public void setMemo(String memo){
         this.memo=memo;
    }

	/**
	 * get版本号
	 */
    public Integer getVersion(){
         return version;
    }

	/**
	 * set版本号
	 */
    public void setVersion(Integer version){
         this.version=version;
    }

	/**
	 * get客人手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set客人手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
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

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public Timestamp getRuzhutime() {
		return ruzhutime;
	}

	public void setRuzhutime(Timestamp ruzhutime) {
		this.ruzhutime = ruzhutime;
	}

	public Timestamp getLikaitime() {
		return likaitime;
	}

	public void setLikaitime(Timestamp likaitime) {
		this.likaitime = likaitime;
	}

	public Timestamp getShijitime() {
		return shijitime;
	}

	public void setShijitime(Timestamp shijitime) {
		this.shijitime = shijitime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	 
	 + country +"|"
	   
	 + roomno +"|"
	   
	 + orderid +"|"
	   
	 + memo +"|"
	   
	 + version +"|"
	   
	 + mobile +"|"
	   
	 + ucode +"|"
	 
	 + ruzhutime +"|"
	 
	 + likaitime +"|"
	 
	 + shijitime +"|"
	 
	 + price +"|"
	 
	 
	 + sex +"|"
	 
	 + state +"|"
	 
	 + userfan +"|"
	 
	 + platfan +"|"
	 
	 + onefan +"|"
	 
	 + twofan +"|"
	 
	 + threefan +"|"
	   
	 + language
	 + "]";
 }

	public Double getUserfan() {
		return userfan;
	}

	public void setUserfan(Double userfan) {
		this.userfan = userfan;
	}

	public Double getPlatfan() {
		return platfan;
	}

	public void setPlatfan(Double platfan) {
		this.platfan = platfan;
	}

	public Double getOnefan() {
		return onefan;
	}

	public void setOnefan(Double onefan) {
		this.onefan = onefan;
	}

	public Double getTwofan() {
		return twofan;
	}

	public void setTwofan(Double twofan) {
		this.twofan = twofan;
	}

	public Double getThreefan() {
		return threefan;
	}

	public void setThreefan(Double threefan) {
		this.threefan = threefan;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 

}
