package com.yf.system.base.service;

import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.servicecenter.IServicecenterComponent;
import com.yf.system.base.train.Train;
import com.yf.system.base.triporder.Triporder;




public class ServicecenterService   implements IServicecenterService{
	
	
	private IServicecenterComponent servicecenterComponent;
	
	
	//礼品定单流水序列
	private final String GIFTORDERSEQ = "giftcodeseq";
	
	//礼品任务单流水序列
	private final String GIFTTASKORDERSEQ="gifttaskorderseq";


	
	/**
	 * 取数字随机码
	 * @return
	 */
	public String getRandString(int len){
		
		return servicecenterComponent.getRandString(len);
		
		
	}
	
	/**
	 * 数字转成字符串
	 * @param num
	 * @param len
	 * @return
	 */
	public String getNumString(long num,int len){
		return servicecenterComponent.getNumString(num, len);
	}
	
	
	/**
	 * 取得汉字拼音
	 */
	public  String getPYString(String str) {
		return servicecenterComponent.getPYString(str);

	}
	
	
	/**
	 * 取得机票订单编号
	 */
	public String getOrderinfoCode(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		return servicecenterComponent.getOrderinfoCode(orderinfo);
	}
	public String getinterTicketCode(Forderinfo forderinfo) {
		return servicecenterComponent.getInterTicketCode(forderinfo);
	}

	public IServicecenterComponent getServicecenterComponent() {
		return servicecenterComponent;
	}

	public void setServicecenterComponent(
			IServicecenterComponent servicecenterComponent) {
		this.servicecenterComponent = servicecenterComponent;
	}

	/**
	 * 取得旅游订单编号
	 */
	public String getTripOrderCode(Triporder orderinfo) {
		// TODO Auto-generated method stub
		return servicecenterComponent.getTriporderCode(orderinfo);
	}
	

	
	
	/**
	 * 取得 租车订单编号
	 */
	public String getCarOrderCode(Carorder carorder) {
		// TODO Auto-generated method stub
		return servicecenterComponent.getCarorderCode(carorder);
	}

	@Override
	public String getRechargeCode(Recharge recharge) {
		return servicecenterComponent.getRechargeCode(recharge);
	}

	@Override
	public String getQmoneyRechargeCode(Qmoneyrecharge qrecharge) {
		return servicecenterComponent.getQmoneyRechargeCode(qrecharge);
	}

	@Override
	public String getTrainCode(Train train) {
		
		return servicecenterComponent.getTringCode(train);
	}

	
	

	
	
}
