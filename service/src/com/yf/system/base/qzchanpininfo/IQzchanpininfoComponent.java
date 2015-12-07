/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzchanpininfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IQzchanpininfoComponent{ 
	
  
 	/**
	 * 创建 签证产品详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Qzchanpininfo createQzchanpininfo(Qzchanpininfo qzchanpininfo) throws SQLException;
	
	/**
	 * 删除 签证产品详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzchanpininfo(long id);
	
	
	/**
	 * 修改 签证产品详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateQzchanpininfo(Qzchanpininfo qzchanpininfo);

		
	/**
	 * 修改 签证产品详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzchanpininfoIgnoreNull(Qzchanpininfo qzchanpininfo);
		
	
	/**
	 * 查找 签证产品详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpininfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 签证产品详细信息
	 * @param id
	 * @return
	 */
	public Qzchanpininfo findQzchanpininfo(long id);
	
	
	/** 
	 * 查找 签证产品详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzchanpininfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找签证产品详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpininfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 签证产品详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzchanpininfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzchanpininfoBySql(String sql);
	
}

