/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.withbank;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IWithbankComponent{ 
	
  
 	/**
	 * 创建 提现
	 * @param id
	 * @return deleted count 
	 */
	public Withbank createWithbank(Withbank withbank) throws SQLException;
	
	/**
	 * 删除 提现
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWithbank(long id);
	
	
	/**
	 * 修改 提现
	 * @param id
	 * @return updated count 
	 */
	public int updateWithbank(Withbank withbank);

		
	/**
	 * 修改 提现但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWithbankIgnoreNull(Withbank withbank);
		
	
	/**
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 提现
	 * @param id
	 * @return
	 */
	public Withbank findWithbank(long id);
	
	
	/** 
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找提现
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 提现
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWithbankBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWithbankBySql(String sql);
	
}

