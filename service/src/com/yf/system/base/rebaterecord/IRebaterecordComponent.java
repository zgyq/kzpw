/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rebaterecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRebaterecordComponent{ 
	
  
 	/**
	 * 创建 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterecord createRebaterecord(Rebaterecord rebaterecord) throws SQLException;
	
	/**
	 * 删除 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterecord(long id);
	
	
	/**
	 * 修改 返佣记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterecord(Rebaterecord rebaterecord);

		
	/**
	 * 修改 返佣记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebaterecordIgnoreNull(Rebaterecord rebaterecord);
		
	
	/**
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 返佣记录表
	 * @param id
	 * @return
	 */
	public Rebaterecord findRebaterecord(long id);
	
	
	/** 
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,PageInfo pageinfo,String ...sql);
		
	/** 
	 * 根据Sql查找返佣记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 返佣记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebaterecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebaterecordBySql(String sql);
	
}

