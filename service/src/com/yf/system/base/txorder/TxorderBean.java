/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.txorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *TX订单
 */
public class TxorderBean implements java.io.Serializable{

	/**
	  *TX订单 表名
	  */
	public static final String TABLE  = "T_TXORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_orderno  = "C_ORDERNO";
	
	/**
	  *支付金额 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *费率 列名 
	  */
    public static final String COL_feilv  = "C_FEILV";
	
	/**
	  *费率串 列名 
	  */
    public static final String COL_feilvstr  = "C_FEILVSTR";
	
	/**
	  *分润串 列名 
	  */
    public static final String COL_fenrunstr  = "C_FENRUNSTR";
	
	/**
	  *实际到账 列名 
	  */
    public static final String COL_sjprice  = "C_SJPRICE";
	
	/**
	  *支付宝账号 列名 
	  */
    public static final String COL_alipayname  = "C_ALIPAYNAME";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_beizhu  = "C_BEIZHU";
	
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
	  *会员ID 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//订单号
	private String orderno;    
    

	//支付金额
	private String price;    
    

	//费率
	private String feilv;    
    

	//费率串
	private String feilvstr;    
    

	//分润串
	private String fenrunstr;    
    

	//实际到账
	private String sjprice;    
    

	//支付宝账号
	private String alipayname;    
    

	//备注
	private String beizhu;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

	//会员ID
	private Long memberid;    
    

	//类型
	private Long type;    
    

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
	 * get订单号
	 */
    public String getOrderno(){
         return orderno;
    }

	/**
	 * set订单号
	 */
    public void setOrderno(String orderno){
         this.orderno=orderno;
    }

	/**
	 * get支付金额
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set支付金额
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get费率
	 */
    public String getFeilv(){
         return feilv;
    }

	/**
	 * set费率
	 */
    public void setFeilv(String feilv){
         this.feilv=feilv;
    }

	/**
	 * get费率串
	 */
    public String getFeilvstr(){
         return feilvstr;
    }

	/**
	 * set费率串
	 */
    public void setFeilvstr(String feilvstr){
         this.feilvstr=feilvstr;
    }

	/**
	 * get分润串
	 */
    public String getFenrunstr(){
         return fenrunstr;
    }

	/**
	 * set分润串
	 */
    public void setFenrunstr(String fenrunstr){
         this.fenrunstr=fenrunstr;
    }

	/**
	 * get实际到账
	 */
    public String getSjprice(){
         return sjprice;
    }

	/**
	 * set实际到账
	 */
    public void setSjprice(String sjprice){
         this.sjprice=sjprice;
    }

	/**
	 * get支付宝账号
	 */
    public String getAlipayname(){
         return alipayname;
    }

	/**
	 * set支付宝账号
	 */
    public void setAlipayname(String alipayname){
         this.alipayname=alipayname;
    }

	/**
	 * get备注
	 */
    public String getBeizhu(){
         return beizhu;
    }

	/**
	 * set备注
	 */
    public void setBeizhu(String beizhu){
         this.beizhu=beizhu;
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
	 * get会员ID
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set会员ID
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
    }

	/**
	 * get类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Long type){
         this.type=type;
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
	   
	 + orderno +"|"
	   
	 + price +"|"
	   
	 + feilv +"|"
	   
	 + feilvstr +"|"
	   
	 + fenrunstr +"|"
	   
	 + sjprice +"|"
	   
	 + alipayname +"|"
	   
	 + beizhu +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + type +"|"
	   
	 + state
	 + "]";
 } 

}
