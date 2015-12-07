/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starreinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class StarreinfoComponent   implements IStarreinfoComponent{ 
	
	
	private IStarreinfoManager starreinfoManager;
   
   
 	public IStarreinfoManager getStarreinfoManager() {
		return starreinfoManager;
	}

	public void setStarreinfoManager(IStarreinfoManager starreinfoManager) {
		this.starreinfoManager = starreinfoManager;
	}
  
 	/**
	 * 创建 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public Starreinfo createStarreinfo(Starreinfo starreinfo) throws SQLException{
	
		return starreinfoManager.createStarreinfo(starreinfo);
	}
	/**
	 * 删除 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarreinfo(long id){
	
		return starreinfoManager.deleteStarreinfo(id);
	}
	
	
	/**
	 * 修改 星级返点设置关联
	 * @param id
	 * @return updated count 
	 */
	public int updateStarreinfo(Starreinfo starreinfo){
		return starreinfoManager.updateStarreinfo(starreinfo);
	
	}

		
	/**
	 * 修改 星级返点设置关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarreinfoIgnoreNull(Starreinfo starreinfo){
			return starreinfoManager.updateStarreinfoIgnoreNull(starreinfo);
	
	}
	
	/**
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,int limit,int offset){
		return starreinfoManager.findAllStarreinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 星级返点设置关联
	 * @param id
	 * @return
	 */
	public Starreinfo findStarreinfo(long id){
		return starreinfoManager.findStarreinfo(id);
	}
	
	/** 
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,PageInfo pageinfo){
		return starreinfoManager.findAllStarreinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找星级返点设置关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String sql,int limit,int offset){
		return starreinfoManager.findAllStarreinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 星级返点设置关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarreinfoBySql(String sql){
		return starreinfoManager.excuteStarreinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarreinfoBySql(String sql){
		return starreinfoManager.countStarreinfoBySql(sql);
	}
}

