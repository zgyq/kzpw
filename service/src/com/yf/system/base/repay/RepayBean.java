/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.repay;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *大客户还款记录表
 */
public class RepayBean implements java.io.Serializable{

	/**
	  *大客户还款记录表 表名
	  */
	public static final String TABLE  = "T_REPAY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *乘机人ID 列名 
	  */
    public static final String COL_passengerid  = "C_PASSENGERID";
	
	/**
	  *大客户ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *还款金额 列名 
	  */
    public static final String COL_hkuanprice  = "C_HKUANPRICE";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *还款时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *操作人 列名 
	  */
    public static final String COL_updateid  = "C_UPDATEID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//乘机人ID
	private Long passengerid;    
    

	//大客户ID
	private Long agentid;    
    

	//还款金额
	private Double hkuanprice;    
    

	//订单ID
	private Long orderid;    
    

	//还款时间
	private Timestamp createtime;    
    
	//还款类型
	private Long  pricetype; //1现金2支票3银行汇款   
	
	
	//操作人
	private Long updateid;    
    

	//备注
	private String comment;    
    

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
	 * get乘机人ID
	 */
    public Long getPassengerid(){
         return passengerid;
    }

	/**
	 * set乘机人ID
	 */
    public void setPassengerid(Long passengerid){
         this.passengerid=passengerid;
    }

	/**
	 * get大客户ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set大客户ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get还款金额
	 */
    public Double getHkuanprice(){
         return hkuanprice;
    }

	/**
	 * set还款金额
	 */
    public void setHkuanprice(Double hkuanprice){
         this.hkuanprice=hkuanprice;
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
	 * get还款时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set还款时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get操作人
	 */
    public Long getUpdateid(){
         return updateid;
    }

	/**
	 * set操作人
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


	public Long getPricetype() {
		return pricetype;
	}

	public void setPricetype(Long pricetype) {
		this.pricetype = pricetype;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + passengerid +"|"
	   
	 + agentid +"|"
	   
	 + hkuanprice +"|"
	   
	 + orderid +"|"
	   
	 + createtime +"|"
	   
	 + updateid +"|"
	 
	 + pricetype +"|"
	   
	 + comment
	 + "]";
 } 

}
