/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.creditcard;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICreditcardComponent{ 
	
  
 	/**
	 * 创建 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public Creditcard createCreditcard(Creditcard creditcard) throws SQLException;
	
	/**
	 * 删除 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCreditcard(long id);
	
	
	/**
	 * 修改 信用卡记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateCreditcard(Creditcard creditcard);

		
	/**
	 * 修改 信用卡记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCreditcardIgnoreNull(Creditcard creditcard);
		
	
	/**
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 信用卡记录表
	 * @param id
	 * @return
	 */
	public Creditcard findCreditcard(long id);
	
	
	/** 
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找信用卡记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 信用卡记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCreditcardBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCreditcardBySql(String sql);
	
}

