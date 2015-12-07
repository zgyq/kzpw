/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *  HISTORY
 *  
 *  2009/08/11 创建
 *
 */

package com.yf.system.back.interceptor;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yf.system.back.action.B2b2cbackAction;
import com.yf.system.back.server.Server;
import com.yf.system.back.servlet.WriteLog;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.systemaction.Systemaction;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.txuserinfo.Txuserinfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

public class AuthenInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public String intercept(ActionInvocation inv) throws Exception {
		// inv.getInvocationContext().getLocale().setDefault(newLocale)
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String servername = request.getServerName();
		servername = getwebname(servername);// 解析
		System.out.println("servername:"+servername);
		
		boolean exist = session.getAttribute("dns") == null ? true
				: ((Dnsmaintenance) session.getAttribute("dns")).getDnsname()
						.equals(servername) ? false : true;// 判断request是否已保存。
		if (exist) {
			String where = "WHERE C_DNSNAME LIKE '%" + servername
					+ "%' AND C_LOGOLOGINSRC='B2B'";
			try {
				List list = Server.getInstance().getSystemService()
						.findAllDnsmaintenance(where, "", -1, 0);

				if (list.size() > 0) {
					Dnsmaintenance dns = (Dnsmaintenance) list.get(0);
					session.setAttribute("dns", dns);
				} else {
					where = "WHERE C_DNSNAME = 'default' AND C_LOGOLOGINSRC='B2B'";
					list = Server.getInstance().getSystemService()
							.findAllDnsmaintenance(where, "", -1, 0);
					Dnsmaintenance dns = (Dnsmaintenance) list.get(0);
					session.setAttribute("dns", dns);
					//System.out.println("dns:"+dns.getAgentid());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String method = inv.getProxy().getActionName();
		if (!method.equals("orderinfo!getOrderCount")) {
			WriteLog.write("所有请求", "请求方法:" + method);
		}
		// System.out.println(method);
		Action action = inv.getAction();
		System.out.println("method:" + method);

		Customeruser user = null;

		if (action instanceof B2b2cbackAction) {
			B2b2cbackAction moaction = (B2b2cbackAction) action;
			if (method.contains("login!tologin")// 到登录页
					|| method.contains("login!login")// 登录
					|| method.contains("login!login_new")// 登录
					|| method.contains("login!about")// 关于我们
					|| method.contains("login!togonggao")// 公告
					|| method.contains("login!tohezuo")// 合作
					|| method.contains("login!contact")// 联系我们
					|| method.contains("login!article")// 注册
					|| method.contains("customeragent!loadcitylist")// 加载成熟
					|| method.contains("vaidate!validateAgentName2")// 验证代理名字
					|| method.contains("vaidate!validateusername2")// 验证代理名字
					|| method.contains("login!toregfenxiao")// 分销注册
					|| method.contains("login!toreggongying")// 供应注册
					|| method.contains("customeragent!addrequestCustomeragent")// 注册
					|| method.contains("airflight!SearchAirFlight") //航班查询
					|| method.contains("airflight!SearchAirFlightZrate") //政策查询
					
					|| method.contains("login!logout")// 退出系统
					|| method.contains("customeragent!reg") // 因测试而加入。可删除...
					|| method.equals("customeragent!agentrequest")) {// 加盟申请

			} else {
				
				user = moaction.getLoginUser();

				if (user == null) {
					if (!method.equals("orderinfo!getOrderCount")) {
						WriteLog.write("所有请求_没登录", "请求方法:" + method);
					}
					return Action.INPUT;
				} else {
					//System.out.println("method:" + method + ",user:"+ user.getLoginname()+",servername:"+servername);

					if ((user.getId() != 1 && user.getId() != 62)
							&& (method.indexOf("delete") != -1
									|| method.indexOf("DELETE") != -1
									|| method.indexOf("batch") != -1 || method
									.indexOf("BATCH") != -1)) {
						if (!method.equals("orderinfo!getOrderCount")) {
							WriteLog.write("非法请求", "请求者ID:" + user.getId()
									+ ",请求方法:" + method);
						}
						 return Action.INPUT;
					}
				}
				if (!method.equals("orderinfo!getOrderCount")) {
					WriteLog.write("所有请求_已经登录", "请求者ID:" + user.getId()
							+ ",请求方法:" + method);
					
					Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(user.getId());
					if(customeruser.getIsenable()==2){
						 return Action.INPUT;
					}
					Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());
					
					if(customeragent.getAgentisenable()==0){
						 return Action.INPUT;
					}
				}

				// 暂无用 注释by：小陈
				if (method != null && method.indexOf("!") > 0
						&& method.indexOf("!to") < 0) {
					//writeLog(user, ServletActionContext.getRequest(), method);
				}

			}

			try {

				return inv.invoke();
			} catch (Exception e) {
				e.printStackTrace();
				moaction.addActionMessage(e.getMessage());

				return Action.ERROR;
			}

		} else {

			try {

				return inv.invoke();
			} catch (Exception e) {
				e.printStackTrace();

				return Action.ERROR;
			}
		}
	}

	public String getwebname(String dnsname) {

		try {
			int start = dnsname.indexOf(".");
			int www = dnsname.indexOf("www");
			int end = dnsname.lastIndexOf(".");
			if (start != -1) {
				if (start == end || www == -1) {
					return dnsname.substring(0, end);
				}
				return dnsname.substring(start + 1, end);
			} else {
				return dnsname;
			}
		} catch (Exception e) {

		}
		return "";
	}

	/**
	 * 写日志信息
	 * 
	 * @param user
	 * @param request
	 * @param method
	 */

	private void writeLog(Customeruser user, HttpServletRequest request,
			String method) {

		try {

			String x_forwarded_for = ServletActionContext.getRequest()
					.getHeader("x-forwarded-for");
			if (x_forwarded_for == null || x_forwarded_for.length() == 0
					|| "unknown".equalsIgnoreCase(x_forwarded_for)) {
				x_forwarded_for = ServletActionContext.getRequest().getHeader(
						"PRoxy-Client-IP");
			}
			if (x_forwarded_for == null || x_forwarded_for.length() == 0
					|| "unknown".equalsIgnoreCase(x_forwarded_for)) {
				x_forwarded_for = ServletActionContext.getRequest().getHeader(
						"WL-Proxy-Client-IP");
			}
			if (x_forwarded_for == null || x_forwarded_for.length() == 0
					|| "unknown".equalsIgnoreCase(x_forwarded_for)) {
				x_forwarded_for = ServletActionContext.getRequest()
						.getRemoteAddr();
			}
			// request.getRemoteAddr()
			Systemaction systemlog = new Systemaction();
			systemlog.setCode(method);

			systemlog.setCreatetime(new Timestamp(System.currentTimeMillis()));
			try {
				List<Systemright> list = Server.getInstance()
						.getMemberService().findAllSystemright(
								" where " + Systemright.COL_code + "='"
										+ method + "'", "", -1, 0);
				if (!list.isEmpty()) {
					systemlog.setActionname(list.get(0).getName());
				} else {
					systemlog.setActionname(method);
				}
			} catch (Exception e) {
			}
			try {
				systemlog.setIp(x_forwarded_for);
			} catch (Exception e) {
			}
			try {
				systemlog.setUsername(user.getLoginname());
			} catch (Exception e) {
			}
			Server.getInstance().getMemberService().createSystemaction(
					systemlog);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
