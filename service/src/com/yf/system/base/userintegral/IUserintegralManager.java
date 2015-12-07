/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.userintegral;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IUserintegralManager{ 
	
  
 	/**
	 * 创建 会员积分记录表
	 * @param id
	 * @return deleted count 
	 */
	public Userintegral createUserintegral(Userintegral userintegral) throws SQLException;
	
	/**
	 * 删除 会员积分记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUserintegral(long id);
	
	
	/**
	 * 修改 会员积分记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateUserintegral(Userintegral userintegral);

		
	/**
	 * 修改 会员积分记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUserintegralIgnoreNull(Userintegral userintegral);
		
	
	/**
	 * 查找 会员积分记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUserintegral(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员积分记录表
	 * @param id
	 * @return
	 */
	public Userintegral findUserintegral(long id);
	
	
	/** 
	 * 查找 会员积分记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUserintegral(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员积分记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUserintegral(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员积分记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUserintegralBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUserintegralBySql(String sql);
	
}

