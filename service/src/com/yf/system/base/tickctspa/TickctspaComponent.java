/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tickctspa;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TickctspaComponent   implements ITickctspaComponent{ 
	
	
	private ITickctspaManager tickctspaManager;
   
   
 	public ITickctspaManager getTickctspaManager() {
		return tickctspaManager;
	}

	public void setTickctspaManager(ITickctspaManager tickctspaManager) {
		this.tickctspaManager = tickctspaManager;
	}
  
 	/**
	 * 创建 票务温泉
	 * @param id
	 * @return deleted count 
	 */
	public Tickctspa createTickctspa(Tickctspa tickctspa) throws SQLException{
	
		return tickctspaManager.createTickctspa(tickctspa);
	}
	/**
	 * 删除 票务温泉
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTickctspa(long id){
	
		return tickctspaManager.deleteTickctspa(id);
	}
	
	
	/**
	 * 修改 票务温泉
	 * @param id
	 * @return updated count 
	 */
	public int updateTickctspa(Tickctspa tickctspa){
		return tickctspaManager.updateTickctspa(tickctspa);
	
	}

		
	/**
	 * 修改 票务温泉但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTickctspaIgnoreNull(Tickctspa tickctspa){
			return tickctspaManager.updateTickctspaIgnoreNull(tickctspa);
	
	}
	
	/**
	 * 查找 票务温泉
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspa(String where, String orderby,int limit,int offset){
		return tickctspaManager.findAllTickctspa(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 票务温泉
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspa(long id){
		return tickctspaManager.findTickctspa(id);
	}
	/**
	 * 查找 票务温泉 by language
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspabylanguage(long id,Integer language){
		return tickctspaManager.findTickctspabylanguage(id,language);
	}
	/** 
	 * 查找 票务温泉
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickctspa(String where, String orderby,PageInfo pageinfo){
		return tickctspaManager.findAllTickctspa(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找票务温泉
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspa(String sql,int limit,int offset){
		return tickctspaManager.findAllTickctspa(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 票务温泉
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTickctspaBySql(String sql){
		return tickctspaManager.excuteTickctspaBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTickctspaBySql(String sql){
		return tickctspaManager.countTickctspaBySql(sql);
	}
}

