/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cabin;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CabinComponent   implements ICabinComponent{ 
	
	
	private ICabinManager cabinManager;
   
   
 	public ICabinManager getCabinManager() {
		return cabinManager;
	}

	public void setCabinManager(ICabinManager cabinManager) {
		this.cabinManager = cabinManager;
	}
  
 	/**
	 * 创建 舱位基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Cabin createCabin(Cabin cabin) throws SQLException{
	
		return cabinManager.createCabin(cabin);
	}
	/**
	 * 删除 舱位基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCabin(long id){
	
		return cabinManager.deleteCabin(id);
	}
	
	
	/**
	 * 修改 舱位基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCabin(Cabin cabin){
		return cabinManager.updateCabin(cabin);
	
	}

		
	/**
	 * 修改 舱位基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCabinIgnoreNull(Cabin cabin){
			return cabinManager.updateCabinIgnoreNull(cabin);
	
	}
	
	/**
	 * 查找 舱位基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCabin(String where, String orderby,int limit,int offset){
		return cabinManager.findAllCabin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 舱位基础信息表
	 * @param id
	 * @return
	 */
	public Cabin findCabin(long id){
		return cabinManager.findCabin(id);
	}
	/**
	 * 查找 舱位基础信息表 by language
	 * @param id
	 * @return
	 */
	public Cabin findCabinbylanguage(long id,Integer language){
		return cabinManager.findCabinbylanguage(id,language);
	}
	/** 
	 * 查找 舱位基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCabin(String where, String orderby,PageInfo pageinfo){
		return cabinManager.findAllCabin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找舱位基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCabin(String sql,int limit,int offset){
		return cabinManager.findAllCabin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 舱位基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCabinBySql(String sql){
		return cabinManager.excuteCabinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCabinBySql(String sql){
		return cabinManager.countCabinBySql(sql);
	}
}

