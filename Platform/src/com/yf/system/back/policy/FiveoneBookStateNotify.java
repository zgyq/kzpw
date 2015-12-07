package com.yf.system.back.policy;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.yf.system.back.server.Server;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.service.ISystemService;

/**
 * @author Administrator 51book 订单状态通知接口
 * 
 */
public class FiveoneBookStateNotify extends HttpServlet{
	Log logger = LogFactory.getLog(EightyiNotify.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.error("51Book出票通知请求："+request.getQueryString());
		try {
			String str=new String(request.getQueryString().getBytes("ISO-8859-1"),"UTF-8");
			logger.error(str);
		} catch (UnsupportedEncodingException e1) {
		}
		String typestr = request.getParameter("type");
		if (typestr != null) {
			try {
				ISystemService service = Server.getInstance()
						.getSystemService();
				int type = Integer.valueOf(typestr);
				String pname="sequenceNo";
				if(type==2){
					pname="orderNo";
				}
				String sequenceNo = request.getParameter(pname);// 订单好
				
				String where = "WHERE C_EXTORDERID='" + sequenceNo + "'";
				Orderinfo orderinfo = (Orderinfo) Server.getInstance()
						.getAirService().findAllOrderinfo(where, "", -1, 0).get(0);
				if (type == 1) {// 供应商确定出票
					String newpnr = request.getParameter("pnrNo");
					String oldpnr = request.getParameter("oldPnrNo");
					if (newpnr == null || oldpnr == null || oldpnr.equals("")) {
						newpnr = "";
					}
					String passengerstrs = new String(request.getParameter(
							"passengerNames").getBytes("ISO-8859-1"), "UTF-8");// 乘机人
																				// 多人以”，“号分隔
					String ticketnosstrs = request.getParameter("ticketNos");
					String passengers[] = passengerstrs.split(",");
					String ticketnos[] = ticketnosstrs.split(",");

					// writeLog.write("51book出票通知",
					// "type:"+typestr+",sequenceNo:"+sequenceNo+",ticketnosstrs:"+ticketnosstrs+",passengerstrs:"+passengerstrs);
					logger.error("type:" + typestr + ",sequenceNo:"
							+ sequenceNo + ",ticketnosstrs:" + ticketnosstrs
							+ ",passengerstrs:" + passengerstrs);

					StringBuilder sql = new StringBuilder(
							"UPDATE T_ORDERINFO SET C_EXTORDERSTATUS=3,C_NEWPNR='"
									+ newpnr + "' WHERE C_EXTORDERID='"
									+ sequenceNo + "';");
					for (int i = 0; i < passengers.length; i++) {
						String name = passengers[i];
						String ticketno = ticketnos[i];
						sql
								.append("UPDATE T_PASSENGER SET C_TICKETNUM='"
										+ ticketno
										+ "' WHERE C_NAME='"
										+ name
										+ "' AND C_ORDERID=(SELECT TOP 1  ID FROM T_ORDERINFO WHERE C_EXTORDERID='"
										+ sequenceNo + "');");
					}
					service.findMapResultBySql(sql.toString(), null);
					try {
						PolicyNotifySupport.outTciket(orderinfo);
					} catch (Exception e) {
						logger.error("51book 通知自动出票出错：", e.fillInStackTrace());
					}

				}

				if (type == 2) {// 供应商拒单
					logger.error("供应商拒单");
					String sql = "UPDATE T_ORDERINFO SET C_EXTORDERSTATUS=28 WHERE C_EXTORDERID='"
							+ sequenceNo + "'";
					service.findMapResultBySql(sql.toString(), null);
				//	refundNo----退款号 orderNo----关联的订单号 refundTime---退款时	refundPrice—退款时间
					String refundNo=request.getParameter("refundNo");
					String refundTime=request.getParameter("refundTime");
					String refundPrice=request.getParameter("refundPrice");
					PolicyNotifySupport.log(orderinfo.getId(), null, "供应拒单，取消出票。交易号："+refundNo+",退款时间："+refundTime+",退款金额："+refundPrice);
				}
			} catch (Exception e2) {
				logger.error("51book 通知出错：", e2.fillInStackTrace());
			}
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("S");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	

}
