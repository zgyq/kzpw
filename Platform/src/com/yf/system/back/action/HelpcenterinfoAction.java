/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;

import com.yf.system.back.server.Server;
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.helpcenterinfo.Helpcenterinfo;

public class HelpcenterinfoAction extends B2b2cbackAction {
	private List<Helpcenterinfo> listHelpcenterinfo;
	private Helpcenterinfo helpcenterinfo = new Helpcenterinfo();

	// 批量操作ID数组
	private int[] selectid;
	private String treestr = "";
	// 批量操作选项
	private int opt;

	// search
	private String s_name;// 名称
	private String s_info;// 信息
	private String h_info;// 答案
	private String h_name;// 问题
	private String m_name;// 名称
	private String s_type;// 类型
	private String isanswers;// 是否是问答
	private String iswebs;// 是否主推

	public String getIsanswer() {
		return isanswers;
	}

	public void setIsanswer(String isanswers) {
		this.isanswers = isanswers;
	}

	public String getIswebs() {
		return iswebs;
	}

	public void setIswebs(String iswebs) {
		this.iswebs = iswebs;
	}

	private void getString(long id) {
		List<Helpcenter> listhelp = Server.getInstance().getMemberService()
				.findAllHelpcenter(
						"where " + Helpcenter.COL_parentid + " =" + id,
						"ORDER BY ID", -1, 0);
		if (!listhelp.isEmpty()) {
			for (Helpcenter m : listhelp) {
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

	/**
	 * 列表查询帮助中心信息
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		if (s_name != null && s_name.trim().length() != 0) {

			where += " and " + Helpcenterinfo.COL_name + " like '%"
					+ s_name.trim() + "%'";
		}
		if (s_info != null && s_info.trim().length() != 0) {

			where += " and " + Helpcenterinfo.COL_info + " like '%"
					+ s_info.trim() + "%'";
		}
		if (s_type != null && s_type.trim().length() != 0) {

			where += " and " + Helpcenterinfo.COL_typeid + " = "
					+ s_type.trim() + "";
		}
		List list = Server.getInstance().getMemberService()
				.findAllHelpcenterinfoForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHelpcenterinfo = list;
		if (pageinfo.getTotalrow() > 0 && listHelpcenterinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllHelpcenterinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHelpcenterinfo = list;
		}
		getString(-1);
		return SUCCESS;
	}

	/**
	 * 转向到帮助中心信息添加页面
	 */
	public String toadd() throws Exception {
		getString(-1);
		return EDIT;
	}

	/**
	 * 转向到帮助中心信息修改页面
	 */
	public String toedit() throws Exception {
		getString(-1);
		helpcenterinfo = Server.getInstance().getMemberService()
				.findHelpcenterinfo(helpcenterinfo.getId());
		return EDIT;
	}

	/**
	 * 转向到帮助中心信息审核页面
	 */
	public String tocheck() throws Exception {
		helpcenterinfo = Server.getInstance().getMemberService()
				.findHelpcenterinfo(helpcenterinfo.getId());
		return CHECK;
	}

	public String getHelpcenterName(long id) {

		return Server.getInstance().getMemberService().findHelpcenter(id)
				.getName();
	}

	/**
	 * 添加帮助中心信息
	 */
	public String add() throws Exception {
		helpcenterinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		helpcenterinfo.setMemberid(getLoginUser().getId());
		if (isanswers.equals("1")) {
			helpcenterinfo.setInfo(h_info);
			helpcenterinfo.setName(h_name);
			helpcenterinfo.setIsanswer(Long.parseLong(isanswers));
			helpcenterinfo.setIsweb(Long.parseLong(iswebs));
			Server.getInstance().getMemberService().createHelpcenterinfo(
					helpcenterinfo);
		} else {
			helpcenterinfo.setName(m_name);
			helpcenterinfo.setIsanswer(Long.parseLong(isanswers));
			helpcenterinfo.setIsweb(Long.parseLong(iswebs));
			Server.getInstance().getMemberService().createHelpcenterinfo(
					helpcenterinfo);
		}

		return LIST;
	}

	/**
	 * 审核帮助中心信息
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateHelpcenterinfoIgnoreNull(
				helpcenterinfo);
		return LIST;
	}

	/**
	 * 编辑帮助中心信息
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateHelpcenterinfoIgnoreNull(
				helpcenterinfo);
		return LIST;
	}

	/**
	 * 删除帮助中心信息
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteHelpcenterinfo(
				helpcenterinfo.getId());
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
							.deleteHelpcenterinfo(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回帮助中心信息对象
	 */

	public Object getModel() {
		return helpcenterinfo;
	}

	public List<Helpcenterinfo> getListHelpcenterinfo() {
		return listHelpcenterinfo;
	}

	public void setListHelpcenterinfo(List<Helpcenterinfo> listHelpcenterinfo) {
		this.listHelpcenterinfo = listHelpcenterinfo;
	}

	public Helpcenterinfo getHelpcenterinfo() {
		return helpcenterinfo;
	}

	public void setHelpcenterinfo(Helpcenterinfo helpcenterinfo) {
		this.helpcenterinfo = helpcenterinfo;
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

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_info() {
		return s_info;
	}

	public void setS_info(String s_info) {
		this.s_info = s_info;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public String getH_info() {
		return h_info;
	}

	public void setH_info(String h_info) {
		this.h_info = h_info;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getIsanswers() {
		return isanswers;
	}

	public void setIsanswers(String isanswers) {
		this.isanswers = isanswers;
	}

}