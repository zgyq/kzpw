/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.exchrecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *积分兑换纪录
 */
public class ExchrecordBean implements java.io.Serializable{

	/**
	  *积分兑换纪录 表名
	  */
	public static final String TABLE  = "T_EXCHRECORD";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *奖品ID 列名 
	  */
    public static final String COL_prizeid  = "C_PRIZEID";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_customerid  = "C_CUSTOMERID";
	
	/**
	  *联系人 列名 
	  */
    public static final String COL_contactname  = "C_CONTACTNAME";
	
	/**
	  *联系手机 列名 
	  */
    public static final String COL_contactmobile  = "C_CONTACTMOBILE";
	
	/**
	  *联系地址 列名 
	  */
    public static final String COL_contactadd  = "C_CONTACTADD";
	
	/**
	  *备注信息 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
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

	//ID
	private long id;    
    

	//奖品ID
	private Integer prizeid;    
    

	//会员ID
	private Integer customerid;    
    

	//联系人
	private String contactname;    
    

	//联系手机
	private String contactmobile;    
    

	//联系地址
	private String contactadd;    
    

	//备注信息
	private String desc;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

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
	 * get奖品ID
	 */
    public Integer getPrizeid(){
         return prizeid;
    }

	/**
	 * set奖品ID
	 */
    public void setPrizeid(Integer prizeid){
         this.prizeid=prizeid;
    }

	/**
	 * get会员ID
	 */
    public Integer getCustomerid(){
         return customerid;
    }

	/**
	 * set会员ID
	 */
    public void setCustomerid(Integer customerid){
         this.customerid=customerid;
    }

	/**
	 * get联系人
	 */
    public String getContactname(){
         return contactname;
    }

	/**
	 * set联系人
	 */
    public void setContactname(String contactname){
         this.contactname=contactname;
    }

	/**
	 * get联系手机
	 */
    public String getContactmobile(){
         return contactmobile;
    }

	/**
	 * set联系手机
	 */
    public void setContactmobile(String contactmobile){
         this.contactmobile=contactmobile;
    }

	/**
	 * get联系地址
	 */
    public String getContactadd(){
         return contactadd;
    }

	/**
	 * set联系地址
	 */
    public void setContactadd(String contactadd){
         this.contactadd=contactadd;
    }

	/**
	 * get备注信息
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set备注信息
	 */
    public void setDesc(String desc){
         this.desc=desc;
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
	   
	 + prizeid +"|"
	   
	 + customerid +"|"
	   
	 + contactname +"|"
	   
	 + contactmobile +"|"
	   
	 + contactadd +"|"
	   
	 + desc +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
