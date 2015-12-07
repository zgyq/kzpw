/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.ympay;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *短信充值记录
 */
public class YmpayBean implements java.io.Serializable{

	/**
	  *短信充值记录 表名
	  */
	public static final String TABLE  = "T_YMPAY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *账号ID 列名 
	  */
    public static final String COL_ymuserid  = "C_YMUSERID";
	
	/**
	  *密码 列名 
	  */
    public static final String COL_pwd  = "C_PWD";
	
	/**
	  *金额 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *代理ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *短信数量 列名 
	  */
    public static final String COL_memnum  = "C_MEMNUM";
	
	/**
	  *备用1 列名 
	  */
    public static final String COL_back1  = "C_EBACK1";
	
	/**
	  *备用2 列名 
	  */
    public static final String COL_back2  = "C_EBACK2";
	
	/**
	  *备用3 列名 
	  */
    public static final String COL_back3  = "C_EBACK3";
	
	/**
	  *备用4 列名 
	  */
    public static final String COL_back4  = "C_EBACK4";

	//ID
	private long id;    
    

	//账号ID
	private Long ymuserid;    
    

	//密码
	private String pwd;    
    

	//金额
	private String price;    
    

	//代理ID
	private String agentid;    
    

	//状态
	private Long state;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//短信数量
	private Long memnum;    
    

	//备用1
	private String back1;    
    

	//备用2
	private String back2;    
    

	//备用3
	private String back3;    
    

	//备用4
	private String back4;    
    

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
	 * get账号ID
	 */
    public Long getYmuserid(){
         return ymuserid;
    }

	/**
	 * set账号ID
	 */
    public void setYmuserid(Long ymuserid){
         this.ymuserid=ymuserid;
    }

	/**
	 * get密码
	 */
    public String getPwd(){
         return pwd;
    }

	/**
	 * set密码
	 */
    public void setPwd(String pwd){
         this.pwd=pwd;
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
	 * get代理ID
	 */
    public String getAgentid(){
         return agentid;
    }

	/**
	 * set代理ID
	 */
    public void setAgentid(String agentid){
         this.agentid=agentid;
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
	 * get短信数量
	 */
    public Long getMemnum(){
         return memnum;
    }

	/**
	 * set短信数量
	 */
    public void setMemnum(Long memnum){
         this.memnum=memnum;
    }

	/**
	 * get备用1
	 */
    public String getBack1(){
         return back1;
    }

	/**
	 * set备用1
	 */
    public void setBack1(String back1){
         this.back1=back1;
    }

	/**
	 * get备用2
	 */
    public String getBack2(){
         return back2;
    }

	/**
	 * set备用2
	 */
    public void setBack2(String back2){
         this.back2=back2;
    }

	/**
	 * get备用3
	 */
    public String getBack3(){
         return back3;
    }

	/**
	 * set备用3
	 */
    public void setBack3(String back3){
         this.back3=back3;
    }

	/**
	 * get备用4
	 */
    public String getBack4(){
         return back4;
    }

	/**
	 * set备用4
	 */
    public void setBack4(String back4){
         this.back4=back4;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + ymuserid +"|"
	   
	 + pwd +"|"
	   
	 + price +"|"
	   
	 + agentid +"|"
	   
	 + state +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + memnum +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + back4
	 + "]";
 } 

}
