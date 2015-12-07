/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.peisong;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPeisongComponent{ 
	
  
 	/**
	 * 创建 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public Peisong createPeisong(Peisong peisong) throws SQLException;
	
	/**
	 * 删除 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePeisong(long id);
	
	
	/**
	 * 修改 行程单配送记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePeisong(Peisong peisong);

		
	/**
	 * 修改 行程单配送记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePeisongIgnoreNull(Peisong peisong);
		
	
	/**
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 行程单配送记录
	 * @param id
	 * @return
	 */
	public Peisong findPeisong(long id);
	
	
	/** 
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找行程单配送记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 行程单配送记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePeisongBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPeisongBySql(String sql);
	
}

