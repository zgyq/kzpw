/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customeraircard;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *里程卡
 */
public class CustomeraircardBean implements java.io.Serializable{

	/**
	  *里程卡 表名
	  */
	public static final String TABLE  = "T_CUSTOMERAIRCARD";

	
	/**
	  *卡编号 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *卡类型 列名 
	  */
    public static final String COL_aircardtype  = "C_AIRCARDTYPE";
	
	/**
	  *卡号 列名 
	  */
    public static final String COL_aircardnumber  = "C_AIRCARDNUMBER";
	
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
	  *关联ID 列名 
	  */
    public static final String COL_refid  = "C_REFID";

	//卡编号
	private long id;    
    

	//卡类型
	private String aircardtype;    
    

	//卡号
	private String aircardnumber;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//关联ID
	private Long refid;    
    

	/**
	 * get卡编号
	 */
    public long getId(){
         return id;
    }

	/**
	 * set卡编号
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get卡类型
	 */
    public String getAircardtype(){
         return aircardtype;
    }

	/**
	 * set卡类型
	 */
    public void setAircardtype(String aircardtype){
         this.aircardtype=aircardtype;
    }

	/**
	 * get卡号
	 */
    public String getAircardnumber(){
         return aircardnumber;
    }

	/**
	 * set卡号
	 */
    public void setAircardnumber(String aircardnumber){
         this.aircardnumber=aircardnumber;
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
	 * get关联ID
	 */
    public Long getRefid(){
         return refid;
    }

	/**
	 * set关联ID
	 */
    public void setRefid(Long refid){
         this.refid=refid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + aircardtype +"|"
	   
	 + aircardnumber +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + refid
	 + "]";
 } 

}
