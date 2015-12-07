/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airflight;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAirflightComponent{ 
	
  
 	/**
	 * 创建 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Airflight createAirflight(Airflight airflight) throws SQLException;
	
	/**
	 * 删除 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirflight(long id);
	
	
	/**
	 * 修改 航班基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirflight(Airflight airflight);

		
	/**
	 * 修改 航班基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirflightIgnoreNull(Airflight airflight);
		
	
	/**
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 航班基础信息表
	 * @param id
	 * @return
	 */
	public Airflight findAirflight(long id);
	
	/**
	 * 查找 航班基础信息表 by language
	 * @param id
	 * @return
	 */
	public Airflight findAirflightbylanguage(long id,Integer language);
	
	/** 
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找航班基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 航班基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirflightBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirflightBySql(String sql);
	
}

