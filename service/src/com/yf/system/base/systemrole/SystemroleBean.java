/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.systemrole;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *系统角色
 */
public class SystemroleBean implements java.io.Serializable{

	/**
	  *系统角色 表名
	  */
	public static final String TABLE  = "T_SYSTEMROLE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
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
	
	/**
	  *角色类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *角色代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
    
    
    /**
     * 业务类型
     */
    public static final String COL_bussinessid  = "C_BUSSINESSID";

    private long bussinessid;

	//ID
	private long id;    
    

	//名称
	private String name;    
    

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
    

	//角色类型
	private Integer type;    
    

	//角色代码
	private String code;    
    

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

	/**
	 * get角色类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set角色类型
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get角色代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set角色代码
	 */
    public void setCode(String code){
         this.code=code;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + customeragentid +"|"
	   
	 + type +"|"
	   
	 + code
	 + "]";
 }

	public long getBussinessid() {
		return bussinessid;
	}

	public void setBussinessid(long bussinessid) {
		this.bussinessid = bussinessid;
	} 

}
