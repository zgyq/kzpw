/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotticket;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *景点门票
 */
public class SpotticketBean implements java.io.Serializable{

	/**
	  *景点门票 表名
	  */
	public static final String TABLE  = "T_SPOTTICKET";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *景区ID 列名 
	  */
    public static final String COL_sid  = "C_SID";
	
	/**
	  *票类ID 列名 
	  */
    public static final String COL_goodsid  = "C_GOODSID";
	
	/**
	  *票类名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *门市价格 列名 
	  */
    public static final String COL_marketprice  = "C_MARKETPRICE";
	
	/**
	  *贝竹价格 列名 
	  */
    public static final String COL_shopprice  = "C_SHOPPRICE";
	
	/**
	  *选项位 列名 
	  */
    public static final String COL_bitopt  = "C_BITOPT";
	
	/**
	  *票量 列名 
	  */
    public static final String COL_limitnumber  = "C_LIMITNUMBER";
	
	/**
	  *票类截至时间 列名 
	  */
    public static final String COL_sellendtime  = "C_SELLENDTIME";
	
	/**
	  *限制购买地区 列名 
	  */
    public static final String COL_limitarea  = "C_LIMITAREA";
	
	/**
	  *可以购买地区 列名 
	  */
    public static final String COL_accessarea  = "C_ACCESSAREA";
	
	/**
	  *单张身份证购买数 列名 
	  */
    public static final String COL_limitsfznumber  = "C_LIMITSFZNUMBER";
	
	/**
	  *起订数 列名 
	  */
    public static final String COL_minnumber  = "C_MINNUMBER";
	
	/**
	  *特价(0无,1有) 列名 
	  */
    public static final String COL_tejia  = "C_TEJIA";
	
	/**
	  *特价产品信息 列名 
	  */
    public static final String COL_title1  = "C_TITLE1";
	
	/**
	  *特价产品图片 列名 
	  */
    public static final String COL_pic1  = "C_PIC1";
	
	/**
	  *特价产品图片 列名 
	  */
    public static final String COL_pic2  = "C_PIC2";
	
	/**
	  *特价产品景区介绍 列名 
	  */
    public static final String COL_text1  = "C_TEXT1";
	
	/**
	  *特价产品温馨提示 列名 
	  */
    public static final String COL_text2  = "C_TEXT2";
	
	/**
	  *特价门票门票说明 列名 
	  */
    public static final String COL_text3  = "C_TEXT3";
	
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
    

	//外部id
	private String outid;    
    

	//景区ID
	private String sid;    
    

	//票类ID
	private String goodsid;    
    

	//票类名称
	private String name;    
    

	//门市价格
	private String marketprice;    
    

	//贝竹价格
	private String shopprice;    
    

	//选项位
	private String bitopt;    
    

	//票量
	private String limitnumber;    
    

	//票类截至时间
	private String sellendtime;    
    

	//限制购买地区
	private String limitarea;    
    

	//可以购买地区
	private String accessarea;    
    

	//单张身份证购买数
	private String limitsfznumber;    
    

	//起订数
	private String minnumber;    
    

	//特价(0无,1有)
	private String tejia;    
    

	//特价产品信息
	private String title1;    
    

	//特价产品图片
	private String pic1;    
    

	//特价产品图片
	private String pic2;    
    

	//特价产品景区介绍
	private String text1;    
    

	//特价产品温馨提示
	private String text2;    
    

	//特价门票门票说明
	private String text3;    
    

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
	 * get外部id
	 */
    public String getOutid(){
         return outid;
    }

	/**
	 * set外部id
	 */
    public void setOutid(String outid){
         this.outid=outid;
    }

	/**
	 * get景区ID
	 */
    public String getSid(){
         return sid;
    }

	/**
	 * set景区ID
	 */
    public void setSid(String sid){
         this.sid=sid;
    }

	/**
	 * get票类ID
	 */
    public String getGoodsid(){
         return goodsid;
    }

	/**
	 * set票类ID
	 */
    public void setGoodsid(String goodsid){
         this.goodsid=goodsid;
    }

	/**
	 * get票类名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set票类名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get门市价格
	 */
    public String getMarketprice(){
         return marketprice;
    }

	/**
	 * set门市价格
	 */
    public void setMarketprice(String marketprice){
         this.marketprice=marketprice;
    }

	/**
	 * get贝竹价格
	 */
    public String getShopprice(){
         return shopprice;
    }

	/**
	 * set贝竹价格
	 */
    public void setShopprice(String shopprice){
         this.shopprice=shopprice;
    }

	/**
	 * get选项位
	 */
    public String getBitopt(){
         return bitopt;
    }

	/**
	 * set选项位
	 */
    public void setBitopt(String bitopt){
         this.bitopt=bitopt;
    }

	/**
	 * get票量
	 */
    public String getLimitnumber(){
         return limitnumber;
    }

	/**
	 * set票量
	 */
    public void setLimitnumber(String limitnumber){
         this.limitnumber=limitnumber;
    }

	/**
	 * get票类截至时间
	 */
    public String getSellendtime(){
         return sellendtime;
    }

	/**
	 * set票类截至时间
	 */
    public void setSellendtime(String sellendtime){
         this.sellendtime=sellendtime;
    }

	/**
	 * get限制购买地区
	 */
    public String getLimitarea(){
         return limitarea;
    }

	/**
	 * set限制购买地区
	 */
    public void setLimitarea(String limitarea){
         this.limitarea=limitarea;
    }

	/**
	 * get可以购买地区
	 */
    public String getAccessarea(){
         return accessarea;
    }

	/**
	 * set可以购买地区
	 */
    public void setAccessarea(String accessarea){
         this.accessarea=accessarea;
    }

	/**
	 * get单张身份证购买数
	 */
    public String getLimitsfznumber(){
         return limitsfznumber;
    }

	/**
	 * set单张身份证购买数
	 */
    public void setLimitsfznumber(String limitsfznumber){
         this.limitsfznumber=limitsfznumber;
    }

	/**
	 * get起订数
	 */
    public String getMinnumber(){
         return minnumber;
    }

	/**
	 * set起订数
	 */
    public void setMinnumber(String minnumber){
         this.minnumber=minnumber;
    }

	/**
	 * get特价(0无,1有)
	 */
    public String getTejia(){
         return tejia;
    }

	/**
	 * set特价(0无,1有)
	 */
    public void setTejia(String tejia){
         this.tejia=tejia;
    }

	/**
	 * get特价产品信息
	 */
    public String getTitle1(){
         return title1;
    }

	/**
	 * set特价产品信息
	 */
    public void setTitle1(String title1){
         this.title1=title1;
    }

	/**
	 * get特价产品图片
	 */
    public String getPic1(){
         return pic1;
    }

	/**
	 * set特价产品图片
	 */
    public void setPic1(String pic1){
         this.pic1=pic1;
    }

	/**
	 * get特价产品图片
	 */
    public String getPic2(){
         return pic2;
    }

	/**
	 * set特价产品图片
	 */
    public void setPic2(String pic2){
         this.pic2=pic2;
    }

	/**
	 * get特价产品景区介绍
	 */
    public String getText1(){
         return text1;
    }

	/**
	 * set特价产品景区介绍
	 */
    public void setText1(String text1){
         this.text1=text1;
    }

	/**
	 * get特价产品温馨提示
	 */
    public String getText2(){
         return text2;
    }

	/**
	 * set特价产品温馨提示
	 */
    public void setText2(String text2){
         this.text2=text2;
    }

	/**
	 * get特价门票门票说明
	 */
    public String getText3(){
         return text3;
    }

	/**
	 * set特价门票门票说明
	 */
    public void setText3(String text3){
         this.text3=text3;
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
	   
	 + outid +"|"
	   
	 + sid +"|"
	   
	 + goodsid +"|"
	   
	 + name +"|"
	   
	 + marketprice +"|"
	   
	 + shopprice +"|"
	   
	 + bitopt +"|"
	   
	 + limitnumber +"|"
	   
	 + sellendtime +"|"
	   
	 + limitarea +"|"
	   
	 + accessarea +"|"
	   
	 + limitsfznumber +"|"
	   
	 + minnumber +"|"
	   
	 + tejia +"|"
	   
	 + title1 +"|"
	   
	 + pic1 +"|"
	   
	 + pic2 +"|"
	   
	 + text1 +"|"
	   
	 + text2 +"|"
	   
	 + text3 +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + state
	 + "]";
 } 

}
