package com.yf.system.base.servicecenter;

import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.train.Train;
import com.yf.system.base.triporder.Triporder;



public interface IServicecenterManager {
	
	
	/**
	 * 获取充值订单号
	 * @param recharge
	 * @return
	 */
	public String getRechargeCode(Recharge recharge);
	
	
	/**
	 * 获取Q币充值订单号
	 * @param qrecharge
	 * @return
	 */
	public String getQmoneyRechargeCode(Qmoneyrecharge qrecharge);
	
	
	
	/**
	 * 取数字随机码
	 * @return
	 */
	public String getRandString(int len);
	
	/**
	 * 数字转成字符串
	 * @param num
	 * @param len
	 * @return
	 */
	public String getNumString(long num,int len);
	
	
	
	/**
	 * 取得汉字拼音
	 */
	public  String getPYString(String str) ;


	/**
	 * 取得机票订单编号
	 */
	public  String getOrderinfoCode(Orderinfo orderinfo) ;
	
	/**
	 * 取得国际订单编号
	 */
	public  String getInterTicketCode(Forderinfo forderinfo) ;
	
	/**
	 * 取得旅游订单编号
	 */
	public  String getTriporderCode(Triporder orderinfo) ;
	
	/**
	 * 酒店订单代码 
	 * @param hotelorder
	 * @return
	 */
	public String getHotelorderCode(com.yf.system.base.hotelorder.Hotelorder hotelorder);
	
	/**
	 * 取得租车订单编号
	 * 
	 */
	public  String getCarorderCode(Carorder carorder) ;
	
	
	/**
	 * 获得火车订单编号
	 * @param Train
	 * @return
	 */
	public  String getTrainCode(Train Train) ;

	
}
