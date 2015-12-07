/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelagent;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *加盟商返点表
 */
public class HotelagentBean implements java.io.Serializable{

	/**
	  *加盟商返点表 表名
	  */
	public static final String TABLE  = "T_HOTELAGENT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *开始时间 列名 
	  */
    public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";
	
	/**
	  *返点星级 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *加盟商ID 列名 
	  */
    public static final String COL_customeragentid  = "C_CUSTOMERAGENTID";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";

	//ID
	private long id;    
    

	//创建时间
	private Timestamp createtime;    
    

	//开始时间
	private Timestamp starttime;    
    

	//结束时间
	private Timestamp endtime;    
    

	//返点星级
	private Long state;    
    

	//加盟商ID
	private Long customeragentid;    
    

	//创建人id
	private Long memberid;    
    

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
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set开始时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
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
	 * get返点星级
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set返点星级
	 */
    public void setState(Long state){
         this.state=state;
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
	 * get创建人id
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set创建人id
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + createtime +"|"
	   
	 + starttime +"|"
	   
	 + endtime +"|"
	   
	 + state +"|"
	   
	 + customeragentid +"|"
	   
	 + memberid
	 + "]";
 } 

}
