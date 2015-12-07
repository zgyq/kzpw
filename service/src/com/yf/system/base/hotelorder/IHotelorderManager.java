/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 */
 
package com.yf.system.base.hotelorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;


public interface IHotelorderManager{ 
	
  
 	/**
	 * 创建 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorder createHotelorder(Hotelorder hotelorder) throws SQLException;
	
	/**
	 * 删除 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorder(long id);
	
	
	/**
	 * 修改 酒店订单
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorder(Hotelorder hotelorder);

		
	/**
	 * 修改 酒店订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderIgnoreNull(Hotelorder hotelorder);
		
	
	/**
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店订单
	 * @param id
	 * @return
	 */
	public Hotelorder findHotelorder(long id);
	
	
	/** 
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderBySql(String sql);
	
}

