/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airfee;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AirfeeComponent   implements IAirfeeComponent{ 
	
	
	private IAirfeeManager airfeeManager;
   
   
 	public IAirfeeManager getAirfeeManager() {
		return airfeeManager;
	}

	public void setAirfeeManager(IAirfeeManager airfeeManager) {
		this.airfeeManager = airfeeManager;
	}
  
 	/**
	 * 创建 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public Airfee createAirfee(Airfee airfee) throws SQLException{
	
		return airfeeManager.createAirfee(airfee);
	}
	/**
	 * 删除 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirfee(long id){
	
		return airfeeManager.deleteAirfee(id);
	}
	
	
	/**
	 * 修改 燃油费机建费表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirfee(Airfee airfee){
		return airfeeManager.updateAirfee(airfee);
	
	}

		
	/**
	 * 修改 燃油费机建费表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirfeeIgnoreNull(Airfee airfee){
			return airfeeManager.updateAirfeeIgnoreNull(airfee);
	
	}
	
	/**
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,int limit,int offset){
		return airfeeManager.findAllAirfee(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 燃油费机建费表
	 * @param id
	 * @return
	 */
	public Airfee findAirfee(long id){
		return airfeeManager.findAirfee(id);
	}
	/**
	 * 查找 燃油费机建费表 by language
	 * @param id
	 * @return
	 */
	public Airfee findAirfeebylanguage(long id,Integer language){
		return airfeeManager.findAirfeebylanguage(id,language);
	}
	/** 
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,PageInfo pageinfo){
		return airfeeManager.findAllAirfee(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找燃油费机建费表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String sql,int limit,int offset){
		return airfeeManager.findAllAirfee(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 燃油费机建费表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirfeeBySql(String sql){
		return airfeeManager.excuteAirfeeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirfeeBySql(String sql){
		return airfeeManager.countAirfeeBySql(sql);
	}
}

