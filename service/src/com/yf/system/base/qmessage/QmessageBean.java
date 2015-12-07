/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qmessage;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *Q信箱
 */
public class QmessageBean implements java.io.Serializable{

	/**
	  *Q信箱 表名
	  */
	public static final String TABLE  = "T_QMESSAGE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_ID  = "ID";
	
	/**
	  *消息内容 列名 
	  */
    public static final String COL_message  = "C_MESSAGE";
	
	/**
	  *时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
    
    /**
     * 创建人
     */
    public static final String COL_createuser="C_CREATEUSER";
    
    /**
     * 处理时间
     */
    public static final String COL_dealtime="C_DEALTIME";

	//ID
	private long ID;    
    

	//消息内容
	private String message;    
    

	//时间
	private Timestamp createtime;    
    

	//状态
	private Integer status; 
	
	private String createuser;
	
	private Timestamp dealtime;
    

	/**
	 * getID
	 */
    public long getId(){
         return ID;
    }

	/**
	 * setID
	 */
    public void setId(long ID){
         this.ID=ID;
    }

	/**
	 * get消息内容
	 */
    public String getMessage(){
         return message;
    }

	/**
	 * set消息内容
	 */
    public void setMessage(String message){
         this.message=message;
    }

	/**
	 * get时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get状态
	 */
    public Integer getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Integer status){
         this.status=status;
    }


	public String toString(){

	return "[" 
	 + ID +"|"
	   
	 + message +"|"
	   
	 + createtime +"|"
	 
	 + status +"|"
	 
	 + createuser +"|"
	 
	 + dealtime +"|"
	 
	 + "]";
 }

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Timestamp getDealtime() {
		return dealtime;
	}

	public void setDealtime(Timestamp dealtime) {
		this.dealtime = dealtime;
	} 

}
