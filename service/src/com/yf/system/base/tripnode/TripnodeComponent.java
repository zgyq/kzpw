/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tripnode;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TripnodeComponent   implements ITripnodeComponent{ 
	
	
	private ITripnodeManager tripnodeManager;
   
   
 	public ITripnodeManager getTripnodeManager() {
		return tripnodeManager;
	}

	public void setTripnodeManager(ITripnodeManager tripnodeManager) {
		this.tripnodeManager = tripnodeManager;
	}
  
 	/**
	 * 创建 注意事项
	 * @param id
	 * @return deleted count 
	 */
	public Tripnode createTripnode(Tripnode tripnode) throws SQLException{
	
		return tripnodeManager.createTripnode(tripnode);
	}
	/**
	 * 删除 注意事项
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTripnode(long id){
	
		return tripnodeManager.deleteTripnode(id);
	}
	
	
	/**
	 * 修改 注意事项
	 * @param id
	 * @return updated count 
	 */
	public int updateTripnode(Tripnode tripnode){
		return tripnodeManager.updateTripnode(tripnode);
	
	}

		
	/**
	 * 修改 注意事项但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTripnodeIgnoreNull(Tripnode tripnode){
			return tripnodeManager.updateTripnodeIgnoreNull(tripnode);
	
	}
	
	/**
	 * 查找 注意事项
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnode(String where, String orderby,int limit,int offset){
		return tripnodeManager.findAllTripnode(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 注意事项
	 * @param id
	 * @return
	 */
	public Tripnode findTripnode(long id){
		return tripnodeManager.findTripnode(id);
	}
	/**
	 * 查找 注意事项 by language
	 * @param id
	 * @return
	 */
	public Tripnode findTripnodebylanguage(long id,Integer language){
		return tripnodeManager.findTripnodebylanguage(id,language);
	}
	/** 
	 * 查找 注意事项
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripnode(String where, String orderby,PageInfo pageinfo){
		return tripnodeManager.findAllTripnode(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找注意事项
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnode(String sql,int limit,int offset){
		return tripnodeManager.findAllTripnode(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 注意事项
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTripnodeBySql(String sql){
		return tripnodeManager.excuteTripnodeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTripnodeBySql(String sql){
		return tripnodeManager.countTripnodeBySql(sql);
	}
}

