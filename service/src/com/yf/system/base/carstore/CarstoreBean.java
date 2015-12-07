/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.carstore;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *租车门店
 */
public class CarstoreBean implements java.io.Serializable{

	/**
	  *租车门店 表名
	  */
	public static final String TABLE  = "T_CARSTORE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *门店编号 列名 
	  */
    public static final String COL_storecode  = "C_STORECODE";
	
	/**
	  *门店名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *开始营业时间 列名 
	  */
    public static final String COL_formtime  = "C_FORMTIME";
	
	/**
	  *结束营业时间 列名 
	  */
    public static final String COL_totime  = "C_TOTIME";
	
	/**
	  *所在市 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *所在省编号 列名 
	  */
    public static final String COL_provincecode  = "C_PROVINCECODE";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
	/**
	  *门店电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *所在区域 列名 
	  */
    public static final String COL_district  = "C_DISTRICT";
	
	/**
	  *所在地 列名 
	  */
    public static final String COL_abbrname  = "C_ABBRNAME";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//门店编号
	private String storecode;    
    

	//门店名称
	private String name;    
    

	//地址
	private String address;    
    

	//开始营业时间
	private String formtime;    
    

	//结束营业时间
	private String totime;    
    

	//所在市
	private String cityid;    
    

	//所在省编号
	private String provincecode;    
    

	//创建人
	private Long createuserid;    
    

	//门店电话
	private String tel;    
    

	//所在区域
	private String district;    
    

	//所在地
	private String abbrname;    
    

	//备注
	private String comment;    
    

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
	 * get门店编号
	 */
    public String getStorecode(){
         return storecode;
    }

	/**
	 * set门店编号
	 */
    public void setStorecode(String storecode){
         this.storecode=storecode;
    }

	/**
	 * get门店名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set门店名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get开始营业时间
	 */
    public String getFormtime(){
         return formtime;
    }

	/**
	 * set开始营业时间
	 */
    public void setFormtime(String formtime){
         this.formtime=formtime;
    }

	/**
	 * get结束营业时间
	 */
    public String getTotime(){
         return totime;
    }

	/**
	 * set结束营业时间
	 */
    public void setTotime(String totime){
         this.totime=totime;
    }

	/**
	 * get所在市
	 */
    public String getCityid(){
         return cityid;
    }

	/**
	 * set所在市
	 */
    public void setCityid(String cityid){
         this.cityid=cityid;
    }

	/**
	 * get所在省编号
	 */
    public String getProvincecode(){
         return provincecode;
    }

	/**
	 * set所在省编号
	 */
    public void setProvincecode(String provincecode){
         this.provincecode=provincecode;
    }

	/**
	 * get创建人
	 */
    public Long getCreateuserid(){
         return createuserid;
    }

	/**
	 * set创建人
	 */
    public void setCreateuserid(Long createuserid){
         this.createuserid=createuserid;
    }

	/**
	 * get门店电话
	 */
    public String getTel(){
         return tel;
    }

	/**
	 * set门店电话
	 */
    public void setTel(String tel){
         this.tel=tel;
    }

	/**
	 * get所在区域
	 */
    public String getDistrict(){
         return district;
    }

	/**
	 * set所在区域
	 */
    public void setDistrict(String district){
         this.district=district;
    }

	/**
	 * get所在地
	 */
    public String getAbbrname(){
         return abbrname;
    }

	/**
	 * set所在地
	 */
    public void setAbbrname(String abbrname){
         this.abbrname=abbrname;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + storecode +"|"
	   
	 + name +"|"
	   
	 + address +"|"
	   
	 + formtime +"|"
	   
	 + totime +"|"
	   
	 + cityid +"|"
	   
	 + provincecode +"|"
	   
	 + createuserid +"|"
	   
	 + tel +"|"
	   
	 + district +"|"
	   
	 + abbrname +"|"
	   
	 + comment
	 + "]";
 } 

}
