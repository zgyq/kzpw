/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.insurcomputer;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *保险服务公司信息
 */
public class InsurcomputerBean implements java.io.Serializable{

	/**
	  *保险服务公司信息 表名
	  */
	public static final String TABLE  = "T_INSURCOMPUTER";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *服务公司编号 列名 
	  */
    public static final String COL_computerid  = "C_COMPUTERID";
	
	/**
	  *服务公司名称 列名 
	  */
    public static final String COL_computername  = "C_COMPUTERNAME";
	
	/**
	  *保险类型 列名 
	  */
    public static final String COL_insuranttype  = "C_INSURANTTYPE";
	
	/**
	  *保险编号 列名 
	  */
    public static final String COL_insurantno  = "C_INSURANTNO";
	
	/**
	  *保险说明内容 列名 
	  */
    public static final String COL_insurantcontent  = "C_INSURANTCONTENT";
	
	/**
	  *保险有效期 列名 
	  */
    public static final String COL_insurtime  = "C_INSURTIME";
	
	/**
	  *保险金额 列名 
	  */
    public static final String COL_insurmoney  = "C_INSURMONEY";
	
	/**
	  *市场价 列名 
	  */
    public static final String COL_scmoney  = "C_SCMONEY";
	
	/**
	  *服务公司状态 列名 
	  */
    public static final String COL_status  = "C_STATUS";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_createid  = "C_CREATEID";
	
	/**
	  *创建日期 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//服务公司编号
	private String computerid;    
    

	//服务公司名称
	private String computername;    
    

	//保险类型
	private Long insuranttype;    
    

	//保险编号
	private String insurantno;    
    

	//保险说明内容
	private String insurantcontent;    
    

	//保险有效期
	private Long insurtime;    
    

	//保险金额
	private String insurmoney;    
    

	//市场价
	private String scmoney;    
    

	//服务公司状态
	private Long status;    
    

	//创建人
	private String createid;    
    

	//创建日期
	private Timestamp createtime;    
    

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
	 * get服务公司编号
	 */
    public String getComputerid(){
         return computerid;
    }

	/**
	 * set服务公司编号
	 */
    public void setComputerid(String computerid){
         this.computerid=computerid;
    }

	/**
	 * get服务公司名称
	 */
    public String getComputername(){
         return computername;
    }

	/**
	 * set服务公司名称
	 */
    public void setComputername(String computername){
         this.computername=computername;
    }

	/**
	 * get保险类型
	 */
    public Long getInsuranttype(){
         return insuranttype;
    }

	/**
	 * set保险类型
	 */
    public void setInsuranttype(Long insuranttype){
         this.insuranttype=insuranttype;
    }

	/**
	 * get保险编号
	 */
    public String getInsurantno(){
         return insurantno;
    }

	/**
	 * set保险编号
	 */
    public void setInsurantno(String insurantno){
         this.insurantno=insurantno;
    }

	/**
	 * get保险说明内容
	 */
    public String getInsurantcontent(){
         return insurantcontent;
    }

	/**
	 * set保险说明内容
	 */
    public void setInsurantcontent(String insurantcontent){
         this.insurantcontent=insurantcontent;
    }

	/**
	 * get保险有效期
	 */
    public Long getInsurtime(){
         return insurtime;
    }

	/**
	 * set保险有效期
	 */
    public void setInsurtime(Long insurtime){
         this.insurtime=insurtime;
    }

	/**
	 * get保险金额
	 */
    public String getInsurmoney(){
         return insurmoney;
    }

	/**
	 * set保险金额
	 */
    public void setInsurmoney(String insurmoney){
         this.insurmoney=insurmoney;
    }

	/**
	 * get市场价
	 */
    public String getScmoney(){
         return scmoney;
    }

	/**
	 * set市场价
	 */
    public void setScmoney(String scmoney){
         this.scmoney=scmoney;
    }

	/**
	 * get服务公司状态
	 */
    public Long getStatus(){
         return status;
    }

	/**
	 * set服务公司状态
	 */
    public void setStatus(Long status){
         this.status=status;
    }

	/**
	 * get创建人
	 */
    public String getCreateid(){
         return createid;
    }

	/**
	 * set创建人
	 */
    public void setCreateid(String createid){
         this.createid=createid;
    }

	/**
	 * get创建日期
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set创建日期
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + computerid +"|"
	   
	 + computername +"|"
	   
	 + insuranttype +"|"
	   
	 + insurantno +"|"
	   
	 + insurantcontent +"|"
	   
	 + insurtime +"|"
	   
	 + insurmoney +"|"
	   
	 + scmoney +"|"
	   
	 + status +"|"
	   
	 + createid +"|"
	   
	 + createtime
	 + "]";
 } 

}
