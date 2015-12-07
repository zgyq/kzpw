/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.back.services.CustomeragentService;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.bak.excel.HthyWorkSheet;
import com.yf.system.bak.excel.HthyWritableWorkBook;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.rebaterecord.Rebaterecord;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

public class RebaterecordAction extends B2b2cbackAction {
	private List<Rebaterecord> listRebaterecord;
	private Rebaterecord rebaterecord = new Rebaterecord();
//	private long s_agentid;
	private String recharestime;
	private String rechareetime;
	private boolean isExp = false;
	private Customeragent customeragent=new Customeragent();

	/**
	 * 到充值页面
	 */
	public String execute() throws Exception {
		Customeragent agent = null;
		if ( rebaterecord.getRebateagentid()== 0|| rebaterecord.getRebateagentid()==this.getLoginUser().getAgentid()) {// 当前登录者。
			agent = this.getLoginsessionagent();
			CustomeragentService service = new CustomeragentServiceImpl();
			agent.setVmoney(service.getTotalVmoney(agent.getId()));// 获得实时虚拟账户余额
			rebaterecord.setRebateagentid(agent.getId());
		} else {
			String sql = "SELECT  " + Customeragent.COL_agentcompanyname
					+ " agentcompanyname, C_VMONEY "
					+ "  vmoney FROM T_CUSTOMERAGENT WHERE ID=" + rebaterecord.getRebateagentid();
			agent = this.findBySql(Customeragent.class, sql);
			agent.setId(rebaterecord.getRebateagentid());
		}
		ServletActionContext.getRequest().setAttribute("agent", agent);
		return SUCCESS;
	}
	
	/**
	 * 到充值记录列表
	 * @return
	 */
	public String torebaterecord(){	
		
		if(rebaterecord.getRebateagentid()==0){
			rebaterecord.setRebateagentid(this.getLoginUser().getAgentid());
		}
		StringBuilder where = new StringBuilder(" where 1=1 ");

		if (isNotNullOrEpt(rebaterecord.getCustomername())) {
			where
					.append(" AND "
							+ rebaterecord.COL_customerid
							+ " IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ rebaterecord.getCustomername() + "%') ");
		}
		if (rebaterecord.getRebatetype() > 0) {
			if (rebaterecord.getRebatetype() == 3) {
				where.append(" AND  C_REBATETYPE=3 AND C_PAYSTATE=1");
			} else {

				where.append(" AND C_REBATETYPE=2");
			}
		} else {
			where
					.append("AND ( C_REBATETYPE=2 OR ( C_REBATETYPE=3 AND C_PAYSTATE=1))");
		}
		String rebattime = this.getCheckTime(this.recharestime,
				this.rechareetime, rebaterecord.COL_rebatetime);

		if (rebattime.length() > 0) {
			where.append(" AND (" + rebattime + ")");
		}
		/*if(this.customeragent.getId()>0){
			System.out.println(customeragent.getId());
			where.append(" AND "+rebaterecord.COL_rebateagentid+"="+customeragent.getId());
		}else{
			if(this.customeragent.getId()==0){
			where.append(" AND "+rebaterecord.COL_rebateagentid+"="+this.getLoginUser().getAgentid());
			}
		}*/
		
		where.append(" AND "+rebaterecord.COL_rebateagentid+"="+rebaterecord.getRebateagentid());
		System.out.println(where.toString());
		
	
		List list=null;
//		if(this.getLoginsessionagent().getAgenttype()==1){
//			list= list = Server.getInstance().getMemberService()
//			.findAllRebaterecordForPageinfo(where.toString(),
//					" ORDER BY ID DESC", pageinfo,"(SELECT C_AGENTCOMPANYNAME FROM T_CUSTOMERAGENT WHERE ID=R.C_REBATEAGENTID)AS agentname ");
//			HttpServletRequest request=ServletActionContext.getRequest();
//			String agentroot = new CustomeragentAction().getAgentRoot(3);
//		//	agentroot+="var root_pt=new Ext.tree.TreeNode({text:\"平台\",id:'46'});root.appendChild(root_pt);";
//			request.setAttribute("agentroot", agentroot);
//		}else{
		HttpServletRequest request=ServletActionContext.getRequest();
		if(this.getLoginsessionagent().getAgenttype()==1){
		String agentroot = new CustomeragentAction().getAgentRoot(3);
		request.setAttribute("agentroot", agentroot);
		}
			list = Server.getInstance().getMemberService()
			.findAllRebaterecordForPageinfo(where.toString(),
					" ORDER BY ID DESC", pageinfo);
//		}
		pageinfo = (PageInfo) list.remove(0);
		listRebaterecord = list;
		System.out.println(listRebaterecord);
		
		if(isExp==true){
			return where.toString();
		}else{
		return "record";
		}
		
		
	}

	public String tovmoneyrecharge() {

		return "tovmeonyrecharge";

	}

	// 显示虚拟账户金额修改页面
	public String addVmoneyPage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
			float s_vmoney = this.rebaterecord.getRebatemoney();
			rebaterecord.setRebatetype(3);
			if (this.getLoginsessionagent().getAgenttype() == 1) {
				rebaterecord.setPaystate(1);//管理员线下充值
			} else {
				rebaterecord.setPaystate(0);
			}
			
			rebaterecord.setCustomerid(this.getLoginUser().getId());
			String memo = "通过"
					+ getyewuleixing((int) rebaterecord.getYewutype()) + ",获得"
					+ s_vmoney + "元";
			if(isNotNullOrEpt(rebaterecord.getRebatememo())){
				memo+=rebaterecord.getRebatememo();
			}
			rebaterecord.setRebatememo(memo);
			rebaterecord.setRebatetime(this.getCurrentTime());
				try {
					rebaterecord=Server.getInstance().getMemberService().createRebaterecord(
							rebaterecord);
					if(rebaterecord.getPaystate()==1){
						new CustomeragentServiceImpl().addAgentvmoney(rebaterecord.getRebateagentid(), rebaterecord.getRebatemoney());
						
					}
					// 记录充值操作记录
				} catch (Exception e) {
					request.setAttribute("message", "由于网路原因导致充值失败，请重新尝试账户充值！");
				}

	
		if (this.getLoginsessionagent().getAgenttype() == 1) {
			return torebaterecord();
		}else{
			Map map=new HashMap();
			map.put("billname", "VmoneyrechargeHelper");
			map.put("orderprice", rebaterecord.getRebatemoney());
			map.put("orderid", rebaterecord.getId());
			request.setAttribute("ordermap", map);
			request.setAttribute("vmoneyrecharge", "");
			return "vmoneyrechargeorder";
		}
	}

//	public void vmeonyrecharge() throws Exception {
//		rebaterecord.setRebatetype(3);// 计入虚拟账户
//		rebaterecord.setPaystate(0);// 未支付
//		rebaterecord.setCustomerid(this.getLoginUserId());
//		rebaterecord.setRebateagentid(s_agentid);
//		rebaterecord.setRebatetime(this.getCurrentTime());
//		rebaterecord.setRebatememo("通过网银支付充值：" + rebaterecord.getRebatemoney());
//		if (rebaterecord.getRebatemoney() > 0) {
//			HttpServletResponse response = ServletActionContext.getResponse();
//			response.setContentType("text/plain; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			try {
//				rebaterecord = Server.getInstance().getMemberService()
//						.createRebaterecord(rebaterecord);
//				out.print(rebaterecord.getId());
//
//				// 记录充值操作记录
//			} catch (Exception e) {
//				out.print("");
//			}
//			out.flush();
//			out.close();
//		}
//
//	}
	// 得到业务系统类型定义
	public String getyewuleixing(int leixingid) {
		switch (leixingid) {
		case 0:
			return "虚拟账户充值";
		case 1:
			return "国内机票";
		case 2:
			return "国际机票";
		case 3:
			return "国内酒店";
		case 4:
			return "国际酒店";
		case 5:
			return "充值业务";
		case 6:
			return "火车票业务";
		case 7:
			return "租车业务";
		case 8:
			return "旅游业务";
		case 9:
			return "加盟奖励";
		}
		return "";
	}	
	
	/**
	 * 导出Excel表格
	 */
	public void expXMoneyExcel(){
		String sql = "";
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		pageinfo.setPagerow(2000);
		sql=torebaterecord();
		List orderinfos = Server.getInstance().getMemberService().findAllRebaterecordForPageinfo(sql," ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) orderinfos.remove(0);
		String name = "充值记录报表.xls";
		try {
			name = new String(name.getBytes("GB2312"), "ISO8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		//设置标题
		response.setHeader("Content-Disposition", "attachment;filename=" + name);
		String[] titleles = { "序号", "采购商", "经手人", "金额", "类型", "关联订单", "时间",
				"详细"};
		HthyWritableWorkBook book=null;
		try {
			book = HthyWritableWorkBook.getInstance(response
					.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HthyWorkSheet sheet = book.createHthyWorkSheet("充值记录报表",
				titleles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow("充值记录报表", 3);
		sheet.createOneRow("充值记录报告", 5);
		sheet.createOneRow("检索条件：");
		//addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		//Map map = null;
		List rebaterecodelist=null;
		Rebaterecord cord=null;
		int ordercount = 0;//保存记录数
		float allprice = 0f;//保存总得交易金额
		float addmoney = 0f;//保存订单充值
		float returnmoney = 0f;//保存订单返佣
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = orderinfos.size();
				ordercount += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					cord=(Rebaterecord)orderinfos.get(i);
					sheet.addCell(i+1);
					sheet.addCell(cord.getAgentname());
					sheet.addCell(cord.getCustomername());
					sheet.addCell(cord.getRebatemoney());
					//获得充值类型编号
				    long type=cord.getYewutype();
					//根据编号获得类型名称
					sheet.addCell(getyewuleixing((int)type));
					sheet.addCell(cord.getOrdernumber());
					sheet.addCell(cord.getRebatetime());
					sheet.addCell(cord.getRebatememo());
					allprice+=cord.getRebatemoney();
					if(getyewuleixing((int)type).equals("虚拟账户充值")){
						addmoney+=cord.getRebatemoney();		
					}else{
						returnmoney+=cord.getRebatemoney();
					}
					sheet.addCell("");
					if (i % 300 == 0) {
						book.flush();
						book.write();
					}
					sheet.rowOver();
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					orderinfos = Server.getInstance().getMemberService().findAllRebaterecordForPageinfo(sql," ORDER BY ID DESC", pageinfo);
					pageinfo = (PageInfo) orderinfos.remove(0);
				} else {
					break;
				}

			}
			System.gc();
			sheet.createOneRow(new String[] { "总记录数：",
					String.valueOf(ordercount) });
			sheet
					.createOneRow(new String[] { "总交易金额：",
							String.valueOf(allprice) });
			sheet.createOneRow(new String[] { "账户充值金额：",
					String.valueOf(formatMoney(addmoney)) });
			sheet.createOneRow(new String[] { "账户返佣金额：",
					String.valueOf(formatMoney(returnmoney)) });
			sheet.sheetOver();
			book.flush();
			book.write();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
	}

	/**
	 * 转向到返佣记录表修改页面
	 */
	public String toedit() throws Exception {
		rebaterecord = Server.getInstance().getMemberService()
				.findRebaterecord(rebaterecord.getId());
		return EDIT;
	}

	/**
	 * 转向到返佣记录表审核页面
	 */
	public String tocheck() throws Exception {
		rebaterecord = Server.getInstance().getMemberService()
				.findRebaterecord(rebaterecord.getId());
		return CHECK;
	}

	/**
	 * 添加返佣记录表
	 */
	public String add() throws Exception {

		Server.getInstance().getMemberService()
				.createRebaterecord(rebaterecord);
		return LIST;
	}

	/**
	 * 审核返佣记录表
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateRebaterecordIgnoreNull(
				rebaterecord);
		return LIST;
	}

	/**
	 * 编辑返佣记录表
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateRebaterecordIgnoreNull(
				rebaterecord);
		return LIST;
	}

	/**
	 * 删除返佣记录表
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteRebaterecord(
				rebaterecord.getId());
		return LIST;
	}

	/**
	 * 返回返佣记录表对象
	 */

	public Object getModel() {
		return rebaterecord;
	}

	public List<Rebaterecord> getListRebaterecord() {
		return listRebaterecord;
	}

	public void setListRebaterecord(List<Rebaterecord> listRebaterecord) {
		this.listRebaterecord = listRebaterecord;
	}

	public Rebaterecord getRebaterecord() {
		return rebaterecord;
	}

	public void setRebaterecord(Rebaterecord rebaterecord) {
		this.rebaterecord = rebaterecord;
	}

	public String getRecharestime() {
		return recharestime;
	}

	public void setRecharestime(String recharestime) {
		this.recharestime = recharestime;
	}

	public String getRechareetime() {
		return rechareetime;
	}

	public void setRechareetime(String rechareetime) {
		this.rechareetime = rechareetime;
	}

	public Customeragent getCustomeragent() {
		return customeragent;
	}

	public void setCustomeragent(Customeragent customeragent) {
		this.customeragent = customeragent;
	}

	public boolean isExp() {
		return isExp;
	}

	public void setExp(boolean isExp) {
		this.isExp = isExp;
	}

}