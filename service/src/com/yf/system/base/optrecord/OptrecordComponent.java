/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.optrecord;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class OptrecordComponent   implements IOptrecordComponent{ 
	
	
	private IOptrecordManager optrecordManager;
   
   
 	public IOptrecordManager getOptrecordManager() {
		return optrecordManager;
	}

	public void setOptrecordManager(IOptrecordManager optrecordManager) {
		this.optrecordManager = optrecordManager;
	}
  
 	/**
	 * 创建 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public Optrecord createOptrecord(Optrecord optrecord) throws SQLException{
	
		return optrecordManager.createOptrecord(optrecord);
	}
	/**
	 * 删除 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOptrecord(long id){
	
		return optrecordManager.deleteOptrecord(id);
	}
	
	
	/**
	 * 修改 操作记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateOptrecord(Optrecord optrecord){
		return optrecordManager.updateOptrecord(optrecord);
	
	}

		
	/**
	 * 修改 操作记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOptrecordIgnoreNull(Optrecord optrecord){
			return optrecordManager.updateOptrecordIgnoreNull(optrecord);
	
	}
	
	/**
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,int limit,int offset){
		return optrecordManager.findAllOptrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 操作记录表
	 * @param id
	 * @return
	 */
	public Optrecord findOptrecord(long id){
		return optrecordManager.findOptrecord(id);
	}
	
	/** 
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,PageInfo pageinfo){
		return optrecordManager.findAllOptrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找操作记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String sql,int limit,int offset){
		return optrecordManager.findAllOptrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 操作记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOptrecordBySql(String sql){
		return optrecordManager.excuteOptrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOptrecordBySql(String sql){
		return optrecordManager.countOptrecordBySql(sql);
	}
}

