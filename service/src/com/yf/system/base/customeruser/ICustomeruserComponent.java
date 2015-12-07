/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeruser;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICustomeruserComponent{ 
	
  
 	/**
	 * 创建 会员
	 * @param id
	 * @return deleted count 
	 */
	public Customeruser createCustomeruser(Customeruser customeruser) throws SQLException;
	
	/**
	 * 删除 会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeruser(long id);
	
	
	/**
	 * 修改 会员
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeruser(Customeruser customeruser);

		
	/**
	 * 修改 会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeruserIgnoreNull(Customeruser customeruser);
		
	
	/**
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员
	 * @param id
	 * @return
	 */
	public Customeruser findCustomeruser(long id);
	
	
	/** 
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeruserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeruserBySql(String sql);
	
}

