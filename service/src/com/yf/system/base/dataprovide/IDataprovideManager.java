/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dataprovide;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IDataprovideManager{ 
	
  
 	/**
	 * 创建 酒店数据提供商
	 * @param id
	 * @return deleted count 
	 */
	public Dataprovide createDataprovide(Dataprovide dataprovide) throws SQLException;
	
	/**
	 * 删除 酒店数据提供商
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDataprovide(long id);
	
	
	/**
	 * 修改 酒店数据提供商
	 * @param id
	 * @return updated count 
	 */
	public int updateDataprovide(Dataprovide dataprovide);

		
	/**
	 * 修改 酒店数据提供商但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDataprovideIgnoreNull(Dataprovide dataprovide);
		
	
	/**
	 * 查找 酒店数据提供商
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDataprovide(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店数据提供商
	 * @param id
	 * @return
	 */
	public Dataprovide findDataprovide(long id);
	
	
	/** 
	 * 查找 酒店数据提供商
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDataprovide(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店数据提供商
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDataprovide(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店数据提供商
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDataprovideBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDataprovideBySql(String sql);
	
}

