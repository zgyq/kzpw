/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.backpoint;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *隐扣设置
 */
public class BackpointBean implements java.io.Serializable{

	/**
	  *隐扣设置 表名
	  */
	public static final String TABLE  = "T_BACKPOINT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *启用时间 列名 
	  */
    public static final String COL_startdate  = "C_STARTDATE";
	
	/**
	  *是否启用 列名 
	  */
    public static final String COL_isenables  = "C_ISENABLES";
	
	/**
	  *隐扣数据 列名 
	  */
    public static final String COL_backpoint  = "C_BACKPOINT";
	
	/**
	  *政策区间 列名 
	  */
    public static final String COL_policyrange  = "C_POLICYRANGE";
	
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
	  *加盟商ID 列名 
	  */
    public static final String COL_customeragentid  = "C_CUSTOMERAGENTID";

	//ID
	private long id;    
    

	//启用时间
	private Timestamp startdate;    
    

	//是否启用
	private Integer isenables;    
    

	//隐扣数据
	private String backpoint;    
    

	//政策区间
	private String policyrange;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//加盟商ID
	private Long customeragentid;    
    

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
	 * get启用时间
	 */
    public Timestamp getStartdate(){
         return startdate;
    }

	/**
	 * set启用时间
	 */
    public void setStartdate(Timestamp startdate){
         this.startdate=startdate;
    }

	/**
	 * get是否启用
	 */
    public Integer getIsenables(){
         return isenables;
    }

	/**
	 * set是否启用
	 */
    public void setIsenables(Integer isenables){
         this.isenables=isenables;
    }

	/**
	 * get隐扣数据
	 */
    public String getBackpoint(){
         return backpoint;
    }

	/**
	 * set隐扣数据
	 */
    public void setBackpoint(String backpoint){
         this.backpoint=backpoint;
    }

	/**
	 * get政策区间
	 */
    public String getPolicyrange(){
         return policyrange;
    }

	/**
	 * set政策区间
	 */
    public void setPolicyrange(String policyrange){
         this.policyrange=policyrange;
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
	 * get加盟商ID
	 */
    public Long getCustomeragentid(){
         return customeragentid;
    }

	/**
	 * set加盟商ID
	 */
    public void setCustomeragentid(Long customeragentid){
         this.customeragentid=customeragentid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + startdate +"|"
	   
	 + isenables +"|"
	   
	 + backpoint +"|"
	   
	 + policyrange +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + customeragentid
	 + "]";
 } 

}
