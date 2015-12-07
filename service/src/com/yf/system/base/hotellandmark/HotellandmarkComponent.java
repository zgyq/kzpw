/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotellandmark;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotellandmarkComponent   implements IHotellandmarkComponent{ 
	
	
	private IHotellandmarkManager hotellandmarkManager;
   
   
 	public IHotellandmarkManager getHotellandmarkManager() {
		return hotellandmarkManager;
	}

	public void setHotellandmarkManager(IHotellandmarkManager hotellandmarkManager) {
		this.hotellandmarkManager = hotellandmarkManager;
	}
  
 	/**
	 * 创建 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public Hotellandmark createHotellandmark(Hotellandmark hotellandmark) throws SQLException{
	
		return hotellandmarkManager.createHotellandmark(hotellandmark);
	}
	/**
	 * 删除 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellandmark(long id){
	
		return hotellandmarkManager.deleteHotellandmark(id);
	}
	
	
	/**
	 * 修改 酒店地标
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellandmark(Hotellandmark hotellandmark){
		return hotellandmarkManager.updateHotellandmark(hotellandmark);
	
	}

		
	/**
	 * 修改 酒店地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellandmarkIgnoreNull(Hotellandmark hotellandmark){
			return hotellandmarkManager.updateHotellandmarkIgnoreNull(hotellandmark);
	
	}
	
	/**
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,int limit,int offset){
		return hotellandmarkManager.findAllHotellandmark(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店地标
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmark(long id){
		return hotellandmarkManager.findHotellandmark(id);
	}
	/**
	 * 查找 酒店地标 by language
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmarkbylanguage(long id,Integer language){
		return hotellandmarkManager.findHotellandmarkbylanguage(id,language);
	}
	/** 
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,PageInfo pageinfo){
		return hotellandmarkManager.findAllHotellandmark(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String sql,int limit,int offset){
		return hotellandmarkManager.findAllHotellandmark(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellandmarkBySql(String sql){
		return hotellandmarkManager.excuteHotellandmarkBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellandmarkBySql(String sql){
		return hotellandmarkManager.countHotellandmarkBySql(sql);
	}
}

