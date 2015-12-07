/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzchanpin;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IQzchanpinComponent{ 
	
  
 	/**
	 * 创建 签证产品
	 * @param id
	 * @return deleted count 
	 */
	public Qzchanpin createQzchanpin(Qzchanpin qzchanpin) throws SQLException;
	
	/**
	 * 删除 签证产品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzchanpin(long id);
	
	
	/**
	 * 修改 签证产品
	 * @param id
	 * @return updated count 
	 */
	public int updateQzchanpin(Qzchanpin qzchanpin);

		
	/**
	 * 修改 签证产品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzchanpinIgnoreNull(Qzchanpin qzchanpin);
		
	
	/**
	 * 查找 签证产品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpin(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 签证产品
	 * @param id
	 * @return
	 */
	public Qzchanpin findQzchanpin(long id);
	
	
	/** 
	 * 查找 签证产品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzchanpin(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找签证产品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpin(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 签证产品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzchanpinBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzchanpinBySql(String sql);
	
}

