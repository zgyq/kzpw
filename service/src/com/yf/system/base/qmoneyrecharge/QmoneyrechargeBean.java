/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.qmoneyrecharge;

import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q币充值表
 */
public class QmoneyrechargeBean  implements
		java.io.Serializable {

	/**
	 * Q币充值表 表名
	 */
	public static final String TABLE = "T_QMONEYRECHARGE";

	/**
	 * ID 列名
	 */
	public static final String COL_id = "ID";

	/**
	 * 订单号 列名
	 */
	public static final String COL_ordernumber = "C_ORDERNUMBER";

	/**
	 * 充值Q号 列名
	 */
	public static final String COL_qqnumber = "C_QQNUMBER";

	/**
	 * 产品分销价
	 */
	public static final String COL_inprice = "C_INPRICE";
	/**
	 * 充值金额 列名
	 */
	public static final String COL_rechmoney = "C_RECHMONEY";

	/**
	 * 充值时间 列名
	 */
	public static final String COL_rechtime = "C_RECHTIME";

	/**
	 * 充值操作人 列名
	 */
	public static final String COL_rechuid = "C_RECHUID";

	/**
	 * 充值状态 列名
	 */
	public static final String COL_rechstate = "C_RECHSTATE";
	/**
	 * 产品id
	 */
	public static final String COL_cardid = "C_CARDID";

	/**
	 * 购买数量
	 */
	public static final String COL_buynum = "C_BUYNUM";

	public static final String COL_refordernumber = "C_REFORDERNUMBER";
	public static final String COL_rechagentid = "C_RECHAGENTID";
	/**
	 * 接受充值人 列名
	 */
	public static final String COL_rechtouid = "C_RECHTOUID";

	public int paymethod;
	
	private int paystate=-1;

	public static final String COL_paymethod = "C_PAYMETHOD";

	public static String getPayMethodByType(int method) {
		switch (method) {
		case 1:
			return "网上支付";
		case 2:
			return "虚拟账户支付";
		}
		return "";
	}

	public String getPaymethodtype() {
		return getPayMethodByType(this.paymethod);
	}

	public int getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(int paymethod) {
		this.paymethod = paymethod;
	}

	// ID
	private long id;

	// 订单号
	private String ordernumber;

	// 充值Q号
	private String qqnumber;

	private String rechuname;

	// 充值金额
	private Float rechmoney;
	// 产品分销价
	private Float inprice;

	// 充值时间
	private Timestamp rechtime;

	// 充值人部门id
	private long rechagentid;

	// 接受充值人 ID

	private long rechtouid;
	// 接受充值人 NAME

	private String rechtouname;

	// 充值操作人
	private long rechuid;

	// 充值状态
	private int rechstate;

	// 关联订单号：用于充值失败后多次充值
	private String refordernumber;

	private String cardid;

	private int buynum;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	/**
	 * getID
	 */
	public long getId() {
		return id;
	}

	/**
	 * setID
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
	 * get充值Q号
	 */
	public String getQqnumber() {
		return qqnumber;
	}

	/**
	 * set充值Q号
	 */
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}

	/**
	 * get充值金额
	 */
	public Float getRechmoney() {
		return rechmoney;
	}

	/**
	 * set充值金额
	 */
	public void setRechmoney(Float rechmoney) {
		this.rechmoney = rechmoney;
	}

	/**
	 * get充值时间
	 */
	public Timestamp getRechtime() {
		return rechtime;
	}

	/**
	 * set充值时间
	 */
	public void setRechtime(Timestamp rechtime) {
		this.rechtime = rechtime;
	}

	/**
	 * get充值操作人
	 */
	public long getRechuid() {
		return rechuid;
	}

	/**
	 * set充值操作人
	 */
	public void setRechuid(long rechuid) {
		this.rechuid = rechuid;
	}

	/**
	 * get充值状态
	 */
	public int getRechstate() {
		return rechstate;
	}

	/**
	 * get充值状态 0-10：为殴飞返回状态：0:充值中，1：充值成功。9 充值失败 11--99 为自定义状态 11：等待支付
	 */

	public String getStatestr() {

		return this.getMobileStateMap().get(this.rechstate);
	}

	public Map<Integer, String> getMobileStateMap() {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(0, "充值中");
		map.put(1, "充值成功");
		map.put(9, "充值失败");
		map.put(11, "等待支付");
		return map;

	}

	/**
	 * set充值状态
	 */
	public void setRechstate(int rechstate) {
		this.rechstate = rechstate;
	}

	public String toString() {

		return "[" + id + "|"

		+ ordernumber + "|"

		+ qqnumber + "|"

		+ rechmoney + "|"

		+ rechtime + "|"

		+ rechuid + "|"

		+ rechstate + "]";
	}

	public Float getInprice() {
		return inprice;
	}

	public void setInprice(Float inprice) {
		this.inprice = inprice;
	}

	public String getRechuname() {
		if (rechuname.equals("")) {
			rechuname = "网站散客";
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

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}
		
	
	
	
}
