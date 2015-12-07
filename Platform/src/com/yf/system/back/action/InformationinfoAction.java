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
import com.yf.system.base.information.Information;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.util.PageInfo;

public class InformationinfoAction extends B2b2cbackAction {
	private List<Informationinfo> listInformationinfo;
	private Informationinfo informationinfo = new Informationinfo();

	// 批量操作ID数组
	private int[] selectid;
	private String treestr = "";
	// 批量操作选项
	private int opt;
	private String name;

	// search
	private String s_name;// 名称
	private String s_info;// 信息
	private String s_type;// 类型
	private String h_info;// 答案
	private String h_name;// 问题
	private String m_name;// 名称
	private String isanswers;// 是否是问答
	private String iswebs;// 是否主推

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



	public String getIswebs() {
		return iswebs;
	}

	public void setIswebs(String iswebs) {
		this.iswebs = iswebs;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void getString(long id) {
		List<Information> listinformation = Server.getInstance()
				.getMemberService().findAllInformation(
						"where " + Information.COL_parentid + " =" + id,
						"ORDER BY ID", -1, 0);
		if (!listinformation.isEmpty()) {

			for (Information m : listinformation) {
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

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getInformationName(long id) {

		return Server.getInstance().getMemberService().findInformation(id)
				.getName();
	}

	/**
	 * 列表查询资讯中心详细信息
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		if (s_name != null && s_name.trim().length() != 0) {

			where += " and " + Informationinfo.COL_name + " like '%"
					+ s_name.trim() + "%'";
		}
		if (s_info != null && s_info.trim().length() != 0) {
			where += " and " + Informationinfo.COL_info + " like '%"
					+ s_info.trim() + "%'";
		}
		if (s_type != null && s_type.trim().length() != 0) {
			where += " and " + Informationinfo.COL_typeid + " = " + s_type;
		}
		List list = Server.getInstance().getMemberService()
				.findAllInformationinfoForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listInformationinfo = list;
		if (pageinfo.getTotalrow() > 0 && listInformationinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllInformationinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listInformationinfo = list;
			System.out.println(where);
		}
		/*
		 * for(int i=0;i<=listInformationinfo.size();i++){
		 * listInformationinfo.get(0).setInfo(listInformationinfo.get(0).getInfo().substring(0,
		 * 20)); }
		 */

		getString(-1);
		return SUCCESS;
	}

	/**
	 * 转向到资讯中心详细信息添加页面
	 */
	public String toadd() throws Exception {
		getString(-1);
		return EDIT;
	}

	/**
	 * 转向到资讯中心详细信息修改页面
	 */
	public String toedit() throws Exception {
		getString(-1);
		informationinfo = Server.getInstance().getMemberService()
				.findInformationinfo(informationinfo.getId());
		return EDIT;
	}

	/**
	 * 转向到资讯中心详细信息审核页面
	 */
	public String tocheck() throws Exception {
		informationinfo = Server.getInstance().getMemberService()
				.findInformationinfo(informationinfo.getId());
		return CHECK;
	}

	/**
	 * 添加资讯中心详细信息
	 */
	public String add() throws Exception {
		informationinfo
				.setCreatetime(new Timestamp(System.currentTimeMillis()));
		informationinfo.setMemberid(getLoginUser().getId());
		if (isanswers.equals("1")) {
			informationinfo.setInfo(h_info);
			informationinfo.setName(h_name);
			informationinfo.setIsanswer(Long.parseLong(isanswers));
			informationinfo.setIsweb(Long.parseLong(iswebs));
			Server.getInstance().getMemberService().createInformationinfo(
					informationinfo);
		} else {
			informationinfo.setName(m_name);
			informationinfo.setIsanswer(Long.parseLong(isanswers));
			informationinfo.setIsweb(Long.parseLong(iswebs));
			Server.getInstance().getMemberService().createInformationinfo(
					informationinfo);
		}

		return LIST;
	}

	/**
	 * 审核资讯中心详细信息
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService()
				.updateInformationinfoIgnoreNull(informationinfo);
		return LIST;
	}

	/**
	 * 编辑资讯中心详细信息
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService()
				.updateInformationinfoIgnoreNull(informationinfo);
		return LIST;
	}

	/**
	 * 删除资讯中心详细信息
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteInformationinfo(
				informationinfo.getId());
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
							.deleteInformationinfo(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回资讯中心详细信息对象
	 */

	public Object getModel() {
		return informationinfo;
	}

	public List<Informationinfo> getListInformationinfo() {
		return listInformationinfo;
	}

	public void setListInformationinfo(List<Informationinfo> listInformationinfo) {
		this.listInformationinfo = listInformationinfo;
	}

	public Informationinfo getInformationinfo() {
		return informationinfo;
	}

	public void setInformationinfo(Informationinfo informationinfo) {
		this.informationinfo = informationinfo;
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

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

}