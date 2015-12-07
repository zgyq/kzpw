/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.airflight;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航班基础信息表
 */
public class AirflightBean implements java.io.Serializable{

	/**
	  *航班基础信息表 表名
	  */
	public static final String TABLE  = "T_AIRFLIGHT";

	
	/**
	  *航班ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航空公司两字码 列名 
	  */
    public static final String COL_aircompanycode  = "C_AIRCOMPANYCODE";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *出发机场三字码 列名 
	  */
    public static final String COL_sairportcode  = "C_SAIRPORTCODE";
	
	/**
	  *到达机场三字码 列名 
	  */
    public static final String COL_eairportcode  = "C_EAIRPORTCODE";
	
	/**
	  *是否启用(0=禁用,1=启用) 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createusertime  = "C_CREATEUSERTIME";
	
	/**
	  *修改人 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//航班ID
	private long id;    
    

	//航空公司两字码
	private String aircompanycode;    
    

	//航班号
	private String flightnumber;    
    

	//出发机场三字码
	private String sairportcode;    
    

	//到达机场三字码
	private String eairportcode;    
    

	//是否启用(0=禁用,1=启用)
	private Integer isenable;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createusertime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	/**
	 * get航班ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set航班ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get航空公司两字码
	 */
    public String getAircompanycode(){
         return aircompanycode;
    }

	/**
	 * set航空公司两字码
	 */
    public void setAircompanycode(String aircompanycode){
         this.aircompanycode=aircompanycode;
    }

	/**
	 * get航班号
	 */
    public String getFlightnumber(){
         return flightnumber;
    }

	/**
	 * set航班号
	 */
    public void setFlightnumber(String flightnumber){
         this.flightnumber=flightnumber;
    }

	/**
	 * get出发机场三字码
	 */
    public String getSairportcode(){
         return sairportcode;
    }

	/**
	 * set出发机场三字码
	 */
    public void setSairportcode(String sairportcode){
         this.sairportcode=sairportcode;
    }

	/**
	 * get到达机场三字码
	 */
    public String getEairportcode(){
         return eairportcode;
    }

	/**
	 * set到达机场三字码
	 */
    public void setEairportcode(String eairportcode){
         this.eairportcode=eairportcode;
    }

	/**
	 * get是否启用(0=禁用,1=启用)
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set是否启用(0=禁用,1=启用)
	 */
    public void setIsenable(Integer isenable){
         this.isenable=isenable;
    }

	/**
	 * get创建人
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
	 */
    public void setCreateuser(String createuser){
         this.createuser=createuser;
    }

	/**
	 * get创建时间
	 */
    public Timestamp getCreateusertime(){
         return createusertime;
    }

	/**
	 * set创建时间
	 */
    public void setCreateusertime(Timestamp createusertime){
         this.createusertime=createusertime;
    }

	/**
	 * get修改人
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改人
	 */
    public void setModifyuser(String modifyuser){
         this.modifyuser=modifyuser;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getModifytime(){
         return modifytime;
    }

	/**
	 * set修改时间
	 */
    public void setModifytime(Timestamp modifytime){
         this.modifytime=modifytime;
    }

	/**
	 * get父编号
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * set父编号
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语言类型
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + aircompanycode +"|"
	   
	 + flightnumber +"|"
	   
	 + sairportcode +"|"
	   
	 + eairportcode +"|"
	   
	 + isenable +"|"
	   
	 + createuser +"|"
	   
	 + createusertime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
