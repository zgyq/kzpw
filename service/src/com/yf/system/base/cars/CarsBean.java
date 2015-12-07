/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.cars;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *汽车列表
 */
public class CarsBean implements java.io.Serializable{

	/**
	  *汽车列表 表名
	  */
	public static final String TABLE  = "T_CARS";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *车型名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *车型编号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *车型简单描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *周1到周4每日单价（不包括保险费，手续费等） 列名 
	  */
    public static final String COL_weekdayprice  = "C_WEEKDAYPRICE";
	
	/**
	  *周5到周日每日单价（不包括保险费，手续费等） 列名 
	  */
    public static final String COL_Weekendprice  = "C_WEEKENDPRICE";
	
	/**
	  *节假日每日单价 列名 
	  */
    public static final String COL_holidayprice  = "C_HOLIDAYPRICE";
	
	/**
	  *节假日名称 列名 
	  */
    public static final String COL_holidayname  = "C_HOLIDAYNAME";
	
	/**
	  *每日保险 列名 
	  */
    public static final String COL_insurancefee  = "C_INSURANCEFEE";
	
	/**
	  *租车手续费 列名 
	  */
    public static final String COL_servicefee  = "C_SERVICEFEE";
	
	/**
	  *信用卡预授权费用 列名 
	  */
    public static final String COL_preauthfee  = "C_PREAUTHFEE";
	
	/**
	  *超时费（元/小时） 列名 
	  */
    public static final String COL_extimefee  = "C_EXTIMEFWW";
	
	/**
	  *超里程费 (元/公里) 列名 
	  */
    public static final String COL_exmilefee  = "C_EXMILEFEE";
	
	/**
	  *每天可用里程(公里/天) 列名 
	  */
    public static final String COL_mile  = "C_MILE";
	
	/**
	  *库存(Y/N) 列名 
	  */
    public static final String COL_available  = "C_AVAILABLE";
	
	/**
	  *图片路径 列名 
	  */
    public static final String COL_imgurl  = "C_IMGURL";
	
	/**
	  *限座最大乘客数 列名 
	  */
    public static final String COL_maxpassenger  = "C_MAXPASSENGER";
	
	/**
	  *品牌 列名 
	  */
    public static final String COL_ppai  = "C_Ppai";
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *门店ID 列名 
	  */
    public static final String COL_carstoreid  = "C_CARSTOREID";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_sort  = "C_SORT";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";

	//ID
	private long id;    
    

	//车型名称
	private String name;    
    

	//车型编号
	private String code;    
    

	//车型简单描述
	private String description;    
    

	//周1到周4每日单价（不包括保险费，手续费等）
	private String weekdayprice;    
    

	//周5到周日每日单价（不包括保险费，手续费等）
	private String Weekendprice;    
    

	//节假日每日单价
	private String holidayprice;    
    

	//节假日名称
	private String holidayname;    
    

	//每日保险
	private String insurancefee;    
    

	//租车手续费
	private String servicefee;    
    

	//信用卡预授权费用
	private String preauthfee;    
    

	//超时费（元/小时）
	private String extimefee;    
    

	//超里程费 (元/公里)
	private String exmilefee;    
    

	//每天可用里程(公里/天)
	private String mile;    
    

	//库存(Y/N)
	private String available;    
    

	//图片路径
	private String imgurl;    
    

	//限座最大乘客数
	private String maxpassenger;    
    

	//品牌
	private String ppai;    
    

	//城市ID
	private Long cityid;    
    

	//门店ID
	private Long carstoreid;    
    

	//排序
	private Long sort;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建者
	private String createuser;    
    

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
	 * get车型名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set车型名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get车型编号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set车型编号
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get车型简单描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set车型简单描述
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get周1到周4每日单价（不包括保险费，手续费等）
	 */
    public String getWeekdayprice(){
         return weekdayprice;
    }

	/**
	 * set周1到周4每日单价（不包括保险费，手续费等）
	 */
    public void setWeekdayprice(String weekdayprice){
         this.weekdayprice=weekdayprice;
    }

	/**
	 * get周5到周日每日单价（不包括保险费，手续费等）
	 */
    public String getWeekendprice(){
         return Weekendprice;
    }

	/**
	 * set周5到周日每日单价（不包括保险费，手续费等）
	 */
    public void setWeekendprice(String Weekendprice){
         this.Weekendprice=Weekendprice;
    }

	/**
	 * get节假日每日单价
	 */
    public String getHolidayprice(){
         return holidayprice;
    }

	/**
	 * set节假日每日单价
	 */
    public void setHolidayprice(String holidayprice){
         this.holidayprice=holidayprice;
    }

	/**
	 * get节假日名称
	 */
    public String getHolidayname(){
         return holidayname;
    }

	/**
	 * set节假日名称
	 */
    public void setHolidayname(String holidayname){
         this.holidayname=holidayname;
    }

	/**
	 * get每日保险
	 */
    public String getInsurancefee(){
         return insurancefee;
    }

	/**
	 * set每日保险
	 */
    public void setInsurancefee(String insurancefee){
         this.insurancefee=insurancefee;
    }

	/**
	 * get租车手续费
	 */
    public String getServicefee(){
         return servicefee;
    }

	/**
	 * set租车手续费
	 */
    public void setServicefee(String servicefee){
         this.servicefee=servicefee;
    }

	/**
	 * get信用卡预授权费用
	 */
    public String getPreauthfee(){
         return preauthfee;
    }

	/**
	 * set信用卡预授权费用
	 */
    public void setPreauthfee(String preauthfee){
         this.preauthfee=preauthfee;
    }

	/**
	 * get超时费（元/小时）
	 */
    public String getExtimefee(){
         return extimefee;
    }

	/**
	 * set超时费（元/小时）
	 */
    public void setExtimefee(String extimefee){
         this.extimefee=extimefee;
    }

	/**
	 * get超里程费 (元/公里)
	 */
    public String getExmilefee(){
         return exmilefee;
    }

	/**
	 * set超里程费 (元/公里)
	 */
    public void setExmilefee(String exmilefee){
         this.exmilefee=exmilefee;
    }

	/**
	 * get每天可用里程(公里/天)
	 */
    public String getMile(){
         return mile;
    }

	/**
	 * set每天可用里程(公里/天)
	 */
    public void setMile(String mile){
         this.mile=mile;
    }

	/**
	 * get库存(Y/N)
	 */
    public String getAvailable(){
         return available;
    }

	/**
	 * set库存(Y/N)
	 */
    public void setAvailable(String available){
         this.available=available;
    }

	/**
	 * get图片路径
	 */
    public String getImgurl(){
         return imgurl;
    }

	/**
	 * set图片路径
	 */
    public void setImgurl(String imgurl){
         this.imgurl=imgurl;
    }

	/**
	 * get限座最大乘客数
	 */
    public String getMaxpassenger(){
         return maxpassenger;
    }

	/**
	 * set限座最大乘客数
	 */
    public void setMaxpassenger(String maxpassenger){
         this.maxpassenger=maxpassenger;
    }

	/**
	 * get品牌
	 */
    public String getPpai(){
         return ppai;
    }

	/**
	 * set品牌
	 */
    public void setPpai(String ppai){
         this.ppai=ppai;
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
	 * get门店ID
	 */
    public Long getCarstoreid(){
         return carstoreid;
    }

	/**
	 * set门店ID
	 */
    public void setCarstoreid(Long carstoreid){
         this.carstoreid=carstoreid;
    }

	/**
	 * get排序
	 */
    public Long getSort(){
         return sort;
    }

	/**
	 * set排序
	 */
    public void setSort(Long sort){
         this.sort=sort;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + code +"|"
	   
	 + description +"|"
	   
	 + weekdayprice +"|"
	   
	 + Weekendprice +"|"
	   
	 + holidayprice +"|"
	   
	 + holidayname +"|"
	   
	 + insurancefee +"|"
	   
	 + servicefee +"|"
	   
	 + preauthfee +"|"
	   
	 + extimefee +"|"
	   
	 + exmilefee +"|"
	   
	 + mile +"|"
	   
	 + available +"|"
	   
	 + imgurl +"|"
	   
	 + maxpassenger +"|"
	   
	 + ppai +"|"
	   
	 + cityid +"|"
	   
	 + carstoreid +"|"
	   
	 + sort +"|"
	   
	 + createtime +"|"
	   
	 + createuser
	 + "]";
 } 

}
