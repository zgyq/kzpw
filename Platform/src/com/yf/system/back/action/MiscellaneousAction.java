/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class MiscellaneousAction extends B2b2cbackAction {
	private List<Miscellaneous> listMiscellaneous;
	private Miscellaneous miscellaneous = new Miscellaneous();
	private List<Customeragent> listgroupuseelist = new ArrayList<Customeragent>();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	private String treestr = "";
	private String s_department;
	
	private String departname;

	// search
	// private String s_name;

	/**
	 * 列表查询客户经理杂项列表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Miscellaneous.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		if (!isAdmin()) {
			where = "WHERE 1=1 AND " + Miscellaneous.COL_groupuserid
					+ " IN (SELECT ID FROM  [T_CUSTOMERAGENT] WHERE C_USERID="
					+ getLoginUserId() + ")";
		}
		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			where = " WHERE 1=1 AND  " + Miscellaneous.COL_groupuserid + " ="
					+ this.getLoginUser().getAgentid();
		}

		List list = Server.getInstance().getMemberService()
				.findAllMiscellaneousForPageinfo(where, " ORDER BY ID DESC ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listMiscellaneous = list;
		if (pageinfo.getTotalrow() > 0 && listMiscellaneous.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllMiscellaneousForPageinfo(where,
							" ORDER BY ID  DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listMiscellaneous = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到客户经理杂项列表添加页面
	 */
	public String toadd() throws Exception {
		String menuwhere = " where 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND "
				+ Customeragent.COL_userid + "=" + getLoginUserId();
		if (isAdmin()||getLoginUser().getType() == 1) {//管理员或平台员工
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		listgroupuseelist = Server.getInstance().getMemberService()
				.findAllCustomeragent(menuwhere, "", -1, 0);
		long[] longarry = new long[listgroupuseelist.size()];
		int i = 0;
		for (Customeragent agent : listgroupuseelist) {
			longarry[i] = agent.getId();
			i++;
		}
		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			longarry = new long[1];
			longarry[0] = this.getLoginUser().getAgentid();
		}
		//this.getDepttreestr(3l, longarry, true);
		return EDIT;
	}

	/**
	 * 转向到客户经理杂项列表修改页面
	 */
	public String toedit() throws Exception {
		String menuwhere = " where 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND "
				+ Customeragent.COL_userid + "=" + getLoginUserId();
		if (isAdmin()||getLoginUser().getType() == 1) {//管理员或平台员工
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		listgroupuseelist = Server.getInstance().getMemberService()
				.findAllCustomeragent(menuwhere, "", -1, 0);
		long[] longarry = new long[listgroupuseelist.size()];
		int i = 0;
		for (Customeragent agent : listgroupuseelist) {
			longarry[i] = agent.getId();
			i++;
		}
		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			longarry = new long[1];
			longarry[0] = this.getLoginUser().getAgentid();
		}
		//this.getDepttreestr(3l, longarry, true);
		miscellaneous = Server.getInstance().getMemberService()
				.findMiscellaneous(miscellaneous.getId());
		if (miscellaneous.getDepartment() != null) {
			departname=Server.getInstance().getMemberService().findDepartment(miscellaneous.getDepartment()).getName();
		} else {
			departname=Server.getInstance().getMemberService().findCustomeragent(miscellaneous.getGroupuserid()).getAgentcompanyname();
		}
		if(miscellaneous.getDepartment()!=null&&miscellaneous.getDepartment()>0){
			this.s_department=miscellaneous.getGroupuserid()+"@"+miscellaneous.getDepartment();
		}else{
			this.s_department="c"+miscellaneous.getGroupuserid();
		}
		return EDIT;
	}

	/**
	 * 转向到客户经理杂项列表审核页面
	 */
	public String tocheck() throws Exception {
		miscellaneous = Server.getInstance().getMemberService()
				.findMiscellaneous(miscellaneous.getId());
		return CHECK;
	}

	/**
	 * 添加客户经理杂项列表
	 */
	public String add() throws Exception {
		if (s_department != null && s_department.trim().length() > 0) {
			if (s_department.indexOf("c") >= 0) {
				long deptid = Long.valueOf(s_department.substring(1));
				miscellaneous.setGroupuserid(deptid);
				miscellaneous.setDepartment(null);
			} else {
				long deptid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));
				miscellaneous.setDepartment(deptid);
				miscellaneous.setGroupuserid(Long.valueOf(s_department
						.substring(s_department.indexOf("@") + 1)));
			}
		}
		miscellaneous.setCreatetime(new Timestamp(System.currentTimeMillis()));
		miscellaneous.setCreateid(getLoginUserId());
		miscellaneous.setState(1l);// 1,未还 2,已还款，3,已还部分
		Server.getInstance().getMemberService().createMiscellaneous(
				miscellaneous);
		return LIST;
	}

	/**
	 * 审核客户经理杂项列表
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateMiscellaneousIgnoreNull(
				miscellaneous);
		return LIST;
	}

	public String getContentitemName(String id) {
		if (id.indexOf("company") >= 0) {
			return Server.getInstance().getMemberService().findCustomeragent(
					Long.parseLong(id.replace("company", "")))
					.getAgentcompanyname();
		} else {
			return Server.getInstance().getMemberService().findDepartment(
					Long.parseLong(id)).getName();
		}
	}

	private void getString(long id, long agid, long flag) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ agid, "ORDER BY ID", -1, 0);
		if (flag > 0) {

			treestr += "var sub_" + agid
					+ " = new Ext.tree.TreeNode({ id:'company" + agid
					+ "',  text:'" + getagentname_b2bback(agid) + "'});\n";

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
	 * 编辑客户经理杂项列表
	 */
	public String edit() throws Exception {
		if (s_department != null && s_department.trim().length() > 0) {
			if (s_department.indexOf("c") >= 0) {
				long deptid = Long.valueOf(s_department.substring(1));
				miscellaneous.setGroupuserid(deptid);
				miscellaneous.setDepartment(null);
			} else {
				long deptid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));
				miscellaneous.setDepartment(deptid);
				miscellaneous.setGroupuserid(Long.valueOf(s_department
						.substring(s_department.indexOf("@") + 1)));
			}
		}
		Server.getInstance().getMemberService().updateMiscellaneousIgnoreNull(
				miscellaneous);
		return LIST;
	}

	/**
	 * 删除客户经理杂项列表
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteMiscellaneous(
				miscellaneous.getId());
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
					Server.getInstance().getMemberService()
							.deleteMiscellaneous(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	public Customeragent getCustomeragentById(long id) {
		return Server.getInstance().getMemberService().findCustomeragent(id);

	}

	public Customeruser getCustomeruserById(long id) {
		return Server.getInstance().getMemberService().findCustomeruser(id);
	}

	/**
	 * 返回客户经理杂项列表对象
	 */

	public Object getModel() {
		return miscellaneous;
	}

	public List<Miscellaneous> getListMiscellaneous() {
		return listMiscellaneous;
	}

	public void setListMiscellaneous(List<Miscellaneous> listMiscellaneous) {
		this.listMiscellaneous = listMiscellaneous;
	}

	public Miscellaneous getMiscellaneous() {
		return miscellaneous;
	}

	public void setMiscellaneous(Miscellaneous miscellaneous) {
		this.miscellaneous = miscellaneous;
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

	public List<Customeragent> getListgroupuseelist() {
		return listgroupuseelist;
	}

	public void setListgroupuseelist(List<Customeragent> listgroupuseelist) {
		this.listgroupuseelist = listgroupuseelist;
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

	public void getUserlistByAgent() throws IOException {

		String agent = ServletActionContext.getRequest().getParameter("agent");
		String username = ServletActionContext.getRequest().getParameter(
				"username");
		String agentname = "";
		String deptname = "";
		StringBuffer str = new StringBuffer("");
		str.append("<table>");
		str
				.append("<tr><td>姓名：<input id=\"cuname\"/>&nbsp;&nbsp;<input type=\"button\" onclick=\"searchuser()\" class=\"button108\" value=\" 查 询 \"/></td></tr>");
		str.append("<table  class=\"passtable\" id=\"divtable\">");
		str.append("<thead><tr>");
		str
				.append("<th class=\"passth\" width=\"80px\">姓名</th><th width=\"100px\">手机号码</th><th width=\"200px\">证件号码</th><th width=\"150px\">部门</th>");
		str.append("</thead></tr><tbody>");
		String where = "";
		if (agent.indexOf("c") >= 0) {
			int index = agent.indexOf("c") + 1;
			int agentid = Integer.valueOf(agent.substring(index));
			agentname = Server.getInstance().getMemberService()
					.findCustomeragent(agentid).getAgentcompanyname();
			where = " where C_AGENTID =" + agentid;
		} else {
			int index = agent.indexOf("@") + 1;
			int agentid = Integer.valueOf(agent.substring(index));
			where = " where C_DEPTID =" + agent;
			Department dept = Server.getInstance().getMemberService()
					.findDepartment(Long.valueOf(agent));
			deptname = dept.getName();
			agentname = Server.getInstance().getMemberService()
					.findCustomeragent(dept.getAgentid()).getAgentcompanyname();
		}
		where += " AND " + Customeruser.COL_membertype + " =1";
		if (username != null && username.length() > 0) {
			where += " AND " + Customeruser.COL_membername + " LIKE '%"
					+ username + "%' ";
		}
		List<Customeruser> customeruserlist = new ArrayList();
		customeruserlist = Server.getInstance().getMemberService()
				.findAllCustomeruser(where, "", -1, 0);
		for (Customeruser user : customeruserlist) {
			String card = "";
			String ccwhere = " WHERE " + Customercredit.COL_refid + "="
					+ user.getId();
			List<Customercredit> ccs = Server.getInstance().getMemberService()
					.findAllCustomercredit(ccwhere, "", -1, 0);
			if (ccs.size() > 0) {
				Customercredit credit = ccs.get(0);
				//System.out.println(credit.getCreditnumber());
				//System.out.println(credit.getType());
				try {
					card = OrderinfoAction.getIDTypeToString(credit
							.getCredittypeid())
							+ ":";
				} catch (Exception e) {

				}
				card += credit.getCreditnumber();

			}
			String mobile = user.getMobile();
			if (mobile == null)
				mobile = "";

			str.append("<tr onclick=\"getCuname('" + user.getId() + "','"
					+ user.getMembername()
					+ "')\" style=\"cursor:pointer\"><td class=\"passtd\">"
					+ user.getMembername() + "</td><td>" + mobile + "</td><td>"
					+ card + "</td><td>" + deptname + "</td></tr>");
		}
		str.append("</tbody></table>");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(str.toString());
		out.flush();
		out.close();

	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

}