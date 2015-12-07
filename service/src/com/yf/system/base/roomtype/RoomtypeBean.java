/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.roomtype;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店房型
 */
public class RoomtypeBean implements java.io.Serializable{

	/**
	  *酒店房型 表名
	  */
	public static final String TABLE  = "T_ROOMTYPE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *面积描述 列名 
	  */
    public static final String COL_areadesc  = "C_AREADESC";
	
	/**
	  *房型描述 列名 
	  */
    public static final String COL_roomdesc  = "C_ROOMDESC";
	
	/**
	  *床型 列名 
	  */
    public static final String COL_bed  = "C_BED";
	
	/**
	  *房间设施 列名 
	  */
    public static final String COL_roomset  = "C_ROOMSET";
	
	/**
	  *房型状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *楼层 列名 
	  */
    public static final String COL_layer  = "C_LAYER";
	
	/**
	  *早餐 列名 
	  */
    public static final String COL_breakfast  = "C_BREAKFAST";
	
	/**
	  *宽带 列名 
	  */
    public static final String COL_wideband  = "C_WIDEBAND";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
    
    /**
	  *房型编码 列名 
	  */
   public static final String COL_roomcode  = "C_ROOMCODE";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//面积描述
	private String areadesc;    
    

	//房型描述
	private String roomdesc;    
    

	//床型
	private String bed;    
    

	//房间设施
	private String roomset;    
    

	//房型状态
	private Integer state;    
    

	//酒店ID
	private Long hotelid;    
    

	//楼层
	private String layer;    
    

	//早餐
	private String breakfast;    
    

	//宽带
	private String wideband;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;   
	
	//房型code
	private String roomcode;  
    

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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get面积描述
	 */
    public String getAreadesc(){
         return areadesc;
    }

	/**
	 * set面积描述
	 */
    public void setAreadesc(String areadesc){
         this.areadesc=areadesc;
    }

	/**
	 * get房型描述
	 */
    public String getRoomdesc(){
         return roomdesc;
    }

	/**
	 * set房型描述
	 */
    public void setRoomdesc(String roomdesc){
         this.roomdesc=roomdesc;
    }

	/**
	 * get床型
	 */
    public String getBed(){
         return bed;
    }

	/**
	 * set床型
	 */
    public void setBed(String bed){
         this.bed=bed;
    }

	/**
	 * get房间设施
	 */
    public String getRoomset(){
         return roomset;
    }

	/**
	 * set房间设施
	 */
    public void setRoomset(String roomset){
         this.roomset=roomset;
    }

	/**
	 * get房型状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set房型状态
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
	 * get楼层
	 */
    public String getLayer(){
         return layer;
    }

	/**
	 * set楼层
	 */
    public void setLayer(String layer){
         this.layer=layer;
    }

	/**
	 * get早餐
	 */
    public String getBreakfast(){
         return breakfast;
    }

	/**
	 * set早餐
	 */
    public void setBreakfast(String breakfast){
         this.breakfast=breakfast;
    }

	/**
	 * get宽带
	 */
    public String getWideband(){
         return wideband;
    }

	/**
	 * set宽带
	 */
    public void setWideband(String wideband){
         this.wideband=wideband;
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


	public String getRoomcode() {
		return roomcode;
	}

	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + areadesc +"|"
	   
	 + roomdesc +"|"
	   
	 + bed +"|"
	   
	 + roomset +"|"
	   
	 + state +"|"
	   
	 + hotelid +"|"
	   
	 + layer +"|"
	   
	 + breakfast +"|"
	   
	 + wideband +"|"
	   
	 + ucode +"|"
	 
	 + roomcode +"|"
	   
	 + language
	 + "]";
 } 

}
