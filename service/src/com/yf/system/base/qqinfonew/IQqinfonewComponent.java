/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqinfonew;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IQqinfonewComponent{ 
	
  
 	/**
	 * 创建 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfonew createQqinfonew(Qqinfonew qqinfonew) throws SQLException;
	
	/**
	 * 删除 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfonew(long id);
	
	
	/**
	 * 修改 QQ号码
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfonew(Qqinfonew qqinfonew);

		
	/**
	 * 修改 QQ号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfonewIgnoreNull(Qqinfonew qqinfonew);
		
	
	/**
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 QQ号码
	 * @param id
	 * @return
	 */
	public Qqinfonew findQqinfonew(long id);
	
	
	/** 
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找QQ号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql QQ号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfonewBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfonewBySql(String sql);
	
}

