/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.spzrate;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *特价政策表
 */
public class SpzrateBean implements java.io.Serializable{

	/**
	  *特价政策表 表名
	  */
	public static final String TABLE  = "T_SPZRATE";

	
	/**
	  *政策ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *起飞机场 列名 
	  */
    public static final String COL_departureport  = "C_DEPARTUREPORT";
	
	/**
	  *到达机场 列名 
	  */
    public static final String COL_arrivalport  = "C_ARRIVALPORT";
	
	/**
	  *行程类型 列名 
	  */
    public static final String COL_traveltype  = "C_TRAVELTYPE";
	
	/**
	  *利润方式 列名 
	  */
    public static final String COL_outpattern  = "C_OUTPATTERN";
	
	/**
	  *留钱 列名 
	  */
    public static final String COL_moneykeep  = "C_MONEYKEEP";
	
	/**
	  *留点 列名 
	  */
    public static final String COL_pointkeep  = "C_POINTKEEP";
	
	/**
	  *航班号 列名 
	  */
    public static final String COL_flightnumber  = "C_FLIGHTNUMBER";
	
	/**
	  *舱位码 列名 
	  */
    public static final String COL_cabincode  = "C_CABINCODE";
	
	/**
	  *返点 列名 
	  */
    public static final String COL_ratevalue  = "C_RATEVALUE";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改人 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *出票开始日期 列名 
	  */
    public static final String COL_issuedstartdate  = "C_ISSUEDSTARTDATE";
	
	/**
	  *出票结束日期 列名 
	  */
    public static final String COL_issuedendate  = "C_ISSUEDENDATE";
	
	/**
	  *备注信息 列名 
	  */
    public static final String COL_remark  = "C_REMARK";
	
	/**
	  *航班限制 列名 
	  */
    public static final String COL_weeknum  = "C_WEEKNUM";
	
	/**
	  *政策状态(0=禁用,1=启用) 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *航空公司两字代码 列名 
	  */
    public static final String COL_aircompanycode  = "C_AIRCOMPANYCODE";
	
	/**
	  *供应商ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *票证类型(1=BSP,2=B2B) 列名 
	  */
    public static final String COL_tickettype  = "C_TICKETTYPE";
	
	/**
	  *关联政策ID 列名 
	  */
    public static final String COL_relationspzrateid  = "C_RELATIONSPZRATEID";
	
	/**
	  *供应商编号 列名 
	  */
    public static final String COL_agentcode  = "C_AGENTCODE";
	
	/**
	  *适用类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *是否自动出票 列名 
	  */
    public static final String COL_isauto  = "C_ISAUTO";
	
	/**
	  *是否需转换记录 列名 
	  */
    public static final String COL_ischange  = "C_ISCHANGE";
	
	/**
	  *本地分销政策 列名 
	  */
    public static final String COL_localspzrate  = "C_LOCALSPZRATE";
	
	/**
	  *加返政策 列名 
	  */
    public static final String COL_addratevalue  = "C_ADDRATEVALUE";
	
	/**
	  *是否普通政策 列名 
	  */
    public static final String COL_general  = "C_GENERAL";
	
	/**
	  *出票方式 列名 
	  */
    public static final String COL_poll  = "C_POLL";
	
	/**
	  *政策类型出港入港 列名 
	  */
    public static final String COL_zratetype  = "C_ZRATETYPE";

	//政策ID
	private long id;    
    

	//起飞机场
	private String departureport;    
    

	//到达机场
	private String arrivalport;    
    

	//行程类型
	private Integer traveltype;    
    

	//利润方式
	private String outpattern;    
    

	//留钱
	private Integer moneykeep;    
    

	//留点
	private Integer pointkeep;    
    

	//航班号
	private String flightnumber;    
    

	//舱位码
	private String cabincode;    
    

	//返点
	private Float ratevalue;    
    

	//创建人
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改人
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//出票开始日期
	private Timestamp issuedstartdate;    
    

	//出票结束日期
	private Timestamp issuedendate;    
    

	//备注信息
	private String remark;    
    

	//航班限制
	private String weeknum;    
    

	//政策状态(0=禁用,1=启用)
	private Integer isenable;    
    

	//航空公司两字代码
	private String aircompanycode;    
    

	//供应商ID
	private Long agentid;    
    

	//票证类型(1=BSP,2=B2B)
	private Integer tickettype;    
    

	//关联政策ID
	private Long relationspzrateid;    
    

	//供应商编号
	private String agentcode;    
    

	//适用类型
	private Integer type;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//是否自动出票
	private Long isauto;    
    

	//是否需转换记录
	private Long ischange;    
    

	//本地分销政策
	private Float localspzrate;    
    

	//加返政策
	private Float addratevalue;    
    

	//是否普通政策
	private Long general;    
    

	//出票方式
	private Long poll;    
    

	//政策类型出港入港
	private Long zratetype;    
    

	/**
	 * get政策ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set政策ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get起飞机场
	 */
    public String getDepartureport(){
         return departureport;
    }

	/**
	 * set起飞机场
	 */
    public void setDepartureport(String departureport){
         this.departureport=departureport;
    }

	/**
	 * get到达机场
	 */
    public String getArrivalport(){
         return arrivalport;
    }

	/**
	 * set到达机场
	 */
    public void setArrivalport(String arrivalport){
         this.arrivalport=arrivalport;
    }

	/**
	 * get行程类型
	 */
    public Integer getTraveltype(){
         return traveltype;
    }

	/**
	 * set行程类型
	 */
    public void setTraveltype(Integer traveltype){
         this.traveltype=traveltype;
    }

	/**
	 * get利润方式
	 */
    public String getOutpattern(){
         return outpattern;
    }

	/**
	 * set利润方式
	 */
    public void setOutpattern(String outpattern){
         this.outpattern=outpattern;
    }

	/**
	 * get留钱
	 */
    public Integer getMoneykeep(){
         return moneykeep;
    }

	/**
	 * set留钱
	 */
    public void setMoneykeep(Integer moneykeep){
         this.moneykeep=moneykeep;
    }

	/**
	 * get留点
	 */
    public Integer getPointkeep(){
         return pointkeep;
    }

	/**
	 * set留点
	 */
    public void setPointkeep(Integer pointkeep){
         this.pointkeep=pointkeep;
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
	 * get返点
	 */
    public Float getRatevalue(){
         return ratevalue;
    }

	/**
	 * set返点
	 */
    public void setRatevalue(Float ratevalue){
         this.ratevalue=ratevalue;
    }

	/**
	 * get创建人
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建人
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
	 * get修改人
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改人
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
	 * get出票开始日期
	 */
    public Timestamp getIssuedstartdate(){
         return issuedstartdate;
    }

	/**
	 * set出票开始日期
	 */
    public void setIssuedstartdate(Timestamp issuedstartdate){
         this.issuedstartdate=issuedstartdate;
    }

	/**
	 * get出票结束日期
	 */
    public Timestamp getIssuedendate(){
         return issuedendate;
    }

	/**
	 * set出票结束日期
	 */
    public void setIssuedendate(Timestamp issuedendate){
         this.issuedendate=issuedendate;
    }

	/**
	 * get备注信息
	 */
    public String getRemark(){
         return remark;
    }

	/**
	 * set备注信息
	 */
    public void setRemark(String remark){
         this.remark=remark;
    }

	/**
	 * get航班限制
	 */
    public String getWeeknum(){
         return weeknum;
    }

	/**
	 * set航班限制
	 */
    public void setWeeknum(String weeknum){
         this.weeknum=weeknum;
    }

	/**
	 * get政策状态(0=禁用,1=启用)
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set政策状态(0=禁用,1=启用)
	 */
    public void setIsenable(Integer isenable){
         this.isenable=isenable;
    }

	/**
	 * get航空公司两字代码
	 */
    public String getAircompanycode(){
         return aircompanycode;
    }

	/**
	 * set航空公司两字代码
	 */
    public void setAircompanycode(String aircompanycode){
         this.aircompanycode=aircompanycode;
    }

	/**
	 * get供应商ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set供应商ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get票证类型(1=BSP,2=B2B)
	 */
    public Integer getTickettype(){
         return tickettype;
    }

	/**
	 * set票证类型(1=BSP,2=B2B)
	 */
    public void setTickettype(Integer tickettype){
         this.tickettype=tickettype;
    }

	/**
	 * get关联政策ID
	 */
    public Long getRelationspzrateid(){
         return relationspzrateid;
    }

	/**
	 * set关联政策ID
	 */
    public void setRelationspzrateid(Long relationspzrateid){
         this.relationspzrateid=relationspzrateid;
    }

	/**
	 * get供应商编号
	 */
    public String getAgentcode(){
         return agentcode;
    }

	/**
	 * set供应商编号
	 */
    public void setAgentcode(String agentcode){
         this.agentcode=agentcode;
    }

	/**
	 * get适用类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set适用类型
	 */
    public void setType(Integer type){
         this.type=type;
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
	 * get是否自动出票
	 */
    public Long getIsauto(){
         return isauto;
    }

	/**
	 * set是否自动出票
	 */
    public void setIsauto(Long isauto){
         this.isauto=isauto;
    }

	/**
	 * get是否需转换记录
	 */
    public Long getIschange(){
         return ischange;
    }

	/**
	 * set是否需转换记录
	 */
    public void setIschange(Long ischange){
         this.ischange=ischange;
    }

	/**
	 * get本地分销政策
	 */
    public Float getLocalspzrate(){
         return localspzrate;
    }

	/**
	 * set本地分销政策
	 */
    public void setLocalspzrate(Float localspzrate){
         this.localspzrate=localspzrate;
    }

	/**
	 * get加返政策
	 */
    public Float getAddratevalue(){
         return addratevalue;
    }

	/**
	 * set加返政策
	 */
    public void setAddratevalue(Float addratevalue){
         this.addratevalue=addratevalue;
    }

	/**
	 * get是否普通政策
	 */
    public Long getGeneral(){
         return general;
    }

	/**
	 * set是否普通政策
	 */
    public void setGeneral(Long general){
         this.general=general;
    }

	/**
	 * get出票方式
	 */
    public Long getPoll(){
         return poll;
    }

	/**
	 * set出票方式
	 */
    public void setPoll(Long poll){
         this.poll=poll;
    }

	/**
	 * get政策类型出港入港
	 */
    public Long getZratetype(){
         return zratetype;
    }

	/**
	 * set政策类型出港入港
	 */
    public void setZratetype(Long zratetype){
         this.zratetype=zratetype;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + departureport +"|"
	   
	 + arrivalport +"|"
	   
	 + traveltype +"|"
	   
	 + outpattern +"|"
	   
	 + moneykeep +"|"
	   
	 + pointkeep +"|"
	   
	 + flightnumber +"|"
	   
	 + cabincode +"|"
	   
	 + ratevalue +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + issuedstartdate +"|"
	   
	 + issuedendate +"|"
	   
	 + remark +"|"
	   
	 + weeknum +"|"
	   
	 + isenable +"|"
	   
	 + aircompanycode +"|"
	   
	 + agentid +"|"
	   
	 + tickettype +"|"
	   
	 + relationspzrateid +"|"
	   
	 + agentcode +"|"
	   
	 + type +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + isauto +"|"
	   
	 + ischange +"|"
	   
	 + localspzrate +"|"
	   
	 + addratevalue +"|"
	   
	 + general +"|"
	   
	 + poll +"|"
	   
	 + zratetype
	 + "]";
 } 

}
