/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.fguest;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *国际机票乘机人表
 */
public class FguestBean implements java.io.Serializable{

	/**
	  *国际机票乘机人表 表名
	  */
	public static final String TABLE  = "T_FGUEST";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单编号 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *乘机人姓名 列名 
	  */
    public static final String COL_guestname  = "C_GUESTNAME";
	
	/**
	  *是否是学生 列名 
	  */
    public static final String COL_isstudent  = "C_ISSTUDENT";
	
	/**
	  *乘机人证件号 列名 
	  */
    public static final String COL_guestidno  = "C_GUESTIDNO";
	
	/**
	  *国家代码 列名 
	  */
    public static final String COL_countrycode  = "C_COUNTRYCODE";
	
	/**
	  *乘机人类型 列名 
	  */
    public static final String COL_guesttype  = "C_GUESTTYPE";
	
	/**
	  *乘机人性别 列名 
	  */
    public static final String COL_gender  = "C_GENDER";
	
	/**
	  *乘机人生日 列名 
	  */
    public static final String COL_birthday  = "C_BIRTHDAY";
	
	/**
	  *目的地邮编 列名 
	  */
    public static final String COL_targetzipcode  = "C_TARGETZIPCODE";
	
	/**
	  *目的地地址 列名 
	  */
    public static final String COL_targetaddress  = "C_TARGETADDRESS";
	
	/**
	  *现居住地址 列名 
	  */
    public static final String COL_liveaddress  = "C_LIVEADDRESS";
    
    /**
     * 票面价
     */
    public static final String COL_ticketprice="C_TICKETPRICE";
    
    /**
     * 出发站机建费
     */
    public static final String COL_sairportfee="C_SAIRPORTFEE";
    
    /**
     * 到达站机建费
     */
    public static final String COL_eairportfee="C_EAIRPORTFEE";
    
    /**
     * 燃油费
     */
    public static final String COL_fuelfee="C_FUELFEE";
    
    /**
     * 机场安检费
     */
    public static final String COL_anjianfee="C_ANJIANFEE";
    
    /**
     * 票号
     */
    public static final String COL_ticketnumber="C_TICKETNUMBER";
    
    /**
     * 行程单号
     */
    public static final String COL_fetnumber="C_FETNUMBER";
    
    /**
     * 手机号
     */
    public static final String COL_mobile="C_MOBILE";
    
    
    
    

	//ID
	private long id;    
    

	//订单编号
	private Long orderid;    
    

	//乘机人姓名
	private String guestname;    
    

	//是否是学生
	private Integer isstudent;    
    

	//乘机人证件号
	private String guestidno;    
    

	//国家代码
	private String countrycode;    
    

	//乘机人类型
	private Integer guesttype;    
    

	//乘机人性别
	private Integer gender;    
    

	//乘机人生日
	private Timestamp birthday;    
    

	//目的地邮编
	private String targetzipcode;    
    

	//目的地地址
	private String targetaddress;    
    

	//现居住地址
	private String liveaddress;  
	
	//票面价
	private Float ticketprice;
	
	//出发站机建费
	private Float sairportfee;
	
	//到达站机建费
	private Float eairportfee;
	
	//燃油费
	private Float fuelfee;
	
	//安检费
	private Float anjianfee;
	
	//票号
	private String ticketnumber;  
	
	//行程单号
	private String fetnumber;  
	
	//手机号
	private String mobile;  
    

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
	 * get订单编号
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set订单编号
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get乘机人姓名
	 */
    public String getGuestname(){
         return guestname;
    }

	/**
	 * set乘机人姓名
	 */
    public void setGuestname(String guestname){
         this.guestname=guestname;
    }

	/**
	 * get是否是学生
	 */
    public Integer getIsstudent(){
         return isstudent;
    }

	/**
	 * set是否是学生
	 */
    public void setIsstudent(Integer isstudent){
         this.isstudent=isstudent;
    }

	/**
	 * get乘机人证件号
	 */
    public String getGuestidno(){
         return guestidno;
    }

	/**
	 * set乘机人证件号
	 */
    public void setGuestidno(String guestidno){
         this.guestidno=guestidno;
    }

	/**
	 * get国家代码
	 */
    public String getCountrycode(){
         return countrycode;
    }

	/**
	 * set国家代码
	 */
    public void setCountrycode(String countrycode){
         this.countrycode=countrycode;
    }

	/**
	 * get乘机人类型
	 */
    public Integer getGuesttype(){
         return guesttype;
    }

	/**
	 * set乘机人类型
	 */
    public void setGuesttype(Integer guesttype){
         this.guesttype=guesttype;
    }

	/**
	 * get乘机人性别
	 */
    public Integer getGender(){
         return gender;
    }

	/**
	 * set乘机人性别
	 */
    public void setGender(Integer gender){
         this.gender=gender;
    }

	/**
	 * get乘机人生日
	 */
    public Timestamp getBirthday(){
         return birthday;
    }

	/**
	 * set乘机人生日
	 */
    public void setBirthday(Timestamp birthday){
         this.birthday=birthday;
    }

	/**
	 * get目的地邮编
	 */
    public String getTargetzipcode(){
         return targetzipcode;
    }

	/**
	 * set目的地邮编
	 */
    public void setTargetzipcode(String targetzipcode){
         this.targetzipcode=targetzipcode;
    }

	/**
	 * get目的地地址
	 */
    public String getTargetaddress(){
         return targetaddress;
    }

	/**
	 * set目的地地址
	 */
    public void setTargetaddress(String targetaddress){
         this.targetaddress=targetaddress;
    }

	/**
	 * get现居住地址
	 */
    public String getLiveaddress(){
         return liveaddress;
    }

	/**
	 * set现居住地址
	 */
    public void setLiveaddress(String liveaddress){
         this.liveaddress=liveaddress;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + guestname +"|"
	   
	 + isstudent +"|"
	   
	 + guestidno +"|"
	   
	 + countrycode +"|"
	   
	 + guesttype +"|"
	   
	 + gender +"|"
	   
	 + birthday +"|"
	   
	 + targetzipcode +"|"
	   
	 + targetaddress +"|"
	 
	 + ticketprice +"|"
	 
	 + sairportfee +"|"
	 
	 + eairportfee +"|"
	 
	 + fuelfee +"|"
	 
	 + anjianfee +"|"
	 
	 + ticketnumber +"|"
	 
	 + fetnumber +"|"
	 
	 + mobile +"|"

	 + liveaddress
	 + "]";
 }

	public Float getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(Float ticketprice) {
		this.ticketprice = ticketprice;
	}

	public Float getSairportfee() {
		return sairportfee;
	}

	public void setSairportfee(Float sairportfee) {
		this.sairportfee = sairportfee;
	}

	public Float getEairportfee() {
		return eairportfee;
	}

	public void setEairportfee(Float eairportfee) {
		this.eairportfee = eairportfee;
	}

	public Float getFuelfee() {
		return fuelfee;
	}

	public void setFuelfee(Float fuelfee) {
		this.fuelfee = fuelfee;
	}

	public Float getAnjianfee() {
		return anjianfee;
	}

	public void setAnjianfee(Float anjianfee) {
		this.anjianfee = anjianfee;
	}

	public String getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	public String getFetnumber() {
		return fetnumber;
	}

	public void setFetnumber(String fetnumber) {
		this.fetnumber = fetnumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 

}
