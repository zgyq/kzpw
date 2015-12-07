/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.biguserprice;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IBiguserpriceManager{ 
	
  
 	/**
	 * 创建 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public Biguserprice createBiguserprice(Biguserprice biguserprice) throws SQLException;
	
	/**
	 * 删除 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguserprice(long id);
	
	
	/**
	 * 修改 大客户还款金额记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguserprice(Biguserprice biguserprice);

		
	/**
	 * 修改 大客户还款金额记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserpriceIgnoreNull(Biguserprice biguserprice);
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param id
	 * @return
	 */
	public Biguserprice findBiguserprice(long id);
	
	
	/** 
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找大客户还款金额记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 大客户还款金额记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserpriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserpriceBySql(String sql);
	
}

