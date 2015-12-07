/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.travelskyreport;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航空公司报表导入
 */
public class TravelskyreportBean implements java.io.Serializable{

	/**
	  *航空公司报表导入 表名
	  */
	public static final String TABLE  = "T_TRAVELSKYREPORT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *票号 列名 
	  */
    public static final String COL_tktnumber  = "C_TKTNUMBER";
	
	/**
	  *行程 列名 
	  */
    public static final String COL_origsest  = "C_ORIGSEST";
	
	/**
	  *票价 列名 
	  */
    public static final String COL_ticketprice  = "C_TICKETPRICE";
	
	/**
	  *税费 列名 
	  */
    public static final String COL_taxs  = "C_TAXS";
	
	/**
	  *返点 列名 
	  */
    public static final String COL_comm  = "C_COMM";
	
	/**
	  *PNR 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *代理人 列名 
	  */
    public static final String COL_agent  = "C_AGENT";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
    /**
	  *创建时间
	  */
    public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//票号
	private String tktnumber;    
    

	//行程
	private String origsest;    
    

	//票价
	private Double ticketprice;    
    

	//税费
	private Double taxs;    
    

	//返点
	private Double comm;    
    

	//PNR
	private String pnr;    
    

	//代理人
	private String agent;    
    

	//状态
	private Long status;   
	
	private Timestamp createtime;
    

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
    public String getTktnumber(){
         return tktnumber;
    }

	/**
	 * set票号
	 */
    public void setTktnumber(String tktnumber){
         this.tktnumber=tktnumber;
    }

	/**
	 * get行程
	 */
    public String getOrigsest(){
         return origsest;
    }

	/**
	 * set行程
	 */
    public void setOrigsest(String origsest){
         this.origsest=origsest;
    }

	/**
	 * get票价
	 */
    public Double getTicketprice(){
         return ticketprice;
    }

	/**
	 * set票价
	 */
    public void setTicketprice(Double ticketprice){
         this.ticketprice=ticketprice;
    }

	/**
	 * get税费
	 */
    public Double getTaxs(){
         return taxs;
    }

	/**
	 * set税费
	 */
    public void setTaxs(Double taxs){
         this.taxs=taxs;
    }

	/**
	 * get返点
	 */
    public Double getComm(){
         return comm;
    }

	/**
	 * set返点
	 */
    public void setComm(Double comm){
         this.comm=comm;
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
	 * get代理人
	 */
    public String getAgent(){
         return agent;
    }

	/**
	 * set代理人
	 */
    public void setAgent(String agent){
         this.agent=agent;
    }

	/**
	 * get状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Long status){
         this.status=status;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + tktnumber +"|"
	   
	 + origsest +"|"
	   
	 + ticketprice +"|"
	   
	 + taxs +"|"
	   
	 + comm +"|"
	   
	 + pnr +"|"
	   
	 + agent +"|"
	   
	 + status +"|"
	 
	 + createtime
	 
	 + "]";
 } 

}
