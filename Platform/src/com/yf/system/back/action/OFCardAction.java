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
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.yf.system.atom.component.WriteLog;
import com.yf.system.atom.interticket.HttpClient;
import com.yf.system.back.server.Server;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.base.advertisement.Advertisement;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.alipay.util.Md5Encrypt;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class OFCardAction extends B2b2cbackAction {
	private List<Advertisement> listAdvertisement;
	private Advertisement advertisement = new Advertisement();
	private Recharge mobilerecharge = new Recharge();
	private Qmoneyrecharge qmoneyrecharge = new Qmoneyrecharge();
	private String rechnumber;
	private int rechstate = -1;// 用于充值状态
	private String rechstime;// 用于充值时间
	private String rechetime;// 用于充值时间

	private List<Map<String, String>> qinfomap;
	private String ordernumber;// 用于订单号
	private String s_ordernumber;// 用于订单号
	private String ordertype;// 用于订单类型
	private String orderstate;// 用于订单状态
	private String forword;// 用于跳转
	
	private Recharge recharge = new Recharge();
	private String sname;// 用于手机充值省名称
	private String companyname;// 用于树形菜单
	private String agentid;// 用于树形菜单
	private String carid;// 用于保存of的产品编号
	private String price;// 用于保存价格
	private String platfu;//交易费
	private String s_psystatus;//订单支付状态
//QBMOBILE
	
	public Float GetNewPrice(Float price){
		List<Sysconfig>list=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='QBMOBILE'", " ORDER BY ID ", -1, 0);
		if(list.size()>0){
			price=price+price*Float.parseFloat(list.get(0).getValue().trim())/1000;
		}
		return Float.parseFloat(formatMoneyShort(price));
	}
	
	/**
	 * 查询订单状态
	 */
	public String GetRechangOrderStauts(int a) throws Exception {
		String ret="";
		if(a==0){
			ret="充值中";	
		}
		if(a==1){
			ret="充值成功";	
		}
		if(a==9){
			ret="充值失败";	
		}
		if(a==11){
			ret="等待支付";	
		}
		if(a==99){
			ret="交易关闭";	
		}
		
		return ret;
	}
	public String toyouxirecharge() {
		
		
		return "toyouxiRecharge";
	}
	public String toshuidianrecharge() {
		
		
		return "toshuidianrecharge";
	}
	
	
	/**
	 * 列表查询广告表
	 */
	public String execute() throws Exception {

		float agentvmoney = this.getLoginsessionagent().getVmoney();
		ServletActionContext.getRequest().setAttribute("vmoney", agentvmoney);
		System.out
				.println("OFCardAction:execure()--recharge/mobile_recharge.jsp");
		return SUCCESS;
	}

	public String toQmoneyRecharge() {
		List<Sysconfig>list=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='QBMOBILE'", " ORDER BY ID ", -1, 0);
		if(list.size()>0){
			platfu=list.get(0).getValue().trim();
		}else{
			platfu="0";
		}
		try {
			Map<String, String> qmonymap = this.getQmoney(null);
			String errmsg = qmonymap.get("err_msg");
			if (errmsg == null || errmsg.trim().equals("")) {
			} else {
				qmonymap.put("inprice", errmsg);

			}
			ServletActionContext.getRequest()
					.setAttribute("qmonymap", qmonymap);
		} catch (Exception e) {
		}
		
		
		
		
		
		float agentvmoney = this.getLoginsessionagent().getVmoney();
		ServletActionContext.getRequest().setAttribute("vmoney", agentvmoney);
		
		System.out
				.println("OFCard!toQmoneyRecharge---recharge:qmoney_recharge.jsp");
		return "toqmoneyrecharge";
	}

	/**
	 * 已废弃
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String rechargeQmoney() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cardid = request.getParameter("cardid");
		String buyamount = request.getParameter("buynum");
		String qqnumber = request.getParameter("qqnumber");
		String rechmoney = request.getParameter("rechmoney");
		Qmoneyrecharge qrecharge = new Qmoneyrecharge();
		qrecharge.setOrdernumber("");
		qrecharge.setCardid(cardid);
		qrecharge.setBuynum(Integer.valueOf(buyamount));
		qrecharge.setRechmoney(Float.valueOf(rechmoney));
		qrecharge.setRechuid(this.getLoginUserId());
		qrecharge.setRechtime(new Timestamp(System.currentTimeMillis()));
		qrecharge.setQqnumber(qqnumber);
		qrecharge = Server.getInstance().getMemberService()
				.createQmoneyrecharge(qrecharge);
		String ordernumber = Server.getInstance().getServiceCenter()
				.getQmoneyRechargeCode(qrecharge);
		qrecharge.setOrdernumber(ordernumber);
		String state = Server.getInstance().getAtomService().qmoneyRecharge(
				ordernumber, cardid, Integer.valueOf(buyamount), qqnumber);
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		try {
			int rstate = Integer.valueOf(state);
			qrecharge.setRechstate(rstate);
			Server.getInstance().getMemberService()
					.updateQmoneyrechargeIgnoreNull(qrecharge);
			this.updateIntegral(user, 5, ordernumber, qrecharge.getRechmoney(),
					null);
			return "qrechargesuccess";
		} catch (Exception e) {
			qrecharge.setRechstate(9);
			ServletActionContext.getRequest().setAttribute("message", state);
			Server.getInstance().getMemberService()
					.updateQmoneyrechargeIgnoreNull(qrecharge);
			// 充值失败

		}

		System.out
				.println("OFCardAction:recharge()--recharge/rechargesuccess.jsp");
		return "rechargesuccess";

	}

	public String getQBCountHtml(String countstr) {
		StringBuffer sb = new StringBuffer("");
		String[] qbstr = countstr.split(",");
		for (String str : qbstr) {
			try {
				int num = Integer.valueOf(str);
				sb.append("<option value='" + num + "'>" + num + "</option>");
			} catch (Exception e) {
				int index = str.indexOf("-");
				int snum = Integer.valueOf(str.substring(0, index));
				int endnum = Integer.valueOf(str.substring(index + 1));
				for (int i = snum; i <= endnum; i++) {
					sb.append("<option value='" + i + "'>" + i + "</option>");
				}
			}
		}

		return sb.toString();

	}

	/**
	 * 
	 * @return 充值
	 * @throws SQLException
	 */
	public String mobileRecharge(Recharge recharge) throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		int mtype = recharge.getPhonetype();
		String quantity = recharge.getCardnum();
		String rechargecoe = recharge.getOrdernumber();
		String phonenumber = recharge.getPhonenumber();
		String message = Server.getInstance().getAtomService().onlineRecharge(
				mtype, quantity, rechargecoe, phonenumber);
		try {

			int state = Integer.valueOf(message);
			recharge.setState(state);
			if (state == 9) {
				throw new Exception();
			}
			Server.getInstance().getMemberService().updateRecharge(recharge);
			Customeruser user = this.getLoginUser();
			this.updateIntegral(user, 5, rechargecoe, recharge.getRechmoney(),
					null);
			request.setAttribute("successtype", 1);
			request.setAttribute("message", "手机话费" + recharge.getStatestr());
			float money = 0 - recharge.getInprice();
			super.createRebateRecord(recharge.getOrdernumber(), money, 5,
					recharge.getRechagentid(), recharge.getRechagentid(), 2,
					"手机充值扣除" + (0 - money));

			this.mobilerecharge = recharge;
			return "rechargesuccess";
		} catch (Exception e) {
			recharge.setState(9);
			Server.getInstance().getMemberService().updateRecharge(recharge);
			ServletActionContext.getRequest().setAttribute("message", message);
			// 充值失败

		}

		System.out
				.println("OFCardAction:recharge()--recharge/rechargesuccess.jsp");
		return "rechargefaile";
	}

	public String rechargeQmoney(Qmoneyrecharge recharge) throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ordernumber = recharge.getOrdernumber();
		String cardid = recharge.getCardid();
		int buyamount = recharge.getBuynum();
		String qqnumber = recharge.getQqnumber();
		String state = Server.getInstance().getAtomService().qmoneyRecharge(
				ordernumber, cardid, buyamount, qqnumber);
		Customeruser user = this.getLoginUser();
		try {
			int rstate = Integer.valueOf(state);
			if (rstate == 9) {
				throw new Exception();
			}
			recharge.setRechstate(rstate);
			Server.getInstance().getMemberService()
					.updateQmoneyrechargeIgnoreNull(recharge);
			this.updateIntegral(user, 9, ordernumber, recharge.getRechmoney(),
					null);
			float money = 0 - (recharge.getInprice() * recharge.getBuynum());
			money = Float.valueOf(super.formatMoney(money));
			// this.abateMemberVmoney(this.getLoginUser(), recharge
			// .getOrdernumber(), 5, money, "Q币充值虚拟账户余额扣除：(金额" + money
			// + ")");
			super.createRebateRecord(recharge.getOrdernumber(), money, 5,
					recharge.getRechagentid(), recharge.getRechagentid(), 2,
					"Q币充值扣除" + (0 - money) + "元");
			request.setAttribute("successtype", 2);
			request.setAttribute("message", "Q币充值成功");
			this.qmoneyrecharge = recharge;
			return "rechargesuccess";
		} catch (Exception e) {
			recharge.setRechstate(9);
			ServletActionContext.getRequest().setAttribute("message", state);
			Server.getInstance().getMemberService()
					.updateQmoneyrechargeIgnoreNull(recharge);
			// 充值失败

		}

		return "rechargefaile";
	}

	public String tophonewebPayresult() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderid = request.getParameter("orderid");
		this.mobilerecharge = Server.getInstance().getMemberService()
				.findRecharge(Long.valueOf(orderid));
		request.setAttribute("successtype", 1);
		return "rechargesuccess";
	}

	public String toqmoneywebPayresult() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderid = request.getParameter("orderid");
		this.qmoneyrecharge = Server.getInstance().getMemberService()
				.findQmoneyrecharge(Long.valueOf(orderid));
		return "rechargesuccess";
	}

	public String vmoneyqmoneyRecharge() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderidstr = request.getParameter("orderid");
		long orderid = Long.valueOf(orderidstr);
		Qmoneyrecharge recharge = Server.getInstance().getMemberService()
				.findQmoneyrecharge(orderid);
		if (recharge.getRechstate() == 11) {
			recharge.setPaymethod(2);// 虚拟账户支付；
			float ordermoney = recharge.getInprice();
			String message = "";
			float uvmoney = new CustomeragentServiceImpl().getTotalVmoney(this
					.getLoginUser().getAgentid());
			if (uvmoney >= ordermoney) {
				try {
					return rechargeQmoney(recharge);
				} catch (SQLException e) {
					message = "充值操作出现失败！";
					e.printStackTrace();
				}

			} else {
				message = "你的虚拟货币余额不足本次消费！";
			}
			request.setAttribute("message", message);
			return "rechargefaile";
		} else {
			return this.toQmoneyRecharge();
		}

	}

	/**
	 * @return Q币充值再次支付
	 */
	public String nextQmoneyRechargePay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String rechid = request.getParameter("rechid");
		long id = Long.valueOf(rechid);
		Qmoneyrecharge qrecharge = Server.getInstance().getMemberService()
				.findQmoneyrecharge(id);
		Map ordermap = new HashMap();
		
		ordermap.put("billname", "QmoneyRechargeHelper");
		ordermap.put("orderid", qrecharge.getId());
		ordermap.put("actionname", "recharge!vmoneyqmoneyRecharge.action");
		ordermap.put("rechnumber", qrecharge.getQqnumber());
		ordermap.put("ordernumber", qrecharge.getOrdernumber());
		ordermap.put("orderprice", Float.valueOf(formatMoney(qrecharge
				.getInprice()
				)));
		ordermap.put("ordername", qrecharge.getQqnumber() + "&nbsp;&nbsp;"
				+ super.formatMoneyShort(qrecharge.getRechmoney()) + "元充值");
		request.setAttribute("ordermap", ordermap);
		request.setAttribute("rechtype", 2);
		request.setAttribute("payresulturl","ofcard!toqmoneywebPayresult.action?orderid="
				+ qrecharge.getId());
		return "towebrepy";
	}

	/**
	 * 
	 * @return
	 */
	public String nextqmoneyRecharge(Qmoneyrecharge qmoneyrecharge) {
		String ordernumber = qmoneyrecharge.getRefordernumber();
		if (!isNotNullOrEpt(ordernumber)) {
			ordernumber = qmoneyrecharge.getOrdernumber();
		}
		ordernumber = "Q" + ordernumber;
		String state = Server.getInstance().getAtomService().qmoneyRecharge(
				ordernumber, qmoneyrecharge.getCardid(),
				qmoneyrecharge.getBuynum(), qmoneyrecharge.getQqnumber());
		qmoneyrecharge.setRefordernumber(ordernumber);
		Server.getInstance().getMemberService().updateQmoneyrechargeIgnoreNull(
				qmoneyrecharge);

		return state.trim();
	}

	/**
	 * @return 手机充值再次支付
	 */
	public String nextPhoneRechargePay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String rechid = request.getParameter("rechid");
		long id = Long.valueOf(rechid);
		Recharge recharge = Server.getInstance().getMemberService()
				.findRecharge(id);
		Map ordermap = new HashMap();
		ordermap.put("billname", "MobileRechargeHelper");
		ordermap.put("actionname", "recharge!vmoneymobileRecharge.action");
		ordermap.put("orderid", recharge.getId());
		ordermap.put("ordernumber", recharge.getOrdernumber());
		ordermap.put("rechnumber", recharge.getPhonenumber());
		ordermap.put("orderprice", recharge.getInprice());
		ordermap.put("ordername", recharge.getPhonenumber() + "&nbsp;-&nbsp;"
				+ super.formatMoneyShort(recharge.getRechmoney()) + "元充值");
		request.setAttribute("ordermap", ordermap);
		request.setAttribute("rechtype", 1);
		request.setAttribute("payresulturl","ofcard!tophonewebPayresult.action?orderid="
				+ recharge.getId());
		System.out.println(request.getAttribute("payresulturl"));
		
		return "towebrepy";
	}

	/**
	 * 
	 * @return
	 */
	public String nextphoneRecharge(Recharge recharge) {
		System.out.println("nextphoneRecharge");
		String ordernumber = recharge.getRefordernumber();
		if (!isNotNullOrEpt(ordernumber)) {
			ordernumber = recharge.getOrdernumber();
		}
		ordernumber = "P" + ordernumber;
		System.out.println("ordernumber:"+ordernumber);
		recharge.setRefordernumber(ordernumber);
		Server.getInstance().getMemberService().updateRechargeIgnoreNull(
				recharge);
		System.out.println("recharge:"+recharge);
		
		String state = Server.getInstance().getAtomService().onlineRecharge(
				recharge.getPhonetype(), recharge.getRechmoney().toString(), ordernumber,
				recharge.getPhonenumber());
		
		return state.trim();
	}

	public void ajaxnextqmoneyRecharge() {
		String message = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String rechid = request.getParameter("rechid");
		Qmoneyrecharge recharge = Server.getInstance().getMemberService()
				.findQmoneyrecharge(Long.valueOf(rechid));
		String stater = nextqmoneyRecharge(recharge);
		System.out.println("stater:"+stater);
		try {
			int state = Integer.valueOf(stater);
			if (state == 9) {
				throw new Exception();
			}
			recharge.setRechstate(state);
			message = recharge.getStatestr();
			System.out.println("message:"+message);
			
			/*float money = 0 - (recharge.getInprice() * recharge.getBuynum());
			money = Float.valueOf(super.formatMoney(money));
			super.createRebateRecord(recharge.getOrdernumber(), money, 5,
					recharge.getRechagentid(), recharge.getRechagentid(), 2,
					"Q币充值扣除" + (0 - money) + "元");*/
		} catch (Exception e) {
			message = "充值失败";
			if(stater.equals("账户金额不足")){
				message = "账户金额不足";
			}
			recharge.setRechstate(9);
		}
		
		if(recharge.getRechtouid()<=0){
			
			recharge.setRechtouid(getLoginUserId());//处理人
		}
		
		
		Server.getInstance().getMemberService().updateQmoneyrechargeIgnoreNull(recharge);
		try {
			PrintWriter out = response.getWriter();
			out.print(message);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void ajaxnextphoneRecharge() {
		String message = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String rechid = request.getParameter("rechid");
		Recharge recharge = Server.getInstance().getMemberService()
				.findRecharge(Long.valueOf(rechid));
		String stater = this.nextphoneRecharge(recharge);
		try {
			int state = Integer.valueOf(stater);
			if (state == 9) {
				throw new Exception();
			}
			recharge.setState(state);
			message = recharge.getStatestr();
			
			float money = 0 - recharge.getInprice();
			super.createRebateRecord(recharge.getOrdernumber(), money, 5,
					recharge.getRechagentid(), recharge.getRechagentid(), 2,
					"手机充值扣除" + (0 - money) + "元");
		} catch (Exception e) {
			message = "充值失败";
			if(stater.equals("账户金额不足")){
				message="账户金额不足";
			}
			recharge.setState(9);
		}
		if(recharge.getRechtouid()<=0){
			
			recharge.setRechtouid(getLoginUserId());//处理人
		}
		
		
		
		Server.getInstance().getMemberService().updateRechargeIgnoreNull(
				recharge);
		
		
	WriteLog.write("OF-QB充值返回信息", "订单ID:"+recharge.getId()+",返回:"+message);
		try {
			PrintWriter out = response.getWriter();
			out.print(message);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String webQmoneyRecharge() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try {

			String cardid = request.getParameter("cardid");
			System.out.println("cardid:"+cardid);
			Map<String, String> qqinfo = Server.getInstance().getAtomService()
					.getQQmoney(cardid);
			String buyamount = request.getParameter("buynum");
			String qqnumber = request.getParameter("qqnumber");
			String pervalue = qqinfo.get("pervalue");
			int monty = Integer.valueOf(buyamount) * Integer.valueOf(pervalue);
			String rechmoney = String.valueOf(monty);
			Qmoneyrecharge qrecharge = new Qmoneyrecharge();
			qrecharge.setBuynum(Integer.valueOf(buyamount));
			qrecharge.setOrdernumber("");
			qrecharge.setInprice(Float.valueOf(qqinfo.get("inprice"))*qrecharge.getBuynum());
			//GetNewPrice
			qrecharge.setInprice(GetNewPrice(qrecharge.getInprice()));
			qrecharge.setCardid(cardid);
			qrecharge.setRechstate(11);
			
			qrecharge.setRechmoney(Float.valueOf(rechmoney));
			long uid = 0l;
			try {
				Customeruser orderuser = (Customeruser) session
						.getAttribute("orderuserlogin");
				qrecharge.setRechtouid(orderuser.getId());
			} catch (Exception e) {

			}

			uid = this.getLoginUserId();
			qrecharge.setRechuid(uid);
			qrecharge.setRechagentid(this.getLoginUser().getAgentid());
			qrecharge.setRechtime(new Timestamp(System.currentTimeMillis()));
			qrecharge.setQqnumber(qqnumber);
			qrecharge = Server.getInstance().getMemberService()
					.createQmoneyrecharge(qrecharge);
			String ordernumber = Server.getInstance().getServiceCenter()
					.getQmoneyRechargeCode(qrecharge);
			qrecharge.setOrdernumber(ordernumber);
			Server.getInstance().getMemberService()
					.updateQmoneyrechargeIgnoreNull(qrecharge);
			Map ordermap = new HashMap();
			float qinprice = Float.valueOf(formatMoney(qrecharge.getInprice()));
			ordermap.put("billname", "QmoneyRechargeHelper");
			ordermap.put("orderid", qrecharge.getId());
			ordermap.put("rechnumber", qrecharge.getQqnumber());
			ordermap.put("ordernumber", ordernumber);
			ordermap.put("orderprice", qinprice);
			ordermap.put("ordername", qrecharge.getQqnumber() + "&nbsp;&nbsp;"
					+ super.formatMoneyShort(qrecharge.getRechmoney()) + "元充值");

			if (ServletActionContext.getServletContext().getAttribute(
					"vmoneyservice") != null) {// 判断是否有虚拟账户业务
				boolean vpay = true;
				ordermap
						.put("actionname", "ofcard!vmoneyqmoneyRecharge.action");
				float vmoney = new CustomeragentServiceImpl()
						.getTotalVmoney(this.getLoginUser().getAgentid());
				if (qinprice > vmoney) {
					vpay = false;
				}
				ordermap.put("vmoney", vmoney);
				ordermap.put("vmpayenable", vpay);// 如果可虚拟账户支付 传入当前账户余额
			}
			request.setAttribute("ordermap", ordermap);
			request.setAttribute("rechtype", 2);
			request.setAttribute("payresulturl","ofcard!toqmoneywebPayresult.action?orderid="
					+ qrecharge.getId());
			System.out.println(request.getAttribute("payresulturl"));
			rechargeMessage(qinprice, request);
		} catch (Exception e) {
			e.printStackTrace();
			return this.toQmoneyRecharge();
		}

		return "towebrepy";
	}

	public void rechargeMessage(float money, HttpServletRequest request) {
		// 获取商户信息
		Map<String, String> usermap = Server.getInstance().getAtomService()
				.getUserInfo();
		String message = "";
		if (usermap.get("err_msg") != null) {
			message = usermap.get("err_msg");
		} else {
			float ltmoney = Float.valueOf(usermap.get("ret_leftcredit"));
			if (money > ltmoney) {
				message = "对不起！商家账户余额不足以支付当前订单！请选择" + ltmoney + "元下订单消费！";
			}
		}
		request.setAttribute("message", message);
	}

	public String webmobileRecharge() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			String mobiletype = request.getParameter("mobiletype");
			int mtype = Integer.valueOf(mobiletype);
			String phonenumber = request.getParameter("phonenumber");
			String quantity = request.getParameter("quantity");
			sname = new String(sname.getBytes("ISO-8859-1"), "UTF-8");
			carid =  request.getParameter("carid");
			price= request.getParameter("price");

			Recharge recharge = new Recharge();
			long uid = 0l;
			try {
				Customeruser orderuser = (Customeruser) session
						.getAttribute("orderuserlogin");
				recharge.setRechtouid(orderuser.getId());
			} catch (Exception e) {

			}
			uid = this.getLoginUserId();
			recharge.setRechagentid(this.getLoginUser().getAgentid());
			recharge.setRechuid(uid);
			recharge.setOrdernumber("");
			recharge.setInprice(Float.valueOf(price));
			//recharge.setInprice(GetNewPrice(recharge.getInprice()));
			
			recharge.setCardnum(quantity);
			recharge.setState(11);// 等待支付
			recharge.setPhonenumber(phonenumber);
			recharge.setPhonetype(mtype);
			recharge.setRechmoney(getRechargeMoney(quantity));
			recharge.setRechtime(new Timestamp(System.currentTimeMillis()));
			recharge = Server.getInstance().getMemberService().createRecharge(
					recharge);
			String rechargecoe = Server.getInstance().getServiceCenter()
					.getRechargeCode(recharge);
			recharge.setOrdernumber(rechargecoe);
			Server.getInstance().getMemberService().updateRechargeIgnoreNull(
					recharge);
			Map ordermap = new HashMap();
			ordermap.put("billname", "MobileRechargeHelper");
			ordermap.put("actionname", "ofcard!vmoneymobileRecharge.action");
			ordermap.put("orderid", recharge.getId());
			ordermap.put("ordernumber", rechargecoe);
			ordermap.put("rechnumber", recharge.getPhonenumber());
			ordermap.put("orderprice", recharge.getInprice());
			ordermap.put("ordername", recharge.getPhonenumber()
					+ "&nbsp;-&nbsp;"
					+ super.formatMoneyShort(recharge.getRechmoney()) + "元充值");
			boolean vpay = true;
			if (recharge.getInprice() > new CustomeragentServiceImpl()
					.getTotalVmoney(this.getLoginUser().getAgentid())) {
				vpay = false;
			}
			ordermap.put("vmpayenable", vpay);
			request.setAttribute("ordermap", ordermap);
			request.setAttribute("payresulturl", "ofcard!tophonewebPayresult.action?orderid="
					+ recharge.getId());
			request.setAttribute("rechtype", 1);
			System.out.println(request.getAttribute("payresulturl"));
			rechargeMessage(recharge.getInprice(), request);
		} catch (Exception e) {
			this.execute();
		}
		return "towebrepy";
	}

	public void ajaxGetInprice() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String areaname = request.getParameter("areaname");//手机号
		String pervalue = request.getParameter("pervalue");//充值金额
		String mtype = request.getParameter("mobiletype");//手机类型
		
		System.out.println(areaname+","+pervalue+","+mtype);
	
		String ofuser="";
		String ofpwd="";
		List<Sysconfig>listuser=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='OFUSER'", " ORDER BY ID ", -1, 0);
		if(listuser!=null&&listuser.size()>0){
			ofuser=listuser.get(0).getValue();
		}
		List<Sysconfig>listpwd=Server.getInstance().getSystemService().findAllSysconfig(" WHERE 1=1 AND "+Sysconfig.COL_name+" ='OFPWD'", " ORDER BY ID ", -1, 0);
		if(listpwd!=null&&listpwd.size()>0){
			ofpwd=listpwd.get(0).getValue();
		}
		String url="http://api2.ofpay.com/telquery.do?userid="+ofuser+"&userpws="+Md5Encrypt.md5(ofpwd)+"&phoneno="+areaname+"&pervalue="+pervalue+"&version=6.0";//话费充值的
		String re = HttpClient.httpget(url, "GBK");
		System.out.println(re);
		String errmsg="-1@网络错误";
		try {
			Document	document = DocumentHelper.parseText(re);
			Element root = document.getRootElement();
			String err_msg=root.element("err_msg").getText();
			String retcode=root.element("retcode").getText();
			System.out.println(retcode+","+err_msg);
			if(retcode.equals("1")){//可以充值
				String cardid=root.element("cardid").getText();//
				String inprice=root.element("inprice").getText();//
				Float newprice=	GetNewPrice(Float.parseFloat(inprice));
				System.out.println(cardid+","+inprice+","+newprice);
				errmsg=cardid+"@"+newprice;
			}else{
				errmsg="-1@"+err_msg;
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(errmsg);
		out.close();

	}

	public String getMobileCardid(int type, float pervalue, String area) {
		String sql = "SELECT C_CARDID FROM T_OFMOBILEINFO WHERE C_MOBILETYPE="
				+ type + " AND C_PERVALUE=" + pervalue
				+ " AND C_AREANAME LIKE'%" + area + "%'";
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				sql, null);
		if (list.size() > 0) {
			return ((Map) list.get(0)).get("C_CARDID").toString();
		}
		return "";

	}

	public Map<String, String> getQmoney(String cardid) {
		return Server.getInstance().getAtomService().getQQmoney(cardid);
	}

	public String vmoneymobileRecharge() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderidstr = request.getParameter("orderid");
		long orderid = Long.valueOf(orderidstr);
		Recharge recharge = Server.getInstance().getMemberService()
				.findRecharge(orderid);
		if (recharge.getState() == 11) {
			recharge.setPaymethod(2);// 虚拟账户支付
			float ordermoney = recharge.getInprice();
			// Customeruser user = this.getLoginUser();
			String message = "";
			Customeragent agent = this.getLoginUserAgent();
			float uvmoney = agent.getVmoney();
			if (uvmoney >= ordermoney) {
				try {
					return mobileRecharge(recharge);
				} catch (SQLException e) {
					message = "充值操作出现失败！";
					e.printStackTrace();
				}

			} else {
				message = "你的虚拟货币余额不足本次消费！";
			}
			request.setAttribute("message", message);
			return "rechargefaile";
		} else {
			return this.execute();
		}
	}

	/**
	 * 已废弃
	 * 
	 * @return 充值
	 * @throws SQLException
	 */
	public String recharge() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String mobiletype = request.getParameter("mobiletype");
		String phonenumber = request.getParameter("phonenumber");
		String quantity = request.getParameter("quantity");
		int mtype = Integer.valueOf(mobiletype);
		Recharge recharge = new Recharge();
		recharge.setOrdernumber("");
		recharge.setPhonetype(mtype);
		recharge.setCardnum(quantity);
		recharge.setPhonenumber(phonenumber);
		recharge.setRechmoney(getRechargeMoney(quantity));
		recharge.setRechtime(new Timestamp(System.currentTimeMillis()));
		recharge.setRechuid(this.getLoginUserId());
		recharge = Server.getInstance().getMemberService().createRecharge(
				recharge);
		String rechargecoe = Server.getInstance().getServiceCenter()
				.getRechargeCode(recharge);
		recharge.setOrdernumber(rechargecoe);
		String message = Server.getInstance().getAtomService().onlineRecharge(
				mtype, quantity, rechargecoe, phonenumber);
		try {
			this.recharge = recharge;
			int state = Integer.valueOf(message);
			recharge.setState(state);
			Server.getInstance().getMemberService().updateRechargeIgnoreNull(
					recharge);
			Customeruser user = (Customeruser) ActionContext.getContext()
					.getSession().get("orderuserlogin");
			this.updateIntegral(user, 5, rechargecoe, recharge.getRechmoney(),
					null);
			// return toPhoneRecharges();
		} catch (Exception e) {
			recharge.setState(9);
			Server.getInstance().getMemberService().updateRechargeIgnoreNull(
					recharge);
			ServletActionContext.getRequest().setAttribute("message", message);
			// 充值失败

		}

		System.out
				.println("OFCardAction:recharge()--recharge/rechargesuccess.jsp");
		return "rechargesuccess";
	}

	private String getMobileJsonInfo(String phonenumber) {
		String rstr = "-1";
		Map<String, String> map = new HashMap<String, String>();
		String urlstr = "http://api2.ofpay.com/mobinfo.do?mobilenum="
				+ phonenumber + "&output=json&callback=querycallback";
		String re = HttpClient.httpget(urlstr, "GBK");
		System.out.println("re:"+re);
		if(re!=null&&re.indexOf("|")!=-1){
			rstr=re.split("[|]")[2];
		}
		
		return rstr;
	}

	public String toRechargeOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		agentid = request.getParameter("agentid");
		String where = "WHERE 1=1";
		if (isNotNullOrEpt(agentid)) {
			long agid = Long.valueOf(agentid);
			if (agid < 0) {
				where = " WHERE C_RECHAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
						+ (0 - agid)
						+ "  AND charindex(CONVERT(nvarchar,"
						+ this.getLoginUser().getAgentid()
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_RECHAGENTID))> 0  )";
			} else {
				where = " WHERE C_RECHAGENTID=" + agentid;
			}

		} else {
			if (this.getLoginUserAgent().getAgenttype() == 1) {
				where = " where 1=1";
			} else {
				where = "WHERE (C_RECHAGENTID="
						+ this.getLoginUser().getAgentid()
						+ "  OR charindex(CONVERT(nvarchar,"
						+ this.getLoginUser().getAgentid()
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_RECHAGENTID))> 0  )";
			}
		}
		if (isNotNullOrEpt(this.rechnumber)) {
			where += " AND " + this.mobilerecharge.COL_phonenumber + " LIKE '%"
					+ rechnumber + "%'";
		}
		if (this.rechstate > -1) {
			where += " AND " + this.mobilerecharge.COL_state + "=" + rechstate;
		}
		String rechtime = super.getCheckTime(rechstime, rechetime,
				mobilerecharge.COL_rechtime);
		if (isNotNullOrEpt(rechtime)) {
			where += " AND (" + rechtime + ")";
		}
		if(s_psystatus!=null&&s_psystatus.length()>0){
			where+=" AND C_PAYSTATE="+s_psystatus;
			if(s_psystatus.equals("1")){
				where+=" and C_STATE=11 ";
			}
			
		}
		System.out.println("手机查询where:"+where);
		List rechargelist = Server.getInstance().getMemberService()
				.findAllRechargeForPageinfo(where, " ORDER BY ID DESC ",
						pageinfo);
		System.out.println(rechargelist.size());
		pageinfo = (PageInfo) rechargelist.remove(0);
		for (int i = 0; i < rechargelist.size(); i++) {
			Recharge recharge = (Recharge) rechargelist.get(i);
			if (recharge.getState() == 0) {

			}
		}
		request.setAttribute("rechargelist", rechargelist);
		String agentroot = new CustomeragentAction().getAgentRoot();
		if (this.getLoginUserAgent().getAgenttype() == 1) {
			agentroot += this.getAgentRootreplenish();
		}
		request.setAttribute("agentroot", agentroot);

		return "recharrecord";
	}

	public String getAgentRootreplenish() {

		return "var root_0=new Ext.tree.TreeNode({text:\"网站散客\",id:'0'});root.appendChild(root_0)";
	}

	public String toQmoneyRechargeOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String where = "WHERE 1=1";
		if (isNotNullOrEpt(agentid)) {
			long agid = Long.valueOf(agentid);
			if (agid < 0) {
				where = " WHERE C_RECHAGENTID IN (SELECT ID FROM T_CUSTOMERAGENT WHERE C_AGENTTYPE="
						+ (0 - agid)
						+ " AND charindex(CONVERT(nvarchar,"
						+ this.getLoginUser().getAgentid()
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_RECHAGENTID))> 0 )";
			} else {
				where = " WHERE C_RECHAGENTID=" + agentid;
			}

		} else {
			if (this.getLoginUserAgent().getAgenttype() == 1) {
				where = " WHERE 1=1 ";
			} else {
				where = "WHERE (C_RECHAGENTID="
						+ this.getLoginUser().getAgentid()
						+ "  OR charindex(CONVERT(nvarchar,"
						+ this.getLoginUser().getAgentid()
						+ "),(SELECT C_PARENTSTR FROM T_CUSTOMERAGENT A WHERE A.ID=C_RECHAGENTID))> 0  )";
			}
		}
		if (isNotNullOrEpt(this.rechnumber)) {
			where += " AND " + this.qmoneyrecharge.COL_qqnumber + " LIKE '%"
					+ rechnumber + "%'";
		}
		if (this.rechstate > -1) {
			where += " AND " + this.qmoneyrecharge.COL_rechstate + "="
					+ rechstate;
		}
		
		
		String rechtime = super.getCheckTime(rechstime, rechetime,
				qmoneyrecharge.COL_rechtime);
		if (isNotNullOrEpt(rechtime)) {
			where += " AND (" + rechtime + ")";
		}
		
		if(s_psystatus!=null&&s_psystatus.length()>0){
			where+=" AND C_PAYSTATE="+s_psystatus;
		}
		
		System.out.println(where);
		System.out.println(pageinfo.getPagenum());
		List qmoneyrechargelist = Server.getInstance().getMemberService()
				.findAllQmoneyrechargeForPageinfo(where, " ORDER BY ID DESC ",
						pageinfo);
		pageinfo = (PageInfo) qmoneyrechargelist.remove(0);
		request.setAttribute("qmoneyrechargelist", qmoneyrechargelist);
		String agentroot = new CustomeragentAction().getAgentRoot();
		if (this.getLoginUserAgent().getAgenttype() == 1) {
			agentroot += this.getAgentRootreplenish();
		}
		request.setAttribute("agentroot", agentroot);
		return "qmoneyrecharrecord";
	}

	public void ajaxMobileInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String mobile = request.getParameter("phonenumber");
		String jsonstr = getMobileJsonInfo(mobile);
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonstr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getRechargeState(String ordernumber) {
		String state = Server.getInstance().getAtomService().getPaystate(
				ordernumber);
		return state;

	}

	public String getQBCountHtml(String countstr, int count) {
		StringBuffer sb = new StringBuffer("");
		String[] qbstr = countstr.split(",");
		for (String str : qbstr) {
			try {
				int num = Integer.valueOf(str);
				sb.append("<option value='" + num + "'>" + num + "</option>");
			} catch (Exception e) {
				int index = str.indexOf("-");
				int snum = Integer.valueOf(str.substring(0, index));
				int endnum = Integer.valueOf(str.substring(index + 1));
				String selectstr = "";
				for (int i = snum; i <= endnum; i++) {
					selectstr = "";
					if (i == count) {
						selectstr = "selected=\"selected\"";
					}
					sb.append("<option " + selectstr + " value='" + i + "'>"
							+ i + "</option>");
				}
			}
		}

		return sb.toString();

	}

	// 返回（1，0，9，-1），其中一项。 1充值成功，0充值中，9充值失败，-1近三天内找不到此订单，请进入平台核实。
	public void ajaxGetPhoneRechState() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String orderid = request.getParameter("orderid");
		Recharge recharge = Server.getInstance().getMemberService()
				.findRecharge(Long.valueOf(orderid));
		ordernumber = recharge.getRefordernumber() == null ? recharge
				.getOrdernumber() : recharge.getRefordernumber();
		String statestr = this.getRechargeState(ordernumber);
		int state = Integer.valueOf(statestr);
		System.out.println(state == -1);
		statestr = state == 1 ? "充值成功" : state == 0 ? "充值中"
				: state == 9 ? "充值失败" : state == -1 ? "交易关闭" : "";
		if (state != 1 && state != recharge.getState()) {
			recharge.setState(state);
			Server.getInstance().getMemberService().updateRechargeIgnoreNull(
					recharge);
		}

		try {
			PrintWriter out = response.getWriter();
			out.print(statestr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ajaxGetQmoneyRechState() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String orderid = request.getParameter("orderid");
		Qmoneyrecharge recharge = Server.getInstance().getMemberService()
				.findQmoneyrecharge(Long.valueOf(orderid));
		ordernumber = recharge.getRefordernumber() == null ? recharge
				.getOrdernumber() : recharge.getRefordernumber();
		String statestr = this.getRechargeState(ordernumber);
		int state = Integer.valueOf(statestr);
		System.out.println(state == -1);
		statestr = state == 1 ? "充值成功" : state == 0 ? "充值中"
				: state == 9 ? "充值失败" : state == -1 ? "交易关闭" : "";
		if (state != -1 && state != recharge.getRechstate()) {
			recharge.setRechstate(state);
			Server.getInstance().getMemberService()
					.updateQmoneyrechargeIgnoreNull(recharge);
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(statestr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updQmoneyRechstate(String ordernumber, int state) {
		String sql = "UPDATE T_QMONEYRECHARGE SET C_STATE=" + state
				+ " WHERE C_ORDERNUMBER = '" + ordernumber + "'";
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);

	}

	public void updMobileRechstate(String ordernumber, int state) {
		String sql = "UPDATE T_RECHARGE SET C_STATE=" + state
				+ " WHERE C_ORDERNUMBER = '" + ordernumber + "'";
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);

	}
	
	public String UpdateOrderState(){
		forword="ofcard!toRechargeOrder.action";
		
		if(ordertype.equals("mobile")){
			String sql = "UPDATE T_RECHARGE SET C_STATE=" + orderstate
			+ " WHERE C_ORDERNUMBER = '" + s_ordernumber + "'";
			Server.getInstance().getSystemService().findMapResultBySql(sql, null);
			forword="ofcard!toRechargeOrder.action";
		}
		if(ordertype.equals("qq")){
			String sql = "UPDATE T_QMONEYRECHARGE SET C_RECHSTATE=" + orderstate
			+ " WHERE C_ORDERNUMBER = '" + s_ordernumber + "'";
			Server.getInstance().getSystemService().findMapResultBySql(sql, null);
			forword="ofcard!toQmoneyRechargeOrder.action";
		}
		return "toorderbytype";
	}
	

	// 通用可选数量（1=50元，2=100元，6=300元）
	// (移动 0.2=10元，0.4=20元,0.6=30元)
	// (联通 0.6=30元)
	// (电信 0.6=30元)
	// 1:移动2.联通，3.电信
	public float getRechargeMoney(String target) {
		return Float.valueOf(target) * 50;
	}

	public Recharge getRecharge() {
		return recharge;
	}

	public void setRecharge(Recharge recharge) {
		this.recharge = recharge;
	}

	@Override
	public Object getModel() {
		return this.recharge;
	}

	public List<Map<String, String>> getQinfomap() {
		return qinfomap;
	}

	public void setQinfomap(List<Map<String, String>> qinfomap) {
		this.qinfomap = qinfomap;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Recharge getMobilerecharge() {
		return mobilerecharge;
	}

	public void setMobilerecharge(Recharge mobilerecharge) {
		this.mobilerecharge = mobilerecharge;
	}

	public Qmoneyrecharge getQmoneyrecharge() {
		return qmoneyrecharge;
	}

	public void setQmoneyrecharge(Qmoneyrecharge qmoneyrecharge) {
		this.qmoneyrecharge = qmoneyrecharge;
	}

	public String getRechnumber() {
		return rechnumber;
	}

	public void setRechnumber(String rechnumber) {
		this.rechnumber = rechnumber;
	}

	public int getRechstate() {
		return rechstate;
	}

	public void setRechstate(int rechstate) {
		this.rechstate = rechstate;
	}

	public String getRechstime() {
		return rechstime;
	}

	public void setRechstime(String rechstime) {
		this.rechstime = rechstime;
	}

	public String getRechetime() {
		return rechetime;
	}

	public void setRechetime(String rechetime) {
		this.rechetime = rechetime;
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
	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getPlatfu() {
		return platfu;
	}
	public void setPlatfu(String platfu) {
		this.platfu = platfu;
	}
	public String getS_psystatus() {
		return s_psystatus;
	}
	public void setS_psystatus(String s_psystatus) {
		this.s_psystatus = s_psystatus;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getForword() {
		return forword;
	}
	public void setForword(String forword) {
		this.forword = forword;
	}
	public String getS_ordernumber() {
		return s_ordernumber;
	}
	public void setS_ordernumber(String s_ordernumber) {
		this.s_ordernumber = s_ordernumber;
	}
}