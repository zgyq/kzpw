/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelprice;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelpriceManager{ 
	
  
 	/**
	 * 创建 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public Hotelprice createHotelprice(Hotelprice hotelprice) throws SQLException;
	
	/**
	 * 删除 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelprice(long id);
	
	
	/**
	 * 修改 酒店价格
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelprice(Hotelprice hotelprice);

		
	/**
	 * 修改 酒店价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpriceIgnoreNull(Hotelprice hotelprice);
		
	
	/**
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店价格
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelprice(long id);
	
	/**
	 * 查找 酒店价格 by language
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelpricebylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelprice(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelprice(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpriceBySql(String sql);
	
}

