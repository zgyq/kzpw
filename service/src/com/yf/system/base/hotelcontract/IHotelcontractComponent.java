/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelcontract;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHotelcontractComponent{ 
	
  
 	/**
	 * 创建 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public Hotelcontract createHotelcontract(Hotelcontract hotelcontract) throws SQLException;
	
	/**
	 * 删除 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelcontract(long id);
	
	
	/**
	 * 修改 酒店合同
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelcontract(Hotelcontract hotelcontract);

		
	/**
	 * 修改 酒店合同但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelcontractIgnoreNull(Hotelcontract hotelcontract);
		
	
	/**
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店合同
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontract(long id);
	
	/**
	 * 查找 酒店合同 by language
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontractbylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店合同
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店合同
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelcontractBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelcontractBySql(String sql);
	
}

