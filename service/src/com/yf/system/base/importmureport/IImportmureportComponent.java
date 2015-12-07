/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.importmureport;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IImportmureportComponent{ 
	
  
 	/**
	 * 创建 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public Importmureport createImportmureport(Importmureport importmureport) throws SQLException;
	
	/**
	 * 删除 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteImportmureport(long id);
	
	
	/**
	 * 修改 东航销售明细导入
	 * @param id
	 * @return updated count 
	 */
	public int updateImportmureport(Importmureport importmureport);

		
	/**
	 * 修改 东航销售明细导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateImportmureportIgnoreNull(Importmureport importmureport);
		
	
	/**
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 东航销售明细导入
	 * @param id
	 * @return
	 */
	public Importmureport findImportmureport(long id);
	
	
	/** 
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找东航销售明细导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 东航销售明细导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteImportmureportBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countImportmureportBySql(String sql);
	
}

