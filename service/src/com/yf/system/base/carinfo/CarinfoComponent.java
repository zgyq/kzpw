/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarinfoComponent   implements ICarinfoComponent{ 
	
	
	private ICarinfoManager carinfoManager;
   
   
 	public ICarinfoManager getCarinfoManager() {
		return carinfoManager;
	}

	public void setCarinfoManager(ICarinfoManager carinfoManager) {
		this.carinfoManager = carinfoManager;
	}
  
 	/**
	 * 创建 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public Carinfo createCarinfo(Carinfo carinfo) throws SQLException{
	
		return carinfoManager.createCarinfo(carinfo);
	}
	/**
	 * 删除 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarinfo(long id){
	
		return carinfoManager.deleteCarinfo(id);
	}
	
	
	/**
	 * 修改 车型数据
	 * @param id
	 * @return updated count 
	 */
	public int updateCarinfo(Carinfo carinfo){
		return carinfoManager.updateCarinfo(carinfo);
	
	}

		
	/**
	 * 修改 车型数据但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarinfoIgnoreNull(Carinfo carinfo){
			return carinfoManager.updateCarinfoIgnoreNull(carinfo);
	
	}
	
	/**
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,int limit,int offset){
		return carinfoManager.findAllCarinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 车型数据
	 * @param id
	 * @return
	 */
	public Carinfo findCarinfo(long id){
		return carinfoManager.findCarinfo(id);
	}
	
	/** 
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,PageInfo pageinfo){
		return carinfoManager.findAllCarinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找车型数据
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String sql,int limit,int offset){
		return carinfoManager.findAllCarinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 车型数据
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarinfoBySql(String sql){
		return carinfoManager.excuteCarinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarinfoBySql(String sql){
		return carinfoManager.countCarinfoBySql(sql);
	}
}

