/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qqinfonew;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *QQ号码
 */
public class QqinfonewBean implements java.io.Serializable{

	/**
	  *QQ号码 表名
	  */
	public static final String TABLE  = "T_QQINFONEW";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *QQ号 列名 
	  */
    public static final String COL_qqno  = "C_QQNO";
	
	/**
	  *类型ID 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
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
    

	//QQ号
	private String qqno;    
    

	//类型ID
	private Long typeid;    
    

	//创建人
	private Long userid;    
    

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
	 * getQQ号
	 */
    public String getQqno(){
         return qqno;
    }

	/**
	 * setQQ号
	 */
    public void setQqno(String qqno){
         this.qqno=qqno;
    }

	/**
	 * get类型ID
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set类型ID
	 */
    public void setTypeid(Long typeid){
         this.typeid=typeid;
    }

	/**
	 * get创建人
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set创建人
	 */
    public void setUserid(Long userid){
         this.userid=userid;
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
	   
	 + qqno +"|"
	   
	 + typeid +"|"
	   
	 + userid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
