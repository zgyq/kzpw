/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.zrate;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *普通政策表
 */
public class ZrateBean implements java.io.Serializable,Comparable{

	/**
	  *普通政策表 表名
	  */
	public static final String TABLE  = "T_ZRATE";

	
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
    public static final String COL_relationzrateid  = "C_RELATIONZRATEID";
	
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
    public static final String COL_localzrate  = "C_LOCALZRATE";
	
	/**
	  *加返政策 列名 
	  */
    public static final String COL_addratevalue  = "C_ADDRATEVALUE";
	
	/**
	  *是否普通政策 列名 
	  */
    public static final String COL_general  = "C_GENERAL";
	
	/**
	  *政策类型出港入港 列名 
	  */
    public static final String COL_zratetype  = "C_ZRATETYPE";
	
	/**
	  *开始时间 列名 
	  */
    public static final String COL_begindate  = "C_BEGINDATE";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
	/**
	  *外部Id 列名 
	  */
    public static final String COL_outid  = "C_OUTID";
	
	/**
	  *适用班期 列名 
	  */
    public static final String COL_limitdate  = "C_LIMITDATE";
	
	/**
	  *政策类型 列名 
	  */
    public static final String COL_istype  = "C_ISTYPE";
    
    /**
     * 上班时间
     */
    public static final String COL_worktime="C_WORKTIME";

    /**
     * 下班时间
     */
    public static final String COL_afterworktime="C_AFTERWORKTIME";
    
    /**
     * 航班号是否适用
     */
    public static final String COL_flightisuse="C_FLIGHTISUSE";
    
    /**
     * 今日出票速度
     */
    public static final String COL_speed="C_SPEED";
    
    /**
     * 今日交易费配置
     */
    public static final String COL_feetype="C_FEETYPE";
    
    /**
     * 今日分销商交易费
     */
    public static final String COL_agentfee="C_AGENTFEE";
    
    
    /**
     * 八千亿周1到周5上班时间
     */
    public static final String COL_onetofiveworktime="C_ONETOFIVEWORKTIME";
    
    /**
     * 八千亿周1到周5下班时间
     */
    public static final String COL_onetofiveaftertime="C_ONETOFIVEAFTERTIME";
    
    
    /**
     * 八千亿周6到周7上班时间
     */
    public static final String COL_weekendworktime="C_WEEKENDWORKTIME";
    
    /**
     * 八千亿周6到周7下班时间
     */
    public static final String COL_weekendaftertime="C_WEEKENDAFTERTIME"; 
    
    

    
    /**
     * 八千亿周1到周5废票时间
     */
    public static final String COL_onetofivewastetime="C_ONETOFIVEWASTETIME";
    
    /**
     * 八千亿周6到周7废票时间
     */
    public static final String COL_weekendwastetime="C_WEEKENDWASTETIME";
    
    
    /**
     * 政策类型(普通还是高反)
     */
    public static final String COL_ztype="C_ZTYPE";
    
   
    /**
     * 航程类型(单程or往返)
     */
    public static final String COL_voyagetype="C_VOYAGETYPE";
    
    
    /**
     * 适用的班期(如1234567)
     */
    public static final String COL_schedule="C_SCHEDULE";
    
    
    /**
     * 用户类型
     */
    public static final String COL_usertype="C_USERTYPE";
    
    
    /**
     * 工作状态
     */
    public static final String COL_workstatus="C_WORKSTATUS";
    
    /**
     * 出发不适用
     */
    public static final String COL_departureexclude="C_DEPARTUREEXCLUDE";
    
    /**
     * 抵达不适用
     */
    public static final String COL_arrivalexclude="C_ARRIVALEXCLUDE";
    
    
	//政策ID
	private long id;    
    

	//起飞机场
	private String departureport;    
    

	//到达机场
	private String arrivalport;    
    

	//行程类型
	private Integer traveltype;   
	
	//航空公司两字代码
	private String aircompanycode;    
    
	
	//使用航班号    如果此字段里面有值要判断所查询的航班是否匹配这个航班号
	private String flightnumber;    
	
	
	//航班限制(排除航班号)  
	private String weeknum;    

	
	//航程类型  返回1表示单程，返回2表示往返，返回3表示单程往返
	private String voyagetype;

	//返点 该条政策的返点,正确的返点是大于等于2.5小于50
	private Float ratevalue;  
	
	//舱位码
	private String cabincode;   
	
	//政策开始时间
	private Timestamp begindate;    
    

	//政策结束时间
	private Timestamp enddate;   
	
	//下班时间
	private String afterworktime;  
	
	//上班时间
	private String worktime; 
	
	//八千亿周1到周5上班时间
	private String onetofiveworktime;
	
	//八千亿周1到周5下班时间
	private String onetofiveaftertime;
	
	//八千亿周6到周7上班时间
	private String weekendworktime;
	
	//八千亿周6到周7下班时间
	private String weekendaftertime;
	
	//八千亿周1到周5废票时间
	private String onetofivewastetime;
	
	//八千亿周6到周7废票时间
	private String weekendwastetime;
	
	//是否普通政策   1=普通政策
	private Long general;    
    
	//政策类型(普通还是高反)  1=普通政策
	private String ztype;
	
	//政策类型  “0”表示不是VIP政策,其余表示为VIP政策
	private Long istype;   
	
	//票证类型(1=BSP,2=B2B)
	private Integer tickettype;    
    
	//备注信息
	private String remark;    
	
	//政策状态(0=禁用,1=启用)
	private Integer isenable;    
	
	//适用用户类型
	private String usertype;
	
	//适用的班期(如1234567)  如果为空就不限制，如果不为空表示限制。例如：1/2/3就适用星期一，二，三
	private String schedule;
	
	//供应商ID
	private Long agentid;    
	
	//外部Id
	private String outid;   
	
	//今日出票速度
	private String speed;
	
	//今日交易费配置
	private String feetype;
	
	
	//今日分销商交易费
	private String agentfee;
	
	//工作状态([繁忙] OR [空闲])
	private String workstatus;
	
	/******************************************************************************/
	
	
	
	
	
    
    
    

	//利润方式
	private String outpattern;    
    

	//留钱
	private Integer moneykeep;    
    

	//留点
	private Integer pointkeep;    
    
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
    
	//关联政策ID
	private Long relationzrateid;    
    

	//供应商编号
	private String agentcode;    
    

	//适用类型 1:适用适用航班号。2：排除航班号(现用与判断是否下单到第三方平台)
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
	private Float localzrate;    
    

	//加返政策
	private Float addratevalue;    
    

	//政策类型出港入港
	private Long zratetype;    
    
	//适用班期
	private String limitdate;    
    
	private Long flightisuse;
    
	//出发不适用
	private String departureexclude;
	
	//抵达不适用
	private String arrivalexclude;
	


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
    public Long getRelationzrateid(){
         return relationzrateid;
    }

	/**
	 * set关联政策ID
	 */
    public void setRelationzrateid(Long relationzrateid){
         this.relationzrateid=relationzrateid;
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
    public Float getLocalzrate(){
         return localzrate;
    }

	/**
	 * set本地分销政策
	 */
    public void setLocalzrate(Float localzrate){
         this.localzrate=localzrate;
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

	/**
	 * get开始时间
	 */
    public Timestamp getBegindate(){
         return begindate;
    }

	/**
	 * set开始时间
	 */
    public void setBegindate(Timestamp begindate){
         this.begindate=begindate;
    }

	/**
	 * get结束时间
	 */
    public Timestamp getEnddate(){
         return enddate;
    }

	/**
	 * set结束时间
	 */
    public void setEnddate(Timestamp enddate){
         this.enddate=enddate;
    }

	/**
	 * get外部Id
	 */
    public String getOutid(){
         return outid;
    }

	/**
	 * set外部Id
	 */
    public void setOutid(String outid){
         this.outid=outid;
    }

	/**
	 * get适用班期
	 */
    public String getLimitdate(){
         return limitdate;
    }

	/**
	 * set适用班期
	 */
    public void setLimitdate(String limitdate){
         this.limitdate=limitdate;
    }

	/**
	 * get政策类型
	 */
    public Long getIstype(){
         return istype;
    }

	/**
	 * set政策类型
	 */
    public void setIstype(Long istype){
         this.istype=istype;
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
	   
	 + relationzrateid +"|"
	   
	 + agentcode +"|"
	   
	 + type +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + isauto +"|"
	   
	 + ischange +"|"
	   
	 + localzrate +"|"
	   
	 + addratevalue +"|"
	   
	 + general +"|"
	   
	 + zratetype +"|"
	   
	 + begindate +"|"
	   
	 + enddate +"|"
	   
	 + outid +"|"
	   
	 + limitdate +"|"
	 
	 + flightisuse +"|"
	 
	 + speed +"|"
	 
	 + feetype +"|"
	 
	 + agentfee +"|"
	 
	 + onetofiveworktime +"|"
	 
	 + onetofiveaftertime +"|"
	 
	 + weekendworktime +"|"
	 
	 + weekendaftertime +"|"
	 
	 + onetofivewastetime +"|"
	 
	 + weekendwastetime +"|"
	 
	 + ztype +"|"
	 
	 + voyagetype +"|"
	 
	 + schedule +"|"
	 
	 + usertype +"|"
	 
	 + workstatus +"|"
	 
	 + arrivalexclude +"|"
	 
	 + departureexclude +"|"
	   
	 + istype
	 + "]";
 }

	public String getAfterworktime() {
		return afterworktime;
	}

	public void setAfterworktime(String afterworktime) {
		this.afterworktime = afterworktime;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public Long getFlightisuse() {
		return flightisuse;
	}

	public void setFlightisuse(Long flightisuse) {
		this.flightisuse = flightisuse;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getFeetype() {
		return feetype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	public String getAgentfee() {
		return agentfee;
	}

	public void setAgentfee(String agentfee) {
		this.agentfee = agentfee;
	}

	public String getOnetofiveworktime() {
		return onetofiveworktime;
	}

	public void setOnetofiveworktime(String onetofiveworktime) {
		this.onetofiveworktime = onetofiveworktime;
	}

	public String getOnetofiveaftertime() {
		return onetofiveaftertime;
	}

	public void setOnetofiveaftertime(String onetofiveaftertime) {
		this.onetofiveaftertime = onetofiveaftertime;
	}

	public String getWeekendworktime() {
		return weekendworktime;
	}

	public void setWeekendworktime(String weekendworktime) {
		this.weekendworktime = weekendworktime;
	}

	public String getWeekendaftertime() {
		return weekendaftertime;
	}

	public void setWeekendaftertime(String weekendaftertime) {
		this.weekendaftertime = weekendaftertime;
	}

	public String getOnetofivewastetime() {
		return onetofivewastetime;
	}

	public void setOnetofivewastetime(String onetofivewastetime) {
		this.onetofivewastetime = onetofivewastetime;
	}

	public String getWeekendwastetime() {
		return weekendwastetime;
	}

	public void setWeekendwastetime(String weekendwastetime) {
		this.weekendwastetime = weekendwastetime;
	}

	public String getZtype() {
		return ztype;
	}

	public void setZtype(String ztype) {
		this.ztype = ztype;
	}

	public String getVoyagetype() {
		return voyagetype;
	}

	public void setVoyagetype(String voyagetype) {
		this.voyagetype = voyagetype;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	public String getDepartureexclude() {
		return departureexclude;
	}

	public void setDepartureexclude(String departureexclude) {
		this.departureexclude = departureexclude;
	}

	public String getArrivalexclude() {
		return arrivalexclude;
	}

	public void setArrivalexclude(String arrivalexclude) {
		this.arrivalexclude = arrivalexclude;
	}

	public int compareTo(Object arg0) {
		Zrate obj = (Zrate)arg0;
		
		return (int)(obj.getRatevalue()*100-this.getRatevalue()*100);
	}

}
