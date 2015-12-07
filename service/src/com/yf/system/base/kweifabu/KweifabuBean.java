/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.kweifabu;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *K位特价发布表
 */
public class KweifabuBean implements java.io.Serializable{

	/**
	  *K位特价发布表 表名
	  */
	public static final String TABLE  = "T_KWEIFABU";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *供应商ID 列名 
	  */
    public static final String COL_angenid  = "C_TYPEID";
	
	/**
	  *航班类型 列名 
	  */
    public static final String COL_flighttype  = "C_FLIGHTTYPE";
	
	/**
	  *航空公司 列名 
	  */
    public static final String COL_ca  = "C_CA";
	
	/**
	  *出发时间 列名 
	  */
    public static final String COL_starttime  = "C_STARTTIME";
	
	/**
	  *出发城市 列名 
	  */
    public static final String COL_startcity  = "C_STARTCITY";
	
	/**
	  *到达城市 列名 
	  */
    public static final String COL_endcity  = "C_ENDCITY";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *舱位码 列名 
	  */
    public static final String COL_cabincode  = "C_CABINCODE";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *票面价 列名 
	  */
    public static final String COL_nominalprice  = "C_NOMINALPRICE";
	
	/**
	  *折扣 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *税率 列名 
	  */
    public static final String COL_taxrate  = "C_TAXRATE";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_comment  = "C_COMMENT";
	
	/**
	  *结算价 列名 
	  */
    public static final String COL_settlementprice  = "C_SETTLEMENTPRICE";
	
	/**
	  *政策 列名 
	  */
    public static final String COL_policy  = "C_POLICY";
	
	/**
	  *乘客类型 列名 
	  */
    public static final String COL_usertype  = "C_USERTYPE";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";

	//ID
	private long id;    
    

	//供应商ID
	private Long angenid;    
    

	//航班类型
	private Long flighttype;    
    

	//航空公司
	private String ca;    
    

	//出发时间
	private Timestamp starttime;    
    

	//出发城市
	private String startcity;    
    

	//到达城市
	private String endcity;    
    

	//航班号
	private String flightnumber;    
    

	//舱位码
	private String cabincode;    
    

	//创建时间
	private Timestamp createtime;    
    

	//票面价
	private Double nominalprice;    
    

	//折扣
	private String discount;    
    

	//税率
	private String taxrate;    
    

	//备注
	private String comment;    
    

	//结算价
	private Double settlementprice;    
    

	//政策
	private Long policy;    
    

	//乘客类型
	private Long usertype;    
    

	//创建者
	private String createuser;    
    

	//状态
	private Long status;    
    

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
	 * get供应商ID
	 */
    public Long getAngenid(){
         return angenid;
    }

	/**
	 * set供应商ID
	 */
    public void setAngenid(Long angenid){
         this.angenid=angenid;
    }

	/**
	 * get航班类型
	 */
    public Long getFlighttype(){
         return flighttype;
    }

	/**
	 * set航班类型
	 */
    public void setFlighttype(Long flighttype){
         this.flighttype=flighttype;
    }

	/**
	 * get航空公司
	 */
    public String getCa(){
         return ca;
    }

	/**
	 * set航空公司
	 */
    public void setCa(String ca){
         this.ca=ca;
    }

	/**
	 * get出发时间
	 */
    public Timestamp getStarttime(){
         return starttime;
    }

	/**
	 * set出发时间
	 */
    public void setStarttime(Timestamp starttime){
         this.starttime=starttime;
    }

	/**
	 * get出发城市
	 */
    public String getStartcity(){
         return startcity;
    }

	/**
	 * set出发城市
	 */
    public void setStartcity(String startcity){
         this.startcity=startcity;
    }

	/**
	 * get到达城市
	 */
    public String getEndcity(){
         return endcity;
    }

	/**
	 * set到达城市
	 */
    public void setEndcity(String endcity){
         this.endcity=endcity;
    }

	/**
	 * get航班号
	 */
    public String getFlightnumber(){
         return flightnumber;
    }

	/**
	 * set航班号
	 */
    public void setFlightnumber(String flightnumber){
         this.flightnumber=flightnumber;
    }

	/**
	 * get舱位码
	 */
    public String getCabincode(){
         return cabincode;
    }

	/**
	 * set舱位码
	 */
    public void setCabincode(String cabincode){
         this.cabincode=cabincode;
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
	 * get票面价
	 */
    public Double getNominalprice(){
         return nominalprice;
    }

	/**
	 * set票面价
	 */
    public void setNominalprice(Double nominalprice){
         this.nominalprice=nominalprice;
    }

	/**
	 * get折扣
	 */
    public String getDiscount(){
         return discount;
    }

	/**
	 * set折扣
	 */
    public void setDiscount(String discount){
         this.discount=discount;
    }

	/**
	 * get税率
	 */
    public String getTaxrate(){
         return taxrate;
    }

	/**
	 * set税率
	 */
    public void setTaxrate(String taxrate){
         this.taxrate=taxrate;
    }

	/**
	 * get备注
	 */
    public String getComment(){
         return comment;
    }

	/**
	 * set备注
	 */
    public void setComment(String comment){
         this.comment=comment;
    }

	/**
	 * get结算价
	 */
    public Double getSettlementprice(){
         return settlementprice;
    }

	/**
	 * set结算价
	 */
    public void setSettlementprice(Double settlementprice){
         this.settlementprice=settlementprice;
    }

	/**
	 * get政策
	 */
    public Long getPolicy(){
         return policy;
    }

	/**
	 * set政策
	 */
    public void setPolicy(Long policy){
         this.policy=policy;
    }

	/**
	 * get乘客类型
	 */
    public Long getUsertype(){
         return usertype;
    }

	/**
	 * set乘客类型
	 */
    public void setUsertype(Long usertype){
         this.usertype=usertype;
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
	 * get状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Long status){
         this.status=status;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + angenid +"|"
	   
	 + flighttype +"|"
	   
	 + ca +"|"
	   
	 + starttime +"|"
	   
	 + startcity +"|"
	   
	 + endcity +"|"
	   
	 + flightnumber +"|"
	   
	 + cabincode +"|"
	   
	 + createtime +"|"
	   
	 + nominalprice +"|"
	   
	 + discount +"|"
	   
	 + taxrate +"|"
	   
	 + comment +"|"
	   
	 + settlementprice +"|"
	   
	 + policy +"|"
	   
	 + usertype +"|"
	   
	 + createuser +"|"
	   
	 + status
	 + "]";
 } 

}
