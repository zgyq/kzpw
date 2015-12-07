/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class OrderinfoAction2 extends B2b2cbackAction {
	private static final long serialVersionUID = 8908166182297986543L;
	private List<Orderinfo> listOrderinfo=new ArrayList<Orderinfo>();
	private Orderinfo orderinfo = new Orderinfo();
	private List<Passenger> listPassenger = new ArrayList<Passenger>();
	private List<Segmentinfo> listSegment = new ArrayList<Segmentinfo>();
	private List<Cityairport> listCityairport;
	private Customeragent listAgent=new Customeragent();
	private Customeragent listGongAgent=new Customeragent();
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	private String h_ptype;
	private String h_name;
	private String h_idtype;
	private String h_idnumber;
	private String strTravelHtml;
	private String strTotalPriceOne;
	private String strTotalPriceTwo;
	private Integer s_orderstatus;
	private String s_pnr;
	private String s_ordernumber;
	private String s_bengincreatetime;
	private String s_endcreatetime;
	private String s_beginchengji;
	private String s_endchengji;
	private String s_beginprinttime;
	private String s_endprinttime;
	private String s_begincity;
	private String s_endcity;
	private String s_passengername;
	private String s_passengerfet;
	private String s_flightnumber;
	private String u_id;
	private String u_idnumber;
	
	
	
	//pnr
	private String order_pnr;
	private String pnrstr;

	public String getPnrstr() {
		return pnrstr;
	}

	public void setPnrstr(String pnrstr) {
		this.pnrstr = pnrstr;
	}

	public String getOrder_pnr() {
		return order_pnr;
	}

	public void setOrder_pnr(String order_pnr) {
		this.order_pnr = order_pnr;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_idnumber() {
		return u_idnumber;
	}

	public void setU_idnumber(String u_idnumber) {
		this.u_idnumber = u_idnumber;
	}

	public String getS_flightnumber() {
		return s_flightnumber;
	}

	public void setS_flightnumber(String s_flightnumber) {
		this.s_flightnumber = s_flightnumber;
	}

	public String getS_passengername() {
		return s_passengername;
	}

	public void setS_passengername(String s_passengername) {
		this.s_passengername = s_passengername;
	}

	public String getS_passengerfet() {
		return s_passengerfet;
	}

	public void setS_passengerfet(String s_passengerfet) {
		this.s_passengerfet = s_passengerfet;
	}

	public String getS_begincity() {
		return s_begincity;
	}

	public void setS_begincity(String s_begincity) {
		this.s_begincity = s_begincity;
	}

	public String getS_endcity() {
		return s_endcity;
	}

	public void setS_endcity(String s_endcity) {
		this.s_endcity = s_endcity;
	}

	public String getS_beginprinttime() {
		return s_beginprinttime;
	}

	public void setS_beginprinttime(String s_beginprinttime) {
		this.s_beginprinttime = s_beginprinttime;
	}

	public String getS_endprinttime() {
		return s_endprinttime;
	}

	public void setS_endprinttime(String s_endprinttime) {
		this.s_endprinttime = s_endprinttime;
	}

	public String getS_beginchengji() {
		return s_beginchengji;
	}

	public void setS_beginchengji(String s_beginchengji) {
		this.s_beginchengji = s_beginchengji;
	}

	public String getS_endchengji() {
		return s_endchengji;
	}

	public void setS_endchengji(String s_endchengji) {
		this.s_endchengji = s_endchengji;
	}

	public String getS_bengincreatetime() {
		return s_bengincreatetime;
	}

	public void setS_bengincreatetime(String s_bengincreatetime) {
		this.s_bengincreatetime = s_bengincreatetime;
	}

	public String getS_endcreatetime() {
		return s_endcreatetime;
	}

	public void setS_endcreatetime(String s_endcreatetime) {
		this.s_endcreatetime = s_endcreatetime;
	}

	public String getS_ordernumber() {
		return s_ordernumber;
	}

	public void setS_ordernumber(String s_ordernumber) {
		this.s_ordernumber = s_ordernumber;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getS_pnr() {
		return s_pnr;
	}

	public void setS_pnr(String s_pnr) {
		this.s_pnr = s_pnr;
	}

	/**
	 * 列表查询订单信息表
	 */
	public String execute() throws Exception {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 ";
		System.out.println(s_begincity);
		if (s_orderstatus != null) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"+s_flightnumber+"%')";
		}
		System.out.println("sss"+where);
		List list = Server.getInstance().getAirService()
		.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}
		return SUCCESS;
	}
	
	/**
	 * 订单报表
	 */
	public String report() throws Exception {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 ";
		System.out.println(s_begincity);
		if (s_orderstatus != null) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"+s_flightnumber+"%')";
		}
		
		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "=" + user.getAgentid() 
						+ " or " + Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) ";
		}
		
		System.out.println(where);
		listOrderinfo = Server.getInstance().getAirService()
		.findAllOrderinfo(where, " ORDER BY ID DESC",
				-1,0);
		System.out.println(listOrderinfo.size()+"size");
		return "report";
	}
	/**
	 * 转向到订单信息表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到订单信息表修改页面
	 */
	public String toedit() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		return EDIT;
	}

	/**
	 * 转向到订单信息表审核页面
	 */
	public String tocheck() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		return CHECK;
	}

	/**
	 * 转向订单详细信息页面
	 */
	public String toshow() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere="WHERE " + Customeragent.COL_id + " = '"
		+ orderinfo.getBuyagentid() + "'";
		listAgent=(Customeragent)Server.getInstance().getMemberService().findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0).get(0);
		
		String strWhereBuy="WHERE " + Customeragent.COL_id + " = '"
		+ orderinfo.getSaleagentid()+ "'";
		listGongAgent=(Customeragent)Server.getInstance().getMemberService().findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0).get(0);
		return "show";
	}

	/**
	 * 添加订单信息表
	 */
	public String add() throws Exception {

		Long idtemp = 0l;

		// 插入乘机人
		String[] h_ptypes = h_ptype.trim().split(",");
		String[] h_names = h_name.trim().split(",");
		String[] h_idtypes = h_idtype.trim().split(",");
		String[] h_idnumbers = h_idnumber.trim().split(",");
		Passenger passenger;

		// 插入行程单
		Segmentinfo segmentOne = (Segmentinfo) ActionContext.getContext()
				.getSession().get("segmentOne");
		if (segmentOne != null) {
			// 插入订单
			orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
			//分销商员工ID
			orderinfo.setCustomeruserid(getLoginUserId());
			//分销商单位ID
			//分销商单位ID
			Customeruser customeruser=getLoginUser();
			orderinfo.setBuyagentid(customeruser.getAgentid());
			orderinfo.setPnr("00000");
			// 新订单等待支付
			orderinfo.setOrderstatus(0);
			// 订单价格
			String[] strPriceArr = strTotalPriceOne.split(",");
			Float totalairportfee = Float.parseFloat(strPriceArr[2]);
			Float totalfuelfee = Float.parseFloat(strPriceArr[1]);
			Float totalticketprice = Float.parseFloat(strPriceArr[0]);
			// 机建费
			orderinfo.setTotalairportfee(totalairportfee);
			// 燃油费
			orderinfo.setTotalfuelfee(totalfuelfee);
			// 票面价格
			orderinfo.setTotalticketprice(totalticketprice);
			// 订单政策
			if(segmentOne.getZrateid()!=null && segmentOne.getZrateid()>0)
			{
			Zrate zrateinfo=(Zrate)Server.getInstance().getAirService().findAllZrate("WHERE "+Zrate.COL_id+" ='"+segmentOne.getZrateid()+"'", "ORDER BY ID", -1, 0).get(0);
			
			Long lBuyagentID =Long.parseLong(zrateinfo.getAgentcode());
			if(lBuyagentID!=null)
			{
			   orderinfo.setSaleagentid(lBuyagentID); //
			}
			}
			orderinfo.setPolicyid(segmentOne.getZrateid());
			// 支付状态
			orderinfo.setPaystatus(0); // 未支付

			orderinfo = Server.getInstance().getAirService().createOrderinfo(
					orderinfo);
			idtemp = orderinfo.getId();
			orderinfo.setOrdernumber(Server.getInstance().getServiceCenter()
					.getOrderinfoCode(orderinfo));

			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfo);

			segmentOne.setOrderid(orderinfo.getId());
			segmentOne = Server.getInstance().getAirService()
					.createSegmentinfo(segmentOne);
			// 插入乘机人
			for (int i = 0; i < h_ptypes.length; i++) {
				passenger = new Passenger();
				passenger.setPtype(Integer.parseInt(h_ptypes[i]));
				passenger.setName(h_names[i]);
				passenger.setIdtype(Integer.parseInt(h_idtypes[i]));
				passenger.setIdnumber(h_idnumbers[i]);
				passenger.setOrderid(orderinfo.getId());
				passenger.setFet(segmentOne.getId() + "");
				passenger.setFuelprice(segmentOne.getFuelfee());
				passenger.setAirportfee(segmentOne.getAirportfee());
				passenger.setDiscount(segmentOne.getDiscount());
				passenger.setPrice(segmentOne.getPrice());
				passenger.setState(0);
				passenger = Server.getInstance().getAirService()
						.createPassenger(passenger);
				listPassenger.add(passenger);
			}
		}
		Segmentinfo segmentTwo = (Segmentinfo) ActionContext.getContext()
				.getSession().get("segmentTwo");
		if (segmentTwo != null) {
			// 插入订单
			orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinfo.setCustomeruserid(getLoginUserId());
			orderinfo.setRelationorderid(orderinfo.getId());
			// 新订单等待支付
			orderinfo.setOrderstatus(0);
			//分销商单位ID
			Customeruser customeruser=getLoginUser();
			orderinfo.setBuyagentid(customeruser.getAgentid());
			orderinfo.setPnr("00000");
			orderinfo.setId(-1);
			orderinfo.setOrdernumber(null);
			// 订单价格
			String[] strPriceArr = strTotalPriceTwo.split(",");
			Float totalairportfee = Float.parseFloat(strPriceArr[2]);
			Float totalfuelfee = Float.parseFloat(strPriceArr[1]);
			Float totalticketprice = Float.parseFloat(strPriceArr[0]);
			// 机建费
			orderinfo.setTotalairportfee(totalairportfee);
			// 燃油费
			orderinfo.setTotalfuelfee(totalfuelfee);
			// 票面价格
			orderinfo.setTotalticketprice(totalticketprice);
			// 订单政策
			if(segmentOne.getZrateid()!=null && segmentOne.getZrateid()>0)
			{
			Zrate zrateinfo=(Zrate)Server.getInstance().getAirService().findAllZrate("WHERE "+Zrate.COL_id+" ='"+segmentTwo.getZrateid()+"'", "ORDER BY ID", -1, 0).get(0);
			
			Long lBuyagentID =Long.parseLong(zrateinfo.getAgentcode());
			if(lBuyagentID!=null)
			{
				orderinfo.setSaleagentid(lBuyagentID); //
			}
			}
			orderinfo.setPolicyid(segmentTwo.getZrateid());
			orderinfo = Server.getInstance().getAirService().createOrderinfo(
					orderinfo);
			orderinfo.setOrdernumber(Server.getInstance().getServiceCenter()
					.getOrderinfoCode(orderinfo));
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfo);
			// 更变驱程关联id
			Orderinfo orderinfotemp = new Orderinfo();
			orderinfotemp.setId(idtemp);
			orderinfotemp.setRelationorderid(orderinfo.getId());
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfotemp);

			segmentTwo.setOrderid(orderinfo.getId());
			segmentTwo = Server.getInstance().getAirService()
					.createSegmentinfo(segmentTwo);
			// 插入乘机人
			for (int i = 0; i < h_ptypes.length; i++) {
				passenger = new Passenger();
				passenger.setPtype(Integer.parseInt(h_ptypes[i]));
				passenger.setName(h_names[i]);
				passenger.setIdtype(Integer.parseInt(h_idtypes[i]));
				passenger.setIdnumber(h_idnumbers[i]);
				passenger.setOrderid(orderinfo.getId());
				passenger.setFet(segmentTwo.getId() + "");
				passenger.setFuelprice(segmentOne.getFuelfee());
				passenger.setAirportfee(segmentOne.getAirportfee());
				passenger.setDiscount(segmentOne.getDiscount());
				passenger.setPrice(segmentOne.getPrice());
				passenger.setState(0);
				passenger = Server.getInstance().getAirService()
						.createPassenger(passenger);
				listPassenger.add(passenger);
			}
		}

		return "ticketorderinfo";
	}

	public String ordersubmit() {
		// 已提交
		orderinfo.setOrderstatus(1);
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		String where = " where 1=1 ";
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}
		return SUCCESS;
	}

	/**
	 * 审核订单信息表
	 */
	public String check() throws Exception {

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		return LIST;
	}

	/**
	 * 编辑订单信息表
	 */
	public String edit() throws Exception {

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		String[] typeid = u_id.trim().split(",");
		String[] typeidnumber = u_idnumber.trim().split(",");
		Passenger passenger=null;
		for(int i=0;i<typeid.length;i++)
		{
			passenger=new Passenger();
			passenger.setId(Integer.parseInt(typeid[i].trim()));
			passenger.setIdnumber(typeidnumber[i].trim());
			Server.getInstance().getAirService().updatePassengerIgnoreNull(passenger);
		}
		return LIST;
	}

	/**
	 * 删除订单信息表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteOrderinfo(orderinfo.getId());
		return LIST;
	}
	
	/**
	 * 订单状态修改
	 */
	public String orderstatusedit() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.QUXIAO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_转向支付页面
	 */
	public String orderstatustozhifu() throws Exception{
		
	//	orderinfo.setOrderstatus(orderinfo.QUXIAO);
		
		
	//	Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return "tozhifu";
	}
	/**
	 * 订单状态修改_支付
	 */
	public String orderstatuszhifu() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.YIFUKUANCHUPIAO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_出票
	 */
	public String orderstatuschupiao() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.YICHUPIAO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_退票_等待审核
	 */
	public String orderstatustuipiao() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.TUIPIAODINGDANDAISHENHE);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_退票_审核通过
	 */
	public String orderstatustuipiaotongguo() throws Exception{
		
		
		orderinfo.setOrderstatus(orderinfo.TUIPIAOSHENHETONGGUO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_退票_审核不通过
	 */
	public String orderstatustuipiaobutongguo() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.TUIPIAOSHENHEBUTONGGUOJIESHU);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_费票_审核通过
	 */
	public String orderstatusfeipiaotongguo() throws Exception{
		
		
		orderinfo.setOrderstatus(orderinfo.FEIPIAOSHENHETONGGUO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_费票_审核不通过
	 */
	public String orderstatusfeipiaobutongguo() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.FEIPIAOSHENHEBUTONGGUO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_废票_等待审核
	 */
	public String orderstatusfeipiao() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.FEIPIAODAISHENHE);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_已经出票_申请改签
	 */
	public String orderstatusshenqinggaiqian() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.GAIQIAN);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_改签_审核通过
	 */
	public String orderstatusgaiqiantongguo() throws Exception{
		
		
		orderinfo.setOrderstatus(orderinfo.GAIQIANSHEHETONGGUO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_改签_审核不通过
	 */
	public String orderstatusgaiqianbutongguo() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.GAIQIANBUTONGGUO);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_改签_已经付款
	 */
	public String orderstatusyifukuan() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.YIFUKUANJIEGUA);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_解挂
	 */
	public String orderstatusjiegua() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.YIJIEGUAJIESHU);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		return LIST;
	}
	/**
	 * 订单状态修改_暂时不能出票
	 */
	public String orderstatusbunengchupiao() throws Exception{
		
		orderinfo.setOrderstatus(orderinfo.BUNENGCHUPIAODENGDAICHULI);
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
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
					Server.getInstance().getAirService().deleteOrderinfo(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 根据订单ID获取行程数据
	 * 
	 * @param orderId
	 * @return
	 */
	public Segmentinfo getSegmentinfo(long orderId) {
		String where = "where " + Segmentinfo.COL_orderid + "=" + orderId;
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 根据机场代码获取城市名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getCitynameByAirport(String airport) {
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getCityname() : "";

	}

	public String getPassengerNamehtml(Long orderid) {
		String html = "";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_orderid + "="
								+ orderid, "", -1, 0);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {
				html += list.get(i).getName() + "<br/>";
			}
			html += list.get(list.size() - 1).getName();
		}
		return html;
	}

	public String getPassengerFEThtml(Long orderid) {
		String html = "";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_orderid + "="
								+ orderid, "", -1, 0);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {
				html += list.get(i).getFet() + "<br/>";
			}
			html += list.get(list.size() - 1).getFet();
		}
		return html;
	}
	/**
	 * 通过pnr跳转到预订页面
	 * @param pnr
	 * @return
	 */
	public String toCreateOrderByPnr()
	{
		List list=Server.getInstance().getTicketSearchService().getOrderbypnr(order_pnr);
		if(list!=null&&list.size()==4)
		{
			try{
			pnrstr=(String) list.get(0);
			listSegment=(List<Segmentinfo>) list.get(1);
			listOrderinfo=(List<Orderinfo>) list.get(2);
			listPassenger=(List<Passenger>) list.get(3);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("接口服务返回pnr信息错误"+e.toString());
			}
		}
		return "orderbypnr";
	}
	/**
	 * 通过pnr预订界面创建订单
	 * @param pnr
	 * @return
	 */
	public String createOrderByPnr()
	{
		return "";
	}
	public String getPassTypeToString(Integer id) {
		switch (id) {
		case 0:
			return "成人";
		case 2:
			return "儿童";
		case 3:
			return "婴儿";
		default:
			return "未知类型";
		}
	}
	
	public String getPayMethod(Integer id)
	{
		switch (id){
		case 0:
			return "未支付";
		case 1:
			return "已支付";
		default:
			return "未支付";
		}
	}

	public String getIDTypeToString(Integer id) {
		switch (id) {
		case 1:
			return "身份证";
		case 2:
			return "护照";
		case 6:
			return "其他";
		default:
			return "其他";
		}
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
	 * 获取待出票订单数量
	 * @return
	 */
	public String getOrderinfoCount() {
		int count = 0;
		String where = " where 1=1 ";
		where += " and " + Orderinfo.COL_orderstatus + "=" + 2;
		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "=" + user.getAgentid() 
						+ " or " + Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) ";
		}
		listOrderinfo = Server.getInstance().getAirService().findAllOrderinfo(where, "ORDER BY ID", -1, 0);
		if (listOrderinfo != null && listOrderinfo.size() > 0) {
			count = listOrderinfo.size();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		out.flush();
		out.close();
		return SUCCESS;
	}

	/**
	 * 返回订单信息表对象
	 */

	public Object getModel() {
		return orderinfo;
	}

	public List<Orderinfo> getListOrderinfo() {
		return listOrderinfo;
	}

	public void setListOrderinfo(List<Orderinfo> listOrderinfo) {
		this.listOrderinfo = listOrderinfo;
	}

	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
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

	public String getH_ptype() {
		return h_ptype;
	}

	public void setH_ptype(String h_ptype) {
		this.h_ptype = h_ptype;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getH_idtype() {
		return h_idtype;
	}

	public void setH_idtype(String h_idtype) {
		this.h_idtype = h_idtype;
	}

	public String getH_idnumber() {
		return h_idnumber;
	}

	public void setH_idnumber(String h_idnumber) {
		this.h_idnumber = h_idnumber;
	}

	public List<Passenger> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public String getStrTravelHtml() {
		return strTravelHtml;
	}

	public void setStrTravelHtml(String strTravelHtml) {
		this.strTravelHtml = strTravelHtml;
	}

	public List<Segmentinfo> getListSegmentinfo() {
		return listSegment;
	}

	public void setSegmentinfo(List<Segmentinfo> listSegment) {
		this.listSegment = listSegment;
	}

	public String getStrTotalPriceOne() {
		return strTotalPriceOne;
	}

	public void setStrTotalPriceOne(String strTotalPriceOne) {
		this.strTotalPriceOne = strTotalPriceOne;
	}

	public String getStrTotalPriceTwo() {
		return strTotalPriceTwo;
	}

	public void setStrTotalPriceTwo(String strTotalPriceTwo) {
		this.strTotalPriceTwo = strTotalPriceTwo;
	}

	public Integer getS_orderstatus() {
		return s_orderstatus;
	}

	public void setS_orderstatus(Integer s_orderstatus) {
		this.s_orderstatus = s_orderstatus;
	}

	public List<Cityairport> getListCityairport() {
		return listCityairport;
	}

	public void setListCityairport(List<Cityairport> listCityairport) {
		this.listCityairport = listCityairport;
	}

	public List<Segmentinfo> getListSegment() {
		return listSegment;
	}

	public void setListSegment(List<Segmentinfo> listSegment) {
		this.listSegment = listSegment;
	}

	public Customeragent getListAgent() {
		return listAgent;
	}

	public void setListAgent(Customeragent listAgent) {
		this.listAgent = listAgent;
	}

	public Customeragent getListGongAgent() {
		return listGongAgent;
	}

	public void setListGongAgent(Customeragent listGongAgent) {
		this.listGongAgent = listGongAgent;
	}

	

}