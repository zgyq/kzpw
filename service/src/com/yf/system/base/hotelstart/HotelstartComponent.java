/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelstart;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelstartComponent   implements IHotelstartComponent{ 
	
	
	private IHotelstartManager hotelstartManager;
   
   
 	public IHotelstartManager getHotelstartManager() {
		return hotelstartManager;
	}

	public void setHotelstartManager(IHotelstartManager hotelstartManager) {
		this.hotelstartManager = hotelstartManager;
	}
  
 	/**
	 * 创建 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstart createHotelstart(Hotelstart hotelstart) throws SQLException{
	
		return hotelstartManager.createHotelstart(hotelstart);
	}
	/**
	 * 删除 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstart(long id){
	
		return hotelstartManager.deleteHotelstart(id);
	}
	
	
	/**
	 * 修改 酒店星级返利
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstart(Hotelstart hotelstart){
		return hotelstartManager.updateHotelstart(hotelstart);
	
	}

		
	/**
	 * 修改 酒店星级返利但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstartIgnoreNull(Hotelstart hotelstart){
			return hotelstartManager.updateHotelstartIgnoreNull(hotelstart);
	
	}
	
	/**
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,int limit,int offset){
		return hotelstartManager.findAllHotelstart(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店星级返利
	 * @param id
	 * @return
	 */
	public Hotelstart findHotelstart(long id){
		return hotelstartManager.findHotelstart(id);
	}
	
	/** 
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,PageInfo pageinfo){
		return hotelstartManager.findAllHotelstart(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店星级返利
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String sql,int limit,int offset){
		return hotelstartManager.findAllHotelstart(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店星级返利
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstartBySql(String sql){
		return hotelstartManager.excuteHotelstartBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstartBySql(String sql){
		return hotelstartManager.countHotelstartBySql(sql);
	}
}

