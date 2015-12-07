/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fdeliverassign;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票配送信息
 */
public class FdeliverassignBean implements java.io.Serializable{

	/**
	  *国际机票配送信息 表名
	  */
	public static final String TABLE  = "T_FDELIVERASSIGN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单id 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *配送方式 列名 
	  */
    public static final String COL_assigntype  = "C_ASSIGNTYPE";
	
	/**
	  *收件人姓名 列名 
	  */
    public static final String COL_postname  = "C_POSTNAME";
	
	/**
	  *收件人电话 列名 
	  */
    public static final String COL_postphone  = "C_POSTPHONE";
	
	/**
	  *邮编 列名 
	  */
    public static final String COL_postcode  = "C_POSTCODE";
	
	/**
	  *送票地址 列名 
	  */
    public static final String COL_postaddress  = "C_POSTADDRESS";
	
	/**
	  *送票城市 列名 
	  */
    public static final String COL_delivercity  = "C_DELIVERCITY";

	//ID
	private long id;    
    

	//订单id
	private Long orderid;    
    

	//配送方式
	private Integer assigntype;    
    

	//收件人姓名
	private String postname;    
    

	//收件人电话
	private String postphone;    
    

	//邮编
	private String postcode;    
    

	//送票地址
	private String postaddress;    
    

	//送票城市
	private String delivercity;    
    

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
	 * get配送方式
	 */
    public Integer getAssigntype(){
         return assigntype;
    }

	/**
	 * set配送方式
	 */
    public void setAssigntype(Integer assigntype){
         this.assigntype=assigntype;
    }

	/**
	 * get收件人姓名
	 */
    public String getPostname(){
         return postname;
    }

	/**
	 * set收件人姓名
	 */
    public void setPostname(String postname){
         this.postname=postname;
    }

	/**
	 * get收件人电话
	 */
    public String getPostphone(){
         return postphone;
    }

	/**
	 * set收件人电话
	 */
    public void setPostphone(String postphone){
         this.postphone=postphone;
    }

	/**
	 * get邮编
	 */
    public String getPostcode(){
         return postcode;
    }

	/**
	 * set邮编
	 */
    public void setPostcode(String postcode){
         this.postcode=postcode;
    }

	/**
	 * get送票地址
	 */
    public String getPostaddress(){
         return postaddress;
    }

	/**
	 * set送票地址
	 */
    public void setPostaddress(String postaddress){
         this.postaddress=postaddress;
    }

	/**
	 * get送票城市
	 */
    public String getDelivercity(){
         return delivercity;
    }

	/**
	 * set送票城市
	 */
    public void setDelivercity(String delivercity){
         this.delivercity=delivercity;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + assigntype +"|"
	   
	 + postname +"|"
	   
	 + postphone +"|"
	   
	 + postcode +"|"
	   
	 + postaddress +"|"
	   
	 + delivercity
	 + "]";
 } 

}
