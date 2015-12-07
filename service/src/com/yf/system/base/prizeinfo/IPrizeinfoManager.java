/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.prizeinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPrizeinfoManager{ 
	
  
 	/**
	 * 创建 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public Prizeinfo createPrizeinfo(Prizeinfo prizeinfo) throws SQLException;
	
	/**
	 * 删除 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizeinfo(long id);
	
	
	/**
	 * 修改 积分礼品信息
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizeinfo(Prizeinfo prizeinfo);

		
	/**
	 * 修改 积分礼品信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizeinfoIgnoreNull(Prizeinfo prizeinfo);
		
	
	/**
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分礼品信息
	 * @param id
	 * @return
	 */
	public Prizeinfo findPrizeinfo(long id);
	
	
	/** 
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分礼品信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分礼品信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizeinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizeinfoBySql(String sql);
	
}

