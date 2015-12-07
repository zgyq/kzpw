/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insurorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IInsurorderManager{ 
	
  
 	/**
	 * 创建 订单表
	 * @param id
	 * @return deleted count 
	 */
	public Insurorder createInsurorder(Insurorder insurorder) throws SQLException;
	
	/**
	 * 删除 订单表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsurorder(long id);
	
	
	/**
	 * 修改 订单表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsurorder(Insurorder insurorder);

		
	/**
	 * 修改 订单表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsurorderIgnoreNull(Insurorder insurorder);
		
	
	/**
	 * 查找 订单表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 订单表
	 * @param id
	 * @return
	 */
	public Insurorder findInsurorder(long id);
	
	
	/** 
	 * 查找 订单表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsurorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找订单表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 订单表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsurorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsurorderBySql(String sql);
	
}

