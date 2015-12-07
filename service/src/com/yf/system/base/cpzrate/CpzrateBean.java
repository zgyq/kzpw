/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.cpzrate;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *包机政策
 */
public class CpzrateBean implements java.io.Serializable{

	/**
	  *包机政策 表名
	  */
	public static final String TABLE  = "T_CPZRATE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *航空公司 列名 
	  */
    public static final String COL_aircompany  = "C_AIRCOMPANY";
	
	/**
	  *政策开始时间 列名 
	  */
    public static final String COL_begindate  = "C_BEGINDATE";
	
	/**
	  *政策结束时间 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *到达城市 列名 
	  */
    public static final String COL_endcity  = "C_ENDCITY";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_airline  = "C_AIRLINE";
	
	/**
	  *舱位 列名 
	  */
    public static final String COL_aircode  = "C_AIRCODE";
	
	/**
	  *票面价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *折扣 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *返点 列名 
	  */
    public static final String COL_rebate  = "C_REBATE";
	
	/**
	  *结算价 列名 
	  */
    public static final String COL_sprice  = "C_SPRICE";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改人 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";

	//ID
	private long id;    
    

	//航空公司
	private String aircompany;    
    

	//政策开始时间
	private Timestamp begindate;    
    

	//政策结束时间
	private Timestamp enddate;    
    

	//出发城市
	private String startcity;    
    

	//到达城市
	private String endcity;    
    

	//航班号
	private String airline;    
    

	//舱位
	private String aircode;    
    

	//票面价
	private Double price;    
    

	//折扣
	private Double discount;    
    

	//返点
	private Double rebate;    
    

	//结算价
	private Double sprice;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

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
	 * get航空公司
	 */
    public String getAircompany(){
         return aircompany;
    }

	/**
	 * set航空公司
	 */
    public void setAircompany(String aircompany){
         this.aircompany=aircompany;
    }

	/**
	 * get政策开始时间
	 */
    public Timestamp getBegindate(){
         return begindate;
    }

	/**
	 * set政策开始时间
	 */
    public void setBegindate(Timestamp begindate){
         this.begindate=begindate;
    }

	/**
	 * get政策结束时间
	 */
    public Timestamp getEnddate(){
         return enddate;
    }

	/**
	 * set政策结束时间
	 */
    public void setEnddate(Timestamp enddate){
         this.enddate=enddate;
    }

	/**
	 * get出发城市
	 */
    public String getStartcity(){
         return startcity;
    }

	/**
	 * set出发城市
	 */
    public void setStartcity(String startcity){
         this.startcity=startcity;
    }

	/**
	 * get到达城市
	 */
    public String getEndcity(){
         return endcity;
    }

	/**
	 * set到达城市
	 */
    public void setEndcity(String endcity){
         this.endcity=endcity;
    }

	/**
	 * get航班号
	 */
    public String getAirline(){
         return airline;
    }

	/**
	 * set航班号
	 */
    public void setAirline(String airline){
         this.airline=airline;
    }

	/**
	 * get舱位
	 */
    public String getAircode(){
         return aircode;
    }

	/**
	 * set舱位
	 */
    public void setAircode(String aircode){
         this.aircode=aircode;
    }

	/**
	 * get票面价
	 */
    public Double getPrice(){
         return price;
    }

	/**
	 * set票面价
	 */
    public void setPrice(Double price){
         this.price=price;
    }

	/**
	 * get折扣
	 */
    public Double getDiscount(){
         return discount;
    }

	/**
	 * set折扣
	 */
    public void setDiscount(Double discount){
         this.discount=discount;
    }

	/**
	 * get返点
	 */
    public Double getRebate(){
         return rebate;
    }

	/**
	 * set返点
	 */
    public void setRebate(Double rebate){
         this.rebate=rebate;
    }

	/**
	 * get结算价
	 */
    public Double getSprice(){
         return sprice;
    }

	/**
	 * set结算价
	 */
    public void setSprice(Double sprice){
         this.sprice=sprice;
    }

	/**
	 * get创建人
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
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
	 * get修改人
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改人
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
	   
	 + aircompany +"|"
	   
	 + begindate +"|"
	   
	 + enddate +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + airline +"|"
	   
	 + aircode +"|"
	   
	 + price +"|"
	   
	 + discount +"|"
	   
	 + rebate +"|"
	   
	 + sprice +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
