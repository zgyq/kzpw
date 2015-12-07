/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rperformance;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RperformanceComponent   implements IRperformanceComponent{ 
	
	
	private IRperformanceManager rperformanceManager;
   
   
 	public IRperformanceManager getRperformanceManager() {
		return rperformanceManager;
	}

	public void setRperformanceManager(IRperformanceManager rperformanceManager) {
		this.rperformanceManager = rperformanceManager;
	}
  
 	/**
	 * 创建 绩效合约统计
	 * @param id
	 * @return deleted count 
	 */
	public Rperformance createRperformance(Rperformance rperformance) throws SQLException{
	
		return rperformanceManager.createRperformance(rperformance);
	}
	/**
	 * 删除 绩效合约统计
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRperformance(long id){
	
		return rperformanceManager.deleteRperformance(id);
	}
	
	
	/**
	 * 修改 绩效合约统计
	 * @param id
	 * @return updated count 
	 */
	public int updateRperformance(Rperformance rperformance){
		return rperformanceManager.updateRperformance(rperformance);
	
	}

		
	/**
	 * 修改 绩效合约统计但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRperformanceIgnoreNull(Rperformance rperformance){
			return rperformanceManager.updateRperformanceIgnoreNull(rperformance);
	
	}
	
	/**
	 * 查找 绩效合约统计
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRperformance(String where, String orderby,int limit,int offset){
		return rperformanceManager.findAllRperformance(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 绩效合约统计
	 * @param id
	 * @return
	 */
	public Rperformance findRperformance(long id){
		return rperformanceManager.findRperformance(id);
	}
	
	/** 
	 * 查找 绩效合约统计
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRperformance(String where, String orderby,PageInfo pageinfo){
		return rperformanceManager.findAllRperformance(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找绩效合约统计
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRperformance(String sql,int limit,int offset){
		return rperformanceManager.findAllRperformance(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 绩效合约统计
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRperformanceBySql(String sql){
		return rperformanceManager.excuteRperformanceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRperformanceBySql(String sql){
		return rperformanceManager.countRperformanceBySql(sql);
	}
}

