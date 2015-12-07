/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customeragent;

import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 * 加盟商信息表
 */
public class CustomeragentBean implements java.io.Serializable {

	/**
	 * 加盟商信息表 表名
	 */
	public static final String TABLE = "T_CUSTOMERAGENT";

	/**
	 * 加盟商ID 列名
	 */
	public static final String COL_id = "ID";

	/**
	 * 代码 列名
	 */
	public static final String COL_code = "C_CODE";

	/**
	 * 加盟商类型(1=运营商,2=供应商,3=分销商) 列名
	 */
	public static final String COL_agenttype = "C_AGENTTYPE";

	/**
	 * 有效期开始时间 列名
	 */
	public static final String COL_agentvsdate = "C_AGENTVSDATE";

	/**
	 * 有效期结束时间 列名
	 */
	public static final String COL_agentvedate = "C_AGENTVEDATE";

	/**
	 * 单位名称 列名
	 */
	public static final String COL_agentcompanyname = "C_AGENTCOMPANYNAME";

	/**
	 * 单位??称 列名
	 */
	public static final String COL_agentshortname = "C_AGENTSHORTNAME";

	/**
	 * 客户类型 列名
	 */
	public static final String COL_agentcityid = "C_AGENTCITYID";

	/**
	 * 单位电话 列名
	 */
	public static final String COL_agenttel = "C_AGENTTEL";

	/**
	 * 通信地址 列名
	 */
	public static final String COL_agentaddress = "C_AGENTADDRESS";

	/**
	 * 邮政编码 列名
	 */
	public static final String COL_agentpostcode = "C_AGENTPOSTCODE";

	/**
	 * 联系人姓名 列名
	 */
	public static final String COL_agentcontactname = "C_AGENTCONTACTNAME";

	/**
	 * 联系人邮箱 列名
	 */
	public static final String COL_agentemail = "C_AGENTEMAIL";

	/**
	 * 审核状态 列名
	 */
	public static final String COL_agentcheckstatus = "C_AGENTCHECKSTATUS";

	/**
	 * 是否启用 列名
	 */
	public static final String COL_agentisenable = "C_AGENTISENABLE";

	/**
	 * 修改时间 列名
	 */
	public static final String COL_modifytime = "C_MODIFYTIME";

	/**
	 * 修改者 列名
	 */
	public static final String COL_modifyuser = "C_MODIFYUSER";

	/**
	 * 创建时间 列名
	 */
	public static final String COL_createtime = "C_CREATETIME";

	/**
	 * 创建者 列名
	 */
	public static final String COL_createuser = "C_CREATEUSER";

	/**
	 * 父ID 列名
	 */
	public static final String COL_parentid = "C_PARENTID";

	/**
	 * 父ID串 列名
	 */
	public static final String COL_parentstr = "C_PARENTSTR";

	/**
	 * 本公司留点 列名
	 */
	public static final String COL_brokenum = "C_BROKENUM";

	/**
	 * 子公司留点 列名
	 */
	public static final String COL_childbrokenum = "C_CHILDBROKENUM";

	/**
	 * 支付宝账号 列名
	 */
	public static final String COL_alipayaccount = "C_ALIPAYACCOUNT";

	/**
	 * 财付通账号 列名
	 */
	public static final String COL_tenpayaccount = "C_TENPAYACCOUNT";

	/**
	 * 快钱账号 列名
	 */
	public static final String COL_kuaibillaccount = "C_KUAIBILLACCOUNT";

	/**
	 * MSN或QQ 列名
	 */
	public static final String COL_msnqq = "C_MSNQQ";

	/**
	 * 公司网址 列名
	 */
	public static final String COL_website = "C_WEBSITE";

	/**
	 * 是否大客户 列名
	 */
	public static final String COL_bigtype = "C_BIGTYPE";

	/**
	 * 是客户经理ID 列名
	 */
	public static final String COL_userid = "C_USERID";

	/**
	 * 东航编码 列名
	 */
	public static final String COL_mucode = "C_MUCODE";

	/**
	 * 南航编码 列名
	 */
	public static final String COL_czcode = "C_CZCODE";

	/**
	 * 是国航编码 列名
	 */
	public static final String COL_cacode = "C_CACODE";

	/**
	 * 分润类型 列名
	 */
	public static final String COL_runtype = "C_RUNTYPE";

	/**
	 * 分润值 列名
	 */
	public static final String COL_runvalue = "C_RUNVALUE";

	/**
	 * 联系人工作电话 列名
	 */
	public static final String COL_agentphone = "C_AGENTPHONE";
	
	/**
	 * 查询流量限制 列名
	 */
	public static final String COL_searchtoall = "C_SEARCHTOALL";
	
	/**
	 * 已查询次数 列名
	 */
	public static final String COL_searchnum = "C_SEARCHNUM";
	
	/**
	 * 系统账号备注 列名
	 */
	public static final String COL_beizhu = "C_BEIZHU";
	

	/**
	 * 联系人传真 列名
	 */
	public static final String COL_agenrfax = "C_AGENRFAX";

	/**
	 * 联系人移动 列名
	 */
	public static final String COL_agentmobile = "C_AGENTMOBILE";

	/**
	 * 其他联系方式 列名
	 */
	public static final String COL_agentother = "C_AGENTOTHER";

	/**
	 * 所属行业 列名(先用于保存限制员工数)
	 */
	public static final String COL_industry = "C_INDUSTRY";

	/**
	 * 财务联系人 列名
	 */
	public static final String COL_financename = "C_FINANCENAME";

	/**
	 * 财务工作电话 列名
	 */
	public static final String COL_financephone = "C_FINANCEPHONE";

	/**
	 * 财务传真号码 列名
	 */
	public static final String COL_financefax = "C_FINANCEFAX";

	/**
	 * 财务移动电话 列名
	 */
	public static final String COL_financemobile = "C_FINANCEMOBILE";

	/**
	 * 财务电邮 列名
	 */
	public static final String COL_financeemail = "C_FINANCEEMAIL";

	/**
	 * 是否允许登录
	 * 
	 */
	public static final String C_isallowlogin = "C_ISALLOWLOGIN";

	/**
	 * 财务其他 列名
	 */
	public static final String COL_financeother = "C_FINANCEOTHER";

	/**
	 * 加盟商所在机场城市
	 */
	public static final String COL_airportcode = "C_AIRPORTCODE";

	/**
	 * 是否允许修改行程单
	 */
	public static final String COL_ismodifyret = "C_ISMODIFYRET";

	/**
	 * 是否返现 <option value="1">不积分不返现</option> <option value="2">积分不返现</option>
	 * <option value="3">返现不积分</option> <option value="4">返现返积分</option>
	 */
	public static final String COL_isreturnmoney = "C_ISRETURNMONEY";

	/**
	 * 短信余额
	 */
	public static final String COL_smsmoney = "C_SMSMONEY";

	/**
	 * 代理上级别 0省级代理商，1市级代理商，2分销商，3经纪人
	 */
	public static final String COL_agentjibie = "C_AGENTJIBIE";

	/**
	 * 所在市ID
	 */
	public static final String COL_cityid = "C_CITYID";

	/**
	 * 虚拟账户金额
	 */
	public static final String COL_vmoney = "C_VMONEY";

	/**
	 * 返利账户金额
	 */
	public static final String COL_rebatemoney = "C_REBATEMONEY";

	/**
	 * 是否月结挂账
	 */
	public static final String COL_isallowmonthpay = "C_ISALLOWMONTHPAY";
	
	/**
	 * 类型
	 */
	public static final String COL_type = "C_TYPE";
	/**
	 * 固定返点值
	 */
	public static final String COL_fixedvalue = "C_FIXEDVALUE";
	
	
	

	// 加盟商ID
	private long id;

	// 代码
	private String code;
	
	// 系统账号备注
	private String beizhu;
	
	//限制查询次数
	private Integer searchtoall = -1;
	//已经查询次数
	private Integer searchnum = -1;
	

	// 加盟商类型(1=运营商,2=供应商,3=分销商)
	private Integer agenttype = 0;

	// 有效期开始时间
	private Timestamp agentvsdate;

	// 有效期结束时间
	private Timestamp agentvedate;

	// 单位名称
	private String agentcompanyname;

	// 单位??称
	private String agentshortname;

	// 客户类型
	private Integer agentcityid;

	// 单位电话
	private String agenttel;

	// 通信地址
	private String agentaddress;

	// 邮政编码
	private String agentpostcode;

	// 联系人姓名
	private String agentcontactname;

	// 联系人邮箱
	private String agentemail;

	// 审核状态
	private Integer agentcheckstatus;

	// 是否启用
	private Integer agentisenable;

	// 修改时间
	private Timestamp modifytime;

	// 修改者
	private String modifyuser;

	// 创建时间
	private Timestamp createtime;

	// 创建者
	private String createuser;

	// 父ID
	private Long parentid;

	// 父ID串
	private String parentstr;

	// 本公司留点
	private Float brokenum;

	// 子公司留点
	private Float childbrokenum;

	// 支付宝账号
	private String alipayaccount;

	// 财付通账号
	private String tenpayaccount;

	// 快钱账号
	private String kuaibillaccount;

	// MSN或QQ
	private String msnqq;

	// 公司网址
	private String website;

	// 是否大客户 0:不是 1:是
	private Long bigtype;

	// 南航编码
	private String czcode;

	// 东航编码
	private String mucode;

	// 国航编码
	private String cacode;

	// 创建者ID
	private Long userid;

	// 分润类型
	private Integer runtype;

	// 分润值
	private Integer runvalue;

	// 联系人工作电话
	private String agentphone;

	// 联系人传真
	private String agenrfax;

	// 联系人移动
	private String agentmobile;

	// 其他联系方式
	private String agentother;

	// 所属行业
	private String industry;

	// 财务联系人
	private String financename;

	// 财务工作电话
	private String financephone;

	// 财务传真号码
	private String financefax;

	// 财务移动电话
	private String financemobile;

	// 财务电邮
	private String financeemail;

	private String airportcode;

	private Integer ismodifyret;
	

	//供应上班时间
	private String  worktimebegin;
	//供应下班时间
	private String  worktimeend;
	private Double smsmoney;

	private Integer agentjibie;

	private Integer cityid;

	private float vmoney=-1;

	//

	private Integer isallowmonthpay;

	// 允许代理级别
	private int allowlevelcount = -1;
	// 允许代理数量
	private int allowproxycount = -1;

	// 出票人电话
	private String outticketmantel;

	// 出票人QQ或MSN
	private String outticketmanmsnqq;

	// 退票人电话
	private String backticketmantel;
	// 退票人QQ或MSN
	private String backticketmanmsnqq;
	
	
	// 类型(1=普通分销商,2=固定返点分销商,3=积分分销商)
	private Integer type;
//固定返点值
	private String fixedvalue;
	
	public int getAllowlevelcount() {
		return allowlevelcount;
	}

	public void setAllowlevelcount(int allowlevelcount) {
		this.allowlevelcount = allowlevelcount;
	}

	public int getAllowproxycount() {
		return allowproxycount;
	}

	public void setAllowproxycount(int allowproxycount) {
		this.allowproxycount = allowproxycount;
	}

	/**
	 * get加盟商ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * set加盟商ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * get代码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * set代码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * get加盟商类型(1=运营商,2=供应商,3=分销商)
	 */
	public Integer getAgenttype() {
		return agenttype;
	}

	/**
	 * set加盟商类型(1=运营商,2=供应商,3=分销商)
	 */
	public void setAgenttype(Integer agenttype) {
		this.agenttype = agenttype;
	}

	/**
	 * get有效期开始时间
	 */
	public Timestamp getAgentvsdate() {
		return agentvsdate;
	}

	/**
	 * set有效期开始时间
	 */
	public void setAgentvsdate(Timestamp agentvsdate) {
		this.agentvsdate = agentvsdate;
	}

	/**
	 * get有效期结束时间
	 */
	public Timestamp getAgentvedate() {
		return agentvedate;
	}

	/**
	 * set有效期结束时间
	 */
	public void setAgentvedate(Timestamp agentvedate) {
		this.agentvedate = agentvedate;
	}

	/**
	 * get单位名称
	 */
	public String getAgentcompanyname() {
		return agentcompanyname;
	}

	/**
	 * set单位名称
	 */
	public void setAgentcompanyname(String agentcompanyname) {
		this.agentcompanyname = agentcompanyname;
	}

	/**
	 * get单位??称
	 */
	public String getAgentshortname() {
		return agentshortname;
	}

	/**
	 * set单位??称
	 */
	public void setAgentshortname(String agentshortname) {
		this.agentshortname = agentshortname;
	}

	/**
	 * get所在地
	 */
	public Integer getAgentcityid() {
		return agentcityid;
	}

	/**
	 * set所在地
	 */
	public void setAgentcityid(Integer agentcityid) {
		this.agentcityid = agentcityid;
	}

	/**
	 * get单位电话
	 */
	public String getAgenttel() {
		return agenttel;
	}

	/**
	 * set单位电话
	 */
	public void setAgenttel(String agenttel) {
		this.agenttel = agenttel;
	}

	/**
	 * get通信地址
	 */
	public String getAgentaddress() {
		return agentaddress;
	}

	/**
	 * set通信地址
	 */
	public void setAgentaddress(String agentaddress) {
		this.agentaddress = agentaddress;
	}

	/**
	 * get邮政编码
	 */
	public String getAgentpostcode() {
		return agentpostcode;
	}

	/**
	 * set邮政编码
	 */
	public void setAgentpostcode(String agentpostcode) {
		this.agentpostcode = agentpostcode;
	}

	/**
	 * get联系人姓名
	 */
	public String getAgentcontactname() {
		return agentcontactname;
	}

	/**
	 * set联系人姓名
	 */
	public void setAgentcontactname(String agentcontactname) {
		this.agentcontactname = agentcontactname;
	}

	/**
	 * get联系人邮箱
	 */
	public String getAgentemail() {
		return agentemail;
	}

	/**
	 * set联系人邮箱
	 */
	public void setAgentemail(String agentemail) {
		this.agentemail = agentemail;
	}

	/**
	 * get审核状态
	 */
	public Integer getAgentcheckstatus() {
		return agentcheckstatus;
	}

	/**
	 * set审核状态
	 */
	public void setAgentcheckstatus(Integer agentcheckstatus) {
		this.agentcheckstatus = agentcheckstatus;
	}

	/**
	 * get是否启用
	 */
	public Integer getAgentisenable() {
		return agentisenable;
	}

	/**
	 * set是否启用
	 */
	public void setAgentisenable(Integer agentisenable) {
		this.agentisenable = agentisenable;
	}

	/**
	 * get修改时间
	 */
	public Timestamp getModifytime() {
		return modifytime;
	}

	/**
	 * set修改时间
	 */
	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}

	/**
	 * get修改者
	 */
	public String getModifyuser() {
		return modifyuser;
	}

	/**
	 * set修改者
	 */
	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}

	/**
	 * get创建时间
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}

	/**
	 * set创建时间
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	/**
	 * get创建者
	 */
	public String getCreateuser() {
		return createuser;
	}

	/**
	 * set创建者
	 */
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	/**
	 * get父ID
	 */
	public Long getParentid() {
		return parentid;
	}

	/**
	 * set父ID
	 */
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	/**
	 * get父ID串
	 */
	public String getParentstr() {
		return parentstr;
	}

	/**
	 * set父ID串
	 */
	public void setParentstr(String parentstr) {
		this.parentstr = parentstr;
	}

	/**
	 * get本公司留点
	 */
	public Float getBrokenum() {
		return brokenum;
	}

	/**
	 * set本公司留点
	 */
	public void setBrokenum(Float brokenum) {
		this.brokenum = brokenum;
	}

	/**
	 * get子公司留点
	 */
	public Float getChildbrokenum() {
		return childbrokenum;
	}

	/**
	 * set子公司留点
	 */
	public void setChildbrokenum(Float childbrokenum) {
		this.childbrokenum = childbrokenum;
	}

	/**
	 * get支付宝账号
	 */
	public String getAlipayaccount() {
		return alipayaccount;
	}

	/**
	 * set支付宝账号
	 */
	public void setAlipayaccount(String alipayaccount) {
		this.alipayaccount = alipayaccount;
	}

	/**
	 * get财付通账号
	 */
	public String getTenpayaccount() {
		return tenpayaccount;
	}

	/**
	 * set财付通账号
	 */
	public void setTenpayaccount(String tenpayaccount) {
		this.tenpayaccount = tenpayaccount;
	}

	/**
	 * get快钱账号
	 */
	public String getkuaibillaccount() {
		return kuaibillaccount;
	}

	/**
	 * set快钱账号
	 */
	public void setkuaibillaccount(String kuaibillaccount) {
		this.kuaibillaccount = kuaibillaccount;
	}

	/**
	 * getMSN或QQ
	 */
	public String getMsnqq() {
		return msnqq;
	}

	/**
	 * setMSN或QQ
	 */
	public void setMsnqq(String msnqq) {
		this.msnqq = msnqq;
	}

	/**
	 * get公司网址
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * set公司网址
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * get联系人工作电话
	 */
	public String getAgentphone() {
		return agentphone;
	}

	/**
	 * set联系人工作电话
	 */
	public void setAgentphone(String agentphone) {
		this.agentphone = agentphone;
	}

	/**
	 * get联系人传真
	 */
	public String getAgenrfax() {
		return agenrfax;
	}

	/**
	 * set联系人传真
	 */
	public void setAgenrfax(String agenrfax) {
		this.agenrfax = agenrfax;
	}

	/**
	 * get联系人移动
	 */
	public String getAgentmobile() {
		return agentmobile;
	}

	/**
	 * set联系人移动
	 */
	public void setAgentmobile(String agentmobile) {
		this.agentmobile = agentmobile;
	}

	/**
	 * get其他联系方式
	 */
	public String getAgentother() {
		return agentother;
	}

	/**
	 * set其他联系方式
	 */
	public void setAgentother(String agentother) {
		this.agentother = agentother;
	}

	/**
	 * get所属行业
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * set所属行业
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * get财务联系人
	 */
	public String getFinancename() {
		return financename;
	}

	/**
	 * set财务联系人
	 */
	public void setFinancename(String financename) {
		this.financename = financename;
	}

	/**
	 * get财务工作电话
	 */
	public String getFinancephone() {
		return financephone;
	}

	/**
	 * set财务工作电话
	 */
	public void setFinancephone(String financephone) {
		this.financephone = financephone;
	}

	/**
	 * get财务传真号码
	 */
	public String getFinancefax() {
		return financefax;
	}

	/**
	 * set财务传真号码
	 */
	public void setFinancefax(String financefax) {
		this.financefax = financefax;
	}

	/**
	 * get财务移动电话
	 */
	public String getFinancemobile() {
		return financemobile;
	}

	/**
	 * set财务移动电话
	 */
	public void setFinancemobile(String financemobile) {
		this.financemobile = financemobile;
	}

	/**
	 * get财务电邮
	 */
	public String getFinanceemail() {
		return financeemail;
	}

	/**
	 * set财务电邮
	 */
	public void setFinanceemail(String financeemail) {
		this.financeemail = financeemail;
	}


	public Long getBigtype() {
		return bigtype;
	}

	public void setBigtype(Long bigtype) {
		this.bigtype = bigtype;
	}

	public String toString() {

		return "[" + id + "|"

		+ code + "|"

		+ agenttype + "|"

		+ agentvsdate + "|"

		+ agentvedate + "|"

		+ agentcompanyname + "|"

		+ agentshortname + "|"

		+ agentcityid + "|"

		+ agenttel + "|"

		+ agentaddress + "|"

		+ agentpostcode + "|"

		+ agentcontactname + "|"

		+ agentemail + "|"

		+ agentcheckstatus + "|"

		+ agentisenable + "|"

		+ modifytime + "|"

		+ modifyuser + "|"

		+ createtime + "|"
		
		+ beizhu + "|"
		
		+ searchnum + "|"
		
		+ searchtoall + "|"

		+ createuser + "|"

		+ parentid + "|"
		
		+ smsmoney + "|"

		+ parentstr + "|"

		+ brokenum + "|"

		+ childbrokenum + "|"

		+ alipayaccount + "|"

		+ tenpayaccount + "|"

		+ kuaibillaccount + "|"

		+ msnqq + "|"

		+ bigtype + "|"

		+ userid + "|"

		+ cacode + "|"

		+ czcode + "|"

		+ mucode + "|"

		+ runtype + "|"

		+ runvalue + "|"

		+ website + "|"

		+ agentphone + "|"

		+ agenrfax + "|"

		+ agentmobile + "|"

		+ agentother + "|"

		+ industry + "|"

		+ financename + "|"

		+ financephone + "|"

		+ financefax + "|"

		+ financemobile + "|"

		+ financeemail + "|"

		+ vmoney + "|"
		
		+ type + "|"
		
		+ fixedvalue + "|"
		
		

		+ isallowmonthpay + "|"

		 + "]";
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getCzcode() {
		return czcode;
	}

	public void setCzcode(String czcode) {
		this.czcode = czcode;
	}

	public String getMucode() {
		return mucode;
	}

	public void setMucode(String mucode) {
		this.mucode = mucode;
	}

	public String getCacode() {
		return cacode;
	}

	public void setCacode(String cacode) {
		this.cacode = cacode;
	}

	public Integer getRuntype() {
		return runtype;
	}

	public void setRuntype(Integer runtype) {
		this.runtype = runtype;
	}

	public Integer getRunvalue() {
		return runvalue;
	}

	public void setRunvalue(Integer runvalue) {
		this.runvalue = runvalue;
	}

	public String getKuaibillaccount() {
		return kuaibillaccount;
	}

	public void setKuaibillaccount(String kuaibillaccount) {
		this.kuaibillaccount = kuaibillaccount;
	}

	public String getAirportcode() {
		return airportcode;
	}

	public void setAirportcode(String airportcode) {
		this.airportcode = airportcode;
	}

	public Integer getIsmodifyret() {
		return ismodifyret;
	}

	public void setIsmodifyret(Integer ismodifyret) {
		this.ismodifyret = ismodifyret;
	}

	

	public Double getSmsmoney() {
		return smsmoney;
	}

	public void setSmsmoney(Double smsmoney) {
		this.smsmoney = smsmoney;
	}

	public Integer getAgentjibie() {
		return agentjibie;
	}

	public void setAgentjibie(Integer agentjibie) {
		this.agentjibie = agentjibie;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public float getVmoney() {
		return vmoney;
	}

	public void setVmoney(float vmoney) {
		this.vmoney = vmoney;
	}


	public Integer getIsallowmonthpay() {
		return isallowmonthpay;
	}

	public void setIsallowmonthpay(Integer isallowmonthpay) {
		this.isallowmonthpay = isallowmonthpay;
	}

	public String getOutticketmantel() {
		return outticketmantel;
	}

	public void setOutticketmantel(String outticketmantel) {
		this.outticketmantel = outticketmantel;
	}

	public String getOutticketmanmsnqq() {
		return outticketmanmsnqq;
	}

	public void setOutticketmanmsnqq(String outticketmanmsnqq) {
		this.outticketmanmsnqq = outticketmanmsnqq;
	}

	public String getBackticketmantel() {
		return backticketmantel;
	}

	public void setBackticketmantel(String backticketmantel) {
		this.backticketmantel = backticketmantel;
	}

	public String getBackticketmanmsnqq() {
		return backticketmanmsnqq;
	}

	public void setBackticketmanmsnqq(String backticketmanmsnqq) {
		this.backticketmanmsnqq = backticketmanmsnqq;
	}



	public String getWorktimebegin() {
		return worktimebegin;
	}

	public void setWorktimebegin(String worktimebegin) {
		this.worktimebegin = worktimebegin;
	}

	public String getWorktimeend() {
		return worktimeend;
	}

	public void setWorktimeend(String worktimeend) {
		this.worktimeend = worktimeend;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getFixedvalue() {
		return fixedvalue;
	}

	public void setFixedvalue(String fixedvalue) {
		this.fixedvalue = fixedvalue;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getSearchtoall() {
		return searchtoall;
	}

	public void setSearchtoall(Integer searchtoall) {
		this.searchtoall = searchtoall;
	}

	public Integer getSearchnum() {
		return searchnum;
	}

	public void setSearchnum(Integer searchnum) {
		this.searchnum = searchnum;
	}

}
