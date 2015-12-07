/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cpzrate;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICpzrateComponent{ 
	
  
 	/**
	 * 创建 包机政策
	 * @param id
	 * @return deleted count 
	 */
	public Cpzrate createCpzrate(Cpzrate cpzrate) throws SQLException;
	
	/**
	 * 删除 包机政策
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCpzrate(long id);
	
	
	/**
	 * 修改 包机政策
	 * @param id
	 * @return updated count 
	 */
	public int updateCpzrate(Cpzrate cpzrate);

		
	/**
	 * 修改 包机政策但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCpzrateIgnoreNull(Cpzrate cpzrate);
		
	
	/**
	 * 查找 包机政策
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCpzrate(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 包机政策
	 * @param id
	 * @return
	 */
	public Cpzrate findCpzrate(long id);
	
	
	/** 
	 * 查找 包机政策
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCpzrate(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找包机政策
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCpzrate(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 包机政策
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCpzrateBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCpzrateBySql(String sql);
	
}

