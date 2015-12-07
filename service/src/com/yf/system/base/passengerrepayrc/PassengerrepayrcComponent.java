/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.passengerrepayrc;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PassengerrepayrcComponent   implements IPassengerrepayrcComponent{ 
	
	
	private IPassengerrepayrcManager passengerrepayrcManager;
   
   
 	public IPassengerrepayrcManager getPassengerrepayrcManager() {
		return passengerrepayrcManager;
	}

	public void setPassengerrepayrcManager(IPassengerrepayrcManager passengerrepayrcManager) {
		this.passengerrepayrcManager = passengerrepayrcManager;
	}
  
 	/**
	 * 创建 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public Passengerrepayrc createPassengerrepayrc(Passengerrepayrc passengerrepayrc) throws SQLException{
	
		return passengerrepayrcManager.createPassengerrepayrc(passengerrepayrc);
	}
	/**
	 * 删除 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassengerrepayrc(long id){
	
		return passengerrepayrcManager.deletePassengerrepayrc(id);
	}
	
	
	/**
	 * 修改 机票还款记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePassengerrepayrc(Passengerrepayrc passengerrepayrc){
		return passengerrepayrcManager.updatePassengerrepayrc(passengerrepayrc);
	
	}

		
	/**
	 * 修改 机票还款记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerrepayrcIgnoreNull(Passengerrepayrc passengerrepayrc){
			return passengerrepayrcManager.updatePassengerrepayrcIgnoreNull(passengerrepayrc);
	
	}
	
	/**
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,int limit,int offset){
		return passengerrepayrcManager.findAllPassengerrepayrc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票还款记录
	 * @param id
	 * @return
	 */
	public Passengerrepayrc findPassengerrepayrc(long id){
		return passengerrepayrcManager.findPassengerrepayrc(id);
	}
	
	/** 
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,PageInfo pageinfo){
		return passengerrepayrcManager.findAllPassengerrepayrc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票还款记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String sql,int limit,int offset){
		return passengerrepayrcManager.findAllPassengerrepayrc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票还款记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerrepayrcBySql(String sql){
		return passengerrepayrcManager.excutePassengerrepayrcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerrepayrcBySql(String sql){
		return passengerrepayrcManager.countPassengerrepayrcBySql(sql);
	}
}

