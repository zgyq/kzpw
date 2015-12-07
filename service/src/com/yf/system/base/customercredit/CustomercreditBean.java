/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customercredit;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *证件
 */
public class CustomercreditBean implements java.io.Serializable{

	/**
	  *证件 表名
	  */
	public static final String TABLE  = "T_CUSTOMERCREDIT";

	
	/**
	  *证件编号 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *证件类型 列名 
	  */
    public static final String COL_credittypeid  = "C_CREDITTYPEID";
	
	/**
	  *证件号 列名 
	  */
    public static final String COL_creditnumber  = "C_CREDITNUMBER";
	
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
	  *类别(0会员,1常用旅客) 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *关联ID 列名 
	  */
    public static final String COL_refid  = "C_REFID";
	
	/**
	  *有效期 列名 
	  */
    public static final String COL_passportvalidity  = "C_PASSPORTVALIDITY";
	
	/**
	  *国籍 列名 
	  */
    public static final String COL_nationality  = "C_NATIONALITY";
	
	/**
	  *签发机关 列名 
	  */
    public static final String COL_issuingauthority  = "C_ISSUINGAUTHORITY";
    
    /**
	  * 状态 列名 
	  */
   public static final String COL_staus  = "C_STAUS";

	//证件编号
	private long id;    
    

	//证件类型
	private Integer credittypeid;    
    

	//证件号
	private String creditnumber;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//类别(0会员,1常用旅客)
	private Integer type;    
    

	//关联ID
	private Long refid;    
    

	//有效期
	private String passportvalidity;    
    

	//国籍
	private String nationality;    
    

	//签发机关
	private String issuingauthority; 
	
	//状态
	private Integer staus;    
    

	/**
	 * get证件编号
	 */
    public long getId(){
         return id;
    }

	/**
	 * set证件编号
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get证件类型
	 */
    public Integer getCredittypeid(){
         return credittypeid;
    }

	/**
	 * set证件类型
	 */
    public void setCredittypeid(Integer credittypeid){
         this.credittypeid=credittypeid;
    }

	/**
	 * get证件号
	 */
    public String getCreditnumber(){
         return creditnumber;
    }

	/**
	 * set证件号
	 */
    public void setCreditnumber(String creditnumber){
         this.creditnumber=creditnumber;
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
	 * get类别(0会员,1常用旅客)
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set类别(0会员,1常用旅客)
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get关联ID
	 */
    public Long getRefid(){
         return refid;
    }

	/**
	 * set关联ID
	 */
    public void setRefid(Long refid){
         this.refid=refid;
    }

	/**
	 * get有效期
	 */
    public String getPassportvalidity(){
         return passportvalidity;
    }

	/**
	 * set有效期
	 */
    public void setPassportvalidity(String passportvalidity){
         this.passportvalidity=passportvalidity;
    }

	/**
	 * get国籍
	 */
    public String getNationality(){
         return nationality;
    }

	/**
	 * set国籍
	 */
    public void setNationality(String nationality){
         this.nationality=nationality;
    }

	/**
	 * get签发机关
	 */
    public String getIssuingauthority(){
         return issuingauthority;
    }

	/**
	 * set签发机关
	 */
    public void setIssuingauthority(String issuingauthority){
         this.issuingauthority=issuingauthority;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + credittypeid +"|"
	   
	 + creditnumber +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + type +"|"
	   
	 + refid +"|"
	   
	 + passportvalidity +"|"
	   
	 + nationality +"|"
	 
	 + staus +"|"
	   
	 + issuingauthority
	 + "]";
 }

	public Integer getStaus() {
		return staus;
	}

	public void setStaus(Integer staus) {
		this.staus = staus;
	} 

}
