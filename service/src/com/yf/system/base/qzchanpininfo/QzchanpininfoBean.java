/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qzchanpininfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *签证产品详细信息
 */
public class QzchanpininfoBean implements java.io.Serializable{

	/**
	  *签证产品详细信息 表名
	  */
	public static final String TABLE  = "T_QZCHANPININFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *产品名称 列名 
	  */
    public static final String COL_title  = "C_TITLE";
	
	/**
	  *产品链接 列名 
	  */
    public static final String COL_titleurl  = "C_TITLEURL";
	
	/**
	  *国家 列名 
	  */
    public static final String COL_country  = "C_COUNTRY";
	
	/**
	  *签证类型 列名 
	  */
    public static final String COL_category  = "C_CATEGORY";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *使馆收费 列名 
	  */
    public static final String COL_sprice  = "C_SPRICE";
	
	/**
	  *签证中心收费 列名 
	  */
    public static final String COL_qprice  = "C_QPRICE";
	
	/**
	  *办证地点 列名 
	  */
    public static final String COL_dealcity  = "C_DEALCITY";
	
	/**
	  *领区 列名 
	  */
    public static final String COL_area  = "C_AREA";
	
	/**
	  *收客范围 列名 
	  */
    public static final String COL_confine  = "C_CONFINE";
	
	/**
	  *费用描述 列名 
	  */
    public static final String COL_feeinfo  = "C_FEEINFO";
	
	/**
	  *有效期 列名 
	  */
    public static final String COL_validitydate  = "C_VALIDITTDATE";
	
	/**
	  *最多停留时间 列名 
	  */
    public static final String COL_settleday  = "C_SETTLEDAY";
	
	/**
	  *预计工作时间 列名 
	  */
    public static final String COL_intendingday  = "C_INTENDINGDAY";
	
	/**
	  *预计工作时间 列名 
	  */
    public static final String COL_numberofentries  = "C_NUMBEROFENTRIES";
	
	/**
	  *是否需要面签 列名 
	  */
    public static final String COL_isexam  = "C_ISEXAM";
	
	/**
	  *产品简介描述 列名 
	  */
    public static final String COL_smalltext  = "C_SMALLTEXT";
	
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
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//外部id
	private String outid;    
    

	//产品名称
	private String title;    
    

	//产品链接
	private String titleurl;    
    

	//国家
	private String country;    
    

	//签证类型
	private String category;    
    

	//价格
	private String price;    
    

	//使馆收费
	private String sprice;    
    

	//签证中心收费
	private String qprice;    
    

	//办证地点
	private String dealcity;    
    

	//领区
	private String area;    
    

	//收客范围
	private String confine;    
    

	//费用描述
	private String feeinfo;    
    

	//有效期
	private String validitydate;    
    

	//最多停留时间
	private String settleday;    
    

	//预计工作时间
	private String intendingday;    
    

	//预计工作时间
	private String numberofentries;    
    

	//是否需要面签
	private String isexam;    
    

	//产品简介描述
	private String smalltext;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get产品名称
	 */
    public String getTitle(){
         return title;
    }

	/**
	 * set产品名称
	 */
    public void setTitle(String title){
         this.title=title;
    }

	/**
	 * get产品链接
	 */
    public String getTitleurl(){
         return titleurl;
    }

	/**
	 * set产品链接
	 */
    public void setTitleurl(String titleurl){
         this.titleurl=titleurl;
    }

	/**
	 * get国家
	 */
    public String getCountry(){
         return country;
    }

	/**
	 * set国家
	 */
    public void setCountry(String country){
         this.country=country;
    }

	/**
	 * get签证类型
	 */
    public String getCategory(){
         return category;
    }

	/**
	 * set签证类型
	 */
    public void setCategory(String category){
         this.category=category;
    }

	/**
	 * get价格
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get使馆收费
	 */
    public String getSprice(){
         return sprice;
    }

	/**
	 * set使馆收费
	 */
    public void setSprice(String sprice){
         this.sprice=sprice;
    }

	/**
	 * get签证中心收费
	 */
    public String getQprice(){
         return qprice;
    }

	/**
	 * set签证中心收费
	 */
    public void setQprice(String qprice){
         this.qprice=qprice;
    }

	/**
	 * get办证地点
	 */
    public String getDealcity(){
         return dealcity;
    }

	/**
	 * set办证地点
	 */
    public void setDealcity(String dealcity){
         this.dealcity=dealcity;
    }

	/**
	 * get领区
	 */
    public String getArea(){
         return area;
    }

	/**
	 * set领区
	 */
    public void setArea(String area){
         this.area=area;
    }

	/**
	 * get收客范围
	 */
    public String getConfine(){
         return confine;
    }

	/**
	 * set收客范围
	 */
    public void setConfine(String confine){
         this.confine=confine;
    }

	/**
	 * get费用描述
	 */
    public String getFeeinfo(){
         return feeinfo;
    }

	/**
	 * set费用描述
	 */
    public void setFeeinfo(String feeinfo){
         this.feeinfo=feeinfo;
    }

	/**
	 * get有效期
	 */
    public String getValiditydate(){
         return validitydate;
    }

	/**
	 * set有效期
	 */
    public void setValiditydate(String validitydate){
         this.validitydate=validitydate;
    }

	/**
	 * get最多停留时间
	 */
    public String getSettleday(){
         return settleday;
    }

	/**
	 * set最多停留时间
	 */
    public void setSettleday(String settleday){
         this.settleday=settleday;
    }

	/**
	 * get预计工作时间
	 */
    public String getIntendingday(){
         return intendingday;
    }

	/**
	 * set预计工作时间
	 */
    public void setIntendingday(String intendingday){
         this.intendingday=intendingday;
    }

	/**
	 * get预计工作时间
	 */
    public String getNumberofentries(){
         return numberofentries;
    }

	/**
	 * set预计工作时间
	 */
    public void setNumberofentries(String numberofentries){
         this.numberofentries=numberofentries;
    }

	/**
	 * get是否需要面签
	 */
    public String getIsexam(){
         return isexam;
    }

	/**
	 * set是否需要面签
	 */
    public void setIsexam(String isexam){
         this.isexam=isexam;
    }

	/**
	 * get产品简介描述
	 */
    public String getSmalltext(){
         return smalltext;
    }

	/**
	 * set产品简介描述
	 */
    public void setSmalltext(String smalltext){
         this.smalltext=smalltext;
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
	   
	 + title +"|"
	   
	 + titleurl +"|"
	   
	 + country +"|"
	   
	 + category +"|"
	   
	 + price +"|"
	   
	 + sprice +"|"
	   
	 + qprice +"|"
	   
	 + dealcity +"|"
	   
	 + area +"|"
	   
	 + confine +"|"
	   
	 + feeinfo +"|"
	   
	 + validitydate +"|"
	   
	 + settleday +"|"
	   
	 + intendingday +"|"
	   
	 + numberofentries +"|"
	   
	 + isexam +"|"
	   
	 + smalltext +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
