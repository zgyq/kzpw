/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelstar;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店星级返点对应表
 */
public class HotelstarBean implements java.io.Serializable{

	/**
	  *酒店星级返点对应表 表名
	  */
	public static final String TABLE  = "T_HOTELSTAR";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *星级ID 列名 
	  */
    public static final String COL_starid  = "C_STARID";
	
	/**
	  *星级名称 列名 
	  */
    public static final String COL_starname  = "C_STARNAME";
	
	/**
	  *返点值 列名 
	  */
    public static final String COL_val  = "C_VAL";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuserid  = "C_CREATEUSERID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//星级ID
	private String starid;    
    

	//星级名称
	private String starname;    
    

	//返点值
	private Double val;    
    

	//创建人
	private Long createuserid;    
    

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
	 * get星级ID
	 */
    public String getStarid(){
         return starid;
    }

	/**
	 * set星级ID
	 */
    public void setStarid(String starid){
         this.starid=starid;
    }

	/**
	 * get星级名称
	 */
    public String getStarname(){
         return starname;
    }

	/**
	 * set星级名称
	 */
    public void setStarname(String starname){
         this.starname=starname;
    }

	/**
	 * get返点值
	 */
    public Double getVal(){
         return val;
    }

	/**
	 * set返点值
	 */
    public void setVal(Double val){
         this.val=val;
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
	   
	 + starid +"|"
	   
	 + starname +"|"
	   
	 + val +"|"
	   
	 + createuserid +"|"
	   
	 + comment
	 + "]";
 } 

}
