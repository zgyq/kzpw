/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.passengerrepayrc;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPassengerrepayrcComponent{ 
	
  
 	/**
	 * 创建 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public Passengerrepayrc createPassengerrepayrc(Passengerrepayrc passengerrepayrc) throws SQLException;
	
	/**
	 * 删除 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassengerrepayrc(long id);
	
	
	/**
	 * 修改 机票还款记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePassengerrepayrc(Passengerrepayrc passengerrepayrc);

		
	/**
	 * 修改 机票还款记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerrepayrcIgnoreNull(Passengerrepayrc passengerrepayrc);
		
	
	/**
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 机票还款记录
	 * @param id
	 * @return
	 */
	public Passengerrepayrc findPassengerrepayrc(long id);
	
	
	/** 
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找机票还款记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 机票还款记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerrepayrcBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerrepayrcBySql(String sql);
	
}

