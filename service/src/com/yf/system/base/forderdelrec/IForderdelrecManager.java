/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.forderdelrec;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IForderdelrecManager{ 
	
  
 	/**
	 * 创建 国际机票订单操作记录
	 * @param id
	 * @return deleted count 
	 */
	public Forderdelrec createForderdelrec(Forderdelrec forderdelrec) throws SQLException;
	
	/**
	 * 删除 国际机票订单操作记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderdelrec(long id);
	
	
	/**
	 * 修改 国际机票订单操作记录
	 * @param id
	 * @return updated count 
	 */
	public int updateForderdelrec(Forderdelrec forderdelrec);

		
	/**
	 * 修改 国际机票订单操作记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateForderdelrecIgnoreNull(Forderdelrec forderdelrec);
		
	
	/**
	 * 查找 国际机票订单操作记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票订单操作记录
	 * @param id
	 * @return
	 */
	public Forderdelrec findForderdelrec(long id);
	
	
	/** 
	 * 查找 国际机票订单操作记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票订单操作记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票订单操作记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderdelrecBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderdelrecBySql(String sql);
	
}

