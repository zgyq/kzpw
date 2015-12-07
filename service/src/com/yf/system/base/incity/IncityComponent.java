/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.incity;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class IncityComponent   implements IIncityComponent{ 
	
	
	private IIncityManager incityManager;
   
   
 	public IIncityManager getIncityManager() {
		return incityManager;
	}

	public void setIncityManager(IIncityManager incityManager) {
		this.incityManager = incityManager;
	}
  
 	/**
	 * 创建 国际城市表
	 * @param id
	 * @return deleted count 
	 */
	public Incity createIncity(Incity incity) throws SQLException{
	
		return incityManager.createIncity(incity);
	}
	/**
	 * 删除 国际城市表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIncity(long id){
	
		return incityManager.deleteIncity(id);
	}
	
	
	/**
	 * 修改 国际城市表
	 * @param id
	 * @return updated count 
	 */
	public int updateIncity(Incity incity){
		return incityManager.updateIncity(incity);
	
	}

		
	/**
	 * 修改 国际城市表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIncityIgnoreNull(Incity incity){
			return incityManager.updateIncityIgnoreNull(incity);
	
	}
	
	/**
	 * 查找 国际城市表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIncity(String where, String orderby,int limit,int offset){
		return incityManager.findAllIncity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际城市表
	 * @param id
	 * @return
	 */
	public Incity findIncity(long id){
		return incityManager.findIncity(id);
	}
	
	/** 
	 * 查找 国际城市表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIncity(String where, String orderby,PageInfo pageinfo){
		return incityManager.findAllIncity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际城市表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIncity(String sql,int limit,int offset){
		return incityManager.findAllIncity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际城市表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIncityBySql(String sql){
		return incityManager.excuteIncityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIncityBySql(String sql){
		return incityManager.countIncityBySql(sql);
	}
}

