/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airfee;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAirfeeManager{ 
	
  
 	/**
	 * 创建 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public Airfee createAirfee(Airfee airfee) throws SQLException;
	
	/**
	 * 删除 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirfee(long id);
	
	
	/**
	 * 修改 燃油费机建费表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirfee(Airfee airfee);

		
	/**
	 * 修改 燃油费机建费表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirfeeIgnoreNull(Airfee airfee);
		
	
	/**
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 燃油费机建费表
	 * @param id
	 * @return
	 */
	public Airfee findAirfee(long id);
	
	/**
	 * 查找 燃油费机建费表 by language
	 * @param id
	 * @return
	 */
	public Airfee findAirfeebylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找燃油费机建费表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 燃油费机建费表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirfeeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirfeeBySql(String sql);
	
}

