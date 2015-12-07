/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainpassenger;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TrainpassengerComponent   implements ITrainpassengerComponent{ 
	
	
	private ITrainpassengerManager trainpassengerManager;
   
   
 	public ITrainpassengerManager getTrainpassengerManager() {
		return trainpassengerManager;
	}

	public void setTrainpassengerManager(ITrainpassengerManager trainpassengerManager) {
		this.trainpassengerManager = trainpassengerManager;
	}
  
 	/**
	 * 创建 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public Trainpassenger createTrainpassenger(Trainpassenger trainpassenger) throws SQLException{
	
		return trainpassengerManager.createTrainpassenger(trainpassenger);
	}
	/**
	 * 删除 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainpassenger(long id){
	
		return trainpassengerManager.deleteTrainpassenger(id);
	}
	
	
	/**
	 * 修改 火车票乘客
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainpassenger(Trainpassenger trainpassenger){
		return trainpassengerManager.updateTrainpassenger(trainpassenger);
	
	}

		
	/**
	 * 修改 火车票乘客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainpassengerIgnoreNull(Trainpassenger trainpassenger){
			return trainpassengerManager.updateTrainpassengerIgnoreNull(trainpassenger);
	
	}
	
	/**
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassenger(String where, String orderby,int limit,int offset){
		return trainpassengerManager.findAllTrainpassenger(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车票乘客
	 * @param id
	 * @return
	 */
	public Trainpassenger findTrainpassenger(long id){
		return trainpassengerManager.findTrainpassenger(id);
	}
	
	/** 
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainpassenger(String where, String orderby,PageInfo pageinfo){
		return trainpassengerManager.findAllTrainpassenger(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车票乘客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassenger(String sql,int limit,int offset){
		return trainpassengerManager.findAllTrainpassenger(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车票乘客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainpassengerBySql(String sql){
		return trainpassengerManager.excuteTrainpassengerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainpassengerBySql(String sql){
		return trainpassengerManager.countTrainpassengerBySql(sql);
	}
}

