/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.giftcatalog;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IGiftcatalogComponent{ 
	
  
 	/**
	 * 创建 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public Giftcatalog createGiftcatalog(Giftcatalog giftcatalog) throws SQLException;
	
	/**
	 * 删除 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGiftcatalog(long id);
	
	
	/**
	 * 修改 礼品目录
	 * @param id
	 * @return updated count 
	 */
	public int updateGiftcatalog(Giftcatalog giftcatalog);

		
	/**
	 * 修改 礼品目录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftcatalogIgnoreNull(Giftcatalog giftcatalog);
		
	
	/**
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalog(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 礼品目录
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalog(long id);
	
	/**
	 * 查找 礼品目录 by language
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalogbylanguage(long id,Integer language);
	
	/** 
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGiftcatalog(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找礼品目录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalog(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 礼品目录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftcatalogBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftcatalogBySql(String sql);
	
}

