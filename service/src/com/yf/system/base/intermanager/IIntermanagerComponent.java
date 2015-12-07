/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.intermanager;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IIntermanagerComponent{ 
	
	/**分页存储过程
	 * @param tableName
	 * @param fldName
	 * @param fldSort
	 * @param sort
	 * @param where
	 * @param fldID
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultPageByProcedure(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo );
 	/**
	 * 创建 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public Intermanager createIntermanager(Intermanager intermanager) throws SQLException;
	
	/**
	 * 删除 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntermanager(long id);
	
	
	/**
	 * 修改 接口管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntermanager(Intermanager intermanager);

		
	/**
	 * 修改 接口管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntermanagerIgnoreNull(Intermanager intermanager);
		
	
	/**
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 接口管理
	 * @param id
	 * @return
	 */
	public Intermanager findIntermanager(long id);
	
	
	/** 
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找接口管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 接口管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntermanagerBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntermanagerBySql(String sql);
	
	/**
	 * 执行sql返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultBySql(String sql,PageInfo pageinfo);
	
	public List findMapResultSortBySql(String sql,String orderby,PageInfo pageinfo);
	
	/**
	 * 执行存贮过程返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultByProcedure(String procedure);
	
	
	
	public <T> T getTObject(Class<T> cls,long id, String... clos);
	
	
}

