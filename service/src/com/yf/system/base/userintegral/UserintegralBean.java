/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.userintegral;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *会员积分记录表
 */
public class UserintegralBean implements java.io.Serializable{

	/**
	  *会员积分记录表 表名
	  */
	public static final String TABLE  = "T_USERINTEGRAL";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
	/**
	  *相关ID 列名 
	  */
    public static final String COL_relatedid  = "C_RELATEDID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *动作 列名 
	  */
    public static final String COL_behavior  = "C_BEHAVIOR";
	
	/**
	  *动作前值 列名 
	  */
    public static final String COL_sval  = "C_SVAL";
	
	/**
	  *动作后值 列名 
	  */
    public static final String COL_eval  = "C_EVAL";
	
	/**
	  *本次动作值 列名 
	  */
    public static final String COL_val  = "C_VAL";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//会员ID
	private Long userid;    
    

	//相关ID
	private Long relatedid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//动作
	private String behavior;    
    

	//动作前值
	private Double sval;    
    

	//动作后值
	private Double eval;    
    

	//本次动作值
	private Double val;    
    

	//创建人
	private Long createuserid;    
    

	//类型
	private Long type;    //1是酒店 2是旅游 3是租车  4机票
    

	//备注
	private String comment;    
    

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
	 * get会员ID
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set会员ID
	 */
    public void setUserid(Long userid){
         this.userid=userid;
    }

	/**
	 * get相关ID
	 */
    public Long getRelatedid(){
         return relatedid;
    }

	/**
	 * set相关ID
	 */
    public void setRelatedid(Long relatedid){
         this.relatedid=relatedid;
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
	 * get动作
	 */
    public String getBehavior(){
         return behavior;
    }

	/**
	 * set动作
	 */
    public void setBehavior(String behavior){
         this.behavior=behavior;
    }

	/**
	 * get动作前值
	 */
    public Double getSval(){
         return sval;
    }

	/**
	 * set动作前值
	 */
    public void setSval(Double sval){
         this.sval=sval;
    }

	/**
	 * get动作后值
	 */
    public Double getEval(){
         return eval;
    }

	/**
	 * set动作后值
	 */
    public void setEval(Double eval){
         this.eval=eval;
    }

	/**
	 * get本次动作值
	 */
    public Double getVal(){
         return val;
    }

	/**
	 * set本次动作值
	 */
    public void setVal(Double val){
         this.val=val;
    }

	/**
	 * get创建人
	 */
    public Long getCreateuserid(){
         return createuserid;
    }

	/**
	 * set创建人
	 */
    public void setCreateuserid(Long createuserid){
         this.createuserid=createuserid;
    }

	/**
	 * get类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get备注
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set备注
	 */
    public void setComment(String comment){
         this.comment=comment;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + userid +"|"
	   
	 + relatedid +"|"
	   
	 + createtime +"|"
	   
	 + behavior +"|"
	   
	 + sval +"|"
	   
	 + eval +"|"
	   
	 + val +"|"
	   
	 + createuserid +"|"
	   
	 + type +"|"
	   
	 + comment
	 + "]";
 } 

}
