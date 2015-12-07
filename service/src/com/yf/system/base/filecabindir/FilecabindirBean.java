/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.filecabindir;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *文件柜目录
 */
public class FilecabindirBean implements java.io.Serializable{

	/**
	  *文件柜目录 表名
	  */
	public static final String TABLE  = "T_FILECABINDIR";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *父目录 列名 
	  */
    public static final String COL_parentid  = "C_PARENTID";
	
	/**
	  *父目录ID串 列名 
	  */
    public static final String COL_parentidstr  = "C_PARENTIDSTR";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_descrition  = "C_DESCRITION";
	
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
	  *权限 列名 
	  */
    public static final String COL_right  = "C_RIGHT";
	
	/**
	  *创建ID 列名 
	  */
    public static final String COL_craeteid  = "C_CREATEID";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//父目录
	private Long parentid;    
    

	//父目录ID串
	private String parentidstr;    
    

	//描述
	private String descrition;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//权限
	private String right;    
    

	//创建ID
	private Long craeteid;    
    

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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get父目录
	 */
    public Long getParentid(){
         return parentid;
    }

	/**
	 * set父目录
	 */
    public void setParentid(Long parentid){
         this.parentid=parentid;
    }

	/**
	 * get父目录ID串
	 */
    public String getParentidstr(){
         return parentidstr;
    }

	/**
	 * set父目录ID串
	 */
    public void setParentidstr(String parentidstr){
         this.parentidstr=parentidstr;
    }

	/**
	 * get描述
	 */
    public String getDescrition(){
         return descrition;
    }

	/**
	 * set描述
	 */
    public void setDescrition(String descrition){
         this.descrition=descrition;
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
	 * get权限
	 */
    public String getRight(){
         return right;
    }

	/**
	 * set权限
	 */
    public void setRight(String right){
         this.right=right;
    }

	/**
	 * get创建ID
	 */
    public Long getCreateid(){
         return craeteid;
    }

	/**
	 * set创建ID
	 */
    public void setCreateid(Long craeteid){
         this.craeteid=craeteid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + parentid +"|"
	   
	 + parentidstr +"|"
	   
	 + descrition +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + right +"|"
	   
	 + craeteid
	 + "]";
 } 

}
