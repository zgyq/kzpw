/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.miscellaneous;

import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 * 客户经理杂项列表
 */
public class MiscellaneousBean implements java.io.Serializable {

	/**
	 * 客户经理杂项列表 表名
	 */
	public static final String TABLE = "T_MISCELLANEOUS";

	/**
	 * ID 列名
	 */
	public static final String COL_id = "ID";

	/**
	 * 时间 列名
	 */
	public static final String COL_createtime = "C_CREATETIME";

	/**
	 * 操作人员 列名
	 */
	public static final String COL_createid = "C_CREATEID";

	/**
	 * 集团客户ID 列名
	 */
	public static final String COL_groupuserid = "C_GROUPUSERID";

	/**
	 * 集团部门 列名
	 */
	public static final String COL_department = "C_DEPARTMENT";

	/**
	 * 旅客姓名 列名
	 */
	public static final String COL_name = "C_NAME";
	/**
	 * 联系人ID 列名
	 */
	public static final String COL_customerid = "C_CUSTOMERID";

	/**
	 * 费用 列名
	 */
	public static final String COL_price = "C_PRICE";

	/**
	 * 备注 列名
	 */
	public static final String COL_description = "C_DESCRIPTION";

	/**
	 * 消费日期
	 */
	public static final String COL_spenddate = "C_SPENDDATE";

	/**
	 * 作废字段
	 * 
	 */
	public static final String COL_debt = "C_DEBT";

	/**
	 * 状态
	 */
	public static final String COL_state = "C_STATE";
	
	/**
	 * 已还
	 */
	public static final String COL_yihai="C_YIHAI";
	
	/**
	 * 还欠
	 */
	public static final String COL_haiqian="C_HAIQIAN";
	
	
	public static final String COL_repaytime="C_REPAYTIME";

	
	private Timestamp repaytime;
	
	// ID
	private long id;

	// 时间
	private Timestamp createtime;

	// 操作人员
	private Long createid;

	// 集团客户ID
	private Long groupuserid;

	// 集团部门
	private Long department;
	
	
	//联系人
	private Long customerid;

	// 旅客姓名
	private String name;

	// 费用
	private Double price;

	// 还欠
	// 作废字段
	private Double debt;

	// 备注
	private String description;

	// 消费日期

	private String spenddate;

	private Double yihai;

	private Double haiqian;

	// 状态
	private Long state;

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
	 * get时间
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}

	/**
	 * set时间
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	/**
	 * get操作人员
	 */
	public Long getCreateid() {
		return createid;
	}

	/**
	 * set操作人员
	 */
	public void setCreateid(Long createid) {
		this.createid = createid;
	}

	/**
	 * get集团客户ID
	 */
	public Long getGroupuserid() {
		return groupuserid;
	}

	/**
	 * set集团客户ID
	 */
	public void setGroupuserid(Long groupuserid) {
		this.groupuserid = groupuserid;
	}

	/**
	 * get集团部门
	 */
	public Long getDepartment() {
		return department;
	}

	/**
	 * set集团部门
	 */
	public void setDepartment(Long department) {
		this.department = department;
	}

	/**
	 * get旅客姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * set旅客姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get费用
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * set费用
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * get备注
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * set备注
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get消费日期
	 */
	public String getSpenddate() {
		return spenddate;
	}

	/**
	 * set消费日期
	 */
	public void setSpenddate(String spenddate) {
		this.spenddate = spenddate;
	}

	public String toString() {

		return "[" + id + "|"

		+ createtime + "|"

		+ createid + "|"

		+ groupuserid + "|"

		+ department + "|"

		+ name + "|"

		+ price + "|"

		+ spenddate + "|"

		+ state + "|"

		+ description + "]";
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	}

	public Double getYihai() {
		return yihai;
	}

	public void setYihai(Double yihai) {
		this.yihai = yihai;
	}

	public Double getHaiqian() {
		return haiqian;
	}

	public void setHaiqian(Double haiqian) {
		this.haiqian = haiqian;
	}

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public Timestamp getRepaytime() {
		return repaytime;
	}

	public void setRepaytime(Timestamp repaytime) {
		this.repaytime = repaytime;
	}

}
