/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.systemright;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *系统权限
 */
public class SystemrightBean implements java.io.Serializable{

	/**
	  *系统权限 表名
	  */
	public static final String TABLE  = "T_SYSTEMRIGHT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *操作名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *操作代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
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
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *父ID 列名 
	  */
    public static final String COL_parentid  = "C_PARENTID";
	
	/**
	  *父ID串 列名 
	  */
    public static final String COL_parentstr  = "C_PARENTSTR";
	
	/**
	  *权限类别 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *资源 列名 
	  */
    public static final String COL_resource  = "C_RESOURCE";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";

	//ID
	private long id;    
    

	//操作名称
	private String name;    
    

	//操作代码
	private String code;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//状态
	private Integer state;    
    

	//父ID
	private Long parentid;    
    

	//父ID串
	private String parentstr;    
    

	//权限类别
	private Integer type;    
    

	//资源
	private String resource;    
    

	//排序
	private Integer orderid;    
    

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
	 * get操作名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set操作名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get操作代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set操作代码
	 */
    public void setCode(String code){
         this.code=code;
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
	 * get状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Integer state){
         this.state=state;
    }

	/**
	 * get父ID
	 */
    public Long getParentid(){
         return parentid;
    }

	/**
	 * set父ID
	 */
    public void setParentid(Long parentid){
         this.parentid=parentid;
    }

	/**
	 * get父ID串
	 */
    public String getParentstr(){
         return parentstr;
    }

	/**
	 * set父ID串
	 */
    public void setParentstr(String parentstr){
         this.parentstr=parentstr;
    }

	/**
	 * get权限类别
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set权限类别
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get资源
	 */
    public String getResource(){
         return resource;
    }

	/**
	 * set资源
	 */
    public void setResource(String resource){
         this.resource=resource;
    }

	/**
	 * get排序
	 */
    public Integer getOrderid(){
         return orderid;
    }

	/**
	 * set排序
	 */
    public void setOrderid(Integer orderid){
         this.orderid=orderid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + code +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + state +"|"
	   
	 + parentid +"|"
	   
	 + parentstr +"|"
	   
	 + type +"|"
	   
	 + resource +"|"
	   
	 + orderid
	 + "]";
 } 

}
