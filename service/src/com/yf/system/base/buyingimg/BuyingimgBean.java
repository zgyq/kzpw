/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.buyingimg;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *团购图片信息
 */
public class BuyingimgBean implements java.io.Serializable{

	/**
	  *团购图片信息 表名
	  */
	public static final String TABLE  = "T_BUYINGIMG";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *线路id 列名 
	  */
    public static final String COL_buyingid  = "C_BUYINGID";
	
	/**
	  *图片路径 列名 
	  */
    public static final String COL_imgurl  = "C_IMGURL";
	
	/**
	  *图片说明 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_beizhu  = "C_BEIZHU";
	
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
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//线路id
	private Long buyingid;    
    

	//图片路径
	private String imgurl;    
    

	//图片说明
	private String name;    
    

	//备注
	private String beizhu;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//状态
	private Long state;    
    

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
	 * get线路id
	 */
    public Long getBuyingid(){
         return buyingid;
    }

	/**
	 * set线路id
	 */
    public void setBuyingid(Long buyingid){
         this.buyingid=buyingid;
    }

	/**
	 * get图片路径
	 */
    public String getImgurl(){
         return imgurl;
    }

	/**
	 * set图片路径
	 */
    public void setImgurl(String imgurl){
         this.imgurl=imgurl;
    }

	/**
	 * get图片说明
	 */
    public String getName(){
         return name;
    }

	/**
	 * set图片说明
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get备注
	 */
    public String getBeizhu(){
         return beizhu;
    }

	/**
	 * set备注
	 */
    public void setBeizhu(String beizhu){
         this.beizhu=beizhu;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + buyingid +"|"
	   
	 + imgurl +"|"
	   
	 + name +"|"
	   
	 + beizhu +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + state
	 + "]";
 } 

}
