/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IQqinfoManager{ 
	
  
 	/**
	 * 创建 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfo createQqinfo(Qqinfo qqinfo) throws SQLException;
	
	/**
	 * 删除 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfo(long id);
	
	/**
	 * 修改 QQ信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfo(Qqinfo qqinfo);

		
	/**
	 * 修改 QQ信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfoIgnoreNull(Qqinfo qqinfo);
		
	
	/**
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 QQ信息表
	 * @param id
	 * @return
	 */
	public Qqinfo findQqinfo(long id);
	
	
	/** 
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找QQ信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql QQ信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfoBySql(String sql);
	
}

