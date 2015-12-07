/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.integral;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *积分管理
 */
public class IntegralBean implements java.io.Serializable{

	/**
	  *积分管理 表名
	  */
	public static final String TABLE  = "T_INTEGRAL";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *代理类别 列名 
	  */
    public static final String COL_agenttype  = "C_AGENTTYPE";
	
	/**
	  *机票积分系数 列名 
	  */
    public static final String COL_aircoeft  = "C_AIRCOEFT";
	
	/**
	  *酒店积分系数 列名 
	  */
    public static final String COL_hotelcoeft  = "C_HOTELCOEFT";
	
	/**
	  *旅游积分系数 列名 
	  */
    public static final String COL_travelcoeft  = "C_TRAVELCOEFT";
	
	/**
	  *租车积分系数 列名 
	  */
    public static final String COL_carrentalcoeft  = "C_CARRENTALCOEFT";
	
	/**
	  *充值积分系数 列名 
	  */
    public static final String COL_rechargecoeft  = "C_RECHARGECOEFT";
	
	/**
	  *注册赠送积分 列名 
	  */
    public static final String COL_registerscore  = "C_REGISTERSCORE";
	
	/**
	  *违约处罚积分 列名 
	  */
    public static final String COL_punishscore  = "C_PUNISHSCORE";
	
	/**
	  *后台预订积分 列名 
	  */
    public static final String COL_backorderscore  = "C_BACKORDERSCORE";
	
	/**
	  *网站预订积分 列名 
	  */
    public static final String COL_weborderscore  = "C_WEBORDERSCORE";

	//ID
	private long id;    
    

	//代理类别
	private long agenttype;    
    //0,省  1,市  2,区域   3,经纪人  4,平台  5,会员

	//机票积分系数
	private Float aircoeft;    
    

	//酒店积分系数
	private Float hotelcoeft;    
    

	//旅游积分系数
	private Float travelcoeft;    
    

	//租车积分系数
	private Float carrentalcoeft;    
    

	//充值积分系数
	private Float rechargecoeft;    
    

	//注册赠送积分
	private Integer registerscore;    
    

	//违约处罚积分
	private Integer punishscore;    
    

	//后台预订积分
	private Integer backorderscore;    
    

	//网站预订积分
	private Integer weborderscore;    
    

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
	 * get代理类别
	 */
    public long getAgenttype(){
         return agenttype;
    }

	/**
	 * set代理类别
	 */
    public void setAgenttype(long agenttype){
         this.agenttype=agenttype;
    }

	/**
	 * get机票积分系数
	 */
    public Float getAircoeft(){
         return aircoeft;
    }

	/**
	 * set机票积分系数
	 */
    public void setAircoeft(Float aircoeft){
         this.aircoeft=aircoeft;
    }

	/**
	 * get酒店积分系数
	 */
    public Float getHotelcoeft(){
         return hotelcoeft;
    }

	/**
	 * set酒店积分系数
	 */
    public void setHotelcoeft(Float hotelcoeft){
         this.hotelcoeft=hotelcoeft;
    }

	/**
	 * get旅游积分系数
	 */
    public Float getTravelcoeft(){
         return travelcoeft;
    }

	/**
	 * set旅游积分系数
	 */
    public void setTravelcoeft(Float travelcoeft){
         this.travelcoeft=travelcoeft;
    }

	/**
	 * get租车积分系数
	 */
    public Float getCarrentalcoeft(){
         return carrentalcoeft;
    }

	/**
	 * set租车积分系数
	 */
    public void setCarrentalcoeft(Float carrentalcoeft){
         this.carrentalcoeft=carrentalcoeft;
    }

	/**
	 * get充值积分系数
	 */
    public Float getRechargecoeft(){
         return rechargecoeft;
    }

	/**
	 * set充值积分系数
	 */
    public void setRechargecoeft(Float rechargecoeft){
         this.rechargecoeft=rechargecoeft;
    }

	/**
	 * get注册赠送积分
	 */
    public Integer getRegisterscore(){
         return registerscore;
    }

	/**
	 * set注册赠送积分
	 */
    public void setRegisterscore(Integer registerscore){
         this.registerscore=registerscore;
    }

	/**
	 * get违约处罚积分
	 */
    public Integer getPunishscore(){
         return punishscore;
    }

	/**
	 * set违约处罚积分
	 */
    public void setPunishscore(Integer punishscore){
         this.punishscore=punishscore;
    }

	/**
	 * get后台预订积分
	 */
    public Integer getBackorderscore(){
         return backorderscore;
    }

	/**
	 * set后台预订积分
	 */
    public void setBackorderscore(Integer backorderscore){
         this.backorderscore=backorderscore;
    }

	/**
	 * get网站预订积分
	 */
    public Integer getWeborderscore(){
         return weborderscore;
    }

	/**
	 * set网站预订积分
	 */
    public void setWeborderscore(Integer weborderscore){
         this.weborderscore=weborderscore;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + agenttype +"|"
	   
	 + aircoeft +"|"
	   
	 + hotelcoeft +"|"
	   
	 + travelcoeft +"|"
	   
	 + carrentalcoeft +"|"
	   
	 + rechargecoeft +"|"
	   
	 + registerscore +"|"
	   
	 + punishscore +"|"
	   
	 + backorderscore +"|"
	   
	 + weborderscore
	 + "]";
 } 

}
