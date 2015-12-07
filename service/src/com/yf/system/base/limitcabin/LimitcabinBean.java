
package com.yf.system.base.limitcabin;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *限制仓位
 */
public class LimitcabinBean implements java.io.Serializable{

	/**
	  *限制仓位 表名
	  */
	public static final String TABLE  = "T_LIMITCABIN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *仓位 列名 
	  */
    public static final String COL_cabin  = "C_CABIN";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *开始时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//航班号
	private String name;    
    

	//仓位
	private String cabin;    
    

	//创建时间
	private Timestamp createtime;    
    

	//开始时间
	private Timestamp stime;    
    

	//结束时间
	private Timestamp endtime;    
    

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
	 * get航班号
	 */
    public String getName(){
         return name;
    }

	/**
	 * set航班号
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get仓位
	 */
    public String getCabin(){
         return cabin;
    }

	/**
	 * set仓位
	 */
    public void setCabin(String cabin){
         this.cabin=cabin;
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
	 * get开始时间
	 */
    public Timestamp getStime(){
         return stime;
    }

	/**
	 * set开始时间
	 */
    public void setStime(Timestamp stime){
         this.stime=stime;
    }

	/**
	 * get结束时间
	 */
    public Timestamp getEndtime(){
         return endtime;
    }

	/**
	 * set结束时间
	 */
    public void setEndtime(Timestamp endtime){
         this.endtime=endtime;
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
	   
	 + name +"|"
	   
	 + cabin +"|"
	   
	 + createtime +"|"
	   
	 + stime +"|"
	   
	 + endtime +"|"
	   
	 + state
	 + "]";
 } 

}
