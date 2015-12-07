package com.yf.system.back.policy;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yf.system.atom.interticket.HttpClient;
import com.yf.system.back.server.Server;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.service.ISystemService;
import com.yf.system.base.util.Util;

/**
 * 8000yi订单状态通知
 * 
 * @author 小陈
 * 
 */
public class EightyiNotify extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(EightyiNotify.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.error("八千翼通知调用："+request.getQueryString());
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String platform = request.getParameter("platform");// 平台名称
		String type = request.getParameter("type");// 通知类型
		String outorderid = request.getParameter("orderguid");// 订单号
		String orderstate = request.getParameter("orderstate");// 订单状态
		String notifymsg = request.getParameter("notifymsg");// 通知信息
		String key = request.getParameter("key");
		String message = "platform:" + platform + ".type:" + type
				+ ".outorderid:" + outorderid + "。orderstate：" + orderstate
				+ ".notifymsg" + notifymsg;
		logger.error(message);
		// Key= $%^+订单号+通知信息+平台名称+$8000yi$
		String valkekstr = "$%^" + outorderid + notifymsg + "8000YI"
				+ "$8000yi$";
		String valkey = "";
		try {
			valkey = HttpClient.MD5(valkekstr).toUpperCase();

			String s = Util.MD5(valkekstr).toUpperCase();
			System.out.println(s);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("mykey:" + valkey);
		//&& key.equals(valkey)) || "2".equals(type)
		if (key != null &&type!=null) {// 请先验证key,如key值不一致则不需处理该通知。由于出票key与本地加密key总
			String where = "WHERE C_EXTORDERID='" + outorderid + "'";
			Orderinfo orderinfo = (Orderinfo) Server.getInstance()
					.getAirService().findAllOrderinfo(where, "", -1, 0).get(0);
			try {
				StringBuilder other = new StringBuilder();
				if ("2".equals(type)) {// 出票完成
					orderstate = "3";// 出票完成
				}
				if (type.equals("1")) {// 支付完成
					orderstate = "2";
					String megs[] = notifymsg.split("\\^");
					String price = megs[megs.length - 1];
					other.append(",C_EXTORDERPRICE=" + price);

				}
				if (type.equals("3") || type.equals("4")) {
					// 订单号^交易号^退款金额^成功或者拒绝的描述^手续费 (退票通知)
					String megs[] = notifymsg.split("\\^");
					try {
						float returnprice = Float.valueOf(megs[2]);
						other.append(",C_EXTRETURNPRICE=" + returnprice);
						PolicyNotifySupport.log(orderinfo.getId(), null, "供应退废通知：交易号"+megs[1]+",退款金额"+returnprice);
					} catch (Exception e) {

					}

				}
				
				//订单号^交易号^退款金额--^拒绝理由 (取消出票) 
				if("5".equals(type)){
					String[] mesg=notifymsg.split("\\^");
					String bussinessno=mesg[1];
					String returnprice=mesg[2];//退款金额
					other.append(",C_EXTRETURNPRICE=" + returnprice);
					PolicyNotifySupport.log(orderinfo.getId(), null, "供应拒单，取消出票。交易号："+bussinessno+"。退款金额："+returnprice);
				}

				StringBuilder sql = new StringBuilder(
						"UPDATE T_ORDERINFO SET C_EXTORDERSTATUS=" + orderstate);
				sql.append(other + " WHERE C_EXTORDERID='" + outorderid + "'");
				if (type.equals("2")) {
					String megs[] = notifymsg.split("\\^");
					String names[] = megs[1].split("\\|");
					String tikcets[] = megs[2].split("\\|");
					for (int i = 0; i < names.length; i++) {
						sql
								.append(";UPDATE T_PASSENGER SET C_TICKETNUM='"
										+ tikcets[i]
										+ "' WHERE C_NAME='"
										+ names[i]
										+ "' AND  C_ORDERID =(SELECT TOP 1 ID FROM T_ORDERINFO WHERE C_EXTORDERID='"
										+ outorderid + "')");
					}

				}
				

				ISystemService service = Server.getInstance().getSystemService();
				logger.error(sql);
				service.findMapResultBySql(sql.toString(), null);
				if (type.equals("2")) {
					try {
						PolicyNotifySupport.outTciket(orderinfo);
					} catch (Exception e) {
						logger.error("8000yi通知自动出票出错：", e.fillInStackTrace());
					}

				}

				PrintWriter out = response.getWriter();
				out.print("true");// 接受到通知返回true

			} catch (Exception e) {
				logger.error("哎呀。八千亿通知出错了：", e.fillInStackTrace());
			}
		}

	}

}
