/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.changpass;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *变更记录
 */
public class ChangpassBean implements java.io.Serializable{

	/**
	  *变更记录 表名
	  */
	public static final String TABLE  = "T_CHANGPASS";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *订单id 列名 
	  */
    public static final String COL_orderid  = "C_ORDERID";
	
	/**
	  *申请人ID 列名 
	  */
    public static final String COL_userid  = "C_USERID";
	
	/**
	  *乘机人id 列名 
	  */
    public static final String COL_passids  = "C_PASSIDS";
	
	/**
	  *加盟商 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_descinfo  = "C_DESCINFO";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *登录时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *申请类型 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *申请返回订单号 列名 
	  */
    public static final String COL_ordernum  = "C_ORDERNUM";
	
	/**
	  *申请返回支付url 列名 
	  */
    public static final String COL_payurl  = "C_PAYURL";
	
	/**
	  *申请返回类型 列名 
	  */
    public static final String COL_rettype  = "C_RETTYPE";
	
	/**
	  *变更姓名 列名 
	  */
    public static final String COL_name  = "C_NEME";
	
	/**
	  *变更证件号码 列名 
	  */
    public static final String COL_idnum  = "C_IDNUM";
	
	/**
	  *变更证件类型 列名 
	  */
    public static final String COL_idtype  = "C_IDTYPE";

	//ID
	private long id;    
    

	//订单id
	private Long orderid;    
    

	//申请人ID
	private Long userid;    
    

	//乘机人id
	private String passids;    
    

	//加盟商
	private Long agentid;    
    

	//备注
	private String descinfo;    
    

	//创建者
	private String createuser;    
    

	//登录时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//状态
	private Long status;    
    

	//申请类型
	private Long type;    
    

	//申请返回订单号
	private String ordernum;    
    

	//申请返回支付url
	private String payurl;    
    

	//申请返回类型
	private String rettype;    
    

	//变更姓名
	private String name;    
    

	//变更证件号码
	private String idnum;    
    

	//变更证件类型
	private String idtype;    
    

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
	 * get订单id
	 */
    public Long getOrderid(){
         return orderid;
    }

	/**
	 * set订单id
	 */
    public void setOrderid(Long orderid){
         this.orderid=orderid;
    }

	/**
	 * get申请人ID
	 */
    public Long getUserid(){
         return userid;
    }

	/**
	 * set申请人ID
	 */
    public void setUserid(Long userid){
         this.userid=userid;
    }

	/**
	 * get乘机人id
	 */
    public String getPassids(){
         return passids;
    }

	/**
	 * set乘机人id
	 */
    public void setPassids(String passids){
         this.passids=passids;
    }

	/**
	 * get加盟商
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set加盟商
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
    }

	/**
	 * get备注
	 */
    public String getDescinfo(){
         return descinfo;
    }

	/**
	 * set备注
	 */
    public void setDescinfo(String descinfo){
         this.descinfo=descinfo;
    }

	/**
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
	 */
    public void setCreateuser(String createuser){
         this.createuser=createuser;
    }

	/**
	 * get登录时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set登录时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
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
	 * get状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set状态
	 */
    public void setStatus(Long status){
         this.status=status;
    }

	/**
	 * get申请类型
	 */
    public Long getType(){
         return type;
    }

	/**
	 * set申请类型
	 */
    public void setType(Long type){
         this.type=type;
    }

	/**
	 * get申请返回订单号
	 */
    public String getOrdernum(){
         return ordernum;
    }

	/**
	 * set申请返回订单号
	 */
    public void setOrdernum(String ordernum){
         this.ordernum=ordernum;
    }

	/**
	 * get申请返回支付url
	 */
    public String getPayurl(){
         return payurl;
    }

	/**
	 * set申请返回支付url
	 */
    public void setPayurl(String payurl){
         this.payurl=payurl;
    }

	/**
	 * get申请返回类型
	 */
    public String getRettype(){
         return rettype;
    }

	/**
	 * set申请返回类型
	 */
    public void setRettype(String rettype){
         this.rettype=rettype;
    }

	/**
	 * get变更姓名
	 */
    public String getName(){
         return name;
    }

	/**
	 * set变更姓名
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get变更证件号码
	 */
    public String getIdnum(){
         return idnum;
    }

	/**
	 * set变更证件号码
	 */
    public void setIdnum(String idnum){
         this.idnum=idnum;
    }

	/**
	 * get变更证件类型
	 */
    public String getIdtype(){
         return idtype;
    }

	/**
	 * set变更证件类型
	 */
    public void setIdtype(String idtype){
         this.idtype=idtype;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + orderid +"|"
	   
	 + userid +"|"
	   
	 + passids +"|"
	   
	 + agentid +"|"
	   
	 + descinfo +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + status +"|"
	   
	 + type +"|"
	   
	 + ordernum +"|"
	   
	 + payurl +"|"
	   
	 + rettype +"|"
	   
	 + name +"|"
	   
	 + idnum +"|"
	   
	 + idtype
	 + "]";
 } 

}
