/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carbrand;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarbrandComponent   implements ICarbrandComponent{ 
	
	
	private ICarbrandManager carbrandManager;
   
   
 	public ICarbrandManager getCarbrandManager() {
		return carbrandManager;
	}

	public void setCarbrandManager(ICarbrandManager carbrandManager) {
		this.carbrandManager = carbrandManager;
	}
  
 	/**
	 * 创建 汽车品牌
	 * @param id
	 * @return deleted count 
	 */
	public Carbrand createCarbrand(Carbrand carbrand) throws SQLException{
	
		return carbrandManager.createCarbrand(carbrand);
	}
	/**
	 * 删除 汽车品牌
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarbrand(long id){
	
		return carbrandManager.deleteCarbrand(id);
	}
	
	
	/**
	 * 修改 汽车品牌
	 * @param id
	 * @return updated count 
	 */
	public int updateCarbrand(Carbrand carbrand){
		return carbrandManager.updateCarbrand(carbrand);
	
	}

		
	/**
	 * 修改 汽车品牌但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarbrandIgnoreNull(Carbrand carbrand){
			return carbrandManager.updateCarbrandIgnoreNull(carbrand);
	
	}
	
	/**
	 * 查找 汽车品牌
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarbrand(String where, String orderby,int limit,int offset){
		return carbrandManager.findAllCarbrand(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 汽车品牌
	 * @param id
	 * @return
	 */
	public Carbrand findCarbrand(long id){
		return carbrandManager.findCarbrand(id);
	}
	
	/** 
	 * 查找 汽车品牌
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarbrand(String where, String orderby,PageInfo pageinfo){
		return carbrandManager.findAllCarbrand(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找汽车品牌
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarbrand(String sql,int limit,int offset){
		return carbrandManager.findAllCarbrand(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 汽车品牌
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarbrandBySql(String sql){
		return carbrandManager.excuteCarbrandBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarbrandBySql(String sql){
		return carbrandManager.countCarbrandBySql(sql);
	}
}

