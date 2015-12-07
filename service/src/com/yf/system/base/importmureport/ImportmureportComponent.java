/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.importmureport;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ImportmureportComponent   implements IImportmureportComponent{ 
	
	
	private IImportmureportManager importmureportManager;
   
   
 	public IImportmureportManager getImportmureportManager() {
		return importmureportManager;
	}

	public void setImportmureportManager(IImportmureportManager importmureportManager) {
		this.importmureportManager = importmureportManager;
	}
  
 	/**
	 * 创建 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public Importmureport createImportmureport(Importmureport importmureport) throws SQLException{
	
		return importmureportManager.createImportmureport(importmureport);
	}
	/**
	 * 删除 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteImportmureport(long id){
	
		return importmureportManager.deleteImportmureport(id);
	}
	
	
	/**
	 * 修改 东航销售明细导入
	 * @param id
	 * @return updated count 
	 */
	public int updateImportmureport(Importmureport importmureport){
		return importmureportManager.updateImportmureport(importmureport);
	
	}

		
	/**
	 * 修改 东航销售明细导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateImportmureportIgnoreNull(Importmureport importmureport){
			return importmureportManager.updateImportmureportIgnoreNull(importmureport);
	
	}
	
	/**
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,int limit,int offset){
		return importmureportManager.findAllImportmureport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 东航销售明细导入
	 * @param id
	 * @return
	 */
	public Importmureport findImportmureport(long id){
		return importmureportManager.findImportmureport(id);
	}
	
	/** 
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,PageInfo pageinfo){
		return importmureportManager.findAllImportmureport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找东航销售明细导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String sql,int limit,int offset){
		return importmureportManager.findAllImportmureport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 东航销售明细导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteImportmureportBySql(String sql){
		return importmureportManager.excuteImportmureportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countImportmureportBySql(String sql){
		return importmureportManager.countImportmureportBySql(sql);
	}
}

