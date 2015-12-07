/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.conferencehall;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *会议厅
 */
public class ConferencehallBean implements java.io.Serializable{

	/**
	  *会议厅 表名
	  */
	public static final String TABLE  = "T_CONFERENCEHALL";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *面积 列名 
	  */
    public static final String COL_area  = "C_AREA";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_pepnum  = "C_PEPNUM";
	
	/**
	  *使用范围 列名 
	  */
    public static final String COL_useof  = "C_USEOF";
	
	/**
	  *简介 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
	/**
	  *会议酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_pic  = "C_PIC";

	//ID
	private long id;    
    

	//类型
	private String type;    
    

	//面积
	private String area;    
    

	//人数
	private String pepnum;    
    

	//使用范围
	private String useof;    
    

	//简介
	private String desc;    
    

	//会议酒店ID
	private Long hotelid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建者
	private String createuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//修改者
	private String modifyuser;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//图片
	private String pic;    
    

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
	 * get类型
	 */
    public String getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(String type){
         this.type=type;
    }

	/**
	 * get面积
	 */
    public String getArea(){
         return area;
    }

	/**
	 * set面积
	 */
    public void setArea(String area){
         this.area=area;
    }

	/**
	 * get人数
	 */
    public String getPepnum(){
         return pepnum;
    }

	/**
	 * set人数
	 */
    public void setPepnum(String pepnum){
         this.pepnum=pepnum;
    }

	/**
	 * get使用范围
	 */
    public String getUseof(){
         return useof;
    }

	/**
	 * set使用范围
	 */
    public void setUseof(String useof){
         this.useof=useof;
    }

	/**
	 * get简介
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set简介
	 */
    public void setDesc(String desc){
         this.desc=desc;
    }

	/**
	 * get会议酒店ID
	 */
    public Long getHotelid(){
         return hotelid;
    }

	/**
	 * set会议酒店ID
	 */
    public void setHotelid(Long hotelid){
         this.hotelid=hotelid;
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

	/**
	 * get图片
	 */
    public String getPic(){
         return pic;
    }

	/**
	 * set图片
	 */
    public void setPic(String pic){
         this.pic=pic;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + type +"|"
	   
	 + area +"|"
	   
	 + pepnum +"|"
	   
	 + useof +"|"
	   
	 + desc +"|"
	   
	 + hotelid +"|"
	   
	 + createtime +"|"
	   
	 + createuser +"|"
	   
	 + modifytime +"|"
	   
	 + modifyuser +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + pic
	 + "]";
 } 

}
