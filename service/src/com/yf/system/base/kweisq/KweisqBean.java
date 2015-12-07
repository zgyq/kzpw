/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.kweisq;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *K位特价申请表
 */
public class KweisqBean implements java.io.Serializable{

	/**
	  *K位特价申请表 表名
	  */
	public static final String TABLE  = "T_KWEISQ";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *供应商ID 列名 
	  */
    public static final String COL_angenid  = "C_ANGENID";
	
	/**
	  *分销商ID 列名 
	  */
    public static final String COL_distributorid  = "C_DISTRIBUTORID";
	
	/**
	  *乘机人数 列名 
	  */
    public static final String COL_peoplenumber  = "C_PEOPLENUMBER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *联系人手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *联系人邮箱 列名 
	  */
    public static final String COL_postbox  = "C_POSTBOX";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *K位信息ID 列名 
	  */
    public static final String COL_kweiid  = "C_KWEIID";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_updatetime  = "C_UPDATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_updateuser  = "C_UPDATEUSER";
    /**
	  *成人 列名 
	  */
   public static final String COL_chenren  = "C_CHENGREN";
   /**
	  *儿童 列名 
	  */
  public static final String COL_ertong  = "C_UERTONG";
  /**
	  *婴儿 列名 
	  */
 public static final String COL_yinger  = "C_YINGER";

	//ID
	private long id;    
    

	//供应商ID
	private Long angenid;    
    

	//分销商ID
	private Long distributorid;    
    

	//乘机人数
	private Long peoplenumber;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建者
	private String createuser;    
    

	//联系人姓名
	private String username;    
    

	//联系人手机
	private String mobile;    
    

	//联系人邮箱
	private String postbox;    
    

	//备注
	private String comment;    
    

	//状态
	private Long status;    
    

	//K位信息ID
	private Long kweiid;    
    

	//修改时间
	private Timestamp updatetime;    
    

	//修改者
	private String updateuser;    
	
	//成人
	private Long chengren;   
	
	//儿童
	private Long ertong;   
	
	//婴儿
	private Long yinger;   
    

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
	 * get供应商ID
	 */
    public Long getAngenid(){
         return angenid;
    }

	/**
	 * set供应商ID
	 */
    public void setAngenid(Long angenid){
         this.angenid=angenid;
    }

	/**
	 * get分销商ID
	 */
    public Long getDistributorid(){
         return distributorid;
    }

	/**
	 * set分销商ID
	 */
    public void setDistributorid(Long distributorid){
         this.distributorid=distributorid;
    }

	/**
	 * get乘机人数
	 */
    public Long getPeoplenumber(){
         return peoplenumber;
    }

	/**
	 * set乘机人数
	 */
    public void setPeoplenumber(Long peoplenumber){
         this.peoplenumber=peoplenumber;
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
	 * get联系人姓名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set联系人姓名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get联系人手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set联系人手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get联系人邮箱
	 */
    public String getPostbox(){
         return postbox;
    }

	/**
	 * set联系人邮箱
	 */
    public void setPostbox(String postbox){
         this.postbox=postbox;
    }

	/**
	 * get备注
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set备注
	 */
    public void setComment(String comment){
         this.comment=comment;
    }

	/**
	 * get状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Long status){
         this.status=status;
    }

	/**
	 * getK位信息ID
	 */
    public Long getKweiid(){
         return kweiid;
    }

	/**
	 * setK位信息ID
	 */
    public void setKweiid(Long kweiid){
         this.kweiid=kweiid;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getUpdatetime(){
         return updatetime;
    }

	/**
	 * set修改时间
	 */
    public void setUpdatetime(Timestamp updatetime){
         this.updatetime=updatetime;
    }

	/**
	 * get修改者
	 */
    public String getUpdateuser(){
         return updateuser;
    }

	/**
	 * set修改者
	 */
    public void setUpdateuser(String updateuser){
         this.updateuser=updateuser;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + angenid +"|"
	   
	 + distributorid +"|"
	   
	 + peoplenumber +"|"
	   
	 + createtime +"|"
	   
	 + createuser +"|"
	   
	 + username +"|"
	   
	 + mobile +"|"
	   
	 + postbox +"|"
	   
	 + comment +"|"
	   
	 + status +"|"
	   
	 + kweiid +"|"
	   
	 + updatetime +"|"
	 
	 + chengren +"|"
	 
	 + ertong +"|"
	 
	 + yinger +"|"
	   
	 + updateuser
	 + "]";
 }

	public Long getChengren() {
		return chengren;
	}

	public void setChengren(Long chengren) {
		this.chengren = chengren;
	}

	public Long getErtong() {
		return ertong;
	}

	public void setErtong(Long ertong) {
		this.ertong = ertong;
	}

	public Long getYinger() {
		return yinger;
	}

	public void setYinger(Long yinger) {
		this.yinger = yinger;
	} 

}
