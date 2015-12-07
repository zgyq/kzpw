/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.repay;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RepayComponent   implements IRepayComponent{ 
	
	
	private IRepayManager repayManager;
   
   
 	public IRepayManager getRepayManager() {
		return repayManager;
	}

	public void setRepayManager(IRepayManager repayManager) {
		this.repayManager = repayManager;
	}
  
 	/**
	 * 创建 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public Repay createRepay(Repay repay) throws SQLException{
	
		return repayManager.createRepay(repay);
	}
	/**
	 * 删除 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRepay(long id){
	
		return repayManager.deleteRepay(id);
	}
	
	
	/**
	 * 修改 大客户还款记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRepay(Repay repay){
		return repayManager.updateRepay(repay);
	
	}

		
	/**
	 * 修改 大客户还款记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRepayIgnoreNull(Repay repay){
			return repayManager.updateRepayIgnoreNull(repay);
	
	}
	
	/**
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String where, String orderby,int limit,int offset){
		return repayManager.findAllRepay(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param id
	 * @return
	 */
	public Repay findRepay(long id){
		return repayManager.findRepay(id);
	}
	
	/** 
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRepay(String where, String orderby,PageInfo pageinfo){
		return repayManager.findAllRepay(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找大客户还款记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String sql,int limit,int offset){
		return repayManager.findAllRepay(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 大客户还款记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRepayBySql(String sql){
		return repayManager.excuteRepayBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRepayBySql(String sql){
		return repayManager.countRepayBySql(sql);
	}
}

