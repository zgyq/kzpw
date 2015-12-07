/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.perworkload;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PerworkloadComponent   implements IPerworkloadComponent{ 
	
	
	private IPerworkloadManager perworkloadManager;
   
   
 	public IPerworkloadManager getPerworkloadManager() {
		return perworkloadManager;
	}

	public void setPerworkloadManager(IPerworkloadManager perworkloadManager) {
		this.perworkloadManager = perworkloadManager;
	}
  
 	/**
	 * 创建 人均工作量统计
	 * @param id
	 * @return deleted count 
	 */
	public Perworkload createPerworkload(Perworkload perworkload) throws SQLException{
	
		return perworkloadManager.createPerworkload(perworkload);
	}
	/**
	 * 删除 人均工作量统计
	 * @param id
	 * @return deleted count 
	 */
	public int deletePerworkload(long id){
	
		return perworkloadManager.deletePerworkload(id);
	}
	
	
	/**
	 * 修改 人均工作量统计
	 * @param id
	 * @return updated count 
	 */
	public int updatePerworkload(Perworkload perworkload){
		return perworkloadManager.updatePerworkload(perworkload);
	
	}

		
	/**
	 * 修改 人均工作量统计但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePerworkloadIgnoreNull(Perworkload perworkload){
			return perworkloadManager.updatePerworkloadIgnoreNull(perworkload);
	
	}
	
	/**
	 * 查找 人均工作量统计
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPerworkload(String where, String orderby,int limit,int offset){
		return perworkloadManager.findAllPerworkload(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 人均工作量统计
	 * @param id
	 * @return
	 */
	public Perworkload findPerworkload(long id){
		return perworkloadManager.findPerworkload(id);
	}
	
	/** 
	 * 查找 人均工作量统计
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPerworkload(String where, String orderby,PageInfo pageinfo){
		return perworkloadManager.findAllPerworkload(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找人均工作量统计
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPerworkload(String sql,int limit,int offset){
		return perworkloadManager.findAllPerworkload(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 人均工作量统计
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePerworkloadBySql(String sql){
		return perworkloadManager.excutePerworkloadBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPerworkloadBySql(String sql){
		return perworkloadManager.countPerworkloadBySql(sql);
	}
}

