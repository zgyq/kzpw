/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.settlementtype;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISettlementtypeManager{ 
	
  
 	/**
	 * 创建 结算分类表
	 * @param id
	 * @return deleted count 
	 */
	public Settlementtype createSettlementtype(Settlementtype settlementtype) throws SQLException;
	
	/**
	 * 删除 结算分类表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSettlementtype(long id);
	
	
	/**
	 * 修改 结算分类表
	 * @param id
	 * @return updated count 
	 */
	public int updateSettlementtype(Settlementtype settlementtype);

		
	/**
	 * 修改 结算分类表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSettlementtypeIgnoreNull(Settlementtype settlementtype);
		
	
	/**
	 * 查找 结算分类表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSettlementtype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 结算分类表
	 * @param id
	 * @return
	 */
	public Settlementtype findSettlementtype(long id);
	
	/**
	 * 查找 结算分类表 by language
	 * @param id
	 * @return
	 */
	public Settlementtype findSettlementtypebylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 结算分类表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSettlementtype(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找结算分类表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSettlementtype(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 结算分类表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSettlementtypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSettlementtypeBySql(String sql);
	
}

