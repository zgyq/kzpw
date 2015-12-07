/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.paymentrecorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPaymentrecorderManager{ 
	
  
 	/**
	 * 创建 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public Paymentrecorder createPaymentrecorder(Paymentrecorder paymentrecorder) throws SQLException;
	
	/**
	 * 删除 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePaymentrecorder(long id);
	
	
	/**
	 * 修改 支付记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePaymentrecorder(Paymentrecorder paymentrecorder);

		
	/**
	 * 修改 支付记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePaymentrecorderIgnoreNull(Paymentrecorder paymentrecorder);
		
	
	/**
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 支付记录
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorder(long id);
	
	/**
	 * 查找 支付记录 by language
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorderbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找支付记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 支付记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePaymentrecorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPaymentrecorderBySql(String sql);
	
}

