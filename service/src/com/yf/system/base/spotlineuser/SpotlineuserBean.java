/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotlineuser;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *线路游客
 */
public class SpotlineuserBean implements java.io.Serializable{

	/**
	  *线路游客 表名
	  */
	public static final String TABLE  = "T_SPOTLINEUSER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *游客类型 列名 
	  */
    public static final String COL_ptype  = "C_PTYPE";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_psex  = "C_PSEX";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *证件类型 列名 
	  */
    public static final String COL_idtype  = "C_IDTYPE";
	
	/**
	  *证件号码 列名 
	  */
    public static final String COL_idno  = "C_IDNO";
	
	/**
	  *联系电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *单价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//订单ID
	private Long orderid;    
    

	//游客类型
	private String ptype;    
    

	//性别
	private String psex;    
    

	//姓名
	private String name;    
    

	//证件类型
	private Long idtype;    
    

	//证件号码
	private String idno;    
    

	//联系电话
	private String tel;    
    

	//单价
	private String price;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

	//状态
	private Long state;    
    

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
	 * get游客类型
	 */
    public String getPtype(){
         return ptype;
    }

	/**
	 * set游客类型
	 */
    public void setPtype(String ptype){
         this.ptype=ptype;
    }

	/**
	 * get性别
	 */
    public String getPsex(){
         return psex;
    }

	/**
	 * set性别
	 */
    public void setPsex(String psex){
         this.psex=psex;
    }

	/**
	 * get姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set姓名
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get证件类型
	 */
    public Long getIdtype(){
         return idtype;
    }

	/**
	 * set证件类型
	 */
    public void setIdtype(Long idtype){
         this.idtype=idtype;
    }

	/**
	 * get证件号码
	 */
    public String getIdno(){
         return idno;
    }

	/**
	 * set证件号码
	 */
    public void setIdno(String idno){
         this.idno=idno;
    }

	/**
	 * get联系电话
	 */
    public String getTel(){
         return tel;
    }

	/**
	 * set联系电话
	 */
    public void setTel(String tel){
         this.tel=tel;
    }

	/**
	 * get单价
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set单价
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
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
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + ptype +"|"
	   
	 + psex +"|"
	   
	 + name +"|"
	   
	 + idtype +"|"
	   
	 + idno +"|"
	   
	 + tel +"|"
	   
	 + price +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
