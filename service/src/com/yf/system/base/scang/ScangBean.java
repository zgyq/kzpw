/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.scang;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *订单升舱表
 */
public class ScangBean implements java.io.Serializable{

	/**
	  *订单升舱表 表名
	  */
	public static final String TABLE  = "T_SCANG";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *关联乘机人表ID 列名 
	  */
    public static final String COL_passengerid  = "C_PASSENGERID";
	
	/**
	  *升舱前舱位码 列名 
	  */
    public static final String COL_startcode  = "C_STARTCODE";
	
	/**
	  *申请升舱到舱位码 列名 
	  */
    public static final String COL_endcode  = "C_ENDCODE";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_ordercode  = "C_Ordercode";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flight  = "C_FLIGHT";
	
	/**
	  *升舱编码/PNR 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *申请时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *办理时间 列名 
	  */
    public static final String COL_transacttime  = "C_TRANSACTTIME";
	
	/**
	  *升舱效率 列名 
	  */
    public static final String COL_xiaolv  = "C_XIAOLV";
	
	/**
	  *升舱状态 列名 
	  */
    public static final String COL_states  = "C_STATE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *申请人 列名 
	  */
    public static final String COL_applyid  = "C_APPLYID";
	
	/**
	  *处理人 列名 
	  */
    public static final String COL_updateid  = "C_UPDATEID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";
	
	/**
	  *差价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *新PNR 列名 
	  */
    public static final String COL_newpnr  = "C_NEWPNR";

	//ID
	private long id;    
    

	//关联乘机人表ID
	private Long passengerid;    
    

	//升舱前舱位码
	private String startcode;    
    

	//申请升舱到舱位码
	private String endcode;    
    

	//订单号
	private String ordercode;    
    

	//订单ID
	private Long orderid;    
    

	//航班号
	private String flight;    
    

	//升舱编码/PNR
	private String pnr;    
    

	//申请时间
	private Timestamp createtime;    
    

	//办理时间
	private Timestamp transacttime;    
    

	//升舱效率
	private String xiaolv;    
    

	//升舱状态
	private Long states;    
    

	//状态
	private Long status;    
    

	//申请人
	private Long applyid;    
    

	//处理人
	private Long updateid;    
    

	//备注
	private String comment;    
    

	//差价
	private Double price;    
    

	//新PNR
	private String newpnr;    
    

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
	 * get关联乘机人表ID
	 */
    public Long getPassengerid(){
         return passengerid;
    }

	/**
	 * set关联乘机人表ID
	 */
    public void setPassengerid(Long passengerid){
         this.passengerid=passengerid;
    }

	/**
	 * get升舱前舱位码
	 */
    public String getStartcode(){
         return startcode;
    }

	/**
	 * set升舱前舱位码
	 */
    public void setStartcode(String startcode){
         this.startcode=startcode;
    }

	/**
	 * get申请升舱到舱位码
	 */
    public String getEndcode(){
         return endcode;
    }

	/**
	 * set申请升舱到舱位码
	 */
    public void setEndcode(String endcode){
         this.endcode=endcode;
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
    public String getFlight(){
         return flight;
    }

	/**
	 * set航班号
	 */
    public void setFlight(String flight){
         this.flight=flight;
    }

	/**
	 * get升舱编码/PNR
	 */
    public String getPnr(){
         return pnr;
    }

	/**
	 * set升舱编码/PNR
	 */
    public void setPnr(String pnr){
         this.pnr=pnr;
    }

	/**
	 * get申请时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set申请时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get办理时间
	 */
    public Timestamp getTransacttime(){
         return transacttime;
    }

	/**
	 * set办理时间
	 */
    public void setTransacttime(Timestamp transacttime){
         this.transacttime=transacttime;
    }

	/**
	 * get升舱效率
	 */
    public String getXiaolv(){
         return xiaolv;
    }

	/**
	 * set升舱效率
	 */
    public void setXiaolv(String xiaolv){
         this.xiaolv=xiaolv;
    }

	/**
	 * get升舱状态
	 */
    public Long getStates(){
         return states;
    }

	/**
	 * set升舱状态
	 */
    public void setStates(Long states){
         this.states=states;
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
	 * get申请人
	 */
    public Long getApplyid(){
         return applyid;
    }

	/**
	 * set申请人
	 */
    public void setApplyid(Long applyid){
         this.applyid=applyid;
    }

	/**
	 * get处理人
	 */
    public Long getUpdateid(){
         return updateid;
    }

	/**
	 * set处理人
	 */
    public void setUpdateid(Long updateid){
         this.updateid=updateid;
    }

	/**
	 * get备注
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set备注
	 */
    public void setComment(String comment){
         this.comment=comment;
    }

	/**
	 * get差价
	 */
    public Double getPrice(){
         return price;
    }

	/**
	 * set差价
	 */
    public void setPrice(Double price){
         this.price=price;
    }

	/**
	 * get新PNR
	 */
    public String getNewpnr(){
         return newpnr;
    }

	/**
	 * set新PNR
	 */
    public void setNewpnr(String newpnr){
         this.newpnr=newpnr;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + passengerid +"|"
	   
	 + startcode +"|"
	   
	 + endcode +"|"
	   
	 + ordercode +"|"
	   
	 + orderid +"|"
	   
	 + flight +"|"
	   
	 + pnr +"|"
	   
	 + createtime +"|"
	   
	 + transacttime +"|"
	   
	 + xiaolv +"|"
	   
	 + states +"|"
	   
	 + status +"|"
	   
	 + applyid +"|"
	   
	 + updateid +"|"
	   
	 + comment +"|"
	   
	 + price +"|"
	   
	 + newpnr
	 + "]";
 } 

}
