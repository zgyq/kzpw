/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.supteam;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISupteamComponent{ 
	
  
 	/**
	 * 创建 团队申请报价表
	 * @param id
	 * @return deleted count 
	 */
	public Supteam createSupteam(Supteam supteam) throws SQLException;
	
	/**
	 * 删除 团队申请报价表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSupteam(long id);
	
	
	/**
	 * 修改 团队申请报价表
	 * @param id
	 * @return updated count 
	 */
	public int updateSupteam(Supteam supteam);

		
	/**
	 * 修改 团队申请报价表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSupteamIgnoreNull(Supteam supteam);
		
	
	/**
	 * 查找 团队申请报价表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 团队申请报价表
	 * @param id
	 * @return
	 */
	public Supteam findSupteam(long id);
	
	
	/** 
	 * 查找 团队申请报价表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找团队申请报价表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 团队申请报价表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSupteamBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSupteamBySql(String sql);
	
}

