/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.gerenguazhanfrec;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *个人挂账记录表
 */
public class GerenguazhanfrecBean implements java.io.Serializable{

	/**
	  *个人挂账记录表 表名
	  */
	public static final String TABLE  = "T_GERENGUAZHANFREC";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *员工ID 列名 
	  */
    public static final String COL_employeeid  = "C_EMPLOYEEID";
	
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
	  *修改者 列名 
	  */
    public static final String COL_midifyuser  = "C_MIDIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_midifytime  = "C_MIDIFYTIME";

	//ID
	private long id;    
    

	//订单ID
	private Long orderid;    
    

	//员工ID
	private Long employeeid;    
    

	//状态
	private Long state;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String midifyuser;    
    

	//修改时间
	private Timestamp midifytime;    
    

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
	 * get员工ID
	 */
    public Long getEmployeeid(){
         return employeeid;
    }

	/**
	 * set员工ID
	 */
    public void setEmployeeid(Long employeeid){
         this.employeeid=employeeid;
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
	 * get修改者
	 */
    public String getMidifyuser(){
         return midifyuser;
    }

	/**
	 * set修改者
	 */
    public void setMidifyuser(String midifyuser){
         this.midifyuser=midifyuser;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getMidifytime(){
         return midifytime;
    }

	/**
	 * set修改时间
	 */
    public void setMidifytime(Timestamp midifytime){
         this.midifytime=midifytime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + employeeid +"|"
	   
	 + state +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + midifyuser +"|"
	   
	 + midifytime
	 + "]";
 } 

}
