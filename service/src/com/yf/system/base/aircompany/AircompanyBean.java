/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.aircompany;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航空公司基础信息表
 */
public class AircompanyBean implements java.io.Serializable{

	/**
	  *航空公司基础信息表 表名
	  */
	public static final String TABLE  = "T_AIRCOMPANY";

	
	/**
	  *航空公司序号 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航空公司两字代码 列名 
	  */
    public static final String COL_aircomcode  = "C_AIRCOMCODE";
	
	/**
	  *航空公司中文名称 列名 
	  */
    public static final String COL_aircomcnname  = "C_AIRCOMCNNAME";
	
	/**
	  *航空公司简称 列名 
	  */
    public static final String COL_aircomjname  = "C_AIRCOMJNAME";
	
	/**
	  *航空公司英文名称 列名 
	  */
    public static final String COL_aircomenname  = "C_AIRCOMENNAME";
	
	/**
	  *航空公司logo 列名 
	  */
    public static final String COL_aircomlogo  = "C_AIRCOMLOGO";
	
	/**
	  *航空公司描述 列名 
	  */
    public static final String COL_aircomdesc  = "C_AIRCOMDESC";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
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
    
    public static final String COL_countrycode="C_COUNTRYCODE";
    
    //是否有包机服务  1有,其他没
    public static final String COL_isair="C_ISAIR";

	//航空公司序号
	private long id;    
    

	//航空公司两字代码
	private String aircomcode;    
    

	//航空公司中文名称
	private String aircomcnname;    
    

	//航空公司简称
	private String aircomjname;    
    

	//航空公司英文名称
	private String aircomenname;    
    

	//航空公司logo
	private String aircomlogo;    
    

	//航空公司描述
	private String aircomdesc;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//是否启用(0=禁用,1=启用)
	private Integer isenable;    
    

	//父编号
	private Long ucode;    
    

	//是否有包机服务
	private Long isair;    
    
	
	//语言类型
	private Integer language;    
	
	//城市代码
	private String countrycode;
    

	/**
	 * get航空公司序号
	 */
    public long getId(){
         return id;
    }

	/**
	 * set航空公司序号
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get航空公司两字代码
	 */
    public String getAircomcode(){
         return aircomcode;
    }

	/**
	 * set航空公司两字代码
	 */
    public void setAircomcode(String aircomcode){
         this.aircomcode=aircomcode;
    }

	/**
	 * get航空公司中文名称
	 */
    public String getAircomcnname(){
         return aircomcnname;
    }

	/**
	 * set航空公司中文名称
	 */
    public void setAircomcnname(String aircomcnname){
         this.aircomcnname=aircomcnname;
    }

	/**
	 * get航空公司简称
	 */
    public String getAircomjname(){
         return aircomjname;
    }

	/**
	 * set航空公司简称
	 */
    public void setAircomjname(String aircomjname){
         this.aircomjname=aircomjname;
    }

	/**
	 * get航空公司英文名称
	 */
    public String getAircomenname(){
         return aircomenname;
    }

	/**
	 * set航空公司英文名称
	 */
    public void setAircomenname(String aircomenname){
         this.aircomenname=aircomenname;
    }

	/**
	 * get航空公司logo
	 */
    public String getAircomlogo(){
         return aircomlogo;
    }

	/**
	 * set航空公司logo
	 */
    public void setAircomlogo(String aircomlogo){
         this.aircomlogo=aircomlogo;
    }

	/**
	 * get航空公司描述
	 */
    public String getAircomdesc(){
         return aircomdesc;
    }

	/**
	 * set航空公司描述
	 */
    public void setAircomdesc(String aircomdesc){
         this.aircomdesc=aircomdesc;
    }

	/**
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
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
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
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
	   
	 + aircomcode +"|"
	   
	 + aircomcnname +"|"
	   
	 + aircomjname +"|"
	   
	 + aircomenname +"|"
	   
	 + aircomlogo +"|"
	   
	 + aircomdesc +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + isenable +"|"
	   
	 + ucode +"|"
	 
	 + isair +"|"
	 
	 + countrycode +"|"
	   
	 + language
	 + "]";
 }

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Long getIsair() {
		return isair;
	}

	public void setIsair(Long isair) {
		this.isair = isair;
	} 

}
