/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.orderinforc;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *订单处理记录
 */
public class OrderinforcBean implements java.io.Serializable{

	/**
	  *订单处理记录 表名
	  */
	public static final String TABLE  = "T_ORDERINFORC";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderinfoid  = "C_ORDERINFOID";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_customeruserid  = "C_CUSTOMERUSERID";
	
	/**
	  *处理结果 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
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
    
	/**
	  *上个锁单会员ID 列名 
	  */
   public static final String COL_suouserid  = "C_SUOUSERID";
   
	/**
	  * 乘机人ID 列名 
	  */
   public static final String COL_passid  = "C_PASSID";
   
   /**
    * 前一订单状态
    */
   public static final String COL_prestate="C_PRESTATE";

	//ID
	private long id;    
    

	//订单ID
	private Long orderinfoid;    
    

	//会员ID
	private Long customeruserid;    
    

	//处理结果
	private String content;    
    

	//创建时间
	private Timestamp createtime;    
    

	//状态
	private Integer state;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language; 
	
	//上个锁单会员ID
	private Long suouserid;  
	
	//乘机人ID
	private Long passid; 
	
	//前一订单状态
	private Integer prestate;

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
    public Long getOrderinfoid(){
         return orderinfoid;
    }

	/**
	 * set订单ID
	 */
    public void setOrderinfoid(Long orderinfoid){
         this.orderinfoid=orderinfoid;
    }

	/**
	 * get会员ID
	 */
    public Long getCustomeruserid(){
         return customeruserid;
    }

	/**
	 * set会员ID
	 */
    public void setCustomeruserid(Long customeruserid){
         this.customeruserid=customeruserid;
    }

	/**
	 * get处理结果
	 */
    public String getContent(){
         return content;
    }

	/**
	 * set处理结果
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
	 * get状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态
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
	   
	 + orderinfoid +"|"
	   
	 + customeruserid +"|"
	   
	 + content +"|"
	   
	 + createtime +"|"
	   
	 + state +"|"
	   
	 + ucode +"|"
	 
	 + suouserid +"|"
	 
	 + passid +"|"
	   
	 + language
	 + "]";
 }

	public Long getSuouserid() {
		return suouserid;
	}

	public void setSuouserid(Long suouserid) {
		this.suouserid = suouserid;
	}

	public Long getPassid() {
		return passid;
	}

	public void setPassid(Long passid) {
		this.passid = passid;
	}

	public Integer getPrestate() {
		return prestate;
	}

	public void setPrestate(Integer prestate) {
		this.prestate = prestate;
	} 

}
