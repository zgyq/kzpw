/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.traincity;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *火车票城市
 */
public class TraincityBean implements java.io.Serializable{

	/**
	  *火车票城市 表名
	  */
	public static final String TABLE  = "T_TRAINCITY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名字 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *拼音 列名 
	  */
    public static final String COL_enname  = "C_ENNAME";
	
	/**
	  *备用1 列名 
	  */
    public static final String COL_back1  = "C_BACK1";
	
	/**
	  *备用2 列名 
	  */
    public static final String COL_back2  = "C_BACK2";
	
	/**
	  *备用3 列名 
	  */
    public static final String COL_back3  = "C_BACK3";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//名字
	private String name;    
    

	//拼音
	private String enname;    
    

	//备用1
	private String back1;    
    

	//备用2
	private String back2;    
    

	//备用3
	private String back3;    
    

	//状态
	private Long state;    
    

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
	 * get名字
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名字
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get拼音
	 */
    public String getEnname(){
         return enname;
    }

	/**
	 * set拼音
	 */
    public void setEnname(String enname){
         this.enname=enname;
    }

	/**
	 * get备用1
	 */
    public String getBack1(){
         return back1;
    }

	/**
	 * set备用1
	 */
    public void setBack1(String back1){
         this.back1=back1;
    }

	/**
	 * get备用2
	 */
    public String getBack2(){
         return back2;
    }

	/**
	 * set备用2
	 */
    public void setBack2(String back2){
         this.back2=back2;
    }

	/**
	 * get备用3
	 */
    public String getBack3(){
         return back3;
    }

	/**
	 * set备用3
	 */
    public void setBack3(String back3){
         this.back3=back3;
    }

	/**
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + enname +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + state
	 + "]";
 } 

}
