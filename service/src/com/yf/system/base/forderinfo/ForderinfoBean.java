/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.forderinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票订单表
 */
public class ForderinfoBean implements java.io.Serializable{

	/**
	  *国际机票订单表 表名
	  */
	public static final String TABLE  = "T_FORDERINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_ordernumber  = "C_ORDERNUMBER";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_contactname  = "C_CONTACTNAME";
	
	/**
	  *联系人手机 列名 
	  */
    public static final String COL_contactmobile  = "C_CONTACTMOBILE";
	
	/**
	  *联系人座机 列名 
	  */
    public static final String COL_contactphone  = "C_CONTACTPHONE";
	
	/**
	  *联系人电子邮件 列名 
	  */
    public static final String COL_contactemail  = "C_CONTACTEMAIL";
	
	/**
	  *备注说明 列名 
	  */
    public static final String COL_contactmark  = "C_CONTACTMARK";
	
	/**
	  *订单状态 列名 
	  */
    public static final String COL_orderstatus  = "C_ORDERSTATUS";
	
	/**
	  *会员id 列名 
	  */
    public static final String COL_customerid  = "C_CUSTOMERID";
	
	/**
	  *下单人姓名 列名 
	  */
    public static final String COL_employeeid  = "C_EMPLOYEEID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *pnr编码 列名 
	  */
    public static final String COL_prncode  = "C_PRNCODE";
	
	/**
	  *行动代码 列名 
	  */
    public static final String COL_actioncode  = "C_ACTIONCODE";
	
	/**
	  *总票价 列名 
	  */
    public static final String COL_totalticketfare  = "C_TOTALTICKETFARE";
	
	/**
	  *总税费 列名 
	  */
    public static final String COL_totalfax  = "C_TOTALFAX";
	
	/**
	  *退改签状态 列名 
	  */
    public static final String COL_refundstatus  = "C_REFUNDSTATUS";
	
	/**
	  *送票状态 列名 
	  */
    public static final String COL_deliverstatus  = "C_DELIVERSTATUS";
	
	/**
	  *支付状态 列名 
	  */
    public static final String COL_paystatus  = "C_PAYSTATUS";
	
	/**
	  *订单类型 列名 
	  */
    public static final String COL_ordertype  = "C_ORDERTYPE";
	
	/**
	  *支付类型 列名 
	  */
    public static final String COL_paytype  = "C_PAYTYPE";

	//ID
	private long id;    
    

	//订单号
	private String ordernumber;    
    

	//联系人姓名
	private String contactname;    
    

	//联系人手机
	private String contactmobile;    
    

	//联系人座机
	private String contactphone;    
    

	//联系人电子邮件
	private String contactemail;    
    

	//备注说明
	private String contactmark;    
    

	//订单状态
	private Integer orderstatus;    
    

	//会员id
	private Long customerid;    
    

	//下单人姓名
	private Long employeeid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//pnr编码
	private String prncode;    
    

	//行动代码
	private String actioncode;    
    

	//总票价
	private Double totalticketfare;    
    

	//总税费
	private Double totalfax;    
    

	//退改签状态
	private Integer refundstatus;    
    

	//送票状态
	private Integer deliverstatus;    
    

	//支付状态
	private Integer paystatus;    
    

	//订单类型
	private Integer ordertype;    
    

	//支付类型
	private Integer paytype;    
    

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
	 * get订单号
	 */
    public String getOrdernumber(){
         return ordernumber;
    }

	/**
	 * set订单号
	 */
    public void setOrdernumber(String ordernumber){
         this.ordernumber=ordernumber;
    }

	/**
	 * get联系人姓名
	 */
    public String getContactname(){
         return contactname;
    }

	/**
	 * set联系人姓名
	 */
    public void setContactname(String contactname){
         this.contactname=contactname;
    }

	/**
	 * get联系人手机
	 */
    public String getContactmobile(){
         return contactmobile;
    }

	/**
	 * set联系人手机
	 */
    public void setContactmobile(String contactmobile){
         this.contactmobile=contactmobile;
    }

	/**
	 * get联系人座机
	 */
    public String getContactphone(){
         return contactphone;
    }

	/**
	 * set联系人座机
	 */
    public void setContactphone(String contactphone){
         this.contactphone=contactphone;
    }

	/**
	 * get联系人电子邮件
	 */
    public String getContactemail(){
         return contactemail;
    }

	/**
	 * set联系人电子邮件
	 */
    public void setContactemail(String contactemail){
         this.contactemail=contactemail;
    }

	/**
	 * get备注说明
	 */
    public String getContactmark(){
         return contactmark;
    }

	/**
	 * set备注说明
	 */
    public void setContactmark(String contactmark){
         this.contactmark=contactmark;
    }

	/**
	 * get订单状态
	 */
    public Integer getOrderstatus(){
         return orderstatus;
    }

	/**
	 * set订单状态
	 */
    public void setOrderstatus(Integer orderstatus){
         this.orderstatus=orderstatus;
    }

	/**
	 * get会员id
	 */
    public Long getCustomerid(){
         return customerid;
    }

	/**
	 * set会员id
	 */
    public void setCustomerid(Long customerid){
         this.customerid=customerid;
    }

	/**
	 * get下单人姓名
	 */
    public Long getEmployeeid(){
         return employeeid;
    }

	/**
	 * set下单人姓名
	 */
    public void setEmployeeid(Long employeeid){
         this.employeeid=employeeid;
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

	/**
	 * getpnr编码
	 */
    public String getPrncode(){
         return prncode;
    }

	/**
	 * setpnr编码
	 */
    public void setPrncode(String prncode){
         this.prncode=prncode;
    }

	/**
	 * get行动代码
	 */
    public String getActioncode(){
         return actioncode;
    }

	/**
	 * set行动代码
	 */
    public void setActioncode(String actioncode){
         this.actioncode=actioncode;
    }

	/**
	 * get总票价
	 */
    public Double getTotalticketfare(){
         return totalticketfare;
    }

	/**
	 * set总票价
	 */
    public void setTotalticketfare(Double totalticketfare){
         this.totalticketfare=totalticketfare;
    }

	/**
	 * get总税费
	 */
    public Double getTotalfax(){
         return totalfax;
    }

	/**
	 * set总税费
	 */
    public void setTotalfax(Double totalfax){
         this.totalfax=totalfax;
    }

	/**
	 * get退改签状态
	 */
    public Integer getRefundstatus(){
         return refundstatus;
    }

	/**
	 * set退改签状态
	 */
    public void setRefundstatus(Integer refundstatus){
         this.refundstatus=refundstatus;
    }

	/**
	 * get送票状态
	 */
    public Integer getDeliverstatus(){
         return deliverstatus;
    }

	/**
	 * set送票状态
	 */
    public void setDeliverstatus(Integer deliverstatus){
         this.deliverstatus=deliverstatus;
    }

	/**
	 * get支付状态
	 */
    public Integer getPaystatus(){
         return paystatus;
    }

	/**
	 * set支付状态
	 */
    public void setPaystatus(Integer paystatus){
         this.paystatus=paystatus;
    }

	/**
	 * get订单类型
	 */
    public Integer getOrdertype(){
         return ordertype;
    }

	/**
	 * set订单类型
	 */
    public void setOrdertype(Integer ordertype){
         this.ordertype=ordertype;
    }

	/**
	 * get支付类型
	 */
    public Integer getPaytype(){
         return paytype;
    }

	/**
	 * set支付类型
	 */
    public void setPaytype(Integer paytype){
         this.paytype=paytype;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + ordernumber +"|"
	   
	 + contactname +"|"
	   
	 + contactmobile +"|"
	   
	 + contactphone +"|"
	   
	 + contactemail +"|"
	   
	 + contactmark +"|"
	   
	 + orderstatus +"|"
	   
	 + customerid +"|"
	   
	 + employeeid +"|"
	   
	 + createtime +"|"
	   
	 + prncode +"|"
	   
	 + actioncode +"|"
	   
	 + totalticketfare +"|"
	   
	 + totalfax +"|"
	   
	 + refundstatus +"|"
	   
	 + deliverstatus +"|"
	   
	 + paystatus +"|"
	   
	 + ordertype +"|"
	   
	 + paytype
	 + "]";
 } 

}
