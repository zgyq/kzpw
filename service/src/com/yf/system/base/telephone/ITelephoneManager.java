/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.telephone;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITelephoneManager{ 
	
  
 	/**
	 * 创建 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public Telephone createTelephone(Telephone telephone) throws SQLException;
	
	/**
	 * 删除 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTelephone(long id);
	
	
	/**
	 * 修改 其他电话
	 * @param id
	 * @return updated count 
	 */
	public int updateTelephone(Telephone telephone);

		
	/**
	 * 修改 其他电话但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTelephoneIgnoreNull(Telephone telephone);
		
	
	/**
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 其他电话
	 * @param id
	 * @return
	 */
	public Telephone findTelephone(long id);
	
	
	/** 
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找其他电话
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 其他电话
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTelephoneBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTelephoneBySql(String sql);
	
}

