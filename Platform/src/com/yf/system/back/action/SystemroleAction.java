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
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.bussiness.Bussiness;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.systemrole.Systemrole;

public class SystemroleAction extends B2b2cbackAction {
	private List<Systemrole> listSystemrole;
	private List<Systemright> listSysright;
	private Systemrole systemrole = new Systemrole();
	private List<Agentroleref> listAgentroleref;
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	private String s_rolename;

	/**
	 * 列表查询系统角色
	 */
	public String execute() throws Exception {
		StringBuilder roleid=new StringBuilder("0");
		for(Bussiness bussiness:this.getLoginsessionagent().getBussinesslist()){
			roleid.append(","+bussiness.getId());
		}
		String where="WHERE 1=1  AND C_BUSSINESSID IN ("+roleid+") ";
		if(s_rolename!=null&&s_rolename.length()>0){
			where+=" and "+Systemrole.COL_name+" like '%"+s_rolename+"%'";
		}
		
		if (this.getLoginUser().getId() > 1) {
			if (!this.isAdmin()) {// 有系统管理员角色
				where += "  AND ( C_CUSTOMERAGENTID="
						+ getLoginUser().getAgentid() + " OR ( C_TYPE="
						+ this.getLoginsessionagent().getAgenttype()
						+ " AND C_CUSTOMERAGENTID=46 ))";

			}
			List<Long> roles = this.getLoginUserRoleNumber();
			StringBuilder rolestr = new StringBuilder("-1");
			for (long role : roles) {
				rolestr.append(","+role);
			}
			where+=" AND ID NOT IN ("+rolestr.toString()+") ";
		}
		listSystemrole = Server.getInstance().getMemberService()
				.findAllSystemrole(where, " ORDER BY ID DESC ", -1, 0);

		return SUCCESS;
	}
	

	/**
	 * 转到给角色赋权的页面
	 */
	/*
	 * public String tofuquan()throws Exception{ String where = " where 1=1 ";
	 * 
	 * //if (s_name!=null && s_name.trim().length()!=0) {
	 * 
	 * //where += " and " + Sysroleright.COL_name +" like '%" +
	 * s_name.trim()+"%'"; //}
	 * 
	 * List list =
	 * Server.getInstance().getMemberService().findAllSystemrightForPageinfo(where,"
	 * ORDER BY ID ",pageinfo); pageinfo = (PageInfo)list.remove(0);
	 * listSysright = list; if(pageinfo.getTotalrow()>0 &&
	 * listSysright.size()==0){ pageinfo.setPagenum(1); list =
	 * Server.getInstance().getMemberService().findAllSystemrightForPageinfo(where,"
	 * ORDER BY ID ",pageinfo); pageinfo = (PageInfo)list.remove(0);
	 * listSysright = list; }
	 * 
	 * return "tofuquan"; }
	 */

	/**
	 * 转向到系统角色添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到系统角色修改页面
	 */
	public String toedit() throws Exception {
		systemrole = Server.getInstance().getMemberService().findSystemrole(
				systemrole.getId());
		return EDIT;
	}

	/**
	 * 转向到系统角色审核页面
	 */
	public String tocheck() throws Exception {
		systemrole = Server.getInstance().getMemberService().findSystemrole(
				systemrole.getId());
		return CHECK;
	}

	/**
	 * 添加系统角色
	 */
	public String add() throws Exception {
		systemrole.setCreateuser(getLoginUser().getLoginname());
		systemrole.setCustomeragentid(getLoginUser().getAgentid());

		systemrole.setCreatetime(new Timestamp(System.currentTimeMillis()));
		systemrole.setModifyuser(getLoginUser().getLoginname());

		systemrole.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().createSystemrole(systemrole);
		return LIST;
	}

	/**
	 * 审核系统角色
	 */
	public String check() throws Exception {
		systemrole.setModifyuser(getLoginUser().getLoginname());
		systemrole.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateSystemroleIgnoreNull(
				systemrole);
		return LIST;
	}

	/**
	 * 编辑系统角色
	 */
	public String edit() throws Exception {
		systemrole.setModifyuser(getLoginUser().getLoginname());
		systemrole.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService().updateSystemroleIgnoreNull(
				systemrole);
		return LIST;
	}

	/**
	 * 删除系统角色
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteSystemrole(
				systemrole.getId());
		//删除角色权限关联表
		String sql=" delete "+Sysroleright.TABLE+" where "+Sysroleright.COL_roleid+" ="+systemrole.getId();
		Server.getInstance().getMemberService().excuteSysrolerightBySql(sql);
		//删除用户角色表
		String sql2=" delete "+Agentroleref.TABLE+" where "+Agentroleref.COL_roleid+" ="+systemrole.getId();
		Server.getInstance().getMemberService().excuteAgentrolerefBySql(sql2);
		
		
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
					// 这些角色不能删除
					if (i == 1 || i == 10035 || i == 10036 || i == 10062
							|| i == 10063) {

					} else {
						Server.getInstance().getMemberService()
								.deleteSystemrole(i);
						
						//删除角色权限关联表
						String sql=" delete "+Sysroleright.TABLE+" where "+Sysroleright.COL_roleid+" ="+i;
						Server.getInstance().getMemberService().excuteSysrolerightBySql(sql);
						//删除用户角色表
						String sql2=" delete "+Agentroleref.TABLE+" where "+Agentroleref.COL_roleid+" ="+i;
						Server.getInstance().getMemberService().excuteAgentrolerefBySql(sql2);
						
					}
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回系统角色对象
	 */

	public Object getModel() {
		return systemrole;
	}

	public List<Systemrole> getListSystemrole() {
		return listSystemrole;
	}

	public void setListSystemrole(List<Systemrole> listSystemrole) {
		this.listSystemrole = listSystemrole;
	}

	public Systemrole getSystemrole() {
		return systemrole;
	}

	public void setSystemrole(Systemrole systemrole) {
		this.systemrole = systemrole;
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

	public List<Systemright> getListSysright() {
		return listSysright;
	}

	public void setListSysright(List<Systemright> listSysright) {
		this.listSysright = listSysright;
	}

	public List<Agentroleref> getListAgentroleref() {
		return listAgentroleref;
	}

	public void setListAgentroleref(List<Agentroleref> listAgentroleref) {
		this.listAgentroleref = listAgentroleref;
	}

	public String getS_rolename() {
		return s_rolename;
	}

	public void setS_rolename(String s_rolename) {
		this.s_rolename = s_rolename;
	}

}