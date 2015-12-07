/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainstation;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TrainstationComponent   implements ITrainstationComponent{ 
	
	
	private ITrainstationManager trainstationManager;
   
   
 	public ITrainstationManager getTrainstationManager() {
		return trainstationManager;
	}

	public void setTrainstationManager(ITrainstationManager trainstationManager) {
		this.trainstationManager = trainstationManager;
	}
  
 	/**
	 * 创建 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public Trainstation createTrainstation(Trainstation trainstation) throws SQLException{
	
		return trainstationManager.createTrainstation(trainstation);
	}
	/**
	 * 删除 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainstation(long id){
	
		return trainstationManager.deleteTrainstation(id);
	}
	
	
	/**
	 * 修改 火车站信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainstation(Trainstation trainstation){
		return trainstationManager.updateTrainstation(trainstation);
	
	}

		
	/**
	 * 修改 火车站信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainstationIgnoreNull(Trainstation trainstation){
			return trainstationManager.updateTrainstationIgnoreNull(trainstation);
	
	}
	
	/**
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,int limit,int offset){
		return trainstationManager.findAllTrainstation(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车站信息
	 * @param id
	 * @return
	 */
	public Trainstation findTrainstation(long id){
		return trainstationManager.findTrainstation(id);
	}
	
	/** 
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,PageInfo pageinfo){
		return trainstationManager.findAllTrainstation(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车站信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String sql,int limit,int offset){
		return trainstationManager.findAllTrainstation(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车站信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainstationBySql(String sql){
		return trainstationManager.excuteTrainstationBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainstationBySql(String sql){
		return trainstationManager.countTrainstationBySql(sql);
	}
}

