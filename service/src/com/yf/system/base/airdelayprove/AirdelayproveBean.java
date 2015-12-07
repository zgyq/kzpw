/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.airdelayprove;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航班延误证明
 */
public class AirdelayproveBean implements java.io.Serializable{

	/**
	  *航班延误证明 表名
	  */
	public static final String TABLE  = "T_AIRDELAYPROVE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_airnum  = "C_AIRNUM";
	
	/**
	  *加盟商ID 列名 
	  */
    public static final String COL_angentid  = "C_ANGENTID";
	
	/**
	  *PNR信息 列名 
	  */
    public static final String COL_pnr  = "C_PNR";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *航班延误信息 列名 
	  */
    public static final String COL_descinfo  = "C_DESCINFO";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_remark  = "C_REMARK";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *附件地址 列名 
	  */
    public static final String COL_urldesc  = "C_URLDESC";

	//ID
	private long id;    
    

	//航班号
	private String airnum;    
    

	//加盟商ID
	private Long angentid;    
    

	//PNR信息
	private String pnr;    
    

	//起飞时间
	private String stime;    
    

	//航班延误信息
	private String descinfo;    
    

	//备注
	private String remark;    
    

	//创建时间
	private Timestamp createtime;    
    

	//状态
	private Long state;    
    

	//创建人id
	private Long memberid;    
    

	//附件地址
	private String urldesc;    
    

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
    public String getAirnum(){
         return airnum;
    }

	/**
	 * set航班号
	 */
    public void setAirnum(String airnum){
         this.airnum=airnum;
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
	 * getPNR信息
	 */
    public String getPnr(){
         return pnr;
    }

	/**
	 * setPNR信息
	 */
    public void setPnr(String pnr){
         this.pnr=pnr;
    }

	/**
	 * get起飞时间
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set起飞时间
	 */
    public void setStime(String stime){
         this.stime=stime;
    }

	/**
	 * get航班延误信息
	 */
    public String getDescinfo(){
         return descinfo;
    }

	/**
	 * set航班延误信息
	 */
    public void setDescinfo(String descinfo){
         this.descinfo=descinfo;
    }

	/**
	 * get备注
	 */
    public String getRemark(){
         return remark;
    }

	/**
	 * set备注
	 */
    public void setRemark(String remark){
         this.remark=remark;
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
	 * get附件地址
	 */
    public String getUrldesc(){
         return urldesc;
    }

	/**
	 * set附件地址
	 */
    public void setUrldesc(String urldesc){
         this.urldesc=urldesc;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + airnum +"|"
	   
	 + angentid +"|"
	   
	 + pnr +"|"
	   
	 + stime +"|"
	   
	 + descinfo +"|"
	   
	 + remark +"|"
	   
	 + createtime +"|"
	   
	 + state +"|"
	   
	 + memberid +"|"
	   
	 + urldesc
	 + "]";
 } 

}
