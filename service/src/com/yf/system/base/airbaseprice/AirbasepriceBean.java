/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.airbaseprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机票基础价格表
 */
public class AirbasepriceBean implements java.io.Serializable{

	/**
	  *机票基础价格表 表名
	  */
	public static final String TABLE  = "T_AIRBASEPRICE";

	
	/**
	  *基础价格序号 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出发机场三字码 列名 
	  */
    public static final String COL_sairportcode  = "C_SAIRPORTCODE";
	
	/**
	  *到达机场三字码 列名 
	  */
    public static final String COL_eairportcode  = "C_EAIRPORTCODE";
	
	/**
	  *里程数 列名 
	  */
    public static final String COL_miles  = "C_MILES";
	
	/**
	  *Y舱价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *航空公司两字代码 列名 
	  */
    public static final String COL_aircompanycode  = "C_AIRCOMPANYCODE";
	
	/**
	  *是否启用(0=禁用,1=启用) 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *行李重量 列名 
	  */
    public static final String COL_yqflag  = "C_YQFLAG";
	
	/**
	  *有效期开始时间 列名 
	  */
    public static final String COL_startdate  = "C_STARTDATE";
	
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
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//基础价格序号
	private long id;    
    

	//出发机场三字码
	private String sairportcode;    
    

	//到达机场三字码
	private String eairportcode;    
    

	//里程数
	private String miles;    
    

	//Y舱价格
	private Integer price;    
    

	//航空公司两字代码
	private String aircompanycode;    
    

	//是否启用(0=禁用,1=启用)
	private Integer isenable;    
    

	//行李重量
	private Integer yqflag;    
    

	//有效期开始时间
	private Timestamp startdate;    
    

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
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	/**
	 * get基础价格序号
	 */
    public long getId(){
         return id;
    }

	/**
	 * set基础价格序号
	 */
    public void setId(long id){
         this.id=id;
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
	 * get里程数
	 */
    public String getMiles(){
         return miles;
    }

	/**
	 * set里程数
	 */
    public void setMiles(String miles){
         this.miles=miles;
    }

	/**
	 * getY舱价格
	 */
    public Integer getPrice(){
         return price;
    }

	/**
	 * setY舱价格
	 */
    public void setPrice(Integer price){
         this.price=price;
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
	 * get行李重量
	 */
    public Integer getYqflag(){
         return yqflag;
    }

	/**
	 * set行李重量
	 */
    public void setYqflag(Integer yqflag){
         this.yqflag=yqflag;
    }

	/**
	 * get有效期开始时间
	 */
    public Timestamp getStartdate(){
         return startdate;
    }

	/**
	 * set有效期开始时间
	 */
    public void setStartdate(Timestamp startdate){
         this.startdate=startdate;
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
	   
	 + miles +"|"
	   
	 + price +"|"
	   
	 + aircompanycode +"|"
	   
	 + isenable +"|"
	   
	 + yqflag +"|"
	   
	 + startdate +"|"
	   
	 + enddate +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
