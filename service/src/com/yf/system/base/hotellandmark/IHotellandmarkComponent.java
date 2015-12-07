/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotellandmark;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotellandmarkComponent{ 
	
  
 	/**
	 * 创建 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public Hotellandmark createHotellandmark(Hotellandmark hotellandmark) throws SQLException;
	
	/**
	 * 删除 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellandmark(long id);
	
	
	/**
	 * 修改 酒店地标
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellandmark(Hotellandmark hotellandmark);

		
	/**
	 * 修改 酒店地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellandmarkIgnoreNull(Hotellandmark hotellandmark);
		
	
	/**
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店地标
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmark(long id);
	
	/**
	 * 查找 酒店地标 by language
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmarkbylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellandmarkBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellandmarkBySql(String sql);
	
}

