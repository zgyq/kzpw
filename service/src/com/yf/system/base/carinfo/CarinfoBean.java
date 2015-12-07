/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.carinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *车型数据
 */
public class CarinfoBean implements java.io.Serializable{

	/**
	  *车型数据 表名
	  */
	public static final String TABLE  = "T_CARINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *车型名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *车型编号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *车辆品牌ID 列名 
	  */
    public static final String COL_brandcode  = "C_BRANDCODE";
	
	/**
	  *厢数 列名 
	  */
    public static final String COL_carriage  = "C_CARRIAGE";
	
	/**
	  *排量 列名 
	  */
    public static final String COL_deliverycapacity  = "C_DELIVERYCAPACITY";
	
	/**
	  *油箱容量 列名 
	  */
    public static final String COL_oilvolume  = "C_OILVOLUME";
	
	/**
	  *座位数 列名 
	  */
    public static final String COL_seatingcount  = "C_SEATINGCOUNT";
	
	/**
	  *变速器类型 列名 
	  */
    public static final String COL_gear  = "C_GEAR";
	
	/**
	  *图片路径 列名 
	  */
    public static final String COL_imageurl  = "C_IMAGEURL";

	//ID
	private long id;    
    

	//车型名称
	private String name;    
    

	//车型编号
	private String code;    
    

	//车辆品牌ID
	private String brandcode;    
    

	//厢数
	private String carriage;    
    

	//排量
	private String deliverycapacity;    
    

	//油箱容量
	private String oilvolume;    
    

	//座位数
	private String seatingcount;    
    

	//变速器类型
	private String gear;    
    

	//图片路径
	private String imageurl;    
    

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
	 * get车型名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set车型名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get车型编号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set车型编号
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get车辆品牌ID
	 */
    public String getBrandcode(){
         return brandcode;
    }

	/**
	 * set车辆品牌ID
	 */
    public void setBrandcode(String brandcode){
         this.brandcode=brandcode;
    }

	/**
	 * get厢数
	 */
    public String getCarriage(){
         return carriage;
    }

	/**
	 * set厢数
	 */
    public void setCarriage(String carriage){
         this.carriage=carriage;
    }

	/**
	 * get排量
	 */
    public String getDeliverycapacity(){
         return deliverycapacity;
    }

	/**
	 * set排量
	 */
    public void setDeliverycapacity(String deliverycapacity){
         this.deliverycapacity=deliverycapacity;
    }

	/**
	 * get油箱容量
	 */
    public String getOilvolume(){
         return oilvolume;
    }

	/**
	 * set油箱容量
	 */
    public void setOilvolume(String oilvolume){
         this.oilvolume=oilvolume;
    }

	/**
	 * get座位数
	 */
    public String getSeatingcount(){
         return seatingcount;
    }

	/**
	 * set座位数
	 */
    public void setSeatingcount(String seatingcount){
         this.seatingcount=seatingcount;
    }

	/**
	 * get变速器类型
	 */
    public String getGear(){
         return gear;
    }

	/**
	 * set变速器类型
	 */
    public void setGear(String gear){
         this.gear=gear;
    }

	/**
	 * get图片路径
	 */
    public String getImageurl(){
         return imageurl;
    }

	/**
	 * set图片路径
	 */
    public void setImageurl(String imageurl){
         this.imageurl=imageurl;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + code +"|"
	   
	 + brandcode +"|"
	   
	 + carriage +"|"
	   
	 + deliverycapacity +"|"
	   
	 + oilvolume +"|"
	   
	 + seatingcount +"|"
	   
	 + gear +"|"
	   
	 + imageurl
	 + "]";
 } 

}
