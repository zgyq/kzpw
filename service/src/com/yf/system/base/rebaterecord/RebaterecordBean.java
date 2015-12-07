/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.rebaterecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *返佣记录表
 */
public class RebaterecordBean implements java.io.Serializable{

	/**
	  *返佣记录表 表名
	  */
	public static final String TABLE  = "T_REBATERECORD";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *业务类型id 列名 
	  */
    public static final String COL_yewutype  = "C_YEWUTYPE";
	
	/**
	  *返佣订单号 列名 
	  */
    public static final String COL_ordernumber  = "C_ORDERNUMBER";
	
	/**
	  *得到返佣的代理商id 列名 
	  */
    public static final String COL_rebateagentid  = "C_REBATEAGENTID";
    /**
     *得到返佣的代理商级别
     */
    public static final String COL_rebateagentjibie  = "C_REBATEAGENTJIBIE";
	
	/**
	  *下级代理id 列名 
	  */
    public static final String COL_childagentid  = "C_CHILDAGENTID";
	
	/**
	  *返佣代理商id串 列名 
	  */
    public static final String COL_rebateagentidstr  = "C_REBATEAGENTIDSTR";
	
	/**
	  *返佣金额 列名 
	  */
    public static final String COL_rebatemoney  = "C_REBATEMONEY";
    
    
    /**
     * 返佣类型，1.网银支付，已返入账户，不纳入虚拟货币。
     * 2.虚拟账户支付，纳入虚拟货币。
     * 3.网银充值 
     */
    public static final String COL_rebattype  = "C_REBATETYPE";
    
    //网银充值 充值状态 0：未支付，1，已支付
    public static final String COL_paystate  = "C_PAYSTATE";
    
	/**
	  *返佣时间 列名 
	  */
    public static final String COL_rebatetime  = "C_REBATETIME";
	
	/**
	  *返佣备注 列名 
	  */
    public static final String COL_rebatememo  = "C_REBATEMEMO";
    
    /**
     * 经手人//原会员ID
     */
    public static final String COL_customerid  = "C_CUSTOMERID";
    
   
    
	//id
	private long id;    
    

	//业务类型id
	private long yewutype;    
    

	//返佣订单号
	private String ordernumber;    
    

	//得到返佣的代理商id
	private long rebateagentid;    
    

	//下级代理id
	private long childagentid;    
    

	//返佣代理商id串
	private String rebateagentidstr;    
    

	//返佣金额
	private float rebatemoney=-1;    
	
	private int rebatetype;
	
	private int paystate;
    

	//返佣时间
	private Timestamp rebatetime;    
    

	//返佣备注
	private String rebatememo;

	//会员ID
	private long customerid;
	
	//经手人
	private String customername;
	
	//加盟商名字
	private String agentname;
	
	private Integer rebateagentjibie;
    

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
	 * get业务类型id
	 */
    public long getYewutype(){
         return yewutype;
    }

	/**
	 * set业务类型id
	 */
    public void setYewutype(long yewutype){
         this.yewutype=yewutype;
    }

	/**
	 * get返佣订单号
	 */
    public String getOrdernumber(){
         return ordernumber;
    }

	/**
	 * set返佣订单号
	 */
    public void setOrdernumber(String ordernumber){
         this.ordernumber=ordernumber;
    }

	/**
	 * get得到返佣的代理商id
	 */
    public long getRebateagentid(){
         return rebateagentid;
    }

	/**
	 * set得到返佣的代理商id
	 */
    public void setRebateagentid(long rebateagentid){
         this.rebateagentid=rebateagentid;
    }

	/**
	 * get下级代理id
	 */
    public long getChildagentid(){
         return childagentid;
    }

	/**
	 * set下级代理id
	 */
    public void setChildagentid(long childagentid){
         this.childagentid=childagentid;
    }

	/**
	 * get返佣代理商id串
	 */
    public String getRebateagentidstr(){
         return rebateagentidstr;
    }

	/**
	 * set返佣代理商id串
	 */
    public void setRebateagentidstr(String rebateagentidstr){
         this.rebateagentidstr=rebateagentidstr;
    }

	/**
	 * get返佣金额
	 */
    public float getRebatemoney(){
         return rebatemoney;
    }

	/**
	 * set返佣金额
	 */
    public void setRebatemoney(float rebatemoney){
         this.rebatemoney=rebatemoney;
    }

	/**
	 * get返佣时间
	 */
    public Timestamp getRebatetime(){
         return rebatetime;
    }

	/**
	 * set返佣时间
	 */
    public void setRebatetime(Timestamp rebatetime){
         this.rebatetime=rebatetime;
    }

	/**
	 * get返佣备注
	 */
    public String getRebatememo(){
         return rebatememo;
    }

	/**
	 * set返佣备注
	 */
    public void setRebatememo(String rebatememo){
         this.rebatememo=rebatememo;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + yewutype +"|"
	   
	 + ordernumber +"|"
	   
	 + rebateagentid +"|"
	   
	 + childagentid +"|"
	   
	 + rebateagentidstr +"|"
	   
	 + rebatemoney +"|"
	   
	 + rebatetime +"|"
	 
	 + customerid +"|"
	   
	 + rebatememo
	 + "]";
 }

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public Integer getRebateagentjibie() {
		return rebateagentjibie;
	}

	public void setRebateagentjibie(Integer rebateagentjibie) {
		this.rebateagentjibie = rebateagentjibie;
	}

	public int getRebatetype() {
		return rebatetype;
	}

	public void setRebatetype(int rebatetype) {
		this.rebatetype = rebatetype;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	} 

}
