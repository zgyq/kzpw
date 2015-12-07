/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.tuipiao;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *退票报表
 */
public class TuipiaoBean implements java.io.Serializable{

	/**
	  *退票报表 表名
	  */
	public static final String TABLE  = "T_TUIPIAO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出票时间 列名 
	  */
    public static final String COL_rttime  = "C_RTTIME";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_ordercode  = "C_ORDERCODE";
	
	/**
	  *PNR 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *订单人数 列名 
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *退票人数 列名 
	  */
    public static final String COL_rnumber  = "C_RNUMBER";
	
	/**
	  *退费票申请时间 列名 
	  */
    public static final String COL_applytime  = "C_APPLYTIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *OFFICE 列名 
	  */
    public static final String COL_office  = "C_OFFICE";
	
	/**
	  *退款金额 列名 
	  */
    public static final String COL_tuiprice  = "C_TUIPRICE";
	
	/**
	  *退款时间 列名 
	  */
    public static final String COL_tuitime  = "C_TUITIME";
	
	/**
	  *票号 列名 
	  */
    public static final String COL_ticketno  = "C_TICKETNO";
	
	/**
	  *乘机人 列名 
	  */
    public static final String COL_passenger  = "C_PASSENGER";
	
	/**
	  *乘机人类型 列名 
	  */
    public static final String COL_ptype  = "C_PTYPE";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *到达城市 列名 
	  */
    public static final String COL_endcity  = "C_ENDCITY";
	
	/**
	  *航程 列名 
	  */
    public static final String COL_sail  = "C_SAIL";
	
	/**
	  *航空公司 列名 
	  */
    public static final String COL_aircompany  = "C_AIRCOMPANY";
	
	/**
	  *航班 列名 
	  */
    public static final String COL_flightnum  = "C_FLIGHTNUM";
	
	/**
	  *航班日期 列名 
	  */
    public static final String COL_flighttime  = "C_FLIGHTTIME";
	
	/**
	  *舱位 列名 
	  */
    public static final String COL_cabin  = "C_CABIN";
	
	/**
	  *票面价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *机建 列名 
	  */
    public static final String COL_jijian  = "C_JIJIAN";
	
	/**
	  *燃油 列名 
	  */
    public static final String COL_ranyou  = "C_RANYOU";
	
	/**
	  *单张计算总计 列名 
	  */
    public static final String COL_talfee  = "C_TALFEE";
	
	/**
	  *行程 列名 
	  */
    public static final String COL_journeytype  = "C_JOURNEYTYPE";
	
	/**
	  *服务费 列名 
	  */
    public static final String COL_fuwufei  = "C_FUWUFEI";

	//ID
	private long id;    
    

	//出票时间
	private Timestamp rttime;    
    

	//订单号
	private String ordercode;    
    

	//PNR
	private String pnr;    
    

	//订单人数
	private Long number;    
    

	//退票人数
	private Long rnumber;    
    

	//退费票申请时间
	private Timestamp applytime;    
    

	//状态
	private String state;    
    

	//OFFICE
	private String office;    
    

	//退款金额
	private Double tuiprice;    
    

	//退款时间
	private Timestamp tuitime;    
    

	//票号
	private String ticketno;    
    

	//乘机人
	private String passenger;    
    

	//乘机人类型
	private String ptype;    
    

	//出发城市
	private String startcity;    
    

	//到达城市
	private String endcity;    
    

	//航程
	private String sail;    
    

	//航空公司
	private String aircompany;    
    

	//航班
	private String flightnum;    
    

	//航班日期
	private Timestamp flighttime;    
    

	//舱位
	private String cabin;    
    

	//票面价
	private Double price;    
    

	//机建
	private Double jijian;    
    

	//燃油
	private Double ranyou;    
    

	//单张计算总计
	private Double talfee;    
    

	//行程
	private String journeytype;    
    

	//服务费
	private Double fuwufei;    
    

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
	 * get出票时间
	 */
    public Timestamp getRttime(){
         return rttime;
    }

	/**
	 * set出票时间
	 */
    public void setRttime(Timestamp rttime){
         this.rttime=rttime;
    }

	/**
	 * get订单号
	 */
    public String getOrdercode(){
         return ordercode;
    }

	/**
	 * set订单号
	 */
    public void setOrdercode(String ordercode){
         this.ordercode=ordercode;
    }

	/**
	 * getPNR
	 */
    public String getPnr(){
         return pnr;
    }

	/**
	 * setPNR
	 */
    public void setPnr(String pnr){
         this.pnr=pnr;
    }

	/**
	 * get订单人数
	 */
    public Long getNumber(){
         return number;
    }

	/**
	 * set订单人数
	 */
    public void setNumber(Long number){
         this.number=number;
    }

	/**
	 * get退票人数
	 */
    public Long getRnumber(){
         return rnumber;
    }

	/**
	 * set退票人数
	 */
    public void setRnumber(Long rnumber){
         this.rnumber=rnumber;
    }

	/**
	 * get退费票申请时间
	 */
    public Timestamp getApplytime(){
         return applytime;
    }

	/**
	 * set退费票申请时间
	 */
    public void setApplytime(Timestamp applytime){
         this.applytime=applytime;
    }

	/**
	 * get状态
	 */
    public String getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(String state){
         this.state=state;
    }

	/**
	 * getOFFICE
	 */
    public String getOffice(){
         return office;
    }

	/**
	 * setOFFICE
	 */
    public void setOffice(String office){
         this.office=office;
    }

	/**
	 * get退款金额
	 */
    public Double getTuiprice(){
         return tuiprice;
    }

	/**
	 * set退款金额
	 */
    public void setTuiprice(Double tuiprice){
         this.tuiprice=tuiprice;
    }

	/**
	 * get退款时间
	 */
    public Timestamp getTuitime(){
         return tuitime;
    }

	/**
	 * set退款时间
	 */
    public void setTuitime(Timestamp tuitime){
         this.tuitime=tuitime;
    }

	/**
	 * get票号
	 */
    public String getTicketno(){
         return ticketno;
    }

	/**
	 * set票号
	 */
    public void setTicketno(String ticketno){
         this.ticketno=ticketno;
    }

	/**
	 * get乘机人
	 */
    public String getPassenger(){
         return passenger;
    }

	/**
	 * set乘机人
	 */
    public void setPassenger(String passenger){
         this.passenger=passenger;
    }

	/**
	 * get乘机人类型
	 */
    public String getPtype(){
         return ptype;
    }

	/**
	 * set乘机人类型
	 */
    public void setPtype(String ptype){
         this.ptype=ptype;
    }

	/**
	 * get出发城市
	 */
    public String getStartcity(){
         return startcity;
    }

	/**
	 * set出发城市
	 */
    public void setStartcity(String startcity){
         this.startcity=startcity;
    }

	/**
	 * get到达城市
	 */
    public String getEndcity(){
         return endcity;
    }

	/**
	 * set到达城市
	 */
    public void setEndcity(String endcity){
         this.endcity=endcity;
    }

	/**
	 * get航程
	 */
    public String getSail(){
         return sail;
    }

	/**
	 * set航程
	 */
    public void setSail(String sail){
         this.sail=sail;
    }

	/**
	 * get航空公司
	 */
    public String getAircompany(){
         return aircompany;
    }

	/**
	 * set航空公司
	 */
    public void setAircompany(String aircompany){
         this.aircompany=aircompany;
    }

	/**
	 * get航班
	 */
    public String getFlightnum(){
         return flightnum;
    }

	/**
	 * set航班
	 */
    public void setFlightnum(String flightnum){
         this.flightnum=flightnum;
    }

	/**
	 * get航班日期
	 */
    public Timestamp getFlighttime(){
         return flighttime;
    }

	/**
	 * set航班日期
	 */
    public void setFlighttime(Timestamp flighttime){
         this.flighttime=flighttime;
    }

	/**
	 * get舱位
	 */
    public String getCabin(){
         return cabin;
    }

	/**
	 * set舱位
	 */
    public void setCabin(String cabin){
         this.cabin=cabin;
    }

	/**
	 * get票面价
	 */
    public Double getPrice(){
         return price;
    }

	/**
	 * set票面价
	 */
    public void setPrice(Double price){
         this.price=price;
    }

	/**
	 * get机建
	 */
    public Double getJijian(){
         return jijian;
    }

	/**
	 * set机建
	 */
    public void setJijian(Double jijian){
         this.jijian=jijian;
    }

	/**
	 * get燃油
	 */
    public Double getRanyou(){
         return ranyou;
    }

	/**
	 * set燃油
	 */
    public void setRanyou(Double ranyou){
         this.ranyou=ranyou;
    }

	/**
	 * get单张计算总计
	 */
    public Double getTalfee(){
         return talfee;
    }

	/**
	 * set单张计算总计
	 */
    public void setTalfee(Double talfee){
         this.talfee=talfee;
    }

	/**
	 * get行程
	 */
    public String getJourneytype(){
         return journeytype;
    }

	/**
	 * set行程
	 */
    public void setJourneytype(String journeytype){
         this.journeytype=journeytype;
    }

	/**
	 * get服务费
	 */
    public Double getFuwufei(){
         return fuwufei;
    }

	/**
	 * set服务费
	 */
    public void setFuwufei(Double fuwufei){
         this.fuwufei=fuwufei;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + rttime +"|"
	   
	 + ordercode +"|"
	   
	 + pnr +"|"
	   
	 + number +"|"
	   
	 + rnumber +"|"
	   
	 + applytime +"|"
	   
	 + state +"|"
	   
	 + office +"|"
	   
	 + tuiprice +"|"
	   
	 + tuitime +"|"
	   
	 + ticketno +"|"
	   
	 + passenger +"|"
	   
	 + ptype +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + sail +"|"
	   
	 + aircompany +"|"
	   
	 + flightnum +"|"
	   
	 + flighttime +"|"
	   
	 + cabin +"|"
	   
	 + price +"|"
	   
	 + jijian +"|"
	   
	 + ranyou +"|"
	   
	 + talfee +"|"
	   
	 + journeytype +"|"
	   
	 + fuwufei
	 + "]";
 } 

}
