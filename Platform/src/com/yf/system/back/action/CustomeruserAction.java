/** 
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.bussiness.Bussiness;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeraircard.Customeraircard;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerintegralrecord.Customerintegralrecord;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.eaccount.Eaccount;
import com.yf.system.base.integral.Integral;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.base.telephone.Telephone;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class CustomeruserAction extends B2b2cbackAction {
	private static final long serialVersionUID = 8093019860394903878L;
	private List<Customeruser> listCustomeruser;
	private Customeruser customeruser = new Customeruser();
	private Customeragent customeragent = new Customeragent();
	private List<Department> listdepartment;
	private List<Systemrole> listSystemrole;
	private List<Customeruser> listb2cCustomeruser;
	private List<Customeragent> listCustomeragent;
	private List<Customercredit> listCustomercredit;
	private String agendept;// 加盟商Id或其部门Id
	private String treestr = "";
	private String strcompanyid;
	private long companyid;
	private String clientpwd;// 修改密码时客户端原始密码
	private String s_isview = "";
	private String parentagentid;
	private String s_agentjibie;

	private String stringroid;

	// 管理员权限数据库对应数值
	private Long pretyAdmin = 10036L;
	// 普通员工权限数据库对应数值
	private Long pretyElmp = 10063L;
	private Boolean pretBool = false;

	// 证件列表
	private Customercredit customercredit = new Customercredit();
	// 联系电话列表
	private List<Telephone> listTelephone;
	// 里程卡列表
	private List<Customeraircard> listCustomeraircard;
	// 批量操作选项

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项

	private int opt;

	private String cusagentname;

	private long memberid;//
	private long roid;
	private long angid;
	private long memid;
	private String s_shenfz;
	private int credittype;
	private String creditnumber;
	private long rightid;
	private String compnayid;
	private long customeragentid;

	private long customerdeptid;
	// 跳转路径
	private String forward;
	private String forward2;
	// 加盟商类型
	private int operationType;
	// 生日
	private String c_birthday;
	// search
	private String s_name;
	private int caid1;
	private String strCusID;
	private String strCustName;
	private String strMobile;
	private String strIsWeb;
	private String s_cardnunber;
	private int cardType;

	private String fenxiaotel;
	private String fenxiaouser;
	private String fenxiaoname;

	private String gongyingtel;
	private String gongyinguser;
	private String gongyingname;

	private String yunyingtel;
	private String yunyinguser;
	private String yunyingname;

	private File[] charter;
	private File[] logo;
	private File[] index01;
	private File[] index02;
	private File[] index03;
	private File[] index04;
	private File[] index05;
	private File[] indexad01;
	private File[] indexad02;
	private File[] indexad03;
	private File[] hotel;
	private File[] air01;
	private File[] air02;
	private File[] air03;
	private File[] inair01;
	private File[] inair02;
	private File[] inair03;
	private File[] travel;

	private String logopath;
	private String index01path;
	private String index02path;
	private String index03path;
	private String index04path;
	private String index05path;
	private String indexad01path;
	private String indexad02path;
	private String indexad03path;
	private String hotelpath;
	private String air01path;
	private String air02path;
	private String air03path;
	private String inair01path;
	private String inair02path;
	private String inair03path;
	private String travelpath;
	private String s_begintime;
	private String s_endtime;

	private String ISWEB;
	/**
	 * 判断上传文件是否合法
	 * 
	 * @param filename
	 * @return
	 */
	private static String[] fileStrs = { "gif", "jpg" };

	private boolean isIllegalfile(String filename) {
		int count = 0;
		for (String str : fileStrs) {
			if (!filename.endsWith(str)) {
				count++;
			}
		}
		if (count < fileStrs.length) {
			return true;
		}
		// 如果计数器等于过滤个数，放弃此次操作
		return false;
	}

	/**
	 * 添加文件
	 */
	public String uplogo() throws Exception {

		// String filepath = "/"+"web"+"/" +"images" +"/";
		// System.out.println(filepath);
		String realPath = getlogoPath();
		System.out.println(realPath);

		File s = new File(realPath);
		if (!s.exists()) {
			s.mkdirs();
		}
		File f = new File("");

		if (charter != null && charter[0] != null) {
			f = this.charter[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = Util.getFilename(f.getName());

				Util.copyfile(f, new File(s.getPath() + "/" + newname));

			}
		}
		if (logo != null && logo[0] != null) {
			f = this.logo[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "logo.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				logopath = getlogoShowPath() + newname;
				System.out.println("logo图片地址==" + logopath);
			}

		}
		if (index01 != null && index01[0] != null) {
			f = this.index01[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {

				System.out.println("f.getName()===" + f.getName());
				String newname = "01.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				index01path = getlogoShowPath() + newname;
				System.out.println("index01图片地址==" + index01path);
			}

		}
		if (index02 != null && index02[0] != null) {
			f = this.index02[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "02.jpg";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				index02path = getlogoShowPath() + newname;
				System.out.println("index02图片地址==" + index02path);
			}

		}
		if (index03 != null && index03[0] != null) {
			f = this.index03[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "03.jpg";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				index03path = getlogoShowPath() + newname;
				System.out.println("index03图片地址==" + index03path);
			}

		}
		if (index04 != null && index04[0] != null) {
			f = this.index04[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "04.jpg";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				index04path = getlogoShowPath() + newname;
				System.out.println("index04图片地址==" + index04path);
			}

		}
		if (index05 != null && index05[0] != null) {
			f = this.index05[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "05.jpg";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				index05path = getlogoShowPath() + newname;
				System.out.println("index05图片地址==" + index05path);
			}

		}
		if (indexad01 != null && indexad01[0] != null) {
			f = this.indexad01[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "index_01.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				indexad01path = getlogoShowPath() + newname;
				System.out.println("indexad01图片地址==" + indexad01path);
			}

		}
		if (indexad02 != null && indexad02[0] != null) {
			f = this.indexad02[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "index_02.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				indexad02path = getlogoShowPath() + newname;
				System.out.println("indexad02图片地址==" + indexad02path);
			}

		}
		if (indexad03 != null && indexad03[0] != null) {
			f = this.indexad03[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "index_03.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				indexad03path = getlogoShowPath() + newname;
				System.out.println("indexad03图片地址==" + indexad03path);
			}

		}
		if (hotel != null && hotel[0] != null) {
			f = this.hotel[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "hotel_01.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				hotelpath = getlogoShowPath() + newname;

				System.out.println("hotel图片地址==" + hotelpath);
			}

		}
		if (air01 != null && air01[0] != null) {
			f = this.air01[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "air_01.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				air01path = getlogoShowPath() + newname;
				System.out.println("air01图片地址==" + air01path);
			}

		}
		if (air02 != null && air02[0] != null) {
			f = this.air02[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "air_02.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				air01path = getlogoShowPath() + newname;
				System.out.println("air02图片地址==" + air02path);
			}

		}
		if (air03 != null && air03[0] != null) {
			f = this.air03[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "air_03.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				air03path = getlogoShowPath() + newname;
				System.out.println("air03图片地址==" + air03path);
			}

		}
		if (inair01 != null && inair01[0] != null) {
			f = this.inair01[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "inair_01.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				inair01path = getlogoShowPath() + newname;
				System.out.println("inair01图片地址==" + inair01path);
			}

		}
		if (inair02 != null && inair02[0] != null) {
			f = this.inair02[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "inair_02.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				inair01path = getlogoShowPath() + newname;
				System.out.println("inair02图片地址==" + inair02path);
			}

		}
		if (inair03 != null && inair03[0] != null) {
			f = this.inair03[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "inair_03.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				inair03path = getlogoShowPath() + newname;
				System.out.println("inair03图片地址==" + inair03path);
			}

		}
		if (travel != null && travel[0] != null) {
			f = this.travel[0];
			System.out.println(s.getPath() + "/" + f.getName());
			String w = f.getName().toLowerCase();

			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			} else {
				String newname = "trave_01.gif";

				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				travelpath = getlogoShowPath() + newname;
				System.out.println("travel图片地址==" + travelpath);
			}

		}
		return "upok";
	}

	public String getS_begintime() {
		return s_begintime;
	}

	public void setS_begintime(String s_begintime) {
		this.s_begintime = s_begintime;
	}

	public String getS_endtime() {
		return s_endtime;
	}

	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}

	public String addUserRo() throws Exception {
		/*
		 * System.out.println("memberid=="+memberid);
		 * System.out.println("roid=="+roid);
		 * 
		 * System.out.println("stringroid=="+stringroid);
		 */

		Server.getInstance().getMemberService().excuteAgentrolerefBySql(
				"delete from " + Agentroleref.TABLE + " where "
						+ Agentroleref.COL_customeruserid + " = " + memberid);

		String[] strarrUserRo = stringroid.split(",");

		for (int i = 0; i < strarrUserRo.length; i++) {

			if (strarrUserRo[i] != null
					&& !strarrUserRo[i].toString().equals(" ")) {
				Agentroleref agentroleref = new Agentroleref();
				agentroleref.setCustomeruserid(memberid);
				agentroleref.setRoleid(Long.parseLong(strarrUserRo[i].trim()));

				Server.getInstance().getMemberService().createAgentroleref(
						agentroleref);

			}

		}

		return this.touser();

	}

	/**
	 * 向指定用户分配单个角色
	 * 
	 * @param uid
	 *            用户id
	 * @param roleid
	 *            角色id
	 */
	public void grantRoletoUser(long uid, long roleid) {
		Agentroleref agentroleref = new Agentroleref();
		agentroleref.setCustomeruserid(uid);
		agentroleref.setRoleid(roleid);
		try {
			Server.getInstance().getMemberService().createAgentroleref(
					agentroleref);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向指定用户分配多个角色
	 * 
	 * @param uid
	 *            用户id
	 * @param rolesid
	 *            角色集
	 */
	public void grantRolestoUser(long uid, List<Systemrole> roles) {
		if (roles != null) {
			for (Systemrole role: roles) {
				grantRoletoUser(uid, role.getId());
			}
		}

	}

	/**
	 * 列表查询会员
	 */
	public String execute() throws Exception {

		String where = " WHERE 1=1 AND " + Customeruser.COL_membertype + " =1 ";
		if (!isAdmin() && getLoginUser().getType() != 1) {// admin或平台员工
			where += " AND " + Customeruser.COL_agentid + " ="
					+ getLoginUser().getAgentid();
		} else {
			where += " AND " + Customeruser.COL_id + " <>" + getLoginUserId();
		}
		if (customeruser.getLoginname() != null
				&& customeruser.getLoginname().trim().length() > 0) {
			where += " AND " + Customeruser.COL_loginname + " LIKE '%"
					+ customeruser.getLoginname() + "%'";
		}
		if (customeruser.getCreateuser() != null
				&& customeruser.getCreateuser().trim().length() > 0) {
			where += " AND " + Customeruser.COL_createuser + " LIKE '%"
					+ customeruser.getCreateuser() + "%' ";
		}
		if (s_begintime != null && s_begintime.trim().length() > 0) {
			if (s_endtime != null && s_endtime.trim().length() > 0) {
				where += " AND ( " + Customeruser.COL_createtime + " BETWEEN '"
						+ s_begintime + " 00:00:00' AND '" + s_endtime
						+ " 23:59:59' )";
			}
		}
		if (s_name != null && s_name.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ s_name.trim() + "%'";
		}
		if (s_shenfz != null && s_shenfz.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ s_shenfz.trim() + "%'";
		}

		System.out.println(where);
		List list = Server.getInstance().getMemberService()
				.findAllCustomeruserForPageinfo(where,
						" ORDER BY " + Customeruser.COL_id + " DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeruser = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeruser.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeruserForPageinfo(where, " ORDER BY ID DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeruser = list;
		}
		return SUCCESS;
	}

	public boolean hasRole(int memberid, long roleid) {
		System.out.println("hasRole" + memberid + "hasRole" + roleid);
		String where = " where " + Agentroleref.COL_customeruserid + " = "
				+ memberid + " and " + Agentroleref.COL_roleid + "=" + roleid;
		if (Server.getInstance().getMemberService().findAllAgentroleref(where,
				"", -1, 0).size() <= 0) {
			return false;

		} else {
			return true;
		}

	}

	private List<Sysroleright> listSysroleright;
	private List<Agentroleref> listAgentroleref;
	/**
	 * 测试菜单
	 */
	ArrayList rlist = new ArrayList();
	ArrayList rlist1 = new ArrayList();
	ArrayList rlist2 = new ArrayList();
	ArrayList rlist3 = new ArrayList();
	ArrayList rlist4 = new ArrayList();
	HashSet hs1 = new HashSet();
	Map list = new HashMap();

	Map map = new HashMap();
	Map map1 = new HashMap();

	public String foo() throws Exception {
		listAgentroleref = Server.getInstance().getMemberService()
				.findAllAgentroleref(
						" where 1=1 and " + Agentroleref.COL_customeruserid
								+ " =" + getLoginUser().getId(),
						" ORDER BY ID ", -1, 0);

		/*
		 * System.out.println("rightid==="+rightid); listAgentroleref =
		 * Server.getInstance().getMemberService().findAllAgentroleref( " where
		 * 1=1 and "+Agentroleref.COL_customeruserid+"
		 * ="+getLoginUser().getId(), " ORDER BY ID ", -1, 0);
		 * 
		 * for (Agentroleref ag : listAgentroleref) { // 循环查询出当前用户的角色ID Long
		 * roleid = ag.getRoleid(); //System.out.println("角色ID===="+roleid);
		 * //根据角色ID去查询出对应的权限 listSysroleright =
		 * Server.getInstance().getMemberService().findAllSysroleright( " where
		 * 1=1 and " +Sysroleright.COL_roleid + " ="+roleid, " ORDER BY ID ",
		 * -1, 0);
		 * 
		 * for (Sysroleright rr : listSysroleright) { // 循环查询出当前角色所对应的权限 Long
		 * rid = rr.getRightid(); String rightCode =
		 * Server.getInstance().getMemberService().findSystemright(rid).getCode();
		 * String rightname =
		 * Server.getInstance().getMemberService().findSystemright(rid).getName();
		 * long Pid =
		 * Server.getInstance().getMemberService().findSystemright(rid).getParentid();
		 * 
		 * //System.out.println("所有的权限ID===="+rid+" 权限名称=="+rightname+"
		 * 权限代码=="+rightCode); if(Pid == rightid){ rlist2.add(rid);
		 * 
		 * System.out.println("权限ID=="+rid+" 权限名称=="+rightname+"
		 * 权限代码=="+rightCode); }else{
		 * 
		 * long righttype =
		 * Server.getInstance().getMemberService().findSystemright(rid).getType();
		 * if(righttype==1){ rlist3.add(rid); long Ppid =
		 * Server.getInstance().getMemberService().findSystemright(rid).getParentid();
		 * 
		 * long Pppid =
		 * Server.getInstance().getMemberService().findSystemright(Ppid).getParentid();
		 * 
		 * if(Pppid==rightid){
		 * 
		 * rlist4.add(rid); System.out.println("权限ID========"+rid+"
		 * 权限名称======"+rightname+" 权限代码======"+rightCode); } } }
		 * 
		 * //System.out.println("权限ID===="+rid+" 权限名称=="+rightname+"
		 * 权限代码=="+rightCode); else { long righttype =
		 * Server.getInstance().getMemberService().findSystemright(rid).getType();
		 * if(righttype==0){
		 * 
		 * rlist2.add(rid); }else{ rlist3.add(rid); } } } }
		 * 
		 */

		return "test";
	}

	private List<Sysroleright> listRoot;
	private String companyname;

	public List<Sysroleright> getListRoot() {
		return listRoot;
	}

	public void setListRoot(List<Sysroleright> listRoot) {
		this.listRoot = listRoot;
	}

	public String getangdep() throws Exception {// 根据加盟商ID查部门
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");

		PrintWriter out = null;
		StringBuffer listid = new StringBuffer();
		StringBuffer listname = new StringBuffer();
		StringBuffer idname = new StringBuffer();
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						" where 1=1 and " + Department.COL_agentid + " ="
								+ angid, "", -1, 0);
		if (list.size() > 0) {
			for (int a = 0; a < list.size(); a++) {

				listid.append(list.get(a).getId() + ",");
				listname.append(list.get(a).getName() + ",");
			}

			idname.append(listid + "/");
			idname.append(listname);

			Writer writer = response.getWriter();
			writer.write(idname.toString());

			writer.flush();
			writer.close();

		} else {
			Writer writer = response.getWriter();
			writer.write("no");

			writer.flush();
			writer.close();

		}

		return "";

	}

	public List<Sysroleright> getListSub(long rid) {
		String where = " where  " + Systemright.COL_parentid + "= " + rid
				+ " and " + Systemright.COL_id + " in ( select "
				+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
				+ " where " + Sysroleright.COL_roleid + " in (select "
				+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
				+ " where " + Agentroleref.COL_customeruserid + "="
				+ getLoginUser().getId() + ")) and " + Systemright.COL_type
				+ " !=2";

		return Server.getInstance().getMemberService().findAllSystemright(
				where, "ORDER BY C_ORDERID", -1, 0);
	}

	/**
	 * 加载左侧菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String leftmenu() throws Exception {
		if (rightid == -1) {// 首次登陆进来
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Object menuid = session.getAttribute("munuid");
			while (menuid == null) {
				menuid = session.getAttribute("munuid");
			}
			try {
				rightid = Long.valueOf(menuid.toString());
				session.removeAttribute("munuid");
			} catch (Exception e) {

			}
		}

		String where = " where  " + Systemright.COL_parentid + "= " + rightid
				+ " and " + Systemright.COL_id + " in ( select "
				+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
				+ " where " + Sysroleright.COL_roleid + " in (select "
				+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
				+ " where " + Agentroleref.COL_customeruserid + "="
				+ getLoginUser().getId() + ")) and " + Systemright.COL_type
				+ " !=2";
		// System.out.println("where==" + where);
		listRoot = Server.getInstance().getMemberService().findAllSystemright(
				where, "ORDER BY C_ORDERID", -1, 0);

		return "forward";
	}

	public List getSysright(long id, long rightid) throws Exception {

		System.out.println("rightid====" + rightid + "id===" + id);
		listAgentroleref = Server.getInstance().getMemberService()
				.findAllAgentroleref(
						" where 1=1 and " + Agentroleref.COL_customeruserid
								+ " =" + getLoginUser().getId(),
						" ORDER BY ID ", -1, 0);

		for (Agentroleref ag : listAgentroleref) {

			// 循环查询出当前用户的角色ID
			Long roleid = ag.getRoleid();
			// System.out.println("角色ID===="+roleid);
			// 根据角色ID去查询出对应的权限
			listSysroleright = Server.getInstance().getMemberService()
					.findAllSysroleright(
							" where 1=1 and " + Sysroleright.COL_roleid + " ="
									+ roleid, " ORDER BY ID ", -1, 0);

			for (Sysroleright rr : listSysroleright) {
				// 循环查询出当前角色所对应的权限
				Long rid = rr.getRightid();
				String rightCode = Server.getInstance().getMemberService()
						.findSystemright(rid).getCode();
				String rightname = Server.getInstance().getMemberService()
						.findSystemright(rid).getName();
				long Pid = Server.getInstance().getMemberService()
						.findSystemright(rid).getParentid();
				long righttype = Server.getInstance().getMemberService()
						.findSystemright(rid).getType();
				System.out
						.println("所有的权限ID====" + rid + "   权限名称==" + rightname
								+ "   权限代码==" + rightCode + "  父ID==" + Pid);

				if (righttype == 1 && Pid == id) {
					rlist4.add(rid);

				}
			}

			HashSet<String> hashSet = new HashSet<String>(rlist4);
			List<String> rlist4 = new ArrayList<String>(hashSet);
			for (Object item : rlist4) {
				System.out.println("item==" + item);
			}
		}

		return rlist4;
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

	/**
	 * 转向到会员添加页面
	 */
	public String toadd() throws Exception {
		this.getAgentRootStr();
		return EDIT;
	}

	public void getAgentRootStr() {
		String agentroot = new CustomeragentAction().getAgentRoot();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("agentroot", agentroot);
	}

	/**
	 * @return
	 * @throws Exception
	 *             转到网上注册会员添加页面
	 */
	public String tob2cadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到logo添加页面
	 */
	public String tologo() throws Exception {

		return "tologo";
	}

	/**
	 * 转向到B2C会员列表页面
	 */
	public String tob2c() throws Exception {

		String where = " where 1=1 and " + Customeruser.COL_membertype + " =1"
				+ " and " + Customeruser.COL_isweb + " =1";
		
		where+=" AND "+Customeruser.COL_agentid+" ="+getLoginUser().getAgentid();

		if (s_name != null && s_name.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ s_name.trim() + "%'";
		}
		if (s_shenfz != null && s_shenfz.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ s_shenfz.trim() + "%'";
		}
		String createuser = ServletActionContext.getRequest().getParameter(
				"s_createuser");
		if (createuser != null && createuser.trim().length() > 0) {
			where += " AND " + Customeruser.COL_createuser + " LIKE '%"
					+ createuser + "%'";
		}
		if (s_begintime != null && s_begintime.trim().length() > 0) {
			if (s_endtime != null && s_endtime.trim().length() > 0) {
				where += " AND (" + Customeruser.COL_createtime + " BETWEEN '"
						+ s_begintime + " 00:00:00' AND '" + s_endtime
						+ " 23:59:59' )";
			}

		}
		
		System.out.println("B2CWHERE:"+where);
		
		List list = Server.getInstance().getMemberService()
				.findAllCustomeruserForPageinfo(where, " ORDER BY ID DESC ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listb2cCustomeruser = list;
		if (pageinfo.getTotalrow() > 0 && listb2cCustomeruser.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeruserForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listb2cCustomeruser = list;
		}

		return "tob2c";
	}

	/**
	 * 转向到会员分配页面
	 * 
	 */

	public String tograntRole() throws Exception {
		StringBuilder roleid=new StringBuilder("0");
		for(Bussiness bussiness:this.getLoginsessionagent().getBussinesslist()){
			roleid.append(","+bussiness.getId());
		}
		String where="WHERE ID>0 AND C_BUSSINESSID IN ("+roleid+") ";
		if (this.getLoginsessionagent().getAgenttype()==1) {// 平台人员
			if(!isAdmin()){
				where +=" AND ID IN (SELECT C_ROLEID FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="+this.getLoginUserId()+" )";
			}
			listSystemrole = Server.getInstance().getMemberService()
			.findAllSystemrole(where, " ORDER BY ID DESC ", -1, 0);

		} else {

			listSystemrole = Server.getInstance().getMemberService()
					.findAllSystemrole(
							where+"  AND ( C_CUSTOMERAGENTID=" 
							+ getLoginUser().getAgentid()+" OR ( C_TYPE="+this.getLoginsessionagent().getAgenttype()+" AND C_CUSTOMERAGENTID=46 ))",
							" ORDER BY ID DESC ", -1, 0);

		}
		
		//一起飞特殊要求
		String wh=" where 1=1 and "+Eaccount.COL_name+" ='51book'";
		List<Eaccount>listEaccount51book=Server.getInstance().getSystemService().findAllEaccount(wh, " ORDER BY ID ", -1, 0);
		String uname=	listEaccount51book.get(0).getUsername().trim();
		
		
		if(getLoginsessionagent().getAgenttype()==3&&uname.equals("GXWMYQF")){
			
			for(int a=0;a<listSystemrole.size();a++){
				
				if(listSystemrole.get(a).getId()==10036){
					listSystemrole.remove(a);
				}
			}
		}
		//
		
		
		String usql="SELECT ID AS id,C_AGENTID AS agentid,C_MEMBERNAME AS membername FROM T_CUSTOMERUSER WHERE ID="+customeruser.getId();
		this.customeruser=super.findBySql(Customeruser.class, usql);
		
		String uroles="SELECT C_ROLEID roleid FROM T_AGENTROLEREF WHERE C_CUSTOMERUSERID="+customeruser.getId();
		List userroles=Server.getInstance().getSystemService().findMapResultBySql(uroles, null);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("userroles", userroles);
		System.out.println("member/grantuserrole.jsp");
		return "tograntrole";
	}
	
	public String grantUserRole(){
		HttpServletRequest request=ServletActionContext.getRequest();
	String[] roles=request.getParameterValues("userrole");
	String sql="DELETE T_AGENTROLEREF WHERE C_CUSTOMERUSERID="+customeruser.getId();
	Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		for(String str:roles){
			Agentroleref agentrole=new Agentroleref();
			agentrole.setCustomeruserid(customeruser.getId());
			agentrole.setRoleid(Long.valueOf(str));
			try {
				Server.getInstance().getMemberService().createAgentroleref(agentrole);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return this.toEmployeelist();
	}

	public String tofenxsgly() throws Exception {
		String where = " where 1=1 and " + Customeruser.COL_isadmin + " =1";
		listAgentroleref = Server.getInstance().getMemberService()
				.findAllAgentroleref(
						" where 1=1 and " + Agentroleref.COL_customeruserid
								+ " =" + getLoginUser().getId(),
						" ORDER BY ID ", -1, 0);

		for (Agentroleref ag : listAgentroleref) { // 循环查询出当前用户的角色ID Long
			long roleid = ag.getRoleid(); // System.out.println("角色ID===="+roleid);

			if (roleid != 1) {
				where += " and " + Customeruser.COL_createuser + " like '%"
						+ getLoginUser().getLoginname() + "%'";
			}
		}
		List list = Server.getInstance().getMemberService()
				.findAllCustomeruserForPageinfo(where,
						" ORDER BY " + Customeruser.COL_createtime + " DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeruser = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeruser.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeruserForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeruser = list;
		}

		return "distrUsersList";

	}

	/**
	 * 增加角色会员关连
	 */
	public String enable() throws Exception {

		// if(!hasRight(memroleright.getRoleid() ,memroleright.getId())){
		Agentroleref agentroleref = new Agentroleref();
		agentroleref.setCustomeruserid(memberid);
		agentroleref.setRoleid(roid);

		Server.getInstance().getMemberService()
				.createAgentroleref(agentroleref);
		// }

		return "fenpei";
	}

	// 重置密码
	public String chongzhi() throws Exception {
		Customeruser cus = Server.getInstance().getMemberService()
				.findCustomeruser(memberid);

		cus.setLogpassword(Util.MD5("111111"));
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				cus);
		forward2 = "customeruser!toDistrUsersList.action?compnayid="
				+ cus.getAgentid();
		return "forward2";
	}

	/**
	 * 删除角色会员关连
	 */
	public String unable() throws Exception {

		Server.getInstance().getMemberService().excuteAgentrolerefBySql(
				"delete from " + Agentroleref.TABLE + " where "
						+ Agentroleref.COL_customeruserid + " = " + memberid
						+ " and " + Agentroleref.COL_roleid + " = " + roid);
		return "fenpei";
	}

	// 取会员名称
	public String getmembername(int id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findCustomeruser(id)
				.getMembername();
	}

	/**
	 * 转向到会员修改页面
	 */
	public String toedit() throws Exception {
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		custCreditMap(customeruser.getId());
		return EDIT;
	}

	/**
	 * @return 网上注册会员转为大客户会员
	 */
	public String tob2cUsertoBiguser() {

		String meanuwhere = "";
		if (this.isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1";
		} else {
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1 AND "
					+ Customeragent.COL_id + "="
					+ this.getLoginUser().getAgentid();
		}
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(3l, arrayagentid, true);

		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		customercredit.setRefid(customeruser.getId());
		this.criditlist();
		return "tojoinBiguser";
	}

	public String b2cUsertoBiguser() throws Exception {
		if (cusagentname != null && !cusagentname.trim().equals("")) {

			if (cusagentname.indexOf("c") >= 0) {
				customeragentid = Long.valueOf(cusagentname.substring(1));

			} else {
				customerdeptid = Long.valueOf(cusagentname.substring(0,
						cusagentname.indexOf("@")));
				customeragentid = Long.valueOf(cusagentname
						.substring(cusagentname.indexOf("@") + 1));
			}
		}
		customeruser.setAgentid(customeragentid);
		customeruser.setDeptid(customerdeptid);
		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));

		} else {

			customeruser.setLogpassword(null);
		}
		System.out.println(customeruser.getLoginname());
		customeruser.setLoginname(customeruser.getLoginname());
		customeruser.setIsweb(2); // 1是，2，不是
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);

		Customercredit customercredit = new Customercredit();

		customercredit.setCreditnumber(creditnumber);
		customercredit.setCredittypeid(credittype);
		customercredit.setCreateuser(getLoginUser().getLoginname());
		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifyuser(getLoginUser().getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
		customercredit.setType(0);
		customercredit.setRefid(customeruser.getId());
		Server.getInstance().getMemberService().createCustomercredit(
				customercredit);

		return this.tobiguser();
	}

	/**
	 * 转向到会员查看页面
	 */
	public String tochakan() throws Exception {

		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		customercredit.setRefid(customeruser.getId());
		this.criditlist();
		return "tochakan";
	}

	public void criditlist() {
		String where = " where 1=1 ";
		if (customercredit.getRefid() != null && customercredit.getRefid() > 0) {
			where += " and " + Customercredit.COL_refid + "="
					+ customercredit.getRefid();
		} else {

		}
		if (customercredit.getCredittypeid() != null
				&& customercredit.getCredittypeid() > 0) {
			where += " and " + Customercredit.COL_credittypeid + "="
					+ customercredit.getCredittypeid();
		}

		if (customercredit.getType() != null && customercredit.getType() >= 0) {
			where += " and " + Customercredit.COL_type + "="
					+ customercredit.getType();
		}
		List list = Server.getInstance().getMemberService()
				.findAllCustomercreditForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomercredit = list;
		if (pageinfo.getTotalrow() > 0 && listCustomercredit.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomercreditForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomercredit = list;
		}

	}

	/**
	 * 转向到会员审核页面
	 */
	public String tocheck() throws Exception {
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		return CHECK;
	}

	/**
	 * 添加会员
	 */
	public String add() throws Exception {

		Customeruser loginUser = this.getLoginUser();
		System.out.println(customeruser.getMembersex());
		if (customeruser.getLoginname() == "") {
			customeruser.setLoginname("M_" + customeruser.getMobile());
			customeruser.setLogpassword(Util.MD5("111111"));
			customeruser
					.setModifytime(new Timestamp(System.currentTimeMillis()));
			customeruser.setModifyuser(getLoginUser().getLoginname());
			customeruser
					.setCreatetime(new Timestamp(System.currentTimeMillis()));
			customeruser.setCreateuser(getLoginUser().getLoginname());
			customeruser.setState(1);
			// if (ServletActionContext.getRequest().getSession().getAttribute(
			// "ISWEB") != null) {
			// customeruser.setIsweb(1);// 1是网站会员
			// } else {
			customeruser.setIsweb(2);// 2不是网站会员
			// }
			customeruser.setMembertype(1);

		} else {
			customeruser
					.setModifytime(new Timestamp(System.currentTimeMillis()));
			customeruser.setModifyuser(getLoginUser().getLoginname());
			customeruser
					.setCreatetime(new Timestamp(System.currentTimeMillis()));
			customeruser.setCreateuser(getLoginUser().getLoginname());
			customeruser.setState(1);
			customeruser.setIsweb(customeruser.getIsweb());
			customeruser.setMembertype(1);

			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));

		}
		if (this.getLoginUser().getType() == 1) {
			Customeragent agent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
			customeruser.setType(agent.getAgenttype());

		} else {

			customeruser.setType(this.getLoginUser().getType());
		}
		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);
		sendMemberRegScore(customeruser);
		customercredit.setCredittypeid(this.cardType);
		customercredit.setCreditnumber(s_cardnunber);
		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
		customercredit.setRefid(customeruser.getId());
		customercredit.setCreateuser(customeruser.getMembername());
		Server.getInstance().getMemberService().createCustomercredit(
				customercredit);
		//
		return execute();
	}

	public void sendMemberRegScore(Customeruser customeruser) {
		String where = " WHERE C_AGENTTYPE=5";
		List<Integral> integrallist = Server.getInstance().getMemberService()
				.findAllIntegral(where, "", -1, 0);
		Integral integral = new Integral();
		if (integrallist.size() > 0) {
			integral = integrallist.get(0);
		}
		customeruser.setTotalscore(integral.getRegisterscore());
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		Customerintegralrecord record = new Customerintegralrecord();
		record.setCreatetime(this.getCurrentTime());
		record.setRefuid(customeruser.getId());
		record.setRefordernumber("无");
		record.setScore(integral.getRegisterscore());
		record.setScoresource("会员注册");
		record.setScorememo("会员注册-注册赠送积分：" + integral.getRegisterscore());
		try {
			Server.getInstance().getMemberService()
					.createCustomerintegralrecord(record);
		} catch (SQLException e) {
			System.out.println("会员注册赠送积分出错：");
			e.printStackTrace();
		}

	}

	/**
	 * 添加会员
	 */
	public String adusers() throws Exception {
		Customeruser loginUser = this.getLoginUser();

		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(getLoginUser().getLoginname());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(getLoginUser().getLoginname());
		customeruser.setState(1);
		customeruser.setLoginname(customeruser.getLoginname());
		if (loginUser.getMembertype() != null) {
			customeruser.setMembertype(loginUser.getMembertype());
		}
		if (loginUser.getType() != null) {
			customeruser.setType(loginUser.getType());
		}
		if (loginUser.getAgentid() != null) {
			customeruser.setAgentid(loginUser.getAgentid());
		}
		customeruser.setLogpassword(Util.MD5(customeruser.getLogpassword()));

		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);

		return "aduser";
	}

	/**
	 * 审核会员
	 */
	public String check() throws Exception {
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(getLoginUser().getLoginname());

		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		return LIST;
	}

	/**
	 * 编辑会员
	 */
	public String edit() throws Exception {
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(getLoginUser().getLoginname());

		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));

		} else {

			customeruser.setLogpassword(null);
		}

		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		this.updateCard();
		String str = ServletActionContext.getRequest().getParameter("ISWEB");
		if (str != null && str.equals("true")) {
			return this.tob2c();
		}
		return execute();
	}

	/**
	 * 编辑会员
	 */
	public String editbiguser() throws Exception {

		if (cusagentname != null && !cusagentname.trim().equals("")) {

			if (cusagentname.indexOf("c") >= 0) {
				customeragentid = Long.valueOf(cusagentname.substring(1));
				customerdeptid = 0;
			} else {
				customerdeptid = Long.valueOf(cusagentname.substring(0,
						cusagentname.indexOf("@")));
				customeragentid = Long.valueOf(cusagentname
						.substring(cusagentname.indexOf("@") + 1));
			}
		}

		customeruser.setAgentid(customeragentid);
		customeruser.setDeptid(customerdeptid);

		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		Timestamp birth = null;
		try {
			birth = dateToTimestamp(ServletActionContext.getRequest()
					.getParameter("birthday"));
		} catch (Exception e) {

		}
		customeruser.setBirthday(birth);
		customeruser.setModifyuser(getLoginUser().getLoginname());
		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));

		} else {

			customeruser.setLogpassword(null);
		}

		Customeragent ang = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());
		customeruser.setType(3);
		if (ang.getBigtype() == 1 && customeruser.getIsadmin() == 1) {// Bigtype==1
			// 大客户
			// 0不是大客户
			customeruser.setMembertype(2);// 1会员.2员工
		} else if (ang.getBigtype() == 1 && customeruser.getIsadmin() == 2) {
			customeruser.setMembertype(1);// 1会员
		} else {
			customeruser.setMembertype(2);// 2.员工
		}
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		this.updateCard();
		if (ServletActionContext.getRequest().getSession().getAttribute(
				"isFromedit") != null) {
			ServletActionContext.getRequest().getSession().removeAttribute(
					"isFromedit");
			return touser();
		}
		return "tobiguserlist";
	}

	/**
	 * @return
	 * @throws Exception
	 *             修改用户信息
	 */
	public String ajaxedituser() throws Exception {
		// String strHtml="";
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(getLoginUser().getLoginname());
		customeruser.setId(Long.parseLong(strCusID));
		customeruser.setMembername(strCustName);
		customeruser.setMobile(strMobile);
		customeruser.setIsweb(Integer.parseInt(strIsWeb));

		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		/*
		 * strHtml="更新成功";
		 * 
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * response.setContentType("text/plain; charset=utf-8"); PrintWriter out =
		 * response.getWriter(); StringBuilder sb = new StringBuilder();
		 * sb.append(strHtml); out.print(sb); out.flush(); out.close();
		 */
		updateCard();// 修改证件号
		ServletActionContext.getRequest()
				.setAttribute("updateMessage", "更新成功！");
		return "tomembers";
	}

	/**
	 * 编辑会员
	 */
	public String editusers() throws Exception {
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(getLoginUser().getLoginname());
		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));

		} else {

			customeruser.setLogpassword(null);
		}

		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		return "editusers";
	}

	/**
	 * 删除会员
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteCustomeruser(
				customeruser.getId());
		String delcusp = " DELETE T_CUSTOMERPASSENGER WHERE C_CUSTOMERUSERID="
				+ customeruser.getId();
		Server.getInstance().getSystemService().findMapResultBySql(delcusp,
				null);
		String str = ServletActionContext.getRequest().getParameter("ISWEB");
		if (str != null && str.equals("true")) {
			return this.tob2c();
		}
		return execute();

	}

	public String tomyuser() throws Exception {
		ServletActionContext.getRequest().getSession().setAttribute(
				"isFromedit", true);
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(getLoginUser().getAgentid());
		if (agent.getAgenttype() == 1) {
			return this.toAddUsers();
		} else if (agent.getAgenttype() == 2) {
			return this.toAddUsersgys();
		} else if (agent.getAgenttype() == 3 && agent.getBigtype() == 1) {
			return "biguser";
		} else {
			return this.toAddUsersfxs();
		}
	}

	public String tobiguser() throws Exception {

		String meanuwhere = "";
		if (this.isAdmin() || this.getLoginUser().getType() == 1) {// 管理员或者运营商
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1";
		} else {
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1 AND "
					+ Customeragent.COL_id + "="
					+ this.getLoginUser().getAgentid();
		}
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(3l, arrayagentid, true);
		String where = "";
		if (isAdmin() || this.getLoginUser().getType() == 1) {// 管理员admin

			where = " WHERE 1=1  and " + Customeruser.COL_agentid
					+ " in ( select " + Customeragent.COL_id + " from "
					+ Customeragent.TABLE + " where "
					+ Customeragent.COL_bigtype + " =1) ";
		} else { // 大客户管理员
			where = " WHERE " + Customeruser.COL_agentid + " ="
					+ getLoginUser().getAgentid();
		}
		where += " AND " + Customeruser.COL_id + "<>" + getLoginUserId();
		if (cusagentname != null && !cusagentname.trim().equals("")) {
			if (cusagentname.indexOf("c") >= 0) {
				long agentid = Long.valueOf(cusagentname.substring(1));
				companyname = Server.getInstance().getMemberService()
						.findCustomeragent(agentid).getAgentcompanyname();
				where = " WHERE " + Customeruser.COL_agentid + " =" + agentid;
			} else {
				long deptid = Long.valueOf(cusagentname.substring(0,
						cusagentname.indexOf("@")));
				companyname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
				where = " WHERE " + Customeruser.COL_deptid + "=" + deptid;
			}
		}

		where += " AND " + Customeruser.COL_id + "<>" + getLoginUserId();
		if (fenxiaouser != null && fenxiaouser.trim().length() != 0) {
			where += " and " + Customeruser.COL_loginname + " like '%"
					+ fenxiaouser.trim() + "%'";
		}
		if (fenxiaoname != null && fenxiaoname.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ fenxiaoname.trim() + "%'";
		}
		if (fenxiaotel != null && fenxiaotel.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ fenxiaotel.trim() + "%'";
		}
		getUsersList(where);
		ServletActionContext.getRequest().getSession().setAttribute("agentype",
				4);// 保存加盟商类型，
		remeberURL();// 保存请求路径，以便角色分配后返回

		return "tobiguser";
	}

	public String touser() throws Exception {

		// String meanuwhere = "";

		long[] arrayagentid = new long[1];
		arrayagentid[0] = getLoginUser().getAgentid();
		// this.getDepttreestr(Long.valueOf(getLoginUser().getType()),
		// arrayagentid, true);

		// -------------------------------------------------------------------
		String where = " WHERE 1=1 AND " + Customeruser.COL_membertype
				+ " =2 and " + Customeruser.COL_agentid + "=46";

		if (!isAdmin()) {
			if (getLoginUserRoleNumber().contains(10037l)) {// 如果为大客户管理员
				where = "WHERE 1=1 ";
			}
			where += " AND " + Customeruser.COL_agentid + " ="
					+ getLoginUser().getAgentid();
		}

		if (cusagentname != null && !cusagentname.trim().equals("")) {
			if (cusagentname.indexOf("c") >= 0) {
				long agentid = Long.valueOf(cusagentname.substring(1));
				companyname = Server.getInstance().getMemberService()
						.findCustomeragent(agentid).getAgentcompanyname();
				where = " WHERE " + Customeruser.COL_agentid + " =" + agentid;
			} else {
				long deptid = Long.valueOf(cusagentname.substring(0,
						cusagentname.indexOf("@")));
				companyname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
				where = " WHERE " + Customeruser.COL_deptid + "=" + deptid;
			}
		}
		// where += " AND " + Customeruser.COL_id + " <>" + getLoginUserId();

		if (yunyinguser != null && yunyinguser.trim().length() != 0) {

			where += " and " + Customeruser.COL_loginname + " like '%"
					+ yunyinguser.trim() + "%'";
		}
		if (yunyingname != null && yunyingname.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ yunyingname.trim() + "%'";
		}
		if (yunyingtel != null && yunyingtel.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ yunyingtel.trim() + "%'";
		}
		// System.out.println(where);
		ServletActionContext.getRequest().getSession().setAttribute("agentype",
				0);// 保存加盟商类型，
		getUsersList(where);
		remeberURL();// 保存请求路径，以便角色分配后返回

		return "touser";
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
					Server.getInstance().getMemberService().deleteCustomeruser(
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
	 * 转向至运营商员工列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toOperationUsersList() throws Exception {

		String meanuwhere = "";
		if (this.isAdmin()) {
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=1 ";
		} else {
			meanuwhere = " WHERE 1>2";
		}
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(1l, arrayagentid, true);
		// ----------------
		String where = " where 1=1  and " + Customeruser.COL_agentid
				+ " in ( SELECT " + Customeragent.COL_id + " FROM "
				+ Customeragent.TABLE + " where " + Customeragent.COL_agenttype
				+ " =1)";
		if (cusagentname != null && !cusagentname.trim().equals("")) {
			if (cusagentname.indexOf("c") >= 0) {
				long agentid = Long.valueOf(cusagentname.substring(1));
				companyname = Server.getInstance().getMemberService()
						.findCustomeragent(agentid).getAgentcompanyname();
				where = " WHERE 1=1 AND " + Customeruser.COL_agentid + " ="
						+ agentid;
			} else {
				long deptid = Long.valueOf(cusagentname.substring(0,
						cusagentname.indexOf("@")));
				companyname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
				where = " WHERE 1=1 AND " + Customeruser.COL_deptid + "="
						+ deptid;
			}
		}
		where += " AND  " + Customeruser.COL_type + " =1 AND "
				+ Customeruser.COL_membertype + " =2";
		if (isAdmin()) {
			where += " AND " + Customeruser.COL_id + "!=" + getLoginUserId();
		}

		if (yunyinguser != null && yunyinguser.trim().length() != 0) {

			where += " and " + Customeruser.COL_loginname + " like '%"
					+ yunyinguser.trim() + "%'";
		}
		if (yunyingname != null && yunyingname.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ yunyingname.trim() + "%'";
		}
		if (yunyingtel != null && yunyingtel.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ yunyingtel.trim() + "%'";
		}

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Customeruser.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		// where += " and " + Customeruser.COL_type + " = 1";
		getUsersList(where);
		ServletActionContext.getRequest().getSession().setAttribute("agentype",
				1);// 保存加盟商类型，
		remeberURL();// 保存请求路径，以便角色分配后返回

		return "operationUsersList";
	}

	/**
	 * 转向至供应商员工列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toSupplyUsersList() throws Exception {

		String where = " where 1=1  and " + Customeruser.COL_type + " =2 and "
				+ Customeruser.COL_membertype + " =2 and "
				+ Customeruser.COL_agentid + "<>46 and " + Customeruser.COL_id
				+ " !=62 and " + Customeruser.COL_agentid + " in ( SELECT "
				+ Customeragent.COL_id + " FROM " + Customeragent.TABLE
				+ " where " + Customeragent.COL_agenttype + " =2)";

		if (gongyinguser != null && gongyinguser.trim().length() != 0) {

			where += " and " + Customeruser.COL_loginname + " like '%"
					+ gongyinguser.trim() + "%'";
		}
		if (gongyingname != null && gongyingname.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ gongyingname.trim() + "%'";
		}
		if (gongyingtel != null && gongyingtel.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ gongyingtel.trim() + "%'";
		}
		if (compnayid != null && compnayid.trim().length() > 0) {
			where += " and " + Customeruser.COL_agentid + "=" + compnayid;
		}

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Customeruser.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		// where += " and " + Customeruser.COL_type + " = 2";
		getUsersList(where);
		ServletActionContext.getRequest().getSession().setAttribute("agentype",
				2);// 保存加盟商类型，
		remeberURL();// 保存请求路径，以便角色分配后返回

		/*
		 * if (gongyinguser!=null && gongyinguser.trim().length()!=0) {
		 * 
		 * where += " and " + Customeruser.COL_loginname +" like '%" +
		 * gongyinguser.trim()+"%'"; } if (gongyingname!=null &&
		 * gongyingname.trim().length()!=0) {
		 * 
		 * where += " and " + Customeruser.COL_membername +" like '%" +
		 * gongyingname.trim()+"%'"; } if (gongyingtel!=null &&
		 * gongyingtel.trim().length()!=0) {
		 * 
		 * where += " and " + Customeruser.COL_mobile +" like '%" +
		 * gongyingtel.trim()+"%'"; } // if (s_name!=null &&
		 * s_name.trim().length()!=0) { // where += " and " +
		 * Customeruser.COL_name +" like '%" + // s_name.trim()+"%'"; // } where += "
		 * and " + Customeruser.COL_type + " = 2"; getUsersList(where);
		 */
		return "supplyUsersList";
	}

	public String toEmployeelist() {
		System.out.println(roid);
		String where = " WHERE 1=1 AND C_MEMBERTYPE IN(-1,2) AND ID!="+this.getLoginUserId();
		
		if (customeruser.getAgentid() == null || customeruser.getAgentid() == 0) {
			customeruser.setAgentid(this.getLoginUser().getAgentid());
		}
		if (this.customeruser.getAgentid() > 0) {
			where += " AND " + Customeruser.COL_agentid + "="
					+ customeruser.getAgentid();
		}

		if (fenxiaouser != null && fenxiaouser.trim().length() != 0) {

			where += " and " + Customeruser.COL_loginname + " like '%"
					+ fenxiaouser.trim() + "%'";
		}
		if (fenxiaoname != null && fenxiaoname.trim().length() != 0) {

			where += " and " + Customeruser.COL_membername + " like '%"
					+ fenxiaoname.trim() + "%'";
		}
		if (fenxiaotel != null && fenxiaotel.trim().length() != 0) {

			where += " and " + Customeruser.COL_mobile + " like '%"
					+ fenxiaotel.trim() + "%'";
		}
		this.getUsersList(where);
		System.out.println("member/customer_distrUsersList.jsp");
		
		if(roid==9999999){
			String message = "您好，您的员工数已经用完！如需添加,请联系管理员!";
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("message", message);
		}
		
		customeragent =Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());
		
		System.out.println(customeragent);
		
		String maxnum = "不限制";
		String datenum = "不限制";
		if(customeragent.getIndustry()!=null){
			maxnum=customeragent.getIndustry();
		}
		if(!maxnum.equals("不限制")){
			List<Customeruser>list=Server.getInstance().getMemberService().findAllCustomeruser("where 1=1 and "+Customeruser.COL_agentid+" ="+customeragent.getId(), "", -1, 0);
			if(customeragent.getIndustry()!=null&&customeragent.getIndustry().length()>0){
				
					datenum=Integer.parseInt(customeragent.getIndustry())-list.size()+"";
					
				
				
			}
			
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("maxnum", maxnum);
		request.setAttribute("datenum", datenum);
		return "distrUsersList";
	}

	/**
	 * 修改用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toeditEmployee() throws Exception {
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		this.customeragent = super.findBySql(Customeragent.class,
				"SELECT ID AS id," + "C_AGENTCOMPANYNAME AS agentcompanyname "
						+ "FROM T_CUSTOMERAGENT WHERE ID="
						+ customeruser.getAgentid());
		
		getString(-1);
		return "addemployee";
	}

	// &pretBool=true
	/**
	 * 修改员工
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editemployee() throws Exception {
		Customeruser loginUser = this.getLoginUser();
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		System.out.println(customeruser.getMobile());
		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().trim().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		} else {
			customeruser.setLogpassword(null);
		}

		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		return this.toEmployeelist();
	}

	/**
	 * 添加员工
	 * 
	 * @return
	 */
	public String toAddEmployee() {
		if(customeruser.getAgentid()==null||customeruser.getAgentid()==0){
			customeruser.setAgentid(this.getLoginsessionagent().getId());
			this.customeragent=this.getLoginsessionagent();
		}else{
		this.customeragent = super
				.findBySql(
						Customeragent.class,
						"SELECT ID AS id,"
								+ "C_AGENTCOMPANYNAME AS agentcompanyname,C_INDUSTRY as industry,C_AGENTTYPE as agenttype,C_AGENTJIBIE AS agentjibie "
								+ "FROM T_CUSTOMERAGENT WHERE ID="
								+ this.customeruser.getAgentid());
		}
		System.out.println("member/addemployee.jsp");
		
		List<Customeruser>list=Server.getInstance().getMemberService().findAllCustomeruser("where 1=1 and "+Customeruser.COL_agentid+" ="+customeragent.getId(), "", -1, 0);
		
		if(customeragent.getIndustry()!=null&&customeragent.getIndustry().length()>0){
			if(list.size()>=Integer.parseInt(customeragent.getIndustry())){
				roid=9999999;
				return this.toEmployeelist();
			}else{
				roid=0;
			}
			
		}
		getString(-1);
		
		
		return "addemployee";
	}

	public String toAddUsersfxs() throws Exception {
		// 获取前一页面路径
		forward = ServletActionContext.getRequest().getHeader("Referer");

		String meanuwhere = "";
		if (this.isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工)
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3  AND "
					+ Customeragent.COL_bigtype + "!=1";
		} else {
			meanuwhere = " WHERE " + Customeragent.COL_id + "="
					+ this.getLoginUser().getAgentid() + " AND "
					+ Customeragent.COL_agenttype + "=3  AND "
					+ Customeragent.COL_bigtype + "!=1";
		}
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(3l, arrayagentid, true);

		return "addUsersfxs";
	}

	/**
	 * 获取相应加盟商员工列表
	 * 
	 * @param where
	 */
	private void getUsersList(String where) {

		List list = Server.getInstance().getMemberService()
				.findAllCustomeruserForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeruser = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeruser.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeruserForPageinfo(where, " ORDER BY ID DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeruser = list;
		}
	}

	public String toeditbiuser() throws Exception {

		String meanuwhere = "";
		if (this.isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1";
		} else {
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1 AND "
					+ Customeragent.COL_id + "="
					+ this.getLoginUser().getAgentid();
		}
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(3l, arrayagentid, true);

		/*
		 * listCustomeragent = Server.getInstance().getMemberService()
		 * .findAllCustomeragent( "where 1=1 and " + Customeragent.COL_bigtype + "
		 * =1 and " + Customeragent.COL_id + " <>46 and " +
		 * Customeragent.COL_agentcheckstatus + " =1", "", -1, 0);
		 */
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		if (customeruser.getAgentid() != null) {
			Customeragent agent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
			if (agent != null) {
				this.companyname = agent.getAgentcompanyname();
			}
		}
		if (customeruser.getDeptid() != null) {
			Department dept = Server.getInstance().getMemberService()
					.findDepartment(customeruser.getDeptid());
			if (dept != null) {
				this.companyname = dept.getName();
			}
		}

		this.customeragentid = converNull(customeruser.getAgentid(), 0l);
		this.customerdeptid = converNull(customeruser.getDeptid(), 0l);

		custCreditMap(customeruser.getId());
		ServletActionContext.getRequest().setAttribute("edit", "true");
		return "toeditbiuser";
	}

	/**
	 * 启用或者禁用员工账号
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doCheckUsers() throws Exception {
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());

		if (customeruser.getIsenable() == null
				|| customeruser.getIsenable() == 0) {
			customeruser.setIsenable(1);
		} else {
			customeruser.setIsenable(0);
		}
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		// 获取前一页面路径
		// forward = ServletActionContext.getRequest().getHeader("Referer");
		// customeruser!toEmployeelist.action?agentid=46327
		forward = "customeruser!toEmployeelist.action?agentid="
				+ customeruser.getAgentid();
		return "userList";
	}

	public String toAddUsers() throws Exception {
		listdepartment = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where 1=1 and " + Department.COL_agentid + " ="
								+ getLoginUser().getAgentid(), "", -1, 0);

		// 获取前一页面路径
		forward = ServletActionContext.getRequest().getHeader("Referer");
		// this.getDepttreestr(1l, null, true);
		return "addUsersyys";
	}

	public String toedityyuser() throws Exception {
		long id = Long.valueOf(ServletActionContext.getRequest().getParameter(
				"id"));
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		custCreditMap(customeruser.getId());
		ServletActionContext.getRequest().setAttribute("edit", "true");
		return toAddUsers();
	}

	/**
	 * @return
	 * @throws Exception
	 *             修改运营商
	 */
	public String edityy() throws Exception {
		Customeruser loginUser = this.getLoginUser();
		if (getAgendept() != null && getAgendept().trim().length() > 0) {
			if (this.getAgendept().indexOf("c") >= 0) {
				long deptid = Long.valueOf(0);
				customeruser.setDeptid(deptid);
				long cid = Long.valueOf(this.getAgendept().substring(1));
				customeruser.setAgentid(cid);
			} else if (this.getAgendept().indexOf("@") >= 0) {
				int index = this.getAgendept().indexOf("@");
				long deptid = Long.valueOf(getAgendept().substring(0, index));
				customeruser.setDeptid(deptid);
				long cid = Long
						.valueOf(this.getAgendept().substring(index + 1));
				customeruser.setAgentid(cid);
			}
		}
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().trim().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		} else {
			customeruser.setLogpassword(null);
		}
		customeruser.setMembertype(2);
		// 加盟商类型
		customeruser.setType(1);
		// 加盟商ID
		customeruser.setAgentid(loginUser.getAgentid());
		customeruser.setBirthday(dateToTimestamp(c_birthday));
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);
		this.updateCard();
		if (ServletActionContext.getRequest().getSession().getAttribute(
				"isFromedit") != null) {
			ServletActionContext.getRequest().getSession().removeAttribute(
					"isFromedit");
			return touser();
		}
		return toOperationUsersList();
	}

	public String toAddUsersgys() throws Exception {

		// 获供应商取部门树
		if (isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工)
			// this.getDepttreestr(2l, null, false);
		} else {
			long id = this.getLoginUser().getAgentid();
			long[] arrrayid = { id };
			// this.getDepttreestr(2l, arrrayid, false);
		}

		// 获取前一页面路径
		forward = ServletActionContext.getRequest().getHeader("Referer");

		return "addUsersgys";
	}

	public String addyunys() throws Exception {// 添加运营商员工
		Customeruser loginUser = this.getLoginUser();
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(loginUser.getLoginname());
		customeruser.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		if (getAgendept() != null && getAgendept().trim().length() > 0) {
			if (this.getAgendept().indexOf("c") >= 0) {
				long deptid = Long.valueOf(0);
				customeruser.setDeptid(deptid);
				long cid = Long.valueOf(this.getAgendept().substring(1));
				customeruser.setAgentid(cid);
			} else if (this.getAgendept().indexOf("@") >= 0) {
				int index = this.getAgendept().indexOf("@");
				long deptid = Long.valueOf(getAgendept().substring(0, index));
				customeruser.setDeptid(deptid);
				long cid = Long
						.valueOf(this.getAgendept().substring(index + 1));
				customeruser.setAgentid(cid);
			}
		}

		// 默认可用
		customeruser.setMembertype(2);
		// 加盟商类型
		customeruser.setType(1);
		// 加盟商ID
		customeruser.setAgentid(loginUser.getAgentid());
		customeruser.setBirthday(dateToTimestamp(c_birthday));
		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);
		Customercredit customercredit = new Customercredit();

		customercredit.setCredittypeid(this.cardType);
		customercredit.setCreditnumber(s_cardnunber);
		customercredit.setCreateuser(loginUser.getLoginname());
		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifyuser(loginUser.getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
		customercredit.setType(0);
		customercredit.setRefid(customeruser.getId());

		Server.getInstance().getMemberService().createCustomercredit(
				customercredit);
		if (ServletActionContext.getRequest().getSession().getAttribute(
				"isFromedit") != null) {
			ServletActionContext.getRequest().getSession().removeAttribute(
					"isFromedit");
			return touser();
		}

		return toOperationUsersList();

	}

	public String addgongys() throws Exception {// 添加供应商员工

		Customeruser loginUser = this.getLoginUser();
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(loginUser.getLoginname());
		// 默认可用
		customeruser.setIsenable(1);
		customeruser.setState(1);
		// 加盟商类型
		customeruser.setType(2);
		customeruser.setMembertype(2);// 1会员.2员工

		// 会员类型 1 前台 2 后台 3同行
		customeruser.setMembertype(2);

		customeruser.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		customeruser.setLoginname(customeruser.getLoginname());

		// 加盟商ID
		customeruser.setBirthday(dateToTimestamp(c_birthday));

		// 添加供应商员工所属供应商
		if (compnayid != null && !compnayid.equals("")) {
			customeruser.setAgentid(Long.parseLong(compnayid));
		}

		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);

		// 添加员工权限，如果是管理员直接分配管理员权限，如果是普通员工，直接分配普通员工权限
		Agentroleref agentroleref = new Agentroleref();
		agentroleref.setCustomeruserid(customeruser.getId());
		long employeeroid = 0l;
		if (customeruser.getIsadmin() == 1) {
			// 供应商管理员角色
			agentroleref.setRoleid(pretyAdmin);
		} else {
			// 供应商普通员工角色
			agentroleref.setRoleid(pretyElmp);
		}
		Server.getInstance().getMemberService()
				.createAgentroleref(agentroleref);

		if (ServletActionContext.getRequest().getSession().getAttribute(
				"isFromedit") != null) {
			ServletActionContext.getRequest().getSession().removeAttribute(
					"isFromedit");
			return touser();
		}
		return this.toSupplyUsersList();

	}

	public String toeditgongys() throws Exception {
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		Customeruser loginUser = this.getLoginUser();
		// 加载部门信息
		// listdepartment=Server.getInstance().getOAService().findAllDepartment("where
		// 1=1 and "+Department.COL_agentid+"="+loginUser.getAgentid(), "", -1,
		// 0);
		// listdepartment=Server.getInstance().getOAService().findAllDepartment("where
		// 1=1 ", "", -1, 0);
		listCustomeragent = Server.getInstance().getMemberService()
				.findAllCustomeragent(
						"where 1=1 and " + Customeragent.COL_agenttype
								+ " =2 and "
								+ Customeragent.COL_agentcheckstatus + "=1 ",
						"", -1, 0);

		// this.getDepttreestr(2l, null, false);// fals:不显示部门
		return "addUsersgys";
	}

	/**
	 * @author twocold
	 * @return
	 * @throws Exception
	 *             根据类型跳转到不同的编辑方法；
	 */
	public String toedituser() throws Exception {

		ServletActionContext.getRequest().getSession().setAttribute(
				"isFromedit", true);
		customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(customeruser.getId());
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());
		if (agent.getAgenttype() == 1) {
			return this.toeditgongys();
		} else if (agent.getAgenttype() == 2) {
			return this.toeditgongys();
		} else if (agent.getAgenttype() == 3 && agent.getBigtype() == 1) {
			return this.toeditbiuser();
		} else {
			return "";
			// return this.toeditfxuser();
		}

	}

	public String editgongys() throws Exception {
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(getLoginUser().getLoginname());
		if (customeruser.getLogpassword() != null
				&& customeruser.getLogpassword().length() > 0) {
			customeruser
					.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		} else {

			customeruser.setLogpassword(null);
		}
		if (getAgendept() != null && getAgendept().trim().length() > 0) {
			if (this.getAgendept().indexOf("c") >= 0) {
				long deptid = Long.valueOf(0);
				customeruser.setDeptid(deptid);
				long cid = Long.valueOf(this.getAgendept().substring(1));
				customeruser.setAgentid(cid);
			} else if (this.getAgendept().indexOf("@") >= 0) {
				int index = this.getAgendept().indexOf("@");
				long deptid = Long.valueOf(getAgendept().substring(0, index));
				customeruser.setDeptid(deptid);
				long cid = Long
						.valueOf(this.getAgendept().substring(index + 1));
				customeruser.setAgentid(cid);
			}
		}
		customeruser.setLoginname(customeruser.getLoginname());
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(
				customeruser);

		if (isAdmin()) {

			String where = " where 1=1 ";

			if (gongyinguser != null && gongyinguser.trim().length() != 0) {

				where += " and " + Customeruser.COL_loginname + " like '%"
						+ gongyinguser.trim() + "%'";
			}
			if (gongyingname != null && gongyingname.trim().length() != 0) {

				where += " and " + Customeruser.COL_membername + " like '%"
						+ gongyingname.trim() + "%'";
			}
			if (gongyingtel != null && gongyingtel.trim().length() != 0) {

				where += " and " + Customeruser.COL_mobile + " like '%"
						+ gongyingtel.trim() + "%'";
			}

			getUsersList(where);

		} else {

			String where = " where 1=1 and " + Customeruser.COL_agentid + " = "
					+ getLoginUser().getAgentid() + " and "
					+ Customeruser.COL_membertype + " =2";

			if (gongyinguser != null && gongyinguser.trim().length() != 0) {

				where += " and " + Customeruser.COL_loginname + " like '%"
						+ gongyinguser.trim() + "%'";
			}
			if (gongyingname != null && gongyingname.trim().length() != 0) {

				where += " and " + Customeruser.COL_membername + " like '%"
						+ gongyingname.trim() + "%'";
			}
			if (gongyingtel != null && gongyingtel.trim().length() != 0) {

				where += " and " + Customeruser.COL_mobile + " like '%"
						+ gongyingtel.trim() + "%'";
			}

			getUsersList(where);

		}
		if (ServletActionContext.getRequest().getSession().getAttribute(
				"isFromedit") != null) {
			ServletActionContext.getRequest().getSession().removeAttribute(
					"isFromedit");
			return touser();
		}
		return "chongzhi";
	}

	public String addbiguser() throws Exception {// 添加分销商员工

		if (cusagentname != null && !cusagentname.trim().equals("")) {

			if (cusagentname.indexOf("c") >= 0) {
				customeragentid = Long.valueOf(cusagentname.substring(1));

			} else {
				customerdeptid = Long.valueOf(cusagentname.substring(0,
						cusagentname.indexOf("@")));
				customeragentid = Long.valueOf(cusagentname
						.substring(cusagentname.indexOf("@") + 1));
			}
		}
		customeruser.setAgentid(customeragentid);
		customeruser.setDeptid(customerdeptid);

		Customeragent ang = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());

		Customeruser loginUser = this.getLoginUser();

		Timestamp time = null;
		try {
			time = dateToTimestamp(ServletActionContext.getRequest()
					.getParameter("birthday"));
		} catch (Exception e) {
		}
		customeruser.setBirthday(time);
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(loginUser.getLoginname());
		customeruser.setLoginname(customeruser.getLoginname());
		customeruser.setLogpassword(Util.MD5(customeruser.getLogpassword()));
//		String nation = customeruser.getNationality();
//		if (nation.trim().equals("") || nation.trim().equals("中文/拼音")) {
//			customeruser.setNationality("中国");// 设置默认国籍
//		}
		// 默认可用

		customeruser.setIsenable(1);
		customeruser.setState(1);
		// 加盟商类型
		customeruser.setType(3);
		if (ang.getBigtype() == 1 && customeruser.getIsadmin() == 1) {// Bigtype==1
			// 大客户
			// 0不是大客户
			customeruser.setMembertype(2);// 1会员.2员工
		} else if (ang.getBigtype() == 1 && customeruser.getIsadmin() == 2) {
			customeruser.setMembertype(1);// 1会员
		} else {
			customeruser.setMembertype(2);// 2.员工
		}

		customeruser.setIsadmin(customeruser.getIsadmin());

		// 加盟商ID

		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);
		HttpServletRequest request = ServletActionContext.getRequest();

		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
		customercredit.setCreateuser(this.getLoginUser().getLoginname());
		customercredit.setModifyuser(this.getLoginUser().getLoginname());
		customercredit.setNationality(request.getParameter("nationality"));
		customercredit.setRefid(customeruser.getId());
		customercredit.setCreditnumber(request.getParameter("s_cardnunber"));
		customercredit.setCredittypeid(Integer.valueOf(request
				.getParameter("cardType")));

		Server.getInstance().getMemberService().createCustomercredit(
				customercredit);

		if (isAdmin()) {

			String where = " where 1=1 ";

			List list = Server.getInstance().getMemberService()
					.findAllSystemroleForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listSystemrole = list;
			if (pageinfo.getTotalrow() > 0 && listSystemrole.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getMemberService()
						.findAllSystemroleForPageinfo(where, " ORDER BY ID ",
								pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listSystemrole = list;
			}

		} else {
			String where = " where 1=1 and " + Systemrole.COL_id + " !=1";

			List list = Server.getInstance().getMemberService()
					.findAllSystemroleForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listSystemrole = list;
			if (pageinfo.getTotalrow() > 0 && listSystemrole.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getMemberService()
						.findAllSystemroleForPageinfo(where, " ORDER BY ID ",
								pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listSystemrole = list;
			}

		}

		if (ServletActionContext.getRequest().getSession().getAttribute(
				"isFromedit") != null) {
			ServletActionContext.getRequest().getSession().removeAttribute(
					"isFromedit");
			return touser();
		}
		return this.tobiguser();

	}

	public String addemployee() throws Exception {// 添加员工

		Customeruser loginUser = this.getLoginUser();
		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(loginUser.getLoginname());
		customeruser.setLoginname(customeruser.getLoginname());
		customeruser.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		// 加盟商类型
		customeruser.setType(customeragent.getAgenttype());
		customeruser.setMembertype(2);// 2.员工
		customeruser.setIsadmin(2);
		// 加盟商ID
		customeruser.setBirthday(dateToTimestamp(c_birthday));
		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);

		// 添加员工权限，如果是管理员直接分配管理员权限，如果是普通员工，直接分配普通员工权限
		Agentroleref agentroleref = new Agentroleref();
		agentroleref.setCustomeruserid(customeruser.getId());
		if (this.customeragent.getAgenttype() == 3) {// 分销
			if (customeragent.getAgentjibie() == 4) {
				agentroleref.setRoleid(10044l);// 预订组
			} else {
				agentroleref.setRoleid(10063l);
			}
		} else if (customeragent.getAgenttype() == 2) {
			if (customeragent.getAgentjibie() == 4) {
				agentroleref.setRoleid(10039l);// 出票组
			} else {
				agentroleref.setRoleid(10062l);// 供应商员工
			}
		}
		Server.getInstance().getMemberService()
				.createAgentroleref(agentroleref);

		return this.toEmployeelist();

	}

	/**
	 * 添加员工
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUsers() throws Exception {
		Customeruser loginUser = this.getLoginUser();

		customeruser.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeruser.setModifyuser(loginUser.getLoginname());
		customeruser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customeruser.setCreateuser(loginUser.getLoginname());
		customeruser.setLoginname(customeruser.getLoginname());
		customeruser.setLogpassword(Util.MD5(customeruser.getLogpassword()));
		// 默认可用
		customeruser.setIsenable(1);
		customeruser.setState(1);
		// 加盟商类型
		customeruser.setType(loginUser.getType());
		// 加盟商ID
		customeruser.setAgentid(loginUser.getAgentid());
		customeruser.setBirthday(dateToTimestamp(c_birthday));
		customeruser = Server.getInstance().getMemberService()
				.createCustomeruser(customeruser);
		Customercredit customercredit = new Customercredit();

		customercredit.setCreditnumber(creditnumber);
		customercredit.setCredittypeid(credittype);
		customercredit.setCreateuser(loginUser.getLoginname());
		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifyuser(loginUser.getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
		customercredit.setType(0);
		customercredit.setRefid(customeruser.getId());

		Server.getInstance().getMemberService().createCustomercredit(
				customercredit);

		return "userList";
	}

	/**
	 * 获取当前登录用户所属角色名称字符串
	 * 
	 * @return
	 */
	public String getRoleStr(long userId) {
		StringBuffer sb = new StringBuffer();
		String where = " where 1=1 ";
		where += " and " + Agentroleref.COL_customeruserid + "=" + userId;

		List<Agentroleref> list = Server.getInstance().getMemberService()
				.findAllAgentroleref(where, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				long roleId = list.get(i).getRoleid();
				Systemrole role = Server.getInstance().getMemberService()
						.findSystemrole(roleId);
				if (i == list.size() - 1) {
					sb.append(role.getName());
				} else {
					sb.append(role.getName() + ",");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 跳转至证件列表页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toCustomercreditList() throws Exception {
		forward = "customercredit.action?refid=" + customeruser.getId();
		return "customercredit";
	}

	/**
	 * 跳转至里程卡列表页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toCustomeraircardList() throws Exception {
		forward = "customeraircard.action?refid=" + customeruser.getId();
		return "customeraircard";

	}

	/**
	 * 跳转至联系电话列表页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toTelephoneList() throws Exception {
		forward = "telephone.action?customeruserid=" + customeruser.getId();
		return "telephone";
	}

	/**
	 * 返回会员对象
	 */

	public List<Customeruser> getListCustomeruser() {
		return listCustomeruser;
	}

	public void setListCustomeruser(List<Customeruser> listCustomeruser) {
		this.listCustomeruser = listCustomeruser;
	}

	public Customeruser getCustomeruser() {
		return customeruser;
	}

	public void setCustomeruser(Customeruser customeruser) {
		this.customeruser = customeruser;
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

	public List<Systemrole> getListSystemrole() {
		return listSystemrole;
	}

	public void setListSystemrole(List<Systemrole> listSystemrole) {
		this.listSystemrole = listSystemrole;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getRoid() {
		return roid;
	}

	public void setRoid(long roid) {
		this.roid = roid;
	}

	public long getMemid() {
		return memid;
	}

	public void setMemid(long memid) {
		this.memid = memid;
	}

	public List<Customeruser> getListb2cCustomeruser() {
		return listb2cCustomeruser;
	}

	public void setListb2cCustomeruser(List<Customeruser> listb2cCustomeruser) {
		this.listb2cCustomeruser = listb2cCustomeruser;
	}

	public int getCredittype() {
		return credittype;
	}

	public void setCredittype(int credittype) {
		this.credittype = credittype;
	}

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public int getOperationType() {
		return operationType;
	}

	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}

	public String getC_birthday() {
		return c_birthday;
	}

	public void setC_birthday(String c_birthday) {
		this.c_birthday = c_birthday;
	}

	public List<Sysroleright> getListSysroleright() {
		return listSysroleright;
	}

	public void setListSysroleright(List<Sysroleright> listSysroleright) {
		this.listSysroleright = listSysroleright;
	}

	public List<Agentroleref> getListAgentroleref() {
		return listAgentroleref;
	}

	public void setListAgentroleref(List<Agentroleref> listAgentroleref) {
		this.listAgentroleref = listAgentroleref;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public ArrayList getRlist() {
		return rlist;
	}

	public void setRlist(ArrayList rlist) {
		this.rlist = rlist;
	}

	public Map getList() {
		return list;
	}

	public void setList(Map list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Map getMap1() {
		return map1;
	}

	public void setMap1(Map map1) {
		this.map1 = map1;
	}

	public ArrayList getRlist1() {
		return rlist1;
	}

	public void setRlist1(ArrayList rlist1) {
		this.rlist1 = rlist1;
	}

	public ArrayList getRlist2() {
		return rlist2;
	}

	public void setRlist2(ArrayList rlist2) {
		this.rlist2 = rlist2;
	}

	public ArrayList getRlist3() {
		return rlist3;
	}

	public void setRlist3(ArrayList rlist3) {
		this.rlist3 = rlist3;
	}

	public long getRightid() {
		return rightid;
	}

	public void setRightid(long rightid) {
		this.rightid = rightid;
	}

	public ArrayList getRlist4() {
		return rlist4;
	}

	public void setRlist4(ArrayList rlist4) {
		this.rlist4 = rlist4;
	}

	public String getForward2() {
		return forward2;
	}

	public void setForward2(String forward2) {
		this.forward2 = forward2;
	}

	public HashSet getHs1() {
		return hs1;
	}

	public void setHs1(HashSet hs1) {
		this.hs1 = hs1;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getCaid1() {
		return caid1;
	}

	public void setCaid1(int caid1) {
		this.caid1 = caid1;
	}

	public List<Telephone> getListTelephone() {
		return listTelephone;
	}

	public void setListTelephone(List<Telephone> listTelephone) {
		this.listTelephone = listTelephone;
	}

	public String getFenxiaotel() {
		return fenxiaotel;
	}

	public void setFenxiaotel(String fenxiaotel) {
		this.fenxiaotel = fenxiaotel;
	}

	public String getFenxiaouser() {
		return fenxiaouser;
	}

	public void setFenxiaouser(String fenxiaouser) {
		this.fenxiaouser = fenxiaouser;
	}

	public String getFenxiaoname() {
		return fenxiaoname;
	}

	public void setFenxiaoname(String fenxiaoname) {
		this.fenxiaoname = fenxiaoname;
	}

	public String getGongyingtel() {
		return gongyingtel;
	}

	public void setGongyingtel(String gongyingtel) {
		this.gongyingtel = gongyingtel;
	}

	public String getGongyinguser() {
		return gongyinguser;
	}

	public void setGongyinguser(String gongyinguser) {
		this.gongyinguser = gongyinguser;
	}

	public String getGongyingname() {
		return gongyingname;
	}

	public void setGongyingname(String gongyingname) {
		this.gongyingname = gongyingname;
	}

	public String getYunyingtel() {
		return yunyingtel;
	}

	public void setYunyingtel(String yunyingtel) {
		this.yunyingtel = yunyingtel;
	}

	public String getYunyinguser() {
		return yunyinguser;
	}

	public void setYunyinguser(String yunyinguser) {
		this.yunyinguser = yunyinguser;
	}

	public String getYunyingname() {
		return yunyingname;
	}

	public void setYunyingname(String yunyingname) {
		this.yunyingname = yunyingname;
	}

	public List<Customeraircard> getListCustomeraircard() {
		return listCustomeraircard;
	}

	public void setListCustomeraircard(List<Customeraircard> listCustomeraircard) {
		this.listCustomeraircard = listCustomeraircard;
	}

	public Customercredit getCustomercredit() {
		return customercredit;
	}

	public void setCustomercredit(Customercredit customercredit) {
		this.customercredit = customercredit;
	}

	public File[] getCharter() {
		return charter;
	}

	public void setCharter(File[] charter) {
		this.charter = charter;
	}

	public static String[] getFileStrs() {
		return fileStrs;
	}

	public static void setFileStrs(String[] fileStrs) {
		CustomeruserAction.fileStrs = fileStrs;
	}

	public File[] getLogo() {
		return logo;
	}

	public void setLogo(File[] logo) {
		this.logo = logo;
	}

	public File[] getIndex01() {
		return index01;
	}

	public void setIndex01(File[] index01) {
		this.index01 = index01;
	}

	public File[] getIndex02() {
		return index02;
	}

	public void setIndex02(File[] index02) {
		this.index02 = index02;
	}

	public File[] getIndex03() {
		return index03;
	}

	public void setIndex03(File[] index03) {
		this.index03 = index03;
	}

	public File[] getIndexad01() {
		return indexad01;
	}

	public void setIndexad01(File[] indexad01) {
		this.indexad01 = indexad01;
	}

	public File[] getIndexad02() {
		return indexad02;
	}

	public void setIndexad02(File[] indexad02) {
		this.indexad02 = indexad02;
	}

	public File[] getIndexad03() {
		return indexad03;
	}

	public void setIndexad03(File[] indexad03) {
		this.indexad03 = indexad03;
	}

	public File[] getHotel() {
		return hotel;
	}

	public void setHotel(File[] hotel) {
		this.hotel = hotel;
	}

	public File[] getAir01() {
		return air01;
	}

	public void setAir01(File[] air01) {
		this.air01 = air01;
	}

	public File[] getAir02() {
		return air02;
	}

	public void setAir02(File[] air02) {
		this.air02 = air02;
	}

	public File[] getAir03() {
		return air03;
	}

	public void setAir03(File[] air03) {
		this.air03 = air03;
	}

	public File[] getInair01() {
		return inair01;
	}

	public void setInair01(File[] inair01) {
		this.inair01 = inair01;
	}

	public File[] getInair02() {
		return inair02;
	}

	public void setInair02(File[] inair02) {
		this.inair02 = inair02;
	}

	public File[] getInair03() {
		return inair03;
	}

	public void setInair03(File[] inair03) {
		this.inair03 = inair03;
	}

	public File[] getTravel() {
		return travel;
	}

	public void setTravel(File[] travel) {
		this.travel = travel;
	}

	public String getLogopath() {
		return logopath;
	}

	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}

	public String getIndex01path() {
		return index01path;
	}

	public void setIndex01path(String index01path) {
		this.index01path = index01path;
	}

	public String getIndex02path() {
		return index02path;
	}

	public void setIndex02path(String index02path) {
		this.index02path = index02path;
	}

	public String getIndex03path() {
		return index03path;
	}

	public void setIndex03path(String index03path) {
		this.index03path = index03path;
	}

	public String getIndexad01path() {
		return indexad01path;
	}

	public void setIndexad01path(String indexad01path) {
		this.indexad01path = indexad01path;
	}

	public String getIndexad02path() {
		return indexad02path;
	}

	public void setIndexad02path(String indexad02path) {
		this.indexad02path = indexad02path;
	}

	public String getIndexad03path() {
		return indexad03path;
	}

	public void setIndexad03path(String indexad03path) {
		this.indexad03path = indexad03path;
	}

	public String getHotelpath() {
		return hotelpath;
	}

	public void setHotelpath(String hotelpath) {
		this.hotelpath = hotelpath;
	}

	public String getAir01path() {
		return air01path;
	}

	public void setAir01path(String air01path) {
		this.air01path = air01path;
	}

	public String getAir02path() {
		return air02path;
	}

	public void setAir02path(String air02path) {
		this.air02path = air02path;
	}

	public String getAir03path() {
		return air03path;
	}

	public void setAir03path(String air03path) {
		this.air03path = air03path;
	}

	public String getInair01path() {
		return inair01path;
	}

	public void setInair01path(String inair01path) {
		this.inair01path = inair01path;
	}

	public String getInair02path() {
		return inair02path;
	}

	public void setInair02path(String inair02path) {
		this.inair02path = inair02path;
	}

	public String getInair03path() {
		return inair03path;
	}

	public void setInair03path(String inair03path) {
		this.inair03path = inair03path;
	}

	public String getTravelpath() {
		return travelpath;
	}

	public void setTravelpath(String travelpath) {
		this.travelpath = travelpath;
	}

	public File[] getIndex04() {
		return index04;
	}

	public void setIndex04(File[] index04) {
		this.index04 = index04;
	}

	public String getIndex04path() {
		return index04path;
	}

	public void setIndex04path(String index04path) {
		this.index04path = index04path;
	}

	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}

	public List<Department> getListdepartment() {
		return listdepartment;
	}

	public void setListdepartment(List<Department> listdepartment) {
		this.listdepartment = listdepartment;
	}

	public String getS_shenfz() {
		return s_shenfz;
	}

	public void setS_shenfz(String s_shenfz) {
		this.s_shenfz = s_shenfz;
	}

	public File[] getIndex05() {
		return index05;
	}

	public void setIndex05(File[] index05) {
		this.index05 = index05;
	}

	public String getIndex05path() {
		return index05path;
	}

	public void setIndex05path(String index05path) {
		this.index05path = index05path;
	}

	public String getStrCusID() {
		return strCusID;
	}

	public void setStrCusID(String strCusID) {
		this.strCusID = strCusID;
	}

	public String getStrCustName() {
		return strCustName;
	}

	public void setStrCustName(String strCustName) {
		this.strCustName = strCustName;
	}

	public String getStrMobile() {
		return strMobile;
	}

	public void setStrMobile(String strMobile) {
		this.strMobile = strMobile;
	}

	public String getStrIsWeb() {
		return strIsWeb;
	}

	public void setStrIsWeb(String strIsWeb) {
		this.strIsWeb = strIsWeb;
	}

	public long getAngid() {
		return angid;
	}

	public void setAngid(long angid) {
		this.angid = angid;
	}

	private void remeberURL() {
		HttpServletRequest request = ServletActionContext.getRequest();
		StringBuffer url = request.getRequestURL();
		request.getSession().setAttribute("befRoleURL", url);

	}

	private void getString(long id) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ getLoginUser().getAgentid(), "ORDER BY ID",
						-1, 0);
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId());
			}
		}
	}

	public String getContentitemName(long id) {
		return Server.getInstance().getMemberService().findDepartment(id)
				.getName();
	}

	public String getAgentName(long id) {
		return Server.getInstance().getMemberService().findCustomeragent(id)
				.getAgentcompanyname();
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	/**
	 * @throws NoSuchAlgorithmException
	 *             修改用户密码
	 */
	public void ajaxUpdatepassword() throws NoSuchAlgorithmException {
		Customeruser customer = (Customeruser) ServletActionContext
				.getRequest().getSession().getAttribute("loginuser");
		String pwd = ServletActionContext.getRequest().getParameter(
				"newpassword");
		String sql = "UPDATE [T_CUSTOMERUSER] SET "
				+ Customeruser.COL_logpassword + "='" + Util.MD5(pwd)
				+ "' WHERE ID=" + customer.getId();
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}
	
	/**
	 * @throws NoSuchAlgorithmException
	 *             修改支付密码
	 */
	public void ajaxUpdatepassword_pay() throws NoSuchAlgorithmException {
		Customeruser customer = (Customeruser) ServletActionContext
				.getRequest().getSession().getAttribute("loginuser");
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(customer.getAgentid());
		
		String pwd = ServletActionContext.getRequest().getParameter(
				"newpassword");
		String sql = "UPDATE [T_CUSTOMERAGENT] SET "
				+ Customeragent.COL_cacode + "='" + Util.MD5(pwd)
				+ "' WHERE ID=" + customer.getAgentid();
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}

	/**
	 * @throws Exception
	 *             验证客户端输入的原始密码是否正确
	 */
	public void ajaxIsRrigthPassword() throws Exception {
		Customeruser customer = (Customeruser) ServletActionContext
				.getRequest().getSession().getAttribute("loginuser");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (!Util.MD5(clientpwd).equals(customer.getLogpassword())) {
			out.write("false");
		} else {
			out.write("true");
		}
		out.flush();
		out.close();

	}
	
	/**
	 * @throws Exception
	 *             验证客户端输入的原始密码是否正确支付
	 */
	public void ajaxIsRrigthPassword_pay() throws Exception {
		Customeruser customer = (Customeruser) ServletActionContext
				.getRequest().getSession().getAttribute("loginuser");
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(customer.getAgentid());
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (!Util.MD5(clientpwd).equals(customeragent.getCacode())) {
			out.write("false");
		} else {
			out.write("true");
		}
		out.flush();
		out.close();

	}

	/**
	 * @throws SQLException
	 * 
	 * 修改或创建会员证件号
	 */
	public void updateCard() throws SQLException {
		if (s_cardnunber != "" && !s_cardnunber.equals("无")) {
			List<Customercredit> list = Server.getInstance().getMemberService()
					.findAllCustomercredit(
							" where " + Customercredit.COL_refid + " = "
									+ strCusID,
							" AND " + Customercredit.COL_credittypeid + "="
									+ this.cardType, -1, 0);
			if (list != null && list.size() > 0) {
				Customercredit cdit = list.get(0);
				cdit.setIssuingauthority(customercredit.getIssuingauthority());
				cdit.setPassportvalidity(customercredit.getPassportvalidity());
				cdit.setCreditnumber(s_cardnunber);
				cdit.setModifytime(new Timestamp(System.currentTimeMillis()));
				Customeruser user = (Customeruser) ServletActionContext
						.getRequest().getSession().getAttribute("loginuser");
				cdit.setModifyuser(user.getMembername());
				Server.getInstance().getMemberService()
						.updateCustomercreditIgnoreNull(cdit);
			} else {
				customercredit.setCredittypeid(this.cardType);
				customercredit.setCreditnumber(s_cardnunber);
				customercredit.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				customercredit.setModifytime(new Timestamp(System
						.currentTimeMillis()));
				customercredit.setRefid(Long.parseLong(strCusID));
				Customeruser user = this.getLoginUser();
				customercredit.setCreateuser(user.getMembername());
				Server.getInstance().getMemberService().createCustomercredit(
						customercredit);
			}
		}
	}

	/**
	 * @param id
	 *            保存修改用户所有证件
	 */
	public void custCreditMap(long id) {
		List<Customercredit> listcredit = Server.getInstance()
				.getMemberService().findAllCustomercredit(
						" where " + Customercredit.COL_refid + " = " + id,
						" order by " + Customercredit.COL_credittypeid, -1, 0);
		Map<Integer, String> ccmap = new HashMap<Integer, String>();
		if (listcredit != null && listcredit.size() > 0) {
			customercredit = listcredit.get(0);
			for (Customercredit c : listcredit) {
				ccmap.put(c.getCredittypeid(), c.getCreditnumber());
			}
		}

		ServletActionContext.getRequest().setAttribute("ccmap", ccmap);

	}

	private void getgxString(long id) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ getLoginUser().getAgentid(), "ORDER BY ID",
						-1, 0);
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getgxString(m.getId());
			}
		}
	}

	/**
	 * 
	 */

	/*
	 * public void ajaxGetListDeptByAgen() throws IOException{ long
	 * agenid=Long.valueOf(ServletActionContext.getRequest().getParameter("agenid"));
	 * getDeptstr(agenid); PrintWriter
	 * out=ServletActionContext.getResponse().getWriter();
	 * out.print(deptstr.toString()); out.flush(); out.close();
	 * 
	 * String sql="SELECT * FROM [T_DEPARTMENT] WHERE C_AGENTID="+agenid; List<Department>
	 * deptlist=Server.getInstance().getMemberService().findAllDepartmentBySql(sql,
	 * -1, 0); for(Department dept:deptlist){ if(dept.getParentid()==-1){
	 * this.deptsort(dept); } deptmap.add(dept); } }
	 */

	public String getAgentNameById(long agenid) {
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(agenid);
		String agentname = "";
		if (customeragent.getAgenttype() == 1)
			agentname = "运营商";
		if (customeragent.getAgenttype() == 2)
			agentname = "供应商";
		if (customeragent.getAgenttype() == 3)
			agentname = "分销商";
		String name = customeragent.getAgentcompanyname();
		if (customeragent.getAgenttype() == 3
				&& customeragent.getBigtype() == 1) {
			if (name != null && !name.equals("")) {
				return name + " / 大客户";
			} else {
				return "大客户";
			}
		} else {
			if (name != null && !name.equals("")) {
				return name + " / " + agentname;
			} else {
				return agentname;
			}

		}

	}

	public String getClientpwd() {
		return clientpwd;
	}

	public void setClientpwd(String clientpwd) {
		this.clientpwd = clientpwd;
	}

	public void setS_cardnunber(String s_cardnunber) {
		this.s_cardnunber = s_cardnunber;
	}

	public String getS_cardnunber() {
		return s_cardnunber;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	@Override
	public Object getModel() {
		return this.customeruser;
	}

	public String getAgendept() {
		return agendept;
	}

	public void setAgendept(String agendept) {
		this.agendept = agendept;
	}

	public List<Customercredit> getListCustomercredit() {
		return listCustomercredit;
	}

	public void setListCustomercredit(List<Customercredit> listCustomercredit) {
		this.listCustomercredit = listCustomercredit;
	}

	public String getCusagentname() {
		return cusagentname;
	}

	public void setCusagentname(String cusagentname) {
		this.cusagentname = cusagentname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public long getCustomeragentid() {
		return customeragentid;
	}

	public void setCustomeragentid(long customeragentid) {
		this.customeragentid = customeragentid;
	}

	public long getCustomerdeptid() {
		return customerdeptid;
	}

	public void setCustomerdeptid(long customerdeptid) {
		this.customerdeptid = customerdeptid;
	}

	public String getISWEB() {
		return ISWEB;
	}

	public void setISWEB(String isweb) {
		ISWEB = isweb;
	}

	public String getCompnayid() {
		return compnayid;
	}

	public void setCompnayid(String compnayid) {
		this.compnayid = compnayid;
	}

	public String getStrcompanyid() {
		return strcompanyid;
	}

	public void setStrcompanyid(String strcompanyid) {
		this.strcompanyid = strcompanyid;
	}

	public long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public String getS_isview() {
		return s_isview;
	}

	public void setS_isview(String s_isview) {
		this.s_isview = s_isview;
	}

	public String getParentagentid() {
		return parentagentid;
	}

	public void setParentagentid(String parentagentid) {
		this.parentagentid = parentagentid;
	}

	public String getS_agentjibie() {
		return s_agentjibie;
	}

	public void setS_agentjibie(String s_agentjibie) {
		this.s_agentjibie = s_agentjibie;
	}

	public String getStringroid() {
		return stringroid;
	}

	public void setStringroid(String stringroid) {
		this.stringroid = stringroid;
	}

	public Customeragent getCustomeragent() {
		return customeragent;
	}

	public void setCustomeragent(Customeragent customeragent) {
		this.customeragent = customeragent;
	}

	public void setPretBool(Boolean pretBool) {
		this.pretBool = pretBool;
	}

}