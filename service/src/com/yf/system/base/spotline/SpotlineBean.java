/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotline;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *景区线路信息
 */
public class SpotlineBean implements java.io.Serializable{

	/**
	  *景区线路信息 表名
	  */
	public static final String TABLE  = "T_SPOTLINE";

	
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
	  *供应商ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *线路名称 列名 
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
	  *景点信息 列名 
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
	  *景点图片 列名 
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
	  *出发日期 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *行程天数 列名 
	  */
    public static final String COL_days  = "C_DAYS";
	
	/**
	  *计划人数 列名 
	  */
    public static final String COL_snums  = "C_SNUMS";
	
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
	  *线路类型 列名 
	  */
    public static final String COL_stype  = "C_STYPE";
	
	/**
	  *地接社名称 列名 
	  */
    public static final String COL_djsname  = "C_DJSNAME";
	
	/**
	  *地接社电话 列名 
	  */
    public static final String COL_djstel  = "C_DJSTEL";
	
	/**
	  *地接社联系人 列名 
	  */
    public static final String COL_djslinkname  = "C_DJSLINKNAME";
	
	/**
	  *地接社地址 列名 
	  */
    public static final String COL_djsaddress  = "C_DJSADDRESS";
	
	/**
	  *服务标准 列名 
	  */
    public static final String COL_fwbz  = "C_FWBZ";
	
	/**
	  *费用包含 列名 
	  */
    public static final String COL_baohan  = "C_BAOHAN";
	
	/**
	  *费用不包含 列名 
	  */
    public static final String COL_bubaohan  = "C_BUBAOHAN";
	
	/**
	  *门市备注 列名 
	  */
    public static final String COL_menshibeizhu  = "C_MENSHIBEIZHU";
	
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
    

	//供应商ID
	private String agentid;    
    

	//线路名称
	private String name;    
    

	//省份ID
	private Long provineid;    
    

	//城市ID
	private Long cityid;    
    

	//区域ID
	private Long areaid;    
    

	//景区地址
	private String address;    
    

	//景点信息
	private String info;    
    

	//交通指南
	private String traffic;    
    

	//注意事项
	private String notice;    
    

	//景点图片
	private String pics;    
    

	//景区图片路径
	private String minipics;    
    

	//票类说明
	private String ticketnotic;    
    

	//温馨提示
	private String guidelines;    
    

	//出发日期
	private String stime;    
    

	//行程天数
	private String days;    
    

	//计划人数
	private String snums;    
    

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
    

	//线路类型
	private Long stype;    
    

	//地接社名称
	private String djsname;    
    

	//地接社电话
	private String djstel;    
    

	//地接社联系人
	private String djslinkname;    
    

	//地接社地址
	private String djsaddress;    
    

	//服务标准
	private String fwbz;    
    

	//费用包含
	private String baohan;    
    

	//费用不包含
	private String bubaohan;    
    

	//门市备注
	private String menshibeizhu;    
    

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
	 * get供应商ID
	 */
    public String getAgentid(){
         return agentid;
    }

	/**
	 * set供应商ID
	 */
    public void setAgentid(String agentid){
         this.agentid=agentid;
    }

	/**
	 * get线路名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set线路名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get省份ID
	 */
    public Long getProvineid(){
         return provineid;
    }

	/**
	 * set省份ID
	 */
    public void setProvineid(Long provineid){
         this.provineid=provineid;
    }

	/**
	 * get城市ID
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set城市ID
	 */
    public void setCityid(Long cityid){
         this.cityid=cityid;
    }

	/**
	 * get区域ID
	 */
    public Long getAreaid(){
         return areaid;
    }

	/**
	 * set区域ID
	 */
    public void setAreaid(Long areaid){
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
	 * get景点信息
	 */
    public String getInfo(){
         return info;
    }

	/**
	 * set景点信息
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
	 * get景点图片
	 */
    public String getPics(){
         return pics;
    }

	/**
	 * set景点图片
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
	 * get出发日期
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set出发日期
	 */
    public void setStime(String stime){
         this.stime=stime;
    }

	/**
	 * get行程天数
	 */
    public String getDays(){
         return days;
    }

	/**
	 * set行程天数
	 */
    public void setDays(String days){
         this.days=days;
    }

	/**
	 * get计划人数
	 */
    public String getSnums(){
         return snums;
    }

	/**
	 * set计划人数
	 */
    public void setSnums(String snums){
         this.snums=snums;
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
	 * get线路类型
	 */
    public Long getStype(){
         return stype;
    }

	/**
	 * set线路类型
	 */
    public void setStype(Long stype){
         this.stype=stype;
    }

	/**
	 * get地接社名称
	 */
    public String getDjsname(){
         return djsname;
    }

	/**
	 * set地接社名称
	 */
    public void setDjsname(String djsname){
         this.djsname=djsname;
    }

	/**
	 * get地接社电话
	 */
    public String getDjstel(){
         return djstel;
    }

	/**
	 * set地接社电话
	 */
    public void setDjstel(String djstel){
         this.djstel=djstel;
    }

	/**
	 * get地接社联系人
	 */
    public String getDjslinkname(){
         return djslinkname;
    }

	/**
	 * set地接社联系人
	 */
    public void setDjslinkname(String djslinkname){
         this.djslinkname=djslinkname;
    }

	/**
	 * get地接社地址
	 */
    public String getDjsaddress(){
         return djsaddress;
    }

	/**
	 * set地接社地址
	 */
    public void setDjsaddress(String djsaddress){
         this.djsaddress=djsaddress;
    }

	/**
	 * get服务标准
	 */
    public String getFwbz(){
         return fwbz;
    }

	/**
	 * set服务标准
	 */
    public void setFwbz(String fwbz){
         this.fwbz=fwbz;
    }

	/**
	 * get费用包含
	 */
    public String getBaohan(){
         return baohan;
    }

	/**
	 * set费用包含
	 */
    public void setBaohan(String baohan){
         this.baohan=baohan;
    }

	/**
	 * get费用不包含
	 */
    public String getBubaohan(){
         return bubaohan;
    }

	/**
	 * set费用不包含
	 */
    public void setBubaohan(String bubaohan){
         this.bubaohan=bubaohan;
    }

	/**
	 * get门市备注
	 */
    public String getMenshibeizhu(){
         return menshibeizhu;
    }

	/**
	 * set门市备注
	 */
    public void setMenshibeizhu(String menshibeizhu){
         this.menshibeizhu=menshibeizhu;
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
	   
	 + agentid +"|"
	   
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
	   
	 + stime +"|"
	   
	 + days +"|"
	   
	 + snums +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + stype +"|"
	   
	 + djsname +"|"
	   
	 + djstel +"|"
	   
	 + djslinkname +"|"
	   
	 + djsaddress +"|"
	   
	 + fwbz +"|"
	   
	 + baohan +"|"
	   
	 + bubaohan +"|"
	   
	 + menshibeizhu +"|"
	   
	 + state
	 + "]";
 } 

}
