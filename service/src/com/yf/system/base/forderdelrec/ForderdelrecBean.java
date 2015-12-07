/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.forderdelrec;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票订单操作记录
 */
public class ForderdelrecBean implements java.io.Serializable{

	/**
	  *国际机票订单操作记录 表名
	  */
	public static final String TABLE  = "T_FORDERDELREC";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单id 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *操作人id 列名 
	  */
    public static final String COL_operateperson  = "C_OPERATEPERSON";
	
	/**
	  *操作时间 列名 
	  */
    public static final String COL_operatetime  = "C_OPERATETIME";
	
	/**
	  *操作描述 列名 
	  */
    public static final String COL_operatedesc  = "C_OPERATEDESC";
	
	/**
	  *当前状态 列名 
	  */
    public static final String COL_operatestatus  = "C_OPERATESTATUS";
	
	/**
	  *下一状态 列名 
	  */
    public static final String COL_nextstatus  = "C_NEXTSTATUS";

	//ID
	private long id;    
    

	//订单id
	private Long orderid;    
    

	//操作人id
	private Long operateperson;    
    

	//操作时间
	private Timestamp operatetime;    
    

	//操作描述
	private String operatedesc;    
    

	//当前状态
	private Integer operatestatus;    
    

	//下一状态
	private Integer nextstatus;    
    

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
	 * get订单id
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set订单id
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get操作人id
	 */
    public Long getOperateperson(){
         return operateperson;
    }

	/**
	 * set操作人id
	 */
    public void setOperateperson(Long operateperson){
         this.operateperson=operateperson;
    }

	/**
	 * get操作时间
	 */
    public Timestamp getOperatetime(){
         return operatetime;
    }

	/**
	 * set操作时间
	 */
    public void setOperatetime(Timestamp operatetime){
         this.operatetime=operatetime;
    }

	/**
	 * get操作描述
	 */
    public String getOperatedesc(){
         return operatedesc;
    }

	/**
	 * set操作描述
	 */
    public void setOperatedesc(String operatedesc){
         this.operatedesc=operatedesc;
    }

	/**
	 * get当前状态
	 */
    public Integer getOperatestatus(){
         return operatestatus;
    }

	/**
	 * set当前状态
	 */
    public void setOperatestatus(Integer operatestatus){
         this.operatestatus=operatestatus;
    }

	/**
	 * get下一状态
	 */
    public Integer getNextstatus(){
         return nextstatus;
    }

	/**
	 * set下一状态
	 */
    public void setNextstatus(Integer nextstatus){
         this.nextstatus=nextstatus;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + operateperson +"|"
	   
	 + operatetime +"|"
	   
	 + operatedesc +"|"
	   
	 + operatestatus +"|"
	   
	 + nextstatus
	 + "]";
 } 

}
