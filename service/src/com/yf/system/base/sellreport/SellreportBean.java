/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.sellreport;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *销售报表
 */
public class SellreportBean implements java.io.Serializable{

	/**
	  *销售报表 表名
	  */
	public static final String TABLE  = "T_SELLREPORT";

	
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
	  *出票效率 列名 
	  */
    public static final String COL_xiaolv  = "C_XIAOLV";
	
	/**
	  *出票人 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *PNR 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *订单保证金 列名 
	  */
    public static final String COL_recognizance  = "C_RECOGNIZANCE";
	
	/**
	  *票面总计 列名 
	  */
    public static final String COL_subprice  = "C_SUBPRICE";
	
	/**
	  *净价总计 列名 
	  */
    public static final String COL_jingjia  = "C_JINGJIA";
	
	/**
	  *机建燃油总计 列名 
	  */
    public static final String COL_jijianranyou  = "C_JIJIANRANYOU";
	
	/**
	  *总手续费 列名 
	  */
    public static final String COL_poundage  = "C_POUNDAGE";
	
	/**
	  *实收总计 列名 
	  */
    public static final String COL_pactprice  = "C_PACTPRICE";
	
	/**
	  *支付方式 列名 
	  */
    public static final String COL_paytype  = "C_PAYTYPE";
	
	/**
	  *订单类型 列名 
	  */
    public static final String COL_ordertype  = "C_ORDERTYPE";
	
	/**
	  *机票类型 列名 
	  */
    public static final String COL_tickettype  = "C_TICKETTYPE";
	
	/**
	  *行程类型 列名 
	  */
    public static final String COL_journeytype  = "C_JOURNEYTYPE";
	
	/**
	  *出票方式 列名 
	  */
    public static final String COL_chupiaotype  = "C_CHUPIAOTYPE";
	
	/**
	  *OFFICE 列名 
	  */
    public static final String COL_office  = "C_OFFICE";
	
	/**
	  *乘机人 列名 
	  */
    public static final String COL_passenger  = "C_PASSENGER";
	
	/**
	  *乘机人类型 列名 
	  */
    public static final String COL_usertype  = "C_USERTYPE";
	
	/**
	  *出发地 列名 
	  */
    public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *目的地 列名 
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
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *航班日期 列名 
	  */
    public static final String COL_flighttime  = "C_FLIGHTTIME";
	
	/**
	  *舱位 列名 
	  */
    public static final String COL_cabin  = "C_CABIN";
	
	/**
	  *政策 列名 
	  */
    public static final String COL_policy  = "C_POLICY";
	
	/**
	  *票面价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *单张净价 列名 
	  */
    public static final String COL_leafletsnet  = "C_LEAFLETSNET";
	
	/**
	  *机建 列名 
	  */
    public static final String COL_jijian  = "C_JIJIAN";
	
	/**
	  *燃油 列名 
	  */
    public static final String COL_ranyou  = "C_RANYOU";
	
	/**
	  *单张结算价 列名 
	  */
    public static final String COL_jiesuanprice  = "C_JIESUANPRICE";
	
	/**
	  *支付航空公司 列名 
	  */
    public static final String COL_payaircompany  = "C_PAYAIRCOMPANY";
	
	/**
	  *支付类型 列名 
	  */
    public static final String COL_zhifuleixing  = "C_ZHIFULEIXING";
	
	/**
	  *票证来源 列名 
	  */
    public static final String COL_laiyuan  = "C_LAIYUAN";
	
	/**
	  *后返利润 列名 
	  */
    public static final String COL_houfan  = "C_HOUFAN";
	
	/**
	  *实际利润 列名 
	  */
    public static final String COL_shijilirun  = "C_SHIJILIRUN";
	
	/**
	  *加收服务费 列名 
	  */
    public static final String COL_fuwufei  = "C_FUWUFEI";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_remark  = "C_REMARK";
	
	/**
	  *票号 列名 
	  */
    public static final String COL_piaohao  = "C_PIAOHAO";

	//ID
	private long id;    
    

	//出票时间
	private Timestamp rttime;    
    

	//订单号
	private String ordercode;    
    

	//出票效率
	private String xiaolv;    
    

	//出票人
	private String username;    
    

	//PNR
	private String pnr;    
    

	//人数
	private Long number;    
    

	//订单保证金
	private Double recognizance;    
    

	//票面总计
	private Double subprice;    
    

	//净价总计
	private Double jingjia;    
    

	//机建燃油总计
	private Double jijianranyou;    
    

	//总手续费
	private Double poundage;    
    

	//实收总计
	private Double pactprice;    
    

	//支付方式
	private String paytype;    
    

	//订单类型
	private String ordertype;    
    

	//机票类型
	private String tickettype;    
    

	//行程类型
	private String journeytype;    
    

	//出票方式
	private String chupiaotype;    
    

	//OFFICE
	private String office;    
    

	//乘机人
	private String passenger;    
    

	//乘机人类型
	private String usertype;    
    

	//出发地
	private String startcity;    
    

	//目的地
	private String endcity;    
    

	//航程
	private String sail;    
    

	//航空公司
	private String aircompany;    
    

	//航班
	private String flightnumber;    
    

	//航班日期
	private Timestamp flighttime;    
    

	//舱位
	private String cabin;    
    

	//政策
	private String policy;    
    

	//票面价
	private Double price;    
    

	//单张净价
	private Double leafletsnet;    
    

	//机建
	private Double jijian;    
    

	//燃油
	private Double ranyou;    
    

	//单张结算价
	private Double jiesuanprice;    
    

	//支付航空公司
	private String payaircompany;    
    

	//支付类型
	private String zhifuleixing;    
    

	//票证来源
	private String laiyuan;    
    

	//后返利润
	private Double houfan;    
    

	//实际利润
	private Double shijilirun;    
    

	//加收服务费
	private Double fuwufei;    
    

	//备注
	private String remark;    
    

	//票号
	private String piaohao;    
    

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
	 * get出票效率
	 */
    public String getXiaolv(){
         return xiaolv;
    }

	/**
	 * set出票效率
	 */
    public void setXiaolv(String xiaolv){
         this.xiaolv=xiaolv;
    }

	/**
	 * get出票人
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set出票人
	 */
    public void setUsername(String username){
         this.username=username;
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
	 * get订单保证金
	 */
    public Double getRecognizance(){
         return recognizance;
    }

	/**
	 * set订单保证金
	 */
    public void setRecognizance(Double recognizance){
         this.recognizance=recognizance;
    }

	/**
	 * get票面总计
	 */
    public Double getSubprice(){
         return subprice;
    }

	/**
	 * set票面总计
	 */
    public void setSubprice(Double subprice){
         this.subprice=subprice;
    }

	/**
	 * get净价总计
	 */
    public Double getJingjia(){
         return jingjia;
    }

	/**
	 * set净价总计
	 */
    public void setJingjia(Double jingjia){
         this.jingjia=jingjia;
    }

	/**
	 * get机建燃油总计
	 */
    public Double getJijianranyou(){
         return jijianranyou;
    }

	/**
	 * set机建燃油总计
	 */
    public void setJijianranyou(Double jijianranyou){
         this.jijianranyou=jijianranyou;
    }

	/**
	 * get总手续费
	 */
    public Double getPoundage(){
         return poundage;
    }

	/**
	 * set总手续费
	 */
    public void setPoundage(Double poundage){
         this.poundage=poundage;
    }

	/**
	 * get实收总计
	 */
    public Double getPactprice(){
         return pactprice;
    }

	/**
	 * set实收总计
	 */
    public void setPactprice(Double pactprice){
         this.pactprice=pactprice;
    }

	/**
	 * get支付方式
	 */
    public String getPaytype(){
         return paytype;
    }

	/**
	 * set支付方式
	 */
    public void setPaytype(String paytype){
         this.paytype=paytype;
    }

	/**
	 * get订单类型
	 */
    public String getOrdertype(){
         return ordertype;
    }

	/**
	 * set订单类型
	 */
    public void setOrdertype(String ordertype){
         this.ordertype=ordertype;
    }

	/**
	 * get机票类型
	 */
    public String getTickettype(){
         return tickettype;
    }

	/**
	 * set机票类型
	 */
    public void setTickettype(String tickettype){
         this.tickettype=tickettype;
    }

	/**
	 * get行程类型
	 */
    public String getJourneytype(){
         return journeytype;
    }

	/**
	 * set行程类型
	 */
    public void setJourneytype(String journeytype){
         this.journeytype=journeytype;
    }

	/**
	 * get出票方式
	 */
    public String getChupiaotype(){
         return chupiaotype;
    }

	/**
	 * set出票方式
	 */
    public void setChupiaotype(String chupiaotype){
         this.chupiaotype=chupiaotype;
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
    public String getUsertype(){
         return usertype;
    }

	/**
	 * set乘机人类型
	 */
    public void setUsertype(String usertype){
         this.usertype=usertype;
    }

	/**
	 * get出发地
	 */
    public String getStartcity(){
         return startcity;
    }

	/**
	 * set出发地
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
    public String getFlightnumber(){
         return flightnumber;
    }

	/**
	 * set航班
	 */
    public void setFlightnumber(String flightnumber){
         this.flightnumber=flightnumber;
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
	 * get政策
	 */
    public String getPolicy(){
         return policy;
    }

	/**
	 * set政策
	 */
    public void setPolicy(String policy){
         this.policy=policy;
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
	 * get单张净价
	 */
    public Double getLeafletsnet(){
         return leafletsnet;
    }

	/**
	 * set单张净价
	 */
    public void setLeafletsnet(Double leafletsnet){
         this.leafletsnet=leafletsnet;
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
	 * get单张结算价
	 */
    public Double getJiesuanprice(){
         return jiesuanprice;
    }

	/**
	 * set单张结算价
	 */
    public void setJiesuanprice(Double jiesuanprice){
         this.jiesuanprice=jiesuanprice;
    }

	/**
	 * get支付航空公司
	 */
    public String getPayaircompany(){
         return payaircompany;
    }

	/**
	 * set支付航空公司
	 */
    public void setPayaircompany(String payaircompany){
         this.payaircompany=payaircompany;
    }

	/**
	 * get支付类型
	 */
    public String getZhifuleixing(){
         return zhifuleixing;
    }

	/**
	 * set支付类型
	 */
    public void setZhifuleixing(String zhifuleixing){
         this.zhifuleixing=zhifuleixing;
    }

	/**
	 * get票证来源
	 */
    public String getLaiyuan(){
         return laiyuan;
    }

	/**
	 * set票证来源
	 */
    public void setLaiyuan(String laiyuan){
         this.laiyuan=laiyuan;
    }

	/**
	 * get后返利润
	 */
    public Double getHoufan(){
         return houfan;
    }

	/**
	 * set后返利润
	 */
    public void setHoufan(Double houfan){
         this.houfan=houfan;
    }

	/**
	 * get实际利润
	 */
    public Double getShijilirun(){
         return shijilirun;
    }

	/**
	 * set实际利润
	 */
    public void setShijilirun(Double shijilirun){
         this.shijilirun=shijilirun;
    }

	/**
	 * get加收服务费
	 */
    public Double getFuwufei(){
         return fuwufei;
    }

	/**
	 * set加收服务费
	 */
    public void setFuwufei(Double fuwufei){
         this.fuwufei=fuwufei;
    }

	/**
	 * get备注
	 */
    public String getRemark(){
         return remark;
    }

	/**
	 * set备注
	 */
    public void setRemark(String remark){
         this.remark=remark;
    }

	/**
	 * get票号
	 */
    public String getPiaohao(){
         return piaohao;
    }

	/**
	 * set票号
	 */
    public void setPiaohao(String piaohao){
         this.piaohao=piaohao;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + rttime +"|"
	   
	 + ordercode +"|"
	   
	 + xiaolv +"|"
	   
	 + username +"|"
	   
	 + pnr +"|"
	   
	 + number +"|"
	   
	 + recognizance +"|"
	   
	 + subprice +"|"
	   
	 + jingjia +"|"
	   
	 + jijianranyou +"|"
	   
	 + poundage +"|"
	   
	 + pactprice +"|"
	   
	 + paytype +"|"
	   
	 + ordertype +"|"
	   
	 + tickettype +"|"
	   
	 + journeytype +"|"
	   
	 + chupiaotype +"|"
	   
	 + office +"|"
	   
	 + passenger +"|"
	   
	 + usertype +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + sail +"|"
	   
	 + aircompany +"|"
	   
	 + flightnumber +"|"
	   
	 + flighttime +"|"
	   
	 + cabin +"|"
	   
	 + policy +"|"
	   
	 + price +"|"
	   
	 + leafletsnet +"|"
	   
	 + jijian +"|"
	   
	 + ranyou +"|"
	   
	 + jiesuanprice +"|"
	   
	 + payaircompany +"|"
	   
	 + zhifuleixing +"|"
	   
	 + laiyuan +"|"
	   
	 + houfan +"|"
	   
	 + shijilirun +"|"
	   
	 + fuwufei +"|"
	   
	 + remark +"|"
	   
	 + piaohao
	 + "]";
 } 

}
