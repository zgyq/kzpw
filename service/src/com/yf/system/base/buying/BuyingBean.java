/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.buying;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *团购信息
 */
public class BuyingBean implements java.io.Serializable{

	/**
	  *团购信息 表名
	  */
	public static final String TABLE  = "T_BUYING";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *供应商ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *省ID 列名 
	  */
    public static final String COL_pid  = "C_PID";
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *区ID 列名 
	  */
    public static final String COL_regionid  = "C_REGIONID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *门市价格 列名 
	  */
    public static final String COL_marketprice  = "C_MARKETPRICE";
	
	/**
	  *团购价格 列名 
	  */
    public static final String COL_shopprice  = "C_SHOPPRICE";
	
	/**
	  *详细信息 列名 
	  */
    public static final String COL_descinfo  = "C_DESCINFO";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_beizhu  = "C_BEIZHU";
	
	/**
	  *提前多少天预约 列名 
	  */
    public static final String COL_tiqiandays  = "C_TIQIANDAYS";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *开始日期 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *结束日期 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";
	
	/**
	  *使用时间范围 列名 
	  */
    public static final String COL_stimeetime  = "C_STIMEETIME";
	
	/**
	  *使用规则 列名 
	  */
    public static final String COL_guize  = "C_GUIZE";
	
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
	  *产品介绍 列名 
	  */
    public static final String COL_text1  = "C_TEXT1";
	
	/**
	  *温馨提示 列名 
	  */
    public static final String COL_text2  = "C_TEXT2";
	
	/**
	  *预订说明 列名 
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
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//外部id
	private String outid;    
    

	//供应商ID
	private Long agentid;    
    

	//省ID
	private Long pid;    
    

	//城市ID
	private Long cityid;    
    

	//区ID
	private Long regionid;    
    

	//名称
	private String name;    
    

	//门市价格
	private String marketprice;    
    

	//团购价格
	private String shopprice;    
    

	//详细信息
	private String descinfo;    
    

	//备注
	private String beizhu;    
    

	//提前多少天预约
	private String tiqiandays;    
    

	//地址
	private String address;    
    

	//开始日期
	private String stime;    
    

	//结束日期
	private String endtime;    
    

	//使用时间范围
	private String stimeetime;    
    

	//使用规则
	private String guize;    
    

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
    

	//产品介绍
	private String text1;    
    

	//温馨提示
	private String text2;    
    

	//预订说明
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
	 * get供应商ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set供应商ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get省ID
	 */
    public Long getPid(){
         return pid;
    }

	/**
	 * set省ID
	 */
    public void setPid(Long pid){
         this.pid=pid;
    }

	/**
	 * get城市ID
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set城市ID
	 */
    public void setCityid(Long cityid){
         this.cityid=cityid;
    }

	/**
	 * get区ID
	 */
    public Long getRegionid(){
         return regionid;
    }

	/**
	 * set区ID
	 */
    public void setRegionid(Long regionid){
         this.regionid=regionid;
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
	 * get团购价格
	 */
    public String getShopprice(){
         return shopprice;
    }

	/**
	 * set团购价格
	 */
    public void setShopprice(String shopprice){
         this.shopprice=shopprice;
    }

	/**
	 * get详细信息
	 */
    public String getDescinfo(){
         return descinfo;
    }

	/**
	 * set详细信息
	 */
    public void setDescinfo(String descinfo){
         this.descinfo=descinfo;
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
	 * get提前多少天预约
	 */
    public String getTiqiandays(){
         return tiqiandays;
    }

	/**
	 * set提前多少天预约
	 */
    public void setTiqiandays(String tiqiandays){
         this.tiqiandays=tiqiandays;
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
	 * get开始日期
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set开始日期
	 */
    public void setStime(String stime){
         this.stime=stime;
    }

	/**
	 * get结束日期
	 */
    public String getEndtime(){
         return endtime;
    }

	/**
	 * set结束日期
	 */
    public void setEndtime(String endtime){
         this.endtime=endtime;
    }

	/**
	 * get使用时间范围
	 */
    public String getStimeetime(){
         return stimeetime;
    }

	/**
	 * set使用时间范围
	 */
    public void setStimeetime(String stimeetime){
         this.stimeetime=stimeetime;
    }

	/**
	 * get使用规则
	 */
    public String getGuize(){
         return guize;
    }

	/**
	 * set使用规则
	 */
    public void setGuize(String guize){
         this.guize=guize;
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
	 * get产品介绍
	 */
    public String getText1(){
         return text1;
    }

	/**
	 * set产品介绍
	 */
    public void setText1(String text1){
         this.text1=text1;
    }

	/**
	 * get温馨提示
	 */
    public String getText2(){
         return text2;
    }

	/**
	 * set温馨提示
	 */
    public void setText2(String text2){
         this.text2=text2;
    }

	/**
	 * get预订说明
	 */
    public String getText3(){
         return text3;
    }

	/**
	 * set预订说明
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
	   
	 + outid +"|"
	   
	 + agentid +"|"
	   
	 + pid +"|"
	   
	 + cityid +"|"
	   
	 + regionid +"|"
	   
	 + name +"|"
	   
	 + marketprice +"|"
	   
	 + shopprice +"|"
	   
	 + descinfo +"|"
	   
	 + beizhu +"|"
	   
	 + tiqiandays +"|"
	   
	 + address +"|"
	   
	 + stime +"|"
	   
	 + endtime +"|"
	   
	 + stimeetime +"|"
	   
	 + guize +"|"
	   
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
	   
	 + type +"|"
	   
	 + state
	 + "]";
 } 

}
