/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotel;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店
 */
public class HotelBean implements java.io.Serializable{

	/**
	  *酒店 表名
	  */
	public static final String TABLE  = "T_HOTEL";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *洒店名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *英文名称 列名 
	  */
    public static final String COL_enname  = "C_ENNAME";
	
	/**
	  *星级 列名 
	  */
    public static final String COL_star  = "C_STAR";
	
	/**
	  *推荐级别 列名 
	  */
    public static final String COL_hot  = "C_HOT";
	
	/**
	  *装修级别 列名 
	  */
    public static final String COL_repair  = "C_REPAIR";
	
	/**
	  *国家ID 列名 
	  */
    public static final String COL_contryid  = "C_CONTRYID";
	
	/**
	  *省份ID 列名 
	  */
    public static final String COL_provinceid  = "C_PROVINCEID";
	
	/**
	  *城市ID 列名 
	  */
    public static final String COL_cityid  = "C_CITYID";
	
	/**
	  *行政区ID 列名 
	  */
    public static final String COL_regionid1  = "C_REGIONID1";
	
	/**
	  *商业区ID 列名 
	  */
    public static final String COL_regionid2  = "C_REGIONID2";
	
	/**
	  *景区ID 列名 
	  */
    public static final String COL_regionid3  = "C_REGIONID3";
	
	/**
	  *酒店地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *酒店描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *洒店类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *房间总数 列名 
	  */
    public static final String COL_rooms  = "C_ROOMS";
	
	/**
	  *餐饮设施 列名 
	  */
    public static final String COL_footitem  = "C_FOOTITEM";
	
	/**
	  *服务设施 列名 
	  */
    public static final String COL_serviceitem  = "C_SERVICEITEM";
	
	/**
	  *会议设施 列名 
	  */
    public static final String COL_meetingitem  = "C_MEETINGITEM";
	
	/**
	  *娱乐设施 列名 
	  */
    public static final String COL_playitem  = "C_PLAYITEM";
	
	/**
	  *可接受卡类型 列名 
	  */
    public static final String COL_carttype  = "C_CARTTYPE";
	
	/**
	  *装修时间 列名 
	  */
    public static final String COL_repaildate  = "C_REPAILDATE";
	
	/**
	  *周边酒店 列名 
	  */
    public static final String COL_nearhotel  = "C_NEARHOTEL";
	
	/**
	  *邮编 列名 
	  */
    public static final String COL_postcode  = "C_POSTCODE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *全拼 列名 
	  */
    public static final String COL_pyname  = "C_PYNAME";
	
	/**
	  *简拼 列名 
	  */
    public static final String COL_jpname  = "C_JPNAME";
	
	/**
	  *是否主楼 列名 
	  */
    public static final String COL_mainfloor  = "C_MAINFLOOR";
	
	/**
	  *网上推荐 列名 
	  */
    public static final String COL_websign  = "C_WEBSIGN";
	
	/**
	  *开业时间 列名 
	  */
    public static final String COL_opendate  = "C_OPENDATE";
	
	/**
	  *传真说明 列名 
	  */
    public static final String COL_faxdesc  = "C_FAXDESC";
	
	/**
	  *销售电话 列名 
	  */
    public static final String COL_markettell  = "C_MARKETTELL";
	
	/**
	  *总机电话 列名 
	  */
    public static final String COL_tortell  = "C_TORTELL";
	
	/**
	  *预订要求 列名 
	  */
    public static final String COL_prespec  = "C_PRESPEC";
	
	/**
	  *附楼高度 列名 
	  */
    public static final String COL_appendlever  = "C_APPENDLEVER";
	
	/**
	  *主楼高度 列名 
	  */
    public static final String COL_mainlevel  = "C_MAINLEVEL";
	
	/**
	  *状态备注 列名 
	  */
    public static final String COL_statedesc  = "C_STATEDESC";
	
	/**
	  *酒店卖点 列名 
	  */
    public static final String COL_sellpoint  = "C_SELLPOINT";
	
	/**
	  *全称 列名 
	  */
    public static final String COL_fullname  = "C_FULLNAME";
	
	/**
	  *开户行 列名 
	  */
    public static final String COL_openbank  = "C_OPENBANK";
	
	/**
	  *开户账号 列名 
	  */
    public static final String COL_bankaccount  = "C_BANKACCOUNT";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_sort  = "C_SORT";
	
	/**
	  *企业ID 列名 
	  */
    public static final String COL_companyid  = "C_COMPANYID";
	
	/**
	  *审核意见 列名 
	  */
    public static final String COL_checkdesc  = "C_CHECKDESC";
	
	/**
	  *传真2 列名 
	  */
    public static final String COL_fax2  = "C_FAX2";
	
	/**
	  *传真1 列名 
	  */
    public static final String COL_fax1  = "C_FAX1";
	
	/**
	  *起价 列名 
	  */
    public static final String COL_startprice  = "C_STARTPRICE";
	
	/**
	  *纬度 列名 
	  */
    public static final String COL_lng  = "C_LNG";
	
	/**
	  *经度 列名 
	  */
    public static final String COL_lat  = "C_LAT";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *国家ID 列名 
	  */
    public static final String COL_countryid  = "C_COUNTRYID";
	
	/**
	  *酒店来源 列名 
	  */
    public static final String COL_sourcetype  = "C_SOURCETYPE";
	
	/**
	  *酒店编码 列名 
	  */
    public static final String COL_hotelcode  = "C_HOTELCODE";
	
	/**
	  *接机服务 列名 
	  */
    public static final String COL_airportservice  = "C_AIRPORTSERVICE";
	
	/**
	  *交通信息 列名 
	  */
    public static final String COL_trafficinfo  = "C_TRAFFICINFO";
	
	/**
	  *支付类型 列名 
	  */
    public static final String COL_paytype  = "C_PAYTYPE";
	
	/**
	  *日审类型 列名 
	  */
    public static final String COL_checktype  = "C_CHECKTYPE";
    
    /**
	  *返点方式 列名 
	  */
   public static final String COL_rebateway  = "C_REBATEWAY";
	
	/**
	  *返现规则 列名 
	  */
   public static final String COL_rulesback  = "C_RULESBACK";
	
	/**
	  *付款方式 列名 
	  */
   public static final String COL_payment  = "C_PAYMENT";
	
	/**
	  *连锁酒店ID 列名 
	  */
   public static final String COL_chaininfoid  = "C_CHAININFOID";
   
   /**
	  *返现类型列名 
	  */
   public static final String COL_meneyback  = "C_MENEYBACK";
   
   /**
	  *价格类型列名 
	  */
 public static final String COL_pricetype  = "C_PRICETYPE";
    

	//ID
	private long id;    
    

	//洒店名称
	private String name;    
    

	//英文名称
	private String enname;    
    

	//星级
	private Integer star;    
    

	//推荐级别
	private Integer hot;    
    

	//装修级别
	private Integer repair;    
    

	//国家ID
	private Long contryid;    
    

	//省份ID
	private Long provinceid;    
    

	//城市ID
	private Long cityid;    
    

	//行政区ID
	private Long regionid1;    
    

	//商业区ID
	private Long regionid2;    
    

	//景区ID
	private Long regionid3;    
    

	//酒店地址
	private String address;    
    

	//酒店描述
	private String description;    
    

	//洒店类型
	private Integer type;    
    

	//房间总数
	private Integer rooms;    
    

	//餐饮设施
	private String footitem;    
    

	//服务设施
	private String serviceitem;    
    

	//会议设施
	private String meetingitem;    
    

	//娱乐设施
	private String playitem;    
    

	//可接受卡类型
	private String carttype;    
    

	//装修时间
	private String repaildate;    
    

	//周边酒店
	private String nearhotel;    
    

	//邮编
	private String postcode;    
    

	//状态
	private Integer state;    
    

	//全拼
	private String pyname;    
    

	//简拼
	private String jpname;    
    

	//是否主楼
	private String mainfloor;    
    

	//网上推荐
	private Integer websign;    
    

	//开业时间
	private Date opendate;    
    

	//传真说明
	private String faxdesc;    
    

	//销售电话
	private String markettell;    
    

	//总机电话
	private String tortell;    
    

	//预订要求
	private String prespec;    
    

	//附楼高度
	private Integer appendlever;    
    

	//主楼高度
	private Integer mainlevel;    
    

	//状态备注
	private String statedesc;    
    

	//酒店卖点
	private String sellpoint;    
    

	//全称  现在用于保存酒店连锁酒店名字
	private String fullname;    
    

	//开户行
	private String openbank;    
    

	//开户账号
	private String bankaccount;    
    

	//排序
	private Long sort;    
    

	//企业ID
	private Long companyid;    
    

	//审核意见
	private String checkdesc;    
    

	//传真2
	private String fax2;    
    

	//传真1
	private String fax1;    
    

	//起价
	private Double startprice;    
    

	//纬度
	private Double lng;    
    

	//经度
	private Double lat;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

	//国家ID
	private Long countryid;    
    

	//酒店来源
	private Long sourcetype;    
    

	//酒店编码
	private String hotelcode;    
    

	//接机服务
	private String airportservice;    
    

	//交通信息
	private String trafficinfo;    
    

	//支付类型
	private Long paytype;    
    

	//日审类型
	private Long checktype;    
	
	//返点方式
	private Long rebateway;    
    

	//返现规则
	private String rulesback;    
    

	//付款方式
	private Long payment;    
    

	//连锁酒店ID
	private Long chaininfoid; 
	
	//返现类型
	private Long meneyback;
    
	
	//价格单位
	private String pricetype;    

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
	 * get洒店名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set洒店名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get英文名称
	 */
    public String getEnname(){
         return enname;
    }

	/**
	 * set英文名称
	 */
    public void setEnname(String enname){
         this.enname=enname;
    }

	/**
	 * get星级
	 */
    public Integer getStar(){
         return star;
    }

	/**
	 * set星级
	 */
    public void setStar(Integer star){
         this.star=star;
    }

	/**
	 * get推荐级别
	 */
    public Integer getHot(){
         return hot;
    }

	/**
	 * set推荐级别
	 */
    public void setHot(Integer hot){
         this.hot=hot;
    }

	/**
	 * get装修级别
	 */
    public Integer getRepair(){
         return repair;
    }

	/**
	 * set装修级别
	 */
    public void setRepair(Integer repair){
         this.repair=repair;
    }

	/**
	 * get国家ID
	 */
    public Long getContryid(){
         return contryid;
    }

	/**
	 * set国家ID
	 */
    public void setContryid(Long contryid){
         this.contryid=contryid;
    }

	/**
	 * get省份ID
	 */
    public Long getProvinceid(){
         return provinceid;
    }

	/**
	 * set省份ID
	 */
    public void setProvinceid(Long provinceid){
         this.provinceid=provinceid;
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
	 * get行政区ID
	 */
    public Long getRegionid1(){
         return regionid1;
    }

	/**
	 * set行政区ID
	 */
    public void setRegionid1(Long regionid1){
         this.regionid1=regionid1;
    }

	/**
	 * get商业区ID
	 */
    public Long getRegionid2(){
         return regionid2;
    }

	/**
	 * set商业区ID
	 */
    public void setRegionid2(Long regionid2){
         this.regionid2=regionid2;
    }

	/**
	 * get景区ID
	 */
    public Long getRegionid3(){
         return regionid3;
    }

	/**
	 * set景区ID
	 */
    public void setRegionid3(Long regionid3){
         this.regionid3=regionid3;
    }

	/**
	 * get酒店地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set酒店地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get酒店描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set酒店描述
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get洒店类型
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set洒店类型
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get房间总数
	 */
    public Integer getRooms(){
         return rooms;
    }

	/**
	 * set房间总数
	 */
    public void setRooms(Integer rooms){
         this.rooms=rooms;
    }

	/**
	 * get餐饮设施
	 */
    public String getFootitem(){
         return footitem;
    }

	/**
	 * set餐饮设施
	 */
    public void setFootitem(String footitem){
         this.footitem=footitem;
    }

	/**
	 * get服务设施
	 */
    public String getServiceitem(){
         return serviceitem;
    }

	/**
	 * set服务设施
	 */
    public void setServiceitem(String serviceitem){
         this.serviceitem=serviceitem;
    }

	/**
	 * get会议设施
	 */
    public String getMeetingitem(){
         return meetingitem;
    }

	/**
	 * set会议设施
	 */
    public void setMeetingitem(String meetingitem){
         this.meetingitem=meetingitem;
    }

	/**
	 * get娱乐设施
	 */
    public String getPlayitem(){
         return playitem;
    }

	/**
	 * set娱乐设施
	 */
    public void setPlayitem(String playitem){
         this.playitem=playitem;
    }

	/**
	 * get可接受卡类型
	 */
    public String getCarttype(){
         return carttype;
    }

	/**
	 * set可接受卡类型
	 */
    public void setCarttype(String carttype){
         this.carttype=carttype;
    }

	/**
	 * get装修时间
	 */
    public String getRepaildate(){
         return repaildate;
    }

	/**
	 * set装修时间
	 */
    public void setRepaildate(String repaildate){
         this.repaildate=repaildate;
    }

	/**
	 * get周边酒店
	 */
    public String getNearhotel(){
         return nearhotel;
    }

	/**
	 * set周边酒店
	 */
    public void setNearhotel(String nearhotel){
         this.nearhotel=nearhotel;
    }

	/**
	 * get邮编
	 */
    public String getPostcode(){
         return postcode;
    }

	/**
	 * set邮编
	 */
    public void setPostcode(String postcode){
         this.postcode=postcode;
    }

	/**
	 * get状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Integer state){
         this.state=state;
    }

	/**
	 * get全拼
	 */
    public String getPyname(){
         return pyname;
    }

	/**
	 * set全拼
	 */
    public void setPyname(String pyname){
         this.pyname=pyname;
    }

	/**
	 * get简拼
	 */
    public String getJpname(){
         return jpname;
    }

	/**
	 * set简拼
	 */
    public void setJpname(String jpname){
         this.jpname=jpname;
    }

	/**
	 * get是否主楼
	 */
    public String getMainfloor(){
         return mainfloor;
    }

	/**
	 * set是否主楼
	 */
    public void setMainfloor(String mainfloor){
         this.mainfloor=mainfloor;
    }

	/**
	 * get网上推荐
	 */
    public Integer getWebsign(){
         return websign;
    }

	/**
	 * set网上推荐
	 */
    public void setWebsign(Integer websign){
         this.websign=websign;
    }

	/**
	 * get开业时间
	 */
    public Date getOpendate(){
         return opendate;
    }

	/**
	 * set开业时间
	 */
    public void setOpendate(Date opendate){
         this.opendate=opendate;
    }

	/**
	 * get传真说明
	 */
    public String getFaxdesc(){
         return faxdesc;
    }

	/**
	 * set传真说明
	 */
    public void setFaxdesc(String faxdesc){
         this.faxdesc=faxdesc;
    }

	/**
	 * get销售电话
	 */
    public String getMarkettell(){
         return markettell;
    }

	/**
	 * set销售电话
	 */
    public void setMarkettell(String markettell){
         this.markettell=markettell;
    }

	/**
	 * get总机电话
	 */
    public String getTortell(){
         return tortell;
    }

	/**
	 * set总机电话
	 */
    public void setTortell(String tortell){
         this.tortell=tortell;
    }

	/**
	 * get预订要求
	 */
    public String getPrespec(){
         return prespec;
    }

	/**
	 * set预订要求
	 */
    public void setPrespec(String prespec){
         this.prespec=prespec;
    }

	/**
	 * get附楼高度
	 */
    public Integer getAppendlever(){
         return appendlever;
    }

	/**
	 * set附楼高度
	 */
    public void setAppendlever(Integer appendlever){
         this.appendlever=appendlever;
    }

	/**
	 * get主楼高度
	 */
    public Integer getMainlevel(){
         return mainlevel;
    }

	/**
	 * set主楼高度
	 */
    public void setMainlevel(Integer mainlevel){
         this.mainlevel=mainlevel;
    }

	/**
	 * get状态备注
	 */
    public String getStatedesc(){
         return statedesc;
    }

	/**
	 * set状态备注
	 */
    public void setStatedesc(String statedesc){
         this.statedesc=statedesc;
    }

	/**
	 * get酒店卖点
	 */
    public String getSellpoint(){
         return sellpoint;
    }

	/**
	 * set酒店卖点
	 */
    public void setSellpoint(String sellpoint){
         this.sellpoint=sellpoint;
    }

	/**
	 * get全称
	 */
    public String getFullname(){
         return fullname;
    }

	/**
	 * set全称
	 */
    public void setFullname(String fullname){
         this.fullname=fullname;
    }

	/**
	 * get开户行
	 */
    public String getOpenbank(){
         return openbank;
    }

	/**
	 * set开户行
	 */
    public void setOpenbank(String openbank){
         this.openbank=openbank;
    }

	/**
	 * get开户账号
	 */
    public String getBankaccount(){
         return bankaccount;
    }

	/**
	 * set开户账号
	 */
    public void setBankaccount(String bankaccount){
         this.bankaccount=bankaccount;
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
	 * get企业ID
	 */
    public Long getCompanyid(){
         return companyid;
    }

	/**
	 * set企业ID
	 */
    public void setCompanyid(Long companyid){
         this.companyid=companyid;
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
	 * get传真2
	 */
    public String getFax2(){
         return fax2;
    }

	/**
	 * set传真2
	 */
    public void setFax2(String fax2){
         this.fax2=fax2;
    }

	/**
	 * get传真1
	 */
    public String getFax1(){
         return fax1;
    }

	/**
	 * set传真1
	 */
    public void setFax1(String fax1){
         this.fax1=fax1;
    }

	/**
	 * get起价
	 */
    public Double getStartprice(){
         return startprice;
    }

	/**
	 * set起价
	 */
    public void setStartprice(Double startprice){
         this.startprice=startprice;
    }

	/**
	 * get纬度
	 */
    public Double getLng(){
         return lng;
    }

	/**
	 * set纬度
	 */
    public void setLng(Double lng){
         this.lng=lng;
    }

	/**
	 * get经度
	 */
    public Double getLat(){
         return lat;
    }

	/**
	 * set经度
	 */
    public void setLat(Double lat){
         this.lat=lat;
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
	 * get国家ID
	 */
    public Long getCountryid(){
         return countryid;
    }

	/**
	 * set国家ID
	 */
    public void setCountryid(Long countryid){
         this.countryid=countryid;
    }

	/**
	 * get酒店来源
	 */
    public Long getSourcetype(){
         return sourcetype;
    }

	/**
	 * set酒店来源
	 */
    public void setSourcetype(Long sourcetype){
         this.sourcetype=sourcetype;
    }

	/**
	 * get酒店编码
	 */
    public String getHotelcode(){
         return hotelcode;
    }

	/**
	 * set酒店编码
	 */
    public void setHotelcode(String hotelcode){
         this.hotelcode=hotelcode;
    }

	/**
	 * get接机服务
	 */
    public String getAirportservice(){
         return airportservice;
    }

	/**
	 * set接机服务
	 */
    public void setAirportservice(String airportservice){
         this.airportservice=airportservice;
    }

	/**
	 * get交通信息
	 */
    public String getTrafficinfo(){
         return trafficinfo;
    }

	/**
	 * set交通信息
	 */
    public void setTrafficinfo(String trafficinfo){
         this.trafficinfo=trafficinfo;
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
	 * get返点方式
	 */
    public Long getRebateway(){
         return rebateway;
    }

	/**
	 * set返点方式
	 */
    public void setRebateway(Long rebateway){
         this.rebateway=rebateway;
    }

	/**
	 * get返现规则
	 */
    public String getRulesback(){
         return rulesback;
    }

	/**
	 * set返现规则
	 */
    public void setRulesback(String rulesback){
         this.rulesback=rulesback;
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
	 * get连锁酒店ID
	 */
    public Long getChaininfoid(){
         return chaininfoid;
    }

	/**
	 * set连锁酒店ID
	 */
    public void setChaininfoid(Long chaininfoid){
         this.chaininfoid=chaininfoid;
    }
    
    /**
	 * get返现类型
	 */
    public Long getMeneyback(){
         return meneyback;
    }

	/**
	 * set返现类型
	 */
    public void setMeneyback(Long meneyback){
         this.meneyback=meneyback;
    }
    
    
    

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + enname +"|"
	   
	 + star +"|"
	   
	 + hot +"|"
	   
	 + repair +"|"
	   
	 + contryid +"|"
	   
	 + provinceid +"|"
	   
	 + cityid +"|"
	   
	 + regionid1 +"|"
	   
	 + regionid2 +"|"
	   
	 + regionid3 +"|"
	   
	 + address +"|"
	   
	 + description +"|"
	   
	 + type +"|"
	   
	 + rooms +"|"
	   
	 + footitem +"|"
	   
	 + serviceitem +"|"
	   
	 + meetingitem +"|"
	   
	 + playitem +"|"
	   
	 + carttype +"|"
	   
	 + repaildate +"|"
	   
	 + nearhotel +"|"
	   
	 + postcode +"|"
	   
	 + state +"|"
	   
	 + pyname +"|"
	   
	 + jpname +"|"
	   
	 + mainfloor +"|"
	   
	 + websign +"|"
	   
	 + opendate +"|"
	   
	 + faxdesc +"|"
	   
	 + markettell +"|"
	   
	 + tortell +"|"
	   
	 + prespec +"|"
	   
	 + appendlever +"|"
	   
	 + mainlevel +"|"
	   
	 + statedesc +"|"
	   
	 + sellpoint +"|"
	   
	 + fullname +"|"
	   
	 + openbank +"|"
	   
	 + bankaccount +"|"
	   
	 + sort +"|"
	   
	 + companyid +"|"
	   
	 + checkdesc +"|"
	   
	 + fax2 +"|"
	   
	 + fax1 +"|"
	   
	 + startprice +"|"
	   
	 + lng +"|"
	   
	 + lat +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + countryid +"|"
	   
	 + sourcetype +"|"
	   
	 + hotelcode +"|"
	   
	 + airportservice +"|"
	   
	 + trafficinfo +"|"
	   
	 + paytype +"|"
	   
	 + checktype +"|"
	   
	 + rebateway +"|"
	   
	 + rulesback +"|"
	   
	 + payment +"|"
	   
	 + chaininfoid+"|"
	 
	 + pricetype+"|"
	 
	 
	 
	 + meneyback
	 + "]";
 }

	public String getPricetype() {
		return pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	} 

}
