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
import com.yf.system.base.airbaseprice.Airbaseprice;
import com.yf.system.base.util.PageInfo;

public class AirbasepriceAction extends B2b2cbackAction {
	private static final long serialVersionUID = 164528570265645814L;
	private List<Airbaseprice> listAirbaseprice;
	private Airbaseprice airbaseprice = new Airbaseprice();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	private String a_startdate;
	private String a_enddate;

	// search
	// private String s_name;

	/**
	 * 列表查询机票基础价格表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Airbaseprice.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		if (airbaseprice.getSairportcode() != null
				&& !"".equals(airbaseprice.getSairportcode())) {
			where += " and " + Airbaseprice.COL_sairportcode + " like '%"
					+ airbaseprice.getSairportcode() + "%'";
		}

		if (airbaseprice.getEairportcode() != null
				&& !"".equals(airbaseprice.getEairportcode())) {
			where += " and " + Airbaseprice.COL_eairportcode + " like '%"
					+ airbaseprice.getEairportcode() + "%'";
		}

		
		List list = Server.getInstance().getAirService()
				.findAllAirbasepriceForPageinfo(where, " ORDER BY ID  DESC ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listAirbaseprice = list;
		if (pageinfo.getTotalrow() > 0 && listAirbaseprice.size() == 0) {
			if (pageinfo.getPagenum() <= 1) {
				pageinfo.setPagenum(1);
			}
			list = Server.getInstance().getAirService()
					.findAllAirbasepriceForPageinfo(where, " ORDER BY ID DESC ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listAirbaseprice = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到机票基础价格表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到机票基础价格表修改页面
	 */
	public String toedit() throws Exception {
		airbaseprice = Server.getInstance().getAirService().findAirbaseprice(
				airbaseprice.getId());
		return EDIT;
	}

	/**
	 * 转向到机票基础价格表审核页面
	 */
	public String docheck() throws Exception {
		airbaseprice = Server.getInstance().getAirService().findAirbaseprice(
				airbaseprice.getId());
		if (airbaseprice.getIsenable() == 1) {
			airbaseprice.setIsenable(0);
		} else {
			airbaseprice.setIsenable(1);
		}
		Server.getInstance().getAirService().updateAirbasepriceIgnoreNull(
				airbaseprice);

		return "list2";
	}

	/**
	 * 添加机票基础价格表
	 */
	public String add() throws Exception {
		airbaseprice.setCreateuser(getLoginUser().getLoginname());
		airbaseprice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		airbaseprice.setModifyuser(getLoginUser().getLoginname());
		airbaseprice.setModifytime(new Timestamp(System.currentTimeMillis()));
		airbaseprice.setStartdate(dateToTimestamp(a_startdate));
		airbaseprice.setEnddate(dateToTimestamp(a_enddate));
		airbaseprice.setLanguage(0);
		Server.getInstance().getAirService().createAirbaseprice(airbaseprice);
		return LIST;
	}

	/**
	 * 审核机票基础价格表
	 */
	public String check() throws Exception {
		airbaseprice.setModifyuser(getLoginUser().getLoginname());
		airbaseprice.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateAirbasepriceIgnoreNull(
				airbaseprice);
		return LIST;
	}

	/**
	 * 编辑机票基础价格表
	 */
	public String edit() throws Exception {
		airbaseprice.setModifyuser(getLoginUser().getLoginname());
		airbaseprice.setModifytime(new Timestamp(System.currentTimeMillis()));
		airbaseprice.setStartdate(dateToTimestamp(a_startdate));
		airbaseprice.setEnddate(dateToTimestamp(a_enddate));
		Server.getInstance().getAirService().updateAirbasepriceIgnoreNull(
				airbaseprice);
		return LIST;
	}

	/**
	 * 删除机票基础价格表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteAirbaseprice(
				airbaseprice.getId());
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
					Server.getInstance().getAirService().deleteAirbaseprice(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回机票基础价格表对象
	 */

	public Object getModel() {
		return airbaseprice;
	}

	public List<Airbaseprice> getListAirbaseprice() {
		return listAirbaseprice;
	}

	public void setListAirbaseprice(List<Airbaseprice> listAirbaseprice) {
		this.listAirbaseprice = listAirbaseprice;
	}

	public Airbaseprice getAirbaseprice() {
		return airbaseprice;
	}

	public void setAirbaseprice(Airbaseprice airbaseprice) {
		this.airbaseprice = airbaseprice;
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

	public String getA_startdate() {
		return a_startdate;
	}

	public void setA_startdate(String a_startdate) {
		this.a_startdate = a_startdate;
	}

	public String getA_enddate() {
		return a_enddate;
	}

	public void setA_enddate(String a_enddate) {
		this.a_enddate = a_enddate;
	}

}