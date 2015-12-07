/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.templet;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TempletComponent   implements ITempletComponent{ 
	
	
	private ITempletManager templetManager;
   
   
 	public ITempletManager getTempletManager() {
		return templetManager;
	}

	public void setTempletManager(ITempletManager templetManager) {
		this.templetManager = templetManager;
	}
  
 	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Templet createTemplet(Templet templet) throws SQLException{
	
		return templetManager.createTemplet(templet);
	}
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplet(long id){
	
		return templetManager.deleteTemplet(id);
	}
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplet(Templet templet){
		return templetManager.updateTemplet(templet);
	
	}

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTempletIgnoreNull(Templet templet){
			return templetManager.updateTempletIgnoreNull(templet);
	
	}
	
	/**
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplet(String where, String orderby,int limit,int offset){
		return templetManager.findAllTemplet(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Templet findTemplet(long id){
		return templetManager.findTemplet(id);
	}
	
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTemplet(String where, String orderby,PageInfo pageinfo){
		return templetManager.findAllTemplet(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplet(String sql,int limit,int offset){
		return templetManager.findAllTemplet(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTempletBySql(String sql){
		return templetManager.excuteTempletBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTempletBySql(String sql){
		return templetManager.countTempletBySql(sql);
	}
}

