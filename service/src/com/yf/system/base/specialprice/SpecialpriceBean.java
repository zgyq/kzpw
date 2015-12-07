/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.specialprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *特价机票信息（定期更新）
 */
public class SpecialpriceBean implements java.io.Serializable{

	/**
	  *特价机票信息（定期更新） 表名
	  */
	public static final String TABLE  = "T_SPECIALPRICE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *起飞机场 列名 
	  */
    public static final String COL_startport  = "C_STARTPORT";
	
	/**
	  *目的机场 列名 
	  */
    public static final String COL_arrivalport  = "C_ARRIVALPORT";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *折扣 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *更新时间 列名 
	  */
    public static final String COL_updatetime  = "C_UPDATETIME";
	
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
     * 是否是国际航班线路
     */
    public static final String COL_isinternal="C_ISINTERNAL";

	//ID
	private long id;    
    

	//起飞机场
	private String startport;    
    

	//目的机场
	private String arrivalport;    
    

	//起飞时间
	private Timestamp starttime;    
    

	//折扣
	private Float discount;    
    

	//价格
	private Float price;    
    

	//更新时间
	private Timestamp updatetime;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;   
	
	private int isinternal;
    

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
	 * get起飞机场
	 */
    public String getStartport(){
         return startport;
    }

	/**
	 * set起飞机场
	 */
    public void setStartport(String startport){
         this.startport=startport;
    }

	/**
	 * get目的机场
	 */
    public String getArrivalport(){
         return arrivalport;
    }

	/**
	 * set目的机场
	 */
    public void setArrivalport(String arrivalport){
         this.arrivalport=arrivalport;
    }

	/**
	 * get起飞时间
	 */
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set起飞时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
    }

	/**
	 * get折扣
	 */
    public Float getDiscount(){
         return discount;
    }

	/**
	 * set折扣
	 */
    public void setDiscount(Float discount){
         this.discount=discount;
    }

	/**
	 * get价格
	 */
    public Float getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(Float price){
         this.price=price;
    }

	/**
	 * get更新时间
	 */
    public Timestamp getUpdatetime(){
         return updatetime;
    }

	/**
	 * set更新时间
	 */
    public void setUpdatetime(Timestamp updatetime){
         this.updatetime=updatetime;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + startport +"|"
	   
	 + arrivalport +"|"
	   
	 + starttime +"|"
	   
	 + discount +"|"
	   
	 + price +"|"
	   
	 + updatetime +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 }

	public int getIsinternal() {
		return isinternal;
	}

	public void setIsinternal(int isinternal) {
		this.isinternal = isinternal;
	} 

}
