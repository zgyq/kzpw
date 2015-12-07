/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.insurorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *订单表
 */
public class InsurorderBean implements java.io.Serializable{

	/**
	  *订单表 表名
	  */
	public static final String TABLE  = "T_INSURORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *流水号 列名 
	  */
    public static final String COL_liushuno  = "C_LIUSHUINO";
	
	/**
	  *服务公司订单号 列名 
	  */
    public static final String COL_orderno  = "C_ORDERNO";
	
	/**
	  *保险类型 列名 
	  */
    public static final String COL_insuranttype  = "C_INSURANTTYPE";
	
	/**
	  *保险总份数 列名 
	  */
    public static final String COL_insurantcount  = "C_INSURANTCOUNT";
	
	/**
	  *订单状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *服务公司id 列名 
	  */
    public static final String COL_computerid  = "C_COMPUTERID";
	
	/**
	  *采购商id 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
	/**
	  *被保人id 列名 
	  */
    public static final String COL_insuruserid  = "C_INSURUSERID";
	
	/**
	  *采购商员工id 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *采购日期 列名 
	  */
    public static final String COL_time  = "C_TIME";
	
	/**
	  *起保日期 列名 
	  */
    public static final String COL_begintime  = "C_BEGINTIME";
	
	/**
	  *保险单价钱 列名 
	  */
    public static final String COL_insurmoney  = "C_INSURMONEY";
	
	/**
	  *订单总金额 列名 
	  */
    public static final String COL_totalmoney  = "C_TOTALMONEY";
	
	/**
	  *结束日期 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";

	//ID
	private long id;    
    

	//流水号
	private String liushuno;    
    

	//服务公司订单号
	private String orderno;    
    

	//保险类型
	private long insuranttype;    
    

	//保险总份数
	private long insurantcount;    
    

	//订单状态
	private Long status;    
    

	//服务公司id
	private long computerid;    
    

	//采购商id
	private long userid;    
    

	//被保人id
	private String insuruserid;    
    

	//采购商员工id
	private long agentid;    
    

	//采购日期
	private Timestamp time;    
    

	//起保日期
	private Timestamp begintime;    
    

	//保险单价钱
	private Double insurmoney;    
    

	//订单总金额
	private Double totalmoney;    
    

	//结束日期
	private Timestamp endtime;    
    

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
	 * get流水号
	 */
    public String getLiushuino(){
         return liushuno;
    }

	/**
	 * set流水号
	 */
    public void setLiushuino(String liushuno){
         this.liushuno=liushuno;
    }

	/**
	 * get服务公司订单号
	 */
    public String getOrderno(){
         return orderno;
    }

	/**
	 * set服务公司订单号
	 */
    public void setOrderno(String orderno){
         this.orderno=orderno;
    }

	/**
	 * get保险类型
	 */
    public long getInsuranttype(){
         return insuranttype;
    }

	/**
	 * set保险类型
	 */
    public void setInsuranttype(long insuranttype){
         this.insuranttype=insuranttype;
    }

	/**
	 * get保险总份数
	 */
    public long getInsurantcount(){
         return insurantcount;
    }

	/**
	 * set保险总份数
	 */
    public void setInsurantcount(long insurantcount){
         this.insurantcount=insurantcount;
    }

	/**
	 * get订单状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set订单状态
	 */
    public void setStatus(Long status){
         this.status=status;
    }

	/**
	 * get服务公司id
	 */
    public long getComputerid(){
         return computerid;
    }

	/**
	 * set服务公司id
	 */
    public void setComputerid(long computerid){
         this.computerid=computerid;
    }

	/**
	 * get采购商id
	 */
    public long getUserid(){
         return userid;
    }

	/**
	 * set采购商id
	 */
    public void setUserid(long userid){
         this.userid=userid;
    }

	/**
	 * get被保人id
	 */
    public String getInsuruserid(){
         return insuruserid;
    }

	/**
	 * set被保人id
	 */
    public void setInsuruserid(String insuruserid){
         this.insuruserid=insuruserid;
    }

	/**
	 * get采购商员工id
	 */
    public long getAgentid(){
         return agentid;
    }

	/**
	 * set采购商员工id
	 */
    public void setAgentid(long agentid){
         this.agentid=agentid;
    }

	/**
	 * get采购日期
	 */
    public Timestamp getTime(){
         return time;
    }

	/**
	 * set采购日期
	 */
    public void setTime(Timestamp time){
         this.time=time;
    }

	/**
	 * get起保日期
	 */
    public Timestamp getBegintime(){
         return begintime;
    }

	/**
	 * set起保日期
	 */
    public void setBegintime(Timestamp begintime){
         this.begintime=begintime;
    }

	/**
	 * get保险单价钱
	 */
    public Double getInsurmoney(){
         return insurmoney;
    }

	/**
	 * set保险单价钱
	 */
    public void setInsurmoney(Double insurmoney){
         this.insurmoney=insurmoney;
    }

	/**
	 * get订单总金额
	 */
    public Double getTotalmoney(){
         return totalmoney;
    }

	/**
	 * set订单总金额
	 */
    public void setTotalmoney(Double totalmoney){
         this.totalmoney=totalmoney;
    }

	/**
	 * get结束日期
	 */
    public Timestamp getEndtime(){
         return endtime;
    }

	/**
	 * set结束日期
	 */
    public void setEndtime(Timestamp endtime){
         this.endtime=endtime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + liushuno +"|"
	   
	 + orderno +"|"
	   
	 + insuranttype +"|"
	   
	 + insurantcount +"|"
	   
	 + status +"|"
	   
	 + computerid +"|"
	   
	 + userid +"|"
	   
	 + insuruserid +"|"
	   
	 + agentid +"|"
	   
	 + time +"|"
	   
	 + begintime +"|"
	   
	 + insurmoney +"|"
	   
	 + totalmoney +"|"
	   
	 + endtime
	 + "]";
 } 

}
