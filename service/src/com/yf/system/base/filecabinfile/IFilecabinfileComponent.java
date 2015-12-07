/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.filecabinfile;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFilecabinfileComponent{ 
	
  
 	/**
	 * 创建 文件
	 * @param id
	 * @return deleted count 
	 */
	public Filecabinfile createFilecabinfile(Filecabinfile filecabinfile) throws SQLException;
	
	/**
	 * 删除 文件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFilecabinfile(long id);
	
	
	/**
	 * 修改 文件
	 * @param id
	 * @return updated count 
	 */
	public int updateFilecabinfile(Filecabinfile filecabinfile);

		
	/**
	 * 修改 文件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFilecabinfileIgnoreNull(Filecabinfile filecabinfile);
		
	
	/**
	 * 查找 文件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabinfile(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 文件
	 * @param id
	 * @return
	 */
	public Filecabinfile findFilecabinfile(long id);
	
	
	/** 
	 * 查找 文件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFilecabinfile(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找文件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabinfile(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 文件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFilecabinfileBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFilecabinfileBySql(String sql);
	
}

