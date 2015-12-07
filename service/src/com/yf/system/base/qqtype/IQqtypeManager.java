/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqtype;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IQqtypeManager{ 
	
  
 	/**
	 * 创建 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public Qqtype createQqtype(Qqtype qqtype) throws SQLException;
	
	/**
	 * 删除 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqtype(long id);
	
	
	/**
	 * 修改 QQ类型
	 * @param id
	 * @return updated count 
	 */
	public int updateQqtype(Qqtype qqtype);

		
	/**
	 * 修改 QQ类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqtypeIgnoreNull(Qqtype qqtype);
		
	
	/**
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 QQ类型
	 * @param id
	 * @return
	 */
	public Qqtype findQqtype(long id);
	
	
	/** 
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqtype(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找QQ类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtype(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql QQ类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqtypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqtypeBySql(String sql);
	
}

