/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.creditcard;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *信用卡记录表
 */
public class CreditcardBean implements java.io.Serializable{

	/**
	  *信用卡记录表 表名
	  */
	public static final String TABLE  = "T_CREDITCARD";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_ID  = "ID";
	
	/**
	  *会员id 列名 联系人
	  */
    public static final String COL_customeruserid  = "C_CUSTOMERUSERID";
    
    /**
	  *酒店订单ID 列名 
	  */
    public static final String COL_hotelorderid  = "C_HOTELORDERID";
	
	/**
	  *银行名称 列名 
	  */
    public static final String COL_creditbank  = "C_CREDITBANK";
	
	/**
	  *信用卡号 列名 
	  */
    public static final String COL_creditnumber  = "C_CREDITNUMBER";
    
	/**
	  *信用卡号有效年 列名 
	  */
   public static final String COL_cardyear  = "C_CARDYEAR";
   
   /**
	  *信用卡号有效月 列名 
	  */
   public static final String COL_cardmonth  = "C_CARDMONTH";
   
   /**
	  *信用卡持姓名 列名 
	  */
   public static final String COL_cardname  = "C_CARDNAME";
   
    /**
	  *持卡人证件类型 列名 
	  */
   public static final String COL_idtype  = "C_IDTYPE";
   
   /**
	  *持卡人证件号码 列名 
	  */
    public static final String COL_idno  = "C_IDNO";
	
	/**
	  *有效期 列名 
	  */
    public static final String COL_creditexpiry  = "C_CREDITEXPIRY";
	
	/**
	  *验证码 列名 
	  */
    public static final String COL_creditcheckcode  = "C_CREDITCHECKCODE";

	//ID
	private long ID;    
    

	//会员id
	private long customeruserid;    
    
	//酒店订单id
	private long hotelorderid;   

	//银行名称
	private String creditbank;    
    

	//信用卡号
	private String creditnumber;    
    

	//有效期
	private Timestamp creditexpiry;   
	
	//有效期年
	private int cardyear;   
	
	//有效期月
	private int cardmonth; 
	
	//持卡人姓名
	private String cardname; 
	
	//证件类型
	private String idtype; 
	
	//证件号码
	private String idno; 

	//验证码
	private String creditcheckcode;    
    

	/**
	 * getID
	 */
    public long getId(){
         return ID;
    }

	/**
	 * setID
	 */
    public void setId(long ID){
         this.ID=ID;
    }

	/**
	 * get会员id
	 */
    public long getCustomeruserid(){
         return customeruserid;
    }

	/**
	 * set会员id
	 */
    public void setCustomeruserid(long customeruserid){
         this.customeruserid=customeruserid;
    }

	/**
	 * get银行名称
	 */
    public String getCreditbank(){
         return creditbank;
    }

	/**
	 * set银行名称
	 */
    public void setCreditbank(String creditbank){
         this.creditbank=creditbank;
    }

	/**
	 * get信用卡号
	 */
    public String getCreditnumber(){
         return creditnumber;
    }

	/**
	 * set信用卡号
	 */
    public void setCreditnumber(String creditnumber){
         this.creditnumber=creditnumber;
    }

	/**
	 * get有效期
	 */
    public Timestamp getCreditexpiry(){
         return creditexpiry;
    }

	/**
	 * set有效期
	 */
    public void setCreditexpiry(Timestamp creditexpiry){
         this.creditexpiry=creditexpiry;
    }

	/**
	 * get验证码
	 */
    public String getCreditcheckcode(){
         return creditcheckcode;
    }

	/**
	 * set验证码
	 */
    public void setCreditcheckcode(String creditcheckcode){
         this.creditcheckcode=creditcheckcode;
    }


	public String toString(){

	return "[" 
	 + ID +"|"
	   
	 + customeruserid +"|"
	 
	 + hotelorderid +"|"
	 
	 + cardyear +"|"
	 
	 + cardmonth +"|"
	 
	 + cardname +"|"
	 
	 + idtype +"|"
	 
	 + idno +"|"
	   
	 + creditbank +"|"
	   
	 + creditnumber +"|"
	   
	 + creditexpiry +"|"
	   
	 + creditcheckcode
	 + "]";
 }

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
	}

	public long getHotelorderid() {
		return hotelorderid;
	}

	public void setHotelorderid(long hotelorderid) {
		this.hotelorderid = hotelorderid;
	}

	public int getCardyear() {
		return cardyear;
	}

	public void setCardyear(int cardyear) {
		this.cardyear = cardyear;
	}

	public int getCardmonth() {
		return cardmonth;
	}

	public void setCardmonth(int cardmonth) {
		this.cardmonth = cardmonth;
	}



	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	} 

}
