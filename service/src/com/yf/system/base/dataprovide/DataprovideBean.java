/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.dataprovide;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店数据提供商
 */
public class DataprovideBean implements java.io.Serializable{

	/**
	  *酒店数据提供商 表名
	  */
	public static final String TABLE  = "T_DATAPROVIDE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *编码 列名 
	  */
    public static final String COL_dataprovidecode  = "C_DATAPROVIDECODE";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_dataprovidename  = "C_DATAPROVIDENAME";
	
	/**
	  *英文名 列名 
	  */
    public static final String COL_dataproviceename  = "C_DATAPROVICEENAME";
	
	/**
	  *中文拼音 列名 
	  */
    public static final String COL_dataprovicecname  = "C_DATAPROVICECNAME";
	
	/**
	  *联系人姓名 列名 
	  */
    public static final String COL_linkmanname  = "C_LINKMANNAME";
	
	/**
	  *联系电话 列名 
	  */
    public static final String COL_linkmanphone  = "C_LINKMANPHONE";
	
	/**
	  *用户名 列名 
	  */
    public static final String COL_username  = "C_USERNAME";
	
	/**
	  *密码 列名 
	  */
    public static final String COL_password  = "C_PASSWORD";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_createmanid  = "C_CREATEMANID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_remark  = "C_REMARK";
	
	/**
	  *备用字段1 列名 
	  */
    public static final String COL_param1  = "C_PARAM1";
	
	/**
	  *备用字段2 列名 
	  */
    public static final String COL_param2  = "C_PARAM2";
	
	/**
	  *备用字段3 列名 
	  */
    public static final String COL_param3  = "C_PARAM3";

	//ID
	private long id;    
    

	//编码
	private String dataprovidecode;    
    

	//名称
	private String dataprovidename;    
    

	//英文名
	private String dataproviceename;    
    

	//中文拼音
	private String dataprovicecname;    
    

	//联系人姓名
	private String linkmanname;    
    

	//联系电话
	private String linkmanphone;    
    

	//用户名
	private String username;    
    

	//密码
	private String password;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
	private Long createmanid;    
    

	//状态
	private Long state;    
    

	//备注
	private String remark;    
    

	//备用字段1
	private String param1;    
    

	//备用字段2
	private String param2;    
    

	//备用字段3
	private String param3;    
    

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
	 * get编码
	 */
    public String getDataprovidecode(){
         return dataprovidecode;
    }

	/**
	 * set编码
	 */
    public void setDataprovidecode(String dataprovidecode){
         this.dataprovidecode=dataprovidecode;
    }

	/**
	 * get名称
	 */
    public String getDataprovidename(){
         return dataprovidename;
    }

	/**
	 * set名称
	 */
    public void setDataprovidename(String dataprovidename){
         this.dataprovidename=dataprovidename;
    }

	/**
	 * get英文名
	 */
    public String getDataproviceename(){
         return dataproviceename;
    }

	/**
	 * set英文名
	 */
    public void setDataproviceename(String dataproviceename){
         this.dataproviceename=dataproviceename;
    }

	/**
	 * get中文拼音
	 */
    public String getDataprovicecname(){
         return dataprovicecname;
    }

	/**
	 * set中文拼音
	 */
    public void setDataprovicecname(String dataprovicecname){
         this.dataprovicecname=dataprovicecname;
    }

	/**
	 * get联系人姓名
	 */
    public String getLinkmanname(){
         return linkmanname;
    }

	/**
	 * set联系人姓名
	 */
    public void setLinkmanname(String linkmanname){
         this.linkmanname=linkmanname;
    }

	/**
	 * get联系电话
	 */
    public String getLinkmanphone(){
         return linkmanphone;
    }

	/**
	 * set联系电话
	 */
    public void setLinkmanphone(String linkmanphone){
         this.linkmanphone=linkmanphone;
    }

	/**
	 * get用户名
	 */
    public String getUsername(){
         return username;
    }

	/**
	 * set用户名
	 */
    public void setUsername(String username){
         this.username=username;
    }

	/**
	 * get密码
	 */
    public String getPassword(){
         return password;
    }

	/**
	 * set密码
	 */
    public void setPassword(String password){
         this.password=password;
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
    public Long getCreatemanid(){
         return createmanid;
    }

	/**
	 * set创建人id
	 */
    public void setCreatemanid(Long createmanid){
         this.createmanid=createmanid;
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

	/**
	 * get备注
	 */
    public String getRemark(){
         return remark;
    }

	/**
	 * set备注
	 */
    public void setRemark(String remark){
         this.remark=remark;
    }

	/**
	 * get备用字段1
	 */
    public String getParam1(){
         return param1;
    }

	/**
	 * set备用字段1
	 */
    public void setParam1(String param1){
         this.param1=param1;
    }

	/**
	 * get备用字段2
	 */
    public String getParam2(){
         return param2;
    }

	/**
	 * set备用字段2
	 */
    public void setParam2(String param2){
         this.param2=param2;
    }

	/**
	 * get备用字段3
	 */
    public String getParam3(){
         return param3;
    }

	/**
	 * set备用字段3
	 */
    public void setParam3(String param3){
         this.param3=param3;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + dataprovidecode +"|"
	   
	 + dataprovidename +"|"
	   
	 + dataproviceename +"|"
	   
	 + dataprovicecname +"|"
	   
	 + linkmanname +"|"
	   
	 + linkmanphone +"|"
	   
	 + username +"|"
	   
	 + password +"|"
	   
	 + createtime +"|"
	   
	 + createmanid +"|"
	   
	 + state +"|"
	   
	 + remark +"|"
	   
	 + param1 +"|"
	   
	 + param2 +"|"
	   
	 + param3
	 + "]";
 } 

}
