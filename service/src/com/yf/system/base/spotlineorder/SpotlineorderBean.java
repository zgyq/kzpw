/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spotlineorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *线路订单
 */
public class SpotlineorderBean implements java.io.Serializable{

	/**
	  *线路订单 表名
	  */
	public static final String TABLE  = "T_SPOTLINEORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *外部订单id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *订单编号 列名 
	  */
    public static final String COL_orderno  = "C_ORDERNO";
	
	/**
	  *线路ID 列名 
	  */
    public static final String COL_spotlineid  = "C_SPOTLINEID";
	
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
	  *线路地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *总人数 列名 
	  */
    public static final String COL_snum  = "C_SNUM";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_linkname  = "C_LINKNAME";
	
	/**
	  *联系电话 列名 
	  */
    public static final String COL_linktel  = "C_LINKTEL";
	
	/**
	  *游玩时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *联系邮箱 列名 
	  */
    public static final String COL_linkemail  = "C_LINKEMAIL";
	
	/**
	  *总价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
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
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *支付状态 列名 
	  */
    public static final String COL_paystate  = "C_PAYSTATE";
	
	/**
	  *营业部ID 列名 
	  */
    public static final String COL_stopid  = "C_STOPID";
	
	/**
	  *订单状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//外部订单id
	private String outid;    
    

	//订单编号
	private String orderno;    
    

	//线路ID
	private String spotlineid;    
    

	//线路名称
	private String name;    
    

	//省份ID
	private String provineid;    
    

	//城市ID
	private String cityid;    
    

	//区域ID
	private String areaid;    
    

	//线路地址
	private String address;    
    

	//总人数
	private String snum;    
    

	//联系人姓名
	private String linkname;    
    

	//联系电话
	private String linktel;    
    

	//游玩时间
	private String stime;    
    

	//联系邮箱
	private String linkemail;    
    

	//总价
	private String price;    
    

	//备注
	private String beizhu;    
    

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
    

	//支付状态
	private Long paystate;    
    

	//营业部ID
	private Long stopid;    
    

	//订单状态
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
	 * get订单编号
	 */
    public String getOrderno(){
         return orderno;
    }

	/**
	 * set订单编号
	 */
    public void setOrderno(String orderno){
         this.orderno=orderno;
    }

	/**
	 * get线路ID
	 */
    public String getSpotlineid(){
         return spotlineid;
    }

	/**
	 * set线路ID
	 */
    public void setSpotlineid(String spotlineid){
         this.spotlineid=spotlineid;
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
	 * get线路地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set线路地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get总人数
	 */
    public String getSnum(){
         return snum;
    }

	/**
	 * set总人数
	 */
    public void setSnum(String snum){
         this.snum=snum;
    }

	/**
	 * get联系人姓名
	 */
    public String getLinkname(){
         return linkname;
    }

	/**
	 * set联系人姓名
	 */
    public void setLinkname(String linkname){
         this.linkname=linkname;
    }

	/**
	 * get联系电话
	 */
    public String getLinktel(){
         return linktel;
    }

	/**
	 * set联系电话
	 */
    public void setLinktel(String linktel){
         this.linktel=linktel;
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
	 * get联系邮箱
	 */
    public String getLinkemail(){
         return linkemail;
    }

	/**
	 * set联系邮箱
	 */
    public void setLinkemail(String linkemail){
         this.linkemail=linkemail;
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
	 * get支付状态
	 */
    public Long getPaystate(){
         return paystate;
    }

	/**
	 * set支付状态
	 */
    public void setPaystate(Long paystate){
         this.paystate=paystate;
    }

	/**
	 * get营业部ID
	 */
    public Long getStopid(){
         return stopid;
    }

	/**
	 * set营业部ID
	 */
    public void setStopid(Long stopid){
         this.stopid=stopid;
    }

	/**
	 * get订单状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set订单状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + outid +"|"
	   
	 + orderno +"|"
	   
	 + spotlineid +"|"
	   
	 + name +"|"
	   
	 + provineid +"|"
	   
	 + cityid +"|"
	   
	 + areaid +"|"
	   
	 + address +"|"
	   
	 + snum +"|"
	   
	 + linkname +"|"
	   
	 + linktel +"|"
	   
	 + stime +"|"
	   
	 + linkemail +"|"
	   
	 + price +"|"
	   
	 + beizhu +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3 +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + paystate +"|"
	   
	 + stopid +"|"
	   
	 + state
	 + "]";
 } 

}
