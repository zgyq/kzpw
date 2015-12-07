/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 */
package com.yf.system.base.hotelorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店订单
 */
public class HotelorderBean implements java.io.Serializable{

	/**
	  *酒店订单 表名
	  */
	public static final String TABLE  = "T_HOTELORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *酒店名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *订单属性 列名 
	  */
    public static final String COL_property  = "C_PROPERTY";
	
	/**
	  *房型名称 列名 
	  */
    public static final String COL_roomtypename  = "C_ROOMTYPENAME";
	
	/**
	  *房型ID 列名 
	  */
    public static final String COL_roomid  = "C_ROOMID";
	
	/**
	  *入住日期 列名 
	  */
    public static final String COL_comedate  = "C_COMEDATE";
	
	/**
	  *离店日期 列名 
	  */
    public static final String COL_leavedate  = "C_LEAVEDATE";
	
	/**
	  *订单人数 列名 
	  */
    public static final String COL_orderpeaple  = "C_ORDERPEAPLE";
	
	/**
	  *间夜 列名 
	  */
    public static final String COL_manyday  = "C_MANYDAY";
	
	/**
	  *订单总价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *预订备注 列名 
	  */
    public static final String COL_predesc  = "C_PREDESC";
	
	/**
	  *预订时间 列名 
	  */
    public static final String COL_pretime  = "C_PRETIME";
	
	/**
	  *会员姓名 列名 
	  */
    public static final String COL_membername  = "C_MEMBERNAME";
	
	/**
	  *会员手机 列名 
	  */
    public static final String COL_membermobile  = "C_MEMBERMOBILE";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *订单版本号 列名 
	  */
    public static final String COL_version  = "C_VERSION";
	
	/**
	  *取消原因 列名 
	  */
    public static final String COL_canclereason  = "C_CANCLEREASON";
	
	/**
	  *订单状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_linkname  = "C_LINKNAME";
	
	/**
	  *联系人手机 列名 
	  */
    public static final String COL_linkmobile  = "C_LINKMOBILE";
	
	/**
	  *联系人电邮 列名 
	  */
    public static final String COL_linkmail  = "C_LINKMAIL";
	
	/**
	  *联系人电话 列名 
	  */
    public static final String COL_linktell  = "C_LINKTELL";
	
	/**
	  *确认方法 列名 
	  */
    public static final String COL_confirmmethod  = "C_CONFIRMMETHOD";
	
	/**
	  *保留时间开始 列名 
	  */
    public static final String COL_reservstart  = "C_RESERVSTART";
	
	/**
	  *保留时间结束 列名 
	  */
    public static final String COL_reservend  = "C_RESERVEND";
	
	/**
	  *特殊要求 列名 
	  */
    public static final String COL_specreq  = "C_SPECREQ";
	
	/**
	  *预订间数 列名 
	  */
    public static final String COL_prerooms  = "C_PREROOMS";
	
	/**
	  *审核意见 列名 
	  */
    public static final String COL_checkdesc  = "C_CHECKDESC";
	
	/**
	  *传真发送时间 列名 
	  */
    public static final String COL_faxsendtime  = "C_FAXSENDTIME";
	
	/**
	  *订单编号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *返回值 列名 
	  */
    public static final String COL_resultvalue  = "C_RESULTVALUE";
	
	/**
	  *返回码 列名 
	  */
    public static final String COL_resultcode  = "C_RESULTCODE";
	
	/**
	  *处理人员ID 列名 
	  */
    public static final String COL_systemuserid  = "C_SYSTEMUSERID";
	
	/**
	  *订单类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
    
    /**
	  *支付类型 列名 
	  */
   public static final String COL_paytype  = "C_PAYTYPE";
	
	/**
	  *每日价格 列名 
	  */
   public static final String COL_dayprice  = "C_DAYPRICE";
   
   /**
	  *日审类型 列名 
	  */
   public static final String COL_checktype  = "C_CHECKTYPE";
   /**
	  *是否回款列名 
	  */
   public static final String COL_ishotelpay  = "C_ISHOTELPAY";

   /**
	  *付款状态 列名 
	  */
  public static final String COL_paystate  = "C_PAYSTATE";
	
	/**
	  *付款方式 列名 
	  */
  public static final String COL_payment  = "C_PAYMENT";
	
	/**
	  *实际金额 列名 
	  */
  public static final String COL_actualmount  = "C_ACTUALMOUNT";
	
	/**
	  *优惠券金额 列名 
	  */
  public static final String COL_couponamount  = "C_COUPONAMOUNT";
	
	/**
	  *订单来源 列名 
	  */
  public static final String COL_ordersource  = "C_ORDERSOURCE";
  
  /**
	  *预订人身份证 列名 
	  */
public static final String COL_number  = "C_NUMBER";

/**
 *预订人性别 列名 
 */
public static final String COL_sex  = "C_SEX";

/**
 *外部订单号 列名 
 */
public static final String COL_waicode  = "C_WAICODE";

/**
 *担保状态 列名 
 */
public static final String COL_danbao  = "C_DANBAO";
  

/**
 *实际离店日期 列名 
 */
public static final String COL_shijitime  = "C_SHIJITIME";

/**
 *订单保留时效 列名 
 */
public static final String COL_baoliutime  = "C_BAOLIUTIME";



/**
	  *夜审状态 列名 
	  */
public static final String COL_yestate  = "C_YESTATE";


/**
 *返点金额 列名 
 */
public static final String COL_fanprice  = "C_FANPRICE";

/**
 *预付总金额 列名 
 */
public static final String COL_yufuprice  = "C_YUFUPRICE";

/**
 *现付总金额 列名 
 */
public static final String COL_xianfuprice  = "C_XIANFUPRICE";

/**
 *订单总利润 列名 
 */
public static final String COL_profits  = "C_PROFITS";

/**
 *订单创建人 列名 
 */
public static final String COL_createuserid  = "C_CREATEUSERID";

/**
 *价格计划ID 列名 
 */
public static final String COL_pricecodeid  = "C_PRICECODEID";

/**
 *价格计划名字 列名 
 */
public static final String COL_pricecodename  = "C_PRICECODENAME";

/**
 *价格单位 列名 
 */
public static final String COL_pricecurrency  = "C_PRICECURRENCY";


	//ID
	private long id;    
    

	//酒店名称
	private String name;    
    

	//酒店ID
	private Long hotelid;    
    

	//订单ID
	private String orderid;    
    

	//订单属性
	private String property;    //1,国内 2,国际
    

	//房型名称
	private String roomtypename;    
    

	//房型ID
	private Long roomid;    
    

	//入住日期
	private Timestamp comedate;    
    

	//离店日期
	private Timestamp leavedate;    
    

	//订单人数
	private Integer orderpeaple;    
    

	//间夜
	private Integer manyday;    
    

	//订单总价
	private String price;    
    

	//预订备注
	private String predesc;    
    

	//预订时间
	private Timestamp pretime;    
    

	//会员姓名
	private String membername;    
    

	//会员手机
	private String membermobile;    
    

	//会员ID
	private Long memberid;    
    

	//订单版本号
	private Integer version;    
    

	//取消原因
	private Integer canclereason;    
    

	//订单状态
	private Integer state;   
	
	//夜审状态
	private Integer yestate; //0,未夜审 1,已夜审,全部正常 2,已也审,非正常 
    

	//联系人姓名
	private String linkname;    
    

	//联系人手机
	private String linkmobile;    
    

	//联系人电邮
	private String linkmail;    
    

	//联系人电话
	private String linktell;    
    

	//确认方法
	private Integer confirmmethod;    
    

	//保留时间开始
	private String reservstart;    
    

	//保留时间结束
	private String reservend;    
    

	//特殊要求
	private String specreq;    
    

	//预订间数
	private Integer prerooms;    
    

	//审核意见
	private String checkdesc;    
    

	//传真发送时间
	private Timestamp faxsendtime;    
    

	//订单编号
	private String code;    
    

	//返回值
	private String resultvalue;    
    

	//返回码
	private Integer resultcode;    
    

	//处理人员ID
	private Long systemuserid;    
    

	//订单类型
	private Integer type;    //1，B2C   2，B2B订单
	
	//支付类型
	private Long paytype;    
    

	//日审类型
	private Long checktype; 
	
	//每日价格
	private String dayprice;
	
	//回款状态
	private Long ishotelpay;
	
	//付款状态
	private Long paystate;    
    

	//付款方式
	private Long payment;    
    

	//实际金额
	private Double actualmount;    
    

	//优惠券金额
	private Double couponamount;    
    

	//订单来源
	private Long ordersource;   
	
	//担保状态 0为无担保 1为全程担保
	private Integer danbao;
    
	//预订人身份证
	private String number;
	
	//预订人性别
	private String sex;
	
	//外部订单号
	private String waicode;
	
	//实际离店日期
	private Timestamp shijitime;  
	
	//保留时效
	private String baoliutime;  
	
	//返点金额
	private Double fanprice;   
	
	//预付总金额
	private Double yufuprice;   
	
	//现付总金额
	private Double xianfuprice;   
	
	//订单总利润
	private Double profits; 
	
	//订单创建人ID.如果是后台呼叫中心给下属会员预订..就录入当前登录者id..前台会员预订也一样..方便统计报表...fanprice只记录当前登录者的利润....
	private Long createuserid;
	
	
	//价格计划id
	private String pricecodeid;  
	
	//价格计划name
	private String pricecodename;  
	
	//价格单位
	private String pricecurrency;  
	

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
	 * get酒店名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set酒店名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get酒店ID
	 */
    public Long getHotelid(){
         return hotelid;
    }

	/**
	 * set酒店ID
	 */
    public void setHotelid(Long hotelid){
         this.hotelid=hotelid;
    }

	/**
	 * get订单ID
	 */
    public String getOrderid(){
         return orderid;
    }

	/**
	 * set订单ID
	 */
    public void setOrderid(String orderid){
         this.orderid=orderid;
    }

	/**
	 * get订单属性
	 */
    public String getProperty(){
         return property;
    }

	/**
	 * set订单属性
	 */
    public void setProperty(String property){
         this.property=property;
    }

	public Double getYufuprice() {
		return yufuprice;
	}

	public void setYufuprice(Double yufuprice) {
		this.yufuprice = yufuprice;
	}

	public Double getXianfuprice() {
		return xianfuprice;
	}

	public void setXianfuprice(Double xianfuprice) {
		this.xianfuprice = xianfuprice;
	}

	/**
	 * get房型名称
	 */
    public String getRoomtypename(){
         return roomtypename;
    }

	/**
	 * set房型名称
	 */
    public void setRoomtypename(String roomtypename){
         this.roomtypename=roomtypename;
    }

	/**
	 * get房型ID
	 */
    public Long getRoomid(){
         return roomid;
    }

	/**
	 * set房型ID
	 */
    public void setRoomid(Long roomid){
         this.roomid=roomid;
    }

	/**
	 * get入住日期
	 */
    public Timestamp getComedate(){
         return comedate;
    }

	/**
	 * set入住日期
	 */
    public void setComedate(Timestamp comedate){
         this.comedate=comedate;
    }

	/**
	 * get离店日期
	 */
    public Timestamp getLeavedate(){
         return leavedate;
    }

	/**
	 * set离店日期
	 */
    public void setLeavedate(Timestamp leavedate){
         this.leavedate=leavedate;
    }

	/**
	 * get订单人数
	 */
    public Integer getOrderpeaple(){
         return orderpeaple;
    }

	/**
	 * set订单人数
	 */
    public void setOrderpeaple(Integer orderpeaple){
         this.orderpeaple=orderpeaple;
    }

	/**
	 * get间夜
	 */
    public Integer getManyday(){
         return manyday;
    }

	/**
	 * set间夜
	 */
    public void setManyday(Integer manyday){
         this.manyday=manyday;
    }

	/**
	 * get订单总价
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set订单总价
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get预订备注
	 */
    public String getPredesc(){
         return predesc;
    }

	/**
	 * set预订备注
	 */
    public void setPredesc(String predesc){
         this.predesc=predesc;
    }

	/**
	 * get预订时间
	 */
    public Timestamp getPretime(){
         return pretime;
    }

	/**
	 * set预订时间
	 */
    public void setPretime(Timestamp pretime){
         this.pretime=pretime;
    }

	/**
	 * get会员姓名
	 */
    public String getMembername(){
         return membername;
    }

	/**
	 * set会员姓名
	 */
    public void setMembername(String membername){
         this.membername=membername;
    }

	/**
	 * get会员手机
	 */
    public String getMembermobile(){
         return membermobile;
    }

	/**
	 * set会员手机
	 */
    public void setMembermobile(String membermobile){
         this.membermobile=membermobile;
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
	 * get订单版本号
	 */
    public Integer getVersion(){
         return version;
    }

	/**
	 * set订单版本号
	 */
    public void setVersion(Integer version){
         this.version=version;
    }

	/**
	 * get取消原因
	 */
    public Integer getCanclereason(){
         return canclereason;
    }

	/**
	 * set取消原因
	 */
    public void setCanclereason(Integer canclereason){
         this.canclereason=canclereason;
    }

	/**
	 * get订单状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set订单状态
	 */
    public void setState(Integer state){
         this.state=state;
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
	 * get联系人手机
	 */
    public String getLinkmobile(){
         return linkmobile;
    }

	/**
	 * set联系人手机
	 */
    public void setLinkmobile(String linkmobile){
         this.linkmobile=linkmobile;
    }

	/**
	 * get联系人电邮
	 */
    public String getLinkmail(){
         return linkmail;
    }

	/**
	 * set联系人电邮
	 */
    public void setLinkmail(String linkmail){
         this.linkmail=linkmail;
    }

	/**
	 * get联系人电话
	 */
    public String getLinktell(){
         return linktell;
    }

	/**
	 * set联系人电话
	 */
    public void setLinktell(String linktell){
         this.linktell=linktell;
    }

	/**
	 * get确认方法
	 */
    public Integer getConfirmmethod(){
         return confirmmethod;
    }

	/**
	 * set确认方法
	 */
    public void setConfirmmethod(Integer confirmmethod){
         this.confirmmethod=confirmmethod;
    }

	/**
	 * get保留时间开始
	 */
    public String getReservstart(){
         return reservstart;
    }

	/**
	 * set保留时间开始
	 */
    public void setReservstart(String reservstart){
         this.reservstart=reservstart;
    }

	/**
	 * get保留时间结束
	 */
    public String getReservend(){
         return reservend;
    }

	/**
	 * set保留时间结束
	 */
    public void setReservend(String reservend){
         this.reservend=reservend;
    }

	/**
	 * get特殊要求
	 */
    public String getSpecreq(){
         return specreq;
    }

	/**
	 * set特殊要求
	 */
    public void setSpecreq(String specreq){
         this.specreq=specreq;
    }

	/**
	 * get预订间数
	 */
    public Integer getPrerooms(){
         return prerooms;
    }

	/**
	 * set预订间数
	 */
    public void setPrerooms(Integer prerooms){
         this.prerooms=prerooms;
    }

	/**
	 * get审核意见
	 */
    public String getCheckdesc(){
         return checkdesc;
    }

	/**
	 * set审核意见
	 */
    public void setCheckdesc(String checkdesc){
         this.checkdesc=checkdesc;
    }

	/**
	 * get传真发送时间
	 */
    public Timestamp getFaxsendtime(){
         return faxsendtime;
    }

	/**
	 * set传真发送时间
	 */
    public void setFaxsendtime(Timestamp faxsendtime){
         this.faxsendtime=faxsendtime;
    }

	/**
	 * get订单编号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set订单编号
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get返回值
	 */
    public String getResultvalue(){
         return resultvalue;
    }

	/**
	 * set返回值
	 */
    public void setResultvalue(String resultvalue){
         this.resultvalue=resultvalue;
    }

	/**
	 * get返回码
	 */
    public Integer getResultcode(){
         return resultcode;
    }

	/**
	 * set返回码
	 */
    public void setResultcode(Integer resultcode){
         this.resultcode=resultcode;
    }

	/**
	 * get处理人员ID
	 */
    public Long getSystemuserid(){
         return systemuserid;
    }

	/**
	 * set处理人员ID
	 */
    public void setSystemuserid(Long systemuserid){
         this.systemuserid=systemuserid;
    }

	/**
	 * get订单类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set订单类型
	 */
    public void setType(Integer type){
         this.type=type;
    }

    /**
	 * get支付类型
	 */
    public Long getPaytype(){
         return paytype;
    }

	/**
	 * set支付类型
	 */
    public void setPaytype(Long paytype){
         this.paytype=paytype;
    }

	/**
	 * get日审类型
	 */
    public Long getChecktype(){
         return checktype;
    }

	/**
	 * set日审类型
	 */
    public void setChecktype(Long checktype){
         this.checktype=checktype;
    }
    
    /**
	 * get每日价格
	 */
    public String getDayprice(){
         return dayprice;
    }

	/**
	 * set每日价格
	 */
    public void setDayprice(String dayprice){
         this.dayprice=dayprice;
    }
    
    /**
	 * get酒店是否回款
	 */
    public Long getIshotelpay(){
         return ishotelpay;
    }

	/**
	 * set酒店是否回款
	 */
    public void setIshotelpay(Long ishotelpay){
         this.ishotelpay=ishotelpay;
    }
    

	/**
	 * get付款状态
	 */
    public Long getPaystate(){
         return paystate;
    }

	/**
	 * set付款状态
	 */
    public void setPaystate(Long paystate){
         this.paystate=paystate;
    }

	/**
	 * get付款方式
	 */
    public Long getPayment(){
         return payment;
    }

	/**
	 * set付款方式
	 */
    public void setPayment(Long payment){
         this.payment=payment;
    }

	/**
	 * get实际金额
	 */
    public Double getActualmount(){
         return actualmount;
    }

	/**
	 * set实际金额
	 */
    public void setActualmount(Double actualmount){
         this.actualmount=actualmount;
    }

	/**
	 * get优惠券金额
	 */
    public Double getCouponamount(){
         return couponamount;
    }

	/**
	 * set优惠券金额
	 */
    public void setCouponamount(Double couponamount){
         this.couponamount=couponamount;
    }

	/**
	 * get订单来源
	 */
    public Long getOrdersource(){
         return ordersource;
    }

	/**
	 * set订单来源
	 */
    public void setOrdersource(Long ordersource){
         this.ordersource=ordersource;
    }
	public Integer getDanbao() {
		return danbao;
	}

	public void setDanbao(Integer danbao) {
		this.danbao = danbao;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWaicode() {
		return waicode;
	}

	public void setWaicode(String waicode) {
		this.waicode = waicode;
	} 


	public Timestamp getShijitime() {
		return shijitime;
	}

	public void setShijitime(Timestamp shijitime) {
		this.shijitime = shijitime;
	}

	public String getBaoliutime() {
		return baoliutime;
	}

	public void setBaoliutime(String baoliutime) {
		this.baoliutime = baoliutime;
	}

	public Integer getYestate() {
		return yestate;
	}

	public void setYestate(Integer yestate) {
		this.yestate = yestate;
	}

	public Double getFanprice() {
		return fanprice;
	}

	public void setFanprice(Double fanprice) {
		this.fanprice = fanprice;
	}

	public Double getProfits() {
		return profits;
	}

	public void setProfits(Double profits) {
		this.profits = profits;
	}

	public Long getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Long createuserid) {
		this.createuserid = createuserid;
	}

	public String getPricecodeid() {
		return pricecodeid;
	}

	public void setPricecodeid(String pricecodeid) {
		this.pricecodeid = pricecodeid;
	}

	public String getPricecodename() {
		return pricecodename;
	}

	public void setPricecodename(String pricecodename) {
		this.pricecodename = pricecodename;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + hotelid +"|"
	   
	 + orderid +"|"
	   
	 + property +"|"
	   
	 + roomtypename +"|"
	   
	 + roomid +"|"
	   
	 + comedate +"|"
	   
	 + leavedate +"|"
	   
	 + orderpeaple +"|"
	 
	 + yestate +"|"
	   
	 + manyday +"|"
	   
	 + price +"|"
	   
	 + predesc +"|"
	   
	 + pretime +"|"
	   
	 + membername +"|"
	   
	 + membermobile +"|"
	   
	 + memberid +"|"
	   
	 + version +"|"
	   
	 + canclereason +"|"
	   
	 + state +"|"
	   
	 + linkname +"|"
	   
	 + linkmobile +"|"
	   
	 + linkmail +"|"
	   
	 + linktell +"|"
	   
	 + confirmmethod +"|"
	   
	 + reservstart +"|"
	   
	 + reservend +"|"
	   
	 + specreq +"|"
	   
	 + prerooms +"|"
	   
	 + checkdesc +"|"
	   
	 + faxsendtime +"|"
	   
	 + code +"|"
	   
	 + resultvalue +"|"
	   
	 + resultcode +"|"
	   
	 + systemuserid +"|"
	   
	 + type+"|"
	 
	 + paytype +"|"
	  
	 + checktype +"|"
	 
	 + dayprice+"|"
	 
	 +ishotelpay+"|"
	   
	 + paystate +"|"
	   
	 + payment +"|"
	   
	 + actualmount +"|"
	   
	 + couponamount +"|"
	 
	 + waicode +"|"
	 
	 + sex +"|"
	 
	 + number +"|"
	 
	 + danbao +"|"
	 
	 + baoliutime +"|"
	 
	 + shijitime +"|"
	 
	 + fanprice +"|"
	 
	 + yufuprice +"|"
	 
	 + xianfuprice +"|"
	 
	 + profits +"|"
	 
	 + createuserid +"|"
	 
	 + pricecodeid+"|"
	 
	 + pricecodename+"|"
	 
	 + pricecurrency+"|"
	 
	 
	   
	 + ordersource
	 
	 + "]";
 }

	public String getPricecurrency() {
		return pricecurrency;
	}

	public void setPricecurrency(String pricecurrency) {
		this.pricecurrency = pricecurrency;
	}



}
