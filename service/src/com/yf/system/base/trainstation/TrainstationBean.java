/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.trainstation;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *火车站信息
 */
public class TrainstationBean implements java.io.Serializable{

	/**
	  *火车站信息 表名
	  */
	public static final String TABLE  = "T_TRAINSTATION";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *GTFSID 列名 
	  */
    public static final String COL_trainstation_id  = "C_TRAINSTATION_ID";
	
	/**
	  *代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *城市 列名 
	  */
    public static final String COL_city  = "C_CITY";
	
	/**
	  *火车站简称 列名 
	  */
    public static final String COL_name_cn  = "C_NAME_CN";
	
	/**
	  *火车站简称拼音 列名 
	  */
    public static final String COL_name_py  = "C_NAME_PY";
	
	/**
	  *火车站英文简称 列名 
	  */
    public static final String COL_name_en  = "C_NAME_EN";
	
	/**
	  *火车站中文全称 列名 
	  */
    public static final String COL_nameall_cn  = "C_NAMEALL_CN";
	
	/**
	  *火车站全称拼音 列名 
	  */
    public static final String COL_nameall_py  = "C_NAMEALL_PY";
	
	/**
	  *火车站英文全称 列名 
	  */
    public static final String COL_nameall_en  = "C_NAMEALL_EN";
	
	/**
	  *火车站别名 列名 
	  */
    public static final String COL_byname  = "C_BYNAME";
	
	/**
	  *国家代码 列名 
	  */
    public static final String COL_statecode  = "C_STATECODE";
	
	/**
	  *行政区划ID 列名 
	  */
    public static final String COL_admin_id  = "C_ADMIN_ID";
	
	/**
	  *行政区划名称 列名 
	  */
    public static final String COL_admin_name  = "C_ADMIN_NAME";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *经度 列名 
	  */
    public static final String COL_lon  = "C_LON";
	
	/**
	  *纬度 列名 
	  */
    public static final String COL_lat  = "C_LAT";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_mem  = "C_MEM";
	
	/**
	  *备用1 列名 
	  */
    public static final String COL_back1  = "C_BACK1";
	
	/**
	  *备用2 列名 
	  */
    public static final String COL_back2  = "C_BACK2";
	
	/**
	  *备用3 列名 
	  */
    public static final String COL_back3  = "C_BACK3";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//GTFSID
	private String trainstation_id;    
    

	//代码
	private String code;    
    

	//城市
	private String city;    
    

	//火车站简称
	private String name_cn;    
    

	//火车站简称拼音
	private String name_py;    
    

	//火车站英文简称
	private String name_en;    
    

	//火车站中文全称
	private String nameall_cn;    
    

	//火车站全称拼音
	private String nameall_py;    
    

	//火车站英文全称
	private String nameall_en;    
    

	//火车站别名
	private String byname;    
    

	//国家代码
	private String statecode;    
    

	//行政区划ID
	private String admin_id;    
    

	//行政区划名称
	private String admin_name;    
    

	//地址
	private String address;    
    

	//电话
	private String tel;    
    

	//经度
	private String lon;    
    

	//纬度
	private String lat;    
    

	//备注
	private String mem;    
    

	//备用1
	private String back1;    
    

	//备用2
	private String back2;    
    

	//备用3
	private String back3;    
    

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
	 * getGTFSID
	 */
    public String getTrainstation_id(){
         return trainstation_id;
    }

	/**
	 * setGTFSID
	 */
    public void setTrainstation_id(String trainstation_id){
         this.trainstation_id=trainstation_id;
    }

	/**
	 * get代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set代码
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get城市
	 */
    public String getCity(){
         return city;
    }

	/**
	 * set城市
	 */
    public void setCity(String city){
         this.city=city;
    }

	/**
	 * get火车站简称
	 */
    public String getName_cn(){
         return name_cn;
    }

	/**
	 * set火车站简称
	 */
    public void setName_cn(String name_cn){
         this.name_cn=name_cn;
    }

	/**
	 * get火车站简称拼音
	 */
    public String getName_py(){
         return name_py;
    }

	/**
	 * set火车站简称拼音
	 */
    public void setName_py(String name_py){
         this.name_py=name_py;
    }

	/**
	 * get火车站英文简称
	 */
    public String getName_en(){
         return name_en;
    }

	/**
	 * set火车站英文简称
	 */
    public void setName_en(String name_en){
         this.name_en=name_en;
    }

	/**
	 * get火车站中文全称
	 */
    public String getNameall_cn(){
         return nameall_cn;
    }

	/**
	 * set火车站中文全称
	 */
    public void setNameall_cn(String nameall_cn){
         this.nameall_cn=nameall_cn;
    }

	/**
	 * get火车站全称拼音
	 */
    public String getNameall_py(){
         return nameall_py;
    }

	/**
	 * set火车站全称拼音
	 */
    public void setNameall_py(String nameall_py){
         this.nameall_py=nameall_py;
    }

	/**
	 * get火车站英文全称
	 */
    public String getNameall_en(){
         return nameall_en;
    }

	/**
	 * set火车站英文全称
	 */
    public void setNameall_en(String nameall_en){
         this.nameall_en=nameall_en;
    }

	/**
	 * get火车站别名
	 */
    public String getByname(){
         return byname;
    }

	/**
	 * set火车站别名
	 */
    public void setByname(String byname){
         this.byname=byname;
    }

	/**
	 * get国家代码
	 */
    public String getStatecode(){
         return statecode;
    }

	/**
	 * set国家代码
	 */
    public void setStatecode(String statecode){
         this.statecode=statecode;
    }

	/**
	 * get行政区划ID
	 */
    public String getAdmin_id(){
         return admin_id;
    }

	/**
	 * set行政区划ID
	 */
    public void setAdmin_id(String admin_id){
         this.admin_id=admin_id;
    }

	/**
	 * get行政区划名称
	 */
    public String getAdmin_name(){
         return admin_name;
    }

	/**
	 * set行政区划名称
	 */
    public void setAdmin_name(String admin_name){
         this.admin_name=admin_name;
    }

	/**
	 * get地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get电话
	 */
    public String getTel(){
         return tel;
    }

	/**
	 * set电话
	 */
    public void setTel(String tel){
         this.tel=tel;
    }

	/**
	 * get经度
	 */
    public String getLon(){
         return lon;
    }

	/**
	 * set经度
	 */
    public void setLon(String lon){
         this.lon=lon;
    }

	/**
	 * get纬度
	 */
    public String getLat(){
         return lat;
    }

	/**
	 * set纬度
	 */
    public void setLat(String lat){
         this.lat=lat;
    }

	/**
	 * get备注
	 */
    public String getMem(){
         return mem;
    }

	/**
	 * set备注
	 */
    public void setMem(String mem){
         this.mem=mem;
    }

	/**
	 * get备用1
	 */
    public String getBack1(){
         return back1;
    }

	/**
	 * set备用1
	 */
    public void setBack1(String back1){
         this.back1=back1;
    }

	/**
	 * get备用2
	 */
    public String getBack2(){
         return back2;
    }

	/**
	 * set备用2
	 */
    public void setBack2(String back2){
         this.back2=back2;
    }

	/**
	 * get备用3
	 */
    public String getBack3(){
         return back3;
    }

	/**
	 * set备用3
	 */
    public void setBack3(String back3){
         this.back3=back3;
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
	   
	 + trainstation_id +"|"
	   
	 + code +"|"
	   
	 + city +"|"
	   
	 + name_cn +"|"
	   
	 + name_py +"|"
	   
	 + name_en +"|"
	   
	 + nameall_cn +"|"
	   
	 + nameall_py +"|"
	   
	 + nameall_en +"|"
	   
	 + byname +"|"
	   
	 + statecode +"|"
	   
	 + admin_id +"|"
	   
	 + admin_name +"|"
	   
	 + address +"|"
	   
	 + tel +"|"
	   
	 + lon +"|"
	   
	 + lat +"|"
	   
	 + mem +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + state
	 + "]";
 } 

}
