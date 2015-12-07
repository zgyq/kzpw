/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelspec;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店注意事项
 */
public class HotelspecBean implements java.io.Serializable{

	/**
	  *酒店注意事项 表名
	  */
	public static final String TABLE  = "C_HOTELSPEC";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
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
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
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
    

	//起始日期
	private Timestamp startdate;    
    

	//终止日期
	private Timestamp enddate;    
    

	//状态
	private Integer state;    
    

	//酒店ID
	private Long hotelid;    
    

	//描述
	private String description;    
    

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
	   
	 + startdate +"|"
	   
	 + enddate +"|"
	   
	 + state +"|"
	   
	 + hotelid +"|"
	   
	 + description +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
