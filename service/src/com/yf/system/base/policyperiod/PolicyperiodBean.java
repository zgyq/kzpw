/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.policyperiod;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *政策有效期表
 */
public class PolicyperiodBean implements java.io.Serializable{

	/**
	  *政策有效期表 表名
	  */
	public static final String TABLE  = "T_POLICYPERIOD";

	
	/**
	  *政策有效期ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *政策ID 列名 
	  */
    public static final String COL_policyguid  = "C_POLICYGUID";
	
	/**
	  *开始日期 列名 
	  */
    public static final String COL_begindate  = "C_BEGINDATE";
	
	/**
	  *结束日期 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
	/**
	  *政策编号 列名 
	  */
    public static final String COL_zrateid  = "C_ZRATEID";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创??时间 列名 
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
	  *是否启用 列名 
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

	//政策有效期ID
	private long id;    
    

	//政策ID
	private Long policyguid;    
    

	//开始日期
	private Timestamp begindate;    
    

	//结束日期
	private Timestamp enddate;    
    

	//政策编号
	private Long zrateid;    
    

	//创建人
	private String createuser;    
    

	//创??时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//是否启用
	private Integer isenable;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	/**
	 * get政策有效期ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set政策有效期ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get政策ID
	 */
    public Long getPolicyguid(){
         return policyguid;
    }

	/**
	 * set政策ID
	 */
    public void setPolicyguid(Long policyguid){
         this.policyguid=policyguid;
    }

	/**
	 * get开始日期
	 */
    public Timestamp getBegindate(){
         return begindate;
    }

	/**
	 * set开始日期
	 */
    public void setBegindate(Timestamp begindate){
         this.begindate=begindate;
    }

	/**
	 * get结束日期
	 */
    public Timestamp getEnddate(){
         return enddate;
    }

	/**
	 * set结束日期
	 */
    public void setEnddate(Timestamp enddate){
         this.enddate=enddate;
    }

	/**
	 * get政策编号
	 */
    public Long getZrateid(){
         return zrateid;
    }

	/**
	 * set政策编号
	 */
    public void setZrateid(Long zrateid){
         this.zrateid=zrateid;
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
	 * get创??时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set创??时间
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
	 * get是否启用
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set是否启用
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
	   
	 + policyguid +"|"
	   
	 + begindate +"|"
	   
	 + enddate +"|"
	   
	 + zrateid +"|"
	   
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
