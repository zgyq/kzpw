/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.flightmodel;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FlightmodelComponent   implements IFlightmodelComponent{ 
	
	
	private IFlightmodelManager flightmodelManager;
   
   
 	public IFlightmodelManager getFlightmodelManager() {
		return flightmodelManager;
	}

	public void setFlightmodelManager(IFlightmodelManager flightmodelManager) {
		this.flightmodelManager = flightmodelManager;
	}
  
 	/**
	 * 创建 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public Flightmodel createFlightmodel(Flightmodel flightmodel) throws SQLException{
	
		return flightmodelManager.createFlightmodel(flightmodel);
	}
	/**
	 * 删除 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightmodel(long id){
	
		return flightmodelManager.deleteFlightmodel(id);
	}
	
	
	/**
	 * 修改 机型信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightmodel(Flightmodel flightmodel){
		return flightmodelManager.updateFlightmodel(flightmodel);
	
	}

		
	/**
	 * 修改 机型信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightmodelIgnoreNull(Flightmodel flightmodel){
			return flightmodelManager.updateFlightmodelIgnoreNull(flightmodel);
	
	}
	
	/**
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,int limit,int offset){
		return flightmodelManager.findAllFlightmodel(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机型信息表
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodel(long id){
		return flightmodelManager.findFlightmodel(id);
	}
	/**
	 * 查找 机型信息表 by language
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodelbylanguage(long id,Integer language){
		return flightmodelManager.findFlightmodelbylanguage(id,language);
	}
	/** 
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,PageInfo pageinfo){
		return flightmodelManager.findAllFlightmodel(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机型信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String sql,int limit,int offset){
		return flightmodelManager.findAllFlightmodel(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机型信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightmodelBySql(String sql){
		return flightmodelManager.excuteFlightmodelBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightmodelBySql(String sql){
		return flightmodelManager.countFlightmodelBySql(sql);
	}
}

