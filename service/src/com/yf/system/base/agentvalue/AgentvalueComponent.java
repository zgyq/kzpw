/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.agentvalue;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AgentvalueComponent   implements IAgentvalueComponent{ 
	
	
	private IAgentvalueManager agentvalueManager;
   
   
 	public IAgentvalueManager getAgentvalueManager() {
		return agentvalueManager;
	}

	public void setAgentvalueManager(IAgentvalueManager agentvalueManager) {
		this.agentvalueManager = agentvalueManager;
	}
  
 	/**
	 * 创建 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public Agentvalue createAgentvalue(Agentvalue agentvalue) throws SQLException{
	
		return agentvalueManager.createAgentvalue(agentvalue);
	}
	/**
	 * 删除 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentvalue(long id){
	
		return agentvalueManager.deleteAgentvalue(id);
	}
	
	
	/**
	 * 修改 加盟商固定返点
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentvalue(Agentvalue agentvalue){
		return agentvalueManager.updateAgentvalue(agentvalue);
	
	}

		
	/**
	 * 修改 加盟商固定返点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentvalueIgnoreNull(Agentvalue agentvalue){
			return agentvalueManager.updateAgentvalueIgnoreNull(agentvalue);
	
	}
	
	/**
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,int limit,int offset){
		return agentvalueManager.findAllAgentvalue(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 加盟商固定返点
	 * @param id
	 * @return
	 */
	public Agentvalue findAgentvalue(long id){
		return agentvalueManager.findAgentvalue(id);
	}
	
	/** 
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,PageInfo pageinfo){
		return agentvalueManager.findAllAgentvalue(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找加盟商固定返点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String sql,int limit,int offset){
		return agentvalueManager.findAllAgentvalue(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 加盟商固定返点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentvalueBySql(String sql){
		return agentvalueManager.excuteAgentvalueBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentvalueBySql(String sql){
		return agentvalueManager.countAgentvalueBySql(sql);
	}
}

