/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICarinfoManager{ 
	
  
 	/**
	 * 创建 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public Carinfo createCarinfo(Carinfo carinfo) throws SQLException;
	
	/**
	 * 删除 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarinfo(long id);
	
	
	/**
	 * 修改 车型数据
	 * @param id
	 * @return updated count 
	 */
	public int updateCarinfo(Carinfo carinfo);

		
	/**
	 * 修改 车型数据但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarinfoIgnoreNull(Carinfo carinfo);
		
	
	/**
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 车型数据
	 * @param id
	 * @return
	 */
	public Carinfo findCarinfo(long id);
	
	
	/** 
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找车型数据
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 车型数据
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarinfoBySql(String sql);
	
}

