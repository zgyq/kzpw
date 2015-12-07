/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customerintegralrecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICustomerintegralrecordManager{ 
	
  
 	/**
	 * 创建 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public Customerintegralrecord createCustomerintegralrecord(Customerintegralrecord customerintegralrecord) throws SQLException;
	
	/**
	 * 删除 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerintegralrecord(long id);
	
	
	/**
	 * 修改 会员积分记录
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerintegralrecord(Customerintegralrecord customerintegralrecord);

		
	/**
	 * 修改 会员积分记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerintegralrecordIgnoreNull(Customerintegralrecord customerintegralrecord);
		
	
	/**
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员积分记录
	 * @param id
	 * @return
	 */
	public Customerintegralrecord findCustomerintegralrecord(long id);
	
	
	/** 
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员积分记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员积分记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerintegralrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerintegralrecordBySql(String sql);
	
}

