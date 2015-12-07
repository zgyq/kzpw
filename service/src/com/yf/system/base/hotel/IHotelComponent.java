/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotel;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelComponent{ 
	
  
 	/**
	 * 创建 酒店
	 * @param id
	 * @return deleted count 
	 */
	public Hotel createHotel(Hotel hotel) throws SQLException;
	
	/**
	 * 删除 酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotel(long id);
	
	
	/**
	 * 修改 酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateHotel(Hotel hotel);

		
	/**
	 * 修改 酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelIgnoreNull(Hotel hotel);
		
	
	/**
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店
	 * @param id
	 * @return
	 */
	public Hotel findHotel(long id);
	
	/**
	 * 查找 酒店 by language
	 * @param id
	 * @return
	 */
	public Hotel findHotelbylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotel(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelBySql(String sql);
	
}

