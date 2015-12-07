/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airlien;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAirlienManager{ 
	
  
 	/**
	 * 创建 航线信息
	 * @param id
	 * @return deleted count 
	 */
	public Airlien createAirlien(Airlien airlien) throws SQLException;
	
	/**
	 * 删除 航线信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirlien(long id);
	
	
	/**
	 * 修改 航线信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirlien(Airlien airlien);

		
	/**
	 * 修改 航线信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirlienIgnoreNull(Airlien airlien);
		
	
	/**
	 * 查找 航线信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirlien(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 航线信息
	 * @param id
	 * @return
	 */
	public Airlien findAirlien(long id);
	
	
	/** 
	 * 查找 航线信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirlien(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找航线信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirlien(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 航线信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirlienBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirlienBySql(String sql);
	
}

