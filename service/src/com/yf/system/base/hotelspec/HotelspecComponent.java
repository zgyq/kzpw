/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelspec;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelspecComponent   implements IHotelspecComponent{ 
	
	
	private IHotelspecManager hotelspecManager;
   
   
 	public IHotelspecManager getHotelspecManager() {
		return hotelspecManager;
	}

	public void setHotelspecManager(IHotelspecManager hotelspecManager) {
		this.hotelspecManager = hotelspecManager;
	}
  
 	/**
	 * 创建 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public Hotelspec createHotelspec(Hotelspec hotelspec) throws SQLException{
	
		return hotelspecManager.createHotelspec(hotelspec);
	}
	/**
	 * 删除 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelspec(long id){
	
		return hotelspecManager.deleteHotelspec(id);
	}
	
	
	/**
	 * 修改 酒店注意事项
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelspec(Hotelspec hotelspec){
		return hotelspecManager.updateHotelspec(hotelspec);
	
	}

		
	/**
	 * 修改 酒店注意事项但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelspecIgnoreNull(Hotelspec hotelspec){
			return hotelspecManager.updateHotelspecIgnoreNull(hotelspec);
	
	}
	
	/**
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspec(String where, String orderby,int limit,int offset){
		return hotelspecManager.findAllHotelspec(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店注意事项
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspec(long id){
		return hotelspecManager.findHotelspec(id);
	}
	/**
	 * 查找 酒店注意事项 by language
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspecbylanguage(long id,Integer language){
		return hotelspecManager.findHotelspecbylanguage(id,language);
	}
	/** 
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelspec(String where, String orderby,PageInfo pageinfo){
		return hotelspecManager.findAllHotelspec(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店注意事项
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspec(String sql,int limit,int offset){
		return hotelspecManager.findAllHotelspec(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店注意事项
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelspecBySql(String sql){
		return hotelspecManager.excuteHotelspecBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelspecBySql(String sql){
		return hotelspecManager.countHotelspecBySql(sql);
	}
}

