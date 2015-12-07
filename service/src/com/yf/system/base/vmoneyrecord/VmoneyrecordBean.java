/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.vmoneyrecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *虚拟账户充值记录
 */
public class VmoneyrecordBean implements java.io.Serializable{

	/**
	  *虚拟账户充值记录 表名
	  */
	public static final String TABLE  = "T_VMONEYRECORD";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *代理商id 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *充值经手人id 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
	/**
	  *充值金额 列名 
	  */
    public static final String COL_money  = "C_MONEY";
	
	/**
	  *充值时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
    
    /**
     * 备注
     */
    public static final String COL_memo="C_MEMO";
    
    /**
     * 订单号
     */
    public static final String COL_ordernumber="C_ORDERNUMBER";
    
    /**
     * 充值类型
     */
    public static final String COL_type="C_TYPE";
    
    
    /**
     * 
     * 充值给某人
     * 
     */
    public static final String COL_customeruserid="C_CUSTOMERUSERID";

	//id
	private long id;    
    

	//代理商id
	private long agentid;    
    

	//充值经手人id
	private long createuserid;    
    

	//充值金额
	private float money;    
    

	//充值时间
	private Timestamp createtime;   
	
	//备注
	private String memo;
	
	//订单号
	private String ordernumber;
	
	private String type;
	
	private String customeruserid;
    

	/**
	 * getid
	 */
    public long getId(){
         return id;
    }

	/**
	 * setid
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get代理商id
	 */
    public long getAgentid(){
         return agentid;
    }

	/**
	 * set代理商id
	 */
    public void setAgentid(long agentid){
         this.agentid=agentid;
    }

	/**
	 * get充值经手人id
	 */
    public long getCreateuserid(){
         return createuserid;
    }

	/**
	 * set充值经手人id
	 */
    public void setCreateuserid(long createuserid){
         this.createuserid=createuserid;
    }

	/**
	 * get充值金额
	 */
    public float getMoney(){
         return money;
    }

	/**
	 * set充值金额
	 */
    public void setMoney(float money){
         this.money=money;
    }

	/**
	 * get充值时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set充值时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + agentid +"|"
	   
	 + createuserid +"|"
	   
	 + money +"|"
	   
	 + createtime
	 + "]";
 }

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCustomeruserid() {
		return customeruserid;
	}

	public void setCustomeruserid(String customeruserid) {
		this.customeruserid = customeruserid;
	} 

}
