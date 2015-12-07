/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fguest;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFguestManager{ 
	
  
 	/**
	 * 创建 国际机票乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Fguest createFguest(Fguest fguest) throws SQLException;
	
	/**
	 * 删除 国际机票乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFguest(long id);
	
	
	/**
	 * 修改 国际机票乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updateFguest(Fguest fguest);

		
	/**
	 * 修改 国际机票乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFguestIgnoreNull(Fguest fguest);
		
	
	/**
	 * 查找 国际机票乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票乘机人表
	 * @param id
	 * @return
	 */
	public Fguest findFguest(long id);
	
	
	/** 
	 * 查找 国际机票乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFguest(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFguestBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFguestBySql(String sql);
	
}

