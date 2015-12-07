/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fdeliverassign;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FdeliverassignComponent   implements IFdeliverassignComponent{ 
	
	
	private IFdeliverassignManager fdeliverassignManager;
   
   
 	public IFdeliverassignManager getFdeliverassignManager() {
		return fdeliverassignManager;
	}

	public void setFdeliverassignManager(IFdeliverassignManager fdeliverassignManager) {
		this.fdeliverassignManager = fdeliverassignManager;
	}
  
 	/**
	 * 创建 国际机票配送信息
	 * @param id
	 * @return deleted count 
	 */
	public Fdeliverassign createFdeliverassign(Fdeliverassign fdeliverassign) throws SQLException{
	
		return fdeliverassignManager.createFdeliverassign(fdeliverassign);
	}
	/**
	 * 删除 国际机票配送信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFdeliverassign(long id){
	
		return fdeliverassignManager.deleteFdeliverassign(id);
	}
	
	
	/**
	 * 修改 国际机票配送信息
	 * @param id
	 * @return updated count 
	 */
	public int updateFdeliverassign(Fdeliverassign fdeliverassign){
		return fdeliverassignManager.updateFdeliverassign(fdeliverassign);
	
	}

		
	/**
	 * 修改 国际机票配送信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFdeliverassignIgnoreNull(Fdeliverassign fdeliverassign){
			return fdeliverassignManager.updateFdeliverassignIgnoreNull(fdeliverassign);
	
	}
	
	/**
	 * 查找 国际机票配送信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,int limit,int offset){
		return fdeliverassignManager.findAllFdeliverassign(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票配送信息
	 * @param id
	 * @return
	 */
	public Fdeliverassign findFdeliverassign(long id){
		return fdeliverassignManager.findFdeliverassign(id);
	}
	
	/** 
	 * 查找 国际机票配送信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,PageInfo pageinfo){
		return fdeliverassignManager.findAllFdeliverassign(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票配送信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String sql,int limit,int offset){
		return fdeliverassignManager.findAllFdeliverassign(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票配送信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFdeliverassignBySql(String sql){
		return fdeliverassignManager.excuteFdeliverassignBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFdeliverassignBySql(String sql){
		return fdeliverassignManager.countFdeliverassignBySql(sql);
	}
}

