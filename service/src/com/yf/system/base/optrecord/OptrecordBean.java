/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.optrecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *操作记录表
 */
public class OptrecordBean implements java.io.Serializable{

	/**
	  *操作记录表 表名
	  */
	public static final String TABLE  = "T_OPTRECORD";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *表名 列名 
	  */
    public static final String COL_tablename  = "C_TABLENAME";
	
	/**
	  *列名 列名 
	  */
    public static final String COL_column  = "C_COLUMN";
	
	/**
	  *修改前 列名 
	  */
    public static final String COL_oldvalue  = "C_OLDVALUE";
	
	/**
	  *修改后 列名 
	  */
    public static final String COL_newvalue  = "C_NEWVALUE";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改ID 列名 
	  */
    public static final String COL_optid  = "C_OPTID";

	//id
	private long id;    
    

	//表名
	private String tablename;    
    

	//列名
	private String column;    
    

	//修改前
	private String oldvalue;    
    

	//修改后
	private String newvalue;    
    

	//描述
	private String description;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改ID
	private Long optid;    
    

	/**
	 * getid
	 */
    public long getId(){
         return id;
    }

	/**
	 * setid
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get表名
	 */
    public String getTablename(){
         return tablename;
    }

	/**
	 * set表名
	 */
    public void setTablename(String tablename){
         this.tablename=tablename;
    }

	/**
	 * get列名
	 */
    public String getColumn(){
         return column;
    }

	/**
	 * set列名
	 */
    public void setColumn(String column){
         this.column=column;
    }

	/**
	 * get修改前
	 */
    public String getOldvalue(){
         return oldvalue;
    }

	/**
	 * set修改前
	 */
    public void setOldvalue(String oldvalue){
         this.oldvalue=oldvalue;
    }

	/**
	 * get修改后
	 */
    public String getNewvalue(){
         return newvalue;
    }

	/**
	 * set修改后
	 */
    public void setNewvalue(String newvalue){
         this.newvalue=newvalue;
    }

	/**
	 * get描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set描述
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get创建人
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
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
	 * get修改ID
	 */
    public Long getOptid(){
         return optid;
    }

	/**
	 * set修改ID
	 */
    public void setOptid(Long optid){
         this.optid=optid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + tablename +"|"
	   
	 + column +"|"
	   
	 + oldvalue +"|"
	   
	 + newvalue +"|"
	   
	 + description +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + optid
	 + "]";
 } 

}
