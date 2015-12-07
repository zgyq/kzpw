/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.planeservice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *包机服务
 */
public class PlaneserviceBean implements java.io.Serializable{

	/**
	  *包机服务 表名
	  */
	public static final String TABLE  = "T_PLANESERVICE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *出行时间 列名 
	  */
    public static final String COL_traveltime  = "C_TRAVELTIME";
	
	/**
	  *回程时间 列名 
	  */
    public static final String COL_returntime  = "C_RETURNTIME";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_travelcity  = "C_TRAVELCITY";
	
	/**
	  *到达城市 列名 
	  */
    public static final String COL_returncity  = "C_RETURNCITY";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_num  = "C_NUM";
	
	/**
	  *联系人 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *单位名字 列名 
	  */
    public static final String COL_unitname  = "C_UNITNAME";
	
	/**
	  *联系地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *邮编 列名 
	  */
    public static final String COL_zipcode  = "C_ZIPCODE";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *传真 列名 
	  */
    public static final String COL_fax  = "C_FAX";
	
	/**
	  *邮箱 列名 
	  */
    public static final String COL_mailbox  = "C_MAILBOX";
	
	/**
	  *机型 列名 
	  */
    public static final String COL_model  = "C_MODEL";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_remarks  = "C_REMARKS";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//出行时间
	private String traveltime;    
    

	//回程时间
	private String returntime;    
    

	//出发城市
	private String travelcity;    
    

	//到达城市
	private String returncity;    
    

	//人数
	private String num;    
    

	//联系人
	private String name;    
    

	//手机
	private String mobile;    
    

	//单位名字
	private String unitname;    
    

	//联系地址
	private String address;    
    

	//邮编
	private String zipcode;    
    

	//电话
	private String tel;    
    

	//传真
	private String fax;    
    

	//邮箱
	private String mailbox;    
    

	//机型
	private String model;    
    

	//备注
	private String remarks;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
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
	 * get出行时间
	 */
    public String getTraveltime(){
         return traveltime;
    }

	/**
	 * set出行时间
	 */
    public void setTraveltime(String traveltime){
         this.traveltime=traveltime;
    }

	/**
	 * get回程时间
	 */
    public String getReturntime(){
         return returntime;
    }

	/**
	 * set回程时间
	 */
    public void setReturntime(String returntime){
         this.returntime=returntime;
    }

	/**
	 * get出发城市
	 */
    public String getTravelcity(){
         return travelcity;
    }

	/**
	 * set出发城市
	 */
    public void setTravelcity(String travelcity){
         this.travelcity=travelcity;
    }

	/**
	 * get到达城市
	 */
    public String getReturncity(){
         return returncity;
    }

	/**
	 * set到达城市
	 */
    public void setReturncity(String returncity){
         this.returncity=returncity;
    }

	/**
	 * get人数
	 */
    public String getNum(){
         return num;
    }

	/**
	 * set人数
	 */
    public void setNum(String num){
         this.num=num;
    }

	/**
	 * get联系人
	 */
    public String getName(){
         return name;
    }

	/**
	 * set联系人
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get单位名字
	 */
    public String getUnitname(){
         return unitname;
    }

	/**
	 * set单位名字
	 */
    public void setUnitname(String unitname){
         this.unitname=unitname;
    }

	/**
	 * get联系地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set联系地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get邮编
	 */
    public String getZipcode(){
         return zipcode;
    }

	/**
	 * set邮编
	 */
    public void setZipcode(String zipcode){
         this.zipcode=zipcode;
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
	 * get传真
	 */
    public String getFax(){
         return fax;
    }

	/**
	 * set传真
	 */
    public void setFax(String fax){
         this.fax=fax;
    }

	/**
	 * get邮箱
	 */
    public String getMailbox(){
         return mailbox;
    }

	/**
	 * set邮箱
	 */
    public void setMailbox(String mailbox){
         this.mailbox=mailbox;
    }

	/**
	 * get机型
	 */
    public String getModel(){
         return model;
    }

	/**
	 * set机型
	 */
    public void setModel(String model){
         this.model=model;
    }

	/**
	 * get备注
	 */
    public String getRemarks(){
         return remarks;
    }

	/**
	 * set备注
	 */
    public void setRemarks(String remarks){
         this.remarks=remarks;
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
	 * get创建人id
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set创建人id
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
	   
	 + traveltime +"|"
	   
	 + returntime +"|"
	   
	 + travelcity +"|"
	   
	 + returncity +"|"
	   
	 + num +"|"
	   
	 + name +"|"
	   
	 + mobile +"|"
	   
	 + unitname +"|"
	   
	 + address +"|"
	   
	 + zipcode +"|"
	   
	 + tel +"|"
	   
	 + fax +"|"
	   
	 + mailbox +"|"
	   
	 + model +"|"
	   
	 + remarks +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + state
	 + "]";
 } 

}
