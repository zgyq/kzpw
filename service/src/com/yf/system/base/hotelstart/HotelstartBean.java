/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelstart;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店星级返利
 */
public class HotelstartBean implements java.io.Serializable{

	/**
	  *酒店星级返利 表名
	  */
	public static final String TABLE  = "T_HOTELSTART";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  * 星级 列名 
	  */
    public static final String COL_hotestart  = "C_HOTESTART";
	
	/**
	  *星级编码 列名 
	  */
    public static final String COL_startcode  = "C_STARTCODE";
	
	/**
	  *返利 列名 
	  */
    public static final String COL_margin  = "C_MARGIN";
	
	/**
	  *数据提供商id 列名 
	  */
    public static final String COL_dataprovideid  = "C_DATAPROVIDEID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_createmanid  = "C_CREATEMANID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/** 
	  *备注 列名 
	  */
    public static final String COL_remark  = "C_REMARK";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";

	//ID
	private long id;    
    

	// 星级
	private String hotestart;    
    

	//星级编码
	private String startcode;    
    

	//返利
	private String margin;    
    

	//数据提供商id
	private Long dataprovideid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
	private Long createmanid;    
    

	//状态
	private Long state;    
    

	//备注
	private String remark;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

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
	 * get 星级
	 */
    public String getHotestart(){
         return hotestart;
    }

	/**
	 * set 星级
	 */
    public void setHotestart(String hotestart){
         this.hotestart=hotestart;
    }

	/**
	 * get星级编码
	 */
    public String getStartcode(){
         return startcode;
    }

	/**
	 * set星级编码
	 */
    public void setStartcode(String startcode){
         this.startcode=startcode;
    }

	/**
	 * get返利
	 */
    public String getMargin(){
         return margin;
    }

	/**
	 * set返利
	 */
    public void setMargin(String margin){
         this.margin=margin;
    }

	/**
	 * get数据提供商id
	 */
    public Long getDataprovideid(){
         return dataprovideid;
    }

	/**
	 * set数据提供商id
	 */
    public void setDataprovideid(Long dataprovideid){
         this.dataprovideid=dataprovideid;
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
	 * get创建人id
	 */
    public Long getCreatemanid(){
         return createmanid;
    }

	/**
	 * set创建人id
	 */
    public void setCreatemanid(Long createmanid){
         this.createmanid=createmanid;
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
	 * get备注
	 */
    public String getRemark(){
         return remark;
    }

	/**
	 * set备注
	 */
    public void setRemark(String remark){
         this.remark=remark;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + hotestart +"|"
	   
	 + startcode +"|"
	   
	 + margin +"|"
	   
	 + dataprovideid +"|"
	   
	 + createtime +"|"
	   
	 + createmanid +"|"
	   
	 + state +"|"
	   
	 + remark +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
