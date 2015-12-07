/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.huodonguser;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHuodonguserComponent{ 
	
  
 	/**
	 * 创建 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public Huodonguser createHuodonguser(Huodonguser huodonguser) throws SQLException;
	
	/**
	 * 删除 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHuodonguser(long id);
	
	
	/**
	 * 修改 活动会员
	 * @param id
	 * @return updated count 
	 */
	public int updateHuodonguser(Huodonguser huodonguser);

		
	/**
	 * 修改 活动会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHuodonguserIgnoreNull(Huodonguser huodonguser);
		
	
	/**
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 活动会员
	 * @param id
	 * @return
	 */
	public Huodonguser findHuodonguser(long id);
	
	
	/** 
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找活动会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 活动会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHuodonguserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHuodonguserBySql(String sql);
	
}

