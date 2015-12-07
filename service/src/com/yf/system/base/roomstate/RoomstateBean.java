/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.roomstate;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店房态
 */
public class RoomstateBean implements java.io.Serializable{

	/**
	  *酒店房态 表名
	  */
	public static final String TABLE  = "T_ROOMSTATE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *房型ID 列名 
	  */
    public static final String COL_roomtypeid  = "C_ROOMTYPEID";
	
	/**
	  *起始日期 列名 
	  */
    public static final String COL_startdate  = "C_STARTDATE";
	
	/**
	  *终止日期 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *是否确认 列名 
	  */
    public static final String COL_confirmmethod  = "C_CONFIRMMETHOD";
	
	/**
	  *???算类别 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *数量 列名 
	  */
    public static final String COL_num  = "C_NUM";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
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
    

	//房型ID
	private Long roomtypeid;    
    

	//起始日期
	private Timestamp startdate;    
    

	//终止日期
	private Timestamp enddate;    
    

	//状态
	private Integer state;    
    

	//是否确认
	private Integer confirmmethod;    
    

	//???算类别
	private Integer type;    
    

	//数量
	private Integer num;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

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
	 * get房型ID
	 */
    public Long getRoomtypeid(){
         return roomtypeid;
    }

	/**
	 * set房型ID
	 */
    public void setRoomtypeid(Long roomtypeid){
         this.roomtypeid=roomtypeid;
    }

	/**
	 * get起始日期
	 */
    public Timestamp getStartdate(){
         return startdate;
    }

	/**
	 * set起始日期
	 */
    public void setStartdate(Timestamp startdate){
         this.startdate=startdate;
    }

	/**
	 * get终止日期
	 */
    public Timestamp getEnddate(){
         return enddate;
    }

	/**
	 * set终止日期
	 */
    public void setEnddate(Timestamp enddate){
         this.enddate=enddate;
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
	 * get是否确认
	 */
    public Integer getConfirmmethod(){
         return confirmmethod;
    }

	/**
	 * set是否确认
	 */
    public void setConfirmmethod(Integer confirmmethod){
         this.confirmmethod=confirmmethod;
    }

	/**
	 * get???算类别
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set???算类别
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get数量
	 */
    public Integer getNum(){
         return num;
    }

	/**
	 * set数量
	 */
    public void setNum(Integer num){
         this.num=num;
    }

	/**
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
	 */
    public void setCreateuser(String createuser){
         this.createuser=createuser;
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
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
	 */
    public void setModifyuser(String modifyuser){
         this.modifyuser=modifyuser;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getModifytime(){
         return modifytime;
    }

	/**
	 * set修改时间
	 */
    public void setModifytime(Timestamp modifytime){
         this.modifytime=modifytime;
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
	   
	 + roomtypeid +"|"
	   
	 + startdate +"|"
	   
	 + enddate +"|"
	   
	 + state +"|"
	   
	 + confirmmethod +"|"
	   
	 + type +"|"
	   
	 + num +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
