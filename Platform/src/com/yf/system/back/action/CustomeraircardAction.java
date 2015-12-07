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
import com.yf.system.base.customeraircard.Customeraircard;

public class CustomeraircardAction extends B2b2cbackAction {
	private List<Customeraircard> listCustomeraircard;
	private Customeraircard customeraircard = new Customeraircard();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询里程卡
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Customeraircard.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		if (customeraircard.getRefid() != null
				&& customeraircard.getRefid() > 0) {
			where += " and " + Customeraircard.COL_refid + "="
					+ customeraircard.getRefid();
		} else {
			return ERROR;
		}
		List list = Server.getInstance().getAirService()
				.findAllCustomeraircardForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeraircard = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeraircard.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllCustomeraircardForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeraircard = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到里程卡添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到里程卡修改页面
	 */
	public String toedit() throws Exception {
		customeraircard = Server.getInstance().getAirService()
				.findCustomeraircard(customeraircard.getId());
		return EDIT;
	}

	/**
	 * 转向到里程卡审核页面
	 */
	public String tocheck() throws Exception {
		customeraircard = Server.getInstance().getAirService()
				.findCustomeraircard(customeraircard.getId());
		return CHECK;
	}

	/**
	 * 添加里程卡
	 */
	public String add() throws Exception {
		customeraircard.setCreateuser(getLoginUser().getLoginname());
		customeraircard
				.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeraircard.setModifyuser(getLoginUser().getLoginname());
		customeraircard
				.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().createCustomeraircard(
				customeraircard);
		return LIST;
	}

	/**
	 * 审核里程卡
	 */
	public String check() throws Exception {
		customeraircard.setModifyuser(getLoginUser().getLoginname());
		customeraircard
				.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateCustomeraircardIgnoreNull(
				customeraircard);
		return LIST;
	}

	/**
	 * 编辑里程卡
	 */
	public String edit() throws Exception {
		customeraircard.setModifyuser(getLoginUser().getLoginname());
		customeraircard
				.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateCustomeraircardIgnoreNull(
				customeraircard);
		return LIST;
	}

	/**
	 * 删除里程卡
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteCustomeraircard(
				customeraircard.getId());
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
					Server.getInstance().getAirService().deleteCustomeraircard(
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
	 * 返回里程卡对象
	 */

	public Object getModel() {
		return customeraircard;
	}

	public List<Customeraircard> getListCustomeraircard() {
		return listCustomeraircard;
	}

	public void setListCustomeraircard(List<Customeraircard> listCustomeraircard) {
		this.listCustomeraircard = listCustomeraircard;
	}

	public Customeraircard getCustomeraircard() {
		return customeraircard;
	}

	public void setCustomeraircard(Customeraircard customeraircard) {
		this.customeraircard = customeraircard;
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