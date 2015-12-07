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
import com.yf.system.base.customercredit.Customercredit;

public class CustomercreditAction extends B2b2cbackAction {
	private static final long serialVersionUID = -4265329030913787049L;
	private List<Customercredit> listCustomercredit;
	private Customercredit customercredit = new Customercredit();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// 跳转路径
	private String forward;
	// search
	// private String s_name;

	/**
	 * 列表查询证件
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";
		if (customercredit.getRefid() != null && customercredit.getRefid() > 0) {
			where += " and " + Customercredit.COL_refid + "="
					+ customercredit.getRefid();
		} else {
			return ERROR;
		}		
		if (customercredit.getCredittypeid() != null && customercredit.getCredittypeid() > 0) {
			where += " and " + Customercredit.COL_credittypeid + "=" + customercredit.getCredittypeid();
		}
		
		if (customercredit.getType() != null && customercredit.getType() >= 0) {
			where += " and " + Customercredit.COL_type + "=" + customercredit.getType();
		}
		List list = Server.getInstance().getMemberService()
				.findAllCustomercreditForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomercredit = list;
		if (pageinfo.getTotalrow() > 0 && listCustomercredit.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomercreditForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomercredit = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到证件添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到证件修改页面
	 */
	public String toedit() throws Exception {
		customercredit = Server.getInstance().getMemberService()
				.findCustomercredit(customercredit.getId());
		return EDIT;
	}

	/**
	 * 转向到证件审核页面
	 */
	public String tocheck() throws Exception {
		customercredit = Server.getInstance().getMemberService()
				.findCustomercredit(customercredit.getId());
		return CHECK;
	}

	/**
	 * 添加证件
	 */
	public String add() throws Exception {
		customercredit.setCreateuser(getLoginUser().getLoginname());
		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifyuser(getLoginUser().getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().createCustomercredit(
				customercredit);
		forward = "customeruser!tochakan.action?id="+ customercredit.getRefid();
		return "list2";
	}

	/**
	 * 审核证件
	 */
	public String check() throws Exception {
		customercredit.setModifyuser(getLoginUser().getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateCustomercreditIgnoreNull(
				customercredit);
		return LIST;
	}

	/**
	 * 编辑证件
	 */
	public String edit() throws Exception {
		customercredit.setModifyuser(getLoginUser().getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateCustomercreditIgnoreNull(
				customercredit);
		forward = "customeruser!tochakan.action?id=" + customercredit.getRefid();
		return "list2";
	}

	/**
	 * 删除证件
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteCustomercredit(
				customercredit.getId());
		forward = "customeruser!tochakan.action?id=" + customercredit.getRefid();
		return "list2";
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
							.deleteCustomercredit(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回证件对象
	 */

	public Object getModel() {
		return customercredit;
	}

	public List<Customercredit> getListCustomercredit() {
		return listCustomercredit;
	}

	public void setListCustomercredit(List<Customercredit> listCustomercredit) {
		this.listCustomercredit = listCustomercredit;
	}

	public Customercredit getCustomercredit() {
		return customercredit;
	}

	public void setCustomercredit(Customercredit customercredit) {
		this.customercredit = customercredit;
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

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

}