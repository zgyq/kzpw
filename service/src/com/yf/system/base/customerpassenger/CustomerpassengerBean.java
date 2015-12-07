/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customerpassenger;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *常用旅客
 */
public class CustomerpassengerBean implements java.io.Serializable{

	/**
	  *常用旅客 表名
	  */
	public static final String TABLE  = "T_CUSTOMERPASSENGER";

	/**
	  *旅客编号 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *旅客姓名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *电子邮箱 列名 
	  */
    public static final String COL_memberemail  = "C_MEMBEREMAIL";
	
	/**
	  *手机号 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_customeruserid  = "C_CUSTOMERUSERID";
	
	/**
	  *排列顺序 列名 
	  */
    public static final String COL_sortid  = "C_SORTID";
	
	/**
	  *地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *客户英文名 列名 
	  */
    public static final String COL_enname  = "C_Enname";
	
	/**
	  *入境时间 列名 
	  */
    public static final String COL_entrytime  = "C_ENTRYTIME";
	
	/**
	  *居留证件种类 列名 
	  */
    public static final String COL_livingcardtype  = "C_LIVINGCARDTYPE";
	
	/**
	  *居留证件号码 列名 
	  */
    public static final String COL_livingcardnum  = "C_LIVINGCARDNUM";
	
	/**
	  *居留证件有效期 列名 
	  */
    public static final String COL_livingperiod  = "C_LIVINGPERIOD";
	
	/**
	  *就业证号码 列名 
	  */
    public static final String COL_worknumber  = "C_WORKNUMBER";
	
	/**
	  *就业证有效期 列名 
	  */
    public static final String COL_workperiod  = "C_WORKPERIOD";
	
	/**
	  *在华地址 列名 
	  */
    public static final String COL_chinaaddress  = "C_CHINAADDRESS";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_sex  = "C_SEX";
    
    /**
	  *状态 列名 
	  */
   public static final String COL_state  = "C_STATE";

	//旅客编号
	private long id;    
    

	//旅客姓名
	private String username;    
    

	//电子邮箱
	private String memberemail;    
    

	//手机号
	private String mobile;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//类型
	private Integer type;    
	
	//状态
	private Integer state;    
    

	//会员ID
	private Long customeruserid;    
    

	//排列顺序
	private Long sortid;    
    

	//地址
	private String address;    
    

	//客户英文名
	private String enname;    
    

	//入境时间
	private String entrytime;    
    

	//居留证件种类
	private String livingcardtype;    
    

	//居留证件号码
	private String livingcardnum;    
    

	//居留证件有效期
	private String livingperiod;    
    

	//就业证号码
	private String worknumber;    
    

	//就业证有效期
	private String workperiod;    
    

	//在华地址
	private String chinaaddress;    
    

	//性别
	private String sex;    
    

	/**
	 * get旅客编号
	 */
    public long getId(){
         return id;
    }

	/**
	 * set旅客编号
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get旅客姓名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set旅客姓名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get电子邮箱
	 */
    public String getMemberemail(){
         return memberemail;
    }

	/**
	 * set电子邮箱
	 */
    public void setMemberemail(String memberemail){
         this.memberemail=memberemail;
    }

	/**
	 * get手机号
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机号
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
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
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
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

	/**
	 * get类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set类型
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get会员ID
	 */
    public Long getCustomeruserid(){
         return customeruserid;
    }

	/**
	 * set会员ID
	 */
    public void setCustomeruserid(Long customeruserid){
         this.customeruserid=customeruserid;
    }

	/**
	 * get排列顺序
	 */
    public Long getSortid(){
         return sortid;
    }

	/**
	 * set排列顺序
	 */
    public void setSortid(Long sortid){
         this.sortid=sortid;
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
	 * get客户英文名
	 */
    public String getEnname(){
         return enname;
    }

	/**
	 * set客户英文名
	 */
    public void setEnname(String enname){
         this.enname=enname;
    }

	/**
	 * get入境时间
	 */
    public String getEntrytime(){
         return entrytime;
    }

	/**
	 * set入境时间
	 */
    public void setEntrytime(String entrytime){
         this.entrytime=entrytime;
    }

	/**
	 * get居留证件种类
	 */
    public String getLivingcardtype(){
         return livingcardtype;
    }

	/**
	 * set居留证件种类
	 */
    public void setLivingcardtype(String livingcardtype){
         this.livingcardtype=livingcardtype;
    }

	/**
	 * get居留证件号码
	 */
    public String getLivingcardnum(){
         return livingcardnum;
    }

	/**
	 * set居留证件号码
	 */
    public void setLivingcardnum(String livingcardnum){
         this.livingcardnum=livingcardnum;
    }

	/**
	 * get居留证件有效期
	 */
    public String getLivingperiod(){
         return livingperiod;
    }

	/**
	 * set居留证件有效期
	 */
    public void setLivingperiod(String livingperiod){
         this.livingperiod=livingperiod;
    }

	/**
	 * get就业证号码
	 */
    public String getWorknumber(){
         return worknumber;
    }

	/**
	 * set就业证号码
	 */
    public void setWorknumber(String worknumber){
         this.worknumber=worknumber;
    }

	/**
	 * get就业证有效期
	 */
    public String getWorkperiod(){
         return workperiod;
    }

	/**
	 * set就业证有效期
	 */
    public void setWorkperiod(String workperiod){
         this.workperiod=workperiod;
    }

	/**
	 * get在华地址
	 */
    public String getChinaaddress(){
         return chinaaddress;
    }

	/**
	 * set在华地址
	 */
    public void setChinaaddress(String chinaaddress){
         this.chinaaddress=chinaaddress;
    }

	/**
	 * get性别
	 */
    public String getSex(){
         return sex;
    }

	/**
	 * set性别
	 */
    public void setSex(String sex){
         this.sex=sex;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + username +"|"
	   
	 + memberemail +"|"
	   
	 + mobile +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + type +"|"
	   
	 + customeruserid +"|"
	   
	 + sortid +"|"
	   
	 + address+"|"
	 
	 + enname +"|"
	   
	 + entrytime +"|"
	   
	 + livingcardtype +"|"
	   
	 + livingcardnum +"|"
	   
	 + livingperiod +"|"
	   
	 + worknumber +"|"
	   
	 + workperiod +"|"
	   
	 + chinaaddress +"|"
	 
	 + state+"|"
	   
	 + sex
	 + "]";
 }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	} 

}
