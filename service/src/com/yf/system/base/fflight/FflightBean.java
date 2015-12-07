/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fflight;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票行程
 */
public class FflightBean implements java.io.Serializable{

	/**
	  *国际机票行程 表名
	  */
	public static final String TABLE  = "T_FFLIGHT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *国际机票订单id 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *总机票 列名 
	  */
    public static final String COL_totalfare  = "C_TOTALFARE";
	
	/**
	  *总税费 列名 
	  */
    public static final String COL_totaltax  = "C_TOTALTAX";
	
	/**
	  *政策标识 列名 
	  */
    public static final String COL_policymark  = "C_POLICYMARK";
	
	/**
	  *国际航公司代码 列名 
	  */
    public static final String COL_aircom  = "C_AIRCOM";
	
	/**
	  *航位信息 列名 
	  */
    public static final String COL_cw  = "C_CW";
	
	/**
	  *起飞机场 列名 
	  */
    public static final String COL_fromairport  = "C_FROMAIRPORT";
	
	/**
	  *到达机场 列名 
	  */
    public static final String COL_toairport  = "C_TOAIRPORT";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_fromdate  = "C_FROMDATE";
    
    /**
     * 到达时间
     */
	public static final String COL_todate="C_TODATE";
    
	/**
	  *国际航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";

	//ID
	private long id;    
    

	//国际机票订单id
	private Long orderid;    
    

	//总机票
	private Double totalfare;    
    

	//总税费
	private Double totaltax;    
    

	//政策标识
	private String policymark;    
    

	//国际航公司代码
	private String aircom;    
    

	//航位信息
	private String cw;    
    

	//起飞机场
	private String fromairport;    
    

	//到达机场
	private String toairport;    
    

	//起飞时间
	private Timestamp fromdate;   
	
	//到达时间
	private Timestamp todate;
    

	//国际航班号
	private String flightnumber;    
    

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
	 * get国际机票订单id
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set国际机票订单id
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get总机票
	 */
    public Double getTotalfare(){
         return totalfare;
    }

	/**
	 * set总机票
	 */
    public void setTotalfare(Double totalfare){
         this.totalfare=totalfare;
    }

	/**
	 * get总税费
	 */
    public Double getTotaltax(){
         return totaltax;
    }

	/**
	 * set总税费
	 */
    public void setTotaltax(Double totaltax){
         this.totaltax=totaltax;
    }

	/**
	 * get政策标识
	 */
    public String getPolicymark(){
         return policymark;
    }

	/**
	 * set政策标识
	 */
    public void setPolicymark(String policymark){
         this.policymark=policymark;
    }

	/**
	 * get国际航公司代码
	 */
    public String getAircom(){
         return aircom;
    }

	/**
	 * set国际航公司代码
	 */
    public void setAircom(String aircom){
         this.aircom=aircom;
    }

	/**
	 * get航位信息
	 */
    public String getCw(){
         return cw;
    }

	/**
	 * set航位信息
	 */
    public void setCw(String cw){
         this.cw=cw;
    }

	/**
	 * get起飞机场
	 */
    public String getFromairport(){
         return fromairport;
    }

	/**
	 * set起飞机场
	 */
    public void setFromairport(String fromairport){
         this.fromairport=fromairport;
    }

	/**
	 * get到达机场
	 */
    public String getToairport(){
         return toairport;
    }

	/**
	 * set到达机场
	 */
    public void setToairport(String toairport){
         this.toairport=toairport;
    }

	/**
	 * get起飞时间
	 */
    public Timestamp getFromdate(){
         return fromdate;
    }

	/**
	 * set起飞时间
	 */
    public void setFromdate(Timestamp fromdate){
         this.fromdate=fromdate;
    }

	/**
	 * get国际航班号
	 */
    public String getFlightnumber(){
         return flightnumber;
    }

	/**
	 * set国际航班号
	 */
    public void setFlightnumber(String flightnumber){
         this.flightnumber=flightnumber;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + totalfare +"|"
	   
	 + totaltax +"|"
	   
	 + policymark +"|"
	   
	 + aircom +"|"
	   
	 + cw +"|"
	   
	 + fromairport +"|"
	   
	 + toairport +"|"
	   
	 + fromdate +"|"
	 
	 + todate +"|"
	   
	 + flightnumber
	 + "]";
 }

	public Timestamp getTodate() {
		return todate;
	}

	public void setTodate(Timestamp todate) {
		this.todate = todate;
	} 

}
