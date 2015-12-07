/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.insuranceinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *保险
 */
public class InsuranceinfoBean implements java.io.Serializable{

	/**
	  *保险 表名
	  */
	public static final String TABLE  = "T_INSURANCEINFO";

	
	/**
	  *id 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *公司名称 列名 
	  */
    public static final String COL_companyname  = "C_COMPANYNAME";
	
	/**
	  *保险产品名称 列名 
	  */
    public static final String COL_insurancename  = "C_INSURANCENAME";
	
	/**
	  *生效日期 列名 
	  */
    public static final String COL_validdate  = "C_VALIDDATE";
	
	/**
	  *保险金额 列名 此字段另作他用，如需使用或修改 请联系 韩蒙辉（用于暂存乘机人Id）
	  */
    public static final String COL_insurancemoney  = "C_INSURANCEMONEY";
	
	/**
	  *保险费 列名 
	  */
    public static final String COL_insurancefee  = "C_INSURANCEFEE";
	
	/**
	  *保险单号 列名 
	  */
    public static final String COL_ordernumber  = "C_ORDERNUMBER";
	
	/**
	  *备注说明 列名 
	  */
    public static final String COL_description  = "C_DESC";
	
	/**
	  *创建人 列名 
	  */
    public static final String COL_employeeid  = "C_EMPLOYEEID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
    
    /**
     * 单证号
     */
    public static final String COL_danzhenghao="C_DANZHENGHAO";
    
    /**
     * 终止日期
     */
    public static final String COL_zhongzhidate="C_ZHONGZHIDATE";
    
    /**
     * 投保人
     */
    public static final String COL_toubaoren="C_TOUBAOREN";
    
    /**
     * 被保人
     */
    public static final String COL_beibaoren="C_BEIBAOREN";
    
    
    /**
     * 保险份数
     */
    public static final String COL_insurancenum="C_INSURANCENUM";
    
    
    /**
     * 保险录入状态 1：未录入；2：已录入
     */
    public static final String COL_insurancestate="C_INSURANCESTATE";
    
    
    public static final String COL_effectdate="C_EFFECTDATE";
    
    
    public static final String COL_enddate="C_ENDDATE";
    
    public static final String COL_wortime="C_WORKTIME";
    
    
    public Integer insurancenum;
    
    
    public Integer insurancestate;
    
	//id
	private long id;    
    

	//公司名称
	private String companyname;    
    

	//保险名称
	private String insurancename;    
    

//	//生效日期
//	private Timestamp validdate;    
//   
	
	private Timestamp  effectdate;
	
	
	
	private Timestamp  enddate;
	

	//保险金额   此字段另作他用，如需使用或修改 请联系 韩蒙辉（用于暂存乘机人Id）
	private String insurancemoney;    
    

	//保险费
	private String insurancefee;    
    

	//保单号
	private String ordernumber;    
    

	//备注说明
	private String description;    
    

	//创建人
	private long employeeid;    
    

	//创建时间
	private Timestamp createtime;  
	
	//单证号
	private String danzhenghao;
	
//	//终止日期
//	private Timestamp zhongzhidate;
	
	//投保人
	private String toubaoren;
	
	//被保人
	private String beibaoren;
	
	private Timestamp worktime;

	
	
    

	/**
	 * getid
	 */
    public long getId(){
         return id;
    }

	/**
	 * setid
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get公司名称
	 */
    public String getCompanyname(){
         return companyname;
    }

	/**
	 * set公司名称
	 */
    public void setCompanyname(String companyname){
         this.companyname=companyname;
    }

	/**
	 * get保险名称
	 */
    public String getInsurancename(){
         return insurancename;
    }

	/**
	 * set保险名称
	 */
    public void setInsurancename(String insurancename){
         this.insurancename=insurancename;
    }
    
    
    
	/**
	 * get保险金额
	 */
    public String getInsurancemoney(){
         return insurancemoney;
    }

	/**
	 * set保险金额
	 */
    public void setInsurancemoney(String insurancemoney){
         this.insurancemoney=insurancemoney;
    }

	/**
	 * get保险费
	 */
    public String getInsurancefee(){
         return insurancefee;
    }

	/**
	 * set保险费
	 */
    public void setInsurancefee(String insurancefee){
         this.insurancefee=insurancefee;
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
	 * get备注说明
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set备注说明
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get创建人
	 */
    public long getEmployeeid(){
         return employeeid;
    }

	/**
	 * set创建人
	 */
    public void setEmployeeid(long employeeid){
         this.employeeid=employeeid;
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
	   
	 + companyname +"|"
	   
	 + insurancename +"|"
	   
	
	   
	 + insurancemoney +"|"
	   
	 + insurancefee +"|"
	   
	 + ordernumber +"|"
	   
	 + description +"|"
	   
	 + employeeid +"|"
	 
	 + danzhenghao +"|"
	 
	 + toubaoren +"|"
	 
	 + beibaoren +"|"
	   
	 + createtime
	 + "]";
 }

	public String getDanzhenghao() {
		return danzhenghao;
	}

	public void setDanzhenghao(String danzhenghao) {
		this.danzhenghao = danzhenghao;
	}

//	public Timestamp getZhongzhidate() {
//		return zhongzhidate;
//	}
//
//	public void setZhongzhidate(Timestamp zhongzhidate) {
//		this.zhongzhidate = zhongzhidate;
//	}

	public String getToubaoren() {
		return toubaoren;
	}

	public void setToubaoren(String toubaoren) {
		this.toubaoren = toubaoren;
	}

	public String getBeibaoren() {
		return beibaoren;
	}

	public void setBeibaoren(String beibaoren) {
		this.beibaoren = beibaoren;
	}

	public Integer getInsurancenum() {
		return insurancenum;
	}

	public void setInsurancenum(Integer insurancenum) {
		this.insurancenum = insurancenum;
	}

	public Integer getInsurancestate() {
		return insurancestate;
	}

	public void setInsurancestate(Integer insurancestate) {
		this.insurancestate = insurancestate;
	}

	

	
	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Timestamp getWorktime() {
		return worktime;
	}

	public void setWorktime(Timestamp worktime) {
		this.worktime = worktime;
	}

	

	

}
