/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insuruser;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IInsuruserManager{ 
	
  
 	/**
	 * 创建 被保人列表
	 * @param id
	 * @return deleted count 
	 */
	public Insuruser createInsuruser(Insuruser insuruser) throws SQLException;
	
	/**
	 * 删除 被保人列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsuruser(long id);
	
	
	/**
	 * 修改 被保人列表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsuruser(Insuruser insuruser);

		
	/**
	 * 修改 被保人列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsuruserIgnoreNull(Insuruser insuruser);
		
	
	/**
	 * 查找 被保人列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuruser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 被保人列表
	 * @param id
	 * @return
	 */
	public Insuruser findInsuruser(long id);
	
	
	/** 
	 * 查找 被保人列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsuruser(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找被保人列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuruser(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 被保人列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsuruserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsuruserBySql(String sql);
	
}

