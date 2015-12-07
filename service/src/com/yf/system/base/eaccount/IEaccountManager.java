/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.eaccount;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IEaccountManager{ 
	
  
 	/**
	 * 创建 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public Eaccount createEaccount(Eaccount eaccount) throws SQLException;
	
	/**
	 * 删除 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEaccount(long id);
	
	
	/**
	 * 修改 外部账号
	 * @param id
	 * @return updated count 
	 */
	public int updateEaccount(Eaccount eaccount);

		
	/**
	 * 修改 外部账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEaccountIgnoreNull(Eaccount eaccount);
		
	
	/**
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 外部账号
	 * @param id
	 * @return
	 */
	public Eaccount findEaccount(long id);
	
	
	/** 
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找外部账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 外部账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEaccountBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEaccountBySql(String sql);
	
}

