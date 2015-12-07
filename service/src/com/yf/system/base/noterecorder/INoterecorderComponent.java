/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.noterecorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface INoterecorderComponent{ 
	
  
 	/**
	 * 创建 通知记录
	 * @param id
	 * @return deleted count 
	 */
	public Noterecorder createNoterecorder(Noterecorder noterecorder) throws SQLException;
	
	/**
	 * 删除 通知记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteNoterecorder(long id);
	
	
	/**
	 * 修改 通知记录
	 * @param id
	 * @return updated count 
	 */
	public int updateNoterecorder(Noterecorder noterecorder);

		
	/**
	 * 修改 通知记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateNoterecorderIgnoreNull(Noterecorder noterecorder);
		
	
	/**
	 * 查找 通知记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNoterecorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 通知记录
	 * @param id
	 * @return
	 */
	public Noterecorder findNoterecorder(long id);
	
	/**
	 * 查找 通知记录 by language
	 * @param id
	 * @return
	 */
	public Noterecorder findNoterecorderbylanguage(long id,Integer language);
	
	/** 
	 * 查找 通知记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllNoterecorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找通知记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNoterecorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 通知记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteNoterecorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countNoterecorderBySql(String sql);
	
}

