/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insurcomputer;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class InsurcomputerComponent   implements IInsurcomputerComponent{ 
	
	
	private IInsurcomputerManager insurcomputerManager;
   
   
 	public IInsurcomputerManager getInsurcomputerManager() {
		return insurcomputerManager;
	}

	public void setInsurcomputerManager(IInsurcomputerManager insurcomputerManager) {
		this.insurcomputerManager = insurcomputerManager;
	}
  
 	/**
	 * 创建 保险服务公司信息
	 * @param id
	 * @return deleted count 
	 */
	public Insurcomputer createInsurcomputer(Insurcomputer insurcomputer) throws SQLException{
	
		return insurcomputerManager.createInsurcomputer(insurcomputer);
	}
	/**
	 * 删除 保险服务公司信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsurcomputer(long id){
	
		return insurcomputerManager.deleteInsurcomputer(id);
	}
	
	
	/**
	 * 修改 保险服务公司信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInsurcomputer(Insurcomputer insurcomputer){
		return insurcomputerManager.updateInsurcomputer(insurcomputer);
	
	}

		
	/**
	 * 修改 保险服务公司信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsurcomputerIgnoreNull(Insurcomputer insurcomputer){
			return insurcomputerManager.updateInsurcomputerIgnoreNull(insurcomputer);
	
	}
	
	/**
	 * 查找 保险服务公司信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurcomputer(String where, String orderby,int limit,int offset){
		return insurcomputerManager.findAllInsurcomputer(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 保险服务公司信息
	 * @param id
	 * @return
	 */
	public Insurcomputer findInsurcomputer(long id){
		return insurcomputerManager.findInsurcomputer(id);
	}
	
	/** 
	 * 查找 保险服务公司信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsurcomputer(String where, String orderby,PageInfo pageinfo){
		return insurcomputerManager.findAllInsurcomputer(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找保险服务公司信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurcomputer(String sql,int limit,int offset){
		return insurcomputerManager.findAllInsurcomputer(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 保险服务公司信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsurcomputerBySql(String sql){
		return insurcomputerManager.excuteInsurcomputerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsurcomputerBySql(String sql){
		return insurcomputerManager.countInsurcomputerBySql(sql);
	}
}

