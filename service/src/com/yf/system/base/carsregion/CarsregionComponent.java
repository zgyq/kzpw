/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carsregion;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarsregionComponent   implements ICarsregionComponent{ 
	
	
	private ICarsregionManager carsregionManager;
   
   
 	public ICarsregionManager getCarsregionManager() {
		return carsregionManager;
	}

	public void setCarsregionManager(ICarsregionManager carsregionManager) {
		this.carsregionManager = carsregionManager;
	}
  
 	/**
	 * 创建 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public Carsregion createCarsregion(Carsregion carsregion) throws SQLException{
	
		return carsregionManager.createCarsregion(carsregion);
	}
	/**
	 * 删除 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarsregion(long id){
	
		return carsregionManager.deleteCarsregion(id);
	}
	
	
	/**
	 * 修改 送车上门区域
	 * @param id
	 * @return updated count 
	 */
	public int updateCarsregion(Carsregion carsregion){
		return carsregionManager.updateCarsregion(carsregion);
	
	}

		
	/**
	 * 修改 送车上门区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsregionIgnoreNull(Carsregion carsregion){
			return carsregionManager.updateCarsregionIgnoreNull(carsregion);
	
	}
	
	/**
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,int limit,int offset){
		return carsregionManager.findAllCarsregion(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 送车上门区域
	 * @param id
	 * @return
	 */
	public Carsregion findCarsregion(long id){
		return carsregionManager.findCarsregion(id);
	}
	
	/** 
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,PageInfo pageinfo){
		return carsregionManager.findAllCarsregion(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找送车上门区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String sql,int limit,int offset){
		return carsregionManager.findAllCarsregion(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 送车上门区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsregionBySql(String sql){
		return carsregionManager.excuteCarsregionBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsregionBySql(String sql){
		return carsregionManager.countCarsregionBySql(sql);
	}
}

