/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotlineinfoComponent{ 
	
  
 	/**
	 * 创建 景区线路详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineinfo createSpotlineinfo(Spotlineinfo spotlineinfo) throws SQLException;
	
	/**
	 * 删除 景区线路详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineinfo(long id);
	
	
	/**
	 * 修改 景区线路详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineinfo(Spotlineinfo spotlineinfo);

		
	/**
	 * 修改 景区线路详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineinfoIgnoreNull(Spotlineinfo spotlineinfo);
		
	
	/**
	 * 查找 景区线路详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 景区线路详细信息
	 * @param id
	 * @return
	 */
	public Spotlineinfo findSpotlineinfo(long id);
	
	
	/** 
	 * 查找 景区线路详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找景区线路详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 景区线路详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineinfoBySql(String sql);
	
}

