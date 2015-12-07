/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelfan;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店设置返点表
 */
public class HotelfanBean implements java.io.Serializable{

	/**
	  *酒店设置返点表 表名
	  */
	public static final String TABLE  = "T_HOTELFAN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *开始时间 列名 
	  */
    public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";
	
	/**
	  *起始价 列名 
	  */
    public static final String COL_startprice  = "C_STARTPRICE";
	
	/**
	  *结束价 列名 
	  */
    public static final String COL_endprice  = "C_ENDPRICE";
	
	/**
	  *返点值 列名 
	  */
    public static final String COL_fan  = "C_FAN";
	
	/**
	  *是否可以使用优惠券 列名 
	  */
    public static final String COL_ifvoucher  = "C_IFVOUCHER";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";

	//ID
	private long id;    
    

	//创建时间
	private Timestamp createtime;    
    

	//开始时间
	private Timestamp starttime;    
    

	//结束时间
	private Timestamp endtime;    
    

	//起始价
	private Double startprice;    
    

	//结束价
	private Double endprice;    
    

	//返点值
	private String fan;    
    

	//是否可以使用优惠券
	private Long ifvoucher;    
    

	//酒店ID
	private Long hotelid;    
    

	//创建人id
	private Long memberid;    
    

	//状态
	private Integer status;    
    

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
	 * get开始时间
	 */
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set开始时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
    }

	/**
	 * get结束时间
	 */
    public Timestamp getEndtime(){
         return endtime;
    }

	/**
	 * set结束时间
	 */
    public void setEndtime(Timestamp endtime){
         this.endtime=endtime;
    }

	/**
	 * get起始价
	 */
    public Double getStartprice(){
         return startprice;
    }

	/**
	 * set起始价
	 */
    public void setStartprice(Double startprice){
         this.startprice=startprice;
    }

	/**
	 * get结束价
	 */
    public Double getEndprice(){
         return endprice;
    }

	/**
	 * set结束价
	 */
    public void setEndprice(Double endprice){
         this.endprice=endprice;
    }

	/**
	 * get返点值
	 */
    public String getFan(){
         return fan;
    }

	/**
	 * set返点值
	 */
    public void setFan(String fan){
         this.fan=fan;
    }

	/**
	 * get是否可以使用优惠券
	 */
    public Long getIfvoucher(){
         return ifvoucher;
    }

	/**
	 * set是否可以使用优惠券
	 */
    public void setIfvoucher(Long ifvoucher){
         this.ifvoucher=ifvoucher;
    }

	/**
	 * get酒店ID
	 */
    public Long getHotelid(){
         return hotelid;
    }

	/**
	 * set酒店ID
	 */
    public void setHotelid(Long hotelid){
         this.hotelid=hotelid;
    }

	/**
	 * get创建人id
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set创建人id
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
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
	 + id +"|"
	   
	 + createtime +"|"
	   
	 + starttime +"|"
	   
	 + endtime +"|"
	   
	 + startprice +"|"
	   
	 + endprice +"|"
	   
	 + fan +"|"
	   
	 + ifvoucher +"|"
	   
	 + hotelid +"|"
	   
	 + memberid +"|"
	   
	 + status
	 + "]";
 } 

}
