/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.redeem;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRedeemManager{ 
	
  
 	/**
	 * 创建 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public Redeem createRedeem(Redeem redeem) throws SQLException;
	
	/**
	 * 删除 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRedeem(long id);
	
	
	/**
	 * 修改 积分兑换
	 * @param id
	 * @return updated count 
	 */
	public int updateRedeem(Redeem redeem);

		
	/**
	 * 修改 积分兑换但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRedeemIgnoreNull(Redeem redeem);
		
	
	/**
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeem(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分兑换
	 * @param id
	 * @return
	 */
	public Redeem findRedeem(long id);
	
	
	/** 
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRedeem(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分兑换
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeem(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分兑换
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRedeemBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRedeemBySql(String sql);
	
}

