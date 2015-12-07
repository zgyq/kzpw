/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.integral;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class IntegralComponent   implements IIntegralComponent{ 
	
	
	private IIntegralManager integralManager;
   
   
 	public IIntegralManager getIntegralManager() {
		return integralManager;
	}

	public void setIntegralManager(IIntegralManager integralManager) {
		this.integralManager = integralManager;
	}
  
 	/**
	 * 创建 积分管理
	 * @param id
	 * @return deleted count 
	 */
	public Integral createIntegral(Integral integral) throws SQLException{
	
		return integralManager.createIntegral(integral);
	}
	/**
	 * 删除 积分管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntegral(long id){
	
		return integralManager.deleteIntegral(id);
	}
	
	
	/**
	 * 修改 积分管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntegral(Integral integral){
		return integralManager.updateIntegral(integral);
	
	}

		
	/**
	 * 修改 积分管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntegralIgnoreNull(Integral integral){
			return integralManager.updateIntegralIgnoreNull(integral);
	
	}
	
	/**
	 * 查找 积分管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntegral(String where, String orderby,int limit,int offset){
		return integralManager.findAllIntegral(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分管理
	 * @param id
	 * @return
	 */
	public Integral findIntegral(long id){
		return integralManager.findIntegral(id);
	}
	
	/** 
	 * 查找 积分管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntegral(String where, String orderby,PageInfo pageinfo){
		return integralManager.findAllIntegral(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntegral(String sql,int limit,int offset){
		return integralManager.findAllIntegral(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntegralBySql(String sql){
		return integralManager.excuteIntegralBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntegralBySql(String sql){
		return integralManager.countIntegralBySql(sql);
	}
}

