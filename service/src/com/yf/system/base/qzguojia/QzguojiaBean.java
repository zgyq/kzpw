/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qzguojia;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *签证国家
 */
public class QzguojiaBean implements java.io.Serializable{

	/**
	  *签证国家 表名
	  */
	public static final String TABLE  = "T_QZGUOJIA";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *产品国家id 列名 
	  */
    public static final String COL_classid  = "C_CLASSID";
	
	/**
	  *产品国家名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *产品洲ID 列名 
	  */
    public static final String COL_bclassid  = "C_BCLASSID";
	
	/**
	  *产品洲名称 列名 
	  */
    public static final String COL_bclassname  = "C_BCLASSNAME";
	
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
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//产品国家id
	private String classid;    
    

	//产品国家名称
	private String name;    
    

	//产品洲ID
	private String bclassid;    
    

	//产品洲名称
	private String bclassname;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

	//状态
	private Long state;    
    

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
	 * get产品国家id
	 */
    public String getClassid(){
         return classid;
    }

	/**
	 * set产品国家id
	 */
    public void setClassid(String classid){
         this.classid=classid;
    }

	/**
	 * get产品国家名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set产品国家名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get产品洲ID
	 */
    public String getBclassid(){
         return bclassid;
    }

	/**
	 * set产品洲ID
	 */
    public void setBclassid(String bclassid){
         this.bclassid=bclassid;
    }

	/**
	 * get产品洲名称
	 */
    public String getBclassname(){
         return bclassname;
    }

	/**
	 * set产品洲名称
	 */
    public void setBclassname(String bclassname){
         this.bclassname=bclassname;
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
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + classid +"|"
	   
	 + name +"|"
	   
	 + bclassid +"|"
	   
	 + bclassname +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
