/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.ymsend;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *短信发送表
 */
public class YmsendBean implements java.io.Serializable{

	/**
	  *短信发送表 表名
	  */
	public static final String TABLE  = "T_YMSEND";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *手机号码 列名 
	  */
    public static final String COL_phone  = "C_PHONE";
	
	/**
	  *短信内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
    
    
    /**
     * 类型  1：定制，2：非定制
     */
    public static final String COL_type ="C_TYPE";
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *订单编码 列名 
	  */
    public static final String COL_ordercode  = "C_ORDERCODE";

	//ID
	private long id;    
    

	//手机号码
	private String phone;    
    

	//短信内容
	private String content;    
    

	//状态
	private Long state;    
	
	private Integer type;
    

	//创建时间
	private Timestamp createtime;    
    

	//描述
	private String description;    
    

	//订单编码
	private String ordercode;    
    

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
	 * get手机号码
	 */
    public String getPhone(){
         return phone;
    }

	/**
	 * set手机号码
	 */
    public void setPhone(String phone){
         this.phone=phone;
    }

	/**
	 * get短信内容
	 */
    public String getContent(){
         return content;
    }

	/**
	 * set短信内容
	 */
    public void setContent(String content){
         this.content=content;
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
	 * get描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set描述
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get订单编码
	 */
    public String getOrdercode(){
         return ordercode;
    }

	/**
	 * set订单编码
	 */
    public void setOrdercode(String ordercode){
         this.ordercode=ordercode;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + phone +"|"
	   
	 + content +"|"
	   
	 + state +"|"
	   
	 + createtime +"|"
	   
	 + description +"|"
	   
	 + ordercode
	 + "]";
 }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	} 

}
