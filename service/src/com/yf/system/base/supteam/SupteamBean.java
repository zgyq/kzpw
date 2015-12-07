/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.supteam;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *团队申请报价表
 */
public class SupteamBean implements java.io.Serializable{

	/**
	  *团队申请报价表 表名
	  */
	public static final String TABLE  = "T_SUPTEAM";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *团队申请信息ID 列名 
	  */
    public static final String COL_teamid  = "C_TEAMID";
	
	/**
	  *供应商ID 列名 
	  */
    public static final String COL_supplierid  = "C_SUPPLIERID";
	
	/**
	  *分销商ID 列名 
	  */
    public static final String COL_distributorid  = "C_DISTRIBUTORID";
	
	/**
	  *报价 列名 
	  */
    public static final String COL_offer  = "C_OFFER";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

    /**
	  *创建时间 列名 
	  */
   public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//团队申请信息ID
	private Long teamid;    
    

	//供应商ID
	private Long supplierid;    
    

	//分销商ID
	private Long distributorid;    
    

	//报价
	private String offer;    
    

	//状态
	private Long status;    
    

	//备注
	private String comment;    
    
	//创建时间
	private Timestamp createtime;
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
	 * get团队申请信息ID
	 */
    public Long getTeamid(){
         return teamid;
    }

	/**
	 * set团队申请信息ID
	 */
    public void setTeamid(Long teamid){
         this.teamid=teamid;
    }

	/**
	 * get供应商ID
	 */
    public Long getSupplierid(){
         return supplierid;
    }

	/**
	 * set供应商ID
	 */
    public void setSupplierid(Long supplierid){
         this.supplierid=supplierid;
    }

	/**
	 * get分销商ID
	 */
    public Long getDistributorid(){
         return distributorid;
    }

	/**
	 * set分销商ID
	 */
    public void setDistributorid(Long distributorid){
         this.distributorid=distributorid;
    }

	/**
	 * get报价
	 */
    public String getOffer(){
         return offer;
    }

	/**
	 * set报价
	 */
    public void setOffer(String offer){
         this.offer=offer;
    }

	/**
	 * get状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Long status){
         this.status=status;
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


	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + teamid +"|"
	   
	 + supplierid +"|"
	   
	 + distributorid +"|"
	   
	 + offer +"|"
	   
	 + status +"|"
	   
	 + createtime +"|"
	 
	 + comment
	 + "]";
 } 

}
