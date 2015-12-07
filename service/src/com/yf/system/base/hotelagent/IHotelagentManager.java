/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelagent;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelagentManager{ 
	
  
 	/**
	 * 创建 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelagent createHotelagent(Hotelagent hotelagent) throws SQLException;
	
	/**
	 * 删除 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelagent(long id);
	
	
	/**
	 * 修改 加盟商返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelagent(Hotelagent hotelagent);

		
	/**
	 * 修改 加盟商返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelagentIgnoreNull(Hotelagent hotelagent);
		
	
	/**
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 加盟商返点表
	 * @param id
	 * @return
	 */
	public Hotelagent findHotelagent(long id);
	
	
	/** 
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找加盟商返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 加盟商返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelagentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelagentBySql(String sql);
	
}

