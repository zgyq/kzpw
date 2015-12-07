/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotlineinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *景区线路详细信息
 */
public class SpotlineinfoBean implements java.io.Serializable{

	/**
	  *景区线路详细信息 表名
	  */
	public static final String TABLE  = "T_SPOTLINEINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *线路id 列名 
	  */
    public static final String COL_spotlineid  = "C_SPOTLINEID";
	
	/**
	  *当前天数 列名 
	  */
    public static final String COL_dday  = "C_DDAY";
	
	/**
	  *区间 列名 
	  */
    public static final String COL_qujian  = "C_QUJIAN";
	
	/**
	  *住宿 列名 
	  */
    public static final String COL_zhusu  = "C_ZHUSU";
	
	/**
	  *餐饮 列名 
	  */
    public static final String COL_canyin  = "C_CANYIN";
	
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
	private String spotlineid;    
    

	//当前天数
	private String dday;    
    

	//区间
	private String qujian;    
    

	//住宿
	private String zhusu;    
    

	//餐饮
	private String canyin;    
    

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
    public String getSpotlineid(){
         return spotlineid;
    }

	/**
	 * set线路id
	 */
    public void setSpotlineid(String spotlineid){
         this.spotlineid=spotlineid;
    }

	/**
	 * get当前天数
	 */
    public String getDday(){
         return dday;
    }

	/**
	 * set当前天数
	 */
    public void setDday(String dday){
         this.dday=dday;
    }

	/**
	 * get区间
	 */
    public String getQujian(){
         return qujian;
    }

	/**
	 * set区间
	 */
    public void setQujian(String qujian){
         this.qujian=qujian;
    }

	/**
	 * get住宿
	 */
    public String getZhusu(){
         return zhusu;
    }

	/**
	 * set住宿
	 */
    public void setZhusu(String zhusu){
         this.zhusu=zhusu;
    }

	/**
	 * get餐饮
	 */
    public String getCanyin(){
         return canyin;
    }

	/**
	 * set餐饮
	 */
    public void setCanyin(String canyin){
         this.canyin=canyin;
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
	   
	 + spotlineid +"|"
	   
	 + dday +"|"
	   
	 + qujian +"|"
	   
	 + zhusu +"|"
	   
	 + canyin +"|"
	   
	 + beizhu +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + state
	 + "]";
 } 

}
