/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.ticketnumber;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *机票票号
 */
public class TicketnumberBean implements java.io.Serializable{

	/**
	  *机票票号 表名
	  */
	public static final String TABLE  = "T_TICKETNUMBER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *机票类型ID 列名 
	  */
    public static final String COL_tickettypeid  = "C_TICKETTYPEID";
	
	/**
	  *开始票号 列名 
	  */
    public static final String COL_beginnumber  = "C_BEGINNUMBER";
	
	/**
	  *结束票号 列名 
	  */
    public static final String COL_endnumber  = "C_ENDNUMBER";
	
	/**
	  *票号备注 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";

	//ID
	private long id;    
    

	//机票类型ID
	private Long tickettypeid;    
    

	//开始票号
	private String beginnumber;    
    

	//结束票号
	private String endnumber;    
    

	//票号备注
	private String description;    
    

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
	 * get机票类型ID
	 */
    public Long getTickettypeid(){
         return tickettypeid;
    }

	/**
	 * set机票类型ID
	 */
    public void setTickettypeid(Long tickettypeid){
         this.tickettypeid=tickettypeid;
    }

	/**
	 * get开始票号
	 */
    public String getBeginnumber(){
         return beginnumber;
    }

	/**
	 * set开始票号
	 */
    public void setBeginnumber(String beginnumber){
         this.beginnumber=beginnumber;
    }

	/**
	 * get结束票号
	 */
    public String getEndnumber(){
         return endnumber;
    }

	/**
	 * set结束票号
	 */
    public void setEndnumber(String endnumber){
         this.endnumber=endnumber;
    }

	/**
	 * get票号备注
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set票号备注
	 */
    public void setDescription(String description){
         this.description=description;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + tickettypeid +"|"
	   
	 + beginnumber +"|"
	   
	 + endnumber +"|"
	   
	 + description
	 + "]";
 } 

}
