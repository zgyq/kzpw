/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.passenger;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PassengerComponent   implements IPassengerComponent{ 
	
	
	private IPassengerManager passengerManager;
   
   
 	public IPassengerManager getPassengerManager() {
		return passengerManager;
	}

	public void setPassengerManager(IPassengerManager passengerManager) {
		this.passengerManager = passengerManager;
	}
  
 	/**
	 * 创建 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Passenger createPassenger(Passenger passenger) throws SQLException{
	
		return passengerManager.createPassenger(passenger);
	}
	/**
	 * 删除 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassenger(long id){
	
		return passengerManager.deletePassenger(id);
	}
	
	
	/**
	 * 修改 乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updatePassenger(Passenger passenger){
		return passengerManager.updatePassenger(passenger);
	
	}

		
	/**
	 * 修改 乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerIgnoreNull(Passenger passenger){
			return passengerManager.updatePassengerIgnoreNull(passenger);
	
	}
	
	/**
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,int limit,int offset){
		return passengerManager.findAllPassenger(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 乘机人表
	 * @param id
	 * @return
	 */
	public Passenger findPassenger(long id){
		return passengerManager.findPassenger(id);
	}
	/**
	 * 查找 乘机人表 by language
	 * @param id
	 * @return
	 */
	public Passenger findPassengerbylanguage(long id,Integer language){
		return passengerManager.findPassengerbylanguage(id,language);
	}
	/** 
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,PageInfo pageinfo){
		return passengerManager.findAllPassenger(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String sql,int limit,int offset){
		return passengerManager.findAllPassenger(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerBySql(String sql){
		return passengerManager.excutePassengerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerBySql(String sql){
		return passengerManager.countPassengerBySql(sql);
	}
}

