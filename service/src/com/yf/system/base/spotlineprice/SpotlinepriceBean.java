/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotlineprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *景区线路价格信息
 */
public class SpotlinepriceBean implements java.io.Serializable{

	/**
	  *景区线路价格信息 表名
	  */
	public static final String TABLE  = "T_SPOTLINEPRICE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *线路id 列名 
	  */
    public static final String COL_spotlineid  = "C_SPOTLINEID";
	
	/**
	  *成人类型 列名 
	  */
    public static final String COL_ptype  = "C_PTYPE";
	
	/**
	  *零售价 列名 
	  */
    public static final String COL_lsprice  = "C_LSPRICE";
	
	/**
	  *结算价 列名 
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
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//线路id
	private String spotlineid;    
    

	//成人类型
	private String ptype;    
    

	//零售价
	private String lsprice;    
    

	//结算价
	private String price;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

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
	 * get线路id
	 */
    public String getSpotlineid(){
         return spotlineid;
    }

	/**
	 * set线路id
	 */
    public void setSpotlineid(String spotlineid){
         this.spotlineid=spotlineid;
    }

	/**
	 * get成人类型
	 */
    public String getPtype(){
         return ptype;
    }

	/**
	 * set成人类型
	 */
    public void setPtype(String ptype){
         this.ptype=ptype;
    }

	/**
	 * get零售价
	 */
    public String getLsprice(){
         return lsprice;
    }

	/**
	 * set零售价
	 */
    public void setLsprice(String lsprice){
         this.lsprice=lsprice;
    }

	/**
	 * get结算价
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set结算价
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
	   
	 + spotlineid +"|"
	   
	 + ptype +"|"
	   
	 + lsprice +"|"
	   
	 + price +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + state
	 + "]";
 } 

}
