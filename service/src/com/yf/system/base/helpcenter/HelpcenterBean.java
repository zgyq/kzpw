/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.helpcenter;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *帮助中心
 */
public class HelpcenterBean implements java.io.Serializable{

	/**
	  *帮助中心 表名
	  */
	public static final String TABLE  = "T_HELPCENTER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
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
 	  *是否主推 列名 
 	  */
   public static final String COL_isweb  = "C_ISWEB";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
	private Long memberid;    
    

	//状态
	private Long state;    
    

	//父ID
	private Long parentid;    
    

	//父ID串
	private String parentstr;    
	
	//是否主推显示
	private Long isweb;   //1主推  2其他不主推

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


	public Long getIsweb() {
		return isweb;
	}

	public void setIsweb(Long isweb) {
		this.isweb = isweb;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + state +"|"
	   
	 + parentid +"|"
	 
	 + isweb +"|"
	   
	 + parentstr
	 + "]";
 } 

}
