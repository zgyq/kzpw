/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.carorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *租车订单
 */
public class CarorderBean implements java.io.Serializable{

	/**
	  *租车订单 表名
	  */
	public static final String TABLE  = "T_CARORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *汽车ID 列名 
	  */
    public static final String COL_carid  = "C_CARID";
	
	/**
	  *订单属性 列名 
	  */
    public static final String COL_property  = "C_PROPERTY";
	
	/**
	  *汽车名称 列名 
	  */
    public static final String COL_carname  = "C_CARNAME";
	
	/**
	  *起租日期 列名 
	  */
    public static final String COL_sdate  = "C_SDATE";
	
	/**
	  *还车日期 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
	/**
	  *取车城市ID 列名 
	  */
    public static final String COL_scityid  = "C_SCITYID";
	
	/**
	  *还车城市ID 列名 
	  */
    public static final String COL_endcityid  = "C_ENDCITYID";
	
	/**
	  *订单总价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *预订时间 列名 
	  */
    public static final String COL_pretime  = "C_PRETIME";
	
	/**
	  *天数 列名 
	  */
    public static final String COL_manyday  = "C_MANYDAY";
	
	/**
	  *预订备注 列名 
	  */
    public static final String COL_predesc  = "C_PREDESC";
	
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
	  *特殊要求 列名 
	  */
    public static final String COL_specreq  = "C_SPECREQ";
	
	/**
	  *订单编号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *订单基本价 列名 
	  */
    public static final String COL_jprice  = "C_JPRICE";
	
	/**
	  *是否需要GPS 列名 
	  */
    public static final String COL_gps  = "C_GPS";
	
	/**
	  *总保险费 列名 
	  */
    public static final String COL_insurancefee  = "C_INSURANCEFEE";
	
	/**
	  *手续费 列名 
	  */
    public static final String COL_servicefee  = "C_SERVICEFEE";
	
	/**
	  *信用卡预授权费用 列名 
	  */
    public static final String COL_preauthfee  = "C_PREAUTHFEE";
	
	/**
	  *GPS费用 列名 
	  */
    public static final String COL_gpsfee  = "C_GPSFEE";
	
	/**
	  *总里程 列名 
	  */
    public static final String COL_mile  = "C_MILE";
	
	/**
	  *送车上门费 列名 
	  */
    public static final String COL_pickupservicefee  = "C_PICKUPSERVICEFEE";
	
	/**
	  *上门取车费 列名 
	  */
    public static final String COL_dropoffservicefee  = "C_DROPOFFSERVICEFEE";
	
	/**
	  *交通罚单押金 列名 
	  */
    public static final String COL_ticketfee  = "C_TICKETFEE";
	
	/**
	  *汽车编号 列名 
	  */
    public static final String COL_carcode  = "C_CARCODE";
	
	/**
	  *订单总利润 列名 
	  */
    public static final String COL_orderfee  = "C_ORDERFEE";
	
	/**
	  *外部订单号 列名 
	  */
    public static final String COL_waicode  = "C_WAICODE";
	
	/**
	  *身份证号码 列名 
	  */
    public static final String COL_nuber  = "C_NUBER";
    
	/**
	  *取车店铺ID 列名 
	  */
   public static final String COL_scarstoreid  = "C_SCARSTOREID";
   
	/**
	  *还车店铺ID 列名 
	  */
   public static final String COL_ecarstoreid  = "C_ECARSTOREID";
   
   
	/**
	  *预订人ID 列名 
	  */
   public static final String COL_bookuserid  = "C_BOOKUSERID";

	//ID
	private long id;    
    

	//汽车ID
	private Long carid;    
    

	//订单属性
	private String property;    
    

	//汽车名称
	private String carname;    
    

	//起租日期
	private String sdate;    
    

	//还车日期
	private String enddate;    
    

	//取车城市ID
	private Long scityid;    
    

	//还车城市ID
	private Long endcityid;    
    

	//订单总价
	private String price;    
    

	//预订时间
	private Timestamp pretime;    
    

	//天数
	private Integer manyday;    
    

	//预订备注
	private String predesc;    
    

	//会员姓名
	private String membername;    
    

	//会员手机
	private String membermobile;    
    

	//会员ID
	private Long memberid;    
    

	//取消原因
	private Integer canclereason;    
    

	//订单状态
	private Integer state;    
    

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
    

	//特殊要求
	private String specreq;    
    

	//订单编号
	private String code;    
    

	//订单基本价
	private String jprice;    
    

	//是否需要GPS
	private String gps;    
    

	//总保险费
	private String insurancefee;    
    

	//手续费
	private String servicefee;    
    

	//信用卡预授权费用
	private String preauthfee;    
    

	//GPS费用
	private String gpsfee;    
    

	//总里程
	private String mile;    
    

	//送车上门费
	private String pickupservicefee;    
    

	//上门取车费
	private String dropoffservicefee;    
    

	//交通罚单押金
	private String ticketfee;    
    

	//汽车编号
	private String carcode;    
    

	//订单总利润
	private String orderfee;    
    

	//外部订单号
	private String waicode;    
    

	//身份证号码
	private String nuber;    
    
	//预订人ID
	private Long bookuserid; 
	
	
	//取车门店ID
	private Long scarstoreid; 
	
	//还车门店ID
	private Long ecarstoreid; 
	
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
	 * get汽车ID
	 */
    public Long getCarid(){
         return carid;
    }

	/**
	 * set汽车ID
	 */
    public void setCarid(Long carid){
         this.carid=carid;
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

	/**
	 * get汽车名称
	 */
    public String getCarname(){
         return carname;
    }

	/**
	 * set汽车名称
	 */
    public void setCarname(String carname){
         this.carname=carname;
    }

	/**
	 * get起租日期
	 */
    public String getSdate(){
         return sdate;
    }

	/**
	 * set起租日期
	 */
    public void setSdate(String sdate){
         this.sdate=sdate;
    }

	/**
	 * get还车日期
	 */
    public String getEnddate(){
         return enddate;
    }

	/**
	 * set还车日期
	 */
    public void setEnddate(String enddate){
         this.enddate=enddate;
    }

	/**
	 * get取车城市ID
	 */
    public Long getScityid(){
         return scityid;
    }

	/**
	 * set取车城市ID
	 */
    public void setScityid(Long scityid){
         this.scityid=scityid;
    }

	/**
	 * get还车城市ID
	 */
    public Long getEndcityid(){
         return endcityid;
    }

	/**
	 * set还车城市ID
	 */
    public void setEndcityid(Long endcityid){
         this.endcityid=endcityid;
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
	 * get天数
	 */
    public Integer getManyday(){
         return manyday;
    }

	/**
	 * set天数
	 */
    public void setManyday(Integer manyday){
         this.manyday=manyday;
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
	 * get订单基本价
	 */
    public String getJprice(){
         return jprice;
    }

	/**
	 * set订单基本价
	 */
    public void setJprice(String jprice){
         this.jprice=jprice;
    }

	/**
	 * get是否需要GPS
	 */
    public String getGps(){
         return gps;
    }

	/**
	 * set是否需要GPS
	 */
    public void setGps(String gps){
         this.gps=gps;
    }

	/**
	 * get总保险费
	 */
    public String getInsurancefee(){
         return insurancefee;
    }

	/**
	 * set总保险费
	 */
    public void setInsurancefee(String insurancefee){
         this.insurancefee=insurancefee;
    }

	/**
	 * get手续费
	 */
    public String getServicefee(){
         return servicefee;
    }

	/**
	 * set手续费
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
	 * getGPS费用
	 */
    public String getGpsfee(){
         return gpsfee;
    }

	/**
	 * setGPS费用
	 */
    public void setGpsfee(String gpsfee){
         this.gpsfee=gpsfee;
    }

	/**
	 * get总里程
	 */
    public String getMile(){
         return mile;
    }

	/**
	 * set总里程
	 */
    public void setMile(String mile){
         this.mile=mile;
    }

	/**
	 * get送车上门费
	 */
    public String getPickupservicefee(){
         return pickupservicefee;
    }

	/**
	 * set送车上门费
	 */
    public void setPickupservicefee(String pickupservicefee){
         this.pickupservicefee=pickupservicefee;
    }

	/**
	 * get上门取车费
	 */
    public String getDropoffservicefee(){
         return dropoffservicefee;
    }

	/**
	 * set上门取车费
	 */
    public void setDropoffservicefee(String dropoffservicefee){
         this.dropoffservicefee=dropoffservicefee;
    }

	/**
	 * get交通罚单押金
	 */
    public String getTicketfee(){
         return ticketfee;
    }

	/**
	 * set交通罚单押金
	 */
    public void setTicketfee(String ticketfee){
         this.ticketfee=ticketfee;
    }

	/**
	 * get汽车编号
	 */
    public String getCarcode(){
         return carcode;
    }

	/**
	 * set汽车编号
	 */
    public void setCarcode(String carcode){
         this.carcode=carcode;
    }

	/**
	 * get订单总利润
	 */
    public String getOrderfee(){
         return orderfee;
    }

	/**
	 * set订单总利润
	 */
    public void setOrderfee(String orderfee){
         this.orderfee=orderfee;
    }

	/**
	 * get外部订单号
	 */
    public String getWaicode(){
         return waicode;
    }

	/**
	 * set外部订单号
	 */
    public void setWaicode(String waicode){
         this.waicode=waicode;
    }

	/**
	 * get身份证号码
	 */
    public String getNuber(){
         return nuber;
    }

	/**
	 * set身份证号码
	 */
    public void setNuber(String nuber){
         this.nuber=nuber;
    }


	public Long getBookuserid() {
		return bookuserid;
	}

	public void setBookuserid(Long bookuserid) {
		this.bookuserid = bookuserid;
	}

	public Long getScarstoreid() {
		return scarstoreid;
	}

	public void setScarstoreid(Long scarstoreid) {
		this.scarstoreid = scarstoreid;
	}

	public Long getEcarstoreid() {
		return ecarstoreid;
	}

	public void setEcarstoreid(Long ecarstoreid) {
		this.ecarstoreid = ecarstoreid;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + carid +"|"
	   
	 + property +"|"
	   
	 + carname +"|"
	   
	 + sdate +"|"
	   
	 + enddate +"|"
	   
	 + scityid +"|"
	   
	 + endcityid +"|"
	   
	 + price +"|"
	   
	 + pretime +"|"
	   
	 + manyday +"|"
	   
	 + predesc +"|"
	   
	 + membername +"|"
	   
	 + membermobile +"|"
	   
	 + memberid +"|"
	   
	 + canclereason +"|"
	   
	 + state +"|"
	   
	 + linkname +"|"
	   
	 + linkmobile +"|"
	   
	 + linkmail +"|"
	   
	 + linktell +"|"
	   
	 + confirmmethod +"|"
	   
	 + specreq +"|"
	   
	 + code +"|"
	   
	 + jprice +"|"
	   
	 + gps +"|"
	   
	 + insurancefee +"|"
	   
	 + servicefee +"|"
	   
	 + preauthfee +"|"
	   
	 + gpsfee +"|"
	   
	 + mile +"|"
	   
	 + pickupservicefee +"|"
	   
	 + dropoffservicefee +"|"
	   
	 + ticketfee +"|"
	   
	 + carcode +"|"
	   
	 + orderfee +"|"
	   
	 + waicode +"|"
	 
	 + bookuserid +"|"
	 
	 + scarstoreid +"|"
	 
	 + ecarstoreid +"|"
	   
	 + nuber
	 + "]";
 } 

}
