/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotel;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelComponent   implements IHotelComponent{ 
	
	
	private IHotelManager hotelManager;
   
   
 	public IHotelManager getHotelManager() {
		return hotelManager;
	}

	public void setHotelManager(IHotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}
  
 	/**
	 * 创建 酒店
	 * @param id
	 * @return deleted count 
	 */
	public Hotel createHotel(Hotel hotel) throws SQLException{
	
		return hotelManager.createHotel(hotel);
	}
	/**
	 * 删除 酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotel(long id){
	
		return hotelManager.deleteHotel(id);
	}
	
	
	/**
	 * 修改 酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateHotel(Hotel hotel){
		return hotelManager.updateHotel(hotel);
	
	}

		
	/**
	 * 修改 酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelIgnoreNull(Hotel hotel){
			return hotelManager.updateHotelIgnoreNull(hotel);
	
	}
	
	/**
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String where, String orderby,int limit,int offset){
		return hotelManager.findAllHotel(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店
	 * @param id
	 * @return
	 */
	public Hotel findHotel(long id){
		return hotelManager.findHotel(id);
	}
	/**
	 * 查找 酒店 by language
	 * @param id
	 * @return
	 */
	public Hotel findHotelbylanguage(long id,Integer language){
		return hotelManager.findHotelbylanguage(id,language);
	}
	/** 
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotel(String where, String orderby,PageInfo pageinfo){
		return hotelManager.findAllHotel(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String sql,int limit,int offset){
		return hotelManager.findAllHotel(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelBySql(String sql){
		return hotelManager.excuteHotelBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelBySql(String sql){
		return hotelManager.countHotelBySql(sql);
	}
}

