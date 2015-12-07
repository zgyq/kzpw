/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.trainpassenger;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *火车票乘客
 */
public class TrainpassengerBean implements java.io.Serializable{

	/**
	  *火车票乘客 表名
	  */
	public static final String TABLE  = "T_TRAINPASSENGER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单ID 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *名字 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *证件类型 列名 
	  */
    public static final String COL_idtype  = "C_IDTYPE";
	
	/**
	  *证件号码 列名 
	  */
    public static final String COL_idnumber  = "C_IDNUMBER";
    /**
	  *预订席别 列名 
	  */
  public static final String COL_yudingtype  = "C_YUDINGTYPE";
    
    /**
	  *出票席别 列名 
	  */
   public static final String COL_chupiaotype  = "C_CHUPIAOTYPE";
   
   /**
	  *出票价 列名 
	  */
 public static final String COL_chupiaoprice  = "C_CHUPIAOPRICE";
   
    
    /**
	  *保险 列名 
	  */
   public static final String COL_bxprice  = "C_BXPRICE";
   
   /**
	  *单价 列名 
	  */
   public static final String COL_price  = "C_PRICE";
   
   /**
	  *状态 列名 
	  */
 public static final String COL_state  = "C_STATE";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//订单ID
	private long orderid;    
    

	//名字
	private String name;    
    

	//证件类型
	private int idtype;    
    
	
	//保险
	private int bxprice;   
	
	//单价
	private Float price; 
	
	//状态
	private int state; 

	//证件号码
	private String idnumber;    
    
	//预订席别
	private String yudingtype; 
	
	//出票席别
	private String chupiaotype;  
	
	//出票价
	private String chupiaoprice; 

	//创建时间
	private Timestamp createtime;    
	
	private String idtypeval;
    

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
	 * get订单ID
	 */
    public long getOrderid(){
         return orderid;
    }

	/**
	 * set订单ID
	 */
    public void setOrderid(long orderid){
         this.orderid=orderid;
    }

	/**
	 * get名字
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名字
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get证件类型
	 */
    public int getIdtype(){
         return idtype;
    }

	/**
	 * set证件类型
	 */
    public void setIdtype(int idtype){
         this.idtype=idtype;
    }

	/**
	 * get证件号码
	 */
    public String getIdnumber(){
         return idnumber;
    }

	/**
	 * set证件号码
	 */
    public void setIdnumber(String idnumber){
         this.idnumber=idnumber;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + name +"|"
	   
	 + idtype +"|"
	   
	 + idnumber +"|"
	 
	 + bxprice +"|"
	 
	 + chupiaoprice +"|"
	 
	 + chupiaotype +"|"
	 
	 + yudingtype +"|"
	 
	 + price +"|"
	 
	 + state +"|"
	   
	 + createtime
	 + "]";
 }

	public String getIdtypeval() {
		return idtypeval;
	}

	public void setIdtypeval(String idtypeval) {
		this.idtypeval = idtypeval;
	}

	public int getBxprice() {
		return bxprice;
	}

	public void setBxprice(int bxprice) {
		this.bxprice = bxprice;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getYudingtype() {
		return yudingtype;
	}

	public void setYudingtype(String yudingtype) {
		this.yudingtype = yudingtype;
	}

	public String getChupiaotype() {
		return chupiaotype;
	}

	public void setChupiaotype(String chupiaotype) {
		this.chupiaotype = chupiaotype;
	}

	public String getChupiaoprice() {
		return chupiaoprice;
	}

	public void setChupiaoprice(String chupiaoprice) {
		this.chupiaoprice = chupiaoprice;
	} 

}
