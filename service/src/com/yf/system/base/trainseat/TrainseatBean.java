/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.trainseat;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *火车席别
 */
public class TrainseatBean implements java.io.Serializable{

	/**
	  *火车席别 表名
	  */
	public static final String TABLE  = "T_TRAINSEAT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *席别代码 列名 
	  */
    public static final String COL_seat_code  = "C_SEAT_CODE";
	
	/**
	  *席别名称 列名 
	  */
    public static final String COL_seat_name  = "C_SEAT_NAME";
	
	/**
	  *12306代码 列名 
	  */
    public static final String COL_code_12306  = "C_CODE_12306";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_mem  = "C_MEM";
	
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
    

	//席别代码
	private String seat_code;    
    

	//席别名称
	private String seat_name;    
    

	//12306代码
	private String code_12306;    
    

	//备注
	private String mem;    
    

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
	 * get席别代码
	 */
    public String getSeat_code(){
         return seat_code;
    }

	/**
	 * set席别代码
	 */
    public void setSeat_code(String seat_code){
         this.seat_code=seat_code;
    }

	/**
	 * get席别名称
	 */
    public String getSeat_name(){
         return seat_name;
    }

	/**
	 * set席别名称
	 */
    public void setSeat_name(String seat_name){
         this.seat_name=seat_name;
    }

	/**
	 * get12306代码
	 */
    public String getCode_12306(){
         return code_12306;
    }

	/**
	 * set12306代码
	 */
    public void setCode_12306(String code_12306){
         this.code_12306=code_12306;
    }

	/**
	 * get备注
	 */
    public String getMem(){
         return mem;
    }

	/**
	 * set备注
	 */
    public void setMem(String mem){
         this.mem=mem;
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
	   
	 + seat_code +"|"
	   
	 + seat_name +"|"
	   
	 + code_12306 +"|"
	   
	 + mem +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + state
	 + "]";
 } 

}
