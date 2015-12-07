/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotticketcity;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *门票城市
 */
public class SpotticketcityBean implements java.io.Serializable{

	/**
	  *门票城市 表名
	  */
	public static final String TABLE  = "T_SPOTTICKETCITY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部ID 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *父ID 列名 
	  */
    public static final String COL_parentid  = "C_PARENTID";
	
	/**
	  *类型(1省2市3区) 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *父ID串 列名 
	  */
    public static final String COL_parentidstr  = "C_PARENTIDSTR";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *拼音 列名 
	  */
    public static final String COL_pinyin  = "C_PINYIN";
	
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
    

	//外部ID
	private String outid;    
    

	//父ID
	private String parentid;    
    

	//类型(1省2市3区)
	private Long type;    
    

	//父ID串
	private String parentidstr;    
    

	//名称
	private String name;    
    

	//拼音
	private String pinyin;    
    

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
	 * get外部ID
	 */
    public String getOutid(){
         return outid;
    }

	/**
	 * set外部ID
	 */
    public void setOutid(String outid){
         this.outid=outid;
    }

	/**
	 * get父ID
	 */
    public String getParentid(){
         return parentid;
    }

	/**
	 * set父ID
	 */
    public void setParentid(String parentid){
         this.parentid=parentid;
    }

	/**
	 * get类型(1省2市3区)
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型(1省2市3区)
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get父ID串
	 */
    public String getParentidstr(){
         return parentidstr;
    }

	/**
	 * set父ID串
	 */
    public void setParentidstr(String parentidstr){
         this.parentidstr=parentidstr;
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
	 * get拼音
	 */
    public String getPinyin(){
         return pinyin;
    }

	/**
	 * set拼音
	 */
    public void setPinyin(String pinyin){
         this.pinyin=pinyin;
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
	   
	 + outid +"|"
	   
	 + parentid +"|"
	   
	 + type +"|"
	   
	 + parentidstr +"|"
	   
	 + name +"|"
	   
	 + pinyin +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
