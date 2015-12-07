/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.province;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *省份
 */
public class ProvinceBean implements java.io.Serializable{

	/**
	  *省份 表名
	  */
	public static final String TABLE  = "T_PROVINCE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *英文全拼 列名 
	  */
    public static final String COL_enname  = "C_ENNAME";
	
	/**
	  *省份代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
    
	/**
	  *类型 列名 
	  */
   public static final String COL_type  = "C_TYPE";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//英文全拼
	private String enname;    
    

	//省份代码
	private String code;    
    

	//父编号
	private Long ucode;    
    

	//类型
	private Integer type;   //1.酒店  2.租车
	
	//语言类型
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
	 * get英文全拼
	 */
    public String getEnname(){
         return enname;
    }

	/**
	 * set英文全拼
	 */
    public void setEnname(String enname){
         this.enname=enname;
    }

	/**
	 * get省份代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set省份代码
	 */
    public void setCode(String code){
         this.code=code;
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


	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + enname +"|"
	   
	 + code +"|"
	   
	 + ucode +"|"
	 
	 + type +"|"
	   
	 + language
	 + "]";
 } 

}
