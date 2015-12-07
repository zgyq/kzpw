/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.dcampaign;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *电子优惠卷活动
 */
public class DcampaignBean implements java.io.Serializable{

	/**
	  *电子优惠卷活动 表名
	  */
	public static final String TABLE  = "T_DCAMPAIGN";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *活动名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *活动代码 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *活动详情 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *活动小图片 列名 
	  */
    public static final String COL_picsrc  = "C_PICSRC";
	
	/**
	  *活动大图片 列名 
	  */
    public static final String COL_bpicsrc  = "C_BPICSRC";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_online  = "C_ONLINE";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *开始时间 列名 
	  */
    public static final String COL_sttime  = "C_STTIME";
	
	/**
	  *结束时间 列名 
	  */
    public static final String COL_endtime  = "C_ENDTIME";
	
	/**
	  *每人限制领取数量 列名 
	  */
    public static final String COL_sum  = "C_SUM";
    
    /**
	  *连锁酒店ID 列名 
	  */
  public static final String COL_chaininfoid  = "C_CHAININFOID";

	//ID
	private long id;    
    

	//活动名称
	private String name;    
    

	//活动代码
	private String code;    
    

	//活动详情
	private String description;    
    

	//活动小图片
	private String picsrc;    
    

	//活动大图片
	private String bpicsrc;    
    

	//排序
	private Long online;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//开始时间
	private Timestamp sttime;    
    

	//结束时间
	private Timestamp endtime;    
    

	//每人限制领取数量
	private Long sum;    
    
	//连锁酒店ID
	private Long chaininfoid; 

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
	 * get活动名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set活动名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get活动代码
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set活动代码
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get活动详情
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set活动详情
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get活动小图片
	 */
    public String getPicsrc(){
         return picsrc;
    }

	/**
	 * set活动小图片
	 */
    public void setPicsrc(String picsrc){
         this.picsrc=picsrc;
    }

	/**
	 * get活动大图片
	 */
    public String getBpicsrc(){
         return bpicsrc;
    }

	/**
	 * set活动大图片
	 */
    public void setBpicsrc(String bpicsrc){
         this.bpicsrc=bpicsrc;
    }

	/**
	 * get排序
	 */
    public Long getOnline(){
         return online;
    }

	/**
	 * set排序
	 */
    public void setOnline(Long online){
         this.online=online;
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
	 * get开始时间
	 */
    public Timestamp getSttime(){
         return sttime;
    }

	/**
	 * set开始时间
	 */
    public void setSttime(Timestamp sttime){
         this.sttime=sttime;
    }

	/**
	 * get结束时间
	 */
    public Timestamp getEndtime(){
         return endtime;
    }

	/**
	 * set结束时间
	 */
    public void setEndtime(Timestamp endtime){
         this.endtime=endtime;
    }

	/**
	 * get每人限制领取数量
	 */
    public Long getSum(){
         return sum;
    }

	/**
	 * set每人限制领取数量
	 */
    public void setSum(Long sum){
         this.sum=sum;
    }


	public Long getChaininfoid() {
		return chaininfoid;
	}

	public void setChaininfoid(Long chaininfoid) {
		this.chaininfoid = chaininfoid;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + code +"|"
	   
	 + description +"|"
	   
	 + picsrc +"|"
	   
	 + bpicsrc +"|"
	   
	 + online +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + sttime +"|"
	 
	 + chaininfoid +"|"
	   
	 + endtime +"|"
	   
	 + sum
	 + "]";
 } 

}
