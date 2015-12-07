/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customerpassenger;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICustomerpassengerManager{ 
	
  
 	/**
	 * 创建 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public Customerpassenger createCustomerpassenger(Customerpassenger customerpassenger) throws SQLException;
	
	/**
	 * 删除 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerpassenger(long id);
	
	
	/**
	 * 修改 常用旅客
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerpassenger(Customerpassenger customerpassenger);

		
	/**
	 * 修改 常用旅客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerpassengerIgnoreNull(Customerpassenger customerpassenger);
		
	
	/**
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassenger(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 常用旅客
	 * @param id
	 * @return
	 */
	public Customerpassenger findCustomerpassenger(long id);
	
	
	/** 
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerpassenger(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找常用旅客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassenger(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 常用旅客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerpassengerBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerpassengerBySql(String sql);
	
}

