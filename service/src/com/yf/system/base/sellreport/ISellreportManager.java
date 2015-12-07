/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sellreport;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISellreportManager{ 
	
  
 	/**
	 * 创建 销售报表
	 * @param id
	 * @return deleted count 
	 */
	public Sellreport createSellreport(Sellreport sellreport) throws SQLException;
	
	/**
	 * 删除 销售报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSellreport(long id);
	
	
	/**
	 * 修改 销售报表
	 * @param id
	 * @return updated count 
	 */
	public int updateSellreport(Sellreport sellreport);

		
	/**
	 * 修改 销售报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSellreportIgnoreNull(Sellreport sellreport);
		
	
	/**
	 * 查找 销售报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSellreport(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 销售报表
	 * @param id
	 * @return
	 */
	public Sellreport findSellreport(long id);
	
	
	/** 
	 * 查找 销售报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSellreport(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找销售报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSellreport(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 销售报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSellreportBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSellreportBySql(String sql);
	
}

