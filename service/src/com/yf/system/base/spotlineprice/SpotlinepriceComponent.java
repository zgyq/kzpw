/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineprice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpotlinepriceComponent   implements ISpotlinepriceComponent{ 
	
	
	private ISpotlinepriceManager spotlinepriceManager;
   
   
 	public ISpotlinepriceManager getSpotlinepriceManager() {
		return spotlinepriceManager;
	}

	public void setSpotlinepriceManager(ISpotlinepriceManager spotlinepriceManager) {
		this.spotlinepriceManager = spotlinepriceManager;
	}
  
 	/**
	 * 创建 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineprice createSpotlineprice(Spotlineprice spotlineprice) throws SQLException{
	
		return spotlinepriceManager.createSpotlineprice(spotlineprice);
	}
	/**
	 * 删除 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineprice(long id){
	
		return spotlinepriceManager.deleteSpotlineprice(id);
	}
	
	
	/**
	 * 修改 景区线路价格信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineprice(Spotlineprice spotlineprice){
		return spotlinepriceManager.updateSpotlineprice(spotlineprice);
	
	}

		
	/**
	 * 修改 景区线路价格信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlinepriceIgnoreNull(Spotlineprice spotlineprice){
			return spotlinepriceManager.updateSpotlinepriceIgnoreNull(spotlineprice);
	
	}
	
	/**
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,int limit,int offset){
		return spotlinepriceManager.findAllSpotlineprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路价格信息
	 * @param id
	 * @return
	 */
	public Spotlineprice findSpotlineprice(long id){
		return spotlinepriceManager.findSpotlineprice(id);
	}
	
	/** 
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,PageInfo pageinfo){
		return spotlinepriceManager.findAllSpotlineprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路价格信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String sql,int limit,int offset){
		return spotlinepriceManager.findAllSpotlineprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路价格信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlinepriceBySql(String sql){
		return spotlinepriceManager.excuteSpotlinepriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlinepriceBySql(String sql){
		return spotlinepriceManager.countSpotlinepriceBySql(sql);
	}
}

