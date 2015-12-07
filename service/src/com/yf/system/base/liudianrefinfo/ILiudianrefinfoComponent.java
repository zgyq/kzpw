/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.liudianrefinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ILiudianrefinfoComponent{ 
	
  
 	/**
	 * 创建 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrefinfo createLiudianrefinfo(Liudianrefinfo liudianrefinfo) throws SQLException;
	
	/**
	 * 删除 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrefinfo(long id);
	
	
	/**
	 * 修改 留点设置关联表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrefinfo(Liudianrefinfo liudianrefinfo);

		
	/**
	 * 修改 留点设置关联表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrefinfoIgnoreNull(Liudianrefinfo liudianrefinfo);
		
	
	/**
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 留点设置关联表
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfo(long id);
	
	/**
	 * 查找 留点设置关联表 by language
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfobylanguage(long id,Integer language);
	
	/** 
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找留点设置关联表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 留点设置关联表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrefinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrefinfoBySql(String sql);
	
}

