/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.triporder;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *线路订单
 */
public class TriporderBean implements java.io.Serializable{

	/**
	  *线路订单 表名
	  */
	public static final String TABLE  = "T_TRIPORDER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
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
	  *线路ID 列名 
	  */
    public static final String COL_triplineid  = "C_TRIPLINEID";
	
	/**
	  *人数 列名 
	  */
    public static final String COL_pnum  = "C_PNUM";
	
	/**
	  *总价 列名 
	  */
    public static final String COL_sump  = "C_SUMP";
	
	/**
	  *订单号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
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
	  *联系人邮箱 列名 
	  */
    public static final String COL_linkmail  = "C_LINKMAIL";
	
	/**
	  *联系人电话 列名 
	  */
    public static final String COL_linktell  = "C_LINKTELL";
	
	/**
	  *特殊要求 列名 
	  */
    public static final String COL_specreq  = "C_SPECREQ";
	
	/**
	  *出发日期 列名 
	  */
    public static final String COL_statetime  = "C_STATETIME";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
	
	/**
	  *会员ID 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *锁定人ID 列名 
	  */
    public static final String COL_lockuser  = "C_LOCKUSER";
	
	/**
	  *锁定状态 列名 
	  */
    public static final String COL_lockstate  = "C_LOCKSTATE";
	
	/**
	  *锁定时间 列名 
	  */
    public static final String COL_locktime  = "C_LOCKTIME";
    
    /**
     * 购买代理商id
     */
    public static final String COL_buyagentid="C_BUYAGENTID";

	//ID
	private long id;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//线路ID
	private Long triplineid;    
    

	//人数
	private Integer pnum;    
    

	//总价
	private Float sump;    
    

	//订单号
	private String code;    
    

	//订单状态
	private Integer state;    
    

	//联系人姓名
	private String linkname;    
    

	//联系人手机
	private String linkmobile;    
    

	//联系人邮箱
	private String linkmail;    
    

	//联系人电话
	private String linktell;    
    

	//特殊要求
	private String specreq;    
    

	//出发日期
	private Timestamp statetime;    
    

	//父编号
	private Long ucode;    
	

	//语言类型
	private Integer language;    
	//Language.原用于语言类型.现用于判断订单类型,1为B2B订单  2为B2C订单;

	//会员ID
	private Long memberid;    
    

	//锁定人ID
	private Long lockuser;    
    

	//锁定状态
	private Long lockstate;    
    

	//锁定时间
	private Timestamp locktime;    
    
	//返点金额
	private Float fanprice;  
	
	//购买代理商id
	private Long buyagentid;

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
	 * get线路ID
	 */
    public Long getTriplineid(){
         return triplineid;
    }

	/**
	 * set线路ID
	 */
    public void setTriplineid(Long triplineid){
         this.triplineid=triplineid;
    }

	/**
	 * get人数
	 */
    public Integer getPnum(){
         return pnum;
    }

	/**
	 * set人数
	 */
    public void setPnum(Integer pnum){
         this.pnum=pnum;
    }

	/**
	 * get总价
	 */
    public Float getSump(){
         return sump;
    }

	/**
	 * set总价
	 */
    public void setSump(Float sump){
         this.sump=sump;
    }

	/**
	 * get订单号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set订单号
	 */
    public void setCode(String code){
         this.code=code;
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
	 * get联系人邮箱
	 */
    public String getLinkmail(){
         return linkmail;
    }

	/**
	 * set联系人邮箱
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
	 * get出发日期
	 */
    public Timestamp getStatetime(){
         return statetime;
    }

	/**
	 * set出发日期
	 */
    public void setStatetime(Timestamp statetime){
         this.statetime=statetime;
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
	 * get锁定人ID
	 */
    public Long getLockuser(){
         return lockuser;
    }

	/**
	 * set锁定人ID
	 */
    public void setLockuser(Long lockuser){
         this.lockuser=lockuser;
    }

	/**
	 * get锁定状态
	 */
    public Long getLockstate(){
         return lockstate;
    }

	/**
	 * set锁定状态
	 */
    public void setLockstate(Long lockstate){
         this.lockstate=lockstate;
    }

	/**
	 * get锁定时间
	 */
    public Timestamp getLocktime(){
         return locktime;
    }

	/**
	 * set锁定时间
	 */
    public void setLocktime(Timestamp locktime){
         this.locktime=locktime;
    }


	public Float getFanprice() {
		return fanprice;
	}

	public void setFanprice(Float fanprice) {
		this.fanprice = fanprice;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime +"|"
	   
	 + triplineid +"|"
	   
	 + pnum +"|"
	   
	 + sump +"|"
	   
	 + code +"|"
	   
	 + state +"|"
	   
	 + linkname +"|"
	   
	 + linkmobile +"|"
	   
	 + linkmail +"|"
	   
	 + linktell +"|"
	   
	 + specreq +"|"
	   
	 + statetime +"|"
	   
	 + ucode +"|"
	   
	 + language +"|"
	   
	 + memberid +"|"
	   
	 + lockuser +"|"
	   
	 + lockstate +"|"
	 
	 + fanprice +"|"
	 
	 + buyagentid+"|"
	   
	 + locktime
	 + "]";
 }

	public Long getBuyagentid() {
		return buyagentid;
	}

	public void setBuyagentid(Long buyagentid) {
		this.buyagentid = buyagentid;
	} 

}
