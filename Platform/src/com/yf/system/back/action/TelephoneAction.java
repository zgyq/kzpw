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
import com.yf.system.base.telephone.Telephone;

public class TelephoneAction extends B2b2cbackAction {
	private static final long serialVersionUID = 8251188380920046228L;
	private List<Telephone> listTelephone;
	private Telephone telephone = new Telephone();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询其他电话
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Telephone.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		if (telephone.getCustomeruserid() != null
				&& telephone.getCustomeruserid() > 0) {
			where += " and " + Telephone.COL_customeruserid + "="
					+ telephone.getCustomeruserid();
		} else {
			return ERROR;
		}
		List list = Server.getInstance().getMemberService()
				.findAllTelephoneForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listTelephone = list;
		if (pageinfo.getTotalrow() > 0 && listTelephone.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllTelephoneForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listTelephone = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到其他电话添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到其他电话修改页面
	 */
	public String toedit() throws Exception {
		telephone = Server.getInstance().getMemberService().findTelephone(
				telephone.getId());
		return EDIT;
	}

	/**
	 * 转向到其他电话审核页面
	 */
	public String tocheck() throws Exception {
		telephone = Server.getInstance().getMemberService().findTelephone(
				telephone.getId());
		return CHECK;
	}

	/**
	 * 添加其他电话
	 */
	public String add() throws Exception {
		telephone.setCreateuser(getLoginUser().getLoginname());
		telephone.setCreatetime(new Timestamp(System.currentTimeMillis()));
		telephone.setModifyuser(getLoginUser().getLoginname());
		telephone.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().createTelephone(telephone);
		return LIST;
	}

	/**
	 * 审核其他电话
	 */
	public String check() throws Exception {
		telephone.setModifyuser(getLoginUser().getLoginname());
		telephone.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateTelephoneIgnoreNull(
				telephone);
		return LIST;
	}

	/**
	 * 编辑其他电话
	 */
	public String edit() throws Exception {
		telephone.setModifyuser(getLoginUser().getLoginname());
		telephone.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateTelephoneIgnoreNull(
				telephone);
		return LIST;
	}

	/**
	 * 删除其他电话
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteTelephone(
				telephone.getId());
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
					Server.getInstance().getMemberService().deleteTelephone(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回其他电话对象
	 */

	public Object getModel() {
		return telephone;
	}

	public List<Telephone> getListTelephone() {
		return listTelephone;
	}

	public void setListTelephone(List<Telephone> listTelephone) {
		this.listTelephone = listTelephone;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
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

}