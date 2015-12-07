/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelstart;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelstartManager{ 
	
  
 	/**
	 * 创建 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstart createHotelstart(Hotelstart hotelstart) throws SQLException;
	
	/**
	 * 删除 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstart(long id);
	
	
	/**
	 * 修改 酒店星级返利
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstart(Hotelstart hotelstart);

		
	/**
	 * 修改 酒店星级返利但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstartIgnoreNull(Hotelstart hotelstart);
		
	
	/**
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店星级返利
	 * @param id
	 * @return
	 */
	public Hotelstart findHotelstart(long id);
	
	
	/** 
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店星级返利
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店星级返利
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstartBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstartBySql(String sql);
	
}

