package com.yf.system.base.servicecenter;

import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.train.Train;
import com.yf.system.base.triporder.Triporder;



public class ServicecenterComponent   implements IServicecenterComponent{
	
	
	private IServicecenterManager servicecenterManager;

	/**
	 * 取数字随机码
	 * @return
	 */
	public String getRandString(int len){
		
		return servicecenterManager.getRandString(len);
		
		
	}
	
	/**
	 * 数字转成字符串
	 * @param num
	 * @param len
	 * @return
	 */
	public String getNumString(long num,int len){
		return servicecenterManager.getNumString(num, len);
	}

	
	/**
	 * 取得汉字拼音
	 */
	public  String getPYString(String str) {
		return servicecenterManager.getPYString(str);

	}
	
	/**
	 * 取得机票订单编号
	 */
	public String getOrderinfoCode(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		return servicecenterManager.getOrderinfoCode(orderinfo);
	}

	
	public IServicecenterManager getServicecenterManager() {
		return servicecenterManager;
	}

	public void setServicecenterManager(IServicecenterManager servicecenterManager) {
		this.servicecenterManager = servicecenterManager;
	}

	/**
	 * 取得国际订单编号
	 */
	public String getInterTicketCode(Forderinfo forderinfo) {
		// TODO Auto-generated method stub
		return servicecenterManager.getInterTicketCode(forderinfo);
	}
	
	/**
	 * 酒店订单代码 
	 * @param hotelorder
	 * @return
	 */
	public String getHotelorderCode(Hotelorder hotelorder){
		return servicecenterManager.getHotelorderCode(hotelorder);
	}
	
	/**
	 * 取得旅游订单编号
	 */
	public  String getTriporderCode(Triporder orderinfo)
	{
		return servicecenterManager.getTriporderCode(orderinfo);
	}

	
	/**
	 * 租车订单代码 
	 * @param carorder
	 * @return
	 */
	public String getCarorderCode(Carorder carorder){
		return servicecenterManager.getCarorderCode(carorder);
	}

	@Override
	public String getRechargeCode(Recharge recharge) {
		
		return servicecenterManager.getRechargeCode(recharge);
	}

	@Override
	public String getQRcechrgeCode(Recharge recharge) {
		return servicecenterManager.getRechargeCode(recharge);
	}

	@Override
	public String getQmoneyRechargeCode(Qmoneyrecharge qrecharge) {
		return servicecenterManager.getQmoneyRechargeCode(qrecharge);
	}

	@Override
	public String getTringCode(Train train) {
	
	  return servicecenterManager.getTrainCode(train);
	}
	
	
	
}
