/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.teamapply;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *团队申请表
 */
public class TeamapplyBean implements java.io.Serializable{

	/**
	  *团队申请表 表名
	  */
	public static final String TABLE  = "T_TEAMAPPLY";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *所属加盟商ID 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
	
	/**
	  *航班类型 列名 
	  */
    public static final String COL_flighttype  = "C_FLIGHTTYPE";
	
	/**
	  *乘客类型 列名 
	  */
    public static final String COL_usertype  = "C_USERTYPE";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *到达城市 列名 
	  */
    public static final String COL_endcity  = "C_ENDCITY";
	
	/**
	  *乘机人数 列名 
	  */
    public static final String COL_numberpeople  = "C_NUMBERPEOPLE";
	
	/**
	  *航空公司 列名 
	  */
    public static final String COL_ca  = "C_CA";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *出发时间 列名 
	  */
    public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";
    
    /**
	  *成人 列名 
	  */
  public static final String COL_chenren  = "C_CHENGREN";
  /**
	  *儿童 列名 
	  */
 public static final String COL_ertong  = "C_UERTONG";
 /**
	  *婴儿 列名 
	  */
public static final String COL_yinger  = "C_YINGER";

	//ID
	private long id;    
    

	//所属加盟商ID
	private Long typeid;    
    

	//航班类型
	private Long flighttype;    
    

	//乘客类型
	private Long usertype;    
    

	//出发城市
	private String startcity;    
    

	//到达城市
	private String endcity;    
    

	//乘机人数
	private Long numberpeople;    
    

	//航空公司
	private String ca;    
    

	//航班号
	private String flightnumber;    
    

	//出发时间
	private Timestamp starttime;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//状态
	private Long status;    
    

	//备注
	private String comment;    
    
	//成人
	private Long chengren;   
	
	//儿童
	private Long ertong;   
	
	//婴儿
	private Long yinger;  
	
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
	 * get所属加盟商ID
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set所属加盟商ID
	 */
    public void setTypeid(Long typeid){
         this.typeid=typeid;
    }

	/**
	 * get航班类型
	 */
    public Long getFlighttype(){
         return flighttype;
    }

	/**
	 * set航班类型
	 */
    public void setFlighttype(Long flighttype){
         this.flighttype=flighttype;
    }

	/**
	 * get乘客类型
	 */
    public Long getUsertype(){
         return usertype;
    }

	/**
	 * set乘客类型
	 */
    public void setUsertype(Long usertype){
         this.usertype=usertype;
    }




	public String getStartcity() {
		return startcity;
	}

	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}

	public String getEndcity() {
		return endcity;
	}

	public void setEndcity(String endcity) {
		this.endcity = endcity;
	}

	/**
	 * get乘机人数
	 */
    public Long getNumberpeople(){
         return numberpeople;
    }

	/**
	 * set乘机人数
	 */
    public void setNumberpeople(Long numberpeople){
         this.numberpeople=numberpeople;
    }

	/**
	 * get航空公司
	 */
    public String getCa(){
         return ca;
    }

	/**
	 * set航空公司
	 */
    public void setCa(String ca){
         this.ca=ca;
    }

	/**
	 * get航班号
	 */
    public String getFlightnumber(){
         return flightnumber;
    }

	/**
	 * set航班号
	 */
    public void setFlightnumber(String flightnumber){
         this.flightnumber=flightnumber;
    }

	/**
	 * get出发时间
	 */
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set出发时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
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
	 * get状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Long status){
         this.status=status;
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
	   
	 + typeid +"|"
	   
	 + flighttype +"|"
	   
	 + usertype +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + numberpeople +"|"
	   
	 + ca +"|"
	   
	 + flightnumber +"|"
	   
	 + starttime +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + status +"|"
	   
	 + chengren +"|"
	 
	 + ertong +"|"
	 
	 + yinger +"|"
	 
	 + comment
	 + "]";
 }

	public Long getChengren() {
		return chengren;
	}

	public void setChengren(Long chengren) {
		this.chengren = chengren;
	}

	public Long getErtong() {
		return ertong;
	}

	public void setErtong(Long ertong) {
		this.ertong = ertong;
	}

	public Long getYinger() {
		return yinger;
	}

	public void setYinger(Long yinger) {
		this.yinger = yinger;
	} 

}
