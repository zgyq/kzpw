/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.segmentinfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import com.yf.system.base.zrate.Zrate;

/**
 *行程表
 */
public class SegmentinfoBean implements java.io.Serializable{
	  private Zrate zrate;

	/**
	  *行程表 表名
	  */
	public static final String TABLE  = "T_SEGMENTINFO";

	
	/**
	  *行程ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *航空公司二字代码 列名 
	  */
    public static final String COL_aircomapnycode  = "C_AIRCOMAPNYCODE";
	
	/**
	  *机建费 列名 
	  */
    public static final String COL_airportfee  = "C_AIRPORTFEE";
	
	/**
	  *燃油费 列名 
	  */
    public static final String COL_fuelfee  = "C_FUELFEE";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_departtime  = "C_DEPARTTIME";
	
	/**
	  *到达时间 列名 
	  */
    public static final String COL_arrivaltime  = "C_ARRIVALTIME";
	
	/**
	  *舱位码 列名 
	  */
    public static final String COL_cabincode  = "C_CABINCODE";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *折扣（四舍五入） 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *全价价格 列名 
	  */
    public static final String COL_yprice  = "C_YPRICE";
	
	/**
	  *行程类型 列名 
	  */
    public static final String COL_traveltype  = "C_TRAVELTYPE";
	
	/**
	  *是否特价(0=非特价,1=特价) 列名 
	  */
    public static final String COL_isspecial  = "C_ISSPECIAL";
	
	/**
	  *起飞机场 列名 
	  */
    public static final String COL_startairport  = "C_STARTAIRPORT";
	
	/**
	  *到达机场 列名 
	  */
    public static final String COL_endairport  = "C_ENDAIRPORT";
	
	/**
	  *退改签规则 列名 
	  */
    public static final String COL_rules  = "C_RULES";
	
	/**
	  *返点 列名 
	  */
    public static final String COL_ratevalue  = "C_RATEVALUE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *起飞航班楼 列名 
	  */
    public static final String COL_borderpointat  = "C_BORDERPOINTAT";
	
	/**
	  *到达航班楼 列名 
	  */
    public static final String COL_offpointat  = "C_OFFPOINTAT";
	
	/**
	  *票面价 列名 
	  */
    public static final String COL_parvalue  = "C_PARVALUE";
	
	/**
	  *代理人ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *政策ID 列名 
	  */
    public static final String COL_zrateid  = "C_ZRATEID";
    /**
     * 机型信息
     */
    public static final String COL_FlightModel="C_FLIGHTMODEL";

	//行程ID
	private long id;    
    

	//订单ID
	private Long orderid;    
    

	//航班号
	private String flightnumber;    
    

	//航空公司二字代码
	private String aircomapnycode;   
	//航空公司名字：对应航空公司二字码
	private String airname;
    

	//机建费
	private Float airportfee;    
    

	//燃油费
	private Float fuelfee;    
    

	//起飞时间
	private Timestamp departtime;    
    

	//到达时间
	private Timestamp arrivaltime;    
    

	//舱位码
	private String cabincode;    
    

	//价格
	private Float price;    
    

	//折扣（四舍五入）
	private Float discount;    
    

	//全价价格
	private Float yprice;    
    

	//行程类型
	private Integer traveltype;    
    

	//是否特价(0=非特价,1=特价)
	private Integer isspecial;    
    

	//起飞机场 三字码
	private String startairport;
	
	//起飞机场 name
	private String startairportname;
    

	//到达机场
	private String endairport;  
	
	
	private String endairportname;
	
	
    

	//退改签规则
	private String rules;    
    

	//返点
	private Float ratevalue;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//起飞航班楼
	private String borderpointat;    
    

	//到达航班楼
	private String offpointat;    
    

	//票面价
	private Float parvalue;    
    

	//代理人ID
	private Long agentid;    
    

	//政策ID
	private Long zrateid;    
	
	private String flightmodel;
	
	private String flightdesc;
    

	/**
	 * get行程ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set行程ID
	 */
    public void setId(long id){
         this.id=id;
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
	 * get航空公司二字代码
	 */
    public String getAircomapnycode(){
         return aircomapnycode;
    }

	/**
	 * set航空公司二字代码
	 */
    public void setAircomapnycode(String aircomapnycode){
         this.aircomapnycode=aircomapnycode;
    }

	/**
	 * get机建费
	 */
    public Float getAirportfee(){
         return airportfee;
    }

	/**
	 * set机建费
	 */
    public void setAirportfee(Float airportfee){
         this.airportfee=airportfee;
    }

	/**
	 * get燃油费
	 */
    public Float getFuelfee(){
         return fuelfee;
    }

	/**
	 * set燃油费
	 */
    public void setFuelfee(Float fuelfee){
         this.fuelfee=fuelfee;
    }

	/**
	 * get起飞时间
	 */
    public Timestamp getDeparttime(){
         return departtime;
    }

	/**
	 * set起飞时间
	 */
    public void setDeparttime(Timestamp departtime){
         this.departtime=departtime;
    	
    }

	/**
	 * get到达时间
	 */
    public Timestamp getArrivaltime(){
         return arrivaltime;
    }

	/**
	 * set到达时间
	 */
    public void setArrivaltime(Timestamp arrivaltime){
         this.arrivaltime=arrivaltime;
    }

	/**
	 * get舱位码
	 */
    public String getCabincode(){
         return cabincode;
    }

	/**
	 * set舱位码
	 */
    public void setCabincode(String cabincode){
         this.cabincode=cabincode;
    }

	/**
	 * get价格
	 */
    public Float getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(Float price){
         this.price=price;
    }

	/**
	 * get折扣（四舍五入）
	 */
    public Float getDiscount(){
         return discount;
    }

	/**
	 * set折扣（四舍五入）
	 */
    public void setDiscount(Float discount){
         this.discount=discount;
    }

	/**
	 * get全价价格
	 */
    public Float getYprice(){
         return yprice;
    }

	/**
	 * set全价价格
	 */
    public void setYprice(Float yprice){
         this.yprice=yprice;
    }

	/**
	 * get行程类型
	 */
    public Integer getTraveltype(){
         return traveltype;
    }

	/**
	 * set行程类型
	 */
    public void setTraveltype(Integer traveltype){
         this.traveltype=traveltype;
    }

	/**
	 * get是否特价(0=非特价,1=特价)
	 */
    public Integer getIsspecial(){
         return isspecial;
    }

	/**
	 * set是否特价(0=非特价,1=特价)
	 */
    public void setIsspecial(Integer isspecial){
         this.isspecial=isspecial;
    }

	/**
	 * get起飞机场
	 */
    public String getStartairport(){
         return startairport;
    }

	/**
	 * set起飞机场
	 */
    public void setStartairport(String startairport){
         this.startairport=startairport;
    }

	/**
	 * get到达机场
	 */
    public String getEndairport(){
         return endairport;
    }

	/**
	 * set到达机场
	 */
    public void setEndairport(String endairport){
         this.endairport=endairport;
    }

	/**
	 * get退改签规则
	 */
    public String getRules(){
         return rules;
    }

	/**
	 * set退改签规则
	 */
    public void setRules(String rules){
         this.rules=rules;
    }

	/**
	 * get返点
	 */
    public Float getRatevalue(){
         return ratevalue;
    }

	/**
	 * set返点
	 */
    public void setRatevalue(Float ratevalue){
         this.ratevalue=ratevalue;
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

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }

	/**
	 * get起飞航班楼
	 */
    public String getBorderpointat(){
         return borderpointat;
    }

	/**
	 * set起飞航班楼
	 */
    public void setBorderpointat(String borderpointat){
         this.borderpointat=borderpointat;
    }

	/**
	 * get到达航班楼
	 */
    public String getOffpointat(){
         return offpointat;
    }

	/**
	 * set到达航班楼
	 */
    public void setOffpointat(String offpointat){
         this.offpointat=offpointat;
    }

	/**
	 * get票面价
	 */
    public Float getParvalue(){
         return parvalue;
    }

	/**
	 * set票面价
	 */
    public void setParvalue(Float parvalue){
         this.parvalue=parvalue;
    }

	/**
	 * get代理人ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set代理人ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get政策ID
	 */
    public Long getZrateid(){
         return zrateid;
    }

	/**
	 * set政策ID
	 */
    public void setZrateid(Long zrateid){
         this.zrateid=zrateid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + flightnumber +"|"
	   
	 + aircomapnycode +"|"
	   
	 + airportfee +"|"
	   
	 + fuelfee +"|"
	   
	 + departtime +"|"
	   
	 + arrivaltime +"|"
	   
	 + cabincode +"|"
	   
	 + price +"|"
	   
	 + discount +"|"
	   
	 + yprice +"|"
	   
	 + traveltype +"|"
	   
	 + isspecial +"|"
	   
	 + startairport +"|"
	   
	 + endairport +"|"
	   
	 + rules +"|"
	   
	 + ratevalue +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + borderpointat +"|"
	   
	 + offpointat +"|"
	   
	 + parvalue +"|"
	   
	 + agentid +"|"
	   
	 + zrateid
	 + "]";
 }

	public String getAirname() {
		return airname;
	}

	public void setAirname(String airname) {
		this.airname = airname;
	}

	public String getStartairportname() {
		return startairportname;
	}

	public void setStartairportname(String startairportname) {
		this.startairportname = startairportname;
	}

	public String getEndairportname() {
		return endairportname;
	}

	public void setEndairportname(String endairportname) {
		this.endairportname = endairportname;
	}

	public String getFlightmodel() {
		return flightmodel;
	}

	public void setFlightmodel(String flightmodel) {
		this.flightmodel = flightmodel;
	}

	public Zrate getZrate() {
		return zrate;
	}

	public void setZrate(Zrate zrate) {
		this.zrate = zrate;
	}

	public String getFlightdesc() {
		return flightdesc;
	}

	public void setFlightdesc(String flightdesc) {
		this.flightdesc = flightdesc;
	} 

}
