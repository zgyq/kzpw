/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qqinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *QQ信息表
 */
public class QqinfoBean implements java.io.Serializable{

	/**
	  *QQ信息表 表名
	  */
	public static final String TABLE  = "T_QQINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *QQ号 列名 
	  */
    public static final String COL_qqnumber  = "C_QQNUMBER";
	
	/**
	  *QQ类型 列名 
	  */
    public static final String COL_qqtype  = "C_QQTYPE";
	
	/**
	  *QQ排序 列名 
	  */
    public static final String COL_qqnumberindex  = "C_QQNUMBERINDEX";

	//ID
	private long id;    
    

	//QQ号
	private String qqnumber;    
    

	//QQ类型
	private Long qqtype;    
	
	private String qqtypename;
	
	
    

	//QQ排序
	private Long qqnumberindex;    
    

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
	 * getQQ号
	 */
    public String getQqnumber(){
         return qqnumber;
    }
    
    

	/**
	 * setQQ号
	 */
    public void setQqnumber(String qqnumber){
         this.qqnumber=qqnumber;
    }

	/**
	 * getQQ类型
	 */
    public Long getQqtype(){
         return qqtype;
    }

	/**
	 * setQQ类型
	 */
    public void setQqtype(Long qqtype){
         this.qqtype=qqtype;
    }

	/**
	 * getQQ排序
	 */
    public Long getQqnumberindex(){
         return qqnumberindex;
    }

	/**
	 * setQQ排序
	 */
    public void setQqnumberindex(Long qqnumberindex){
         this.qqnumberindex=qqnumberindex;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + qqnumber +"|"
	   
	 + qqtype +"|"
	   
	 + qqnumberindex
	 + "]";
  }

	public String getQqtypename() {
		return qqtypename;
	}

	public void setQqtypename(String qqtypename) {
		this.qqtypename = qqtypename;
	}

}
