/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class InsuranceinfoAction extends B2b2cbackAction {
	private List<Insuranceinfo> listInsuranceinfo;
	private Insuranceinfo insuranceinfo = new Insuranceinfo();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	public long orderId;// 订单Id
	
	private String s_ordernumber;//订单号
	private String s_passengername;//乘机人
	private int s_product;//产品
	private String s_baodannumber;//保单号
	private String s_danzhengnumber;//但正号
	private String s_qbbegintime;//起保日期
	private String s_qbendtime;//

	public List<Insuranceinfo> insurancelist;

	// search
	// private String s_name;

	/**
	 * 列表查询保险
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";
		
		if(isNotNullOrEpt(s_ordernumber)){
			//where+=" AND ID IN ( SELECT "++" )";
		}

		List list = Server.getInstance().getMemberService()
				.findAllInsuranceinfoForPageinfo(where, " ORDER BY ID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listInsuranceinfo = list;
		if (pageinfo.getTotalrow() > 0 && listInsuranceinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService()
					.findAllInsuranceinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listInsuranceinfo = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到保险添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到保险修改页面
	 */
	public String toedit() throws Exception {
		insuranceinfo = Server.getInstance().getMemberService()
				.findInsuranceinfo(insuranceinfo.getId());
		insurancelist = new ArrayList<Insuranceinfo>();
		insurancelist.add(insuranceinfo);
		return EDIT;
	}

	/**
	 * 转向到保险审核页面
	 */
	public String tocheck() throws Exception {
		insuranceinfo = Server.getInstance().getMemberService()
				.findInsuranceinfo(insuranceinfo.getId());
		return CHECK;
	}

	/**
	 * @return 转到添加保险页面
	 */
	public String toaddinsurance() {
		String where = " WHERE "
				+ Insuranceinfo.COL_id
				+ " IN ( SELECT C_INSURANCE  FROM [T_PASSENGER] WHERE C_ORDERID="
				+ orderId + " )";
		insurancelist = Server.getInstance().getMemberService()
				.findAllInsuranceinfo(where, "", -1, 0);
		if (insurancelist.size() == 0) {// PNR 导入时没有录入保险 现在又要录入的情况
			String pwhere = " WHERE " + Passenger.COL_orderid + "=" + orderId;
			List<Passenger> passengers = Server.getInstance().getAirService()
					.findAllPassenger(pwhere, "", -1, 0);
			Segmentinfo seg = null;
			if (passengers.size() > 0) {
				Passenger passenger = passengers.get(0);
				String swhere = " WHERE " + Segmentinfo.COL_orderid + "="
						+ passenger.getOrderid();
				seg = (Segmentinfo) Server.getInstance().getAirService()
						.findAllSegmentinfo(swhere, "", -1, 0).get(0);
			}
			int inid = 0;
			for (Passenger pa : passengers) {
				inid--;
				Insuranceinfo insur = new Insuranceinfo();
				// System.out.println(pa.getName());
				insur.setId(inid);// 此处设置Id为录入保险时区分
				insur.setInsurancemoney(String.valueOf(pa.getId()));// 暂存保险人Id
				insur.setBeibaoren(pa.getName());
				insur.setToubaoren(pa.getName());

				insur.setCreatetime(dateToTimestamp(formatTimestamp2(seg
						.getDeparttime())));
				Timestamp t = new Timestamp(insur.getCreatetime().getTime());
				t.setDate(t.getDate() + 7);
				insur.setEnddate(t);
				insurancelist.add(insur);

			}
		}
		// System.out.println(insurancelist.size());
		return "toaddinsurance";
	}

	public String getPassengername(long id) {
		String where = "  WHERE C_INSURANCE=" + id;
		Passenger passenger = (Passenger) Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0).get(0);
		if (passenger != null) {
			return passenger.getName();
		}
		return "";
	}

	/**
	 * 添加保险
	 */
	public String add() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String[] passengerids = request.getParameterValues("passengerid");
		for (String str : passengerids) {

			String companyname = request.getParameter("companyname" + str);
			String insurancename = request.getParameter("insurancename" + str);
			String insurancefee = request.getParameter("insurancefee" + str);
			String createtime = request.getParameter("createtime" + str);
			String enddate = request.getParameter("zhongzhidate" + str);
			String ordernumber = request.getParameter("ordernumber" + str);
			String danzhenghao = request.getParameter("danzhenghao" + str);
			String toubaoren = request.getParameter("toubaoren" + str);
			String beibaoren = request.getParameter("beibaoren" + str);
			String insurancenum = request.getParameter("insurancenum" + str);
			String desc = request.getParameter("description" + str);
			Insuranceinfo insur = Server.getInstance().getMemberService()
					.findInsuranceinfo(Long.valueOf(str));
			boolean isnew = false;
			if (insur == null) {
				isnew = true;
				insur = new Insuranceinfo();

			}
			insur.setEmployeeid(getLoginUserId());
			insur.setCompanyname(companyname);
			insur.setInsurancenum(Integer.valueOf(insurancenum));
			insur.setInsurancename(insurancename);
			insur.setInsurancefee(insurancefee);
			insur.setOrdernumber(ordernumber);
			insur.setDanzhenghao(danzhenghao);
			insur.setToubaoren(toubaoren);
			insur.setBeibaoren(beibaoren);
			insur.setInsurancestate(2);
			if (ordernumber.length() == 0) {
				insur.setInsurancestate(1);
			}
			insur.setEnddate(dateToTimestamp(enddate));
			insur.setCreatetime(dateToTimestamp(createtime));
			insur.setDescription(desc);
			if (isnew) {
				Insuranceinfo insurance = Server.getInstance()
						.getMemberService().createInsuranceinfo(insur);
				String pid = request.getParameter("temppid" + str);
				// Passenger
				// passenger=Server.getInstance().getAirService().findPassenger(Long.valueOf(pid));
				String sql = "UPDATE T_PASSENGER SET C_INSURANCE="
						+ insurance.getId() + " WHERE ID=" + pid;
				Server.getInstance().getSystemService().findMapResultBySql(sql,
						null);
			} else {
				Server.getInstance().getMemberService().updateInsuranceinfo(
						insur);
			}
		}
		return LIST;
	}

	/**
	 * 审核保险
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateInsuranceinfoIgnoreNull(
				insuranceinfo);
		return LIST;
	}

	/**
	 * 编辑保险
	 */
	public String edit() throws Exception {

		return this.add();
	}

	/**
	 * 删除保险
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteInsuranceinfo(
				insuranceinfo.getId());
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
					Server.getInstance().getMemberService()
							.deleteInsuranceinfo(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回保险对象
	 */

	public Object getModel() {
		return insuranceinfo;
	}

	public List<Insuranceinfo> getListInsuranceinfo() {
		return listInsuranceinfo;
	}

	public void setListInsuranceinfo(List<Insuranceinfo> listInsuranceinfo) {
		this.listInsuranceinfo = listInsuranceinfo;
	}

	public Insuranceinfo getInsuranceinfo() {
		return insuranceinfo;
	}

	public void setInsuranceinfo(Insuranceinfo insuranceinfo) {
		this.insuranceinfo = insuranceinfo;
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<Insuranceinfo> getInsurancelist() {
		return insurancelist;
	}

	public void setInsurancelist(List<Insuranceinfo> insurancelist) {
		this.insurancelist = insurancelist;
	}

	public String getS_ordernumber() {
		return s_ordernumber;
	}

	public void setS_ordernumber(String s_ordernumber) {
		this.s_ordernumber = s_ordernumber;
	}

	public String getS_passengername() {
		return s_passengername;
	}

	public void setS_passengername(String s_passengername) {
		this.s_passengername = s_passengername;
	}

	public int getS_product() {
		return s_product;
	}

	public void setS_product(int s_product) {
		this.s_product = s_product;
	}

	public String getS_baodannumber() {
		return s_baodannumber;
	}

	public void setS_baodannumber(String s_baodannumber) {
		this.s_baodannumber = s_baodannumber;
	}

	public String getS_danzhengnumber() {
		return s_danzhengnumber;
	}

	public void setS_danzhengnumber(String s_danzhengnumber) {
		this.s_danzhengnumber = s_danzhengnumber;
	}

	public String getS_qbbegintime() {
		return this.s_qbbegintime;
	}

	public void setS_qbbegintime(String s_qbstarttime) {
		this.s_qbbegintime = s_qbstarttime;
	}

	public String getS_qbendtime() {
		return s_qbendtime;
	}

	public void setS_qbendtime(String s_qbendtime) {
		this.s_qbendtime = s_qbendtime;
	}

}