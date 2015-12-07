/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.back.services.CustomeragentService;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.vmoneyrecord.Vmoneyrecord;
import com.opensymphony.webwork.ServletActionContext;

public class VmoneyrecordAction extends B2b2cbackAction {
	private List<Vmoneyrecord> listVmoneyrecord;
	private Vmoneyrecord vmoneyrecord = new Vmoneyrecord();
	private long s_agentid;
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;
	private float s_vmoney;

	// search
	// private String s_name;

	/**
	 * 列表查询虚拟账户充值记录
	 */
	public String execute() throws Exception {
		Customeragent agent = null;
		if (s_agentid==0) {//当前登录者。
			agent = this.getLoginsessionagent();
			CustomeragentService service=new CustomeragentServiceImpl();
			agent.setVmoney(service.getTotalVmoney(agent.getId()));//获得实时虚拟账户余额
		}else{
			agent=Server.getInstance().getMemberService().findCustomeragent(s_agentid);
		}
		String where = " where 1=1 and " + Vmoneyrecord.COL_agentid + "="+agent.getId();
		List list = Server.getInstance().getMemberService()
				.findAllVmoneyrecordForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listVmoneyrecord = list;
		if (pageinfo.getTotalrow() > 0 && listVmoneyrecord.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllVmoneyrecordForPageinfo(where, " ORDER BY ID DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listVmoneyrecord = list;
		}
		ServletActionContext.getRequest().setAttribute("agent", agent);
		return SUCCESS;
	}

	// 显示虚拟账户金额修改页面
	public String addVmoneyPage() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
	 if(this.getLoginsessionagent().getAgenttype()==1){
		 if(s_vmoney>0){
			try{
			// 记录充值操作记录
			
			vmoneyrecord.setAgentid(this.s_agentid);
			vmoneyrecord.setCreateuserid(getLoginUser().getId());
			vmoneyrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
			vmoneyrecord.setMoney(s_vmoney);
			System.out.println(vmoneyrecord.getOrdernumber());
			System.out.println(vmoneyrecord.getType());
			Server.getInstance().getMemberService()
					.createVmoneyrecord(vmoneyrecord);
			String sql="UPDATE T_CUSTOMERAGENT SET C_VMONEY=C_VMONEY+"+s_vmoney+" WHERE ID="+this.s_agentid;
			Server.getInstance().getSystemService().findMapResultBySql(sql, null);
			}catch(Exception e){
				
				request.setAttribute("message", "由于网路原因导致充值失败，请重新尝试账户充值！");
			}
		 }else{
			 
				request.setAttribute("message", "充值金额请确保大于0！");
		 }
			
	 }else{
		  request.setAttribute("message", "非平台操作人员无法执行充值操作！");
	 }
		return this.execute();
	}

	/**
	 * 转向到虚拟账户充值记录添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到虚拟账户充值记录修改页面
	 */
	public String toedit() throws Exception {
		vmoneyrecord = Server.getInstance().getMemberService()
				.findVmoneyrecord(vmoneyrecord.getId());
		return EDIT;
	}

	/**
	 * 转向到虚拟账户充值记录审核页面
	 */
	public String tocheck() throws Exception {
		vmoneyrecord = Server.getInstance().getMemberService()
				.findVmoneyrecord(vmoneyrecord.getId());
		return CHECK;
	}

	/**
	 * 添加虚拟账户充值记录
	 */
	public String add() throws Exception {
		vmoneyrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getMemberService()
				.createVmoneyrecord(vmoneyrecord);
		return LIST;
	}

	/**
	 * 审核虚拟账户充值记录
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateVmoneyrecordIgnoreNull(
				vmoneyrecord);
		return LIST;
	}

	/**
	 * 编辑虚拟账户充值记录
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateVmoneyrecordIgnoreNull(
				vmoneyrecord);
		return LIST;
	}

	/**
	 * 删除虚拟账户充值记录
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteVmoneyrecord(
				vmoneyrecord.getId());
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
					Server.getInstance().getMemberService().deleteVmoneyrecord(
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
	 * 返回虚拟账户充值记录对象
	 */

	public Object getModel() {
		return vmoneyrecord;
	}

	public List<Vmoneyrecord> getListVmoneyrecord() {
		return listVmoneyrecord;
	}

	public void setListVmoneyrecord(List<Vmoneyrecord> listVmoneyrecord) {
		this.listVmoneyrecord = listVmoneyrecord;
	}

	public Vmoneyrecord getVmoneyrecord() {
		return vmoneyrecord;
	}

	public void setVmoneyrecord(Vmoneyrecord vmoneyrecord) {
		this.vmoneyrecord = vmoneyrecord;
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

	public long getS_agentid() {
		return s_agentid;
	}

	public void setS_agentid(long s_agentid) {
		this.s_agentid = s_agentid;
	}

	public float getS_vmoney() {
		return s_vmoney;
	}

	public void setS_vmoney(float s_vmoney) {
		this.s_vmoney = s_vmoney;
	}

}