/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelagent;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelagentComponent   implements IHotelagentComponent{ 
	
	
	private IHotelagentManager hotelagentManager;
   
   
 	public IHotelagentManager getHotelagentManager() {
		return hotelagentManager;
	}

	public void setHotelagentManager(IHotelagentManager hotelagentManager) {
		this.hotelagentManager = hotelagentManager;
	}
  
 	/**
	 * 创建 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelagent createHotelagent(Hotelagent hotelagent) throws SQLException{
	
		return hotelagentManager.createHotelagent(hotelagent);
	}
	/**
	 * 删除 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelagent(long id){
	
		return hotelagentManager.deleteHotelagent(id);
	}
	
	
	/**
	 * 修改 加盟商返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelagent(Hotelagent hotelagent){
		return hotelagentManager.updateHotelagent(hotelagent);
	
	}

		
	/**
	 * 修改 加盟商返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelagentIgnoreNull(Hotelagent hotelagent){
			return hotelagentManager.updateHotelagentIgnoreNull(hotelagent);
	
	}
	
	/**
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,int limit,int offset){
		return hotelagentManager.findAllHotelagent(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 加盟商返点表
	 * @param id
	 * @return
	 */
	public Hotelagent findHotelagent(long id){
		return hotelagentManager.findHotelagent(id);
	}
	
	/** 
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,PageInfo pageinfo){
		return hotelagentManager.findAllHotelagent(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找加盟商返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String sql,int limit,int offset){
		return hotelagentManager.findAllHotelagent(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 加盟商返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelagentBySql(String sql){
		return hotelagentManager.excuteHotelagentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelagentBySql(String sql){
		return hotelagentManager.countHotelagentBySql(sql);
	}
}

