/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.exchrecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IExchrecordComponent{ 
	
  
 	/**
	 * 创建 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public Exchrecord createExchrecord(Exchrecord exchrecord) throws SQLException;
	
	/**
	 * 删除 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteExchrecord(long id);
	
	
	/**
	 * 修改 积分兑换纪录
	 * @param id
	 * @return updated count 
	 */
	public int updateExchrecord(Exchrecord exchrecord);

		
	/**
	 * 修改 积分兑换纪录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateExchrecordIgnoreNull(Exchrecord exchrecord);
		
	
	/**
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分兑换纪录
	 * @param id
	 * @return
	 */
	public Exchrecord findExchrecord(long id);
	
	
	/** 
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllExchrecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分兑换纪录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分兑换纪录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteExchrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countExchrecordBySql(String sql);
	
}

