﻿/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fsendticketcity;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFsendticketcityComponent{ 
	
  
 	/**
	 * 创建 国际机票送票城市
	 * @param id
	 * @return deleted count 
	 */
	public Fsendticketcity createFsendticketcity(Fsendticketcity fsendticketcity) throws SQLException;
	
	/**
	 * 删除 国际机票送票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFsendticketcity(long id);
	
	
	/**
	 * 修改 国际机票送票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateFsendticketcity(Fsendticketcity fsendticketcity);

		
	/**
	 * 修改 国际机票送票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFsendticketcityIgnoreNull(Fsendticketcity fsendticketcity);
		
	
	/**
	 * 查找 国际机票送票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票送票城市
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcity(long id);
	
	/**
	 * 查找 国际机票送票城市 by language
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcitybylanguage(long id,Integer language);
	
	/** 
	 * 查找 国际机票送票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票送票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票送票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFsendticketcityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFsendticketcityBySql(String sql);
	
}

