/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymreceive;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IYmreceiveComponent{ 
	
  
 	/**
	 * 创建 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public Ymreceive createYmreceive(Ymreceive ymreceive) throws SQLException;
	
	/**
	 * 删除 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmreceive(long id);
	
	
	/**
	 * 修改 短信接收表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmreceive(Ymreceive ymreceive);

		
	/**
	 * 修改 短信接收表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmreceiveIgnoreNull(Ymreceive ymreceive);
		
	
	/**
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceive(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 短信接收表
	 * @param id
	 * @return
	 */
	public Ymreceive findYmreceive(long id);
	
	
	/** 
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmreceive(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找短信接收表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceive(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 短信接收表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmreceiveBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmreceiveBySql(String sql);
	
}

