/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzguojia;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IQzguojiaComponent{ 
	
  
 	/**
	 * 创建 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public Qzguojia createQzguojia(Qzguojia qzguojia) throws SQLException;
	
	/**
	 * 删除 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzguojia(long id);
	
	
	/**
	 * 修改 签证国家
	 * @param id
	 * @return updated count 
	 */
	public int updateQzguojia(Qzguojia qzguojia);

		
	/**
	 * 修改 签证国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzguojiaIgnoreNull(Qzguojia qzguojia);
		
	
	/**
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 签证国家
	 * @param id
	 * @return
	 */
	public Qzguojia findQzguojia(long id);
	
	
	/** 
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找签证国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 签证国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzguojiaBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzguojiaBySql(String sql);
	
}

