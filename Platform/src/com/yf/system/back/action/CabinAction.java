/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.util.PageInfo;

public class CabinAction extends B2b2cbackAction {
	private static final long serialVersionUID = -3763311434279028642L;
	private List<Cabin> listCabin;
	private Cabin cabin = new Cabin();

	// 批量操作ID数组
	private int[] selectid;
	private String c_startdate;
	private String c_enddate;
	
	private String shoujihao;
	private long s_orderid;
	
	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询舱位基础信息表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Cabin.COL_name +" like '%" + s_name.trim()+"%'";
		// }
		if (cabin.getAircompanycode() != null && !"".equals(cabin.getAircompanycode())) {
			where += " and " + Cabin.COL_aircompanycode + " like '%" + cabin.getAircompanycode() + "%'";
		}
		
		if (cabin.getCabincode() != null && !"".equals(cabin.getCabincode() )) {
			where += " and " + Cabin.COL_cabincode + " like '%" + cabin.getCabincode() + "%'";
		}
		
		List list = Server.getInstance().getAirService()
				.findAllCabinForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCabin = list;
		if (pageinfo.getTotalrow() > 0 && listCabin.size() == 0) {
			if (pageinfo.getPagenum() <= 1) {
				pageinfo.setPagenum(1);
			}
			list = Server.getInstance().getAirService()
					.findAllCabinForPageinfo(where, " ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCabin = list;
		}

		return SUCCESS;
	}
	//授权
	public void beizhushoujihao() throws Exception {
		System.out.println("备注手机号");
		Orderinfo orderinfopnr = Server.getInstance().getAirService().findOrderinfo(s_orderid);
		String strReturn = "";
		if (orderinfopnr.getPnr() != null
				&& !orderinfopnr.getPnr().equals("NOPNR")) {
			
			
			
			String sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr(), "", "");
			System.out.println("sub:"+sub);
			String ig="";
			if(sub.indexOf("授权")!=-1){
				ig="back";
				sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr(), "", ig);
			}
			
			String FK="@"; //封口
			String te=	Server.getInstance().getTicketSearchService().commandFunction2("OSI YY CTCT"+shoujihao+"\r"+FK+"", "", ig);
			//Server.getInstance().getTicketSearchService().commandFunction2(FK, "", "");
			System.out.println("TE:"+te);
			String sub2=Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr(), "", ig);
			
			if(te.indexOf("预订酒店指令")!=-1){
				strReturn="ok";
				insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了备注操作!手机号:"+shoujihao.toString());
			}else{
				Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr()+"$IG", "", ig);
				
			}
			System.out.println(strReturn);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strReturn);
			out.print(sb);
			out.flush();
			out.close();
		}
	}
	//授权
	public void valadateispay() throws Exception {
		System.out.println("验证是否有订单未支付");
		String where=" where 1=1 and "+Orderinfo.COL_buyagentid+" ="+getLoginUser().getAgentid()+" AND "+Orderinfo.COL_paystatus+" =0 AND "+Orderinfo.COL_orderstatus+" !=6";
		/*String s_createtime="";
		if (isNotNullOrEpt(s_createtime)) {
			where+=" AND " + Orderinfo.COL_createtime + " = '"
					+ s_createtime + "'";
		}*/
		String ret="0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String startDate = sdf.format(calendar.getTime());
		
		String todaytime = this.getCheckTime(startDate, startDate,
				Orderinfo.COL_createtime);
		if (todaytime != null && todaytime.trim().length() != 0) {// 出票时间
			where+=" AND (" + todaytime + ") ";
		}
		System.out.println(where);
		List list = Server.getInstance().getAirService().findAllOrderinfo(where, " ORDER BY ID DESC ", -1, 0);
		
		if(getLoginUser().getAgentid()==46){
			
			ret="0";
		}else{
			
			ret=list.size()+"";
		}
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(ret);
			out.flush();
			out.close();
		
	}
	public void valadateisquxiao() throws Exception {
		System.out.println("验证多少点的取消");
		String where=" where 1=1 and "+Orderinfo.COL_buyagentid+" ="+getLoginUser().getAgentid()+" AND "+Orderinfo.COL_paystatus+" =0 AND "+Orderinfo.COL_orderstatus+" =6";
		/*String s_createtime="";
		if (isNotNullOrEpt(s_createtime)) {
			where+=" AND " + Orderinfo.COL_createtime + " = '"
					+ s_createtime + "'";
		}*/
		String ret="0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String startDate = sdf.format(calendar.getTime());
		
		String todaytime = this.getCheckTime(startDate, startDate,
				Orderinfo.COL_createtime);
		if (todaytime != null && todaytime.trim().length() != 0) {// 出票时间
			where+=" AND (" + todaytime + ") ";
		}
		System.out.println(where);
		List list = Server.getInstance().getAirService().findAllOrderinfo(where, " ORDER BY ID DESC ", -1, 0);
		
		if(getLoginUser().getAgentid()==46){
			
			ret="0";
		}else{
			
			ret=list.size()+"";
		}
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(ret);
			out.flush();
			out.close();
		
	}
	public void XEPNRinfo() throws Exception {
		
		System.out.println("xepnr");
		Orderinfo orderinfopnr = Server.getInstance().getAirService()
				.findOrderinfo(s_orderid);
		String strReturn = "";
		if (orderinfopnr.getPnr() != null
				&& !orderinfopnr.getPnr().equals("NOPNR")&& !orderinfopnr.getPnr().equals("123456")&& orderinfopnr.getOrdernumber().indexOf("9C")==-1) {
			//insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了取消PNR操作!");
			Orderinforc orderinforc = new Orderinforc();
			orderinforc.setCustomeruserid(getLoginUserId());
			orderinforc.setOrderinfoid(orderinfopnr.getId());
			orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc.setContent(getLoginUser().getLoginname()+"执行了取消PNR操作!");
			orderinforc.setSuouserid(orderinfopnr.getUserid());
			orderinforc.setState(orderinfopnr.getOrderstatus());
			orderinforc.setCustomeruserid(getLoginUserId());
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
			
			strReturn = Server.getInstance().getTicketSearchService().XEPNR(
					orderinfopnr.getPnr());
			System.out.println("strReturn:"+strReturn);
			if(strReturn.indexOf("NO PNR")!=-1){
				strReturn = "";
			}else{
				strReturn = "ok";
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strReturn);
			out.print(sb);
			out.flush();
			out.close();
		}
		/*if(getLoginUser().getAgentid()==46){
			
		}else{
			
			Orderinforc orderinforc = new Orderinforc();
			orderinforc.setCustomeruserid(getLoginUserId());
			orderinforc.setOrderinfoid(orderinfopnr.getId());
			orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc.setContent(getLoginUser().getLoginname()+"执行了取消订单操作!");
			orderinforc.setSuouserid(orderinfopnr.getUserid());
			orderinforc.setState(orderinfopnr.getOrderstatus());
			orderinforc.setCustomeruserid(getLoginUserId());
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strReturn);
			out.print("ok");
			out.flush();
			out.close();
		}*/
		
		
	}
	public void XEPNRinfo222() throws Exception {
		System.out.println("xepnr");
		Orderinfo orderinfopnr = Server.getInstance().getAirService()
				.findOrderinfo(s_orderid);
		String strReturn = "";
		if (orderinfopnr.getPnr() != null
				&& !orderinfopnr.getPnr().equals("NOPNR")) {
			//insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了取消PNR操作!");
			Orderinforc orderinforc = new Orderinforc();
			orderinforc.setCustomeruserid(getLoginUserId());
			orderinforc.setOrderinfoid(orderinfopnr.getId());
			orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc.setContent(getLoginUser().getLoginname()+"执行了取消PNR操作!");
			orderinforc.setSuouserid(orderinfopnr.getUserid());
			orderinforc.setState(orderinfopnr.getOrderstatus());
			orderinforc.setCustomeruserid(getLoginUserId());
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
			
			strReturn = Server.getInstance().getTicketSearchService().XEPNR(
					orderinfopnr.getPnr());
			System.out.println("strReturn:"+strReturn);
			if(strReturn.indexOf("NO PNR")!=-1){
				strReturn = "";
			}else{
				strReturn = "ok";
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strReturn);
			out.print(sb);
			out.flush();
			out.close();
		}
		/*if(getLoginUser().getAgentid()==46){
			
		}else{
			
			Orderinforc orderinforc = new Orderinforc();
			orderinforc.setCustomeruserid(getLoginUserId());
			orderinforc.setOrderinfoid(orderinfopnr.getId());
			orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc.setContent(getLoginUser().getLoginname()+"执行了取消订单操作!");
			orderinforc.setSuouserid(orderinfopnr.getUserid());
			orderinforc.setState(orderinfopnr.getOrderstatus());
			orderinforc.setCustomeruserid(getLoginUserId());
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strReturn);
			out.print("ok");
			out.flush();
			out.close();
		}*/
		
		
	}
	public void insertOrderinforc(Orderinfo orderinfo, String operatedesc) {
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent(operatedesc);
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(orderinfo.getOrderstatus());
		orderinforc.setCustomeruserid(getLoginUserId());
		try {
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 转向到舱位基础信息表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到舱位基础信息表修改页面
	 */
	public String toedit() throws Exception {
		cabin = Server.getInstance().getAirService().findCabin(cabin.getId());
		return EDIT;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=cabin.getLanguage();
		Long uco=cabin.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		cabin = Server.getInstance().getAirService().findCabinbylanguage(cabin.getUcode(),cabin.getLanguage());
		if(cabin==null)
		{
			cabin=new Cabin();
			cabin.setLanguage(lan);
			cabin.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
		}
		return EDIT;
	}
	/**
	 * 转向到舱位基础信息表审核页面
	 */
	public String docheck() throws Exception {
		cabin = Server.getInstance().getAirService().findCabin(cabin.getId());
		if (cabin.getIsenable() == 1) {
			cabin.setIsenable(0);
		} else {
			cabin.setIsenable(1);
		}
		Server.getInstance().getAirService().updateCabinIgnoreNull(cabin);
		return "list2";
	}

	/**
	 * 添加舱位基础信息表
	 */
	public String add() throws Exception {
		cabin.setCreateuser(getLoginUser().getLoginname());
		cabin.setCreatetime(new Timestamp(System.currentTimeMillis()));
		cabin.setModifyuser(getLoginUser().getLoginname());
		cabin.setModifytime(new Timestamp(System.currentTimeMillis()));
		cabin.setStratedate(dateToTimestamp(c_startdate));
		cabin.setEnddate(dateToTimestamp(c_enddate));
		
		Server.getInstance().getAirService().createCabin(cabin);
		return LIST;
	}

	/**
	 * 审核舱位基础信息表
	 */
	public String check() throws Exception {
		cabin.setModifyuser(getLoginUser().getLoginname());
		cabin.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateCabinIgnoreNull(cabin);
		return LIST;
	}

	/**
	 * 编辑舱位基础信息表
	 */
	public String edit() throws Exception {
		cabin.setModifyuser(getLoginUser().getLoginname());
		cabin.setModifytime(new Timestamp(System.currentTimeMillis()));
		cabin.setStratedate(dateToTimestamp(c_startdate));
		cabin.setEnddate(dateToTimestamp(c_enddate));
		
		Server.getInstance().getAirService().updateCabinIgnoreNull(cabin);
		return LIST;
	}

	/**
	 * 删除舱位基础信息表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteCabin(cabin.getId());
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
					Server.getInstance().getAirService().deleteCabin(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回舱位基础信息表对象
	 */

	public Object getModel() {
		return cabin;
	}

	public List<Cabin> getListCabin() {
		return listCabin;
	}

	public void setListCabin(List<Cabin> listCabin) {
		this.listCabin = listCabin;
	}

	public Cabin getCabin() {
		return cabin;
	}

	public void setCabin(Cabin cabin) {
		this.cabin = cabin;
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

	public String getC_startdate() {
		return c_startdate;
	}

	public void setC_startdate(String c_startdate) {
		this.c_startdate = c_startdate;
	}

	public String getC_enddate() {
		return c_enddate;
	}

	public void setC_enddate(String c_enddate) {
		this.c_enddate = c_enddate;
	}
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	public long getS_orderid() {
		return s_orderid;
	}
	public void setS_orderid(long s_orderid) {
		this.s_orderid = s_orderid;
	}

}