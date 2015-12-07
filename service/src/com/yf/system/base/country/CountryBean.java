/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.country;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国家表
 */
public class CountryBean implements java.io.Serializable{

	/**
	  *国家表 表名
	  */
	public static final String TABLE  = "T_COUNTRY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名字 列名 
	  */
    public static final String COL_name  = "C_NAME";
    
    /**
	  *中文名字 列名 
	  */
   public static final String COL_zhname  = "C_ZHNAME";
	
	/**
	  *所属洲 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
	/**
	  *编码(alpha-3) 列名 
	  */
    public static final String COL_code3  = "C_CODE3";
	
	/**
	  *编码(alpha-2) 列名 
	  */
    public static final String COL_code2  = "C_CODE2";
	
	/**
	  *FIPS 列名 
	  */
    public static final String COL_fips  = "C_FIPS";
	
	/**
	  *UN 列名 
	  */
    public static final String COL_un  = "C_UN";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";

	//ID
	private long id;    
    

	//名字
	private String name;    
    
	

	//中文名字
	private String zhname;  
	
	

	//所属洲
	private String desc;    
    

	//编码(alpha-3)
	private String code3;    
    

	//编码(alpha-2)
	private String code2;    
    

	//FIPS
	private String fips;    
    

	//UN
	private String un;    
    

	//创建时间
	private Timestamp createtime;    
    

	//类型
	private Long type;    
    

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
	 * get所属洲
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set所属洲
	 */
    public void setDesc(String desc){
         this.desc=desc;
    }

	/**
	 * get编码(alpha-3)
	 */
    public String getCode3(){
         return code3;
    }

	/**
	 * set编码(alpha-3)
	 */
    public void setCode3(String code3){
         this.code3=code3;
    }

	/**
	 * get编码(alpha-2)
	 */
    public String getCode2(){
         return code2;
    }

	/**
	 * set编码(alpha-2)
	 */
    public void setCode2(String code2){
         this.code2=code2;
    }

	/**
	 * getFIPS
	 */
    public String getFips(){
         return fips;
    }

	/**
	 * setFIPS
	 */
    public void setFips(String fips){
         this.fips=fips;
    }

	/**
	 * getUN
	 */
    public String getUn(){
         return un;
    }

	/**
	 * setUN
	 */
    public void setUn(String un){
         this.un=un;
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
	 * get类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Long type){
         this.type=type;
    }


	public String getZhname() {
		return zhname;
	}

	public void setZhname(String zhname) {
		this.zhname = zhname;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	 
	 + zhname +"|"
	   
	 + desc +"|"
	   
	 + code3 +"|"
	   
	 + code2 +"|"
	   
	 + fips +"|"
	   
	 + un +"|"
	   
	 + createtime +"|"
	   
	 + type
	 + "]";
 } 

}
