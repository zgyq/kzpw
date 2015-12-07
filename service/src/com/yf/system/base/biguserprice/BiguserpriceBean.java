/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.biguserprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *大客户还款金额记录表
 */
public class BiguserpriceBean implements java.io.Serializable{

	/**
	  *大客户还款金额记录表 表名
	  */
	public static final String TABLE  = "T_BIGUSERPRICE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *大客户ID 列名 
	  */
    public static final String COL_angentid  = "C_ANGENTID";
    
    
    public static final String COL_deptid="C_DEPTID";
	
	/**
	  *还款总金额 列名 
	  */
    public static final String COL_hkuanprice  = "C_HKUANPRICE";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
    /**
     *还款类型
     */
    public static final String COL_repaytype  = "C_repaytype";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

    public static final String COL_debt="C_DEBT";
	//ID
	private long id;    
    

	//大客户ID
	private Long angentid;    
	
	//大客户部门ID
	private Long deptid;
    

	//还款总金额
	private Double hkuanprice;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人
	private Long createuserid;    
    

	//备注
	private String comment;   
	
	//付款方式
	private Long repaytype;
	
	//还款后还欠
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
    public Long getAngentid(){
         return angentid;
    }

	/**
	 * set大客户ID
	 */
    public void setAngentid(Long angentid){
         this.angentid=angentid;
    }

	/**
	 * get还款总金额
	 */
    public Double getHkuanprice(){
         return hkuanprice;
    }

	/**
	 * set还款总金额
	 */
    public void setHkuanprice(Double hkuanprice){
         this.hkuanprice=hkuanprice;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + angentid +"|"
	   
	 + hkuanprice +"|"
	   
	 + createtime +"|"
	   
	 + createuserid +"|"
	   
	 + comment
	 + "]";
 }

	public Long getRepaytype() {
		return repaytype;
	}

	public void setRepaytype(Long repaytype) {
		this.repaytype = repaytype;
	}

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	}

	public Long getDeptid() {
		return deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	} 

}
