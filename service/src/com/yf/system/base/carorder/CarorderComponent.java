/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carorder;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarorderComponent   implements ICarorderComponent{ 
	
	
	private ICarorderManager carorderManager;
   
   
 	public ICarorderManager getCarorderManager() {
		return carorderManager;
	}

	public void setCarorderManager(ICarorderManager carorderManager) {
		this.carorderManager = carorderManager;
	}
  
 	/**
	 * 创建 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public Carorder createCarorder(Carorder carorder) throws SQLException{
	
		return carorderManager.createCarorder(carorder);
	}
	/**
	 * 删除 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarorder(long id){
	
		return carorderManager.deleteCarorder(id);
	}
	
	
	/**
	 * 修改 租车订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCarorder(Carorder carorder){
		return carorderManager.updateCarorder(carorder);
	
	}

		
	/**
	 * 修改 租车订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarorderIgnoreNull(Carorder carorder){
			return carorderManager.updateCarorderIgnoreNull(carorder);
	
	}
	
	/**
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,int limit,int offset){
		return carorderManager.findAllCarorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 租车订单
	 * @param id
	 * @return
	 */
	public Carorder findCarorder(long id){
		return carorderManager.findCarorder(id);
	}
	
	/** 
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,PageInfo pageinfo){
		return carorderManager.findAllCarorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找租车订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String sql,int limit,int offset){
		return carorderManager.findAllCarorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 租车订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarorderBySql(String sql){
		return carorderManager.excuteCarorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarorderBySql(String sql){
		return carorderManager.countCarorderBySql(sql);
	}
}

