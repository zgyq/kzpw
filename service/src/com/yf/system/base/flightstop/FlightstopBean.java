/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.flightstop;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航班经停信息
 */
public class FlightstopBean implements java.io.Serializable{

	/**
	  *航班经停信息 表名
	  */
	public static final String TABLE  = "T_FLIGHTSTOP";

	
	/**
	  *航班经停ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出发机场三字代码 列名 
	  */
    public static final String COL_sairportcode  = "C_SAIRPORTCODE";
	
	/**
	  *到达机场三字代码 列名 
	  */
    public static final String COL_eairportcode  = "C_EAIRPORTCODE";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *经停次数 列名 
	  */
    public static final String COL_stopnumber  = "C_STOPNUMBER";
	
	/**
	  *经停城市 列名 
	  */
    public static final String COL_city  = "C_CITY";
	
	/**
	  *停留时间 列名 
	  */
    public static final String COL_time  = "C_TIME";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改人 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *是否启用(0=禁用,1=启用) 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//航班经停ID
	private long id;    
    

	//出发机场三字代码
	private String sairportcode;    
    

	//到达机场三字代码
	private String eairportcode;    
    

	//航班号
	private String flightnumber;    
    

	//经停次数
	private Integer stopnumber;    
    

	//经停城市
	private String city;    
    

	//停留时间
	private String time;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//是否启用(0=禁用,1=启用)
	private Integer isenable;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	/**
	 * get航班经停ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set航班经停ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get出发机场三字代码
	 */
    public String getSairportcode(){
         return sairportcode;
    }

	/**
	 * set出发机场三字代码
	 */
    public void setSairportcode(String sairportcode){
         this.sairportcode=sairportcode;
    }

	/**
	 * get到达机场三字代码
	 */
    public String getEairportcode(){
         return eairportcode;
    }

	/**
	 * set到达机场三字代码
	 */
    public void setEairportcode(String eairportcode){
         this.eairportcode=eairportcode;
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
	 * get经停次数
	 */
    public Integer getStopnumber(){
         return stopnumber;
    }

	/**
	 * set经停次数
	 */
    public void setStopnumber(Integer stopnumber){
         this.stopnumber=stopnumber;
    }

	/**
	 * get经停城市
	 */
    public String getCity(){
         return city;
    }

	/**
	 * set经停城市
	 */
    public void setCity(String city){
         this.city=city;
    }

	/**
	 * get停留时间
	 */
    public String getTime(){
         return time;
    }

	/**
	 * set停留时间
	 */
    public void setTime(String time){
         this.time=time;
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
	   
	 + sairportcode +"|"
	   
	 + eairportcode +"|"
	   
	 + flightnumber +"|"
	   
	 + stopnumber +"|"
	   
	 + city +"|"
	   
	 + time +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + isenable +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
