/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triplinetype;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriplinetypeComponent   implements ITriplinetypeComponent{ 
	
	
	private ITriplinetypeManager triplinetypeManager;
   
   
 	public ITriplinetypeManager getTriplinetypeManager() {
		return triplinetypeManager;
	}

	public void setTriplinetypeManager(ITriplinetypeManager triplinetypeManager) {
		this.triplinetypeManager = triplinetypeManager;
	}
  
 	/**
	 * 创建 旅游线路类型表
	 * @param id
	 * @return deleted count 
	 */
	public Triplinetype createTriplinetype(Triplinetype triplinetype) throws SQLException{
	
		return triplinetypeManager.createTriplinetype(triplinetype);
	}
	/**
	 * 删除 旅游线路类型表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriplinetype(long id){
	
		return triplinetypeManager.deleteTriplinetype(id);
	}
	
	
	/**
	 * 修改 旅游线路类型表
	 * @param id
	 * @return updated count 
	 */
	public int updateTriplinetype(Triplinetype triplinetype){
		return triplinetypeManager.updateTriplinetype(triplinetype);
	
	}

		
	/**
	 * 修改 旅游线路类型表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplinetypeIgnoreNull(Triplinetype triplinetype){
			return triplinetypeManager.updateTriplinetypeIgnoreNull(triplinetype);
	
	}
	
	/**
	 * 查找 旅游线路类型表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetype(String where, String orderby,int limit,int offset){
		return triplinetypeManager.findAllTriplinetype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 旅游线路类型表
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetype(long id){
		return triplinetypeManager.findTriplinetype(id);
	}
	/**
	 * 查找 旅游线路类型表 by language
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetypebylanguage(long id,Integer language){
		return triplinetypeManager.findTriplinetypebylanguage(id,language);
	}
	/** 
	 * 查找 旅游线路类型表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinetype(String where, String orderby,PageInfo pageinfo){
		return triplinetypeManager.findAllTriplinetype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找旅游线路类型表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetype(String sql,int limit,int offset){
		return triplinetypeManager.findAllTriplinetype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 旅游线路类型表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplinetypeBySql(String sql){
		return triplinetypeManager.excuteTriplinetypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplinetypeBySql(String sql){
		return triplinetypeManager.countTriplinetypeBySql(sql);
	}
}

