/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.airfee;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *燃油费机建费表
 */
public class AirfeeBean implements java.io.Serializable{

	/**
	  *燃油费机建费表 表名
	  */
	public static final String TABLE  = "T_AIRFEE";

	
	/**
	  *燃油机建费ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *成人机建费 列名 
	  */
    public static final String COL_adultairportfee  = "C_ADULTAIRPORTFEE";
	
	/**
	  *儿童机建费 列名 
	  */
    public static final String COL_chdairportfee  = "C_CHDAIRPORTFEE";
	
	/**
	  *婴儿机建费 列名 
	  */
    public static final String COL_babyairportfee  = "C_BABYAIRPORTFEE";
	
	/**
	  *成人机建费(支线) 列名 
	  */
    public static final String COL_nearadultairpotyfee  = "C_NEARADULTAIRPOTYFEE";
	
	/**
	  *儿童机建费(支线) 列名 
	  */
    public static final String COL_nearchdairpotyfee  = "C_NEARCHDAIRPOTYFEE";
	
	/**
	  *婴儿机建费(支线) 列名 
	  */
    public static final String COL_nearbabyairportfee  = "C_NEARBABYAIRPORTFEE";
	
	/**
	  *成人燃油费 列名 
	  */
    public static final String COL_adultfuelfee  = "C_ADULTFUELFEE";
	
	/**
	  *儿童燃油费 列名 
	  */
    public static final String COL_chdfuelfee  = "C_CHDFUELFEE";
	
	/**
	  *婴儿燃油费 列名 
	  */
    public static final String COL_babyfuelfee  = "C_BABYFUELFEE";
	
	/**
	  *成人燃油费(近) 列名 
	  */
    public static final String COL_nearadultfuelfee  = "C_NEARADULTFUELFEE";
	
	/**
	  *儿童燃油费(近) 列名 
	  */
    public static final String COL_nearchdfuelfee  = "C_NEARCHDFUELFEE";
	
	/**
	  *婴儿燃油费(近) 列名 
	  */
    public static final String COL_nearbabyfuelfee  = "C_NEARBABYFUELFEE";
	
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

	//燃油机建费ID
	private long id;    
    

	//成人机建费
	private Integer adultairportfee;    
    

	//儿童机建费
	private Integer chdairportfee;    
    

	//婴儿机建费
	private Integer babyairportfee;    
    

	//成人机建费(支线)
	private Integer nearadultairpotyfee;    
    

	//儿童机建费(支线)
	private Integer nearchdairpotyfee;    
    

	//婴儿机建费(支线)
	private Integer nearbabyairportfee;    
    

	//成人燃油费
	private Integer adultfuelfee;    
    

	//儿童燃油费
	private Integer chdfuelfee;    
    

	//婴儿燃油费
	private Integer babyfuelfee;    
    

	//成人燃油费(近)
	private Integer nearadultfuelfee;    
    

	//儿童燃油费(近)
	private Integer nearchdfuelfee;    
    

	//婴儿燃油费(近)
	private Integer nearbabyfuelfee;    
    

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
	 * get燃油机建费ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set燃油机建费ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get成人机建费
	 */
    public Integer getAdultairportfee(){
         return adultairportfee;
    }

	/**
	 * set成人机建费
	 */
    public void setAdultairportfee(Integer adultairportfee){
         this.adultairportfee=adultairportfee;
    }

	/**
	 * get儿童机建费
	 */
    public Integer getChdairportfee(){
         return chdairportfee;
    }

	/**
	 * set儿童机建费
	 */
    public void setChdairportfee(Integer chdairportfee){
         this.chdairportfee=chdairportfee;
    }

	/**
	 * get婴儿机建费
	 */
    public Integer getBabyairportfee(){
         return babyairportfee;
    }

	/**
	 * set婴儿机建费
	 */
    public void setBabyairportfee(Integer babyairportfee){
         this.babyairportfee=babyairportfee;
    }

	/**
	 * get成人机建费(支线)
	 */
    public Integer getNearadultairpotyfee(){
         return nearadultairpotyfee;
    }

	/**
	 * set成人机建费(支线)
	 */
    public void setNearadultairpotyfee(Integer nearadultairpotyfee){
         this.nearadultairpotyfee=nearadultairpotyfee;
    }

	/**
	 * get儿童机建费(支线)
	 */
    public Integer getNearchdairpotyfee(){
         return nearchdairpotyfee;
    }

	/**
	 * set儿童机建费(支线)
	 */
    public void setNearchdairpotyfee(Integer nearchdairpotyfee){
         this.nearchdairpotyfee=nearchdairpotyfee;
    }

	/**
	 * get婴儿机建费(支线)
	 */
    public Integer getNearbabyairportfee(){
         return nearbabyairportfee;
    }

	/**
	 * set婴儿机建费(支线)
	 */
    public void setNearbabyairportfee(Integer nearbabyairportfee){
         this.nearbabyairportfee=nearbabyairportfee;
    }

	/**
	 * get成人燃油费
	 */
    public Integer getAdultfuelfee(){
         return adultfuelfee;
    }

	/**
	 * set成人燃油费
	 */
    public void setAdultfuelfee(Integer adultfuelfee){
         this.adultfuelfee=adultfuelfee;
    }

	/**
	 * get儿童燃油费
	 */
    public Integer getChdfuelfee(){
         return chdfuelfee;
    }

	/**
	 * set儿童燃油费
	 */
    public void setChdfuelfee(Integer chdfuelfee){
         this.chdfuelfee=chdfuelfee;
    }

	/**
	 * get婴儿燃油费
	 */
    public Integer getBabyfuelfee(){
         return babyfuelfee;
    }

	/**
	 * set婴儿燃油费
	 */
    public void setBabyfuelfee(Integer babyfuelfee){
         this.babyfuelfee=babyfuelfee;
    }

	/**
	 * get成人燃油费(近)
	 */
    public Integer getNearadultfuelfee(){
         return nearadultfuelfee;
    }

	/**
	 * set成人燃油费(近)
	 */
    public void setNearadultfuelfee(Integer nearadultfuelfee){
         this.nearadultfuelfee=nearadultfuelfee;
    }

	/**
	 * get儿童燃油费(近)
	 */
    public Integer getNearchdfuelfee(){
         return nearchdfuelfee;
    }

	/**
	 * set儿童燃油费(近)
	 */
    public void setNearchdfuelfee(Integer nearchdfuelfee){
         this.nearchdfuelfee=nearchdfuelfee;
    }

	/**
	 * get婴儿燃油费(近)
	 */
    public Integer getNearbabyfuelfee(){
         return nearbabyfuelfee;
    }

	/**
	 * set婴儿燃油费(近)
	 */
    public void setNearbabyfuelfee(Integer nearbabyfuelfee){
         this.nearbabyfuelfee=nearbabyfuelfee;
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
	   
	 + adultairportfee +"|"
	   
	 + chdairportfee +"|"
	   
	 + babyairportfee +"|"
	   
	 + nearadultairpotyfee +"|"
	   
	 + nearchdairpotyfee +"|"
	   
	 + nearbabyairportfee +"|"
	   
	 + adultfuelfee +"|"
	   
	 + chdfuelfee +"|"
	   
	 + babyfuelfee +"|"
	   
	 + nearadultfuelfee +"|"
	   
	 + nearchdfuelfee +"|"
	   
	 + nearbabyfuelfee +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
