/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainfare;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TrainfareComponent   implements ITrainfareComponent{ 
	
	
	private ITrainfareManager trainfareManager;
   
   
 	public ITrainfareManager getTrainfareManager() {
		return trainfareManager;
	}

	public void setTrainfareManager(ITrainfareManager trainfareManager) {
		this.trainfareManager = trainfareManager;
	}
  
 	/**
	 * 创建 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public Trainfare createTrainfare(Trainfare trainfare) throws SQLException{
	
		return trainfareManager.createTrainfare(trainfare);
	}
	/**
	 * 删除 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainfare(long id){
	
		return trainfareManager.deleteTrainfare(id);
	}
	
	
	/**
	 * 修改 火车票价
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainfare(Trainfare trainfare){
		return trainfareManager.updateTrainfare(trainfare);
	
	}

		
	/**
	 * 修改 火车票价但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainfareIgnoreNull(Trainfare trainfare){
			return trainfareManager.updateTrainfareIgnoreNull(trainfare);
	
	}
	
	/**
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,int limit,int offset){
		return trainfareManager.findAllTrainfare(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车票价
	 * @param id
	 * @return
	 */
	public Trainfare findTrainfare(long id){
		return trainfareManager.findTrainfare(id);
	}
	
	/** 
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,PageInfo pageinfo){
		return trainfareManager.findAllTrainfare(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车票价
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String sql,int limit,int offset){
		return trainfareManager.findAllTrainfare(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车票价
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainfareBySql(String sql){
		return trainfareManager.excuteTrainfareBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainfareBySql(String sql){
		return trainfareManager.countTrainfareBySql(sql);
	}
}

