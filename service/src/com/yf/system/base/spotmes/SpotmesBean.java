/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotmes;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *景点信息
 */
public class SpotmesBean implements java.io.Serializable{

	/**
	  *景点信息 表名
	  */
	public static final String TABLE  = "T_SPOTMES";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *景区ID 列名 
	  */
    public static final String COL_sid  = "C_SID";
	
	/**
	  *景区供应商ID 列名 
	  */
    public static final String COL_uid  = "C_UID";
	
	/**
	  *景区名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *省份ID 列名 
	  */
    public static final String COL_provineid  = "C_PROVINEID";
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *区域ID 列名 
	  */
    public static final String COL_areaid  = "C_AREAID";
	
	/**
	  *景区地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *景区信息 列名 
	  */
    public static final String COL_info  = "C_INFO";
	
	/**
	  *交通指南 列名 
	  */
    public static final String COL_traffic  = "C_TRAFFIC";
	
	/**
	  *注意事项 列名 
	  */
    public static final String COL_notice  = "C_NOTICE";
	
	/**
	  *景区图片 列名 
	  */
    public static final String COL_pics  = "C_PICS";
	
	/**
	  *景区图片路径 列名 
	  */
    public static final String COL_minipics  = "C_MINIPICS";
	
	/**
	  *票类说明 列名 
	  */
    public static final String COL_ticketnotic  = "C_TICKETNOTIC";
	
	/**
	  *温馨提示 列名 
	  */
    public static final String COL_guidelines  = "C_GUIDELINES";
	
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
	  *会员ID 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//外部id
	private String outid;    
    

	//景区ID
	private String sid;    
    

	//景区供应商ID
	private String uid;    
    

	//景区名称
	private String name;    
    

	//省份ID
	private String provineid;    
    

	//城市ID
	private String cityid;    
    

	//区域ID
	private String areaid;    
    

	//景区地址
	private String address;    
    

	//景区信息
	private String info;    
    

	//交通指南
	private String traffic;    
    

	//注意事项
	private String notice;    
    

	//景区图片
	private String pics;    
    

	//景区图片路径
	private String minipics;    
    

	//票类说明
	private String ticketnotic;    
    

	//温馨提示-附近景点
	private String guidelines;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

	//创建时间
	private Timestamp createtime;    
    

	//会员ID
	private Long memberid;    
    

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
	 * get外部id
	 */
    public String getOutid(){
         return outid;
    }

	/**
	 * set外部id
	 */
    public void setOutid(String outid){
         this.outid=outid;
    }

	/**
	 * get景区ID
	 */
    public String getSid(){
         return sid;
    }

	/**
	 * set景区ID
	 */
    public void setSid(String sid){
         this.sid=sid;
    }

	/**
	 * get景区供应商ID
	 */
    public String getUid(){
         return uid;
    }

	/**
	 * set景区供应商ID
	 */
    public void setUid(String uid){
         this.uid=uid;
    }

	/**
	 * get景区名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set景区名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get省份ID
	 */
    public String getProvineid(){
         return provineid;
    }

	/**
	 * set省份ID
	 */
    public void setProvineid(String provineid){
         this.provineid=provineid;
    }

	/**
	 * get城市ID
	 */
    public String getCityid(){
         return cityid;
    }

	/**
	 * set城市ID
	 */
    public void setCityid(String cityid){
         this.cityid=cityid;
    }

	/**
	 * get区域ID
	 */
    public String getAreaid(){
         return areaid;
    }

	/**
	 * set区域ID
	 */
    public void setAreaid(String areaid){
         this.areaid=areaid;
    }

	/**
	 * get景区地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set景区地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get景区信息
	 */
    public String getInfo(){
         return info;
    }

	/**
	 * set景区信息
	 */
    public void setInfo(String info){
         this.info=info;
    }

	/**
	 * get交通指南
	 */
    public String getTraffic(){
         return traffic;
    }

	/**
	 * set交通指南
	 */
    public void setTraffic(String traffic){
         this.traffic=traffic;
    }

	/**
	 * get注意事项
	 */
    public String getNotice(){
         return notice;
    }

	/**
	 * set注意事项
	 */
    public void setNotice(String notice){
         this.notice=notice;
    }

	/**
	 * get景区图片
	 */
    public String getPics(){
         return pics;
    }

	/**
	 * set景区图片
	 */
    public void setPics(String pics){
         this.pics=pics;
    }

	/**
	 * get景区图片路径
	 */
    public String getMinipics(){
         return minipics;
    }

	/**
	 * set景区图片路径
	 */
    public void setMinipics(String minipics){
         this.minipics=minipics;
    }

	/**
	 * get票类说明
	 */
    public String getTicketnotic(){
         return ticketnotic;
    }

	/**
	 * set票类说明
	 */
    public void setTicketnotic(String ticketnotic){
         this.ticketnotic=ticketnotic;
    }

	/**
	 * get温馨提示
	 */
    public String getGuidelines(){
         return guidelines;
    }

	/**
	 * set温馨提示
	 */
    public void setGuidelines(String guidelines){
         this.guidelines=guidelines;
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
	 * get会员ID
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set会员ID
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
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
	   
	 + outid +"|"
	   
	 + sid +"|"
	   
	 + uid +"|"
	   
	 + name +"|"
	   
	 + provineid +"|"
	   
	 + cityid +"|"
	   
	 + areaid +"|"
	   
	 + address +"|"
	   
	 + info +"|"
	   
	 + traffic +"|"
	   
	 + notice +"|"
	   
	 + pics +"|"
	   
	 + minipics +"|"
	   
	 + ticketnotic +"|"
	   
	 + guidelines +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + state
	 + "]";
 } 

}
