/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.util.List;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import com.yf.system.base.util.PageInfo;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dataprovide.Dataprovide;
import com.yf.system.base.hotelstart.Hotelstart;
import com.opensymphony.webwork.ServletActionContext;

public class HotelstartAction extends B2b2cbackAction {
	private List<Hotelstart> listHotelstart;//星级返利list集合
	private List<Dataprovide> listDataprovide;//酒店数据提供商list集合
	private Hotelstart hotelstart = new Hotelstart();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;
	private String dataid;
	private String types;//状态修改

	private String xingji;//星级
	private String shuju;//数据提供商
	// search
	// private String s_name;

	/**
	 * 列表查询酒店星级返利
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		if (xingji!=null && xingji.trim().length()!=0) {

		 where += " and " + Hotelstart.COL_hotestart +" ='" +
		 xingji.trim()+"'";
		 }
		
		if (shuju!=null && shuju.trim().length()!=0) {

			 where += " and " + Hotelstart.COL_dataprovideid +" = " +
			 shuju.trim()+"";
		}
		String wheres=" where 1=1 ";
		listDataprovide=Server.getInstance().getHotelService().findAllDataprovide(wheres, " order by id ", -1, 0);
		List list = Server.getInstance().getHotelService()
				.findAllHotelstartForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotelstart = list;
		if (pageinfo.getTotalrow() > 0 && listHotelstart.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelstartForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotelstart = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到酒店星级返利添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到酒店星级返利修改页面
	 */
	public String toedit() throws Exception {
		String where = " where 1=1 ";
		listDataprovide = Server.getInstance().getHotelService()
				.findAllDataprovide(where, " order by id", -1, 0);
		hotelstart = Server.getInstance().getHotelService().findHotelstart(
				hotelstart.getId());
		return EDIT;
	}

	/**
	 * 转向到酒店星级返利审核页面
	 */
	public String tocheck() throws Exception {
		hotelstart = Server.getInstance().getHotelService().findHotelstart(
				hotelstart.getId());
		return CHECK;
	}

	/**
	 * 添加酒店星级返利
	 */
	public String add() throws Exception {
		hotelstart.setCreatetime(new Timestamp(System.currentTimeMillis()));
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser costomeruser = (Customeruser) session
				.getAttribute("loginuser");
		hotelstart.setCreatemanid(costomeruser.getId());
		Server.getInstance().getHotelService().createHotelstart(hotelstart);
		return LIST;
	}

	/**
	 * 审核酒店星级返利
	 */
	public String check() throws Exception {

		Server.getInstance().getHotelService().updateHotelstartIgnoreNull(
				hotelstart);
		return LIST;
	}

	/**
	 * 编辑酒店星级返利
	 */
	public String edit() throws Exception {

		Server.getInstance().getHotelService().updateHotelstartIgnoreNull(
				hotelstart);
		return LIST;
	}
	public String getDataproviceName(long id){
		return Server.getInstance().getHotelService().findDataprovide(id).getDataprovidename();
	}
	/**
	 * 删除酒店星级返利
	 */
	public String delete() throws Exception {
		Server.getInstance().getHotelService().deleteHotelstart(
				hotelstart.getId());
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
					Server.getInstance().getHotelService().deleteHotelstart(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}
	//状态修改
	public String updateState() throws Exception{
		String type = new String(types.getBytes("iso-8859-1"),"utf-8");
		if(type.equals("启用")){
			hotelstart=Server.getInstance().getHotelService().findHotelstart(Integer.parseInt(dataid));
			long e=1;
			hotelstart.setState(e);
			Server.getInstance().getHotelService().updateHotelstart(hotelstart);
				
		}else if(type.equals("禁用")){
			hotelstart=Server.getInstance().getHotelService().findHotelstart(Integer.parseInt(dataid));
			long e=2;
			hotelstart.setState(e);
			Server.getInstance().getHotelService().updateHotelstart(hotelstart);
		}
			return execute();
	}
	/**
	 * 返回酒店星级返利对象
	 */

	public Object getModel() {
		return hotelstart;
	}

	public List<Hotelstart> getListHotelstart() {
		return listHotelstart;
	}

	public void setListHotelstart(List<Hotelstart> listHotelstart) {
		this.listHotelstart = listHotelstart;
	}

	public Hotelstart getHotelstart() {
		return hotelstart;
	}

	public void setHotelstart(Hotelstart hotelstart) {
		this.hotelstart = hotelstart;
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

	public List<Dataprovide> getListDataprovide() {
		return listDataprovide;
	}

	public void setListDataprovide(List<Dataprovide> listDataprovide) {
		this.listDataprovide = listDataprovide;
	}

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

	public String getXingji() {
		return xingji;
	}

	public void setXingji(String xingji) {
		this.xingji = xingji;
	}

	public String getShuju() {
		return shuju;
	}

	public void setShuju(String shuju) {
		this.shuju = shuju;
	}



}