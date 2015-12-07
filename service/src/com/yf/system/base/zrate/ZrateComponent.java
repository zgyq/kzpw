/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.zrate;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ZrateComponent   implements IZrateComponent{ 
	
	
	private IZrateManager zrateManager;
   
   
 	public IZrateManager getZrateManager() {
		return zrateManager;
	}

	public void setZrateManager(IZrateManager zrateManager) {
		this.zrateManager = zrateManager;
	}
  
 	/**
	 * 创建 普通政策表
	 * @param id
	 * @return deleted count 
	 */
	public Zrate createZrate(Zrate zrate) throws SQLException{
	
		return zrateManager.createZrate(zrate);
	}
	/**
	 * 删除 普通政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteZrate(long id){
	
		return zrateManager.deleteZrate(id);
	}
	
	
	/**
	 * 修改 普通政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateZrate(Zrate zrate){
		return zrateManager.updateZrate(zrate);
	
	}

		
	/**
	 * 修改 普通政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateZrateIgnoreNull(Zrate zrate){
			return zrateManager.updateZrateIgnoreNull(zrate);
	
	}
	
	/**
	 * 查找 普通政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZrate(String where, String orderby,int limit,int offset){
		return zrateManager.findAllZrate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 普通政策表
	 * @param id
	 * @return
	 */
	public Zrate findZrate(long id){
		return zrateManager.findZrate(id);
	}
	/**
	 * 查找 普通政策表
	 * @param id
	 * @return
	 */
	public Zrate findZrateByDB(long id){
		return zrateManager.findZrateByDB(id);
	}
	
	/** 
	 * 查找 普通政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllZrate(String where, String orderby,PageInfo pageinfo){
		return zrateManager.findAllZrate(where, orderby,pageinfo);
	}
	
	
	public List findAllZrateBySP(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo )
	{
		return zrateManager.findAllZrateBySP(tableName, fldName, fldSort, sort, where, fldID, pageinfo);
	}
		
	/** 
	 * 根据Sql查找普通政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZrate(String sql,int limit,int offset){
		return zrateManager.findAllZrate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 普通政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteZrateBySql(String sql){
		return zrateManager.excuteZrateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countZrateBySql(String sql){
		return zrateManager.countZrateBySql(sql);
	}
}

