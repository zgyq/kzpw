/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.peisong;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *行程单配送记录
 */
public class PeisongBean implements java.io.Serializable{

	/**
	  *行程单配送记录 表名
	  */
	public static final String TABLE  = "T_PEISONG";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *收件人 列名 
	  */
    public static final String COL_linkname  = "C_LINKNAME";
	
	/**
	  *邮政编码 列名 
	  */
    public static final String COL_addcode  = "C_ADDCODE";
	
	/**
	  *联系电话 列名 
	  */
    public static final String COL_linktel  = "C_LINKTEL";
	
	/**
	  *联系地址 列名 
	  */
    public static final String COL_dizhi  = "C_DIZHI";
	
	/**
	  *代理ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *创建人 列名 
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
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//订单ID
	private Long orderid;    
    

	//收件人
	private String linkname;    
    

	//邮政编码
	private String addcode;    
    

	//联系电话
	private String linktel;    
    

	//联系地址
	private String dizhi;    
    

	//代理ID
	private Long agentid;    
    

	//创建人
	private Long userid;    
    

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
	 * get收件人
	 */
    public String getLinkname(){
         return linkname;
    }

	/**
	 * set收件人
	 */
    public void setLinkname(String linkname){
         this.linkname=linkname;
    }

	/**
	 * get邮政编码
	 */
    public String getAddcode(){
         return addcode;
    }

	/**
	 * set邮政编码
	 */
    public void setAddcode(String addcode){
         this.addcode=addcode;
    }

	/**
	 * get联系电话
	 */
    public String getLinktel(){
         return linktel;
    }

	/**
	 * set联系电话
	 */
    public void setLinktel(String linktel){
         this.linktel=linktel;
    }

	/**
	 * get联系地址
	 */
    public String getDizhi(){
         return dizhi;
    }

	/**
	 * set联系地址
	 */
    public void setDizhi(String dizhi){
         this.dizhi=dizhi;
    }

	/**
	 * get代理ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set代理ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get创建人
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set创建人
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
	   
	 + linkname +"|"
	   
	 + addcode +"|"
	   
	 + linktel +"|"
	   
	 + dizhi +"|"
	   
	 + agentid +"|"
	   
	 + userid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
