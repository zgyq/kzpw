/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.specialprice;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpecialpriceComponent{ 
	
  
 	/**
	 * 创建 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public Specialprice createSpecialprice(Specialprice specialprice) throws SQLException;
	
	/**
	 * 删除 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpecialprice(long id);
	
	
	/**
	 * 修改 特价机票信息（定期更新）
	 * @param id
	 * @return updated count 
	 */
	public int updateSpecialprice(Specialprice specialprice);

		
	/**
	 * 修改 特价机票信息（定期更新）但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpecialpriceIgnoreNull(Specialprice specialprice);
		
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param id
	 * @return
	 */
	public Specialprice findSpecialprice(long id);
	
	
	/** 
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找特价机票信息（定期更新）
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 特价机票信息（定期更新）
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpecialpriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpecialpriceBySql(String sql);
	
}

