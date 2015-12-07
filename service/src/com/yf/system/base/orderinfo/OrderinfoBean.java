/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.orderinfo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.base.passenger.Passenger;

/**
 * 订单信息表
 */
public class OrderinfoBean implements java.io.Serializable {

	/**
	 * 订单信息表 表名
	 */
	public static final String TABLE = "T_ORDERINFO";

	/**
	 * 订单ID 列名
	 */
	public static final String COL_id = "ID";

	/**
	 * 订单号 列名
	 */
	public static final String COL_ordernumber = "C_ORDERNUMBER";

	/**
	 * 分销商ID 列名
	 * 
	 */
	public static final String COL_buyagentid = "C_BUYAGENTID";

	/**
	 * 政策ID 列名
	 */
	public static final String COL_policyid = "C_POLICYID";

	/**
	 * 联系人姓名 列名
	 */
	public static final String COL_contactname = "C_CONTACTNAME";

	/**
	 * 联系人手机 列名
	 */
	public static final String COL_contactmobile = "C_CONTACTMOBILE";

	/**
	 * 备注信息 列名
	 */
	public static final String COL_memo = "C_MEMO";

	/**
	 * 送票方式 列名
	 */
	public static final String COL_receipt = "C_RECEIPT";

	/**
	 * 送票地址 列名
	 */
	public static final String COL_addresa = "C_ADDRESA";

	/**
	 * 订单状态 列名
	 */
	public static final String COL_orderstatus = "C_ORDERSTATUS";

	/**
	 * 总燃油费 列名
	 */
	public static final String COL_totalfuelfee = "C_TOTALFUELFEE";

	/**
	 * 总机建费 列名
	 */
	public static final String COL_totalairportfee = "C_TOTALAIRPORTFEE";

	/**
	 * 总票面价 列名
	 */
	public static final String COL_totalticketprice = "C_TOTALTICKETPRICE";

	/**
	 * 创建时间 列名
	 */
	public static final String COL_createtime = "C_CREATETIME";

	/**
	 * 关联订单号 列名
	 */
	public static final String COL_relationorderid = "C_RELATIONORDERID";

	/**
	 * 退改签状态 列名
	 */
	public static final String COL_tuistatus = "C_TUISTATUS";

	/**
	 * 联系电话 列名
	 */
	public static final String COL_contacttel = "C_CONTACTTEL";

	/**
	 * PNR 列名
	 */
	public static final String COL_pnr = "C_PNR";

	/**
	 * 支付状态 列名
	 */
	public static final String COL_paystatus = "C_PAYSTATUS";

	/**
	 * 支付方式 列名
	 */
	public static final String COL_paymethod = "C_PAYMETHOD";
	/**
	 * 出票方式 列名 1=立即出票 2=暂缓出票
	 */
	public static final String COL_fkmethod = "C_FKMETHOD";

	/**
	 * 预订人id 列名
	 */
	public static final String COL_saleagentid = "C_SALEAGENTID";

	/**
	 * 会员ID 列名
	 */
	public static final String COL_customeruserid = "C_CUSTOMERUSERID";



	/**
	 * 通知方式 列名
	 */
	public static final String COL_notetype = "C_NOTETYPE";

	/**
	 * 联系人EMail 列名
	 */
	public static final String COL_contactemail = "C_CONTACTEMAIL";

	/**
	 * 联系人传真 列名
	 */
	public static final String COL_contactfax = "C_CONTACTFAX";

	/**
	 * 出票日期 列名
	 */
	public static final String COL_printtime = "C_PRINTTIME";

	/**
	 * 折扣 列名
	 */
	public static final String COL_ratevalue = "C_RATEVALUE";

	/**
	 * 父编号 列名
	 */
	public static final String COL_ucode = "C_UCODE";

	/**
	 * 语言类型 列名
	 */
	public static final String COL_language = "C_LANGUAGE";

	/**
	 * 保险份数 列名
	 */
	public static final String COL_operate = "C_OPERATE";

	/**
	 * 邮寄金额 列名
	 */
	public static final String COL_postmoney = "C_POSTMONEY";

	/**
	 * 收件人姓名 列名
	 */
	public static final String COL_postname = "C_POSTNAME";

	/**
	 * 收件人电话 列名
	 */
	public static final String COL_postmobile = "C_POSTMOBILE";

	/**
	 * 收件人邮编 列名
	 */
	public static final String COL_postcode = "C_POSTCODE";

	/**
	 * 订单来源 列名
	 */
	public static final String COL_ordertype = "C_ORDERTYPE";

	/**
	 * 供应商操作状态
	 */
	public static final String COL_operatingstate = "C_OPERATINGSTATE";

	/**
	 * 供应商修改时间 列名
	 */
	public static final String COL_updatetime = "C_UPDATETIME";

	/**
	 * 供应商修改者ID 列名
	 */
	public static final String COL_userid = "C_USERID";

	/**
	 * 分销商操作状态
	 */
	public static final String COL_fenxiaooperstate = "C_FENXIAOOPERSTATE";

	/**
	 * 分销商修改时间 列名
	 */
	public static final String COL_fenxiaoupdatetime = "C_FENXIAOUPDATETIME";

	/**
	 * 分销商修改者ID 列名
	 */
	public static final String COL_fenxiaouserid = "C_FENXIAOUSERID";

	/**
	 * 大PNR 列名
	 */
	public static final String COL_bigpnr = "C_BIGPNR";

	/**
	 * 换开关联ID
	 */
	public static final String COL_gaiorderid = "C_GAIORDERID";

	/**
	 * 分销商锁单时间 列名
	 */
	public static final String COL_fxssuotime = "C_FXSSUOTIME";

	/**
	 * 供应商锁单时间 列名
	 */
	public static final String COL_gyssuotime = "C_GYSSUOTIME";

	/**
	 * 取消订单时间 列名
	 */
	public static final String COL_quxiaotime = "C_QUXIAOTIME";

	/**
	 * 配送状态
	 */
	public static final String COL_peisongstatus = "C_PEISONGSTATUS";
	/**
	 * 配送人ID
	 */
	public static final String COL_peisongrenid = "C_PEISONGRENID";

	/**
	 * 接送人姓名(现在用于保存office)
	 */
	public static final String COL_pickonename = "C_PICKONENAME";
	/**
	 * 接送人电话(现在用于保存出票速度)
	 */
	public static final String COL_pickonephone = "C_PICKONEPHONE";

	/**
	 * 订单紧急状态
	 */
	public static final String COL_busystatus = "C_BUSYSTATUS";

	/**
	 * 挂账人id
	 */
	public static final String COL_guazhangrenid = "C_GUAZHANGRENID";

	/**
	 * 配送日期
	 */
	public static final String C_peisongdate = "C_PEISONGDATE";

	/**
	 * 新PNR
	 */

	public static final String COL_newpnr = "C_NEWPNR";

	/**
	 * 新票号
	 */
	public static final String COL_newticnum = "C_NEWTICNUM";

	/**
	 * 新订单号
	 */
	public static final String COL_newordernum = "C_NEWORDERNUM";

	/**
	 * 外部政策id
	 */
	public static final String COL_extpolicyid = "C_EXTPOLICYID";

	/**
	 * 政策提供商id
	 */
	public static final String COL_policyagentid = "C_POLICYAGENTID";
	
	/**
	 * 订单原状态 列名
	 */
	public static final String COL_oldorderstatus = "C_OLDORDERSTATUS";


	/**
	 * 外部订单id
	 */
	public static final String COL_extorderid = "C_EXTORDERID";
	
	/**
	 * NEW外部订单id
	 */
	public static final String COL_newextorderid = "C_NEWEXTORDERID";

	/**
	 * 外部订单状态
	 */
	public static final String COL_extorderstatus = "C_EXTORDERSTATUS";

	/**
	 * 外部订单外部政策id
	 */
	public static final String COL_extorderpolicyid = "C_EXTORDERPOLICYID";

	/**
	 * 外部订单实际金额
	 */
	public static final String COL_extorderprice = "C_EXTORDERPRICE";

	/**
	 * 外部订单创建时间
	 */
	public static final String COL_extordercreatetime = "C_EXTORDERCREATETIME";

	/**
	 * 外部订单外部政策id
	 */
	public static final String COL_extorderepolicyid = "C_EXTORDEREPOLICYID";

	/**
	 * 分销商返点
	 */
	public static final String COL_fenxiaoshangfandian = "C_FENXIAOSHANGFANDIAN";
	
	
	public static final String COL_CREDITCARDID="C_CREDITCARDID";
	
	/**
	 * 升舱关联订单ID
	 */
	public static final String COL_shengcangorderid="C_SHENGCANGORDERID";
	
	//总安检费用
	public static final String COL_totalanjian="C_TOTALANJIAN";
	
	//总其他税费
	public static final String COL_totalotherfee="C_TOTALOTHERFEE";
	
	//是否是国际订单
	public static final String COL_internal="C_INTERNAL";
	
	public static final String COL_cashier="C_CASHIER";
	
	//折扣金额
	public static final String COL_zhekoujine="C_ZHEKOUJINE";
	public static final String COL_isprint="C_ISPRINT";
	
	public static final String COL_ismutily="C_ISMULITY";
	//返佣金额
	public static final String COL_rebatemoney="C_REBATEMONEY";
	
	//返佣信息记录
	public static final String COL_backpointinfo="C_BACKPOINTINFO";
	
	
	
	/**
	 * 联系人短信类型
	 *主要用于先保存，后发送
	 */
	public static final String COL_contactmsgtype = "C_CONTACTMSGTYPE";
	
	/**
	 * 当前订单
	 */
	public static final String COL_operateagent = "C_OPERATEAGENT";
	
	

	public static final String COL_returnprice="C_RETURNPRICE";
	

	public static final String COL_paymenturl="C_PAYMENTURL";
	
	
	/**
	 * 当前订单的平台费(如果同时有多个平台费，插入数据的时候，只在一条数据中标出，请将平台费其它的值标记为0)
	 */
	public static final String COL_currpaltfee="C_CURRPLATFEE";
	
	public static final String COL_pnrtxt="C_PNRTXT";

	public static final String COL_pattxt="C_PATTXT";
	
	public static final String COL_b2cprofit="C_B2CPROFIT";
	
	public static final String COL_cclientpayprice="C_CCLIENTPAYPRICE";
	// 订单ID
	private long id;
	
	/**
	 * 订单总价 包含税费
	 */
	private float orderprice;
	
	
	//退费票退费金额
	private Float returnprice;
	
	// 订单号
	private String ordernumber;
	// 是否打印
	private Integer isprint;

	// 分销商ID
	private Long buyagentid;

	// 政策ID
	private Long policyid;

	// 备注信息
	private String memo;

	// 送票方式
	private Integer receipt;

	// 送票地址
	private String addresa;

	// 订单状态
	private Integer orderstatus;

	// 总燃油费
	private Float totalfuelfee;

	// 总机建费
	private Float totalairportfee;

	// 总票面价
	private Float totalticketprice;

	// 创建时间
	private Timestamp createtime;

	// 关联订单号
	private Long relationorderid;

	// 退改签状态
	private Integer tuistatus;

	// 联系电话
	private String contacttel;

	// PNR
	private String pnr;

	// 支付状态
	private Integer paystatus;

	// 支付方式
	private Integer paymethod;

	// 付款方式 //1:现金，2，支票，3，建行pos，4,：银联pos，5：免优票，6：里程券，7：个人挂账，8：月结挂账9：网上支付10,：银行汇款
	private Integer fkmethod;

	// 预订人id 运营商操作人员id
	private Long saleagentid;

	// 会员ID 订单所属会员
	private Long customeruserid;

	// 订单所属单位ID
	private Long customeragentid;

	// 通知方式
	private Integer notetype;

	// 联系人姓名
	private String contactname;

	// 联系人手机
	private String contactmobile;

	// 联系人EMail
	private String contactemail;

	// 联系人传真
	private String contactfax;

	// 出票日期
	private Timestamp printtime;

	// 折扣
	private Float ratevalue;

	// 父编号
	private Long ucode;

	// 语言类型
	private Integer language;


	// 邮寄金额
	private Integer postmoney;

	// 收件人姓名
	private String postname;

	// 收件人电话
	private String postmobile;//Postmobile-工作时间

	// 收件人邮编
	private String postcode;

	// 订单来源    1:网站订单，2.后台订单。3.3G手机订单
	private Long ordertype;

	// 供应商订单操作状态
	private Long operatingstate;

	// 供应商订单操作人id
	private Long userid;
	
	//当前操作订单商
	private Long operateagent;

	// 供应商订单修改时间
	private Timestamp updatetime;

	// 分销商订单操作状态
	private Long fenxiaooperstate;

	// 分销商订单操作人id
	private Long fenxiaouserid;

	// 分销商订单修改时间
	private Timestamp fenxiaoupdatetime;

	// 大PNR
	private String bigpnr;

	// 换开关联id
	private Long gaiorderid;

	// 分销商锁单时间
	private Timestamp fxssuotime;

	// 供应商锁单时间
	private Timestamp gyssuotime;

	// 取消订单时间
	private Timestamp quxiaotime;

	private Long peisongstatus;

	private Long peisongrenid;

	private String pickonename;//现在用于保存office

	private String pickonephone;
	// 订单紧急状态
	private Long busystatus;
	// 挂账人id
	private Long guazhangrenid;

	private Timestamp peisongdate;

	//供应换PNR出票 
	private String newpnr;

	private String newticnum;

	private String newordernum;

	// 外部政策id
	private String extpolicyid;

	// 政策提供商id
	private Long policyagentid;

	// 外部订单id
	private String extorderid;
	
	// 新外部订单id(退/废生成)
	private String newextorderid;

	// 外部订单状态
	private Integer extorderstatus;
	
	//外部订单状态 文字形式。不关联数据库
	private String extorderstatusstr;//1 新订单等待支付   2已经付款，等待出票  3已经出票，交易结束

	// 外部订单政策id
	private Integer extorderpolicyid;

	// 外部订单外部政策id
	private String extorderepolicyid;

	// 外部订单实际金额
	private Float extorderprice;
	
	
	//外部供应商退款金额
	private Float extreturnprice;
	
	

	// 外部订单创建时间
	private Timestamp extordercreatetime;

	// 分销商返点
	private Float fenxiaoshangfandian;
	
	private Integer cashier;//是否收银，0，未，1：已
	
	 //* 关联信用卡
	 
	private Long creditcardid;
	
	//升舱关联订单ID
	private Long shengcangorderid;
	
	private String shengcangoldtn;
	
	private Long isshengcang;
	
	private Float totalanjian;
	
	private Integer contactmsgtype;
	
	private Float totalotherfee;
	
	private Long internal;
	
	private Float zhekoujine;
	
	private Long ismutily;

	// 订单原状态  退废改签保存期原状态。
	private Integer oldorderstatus;
	
	private String backpointinfo;

	
	private Float rebatemoney;
	

	private String paymenturl;
	
	private int isbackinsur=0;//是否退保险 ：1.不退，2 退

	/**
	 * 当前定单平台费记录字段
	 */
	private Float currplatfee;
	//B2C网站利润
	private String b2cprofit;
	//C客户端支付价格
	private String cclientpayprice;
	//0不参与分润，1参与分润给允风文化
	private int ispayhthy=1;
	
	
	private String pnrtxt;
	
	
	private String pattxt;
	
	public String getOrdertypestr(){
		if(this.ordertype==1){
			return  "网站订单</br>散客";
		}
		if(this.ordertype==2){
			return  "后台订单</br>散客";
		}
		if(this.ordertype==3){
			return  "手机订单</br>散客";
		}
		if(this.ordertype==4){
			return  "差旅订单</br>散客";
		}
		if(this.ordertype==5){
			return  "后台订单</br>团队";
		}
		if(this.ordertype==6){
			return  "网站订单</br>团队";
		}
		return "";
	}
	


	/**
	 * get订单ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * set订单ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * get订单号
	 */
	public String getOrdernumber() {
		return ordernumber;
	}

	/**
	 * set订单号
	 */
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	/**
	 * get分销商ID
	 */
	public Long getBuyagentid() {
		return buyagentid;
	}

	/**
	 * set分销商ID
	 */
	public void setBuyagentid(Long buyagentid) {
		this.buyagentid = buyagentid;
	}

	/**
	 * get政策ID
	 */
	public Long getPolicyid() {
		return policyid;
	}

	public Timestamp getQuxiaotime() {
		return quxiaotime;
	}

	public void setQuxiaotime(Timestamp quxiaotime) {
		this.quxiaotime = quxiaotime;
	}

	/**
	 * set政策ID
	 */
	public void setPolicyid(Long policyid) {
		this.policyid = policyid;
	}

	/**
	 * get联系人姓名
	 */
	public String getContactname() {
		return contactname;
	}

	/**
	 * set联系人姓名
	 */
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	/**
	 * get联系人手机
	 */
	public String getContactmobile() {
		return contactmobile;
	}

	/**
	 * set联系人手机
	 */
	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}

	/**
	 * get备注信息
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * set备注信息
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * get送票方式
	 */
	public Integer getReceipt() {
		return receipt;
	}

	/**
	 * set送票方式
	 */
	public void setReceipt(Integer receipt) {
		this.receipt = receipt;
	}

	/**
	 * get送票地址
	 */
	public String getAddresa() {
		return addresa;
	}

	/**
	 * set送票地址
	 */
	public void setAddresa(String addresa) {
		this.addresa = addresa;
	}

	/**
	 * get订单状态
	 */
	public Integer getOrderstatus() {
		return orderstatus;
	}

	/**
	 * set订单状态
	 */
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}

	/**
	 * get总燃油费
	 */
	public Float getTotalfuelfee() {
		return totalfuelfee;
	}

	/**
	 * set总燃油费
	 */
	public void setTotalfuelfee(Float totalfuelfee) {
		this.totalfuelfee = totalfuelfee;
	}

	/**
	 * get总机建费
	 */
	public Float getTotalairportfee() {
		return totalairportfee;
	}

	/**
	 * set总机建费
	 */
	public void setTotalairportfee(Float totalairportfee) {
		this.totalairportfee = totalairportfee;
	}

	/**
	 * get总票面价
	 */
	public Float getTotalticketprice() {
		return totalticketprice;
	}

	/**
	 * set总票面价
	 */
	public void setTotalticketprice(Float totalticketprice) {
		this.totalticketprice = totalticketprice;
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
	 * get关联订单号
	 */
	public Long getRelationorderid() {
		return relationorderid;
	}

	/**
	 * set关联订单号
	 */
	public void setRelationorderid(Long relationorderid) {
		this.relationorderid = relationorderid;
	}

	/**
	 * get退改签状态
	 */
	public Integer getTuistatus() {
		return tuistatus;
	}

	/**
	 * set退改签状态
	 */
	public void setTuistatus(Integer tuistatus) {
		this.tuistatus = tuistatus;
	}

	/**
	 * get联系电话
	 */
	public String getContacttel() {
		return contacttel;
	}

	/**
	 * set联系电话
	 */
	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	/**
	 * getPNR
	 */
	public String getPnr() {
		return pnr;
	}

	/**
	 * setPNR
	 */
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	/**
	 * get支付状态
	 */
	public Integer getPaystatus() {
		return paystatus;
	}

	/**
	 * set支付状态
	 */
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}

	/**
	 * get支付方式
	 */
	public Integer getPaymethod() {
		return paymethod;
	}

	/**
	 * set支付方式
	 */
	public void setPaymethod(Integer paymethod) {
		this.paymethod = paymethod;
	}

	/**
	 * get出票商
	 */
	public Long getSaleagentid() {
		return saleagentid;
	}

	/**
	 * set出票商
	 */
	public void setSaleagentid(Long saleagentid) {
		this.saleagentid = saleagentid;
	}

	/**
	 * get会员ID
	 */
	public Long getCustomeruserid() {
		return customeruserid;
	}

	/**
	 * set会员ID
	 */
	public void setCustomeruserid(Long customeruserid) {
		this.customeruserid = customeruserid;
	}

	/**
	 * get通知方式
	 */
	public Integer getNotetype() {
		return notetype;
	}

	/**
	 * set通知方式
	 */
	public void setNotetype(Integer notetype) {
		this.notetype = notetype;
	}

	/**
	 * get联系人EMail
	 */
	public String getContactemail() {
		return contactemail;
	}

	/**
	 * set联系人EMail
	 */
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	/**
	 * get联系人传真
	 */
	public String getContactfax() {
		return contactfax;
	}

	/**
	 * set联系人传真
	 */
	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}

	/**
	 * get出票日期
	 */
	public Timestamp getPrinttime() {
		return printtime;
	}

	/**
	 * set出票日期
	 */
	public void setPrinttime(Timestamp printtime) {
		this.printtime = printtime;
	}

	/**
	 * get折扣
	 */
	public Float getRatevalue() {
		return ratevalue;
	}

	/**
	 * set折扣
	 */
	public void setRatevalue(Float ratevalue) {
		this.ratevalue = ratevalue;
	}

	/**
	 * get父编号
	 */
	public Long getUcode() {
		return ucode;
	}

	/**
	 * set父编号
	 */
	public void setUcode(Long ucode) {
		this.ucode = ucode;
	}

	/**
	 * get语言类型
	 */
	public Integer getLanguage() {
		return language;
	}

	/**
	 * set语言类型
	 */
	public void setLanguage(Integer language) {
		this.language = language;
	}


	/**
	 * get邮寄金额
	 */
	public Integer getPostmoney() {
		return postmoney;
	}

	/**
	 * set邮寄金额
	 */
	public void setPostmoney(Integer postmoney) {
		this.postmoney = postmoney;
	}

	/**
	 * get收件人姓名
	 */
	public String getPostname() {
		return postname;
	}

	/**
	 * set收件人姓名
	 */
	public void setPostname(String postname) {
		this.postname = postname;
	}

	/**
	 * get收件人电话
	 */
	public String getPostmobile() {
		return postmobile;
	}

	/**
	 * set收件人电话
	 */
	public void setPostmobile(String postmobile) {
		this.postmobile = postmobile;
	}

	/**
	 * get收件人邮编
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * set收件人邮编
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * get订单来源
	 */
	public Long getOrdertype() {
		return ordertype;
	}

	/**
	 * set订单来源
	 */
	public void setOrdertype(Long ordertype) {
		this.ordertype = ordertype;
	}

	/**
	 * get订单的紧急状态
	 */
	public Long getBusystatus() {
		return busystatus;
	}

	/**
	 * set订单的紧急状态
	 */
	public void setBusystatus(Long busystatus) {
		this.busystatus = busystatus;
	}

	/**
	 * get挂账人ID
	 */
	public Long getGuazhangrenid() {
		return guazhangrenid;
	}

	/**
	 * set订单ID
	 */
	public void setGuazhangrenid(Long guazhangrenid) {
		this.guazhangrenid = guazhangrenid;
	}

	/**
	 * get配送时间
	 */
	public Timestamp getPeisongdate() {
		return peisongdate;
	}

	/**
	 * set配送时间
	 */
	public void setPeisongdate(Timestamp peisongdate) {
		this.peisongdate = peisongdate;
	}

	/**
	 * get备注信息
	 */
	public String getNewpnr() {
		return newpnr;
	}

	/**
	 * set备注信息
	 */
	public void setNewpnr(String newpnr) {
		this.newpnr = newpnr;
	}

	/**
	 * get新票号
	 */
	public String getNewticnum() {
		return newticnum;
	}

	/**
	 * set新票号
	 */
	public void setNewticnum(String newticnum) {
		this.newticnum = newticnum;
	}

	/**
	 * get新订单号
	 */
	public String getNewordernum() {
		return newordernum;
	}

	/**
	 * set新订单号
	 */
	public void setNewordernum(String newordernum) {
		this.newordernum = newordernum;
	}

	public Timestamp getFxssuotime() {
		return fxssuotime;
	}

	public void setFxssuotime(Timestamp fxssuotime) {
		this.fxssuotime = fxssuotime;
	}

	public Timestamp getGyssuotime() {
		return gyssuotime;
	}

	public void setGyssuotime(Timestamp gyssuotime) {
		this.gyssuotime = gyssuotime;
	}

	public Long getOperatingstate() {
		return operatingstate;
	}

	public void setOperatingstate(Long operatingstate) {
		this.operatingstate = operatingstate;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getBigpnr() {
		return bigpnr;
	}

	public void setBigpnr(String bigpnr) {
		this.bigpnr = bigpnr;
	}

	public Long getFenxiaooperstate() {
		return fenxiaooperstate;
	}

	public void setFenxiaooperstate(Long fenxiaooperstate) {
		this.fenxiaooperstate = fenxiaooperstate;
	}

	public Long getFenxiaouserid() {
		return fenxiaouserid;
	}

	public void setFenxiaouserid(Long fenxiaouserid) {
		this.fenxiaouserid = fenxiaouserid;
	}

	public Timestamp getFenxiaoupdatetime() {
		return fenxiaoupdatetime;
	}

	public void setFenxiaoupdatetime(Timestamp fenxiaoupdatetime) {
		this.fenxiaoupdatetime = fenxiaoupdatetime;
	}

	public Long getPeisongstatus() {
		return peisongstatus;
	}

	public void setPeisongstatus(Long peisongstatus) {
		this.peisongstatus = peisongstatus;
	}

	public Long getPeisongrenid() {
		return peisongrenid;
	}

	public void setPeisongrenid(Long peisongrenid) {
		this.peisongrenid = peisongrenid;
	}

	public String toString() {

		return "[" + id + "|"

		+ ordernumber + "|"

		+ buyagentid + "|"

		+ policyid + "|"

		+ contactname + "|"

		+ contactmobile + "|"

		+ memo + "|"

		+ receipt + "|"

		+ addresa + "|"

		+ orderstatus + "|"

		+ totalfuelfee + "|"

		+ totalairportfee + "|"

		+ totalticketprice + "|"

		+ createtime + "|"

		+ relationorderid + "|"

		+ tuistatus + "|"

		+ contacttel + "|"

		+ pnr + "|"

		+ paystatus + "|"

		+ paymethod + "|"

		+ saleagentid + "|"

		+ customeruserid + "|"

		+ notetype + "|"

		+ contactemail + "|"

		+ contactfax + "|"

		+ printtime + "|"

		+ ratevalue + "|"

		+ ucode + "|"

		+ language + "|"

	

		+ postmoney + "|"

		+ postname + "|"

		+ postmobile + "|"

		+ postcode + "|"

		+ userid + "|"

		+ updatetime + "|"

		+ operatingstate + "|"

		+ fenxiaouserid + "|"

		+ fenxiaoupdatetime + "|"

		+ fenxiaooperstate + "|"

		+ bigpnr + "|"

		+ gaiorderid + "|"

		+ fxssuotime + "|"
		
		+ newextorderid + "|"

		+ gyssuotime + "|"

		+ quxiaotime + "|"

		+ peisongstatus + "|"

		+ peisongrenid + "|"

		+ busystatus + "|"

		+ guazhangrenid + "|"

		+ peisongdate + "|"

		+ newpnr + "|"

		+ ordertype+"|"
		
		+ shengcangoldtn+"|"
		
		+ isshengcang+"|"
		
		+ totalanjian+"|"
		
		+ pnrtxt+"|"
		
		+ pattxt+"|"
		
		+ b2cprofit+"|"
		
		+ cclientpayprice+"|"
		
		+totalotherfee+"|"
		
		+internal+"|"
		
		+zhekoujine+"|"
		
		+rebatemoney+"|"
		
		+ shengcangorderid
		
		+ "]";
	}
	public Long getGaiorderid() {
		return gaiorderid;
	}

	public void setGaiorderid(Long gaiorderid) {
		this.gaiorderid = gaiorderid;
	}

	public String getPickonename() {
		return pickonename;
	}

	public void setPickonename(String pickonename) {
		this.pickonename = pickonename;
	}

	public String getPickonephone() {
		return pickonephone;
	}

	public void setPickonephone(String pickonephone) {
		this.pickonephone = pickonephone;
	}

	public Long getCustomeragentid() {
		return customeragentid;
	}

	public void setCustomeragentid(Long customeragentid) {
		this.customeragentid = customeragentid;

	}

	public Integer getFkmethod() {
		return fkmethod;
	}

	public void setFkmethod(Integer fkmethod) {
		this.fkmethod = fkmethod;

	}

	public String getExtpolicyid() {
		return extpolicyid;
	}

	public void setExtpolicyid(String extpolicyid) {
		this.extpolicyid = extpolicyid;
	}

	public Long getPolicyagentid() {
		return policyagentid;
	}

	public void setPolicyagentid(Long policyagentid) {
		this.policyagentid = policyagentid;
	}

	public String getExtorderid() {
		return extorderid;
	}

	public void setExtorderid(String extorderid) {
		this.extorderid = extorderid;
	}

	public Integer getExtorderstatus() {
		return extorderstatus;
	}

	public void setExtorderstatus(Integer extorderstatus) {
		this.extorderstatus = extorderstatus;
	}

	public Integer getExtorderpolicyid() {
		return extorderpolicyid;
	}

	public void setExtorderpolicyid(Integer extorderpolicyid) {
		this.extorderpolicyid = extorderpolicyid;
	}

	public String getExtorderepolicyid() {
		return extorderepolicyid;
	}

	public void setExtorderepolicyid(String extorderepolicyid) {
		this.extorderepolicyid = extorderepolicyid;
	}

	public Float getExtorderprice() {
		return extorderprice;
	}

	public void setExtorderprice(Float extorderprice) {
		this.extorderprice = extorderprice;
	}

	public Timestamp getExtordercreatetime() {
		return extordercreatetime;
	}

	public void setExtordercreatetime(Timestamp extordercreatetime) {
		this.extordercreatetime = extordercreatetime;
	}

	public Float getFenxiaoshangfandian() {
		return fenxiaoshangfandian;
	}

	public void setFenxiaoshangfandian(Float fenxiaoshangfandian) {
		this.fenxiaoshangfandian = fenxiaoshangfandian;

	}

	public Long getCreditcardid() {
		return creditcardid;
	}

	public void setCreditcardid(Long creditcardid) {
		this.creditcardid = creditcardid;
	}

	public Long getShengcangorderid() {
		return shengcangorderid;
	}

	public void setShengcangorderid(Long shengcangorderid) {
		this.shengcangorderid = shengcangorderid;
	}

	public String getShengcangoldtn() {
		return shengcangoldtn;
	}

	public void setShengcangoldtn(String shengcangoldtn) {
		this.shengcangoldtn = shengcangoldtn;
	}

	public Long getIsshengcang() {
		return isshengcang;
	}

	public void setIsshengcang(Long isshengcang) {
		this.isshengcang = isshengcang;
	}

	

	public Long getInternal() {
		return internal;
	}

	public void setInternal(Long internal) {
		this.internal = internal;
	}

	public Integer getCashier() {
		return cashier;
	}

	public void setCashier(Integer cashier) {
		this.cashier = cashier;
	}

	public Float getTotalanjian() {
		return totalanjian;
	}

	public void setTotalanjian(Float totalanjian) {
		this.totalanjian = totalanjian;
	}

	public Float getTotalotherfee() {
		return totalotherfee;
	}

	public void setTotalotherfee(Float totalotherfee) {
		this.totalotherfee = totalotherfee;
	}

	public Float getZhekoujine() {
		return zhekoujine;
	}

	public void setZhekoujine(Float zhekoujine) {
		this.zhekoujine = zhekoujine;
	}

	public Integer getIsprint() {
		return isprint;
	}

	public void setIsPrint(Integer isPrint) {
		this.isprint = isPrint;
	}

	public Long getIsmutily() {
		return ismutily;
	}

	public void setIsmutily(Long ismutily) {
		this.ismutily = ismutily;
	}

	public Integer getOldorderstatus() {
		return oldorderstatus;
	}

	public void setOldorderstatus(Integer oldorderstatus) {
		this.oldorderstatus = oldorderstatus;
	}

	public Integer getContactmsgtype() {
		return contactmsgtype;
	}

	public void setContactmsgtype(Integer contactmsgtype) {
		this.contactmsgtype = contactmsgtype;
	}

	public void setIsprint(Integer isprint) {
		this.isprint = isprint;
	}

	public Float getReturnprice() {
		return returnprice;
	}

	public void setReturnprice(Float returnprice) {
		this.returnprice = returnprice;
	}

	public Float getRebatemoney() {
		return rebatemoney;
	}

	public void setRebatemoney(Float rebatemoney) {
		this.rebatemoney = rebatemoney;
	}

	public Long getOperateagent() {
		return operateagent;
	}

	public void setOperateagent(Long operateagent) {
		this.operateagent = operateagent;
	}



	public float getOrderprice() {
		return orderprice;
	}



	public void setOrderprice(float orderprice) {
		this.orderprice = orderprice;
	}



	public String getBackpointinfo() {
		return backpointinfo;
	}



	public void setBackpointinfo(String backpointinfo) {
		this.backpointinfo = backpointinfo;
	}

	public Float getCurrplatfee() {
		return currplatfee;
	}



	public void setCurrplatfee(Float currplatfee) {
		this.currplatfee = currplatfee;
	}



	public String getPaymenturl() {
		return paymenturl;
	}



	public void setPaymenturl(String paymenturl) {
		this.paymenturl = paymenturl;
	}



	public String getExtorderstatusstr() {
		return extorderstatusstr;
	}



	public void setExtorderstatusstr(String extorderstatusstr) {
		this.extorderstatusstr = extorderstatusstr;
	}



	public int getIsbackinsur() {
		return isbackinsur;
	}



	public void setIsbackinsur(int isbackinsur) {
		this.isbackinsur = isbackinsur;
	}




	public Float getExtreturnprice() {
		return extreturnprice;
	}



	public void setExtreturnprice(Float extreturnprice) {
		this.extreturnprice = extreturnprice;
	}




	public String getNewextorderid() {
		return newextorderid;
	}



	public void setNewextorderid(String newextorderid) {
		this.newextorderid = newextorderid;
	}



	public String getB2cprofit() {
		return b2cprofit;
	}



	public void setB2cprofit(String b2cprofit) {
		this.b2cprofit = b2cprofit;
	}



	public String getCclientpayprice() {
		return cclientpayprice;
	}



	public void setCclientpayprice(String cclientpayprice) {
		this.cclientpayprice = cclientpayprice;
	}



	public int getIspayhthy() {
		return ispayhthy;
	}



	public void setIspayhthy(int ispayhthy) {
		this.ispayhthy = ispayhthy;
	}



	public String getPnrtxt() {
		return pnrtxt;
	}



	public void setPnrtxt(String pnrtxt) {
		this.pnrtxt = pnrtxt;
	}



	public String getPattxt() {
		return pattxt;
	}



	public void setPattxt(String pattxt) {
		this.pattxt = pattxt;
	}


	

}
