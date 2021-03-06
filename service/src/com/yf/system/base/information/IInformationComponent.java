/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.information;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IInformationComponent{ 
	
  
 	/**
	 * 创建 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public Information createInformation(Information information) throws SQLException;
	
	/**
	 * 删除 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformation(long id);
	
	
	/**
	 * 修改 资讯中心
	 * @param id
	 * @return updated count 
	 */
	public int updateInformation(Information information);

		
	/**
	 * 修改 资讯中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationIgnoreNull(Information information);
		
	
	/**
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 资讯中心
	 * @param id
	 * @return
	 */
	public Information findInformation(long id);
	
	
	/** 
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformation(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找资讯中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 资讯中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationBySql(String sql);
	
}

