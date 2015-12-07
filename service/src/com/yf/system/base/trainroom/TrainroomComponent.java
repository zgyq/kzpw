/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainroom;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TrainroomComponent   implements ITrainroomComponent{ 
	
	
	private ITrainroomManager trainroomManager;
   
   
 	public ITrainroomManager getTrainroomManager() {
		return trainroomManager;
	}

	public void setTrainroomManager(ITrainroomManager trainroomManager) {
		this.trainroomManager = trainroomManager;
	}
  
 	/**
	 * 创建 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public Trainroom createTrainroom(Trainroom trainroom) throws SQLException{
	
		return trainroomManager.createTrainroom(trainroom);
	}
	/**
	 * 删除 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainroom(long id){
	
		return trainroomManager.deleteTrainroom(id);
	}
	
	
	/**
	 * 修改 火车售票点
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainroom(Trainroom trainroom){
		return trainroomManager.updateTrainroom(trainroom);
	
	}

		
	/**
	 * 修改 火车售票点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainroomIgnoreNull(Trainroom trainroom){
			return trainroomManager.updateTrainroomIgnoreNull(trainroom);
	
	}
	
	/**
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,int limit,int offset){
		return trainroomManager.findAllTrainroom(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车售票点
	 * @param id
	 * @return
	 */
	public Trainroom findTrainroom(long id){
		return trainroomManager.findTrainroom(id);
	}
	
	/** 
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,PageInfo pageinfo){
		return trainroomManager.findAllTrainroom(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车售票点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String sql,int limit,int offset){
		return trainroomManager.findAllTrainroom(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车售票点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainroomBySql(String sql){
		return trainroomManager.excuteTrainroomBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainroomBySql(String sql){
		return trainroomManager.countTrainroomBySql(sql);
	}
}

