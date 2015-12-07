/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fairport;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FairportComponent   implements IFairportComponent{ 
	
	
	private IFairportManager fairportManager;
   
   
 	public IFairportManager getFairportManager() {
		return fairportManager;
	}

	public void setFairportManager(IFairportManager fairportManager) {
		this.fairportManager = fairportManager;
	}
  
 	/**
	 * 创建 国际机票机场
	 * @param id
	 * @return deleted count 
	 */
	public Fairport createFairport(Fairport fairport) throws SQLException{
	
		return fairportManager.createFairport(fairport);
	}
	/**
	 * 删除 国际机票机场
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairport(long id){
	
		return fairportManager.deleteFairport(id);
	}
	
	
	/**
	 * 修改 国际机票机场
	 * @param id
	 * @return updated count 
	 */
	public int updateFairport(Fairport fairport){
		return fairportManager.updateFairport(fairport);
	
	}

		
	/**
	 * 修改 国际机票机场但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFairportIgnoreNull(Fairport fairport){
			return fairportManager.updateFairportIgnoreNull(fairport);
	
	}
	
	/**
	 * 查找 国际机票机场
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String where, String orderby,int limit,int offset){
		return fairportManager.findAllFairport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票机场
	 * @param id
	 * @return
	 */
	public Fairport findFairport(long id){
		return fairportManager.findFairport(id);
	}
	/**
	 * 查找 国际机票机场 by language
	 * @param id
	 * @return
	 */
	public Fairport findFairportbylanguage(long id,Integer language){
		return fairportManager.findFairportbylanguage(id,language);
	}
	/** 
	 * 查找 国际机票机场
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairport(String where, String orderby,PageInfo pageinfo){
		return fairportManager.findAllFairport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票机场
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String sql,int limit,int offset){
		return fairportManager.findAllFairport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票机场
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairportBySql(String sql){
		return fairportManager.excuteFairportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairportBySql(String sql){
		return fairportManager.countFairportBySql(sql);
	}
}

