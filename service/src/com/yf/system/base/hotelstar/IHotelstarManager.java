/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelstar;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelstarManager{ 
	
  
 	/**
	 * 创建 酒店星级返点对应表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstar createHotelstar(Hotelstar hotelstar) throws SQLException;
	
	/**
	 * 删除 酒店星级返点对应表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstar(long id);
	
	
	/**
	 * 修改 酒店星级返点对应表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstar(Hotelstar hotelstar);

		
	/**
	 * 修改 酒店星级返点对应表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstarIgnoreNull(Hotelstar hotelstar);
		
	
	/**
	 * 查找 酒店星级返点对应表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstar(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店星级返点对应表
	 * @param id
	 * @return
	 */
	public Hotelstar findHotelstar(long id);
	
	
	/** 
	 * 查找 酒店星级返点对应表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstar(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店星级返点对应表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstar(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店星级返点对应表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstarBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstarBySql(String sql);
	
}

