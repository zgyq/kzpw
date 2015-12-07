/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeraircard;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICustomeraircardComponent{ 
	
  
 	/**
	 * 创建 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public Customeraircard createCustomeraircard(Customeraircard customeraircard) throws SQLException;
	
	/**
	 * 删除 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeraircard(long id);
	
	
	/**
	 * 修改 里程卡
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeraircard(Customeraircard customeraircard);

		
	/**
	 * 修改 里程卡但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeraircardIgnoreNull(Customeraircard customeraircard);
		
	
	/**
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 里程卡
	 * @param id
	 * @return
	 */
	public Customeraircard findCustomeraircard(long id);
	
	
	/** 
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找里程卡
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 里程卡
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeraircardBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeraircardBySql(String sql);
	
}

