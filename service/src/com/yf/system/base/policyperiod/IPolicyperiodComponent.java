/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.policyperiod;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPolicyperiodComponent{ 
	
  
 	/**
	 * 创建 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public Policyperiod createPolicyperiod(Policyperiod policyperiod) throws SQLException;
	
	/**
	 * 删除 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePolicyperiod(long id);
	
	
	/**
	 * 修改 政策有效期表
	 * @param id
	 * @return updated count 
	 */
	public int updatePolicyperiod(Policyperiod policyperiod);

		
	/**
	 * 修改 政策有效期表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePolicyperiodIgnoreNull(Policyperiod policyperiod);
		
	
	/**
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 政策有效期表
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiod(long id);
	
	/**
	 * 查找 政策有效期表 by language
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiodbylanguage(long id,Integer language);
	
	/** 
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找政策有效期表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 政策有效期表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePolicyperiodBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPolicyperiodBySql(String sql);
	
}

