/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.infotype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *信息类型
 */
public class InfotypeBean implements java.io.Serializable{

	/**
	  *信息类型 表名
	  */
	public static final String TABLE  = "T_INFOTYPE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *类型名称 列名 
	  */
    public static final String COL_typename  = "C_TYPENAME";
	
	/**
	  *类型排序 列名 
	  */
    public static final String COL_index  = "C_INDEX";
	
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
    

	//类型名称
	private String typename;    
    

	//类型排序
	private Integer index;    
    

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
	 * get类型名称
	 */
    public String getTypename(){
         return typename;
    }

	/**
	 * set类型名称
	 */
    public void setTypename(String typename){
         this.typename=typename;
    }

	/**
	 * get类型排序
	 */
    public Integer getIndex(){
         return index;
    }

	/**
	 * set类型排序
	 */
    public void setIndex(Integer index){
         this.index=index;
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
	   
	 + typename +"|"
	   
	 + index +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
