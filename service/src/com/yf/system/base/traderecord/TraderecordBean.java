/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.traderecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *交易记录
 */
public class TraderecordBean implements java.io.Serializable{

	/**
	  *交易记录 表名
	  */
	public static final String TABLE  = "T_TRADERECORD";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
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
	  *状态:0等待 1:支付成功 2:失败 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *金额 列名 
	  */
    public static final String COL_totalfee  = "C_TOTALFEE";
	
	/**
	  *支付方式:0支付宝 1:财富通 列名 
	  */
    public static final String COL_paytype  = "C_PAYTYPE";
	
	/**
	  *服务名称 列名 
	  */
    public static final String COL_payname  = "C_PAYNAME";
	
	/**
	  *返回码 列名 
	  */
    public static final String COL_retcode  = "C_RETCODE";
	
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
    public static final String COL_goodsname  = "C_GOODSNAME";
	
	/**
	  *商品描述 列名 
	  */
    public static final String COL_goodsdesc  = "C_GOODSDESC";
	
	/**
	  *订单类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *银行 列名 
	  */
    public static final String COL_bankcode  = "C_BANKCODE";
	
	/**
	  *支付类型 列名 
	  */
    public static final String COL_paymothed  = "C_PAYMOTHED";

	//id
	private long id;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//订单号
	private String ordercode;    
    

	//状态:0等待 1:支付成功 2:失败
	private Integer state;    
    

	//金额
	private float totalfee;    
    

	//支付方式:0支付宝 1:财富通
	private Integer paytype;    
    

	//服务名称
	private String payname;    
    

	//返回码
	private String retcode;    
    

	//备注
	private String description;    
    

	//交易代码
	private String code;    
    

	//商品名称
	private String goodsname;    
    

	//商品描述
	private String goodsdesc;    
    

	//订单类型
	private Integer type;    
    

	//银行
	private String bankcode;    
    

	//支付类型
	private String paymothed;    
    

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
	 * get状态:0等待 1:支付成功 2:失败
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态:0等待 1:支付成功 2:失败
	 */
    public void setState(Integer state){
         this.state=state;
    }

	/**
	 * set金额
	 */
    public void setTotalfee(Integer totalfee){
         this.totalfee=totalfee;
    }

	/**
	 * get支付方式:0支付宝 1:财富通
	 */
    public Integer getPaytype(){
         return paytype;
    }

	/**
	 * set支付方式:0支付宝 1:财富通
	 */
    public void setPaytype(Integer paytype){
         this.paytype=paytype;
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
    public String getGoodsname(){
         return goodsname;
    }

	/**
	 * set商品名称
	 */
    public void setGoodsname(String goodsname){
         this.goodsname=goodsname;
    }

	/**
	 * get商品描述
	 */
    public String getGoodsdesc(){
         return goodsdesc;
    }

	/**
	 * set商品描述
	 */
    public void setGoodsdesc(String goodsdesc){
         this.goodsdesc=goodsdesc;
    }

	/**
	 * get订单类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set订单类型
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get银行
	 */
    public String getBankcode(){
         return bankcode;
    }

	/**
	 * set银行
	 */
    public void setBankcode(String bankcode){
         this.bankcode=bankcode;
    }

	/**
	 * get支付类型
	 */
    public String getPaymothed(){
         return paymothed;
    }

	/**
	 * set支付类型
	 */
    public void setPaymothed(String paymothed){
         this.paymothed=paymothed;
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
	   
	 + totalfee +"|"
	   
	 + paytype +"|"
	   
	 + payname +"|"
	   
	 + retcode +"|"
	   
	 + description +"|"
	   
	 + code +"|"
	   
	 + goodsname +"|"
	   
	 + goodsdesc +"|"
	   
	 + type +"|"
	   
	 + bankcode +"|"
	   
	 + paymothed
	 + "]";
 }

	public float getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(float totalfee) {
		this.totalfee = totalfee;
	} 

}
