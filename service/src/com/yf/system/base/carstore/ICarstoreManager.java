/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carstore;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICarstoreManager{ 
	
  
 	/**
	 * 创建 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public Carstore createCarstore(Carstore carstore) throws SQLException;
	
	/**
	 * 删除 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarstore(long id);
	
	
	/**
	 * 修改 租车门店
	 * @param id
	 * @return updated count 
	 */
	public int updateCarstore(Carstore carstore);

		
	/**
	 * 修改 租车门店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarstoreIgnoreNull(Carstore carstore);
		
	
	/**
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 租车门店
	 * @param id
	 * @return
	 */
	public Carstore findCarstore(long id);
	
	
	/** 
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找租车门店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 租车门店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarstoreBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarstoreBySql(String sql);
	
}

