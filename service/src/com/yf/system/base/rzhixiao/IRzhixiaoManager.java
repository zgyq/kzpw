/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rzhixiao;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRzhixiaoManager{ 
	
  
 	/**
	 * 创建 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rzhixiao createRzhixiao(Rzhixiao rzhixiao) throws SQLException;
	
	/**
	 * 删除 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRzhixiao(long id);
	
	
	/**
	 * 修改 直销汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRzhixiao(Rzhixiao rzhixiao);

		
	/**
	 * 修改 直销汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRzhixiaoIgnoreNull(Rzhixiao rzhixiao);
		
	
	/**
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 直销汇总表
	 * @param id
	 * @return
	 */
	public Rzhixiao findRzhixiao(long id);
	
	
	/** 
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找直销汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 直销汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRzhixiaoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRzhixiaoBySql(String sql);
	
}

