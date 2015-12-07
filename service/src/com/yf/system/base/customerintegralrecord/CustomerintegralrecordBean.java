/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customerintegralrecord;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *会员积分记录
 */
public class CustomerintegralrecordBean implements java.io.Serializable{

	/**
	  *会员积分记录 表名
	  */
	public static final String TABLE  = "T_CUSTOMERINTEGRALRECORD";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *关联会员ID 列名 
	  */
    public static final String COL_refuid  = "C_REFUID";
    /**
     *关联订单号 列名 
     */
    public static final String COL_refordernumber  = "C_REFORDERNUMBER";
	
    /**
     *积分来源 
     */
    public static final String COL_scoresource  = "C_SCORESOURCE";
    
	/**
	  *本次积分 列名 
	  */
    public static final String COL_score  = "C_SCORE";
	
	/**
	  *时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *积分说明 列名 
	  */
    public static final String COL_scorememo  = "C_SCOREMEMO";

	//ID
	private long id;    
    

	//关联会员ID
	private long refuid;    
	//关联订单号
	private String refordernumber;    
	//积分来源
	private String scoresource;    
    

	//本次积分
	private Integer score;    
    

	//时间
	private Timestamp createtime;    
    

	//积分说明
	private String scorememo;    
    

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
	 * get关联会员ID
	 */
    public long getRefuid(){
         return refuid;
    }

	/**
	 * set关联会员ID
	 */
    public void setRefuid(long refuid){
         this.refuid=refuid;
    }

	/**
	 * get本次积分
	 */
    public Integer getScore(){
         return score;
    }

	/**
	 * set本次积分
	 */
    public void setScore(Integer score){
         this.score=score;
    }

	/**
	 * get时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }




	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + refuid +"|"
	   
	 + score +"|"
	   
	 + createtime +"|"
	   
	 + scorememo
	 + "]";
 }

	public String getRefordernumber() {
		return refordernumber;
	}

	public void setRefordernumber(String refordernumber) {
		this.refordernumber = refordernumber;
	}

	public String getScoresource() {
		return scoresource;
	}

	public void setScoresource(String scoresource) {
		this.scoresource = scoresource;
	}

	public String getScorememo() {
		return scorememo;
	}

	public void setScorememo(String scorememo) {
		this.scorememo = scorememo;
	} 

}
