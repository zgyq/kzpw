/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.yf.system.back.server.Server;
import com.yf.system.bak.excel.HthyWorkSheet;
import com.yf.system.bak.excel.HthyWritableWorkBook;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.miscellaneous.MiscellaneousBean;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class AirreportAction extends B2b2cbackAction {
	// private List list;;
	private List<Orderinfo> listorderinfo;
	private String filedname = "";
	private List listPassenger = new ArrayList();
	private List<Aircompany> listAircompany;
	private List<Department> deptlist;
	private List<Customeragent> cusagentlist;
	private String strMonth;
	private String strStartDate;
	private String strEndDate;

	private String departname;
	private List listbigreport = new ArrayList();// 大客户报表
	private List<Department> listDepartment;

	private List<Map> biguserqkmaplist = new ArrayList<Map>();
	private List<Map> grgzqkmaplist = new ArrayList<Map>();
	private int ordercount = 0;// 订单数
	private int ticketcount = 0;// 订单数
	private float pricegather;// 票价小计
	private float dutygather;// 税小计。
	private float tuifeegather;// 手续费小计
	private float insurfeegather;// baox小计
	private String treestr="";
	private int state = 0;
	private String stime;
	private String etime;
	private String username;
	// 开始时间和结束时间
	private String piaohao;// 票号
	private String s_begintime;// 出票时间
	private String s_endtime;
	private String orderstime;// 预订时间
	private String orderetime;
	private String t_begintime;// 退票时间
	private String t_endtime;
	private String f_begintime;// 废票时间
	private String f_endtime;
	private String h_begintime;// 还款时间
	private String h_endtime;

	private String sqname;// 申请退废人
	private String shname;// 审核退废人
	private String tkname;// 退款退废人
	private String sq_begintime;// 申请时间
	private String sq_endtime;
	private String sh_begintime;// 审核时间
	private String sh_endtime;
	private String tk_begintime;// 退款时间
	private String tk_endtime;

	private String s_ticketname;// 乘机人姓名
	private String s_linkname;// 联系人姓名
	private String s_airline;// 航班号、
	private String s_chuname;// 出票人姓名
	private String s_tfname;// 退费票审核人姓名

	private String s_tuibegindate;// 退票开始时间
	private String s_tuienddate; // 退票结束时间
	private String s_tuitype;// 退票类型
	private int s_type = -1;// 用于返佣业务类型‘
	private String s_pnr; // PNR
	private String flight_begintime;// 航班日期
	private String flight_endtime;

	private String s_department;// 部门
	private String s_createuser;// 创建人

	private String s_sendname;// 配送人
	private String s_shouyinname;// 收银人
	private String send_begintime;// 配送时间
	private String send_endtime;
	private String shou_begintime;// 收银时间
	private String shou_endtime;

	private String s_gzname;

	private String s_airname;// 航空公司名字

	private String s_ordername;// 预订人----对应orderinfo的saleagentid

	private List<Tickettype> listtickettype;

	private long tickettype = 0;

	private int insurtype = -1;// 出票状态 默认已收银

	private int s_paymethod = -1; // 支付方式
	private int fkmethod = -1;// 付款方式
	private int fkstate = 0;// 是否付款

	private int custype = -1;// 客户类型

	private List<Orderinfo> listorderinfos = new ArrayList<Orderinfo>();// 电子客票明细报表

	private List listrebaterecord;

	private String s_ordernum;// 订单号

	private String s_flight;// 航班

	private String s_cabin;// 舱位

	private int tftype = 0;// 退废状态

	private int tfstate;// 退废类型

	private List datefeilist = new ArrayList();// 当日退费票
	private Map<String, String> priceSubtotal;// 费用小计

	private String notoday;
	private String ispersonalqk;

	private String is_first;

	private String clientmanger;// 客户经理

	private int s_internal = -1;// 类型

	private String is_tfticket;

	private Customeragent customeragent = new Customeragent();

	
	private List<Customeragent> ListCustomeragent;
	
	private String agentname;
	private long parentid=46;
	
	
	private void toToday() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		Date enddate = new Date();
		enddate.setDate(enddate.getDate());
		enddate.setHours(23);
		enddate.setMinutes(59);
		enddate.setSeconds(59);
		s_begintime = dateFormat.format(date);
		s_endtime = dateFormat.format(enddate);

	}

	private void toTodayoftk() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// date.setHours(0);
		// date.setMinutes(0);
		// date.setSeconds(0);
		Date enddate = new Date();
		enddate.setDate(enddate.getDate());
		// enddate.setHours(23);
		// enddate.setMinutes(59);
		// enddate.setSeconds(59);
		tk_begintime = dateFormat.format(date);
		tk_endtime = dateFormat.format(enddate);
		strStartDate = dateFormat.format(date);
		strEndDate = dateFormat.format(enddate);

	}

	private void toMonth() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date date = new Date();
		strMonth = dateFormat.format(date);
	}

	private void toTodayofShouyin() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		Date enddate = new Date();
		enddate.setDate(enddate.getDate());
		enddate.setHours(23);
		enddate.setMinutes(59);
		enddate.setSeconds(59);
		this.shou_begintime = dateFormat.format(date);
		this.shou_endtime = dateFormat.format(enddate);
	}
	public String getAgentNameBYid(long id) {
		String ret="";
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(id);
		if(customeragent.getAgentshortname()!=null){
			ret=customeragent.getAgentshortname();
		}else{
			
			ret=customeragent.getAgentcompanyname();
		}
		
		return ret;
	}
	public String getContentitemName(long id) {
		return Server.getInstance().getMemberService().findDepartment(id)
				.getName();
	}

	public String getContentitemName(String id) {
		if (id.equals("-1")) {
			return "----所有---";
		} else if (id.indexOf("company") >= 0) {
			return Server.getInstance().getMemberService().findCustomeragent(
					Long.parseLong(id.replace("company", "")))
					.getAgentcompanyname();
		} else {
			return Server.getInstance().getMemberService().findDepartment(
					Long.parseLong(id)).getName();
		}
	}
	
	
	public String toagent(){
		String where=" WHERE 1=1 AND "+Customeragent.COL_agenttype+" =3";
		if(getLoginUser().getAgentid()!=46){
			parentid=getLoginUser().getAgentid();
		}
		where +=" AND "+Customeragent.COL_parentid+" ="+parentid;
		
		if(username!=null&&username.length()>0){
			
			where +=" AND ( "+Customeragent.COL_agentcompanyname+" like '%" + username.trim()+"%' OR "+Customeragent.COL_agentcompanyname+" like '%" + username.trim()+"%')";
		}
		//ListCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(where, " ORDER BY ID DESC ", -1, 0);	
		
		List list = Server.getInstance().getMemberService()
		.findAllCustomeragentForPageinfo(where, " ORDER BY ID ",
				pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		ListCustomeragent = list;
		if (pageinfo.getTotalrow() > 0 && ListCustomeragent.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllCustomeragentForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			ListCustomeragent = list;
}
		
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String agentroot = new CustomeragentAction().getAgentRoot();
		//request.setAttribute("agentroot", agentroot);
		
		if(getLoginUser().getAgentid()==46){
		getString(46);
		}else{
			
		getString(getLoginUser().getAgentid());	
		}
		//System.out.println("???"+treestr);
		
		return "agent";
	}
	
	private void getString(long id){
		List<  Customeragent  > list = Server.getInstance().getMemberService().findAllCustomeragent("where "+Customeragent.COL_parentid+" ="+id+" and "+Customeragent.COL_agenttype+" =3" ," ORDER BY ID DESC ",20,0);
		if(!list.isEmpty()){
		
			for(Customeragent m :list){
				String agname="";
				if(m.getAgentshortname()!=null){
					agname=m.getAgentshortname();
				}else{
					agname=m.getAgentcompanyname();
				}
				if(id==getLoginUser().getAgentid()){
					
					
					treestr+="var sub_"+ m.getId() 
						+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"',  text:'"+ agname +"'});\n";
					
					treestr+="root.appendChild(sub_"+ m.getId() +");\n";
				}else{
					treestr+="var sub_"+ m.getId() 
					+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"', text:'"+ agname +"'});\n";
			
					treestr+="sub_"+ id +".appendChild(sub_"+ m.getId() +");\n";
				
				}
				getString(m.getId());
			}
		}
	}
	
	public List<Object> getOrderhtmlByAgent(long id){
		List<Object> lists = new ArrayList<Object>();
		int ordersize=0;
		int passsize=0;
		Float orderprice=0f;
		String sql=" WHERE 1=1 AND "+Orderinfo.COL_buyagentid+" ="+id+" AND "+Orderinfo.COL_orderstatus+" =3";
		//String sql=" WHERE 1=1 ";
		//int ordersize=Server.getInstance().getAirService().countOrderinfoBySql(sql);
		//lists.add(ordersize);
		
		String sqlpa=" WHERE 1=1 AND "+Passenger.COL_orderid+" IN ( SELECT "+Orderinfo.COL_id+" FROM "+Orderinfo.TABLE+" WHERE "+Orderinfo.COL_buyagentid+" ="+id+" AND "+Orderinfo.COL_orderstatus+" =3)";
		String pa="select count(ID) as panum FROM T_PASSENGER "+sqlpa;
		
		List list=Server.getInstance().getSystemService().findMapResultBySql(pa, null);
		
		if(list.size()>0){
			
			for(int p=0;p<list.size();p++){
				Map map=(Map) list.get(p);
				
				 if(map!=null&&map.size()>0){
					 passsize=Integer.parseInt(map.get("panum").toString());
					 
				 }
				
			}
		}
		
		String sqlprice="select count(ID) as ordernum ,sum(C_TOTALAIRPORTFEE+C_TOTALFUELFEE+C_TOTALTICKETPRICE) as orderprice FROM T_ORDERINFO "+sql;
		datefeilist=Server.getInstance().getSystemService().findMapResultBySql(sqlprice, null);
		
		
		
		for(int a=0;a<datefeilist.size();a++){
			 Map map=(Map) datefeilist.get(a);
			 if(map!=null&&map.size()>0){
				 ordersize=Integer.parseInt(map.get("ordernum").toString());
				 if(map.get("orderprice")!=null&&!map.get("orderprice").toString().equals("NULL")){
					 orderprice=Float.parseFloat(map.get("orderprice").toString()); 
				 }
				 
			 }
			
			}

		lists.add(ordersize);
		lists.add(passsize);
		lists.add(orderprice);
		
		//System.out.println(lists);
		return lists;
	}
	
	public String lirun(){
		// 非第一次进入
		if (is_first != null) {
			
			Customeragent longinagent = this.getLoginsessionagent();
			System.out.println(longinagent.getAgenttype());
			HttpServletRequest request = ServletActionContext.getRequest();
			long agid = this.customeragent.getId();
			StringBuilder where = new StringBuilder(" where 1=1 ");
			tftype=3;
			if (tftype > 0) {

				where.append("  AND C_ORDERSTATUS =" + tftype);
			} else {

			/*	where
						.append("  AND C_ORDERSTATUS >2 AND C_ORDERSTATUS NOT IN(6,9,16,18,19,27) ");*/
				where
				.append("  AND C_ORDERSTATUS =3 ");
			}
			if (longinagent.getAgenttype() != 2) {
				if (agid!=0) {					
					if (agid < 0) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
										+ (0 - agid));
						if (longinagent.getAgenttype() != 1) {
							where
									.append("  AND  charindex(','+CONVERT(nvarchar,"
											+ longinagent.getId()
											+ ")+',',','+C_PARENTSTR+',')> 0 ");
						}
						where.append(")");
					} else {
						where.append(" AND C_BUYAGENTID=" + agid);
					}
				} else {
					if (longinagent.getAgenttype() != 1) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
										+ longinagent.getId()
										+ "  OR  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
					}
				}
			} else {
				where.append(" AND " + Orderinfo.COL_policyagentid + "="
						+ longinagent.getId());

			}
			
			if (isNotNullOrEpt(this.s_ordernum)) {
				where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
			}
			if (!isNullorSpace(s_ordername)) {// 预订人
				where
						.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_ordername + "%')");
			}
			if (!isNullorSpace(s_chuname)) {// 出票人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_chuname + "%' ) )");
			}
			String cptime = this.getCheckTime(s_begintime, s_endtime,
					"C_PRINTTIME");// 出票时间
			if (cptime.length() > 0) {
				where.append(" AND (" + cptime + ") ");

			}
			String ydtime = this.getCheckTime(orderstime, orderetime,
					Orderinfo.COL_createtime);// 预订时间
			if (ydtime.length() > 0) {
				where.append(" AND (" + ydtime + ") ");

			}
			if (!isNullorSpace(s_shouyinname)) {// 收银人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_shouyinname + "%' ) AND C_STATE  =10 )");
			}
			String shoutime = this.getCheckTime(this.shou_begintime,
					this.shou_endtime, "C_CREATETIME");
			if (shoutime.length() > 0) {// 收银时间
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
								+ shoutime + ") )");
			}
			if (!this.isNullorSpace(sqname)) {// 申请人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ sqname + "%' ) AND C_STATE IN (4,5) )");
			}
			String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
					"C_CREATETIME");// 申请时间
			if (sqtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
								+ sqtime + "))");
			}
			if (!this.isNullorSpace(shname)) {// 审核人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
			}
			String shtime = this.getCheckTime(sh_begintime, sh_endtime,
					"C_CREATETIME");// 审核时间
			if (shtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
								+ shtime + "))");
			}
			if (!this.isNullorSpace(tkname)) {// 退款人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ tkname + "%' ) AND C_STATE IN (9,18) )");
			}
			String tktime = this.getCheckTime(tk_begintime, tk_endtime,
					"C_CREATETIME");// 退款时间
			if (tktime.length() > 0) {
				where
						.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
								+ tktime + "))");
			}
			if (!isNullorSpace(piaohao)) {// 票号

				where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
			}
			if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

				where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
			}
			String flitime = this.getCheckTime(this.flight_begintime, "",
					Segmentinfo.COL_departtime);
			if (flitime.length() > 0) {// 航班日期
				where
						.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
								+ flitime + ")");
			}
			if (!isNullorSpace(s_pnr)) {// PNR
				where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
						+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
			}
			if (!isNullorSpace(s_airname)) {// 航空公司

				where.append(" AND AIRNAME LIKE '%" + s_airname + "%'");
			}
			if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
				where.append(" AND C_CABINCODE = '" + s_cabin + "'");
			}

			

			System.out.println("chupiaoReport:" + where);
	
			List list=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID DESC ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listorderinfo = list;
			if (pageinfo.getTotalrow() > 0 && listorderinfo.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID DESC ", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listorderinfo = list;
			}
			
		}
		return "lirun";
	}

	public List getPassengerNamehtml(Long orderid) {
		List<String> lists = new ArrayList<String>();
		String html = "";
		String ticketnum="";
		String agentname="";
		String fnum="";
		String stime="";
		String xingcheng="";
		String piaomianjia="";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_orderid + "="
								+ orderid + " AND C_STATE<>12", "", -1, 0);
		List<Passenger> newlist = Server.getInstance().getAirService()
		.findAllPassenger(
				"WHERE 1=1 AND " + Passenger.COL_orderid + "="
						+ orderid + " AND C_STATE<>12 and "+Passenger.COL_ptype+" =1", "", -1, 0);
		
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {
				
				String pastate="已出票";
				String lodstate="("+pastate+")";
				if(list.get(i).getState()==4){
					pastate="退票";
					lodstate="<span style='color: red'>("+pastate+")</span>";
				}
				if(list.get(i).getState()==5){
					pastate="废票";
					lodstate="<span style='color: red'>("+pastate+")</span>";
				}
				if(list.get(i).getState()==6){
					pastate="改签";
					lodstate="<span style='color: red'>("+pastate+")</span>";
				}
				
				
				
				html += list.get(i).getName()+lodstate + "<br/>";
				ticketnum +=list.get(i).getTicketnum() + "<br/>";
				
			}
			
			String pastate="已出票";
			String lodstate="("+pastate+")";
			if(list.get(list.size() - 1).getState()==4){
				pastate="退票";
				lodstate="<span style='color: red'>("+pastate+")</span>";
			}
			if(list.get(list.size() - 1).getState()==5){
				pastate="废票";
				lodstate="<span style='color: red'>("+pastate+")</span>";
			}
			if(list.get(list.size() - 1).getState()==6){
				pastate="改签";
				lodstate="<span style='color: red'>("+pastate+")</span>";
			}
			
			html += list.get(list.size() - 1).getName()+lodstate;
			ticketnum +=list.get(list.size() - 1).getTicketnum() + "<br/>";
		}
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(orderid);
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
		List<Segmentinfo>listSegmentinfo=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
		List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" where 1=1 and "+Passenger.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
		agentname=customeragent.getAgentcompanyname();
		fnum=listSegmentinfo.get(0).getFlightnumber();
		stime=listSegmentinfo.get(0).getDeparttime()+"";
		xingcheng=getCitynameByAirport(listSegmentinfo.get(0).getStartairport())+"-"+getCitynameByAirport(listSegmentinfo.get(0).getEndairport());
		piaomianjia=listSegmentinfo.get(0).getParvalue()+"";
		
		//计算返利开始
		String fanli="";
		
		Float zratevalue=orderinfo.getRatevalue();
		Float agentvalue=orderinfo.getFenxiaoshangfandian();
		
		Float pvalue=listSegmentinfo.get(0).getParvalue();//票面价
		Float Yprice=listSegmentinfo.get(0).getYprice();//Y价格
		
		Float price=0f;
		Float shuifei=0f;
		Float baoxian=0f;
		for(int a=0;a<listpass.size();a++){
			Passenger passenger=listpass.get(a);
			if(passenger.getPtype()==1){//成人
				price+=pvalue;
			}
			if(passenger.getPtype()==2){//儿童
				
				
				if (listSegmentinfo.get(0).getDiscount() > 100) {
					
					price+=getRoundPrice(pvalue, 2);
					
				} else {
					
					price+=getRoundPrice(Yprice, 2);
				
				}
				
			}
			if(passenger.getPtype()==3){//婴儿
				
				// 儿童婴儿价
				if (listSegmentinfo.get(0).getDiscount() > 100) {
					price+=getRoundPrice(pvalue, 10);
					
				} else {
					price+=getRoundPrice(Yprice, 10);
					
				}
				
			}
			price+=passenger.getFuelprice();
			price+=passenger.getAirportfee();
			
		
			shuifei+=passenger.getFuelprice();
			shuifei+=passenger.getAirportfee();
			baoxian+=passenger.getInsurprice();
			
		}
		
		Float retprice=	price-(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice());	
		
		fanli=retprice+"";
		//计算结束
		
		
		
		
		lists.add(html);//乘机人 0
		lists.add(ticketnum);//票号 1
		lists.add(agentname);// 加盟商名字 2
		lists.add(fnum);//航班号 3
		lists.add(stime);// 出发时间 4
		lists.add(xingcheng);//行程 5
		lists.add(piaomianjia);//票面价 6
		lists.add(fanli);// 返利 7
		lists.add(shuifei+"");// 税费 8
		lists.add(baoxian+"");// 保险 9
		lists.add(price+"");// 总票面价 10
		lists.add(listpass.size()+"");// 总人数 11
		lists.add(listSegmentinfo.get(0).getDiscount()+"");// 折扣 12
		System.out.println("lists:"+lists);
		
		return lists;
	}
	public Float formatFlot(String price){
		
		return Float.parseFloat(price);
	}
	/**
	 * @return
	 * @throws Exception
	 *             大客户报表
	 */
	private String qkhzwhere = "";
	private String qkhzmwhere = "";

	public String todakehu() throws Exception {
		if (!isExp) {
			String ticketwhere = " WHERE 1=1 ";
			listtickettype = Server.getInstance().getMemberService()
					.findAllTickettype(ticketwhere, "", -1, 0);
			String menuwhere = "";
			/*
			 * String menuwhere = " where 1=1 AND C_AGENTISENABLE=1 and
			 * C_AGENTCHECKSTATUS=1 AND " + Customeragent.COL_userid + " =" +
			 * getLoginUserId();// 客户经理
			 */
			if (isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
				menuwhere = " WHERE 1=1  AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
			}
			List<Customeragent> listCustomeragent = Server.getInstance()
					.getMemberService().findAllCustomeragent(menuwhere, "", -1,
							0);
			long[] longarry = new long[listCustomeragent.size()];
			int i = 0;
			for (Customeragent agent : listCustomeragent) {
				longarry[i] = agent.getId();
				i++;
			}
			if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
				longarry = new long[1];
				longarry[0] = this.getLoginUser().getAgentid();
			}
			// this.getDepttreestr(3l, longarry, true);
		}
		if (is_first != null) {
			String sql = " SELECT ID, C_ORDERID,C_INTERNAL, C_CUSTOMERAGENTID,C_ORDERNUMBER,C_TICKETNUM,C_FET, C_NAME,C_FENXIAOSHANGFANDIAN,"
					+ "C_PRICE,ISNULL(C_AIRPORTFEE,0)+ISNULL(C_FUELPRICE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0) AS DUTY,C_TUIFEE,ISNULL(C_INSURANCEFEE,0) AS INSURFEE ,(SELECT C_TYPENAME FROM T_TICKETTYPE T WHERE T.ID=v.C_TICKETTYPEID) AS TICKETTYPE,"
					+ "C_PRINTTIME,C_CUSTOMERUSERID,C_STATE,C_INSURANCE,C_HKSTATE ,C_YIHAI,ISNULL(C_HAIQIAN,0) AS HAIQIAN,C_MEMO ,"
					+ "YPRICE,"
					+ "AIRDISCOUNT as DISCOUNT,"
					+ "AIRSAIL as citypair,"
					+ "AIRCABINCODE as cabincode,"
					+ "AIRTIME as DEPARTDATE,"
					+ "AIRFLIGHTNUMBER AS hangbanhao,"
					+ "AIRCOMPANY  as hangkonggongsi, "
					+ "dbo.F_GetAgentName(C_CUSTOMERUSERID,C_CUSTOMERAGENTID) AS AGENTNAME "
					+ "FROM view_pas_order_seng v WHERE 1=1 ";
			if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
				sql += " AND " + Orderinfo.COL_buyagentid + "="
						+ getLoginUser().getAgentid();
			}

			if (s_department != null && s_department.trim().length() > 0
					&& !s_department.equals("-1")) {// 部门
				if (s_department.indexOf("c") >= 0) {
					long agentid = Long.valueOf(s_department.substring(1));
					departname = Server.getInstance().getMemberService()
							.findCustomeragent(agentid).getAgentcompanyname();
					// String deptidlist = super.getAllDeptIdByAgentId(agentid);
					sql += " AND C_CUSTOMERAGENTID IN(" + agentid + ")";
					qkhzwhere = " AND C_CUSTOMERAGENTID IN(" + agentid + ")";
					qkhzmwhere = " AND " + MiscellaneousBean.COL_groupuserid
							+ " IN (" + agentid + ")";

				} else {
					long deptid = Long.valueOf(s_department.substring(0,
							s_department.indexOf("@")));
					this.departname = Server.getInstance().getMemberService()
							.findDepartment(deptid).getName();
					String deptidlist = super.getSubDetpt(deptid);
					sql += " AND "
							+ Passenger.COL_orderid
							+ " IN (SELECT "
							+ Orderinfo.COL_id
							+ " From "
							+ Orderinfo.TABLE
							+ " WHERE "
							+ Orderinfo.COL_customeruserid// 订单所属会员
							+ ""
							+ " IN ( SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID IN ("
							+ deptidlist + " ) )) ";
					qkhzwhere = " AND "
							+ Orderinfo.COL_customeruserid
							+ " IN(SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID IN ("
							+ deptidlist + " ) )";
					qkhzmwhere = " AND " + MiscellaneousBean.COL_department
							+ " IN (" + deptidlist + ")";
				}

			} else {
				sql += " AND  C_CUSTOMERAGENTID IN(SELECT ID FROM T_CUSTOMERAGENT WHERE C_BIGTYPE=1)";
			}
			// 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.废票退款成功10.订单关闭
			// 11.已经废票12.已经退票13.申请改签14.已经改签15,改签失败，16，暂不能出票，17，退票不成功 18
			// "退票退款成功";
			// 19:"问题订单"; 23:n "申请升舱"; 24: "已换开";
			// 25: "升舱换开成功"; 26: "升舱失败"; 27: "待确认"; 28: "在途订单"; 29: "待收银"; 30:
			// "申请换开";defalut "新订单";
			if (this.insurtype >= 0) {
				if (insurtype == 3) {// 出票状态1：已出票，根据东航要求，已出票在这里包含申请状态票....
					sql += " AND " + Orderinfo.COL_orderstatus
							+ " NOT IN (2,9,11,12,16,18,27)";
				} else if (insurtype == 10) {// 已收银
					sql += " AND " + Orderinfo.COL_orderstatus
							+ " NOT IN (9,11,12,18) AND C_CASHIER =1";
				} else if (insurtype == 2) {// 未出票
					sql += " AND " + Orderinfo.COL_orderstatus + " IN (2,27)";
				} else if (insurtype == 11) {// 废票
					sql += " AND " + Orderinfo.COL_orderstatus + " IN (11,9)";

				} else if (insurtype == 12) {// 退票
					sql += " AND " + Orderinfo.COL_orderstatus + " IN (12,18)";
				} else {
					sql += " AND " + Orderinfo.COL_orderstatus + "="
							+ insurtype;
				}
			}

			if (s_ordername != null && s_ordername.trim().length() > 0) {// 预订人
				sql += " AND "
						+ Orderinfo.COL_saleagentid
						+ " IN ( SELECT ID FROM [T_CUSTOMERUSER] WHERE [C_MEMBERNAME] LIKE '%"
						+ s_ordername + "%' )";
			}

			if (this.s_internal > -1) {

				sql += " AND C_INTERNAL =" + s_internal;

			}

			String ctime = this.getCheckTime(s_begintime, s_endtime,
					Passenger.COL_rttime);
			if (ctime.length() > 0) {// 出票时间
				sql += " AND (" + ctime + ")";
			}
			/*
			 * String ttime = this.getCheckTime(t_begintime, t_endtime,
			 * Passenger.COL_tuifeitime); if (ttime.length() > 0) {// 退票时间 sql += "
			 * AND (" + ttime + ") AND " + Passenger.COL_state + "=" + 3; }
			 * String ftime = this.getCheckTime(f_begintime, f_endtime,
			 * Passenger.COL_tuifeitime); if (ftime.length() > 0) {// 废票时间 sql += "
			 * AND (" + ftime + ") AND " + Passenger.COL_state + "=" + 2; }
			 */

			if (this.s_flight != null && s_flight.trim().length() > 0) {// 航班
				sql += " AND C_FLIGHTNUMBER LIKE '%" + s_flight + "%'";
			}
			if (this.s_cabin != null && this.s_cabin.trim().length() > 0) {// 舱位

				sql += " AND [C_CABINCODE] LIKE '%" + s_cabin + "%'";

			}
			if (this.fkstate > 0) {// 是否付款

				sql += " AND [C_HKSTATE] =" + fkstate;

			}
			if (this.tickettype > 0f) {// 机票类型
				sql += " AND C_TICKETTYPEID=" + tickettype;
			}
			/*
			 * if (s_tfname != null && s_tfname.trim().length() != 0) {// 退废票人
			 * sql += " AND " + Passenger.COL_orderid + " IN (SELECT
			 * C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN
			 * (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%" +
			 * s_tfname + "%') AND C_STATE IN (11,12))"; }
			 */

			if (s_linkname != null && s_linkname.trim().length() > 0) {// 联系人
				sql += " AND " + Orderinfo.COL_contactname + " LIKE '%"
						+ s_linkname + "%'";
			}

			if (s_ticketname != null && s_ticketname.trim().length() > 0) {// 乘机人
				sql += " AND " + Passenger.COL_name + " LIKE '%" + s_ticketname
						+ "%'";
			}
			if (this.piaohao != null && this.piaohao.trim().length() > 0) { // 票号

				sql += " AND C_TICKETNUM LIKE '%" + piaohao + "%'";
			}
			if (s_chuname != null && s_chuname.length() > 0) {// 出票人
				sql += " AND C_ORDERID "
						+ " IN (SELECT C_ORDERINFOID FROM  [T_ORDERINFORC]  WHERE C_STATE IN (3,29) "
						+ " AND C_CUSTOMERUSERID IN(  SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ s_chuname + "%' ) )";
			}
			if (!this.isNullorSpace(sqname)) {// 申请人
				sql += " AND C_ORDERID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
						+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ sqname + "%' ) AND C_STATE IN (4,5) )";
			}
			String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
					"C_CREATETIME");// 申请时间
			if (sqtime.length() > 0) {
				sql += " AND "
						+ Passenger.COL_orderid
						+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
						+ sqtime + "))";
			}
			if (!this.isNullorSpace(shname)) {// 审核人
				sql += " AND C_ORDERID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
						+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ shname + "%' ) AND C_STATE IN (7,17,11,12) )";
			}
			String shtime = this.getCheckTime(sh_begintime, sh_endtime,
					"C_CREATETIME");// 审核时间
			if (shtime.length() > 0) {
				sql += " AND "
						+ Passenger.COL_orderid
						+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
						+ shtime + "))";
			}
			if (!this.isNullorSpace(tkname)) {// 退款人
				sql += " AND C_ORDERID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
						+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ tkname + "%' ) AND C_STATE IN (9,18) )";
			}
			String tktime = this.getCheckTime(tk_begintime, tk_endtime,
					"C_CREATETIME");// 退款时间
			if (tktime.length() > 0) {
				sql += " AND "
						+ Passenger.COL_orderid
						+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
						+ tktime + "))";
			}
			if (s_paymethod != -1) {// 支付方式
				sql += " AND " + Orderinfo.COL_paymethod + "=" + s_paymethod;
			}
			if (fkmethod != -1) {// 还款款方式
				sql += " AND " + Orderinfo.COL_fkmethod + "=" + fkmethod;
			}
			this.getGather(sql);
			if (isExp) {
				return sql;
			} else {
				// sql += " ORDER BY C_STATE ASC , ID DESC ";
				listbigreport = Server.getInstance().getSystemService()
						.findMapResultSortBySql(sql,
								" ORDER BY C_ORDERID ASC ", pageinfo);
				pageinfo = (PageInfo) listbigreport.remove(0);
			}
		} else {
			insurtype = -1;
			this.toToday();
		}
		return "todakehu";

	}

	public float getInsuranceFeeById(long insurid) {
		float insurfee = 0f;
		if (insurid > 0) {
			Insuranceinfo insruance = Server.getInstance().getMemberService()
					.findInsuranceinfo(insurid);
			if (insruance != null)
				insurfee = Float.valueOf(insruance.getInsurancefee());
		}
		return insurfee;
	}

	/**
	 * 大客户欠款汇总报表
	 * 
	 * @return
	 */
	public String toBiguserGatherReport() {
		String menuwhere = " where 1>2 ";// 默认不显示
		if (isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
			menuwhere = " WHERE 1=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		List<Customeragent> listCustomeragent = Server.getInstance()
				.getMemberService().findAllCustomeragent(menuwhere, "", -1, 0);
		long[] longarry = new long[listCustomeragent.size()];
		int i = 0;
		for (Customeragent agent : listCustomeragent) {
			longarry[i] = agent.getId();
			i++;
		}
		if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			longarry = new long[1];
			longarry[0] = this.getLoginUser().getAgentid();
		}
		// this.getDepttreestr(3l, longarry, true);
		if (is_first != null) {
			this.doBiguserGather();
		} else {
			this.toToday();
		}
		return "tobiguserqkreport";
	}

	private void doBiguserGather() {
		biguserqkmaplist = new ArrayList<Map>();

		String agentid = "0";
		List<String> agentidstr = new ArrayList<String>();
		List<String> deptidstr = new ArrayList<String>();
		if (s_department != null && s_department.trim().length() > 0
				&& !s_department.equals("-1")) {// 部门
			if (s_department.indexOf("c") >= 0) {
				agentid = s_department.substring(1);
				departname = Server.getInstance().getMemberService()
						.findCustomeragent(Long.valueOf(agentid))
						.getAgentcompanyname();
				agentidstr.add(agentid);

			} else {
				long deptid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));
				agentid = s_department.substring(s_department.indexOf("@") + 1);
				this.departname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
				deptidstr.add(String.valueOf(deptid));

			}
		} else {
			if (!isNotNullOrEpt(clientmanger)) {
				if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角
					agentidstr.add(String.valueOf(getLoginUser().getAgentid()));
				} else {
					String menuwhere = " WHERE 1=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
					List<Customeragent> listCustomeragent = Server
							.getInstance().getMemberService()
							.findAllCustomeragent(menuwhere, "", -1, 0);
					for (Customeragent agent : listCustomeragent) {
						agentidstr.add(String.valueOf(agent.getId()));
					}
				}
			}

		}
		if (isNotNullOrEpt(clientmanger) && !isNotNullOrEpt(s_department)) {
			String menuwhere = "	WHERE C_USERID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%%')";
			List<Customeragent> listCustomeragent = Server.getInstance()
					.getMemberService().findAllCustomeragent(menuwhere, "", -1,
							0);
			for (Customeragent agent : listCustomeragent) {
				agentidstr.add(String.valueOf(agent.getId()));
			}

		}

		if (agentidstr.size() > 0) {
			for (String s : agentidstr) {
				String where = "  AND  C_PAYMETHOD=5 AND ( C_FKMETHOD=8 OR C_FKMETHOD IS NULL )";
				String mwhere = "";
				where += " AND C_CUSTOMERAGENTID =" + s;
				mwhere += " AND C_GROUPUSERID=" + s;
				String mname = this
						.getAgentManageNameByagentid(Long.valueOf(s));
				String agentname = this.getagentname_b2bback(Long.valueOf(s));
				this.bigusergatheroperate(where, mwhere, mname, agentname);

			}

		} else if (deptidstr.size() > 0) {
			for (String s : deptidstr) {
				String where = "  AND  C_PAYMETHOD=5 AND ( C_FKMETHOD=8 OR C_FKMETHOD IS NULL )";
				String mwhere = "";
				where += " AND C_CUSTOMERUSERID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID ="
						+ s + ") ";
				mwhere += " AND C_DEPARTMENT = " + s;
				String mname = this.getAgentManageNameByagentid(Long
						.valueOf(agentid));
				this.bigusergatheroperate(where, mwhere, mname, departname);
			}
		}

	}

	private void bigusergatheroperate(String where, String mwhere,
			String mname, String agentname) {
		if (this.s_endtime != null && s_endtime.trim().length() > 0) {
			where += " AND  C_RTTIME <=''" + s_endtime + "''";
			mwhere += " AND " + Miscellaneous.COL_createtime + "<=''"
					+ s_endtime + "''";
		}
		float arrearage = 0f;
		List<Map> pricemap = Server.getInstance().getSystemService()
				.findMapResultByProcedure(
						"[dbo].[sp_getqkbyagent] @WHERE = N' " + where
								+ " ',@ZWHERE = N' " + mwhere + "'");
		for (Map m : pricemap) {
			arrearage = Float.valueOf(m.get("qkprice").toString());
		}

		Map m = new HashMap();
		m.put("agentname", agentname);
		m.put("endtime", s_endtime);
		m.put("agentdebt", arrearage);

		m.put("username", mname);

		biguserqkmaplist.add(m);
	}

	private String getAgentManageNameByagentid(long id) {
		String cwhere = " WHERE ID =(SELECT C_USERID FROM T_CUSTOMERAGENT WHERE ID="
				+ id + ")";
		List<Customeruser> users = Server.getInstance().getMemberService()
				.findAllCustomeruser(cwhere, "", -1, 0);
		if (users.size() > 0) {
			return users.get(0).getMembername();
		}
		return "";

	}

	public void expBiguserGatherExcel() throws Exception {
		HthyWritableWorkBook
				.setSEARCHNUM(HthyWritableWorkBook.getSEARCHNUM() + 1);
		try {
			this.toBiguserGatherReport();
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		String[] titles = { "序号", "大客户", "截止日期", "欠款余额", "客户经理" };
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = "大客户欠款汇总报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");

		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("大客户欠款汇总报表",
				titles.length + 10, biguserqkmaplist.size() + 50);
		sheet.createOneRow("出票报表", 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		sheet.createOneRow("检索条件：");
		sheet.createRow();
		sheet.addCell("大客户：", HthyWorkSheet.Blod);
		sheet.addCell(departname);
		sheet.addCell("截止日期：", HthyWorkSheet.Blod);
		sheet.addCell(s_endtime);
		sheet.addCell("客户经理：", HthyWorkSheet.Blod);
		sheet.addCell(clientmanger);
		sheet.rowOver();
		addReportOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		float price = 0;
		int num = biguserqkmaplist.size();
		try {
			for (int i = 0; i < num; i++) {
				Map m = (HashMap) biguserqkmaplist.get(0);
				sheet.createRow();
				sheet.addCell(i + 1);
				sheet.addCell(m.get("agentname"));
				sheet.addCell(m.get("endtime"));
				sheet.addCell(m.get("agentdebt"));
				price += Float.valueOf(m.get("agentdebt").toString());
				sheet.addCell(m.get("username"));
				biguserqkmaplist.remove(0);
				sheet.rowOver();
			}
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		sheet.sheetOver();
		book.write();
		book.close();
	}

	/**
	 * 部门列表添加散客。
	 */
	private void addDepttreeofSanke() {
		if (this.isAdmin() || getLoginUser().getType() == 1) {
			StringBuffer dstr = new StringBuffer(super.getDeptstr());
			dstr
					.append(" var root_46 = new Ext.tree.TreeNode({text:\"散客\",id:'c46'});root.appendChild(root_46);");
			super.setDeptstr(dstr);
		}
	}

	/**
	 * 个人挂账还款报表
	 * 
	 * @return
	 */
	public String toPersonalAccountReport() {
		long[] longarry = { 46 };

		// this.getDepttreestr(1l, longarry, true);
		if (is_first != null) {
			String qkstate = "1,2,3";
			if (ispersonalqk != null && ispersonalqk.equals("true")) {
				qkstate = "1,3";
			}
			String sql = " SELECT ID, C_ORDERID, C_CUSTOMERAGENTID,C_ORDERNUMBER,C_TICKETNUM,C_FET, C_NAME,ISNULL(C_INSURANCEFEE,0) INSURFEE,"
					+ "C_PRICE,ISNULL(C_AIRPORTFEE,0)+ISNULL(C_FUELPRICE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0) AS DUTY,C_TUIFEE,dbo.F_GetAgentName(C_CUSTOMERUSERID,C_CUSTOMERAGENTID) AS AGENTNAME,"
					+ "dbo.F_GetSegmAirCode(C_ORDERID,'C_STARTAIRPORT') as citypair,dbo.F_GetSegmAirCode(C_ORDERID,'C_DEPARTTIME') as chufashijian,dbo.F_GetSegmAirCode(C_ORDERID,'C_FLIGHTNUMBER') as hangbanhao,"
					+ "dbo.F_GetSegmAirCode(C_ORDERID,'C_AIRCOMAPNYCODE') as hangkonggongsi,dbo.F_GetSegmAirCode(C_ORDERID,'C_YPRICE') as YPRICE,dbo.F_GetSegmAirCode(C_ORDERID,'C_DISCOUNT') as DISCOUNT,"
					+ "C_PRINTTIME,C_CUSTOMERUSERID,C_STATE,C_INSURANCE,C_HKSTATE ,C_YIHAI,C_MEMO,"
					+ "C_GUAZHANGRENID,(SELECT C_MEMBERNAME FROM T_CUSTOMERUSER C WHERE C.ID=v.C_GUAZHANGRENID) AS GZRNAME,C_REPAYTIME FROM view_pas_order_seng v WHERE  C_FKMETHOD=7 AND C_HKSTATE IN ("
					+ qkstate + ")";
			if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
				sql += " AND " + Orderinfo.COL_buyagentid + "="
						+ getLoginUser().getAgentid();
			}
			if (s_department != null && s_department.trim().length() > 0
					&& !s_department.equals("-1")) {
				String deptstr = "";
				if (s_department.indexOf("c") >= 0) {
					long deptid = Long.valueOf(s_department.substring(1));
					this.departname = Server.getInstance().getMemberService()
							.findCustomeragent(deptid).getAgentcompanyname();
					deptstr = super.getAllDeptIdByAgentId(deptid);
				} else {
					long deptid = Long.valueOf(s_department.substring(0,
							s_department.indexOf("@")));
					this.departname = Server.getInstance().getMemberService()
							.findDepartment(deptid).getName();
					deptstr = getSubDetpt(deptid);
				}
				sql += " AND C_GUAZHANGRENID IN (SELECT ID FROM T_CUSTOMERUSER  WHERE C_DEPTID IN ("
						+ deptstr + ")) ";

			}
			/*
			 * if (this.insurtype >= 0) { if (insurtype == 1) {//
			 * 出票状态1：已出票，根据东航要求，已出票在这里包含申请状态票.... sql += " AND " +
			 * Passenger.COL_state + " NOT IN (0,2,3,9)"; } else { sql += " AND " +
			 * Passenger.COL_state + "=" + insurtype; } } else { sql += " AND " +
			 * Passenger.COL_state + " NOT IN (0,11)";// 0:未出票,11:已取消 }
			 */

			if (s_ordername != null && s_ordername.trim().length() > 0) {// 预订人
				sql += " AND "
						+ Orderinfo.COL_saleagentid
						+ " IN ( SELECT ID FROM [T_CUSTOMERUSER] WHERE [C_MEMBERNAME] LIKE '%"
						+ s_ordername + "%' )";
			}

			if (this.s_internal > -1) {

				sql += " AND C_INTERNAL =" + s_internal;

			}

			String ctime = this.getCheckTime(s_begintime, s_endtime,
					Passenger.COL_rttime);
			if (ctime.length() > 0) {// 出票时间
				sql += " AND (" + ctime + ")";
			}
			String ttime = this.getCheckTime(t_begintime, t_endtime,
					Passenger.COL_tuifeitime);
			if (ttime.length() > 0) {// 退票时间
				sql += " AND (" + ttime + ") AND " + Passenger.COL_state + "="
						+ 3;
			}
			String ftime = this.getCheckTime(f_begintime, f_endtime,
					Passenger.COL_tuifeitime);
			if (ftime.length() > 0) {// 废票时间
				sql += " AND (" + ftime + ") AND " + Passenger.COL_state + "="
						+ 2;
			}

			String htime = this.getCheckTime(h_begintime, h_endtime,
					Passenger.COL_repaytime);
			if (ftime.length() > 0) {// 还款时间
				sql += " AND (" + htime + ") AND " + Passenger.COL_hkstate
						+ " IN (2,3)";
			}

			if (this.s_flight != null && s_flight.trim().length() > 0) {// 航班
				sql += " AND C_FLIGHTNUMBER LIKE '%" + s_flight + "%'";
			}
			if (this.s_cabin != null && this.s_cabin.trim().length() > 0) {// 舱位

				sql += " AND [C_CABINCODE] LIKE '%" + s_cabin + "%'";

			}
			if (this.fkstate > 0) {// 是否付款

				sql += " AND [C_HKSTATE] =" + fkstate;

			}
			// if (this.tickettype > 0f) {// 机票类型
			// String twhere = " WHERE " + Ticketnumber.COL_tickettypeid + "="
			// + tickettype;
			// Ticketnumber ticketnumber = null;
			// List<Ticketnumber> ticketnumbers = Server.getInstance()
			// .getMemberService().findAllTicketnumber(twhere, "", -1,
			// 0);
			// if (ticketnumbers.size() > 0) {
			// ticketnumber = ticketnumbers.get(0);
			// }
			// if (ticketnumber != null) {
			// String begint = ticketnumber.getBeginnumber();
			// String endt = ticketnumber.getEndnumber();
			// sql += " AND SUBSTRING(" + Passenger.COL_ticketnum
			// + ",5,10) BETWEEN '" + begint + "' AND '" + endt
			// + "'";
			// } else {
			// sql += " AND 1>2";
			// }
			// }
			if (s_tfname != null && s_tfname.trim().length() != 0) {// 退废票人
				sql += " AND "
						+ Passenger.COL_orderid
						+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ s_tfname + "%') AND C_STATE IN (11,12))";
			}

			if (s_linkname != null && s_linkname.trim().length() > 0) {// 联系人
				sql += " AND " + Orderinfo.COL_contactname + " LIKE '%"
						+ s_linkname + "%'";
			}

			if (s_ticketname != null && s_ticketname.trim().length() > 0) {// 乘机人
				sql += " AND " + Passenger.COL_name + " LIKE '%" + s_ticketname
						+ "%'";
			}

			if (this.s_gzname != null && this.s_gzname.trim().length() > 0) {// 挂账人
				sql += " AND "
						+ Orderinfo.COL_guazhangrenid
						+ " IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_AGENTID=46 AND C_MEMBERNAME LIKE '%"
						+ s_gzname + "%')";
			}
			if (this.piaohao != null && this.piaohao.trim().length() > 0) { // 票号

				sql += " AND C_TICKETNUM LIKE '%" + piaohao + "%'";
			}
			if (s_chuname != null && s_chuname.length() > 0) {// 出票人
				sql += " AND C_ORDERID "
						+ " IN (SELECT C_ORDERINFOID FROM  [T_ORDERINFORC]  WHERE "
						+ Orderinforc.COL_state
						+ "="
						+ 3
						+ " AND C_CUSTOMERUSERID IN(  SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ s_chuname + "%' ) )";
			}
			// if (s_paymethod != -1) {// 支付方式
			// sql += " AND " + Orderinfo.COL_paymethod + "=" + s_paymethod;
			// }
			// if (fkmethod != -1) {// 付款方式
			// sql += " AND " + Orderinfo.COL_fkmethod + "=" + fkmethod;
			// }
			this.getGather(sql);
			if (isExp) {
				return sql;
			} else {
				// sql += " ORDER BY C_STATE ASC , ID DESC ";
				System.out.println(sql);
				List list = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listbigreport = list;
			}
		} else {
			this.toToday();
		}

		return "topersonalreport";
	}

	public String toPersonalQKGatherReport() {
		long[] arrayagentid = { 46 };
		// this.getDepttreestr(1l, arrayagentid, true);

		List<Customeruser> customeruserList = new ArrayList<Customeruser>();
		String where = " WHERE ID IN(SELECT C_GUAZHANGRENID FROM T_ORDERINFO WHERE C_FKMETHOD=7)";
		if (s_department != null && s_department.trim().length() != 0) {// 部门
			String deptstr = "";
			if (s_department.indexOf("c") >= 0) {
				long deptid = Long.valueOf(s_department.substring(1));
				this.departname = Server.getInstance().getMemberService()
						.findCustomeragent(deptid).getAgentcompanyname();
				// deptstr = super.getAllDeptIdByAgentId(deptid);
			} else {
				long deptid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));
				this.departname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
				deptstr = getSubDetpt(deptid);
				where += " AND C_DEPTID IN (" + deptstr + ")";
			}
		}
		if (this.s_gzname != null && s_gzname.trim().length() > 0) {
			where += " AND C_MEMBERNAME LIKE '%" + s_gzname + "%'";
		}
		String andwhere = "";
		if (this.s_endtime != null && s_endtime.trim().length() > 0) {
			andwhere = " AND C_RTTIME <= ''" + s_endtime + "''";
		} else {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			s_endtime = f.format(new Date());
			andwhere = " AND C_RTTIME <= ''" + s_endtime + "''";

		}
		customeruserList = Server.getInstance().getMemberService()
				.findAllCustomeruser(where, "", -1, 0);
		for (Customeruser user : customeruserList) {
			Map<String, Object> map = new HashMap<String, Object>();
			String deptname = super.getDeptNameByID(String.valueOf(user
					.getDeptid()));
			map.put("dept", deptname);
			map.put("gzname", user.getMembername());
			map.put("jzdate", this.s_endtime);
			float qkprice = getGRGZQKPrice(user.getId(), andwhere);
			map.put("qkprice", qkprice);
			this.grgzqkmaplist.add(map);

		}
		return "toPersonalQKGatherReport";
	}

	public void expPersonalQKGatherExcel() throws Exception {
		try {
			HthyWritableWorkBook.setSEARCHNUM(HthyWritableWorkBook
					.getSEARCHNUM() + 1);
			this.toPersonalQKGatherReport();
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		String[] titles = { "序号", "部门", "挂账人", "截至日期", "欠款余额" };
		String name = "个人挂账欠款汇总报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("个人挂账欠款汇总报表",
				titles.length + 10, listPassenger.size() + 50);
		sheet.createOneRow("个人挂账欠款汇总报表", 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		// sheet.createOneRow("检索条件：");
		// addReportOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		double allhqprice = 0d;
		int num = grgzqkmaplist.size();
		try {
			for (int i = 0; i < num; i++) {
				sheet.createRow();
				Map map = (HashMap) grgzqkmaplist.get(0);
				sheet.addCell(i + 1);
				sheet.addCell(map.get("dept"));
				sheet.addCell(map.get("gzname"));
				sheet.addCell(map.get("jzdate"));
				sheet.addCell(map.get("qkprice"));
				allhqprice += Double.valueOf(map.get("qkprice").toString());
				grgzqkmaplist.remove(0);
				sheet.rowOver();

			}
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		sheet
				.createOneRow(new String[] { "欠款金额总计：",
						String.valueOf(allhqprice) });
		sheet.sheetOver();
		book.write();
		book.close();

	}

	private float getGRGZQKPrice(long gzrid, String andwhere) {
		float arrearage = 0f;
		String otherwhere = " AND C_GUAZHANGRENID=" + gzrid + " " + andwhere;
		List<Map> pricemap = Server.getInstance().getSystemService()
				.findMapResultByProcedure(
						" [dbo].[sp_getqkbyagent] @WHERE = N'" + otherwhere
								+ "',@ZWHERE = N'NULL'");
		for (Map m : pricemap) {
			arrearage = Float.valueOf(m.get("qkprice").toString());
		}
		return arrearage;

	}

	public void expPersonalAccountReportExcel() throws Exception {
		String sql = "";
		try {
			isExp = true;
			HthyWritableWorkBook.setSEARCHNUM(HthyWritableWorkBook
					.getSEARCHNUM() + 1);
			sql = toPersonalAccountReport();
			pageinfo.setPagerow(2000);
			listbigreport = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, pageinfo);
			pageinfo = (PageInfo) listbigreport.remove(0);

		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		// （大客户）部门（或散客）、票号、行程单号、订单序号、乘客姓名、航空公司、航班号、出发城市、目的城市、起飞日期、起飞时刻、机票全价、折扣率、
		// 折扣票价、机建费、燃油费、退票费、总价、返利、实际结账、出票日期、机票状态、挂账人、（个人）是否还款、还款日期、订单备注
		// 导出列表左下方及显示页面列表左下方显示：本期已还款金额总计、本期未还款金额总计、累计未还款金额总计

		String[] titles = { "部门", "类型", "票号", "行程单号", "订单编号", "乘客姓名", "航空公司",
				"航班号", "航程", "起飞日期", "机票全价", "折扣率", "折扣票价", "税", "保险", "退票费",
				"总价", "返利", "实际结账", "出票日期", "机票状态", "挂账人", "是否付款", "还款日期",
				"订单备注", };

		String name = "个人挂账还款报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("个人挂账还款报表",
				titles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow("个人挂账还款报表", 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		int num = 0;
		double hqprice = 0d;
		double relprice = 0d;
		double allhqprice = 0d;

		Orderinfo orderinfo = null;
		try {

			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = listbigreport.size();
				num += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					Map map = (HashMap) listbigreport.remove(0);
					relprice += Double
							.valueOf(nullConver(map.get("C_YIHAI"), 0)
									.toString());
					long orderid = Long.valueOf(converNull(
							map.get("C_ORDERID"), "0").toString());
					Long l = Long.valueOf(map.get("C_CUSTOMERAGENTID")
							.toString());
					sheet.addCell(map.get("AGENTNAME"));
					String inter = converNull(map.get("C_INTERNAL"), "0")
							.toString();
					int interanl = Integer.valueOf(inter);
					sheet.addCell(interanl == 0 ? "国内票" : "国际票");
					sheet.addCell(map.get("C_TICKETNUM"));
					sheet.addCell(map.get("C_FET"));
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(map.get("C_NAME"));
					sheet.addCell(map.get("hangkonggongsi"));
					sheet.addCell(map.get("hangbanhao"));
					sheet.addCell(map.get("citypair"));// 出发城市
					sheet.addCell(map.get("chufashijian"));
					sheet.addCell(map.get("YPRICE"));
					// C_YPRICE
					sheet.addCell(map.get("DISCOUNT"));
					float price = Float.valueOf(nullConver(map.get("C_PRICE"),
							0).toString());
					float duty = Float.valueOf(nullConver(map.get("DUTY"), 0)
							.toString());
					sheet.addCell(price);
					sheet.addCell(duty);

					sheet.addCell(converNull(map.get("INSURFEE"), "0"));
					sheet.addCell(nullConver(map.get("C_TUIFEE"), 0.0));
					sheet.addCell(price + duty);
					sheet.addCell(0);
					sheet.addCell(nullConver(map.get("C_YIHAI"), 0.0));
					sheet.addCell(map.get("C_PRINTTIME"));
					int hk = Integer.valueOf(map.get("C_HKSTATE").toString());
					if (hk == 1 || hk == 3) {
						long pid = Long.valueOf(map.get("ID").toString());
						hqprice += getHQprice(pid);
					}
					String hkstr = "";
					if (hk == 1) {
						hkstr = "未付款";
					}
					if (hk == 2) {
						hkstr = "已付款";
					}
					if (hk == 3) {
						hkstr = "部分付款";
					}
					int state = Integer.valueOf(map.get("C_STATE").toString());
					String statestr = getpassstate(state);
					sheet.addCell(statestr);
					sheet.addCell(map.get("GZRNAME"));// 挂账人
					sheet.addCell(hkstr);
					Object rt = map.get("C_REPAYTIME");
					String rttime = "";
					if (rt != null) {
						rttime = map.get("C_REPAYTIME").toString();
						if (rttime.trim().length() > 0)
							rttime = super.formatStringTime(rttime);
					}
					sheet.addCell(rttime);
					sheet.addCell(map.get("C_MEMO").toString());
					sheet.rowOver();
					if (num % 300 == 0) {
						book.flush();
						book.write();
					}
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					listbigreport = Server.getInstance().getSystemService()
							.findMapResultBySql(sql, pageinfo);
					pageinfo = (PageInfo) listbigreport.remove(0);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		System.gc();
		sheet.createOneRow(new String[] { "本期已还款金额总计：",
				String.valueOf(relprice) });
		sheet
				.createOneRow(new String[] { "本期未还款金额总计：",
						String.valueOf(hqprice) });
		sheet.createOneRow(new String[] { "累计未还款金额总计：",
				String.valueOf(this.getAllgrgzPrice()) });
		sheet.sheetOver();
		book.flush();
		book.write();
		book.close();

	}

	public String getFlightTime(long orderid) {
		return "";
	}

	public String getbumen(long id) {// 取出票人所在部门
		long userid = Server.getInstance().getAirService().findOrderinfo(id)
				.getUserid();

		long Deptid = Server.getInstance().getMemberService().findCustomeruser(
				userid).getDeptid();

		String name = Server.getInstance().getMemberService().findDepartment(
				Deptid).getName();
		return name;
	}

	public String airticketrebatreport() {
		if (is_first != null) {
			int agenttype = this.getLoginUserAgent().getAgenttype();// 所属加盟商类型
			long agentid = this.getLoginUserAgent().getId();
			String sql = " SELECT * FROM [view_airorderrebate] ";
			sql += " WHERE 1=1 AND  (C_BUYAGENTID=" + agentid
					+ "  OR charindex(CONVERT(nvarchar," + agentid
					+ "),PARENTSTR)> 0  )";
			if (agenttype == 2) {// 供应商 自己订单和自己政策下的已支付订单
				sql = " SELECT * FROM [view_airorderrebate]  WHERE 1=1 AND ( C_BUYAGENTID="
						+ agentid
						+ "  OR charindex(CONVERT(nvarchar,"
						+ agentid
						+ "),PARENTSTR)> 0    OR ("
						+ Orderinfo.COL_policyagentid
						+ "="
						+ agentid
						+ " AND C_ORDERSTATUS !=1))";

			}
			sql += " AND C_ORDERSTATUS NOT IN (1,2,6,16,19,27,9,11,12,18)";
			if (isNotNullOrEpt(this.s_ordernum)) {
				sql += " AND  C_ORDERNUMBER  LIKE '%" + s_ordernum + "%' ";
			}
			if (!isNullorSpace(s_pnr)) {// PNR
				sql += " AND (" + Orderinfo.COL_pnr + "='" + s_pnr + "' OR "
						+ Orderinfo.COL_bigpnr + "='" + s_pnr + "')";
			}
			String createtime = this.getCheckTime(s_begintime, s_endtime,
					"C_PRINTTIME");
			if (isNotNullOrEpt(createtime)) {
				sql += " AND (" + createtime + ") ";
			}
			System.out.println(sql);
			if (isExp) {
				return sql;
			} else {
				this.listrebaterecord = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, pageinfo);
				if (listrebaterecord.size() > 0) {
					pageinfo = (PageInfo) listrebaterecord.remove(0);
				}
				System.out.println(listrebaterecord.size());
			}

		}

		System.out
				.println("Airreport:airticketrebatreport----report:airrebatreport.jsp");

		return "airrebatreport";
	}

	public void expairrebatExcel() throws Exception {
		String sql = "";
		try {
			HthyWritableWorkBook.SEARCHNUM += 1;
			isExp = true;
			sql = this.airticketrebatreport();
			pageinfo.setPagerow(2000);
			this.listrebaterecord = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, pageinfo);
			pageinfo = (PageInfo) listrebaterecord.remove(0);
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
			e.printStackTrace();
		}
		String name = "机票返佣报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);

		List<String> leveltitle = new ArrayList<String>();
		leveltitle.add("订单号");
		leveltitle.add("出票时间");
		leveltitle.add("PNR");
		leveltitle.add("航班号");
		leveltitle.add("航班日期");
		leveltitle.add("订单票价");
		leveltitle.add("订单税费");
		int level = this.getLoginUserAgent().getAgentjibie();
		if (level == 4) {
			leveltitle.add("平台");
		}
		if (level == 4 || level == 0) {
			leveltitle.add("省代理");
		}
		if (level == 4 || level == 0 || level == 1) {
			leveltitle.add("市代理");
		}
		if (level == 4 || level == 0 || level == 1 || level == 2) {
			leveltitle.add("区域代理");
		}
		if (level == 4 || level == 0 || level == 1 || level == 2 || level == 3) {
			leveltitle.add("经纪人");
			leveltitle.add("会员");
		}
		leveltitle.add("订单状态");
		String[] titleles = leveltitle.toArray(new String[] {});
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("运营商盈利报表",
				titleles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow("机票返佣报表", 3);
		sheet.createOneRow("${dns.companyname}商旅中心电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		// sheet.createOneRow("检索条件：");
		// addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);

		Map map = null;
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = listrebaterecord.size();
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					map = (HashMap) listrebaterecord.remove(0);
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(map.get("C_PRINTTIME"));
					sheet.addCell(this.getpnr(converNull(map.get("C_PNR"), "")
							.toString(), converNull(map.get("C_BIGPNR"), "")
							.toString()));

					sheet.addCell(map.get("AIRFLIGHTNUMBER"));
					sheet.addCell(map.get("AIRTIME"));
					sheet.addCell(map.get("C_TOTALTICKETPRICE"));
					sheet.addCell(map.get("DUTY"));
					if (level == 4) {

						sheet.addCell(map.get("AREBAT"));
					}
					if (level == 4 || level == 0) {

						sheet.addCell(map.get("BREBAT"));
					}
					if (level == 4 || level == 0 || level == 1) {
						sheet.addCell(map.get("CREBAT"));

					}
					if (level == 4 || level == 0 || level == 1 || level == 2) {
						sheet.addCell(map.get("DREBAT"));

					}
					if (level == 4 || level == 0 || level == 1 || level == 2
							|| level == 3) {
						sheet.addCell(map.get("EREBAT"));
						sheet.addCell(map.get("FREBAT"));
					}
					sheet.addCell(getOrderStatestr(Integer.valueOf(map.get(
							"C_ORDERSTATUS").toString())));
					if (i % 300 == 0) {
						book.flush();
						book.write();
					}
					sheet.rowOver();
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					listrebaterecord = Server.getInstance().getSystemService()
							.findMapResultBySql(sql, pageinfo);
					pageinfo = (PageInfo) listrebaterecord.remove(0);
				} else {
					break;
				}

			}
			System.gc();

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
	 * 运营商盈利报表
	 * 
	 * @return
	 */
	public String operatorsreport() {
		if (is_first != null) {
			String sql = "SELECT "
					+ "(SELECT C_ORDERNUMBER FROM T_ORDERINFO WHERE ID=R.C_ORDERNUMBER ) AS  ORDERNUMBER,"
					+ "C_REBATEAGENTIDSTR,C_REBATEMONEY,C_REBATETIME,"
					+ "C_REBATEMEMO,C_YEWUTYPE,"
					+ "(SELECT ISNULL(C_AGENTSHORTNAME,C_AGENTCOMPANYNAME )FROM T_CUSTOMERAGENT WHERE ID=R.C_REBATEAGENTID)AS REBATAGENTNAME,"
					+ "(SELECT C_AGENTJIBIE FROM T_CUSTOMERAGENT WHERE ID=R.C_REBATEAGENTID)AS REBATAGENTRANK,"
					+ "(SELECT ISNULL(C_AGENTSHORTNAME,C_AGENTCOMPANYNAME )FROM T_CUSTOMERAGENT WHERE ID=R.C_CHILDAGENTID)AS CHILDAGENTNAME,"
					+ "(SELECT C_AGENTJIBIE FROM T_CUSTOMERAGENT WHERE ID=R.C_CHILDAGENTID)AS CHILDAGENTRANK,"
					+ "(SELECT C_MEMBERNAME FROM T_CUSTOMERUSER WHERE ID=R.C_CUSTOMERID) MEMBERNAME"
					+ " FROM T_REBATERECORD R WHERE 1=1";
			sql += " AND C_REBATEAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTJIBIE="
					+ this.getLoginsessionagent().getAgenttype() + ")";

			if (isNotNullOrEpt(this.s_ordernum)) {
				sql += " AND  C_ORDERNUMBER IN (SELECT ID  FROM T_ORDERINFO WHERE C_ORDERNUMBER = '"
						+ s_ordernum + "')";
			}

			String createtime = this.getCheckTime(s_begintime, s_endtime,
					"C_REBATETIME");
			if (isNotNullOrEpt(createtime)) {
				sql += " AND (" + createtime + ") ";
			}
			if (s_type > 0) {
				sql += " AND C_YEWUTYPE=" + s_type;
			}
			if (isExp) {
				return sql;
			} else {
				this.listrebaterecord = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, pageinfo);
				if (listrebaterecord.size() > 0) {
					pageinfo = (PageInfo) listrebaterecord.remove(0);
				}
			}

		}
		System.out
				.println("Airreport:operatorsreport----report:operatorsreport.jsp");
		return "operatorsreport";
	}

	public String getOrderStatestr(Integer state) {
		return B2borderinfoAction.getStateToString(state);
	}

	/**
	 * 出票报表
	 * 
	 * @return
	 */
	public String chupiao_old() {
		// 非第一次进入
		if (is_first != null) {

			Customeragent longinagent = this.getLoginsessionagent();
			System.out.println(longinagent.getAgenttype());
			HttpServletRequest request = ServletActionContext.getRequest();
			long agid = this.customeragent.getId();
			StringBuilder where = new StringBuilder(" 1=1 ");
			
				if(tftype>0){
					where.append("  AND C_ORDERSTATUS="+tftype);
				}else{
					where.append("  AND C_ORDERSTATUS=3");
				}
				
			
			if (longinagent.getAgenttype() != 2) {
				if (agid!=0) {					
					if (agid < 0) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
										+ (0 - agid));
						if (longinagent.getAgenttype() != 1) {
							where
									.append("  AND  charindex(','+CONVERT(nvarchar,"
											+ longinagent.getId()
											+ ")+',',','+C_PARENTSTR+',')> 0 ");
						}
						where.append(")");
					} else {
						where.append(" AND C_BUYAGENTID=" + agid);
					}
				} else {
					if (longinagent.getAgenttype() != 1) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
										+ longinagent.getId()
										+ "  OR  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
					}
				}
			} else {
				where.append(" AND " + Orderinfo.COL_policyagentid + "="
						+ longinagent.getId());

			}
			// if (insurtype == 3) {// 出票状态1：已出票，根据东航要求，已出票在这里包含申请状态票....
			// where.append(" AND " + Orderinfo.COL_orderstatus
			// + " NOT IN (1,2,6,16,19,27,9,11,12,18)");
			// } else if (insurtype == 10) {// 已收银 不包含审核过退废和退费成功的
			// where.append(" AND " + Orderinfo.COL_orderstatus
			// + " NOT IN (9,11,12,18) AND C_CASHIER =1");
			// } else if (insurtype == 2) {// 未出票
			// where.append(" AND " + Orderinfo.COL_orderstatus + "=2");
			// } else if (insurtype == 11) {// 废票
			// where
			// .append(" AND " + Orderinfo.COL_orderstatus
			// + " IN (11,9)");
			//
			// } else if (insurtype == 12) {// 退票
			// where.append(" AND " + Orderinfo.COL_orderstatus
			// + " IN (12,18)");
			// } else if (insurtype == -1) {// 出票报表所有
			// //高亮 2011-12-22
			// //过滤掉订单状态为等待出票的订单 订单状态编码是2
			// where.append(" AND " + Orderinfo.COL_orderstatus
			// + " NOT IN (1,2,6,16,19,27,9,11,12,18)");
			// } else {// 退废票报表所有
			// where.append(" AND " + Orderinfo.COL_orderstatus
			// + " IN (9,11,12,18)");
			// }
			if (isNotNullOrEpt(this.s_ordernum)) {
				where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
			}
			if (!isNullorSpace(s_ordername)) {// 预订人
				where
						.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_ordername + "%')");
			}
			if (!isNullorSpace(s_chuname)) {// 出票人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_chuname + "%' ) )");
			}
			String cptime = this.getCheckTime(s_begintime, s_endtime,
					"C_PRINTTIME");// 出票时间
			if (cptime.length() > 0) {
				where.append(" AND (" + cptime + ") ");

			}
			String ydtime = this.getCheckTime(orderstime, orderetime,
					Orderinfo.COL_createtime);// 预订时间
			if (ydtime.length() > 0) {
				where.append(" AND (" + ydtime + ") ");

			}
			if (!isNullorSpace(s_shouyinname)) {// 收银人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_shouyinname + "%' ) AND C_STATE  =10 )");
			}
			String shoutime = this.getCheckTime(this.shou_begintime,
					this.shou_endtime, "C_CREATETIME");
			if (shoutime.length() > 0) {// 收银时间
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
								+ shoutime + ") )");
			}
			if (!this.isNullorSpace(sqname)) {// 申请人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ sqname + "%' ) AND C_STATE IN (4,5) )");
			}
			String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
					"C_CREATETIME");// 申请时间
			if (sqtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
								+ sqtime + "))");
			}
			if (!this.isNullorSpace(shname)) {// 审核人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
			}
			String shtime = this.getCheckTime(sh_begintime, sh_endtime,
					"C_CREATETIME");// 审核时间
			if (shtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
								+ shtime + "))");
			}
			if (!this.isNullorSpace(tkname)) {// 退款人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ tkname + "%' ) AND C_STATE IN (9,18) )");
			}
			String tktime = this.getCheckTime(tk_begintime, tk_endtime,
					"C_CREATETIME");// 退款时间
			if (tktime.length() > 0) {
				where
						.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
								+ tktime + "))");
			}
			if (!isNullorSpace(piaohao)) {// 票号

				where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
			}
			if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

				where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
			}
			String flitime = this.getCheckTime(this.flight_begintime, "",
					Segmentinfo.COL_departtime);
			if (flitime.length() > 0) {// 航班日期
				where
						.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
								+ flitime + ")");
			}
			if (!isNullorSpace(s_pnr)) {// PNR
				where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
						+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
			}
			if (!isNullorSpace(s_airname)) {// 航空公司

				where.append(" AND AIRNAME LIKE '%" + s_airname + "%'");
			}
			if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
				where.append(" AND C_CABINCODE = '" + s_cabin + "'");
			}

			/*
			 * if (this.isExp) { if (this.is_tfticket != null) { sql += " ORDER
			 * BY C_ORDERSTATUS,C_PRINTTIME"; } else { sql += " ORDER BY
			 * C_RTTIME ASC "; } } else { // sql += " ORDER BY ID ASC "; }
			 */

			System.out.println("chupiaoReport:" + where);

			if (this.tftype > 0) {
				filedname = " *,(SELECT SUM(C_TUIFEE) FROM T_PASSENGER WHERE C_ORDERID=O.ID AND C_STATE<>12) AS SHOUXUFEI  ";
			} else {
				if (this.getLoginsessionagent().getAgenttype() == 1) {
					filedname = " *,(SELECT SUM(C_REBATEMONEY) FROM T_REBATERECORD R "
							+ "WHERE R.C_ORDERNUMBER=O.C_ORDERNUMBER AND C_REBATEMONEY>0 AND C_REBATEAGENTID!=46)"
							+ " AS REBATEMONEY  ";
				} else {
					filedname = " *,(SELECT SUM(C_REBATEMONEY) FROM T_REBATERECORD R "
							+ "WHERE R.C_ORDERNUMBER=O.C_ORDERNUMBER AND C_REBATEMONEY>0 AND C_REBATEAGENTID="
							+ this.getLoginsessionagent().getId()
							+ ")"
							+ " AS REBATEMONEY  ";
				}
			}
			if (isExp) {
				return where.toString();
			} else {
				this.getGather(" where  " + where.toString());
				listPassenger=this.reportPage(where.toString());
			}

		} else {
			this.toToday();
			if (!isExp) {
				this.insurtype = 10;
				if (this.tftype >0) {
					this.toTodayofShouyin();
				} else {
					this.insurtype = 12;
					this.toTodayoftk();
				}
			}
		}
		if (this.tftype>0) {
			return "totfticketreport";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String agentroot = new CustomeragentAction().getAgentRoot();
		request.setAttribute("agentroot", agentroot);
		return "chupiao";
	}
	
	public String chupiao() {
		// 非第一次进入
		if (is_first != null) {
			
			Customeragent longinagent = this.getLoginsessionagent();
			System.out.println(longinagent.getAgenttype());
			HttpServletRequest request = ServletActionContext.getRequest();
			long agid = this.customeragent.getId();
			StringBuilder where = new StringBuilder(" where 1=1 ");
			if (tftype > 0) {

				where.append("  AND C_ORDERSTATUS =" + tftype);
			} else {

				/*where
						.append("  AND C_ORDERSTATUS >2 AND C_ORDERSTATUS NOT IN(6,9,16,18,19,27) ");*/
				where
				.append("  AND C_ORDERSTATUS =3 ");
			}
			if (longinagent.getAgenttype() != 2) {
				if (agid!=0) {					
					if (agid < 0) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
										+ (0 - agid));
						if (longinagent.getAgenttype() != 1) {
							where
									.append("  AND  charindex(','+CONVERT(nvarchar,"
											+ longinagent.getId()
											+ ")+',',','+C_PARENTSTR+',')> 0 ");
						}
						where.append(")");
					} else {
						where.append(" AND C_BUYAGENTID=" + agid);
					}
				} else {
					if (longinagent.getAgenttype() != 1) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
										+ longinagent.getId()
										+ "  OR  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
					}
				}
			} else {
				where.append(" AND " + Orderinfo.COL_policyagentid + "="
						+ longinagent.getId());

			}
			
			if (isNotNullOrEpt(this.s_ordernum)) {
				where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
			}
			if (!isNullorSpace(s_ordername)) {// 预订人
				where
						.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_ordername + "%')");
			}
			if (!isNullorSpace(s_chuname)) {// 出票人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_chuname + "%' ) )");
			}
			String cptime = this.getCheckTime(s_begintime, s_endtime,
					"C_PRINTTIME");// 出票时间
			if (cptime.length() > 0) {
				where.append(" AND (" + cptime + ") ");

			}
			String ydtime = this.getCheckTime(orderstime, orderetime,
					Orderinfo.COL_createtime);// 预订时间
			if (ydtime.length() > 0) {
				where.append(" AND (" + ydtime + ") ");

			}
			if (!isNullorSpace(s_shouyinname)) {// 收银人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_shouyinname + "%' ) AND C_STATE  =10 )");
			}
			String shoutime = this.getCheckTime(this.shou_begintime,
					this.shou_endtime, "C_CREATETIME");
			if (shoutime.length() > 0) {// 收银时间
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
								+ shoutime + ") )");
			}
			if (!this.isNullorSpace(sqname)) {// 申请人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ sqname + "%' ) AND C_STATE IN (4,5) )");
			}
			String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
					"C_CREATETIME");// 申请时间
			if (sqtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
								+ sqtime + "))");
			}
			if (!this.isNullorSpace(shname)) {// 审核人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
			}
			String shtime = this.getCheckTime(sh_begintime, sh_endtime,
					"C_CREATETIME");// 审核时间
			if (shtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
								+ shtime + "))");
			}
			if (!this.isNullorSpace(tkname)) {// 退款人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ tkname + "%' ) AND C_STATE IN (9,18) )");
			}
			String tktime = this.getCheckTime(tk_begintime, tk_endtime,
					"C_CREATETIME");// 退款时间
			if (tktime.length() > 0) {
				where
						.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
								+ tktime + "))");
			}
			if (!isNullorSpace(piaohao)) {// 票号

				where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
			}
			if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

				where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
			}
			String flitime = this.getCheckTime(this.flight_begintime, "",
					Segmentinfo.COL_departtime);
			if (flitime.length() > 0) {// 航班日期
				where
						.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
								+ flitime + ")");
			}
			if (!isNullorSpace(s_pnr)) {// PNR
				where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
						+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
			}
			if (!isNullorSpace(s_airname)) {// 航空公司

				where.append(" AND AIRNAME LIKE '%" + s_airname + "%'");
			}
			if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
				where.append(" AND C_CABINCODE = '" + s_cabin + "'");
			}

			

			System.out.println("chupiaoReport:" + where);
	
			List list=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listorderinfo = list;
			if (pageinfo.getTotalrow() > 0 && listorderinfo.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID  ", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listorderinfo = list;
			}
			
		}
		return "chupiao";
		}
	public String chupiao_9c() {
		// 非第一次进入
		if (is_first != null) {
			
			Customeragent longinagent = this.getLoginsessionagent();
			System.out.println(longinagent.getAgenttype());
			HttpServletRequest request = ServletActionContext.getRequest();
			long agid = this.customeragent.getId();
			StringBuilder where = new StringBuilder(" where 1=1 ");
			if (tftype > 0) {

				where.append("  AND C_ORDERSTATUS =" + tftype);
			} else {

				/*where
						.append("  AND C_ORDERSTATUS >2 AND C_ORDERSTATUS NOT IN(6,9,16,18,19,27) ");*/
				where
				.append("  AND C_ORDERSTATUS =3 ");
			}
			if (longinagent.getAgenttype() != 2) {
				if (agid!=0) {					
					if (agid < 0) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
										+ (0 - agid));
						if (longinagent.getAgenttype() != 1) {
							where
									.append("  AND  charindex(','+CONVERT(nvarchar,"
											+ longinagent.getId()
											+ ")+',',','+C_PARENTSTR+',')> 0 ");
						}
						where.append(")");
					} else {
						where.append(" AND C_BUYAGENTID=" + agid);
					}
				} else {
					if (longinagent.getAgenttype() != 1) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
										+ longinagent.getId()
										+ "  OR  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
					}
				}
			} else {
				where.append(" AND " + Orderinfo.COL_policyagentid + "="
						+ longinagent.getId());

			}
			
			if (isNotNullOrEpt(this.s_ordernum)) {
				where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
			}
			if (!isNullorSpace(s_ordername)) {// 预订人
				where
						.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_ordername + "%')");
			}
			if (!isNullorSpace(s_chuname)) {// 出票人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_chuname + "%' ) )");
			}
			String cptime = this.getCheckTime(s_begintime, s_endtime,
					"C_PRINTTIME");// 出票时间
			if (cptime.length() > 0) {
				where.append(" AND (" + cptime + ") ");

			}
			String ydtime = this.getCheckTime(orderstime, orderetime,
					Orderinfo.COL_createtime);// 预订时间
			if (ydtime.length() > 0) {
				where.append(" AND (" + ydtime + ") ");

			}
			if (!isNullorSpace(s_shouyinname)) {// 收银人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_shouyinname + "%' ) AND C_STATE  =10 )");
			}
			String shoutime = this.getCheckTime(this.shou_begintime,
					this.shou_endtime, "C_CREATETIME");
			if (shoutime.length() > 0) {// 收银时间
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
								+ shoutime + ") )");
			}
			if (!this.isNullorSpace(sqname)) {// 申请人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ sqname + "%' ) AND C_STATE IN (4,5) )");
			}
			String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
					"C_CREATETIME");// 申请时间
			if (sqtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
								+ sqtime + "))");
			}
			if (!this.isNullorSpace(shname)) {// 审核人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
			}
			String shtime = this.getCheckTime(sh_begintime, sh_endtime,
					"C_CREATETIME");// 审核时间
			if (shtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
								+ shtime + "))");
			}
			if (!this.isNullorSpace(tkname)) {// 退款人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ tkname + "%' ) AND C_STATE IN (9,18) )");
			}
			String tktime = this.getCheckTime(tk_begintime, tk_endtime,
					"C_CREATETIME");// 退款时间
			if (tktime.length() > 0) {
				where
						.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
								+ tktime + "))");
			}
			if (!isNullorSpace(piaohao)) {// 票号

				where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
			}
			if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

				where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
			}
			String flitime = this.getCheckTime(this.flight_begintime, "",
					Segmentinfo.COL_departtime);
			if (flitime.length() > 0) {// 航班日期
				where
						.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
								+ flitime + ")");
			}
			if (!isNullorSpace(s_pnr)) {// PNR
				where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
						+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
			}
			where.append("  AND ID IN( SELECT "+Segmentinfo.COL_orderid+" FROM T_SEGMENTINFO where "+Segmentinfo.COL_aircomapnycode+" ='9C' )");
			
			
			
			if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
				where.append(" AND C_CABINCODE = '" + s_cabin + "'");
			}

			

			System.out.println("chupiaoReport:" + where);
	
			List list=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listorderinfo = list;
			if (pageinfo.getTotalrow() > 0 && listorderinfo.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID  ", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listorderinfo = list;
			}
			
		}
		return "chupiao_9c";
		}
	public String tuipiao() {
		// 非第一次进入
		if (is_first != null) {
			
			Customeragent longinagent = this.getLoginsessionagent();
			System.out.println(longinagent.getAgenttype());
			HttpServletRequest request = ServletActionContext.getRequest();
			long agid = this.customeragent.getId();
			StringBuilder where = new StringBuilder(" where 1=1 ");
			if (tftype > 0) {

				where.append("  AND C_ORDERSTATUS =" + tftype);
			} else {

				/*where
						.append("  AND C_ORDERSTATUS >2 AND C_ORDERSTATUS NOT IN(6,9,16,18,19,27) ");*/
				where
				.append("  AND C_ORDERSTATUS =3 ");
			}
			if (longinagent.getAgenttype() != 2) {
				if (agid!=0) {					
					if (agid < 0) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
										+ (0 - agid));
						if (longinagent.getAgenttype() != 1) {
							where
									.append("  AND  charindex(','+CONVERT(nvarchar,"
											+ longinagent.getId()
											+ ")+',',','+C_PARENTSTR+',')> 0 ");
						}
						where.append(")");
					} else {
						where.append(" AND C_BUYAGENTID=" + agid);
					}
				} else {
					if (longinagent.getAgenttype() != 1) {
						where
								.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
										+ longinagent.getId()
										+ "  OR  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
					}
				}
			} else {
				where.append(" AND " + Orderinfo.COL_policyagentid + "="
						+ longinagent.getId());

			}
			
			if (isNotNullOrEpt(this.s_ordernum)) {
				where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
			}
			if (!isNullorSpace(s_ordername)) {// 预订人
				where
						.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_ordername + "%')");
			}
			if (!isNullorSpace(s_chuname)) {// 出票人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_chuname + "%' ) )");
			}
			String cptime = this.getCheckTime(s_begintime, s_endtime,
					"C_PRINTTIME");// 出票时间
			if (cptime.length() > 0) {
				where.append(" AND (" + cptime + ") ");

			}
			String ydtime = this.getCheckTime(orderstime, orderetime,
					Orderinfo.COL_createtime);// 预订时间
			if (ydtime.length() > 0) {
				where.append(" AND (" + ydtime + ") ");

			}
			if (!isNullorSpace(s_shouyinname)) {// 收银人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ s_shouyinname + "%' ) AND C_STATE  =10 )");
			}
			String shoutime = this.getCheckTime(this.shou_begintime,
					this.shou_endtime, "C_CREATETIME");
			if (shoutime.length() > 0) {// 收银时间
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
								+ shoutime + ") )");
			}
			if (!this.isNullorSpace(sqname)) {// 申请人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ sqname + "%' ) AND C_STATE IN (4,5) )");
			}
			String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
					"C_CREATETIME");// 申请时间
			if (sqtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
								+ sqtime + "))");
			}
			if (!this.isNullorSpace(shname)) {// 审核人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
			}
			String shtime = this.getCheckTime(sh_begintime, sh_endtime,
					"C_CREATETIME");// 审核时间
			if (shtime.length() > 0) {
				where
						.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
								+ shtime + "))");
			}
			if (!this.isNullorSpace(tkname)) {// 退款人
				where
						.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
								+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
								+ tkname + "%' ) AND C_STATE IN (9,18) )");
			}
			String tktime = this.getCheckTime(tk_begintime, tk_endtime,
					"C_CREATETIME");// 退款时间
			if (tktime.length() > 0) {
				where
						.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
								+ tktime + "))");
			}
			if (!isNullorSpace(piaohao)) {// 票号

				where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
			}
			if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

				where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
			}
			String flitime = this.getCheckTime(this.flight_begintime, "",
					Segmentinfo.COL_departtime);
			if (flitime.length() > 0) {// 航班日期
				where
						.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
								+ flitime + ")");
			}
			if (!isNullorSpace(s_pnr)) {// PNR
				where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
						+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
			}
			if (!isNullorSpace(s_airname)) {// 航空公司

				where.append(" AND AIRNAME LIKE '%" + s_airname + "%'");
			}
			if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
				where.append(" AND C_CABINCODE = '" + s_cabin + "'");
			}

			

			System.out.println("tuipiaoReport:" + where);
	
			List list=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listorderinfo = list;
			if (pageinfo.getTotalrow() > 0 && listorderinfo.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID  ", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listorderinfo = list;
			}
			
		}
		return "tuipiao";
		}
	
	/**
	 * @return
	 */
	public List reportPage(String where){
		System.out.println("reportPage-where:"+where);
		int count=Server.getInstance().getAirService().countOrderinfoBySql("SELECT COUNT(*) FROM view_orderinfo WHERE "+where);
		pageinfo.setTotalrow(count);
		String pagesql="WITH SQL_QUERY AS(SELECT ROW_NUMBER() OVER(ORDER BY C_BUYAGENTID) AS ROWNO,"+filedname+" FROM view_orderinfo O  WHERE "+where+")";
		
		int offset=(pageinfo.getPagenum()-1)*pageinfo.getPagerow();
		pagesql+="SELECT * FROM SQL_QUERY WHERE    ROWNO BETWEEN "+(offset+1)+" AND "+(offset+pageinfo.getPagerow());
		System.out.println("pagesql:"+pagesql);
		List list = Server.getInstance().getSystemService().findMapResultBySql(pagesql, null);
		return list;
	}

	/**
	 * @param fdstr
	 * @param pcount
	 * @return 订单那对外返润
	 */
	public float getOutrebate(Orderinfo order, int pcount) {
		float[] yunyingfds = this.getNationTicketrebat(
				order.getBackpointinfo(), pcount);
		float fr = yunyingfds[0] + yunyingfds[1];
		return fr;
	}

	private void getGather(String where) {
		String sql = "SELECT COUNT(ID) ORDERCOUNT ,"
				+ "  SUM(C_PARVALUE) AS PARPRICE ,"
				+ "  SUM(C_TOTALTICKETPRICE+DUTY+ISNULL(INSURANCEPRICE,0)) AS PAYPRICE ,"
				+ "  SUM(DUTY) AS DUTYPRICE,SUM(ISNULL(INSURANCEPRICE,0)) AS INSURALLPRICE"
				+ "   FROM view_orderinfo ";

		List ordercountlist = Server.getInstance().getSystemService()
				.findMapResultBySql(sql + " " + where, null);
		Map m = (HashMap) ordercountlist.get(0);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("gather", m);
	}

	public Segmentinfo getSegmentinfoByOrderId(long orderid) {
		List<Segmentinfo> sges = Server.getInstance().getAirService()
				.findAllSegmentinfo(" WHERE C_ORDERID=" + orderid, "", -1, 0);
		Segmentinfo seg = new Segmentinfo();
		if (sges.size() > 0) {
			seg = sges.get(0);

		}
		return seg;
	}

	private boolean isNullorSpace(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public String getOrderNumber(long orderid) {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(orderid);
		if (orderinfo != null) {
			return orderinfo.getOrdernumber();
		}
		return "";

	}

	public Map<Integer, String> getPaymethodMap() {
		return new OrderinfoAction().getPaymethodMap();
	}

	public Map<Integer, String> getFkmethodMaP() {
		return new OrderinfoAction().getFkmethodMap();
	}

	public String getPayMethodStr(int paymethod) {
		return new OrderinfoAction().getPayMethodStr(paymethod);
	}

	/**
	 * @return
	 * @throws Exception
	 *             当日退废报表
	 */
	public String datefei() throws Exception {// 当日作废
		/*
		 * 检索条件列表：部门、预订人、联系人、乘机人、出票人、退废票人、 出票日期起止、废票日期起止、退票日期起止、票号、订单编号、航班、
		 * 舱位、支付方式、付款方式、机票类型、客户类型、退废票状态、退废票类型；
		 * 
		 * 显示页面列表：订单编号、支付方式、付款方式、票号、PNR、乘机人、航班、票面金额、税、客户实际支付金额、
		 * 退废票费、东航实际退票费用、客户实际退款金额、退废票状态、退废票类型、退废票人、出票日期、出票人；
		 */

		String operate = "=";
		if (this.notoday != null && (notoday.equals("true"))) {
			operate = "<>";
		}
		String statestr = "2,3";
		if (this.tfstate > 0) {
			statestr = String.valueOf(tfstate);
		}
		String ticketwhere = " WHERE 1=1 ";
		listtickettype = Server.getInstance().getMemberService()
				.findAllTickettype(ticketwhere, "", -1, 0);
		if (is_first != null) {
			String sql = "SELECT ID, C_ORDERID, C_ORDERNUMBER,C_PAYMETHOD,C_TICKETNUM,C_CUSTOMERAGENTID,C_NAME,C_PRICE,C_PNR,C_BIGPNR,"
					+ "ISNULL(C_FUELPRICE,0)+ISNULL(C_AIRPORTFEE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0) DUTY,C_TUIFEE ,ISNULL(C_INSURANCEFEE,0) INSURFEE,"
					+ "C_PRINTTIME,C_STATE,[C_TUIFEIYUANYI],C_YIHAI,C_FKMETHOD ,"
					+ "dbo.F_GetAgentName(C_CUSTOMERUSERID,C_CUSTOMERAGENTID) AS AGENTNAME ,"
					+ "AIRFLIGHTNUMBER  as hangbanhao,"
					+ "(SELECT TOP 1 C_MEMBERNAME FROM view_orderrc_custuser vth WHERE vth.C_ORDERINFOID=vp.C_ORDERID AND vth.C_STATE=3) AS CPNAME,(SELECT TOP 1 C_CREATETIME FROM T_ORDERINFORC RC WHERE RC.C_ORDERINFOID=vp.C_ORDERID AND RC.C_STATE IN(11,12,7,17)) AS TFTIME ,"
					+ "(SELECT TOP 1 C_MEMBERNAME FROM view_orderrc_custuser vth WHERE vth.C_ORDERINFOID=vp.C_ORDERID AND vth.C_STATE IN (11,12,7,17)) AS TFNAME "
					+ "FROM  [view_pas_order_seng] vp"
					+ " WHERE  C_STATE IN ("
					+ statestr
					+ ") AND C_TUITIME IS NOT NULL AND CONVERT(DATE,C_RTTIME,23)"
					+ operate + "CONVERT(DATE,C_TUITIME,23)";
			String salewhere = "";
			if (s_department != null && s_department.trim().length() != 0) {// 部门
				String deptstr = "";
				if (s_department.indexOf("c") >= 0) {
					long deptid = Long.valueOf(s_department.substring(1));
					this.departname = Server.getInstance().getMemberService()
							.findCustomeragent(deptid).getAgentcontactname();
					deptstr = getSubDetpt(deptid);
				} else {
					long deptid = Long.valueOf(s_department.substring(0,
							s_department.indexOf("@")));
					this.departname = Server.getInstance().getMemberService()
							.findDepartment(deptid).getName();
					deptstr = getSubDetpt(deptid);
				}
				// salewhere = " AND C_SALEAGENTID " + " in ( SELECT ID FROM "
				// + Customeruser.TABLE + " WHERE "
				// + Customeruser.COL_deptid + " IN (" + deptstr + ")";
				sql += " AND C_ORDERID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
						+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID  IN("
						+ deptstr + ") ) AND C_STATE NOT IN(0) )";

			}

			/*
			 * 舱位 检索条件列表：部门、预订人、联系人、乘机人、出票人、退废票人、
			 * 出票日期起止、废票日期起止、退票日期起止、票号、订单编号、航班、
			 * 舱位、支付方式、付款方式、机票类型、客户类型、退废票状态、退废票类型；
			 */
			if (s_ordername != null && s_ordername.trim().length() > 0) {// 预订人
				if (salewhere.length() == 0)
					salewhere += " AND "
							+ Orderinfo.COL_saleagentid
							+ " IN ( SELECT ID FROM [T_CUSTOMERUSER] WHERE [C_MEMBERNAME] LIKE '%"
							+ s_ordername + "%' ";
				else {
					salewhere += " AND [C_MEMBERNAME] LIKE '%" + s_ordername
							+ "%' ";
				}
			}

			if (custype > 0) {
				if (custype == 1) {// 大客户
					sql += " AND "
							+ Orderinfo.COL_buyagentid
							+ " IN (SELECT ID FROM T_CUSTOMERAGENT WHERE  C_BIGTYPE=1 )";
				} else if (custype == 2) {// 所有散客
					sql += "  AND " + Orderinfo.COL_buyagentid + "=46";
				} else if (custype == 3) {// 当月散客
					sql += "  AND "
							+ Orderinfo.COL_buyagentid
							+ "=46 AND SUBSTRING(convert(varchar,C_PRINTTIME),1,7)=(SELECT SUBSTRING(convert(varchar,C_CREATETIME),1,7) FROM T_CUSTOMERUSER  WHERE ID=C_CUSTOMERUSERID )";

				} else if (custype == 4) {// 非当月散客
					sql += " AND "
							+Orderinfo.COL_buyagentid
							+ "=46 AND SUBSTRING(convert(varchar,C_PRINTTIME),1,7)<>(SELECT SUBSTRING(convert(varchar,C_CREATETIME),1,7) FROM T_CUSTOMERUSER  WHERE ID=C_CUSTOMERUSERID )";
				} else if (custype == 5) {
					if (salewhere.length() == 0) {
						salewhere += " AND "
								+ Orderinfo.COL_saleagentid
								+ " IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_AGENTID IN(SELECT ID FROM T_CUSTOMERAGENT WHERE C_BIGTYPE =0 AND C_AGENTTYPE=3)";
					} else {
						salewhere += " AND  C_AGENTID IN(SELECT ID FROM T_CUSTOMERAGENT WHERE C_BIGTYPE =0 AND C_AGENTTYPE=3)";
					}
				}
			}

			if (salewhere.length() > 0)
				salewhere += ")";
			sql += salewhere;

			if (this.s_internal > -1) {

				sql += " AND C_INTERNAL =" + s_internal;

			}
			if (this.tickettype > 0) {// 机票类型
				sql += " AND C_TICKETTYPEID=" + tickettype;
			}
			String timewhere = this.getCheckTime(s_begintime, s_endtime,
					Passenger.COL_rttime);

			if (timewhere.length() > 0) {// 出票时间
				sql += " AND (" + timewhere + ")";
			}
			String ttime = this.getCheckTime(t_begintime, t_endtime,
					Passenger.COL_tuifeitime);
			if (ttime.length() > 0) {// 退票时间
				sql += " AND (" + ttime + ") AND " + Passenger.COL_state + "="
						+ 3;
			}
			String ftime = this.getCheckTime(f_begintime, f_endtime,
					Passenger.COL_tuifeitime);
			if (ftime.length() > 0) {// 废票时间
				sql += " AND (" + ftime + ") AND " + Passenger.COL_state + "="
						+ 2;
			}
			if (s_linkname != null && s_linkname.trim().length() > 0) {// 联系人
				sql += " AND " + Orderinfo.COL_contactname + " LIKE '%"
						+ s_linkname + "%'";
			}

			if (s_ticketname != null && s_ticketname.trim().length() > 0) {// 乘机人
				sql += " AND " + Passenger.COL_name + " LIKE '%" + s_ticketname
						+ "%'";
			}
			String ctfsql = "";// 出票，退票，废票 人查询sql

			if (s_chuname != null && s_chuname.length() > 0) {// 出票人
				ctfsql = " AND C_ORDERID "
						+ " IN (SELECT C_ORDERINFOID FROM  [T_ORDERINFORC]  WHERE "
						+ Orderinforc.COL_state
						+ " IN (3,29) "
						+ " AND C_CUSTOMERUSERID IN(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ s_chuname + "%')) ";
			}
			if (s_tfname != null && s_tfname.trim().length() > 0) {
				if (ctfsql.length() == 0) {
					ctfsql = " AND C_ORDERID "
							+ " IN (SELECT C_ORDERINFOID FROM  [T_ORDERINFORC]  WHERE "
							+ Orderinforc.COL_state
							+ "IN (11,12) "
							+ " AND C_CUSTOMERUSERID IN(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfname + "%')) ";
				} else {
					ctfsql = "  AND C_ORDERID "
							+ " IN ( SELECT DISTINCT(C_ORDERINFOID) FROM T_ORDERINFORC WHERE C_STATE=3  "
							+ "AND C_CUSTOMERUSERID IN(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfname
							+ "%' )"
							+ "AND C_ORDERINFOID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE IN (11,12) AND "
							+ " C_CUSTOMERUSERID IN(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfname + "%' ))) ";
				}
			}

			sql += ctfsql;
			if (s_paymethod != -1) {// 支付方式
				sql += " AND " + Orderinfo.COL_paymethod + "=" + s_paymethod;
			}
			if (fkmethod != -1) {// 付款方式
				sql += " AND " + Orderinfo.COL_fkmethod + "=" + fkmethod;
			}

			if (s_ordernum != null && s_ordernum.trim().length() > 0) { // 订单号

				sql += " AND C_ORDERNUMBER LIKE '%" + s_ordernum + "%'";
			}
			if (this.piaohao != null && this.piaohao.trim().length() > 0) { // 票号

				sql += " AND C_TICKETNUM LIKE '%" + piaohao + "%'";
			}

			if (this.s_flight != null && s_flight.trim().length() > 0) {// 航班
				sql += " AND C_FLIGHTNUMBER LIKE '%" + s_flight + "%'";
			}
			if (this.s_cabin != null && this.s_cabin.trim().length() > 0) {// 舱位

				sql += " AND [C_CABINCODE] LIKE '%" + s_cabin + "%'";

			}
			if (this.tftype > 0) {
				sql += " AND C_TUIFEIYUANYI=" + tftype;
			}
			this.getGather(sql);
			if (isExp) {
				return sql;
			} else {
				datefeilist = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, pageinfo);
				pageinfo = (PageInfo) datefeilist.remove(0);
			}
		}

		long[] arrayagentid = { 46 };
		// this.getDepttreestr(1l, arrayagentid, true);
		return "datefei";
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public List airreportsumall() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (s_begintime == null || s_begintime.trim().length() == 0) {
			s_begintime = dateFormat.format(new Timestamp(System
					.currentTimeMillis()).getTime());
		}
		if (s_endtime == null || s_endtime.trim().length() == 0) {
			s_endtime = dateFormat.format(new Timestamp(System
					.currentTimeMillis()).getTime());
			;
		}
		String sql = "SELECT CONVERT(varchar(12) , b.C_CREATETIME, 102 ) as r_time, "
				+ "c.C_AIRCOMAPNYCODE as r_aircomapnycode,"
				+ "SUM(b.C_TOTALTICKETPRICE) as r_totalticketprice,"
				+ "COUNT(a.ID) as r_sum "
				+ "FROM T_PASSENGER a,T_ORDERINFO b,[T_SEGMENTINFO] c"
				+ " where a.C_ORDERID= b.ID and c.C_ORDERID=b.ID"
				+ " and b.C_CREATETIME >='"
				+ s_begintime
				+ " 00:00:00' "
				+ " and b.C_CREATETIME<='"
				+ s_endtime
				+ " 23:59:59' "
				+ "group by c.C_AIRCOMAPNYCODE,CONVERT(varchar(12),b.C_CREATETIME, 102)"
				+ " order by CONVERT(varchar(12) , b.C_CREATETIME, 102 )";
		return Server.getInstance().getSystemService().findMapResultBySql(sql,
				null);
	}

	/*
	 * public String airreportsum() { list = airreportsumall(); return
	 * "airreportsum"; }
	 */

	/*
	 * public void airreportsumdown() throws IOException, RowsExceededException,
	 * WriteException { list = airreportsumall(); String fileName = "航空公司.xls";
	 * HttpServletResponse response = ServletActionContext.getResponse();
	 * response.setContentType("application/vnd.ms-excel");
	 * response.setHeader("Content-Disposition", "attachment;filename=" + new
	 * String(fileName.getBytes("gb2312"), "ISO8859-1")); //
	 * response.setHeader("Content-Disposition", "attachment; filename=" + //
	 * java.net.URLEncoder.encode(fileName, "UTF-8")); WritableWorkbook workbook =
	 * Workbook.createWorkbook(response .getOutputStream()); WritableSheet sheet =
	 * workbook.createSheet("Sheet_1", 0); Label label0 = new Label(0, 0, "时间");
	 * sheet.addCell(label0); Label label1 = new Label(1, 0, "航空公司");
	 * sheet.addCell(label1); Label label2 = new Label(2, 0, "数量");
	 * sheet.addCell(label2); Label label3 = new Label(3, 0, "金额");
	 * sheet.addCell(label3); for (int i = 0; i < list.size(); i++) { Map map =
	 * (Map) list.get(i); String label0_0 = ""; if (map.get("r_time") != null) {
	 * label0_0 = map.get("r_time").toString(); } Label label00 = new Label(0, i +
	 * 1, label0_0); sheet.addCell(label00); String label1_1 = ""; if
	 * (map.get("r_aircomapnycode") != null) { label1_1 =
	 * map.get("r_aircomapnycode").toString(); } Label label11 = new Label(1, i +
	 * 1, label1_1); sheet.addCell(label11); String label2_2 = ""; if
	 * (map.get("r_sum") != null) { label2_2 = map.get("r_sum").toString(); }
	 * Label label22 = new Label(2, i + 1, label2_2); sheet.addCell(label22);
	 * String label3_3 = ""; if (map.get("r_totalticketprice") != null) {
	 * label3_3 = map.get("r_totalticketprice").toString(); } Label label33 =
	 * new Label(3, i + 1, label3_3); sheet.addCell(label33); }
	 * workbook.write(); workbook.close(); }
	 */

	public List airreportdetailall() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (s_begintime == null || s_begintime.trim().length() == 0) {
			s_begintime = dateFormat.format(new Timestamp(System
					.currentTimeMillis()).getTime());
		}
		if (s_endtime == null || s_endtime.trim().length() == 0) {
			s_endtime = dateFormat.format(new Timestamp(System
					.currentTimeMillis()).getTime());
			;
		}

		String sql = "SELECT a.[C_TICKETNUM] as r_ticketnum,"
				+ " (b.C_STARTAIRPORT+b.C_ENDAIRPORT) as r_segmentinfo,"
				+ " c.C_PRINTTIME as r_printtime,"
				+ " a.C_PRICE as r_price,"
				+ " a.C_FUELPRICE as r_fuelprice,"
				+ " a.C_AIRPORTFEE as r_airporttee,"
				+ " c.C_CREATETIME as r_createtime,"
				+ " (select C_NAME FROM T_CUSTOMERUSER where ID=c.C_CUSTOMERUSERID )as r_createname,"
				+ " b.C_FLIGHTNUMBER as r_flightnumber,"
				+ " c.C_PNR as r_pnr,"
				+ " a.C_NAME as r_passengeruser,"
				+ " b.C_DEPARTTIME as r_departtime,"
				+ " b.C_CABINCODE as r_cabincode,"
				+ " a.C_FUELPRICE+a.C_AIRPORTFEE as r_fee,"
				+ " c.C_ORDERSTATUS as r_orderstate,"
				+ " c.C_MEMO as r_memo,"
				+ " c.C_CONTACTNAME as r_comtactname"
				+ " FROM [T_PASSENGER] as a, [T_SEGMENTINFO] as b,[T_ORDERINFO] as c"
				+ " where a.C_ORDERID=c.ID and b.C_ORDERID=c.ID and c.C_CREATETIME>='"
				+ s_begintime + " 00:00:00' and C_CREATETIME<='" + s_endtime
				+ " 23:59:59'";
		System.out.println(sql);
		if (s_createuser != null && s_createuser.trim().length() > 0) {
			sql += " and c.C_CUSTOMERUSERID in ( select ID from T_CUSTOMERUSER where C_MEMBERNAME='"
					+ s_createuser + "')";
		}
		if (s_department != null && s_department.trim().length() > 0) {
			sql += " and c.C_CUSTOMERUSERID in ( select ID from T_CUSTOMERUSER where C_DEPTID = "
					+ s_department + " )";
		}
		return Server.getInstance().getSystemService().findMapResultBySql(sql,
				null);
	}

	public List airreportsumdatail() {
		String sql = " SELECT COUNT(ID)as r_sum,SUM([C_PRICE]+[C_FUELPRICE]+[C_AIRPORTFEE]) as r_tatal from T_PASSENGER "
				+ " Where C_ORDERID in (Select ID from T_ORDERINFO where C_CREATETIME>='"
				+ s_begintime
				+ " 00:00:00' and C_CREATETIME<='"
				+ s_endtime
				+ " 23:59:59')";
		if (s_createuser != null && s_createuser.trim().length() > 0) {
			sql += " and C_ORDERID in (Select ID from T_ORDERINFO where C_CUSTOMERUSERID in ( select ID from T_CUSTOMERUSER where C_MEMBERNAME='"
					+ s_createuser + "'))";
		}
		if (s_department != null && s_department.trim().length() > 0) {
			sql += "and C_ORDERID in (Select ID from T_ORDERINFO where C_CUSTOMERUSERID in ( select ID from T_CUSTOMERUSER where C_DEPTID = "
					+ s_department + " ))";
		}
		System.out.println(sql);
		return Server.getInstance().getSystemService().findMapResultBySql(sql,
				null);
	}

	public String airreportdetail() {
		String ticketwhere = " WHERE 1=1 ";
		listtickettype = Server.getInstance().getMemberService()
				.findAllTickettype(ticketwhere, "", -1, 0);
		long[] arrayagentid = { 46 };
		// this.getDepttreestr(1l, arrayagentid, true);

		if (is_first != null) {
			String timewhere = this.getCheckTime(s_begintime, s_endtime,
					Orderinfo.COL_printtime);
			String where = " WHERE "
					+ " C_ORDERSTATUS NOT IN (2,6,9,11,12,16,18,19,27) ";
			if (timewhere.length() > 0) {
				where += " AND (" + timewhere + ")";
			}

			if (this.s_ordernum != null && s_ordernum.trim().length() > 0) {// 订单号
				where += " AND " + Orderinfo.COL_ordernumber + " LIKE '%"
						+ s_ordernum + "%' ";
			}
			if (this.s_linkname != null && this.s_linkname.trim().length() > 0) {// 联系人
				where += " AND " + Orderinfo.COL_contactname + " LIKE '%"
						+ s_linkname + "%' ";
			}
			if (this.s_internal > -1) {

				where += " AND C_INTERNAL =" + s_internal;

			}
			if (this.tickettype > 0) {
				where += " AND  ID=(SELECT C_ORDERID FROM T_PASSENGER WHERE T_PASSENGER.C_ORDERID=T_ORDERINFO.ID AND C_TICKETTYPEID="
						+ tickettype + ")";
			}
			String tempwhere = "";
			String salewhere = "";
			if (s_department != null && s_department.trim().length() != 0) {// 部门
				String deptstr = "";
				if (s_department.indexOf("c") >= 0) {
					long deptid = Long.valueOf(s_department.substring(1));
					this.departname = Server.getInstance().getMemberService()
							.findDepartment(deptid).getName();
					deptstr = getSubDetpt(deptid);
				} else {
					long deptid = Long.valueOf(s_department.substring(0,
							s_department.indexOf("@")));
					this.departname = Server.getInstance().getMemberService()
							.findDepartment(deptid).getName();
					deptstr = getSubDetpt(deptid);
				}
				salewhere = " AND " + Orderinfo.COL_saleagentid + " in (";
				tempwhere = " SELECT ID FROM " + Customeruser.TABLE + " WHERE "
						+ Customeruser.COL_deptid + " IN  (" + deptstr + ")";
			}
			if (s_ordername != null && s_ordername.trim().length() > 0) {// 预订人
				if (salewhere.length() == 0) {
					salewhere += " AND "
							+ Orderinfo.COL_saleagentid
							+ " IN ( SELECT ID FROM [T_CUSTOMERUSER] WHERE [C_MEMBERNAME] LIKE '%"
							+ s_ordername + "%' ";
				} else {
					tempwhere += " AND  [C_MEMBERNAME] LIKE '%" + s_ordername
							+ "%' ";
				}
			}
			if (s_chuname != null && s_chuname.length() > 0) {// 出票人
				where += " AND "
						+ Orderinfo.COL_id
						+ " IN (SELECT C_ORDERINFOID FROM  [T_ORDERINFORC]  WHERE "
						+ Orderinforc.COL_state
						+ "="
						+ 3
						+ " AND C_CUSTOMERUSERID IN(  SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
						+ s_chuname + "%' ) )";
			}
			if (s_paymethod != -1) {// 支付方式
				where += " AND " + Orderinfo.COL_paymethod + "=" + s_paymethod;
			}
			if (fkmethod != -1) {// 付款方式
				where += " AND " + Orderinfo.COL_fkmethod + "=" + fkmethod;
			}
			if (custype > 0) {
				if (custype == 1) {// 大客户
					where += " AND "
							+ Orderinfo.COL_buyagentid
							+ " IN (SELECT ID FROM T_CUSTOMERAGENT WHERE  C_BIGTYPE=1 )";
				} else if (custype == 2) {// 所有散客
					where += "  AND " + Orderinfo.COL_buyagentid + "=46";
				} else if (custype == 3) {// 当月散客
					where += "  AND "
							+ Orderinfo.COL_buyagentid
							+ "=46 AND SUBSTRING(convert(varchar,C_PRINTTIME),1,7)=(SELECT SUBSTRING(convert(varchar,C_CREATETIME),1,7) FROM T_CUSTOMERUSER  WHERE ID=T_ORDERINFO.C_CUSTOMERUSERID )";

				} else if (custype == 4) {// 非当月散客
					where += " AND "
							+ Orderinfo.COL_buyagentid
							+ "=46 AND SUBSTRING(convert(varchar,C_PRINTTIME),1,7)<>(SELECT SUBSTRING(convert(varchar,C_CREATETIME),1,7) FROM T_CUSTOMERUSER  WHERE ID=T_ORDERINFO.C_CUSTOMERUSERID )";
				} else if (custype == 5) {
					if (salewhere.length() == 0) {
						salewhere += " AND "
								+ Orderinfo.COL_saleagentid
								+ " IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_AGENTID IN(SELECT ID FROM T_CUSTOMERAGENT WHERE C_BIGTYPE =0 AND C_AGENTTYPE=3)";
					} else {
						tempwhere += " AND  C_AGENTID IN(SELECT ID FROM T_CUSTOMERAGENT WHERE C_BIGTYPE =0 AND C_AGENTTYPE=3)";
					}
				}
			}
			String passwhere = "";
			if (s_ticketname != null && s_ticketname.trim().length() > 0) {// 乘机人
				passwhere = "  AND "
						+ Orderinfo.COL_id
						+ " IN (SELECT C_ORDERID FROM T_PASSENGER WHERE C_NAME LIKE '%"
						+ s_ticketname + "%'";
			}
			if (this.piaohao != null && this.piaohao.trim().length() > 0) {// 票号
				if (passwhere.length() == 0) {
					passwhere = "  AND "
							+ Orderinfo.COL_id
							+ " IN (SELECT C_ORDERID FROM T_PASSENGER WHERE C_TICKETNUM LIKE '%"
							+ piaohao + "%'";
				} else {
					passwhere += " AND  C_TICKETNUM LIKE '%" + piaohao + "%'";
				}
			}
			if (passwhere.length() > 0) {
				passwhere += ")";
			}
			where += passwhere;
			// if(tempwhere.length()>0){
			// tempwhere+=")";
			// }
			salewhere += tempwhere;
			if (salewhere.length() > 0) {
				salewhere += ")";
			}
			where += salewhere;
			String flightwhere = "";
			if (this.s_flight != null && s_flight.trim().length() > 0) {
				flightwhere += " AND  "
						+ Orderinfo.COL_id
						+ " IN (SELECT C_ORDERID FROM T_SEGMENTINFO WHERE C_FLIGHTNUMBER LIKE '%"
						+ s_flight + "%'";
			}
			if (this.s_cabin != null && this.s_cabin.trim().length() > 0) {
				if (flightwhere.length() == 0) {
					flightwhere += " AND  "
							+ Orderinfo.COL_id
							+ " IN (SELECT C_ORDERID FROM T_SEGMENTINFO WHERE [C_CABINCODE] LIKE '%"
							+ s_cabin + "%'";
				} else {
					flightwhere += " AND [C_CABINCODE] LIKE '%" + s_cabin
							+ "%'";
				}
			}
			if (flightwhere.length() > 0) {
				flightwhere += ")";
			}
			where += flightwhere;
			if (isExp) {
				return where;
			} else {
				List list = Server.getInstance().getAirService()
						.findAllOrderinfoForPageinfo(where, "", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listorderinfos = (List<Orderinfo>) list;
			}

		}
		return "airreportdetail";
	}

	public String getAgentNameOfOrder(Orderinfo order) {
		if (converNull(order.getCustomeragentid(), 0l) == 46) {
			return order.getContactname();
		} else {
			Customeragent agetn = null;
			try {
				agetn = Server.getInstance().getMemberService()
						.findCustomeragent(order.getCustomeragentid());
			} catch (Exception e) {
				System.out.println("Exception:********");
				System.out.println(order.getId());
			}
			if (agetn != null) {
				String depetname = "";
				String where = " WHERE ID=(SELECT ISNULL(C_DEPTID,0) FROM T_CUSTOMERUSER WHERE ID="
						+ order.getCustomeruserid() + " )";
				List<Department> depts = Server.getInstance()
						.getMemberService().findAllDepartment(where, "", -1, 0);
				if (depts.size() > 0) {
					depetname = depts.get(0).getName();
				}
				if (depetname != null && depetname.length() > 0) {
					String shortname = agetn.getAgentshortname();
					if (this.isNullorSpace(shortname)) {
						shortname = agetn.getAgentcompanyname();
					}
					return shortname + "/" + depetname;
				} else {
					String shortname = agetn.getAgentshortname();
					if (this.isNullorSpace(shortname)) {
						return agetn.getAgentcompanyname();
					}
					return shortname;
				}
			}
			return "";
		}
	}

	public void addExcelOptions(HthyWorkSheet sheet) {

	}

	public String getAgentNameOfOrderById(long orderid) {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(orderid);
		return this.getAgentNameOfOrder(orderinfo);
	}

	private boolean isExp = false;

	/**
	 * 加盟商盈利报表
	 */
	public void expOperatorExcel() throws Exception {
		String sql = "";
		try {
			HthyWritableWorkBook.SEARCHNUM += 1;
			isExp = true;
			sql = this.operatorsreport();
			pageinfo.setPagerow(2000);
			this.listrebaterecord = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, pageinfo);
			pageinfo = (PageInfo) listrebaterecord.remove(0);
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
			e.printStackTrace();
		}
		String name = "运营商盈利报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		String[] titleles = { "代理商类型", "代理商名称", "关联订单", "返佣业务", "返佣商类型",
				"返佣商名称", "返佣值", "返佣时间", "备注", };
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("运营商盈利报表",
				titleles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow("运营商盈利报表", 3);
		sheet.createOneRow("${dns.companyname}商旅中心电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		// sheet.createOneRow("检索条件：");
		// addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);

		Map map = null;
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = listrebaterecord.size();
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					map = (HashMap) listrebaterecord.remove(0);
					// sheet.addCell(getAgentTypeName(Long.valueOf(converNull(
					// map.get("REBATAGENTRANK"), -1).toString())));
					sheet.addCell("");
					sheet.addCell(map.get("REBATAGENTNAME"));
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(getyewuleixing(Integer.valueOf(converNull(
							map.get("C_YEWUTYPE"), -1).toString())));// 机票类型,C_FKMETHOD
					// sheet.addCell(getAgentTypeName(Long.valueOf(converNull(
					// map.get("CHILDAGENTRANK"), -1).toString())));

					sheet.addCell("");
					sheet.addCell(map.get("CHILDAGENTNAME"));
					sheet.addCell(map.get("C_REBATEMONEY"));
					sheet.addCell(formatStringTime(converNull(
							map.get("C_REBATETIME"), "").toString()));
					sheet.addCell(map.get("C_REBATEMEMO"));
					if (i % 300 == 0) {
						book.flush();
						book.write();
					}
					sheet.rowOver();
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					listrebaterecord = Server.getInstance().getSystemService()
							.findMapResultBySql(sql, pageinfo);
					pageinfo = (PageInfo) listrebaterecord.remove(0);
				} else {
					break;
				}

			}
			System.gc();

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
	public void expChupiaoExcel() throws Exception {
		Customeragent longinagent = this.getLoginsessionagent();
		System.out.println(longinagent.getAgenttype());
		HttpServletRequest request = ServletActionContext.getRequest();
		long agid = this.customeragent.getId();
		StringBuilder where = new StringBuilder(" where 1=1 ");
		if (tftype > 0) {

			where.append("  AND C_ORDERSTATUS =" + tftype);
		} else {

			where
					.append("  AND C_ORDERSTATUS =3 ");
		}
		if (longinagent.getAgenttype() != 2) {
			if (agid!=0) {					
				if (agid < 0) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
									+ (0 - agid));
					if (longinagent.getAgenttype() != 1) {
						where
								.append("  AND  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ");
					}
					where.append(")");
				} else {
					where.append(" AND C_BUYAGENTID=" + agid);
				}
			} else {
				if (longinagent.getAgenttype() != 1) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
									+ longinagent.getId()
									+ "  OR  charindex(','+CONVERT(nvarchar,"
									+ longinagent.getId()
									+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
				}
			}
		} else {
			where.append(" AND " + Orderinfo.COL_policyagentid + "="
					+ longinagent.getId());

		}
		
		if (isNotNullOrEpt(this.s_ordernum)) {
			where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
		}
		if (!isNullorSpace(s_ordername)) {// 预订人
			where
					.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_ordername + "%')");
		}
		if (!isNullorSpace(s_chuname)) {// 出票人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_chuname + "%' ) )");
		}
		String cptime = this.getCheckTime(s_begintime, s_endtime,
				"C_PRINTTIME");// 出票时间
		if (cptime.length() > 0) {
			where.append(" AND (" + cptime + ") ");

		}
		String ydtime = this.getCheckTime(orderstime, orderetime,
				Orderinfo.COL_createtime);// 预订时间
		if (ydtime.length() > 0) {
			where.append(" AND (" + ydtime + ") ");

		}
		if (!isNullorSpace(s_shouyinname)) {// 收银人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shouyinname + "%' ) AND C_STATE  =10 )");
		}
		String shoutime = this.getCheckTime(this.shou_begintime,
				this.shou_endtime, "C_CREATETIME");
		if (shoutime.length() > 0) {// 收银时间
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
							+ shoutime + ") )");
		}
		if (!this.isNullorSpace(sqname)) {// 申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ sqname + "%' ) AND C_STATE IN (4,5) )");
		}
		String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
				"C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
							+ sqtime + "))");
		}
		if (!this.isNullorSpace(shname)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
		}
		String shtime = this.getCheckTime(sh_begintime, sh_endtime,
				"C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
							+ shtime + "))");
		}
		if (!this.isNullorSpace(tkname)) {// 退款人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ tkname + "%' ) AND C_STATE IN (9,18) )");
		}
		String tktime = this.getCheckTime(tk_begintime, tk_endtime,
				"C_CREATETIME");// 退款时间
		if (tktime.length() > 0) {
			where
					.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
							+ tktime + "))");
		}
		if (!isNullorSpace(piaohao)) {// 票号

			where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
		}
		if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

			where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
		}
		String flitime = this.getCheckTime(this.flight_begintime, "",
				Segmentinfo.COL_departtime);
		if (flitime.length() > 0) {// 航班日期
			where
					.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
							+ flitime + ")");
		}
		if (!isNullorSpace(s_pnr)) {// PNR
			where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
					+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
		}
		if (!isNullorSpace(s_airname)) {// 航空公司

			where.append(" AND AIRNAME LIKE '%" + s_airname + "%'");
		}
		if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
			where.append(" AND C_CABINCODE = '" + s_cabin + "'");
		}
		System.out.println("chupiaoReport:" + where);
		
		
		List<Orderinfo> orderinfos=Server.getInstance().getAirService().findAllOrderinfo(where.toString(), " ORDER BY ID ", -1, 0);
		
		
		//List<Orderinfo> orderinfos=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID ", pageinfo);
		
		
		
		
		
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		
		
		ticketcount = pageinfo.getTotalrow();

		String name = "出票报表.xls";
		String nm="出票报表";
		if(tftype==18){
			name = "退票报表.xls";
			nm = "退票报表";
		}
		if(tftype==19){
			name = "废票报表.xls";
			nm = "废票报表";
		}
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		/*String[] titleles = { "订单号", "采购商", "PNR", "乘机人", "票号","人数", "航班号","折扣",
				"航班日期", "航程", "票面价", "订单返点","分销商返点","分销商返利", "税费", "保险", "结算价","支付方式" ,"机票状态" };*/
		
		String[] titleles = { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
				"分销商返点","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
	
		if(getLoginAgent().getAgenttype()==1){
			titleles = new String[]  { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险","分销商返点","本机留点","留点利润","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
		}else{
			titleles = new String[] { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
					"分销商返点","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
		
		
		}
		
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		Map<Integer,Integer> column=new HashMap<Integer,Integer>();
		column.put(2, 150);
		column.put(5, 120);
		HthyWorkSheet sheet = book.createHthyWorkSheet(nm,
				titleles.length + 10, 10000,column);
		sheet.createOneRow(nm, 3);
		sheet.createOneRow("电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		Map map = null;
		int ordercount = 0;
		float parprice = 0f;
		float allinsur = 0f;
		float allduty = 0f;
		float allzfgy=0f;
		try {
			int passsize=0;
			for (int x = 0; x < orderinfos.size(); x++) {
				
				Orderinfo orderinfo=orderinfos.get(x);
				
				List<String> lists = new ArrayList<String>();
				String html = "";
				String ticketnum="";
				String agentname="";
				String fnum="";
				String stime="";
				String xingcheng="";
				String piaomianjia="";
				
				
				Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
				List<Segmentinfo>listSegmentinfo=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
				List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" where 1=1 and "+Passenger.COL_orderid+" ="+orderinfo.getId()+" AND "+Passenger.COL_state+" <>12", "", -1, 0);
				agentname=customeragent.getAgentcompanyname();
				fnum=listSegmentinfo.get(0).getFlightnumber();
				stime=listSegmentinfo.get(0).getDeparttime()+"";
				xingcheng=getCitynameByAirport(listSegmentinfo.get(0).getStartairport())+"-"+getCitynameByAirport(listSegmentinfo.get(0).getEndairport());
				piaomianjia=listSegmentinfo.get(0).getParvalue()+"";
				
				//计算返利开始
				String fanli="";
				
				Float zratevalue=orderinfo.getRatevalue();
				Float agentvalue=orderinfo.getFenxiaoshangfandian();
				
				Float pvalue=listSegmentinfo.get(0).getParvalue();//票面价
				Float Yprice=listSegmentinfo.get(0).getYprice();//Y价格
				
				Float price=0f;
				Float shuifei=0f;
				Float baoxian=0f;
				if(listpass.size()>0){
					passsize+=listpass.size();
					for(int a=0;a<listpass.size();a++){
						
						
						
						Passenger passenger=listpass.get(a);
						if(passenger.getPtype()==1){//成人
							price+=pvalue;
						}
						if(passenger.getPtype()==2){//儿童
							
							
							if (listSegmentinfo.get(0).getDiscount() > 100) {
								
								price+=getRoundPrice(pvalue, 2);
								
							} else {
								
								price+=getRoundPrice(Yprice, 2);
							
							}
							
						}
						if(passenger.getPtype()==3){//婴儿
							
							// 儿童婴儿价
							if (listSegmentinfo.get(0).getDiscount() > 100) {
								price+=getRoundPrice(pvalue, 10);
								
							} else {
								price+=getRoundPrice(Yprice, 10);
								
							}
							
						}
						price+=passenger.getFuelprice();
						price+=passenger.getAirportfee();
						
					
						shuifei+=passenger.getFuelprice();
						shuifei+=passenger.getAirportfee();
						baoxian+=passenger.getInsurprice();
						
						String pastate="已出票";
						String lodstate="("+pastate+")";
						if(passenger.getState()==4){
							pastate="退票";
						}
						if(passenger.getState()==5){
							pastate="废票";
						}
						if(passenger.getState()==6){
							pastate="改签";
						}
						lodstate="("+pastate+")";
						html += passenger.getName()+lodstate + "<br/>";
						ticketnum +=passenger.getTicketnum() + "<br/>";
						
						
					}
				}
				Float retprice=	price-(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice());	
				
				fanli=retprice+"";
				//计算结束
				
				
				
				
				lists.add(html);//乘机人 0
				lists.add(ticketnum);//票号 1
				lists.add(agentname);// 加盟商名字 2
				lists.add(fnum);//航班号 3
				lists.add(stime);// 出发时间 4
				lists.add(xingcheng);//行程 5
				lists.add(piaomianjia);//票面价 6
				lists.add(fanli);// 返利 7
				lists.add(shuifei+"");// 税费 8
				lists.add(baoxian+"");// 保险 9
				lists.add(price+"");// 总票面价 10
				lists.add(listpass.size()+"");// 总人数 11
				
				lists.add(listSegmentinfo.get(0).getDiscount()+"");//  折扣 12
				
				//计算总票面价
				parprice+=price;
				//计算总税费
				allduty+=shuifei;
				//计算总保险
				allinsur+=baoxian;
				//计算总结算价
				allzfgy+=orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice();
					
					
		//String[] titleles = { "订单号", "采购商", "PNR", "乘机人", "票号","人数", "航班号","折扣",
		//					"航班日期", "航程", "票面价", "订单返点","分销商返点","分销商返利", "税费", "保险", "结算价","支付方式" ,"机票状态" };
					
		//开始创建
				
				
			//	String[] titleles = { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
			//			"返点","分销商返点","分销商返利", "结算价", "航班日期", "航班号","舱位","保险", "销售员", "单位", "支付方式","备注"  };
				
				
					sheet.createRow();
					
					sheet.addCell(orderinfo.getOrdernumber());//订单号
					sheet.addCell(orderinfo.getPnr());//PNR
					sheet.addCell(html.replace("<br/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);//乘机人\
					sheet.addCell(ticketnum.replace("<br/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);//票号
					sheet.addCell(listpass.size());//人数
					sheet.addCell(xingcheng);//航程
					sheet.addCell(piaomianjia);//票面价
					sheet.addCell(listSegmentinfo.get(0).getDiscount());//折扣
					sheet.addCell(shuifei);//税费
					sheet.addCell(price);//总票面价
					sheet.addCell(baoxian);//保险
					
					//sheet.addCell(orderinfo.getRatevalue());//订单返点
					sheet.addCell(orderinfo.getFenxiaoshangfandian());//分销商返点
					if(getLoginAgent().getAgenttype()==1){
						
						sheet.addCell(orderinfo.getRatevalue()-orderinfo.getFenxiaoshangfandian());//分销商返点
						sheet.addCell(orderinfo.getB2cprofit());//留点利润
					}
					sheet.addCell(fanli);//分销商返利
					sheet.addCell(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice()+baoxian);//结算价
					sheet.addCell(stime);//航班日期
					sheet.addCell(orderinfo.getPrinttime());//出票日期
					sheet.addCell(fnum);//航班号
					sheet.addCell(listSegmentinfo.get(0).getCabincode());//舱位
					
					sheet.addCell(orderinfo.getCustomeruserid());//销售员
					sheet.addCell(agentname);//采购商
					sheet.addCell(getPayMethod(orderinfo.getPaymethod()));//支付方式
					//sheet.addCell(orderinfo.getMemo());//备注
					sheet.addCell(getOrderStatestr(orderinfo.getOrderstatus()));//备注
					
					
					
					
					
					
					
					
					
					
				
					
					//
					

		//创建结束			
					sheet.rowOver();
				
				

			}
			System.gc();
			sheet.createOneRow(new String[] { "总订单数：",
					String.valueOf(orderinfos.size()) });
			sheet.createOneRow(new String[] { "总人数：",
					String.valueOf(passsize) });
			sheet
					.createOneRow(new String[] { "总票面价：",
							String.valueOf(parprice) });
			sheet.createOneRow(new String[] { "总税费：",
					String.valueOf(formatMoney(allduty)) });
			sheet.createOneRow(new String[] { "总保险：",
					String.valueOf(formatMoney(allinsur)) });
			if(this.getLoginsessionagent().getAgenttype()==1){
			sheet.createOneRow(new String[] { "总结算价：",
					String.valueOf(formatMoney(allzfgy)) });
			}
			
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
	public void expChupiaoExcel_9c() throws Exception {
		Customeragent longinagent = this.getLoginsessionagent();
		System.out.println(longinagent.getAgenttype());
		HttpServletRequest request = ServletActionContext.getRequest();
		long agid = this.customeragent.getId();
		StringBuilder where = new StringBuilder(" where 1=1 ");
		if (tftype > 0) {

			where.append("  AND C_ORDERSTATUS =" + tftype);
		} else {

			where
					.append("  AND C_ORDERSTATUS =3 ");
		}
		if (longinagent.getAgenttype() != 2) {
			if (agid!=0) {					
				if (agid < 0) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
									+ (0 - agid));
					if (longinagent.getAgenttype() != 1) {
						where
								.append("  AND  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ");
					}
					where.append(")");
				} else {
					where.append(" AND C_BUYAGENTID=" + agid);
				}
			} else {
				if (longinagent.getAgenttype() != 1) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
									+ longinagent.getId()
									+ "  OR  charindex(','+CONVERT(nvarchar,"
									+ longinagent.getId()
									+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
				}
			}
		} else {
			where.append(" AND " + Orderinfo.COL_policyagentid + "="
					+ longinagent.getId());

		}
		
		if (isNotNullOrEpt(this.s_ordernum)) {
			where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
		}
		if (!isNullorSpace(s_ordername)) {// 预订人
			where
					.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_ordername + "%')");
		}
		if (!isNullorSpace(s_chuname)) {// 出票人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_chuname + "%' ) )");
		}
		String cptime = this.getCheckTime(s_begintime, s_endtime,
				"C_PRINTTIME");// 出票时间
		if (cptime.length() > 0) {
			where.append(" AND (" + cptime + ") ");

		}
		String ydtime = this.getCheckTime(orderstime, orderetime,
				Orderinfo.COL_createtime);// 预订时间
		if (ydtime.length() > 0) {
			where.append(" AND (" + ydtime + ") ");

		}
		if (!isNullorSpace(s_shouyinname)) {// 收银人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shouyinname + "%' ) AND C_STATE  =10 )");
		}
		String shoutime = this.getCheckTime(this.shou_begintime,
				this.shou_endtime, "C_CREATETIME");
		if (shoutime.length() > 0) {// 收银时间
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
							+ shoutime + ") )");
		}
		if (!this.isNullorSpace(sqname)) {// 申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ sqname + "%' ) AND C_STATE IN (4,5) )");
		}
		String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
				"C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
							+ sqtime + "))");
		}
		if (!this.isNullorSpace(shname)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
		}
		String shtime = this.getCheckTime(sh_begintime, sh_endtime,
				"C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
							+ shtime + "))");
		}
		if (!this.isNullorSpace(tkname)) {// 退款人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ tkname + "%' ) AND C_STATE IN (9,18) )");
		}
		String tktime = this.getCheckTime(tk_begintime, tk_endtime,
				"C_CREATETIME");// 退款时间
		if (tktime.length() > 0) {
			where
					.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
							+ tktime + "))");
		}
		if (!isNullorSpace(piaohao)) {// 票号

			where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
		}
		if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

			where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
		}
		String flitime = this.getCheckTime(this.flight_begintime, "",
				Segmentinfo.COL_departtime);
		if (flitime.length() > 0) {// 航班日期
			where
					.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
							+ flitime + ")");
		}
		if (!isNullorSpace(s_pnr)) {// PNR
			where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
					+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
		}
		
		where.append("  AND ID IN( SELECT "+Segmentinfo.COL_orderid+" FROM T_SEGMENTINFO where "+Segmentinfo.COL_aircomapnycode+" ='9C' )");
		
		
		if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
			where.append(" AND C_CABINCODE = '" + s_cabin + "'");
		}
		System.out.println("chupiaoReport:" + where);
		
		
		List<Orderinfo> orderinfos=Server.getInstance().getAirService().findAllOrderinfo(where.toString(), " ORDER BY ID ", -1, 0);
		
		
		//List<Orderinfo> orderinfos=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID ", pageinfo);
		
		
		
		
		
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		
		
		ticketcount = pageinfo.getTotalrow();

		String name = "出票报表.xls";
		String nm="出票报表";
		if(tftype==18){
			name = "退票报表.xls";
			nm = "退票报表";
		}
		if(tftype==19){
			name = "废票报表.xls";
			nm = "废票报表";
		}
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		/*String[] titleles = { "订单号", "采购商", "PNR", "乘机人", "票号","人数", "航班号","折扣",
				"航班日期", "航程", "票面价", "订单返点","分销商返点","分销商返利", "税费", "保险", "结算价","支付方式" ,"机票状态" };*/
		
		String[] titleles = { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
				"分销商返点","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
	
		if(getLoginAgent().getAgenttype()==1){
			titleles = new String[]  { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险","分销商返点","本机留点","留点利润","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
		}else{
			titleles = new String[] { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
					"分销商返点","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
		
		
		}
		
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		Map<Integer,Integer> column=new HashMap<Integer,Integer>();
		column.put(2, 150);
		column.put(5, 120);
		HthyWorkSheet sheet = book.createHthyWorkSheet(nm,
				titleles.length + 10, 10000,column);
		sheet.createOneRow(nm, 3);
		sheet.createOneRow("电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		Map map = null;
		int ordercount = 0;
		float parprice = 0f;
		float allinsur = 0f;
		float allduty = 0f;
		float allzfgy=0f;
		try {
			int passsize=0;
			for (int x = 0; x < orderinfos.size(); x++) {
				
				Orderinfo orderinfo=orderinfos.get(x);
				
				List<String> lists = new ArrayList<String>();
				String html = "";
				String ticketnum="";
				String agentname="";
				String fnum="";
				String stime="";
				String xingcheng="";
				String piaomianjia="";
				
				
				Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
				List<Segmentinfo>listSegmentinfo=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
				List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" where 1=1 and "+Passenger.COL_orderid+" ="+orderinfo.getId()+" AND "+Passenger.COL_state+" <>12", "", -1, 0);
				agentname=customeragent.getAgentcompanyname();
				fnum=listSegmentinfo.get(0).getFlightnumber();
				stime=listSegmentinfo.get(0).getDeparttime()+"";
				xingcheng=getCitynameByAirport(listSegmentinfo.get(0).getStartairport())+"-"+getCitynameByAirport(listSegmentinfo.get(0).getEndairport());
				piaomianjia=listSegmentinfo.get(0).getParvalue()+"";
				
				//计算返利开始
				String fanli="";
				
				Float zratevalue=orderinfo.getRatevalue();
				Float agentvalue=orderinfo.getFenxiaoshangfandian();
				
				Float pvalue=listSegmentinfo.get(0).getParvalue();//票面价
				Float Yprice=listSegmentinfo.get(0).getYprice();//Y价格
				
				Float price=0f;
				Float shuifei=0f;
				Float baoxian=0f;
				if(listpass.size()>0){
					passsize+=listpass.size();
					for(int a=0;a<listpass.size();a++){
						
						
						
						Passenger passenger=listpass.get(a);
						if(passenger.getPtype()==1){//成人
							price+=pvalue;
						}
						if(passenger.getPtype()==2){//儿童
							
							
							if (listSegmentinfo.get(0).getDiscount() > 100) {
								
								price+=getRoundPrice(pvalue, 2);
								
							} else {
								
								price+=getRoundPrice(Yprice, 2);
							
							}
							
						}
						if(passenger.getPtype()==3){//婴儿
							
							// 儿童婴儿价
							if (listSegmentinfo.get(0).getDiscount() > 100) {
								price+=getRoundPrice(pvalue, 10);
								
							} else {
								price+=getRoundPrice(Yprice, 10);
								
							}
							
						}
						price+=passenger.getFuelprice();
						price+=passenger.getAirportfee();
						
					
						shuifei+=passenger.getFuelprice();
						shuifei+=passenger.getAirportfee();
						baoxian+=passenger.getInsurprice();
						
						String pastate="已出票";
						String lodstate="("+pastate+")";
						if(passenger.getState()==4){
							pastate="退票";
						}
						if(passenger.getState()==5){
							pastate="废票";
						}
						if(passenger.getState()==6){
							pastate="改签";
						}
						lodstate="("+pastate+")";
						html += passenger.getName()+lodstate + "<br/>";
						ticketnum +=passenger.getTicketnum() + "<br/>";
						
						
					}
				}
				Float retprice=	price-(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice());	
				
				fanli=retprice+"";
				//计算结束
				
				
				
				
				lists.add(html);//乘机人 0
				lists.add(ticketnum);//票号 1
				lists.add(agentname);// 加盟商名字 2
				lists.add(fnum);//航班号 3
				lists.add(stime);// 出发时间 4
				lists.add(xingcheng);//行程 5
				lists.add(piaomianjia);//票面价 6
				lists.add(fanli);// 返利 7
				lists.add(shuifei+"");// 税费 8
				lists.add(baoxian+"");// 保险 9
				lists.add(price+"");// 总票面价 10
				lists.add(listpass.size()+"");// 总人数 11
				
				lists.add(listSegmentinfo.get(0).getDiscount()+"");//  折扣 12
				
				//计算总票面价
				parprice+=price;
				//计算总税费
				allduty+=shuifei;
				//计算总保险
				allinsur+=baoxian;
				//计算总结算价
				allzfgy+=orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice();
					
					
		//String[] titleles = { "订单号", "采购商", "PNR", "乘机人", "票号","人数", "航班号","折扣",
		//					"航班日期", "航程", "票面价", "订单返点","分销商返点","分销商返利", "税费", "保险", "结算价","支付方式" ,"机票状态" };
					
		//开始创建
				
				
			//	String[] titleles = { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
			//			"返点","分销商返点","分销商返利", "结算价", "航班日期", "航班号","舱位","保险", "销售员", "单位", "支付方式","备注"  };
				
				
					sheet.createRow();
					
					sheet.addCell(orderinfo.getOrdernumber());//订单号
					sheet.addCell(orderinfo.getPnr());//PNR
					sheet.addCell(html.replace("<br/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);//乘机人\
					sheet.addCell(ticketnum.replace("<br/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);//票号
					sheet.addCell(listpass.size());//人数
					sheet.addCell(xingcheng);//航程
					sheet.addCell(piaomianjia);//票面价
					sheet.addCell(listSegmentinfo.get(0).getDiscount());//折扣
					sheet.addCell(shuifei);//税费
					sheet.addCell(price);//总票面价
					sheet.addCell(baoxian);//保险
					
					//sheet.addCell(orderinfo.getRatevalue());//订单返点
					sheet.addCell(orderinfo.getFenxiaoshangfandian());//分销商返点
					if(getLoginAgent().getAgenttype()==1){
						
						sheet.addCell(orderinfo.getRatevalue()-orderinfo.getFenxiaoshangfandian());//分销商返点
						sheet.addCell(orderinfo.getB2cprofit());//留点利润
					}
					sheet.addCell(fanli);//分销商返利
					sheet.addCell(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice()+baoxian);//结算价
					sheet.addCell(stime);//航班日期
					sheet.addCell(orderinfo.getPrinttime());//出票日期
					sheet.addCell(fnum);//航班号
					sheet.addCell(listSegmentinfo.get(0).getCabincode());//舱位
					
					sheet.addCell(orderinfo.getCustomeruserid());//销售员
					sheet.addCell(agentname);//采购商
					sheet.addCell(getPayMethod(orderinfo.getPaymethod()));//支付方式
					//sheet.addCell(orderinfo.getMemo());//备注
					sheet.addCell(getOrderStatestr(orderinfo.getOrderstatus()));//备注
					
					
					
					
					
					
					
					
					
					
				
					
					//
					

		//创建结束			
					sheet.rowOver();
				
				

			}
			System.gc();
			sheet.createOneRow(new String[] { "总订单数：",
					String.valueOf(orderinfos.size()) });
			sheet.createOneRow(new String[] { "总人数：",
					String.valueOf(passsize) });
			sheet
					.createOneRow(new String[] { "总票面价：",
							String.valueOf(parprice) });
			sheet.createOneRow(new String[] { "总税费：",
					String.valueOf(formatMoney(allduty)) });
			sheet.createOneRow(new String[] { "总保险：",
					String.valueOf(formatMoney(allinsur)) });
			if(this.getLoginsessionagent().getAgenttype()==1){
			sheet.createOneRow(new String[] { "总结算价：",
					String.valueOf(formatMoney(allzfgy)) });
			}
			
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
	public void expLiRunExcel() throws Exception {
		Customeragent longinagent = this.getLoginsessionagent();
		System.out.println(longinagent.getAgenttype());
		HttpServletRequest request = ServletActionContext.getRequest();
		long agid = this.customeragent.getId();
		StringBuilder where = new StringBuilder(" where 1=1 ");
		if (tftype > 0) {

			where.append("  AND C_ORDERSTATUS =" + tftype);
		} else {

			where
					.append("  AND C_ORDERSTATUS =3 ");
		}
		if (longinagent.getAgenttype() != 2) {
			if (agid!=0) {					
				if (agid < 0) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
									+ (0 - agid));
					if (longinagent.getAgenttype() != 1) {
						where
								.append("  AND  charindex(','+CONVERT(nvarchar,"
										+ longinagent.getId()
										+ ")+',',','+C_PARENTSTR+',')> 0 ");
					}
					where.append(")");
				} else {
					where.append(" AND C_BUYAGENTID=" + agid);
				}
			} else {
				if (longinagent.getAgenttype() != 1) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE ID="
									+ longinagent.getId()
									+ "  OR  charindex(','+CONVERT(nvarchar,"
									+ longinagent.getId()
									+ ")+',',','+C_PARENTSTR+',')> 0 ) ");
				}
			}
		} else {
			where.append(" AND " + Orderinfo.COL_policyagentid + "="
					+ longinagent.getId());

		}
		
		if (isNotNullOrEpt(this.s_ordernum)) {
			where.append(" AND C_ORDERNUMBER='" + s_ordernum + "'");
		}
		if (!isNullorSpace(s_ordername)) {// 预订人
			where
					.append(" AND C_SALEAGENTID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_ordername + "%')");
		}
		if (!isNullorSpace(s_chuname)) {// 出票人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE =3 AND C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_chuname + "%' ) )");
		}
		String cptime = this.getCheckTime(s_begintime, s_endtime,
				"C_PRINTTIME");// 出票时间
		if (cptime.length() > 0) {
			where.append(" AND (" + cptime + ") ");

		}
		String ydtime = this.getCheckTime(orderstime, orderetime,
				Orderinfo.COL_createtime);// 预订时间
		if (ydtime.length() > 0) {
			where.append(" AND (" + ydtime + ") ");

		}
		if (!isNullorSpace(s_shouyinname)) {// 收银人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shouyinname + "%' ) AND C_STATE  =10 )");
		}
		String shoutime = this.getCheckTime(this.shou_begintime,
				this.shou_endtime, "C_CREATETIME");
		if (shoutime.length() > 0) {// 收银时间
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_STATE=10 AND ("
							+ shoutime + ") )");
		}
		if (!this.isNullorSpace(sqname)) {// 申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ sqname + "%' ) AND C_STATE IN (4,5) )");
		}
		String sqtime = this.getCheckTime(sq_begintime, sq_endtime,
				"C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
							+ sqtime + "))");
		}
		if (!this.isNullorSpace(shname)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ shname + "%' ) AND C_STATE IN (7,17,11,12) )");
		}
		String shtime = this.getCheckTime(sh_begintime, sh_endtime,
				"C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
							+ shtime + "))");
		}
		if (!this.isNullorSpace(tkname)) {// 退款人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ tkname + "%' ) AND C_STATE IN (9,18) )");
		}
		String tktime = this.getCheckTime(tk_begintime, tk_endtime,
				"C_CREATETIME");// 退款时间
		if (tktime.length() > 0) {
			where
					.append(" AND ID  IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(9,18) AND ("
							+ tktime + "))");
		}
		if (!isNullorSpace(piaohao)) {// 票号

			where.append(" AND TICKETNUMBERS LIKE  '%" + piaohao + "%'");
		}
		if (s_ticketname != null && s_ticketname.trim().length() != 0) {// 乘机人

			where.append(" AND  PASSENGERS LIKE '%" + s_ticketname + "%'");
		}
		String flitime = this.getCheckTime(this.flight_begintime, "",
				Segmentinfo.COL_departtime);
		if (flitime.length() > 0) {// 航班日期
			where
					.append(" AND ID IN  ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE "
							+ flitime + ")");
		}
		if (!isNullorSpace(s_pnr)) {// PNR
			where.append(" AND (" + Orderinfo.COL_pnr + "='" + s_pnr
					+ "' OR " + Orderinfo.COL_bigpnr + "='" + s_pnr + "')");
		}
		if (!isNullorSpace(s_airname)) {// 航空公司

			where.append(" AND AIRNAME LIKE '%" + s_airname + "%'");
		}
		if (s_cabin != null && s_cabin.trim().length() > 0) {// 舱位
			where.append(" AND C_CABINCODE = '" + s_cabin + "'");
		}
		System.out.println("chupiaoReport:" + where);
		
		
		List<Orderinfo> orderinfos=Server.getInstance().getAirService().findAllOrderinfo(where.toString(), " ORDER BY ID ", -1, 0);
		
		
		//List<Orderinfo> orderinfos=Server.getInstance().getAirService().findAllOrderinfoForPageinfo(where.toString(), " ORDER BY ID ", pageinfo);
		
		
		
		
		
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		
		
		ticketcount = pageinfo.getTotalrow();

		String name = "利润报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		/*String[] titleles = { "订单号", "采购商", "PNR", "乘机人", "票号","人数", "航班号","折扣",
				"航班日期", "航程", "票面价", "订单返点","分销商返点","分销商返利", "税费", "保险", "结算价","支付方式" ,"机票状态" };*/
		
		String[] titleles = { "订单号","PNR", "乘机人","票号", "人数", "航程", "总票面价","折扣","税费", "总票面价","保险","订单返点","留点利润",
				"分销商返点","分销商返利", "结算价", "航班日期", "出票日期", "航班号","舱位", "销售员", "单位", "支付方式","机票状态"  };
	
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		Map<Integer,Integer> column=new HashMap<Integer,Integer>();
		column.put(2, 150);
		column.put(5, 120);
		HthyWorkSheet sheet = book.createHthyWorkSheet("利润报表",
				titleles.length + 10, 10000,column);
		sheet.createOneRow("利润报表", 3);
		sheet.createOneRow("电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		Map map = null;
		int ordercount = 0;
		float parprice = 0f;
		float allinsur = 0f;
		float allduty = 0f;
		float allzfgy=0f;
		try {
			int passsize=0;
			for (int x = 0; x < orderinfos.size(); x++) {
				
				Orderinfo orderinfo=orderinfos.get(x);
				
				List<String> lists = new ArrayList<String>();
				String html = "";
				String ticketnum="";
				String agentname="";
				String fnum="";
				String stime="";
				String xingcheng="";
				String piaomianjia="";
				
				
				Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
				List<Segmentinfo>listSegmentinfo=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
				List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" where 1=1 and "+Passenger.COL_orderid+" ="+orderinfo.getId()+" AND "+Passenger.COL_state+" <>12", "", -1, 0);
				agentname=customeragent.getAgentcompanyname();
				fnum=listSegmentinfo.get(0).getFlightnumber();
				stime=listSegmentinfo.get(0).getDeparttime()+"";
				xingcheng=getCitynameByAirport(listSegmentinfo.get(0).getStartairport())+"-"+getCitynameByAirport(listSegmentinfo.get(0).getEndairport());
				piaomianjia=listSegmentinfo.get(0).getParvalue()+"";
				
				//计算返利开始
				String fanli="";
				
				Float zratevalue=orderinfo.getRatevalue();
				Float agentvalue=orderinfo.getFenxiaoshangfandian();
				
				Float pvalue=listSegmentinfo.get(0).getParvalue();//票面价
				Float Yprice=listSegmentinfo.get(0).getYprice();//Y价格
				
				Float price=0f;
				Float shuifei=0f;
				Float baoxian=0f;
				if(listpass.size()>0){
					passsize+=listpass.size();
					for(int a=0;a<listpass.size();a++){
						
						
						
						Passenger passenger=listpass.get(a);
						if(passenger.getPtype()==1){//成人
							price+=pvalue;
						}
						if(passenger.getPtype()==2){//儿童
							
							
							if (listSegmentinfo.get(0).getDiscount() > 100) {
								
								price+=getRoundPrice(pvalue, 2);
								
							} else {
								
								price+=getRoundPrice(Yprice, 2);
							
							}
							
						}
						if(passenger.getPtype()==3){//婴儿
							
							// 儿童婴儿价
							if (listSegmentinfo.get(0).getDiscount() > 100) {
								price+=getRoundPrice(pvalue, 10);
								
							} else {
								price+=getRoundPrice(Yprice, 10);
								
							}
							
						}
						price+=passenger.getFuelprice();
						price+=passenger.getAirportfee();
						
					
						shuifei+=passenger.getFuelprice();
						shuifei+=passenger.getAirportfee();
						baoxian+=passenger.getInsurprice();
						
						
						html += passenger.getName() + "<br/>";
						ticketnum +=passenger.getTicketnum() + "<br/>";
						
						
					}
				}
				Float retprice=	price-(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice());	
				
				fanli=retprice+"";
				//计算结束
				
				
				
				
				lists.add(html);//乘机人 0
				lists.add(ticketnum);//票号 1
				lists.add(agentname);// 加盟商名字 2
				lists.add(fnum);//航班号 3
				lists.add(stime);// 出发时间 4
				lists.add(xingcheng);//行程 5
				lists.add(piaomianjia);//票面价 6
				lists.add(fanli);// 返利 7
				lists.add(shuifei+"");// 税费 8
				lists.add(baoxian+"");// 保险 9
				lists.add(price+"");// 总票面价 10
				lists.add(listpass.size()+"");// 总人数 11
				
				lists.add(listSegmentinfo.get(0).getDiscount()+"");//  折扣 12
				
				//计算总票面价
				parprice+=price;
				//计算总税费
				allduty+=shuifei;
				//计算总保险
				allinsur+=baoxian;
				//计算总结算价
				allzfgy+=orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice();
					
					
		//String[] titleles = { "订单号", "采购商", "PNR", "乘机人", "票号","人数", "航班号","折扣",
		//					"航班日期", "航程", "票面价", "订单返点","分销商返点","分销商返利", "税费", "保险", "结算价","支付方式" ,"机票状态" };
					
		//开始创建
				
				
			//	String[] titleles = { "订单号","PNR", "乘机人","票号", "人数", "航程", "票面价","折扣","税费", "总票面价","保险",
			//			"返点","分销商返点","分销商返利", "结算价", "航班日期", "航班号","舱位","保险", "销售员", "单位", "支付方式","备注"  };
				
				
					sheet.createRow();
					
					sheet.addCell(orderinfo.getOrdernumber());//订单号
					sheet.addCell(orderinfo.getPnr());//PNR
					sheet.addCell(html.replace("<br/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);//乘机人\
					sheet.addCell(ticketnum.replace("<br/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);//票号
					sheet.addCell(listpass.size());//人数
					sheet.addCell(xingcheng);//航程
					sheet.addCell(piaomianjia);//票面价
					sheet.addCell(listSegmentinfo.get(0).getDiscount());//折扣
					sheet.addCell(shuifei);//税费
					sheet.addCell(price);//总票面价
					sheet.addCell(baoxian);//保险
					
					sheet.addCell(orderinfo.getRatevalue());//订单返点
					sheet.addCell(orderinfo.getB2cprofit());//留点利润
					
					
					sheet.addCell(orderinfo.getFenxiaoshangfandian());//分销商返点
					sheet.addCell(fanli);//分销商返利
					sheet.addCell(orderinfo.getTotalairportfee()+orderinfo.getTotalfuelfee()+orderinfo.getTotalticketprice()+baoxian);//结算价
					sheet.addCell(stime);//航班日期
					sheet.addCell(orderinfo.getPrinttime());//出票日期
					sheet.addCell(fnum);//航班号
					sheet.addCell(listSegmentinfo.get(0).getCabincode());//舱位
					
					sheet.addCell(orderinfo.getCustomeruserid());//销售员
					sheet.addCell(agentname);//采购商
					sheet.addCell(getPayMethod(orderinfo.getPaymethod()));//支付方式
					//sheet.addCell(orderinfo.getMemo());//备注
					sheet.addCell(getOrderStatestr(orderinfo.getOrderstatus()));//备注
					
					
					
					
					
					
					
					
					
					
				
					
					//
					

		//创建结束			
					sheet.rowOver();
				
				

			}
			System.gc();
			sheet.createOneRow(new String[] { "总订单数：",
					String.valueOf(orderinfos.size()) });
			sheet.createOneRow(new String[] { "总人数：",
					String.valueOf(passsize) });
			sheet
					.createOneRow(new String[] { "总票面价：",
							String.valueOf(parprice) });
			sheet.createOneRow(new String[] { "总税费：",
					String.valueOf(formatMoney(allduty)) });
			sheet.createOneRow(new String[] { "总保险：",
					String.valueOf(formatMoney(allinsur)) });
			if(this.getLoginsessionagent().getAgenttype()==1){
			sheet.createOneRow(new String[] { "总结算价：",
					String.valueOf(formatMoney(allzfgy)) });
			}
			
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

	public void expChupiaoExcel_old() throws Exception {
		String sql = "";
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		sql = chupiao_old();
		
		/*if(sql.indexOf("where")==-1||sql.indexOf("where")>5){
				sql=" where "+sql;
		}*/
		
		pageinfo.setPagerow(2000);
		List orderinfos = this.reportPage(sql);
		ticketcount = pageinfo.getTotalrow();

		String name = "出票报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		String[] titleles = { "订单号", "采购", "PNR", "乘机人", "票号", "航班号", "航班日期",
				"航程", "票面价", "返点", "返利", "税费", "保险", "采购支付","支付供应", "机票状态" };
		if (this.getLoginsessionagent().getAgenttype() != 1) {
	titleles = new String[] { "订单号", "采购", "PNR", "乘机人", "票号", "航班号","航班日期", 
			   "航程", "票面价", "获利", "税费", "保险", "结算价", "机票状态" };

		}
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		Map<Integer,Integer> column=new HashMap<Integer,Integer>();
		column.put(2, 150);
		column.put(5, 120);
		HthyWorkSheet sheet = book.createHthyWorkSheet("出票报表",
				titleles.length + 10, pageinfo.getTotalrow() + 50,column);
		sheet.createOneRow("出票报表", 3);
		sheet.createOneRow("电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		Map map = null;
		int ordercount = 0;
		float parprice = 0f;
		float allinsur = 0f;
		float allduty = 0f;
		float allzfgy=0f;
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = orderinfos.size();
				ordercount += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					map = (HashMap) orderinfos.remove(0);
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(map.get("C_AGENTCOMPANYNAME"));
					sheet.addCell(map.get("C_PNR"));
					
					sheet.addCell(map.get("PASSENGERS").toString().replace("<BR/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);
					sheet.addCell(map.get("TICKETNUMBERS").toString().replace("<BR/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);
					// sheet.addCell(map.get("AIRNAME"));
					sheet.addCell(map.get("C_FLIGHTNUMBER"));
					sheet.addCell(map.get("C_DEPARTTIME"));
					sheet.addCell(map.get("AIRFLIGHT"));
					// sheet.addCell(map.get("C_CABINCODE"));
					float cparprice = Float.valueOf(converNull(map.get("C_PARVALUE"),"0")
							.toString());
					parprice += cparprice;
					sheet.addCell(cparprice);
					if (this.getLoginsessionagent().getAgenttype() == 1) {
						sheet.addCell(map.get("REBAT"));
					}
					if(map.get("REBATEMONEY")==null||map.get("REBATEMONEY").equals("")){
						Float val=0f;
						int passsize=1;
						List<Orderinfo>listorder=Server.getInstance().getAirService().findAllOrderinfo(" WHERE 1=1 AND "+Orderinfo.COL_ordernumber+" ='"+map.get("C_ORDERNUMBER")+"'", " ORDER BY ID DESC ", -1, 0);
						if(listorder.size()>0){
							List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+listorder.get(0).getId(), " ORDER BY ID DESC ", -1, 0);
							
							passsize=listpass.size();
							if(listorder.get(0).getRatevalue()!=null&&listorder.get(0).getFenxiaoshangfandian()!=null){
								val=listorder.get(0).getRatevalue()-listorder.get(0).getFenxiaoshangfandian();
							}
						}
						
						
						
						if (this.getLoginsessionagent().getAgenttype() == 1) {
							//Float yunysvalue=val*cparprice/100*passsize;
							//sheet.addCell(formatflotMoneyB2B(yunysvalue));
							sheet.addCell(listorder.get(0).getB2cprofit());
						}else{
							
							Float yunysvalue=listorder.get(0).getFenxiaoshangfandian()*cparprice/100*passsize;
							sheet.addCell(formatflotMoneyB2B(yunysvalue));
						}
						
					}else{
						sheet.addCell(map.get("REBATEMONEY"));
					}
					
					
					float duty = Float.valueOf(converNull(map.get("DUTY"), "0")
							.toString());
					allduty += duty;
					sheet.addCell(duty);
					float insurprice = Float.valueOf(converNull(
							map.get("INSURANCEPRICE"), "0").toString());
					allinsur += insurprice;
					sheet.addCell(map.get("INSURANCEPRICE"));
					float payprice = Float.valueOf(map
							.get("C_TOTALTICKETPRICE").toString())
							+ Float.valueOf(map.get("DUTY").toString())
							+ insurprice;
					sheet.addCell(payprice);
					if(this.getLoginsessionagent().getAgenttype()==1){
					float zfgyprice=0;
					try{
						zfgyprice=Float.valueOf(converNull(map.get("C_EXTORDERPRICE"),"0").toString());
					}catch(Exception e){
						
					}
					sheet.addCell(zfgyprice);
					allzfgy+=zfgyprice;
					}
					sheet.addCell(getOrderStatestr(Integer.valueOf(map.get(
							"C_ORDERSTATUS").toString())));

					if (i % 300 == 0) {
						book.flush();
						book.write();
					}
					sheet.rowOver();
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					orderinfos = this.reportPage(sql);
				} else {
					break;
				}

			}
			System.gc();
			sheet.createOneRow(new String[] { "总订单数：",
					String.valueOf(ordercount) });
			sheet
					.createOneRow(new String[] { "总票面价：",
							String.valueOf(parprice) });
			sheet.createOneRow(new String[] { "总税费：",
					String.valueOf(formatMoney(allduty)) });
			sheet.createOneRow(new String[] { "总保险：",
					String.valueOf(formatMoney(allinsur)) });
			if(this.getLoginsessionagent().getAgenttype()==1){
			sheet.createOneRow(new String[] { "总支付供应：",
					String.valueOf(formatMoney(allzfgy)) });
			}
			
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
	public void expLiyunExcel() throws Exception {
		String sql = "";
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		sql = lirun();
		pageinfo.setPagerow(2000);
		List orderinfos = this.reportPage(sql);
		ticketcount = pageinfo.getTotalrow();

		String name = "利润报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		String[] titleles = { "订单号", "采购", "PNR", "乘机人", "票号", "航班号", "航班日期",
				"航程", "票面价", "订单返点", "分销返点", "返利", "税费", "保险", "采购支付","支付供应", "机票状态" };
		if (this.getLoginsessionagent().getAgenttype() != 1) {
			titleles = new String[] { "订单号", "采购", "PNR", "乘机人", "票号", "航班号",
					"航班日期", "航程", "票面价", "获利", "税费", "保险", "结算价", "机票状态" };

		}
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		Map<Integer,Integer> column=new HashMap<Integer,Integer>();
		column.put(2, 150);
		column.put(5, 120);
		HthyWorkSheet sheet = book.createHthyWorkSheet("利润报表",
				titleles.length + 10, pageinfo.getTotalrow() + 50,column);
		sheet.createOneRow("利润报表", 3);
		sheet.createOneRow("电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		Map map = null;
		int ordercount = 0;
		float parprice = 0f;
		float allinsur = 0f;
		float allduty = 0f;
		float allzfgy=0f;
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = orderinfos.size();
				ordercount += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					map = (HashMap) orderinfos.remove(0);
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(map.get("C_AGENTCOMPANYNAME"));
					sheet.addCell(map.get("C_PNR"));
					
					sheet.addCell(map.get("PASSENGERS").toString().replace("<BR/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);
					sheet.addCell(map.get("TICKETNUMBERS").toString().replace("<BR/>", "&#10;"),HthyWorkSheet.EXCEL_BREAK);
					// sheet.addCell(map.get("AIRNAME"));
					sheet.addCell(map.get("C_FLIGHTNUMBER"));
					sheet.addCell(map.get("C_DEPARTTIME"));
					sheet.addCell(map.get("AIRFLIGHT"));
					// sheet.addCell(map.get("C_CABINCODE"));
					float cparprice = Float.valueOf(converNull(map.get("C_PARVALUE"),"0")
							.toString());
					parprice += cparprice;
					sheet.addCell(cparprice);
					if (this.getLoginsessionagent().getAgenttype() == 1) {
						sheet.addCell(map.get("REBAT"));
						sheet.addCell(map.get("REBAT"));
					}
					sheet.addCell(map.get("REBATEMONEY"));
					float duty = Float.valueOf(converNull(map.get("DUTY"), "0")
							.toString());
					allduty += duty;
					sheet.addCell(duty);
					float insurprice = Float.valueOf(converNull(
							map.get("INSURANCEPRICE"), "0").toString());
					allinsur += insurprice;
					sheet.addCell(map.get("INSURANCEPRICE"));
					float payprice = Float.valueOf(map
							.get("C_TOTALTICKETPRICE").toString())
							+ Float.valueOf(map.get("DUTY").toString())
							+ insurprice;
					sheet.addCell(payprice);
					if(this.getLoginsessionagent().getAgenttype()==1){
					float zfgyprice=0;
					try{
						zfgyprice=Float.valueOf(converNull(map.get("C_EXTORDERPRICE"),"0").toString());
					}catch(Exception e){
						
					}
					sheet.addCell(zfgyprice);
					allzfgy+=zfgyprice;
					}
					sheet.addCell(getOrderStatestr(Integer.valueOf(map.get(
							"C_ORDERSTATUS").toString())));

					if (i % 300 == 0) {
						book.flush();
						book.write();
					}
					sheet.rowOver();
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					orderinfos = this.reportPage(sql);
				} else {
					break;
				}

			}
			System.gc();
			sheet.createOneRow(new String[] { "总订单数：",
					String.valueOf(ordercount) });
			sheet
					.createOneRow(new String[] { "总票面价：",
							String.valueOf(parprice) });
			sheet.createOneRow(new String[] { "总税费：",
					String.valueOf(formatMoney(allduty)) });
			sheet.createOneRow(new String[] { "总保险：",
					String.valueOf(formatMoney(allinsur)) });
			if(this.getLoginsessionagent().getAgenttype()==1){
			sheet.createOneRow(new String[] { "总支付供应：",
					String.valueOf(formatMoney(allzfgy)) });
			}
			
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

	public void expTFpiaoExcel() throws Exception {
		String sql = "";
		HthyWritableWorkBook.SEARCHNUM += 1;
		isExp = true;
		sql = chupiao_old();
		pageinfo.setPagerow(2000);
		List orderinfos = Server.getInstance().getSystemService()
				.findMapResultPageByProcedure("view_orderinfo O ", filedname,
						"ID", 1, sql, "ID", pageinfo);
		pageinfo = (PageInfo) orderinfos.remove(0);
		ticketcount = pageinfo.getTotalrow();
		String reportname="退票报表";
		if(this.tftype==9){
			reportname="废票报表";
		}
		String name=reportname+".xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		String[] titleles = {"订单号", "采购", "PNR", "乘机人", "票号", "航班号", "航班日期", "航程", "舱位", "实付款", ",手续费", "退款金额", "机票状态" };
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet(reportname,
				titleles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow(reportname, 3);
		sheet.createOneRow("电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titleles, HthyWorkSheet.CenterBlod);
		java.text.NumberFormat numformat = java.text.NumberFormat
				.getPercentInstance();
		numformat.setMinimumFractionDigits(2);// 小数点后保留几位
		Map map = null;
		int ordercount = 0;
		float allshifuk=0f;//总是收款
		float allsxf=0f;//总手续费
		float alltkj=0f;//总退款金额
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = orderinfos.size();
				ordercount += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					map = (HashMap) orderinfos.remove(0);
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(map.get("C_AGENTCOMPANYNAME"));
					sheet.addCell(map.get("C_PNR"));
					sheet.addCell(map.get("PASSENGERS"));
					sheet.addCell(map.get("TICKETNUMBERS"));
					// sheet.addCell(map.get("AIRNAME"));
					sheet.addCell(map.get("C_FLIGHTNUMBER"));
					sheet.addCell(map.get("C_DEPARTTIME"));
					sheet.addCell(map.get("AIRFLIGHT"));
					 sheet.addCell(map.get("C_CABINCODE"));//仓位
					
					 float ticket=Float.valueOf(map.get("C_TOTALTICKETPRICE").toString());
					 float duty=Float.valueOf(map.get("DUTY").toString());
					 float inprice=Float.valueOf(map.get("INSURANCEPRICE").toString());
					 float shifukuang=ticket+duty+inprice;
					 allshifuk+=shifukuang;
					sheet.addCell(shifukuang);
					float sxf=Float.valueOf(converNull(map.get("SHOUXUFEI"),"0").toString());
					sheet.addCell(sxf);
					allsxf+=sxf;
					float tkj=Float.valueOf(converNull(map.get("C_RETURNPRICE"),"0").toString());
					alltkj+=tkj;
					sheet.addCell(tkj);
					sheet.addCell(getOrderStatestr(Integer.valueOf(map.get(
							"C_ORDERSTATUS").toString())));

					if (i % 300 == 0) {
						book.flush();
						book.write();
					}
					sheet.rowOver();
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					orderinfos = Server.getInstance().getSystemService()
							.findMapResultPageByProcedure("view_orderinfo O ",
									filedname, "ID", 1, sql, "ID", pageinfo);

					pageinfo = (PageInfo) orderinfos.remove(0);
				} else {
					break;
				}

			}
			System.gc();
			sheet.createOneRow(new String[] { "总订单数：",String.valueOf(ordercount) });
			sheet.createOneRow(new String[] { "总实付款：",formatMoney(allshifuk)+"元"});
			sheet.createOneRow(new String[] { "总手续费：",formatMoney(allsxf)+"元"});
			sheet.createOneRow(new String[] { "总退款金：",formatMoney(alltkj)+"元" });
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
	 * @return
	 */
	public String getTicketType(long tickttypeid) {

		Tickettype ttype = Server.getInstance().getMemberService()
				.findTickettype(tickttypeid);
		if (ttype != null) {
			return ttype.getTypename();
		}
		return "未知";
	}

	public Map<Integer, String> getHkmethodMap() {
		return new BiguserpriceAction().getHkmethodMap();
	}

	/**
	 * 明细导出Excel
	 * 
	 * @throws Exception
	 */
	public void expDetailExcel() throws Exception {
		String where = "";
		try {
			this.isExp = true;
			HthyWritableWorkBook.setSEARCHNUM(HthyWritableWorkBook
					.getSEARCHNUM() + 1);
			where = airreportdetail();
			pageinfo.setPagerow(2000);
			List list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, "", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listorderinfos = (List<Orderinfo>) list;

		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		String[] titles = { "客户名称", "类型", "起始票号", "终止票号", "PNR", "人数", "成人",
				"儿童", "航程", "航班舱位", "票面金额", "税", "折让", "实收金额", "实际支付金额", "代理费",
				"支付方式", "付款方式", "订单编号", "出票时间", "出票人ID", "机票状态" };
		String name = "电子客票明细报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("电子客票明细报表",
				titles.length + 5, pageinfo.getTotalrow() + 50);
		sheet.createOneRow("电子客票明细报表", 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		Map<Integer, Float> dxmap = new HashMap<Integer, Float>();
		int num = 0;
		float yprice = 0;
		float relprice = 0;
		float duty = 0;
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = listorderinfos.size();
				num += pnum;
				for (int i = 0; i < pnum; i++) {
					Orderinfo order = listorderinfos.remove(0);
					sheet.createRow();
					long orderid = order.getId();
					float yp = order.getTotalticketprice();
					float dy = converNull(order.getTotalairportfee(), 0f)
							+ converNull(order.getTotalfuelfee(), 0f)
							+ converNull(order.getTotalanjian(), 0f)
							+ converNull(order.getTotalotherfee(), 0f);
					// float rp = this.getRealPrice(orderid);
					yprice += yp;
					duty += dy;
					// relprice += rp;

					sheet.addCell(this.getAgentNameOfOrder(order));
					sheet.addCell(this.s_internal == 0 ? "国内票" : "国际票");
					sheet.addCell(this.getSEticketnum(orderid, 1));
					sheet.addCell(this.getSEticketnum(orderid, 2));
					sheet.addCell(this.getpnr(orderid));// pnr
					List<Passenger> pas = Server.getInstance().getAirService()
							.findAllPassenger(
									" WHERE " + Passenger.COL_orderid + "="
											+ orderid, "", -1, 0);
					int adult = 0;
					int children = 0;
					for (Passenger p : pas) {
						if (p.getPtype() == 1) {
							adult += 1;
						} else {
							children += 1;
						}

						int fkm = converNull(order.getFkmethod(), 0);
						if (dxmap.get(fkm) != null) {
							float dxprice = dxmap.get(fkm);
							// dxprice += this.getPassengerPrice(p.getId());
							dxmap.put(fkm, dxprice);
						} else {
							// dxmap.put(fkm,
							// this.getPassengerPrice(p.getId()));
						}

					}
					sheet.addCell(pas.size());
					sheet.addCell(adult);// 成人
					sheet.addCell(children);// 儿童
					sheet.addCell(this.getSegmentInfo(orderid, 1));//
					sheet.addCell(this.getSegmentInfo(orderid, 4));//
					sheet.addCell(yp);
					sheet.addCell(dy);
					// sheet.addCell(this.getPreferential(orderid));
					// sheet.addCell(rp);
					// sheet.addCell(rp);
					sheet.addCell(0);
					sheet.addCell(this.getPayMethodStr(order.getPaymethod()));
					sheet.addCell(this.getFkmethodstr(converNull(order
							.getFkmethod(), 0)));

					sheet.addCell(order.getOrdernumber());
					sheet.addCell(order.getPrinttime());// 出票日期
					// sheet.addCell(this.getInsurName(orderid));// 出票人
					sheet
							.addCell(this.getOrderStatestr(order
									.getOrderstatus()));// 机票状态
					sheet.rowOver();
					if (num % 300 == 0) {
						book.flush();
						book.write();
					}
				}

				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					List list = Server.getInstance().getAirService()
							.findAllOrderinfoForPageinfo(where, "", pageinfo);
					pageinfo = (PageInfo) list.remove(0);
					listorderinfos = (List<Orderinfo>) list;
				} else {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		System.gc();
		sheet.createOneRow(new String[] { "总订单数：", String.valueOf(num) });
		sheet
				.createOneRow(new String[] { "票面金额总和：",
						super.formatMoney(yprice) });
		sheet.createOneRow(new String[] { "实际支付金额总和：",
				super.formatMoney(relprice) });
		sheet.createOneRow(new String[] { "代理费总和：", super.formatMoney(0f) });
		sheet.createOneRow(new String[] { "税总和：", super.formatMoney(duty) });
		sheet.createOneRow("单项汇总：");
		Iterator<Map.Entry<Integer, Float>> iterator = dxmap.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Float> entry = iterator.next();
			int key = entry.getKey();
			float value = entry.getValue();
			sheet.createOneRow(new String[] { " ",
					this.getFkmethodstr(key) + ":",
					String.valueOf(formatMoney(value)) });
		}
		dxmap.clear();
		sheet.sheetOver();
		book.flush();
		book.write();
		book.close();
	}

	/**
	 * 当日,非当日退废报表
	 * 
	 * @throws Exception
	 */
	public void expDateFeiExcel() throws Exception {
		String sql = "";
		try {
			this.isExp = true;
			HthyWritableWorkBook.setSEARCHNUM(HthyWritableWorkBook
					.getSEARCHNUM() + 1);
			sql = datefei();
			pageinfo.setPagerow(2000);
			datefeilist = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, pageinfo);
			pageinfo = (PageInfo) datefeilist.remove(0);
		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		String[] titles = { "序号", "客户名称", "类型", "订单编号", "支付方式", "付款方式", "票号",
				"PNR", "乘机人", "航班", "票面金额", "税", "客户实际支付金额", "退票手续费率", "退废票费",
				"东航实际退票费用", "客户实际退款金额", "退废票状态", "退废票类型", "退费票日期", "退废票人",
				"出票日期", "出票人" };
		String name = "当日退废报表";
		String lablename = "当日作废数：";
		if (this.notoday != null && (notoday.equals("true"))) {
			name = "非当日退废报表";
			lablename = "非当日作废数：";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + name
				+ ".xls");
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet(name,
				titles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow(name, 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		int num = 0;
		int zuofeinum = 0;
		int tuipiaonum = 0;
		double yprice = 0;
		double duty = 0;
		double realprice = 0;
		double tuifee = 0;
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = datefeilist.size();
				num += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					Map map = (HashMap) datefeilist.remove(0);
					long orderid = 0l;
					if (map.get("C_ORDERID") != null) {
						orderid = Long.valueOf(map.get("C_ORDERID").toString());
					}
					int s = Integer.valueOf(map.get("C_STATE").toString());
					if (s == 2) {
						zuofeinum++;
					}
					if (s == 3) {
						tuipiaonum++;
					}
					yprice += Double
							.valueOf(nullConver(map.get("C_PRICE"), 0.0)
									.toString());
					duty += Double.valueOf(nullConver(map.get("DUTY"), 0.0)
							.toString());
					realprice += Double.valueOf(nullConver(map.get("C_YIHAI"),
							0.0).toString());
					tuifee += Double.valueOf(nullConver(map.get("C_TUIFEE"),
							0.0).toString());
					sheet.addCell(i + 1);
					sheet.addCell(map.get("AGENTNAME"));// 客户名称
					sheet.addCell(this.s_internal == 0 ? "国内票" : "国际票");
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(this.getPayMethodStr(Integer.valueOf((map
							.get("C_PAYMETHOD")).toString())));
					sheet.addCell(this.getFkmethodstr(Integer
							.valueOf(converNull(map.get("C_FKMETHOD"), 0)
									.toString())));
					sheet.addCell(converNull(map.get("C_TICKETNUM"), ""));
					sheet.addCell(this.getpnr(orderid));
					sheet.addCell(map.get("C_NAME"));// 乘机人
					sheet.addCell(map.get("hangbanhao"));
					sheet.addCell(nullConver(map.get("C_PRICE"), ""));
					sheet.addCell(nullConver(map.get("DUTY"), ""));
					sheet.addCell(converNull(map.get("C_YIHAI"), "0"));// 客户实际支付
					float f = 0;
					if (map.get("C_TUIFEE") != null
							&& map.get(Passenger.COL_price) != null) {
						f = Math.round(Float.valueOf(map.get("C_TUIFEE")
								.toString())
								/ Float.valueOf(map.get(Passenger.COL_price)
										.toString()));
					}
					sheet.addCell(f + "%");// 手续费率
					sheet.addCell(map.get("C_TUIFEE"));// 手续费
					sheet.addCell("");// 东航实际退票费
					sheet.addCell("");// 客户实际退票金额
					sheet.addCell(getpassstate(Integer.valueOf(map.get(
							"C_STATE").toString())));// 退票状态，
					String leixing = "未知";
					if (map.get("C_TUIFEIYUANYI") != null) {
						int ss = Integer.valueOf(map.get("C_TUIFEIYUANYI")
								.toString());
						if (ss == 1)
							leixing = "自愿";
						if (ss == 2)
							leixing = "非自愿";
					}
					sheet.addCell(leixing);// 退票类型
					// sheet.addCell(this.getTuiFeiTime(orderid));// 退废票日期
					sheet.addCell(map.get("TFNAME"));// 退废票人
					sheet.addCell(map.get("C_PRINTTIME"));// 出票日期
					sheet.addCell(map.get("CPNAME"));
					sheet.rowOver();
					if (num % 300 == 0) {
						book.flush();
						book.write();
					}

				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					datefeilist = Server.getInstance().getSystemService()
							.findMapResultBySql(sql, pageinfo);
					pageinfo = (PageInfo) datefeilist.remove(0);
				} else {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		System.gc();
		sheet.createOneRow(new String[] { "总退票航段数：", String.valueOf(num) });
		sheet
				.createOneRow(new String[] { lablename,
						String.valueOf(zuofeinum) });
		sheet.createOneRow(new String[] { "退票数：", String.valueOf(tuipiaonum) });
		sheet.createOneRow(new String[] { "票面金额总和：", String.valueOf(yprice) });
		sheet.createOneRow(new String[] { "税总和：", String.valueOf(duty) });
		sheet.createOneRow(new String[] { "实际支付金额总和：",
				String.valueOf(realprice) });
		sheet.createOneRow(new String[] { "实际退票金额总和：", "0" });
		sheet.sheetOver();
		book.flush();
		book.write();
		book.close();
	}

	public void expBiguserExcel() throws Exception {
		String sql = "";
		try {
			this.isExp = true;
			HthyWritableWorkBook.setSEARCHNUM(HthyWritableWorkBook
					.getSEARCHNUM() + 1);
			sql = todakehu();
			pageinfo.setPagerow(2000);
			listbigreport = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, pageinfo);
			pageinfo = (PageInfo) listbigreport.remove(0);

		} catch (Exception e) {
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		String[] titles = { "部门", "类型", "票号", "机票类型", "行程单号", "订单编号", "乘客姓名",
				"航空公司", "航班号", "航程", "起飞日期", "起飞时刻", "机票全价", "折扣率", "折扣票价",
				"税", "保险", "退票费", "总价", "返利", "实际结账", "出票日期", "机票状态", "是否付款",
				"订单备注", };
		String name = "大客户报表.xls";
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet("大客户报表",
				titles.length + 5, pageinfo.getTotalrow() + 50);
		sheet.createOneRow("大客户报表", 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);// 中国东方航空公司电子客票销售报告
		sheet.createOneRow("检索条件：");
		addReportOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		int num = 0;
		float hqprice = 0f;
		float relprice = 0f;
		long orderid = 0l;
		PassengerAction pa = new PassengerAction();
		try {
			int totalpage = pageinfo.getTotalpage();
			for (int x = 1; x <= totalpage; x++) {
				int pnum = listbigreport.size();
				num += pnum;
				for (int i = 0; i < pnum; i++) {
					sheet.createRow();
					Map map = (HashMap) listbigreport.remove(0);
					relprice += Float.valueOf(nullConver(map.get("C_YIHAI"), 0)
							.toString());
					orderid = Long.valueOf(converNull(map.get("C_ORDERID"), 0)
							.toString());
					Long l = Long.valueOf(map.get("C_CUSTOMERAGENTID")
							.toString());
					sheet.addCell(map.get("AGENTNAME"));
					String inter = converNull(map.get("C_INTERNAL"), "-1")
							.toString();
					int interanl = Integer.valueOf(inter);
					sheet.addCell(interanl == 0 ? "国内票" : interanl == 1 ? "国际票"
							: "未知");
					sheet.addCell(map.get("C_TICKETNUM"));
					sheet.addCell(map.get("TICKETTYPE"));
					sheet.addCell(map.get("C_FET"));
					sheet.addCell(map.get("C_ORDERNUMBER"));
					sheet.addCell(map.get("C_NAME"));
					sheet.addCell(converNull(map.get("hangkonggongsi"), "")
							.toString().replace("<br/>", " | "));
					sheet.addCell(converNull(map.get("hangbanhao"), "")
							.toString().replace("<br/>", " | "));
					sheet.addCell(converNull(map.get("citypair"), "")
							.toString().replace("<br/>", " | "));// 出发城市
					String date = map.get("DEPARTDATE").toString();
					String[] dates = date.split("<br/>");
					String datestr = "";
					String timestr = "";
					for (String str : dates) {
						if (datestr.length() > 0) {
							datestr = " | " + str.substring(0, 10);
							timestr = " | " + str.substring(10);
						} else {
							datestr = str.substring(0, 10);
							timestr = str.substring(10);
						}
					}
					sheet.addCell(datestr);
					sheet.addCell(timestr);

					sheet.addCell(converNull(map.get("YPRICE"), "0").toString()
							.replace("<br/>", " | "));
					sheet.addCell(converNull(map.get("DISCOUNT"), "")
							.toString().replace("<br/>", " | "));
					float price = Float.valueOf(converNull(map.get("C_PRICE"),
							0).toString());
					sheet.addCell(price);
					float duty = Float.valueOf(map.get("DUTY").toString());
					sheet.addCell(duty);
					float baoxian = Float.valueOf(converNull(
							map.get("C_INSURANCEFEE"), "0").toString());
					sheet.addCell(baoxian);// 保险
					float tuifee = Float.valueOf(converNull(
							map.get("C_TUIFEE"), 0).toString());
					sheet.addCell(tuifee);
					float zp = Float.valueOf(nullConver(map.get("C_PRICE"), 0)
							.toString())
							+ duty;
					sheet.addCell(zp);
					sheet.addCell(map.get("C_FENXIAOSHANGFANDIAN"));
					sheet.addCell(nullConver(map.get("C_YIHAI"), 0.0));
					String prittime = map.get("C_PRINTTIME").toString();
					if (prittime.length() > 10) {
						prittime = prittime.substring(0, 10);
					}
					sheet.addCell(prittime);
					int hk = Integer
							.valueOf(converNull(map.get("C_HKSTATE"), 0)
									.toString());
					if (hk == 1 || hk == 3) {
						hqprice += pa.getHQPrice(hk, Integer.valueOf(map.get(
								"C_STATE").toString()), price + duty, baoxian,
								Float.valueOf(converNull(map.get("HAIQIAN"), 0)
										.toString()), tuifee);

					}
					String hkstr = "";
					if (hk == 1) {
						hkstr = "未付款";
					}
					if (hk == 2) {
						hkstr = "已付款";
					}
					if (hk == 3) {
						hkstr = "部分付款";
					}
					int state = Integer.valueOf(map.get("C_STATE").toString());
					String statestr = getpassstate(state);
					sheet.addCell(statestr);
					sheet.addCell(hkstr);
					sheet.addCell(map.get("C_MEMO").toString());
					sheet.rowOver();
					if (num % 200 == 0) {
						book.flush();
						book.write();
					}
				}
				if (x < totalpage) {
					pageinfo.setPagenum(x + 1);
					pageinfo.setPagerow(2000);
					listbigreport = Server.getInstance().getSystemService()
							.findMapResultBySql(sql, pageinfo);
					pageinfo = (PageInfo) listbigreport.remove(0);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			HthyWritableWorkBook.SEARCHNUM -= 1;
		}
		System.gc();
		sheet.createOneRow(new String[] { "本期已还款金额总计：",
				String.valueOf(relprice) });
		sheet
				.createOneRow(new String[] { "本期未还款金额总计：",
						String.valueOf(hqprice) });
		if (s_department != null && s_department.trim().length() > 0) {
			List<Map> pricemap = Server.getInstance().getSystemService()
					.findMapResultByProcedure(
							"[dbo].[sp_getqkbyagent] @WHERE = N' " + qkhzwhere
									+ " ',@ZWHERE = N' " + this.qkhzmwhere
									+ "'");
			for (Map m : pricemap) {
				sheet.createOneRow(new String[] { "累计未还款金额总计：",
						m.get("qkprice").toString() });
			}
		}
		sheet.sheetOver();
		String where = " where 1=1  and " + Miscellaneous.COL_state
				+ " in (1,2,3)";
		List<Miscellaneous> mislist = Server.getInstance().getMemberService()
				.findAllMiscellaneous(where, " ORDER BY ID DESC", -1, 0);
		String[] zftitles = { "集团客户", "部门", "联系人", "旅客姓名", "操作人员", "费用",
				"费用发生日期", "创建时间", "还款状态", "欠款总计", "备注" };
		HthyWorkSheet zxsheet = book.createHthyWorkSheet("杂项费用",
				zftitles.length + 10, mislist.size() + 50);
		zxsheet.createOneRow("杂项费用", 5);
		zxsheet.createOneRow(zftitles, HthyWorkSheet.CenterBlod);
		int mi = mislist.size();
		float allprice = 0f;
		double allqk = 0f;
		try {
			for (int i = 0; i < mi; i++) {
				zxsheet.createRow();
				Miscellaneous mis = mislist.get(0);
				String deptname = "";
				if (mis.getGroupuserid() != null) {
					deptname = super.getCustagentNameById(mis.getGroupuserid());
				}
				if (mis.getDepartment() != null) {
					deptname += "/"
							+ super.getdepartmentNamebyId(mis.getDepartment());
				}
				zxsheet.addCell(deptname);
				zxsheet.addCell(super.getusername(mis.getCustomerid()));
				zxsheet.addCell(mis.getName());
				zxsheet.addCell(super.getusername(mis.getCreateid()));
				zxsheet.addCell(mis.getPrice());
				allprice += mis.getPrice();
				zxsheet.addCell(mis.getSpenddate());
				zxsheet.addCell(mis.getCreatetime());
				String hkstatestr = mis.getState() == 1 ? "未还款" : mis
						.getState() == 2 ? "已还款" : "部分还款";
				zxsheet.addCell(hkstatestr);
				zxsheet.addCell(converNull(mis.getHaiqian(), 0f));
				allqk += converNull(mis.getHaiqian(), 0d);
				zxsheet.rowOver();
				if (num % 200 == 0) {
					book.flush();
					book.write();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			HthyWritableWorkBook
					.setSEARCHNUM(HthyWritableWorkBook.SEARCHNUM - 1);
		}
		mislist.remove(mislist);
		System.gc();
		zxsheet
				.createOneRow(new String[] { "杂项费用总计：",
						String.valueOf(allprice) });
		zxsheet
				.createOneRow(new String[] { "杂项费用欠款总计：", String.valueOf(allqk) });
		zxsheet.sheetOver();
		book.flush();
		book.write();
		book.close();

	}

	/**
	 * @return 获得报表统计时间段
	 */
	private String getStattime(String begintime, String endtime) {
		String time = "所有时间段";
		if (begintime != null && begintime.trim().length() > 0
				&& endtime != null && endtime.trim().length() > 0) {

			return begintime + " 00:00:00----" + endtime + " 23:59:59";

		} else if (begintime != null && begintime.trim().length() > 0) {
			return begintime + " 00:00:00 后";
		} else if (endtime != null && endtime.trim().length() > 0) {
			return endtime + " 23:59:59 前";
		}
		return time;

	}

	public String getZftime(long orderid) {
		String where = " WHERE C_ORDERINFOID=" + orderid + " AND C_STATE=10";
		List<Orderinforc> rc = Server.getInstance().getAirService()
				.findAllOrderinforc(where, "", -1, 0);
		if (rc.size() > 0) {
			return this.formatTimestamptoMinute(rc.get(0).getCreatetime());
		}
		return "";
	}

	private float getHQprice(long passengerid) {
		Passenger passenger = Server.getInstance().getAirService()
				.findPassenger(passengerid);
		float price = 0f;
		price += converNull(passenger.getPrice(), 0f)
				+ converNull(passenger.getFuelprice(), 0f)
				+ converNull(passenger.getAirportfee(), 0f)
				+ passenger.getInsurprice();

		return price;
	}

	/**
	 * 获得所有个人挂账欠款
	 * 
	 * @return
	 */
	private float getAllgrgzPrice() {
		float arrearage = 0f;
		String otherwhere = " AND C_FKMETHOD=7";
		List<Map> pricemap = Server.getInstance().getSystemService()
				.findMapResultByProcedure(
						" [dbo].[sp_getqkbyagent] @WHERE = N' " + otherwhere
								+ " ',@ZWHERE = N'NULL'");
		for (Map m : pricemap) {
			arrearage = Float.valueOf(m.get("qkprice").toString());
		}
		return arrearage;
	}

	private Object nullConver(Object obj, Object t) {
		if (obj == null) {
			return t;
		} else {
			return obj;
		}
	}

	/**
	 * 获得起止票号
	 * 
	 * @param orderid
	 * @return
	 */
	public String getSEticketnum(long orderid, int se) {
		String where = " WHERE " + Passenger.COL_orderid + "=" + orderid;
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		if (passengers != null && passengers.size() > 0) {

			if (passengers.size() == 1) {
				Passenger passengerp = passengers.get(0);
				return passengerp.getTicketnum();
			} else {
				long[] ticketnums = new long[passengers.size()];
				String onetic = passengers.get(0).getTicketnum();
				String head = onetic.substring(0, onetic.indexOf("-") + 1);
				int i = 0;
				for (Passenger passenger : passengers) {
					String pticket = passenger.getTicketnum().trim();
					pticket = pticket.substring(pticket.indexOf("-") + 1);
					long tick = 0;
					if (pticket.length() > 0) {
						tick = Long.valueOf(pticket);
					}
					ticketnums[i] = tick;
					i++;
				}
				Arrays.sort(ticketnums);
				if (se == 1) {
					return head + "" + ticketnums[0];
				} else {
					return head + "" + ticketnums[passengers.size() - 1];
				}

			}

		}
		return "";

	}

	/**
	 * Excel 头部添加查询条件
	 * 
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void addReportOptions(HthyWorkSheet sheet)
			throws RowsExceededException, WriteException {
		sheet.createRow();
		if (isNotNullOrEpt(s_department)) {
			sheet.addCell("部门：", HthyWorkSheet.Blod);
			sheet.addCell(departname);
		}
		if (this.s_internal > -1) {
			sheet.addCell("类型：", HthyWorkSheet.Blod);
			sheet.addCell(s_internal == 0 ? "国内票" : "国际票");
		}
		if (this.getCheckTime(s_begintime, s_endtime).length() > 0) {
			sheet.addCell("出票时间：", HthyWorkSheet.Blod);
			sheet.addCell(this.getCheckTime(s_begintime, s_endtime), 2);
		}
		if (isNotNullOrEpt(sqname)) {
			sheet.addCell("退废申请人：", HthyWorkSheet.Blod);
			sheet.addCell(sqname);
		}
		if (this.getCheckTime(this.sq_begintime, sq_endtime).length() > 0) {
			sheet.addCell("申请时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(this.sq_begintime, sq_endtime), 2);
		}
		if (isNotNullOrEpt(shname)) {
			sheet.addCell("退废审核人：", HthyWorkSheet.Blod);
			sheet.addCell(shname);
		}
		if (this.getCheckTime(this.sh_begintime, sh_endtime).length() > 0) {
			sheet.addCell("退废审核时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(this.sh_begintime, sh_endtime), 2);
		}
		if (isNotNullOrEpt(tkname)) {
			sheet.addCell("退废退款人：", HthyWorkSheet.Blod);
			sheet.addCell(tkname);

		}
		if (this.getCheckTime(this.tk_begintime, tk_endtime).length() > 0) {
			sheet.addCell("退款时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(this.tk_begintime, tk_endtime), 2);
		}
		if (this.getCheckTime(t_begintime, t_endtime).length() > 0) {
			sheet.addCell("退票时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(t_begintime, t_endtime), 2);
		}
		if (this.getCheckTime(f_begintime, f_endtime).length() > 0) {
			sheet.addCell("废票时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(f_begintime, f_endtime), 2);
		}
		if (this.getCheckTime(h_begintime, f_endtime).length() > 0) {
			sheet.addCell("还款时间：", HthyWorkSheet.Blod);
			sheet.addCell(this.getCheckTime(h_begintime, f_endtime), 2);
		}
		if (this.getCheckTime(flight_begintime, flight_endtime).length() > 0) {
			sheet.addCell("航班时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(flight_begintime, flight_endtime), 2);
		}
		if (isNotNullOrEpt(this.s_sendname)) {
			sheet.addCell("配送人：", HthyWorkSheet.Blod);
			sheet.addCell(s_sendname);
		}
		if (this.getCheckTime(send_begintime, send_endtime).length() > 0) {
			sheet.addCell("配送日期：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(send_begintime, send_endtime), 2);
		}
		if (isNotNullOrEpt(this.s_shouyinname)) {
			sheet.addCell("收银人：", HthyWorkSheet.Blod);
			sheet.addCell(s_shouyinname);
		}
		if (this.getCheckTime(shou_begintime, shou_endtime).length() > 0) {
			sheet.addCell("收银时间：", HthyWorkSheet.Blod);
			sheet.addCell(getCheckTime(shou_begintime, shou_endtime), 2);
		}
		if (isNotNullOrEpt(s_ticketname)) {
			sheet.addCell("乘机人：", HthyWorkSheet.Blod);
			sheet.addCell(s_ticketname);
		}
		if (isNotNullOrEpt(s_linkname)) {
			sheet.addCell("联系人：", HthyWorkSheet.Blod);
			sheet.addCell(s_linkname);
		}
		if (isNotNullOrEpt(s_ordername)) {
			sheet.addCell("预订人：", HthyWorkSheet.Blod);
			sheet.addCell(s_ordername);
		}
		if (isNotNullOrEpt(s_chuname)) {
			sheet.addCell("出票人：", HthyWorkSheet.Blod);
			sheet.addCell(s_chuname);
		}
		if (isNotNullOrEpt(s_gzname)) {
			sheet.addCell("挂账人：", HthyWorkSheet.Blod);
			sheet.addCell(s_gzname);
		}
		if (isNotNullOrEpt(s_airname)) {
			sheet.addCell("航空公司：", HthyWorkSheet.Blod);
			sheet.addCell(s_airname);
		}
		if (isNotNullOrEpt(s_flight)) {
			sheet.addCell("航班：", HthyWorkSheet.Blod);
			sheet.addCell(s_flight);
		}
		if (isNotNullOrEpt(s_cabin)) {
			sheet.addCell("舱位：", HthyWorkSheet.Blod);
			sheet.addCell(s_cabin);
		}
		if (isNotNullOrEpt(s_ordernum)) {
			sheet.addCell("订单号：", HthyWorkSheet.Blod);
			sheet.addCell(s_ordernum);
		}
		if (isNotNullOrEpt(piaohao)) {
			sheet.addCell("票号：", HthyWorkSheet.Blod);
			sheet.addCell(piaohao);
		}
		if (isNotNullOrEpt(s_pnr)) {
			sheet.addCell("PNR：", HthyWorkSheet.Blod);
			sheet.addCell(s_pnr);
		}
		if (insurtype > -1) {
			sheet.addCell("机票状态：", HthyWorkSheet.Blod);
			sheet.addCell(this.getOrderStatestr(insurtype));
		}
		if (tickettype > 0) {
			sheet.addCell("机票类型：", HthyWorkSheet.Blod);
			Tickettype type = Server.getInstance().getMemberService()
					.findTickettype(Long.valueOf(tickettype));
		}
		if (tfstate > 0) {
			sheet.addCell("退废票状态：", HthyWorkSheet.Blod);
			String[] str = { "", "", "已废票", "已退票" };
			sheet.addCell(getInsurtype(tfstate, str));
		}
		if (tftype > 0) {
			sheet.addCell("退费票类型：", HthyWorkSheet.Blod);
			String[] str = { "", "自愿", "非自愿" };
		}
		if (s_paymethod > -1) {
			sheet.addCell("支付方式：", HthyWorkSheet.Blod);
			sheet.addCell(this.getPayMethodStr(s_paymethod));
		}
		if (fkmethod > -1) {
			sheet.addCell("付款方式：", HthyWorkSheet.Blod);
			sheet.addCell(this.getFkmethodstr(fkmethod));
		}
		if (fkstate > 0) {
			sheet.addCell("是否付款：", HthyWorkSheet.Blod);
			String[] str = { "", "未付款", "已付款", "部分付款" };
			sheet.addCell(getInsurtype(fkstate, str));
		}
		if (custype >= 0) {
			sheet.addCell("客户类型：", HthyWorkSheet.Blod);
			String[] str = { "所有", "大客户", "所有散客", "当月散客", "非当月散客", "所有分销商" };
			sheet.addCell(getInsurtype(custype, str));
		}

		sheet.rowOver();
	}

	private int addExcelSelect(WritableSheet sheet, int line)
			throws RowsExceededException, WriteException {
		Label cxtj = new Label(0, ++line, "查询条件：");
		sheet.addCell(cxtj);
		++line;
		int i = 1;
		int j = 0;
		if (isNotNullOrEpt(s_department)) {
			Label label0 = new Label(++j, line, "部门：");
			Label label1 = new Label(++j, line, departname);
			// sheet.mergeCells(j, line, j + 2, line);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (this.s_internal > -1) {
			Label label0 = new Label(++j, line, "类型：");
			Label label1 = new Label(++j, line, s_internal == 0 ? "国内票" : "国际票");
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (this.getCheckTime(s_begintime, s_endtime, "").length() > 0) {
			Label label0 = new Label(++j, line, "出票时间：");
			Label label1 = new Label(++j, line, this.getStattime(s_begintime,
					s_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(sqname)) {
			Label label0 = new Label(++j, line, "退废申请人：");
			Label label1 = new Label(++j, line, sqname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (this.getCheckTime(this.sq_begintime, sq_endtime, "").length() > 0) {
			Label label0 = new Label(++j, line, "申请时间：");
			Label label1 = new Label(++j, line, this.getStattime(sq_begintime,
					sq_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(shname)) {
			Label label0 = new Label(++j, line, "退废审核人：");
			Label label1 = new Label(++j, line, shname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (this.getCheckTime(this.sh_begintime, sh_endtime, "").length() > 0) {
			Label label0 = new Label(++j, line, "退废审核时间：");
			Label label1 = new Label(++j, line, this.getStattime(sh_begintime,
					sh_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(tkname)) {
			Label label0 = new Label(++j, line, "退废退款人：");
			Label label1 = new Label(++j, line, tkname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (this.getCheckTime(this.tk_begintime, tk_endtime, "").length() > 0) {
			Label label0 = new Label(++j, line, "退款时间：");
			Label label1 = new Label(++j, line, this.getStattime(tk_begintime,
					tk_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(t_begintime) || isNotNullOrEpt(t_endtime)) {
			Label label0 = new Label(++j, line, "退票时间时间：");
			Label label1 = new Label(++j, line, getStattime(t_begintime,
					t_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(f_begintime) || isNotNullOrEpt(f_endtime)) {
			Label label0 = new Label(++j, line, "废票时间：");
			Label label1 = new Label(++j, line, this.getStattime(f_begintime,
					f_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(h_begintime) || isNotNullOrEpt(f_endtime)) {
			Label label0 = new Label(++j, line, "还款时间：");
			Label label1 = new Label(++j, line, this.getStattime(h_begintime,
					h_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(flight_begintime) || isNotNullOrEpt(flight_endtime)) {
			Label label0 = new Label(++j, line, "航班时间：");
			Label label1 = new Label(++j, line, this.getStattime(
					flight_begintime, flight_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(send_begintime) || isNotNullOrEpt(send_endtime)) {
			Label label0 = new Label(++j, line, "配送日期：");
			Label label1 = new Label(++j, line, this.getStattime(
					send_begintime, send_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(shou_begintime) || isNotNullOrEpt(shou_endtime)) {
			Label label0 = new Label(++j, line, "收银时间：");
			Label label1 = new Label(++j, line, this.getStattime(
					shou_begintime, shou_endtime));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_ticketname)) {
			Label label0 = new Label(++j, line, "乘机人：");
			Label label1 = new Label(++j, line, s_ticketname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_linkname)) {
			Label label0 = new Label(++j, line, "联系人：");
			Label label1 = new Label(++j, line, s_linkname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_ordername)) {
			Label label0 = new Label(++j, line, "预订人：");
			Label label1 = new Label(++j, line, s_ordername);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_chuname)) {
			Label label0 = new Label(++j, line, "出票人：");
			Label label1 = new Label(++j, line, s_chuname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_gzname)) {
			Label label0 = new Label(++j, line, "挂账人：");
			Label label1 = new Label(++j, line, s_gzname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_tfname)) {
			Label label0 = new Label(++j, line, "退废审核人：");
			Label label1 = new Label(++j, line, s_tfname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(this.s_sendname)) {
			Label label0 = new Label(++j, line, "配送人：");
			Label label1 = new Label(++j, line, s_sendname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(this.s_shouyinname)) {
			Label label0 = new Label(++j, line, "收银人：");
			Label label1 = new Label(++j, line, s_shouyinname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_airname)) {
			Label label0 = new Label(++j, line, "航空公司：");
			Label label1 = new Label(++j, line, s_airname);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_flight)) {
			Label label0 = new Label(++j, line, "航班：");
			Label label1 = new Label(++j, line, s_flight);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_cabin)) {
			Label label0 = new Label(++j, line, "舱位：");
			Label label1 = new Label(++j, line, s_cabin);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_ordernum)) {
			Label label0 = new Label(++j, line, "订单号：");
			Label label1 = new Label(++j, line, s_ordernum);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(piaohao)) {
			Label label0 = new Label(++j, line, "票号：");
			Label label1 = new Label(++j, line, piaohao);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (isNotNullOrEpt(s_pnr)) {
			Label label0 = new Label(++j, line, "PNR：");
			Label label1 = new Label(++j, line, s_pnr);
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (insurtype > -1) {
			Label label0 = new Label(++j, line, "机票状态：");
			Label label1 = new Label(++j, line, this
					.getOrderStatestr(insurtype));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			i += 3;
			++j;
		}
		if (tickettype > 0) {
			Label label0 = new Label(++j, line, "机票类型：");
			Tickettype type = Server.getInstance().getMemberService()
					.findTickettype(Long.valueOf(tickettype));
			Label label1 = new Label(++j, line, type.getTypename());
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			i += 3;
			++j;
		}
		if (tfstate > 0) {
			Label label0 = new Label(++j, line, "退废票状态：");
			String[] str = { "", "", "已废票", "已退票" };
			Label label1 = new Label(++j, line, getInsurtype(tfstate, str));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (tftype > 0) {
			Label label0 = new Label(++j, line, "退费票类型：");
			String[] str = { "", "自愿", "非自愿" };
			Label label1 = new Label(++j, line, getInsurtype(tftype, str));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (s_paymethod > -1) {
			Label label0 = new Label(++j, line, "支付方式：");
			Label label1 = new Label(++j, line, this
					.getPayMethodStr(s_paymethod));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		if (fkmethod > -1) {
			Label label0 = new Label(++j, line, "付款方式：");
			Label label1 = new Label(++j, line, this.getFkmethodstr(fkmethod));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			i += 3;
			++j;
		}
		if (fkstate > 0) {
			Label label0 = new Label(++j, line, "是否付款：");
			String[] str = { "", "未付款", "已付款", "部分付款" };
			Label label1 = new Label(++j, line, getInsurtype(fkstate, str));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			i += 3;
			++j;
		}
		if (custype >= 0) {
			Label label0 = new Label(++j, line, "客户类型：");
			String[] str = { "所有", "大客户", "所有散客", "当月散客", "非当月散客", "所有分销商" };
			Label label1 = new Label(++j, line, getInsurtype(custype, str));
			sheet.addCell(label0);
			sheet.addCell(label1);
			if (i % 20 == 0) {
				++line;
				j = 0;
			}
			;
			i += 3;
			++j;
		}
		return line + 1;
	}

	private String getInsurtype(int type, String[] values) {
		String r = "";
		switch (type) {
		case -1:
			r = "";
			break;
		case 0:
			r = values[0];
			break;
		case 1:
			r = values[1];
			break;
		case 2:
			r = values[2];
			break;
		case 3:
			r = values[3];
			break;
		case 4:
			r = values[4];
			break;
		case 5:
			r = values[5];
			break;
		case 6:
			r = values[6];
			break;
		case 7:
			r = values[7];
			break;
		case 8:
			r = values[8];
			break;
		case 9:
			r = values[9];
			break;
		}
		return r;
	}

	public String getFkmethodstr(int state) {
		return OrderinfoAction.getFkmethodstr(state);
	}

	/**
	 * @param orderid
	 * @return 机票价格
	 */
	public float getTicketPrice(long orderid) {
		float price = 0f;
		String where = " WHERE " + Passenger.COL_orderid + "=" + orderid;
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		if (passengers != null && passengers.size() > 0) {
			for (Passenger passenger : passengers) {
				if (passenger.getPrice() == null) {
					passenger.setPrice(0f);
				}
				price += passenger.getPrice();
			}
		}
		return price;

	}

	/**
	 * 获得乘机人
	 * 
	 * @param orderid
	 * @return
	 */
	public String getPassengername(long orderid) {
		String name = "";
		String where = " WHERE " + Passenger.COL_orderid + "=" + orderid;
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		if (passengers != null && passengers.size() > 0) {

			for (Passenger passenger : passengers) {
				if (name.length() > 0) {
					name += "<br/>" + passenger.getName();
				} else {
					name += passenger.getName();
				}
			}
		}
		return name;

	}

	/**
	 * 
	 * 根据订单号orderid和要获得的值的代表zd 返回对应的值； t：0：航空公司，1：航程，2，航班号，3，航班时间 4，仓位,5:机票全价
	 * 
	 * @param orderid
	 * @param zd
	 * @return
	 */
	private long corderid = 0l;// 仅用于 getSegmentInfo
	private List<Segmentinfo> segments = null;// 仅用于 getSegmentInfo

	public String getSegmentInfo(long orderid, int t) {
		String flighinfo = "";
		if (orderid != corderid || segments == null) {
			String where = " WHERE " + Segmentinfo.COL_orderid + "=" + orderid;
			segments = (List<Segmentinfo>) Server.getInstance().getAirService()
					.findAllSegmentinfo(where, "", -1, 0);
		}
		int i = 0;
		for (Segmentinfo segment : segments) {
			if (i > 0) {
				flighinfo += "<br/>";
				switch (t) {
				case 0:
					flighinfo += this.getAircomapnycodeByEZM(segment
							.getAircomapnycode());
					break;
				case 1:
					flighinfo += getCitynameByAirport(segment.getStartairport())
							+ "--"
							+ getCitynameByAirport(segment.getEndairport());
					break;
				case 2:
					flighinfo += segment.getFlightnumber();
					break;
				case 3:
					flighinfo += formatTimestamptoMinute(segment
							.getDeparttime());
					break;
				case 4:
					flighinfo += segment.getCabincode();
					break;
				case 5:
					flighinfo += String.valueOf(converNull(segment.getYprice(),
							0f));
					break;
				case 6:
					flighinfo += String.valueOf(converNull(segment
							.getDiscount(), 0f));
					break;
				}

			} else {
				switch (t) {
				case 0:
					flighinfo += this.getAircomapnycodeByEZM(segment
							.getAircomapnycode());
					break;
				case 1:
					flighinfo += getCitynameByAirport(segment.getStartairport())
							+ "--"
							+ getCitynameByAirport(segment.getEndairport());
					break;
				case 2:
					flighinfo += segment.getFlightnumber();
					break;
				case 3:
					flighinfo += formatTimestamptoMinute(segment
							.getDeparttime());
					break;
				case 4:
					flighinfo += segment.getCabincode();
					break;
				case 5:
					flighinfo += String.valueOf(converNull(segment.getYprice(),
							0f));
					break;
				case 6:
					flighinfo += String.valueOf(converNull(segment
							.getDiscount(), 0f));
					break;
				}
			}
			i++;
		}
		corderid = orderid;
		return flighinfo;

	}

	public String getFlightDate(long orderid) {
		try {
			Segmentinfo segment = (Segmentinfo) Server
					.getInstance()
					.getAirService()
					.findAllSegmentinfo(
							" WHERE " + Segmentinfo.COL_orderid + "=" + orderid,
							"", -1, 0).get(0);
			return super.formatTimestamptoMinute(segment.getDeparttime());
		} catch (Exception e) {

		}
		return "";

	}

	public String getFlight(long orderid, int num) {
		String where = " WHERE " + Segmentinfo.COL_orderid + "=" + orderid;
		List<Segmentinfo> segments = (List<Segmentinfo>) Server.getInstance()
				.getAirService().findAllSegmentinfo(where, "", -1, 0);
		Segmentinfo segment = null;
		if (segments.size() > 0) {
			segment = segments.get(0);
			if (num == 1) {
				return getCitynameByAirport(segment.getStartairport());
			} else {

				return getCitynameByAirport(segment.getEndairport());
			}
		}
		return "";

	}

	public String getTuiKuanState(long orderid) {
		String where = " WHERE C_ORDERINFOID=" + orderid + " AND C_STATE=9";
		List<Orderinforc> orderrcs = Server.getInstance().getAirService()
				.findAllOrderinforc(where, "", -1, 0);
		if (orderrcs.size() > 0) {
			return "已退款";
		}
		return "未退款";

	}

	public String getorderinfocode(long id) {// 取订单编号

		return Server.getInstance().getAirService().findOrderinfo(id)
				.getOrdernumber();
	}

	public String getorderinfo_ca(long id) {// 取航空公司2字码
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getAircomapnycode() != null) {
			return list.get(0).getAircomapnycode();

		} else {
			return "";
		}
	}

	public String gethangbanhao(long id) {// 取航班号
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getFlightnumber() != null) {
			return list.get(0).getFlightnumber();

		} else {
			return "";
		}
	}

	public String getchufacity(long id) {// 取出发城市
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getStartairport() != null) {
			return list.get(0).getStartairport();

		} else {
			return "";
		}
	}

	public String getdaodacity(long id) {// 取到达城市
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getEndairport() != null) {
			return list.get(0).getEndairport();

		} else {
			return "";
		}
	}

	public Timestamp geqifeitime(long id) {// 取起飞时间
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		// if(list.size()>0&&list.get(0).getDeparttime()!=null){
		return list.get(0).getDeparttime();

	}

	public String getquanjia(long id) {// 取全价
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getYprice() != null) {
			return list.get(0).getYprice().toString();

		} else {
			return "";
		}
	}

	public String getzhekou(long id) {// 取折扣
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getYprice() != null) {
			return list.get(0).getYprice().toString();

		} else {
			return "";
		}
	}

	public String getzhekoujia(long id) {// 取折扣价
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getParvalue() != null) {
			return list.get(0).getParvalue().toString();

		} else {
			return "";
		}
	}

	public Timestamp getchupiaotime(long id) {// 取出票时间
		return Server.getInstance().getAirService().findOrderinfo(id)
				.getPrinttime();
	}

	public String getzhuangt(long id) {// 取支付状态
		int ss = Server.getInstance().getAirService().findOrderinfo(id)
				.getPaystatus();
		if (ss == 1) {
			return "已支付";
		} else {
			return "未支付";
		}
	}

	public String getbeizhu(long id) {// 取支付状态
		String beizhu = Server.getInstance().getAirService().findOrderinfo(id)
				.getMemo();
		if (beizhu != null && beizhu.length() > 0) {
			return beizhu;
		} else {

			return "";
		}

	}

	public Timestamp gettime(long id) {// 取订单时间
		Timestamp time = Server.getInstance().getAirService().findOrderinfo(id)
				.getCreatetime();

		return time;

	}

	public String getcode(long id) {// 取订单编号
		String code = Server.getInstance().getAirService().findOrderinfo(id)
				.getOrdernumber();
		return code;
	}

	public String getchupiaoren(long id) {// 取出票人
		long userid = Server.getInstance().getAirService().findOrderinfo(id)
				.getUserid();
		String name = Server.getInstance().getMemberService().findCustomeruser(
				userid).getMembername();
		return name;
	}

	/**
	 * @param id
	 *            获得部门名称
	 * @return
	 */
	public String getDepartname(long id, String dept) {// 取出票人所在部门
		String depname = "";
		if (dept.trim().length() > 0 && !dept.equals("-1")) {
			if (s_department.indexOf("c") >= 0) {
				long agentid = Long.valueOf(s_department.substring(1));
				if (agentid == 46) {
					departname = "散客";
				} else {
					departname = Server.getInstance().getMemberService()
							.findCustomeragent(agentid).getAgentcompanyname();
				}

			} else if (dept.contains("@")) {
				long deptid = Long.valueOf(s_department.substring(0,
						s_department.indexOf("@")));
				depname = Server.getInstance().getMemberService()
						.findDepartment(deptid).getName();
			}
		} else {
			depname = Server.getInstance().getMemberService()
					.findCustomeragent(id).getAgentcompanyname();
		}
		return depname;
	}

	public String getzhifutype(long id, int state) {// 取订单支付类型
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(id);
		if (state == 1) {
			return this.getPayMethodStr(orderinfo.getPaymethod());
		} else {
			return this.getFkmethodstr(converNull(orderinfo.getFkmethod(), 0));
		}

	}

	public Float shui(Float airportfee, Float fuelprice) {// 基建+燃油

		return airportfee + fuelprice;

	}

	public String getyinghang(String code) {// 取银行

		List<Traderecord> listTraderecord = Server.getInstance()
				.getMemberService().findAllTraderecord(
						"where 1=1 and " + Traderecord.COL_ordercode + " ='"
								+ code + "'", "", -1, 0);
		if (listTraderecord.size() > 0) {
			return listTraderecord.get(0).getBankcode();
		} else {

			return "无";
		}
	}

	public String getjiaoyicode(String ordercode) {// 取交易代码

		List<Traderecord> listTraderecord = Server.getInstance()
				.getMemberService().findAllTraderecord(
						"where 1=1 and " + Traderecord.COL_ordercode + " ='"
								+ ordercode + "'", "", -1, 0);
		if (listTraderecord.size() > 0) {
			return listTraderecord.get(0).getCode();
		} else {

			return "无";
		}
	}

	/**
	 * @param id
	 * @return 查询PNR
	 */
	public String getpnr(long id) {// 取订单PNR
		Orderinfo info = Server.getInstance().getAirService().findOrderinfo(id);
		return this.getpnr(info);
	}

	public String getpnr(Orderinfo info) {// 取订单PNR
		String pnr = "";
		String littlepnr = info.getPnr();
		if (littlepnr != null && littlepnr.trim().length() > 0) {
			littlepnr += "(小)<br/>";
		} else {
			littlepnr = "";
		}
		String bigpnr = info.getBigpnr();
		if (bigpnr != null && bigpnr.trim().length() > 0) {
			bigpnr += "(大)";
		} else {
			bigpnr = "";
		}
		return littlepnr + bigpnr;
	}

	public String getpnr(String lpnr, String bpnr) {
		String pnr = "";
		if (lpnr != null && lpnr.trim().length() > 0) {
			pnr += lpnr;
		}
		if (bpnr != null && bpnr.trim().length() > 0) {
			if (pnr.trim().length() > 0) {
				pnr += "(小)<br/>" + bpnr + "(大)";
			} else {
				pnr += bpnr;
			}
		}
		return pnr;
	}

	public Timestamp getcreatetime(long id) {// 取订单时间
		Timestamp time = Server.getInstance().getAirService().findOrderinfo(id)
				.getCreatetime();
		return time;
	}

	public String getcangwei(long orderid) {// 取舱位
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " ="
								+ orderid, "", -1, 0);
		if (list.size() > 0) {
			return list.get(0).getCabincode();
		} else {
			return "";
		}
	}

	public Float getfandian(long id) {// 取订单返点
		// String pnr=
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getRatevalue() != null) {
			return list.get(0).getRatevalue();
		} else {

			return 0.00f;
		}

	}

	public String getDeptName(String strDeptID) {
		String strDeptName = "";
		if (strDeptID != null && !strDeptID.equals("")) {
			if (strDeptID.equals("-1")) {
				strDeptName = "<b>部门合计:</b>";
			} else {
				Department depart = Server.getInstance().getMemberService()
						.findDepartment(Long.parseLong(strDeptID));
				if (depart != null) {
					strDeptName = depart.getName();
				}
			}
		}
		return strDeptName;
	}

	public String getAgentName(String strAgentID) {
		String strAgentName = "";

		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(Long.parseLong(strAgentID));
		if (agent != null) {
			strAgentName = agent.getAgentcompanyname();
		}
		return strAgentName;
	}

	// public String getRowColor(String strDeptID)
	// {
	// String strColor="";
	// List<Department>
	// deptlist=Server.getInstance().getMemberService().findAllDepartment("where
	// C_AGENTID=46", "", -1, 0);
	// String[] strarrcolor={"#ff99cc","#c0c0c0","#ffff99","#ccffff"};
	//		
	// for(int i=0;i<deptlist.size();i++)
	// {
	// int index=i%4;
	// strColor=strarrcolor[index].toString();
	//			
	// }
	// return "style='background-color:#"+strColor+"'";
	// }

	public void IsTooMuchUser() throws Exception {
		String strReturn = "0";
		if (HthyWritableWorkBook.getSEARCHNUM() >= 2) {
			strReturn = "1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(strReturn);
		out.flush();
		out.close();
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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

	public List<Orderinfo> getListorderinfo() {
		return listorderinfo;
	}

	public void setListorderinfo(List<Orderinfo> listorderinfo) {
		this.listorderinfo = listorderinfo;
	}

	public List<Passenger> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public List<Department> getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List<Department> deptlist) {
		this.deptlist = deptlist;
	}

	public String getStrMonth() {
		return strMonth;
	}

	public void setStrMonth(String strMonth) {
		this.strMonth = strMonth;
	}

	public String getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}

	public String getStrEndDate() {
		return strEndDate;
	}

	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getPiaohao() {
		return piaohao;
	}

	public void setPiaohao(String piaohao) {
		this.piaohao = piaohao;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getS_ticketname() {
		return s_ticketname;
	}

	public void setS_ticketname(String s_ticketname) {
		this.s_ticketname = s_ticketname;
	}

	public String getS_linkname() {
		return s_linkname;
	}

	public void setS_linkname(String s_linkname) {
		this.s_linkname = s_linkname;
	}

	public String getS_airline() {
		return s_airline;
	}

	public void setS_airline(String s_airline) {
		this.s_airline = s_airline;
	}

	public String getS_tuibegindate() {
		return s_tuibegindate;
	}

	public void setS_tuibegindate(String s_tuibegindate) {
		this.s_tuibegindate = s_tuibegindate;
	}

	public String getS_tuienddate() {
		return s_tuienddate;
	}

	public void setS_tuienddate(String s_tuienddate) {
		this.s_tuienddate = s_tuienddate;
	}

	public String getS_tuitype() {
		return s_tuitype;
	}

	public void setS_tuitype(String s_tuitype) {
		this.s_tuitype = s_tuitype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}

	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public String getS_chuname() {
		return s_chuname;
	}

	public void setS_chuname(String s_chuname) {
		this.s_chuname = s_chuname;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public String getS_createuser() {
		return s_createuser;
	}

	public void setS_createuser(String s_createuser) {
		this.s_createuser = s_createuser;
	}

	public List<Customeragent> getCusagentlist() {
		return cusagentlist;
	}

	public void setCusagentlist(List<Customeragent> cusagentlist) {
		this.cusagentlist = cusagentlist;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getS_ordername() {
		return s_ordername;
	}

	public void setS_ordername(String s_ordername) {
		this.s_ordername = s_ordername;
	}

	public List<Tickettype> getListtickettype() {
		return listtickettype;
	}

	public void setListtickettype(List<Tickettype> listtickettype) {
		this.listtickettype = listtickettype;
	}

	public long getTickettype() {
		return tickettype;
	}

	public void setTickettype(long tickettype) {
		this.tickettype = tickettype;
	}

	public int getInsurtype() {
		return insurtype;
	}

	public void setInsurtype(int insurtype) {
		this.insurtype = insurtype;
	}

	public int getCustype() {
		return custype;
	}

	public void setCustype(int custype) {
		this.custype = custype;
	}

	public int getS_paymethod() {
		return s_paymethod;
	}

	public void setS_paymethod(int s_paymethod) {
		this.s_paymethod = s_paymethod;
	}

	public int getFkmethod() {
		return fkmethod;
	}

	public void setFkmethod(int fkmethod) {
		this.fkmethod = fkmethod;
	}

	public List<Orderinfo> getListorderinfos() {
		return listorderinfos;
	}

	public void setListorderinfos(List<Orderinfo> listorderinfos) {
		this.listorderinfos = listorderinfos;
	}

	public String getS_ordernum() {
		return s_ordernum;
	}

	public void setS_ordernum(String s_ordernum) {
		this.s_ordernum = s_ordernum;
	}

	public String getS_flight() {
		return s_flight;
	}

	public void setS_flight(String s_flight) {
		this.s_flight = s_flight;
	}

	public String getS_cabin() {
		return s_cabin;
	}

	public void setS_cabin(String s_cabin) {
		this.s_cabin = s_cabin;
	}

	public List getDatefeilist() {
		return datefeilist;
	}

	public void setDatefeilist(List datefeilist) {
		this.datefeilist = datefeilist;
	}

	public String getNotoday() {
		return notoday;
	}

	public void setNotoday(String notoday) {
		this.notoday = notoday;
	}

	public String getT_begintime() {
		return t_begintime;
	}

	public void setT_begintime(String t_begintime) {
		this.t_begintime = t_begintime;
	}

	public String getT_endtime() {
		return t_endtime;
	}

	public void setT_endtime(String t_endtime) {
		this.t_endtime = t_endtime;
	}

	public String getF_begintime() {
		return f_begintime;
	}

	public void setF_begintime(String f_begintime) {
		this.f_begintime = f_begintime;
	}

	public String getF_endtime() {
		return f_endtime;
	}

	public void setF_endtime(String f_endtime) {
		this.f_endtime = f_endtime;
	}

	public String getS_tfname() {
		return s_tfname;
	}

	public void setS_tfname(String s_tfname) {
		this.s_tfname = s_tfname;
	}

	public String getIs_first() {
		return is_first;
	}

	public void setIs_first(String is_first) {
		this.is_first = is_first;
	}

	public List getListbigreport() {
		return listbigreport;
	}

	public void setListbigreport(List listbigreport) {
		this.listbigreport = listbigreport;
	}

	public Map<String, String> getPriceSubtotal() {
		return priceSubtotal;
	}

	public void setPriceSubtotal(Map<String, String> priceSubtotal) {
		this.priceSubtotal = priceSubtotal;
	}

	public List<Map> getBiguserqkmaplist() {
		return biguserqkmaplist;
	}

	public void setBiguserqkmaplist(List<Map> biguserqkmaplist) {
		this.biguserqkmaplist = biguserqkmaplist;
	}

	public String getClientmanger() {
		return clientmanger;
	}

	public void setClientmanger(String clientmanger) {
		this.clientmanger = clientmanger;
	}

	public String getS_pnr() {
		return s_pnr;
	}

	public void setS_pnr(String s_pnr) {
		this.s_pnr = s_pnr;
	}

	public String getFlight_begintime() {
		return flight_begintime;
	}

	public void setFlight_begintime(String flight_begintime) {
		this.flight_begintime = flight_begintime;
	}

	public String getFlight_endtime() {
		return flight_endtime;
	}

	public void setFlight_endtime(String flight_endtime) {
		this.flight_endtime = flight_endtime;
	}

	public String getS_airname() {
		return s_airname;
	}

	public void setS_airname(String s_airname) {
		this.s_airname = s_airname;
	}

	public int getTftype() {
		return tftype;
	}

	public void setTftype(int tftype) {
		this.tftype = tftype;
	}

	public int getTfstate() {
		return tfstate;
	}

	public void setTfstate(int tfstate) {
		this.tfstate = tfstate;
	}

	public int getFkstate() {
		return fkstate;
	}

	public void setFkstate(int fkstate) {
		this.fkstate = fkstate;
	}

	public String getH_begintime() {
		return h_begintime;
	}

	public void setH_begintime(String h_begintime) {
		this.h_begintime = h_begintime;
	}

	public String getH_endtime() {
		return h_endtime;
	}

	public void setH_endtime(String h_endtime) {
		this.h_endtime = h_endtime;
	}

	public String getS_gzname() {
		return s_gzname;
	}

	public void setS_gzname(String s_gzname) {
		this.s_gzname = s_gzname;
	}

	public String getIspersonalqk() {
		return ispersonalqk;
	}

	public void setIspersonalqk(String ispersonalqk) {
		this.ispersonalqk = ispersonalqk;
	}

	public List<Map> getGrgzqkmaplist() {
		return grgzqkmaplist;
	}

	public void setGrgzqkmaplist(List<Map> grgzqkmaplist) {
		this.grgzqkmaplist = grgzqkmaplist;
	}

	public int getS_internal() {
		return s_internal;
	}

	public void setS_internal(int s_internal) {
		this.s_internal = s_internal;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	public String getS_sendname() {
		return s_sendname;
	}

	public void setS_sendname(String s_sendname) {
		this.s_sendname = s_sendname;
	}

	public String getS_shouyinname() {
		return s_shouyinname;
	}

	public void setS_shouyinname(String s_shouyinname) {
		this.s_shouyinname = s_shouyinname;
	}

	public String getSend_begintime() {
		return send_begintime;
	}

	public void setSend_begintime(String send_begintime) {
		this.send_begintime = send_begintime;
	}

	public String getSend_endtime() {
		return send_endtime;
	}

	public void setSend_endtime(String send_endtime) {
		this.send_endtime = send_endtime;
	}

	public String getShou_begintime() {
		return shou_begintime;
	}

	public void setShou_begintime(String shou_begintime) {
		this.shou_begintime = shou_begintime;
	}

	public String getShou_endtime() {
		return shou_endtime;
	}

	public void setShou_endtime(String shou_endtime) {
		this.shou_endtime = shou_endtime;
	}

	public String getIs_tfticket() {
		return is_tfticket;
	}

	public void setIs_tfticket(String is_tfticket) {
		this.is_tfticket = is_tfticket;
	}

	public String getSqname() {
		return sqname;
	}

	public void setSqname(String sqname) {
		this.sqname = sqname;
	}

	public String getShname() {
		return shname;
	}

	public void setShname(String shname) {
		this.shname = shname;
	}

	public String getTkname() {
		return tkname;
	}

	public void setTkname(String tkname) {
		this.tkname = tkname;
	}

	public String getSq_begintime() {
		return sq_begintime;
	}

	public void setSq_begintime(String sq_begintime) {
		this.sq_begintime = sq_begintime;
	}

	public String getSq_endtime() {
		return sq_endtime;
	}

	public void setSq_endtime(String sq_endtime) {
		this.sq_endtime = sq_endtime;
	}

	public String getSh_begintime() {
		return sh_begintime;
	}

	public void setSh_begintime(String sh_begintime) {
		this.sh_begintime = sh_begintime;
	}

	public String getSh_endtime() {
		return sh_endtime;
	}

	public void setSh_endtime(String sh_endtime) {
		this.sh_endtime = sh_endtime;
	}

	public String getTk_begintime() {
		return tk_begintime;
	}

	public void setTk_begintime(String tk_begintime) {
		this.tk_begintime = tk_begintime;
	}

	public String getTk_endtime() {
		return tk_endtime;
	}

	public void setTk_endtime(String tk_endtime) {
		this.tk_endtime = tk_endtime;
	}

	public int getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
	}

	public float getPricegather() {
		return pricegather;
	}

	public void setPricegather(float pricegather) {
		this.pricegather = pricegather;
	}

	public float getDutygather() {
		return dutygather;
	}

	public void setDutygather(float dutygather) {
		this.dutygather = dutygather;
	}

	public float getTuifeegather() {
		return tuifeegather;
	}

	public void setTuifeegather(float tuifeegather) {
		this.tuifeegather = tuifeegather;
	}

	public float getInsurfeegather() {
		return insurfeegather;
	}

	public void setInsurfeegather(float insurfeegather) {
		this.insurfeegather = insurfeegather;
	}

	public List getListrebaterecord() {
		return listrebaterecord;
	}

	public void setListrebaterecord(List listrebaterecord) {
		this.listrebaterecord = listrebaterecord;
	}

	public int getS_type() {
		return s_type;
	}

	public void setS_type(int s_type) {
		this.s_type = s_type;
	}

	public Customeragent getCustomeragent() {
		return customeragent;
	}

	public void setCustomeragent(Customeragent customeragent) {
		this.customeragent = customeragent;
	}

	public String getOrderstime() {
		return orderstime;
	}

	public void setOrderstime(String orderstime) {
		this.orderstime = orderstime;
	}

	public String getOrderetime() {
		return orderetime;
	}

	public void setOrderetime(String orderetime) {
		this.orderetime = orderetime;
	}

	public List<Customeragent> getListCustomeragent() {
		return ListCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		ListCustomeragent = listCustomeragent;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public long getParentid() {
		return parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}
	public String getPayMethod(int type){
		//paymethodmap.put(1, "网上支付");
		//paymethodmap.put(2, "门市支付");
		//paymethodmap.put(3, "票到付款");
		//paymethodmap.put(4, "虚拟账户");
		String sub="网上支付";
		
		if(type==1){
			sub="网上支付";
		}
		if(type==2){
			sub="门市支付";
		}
		if(type==3){
			sub="票到付款";
		}
		if(type==4){
			sub="虚拟账户";
		}
		return sub;
	}
}