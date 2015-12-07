/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carsregion;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICarsregionManager{ 
	
  
 	/**
	 * 创建 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public Carsregion createCarsregion(Carsregion carsregion) throws SQLException;
	
	/**
	 * 删除 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarsregion(long id);
	
	
	/**
	 * 修改 送车上门区域
	 * @param id
	 * @return updated count 
	 */
	public int updateCarsregion(Carsregion carsregion);

		
	/**
	 * 修改 送车上门区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsregionIgnoreNull(Carsregion carsregion);
		
	
	/**
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 送车上门区域
	 * @param id
	 * @return
	 */
	public Carsregion findCarsregion(long id);
	
	
	/** 
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找送车上门区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 送车上门区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsregionBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsregionBySql(String sql);
	
}

