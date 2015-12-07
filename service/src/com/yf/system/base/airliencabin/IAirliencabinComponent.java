/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airliencabin;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAirliencabinComponent{ 
	
  
 	/**
	 * 创建 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public Airliencabin createAirliencabin(Airliencabin airliencabin) throws SQLException;
	
	/**
	 * 删除 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirliencabin(long id);
	
	
	/**
	 * 修改 航线仓位信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirliencabin(Airliencabin airliencabin);

		
	/**
	 * 修改 航线仓位信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirliencabinIgnoreNull(Airliencabin airliencabin);
		
	
	/**
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 航线仓位信息
	 * @param id
	 * @return
	 */
	public Airliencabin findAirliencabin(long id);
	
	
	/** 
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找航线仓位信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 航线仓位信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirliencabinBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirliencabinBySql(String sql);
	
}

