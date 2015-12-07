/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.xcdnoinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *行程单号码
 */
public class XcdnoinfoBean implements java.io.Serializable{

	/**
	  *行程单号码 表名
	  */
	public static final String TABLE  = "T_XCDNOINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *开始号码 列名 
	  */
    public static final String COL_sno  = "C_SNO";
	
	/**
	  *结束号码 列名 
	  */
    public static final String COL_endno  = "C_ENDNO";
	
	/**
	  *行程单编号ID 列名 
	  */
    public static final String COL_xcdid  = "C_XCDID";
	
	/**
	  *号码 列名 
	  */
    public static final String COL_xcdinfo  = "C_XCDINFO";
	
	/**
	  *OFFICE 列名 
	  */
    public static final String COL_officecode  = "C_OFFICECODE";
	
	/**
	  *填开单位 列名 
	  */
    public static final String COL_companyname  = "C_COMPANYNAME";
	
	/**
	  *领单单位 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//开始号码
	private String sno;    
    

	//结束号码
	private String endno;    
    

	//行程单编号ID
	private Long xcdid;    
    

	//号码
	private String xcdinfo;    
    

	//OFFICE
	private String officecode;    
    

	//填开单位
	private String companyname;    
    

	//领单单位
	private Long agentid;    
    

	//创建人
	private Long userid;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get开始号码
	 */
    public String getSno(){
         return sno;
    }

	/**
	 * set开始号码
	 */
    public void setSno(String sno){
         this.sno=sno;
    }

	/**
	 * get结束号码
	 */
    public String getEndno(){
         return endno;
    }

	/**
	 * set结束号码
	 */
    public void setEndno(String endno){
         this.endno=endno;
    }

	/**
	 * get行程单编号ID
	 */
    public Long getXcdid(){
         return xcdid;
    }

	/**
	 * set行程单编号ID
	 */
    public void setXcdid(Long xcdid){
         this.xcdid=xcdid;
    }

	/**
	 * get号码
	 */
    public String getXcdinfo(){
         return xcdinfo;
    }

	/**
	 * set号码
	 */
    public void setXcdinfo(String xcdinfo){
         this.xcdinfo=xcdinfo;
    }

	/**
	 * getOFFICE
	 */
    public String getOfficecode(){
         return officecode;
    }

	/**
	 * setOFFICE
	 */
    public void setOfficecode(String officecode){
         this.officecode=officecode;
    }

	/**
	 * get填开单位
	 */
    public String getCompanyname(){
         return companyname;
    }

	/**
	 * set填开单位
	 */
    public void setCompanyname(String companyname){
         this.companyname=companyname;
    }

	/**
	 * get领单单位
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set领单单位
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get创建人
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set创建人
	 */
    public void setUserid(Long userid){
         this.userid=userid;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + sno +"|"
	   
	 + endno +"|"
	   
	 + xcdid +"|"
	   
	 + xcdinfo +"|"
	   
	 + officecode +"|"
	   
	 + companyname +"|"
	   
	 + agentid +"|"
	   
	 + userid +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
