/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rgroupcustomers;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRgroupcustomersComponent{ 
	
  
 	/**
	 * 创建 集团客户环比统计表
	 * @param id
	 * @return deleted count 
	 */
	public Rgroupcustomers createRgroupcustomers(Rgroupcustomers rgroupcustomers) throws SQLException;
	
	/**
	 * 删除 集团客户环比统计表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRgroupcustomers(long id);
	
	
	/**
	 * 修改 集团客户环比统计表
	 * @param id
	 * @return updated count 
	 */
	public int updateRgroupcustomers(Rgroupcustomers rgroupcustomers);

		
	/**
	 * 修改 集团客户环比统计表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRgroupcustomersIgnoreNull(Rgroupcustomers rgroupcustomers);
		
	
	/**
	 * 查找 集团客户环比统计表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRgroupcustomers(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 集团客户环比统计表
	 * @param id
	 * @return
	 */
	public Rgroupcustomers findRgroupcustomers(long id);
	
	
	/** 
	 * 查找 集团客户环比统计表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRgroupcustomers(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找集团客户环比统计表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRgroupcustomers(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 集团客户环比统计表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRgroupcustomersBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRgroupcustomersBySql(String sql);
	
}

