/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.eterminfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class EterminfoComponent   implements IEterminfoComponent{ 
	
	
	private IEterminfoManager eterminfoManager;
   
   
 	public IEterminfoManager getEterminfoManager() {
		return eterminfoManager;
	}

	public void setEterminfoManager(IEterminfoManager eterminfoManager) {
		this.eterminfoManager = eterminfoManager;
	}
  
 	/**
	 * 创建 配置表
	 * @param id
	 * @return deleted count 
	 */
	public Eterminfo createEterminfo(Eterminfo eterminfo) throws SQLException{
	
		return eterminfoManager.createEterminfo(eterminfo);
	}
	/**
	 * 删除 配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEterminfo(long id){
	
		return eterminfoManager.deleteEterminfo(id);
	}
	
	
	/**
	 * 修改 配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateEterminfo(Eterminfo eterminfo){
		return eterminfoManager.updateEterminfo(eterminfo);
	
	}

		
	/**
	 * 修改 配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEterminfoIgnoreNull(Eterminfo eterminfo){
			return eterminfoManager.updateEterminfoIgnoreNull(eterminfo);
	
	}
	
	/**
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfo(String where, String orderby,int limit,int offset){
		return eterminfoManager.findAllEterminfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 配置表
	 * @param id
	 * @return
	 */
	public Eterminfo findEterminfo(long id){
		return eterminfoManager.findEterminfo(id);
	}
	
	/** 
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEterminfo(String where, String orderby,PageInfo pageinfo){
		return eterminfoManager.findAllEterminfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfo(String sql,int limit,int offset){
		return eterminfoManager.findAllEterminfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEterminfoBySql(String sql){
		return eterminfoManager.excuteEterminfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEterminfoBySql(String sql){
		return eterminfoManager.countEterminfoBySql(sql);
	}
}

