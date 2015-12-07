/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.agentvalue;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *加盟商固定返点
 */
public class AgentvalueBean implements java.io.Serializable{

	/**
	  *加盟商固定返点 表名
	  */
	public static final String TABLE  = "T_AGENTVALUE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *加盟商名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *加盟商ID 列名 
	  */
    public static final String COL_angentid  = "C_ANGENTID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *固定返点值 列名 
	  */
    public static final String COL_rvalue  = "C_RVALUE";

	//ID
	private long id;    
    

	//加盟商名称
	private String name;    
    

	//加盟商ID
	private Long angentid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
	private Long memberid;    
    

	//固定返点值
	private String rvalue;    
    

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
	 * get加盟商名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set加盟商名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get加盟商ID
	 */
    public Long getAngentid(){
         return angentid;
    }

	/**
	 * set加盟商ID
	 */
    public void setAngentid(Long angentid){
         this.angentid=angentid;
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

	/**
	 * get固定返点值
	 */
    public String getRvalue(){
         return rvalue;
    }

	/**
	 * set固定返点值
	 */
    public void setRvalue(String rvalue){
         this.rvalue=rvalue;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + angentid +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + rvalue
	 + "]";
 } 

}
