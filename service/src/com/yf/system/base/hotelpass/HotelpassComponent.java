/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelpass;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelpassComponent   implements IHotelpassComponent{ 
	
	
	private IHotelpassManager hotelpassManager;
   
   
 	public IHotelpassManager getHotelpassManager() {
		return hotelpassManager;
	}

	public void setHotelpassManager(IHotelpassManager hotelpassManager) {
		this.hotelpassManager = hotelpassManager;
	}
  
 	/**
	 * 创建 酒店常用入住人表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelpass createHotelpass(Hotelpass hotelpass) throws SQLException{
	
		return hotelpassManager.createHotelpass(hotelpass);
	}
	/**
	 * 删除 酒店常用入住人表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelpass(long id){
	
		return hotelpassManager.deleteHotelpass(id);
	}
	
	
	/**
	 * 修改 酒店常用入住人表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelpass(Hotelpass hotelpass){
		return hotelpassManager.updateHotelpass(hotelpass);
	
	}

		
	/**
	 * 修改 酒店常用入住人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpassIgnoreNull(Hotelpass hotelpass){
			return hotelpassManager.updateHotelpassIgnoreNull(hotelpass);
	
	}
	
	/**
	 * 查找 酒店常用入住人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpass(String where, String orderby,int limit,int offset){
		return hotelpassManager.findAllHotelpass(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店常用入住人表
	 * @param id
	 * @return
	 */
	public Hotelpass findHotelpass(long id){
		return hotelpassManager.findHotelpass(id);
	}
	
	/** 
	 * 查找 酒店常用入住人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelpass(String where, String orderby,PageInfo pageinfo){
		return hotelpassManager.findAllHotelpass(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店常用入住人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpass(String sql,int limit,int offset){
		return hotelpassManager.findAllHotelpass(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店常用入住人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpassBySql(String sql){
		return hotelpassManager.excuteHotelpassBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpassBySql(String sql){
		return hotelpassManager.countHotelpassBySql(sql);
	}
}

