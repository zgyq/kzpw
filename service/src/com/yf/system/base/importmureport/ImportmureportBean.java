/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.importmureport;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *东航销售明细导入
 */
public class ImportmureportBean implements java.io.Serializable{

	/**
	  *东航销售明细导入 表名
	  */
	public static final String TABLE  = "T_IMPORTMUREPORT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *票号 列名 
	  */
    public static final String COL_ticketnumber  = "C_TICKETNUMBER";
	
	/**
	  *批量支付 列名 
	  */
    public static final String COL_payall  = "C_PAYALL";
	
	/**
	  *PNR 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *成人 列名 
	  */
    public static final String COL_chengren  = "C_CHENGREN";
	
	/**
	  *儿童 列名 
	  */
    public static final String COL_ertong  = "C_ERTONG";
	
	/**
	  *航程 列名 
	  */
    public static final String COL_voyage  = "C_VOYAGE";
	
	/**
	  *舱位 列名 
	  */
    public static final String COL_cabin  = "C_CABIN";
	
	/**
	  *票面金额 列名 
	  */
    public static final String COL_ticketprice  = "C_TICKETPRICE";
	
	/**
	  *税 列名 
	  */
    public static final String COL_fee  = "C_FEE";
	
	/**
	  *实际支付金额 列名 
	  */
    public static final String COL_payprice  = "C_PAYPRICE";
	
	/**
	  *代理费 列名 
	  */
    public static final String COL_daiprice  = "C_DAIPRICE";
	
	/**
	  *支付银行 列名 
	  */
    public static final String COL_paybank  = "C_PAYBANK";
	
	/**
	  *银行票号 列名 
	  */
    public static final String COL_banknumber  = "C_BANKNUMBER";
	
	/**
	  *出票时间 列名 
	  */
    public static final String COL_time  = "C_TIME";
	
	/**
	  *入库人ID 列名 
	  */
    public static final String COL_storageid  = "C_STORAGEID";
	
	/**
	  *出票人ID 列名 
	  */
    public static final String COL_chupiaoid  = "C_CHUPIAOID";
	
	/**
	  *比对状态 列名 
	  */
    public static final String COL_compstate  = "C_COMPSTATE";
	
	/**
	  *机票状态 列名 
	  */
    public static final String COL_ticketstate  = "C_TICKETSTATE";

	//ID
	private long id;    
    

	//票号
	private String ticketnumber;    
    

	//批量支付
	private String payall;    
    

	//PNR
	private String pnr;    
    

	//人数
	private Long number;    
    

	//成人
	private Long chengren;    
    

	//儿童
	private Long ertong;    
    

	//航程
	private String voyage;    
    

	//舱位
	private String cabin;    
    

	//票面金额
	private Double ticketprice;    
    

	//税
	private Double fee;    
    

	//实际支付金额
	private Double payprice;    
    

	//代理费
	private Double daiprice;    
    

	//支付银行
	private String paybank;    
    

	//银行票号
	private String banknumber;    
    

	//出票时间
	private Timestamp time;    
    

	//入库人ID
	private String storageid;    
    

	//出票人ID
	private String chupiaoid;    
    

	//比对状态
	private Long compstate;    
    

	//机票状态
	private Long ticketstate;    
    

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
	 * get票号
	 */
    public String getTicketnumber(){
         return ticketnumber;
    }

	/**
	 * set票号
	 */
    public void setTicketnumber(String ticketnumber){
         this.ticketnumber=ticketnumber;
    }

	/**
	 * get批量支付
	 */
    public String getPayall(){
         return payall;
    }

	/**
	 * set批量支付
	 */
    public void setPayall(String payall){
         this.payall=payall;
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
	 * get成人
	 */
    public Long getChengren(){
         return chengren;
    }

	/**
	 * set成人
	 */
    public void setChengren(Long chengren){
         this.chengren=chengren;
    }

	/**
	 * get儿童
	 */
    public Long getErtong(){
         return ertong;
    }

	/**
	 * set儿童
	 */
    public void setErtong(Long ertong){
         this.ertong=ertong;
    }

	/**
	 * get航程
	 */
    public String getVoyage(){
         return voyage;
    }

	/**
	 * set航程
	 */
    public void setVoyage(String voyage){
         this.voyage=voyage;
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
	 * get票面金额
	 */
    public Double getTicketprice(){
         return ticketprice;
    }

	/**
	 * set票面金额
	 */
    public void setTicketprice(Double ticketprice){
         this.ticketprice=ticketprice;
    }

	/**
	 * get税
	 */
    public Double getFee(){
         return fee;
    }

	/**
	 * set税
	 */
    public void setFee(Double fee){
         this.fee=fee;
    }

	/**
	 * get实际支付金额
	 */
    public Double getPayprice(){
         return payprice;
    }

	/**
	 * set实际支付金额
	 */
    public void setPayprice(Double payprice){
         this.payprice=payprice;
    }

	/**
	 * get代理费
	 */
    public Double getDaiprice(){
         return daiprice;
    }

	/**
	 * set代理费
	 */
    public void setDaiprice(Double daiprice){
         this.daiprice=daiprice;
    }

	/**
	 * get支付银行
	 */
    public String getPaybank(){
         return paybank;
    }

	/**
	 * set支付银行
	 */
    public void setPaybank(String paybank){
         this.paybank=paybank;
    }

	/**
	 * get银行票号
	 */
    public String getBanknumber(){
         return banknumber;
    }

	/**
	 * set银行票号
	 */
    public void setBanknumber(String banknumber){
         this.banknumber=banknumber;
    }

	/**
	 * get出票时间
	 */
    public Timestamp getTime(){
         return time;
    }

	/**
	 * set出票时间
	 */
    public void setTime(Timestamp time){
         this.time=time;
    }

	/**
	 * get入库人ID
	 */
    public String getStorageid(){
         return storageid;
    }

	/**
	 * set入库人ID
	 */
    public void setStorageid(String storageid){
         this.storageid=storageid;
    }

	/**
	 * get出票人ID
	 */
    public String getChupiaoid(){
         return chupiaoid;
    }

	/**
	 * set出票人ID
	 */
    public void setChupiaoid(String chupiaoid){
         this.chupiaoid=chupiaoid;
    }

	/**
	 * get比对状态
	 */
    public Long getCompstate(){
         return compstate;
    }

	/**
	 * set比对状态
	 */
    public void setCompstate(Long compstate){
         this.compstate=compstate;
    }

	/**
	 * get机票状态
	 */
    public Long getTicketstate(){
         return ticketstate;
    }

	/**
	 * set机票状态
	 */
    public void setTicketstate(Long ticketstate){
         this.ticketstate=ticketstate;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + ticketnumber +"|"
	   
	 + payall +"|"
	   
	 + pnr +"|"
	   
	 + number +"|"
	   
	 + chengren +"|"
	   
	 + ertong +"|"
	   
	 + voyage +"|"
	   
	 + cabin +"|"
	   
	 + ticketprice +"|"
	   
	 + fee +"|"
	   
	 + payprice +"|"
	   
	 + daiprice +"|"
	   
	 + paybank +"|"
	   
	 + banknumber +"|"
	   
	 + time +"|"
	   
	 + storageid +"|"
	   
	 + chupiaoid +"|"
	   
	 + compstate +"|"
	   
	 + ticketstate
	 + "]";
 } 

}
