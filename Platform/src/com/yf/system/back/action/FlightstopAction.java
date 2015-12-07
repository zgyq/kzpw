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
import com.yf.system.base.flightstop.Flightstop;
import com.yf.system.base.util.PageInfo;

public class FlightstopAction extends B2b2cbackAction {
	private static final long serialVersionUID = -6308959668406721315L;
	private List<Flightstop> listFlightstop;
	private Flightstop flightstop = new Flightstop();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询航班经停信息
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Flightstop.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		if (flightstop.getSairportcode() != null
				&& !"".equals(flightstop.getSairportcode())) {
			where += " and " + Flightstop.COL_sairportcode + " like '%"
					+ flightstop.getSairportcode() + "%'";
		}

		if (flightstop.getEairportcode() != null
				&& !"".equals(flightstop.getEairportcode())) {
			where += " and " + Flightstop.COL_eairportcode + " like '%"
					+ flightstop.getEairportcode() + "%'";
		}

		if (flightstop.getCity() != null
				&& !"".equals(flightstop.getCity())) {
			where += " and " + Flightstop.COL_city + " like '%"
					+ flightstop.getCity() + "%'";
		}

		if (flightstop.getFlightnumber() != null
				&& !"".equals(flightstop.getFlightnumber())) {
			where += " and " + Flightstop.COL_flightnumber + " like '%"
					+ flightstop.getFlightnumber() + "%'";
		}
		
		List list = Server.getInstance().getAirService()
				.findAllFlightstopForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listFlightstop = list;
		if (pageinfo.getTotalrow() > 0 && listFlightstop.size() == 0) {
			if (pageinfo.getPagenum() <= 1) {
				pageinfo.setPagenum(1);
			}
			list = Server.getInstance().getAirService()
					.findAllFlightstopForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listFlightstop = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到航班经停信息添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到航班经停信息修改页面
	 */
	public String toedit() throws Exception {
		flightstop = Server.getInstance().getAirService().findFlightstop(
				flightstop.getId());
		return EDIT;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=flightstop.getLanguage();
		Long uco=flightstop.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		flightstop = Server.getInstance().getAirService().findFlightstopbylanguage(flightstop.getUcode(),flightstop.getLanguage());
		if(flightstop==null)
		{
			flightstop=new Flightstop();
			flightstop.setLanguage(lan);
			flightstop.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
		}
		return EDIT;
	}

	/**
	 * 转向到航班经停信息审核页面
	 */
	public String docheck() throws Exception {
		flightstop = Server.getInstance().getAirService().findFlightstop(
				flightstop.getId());
		if (flightstop.getIsenable() == 1) {
			flightstop.setIsenable(0);
		} else {
			flightstop.setIsenable(1);
		}
		Server.getInstance().getAirService().updateFlightstopIgnoreNull(flightstop);
		return "list2";
	}

	/**
	 * 添加航班经停信息
	 */
	public String add() throws Exception {
		flightstop.setCreateuser(getLoginUser().getLoginname());
		flightstop.setCreatetime(new Timestamp(System.currentTimeMillis()));
		flightstop.setModifyuser(getLoginUser().getLoginname());
		flightstop.setModifytime(new Timestamp(System.currentTimeMillis()));

		flightstop=Server.getInstance().getAirService().createFlightstop(flightstop);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 审核航班经停信息
	 */
	public String check() throws Exception {
		flightstop.setModifyuser(getLoginUser().getLoginname());
		flightstop.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateFlightstopIgnoreNull(
				flightstop);
		return LIST;
	}

	/**
	 * 编辑航班经停信息
	 */
	public String edit() throws Exception {
		flightstop.setModifyuser(getLoginUser().getLoginname());
		flightstop.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateFlightstopIgnoreNull(
				flightstop);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 删除航班经停信息
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteFlightstop(
				flightstop.getId());
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
					Server.getInstance().getAirService().deleteFlightstop(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回航班经停信息对象
	 */

	public Object getModel() {
		return flightstop;
	}

	public List<Flightstop> getListFlightstop() {
		return listFlightstop;
	}

	public void setListFlightstop(List<Flightstop> listFlightstop) {
		this.listFlightstop = listFlightstop;
	}

	public Flightstop getFlightstop() {
		return flightstop;
	}

	public void setFlightstop(Flightstop flightstop) {
		this.flightstop = flightstop;
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