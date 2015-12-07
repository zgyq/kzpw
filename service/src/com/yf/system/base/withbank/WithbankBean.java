/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.withbank;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *提现
 */
public class WithbankBean implements java.io.Serializable{

	/**
	  *提现 表名
	  */
	public static final String TABLE  = "T_WITHBANK";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *金额 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *发卡行 列名 
	  */
    public static final String COL_bankname  = "C_BANKNAME";
	
	/**
	  *持卡人名字 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *卡号 列名 
	  */
    public static final String COL_bankno  = "C_BANKNO";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
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
	  *修改时间 列名 
	  */
    public static final String COL_updatetime  = "C_UPDATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//金额
	private String price;    
    

	//发卡行
	private String bankname;    
    

	//持卡人名字
	private String username;    
    

	//卡号
	private String bankno;    
    

	//会员ID
	private Long userid;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改时间
	private Timestamp updatetime;    
    

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
	 * get金额
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set金额
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get发卡行
	 */
    public String getBankname(){
         return bankname;
    }

	/**
	 * set发卡行
	 */
    public void setBankname(String bankname){
         this.bankname=bankname;
    }

	/**
	 * get持卡人名字
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set持卡人名字
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get卡号
	 */
    public String getBankno(){
         return bankno;
    }

	/**
	 * set卡号
	 */
    public void setBankno(String bankno){
         this.bankno=bankno;
    }

	/**
	 * get会员ID
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set会员ID
	 */
    public void setUserid(Long userid){
         this.userid=userid;
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
	 * get修改时间
	 */
    public Timestamp getUpdatetime(){
         return updatetime;
    }

	/**
	 * set修改时间
	 */
    public void setUpdatetime(Timestamp updatetime){
         this.updatetime=updatetime;
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
	   
	 + price +"|"
	   
	 + bankname +"|"
	   
	 + username +"|"
	   
	 + bankno +"|"
	   
	 + userid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + updatetime +"|"
	   
	 + state
	 + "]";
 } 

}
