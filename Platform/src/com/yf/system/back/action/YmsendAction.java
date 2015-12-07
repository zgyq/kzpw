package com.yf.system.back.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.messgroup.Messgroup;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.templet.Templet;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.ymsend.Ymsend;
import com.opensymphony.webwork.ServletActionContext;

public class YmsendAction extends B2b2cbackAction {
	private List<Ymsend> listYmsend;
	private Ymsend ymsend = new Ymsend();
	private String s_name;
	private int[] selectid;
	private List<Customeruser> listemployee;
	private String s_phone;
	private long s_employeeid;
	private String s_stratedate;
	private String s_endedate;
	private int opt;
	private Map<String, String> maptempltes = new HashMap<String, String>();
	private String templtes;// 模板
	private String tem;
	private String txtphone;
	private String addserial;
	private String txtmessage;
	private String sendtime;
	private String sendtype;
	private List<Messgroup> listcutomerpassenger;
	private List<Messgroup> listmess;
	private String temp;
	private List<Templet> listtemplet;
	private List<Templet> listtem;
	
	private String forward;
	private Long orderid;//订单ID
	// search
	// private String s_name;

	
	public List<Templet> getListtem() {
		return listtem;
	}

	public void setListtem(List<Templet> listtem) {
		this.listtem = listtem;
	}

	public List<Templet> getListtemplet() {
		return listtemplet;
	}

	public void setListtemplet(List<Templet> listtemplet) {
		this.listtemplet = listtemplet;
	}

	public List<Messgroup> getListmess() {
		return listmess;
	}

	public void setListmess(List<Messgroup> listmess) {
		this.listmess = listmess;
	}

	public String getSendtype() {
		return sendtype;
	}

	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getAddserial() {
		return addserial;
	}

	public void setAddserial(String addserial) {
		this.addserial = addserial;
	}

	public String getTxtmessage() {
		return txtmessage;
	}

	public void setTxtmessage(String txtmessage) {
		this.txtmessage = txtmessage;
	}

	public String getTem() {
		return tem;
	}

	public void setTem(String tem) {
		this.tem = tem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork.ActionSupport#execute()
	 */
	public String execute() throws Exception {

		/**
		 * 重新发送短信
		 * 
		 */
		String ajax = ServletActionContext.getRequest().getParameter("ajax");
		if (ajax != null && ajax.length() > 0) {
			String[] phonenums = ServletActionContext.getRequest()
					.getParameterValues("phonenum");
			String returnvalue = "true";
			String content = "";
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			long state = 0;
			int r = 0;
			for (String str : phonenums) {
				long id = Long.valueOf(str);
				Ymsend ym = Server.getInstance().getMemberService().findYmsend(
						id);
				if(ym.getType()==null){
					ym.setType(2);
				}
				if (ym.getType() == 1) {// 飞友 定制短信
					String where = " WHERE C_ORDERNUMBER='" + ym.getOrdercode()
							+ "'";
					Orderinfo orderinfo = (Orderinfo) Server.getInstance()
							.getAirService().findAllOrderinfo(where, "", -1, 0)
							.get(0);
					String pname = "旅客";
					if (orderinfo.getContactmobile() != null
							&& orderinfo.getContactmobile().trim().equals(
									ym.getPhone().trim())) {
						if (orderinfo.getContactname() != null
								&& orderinfo.getContactname().trim().length() > 0) {
							pname = orderinfo.getContactname();
						}
					} else {
						where = " WHERE " + Passenger.COL_orderid + "=(SELECT "
								+ Orderinfo.COL_id + " FROM " + Orderinfo.TABLE
								+ " WHERE " + Orderinfo.COL_ordernumber + "='"
								+ ym.getOrdercode() + "' )";
						List<Passenger> passengers = Server.getInstance()
								.getAirService().findAllPassenger(where, "",
										-1, 0);
						for (Passenger passenger : passengers) {
							if (passenger.getMobile() != null
									&& passenger.getMobile().trim().equals(
											ym.getPhone().trim())) {
								pname = passenger.getName();
								break;
							}
						}
					}

					where = " WHERE C_ORDERID=(SELECT ID FROM T_ORDERINFO WHERE C_ORDERNUMBER ='"
							+ ym.getOrdercode() + "')";
					Segmentinfo segment = (Segmentinfo) Server.getInstance()
							.getAirService().findAllSegmentinfo(where, "", -1,
									0).get(0);

					content = "手机号" + ym.getPhone() + "，订单号:"
							+ ym.getOrdercode() + "定制的航班动态短信，定制成功！";
					r = Server.getInstance().getAtomService().sendFeiyouSms(
							ym.getPhone(),
							this.formatTimestamp2(segment.getDeparttime()),
							segment.getFlightnumber(),
							segment.getStartairport(), segment.getEndairport(),
							pname, "0", null, ym.getOrdercode());

				} else {// 浪驰短信
					// this.smsSend(new
					// String[]{""+orderinfo.getContactmobile()+""} ,
					// smstemple,
					// orderinfo.getOrdernumber()+"-"+orderinfo2.getOrdernumber(),getLoginUserId()+"");
					r = smsSend(new String[] { ym.getPhone() },
							ym.getContent(), ym.getOrdercode(), String
									.valueOf(this.getLoginUserId()));
					
					content = ym.getContent();
				}

				if (r < 0) {
					// 短信发送失败
					if (returnvalue.equals("true")) {
						returnvalue = "";
					}
					if (returnvalue.length() > 0) {
						returnvalue += ";" + ym.getPhone();
					} else {
						returnvalue += ym.getPhone();
					}

					state = 6;
				}
				Ymsend send = new Ymsend();
				send.setContent(content);
				send.setCreatetime(new Timestamp(System.currentTimeMillis()));
				send.setOrdercode(ym.getOrdercode());
				send.setType(ym.getType());
				send.setDescription(ym.getDescription());
				send.setPhone(ym.getPhone());
				send.setState(state);
				Server.getInstance().getMemberService().createYmsend(send);

			}
			System.out.println(returnvalue);
			out.print(returnvalue);
			out.flush();
			out.close();
			/**
			 * 已发送短信列表 }
			 */
		} else {
			String where = " where 1=1 ";

			listemployee = Server.getInstance().getMemberService()
					.findAllCustomeruser(
							"where C_MEMBERTYPE=2 and C_AGENTID=46 and ID<>62",
							"", -1, 0);

			if (s_phone != null && s_phone.trim().length() != 0) {

				where += " and " + Ymsend.COL_phone + " = '" + s_phone.trim()
						+ "'";
			}
			if (s_employeeid != 0) {

				where += " and " + Ymsend.COL_description + " = '"
						+ s_employeeid + "'";
			}
			if (s_stratedate != null && s_stratedate.trim().length() != 0
					&& s_endedate != null && s_endedate.trim().length() != 0) {

				where += " and " + Ymsend.COL_createtime + " between '"
						+ s_stratedate + " 00:00:00' and '" + s_endedate
						+ " 23:59:59'";
			}

			if (ymsend.getOrdercode() != null
					&& ymsend.getOrdercode().trim().length() > 0) {
				where += " AND " + Ymsend.COL_ordercode + " LIKE '%"
						+ ymsend.getOrdercode() + "%'";
			}
			if (ymsend.getState() != null) {
				where += " AND (" + Ymsend.COL_state + "=" + ymsend.getState()
				+ " or " + Ymsend.COL_state + "=1)";
			}
			

			List list = Server.getInstance().getMemberService()
					.findAllYmsendForPageinfo(where, " ORDER BY ID DESC",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listYmsend = list;
			if (pageinfo.getTotalrow() > 0 && listYmsend.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getMemberService()
						.findAllYmsendForPageinfo(where, " ORDER BY ID DESC",
								pageinfo);
				pageinfo = (PageInfo) list.remove(0);

				listYmsend = list;
				if (pageinfo.getTotalrow() > 0 && listYmsend.size() == 0) {
					pageinfo.setPagenum(1);
					list = Server.getInstance().getMemberService()
							.findAllYmsendForPageinfo(where,
									" ORDER BY ID DESC", pageinfo);
					pageinfo = (PageInfo) list.remove(0);
					listYmsend = list;
				}
			}
		}
		return SUCCESS;
	}

	private String s_ordernumber;

	/**
	 * 短信模板
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toadd() throws Exception {

		// 加载短信模板
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser customeruser = (Customeruser) session
				.getAttribute("loginuser");
		String where = " where " + Templet.COL_createuserid + "="
				+ customeruser.getId();
		listtemplet = Server.getInstance().getMemberService().findAllTemplet(
				where, "order by id", -1, 0);
		getCustomerpassengerlist();
		return EDIT;
	}
	
	public String toadd2() throws Exception {

		
		return "tosend";
	}

	/**
	 * 读取短信模板
	 * 
	 * @throws Exception
	 */
	public void getMessage() throws Exception {

		toadd();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser customeruser = (Customeruser) session
				.getAttribute("loginuser");
			String where = " where " + Templet.COL_createuserid + " = "
				+ customeruser.getId() + " and " + Templet.COL_id + " = "
				+ templtes;
		listtem = Server.getInstance().getMemberService().findAllTemplet(where,
				"order by id", -1, 0);
		
		String strtemp = "";
		if (listtem.size() > 0) {
			strtemp = listtem.get(0).getTempletmess();
		}
		PrintWriter out = response.getWriter();
		System.out.println(strtemp);
		out.print(strtemp);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void getCuslist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		getCustomerpassengerlist();
		// String strtemp="";
		// if(templtes!=null){
		// strtemp=maptempltes.get(templtes);
		// }
		PrintWriter out = response.getWriter();
		// System.out.println(strtemp);
		// out.print(strtemp);
		out.flush();
		out.close();
	}

	public String toedit() throws Exception {
		ymsend = Server.getInstance().getMemberService().findYmsend(
				ymsend.getId());
		return EDIT;
	}

	public String tocheck() throws Exception {
		ymsend = Server.getInstance().getMemberService().findYmsend(
				ymsend.getId());
		return CHECK;
	}

	public String add() throws Exception {
		// 发送短信
		String[] mobiles = {};
		if (ymsend.getPhone().indexOf(",") > 0) {
			mobiles = ymsend.getPhone().split(",");
		} else {
			mobiles = new String[] { "" + ymsend.getPhone() + "" };
		}
		int v = smsSend(mobiles, ymsend.getContent(), ymsend.getOrdercode(),
				getLoginUserId() + "");

		// Ymsend send = new Ymsend();
		// send.setContent(ymsend.getContent());
		// send.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// send.setOrdercode("");
		// send.setType(2);
		// send.setDescription("");
		// String phone=Arrays.toString(mobiles).replace("[", "");
		// phone=phone.replace("]", "");
		// send.setPhone(phone);
		// send.setState(Long.valueOf(v));
		// Server.getInstance().getMemberService().createYmsend(send);

		return LIST;
	}

	public String check() throws Exception {

		Server.getInstance().getMemberService().updateYmsendIgnoreNull(ymsend);
		return LIST;
	}

	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateYmsendIgnoreNull(ymsend);
		return LIST;
	}

	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteYmsend(ymsend.getId());
		return LIST;
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {

			switch (opt) {
			case 1: // delete

				for (int i : selectid) {
					Server.getInstance().getMemberService().deleteYmsend(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	public Object getModel() {
		return ymsend;
	}

	public List<Ymsend> getListYmsend() {
		return listYmsend;
	}

	public void setListYmsend(List<Ymsend> listYmsend) {
		this.listYmsend = listYmsend;
	}

	public Ymsend getYmsend() {
		return ymsend;
	}

	public void setYmsend(Ymsend ymsend) {
		this.ymsend = ymsend;
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

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public List<Customeruser> getListemployee() {
		return listemployee;
	}

	public void setListemployee(List<Customeruser> listemployee) {
		this.listemployee = listemployee;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public long getS_employeeid() {
		return s_employeeid;
	}

	public void setS_employeeid(long s_employeeid) {
		this.s_employeeid = s_employeeid;
	}

	public String getS_stratedate() {
		return s_stratedate;
	}

	public void setS_stratedate(String s_stratedate) {
		this.s_stratedate = s_stratedate;
	}

	public String getS_endedate() {
		return s_endedate;
	}

	public void setS_endedate(String s_endedate) {
		this.s_endedate = s_endedate;
	}

	public String getS_ordernumber() {
		return s_ordernumber;
	}

	public void setS_ordernumber(String s_ordernumber) {
		this.s_ordernumber = s_ordernumber;
	}

	public Map<String, String> getMaptempltes() {
		return maptempltes;
	}

	public void setMaptempltes(Map<String, String> maptempltes) {
		this.maptempltes = maptempltes;
	}

	public String getTempltes() {
		return templtes;
	}

	public void setTempltes(String templtes) {
		this.templtes = templtes;
	}

	public String getTxtphone() {
		return txtphone;
	}

	public void setTxtphone(String txtphone) {
		this.txtphone = txtphone;
	}
	
	/*
	 * 
	 */
	
	
	public String sendSms() throws Exception{
		
		int state;
		String[] phone = {};
		if (txtphone.indexOf(",") > 0) {
			phone = txtphone.split(",");
		} else {
			phone = new String[] { "" + txtphone + "" };
		}
		
		state = Server.getInstance().getAtomService().sendSms(phone,
				txtmessage, orderid+"", "2");
		System.out.println("state:"+state);
		//forward="b2bticketorder!showOrderdetail.action?id="+orderid;
		return "toorder";
	}

	/**
	 * 发送定时/即时短信
	 * 
	 * @throws SQLException
	 */
	public String sendLuckySms() throws SQLException {
		int state;
		String[] phone = {};
		if (txtphone.indexOf(",") > 0) {
			phone = txtphone.split(",");
		} else {
			phone = new String[] { "" + txtphone + "" };
		}
		sendtime = sendtime.trim();
		sendtime = sendtime.replace("-", "");
		sendtime = sendtime.replace(" ", "");
		sendtime = sendtime.replace(":", "");
		if (sendtype.equals("2")) {
			// state=Server.getInstance().getAtomService().sendLuckySms(phone,
			// txtmessage, addserial);
			state = Server.getInstance().getAtomService().sendSms(phone,
					txtmessage, addserial, getLoginUser().getMembername());
		} else {
			// state =
			// Server.getInstance().getAtomService().sendTimeingSms(phone,txtmessage,
			// addserial, sendtime);
			state = Server.getInstance().getAtomService().sendSms(phone,
					txtmessage, addserial, sendtime);
		}
		System.out.println("++++++++++"+state);
		
		if (state == 0) {
			return "sendsuccess";
		} else if (state == 18) {
			return "senderror";
		} else {
			return "senderror";
		}
	}

	/**
	 * 短信充值。
	 * 
	 * @return
	 */
	public String smspay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map map = new HashMap();
		map.put("billname", "SMSRechargeHelper");// 对应接口中支付帮助类
		map.put("orderprice", 100);
		map.put("orderid", 67);
		request.setAttribute("ordermap", map);
		request.setAttribute("vmoneyrecharge", "");
		return "smspay";
	}

	/**
	 * 得到用户常用旅客列表
	 * 
	 * @return
	 */
	public void getCustomerpassengerlist() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser customeruser = (Customeruser) session
				.getAttribute("loginuser");
		String where = " where " + Messgroup.COL_createuserid + "="
				+ customeruser.getId();
		// listcutomerpassenger = Server.getInstance().getMemberService()
		// .findAllCustomerpassenger(where, "ORDER BY ID", -1, 0);
		// listcutomerpassenger.get(0).setMobile("15110280546");
		listcutomerpassenger = Server.getInstance().getMemberService()
				.findAllMessgroup(where, "order by id", -1, 0);
	}

	public void getmessgroup() throws Exception {
		toadd();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customeruser customeruser = (Customeruser) session
				.getAttribute("loginuser");
		if(temp!=null){
		String where = " where " + Messgroup.COL_createuserid + " = "
				+ customeruser.getId() + " and " + Messgroup.COL_id + " = "
				+ temp;
		
		listmess = Server.getInstance().getMemberService().findAllMessgroup(
				where, "order by id", -1, 0);
		}
		String strtemp = "";
		if (listmess.size() > 0) {
			strtemp = listmess.get(0).getMessnums();
		}
		PrintWriter out = response.getWriter();
		System.out.println(strtemp);
		out.print(strtemp);
		out.flush();
		out.close();
	}
	/**
	 * 读取txt文档
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	private String filepath;//文件路径
	private StringBuffer buff;
	 public void getTextFromTxt() throws Exception {    
		 HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
	        FileReader fr = new FileReader(this.filepath);    
	        BufferedReader br = new BufferedReader(fr);    
	        buff = new StringBuffer();    
	        String temp = null;    
	        while((temp = br.readLine()) != null){    
	            buff.append(temp);    
	        }    
	        br.close();  
	        String strtemp = "";
			if (buff.length()>0) {
				strtemp = buff.toString();
			}
			PrintWriter out = response.getWriter();
			System.out.println(strtemp);
			out.print(strtemp);
			out.flush();
			out.close();
	 }
	public List<Messgroup> getListcutomerpassenger() {
		return listcutomerpassenger;
	}

	public void setListcutomerpassenger(List<Messgroup> listcutomerpassenger) {
		this.listcutomerpassenger = listcutomerpassenger;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public StringBuffer getBuff() {
		return buff;
	}

	public void setBuff(StringBuffer buff) {
		this.buff = buff;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


}