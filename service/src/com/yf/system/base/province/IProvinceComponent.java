/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.province;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IProvinceComponent{ 
	
  
 	/**
	 * 创建 省份
	 * @param id
	 * @return deleted count 
	 */
	public Province createProvince(Province province) throws SQLException;
	
	/**
	 * 删除 省份
	 * @param id
	 * @return deleted count 
	 */
	public int deleteProvince(long id);
	
	
	/**
	 * 修改 省份
	 * @param id
	 * @return updated count 
	 */
	public int updateProvince(Province province);

		
	/**
	 * 修改 省份但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateProvinceIgnoreNull(Province province);
		
	
	/**
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvince(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 省份
	 * @param id
	 * @return
	 */
	public Province findProvince(long id);
	
	/**
	 * 查找 省份 by language
	 * @param id
	 * @return
	 */
	public Province findProvincebylanguage(long id,Integer language);
	
	/** 
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllProvince(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找省份
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvince(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 省份
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteProvinceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countProvinceBySql(String sql);
	
}

