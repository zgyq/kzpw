/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelorderrc;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelorderrcComponent   implements IHotelorderrcComponent{ 
	
	
	private IHotelorderrcManager hotelorderrcManager;
   
   
 	public IHotelorderrcManager getHotelorderrcManager() {
		return hotelorderrcManager;
	}

	public void setHotelorderrcManager(IHotelorderrcManager hotelorderrcManager) {
		this.hotelorderrcManager = hotelorderrcManager;
	}
  
 	/**
	 * 创建 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorderrc createHotelorderrc(Hotelorderrc hotelorderrc) throws SQLException{
	
		return hotelorderrcManager.createHotelorderrc(hotelorderrc);
	}
	/**
	 * 删除 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorderrc(long id){
	
		return hotelorderrcManager.deleteHotelorderrc(id);
	}
	
	
	/**
	 * 修改 酒店订单状态日志
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorderrc(Hotelorderrc hotelorderrc){
		return hotelorderrcManager.updateHotelorderrc(hotelorderrc);
	
	}

		
	/**
	 * 修改 酒店订单状态日志但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderrcIgnoreNull(Hotelorderrc hotelorderrc){
			return hotelorderrcManager.updateHotelorderrcIgnoreNull(hotelorderrc);
	
	}
	
	/**
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,int limit,int offset){
		return hotelorderrcManager.findAllHotelorderrc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrc(long id){
		return hotelorderrcManager.findHotelorderrc(id);
	}
	/**
	 * 查找 酒店订单状态日志 by language
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrcbylanguage(long id,Integer language){
		return hotelorderrcManager.findHotelorderrcbylanguage(id,language);
	}
	/** 
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,PageInfo pageinfo){
		return hotelorderrcManager.findAllHotelorderrc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店订单状态日志
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String sql,int limit,int offset){
		return hotelorderrcManager.findAllHotelorderrc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店订单状态日志
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderrcBySql(String sql){
		return hotelorderrcManager.excuteHotelorderrcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderrcBySql(String sql){
		return hotelorderrcManager.countHotelorderrcBySql(sql);
	}
}

