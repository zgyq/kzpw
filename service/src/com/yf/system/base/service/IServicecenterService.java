package com.yf.system.base.service;

import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.train.Train;
import com.yf.system.base.triporder.Triporder;



public interface IServicecenterService {
	
	
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
	 * 获取充值订单号
	 * @param recharge
	 * @return
	 */
	public String getRechargeCode(Recharge recharge);
	/**
	 * 获取充值订单号
	 * @param recharge
	 * @return
	 */
	public String getQmoneyRechargeCode(Qmoneyrecharge qrecharge);

	/**
	 * 取得机票订单编号
	 */
	public  String getOrderinfoCode(Orderinfo orderinfo) ;
	/**
	 * 取得国际机票订单编号
	 */
	public  String getinterTicketCode(Forderinfo forderinfo) ;
	
	/**
	 * 取得旅游订单编号
	 */
	public  String getTripOrderCode(Triporder orderinfo) ;
	
	/**
	 * 取得租车订单编号
	 */
	public  String getCarOrderCode(Carorder carorder) ;
	
	
	public String getTrainCode(Train train);

}
