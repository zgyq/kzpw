/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.scang;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ScangComponent   implements IScangComponent{ 
	
	
	private IScangManager scangManager;
   
   
 	public IScangManager getScangManager() {
		return scangManager;
	}

	public void setScangManager(IScangManager scangManager) {
		this.scangManager = scangManager;
	}
  
 	/**
	 * 创建 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public Scang createScang(Scang scang) throws SQLException{
	
		return scangManager.createScang(scang);
	}
	/**
	 * 删除 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScang(long id){
	
		return scangManager.deleteScang(id);
	}
	
	
	/**
	 * 修改 订单升舱表
	 * @param id
	 * @return updated count 
	 */
	public int updateScang(Scang scang){
		return scangManager.updateScang(scang);
	
	}

		
	/**
	 * 修改 订单升舱表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScangIgnoreNull(Scang scang){
			return scangManager.updateScangIgnoreNull(scang);
	
	}
	
	/**
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String where, String orderby,int limit,int offset){
		return scangManager.findAllScang(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 订单升舱表
	 * @param id
	 * @return
	 */
	public Scang findScang(long id){
		return scangManager.findScang(id);
	}
	
	/** 
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScang(String where, String orderby,PageInfo pageinfo){
		return scangManager.findAllScang(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找订单升舱表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String sql,int limit,int offset){
		return scangManager.findAllScang(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 订单升舱表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScangBySql(String sql){
		return scangManager.excuteScangBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScangBySql(String sql){
		return scangManager.countScangBySql(sql);
	}
}

