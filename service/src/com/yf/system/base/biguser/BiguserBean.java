/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.biguser;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *大客户关联金额表
 */
public class BiguserBean implements java.io.Serializable{

	/**
	  *大客户关联金额表 表名
	  */
	public static final String TABLE  = "T_BIGUSER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *大客户ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *信用额度 列名 
	  */
    public static final String COL_creditprice  = "C_CREDITPRICE";
	
	/**
	  *已用额度 列名 
	  */
    public static final String COL_yyongprice  = "C_YYONGPRICE";
	
	/**
	  *可用额度 列名 
	  */
    public static final String COL_kyongprice  = "C_KYONGPRICE";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";
    /**
	  *还款余额 列名 
	  */
     public static final String COL_yeprice  = "C_YEPRICE";
     
     /**
     * 大客户欠款总额
     */
    public static final String COL_debt="C_DEBT";

	//ID
	private long id;    
    

	//大客户ID
	private Long agentid;    
    

	//信用额度
	private Double creditprice;    
    

	//已用额度
	private Double yyongprice;    
    

	//可用额度
	private Double kyongprice;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人
	private Long createuserid;    
    

	//备注
	private String comment;    
    
	//还款余额
	private Double yeprice; 
	
	private Double debt;

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
	 * get大客户ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set大客户ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get信用额度
	 */
    public Double getCreditprice(){
         return creditprice;
    }

	/**
	 * set信用额度
	 */
    public void setCreditprice(Double creditprice){
         this.creditprice=creditprice;
    }

	/**
	 * get已用额度
	 */
    public Double getYyongprice(){
         return yyongprice;
    }

	/**
	 * set已用额度
	 */
    public void setYyongprice(Double yyongprice){
         this.yyongprice=yyongprice;
    }

	/**
	 * get可用额度
	 */
    public Double getKyongprice(){
         return kyongprice;
    }

	/**
	 * set可用额度
	 */
    public void setKyongprice(Double kyongprice){
         this.kyongprice=kyongprice;
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


	public Double getYeprice() {
		return yeprice;
	}

	public void setYeprice(Double yeprice) {
		this.yeprice = yeprice;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + agentid +"|"
	   
	 + creditprice +"|"
	   
	 + yyongprice +"|"
	   
	 + kyongprice +"|"
	   
	 + createtime +"|"
	   
	 + createuserid +"|"
	   
	 + yeprice +"|"
	 
	 + comment
	 
	 + "]";
 }

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	} 

}
