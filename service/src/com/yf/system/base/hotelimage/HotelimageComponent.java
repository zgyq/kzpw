/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelimage;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelimageComponent   implements IHotelimageComponent{ 
	
	
	private IHotelimageManager hotelimageManager;
   
   
 	public IHotelimageManager getHotelimageManager() {
		return hotelimageManager;
	}

	public void setHotelimageManager(IHotelimageManager hotelimageManager) {
		this.hotelimageManager = hotelimageManager;
	}
  
 	/**
	 * 创建 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public Hotelimage createHotelimage(Hotelimage hotelimage) throws SQLException{
	
		return hotelimageManager.createHotelimage(hotelimage);
	}
	/**
	 * 删除 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelimage(long id){
	
		return hotelimageManager.deleteHotelimage(id);
	}
	
	
	/**
	 * 修改 酒店图片
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelimage(Hotelimage hotelimage){
		return hotelimageManager.updateHotelimage(hotelimage);
	
	}

		
	/**
	 * 修改 酒店图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelimageIgnoreNull(Hotelimage hotelimage){
			return hotelimageManager.updateHotelimageIgnoreNull(hotelimage);
	
	}
	
	/**
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimage(String where, String orderby,int limit,int offset){
		return hotelimageManager.findAllHotelimage(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店图片
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimage(long id){
		return hotelimageManager.findHotelimage(id);
	}
	/**
	 * 查找 酒店图片 by language
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimagebylanguage(long id,Integer language){
		return hotelimageManager.findHotelimagebylanguage(id,language);
	}
	/** 
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelimage(String where, String orderby,PageInfo pageinfo){
		return hotelimageManager.findAllHotelimage(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimage(String sql,int limit,int offset){
		return hotelimageManager.findAllHotelimage(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelimageBySql(String sql){
		return hotelimageManager.excuteHotelimageBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelimageBySql(String sql){
		return hotelimageManager.countHotelimageBySql(sql);
	}
}

