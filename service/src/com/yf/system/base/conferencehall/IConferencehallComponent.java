/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.conferencehall;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IConferencehallComponent{ 
	
  
 	/**
	 * 创建 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehall createConferencehall(Conferencehall conferencehall) throws SQLException;
	
	/**
	 * 删除 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehall(long id);
	
	
	/**
	 * 修改 会议厅
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehall(Conferencehall conferencehall);

		
	/**
	 * 修改 会议厅但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehallIgnoreNull(Conferencehall conferencehall);
		
	
	/**
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会议厅
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehall(long id);
	
	/**
	 * 查找 会议厅 by language
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehallbylanguage(long id,Integer language);
	
	/** 
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会议厅
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会议厅
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehallBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehallBySql(String sql);
	
}

