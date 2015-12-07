/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.carimages;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *汽车图片
 */
public class CarimagesBean implements java.io.Serializable{

	/**
	  *汽车图片 表名
	  */
	public static final String TABLE  = "T_CARIMAGES";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *图片名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *图片路径 列名 
	  */
    public static final String COL_carurl  = "C_CARURL";
	
	/**
	  *图片概述 列名 
	  */
    public static final String COL_cardesc  = "C_CARDESC";
	
	/**
	  *汽车ID 列名 
	  */
    public static final String COL_carid  = "C_CARID";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//图片名称
	private String name;    
    

	//图片路径
	private String carurl;    
    

	//图片概述
	private String cardesc;    
    

	//汽车ID
	private Long carid;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get图片名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set图片名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get图片路径
	 */
    public String getCarurl(){
         return carurl;
    }

	/**
	 * set图片路径
	 */
    public void setCarurl(String carurl){
         this.carurl=carurl;
    }

	/**
	 * get图片概述
	 */
    public String getCardesc(){
         return cardesc;
    }

	/**
	 * set图片概述
	 */
    public void setCardesc(String cardesc){
         this.cardesc=cardesc;
    }

	

	public Long getCarid() {
		return carid;
	}

	public void setCarid(Long carid) {
		this.carid = carid;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + carurl +"|"
	   
	 + cardesc +"|"
	   
	 + carid +"|"
	   
	 + createuser +"|"
	   
	 + createtime
	 + "]";
 } 

}
