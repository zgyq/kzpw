/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carstore;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarstoreComponent   implements ICarstoreComponent{ 
	
	
	private ICarstoreManager carstoreManager;
   
   
 	public ICarstoreManager getCarstoreManager() {
		return carstoreManager;
	}

	public void setCarstoreManager(ICarstoreManager carstoreManager) {
		this.carstoreManager = carstoreManager;
	}
  
 	/**
	 * 创建 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public Carstore createCarstore(Carstore carstore) throws SQLException{
	
		return carstoreManager.createCarstore(carstore);
	}
	/**
	 * 删除 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarstore(long id){
	
		return carstoreManager.deleteCarstore(id);
	}
	
	
	/**
	 * 修改 租车门店
	 * @param id
	 * @return updated count 
	 */
	public int updateCarstore(Carstore carstore){
		return carstoreManager.updateCarstore(carstore);
	
	}

		
	/**
	 * 修改 租车门店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarstoreIgnoreNull(Carstore carstore){
			return carstoreManager.updateCarstoreIgnoreNull(carstore);
	
	}
	
	/**
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,int limit,int offset){
		return carstoreManager.findAllCarstore(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 租车门店
	 * @param id
	 * @return
	 */
	public Carstore findCarstore(long id){
		return carstoreManager.findCarstore(id);
	}
	
	/** 
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,PageInfo pageinfo){
		return carstoreManager.findAllCarstore(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找租车门店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String sql,int limit,int offset){
		return carstoreManager.findAllCarstore(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 租车门店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarstoreBySql(String sql){
		return carstoreManager.excuteCarstoreBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarstoreBySql(String sql){
		return carstoreManager.countCarstoreBySql(sql);
	}
}

