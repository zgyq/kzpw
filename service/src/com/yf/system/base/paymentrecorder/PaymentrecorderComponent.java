/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.paymentrecorder;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PaymentrecorderComponent   implements IPaymentrecorderComponent{ 
	
	
	private IPaymentrecorderManager paymentrecorderManager;
   
   
 	public IPaymentrecorderManager getPaymentrecorderManager() {
		return paymentrecorderManager;
	}

	public void setPaymentrecorderManager(IPaymentrecorderManager paymentrecorderManager) {
		this.paymentrecorderManager = paymentrecorderManager;
	}
  
 	/**
	 * 创建 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public Paymentrecorder createPaymentrecorder(Paymentrecorder paymentrecorder) throws SQLException{
	
		return paymentrecorderManager.createPaymentrecorder(paymentrecorder);
	}
	/**
	 * 删除 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePaymentrecorder(long id){
	
		return paymentrecorderManager.deletePaymentrecorder(id);
	}
	
	
	/**
	 * 修改 支付记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePaymentrecorder(Paymentrecorder paymentrecorder){
		return paymentrecorderManager.updatePaymentrecorder(paymentrecorder);
	
	}

		
	/**
	 * 修改 支付记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePaymentrecorderIgnoreNull(Paymentrecorder paymentrecorder){
			return paymentrecorderManager.updatePaymentrecorderIgnoreNull(paymentrecorder);
	
	}
	
	/**
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,int limit,int offset){
		return paymentrecorderManager.findAllPaymentrecorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 支付记录
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorder(long id){
		return paymentrecorderManager.findPaymentrecorder(id);
	}
	/**
	 * 查找 支付记录 by language
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorderbylanguage(long id,Integer language){
		return paymentrecorderManager.findPaymentrecorderbylanguage(id,language);
	}
	/** 
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,PageInfo pageinfo){
		return paymentrecorderManager.findAllPaymentrecorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找支付记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String sql,int limit,int offset){
		return paymentrecorderManager.findAllPaymentrecorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 支付记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePaymentrecorderBySql(String sql){
		return paymentrecorderManager.excutePaymentrecorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPaymentrecorderBySql(String sql){
		return paymentrecorderManager.countPaymentrecorderBySql(sql);
	}
}

