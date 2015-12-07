/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.planeservice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PlaneserviceComponent   implements IPlaneserviceComponent{ 
	
	
	private IPlaneserviceManager planeserviceManager;
   
   
 	public IPlaneserviceManager getPlaneserviceManager() {
		return planeserviceManager;
	}

	public void setPlaneserviceManager(IPlaneserviceManager planeserviceManager) {
		this.planeserviceManager = planeserviceManager;
	}
  
 	/**
	 * 创建 包机服务
	 * @param id
	 * @return deleted count 
	 */
	public Planeservice createPlaneservice(Planeservice planeservice) throws SQLException{
	
		return planeserviceManager.createPlaneservice(planeservice);
	}
	/**
	 * 删除 包机服务
	 * @param id
	 * @return deleted count 
	 */
	public int deletePlaneservice(long id){
	
		return planeserviceManager.deletePlaneservice(id);
	}
	
	
	/**
	 * 修改 包机服务
	 * @param id
	 * @return updated count 
	 */
	public int updatePlaneservice(Planeservice planeservice){
		return planeserviceManager.updatePlaneservice(planeservice);
	
	}

		
	/**
	 * 修改 包机服务但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePlaneserviceIgnoreNull(Planeservice planeservice){
			return planeserviceManager.updatePlaneserviceIgnoreNull(planeservice);
	
	}
	
	/**
	 * 查找 包机服务
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPlaneservice(String where, String orderby,int limit,int offset){
		return planeserviceManager.findAllPlaneservice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 包机服务
	 * @param id
	 * @return
	 */
	public Planeservice findPlaneservice(long id){
		return planeserviceManager.findPlaneservice(id);
	}
	
	/** 
	 * 查找 包机服务
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPlaneservice(String where, String orderby,PageInfo pageinfo){
		return planeserviceManager.findAllPlaneservice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找包机服务
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPlaneservice(String sql,int limit,int offset){
		return planeserviceManager.findAllPlaneservice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 包机服务
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePlaneserviceBySql(String sql){
		return planeserviceManager.excutePlaneserviceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPlaneserviceBySql(String sql){
		return planeserviceManager.countPlaneserviceBySql(sql);
	}
}

