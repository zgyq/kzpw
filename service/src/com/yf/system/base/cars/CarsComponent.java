/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cars;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarsComponent   implements ICarsComponent{ 
	
	
	private ICarsManager carsManager;
   
   
 	public ICarsManager getCarsManager() {
		return carsManager;
	}

	public void setCarsManager(ICarsManager carsManager) {
		this.carsManager = carsManager;
	}
  
 	/**
	 * 创建 汽车列表
	 * @param id
	 * @return deleted count 
	 */
	public Cars createCars(Cars cars) throws SQLException{
	
		return carsManager.createCars(cars);
	}
	/**
	 * 删除 汽车列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCars(long id){
	
		return carsManager.deleteCars(id);
	}
	
	
	/**
	 * 修改 汽车列表
	 * @param id
	 * @return updated count 
	 */
	public int updateCars(Cars cars){
		return carsManager.updateCars(cars);
	
	}

		
	/**
	 * 修改 汽车列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsIgnoreNull(Cars cars){
			return carsManager.updateCarsIgnoreNull(cars);
	
	}
	
	/**
	 * 查找 汽车列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCars(String where, String orderby,int limit,int offset){
		return carsManager.findAllCars(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 汽车列表
	 * @param id
	 * @return
	 */
	public Cars findCars(long id){
		return carsManager.findCars(id);
	}
	
	/** 
	 * 查找 汽车列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCars(String where, String orderby,PageInfo pageinfo){
		return carsManager.findAllCars(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找汽车列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCars(String sql,int limit,int offset){
		return carsManager.findAllCars(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 汽车列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsBySql(String sql){
		return carsManager.excuteCarsBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsBySql(String sql){
		return carsManager.countCarsBySql(sql);
	}
}

