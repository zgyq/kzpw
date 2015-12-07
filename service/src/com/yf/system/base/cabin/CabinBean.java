/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.cabin;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *舱位基础信息表
 */
public class CabinBean implements java.io.Serializable{

	/**
	  *舱位基础信息表 表名
	  */
	public static final String TABLE  = "T_CABIN";

	
	/**
	  *舱位ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航空公司两字代码 列名 
	  */
    public static final String COL_aircompanycode  = "C_AIRCOMPANYCODE";
	
	/**
	  *舱位码 列名 
	  */
    public static final String COL_cabincode  = "C_CABINCODE";
	
	/**
	  *舱位折扣 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *是否启用(0=禁用,1=启用?) 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *有效期开始时?? 列名 
	  */
    public static final String COL_stratedate  = "C_STRATEDATE";
	
	/**
	  *有效期结束时间 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
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
	  *退改签规则 列名 
	  */
    public static final String COL_cabinrule  = "C_CABINRULE";
	
	/**
	  *经济舱 列名 
	  */
    public static final String COL_typename  = "C_TYPENAME";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//舱位ID
	private long id;    
    

	//航空公司两字代码
	private String aircompanycode;    
    

	//舱位码
	private String cabincode;    
    

	//舱位折扣
	private Integer discount;    
    

	//是否启用(0=禁用,1=启用?)
	private Integer isenable;    
    

	//有效期开始时??
	private Timestamp stratedate;    
    

	//有效期结束时间
	private Timestamp enddate;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//退改签规则
	private String cabinrule;    
    

	//经济舱
	private String typename;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	/**
	 * get舱位ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set舱位ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get航空公司两字代码
	 */
    public String getAircompanycode(){
         return aircompanycode;
    }

	/**
	 * set航空公司两字代码
	 */
    public void setAircompanycode(String aircompanycode){
         this.aircompanycode=aircompanycode;
    }

	/**
	 * get舱位码
	 */
    public String getCabincode(){
         return cabincode;
    }

	/**
	 * set舱位码
	 */
    public void setCabincode(String cabincode){
         this.cabincode=cabincode;
    }

	/**
	 * get舱位折扣
	 */
    public Integer getDiscount(){
         return discount;
    }

	/**
	 * set舱位折扣
	 */
    public void setDiscount(Integer discount){
         this.discount=discount;
    }

	/**
	 * get是否启用(0=禁用,1=启用?)
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set是否启用(0=禁用,1=启用?)
	 */
    public void setIsenable(Integer isenable){
         this.isenable=isenable;
    }

	/**
	 * get有效期开始时??
	 */
    public Timestamp getStratedate(){
         return stratedate;
    }

	/**
	 * set有效期开始时??
	 */
    public void setStratedate(Timestamp stratedate){
         this.stratedate=stratedate;
    }

	/**
	 * get有效期结束时间
	 */
    public Timestamp getEnddate(){
         return enddate;
    }

	/**
	 * set有效期结束时间
	 */
    public void setEnddate(Timestamp enddate){
         this.enddate=enddate;
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
	 * get退改签规则
	 */
    public String getCabinrule(){
         return cabinrule;
    }

	/**
	 * set退改签规则
	 */
    public void setCabinrule(String cabinrule){
         this.cabinrule=cabinrule;
    }

	/**
	 * get经济舱
	 */
    public String getTypename(){
         return typename;
    }

	/**
	 * set经济舱
	 */
    public void setTypename(String typename){
         this.typename=typename;
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
	   
	 + cabincode +"|"
	   
	 + discount +"|"
	   
	 + isenable +"|"
	   
	 + stratedate +"|"
	   
	 + enddate +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + cabinrule +"|"
	   
	 + typename +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
