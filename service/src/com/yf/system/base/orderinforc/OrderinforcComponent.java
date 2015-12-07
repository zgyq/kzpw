/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.orderinforc;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class OrderinforcComponent   implements IOrderinforcComponent{ 
	
	
	private IOrderinforcManager orderinforcManager;
   
   
 	public IOrderinforcManager getOrderinforcManager() {
		return orderinforcManager;
	}

	public void setOrderinforcManager(IOrderinforcManager orderinforcManager) {
		this.orderinforcManager = orderinforcManager;
	}
  
 	/**
	 * 创建 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public Orderinforc createOrderinforc(Orderinforc orderinforc) throws SQLException{
	
		return orderinforcManager.createOrderinforc(orderinforc);
	}
	/**
	 * 删除 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOrderinforc(long id){
	
		return orderinforcManager.deleteOrderinforc(id);
	}
	
	
	/**
	 * 修改 订单处理记录
	 * @param id
	 * @return updated count 
	 */
	public int updateOrderinforc(Orderinforc orderinforc){
		return orderinforcManager.updateOrderinforc(orderinforc);
	
	}

		
	/**
	 * 修改 订单处理记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOrderinforcIgnoreNull(Orderinforc orderinforc){
			return orderinforcManager.updateOrderinforcIgnoreNull(orderinforc);
	
	}
	
	/**
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,int limit,int offset){
		return orderinforcManager.findAllOrderinforc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 订单处理记录
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforc(long id){
		return orderinforcManager.findOrderinforc(id);
	}
	/**
	 * 查找 订单处理记录 by language
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforcbylanguage(long id,Integer language){
		return orderinforcManager.findOrderinforcbylanguage(id,language);
	}
	/** 
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,PageInfo pageinfo){
		return orderinforcManager.findAllOrderinforc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找订单处理记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String sql,int limit,int offset){
		return orderinforcManager.findAllOrderinforc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 订单处理记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOrderinforcBySql(String sql){
		return orderinforcManager.excuteOrderinforcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOrderinforcBySql(String sql){
		return orderinforcManager.countOrderinforcBySql(sql);
	}
}

