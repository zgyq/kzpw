/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.airlien;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *航线信息
 */
public class AirlienBean implements java.io.Serializable{

	/**
	  *航线信息 表名
	  */
	public static final String TABLE  = "T_AIRLIEN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *起飞三字码 列名 
	  */
    public static final String COL_scode  = "C_SCODE";
	
	/**
	  *到达三字码 列名 
	  */
    public static final String COL_ecode  = "C_ECODE";
	
	/**
	  *起飞机场 列名 
	  */
    public static final String COL_scityname  = "C_SCITYNAME";
	
	/**
	  *到达机场 列名 
	  */
    public static final String COL_ecityname  = "C_ECITYNAME";
	
	/**
	  *出发航站楼 列名 
	  */
    public static final String COL_shzl  = "C_SHZL";
	
	/**
	  *到达航站楼 列名 
	  */
    public static final String COL_ehzl  = "C_EHZL";
	
	/**
	  *航程距离 列名 
	  */
    public static final String COL_distance  = "C_DISTANCE";
	
	/**
	  *飞行时间 列名 
	  */
    public static final String COL_ftime  = "C_FTIME";
	
	/**
	  *航空公司代码 列名 
	  */
    public static final String COL_aircode  = "C_AIRCODE";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_airno  = "C_AIRNO";
	
	/**
	  *航空公司名字 列名 
	  */
    public static final String COL_airname  = "C_AIRNAME";
	
	/**
	  *基建费 列名 
	  */
    public static final String COL_airportfee  = "C_AIRPORTFEE";
	
	/**
	  *燃油费 列名 
	  */
    public static final String COL_fuelfee  = "C_FUELFEE";
	
	/**
	  *经停次数 列名 
	  */
    public static final String COL_stopnum  = "C_STOPNUM";
	
	/**
	  *经停信息 列名 
	  */
    public static final String COL_stopinfo  = "C_STOPINFO";
	
	/**
	  *餐饮 列名 
	  */
    public static final String COL_meal  = "C_MEAL";
	
	/**
	  *起飞时间 列名 
	  */
    public static final String COL_departtime  = "C_DEPARTTIME";
	
	/**
	  *降落时间 列名 
	  */
    public static final String COL_arrivetime  = "C_ARRIVETIME";
	
	/**
	  *共享航班号 列名 
	  */
    public static final String COL_sharenum  = "C_SHARENUM";
	
	/**
	  *班期信息 列名 
	  */
    public static final String COL_banqi  = "C_BANQI";
	
	/**
	  *机型 列名 
	  */
    public static final String COL_airtype  = "C_AIRTYPE";
	
	/**
	  *全价价格 列名 
	  */
    public static final String COL_yprice  = "C_YPRICE";
	
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
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//起飞三字码
	private String scode;    
    

	//到达三字码
	private String ecode;    
    

	//起飞机场
	private String scityname;    
    

	//到达机场
	private String ecityname;    
    

	//出发航站楼
	private String shzl;    
    

	//到达航站楼
	private String ehzl;    
    

	//航程距离
	private String distance;    
    

	//飞行时间
	private String ftime;    
    

	//航空公司代码
	private String aircode;    
    

	//航班号
	private String airno;    
    

	//航空公司名字
	private String airname;    
    

	//基建费
	private String airportfee;    
    

	//燃油费
	private String fuelfee;    
    

	//经停次数
	private String stopnum;    
    

	//经停信息
	private String stopinfo;    
    

	//餐饮
	private String meal;    
    

	//起飞时间
	private String departtime;    
    

	//降落时间
	private String arrivetime;    
    

	//共享航班号
	private String sharenum;    
    

	//班期信息
	private String banqi;    
    

	//机型
	private String airtype;    
    

	//全价价格
	private String yprice;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get起飞三字码
	 */
    public String getScode(){
         return scode;
    }

	/**
	 * set起飞三字码
	 */
    public void setScode(String scode){
         this.scode=scode;
    }

	/**
	 * get到达三字码
	 */
    public String getEcode(){
         return ecode;
    }

	/**
	 * set到达三字码
	 */
    public void setEcode(String ecode){
         this.ecode=ecode;
    }

	/**
	 * get起飞机场
	 */
    public String getScityname(){
         return scityname;
    }

	/**
	 * set起飞机场
	 */
    public void setScityname(String scityname){
         this.scityname=scityname;
    }

	/**
	 * get到达机场
	 */
    public String getEcityname(){
         return ecityname;
    }

	/**
	 * set到达机场
	 */
    public void setEcityname(String ecityname){
         this.ecityname=ecityname;
    }

	/**
	 * get出发航站楼
	 */
    public String getShzl(){
         return shzl;
    }

	/**
	 * set出发航站楼
	 */
    public void setShzl(String shzl){
         this.shzl=shzl;
    }

	/**
	 * get到达航站楼
	 */
    public String getEhzl(){
         return ehzl;
    }

	/**
	 * set到达航站楼
	 */
    public void setEhzl(String ehzl){
         this.ehzl=ehzl;
    }

	/**
	 * get航程距离
	 */
    public String getDistance(){
         return distance;
    }

	/**
	 * set航程距离
	 */
    public void setDistance(String distance){
         this.distance=distance;
    }

	/**
	 * get飞行时间
	 */
    public String getFtime(){
         return ftime;
    }

	/**
	 * set飞行时间
	 */
    public void setFtime(String ftime){
         this.ftime=ftime;
    }

	/**
	 * get航空公司代码
	 */
    public String getAircode(){
         return aircode;
    }

	/**
	 * set航空公司代码
	 */
    public void setAircode(String aircode){
         this.aircode=aircode;
    }

	/**
	 * get航班号
	 */
    public String getAirno(){
         return airno;
    }

	/**
	 * set航班号
	 */
    public void setAirno(String airno){
         this.airno=airno;
    }

	/**
	 * get航空公司名字
	 */
    public String getAirname(){
         return airname;
    }

	/**
	 * set航空公司名字
	 */
    public void setAirname(String airname){
         this.airname=airname;
    }

	/**
	 * get基建费
	 */
    public String getAirportfee(){
         return airportfee;
    }

	/**
	 * set基建费
	 */
    public void setAirportfee(String airportfee){
         this.airportfee=airportfee;
    }

	/**
	 * get燃油费
	 */
    public String getFuelfee(){
         return fuelfee;
    }

	/**
	 * set燃油费
	 */
    public void setFuelfee(String fuelfee){
         this.fuelfee=fuelfee;
    }

	/**
	 * get经停次数
	 */
    public String getStopnum(){
         return stopnum;
    }

	/**
	 * set经停次数
	 */
    public void setStopnum(String stopnum){
         this.stopnum=stopnum;
    }

	/**
	 * get经停信息
	 */
    public String getStopinfo(){
         return stopinfo;
    }

	/**
	 * set经停信息
	 */
    public void setStopinfo(String stopinfo){
         this.stopinfo=stopinfo;
    }

	/**
	 * get餐饮
	 */
    public String getMeal(){
         return meal;
    }

	/**
	 * set餐饮
	 */
    public void setMeal(String meal){
         this.meal=meal;
    }

	/**
	 * get起飞时间
	 */
    public String getDeparttime(){
         return departtime;
    }

	/**
	 * set起飞时间
	 */
    public void setDeparttime(String departtime){
         this.departtime=departtime;
    }

	/**
	 * get降落时间
	 */
    public String getArrivetime(){
         return arrivetime;
    }

	/**
	 * set降落时间
	 */
    public void setArrivetime(String arrivetime){
         this.arrivetime=arrivetime;
    }

	/**
	 * get共享航班号
	 */
    public String getSharenum(){
         return sharenum;
    }

	/**
	 * set共享航班号
	 */
    public void setSharenum(String sharenum){
         this.sharenum=sharenum;
    }

	/**
	 * get班期信息
	 */
    public String getBanqi(){
         return banqi;
    }

	/**
	 * set班期信息
	 */
    public void setBanqi(String banqi){
         this.banqi=banqi;
    }

	/**
	 * get机型
	 */
    public String getAirtype(){
         return airtype;
    }

	/**
	 * set机型
	 */
    public void setAirtype(String airtype){
         this.airtype=airtype;
    }

	/**
	 * get全价价格
	 */
    public String getYprice(){
         return yprice;
    }

	/**
	 * set全价价格
	 */
    public void setYprice(String yprice){
         this.yprice=yprice;
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
	   
	 + scode +"|"
	   
	 + ecode +"|"
	   
	 + scityname +"|"
	   
	 + ecityname +"|"
	   
	 + shzl +"|"
	   
	 + ehzl +"|"
	   
	 + distance +"|"
	   
	 + ftime +"|"
	   
	 + aircode +"|"
	   
	 + airno +"|"
	   
	 + airname +"|"
	   
	 + airportfee +"|"
	   
	 + fuelfee +"|"
	   
	 + stopnum +"|"
	   
	 + stopinfo +"|"
	   
	 + meal +"|"
	   
	 + departtime +"|"
	   
	 + arrivetime +"|"
	   
	 + sharenum +"|"
	   
	 + banqi +"|"
	   
	 + airtype +"|"
	   
	 + yprice +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + state
	 + "]";
 } 

}
