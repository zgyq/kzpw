/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.policyperiod;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PolicyperiodComponent   implements IPolicyperiodComponent{ 
	
	
	private IPolicyperiodManager policyperiodManager;
   
   
 	public IPolicyperiodManager getPolicyperiodManager() {
		return policyperiodManager;
	}

	public void setPolicyperiodManager(IPolicyperiodManager policyperiodManager) {
		this.policyperiodManager = policyperiodManager;
	}
  
 	/**
	 * 创建 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public Policyperiod createPolicyperiod(Policyperiod policyperiod) throws SQLException{
	
		return policyperiodManager.createPolicyperiod(policyperiod);
	}
	/**
	 * 删除 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePolicyperiod(long id){
	
		return policyperiodManager.deletePolicyperiod(id);
	}
	
	
	/**
	 * 修改 政策有效期表
	 * @param id
	 * @return updated count 
	 */
	public int updatePolicyperiod(Policyperiod policyperiod){
		return policyperiodManager.updatePolicyperiod(policyperiod);
	
	}

		
	/**
	 * 修改 政策有效期表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePolicyperiodIgnoreNull(Policyperiod policyperiod){
			return policyperiodManager.updatePolicyperiodIgnoreNull(policyperiod);
	
	}
	
	/**
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,int limit,int offset){
		return policyperiodManager.findAllPolicyperiod(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 政策有效期表
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiod(long id){
		return policyperiodManager.findPolicyperiod(id);
	}
	/**
	 * 查找 政策有效期表 by language
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiodbylanguage(long id,Integer language){
		return policyperiodManager.findPolicyperiodbylanguage(id,language);
	}
	/** 
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,PageInfo pageinfo){
		return policyperiodManager.findAllPolicyperiod(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找政策有效期表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String sql,int limit,int offset){
		return policyperiodManager.findAllPolicyperiod(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 政策有效期表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePolicyperiodBySql(String sql){
		return policyperiodManager.excutePolicyperiodBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPolicyperiodBySql(String sql){
		return policyperiodManager.countPolicyperiodBySql(sql);
	}
}

