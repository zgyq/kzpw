/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.adcooperate;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAdcooperateManager{ 
	
  
 	/**
	 * 创建 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public Adcooperate createAdcooperate(Adcooperate adcooperate) throws SQLException;
	
	/**
	 * 删除 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdcooperate(long id);
	
	
	/**
	 * 修改 广告合作表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdcooperate(Adcooperate adcooperate);

		
	/**
	 * 修改 广告合作表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdcooperateIgnoreNull(Adcooperate adcooperate);
		
	
	/**
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 广告合作表
	 * @param id
	 * @return
	 */
	public Adcooperate findAdcooperate(long id);
	
	
	/** 
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找广告合作表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 广告合作表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdcooperateBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdcooperateBySql(String sql);
	
}

