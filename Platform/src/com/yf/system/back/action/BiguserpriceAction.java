/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.yf.system.back.server.Server;
import com.yf.system.base.biguser.Biguser;
import com.yf.system.base.biguserprice.Biguserprice;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.passengerrepayrc.Passengerrepayrc;
import com.yf.system.base.repay.Repay;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class BiguserpriceAction extends B2b2cbackAction {
	private List<Biguserprice> listBiguserprice;
	private List<Passenger> listPassenger;// 已出票
	private List<Passenger> otherlistPassenger;// 退废改签
	private List<Miscellaneous> listMiscellaneous;// 杂项费用
	private List<Orderinfo> listOrderinfo;
	private Biguserprice biguserprice = new Biguserprice();
	private Customeragent customeragent = new Customeragent();
	private List<Customeragent> listCustomeragent;
	private List<Department> listDepartment;
	private String treestr = "";
	

	private Timestamp today = new Timestamp(System.currentTimeMillis());

	private Biguser biguser;

	// 批量操作ID数组
	private int[] selectid;
	private String listdep = "";

	private long hkallprice;// 记录客户 所填还款金额

	private double blanceyue;// 记录所剩余额

	private long haveprofit;// 记录所还

	private float arrearage; // 欠款总额

	private int contains = 0;// 包含 不包含 下级部门

	// 批量操作选项
	private int opt;
	private double yu;
	// 开始时间和结束时间
	private String s_begintime;
	private String s_endtime;
	private double hai;
	private double yue;

	private String s_department;
	private String companyname;
	private String s_passenger;// 操作人员

	private String accountManager; // 客户经理

	private double pricecount;// 还款金额总计

	// search
	// private String s_name;
	private String forword;
	private String passid;
	private String bufenid;// 还款部分的那个ID
	private long agentid;
	private long ptype;
	private String username;// 联系人

	private long angentid;
	private int departmentid;
	private String twodepartment;
	private int s_state;
	private String orderid;
	private String departname;

	private String s_ordername;// 预订人

	private String s_passengername;// 乘机人

	private String flight_begintime;// 航班日期

	private String flight_endtime;
	private String s_ordernum;
	private String s_ticketnum;

	private int s_internal = -1;// 机票类型：国内，国际。

	public String getS_ordername() {
		return s_ordername;
	}

	public void setS_ordername(String s_ordername) {
		this.s_ordername = s_ordername;
	}

	public String getS_passengername() {
		return s_passengername;
	}

	public void setS_passengername(String s_passengername) {
		this.s_passengername = s_passengername;
	}

	public String getFlight_begintime() {
		return flight_begintime;
	}

	public void setFlight_begintime(String flight_begintime) {
		this.flight_begintime = flight_begintime;
	}

	public String getFlight_endtime() {
		return flight_endtime;
	}

	public void setFlight_endtime(String flight_endtime) {
		this.flight_endtime = flight_endtime;
	}

	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getAngentid() {
		return angentid;
	}

	public void setAngentid(long angentid) {
		this.angentid = angentid;
	}

	public int getS_state() {
		return s_state;
	}

	public void setS_state(int s_state) {
		this.s_state = s_state;
	}

	public BiguserpriceAction() {
		Calendar cal = Calendar.getInstance();
		// 将本月1号作为日期初始
		cal.set(cal.DATE, 1);
		// ben月1号减去一天，即得到上月最后一天
		cal.add(cal.DATE, -1);
		SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		s_endtime = df.format(cal.getTime());
		Calendar c = Calendar.getInstance();
		c.add(cal.MONTH, -1);
		c.set(c.DATE, 1);
		s_begintime = df.format(c.getTime());
	}

	/**
	 * 
	 * 列表查询大客户还款金额记录表
	 */
	public String execute() throws Exception {

		String menuwhere = " where 1=1 AND C_AGENTISENABLE=1 and C_AGENTCHECKSTATUS=1 AND "
				+ Customeragent.COL_userid + " =" + getLoginUserId();
		if (isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		listCustomeragent = Server.getInstance().getMemberService()
				.findAllCustomeragent(menuwhere, "", -1, 0);
		long[] longarry = new long[listCustomeragent.size()];
		int i = 0;
		for (Customeragent agent : listCustomeragent) {
			longarry[i] = agent.getId();
			i++;
		}
		String strwhere = "";
		String where = " where 1=1 ";// 系统管理员
		if (!isAdmin()) {// 非系统管理员 默认为客户经理
			strwhere = " AND " + Biguserprice.COL_angentid
					+ " IN ( SELECT ID FROM [T_CUSTOMERAGENT] WHERE C_USERID="
					+ getLoginUserId() + " )";
		}
		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			longarry = new long[1];
			longarry[0] = this.getLoginUser().getAgentid();
			strwhere = " AND " + Biguserprice.COL_angentid + "="
					+ getLoginUser().getAgentid();
		}
	//	this.getDepttreestr(3l, longarry, true);

		if (s_department != null && s_department.length() > 0) {// 部门
			if (s_department.indexOf("c") >= 0) {
				angentid = Long.valueOf(s_department.replace("c", ""));
				strwhere = " AND " + Biguserprice.COL_angentid + "=" + angentid;
				companyname = Server.getInstance().getMemberService()
						.findCustomeragent(angentid).getAgentcompanyname();
			} else {
				long deptid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));

				agentid = Long.valueOf(s_department.substring(s_department
						.indexOf("@") + 1));
				strwhere = " AND " + Biguserprice.COL_deptid + "=" + deptid;
				companyname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
			}

			where += strwhere;
			if (accountManager != null && accountManager.length() > 0) {// 客户经理
				where += " AND "
						+ Biguserprice.COL_angentid
						+ " IN(SELECT ID FROM [T_CUSTOMERAGENT] WHERE [C_USERID]"
						+ " IN (SELECT ID FROM [T_CUSTOMERUSER] WHERE [C_MEMBERNAME] LIKE '%"
						+ accountManager + "%') )";
			}

			if (s_passenger != null && s_passenger.length() > 0) {
				where += " AND "
						+ Biguserprice.COL_createuserid
						+ " IN (SELECT ID FROM [T_CUSTOMERUSER] WHERE [C_MEMBERNAME] LIKE '%"
						+ s_passenger + "%')";
			}
			String time = this.getCheckTime(s_begintime, s_endtime,
					Biguserprice.COL_createtime);
			if (time.length() > 0) {
				where += " AND (" + time + ")";
			}
			System.out.println(where);
			List list = Server.getInstance().getMemberService()
					.findAllBiguserpriceForPageinfo(where,
							" ORDER BY C_CREATETIME DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);

			listBiguserprice = list;
			if (pageinfo.getTotalrow() > 0 && listBiguserprice.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getMemberService()
						.findAllBiguserpriceForPageinfo(where,
								" ORDER BY C_CREATETIME DESC ", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listBiguserprice = list;
			}
			for (Biguserprice pric : listBiguserprice) {
				double price = 0.0;
				if (pric.getHkuanprice() != null) {
					price = pric.getHkuanprice();
				}

				pricecount += price;
			}
		}
		return SUCCESS;
	}

	/**
	 * 导出客户还款历史记录
	 * 
	 * @throws Exception
	 */
	public void expBiguserRepayRecordExcel() throws Exception {
		this.execute();
		String name = "大客户还款记录报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		String[] titles = { "大客户", "本次还款总额", "本次还款后欠款总额", "还款时间", "付款方式",
				"客户经理", "操作人员", "备注" };
		Map<Integer, List<Object>> valuemap = new HashMap<Integer, List<Object>>();
		int i = 0;
		for (Biguserprice biguserprice : listBiguserprice) {
			List<Object> valuelist = new ArrayList<Object>();
			valuelist.add(getangentname(biguserprice.getAngentid()));
			valuelist.add(biguserprice.getHkuanprice());
			valuelist.add(biguserprice.getDebt());
			valuelist.add(formatTimestamp(biguserprice.getCreatetime()));
			String rt = biguserprice.getRepaytype() == 1 ? "现金" : biguserprice
					.getRepaytype() == 2 ? "支票" : "银行汇款";
			valuelist.add(rt);
			valuelist.add(accountManagerName(biguserprice.getAngentid()));
			valuelist.add(getusername(biguserprice.getCreateuserid()));
			valuelist.add(converNull(biguserprice.getComment(), ""));
			valuemap.put(i, valuelist);
			i++;
		}
		WritableWorkbook book = Workbook.createWorkbook(response
				.getOutputStream());
		WritableSheet sheet = book.createSheet("sheet1", 0);
		Map<String, String> options = new HashMap<String, String>();
		options.put("大客户", companyname);
		options.put("客户经理", accountManager);
		options.put("操作人员", s_passenger);
		options.put("还款时间", s_begintime);
		options.put("", s_endtime);
		int line = this.addExcelOptions(sheet, 1, options, titles.length);
		this.reportExpExcel(sheet, "大客户还款记录", line, titles, valuemap);
		book.write();
		book.close();

	}

	private void getString(long id, long agid, long flag) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ agid, "ORDER BY ID", -1, 0);
		if (flag > 0) {

			treestr += "var sub_" + agid + " = new Ext.tree.TreeNode({ id:'"
					+ agid + "',  text:'" + getagentname_b2bback(agid) + "'});\n";

			treestr += "root.appendChild(sub_" + agid + ");\n";
		}
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "sub_" + agid + ".appendChild(sub_" + m.getId()
							+ ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId(), agid, -1);
			}
		}

	}

	private void getStringdep(long id, long angid) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ getLoginUser().getAgentid(), "ORDER BY ID",
						-1, 0);
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getStringdep(m.getId(), agentid);
			}
		}
	}

	private void getdep(long id) {
		listdep += "" + id;
		List<Department> listde = Server
				.getInstance()
				.getMemberService()
				.findAllDepartment(
						" where 1=1 and " + Department.COL_parentid + " =" + id,
						"", -1, 0);

		if (listde.size() > 0) {
			long deid = listde.get(0).getId();
			listdep += ",";
			getdep(deid);
		}

	}

	public String repay() throws Exception {
		ServletActionContext.getRequest().getSession().removeAttribute("mapid");
		ServletActionContext.getRequest().getSession().removeAttribute(
				"mapsave");
		ServletActionContext.getRequest().getSession().removeAttribute(
				"repayprice");
		ServletActionContext.getRequest().getSession().removeAttribute("pid");
		return this.repayment();
	}

	/**
	 * @return 大客户还款业务操作
	 * @throws Exception
	 */
	public String repayment() throws Exception {
		StringBuffer js = new StringBuffer("");
		String menuwhere = "";
		if (isAdmin() || this.getLoginUser().getType() == 1) {// admin 或平台员工
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		if (getLoginUserRoleNumber().contains(10038l)) {
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 and C_AGENTCHECKSTATUS=1  AND "
					+ Customeragent.COL_userid + " =" + getLoginUserId();// 客户经理
		}

		listCustomeragent = Server.getInstance().getMemberService()
				.findAllCustomeragent(menuwhere, "", -1, 0);
		long[] longarry = new long[listCustomeragent.size()];
		int i = 0;
		for (Customeragent agent : listCustomeragent) {
			longarry[i] = agent.getId();
			i++;
		}
		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			longarry = new long[1];
			longarry[0] = this.getLoginUser().getAgentid();
		}
		//this.getDepttreestr(3l, longarry, true);

		// 乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票 4=申请退票 5=申请废票 6=申请改签 7=退票失败 8=废票失败
		// 9=改签成功 10=改签失败 11已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失
		// 订单状态 1:等待支付;2 等待出票;3
		// 出票完成";4申请退票";5申请废票";6取消订单";7废票不成功";8审核失败";9废票退款成功";10 订单完成";11已经废票";
		// 12已经退票";13申请改签";14已经改签";15改签失败";16暂不能出票";17退票不成功";18退票退款成功";19问题订单";23申请升舱";24已换开";
		// 25升舱换开成功";
		// 26升舱失败";27待确认";28在途订单";29待收银";30申请换开";

		// COL_state1：已出，2：已废，3：已退，9：已改签
		// COL_hkstate 1:未还，2：已还，3：已还部分
		/*
		 * 订单费用列表
		 * 
		 * //乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=
		 * 
		 * //废票失败9=改签成功10=改签失败11=已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失
		 * 
		 * //败
		 * 
		 * 
		 */
		String thiswhere = "";
		String otherwhere = "";
		String mwhere = "";
		String where = " where " + Passenger.COL_state
				+ " NOT IN (0,2,3,9,11,12,16,17)  ";
		thiswhere += " AND " + Passenger.COL_hkstate + "!=2 ";
		if (this.s_passengername != null && s_passengername.trim().length() > 0) {
			thiswhere += " AND " + Passenger.COL_name + " LIKE '%"
					+ s_passengername + "%'";

		}
		if (isNotNullOrEpt(s_ticketnum)) {
			thiswhere += " AND " + Passenger.COL_ticketnum + " = '"
					+ s_ticketnum + "'";
		}
		thiswhere += " AND C_ORDERID IN (SELECT ID FROM T_ORDERINFO WHERE C_PAYMETHOD=5 AND ( C_FKMETHOD=8 OR C_FKMETHOD IS NULL ) ) ";
		String timewhere = this.getCheckTime(s_begintime, s_endtime,
				Passenger.COL_rttime);// 出票日期
		if (timewhere.length() > 0) {
			thiswhere += " AND (" + timewhere + ") ";
		}
		if (s_department != null && !s_department.trim().equals("")) {// 部门

			if (s_department.indexOf("c") >= 0) {
				agentid = Long.valueOf(s_department.substring(1));
				this.departname = Server.getInstance().getMemberService()
						.findCustomeragent(agentid).getAgentcompanyname();
				String deptlist = s_department.substring(1);
				if (this.contains == 1) {
					deptlist = super.getAllDeptIdByAgentId(agentid);
				}
//				thiswhere += " AND " + Passenger.COL_orderid + " in (select "
//						+ Orderinfo.COL_id + " from " + Orderinfo.TABLE
//						+ " where " + Orderinfo.COL_customeragentid + " IN("
//						+ deptlist + ")";

				mwhere += " AND " + Miscellaneous.COL_groupuserid + " IN ("
						+ agentid + ")";
			} else {
				agentid = Long.valueOf(s_department.substring(0, s_department
						.indexOf("@")));
				this.departname = Server.getInstance().getMemberService()
						.findDepartment(agentid).getName();
				String deptlist = String.valueOf(agentid);
				if (this.contains == 1) {
					deptlist = super.getSubDetpt(agentid);
				}
				thiswhere += " AND "
						+ Passenger.COL_orderid
						+ " IN (SELECT "
						+ Orderinfo.COL_id
						+ " From "
						+ Orderinfo.TABLE
						+ " WHERE "
						+ Orderinfo.COL_customeruserid
						+ ""
						+ " IN ( SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID IN("
						+ deptlist + ") ) ";

				mwhere += " AND " + Miscellaneous.COL_department + " IN ("
						+ agentid + ")";
			}
			if (username != null && username.length() > 0) {// 联系人
				thiswhere += " AND " + Orderinfo.COL_contactname + " LIKE '%"
						+ username + "%'";
				mwhere += " AND "
						+ Miscellaneous.COL_customerid
						+ "  IN ( SELECT ID FROM [T_CUSTOMERUSER] WHERE C_MEMBERNAME LIKE '%"
						+ username + "%' )";
			}
			if (isNotNullOrEpt(s_ordernum)) {// 订单号
				thiswhere += " AND " + Orderinfo.COL_ordernumber + " LIKE '%"
						+ s_ordernum + "%'";
			}
			if (this.s_ordername != null && s_ordername.trim().length() > 0) {// 预订人
				thiswhere += " AND "
						+ Orderinfo.COL_saleagentid
						+ " IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ s_ordername + "%' )";
			}
			if (this.s_internal > -1) {// 类型
				thiswhere += " AND C_INTERNAL =" + s_internal;
			}
			String flightwhere = "";// 航班日期
			if (this.flight_begintime != null
					&& flight_begintime.trim().length() > 0) {
				flightwhere += " AND "
						+ Orderinfo.COL_id
						+ " IN ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE C_DEPARTTIME>='"
						+ flight_begintime + " 00:00:00'  ";
			}
			if (this.flight_endtime != null
					&& flight_endtime.trim().length() > 0) {
				if (flightwhere.length() > 0) {
					flightwhere += " AND C_ARRIVALTIME<='" + flight_endtime
							+ " 23:59:59' ";
				} else {
					flightwhere += " AND "
							+ Orderinfo.COL_id
							+ " IN ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE C_ARRIVALTIME<='"
							+ flight_endtime + " 23:59:59'  ";
				}

			}
			if (flightwhere.length() > 0) {
				flightwhere += ")";
				thiswhere += flightwhere;
			}
			thiswhere += ")";
			where += thiswhere;
			otherwhere += thiswhere;

			System.out.println("Biguserprice-repayment:" + where);
			List list = Server.getInstance().getAirService()
					.findAllPassengerForPageinfo(where, " ORDER BY ID ASC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listPassenger = list;
			if (pageinfo.getTotalrow() > 0 && listPassenger.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getAirService()
						.findAllPassengerForPageinfo(where,
								" ORDER BY " + Passenger.COL_hkstate, pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listPassenger = list;
			}
			for (Passenger passenger : listPassenger) {
				float titcketprice = converNull(passenger.getPrice(), 0f);// 票价
				float buildprice = converNull(passenger.getAirportfee(), 0f);// 机建费
				float oilprice = converNull(passenger.getFuelprice(), 0f);// 燃油费
				float safetyprice = converNull(passenger.getAnjianfee(), 0f);// 安检费
				float otherprice = converNull(passenger.getOtherfee(), 0f);// 其他费用
				float insure = passenger.getInsurprice();
				float lastprice = titcketprice + buildprice + oilprice + insure
						+ safetyprice + otherprice;

				// passenger.setPrice(lastprice);
				if (passenger.getYihai() == null) {
					passenger.setYihai(0f);
				}
				if (passenger.getHkstate() == 2
						&& passenger.getHaiqian() == null) {// 已还
					passenger.setHaiqian(0f);
				} else {
					passenger.setHaiqian(lastprice - passenger.getYihai());
				}

				// arrearage += passenger.getHaiqian();
			}
			// ------------
			/*
			 * 退废改签列表
			 */
			this.otherPassenger(otherwhere);
			/*
			 * 杂项费列表
			 */
			this.miscellList(mwhere);
			// 以下 代码 用于选中按钮
			String repayname = ServletActionContext.getRequest().getParameter(
					"repayname");
			if (repayname == null) {
				this.toadd();// 计算还款余额
			}

			js
					.append("<script type=\"text/javascript\">$(document).ready(function(){");
			if (repayname == null || repayname.equals("")) {
				js.append("feiyong(1);");
			} else if (repayname.trim().equals("other")) {
				js.append("feiyong(2);");
			} else {
				js.append("feiyong(3);");
			}
			js.append("});</script>");
			otherwhere = otherwhere.replace("'", "''");
			mwhere = mwhere.replace("'", "''");
			List<Map> pricemap = Server.getInstance().getSystemService()
					.findMapResultByProcedure(
							"[dbo].[sp_getqkbyagent] @WHERE = N' " + otherwhere
									+ " ',@ZWHERE = N' " + mwhere + "'");
			for (Map m : pricemap) {
				this.arrearage = Float.valueOf(m.get("qkprice").toString());
			}

		}
		ServletActionContext.getRequest().setAttribute("repayjs", js);
		return LIST;
	}

	public String otherPassenger(String otherwhere) {
		String where = "";
		where = " where "
				+ Passenger.COL_state
				+ " IN (2,3,9,16,17) AND C_ORDERID IN (SELECT ID FROM T_ORDERINFO WHERE C_PAYMETHOD=5 AND C_FKMETHOD=8 OR C_FKMETHOD IS NULL )";
		if (otherwhere != null && !otherwhere.trim().equals("")) {
			where += " " + otherwhere;
		}
		List list = Server.getInstance().getAirService()
				.findAllPassengerForPageinfo(where, " ORDER BY ID ASC",
						pageother);
		pageother = (PageInfo) list.remove(0);
		otherlistPassenger = list;
		if (pageother.getTotalrow() > 0 && otherlistPassenger.size() == 0) {
			pageother.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllPassengerForPageinfo(where,
							" ORDER BY " + Passenger.COL_hkstate, pageother);
			pageother = (PageInfo) list.remove(0);
			otherlistPassenger = list;
		}

		for (Passenger passenger : otherlistPassenger) {
			if (passenger.getYihai() == null) {
				passenger.setYihai(0f);
			}
			float titcketprice = converNull(passenger.getPrice(), 0f);// 票价
			float buildprice = converNull(passenger.getAirportfee(), 0f);// 机建费
			float oilprice = converNull(passenger.getFuelprice(), 0f);// 燃油费
			float safetyprice = converNull(passenger.getAnjianfee(), 0f);// 安检费
			float otherprice = converNull(passenger.getOtherfee(), 0f);// 其他费用
			float insure = passenger.getInsurprice();
			float lastprice = titcketprice + buildprice + oilprice + insure
					+ safetyprice + otherprice;
			// passenger.setPrice(lastprice);
			if (passenger.getState() == 9) {// 改签成功 日期改签
				passenger.setHaiqian(lastprice + passenger.getTuifee()
						- passenger.getYihai());
			} else {// 已退票呢
				passenger.setHaiqian(passenger.getTuifee() + insure
						- passenger.getYihai());
			}
			// arrearage += passenger.getHaiqian();

		}

		return "";
	}

	public String miscellList(String mwhere) {
		String where = "";
		where = " where 1=1  and " + Miscellaneous.COL_state + " in (1,3) ";

		where += " " + mwhere;
		List list = Server.getInstance().getMemberService()
				.findAllMiscellaneousForPageinfo(where, " ORDER BY ID DESC",
						pagezafei);
		pagezafei = (PageInfo) list.remove(0);
		listMiscellaneous = list;
		if (pagezafei.getTotalrow() > 0 && listMiscellaneous.size() == 0) {
			pagezafei.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllMiscellaneousForPageinfo(where, " ORDER BY ID ASC",
							pagezafei);
			pagezafei = (PageInfo) list.remove(0);
			listMiscellaneous = list;
		}
		for (Miscellaneous mis : listMiscellaneous) {
			if (mis.getYihai() == null) {
				mis.setYihai(0.0);
			}
			mis.setHaiqian((mis.getPrice() - mis.getYihai()));
			// arrearage += mis.getHaiqian();
		}
		return "";
	}

	public String getSegmentInfo(long orderid, String methoeName)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		List<Segmentinfo> segments = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0);
		Method segMethod = Segmentinfo.class.getMethod(methoeName, null);
		if (segments != null && segments.size() > 0) {
			Segmentinfo segmentinfo = segments.get(0);
			return segMethod.invoke(segmentinfo, null).toString();

		}
		return "";

	}

	private Double getDebt(long gentid) {
		// 乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=

		// 废票失败9=改签成功10=改签失败11=已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失

		// 败
		String where = "where " + Passenger.COL_state
				+ " IN (1,2,3,4,5,6,7,8,9,10,13,14,15,16,17) AND "
				+ Passenger.COL_orderid + " in (SELECT " + Orderinfo.COL_id
				+ " from " + Orderinfo.TABLE + " where "
				+ Orderinfo.COL_buyagentid + " =" + gentid + ")";
		List<Passenger> passlist = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		float zongfei = 0f;
		for (Passenger passenger : passlist) {
			if (passenger.getYihai() == null)
				passenger.setYihai(0f);
			int state = passenger.getState();
			if ((state == 1 || state == 4 || state == 5 || state == 6
					|| state == 7 || state == 8 || state == 10 || state == 13
					|| state == 14 || state == 15)
					&& passenger.getHkstate() != 2) {// 已出票 ！=已还
				float titcketprice = converNull(passenger.getPrice(), 0f);// 票价
				float buildprice = converNull(passenger.getAirportfee(), 0f);// 机建费
				float oilprice = converNull(passenger.getFuelprice(), 0f);// 燃油费
				float insure =passenger.getInsurprice();
				float lastprice = (titcketprice + buildprice + oilprice + insure)
						- passenger.getYihai();

				zongfei += lastprice;
			}
			if ((passenger.getState() == 2 || passenger.getState() == 3)
					&& passenger.getHkstate() != 2) {
				float insure = passenger.getInsurprice();
				zongfei += passenger.getTuifee() + insure
						- passenger.getYihai();

			}
			if (passenger.getState() == 9 && passenger.getHkstate() != 2) {
				float titcketprice = converNull(passenger.getPrice(), 0f);// 票价
				float buildprice = converNull(passenger.getAirportfee(), 0f);// 机建费
				float oilprice = converNull(passenger.getFuelprice(), 0f);// 燃油费
				float insure = passenger.getInsurprice();
				float lastprice = (titcketprice + buildprice + oilprice + insure)
						- passenger.getYihai();
				zongfei += lastprice + passenger.getTuifee()
						- passenger.getYihai();
			}

		}

		where = " where 1=1  and " + Miscellaneous.COL_state + " in (1,3) ";
		where += " and " + Miscellaneous.COL_groupuserid + " =" + gentid;
		List<Miscellaneous> misces = Server.getInstance().getMemberService()
				.findAllMiscellaneous(where, "", -1, 0);
		for (Miscellaneous ms : misces) {
			if (ms.getState() == 1) {
				zongfei += ms.getPrice();
			}
			if (ms.getState() == 3) {
				zongfei += ms.getPrice() - ms.getYihai();
			}
		}
		return Double.valueOf(zongfei);
	}

	/**
	 * 转向到大客户还款金额记录表添加页面
	 */
	public String toadd() throws Exception {
		// getStringdep(-1,agentid);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * if(s_begintime==null||s_begintime.trim().length()==0) {
		 * s_begintime=dateFormat.format(new
		 * Timestamp(System.currentTimeMillis()).getTime()); }
		 * if(s_endtime==null||s_endtime.trim().length()==0) {
		 * s_endtime=dateFormat.format(new
		 * Timestamp(System.currentTimeMillis()).getTime());; }
		 */

		customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(agentid);

		List<Biguser> listbig = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ agentid, "", -1, 0);

		if (listbig.size() > 0) {
			if (listbig.get(0).getYeprice() == null) {
				yue = 0.00;
			} else {
				yue = listbig.get(0).getYeprice();
			}
		}
		this.blanceyue = yue;
		// agentid=46l;
		/*
		 * where += "where "+ Passenger.COL_state+" IN (1,2,3) AND
		 * "+Passenger.COL_orderid+" in (select "+Orderinfo.COL_id+" from
		 * "+Orderinfo.TABLE+" where "+Orderinfo.COL_buyagentid+" ="+agentid+")
		 * and ("+Passenger.COL_hkstate+" !=2 or "+Passenger.COL_hkstate+" is
		 * null )";
		 * 
		 * if(username!=null && username.trim().length()!=0){ where += " and
		 * "+Passenger.COL_name +" like '%" + username.trim()+"%'"; } if
		 * (s_begintime!=null && s_begintime.trim().length()!=0) {
		 * 
		 * where += " and "+Passenger.COL_rttime+ ">='"+s_begintime+" 00:00:00' "; }
		 * if (s_endtime!=null && s_endtime.trim().length()!=0) {
		 * 
		 * where += " and "+Passenger.COL_rttime+"<='"+s_endtime+" 23:59:59' "; }
		 * if(s_state>0){ where += " and "+Passenger.COL_hkstate+" ="+s_state; }
		 * if(departmentid !=0){ Department department =
		 * Server.getInstance().getMemberService().findDepartment(departmentid);
		 * getdep(department.getId());//递归查询部门 where += " and
		 * "+Passenger.COL_orderid+" in ( select "+Orderinfo.COL_id+" from
		 * "+Orderinfo.TABLE+" where "+Orderinfo.COL_customeruserid+" in (
		 * select "+Customeruser.COL_id+" from "+Customeruser.TABLE+" where
		 * "+Customeruser.COL_deptid+" in("+listdep+")))"; }
		 * System.out.println("where=="+where);
		 * 
		 * //if (s_name!=null && s_name.trim().length()!=0) {
		 * 
		 * //where += " and " + Passenger.COL_name +" like '%" +
		 * s_name.trim()+"%'"; //}
		 * 
		 * List list =
		 * Server.getInstance().getAirService().findAllPassengerForPageinfo(where,"
		 * ORDER BY ID DESC",pageinfo); pageinfo = (PageInfo)list.remove(0);
		 * listPassenger = list; if(pageinfo.getTotalrow()>0 &&
		 * listPassenger.size()==0){ pageinfo.setPagenum(1); list =
		 * Server.getInstance().getAirService().findAllPassengerForPageinfo(where,"
		 * ORDER BY ID DESC",pageinfo); pageinfo = (PageInfo)list.remove(0);
		 * listPassenger = list; } for(Passenger passenger:listPassenger){ float
		 * titcketprice= passenger.getPrice();//票价 float
		 * buildprice=passenger.getAirportfee();//机建费 float
		 * oilprice=passenger.getFuelprice();//燃油费 float
		 * insure=passenger.getInsurance()*20f; float
		 * lastprice=titcketprice+buildprice+oilprice+insure;
		 * passenger.setPrice(lastprice); if( passenger.getYihai()==null)
		 * passenger.setYihai(0f);
		 * passenger.setHaiqian(lastprice-passenger.getYihai()); }
		 */
		return LIST;
	}

	/**
	 * 转向到大客户退费列表
	 */
	public String totuifei() throws Exception {
		// getStringdep(-1,agentid);
		// SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * if(s_begintime==null||s_begintime.trim().length()==0) {
		 * s_begintime=dateFormat.format(new
		 * Timestamp(System.currentTimeMillis()).getTime()); }
		 * if(s_endtime==null||s_endtime.trim().length()==0) {
		 * s_endtime=dateFormat.format(new
		 * Timestamp(System.currentTimeMillis()).getTime());; }
		 */

		customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(agentid);
		biggetString(-1, agentid);
		String where = " ";
		List<Biguser> listbig = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ agentid, "", -1, 0);

		if (listbig.size() > 0) {
			if (listbig.get(0).getYeprice() == null) {
				yue = 0.00;
			} else {
				yue = listbig.get(0).getYeprice();
			}
		}
		agentid = 46l;
		where += "where " + Passenger.COL_orderid + " in (select "
				+ Orderinfo.COL_id + " from " + Orderinfo.TABLE + " where "
				+ Orderinfo.COL_customeruserid + " in (select "
				+ Customeruser.COL_id + " from " + Customeruser.TABLE
				+ " where " + Customeruser.COL_agentid + " =" + agentid
				+ ")) and (" + Passenger.COL_hkstate + " !=2 or "
				+ Passenger.COL_hkstate + " is null )";

		where += " and (" + Passenger.COL_state + " =2 or "
				+ Passenger.COL_state + " =3 or " + Passenger.COL_state
				+ " =9)";

		if (username != null && username.trim().length() != 0) {
			where += " and " + Passenger.COL_name + " like '%"
					+ username.trim() + "%'";
		}
		if (s_begintime != null && s_begintime.trim().length() != 0) {

			where += " and " + Passenger.COL_rttime + ">='" + s_begintime
					+ " 00:00:00' ";
		}
		if (s_endtime != null && s_endtime.trim().length() != 0) {

			where += " and " + Passenger.COL_rttime + "<='" + s_endtime
					+ " 23:59:59' ";
		}
		/*
		 * if(s_state>0){ where += " and "+Passenger.COL_hkstate+" ="+s_state; }
		 */
		if (departmentid != 0) {
			Department department = Server.getInstance().getMemberService()
					.findDepartment(departmentid);
			getdep(department.getId());// 递归查询部门
			where += " and " + Passenger.COL_orderid + " in ( select "
					+ Orderinfo.COL_id + " from " + Orderinfo.TABLE + " where "
					+ Orderinfo.COL_customeruserid + " in ( select "
					+ Customeruser.COL_id + " from " + Customeruser.TABLE
					+ " where " + Customeruser.COL_deptid + " in(" + listdep
					+ ")))";
		}
		// System.out.println("where==" + where);

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Passenger.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		List list = Server.getInstance().getAirService()
				.findAllPassengerForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listPassenger = list;
		if (pageinfo.getTotalrow() > 0 && listPassenger.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllPassengerForPageinfo(where, " ORDER BY ID DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listPassenger = list;
		}
		// tomyorder(agentid);
		return "tuifeilist";
	}

	/**
	 * 转向到大客户杂项页面
	 */
	public String tozafei() throws Exception {
		// getStringdep(-1,agentid);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * if(s_begintime==null||s_begintime.trim().length()==0) {
		 * s_begintime=dateFormat.format(new
		 * Timestamp(System.currentTimeMillis()).getTime()); }
		 * if(s_endtime==null||s_endtime.trim().length()==0) {
		 * s_endtime=dateFormat.format(new
		 * Timestamp(System.currentTimeMillis()).getTime());; }
		 */

		customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(agentid);
		biggetString(-1, agentid);
		String where = " where 1=1  and " + Miscellaneous.COL_state + " =1";
		List<Biguser> listbig = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ agentid, "", -1, 0);

		if (listbig.size() > 0) {
			if (listbig.get(0).getYeprice() == null) {
				yue = 0.00;
			} else {
				yue = listbig.get(0).getYeprice();
			}
		}
		// agentid=46l;

		where += " and " + Miscellaneous.COL_groupuserid + " =" + agentid;

		if (username != null && username.trim().length() != 0) {
			where += " and " + Miscellaneous.COL_name + " like '%"
					+ username.trim() + "%'";
		}
		if (s_begintime != null && s_begintime.trim().length() != 0) {

			where += " and " + Miscellaneous.COL_createtime + ">='"
					+ s_begintime + " 00:00:00' ";
		}
		if (s_endtime != null && s_endtime.trim().length() != 0) {

			where += " and " + Miscellaneous.COL_createtime + "<='" + s_endtime
					+ " 23:59:59' ";
		}
		/*
		 * if(s_state>0){ where += " and "+Passenger.COL_hkstate+" ="+s_state; }
		 */
		if (departmentid != 0) {
			Department department = Server.getInstance().getMemberService()
					.findDepartment(departmentid);
			getdep(department.getId());// 递归查询部门
			// where += " and "+Passenger.COL_orderid+" in ( select
			// "+Orderinfo.COL_id+" from "+Orderinfo.TABLE+" where
			// "+Orderinfo.COL_customeruserid+" in ( select
			// "+Customeruser.COL_id+" from "+Customeruser.TABLE+" where
			// "+Customeruser.COL_deptid+" in("+listdep+")))";
			where += " and " + Miscellaneous.COL_department + " in(" + listdep
					+ ")";
		}
		System.out.println("where==" + where);

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Passenger.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		List list = Server.getInstance().getMemberService()
				.findAllMiscellaneousForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listMiscellaneous = list;
		if (pageinfo.getTotalrow() > 0 && listMiscellaneous.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllMiscellaneousForPageinfo(where,
							" ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listMiscellaneous = list;
		}
		// tomyorder(agentid);
		return "tozafei";
	}

	/**
	 * 转向到大客户还款金额记录表修改页面
	 */
	public String toedit() throws Exception {
		biguserprice = Server.getInstance().getMemberService()
				.findBiguserprice(biguserprice.getId());
		return EDIT;
	}

	/**
	 * 转向到大客户还款金额记录表审核页面
	 */
	public String tocheck() throws Exception {
		biguserprice = Server.getInstance().getMemberService()
				.findBiguserprice(biguserprice.getId());
		return CHECK;

	}

	HttpSession session = null;

	/**
	 * 保存勾选的PassengerId
	 */
	public void ajaxSaveCheckedPassenger() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (session == null) {
			session = request.getSession();
		}
		String passengerid = request.getParameter("passengerid");
		String isSave = request.getParameter("isSave");
		Map<Object, Object> mapid = new HashMap<Object, Object>();
		Map<Object, Object> mapsave = new HashMap<Object, Object>();
		Object obj = session.getAttribute("mapid");
		Object objsave = session.getAttribute("mapsave");
		if (obj != null) {
			mapid = (Map) obj;
		}
		if (objsave != null) {
			mapsave = (Map) objsave;
		}
		int id = 0;
		double price = 0;
		if (passengerid.indexOf("bz") >= 0) {
			id = Integer.valueOf(passengerid.substring(2, passengerid
					.indexOf("@")));
			price = Double.valueOf(passengerid.substring(passengerid
					.indexOf("@") + 1));
			if (isSave != null) {
				mapid.put(id, id);
				mapsave.put("bz" + id, price);
			} else {
				mapsave.remove("bz" + id);
				mapid.remove(id);
			}
			session.setAttribute("pid", id);
			session.setAttribute("repayprice", price);

		} else if (passengerid.indexOf("b") >= 0) {
			id = Integer.valueOf(passengerid.substring(1, passengerid
					.indexOf("@")));
			price = Double.valueOf(passengerid.substring(passengerid
					.indexOf("@") + 1));
			if (isSave != null) {
				mapsave.put("b" + id, price);
				mapid.put(id, id);
			} else {
				mapsave.remove("b" + id);
				mapid.remove(id);
			}
			session.setAttribute("pid", id);
			session.setAttribute("repayprice", price);
		} else if (passengerid.indexOf("z") >= 0) {
			id = Integer.valueOf(passengerid.substring(1, passengerid
					.indexOf("@")));
			price = Double.valueOf(passengerid.substring(passengerid
					.indexOf("@") + 1));
			if (isSave != null) {
				mapsave.put("z" + id, price);
				mapid.put(id, id);
			} else {
				mapsave.remove("z" + id);
				mapid.remove(id);
			}
			session.setAttribute("pid", id);
			session.setAttribute("repayprice", price);
		} else {
			id = Integer.valueOf(passengerid.substring(0, passengerid
					.indexOf("@")));
			price = Double.valueOf(passengerid.substring(passengerid
					.indexOf("@") + 1));
			if (isSave != null) {
				mapsave.put(id, "");
				mapid.put(id, id);
			} else {
				mapsave.remove(id);
				mapid.remove(id);
			}
		}
		session.setAttribute("mapid", mapid);
		session.setAttribute("mapsave", mapsave);

	}

	public boolean havechecked(int id) {
		if (session == null) {
			session = ServletActionContext.getRequest().getSession();
		}
		if (session.getAttribute("mapid") != null) {
			Map mapid = (Map) session.getAttribute("mapid");
			if (mapid.get(id) != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String haikuan() throws Exception {
		Map mapsave = (Map) ServletActionContext.getRequest().getSession()
				.getAttribute("mapsave");
		if (mapsave != null && mapsave.size() > 0) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			Iterator iterator = mapsave.entrySet().iterator();
			String pid1 = "0";
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String orderid = entry.getKey().toString();
				Double repayprice = 0.0;
				int id = 0;
				if (orderid.indexOf("bz") >= 0) {// 处理杂费部分还款
					id = Integer.valueOf(orderid.substring(2));
					double price = Double.valueOf(entry.getValue().toString());
					Miscellaneous mis = Server.getInstance().getMemberService()
							.findMiscellaneous(id);
					mis.setState(3l);
					if (mis.getYihai() == null)
						mis.setYihai(0.0);
					mis.setYihai(price + mis.getYihai());
					mis.setHaiqian((mis.getPrice() - mis.getYihai()));
					mis.setRepaytime(time);
					Server.getInstance().getMemberService()
							.updateMiscellaneousIgnoreNull(mis);
				} else if (orderid.indexOf("z") >= 0) {// 处理杂费
					id = Integer.valueOf(orderid.substring(1));
					Miscellaneous mis = Server.getInstance().getMemberService()
							.findMiscellaneous(id);
					mis.setState(2l);
					mis.setRepaytime(time);
					mis.setYihai(mis.getPrice());
					mis.setHaiqian(0.0);
					Server.getInstance().getMemberService()
							.updateMiscellaneousIgnoreNull(mis);
					repayprice = Double.valueOf(mis.getPrice());
				} else if (orderid.indexOf("b") >= 0) {// 处理订单(退票，废票，改签)部分还款
					id = Integer.valueOf(orderid.substring(1));
					Passenger passenger = Server.getInstance().getAirService()
							.findPassenger(id);
					float price = Float.valueOf(entry.getValue().toString());
					float titcketprice = passenger.getPrice();// 票价
					float buildprice = passenger.getAirportfee();// 机建费
					float oilprice = passenger.getFuelprice();// 燃油费
					float insurfee=passenger.getInsurprice();
					float lastprice = titcketprice + buildprice + oilprice+insurfee;
					
					passenger.setHkmethod(ptype);
					passenger.setRepaytime(time);
					passenger.setHkstate(3l);
					if (passenger.getYihai() == null)
						passenger.setYihai(0f);
					int state = passenger.getState();
					passenger.setYihai(price + passenger.getYihai());
					if (state == 2 || state == 3 || state == 9) {
						if (state == 9) {
							passenger.setHaiqian(lastprice
									+ passenger.getTuifee()
									- passenger.getYihai());
						} else {// 退废
							passenger.setHaiqian(passenger.getTuifee()
									+ insurfee - passenger.getYihai());
						}
					} else {
						passenger.setHaiqian(lastprice - passenger.getYihai());
					}
					Passengerrepayrc rc = new Passengerrepayrc();
					rc.setPassenger(passenger.getId());
					rc.setHkmoney(passenger.getYihai());
					rc.setHkuserid(this.getLoginUserId());
					rc.setHkdatetime(time);
					Server.getInstance().getAirService()
							.createPassengerrepayrc(rc);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(passenger);
				} else { // 处理已出票订单
					id = Integer.valueOf(orderid);
					pid1 += "," + id;
					/*
					 * Passenger passenger =
					 * Server.getInstance().getAirService() .findPassenger(id);
					 * passenger.setRepaytime(time); float titcketprice =
					 * converNull(passenger.getPrice(), 0f);// 票价 float
					 * buildprice = converNull(passenger.getAirportfee(), 0f);//
					 * 机建费 float oilprice = converNull(passenger.getFuelprice(),
					 * 0f);// 燃油费 float lastprice = titcketprice + buildprice +
					 * oilprice; Long insure = passenger.getInsurance();// 保险id
					 * float insurfee=0f;//保险费 if (insure != null) {
					 * Insuranceinfo insurance = Server.getInstance()
					 * .getMemberService().findInsuranceinfo(insure); if
					 * (insurance != null) { lastprice +=insurfee=
					 * Float.valueOf(insurance .getInsurancefee()); } } int
					 * state = passenger.getState(); if (state == 2 || state ==
					 * 3 || state == 9) { if (state == 9) {
					 * passenger.setYihai(lastprice +
					 * converNull(passenger.getTuifee(), 0f));
					 *  } else { passenger.setYihai(converNull(
					 * passenger.getTuifee(), 0f)+insurfee); pid2+=","+id; } }
					 * else { pid3+=","+id; passenger.setYihai(lastprice); }
					 * passenger.setHaiqian(0f); passenger.setHkstate(2l);
					 * Server.getInstance().getAirService()
					 * .updatePassengerIgnoreNull(passenger);
					 * 
					 * repayprice = Double.valueOf(passenger.getPrice());
					 */
					// passid = passenger.getId();
				}
			}
			// 改签票 还款
			String update1 = "UPDATE view_biguserqkhz SET C_HKMETHOD="
					+ ptype
					+ " ,C_HKSTATE=2 ,C_HAIQIAN=0,C_YIHAI=(ISNULL(C_PRICE,0) +ISNULL(C_AIRPORTFEE,0)+ISNULL(C_FUELPRICE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0)+ISNULL(C_INSURANCEFEE,0)+ISNULL(C_TUIFEE,0)) WHERE ID IN("
					+ pid1 + ") AND C_STATE=9  ";
			Server.getInstance().getSystemService().findMapResultBySql(update1,
					null);
			// 退废票还款
			String update2 = "UPDATE view_biguserqkhz SET C_HKMETHOD="
					+ ptype
					+ " , C_HKSTATE=2 ,C_HAIQIAN=0,C_YIHAI=(ISNULL(C_TUIFEE,0)+ISNULL(C_INSURANCEFEE,0)) WHERE ID IN("
					+ pid1 + ") AND C_STATE IN(2,3,16,17)";
			Server.getInstance().getSystemService().findMapResultBySql(update2,
					null);
			// 正常票还款
			String update3 = "UPDATE view_biguserqkhz SET C_HKMETHOD="
					+ ptype
					+ " , C_HKSTATE=2 ,C_HAIQIAN=0,C_YIHAI=(ISNULL(C_PRICE,0) +ISNULL(C_AIRPORTFEE,0)+ISNULL(C_FUELPRICE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0)+ISNULL(C_INSURANCEFEE,0)) WHERE ID IN("
					+ pid1 + ") AND C_STATE NOT IN (2,3,9,16,17)";
			Server.getInstance().getSystemService().findMapResultBySql(update3,
					null);

			Biguserprice biguserprice = new Biguserprice();
			biguserprice
					.setCreatetime(new Timestamp(System.currentTimeMillis()));
			biguserprice.setCreateuserid(getLoginUserId());
			if (s_department != null && s_department.trim().length() > 0) {
				if (s_department.indexOf("c") >= 0) {
					agentid = Long.valueOf(s_department.substring(1));
					biguserprice.setAngentid(agentid);
				} else {
					long deptid = Long.valueOf(s_department.substring(0,
							s_department.indexOf("@")));
					agentid = Long.valueOf(s_department.substring(s_department
							.indexOf("@") + 1));
					biguserprice.setAngentid(agentid);
					biguserprice.setDeptid(deptid);

				}
			}
			String allprice = ServletActionContext.getRequest().getParameter(
					"allprice");
			String hqpricestr = ServletActionContext.getRequest().getParameter(
					"allhqprice");
			double hqprice = Double.valueOf(hqpricestr);
			double thisprice = Double.valueOf(allprice);
			biguserprice.setHkuanprice(thisprice);
			biguserprice.setDebt(hqprice - thisprice);
			biguserprice.setRepaytype(ptype);
			Biguserprice bprice = Server.getInstance().getMemberService()
					.createBiguserprice(biguserprice);
			long uid = this.getLoginUserId();
			String sql = "INSERT INTO  T_PASSENGERREPAYRC(C_BIGPRICEID,C_PASSENGER,C_HKUSERID," +
					"C_HKMONEY,C_HKDATETIME) SELECT "+bprice.getId()+" ,ID,"
					+ uid
					+ ",C_YIHAI,'"
					+ time
					+ "' FROM view_pas_order_seng WHERE ID IN (" + pid1 + ")";
			Server.getInstance().getSystemService().findMapResultBySql(sql,
					null);

			List<Biguser> bigusers = Server.getInstance().getMemberService()
					.findAllBiguser(
							" WHERE " + Biguser.COL_agentid + " =" + agentid,
							"", -1, 0);
			Biguser biguser = new Biguser();
			if (bigusers.size() > 0) {
				biguser = bigusers.get(0);
			}
			String yue = ServletActionContext.getRequest().getParameter(
					"balance");
			biguser.setYeprice(Double.valueOf(yue));
			if (bigusers.size() > 0) {
				Server.getInstance().getMemberService()
						.updateBiguserIgnoreNull(biguser);
			} else {
				Server.getInstance().getMemberService().createBiguser(biguser);
			}
		}
		// 清空session;
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("mapid");
		session.removeAttribute("mapsave");
		session.removeAttribute("repayprice");
		session.removeAttribute("pid");
		return this.repay();
	}

	// 退费票还款操作
	public String tuifeihaikuan() throws Exception {
		// agentid=46002l;
		System.out.println("orderid==" + orderid);
		String[] order = orderid.split(",");
		biguserprice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		biguserprice.setCreateuserid(getLoginUserId());
		biguserprice.setAngentid(agentid);
		Server.getInstance().getMemberService()
				.createBiguserprice(biguserprice);

		// 在大客户关联表插入还款总金额开始
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ biguserprice.getAngentid(), "", -1, 0);
		long biguserid = list.get(0).getId();
		Biguser big = Server.getInstance().getMemberService().findBiguser(
				biguserid);
		if (big.getYeprice() == null) {
			big.setYeprice(0.00);
		}
		big.setYeprice(biguserprice.getHkuanprice() + big.getYeprice());
		Server.getInstance().getMemberService().updateBiguserIgnoreNull(big);

		if (order.length > 0) {

			if (yu > 0) {// 够还

				for (int a = 0; a < order.length; a++) {

					Double ye = Server.getInstance().getMemberService()
							.findBiguser(big.getId()).getYeprice();// 查询当前余额

					long paid = Long.parseLong(order[a].trim());
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);

					pa.setYihai(pa.getTuifee());
					pa.setHkstate(2l);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);

					// /
					Biguser bigu = Server.getInstance().getMemberService()
							.findBiguser(big.getId());

					bigu.setYeprice(ye - pa.getTuifee());
					bigu.setKyongprice(bigu.getKyongprice() + pa.getTuifee());
					Server.getInstance().getMemberService()
							.updateBiguserIgnoreNull(bigu);

					Repay repay = new Repay();
					repay.setAgentid(big.getAgentid());
					repay.setCreatetime(new Timestamp(System
							.currentTimeMillis()));
					repay.setHkuanprice(Double.parseDouble(pa.getYihai()
							.toString()));
					repay.setOrderid(pa.getOrderid());
					repay.setPassengerid(pa.getId());
					repay.setUpdateid(getLoginUserId());
					repay.setPricetype(ptype);
					repay.setComment("还退费票订单");
					Server.getInstance().getMemberService().createRepay(repay);

				}
			}

		}

		return "haikuan";
	}

	// 杂项费用还款操作
	public String zafeihaikuan() throws Exception {
		// agentid=46002l;
		System.out.println("orderid==" + orderid);
		String[] order = orderid.split(",");
		biguserprice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		biguserprice.setCreateuserid(getLoginUserId());
		biguserprice.setAngentid(agentid);
		Server.getInstance().getMemberService()
				.createBiguserprice(biguserprice);

		// 在大客户关联表插入还款总金额开始
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ biguserprice.getAngentid(), "", -1, 0);
		long biguserid = list.get(0).getId();
		Biguser big = Server.getInstance().getMemberService().findBiguser(
				biguserid);
		if (big.getYeprice() == null) {
			big.setYeprice(0.00);
		}
		big.setYeprice(biguserprice.getHkuanprice() + big.getYeprice());
		Server.getInstance().getMemberService().updateBiguserIgnoreNull(big);

		if (order.length > 0) {

			if (yu > 0) {// 够还

				for (int a = 0; a < order.length; a++) {

					Double ye = Server.getInstance().getMemberService()
							.findBiguser(big.getId()).getYeprice();// 查询当前余额

					long paid = Long.parseLong(order[a].trim());
					Miscellaneous miscellaneous = Server.getInstance()
							.getMemberService().findMiscellaneous(paid);

					miscellaneous.setState(2l);
					Server.getInstance().getMemberService()
							.updateMiscellaneousIgnoreNull(miscellaneous);

					// /
					Biguser bigu = Server.getInstance().getMemberService()
							.findBiguser(big.getId());

					bigu.setYeprice(ye - miscellaneous.getPrice());
					bigu.setKyongprice(bigu.getKyongprice()
							+ miscellaneous.getPrice());
					Server.getInstance().getMemberService()
							.updateBiguserIgnoreNull(bigu);

					Repay repay = new Repay();
					repay.setAgentid(big.getAgentid());
					repay.setCreatetime(new Timestamp(System
							.currentTimeMillis()));
					repay.setHkuanprice(Double.parseDouble(miscellaneous
							.getPrice().toString()));
					repay.setOrderid(miscellaneous.getId());
					repay.setPassengerid(miscellaneous.getId());
					repay.setUpdateid(getLoginUserId());
					repay.setPricetype(ptype);
					repay.setComment("杂项费用还款记录");
					Server.getInstance().getMemberService().createRepay(repay);

				}
			}

		}

		return "haikuan";
	}

	public String baoliu() throws Exception {// 保留以前的还款
		biguserprice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		biguserprice.setCreateuserid(getLoginUserId());
		Server.getInstance().getMemberService()
				.createBiguserprice(biguserprice);
		// 在大客户关联表插入还款总金额开始
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ biguserprice.getAngentid(), "", -1, 0);
		long biguserid = list.get(0).getId();
		Biguser big = Server.getInstance().getMemberService().findBiguser(
				biguserid);
		if (big.getYeprice() == null) {
			big.setYeprice(0.00);
		}
		big.setYeprice(biguserprice.getHkuanprice() + big.getYeprice());
		Server.getInstance().getMemberService().updateBiguserIgnoreNull(big);

		// 在大客户关联表插入还款总金额结束
		long angentid = biguserprice.getAngentid();
		// long angentid = 46;//目前测试默认为46 因为现在订单都是46得
		String where = "where (" + Passenger.COL_hkstate + " !=2 or "
				+ Passenger.COL_hkstate + " is null ) and "
				+ Passenger.COL_orderid + " in (select " + Orderinfo.COL_id
				+ " from " + Orderinfo.TABLE + " where "
				+ Orderinfo.COL_customeruserid + " in (select "
				+ Customeruser.COL_id + " from " + Customeruser.TABLE
				+ " where " + Customeruser.COL_agentid + " =" + angentid + "))";
		System.out.println("where==" + where);
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID ", -1, 0);
		Double zong = big.getYeprice();
		if (listPassenger.size() > 0) {
			for (int a = 0; a < listPassenger.size(); a++) {
				Double ye = Server.getInstance().getMemberService()
						.findBiguser(big.getId()).getYeprice();// 查询当前余额

				if (listPassenger.get(a).getHkstate() == null
						|| listPassenger.get(a).getHkstate() == 1) {// 未还款
					Passenger pa = listPassenger.get(a);
					if (ye > pa.getPrice()) {// 如果余金额大于票价就进行还款
						pa.setYihai(pa.getPrice());
						pa.setHkstate(2l);
						Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(pa);
						Repay repay = new Repay();
						repay.setAgentid(big.getAgentid());
						repay.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						repay.setHkuanprice(Double.parseDouble(pa.getYihai()
								.toString()));
						repay.setOrderid(pa.getOrderid());
						repay.setPassengerid(pa.getId());
						repay.setUpdateid(getLoginUserId());
						Server.getInstance().getMemberService().createRepay(
								repay);
						Biguser bigu = Server.getInstance().getMemberService()
								.findBiguser(big.getId());
						bigu.setYeprice(ye - pa.getPrice());
						bigu
								.setKyongprice(bigu.getKyongprice()
										+ pa.getPrice());
						Server.getInstance().getMemberService()
								.updateBiguserIgnoreNull(bigu);

					} else {// 金额余额小于票价
						pa.setYihai(Float.parseFloat(ye.toString()));
						Double qian = pa.getPrice() - ye;
						pa.setHaiqian(Float.parseFloat(qian.toString()));
						pa.setHkstate(3l);
						Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(pa);

						Repay repay = new Repay();
						repay.setAgentid(big.getAgentid());
						repay.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						repay.setHkuanprice(ye);
						repay.setOrderid(pa.getOrderid());
						repay.setPassengerid(pa.getId());
						repay.setUpdateid(getLoginUserId());
						Server.getInstance().getMemberService().createRepay(
								repay);

						Biguser bi = Server.getInstance().getMemberService()
								.findBiguser(big.getId());
						bi.setYeprice(0.00d);
						bi.setKyongprice(bi.getKyongprice() + ye);
						Server.getInstance().getMemberService()
								.updateBiguserIgnoreNull(bi);
						break;
					}
				} else {// 已还款一半..
					Passenger pa = listPassenger.get(a);
					if (ye > pa.getHaiqian()) {// 如果余金额大于还欠票价就进行还款
						Float qian = pa.getHaiqian();
						pa.setYihai(pa.getPrice());
						pa.setHaiqian(0.00f);
						pa.setHkstate(2l);
						Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(pa);

						Repay repay = new Repay();
						repay.setAgentid(big.getAgentid());
						repay.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						repay
								.setHkuanprice(Double.parseDouble(qian
										.toString()));
						repay.setOrderid(pa.getOrderid());
						repay.setPassengerid(pa.getId());
						repay.setUpdateid(getLoginUserId());
						Server.getInstance().getMemberService().createRepay(
								repay);

						Biguser bigu = Server.getInstance().getMemberService()
								.findBiguser(big.getId());
						bigu.setYeprice(ye - qian);
						bigu.setKyongprice(bigu.getKyongprice() + qian);

						Server.getInstance().getMemberService()
								.updateBiguserIgnoreNull(bigu);
					}
				}
			}
		}

		return CHECK;
	}

	/**
	 * 添加大客户还款金额记录表
	 */
	public String add() throws Exception {
		biguserprice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		biguserprice.setCreateuserid(getLoginUserId());
		Server.getInstance().getMemberService()
				.createBiguserprice(biguserprice);
		// 在大客户关联表插入还款总金额开始
		List<Biguser> list = Server.getInstance().getMemberService()
				.findAllBiguser(
						" where 1=1 and " + Biguser.COL_agentid + " ="
								+ biguserprice.getAngentid(), "", -1, 0);
		long biguserid = list.get(0).getId();
		Biguser big = Server.getInstance().getMemberService().findBiguser(
				biguserid);
		if (big.getYeprice() == null) {
			big.setYeprice(0.00);
		}
		big.setYeprice(biguserprice.getHkuanprice() + big.getYeprice());
		Server.getInstance().getMemberService().updateBiguserIgnoreNull(big);

		tomyorder(biguserprice.getAngentid());
		// forword ="customeragent!toprice.action";
		// forword ="biguserprice!tomyorder.action?agentid="+agentid;
		return LIST;
	}

	public void tomyorder(long agentid) throws Exception {// 选择大客户,查询还款订单列表
		// listDepartment =
		// Server.getInstance().getMemberService().findAllCustomeragent("where
		// 1=1 and "+Customeragent.COL_userid+" ="+getLoginUserId(), "", -1, 0);

		// listCustomeragent =
		// Server.getInstance().getMemberService().findAllCustomeragent("where
		// 1=1 and "+Customeragent.COL_userid+" ="+getLoginUserId(), "", -1, 0);

	}

	private void biggetString(long id, long agentid) {// 大客户部门
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ agentid, "ORDER BY ID", -1, 0);
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				biggetString(m.getId(), agentid);
			}
		}
	}

	/**
	 * 审核大客户还款金额记录表
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateBiguserpriceIgnoreNull(
				biguserprice);
		return LIST;
	}

	/**
	 * 编辑大客户还款金额记录表
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateBiguserpriceIgnoreNull(
				biguserprice);
		return LIST;
	}

	/**
	 * 删除大客户还款金额记录表
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteBiguserprice(
				biguserprice.getId());
		return LIST;
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {

			switch (opt) {
			case 1: // delete

				for (int i : selectid) {
					Server.getInstance().getMemberService().deleteBiguserprice(
							i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * @param agentid
	 * @return 获得大客户客户经理
	 */
	public String accountManagerName(long agentid) {
		return this.getusername(Server.getInstance().getMemberService()
				.findCustomeragent(agentid).getUserid());
	}

	/**
	 * @param orderid
	 * @return 获得订单联系人
	 */
	public String getlinkManName(long orderid) {
		return Server.getInstance().getAirService().findOrderinfo(orderid)
				.getContactname();
	}

	/**
	 * @param orderid
	 * @return 获得订单预订人
	 */
	public String getOrderName(long orderid) {
		return this.getusername(Server.getInstance().getAirService()
				.findOrderinfo(orderid).getSaleagentid());
	}

	/**
	 * @param orderid
	 * @return 根据订单号获得航程
	 */
	public String getFlight(long orderid) {
		List<Segmentinfo> segments = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0);
		if (segments.size() > 0) {
			Segmentinfo segment = segments.get(0);
			return getCitynameByAirport(segment.getStartairport()) + "-"
					+ getCitynameByAirport(segment.getEndairport());
		}
		return "";
	}

	/**
	 * @param orderid
	 * @return 根据订单号获得航程时间
	 */
	public String getFlighttime(long orderid) {
		List<Segmentinfo> segments = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0);
		if (segments.size() > 0) {
			Segmentinfo segment = segments.get(0);
			return formatTimestamptoMinute(segment.getDeparttime()).toString();
		}
		return "";
	}

	public Map<Integer, String> getHkmethodMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, getHkstateStr(1));
		map.put(2, getHkstateStr(2));
		map.put(3, getHkstateStr(3));
		map.put(4, getHkstateStr(4));
		map.put(5, getHkstateStr(5));
		map.put(6, getHkstateStr(6));

		return map;
	}

	public static String getHkstateStr(int state) {
		switch (state) {
		case 1:
			return "现金";
		case 2:
			return "支票";
		case 3:
			return "银行汇款";

		case 4:
			return "建行POS";
		case 5:
			return "银联POS";
		case 6:
			return "网上支付";
		}
		return "";
	}

	/**
	 * 返回大客户还款金额记录表对象
	 */

	public Object getModel() {
		return biguserprice;
	}

	public List<Biguserprice> getListBiguserprice() {
		return listBiguserprice;
	}

	public void setListBiguserprice(List<Biguserprice> listBiguserprice) {
		this.listBiguserprice = listBiguserprice;
	}

	public Biguserprice getBiguserprice() {
		return biguserprice;
	}

	public void setBiguserprice(Biguserprice biguserprice) {
		this.biguserprice = biguserprice;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}

	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public Customeragent getCustomeragent() {
		return customeragent;
	}

	public void setCustomeragent(Customeragent customeragent) {
		this.customeragent = customeragent;
	}

	public List<Passenger> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public List<Orderinfo> getListOrderinfo() {
		return listOrderinfo;
	}

	public void setListOrderinfo(List<Orderinfo> listOrderinfo) {
		this.listOrderinfo = listOrderinfo;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public double getYue() {
		return yue;
	}

	public void setYue(double yue) {
		this.yue = yue;
	}

	public double getYu() {
		return yu;
	}

	public void setYu(double yu) {
		this.yu = yu;
	}

	public double getHai() {
		return hai;
	}

	public void setHai(double hai) {
		this.hai = hai;
	}

	public String getPassid() {
		return passid;
	}

	public void setPassid(String passid) {
		this.passid = passid;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getBufenid() {
		return bufenid;
	}

	public void setBufenid(String bufenid) {
		this.bufenid = bufenid;
	}

	public String getS_begintime() {
		return s_begintime;
	}

	public void setS_begintime(String s_begintime) {
		this.s_begintime = s_begintime;
	}

	public String getS_endtime() {
		return s_endtime;
	}

	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}

	public String getListdep() {
		return listdep;
	}

	public void setListdep(String listdep) {
		this.listdep = listdep;
	}

	public List<Miscellaneous> getListMiscellaneous() {
		return listMiscellaneous;
	}

	public void setListMiscellaneous(List<Miscellaneous> listMiscellaneous) {
		this.listMiscellaneous = listMiscellaneous;
	}

	public long getPtype() {
		return ptype;
	}

	public void setPtype(long ptype) {
		this.ptype = ptype;
	}

	public List<Passenger> getOtherlistPassenger() {
		return otherlistPassenger;
	}

	public void setOtherlistPassenger(List<Passenger> otherlistPassenger) {
		this.otherlistPassenger = otherlistPassenger;
	}

	public Biguser getBiguser() {
		return biguser;
	}

	public void setBiguser(Biguser biguser) {
		this.biguser = biguser;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getS_passenger() {
		return s_passenger;
	}

	public void setS_passenger(String s_passenger) {
		this.s_passenger = s_passenger;
	}

	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public double getPricecount() {
		return pricecount;
	}

	public void setPricecount(double pricecount) {
		this.pricecount = pricecount;
	}

	public Timestamp getToday() {
		return today;
	}

	public void setToday(Timestamp today) {
		this.today = today;
	}

	public long getHkallprice() {
		return hkallprice;
	}

	public void setHkallprice(long hkallprice) {
		this.hkallprice = hkallprice;
	}

	public double getBlanceyue() {
		return blanceyue;
	}

	public void setBlanceyue(double blanceyue) {
		this.blanceyue = blanceyue;
	}

	public long getHaveprofit() {
		return haveprofit;
	}

	public void setHaveprofit(long haveprofit) {
		this.haveprofit = haveprofit;
	}

	public String getTwodepartment() {
		return twodepartment;
	}

	public void setTwodepartment(String twodepartment) {
		this.twodepartment = twodepartment;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public float getArrearage() {
		return arrearage;
	}

	public void setArrearage(float arrearage) {
		this.arrearage = arrearage;
	}

	public int getS_internal() {
		return s_internal;
	}

	public void setS_internal(int s_internal) {
		this.s_internal = s_internal;
	}

	public int getContains() {
		return contains;
	}

	public void setContains(int contains) {
		this.contains = contains;
	}

	public String getS_ordernum() {
		return s_ordernum;
	}

	public void setS_ordernum(String s_ordernum) {
		this.s_ordernum = s_ordernum;
	}

	public String getS_ticketnum() {
		return s_ticketnum;
	}

	public void setS_ticketnum(String s_ticketnum) {
		this.s_ticketnum = s_ticketnum;
	}

}