/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.telephone;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *其他电话
 */
public class TelephoneBean implements java.io.Serializable{

	/**
	  *其他电话 表名
	  */
	public static final String TABLE  = "T_TELEPHONE";

	
	/**
	  *电话编号 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_customeruserid  = "C_CUSTOMERUSERID";
	
	/**
	  *电话号码 列名 
	  */
    public static final String COL_telnumber  = "C_TELNUMBER";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_teltype  = "C_TELTYPE";
	
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

	//电话编号
	private long id;    
    

	//会员ID
	private Long customeruserid;    
    

	//电话号码
	private String telnumber;    
    

	//类型
	private Integer teltype;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	/**
	 * get电话编号
	 */
    public long getId(){
         return id;
    }

	/**
	 * set电话编号
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get会员ID
	 */
    public Long getCustomeruserid(){
         return customeruserid;
    }

	/**
	 * set会员ID
	 */
    public void setCustomeruserid(Long customeruserid){
         this.customeruserid=customeruserid;
    }

	/**
	 * get电话号码
	 */
    public String getTelnumber(){
         return telnumber;
    }

	/**
	 * set电话号码
	 */
    public void setTelnumber(String telnumber){
         this.telnumber=telnumber;
    }

	/**
	 * get类型
	 */
    public Integer getTeltype(){
         return teltype;
    }

	/**
	 * set类型
	 */
    public void setTeltype(Integer teltype){
         this.teltype=teltype;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + customeruserid +"|"
	   
	 + telnumber +"|"
	   
	 + teltype +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
