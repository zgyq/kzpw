/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dataprovide.Dataprovide;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class DataprovideAction extends B2b2cbackAction {
	private List<Dataprovide> listDataprovide;
	private Dataprovide dataprovide = new Dataprovide();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;
	private String mingcheng;

	private String types;

	private String dataid;

	// search
	// private String s_name;

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	/**
	 * 列表查询酒店数据提供商
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		if (mingcheng != null && mingcheng.trim().length() != 0) {

			where += " and " + Dataprovide.COL_dataprovidename + " like '%"
					+ mingcheng.trim() + "%'";
		}

		List list = Server
				.getInstance()
				.getHotelService()
				.findAllDataprovideForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listDataprovide = list;
		if (pageinfo.getTotalrow() > 0 && listDataprovide.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllDataprovideForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listDataprovide = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到酒店数据提供商添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到酒店数据提供商修改页面
	 */
	public String toedit() throws Exception {
		dataprovide = Server.getInstance().getHotelService().findDataprovide(
				dataprovide.getId());
		return EDIT;
	}

	/**
	 * 转向到酒店数据提供商审核页面
	 */
	public String tocheck() throws Exception {
		dataprovide = Server.getInstance().getHotelService().findDataprovide(
				dataprovide.getId());
		return CHECK;
	}

	/**
	 * 添加酒店数据提供商
	 */
	public String add() throws Exception {
		dataprovide.setCreatetime(new Timestamp(System.currentTimeMillis()));
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser customeruser = (Customeruser) session
				.getAttribute("loginuser");
		dataprovide.setCreatemanid(customeruser.getId());
		Server.getInstance().getHotelService().createDataprovide(dataprovide);
		return LIST;
	}

	/**
	 * 审核酒店数据提供商
	 */
	public String check() throws Exception {

		Server.getInstance().getHotelService().updateDataprovideIgnoreNull(
				dataprovide);
		return LIST;
	}

	/**
	 * 编辑酒店数据提供商
	 */
	public String edit() throws Exception {

		Server.getInstance().getHotelService().updateDataprovideIgnoreNull(
				dataprovide);
		return LIST;
	}

	/**
	 * 删除酒店数据提供商
	 */
	public String delete() throws Exception {
		Server.getInstance().getHotelService().deleteDataprovide(
				dataprovide.getId());
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
					Server.getInstance().getHotelService().deleteDataprovide(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	// 跳转到添加星级页面
	public String toaddStar() {
		String where = " where 1=1 ";
		listDataprovide = Server.getInstance().getHotelService()
				.findAllDataprovide(where, " order by id", -1, 0);
		return "toaddstar";
	}

	// 状态修改
	public String updateState() throws Exception {
		String type = new String(types.getBytes("iso-8859-1"), "utf-8");
		if (type.equals("启用")) {
			dataprovide = Server.getInstance().getHotelService()
					.findDataprovide(Integer.parseInt(dataid));
			long e = 1;
			dataprovide.setState(e);
			Server.getInstance().getHotelService().updateDataprovide(
					dataprovide);

		} else if (type.equals("禁用")) {
			dataprovide = Server.getInstance().getHotelService()
					.findDataprovide(Integer.parseInt(dataid));
			long e = 2;
			dataprovide.setState(e);
			Server.getInstance().getHotelService().updateDataprovide(
					dataprovide);
		}
		return execute();
	}

	/**
	 * 返回酒店数据提供商对象
	 */

	public Object getModel() {
		return dataprovide;
	}

	public List<Dataprovide> getListDataprovide() {
		return listDataprovide;
	}

	public void setListDataprovide(List<Dataprovide> listDataprovide) {
		this.listDataprovide = listDataprovide;
	}

	public Dataprovide getDataprovide() {
		return dataprovide;
	}

	public void setDataprovide(Dataprovide dataprovide) {
		this.dataprovide = dataprovide;
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