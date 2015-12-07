/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.passenger;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *乘机人表
 */
public class PassengerBean implements java.io.Serializable{

	/**
	  *乘机人表 表名
	  */
	public static final String TABLE  = "T_PASSENGER";

	
	/**
	  *乘机人ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *乘机人姓名 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *乘机人类型 列名 
	  */
    public static final String COL_ptype  = "C_PTYPE";
	
	/**
	  *证件类型 列名 
	  */
    public static final String COL_idtype  = "C_IDTYPE";
	
	/**
	  *证件号 列名 
	  */
    public static final String COL_idnumber  = "C_IDNUMBER";
	
	/**
	  *票价 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *燃油费 列名 
	  */
    public static final String COL_fuelprice  = "C_FUELPRICE";
	
	/**
	  *机建费 列名 
	  */
    public static final String COL_airportfee  = "C_AIRPORTFEE";
	
	/**
	  *折扣 列名 
	  */
    public static final String COL_discount  = "C_DISCOUNT";
	
	/**
	  *票号 列名 
	  */
    public static final String COL_ticketnum  = "C_TICKETNUM";
	
	/**
	  *行程单号 列名 
	  */
    public static final String COL_fet  = "C_FET";
	
	/**
	  *EI项 列名 
	  */
    public static final String COL_ei  = "C_EI";
	
	/**
	  *票状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *退票费 列名 
	  */
    public static final String COL_tuifee  = "C_TUIFEE";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *保险份数 列名 
	  */
    public static final String COL_insurance  = "C_INSURANCE";
	
	/**
	  *出票时间 列名 
	  */
    public static final String COL_rttime  = "C_RTTIME";
	
	/**
	  *退费票时间 列名 
	  */
    public static final String COL_tuitime  = "C_TUITIME";
	
	/**
	  *退费票手续费 列名 
	  */
    public static final String COL_tuipiaoshouxufee  = "C_TUIPIAOSHOUXUFEE";
	
	/**
	  *还款状态 列名 
	  */
    public static final String COL_hkstate  = "C_HKSTATE";
	
	/**
	  *还款已还金额 列名 
	  */
    public static final String COL_yihai  = "C_YIHAI";
	
	/**
	  *还款还欠金额 列名 
	  */
    public static final String COL_haiqian  = "C_HAIQIAN";
	
	/**
	  *退费原因 列名 
	  */
    public static final String COL_tuifeiyuanyi  = "C_TUIFEIYUANYI";
	
	/**
	  *是否取消座位 列名 
	  */
    public static final String COL_iscabinsite  = "C_ISCABINSITE";
	
	/**
	  *退费说明 列名 
	  */
    public static final String COL_tuifeidesc  = "C_TUIFEIDESC";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_beizhu  = "C_BEIZHU";
	
	/**
	  *退费申请时间 列名 
	  */
    public static final String COL_tuifeitime  = "C_TUIFEITIME";
	
	/**
	  *不能退票原因 列名 
	  */
    public static final String COL_notuidesc  = "C_NOTUIDESC";
	
	/**
	  *退Or费 列名 
	  */
    public static final String COL_tuiorfei  = "C_TUIORFEI";
    
    /**
     * 改期日期
     */
    public static final String COL_changedate="C_CHANGEDATE";

    /**
     *改签航班号
     */
    public static final String COL_changeflight="C_CHANGEFLIGHT";


    /**
     * 改签舱位码
     */
    public static final String COL_changecabin="C_CHANGECABIN";

    /**
     * 改签新PNR
     */
    public static final String COL_changepnr="C_CHANGEPNR";
    
    /**
     * 手机号
     */
    public static final String COL_mobile="C_MOBILE";
    
    
    /**
     * 还款时间
     */
    public static final String COL_repaytime="C_REPAYTIME";
    
    /**
     * 退票比例
     */
    public static final String COL_tuipiaobili="C_TUIPIAOBILI";
    
    /**
     * 安检费
     */
    public static final String COL_anjianfee="C_ANJIANFEE";
    
    /**
     * 其他税费
     */
    public static final String COL_otherfee="C_OTHERFEE";

    /**
     * 机票类型
     */
    public static final String COL_TICKETTYPEID="C_TICKETTYPEID";
    
    /**
     * 原票价（未减去折扣金额的价格）
     */
    public static final String COL_yuanprice="C_YUANPRICE";
    
    
    /**
     * 还款方式。
     */
    public static final String COL_hkmethod="C_HKMETHOD";
    
    
    //接收短信类型---0：不接收，1：接收航班动态短信，2：接收出票提醒短信 3：1,2类型短信都接收
    //用于待出票
    
    public static final String COL_msgtype="C_MSGTYPE";
    
    /**
     * 是否是留学生 0不是 1是
     */
    public static final String COL_isstudent="C_ISSTUDENT";
    
    /**
     * 证件有效期
     */
    public static final String COL_cardvaliddate="C_CARDVALIDDATE";
    
    /**
     * 国籍
     */
    public static final String COL_country="C_COUNTRY";
    /**
     * 出生日期
     */
    public static final String COL_birthday="C_BIRTHDAY";
    
    /**
     * 目的地邮编(原证件号码)
     */
    public static final String COL_destzipcode="C_DESTZIPCODE";
    
    /**
     * 目的地地址
     */
    public static final String COL_destadress="C_DESTADDRESS";
    
    /**
     * 现居住地址
     */
    public static final String COL_liveaddress="C_LIVEADDRESS";
    
    
    public static final String COL_lirun="C_LIRUN";
    
	//乘机人ID
	private long id;    
    

	//订单ID
	private Long orderid;    
    

	//乘机人姓名
	private String name;    
    

	//乘机人类型
	private Integer ptype;    
    

	//证件类型
	private Integer idtype;    
    

	//证件号
	private String idnumber;    
    

	//票价
	private Float price;    
    

	//燃油费
	private Float fuelprice;    
    

	//机建费
	private Float airportfee;    
    

	//折扣
	private Float discount;    
    

	//票号
	private String ticketnum;    
    

	//行程单号
	private String fet;    
    

	//EI项
	private String ei;    
    

	//票状态
	private Integer state;    
    

	//退票费
	private Float tuifee;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    
	//出票时间
	private Timestamp rttime;    
    

	//退费票时间
	private Timestamp tuitime;    
    

	//退费票手续费
	private Float tuipiaoshouxufee;    
    

	//还款状态
	private Long hkstate;
	
	/**
	 * 还款方式
	 */
	private Long hkmethod;

	
	//还款时间
	private Timestamp repaytime;
    

	//还款已还金额
	private Float yihai;    
    

	//还款还欠金额
	private Float haiqian;    
    

	//退费原因
	private Long tuifeiyuanyi;    
    

	//是否取消座位
	private Long iscabinsite;    
    

	//退费说明
	private String tuifeidesc;    
    

	//备注
	private String beizhu;    
    

	//退费申请时间
	private Timestamp tuifeitime;    
    

	//不能退票原因
	private String notuidesc;    
    

	//退Or费
	private Long tuiorfei;    
    
	
	//改期日期
	private String changedate;
	//改签航班号
	private String changeflight;
	//改签舱位
	private String changecabin;
	//改签PNR
	private String changepnr;
	//手机号码
	private String mobile;
	
	//退票比例
	private String tuipiaobili;
	
	//安检费
	private Float anjianfee;
	
	//其他税费
	private Float otherfee;
	
	//机票类型
	private Long tickettypeid;
	
	//原票价
	private Float yuanprice; 
	
	private Integer msgtype;
	//保险费
	private Float insurprice=0f;
	
	private Integer isstudent;
	
	private String cardvaliddate;
	
	private String country;
	
	private String birthday;
	
	private String destzipcode;
	
	private String destadress;
	
	private String liveaddress;
	
	private Float lirun;
	
	private int issave;
	

	/**
	 * get乘机人ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set乘机人ID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get订单ID
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set订单ID
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get乘机人姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set乘机人姓名
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get乘机人类型
	 */
    public Integer getPtype(){
         return ptype;
    }

	/**
	 * set乘机人类型
	 */
    public void setPtype(Integer ptype){
         this.ptype=ptype;
    }

	/**
	 * get证件类型
	 */
    public Integer getIdtype(){
         return idtype;
    }

	/**
	 * set证件类型
	 */
    public void setIdtype(Integer idtype){
         this.idtype=idtype;
    }

	/**
	 * get证件号
	 */
    public String getIdnumber(){
         return idnumber;
    }

	/**
	 * set证件号
	 */
    public void setIdnumber(String idnumber){
         this.idnumber=idnumber;
    }

	/**
	 * get票价
	 */
    public Float getPrice(){
         return price;
    }

	/**
	 * set票价
	 */
    public void setPrice(Float price){
         this.price=price;
    }

	/**
	 * get燃油费
	 */
    public Float getFuelprice(){
         return fuelprice;
    }

	/**
	 * set燃油费
	 */
    public void setFuelprice(Float fuelprice){
         this.fuelprice=fuelprice;
    }

	/**
	 * get机建费
	 */
    public Float getAirportfee(){
         return airportfee;
    }

	/**
	 * set机建费
	 */
    public void setAirportfee(Float airportfee){
         this.airportfee=airportfee;
    }

	/**
	 * get折扣
	 */
    public Float getDiscount(){
         return discount;
    }

	/**
	 * set折扣
	 */
    public void setDiscount(Float discount){
         this.discount=discount;
    }

	/**
	 * get票号
	 */
    public String getTicketnum(){
         return ticketnum;
    }

	/**
	 * set票号
	 */
    public void setTicketnum(String ticketnum){
         this.ticketnum=ticketnum;
    }

	/**
	 * get行程单号
	 */
    public String getFet(){
         return fet;
    }

	/**
	 * set行程单号
	 */
    public void setFet(String fet){
         this.fet=fet;
    }

	/**
	 * getEI项
	 */
    public String getEi(){
         return ei;
    }

	/**
	 * setEI项
	 */
    public void setEi(String ei){
         this.ei=ei;
    }

	/**
	 * get票状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set票状态
	 */
    public void setState(Integer state){
         this.state=state;
    }

	/**
	 * get退票费
	 */
    public Float getTuifee(){
         return tuifee;
    }

	/**
	 * set退票费
	 */
    public void setTuifee(Float tuifee){
         this.tuifee=tuifee;
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
	 * get出票时间
	 */
    public Timestamp getRttime(){
         return rttime;
    }

	/**
	 * set出票时间
	 */
    public void setRttime(Timestamp rttime){
         this.rttime=rttime;
    }

	/**
	 * get退费票时间
	 */
    public Timestamp getTuitime(){
         return tuitime;
    }

	/**
	 * set退费票时间
	 */
    public void setTuitime(Timestamp tuitime){
         this.tuitime=tuitime;
    }

	/**
	 * get退费票手续费
	 */
    public Float getTuipiaoshouxufe(){
         return tuipiaoshouxufee;
    }

	/**
	 * set退费票手续费
	 */
    public void setTuipiaoshouxufe(Float tuipiaoshouxufee){
         this.tuipiaoshouxufee=tuipiaoshouxufee;
    }

	/**
	 * get还款状态
	 */
    public Long getHkstate(){
         return hkstate;
    }

	/**
	 * set还款状态
	 */
    public void setHkstate(Long hkstate){
         this.hkstate=hkstate;
    }

	/**
	 * get还款已还金额
	 */
    public Float getYihai(){
         return yihai;
    }

	/**
	 * set还款已还金额
	 */
    public void setYihai(Float yihai){
         this.yihai=yihai;
    }

	/**
	 * get还款还欠金额
	 */
    public Float getHaiqian(){
         return haiqian;
    }

	/**
	 * set还款还欠金额
	 */
    public void setHaiqian(Float haiqian){
         this.haiqian=haiqian;
    }

	/**
	 * get退费原因
	 */
    public Long getTuifeiyuanyi(){
         return tuifeiyuanyi;
    }

	/**
	 * set退费原因
	 */
    public void setTuifeiyuanyi(Long tuifeiyuanyi){
         this.tuifeiyuanyi=tuifeiyuanyi;
    }

	/**
	 * get是否取消座位
	 */
    public Long getIscabinsite(){
         return iscabinsite;
    }

	/**
	 * set是否取消座位
	 */
    public void setIscabinsite(Long iscabinsite){
         this.iscabinsite=iscabinsite;
    }

	/**
	 * get退费说明
	 */
    public String getTuifeidesc(){
         return tuifeidesc;
    }

	/**
	 * set退费说明
	 */
    public void setTuifeidesc(String tuifeidesc){
         this.tuifeidesc=tuifeidesc;
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
	 * get退费申请时间
	 */
    public Timestamp getTuifeitime(){
         return tuifeitime;
    }

	/**
	 * set退费申请时间
	 */
    public void setTuifeitime(Timestamp tuifeitime){
         this.tuifeitime=tuifeitime;
    }

	/**
	 * get不能退票原因
	 */
    public String getNotuidesc(){
         return notuidesc;
    }

	/**
	 * set不能退票原因
	 */
    public void setNotuidesc(String notuidesc){
         this.notuidesc=notuidesc;
    }

	/**
	 * get退Or费
	 */
    public Long getTuiorfei(){
         return tuiorfei;
    }

	/**
	 * set退Or费
	 */
    public void setTuiorfei(Long tuiorfei){
         this.tuiorfei=tuiorfei;
    }
    
    /**
	 * get改期日期
	 */
    public String getChangedate(){
         return changedate;
    }
    
    /**
	 * set改期日期
	 */
    public void setChangedate(String changedate){
         this.changedate=changedate;
    }
    
    /**
	 * 改签航班号
	 */
    public String getChangeflight(){
         return changeflight;
    }
    
    /**
	 * set改签航班号
	 */
    public void setChangeflight(String changeflight){
         this.changeflight=changeflight;
    }
    
    /**
	 * get改签舱位
	 */
    public String getChangecabin(){
         return changecabin;
    }
    
    /**
	 * set改签舱位
	 */
    public void setChangecabin(String changecabin){
         this.changecabin=changecabin;
    }
    
    /**
	 * get改签新PNR
	 */
    public String getChangepnr(){
         return changepnr;
    }
    
    /**
	 * set改签新PNR
	 */
    public void setChangepnr(String changepnr){
         this.changepnr=changepnr;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + name +"|"
	   
	 + ptype +"|"
	   
	 + idtype +"|"
	   
	 + idnumber +"|"
	   
	 + price +"|"
	   
	 + fuelprice +"|"
	   
	 + airportfee +"|"
	   
	 + discount +"|"
	   
	 + ticketnum +"|"
	   
	 + fet +"|"
	   
	 + ei +"|"
	   
	 + state +"|"
	   
	 + tuifee +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + rttime +"|"
	   
	 + tuitime +"|"
	   
	 + tuipiaoshouxufee +"|"
	   
	 + hkstate +"|"
	   
	 + yihai +"|"
	   
	 + haiqian +"|"
	   
	 + tuifeiyuanyi +"|"
	   
	 + iscabinsite +"|"
	   
	 + tuifeidesc +"|"
	   
	 + beizhu +"|"
	   
	 + tuifeitime +"|"
	   
	 + notuidesc +"|"
	 
     + changedate +"|"
	 
	 + changeflight +"|"
	 
     + changecabin +"|"
	 
	 + changepnr +"|"
	 
	 + mobile +"|"
	 
	 +tuipiaobili+"|"
	 
	 +anjianfee+"|"
	 
	 +otherfee+"|"
	 
	 +yuanprice+"|"
	   
	 + tuiorfei
	 
	 + "]";
 }

	public Timestamp getRepaytime() {
		return repaytime;
	}

	public void setRepaytime(Timestamp repaytime) {
		this.repaytime = repaytime;
	}

	public String getTuipiaobili() {
		return tuipiaobili;
	}

	public void setTuipiaobili(String tuipiaobili) {
		this.tuipiaobili = tuipiaobili;
	}

	public Float getAnjianfee() {
		return anjianfee;
	}

	public void setAnjianfee(Float anjianfee) {
		this.anjianfee = anjianfee;
	}

	public Float getOtherfee() {
		return otherfee;
	}

	public void setOtherfee(Float otherfee) {
		this.otherfee = otherfee;
	}

	public Long getTickettypeid() {
		return tickettypeid;
	}

	public void setTickettypeid(Long tickettypeid) {
		this.tickettypeid = tickettypeid;
	}

	public Float getYuanprice() {
		return yuanprice;
	}

	public void setYuanprice(Float yuanprice) {
		this.yuanprice = yuanprice;
	}

	public Long getHkmethod() {
		return hkmethod;
	}

	public void setHkmethod(Long hkmethod) {
		this.hkmethod = hkmethod;
	}

	public Integer getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(Integer msgtype) {
		this.msgtype = msgtype;
	}

	public Float getInsurprice() {
		return insurprice;
	}

	public void setInsurprice(Float insurprice) {
		this.insurprice = insurprice;
	}

	public Integer getIsstudent() {
		return isstudent;
	}

	public void setIsstudent(Integer isstudent) {
		this.isstudent = isstudent;
	}

	public String getCardvaliddate() {
		return cardvaliddate;
	}

	public void setCardvaliddate(String cardvaliddate) {
		this.cardvaliddate = cardvaliddate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDestzipcode() {
		return destzipcode;
	}

	public void setDestzipcode(String destzipcode) {
		this.destzipcode = destzipcode;
	}

	public String getDestadress() {
		return destadress;
	}

	public void setDestadress(String destadress) {
		this.destadress = destadress;
	}

	public String getLiveaddress() {
		return liveaddress;
	}

	public void setLiveaddress(String liveaddress) {
		this.liveaddress = liveaddress;
	}

	public Float getLirun() {
		return lirun;
	}

	public void setLirun(Float lirun) {
		this.lirun = lirun;
	}

	public int getIssave() {
		return issave;
	}

	public void setIssave(int issave) {
		this.issave = issave;
	}

}
