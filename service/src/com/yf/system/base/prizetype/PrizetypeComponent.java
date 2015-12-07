/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.prizetype;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PrizetypeComponent   implements IPrizetypeComponent{ 
	
	
	private IPrizetypeManager prizetypeManager;
   
   
 	public IPrizetypeManager getPrizetypeManager() {
		return prizetypeManager;
	}

	public void setPrizetypeManager(IPrizetypeManager prizetypeManager) {
		this.prizetypeManager = prizetypeManager;
	}
  
 	/**
	 * 创建 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public Prizetype createPrizetype(Prizetype prizetype) throws SQLException{
	
		return prizetypeManager.createPrizetype(prizetype);
	}
	/**
	 * 删除 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizetype(long id){
	
		return prizetypeManager.deletePrizetype(id);
	}
	
	
	/**
	 * 修改 积分礼品类型
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizetype(Prizetype prizetype){
		return prizetypeManager.updatePrizetype(prizetype);
	
	}

		
	/**
	 * 修改 积分礼品类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizetypeIgnoreNull(Prizetype prizetype){
			return prizetypeManager.updatePrizetypeIgnoreNull(prizetype);
	
	}
	
	/**
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,int limit,int offset){
		return prizetypeManager.findAllPrizetype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分礼品类型
	 * @param id
	 * @return
	 */
	public Prizetype findPrizetype(long id){
		return prizetypeManager.findPrizetype(id);
	}
	
	/** 
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,PageInfo pageinfo){
		return prizetypeManager.findAllPrizetype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分礼品类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String sql,int limit,int offset){
		return prizetypeManager.findAllPrizetype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分礼品类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizetypeBySql(String sql){
		return prizetypeManager.excutePrizetypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizetypeBySql(String sql){
		return prizetypeManager.countPrizetypeBySql(sql);
	}
}

