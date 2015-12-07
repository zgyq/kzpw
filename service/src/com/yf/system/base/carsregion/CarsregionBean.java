/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.carsregion;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *送车上门区域
 */
public class CarsregionBean implements java.io.Serializable{

	/**
	  *送车上门区域 表名
	  */
	public static final String TABLE  = "T_CARSREGION";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
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
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//所在市
	private Long cityid;    
    

	//所在省编号
	private String provincecode;    
    

	//创建人
	private Long createuserid;    
    

	//价格
	private String price;    
    

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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get所在市
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set所在市
	 */
    public void setCityid(Long cityid){
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
	 * get价格
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(String price){
         this.price=price;
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
	   
	 + name +"|"
	   
	 + cityid +"|"
	   
	 + provincecode +"|"
	   
	 + createuserid +"|"
	   
	 + price +"|"
	   
	 + comment
	 + "]";
 } 

}
