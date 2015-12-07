/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class SysmessageAction extends B2b2cbackAction {
	private static final long serialVersionUID = -7755771783853575613L;
	private List<Sysmessage> listSysmessage;
	private List<Customeruser> listCustomeruser;
	private Sysmessage sysmessage = new Sysmessage();
	// 发布时间
	private String s_pubtime;
	// 截止时间
	private String s_endtime;
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询消息公告
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Sysmessage.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		/*if (sysmessage.getTitle() != null && !"".equals(sysmessage.getTitle())) {
			where += " and " + Sysmessage.COL_title + " like '%"
					+ sysmessage.getTitle() + "%' ";
		}

		if (sysmessage.getState() != null && sysmessage.getState() >= 0) {
			where += " and " + Sysmessage.COL_state + "="
					+ sysmessage.getState();
		}

		if (sysmessage.getType() != null && sysmessage.getType() >= 0) {
			where += " and " + Sysmessage.COL_type + "=" + sysmessage.getType();
		} else {
			where += " and (" + Sysmessage.COL_type + "= 0 or " + Sysmessage.COL_type + "=1) ";
		}*/

		Customeruser user = getLoginUser();
		// 获取登录用户角色列表
		List<Agentroleref> agentrolerefList = Server.getInstance()
				.getMemberService().findAllAgentroleref(
						" where " + Agentroleref.COL_customeruserid + "="
								+ user.getId(), "ORDER BY ID", -1, 0);
		String roleStr = "";
		StringBuffer sb = new StringBuffer();
		// 系统配置表存放的用户角色信息
		/*List<Sysconfig> configList = null;
		if (agentrolerefList != null && agentrolerefList.size() > 0) {
			for (Agentroleref ref : agentrolerefList) {
				if (sb.length() == 0) {
					sb.append(ref.getRoleid());
				} else {
					sb.append("," + ref.getRoleid());
				}
			}
			roleStr = sb.toString();
			String sql = "";
			sql = " where " + Sysconfig.COL_value + " in ('" + roleStr+ "')";
			configList = Server.getInstance().getMemberService()
					.findAllSysconfig(sql, "ORDER BY ID", -1, 0);
		}

		// 判断当前用户是否为系统管理员或运营商
		if (configList != null && configList.size() > 0) {
			int count = 0;
			for (Sysconfig config : configList) {
				if (config.getName().equals("系统管理员")
						|| config.getName().equals("运营商")) {
					count++;
				}
			}
			if (count == 0) {
				where += " and " + Sysmessage.COL_customeruserid + "="
						+ user.getId();
			}
		} else {
			where += " and " + Sysmessage.COL_customeruserid + "="
					+ user.getId();
		}*/
		

		// 获取消息列表
		getSysmessageListByWhere(where);

		return SUCCESS;
	}

	/**
	 * 转向到消息公告添加页面
	 */
	public String toadd() throws Exception {
		Customeruser user = this.getLoginUser();
		listCustomeruser = getCustomeruserList(user.getAgentid(), user.getId());
		return EDIT;
	}

	/**
	 * 转向到消息公告修改页面
	 */
	public String toedit() throws Exception {
		sysmessage = Server.getInstance().getAirService().findSysmessage(
				sysmessage.getId());
		Customeruser user = this.getLoginUser();
		listCustomeruser = getCustomeruserList(user.getAgentid(), user.getId());
		return EDIT;
	}

	/**
	 * 判断用户ID是否在可见用户组中
	 * 
	 * @param userId
	 *            用户Id
	 * @return
	 */
	public boolean isContained(long userId) {
		if (sysmessage.getUsers() != null && !"".equals(sysmessage.getUsers())) {
			String[] idList = sysmessage.getUsers().split(",");
			for (String str : idList) {
				if (str != null && !"".equals(str)
						&& userId == Long.valueOf(str)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 根据加盟商ID获取用户信息列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Customeruser> getCustomeruserList(long agentId, long userId) {
		String where = " where " + Customeruser.COL_agentid + "=" + agentId
				+ " and " + Customeruser.COL_id + " != " + userId + " and "
				+ Customeruser.COL_isenable + "=1";
		List<Customeruser> list = Server.getInstance().getMemberService()
				.findAllCustomeruser(where, "ORDER BY ID", -1, 0);
		return list;
	}

	/**
	 * 转向到消息公告查看页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String todetail() throws Exception {
		sysmessage = Server.getInstance().getAirService().findSysmessage(
				sysmessage.getId());
		return "detail";
	}

	/**
	 * 截取字符串
	 * 
	 * @param str
	 * @return
	 */
	public String subString(String str) {
		return (str == null || "".equals(str)) ? "" : str.length() <= 30 ? str
				: str.substring(0, 30) + "…";
	}

	/**
	 * 转向到消息公告审核页面
	 */
	public String docheck() throws Exception {
		sysmessage = Server.getInstance().getAirService().findSysmessage(
				sysmessage.getId());
		if (sysmessage.getState() == 0) {
			sysmessage.setState(1);
		} else {
			sysmessage.setState(0);
		}
		Server.getInstance().getAirService().updateSysmessageIgnoreNull(
				sysmessage);
		return LIST;
	}

	/**
	 * 添加消息公告
	 */
	public String add() throws Exception {
		sysmessage.setPubtime(dateToTimestamp(s_pubtime));
		sysmessage.setEndtime(dateToTimestamp(s_endtime));
		sysmessage.setCustomeruserid(getLoginUser().getId());
		sysmessage.setCreateuser(getLoginUser().getLoginname());
		sysmessage.setCreatetime(new Timestamp(System.currentTimeMillis()));
		sysmessage.setModifyuser(getLoginUser().getLoginname());
		sysmessage.setModifytime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().createSysmessage(sysmessage);
		this.changMessagMap();
		
		return LIST;
	}

	/**
	 * 审核消息公告
	 */
	public String check() throws Exception {
		sysmessage.setModifyuser(getLoginUser().getLoginname());
		sysmessage.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateSysmessageIgnoreNull(
				sysmessage);
		return LIST;
	}

	/**
	 * 编辑消息公告
	 */
	public String edit() throws Exception {
		sysmessage.setModifyuser(getLoginUser().getLoginname());
		sysmessage.setModifytime(new Timestamp(System.currentTimeMillis()));
		sysmessage.setPubtime(dateToTimestamp(s_pubtime));
		sysmessage.setEndtime(dateToTimestamp(s_endtime));

		Server.getInstance().getAirService().updateSysmessageIgnoreNull(
				sysmessage);
		//修改后更新messageMap
		this.changMessagMap();
		return LIST;
	}

	/**
	 * 删除消息公告
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteSysmessage(
				sysmessage.getId());
		//删除后更新公告
		changMessagMap();
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
					Server.getInstance().getAirService().deleteSysmessage(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 根据用户ID串获取用户姓名串
	 * 
	 * @param idStr
	 * @return
	 */
	public String getCustomeruserNames(String idStr) {
		if (idStr == null || "".equals(idStr)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		String[] arr = idStr.split(",");
		for (String s : arr) {
			if (s != null && !"".equals(s)) {
				Customeruser user = Server.getInstance().getMemberService()
						.findCustomeruser(Long.valueOf(s));
				if ("".equals(sb.toString())) {
					sb.append(user.getMembername());
				} else {
					sb.append("," + user.getMembername());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 登录用户接收的站内消息列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String myReceiveMsg() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Sysmessage.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		if (sysmessage.getTitle() != null && !"".equals(sysmessage.getTitle())) {
			where += " and " + Sysmessage.COL_title + " like '%"
					+ sysmessage.getTitle() + "%' ";
		}

		if (sysmessage.getState() != null && sysmessage.getState() >= 0) {
			where += " and " + Sysmessage.COL_state + "="
					+ sysmessage.getState();
		}

		// 状态2为站内消息
		where += " and " + Sysmessage.COL_type + " = 2";
		
		Customeruser user = getLoginUser();
		where += " and " + Sysmessage.COL_users + " like '%,"
				+ user.getId() + ",%'";
		// 获取消息列表
		getSysmessageListByWhere(where);
		return "receiveMsgList";
	}

	/**
	 * 登录用户发送的站内消息列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String mySendMsg() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Sysmessage.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		if (sysmessage.getTitle() != null && !"".equals(sysmessage.getTitle())) {
			where += " and " + Sysmessage.COL_title + " like '%"
					+ sysmessage.getTitle() + "%' ";
		}

		if (sysmessage.getState() != null && sysmessage.getState() >= 0) {
			where += " and " + Sysmessage.COL_state + "="
					+ sysmessage.getState();
		}

		// 状态2为站内消息
		where += " and " + Sysmessage.COL_type + " = 2";
		
		Customeruser user = getLoginUser();
		where += " and " + Sysmessage.COL_customeruserid + "=" + user.getId();
		// 获取消息列表
		getSysmessageListByWhere(where);
		return "sendMsgList";
	}

	/**
	 * 根据查询条件获取消息列表
	 * 
	 * @param where
	 */
	public void getSysmessageListByWhere(String where) {
		System.out.println("where:"+where);
		List list = Server.getInstance().getAirService()
				.findAllSysmessageForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listSysmessage = list;
		if (pageinfo.getTotalrow() > 0 && listSysmessage.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllSysmessageForPageinfo(where, " ORDER BY ID DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listSysmessage = list;
		}
	}
	
	/**
	 * 跳转至发送站内消息页面
	 * @return
	 * @throws Exception
	 */
	public String toSendMsg() throws Exception {
		Customeruser user = this.getLoginUser();
		listCustomeruser = getCustomeruserList(user.getAgentid(), user.getId());
		return "sendMsg";
	}

	/**
	 * 发送站内消息
	 */
	public String sendMsg() throws Exception {
		sysmessage.setCustomeruserid(getLoginUser().getId());
		sysmessage.setCreateuser(getLoginUser().getLoginname());
		sysmessage.setCreatetime(new Timestamp(System.currentTimeMillis()));
		sysmessage.setModifyuser(getLoginUser().getLoginname());
		sysmessage.setModifytime(new Timestamp(System.currentTimeMillis()));
		// 2为站内消息
		sysmessage.setType(2);
		// 状态0为未查看
		sysmessage.setState(0);
		Server.getInstance().getAirService().createSysmessage(sysmessage);
		return "toMsgList";
	}
	
	/**
	 * 转向到站内消息收件箱查看页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toSendMsgDetail() throws Exception {
		sysmessage = Server.getInstance().getAirService().findSysmessage(
				sysmessage.getId());
		sysmessage.setState(1);
		Server.getInstance().getAirService().updateSysmessageIgnoreNull(sysmessage);
		return "detail";
	}
	
	/**
	 * 转向到站内消息发件箱查看页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toRevMsgDetail() throws Exception {
		sysmessage = Server.getInstance().getAirService().findSysmessage(
				sysmessage.getId());
		return "detail";
	}
	
	/**
	 * 返回消息公告对象
	 */
	public Object getModel() {
		return sysmessage;
	}

	public List<Sysmessage> getListSysmessage() {
		return listSysmessage;
	}

	public void setListSysmessage(List<Sysmessage> listSysmessage) {
		this.listSysmessage = listSysmessage;
	}

	public Sysmessage getSysmessage() {
		return sysmessage;
	}

	public void setSysmessage(Sysmessage sysmessage) {
		this.sysmessage = sysmessage;
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

	public String getS_pubtime() {
		return s_pubtime;
	}

	public void setS_pubtime(String s_pubtime) {
		this.s_pubtime = s_pubtime;
	}

	public String getS_endtime() {
		return s_endtime;
	}

	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}

	public List<Customeruser> getListCustomeruser() {
		return listCustomeruser;
	}

	public void setListCustomeruser(List<Customeruser> listCustomeruser) {
		this.listCustomeruser = listCustomeruser;
	}
	//更新公告
	private void changMessagMap(){		
	
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String,Sysmessage> messageMap=(Map<String, Sysmessage>)session.getAttribute("messageMap");//
		if(messageMap==null){
			messageMap=new HashMap<String,Sysmessage>();
		}
		messageMap.clear();
		String messageSql="SELECT * FROM [T_SYSMESSAGE] WHERE C_MODIFYTIME IN(SELECT MAX(C_MODIFYTIME) FROM [T_SYSMESSAGE] WHERE C_TYPE IN(1,2,3,4,5) AND '"
			+DateFormat.getDateTimeInstance().format(System.currentTimeMillis())+"' BETWEEN C_PUBTIME AND C_ENDTIME GROUP BY C_TYPE )";
		List<Sysmessage> sysmessages=Server.getInstance().getAirService().findAllSysmessageBySql(messageSql, -1, 0);
		for(Sysmessage message:sysmessages){
			messageMap.put(message.getType().toString(), message);
		}
		session.setAttribute("messageMap", messageMap);
	}

}