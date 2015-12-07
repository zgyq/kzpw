/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.biguser;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IBiguserComponent{ 
	
  
 	/**
	 * 创建 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public Biguser createBiguser(Biguser biguser) throws SQLException;
	
	/**
	 * 删除 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguser(long id);
	
	
	/**
	 * 修改 大客户关联金额表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguser(Biguser biguser);

		
	/**
	 * 修改 大客户关联金额表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserIgnoreNull(Biguser biguser);
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param id
	 * @return
	 */
	public Biguser findBiguser(long id);
	
	
	/** 
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找大客户关联金额表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 大客户关联金额表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserBySql(String sql);
	
}

