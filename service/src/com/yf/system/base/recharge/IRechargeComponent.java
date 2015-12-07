/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.recharge;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRechargeComponent{ 
	
  
 	/**
	 * 创建 手机充值
	 * @param id
	 * @return deleted count 
	 */
	public Recharge createRecharge(Recharge recharge) throws SQLException;
	
	/**
	 * 删除 手机充值
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRecharge(long id);
	
	
	/**
	 * 修改 手机充值
	 * @param id
	 * @return updated count 
	 */
	public int updateRecharge(Recharge recharge);

		
	/**
	 * 修改 手机充值但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRechargeIgnoreNull(Recharge recharge);
		
	
	/**
	 * 查找 手机充值
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRecharge(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 手机充值
	 * @param id
	 * @return
	 */
	public Recharge findRecharge(long id);
	
	
	/** 
	 * 查找 手机充值
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRecharge(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找手机充值
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRecharge(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 手机充值
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRechargeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRechargeBySql(String sql);
	
}

