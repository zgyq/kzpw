/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spzrate;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpzrateComponent   implements ISpzrateComponent{ 
	
	
	private ISpzrateManager spzrateManager;
   
   
 	public ISpzrateManager getSpzrateManager() {
		return spzrateManager;
	}

	public void setSpzrateManager(ISpzrateManager spzrateManager) {
		this.spzrateManager = spzrateManager;
	}
  
 	/**
	 * 创建 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public Spzrate createSpzrate(Spzrate spzrate) throws SQLException{
	
		return spzrateManager.createSpzrate(spzrate);
	}
	/**
	 * 删除 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpzrate(long id){
	
		return spzrateManager.deleteSpzrate(id);
	}
	
	
	/**
	 * 修改 特价政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateSpzrate(Spzrate spzrate){
		return spzrateManager.updateSpzrate(spzrate);
	
	}

		
	/**
	 * 修改 特价政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpzrateIgnoreNull(Spzrate spzrate){
			return spzrateManager.updateSpzrateIgnoreNull(spzrate);
	
	}
	
	/**
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,int limit,int offset){
		return spzrateManager.findAllSpzrate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 特价政策表
	 * @param id
	 * @return
	 */
	public Spzrate findSpzrate(long id){
		return spzrateManager.findSpzrate(id);
	}
	/**
	 * 查找 特价政策表 by language
	 * @param id
	 * @return
	 */
	public Spzrate findSpzratebylanguage(long id,Integer language){
		return spzrateManager.findSpzratebylanguage(id,language);
	}
	/** 
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,PageInfo pageinfo){
		return spzrateManager.findAllSpzrate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找特价政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String sql,int limit,int offset){
		return spzrateManager.findAllSpzrate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 特价政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpzrateBySql(String sql){
		return spzrateManager.excuteSpzrateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpzrateBySql(String sql){
		return spzrateManager.countSpzrateBySql(sql);
	}
}

