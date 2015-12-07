/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.liudianrecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ILiudianrecordManager{ 
	
  
 	/**
	 * 创建 留点记录表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrecord createLiudianrecord(Liudianrecord liudianrecord) throws SQLException;
	
	/**
	 * 删除 留点记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrecord(long id);
	
	
	/**
	 * 修改 留点记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrecord(Liudianrecord liudianrecord);

		
	/**
	 * 修改 留点记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrecordIgnoreNull(Liudianrecord liudianrecord);
		
	
	/**
	 * 查找 留点记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 留点记录表
	 * @param id
	 * @return
	 */
	public Liudianrecord findLiudianrecord(long id);
	
	/**
	 * 查找 留点记录表 by language
	 * @param id
	 * @return
	 */
	public Liudianrecord findLiudianrecordbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 留点记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找留点记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 留点记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrecordBySql(String sql);
	
}

