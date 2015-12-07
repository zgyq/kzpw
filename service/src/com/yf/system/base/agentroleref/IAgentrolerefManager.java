/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.agentroleref;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAgentrolerefManager{ 
	
  
 	/**
	 * 创建 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public Agentroleref createAgentroleref(Agentroleref agentroleref) throws SQLException;
	
	/**
	 * 删除 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentroleref(long id);
	
	
	/**
	 * 修改 会员角色关联
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentroleref(Agentroleref agentroleref);

		
	/**
	 * 修改 会员角色关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentrolerefIgnoreNull(Agentroleref agentroleref);
		
	
	/**
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员角色关联
	 * @param id
	 * @return
	 */
	public Agentroleref findAgentroleref(long id);
	
	
	/** 
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员角色关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员角色关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentrolerefBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentrolerefBySql(String sql);
	
}

