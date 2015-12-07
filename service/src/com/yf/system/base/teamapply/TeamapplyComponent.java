/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.teamapply;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TeamapplyComponent   implements ITeamapplyComponent{ 
	
	
	private ITeamapplyManager teamapplyManager;
   
   
 	public ITeamapplyManager getTeamapplyManager() {
		return teamapplyManager;
	}

	public void setTeamapplyManager(ITeamapplyManager teamapplyManager) {
		this.teamapplyManager = teamapplyManager;
	}
  
 	/**
	 * 创建 团队申请表
	 * @param id
	 * @return deleted count 
	 */
	public Teamapply createTeamapply(Teamapply teamapply) throws SQLException{
	
		return teamapplyManager.createTeamapply(teamapply);
	}
	/**
	 * 删除 团队申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTeamapply(long id){
	
		return teamapplyManager.deleteTeamapply(id);
	}
	
	
	/**
	 * 修改 团队申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTeamapply(Teamapply teamapply){
		return teamapplyManager.updateTeamapply(teamapply);
	
	}

		
	/**
	 * 修改 团队申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTeamapplyIgnoreNull(Teamapply teamapply){
			return teamapplyManager.updateTeamapplyIgnoreNull(teamapply);
	
	}
	
	/**
	 * 查找 团队申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTeamapply(String where, String orderby,int limit,int offset){
		return teamapplyManager.findAllTeamapply(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团队申请表
	 * @param id
	 * @return
	 */
	public Teamapply findTeamapply(long id){
		return teamapplyManager.findTeamapply(id);
	}
	
	/** 
	 * 查找 团队申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTeamapply(String where, String orderby,PageInfo pageinfo){
		return teamapplyManager.findAllTeamapply(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团队申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTeamapply(String sql,int limit,int offset){
		return teamapplyManager.findAllTeamapply(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团队申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTeamapplyBySql(String sql){
		return teamapplyManager.excuteTeamapplyBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTeamapplyBySql(String sql){
		return teamapplyManager.countTeamapplyBySql(sql);
	}
}

