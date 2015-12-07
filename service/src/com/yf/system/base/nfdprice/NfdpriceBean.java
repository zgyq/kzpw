/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.nfdprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *NFD价格
 */
public class NfdpriceBean implements java.io.Serializable{

	/**
	  *NFD价格 表名
	  */
	public static final String TABLE  = "T_NFDPRICE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出发地 列名 
	  */
    public static final String COL_scity  = "C_SCITY";
	
	/**
	  *到达地 列名 
	  */
    public static final String COL_ecity  = "C_ECITY";
	
	/**
	  *航空公司 列名 
	  */
    public static final String COL_aircode  = "C_AIRCODE";
	
	/**
	  *price 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *往返价 列名 
	  */
    public static final String COL_rtPrice  = "C_RTPRICE";
	
	/**
	  *票价级别 列名 
	  */
    public static final String COL_priceleve  = "C_PRICELEVE";
	
	/**
	  *开始时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_etime  = "C_ETIME";
	
	/**
	  *提前最小天数 列名 
	  */
    public static final String COL_smday  = "C_SMDAY";
	
	/**
	  *提前最大天数 列名 
	  */
    public static final String COL_bigday  = "C_BIGDAY";
	
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
    

	//出发地
	private String scity;    
    

	//到达地
	private String ecity;    
    

	//航空公司
	private String aircode;    
    

	//price
	private String price;    
    

	//往返价
	private String rtPrice;    
    

	//票价级别
	private String priceleve;    
    

	//开始时间
	private String stime;    
    

	//结束时间
	private String etime;    
    

	//提前最小天数
	private String smday;    
    

	//提前最大天数
	private String bigday;    
    

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
	 * get出发地
	 */
    public String getScity(){
         return scity;
    }

	/**
	 * set出发地
	 */
    public void setScity(String scity){
         this.scity=scity;
    }

	/**
	 * get到达地
	 */
    public String getEcity(){
         return ecity;
    }

	/**
	 * set到达地
	 */
    public void setEcity(String ecity){
         this.ecity=ecity;
    }

	/**
	 * get航空公司
	 */
    public String getAircode(){
         return aircode;
    }

	/**
	 * set航空公司
	 */
    public void setAircode(String aircode){
         this.aircode=aircode;
    }

	/**
	 * getprice
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * setprice
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get往返价
	 */
    public String getRtPrice(){
         return rtPrice;
    }

	/**
	 * set往返价
	 */
    public void setRtPrice(String rtPrice){
         this.rtPrice=rtPrice;
    }

	/**
	 * get票价级别
	 */
    public String getPriceleve(){
         return priceleve;
    }

	/**
	 * set票价级别
	 */
    public void setPriceleve(String priceleve){
         this.priceleve=priceleve;
    }

	/**
	 * get开始时间
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set开始时间
	 */
    public void setStime(String stime){
         this.stime=stime;
    }

	/**
	 * get结束时间
	 */
    public String getEtime(){
         return etime;
    }

	/**
	 * set结束时间
	 */
    public void setEtime(String etime){
         this.etime=etime;
    }

	/**
	 * get提前最小天数
	 */
    public String getSmday(){
         return smday;
    }

	/**
	 * set提前最小天数
	 */
    public void setSmday(String smday){
         this.smday=smday;
    }

	/**
	 * get提前最大天数
	 */
    public String getBigday(){
         return bigday;
    }

	/**
	 * set提前最大天数
	 */
    public void setBigday(String bigday){
         this.bigday=bigday;
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
	   
	 + scity +"|"
	   
	 + ecity +"|"
	   
	 + aircode +"|"
	   
	 + price +"|"
	   
	 + rtPrice +"|"
	   
	 + priceleve +"|"
	   
	 + stime +"|"
	   
	 + etime +"|"
	   
	 + smday +"|"
	   
	 + bigday +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
