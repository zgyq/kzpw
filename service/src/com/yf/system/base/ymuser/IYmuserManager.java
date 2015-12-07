/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymuser;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IYmuserManager{ 
	
  
 	/**
	 * 创建 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public Ymuser createYmuser(Ymuser ymuser) throws SQLException;
	
	/**
	 * 删除 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmuser(long id);
	
	
	/**
	 * 修改 短信用户账号
	 * @param id
	 * @return updated count 
	 */
	public int updateYmuser(Ymuser ymuser);

		
	/**
	 * 修改 短信用户账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmuserIgnoreNull(Ymuser ymuser);
		
	
	/**
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 短信用户账号
	 * @param id
	 * @return
	 */
	public Ymuser findYmuser(long id);
	
	
	/** 
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找短信用户账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 短信用户账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmuserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmuserBySql(String sql);
	
}

