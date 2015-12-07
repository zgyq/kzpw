/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.segmentinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISegmentinfoComponent{ 
	
  
 	/**
	 * 创建 行程表
	 * @param id
	 * @return deleted count 
	 */
	public Segmentinfo createSegmentinfo(Segmentinfo segmentinfo) throws SQLException;
	
	/**
	 * 删除 行程表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSegmentinfo(long id);
	
	
	/**
	 * 修改 行程表
	 * @param id
	 * @return updated count 
	 */
	public int updateSegmentinfo(Segmentinfo segmentinfo);

		
	/**
	 * 修改 行程表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSegmentinfoIgnoreNull(Segmentinfo segmentinfo);
		
	
	/**
	 * 查找 行程表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSegmentinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 行程表
	 * @param id
	 * @return
	 */
	public Segmentinfo findSegmentinfo(long id);
	
	/**
	 * 查找 行程表 by language
	 * @param id
	 * @return
	 */
	public Segmentinfo findSegmentinfobylanguage(long id,Integer language);
	
	/** 
	 * 查找 行程表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSegmentinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找行程表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSegmentinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 行程表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSegmentinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSegmentinfoBySql(String sql);
	
}

