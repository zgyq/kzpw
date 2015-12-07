/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdnoinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IXcdnoinfoManager{ 
	
  
 	/**
	 * 创建 行程单号码
	 * @param id
	 * @return deleted count 
	 */
	public Xcdnoinfo createXcdnoinfo(Xcdnoinfo xcdnoinfo) throws SQLException;
	
	/**
	 * 删除 行程单号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdnoinfo(long id);
	
	
	/**
	 * 修改 行程单号码
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdnoinfo(Xcdnoinfo xcdnoinfo);

		
	/**
	 * 修改 行程单号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdnoinfoIgnoreNull(Xcdnoinfo xcdnoinfo);
		
	
	/**
	 * 查找 行程单号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 行程单号码
	 * @param id
	 * @return
	 */
	public Xcdnoinfo findXcdnoinfo(long id);
	
	
	/** 
	 * 查找 行程单号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdnoinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找行程单号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 行程单号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdnoinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdnoinfoBySql(String sql);
	
}

