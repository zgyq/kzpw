/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.ticketapp;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *特价申请表
 */
public class TicketappBean implements java.io.Serializable{

	/**
	  *特价申请表 表名
	  */
	public static final String TABLE  = "T_TICKETAPP";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出发地 列名 
	  */
    public static final String COL_sname  = "C_SNAME";
	
	/**
	  *到达地 列名 
	  */
    public static final String COL_endname  = "C_ENDNAME";
	
	/**
	  *出发时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *航空公司 列名 
	  */
    public static final String COL_copname  = "C_COPNAME";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_fnub  = "C_FNUB";
	
	/**
	  *舱位码 列名 
	  */
    public static final String COL_cnub  = "C_CNUB";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_pnumber  = "C_PNUMBER";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *联系人电话 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *联系人邮箱 列名 
	  */
    public static final String COL_memberemail  = "C_MEMBEREMAIL";
	
	/**
	  *身份证号码 列名 
	  */
    public static final String COL_cardnunber  = "C_CARDNUNBER";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//出发地
	private String sname;    
    

	//到达地
	private String endname;    
    

	//出发时间
	private String stime;    
    

	//航空公司
	private String copname;    
    

	//航班号
	private String fnub;    
    

	//舱位码
	private String cnub;    
    

	//人数
	private String pnumber;    
    

	//联系人姓名
	private String username;    
    

	//联系人电话
	private String mobile;    
    

	//联系人邮箱
	private String memberemail;    
    

	//身份证号码
	private String cardnunber;    
    

	//备注
	private String description;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get出发地
	 */
    public String getSname(){
         return sname;
    }

	/**
	 * set出发地
	 */
    public void setSname(String sname){
         this.sname=sname;
    }

	/**
	 * get到达地
	 */
    public String getEndname(){
         return endname;
    }

	/**
	 * set到达地
	 */
    public void setEndname(String endname){
         this.endname=endname;
    }

	/**
	 * get出发时间
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set出发时间
	 */
    public void setStime(String stime){
         this.stime=stime;
    }

	/**
	 * get航空公司
	 */
    public String getCopname(){
         return copname;
    }

	/**
	 * set航空公司
	 */
    public void setCopname(String copname){
         this.copname=copname;
    }

	/**
	 * get航班号
	 */
    public String getFnub(){
         return fnub;
    }

	/**
	 * set航班号
	 */
    public void setFnub(String fnub){
         this.fnub=fnub;
    }

	/**
	 * get舱位码
	 */
    public String getCnub(){
         return cnub;
    }

	/**
	 * set舱位码
	 */
    public void setCnub(String cnub){
         this.cnub=cnub;
    }

	/**
	 * get人数
	 */
    public String getPnumber(){
         return pnumber;
    }

	/**
	 * set人数
	 */
    public void setPnumber(String pnumber){
         this.pnumber=pnumber;
    }

	/**
	 * get联系人姓名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set联系人姓名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get联系人电话
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set联系人电话
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get联系人邮箱
	 */
    public String getMemberemail(){
         return memberemail;
    }

	/**
	 * set联系人邮箱
	 */
    public void setMemberemail(String memberemail){
         this.memberemail=memberemail;
    }

	/**
	 * get身份证号码
	 */
    public String getCardnunber(){
         return cardnunber;
    }

	/**
	 * set身份证号码
	 */
    public void setCardnunber(String cardnunber){
         this.cardnunber=cardnunber;
    }

	/**
	 * get备注
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set备注
	 */
    public void setDescription(String description){
         this.description=description;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + sname +"|"
	   
	 + endname +"|"
	   
	 + stime +"|"
	   
	 + copname +"|"
	   
	 + fnub +"|"
	   
	 + cnub +"|"
	   
	 + pnumber +"|"
	   
	 + username +"|"
	   
	 + mobile +"|"
	   
	 + memberemail +"|"
	   
	 + cardnunber +"|"
	   
	 + description +"|"
	   
	 + createtime
	 + "]";
 } 

}
