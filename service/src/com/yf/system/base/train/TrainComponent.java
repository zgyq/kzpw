/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.train;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.util.PageInfo;

public class TrainComponent   implements ITrainComponent{ 
	
	
	private ITrainManager trainManager;
   
   
 	public ITrainManager getTrainManager() {
		return trainManager;
	}

	public void setTrainManager(ITrainManager trainManager) {
		this.trainManager = trainManager;
	}
  
 	/**
	 * 创建 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public Train createTrain(Train train) throws SQLException{
	
		return trainManager.createTrain(train);
	}
	/**
	 * 删除 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrain(long id){
	
		return trainManager.deleteTrain(id);
	}
	
	
	/**
	 * 修改 火车时刻表
	 * @param id
	 * @return updated count 
	 */
	public int updateTrain(Train train){
		return trainManager.updateTrain(train);
	
	}

		
	/**
	 * 修改 火车时刻表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainIgnoreNull(Train train){
			return trainManager.updateTrainIgnoreNull(train);
	
	}
	
	/**
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrain(String where, String orderby,int limit,int offset){
		return trainManager.findAllTrain(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车时刻表
	 * @param id
	 * @return
	 */
	public Train findTrain(long id){
		return trainManager.findTrain(id);
	}
	
	/** 
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrain(String where, String orderby,PageInfo pageinfo){
		return trainManager.findAllTrain(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车时刻表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrain(String sql,int limit,int offset){
		return trainManager.findAllTrain(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车时刻表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainBySql(String sql){
		return trainManager.excuteTrainBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainBySql(String sql){
		return trainManager.countTrainBySql(sql);
	}
}

