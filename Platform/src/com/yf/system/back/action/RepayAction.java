/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.department.Department;
import com.yf.system.base.repay.Repay;
import com.yf.system.base.util.PageInfo;

public class RepayAction extends B2b2cbackAction {
	private List<Repay> listRepay;
	private Repay repay = new Repay();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;
	private String treestr = "";
	private String s_department;
	private String s_passenger;
	private String s_operator;
	private String s_startdate;
	private String s_enddate;
	private long agentid;
	private String departname;

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	/**
	 * 列表查询大客户还款记录表
	 */
	public String execute() throws Exception {

		String menuwhere = " where 1=1 AND C_AGENTISENABLE=1 and C_AGENTCHECKSTATUS=1  AND "
				+ Customeragent.COL_userid + " =" + getLoginUserId();// 客户经理
		if (isAdmin()) {// admin
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		List<Customeragent> listCustomeragent = Server.getInstance()
				.getMemberService().findAllCustomeragent(menuwhere, "", -1, 0);
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
		

		String where = " where 1=1 ";

		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色

			where = " WHERE 1=1  AND " + Repay.COL_agentid + "="
					+ getLoginUser().getAgentid();
		}
		if (!isAdmin()) {
			where = " WHERE 1=1 AND " + Repay.COL_agentid
					+ " IN ( SELECT ID FROM [T_CUSTOMERAGENT] WHERE C_USERID="
					+ this.getLoginUserId() + " )";
		}
		if (s_department != null && s_department.trim().length() > 0) {
			if (s_department.indexOf("c") >= 0) {
				 agentid = Long.valueOf(s_department.substring(1));
				this.departname = Server.getInstance().getMemberService()
						.findDepartment(agentid).getName();

			} else {
				agentid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));
				this.departname = Server.getInstance().getMemberService()
						.findDepartment(agentid).getName();

			}
			where = " WHERE 1=1  AND " + Repay.COL_agentid + "="+agentid;
			
		}

		// 乘机人姓名
		if (s_passenger != null && s_passenger.trim().length() != 0) {
			Repay r = new Repay();

			where += " and " + Repay.COL_passengerid
					+ " in (select ID from T_PASSENGER  where C_NAME like '%"
					+ s_passenger.trim() + "%')";
		}
		// 操作人姓名
		if (s_operator != null && s_operator.trim().length() != 0) {
			where += " and "
					+ Repay.COL_orderid
					+ " in (select ID from T_ORDERINFO where C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like '%"
					+ s_operator + "%') )";
		}
		// 部门id
		if (s_department != null && s_department.trim().length() != 0) {
			where += " and " + Repay.COL_agentid + "=" + s_department;
		}
		// 起止日期
		if (s_startdate != null && s_startdate.trim().length() != 0
				&& s_enddate != null && s_enddate.trim().length() != 0) {
			where += " and " + Repay.COL_createtime + " between " + s_startdate
					+ " and " + s_enddate;
		}

		List list = Server
				.getInstance()
				.getMemberService()
				.findAllRepayForPageinfo(where,
						" ORDER BY " + Repay.COL_createtime + " DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listRepay = list;
		if (pageinfo.getTotalrow() > 0 && listRepay.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllRepayForPageinfo(where,
							" ORDER BY " + Repay.COL_createtime + " DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listRepay = list;
		}
	
		return SUCCESS;
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

	/**
	 * 转向到大客户还款记录表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到大客户还款记录表修改页面
	 */
	public String toedit() throws Exception {
		repay = Server.getInstance().getMemberService()
				.findRepay(repay.getId());
		return EDIT;
	}

	/**
	 * 转向到大客户还款记录表审核页面
	 */
	public String tocheck() throws Exception {
		repay = Server.getInstance().getMemberService()
				.findRepay(repay.getId());
		return CHECK;
	}

	/**
	 * 添加大客户还款记录表
	 */
	public String add() throws Exception {
		repay.setCreatetime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().createRepay(repay);
		return LIST;
	}

	/**
	 * 审核大客户还款记录表
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateRepayIgnoreNull(repay);
		return LIST;
	}

	/**
	 * 编辑大客户还款记录表
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateRepayIgnoreNull(repay);
		return LIST;
	}

	/**
	 * 删除大客户还款记录表
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteRepay(repay.getId());
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
					Server.getInstance().getMemberService().deleteRepay(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回大客户还款记录表对象
	 */

	public Object getModel() {
		return repay;
	}

	public List<Repay> getListRepay() {
		return listRepay;
	}

	public void setListRepay(List<Repay> listRepay) {
		this.listRepay = listRepay;
	}

	public Repay getRepay() {
		return repay;
	}

	public void setRepay(Repay repay) {
		this.repay = repay;
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

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public String getS_passenger() {
		return s_passenger;
	}

	public void setS_passenger(String s_passenger) {
		this.s_passenger = s_passenger;
	}

	public String getS_operator() {
		return s_operator;
	}

	public void setS_operator(String s_operator) {
		this.s_operator = s_operator;
	}

	public String getS_startdate() {
		return s_startdate;
	}

	public void setS_startdate(String s_startdate) {
		this.s_startdate = s_startdate;
	}

	public String getS_enddate() {
		return s_enddate;
	}

	public void setS_enddate(String s_enddate) {
		this.s_enddate = s_enddate;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

}