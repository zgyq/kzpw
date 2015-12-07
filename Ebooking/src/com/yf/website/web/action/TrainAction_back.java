/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */


package com.yf.website.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.system.atom.service.IAtomService;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.service.ITrainService;
import com.yf.system.base.train.Train;
import com.yf.system.base.trainpassenger.Trainpassenger;
import com.yf.system.base.util.PageInfo;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;

public class TrainAction_back extends B2b2cbackAction {
	private List<Train> listTrain;
	private Train train = new Train();
	private String agentroot;
	private long agentid;

	private String companyname;
	private String forword;

	// 用于查询条件
	private String startcreatetime;
	private String endcreatetime;

	private List<Train> trainlist = new ArrayList<Train>();
	private List<Trainpassenger> trainpassengerlist = null;
	private ITrainService trainservice;

	/**
	 * 火车首页
	 */
	public String execute() {

		return "index";
	}

	/**
	 * @return 时刻列表
	 */
	public String search() {
		IAtomService service = Server.getInstance().getAtomService();
		if (!isNotNullOrEpt(train.getStarttime())) {
			Timestamp now = this.getCurrentTime();
			now.setDate(now.getDate() + 2);
			train.setStarttime(super.formatTimestampyyyyMMdd(now));
		}
		this.trainlist = service.getSKTrainList(train.getStartcity(), train
				.getEndcity(), train.getStarttime());
		System.out.println("***************************************");
		System.out.println(trainlist.size());
		return "trainlist";

	}

	/**
	 * @return
	 * 
	 * 预定列表
	 */
	public String yptrain() {
		// IAtomService service = Server.getInstance().getAtomService();
		// DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// if (train.getStarttime() == null) {
		// train.setStarttime(super.formatTimestampyyyyMMdd(this
		// .getCurrentTime()));
		// }
		// String time;
		// try {
		// time = format.format(format.parse((train.getStarttime())));
		// train.setStarttime(time);
		// } catch (ParseException e) {
		// }
		// this.trainlist = service.getDGTrainList(train.getStartcity(), train
		// .getEndcity(), train.getStarttime());
		// for (Train ctrian : trainlist) {
		// if (ctrian.getTraincode().equals(this.train.getTraincode())) {
		// trainlist.remove(ctrian);
		// trainlist.add(0, ctrian);
		// break;
		// }
		// }
		System.out.println("***************************************");
		System.out.println("TrainAction:yptrain/train:yptrainlist.jsp");
		return "yptrain";
	}

	public void ajaxYPList() {
		HttpServletResponse response = ServletActionContext.getResponse();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(train.getTraincode());
		System.out.println(train.getStartcity());
		System.out.println(train.getEndcity());
		IAtomService service = Server.getInstance().getAtomService();
		if (train.getStarttime() == null) {
			train.setStarttime(super.formatTimestampyyyyMMdd(this
					.getCurrentTime()));
		}

		try {
			String time = format.format(format.parse((train.getStarttime())));
			train.setStarttime(time);
		} catch (ParseException e) {
		}
		System.out.println(train.getStarttime());
		this.trainlist = service.getDGTrainList(train.getStartcity(), train
				.getEndcity(), train.getStarttime());
		if (isNotNullOrEpt(train.getTraincode())) {
			for (Train ctrian : trainlist) {
				if (ctrian.getTraincode().equals(this.train.getTraincode())) {
					trainlist.remove(ctrian);
					trainlist.add(0, ctrian);
					break;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (Train train : trainlist) {
			builder.append("<TR ");
			if (i == 0) {
				builder.append("style='background: #d1e6f8'");
			}
			builder.append("class='" + train.getTraincode().substring(0, 1)
					+ "'>");
			builder.append("<TD height=\"50px\"><b class=\"lan14\">");
			builder.append(train.getTraincode() + "</b><br />");
			builder.append(train.getTraintype() + "</TD>");
			builder
					.append("<TD>" + train.getStartcity()
							+ train.getStarttime());
			builder.append("<br />");
			builder.append(train.getEndcity() + train.getEndtime() + "</TD>");
			builder.append("<TD>" + train.getDistance() + "公里<br />");
			builder.append(train.getCosttime() + "</TD>");
			// <!-- 硬座 -->
			builder.append("<TD>");
			builder.append(getTrainpriceByYP(train.getYzyp(), train
					.getYzprice(), "￥"));
			builder.append("</TD>");
			builder.append("<TD>");
			if (existSeat(train.getRz2yp())) {
				builder.append(getTrainpriceByYP(train.getRz2yp(), train
						.getRz2price(), "二等￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getRz1yp(), train
						.getRz1price(), "一等￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getRzyp(), train
						.getRzprice(), "普通￥"));
			} else {

				builder.append("<font style=\"color: #ccc\">--</font>");
				builder.append("</TD>");
			}
			builder.append("<TD>");

			if (existSeat(train.getYwyp())) {
				builder.append(getTrainpriceByYP(train.getYwyp(), train
						.getYwsprice(), "上￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getYwyp(), train
						.getYwzprice(), "中￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getYwyp(), train
						.getYwxprice(), "下￥"));
			} else {
				builder.append("<font style=\"color: #ccc\">--</font>");
			}
			builder.append("</TD>");
			builder.append("<TD>");
			if (existSeat(train.getRwyp())) {
				builder.append(getTrainpriceByYP(train.getRwyp(), train
						.getRwsprice(), "上￥"));
				builder.append("<br/>");
				builder.append(getTrainpriceByYP(train.getRwyp(), train
						.getRwxprice(), "下￥"));
				builder.append("<br/>");
			} else {
				builder.append("<font style=\"color: #ccc\">--</font>");
			}
			builder.append("</TD>");
			builder.append("<TD>");
			if (hasYP(train)) {
				builder
						.append("<img src=\"images/buyico.jpg\" style='margin-top:1px;cursor:pointer;'");
				builder.append("onclick=toordertrain(" + train.getJson()
						+ "); /><br/>");
			} else {
				builder.append("<font color='#cccccc'>已售完</font>");
			}
			builder.append("<span style='cursor: pointer; display:block' "
					+ "onclick=showInfo('" + train.getTraincode() + "'," + i
					+ ")>&nbsp;&nbsp;详情</span>");
			builder.append("</TD>");
			builder.append("</TR>");
			builder.append("<tr>");
			builder.append("<td colspan=\"8\" style=\"padding: 0\">");
			builder.append("<div class=\"tinfo lbox\" id='divinfo" + i
					+ "' style=\"display:none; text-align: center;");
			builder.append("width:670px; margin: 8px\">");
			builder.append("</div>");
			builder.append("</td>");
			builder.append("</tr>");
			builder.append("<tr>");
			builder
					.append("<td colspan=\"8\" style=\"height: 1px; line-height: 1px;");
			builder.append("overflow:hidden; padding: 0 \">");
			builder
					.append("<div style=\"height: 1px; background:#91c8e5; line-height: 1px;");
			builder.append("overflow: \">&nbsp;</div>");
			builder.append("</td>");
			builder.append("</tr>");
			i++;
		}

		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(builder.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return 到订单预定页面
	 */
	public String toordertrain() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println(train.getStartdate());
		session.setAttribute("ordertrain", train);
		StringBuilder builder = new StringBuilder("");
		StringBuilder pwbuilder = new StringBuilder("");
		System.out.println(train.getGwyp());
		if (existSeat(train.getGwyp())) {
			int yp = Integer.valueOf(train.getGwyp());
			if (yp > 0 && train.getGwxprice() > 0 && train.getGwsprice() > 0) {
				pwbuilder
						.append("<div id='daccept1' class='f'><input name='jszw' type=checkbox value='1'/>高级卧铺下</div>");
				pwbuilder
						.append("<div id='daccept2' class='f'><input name='jszw' type=checkbox value='2'/>高级卧铺上</div>");
				builder.append("<option value=\"{'type':1,price:"
						+ train.getGwxprice() + "}\">高级卧铺下"
						+ train.getGwxprice() + "</option>");
				builder.append("<option value=\"{'type':2,price:"
						+ train.getGwsprice() + "}\">高级卧铺上"
						+ train.getGwsprice() + "</option>");
			}
		}
		if (existSeat(train.getRwyp())) {
			int yp = Integer.valueOf(train.getRwyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept3' class='f'><input name='jszw' type=checkbox value='3'/>软卧下</div>");
				pwbuilder
						.append("<div id='daccept4' class='f'><input name='jszw' type=checkbox value='4'/>软卧上</div>");
				builder.append("<option value=\"{'type':3,'price':"
						+ train.getRwxprice() + "}\">软卧下" + train.getRwxprice()
						+ "</option>");
				builder.append("<option value=\"{'type':4,'price':"
						+ train.getRwsprice() + "}\">软卧上" + train.getRwsprice()
						+ "</option>");
			}
		}
		if (existSeat(train.getYwyp())) {
			int yp = Integer.valueOf(train.getYwyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept5' class='f'><input name='jszw' type=checkbox value='5'/>硬卧下</div>");
				pwbuilder
						.append("<div id='daccept6' class='f'><input name='jszw' type=checkbox value='6'/>硬卧上</div>");
				builder.append("<option value=\"{'type':5,'price':"
						+ train.getYwxprice() + "}\">硬卧下" + train.getYwxprice()
						+ "</option>");
				builder.append("<option value=\"{'type':6,'price':"
						+ train.getYwxprice() + "}\">硬卧上" + train.getYwsprice()
						+ "</option>");
			}

		}
		if (existSeat(train.getRzyp())) {
			int yp = Integer.valueOf(train.getRzyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept7' class='f'><input name='jszw' type=checkbox value='7'/>普通软座</div>");
				builder.append("<option value=\"{'type':7,'price':"
						+ train.getRzprice() + "}\">普通软座" + train.getRzprice()
						+ "</option>");
			}
		}
		if (existSeat(train.getRz1yp())) {
			int yp = Integer.valueOf(train.getRz1yp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept8' class='f'><input name='jszw' type=checkbox value='8'/>一等软座</div>");
				builder.append("<option value=\"{'type':8,'price':"
						+ train.getRz1price() + "}\">一等软座"
						+ train.getRz1price() + "</option>");
			}
		}
		if (existSeat(train.getRz2yp())) {
			int yp = Integer.valueOf(train.getRz2yp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept9' class='f'><input name='jszw' type=checkbox value='9'/>二等软座</div>");
				builder.append("<option value=\"{'type':9,'price':"
						+ train.getRz2price() + "}\">二等软座"
						+ train.getRz2price() + "</option>");
			}
		}
		if (existSeat(train.getYzyp())) {
			int yp = Integer.valueOf(train.getYzyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept10' class='f'><input name='jszw' type=checkbox value='10'/>硬座</div>");
				builder.append("<option value=\"{'type':10,'price':"
						+ train.getYzprice() + "}\">硬座" + train.getYzprice()
						+ "</option>");
			}
		}

		if (train.getWzyp() != null && train.getWzyp().equals("有")) {
			pwbuilder
					.append("<div id='d10' class='f'><input name='jszw' type=checkbox value='11'/>无座</div>");
			builder.append("<option value=\"{'type':11,'price':"
					+ train.getYzprice() + "}\">无座" + train.getYzprice()
					+ "</option>");
		}
		request.setAttribute("zwhtml", builder.toString());
		request.setAttribute("jszw", pwbuilder.toString());
		return "toordertrain";

	}

	/**
	 * 预定车票 生成订单
	 * 
	 * @return
	 */
	public String ordertrain() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Train ordertrain = (Train) session.getAttribute("ordertrain");
		session.removeAttribute("ordertrain");
		session.removeAttribute("orderuserlogin");
		String totalprice = request.getParameter("frometo");
		ordertrain.setCreatetime(this.getCurrentTime());
		ordertrain.setOrderstatus(1);// 未支付
		ordertrain.setCreateuid(this.getLoginUserId());// 预订人
		ordertrain.setMemberid(0);// 会员ID，流程更改，已无用
		ordertrain.setAgentid(46);// 网站散客
		ordertrain.setTotalprice(Float.valueOf(totalprice.trim()));
		ordertrain.setSeattype(train.getSeattype());
		ordertrain.setDeliveryadd(train.getDeliveryadd());
		ordertrain.setDeliverytype(train.getDeliverytype());
		ordertrain.setPost(train.getPost());
		ordertrain.setContactname(train.getContactname());
		ordertrain.setContactmobile(train.getContactmobile());
		ordertrain.setCount(train.getCount());
		ordertrain.setMemo(train.getMemo());
		ordertrain.setPaymethod(1);// 网上支付
		ordertrain.setPaystatus(1);// 未支付
		String[] acceptseats = request.getParameterValues("jszw");
		if (acceptseats != null && acceptseats.length > 0) {
			StringBuilder accept = new StringBuilder();
			for (String s : acceptseats) {
				if (accept.length() > 0) {
					accept.append(",");
				}
				accept.append(s);
			}
			ordertrain.setAcceptseat(accept.toString());
		}

		try {
			this.installService();
			ordertrain = this.trainservice.createTrain(ordertrain);
			String ordernumber = Server.getInstance().getServiceCenter()
					.getTrainCode(ordertrain);
			ordertrain.setOrdernumber(ordernumber);
			trainservice.updateTrainIgnoreNull(ordertrain);
			String[] pnames = request.getParameterValues("pname");
			if (pnames != null && pnames.length > 0) {
				String[] idtypes = request.getParameterValues("idtype");
				String[] idnumbers = request.getParameterValues("idnumber");
				for (int i = 0; i < pnames.length; i++) {
					String pname = pnames[i];
					if (pname.trim().length() > 0) {
						String idtype = idtypes[i];
						String idnumber = idnumbers[i];
						Trainpassenger passenger = new Trainpassenger();
						passenger.setName(pname);
						System.out.println(ordertrain.getId());
						passenger.setOrderid(ordertrain.getId());
						passenger.setIdtype(Integer.valueOf(idtype));
						passenger.setIdnumber(idnumber);
						this.trainservice.createTrainpassenger(passenger);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.train = ordertrain;
		session.setAttribute("ordertrain", train);
		this.forword = "http://" + request.getServerName() + ":"
				+ request.getServerPort()
				+ "/interface/Alipay?helpername=Trainpayhelper&orderid="
				+ train.getId();
		return "orderpay";
	}

	public String ordersuccess() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		this.train = (Train) session.getAttribute("ordertrain");
		session.removeAttribute("ordertrain");
		return "ordersuccess";
	}

	public String toPay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.forword = "http://" + request.getServerName() + ":"
				+ request.getServerPort()
				+ "/interface/Alipay?helpername=Trainpayhelper&orderid="
				+ train.getId();
		System.out.println(forword);
		return "orderpay";
	}

	/**
	 * 火车票订单列表
	 * 
	 * @return
	 */
	public String trainorder() {
		this.installService();
		HttpServletRequest request = ServletActionContext.getRequest();
	
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
	
		if (isNotNullOrEpt(train.getOrdernumber())) {
			where.append(" AND C_ORDERNUMBER LIKE '%" + train.getOrdernumber()
					+ "%'");
		}
		if (train.getOrderstatus() > 0) {
			where.append(" AND C_ORDERSTATUS=" + train.getOrderstatus());
		}
		String createtime = this.getCheckTime(this.startcreatetime,
				this.endcreatetime, "C_CREATETIME");
		if (isNotNullOrEpt(createtime)) {
			where.append(" AND C_CREATETIME (" + createtime + ")");
		}
		List list = trainservice.findAllTrainForPageinfo(where.toString(),
				" ORDER BY ID DESC ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		this.trainlist = list;
	
		System.out
				.println("train!trainorder.action/train:trainorderrecord.jsp");
		return "trainorder";
	}

	public String trainreport() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String sql="SELECT * FROM view_trainorderrebate   ";
		List list=Server.getInstance().getSystemService().findMapResultSortBySql(sql, " ORDER BY ID DESC ", pageinfo);
		pageinfo=(PageInfo)list.remove(0);
		request.setAttribute("trainrebatelist", list);
		
		
		
		
		

		System.out
				.println("train!trainreport.action/report:trainrebatreport.jsp");
		return "trainreport";
	}

	public String processOrder() {
		this.installService();
		int orderstatus = train.getOrderstatus();
		if(orderstatus==5){
			Train ctrain=this.trainservice.findTrain(train.getId());
			if(ctrain.getAgentid()==46&&ctrain.getMemberid()!=1){
				Server.getInstance().getAtomService().createTrainrebate(ctrain);
			}
		}
		
		if (orderstatus > 0) {
			this.trainservice.updateTrainIgnoreNull(train);
		}
		return this.trainorder();
	}

	/**
	 * 订单详细信息
	 * 
	 * @return
	 */
	public String orderdetail() {
		this.installService();
		this.train = trainservice.findTrain(train.getId());
		String acceptseat = train.getAcceptseat();
		if (isNotNullOrEpt(acceptseat)) {
			String[] seats = acceptseat.split(",");
			StringBuilder sb = new StringBuilder("");
			for (String seat : seats) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(seat);
			}
			String sql = " SELECT * FROM T_TRAINSEAT WHERE C_SEATKEY IN ("
					+ sb.toString() + ") ";
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, null);
			StringBuilder sbseats = new StringBuilder("");
			for (int i = 0; i < list.size(); i++) {
				Map m = (Map) list.get(i);
				if (sbseats.length() > 0) {
					sbseats.append(",");
				}
				sbseats.append(m.get("C_SEATVAL").toString());
			}
			train.setAcceptseatval(sbseats.toString());
		}
		this.trainpassengerlist = trainservice.findAllTrainpassenger(
				"WHERE C_ORDERID=" + train.getId(), "", -1, 0);
		return "orderdetail";
	}

	public String getAgentRootreplenish() {

		return "var root_0=new Ext.tree.TreeNode({text:\"网站散客\",id:'0'});root.appendChild(root_0)";
	}

	/**
	 * 列车坐席价格
	 * 
	 * @param train
	 * @return
	 */
	public String getTicketPriceHtml(Train train) {
		StringBuilder pricehtml = new StringBuilder("");
		if (isntNullorZero(train.getYzprice())) {
			pricehtml.append("硬座" + train.getYzprice() + "元");
		}
		if (isntNullorZero(train.getYwsprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("硬卧" + train.getYwsprice() + "/"
					+ train.getYwzprice() + "/" + train.getYwxprice() + "元");
		}
		if (isntNullorZero(train.getRzprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("普通软坐" + train.getRzprice() + "元");
		}
		if (isntNullorZero(train.getRz2price())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("二等软座" + train.getRz2price() + "元");
		}
		if (isntNullorZero(train.getRz1price())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("一等软座" + train.getRz1price() + "元");
		}
		if (isntNullorZero(train.getRwsprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("软卧" + train.getRwsprice() + "/"
					+ train.getRwxprice() + "元");
		}
		if (isntNullorZero(train.getGwsprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("高级软卧" + train.getGwsprice() + "/"
					+ train.getGwxprice() + "元");
		}
		return pricehtml.toString();
	}

	private boolean isntNullorZero(Float value) {
		if (value == null || value == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 根据余票显示不同颜色坐席
	 * 
	 * @param yp
	 * @param price
	 * @param info
	 * @return
	 */
	public String getTrainpriceByYP(String yp, Float price, String info) {
		System.out.println(yp + "|" + price + "|" + info);
		try {
			int ypcount = Integer.valueOf(yp);
			if (ypcount > 0) {
				return "<font style='color:#3582c8' >" + info + price + "("
						+ yp + ")</font>";
			} else {
				return "<font style='color:#ccc'>" + info + price + "</font>";
			}
		} catch (Exception e) {
			return "<font style='color:#ccc'>--</font>";
		}

	}

	public boolean existSeat(String yp) {
		try {
			Integer.parseInt(yp);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean hasYP(Train train) {
		int yp = 0;
		// try {
		// if (train.getWzyp().trim().equals("有")) {
		// return true;
		// }
		// } catch (Exception e) {
		//
		// }
		try {
			yp = Integer.valueOf(train.getYzyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getYwyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}

		try {
			yp = Integer.valueOf(train.getRz2yp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getRz1yp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getRzyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getRwyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getGwyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}
	public String GetYongShi(String stime,String etime) {
		long minute1=0l;
		try {
			SimpleDateFormat dfs = new SimpleDateFormat("HH:mm");
			java.util.Date begin=dfs.parse(stime);
			java.util.Date end = dfs.parse(etime);
			long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒

			long day1=between/(24*3600);
			long hour1=between%(24*3600)/3600;
			minute1 = between%3600/60;
			long second1=between%60/60;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
		
		return minute1+"";
		
		
	}
	public void ajaxGetTrainInfo2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");

		String traincode = request.getParameter("traincode");
		String date = request.getParameter("startdate");
		List<Map<String, String>> listmap = Server.getInstance()
				.getAtomService().getTrainInfo(traincode, date);
		StringBuilder htmlbuilder = new StringBuilder("");
		htmlbuilder.append("showTrainInfo(new Array(");
		int i = 0;
		for (Map<String, String> map : listmap) {
			if (i != 0) {
				htmlbuilder.append(",");
			}
			htmlbuilder.append("{");
			htmlbuilder.append("'sno':'" + map.get("sno") + "',");
			htmlbuilder.append("'sname':'" + map.get("sname") + "',");
			htmlbuilder.append("'arrtime':'" + map.get("arrtime") + "',");
			htmlbuilder.append("'gotime':'" + map.get("gotime") + "',");
			htmlbuilder.append("'costtime':'" + map.get("costtime") + "',");
			htmlbuilder.append("'distance':'" + map.get("distance") + "',");
			htmlbuilder.append("'yz':'" + map.get("yz") + "',");
			// htmlbuilder.append("'rz':'"+map.get("rz")+"',");
			// htmlbuilder.append("'rz1':'"+map.get("rz1")+"',");
			htmlbuilder.append("'rz2':'" + map.get("rz2") + "',");
			htmlbuilder.append("'yws':'" + map.get("yws") + "',");
			htmlbuilder.append("'ywz':'" + map.get("ywz") + "',");
			htmlbuilder.append("'ywx':'" + map.get("ywx") + "'");
			// htmlbuilder.append("'rws':'"+map.get("rws")+"',");
			// htmlbuilder.append("'rwx':'"+map.get("rwx")+"'");
			htmlbuilder.append("}");
			i++;
		}
		htmlbuilder.append("));");
		try {
			System.out.println(htmlbuilder.toString());
			PrintWriter out = response.getWriter();
			out.print(htmlbuilder.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String getTicketPriceHtml_new(Train train) {
		StringBuilder pricehtml = new StringBuilder("<table  cellspacing='0' cellpadding='1' align='center' style='width:100%'>");
		//StringBuilder pricehtml = new StringBuilder("");
		if (isntNullorZero(train.getYzprice())) {
			pricehtml.append("<tr><td>");
			pricehtml.append("硬座：￥<b>" + train.getYzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getYwsprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("硬卧：￥<b>" + train.getYwsprice() + "/"
					+ train.getYwzprice() + "/" + train.getYwxprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRzprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("软坐：￥<b>" + train.getRzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRz2price())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("二等：￥<b>" + train.getRz2price() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRz1price())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("一等：￥<b>" + train.getRz1price() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getSwzprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("商务：￥<b>" + train.getSwzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getTdzprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("特等：￥<b>" + train.getTdzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRwsprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("软卧：￥<b>" + train.getRwsprice() + "/"
					+ train.getRwxprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getGwsprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("高级软卧：￥<b>" + train.getGwsprice() + "/"
					+ train.getGwxprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		pricehtml.append("</table>");
		
		System.out.println(pricehtml.toString());
		
		return pricehtml.toString();
	}
	public void ajaxGetTrainInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");

		String traincode = request.getParameter("traincode");
		String date = request.getParameter("startdate");
		List<Map<String, String>> listmap = Server.getInstance()
				.getAtomService().getTrainInfo(traincode, date);
		StringBuilder htmlbuilder = new StringBuilder("");
		htmlbuilder.append("<table  cellspacing='0' cellpadding='1' align='center' style='width:100%'><tr>");
		int i = 0;
		for (Map<String, String> map : listmap) {
			htmlbuilder.append("<td>"+map.get("sname")+"<br />");
			if(i==0&&map.get("arrtime").equals(map.get("gotime"))){
				htmlbuilder.append("<span class='color'>发时:"+map.get("gotime")+"</span><br />");
			}else if(i!=0&&map.get("arrtime").equals(map.get("gotime"))){
				htmlbuilder.append("<span class='color'>到时:"+map.get("gotime")+"</span><br />");
			}else{
			htmlbuilder.append("<span class='color'>"+map.get("arrtime")+"—"+map.get("gotime")+"</span><br />");
			htmlbuilder.append("<span class='color'>停"+GetYongShi(map.get("arrtime"),map.get("gotime"))+"分</span>");
			}
			
			htmlbuilder.append("</td>");
			i++;
			if(i==8||i==16||i==24||i==32){
				htmlbuilder.append("</tr><tr>");
				System.out.println("??????????????????");

			}
			
		}
		htmlbuilder.append("</tr></table>");
		try {
			System.out.println(htmlbuilder.toString());
			PrintWriter out = response.getWriter();
			out.print(htmlbuilder.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void installService() {
		if (trainservice == null) {
			this.trainservice = Server.getInstance().getTrainService();
		}
	}

	/**
	 * 转向到火车时刻表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 返回火车时刻表对象
	 */

	public Object getModel() {
		return train;
	}

	public List<Train> getListTrain() {
		return listTrain;
	}

	public void setListTrain(List<Train> listTrain) {
		this.listTrain = listTrain;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public List<Train> getTrainlist() {
		return trainlist;
	}

	public void setTrainlist(List<Train> trainlist) {
		this.trainlist = trainlist;
	}

	public String getAgentroot() {
		return agentroot;
	}

	public void setAgentroot(String agentroot) {
		this.agentroot = agentroot;
	}

	public String getEndcreatetime() {
		return endcreatetime;
	}

	public void setEndcreatetime(String endcreatetime) {
		this.endcreatetime = endcreatetime;
	}

	public String getStartcreatetime() {
		return startcreatetime;
	}

	public void setStartcreatetime(String startcreatetime) {
		this.startcreatetime = startcreatetime;
	}

	public List<Trainpassenger> getTrainpassengerlist() {
		return trainpassengerlist;
	}

	public void setTrainpassengerlist(List<Trainpassenger> trainpassengerlist) {
		this.trainpassengerlist = trainpassengerlist;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

}