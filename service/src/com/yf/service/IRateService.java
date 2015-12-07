package com.yf.service;



import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.yf.system.base.changpass.Changpass;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinfo.TicketOrder;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.zrate.Zrate;

public interface IRateService {
	
	/**
	 * 申请退费票
	 * @param order
	 * @return
	 */
	
	public String ChangeOrder(Orderinfo order);
	
	
	
	/**
	 * 创建异地订单
	 * @param order
	 * @return
	 */
	public String CreateOrder(Orderinfo order,Segmentinfo sinfo,List<Passenger> listPassenger);
	
	/**
	 * 创建B2C异地订单
	 */
	public Orderinfo CreateB2COrder(Orderinfo order,Segmentinfo sinfo,List<Passenger> list);
	
	/**
	 * 异地自动支付
	 * @param order
	 * @return
	 */
	public String AutoPay(Orderinfo order);
	
	
	/**
	 * 	
	 * 收银台模式
	 * @param order
	 * @return
	 */
	public String OrderPay(Orderinfo order);
	
	/**
	 * 查找今日政策
	 * @return
	 */
	public List<Zrate> FindRate(String scity,String ecity,String sdate,int voyageType);

	
	public Zrate FindRateOne(String rateno);

	
	
	/**
	 * @param orderid
	 * @param outid
	 * @param fromcity
	 * @param tocity
	 * @param aircode
	 * @return
	 */
	public Zrate getEightnewZrate(long orderid,String outid,String fromcity,String tocity,String aircode);

	/**
	 * @param order
	 * @param sinfo
	 * @param Passenger
	
	 * @return Zrate
	 * 下单时候匹配最优政策
	 */
	public Zrate FindZrateByFlight(Orderinfo order, Segmentinfo sinfo,List<Passenger> listPassenger) ;
		
	
	public Zrate FindZrateByIdTo51Book(String zrateid) ;
	
	public Zrate FindOneZrateTo51Book(String zrateoutid);
	public String FindOutOrderInfoByOrderNo(String orderno,String angid);
	
	public List SeachFlight(String scity,String ecity,String compname,String depdate,String type);
	
	public List SeachFiveoneFlight(String scity,String ecity,String compname,String depdate,String type);
	
	public String TuiFeiOrder(Orderinfo orderinfo,List<Passenger> listPassenger,String WhyId);
	public String TuiFeiOrderTest(String agentCode,String securityCode,String orderSequenceNo,String ActionType,String returl);

	
	public String createPNRByGDSBook(List<Segmentinfo> Lisysegmentinfo,List<Passenger>listpass,Orderinfo orderinfo);

	public String canceorder(Orderinfo orderinfo);
	public TicketOrder CreateOrderByPnrtxtANDPattxt(Orderinfo order,Segmentinfo sinfo,List<Passenger> listPassenger);
	
	
	public List<Zrate> FindListZrateByPNR(Orderinfo order,Segmentinfo segmentinfo,List<Passenger>listpass) throws ParseException, SQLException  ;
	
	
	public String  JTsearch(String FlightNumber,String stime);
	public String ChangOrderPass(Orderinfo orderinfo,Changpass changpass);
	
	//行程单用
	public String  GetInfoByVotes(String office,String ticketno);
	public String  Create_XingChengDan_New(String office,String ticketno,String xcdno);
	
	public List<Zrate> GetJinRiRateList(Segmentinfo segmentinfo,String stime,String zratetype);
}
