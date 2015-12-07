/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starsettlementtype;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class StarsettlementtypeComponent   implements IStarsettlementtypeComponent{ 
	
	
	private IStarsettlementtypeManager starsettlementtypeManager;
   
   
 	public IStarsettlementtypeManager getStarsettlementtypeManager() {
		return starsettlementtypeManager;
	}

	public void setStarsettlementtypeManager(IStarsettlementtypeManager starsettlementtypeManager) {
		this.starsettlementtypeManager = starsettlementtypeManager;
	}
  
 	/**
	 * 创建 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public Starsettlementtype createStarsettlementtype(Starsettlementtype starsettlementtype) throws SQLException{
	
		return starsettlementtypeManager.createStarsettlementtype(starsettlementtype);
	}
	/**
	 * 删除 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarsettlementtype(long id){
	
		return starsettlementtypeManager.deleteStarsettlementtype(id);
	}
	
	
	/**
	 * 修改 星级结算分类
	 * @param id
	 * @return updated count 
	 */
	public int updateStarsettlementtype(Starsettlementtype starsettlementtype){
		return starsettlementtypeManager.updateStarsettlementtype(starsettlementtype);
	
	}

		
	/**
	 * 修改 星级结算分类但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarsettlementtypeIgnoreNull(Starsettlementtype starsettlementtype){
			return starsettlementtypeManager.updateStarsettlementtypeIgnoreNull(starsettlementtype);
	
	}
	
	/**
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,int limit,int offset){
		return starsettlementtypeManager.findAllStarsettlementtype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 星级结算分类
	 * @param id
	 * @return
	 */
	public Starsettlementtype findStarsettlementtype(long id){
		return starsettlementtypeManager.findStarsettlementtype(id);
	}
	
	/** 
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,PageInfo pageinfo){
		return starsettlementtypeManager.findAllStarsettlementtype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找星级结算分类
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String sql,int limit,int offset){
		return starsettlementtypeManager.findAllStarsettlementtype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 星级结算分类
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarsettlementtypeBySql(String sql){
		return starsettlementtypeManager.excuteStarsettlementtypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarsettlementtypeBySql(String sql){
		return starsettlementtypeManager.countStarsettlementtypeBySql(sql);
	}
}

