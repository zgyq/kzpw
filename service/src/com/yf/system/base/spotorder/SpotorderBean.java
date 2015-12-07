/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *门票订单
 */
public class SpotorderBean implements java.io.Serializable{

	/**
	  *门票订单 表名
	  */
	public static final String TABLE  = "T_SPOTORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部订单id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *景区ID 列名 
	  */
    public static final String COL_spotorderid  = "C_spotorderID";
	
	/**
	  *门票ID 列名 
	  */
    public static final String COL_spotticketid  = "C_SPOTTICKETID";
	
	/**
	  *门票名称 列名 
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
	  *门票数量 列名 
	  */
    public static final String COL_snum  = "C_SNUM";
	
	/**
	  *身份证 列名 
	  */
    public static final String COL_sfz  = "C_SFZ";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *游玩时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *景区图片路径 列名 
	  */
    public static final String COL_minipics  = "C_MINIPICS";
	
	/**
	  *总价 列名 
	  */
    public static final String COL_price  = "C_Price";
	
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
    

	//外部订单id
	private String outid;    
    

	//景区ID
	private String spotorderid;    
    

	//门票ID
	private String spotticketid;    
    

	//门票名称
	private String name;    
    

	//省份ID
	private String provineid;    
    

	//城市ID
	private String cityid;    
    

	//区域ID
	private String areaid;    
    

	//景区地址
	private String address;    
    

	//门票数量
	private String snum;    
    

	//身份证
	private String sfz;    
    

	//电话
	private String tel;    
    

	//游玩时间
	private String stime;    
    

	//景区图片路径
	private String minipics;    
    

	//总价
	private String price;    
    

	//温馨提示
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
	 * get外部订单id
	 */
    public String getOutid(){
         return outid;
    }

	/**
	 * set外部订单id
	 */
    public void setOutid(String outid){
         this.outid=outid;
    }

	/**
	 * get景区ID
	 */
    public String getspotorderid(){
         return spotorderid;
    }

	/**
	 * set景区ID
	 */
    public void setspotorderid(String spotorderid){
         this.spotorderid=spotorderid;
    }

	/**
	 * get门票ID
	 */
    public String getSpotticketid(){
         return spotticketid;
    }

	/**
	 * set门票ID
	 */
    public void setSpotticketid(String spotticketid){
         this.spotticketid=spotticketid;
    }

	/**
	 * get门票名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set门票名称
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
	 * get门票数量
	 */
    public String getSunm(){
         return snum;
    }

	/**
	 * set门票数量
	 */
    public void setSunm(String snum){
         this.snum=snum;
    }

	/**
	 * get身份证
	 */
    public String getSfz(){
         return sfz;
    }

	/**
	 * set身份证
	 */
    public void setSfz(String sfz){
         this.sfz=sfz;
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
	 * get游玩时间
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set游玩时间
	 */
    public void setStime(String stime){
         this.stime=stime;
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
	 * get总价
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set总价
	 */
    public void setPrice(String price){
         this.price=price;
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
	   
	 + spotorderid +"|"
	   
	 + spotticketid +"|"
	   
	 + name +"|"
	   
	 + provineid +"|"
	   
	 + cityid +"|"
	   
	 + areaid +"|"
	   
	 + address +"|"
	   
	 + snum +"|"
	   
	 + sfz +"|"
	   
	 + tel +"|"
	   
	 + stime +"|"
	   
	 + minipics +"|"
	   
	 + price +"|"
	   
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
