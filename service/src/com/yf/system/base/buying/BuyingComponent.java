/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.buying;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class BuyingComponent   implements IBuyingComponent{ 
	
	
	private IBuyingManager buyingManager;
   
   
 	public IBuyingManager getBuyingManager() {
		return buyingManager;
	}

	public void setBuyingManager(IBuyingManager buyingManager) {
		this.buyingManager = buyingManager;
	}
  
 	/**
	 * 创建 团购信息
	 * @param id
	 * @return deleted count 
	 */
	public Buying createBuying(Buying buying) throws SQLException{
	
		return buyingManager.createBuying(buying);
	}
	/**
	 * 删除 团购信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBuying(long id){
	
		return buyingManager.deleteBuying(id);
	}
	
	
	/**
	 * 修改 团购信息
	 * @param id
	 * @return updated count 
	 */
	public int updateBuying(Buying buying){
		return buyingManager.updateBuying(buying);
	
	}

		
	/**
	 * 修改 团购信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBuyingIgnoreNull(Buying buying){
			return buyingManager.updateBuyingIgnoreNull(buying);
	
	}
	
	/**
	 * 查找 团购信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuying(String where, String orderby,int limit,int offset){
		return buyingManager.findAllBuying(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团购信息
	 * @param id
	 * @return
	 */
	public Buying findBuying(long id){
		return buyingManager.findBuying(id);
	}
	
	/** 
	 * 查找 团购信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuying(String where, String orderby,PageInfo pageinfo){
		return buyingManager.findAllBuying(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团购信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuying(String sql,int limit,int offset){
		return buyingManager.findAllBuying(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团购信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBuyingBySql(String sql){
		return buyingManager.excuteBuyingBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBuyingBySql(String sql){
		return buyingManager.countBuyingBySql(sql);
	}
}

