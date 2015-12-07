/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.starsettlementtype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *星级结算分类
 */
public class StarsettlementtypeBean implements java.io.Serializable{

	/**
	  *星级结算分类 表名
	  */
	public static final String TABLE  = "T_STARSETTLEMENTTYPE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *类型名称 列名 
	  */
    public static final String COL_typename  = "C_TYPENAME";
	
	/**
	  *星级留点记录id 列名 
	  */
    public static final String COL_sliudianid  = "C_SLIUDIANID";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *所属家盟商id 列名 
	  */
    public static final String COL_sagentid  = "C_SAGENTID";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";

	//ID
	private long id;    
    

	//类型名称
	private String typename;    
    

	//星级留点记录id
	private Long sliudianid;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//所属家盟商id
	private Long sagentid;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

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
	 * get星级留点记录id
	 */
    public Long getSliudianid(){
         return sliudianid;
    }

	/**
	 * set星级留点记录id
	 */
    public void setSliudianid(Long sliudianid){
         this.sliudianid=sliudianid;
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
	 * get所属家盟商id
	 */
    public Long getSagentid(){
         return sagentid;
    }

	/**
	 * set所属家盟商id
	 */
    public void setSagentid(Long sagentid){
         this.sagentid=sagentid;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + typename +"|"
	   
	 + sliudianid +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + sagentid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
