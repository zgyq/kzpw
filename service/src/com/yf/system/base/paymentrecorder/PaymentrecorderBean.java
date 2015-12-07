/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.paymentrecorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *支付记录
 */
public class PaymentrecorderBean implements java.io.Serializable{

	/**
	  *支付记录 表名
	  */
	public static final String TABLE  = "T_PAYMENTRECORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创??时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_ordercode  = "C_ORDERCODE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *支付方式 列名 
	  */
    public static final String COL_paytype  = "C_PAYTYPE";
	
	/**
	  *金额 列名 
	  */
    public static final String COL_amount  = "C_AMOUNT";
	
	/**
	  *服务名称 列名 
	  */
    public static final String COL_payname  = "C_PAYNAME";
	
	/**
	  *返回码 列名 
	  */
    public static final String COL_retcode  = "C_RETCODE";
	
	/**
	  *返回地址 列名 
	  */
    public static final String COL_returl  = "C_RETURL";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *交易代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *商品名称 列名 
	  */
    public static final String COL_productname  = "C_PRODUCTNAME";
	
	/**
	  *商???描述 列名 
	  */
    public static final String COL_productesc  = "C_PRODUCTESC";
	
	/**
	  *商品信息地址 列名 
	  */
    public static final String COL_producturl  = "C_PRODUCTURL";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//ID
	private long id;    
    

	//创建者
	private String createuser;    
    

	//创??时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//订单号
	private String ordercode;    
    

	//状态
	private Integer state;    
    

	//支付方式
	private Integer paytype;    
    

	//金额
	private Float amount;    
    

	//服务名称
	private String payname;    
    

	//返回码
	private String retcode;    
    

	//返回地址
	private String returl;    
    

	//备注
	private String description;    
    

	//交易代码
	private String code;    
    

	//商品名称
	private String productname;    
    

	//商???描述
	private String productesc;    
    

	//商品信息地址
	private String producturl;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

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
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
	 */
    public void setCreateuser(String createuser){
         this.createuser=createuser;
    }

	/**
	 * get创??时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set创??时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
	 */
    public void setModifyuser(String modifyuser){
         this.modifyuser=modifyuser;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getModifytime(){
         return modifytime;
    }

	/**
	 * set修改时间
	 */
    public void setModifytime(Timestamp modifytime){
         this.modifytime=modifytime;
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
	 * get状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Integer state){
         this.state=state;
    }

	/**
	 * get支付方式
	 */
    public Integer getPaytype(){
         return paytype;
    }

	/**
	 * set支付方式
	 */
    public void setPaytype(Integer paytype){
         this.paytype=paytype;
    }

	/**
	 * get金额
	 */
    public Float getAmount(){
         return amount;
    }

	/**
	 * set金额
	 */
    public void setAmount(Float amount){
         this.amount=amount;
    }

	/**
	 * get服务名称
	 */
    public String getPayname(){
         return payname;
    }

	/**
	 * set服务名称
	 */
    public void setPayname(String payname){
         this.payname=payname;
    }

	/**
	 * get返回码
	 */
    public String getRetcode(){
         return retcode;
    }

	/**
	 * set返回码
	 */
    public void setRetcode(String retcode){
         this.retcode=retcode;
    }

	/**
	 * get返回地址
	 */
    public String getReturl(){
         return returl;
    }

	/**
	 * set返回地址
	 */
    public void setReturl(String returl){
         this.returl=returl;
    }

	/**
	 * get备注
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set备注
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get交易代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set交易代码
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get商品名称
	 */
    public String getProductname(){
         return productname;
    }

	/**
	 * set商品名称
	 */
    public void setProductname(String productname){
         this.productname=productname;
    }

	/**
	 * get商???描述
	 */
    public String getProductesc(){
         return productesc;
    }

	/**
	 * set商???描述
	 */
    public void setProductesc(String productesc){
         this.productesc=productesc;
    }

	/**
	 * get商品信息地址
	 */
    public String getProducturl(){
         return producturl;
    }

	/**
	 * set商品信息地址
	 */
    public void setProducturl(String producturl){
         this.producturl=producturl;
    }

	/**
	 * get父编号
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * set父编号
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语言类型
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + ordercode +"|"
	   
	 + state +"|"
	   
	 + paytype +"|"
	   
	 + amount +"|"
	   
	 + payname +"|"
	   
	 + retcode +"|"
	   
	 + returl +"|"
	   
	 + description +"|"
	   
	 + code +"|"
	   
	 + productname +"|"
	   
	 + productesc +"|"
	   
	 + producturl +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
