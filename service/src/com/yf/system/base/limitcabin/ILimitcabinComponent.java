
 
package com.yf.system.base.limitcabin;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ILimitcabinComponent{ 
	
  
 	/**
	 * 创建 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public Limitcabin createLimitcabin(Limitcabin limitcabin) throws SQLException;
	
	/**
	 * 删除 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLimitcabin(long id);
	
	
	/**
	 * 修改 限制仓位
	 * @param id
	 * @return updated count 
	 */
	public int updateLimitcabin(Limitcabin limitcabin);

		
	/**
	 * 修改 限制仓位但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLimitcabinIgnoreNull(Limitcabin limitcabin);
		
	
	/**
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 限制仓位
	 * @param id
	 * @return
	 */
	public Limitcabin findLimitcabin(long id);
	
	
	/** 
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找限制仓位
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 限制仓位
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLimitcabinBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLimitcabinBySql(String sql);
	
}

