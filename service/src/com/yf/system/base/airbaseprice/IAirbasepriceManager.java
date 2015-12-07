/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airbaseprice;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAirbasepriceManager{ 
	
  
 	/**
	 * 创建 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public Airbaseprice createAirbaseprice(Airbaseprice airbaseprice) throws SQLException;
	
	/**
	 * 删除 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirbaseprice(long id);
	
	
	/**
	 * 修改 机票基础价格表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirbaseprice(Airbaseprice airbaseprice);

		
	/**
	 * 修改 机票基础价格表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirbasepriceIgnoreNull(Airbaseprice airbaseprice);
		
	
	/**
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 机票基础价格表
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbaseprice(long id);
	
	/**
	 * 查找 机票基础价格表 by language
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbasepricebylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找机票基础价格表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 机票基础价格表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirbasepriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirbasepriceBySql(String sql);
	
}

