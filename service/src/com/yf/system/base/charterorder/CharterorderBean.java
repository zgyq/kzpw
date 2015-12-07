/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.charterorder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *包机订单
 */
public class CharterorderBean implements java.io.Serializable{

	/**
	  *包机订单 表名
	  */
	public static final String TABLE  = "T_CHARTERORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_num  = "C_NUM";
	
	/**
	  *最多人数 列名 
	  */
    public static final String COL_maxnum  = "C_MAXNUM";
	
	/**
	  *申请人 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *单位名字 列名 
	  */
    public static final String COL_unitname  = "C_UNITNAME";
	
	/**
	  *联系地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *邮编 列名 
	  */
    public static final String COL_zipcode  = "C_ZIPCODE";
	
	/**
	  *电话 列名 
	  */
    public static final String COL_tel  = "C_TEL";
	
	/**
	  *QQ 列名 
	  */
    public static final String COL_qq  = "C_QQ";
	
	/**
	  *传真 列名 
	  */
    public static final String COL_fax  = "C_FAX";
	
	/**
	  *邮箱 列名 
	  */
    public static final String COL_mailbox  = "C_MAILBOX";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_remarks  = "C_REMARKS";
	
	/**
	  *总价格 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *航程类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *乘客类型 列名 
	  */
    public static final String COL_usertype  = "C_USERTYPE";
	
	/**
	  *最早时间 列名 
	  */
    public static final String COL_stime  = "C_STIME";
	
	/**
	  *最晚时间 列名 
	  */
    public static final String COL_etime  = "C_ETIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
    
    /**
	  *服务类型 列名 
	  */
   public static final String COL_servicetype  = "C_SERVICETYPE";
   
   /**
	  *订单编号 列名 
	  */
   public static final String COL_ordercode  = "C_ORDERCODE";

	//ID
	private long id;    
    

	//人数
	private String num;    
    

	//最多人数
	private String maxnum;    
    

	//申请人
	private String name;    
    

	//手机
	private String mobile;    
    

	//单位名字
	private String unitname;    
    

	//联系地址
	private String address;    
    

	//邮编
	private String zipcode;    
    

	//电话
	private String tel;    
    

	//QQ
	private String qq;    
    

	//传真
	private String fax;    
    

	//邮箱
	private String mailbox;    
    

	//备注
	private String remarks;    
    

	//总价格
	private String price;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
	private Long memberid;    
    

	//航程类型
	private Long type;  
	
	//服务类型
	private Long servicetype;
    
	//订单编号
	private String ordercode;
	
	
	//乘客类型
	private Long usertype;    
    

	//最早时间
	private String stime;    
    

	//最晚时间
	private String etime;    
    

	//状态
	private Long state;    
    

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
	 * get人数
	 */
    public String getNum(){
         return num;
    }

	/**
	 * set人数
	 */
    public void setNum(String num){
         this.num=num;
    }

	/**
	 * get最多人数
	 */
    public String getMaxnum(){
         return maxnum;
    }

	/**
	 * set最多人数
	 */
    public void setMaxnum(String maxnum){
         this.maxnum=maxnum;
    }

	/**
	 * get申请人
	 */
    public String getName(){
         return name;
    }

	/**
	 * set申请人
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get单位名字
	 */
    public String getUnitname(){
         return unitname;
    }

	/**
	 * set单位名字
	 */
    public void setUnitname(String unitname){
         this.unitname=unitname;
    }

	/**
	 * get联系地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set联系地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get邮编
	 */
    public String getZipcode(){
         return zipcode;
    }

	/**
	 * set邮编
	 */
    public void setZipcode(String zipcode){
         this.zipcode=zipcode;
    }

	/**
	 * get电话
	 */
    public String getTel(){
         return tel;
    }

	/**
	 * set电话
	 */
    public void setTel(String tel){
         this.tel=tel;
    }

	/**
	 * getQQ
	 */
    public String getQq(){
         return qq;
    }

	/**
	 * setQQ
	 */
    public void setQq(String qq){
         this.qq=qq;
    }

	/**
	 * get传真
	 */
    public String getFax(){
         return fax;
    }

	/**
	 * set传真
	 */
    public void setFax(String fax){
         this.fax=fax;
    }

	/**
	 * get邮箱
	 */
    public String getMailbox(){
         return mailbox;
    }

	/**
	 * set邮箱
	 */
    public void setMailbox(String mailbox){
         this.mailbox=mailbox;
    }

	/**
	 * get备注
	 */
    public String getRemarks(){
         return remarks;
    }

	/**
	 * set备注
	 */
    public void setRemarks(String remarks){
         this.remarks=remarks;
    }

	/**
	 * get总价格
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set总价格
	 */
    public void setPrice(String price){
         this.price=price;
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
	 * get创建人id
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set创建人id
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
    }

	/**
	 * get航程类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set航程类型
	 */
    public void setType(Long type){
         this.type=type;
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
	 * get最早时间
	 */
    public String getStime(){
         return stime;
    }

	/**
	 * set最早时间
	 */
    public void setStime(String stime){
         this.stime=stime;
    }

	/**
	 * get最晚时间
	 */
    public String getEtime(){
         return etime;
    }

	/**
	 * set最晚时间
	 */
    public void setEtime(String etime){
         this.etime=etime;
    }

	/**
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public Long getServicetype() {
		return servicetype;
	}

	public void setServicetype(Long servicetype) {
		this.servicetype = servicetype;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + num +"|"
	   
	 + maxnum +"|"
	   
	 + name +"|"
	   
	 + mobile +"|"
	   
	 + unitname +"|"
	   
	 + address +"|"
	   
	 + zipcode +"|"
	   
	 + tel +"|"
	   
	 + qq +"|"
	   
	 + fax +"|"
	   
	 + mailbox +"|"
	   
	 + remarks +"|"
	   
	 + price +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + type +"|"
	 
	 + servicetype +"|"
	 
	 + ordercode +"|"
	   
	 + usertype +"|"
	   
	 + stime +"|"
	   
	 + etime +"|"
	   
	 + state
	 + "]";
 } 

}
