/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.infocontent;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class InfocontentComponent   implements IInfocontentComponent{ 
	
	
	private IInfocontentManager infocontentManager;
   
   
 	public IInfocontentManager getInfocontentManager() {
		return infocontentManager;
	}

	public void setInfocontentManager(IInfocontentManager infocontentManager) {
		this.infocontentManager = infocontentManager;
	}
  
 	/**
	 * 创建 信息
	 * @param id
	 * @return deleted count 
	 */
	public Infocontent createInfocontent(Infocontent infocontent) throws SQLException{
	
		return infocontentManager.createInfocontent(infocontent);
	}
	/**
	 * 删除 信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfocontent(long id){
	
		return infocontentManager.deleteInfocontent(id);
	}
	
	
	/**
	 * 修改 信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInfocontent(Infocontent infocontent){
		return infocontentManager.updateInfocontent(infocontent);
	
	}

		
	/**
	 * 修改 信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfocontentIgnoreNull(Infocontent infocontent){
			return infocontentManager.updateInfocontentIgnoreNull(infocontent);
	
	}
	
	/**
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontent(String where, String orderby,int limit,int offset){
		return infocontentManager.findAllInfocontent(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 信息
	 * @param id
	 * @return
	 */
	public Infocontent findInfocontent(long id){
		return infocontentManager.findInfocontent(id);
	}
	
	/** 
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfocontent(String where, String orderby,PageInfo pageinfo){
		return infocontentManager.findAllInfocontent(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontent(String sql,int limit,int offset){
		return infocontentManager.findAllInfocontent(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfocontentBySql(String sql){
		return infocontentManager.excuteInfocontentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfocontentBySql(String sql){
		return infocontentManager.countInfocontentBySql(sql);
	}
}

