/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.gift;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IGiftComponent{ 
	
  
 	/**
	 * 创建 礼品
	 * @param id
	 * @return deleted count 
	 */
	public Gift createGift(Gift gift) throws SQLException;
	
	/**
	 * 删除 礼品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGift(long id);
	
	
	/**
	 * 修改 礼品
	 * @param id
	 * @return updated count 
	 */
	public int updateGift(Gift gift);

		
	/**
	 * 修改 礼品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftIgnoreNull(Gift gift);
		
	
	/**
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 礼品
	 * @param id
	 * @return
	 */
	public Gift findGift(long id);
	
	/**
	 * 查找 礼品 by language
	 * @param id
	 * @return
	 */
	public Gift findGiftbylanguage(long id,Integer language);
	
	/** 
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGift(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找礼品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 礼品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftBySql(String sql);
	
}

