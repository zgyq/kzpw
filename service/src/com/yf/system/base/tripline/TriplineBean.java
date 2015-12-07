/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.tripline;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *旅行线路
 */
public class TriplineBean implements java.io.Serializable{

	/**
	  *旅行线路 表名
	  */
	public static final String TABLE  = "T_TRIPLINE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
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
	  *简介 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *起价 列名 
	  */
    public static final String COL_startprice  = "C_STARTPRICE";
	
	/**
	  *优惠价 列名 
	  */
    public static final String COL_proprice  = "C_PROPRICE";
	
	/**
	  *报名要求 列名 
	  */
    public static final String COL_predesc  = "C_PREDESC";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *出发班期 列名 
	  */
    public static final String COL_startrange  = "C_STARTRANGE";
	
	/**
	  *旅行社ID 列名 
	  */
    public static final String COL_customeragentid  = "C_CUSTOMERAGENTID";
	
	/**
	  *出发日期 列名 
	  */
    public static final String COL_startdate  = "C_STARTDATE";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_image  = "C_IMAGE";
	
	/**
	  *目的地城市 列名 
	  */
    public static final String COL_endcityid  = "C_ENDCITYID";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *旅游线路类型 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
    
    /**
     * 旅游线路 长线路名称
     */
    public static final String COL_longname = "C_LONGNAME";

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//简介
	private String description;    
    

	//价格
	private Float price;    
    

	//起价
	private Float startprice;    
    

	//优惠价
	private Float proprice;    
    

	//报名要求
	private String predesc;    
    

	//出发城市
	private Long cityid;    
    

	//出发班期
	private String startrange;    
    

	//旅行社ID
	private Long customeragentid;    
    

	//出发日期
	private String startdate;    
    

	//图片
	private String image;    
    

	//目的地城市
	private Long endcityid;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//旅游线路类型
	private Long typeid; 

	private String longname;
    

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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
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
	 * get简介
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set简介
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get价格
	 */
    public Float getPrice(){
         return price;
    }

	/**
	 * set价格
	 */
    public void setPrice(Float price){
         this.price=price;
    }

	/**
	 * get起价
	 */
    public Float getStartprice(){
         return startprice;
    }

	/**
	 * set起价
	 */
    public void setStartprice(Float startprice){
         this.startprice=startprice;
    }

	/**
	 * get优惠价
	 */
    public Float getProprice(){
         return proprice;
    }

	/**
	 * set优惠价
	 */
    public void setProprice(Float proprice){
         this.proprice=proprice;
    }

	/**
	 * get报名要求
	 */
    public String getPredesc(){
         return predesc;
    }

	/**
	 * set报名要求
	 */
    public void setPredesc(String predesc){
         this.predesc=predesc;
    }

	/**
	 * get出发城市
	 */
    public Long getCityid(){
         return cityid;
    }

	/**
	 * set出发城市
	 */
    public void setCityid(Long cityid){
         this.cityid=cityid;
    }

	/**
	 * get出发班期
	 */
    public String getStartrange(){
         return startrange;
    }

	/**
	 * set出发班期
	 */
    public void setStartrange(String startrange){
         this.startrange=startrange;
    }

	/**
	 * get旅行社ID
	 */
    public Long getCustomeragentid(){
         return customeragentid;
    }

	/**
	 * set旅行社ID
	 */
    public void setCustomeragentid(Long customeragentid){
         this.customeragentid=customeragentid;
    }

	/**
	 * get出发日期
	 */
    public String getStartdate(){
         return startdate;
    }

	/**
	 * set出发日期
	 */
    public void setStartdate(String startdate){
         this.startdate=startdate;
    }

	/**
	 * get图片
	 */
    public String getImage(){
         return image;
    }

	/**
	 * set图片
	 */
    public void setImage(String image){
         this.image=image;
    }

	/**
	 * get目的地城市
	 */
    public Long getEndcityid(){
         return endcityid;
    }

	/**
	 * set目的地城市
	 */
    public void setEndcityid(Long endcityid){
         this.endcityid=endcityid;
    }

	/**
	 * get父编号
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * set父编号
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语言类型
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }

	/**
	 * get旅游线路类型
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set旅游线路类型
	 */
    public void setTypeid(Long typeid){
         this.typeid=typeid;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + description +"|"
	   
	 + price +"|"
	   
	 + startprice +"|"
	   
	 + proprice +"|"
	   
	 + predesc +"|"
	   
	 + cityid +"|"
	   
	 + startrange +"|"
	   
	 + customeragentid +"|"
	   
	 + startdate +"|"
	   
	 + image +"|"
	   
	 + endcityid +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + typeid+"|"
	 + longname 
	 + "]";
 }

	public String getLongname() {
		return longname;
	}

	public void setLongname(String longname) {
		this.longname = longname;
	} 

}
