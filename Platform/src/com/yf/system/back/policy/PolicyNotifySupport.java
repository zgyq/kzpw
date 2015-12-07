package com.yf.system.back.policy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.action.B2borderinfoAction;
import com.yf.system.back.server.Server;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;

public   class PolicyNotifySupport  {

	/**
	 * 出票
	 * 
	 * @param outid
	 *            外部订单ID
	 * @throws Exception 
	 */
	public static void outTciket(Orderinfo orderinfo) throws Exception {
	
			
			if (orderinfo.getOrderstatus() < 3) {
				String sql="UPDATE T_ORDERINFO SET C_ORDERSTATUS=3,C_PRINTTIME='"+new Timestamp(System.currentTimeMillis())+"' WHERE ID="+orderinfo.getId();
				Server.getInstance().getSystemService().findMapResultBySql(sql, null);
				List<Passenger> listpassenger = Server.getInstance()
						.getAirService().findAllPassenger(
								"WHERE C_ORDERID=" + orderinfo.getId()
										+ " and " + Passenger.COL_state
										+ "<>12", "ORDER BY ID", -1, 0);
				List<Segmentinfo> listsegmentinfo = Server.getInstance()
						.getAirService().findAllSegmentinfo(
								"WHERE C_ORDERID=" + orderinfo.getId(), "", -1,
								0);
				//出票成功 返佣
				new B2borderinfoAction().sharingRebate(orderinfo, listpassenger
						.size());
				log(orderinfo.getId(),3,"供应出票成功，系统自动出票。");
				//发送联系人短信
				new B2borderinfoAction().sendTXTSmstoLinkuser(
						new String[] { orderinfo.getContactmobile() },
						listpassenger, listsegmentinfo);
				
				
			}
	
		
	}
	
	public static void log(long orderid,Integer state,String memo) throws SQLException{
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setOrderinfoid(orderid);
		orderinforc.setCustomeruserid(null);
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent(memo);
		orderinforc.setState(state);
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
	}
}
