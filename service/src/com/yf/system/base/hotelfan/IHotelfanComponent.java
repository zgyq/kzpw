/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelfan;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelfanComponent{ 
	
  
 	/**
	 * 创建 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelfan createHotelfan(Hotelfan hotelfan) throws SQLException;
	
	/**
	 * 删除 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelfan(long id);
	
	
	/**
	 * 修改 酒店设置返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelfan(Hotelfan hotelfan);

		
	/**
	 * 修改 酒店设置返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelfanIgnoreNull(Hotelfan hotelfan);
		
	
	/**
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfan(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店设置返点表
	 * @param id
	 * @return
	 */
	public Hotelfan findHotelfan(long id);
	
	
	/** 
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelfan(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店设置返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfan(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店设置返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelfanBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelfanBySql(String sql);
	
}

