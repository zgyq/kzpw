/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.redeem;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *积分兑换
 */
public class RedeemBean implements java.io.Serializable{

	/**
	  *积分兑换 表名
	  */
	public static final String TABLE  = "T_REDEEM";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *礼品名称 列名 
	  */
    public static final String COL_giftname  = "C_GIFTNAME";
	
	/**
	  *礼品ID 列名 
	  */
    public static final String COL_giftid  = "C_GIFTID";
	
	/**
	  *消费积分 列名 
	  */
    public static final String COL_integral  = "C_INTEGRAL";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *省份 列名 
	  */
    public static final String COL_province  = "C_PROVINCE";
	
	/**
	  *城市 列名 
	  */
    public static final String COL_city  = "C_CITY";
	
	/**
	  *区域 列名 
	  */
    public static final String COL_area  = "C_AREA";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *邮编 列名 
	  */
    public static final String COL_postcode  = "C_POSTCODE";
	
	/**
	  *手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
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
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//礼品名称
	private String giftname;    
    

	//礼品ID
	private Long giftid;    
    

	//消费积分
	private Long integral;    
    

	//联系人姓名
	private String name;    
    

	//省份
	private String province;    
    

	//城市
	private String city;    
    

	//区域
	private String area;    
    

	//地址(现在用于保存常用配送地址ID)
	private String address;    
    

	//邮编
	private String postcode;    
    

	//手机
	private String mobile;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//会员ID
	private Long userid;    
    

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
	 * get礼品名称
	 */
    public String getGiftname(){
         return giftname;
    }

	/**
	 * set礼品名称
	 */
    public void setGiftname(String giftname){
         this.giftname=giftname;
    }

	/**
	 * get礼品ID
	 */
    public Long getGiftid(){
         return giftid;
    }

	/**
	 * set礼品ID
	 */
    public void setGiftid(Long giftid){
         this.giftid=giftid;
    }

	/**
	 * get消费积分
	 */
    public Long getIntegral(){
         return integral;
    }

	/**
	 * set消费积分
	 */
    public void setIntegral(Long integral){
         this.integral=integral;
    }

	/**
	 * get联系人姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set联系人姓名
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
	 * get城市
	 */
    public String getCity(){
         return city;
    }

	/**
	 * set城市
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
	 * get邮编
	 */
    public String getPostcode(){
         return postcode;
    }

	/**
	 * set邮编
	 */
    public void setPostcode(String postcode){
         this.postcode=postcode;
    }

	/**
	 * get手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
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

	/**
	 * get会员ID
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set会员ID
	 */
    public void setUserid(Long userid){
         this.userid=userid;
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
	   
	 + giftname +"|"
	   
	 + giftid +"|"
	   
	 + integral +"|"
	   
	 + name +"|"
	   
	 + province +"|"
	   
	 + city +"|"
	   
	 + area +"|"
	   
	 + address +"|"
	   
	 + postcode +"|"
	   
	 + mobile +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + userid +"|"
	   
	 + state
	 + "]";
 } 

}
