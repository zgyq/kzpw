/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fcity;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FcityComponent   implements IFcityComponent{ 
	
	
	private IFcityManager fcityManager;
   
   
 	public IFcityManager getFcityManager() {
		return fcityManager;
	}

	public void setFcityManager(IFcityManager fcityManager) {
		this.fcityManager = fcityManager;
	}
  
 	/**
	 * 创建 国际机票城市
	 * @param id
	 * @return deleted count 
	 */
	public Fcity createFcity(Fcity fcity) throws SQLException{
	
		return fcityManager.createFcity(fcity);
	}
	/**
	 * 删除 国际机票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcity(long id){
	
		return fcityManager.deleteFcity(id);
	}
	
	
	/**
	 * 修改 国际机票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateFcity(Fcity fcity){
		return fcityManager.updateFcity(fcity);
	
	}

		
	/**
	 * 修改 国际机票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFcityIgnoreNull(Fcity fcity){
			return fcityManager.updateFcityIgnoreNull(fcity);
	
	}
	
	/**
	 * 查找 国际机票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcity(String where, String orderby,int limit,int offset){
		return fcityManager.findAllFcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票城市
	 * @param id
	 * @return
	 */
	public Fcity findFcity(long id){
		return fcityManager.findFcity(id);
	}
	/**
	 * 查找 国际机票城市 by language
	 * @param id
	 * @return
	 */
	public Fcity findFcitybylanguage(long id,Integer language){
		return fcityManager.findFcitybylanguage(id,language);
	}
	/** 
	 * 查找 国际机票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcity(String where, String orderby,PageInfo pageinfo){
		return fcityManager.findAllFcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcity(String sql,int limit,int offset){
		return fcityManager.findAllFcity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcityBySql(String sql){
		return fcityManager.excuteFcityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcityBySql(String sql){
		return fcityManager.countFcityBySql(sql);
	}
}

