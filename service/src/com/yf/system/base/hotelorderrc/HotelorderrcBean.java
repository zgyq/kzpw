/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelorderrc;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店订单状态日志
 */
public class HotelorderrcBean implements java.io.Serializable{

	/**
	  *酒店订单状态日志 表名
	  */
	public static final String TABLE  = "T_HOTELORDERRC";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *操作人 列名 
	  */
    public static final String COL_handleuser  = "C_HANDLEUSER";
	
	/**
	  *操作内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *联系电话 列名 
	  */
    public static final String COL_linktell  = "C_LINKTELL";
	
	/**
	  *相关状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//ID
	private long id;    
    

	//订单ID
	private Long orderid;    
    

	//操作人
	private String handleuser;    
    

	//操作内容
	private String content;    
    

	//创建时间
	private Timestamp createtime;    
    

	//描述
	private String description;    
    

	//联系电话
	private String linktell;    
    

	//相关状态
	private Integer state;    
    

	//父编号
	private Long ucode;    
    

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
	 * get订单ID
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set订单ID
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get操作人
	 */
    public String getHandleuser(){
         return handleuser;
    }

	/**
	 * set操作人
	 */
    public void setHandleuser(String handleuser){
         this.handleuser=handleuser;
    }

	/**
	 * get操作内容
	 */
    public String getContent(){
         return content;
    }

	/**
	 * set操作内容
	 */
    public void setContent(String content){
         this.content=content;
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
	 * get联系电话
	 */
    public String getLinktell(){
         return linktell;
    }

	/**
	 * set联系电话
	 */
    public void setLinktell(String linktell){
         this.linktell=linktell;
    }

	/**
	 * get相关状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set相关状态
	 */
    public void setState(Integer state){
         this.state=state;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + handleuser +"|"
	   
	 + content +"|"
	   
	 + createtime +"|"
	   
	 + description +"|"
	   
	 + linktell +"|"
	   
	 + state +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
