/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotticket;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotticketManager{ 
	
  
 	/**
	 * 创建 景点门票
	 * @param id
	 * @return deleted count 
	 */
	public Spotticket createSpotticket(Spotticket spotticket) throws SQLException;
	
	/**
	 * 删除 景点门票
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotticket(long id);
	
	
	/**
	 * 修改 景点门票
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotticket(Spotticket spotticket);

		
	/**
	 * 修改 景点门票但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotticketIgnoreNull(Spotticket spotticket);
		
	
	/**
	 * 查找 景点门票
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticket(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 景点门票
	 * @param id
	 * @return
	 */
	public Spotticket findSpotticket(long id);
	
	
	/** 
	 * 查找 景点门票
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticket(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找景点门票
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticket(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 景点门票
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotticketBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotticketBySql(String sql);
	
}

