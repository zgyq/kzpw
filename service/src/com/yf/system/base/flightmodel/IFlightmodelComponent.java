/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.flightmodel;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFlightmodelComponent{ 
	
  
 	/**
	 * 创建 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public Flightmodel createFlightmodel(Flightmodel flightmodel) throws SQLException;
	
	/**
	 * 删除 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightmodel(long id);
	
	
	/**
	 * 修改 机型信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightmodel(Flightmodel flightmodel);

		
	/**
	 * 修改 机型信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightmodelIgnoreNull(Flightmodel flightmodel);
		
	
	/**
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 机型信息表
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodel(long id);
	
	/**
	 * 查找 机型信息表 by language
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodelbylanguage(long id,Integer language);
	
	/** 
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找机型信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 机型信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightmodelBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightmodelBySql(String sql);
	
}

