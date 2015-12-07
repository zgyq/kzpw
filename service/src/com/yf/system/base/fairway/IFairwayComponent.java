/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fairway;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFairwayComponent{ 
	
  
 	/**
	 * 创建 国际机票航空公司
	 * @param id
	 * @return deleted count 
	 */
	public Fairway createFairway(Fairway fairway) throws SQLException;
	
	/**
	 * 删除 国际机票航空公司
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairway(long id);
	
	
	/**
	 * 修改 国际机票航空公司
	 * @param id
	 * @return updated count 
	 */
	public int updateFairway(Fairway fairway);

		
	/**
	 * 修改 国际机票航空公司但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFairwayIgnoreNull(Fairway fairway);
		
	
	/**
	 * 查找 国际机票航空公司
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票航空公司
	 * @param id
	 * @return
	 */
	public Fairway findFairway(long id);
	
	/**
	 * 查找 国际机票航空公司 by language
	 * @param id
	 * @return
	 */
	public Fairway findFairwaybylanguage(long id,Integer language);
	
	/** 
	 * 查找 国际机票航空公司
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairway(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票航空公司
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票航空公司
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairwayBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairwayBySql(String sql);
	
}

