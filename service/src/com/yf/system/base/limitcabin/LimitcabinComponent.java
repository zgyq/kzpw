
 
package com.yf.system.base.limitcabin;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class LimitcabinComponent   implements ILimitcabinComponent{ 
	
	
	private ILimitcabinManager limitcabinManager;
   
   
 	public ILimitcabinManager getLimitcabinManager() {
		return limitcabinManager;
	}

	public void setLimitcabinManager(ILimitcabinManager limitcabinManager) {
		this.limitcabinManager = limitcabinManager;
	}
  
 	/**
	 * 创建 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public Limitcabin createLimitcabin(Limitcabin limitcabin) throws SQLException{
	
		return limitcabinManager.createLimitcabin(limitcabin);
	}
	/**
	 * 删除 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLimitcabin(long id){
	
		return limitcabinManager.deleteLimitcabin(id);
	}
	
	
	/**
	 * 修改 限制仓位
	 * @param id
	 * @return updated count 
	 */
	public int updateLimitcabin(Limitcabin limitcabin){
		return limitcabinManager.updateLimitcabin(limitcabin);
	
	}

		
	/**
	 * 修改 限制仓位但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLimitcabinIgnoreNull(Limitcabin limitcabin){
			return limitcabinManager.updateLimitcabinIgnoreNull(limitcabin);
	
	}
	
	/**
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,int limit,int offset){
		return limitcabinManager.findAllLimitcabin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 限制仓位
	 * @param id
	 * @return
	 */
	public Limitcabin findLimitcabin(long id){
		return limitcabinManager.findLimitcabin(id);
	}
	
	/** 
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,PageInfo pageinfo){
		return limitcabinManager.findAllLimitcabin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找限制仓位
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String sql,int limit,int offset){
		return limitcabinManager.findAllLimitcabin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 限制仓位
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLimitcabinBySql(String sql){
		return limitcabinManager.excuteLimitcabinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLimitcabinBySql(String sql){
		return limitcabinManager.countLimitcabinBySql(sql);
	}
}

