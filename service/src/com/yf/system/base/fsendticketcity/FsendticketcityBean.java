/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fsendticketcity;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票送票城市
 */
public class FsendticketcityBean implements java.io.Serializable{

	/**
	  *国际机票送票城市 表名
	  */
	public static final String TABLE  = "T_FSENDTICKETCITY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *送票城市三字码 列名 
	  */
    public static final String COL_stcitycode  = "C_STCITYCODE";
	
	/**
	  *送票城市名称 列名 
	  */
    public static final String COL_stcityname  = "C_STCITYNAME";
	
	/**
	  *送票城市英文名 列名 
	  */
    public static final String COL_stcitynameen  = "C_STCITYNAMEEN";
	
	/**
	  *UCODE 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语种 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//ID
	private long id;    
    

	//送票城市三字码
	private String stcitycode;    
    

	//送票城市名称
	private String stcityname;    
    

	//送票城市英文名
	private String stcitynameen;    
    

	//UCODE
	private Long ucode;    
    

	//语种
	private Integer language;    
    

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
	 * get送票城市三字码
	 */
    public String getStcitycode(){
         return stcitycode;
    }

	/**
	 * set送票城市三字码
	 */
    public void setStcitycode(String stcitycode){
         this.stcitycode=stcitycode;
    }

	/**
	 * get送票城市名称
	 */
    public String getStcityname(){
         return stcityname;
    }

	/**
	 * set送票城市名称
	 */
    public void setStcityname(String stcityname){
         this.stcityname=stcityname;
    }

	/**
	 * get送票城市英文名
	 */
    public String getStcitynameen(){
         return stcitynameen;
    }

	/**
	 * set送票城市英文名
	 */
    public void setStcitynameen(String stcitynameen){
         this.stcitynameen=stcitynameen;
    }

	/**
	 * getUCODE
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * setUCODE
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语种
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语种
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + stcitycode +"|"
	   
	 + stcityname +"|"
	   
	 + stcitynameen +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
