/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelorderrc;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelorderrcManager{ 
	
  
 	/**
	 * 创建 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorderrc createHotelorderrc(Hotelorderrc hotelorderrc) throws SQLException;
	
	/**
	 * 删除 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorderrc(long id);
	
	
	/**
	 * 修改 酒店订单状态日志
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorderrc(Hotelorderrc hotelorderrc);

		
	/**
	 * 修改 酒店订单状态日志但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderrcIgnoreNull(Hotelorderrc hotelorderrc);
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrc(long id);
	
	/**
	 * 查找 酒店订单状态日志 by language
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrcbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店订单状态日志
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店订单状态日志
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderrcBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderrcBySql(String sql);
	
}

