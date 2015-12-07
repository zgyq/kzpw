/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.sun.org.apache.xpath.internal.operations.Gte;
import com.yf.system.atom.component.WriteLog;
import com.yf.system.back.policy.PolicyNotifySupport;
import com.yf.system.back.server.Server;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.gerenguazhanfrec.Gerenguazhanfrec;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.peisong.Peisong;
import com.yf.system.base.scang.Scang;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.service.IAirService;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.vmoneyrecord.Vmoneyrecord;
import com.yf.system.base.withbank.Withbank;
import com.yf.system.base.ymsend.Ymsend;
import com.yf.system.base.zrate.Zrate;

public class B2borderinfoAction extends B2b2cbackAction {
	private static final long serialVersionUID = 8908166182297986543L;
	private List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
	private Orderinfo orderinfo = new Orderinfo();
	private Orderinfo orderinfo2 = new Orderinfo();
	private Orderinfo orderinfo1 = new Orderinfo();
	private List<Withbank> listfenrun = new ArrayList<Withbank>();
	private List<Passenger> listPassenger = new ArrayList<Passenger>();
	// private List<Insuranceinfo> listInsuranceinfo=new
	// ArrayList<Insuranceinfo>();
	private List<Peisong>listPeisong=new ArrayList<Peisong>();
	private List<Passenger> listPassenger2 = new ArrayList<Passenger>();
	private List<Segmentinfo> listSegment = new ArrayList<Segmentinfo>();
	private List<Segmentinfo> listSegment2 = new ArrayList<Segmentinfo>();
	private List<Cityairport> listCityairport;
	private Customeragent listAgent = new Customeragent();
	private Customeragent listGongAgent = new Customeragent();
	
	private List<Scang> listScang = new ArrayList<Scang>();
	private List<Zrate> ListZrate1=new ArrayList<Zrate>();
	private List<Zrate> ListZrate2=new ArrayList<Zrate>();
	private List<Department> salesroolist;
	private String strPNR;
	private String s_adultpnr;
	private String s_returnpnr = "";
	private String officecode="";//OFFICE
	private String fancaiinfo;//返采备注
	private long zrate_id;
	private Segmentinfo segmentOne = new Segmentinfo();
	private Segmentinfo segmentTwo = new Segmentinfo();
	private long s_agentid;
	private Double s_totalpaymoeny;
	private String forwork;
	private String s_songpaiodanpid;
	private String strSenderID;
	private String strSenderDate;
	private String s_Paindex;
	private String tuigaiindex;
	private String s_feipiaoshenqingsdate;
	private String s_feipiaoshenqingedate;
	private String newordernum;//申请退废新订单号
	
	private String c_memo;//订单备注
	
	private String zratememo;
	
	private int s_isinter = -1;
	private String whyid;// 退废申请理由ID
	private String hidTuoOrFei;// 退OR废 4退 5废
	private String s_oldzratevalue = "0";
	private String s_bestzratevalue = "0";
	private String s_oldorderprice = "0";
	private String s_neworderprice = "0";
	
	private String  TuiFeiType;//
	// ajax更新用政策ID
	private long ajax_zid;
	private String ajax_fromcity;
	private String ajax_tocity;
	private String ajax_code;// 航空公司二字码
	private String ajax_waiid;// 政策外部ID
	private String ajax_zatetype;// 政策所属加盟商
	private String parvalue;//
	private String ajax_vogtype;// 第一程 第2程
	// 批量操作ID数组
	private int[] selectid;
	private String s_paymethod;
	private int orderpaymethod = -1;
	private long temporderuserid;
	private float s_zonglirun = 0f;
	private float s_zonglirun2 = 0f;
	private String bxname;
	private String bxcount;
	
	private String bxprice;
	
	// 是否保存到常用旅客
	private String issavepassenger;
	private String FF_FlightNumber;
	private String FF_date;
	private String FF_StopNum;
	private String s_customeragentid;// 订单所属单位Id
	// 临时ID
	Long idtemp = 0l;
	private String s_contactmobile;
	// 批量操作选项
	private int opt;
	// 跳转用
	private int ty;
	private String forward;
	// 成人乘机人数量
	private int adultnum = 0;
	private String h_ptype;
	private String h_name;
	private String h_idtype;
	private String h_idnumber;
	// 乘机人出生日期
	private String h_birthday;
	private String strTravelHtml;
	private String strTotalPriceOne;
	private String strTotalPriceTwo;
	private int s_orderstatus;
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
	private String h_insurance;
	private String h_savepasenger;
	private Long s_ordertype=0l;
	private String companyname;
	private String s_receipt = "";
	private String s_pnr_inter;
	private String s_tax_inter;
	private String s_adultprice_inter;
	private String s_childprice_inter;
	private static Map<Integer, String> paymethodmap = new HashMap<Integer, String>();
	private String s_tfshenqingren;
	// 退废申请时间范围
	private String s_tfshenqingsdate;
	// 退废申请时间范围结束
	private String s_tfshenqingedate; //

	// 退废审核时间
	private String s_tfshenhesdate;
	private String s_tfshenheedate;
	// 退废审核人员
	private String s_tfshenheren;
	// 改签申请时间
	private String s_gaiqianshenqingsdate;
	private String s_gaiqianshenqingedate;
	// 改签申请人员
	private String s_gaiqianshenqingren;
	// 改签审核人员
	private String s_gaiqianshenheren;
	// 改签审核时间
	private String s_gaiqianshenhesdate;
	private String s_gaiqianshenheedate;
	// 升舱申请人员
	private String s_shengcangshenqingren;
	// 升舱申请时间
	private String s_shengcangshenqingsdate;
	private String s_shengcangshenqingedate;
	// 升舱审核人员
	private String s_shengcangshenheren;
	// 升舱审核时间
	private String s_shengcangshenhesdate;
	private String s_shengcangshenheedate;

	// 换开申请人员
	private String s_huankaishenqingren;
	// 换开申请时间
	private String s_huankaishenqingsdate;
	private String s_huankaishenqingedate;
	// 换开审核人员
	private String s_huankaishenheren;
	// 换开审核时间
	private String s_huankaishenhesdate;
	private String s_huankaishenheedate;

	//
	private Long s_orderid;
	// 预订的开始时间
	private String h_prestarttime;

	// 预订的结束时间
	private String h_preendtime;
	//加盟商名字
	private String agentname;
	
	// pnr
	private String order_pnr;
	private String pnrstr;
	// 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭

	private Long zrate_one;
	private Long zrate_two;
	private String s_contactname;
	private String s_bookername;
	private String s_chupiaoname;
	private String strTuiOrderID;
	private List<Tickettype> listtickettype;
	private long s_tickettypeid;
	private String strNewTicketNum;
	private String strSepPNR;
	private String strTuikuanDesc;
	private long s_employeeid;
	private int no;
	private String beizhu;
	private String tui_tuifeidesc;
	private String tui_nodesc;
	private String passid;
	private String tui;
	private String changedate;//起飞时间
	private String changedate2;//到达时间
	private String changeflight;
	private String changecabin;
	private String changepnr;
	private Long tui_state;
	private Long tui_iscabinsite;
	private int typ;
	private List<Orderinforc> listorderinforc;
	private List<Ymsend> listYmsend;
	private String agentid;// 用于树形菜单

	private String s_createtime;
	private String lockorder="false";

	// 分隔字符串 vic
	private String strSplit = "@";
	// 子分隔符 vic
	private String strSubSplit = ",";
	// 总保险费
	private float orderSafePrice = 0f;
	// 平台费
	private float orderPlat = 0f;
	
	// 行程单费用
	private int xcdPlat = 0;
	
	// 配送费用
	private int xcdpsPlat = 0;
	
	//以下为配送信息
	private String isxcd;//是否需要行程单  0 不要  1要
	private String ispeisong;//是否需要配送行程单  0 不要  1要
	private String lianxiname;//配送联系人
	private String lianxitel;//配送联系人电话
	private String youzhengbianma;//配送地址邮政编码
	private String peisongadd;//配送地址
	//以上为配送信息
	//下单用
	private String s_txtcontactemail;//旅客邮箱
	private String s_txtcaigoumobile;//采购商电话
	
	
	private int	paytype;//支付方式  1网上  4虚拟
	
	private int	s_guoneiguoji;//国内国际  0所有  1国际  2国内

	
	private Long s_tuifeistate=-1l;//退费订单状态 -1  所有
	private Long s_biangengstate=-1l;//变更订单状态 -1  所有
	
	
	// Server.getInstance().getSystemService().findAllSysconfig(" where 1=1 and
	// "+Sysconfig.COL_name+" ='Platformfees'", "", -1, 0)
	public B2borderinfoAction() {
		Sysconfig sysconfig = Server.getInstance().getMemberService()
				.findSysconfig(10022L);
		if (sysconfig != null){
			this.orderPlat = Float.parseFloat(sysconfig.getValue());
		}
		List<Sysconfig>listsys=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='xcdprice'", " ORDER BY ID ", -1, 0);
		if (listsys!=null){
			this.xcdPlat = Integer.parseInt(listsys.get(0).getValue().trim());
		}
		List<Sysconfig>listsys2=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='xcdpsprice'", " ORDER BY ID ", -1, 0);
		if (listsys2!=null){
			this.xcdpsPlat = Integer.parseInt(listsys2.get(0).getValue().trim());
		}
		
		//System.out.println(orderPlat+","+xcdPlat+","+xcdpsPlat);
	}

	

	/*
	 * 初始化定义。
	 */
	static {
		// ----支付方式
		paymethodmap.put(1, "支付宝");
		paymethodmap.put(2, "门市支付");
		paymethodmap.put(3, "票到付款");
		paymethodmap.put(4, "虚拟账户");
		paymethodmap.put(5, "财付通");
		paymethodmap.put(6, "快钱");
		paymethodmap.put(7, "一币支付");
		// paymethodmap.put(5, "月结支付");
		// ----
	}

	
	public String AllChang()throws Exception {
		Customeragent longinagent = this.getLoginsessionagent();
		//System.out.println(longinagent.getAgenttype());
		HttpServletRequest request = ServletActionContext.getRequest();
		agentid = request.getParameter("agentid");
		StringBuilder where = new StringBuilder(" WHERE 1=1  ");
		
		if(s_orderid!=null&&s_orderid>0){
			
			where.append(" and "+Orderinfo.COL_id+" ='"+s_orderid+"'");
		}
		
		if (s_ordertype != null && s_ordertype > 0) {
			where.append(" and " + Orderinfo.COL_ordertype + " = " + s_ordertype);
		}
		
		if(paytype>0){
			
			where.append(" and "+Orderinfo.COL_paymethod+" ="+paytype);
		}
		
		
				if(agentname!=null&&agentname.length()>0){
					
					where.append(" and "+Orderinfo.COL_buyagentid+" in ( SELECT "+Customeragent.COL_id+" from "+Customeragent.TABLE+" where 1=1 and "+Customeragent.COL_agentcompanyname+" like '%"+agentname+"%') ");
				}
	
		
		
		
		if (longinagent.getAgenttype() != 2) {//
			if (isNotNullOrEpt(agentid)) {//显示当前代理和下级订单
				long agid = Long.valueOf(agentid);
				if (agid < 0) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
									+ (0 - agid));
					if (longinagent.getAgenttype() != 1) {
						where.append("  AND  charindex(','+CONVERT(nvarchar,"
								+ longinagent.getId()
								+ ")+',',','+C_PARENTSTR+',')> 0 ");
					}
					where.append(")");
				} else {
					where.append(" AND  C_BUYAGENTID=" + agentid);
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
			/*if(longinagent.getAgenttype()==3){//只显示当前代理订单
				where.append(" AND  C_BUYAGENTID=" + longinagent.getId());
				
			}*/
			
		} else {
			where.append(" AND( " + Orderinfo.COL_policyagentid + "="
					+ longinagent.getId() + " OR  C_BUYAGENTID="
					+ longinagent.getId() + " )");

		}
		if (isNotNullOrEpt(this.s_ordernumber)) {
			where.append(" AND C_ORDERNUMBER ='" + s_ordernumber + "'");
		}
		if (isNotNullOrEpt(s_createtime)) {
			where.append(" AND " + Orderinfo.COL_createtime + " = '"
					+ s_createtime + "'");
		}
		
		
		String orderstatus = String.valueOf("14,15,13");
		
		if (s_biangengstate ==1) {//当日
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			String startDate = sdf.format(calendar.getTime());
			
			String todaytime = this.getCheckTime(startDate, startDate,
					Orderinfo.COL_updatetime);
			if (todaytime != null && todaytime.trim().length() != 0) {// 出票时间
				where.append(" AND (" + todaytime + ") ");
			}
		}
		
		if (s_biangengstate ==3||s_biangengstate ==4) {//申请中的
			
			orderstatus = String.valueOf("13");
		}
		if (s_biangengstate ==5) {//改前完成
			
			orderstatus = String.valueOf("14");
		}
		
		where.append("  and ( " + Orderinfo.COL_orderstatus + " IN ("+ orderstatus + "))");
		
		
		
		if (isNotNullOrEpt(this.lockorder) && lockorder.equals("true")) {
			where.append(" AND " + Orderinfo.COL_userid + " >0 ");
		}
		if (isNotNullOrEpt(this.s_receipt) && s_receipt.equals("true")) {
			where.append(" and " + Orderinfo.COL_orderstatus + "=3  AND "
					+ Orderinfo.COL_receipt + "=4");
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where.append(" AND( C_PNR ='" + s_pnr + "' or C_BIGPNR='" + s_pnr
					+ "')");
		}
		// if (s_isinter != -1) {
		// if (s_isinter == 1) {
		// where += " AND " + Orderinfo.COL_internal + "=" + s_isinter;
		// } else if (s_isinter == 0) {
		// where += " AND (" + Orderinfo.COL_internal + " is null or "
		// + Orderinfo.COL_internal + "=0)";
		// }
		// }
		String flighttime = this.getCheckTime(s_beginchengji, s_endchengji,
				"C_DEPARTTIME");
		if (isNotNullOrEpt(flighttime)) {// 乘机日期
			where.append(" AND ID "
					+ " IN (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] WHERE "
					+ flighttime + ")");
		}
		String insuretime = this.getCheckTime(s_beginprinttime, s_endprinttime,
				Orderinfo.COL_printtime);
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {// 出票时间
			where.append(" AND (" + insuretime + ") ");
		}
		if (isNotNullOrEpt(s_passengername)) {// 乘机人
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
							+ s_passengername + "%')");
		}
		if (isNotNullOrEpt(s_passengerfet)) {// 票号
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_TICKETNUM] like '%"
							+ s_passengerfet + "%')");
		}
		if (isNotNullOrEpt(s_flightnumber)) {// 航班号
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
							+ s_flightnumber + "%')");
		}
		if (orderpaymethod > -1) {
			where.append(" AND " + Orderinfo.COL_paymethod + "="
					+ orderpaymethod);
		}
		// 联系人姓名
		// if (isNotNullOrEpt(s_contactname)) {
		// where += " AND " + Orderinfo.COL_contactname + " LIKE '%"
		// + s_contactname + "%' ";
		// 预订人姓名
		if (isNotNullOrEpt(s_bookername)) {
			where
					.append(" and "
							+ Orderinfo.COL_saleagentid
							+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
							+ s_bookername.trim()
							+ "%' and C_TYPE = 1 and C_AGENTID=46) ");
		}
		// 出票人姓名
		if (isNotNullOrEpt(s_chupiaoname)) {
			where.append(" and ID "
					+ " in (SELECT DISTINCT(C_ORDERINFOID) FROM "
					+ "T_ORDERINFORC WHERE C_CUSTOMERUSERID IN (SELECT ID "
					+ "FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
					+ s_chupiaoname + "%')) ");
		}

		if (this.isNotNullOrEpt(s_tfshenqingren)) {// 退废申请人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfshenqingren + "%' ) AND C_STATE IN (4,5) )");
		}
		String sqtime = this.getCheckTime(s_tfshenqingsdate, s_tfshenqingedate,
				"C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
							+ sqtime + "))");
		}
		if (this.isNotNullOrEpt(s_tfshenheren)) {// 退废审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfshenheren
							+ "%' ) AND C_STATE IN (7,17,11,12) )");
		}
		String shtime = this.getCheckTime(s_tfshenhesdate, s_tfshenheedate,
				"C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
							+ shtime + "))");
		}
		if (this.isNotNullOrEpt(s_gaiqianshenqingren)) {// 改签申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_gaiqianshenqingren
							+ "%' ) AND C_STATE IN (13) )");
		}
		String gqsqtime = this.getCheckTime(s_gaiqianshenqingsdate,
				s_gaiqianshenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(13) AND ("
							+ gqsqtime + "))");
		}

		if (this.isNotNullOrEpt(s_gaiqianshenheren)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_gaiqianshenheren
							+ "%' ) AND C_STATE IN (14,15) )");
		}
		String gqshtime = this.getCheckTime(s_gaiqianshenhesdate,
				s_gaiqianshenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(14,15) AND ("
							+ gqshtime + "))");
		}

		if (this.isNotNullOrEpt(s_shengcangshenqingren)) {// 升舱申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shengcangshenqingren
							+ "%' ) AND C_STATE IN (23) )");
		}
		String scsqtime = this.getCheckTime(s_shengcangshenqingsdate,
				s_shengcangshenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(23) AND ("
							+ scsqtime + "))");
		}
		if (this.isNotNullOrEpt(s_shengcangshenheren)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shengcangshenheren
							+ "%' ) AND C_STATE IN (25,26) )");
		}
		String scshtime = this.getCheckTime(s_shengcangshenhesdate,
				s_shengcangshenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(25,26) AND ("
							+ scshtime + "))");
		}

		if (this.isNotNullOrEpt(s_huankaishenqingren)) {// 换开申请人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_huankaishenqingren
							+ "%' ) AND C_STATE IN (30) )");
		}
		String hksqtime = this.getCheckTime(s_huankaishenqingsdate,
				s_huankaishenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(30) AND ("
							+ hksqtime + "))");
		}
		if (this.isNotNullOrEpt(s_huankaishenheren)) {// 审核人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_huankaishenheren
							+ "%' ) AND C_STATE IN (24,31) )");
		}
		String hkshtime = this.getCheckTime(s_huankaishenhesdate,
				s_huankaishenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(245,31) AND ("
							+ hkshtime + "))");
		}
		String extstatus = request.getParameter("extstatus");
		if (extstatus != null) {
			int exts = Integer.valueOf(extstatus.toString());
			if (exts == 3) {
				String overoutwhere = " AND C_ORDERSTATUS <3 AND "
						+ "  ( C_POLICYAGENTID=3 AND C_EXTORDERSTATUS=3)";
				where.append(overoutwhere);
			} else if (exts == 4) {
				where.append(" AND C_ORDERSTATUS IN (4,5)");
			} else if (exts == 5) {

				where.append(" AND C_EXTORDERSTATUS IN (8,11) ");
			}
		}
		
		
		String yudtime = this.getCheckTime(s_feipiaoshenqingsdate, s_feipiaoshenqingedate,
		"C_CREATETIME");
		
		System.out.println("yudtime:"+yudtime);
		if (isNotNullOrEpt(yudtime)) {// 预定日期
			where.append(" AND  "+ yudtime);
		}
		
		
		if(s_guoneiguoji==1){
			where.append(" AND "+Orderinfo.COL_internal+" ="+s_guoneiguoji);
		}
		if(s_guoneiguoji==2){
			where.append(" AND "+Orderinfo.COL_internal+" !=1");
		}
		
		
		
		
		System.out.println("where:"+where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where.toString(),
						" ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		//加载加盟商开始
		String agentroot = new CustomeragentAction().getAgentRoot();
		request.setAttribute("agentroot", agentroot);
        //结束
		System.out.println("agentroot:"+agentroot);
		System.out.println("B2borderinfoAction.execute()---biangeng.jsp");
		
		
		
		return "AllChang";
	}
	public String AllTuiFei()throws Exception {
		Customeragent longinagent = this.getLoginsessionagent();
		//System.out.println(longinagent.getAgenttype());
		HttpServletRequest request = ServletActionContext.getRequest();
		agentid = request.getParameter("agentid");
		StringBuilder where = new StringBuilder(" WHERE 1=1  ");
		
		if(s_orderid!=null&&s_orderid>0){
			
			where.append(" and "+Orderinfo.COL_id+" ='"+s_orderid+"'");
		}
		
		if (s_ordertype != null && s_ordertype > 0) {
			where.append(" and " + Orderinfo.COL_ordertype + " = " + s_ordertype);
		}
		
		if(paytype>0){
			
			where.append(" and "+Orderinfo.COL_paymethod+" ="+paytype);
		}
		
		
				if(agentname!=null&&agentname.length()>0){
					
					where.append(" and "+Orderinfo.COL_buyagentid+" in ( SELECT "+Customeragent.COL_id+" from "+Customeragent.TABLE+" where 1=1 and "+Customeragent.COL_agentcompanyname+" like '%"+agentname+"%') ");
				}
	
		
		
		
		if (longinagent.getAgenttype() != 2) {//
			if (isNotNullOrEpt(agentid)) {//显示当前代理和下级订单
				long agid = Long.valueOf(agentid);
				if (agid < 0) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
									+ (0 - agid));
					if (longinagent.getAgenttype() != 1) {
						where.append("  AND  charindex(','+CONVERT(nvarchar,"
								+ longinagent.getId()
								+ ")+',',','+C_PARENTSTR+',')> 0 ");
					}
					where.append(")");
				} else {
					where.append(" AND  C_BUYAGENTID=" + agentid);
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
			/*if(longinagent.getAgenttype()==3){//只显示当前代理订单
				where.append(" AND  C_BUYAGENTID=" + longinagent.getId());
				
			}*/
			
		} else {
			where.append(" AND( " + Orderinfo.COL_policyagentid + "="
					+ longinagent.getId() + " OR  C_BUYAGENTID="
					+ longinagent.getId() + " )");

		}
		if (isNotNullOrEpt(this.s_ordernumber)) {
			where.append(" AND C_ORDERNUMBER ='" + s_ordernumber + "'");
		}
		if (isNotNullOrEpt(s_createtime)) {
			where.append(" AND " + Orderinfo.COL_createtime + " = '"
					+ s_createtime + "'");
		}
		
		
		String orderstatus = String.valueOf("4,5,7,9,11,12,17,18");
		
		if (s_tuifeistate ==1) {//当日
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			String startDate = sdf.format(calendar.getTime());
			
			String todaytime = this.getCheckTime(startDate, startDate,
					Orderinfo.COL_updatetime);
			if (todaytime != null && todaytime.trim().length() != 0) {// 出票时间
				where.append(" AND (" + todaytime + ") ");
			}
		}
		if (s_tuifeistate ==2) {//暂不能退废票
			
			orderstatus = String.valueOf("7,17");
		}
		if (s_tuifeistate ==3||s_tuifeistate ==1) {//申请中的
			
			orderstatus = String.valueOf("4,5");
		}
		if (s_tuifeistate ==5) {//已经退款的
			
			orderstatus = String.valueOf("9,18");
		}
		if (s_tuifeistate ==6) {//审核通过待退款
			
			orderstatus = String.valueOf("11,12");
		}
		where.append("  and ( " + Orderinfo.COL_orderstatus + " IN ("+ orderstatus + "))");
		
		
		
		if (isNotNullOrEpt(this.lockorder) && lockorder.equals("true")) {
			where.append(" AND " + Orderinfo.COL_userid + " >0 ");
		}
		if (isNotNullOrEpt(this.s_receipt) && s_receipt.equals("true")) {
			where.append(" and " + Orderinfo.COL_orderstatus + "=3  AND "
					+ Orderinfo.COL_receipt + "=4");
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where.append(" AND( C_PNR ='" + s_pnr + "' or C_BIGPNR='" + s_pnr
					+ "')");
		}
		// if (s_isinter != -1) {
		// if (s_isinter == 1) {
		// where += " AND " + Orderinfo.COL_internal + "=" + s_isinter;
		// } else if (s_isinter == 0) {
		// where += " AND (" + Orderinfo.COL_internal + " is null or "
		// + Orderinfo.COL_internal + "=0)";
		// }
		// }
		String flighttime = this.getCheckTime(s_beginchengji, s_endchengji,
				"C_DEPARTTIME");
		if (isNotNullOrEpt(flighttime)) {// 乘机日期
			where.append(" AND ID "
					+ " IN (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] WHERE "
					+ flighttime + ")");
		}
		String insuretime = this.getCheckTime(s_beginprinttime, s_endprinttime,
				Orderinfo.COL_printtime);
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {// 出票时间
			where.append(" AND (" + insuretime + ") ");
		}
		if (isNotNullOrEpt(s_passengername)) {// 乘机人
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
							+ s_passengername + "%')");
		}
		if (isNotNullOrEpt(s_passengerfet)) {// 票号
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_TICKETNUM] like '%"
							+ s_passengerfet + "%')");
		}
		if (isNotNullOrEpt(s_flightnumber)) {// 航班号
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
							+ s_flightnumber + "%')");
		}
		if (orderpaymethod > -1) {
			where.append(" AND " + Orderinfo.COL_paymethod + "="
					+ orderpaymethod);
		}
		// 联系人姓名
		// if (isNotNullOrEpt(s_contactname)) {
		// where += " AND " + Orderinfo.COL_contactname + " LIKE '%"
		// + s_contactname + "%' ";
		// 预订人姓名
		if (isNotNullOrEpt(s_bookername)) {
			where
					.append(" and "
							+ Orderinfo.COL_saleagentid
							+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
							+ s_bookername.trim()
							+ "%' and C_TYPE = 1 and C_AGENTID=46) ");
		}
		// 出票人姓名
		if (isNotNullOrEpt(s_chupiaoname)) {
			where.append(" and ID "
					+ " in (SELECT DISTINCT(C_ORDERINFOID) FROM "
					+ "T_ORDERINFORC WHERE C_CUSTOMERUSERID IN (SELECT ID "
					+ "FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
					+ s_chupiaoname + "%')) ");
		}

		if (this.isNotNullOrEpt(s_tfshenqingren)) {// 退废申请人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfshenqingren + "%' ) AND C_STATE IN (4,5) )");
		}
		String sqtime = this.getCheckTime(s_tfshenqingsdate, s_tfshenqingedate,
				"C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
							+ sqtime + "))");
		}
		if (this.isNotNullOrEpt(s_tfshenheren)) {// 退废审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfshenheren
							+ "%' ) AND C_STATE IN (7,17,11,12) )");
		}
		String shtime = this.getCheckTime(s_tfshenhesdate, s_tfshenheedate,
				"C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
							+ shtime + "))");
		}
		if (this.isNotNullOrEpt(s_gaiqianshenqingren)) {// 改签申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_gaiqianshenqingren
							+ "%' ) AND C_STATE IN (13) )");
		}
		String gqsqtime = this.getCheckTime(s_gaiqianshenqingsdate,
				s_gaiqianshenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(13) AND ("
							+ gqsqtime + "))");
		}

		if (this.isNotNullOrEpt(s_gaiqianshenheren)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_gaiqianshenheren
							+ "%' ) AND C_STATE IN (14,15) )");
		}
		String gqshtime = this.getCheckTime(s_gaiqianshenhesdate,
				s_gaiqianshenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(14,15) AND ("
							+ gqshtime + "))");
		}

		if (this.isNotNullOrEpt(s_shengcangshenqingren)) {// 升舱申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shengcangshenqingren
							+ "%' ) AND C_STATE IN (23) )");
		}
		String scsqtime = this.getCheckTime(s_shengcangshenqingsdate,
				s_shengcangshenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(23) AND ("
							+ scsqtime + "))");
		}
		if (this.isNotNullOrEpt(s_shengcangshenheren)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shengcangshenheren
							+ "%' ) AND C_STATE IN (25,26) )");
		}
		String scshtime = this.getCheckTime(s_shengcangshenhesdate,
				s_shengcangshenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(25,26) AND ("
							+ scshtime + "))");
		}

		if (this.isNotNullOrEpt(s_huankaishenqingren)) {// 换开申请人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_huankaishenqingren
							+ "%' ) AND C_STATE IN (30) )");
		}
		String hksqtime = this.getCheckTime(s_huankaishenqingsdate,
				s_huankaishenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(30) AND ("
							+ hksqtime + "))");
		}
		if (this.isNotNullOrEpt(s_huankaishenheren)) {// 审核人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_huankaishenheren
							+ "%' ) AND C_STATE IN (24,31) )");
		}
		String hkshtime = this.getCheckTime(s_huankaishenhesdate,
				s_huankaishenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(245,31) AND ("
							+ hkshtime + "))");
		}
		String extstatus = request.getParameter("extstatus");
		if (extstatus != null) {
			int exts = Integer.valueOf(extstatus.toString());
			if (exts == 3) {
				String overoutwhere = " AND C_ORDERSTATUS <3 AND "
						+ "  ( C_POLICYAGENTID=3 AND C_EXTORDERSTATUS=3)";
				where.append(overoutwhere);
			} else if (exts == 4) {
				where.append(" AND C_ORDERSTATUS IN (4,5)");
			} else if (exts == 5) {

				where.append(" AND C_EXTORDERSTATUS IN (8,11) ");
			}
		}
		
		
		String yudtime = this.getCheckTime(s_feipiaoshenqingsdate, s_feipiaoshenqingedate,
		"C_CREATETIME");
		
		System.out.println("yudtime:"+yudtime);
		if (isNotNullOrEpt(yudtime)) {// 预定日期
			where.append(" AND  "+ yudtime);
		}
		
		
		if(s_guoneiguoji==1){
			where.append(" AND "+Orderinfo.COL_internal+" ="+s_guoneiguoji);
		}
		if(s_guoneiguoji==2){
			where.append(" AND "+Orderinfo.COL_internal+" !=1");
		}
		
		
		
		
		System.out.println("where:"+where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where.toString(),
						" ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		//加载加盟商开始
		String agentroot = new CustomeragentAction().getAgentRoot();
		request.setAttribute("agentroot", agentroot);
        //结束
		System.out.println("agentroot:"+agentroot);
		System.out.println("B2borderinfoAction.execute()---tuifeiorder.jsp");
		
		
		
		
		return "AllTuiFei";
	}
	
	/**
	 * 列表查询订单信息表
	 */
	public String execute() throws Exception {
		Customeragent longinagent = this.getLoginsessionagent();
		//System.out.println(longinagent.getAgenttype());
		HttpServletRequest request = ServletActionContext.getRequest();
		agentid = request.getParameter("agentid");
		StringBuilder where = new StringBuilder(" WHERE 1=1  ");
		
		if(s_orderid!=null&&s_orderid>0){
			
			where.append(" and "+Orderinfo.COL_id+" ='"+s_orderid+"'");
		}
		
		if (s_ordertype != null && s_ordertype > 0) {
			where.append(" and " + Orderinfo.COL_ordertype + " = " + s_ordertype);
		}
		
		if(paytype>0){
			
			where.append(" and "+Orderinfo.COL_paymethod+" ="+paytype);
		}
		
		
				if(agentname!=null&&agentname.length()>0){
					
					where.append(" and "+Orderinfo.COL_buyagentid+" in ( SELECT "+Customeragent.COL_id+" from "+Customeragent.TABLE+" where 1=1 and "+Customeragent.COL_agentcompanyname+" like '%"+agentname+"%') ");
				}
	
		
		
		
		if (longinagent.getAgenttype() != 2) {//
			if (isNotNullOrEpt(agentid)) {//显示当前代理和下级订单
				long agid = Long.valueOf(agentid);
				if (agid < 0) {
					where
							.append(" AND C_BUYAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
									+ (0 - agid));
					if (longinagent.getAgenttype() != 1) {
						where.append("  AND  charindex(','+CONVERT(nvarchar,"
								+ longinagent.getId()
								+ ")+',',','+C_PARENTSTR+',')> 0 ");
					}
					where.append(")");
				} else {
					where.append(" AND  C_BUYAGENTID=" + agentid);
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
			/*if(longinagent.getAgenttype()==3){//只显示当前代理订单
				where.append(" AND  C_BUYAGENTID=" + longinagent.getId());
				
			}*/
			
		} else {
			where.append(" AND( " + Orderinfo.COL_policyagentid + "="
					+ longinagent.getId() + " OR  C_BUYAGENTID="
					+ longinagent.getId() + " )");

		}
		if (isNotNullOrEpt(this.s_ordernumber)) {
			where.append(" AND C_ORDERNUMBER ='" + s_ordernumber + "'");
		}
		if (isNotNullOrEpt(s_createtime)) {
			where.append(" AND " + Orderinfo.COL_createtime + " = '"
					+ s_createtime + "'");
		}
		if (s_orderstatus > 0) {// 订单状态
			String orderstatus = String.valueOf(s_orderstatus);
			if (s_orderstatus == 29) {
				orderstatus += ",28";
			}
			where.append("  and ( " + Orderinfo.COL_orderstatus + " IN ("
					+ orderstatus + ")");
			if (s_orderstatus == 2) {// 等待出票 包含1，等待支付，票到付款
				where.append(" OR (" + Orderinfo.COL_orderstatus + "=1 AND "
						+ Orderinfo.COL_paymethod + "=3 ))");
			} else {
				where.append(")");
			}

		}
		if (s_orderstatus ==2) {
		//	where.append(" AND ( C_USERID IS NULL OR C_USERID IN(0,1,-1))");
		}
		
		
		
		if (isNotNullOrEpt(this.lockorder) && lockorder.equals("true")) {
			where.append(" AND " + Orderinfo.COL_userid + " >0 ");
		}
		if (isNotNullOrEpt(this.s_receipt) && s_receipt.equals("true")) {
			where.append(" and " + Orderinfo.COL_orderstatus + "=3  AND "
					+ Orderinfo.COL_receipt + "=4");
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where.append(" AND( C_PNR ='" + s_pnr + "' or C_BIGPNR='" + s_pnr
					+ "')");
		}
		// if (s_isinter != -1) {
		// if (s_isinter == 1) {
		// where += " AND " + Orderinfo.COL_internal + "=" + s_isinter;
		// } else if (s_isinter == 0) {
		// where += " AND (" + Orderinfo.COL_internal + " is null or "
		// + Orderinfo.COL_internal + "=0)";
		// }
		// }
		String flighttime = this.getCheckTime(s_beginchengji, s_endchengji,
				"C_DEPARTTIME");
		if (isNotNullOrEpt(flighttime)) {// 乘机日期
			where.append(" AND ID "
					+ " IN (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] WHERE "
					+ flighttime + ")");
		}
		String insuretime = this.getCheckTime(s_beginprinttime, s_endprinttime,
				Orderinfo.COL_printtime);
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {// 出票时间
			where.append(" AND (" + insuretime + ") ");
		}
		if (isNotNullOrEpt(s_passengername)) {// 乘机人
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
							+ s_passengername + "%')");
		}
		if (isNotNullOrEpt(s_passengerfet)) {// 票号
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_TICKETNUM] like '%"
							+ s_passengerfet + "%')");
		}
		if (isNotNullOrEpt(s_flightnumber)) {// 航班号
			where
					.append(" AND "
							+ Orderinfo.COL_id
							+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
							+ s_flightnumber + "%')");
		}
		if (orderpaymethod > -1) {
			where.append(" AND " + Orderinfo.COL_paymethod + "="
					+ orderpaymethod);
		}
		// 联系人姓名
		// if (isNotNullOrEpt(s_contactname)) {
		// where += " AND " + Orderinfo.COL_contactname + " LIKE '%"
		// + s_contactname + "%' ";
		// 预订人姓名
		if (isNotNullOrEpt(s_bookername)) {
			where
					.append(" and "
							+ Orderinfo.COL_saleagentid
							+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
							+ s_bookername.trim()
							+ "%' and C_TYPE = 1 and C_AGENTID=46) ");
		}
		// 出票人姓名
		if (isNotNullOrEpt(s_chupiaoname)) {
			where.append(" and ID "
					+ " in (SELECT DISTINCT(C_ORDERINFOID) FROM "
					+ "T_ORDERINFORC WHERE C_CUSTOMERUSERID IN (SELECT ID "
					+ "FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
					+ s_chupiaoname + "%')) ");
		}

		if (this.isNotNullOrEpt(s_tfshenqingren)) {// 退废申请人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfshenqingren + "%' ) AND C_STATE IN (4,5) )");
		}
		String sqtime = this.getCheckTime(s_tfshenqingsdate, s_tfshenqingedate,
				"C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(4,5) AND ("
							+ sqtime + "))");
		}
		if (this.isNotNullOrEpt(s_tfshenheren)) {// 退废审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_tfshenheren
							+ "%' ) AND C_STATE IN (7,17,11,12) )");
		}
		String shtime = this.getCheckTime(s_tfshenhesdate, s_tfshenheedate,
				"C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(7,17,11,12) AND ("
							+ shtime + "))");
		}
		if (this.isNotNullOrEpt(s_gaiqianshenqingren)) {// 改签申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_gaiqianshenqingren
							+ "%' ) AND C_STATE IN (13) )");
		}
		String gqsqtime = this.getCheckTime(s_gaiqianshenqingsdate,
				s_gaiqianshenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(13) AND ("
							+ gqsqtime + "))");
		}

		if (this.isNotNullOrEpt(s_gaiqianshenheren)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_gaiqianshenheren
							+ "%' ) AND C_STATE IN (14,15) )");
		}
		String gqshtime = this.getCheckTime(s_gaiqianshenhesdate,
				s_gaiqianshenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(14,15) AND ("
							+ gqshtime + "))");
		}

		if (this.isNotNullOrEpt(s_shengcangshenqingren)) {// 升舱申请人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shengcangshenqingren
							+ "%' ) AND C_STATE IN (23) )");
		}
		String scsqtime = this.getCheckTime(s_shengcangshenqingsdate,
				s_shengcangshenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(23) AND ("
							+ scsqtime + "))");
		}
		if (this.isNotNullOrEpt(s_shengcangshenheren)) {// 审核人
			where
					.append(" AND ID IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_shengcangshenheren
							+ "%' ) AND C_STATE IN (25,26) )");
		}
		String scshtime = this.getCheckTime(s_shengcangshenhesdate,
				s_shengcangshenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(25,26) AND ("
							+ scshtime + "))");
		}

		if (this.isNotNullOrEpt(s_huankaishenqingren)) {// 换开申请人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_huankaishenqingren
							+ "%' ) AND C_STATE IN (30) )");
		}
		String hksqtime = this.getCheckTime(s_huankaishenqingsdate,
				s_huankaishenqingedate, "C_CREATETIME");// 申请时间
		if (sqtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(30) AND ("
							+ hksqtime + "))");
		}
		if (this.isNotNullOrEpt(s_huankaishenheren)) {// 审核人
			where
					.append(" AND ID  IN(SELECT C_ORDERINFOID FROM T_ORDERINFORC WHERE C_CUSTOMERUSERID IN "
							+ "(SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
							+ s_huankaishenheren
							+ "%' ) AND C_STATE IN (24,31) )");
		}
		String hkshtime = this.getCheckTime(s_huankaishenhesdate,
				s_huankaishenheedate, "C_CREATETIME");// 审核时间
		if (shtime.length() > 0) {
			where
					.append(" AND ID "
							+ " IN (SELECT C_ORDERINFOID FROM T_ORDERINFORC  WHERE C_STATE IN(245,31) AND ("
							+ hkshtime + "))");
		}
		String extstatus = request.getParameter("extstatus");
		if (extstatus != null) {
			int exts = Integer.valueOf(extstatus.toString());
			if (exts == 3) {
				String overoutwhere = " AND C_ORDERSTATUS <3 AND "
						+ "  ( C_POLICYAGENTID=3 AND C_EXTORDERSTATUS=3)";
				where.append(overoutwhere);
			} else if (exts == 4) {
				where.append(" AND C_ORDERSTATUS IN (4,5)");
			} else if (exts == 5) {

				where.append(" AND C_EXTORDERSTATUS IN (8,11) ");
			}
		}
		
		
		String yudtime = this.getCheckTime(s_feipiaoshenqingsdate, s_feipiaoshenqingedate,
		"C_CREATETIME");
		
		System.out.println("yudtime:"+yudtime);
		if (isNotNullOrEpt(yudtime)) {// 预定日期
			where.append(" AND  "+ yudtime);
		}
		
		
		if(s_guoneiguoji==1){
			where.append(" AND "+Orderinfo.COL_internal+" ="+s_guoneiguoji);
		}
		if(s_guoneiguoji==2){
			where.append(" AND "+Orderinfo.COL_internal+" !=1");
		}
		
		
		
		
		System.out.println("where:"+where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where.toString(),
						" ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		//加载加盟商开始
		String agentroot = new CustomeragentAction().getAgentRoot();
		request.setAttribute("agentroot", agentroot);
        //结束
		System.out.println("agentroot:"+agentroot);
		System.out.println("B2borderinfoAction.execute()---b2borderinfo.jsp");
		
		//companyname="七星票务";
		//agentid="46";
		return SUCCESS;
	}
	//选择供应商
	public String changagent(){
	orderinfo =Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());	
	listSegment=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0)	;
	listPassenger=Server.getInstance().getAirService().findAllPassenger(" where 1=1 and "+Passenger.COL_orderid+" ="+orderinfo.getId(), " order by id ", -1, 0)	;
	
	
	//匹配政策
	List<Zrate> list51=new ArrayList<Zrate>();//51
	List<Zrate> listpm=new ArrayList<Zrate>();//票盟
	List<Zrate> listjr=new ArrayList<Zrate>();//今日
	List<Zrate> list8000yi=new ArrayList<Zrate>();//8000yi
	List<Zrate> list517na=new ArrayList<Zrate>();//517na
	
	List<Zrate> listbaituo=new ArrayList<Zrate>();//百拓
	
	if(orderinfo.getPnrtxt()!=null&&orderinfo.getPnrtxt().indexOf("BJS182")!=-1){
		orderinfo.setPnrtxt(orderinfo.getPnrtxt().replace(" b ", "").split("[.]BJS182")[0]+".BJS182");
	}
	if(orderinfo.getPnrtxt()!=null&&orderinfo.getPnrtxt().indexOf("PEK868")!=-1){
		orderinfo.setPnrtxt(orderinfo.getPnrtxt().replace(" b ", "").split("[.]PEK868")[0]+".PEK868");
	}
	
	
	orderinfo.getPnrtxt();
	
	
	try {
//8000yi
		
		orderinfo.setPolicyagentid(3l);
		list8000yi=Server.getInstance().getRateService().FindListZrateByPNR(orderinfo, listSegment.get(0), listPassenger);
		
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	try {
		//51
		orderinfo.setPolicyagentid(5l);
		list51=Server.getInstance().getRateService().FindListZrateByPNR(orderinfo, listSegment.get(0), listPassenger);
		
		//票盟
		orderinfo.setPolicyagentid(2l);
		listpm=Server.getInstance().getRateService().FindListZrateByPNR(orderinfo, listSegment.get(0), listPassenger);
		
		//今日
		//orderinfo.setPolicyid(-1l);
		orderinfo.setPolicyagentid(6l);
		listjr=Server.getInstance().getRateService().FindListZrateByPNR(orderinfo, listSegment.get(0), listPassenger);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	try {
				
		//517
		//orderinfo.setPolicyagentid(7l);
		//list517na=Server.getInstance().getRateService().FindListZrateByPNR(orderinfo, listSegment.get(0), listPassenger);
		//System.out.println("list517na:"+list517na.get(0).getRatevalue());
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
	try {
				//百拓
				//orderinfo.setPolicyagentid(4l);
				//listbaituo=Server.getInstance().getRateService().FindListZrateByPNR(orderinfo, listSegment.get(0), listPassenger);
				//System.out.println("listbaituo:"+listbaituo.get(0).getRatevalue());
						
					}catch (Exception e) {
						// TODO: handle exception
					}
							
			
	if(list51!=null&&list51.size()>0){
	for(int a=0;a<list51.size();a++){
		if(list51.get(a).getRatevalue()!=null&&list51.get(a).getRatevalue()>0){
		if(list51.get(a).getGeneral()==2){
			
			ListZrate2.add(list51.get(a));
		}else{
			ListZrate1.add(list51.get(a));
		}
		}
	}
	}
	if(listpm!=null&&listpm.size()>0){
	for(int a=0;a<listpm.size();a++){
		if(listpm.get(a).getRatevalue()!=null&&listpm.get(a).getRatevalue()>0){
		if(listpm.get(a).getGeneral()==2){
			ListZrate2.add(listpm.get(a));
		}else{
			ListZrate1.add(listpm.get(a));
		}
		}
	}
	}
	
	if(list8000yi!=null&&list8000yi.size()>0){
	for(int a=0;a<list8000yi.size();a++){
		if(list8000yi.get(a).getRatevalue()!=null&&list8000yi.get(a).getRatevalue()>0){
		if(list8000yi.get(a).getGeneral()==2){
			ListZrate2.add(list8000yi.get(a));
		}else{
			ListZrate1.add(list8000yi.get(a));
		}
		}
	}
	}
	if(listjr!=null&&listjr.size()>0){
	for(int a=0;a<listjr.size();a++){
		if(listjr.get(a).getRatevalue()!=null&&listjr.get(a).getRatevalue()>0){
		if(listjr.get(a).getGeneral()==2){
			ListZrate2.add(listjr.get(a));
		}else{
			ListZrate1.add(listjr.get(a));
		}
		}
	}
	}
	if(list517na!=null&&list517na.size()>0){
		
		for(int a=0;a<list517na.size();a++){
			if(list517na.get(a).getRatevalue()!=null&&list517na.get(a).getRatevalue()>0){
			if(list517na.get(a).getGeneral()==2){
				ListZrate2.add(list517na.get(a));
			}else{
				ListZrate1.add(list517na.get(a));
			}
			}
		}
		}
	if(listbaituo!=null&&listbaituo.size()>0){
		for(int a=0;a<listbaituo.size();a++){
			if(listbaituo.get(a).getRatevalue()!=null&&listbaituo.get(a).getRatevalue()>0){
			if(listbaituo.get(a).getGeneral()==2){
				ListZrate2.add(listbaituo.get(a));
			}else{
				ListZrate1.add(listbaituo.get(a));
			}
			}
		}
		}
	//ListZrate1
	 java.util.Collections.sort(ListZrate1);
	 java.util.Collections.sort(ListZrate2);
	
	
	
		return "changagent";
	}
	public void ajaxTuiFei() throws IOException{
		//申请退费.默认取消PNR
		Server.getInstance().getTicketSearchService().commandFunction2("AVH/PEKSHA", "", "");
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(strTuiOrderID));
		//Server.getInstance().getTicketSearchService().commandFunction2("rt"+orderinfo.getPnr()+"$xepnr@", "", "");
		
		
		orderinfo.setMemo(tui_tuifeidesc);//原因   文字描述
		orderinfo.setAddresa(tui_state+"");//类型   
		orderinfo.setContactfax(TuiFeiType);//退还是废 4 或者5
		orderinfo.setPostname(passid);
		
		String sub= Server.getInstance().getRateService().TuiFeiOrder(orderinfo, null, null);
		
		System.out.println("sub:"+sub);
		
		if(!sub.equals("-1")&&sub.indexOf("@")!=-1){
			
			String newordernum=sub.split("@")[1];
			orderinfo.setNewextorderid(newordernum);
			
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		}
		
		
		PrintWriter out = response.getWriter();
		out.print(sub);
		out.flush();
		out.close();
		
	}
	//运营商提交给供应商
	public void ajaxTuiFeiToGys() throws IOException{
		WriteLog.write("运营商提交申请退废记录", "订单ID:"+strTuiOrderID);
		//申请退费.默认取消PNR
		Server.getInstance().getTicketSearchService().commandFunction2("AVH/PEKSHA", "", "");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(strTuiOrderID));
		//Server.getInstance().getTicketSearchService().commandFunction2("rt"+orderinfo.getPnr()+"$xepnr@", "", "");
		
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent("提交退/废-"+getLoginUser().getLoginname()+"-执行了提交申请退废到供应商");
		orderinforc.setSuouserid(1l);
		orderinforc.setCustomeruserid(1l);
		try {
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String state="4";//4 申请退票   5申请废票  6申请改签
		if(orderinfo.getOrderstatus()==4){//5申请废票  4申请退票 
			state="4";
		}
		if(orderinfo.getOrderstatus()==5){//5申请废票  4申请退票 
			state="5";
		}
		
		String where=" where 1=1 and "+Passenger.COL_orderid+" ="+orderinfo.getId()+" AND "+Passenger.COL_state+" ="+state;
		List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(where, " ORDER BY ID ", -1, 0);
		
		String sub="-1";
		if(listpass.size()>0){
			String pid="";
			for(int p=0;p<listpass.size();p++){
				pid+=listpass.get(p).getId()+",";
			}
			orderinfo.setMemo(listpass.get(0).getTuifeidesc());//原因
			orderinfo.setAddresa(listpass.get(0).getTuifeiyuanyi()+"");//类型
			orderinfo.setContactfax(state);//退还是废
			orderinfo.setPostname(pid);
			
			 sub= Server.getInstance().getRateService().TuiFeiOrder(orderinfo, listpass, null);
			 WriteLog.write("运营商提交申请退废记录", "订单ID:"+strTuiOrderID+",返回:"+sub);
			System.out.println("sub:"+sub);
			
			if(!sub.equals("-1")&&sub.indexOf("@")!=-1){
				
				String newordernum=sub.split("@")[1];
				//orderinfo.setNewextorderid(newordernum);
				//Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
				String sql=" UPDATE "+Passenger.TABLE+" set "+Passenger.COL_ei+" ='"+newordernum+"' where "+Passenger.COL_orderid+" ="+orderinfo.getId()+" AND "+Passenger.COL_state+" ="+state;
				Server.getInstance().getAirService().excutePassengerBySql(sql);
				sub=newordernum;
				
			}
		}else{
			
			sub="-2";
		}
		
		
		
		PrintWriter out = response.getWriter();
		out.print(sub);
		out.flush();
		out.close();
		
	}
	/**
	 * @return
	 * @throws Exception
	 *             订单解锁
	 */
	public String unlockorder() throws Exception {
		this.unlockOrder(orderinfo.getId());
		return this.execute();
	}
	
	
	
	
	/**
	 * @return
	 * @throws Exception
	 *             跳转到添加儿童票界面
	 */
	public String toaddRTticket() throws Exception {
		
		
		
		
		return "toaddRTticket";
	}
	/**
	 * @return
	 * @throws Exception
	 *             跳转到添加婴儿票界面
	 */
	public String toaddYEticket() throws Exception {
		
		
		
		
		return "toaddYEticket";
	}
	/**
	 * @return
	 * @throws Exception
	 *             跳转到添加儿童票界面
	 */
	public void CreateRtOrder() throws Exception {
		String sub="-1";//-1 网络异常 -2 创建PNR失败 -3 创建订单失败
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("s_orderid:"+s_orderid+",h_name:"+h_name+",h_birthday:"+h_birthday);
		Orderinfo order=Server.getInstance().getAirService().findOrderinfo(s_orderid);
		List<Segmentinfo> listsegmenginfo=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+s_orderid, " ORDER BY ID ", -1, 0);
		List<Passenger>listpassengermodel=new ArrayList<Passenger>();
		Passenger passenger=new Passenger();
		if(h_name.indexOf("CHD")==-1){
			passenger.setName(h_name+"CHD");
		}else{
			passenger.setName(h_name);
		}
		
		passenger.setIdnumber(h_birthday);
		if(passenger.getIdnumber().length()>=16){
			String birthday = passenger.getIdnumber().substring(6,14);
			passenger.setBirthday(birthday.substring(0, 4)+"-"+birthday.substring(4, 6)+"-"+birthday.substring(6, 8));
			}
		
		
		passenger.setIdtype(1);
		passenger.setPtype(2);
		passenger.setPrice(100f);
		passenger.setAirportfee(50f);
		passenger.setFuelprice(60f);
		passenger.setLanguage(0);
		passenger.setState(0);
		if(h_insurance!=null&&!h_insurance.equals("0")){
			//计算保险
			float bxcb=20f;
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
				bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
			}
			passenger.setInsurprice(Integer.parseInt(h_insurance)*bxcb);
		}
		
		listpassengermodel.add(passenger);
		
		String chengrenpnr=order.getPnr();
		order.setRatevalue(0f);
		order.setFenxiaoshangfandian(0f);
		order.setId(0l);
		order.setPaystatus(0);
		order.setOrderstatus(1);
		order.setRelationorderid(s_orderid);
		order.setExtorderid(null);
		order.setExtorderstatus(0);
		order.setPnr("123456");
		order.setBigpnr("123456");
		order.setBackpointinfo("");
		Orderinfo rtorder=Server.getInstance().getAirService().createOrderinfo(order);
		rtorder=Server.getInstance().getAirService().findOrderinfo(rtorder.getId());
		Segmentinfo segmentinfo=listsegmenginfo.get(0);
		segmentinfo.setId(0l);
		segmentinfo.setRatevalue(0f);
		//if(segmentinfo.getCabincode().equals("F")||segmentinfo.getCabincode().equals("A")||segmentinfo.getCabincode().equals("P")){
		if(segmentinfo.getDiscount()>100){
			segmentinfo.setCabincode(segmentinfo.getCabincode());
		}else{
			if(segmentinfo.getAircomapnycode().equals("CZ")&&segmentinfo.getCabincode().equals("W")){
				segmentinfo.setCabincode("W");
			}else{
				segmentinfo.setCabincode("Y");
			}
			segmentinfo.setDiscount(100f);
		}
		
		
		segmentinfo.setOrderid(rtorder.getId());
		segmentinfo=Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		
		List<Passenger>listpass=new ArrayList<Passenger>();
		for(int p=0;p<listpassengermodel.size();p++){
			Passenger pa=listpassengermodel.get(p);
			pa.setOrderid(rtorder.getId());
			pa.setPtype(2);
			pa=Server.getInstance().getAirService().createPassenger(pa);
			listpass.add(pa);
		}
		
		List<Segmentinfo>listseg=new ArrayList<Segmentinfo>();
		listseg.add(segmentinfo);
		
		s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listseg, listpass, chengrenpnr);
		///s_returnpnr="HE2CF3";
		System.out.println("儿童PNR:"+s_returnpnr);
		
		String pat_Price="0";
		String pat_Fuleprice="0";
		String pat_airportfee="0";
		
		if(s_returnpnr.equals("-1")||s_returnpnr.equals("NO PNR")||s_returnpnr.equals("NOPNR")){
			
			Server.getInstance().getAirService().excutePassengerBySql(" DELETE "+Passenger.TABLE+" where "+Passenger.COL_orderid+" ="+rtorder.getId());
			Server.getInstance().getAirService().excuteSegmentinfoBySql(" DELETE "+Segmentinfo.TABLE+" where "+Segmentinfo.COL_orderid+" ="+rtorder.getId());
			Server.getInstance().getAirService().deleteOrderinfo(rtorder.getId());
			
			
			sub="-2";
			
			out.print(sub);
			out.flush();
			out.close();
			return ;
			
		}else{
			rtorder.setPnr(s_returnpnr);
			
			String	pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr, "");
			System.out.println("pnrtxt1:"+pnrtxt);
			//原始的用
			int ind=0;
			if(pnrtxt.indexOf("+")>0){
				ind=pnrtxt.indexOf("+");
				pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PN", "");
			}
			/*if(pnrtxt.indexOf("+")>ind){
				ind=pnrtxt.indexOf("+");
				pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PN$PN", "");
			}
			if(pnrtxt.indexOf("+")>ind){
				ind=pnrtxt.indexOf("+");
				pnrtxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PN$PN$PN", "");
			}*/
			System.out.println("pnrtxt2:"+pnrtxt);
			String	pattxt=Server.getInstance().getTicketSearchService().commandFunction("RT"+s_returnpnr+"$PAT:A*CH", "");
				System.out.println("pattxt:"+pattxt);
			String bigpnr = Server.getInstance().getTicketSearchService().getBigPNRInfo(s_returnpnr);
		
			//黑屏创建
			System.out.println("listpass:"+listpass.size());
			//List<String> listonrinfo=GetRtPatPNR2(s_returnpnr, listpass);//0pnrinfo 1patinfo 2bigpnr
				if(pattxt.toString().indexOf("没有符合条件的运价")!=-1){
					System.out.println("没有符合条件的运价,订单创建失败");
					Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
					Server.getInstance().getAirService().excutePassengerBySql(" DELETE "+Passenger.TABLE+" where "+Passenger.COL_orderid+" ="+rtorder.getId());
					Server.getInstance().getAirService().excuteSegmentinfoBySql(" DELETE "+Segmentinfo.TABLE+" where "+Segmentinfo.COL_orderid+" ="+rtorder.getId());
					Server.getInstance().getAirService().deleteOrderinfo(rtorder.getId());
					sub="-2";
					out.print(sub);
					out.flush();
					out.close();
					return ;
				}else{
					
					
					
					rtorder.setPattxt(pattxt.split(">")[1]);
					rtorder.setPnrtxt(pnrtxt);
					rtorder.setBigpnr(bigpnr);
					
					//
					  String[] strpatItem=rtorder.getPattxt().split(" ");
					  System.out.println("核对黑屏价格-数组:"+strpatItem.length);
					  for(int i=0;i<strpatItem.length;i++) 
					  {
						  if(!strpatItem[i].trim().equals(""))
						  {
							  //票价
							  if(strpatItem[i].trim().indexOf("FARE:")>=0)
							  {
								  pat_Price=strpatItem[i].trim().replace("FARE:CNY", "");
							  }
							  //燃油费
							  if(strpatItem[i].trim().indexOf("YQ:CNY")>=0)
							  {
								  pat_Fuleprice=strpatItem[i].trim().replace("YQ:CNY", "");
							  }
							  //机建费
							  if(strpatItem[i].trim().indexOf("TAX:CNY")>=0)
							  {
								  pat_airportfee=strpatItem[i].trim().replace("TAX:CNY", "");
							  }
							  
							  if(!pat_Price.equals("0")){
								  
								  break;
							  }
							  
						  }
					  }
				}
			
		}
		System.out.println(pat_Price+"-"+pat_airportfee+"-"+pat_Fuleprice);
		segmentinfo.setPrice(Float.parseFloat(pat_Price));
		segmentinfo.setParvalue(Float.parseFloat(pat_Price));
		Server.getInstance().getAirService().updateSegmentinfoIgnoreNull(segmentinfo);
		
		Float allprice=0f;
		Float alljj=0f;
		Float allry=0f;
		for(int a=0;a<listpass.size();a++){
			
			Passenger p=listpass.get(a);
			p.setPrice(Float.parseFloat(pat_Price));
			p.setAirportfee(10f);//儿童票10块钱手续费
			p.setFuelprice(Float.parseFloat(pat_Fuleprice));
			p.setPtype(2);
			Server.getInstance().getAirService().updatePassengerIgnoreNull(p);
			allprice+=p.getPrice();
			alljj+=p.getAirportfee();
			allry+=p.getFuelprice();
		}
		rtorder.setTotalticketprice(allprice);
		rtorder.setTotalairportfee(alljj);
		rtorder.setTotalfuelfee(allry);
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(rtorder);
		
		sub=rtorder.getId()+"";
		out.print(sub);
		out.flush();
		out.close();
	}
	public void CreateYEOrder() throws Exception {
		String sub="-1";//-1 网络异常 -2 创建PNR失败 -3 创建订单失败
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("s_orderid:"+s_orderid+",h_name:"+h_name+",h_birthday:"+h_birthday);
		Orderinfo order=Server.getInstance().getAirService().findOrderinfo(s_orderid);
		List<Segmentinfo> listsegmenginfo=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+s_orderid, " ORDER BY ID ", -1, 0);
		List<Passenger>listpassengermodel=new ArrayList<Passenger>();
		Passenger passenger=new Passenger();
		passenger.setName(h_name);
		passenger.setIdnumber(h_birthday);
		if(passenger.getIdnumber().length()>=16){
			String birthday = passenger.getIdnumber().substring(6,14);
			passenger.setBirthday(birthday.substring(0, 4)+"-"+birthday.substring(4, 6)+"-"+birthday.substring(6, 8));
			}
		
		passenger.setIdtype(1);
		passenger.setPtype(3);
		passenger.setPrice(100f);
		passenger.setAirportfee(50f);
		passenger.setFuelprice(60f);
		passenger.setLanguage(0);
		passenger.setState(0);
		if(h_insurance!=null&&!h_insurance.equals("0")){
			//计算保险
			float bxcb=20f;
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
				bxcb=Float.parseFloat(session.getAttribute("INSURPRICE").toString().trim());
			}
			passenger.setInsurprice(Integer.parseInt(h_insurance)*bxcb);
		}
		
		listpassengermodel.add(passenger);
		
		
		order.setRatevalue(0f);
		order.setFenxiaoshangfandian(0f);
		order.setId(0l);
		order.setPaystatus(0);
		order.setOrderstatus(1);
		order.setRelationorderid(s_orderid);
		order.setExtorderid(null);
	
		order.setExtorderstatus(0);
		
		order.setBackpointinfo("");
		order.setPnr("123456");
		order.setBigpnr("123456");
		order.setPnrtxt("");
		order.setPattxt("");
		
		Orderinfo rtorder=Server.getInstance().getAirService().createOrderinfo(order);
		rtorder=Server.getInstance().getAirService().findOrderinfo(rtorder.getId());
		Segmentinfo segmentinfo=listsegmenginfo.get(0);
		
		String pat_Price="0";
		String pat_Fuleprice="0";
		String pat_airportfee="0";
		
		
		segmentinfo.setId(0l);
		segmentinfo.setRatevalue(0f);
		if(segmentinfo.getCabincode().equals("F")||segmentinfo.getCabincode().equals("A")||segmentinfo.getCabincode().equals("P")){
			segmentinfo.setCabincode(segmentinfo.getCabincode());
			pat_Price=getRoundPrice(segmentinfo.getParvalue(), 10)+"";
		}else{
			if(segmentinfo.getAircomapnycode().equals("CZ")){
				
				segmentinfo.setCabincode("W");
			}else{
				segmentinfo.setCabincode("Y");
			}
			segmentinfo.setDiscount(100f);
			pat_Price=getRoundPrice(segmentinfo.getYprice(), 10)+"";
		}
		
		
		segmentinfo.setOrderid(rtorder.getId());
		segmentinfo=Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		
		List<Passenger>listpass=new ArrayList<Passenger>();
		for(int p=0;p<listpassengermodel.size();p++){
			Passenger pa=listpassengermodel.get(p);
			pa.setOrderid(rtorder.getId());
			pa.setPtype(3);
			pa=Server.getInstance().getAirService().createPassenger(pa);
			listpass.add(pa);
		}
		
		List<Segmentinfo>listseg=new ArrayList<Segmentinfo>();
		listseg.add(segmentinfo);
		
		
		
		
		
		System.out.println(pat_Price+"-"+pat_airportfee+"-"+pat_Fuleprice);
		
		
		
		segmentinfo.setPrice(Float.parseFloat(pat_Price));
		segmentinfo.setParvalue(Float.parseFloat(pat_Price));
		Server.getInstance().getAirService().updateSegmentinfoIgnoreNull(segmentinfo);
		
		Float allprice=0f;
		Float alljj=0f;
		Float allry=0f;
		for(int a=0;a<listpass.size();a++){
			
			Passenger p=listpass.get(a);
			p.setPrice(Float.parseFloat(pat_Price));
			p.setAirportfee(0f);
			p.setFuelprice(20f);
			p.setPtype(3);
			Server.getInstance().getAirService().updatePassengerIgnoreNull(p);
			allprice+=p.getPrice();
			alljj+=p.getAirportfee();
			allry+=p.getFuelprice();
		}
		rtorder.setTotalticketprice(allprice);
		rtorder.setTotalairportfee(alljj);
		rtorder.setTotalfuelfee(allry);
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(rtorder);
		
		sub=rtorder.getId()+"";
		out.print(sub);
		out.flush();
		out.close();
	}

	// 收银操作
	public void doShoukuan() throws Exception {
		String strReturn = "";
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		// System.out.println(orderinfo.getCustomeruserid());
		// System.out.println(customeruser == null);
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(orderinfo.getBuyagentid());
		try {
			String scripturl = "<style type=\"text/css\">.dhide{display:none;}</style><script type=\"text/javascript\" src=\"${pageContext.request.contextPath}/js/adapter/ext/ext-base.js\"></script>";
			strReturn += "<div id='shouyininfo'>";

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		strReturn += "<table id='tbpeisonginfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='6' align='left'><b>航程信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td colspan='2'>出发城市-到达城市</td>" + "<td>航班号</td>"
				+ "<td>舱位码</td>" + "<td colspan='2'>起飞时间</td><td></td>";
		strReturn += "</tr>";

		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td colspan='2'>"
					+ listseginfo.get(i).getStartairport() + "-"
					+ listseginfo.get(i).getEndairport() + "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td colspan='2'>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table>";
		strReturn += "<br />";
		strReturn += "<table id='tbpassenger' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr><td colspan='12' align='left'><b>乘机人信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td><td>小计</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " AND C_STATE<>12";

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		float insurprce = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			Passenger passenger = listpassenger.get(i);
			insurprce += passenger.getInsurprice();
			strReturn += "<tr>";
			// strReturn+="<td align='center'><input type='hidden'
			// id='txtpassid_"+i+"' value='"+listpassenger.get(i).getId()+"'
			// /><input type='checkbox' checked='checked'
			// id='chkpassenger_"+i+"'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(passenger.getTickettypeid(), 0l))
								.getTypename() + "</td>";
			}
			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(passenger.getPrice()) + "</td>";
			strReturn += "<td>" + formatMoney(passenger.getFuelprice())
					+ "</td>";
			strReturn += "<td>" + formatMoney(passenger.getAirportfee())
					+ "</td>";
			strReturn += "<td>" + formatMoney(passenger.getAnjianfee())
					+ "</td><td>" + formatMoney(passenger.getOtherfee())
					+ "</td>";

			strReturn += "<td>"
					+ formatMoney(converNull(passenger.getPrice(), 0f)
							+ converNull(passenger.getFuelprice(), 0f)
							+ converNull(passenger.getAirportfee(), 0f)
							+ converNull(passenger.getAnjianfee(), 0f)
							+ converNull(passenger.getOtherfee(), 0f))
					+ "</td>";

			strReturn += "</tr>";

		}
		strReturn += "</tbody>";

		strReturn += "</table>";

		strReturn += "<br />";
		strReturn += "<table id='tbpayinfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='10' align='left'><b>支付信息</b></td></tr>";
		strReturn += "<tr>";
		strReturn += "<td align='right' width='100px' class='table_color_r colortrin'><input type=\"hidden\" id=\"9\" value=\""
				+ orderinfo.getPaymethod() + "\"/>应付金额：</td>";
		strReturn += "<td align='left' width='110px' style='color:red;font-weight:bold'>"
				+ formatMoney(converNull(orderinfo.getTotalticketprice(), 0f)
						+ converNull(orderinfo.getTotalairportfee(), 0f)
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f)
						+ converNull(orderinfo.getTotalfuelfee(), 0f))
				+ "</td>";
		strReturn += "<td align='right' class='table_color_r colortrin'>保险：</td><td>"
				+ insurprce + "</td>";
		strReturn += "<td align='right'  class='table_color_r colortrin'>付款方式：</td>";
		strReturn += "<td align='left' style='color:red;font-weight:bold'>";
		String strPayMethod = getPayMethodStr(orderinfo.getPaymethod());
		String strHtmlSelect = "";
		// 个人挂账员工集合
		if (orderinfo.getPaymethod() == 5) {
			strReturn += "<input type='hidden' id='sid' size='5' name='fkmethod' value='8'/>月结挂账";
		} else {
			List<Customeruser> listemployee = Server
					.getInstance()
					.getMemberService()
					.findAllCustomeruser(
							" WHERE C_AGENTID = 46 AND C_TYPE = 1 AND ID <> 62",
							"", -1, 0);
			strHtmlSelect += "<select name='guazhangrenid' id='ddlemployeeid'>";
			strHtmlSelect += "<option value='0'>--请选择个人挂账员工--</option>";
			for (int i = 0; i < listemployee.size(); i++) {

				strHtmlSelect += "<option value='"
						+ listemployee.get(i).getId() + "'>"
						+ listemployee.get(i).getMembername() + "</option>";
			}
			strHtmlSelect += "</select>";
			String opetion = "<option value='1' id='xj'>现金</option><option value='2' id='zp'>支票</option><option value='3' id='jh'>建行POS</option><option value='4' id='ylpos'>银联POS</option>"
					+ "<option value='5' id='myp '>免优票</option><option  value='6' id='lcj'>里程券</option>";
			opetion += "<option id='wszf'  value='9'>网上支付</option>";
			strReturn += "<select name=\"fkmethod\" id='sid' onchange=\"change()\">";
			int paymethod = orderinfo.getPaymethod();
			if (paymethod == 2 || paymethod == 3 || paymethod == 6) {//
				strReturn += opetion;
			} else {
				strReturn += opetion
						+ "<option id='yjgz'  value='8'>月结挂账</option>"

						+ "<option id='yhhk' value='10' >银行汇款</option>";

			}
			strReturn += "<option id='nbjs' value='11' >内部结算</option></select>";

		}
		strReturn += "</td>";
		List<Passenger> listpassenger2 = Server
				.getInstance()
				.getAirService()
				.findAllPassenger("WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
		// 判断含有几个乘机人，如果含有多个乘机人，添加分离打印功能
		String strFenliBtn = "";
		String strPassIDs = "";
		if (listpassenger2.size() > 1) {
			for (int i = 0; i < listpassenger2.size(); i++) {
				strPassIDs += listpassenger2.get(i).getId() + "|";
			}
			strFenliBtn = "&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:fenlidayin('"
					+ strTuiOrderID
					+ "','"
					+ strPassIDs
					+ "');' value='分离打印' type='button'>";
		}
		if (orderinfo.getPaymethod() != 5) {
			strReturn += " <td class='table_color_r colortrin divgrgz' align='right' id='divgrgz'>个人挂帐:</td><td class=\"divgrgz\" align='left'>"
					+ strHtmlSelect + "</td></div>";
		}
		strReturn += "</tr>";
		strReturn += "<tr><td colspan='10' align='center'><input class='button_d font-bai' value='收银' onclick=' if(isSelectPeople()){doshoukuan("
				+ strTuiOrderID
				+ ")};' type='button'>&nbsp;&nbsp;"
				+ "<input class='button_d font-bai' onclick='javascript:printChange("
				+ orderinfo.getId()
				+ ");prn1_print();' value='打印送票单' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='closedialog(0);' value='取消' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:prn1_preview();' value='预览送票单' type='button'>"
				+ strFenliBtn + "</td></tr>";
		strReturn += "</table></div>";
		String strAddress = "";
		if (orderinfo.getAddresa() != null
				&& !orderinfo.getAddresa().equals("")) {
			strAddress = orderinfo.getAddresa();
		} else {
			strAddress = "无";
		}
		String strMemo = "";
		if (orderinfo.getMemo() != null && !orderinfo.getMemo().equals("")) {
			strMemo = orderinfo.getMemo();
		} else {
			strMemo = "无";
		}

		String strPayName = getPayMethodStr(orderinfo.getPaymethod());

		strReturn += "<div id='tbpreivew'  style='display:none'>"
				+ this.getSendTicketPaper(orderinfo) + "</div>";
		strReturn += "<table id='tbbutton1' style='display:none' width='100%' valign='top' border='0'>";
		strReturn += "<tr><td colspan='8'><input class='button_d font-bai' value='打印' onclick='javascript:prn1_print();' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='cancelprint();' value='取消' type='button'></td></tr>";
		strReturn += "</table>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 获得送票单
	 * 
	 * @param orderinfo
	 * @return
	 */
	private String getSendTicketPaper(Orderinfo orderinfo) {
		StringBuffer strReturn = new StringBuffer("");

		String strCompan = "无";
		String billsql = "SELECT C_ORDERID,C_CREATETIME,C_PRINTTIME,C_CUSTOMERAGENTID,C_POSTNAME,C_POSTMOBILE,C_ORDERNUMBER,C_PNR,C_BIGPNR,C_TICKETNUM,C_ADDRESA,C_MEMO,"
				+ "(SELECT C_TYPENAME FROM T_TICKETTYPE T WHERE T.ID=v.C_TICKETTYPEID) AS TICKETTYPE  , "
				+ "(SELECT  C_MEMBERNAME FROM T_CUSTOMERUSER C WHERE C.ID=v.C_SALEAGENTID) AS SALENAME,"
				+ "(SELECT C_MEMBERNAME FROM T_CUSTOMERUSER WHERE ID=(SELECT TOP 1 C_CUSTOMERUSERID FROM T_ORDERINFORC WHERE C_STATE IN (3,29) AND C_ORDERINFOID=v.C_ORDERID)) AS CPNAME,"
				+ "(SELECT C_MOBILE FROM T_CUSTOMERUSER WHERE ID=v.C_CUSTOMERUSERID) MOBILE, C_PAYMETHOD,C_FKMETHOD,C_FENXIAOSHANGFANDIAN,C_ZHEKOUJINE,"
				+ "C_PRICE,C_YUANPRICE,ISNULL(C_AIRPORTFEE,0)+ISNULL(C_FUELPRICE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0) AS DUTY,C_INSURANCE,ISNULL(C_INSURANCEFEE,0) INSURFEE,"
				+ "C_TUIFEE,C_RTTIME,C_PRINTTIME,C_SALEAGENTID,C_NAME,C_CONTACTNAME,"
				+ "dbo.F_GetAgentName(C_CUSTOMERUSERID,C_CUSTOMERAGENTID) AS AGENTNAME "
				+ " FROM view_pas_order_seng v  WHERE 1=1 AND C_ORDERID="
				+ strTuiOrderID;
		if (isNotNullOrEpt(s_songpaiodanpid)) {
			billsql += " AND ID =" + s_songpaiodanpid;
		}
		List billlist = Server.getInstance().getSystemService()
				.findMapResultBySql(billsql, null);
		Map ordermap = new HashMap();
		if (billlist.size() > 0) {
			ordermap = (HashMap) billlist.get(0);
		}
		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		strCompan = converNull(ordermap.get("AGENTNAME"), "").toString();
		String strTicketType = converNull(ordermap.get("TICKETTYPE"), "")
				.toString();
		strReturn
				.append("<table border='0' id=\"tbprint\" width='100%' style='font-size:16px;margin:0 auto;border-collapse:collapse;border-spacing:0;line-height:30px;display:none'>");
		strReturn.append("<tr>");
		strReturn.append("<td colspan='8' style=' text-align:center;'>");
		strReturn
				.append("<font style='float:left; font-size:24px;font-weight:bold; margin-left:260px;' size='5em'>${dns.companyname}商旅中心送票单</font><font class='r' style='width:120px;size:12px; float:right;'>"
						+ strTicketType + "</font></td>");

		long agentid = Long.valueOf(converNull(
				ordermap.get("C_CUSTOMERAGENTID"), "0").toString());
		String strcontactname = converNull(ordermap.get("C_CONTACTNAME"), "无")
				.toString();
		String strcontacttel = converNull(ordermap.get("MOBILE"), "无")
				.toString();
		String strPnr = converNull(ordermap.get("C_PNR"), "").toString();
		String strBigPnr = converNull(ordermap.get("C_BIGPNR"), "").toString();
		strPnr = strBigPnr.length() > 0 ? strBigPnr : strPnr;
		// 如果联系人是散客，取散客的真实姓名
		if (agentid == 46l) {
			String postname = converNull(ordermap.get("C_POSTNAME"), "")
					.toString();
			if (postname != null && !postname.equals("")) {
				strcontactname = postname;
			}
			strcontacttel = converNull(ordermap.get("C_POSTMOBILE"), "无")
					.toString();
		}
		int intpay = Integer.valueOf(converNull(ordermap.get("C_PAYMETHOD"),
				"0").toString());
		String strPayName = getPayMethodStr(orderinfo.getPaymethod());

		String strAddress = converNull(ordermap.get("C_ADDRESA"), "无")
				.toString();
		String strMemo = converNull(ordermap.get("C_MEMO"), "无").toString();
		strReturn
				.append("<tr style='line-height:15px'><td align='right'>客户名称:</td><td align='left'>"
						+ strCompan + "</font></td>");
		strReturn.append("<td align='right'>预定人:</td>");
		strReturn
				.append("<td align='left' style='height:15px;line-height:15px;'>"
						+ ordermap.get("SALENAME")
						+ "</td><td align='right'>提交时间:</font></td>");
		strReturn
				.append("<td align='left' style='height:15px;line-height:15px;'>"
						+ super.formatStringTime(converNull(
								ordermap.get("C_CREATETIME"), "").toString())
						+ "</td>");
		strReturn
				.append("<td align='right' style='height:15px;line-height:15px;'>PNR:</font></td><td align='left' style='height:15px;line-height:15px;'>"
						+ strPnr + "</td></tr>");
		strReturn
				.append("<tr style=''><td  style='height:15px;line-height:15px;' align='right'>订单号:</td>");
		strReturn
				.append("<td align='left'style='height:15px;line-height:15px;'>"
						+ ordermap.get("C_ORDERNUMBER") + "</td>");
		strReturn
				.append("<td align='right' style='height:10px;line-height:10px;'>出票人:</td><td align='left' style='height:10px;line-height:10px;'>"
						+ ordermap.get("CPNAME")
						+ "</td><td align='right' style='height:10px;line-height:10px;'>出票时间:</td><td align='left' style='height:10px;line-height:10px;'>"
						+ super.formatStringTime(ordermap.get("C_PRINTTIME")
								.toString()) + "</td>");
		strReturn
				.append("<td align='right' style='height:10px;line-height:10px;'><font >支付方式:</font></td><td align='left' style='height:10px;line-height:10px;'><font >"
						+ strPayName + "</font></td></tr>");
		strReturn
				.append("<tr style='line-height:14px'><td align='right' style='height:10px;line-height:10px;'>备注:</td><td align='left' colspan='5'>"
						+ SubString(strMemo, 20) + "</font></td>");
		// strReturn
		// .append("<td align='right'></td><td align='left'></td><td
		// align='right'>Memo:</td><td align='left'>"
		// + SubString(strMemo, 20) + "</td>");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		strReturn
				.append("<td align='right' style='height:10px;line-height:10px;'>打印时间:</td><td align='left' width='10%'>"
						+ dateFormat.format(new Timestamp(System
								.currentTimeMillis()).getTime()) + "</td></tr>");
		strReturn
				.append("<tr><td colspan='8'><hr size='1px' style='height:1px; width:100%'></td></tr>");

		strReturn.append("<tr><td colspan='8'>");
		// 横线以下的数据
		strReturn
				.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		strReturn.append("<tr>");
		strReturn
				.append("<td width='40%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		strReturn.append("<tr>");
		strReturn
				.append("<td width='5%' valign='top' >"
						+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		strReturn.append("<tr>");
		strReturn
				.append("<td style='height:10px;line-height:10px;' align='right'>航&nbsp;&nbsp;&nbsp;程:</td>");
		strReturn.append("</tr>");
		strReturn.append("</table>");
		strReturn.append("</td>");
		strReturn
				.append("<td width='24%' valign='top'>"
						+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		strReturn.append("<tr>");
		strReturn.append("<td>&nbsp;</td>");
		strReturn.append("</tr>");
		for (int i = 0; i < listseginfo.size(); i++) {
			Segmentinfo segment = listseginfo.get(i);
			strReturn.append("<tr>");
			strReturn.append("<td>"
					+ converNull(segment.getStartairport(), "")
					+ converNull(segment.getEndairport(), "")
					+ "&nbsp;"
					+ segment.getFlightnumber()
					+ "&nbsp;"
					+ segment.getCabincode()
					+ "&nbsp;"
					+ ChangeDateMode(converNull(segment.getDeparttime(), "")
							.toString()) + "&nbsp;"
					+ formatTimestampHHmm(segment.getDeparttime()) + "&nbsp;"
					+ "</td>");
			strReturn.append("</tr>");
		}
		strReturn.append("</table></td>");
		strReturn
				.append("<td width='76%' rowspan=\"2\" valign='top'>"
						+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		strReturn.append(" <tr>");
		strReturn
				.append("<td valign='top' align='left' width='50%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		// 循环乘机人10个

		float strAmt = 0;
		int j = 0;
		for (int i = 0; i < Math.ceil(billlist.size() / 10.0); i++) {
			strReturn.append("<td><table>");
			for (; j < (i + 1) * 10; j++) {
				Map pmap = new HashMap();
				try {
					pmap = (HashMap) billlist.get(j);
				} catch (Exception e) {
					pmap = new HashMap();
				}

				strAmt += Float.valueOf(converNull(pmap.get("C_PRICE"), "0")
						.toString())
						+ Float.valueOf(converNull(pmap.get("DUTY"), "0")
								.toString());
				strReturn.append("<tr>");
				strReturn.append("<td style='height:15px;line-height:15px;'>"
						+ converNull(pmap.get("C_TICKETNUM"), "")
						+ " "
						+ SubString(converNull(pmap.get("C_NAME"), "")
								.toString(), 6) + "</td>");
				strReturn.append("</tr>");

			}

			strReturn.append("</table></td>");
		}
		strReturn.append("</tr>");
		strReturn.append("</table></td>");
		strReturn.append("</tr>");
		strReturn.append(" </table></td></tr>"); // -----
		strReturn
				.append("<tr><td colspan=\"2\" valign=\"top\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");
		strReturn.append("<tr>");
		strReturn.append("<td width='80'>联&nbsp;&nbsp;系&nbsp;&nbsp;人:</td><td>"
				+ strcontactname + "</td><td></td>");
		strReturn.append("</tr>");
		strReturn.append("<tr>");
		strReturn.append("<td>联系电话:</td><td>" + strcontacttel
				+ "</td><td></td>");
		strReturn.append("</tr>");
		strReturn.append("<tr>");
		strReturn.append("<td>联系地址:</td><td>" + strAddress + "</td><td></td>");
		strReturn.append("</tr>");
		strReturn.append("</table>");

		strReturn.append("</td></tr></table></td></tr></table></td></tr>");

		strReturn.append("<tr><td height='2px'></td></tr>");
		float strfanjine = Float.valueOf(converNull(
				ordermap.get("C_ZHEKOUJINE"), "0").toString())
				* billlist.size();
		String papercount = "等共：" + billlist.size();
		if (isNotNullOrEpt(s_songpaiodanpid)) {
			String count = ServletActionContext.getRequest().getParameter(
					"pagecount");
			papercount = "等第：" + s_Paindex + "张&nbsp;&nbsp;共：" + count;
		}
		strReturn.append("<tr><td align='center' colspan='8'>Amt:"
				+ strAmt
				+ "/返点"
				+ formatMoney_string(converNull(
						ordermap.get("C_FENXIAOSHANGFANDIAN"), "0").toString())
				+ "/返金额" + strfanjine + "/保险"
				+ getIssurByOrderid(orderinfo.getId())
				+ "元  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + papercount
				+ "张 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收票人：</td></tr>");

		strReturn.append("</table>");
		return strReturn.toString();
	}

	public String webrepayorder() {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(this.orderinfo.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("orderid", this.orderinfo.getId());
		request.setAttribute("billname", "airorderbill");

		Map ordermap = new HashMap();
		ordermap.put("billname", "airorderbill");
		ordermap.put("orderid", orderinfo.getId());
		ordermap.put("actionname", "b2bticketorder!vmoneyAirticketpay.action");
		ordermap.put("ordernumber", orderinfo.getOrdernumber());
		float allprice = converNull(orderinfo.getTotalticketprice(), 0f)
				+ converNull(orderinfo.getTotalairportfee(), 0f)
				+ converNull(orderinfo.getTotalfuelfee(), 0f)
				+ converNull(orderinfo.getPostmoney(), 0);
		ordermap.put("orderprice", allprice);
		ordermap.put("ordername", "机票预订");
		request.setAttribute("ordermap", ordermap);

		return "towebrepy";
	}

	/**
	 * 国际机票订单确认
	 * 
	 * @throws Exception
	 */
	public void interOrderConfirmHtml() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				Long.parseLong(strTuiOrderID));
		sb
				.append("<table><tr><td>请填写PNR,票面价,税费信息&nbsp;&nbsp;</td></tr></table>");
		sb
				.append("<table width='100%' border='1' cellspacing='0' bordercolorlight='#a0cfee' bordercolordark='white' cellpadding='0' style='border: 1px solid #a0cfee;'>");
		sb
				.append("<tr  style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #fff'>");
		sb
				.append("<td align='right' width='10%'>PNR编码：</td><td align='left' width='15%'><input type='text' id='txt_pnr_inter' name='s_pnr_inter' value='' /></td>");
		sb
				.append("<td align='right' width='10%'>税费：</td><td align='left' width='15%'><input type='text' id='txt_tax_inter' name='s_tax_inter' value='' /></td>");
		sb.append("</tr>");
		sb
				.append("<tr style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #fff'>");
		sb
				.append("<td align='right' width='10%'>票面价(成人)</td><td align='left' width='15%'><input type='text' id='txt_adultprice_inter' name='s_adultprice_inter' value='' /></td>");
		sb
				.append("<td align='right' width='10%'>票面价(儿童)</td><td align='left' width='15%'><input type='text' id='txt_childprice_inter' name='s_childprice_inter' value='' /></td>");
		sb.append("</tr>");

		sb.append("</table>");
		sb.append("<br />");
		sb
				.append("<input id='btnconfirminter' type='button' onclick='return saveinterorder("
						+ strTuiOrderID
						+ ");' class=\"button_d font-bai\" value='更新订单'/>&nbsp;&nbsp;<input class='button_d font-bai' value='取消' onclick='closedialog("
						+ strTuiOrderID + ");' type='button' />");
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 更新国际机票订单信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public void saveInterOrder() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();

		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				Long.parseLong(strTuiOrderID));
		orderinfo.setPnr(s_pnr_inter);
		Float ftotalPrice = 0f;
		Float ftotlatax = 0f;
		List<Passenger> listpass = Server.getInstance().getAirService()
				.findAllPassenger(
						"where " + Passenger.COL_orderid + "=" + strTuiOrderID,
						"", -1, 0);
		for (Passenger passenger : listpass) {
			// 成人
			if (passenger.getPtype() == 1) {
				passenger.setPrice(Float.parseFloat(s_adultprice_inter));
				passenger.setFuelprice(Float.parseFloat(s_tax_inter));
				ftotalPrice += Float.parseFloat(s_adultprice_inter);
				ftotlatax += Float.parseFloat(s_tax_inter);
			} else if (passenger.getPtype() == 2) {
				passenger.setPrice(Float.parseFloat(s_childprice_inter));
				passenger.setFuelprice(Float.parseFloat(s_tax_inter));
				ftotalPrice += Float.parseFloat(s_childprice_inter);
				ftotlatax += Float.parseFloat(s_tax_inter);
			}
			Server.getInstance().getAirService().updatePassenger(passenger);
		}
		List<Segmentinfo> listsegment = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where " + Segmentinfo.COL_orderid + "="
								+ strTuiOrderID, "", -1, 0);
		for (Segmentinfo segmentinfo : listsegment) {
			segmentinfo.setPrice(Float.parseFloat(s_childprice_inter));
			segmentinfo.setFuelfee(Float.parseFloat(s_tax_inter));
			Server.getInstance().getAirService().updateSegmentinfo(segmentinfo);
		}
		orderinfo.setTotalfuelfee(ftotlatax);
		orderinfo.setOrderstatus(1); // 将确认之后的订单状态改为待支付状态
		orderinfo.setTotalticketprice(ftotalPrice);
		Server.getInstance().getAirService().updateOrderinfo(orderinfo);
		// 发送确认短信
		String[] mobiles = { orderinfo.getContactmobile() };
		sendInterConfirmSms(mobiles, orderinfo.getId());
		sb.append("1");
		out.print(sb);
		out.flush();
		out.close();

	}

	/**
	 * @throws Exception
	 *             3:正在出票
	 */
	public void rrticket() throws Exception {
		System.out.println("id:"+orderinfo.getId());
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String sql = "SELECT ID,AIRNAME,C_FLIGHTNUMBER,C_AGENTCOMPANYNAME,AIRFLIGHT,C_DEPARTTIME,C_CABINCODE,C_PNR,C_BIGPNR,ISNULL(C_TOTALTICKETPRICE,0) TICKETPRICE,ISNULL(DUTY,0) DUTY,ISNULL(INSURANCEPRICE,0) INSURPRICE FROM view_orderinfo WHERE ID="
				+ orderinfo.getId();
		//sql=" SELECT * FROM view_orderinfo WHERE ID="+orderinfo.getId();
		System.out.println("SQL:"+sql);
		
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		
		System.out.println("list:"+list.toString());
		Map map = (Map) list.get(0);
		this.lockOrder(orderinfo.getId(), 3);
		sb
		.append("<form name='chupiaoform' id='chupiaoform' action='b2bticketorder!saveticketnumber.action' method='post'>");
		sb.append("<table><tr><td>基本信息&nbsp;&nbsp;</td></tr></table>");
		sb
				.append("<table class='book_pgcontent' width='100%' border='1' cellspacing='0' bordercolorlight='#a0cfee' bordercolordark='white' cellpadding='0' style='border: 1px solid #a0cfee'>");
		sb
				.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
		sb
				.append("<th style='text-align:center'>采购商</th>"
						+ "<th style='text-align:center'>航空公司</th>"
						+ "<th style='text-align:center'>航班号</th>"
						+ "<th style='text-align:center'>航程</th>"
						+ "<th style='text-align:center'>起飞日期</th>"
						+ "<th style='text-align:center'>舱位</th>"
						+ "<th style='text-align:center'>PNR</th><th style='text-align:center'>费用总计</th>");
		sb.append("</tr>");
		float allprice = Float.valueOf(map.get("TICKETPRICE").toString())
				+ Float.valueOf(map.get("DUTY").toString())
				+ Float.valueOf(map.get("INSURPRICE").toString());
		// 修改人：星星
		// 修改时间：2011-11-16
		// 修改原因：订单只有大PNR，没有小PNR时，点击立即出票报错，+map.get("C_PNR").toString() +
		// "'/></td><td>" + allprice
		String PnrCode = "";
		if (map.get("C_PNR") != null && !map.get("C_PNR").toString().equals("")) {
			PnrCode = map.get("C_PNR").toString();
		} else if (map.get("C_BIGPNR") != null
				&& !map.get("C_BIGPNR").toString().equals("")) {
			PnrCode = map.get("C_BIGPNR").toString();
		}
		sb
				.append("<tr><td>"
						+ map.get("C_AGENTCOMPANYNAME").toString()
						+ "</td><td>"
						+ map.get("AIRNAME").toString()
						+ "</td><td>"
						+ map.get("C_FLIGHTNUMBER").toString()
						+ "</td><td>"
						+ map.get("AIRFLIGHT").toString()
						+ "</td><td>"
						+ super.formatStringTime(map.get("C_DEPARTTIME")
								.toString())
						+ "</td><td>"
						+ map.get("C_CABINCODE").toString()
						+ "</td><td><input onblur='checkPnr(this.value)' size='8' name='s_pnr' id='orderlpnr' value='"
						+ PnrCode + "'/></td><td>" + allprice + "</td>");
		sb.append("</tr>");
		sb.append("</table>");
		
		sb.append("<input type=\"hidden\" name=\"corderid\" value='"
				+ orderinfo.getId() + "'/>");
		sb.append("<span style='color:red' align='left'>请填写正确格式的票号！</span>");
		String psql = "SELECT ID, C_TICKETNUM, C_PTYPE,C_NAME,C_IDTYPE,C_IDNUMBER,C_PRICE,C_AIRPORTFEE,C_FUELPRICE,"
				+ "C_INSURPRICE "
				+ ",C_ANJIANFEE,C_OTHERFEE FROM T_PASSENGER P WHERE C_ORDERID="
				+ orderinfo.getId() + " AND C_STATE<>12";
		List passengerlist = Server.getInstance().getSystemService()
				.findMapResultBySql(psql, null);
		sb
				.append("<table class='book_pgcontent' width='100%' border='1' cellspacing='0' bordercolorlight='#a0cfee' bordercolordark='white' cellpadding='0' style='border: 1px solid #a0cfee'>");
		sb.append("<tbody>");
		sb
				.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
		sb
				.append("<td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号</td>"
						+ "<td>票号<input type='button' class='button_xg'  value='提取票号'onclick=\"dispose('系统正在为您提取票号');ajaxPickupTicketnumber("
						+ passengerlist.size()
						+ ",'"
						+ PnrCode
						+ "'"
						+ ")\"; /> "
						+ "</td><td>短信</td><td>票价</td><td>机建</td><td>燃油</td><td>保险</td>");

		if (orderinfo.getInternal() != null) {
			if (orderinfo.getInternal() == 1) {
				sb.append("<td>安检</td><td>其它税</td>");
			}
		}
		sb.append("<td>小计</td>");
		sb.append("</tr>");

		for (int i = 0; i < passengerlist.size(); i++) {
			Map pmap = (Map) passengerlist.get(i);
			sb.append("<tr id='tr" + i + "'>");

			String ptype="";
			if(pmap.get("C_PTYPE")!=null){
				ptype=pmap.get("C_PTYPE").toString();
			}
			sb.append("<td>"
					+ getPassTypeToString(Integer.valueOf(ptype)) + "</td>");
			sb.append("<td>" + pmap.get("C_NAME").toString() + "</td>");
			String pid = pmap.get("ID").toString();
			String credityp="";
			//如果是儿童  这地方出错
			if(pmap.get("C_IDTYPE")!=null){
			 credityp = getIDTypeToString(Integer.valueOf(pmap.get(
					"C_IDTYPE").toString()));
			}
			sb.append("<td>" + credityp + "</td>");
			String IDNUMBER="";
			if(pmap.get("C_IDNUMBER")!=null){
				IDNUMBER=pmap.get("C_IDNUMBER").toString();
			}
			sb.append("<td>" + IDNUMBER + "</td>");
			if(pmap.get("C_TICKETNUM")==null||pmap.get("C_TICKETNUM").toString().trim().length()==0){
				sb.append("<td><input size='20' style='margin:3px;' id='titnum" + i
						+ "' name=\"" + pid + "ticketnumber\" value='000-0000000000'/></td>");
			}else{
				sb.append("<td><input size='20' style='margin:3px;' id='titnum" + i
						+ "' name=\"" + pid + "ticketnumber\" value='"
						+ converNull(pmap.get("C_TICKETNUM"), "") + "'/></td>");
			}
			
			

			String hbmsg = "";
			String chmsg = "";
			
			float price = Float.valueOf(pmap.get("C_PRICE").toString());
			float airprice = Float.valueOf(pmap.get("C_AIRPORTFEE").toString());
			float fuelprice = Float.valueOf(pmap.get("C_FUELPRICE").toString());
			float insurpirce = Float.valueOf(converNull(
					pmap.get("C_INSURPRICE"), 0).toString());
			float anjian = Float.valueOf(converNull(pmap.get("C_ANJIANFEE"), 0)
					.toString());
			float otherfee = Float
					.valueOf(converNull(pmap.get("C_OTHERFEE"), 0).toString());
			float passegerprice = price + airprice + fuelprice + insurpirce
					+ anjian + otherfee;
			sb.append("<td>"
					// +"<input type='hidden' " + hbmsg
					// + " name='s_pmsgtype" + passenger.getId()
					// + "' value='1' />航班短信<br/>"
					+ "<input type='checkbox'  " + chmsg + " name='s_pmsgtype"
					+ pid + "' value='2' />出票短信</td>");
			sb
					.append("<td><input size='7' id='price"
							+ i
							+ "' onblur='accountprice()'  name='"
							+ pid
							+ "price' value='"
							+ price
							+ "'/></td><td><input  size='4' onblur='accountprice()' id='air"
							+ i
							+ "' name='"
							+ pid
							+ "airport' value='"
							+ airprice
							+ "'/></td><td><input  size='4' onblur='accountprice()' id='fuel"
							+ i + "' name='" + pid

							+ "fuel' value='" + fuelprice + "'/></td>");
			sb.append("<td>" + insurpirce + "</td>");
			if (orderinfo.getInternal() != null) {
				if (orderinfo.getInternal() == 1) {
					sb
							.append("<td><input size='5' name='"
									+ pid
									+ "anjian' onblur='accountprice()' id='anjian"
									+ i
									+ "' value='"
									+ anjian
									+ "'/></td>"
									+ "<td><input size='5' onblur='accountprice()' id='other"
									+ i + "' name='" + pid + "other' value='"
									+ otherfee + "'/></td>");
				}

			}
			sb.append("<td id='pprice" + i + "'>" + passegerprice + "</td>");
			sb.append("</tr>");

		}
		String hblinkmsg = "";
		String cplinkmsg = "";
		// 此为东航联系人短信选项。
		// if (orderinfo.getContactmsgtype() != null
		// && orderinfo.getCustomeruserid() != 90148l) {
		// if (orderinfo.getContactmsgtype() == 3) {
		// hblinkmsg = "checked=\"checked\"";
		// cplinkmsg = "checked=\"checked\"";
		// } else if (orderinfo.getContactmsgtype() == 2) {
		// cplinkmsg = "checked=\"checked\"";
		// } else if (orderinfo.getContactmsgtype() == 1) {
		// hblinkmsg = "checked=\"checked\"";
		// }
		// }
		sb.append("<tr>");
		sb.append("<td align=\"right\" class='GridViewHeaderStyle' style='color:#0356A6'>订单备注:</td>"
						+ "<td colspan=\"12\" align='left'><textarea rows=\"2\" cols=\"50\" name=\"ordermemo\">"
						+ converNull(map.get("C_MEMO"), "").toString()
						+ "</textarea></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td align=\"right\" class='GridViewHeaderStyle' style='color:#0356A6'>返采备注:</td>"
				+ "<td colspan=\"12\" align='left'><textarea rows=\"2\" cols=\"50\" name=\"fancaiinfo\">"
				+ "</textarea></td>");
		sb.append("</tr>");
		sb
				.append("<tr><td align=\"right\" class='GridViewHeaderStyle' style='color:#0356A6'>联系人短信:</td>"
						+ "<td colspan=\"12\" align='left'>"
						// + "<input type='checkbox' "
						// + hblinkmsg
						// + " name='s_msgtype' value='1'
						// />航班动态短信&nbsp;&nbsp;"
						+ "<input type='checkbox' checked='checked' "
						+ cplinkmsg
						+ " name='s_msgtype' value='2' />出票提醒短信</td></tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("<br/>");

		sb
				.append("<input id='chupiaoid' type='button' onclick='valch()' class=\"button_d font-bai\" value='保存并出票'/>&nbsp;&nbsp;<input class='button_d font-bai' value='取消' onclick='closedialog("
						+ orderinfo.getId() + ");' type='button' />");
		sb.append("</form>");
		sb
				.append("<script>" + "function valchupiao(){" + " "
						+ "for(i=0;i<"
						+ passengerlist.size()
						+ ";i++){"
						+ "if($('#titnum'+i).val()==\"\"){"
						+ "alert('第'+(i+1)+'行中票号不能为空！');"
						+ "$('#titnum'+i).focus(); "
						+ "return false;"
						+ ""
						+ "}"
						+ ""
						+ "if($('#titnum'+i).val().length<14){"
						+ "alert('第'+(i+1)+'行中票号格式不正确！');"
						+ "$('#titnum'+i).focus(); "
						+ " return false;"
						+ "}"
						+ "var price=$('#price'+i); var fuel=$('#fuel'+i); var air=$('#air'+i);var anjian=$('#anjian'+i);var other=$('#other'+i);"
						+

						"if(price!=null&&(price.val()==0||price.val()=='')){"
						+ "  if(confirm('是否确定第'+(i+1)+'行中票价为空！')){}else{return false}"
						+ " }"
						+ "if(air!=null&&(air.val()==0||air.val()=='')){"
						+ "  if(confirm('是否确定第'+(i+1)+'行中燃油费为空！')){}else{return false}"
						+ " }"
						+ "if(fuel!=null&&(fuel.val()==0||fuel.val()=='')){"
						+ "  if(confirm('是否确定第'+(i+1)+'行中机建费为空！')){}else{return false}"
						+ " }"
						+ "if(anjian!=null&&(anjian.val()==0||anjian.val()=='')){"
						+ "  if(confirm('是否确定第'+(i+1)+'行中安检费为空！')){}else{return false}"
						+ " }"
						+ "if(other!=null&&(other.val()==0||other.val()=='')){"
						+ "  if(confirm('是否确定第'+(i+1)+'行中其它费为空！')){}else{return false}"
						+ " }"
						+ "}"
						+ "return true;"
						+ "}"
						+ "function valch(){"
						+ "if(valchupiao()){"
						+ "document.getElementById(\"chupiaoid\").disabled = true;;document.chupiaoform.submit();"
						+ "}" + "}</script>");

		out.print(sb);
		out.flush();
		out.close();

	}

	/**
	 * @throws Exception
	 *             保存并出票
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String saveticketnumber() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String q = request.getParameter("corderid");
		this.unlockOrder(Long.valueOf(q));// 解锁。
		strTuiOrderID = converNull(q, "0");
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.valueOf(strTuiOrderID));
		Timestamp date = new Timestamp(System.currentTimeMillis());
		orderinfo.setPrinttime(date);
		orderinfo.setBusystatus(1l);
		orderinfo.setPnr(s_pnr);
		
		String strOptdesc = "";
		if (orderinfo.getPaystatus() == 0) {
			orderinfo.setOrderstatus(29);
			orderinfo.setExtorderstatus(29);
		} else {
			orderinfo.setOrderstatus(3);
			orderinfo.setExtorderstatus(3);
		}

		this.orderinfo = orderinfo;
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " and "
								+ Passenger.COL_state + "<>12", "ORDER BY ID",
						-1, 0);
		List<Segmentinfo> listsegmentinfo = Server.getInstance()
				.getAirService().findAllSegmentinfo(
						"WHERE C_ORDERID=" + orderinfo.getId(), "", -1, 0);
		float allprice = 0f;// 总票价
		float allairport = 0f;// 总机建
		float allfuel = 0f;// 总燃油
		float allanjian = 0f;// 总安检
		float allother = 0f;// 总其它

		if (listpassenger.size() > 0) {
			for (int i = 0; i < listpassenger.size(); i++) {
				Passenger passenger = listpassenger.get(i);
				passenger.setState(1);
				long paid = passenger.getId();
				String str = String.valueOf(paid);
				String titnum = request.getParameter(str + "ticketnumber");
				String ei = request.getParameter(str + "ei");
				passenger.setTicketnum(titnum);
				passenger.setTickettypeid(s_tickettypeid);
				passenger.setEi(ei);
				float price = Float.valueOf(converTrim(request.getParameter(str
						+ "price"), "0"));
				float airport = Float.valueOf(converTrim(request
						.getParameter(str + "airport"), "0"));
				float fuel = Float.valueOf(converTrim(request.getParameter(str
						+ "fuel"), "0"));
				/*float anjian = 0f;
				if (request.getParameter(str + "anjian") != null) {
					anjian = Float.valueOf(converTrim(request.getParameter(str
							+ "anjian"), "0"));
				}*/
				float other = 0f;
				if (request.getParameter(str + "other") != null) {
					other = Float.valueOf(converTrim(request.getParameter(str
							+ "other"), "0"));
				}
				allprice += price;
				allairport += airport;
				allfuel += fuel;
			//	allanjian += anjian;
				allother += other;
				passenger.setPrice(price);
				passenger.setAirportfee(airport);
				passenger.setFuelprice(fuel);
				//passenger.setAnjianfee(anjian);
				passenger.setOtherfee(other);
				passenger.setRttime(orderinfo.getPrinttime());
				Server.getInstance().getAirService().updatePassengerIgnoreNull(
						passenger);
				String[] msgtypes = request.getParameterValues("s_pmsgtype"
						+ passenger.getId());
				/*if (msgtypes != null && msgtypes.length > 0) {
					if (msgtypes.length == 1) {
						if (msgtypes[0].equals("2")) {
							sendTXTSmstoPassenger(passenger, listsegmentinfo);
						} else {
							for (Segmentinfo segmenginfo : listsegmentinfo) {
								sendFYsms(passenger.getMobile(), passenger
										.getName(), segmenginfo, orderinfo
										.getId());
							}
						}
					} else {
						sendTXTSmstoPassenger(passenger, listsegmentinfo);
						for (Segmentinfo segmenginfo : listsegmentinfo) {
							sendFYsms(passenger.getMobile(), passenger
									.getName(), segmenginfo, orderinfo.getId());
						}
					}
				}*/
				
				
				
				
				
			}
		List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
			//if(listseg!=null&&listseg.size()>0&&!listseg.get(0).getAircomapnycode().equals("9C")){
				//sendTXTSmstoPassenger(listpassenger, listsegmentinfo);
				sendTXTSmstoPassenger2(listpassenger, listsegmentinfo);
			//}
			
		}
		strOptdesc = "立即出票-" + this.getLoginUser().getMembername()
				+ "执行了立即出票操作，订单状态为："
				+ this.getStateToString(orderinfo.getOrderstatus());
		orderinfo.setTotalticketprice(allprice);
		orderinfo.setTotalairportfee(allairport);
		orderinfo.setTotalfuelfee(allfuel);
		//orderinfo.setTotalanjian(allanjian);
		orderinfo.setTotalotherfee(allother);
		String ordermemo = request.getParameter("ordermemo");
		orderinfo.setMemo(ordermemo);
		
		//添加出票速度
		
		
		String newtime=new Timestamp(System.currentTimeMillis()).toString();
		if(orderinfo.getCreatetime()!=null){
			String oldtime=orderinfo.getCreatetime()+"";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = df.parse(newtime);
			Date date2 = df.parse(oldtime);
			
			long fen=(date1.getTime() - date2.getTime())/1000/60;
			
			orderinfo.setPickonephone(fen+"分钟");
		}
		
		
		
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		// 创建操作记录
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCustomeruserid(this.getLoginUserId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent(strOptdesc);
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(orderinfo.getOrderstatus());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
		//返采备注
		if(fancaiinfo!=null&&fancaiinfo.trim().length()>0){
			Orderinforc orderinforc2 = new Orderinforc();
			orderinforc2.setCustomeruserid(getLoginUserId());
			orderinforc2.setOrderinfoid(orderinfo.getId());
			orderinforc2.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc2.setSuouserid(orderinfo.getUserid());
			//orderinforc2.setState(-1);
			orderinforc2.setContent("返采备注:" +fancaiinfo );
			orderinforc2.setCustomeruserid(getLoginUserId());
			Server.getInstance().getAirService().createOrderinforc(orderinforc2);
		}
		
		// ------------------------------增加会员积分开始-------------------------------------------
		// 出票后将积分添加到会员积分表中-开始

		// Customeruser member = Server.getInstance().getMemberService()
		// .findCustomeruser(orderinfo.getCustomeruserid());
		// float fmoney = orderinfo.getTotalairportfee()
		// + orderinfo.getTotalticketprice() + orderinfo.getTotalfuelfee();
		// updateIntegral(member, 1, orderinfo.getOrdernumber(), fmoney, null);

		// ------------------------------增加会员积分结束-------------------------------------------
		// 出票后将积分添加到会员积分表中-结束
		// ---------------------------------记录返佣金额开始----------------------------------------
		orderinfo
				.setTotalinsurprice(this.getINSURMONEYPrice(orderinfo.getId()));
		super.sharingRebate(orderinfo, listpassenger.size());

		// ---------------------------------记录返佣金额结束----------------------------------------
		// Customeragent orderagent = Server.getInstance().getMemberService()
		// .findCustomeragent(orderinfo.getBuyagentid());
		// getrebatetouser(orderinfo.getRebatemoney().toString(),orderinfo.getId()+"","1");
		s_orderstatus = 2;
		ty = 1;

		// 发送短信
		/*String[] msgtype = request.getParameterValues("s_msgtype");// 联系人
		Customeruser linkuser = Server
				.getInstance()
				.getMemberService()
				.findCustomeruser(converNull(orderinfo.getCustomeruserid(), 0l));

		if (orderinfo.getContactmobile() != null && msgtype != null
				&& msgtype.length > 0) {
			String[] mobiles = { orderinfo.getContactmobile() };
			if (msgtype.length == 1) {
				if (msgtype[0].equals("2")) {
					// 发送出票短信
					super.sendTXTSmstoLinkuser(mobiles, listpassenger,
							listsegmentinfo);
				} else {
					// 动态短信
					for (Segmentinfo segmenginfo : listsegmentinfo) {
						sendFYsms(linkuser.getMobile(), linkuser
								.getMembername(), segmenginfo, orderinfo
								.getId());
					}

				}
			} else {
				sendTXTSmstoLinkuser(mobiles, listpassenger, listsegmentinfo);
				for (Segmentinfo segmenginfo : listsegmentinfo) {
					sendFYsms(linkuser.getMobile(), linkuser.getMembername(),
							segmenginfo, orderinfo.getId());
				}
			}
		}*/

		return execute();
	}

	/**
	 * 列表查询订单信息表==分销商
	 */
	public String today() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 and " + Orderinfo.COL_createtime + ">="
				+ "CONVERT(datetime, '" + h_prestarttime + " 00:00:00') and "
				+ Orderinfo.COL_createtime + " <=" + "CONVERT(datetime, '"
				+ h_preendtime + " 23:59:59') and "
				+ Orderinfo.COL_customeruserid + " =" + getLoginUser().getId();
		// System.out.println(s_begincity);
		if (s_orderstatus > 0) {
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
		/*
		 * if (s_bengincreatetime != null && s_bengincreatetime.trim().length() !=
		 * 0) { where += " and " + Orderinfo.COL_createtime + " >= '" +
		 * s_bengincreatetime.trim() + " 00:00:00'"; } if (s_endcreatetime !=
		 * null && s_endcreatetime.trim().length() != 0) { where += " and " +
		 * Orderinfo.COL_createtime + " <= '" + s_endcreatetime.trim() + "
		 * 23:59:59'"; }
		 */
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
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
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

		return "today";
	}

	/**
	 * 列表查询订单信息表===供应商
	 */
	public String tomyorder() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 and " + Orderinfo.COL_paystatus + " =1";// and
		// "+Orderinfo.COL_saleagentid+"
		// ="+getLoginUserId()
		// System.out.println(s_begincity);
		if (s_orderstatus > 0) {
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
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
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

		return "tomyorder";
	}

	/**
	 * 列表查询订单信息表===供应商 toPaid
	 */
	public String toPaid() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 ";// and "+Orderinfo.COL_saleagentid+"
		// ="+getLoginUserId()
		// System.out.println(s_begincity);
		if (s_orderstatus > 0) {
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
		if (ty == 7 || ty == 8) {

			where += " and " + Orderinfo.COL_createtime + ">="
					+ "CONVERT(datetime, '" + h_prestarttime
					+ " 00:00:00') and " + Orderinfo.COL_createtime + " <="
					+ "CONVERT(datetime, '" + h_preendtime + " 23:59:59')";

		} else {

			if (s_bengincreatetime != null
					&& s_bengincreatetime.trim().length() != 0) {
				where += " and " + Orderinfo.COL_createtime + " >= '"
						+ s_bengincreatetime.trim() + " 00:00:00'";
			}
			if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
				where += " and " + Orderinfo.COL_createtime + " <= '"
						+ s_endcreatetime.trim() + " 23:59:59'";
			}
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
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
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

		return "toPaid";
	}

	/**
	 * 跳转到订单报表
	 * 
	 * @return
	 */
	public String toreport() {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		return "report";
	}

	/**
	 * 订单报表查询
	 */
	public String report() throws Exception {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 ";
		System.out.println(s_begincity);
		if (s_orderstatus > 0) {
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
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}
		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
		listOrderinfo = Server.getInstance().getAirService().findAllOrderinfo(
				where, " ORDER BY ID DESC", -1, 0);
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
	 * 转向到订单信息表修改页面
	 */
	public String toeditorderinfo() throws Exception {
		String ticketwhere = " WHERE 1=1 ";
		listtickettype = Server.getInstance().getMemberService()
				.findAllTickettype(ticketwhere, "", -1, 0);

		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(orderinfo.getBuyagentid());

		Customeruser user = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());

		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId() + " and " + Passenger.COL_state + "<>12";
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		listYmsend = Server.getInstance().getMemberService().findAllYmsend(
				" WHERE C_ORDERCODE ='" + orderinfo.getId() + "'", "", -1, 0);
		return "toeditorderinfo";
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
		System.out.println(orderinfo.getRebatemoney());
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		List<Customeragent> list = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			listAgent = list.get(0);
		}

		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		List<Customeragent> list2 = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list2 != null && list2.size() > 0) {
			listGongAgent = list2.get(0);
		}
		return "show";
	}

	public void B2BCreateOrder() throws Exception {

	}

	/**
	 * 根据政策ID查询外部政策值,如果有变化就更新
	 */
	public void SeachZateAndUpdate() throws Exception {
		String zrateid = "";

		if (ajax_vogtype.equals("1")) {// 第一程
			segmentOne = (Segmentinfo) ActionContext.getContext().getSession()
					.get("segmentOne");
			zrateid = segmentOne.getZrateid() + "";
		}
		if (ajax_vogtype.equals("2")) {// 第2程

			segmentTwo = (Segmentinfo) ActionContext.getContext().getSession()
					.get("segmentTwo");
			zrateid = segmentTwo.getZrateid() + "";
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();

		String ZateValue = "";
		Zrate zrate = new Zrate();
		zrate = Server.getInstance().getAirService().findZrate(ajax_zid);

		if (ajax_vogtype.equals("1")) {// 第一程
			segmentOne.setZrateid(zrate.getId());
			segmentOne.setRatevalue(Getliudianvalue(zrate.getRatevalue()));
			// 取得返佣值
			long lagentid = getLoginUser().getAgentid();
			String stragentjibie = getLoginUserAgent().getAgentjibie()
					.toString();
			String strRabateString = "0";
			try {
				strRabateString = getAgentRebatevalue(lagentid, segmentOne
						.getParvalue()
						* Getliudianvalue(zrate.getRatevalue()) / 100, 1,
						getLoginUserAgent().getAgentjibie());
			} catch (Exception ex) {
				strRabateString = "0";
			}
			// 计算当前登录代理商的返佣金额
			Float frabatemoney = 0f;
			String strrabatemoney = "0";

			frabatemoney = Float.parseFloat(strRabateString);
			strrabatemoney = formatMoney_short(frabatemoney.toString());

			// 取的返佣值结束
			segmentOne.setPrice(segmentOne.getParvalue() - frabatemoney);

			ActionContext.getContext().getSession().remove("segmentOne");
			ActionContext.getContext().getSession().put("segmentOne",
					segmentOne);

			System.out.println("政策发生了变化!!segmentOne!!!变化后政策ID=="
					+ segmentOne.getZrateid());
		}
		if (ajax_vogtype.equals("2")) {// 第2程

			segmentTwo.setZrateid(zrate.getId());
			segmentTwo.setRatevalue(Getliudianvalue(zrate.getRatevalue()));
			// 取得返佣值
			long lagentid = getLoginUser().getAgentid();
			String stragentjibie = getLoginUserAgent().getAgentjibie()
					.toString();
			String strRabateString = "0";
			try {
				strRabateString = getAgentRebatevalue(lagentid, segmentTwo
						.getParvalue()
						* Getliudianvalue(zrate.getRatevalue()) / 100, 1,
						getLoginUserAgent().getAgentjibie());
			} catch (Exception ex) {
				strRabateString = "0";
			}
			// 计算当前登录代理商的返佣金额
			Float frabatemoney = 0f;
			String strrabatemoney = "0";

			frabatemoney = Float.parseFloat(strRabateString);
			strrabatemoney = formatMoney_short(frabatemoney.toString());

			// 取的返佣值结束
			segmentTwo.setPrice(segmentTwo.getParvalue() - frabatemoney);
			ActionContext.getContext().getSession().remove("segmentTwo");
			ActionContext.getContext().getSession().put("segmentTwo",
					segmentTwo);
			System.out.println("政策发生了变化!!!segmentTwo!!变化后政策ID=="
					+ segmentTwo.getZrateid());
		}

		if (zrate.getIsenable() == 0) {// 禁用 政策被禁用
			sb.append("-1");
			out.print(sb);
			out.flush();
			out.close();
		}
		Float zatevalue = Getliudianvalue(zrate.getRatevalue());
		System.out.println("留点后zatevalue==" + zatevalue);

		Float youhui = gethuiyouprice(zatevalue / 100, 1f, Float
				.parseFloat(parvalue));// 优惠价格

		Float jiesuanprice = Float.parseFloat(parvalue) - youhui;
		System.out.println("优惠:" + youhui);
		System.out.println("价格:" + jiesuanprice);

		sb.append(formatZrate(zatevalue) + "," + youhui.toString() + "0,"
				+ jiesuanprice + "0");
		System.out.println(sb.toString());
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 再次下单
	 */
	public void nextOrderticket() {
		String message = "";
		IAirService service = Server.getInstance().getAirService();
		HttpServletRequest request = ServletActionContext.getRequest();
		long orderid = Long.valueOf(request.getParameter("orderid"));
		Orderinfo orderinfo = service.findOrderinfo(orderid);
		// 记录是否是重新下单 星星
		// 只要是方便星星重新下单接口，区别是否是通过重新下单，提交外部订单
		orderinfo.setBusystatus(1l); // 如果通过重新下单生成，订单紧急状态为1
		// 记录是否是重新下单 星星
		if (!orderinfo.getPnr().equals("NOPNR")) {
			Segmentinfo segmentinfo = (Segmentinfo) (service
					.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0)
					.get(0));
			List<Passenger> listPassenger = service.findAllPassenger(
					"WHERE C_ORDERID=" + orderid, "", -1, 0);
			Zrate zrate = Server.getInstance().getRateService()
					.FindZrateByFlight(orderinfo, segmentinfo, listPassenger);
			if (zrate != null) {
				orderinfo.setPolicyid(zrate.getId());// 政策ID
				orderinfo.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfo.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfo.setExtpolicyid(zrate.getOutid()); // 外部政策id
				try {
					orderinfo
							.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate
									.getRatevalue())));// 分销商返点
				} catch (Exception e) {

				}
				segmentinfo.setAgentid(zrate.getAgentid());
				segmentinfo.setRatevalue(zrate.getRatevalue());
				segmentinfo.setZrateid(zrate.getId());
				segmentinfo.setZrate(zrate);

				// 创建外部订单，方法调用
				String strExtOrderNumber = Server.getInstance()
						.getRateService().CreateOrder(orderinfo, segmentinfo,
								listPassenger);
				if (isNotNullOrEpt(strExtOrderNumber)
						&& !strExtOrderNumber.equals("-1")) {
					orderinfo.setExtorderid(strExtOrderNumber);
					// 外部订单状态
					orderinfo.setExtorderstatus(0);
					// 外部订单创建时间
					orderinfo.setExtordercreatetime(new Timestamp(System
							.currentTimeMillis()));
					int intadult = 0;
					for (int i = 0; i < listPassenger.size(); i++) {
						if (listPassenger.get(i).getPtype() == 1) {
							intadult++;
						}
					}
					Float fzonglirun = orderinfo.getRatevalue()
							* segmentinfo.getParvalue() / 100 * intadult;
					int intzonglirun = fzonglirun.intValue();
					orderinfo.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));
					Customeragent agent = findBySql(Customeragent.class,
							"SELECT ID id ,C_PARENTSTR parentstr FROM T_CUSTOMERAGENT WHERE ID="
									+ orderinfo.getBuyagentid());
					System.out.println(strExtOrderNumber);
					service.updateOrderinfoIgnoreNull(orderinfo);
					service.updateSegmentinfoIgnoreNull(segmentinfo);

				} else {
					message = "faile";
				}
			} else {
				message = "faile";
			}
		}
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print(message);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加订单信息表,此方法已不再使用，创建订单方法目前为toaddorder.action
	 */
	public void add() throws Exception {
		// 是否黑屏帐号创建PNR，1=使用HGH133黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 2;
		// 是否生成PNR
		int intIsCreatePNR = 0;
		// 是否生成外部订单
		int intIsCreateOuterOrder = 0;
		// 是否按照原政策信息已经生成外部订单
		int intIsCreated = 0;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		try {

			// 插入乘机人
			String[] h_ptypes = h_ptype.trim().split(strSubSplit);
			String[] h_names = h_name.trim().split(strSubSplit);
			String[] h_idtypes = h_idtype.trim().split(strSubSplit);
			String[] h_idnumbers = h_idnumber.trim().split(strSubSplit);
			String[] h_birthdays = h_birthday.trim().split(strSubSplit);
			String[] bxcounts = bxcount.trim().split(strSubSplit);
			// 最优政策
			Zrate bestzrate = new Zrate();
			Passenger passenger;
			// 单行程
			segmentOne = (Segmentinfo) ActionContext.getContext().getSession()
					.get("segmentOne");
			if (ActionContext.getContext().getSession().get("segmentTwo") != null) {
				segmentTwo = (Segmentinfo) ActionContext.getContext()
						.getSession().get("segmentTwo");
			} else {
				segmentTwo = null;
			}

			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
			List<Segmentinfo> listsegmenginfo = new ArrayList<Segmentinfo>();
			List<Segmentinfo> listsegmenginf = null;
			Customeruser customeruser = getLoginUser();
			listsegmenginfo.add(segmentOne);

			if (segmentTwo != null) {
				listsegmenginfo.add(segmentTwo);
			}
			int size = listsegmenginfo.size();
			int iVa = 1;// 只给一个表单加入平台费
			for (int n = 0; n < size; n++) {
				listPassenger = new ArrayList<Passenger>();
				listsegmenginf = new ArrayList<Segmentinfo>();
				Segmentinfo segment = listsegmenginfo.get(n);
				listsegmenginf.add(segment);
				// 插入订单
				orderinfo = new Orderinfo();
				orderinfo.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				// 会员ID
				try {
					Customeruser memberbook = (Customeruser) ActionContext
							.getContext().getSession().get("orderuserlogin");
					orderinfo.setCustomeruserid(memberbook.getId());
				} catch (Exception e) {
				}
				// 分销商员工ID,即预订人ID
				orderinfo.setSaleagentid(getLoginUserId());
				// 分销商单位ID
				// 分销商单位ID
				orderinfo.setBuyagentid(customeruser.getAgentid());
				orderinfo.setPolicyid(segment.getZrateid());
				orderinfo.setContactmobile(s_contactmobile);

				// 支付方式
				orderinfo.setPaymethod(Integer.parseInt(s_paymethod));
				// 如果是虚拟帐号支付
				// var
				// fkmethodstr=b==1?"网上支付(快钱)":b==2?"门市付款":b==3?"票到付款":"虚拟账户支付";
				if (s_paymethod.equals("2")) {
					orderinfo.setPaystatus(1); // 已支付
					// 虚拟账户支付，已支付，等待出票
					orderinfo.setOrderstatus(2);
				}
				// 月结支付
				else if (s_paymethod.equals("5")) {
					orderinfo.setPaystatus(0); // 未支付
					// 月结支付，未支付，等待出票
					orderinfo.setOrderstatus(2);
				} else {
					orderinfo.setPaystatus(0); // 未支付
					// 网上支付，未支付，等待支付
					// 在未创建外部订单之前，订单状态为待确认。
					orderinfo.setOrderstatus(27);
					if (s_paymethod.equals("3")) {
						orderinfo.setReceipt(4);// 4：市内配送。参照东航。
					}

				}
				orderinfo.setLanguage(0);
				orderinfo.setOrdertype(2l);// b2b订单
				float subfuelfee = 0;
				float subairportfee = 0;
				float subprice = 0;
				// 插入乘机人
				for (int i = 0; i < h_names.length; i++) {
					if (h_names[i].trim().length() > 0) {
						passenger = new Passenger();
						passenger
								.setPtype(Integer.parseInt(h_ptypes[i].trim()));
						if (passenger.getPtype() == 1) {
							passenger.setPrice(segment.getPrice());
							passenger.setAirportfee(segment.getAirportfee());
							passenger.setFuelprice(segment.getFuelfee());
						} else if (passenger.getPtype() == 2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(getRoundPrice(segment
									.getFuelfee(), 2));
							if (segment.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segment
										.getParvalue(), 2));
							} else {
								passenger.setPrice(getRoundPrice(segment
										.getYprice(), 2));
							}
						} else {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(0f);
							// 儿童婴儿价
							if (segment.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segment
										.getParvalue(), 10));
							} else {
								passenger.setPrice(getRoundPrice(segment
										.getYprice(), 10));
							}
						}
						subprice += passenger.getPrice();
						subfuelfee += passenger.getFuelprice();
						subairportfee += passenger.getAirportfee();
						passenger.setName(h_names[i]);
						passenger.setIdtype(Integer.parseInt(h_idtypes[i]
								.trim()));
						passenger.setIdnumber(h_idnumbers[i].trim());
						passenger.setFet(segment.getId() + "");
						passenger.setDiscount(segment.getDiscount());
						passenger.setState(0);
						passenger.setLanguage(0);
						listPassenger.add(passenger);
					}
				}
				List<Long> zratelist = new ArrayList<Long>();
				zratelist.add(zrate_one);
				zratelist.add(zrate_two);
				Zrate zrate = Server.getInstance().getAirService().findZrate(
						zratelist.get(n));
				orderinfo.setPolicyid(zrate.getId());// 政策ID
				orderinfo
						.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate
								.getRatevalue())));// 分销商返点
				orderinfo.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfo.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfo.setExtpolicyid(zrate.getOutid()); // 外部政策id
				segment.setAgentid(zrate.getAgentid());
				segment.setRatevalue(zrate.getRatevalue());
				segment.setZrateid(zrate.getId());
				segment.setLanguage(0);
				segment.setZrate(zrate);
				if (intIsCreatePNR == 1) {
					if (intCreatePNRType == 1) {
						s_returnpnr = Server.getInstance()
								.getTicketSearchService().CreatePNRByCmd(
										listsegmenginf, listPassenger, "");
					} else {
						s_returnpnr = Server.getInstance()
								.getTicketSearchService().CreatePNRByInterFace(
										listsegmenginf, listPassenger, "");
					}
				} else {
					s_returnpnr = "123456";
				}
				// s_returnpnr ="HQL4FW";
				System.out.println("**********************生成的PNR编码："
						+ s_returnpnr);
				System.out.println(s_returnpnr);
				// 判断是否生成PNR
				if (s_returnpnr.equals("NOPNR")) {
					this.forwork = "NOPNR";
					break;
				}
				// 机建费
				orderinfo.setTotalairportfee(subairportfee);
				// 燃油费
				orderinfo.setTotalfuelfee(subfuelfee);
				// 总机票价格+平台费用
				orderinfo.setTotalticketprice(subprice);// 存入数据库中的数据
				if (iVa <= 1)
					orderinfo.setCurrplatfee(this.orderPlat);

				// 供应商ID
				orderinfo.setPnr(s_returnpnr);

				// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
				/*
				 * String strBigPNR = "无"; if (orderinfo.getPolicyagentid() ==
				 * 5) {// 51BOOKxu strBigPNR =
				 * Server.getInstance().getTicketSearchService()
				 * .getBigPNRInfo(s_returnpnr); }
				 * orderinfo.setBigpnr(strBigPNR);
				 */
				// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
				orderinfo.setPolicyagentid(segment.getAgentid());
				orderinfo.setPostmoney(0);
				orderinfo.setPassengerlist(listPassenger);
				listOrderinfo.add(orderinfo);

			}
			//
			if (!s_returnpnr.equals("NOPNR")) {
				for (int j = 0; j < listOrderinfo.size(); j++) {
					orderinfo = listOrderinfo.get(j);

					Segmentinfo seginfo = listsegmenginfo.get(0);
					// 如果是其他供应商政策，则不生成外部订单
					if ((orderinfo.getPolicyagentid() == 3
							|| orderinfo.getPolicyagentid() == 5 || orderinfo
							.getPolicyagentid() == 6)
							&& intIsCreateOuterOrder == 1) {
						intIsCreateOuterOrder = 1;
						System.out.println("属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
					} else {
						intIsCreateOuterOrder = 0;
						// 不属于平台政策，则可以直接支付订单
						orderinfo.setOrderstatus(1);
						System.out.println("不属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
					}
					if (intIsCreateOuterOrder == 1) {
						try {
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfo,
											seginfo,
											orderinfo.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								intIsCreated = 1;
								if (orderinfo.getPolicyagentid() == 5) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfo
														.setExtorderid(strExtOrderArr[1]);
												orderinfo
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else {
									// 外部订单号
									orderinfo.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfo.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfo.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (s_paymethod.equals("2")
										|| s_paymethod.equals("3")) {
									orderinfo.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfo.setOrderstatus(2);
								} else {
									orderinfo.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								intIsCreated = 0;
								System.out.println("按照本地政策，创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
							}
						} catch (Exception ex) {
							intIsCreated = 0;
							System.out.println("按照本地政策，创建外部订单失败，异常结果:"
									+ ex.getMessage());
						}
					}
					// 如果没有按照原始政策，生成外部订单，则按照最优政策信息，再次生成外部订单
					System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
					System.out.println("是否生成外部订单标记：" + intIsCreateOuterOrder
							+ " 是否已按照原始政策生成外部订单：" + intIsCreated);
					if (intIsCreateOuterOrder == 1 && intIsCreated == 0) {
						// 匹配最优政策，并生成外部订单
						try {
							try {
								bestzrate = Server.getInstance()
										.getRateService().FindZrateByFlight(
												orderinfo, seginfo,
												orderinfo.getPassengerlist());
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									try {
										// 计算价格
										orderinfo
												.setPolicyid(bestzrate.getId());// 政策ID
										orderinfo
												.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
														.getRatevalue())));// 分销商返点
										orderinfo.setPolicyagentid(bestzrate
												.getAgentid());// 政策提供商id
										orderinfo
												.setRatevalue(dceimalFormat(bestzrate
														.getRatevalue()));// 折扣
										orderinfo.setExtpolicyid(bestzrate
												.getOutid()); // 外部政策id
										System.out.println("调用最优政策方法,成功,政策为=="
												+ bestzrate);
									} catch (RuntimeException e) {
										System.out
												.println("调用最优政策方法,出现异常,异常信息："
														+ e.getMessage());
										e.printStackTrace();
									}
								}

							} catch (RuntimeException e) {
								System.out.println("调用最优政策方法,出现异常,异常信息："
										+ e.getMessage());
								e.printStackTrace();
							}
							seginfo.setZrate(bestzrate);
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfo,
											seginfo,
											orderinfo.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								if (orderinfo.getPolicyagentid() == 5) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfo
														.setExtorderid(strExtOrderArr[1]);
												orderinfo
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else {
									// 外部订单号
									orderinfo.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfo.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfo.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (s_paymethod.equals("2")
										|| s_paymethod.equals("3")) {
									orderinfo.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfo.setOrderstatus(2);
								} else {
									orderinfo.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								System.out.println("按照最优政策创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("按照最优政策创建外部订单失败，异常信息"
									+ e.getMessage());
						}
					}

					// 计算总利润，以及留点记录信息
					// 成人总数
					int intadult = 0;
					for (int i = 0; i < orderinfo.getPassengerlist().size(); i++) {
						if (orderinfo.getPassengerlist().get(i).getPtype() == 1) {
							intadult++;
						}
					}
					Float fzonglirun = orderinfo.getRatevalue()
							* seginfo.getParvalue() / 100 * intadult;
					int intzonglirun = fzonglirun.intValue();
					orderinfo.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));

					// 生成本地订单信息

					orderinfo = Server.getInstance().getAirService()
							.createOrderinfo(orderinfo);

					System.out.println("订单信息==" + orderinfo);
					System.out.println("订单ID==" + orderinfo.getId());
					System.out.println("外部订单ID==" + orderinfo.getExtorderid());

					Segmentinfo segmentinfo = listsegmenginfo.get(j);
					segmentinfo.setOrderid(orderinfo.getId());
					// 获取新政策，更新航程信息
					// Creater by:sunbin
					// 2011-10-18
					if (bestzrate != null && bestzrate.getRatevalue() != null
							&& bestzrate.getAgentid() != null) {
						Float fsegmentprice = segmentinfo.getParvalue()
								* (1 - Getliudianvalue(bestzrate.getRatevalue()) / 100);
						int intsegmentprice = fsegmentprice.intValue();
						segmentinfo.setAgentid(bestzrate.getAgentid());
						segmentinfo.setRatevalue(bestzrate.getRatevalue());
						segmentinfo.setZrateid(bestzrate.getId());
						segmentinfo.setPrice(Float.parseFloat(String
								.valueOf(intsegmentprice)));
						segmentinfo.setRules(bestzrate.getRemark());
					}
					// 获取新政策，更新航程信息
					// 结束
					segmentinfo = Server.getInstance().getAirService()
							.createSegmentinfo(segmentinfo);

					System.out.println(orderinfo.getPassengerlist().size());
					int l = 0;
					float subpricenew = 0;
					float insurprice = 0f;// 保险价格
					for (Passenger passeng : orderinfo.getPassengerlist()) {
						passeng.setOrderid(orderinfo.getId());
						String bxname = "阳光";
						String bxcount = bxcounts[l];
						// passeng.setInsurance(null);
						if (Integer.valueOf(bxcount) > 0) {
							Insuranceinfo insurance = new Insuranceinfo();
							insurance.setCompanyname(bxname);
							insurance.setInsurancename(bxname + "航空意外保险");
							insurance
									.setCreatetime(dateToTimestamp(formatTimestamp2(segmentinfo
											.getDeparttime())));
							Timestamp tem = new Timestamp(insurance
									.getCreatetime().getTime());
							tem.setDate(tem.getDate() + 7);
							insurance.setEnddate(tem);
							insurance.setToubaoren(passeng.getName());
							insurance.setBeibaoren(passeng.getName());
							insurance.setInsurancenum(Integer.valueOf(bxcount));
							if (segmentTwo != null) {
								if (!new B2bAirSearchAction().isInInsrutime(
										segmentOne.getDeparttime(), segmentTwo
												.getDeparttime())) {
									if (j == 0) {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.ceil(Integer
													.valueOf(bxcount) / 2.0);
										}
										insurance.setInsurancenum(count);
										insurance
												.setInsurancefee(String
														.valueOf(insurance
																.getInsurancenum() * 20));
										insurance = Server.getInstance()
												.getMemberService()
												.createInsuranceinfo(insurance);
										// passeng.setInsurance(insurance.getId());
									} else {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.floor(Integer
													.valueOf(bxcount) / 2.0);
											insurance.setInsurancenum(count);
											insurance
													.setInsurancefee(String
															.valueOf(insurance
																	.getInsurancenum() * 20));
											insurance = Server.getInstance()
													.getMemberService()
													.createInsuranceinfo(
															insurance);
											// passeng.setInsurance(insurance
											// .getId());
										}
									}

								} else {
									if (j == 0) {
										insurance
												.setInsurancefee(String
														.valueOf(insurance
																.getInsurancenum() * 20));
										insurance = Server.getInstance()
												.getMemberService()
												.createInsuranceinfo(insurance);
										// passeng.setInsurance(insurance.getId());
									}
								}
							} else {
								insurance
										.setInsurancefee(String
												.valueOf(insurance
														.getInsurancenum() * 20));
								insurance = Server.getInstance()
										.getMemberService()
										.createInsuranceinfo(insurance);
								// passeng.setInsurance(insurance.getId());

							}
							insurprice += Float.valueOf(converNull(insurance
									.getInsurancefee(), "0"));
						}
						// 获取最优政策，更新乘机人信息
						// Created By:sunbin
						// 2011-10-18
						if (bestzrate != null
								&& bestzrate.getRatevalue() != null
								&& bestzrate.getAgentid() != null) {
							if (passeng.getPtype() == 1) {
								passeng.setPrice(segmentinfo.getPrice());
								passeng.setAirportfee(segmentinfo
										.getAirportfee());
								passeng.setFuelprice(segmentinfo.getFuelfee());
							} else if (passeng.getPtype() == 2) {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(getRoundPrice(segmentinfo
										.getFuelfee(), 2));
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getParvalue(), 2));
								} else {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getYprice(), 2));
								}
							} else {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(0f);
								// 儿童婴儿价
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getParvalue(), 10));
								} else {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getYprice(), 10));
								}
							}
							subpricenew += passeng.getPrice();
							// 获取最优政策，更新乘机人信息
							// 结束
						}
						Server.getInstance().getAirService().createPassenger(
								passeng);
						l++;
					}

					// 更新订单总价信息
					if (subpricenew != 0f) {
						// 总机票价格+平台费用
						orderinfo.setTotalticketprice(subpricenew);// 存入数据库中的数据
					}
					if (j == 0) {
						this.orderinfo1 = orderinfo;
					} else {
						this.orderinfo2 = orderinfo;
					}
					System.out
							.println("***************************返佣信息**************************************");

					String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfo.getRatevalue(),
							Getliudianvalue(orderinfo.getRatevalue()), seginfo
									.getParvalue(), insurprice);
					System.out.println(strCustomgeragentBackPointInfo);
					orderinfo.setFenxiaoshangfandian(Getliudianvalue(orderinfo
							.getRatevalue()));
					orderinfo.setBackpointinfo(strCustomgeragentBackPointInfo);
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfo);
				}
				if (orderinfo2.getId() > 0) {
					String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
							+ orderinfo1.getId() + " WHERE ID="
							+ orderinfo2.getId()
							+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
							+ orderinfo2.getId() + " WHERE ID="
							+ orderinfo1.getId();
					Server.getInstance().getSystemService().findMapResultBySql(
							sql, null);

				}
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zrateone");
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zratetwo");
				System.out.println(issavepassenger);
				// 是否保存常用乘机人信息
				String[] ArrIsSave = issavepassenger.split(",");
				String strTempPassenger = "";
				for (int i = ArrIsSave.length - 1; i >= 0; i--) {
					strTempPassenger += ArrIsSave[i] + ",";
				}
				String[] ArrIsSaveNew = strTempPassenger.split(",");

				for (int i = 0; i < orderinfo.getPassengerlist().size(); i++) {
					String where = " where 1=1 and "
							+ Customerpassenger.COL_customeruserid
							+ " = "
							+ getLoginUser().getId()
							+ " and "
							+ Customerpassenger.COL_username
							+ " = '"
							+ orderinfo.getPassengerlist().get(i).getName()
									.trim() + "'";

					List<Customerpassenger> list = Server.getInstance()
							.getMemberService().findAllCustomerpassenger(where,
									"", -1, 0);
					// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
					if (ArrIsSaveNew[i].equals("0")
							|| (list != null && list.size() > 0)) {
						continue;
					}
					try {
						// 当前登录员工
						Customeruser loginEmployee = getLoginUser();
						Customerpassenger customerpassenger = new Customerpassenger();
						customerpassenger.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customerpassenger.setCreateuser(getLoginUser()
								.getLoginname());
						customerpassenger.setUsername(orderinfo
								.getPassengerlist().get(i).getName().trim());
						customerpassenger.setType(1);
						customerpassenger.setCustomeruserid(loginEmployee
								.getId());
						customerpassenger = Server.getInstance()
								.getMemberService().createCustomerpassenger(
										customerpassenger);
						// 添加证件
						Customercredit customercredit = new Customercredit();
						customercredit.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setCreateuser(loginEmployee
								.getMembername());
						customercredit
								.setCreditnumber(orderinfo.getPassengerlist()
										.get(i).getIdnumber().trim());
						customercredit.setCredittypeid(orderinfo
								.getPassengerlist().get(i).getIdtype());
						customercredit.setModifytime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setModifyuser(loginEmployee
								.getMembername());
						customercredit.setRefid(customerpassenger.getId());
						customercredit.setType(1);
						Server.getInstance().getMemberService()
								.createCustomercredit(customercredit);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				forwork = "b2bticketorder!payorder.action?orderinfo.id="
						+ orderinfo1.getId();
			}

			//
		} catch (Exception e) {
			e.printStackTrace();
			forwork = "ERROR";
		}
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(forwork);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建订单前对象赋值
	 * 
	 * @throws Exception
	 */
	public void toaddorder() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");

		// 取得乘机人信息
		String[] h_ptypes = h_ptype.trim().split(strSubSplit);
		String[] h_names = h_name.trim().split(strSubSplit);
		String[] h_idtypes = h_idtype.trim().split(strSubSplit);
		String[] h_idnumbers = h_idnumber.trim().split(strSubSplit);
		String[] h_birthdays = h_birthday.trim().split(strSubSplit);

		String[] bxcounts = bxcount.trim().split(strSubSplit);
		// 航程信息
		segmentOne = (Segmentinfo) ActionContext.getContext().getSession().get(
				"segmentOne");
		if (ActionContext.getContext().getSession().get("segmentTwo") != null) {
			segmentTwo = (Segmentinfo) ActionContext.getContext().getSession()
					.get("segmentTwo");
		} else {
			segmentTwo = null;
		}
		// 航程list
		List<Segmentinfo> listsegmenginfo = new ArrayList<Segmentinfo>();
		// 乘机人list
		List<Passenger> listpassenger = new ArrayList<Passenger>();
		// 当前登录员工
		Customeruser loginemployee = getLoginUser();
		// 航程list 赋值
		listsegmenginfo.add(segmentOne);
		if (segmentTwo != null) {
			listsegmenginfo.add(segmentTwo);
		}
		/** ***订单信息赋值开始*********************************************************** */
		orderinfo = new Orderinfo();
		
		//订单备注
		if(c_memo!=null&&c_memo.trim().length()>0){
		orderinfo.setMemo(c_memo.trim());
		}
		// 创建时间
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// 会员ID
		try {
			Customeruser memberbook = (Customeruser) ActionContext.getContext()
					.getSession().get("orderuserlogin");
			orderinfo.setCustomeruserid(memberbook.getId());
		} catch (Exception e) {
			orderinfo.setCustomeruserid(loginemployee.getId());
		}
		// 分销商员工ID,即预订人ID
		orderinfo.setSaleagentid(loginemployee.getId());
		// 分销商单位ID,加盟商ID
		orderinfo.setBuyagentid(loginemployee.getAgentid());
		// 联系手机号
		orderinfo.setContactmobile(s_contactmobile);
		orderinfo.setContactname(s_contactname);
		/** **支付方式赋值开始**************************************** */
		// 1=网上支付(快钱) 2=门市付款 3=票到付款":"虚拟账户支付";
		if (s_paymethod.equals("2")) {
			// 已支付
			orderinfo.setPaystatus(1);
			// 门市付款，已支付，等待出票
			orderinfo.setOrderstatus(2);
		}
		// 月结支付
		else if (s_paymethod.equals("5")) {
			// 未支付
			orderinfo.setPaystatus(0);
			// 月结支付，未支付，等待出票
			orderinfo.setOrderstatus(2);
		} else {
			// 未支付
			orderinfo.setPaystatus(0);
			// 网上支付，未支付，等待支付
			// 在未创建外部订单之前，订单状态为待确认。
			orderinfo.setOrderstatus(27);
			if (s_paymethod.equals("3")) {
				// 4：市内配送
				orderinfo.setReceipt(4);
			}
		}
		
		// 预订儿童票时成人PNR编码
		orderinfo.setNewpnr(s_adultpnr);
		// 支付方式
		orderinfo.setPaymethod(Integer.parseInt(s_paymethod));
		/** **支付方式赋值开始**************************************** */
		
		orderinfo.setLanguage(0);
		// 订单类型 b2b后台订单
		orderinfo.setOrdertype(2l);
		/** **订单信息赋值结束*********************************************************** */

		/** **本地政策赋值开始**************************************** */
		List<Long> zratelist = new ArrayList<Long>();
		zratelist.add(zrate_one);
		zratelist.add(zrate_two);
		/** **本地政策赋值开始**************************************** */

		/** **乘机人信息赋值开始*********************************************************** */
		for (int i = 0; i < h_names.length; i++) {
			if (h_names[i].trim().length() > 0) {
				Passenger passenger = new Passenger();
				passenger.setPtype(Integer.parseInt(h_ptypes[i].trim()));

				passenger.setName(h_names[i]);
				if(!h_ptypes[i].trim().equals("3")){
				passenger.setIdtype(Integer.parseInt(h_idtypes[i].trim()));
				passenger.setIdnumber(h_idnumbers[i].trim());
				}
				try {
					passenger.setBirthday(h_birthdays[i].trim());
				} catch (Exception ex) {
				}
				 //PNR联系方式
			    passenger.setMobile(orderinfo.getContactmobile());
				passenger.setState(0);
				passenger.setLanguage(0);
				listpassenger.add(passenger);
			}
		}
		/** **乘机人信息赋值结束*********************************************************** */
		// 平台费手续费
		orderinfo.setCurrplatfee(this.orderPlat);
		if(isxcd!=null&&isxcd.equals("1")){
			orderinfo.setPostmoney(this.xcdPlat*listpassenger.size());
		}
		if(ispeisong!=null&&ispeisong.equals("1")){
			//配送费
		orderinfo.setPostmoney(this.xcdPlat*listpassenger.size()+this.xcdpsPlat);
			
		}
		
		
		
		orderinfo.setContactemail(s_txtcontactemail);//旅客邮箱
		orderinfo.setContacttel(s_txtcaigoumobile);//采购商联系电话

		// 创建订单信息
		
		
		/*forwork = CreateOrder(listsegmenginfo, listpassenger, orderinfo,
				zratelist, "0", issavepassenger, 1);*/
		/*forwork = CreateOrder(listsegmenginfo, listpassenger, orderinfo,
				zratelist,bxcount , issavepassenger, 1);*/
		
		forwork = CreateOrder_new(listsegmenginfo, listpassenger, orderinfo,
				zratelist,bxcount , issavepassenger, 1);
		
		if(forwork!=null&&forwork.indexOf("b2bticketorder!payorder")!=-1&&ispeisong!=null&&ispeisong.equals("1")){//说明创建订单成功.添加配送记录
		String orderid=	forwork.split("&")[0].trim().split("=")[1].trim();
		Peisong peisong=new Peisong();
		peisong.setOrderid(Long.parseLong(orderid));
		peisong.setAgentid(getLoginUser().getAgentid());
		peisong.setUserid(getLoginUser().getId());
		peisong.setCreatetime(new Timestamp(System.currentTimeMillis()));
		peisong.setLinkname(lianxiname);
		peisong.setLinktel(lianxitel);
		peisong.setDizhi(peisongadd);
		peisong.setAddcode(youzhengbianma);
		peisong.setState(0l);//0未配送
		Server.getInstance().getAirService().createPeisong(peisong);
		
		}
		
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(forwork);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//从新选择政策下单
	public void NextCreateorder(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String sub="-1";
		
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(s_orderid);
		Orderinfo orderinfoold=Server.getInstance().getAirService().findOrderinfo(s_orderid);
		List<Segmentinfo> listseg=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
		List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
		Zrate zrate = Server.getInstance().getAirService().findZrate(ajax_zid);
		
		Segmentinfo segmentinfo=listseg.get(0);
		segmentinfo.setZrate(zrate);
		Customeruser loginemployee = getLoginUser();
		//orderinfo.setCustomeruserid(loginemployee.getId());
		// 分销商员工ID,即预订人ID
		//orderinfo.setSaleagentid(loginemployee.getId());
		// 分销商单位ID,加盟商ID
		//orderinfo.setBuyagentid(loginemployee.getAgentid());
	
		orderinfo.setPolicyid(ajax_zid);
		orderinfo.setRatevalue(zrate.getRatevalue());
		//orderinfo.setFenxiaoshangfandian(zrate.getRatevalue());
		//orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinfo.setPolicyagentid(zrate.getAgentid());
		
		if(zrate.getGeneral()!=null){
			orderinfo.setReceipt(Integer.parseInt(zrate.getGeneral()+""));//政策类型  普通 特殊
		}else{
			
			orderinfo.setReceipt(1);
		}
		
		
		String oldno="";
		String oldfandian="";
		if(orderinfoold.getExtorderid()!=null){
			oldno=orderinfoold.getExtorderid();
			oldfandian=orderinfoold.getRatevalue()+"";
		}
		
		
		if(orderinfo.getPnrtxt()!=null&&orderinfo.getPnrtxt().indexOf("BJS182")!=-1){
			orderinfo.setPnrtxt(orderinfo.getPnrtxt().replace(" b ", "").split("[.]BJS182")[0]+".BJS182");
		}
		if(orderinfo.getPnrtxt()!=null&&orderinfo.getPnrtxt().indexOf("PEK868")!=-1){
			orderinfo.setPnrtxt(orderinfo.getPnrtxt().replace(" b ", "").split("[.]PEK868")[0]+".PEK868");
		}
		
		
		String strExtOrderNumber = Server.getInstance().getRateService().CreateOrder(orderinfo,
				segmentinfo, listpass);
		WriteLog.write("外部订单返回", strExtOrderNumber);
		// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
		if (!strExtOrderNumber.equals("-1")) {
			if (orderinfo.getPolicyagentid() == 5 || orderinfo.getPolicyagentid() == 2 ||orderinfo.getPolicyagentid() == 7) {
			// 返回格式：S|订单号|支付url
			// 外部订单号

			if (strExtOrderNumber.indexOf("|") > 0) {
				String[] strExtOrderArr = strExtOrderNumber
						.split("[|]");
				
					
				if (strExtOrderArr.length == 3) {
					if (strExtOrderArr[0].equals("S")) {
						
						System.out.println("strExtOrderArr[1]:"+strExtOrderArr[1]);
						System.out.println("strExtOrderArr[2]:"+strExtOrderArr[2]);
						orderinfo
								.setExtorderid(strExtOrderArr[1]);
						orderinfo
								.setPaymenturl(strExtOrderArr[2]);
					}
				}
			}

		}else if(orderinfo.getPolicyagentid() == 6||orderinfo.getPolicyagentid() == 4){
			if (strExtOrderNumber.indexOf("@") != -1) {
				String[] strExtOrderArrpnr = strExtOrderNumber.split("[@]");
				WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfo.getPolicyagentid());
				orderinfo.setExtorderid(strExtOrderArrpnr[0].trim());
				//orderinfomodel.setPnr(strExtOrderArrpnr[1].trim());
				WriteLog.write("外部订单号", "订单号:"+strExtOrderNumber+",政策加盟商:"+orderinfo.getPolicyagentid()+",外部id:"+strExtOrderArrpnr[0].trim()+",PNR:"+strExtOrderArrpnr[1].trim());
		
				if(orderinfo.getPolicyagentid() == 4&&strExtOrderArrpnr[3]!=null){//百拓
					orderinfo.setExtorderprice(Float.parseFloat(strExtOrderArrpnr[3].trim()));
				}
				
				
				
			}
		} else {
			// 外部订单号
			orderinfo.setExtorderid(strExtOrderNumber);
		}
		// 外部订单状态
			orderinfo.setExtorderstatus(0);
		// 外部订单创建时间
			orderinfo.setExtordercreatetime(new Timestamp(
				System.currentTimeMillis()));
		// 本地订单状态为待支付
		
		// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
		
		Orderinforc orderinforc = new Orderinforc();
		System.out.println("id:"+orderinfo.getId());
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(-1);
		orderinforc.setContent("从新下单-" + getLoginUser().getMembername()
				+ "从新下单,原外部订单号:"+oldno+",新订单号:"+orderinfo.getExtorderid()+",原返点:"+oldfandian+",新返点:"+orderinfo.getRatevalue());
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setLanguage(0);
		System.out.println("orderinforc:"+orderinforc.toString());
		try {
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		
	} else {
		System.out.println("按照最优政策创建外部订单失败，返回结果:"
				+ strExtOrderNumber);
		
		
	}
		
		if(!strExtOrderNumber.equals("-1")){
			
			
			sub=orderinfo.getId()+"";
		}
		/*
		if(!strExtOrderNumber.equals("-1")){
		
			
		try {
			//orderinfo.setId(-1);
			
			//orderinfo=Server.getInstance().getAirService().createOrderinfo(orderinfo);
			sub=orderinfo.getId()+"";
			//Orderinfo orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());
			//segmentinfo.setOrderid(orderinfo2.getId());
			//segmentinfo.setId(0);
			segmentinfo.setRatevalue(orderinfo.getRatevalue());
			segmentinfo.setAgentid(zrate.getAgentid());
			segmentinfo.setPrice(FrmatJinYi(segmentinfo.getParvalue()-(segmentinfo.getParvalue()*orderinfo.getFenxiaoshangfandian()/100)));
			segmentinfo.setZrateid(zrate.getId());
			
			Server.getInstance().getAirService().updateSegmentinfoIgnoreNull(segmentinfo);
			
			float subprice = 0;
			for(int p=0;p<listpass.size();p++){
				Passenger passenger=listpass.get(p);
				passenger.setId(0);
				passenger.setOrderid(orderinfo2.getId());
				if (passenger.getPtype() == 1) {
					passenger.setPrice(segmentinfo.getPrice());
				} else if (passenger.getPtype() == 2) {
					if (segmentinfo.getDiscount() > 100) {
						passenger.setPrice(getRoundPrice(segmentinfo.getParvalue(), 2));
					} else {
						passenger.setPrice(getRoundPrice(segmentinfo.getYprice(), 2));
					}
				}
				subprice += passenger.getPrice();
				Server.getInstance().getAirService().createPassenger(passenger);
				
			}
			System.out.println("subprice:"+subprice);
			orderinfo.setTotalticketprice(subprice);
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		*/
		
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(sub);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String topayorder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("nextpay", "");
		return this.payorder();
	}
	
	
	public String valadataTime(String time) {
		//System.out.println("time:"+time);
		String ret="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		String startDate = sdf.format(calendar.getTime());
		//System.out.println("startDate:"+startDate);
		if(startDate.equals(time.trim())){
			ret="style='background-color: red'";
		}
		//System.out.println("ret:"+ret);
		return ret;
	}
	
	

	/**
	 * 应付保险
	 * 
	 * @return
	 */
	public float getInsurancepirice(String backinfo) {
		String[] strs = backinfo.split("@");
		float chengben = Float.valueOf(strs[strs.length - 1].split("\\|")[0]);
		float goumai = Float.valueOf(strs[strs.length - 1].split("\\|")[1]);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		int bxcb=20;
		if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
			bxcb=Integer.parseInt(session.getAttribute("INSURPRICE").toString().trim());
		}
		int count = (int) goumai / bxcb;
		return goumai - (count * chengben);
	}

	public String payorder() {
		float totalprice = 0f;
		/*orderinfo = this
				.findBySql(
						Orderinfo.class,
						"SELECT ID id,C_BACKPOINTINFO backpointinfo,C_RELATIONORDERID relationorderid,C_ORDERSTATUS orderstatus ,REBAT fenxiaoshangfandian, C_ORDERNUMBER ordernumber , ISNULL(C_TOTALTICKETPRICE,0) totalticketprice,"
								+ "ISNULL(C_TOTALAIRPORTFEE,0) totalairportfee,ISNULL(C_TOTALFUELFEE,0) totalfuelfee,"
								+ "C_PNR pnr,C_BIGPNR bigpnr,ISNULL(C_CURRPLATFEE,0) currplatfee"
								+ " FROM view_orderinfo WHERE ID="
								+ orderinfo.getId());*/
		
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());
		
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				"where 1=1 and " + Passenger.COL_orderid + " ="
						+ orderinfo.getId(), "", -1, 0);
		float totalinsurprice = 0f;
		float totalinsurprice2 = 0f;
		for (Passenger passenger : listPassenger) {
			totalinsurprice += passenger.getInsurprice();
			if(passenger.getAnjianfee()!=null){
			totalinsurprice2 += passenger.getAnjianfee();
			}
		}
		orderinfo.setTotalinsurprice(totalinsurprice);
		orderinfo.setOrderprice(orderinfo.getTotalticketprice()
				+ orderinfo.getTotalinsurprice() + orderinfo.getTotalfuelfee()
				+ orderinfo.getTotalairportfee()+totalinsurprice2); //
		totalprice += orderinfo.getOrderprice();
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				"where 1=1 and " + Segmentinfo.COL_orderid + " ="
						+ orderinfo.getId(), "", -1, 0);
		if (orderinfo.getRelationorderid() != null
				&& orderinfo.getRelationorderid() > 0) {
			orderinfo2 = this
					.findBySql(
							Orderinfo.class,
							"SELECT ID id,C_ORDERSTATUS orderstatus,C_ORDERNUMBER ordernumber, ISNULL(C_TOTALTICKETPRICE,0) totalticketprice,REBAT fenxiaoshangfandian,"
									+ "ISNULL(C_TOTALAIRPORTFEE,0) totalairportfee,ISNULL(C_TOTALFUELFEE,0) totalfuelfee,"
									+ "C_PNR pnr,C_BIGPNR bigpnr,ISNULL(C_CURRPLATFEE,0) currplatfee,ISNULL(INSURANCEPRICE,0) as totalinsurprice"
									+ " FROM view_orderinfo WHERE ID="
									+ orderinfo.getRelationorderid());
			//orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
			listPassenger2 = Server.getInstance().getAirService()
					.findAllPassenger(
							"where 1=1 and " + Passenger.COL_orderid + " ="
									+ orderinfo2.getId(), "", -1, 0);

			listSegment2 = Server.getInstance().getAirService()
					.findAllSegmentinfo(
							"where 1=1 and " + Segmentinfo.COL_orderid + " ="
									+ orderinfo2.getId(), "", -1, 0);
			float totalinsruprice = 0f;
			for (Passenger passenger : listPassenger2) {
				totalinsruprice += passenger.getInsurprice();
			}

			orderinfo2.setTotalinsurprice(totalinsruprice);
			orderinfo2.setOrderprice(orderinfo2.getTotalticketprice()
					+ orderinfo2.getTotalinsurprice()
					+ orderinfo2.getTotalfuelfee()
					+ orderinfo2.getTotalairportfee()); //
			totalprice += orderinfo2.getOrderprice();

		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("billname", "Airpayhelper");// 对应接口中 支付辅助类 必传
		map.put("orderid", orderinfo.getId());// 订单id 必传
		if (ServletActionContext.getServletContext().getAttribute(
				"vmoneyservice") != null) {// 判断是否有虚拟账户业务
			map.put("actionname", "b2bticketorder!vmoneyAirticketpay.action");

			boolean vpay = true;
			float vmoney = new CustomeragentServiceImpl().getTotalVmoney(this
					.getLoginUser().getAgentid());
			if (totalprice > vmoney) {
				vpay = false;
			}
			map.put("vmoney", vmoney);
			map.put("vmpayenable", vpay);// 如果可虚拟账户支付 传入当前账户余额
		}
		map.put("orderprice", totalprice
				+ converNull(orderinfo.getCurrplatfee(), 0f)+ converNull(orderinfo.getPostmoney(), 0));
		request.setAttribute("ordermap", map);// 传值....
		return "ticketorderinfo";
	}
	public String payorder2() {
		float totalprice = 0f;
		
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());
		
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				"where 1=1 and " + Passenger.COL_orderid + " ="
						+ orderinfo.getId(), "", -1, 0);
		
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				"where 1=1 and " + Segmentinfo.COL_orderid + " ="
						+ orderinfo.getId(), "", -1, 0);
		float totalinsurprice = 0f;
		float price=0f;
		
		
		for (Passenger passenger : listPassenger) {
			totalinsurprice += passenger.getInsurprice();
			
			
		}
		orderinfo.setTotalinsurprice(totalinsurprice);
		orderinfo.setOrderprice(orderinfo.getTotalticketprice()
				+ orderinfo.getTotalinsurprice() + orderinfo.getTotalfuelfee()
				+ orderinfo.getTotalairportfee()+orderinfo.getRebatemoney()); //积分用户,加上利润
		totalprice += orderinfo.getOrderprice();
	
		if (orderinfo.getRelationorderid() != null
				&& orderinfo.getRelationorderid() > 0) {
			/*orderinfo2 = this
					.findBySql(
							Orderinfo.class,
							"SELECT ID id,C_ORDERSTATUS orderstatus,C_ORDERNUMBER ordernumber, ISNULL(C_TOTALTICKETPRICE,0) totalticketprice,REBAT fenxiaoshangfandian,"
									+ "ISNULL(C_TOTALAIRPORTFEE,0) totalairportfee,ISNULL(C_TOTALFUELFEE,0) totalfuelfee,"
									+ "C_PNR pnr,C_BIGPNR bigpnr,ISNULL(C_CURRPLATFEE,0) currplatfee,ISNULL(INSURANCEPRICE,0) as totalinsurprice"
									+ " FROM view_orderinfo WHERE ID="
									+ orderinfo.getRelationorderid());*/
			orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
			listPassenger2 = Server.getInstance().getAirService()
					.findAllPassenger(
							"where 1=1 and " + Passenger.COL_orderid + " ="
									+ orderinfo2.getId(), "", -1, 0);

			listSegment2 = Server.getInstance().getAirService()
					.findAllSegmentinfo(
							"where 1=1 and " + Segmentinfo.COL_orderid + " ="
									+ orderinfo2.getId(), "", -1, 0);
			float totalinsruprice = 0f;
			for (Passenger passenger : listPassenger2) {
				totalinsruprice += passenger.getInsurprice();
			}

			orderinfo2.setTotalinsurprice(totalinsruprice);
			orderinfo2.setOrderprice(orderinfo2.getTotalticketprice()
					+ orderinfo2.getTotalinsurprice()
					+ orderinfo2.getTotalfuelfee()
					+ orderinfo2.getTotalairportfee()+orderinfo2.getRebatemoney()); //
			totalprice += orderinfo2.getOrderprice();

		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("billname", "Airpayhelper");// 对应接口中 支付辅助类 必传
		map.put("orderid", orderinfo.getId());// 订单id 必传
		if (ServletActionContext.getServletContext().getAttribute(
				"vmoneyservice") != null) {// 判断是否有虚拟账户业务
			map.put("actionname", "b2bticketorder!vmoneyAirticketpay.action");

			boolean vpay = true;
			float vmoney = new CustomeragentServiceImpl().getTotalVmoney(this
					.getLoginUser().getAgentid());
			if (totalprice > vmoney) {
				vpay = false;
			}
			map.put("vmoney", vmoney);
			map.put("vmpayenable", vpay);// 如果可虚拟账户支付 传入当前账户余额
		}
		map.put("orderprice", totalprice
				+ converNull(orderinfo.getCurrplatfee(), 0f));
		request.setAttribute("ordermap", map);// 传值....
		return "ticketorderinfo2";
	}

	
	public void topay() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String urlstr = "http://" + request.getServerName() + ":"
				+ request.getServerPort()
				+ "/interface/Alipay?helpername=Airpayhelper&orderid="
				+ orderinfo.getId();
		try {
			response.sendRedirect(urlstr);
		} catch (IOException e) {
			System.out.println("支付跳转出错：");
			e.printStackTrace();
		}
	}
	

	/**
	 * 调用短信接口发送短信
	 * 
	 * @param mobiles
	 *            手机号码组
	 * @param content
	 *            短信内容
	 * @param ordercode
	 *            订单号 可选
	 * @return
	 */
	public int smsSend(String[] mobiles, String content, String ordercode) {
		return Server.getInstance().getAtomService().sendSms(mobiles, content,
				ordercode, "");
	}

	public List<Department> getSaleroomlist() {
		String salewhere = " WHERE C_TYPE=1  ";
		salesroolist = Server.getInstance().getMemberService()
				.findAllDepartment(salewhere, "", -1, 0);
		return salesroolist;

	}

	/**
	 * 扣除虚拟money
	 * 
	 * @throws SQLException
	 */
	private void abatemembervmoney(Orderinfo orderinfo) throws SQLException {

		// 保存虚拟账户支付记录
		Vmoneyrecord vmrecord = new Vmoneyrecord();
		vmrecord.setAgentid(orderinfo.getBuyagentid());
		vmrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
		vmrecord.setCreateuserid(getLoginUserId());
		vmrecord.setMoney(0 - this.getOrdertotalprice(orderinfo));
		vmrecord.setOrdernumber(orderinfo.getOrdernumber());
		vmrecord.setType("1");
		vmrecord.setMemo("机票订单虚拟账户金额扣除(金额：" + vmrecord.getMoney() + ")");
		Server.getInstance().getMemberService().createVmoneyrecord(vmrecord);

	}

	// public String searchair() {
	// float allmoney = 0;
	//
	// listPassenger = Server.getInstance().getAirService().findAllPassenger(
	// "where 1=1 and " + Passenger.COL_orderid + " ="
	// + orderinfo.getId(), "", -1, 0);
	// orderinfo = Server.getInstance().getAirService().findOrderinfo(
	// orderinfo.getId());
	//
	// orderinfo.setTotalticketprice(orderinfo.getTotalticketprice());
	//
	// orderinfo.setOrderprice(this.getOrdertotalprice(orderinfo));
	// allmoney += orderinfo.getOrderprice();
	// allmoney+=orderinfo.getCurrplatfee();
	//
	// listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
	// "where 1=1 and " + Segmentinfo.COL_orderid + " ="
	// + orderinfo.getId(), "", -1, 0);
	// if (idtemp != orderinfo.getId()) {
	// listPassenger2 = Server.getInstance().getAirService()
	// .findAllPassenger(
	// "where 1=1 and " + Passenger.COL_orderid + " ="
	// + idtemp, "", -1, 0);
	// orderinfo2 = Server.getInstance().getAirService().findOrderinfo(
	// idtemp);
	// orderinfo2.setOrderprice(this.getOrdertotalprice(orderinfo2));
	// listSegment2 = Server.getInstance().getAirService()
	// .findAllSegmentinfo(
	// "where 1=1 and " + Segmentinfo.COL_orderid + " ="
	// + idtemp, "", -1, 0);
	// allmoney += orderinfo2.getOrderprice();
	// }
	//
	// orderSafePrice = 0f;
	// // orderSafePrice=getIssurByOrderid(orderinfo.getId());
	// orderSafePrice = getINSURMONEYPrice(orderinfo.getId());
	//
	// if (idtemp != orderinfo.getId()) {
	// orderSafePrice += getINSURMONEYPrice(idtemp);
	// }
	//
	// // 添加平台费
	// orderinfo.setOrderprice(orderinfo.getOrderprice() + this.orderPlat);
	//
	// HttpServletRequest request = ServletActionContext.getRequest();
	// Map ordermap = new HashMap();
	// ordermap.put("billname", "airorderbill");
	// ordermap.put("orderid", orderinfo.getId());
	// ordermap.put("actionname", "b2bticketorder!vmoneyAirticketpay.action");
	// ordermap.put("rechnumber", "");
	// ordermap.put("ordernumber", orderinfo.getOrdernumber());
	// ordermap.put("orderprice", allmoney);
	// ordermap.put("ordername", "");
	// request.setAttribute("payresulturl", request.getContextPath()
	// + "/b2bticketorder.action?s_orderid=" + orderinfo.getId());
	// request.setAttribute("ordermap", ordermap);
	//
	// return "ticketorderinfo";
	// }

	public float getOrdertotalprice(Orderinfo orderinfo) {
		float money = orderinfo.getTotalticketprice()
				+ converNull(orderinfo.getTotalairportfee(), 0f)
				+ converNull(orderinfo.getTotalfuelfee(), 0f)
				+ converNull(orderinfo.getPostmoney(), 0);

		// String sql = "SELECT ISNULL(SUM(C_INSURANCEFEE),0) AS INSURMONEY FROM
		// T_INSURANCEINFO WHERE ID IN (SELECT C_INSURANCE FROM T_PASSENGER
		// WHERE C_ORDERID ="
		// + orderinfo.getId() + ")";
		// List list =
		// Server.getInstance().getSystemService().findMapResultBySql(
		// sql, null);
		// if (list.size() > 0) {
		// Map map = (Map) list.get(0);
		// String imoney = map.get("INSURMONEY").toString();
		// money += Float.valueOf(imoney);
		// }
		return money + this.getINSURMONEYPrice(orderinfo.getId());
	}

	/**
	 * 机票订单虚拟账户支付。
	 * 
	 * @return
	 */
	public String vmoneyAirticketpay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int paystate = 1;// 成功
		String message = "订单支付成功!";
		String orderid = ServletActionContext.getRequest().getParameter(
				"orderid");
		float pricesum1 = 0f;
		float pricesum2 = 0f;
		try {
			Orderinfo orderinfo = Server.getInstance().getAirService()
					.findOrderinfo(Long.valueOf(orderid));
			if (orderinfo.getPaystatus() == 1) {
				return "paysuccess";
			}
			Orderinfo orderinfo2 = null;
			if (orderinfo != null) {
				pricesum1 = this.getOrdertotalprice(orderinfo);
				if (orderinfo.getRelationorderid() != null) {
					orderinfo2 = Server.getInstance().getAirService()
							.findOrderinfo(orderinfo.getRelationorderid());
					pricesum2 = getOrdertotalprice(orderinfo2);
				}
			}
			float vmoney = new CustomeragentServiceImpl()
					.getTotalVmoney(orderinfo.getBuyagentid());
			if (pricesum1 + pricesum2 > vmoney) {
				paystate = 2;// 失败
				message = "订单支付失败！原因：当前账户余额不足与订单支付！";
			} else {
				orderinfo.setPaystatus(1); // 已支付
				// 虚拟账户支付，已支付，等待出票
				orderinfo.setOrderstatus(2);
				orderinfo.setPaymethod(4);
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
						orderinfo);
				long buyagentid = orderinfo.getBuyagentid();
				if (pricesum1 == 0) {
					throw new Exception();
				}
				this.createRebateRecord(orderinfo.getOrdernumber(),
						0 - pricesum1, 1, buyagentid, buyagentid, 2, null);
				if (orderinfo2 != null) {
					orderinfo2.setPaystatus(1); // 已支付
					// 虚拟账户支付，已支付，等待出票
					orderinfo2.setOrderstatus(2);
					orderinfo2.setPaymethod(4);
					if (pricesum2 == 0) {
						throw new Exception();
					}
					this.createRebateRecord(orderinfo2.getOrdernumber(),
							0 - pricesum2, 1, buyagentid, buyagentid, 2, null);
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfo2);
				}

			}
		} catch (Exception e) {

			paystate = 2;// 失败
			message = "订单支付失败！原因：网络连接失败！";
			e.printStackTrace();
		}
		request.setAttribute("paystate", paystate);
		request.setAttribute("message", message);
		System.out.println("air/airpaysuccess.jsp");
		return "paysuccess";
	}

	public String searchairf() {

		return "ticketorderinfof";
	}

	/**
	 * ajax 获取外部订单状态。
	 */
	public void ajaxOutstats() {
		// HttpServletRequest request=ServletActionContext.getRequest();
		// String outordernumber=request.getParameter("outordernumber");
		// String agentid=request.getParameter("policyagentid");
		// // a|b（乘机人）@111|222（票号）@8000（价格）@出票（状态）
		// String
		// info=Server.getInstance().getRateService().FindOutOrderInfoByOrderNo(outordernumber,
		// agentid);
		// if(info.equals("-1")){
		// String[] infos=info.split("@");
		// }
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
	 * @param limit
	 * @param orderstate
	 * @return 判断是否有订单修改权限
	 */
	public boolean haveOrderOperatelimit(String limit, int orderstate) {
		if (this.checkright(limit)) {
			String roles = this.getLoginUserRoleNumber().toString().replace(
					'[', ' ').replace(']', ' ');
			String sql = "SELECT * FROM T_ORDERSTATELIMIT WHERE C_ROLEID IN ("
					+ roles
					+ ") AND C_ORDERSTATE="
					+ orderstate
					+ " AND C_LIMITID=(SELECT ID FROM T_SYSTEMRIGHT WHERE C_CODE='"
					+ limit + "')";
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			if (list.size() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 编辑订单信息表
	 */
	public String edit() throws Exception {	
		
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Passenger> listpassengers = Server.getInstance().getAirService()
				.findAllPassenger(
						" WHERE C_ORDERID=" + orderinfo.getId()
								+ " AND C_STATE<>12", "", -1, 0);
		float allprice = 0f;
		float allfuelprice = 0f;
		float allairprice = 0f;
		float allanjianfee = 0f;
		float allotherfee = 0f;
		float allinsurprice = 0f;
		String tfdesc = request.getParameter("tfmemo");
		try {
			for (Passenger pasger : listpassengers) {

				long id = pasger.getId();
				if (request.getParameter(id + "price") != null) {
					float price = Float.valueOf(converTrim(request
							.getParameter(id + "price"), "0"));
					float fuelprice = Float.valueOf(converTrim(request
							.getParameter(id + "fuelprice"), "0"));
					float airportfee = Float.valueOf(converTrim(request
							.getParameter(id + "airportfee"), "0"));
					float anjianfee = Float.valueOf(converTrim(request
							.getParameter(id + "anjianfee"), "0"));
					float otherfee = Float.valueOf(converTrim(request
							.getParameter(id + "otherfee"), "0"));
					float tuifee = Float.valueOf(converTrim(request
							.getParameter(id + "tuifee"), "0"));
					float customerpay = Float.valueOf(converTrim(request
							.getParameter(id + "customerpay"), "0"));
					float insurprice = Float.valueOf(converTrim(request
							.getParameter(id + "insurprice"), "0"));
					String pastate=converTrim(request
							.getParameter(id + "state"), "0");
					
					allprice += price;
					allfuelprice += fuelprice;
					allairprice += airportfee;
					allanjianfee += anjianfee;
					allotherfee += otherfee;
					allinsurprice += insurprice;
					if (isNotNullOrEpt(tfdesc)) {
						pasger.setTuifeidesc(tfdesc);
					}
					pasger.setPrice(price);
					pasger.setAirportfee(airportfee);
					pasger.setFuelprice(fuelprice);
					//pasger.setAnjianfee(anjianfee);
					pasger.setOtherfee(otherfee);
					pasger.setTuifee(tuifee);
					
					pasger.setState(Integer.parseInt(pastate));
					
					// 将修改的保险添加到数据库
					pasger.setInsurprice(insurprice);
					System.out.println(orderinfo.getBackpointinfo());
					if (orderinfo.getBackpointinfo() != null) {
						String point = orderinfo.getBackpointinfo();
						int indexs = point.lastIndexOf("|");
						String beginstr = point.substring(0, indexs + 1);
						String backpoint = point.substring(indexs + 1);
						backpoint = allinsurprice + "";
						System.out.println(beginstr + backpoint);
						orderinfo.setBackpointinfo(beginstr + backpoint);
					}
					orderinfo.setTotalticketprice(allprice);
					orderinfo.setTotalairportfee(allairprice);
					orderinfo.setTotalfuelfee(allfuelprice);
					//orderinfo.setTotalanjian(allanjianfee);
					orderinfo.setTotalotherfee(allotherfee);
				}
				String ticketnum = request.getParameter(id + "ticketnumber");
				pasger.setTicketnum(ticketnum);
				String strname = request.getParameter(id + "name");
				pasger.setName(strname);
				String phone = request.getParameter(id + "mobile");
				pasger.setMobile(phone);
				String idnumber = request.getParameter(id + "idnumber");
				pasger.setIdnumber(idnumber);
				if (s_tickettypeid > 0) {
					pasger.setTickettypeid(s_tickettypeid);
				}
				
				Server.getInstance().getAirService().updatePassengerIgnoreNull(
						pasger);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if(zratememo!=null&&zratememo.trim().length()>0){
			List<Segmentinfo> listsegment2 = Server.getInstance()
			.getAirService().findAllSegmentinfo(
					" WHERE C_ORDERID=" + orderinfo.getId(), "", -1, 0);
			
			Segmentinfo segment=listsegment2.get(0);
			segment.setRules(zratememo);
			Server.getInstance().getAirService()
			.updateSegmentinfoIgnoreNull(segment);
		}
		
		// int olestate =
		// Integer.valueOf(request.getParameter("orderoldstate"));
		// if(haveOrderOperatelimit("updsegmentinfo", olestate)){ //元
		if (true) {
			List<Segmentinfo> listsegment = Server.getInstance()
					.getAirService().findAllSegmentinfo(
							" WHERE C_ORDERID=" + orderinfo.getId(), "", -1, 0);
			for (Segmentinfo segment : listsegment) {
				long id = segment.getId();
				String flightnumber = request.getParameter(id + "flightnumber");
				String cabincode = request.getParameter(id + "cabincode");
				String departtime = request.getParameter(id + "departtime");
				String arrivaltime = request.getParameter(id + "arrivaltime");
				String yprice = request.getParameter(id + "yprice");
				String discount = request.getParameter(id + "discount");
				segment.setFlightnumber(flightnumber);
				segment.setCabincode(cabincode);
				//segment.setYprice(Float.valueOf(converNull(yprice, "0")));
				segment.setDiscount(Float.valueOf(converNull(discount, "0")));
				if (isNotNullOrEpt(departtime)) {
					segment.setDeparttime(super.dateToTimestamp(departtime));
				}
				if (isNotNullOrEpt(arrivaltime)) {
					segment.setArrivaltime(super.dateToTimestamp(arrivaltime));
				}
				Server.getInstance().getAirService()
						.updateSegmentinfoIgnoreNull(segment);
			}

		}
		// if (orderinfo.getOrderstatus() != null) {
		// if (olestate != orderinfo.getOrderstatus()) {
		// this.synchPassengertoOrder(orderinfo);
		// }
		// }
		// if (orderinfo.getPaystatus() == 0) {
		// orderinfo.setOrderstatus(1);
		// }
		// if (orderinfo.getPaystatus() == 1) {
		// orderinfo.setOrderstatus(2);
		// }
		//orderinfo.setOrderstatus(null);
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		if(orderinfo.getExtorderstatus()!=null&&orderinfo.getExtorderstatus()==3){
			Orderinfo order=Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());
			PolicyNotifySupport.outTciket(order);
		}

		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(-1);
		orderinforc.setContent("订单修改-" + getLoginUser().getMembername()
				+ "修改了订单");
		orderinforc.setCustomeruserid(getLoginUserId());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
		if(fancaiinfo!=null&&fancaiinfo.trim().length()>0){
			Orderinforc orderinforc2 = new Orderinforc();
			orderinforc2.setCustomeruserid(getLoginUserId());
			orderinforc2.setOrderinfoid(orderinfo.getId());
			orderinforc2.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc2.setSuouserid(orderinfo.getUserid());
			//orderinforc2.setState(-1);
			orderinforc2.setContent("返采备注:" +fancaiinfo );
			orderinforc2.setCustomeruserid(getLoginUserId());
			Server.getInstance().getAirService().createOrderinforc(orderinforc2);
		}
		
		
		forward = ServletActionContext.getRequest().getHeader("Referer");

		// //////
		return "editorderinfo";
	}

	// 取得是否是升舱补差订单标识
	public long getisshengcang(long id) {
		long lisshengcang = 0;
		try {
			Orderinfo temporder = Server.getInstance().getAirService()
					.findOrderinfo(orderinfo.getId());
			if (temporder.getIsshengcang() == 1) {
				lisshengcang = 1l;
			} else {
				lisshengcang = 0l;
			}
		} catch (Exception ex) {

		}
		return lisshengcang;
	}

	// 取得升舱补差前票号
	public String getshengcangtn(long id) {
		String strshengcangoldtn = "";
		Orderinfo temporder = Server.getInstance().getAirService()
				.findOrderinfo(orderinfo.getId());
		if (!temporder.getShengcangoldtn().equals("")) {
			strshengcangoldtn = temporder.getShengcangoldtn();
		}

		return strshengcangoldtn;
	}

	// 取得改签舱位
	public String getgaiqiancabin(long id) {
		String strcabincode = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strcabincode = tempass.get(0).getChangecabin();
		}

		return strcabincode;
	}

	// 取得改签日期
	public String getgaiqiandate(long id) {
		String strdate = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strdate = tempass.get(0).getChangedate();
		}

		return strdate;
	}
	// 取得改签日期降落时间
	public String getgaiqiandate2(long id) {
		String strdate = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strdate = formatTimestampyyyyMMddHHmm(tempass.get(0).getTuitime());
		}

		return strdate;
	}
	// 取得改签航班号
	public String getgaiqianfnumber(long id) {
		String strnumber = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strnumber = tempass.get(0).getChangeflight();
		}

		return strnumber;
	}

	public Segmentinfo getxingchenginfo(long id) {
		Segmentinfo segment = new Segmentinfo();
		List<Segmentinfo> listsegmenginfo = Server.getInstance()
				.getAirService().findAllSegmentinfo(
						"where " + Segmentinfo.COL_orderid + "=" + id, "", -1,
						0);
		if (listsegmenginfo.size() > 0) {
			segment = listsegmenginfo.get(0);
		}
		return segment;
	}

	private List<Passenger> getPassengerListByOrderiId(long orderid) {
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"where " + Passenger.COL_orderid + "="
								+ orderinfo.getId() + " AND C_STATE<>12", "",
						-1, 0);
		return listpassenger;
	}

	/**
	 * 同步订单和乘机人状态。
	 */
	public void synchPassengertoOrder(Orderinfo orderinfo) {
		Map<Integer, Integer> statetostate = new HashMap<Integer, Integer>();
		statetostate.put(2, 0);
		statetostate.put(3, 1);
		statetostate.put(4, 4);
		statetostate.put(5, 5);
		statetostate.put(6, 11);
		statetostate.put(7, 8);
		statetostate.put(9, 16);
		statetostate.put(10, 1);
		statetostate.put(11, 2);
		statetostate.put(12, 3);
		statetostate.put(13, 6);
		statetostate.put(14, 9);
		statetostate.put(15, 10);
		statetostate.put(16, 0);
		statetostate.put(17, 7);
		statetostate.put(18, 17);
		statetostate.put(13, 13);
		statetostate.put(24, 14);
		statetostate.put(25, 14);
		statetostate.put(26, 15);
		statetostate.put(27, 0);
		statetostate.put(28, 1);
		statetostate.put(29, 1);
		statetostate.put(30, 13);

		int orderstate = converNull(orderinfo.getOrderstatus(), 0);
		if (statetostate.get(orderstate) != null) {
			String sql = "UPDATE T_PASSENGER SET C_STATE="
					+ statetostate.get(orderstate) + " WHERE C_ORDERID="
					+ orderinfo.getId() + " AND C_STATE<>12";
			Server.getInstance().getSystemService().findMapResultBySql(sql,
					null);
		}

	}

	/**
	 * @param mobile
	 * @return 判断是否 定制 且未取消定制短信。
	 */
	public boolean isOrdersmsAndnoremove(String mobile) {

		String where = " WHERE C_PHONE='" + mobile
				+ "' AND C_TYPE=1 AND C_STATE IN (0,2)";
		List<Ymsend> listymsends = Server.getInstance().getMemberService()
				.findAllYmsend(where, "", -1, 0);
		if (listymsends == null || listymsends.size() == 0) {
			return false;
		} else {
			for (Ymsend ymsend : listymsends) {
				if (ymsend.getState() == 2l) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 给订单那联系人发送退废短信
	 * 
	 * @param passengers
	 */
	public void sendTFMsgtoLinkUser(List<Passenger> passengers) {
		// 您好，您购买的：孙国城320113196310281215等3人，南京-北京，以及其他航段，票号781-2377458901等3张，
		// 总票价8080+2920，废/退票费800，退款金额9340，该电子客票已废/退票。如有疑问请与江苏东航售票处联系，电话：4001-968968

		Passenger passenger = passengers.get(0);
		String statestr = passenger.getState() == 2 ? "废" : "退";
		String where = " WHERE C_ORDERID=" + passenger.getOrderid();
		List<Segmentinfo> listseg = Server.getInstance().getAirService()
				.findAllSegmentinfo(where, "", -1, 0);
		String segmentstr = this.getCitynameByAirport(listseg.get(0)
				.getStartairport())
				+ "-" + getCitynameByAirport(listseg.get(0).getEndairport());
		if (listseg.size() > 1) {
			segmentstr += "，以及其他航段";
		}
		String passengername = passenger.getName() + ""
				+ passenger.getIdnumber();
		if (passengers.size() > 0) {
			passengername += "等" + passengers.size() + "人";
		}
		float allticketprice = 0f;
		float duty = 0f;
		for (Passenger p : passengers) {
			allticketprice += converNull(p.getPrice(), 0f);
			duty += converNull(p.getFuelprice(), 0f)
					+ converNull(p.getAirportfee(), 0f)
					+ converNull(p.getAnjianfee(), 0f)
					+ converNull(p.getOtherfee(), 0f);
		}

		String msg = "您好，您购买的："
				+ passengername
				+ "，"
				+ segmentstr
				+ "，"
				+ "票号"
				+ converNull(passenger.getTicketnum(), "")
				+ "，总票价"
				+ allticketprice
				+ "+"
				+ duty
				+ "，"
				+ statestr
				+ "票费"
				+ passenger.getTuifee()
				+ "(每人)，退款金额"
				+ (converNull(passenger.getPrice(), 0f) + duty - converNull(
						passenger.getTuifee(), 0f)) + "，" + "该电子客票已" + statestr
				+ "票。如有疑问请与售票处联系!";
		Server.getInstance().getAtomService().sendSms(
				new String[] { converNull(passenger.getMobile(), "").trim() },
				msg, String.valueOf(passenger.getOrderid()), null);

	}

	/**
	 * 给乘机人发送退废短信
	 * 
	 * @param passenger
	 */
	public void sendTFMsgtoPassenger(Passenger passenger) {
		// 您好，您购买的：孙国城320113196310281215，南京-北京，以及其他航段，
		// 票号781-2377458901，总票价8080+2920，废/退票费800，退款金额9340，
		// 该电子客票已废/退票。如有疑问请与江苏东航售票处联系，电话：4001-968968
		String where = " WHERE C_ORDERID=" + passenger.getOrderid();
		List<Segmentinfo> listseg = Server.getInstance().getAirService()
				.findAllSegmentinfo(where, "", -1, 0);
		String segmentstr = this.getCitynameByAirport(listseg.get(0)
				.getStartairport())
				+ "-" + getCitynameByAirport(listseg.get(0).getEndairport());
		if (listseg.size() > 1) {
			segmentstr += "，以及其他航段";
		}
		String statestr = passenger.getState() == 2 ? "废" : "退";
		float duty = converNull(passenger.getFuelprice(), 0f)
				+ converNull(passenger.getAirportfee(), 0f)
				+ converNull(passenger.getAnjianfee(), 0f)
				+ converNull(passenger.getOtherfee(), 0f);
		String msg = "您好，您购买的："
				+ passenger.getName()
				+ ""
				+ passenger.getIdnumber()
				+ "，"
				+ segmentstr
				+ "，"
				+ "票号"
				+ converNull(passenger.getTicketnum(), "")
				+ "，总票价"
				+ passenger.getPrice()
				+ "+"
				+ duty
				+ "，"
				+ statestr
				+ "票费"
				+ passenger.getTuifee()
				+ "，退款金额"
				+ (converNull(passenger.getPrice(), 0f) + duty - converNull(
						passenger.getTuifee(), 0f)) + "，" + "该电子客票已" + statestr
				+ "票。如有疑问请与售票处联系!";
		Server.getInstance().getAtomService().sendSms(
				new String[] { converNull(passenger.getMobile(), "").trim() },
				msg, String.valueOf(passenger.getOrderid()), null);

	}

	public String seachstate() {// 供应商查询订单状态
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.valueOf(strTuiOrderID));
		if (orderinfo.getGyssuotime() == null) {// 新订单啊
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("kong");
			/*
			 * if(orderinfo.getOperatingstate()==null){
			 * 
			 * orderinfo.setOperatingstate(0l); }
			 * 
			 * try { if(orderinfo.getOperatingstate()==1 &&
			 * orderinfo.getUserid()!=getLoginUserId()){
			 * 
			 * out = response.getWriter(); out.print("suo"); }else
			 * if(orderinfo.getUserid()==null){ out = response.getWriter();
			 * out.print("kong");
			 * 
			 * }else{ if(orderinfo.getUserid()==getLoginUserId()){ out =
			 * response.getWriter(); out.print("my"); }else{ out =
			 * response.getWriter(); out.print("she,"+orderinfo.getUserid()); } } }
			 * catch (IOException e) { e.printStackTrace(); }
			 */
			out.flush();
			out.close();
		} else {

			if (new Timestamp(System.currentTimeMillis()).getTime()
					- orderinfo.getGyssuotime().getTime() > 30 * 1000 * 60) {// 超过了30分钟
				// orderinfo.setGyssuotime(null);
				orderinfo.setOperatingstate(0l);
				// orderinfo.setUserid(null);
				Server.getInstance().getAirService().updateOrderinfo(orderinfo);
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.print("kong");
				out.flush();
				out.close();

			} else {// 还没超过30分钟

				if (orderinfo.getOperatingstate() == null) {

					orderinfo.setOperatingstate(0l);
				}

				try {
					if (orderinfo.getOperatingstate() == 1
							&& orderinfo.getUserid() != getLoginUserId()
							&& orderinfo.getUserid() != 0) {

						out = response.getWriter();
						out.print("suo");
					} else if (orderinfo.getUserid() == null) {
						out = response.getWriter();
						out.print("kong");

					} else {
						if (orderinfo.getUserid() == getLoginUserId()) {
							out = response.getWriter();
							out.print("my");
						} else if (orderinfo.getUserid() != 0) {
							out = response.getWriter();
							out.print("she," + orderinfo.getUserid());
						} else {
							out = response.getWriter();
							out.print("my");
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.flush();
				out.close();
			}

		}
		return SUCCESS;
	}

	/**
	 * 根据订单id获得订单中所包含的票的票号
	 * 
	 * @param orderid
	 * @return
	 */
	public String getTicketnumByOrderid(long orderid) {
		String ticketnum = "";
		String where = " WHERE C_ORDERID=" + orderid + " AND "
				+ Passenger.COL_state + "<>12";
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		for (Passenger passenger : passengers) {
			if (ticketnum.length() > 0) {
				ticketnum += "<br/>" + passenger.getTicketnum();

			} else {
				ticketnum += passenger.getTicketnum();
			}
		}
		return ticketnum;

	}

	public static Map<Integer, String> getPayMethodMap() {
		return paymethodmap;
	}

	public static String getPayMethodStr(int paymethod) {
		try {
			return paymethodmap.get(paymethod);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 检测是否已经过了废票时间，出票当日24点之后不能进行废票 Created by sunbin
	 */
	public boolean checkFeiPiaoValite(Timestamp tmrttime) {
		// 取得当前时间
		Timestamp tmnowtime = new Timestamp(System.currentTimeMillis());
		String strDateChupiao = formatTimestamp2(tmrttime);
		Timestamp tmRTTime = dateToTimestamp(strDateChupiao + " 17:00:00");
		Timestamp tmNowTime = dateToTimestamp(tmnowtime.toString());
		if ((tmNowTime.getTime() - tmRTTime.getTime()) > 0) {
			return false;
		}
		return true;
	}

	/**
	 * @param orderid
	 * @param mobile
	 * @return是否已定制
	 */
	public boolean haveOrderMoveOrSendMsg(Long orderid, String mobile, int type) {
		if (isNotNullOrEpt(mobile)) {
			String where = " WHERE C_PHONE='" + mobile + "' AND C_TYPE=" + type
					+ " AND C_STATE=0 AND C_ORDERCODE='" + orderid + "'";
			List<Ymsend> listYmesends = Server.getInstance().getMemberService()
					.findAllYmsend(where, "", -1, 0);
			if (listYmesends.size() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void ajaxPickupTicktnumber() throws IOException {
		//		
		// 如果是小PNR用这个方法Server.getInstance()
		// .getTicketSearchService().commandFunction2(
		// "RT" + strPNR.trim() + "$PN$PN$PAT:A", "",
		// "")
		// 无脸男 15:23:31
		// 如果是大PNR用Server.getInstance().getTicketSearchService()
		// .getPNRInfo(strPNR.trim());

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		int count = Integer.valueOf(request.getParameter("count"));
		String bpnr = null;
		String lpnr = request.getParameter("lpnr");
		String strPNRINfo = "";

		if (isNotNullOrEpt(lpnr)) {
			strPNRINfo = Server.getInstance().getTicketSearchService()
					.commandFunction2("RT" + lpnr.trim() + "$PN$PN$PAT:A", "",
							"");
		} else if (isNotNullOrEpt(bpnr)) {
			strPNRINfo = Server.getInstance().getTicketSearchService()
					.getPNRInfo(bpnr.trim());
		}

		StringBuilder ticketnum = new StringBuilder("");
		for (int i = 1; i <= count; i++) {
			String pticketnum = Server.getInstance().getTicketSearchService()
					.getTicketNumber(strPNRINfo, "P" + i);
			if (pticketnum.length() > 0) {
				if (ticketnum.length() > 0) {
					ticketnum.append("|");
				}
				ticketnum.append(pticketnum);

			}
		}
		PrintWriter out = response.getWriter();
		out.print(ticketnum);
		out.flush();
		out.close();
	}

	/**
	 * 判断是否可支付 已废弃，可删除
	 * 
	 * @throws IOException
	 */
	public void ajaxInpaytime() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("orderid");
		String pretstr = "";
		long orderid = Long.valueOf(orderidstr);
		Segmentinfo segment = this.getSegmentinfo(orderid);
		Timestamp ctime = this.getCurrentTime();
		ctime.setHours(ctime.getHours() + 2);
		if (ctime.after(segment.getDeparttime())) {
			pretstr = "航班起飞前2小时内不可支付！";
		}
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();

	}

	public void suodan(){
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			String orderidstr = request.getParameter("strTuiOrderID");
			String pretstr="";
			Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
			
			
			
			if(orderinfo.getUserid()==null||orderinfo.getUserid()==0||orderinfo.getUserid()==-1){
				pretstr="锁单成功!";
				orderinfo.setUserid(getLoginUser().getId());
				orderinfo.setFxssuotime(new Timestamp(System.currentTimeMillis()));
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
			}else{
				if(orderinfo.getUserid()!=getLoginUser().getId()){
					pretstr="锁单失败!当前订单已被["+getusername(orderinfo.getUserid())+"]锁定!";
					
				}else{
					pretstr="锁单成功!";
					
				}
				
			}
			
			
			PrintWriter out = response.getWriter();
			System.out.println(pretstr);
			out.print(pretstr);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
public void ajaxValadateSuoDan(){
		
		try {
			
			if(getLoginAgent().getAgenttype()==1||getLoginAgent().getAgenttype()==2){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			String orderidstr = request.getParameter("strTuiOrderID");
			String pretstr="";
			Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
			if(orderinfo.getUserid()==null||orderinfo.getUserid()==0||orderinfo.getUserid()==-1){
				pretstr="";
				orderinfo.setUserid(getLoginUser().getId());
				orderinfo.setFxssuotime(new Timestamp(System.currentTimeMillis()));
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
			}else{
				if(orderinfo.getUserid()!=getLoginUser().getId()){
					pretstr="操作失败!当前订单已被["+getusername(orderinfo.getUserid())+"]锁定!";
					
				}else{
					
					pretstr="";
				}
				
			}
			
			
			PrintWriter out = response.getWriter();
			System.out.println(pretstr);
			out.print(pretstr);
			out.flush();
			out.close();
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	/**
	 * 异步判断当前订单是否已锁定
	 * 
	 * @throws IOException
	 */
	public void ajaxIsoperateing() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("orderid");
		String orderstate = request.getParameter("orderstate");
		String pretstr = "";
		int orderstatus = Integer.valueOf(orderstate);
		Orderinfo orderinfo = this
				.findBySql(
						Orderinfo.class,
						"SELECT C_ORDERSTATUS orderstatus,C_USERID userid,C_OPERATINGSTATE operatingstate FROM T_ORDERINFO WHERE ID="
								+ orderidstr);

		if (converNull(orderinfo.getUserid(), 0l) > 0) {
			int state = Integer.valueOf(String.valueOf(orderinfo
					.getOperatingstate()));
			pretstr = "当前订单正在做 " + this.getStateToString(state)
					+ "，请刷新页面或稍后再试！";
		} else if (orderinfo.getOrderstatus() != orderstatus) {
			pretstr = "订单已" + this.getStateToString(orderinfo.getOrderstatus())
					+ "，请刷新当前页面！";
		}
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
	}

	/**
	 * 删除订单信息表
	 */
	public String delete() throws Exception {
		
		if(getLoginAgent().getAgenttype()==1){
			Server.getInstance().getAirService().excutePassengerBySql(" DELETE "+Passenger.TABLE+" where "+Passenger.COL_orderid+" ="+orderinfo.getId());
			Server.getInstance().getAirService().excuteSegmentinfoBySql(" DELETE "+Segmentinfo.TABLE+" where "+Segmentinfo.COL_orderid+" ="+orderinfo.getId());
			Server.getInstance().getAirService().excuteOrderinforcBySql(" DELETE "+Orderinforc.TABLE+" where "+Orderinforc.COL_orderinfoid+" ="+orderinfo.getId());
			String ordercode="A"+(10000+orderinfo.getId());
			Server.getInstance().getMemberService().excuteTraderecordBySql(" DELETE "+Traderecord.TABLE+" where "+Traderecord.COL_ordercode+" ='"+ordercode+"'");
			Server.getInstance().getAirService().deleteOrderinfo(orderinfo.getId());
			
		}
		
		
		return this.execute();
	}

	public String payinfo() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				s_orderid);
		return "payinfo";
	}

	/**
	 * 订单状态修改==分销商
	 */
	public String orderstatusedit() throws Exception {
		/*
		 * if(orderinfo.getOrderstatus()==3) {
		 * 
		 * 
		 * orderinfo.setPrinttime(new Timestamp(System.currentTimeMillis()));
		 * orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());
		 * String smstemple=""; List<Segmentinfo>
		 * list=Server.getInstance().getAirService().findAllSegmentinfo(" where
		 * "+Segmentinfo.COL_orderid+" = "+orderinfo.getId(), "", -1, 0);
		 * Segmentinfo segment=null; if(list!=null&&list.size()>0) {
		 * segment=list.get(0); } if(segment!=null) {
		 * smstemple=this.getSMSTemple("AOrderInform");
		 * smstemple=smstemple.replaceAll("@aircompanyto@",
		 * this.getAircomapnycodeByEZM(segment.getAircomapnycode()));
		 * smstemple=smstemple.replaceAll("@airlineto@",
		 * segment.getFlightnumber());
		 * smstemple=smstemple.replaceAll("@startcityto@",
		 * getAirportbySZM(segment.getStartairport()));
		 * smstemple=smstemple.replaceAll("@endcityto@",
		 * getAirportbySZM(segment.getEndairport()));
		 * smstemple=smstemple.replaceAll("@startcityloginto@",segment.getBorderpointat());
		 * smstemple=smstemple.replaceAll("@starttimeto@",
		 * formatTimestamp2(segment.getDeparttime())+"
		 * "+formatTimestamp3(segment.getDeparttime()));
		 * smstemple=smstemple.replaceAll("@endtimeto@",
		 * formatTimestamp3(segment.getArrivaltime())); }
		 * System.out.println(smstemple); this.smsSend(new
		 * String[]{""+orderinfo.getContactmobile()+""}, smstemple,
		 * orderinfo.getOrdernumber()+orderinfo2.getOrdernumber()); }
		 */
		if (orderinfo.getOrderstatus() == 2) {

			orderinfo.setPaystatus(1);
		}
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		// 获取前一页面路径
		forward = ServletActionContext.getRequest().getHeader("Referer");
		return LIST;
	}

	// 得到配送信息
	public void getPeisong() throws Exception {
		String strReturn = "";

		strReturn += "<table id='tbpeisonginfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='6' align='left'><b>航程信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td colspan='2'>出发城市-到达城市</td>" + "<td>航班号</td>"
				+ "<td>舱位码</td>" + "<td colspan='2'>起飞时间</td><td></td>";
		strReturn += "</tr>";

		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td colspan='2'>"
					+ listseginfo.get(i).getStartairport() + "-"
					+ listseginfo.get(i).getEndairport() + "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td colspan='2'>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "</tr>";
		}
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		try {

			strReturn += "<tr><td colspan='6' align='left'><b>订单配送信息</b></td></tr>";
			strReturn += "<tr>";
			strReturn += "<td align='right' class='table_color_r colortrin'>采购商名称：</td>";
			String agentname = "";
			String strContactName = "";
			String strContactTel = "";

			agentname = converNull(getagentname_b2bback(orderinfo
					.getBuyagentid()), "无");
			strContactName = converNull(orderinfo.getPostname(), converNull(
					orderinfo.getContactname(), "无"));
			strContactTel = converNull(orderinfo.getPostmobile(), converNull(
					orderinfo.getContactmobile(), "无"));

			strReturn += "<td align='left' >" + agentname + "</td>";
			strReturn += "<td align='right' class='table_color_r colortrin'>联系人：</td>";
			strReturn += "<td align='left' >" + strContactName + "</td>";
			strReturn += "<td align='right' class='table_color_r colortrin'>联系电话：</td>";
			strReturn += "<td align='left' >" + strContactTel + "</td></tr>";
		} catch (Exception ex) {

		}
		String strAddress = "";
		if (orderinfo.getAddresa() != null
				&& !orderinfo.getAddresa().equals("")) {
			strAddress = orderinfo.getAddresa();
		} else {
			strAddress = "无";
		}
		String strMemo = "";
		if (orderinfo.getMemo() != null && !orderinfo.getMemo().equals("")) {
			strMemo = orderinfo.getMemo();
		} else {
			strMemo = "无";
		}
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>配送地址：</td><td align='left' colspan='5'>"
				+ strAddress + "</td></tr>";
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>备注信息：</td><td align='left' colspan='5' valign='top'>";
		strReturn += "" + strMemo + "</td></tr>";
		String strPayName = "";
		if (orderinfo.getPaymethod() == 4) {
			strPayName = "无卡支付";
		} else if (orderinfo.getPaymethod() == 1) {
			strPayName = "在线支付";
		} else if (orderinfo.getPaymethod() == 2) {
			strPayName = "门市付款";
		} else if (orderinfo.getPaymethod() == 3) {
			strPayName = "票到付款";
		} else if (orderinfo.getPaymethod() == 5) {
			strPayName = "客户挂账";
		} else if (orderinfo.getPaymethod() == 6) {
			strPayName = "柜台支付";
		}
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>支付方式：</td><td align='left'>"
				+ strPayName + "</td>";
		strReturn += "<td align='right' class='table_color_r colortrin'>出票时间：</td>";
		strReturn += "<td align='left'>2010-10-01 12:30</td>";
		String strPNR = "";
		if (orderinfo.getPnr() != null && !orderinfo.getPnr().equals("")) {
			strPNR = orderinfo.getPnr() + "(小)";
		}
		if (orderinfo.getBigpnr() != null && !orderinfo.getBigpnr().equals("")) {
			strPNR += "&nbsp;&nbsp;" + orderinfo.getBigpnr() + "(大)";
		}
		strReturn += "<td align='right' class='table_color_r colortrin'>记录编码：</td><td align='left'>"
				+ strPNR + "</td></tr>";
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>送票员：</td>";
		strReturn += "<td align='left'>";

		String where = "SELECT a.C_CUSTOMERUSERID as id, (select C_MEMBERNAME from T_CUSTOMERUSER b where  a.C_CUSTOMERUSERID=b.ID) as name FROM         T_AGENTROLEREF a  where C_ROLEID=10046";
		List listdeptsale = Server.getInstance().getSystemService()
				.findMapResultBySql(where, null);

		strReturn += "<select id='ddlsender'>";
		strReturn += "<option value='0'></option>";
		for (int i = 0; i < listdeptsale.size(); i++) {
			Map mapcustomer = (Map) listdeptsale.get(i);

			strReturn += "<option value='" + mapcustomer.get("id") + "'>"
					+ mapcustomer.get("name") + "</option>";
		}
		strReturn += "</select></td>";
		Timestamp tsdatenow = new Timestamp(System.currentTimeMillis());
		strReturn += "<td colspan='2' align='left'><font color='#FF0000'>请选择配送员</font></td><td align='right' class='table_color_r colortrin'>配送日期：</td><td align='left'><input class='Wdate' type='text' value='"
				+ formatTimestamp2(tsdatenow)
				+ "' name='peisongdate' onFocus=\"WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d',alwaysUseStartDate:true})\" id='txtsendtime' /></td></tr>";
		strReturn += "</table><br />";
		List<Passenger> listpassenger2 = Server
				.getInstance()
				.getAirService()
				.findAllPassenger("WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
		// 判断含有几个乘机人，如果含有多个乘机人，添加分离打印功能
		String strFenliBtn = "";
		String strPassIDs = "";
		if (listpassenger2.size() > 1) {
			for (int i = 0; i < listpassenger2.size(); i++) {
				strPassIDs += listpassenger2.get(i).getId() + "|";
			}
			strFenliBtn = "&nbsp;&nbsp;<input class='button_d font-bai' onclick='fenlidayin(\""
					+ strTuiOrderID
					+ "\",\""
					+ strPassIDs
					+ "\");' value='分离打印' type='button'>";
		}
		strReturn += "<span id='span_peisong' style='margin-top:10px'><input class='button_d font-bai' onclick='sendticket("
				+ strTuiOrderID
				+ ");' value='配送' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:printChange("
				+ orderinfo.getId()
				+ ");prn1_print();' value='打印送票单' type='button'>&nbsp;&nbsp;"
				// "<input class='button_d font-bai'
				// onclick='javascript:prn1_preview();' value='预览送票单'
				// type='button'>"
				+ strFenliBtn + "</span>";
		strReturn += "<input type=\"hidden\" id=\"printorderid\" value=\""
				+ orderinfo.getId() + "\">";
		strReturn += "<div id='tbpreivew'>"
				+ this.getSendTicketPaper(orderinfo) + " </div>";
		strReturn += "<table id='tbbutton' style='display:none' width='100%' valign='top' border='0'>";
		strReturn += "<tr id='trbutton1'><td colspan='8'><input class='button_d font-bai' value='打印' onclick='javascript:prn1_print();' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='cancelprint();' value='取消' type='button'></td></tr>";
		strReturn += "</table>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 配送订单
	public void dealsendticket() throws Exception {
		String strReturn = "";
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		orderinfo.setPeisongrenid(Long.parseLong(strSenderID));
		orderinfo.setPeisongdate(dateToTimestamp(strSenderDate));
		orderinfo.setPeisongstatus(1l); // 0未配送，1配送中，2已配送
		orderinfo.setOrderstatus(28); // 在途订单
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		strReturn = "配送成功！";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 执行申请退费票
	public void TuiFeiOrder() throws Exception {
		String strReturn = "-1";

		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " and "
								+ Passenger.COL_state + " =" + hidTuoOrFei, "",
						-1, 0);

		String sub = "-1";
		sub = Server.getInstance().getRateService().TuiFeiOrder(orderinfo,
				listpassenger, whyid);

		if (sub.indexOf("-1")!=-1) {// 申请失败
			//strReturn=sub;
			strReturn=sub.split("@")[1];
			
		}else{
			
			orderinfo.setNewextorderid(sub);
			orderinfo.setExtorderstatus(orderinfo.getOrderstatus());// 修改外部订单状态为审核中...hanmenghui
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfo);
			strReturn = "ok";
			
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(strReturn);
		out.print(strReturn);
		out.flush();
		out.close();

	}

	// 得到乘机人信息根据订单号--申请退费票
	public void ToTuiFeiOrder() throws Exception {
		int staus = typ;// 4 申请退票 5申请费票
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		StringBuffer strReturn = new StringBuffer("");

		long policyagentid = orderinfo.getPolicyagentid();// 政策供应商

		// policyagentid = 3;
		if (policyagentid == 3 || policyagentid == 5) {
			if (typ == 5) {// 废票
				strReturn
						.append("<span style='color:red' align='left'>申请废票确认！</span>");
				staus = 5;

			}
			if (typ == 4) {// 退票
				staus = 4;
				strReturn
						.append("<span style='color:red' align='left'>申请退票确认！</span>");
			}
			strReturn
					.append("<table class='book_pgcontent' width='99%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
			strReturn.append("<tbody>");

			strReturn
					.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
			strReturn
					.append("<td><input type='hidden' id='checkboxflag' value='0' />");
			strReturn
					.append("<input type='checkbox' disabled='disabled' id='chkpassenger1_all' onclick='checkallbox();'>");

			strReturn
					.append("</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td>");

		}
		strReturn.append("</tr>");

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " and "
								+ Passenger.COL_state + "=" + staus, "", -1, 0);
		float tkprice = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			Passenger passenger = listpassenger.get(i);
			tkprice = converNull(passenger.getPrice(), 0f)
					+ converNull(passenger.getAirportfee(), 0f)
					+ converNull(passenger.getFuelprice(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)
					+ converNull(passenger.getOtherfee(), 0f);
			strReturn.append("<tr>");
			strReturn
					.append("<td align='center'><input type='hidden' id='txtpassid_"
							+ i
							+ "' value='"
							+ listpassenger.get(i).getId()
							+ "' />");
			String checkbox = "<input type='checkbox' disabled='disabled' id='chkpassenger_"
					+ i + "'>";
			if (orderinfo.getOrderstatus() == 10) {
				String tiecekmessage = this.getTicketInfo(passenger
						.getTicketnum());
				if (tiecekmessage.replace(" ", "").toLowerCase().indexOf(
						"openforuse") < 0) {

				}
			}
			strReturn.append(checkbox);

			strReturn.append("</td><td>"
					+ getPassTypeToString(passenger.getPtype()) + "</td>");
			strReturn.append("<td>" + passenger.getName());

			strReturn.append("</td>");
			strReturn.append("<td>" + getIDTypeToString(passenger.getIdtype())
					+ "</td>");
			strReturn.append("<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>");
			String strTicketNumber = "暂无";
			if (passenger.getTicketnum() != null
					&& !passenger.getTicketnum().equals("")) {
				strTicketNumber = passenger.getTicketnum();
			}
			strReturn.append("<td>" + strTicketNumber + "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getPrice())
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getFuelprice())
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getAirportfee())
					+ "</td>");
			if (converNull(orderinfo.getInternal(), 0l) == 1l) {
				strReturn.append("<td>" + formatMoney(passenger.getAnjianfee())
						+ "</td><td>" + formatMoney(passenger.getOtherfee())
						+ "</td>");
			}
			strReturn.append("</tr>");
			strReturn.append("<input type='hidden' id='hidTuoOrFei' value='"
					+ typ + "' />");
		}
		strReturn.append("</tbody>");
		strReturn.append("</table>");
		strReturn.append("<br />");
		String strReason = "退票原因";
		if (typ == 5) {// 废票
			strReason = "废票原因";
		}
		if (typ == 4) {// 废票
			strReason = "退票原因";
		}

		String select = GetWhyTuiFei(policyagentid + "", typ + "");

		strReturn
				.append("<tr class='GridViewHeaderStyle'><td class='table_color_r colortrin' width='60px'>"
						+ strReason
						+ ":</td><td align='left'>"
						+ select
						+ "</td></tr>");

		strReturn.append("<br />");

		if (listpassenger.size() > 0) {

			strReturn.append("<br />");
			strReturn
					.append("<input class='button_d font-bai' value='确认退废' onclick='checkTuiFei("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
		}
		strReturn
				.append("<input class='button_d font-bai' value='取消' onclick='closedialog("
						+ strTuiOrderID + ");' type='button' />");

		strReturn.append("<br />");
		strReturn.append("<br />");
		strReturn.append("温馨提示:");
		strReturn.append("<br />");
		strReturn
				.append("(1):提交退废申请前，请先取消不走的乘客的位置(有多名乘客时，请先将不走的乘客分离出编码，再取消不走的乘客的位置)");
		strReturn.append("<br />");
		strReturn.append("(2):您的操作一旦提交申请将不能撤销，并且平台会对您的订单进行相应处理，请慎重处理");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(strReturn);
		out.print(strReturn);
		out.flush();
		out.close();

	}

	// 得到乘机人信息根据订单号
	public void getPassengerList() throws Exception {

		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		String linkcheckbox = "";
		Integer linkmsgtype = orderinfo.getContactmsgtype();
		if (linkmsgtype != null && (linkmsgtype == 2 || linkmsgtype == 3)) {
			linkcheckbox = "checked='checked'";
		}
		StringBuffer strReturn = new StringBuffer("");
		long ordertate = 0;
		if (typ == 1) {
			strReturn
					.append("<span style='color:red' align='left'>请选择您要废票的乘机人！</span>");
			ordertate = 5;
		}
		if (typ == 2) {
			strReturn
					.append("<span style='color:red' align='left'>请选择您要退票的乘机人！</span>");
			ordertate = 4;
		}
		if (typ == 3) {
			strReturn
					.append("<span style='color:red' align='left'>请选择您要改签的乘机人！</span>");
			ordertate = 13;
		}
		if (typ == 14) {
			strReturn
					.append("<span style='color:red' align='left'>请选择要升舱换开的乘机人！</span>");
			ordertate = 23;
		}

		this.lockOrder(orderinfo.getId(), ordertate);// 锁单
		if (typ == 1 || typ == 2) {
			strReturn
					.append("<table width='99%' ><tr><td align='left'>联系人短信提醒：<input type='radio' "
							+ linkcheckbox
							+ " name='s_linkmsgtype' value='4'/>是&nbsp;<input type='radio' name='s_linkmsgtype' value='0'/>否</td></tr></table>");
		}
		strReturn
				.append("<table class='book_pgcontent' width='99%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
		strReturn.append("<tbody>");

		strReturn
				.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
		strReturn
				.append("<td><input type='hidden' id='checkboxflag' value='0' />");
		strReturn
				.append("<input type='checkbox'  id='chkpassenger1_all' onclick='checkallbox();'>");

		strReturn
				.append("</td><td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td>");
		if (converNull(orderinfo.getInternal(), 0l) == 1l) {
			strReturn.append("<td>安检</td><td>其它</td>");
		}
		strReturn.append("</tr>");

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " and "
								+ Passenger.COL_state + "<>12", "", -1, 0);
		float tkprice = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			Passenger passenger = listpassenger.get(i);
			tkprice = converNull(passenger.getPrice(), 0f)
					+ converNull(passenger.getAirportfee(), 0f)
					+ converNull(passenger.getFuelprice(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)
					+ converNull(passenger.getOtherfee(), 0f);
			strReturn.append("<tr>");
			strReturn
					.append("<td align='center'><input type='hidden' id='txtpassid_"
							+ i
							+ "' value='"
							+ listpassenger.get(i).getId()
							+ "' />");
			String checkbox = "<input type='checkbox'  id='chkpassenger_" + i
					+ "'>";
			if (orderinfo.getOrderstatus() == 10) {
				String tiecekmessage = this.getTicketInfo(passenger
						.getTicketnum());
				if (tiecekmessage.replace(" ", "").toLowerCase().indexOf(
						"openforuse") < 0) {

				}
			}
			strReturn.append(checkbox);
			if (i == 0) {
				strReturn.append("<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>");
			}
			strReturn.append("</td><td>"
					+ getPassTypeToString(passenger.getPtype()) + "</td>");
			strReturn.append("<td>" + passenger.getName());
			if (typ == 1 || typ == 2) {
				String pcheckbox = "";
				if (passenger.getMsgtype() != null
						&& (passenger.getMsgtype() == 2 || passenger
								.getMsgtype() == 3)) {
					pcheckbox = "checked='checked'";
				}
				strReturn
						.append("<br/><font color='red'>短信提醒：</font><input type='checkbox' "
								+ pcheckbox
								+ " id='s_msgtype"
								+ i
								+ "' value='4'>");
			}
			strReturn.append("</td>");
			strReturn.append("<td>" + getIDTypeToString(passenger.getIdtype())
					+ "</td>");
			strReturn.append("<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>");
			String strTicketNumber = "暂无";
			if (passenger.getTicketnum() != null
					&& !passenger.getTicketnum().equals("")) {
				strTicketNumber = passenger.getTicketnum();
			}
			strReturn.append("<td>" + strTicketNumber + "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getPrice())
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getFuelprice())
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getAirportfee())
					+ "</td>");
			if (converNull(orderinfo.getInternal(), 0l) == 1l) {
				strReturn.append("<td>" + formatMoney(passenger.getAnjianfee())
						+ "</td><td>" + formatMoney(passenger.getOtherfee())
						+ "</td>");
			}
			strReturn.append("</tr>");

		}
		// if (typ == 2) {
		// //strReturn
		// // .append("<tr><td colspan='3' class='table_color_r
		// colortrin'>退票手续费(每人):</td><td colspan='3' align=\"left\"><input
		// type='textbox' id='txttuifee' onblur=\"acountordertfprice()\"
		// width='15px' /></td>"
		// // + "<td class='table_color_r colortrin'>退款金额：</td><td colspan='5'
		// align=\"left\" ><input id='ordertfprice' size='7'/></td></tr>");
		// } else if (typ == 1) {
		// strReturn
		// .append("<tr><td colspan='3' class='table_color_r
		// colortrin'>废票手续费(每人):</td><td colspan='3' align=\"left\"><input
		// type='textbox' id='txttuifee' onblur=\"acountordertfprice()\"
		// width='15px' /></td>"
		// + "<td class='table_color_r colortrin'>退款金额：</td><td colspan='5'
		// align=\"left\" > <input id='ordertfprice' size='7'/></td></tr>");
		// } else if (typ == 3) {
		// strReturn
		// .append("<tr><td colspan='12'>改签手续费(每人):<input type='textbox'
		// id='txttuifee' width='15px' /></td></tr>");
		// } else if (typ == 14) {
		// strReturn
		// .append("<tr><td colspan='12'>升舱换开手续费(每人):<input type='textbox'
		// id='txttuifee' width='15px' /></td></tr>");
		// }
		strReturn.append("</tbody>");
		strReturn.append("</table>");
		strReturn.append("<br />");
		String strReason = "";
		String strDesc = "";
		String strTishi = "";
		if (typ == 1) {
			strReason = "废票原因";
			strDesc = "废票说明";
			strTishi = "温馨提示：当日废票请在17点之前进行提交,17点之后只能作为退票处理,按照航空公司客规收取手续费";
		} else if (typ == 2) {
			strReason = "退票原因";
			strDesc = "退票说明";
			strTishi = "温馨提示：退票会按照航空公司客规收取手续费";
		} else if (typ == 3) {
			strReason = "改签原因";
			strDesc = "改签说明";
			strTishi = "温馨提示：请将改签信息填写到备注说明中,如果已经生成了新的PNR请将PNR填写";
		} else if (typ == 14) {
			strReason = "升舱换开原因";
			strDesc = "升舱换开说明";
			strTishi = "温馨提示：请将改签信息填写到备注说明中,如果已经生成了新的PNR请将PNR填写";
		}

		strReturn
				.append("<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
		
		
		
		if (typ == 1) {
			strReturn
					.append("<tr><td class='table_color_r colortrin' width='60px'>"
							+ strReason
							+ ":</td><td align='left'>" +
							GetWhyTuiFei("5", "5") +
									"</td><td align='right' class='table_color_r colortrin'>保留位置:</td><td align='left'><input type='radio' id='rdoyes' name='tui_iscabinsite' value='0'  />是 <input type='radio' id='rdono' name='tui_iscabinsite'  checked='checked' value='1' />否</td></tr>");
		} else if (typ == 2) {
			
				strReturn
						.append("<tr><td class='table_color_r colortrin' width='60px'>"
								+ strReason
								+ ":</td><td align='left'>" +
								GetWhyTuiFei("5", "4") +
										"</td><td align='right' class='table_color_r colortrin'>保留位置:</td><td align='left'><input type='radio' id='rdoyes' name='tui_iscabinsit' value='0'  />是 <input type='radio' id='rdono' name='tui_iscabinsit'  checked='checked'  value='1' />否</td></tr>");
		
		} else if (typ == 3) {
			strReturn
					.append("<tr><td class='table_color_r colortrin' width='120px'>"
							+ strReason
							+ ":</td><td align='left'><select id='ddlreason'><option value='1'>自愿改签</option><option value='2'>非自愿改签</option></select></td><td align='right' class='table_color_r colortrin' width='120px'>保留位置:</td><td align='left'> <input type='radio' id='rdono' name='tui_iscabinsite' value='0'  />是 <input type='radio' id='rdoyes' name='tui_iscabinsite' checked='checked' value='1'  />否</td></tr>");

			strReturn
					.append("<tr id='trchangedate'><td class='table_color_r colortrin' width='120px'></br>起飞时间：</td><td align='left' ><input type='text' onfocus=\"WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})\" class='Wdate' id='txtchangedate' name='changedate' /></td><td class='table_color_r colortrin' width='120px'>到达时间：</td><td align='left' ><input type='text' onfocus=\"WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})\" class='Wdate' id='txtchangedate2' name='changedate2' /></td></tr>");
			strReturn
					.append("<tr id='trchangecangwei'  ><td class='table_color_r colortrin' width='120px'>新的舱位：</td><td align='left'><input type='text' id='txtchangecabin' name='changecabin' />(例如:Y)</td><td class='table_color_r colortrin' width='120px'>新的航班号：</td><td align='left'><input type='text' id='txtchangeflight' name='changeflight' />(例如:CA1234)</td></tr>");
			strReturn
					.append("<tr id='trchangecangwei' style='display:none'><td class='table_color_r colortrin' width='120px'>更改航段：</td><td align='left' colspan='3'><input type='text' style='width:100px' id='txtstartairport' name='s_startairport' />-<input type='text' id='txtendairport' name='s_endairport' style='width:100px' /><font color='red'>请输入机场城市三字码</font></td></tr>");

			strReturn
					.append("<tr style='display:none'><td colspan='4'><span style='color:red'>PNR生成已经超过三天，请需要重新生成PNR！</span></td></tr>");
			strReturn
					.append("<tr style='display:none' id='trchangecangwei'><td class='table_color_r colortrin' width='60px'>原订单号：</td><td align='left'><input type='text' id='txtorderid' value='"
							+ orderinfo.getOrdernumber()
							+ "' name='orderid' /></td><td class='table_color_r colortrin' width='60px'>新PNR：</td><td align='left'><input type='text' id='txtchangepnr' name='changepnr' /></td></tr>");
		} else if (typ == 14) // 升舱换开
		{
			strReturn
					.append("<tr><td colspan='4' align='left'><span style='color:red'>请生成新的换开订单或将新生成的换开PNR导入系统中，进行查询</span></td></tr>");
			strReturn
					.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'><td colspan='4' align='left'><b>换开操作处理</b></td></tr>");
			strReturn
					.append("<td class='table_color_r colortrin'>新订单号：</td><td align='left'><input type='text' id='txtordernumber' /></td><td class='table_color_r colortrin'>新PNR:</td><td align='left'><input type='text' id='txtorderpnr'  /></td>");
			strReturn.append("</tr>");
			strReturn
					.append("<tr  id='trchangecangwei' ><td class='table_color_r colortrin' width='120px'>新票号：</td><td align='left' colspan='3'><input type='text' id='txtnewticnum' name='newticnum' /> <span style='color:red'>新PNR和新票号至少填写一项</span></td></tr>");
		}
		strReturn
				.append("<tr><td class='table_color_r colortrin' width='60px'>"
						+ strDesc
						+ ":</td><td colspan='3' align='left'><textarea id='tuifeidesc' rows='5' cols='60'></textarea></td></tr>");
		strReturn
				.append("<tr><td colspan='4' align='left'><span style='color:red'>"
						+ strTishi + "</span></td></tr>");
		strReturn.append("</table>");
		if (typ == 2) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='申请退票' onclick='tuiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
		}
		if (typ == 1) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='申请废票' onclick='feiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
		}
		if (typ == 3) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='申请改签' onclick='gaiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
		}
		if (typ == 14) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='申请升舱换开' onclick='shengcangticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
		}
		strReturn
				.append("<input class='button_d font-bai' value='取消' onclick='closedialog("
						+ strTuiOrderID + ");' type='button' />");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(strReturn);
		out.print(strReturn);
		out.flush();
		out.close();
	}
	public String gettuifeiyuany(long id){
		String sub="";
		if(id==1){
			sub="当日作废，扣10元手续费";
		}
		if(id==2){
			sub="其它废票情况";
		}
		if(id==3){
			sub="客人自愿退票，按客规收取手续费";
		}
		if(id==4){
			sub="南航FC舱、国航FC舱、东航FCY舱、海航FC舱，申请全退";
		}
		if(id==5){
			sub="因航班取消延误，申请全退";
		}
		if(id==6){
			sub="升舱换开，申请全退";
		}
		if(id==7){
			sub="名字错换开重出，申请全退";
		}
		if(id==8){
			sub="客人因病无法乘机，申请全退";
		}
		if(id==9){
			sub="其它退票情况";
		}
		if(id==10){
			sub="申请退回票款差价";
		}
		
		return sub;
	}
	// 得到申请废退得乘机人
	public void getPassengersqList() throws Exception {
		StringBuilder strReturn = new StringBuilder();
		String strTuipiaofeis = "";
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				Long.valueOf(strTuiOrderID));
		long orderstate = 0l;
		if (typ == 1) {
			strReturn
					.append("<span style='color:red' align='left'>请选择审核通过废票的乘机人！</span>");
			strTuipiaofeis = "废票手续费";

		}
		if (typ == 2) {
			strReturn
					.append("<span style='color:red' align='left'>请选择审核通过退票的乘机人！</span>");
			strTuipiaofeis = "退票手续费";
		}
		if (typ == 3) {
			strReturn
					.append("<span style='color:red' align='left'>请选择审核通过改签的乘机人！</span>");
			strTuipiaofeis = "改签费用";
		}
		if (typ == 4) {
			strReturn
					.append("<span style='color:red' align='left'>请选择要分离的乘机人！</span>");
		}
		if (typ == 14) {
			strReturn
					.append("<span style='color:red' align='left'>请选择要分离的乘机人！</span>");
			strTuipiaofeis = "升舱换开费用";
		}
		this.lockOrder(orderinfo.getId(), orderstate);
		if (typ == 1 || typ == 2) {
			Integer lmsgtype = orderinfo.getContactmsgtype();
			String checked = "";
			if (lmsgtype != null && lmsgtype == 4) {
				checked = "checked='checked'";
			}
			strReturn
					.append("<table width='99%' ><tr><td align='left'>联系人短信提醒：<input type='radio' name='s_linkmsgtype' "
							+ checked
							+ " value='4'/>是&nbsp;<input type='radio' name='s_linkmsgtype' value='0'/>否</td></tr></table>");
		}
		strReturn
				.append("<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
		strReturn.append("<tbody>");

		strReturn
				.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
		strReturn
				.append("<td><input type='hidden' id='checkboxflag' value='0' />"
						+ "<input type='checkbox' style='display:none' id='chkpassenger1_all' onclick='checkallbox();'></td>"
						+ "<td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td>"
						+ "<td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td>");

		// strReturn.append("<td>" + strTuipiaofeis + "</td>";
		// strReturn.append("<td>退款金额</td>";
		strReturn.append("</tr>");
		String where = "  WHERE C_ORDERID=" + strTuiOrderID + " and "
				+ Passenger.COL_state + "<>12";
		int intpasscount = Server.getInstance().getAirService()
				.countPassengerBySql(
						"SELECT COUNT(*) FROM T_PASSENGER " + where);

		if (typ == 1) {
			where += " and " + Passenger.COL_state + " =5";
		}
		if (typ == 2) {
			where += " and " + Passenger.COL_state + " =4";
		}
		if (typ == 3) {
			where += " and " + Passenger.COL_state + " =6";
		}
		if (typ == 14) {
			where += " and " + Passenger.COL_state + " =13";
		}

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		// System.out.println(listpassenger.size());
		boolean backinsur = false;
		float insurcb = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			float pinsurcb = 0f;
			Passenger passenger = listpassenger.get(i);
			float tkprice = converNull(passenger.getPrice(), 0f)
					+ converNull(passenger.getAirportfee(), 0f)
					+ converNull(passenger.getFuelprice(), 0f)
					+ converNull(passenger.getAnjianfee(), 0f)
					+ converNull(passenger.getOtherfee(), 0f);
			if (passenger.getInsurprice()!=null&&passenger.getInsurprice() > 0) {
				if (!backinsur)
					insurcb = getInsurcb(orderinfo.getBackpointinfo());
				
				HttpSession session = ServletActionContext.getRequest().getSession();
				int bxcb=20;
				if(session.getAttribute("INSURPRICE")!=null&&session.getAttribute("INSURPRICE").toString().trim().length()>0){
					bxcb=Integer.parseInt(session.getAttribute("INSURPRICE").toString().trim());
				}
				
				int count = (int) (passenger.getInsurprice() / bxcb);
				pinsurcb = insurcb * count;
				backinsur = true;
			}
			strReturn.append("<tr>");
			strReturn
					.append("<td align='center'>"
							+ "<input type='hidden' id='txtpassid_"
							+ i
							+ "' value='"
							+ passenger.getId()
							+ "' />"
							+ "<input type='checkbox' onclick='acountordertfprice()' value='"
							+ tkprice + "' insur='" + pinsurcb
							+ "'  id='chkpassenger_" + i + "'></td>");
			if (i == 0) {
				strReturn.append("<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(passenger.getTickettypeid(), 0l))
								.getTypename() + "</td>");
			}
			strReturn.append("<td>" + getPassTypeToString(passenger.getPtype())
					+ "</td>");
			String checke = "";
			if (passenger.getMsgtype() != null && passenger.getMsgtype() == 4) {
				checke = "checked='checked'";
			}
			strReturn
					.append("<td>"
							+ passenger.getName()
							+ "<br/><font color='red'>短信提醒：</font><input type='checkbox' "
							+ checke + " id='s_msgtype" + i
							+ "' value='4'></td>");
			strReturn.append("<td>" + getIDTypeToString(passenger.getIdtype())
					+ "</td>");
			strReturn.append("<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ passenger.getIdnumber() + "</span></td>");
			String strTicketNumber = "暂无";
			if (passenger.getTicketnum() != null
					&& !passenger.getTicketnum().equals("")) {
				strTicketNumber = passenger.getTicketnum();
			}
			strReturn.append("<td style='color:red'>" + strTicketNumber
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getPrice())
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getFuelprice())
					+ "</td>");
			strReturn.append("<td>" + formatMoney(passenger.getAirportfee())
					+ "</td>");

			// if (passenger.getTuifee() != null) {
			// strReturn.append("<td style='color:red'><b>"
			// + formatMoney(listpassenger.get(i).getTuifee())
			// + "</b></td>";
			// } else {
			// strReturn.append("<td>无</td>";
			// }
			// if (i == 0) {
			// strReturn.append("<td rowspan=\"" + listpassenger.size() + "\" >"
			// + converNull(orderinfo.getReturnprice(), 0f) + "</td>";
			// }
			strReturn.append("</tr>");

		}

		strReturn.append("</tbody>");

		strReturn.append("</table>");
		strReturn
				.append("<span style='color:red' align='left'>原订单信息(点击订单号查看原订单信息)</span>");
		strReturn
				.append("<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
		strReturn.append("<tbody>");
		strReturn
				.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
		strReturn.append("<td>订单编号</td>" + "<td>行程</td>" + "<td>起飞时间</td>"
				+ "<td>预订时间</td>" + "<td>航班号</td>" + "<td>航位</td>"
				+ "<td>PNR</td>");
		strReturn.append("</tr>");
		strReturn.append("</tr>");
		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where " + Segmentinfo.COL_orderid + "="
								+ strTuiOrderID + "", "", -1, 0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn.append("<tr>");
			strReturn
					.append("<td><a style='text-decoration:underline' href='orderinfo!toshowb2c.action?id="
							+ orderinfo.getId()
							+ "' target='_blank'>"
							+ orderinfo.getOrdernumber() + "</a></td>");
			strReturn
					.append("<td>"
							+ getCitynameByAirport(listseginfo.get(i)
									.getStartairport())
							+ "-"
							+ getCitynameByAirport(listseginfo.get(i)
									.getEndairport()) + "</td>");
			strReturn.append("<td>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>");
			strReturn.append("<td>"
					+ formatTimestamp(orderinfo.getCreatetime()) + "</td>");
			strReturn.append("<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>");
			strReturn.append("<td>" + listseginfo.get(i).getCabincode()
					+ "</td>");
			strReturn.append("<td>" + converNull(orderinfo.getPnr(), "")
					+ "(小)</br>" + converNull(orderinfo.getBigpnr(), "")
					+ "</td>");
			strReturn.append("</tr>");
		}
		strReturn.append("<tr><td colspan='10'><table>");
		float insurprice = 0f;
		if (typ == 1 || typ == 2) {
			if (typ == 2) {
				strReturn
						.append("<tr><td  class='table_color_r colortrin'>退票手续费(每人):</td>"
								+ "<td><input id='txttuifee' value='0' onblur=\"acountordertfprice()\"  /></td>"
								+ "<td  class='table_color_r colortrin'>&nbsp;&nbsp;退款金额：</td>"
								+ "<td  align=\"left\" ><input id='ordertfprice' /></td>");
			} else if (typ == 1) {
				strReturn
						.append("<tr><td  class='table_color_r colortrin'>废票手续费(每人):</td><td colspan='3' align=\"left\"><input type='textbox' value='0' id='txttuifee' onblur=\"acountordertfprice()\"  width='15px' /></td>"
								+ "<td   class='table_color_r colortrin'>退款金额：</td>"
								+ "<td  align=\"left\" > <input id='ordertfprice'/></td>");
			}
			if (backinsur) {
				strReturn
						.append("<td class='table_color_r colortrin' align='left'>保险退款：</td><td><input type='radio' name='isbackinsur' onclick='acountordertfprice();'  value='1'/>否<input type='radio' onclick='acountordertfprice();' name='isbackinsur' value='2'/>是</td>");
			}
			if (orderinfo.getExtorderstatus() != null) {
				if (orderinfo.getExtorderstatus() == 8
						|| orderinfo.getExtorderstatus() == 11) {
					strReturn
							.append("<td class='table_color_r colortrin' align='left'>供应退款：</td><td>"
									+ orderinfo.getReturnprice() + "</td>");
				}
			}

			strReturn.append("</tr>");
		} else if (typ == 3) {
			strReturn
					.append("<tr><td '>改签手续费(每人):<input type='textbox' value='0' id='txttuifee'  width='15px' /></td></tr>");
		} else if (typ == 14) {
			strReturn
					.append("<tr><td >升舱换开手续费(每人):<input type='textbox' value='0' id='txttuifee'  width='15px' /></td></tr>");
		}
		strReturn.append("</table></tr><td>");
		strReturn.append("<tr><td colspan='10' height='5px'></td></tr>");
		strReturn.append("</tbody>");
		strReturn.append("</table>");
		// 加载升舱换开审核
		if (orderinfo.getOrderstatus() == 23
				|| orderinfo.getOrderstatus() == 30) {
			String wheresql = "WHERE ID=(" + orderinfo.getRelationorderid()
					+ ")";
			List<Orderinfo> orderinfos = Server.getInstance().getAirService()
					.findAllOrderinfo(wheresql, "", -1, 0);

			strReturn
					.append("<span style='color:red' align='left'>新订单信息(点击订单号查看新订单信息)</span>");
			strReturn
					.append("<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>"
							+ "<tr  class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
			strReturn.append("<td>订单编号</td>" + "<td>行程</td>" + "<td>起飞时间</td>"
					+ "<td>预订时间</td>" + "<td>航班号</td>" + "<td>航位</td>"
					+ "<td>PNR</td>");
			strReturn.append("</tr>");
			if (orderinfos.size() > 0) {
				Orderinfo neworder = orderinfos.get(0);
				String swhere = " WHERE C_ORDERID=" + neworder.getId();
				List<Segmentinfo> segmentinfos = Server.getInstance()
						.getAirService().findAllSegmentinfo(swhere, "", -1, 0);
				Segmentinfo segment = new Segmentinfo();
				if (segmentinfos.size() > 0) {
					segment = segmentinfos.get(0);
				}
				strReturn
						.append("<tr><td><a style='text-decoration:underline' href='orderinfo!toshowb2c.action?id="
								+ neworder.getId()
								+ "' target='_blank'>"
								+ neworder.getOrdernumber() + "</a></td>");
				strReturn.append("<td>"
						+ getCitynameByAirport(segment.getStartairport()) + "-"
						+ getCitynameByAirport(segment.getEndairport())
						+ "</td>");
				strReturn.append("<td>"
						+ formatTimestamp(segment.getDeparttime()) + "</td>");
				strReturn.append("<td>"
						+ formatTimestamp(neworder.getCreatetime()) + "</td>");
				strReturn.append("<td>" + segment.getFlightnumber() + "</td>");
				strReturn.append("<td>" + segment.getCabincode() + "</td>");
				strReturn.append("<td>" + converNull(neworder.getPnr(), "")
						+ "(小)<br/>" + converNull(neworder.getBigpnr(), "")
						+ "(大)</td>");
				strReturn.append("</tr>");
				strReturn.append("</table>");
			} else {

				strReturn.append("<tr><td colspan=\"7\">暂无</td></tr>");
			}
		}
		strReturn
				.append("<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
		strReturn
				.append("<tr><td class='table_color_l colortrin' colspan='4' width='60px'><b>申请退废/改签原因如下</b></td></tr>");
		Passenger passenger = new Passenger();
		if (listpassenger.size() > 0) {
			passenger = listpassenger.get(0);
		}
		if (passenger.getTuifeiyuanyi() == null) {
			passenger.setTuifeiyuanyi(1l);
		}
		if (typ != 14) {
			strReturn
					.append("<tr><td class='table_color_r colortrin' width='140px'>退废/改签原因:</td><td align='left'>");
			
			if (passenger.getTuifeiyuanyi() == 3) {
				strReturn.append(gettuifeiyuany(passenger.getTuifeiyuanyi()));
			}
			strReturn
					.append("</td><td align='right' class='table_color_r colortrin' width='60px'>保留位置:</td><td align='left'>");
			strReturn
					.append(converNull(passenger.getIscabinsite(), 0l) == 1l ? "是"
							: "否");
			strReturn.append("</td></tr>");
		}
		// 改签信息
		if (typ == 3) {
			strReturn.append("<tr >");
			strReturn
					.append("<td class='table_color_r colortrin' width='120px' >改签后起飞时间：</td>");
			strReturn.append("<td align='left' width='250px' >"
					+ passenger.getChangedate() + "</td>");
			strReturn
			.append("<td class='table_color_r colortrin' width='120px' >改签后到达时间：</td>");
	strReturn.append("<td align='left' width='250px' >"
			+ formatTimestampHHmm2(passenger.getTuitime()) + "</td>");
	
			
	
			strReturn.append("</tr>");

			if ((passenger.getChangecabin() != null && !listpassenger.get(0)
					.getChangecabin().equals(""))
					|| passenger.getChangeflight() != null
					&& !passenger.getChangeflight().equals("")) {
				strReturn.append("<tr >");
				strReturn
						.append("<td class='table_color_r colortrin' width='120px'>改签舱位：</td>");
				String strChcabin = "无";
				if (passenger.getChangecabin() != null
						&& !passenger.getChangecabin().equals("")) {
					strChcabin = passenger.getChangecabin();
				}
				strReturn.append("<td align='left' width='250px'>" + strChcabin
						+ "</td>");
				String strChflight = "无";
				if (passenger.getChangeflight() != null
						&& !passenger.getChangeflight().equals("")) {
					strChflight = passenger.getChangeflight();
				}
				strReturn
						.append("<td class='table_color_r colortrin' width='120px'>改签航班：</td>");
				strReturn.append("<td align='left' width='250px'>"
						+ strChflight + "</td>");
				strReturn.append("</tr>");
			}
		}
		if (typ == 14) {
			strReturn.append("<tr >");
			strReturn
					.append("<td class='table_color_r colortrin' width='120px'>新订单号：</td>");
			String strcpnr = "无";
			String strcp = "";
			if (orderinfo.getNewordernum() != null
					&& !orderinfo.getNewordernum().equals("")) {
				strcpnr = "<a style='text-decoration:underline' href='orderinfo!toshowb2c.action?id="
						+ orderinfo.getId()
						+ "' target='_blank'>"
						+ orderinfo.getNewordernum() + "</a>";
			}
			if (orderinfo.getNewpnr() != null
					&& !orderinfo.getNewpnr().equals("")) {
				strcp = orderinfo.getNewpnr();
			}
			strReturn.append("<td align='left' width='250px'>" + strcpnr
					+ "</td>");
			strReturn
					.append("<td class='table_color_r colortrin' width='120px' >新PNR：</td>");
			strReturn.append("<td align='left' width='250px' colspan='2'>"
					+ strcp + "</td>");
			strReturn.append("</tr>");

			strReturn.append("<tr >");
			strReturn
					.append("<td class='table_color_r colortrin' width='120px'>新票号：</td>");
			String strTicNum = "";
			if (orderinfo.getNewticnum() != null
					&& !orderinfo.getNewticnum().equals("")) {
				strTicNum = orderinfo.getNewticnum();
			}
			strReturn.append("<td align='left' width='250px'>" + strTicNum
					+ "</td>");
			strReturn
					.append("<td class='table_color_r colortrin' width='120px' ></td>");
			strReturn
					.append("<td align='left' width='250px' colspan='2'></td>");
			strReturn.append("</tr>");
		}
		strReturn
				.append("<tr><td class='table_color_r colortrin' width='60px'>备注说明:</td><td align='left' style='color:red' width='250px'>");
		String time = "";
		try {
			strReturn.append(listpassenger.get(0).getTuifeidesc());
			time = formatTimestamp(passenger.getTuifeitime());
		} catch (Exception e) {

		}
		strReturn
				.append("</td><td class='table_color_r colortrin'>申请时间:</td><td align='left'>"
						+ time + "</td></tr>");
		strReturn.append("<tr><td colspan='4' height='5px'></td></tr>");
		strReturn.append("</table>");
		strReturn
				.append("<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>");
		if (typ != 3 && typ != 14) {
			if (orderinfo.getOrderstatus() == 4) {
				strReturn
						.append("<tr><td width='140px' class='table_color_r colortrin'>暂不能退废票/改签原因：</td><td colspan='3' align='left'><input type='radio' id='rdoyes' name='radiotuifei' checked='checked' style='display:none' /> <input type='radio' checked='checked' id='rdono' name='radiotuifei' />其他原因</td></tr>");
			} else {
				strReturn
						.append("<tr><td width='140px' class='table_color_r colortrin'>暂不能退废票/改签原因：</td><td colspan='3' align='left'><input type='radio' id='rdoyes' name='radiotuifei' checked='checked' />废票时间已过 <input type='radio' id='rdono' name='radiotuifei' />其他原因</td></tr>");
			}

		} else {
			strReturn
					.append("<tr><td width='140px' colspan='4' style='color:red' align='left'>如果审核不通过请将不能审核通过原因填写在备注说明中</td></tr>");
		}
		strReturn
				.append("<tr><td class='table_color_r colortrin' width='120'>备注说明</td><td colspan='3' align='left'><textarea rows='5' id='beizhu' cols='60'></textarea></td></tr>");
		strReturn.append("</table>");

		if (typ == 2) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='审核通过' onclick='shenhetuiticket("
							+ strTuiOrderID
							+ ","
							+ intpasscount
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
			strReturn
					.append("<input class='button_d font-bai' value='审核不通过' onclick='noshenhetuiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
			// 打印退票单按钮
			// strReturn.append("<input class='button_d font-bai' value='打印退票单'
			// onclick='javascript:prn1_print();' type='button'>
			// &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		if (typ == 1) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='审核通过' onclick='shenhefeiticket("
							+ strTuiOrderID
							+ ","
							+ intpasscount
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
			strReturn
					.append("<input class='button_d font-bai' value='审核不通过' onclick='noshenhefeiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");

		}
		if (typ == 3) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='审核通过' onclick='shenhegaiticket("
							+ strTuiOrderID
							+ ","
							+ intpasscount
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
			strReturn
					.append("<input class='button_d font-bai' value='审核不通过' onclick='noshenhegaiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");

		}
		if (typ == 14) {
			strReturn
					.append("<br /><input class='button_d font-bai' value='审核通过' onclick='shenheshengcangticket("
							+ strTuiOrderID
							+ ","
							+ intpasscount
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
			strReturn
					.append("<input class='button_d font-bai' value='审核不通过' onclick='noshenhegaiticket("
							+ strTuiOrderID
							+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;");
		}
		strReturn
				.append("<input class='button_d font-bai' value='取消' onclick='closedialog("
						+ strTuiOrderID + ");' type='button' />");

		strReturn
				.append("<script>function acountordertfprice(){  var zpj=0;"
						+ " var binsur=$('input[@type=radio][name=isbackinsur][checked]').val();"
						+ " var tfp=$(\"input:checkbox[id*='chkpassenger_'][checked=true]\").length;var allsxf=converNullAndEpt($(\"#txttuifee\").val(),0)*tfp;"
						+ "$(\"input:checkbox[id*='chkpassenger_'][checked=true]\").each(function(i){"
						+ "zpj+=parseInt($(this).val());if(binsur==2){var theinsur=$(this).attr('insur');zpj+=parseInt(theinsur);}"
						+ "}); ");
		if (backinsur) {
			strReturn.append(" ");
			strReturn.append(" {zpj+=" + insurprice + "*tfp}; ");
		}
		strReturn.append(" $(\"#ordertfprice\").val(zpj-allsxf);}</script>");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 得到退费信息查看
	public void getViewTuifei() throws Exception {
		String strReturn = "";
		String strTuipiaofei = "";
		if (typ == 1) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过废票的乘机人！</span>";
			strTuipiaofei = "废票手续费";
		}
		if (typ == 2) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过退票的乘机人！</span>";
			strTuipiaofei = "退票费";
		}
		if (typ == 3) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过改签的乘机人！</span>";
			strTuipiaofei = "改签费用";
		}
		if (typ == 4) {
			strReturn += "<span style='color:red' align='left'>查看乘机人退废信息</span>";
			strTuipiaofei = "退/废费用";
		}
		if (typ == 6 || typ == 7) {
			strReturn += "<span style='color:red' align='left'>查看乘机人退废信息</span>";
			strTuipiaofei = "退/废费用";

		}
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td><td>"
				+ strTuipiaofei + "</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID;
		if (typ == 1) {
			where += " and " + Passenger.COL_state + " =5";
		}
		if (typ == 2) {
			where += " and " + Passenger.COL_state + " =4";
		}
		if (typ == 3) {
			where += " and " + Passenger.COL_state + " =6";
		}

		where += " AND C_STATE <>12 ";
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				Long.valueOf(strTuiOrderID));
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		float totaltuifee = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			strReturn += "<tr>";
			// strReturn+="<td align='center'><input type='hidden'
			// id='txtpassid_"+i+"' value='"+listpassenger.get(i).getId()+"'
			// /><input type='checkbox' checked='checked'
			// id='chkpassenger_"+i+"'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}
			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td style=\"color:red\">" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(converNull(listpassenger.get(i)
							.getAnjianfee(), 0f))
					+ "</td><td>"
					+ formatMoney(converNull(
							listpassenger.get(i).getOtherfee(), 0f)) + "</td>";
			if (listpassenger.get(i).getTuifee() != null) {
				strReturn += "<td style='color:red;'><b>"
						+ formatMoney(listpassenger.get(i).getTuifee())
						+ "</b></td>";
				totaltuifee += converNull(listpassenger.get(i).getTuifee(), 0f);
			} else {
				strReturn += "<td style='color:red'></td>";
			}
			strReturn += "</tr>";

		}
		strReturn += "<tr><td colspan='15' height='5px' style='border:0px'></td></tr>";
		strReturn += "</tbody>";

		strReturn += "</table>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>订单编号</td>" + "<td>行程</td>" + "<td>起飞时间</td>"
				+ "<td>预订时间</td>" + "<td>航班号</td>" + "<td>PNR</td>";
		strReturn += "</tr>";
		Passenger passenger = new Passenger();

		if (listpassenger.size() > 0) {
			passenger = listpassenger.get(0);
		}
		if (passenger.getTuifeiyuanyi() == null) {
			passenger.setTuifeiyuanyi(1l);
		}
		strReturn += "<tr>";
		strReturn += "<td>" + orderinfo.getOrdernumber() + "</td>";
		strReturn += "<td>"
				+ getCitynameByAirport(getSegmentinfo(orderinfo.getId())
						.getStartairport())
				+ "--"
				+ getCitynameByAirport(getSegmentinfo(orderinfo.getId())
						.getEndairport()) + "</td>";
		strReturn += "<td>" + geqifeitime(orderinfo.getId()) + "</td>";
		strReturn += "<td>" + formatTimestamp(orderinfo.getCreatetime())
				+ "</td>";
		strReturn += "<td>" + gethangbanhao(orderinfo.getId()) + "</td>";
		strReturn += "<td>"
				+ converNull(orderinfo.getPnr(), converNull(orderinfo
						.getBigpnr(), "")) + "</td>";

		strReturn += "</tr>";

		strReturn += "<tr><td colspan='10' height='5px'></td></tr>";
		strReturn += "</tbody>";
		strReturn += "</table>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td class='table_color_l colortrin' colspan='4' width='60px'><b>申请退费原因如下</b></td></tr>";
		strReturn += "<tr><td class='table_color_r colortrin' width='60px'>退废原因:</td><td align='left'>";
		// System.out.println(passenger.getTuifeiyuanyi());
		String tuifei = "";

		if (orderinfo.getOrderstatus() == 12) {
			if (passenger.getTuifeiyuanyi() == 1) {
				tuifei = "自愿退票";
			} else {
				tuifei = "非自愿退票";
			}

		}
		if (orderinfo.getOrderstatus() == 11l) {
			if (passenger.getTuifeiyuanyi() == 1) {
				tuifei = "自愿废票";
			} else {
				tuifei = "非自愿废票";
			}
		}
		strReturn += tuifei;
		strReturn += "</td><td align='right' class='table_color_r colortrin' width='60px'>保留位置:</td><td align='left'>";
		if (passenger.getIscabinsite() == 0) {
			strReturn += "是";
		}
		if (passenger.getIscabinsite() == 1) {
			strReturn += "否";
		}
		strReturn += "</td></tr>";

		strReturn += "<tr><td class='table_color_r colortrin' width='60px'>备注说明:</td><td align='left' style='color:red'>"
				+ passenger.getTuifeidesc()
				+ "</td><td class='table_color_r colortrin'>申请时间:</td><td align='left'>"
				+ formatTimestamp(passenger.getTuifeitime()) + "</td></tr>";
		strReturn += "<tr><td colspan='4' height='5px'></td></tr>";
		strReturn += "</table>";
		int intiswebpay = 0;
		strReturn += "<form name='formpay' method='post'>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		String strbeizhushuoming = "无";
		if (passenger.getBeizhu() != null
				&& !passenger.getBeizhu().equals("undefined")) {
			strbeizhushuoming = passenger.getBeizhu();
		}
		strReturn += "<tr><td class='table_color_r colortrin'>备注说明：</td><td colspan='3' align='left' style='color:red'>"
				+ strbeizhushuoming + "</td></tr>";

		strReturn += "<tr><td width='120px' class='table_color_r colortrin'>退款金额：</td><td colspan='3' align='left'><span style='font-weight:bold'>"
				// + formatMoney(orderinfo.getTotalticketprice()
				// + orderinfo.getTotalairportfee()
				// + orderinfo.getTotalfuelfee()
				// + converNull(orderinfo.getTotalanjian(), 0f)
				// + converNull(orderinfo.getTotalotherfee(), 0f))
				// + "-"
				// + formatMoney(totaltuifee)
				// + "=</span><span style='font-weight:bold;color:red'>"
				// + formatMoney(orderinfo.getTotalticketprice()
				// + orderinfo.getTotalairportfee()
				// + orderinfo.getTotalfuelfee()
				// + converNull(orderinfo.getTotalanjian(), 0f)
				// + converNull(orderinfo.getTotalotherfee(), 0f)
				// - totaltuifee)
				+ converNull(orderinfo.getReturnprice(), 0)
				+ "元</span></td></tr>";
		if (orderinfo.getPaymethod() == 1) {
			intiswebpay = 1;
			strReturn += "<tr><td style='color:red' colspan='4'><input type='text' name='amount' value='"
					+ formatMoney(orderinfo.getReturnprice())
					+ "' /><input type='text' name='ordercode' value='"
					+ orderinfo.getOrdernumber()
					+ "' /><b>此订单为网上支付订单，点击退款成功将会调用退款接口进行退款</b></td></tr>";
		}

		strReturn += "<tr><td width='120px' class='table_color_r colortrin'>暂不能退票原因：</td><td colspan='3' align='left'>"
				+ converNull(passenger.getNotuidesc(), "无") + "</td></tr>";

		strReturn += "</table>";
		if (typ == 2) {// 退票
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhetuiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhetuiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 废票
		if (typ == 1) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhefeiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhefeiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 改签
		if (typ == 3) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhegaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhegaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 升舱换开
		if (typ == 4) {
			strReturn += "<br /><input class='button_d font-bai' value='退款成功' onclick='tuipiaotuikuan("
					+ strTuiOrderID
					+ ");'  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='取消' onclick='closedialog(0);' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 废票退款
		if (typ == 6) {
			strTuikuanDesc = formatMoney(orderinfo.getTotalticketprice()
					+ orderinfo.getTotalairportfee()
					+ orderinfo.getTotalfuelfee())
					+ "-"
					+ formatMoney(totaltuifee)
					+ "="
					+ formatMoney(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalairportfee()
							+ orderinfo.getTotalfuelfee() - totaltuifee);
			strReturn += "<br /><input class='button_d font-bai' value='退款成功' onclick=\"feipiaotuikuan("
					+ strTuiOrderID
					+ ",'"
					+ strTuikuanDesc
					+ "',"
					+ intiswebpay
					+ ");\"  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='取消' onclick='closedialog(0);' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 退票退款
		if (typ == 7) {
			strTuikuanDesc = formatMoney(orderinfo.getTotalticketprice()
					+ orderinfo.getTotalairportfee()
					+ orderinfo.getTotalfuelfee())
					+ "-"
					+ formatMoney(totaltuifee)
					+ "="
					+ formatMoney(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalairportfee()
							+ orderinfo.getTotalfuelfee() - totaltuifee);
			strReturn += "<br /><input class='button_d font-bai' value='退款成功' onclick='tuipiaotuikuan("
					+ strTuiOrderID
					+ ","
					+ intiswebpay
					+ ");'  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='取消' onclick='closedialog(0);' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		strReturn += "</form>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public Timestamp geqifeitime(long id) {// 取起飞时间
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		// if(list.size()>0&&list.get(0).getDeparttime()!=null){
		return list.get(0).getDeparttime();

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

	/**
	 * 订单状态修改==供应商
	 */

	public String editorderstatus() throws Exception {
		this.unlockOrder(orderinfo.getId());// 解锁。
		String strOptdesc = "";
		Orderinfo theorderinfo = Server.getInstance().getAirService()
				.findOrderinfo(orderinfo.getId());
		int status = orderinfo.getOrderstatus();
		
		if(newordernum!=null&&newordernum.length()>0){
			orderinfo.setNewextorderid(newordernum);
			
		}
		
		if (status == 4 || status == 5 || status == 13 || status == 23
				|| status == 30) {
			orderinfo.setOldorderstatus(theorderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 2) {// 支付
			orderinfo.setPaystatus(1);
			strOptdesc = "等待出票-" + getLoginUser().getMembername()
					+ "执行了等待出票，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 28) {// 待配送
			strOptdesc = "在途订单-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 29) {// 待收款
			strOptdesc = "待收银-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 30) {
			// 申请换开操作--twocold
			Orderinfo neworder = new Orderinfo();
			Passenger passenger = new Passenger();
			if (strNewTicketNum != null && strNewTicketNum.trim().length() > 0) {
				String where = " WHERE " + Passenger.COL_ticketnum + "='"
						+ strNewTicketNum + "'";
				List<Passenger> orders = Server.getInstance().getAirService()
						.findAllPassenger(where, "", -1, 0);
				if (orders.size() > 0) {
					passenger = orders.get(0);
					neworder = Server.getInstance().getAirService()
							.findOrderinfo(passenger.getOrderid());
					if (neworder != null)
						orderinfo.setNewordernum(neworder.getOrdernumber());
				}
			} else if (strSepPNR != null && strSepPNR.trim().length() > 0) {
				String where = " WHERE " + Orderinfo.COL_pnr + "='" + strSepPNR
						+ "' OR C_BIGPNR ='" + strSepPNR + "'";
				List<Orderinfo> orders = Server.getInstance().getAirService()
						.findAllOrderinfo(where, "", -1, 0);
				if (orders.size() > 0) {
					neworder = orders.get(0);
					// orderinfo.setNewordernum(neworder.getOrdernumber());
				}
			}
			orderinfo.setNewordernum(neworder.getOrdernumber());
			String pnr = neworder.getPnr() != null
					&& neworder.getPnr().trim().length() > 0 ? neworder
					.getPnr() : neworder.getBigpnr();
			orderinfo.setNewpnr(pnr);
			orderinfo.setNewticnum(passenger.getTicketnum());
			orderinfo.setOrderstatus(30);
			orderinfo.setRelationorderid(neworder.getId());
			strOptdesc = "申请换开-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}
		if (orderinfo.getOrderstatus() == 24) {// 换开审核通过
			orderinfo.setOrderstatus(24);
			strOptdesc = "换开审核通过-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 9 || orderinfo.getOrderstatus() == 18) {
			String sql = "SELECT ISNULL(SUM(C_TUIFEE),0) AS SXF FROM T_PASSENGER WHERE C_ORDERID="
					+ theorderinfo.getId() + " AND C_STATE<>12";
			Map map = (Map) Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null).get(0);
			float sxf = Float.valueOf(map.get("SXF").toString());
			int orderstatus = theorderinfo.getOrderstatus();
			if (orderinfo.getOrderstatus() == 9) {// 废票退款
				strOptdesc = "废票退款成功-" + getLoginUser().getMembername()
						+ "执行了操作，订单状态为"
						+ getStateToString(orderinfo.getOrderstatus())
						+ "<br />退款信息：" + strTuikuanDesc + "(应退款)";
				// 撤销返佣记录
				theorderinfo.setOrderstatus(9);
				this.takeoutRebate(theorderinfo, sxf, true);
			}
			if (orderinfo.getOrderstatus() == 18) {// 退票退款
				strOptdesc = "退票退款成功--" + getLoginUser().getMembername()
						+ "执行了操作，订单状态为"
						+ getStateToString(orderinfo.getOrderstatus())
						+ "<br />退款信息：" + strTuikuanDesc + "(应退款)";
				// 撤销返佣记录
				theorderinfo.setOrderstatus(18);
				this.takeoutRebate(theorderinfo, sxf, true);

			}
			theorderinfo.setOrderstatus(orderstatus);
		}
		if (orderinfo.getOrderstatus() == 4) // 申请退票
		{
			strOptdesc = "申请退票-" + getLoginUser().getMembername()
					+ "执行了申请退票，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());

		}
		if (orderinfo.getOrderstatus() == 16) // 暂不能出票
		{
			strOptdesc = "暂不能出票-" + getLoginUser().getMembername()
					+ "执行了暂不能出票，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 3) {// 出票
			strOptdesc = "立即出票-" + getLoginUser().getMembername()
					+ "执行了出票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
			orderinfo.setPrinttime(new Timestamp(System.currentTimeMillis()));
		}
		
		
		
		if (orderinfo.getOrderstatus() == 6 || orderinfo.getOrderstatus() == 19) {// 取消订单--19：拒单
			orderinfo.setQuxiaotime(new Timestamp(System.currentTimeMillis()));
			if (orderinfo.getOrderstatus() == 6) {
				
			/*String sub=Server.getInstance().getRateService().canceorder(orderinfo);
				if(sub.equals("-1")){
					return "";
				}*/
				strOptdesc = "取消订单-" + getLoginUser().getMembername()
				+ "执行了取消订单，订单状态为";
			} else {
				if (beizhu != null && beizhu.trim().length() > 0) {
					String expr = new String(beizhu.getBytes("ISO-8859-1"), "UTF-8");
					beizhu = expr;
				}
				orderinfo.setAddresa(beizhu);
				strOptdesc = "无法出票-拒单-" + getLoginUser().getMembername()
				+ "执行了 拒单操作，拒单原因:"+beizhu+" ,订单状态为";
				
				/*Server.getInstance().getTicketSearchService().XEPNR(
						theorderinfo.getPnr());*/

			}
			strOptdesc += getStateToString(orderinfo.getOrderstatus());
			if (vmoneyService() && theorderinfo.getPaystatus() == 1
					&& theorderinfo.getBuyagentid() != 46l) {// 已支付
				// 撤销返佣记录
				float money = theorderinfo.getTotalticketprice()
						+ theorderinfo.getTotalfuelfee()
						+ theorderinfo.getTotalairportfee();
				money += this.getINSURMONEYPrice(theorderinfo.getId());
				// 退还票款。
				this.createRebateRecord(theorderinfo.getOrdernumber(), money,
						1, theorderinfo.getBuyagentid(), theorderinfo
								.getBuyagentid(), 2, "订单"
								+ theorderinfo.getOrdernumber() + "取消预订,账户返还"
								+ money + "元.");
			}
			if(theorderinfo.getPaystatus() == 1
					&& theorderinfo.getBuyagentid() != 46l){
				String whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and "+Traderecord.COL_ordercode+" ='"+theorderinfo.getOrdernumber()+"'";
				whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
				List<Traderecord>listTraderecord=Server.getInstance().getMemberService().findAllTraderecord(whereTR, " ORDER BY ID ", -1, 0);
				if(listTraderecord!=null&&listTraderecord.size()>0){
				//在线支付.退款
				String url="http://127.0.0.1:8080/interface/Alipaytui?orderid="+orderinfo.getId();
				WriteLog.write("拒单或者取消订单-申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url);
				java.net.URL Url = new java.net.URL(url);
				java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String s="";
				while((s=br.readLine())!=null)
				{
					WriteLog.write("拒单或者取消订单-申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
					System.out.println("申请退款返回:"+s);
					if(s.indexOf("T")!=-1)
		        	{
						WriteLog.write("拒单或者取消订单-申请退款信息-成功", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
						System.out.println("申请退款成功");
		        	}else{
		        		System.out.println("申请退款失败");
		        		WriteLog.write("拒单或者取消订单-申请退款信息-失败", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
		        	}
					
				}
				}
			}
		}
				
			
		
		orderinfo.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		// 如果是收银操作，如果有个人挂账情况
		if (orderinfo.getOrderstatus() == 10) {
			orderinfo.setCashier(1);// 已收银
			orderinfo.setPaystatus(1);
			if (orderinfo.getFkmethod() > 0) {
				if (orderinfo.getFkmethod() == 7) {// 个人挂账
					orderinfo.setGuazhangrenid(s_employeeid);
					// 插入个人挂账记录
					Gerenguazhanfrec gerenguazhang = new Gerenguazhanfrec();
					gerenguazhang.setOrderid(orderinfo.getId());
					gerenguazhang.setEmployeeid(s_employeeid);
					gerenguazhang.setState(0l);
					gerenguazhang.setCreatetime(new Timestamp(System
							.currentTimeMillis()));
					gerenguazhang.setCreateuser(getLoginUserId() + "");
					Server.getInstance().getMemberService()
							.createGerenguazhanfrec(gerenguazhang);
				} else if (orderinfo.getFkmethod() != 7
						&& orderinfo.getFkmethod() != 8) {// 7,个人挂账，8， 月结挂账
					for (Passenger passenger : this
							.getPassengerListByOrderiId(orderinfo.getId())) {
						float allprice = converNull(passenger.getPrice(), 0f)
								+ converNull(passenger.getFuelprice(), 0f)
								+ converNull(passenger.getAirportfee(), 0f)
								+ passenger.getInsurprice();

						allprice += converNull(orderinfo.getPostmoney(), 0);
						String sql = " UPDATE T_PASSENGER SET C_HKSTATE=2,C_YIHAI="
								+ allprice
								+ ",C_HAIQIAN=0 WHERE C_ORDERID="
								+ orderinfo.getId();
						Server.getInstance().getSystemService()
								.findMapResultBySql(sql, null);
					}
				}
				Orderinfo currentorderinfo = Server.getInstance()
						.getAirService().findOrderinfo(orderinfo.getId());
				if (converNull(currentorderinfo.getReceipt(), -1) == 4
						|| converNull(currentorderinfo.getReceipt(), -1) == 5) {
					orderinfo.setPeisongstatus(2l);

				}
			}

		}

		if (no == 2) {
			if (beizhu != null && beizhu.trim().length() > 0) {
				String expr = new String(beizhu.getBytes("ISO-8859-1"), "UTF-8");
				beizhu = expr;
			}
			if (tui_tuifeidesc != null && tui_tuifeidesc.trim().length() > 0) {
				String tuifeidesc = new String(tui_tuifeidesc
						.getBytes("ISO-8859-1"), "UTF-8");
				tui_tuifeidesc = tuifeidesc;
			}
			if (tui_nodesc != null && tui_nodesc.trim().length() > 0) {
				String nodesc = new String(tui_nodesc.getBytes("ISO-8859-1"),
						"UTF-8");
				tui_nodesc = nodesc;
			}

			/*
			 * String bei = encoder(beizhu);
			 * beizhu=java.net.URLDecoder.decode(bei,"UTF-8");
			 */
		}
		if (orderinfo.getOrderstatus() == 3) {// 出票
			String sql = " update " + Passenger.TABLE + " set "
					+ Passenger.COL_state + " =1," + Passenger.COL_rttime
					+ " ='" + new Timestamp(System.currentTimeMillis())
					+ "' where " + Passenger.COL_orderid + " ="
					+ orderinfo.getId();
			Server.getInstance().getAirService().excutePassengerBySql(sql);
			strOptdesc = "出票-" + getLoginUser().getMembername()
					+ "执行了出票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 12
				|| orderinfo.getOrderstatus() == 11) {
			System.out.println(orderinfo.getIsbackinsur());
			HttpServletRequest request = ServletActionContext.getRequest();
			float returnprice = Float.valueOf(converNull(request
					.getParameter("returnprice"), "0"));
			String tuifee = request.getParameter("tui");
			orderinfo.setReturnprice(returnprice);
			if (isNotNullOrEpt(tuifee)) {
				String sql = "UPDATE T_PASSENGER SET C_TUIFEE=" + tuifee
						+ " WHERE C_ORDERID=" + theorderinfo.getId()
						+ " AND C_STATE<>12";
				Server.getInstance().getSystemService().findMapResultBySql(sql,
						null);
			}
			List<Segmentinfo> segments = null;
			String linkmsgtype = ServletActionContext.getRequest()
					.getParameter("linkmsgtype");
			if (linkmsgtype.equals("4")) {
				List<Passenger> listpassenger = Server.getInstance()
						.getAirService().findAllPassenger(
								" WHERE C_ORDERID=" + theorderinfo.getId(), "",
								-1, 0);
				this.sendTFMsgtoLinkUser(listpassenger);

			}
			if (this.isOrdersmsAndnoremove(theorderinfo.getContactmobile())) {
				segments = Server.getInstance().getAirService()
						.findAllSegmentinfo(
								"WHERE C_ORDERID=" + theorderinfo.getId(), "",
								-1, 0);
				for (Segmentinfo sengment : segments) {

					this.removeFYsms(theorderinfo.getContactmobile(),
							theorderinfo.getContactname(), sengment,
							theorderinfo.getId());
				}
			}

			if (orderinfo.getOrderstatus() == 11) {// 废票

				String[] passenger = passid.split(strSubSplit);
				String[] msgtypes = ServletActionContext.getRequest()
						.getParameter("msgtypes").split(strSubSplit);
				if (passenger.toString().trim().length() > 0) {

					for (int a = 0; a < passenger.length; a++) {
						long paid = Long.parseLong(passenger[a]);
						String msgtype = msgtypes[a];
						Passenger pa = Server.getInstance().getAirService()
								.findPassenger(paid);
						pa.setState(2);
						pa.setBeizhu(beizhu);
						pa.setTuifee(Float.parseFloat(tui));

						pa
								.setTuitime(new Timestamp(System
										.currentTimeMillis()));
						Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(pa);
						if (msgtype.equals("4")) {
							sendTFMsgtoPassenger(pa);
						}
						if (this.isOrdersmsAndnoremove(pa.getMobile())) {
							if (segments == null) {
								segments = Server.getInstance().getAirService()
										.findAllSegmentinfo(
												"WHERE C_ORDERID="
														+ orderinfo.getId(),
												"", -1, 0);
							}
							for (Segmentinfo sengment : segments) {

								this.removeFYsms(pa.getMobile(), pa.getName(),
										sengment, pa.getOrderid());
							}
						}
					}
				}
				strOptdesc = "废票审核通过-" + getLoginUser().getMembername()
						+ "执行了废票操作，订单状态为"
						+ getStateToString(orderinfo.getOrderstatus())
						+ "<br />废票备注：" + beizhu;
			}
			if (orderinfo.getOrderstatus() == 12) {// 退票
				strOptdesc = "退票审核通过-" + getLoginUser().getMembername()
						+ "执行了退票操作，订单状态为"
						+ getStateToString(orderinfo.getOrderstatus());
				String[] passenger = passid.split(strSubSplit);
				String[] msgtypes = ServletActionContext.getRequest()
						.getParameter("msgtypes").split(strSubSplit);

				if (passenger.toString().trim().length() > 0) {

					for (int a = 0; a < passenger.length; a++) {
						long paid = Long.parseLong(passenger[a]);
						String msgtype = msgtypes[a];
						Passenger pa = Server.getInstance().getAirService()
								.findPassenger(paid);
						pa.setState(3);
						pa.setBeizhu(beizhu);
						// pa.setTuifee(Float.parseFloat(tui));
						pa
								.setTuitime(new Timestamp(System
										.currentTimeMillis()));
						Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(pa);
						if (msgtype.equals("4")) {
							sendTFMsgtoPassenger(pa);
						}
						if (this.isOrdersmsAndnoremove(pa.getMobile())) {
							if (segments == null) {
								segments = Server.getInstance().getAirService()
										.findAllSegmentinfo(
												"WHERE C_ORDERID="
														+ orderinfo.getId(),
												"", -1, 0);
							}
							for (Segmentinfo sengment : segments) {
								this.removeFYsms(pa.getMobile(), pa.getName(),
										sengment, pa.getOrderid());
							}
						}
					}
				}
				strOptdesc = "退票-" + getLoginUser().getMembername()
						+ "执行了退票操作，订单状态为"
						+ getStateToString(orderinfo.getOrderstatus())
						+ "<br />退票备注：" + beizhu;
			}
		}
		// 改签
		if (orderinfo.getOrderstatus() == 13) {
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(6);// 申请改签
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuiorfei(0l);
					pa.setChangedate(changedate);//航班起飞时间
					pa.setTuitime(dateToTimestamp2(changedate2));//航班降落时间
					pa.setChangeflight(changeflight);
					try {
						changecabin=new String(changecabin.getBytes("ISO-8859-1"),"UTF-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					pa.setChangecabin(changecabin);
					pa.setChangepnr(changepnr);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "改签-" + getLoginUser().getMembername()
					+ "执行了申请改签操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />改签备注：" + tui_tuifeidesc+",改签到航班:"+changeflight+",改签到仓位:"+changecabin+",改签航班起飞时间:"+changedate+",改签航班降落时间:"+changedate2;
		}
		// 申请升舱换开
		if (orderinfo.getOrderstatus() == 30) {
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(13);// 申请升舱换开
					pa.setTuifee(Float.parseFloat(tui));
					pa.setTuiorfei(0l);
					pa.setChangedate(changedate);
					pa.setChangeflight(changeflight);
					pa.setChangecabin(changecabin);
					pa.setChangepnr(changepnr);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}

			strOptdesc = "申请升舱换开-" + getLoginUser().getMembername()
					+ "执行了申请升舱换开操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />申请升舱换开备注：" + tui_tuifeidesc;
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}
		if (orderinfo.getOrderstatus() == 4) {// 申请退票的乘机人

			String[] msgtypes = ServletActionContext.getRequest().getParameter(
					"msgtypes").split(strSubSplit);
			String linkmsgtype = ServletActionContext.getRequest()
					.getParameter("linkmsgtype");
			if (linkmsgtype.equals("4")) {// 退废短信
				orderinfo.setContactmsgtype(4);
			}
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					String msgtype = msgtypes[a];
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					if (msgtype.equals("4")) {
						pa.setMsgtype(4);
					}
					pa.setState(4);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuiorfei(0l);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}

			strOptdesc = "申请退票-" + getLoginUser().getMembername()
					+ "执行了申请退票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />申请退票备注：" + tui_tuifeidesc;
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}

		if (orderinfo.getOrderstatus() == 5) {// 申请废票的乘机人
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {
				String[] msgtypes = ServletActionContext.getRequest()
						.getParameter("msgtypes").split(strSubSplit);
				String linkmsgtype = ServletActionContext.getRequest()
						.getParameter("linkmsgtype");
				if (linkmsgtype.equals("4")) {
					orderinfo.setContactmsgtype(4);
				}
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					String msgtype = msgtypes[a];
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					if (msgtype.equals("4")) {
						pa.setMsgtype(4);
					}
					pa.setState(5);
					pa.setTuiorfei(1l);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					// pa.setTuifee(Float.parseFloat(this.converTrim(tui,
					// "0")));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "申请废票-" + getLoginUser().getMembername()
					+ "执行了申请废票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />申请废票备注：" + tui_tuifeidesc;
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}

		if (orderinfo.getOrderstatus() == 17) {// 退票不通过
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(7);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "退票审核不通过-" + getLoginUser().getMembername()
					+ "执行了退票审核不通过，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>退票审核不通过备注：" + beizhu;

		}
		if (orderinfo.getOrderstatus() == 7) {// 废票不通过
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(1);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}

			strOptdesc = "废票审核不通过-" + getLoginUser().getMembername()
					+ "执行了废票审核不通过，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>废票审核不通过备注：" + beizhu;
		}
		String strbeizhudesc = "";
		if (orderinfo.getOrderstatus() == 14) {// 改签通过
			String strgaiqiancabin = getgaiqiancabin(orderinfo.getId());
			String strgaiqiandate = getgaiqiandate(orderinfo.getId());
			String strgaiqiandate2 = getgaiqiandate2(orderinfo.getId());
			String strgaiqianfnumber = getgaiqianfnumber(orderinfo.getId());
			
			System.out.println("仓位:"+strgaiqiancabin);
			System.out.println("航班:"+strgaiqianfnumber);
			System.out.println("起飞:"+strgaiqiandate);
			System.out.println("降落:"+strgaiqiandate2);

			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(9);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));

					try {
						strbeizhudesc += "<br /><font color='red'><b>改签信息：";
						String stroldcabin = "";
						String strolddate = "";
						String stroldfnumber = "";

						stroldcabin = getxingchenginfo(orderinfo.getId())
								.getCabincode();
						strolddate = formatTimestampHHmm2(getxingchenginfo(
								orderinfo.getId()).getDeparttime());
						stroldfnumber = getxingchenginfo(orderinfo.getId())
								.getFlightnumber();
						if (!strgaiqiancabin.equals("")) {
							strbeizhudesc += " 舱位从" + stroldcabin + "改签到"
									+ strgaiqiancabin + "舱";
						}
						if (!strgaiqiandate.equals("")) {
							strbeizhudesc += " 起飞时间从" + strolddate + "改签到"
									+ strgaiqiandate + " ";
						}
						if (!strgaiqianfnumber.equals("")) {
							strbeizhudesc += " 航班号从" + stroldfnumber + "改签到"
									+ strgaiqianfnumber + " ";
						}
						strbeizhudesc += "</b></font>";

					} catch (Exception ex) {

					}
					pa.setBeizhu(beizhu + "" + strbeizhudesc);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
				// 改签通过将改签的信息更新到行程信息中
				List<Segmentinfo> listsegmeng = Server.getInstance()
						.getAirService().findAllSegmentinfo(
								" where " + Segmentinfo.COL_orderid + "="
										+ orderinfo.getId(), "", -1, 0);
				if (listsegmeng.size() > 0) {
					if (strgaiqiancabin != null && !strgaiqiancabin.equals("")) {
						listsegmeng.get(0).setCabincode(
								getgaiqiancabin(orderinfo.getId()));
					}
					if (strgaiqiandate != null && !strgaiqiandate.equals("")) {
						listsegmeng.get(0).setDeparttime(
								dateToTimestamp2(strgaiqiandate));
						listsegmeng.get(0).setArrivaltime(dateToTimestamp2(strgaiqiandate2));
					}
					if (strgaiqianfnumber != null
							&& !strgaiqianfnumber.equals("")) {
						listsegmeng.get(0).setFlightnumber(strgaiqianfnumber);
					}
					Server.getInstance().getAirService().updateSegmentinfo(
							listsegmeng.get(0));
				}

			}

			strOptdesc = "已经改签-" + getLoginUser().getMembername()
					+ "执行了已经改签操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />改签审核通过备注：" + beizhu + " " + strbeizhudesc;
		}
		if (orderinfo.getOrderstatus() == 25) {// 升舱换开通过
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(14);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "已升舱换开-" + getLoginUser().getMembername()
					+ "执行了已升舱换开操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />升舱换开审核通过备注：" + beizhu;
		}

		if (orderinfo.getOrderstatus() == 26) {// 升舱换开不通过
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(15); // 换开不通过
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "改签不通过-" + getLoginUser().getMembername()
					+ "执行了改签不通过操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>改签审核不通过备注：" + beizhu;
		}
		if (orderinfo.getOrderstatus() == 15) {// 改签不通过
			String[] passenger = passid.split(strSubSplit);
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(10);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "改签不通过-" + getLoginUser().getMembername()
					+ "执行了改签不通过操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>改签审核不通过备注：" + beizhu;
		}
		if (status == 7 || status == 17 || status == 15 || status == 26) {

			if (theorderinfo.getOldorderstatus() != null) {
				orderinfo.setOrderstatus(theorderinfo.getOldorderstatus());
			}
		}
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);

		// String loginname = Server.getInstance().getMemberService()
		// .findCustomeruser(getLoginUser().getId()).getLoginname();
		// List<Passenger> listpa = Server.getInstance().getAirService()
		// .findAllPassenger(
		// "where 1=1 and " + Passenger.COL_orderid + " ="
		// + orderinfo.getId(), "", -1, 0);
		// this.synchPassengertoOrder(orderinfo);

		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent(strOptdesc);
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(orderinfo.getOrderstatus());
		orderinforc.setCustomeruserid(getLoginUserId());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
		// System.out.println(rc.getId());

		// 获取前一页面路径

		forward = ServletActionContext.getRequest().getHeader("Referer");
		
		forward="b2bticketorder.action";
		System.out.println("forward:"+forward);
		
		if (orderinfo.getOrderstatus() == 29) {
			if (forward.indexOf("s_orderstatus") >= 0) {
				forward = forward.replace("s_orderstatus",
						"s_orderstatus=29&s_ordernumber="
								+ theorderinfo.getOrdernumber() + "&a");
			} else {
				if (forward.indexOf("?") > 0) {
					forward += "&s_ordernumber="
							+ theorderinfo.getOrdernumber();
				} else {
					forward += "?s_ordernumber="
							+ theorderinfo.getOrdernumber();
				}
			}
		} else if (orderinfo.getOrderstatus() == 10) {
			forward = forward.replace("s_orderstatus", "s_cashier=1&a");
			if (!(forward.indexOf("s_ordernumber") >= 0)) {
				if (forward.indexOf("?") > 0) {
					forward += "&s_ordernumber="
							+ theorderinfo.getOrdernumber();
				} else {
					forward += "?s_ordernumber="
							+ theorderinfo.getOrdernumber();
				}
			}
		}

		return "editorderstatus";
	}
	
	public void  alipay_tuifenrun() throws Exception {
		orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(strTuiOrderID));
		String ret="-1";
		String whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"'";
		whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
		List<Traderecord>listTraderecord=Server.getInstance().getMemberService().findAllTraderecord(whereTR, " ORDER BY ID ", -1, 0);
		if(listTraderecord!=null&&listTraderecord.size()>0){
		//在线支付.退款
		String url="http://127.0.0.1:8080/interface/Alipaytui?orderid="+orderinfo.getId();
		WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url);
		java.net.URL Url = new java.net.URL(url);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String s="";
		while((s=br.readLine())!=null)
		{
			WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
			System.out.println("申请退款返回:"+s);
			if(s.indexOf("T")!=-1)
        	{
				WriteLog.write("申请退款信息-成功", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
				ret="1";
				System.out.println("申请退款成功");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/plain; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.print(ret);
				out.flush();
				out.close();
        	}else{
        		System.out.println("申请退款失败");
        		WriteLog.write("申请退款信息-失败", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
        		ret="-1";
        		HttpServletResponse response = ServletActionContext.getResponse();
    			response.setContentType("text/plain; charset=utf-8");
    			PrintWriter out = response.getWriter();
    			
    			out.print(ret);
    			out.flush();
    			out.close();
        	}
			
		}
		}
		
		
	}
	
	
	public void can51bookorder() throws Exception {
		System.out.println("=================取消第三方订单===================");
		Orderinfo orderinfopnr = Server.getInstance().getAirService()
				.findOrderinfo(s_orderid);
		String strReturn = "-1";
		if (orderinfopnr.getExtorderid()!=null) {
			
			strReturn = Server.getInstance().getRateService().canceorder(orderinfopnr);
			
			System.out.println(strReturn);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(strReturn);
			out.flush();
			out.close();
		}else{
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(strReturn);
			out.flush();
			out.close();
		}
	}

	
	/**
	 * @param order
	 */
	private void lockOrder(long orderid, long orderstate) {
		String sql = " UPDATE T_ORDERINFO SET C_USERID="
				+ this.getLoginUser().getId() + ",C_OPERATINGSTATE="
				+ orderstate + ",C_OPERATEAGENT="
				+ this.getLoginUser().getAgentid() + " WHERE ID=" + orderid;
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);

	}

	private void unlockOrder(long orderid) {
		String sql = " UPDATE T_ORDERINFO SET C_USERID=-1,C_OPERATEAGENT=-1,C_OPERATINGSTATE=-1 WHERE ID ="
				+ orderid;
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);

	}

	public void ajaxunlockorder() {
		System.out.println("*********ajaxunlockorder********************");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");

		this.unlockOrder(orderinfo.getId());
	}

	/**
	 * 转向订单详细信息页面==供应商
	 */
	public String showOrderdetail() throws Exception {
		if (orderinfo.getId() > 0) {
			orderinfo = Server.getInstance().getAirService().findOrderinfo(
					orderinfo.getId());
		} else {
			String where = " WHERE C_ORDERNUMBER = '"
					+ orderinfo.getOrdernumber() + "'";
			List list = Server.getInstance().getAirService().findAllOrderinfo(
					where, "", -1, 0);
			if (list.size() > 0) {
				orderinfo = (Orderinfo) list.get(0);
			} else {
				return "";
			}
		}
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId() + " AND " + Passenger.COL_state + "<>12";
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		listYmsend = Server.getInstance().getMemberService().findAllYmsend(
				" WHERE C_ORDERCODE ='" + orderinfo.getId() + "'", "", -1, 0);
		List<Customeragent> list = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			listAgent = list.get(0);
		}
		for (int i = 0; i < listPassenger.size(); i++) {
			if (listPassenger.get(i).getPtype() == 1) {
				adultnum = adultnum + 1;
			}
		}

		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		List<Customeragent> list2 = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list2 != null && list2.size() > 0) {
			listGongAgent = list2.get(0);
		}

		// Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());
		String strOrderInfo = orderinfo.getBackpointinfo() != null ? orderinfo
				.getBackpointinfo().trim() : "";

		String sql = "SELECT * FROM [T_ORDERINFORC] WHERE C_ORDERINFOID = "
				+ orderinfo.getId();
		if (this.getLoginsessionagent().getAgenttype() != 1) {
			sql += " AND C_STATE IS NOT NULL ";
		}
		sql += " ORDER BY C_CREATETIME  ";
		listorderinforc = Server.getInstance().getAirService()
				.findAllOrderinforcBySql(sql, -1, 0);
		listPeisong=Server.getInstance().getAirService().findAllPeisong(" WHERE 1=1 AND "+Peisong.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID DESC ", -1, 0);
		listScang=Server.getInstance().getAirService().findAllScang(" WHERE 1=1 AND "+Scang.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
		
		
		if(orderinfo.getBackpointinfo()!=null){
		
		String liudianinfo=orderinfo.getBackpointinfo();
		String [] liudianinfos=liudianinfo.split("@");
		String newbackinfo="";
		for(int s=0;s<liudianinfos.length;s++){
			if(liudianinfos[s]!=null&&liudianinfos[s].trim().length()>0&&liudianinfos[s].indexOf(",")!=-1){//保险的不算
				String info=liudianinfos[s].trim();//得到单条记录
				String []infos=info.split(",");//得到单条记录的数组
				String agentid=infos[0].trim();//代理ID
				String liudian=infos[1];//留点参数
				String zongdian=infos[3];//总返点
				if(Float.parseFloat(liudian)>Float.parseFloat(zongdian)){
					//WriteLog.write("分润参数信息-错误订单", "订单ID:"+orderinfo.getId());
					
				}else{
				
				if(!agentid.equals("1")&&!agentid.equals("46")&&!agentid.equals(orderinfo.getBuyagentid().toString())&&!liudian.equals("0.00")){
					
					Withbank withbank=new Withbank();
					
					String price=infos[2];//票面价
					
					Float lirun=Float.parseFloat(price)*Float.parseFloat(liudian)/100*listPassenger.size();
					String lirunstr=lirun+"";
					lirunstr=lirunstr.substring(0, lirunstr.indexOf("."));
					Customeragent cuagent=Server.getInstance().getMemberService().findCustomeragent(Long.parseLong(agentid.trim()));
						if(cuagent.getAlipayaccount()!=null){
							System.out.println("支付宝账号:"+cuagent.getAlipayaccount());
							//cuagent.setAlipayaccount("1193367@qq.com");
							withbank.setUsername(cuagent.getAgentshortname());//代理名字
							withbank.setBankno(cuagent.getAlipayaccount());//账号
							withbank.setPrice(lirunstr);
							withbank.setBankname(liudian);
							listfenrun.add(withbank);
							
						}
						
				}
			}
				
			}
		}
		
		}
		
		
		return "shwoorderdetail";
	}

	/**
	 * 获取外部订单状态列表
	 * @return
	 */
	public List getExtorderstauslist() {
		String sql = "SELECT C_STATEID id,C_STATEMEMO memo FROM T_OUTORDERSTATE WHERE C_AGENTID=3 ORDER BY C_STATEID";
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		return list;
	}

	/**
	 * 订单状态修改_转向支付页面
	 */
	public String orderstatustozhifu() throws Exception {
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
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		listAgent = (Customeragent) Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0).get(0);

		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		listGongAgent = (Customeragent) Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0).get(0);
		return "tozhifu";
	}

	public Tickettype getTickettypeById(long typeid) {
		if (typeid > 0) {
			return Server.getInstance().getMemberService().findTickettype(
					typeid);
		} else {
			Tickettype tyep = new Tickettype();
			tyep.setTypename("");
			return tyep;
		}
	}

	public Tickettype getTickettypeByOrderId(long orderid) {
		Tickettype type = new Tickettype();
		String where = " WHERE C_ORDERID=" + orderid;
		List<Passenger> passengerlist = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		if (passengerlist.size() > 0) {
			Passenger passenger = passengerlist.get(0);
			type = Server.getInstance().getMemberService().findTickettype(
					passenger.getTickettypeid());
		}
		return type;
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
				.findAllSegmentinfo(where,
						"ORDER BY " + Segmentinfo.COL_departtime, -1, 0);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
//国内
	public String[] getSegmenentByOrderid(long orderid) {

		String sql = " SELECT C_FLIGHTNUMBER,AIRFLIGHT,C_DEPARTTIME FROM view_orderinfo WHERE ID="
				+ orderid;
		
		//System.out.println(sql);
		try {
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			if (list.size() > 0) {
				String[] str = new String[3];
				Map m = (Map) list.get(0);
				str[0] = m.get("C_FLIGHTNUMBER").toString();
				str[1] = m.get("AIRFLIGHT").toString();
				str[2] = m.get("C_DEPARTTIME").toString();
				return str;
			}
		} catch (Exception e) {

		}
		return null;

	}
	
	
	
	public String[] getSegmenentByOrderid2(long orderid) {

		List<Segmentinfo>list=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderid, " ORDER BY ID ", -1, 0);
		String[] str = new String[3];
		String xingc="";
		String hangbanhao="";
		String qifeitime="";
		if(list!=null&&list.size()>0){
			
			for(int s=0;s<list.size();s++){
				
				xingc+=getAirnamebySZM(list.get(s).getStartairport())+"-"+getAirnamebySZM(list.get(s).getEndairport())+"<br/>";
				hangbanhao+=list.get(s).getFlightnumber()+"<br/>";
				
			}
		}
		qifeitime+=list.get(0).getDeparttime();
		str[0] = hangbanhao;
		str[1] = xingc;
		str[2] = qifeitime;
		
		/*try {
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			if (list.size() > 0) {
				
				Map m = (Map) list.get(0);
				str[0] = m.get("C_FLIGHTNUMBER").toString();
				str[1] = m.get("AIRFLIGHT").toString();
				str[2] = m.get("C_DEPARTTIME").toString();
				return str;
			}
			
			
		} catch (Exception e) {

		}*/
		return str;

	}
	
	//国际
	public String[] getInterSegmenentByOrderid(long orderid) {

		
		
		List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderid, " ORDER BY ID ", -1, 0);
		if (listseg.size() > 0) {
		String[] str = new String[3];
		if(listseg.size()==1){//直飞
			if(listseg.get(0).getFlightnumber()!=null){
			str[0]=listseg.get(0).getFlightnumber();
			}else{
			str[0]="";	
			}
			if(listseg.get(0).getStartairport()!=null&&listseg.get(0).getEndairport()!=null){
				str[1]=getCitynameByAirport(listseg.get(0).getStartairport())+"-"+getCitynameByAirport(listseg.get(0).getEndairport());
				}else{
				str[1]="";	
			}
			
			if(listseg.get(0).getDeparttime()!=null){
				str[2]=listseg.get(0).getDeparttime()+"";
				}else{
				str[2]="";	
			}
		}else{//转机
				int len=listseg.size();
				if(listseg.get(0).getFlightnumber()!=null){
				str[0]=listseg.get(0).getFlightnumber();
				}else{
				str[0]="";	
				}
				if(listseg.get(0).getStartairport()!=null&&listseg.get(len-1).getEndairport()!=null){
					str[1]=getCitynameByAirport(listseg.get(0).getStartairport())+"-"+getCitynameByAirport(listseg.get(len-1).getEndairport());
					}else{
					str[1]="";	
				}
				
				if(listseg.get(0).getDeparttime()!=null){
					str[2]=listseg.get(0).getDeparttime()+"";
					}else{
					str[2]="";	
				}
			
			
		}
		
		return str;
		}
		return null;

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
		if(list.size()>0){
			if(list.get(0).getCityname()!=null){
				return list.get(0).getCityname();
			}else{
				return "";
			}
			
		}else{
			String whereinter = "where " + Fcity.COL_citycode + "='" + airport
			+ "'";
				List<Fcity> listinter = Server.getInstance().getInterticketService()
						.findAllFcity(whereinter, "ORDER BY ID", -1, 0);
				if(listinter.size()>0){
					if(listinter.get(0).getCityname()!=null){
						return listinter.get(0).getCityname();
					}else{
						return "";
					}
					
				}
			
		}
		
		return "";
	}
	public List GetAgentTelQQ(Long id) {
		
		List<String> lists = new ArrayList<String>();
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(id);
		String tel="";
		String QQ="";
		String name="";
		if(customeragent!=null){
			if(customeragent.getAgentphone()!=null){
				tel=customeragent.getAgentphone();
			}
			if(customeragent.getMsnqq()!=null){
				QQ=customeragent.getMsnqq();
			}
			if(customeragent.getAgentshortname()!=null&&customeragent.getAgentshortname().length()>0){
				name=customeragent.getAgentshortname();
			}else{
				name=customeragent.getAgentcompanyname();
			}
		}
		
		
		lists.add(tel);
		lists.add(QQ);
		lists.add(name);
		return lists;
	}

	public List getPassengerNamehtml(Long orderid, String fdstr) {
		//System.out.println("fdstr:"+fdstr);
		List<String> lists = new ArrayList<String>();
		String html = "";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_orderid + "="
								+ orderid + " AND C_STATE<>12", "", -1, 0);
		List<Passenger> newlist = Server.getInstance().getAirService()
		.findAllPassenger(
				"WHERE 1=1 AND " + Passenger.COL_orderid + "="
						+ orderid + " AND C_STATE<>12 and "+Passenger.COL_ptype+" =1", "", -1, 0);
		//陈鑫修改  该list要去除成人
		int newsize=newlist.size();
		
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {
				html += list.get(i).getName() + "<br/>";
				
			}
			html += list.get(list.size() - 1).getName();
		}
		lists.add(html);
		String reb="";
		try {
			if (fdstr != null && !fdstr.equals("")&&!fdstr.equals("0.0")&&fdstr.length()>5) {
				float[] moneys = this.getNationTicketrebat(fdstr, newsize);
				//lists.add((moneys[0] + moneys[1]) + "");//带保险的
				if(moneys!=null&&moneys.length>0){
				reb=(moneys[0])+"";
				}
				//lists.add((moneys[0]) + "");//不带保险的
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lists.add(reb);
		
		
		
		
		//System.out.println("lists:"+lists);
		return lists;
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
	 * 
	 * @param pnr
	 * @return
	 */
	public String toCreateOrderByPnr() {
		List list = Server.getInstance().getTicketSearchService()
				.getOrderbypnr(order_pnr);
		if (list != null && list.size() == 4) {
			try {
				pnrstr = (String) list.get(0);
				listSegment = (List<Segmentinfo>) list.get(1);
				listOrderinfo = (List<Orderinfo>) list.get(2);
				listPassenger = (List<Passenger>) list.get(3);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("接口服务返回pnr信息错误" + e.toString());
			}
		}
		return "orderbypnr";
	}

	/**
	 * 提取PNR信息
	 */
	public void rtPNRinfo() throws Exception {
		String strReturn = Server.getInstance().getTicketSearchService()
				.getPNRInfo(strPNR);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
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
	//授权
	public void ShouQuan() throws Exception {
		System.out.println("shouquan");
		Orderinfo orderinfopnr = Server.getInstance().getAirService()
				.findOrderinfo(s_orderid);
		String strReturn = "";
		if (orderinfopnr.getPnr() != null
				&& !orderinfopnr.getPnr().equals("NOPNR")) {
			
			
			
			String sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr(), "", "");
			System.out.println("sub:"+sub);
			String ig="";
			if(sub.indexOf("授权")!=-1){
				ig="back";
				sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR, "", ig);
			}
			
			String FK="\\"; //封口
			String te=	Server.getInstance().getTicketSearchService().commandFunction2("RMK TJ AUTH "+officecode+"\r"+FK+"", "", ig);
			//Server.getInstance().getTicketSearchService().commandFunction2(FK, "", "");
			System.out.println("TE:"+te);
			String sub2=Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr(), "", ig);
			if(sub2.indexOf("需要封口(@)或还原(IG)")!=-1){
				Server.getInstance().getTicketSearchService().commandFunction2("RT"+orderinfopnr.getPnr()+"$IG", "", ig);
			}
			if(te.indexOf("航空公司使用自动出票时限")!=-1){
				strReturn="ok";
				insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了授权操作!OFFICE:"+officecode.toString());
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
	//单独分离PNR
	public void fenlipnr() throws Exception {
		System.out.println("fenlipnr");
		Orderinfo orderinfopnr = Server.getInstance().getAirService()
				.findOrderinfo(s_orderid);
		String ret = "";
		String strNewPnr="";
		String strNewBigPnr="";
		if (orderinfopnr.getPnr() != null
				&& !orderinfopnr.getPnr().equals("NOPNR")) {
			
			insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了分离PNR操作!序号:"+officecode.toString());
			
				String strReturn = Server.getInstance().getTicketSearchService().SPPNR(orderinfopnr.getPnr(),officecode.toString());
				System.out.println("strReturn:"+strReturn);
				insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了分离PNR操作!返回:"+strReturn);
				if (strReturn.length() > 0 && strReturn.indexOf("SPLIT FROM") >= 0) {
					// 对黑屏返回值进行解析
					Pattern pattern = Pattern.compile("[\\r\\n]");
					// 以换行符将字符串拆分
					String[] strarr = pattern.split(strReturn);

					for (int i = 0; i < strarr.length; i++) {
						if (strarr[i].indexOf("SPLIT FROM") >= 0) {
							Pattern pDetails = Pattern.compile("\\s{1,2}");
							String[] strPnrarr = pDetails.split(strarr[i]);
							for (int j = 0; j < strPnrarr.length; j++) {
								if (strPnrarr.length == 4) {
									strNewPnr = strPnrarr[0];
									// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
									// strNewBigPnr =
									//strNewBigPnr=Server.getInstance().getTicketSearchService().getBigPNRInfo(strNewPnr);
									// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
									
								}
							}
							insertOrderinforc(orderinfopnr, getLoginUser().getLoginname()+"执行了分离PNR操作!新PNR:"+strNewPnr);
						}
					}
				}
			//开始拆单
				if(1==2){
				// 将分离的乘机人从原订单更改状态
				// 废票分离
			
					// 计算保险分数
					List<Passenger> listpasscount = Server.getInstance()
							.getAirService().findAllPassenger(
									" WHERE C_ORDERID=" + strTuiOrderID + " and "
											+ Passenger.COL_state + "<>12", "", -1, 0);

					List<Passenger> listpass = new ArrayList<Passenger>();
					String tkprice="";
					// 插入新订单信息
					Orderinfo ordermodel = Server.getInstance().getAirService()
							.findOrderinfo(Long.parseLong(strTuiOrderID));
					ordermodel.setReturnprice(Float.valueOf(converNull(tkprice, "0")));
					ordermodel.setRelationorderid(ordermodel.getId());
					ordermodel.setId(-1l);
					ordermodel.setOrdernumber("");
					ordermodel.setPnr(strNewPnr);
					ordermodel.setIsbackinsur(orderinfo.getIsbackinsur());
					ordermodel.setBigpnr(strNewBigPnr);
					// 更新新订单价格信息
					String s_newpassid="";
					
					String[] strpidsarr = s_newpassid.split(strSubSplit);
					float doutotpricenew = 0f;
					float doufuelpricenew = 0f;
					float douairpricenew = 0f;
					float insurprice = 0f;
					String insurid = "";
					for (int i = 0; i < strpidsarr.length; i++) {
						long id = Long.parseLong(strpidsarr[i]);
						Passenger passenger = Server.getInstance().getAirService()
								.findPassenger(id);

						insurprice += passenger.getInsurprice();
						listpass.add(passenger);
						passenger.setState(12);
						passenger.setBeizhu("此乘机人已经被分离!");
						int intcount = Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(passenger);
						doutotpricenew += passenger.getPrice();
						doufuelpricenew += passenger.getFuelprice();
						douairpricenew += passenger.getAirportfee();

					}
					ordermodel.setTotalticketprice(doutotpricenew);
					ordermodel.setTotalfuelfee(doufuelpricenew);
					ordermodel.setTotalairportfee(douairpricenew);
					// 保险现在乘机人表里面没有存，暂时分离的时候就认为这个人有份保险
					String operatedesc = "";
					if (tuigaiindex.equals("1")) {
						ordermodel.setOrderstatus(11); // 废票成功
						operatedesc = "废票审核通过-";

					} else if (tuigaiindex.equals("2")) {
						ordermodel.setOrderstatus(12); // 退票成功
						operatedesc = "退票审核通过-";
					} else if (tuigaiindex.equals("3")) {
						ordermodel.setOrderstatus(14); // 改签成功
						operatedesc = "改签审核通过-";
					}
					Orderinfo orderold = Server.getInstance().getAirService()
							.findOrderinfo(Long.parseLong(strTuiOrderID));
					// 数据库中插入新订单
					ordermodel.setUserid(0l);
					ordermodel.setOperatingstate(-1l);
					ordermodel = Server.getInstance().getAirService().createOrderinfo(
							ordermodel);
					System.out.println(ordermodel.getId());
					// 更新订单订单号
					// 插入操作记录：
					operatedesc += getLoginUser().getMembername() + "执行了退票操作，订单状态为"
							+ getStateToString(ordermodel.getOrderstatus());
					this.insertOrderinforc(ordermodel, operatedesc);
					// 更改申请操作记录为新订单
					String sql = "UPDATE T_ORDERINFORC SET C_ORDERINFOID="
							+ ordermodel.getId() + " WHERE C_ORDERINFOID="
							+ strTuiOrderID + " AND C_STATE IN(4,5,11,12)";
					Server.getInstance().getSystemService().findMapResultBySql(sql,
							null);

					orderold.setRelationorderid(ordermodel.getId());

					orderold.setOrderstatus(orderold.getOldorderstatus()); // 还原原订单状态。

					// 旧订单价格信息
					orderold.setTotalticketprice(orderold.getTotalticketprice()
							- doutotpricenew);
					orderold.setTotalairportfee(orderold.getTotalairportfee()
							- douairpricenew);
					orderold.setTotalfuelfee(orderold.getTotalfuelfee()
							- doufuelpricenew);
					// 保险暂不退 请勿删除
					// try{
					// String backinfo=orderold.getBackpointinfo();
					// int index=backinfo.indexOf(1);
					// String money=backinfo.substring(index+1);
					// float lastmoney=Float.valueOf(money)-insurprice;
					// backinfo.replace("|"+money, "|"+lastmoney);
					// }catch(Exception e){//
					// }
					// 更新旧订单管理订单号
					Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
							orderold);
					// 插入新订单航程信息
					// 得到航程ID
					List<Segmentinfo> listsegmentinfo = Server.getInstance()
							.getAirService().findAllSegmentinfo(
									" WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
					if (listsegmentinfo.size() > 0) {
						Segmentinfo segmengtinfo = listsegmentinfo.get(0);
						segmengtinfo.setId(-1l);
						segmengtinfo.setOrderid(ordermodel.getId());
						segmengtinfo = Server.getInstance().getAirService()
								.createSegmentinfo(segmengtinfo);
						for (int i = 0; i < listpass.size(); i++) {
							Passenger passeng = listpass.get(i);
							// 插入新订单乘机人信息
							if (tuigaiindex.equals("1")) {
								passeng.setState(2); // 废票成功
							} else if (tuigaiindex.equals("2")) {
								passeng.setState(3);// 退票成功
							} else if (tuigaiindex.equals("3")) {
								passeng.setState(9);// 退票成功
							}
							if (!isNotNullOrEpt(tui)) {
								tui = "0";
							}
							passeng.setTuifee(Float.valueOf(tui));
							passeng.setBeizhu("分离新订单");
							passeng.setOrderid(ordermodel.getId());
							passeng.setId(-1l);
							passeng = Server.getInstance().getAirService()
									.createPassenger(passeng);
							if (converNull(passeng.getMsgtype(), 0) == 3) {
								this.sendTFMsgtoPassenger(passeng);
							}
						}

					}
				}
			//拆单结束
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strNewPnr);
			out.print(sb);
			out.flush();
			out.close();
		}
	}

	public void ajaxSendTFMsg() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String passid = request.getParameter("passengerids");
		String msgtypestr = request.getParameter("msgtypes");
		String linktype = request.getParameter("linkmsgtype");

		String[] passenger = passid.split(strSubSplit);
		String[] msgtypes = msgtypestr.split(strSubSplit);
		List<Passenger> passengers = new ArrayList<Passenger>();
		if (passenger.toString().trim().length() > 0) {

			for (int a = 0; a < passenger.length; a++) {
				long paid = Long.parseLong(passenger[a]);
				String msgtype = msgtypes[a];
				if (msgtype.equals("4")) {
					Passenger pg = Server.getInstance().getAirService()
							.findPassenger(paid);
					this.sendTFMsgtoPassenger(pg);
				}

			}
		}
		if (linktype.equals("4")) {
			this.sendTFMsgtoLinkUser(passengers);
		}
	}

	// 得到分离乘机人信息
	public void getPassengersqListsep() throws Exception {
		String strReturn = "";
		Orderinfo listorder = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		String strPPNR = "";
		if (listorder.getPnr() != null && !listorder.getPnr().equals("")) {
			strPPNR = listorder.getPnr();
		} else if (listorder.getBigpnr() != null
				&& !listorder.getBigpnr().equals("")) {
			strPPNR = listorder.getBigpnr();
		}
		strReturn += "<fieldset><legend>订单信息</legend> ";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td width='30%' align='left'><intput type='text' id='hidseporderid' name='strTuiOrderID' value='"
				+ strTuiOrderID
				+ "' /><b>订单号：</b>"
				+ listorder.getOrdernumber()
				+ "</td><td width='70%' rowspan='3'><div id='pnrinfo' style='text-align:left;background-color: Black; color: #00ff00; height: 123px; width: 98%; margin: 0 auto; overflow: auto;'>请选提取PNR并确认乘机人在PNR中的序号！</div></td></tr>";
		strReturn += "<tr><td align='left'><b>PNR：</b><input type='text' id='txtpnrcode' style='width:60px' value='"
				+ strPPNR
				+ "' />&nbsp;&nbsp;<input type='button' id='btnpnr' onclick='rTPnr();' class='button108' value='提取PNR' /></td></tr>";
		strReturn += "<tr><td align='left'><b>创建时间：</b>"
				+ formatTimestampHHmm2(listorder.getCreatetime())
				+ "</td></tr>";
		strReturn += "</table>";
		strReturn += "</fieldset>";
		if (typ == 4) {
			strReturn += "<fieldset><legend>乘机人信息</legend>";
		}
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td><input type='hidden' id='checkboxflag' value='0' /><input style='display:none' type='checkbox' id='chkpassenger1_all' onclick='checkallbox();'></td><td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " and "
				+ Passenger.COL_state + "<>12";
		String strXuhaonumbers = "";
		int inti = 0;
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		System.out.println(passid);
		for (int i = 0; i < listpassenger.size(); i++) {
			String strFlag = "";
			String strBkcolor = "";
			if (passid.indexOf(listpassenger.get(i).getId() + "") >= 0) {
				strFlag = "checked='checked'";
				strBkcolor = "style='background-color:#ffffee'";
				inti = i + 1;
				strXuhaonumbers += inti + "/";
			}
			strReturn += "<tr " + strBkcolor + ">";
			strReturn += "<td align='center'><input type='hidden' id='txtpassid_"
					+ i
					+ "' value='"
					+ listpassenger.get(i).getId()
					+ "' /><input type='checkbox' id='chkpassenger_"
					+ i
					+ "' "
					+ strFlag
					+ " disabled='disabled' onclick='setpassid("
					+ i
					+ ");'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}

			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(converNull(listpassenger.get(i)
							.getAnjianfee(), 0f))
					+ "</td><td>"
					+ formatMoney(converNull(
							listpassenger.get(i).getOtherfee(), 0f)) + "</td>";

			strReturn += "</tr>";
		}
		strReturn += "</tbody>";
		strReturn += "</table>";
		strReturn += "</fieldset>";
		if (passid.split(strSubSplit).length != listpassenger.size()) {
			strReturn += "<fieldset><legend>乘机人分离操作</legend> ";
		} else {
			strReturn += "<fieldset><legend>乘机人退票操作</legend> ";
		}

		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		if (passid.split(strSubSplit).length != listpassenger.size()) {
			strReturn += "<tr><td colspan='3'><input type='radio'  id='rdoheipingfenli'  name='fenlitype' value='3' />自动分离&nbsp;&nbsp;<input type='radio' id='rdobaipingfenli' checked='checked' onclick='shownewpnr();' name='fenlitype' value='2' />手动分离&nbsp;&nbsp;<span id='span_newpnrinfo'>分离新PNR(小)<input type='text' id='txtnewpnr' style='width:60px' name='strNewPnr' /><font style='color:red'>*</font>&nbsp;&nbsp;分离新PNR(大)<input type='text' id='txtnewbigpnr' style='width:60px' name='strNewBigPnr' /><font style='color:red'>*</font></span></td></tr>";
		} else {
			strReturn += "<tr><td colspan='3'></td></tr>";
		}
		String strBName = "分离";
		String strAName = "全部废退";
		if (tuigaiindex.equals("1")) {
			strBName = "分离并废票";
			strAName = "全部废票";
		} else if (tuigaiindex.equals("2")) {
			strBName = "分离并退票";
			strAName = "全部退票";
		} else if (tuigaiindex.equals("3")) {
			strBName = "分离并改签";
			strAName = "全部改签";
		} else if (tuigaiindex.equals("14")) {
			strBName = "分离并升舱";
			strAName = "全部升舱";
		}
		if (passid.split(strSubSplit).length != listpassenger.size()) {
			strReturn += "<tr id='trparpnrsep'><td align='left'><span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请输入待分离乘机人的序号，必须要与黑屏PNR中的序号一致,否则将分离错误！</span></td><td><input type='text' id='txtxuhao' style='width:50px' value='"
					+ strXuhaonumbers
							.substring(0, strXuhaonumbers.length() - 1)
					+ "'  /></td><td align='right'><input type='hidden' id='hidpassengerid' style='width:50px' value='"
					+ passid
					+ "' name='s_newpassid'><input class='button_d font-bai' value='"
					+ strBName
					+ "' onclick='sepratePnr("
					+ tuigaiindex
					+ ");' type='button' /> </td></tr>";
		} else {
			strReturn += "<tr id='trallpnrsep'><td align='left'><span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;如果此订单中的所有乘机人都要退/改/废票，请选择"
					+ strAName
					+ ",否则将不能执行成功！</span></td><td colspan='2' align='right'><input class='button_d font-bai' value='"
					+ strAName
					+ "' onclick='alltuifeiticket("
					+ strTuiOrderID
					+ "," + tuigaiindex + ");' type='button' /></td></tr>";
		}
		strReturn += "</table>";
		strReturn += "</fieldset>";
		strReturn += "<input type='hidden' id='txttuifee' value='" + tui
				+ "'/>";
		String returnprice = ServletActionContext.getRequest().getParameter(
				"returnprice");
		System.out.println(orderinfo.getIsbackinsur());
		strReturn += "<input type='hidden' id='ordertfprice' value='"
				+ returnprice
				+ "'/><input type='hidden' id='backinsur' value='"
				+ orderinfo.getIsbackinsur() + "'/>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * @throws Exception
	 *             分离PNR
	 */
	public void sepratePNR() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String strfenliType = request.getParameter("strfenliType");
		String strXuNumber = request.getParameter("strXuNumber");
		String strNewPnr = request.getParameter("strNewPnr");
		String strNewBigPnr = request.getParameter("strNewBigPnr");
		String s_newpassid = request.getParameter("s_newpassid");
		String tui = request.getParameter("tui");
		String tkprice = request.getParameter("returnprice");
		String fenlinewpnr="";
		if (strfenliType.equals("1")) {
			String strReturn = Server.getInstance().getTicketSearchService().SPPNR(strSepPNR,strXuNumber);
			WriteLog.write("申请退废改签分离记录", "PNR:"+strSepPNR+",序号:"+strXuNumber+",返回:"+strReturn);
			System.out.println("strReturn:"+strReturn);
			if (strReturn.length() > 0 && strReturn.indexOf("SPLIT FROM") >= 0) {
				// 对黑屏返回值进行解析
				Pattern pattern = Pattern.compile("[\\r\\n]");
				// 以换行符将字符串拆分
				String[] strarr = pattern.split(strReturn);

				for (int i = 0; i < strarr.length; i++) {
					if (strarr[i].indexOf("SPLIT FROM") >= 0) {
						Pattern pDetails = Pattern.compile("\\s{1,2}");
						String[] strPnrarr = pDetails.split(strarr[i]);
						for (int j = 0; j < strPnrarr.length; j++) {
							if (strPnrarr.length == 4) {
								strNewPnr = strPnrarr[0];
								fenlinewpnr=strPnrarr[0];
								// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
								// strNewBigPnr =
								// Server.getInstance().getTicketSearchService().getBigPNRInfo(strNewPnr);
								// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
							}
						}
					}
				}
			}
		}

		// 将分离的乘机人从原订单更改状态
		// 废票分离
		if (s_newpassid.length() > 1) {
			// 计算保险分数
			List<Passenger> listpasscount = Server.getInstance()
					.getAirService().findAllPassenger(
							" WHERE C_ORDERID=" + strTuiOrderID + " and "
									+ Passenger.COL_state + "<>12", "", -1, 0);

			List<Passenger> listpass = new ArrayList<Passenger>();
			// 插入新订单信息
			Orderinfo ordermodel = Server.getInstance().getAirService()
					.findOrderinfo(Long.parseLong(strTuiOrderID));
			ordermodel.setReturnprice(Float.valueOf(converNull(tkprice, "0")));
			ordermodel.setRelationorderid(ordermodel.getId());
			ordermodel.setId(-1l);
			ordermodel.setOrdernumber("");
			ordermodel.setPnr(strNewPnr);
			ordermodel.setIsbackinsur(orderinfo.getIsbackinsur());
			ordermodel.setBigpnr(strNewBigPnr);
			// 更新新订单价格信息
			String[] strpidsarr = s_newpassid.split(strSubSplit);
			float doutotpricenew = 0f;
			float doufuelpricenew = 0f;
			float douairpricenew = 0f;
			float insurprice = 0f;
			String insurid = "";
			for (int i = 0; i < strpidsarr.length; i++) {
				long id = Long.parseLong(strpidsarr[i]);
				Passenger passenger = Server.getInstance().getAirService()
						.findPassenger(id);

				insurprice += passenger.getInsurprice();
				listpass.add(passenger);
				passenger.setState(12);
				passenger.setBeizhu("此乘机人已经被分离!");
				int intcount = Server.getInstance().getAirService()
						.updatePassengerIgnoreNull(passenger);
				doutotpricenew += passenger.getPrice();
				doufuelpricenew += passenger.getFuelprice();
				douairpricenew += passenger.getAirportfee();

			}
			ordermodel.setTotalticketprice(doutotpricenew);
			ordermodel.setTotalfuelfee(doufuelpricenew);
			ordermodel.setTotalairportfee(douairpricenew);
			// 保险现在乘机人表里面没有存，暂时分离的时候就认为这个人有份保险
			String operatedesc = "";
			if (tuigaiindex.equals("1")) {
				ordermodel.setOrderstatus(11); // 废票成功
				operatedesc = "废票审核通过-";

			} else if (tuigaiindex.equals("2")) {
				ordermodel.setOrderstatus(12); // 退票成功
				operatedesc = "退票审核通过-";
			} else if (tuigaiindex.equals("3")) {
				ordermodel.setOrderstatus(14); // 改签成功
				operatedesc = "改签审核通过-";
			}
			Orderinfo orderold = Server.getInstance().getAirService()
					.findOrderinfo(Long.parseLong(strTuiOrderID));
			// 数据库中插入新订单
			ordermodel.setUserid(0l);
			ordermodel.setOperatingstate(-1l);
			ordermodel = Server.getInstance().getAirService().createOrderinfo(
					ordermodel);
			System.out.println(ordermodel.getId());
			// 更新订单订单号
			// 插入操作记录：
			operatedesc += getLoginUser().getMembername() + "执行了退票操作，订单状态为"
					+ getStateToString(ordermodel.getOrderstatus());
			this.insertOrderinforc(ordermodel, operatedesc);
			// 更改申请操作记录为新订单
			String sql = "UPDATE T_ORDERINFORC SET C_ORDERINFOID="
					+ ordermodel.getId() + " WHERE C_ORDERINFOID="
					+ strTuiOrderID + " AND C_STATE IN(4,5,11,12)";
			Server.getInstance().getSystemService().findMapResultBySql(sql,
					null);

			orderold.setRelationorderid(ordermodel.getId());

			orderold.setOrderstatus(orderold.getOldorderstatus()); // 还原原订单状态。

			// 旧订单价格信息
			orderold.setTotalticketprice(orderold.getTotalticketprice()
					- doutotpricenew);
			orderold.setTotalairportfee(orderold.getTotalairportfee()
					- douairpricenew);
			orderold.setTotalfuelfee(orderold.getTotalfuelfee()
					- doufuelpricenew);
			// 保险暂不退 请勿删除
			// try{
			// String backinfo=orderold.getBackpointinfo();
			// int index=backinfo.indexOf(1);
			// String money=backinfo.substring(index+1);
			// float lastmoney=Float.valueOf(money)-insurprice;
			// backinfo.replace("|"+money, "|"+lastmoney);
			// }catch(Exception e){//
			// }
			// 更新旧订单管理订单号
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderold);
			// 插入新订单航程信息
			// 得到航程ID
			List<Segmentinfo> listsegmentinfo = Server.getInstance()
					.getAirService().findAllSegmentinfo(
							" WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
			if (listsegmentinfo.size() > 0) {
				Segmentinfo segmengtinfo = listsegmentinfo.get(0);
				segmengtinfo.setId(-1l);
				segmengtinfo.setOrderid(ordermodel.getId());
				segmengtinfo = Server.getInstance().getAirService()
						.createSegmentinfo(segmengtinfo);
				for (int i = 0; i < listpass.size(); i++) {
					Passenger passeng = listpass.get(i);
					// 插入新订单乘机人信息
					if (tuigaiindex.equals("1")) {
						passeng.setState(2); // 废票成功
					} else if (tuigaiindex.equals("2")) {
						passeng.setState(3);// 退票成功
					} else if (tuigaiindex.equals("3")) {
						passeng.setState(9);// 退票成功
					}
					if (!isNotNullOrEpt(tui)) {
						tui = "0";
					}
					passeng.setTuifee(Float.valueOf(tui));
					passeng.setBeizhu("分离新订单");
					passeng.setOrderid(ordermodel.getId());
					passeng.setId(-1l);
					passeng = Server.getInstance().getAirService()
							.createPassenger(passeng);
					if (converNull(passeng.getMsgtype(), 0) == 3) {
						this.sendTFMsgtoPassenger(passeng);
					}
				}

			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strNewPnr);
		out.print(sb);
		out.flush();
		out.close();
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
	 * 通过pnr预订界面创建订单
	 * 
	 * @param pnr
	 * @return
	 */
	public String createOrderByPnr() {
		return "";
	}

	public String getPassTypeToString(Integer id) {
		switch (id) {
		case 1:
			return "成人";
		case 2:
			return "儿童";
		case 3:
			return "婴儿";
		default:
			return "未知类型";
		}
	}

	public String getPayStatus(Integer id) {
		switch (id) {
		case 0:
			return "未支付";
		case 1:
			return "已支付";
		default:
			return "未知状态";
		}
	}

	public String getIDTypeToString(Integer id) {
		switch (id) {
		case 1:
			return "身份证";
		case 2:
			return "驾驶证";
		case 3:
			return "护照";
		case 4:
			return "港澳通行证";
		case 5:
			return "台湾通行证";
		case 6:
			return "台胞证";
		case 7:
			return "回乡证";
		case 8:
			return "军官证";
		default:
			return "其他";
		}
	}

	// 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废票12.已经退票13.申请改签14.已经改签
	public static String getStateToString(Integer id) {
		switch (id) {
		case 0:
			return "待确认";
		case 1:
			return "等待支付";
		case 2:
			return "等待出票";
		case 3:
			return "出票完成";
		case 4:
			return "申请退票";
		case 5:
			return "申请废票";
		case 6:
			return "取消订单";
		case 7:
			return "废票不成功";
		case 8:
			return "审核失败";
		case 9:
			return "废票退款成功";
		case 10:
			return "订单关闭";
		case 11:
			return "废票未退款";
		case 12:
			return "退票未退款";
		case 13:
			return "申请改签";
		case 14:
			return "已经改签";
		case 15:
			return "改签失败";
		case 16:
			return "暂不能出票";
		case 17:
			return "退票不成功";
		case 18:
			return "退票退款成功";
		case 19:
			return "拒单-等待退款";
		case 20:
			return "拒单-已经退款";
		case 23:
			return "申请升舱";
		case 24:
			return "已换开";
		case 25:
			return "升舱换开成功";
		case 26:
			return "升舱失败";
		case 27:
			return "待确认";
		case 28:
			return "在途订单";
		case 29:
			return "待收银";
		case 30:
			return "申请换开";
		case 31:
			return "换开失败";
		default:
			return "";
		}
	}
	public static String getExtStateToString(Integer id) {
		switch (id) {
		case 0:
			return "待确认";
		case 1:
			return "已支付供应";
		case 2:
			return "已支付供应";
		case 3:
			return "出票完成";
		case 4:
			return "申请退票";
		case 5:
			return "申请废票";
		case 6:
			return "取消订单";
		case 7:
			return "废票不成功";
		case 8:
			return "审核失败";
		case 9:
			return "废票退款成功";
		case 10:
			return "订单关闭";
		case 11:
			return "废票未退款";
		case 12:
			return "退票未退款";
		case 13:
			return "申请改签";
		case 14:
			return "已经改签";
		case 15:
			return "改签失败";
		case 16:
			return "暂不能出票";
		case 17:
			return "退票不成功";
		case 18:
			return "退票退款成功";
		case 19:
			return "拒单-等待退款";
		case 20:
			return "拒单-已经退款";
		case 23:
			return "申请升舱";
		case 24:
			return "已换开";
		case 25:
			return "升舱换开成功";
		case 26:
			return "升舱失败";
		case 27:
			return "待确认";
		case 28:
			return "在途订单";
		case 29:
			return "待收银";
		case 30:
			return "申请换开";
		case 31:
			return "换开失败";
		default:
			return "";
		}
	}
	/**
	 * 通过id获取订单
	 * 
	 * @param id
	 * @return
	 */
	public Orderinfo getorderbyid(long id) {
		return Server.getInstance().getAirService().findOrderinfo(id);
	}

	/**
	 * 获取待出票订单数量
	 * 
	 * @return 1，现付 2，预付
	 */
	public String getOrderinfoCount() {
		int count = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		String where = " where 1=1 ";
		where += " and " + Orderinfo.COL_orderstatus + "=" + 2;
		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}
		listOrderinfo = Server.getInstance().getAirService().findAllOrderinfo(
				where, "ORDER BY ID", -1, 0);
		if (listOrderinfo != null && listOrderinfo.size() > 0) {
			count = listOrderinfo.size();
		}
		String zong = count + "," + count2 + "," + count3 + "," + count4;
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(zong);
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();
		return SUCCESS;
	}

	/**
	 * 订单重新选择政策下单
	 */
	public void reCreateOrder() throws Exception {
		String strReturn = "0"; // 0=创建失败，1=创建成功,2=外部订单创建失败，请重试
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(s_orderid);
		List<Passenger> listPassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						" where " + Passenger.COL_orderid + "=" + s_orderid,
						"", -1, 0);
		List<Segmentinfo> listsegmentinfo = Server.getInstance()
				.getAirService().findAllSegmentinfo(
						" where " + Segmentinfo.COL_orderid + "=" + s_orderid,
						"", -1, 0);
		// 修改旧订单里面的政策信息
		Zrate zrate = Server.getInstance().getAirService().findZrate(zrate_id);
		if (zrate != null) {
			listsegmentinfo.get(0).setAgentid(zrate.getAgentid());
			listsegmentinfo.get(0).setRatevalue(zrate.getRatevalue());
			listsegmentinfo.get(0).setZrateid(zrate.getId());
			orderinfo.setPolicyid(zrate.getId());
			orderinfo.setFenxiaoshangfandian(Getliudianvalue(zrate
					.getRatevalue()));
			orderinfo.setPolicyagentid(zrate.getAgentid());
			orderinfo.setRatevalue(zrate.getRatevalue());
			orderinfo.setExtpolicyid(zrate.getOutid());
			orderinfo
					.setTotalticketprice((listsegmentinfo.get(0).getParvalue() - listsegmentinfo
							.get(0).getParvalue()
							* orderinfo.getFenxiaoshangfandian() / 100)
							* listPassenger.size());
		}
		// 订单状态为
		if (listsegmentinfo.size() > 0
				&& (orderinfo.getOrderstatus() == 1 || orderinfo
						.getOrderstatus() == 2)) {
			// //创建外部订单
			try {
				Server.getInstance().getRateService().CreateOrder(orderinfo,
						listsegmentinfo.get(0), listPassenger);
				strReturn = "1";
			} catch (Exception e) {
				e.printStackTrace();
				strReturn = "2";
			}
		} else {
			// 不能重下订单，创建失败
			strReturn = "0";
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

	/**
	 * @param id
	 * @return 查询PNR
	 */
	public String getpnr(long id) {// 取订单PNR
		Orderinfo info = Server.getInstance().getAirService().findOrderinfo(id);
		String pnr = "";
		String littlepnr = info.getPnr();
		if (littlepnr != null && littlepnr.trim().length() > 0) {
			littlepnr += "[小]";
		} else {
			littlepnr = "";
		}
		String bigpnr = info.getBigpnr();
		if (bigpnr != null && bigpnr.trim().length() > 0) {
			bigpnr += "<br/>[大]";
		} else {
			bigpnr = "";
		}
		return littlepnr + bigpnr;
	}

	public String getCustomerNameById(long cid) {
		String strMemberName = "";
		try {
			if (Server.getInstance().getMemberService().findCustomeruser(cid) != null) {
				strMemberName = Server.getInstance().getMemberService()
						.findCustomeruser(cid).getMembername();
			}
		} catch (Exception ex) {
			strMemberName = "";
		}

		return strMemberName;

	}

	/**
	 * 判断代理商虚拟账户余额是否可以进行票款支付
	 * 
	 * @param id
	 *            代理商id
	 * @param dticketfee
	 *            总机票费用
	 * @return
	 */
	public void isEnoughVmoney() throws Exception {
		String strReturn = "";
		Customeragent cusomtneragent = Server.getInstance().getMemberService()
				.findCustomeragent(s_agentid);
		if ((Double.parseDouble(converNull(cusomtneragent.getVmoney(), 0) + "") - s_totalpaymoeny) <= 0) {
			strReturn = "1";
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

	private String converTrim(String value, String returnvalue) {
		if (value == null || value.trim().length() == 0) {
			return returnvalue;
		}
		return value;
	}

	public void getFlightStopinfo() throws Exception {
		// FF:CZ3784/10AUG11
		// WNZ 1225 738
		// WUH 1350 1445
		// KWE 1605
		String strReturn = "";
		String strHtml = "";
		
		String strcmd = "FF:/" + FF_FlightNumber + "/" + ChangeDateMode(FF_date);
		strReturn = Server.getInstance().getTicketSearchService()
				.commandFunction2(strcmd, "", "");
		Pattern pattern = Pattern.compile("[\\r\\n]");
		String[] strStoparr = pattern.split(strReturn);

		String strStop = "";
		String strStopcity = "";
		String strSTime = "";
		String strETime = "";
		if (strStoparr.length >= 2) {
			//strStop = strStoparr[2];//原始的为2
			strStop = strStoparr[3];//罗总用乐途放大的为3
			//返回格式为
			//请参考指令AV:航班号 / PLEASE REFER FUNCTION AV:FLIGHT NUMBER
			//FF:SC4934/16NOV13   
			//NNG           2025     738  
			//WUH   2205    2255      
			//TNA   0020+
			Pattern rpinfo = Pattern.compile("\\s");
			String[] strstopinfo = rpinfo.split(strStop);
			if (strstopinfo.length >= 2) {
				String strinfo = "";
				for (int i = 0; i < strstopinfo.length; i++) {
					if (strstopinfo[i].trim().length() > 0) {
						strinfo += strstopinfo[i].trim() + ",";
					}
				}
				strstopinfo = strinfo.split(strSubSplit);
				strStopcity = getAirnamebySZM(strstopinfo[0]);
				strSTime = strstopinfo[1];
				strSTime = strSTime.substring(0, 2)+":"+strSTime.substring(2, 4);
				strETime = strstopinfo[2];
				strETime = strETime.substring(0, 2)+":"+strETime.substring(2, 4);
				strHtml += "<table width='226' border='0'>";
				strHtml += "<tr>";
				strHtml += "<td width='108' align='right'>经停次数：</td>";
				strHtml += "<td width='108' align='left'>" + FF_StopNum
						+ "次</td>";
				strHtml += "</tr>";
				strHtml += "<tr>";
				strHtml += "<td align='right'>经停地点：</td>";
				strHtml += "<td align='left'>" + strStopcity + "</td>";
				strHtml += "</tr>";
				strHtml += "<tr>";
				strHtml += "<td align='right'>经停时间：</td>";
				strHtml += "<td align='left'>" + strSTime + "-" + strETime
						+ "</td>";
				strHtml += "</tr>";
				strHtml += "</table>";
			}

		} else {
			strHtml = strReturn;
		}
		
		
		/*String sub=Server.getInstance().getRateService().JTsearch(FF_FlightNumber, FF_date);
		
		if(sub!=null&&!sub.equals("-1")&&sub.length()>0&&sub.indexOf("@")!=-1){
			
			String[] cityname=sub.split("@");
			
			
			strHtml += "<table width='226' border='0'>";
			strHtml += "<tr>";
			strHtml += "<td width='108' align='right'>经停次数：</td>";
			strHtml += "<td width='108' align='left'>" + FF_StopNum
					+ "次</td>";
			strHtml += "</tr>";
			strHtml += "<tr>";
			strHtml += "<td align='right'>经停地点：</td>";
			strHtml += "<td align='left'>" + cityname[0] + "</td>";
			strHtml += "</tr>";
			strHtml += "<tr>";
			strHtml += "<td align='right'>经停时间：</td>";
			strHtml += "<td align='left'>" + cityname[1]
					+ "</td>";
			strHtml += "</tr>";
			strHtml += "</table>";
			
		}*/
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strHtml);
		out.print(sb);
		out.flush();
		out.close();
	}

	
	/**
	 * 新生成订单方法
	 * 
	 * @throws Exception
	 */
	public String CreateOrder_Old(List<Segmentinfo> listsegmenginfo,
			List<Passenger> listpassenger, Orderinfo orderinfo,
			List<Long> zratelist, String insurances) throws Exception {
		String strReturn = "NOPNR";
		// 是否黑屏帐号创建PNR，1=使用HGH133黑屏帐号创建PNR,2=使用51book接口创建PNR
		int intCreatePNRType = 1;
		// 是否生成PNR
		int intIsCreatePNR = 0;
		// 是否生成外部订单
		int intIsCreateOuterOrder = 0;
		// 是否按照原政策信息已经生成外部订单
		int intIsCreated = 0;
		// 最优政策
		Zrate bestzrate = new Zrate();
		String[] bxcounts = insurances.trim().split(strSubSplit);
		try {
			// 订单list
			List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();

			int iVa = 1;// 只给一个表单加入平台费
			int intsegmentsize = listsegmenginfo.size();
			/** ****************循环航程list,并创建订单开始************************ */
			for (int s = 0; s < intsegmentsize; s++) {
				Segmentinfo segmentinfo = listsegmenginfo.get(s);
				/** ***订单信息赋值开始*********************************************************** */
				orderinfo = new Orderinfo();
				/** **本地政策赋值开始**************************************** */
				Zrate zrate = Server.getInstance().getAirService().findZrate(
						zratelist.get(s));
				orderinfo.setPolicyid(zrate.getId());// 政策ID
				orderinfo
						.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(zrate
								.getRatevalue())));// 分销商返点
				orderinfo.setPolicyagentid(zrate.getAgentid());// 政策提供商id
				orderinfo.setRatevalue(dceimalFormat(zrate.getRatevalue()));// 折扣
				orderinfo.setExtpolicyid(zrate.getOutid()); // 外部政策id
				segmentinfo.setAgentid(zrate.getAgentid());
				segmentinfo.setRatevalue(zrate.getRatevalue());
				segmentinfo.setZrateid(zrate.getId());
				segmentinfo.setLanguage(0);
				segmentinfo.setZrate(zrate);
				/** **本地政策赋值结束**************************************** */

				/** **订单信息赋值结束*********************************************************** */
				float subfuelfee = 0;
				float subairportfee = 0;
				float subprice = 0;
				/** **乘机人信息赋值开始*********************************************************** */
				for (int i = 0; i < listpassenger.size(); i++) {
					if (listpassenger.get(i).getName().trim().length() > 0) {
						Passenger passenger = listpassenger.get(i);
						if (passenger.getPtype() == 1) {
							passenger.setPrice(segmentinfo.getPrice());
							passenger
									.setAirportfee(segmentinfo.getAirportfee());
							passenger.setFuelprice(segmentinfo.getFuelfee());
						} else if (passenger.getPtype() == 2) {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(getRoundPrice(segmentinfo
									.getFuelfee(), 2));
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo
										.getParvalue(), 2));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo
										.getYprice(), 2));
							}
						} else {
							passenger.setAirportfee(0f);
							passenger.setFuelprice(0f);
							// 儿童婴儿价
							if (segmentinfo.getDiscount() > 100) {
								passenger.setPrice(getRoundPrice(segmentinfo
										.getParvalue(), 10));
							} else {
								passenger.setPrice(getRoundPrice(segmentinfo
										.getYprice(), 10));
							}
						}
						subprice += passenger.getPrice();
						subfuelfee += passenger.getFuelprice();
						subairportfee += passenger.getAirportfee();
						passenger.setDiscount(segmentinfo.getDiscount());
					}
				}
				/** **乘机人信息赋值结束*********************************************************** */
				if (intIsCreatePNR == 1) {
					if (intCreatePNRType == 1) {
						s_returnpnr = Server.getInstance()
								.getTicketSearchService().CreatePNRByCmd(
										listsegmenginfo, listpassenger, "");
					} else {
						s_returnpnr = Server.getInstance()
								.getTicketSearchService().CreatePNRByInterFace(
										listsegmenginfo, listpassenger, "");
					}
				} else {
					s_returnpnr = "123456";
				}
				System.out.println("**********************生成的PNR编码："
						+ s_returnpnr);
				// 判断是否生成PNR
				if (s_returnpnr.equals("NOPNR")) {
					strReturn = "NOPNR";
					break;
				}
				// 机建费
				orderinfo.setTotalairportfee(subairportfee);
				// 燃油费
				orderinfo.setTotalfuelfee(subfuelfee);
				// 总机票价格+平台费用
				orderinfo.setTotalticketprice(subprice);// 存入数据库中的数据
				// PNR赋值
				orderinfo.setPnr(s_returnpnr);
				String strBigPNR = "无";

				// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改开始
				// 只有51book才获取大PNR
				/*
				 * if (orderinfo.getPolicyagentid() == 5) { strBigPNR =
				 * Server.getInstance().getTicketSearchService()
				 * .getBigPNRInfo(s_returnpnr); }
				 * orderinfo.setBigpnr(strBigPNR);
				 */
				// 陈星修改,修改时间2011-12-22,修改原因:暂时关闭大PNR提取功能,修改结束
				orderinfo.setPostmoney(0);
				orderinfo.setPassengerlist(listpassenger);
				listOrderinfo.add(orderinfo);
			}
			/** ****************循环航程list,并创建订单结束************************ */

			// 如果生成PNR则创建订单，否则提示创建订单失败
			if (!s_returnpnr.equals("NOPNR")) {
				for (int j = 0; j < listOrderinfo.size(); j++) {
					orderinfo = listOrderinfo.get(j);

					Segmentinfo seginfo = listsegmenginfo.get(j);
					// 如果是其他供应商政策，则不生成外部订单
					if ((orderinfo.getPolicyagentid() == 3
							|| orderinfo.getPolicyagentid() == 5 || orderinfo
							.getPolicyagentid() == 6)
							&& intIsCreateOuterOrder == 1) {
						intIsCreateOuterOrder = 1;
						System.out.println("属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
					} else {
						intIsCreateOuterOrder = 0;
						// 不属于平台政策，则可以直接支付订单
						orderinfo.setOrderstatus(1);
						System.out.println("不属于平台政策：是否创建外部订单："
								+ intIsCreateOuterOrder);
					}
					if (intIsCreateOuterOrder == 1) {
						try {
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfo,
											seginfo,
											orderinfo.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								intIsCreated = 1;
								if (orderinfo.getPolicyagentid() == 5) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfo
														.setExtorderid(strExtOrderArr[1]);
												orderinfo
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else {
									// 外部订单号
									orderinfo.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfo.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfo.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (s_paymethod.equals("2")
										|| s_paymethod.equals("3")) {
									orderinfo.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfo.setOrderstatus(2);
								} else {
									orderinfo.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								intIsCreated = 0;
								System.out.println("按照本地政策，创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
							}
						} catch (Exception ex) {
							intIsCreated = 0;
							System.out.println("按照本地政策，创建外部订单失败，异常结果:"
									+ ex.getMessage());
						}
					}
					// 如果没有按照原始政策，生成外部订单，则按照最优政策信息，再次生成外部订单
					System.out.println("没有按照原始政策生成订单，匹配最优政策，生成外部订单！");
					System.out.println("是否生成外部订单标记：" + intIsCreateOuterOrder
							+ " 是否已按照原始政策生成外部订单：" + intIsCreated);
					if (intIsCreateOuterOrder == 1 && intIsCreated == 0) {
						// 匹配最优政策，并生成外部订单
						try {
							try {
								bestzrate = Server.getInstance()
										.getRateService().FindZrateByFlight(
												orderinfo, seginfo,
												orderinfo.getPassengerlist());
								if (bestzrate != null
										&& bestzrate.getRatevalue() != null
										&& bestzrate.getAgentid() != null) {
									try {
										// 计算价格
										orderinfo
												.setPolicyid(bestzrate.getId());// 政策ID
										orderinfo
												.setFenxiaoshangfandian(dceimalFormat(Getliudianvalue(bestzrate
														.getRatevalue())));// 分销商返点
										orderinfo.setPolicyagentid(bestzrate
												.getAgentid());// 政策提供商id
										orderinfo
												.setRatevalue(dceimalFormat(bestzrate
														.getRatevalue()));// 折扣
										orderinfo.setExtpolicyid(bestzrate
												.getOutid()); // 外部政策id
										System.out.println("调用最优政策方法,成功,政策为=="
												+ bestzrate);
									} catch (RuntimeException e) {
										System.out
												.println("调用最优政策方法,出现异常,异常信息："
														+ e.getMessage());
										e.printStackTrace();
									}
								}

							} catch (RuntimeException e) {
								System.out.println("调用最优政策方法,出现异常,异常信息："
										+ e.getMessage());
								e.printStackTrace();
							}
							seginfo.setZrate(bestzrate);
							// 创建外部订单，方法调用
							String strExtOrderNumber = Server.getInstance()
									.getRateService().CreateOrder(orderinfo,
											seginfo,
											orderinfo.getPassengerlist());
							// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --开始
							if (!strExtOrderNumber.equals("-1")) {
								if (orderinfo.getPolicyagentid() == 5) {
									// 返回格式：S|订单号|支付url
									// 外部订单号

									if (strExtOrderNumber.indexOf("|") > 0) {
										String[] strExtOrderArr = strExtOrderNumber
												.split("[|]");
										if (strExtOrderArr.length == 3) {
											if (strExtOrderArr[0].equals("S")) {
												orderinfo
														.setExtorderid(strExtOrderArr[1]);
												orderinfo
														.setPaymenturl(strExtOrderArr[2]);
											}
										}
									}

								} else {
									// 外部订单号
									orderinfo.setExtorderid(strExtOrderNumber);
								}
								// 外部订单状态
								orderinfo.setExtorderstatus(0);
								// 外部订单创建时间
								orderinfo.setExtordercreatetime(new Timestamp(
										System.currentTimeMillis()));
								// 本地订单状态为待支付
								if (s_paymethod.equals("2")
										|| s_paymethod.equals("3")) {
									orderinfo.setPaystatus(1); // 已支付
									// 门市付款或者票到付款，则订单状态为等待出票
									orderinfo.setOrderstatus(2);
								} else {
									orderinfo.setOrderstatus(1);
								}
								// 如果生成成功，则更新外部订单号，外部政策id,外部订单创建时间 --结束
							} else {
								System.out.println("按照最优政策创建外部订单失败，返回结果:"
										+ strExtOrderNumber);
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("按照最优政策创建外部订单失败，异常信息"
									+ e.getMessage());
						}
					}

					// 计算总利润，以及留点记录信息
					// 成人总数
					int intadult = 0;
					for (int i = 0; i < orderinfo.getPassengerlist().size(); i++) {
						if (orderinfo.getPassengerlist().get(i).getPtype() == 1) {
							intadult++;
						}
					}
					Float fzonglirun = orderinfo.getRatevalue()
							* seginfo.getParvalue() / 100 * intadult;
					int intzonglirun = fzonglirun.intValue();
					orderinfo.setRebatemoney(this.formatfloatMoney(Float
							.parseFloat(intzonglirun + "")));

					// 生成本地订单信息

					orderinfo = Server.getInstance().getAirService()
							.createOrderinfo(orderinfo);
					System.out.println(orderinfo.getOrdernumber());
					System.out.println("订单信息==" + orderinfo);
					System.out.println("订单ID==" + orderinfo.getId());
					System.out.println("外部订单ID==" + orderinfo.getExtorderid());

					Segmentinfo segmentinfo = listsegmenginfo.get(j);
					segmentinfo.setOrderid(orderinfo.getId());
					// 获取新政策，更新航程信息
					// Creater by:sunbin
					// 2011-10-18
					if (bestzrate != null && bestzrate.getRatevalue() != null
							&& bestzrate.getAgentid() != null) {
						Float fsegmentprice = segmentinfo.getParvalue()
								* (1 - Getliudianvalue(bestzrate.getRatevalue()) / 100);
						int intsegmentprice = fsegmentprice.intValue();
						segmentinfo.setAgentid(bestzrate.getAgentid());
						segmentinfo.setRatevalue(bestzrate.getRatevalue());
						segmentinfo.setZrateid(bestzrate.getId());
						segmentinfo.setPrice(Float.parseFloat(String
								.valueOf(intsegmentprice)));
						segmentinfo.setRules(bestzrate.getRemark());
					}
					// 获取新政策，更新航程信息
					// 结束
					segmentinfo = Server.getInstance().getAirService()
							.createSegmentinfo(segmentinfo);

					System.out.println(orderinfo.getPassengerlist().size());
					int l = 0;
					float subpricenew = 0;
					float insurprice = 0f;// 保险价格
					for (Passenger passeng : orderinfo.getPassengerlist()) {
						passeng.setOrderid(orderinfo.getId());
						String bxname = "阳光";
						String bxcount = bxcounts[l];
						// passeng.setInsurance(null);
						if (Integer.valueOf(bxcount) > 0) {
							Insuranceinfo insurance = new Insuranceinfo();
							insurance.setCompanyname(bxname);
							insurance.setInsurancename(bxname + "航空意外保险");
							insurance
									.setCreatetime(dateToTimestamp(formatTimestamp2(segmentinfo
											.getDeparttime())));
							Timestamp tem = new Timestamp(insurance
									.getCreatetime().getTime());
							tem.setDate(tem.getDate() + 7);
							insurance.setEnddate(tem);
							insurance.setToubaoren(passeng.getName());
							insurance.setBeibaoren(passeng.getName());
							insurance.setInsurancenum(Integer.valueOf(bxcount));
							if (segmentTwo != null) {
								if (!new B2bAirSearchAction().isInInsrutime(
										segmentOne.getDeparttime(), segmentTwo
												.getDeparttime())) {
									if (j == 0) {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.ceil(Integer
													.valueOf(bxcount) / 2.0);
										}
										insurance.setInsurancenum(count);
										insurance
												.setInsurancefee(String
														.valueOf(insurance
																.getInsurancenum() * 20));
										insurance = Server.getInstance()
												.getMemberService()
												.createInsuranceinfo(insurance);
										// passeng.setInsurance(insurance.getId());
									} else {
										int count = 1;
										if (Integer.valueOf(bxcount) > 1) {
											count = (int) Math.floor(Integer
													.valueOf(bxcount) / 2.0);
											insurance.setInsurancenum(count);
											insurance
													.setInsurancefee(String
															.valueOf(insurance
																	.getInsurancenum() * 20));
											insurance = Server.getInstance()
													.getMemberService()
													.createInsuranceinfo(
															insurance);
											// passeng.setInsurance(insurance
											// .getId());
										}
									}

								} else {
									if (j == 0) {
										insurance
												.setInsurancefee(String
														.valueOf(insurance
																.getInsurancenum() * 20));
										insurance = Server.getInstance()
												.getMemberService()
												.createInsuranceinfo(insurance);
										// passeng.setInsurance(insurance.getId());
									}
								}
							} else {
								insurance
										.setInsurancefee(String
												.valueOf(insurance
														.getInsurancenum() * 20));
								insurance = Server.getInstance()
										.getMemberService()
										.createInsuranceinfo(insurance);
								// passeng.setInsurance(insurance.getId());

							}
							insurprice += Float.valueOf(converNull(insurance
									.getInsurancefee(), "0"));
						}
						// 获取最优政策，更新乘机人信息
						// Created By:sunbin
						// 2011-10-18
						if (bestzrate != null
								&& bestzrate.getRatevalue() != null
								&& bestzrate.getAgentid() != null) {
							if (passeng.getPtype() == 1) {
								passeng.setPrice(segmentinfo.getPrice());
								passeng.setAirportfee(segmentinfo
										.getAirportfee());
								passeng.setFuelprice(segmentinfo.getFuelfee());
							} else if (passeng.getPtype() == 2) {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(getRoundPrice(segmentinfo
										.getFuelfee(), 2));
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getParvalue(), 2));
								} else {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getYprice(), 2));
								}
							} else {
								passeng.setAirportfee(0f);
								passeng.setFuelprice(0f);
								// 儿童婴儿价
								if (seginfo.getDiscount() > 100) {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getParvalue(), 10));
								} else {
									passeng.setPrice(getRoundPrice(segmentinfo
											.getYprice(), 10));
								}
							}
							subpricenew += passeng.getPrice();
							// 获取最优政策，更新乘机人信息
							// 结束
						}
						Server.getInstance().getAirService().createPassenger(
								passeng);
						l++;
					}

					// 更新订单总价信息
					if (subpricenew != 0f) {
						// 总机票价格+平台费用
						orderinfo.setTotalticketprice(subpricenew);// 存入数据库中的数据
					}
					if (j == 0) {
						this.orderinfo1 = orderinfo;
					} else {
						this.orderinfo2 = orderinfo;
					}
					System.out
							.println("***************************返佣信息**************************************");
					System.out.println(orderinfo.getId());

					System.out.println(orderinfo.getRatevalue());
					String strCustomgeragentBackPointInfo = getCustomerBackPointString(
							getLoginUserAgent(), orderinfo.getRatevalue(),
							Getliudianvalue(orderinfo.getRatevalue()), seginfo
									.getParvalue(), insurprice);
					System.out.println(strCustomgeragentBackPointInfo);
					orderinfo.setFenxiaoshangfandian(Getliudianvalue(orderinfo
							.getRatevalue()));
					orderinfo.setBackpointinfo(strCustomgeragentBackPointInfo);
					Server.getInstance().getAirService()
							.updateOrderinfoIgnoreNull(orderinfo);
				}
				if (orderinfo2.getId() > 0) {
					String sql = "UPDATE T_ORDERINFO SET C_RELATIONORDERID="
							+ orderinfo1.getId() + " WHERE ID="
							+ orderinfo2.getId()
							+ ";UPDATE T_ORDERINFO SET C_RELATIONORDERID="
							+ orderinfo2.getId() + " WHERE ID="
							+ orderinfo1.getId();
					Server.getInstance().getSystemService().findMapResultBySql(
							sql, null);

				}
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zrateone");
				ActionContext.getContext().getSession().remove(
						this.getLoginUserId() + "zratetwo");
				System.out.println(issavepassenger);
				// 是否保存常用乘机人信息
				String[] ArrIsSave = issavepassenger.split(",");
				String strTempPassenger = "";
				for (int i = ArrIsSave.length - 1; i >= 0; i--) {
					strTempPassenger += ArrIsSave[i] + ",";
				}
				String[] ArrIsSaveNew = strTempPassenger.split(",");

				for (int i = 0; i < orderinfo.getPassengerlist().size(); i++) {
					String where = " where 1=1 and "
							+ Customerpassenger.COL_customeruserid
							+ " = "
							+ getLoginUser().getId()
							+ " and "
							+ Customerpassenger.COL_username
							+ " = '"
							+ orderinfo.getPassengerlist().get(i).getName()
									.trim() + "'";

					List<Customerpassenger> list = Server.getInstance()
							.getMemberService().findAllCustomerpassenger(where,
									"", -1, 0);
					// 如果此乘机人已经存在或者是否保存常用登机人选择的是“否”
					if (ArrIsSaveNew[i].equals("0")
							|| (list != null && list.size() > 0)) {
						continue;
					}
					try {
						// 当前登录员工
						Customeruser loginEmployee = getLoginUser();
						Customerpassenger customerpassenger = new Customerpassenger();
						customerpassenger.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customerpassenger.setCreateuser(getLoginUser()
								.getLoginname());
						customerpassenger.setUsername(orderinfo
								.getPassengerlist().get(i).getName().trim());
						customerpassenger.setType(1);
						customerpassenger.setCustomeruserid(loginEmployee
								.getId());
						customerpassenger = Server.getInstance()
								.getMemberService().createCustomerpassenger(
										customerpassenger);
						// 添加证件
						Customercredit customercredit = new Customercredit();
						customercredit.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setCreateuser(loginEmployee
								.getMembername());
						customercredit
								.setCreditnumber(orderinfo.getPassengerlist()
										.get(i).getIdnumber().trim());
						customercredit.setCredittypeid(orderinfo
								.getPassengerlist().get(i).getIdtype());
						customercredit.setModifytime(new Timestamp(System
								.currentTimeMillis()));
						customercredit.setModifyuser(loginEmployee
								.getMembername());
						customercredit.setRefid(customerpassenger.getId());
						customercredit.setType(1);
						Server.getInstance().getMemberService()
								.createCustomercredit(customercredit);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(orderinfo1.getId());
				System.out.println(orderinfo2.getId());
				strReturn = "b2bticketorder!payorder.action?orderinfo.id="
						+ orderinfo1.getId();
			}

			//
		} catch (Exception e) {
			e.printStackTrace();
			strReturn = "ERROR";
		}

		return strReturn;

	}

	/**
	 * 1,2.00,480.0,5.8@46,3.8,480.0,5.8@0|0.0 获取登录者所应看到返点及利润 [0] 返点，[1]利润
	 * 
	 * @param fdstr
	 * @return
	 */
	public float[] getLonginrebate(String fdstr, int people) {
		String[] infos = fdstr.split("@");
		float[] returninfo = new float[2];
		long loginid = this.getLoginUser().getAgentid();
		float allsuppoint = 0f;

		for (String info : infos) {
			String[] agentinfo = info.split(",");
			long agentid = Long.valueOf(agentinfo[0]);// ID
			float suppoint = Float.valueOf(agentinfo[1]);// 留点
			float ordermoney = Float.valueOf(agentinfo[2]);// 单个订单价格
			float zpoint = Float.valueOf(agentinfo[3]);// 留点
			float totalrebate = super.formatfloatMoney((ordermoney * people)
					* zpoint / 100);
			if (agentid == loginid) {
				returninfo[0] = formatfloatMoney(zpoint - allsuppoint);
				returninfo[1] = formatfloatMoney(Math.floor(totalrebate
						- ordermoney * people * allsuppoint / 100));
				break;
			}
			allsuppoint += suppoint;
		}
		return returninfo;
	}

	public String GetWhyTuiFei(String angentid, String type) {// angentid
		// 加盟商ID type 类型
		// 4退票 5费票
		StringBuffer sub = new StringBuffer();
		if (angentid.equals("3")) {// 8000翼
			sub.append("<select id='ddlreason'>");
			if (type.equals("4")) {

				sub
						.append("<option value='393'>(旅客自愿退票)已作废/未创建行程单，已取消位置</option>");
				sub.append("<option value='395'>(申请全退)非供应商出票，只退款，不退票</option>");
				sub
						.append("<option value='396'>(申请全退)同一编码在平台重复支付，同一供应商出票，只退款，不退票</option>");
				sub
						.append("<option value='397'>(申请全退)同一航空公司，在平台同一供应商出票，满足升舱全退条件，已取消位置</option>");
				sub
						.append("<option value='400'>(申请全退)同一承运人因前段航班延误/取消，导致后段航班无法登机，已取消位置</option>");
				sub
						.append("<option value='401'>(申请全退)PNR包含航班延误/取消信息，或我方已传真相关证明，已取消位置作废行程单</option>");
				sub
						.append("<option value='402'>(申请全退)客户重复购买同一类型的机票（都是B2B或都是BSP），同终端出票，只退款，不退票</option>");
				sub
						.append("<option value='403'>(申请全退)已邮寄市级以上医院证明（诊断书、病例、旅客不能登机的证明、发票）原件，已取消位置</option>");
				sub
						.append("<option value='404'>(申请全退)供应商操作不规范，导致乘客不能正常登机，只退款，不退票</option>");
				sub
						.append("<option value='407'>(申请全退)按航空公司规定，同一日期和航班，同终端出票，名其中一个字音同字不同，已取消位置</option>");
				sub
						.append("<option value='585'>(申请全退)同一编码在两个平台重复支付，同一供应商出票，只退款，不退票</option>");
				sub
						.append("<option value='643'>(申请全退)因供应商操作不规范，导致客人无法登机</option>");
				sub
						.append("<option value='646'>(申请全退)客户重复购买同一类型的机票（都是B2B或都是BSP），同终端出票</option>");
				sub
						.append("<option value='658'>(旅客自愿退票)客票为换开状态，申请自愿退票</option>");

			}
			if (type.equals("5")) {
				sub
						.append("<option value='72'>我方已经作废行程单/未创建行程单，并且取消位置，申请卖家废票！【否则卖家不能作废】</option>");
				sub
						.append("<option value='163'>一个编码贴有多个票号，申请卖家废票！【请卖家只作废票号不取消编码】</option>");
			}

			sub.append("</select>");
		}

		if (angentid.equals("5")) {// 51book

			sub.append("<select id='ddlreason'>");

			if (type.equals("5")) {
				sub.append("<option value='1'>当日作废，扣10元手续费</option>");
				sub.append("<option value='2'>其它废票情况</option>");
			}
			if (type.equals("4")) {
				sub.append("<option value='3'>客人自愿退票，按客规收取手续费</option>");
				sub.append("<option value='4'>南航FC舱、东航FCY舱，申请全退</option>");
				sub.append("<option value='5'>因航班取消延误，申请全退</option>");
				sub.append("<option value='6'>升舱换开，申请全退</option>");
				sub.append("<option value='7'>名字错换开重出，申请全退</option>");
				sub.append("<option value='8'>客人因病无法乘机，申请全退</option>");
				sub.append("<option value='9'>其它退票情况</option>");
				sub.append("<option value='10'>申请退回票款差价</option>");
			}
			sub.append("</select>");
		}

		return sub.toString();
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

	public Orderinfo getOrderinfo2() {
		return orderinfo2;
	}

	public void setOrderinfo2(Orderinfo orderinfo2) {
		this.orderinfo2 = orderinfo2;
	}

	public Long getIdtemp() {
		return idtemp;
	}

	public void setIdtemp(Long idtemp) {
		this.idtemp = idtemp;
	}

	public String getForwork() {
		return forwork;
	}

	public void setForwork(String forwork) {
		this.forwork = forwork;
	}

	public String getH_insurance() {
		return h_insurance;
	}

	public void setH_insurance(String h_insurance) {
		this.h_insurance = h_insurance;
	}

	public String getH_savepasenger() {
		return h_savepasenger;
	}

	public void setH_savepasenger(String h_savepasenger) {
		this.h_savepasenger = h_savepasenger;
	}

	public List<Segmentinfo> getListSegment2() {
		return listSegment2;
	}

	public void setListSegment2(List<Segmentinfo> listSegment2) {
		this.listSegment2 = listSegment2;
	}

	public long getTemporderuserid() {
		return temporderuserid;
	}

	public void setTemporderuserid(long temporderuserid) {
		this.temporderuserid = temporderuserid;
	}

	public Long getS_ordertype() {
		return s_ordertype;
	}

	public void setS_ordertype(Long s_ordertype) {
		this.s_ordertype = s_ordertype;
	}

	public int getTy() {
		return ty;
	}

	public void setTy(int ty) {
		this.ty = ty;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getH_prestarttime() {
		return h_prestarttime;
	}

	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}

	public String getH_preendtime() {
		return h_preendtime;
	}

	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}

	public String getStrPNR() {
		return strPNR;
	}

	public void setStrPNR(String strPNR) {
		this.strPNR = strPNR;
	}

	public String getS_returnpnr() {
		return s_returnpnr;
	}

	public void setS_returnpnr(String s_returnpnr) {
		this.s_returnpnr = s_returnpnr;
	}

	public Segmentinfo getSegmentOne() {
		return segmentOne;
	}

	public void setSegmentOne(Segmentinfo segmentOne) {
		this.segmentOne = segmentOne;
	}

	public Segmentinfo getSegmentTwo() {
		return segmentTwo;
	}

	public void setSegmentTwo(Segmentinfo segmentTwo) {
		this.segmentTwo = segmentTwo;
	}

	public List<Passenger> getListPassenger2() {
		return listPassenger2;
	}

	public void setListPassenger2(List<Passenger> listPassenger2) {
		this.listPassenger2 = listPassenger2;
	}

	public Long getS_orderid() {
		return s_orderid;
	}

	public void setS_orderid(Long s_orderid) {
		this.s_orderid = s_orderid;
	}

	public long getZrate_id() {
		return zrate_id;
	}

	public void setZrate_id(long zrate_id) {
		this.zrate_id = zrate_id;
	}

	public long getS_agentid() {
		return s_agentid;
	}

	public void setS_agentid(long s_agentid) {
		this.s_agentid = s_agentid;
	}

	public Double getS_totalpaymoeny() {
		return s_totalpaymoeny;
	}

	public void setS_totalpaymoeny(Double s_totalpaymoeny) {
		this.s_totalpaymoeny = s_totalpaymoeny;
	}

	public String getS_paymethod() {
		return s_paymethod;
	}

	public void setS_paymethod(String s_paymethod) {
		this.s_paymethod = s_paymethod;
	}

	public String getS_contactname() {
		return s_contactname;
	}

	public void setS_contactname(String s_contactname) {
		this.s_contactname = s_contactname;
	}

	public String getS_bookername() {
		return s_bookername;
	}

	public void setS_bookername(String s_bookername) {
		this.s_bookername = s_bookername;
	}

	public String getS_chupiaoname() {
		return s_chupiaoname;
	}

	public void setS_chupiaoname(String s_chupiaoname) {
		this.s_chupiaoname = s_chupiaoname;
	}

	public String getS_tfshenqingren() {
		return s_tfshenqingren;
	}

	public void setS_tfshenqingren(String s_tfshenqingren) {
		this.s_tfshenqingren = s_tfshenqingren;
	}

	public String getS_tfshenqingsdate() {
		return s_tfshenqingsdate;
	}

	public void setS_tfshenqingsdate(String s_tfshenqingsdate) {
		this.s_tfshenqingsdate = s_tfshenqingsdate;
	}

	public String getS_tfshenqingedate() {
		return s_tfshenqingedate;
	}

	public void setS_tfshenqingedate(String s_tfshenqingedate) {
		this.s_tfshenqingedate = s_tfshenqingedate;
	}

	public String getS_tfshenhesdate() {
		return s_tfshenhesdate;
	}

	public void setS_tfshenhesdate(String s_tfshenhesdate) {
		this.s_tfshenhesdate = s_tfshenhesdate;
	}

	public String getS_tfshenheedate() {
		return s_tfshenheedate;
	}

	public void setS_tfshenheedate(String s_tfshenheedate) {
		this.s_tfshenheedate = s_tfshenheedate;
	}

	public String getS_tfshenheren() {
		return s_tfshenheren;
	}

	public void setS_tfshenheren(String s_tfshenheren) {
		this.s_tfshenheren = s_tfshenheren;
	}

	public String getS_gaiqianshenqingsdate() {
		return s_gaiqianshenqingsdate;
	}

	public void setS_gaiqianshenqingsdate(String s_gaiqianshenqingsdate) {
		this.s_gaiqianshenqingsdate = s_gaiqianshenqingsdate;
	}

	public String getS_gaiqianshenqingedate() {
		return s_gaiqianshenqingedate;
	}

	public void setS_gaiqianshenqingedate(String s_gaiqianshenqingedate) {
		this.s_gaiqianshenqingedate = s_gaiqianshenqingedate;
	}

	public String getS_gaiqianshenqingren() {
		return s_gaiqianshenqingren;
	}

	public void setS_gaiqianshenqingren(String s_gaiqianshenqingren) {
		this.s_gaiqianshenqingren = s_gaiqianshenqingren;
	}

	public String getS_gaiqianshenheren() {
		return s_gaiqianshenheren;
	}

	public void setS_gaiqianshenheren(String s_gaiqianshenheren) {
		this.s_gaiqianshenheren = s_gaiqianshenheren;
	}

	public String getS_gaiqianshenhesdate() {
		return s_gaiqianshenhesdate;
	}

	public void setS_gaiqianshenhesdate(String s_gaiqianshenhesdate) {
		this.s_gaiqianshenhesdate = s_gaiqianshenhesdate;
	}

	public String getS_gaiqianshenheedate() {
		return s_gaiqianshenheedate;
	}

	public void setS_gaiqianshenheedate(String s_gaiqianshenheedate) {
		this.s_gaiqianshenheedate = s_gaiqianshenheedate;
	}

	public String getS_shengcangshenqingren() {
		return s_shengcangshenqingren;
	}

	public void setS_shengcangshenqingren(String s_shengcangshenqingren) {
		this.s_shengcangshenqingren = s_shengcangshenqingren;
	}

	public String getS_shengcangshenqingsdate() {
		return s_shengcangshenqingsdate;
	}

	public void setS_shengcangshenqingsdate(String s_shengcangshenqingsdate) {
		this.s_shengcangshenqingsdate = s_shengcangshenqingsdate;
	}

	public String getS_shengcangshenqingedate() {
		return s_shengcangshenqingedate;
	}

	public void setS_shengcangshenqingedate(String s_shengcangshenqingedate) {
		this.s_shengcangshenqingedate = s_shengcangshenqingedate;
	}

	public String getS_shengcangshenheren() {
		return s_shengcangshenheren;
	}

	public void setS_shengcangshenheren(String s_shengcangshenheren) {
		this.s_shengcangshenheren = s_shengcangshenheren;
	}

	public String getS_shengcangshenhesdate() {
		return s_shengcangshenhesdate;
	}

	public void setS_shengcangshenhesdate(String s_shengcangshenhesdate) {
		this.s_shengcangshenhesdate = s_shengcangshenhesdate;
	}

	public String getS_shengcangshenheedate() {
		return s_shengcangshenheedate;
	}

	public void setS_shengcangshenheedate(String s_shengcangshenheedate) {
		this.s_shengcangshenheedate = s_shengcangshenheedate;
	}

	public void setS_orderstatus(int s_orderstatus) {
		this.s_orderstatus = s_orderstatus;
	}

	public String getS_huankaishenqingren() {
		return s_huankaishenqingren;
	}

	public void setS_huankaishenqingren(String s_huankaishenqingren) {
		this.s_huankaishenqingren = s_huankaishenqingren;
	}

	public String getS_huankaishenqingsdate() {
		return s_huankaishenqingsdate;
	}

	public void setS_huankaishenqingsdate(String s_huankaishenqingsdate) {
		this.s_huankaishenqingsdate = s_huankaishenqingsdate;
	}

	public String getS_huankaishenqingedate() {
		return s_huankaishenqingedate;
	}

	public void setS_huankaishenqingedate(String s_huankaishenqingedate) {
		this.s_huankaishenqingedate = s_huankaishenqingedate;
	}

	public String getS_huankaishenheren() {
		return s_huankaishenheren;
	}

	public void setS_huankaishenheren(String s_huankaishenheren) {
		this.s_huankaishenheren = s_huankaishenheren;
	}

	public String getS_huankaishenhesdate() {
		return s_huankaishenhesdate;
	}

	public void setS_huankaishenhesdate(String s_huankaishenhesdate) {
		this.s_huankaishenhesdate = s_huankaishenhesdate;
	}

	public String getS_huankaishenheedate() {
		return s_huankaishenheedate;
	}

	public void setS_huankaishenheedate(String s_huankaishenheedate) {
		this.s_huankaishenheedate = s_huankaishenheedate;
	}

	public String getStrTuiOrderID() {
		return strTuiOrderID;
	}

	public void setStrTuiOrderID(String strTuiOrderID) {
		this.strTuiOrderID = strTuiOrderID;
	}

	public List<Tickettype> getListtickettype() {
		return listtickettype;
	}

	public void setListtickettype(List<Tickettype> listtickettype) {
		this.listtickettype = listtickettype;
	}

	public long getS_tickettypeid() {
		return s_tickettypeid;
	}

	public void setS_tickettypeid(long s_tickettypeid) {
		this.s_tickettypeid = s_tickettypeid;
	}

	public String getStrNewTicketNum() {
		return strNewTicketNum;
	}

	public void setStrNewTicketNum(String strNewTicketNum) {
		this.strNewTicketNum = strNewTicketNum;
	}

	public String getStrSepPNR() {
		return strSepPNR;
	}

	public void setStrSepPNR(String strSepPNR) {
		this.strSepPNR = strSepPNR;
	}

	public String getStrTuikuanDesc() {
		return strTuikuanDesc;
	}

	public void setStrTuikuanDesc(String strTuikuanDesc) {
		this.strTuikuanDesc = strTuikuanDesc;
	}

	public long getS_employeeid() {
		return s_employeeid;
	}

	public void setS_employeeid(long s_employeeid) {
		this.s_employeeid = s_employeeid;
	}

	public String getTui_tuifeidesc() {
		return tui_tuifeidesc;
	}

	public void setTui_tuifeidesc(String tui_tuifeidesc) {
		this.tui_tuifeidesc = tui_tuifeidesc;
	}

	public String getTui_nodesc() {
		return tui_nodesc;
	}

	public void setTui_nodesc(String tui_nodesc) {
		this.tui_nodesc = tui_nodesc;
	}

	public String getPassid() {
		return passid;
	}

	public void setPassid(String passid) {
		this.passid = passid;
	}

	public String getTui() {
		return tui;
	}

	public void setTui(String tui) {
		this.tui = tui;
	}

	public String getChangedate() {
		return changedate;
	}

	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	public String getChangeflight() {
		return changeflight;
	}

	public void setChangeflight(String changeflight) {
		this.changeflight = changeflight;
	}

	public String getChangecabin() {
		return changecabin;
	}

	public void setChangecabin(String changecabin) {
		this.changecabin = changecabin;
	}

	public String getChangepnr() {
		return changepnr;
	}

	public void setChangepnr(String changepnr) {
		this.changepnr = changepnr;
	}

	public Long getTui_state() {
		return tui_state;
	}

	public void setTui_state(Long tui_state) {
		this.tui_state = tui_state;
	}

	public Long getTui_iscabinsite() {
		return tui_iscabinsite;
	}

	public void setTui_iscabinsite(Long tui_iscabinsite) {
		this.tui_iscabinsite = tui_iscabinsite;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public List getListorderinforc() {
		return listorderinforc;
	}

	public void setListorderinforc(List listorderinforc) {
		this.listorderinforc = listorderinforc;
	}

	public List getListYmsend() {
		return listYmsend;
	}

	public void setListYmsend(List listYmsend) {
		this.listYmsend = listYmsend;
	}

	public float getS_zonglirun() {
		return s_zonglirun;
	}

	public void setS_zonglirun(float s_zonglirun) {
		this.s_zonglirun = s_zonglirun;
	}

	public float getS_zonglirun2() {
		return s_zonglirun2;
	}

	public void setS_zonglirun2(float s_zonglirun2) {
		this.s_zonglirun2 = s_zonglirun2;
	}

	public static Map<Integer, String> getPaymethodmap() {
		return paymethodmap;
	}

	public static void setPaymethodmap(Map<Integer, String> paymethodmap) {
		B2borderinfoAction.paymethodmap = paymethodmap;
	}

	public int getOrderpaymethod() {
		return orderpaymethod;
	}

	public void setOrderpaymethod(int orderpaymethod) {
		this.orderpaymethod = orderpaymethod;
	}

	public String getS_receipt() {
		return s_receipt;
	}

	public void setS_receipt(String s_receipt) {
		this.s_receipt = s_receipt;
	}

	public String getStrSenderID() {
		return strSenderID;
	}

	public void setStrSenderID(String strSenderID) {
		this.strSenderID = strSenderID;
	}

	public String getStrSenderDate() {
		return strSenderDate;
	}

	public void setStrSenderDate(String strSenderDate) {
		this.strSenderDate = strSenderDate;
	}

	public String getS_songpaiodanpid() {
		return s_songpaiodanpid;
	}

	public void setS_songpaiodanpid(String s_songpaiodanpid) {
		this.s_songpaiodanpid = s_songpaiodanpid;
	}

	public String getS_Paindex() {
		return s_Paindex;
	}

	public void setS_Paindex(String paindex) {
		s_Paindex = paindex;
	}

	public String getBxname() {
		return bxname;
	}

	public void setBxname(String bxname) {
		this.bxname = bxname;
	}

	public String getBxcount() {
		return bxcount;
	}

	public void setBxcount(String bxcount) {
		this.bxcount = bxcount;
	}

	public List<Department> getSalesroolist() {
		return salesroolist;
	}

	public void setSalesroolist(List<Department> salesroolist) {
		this.salesroolist = salesroolist;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getS_printtime() {
		return s_createtime;
	}

	public void setS_printtime(String s_printtime) {
		this.s_createtime = s_printtime;
	}

	public String getS_createtime() {
		return s_createtime;
	}

	public void setS_createtime(String s_createtime) {
		this.s_createtime = s_createtime;
	}

	public String getS_customeragentid() {
		return s_customeragentid;
	}

	public void setS_customeragentid(String s_customeragentid) {
		this.s_customeragentid = s_customeragentid;
	}

	public String getLockorder() {
		return lockorder;
	}

	public void setLockorder(String lockorder) {
		this.lockorder = lockorder;
	}

	public String getFF_FlightNumber() {
		return FF_FlightNumber;
	}

	public void setFF_FlightNumber(String flightNumber) {
		FF_FlightNumber = flightNumber;
	}

	public String getFF_date() {
		return FF_date;
	}

	public void setFF_date(String ff_date) {
		FF_date = ff_date;
	}

	public String getFF_StopNum() {
		return FF_StopNum;
	}

	public void setFF_StopNum(String stopNum) {
		FF_StopNum = stopNum;
	}

	public String getTuigaiindex() {
		return tuigaiindex;
	}

	public void setTuigaiindex(String tuigaiindex) {
		this.tuigaiindex = tuigaiindex;
	}

	public int getS_isinter() {
		return s_isinter;
	}

	public void setS_isinter(int s_isinter) {
		this.s_isinter = s_isinter;
	}

	public String getS_pnr_inter() {
		return s_pnr_inter;
	}

	public void setS_pnr_inter(String s_pnr_inter) {
		this.s_pnr_inter = s_pnr_inter;
	}

	public String getS_tax_inter() {
		return s_tax_inter;
	}

	public void setS_tax_inter(String s_tax_inter) {
		this.s_tax_inter = s_tax_inter;
	}

	public String getS_adultprice_inter() {
		return s_adultprice_inter;
	}

	public void setS_adultprice_inter(String s_adultprice_inter) {
		this.s_adultprice_inter = s_adultprice_inter;
	}

	public String getS_childprice_inter() {
		return s_childprice_inter;
	}

	public void setS_childprice_inter(String s_childprice_inter) {
		this.s_childprice_inter = s_childprice_inter;
	}

	public long getAjax_zid() {
		return ajax_zid;
	}

	public void setAjax_zid(long ajax_zid) {
		this.ajax_zid = ajax_zid;
	}

	public String getAjax_fromcity() {
		return ajax_fromcity;
	}

	public void setAjax_fromcity(String ajax_fromcity) {
		this.ajax_fromcity = ajax_fromcity;
	}

	public String getAjax_tocity() {
		return ajax_tocity;
	}

	public void setAjax_tocity(String ajax_tocity) {
		this.ajax_tocity = ajax_tocity;
	}

	public String getAjax_code() {
		return ajax_code;
	}

	public void setAjax_code(String ajax_code) {
		this.ajax_code = ajax_code;
	}

	public String getAjax_waiid() {
		return ajax_waiid;
	}

	public void setAjax_waiid(String ajax_waiid) {
		this.ajax_waiid = ajax_waiid;
	}

	public String getAjax_zatetype() {
		return ajax_zatetype;
	}

	public void setAjax_zatetype(String ajax_zatetype) {
		this.ajax_zatetype = ajax_zatetype;
	}

	public String getParvalue() {
		return parvalue;
	}

	public void setParvalue(String parvalue) {
		this.parvalue = parvalue;
	}

	public float getOrderSafePrice() {
		return orderSafePrice;
	}

	public float getOrderPlat() {
		return orderPlat;
	}

	public String getAjax_vogtype() {
		return ajax_vogtype;
	}

	public void setAjax_vogtype(String ajax_vogtype) {
		this.ajax_vogtype = ajax_vogtype;
	}

	public String getS_contactmobile() {
		return s_contactmobile;
	}

	public void setS_contactmobile(String s_contactmobile) {
		this.s_contactmobile = s_contactmobile;
	}

	public String getIssavepassenger() {
		return issavepassenger;
	}

	public void setIssavepassenger(String issavepassenger) {
		this.issavepassenger = issavepassenger;
	}

	public int getAdultnum() {
		return adultnum;
	}

	public void setAdultnum(int adultnum) {
		this.adultnum = adultnum;
	}

	public Orderinfo getOrderinfo1() {
		return orderinfo1;
	}

	public void setOrderinfo1(Orderinfo orderinfo1) {
		this.orderinfo1 = orderinfo1;
	}

	public String getH_birthday() {
		return h_birthday;
	}

	public void setH_birthday(String h_birthday) {
		this.h_birthday = h_birthday;
	}

	public String getS_adultpnr() {
		return s_adultpnr;
	}

	public void setS_adultpnr(String s_adultpnr) {
		this.s_adultpnr = s_adultpnr;
	}

	public String getWhyid() {
		return whyid;
	}

	public void setWhyid(String whyid) {
		this.whyid = whyid;
	}

	public String getHidTuoOrFei() {
		return hidTuoOrFei;
	}

	public void setHidTuoOrFei(String hidTuoOrFei) {
		this.hidTuoOrFei = hidTuoOrFei;
	}

	public String getS_oldzratevalue() {
		return s_oldzratevalue;
	}

	public void setS_oldzratevalue(String s_oldzratevalue) {
		this.s_oldzratevalue = s_oldzratevalue;
	}

	public String getS_bestzratevalue() {
		return s_bestzratevalue;
	}

	public void setS_bestzratevalue(String s_bestzratevalue) {
		this.s_bestzratevalue = s_bestzratevalue;
	}

	public String getS_oldorderprice() {
		return s_oldorderprice;
	}

	public void setS_oldorderprice(String s_oldorderprice) {
		this.s_oldorderprice = s_oldorderprice;
	}

	public String getS_neworderprice() {
		return s_neworderprice;
	}

	public void setS_neworderprice(String s_neworderprice) {
		this.s_neworderprice = s_neworderprice;
	}

	public String getC_memo() {
		return c_memo;
	}

	public void setC_memo(String c_memo) {
		this.c_memo = c_memo;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public int getPaytype() {
		return paytype;
	}

	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}

	public String getTuiFeiType() {
		return TuiFeiType;
	}

	public void setTuiFeiType(String tuiFeiType) {
		TuiFeiType = tuiFeiType;
	}

	public String getNewordernum() {
		return newordernum;
	}

	public void setNewordernum(String newordernum) {
		this.newordernum = newordernum;
	}

	public String getS_feipiaoshenqingsdate() {
		return s_feipiaoshenqingsdate;
	}

	public void setS_feipiaoshenqingsdate(String s_feipiaoshenqingsdate) {
		this.s_feipiaoshenqingsdate = s_feipiaoshenqingsdate;
	}

	public String getS_feipiaoshenqingedate() {
		return s_feipiaoshenqingedate;
	}

	public void setS_feipiaoshenqingedate(String s_feipiaoshenqingedate) {
		this.s_feipiaoshenqingedate = s_feipiaoshenqingedate;
	}

	public String getFancaiinfo() {
		return fancaiinfo;
	}

	public void setFancaiinfo(String fancaiinfo) {
		this.fancaiinfo = fancaiinfo;
	}

	public String getIsxcd() {
		return isxcd;
	}

	public void setIsxcd(String isxcd) {
		this.isxcd = isxcd;
	}

	public String getIspeisong() {
		return ispeisong;
	}

	public void setIspeisong(String ispeisong) {
		this.ispeisong = ispeisong;
	}

	public String getLianxiname() {
		return lianxiname;
	}

	public void setLianxiname(String lianxiname) {
		this.lianxiname = lianxiname;
	}

	public String getLianxitel() {
		return lianxitel;
	}

	public void setLianxitel(String lianxitel) {
		this.lianxitel = lianxitel;
	}

	public String getYouzhengbianma() {
		return youzhengbianma;
	}

	public void setYouzhengbianma(String youzhengbianma) {
		this.youzhengbianma = youzhengbianma;
	}

	public void setOrderPlat(float orderPlat) {
		this.orderPlat = orderPlat;
	}

	public int getXcdPlat() {
		return xcdPlat;
	}
	

	public void setXcdPlat(int xcdPlat) {
		this.xcdPlat = xcdPlat;
	}

	public int getXcdpsPlat() {
		return xcdpsPlat;
	}

	public void setXcdpsPlat(int xcdpsPlat) {
		this.xcdpsPlat = xcdpsPlat;
	}

	public String getPeisongadd() {
		return peisongadd;
	}

	public void setPeisongadd(String peisongadd) {
		this.peisongadd = peisongadd;
	}

	public List<Peisong> getListPeisong() {
		return listPeisong;
	}

	public void setListPeisong(List<Peisong> listPeisong) {
		this.listPeisong = listPeisong;
	}

	public String getZratememo() {
		return zratememo;
	}

	public void setZratememo(String zratememo) {
		this.zratememo = zratememo;
	}

	public String getOfficecode() {
		return officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getS_txtcontactemail() {
		return s_txtcontactemail;
	}

	public void setS_txtcontactemail(String s_txtcontactemail) {
		this.s_txtcontactemail = s_txtcontactemail;
	}

	public String getS_txtcaigoumobile() {
		return s_txtcaigoumobile;
	}

	public void setS_txtcaigoumobile(String s_txtcaigoumobile) {
		this.s_txtcaigoumobile = s_txtcaigoumobile;
	}

	public int getS_guoneiguoji() {
		return s_guoneiguoji;
	}

	public void setS_guoneiguoji(int s_guoneiguoji) {
		this.s_guoneiguoji = s_guoneiguoji;
	}

	public List<Scang> getListScang() {
		return listScang;
	}

	public void setListScang(List<Scang> listScang) {
		this.listScang = listScang;
	}

	public List<Zrate> getListZrate1() {
		return ListZrate1;
	}

	public void setListZrate1(List<Zrate> listZrate1) {
		ListZrate1 = listZrate1;
	}

	public List<Zrate> getListZrate2() {
		return ListZrate2;
	}

	public void setListZrate2(List<Zrate> listZrate2) {
		ListZrate2 = listZrate2;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Long getZrate_one() {
		return zrate_one;
	}

	public void setZrate_one(Long zrate_one) {
		this.zrate_one = zrate_one;
	}

	public Long getZrate_two() {
		return zrate_two;
	}

	public void setZrate_two(Long zrate_two) {
		this.zrate_two = zrate_two;
	}

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

	public Long getS_tuifeistate() {
		return s_tuifeistate;
	}

	public void setS_tuifeistate(Long s_tuifeistate) {
		this.s_tuifeistate = s_tuifeistate;
	}
	public Long getS_biangengstate() {
		return s_biangengstate;
	}
	public void setS_biangengstate(Long s_biangengstate) {
		this.s_biangengstate = s_biangengstate;
	}
	public List<Withbank> getListfenrun() {
		return listfenrun;
	}
	public void setListfenrun(List<Withbank> listfenrun) {
		this.listfenrun = listfenrun;
	}
	public String getChangedate2() {
		return changedate2;
	}
	public void setChangedate2(String changedate2) {
		this.changedate2 = changedate2;
	}

}