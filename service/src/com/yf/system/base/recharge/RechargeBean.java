/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.recharge;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

/**
 *手机充值
 */
public class RechargeBean  implements java.io.Serializable {

	/**
	  *手机充值 表名
	  */
	public static final String TABLE  = "T_RECHARGE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_ordernumber  = "C_ORDERNUMBER";
	
	/**
	  *充值号码 列名 
	  */
    public static final String COL_phonenumber  = "C_PHONENUMBER";
	
	/**
	  *充值金额 列名 
	  */
    public static final String COL_rechmoney  = "C_RECHMONEY";
	
	/**
	  *充值时间 列名 
	  */
    public static final String COL_rechtime  = "C_RECHTIME";
	
	/**
	  *充值操作人 列名 
	  */
    public static final String COL_rechuid  = "C_RECHUID";
	
    /**
     *充值操作人 列名 
     */
    public static final String COL_rechuname  = "RECHUNAME";
    
	/**
	  *充值状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
    /**
     *充值类型
     */
    public static final String COL_phonetype  = "C_PHONETYPE";
    
    public static final String COL_cardnum="C_CARDNUM";
    
    
    public static final String COL_inprice="C_INPRICE";
    
    public static final String COL_refordernumber="C_REFORDERNUMBER";
    
    public static final String COL_rechagentid="C_RECHAGENTID";
    /**
	  *接受充值人 列名 
	  */
   public static final String COL_rechtouid  = "C_RECHTOUID";

	//ID
	private long id;    
    

	//订单号
	private String ordernumber;    
	
	
	//关联订单号：用于充值失败后多次充值
	private String refordernumber;
    
	
	//充值对应 0.2：10， 0.4： 20
	private String cardnum;

	//充值号码
	private String phonenumber;    
    

	//充值金额
	private Float rechmoney;   
	
	//产品分销价
	private Float inprice;   
	
	
    

	//充值时间
	private Timestamp rechtime;    
    

	//充值操作人 ID
	
	private long rechuid;  
	//充值人部门id
	private long rechagentid;
	
	//接受充值人 ID
	
	private long rechtouid;  
	
	
	
	//充值操作人 name
	private String rechuname;    
	//接受充值人 name
	private String rechtouname;    
    

	//充值状态 如果成功将为1，澈消(充值失败)为9，充值中为0,只能当状态为9时，商户才可以退款给用户。
	private int state;    
	
	//充值类型  移动 联通 为：1 电信为2
	private int phonetype;
	
	/**
	 * 0:等待支付，1，支付成功
	 */
	private int paystate=-1;
	
	
	
    

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
	 * get订单号
	 */
    public String getOrdernumber(){
         return ordernumber;
    }

	/**
	 * set订单号
	 */
    public void setOrdernumber(String ordernumber){
         this.ordernumber=ordernumber;
    }

	/**
	 * get充值号码
	 */
    public String getPhonenumber(){
         return phonenumber;
    }

	/**
	 * set充值号码
	 */
    public void setPhonenumber(String phonenumber){
         this.phonenumber=phonenumber;
    }

	/**
	 * get充值金额
	 */
    public Float getRechmoney(){
         return rechmoney;
    }

	/**
	 * set充值金额
	 */
    public void setRechmoney(Float rechmoney){
         this.rechmoney=rechmoney;
    }

	/**
	 * get充值时间
	 */
    public Timestamp getRechtime(){
         return rechtime;
    }

	/**
	 * set充值时间
	 */
    public void setRechtime(Timestamp rechtime){
         this.rechtime=rechtime;
    }

	/**
	 * get充值操作人
	 */
    public long getRechuid(){
         return rechuid;
    }

	/**
	 * set充值操作人
	 */
    public void setRechuid(long rechuid){
         this.rechuid=rechuid;
    }

	/**
	 * get充值状态
	 * 0-10：为殴飞返回状态：0:充值中，1：充值成功。9 充值失败
	 * 11--99 为自定义状态  11：等待支付
	 */
    public int getState(){
         return state;
    }
    
    public String getStatestr(){
    	
    	return this.getMobileStateMap().get(this.getState());
    }
    public static Map<Integer,String> getMobileStateMap(){
    	Map<Integer,String> map=new TreeMap<Integer,String>();
    	map.put(0, "充值中");
    	map.put(1, "充值成功");
    	map.put(9, "充值失败");
    	map.put(11, "等待支付");
    	return map;
    	
    }
    
  

    
	/**
	 * set充值状态
	 */
    public void setState(int state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + ordernumber +"|"
	   
	 + phonenumber +"|"
	   
	 + rechmoney +"|"
	   
	 + rechtime +"|"
	   
	 + rechuid +"|"
	   
	 + state
	 + "]";
 }

	public int getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(int phonetype) {
		this.phonetype = phonetype;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public Float getInprice() {
		return inprice;
	}

	public void setInprice(Float inprice) {
		this.inprice = inprice;
	}

	public String getRechuname() {
		if(rechuname.equals("")){
			rechuname="网站散客";
		}
		return rechuname;
	}

	public void setRechuname(String rechuname) {
		this.rechuname = rechuname;
	}

	public String getRefordernumber() {
		return refordernumber;
	}

	public void setRefordernumber(String refordernumber) {
		this.refordernumber = refordernumber;
	}

	public long getRechagentid() {
		return rechagentid;
	}

	public void setRechagentid(long rechagentid) {
		this.rechagentid = rechagentid;
	}

	public long getRechtouid() {
		return rechtouid;
	}

	public void setRechtouid(long rechtouid) {
		this.rechtouid = rechtouid;
	}

	public String getRechtouname() {
		return rechtouname;
	}

	public void setRechtouname(String rechtouname) {
		this.rechtouname = rechtouname;
	}
	
	
	  public int paymethod;
		
		public static final String COL_paymethod="C_PAYMETHOD";
		
		public static String getPayMethodByType(int method){
			switch (method){
			case 1:return"网上支付";
			case 2:return"虚拟账户支付";
			}
			return "";
		}
		
		public String getPaymethodtype(){
			return getPayMethodByType(this.paymethod);
		}

	public int getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(int paymethod) {
		this.paymethod = paymethod;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	} 
	

}
