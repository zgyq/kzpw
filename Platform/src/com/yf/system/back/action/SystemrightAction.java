/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;

import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;

public class SystemrightAction extends B2b2cbackAction {

	public static final String modelstr = "28,10254,81,82,189,10502,10590,10650,10678,10679";
	// 只有机票的系统权限modelstr "28,10254,81,82,189,10590,10678,10679";
	// 有机票，酒店，火车票权限的modelstr "28,10254,81,82,189,10502,10590,10650,10678,10679";

	//10622,
	//public static final String modelstr = "1,10254,81,82,189,10502,10590,10622,10650,10678,10679,10697";
//	public static final String modelstr = "1,10254,81,82,189,10590,10678,10679,10697";
	// 只有机票的系统权限modelstr "1,10254,81,82,189,10590,10678,10679";
	// 有机票，酒店，火车票权限的modelstr "1,10254,81,82,189,10502,10590,10650,10678,10679,10697";

	private List<Systemright> listSystemright;
	private Systemright systemright = new Systemright();
	private List<Systemright> listsysright;
	private List<Systemright> listsysright1;
	private List<Systemright> listsysright2;
	private List<Sysroleright> listSysroleright;
	private List<Agentroleref> listAgentroleref;

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;
	private int rd;
	private long rigd;
	private long rold;

	private String treestr = "";
	private String s_rigthname;
	private String s_rigthcode;

	private List<Systemright> listSelect = new ArrayList<Systemright>();
	private List<Systemright> listSelect2 = new ArrayList<Systemright>();

	public List<Systemright> getListSelect(long id) {
		listSelect.clear();
		List<Systemright> cs = Server.getInstance().getMemberService()
				.findAllSystemright(
						" where " + Systemright.COL_parentid + " = " + id,
						"order by " + Systemright.COL_id + " desc ", -1, 0);
		for (Systemright c : cs) {
			listSelect.add(c);
		}

		return listSelect;
	}

	public List<Systemright> getListSelect2(long id) {
		listSelect2.clear();
		List<Systemright> cs = Server.getInstance().getMemberService()
				.findAllSystemright(
						" where " + Systemright.COL_parentid + "=" + id,
						"order by " + Systemright.COL_id + " desc ", -1, 0);
		for (Systemright c : cs) {
			listSelect2.add(c);
		}

		return listSelect2;
	}

	// search
	// private String s_name;
	private void getString(long id) {
		String where = " WHERE  "
				+ Systemright.COL_parentid + " = " + id;

		List<Systemright> list = Server.getInstance().getMemberService()
				.findAllSystemright(where, "ORDER BY ID", -1, 0);
		if (!list.isEmpty()) {

			for (Systemright m : list) {
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
				getString(m.getId());
			}
		}
	}

	public String getContentitemName(long id) {
		return Server.getInstance().getMemberService().findSystemright(id)
				.getName();
	}

	/**
	 * 创建树
	 */
	public String buildTree() {
//		String wherestr = " AND (ID IN (" + SystemrightAction.modelstr
//				+ ") OR dbo.F_TWOCHARINDEX('" + SystemrightAction.modelstr
//				+ "'," + Systemright.COL_parentstr + ")>0)";
		if (this.getLoginUserRoleNumber().contains(-1)) {
			listsysright = Server.getInstance().getMemberService()
					.findAllSystemright("where 1 = 1 ",
							"ORDER BY ID ", -1, 0);

		} else {
			String where = " where " + Systemright.COL_id + " in ( select "
					+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
					+ " where " + Sysroleright.COL_roleid + " in (select "
					+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
					+ " where " + Agentroleref.COL_customeruserid + "="
					+ getLoginUser().getId() + "))" ;
			System.out.println("where==*****1" + where);
			listsysright = Server.getInstance().getMemberService()
					.findAllSystemright(where, "ORDER BY ID ", -1, 0);
		}
		System.out.println(listsysright.size());
		return "deparTree";
	}

	/**
	 * 创建树
	 */
	public String buildTree2() {
		listAgentroleref = Server.getInstance().getMemberService()
				.findAllAgentroleref(
						" where 1=1 and " + Agentroleref.COL_customeruserid
								+ " =" + getLoginUser().getId(),
						" ORDER BY ID ", -1, 0);

		for (Agentroleref ag : listAgentroleref) { // 循环查询出当前用户的角色ID Long
			long roleid = ag.getRoleid(); // System.out.println("角色ID===="+roleid);
//			String wherestr = " AND (ID IN (" + SystemrightAction.modelstr
//					+ ") OR dbo.F_TWOCHARINDEX('" + SystemrightAction.modelstr
//					+ "'," + Systemright.COL_parentstr + ")>0)";

			if (roleid == -1) {
				listsysright = Server.getInstance().getMemberService()
						.findAllSystemright("where 1 = 1 ",
								"ORDER BY ID ", -1, 0);

			} else {

				String where = " where " + Systemright.COL_id + " in ( select "
						+ Sysroleright.COL_rightid + " from "
						+ Sysroleright.TABLE + " where "
						+ Sysroleright.COL_roleid + " in (select "
						+ Agentroleref.COL_roleid + " from "
						+ Agentroleref.TABLE + " where "
						+ Agentroleref.COL_customeruserid + "="
						+ getLoginUser().getId() + "))" ;
				System.out.println("where*****2==" + where);
				listsysright = Server.getInstance().getMemberService()
						.findAllSystemright(where, "ORDER BY ID ", -1, 0);
			}
			System.out.println(listsysright.size());
		}

		// listsysright1 =
		// Server.getInstance().getMemberService().findAllSystemright(
		// "where 1 = 1 and "+Systemright.COL_parentid+" = -1", "ORDER BY ID ",
		// -1, 0);
		// listsysright2 = Server.getInstance().getMemberService()
		// .findAllSystemright("where 1 = 1 and "+Systemright.COL_parentid+" !=
		// -1", "ORDER BY ID ", -1, 0);
		return "tofuquan";
	}

	public void addsysrolerright() throws SQLException {
		System.out.println(rold + "----" + rigd);
		String where = " where 1=1  and " + Sysroleright.COL_rightid + " ="
				+ rigd + " and " + Sysroleright.COL_roleid + " =" + rold;
		listSysroleright = Server.getInstance().getMemberService()
				.findAllSysroleright(where, "ORDER BY ID ", -1, 0);
		System.out.println(where);
		System.out.println("listSysroleright.size()" + listSysroleright.size());
		if (listSysroleright.size() == 0) {
			Sysroleright sysroleright = new Sysroleright();
			sysroleright.setRoleid(rold);
			sysroleright.setRightid(rigd);
			Server.getInstance().getMemberService().createSysroleright(
					sysroleright);
		}

	}

	public void deletsysrolerright() throws SQLException {
		System.out.println(rold + "----" + rigd);
//		String sq = "delete from " + Sysroleright.TABLE + " where 1 = 1 AND "
//				+ Sysroleright.COL_roleid + " = " + rold + " AND "
//				+ Sysroleright.COL_rightid + " = " + rigd;
		//以下有小韩修改 功能：删除上级角色权限同时删除下级角色权限
		String sql="DELETE T_SYSROLERIGHT WHERE ( C_ROLEID="+rold+" AND C_RIGHTID="+rigd+" )" +
				" OR C_ROLEID IN  (SELECT ID FROM T_SYSTEMROLE WHERE CHARINDEX(','+(SELECT CONVERT(VARCHAR(50),C_CUSTOMERAGENTID) FROM T_SYSTEMROLE WHERE ID="+rold+")+',',(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT C WHERE C_CUSTOMERAGENTID=C.ID))>0)";
		if(rold==1){//系统管理员 最高角色
			sql="DELETE T_SYSROLERIGHT WHERE ( C_ROLEID=1 OR C_ROLEID IN(SELECT ID FROM T_SYSTEMROLE WHERE C_CUSTOMERAGENTID=46)) AND C_RIGHTID= "+rigd;
		}
		Server.getInstance().getMemberService().excuteSysrolerightBySql(sql);

	}

	// 取较色名称
	public String getRolername(int id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findSystemrole(id)
				.getName();
	}

	/**
	 * 列表查询系统权限
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		if (s_rigthname != null && s_rigthname.trim().length() != 0) {

			where += " and " + Systemright.COL_name + " like '%"
					+ s_rigthname.trim() + "%'";
		}
		if (s_rigthcode != null && s_rigthcode.trim().length() != 0) {

			where += " and " + Systemright.COL_code + " like '%"
					+ s_rigthcode.trim() + "%'";
		}

//		String wherestr = " AND (ID IN (" + SystemrightAction.modelstr
//				+ ") OR dbo.F_TWOCHARINDEX('" + SystemrightAction.modelstr
//				+ "'," + Systemright.COL_parentstr + ")>0)";

		List list = Server.getInstance().getMemberService()
				.findAllSystemrightForPageinfo(where ,
						" ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listSystemright = list;
		if (pageinfo.getTotalrow() > 0 && listSystemright.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllSystemrightForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listSystemright = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到系统权限添加页面
	 */
	public String toadd() throws Exception {
		getString(-1l);

		return EDIT;
	}

	/**
	 * 转向到系统权限修改页面
	 */
	public String toedit() throws Exception {
		getString(-1l);
		systemright = Server.getInstance().getMemberService().findSystemright(
				systemright.getId());
		return EDIT;
	}

	/**
	 * 转向到系统权限审核页面
	 */
	public String tocheck() throws Exception {
		systemright = Server.getInstance().getMemberService().findSystemright(
				systemright.getId());
		return CHECK;
	}

	/**
	 * 添加系统权限
	 */
	public String add() throws Exception {
		System.err.println("parentid====" + systemright.getParentid());
		if (systemright.getParentid() == null) {
			systemright.setParentid(-1l);
		}

		systemright.setCreateuser(getLoginUser().getLoginname());
		// systemright.setCreateuser("admin");
		systemright.setCreatetime(new Timestamp(System.currentTimeMillis()));
		systemright.setModifyuser(getLoginUser().getLoginname());
		// systemright.setModifyuser("admin");
		systemright.setModifytime(new Timestamp(System.currentTimeMillis()));

		systemright = Server.getInstance().getMemberService()
				.createSystemright(systemright);
		if (systemright.getOrderid() == null) {
			long b = systemright.getId();
			int a = (int) b;
			systemright.setOrderid(a);
			Server.getInstance().getMemberService()
					.updateSystemrightIgnoreNull(systemright);

		}
		return LIST;
	}

	/**
	 * 审核系统权限
	 */
	public String check() throws Exception {
		systemright.setModifyuser(getLoginUser().getLoginname());
		systemright.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateSystemrightIgnoreNull(
				systemright);
		return LIST;
	}

	public boolean hasRight(long roleid, long rightid) {
		System.out.println("rightid" + rightid);
		String where = " where " + Sysroleright.COL_rightid + " = " + rightid
				+ " and " + Sysroleright.COL_roleid + "=" + roleid;
		if (Server.getInstance().getMemberService().findAllSysroleright(where,
				"", -1, 0).size() <= 0) {
			return false;

		} else {
			return true;
		}

	}

	/**
	 * 编辑系统权限
	 */
	public String edit() throws Exception {
		systemright.setModifyuser("admin");
		systemright.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateSystemrightIgnoreNull(
				systemright);
		return LIST;
	}

	/**
	 * 删除系统权限
	 */
	public String delete() throws Exception {
		String sql = "DELETE T_SYSTEMRIGHT WHERE ID="
				+ this.systemright.getId()
				+ " OR CHARINDEX(','+CONVERT(NVARCHAR(50),"
				+ this.systemright.getId() + ")+',',','+C_PARENTSTR+',')>0";
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
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
							.deleteSystemright(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回系统权限对象
	 */

	public Object getModel() {
		return systemright;
	}

	public List<Systemright> getListSystemright() {
		return listSystemright;
	}

	public void setListSystemright(List<Systemright> listSystemright) {
		this.listSystemright = listSystemright;
	}

	public Systemright getSystemright() {
		return systemright;
	}

	public void setSystemright(Systemright systemright) {
		this.systemright = systemright;
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

	public List<Systemright> getListSelect() {
		return listSelect;
	}

	public void setListSelect(List<Systemright> listSelect) {
		this.listSelect = listSelect;
	}

	public List<Systemright> getListSelect2() {
		return listSelect2;
	}

	public void setListSelect2(List<Systemright> listSelect2) {
		this.listSelect2 = listSelect2;
	}

	public List<Systemright> getListsysright1() {
		return listsysright1;
	}

	public void setListsysright1(List<Systemright> listsysright1) {
		this.listsysright1 = listsysright1;
	}

	public List<Systemright> getListsysright2() {
		return listsysright2;
	}

	public void setListsysright2(List<Systemright> listsysright2) {
		this.listsysright2 = listsysright2;
	}

	public List<Systemright> getListsysright() {
		return listsysright;
	}

	public void setListsysright(List<Systemright> listsysright) {
		this.listsysright = listsysright;
	}

	public int getRd() {
		return rd;
	}

	public void setRd(int rd) {
		this.rd = rd;
	}

	public long getRigd() {
		return rigd;
	}

	public void setRigd(long rigd) {
		this.rigd = rigd;
	}

	public long getRold() {
		return rold;
	}

	public void setRold(long rold) {
		this.rold = rold;
	}

	public List<Sysroleright> getListSysroleright() {
		return listSysroleright;
	}

	public void setListSysroleright(List<Sysroleright> listSysroleright) {
		this.listSysroleright = listSysroleright;
	}

	public String getS_rigthname() {
		return s_rigthname;
	}

	public void setS_rigthname(String s_rigthname) {
		this.s_rigthname = s_rigthname;
	}

	public String getS_rigthcode() {
		return s_rigthcode;
	}

	public void setS_rigthcode(String s_rigthcode) {
		this.s_rigthcode = s_rigthcode;
	}

}