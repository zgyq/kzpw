/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.yf.system.back.server.Server;
import com.yf.system.back.services.CustomeragentService;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.biguser.Biguser;
import com.yf.system.base.city.City;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.province.Province;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class CustomeragentAction extends B2b2cbackAction {
	private List<Biguser> listBiguser;
	private static final long serialVersionUID = -1847412843136679416L;
	private List<Customeragent> listCustomeragent;
	private List<Customeruser> listCustomeruser;
	private List<Agentroleref> listAgentroleref;
	private Customeragent customeragent = new Customeragent();

	private List<Settlementtype> listsettle;
	private Agentroleref agentroleref = new Agentroleref();
	// 有效开始时间
	private String c_agentvsdate;
	// 有效结束时间
	private String c_agentvedate;
	private long compnayid;
	private long parentagentid;
	private long s_provinceid;
	private String companyname;
	private int s_cityid;
	private Double s_vmoney;
	private int type = 0;
	private String s_isview = "";
	private int enablestate = -1;
	private int maxrow;//总行数
	private int maxpage;//总页数
	private int page=1;
	private String bigname;
	private String agentusernamename;
	private String agentusernamename_ip;
	private String agentlinkname;
	
	private long hiddenid;
	private long hiddenid_ip;
	// search

	private String treestr = "";
	private String s_department;
	private String s_passenger;
	private List<Cityairport> listcityairport;
	private List<Province> listprovince;
	private int s_agentjibie = 0;
	private String forward;
	private Customeruser customeruser = new Customeruser();
	// 显示企业列表的集合
	private List gCusagelist;

	
	private String agentvalue;//固定值
	
	public List getGCusagelist() {
		return gCusagelist;
	}

	public void setGCusagelist(List cusagelist) {
		gCusagelist = cusagelist;
	}

	public String getC_agentvsdate() {
		return c_agentvsdate;
	}

	public void setC_agentvsdate(String c_agentvsdate) {
		this.c_agentvsdate = c_agentvsdate;
	}

	public String getC_agentvedate() {
		return c_agentvedate;

	}

	public void setC_agentvedate(String c_agentvedate) {
		this.c_agentvedate = c_agentvedate;
	}

	public Customeragent getCustomeragent(long id) {
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(id);
		return agent;
	}
	//以下为最新分销界面
    private boolean addmoney = false;
    public static boolean vmenable = false;
    
	public String tofenxiao() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
	    String agenttypestr = "采购商";
	    if (((Integer)converNull(this.customeragent.getAgenttype(), 
	      getLoginsessionagent().getAgenttype())).intValue() == 
	      2) {
	      agenttypestr = "供应商";
	    }
	    request.setAttribute("typestr", agenttypestr);

	    String strwhere = "";
	    if (getLoginUser().getId() == 1L)
	    {
	      strwhere = " WHERE 1=1 AND C_PARENTID= " + 
	        getLoginUserAgent().getId();
	    }
	    if (isNotNullOrEpt(this.customeragent.getAgentcompanyname())) {
	      strwhere = strwhere + " AND (C_AGENTCOMPANYNAME LIKE '%" + 
	        this.customeragent.getAgentcompanyname() + 
	        "%' OR C_AGENTSHORTNAME LIKE '%" + 
	        this.customeragent.getAgentcompanyname() + "%' )";
	    }
	    if (isNotNullOrEpt(this.customeragent.getCode())) {
	      strwhere = strwhere + " AND C_CODE='" + this.customeragent.getCode() + "'";
	    }
	    if (isNotNullOrEpt(this.customeragent.getAgentcontactname())) {
	      strwhere = strwhere + " AND C_AGENTCONTACTNAME='" + 
	        this.customeragent.getAgentcontactname() + "'";
	    }
	    if (isNotNullOrEpt(this.customeragent.getAgentphone())) {
	      strwhere = strwhere + " AND C_AGENTPHONE='" + this.customeragent.getAgentphone() + 
	        "'";
	    }
	    String where = "WHERE C_AGENTTYPE=" + this.customeragent.getAgenttype() + 
	      " AND C_AGENTCHECKSTATUS=1 ";
	    if (strwhere.length() > 0)
	    {
	      where = where + " AND CHARINDEX('," + getLoginUser().getAgentid() + 
	        ",',','+C_PARENTSTR+',')>0 " + strwhere;
	    }
	    else where = where + " AND C_PARENTID=" + getLoginUser().getAgentid();

	   /* if (getLoginsessionagent().getAgenttype().intValue() == 1) {
	      Systemrole role = getLoginRole();
	      if (role.getId() == 3L) {
	        where = where + " AND C_MANAGERUID=" + getLoginUser().getId();
	      }
	    }*/

	    this.pageinfo.setPagerow(10);
	    System.out.println(where);
	    List list = Server.getInstance().getMemberService()
	      .findAllCustomeragentForPageinfo(where, "ORDER BY ID DESC", 
	      this.pageinfo);
	    this.pageinfo = ((PageInfo)list.remove(0));
	    this.listCustomeragent = list;
		return "tofenxiao";
	}
	public void ajaxagentlist()
	  {
	    String where = " WHERE C_PARENTID=" + this.customeragent.getId();
	    this.listCustomeragent = 
	      Server.getInstance().getMemberService().findAllCustomeragent(where, "ORDER BY ID DESC", -1, 0);
	    System.out.println(this.listCustomeragent.size());
	    if (this.listCustomeragent.size() > 0) {
	      StringBuilder sb = new StringBuilder(
	        this.listCustomeragent.size() * 1024);
	      long parentid = this.customeragent.getId();
	      this.addmoney = super.checkright("addmoney");
	      createagenthtml(parentid, sb, this.listCustomeragent);

	      HttpServletResponse response = ServletActionContext.getResponse();
	      response.setContentType("text/html;charset=utf-8");
	      try
	      {
	        PrintWriter out = response.getWriter();
	        out.print(sb.toString());
	        out.flush();
	        out.close();
	      }
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	public void createagenthtml(long parentid, StringBuilder sb, List<Customeragent> listCustomeragent)
	  {
	    for (Customeragent agent : listCustomeragent) {
	     /* System.out.println(agent.getId() + "===========" + 
	        agent.getB2copenable());*/
	      if (agent.getParentid().longValue() == parentid) {
	        int jibie = agent.getAgentjibie().intValue() + 1;
	        if (agent.getAgentjibie().intValue() > 4) {
	          jibie -= 2;
	        }
	        String clss = agent.getParentstr().replace(',', ' ');
	        sb.append("<tr class='" + clss + "'>");

	        sb.append("<td align=\"left\"   class=\" pf" + ((jibie - 1) * 20) + 
	          "\" >");
	        sb.append("<font class=\"font-000 mr8\">");

	        sb
	          .append("<a href='javascript:void(0)' onclick='nexttoggle(" + 
	          agent.getId() + 
	          ");'><img  style=\"cursor: pointer;\" src=\"skin/blue/images/" + 
	          jibie + 
	          ".png\"  height=\"16\" align=\"absmiddle\" />" + 
	          agent.getCode());
	        sb.append("</a></font>");
	        sb.append("</td>");

	        sb.append("<td><font class=\"font-666\">" + 
	          agent.getAgentcompanyname() + "</font></td>");
	        //sb.append("<td><font class=\"font-666\">" + agent.getSmscount() + "</font></td>");//短信
	        sb.append("<td><font class=\"font-bdb0000\">" + 
	          ((((Integer)converNull(agent.getAgentisenable(), Integer.valueOf(0))).intValue() == 0) ? "禁用" : 
	          "正常") + 
	          "</font></td>");
	        if (vmenable) {
	          sb.append("<td><font class=\"font-bdb0000\">" + 
	            agent.getVmoney() + "</font></td>");
	        }
	        sb.append("<td><font class=\"font-666\">" + 
	          agent.getAgentcontactname() + "</font></td>");
	        sb.append("<td><font class=\"font-666\">" + 
	          agent.getAgentphone() + "</font></td>");

	        sb.append("<td class=\"line-h18\">");

	        if ((getLoginsessionagent().getAgenttype().intValue() == 1) 
	        		//|| (getLoginsessionagent().getAllowlevelcount()>0)
	          )
	        	
	        {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='customeragent!toadd.action?agenttype=" + 
	            agent.getAgenttype() + 
	            "&parentid=" + 
	            agent.getId() + "' >下级开户</a></font>|");
	        }
	        if ((getLoginsessionagent().getAgenttype().intValue() == 1) || 
	          (getLoginsessionagent().getId() == 
	          agent.getParentid().longValue()) || 
	          (getLoginsessionagent().getAllowlevelcount()>0)) {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='customeragent!toeditgent.action?compnayid=" + 
	            agent.getId() + "'>修改</a></font>|");
	          if (getLoginsessionagent().getAgenttype().intValue() == 1) {
	            sb
	              .append("<font class=\"x_line mfr5\"><a href='javascript:void(0)' onclick='candelt(" + 
	              agent.getId() + ");'>删除</a></font>|");
	          }

	        }

	        if ((((agent.getParentid().longValue() == getLoginsessionagent().getId()) || (
	          getLoginsessionagent().getAllowlevelcount()>0))) && 
	          (agent.getAgenttype().intValue() == 3)) {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='liudianinfo!toadd.action?lagentid=" + 
	            agent.getId() + "'>留点设置</a></font>|");
	        }

	        if (getLoginsessionagent().getAgenttype().intValue() == 1||1==1) {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='customeruser!toEmployeelist.action?agentid=" + 
	            agent.getId() + "'>员工信息</a></font>|");
	         /* sb
	            .append("<font class=\"x_line mfr5\"><a href='dnsmaintenance.action?agentid=" + 
	            agent.getId() + "'>域名绑定</a></font>|");*/
	        }
	        if ((vmenable) && (getLoginsessionagent().getAgenttype().intValue() == 1) && 
	          (this.addmoney)) {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='rebaterecord.action?rebaterecord.rebateagentid=" + 
	            agent.getId() + "'>充值</a></font>|");
	        }

	       /* if (getLoginsessionagent().getB2copenable().intValue() == 1) {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='b2cagent!b2cskip.action?agentid=" + 
	            agent.getId() + "'>B2C开户</a></font>");
	        }
	        if ((getLoginUserAgent().getAgenttype().intValue() == 1) || 
	          (getLoginsessionagent().getOpenable().intValue() == 1)) {
	          sb
	            .append("<font class=\"x_line mfr5\"><a href='customeragent!b2btoedit.action?customeragent.id=" + 
	            agent.getId() + "'>权限设置</a></font>");
	        }*/
	        sb
            .append("<font class=\"x_line mfr5\"><a href='rebaterecord.action?rebaterecord.rebateagentid=" + 
            agent.getId() + "'>充值</a></font>|");
	        
	        if(getLoginAgent().getAgenttype()==1){
	        sb
            .append("<font class=\"x_line mfr5\"><input type=\"hidden\" value=\""+agent.getAgentother()+"\" name=\"agentother_"+agent.getId()+"\" id=\"agentother_"+agent.getId()+"\" />");
            sb
            .append("<a href=\"javascript:void(0)\" onclick=\"showqemailbox("+agent.getId()+");return false;\">通知地址</a></font>|");
        	
            
            sb.append("<font class=\"x_line mfr5\"><input type=\"hidden\" value=\""+agent.getWebsite()+"\" name=\"website_"+agent.getId()+"\" id=\"website_"+agent.getId()+"\" />");
            //sb.append("<a href=\"javascript:void(0)\" onclick=\"showqemailbox_ip("+agent.getId()+");return false;\">绑定IP</a></font>|");
            sb.append("<font class=\"x_line mfr5\"><a href='login!tobaoxian.action?agentid=" +  agent.getId() + "'>设置保险</a></font>");
            
	        }
	        
	        sb.append("</td>");

	        sb.append("</tr><tr id='agentspan" + agent.getId() + "'></tr>");

	        createagenthtml(agent.getId(), sb, listCustomeragent);
	      }
	    }
	  }
	//以上为最新分销页面
	/**
	 * 显示航空公司
	 * 
	 * @throws IOException
	 */
	public String toshowcomputer() {
		return "toshowcomputer";
	}
	
	
	public String editURLvalue() {
	Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(hiddenid);	
	if(agentusernamename!=null&&agentusernamename.trim().length()>0){
		agent.setAgentother(agentusernamename);
		Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(agent);
	}
		forward="customeragent!tofenxiao.action?agenttype=3";
		return "forward";
	}
	public String editIPvalue() {
		Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(hiddenid_ip);	
		if(agentusernamename_ip!=null&&agentusernamename_ip.trim().length()>0){
			agent.setWebsite(agentusernamename_ip);
			Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(agent);
		}
			forward="customeragent!tofenxiao.action?agenttype=3";
			return "forward";
		}
	
	public String tohuoche() {
		customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid());
		
		return "tohuoche";
	}
	
	
	public String ShowAgentinfo() {
		
		customeragent=getLoginAgent();
		
		return "ShowAgentinfo";
	}
	public void ajaxtoCustomeragent() throws IOException {
	    this.customeragent = 
	      Server.getInstance().getMemberService().findCustomeragent(this.customeragent.getId());
	    String json = JSONObject.fromObject(this.customeragent).toString();
	    HttpServletResponse response = ServletActionContext.getResponse();
	    response.setContentType("text/json; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    System.out.println(json);
	    out.print(json);
	    out.flush();
	    out.close();
	  }
	public void getAgentJsontxt(StringBuilder sb, Customeragent agent,
			List<Customeragent> agentlist) {
		List<Customeragent> subagentlist = new ArrayList<Customeragent>();
		for (Customeragent cagent : agentlist) {
			if (converNull(cagent.getParentid(), 0l) == agent.getId()) {
				subagentlist.add(cagent);
			}
		}
		sb.append("{");
		sb.append("id: " + agent.getId() + ",");
		// sb.append("expanded: " + true + ",");
		// sb.append("ids:'{\"id\":\""+agent.getId()+"\",\"next\":\""+agent.getIschildcom()+"\",\"pass\":\""+agent.getAgentcheckstatus()+"\"}',");
		sb.append("name: '" + agent.getAgentcompanyname() + "',");
		sb.append("code: '" + agent.getCode() + "',");
		sb.append("type: '" + super.getAgentTypeName(agent.getAgentjibie())
				+ "',");
		// sb.append("account: " + converNull(agent.getVmoney(), 0) + ",");
		// sb.append("area: '"+agent.getAgentaddress()+"',");
		sb.append("contactname: '" + agent.getAgentcontactname() + "',");
		sb.append("contactmobile: '" + agent.getAgentphone() + "',");
		String levelstr = "不限";
		if (agent.getAllowlevelcount() != -1) {
			levelstr = agent.getAllowlevelcount() + "";
		}
		String proxystr = "不限";
		if (agent.getAllowproxycount() != -1) {
			proxystr = agent.getAllowproxycount() + "";
		}
		sb.append("allowlevelcount: '" + levelstr + "级',");
		sb.append("allowproxycount: '" + proxystr + "个',");
		//sb.append("vmoney: '" + agent.getVmoney() + "元',");
		String uname="";
		String whereuser=" SELECT C_LOGINNAME as loginname FROM T_CUSTOMERUSER WHERE C_AGENTID ="+agent.getId()+" AND C_MEMBERTYPE=-1";
		List listusername=Server.getInstance().getSystemService().findMapResultBySql(whereuser, null);
		if(listusername.size()>0){
			Map xMap=(Map)listusername.get(0);
			uname=xMap.get("loginname").toString();
		}
		
		sb.append("username: '"+uname+"',");
		sb.append("enable: '" + (agent.getAgentisenable() == 1 ? "启用" : "禁用")
				+ "',");
		// sb.append("checked: '"
		// + (agent.getAgentcheckstatus() == 1 ? "审核通过" : agent
		// .getAgentcheckstatus() == 2 ? "拒绝审核" : "未审核") + "',");
		// sb.append("operate: 'true',");
		if (subagentlist.size() > 0) {
			sb.append("expanded: " + true + ",");
			sb.append("children: [");
			for (int i = 0; i < subagentlist.size(); i++) {
				Customeragent theagent = subagentlist.get(i);
				if (i > 0) {
					sb.append(",");
				}
				getAgentJsontxt(sb, theagent, agentlist);
			}
			sb.append("]");
		} else {
			sb.append("leaf: true");
			// sb.append("iconCls: 'name'");
		}
		sb.append("}");

	}

	/**
	 * ajax请求获取采购商
	 * 
	 * @throws IOException
	 */
	public void getAgentJson() throws IOException {
		System.out.println(System.currentTimeMillis());
		HttpServletResponse response = ServletActionContext.getResponse();
		String aname = customeragent.getAgentcompanyname();
		List<Integer> agentjibie = new ArrayList<Integer>();// 初始化 0：一级。4.平台自有
		agentjibie.add(0);// 一级
	//	agentjibie.add(4);// 自有
		Customeragent agent = this.getLoginsessionagent();
		if(aname==null){
			aname="";
		}
		String agentname = new String(aname.getBytes("ISO-8859-1"),"GBK");
		String username="";
		String linkname="";
		if(agentusernamename!=null&&agentusernamename.length()>0){
			 username = new String(agentusernamename.getBytes("ISO-8859-1"),"GBK");
		}
		if(agentlinkname!=null&&agentlinkname.length()>0){
			linkname = new String(agentlinkname.getBytes("ISO-8859-1"),"GBK");
		}
		
		
		System.out.println("username:"+username);
		System.out.println("linkname:"+linkname);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String where = " WHERE ID>6 AND C_AGENTCHECKSTATUS=1 ";
		
		
		if (agent.getId()!=46) {
			agentjibie = new ArrayList<Integer>();
			System.out.println(agent.getAgentjibie());
			agentjibie.add(agent.getAgentjibie());
			where += " AND (ID=" + agent.getId() + " OR (charindex( ',"
			+ agent.getId() + ",',','+ C_PARENTSTR+',' )>0))";

		}
		if(this.getLoginsessionagent().getId()==1){
			customeragent.setAgenttype(1);
		}
		//加盟商名称
		if (isNotNullOrEpt(agentname)) {
			String sql = "EXEC [dbo].[STRUNION] @TABLE = N'T_CUSTOMERAGENT',  @COLUNAME = N'C_PARENTSTR',  @WHERE = N'WHERE (C_AGENTCOMPANYNAME LIKE ''%"
					+ agentname
					+ "%'' OR C_AGENTSHORTNAME LIKE ''%"
					+ agentname + "%'')'";
			System.out.println(sql);
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			Map m = (Map) list.get(0);
			String ustr = converNull(m.get("USTR"), "").toString();
			where += " AND ("
					+ // 上级
					"charindex(','+convert(nvarchar,ID)+',','"
					+ ustr
					+ "')>0 "
					+ "OR ID IN ( SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTCOMPANYNAME LIKE '%"
					+ agentname + "%' OR C_AGENTSHORTNAME LIKE '%" + agentname
					+ "%'))";

		}
		//联系人
		if (isNotNullOrEpt(linkname)) {
			String sql = "EXEC [dbo].[STRUNION] @TABLE = N'T_CUSTOMERAGENT',  @COLUNAME = N'C_PARENTSTR',  @WHERE = N'WHERE (C_AGENTCONTACTNAME LIKE ''%"
					+ linkname + "%'')'";
			System.out.println(sql);
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			Map m = (Map) list.get(0);
			String ustr = converNull(m.get("USTR"), "").toString();
			where += " AND ("
					+ // 上级
					"charindex(','+convert(nvarchar,ID)+',','"
					+ ustr
					+ "')>0 "
					+ "OR ID IN ( SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTCONTACTNAME LIKE '%"
					+ linkname + "%'))";

		}
		//用户名
		
		if(username!=null&&username.length()>0){
			
		//	where+=" and "+Customeragent.COL_id+" in ( SELECT "+Customeruser.COL_agentid+" FROM "+Customeruser.TABLE+" where "+Customeruser.COL_loginname+" like '%"+username+"%') ";
		}

		if (isNotNullOrEpt(username)) {
			String sql = "EXEC [dbo].[STRUNION] @TABLE = N'T_CUSTOMERAGENT',  @COLUNAME = N'C_PARENTSTR',  @WHERE = N'WHERE ( ID  IN ( SELECT "+Customeruser.COL_agentid+" FROM "+Customeruser.TABLE+" where "+Customeruser.COL_loginname+" like ''%"+username+"%'') )'";
			System.out.println(sql);
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			Map m = (Map) list.get(0);
			String ustr = converNull(m.get("USTR"), "").toString();
			where += " AND ("
					+ // 上级
					"charindex(','+convert(nvarchar,ID)+',','"
					+ ustr
					+ "')>0 "
					+ "OR ID IN ( ( SELECT "+Customeruser.COL_agentid+" FROM "+Customeruser.TABLE+" where "+Customeruser.COL_loginname+" like '%"+username+"%') ))";

		}
		if (converNull(customeragent.getAgenttype(), this
				.getLoginsessionagent().getAgenttype()) > 0) {
			where += " AND C_AGENTTYPE=" + customeragent.getAgenttype();

		}

		if (this.enablestate > -1) {
			where += " AND " + Customeragent.COL_agentisenable + "=" + enablestate;
		}
		System.out.println(where);
		//pageinfo.set
		// pageinfo.setPagerow(5);
		 
		 int st=0;//开始
		 int end=10;//结束
		// int maxrow;//总行数
		// int maxpage;//总页数
		 
		 List<Customeragent> listcus = Server.getInstance()
			.getMemberService().findAllCustomeragent(where,
					" ORDER BY ID DESC ", -1, 0);
		 maxrow=listcus.size();
		 maxpage=maxrow/10;
		 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 request.setAttribute("maxrow", maxrow);
		 request.setAttribute("maxpage", maxpage);
		 
		 String orderby=" ORDER BY ID DESC ";
		 
		 
		 //计算分页
		 if(page==1){
			 
			 st=0;
			 end=st+10;
		 }else{
			 
			 st=page*10-10;
			 end=st+10;
		 }
		 if(page==-9999){
			 st=0;
			 end=st+10;
			 orderby=" ORDER BY ID ";
		 }
		/* st=st*page;
		 end=st+10;*/
		 
		 System.out.println("orderby:"+orderby);
		 System.out.println("st:"+st+"...end:"+end);
		List<Customeragent> listcustomeragent = Server.getInstance()
				.getMemberService().findAllCustomeragent(where,
						orderby, 10, st);
		
		System.out.println(listcustomeragent.size());
		// pageinfo=(PageInfo)list.remove(0);
		// List<Customeragent>listcustomeragent=list;
		StringBuilder jsonsb = new StringBuilder("");
		jsonsb.append("[");

		for (int i = 0; i < listcustomeragent.size(); i++) {
			Customeragent customeragent = listcustomeragent.get(i);
			if (agentjibie.contains(customeragent.getAgentjibie())) {
				if (jsonsb.length() > 1) {
					jsonsb.append(",");
				}
				getAgentJsontxt(jsonsb, customeragent, listcustomeragent);

			}

		}
		jsonsb.append("]");
		 System.out.println(jsonsb);
//		 System.out.println("length:" + jsonsb.toString());
		out.print(jsonsb.toString());
		out.flush();
		out.close();
		System.out.println(System.currentTimeMillis());

	}

	/**
	 * 列表查询下级加盟商信息表
	 */
	public String toSubagent() throws Exception {
		String strwhere = " where 1=1 and " + Customeragent.COL_parentid + " ="
				+ getLoginUser().getAgentid();
		List list = Server.getInstance().getMemberService()
				.findAllCustomeragentForPageinfo(strwhere, "ORDER BY ID DESC",
						pageinfo);

		pageinfo = (PageInfo) list.remove(0);

		listCustomeragent = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeragent.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeragentForPageinfo(strwhere, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeragent = list;
		}

		return "toSubagent";
	}

	/**
	 * 列表查询加盟商信息表
	 */
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String agenttypestr = "采购商";
		if (converNull(customeragent.getAgenttype(), this
				.getLoginsessionagent().getAgenttype()) == 2) {
			agenttypestr = "供应商";
		}
		request.setAttribute("typestr", agenttypestr);
		
		
	/*	Customeragent agent = this.getLoginsessionagent();
		
		
		String where = " WHERE ID>6 AND C_AGENTCHECKSTATUS=1 ";
		if (agent.getId()!=46) {
			
			
		
			where += " AND (ID=" + agent.getId() + " OR (charindex( ',"
			+ agent.getId() + ",',','+ C_PARENTSTR+',' )>0))";

		}
		
		if (converNull(customeragent.getAgenttype(), this
				.getLoginsessionagent().getAgenttype()) > 0) {
			where += " AND C_AGENTTYPE=" + customeragent.getAgenttype();

		}

		if (this.enablestate > -1) {
			where += " AND " + Customeragent.COL_agentisenable + "=" + enablestate;
		}
		System.out.println(where);
		
		 int st=0;//开始
		 int end=10;//结束
		
		 //计算分页
		 if(page==1){
			 st=0;
			 end=st+10;
		 }else{
			 
			 st=page*10-10;
			 end=st+10;
		 }
		
		 
		 
		 
		List<Customeragent> listcustomeragent = Server.getInstance()
				.getMemberService().findAllCustomeragent(where,
						" ORDER BY ID ", end, st);*/

		return SUCCESS;
	}

	/**
	 * 获取下级
	 * 
	 * @param agent
	 * @return
	 */
	public int getNextlevelByAgent(Customeragent agent) {
		int level = agent.getAgentjibie();
		if (level == 4) {
			level = 0;
		} else if (level == 3) {
			level = 6;
		} else {
			level += 1;
		}
		return level;

	}

	/**
	 * 通过ID 获取下级级别代码
	 * 
	 * @param agentid
	 * @return
	 */
	public int getNextlevelByAgentId(long agentid) {
		String sql = "SELECT  C_AGENTJIBIE as agentjibie FROM T_CUSTOMERAGENT  WHERE ID="
				+ agentid;
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		Map m = (Map) list.get(0);
		try {
			Customeragent agent = super.setFiledfrommap(Customeragent.class, m);
			return getNextlevelByAgent(agent);
		} catch (Exception e) {
			System.out
					.println("获取下级级别赋值出错：customeragent:getNextlevelByAgentId");
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 转向到加盟商信息表添加页面
	 */
	public String toadd() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (this.getLoginsessionagent().getAgenttype() != 1) {
			String message = this.openablemsg(this.getLoginUser().getAgentid());
			if (message != null) {
				request.setAttribute("message", message);
				return this.tofenxiao();
			}
		}
		String[] levelarray = { "不限", "0", "1", "2" };// 默认可添级别
		String[] proxyarray = { "不限", "0", "1", "5", "10" };
		if (customeragent.getParentid() == null) {
			customeragent.setParentid(this.getLoginUser().getAgentid());
		}
//		Customeragent parentagent=super.findBySql(Customeragent.class, "SELECT C_AGENTTYPE AS agenttype FROM T_CUSTOMERAGENT WHERE ID= "+customeragent.getParentid());
//		System.out.println(customeragent.getAgenttype());
//		customeragent.setAgenttype(parentagent.getAgenttype());
		if (customeragent.getParentid() == 46) {
			customeragent.setAgentjibie(0);
		} else {
			customeragent.setAgentjibie(this
					.getNextlevelByAgentId(customeragent.getParentid()));
			Map m = this.getOpendlevelinfo(customeragent.getParentid());
			int ecount = Integer.valueOf(m.get("ECOUNT").toString());// 已开下级
			int alcount = Integer.valueOf(m.get("alcount").toString());// 允许级别
			int apcount = Integer.valueOf(m.get("apcount").toString());// 允许代理
			int clevel = Integer.valueOf(m.get("CLEVEL").toString());// 当前级别
			if (alcount > 0) {
				request.setAttribute("allowlevel", "");
				levelarray = new String[alcount];
				for (int i = 0; i < alcount; i++) {
					levelarray[i] = "" + i;
				}
			}
			if (apcount > 0) {
				request.setAttribute("allowproxy", "");
				proxyarray = new String[apcount];
				for (int i = 0; i < apcount; i++) {
					proxyarray[i] = i + "";
				}
			}

		}
		// 加盟商默认的机票出发城市
		listcityairport = Server.getInstance().getAirService()
				.findAllCityairport(" WHERE 1=1 AND "+Cityairport.COL_countrycode+" ='CN'",
						"order by " + Cityairport.COL_cityindex, -1, 0);
		// 加盟商所在省份
		listprovince = Server.getInstance().getHotelService().findAllProvince(
				"", "order by " + Province.COL_enname, -1, 0);
		request.setAttribute("levelarray", levelarray);
		request.setAttribute("proxyarray", proxyarray);
		String agenttypestr = "采购商";
		if (customeragent.getAgenttype() == 2) {
			agenttypestr = "供应商";
		}
		request.setAttribute("typestr", agenttypestr);
		System.out.println(customeragent.getAgenttype());
		System.out.println(customeragent.getParentid());
		return EDIT;

	}

	public String toaddbiguser() throws Exception {// 跳转到添加大客户页面

		// 列表显示客户经理

		listCustomeruser = Server.getInstance().getMemberService()
				.findAllCustomeruser(
						" where 1=1 and " + Customeruser.COL_id
								+ " in ( SELECT "
								+ Agentroleref.COL_customeruserid + " FROM "
								+ Agentroleref.TABLE + " where "
								+ Agentroleref.COL_roleid + " =10038)", "", -1,
						0);
		
		return "toaddbiguser";
		
	}

	// 大客户列表
	public String tobiguser() throws Exception {
		String where = "";
		if (isAdmin() || getLoginUser().getType() == 1) {

			where += " where 1=1 and " + Customeragent.COL_bigtype + " =1";
		} else {
			where += " where 1=1 and " + Customeragent.COL_bigtype + " =1 and "
					+ Customeragent.COL_createuser + " ='"
					+ getLoginUser().getLoginname() + "'";

		}
		// if (s_name != null && s_name.trim().length() != 0) {
		//
		// where += " and " + Customeragent.COL_agentcompanyname + " like '%"
		// + s_name.trim() + "%'";
		// }
		// if (s_name2 != null && s_name2.trim().length() != 0) {
		//
		// where += " and " + Customeragent.COL_agentshortname + " like '%"
		// + s_name2.trim() + "%'";
		// }
		List list = Server.getInstance().getMemberService()
				.findAllCustomeragentForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeragent = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeragent.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeragentForPageinfo(where,
							" ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeragent = list;
		}
		return "biguser";
	}

	/**
	 * 转向添加佣金政策页面
	 */
	public String toyjzc() throws Exception {
		Long agentid = Server.getInstance().getMemberService()
				.findCustomeruser(getLoginUser().getId()).getAgentid();
		customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(agentid);
		return "showyjzc";
	}

	public String tosetyj() throws Exception {

		Long agentid = Server.getInstance().getMemberService()
				.findCustomeruser(getLoginUser().getId()).getAgentid();
		customeragent.setId(agentid);
		Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(
				customeragent);

		String where = " where 1=1 ";
		// 加盟商的父级序号为当前登录用户的加盟商序号
		where += " and " + Customeragent.COL_parentid + "="
				+ this.getLoginUser().getAgentid();
		Customeragent currentCust = Server.getInstance().getMemberService()
				.findCustomeragent(getLoginUserId());
		if (currentCust != null) {
			String parentstr = currentCust.getParentid() != null ? currentCust
					.getId()
					+ "," + currentCust.getParentid() : currentCust.getId()
					+ "";
			where += " and " + Customeragent.COL_parentstr + " like '"
					+ parentstr + "'";
		}
		List list = Server.getInstance().getMemberService()
				.findAllCustomeragentForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeragent = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeragent.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeragentForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeragent = list;
		}
		return SUCCESS;
	}

	/**
	 * 转向到供销商信息表添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toaddSupply() throws Exception {
		return "supplyEdit";
	}

	/**
	 * 转向到分销商信息表添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toaddDistribution() throws Exception {
		return "distrEdit";
	}

	/**
	 * 转向到加盟商信息表修改页面
	 */
	public String toeditgent() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 加盟商默认的机票出发城市
		listcityairport = Server.getInstance().getAirService()
		.findAllCityairport(" WHERE 1=1 AND "+Cityairport.COL_countrycode+" ='CN'",
				"order by " + Cityairport.COL_cityindex, -1, 0);
		// 加盟商所在省份
		listprovince = Server.getInstance().getHotelService().findAllProvince(
				"", "order by " + Province.COL_enname, -1, 0);
		if (compnayid == 0) {
			customeragent = this.getLoginsessionagent();
		} else {
			customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(compnayid);
			
			System.out.println(customeragent.getBussinesslist().size());
		}
		String sql = "SELECT ID as id, C_MEMBERNAME AS membername ,C_MEMBERMOBILE as membermobile,C_LOGINNAME as loginname "
				+ "FROM T_CUSTOMERUSER WHERE C_MEMBERTYPE=-1 AND C_AGENTID="
				+ customeragent.getId();
		Customeruser user = super.findBySql(Customeruser.class, sql);
		request.setAttribute("user", user);
		String[] levelarray = { "不限", "0", "1", "2" };// 默认可添级别
		String[] proxyarray = { "不限", "0", "1", "5", "10" };
		if (this.getLoginsessionagent().getAgenttype() != 1) {
			Map m = this.getOpendlevelinfo(customeragent.getParentid());
			int ecount = Integer.valueOf(m.get("ECOUNT").toString());// 已开下级
			int alcount = Integer.valueOf(m.get("alcount").toString());// 允许级别
			int apcount = Integer.valueOf(m.get("apcount").toString());// 允许代理
			int clevel = Integer.valueOf(m.get("CLEVEL").toString());// 当前级别
			if (alcount > 0) {
				request.setAttribute("allowlevel", "");
				levelarray = new String[alcount];
				for (int i = 0; i < alcount; i++) {
					levelarray[i] = "" + i;
				}
			}
			if (apcount > 0) {
				request.setAttribute("allowproxy", "");
				proxyarray = new String[apcount];
				for (int i = 0; i < apcount; i++) {
					proxyarray[i] = i + "";
				}
			}
		}
		request.setAttribute("levelarray", levelarray);
		request.setAttribute("proxyarray", proxyarray);

		return EDIT;
	}

	private Double getDebt(long gentid) {
		// 乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=

		// 废票失败9=改签成功10=改签失败11=已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失

		// 败
		String where = "where " + Passenger.COL_state
				+ " IN (1,2,3,4,5,6,7,8,9,10,13,14,15) AND "
				+ Passenger.COL_orderid + " in (SELECT " + Orderinfo.COL_id
				+ " from " + Orderinfo.TABLE + " where "
				+ Orderinfo.COL_buyagentid+ " =" + gentid + ")";
		List<Passenger> passlist = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		float zongfei = 0f;
		for (Passenger passenger : passlist) {
			if (passenger.getYihai() == null)
				passenger.setYihai(0f);
			int state = passenger.getState();
			if ((state == 1 || state == 4 || state == 5 || state == 6
					|| state == 7 || state == 8 || state == 10 || state == 13
					|| state == 14 || state == 15)
					&& passenger.getHkstate() != 2) {// 已出票 ！=已还
				float titcketprice = passenger.getPrice();// 票价
				float buildprice = passenger.getAirportfee();// 机建费
				float oilprice = passenger.getFuelprice();// 燃油费
				float insure =passenger.getInsurprice();
				float lastprice = (titcketprice + buildprice + oilprice + insure)
						- passenger.getYihai();
				zongfei += lastprice;

			}
			if ((passenger.getState() == 2 || passenger.getState() == 3)
					&& passenger.getHkstate() != 2) {
				zongfei += passenger.getTuifee() - passenger.getYihai();

			}
			if (passenger.getState() == 9 && passenger.getHkstate() != 2) {
				float titcketprice = passenger.getPrice();// 票价
				float buildprice = passenger.getAirportfee();// 机建费
				float oilprice = passenger.getFuelprice();// 燃油费
				float insure = passenger.getInsurprice();// 保险费用
				float lastprice = (titcketprice + buildprice + oilprice + insure)
						- passenger.getYihai();
				zongfei += lastprice + passenger.getTuifee()
						- passenger.getYihai();
			}

		}

		where = " where 1=1  and " + Miscellaneous.COL_state + " in (1,3) ";
		where += " and " + Miscellaneous.COL_groupuserid + " =" + gentid;
		List<Miscellaneous> misces = Server.getInstance().getMemberService()
				.findAllMiscellaneous(where, "", -1, 0);
		for (Miscellaneous ms : misces) {
			if (ms.getState() == 1) {
				zongfei += ms.getPrice();
			}
			if (ms.getState() == 3) {
				zongfei += ms.getPrice() - ms.getYihai();
			}
		}
		return Double.valueOf(zongfei);
	}

	/**
	 * 加盟商申请
	 * 
	 * @return
	 */
	public String agentrequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		customeragent.setAgentcheckstatus(0);
		customeragent.setCreatetime(this.getCurrentTime());
		customeragent.setCreateuser(null);
		customeragent.setParentid(46l);
		customeragent.setAgentjibie(0);

		String message = "您好，您的申请已成功提交，我们将尽快与您联系，感谢您的支持！";
		try {
			if(isNotNullOrEpt(customeragent.getAgentcompanyname())){
				Server.getInstance().getMemberService().createCustomeragent(
						customeragent);
			}else{
				message = "请完整填写申请信息。";
			}
		} catch (SQLException e) {
			Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
			message = "抱歉，由于网络故障导致申请失败，请联系客服：" + dns.getServiceline() + "。";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		return "toagentrequest";
	}

	/**
	 * 加盟商申请列表
	 * 
	 * @return
	 */
	public String agentrequestlist() {

		/*String sql = "SELECT ID,C_AGENTCOMPANYNAME,C_AGENTTYPE,C_CREATETIME,C_AGENTCONTACTNAME,"
				+ "C_AGENTPHONE,C_AGENTADDRESS,"
				+ "(SELECT C_AGENTCOMPANYNAME FROM T_CUSTOMERAGENT WHERE ID=T.C_PARENTID)AS PARENTNAME "
				+ "FROM T_CUSTOMERAGENT T  WHERE C_AGENTCHECKSTATUS=0";
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("agentlist", list);*/
		
		String where=" WHERE 1=1 AND C_AGENTCHECKSTATUS =0 ";
		
	    List list = Server.getInstance().getMemberService().findAllCustomeragentForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustomeragent = list;
		  if(pageinfo.getTotalrow()>0 &&   listCustomeragent.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomeragentForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCustomeragent = list;
		}
		  
		//listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(, " ORDER BY ID DESC ", -1, 0);
		
		return "agentrequestlist";
	}

	/**
	 * 加盟商申请查看
	 * 
	 * @return
	 */
	public String agentrequestinfo() {
		try {
			this.customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(customeragent.getId());
		} catch (Exception e) {
			System.out.println("此加盟商不存在");
			e.printStackTrace();
		}
		return "agentrequestinfo";
	}
	

	/**
	 * 到添加G企业
	 * 
	 * @return
	 */
	public String toaddGcompany() {
		return "toaddgcompany";
	}

	/**
	 * 添加G企业
	 * 
	 * @return
	 */
	public String addGcompany() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 设置编号
		customeragent.setCode("www123");
		// 设置状态为4为G客户
		customeragent.setAgenttype(4);
		customeragent.setModifyuser(getLoginUser().getLoginname());
		customeragent.setCreateuser(getLoginUser().getLoginname());
		customeragent.setAgentvsdate(dateToTimestamp(c_agentvsdate));
		customeragent.setAgentvedate(dateToTimestamp(c_agentvedate));
		String[] bussiness = request.getParameterValues("businesstype");
		CustomeragentService service = new CustomeragentServiceImpl();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser user = new Customeruser();
		user = (Customeruser) session.getAttribute("loginuser");
		try {
			service.add(customeragent, user, bussiness, this
					.getLoginsessionagent().getId());
			System.out.println("添加成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("添加失败！");
		}
		return toshowGcompany();
	}

	/**
	 * 显示企业列表
	 * 
	 * @return
	 */
	public String toshowGcompany() {
		// String where="SELECT * FROM T_CUSTOMERAGENT";
		StringBuilder sb = new StringBuilder("WHERE C_AGENTTYPE = 4");
		if (customeragent.getAgentcompanyname() != null
				&& customeragent.getAgentcompanyname().equals("")) {
			sb.append(" AND C_AGENTCOMPANYNAME like %'"
					+ customeragent.getAgentcompanyname() + "%'");
		}
		if (customeragent.getAgentcontactname() != null
				&& customeragent.getAgentcontactname().equals("")) {
			sb.append(" AND C_AGENTCONTACTNAME like %'"
					+ customeragent.getAgentcontactname() + "%'");
		}
		System.out.println(sb);
		this.setGCusagelist(Server.getInstance().getMemberService()
				.findAllCustomeragentForPageinfo(sb.toString(),
						" ORDER BY ID ", pageinfo));
		// pageinfo = (PageInfo)gCusagelist.remove(0);
		return "toshowGcompany";
	}
	/**
	 * 添加加盟商信息表
	 */
	public String addrequestCustomeragent() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		customeragent.setAgentcheckstatus(0);
		customeragent.setAgentisenable(0);
		customeragent.setAllowlevelcount(-1);// 表示不限
		customeragent.setAllowproxycount(-1);// 表示不限
		String arentstr="46,1";
		if(customeragent.getParentid()!=null){
		Customeragent customerag=Server.getInstance().getMemberService().findCustomeragent(Long.valueOf(customeragent.getParentid()));
		arentstr=customerag.getId()+","+customerag.getParentstr();
		}
		customeragent.setParentid(46l);
		customeragent.setParentstr(arentstr);
		customeragent.setCreateuser("admin");
		customeragent.setAgentvsdate(dateToTimestamp(c_agentvsdate));
		customeragent.setAgentvedate(dateToTimestamp(c_agentvedate));
		customeragent.setUserid(46l);
		customeragent.setCreatetime(this.getCurrentTime());
		customeragent.setAgentphone(customeragent.getAgentmobile());
		String message = "您好，您的申请已成功提交，我们将尽快与您联系，感谢您的支持！";
		try {
			Server.getInstance().getMemberService().createCustomeragent(customeragent);
		} catch (Exception e) {
			Dnsmaintenance dns = (Dnsmaintenance) session.getAttribute("dns");
			message = "抱歉，由于网络故障导致申请失败，请联系客服协助处理。";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		if(customeragent.getAgenttype()==3){
			return "addrequestCustomeragent_fenxiao";
		}
		if(customeragent.getAgenttype()==2){
			return "addrequestCustomeragent_gongying";
		}
		return "addrequestCustomeragent";

	}

	/**
	 * 添加加盟商信息表
	 */
	public String add() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String name = request.getParameter("username");
		String mobile = request.getParameter("usermobile");
		Customeruser user = new Customeruser();
		user.setMembername(name);
		user.setMembermobile(mobile);
		user.setLoginname(loginname);
		user.setLogpassword(Util.MD5(password));
		user.setType(customeragent.getAgenttype());
		String levelcount = request.getParameter("levelcount");
		String proxycount = request.getParameter("proxycount");
		try {
			customeragent.setAllowproxycount(Integer.valueOf(proxycount));
		} catch (Exception e) {

		}
		try {
			customeragent.setAllowlevelcount(Integer.valueOf(levelcount));
		} catch (Exception e) {
			customeragent.setAllowlevelcount(-1);// 表示不限
			customeragent.setAllowproxycount(-1);// 表示不限
		}
		if(customeragent.getParentid()==null){
		customeragent.setParentid(46l);
		}
		
		/*String arentstr="46";
		if(getLoginUser().getAgentid()==46){
			arentstr="46,1";
		}else{
			Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid());
			if(customeragent.getParentstr()!=null){
				arentstr=customeragent.getId()+","+customeragent.getParentstr();
			}
			
		}*/
		String arentstr="46,1";
		if(customeragent.getParentid()!=null){
		Customeragent customerag=Server.getInstance().getMemberService().findCustomeragent(Long.valueOf(customeragent.getParentid()));
		arentstr=customerag.getId()+","+customerag.getParentstr();
		}
		
		customeragent.setParentstr(arentstr);
		customeragent.setCreateuser(getLoginUser().getLoginname());
		customeragent.setAgentvsdate(dateToTimestamp(c_agentvsdate));
		customeragent.setAgentvedate(dateToTimestamp(c_agentvedate));
		if (customeragent.getUserid() != null) {
			customeragent.setUserid(customeragent.getUserid());
		} else {
			customeragent.setUserid(getLoginUserId());
		}
		
		
		//customeragent.setAgentphone(customeragent.getAgentmobile());
		
		String[] bussiness = request.getParameterValues("businesstype");
		CustomeragentService service = new CustomeragentServiceImpl();
		service.add(customeragent, user, bussiness, this.getLoginsessionagent()
				.getId());
		return this.tofenxiao();

	}

	/**
	 * 添加加盟商信息表
	 */
	public String reg() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String levelcount = request.getParameter("levelcount");
		String proxycount = request.getParameter("proxycount");
		try {
			customeragent.setAllowproxycount(Integer.valueOf(proxycount));
		} catch (Exception e) {

		}
		try {
			customeragent.setAllowlevelcount(Integer.valueOf(levelcount));
		} catch (Exception e) {
			customeragent.setAllowlevelcount(0);// -1表示不限
			customeragent.setAllowproxycount(0);// -1表示不限
		}
		
		String arentstr="46,1";
		if(customeragent.getParentid()!=null){
		Customeragent customerag=Server.getInstance().getMemberService().findCustomeragent(Long.valueOf(customeragent.getParentid()));
		arentstr=customerag.getId()+","+customerag.getParentstr();
		}
		
		customeragent.setParentstr(arentstr);
		customeragent.setCreateuser("申请");
		customeragent.setAgentvsdate(dateToTimestamp(c_agentvsdate));
		customeragent.setAgentvedate(dateToTimestamp(c_agentvedate));
		customeragent.setAgentcheckstatus(0);
		customeragent.setUserid(-1l);
		
		Server.getInstance().getMemberService().createCustomeragent(customeragent);
	
		String message = "您好，您的申请已成功提交，我们将尽快与您联系，感谢您的支持！";
		
		request.setAttribute("message", message);
		return "toreg";

	}

	/**
	 * 跳转至加盟商申请
	 * 
	 * @return
	 */
	public String torequestCustomeragent() {
		String where = " WHERE " + Customeragent.COL_agentcheckstatus + "=-1";
		List list = Server.getInstance().getMemberService()
				.findAllCustomeragentForPageinfo(where, " ORDER BY ID ",
						this.pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCustomeragent = list;
		if (pageinfo.getTotalrow() > 0 && listCustomeragent.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeragentForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCustomeragent = list;
		}
		return "torequestCustomeragent";
	}

	/**
	 * 采购商下级开户申请
	 */
	public void agentnextrequest() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			String message = "";
			try {
				this.add();
				message = "true";
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.print(message);
			out.flush();
			out.close();
		} catch (IOException e1) {
		}

	}

	public String checkbig() throws Exception {
		customeragent.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeragent.setModifyuser(getLoginUser().getLoginname());

		Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(
				customeragent);
		return "checkbig";
	}

	/**
	 * 编辑加盟商信息表
	 */
	public String edit() throws Exception {
		System.out.println(customeragent.getSmsmoney());
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(customeragent.getId());
		String levelcount = request.getParameter("levelcount");
		String proxycount = request.getParameter("proxycount");
		try {
			customeragent.setAllowproxycount(Integer.valueOf(proxycount));
		} catch (Exception e) {
		}
		try {
			customeragent.setAllowlevelcount(Integer.valueOf(levelcount));
		} catch (Exception e) {
			customeragent.setAllowlevelcount(-1);
			customeragent.setAllowproxycount(-1);
		}
		customeragent.setModifytime(new Timestamp(System.currentTimeMillis()));
		customeragent.setModifyuser(getLoginUser().getLoginname());
		customeragent.setCityid(s_cityid);
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String name = request.getParameter("username");
		String mobile = request.getParameter("usermobile");
		String uid = request.getParameter("loginuid");
		Customeruser user = new Customeruser();
		if(isNotNullOrEpt(uid)){
		user.setId(Long.valueOf(uid));
		}
		user.setMembername(name);
		user.setMembermobile(mobile);
		user.setLoginname(loginname);
		if (isNotNullOrEpt(password)) {
			user.setLogpassword(Util.MD5(password));
		}
		String[] bussiness = request.getParameterValues("businesstype");
		CustomeragentService service = new CustomeragentServiceImpl();
		service.editAgent(customeragent, user, bussiness, this
				.getLoginsessionagent().getId());
		return this.tofenxiao();
	}

	/**
	 * 删除加盟商信息表
	 */
	public String delete() throws Exception {
		System.out.println(customeragent.getAgenttype());
		long cagentid = customeragent.getId();
		StringBuilder sql = new StringBuilder();
		sql
				.append("DELETE T_CUSTOMERUSER WHERE C_AGENTID IN ( SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
						+ cagentid
						+ " OR CHARINDEX(',"
						+ cagentid
						+ ",',','+C_PARENTSTR+',')>0)");
		sql.append("DELETE T_CUSTOMERAGENT WHERE ID=" + cagentid
				+ " OR CHARINDEX('," + cagentid + ",',','+C_PARENTSTR+',')>0;");
		sql.append("DELETE T_AGENTROLEREF WHERE C_CUSTOMERUSERID NOT IN(SELECT ID FROM T_CUSTOMERUSER);");//删除用户角色对应数据
		sql.append("DELETE T_AGENTREFBUSSINESS WHERE C_AGENTID="+cagentid);//删除用户角色对应数据
		System.out.println(sql.toString());
		Server.getInstance().getSystemService().findMapResultBySql(
				sql.toString(), null);
		
		//删除对应扣点
		Server.getInstance().getMemberService().excuteLiudianrefinfoBySql(" DELETE "+Liudianrefinfo.TABLE+" where "+Liudianrefinfo.COL_agentid+" ="+cagentid);
		//;
		return this.tofenxiao();
	}

	/**
	 * 判断当前加盟商是否可删除
	 */
	public void ajaxcandelt() {
		String sql = "SELECT COUNT(ID) FROM T_ORDERINFO WHERE C_BUYAGENTID="
				+ this.customeragent.getId();
		int count = Server.getInstance().getMemberService()
				.countCustomeragentBySql(sql);
	  float vmoney=new CustomeragentServiceImpl().getTotalVmoney(customeragent.getId());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			if (count > 1||vmoney>0) {
				out.print("false");
			} else {
				out.print("true");
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 判断能否开下级 获取对应信息
	 * 
	 * @param agentid
	 * @return
	 */
	public Map<String, Integer> getOpendlevelinfo(long agentid) {
		StringBuilder sql = new StringBuilder("");
		sql
				.append(" SELECT ISNULL((COUNT(ID)+SUM(C_ALLOWPROXYCOUNT)),0) AS ECOUNT,");
		sql.append(" (SELECT C_AGENTJIBIE  FROM T_CUSTOMERAGENT WHERE ID="
				+ agentid + ") AS CLEVEL  ,");
		sql.append(" (SELECT C_ALLOWLEVELCOUNT FROM T_CUSTOMERAGENT WHERE ID="
				+ agentid + ") AS alcount ,");
		sql.append(" (SELECT C_ALLOWPROXYCOUNT FROM T_CUSTOMERAGENT WHERE ID="
				+ agentid + ") AS apcount");
		sql
				.append(" FROM T_CUSTOMERAGENT WHERE charindex( ','+CONVERT(NVARCHAR(50),"
						+ agentid + ")+',',','+ C_PARENTSTR+',' )>0");
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql.toString(), null);
		Map m = (Map) list.get(0);
		return m;

	}

	/**
	 * 判断当前加盟商是否可开下级 若返回null表示可以
	 * 
	 * @param agengid
	 * @return
	 */
	public String openablemsg(long agengid) {
		Map m = this.getOpendlevelinfo(agengid);
		int ecount = Integer.valueOf(m.get("ECOUNT").toString());// 已开下级
		int alcount = Integer.valueOf(m.get("alcount").toString());// 允许级别
		int apcount = Integer.valueOf(m.get("apcount").toString());// 允许代理
		int clevel = Integer.valueOf(m.get("CLEVEL").toString());// 当前级别
		String message = null;
		if (alcount == 0) {
			message = "当前加盟商不被允许开下级代理";
		} else if (alcount > 0 && ecount == apcount) {
			message = "代理个数超出允许数量";

		}
		return message;
	}

	/**
	 * mmm 判断是否可开下级
	 */
	public void ajaxopenenable() {
		long id = customeragent.getId();
		String message = openablemsg(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(converNull(message, ""));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据省id取得所有市级信息
	 */
	public String loadcitylist() throws Exception {
		String strReturn = "<select name='cityid' id='ddlciyid' onchange='bindcityid();'>";
		List<City> listcity = Server.getInstance().getHotelService()
				.findAllCity(
						"where " + City.COL_provinceid + "=" + s_provinceid,
						"", -1, 0);
		if (listcity.size() > 0) {
			for (int i = 0; i < listcity.size(); i++) {
				strReturn += "<option value='" + listcity.get(i).getId() + "'>"
						+ listcity.get(i).getName() + "</option>";
			}
		}
		strReturn += "</select>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(strReturn);
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();
		return strReturn;
	}

	public String getAgentRoot(Integer...agenttypes) {
		Customeragent cagent = this.getLoginsessionagent();
		int agenttype = cagent.getAgenttype();
		long searchtype=0;
		if(agenttypes!=null&&agenttypes.length>0){
			searchtype=agenttypes[0];
		}
		long parentid = 46;
		if (agenttype != 1) {
			parentid = cagent.getId();
		}
		StringBuffer agentbuffer = new StringBuffer();
		agentbuffer
				.append("var root = new Ext.tree.TreeNode({text:\"所 有\",id:'-1'});");
		// if (agenttype == 1) {
		// List<Customeragent> yunys = Server.getInstance().getMemberService()
		// .findAllCustomeragent(" WHERE C_AGENTTYPE =1",
		// " ORDER BY ID ASC ", -1, 0);
		// for (Customeragent agent : yunys) {
		// String rootname = "root_" + agent.getId();
		// agentbuffer.append("var " + rootgname
		// + "=new Ext.tree.TreeNode({text:\""
		// + agent.getAgentcompanyname() + "\",id:'" + agent.getId()
		// + "'});");
		// agentbuffer.append("root.appendChild(" + rootname + ");");
		// }
		// }
		
		//陈星注释
		/*if(searchtype==0||searchtype==2)
		if (agenttype == 1 || agenttype == 2) {
			String sql = " SELECT ID AS id,C_PARENTID AS parentid,C_AGENTCOMPANYNAME AS agentname FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE=2"
					+ " AND ( ID="
					+ parentid
					+ " OR CHARINDEX(','+CONVERT(NVARCHAR(50),"
					+ parentid
					+ ")+',',','+C_PARENTSTR+',')>0) AND C_PARENTID IS NOT NULL ORDER BY ID ASC";

			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			if (list.size() > 0) {
				List<Map> gongys = list;
				String rootname = "root_gy";
				agentbuffer.append("var " + rootname
						+ "=new Ext.tree.TreeNode({text:\"供应商\",id:'-2'});");
				agentbuffer.append("root.appendChild(" + rootname + ");");
				for (Map gymap : gongys) {
					long id = Long.valueOf(gymap.get("id").toString());//id
					long partid = Long
							.valueOf(gymap.get("parentid").toString());//parentid
					String agentname = gymap.get("agentname").toString();//name
					if (agenttype == 1) {
						if (partid != parentid) {
							continue;
						}
					} else {
						if (id != parentid) {
							continue;
						}
					}
					String rootname2 = "root_" + id;
					agentbuffer.append("var " + rootname2
							+ "=new Ext.tree.TreeNode({text:\"" + agentname
							+ "\",id:'" + id + "'});");
					agentbuffer.append("root_gy.appendChild(" + rootname2
							+ ");");
					this.getSubRoot(id, gongys, rootname2, agentbuffer);
				}
				list = null;
			}
		}*/
		//陈星注释
		
		
		if(searchtype==0||searchtype==3)
		if (agenttype == 1 || agenttype == 3) {
			String sql = " SELECT TOP 10 ID AS id,C_PARENTID AS parentid,C_AGENTCOMPANYNAME AS agentname FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE=3"
					+ " AND ( ID="
					+ parentid
					+ " OR CHARINDEX(','+CONVERT(NVARCHAR(50),"
					+ parentid
					+ ")+',',','+C_PARENTSTR+',')>0) AND C_PARENTID IS NOT NULL  ORDER BY ID ASC ";

			
			
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			if (list.size() > 0) {
				List<Map> fenxs = list;
				String rootname = "root_fx";
				agentbuffer.append("var " + rootname
						+ "=new Ext.tree.TreeNode({text:\"采购商\",id:'-3'});");
				agentbuffer.append("root.appendChild(" + rootname + ");");
				for (Map fxmap : fenxs) {
					long id = Long.valueOf(fxmap.get("id").toString());
					long partid = Long
							.valueOf(fxmap.get("parentid").toString());
					String agentname = fxmap.get("agentname").toString();
					if (agenttype == 1) {
						if (partid != parentid) {
							continue;
						}
					} else {
						if (id != parentid) {
							continue;
						}
					}
					String rootname3 = "root_" + id;
					agentbuffer.append("var " + rootname3
							+ "=new Ext.tree.TreeNode({text:\"" + agentname
							+ "\",id:'" + id + "'});");
					agentbuffer.append("root_fx.appendChild(" + rootname3
							+ ");");
					this.getSubRoot(id, fenxs, rootname3, agentbuffer);

				}

				list = null;
			}
		}
		return agentbuffer.toString();
	}

	private void getSubRoot(long parentid, List<Map> gentmaplist,
			String parentroot, StringBuffer buffer) {
		for (Map agentmap : gentmaplist) {
			long id = Long.valueOf(agentmap.get("id").toString());
			long partid = Long.valueOf(agentmap.get("parentid").toString());
			if (partid == parentid) {
				String agentname = agentmap.get("agentname").toString();
				String rootname = "root_" + id;
				buffer.append("var " + rootname
						+ "=new Ext.tree.TreeNode({id:'" + id + "',text:'"
						+ agentname + "'});");
				buffer.append(parentroot + ".appendChild(" + rootname + ");");
				this.getSubRoot(id, gentmaplist, rootname, buffer);
			}
		}
	}

	/**
	 * 查看当前登录人所属代理商预存款余额
	 */
	public String getYuCunKuanView() {
		// 取得当前登录人所在的代理商id
		customeragent = this.getLoginuserAgentfromdb();

		return "toyucunkuanview";

	}

	/**
	 * @return
	 * 
	 * 获得当前登录者所属单位
	 */
	public Customeragent getLoginuserAgentfromdb() {
		return Server.getInstance().getMemberService().findCustomeragent(
				this.getLoginUser().getAgentid());
	}

	/**
	 * 供应分销查看下级代理
	 */
	public String tonextagentview() throws Exception {
		// 取得当前登录人所在的代理商id
		customeragent = this.getLoginUserAgent();

		HttpServletResponse response = ServletActionContext.getResponse();
		if (customeragent.getAgentjibie() == 3
				|| customeragent.getAgentjibie() == 5) {
			PrintWriter out = response.getWriter();
			String strMessage = new String("对不起，您没有下级开户的权限！"
					.getBytes("ISO8859-1"), "utf-8");
			// response.setContentType("text/html;charset=utf-8");
			// response.setCharacterEncoding("utf-8");//防止弹出的信息出现乱码

			out.print("<script>alert('No Right To Vist!');</script>");
			out.flush();
			out.close();
		} else {

			forward = "customeragent.action?parentagentid="
					+ customeragent.getId() + "&s_agentjibie="
					+ (customeragent.getAgentjibie() + 1) + "";
		}
		return "forward";
	}

	/**
	 * 查看供应商或者分销单位信息
	 * 
	 * @throws Exception
	 */
	public String toViewCompanyInfo() throws Exception {
		// 取得当前登录人所在的代理商id
		customeragent = this.getLoginUserAgent();

		HttpServletResponse response = ServletActionContext.getResponse();
		forward = "customeragent!toeditgent.action?s_isview=true&id="
				+ customeragent.getId() + "&compnayid="
				+ customeragent.getParentid();
		return "forward";
	}

	/**
	 * 查看供应商或者分销留点设置
	 * 
	 * @throws Exception
	 */
	public String toViewCompanyLiudian() throws Exception {
		// 取得当前登录人所在的代理商id
		customeragent = this.getLoginUserAgent();

		HttpServletResponse response = ServletActionContext.getResponse();
		forward = "liudianinfo!toadd.action?lagentid=" + customeragent.getId();
		return "forward";
	}

	/**
	 * 分销商或者供应商员工信息管理
	 */
	public String toViewCompEmployee() throws Exception {
		// 取得当前登录人所在的代理商id
		customeragent = this.getLoginUserAgent();

		if (customeragent.getAgenttype() == 2) {
			forward = "customeruser!toSupplyUsersList.action?compnayid="
					+ customeragent.getId();
		} else if (customeragent.getAgenttype() == 3) {
			forward = "customeruser!toDistrUsersList.action?compnayid="
					+ customeragent.getId();
		}
		return "forward";

	}

	/**
	 * 修改个人信息
	 */
	public String toModifyEmployeeInfo() throws Exception {
		// 取得当前登录人所在的代理商id
		customeragent = this.getLoginUserAgent();

		HttpServletResponse response = ServletActionContext.getResponse();
		// 供应商
		if (customeragent.getAgenttype() == 2) {
			forward = "customeruser!toeditgongys.action?s_isview=true&id="
					+ getLoginUserId() + "&compnayid=" + customeragent.getId();
		} else if (customeragent.getAgenttype() == 3)// 分销商
		{
			forward = "customeruser!toeditfxuser.action?s_isview=true&id="
					+ getLoginUserId() + "&compnayid=" + customeragent.getId();
		}
		return "forward";
	}

	// 判断加盟商是否通过审核
	public Boolean isCheckedAgent(long id) {
		Boolean ischecked = false;
		customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(id);
		if (customeragent.getAgentcheckstatus() == 1) {
			ischecked = true;
		}
		return ischecked;
	}
	
	/**
	 * 返回加盟商信息表对象
	 */

	public Object getModel() {
		return customeragent;
	}

	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}

	public Customeragent getCustomeragent() {
		return customeragent;
	}

	public void setCustomeragent(Customeragent customeragent) {
		this.customeragent = customeragent;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Biguser> getListBiguser() {
		return listBiguser;
	}

	public void setListBiguser(List<Biguser> listBiguser) {
		this.listBiguser = listBiguser;
	}

	public List<Customeruser> getListCustomeruser() {
		return listCustomeruser;
	}

	public void setListCustomeruser(List<Customeruser> listCustomeruser) {
		this.listCustomeruser = listCustomeruser;
	}

	public List<Agentroleref> getListAgentroleref() {
		return listAgentroleref;
	}

	public void setListAgentroleref(List<Agentroleref> listAgentroleref) {
		this.listAgentroleref = listAgentroleref;
	}

	public Agentroleref getAgentroleref() {
		return agentroleref;
	}

	public void setAgentroleref(Agentroleref agentroleref) {
		this.agentroleref = agentroleref;
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

	public String getS_passenger() {
		return s_passenger;
	}

	public void setS_passenger(String s_passenger) {
		this.s_passenger = s_passenger;
	}

	public Customeruser getCustomeruser() {
		return customeruser;
	}

	public void setCustomeruser(Customeruser customeruser) {
		this.customeruser = customeruser;
	}

	public String getBigname() {
		return bigname;
	}

	public void setBigname(String bigname) {
		this.bigname = bigname;
	}

	/**
	 * @param agenId
	 * @return 根据大客户ID获得其客户经理
	 */
	public String getCustManagerByAgenId(long agenId) {
		long userid = Server.getInstance().getMemberService()
				.findCustomeragent(agenId).getUserid();
		return Server.getInstance().getMemberService().findCustomeruser(userid)
				.getMembername();
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<Cityairport> getListcityairport() {
		return listcityairport;
	}

	public void setListcityairport(List<Cityairport> listcityairport) {
		this.listcityairport = listcityairport;
	}

	public List<Province> getListprovince() {
		return listprovince;
	}

	public void setListprovince(List<Province> listprovince) {
		this.listprovince = listprovince;
	}

	public long getCompnayid() {
		return compnayid;
	}

	public void setCompnayid(long compnayid) {
		this.compnayid = compnayid;
	}

	public long getParentagentid() {
		return parentagentid;
	}

	public void setParentagentid(long parentagentid) {
		this.parentagentid = parentagentid;
	}

	public int getS_agentjibie() {
		return s_agentjibie;
	}

	public void setS_agentjibie(int s_agentjibie) {
		this.s_agentjibie = s_agentjibie;
	}

	public long getS_provinceid() {
		return s_provinceid;
	}

	public void setS_provinceid(long s_provinceid) {
		this.s_provinceid = s_provinceid;
	}

	public int getS_cityid() {
		return s_cityid;
	}

	public void setS_cityid(int s_cityid) {
		this.s_cityid = s_cityid;
	}

	public Double getS_vmoney() {
		return s_vmoney;
	}

	public void setS_vmoney(Double s_vmoney) {
		this.s_vmoney = s_vmoney;
	}

	public String getS_isview() {
		return s_isview;
	}

	public void setS_isview(String s_isview) {
		this.s_isview = s_isview;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public List<Settlementtype> getListsettle() {
		return listsettle;
	}

	public void setListsettle(List<Settlementtype> listsettle) {
		this.listsettle = listsettle;
	}

	public int getEablestate() {
		return enablestate;
	}

	public void setEablestate(int eablestate) {
		this.enablestate = eablestate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxrow() {
		return maxrow;
	}

	public void setMaxrow(int maxrow) {
		this.maxrow = maxrow;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public String getAgentusernamename() {
		return agentusernamename;
	}

	public void setAgentusernamename(String agentusernamename) {
		this.agentusernamename = agentusernamename;
	}

	public String getAgentlinkname() {
		return agentlinkname;
	}

	public void setAgentlinkname(String agentlinkname) {
		this.agentlinkname = agentlinkname;
	}

	public boolean isAddmoney() {
		return addmoney;
	}

	public void setAddmoney(boolean addmoney) {
		this.addmoney = addmoney;
	}

	public static boolean isVmenable() {
		return vmenable;
	}

	public static void setVmenable(boolean vmenable) {
		CustomeragentAction.vmenable = vmenable;
	}

	public long getHiddenid() {
		return hiddenid;
	}

	public void setHiddenid(long hiddenid) {
		this.hiddenid = hiddenid;
	}

	public String getAgentusernamename_ip() {
		return agentusernamename_ip;
	}

	public void setAgentusernamename_ip(String agentusernamename_ip) {
		this.agentusernamename_ip = agentusernamename_ip;
	}

	public long getHiddenid_ip() {
		return hiddenid_ip;
	}

	public void setHiddenid_ip(long hiddenid_ip) {
		this.hiddenid_ip = hiddenid_ip;
	}

}