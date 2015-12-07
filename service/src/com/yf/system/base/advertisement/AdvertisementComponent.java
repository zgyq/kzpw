/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.advertisement;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AdvertisementComponent   implements IAdvertisementComponent{ 
	
	
	private IAdvertisementManager advertisementManager;
   
   
 	public IAdvertisementManager getAdvertisementManager() {
		return advertisementManager;
	}

	public void setAdvertisementManager(IAdvertisementManager advertisementManager) {
		this.advertisementManager = advertisementManager;
	}
  
 	/**
	 * 创建 广告表
	 * @param id
	 * @return deleted count 
	 */
	public Advertisement createAdvertisement(Advertisement advertisement) throws SQLException{
	
		return advertisementManager.createAdvertisement(advertisement);
	}
	/**
	 * 删除 广告表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdvertisement(long id){
	
		return advertisementManager.deleteAdvertisement(id);
	}
	
	
	/**
	 * 修改 广告表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdvertisement(Advertisement advertisement){
		return advertisementManager.updateAdvertisement(advertisement);
	
	}

		
	/**
	 * 修改 广告表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdvertisementIgnoreNull(Advertisement advertisement){
			return advertisementManager.updateAdvertisementIgnoreNull(advertisement);
	
	}
	
	/**
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisement(String where, String orderby,int limit,int offset){
		return advertisementManager.findAllAdvertisement(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 广告表
	 * @param id
	 * @return
	 */
	public Advertisement findAdvertisement(long id){
		return advertisementManager.findAdvertisement(id);
	}
	
	/** 
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdvertisement(String where, String orderby,PageInfo pageinfo){
		return advertisementManager.findAllAdvertisement(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找广告表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisement(String sql,int limit,int offset){
		return advertisementManager.findAllAdvertisement(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 广告表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdvertisementBySql(String sql){
		return advertisementManager.excuteAdvertisementBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdvertisementBySql(String sql){
		return advertisementManager.countAdvertisementBySql(sql);
	}
}

