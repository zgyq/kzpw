/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.carbrand;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *汽车品牌
 */
public class CarbrandBean implements java.io.Serializable{

	/**
	  *汽车品牌 表名
	  */
	public static final String TABLE  = "T_CARBRAND";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *品牌编号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";

	//ID
	private long id;    
    

	//品牌编号
	private String code;    
    

	//名称
	private String name;    
    

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
	 * get品牌编号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set品牌编号
	 */
    public void setCode(String code){
         this.code=code;
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
	   
	 + code +"|"
	   
	 + name +"|"
	   
	 + comment
	 + "]";
 } 

}
