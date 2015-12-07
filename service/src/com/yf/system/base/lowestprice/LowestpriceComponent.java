/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.lowestprice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class LowestpriceComponent   implements ILowestpriceComponent{ 
	
	
	private ILowestpriceManager lowestpriceManager;
   
   
 	public ILowestpriceManager getLowestpriceManager() {
		return lowestpriceManager;
	}

	public void setLowestpriceManager(ILowestpriceManager lowestpriceManager) {
		this.lowestpriceManager = lowestpriceManager;
	}
  
 	/**
	 * 创建 机票低价数据表
	 * @param id
	 * @return deleted count 
	 */
	public Lowestprice createLowestprice(Lowestprice lowestprice) throws SQLException{
	
		return lowestpriceManager.createLowestprice(lowestprice);
	}
	/**
	 * 删除 机票低价数据表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLowestprice(long id){
	
		return lowestpriceManager.deleteLowestprice(id);
	}
	
	
	/**
	 * 修改 机票低价数据表
	 * @param id
	 * @return updated count 
	 */
	public int updateLowestprice(Lowestprice lowestprice){
		return lowestpriceManager.updateLowestprice(lowestprice);
	
	}

		
	/**
	 * 修改 机票低价数据表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLowestpriceIgnoreNull(Lowestprice lowestprice){
			return lowestpriceManager.updateLowestpriceIgnoreNull(lowestprice);
	
	}
	
	/**
	 * 查找 机票低价数据表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLowestprice(String where, String orderby,int limit,int offset){
		return lowestpriceManager.findAllLowestprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票低价数据表
	 * @param id
	 * @return
	 */
	public Lowestprice findLowestprice(long id){
		return lowestpriceManager.findLowestprice(id);
	}
	
	/** 
	 * 查找 机票低价数据表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLowestprice(String where, String orderby,PageInfo pageinfo){
		return lowestpriceManager.findAllLowestprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票低价数据表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLowestprice(String sql,int limit,int offset){
		return lowestpriceManager.findAllLowestprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票低价数据表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLowestpriceBySql(String sql){
		return lowestpriceManager.excuteLowestpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLowestpriceBySql(String sql){
		return lowestpriceManager.countLowestpriceBySql(sql);
	}
}

