/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.aircompany;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AircompanyComponent   implements IAircompanyComponent{ 
	
	
	private IAircompanyManager aircompanyManager;
   
   
 	public IAircompanyManager getAircompanyManager() {
		return aircompanyManager;
	}

	public void setAircompanyManager(IAircompanyManager aircompanyManager) {
		this.aircompanyManager = aircompanyManager;
	}
  
 	/**
	 * 创建 航空公司基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Aircompany createAircompany(Aircompany aircompany) throws SQLException{
	
		return aircompanyManager.createAircompany(aircompany);
	}
	/**
	 * 删除 航空公司基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAircompany(long id){
	
		return aircompanyManager.deleteAircompany(id);
	}
	
	
	/**
	 * 修改 航空公司基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAircompany(Aircompany aircompany){
		return aircompanyManager.updateAircompany(aircompany);
	
	}

		
	/**
	 * 修改 航空公司基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAircompanyIgnoreNull(Aircompany aircompany){
			return aircompanyManager.updateAircompanyIgnoreNull(aircompany);
	
	}
	
	/**
	 * 查找 航空公司基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAircompany(String where, String orderby,int limit,int offset){
		return aircompanyManager.findAllAircompany(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航空公司基础信息表
	 * @param id
	 * @return
	 */
	public Aircompany findAircompany(long id){
		return aircompanyManager.findAircompany(id);
	}
	/**
	 * 查找 航空公司基础信息表 by language
	 * @param id
	 * @return
	 */
	public Aircompany findAircompanybylanguage(long id,Integer language){
		return aircompanyManager.findAircompanybylanguage(id,language);
	}
	/** 
	 * 查找 航空公司基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAircompany(String where, String orderby,PageInfo pageinfo){
		return aircompanyManager.findAllAircompany(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航空公司基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAircompany(String sql,int limit,int offset){
		return aircompanyManager.findAllAircompany(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航空公司基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAircompanyBySql(String sql){
		return aircompanyManager.excuteAircompanyBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAircompanyBySql(String sql){
		return aircompanyManager.countAircompanyBySql(sql);
	}
}

