/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.agentvalue;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAgentvalueManager{ 
	
  
 	/**
	 * 创建 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public Agentvalue createAgentvalue(Agentvalue agentvalue) throws SQLException;
	
	/**
	 * 删除 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentvalue(long id);
	
	
	/**
	 * 修改 加盟商固定返点
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentvalue(Agentvalue agentvalue);

		
	/**
	 * 修改 加盟商固定返点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentvalueIgnoreNull(Agentvalue agentvalue);
		
	
	/**
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 加盟商固定返点
	 * @param id
	 * @return
	 */
	public Agentvalue findAgentvalue(long id);
	
	
	/** 
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找加盟商固定返点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 加盟商固定返点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentvalueBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentvalueBySql(String sql);
	
}

