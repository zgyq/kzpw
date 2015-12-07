/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.jinribaobiao;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *今日报表
 */
public class JinribaobiaoBean implements java.io.Serializable{

	/**
	  *今日报表 表名
	  */
	public static final String TABLE  = "T_JINRIBAOBIAO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单时间 列名 
	  */
    public static final String COL_ordertime  = "C_ORDERTIME";
	
	/**
	  *PNR 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *票号 列名 
	  */
    public static final String COL_ticketcode  = "C_TICKETCODE";
	
	/**
	  *订单编号 列名 
	  */
    public static final String COL_ordercode  = "C_ORDERCODE";
	
	/**
	  *客户姓名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *始发地 列名 
	  */
    public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *目的地 列名 
	  */
    public static final String COL_endcity  = "C_ENDCITY";
	
	/**
	  *始发地三字码 列名 
	  */
    public static final String COL_startcityszm  = "C_STARTCITYSZM";
	
	/**
	  *目的地三字码 列名 
	  */
    public static final String COL_endcityszm  = "C_ENDCITYSZM";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *仓位码 列名 
	  */
    public static final String COL_cabincode  = "C_CABINCODE";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_flightdate  = "C_FLIGHTDATE";
	
	/**
	  *票面价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *同行返点 列名 
	  */
    public static final String COL_fandian  = "C_FANDIAN";
	
	/**
	  *机建燃油 列名 
	  */
    public static final String COL_jijianranyou  = "C_JIJIANRANYOU";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *收款金额 列名 
	  */
    public static final String COL_submoney  = "C_SUBMONEY";
	
	/**
	  *手续费 列名 
	  */
    public static final String COL_shouxufei  = "C_SHOUXUFEI";
	
	/**
	  *退款金额 列名 
	  */
    public static final String COL_tuikuan  = "C_TUIKUAN";
	
	/**
	  *应收 列名 
	  */
    public static final String COL_yingshou  = "C_YINGSHOU";
	
	/**
	  *利润 列名 
	  */
    public static final String COL_lirun  = "C_LIRUN";
	
	/**
	  *支付方式 列名 
	  */
    public static final String COL_paymethod  = "C_PAYMETHOD";
	
	/**
	  *支付时间 列名 
	  */
    public static final String COL_paytime  = "C_PAYTIME";
	
	/**
	  *废票时间 列名 
	  */
    public static final String COL_feitime  = "C_FEITIME";
	
	/**
	  *出票时间 列名 
	  */
    public static final String COL_rttime  = "C_RTTIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//订单时间
	private Timestamp ordertime;    
    

	//PNR
	private String pnr;    
    

	//票号
	private String ticketcode;    
    

	//订单编号
	private String ordercode;    
    

	//客户姓名
	private String username;    
    

	//始发地
	private String startcity;    
    

	//目的地
	private String endcity;    
    

	//始发地三字码
	private String startcityszm;    
    

	//目的地三字码
	private String endcityszm;    
    

	//航班号
	private String flightnumber;    
    

	//仓位码
	private String cabincode;    
    

	//起飞时间
	private Timestamp flightdate;    
    

	//票面价
	private Double price;    
    

	//同行返点
	private Double fandian;    
    

	//机建燃油
	private Double jijianranyou;    
    

	//人数
	private Long number;    
    

	//收款金额
	private Double submoney;    
    

	//手续费
	private Double shouxufei;    
    

	//退款金额
	private Double tuikuan;    
    

	//应收
	private Double yingshou;    
    

	//利润
	private Double lirun;    
    

	//支付方式
	private String paymethod;    
    

	//支付时间
	private Timestamp paytime;    
    

	//废票时间
	private Timestamp feitime;    
    

	//出票时间
	private Timestamp rttime;    
    

	//状态
	private String state;    
    

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
	 * get订单时间
	 */
    public Timestamp getOrdertime(){
         return ordertime;
    }

	/**
	 * set订单时间
	 */
    public void setOrdertime(Timestamp ordertime){
         this.ordertime=ordertime;
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
	 * get票号
	 */
    public String getTicketcode(){
         return ticketcode;
    }

	/**
	 * set票号
	 */
    public void setTicketcode(String ticketcode){
         this.ticketcode=ticketcode;
    }

	/**
	 * get订单编号
	 */
    public String getOrdercode(){
         return ordercode;
    }

	/**
	 * set订单编号
	 */
    public void setOrdercode(String ordercode){
         this.ordercode=ordercode;
    }

	/**
	 * get客户姓名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set客户姓名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get始发地
	 */
    public String getStartcity(){
         return startcity;
    }

	/**
	 * set始发地
	 */
    public void setStartcity(String startcity){
         this.startcity=startcity;
    }

	/**
	 * get目的地
	 */
    public String getEndcity(){
         return endcity;
    }

	/**
	 * set目的地
	 */
    public void setEndcity(String endcity){
         this.endcity=endcity;
    }

	/**
	 * get始发地三字码
	 */
    public String getStartcityszm(){
         return startcityszm;
    }

	/**
	 * set始发地三字码
	 */
    public void setStartcityszm(String startcityszm){
         this.startcityszm=startcityszm;
    }

	/**
	 * get目的地三字码
	 */
    public String getEndcityszm(){
         return endcityszm;
    }

	/**
	 * set目的地三字码
	 */
    public void setEndcityszm(String endcityszm){
         this.endcityszm=endcityszm;
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
	 * get仓位码
	 */
    public String getCabincode(){
         return cabincode;
    }

	/**
	 * set仓位码
	 */
    public void setCabincode(String cabincode){
         this.cabincode=cabincode;
    }

	/**
	 * get起飞时间
	 */
    public Timestamp getFlightdate(){
         return flightdate;
    }

	/**
	 * set起飞时间
	 */
    public void setFlightdate(Timestamp flightdate){
         this.flightdate=flightdate;
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
	 * get同行返点
	 */
    public Double getFandian(){
         return fandian;
    }

	/**
	 * set同行返点
	 */
    public void setFandian(Double fandian){
         this.fandian=fandian;
    }

	/**
	 * get机建燃油
	 */
    public Double getJijianranyou(){
         return jijianranyou;
    }

	/**
	 * set机建燃油
	 */
    public void setJijianranyou(Double jijianranyou){
         this.jijianranyou=jijianranyou;
    }

	/**
	 * get人数
	 */
    public Long getNumber(){
         return number;
    }

	/**
	 * set人数
	 */
    public void setNumber(Long number){
         this.number=number;
    }

	/**
	 * get收款金额
	 */
    public Double getSubmoney(){
         return submoney;
    }

	/**
	 * set收款金额
	 */
    public void setSubmoney(Double submoney){
         this.submoney=submoney;
    }

	/**
	 * get手续费
	 */
    public Double getShouxufei(){
         return shouxufei;
    }

	/**
	 * set手续费
	 */
    public void setShouxufei(Double shouxufei){
         this.shouxufei=shouxufei;
    }

	/**
	 * get退款金额
	 */
    public Double getTuikuan(){
         return tuikuan;
    }

	/**
	 * set退款金额
	 */
    public void setTuikuan(Double tuikuan){
         this.tuikuan=tuikuan;
    }

	/**
	 * get应收
	 */
    public Double getYingshou(){
         return yingshou;
    }

	/**
	 * set应收
	 */
    public void setYingshou(Double yingshou){
         this.yingshou=yingshou;
    }

	/**
	 * get利润
	 */
    public Double getLirun(){
         return lirun;
    }

	/**
	 * set利润
	 */
    public void setLirun(Double lirun){
         this.lirun=lirun;
    }

	/**
	 * get支付方式
	 */
    public String getPaymethod(){
         return paymethod;
    }

	/**
	 * set支付方式
	 */
    public void setPaymethod(String paymethod){
         this.paymethod=paymethod;
    }

	/**
	 * get支付时间
	 */
    public Timestamp getPaytime(){
         return paytime;
    }

	/**
	 * set支付时间
	 */
    public void setPaytime(Timestamp paytime){
         this.paytime=paytime;
    }

	/**
	 * get废票时间
	 */
    public Timestamp getFeitime(){
         return feitime;
    }

	/**
	 * set废票时间
	 */
    public void setFeitime(Timestamp feitime){
         this.feitime=feitime;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + ordertime +"|"
	   
	 + pnr +"|"
	   
	 + ticketcode +"|"
	   
	 + ordercode +"|"
	   
	 + username +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + startcityszm +"|"
	   
	 + endcityszm +"|"
	   
	 + flightnumber +"|"
	   
	 + cabincode +"|"
	   
	 + flightdate +"|"
	   
	 + price +"|"
	   
	 + fandian +"|"
	   
	 + jijianranyou +"|"
	   
	 + number +"|"
	   
	 + submoney +"|"
	   
	 + shouxufei +"|"
	   
	 + tuikuan +"|"
	   
	 + yingshou +"|"
	   
	 + lirun +"|"
	   
	 + paymethod +"|"
	   
	 + paytime +"|"
	   
	 + feitime +"|"
	   
	 + rttime +"|"
	   
	 + state
	 + "]";
 } 

}
