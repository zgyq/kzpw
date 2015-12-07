/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.chaininfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ChaininfoComponent   implements IChaininfoComponent{ 
	
	
	private IChaininfoManager chaininfoManager;
   
   
 	public IChaininfoManager getChaininfoManager() {
		return chaininfoManager;
	}

	public void setChaininfoManager(IChaininfoManager chaininfoManager) {
		this.chaininfoManager = chaininfoManager;
	}
  
 	/**
	 * 创建 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public Chaininfo createChaininfo(Chaininfo chaininfo) throws SQLException{
	
		return chaininfoManager.createChaininfo(chaininfo);
	}
	/**
	 * 删除 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChaininfo(long id){
	
		return chaininfoManager.deleteChaininfo(id);
	}
	
	
	/**
	 * 修改 连锁酒店类型
	 * @param id
	 * @return updated count 
	 */
	public int updateChaininfo(Chaininfo chaininfo){
		return chaininfoManager.updateChaininfo(chaininfo);
	
	}

		
	/**
	 * 修改 连锁酒店类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChaininfoIgnoreNull(Chaininfo chaininfo){
			return chaininfoManager.updateChaininfoIgnoreNull(chaininfo);
	
	}
	
	/**
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,int limit,int offset){
		return chaininfoManager.findAllChaininfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param id
	 * @return
	 */
	public Chaininfo findChaininfo(long id){
		return chaininfoManager.findChaininfo(id);
	}
	
	/** 
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,PageInfo pageinfo){
		return chaininfoManager.findAllChaininfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找连锁酒店类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String sql,int limit,int offset){
		return chaininfoManager.findAllChaininfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 连锁酒店类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChaininfoBySql(String sql){
		return chaininfoManager.excuteChaininfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChaininfoBySql(String sql){
		return chaininfoManager.countChaininfoBySql(sql);
	}
}

