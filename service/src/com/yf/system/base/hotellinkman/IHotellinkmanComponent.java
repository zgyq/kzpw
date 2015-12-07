/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotellinkman;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotellinkmanComponent{ 
	
  
 	/**
	 * 创建 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public Hotellinkman createHotellinkman(Hotellinkman hotellinkman) throws SQLException;
	
	/**
	 * 删除 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellinkman(long id);
	
	
	/**
	 * 修改 酒店联系人
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellinkman(Hotellinkman hotellinkman);

		
	/**
	 * 修改 酒店联系人但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellinkmanIgnoreNull(Hotellinkman hotellinkman);
		
	
	/**
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkman(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店联系人
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkman(long id);
	
	/**
	 * 查找 酒店联系人 by language
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkmanbylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellinkman(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店联系人
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkman(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店联系人
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellinkmanBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellinkmanBySql(String sql);
	
}

