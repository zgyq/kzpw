/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/11 创建
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.filecabindir.Filecabindir;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.qqinfo.Qqinfo;
import com.yf.system.base.qqtype.Qqtype;
import com.yf.system.base.rebaterule.Rebaterule;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;


public class LoginAction_new extends B2b2cbackAction {
	private static final long serialVersionUID = -1985202558426456030L;

	private String validateImg;
	private String forword;
	private String forwordoa;
	private String validate;
	private String usermobile;
	private String importtype;
	private String s_orderstatuspnr;
	private int isinter;
	private Customeruser user = new Customeruser();
	private Customeragent agent;
	private List<Sysmessage> sysmessageList;
	private List<Orderinfo> ticketorderlist;
	private Customeruser customeruser;
	private String username;
	private List<Filecabindir> ListFilecabindir;
	private List<Agentroleref> ListAgentroleref;
	private String type;
	private int s_membertype;
	private int puserflag;
	private int ywtype = 0;
	private int rechtype = 0;
	private List<Customeruser> listCustomeruser;
	private String strrebatehtml = "";
	private List<Systemright> listRoot;
	private Long orderuserid;
	private String s_qqlistinfo = "";
	private String treestr = "";
	private String s_department;
	private String urlaction;
	private List<Rebaterule> listRebaterule;
	private String puser;
	private String shengdailizongshu;
	private String shidailizongshu;
	private String quyudailizongshu;
	private String jingjirenzongshu;
	// 机票订单个数
	private String ticketordernum;

	private long agentid;

	// 酒店订单个数
	private String hotelordernum;
	// 旅游订单个数
	private String tripordernum;
	// 租车订单个数
	private String carordernum;
	// 手机充值
	private String mobileordernum;
	// QQ充值订单
	private String qqordernum;
	// 订单总个数
	private String totalordernum;

	//订单ID
	private String orderid;

	private List menulist;
	
	private String companyname;
	private String agentidstr;

	public String getUrlaction() {
		return urlaction;
	}

	public void setUrlaction(String urlaction) {
		this.urlaction = urlaction;
	}

	public Long getOrderuserid() {
		return orderuserid;
	}

	public void setOrderuserid(Long orderuserid) {
		this.orderuserid = orderuserid;
	}

	public List<Systemright> getListRoot() {
		return listRoot;
	}

	public void setListRoot(List<Systemright> listRoot) {
		this.listRoot = listRoot;
	}

	public void validatemobile() throws Exception {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (!Server.getInstance().getMemberService().findAllCustomeruser(
				"where 1 = 1 and " + Customeruser.COL_mobile + " = '"
						+ usermobile + "'", "", -1, 0).isEmpty()) {
			out.print("trmobile");
		} else {
			out.print("famobile");
		}
		out.flush();
		out.close();
	}

	public void validateusername() throws Exception {

		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (!Server.getInstance().getMemberService().findAllCustomeruser(
				"where 1 = 1 and " + Customeruser.COL_loginname + " = '"
						+ username + "'", "", -1, 0).isEmpty()) {
			out.print("trname");
		} else {
			out.print("faname");
		}
		out.flush();
		out.close();
	}

	public String tologin() {
		// System.out.println("***********************************");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
	//	System.out.println(dns.getLoginpagename());
		if (dns != null) {
			this.forword = dns.getLoginpagename();
			return "forword";
		} else {
			return INPUT;
		}
	}
	public String  topay() throws IOException{
		System.out.println("topay");
		//String url="http://210.83.80.4/ticket_inter/Jinripay?paymethod=directPay&Billpaymethod=12&orderid="+orderid;
		String urltemp="http://210.83.80.4/ticket_inter/Jinripay?paymethod=directPay&Billpaymethod=12&orderid=20058";
		
		
		
			
		
		return "";
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		
		String vali = (String) ServletActionContext.getContext().getSession()
				.get("validate");
		// 从其它链接过来的
		if (validateImg == null || vali == null
				|| vali.toLowerCase().trim().equals("")) {
			return tologin();
		}
		if (!validateImg.toLowerCase().equals(vali)) {
			// 验证否
			this.addActionMessage("验证码错误,请重新登录!");
			this.addFieldError("erromessage", "验证码错误!");
			return tologin();
		}
		List list = null;
		if (user.getLoginname() != null
				&& ((user.getLoginname().indexOf(' ') < 0) && (user
						.getLoginname().indexOf('|') < 0))) {
			String where = " where " + Customeruser.COL_loginname + " = '"
					+ user.getLoginname() + "'";
			list = Server.getInstance().getMemberService().findAllCustomeruser(
					where, "", 1, 0);
			if (list.isEmpty()) {
				this.addActionMessage("用户名错误,请重新登录!");
				this.addFieldError("erromessage", "用户名或密码错误!");
				return tologin();
			}

		} else {
			this.addActionMessage("用户名错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			return tologin();
		}
		if (user.getLogpassword() != null) {
			if (!Util.MD5(user.getLogpassword()).equals(
					((Customeruser) (list.get(0))).getLogpassword())) {
				this.addActionMessage("密码错误,请重新登录!");
				this.addFieldError("erromessage", "用户名或密码错误!");
				return tologin();
			}

		} else {
			this.addActionMessage("密码错误,请重新登录!");
			this.addFieldError("erromessage", "用户名或密码错误!");
			return tologin();
		}
		Customeruser loginuser = (Customeruser) list.get(0);
		Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(loginuser.getAgentid());
		System.out.println(agent.getBussinesslist()==null);
		if (agent == null || converNull(agent.getAgentisenable(), 1) == 0) {
			this.addActionMessage("此账户所属单位已禁用!");
			this.addFieldError("erromessage", "此账户所属单位已禁用!");
			return tologin();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
		long loginagentid =  agent.getId();
		if (dns != null) {
			if (dns.getAgentid() != loginagentid) {// 非绑定
				String sql = "SELECT C_AGENTID FROM T_DNSMAINTENANCE "
						+ "WHERE C_AGENTID="
						+ loginagentid
						+ "  OR ( CHARINDEX(','+CONVERT(NVARCHAR(50),C_AGENTID)+',',',"
						+ agent.getParentstr()
						+ ",')>0 AND C_AGENTID!=46) ORDER BY C_AGENTID DESC";
				System.out.println("LOGIN SQL:" + sql);
				List dnslist = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, null);
				int count = dnslist.size();
				System.out.println("LOGIN result:" + count);
				if (count > 0) {// 是否存在绑定或者绑定其父（不包括平台） 若存在绑定 不可登录
					Map map = (Map) dnslist.get(0);
					long dnsagentid = Long.valueOf(map.get("C_AGENTID").toString());
					if (dns.getAgentid() != dnsagentid) {
						this.addFieldError("erromessage", "用户名或密码错误!");
						return tologin();
					}
				} else {// 不存在 判断绑定是否为其父
					String parentstr = agent.getParentstr();
					if (parentstr.indexOf(dns.getAgentid() + "") < 0) {
						this.addFieldError("erromessage", "用户名或密码错误!");
						return this.tologin();
					}

				}
			}
		} else {
			this.addFieldError("erromessage", "用户名或密码错误!");
			return tologin();
		}
		session.setAttribute("loginuser", loginuser);
		session.setAttribute("loginagent", agent);
		
		
		
		String where = " SELECT ID as id, C_NAME as name FROM T_SYSTEMRIGHT WHERE C_PARENTID= -1 and ID IN "
			+ "( SELECT C_RIGHTID FROM  T_SYSROLERIGHT WHERE C_ROLEID IN  "
			+ "(SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="
			+ this.getLoginUserId() + ")) and C_TYPE !=2";
	// 以下追加用于模块限制 若有新添模块 请修改 SystemrightAction中的modestr
//	where += " AND ID IN (" + SystemrightAction.modelstr + ")";
	 System.out.println(where);
	 menulist = Server.getInstance().getSystemService().findMapResultBySql( where + " ORDER BY C_ORDERID ", null);
		
		
		
		
		return SUCCESS;
	}

	public String logout() throws Exception {

		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return INPUT;
	}

	private List<Sysroleright> listSysroleright;

	public List<Sysroleright> getListSysroleright() {
		return listSysroleright;
	}

	public void setListSysroleright(List<Sysroleright> listSysroleright) {
		this.listSysroleright = listSysroleright;
	}

	
	
	private void getTreeStr(List<Systemright> list,JSONArray ja,long id){
		
		//JSONArray ja = new JSONArray();
			for(int i=0; i<list.size(); i++){
			
			JSONObject o = new JSONObject();//JSONObject.fromObject(list.get(i));
		   	o.element("text",list.get(i).getName());
			o.element("id", list.get(i).getId());
			o.element("code",list.get(i).getCode());
			o.element("name", list.get(i).getName());
		   	/*
			Systemright sr = Server.getInstance().getMemberService().findSystemright(id);
		   	if(sr!=null)
		   	o.element("parentname", sr.getName());
		   	*/
		    String where = " where  " + Systemright.COL_parentid + "= " +list.get(i).getId()
			+ " and " + Systemright.COL_id + " in ( select "
			+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
			+ " where " + Sysroleright.COL_roleid + " in (select "
			+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
			+ " where " + Agentroleref.COL_customeruserid + "="
			+ getLoginUser().getId() + ")) and " + Systemright.COL_type
			+ " !=2";
	
		   	
		   	
			List<Systemright> slist = Server.getInstance().getMemberService().findAllSystemright(where, "ORDER BY C_ORDERID desc", -1, 0);
			if(slist.isEmpty()){
				o.element("leaf", true);
				//o.element("checked", false);
				ja.add(o);
			}else{
				JSONArray jb = new JSONArray();
				getTreeStr(slist,jb,list.get(i).getId());
				
				o.accumulate("children", jb);
				o.element("expanded", true);
				ja.add(o);
								
			}
		   	
		}
	    
	}
	
	
	
	/**
	 * JSON列表查询权限
	 */	
	
	public void jsonlist()throws Exception{
		System.out.println(ServletActionContext.getRequest().getRequestURL()+"?"+ServletActionContext.getRequest().getQueryString());
		try{
				
			   StringBuilder sb = new StringBuilder();
			   
			   String where = " where  " + Systemright.COL_parentid + "= " + user.getId()
				+ " and " + Systemright.COL_id + " in ( select "
				+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
				+ " where " + Sysroleright.COL_roleid + " in (select "
				+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
				+ " where " + Agentroleref.COL_customeruserid + "="
				+ getLoginUser().getId() + ")) and " + Systemright.COL_type
				+ " !=2";
		
			   
			   List<Systemright> list = Server.getInstance().getMemberService().findAllSystemright(where,"ORDER BY C_ORDERID", -1, 0);
			   JSONArray ja = new JSONArray();
			   
			   getTreeStr(list, ja, user.getId());
			   sb.append(ja.toString());
			   System.out.println(ja.toString());
	        //得到response
	        HttpServletResponse response = ServletActionContext.getResponse();
	        //设置编码
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/xml;charset=utf-8");
	        response.setHeader("Cache-Control", "no-cache");
	        PrintWriter out = response.getWriter();
	        out.write(sb.toString());
	        out.flush();
	        out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 头部导航菜单 若需添加内容 请 考虑 使用 ajax 异步请求。
	 * 
	 * @return
	 * @throws Exception
	 */
	public String topmenu() throws Exception {
		//测试多语言--陈星
	/*	List  listmap=getProperties("1", "city,name", "2");
		System.out.println("listmap=="+listmap);
		if(listmap.size()>0){
			for(int a=0;a<listmap.size();a++){
				
				Map map=(Map) listmap.get(a);
				
				testyuyan=(String) map.get((Object)("name"));
				testcity=(String) map.get((Object)("city"));
			}
			
		}*/
		//测试结束--陈星
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String where = " SELECT ID as id, C_NAME as name FROM T_SYSTEMRIGHT WHERE C_PARENTID= -1 and ID IN "
				+ "( SELECT C_RIGHTID FROM  T_SYSROLERIGHT WHERE C_ROLEID IN  "
				+ "(SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="
				+ this.getLoginUserId() + ")) and C_TYPE !=2";
		// 以下追加用于模块限制 若有新添模块 请修改 SystemrightAction中的modestr
	//	where += " AND ID IN (" + SystemrightAction.modelstr + ")";
		System.out.println(where);
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				where + " ORDER BY C_ORDERID ", null);
		// 保存首个菜单ID用于显示对应左侧菜单
		if (list.size() > 0) {
			Map m = (Map) list.get(0);
			session.setAttribute("munuid", m.get("id"));
		}

		request.setAttribute("topmenulist", list);

		return "totop";
	}

	/**
	 * 
	 * 异步获取公告信息
	 */
	public void ajaxnoticemessage() {

		// 滚动广告
		List<Sysmessage> listmessgae = Server.getInstance().getAirService()
				.findAllSysmessage("where 1=1", "ORDER BY ID DESC", -1, 0);
		StringBuilder message = new StringBuilder();
		if (listmessgae.size() > 0) {
			for (int i = 0; i < listmessgae.size(); i++) {
				message
						.append("<li> <a target='member' href='sysmessage!todetail.action?id="
								+ listmessgae.get(i).getId()
								+ "' class='font-f60'>"
								+ listmessgae.get(i).getTitle().toString()
								+ "&nbsp;&nbsp;"
								+ formatTimestampyyyyMMdd(listmessgae.get(i)
										.getCreatetime()) + "</a></li>");
			}
		} else {
			message.append("<li>暂无公告内容</li>");
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(message.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
		}

	}

	private List<Agentroleref> listAgentroleref;

	public String forwordoa() throws Exception {

		System.out.println("forwordoa===" + forwordoa);
		listAgentroleref = Server.getInstance().getMemberService()
				.findAllAgentroleref(
						" where 1=1 and " + Agentroleref.COL_customeruserid
								+ " =" + getLoginUser().getId(),
						" ORDER BY ID ", -1, 0);

		/*
		 * for (Agentroleref ag : listAgentroleref) { // 循环查询出当前用户的角色ID Long
		 * long roleid = ag.getRoleid();
		 * //System.out.println("角色ID===="+roleid);
		 * 
		 * if(roleid == 1 || roleid == 18){
		 * 
		 * String where = " where 1=1 "; ListFilecabindir =
		 * Server.getInstance().getOAService().findAllFilecabindir(where, "",
		 * -1, 0); }else { String where = " where 1=1 and
		 * "+Filecabindir.COL_right+" ="+getLoginUser().getDeptid();
		 * ListFilecabindir =
		 * Server.getInstance().getOAService().findAllFilecabindir(where, "",
		 * -1, 0); } }
		 */
		String where = " where 1=1 ";
		// ListFilecabindir =
		// Server.getInstance().getOAService().findAllFilecabindir(where, "",
		// -1, 0);

		return "forwordoa";
	}

	// 取权限名称
	public String getsysrightname(int id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findSystemright(id)
				.getName();
	}

	// 取权限代码
	public String getsysrightcode(int id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findSystemright(id)
				.getCode();
	}

	public String remaveorderuser() throws IOException {
		ActionContext.getContext().getSession().remove("orderuserlogin");
		ActionContext.getContext().getSession().remove("orderUrl");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect(urlaction);
		return "userlogin";
	}

	// 注册 通过呼叫中心或者电话
	public String createuserbyorder() throws Exception {
		ActionContext.getContext().getSession().remove("orderuserlogin");
		customeruser.setLoginname("M_" + customeruser.getMobile());
		int ran = (int) (Math.random() * 99999 + 1);
		String run = ran + "";
		customeruser.setLogpassword(Util.MD5(run));

		// customeruser.setLogpassword(Util.MD5("111111"));
		customeruser.setMobile(customeruser.getMobile());
		customeruser.setMembermobile(customeruser.getMobile());
		customeruser.setMembertype(1);
		customeruser.setState(1);
		customeruser.setAgentid(this.getLoginUser().getAgentid());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(this.getLoginUser().getLoginname());
		customeruser.setIsweb(2);
		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);
		// 赠送积分：
		new CustomeruserAction().sendMemberRegScore(customeruser);
		long memberid = customeruser.getId();
		ActionContext.getContext().getSession().put("orderuserlogin",
				customeruser);
		forword = (String) ActionContext.getContext().getSession().get(
				"orderUrl");
		if (forword != null && !"".equals(forword)) {
			HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().remove("orderUrl");
			response.sendRedirect(forword);
			return "userlogin";
		}
		// 测试发送短信
		/*
		 * String smstemple=this.getSMSTemple("AOrderInform");
		 * System.out.println(smstemple); this.smsSend(new
		 * String[]{""+customeruser.getMobile()+""}, "呼叫中心注册成功","AIcode");
		 */
		String smstemple = "";
		smstemple = this.getSMSTemple("RegisterMobile");
		smstemple = smstemple.replaceAll("@CustomerName@", customeruser
				.getMobile());
		smstemple = smstemple.replaceAll("@Gender@", "先生/女士");
		smstemple = smstemple.replaceAll("@LoginPwd@", run);

		this.smsSend(new String[] { "" + customeruser.getMobile() + "" },
				smstemple, "", getLoginUserId() + "");
		/*
		 * String smstemple="";
		 * 
		 * smstemple=this.getSMSTemple("RegisterCustomer");
		 * smstemple=smstemple.replaceAll("@CustomerName@",customeruser.getMobile());
		 * smstemple=smstemple.replaceAll("@Gender@","先生/女士"); this.smsSend(new
		 * String[]{""+customeruser.getMobile()+""}, smstemple,"");
		 */
		// 测试结束
		return this.getMemberByOrder();
	}

	/**
	 * 查询会员
	 * 
	 * @return
	 */
	public String getMemberByOrder() throws Exception {
		// 如果是平台登录，则跳转到会员查询页面
		if (getLoginUserAgent().getId() == 46) {
			this.toMemberSearch();
		} else {
			// 国内机票业务

			if (ywtype == 0) {
				forword = (String) ActionContext.getContext().getSession().get(
						"orderUrl");
			} else if (ywtype == 1) {
				forword = "b2bairsearch.action";
			} else if (ywtype == 2) {
				forword = "hoteluserbook.action?ty=1";
			} else if (ywtype == 3) {
				forword = "triplinebook.action";
			} else if (ywtype == 4) {
				forword = "bookcar.action";
			} else if (ywtype == 5) {
				HttpServletRequest request = ServletActionContext.getRequest();
				String rechtype = request.getParameter("rechtype");
				if (rechtype.equals("1")) {
					forword = "ofcard.action";
				} else if (rechtype.equals("2")) {
					forword = "ofcard!toQmoneyRecharge.action";
				}
			} else if (ywtype == 6) {
				forword = "train.action";
			} else if (ywtype == 7) {
				forword = "interticket.action";
			} else if (ywtype == 10) {
				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=0";
			} else if (ywtype == 9) {
				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=1";
			} else if (ywtype == 8) {// 国际酒店预订

				forword = "interhotelbook.action";
			} else if (ywtype == 11) {// 国内PNR导入

				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=0";
			} else if (ywtype == 12) {// 国际PNR导入

				forword = "airsearch!toimportpnr.action?importtype="
						+ importtype + "&s_orderstatuspnr=" + s_orderstatuspnr
						+ "&isinter=1";
			}

			else {
				forword = "";
			}
		}
		if (getLoginUserAgent().getId() == 46) {
			return "userlogin";
		} else {
			return "forword";
		}
	}

	/**
	 * 跳转到会员查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toMemberSearch() throws Exception {
		String where = " where 1=1 and " + Customeruser.COL_membertype
				+ " = 1 AND " + Customeruser.COL_agentid
				+ " NOT IN (select ID from " + Customeragent.TABLE
				+ " where  C_AGENTISENABLE !=1 AND C_AGENTCHECKSTATUS !=1)";

		long loginagentid = this.getLoginUser().getAgentid();
		if (isNotNullOrEpt(agentidstr)) {
			agentid = Long.valueOf(agentidstr);
			if (agentid < 0) {
				where += " AND  C_AGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
						+ (0 - agentid)
						+ "  AND ( charindex(CONVERT(nvarchar,"
						+ loginagentid
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_AGENTID))> 0 OR C_AGENTID="
						+ loginagentid + " )) ";
			} else {
				where += " AND C_AGENTID=" + agentid;
			}
		} else {
			if (this.getLoginUserAgent().getAgenttype() == 1) {

			} else {
				where += " AND ( C_AGENTID="
						+ loginagentid
						+ " OR charindex(CONVERT(nvarchar,"
						+ loginagentid
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_AGENTID))> 0)";
			}
		}

		if (customeruser != null && customeruser.getMembername() != null
				&& customeruser.getMembername().trim().length() > 0) {
			where += " and " + Customeruser.COL_membername + " like '%"
					+ customeruser.getMembername() + "%'";
		}
		if (customeruser != null
				&& customeruser.getMobile().trim().length() > 0) {
			where += " and " + Customeruser.COL_mobile + " like '%"
					+ customeruser.getMobile() + "%'";
		}
		System.out.println(where);
		pageinfo.setPagerow(10);
		List list = Server.getInstance().getMemberService()
				.findAllCustomeruserForPageinfo(where, "ORDER BY ID DESC",
						pageinfo);
		if (list != null && list.size() > 0) {
			pageinfo = (PageInfo) list.remove(0);
			listCustomeruser = list;
		}

		String agentroot = new CustomeragentAction().getAgentRoot();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("agentroot", agentroot);
		return "userlogin";
	}

	private void getString(long id, long agid, long flag) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ agid, "ORDER BY ID", -1, 0);
		if (flag > 0) {

			treestr += "var sub_" + agid
					+ " = new Ext.tree.TreeNode({ id:'company" + agid
					+ "',  text:'" + getagentname_b2bback(agid) + "'});\n";

			treestr += "root.appendChild(sub_" + agid + ");\n";
		}
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "sub_" + agid + ".appendChild(sub_" + m.getId()
							+ ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId(), agid, -1);
			}
		}

	}

	public String setorderuserlogin() throws IOException {

		if (forword.equals("0")) {
			forword = (String) ActionContext.getContext().getSession().get(
					"orderUrl");
		} else if (forword.equals("1")) {
			forword = "b2bairsearch.action";
		} else if (forword.equals("2")) {
			forword = "hoteluserbook.action?ty=1";
		} else if (forword.equals("3")) {
			forword = "triplinebook.action";
		} else if (forword.equals("4")) {
			forword = "bookcar.action";
		} else if (forword.equals("5")) {
			HttpServletRequest request = ServletActionContext.getRequest();
			String rechtype = request.getParameter("rechtype");
			if (rechtype.equals("1")) {
				forword = "ofcard.action";
			} else if (rechtype.equals("2")) {
				forword = "ofcard!toQmoneyRecharge.action";
			}
		} else if (forword.equals("6")) {
			forword = "train.action";
		} else if (forword.equals("7")) {
			forword = "interticket.action";
		} else if (forword.equals("pnr")) {
			forword = "airsearch!toimportpnr.action?importtype=" + importtype
					+ "&s_orderstatuspnr=" + s_orderstatuspnr + "&isinter=0";
		} else if (forword.equals("gjpnr")) {
			forword = "airsearch!toimportpnr.action?importtype=" + importtype
					+ "&s_orderstatuspnr=" + s_orderstatuspnr + "&isinter=1";
		} else if (forword.equals("8")) {// 国际酒店预订

			forword = "interhotelbook.action";
		} else {
			forword = "";
		}
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderuserid);

		ActionContext.getContext().getSession().put("orderuserlogin",
				customeruser);
		// 加载联系人行用卡列表
		System.out.println(forword);
		if (forword != null && !"".equals(forword)) {
			HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().remove("orderUrl");
			response.sendRedirect(forword);
			return "userlogin";
		}

		return "userlogin";
	}

	public String getContentitemName(String id) {
		if (id.indexOf("company") >= 0) {
			return Server.getInstance().getMemberService().findCustomeragent(
					Long.parseLong(id.replace("company", "")))
					.getAgentcompanyname();
		} else {
			return Server.getInstance().getMemberService().findDepartment(
					Long.parseLong(id)).getName();
		}
	}

	/**
	 * 转向至欢迎页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String towelcome() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();

		// 客服QQ信息
		List<Qqtype> listqqtype = Server.getInstance().getMemberService()
				.findAllQqtype("where 1=1", "ORDER BY " + Qqtype.COL_index, -1,
						0);
		for (int i = 0; i < listqqtype.size(); i++) {
			s_qqlistinfo += "<tr><td class='tableheader2'><b>"
					+ listqqtype.get(i).getTypename() + "</b></td></tr>";
			List<Qqinfo> listqqinfo = Server.getInstance().getMemberService()
					.findAllQqinfo(
							"where " + Qqinfo.COL_qqtype + "="
									+ listqqtype.get(i).getId(),
							"Order by " + Qqinfo.COL_qqnumberindex, -1, 0);
			s_qqlistinfo += "<tr onmouseout='this.className=&#39;listresult&#39;;' onmouseover='this.className=&#39;listresultMouseOver&#39;' class='listresult'><td>";
			for (int j = 0; j < listqqinfo.size(); j++) {
				s_qqlistinfo += "&nbsp;&nbsp;<a href='#'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="
						+ listqqinfo.get(j).getQqnumber()
						+ "&site=qq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"
						+ listqqinfo.get(j).getQqnumber()
						+ ":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a>";

			}
			s_qqlistinfo += "</td></tr>";
		}
		// // 返佣规则列表
		// List<Rebaterule> listrebate = Server.getInstance().getMemberService()
		// .findAllRebaterule("where 1=1", "ORDER BY ID", -1, 0);
		// for (int i = 0; i < listrebate.size(); i++) {
		// strrebatehtml += "<tr
		// onmouseout='this.className=&#39;listresult&#39;;'onmouseover='this.className=&#39;listresultMouseOver&#39;'class='listresult'>";
		// Customeragent loginagent = getLoginsessionagent();
		// strrebatehtml += "<td>"
		// + getAgentTypeName(loginagent.getAgentjibie())
		// + "</td><td>"
		// + getyewuleixing(listrebate.get(i).getRuletypeid())
		// + "</td><td>"
		// + formatMoney_string(listrebate.get(i).getRebatvalue()
		// * 100 + "") + "%</td>";
		// strrebatehtml += "</tr>";
		// }
		String first=request.getParameter("first");
		if(first!=null){
			request.setAttribute("first", "true");
		}
		return "welcome";
	}

	public String getTripOrderState(Integer id) {
		String streturn = "";
		if (id == 0) {
			streturn = "待确认";
		} else if (id == 1) {
			streturn = "完成";
		}
		return streturn;
	}

	public String getStateToString(Integer id) {
		switch (id) {
		case 0:

			return "新订单等待支付";

		case 1:

			return "采购商取消交易，交易结束";

		case 2:

			return "已经付款，等待出票";

		case 3:

			return "已经出票，交易结束";

		case 4:

			return "取消出票，等待退款";

		case 5:

			return "改签订单，等待审核";

		case 6:

			return "改签审核通过，机票被挂起，等待支付";

		case 7:

			return "已经付款，等待解挂";

		case 8:

			return "已经解挂，交易结束";

		case 9:

			return "改签订单审核不通过，交易结束";

		case 10:

			return "退票订单，等待审核";

		case 11:

			return "已经退款，交易结束";

		case 12:

			return "退票订单审核不通过，交易结束";

		case 13:

			return "废票订单，等待审核";

		case 14:

			return "废票审核通过，等待退款";

		case 15:

			return "废退票订单审核不通过，交易结束";

		case 16:

			return "退款订单，延迟处理";

		case 17:

			return "线下订单待确认";

		case 18:

			return "线下订单审核不通过，交易结束";

		case 19:

			return "暂不能出票，等待处理";

		default:
			return "未知状态";
		}
	}

	/**
	 * 截取字符串
	 * 
	 * @param str
	 * @return
	 */
	public String subString(String str) {
		return (str == null || "".equals(str)) ? "" : str.length() <= 10 ? str
				: str.substring(0, 10) + "…";
	}

	public Object getModel() {
		return user;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getValidateImg() {
		return validateImg;
	}

	public void setValidateImg(String validateImg) {
		this.validateImg = validateImg;
	}

	public Customeruser getUser() {
		return user;
	}

	public void setUser(Customeruser user) {
		this.user = user;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public Customeragent getAgent() {
		return agent;
	}

	public void setAgent(Customeragent agent) {
		this.agent = agent;
	}

	public List<Sysmessage> getSysmessageList() {
		return sysmessageList;
	}

	public void setSysmessageList(List<Sysmessage> sysmessageList) {
		this.sysmessageList = sysmessageList;
	}

	public String getForwordoa() {
		return forwordoa;
	}

	public void setForwordoa(String forwordoa) {
		this.forwordoa = forwordoa;
	}

	public List<Filecabindir> getListFilecabindir() {
		return ListFilecabindir;
	}

	public void setListFilecabindir(List<Filecabindir> listFilecabindir) {
		ListFilecabindir = listFilecabindir;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Orderinfo> getTicketorderlist() {
		return ticketorderlist;
	}

	public void setTicketorderlist(List<Orderinfo> ticketorderlist) {
		this.ticketorderlist = ticketorderlist;
	}

	public Customeruser getCustomeruser() {
		return customeruser;
	}

	public void setCustomeruser(Customeruser customeruser) {
		this.customeruser = customeruser;
	}

	public List<Customeruser> getListCustomeruser() {
		return listCustomeruser;
	}

	public void setListCustomeruser(List<Customeruser> listCustomeruser) {
		this.listCustomeruser = listCustomeruser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Agentroleref> getListAgentroleref() {
		return ListAgentroleref;
	}

	public void setListAgentroleref(List<Agentroleref> listAgentroleref) {
		ListAgentroleref = listAgentroleref;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public int getS_membertype() {
		return s_membertype;
	}

	public void setS_membertype(int s_membertype) {
		this.s_membertype = s_membertype;
	}

	public boolean agentAble(long agenid, long id) {
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(agenid);
		int able = agent.getAgentisenable();// 是否启用
		Customeruser user = Server.getInstance().getMemberService()
				.findCustomeruser(id);

		if (user.getIsenable() == null) {
			user.setIsenable(1);
		}
		int userable = user.getIsenable();
		if (userable != 1) {
			return false;
		}
		if (able != 1) {
			return false;
		}
		return true;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

	public String getImporttype() {
		return importtype;
	}

	public void setImporttype(String importtype) {
		this.importtype = importtype;
	}

	public int getPuserflag() {
		return puserflag;
	}

	public void setPuserflag(int puserflag) {
		this.puserflag = puserflag;
	}

	public String getS_orderstatuspnr() {
		return s_orderstatuspnr;
	}

	public void setS_orderstatuspnr(String s_orderstatuspnr) {
		this.s_orderstatuspnr = s_orderstatuspnr;
	}

	public int getIsinter() {
		return isinter;
	}

	public void setIsinter(int isinter) {
		this.isinter = isinter;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStrrebatehtml() {
		return strrebatehtml;
	}

	public void setStrrebatehtml(String strrebatehtml) {
		this.strrebatehtml = strrebatehtml;
	}

	public String getS_qqlistinfo() {
		return s_qqlistinfo;
	}

	public void setS_qqlistinfo(String s_qqlistinfo) {
		this.s_qqlistinfo = s_qqlistinfo;
	}

	public int getYwtype() {
		return ywtype;
	}

	public void setYwtype(int ywtype) {
		this.ywtype = ywtype;
	}

	public List<Rebaterule> getListRebaterule() {
		return listRebaterule;
	}

	public void setListRebaterule(List<Rebaterule> listRebaterule) {
		this.listRebaterule = listRebaterule;
	}

	public String getShengdailizongshu() {
		return shengdailizongshu;
	}

	public void setShengdailizongshu(String shengdailizongshu) {
		this.shengdailizongshu = shengdailizongshu;
	}

	public String getShidailizongshu() {
		return shidailizongshu;
	}

	public void setShidailizongshu(String shidailizongshu) {
		this.shidailizongshu = shidailizongshu;
	}

	public String getQuyudailizongshu() {
		return quyudailizongshu;
	}

	public void setQuyudailizongshu(String quyudailizongshu) {
		this.quyudailizongshu = quyudailizongshu;
	}

	public String getJingjirenzongshu() {
		return jingjirenzongshu;
	}

	public void setJingjirenzongshu(String jingjirenzongshu) {
		this.jingjirenzongshu = jingjirenzongshu;
	}

	public String getTicketordernum() {
		return ticketordernum;
	}

	public void setTicketordernum(String ticketordernum) {
		this.ticketordernum = ticketordernum;
	}

	public String getHotelordernum() {
		return hotelordernum;
	}

	public void setHotelordernum(String hotelordernum) {
		this.hotelordernum = hotelordernum;
	}

	public String getTripordernum() {
		return tripordernum;
	}

	public void setTripordernum(String tripordernum) {
		this.tripordernum = tripordernum;
	}

	public String getCarordernum() {
		return carordernum;
	}

	public void setCarordernum(String carordernum) {
		this.carordernum = carordernum;
	}

	public String getMobileordernum() {
		return mobileordernum;
	}

	public void setMobileordernum(String mobileordernum) {
		this.mobileordernum = mobileordernum;
	}

	public String getQqordernum() {
		return qqordernum;
	}

	public void setQqordernum(String qqordernum) {
		this.qqordernum = qqordernum;
	}

	public String getTotalordernum() {
		return totalordernum;
	}

	public void setTotalordernum(String totalordernum) {
		this.totalordernum = totalordernum;
	}

	public int getRechtype() {
		return rechtype;
	}

	public void setRechtype(int rechtype) {
		this.rechtype = rechtype;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public String getAgentidstr() {
		return agentidstr;
	}

	public void setAgentidstr(String agentidstr) {
		this.agentidstr = agentidstr;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public List getMenulist() {
		return menulist;
	}

	public void setMenulist(List menulist) {
		this.menulist = menulist;
	}



}