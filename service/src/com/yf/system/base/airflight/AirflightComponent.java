/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airflight;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AirflightComponent   implements IAirflightComponent{ 
	
	
	private IAirflightManager airflightManager;
   
   
 	public IAirflightManager getAirflightManager() {
		return airflightManager;
	}

	public void setAirflightManager(IAirflightManager airflightManager) {
		this.airflightManager = airflightManager;
	}
  
 	/**
	 * 创建 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Airflight createAirflight(Airflight airflight) throws SQLException{
	
		return airflightManager.createAirflight(airflight);
	}
	/**
	 * 删除 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirflight(long id){
	
		return airflightManager.deleteAirflight(id);
	}
	
	
	/**
	 * 修改 航班基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirflight(Airflight airflight){
		return airflightManager.updateAirflight(airflight);
	
	}

		
	/**
	 * 修改 航班基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirflightIgnoreNull(Airflight airflight){
			return airflightManager.updateAirflightIgnoreNull(airflight);
	
	}
	
	/**
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,int limit,int offset){
		return airflightManager.findAllAirflight(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航班基础信息表
	 * @param id
	 * @return
	 */
	public Airflight findAirflight(long id){
		return airflightManager.findAirflight(id);
	}
	/**
	 * 查找 航班基础信息表 by language
	 * @param id
	 * @return
	 */
	public Airflight findAirflightbylanguage(long id,Integer language){
		return airflightManager.findAirflightbylanguage(id,language);
	}
	/** 
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,PageInfo pageinfo){
		return airflightManager.findAllAirflight(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航班基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String sql,int limit,int offset){
		return airflightManager.findAllAirflight(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航班基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirflightBySql(String sql){
		return airflightManager.excuteAirflightBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirflightBySql(String sql){
		return airflightManager.countAirflightBySql(sql);
	}
}

