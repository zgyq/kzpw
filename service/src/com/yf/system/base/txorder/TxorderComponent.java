/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.txorder;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TxorderComponent   implements ITxorderComponent{ 
	
	
	private ITxorderManager txorderManager;
   
   
 	public ITxorderManager getTxorderManager() {
		return txorderManager;
	}

	public void setTxorderManager(ITxorderManager txorderManager) {
		this.txorderManager = txorderManager;
	}
  
 	/**
	 * 创建 TX订单
	 * @param id
	 * @return deleted count 
	 */
	public Txorder createTxorder(Txorder txorder) throws SQLException{
	
		return txorderManager.createTxorder(txorder);
	}
	/**
	 * 删除 TX订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTxorder(long id){
	
		return txorderManager.deleteTxorder(id);
	}
	
	
	/**
	 * 修改 TX订单
	 * @param id
	 * @return updated count 
	 */
	public int updateTxorder(Txorder txorder){
		return txorderManager.updateTxorder(txorder);
	
	}

		
	/**
	 * 修改 TX订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTxorderIgnoreNull(Txorder txorder){
			return txorderManager.updateTxorderIgnoreNull(txorder);
	
	}
	
	/**
	 * 查找 TX订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxorder(String where, String orderby,int limit,int offset){
		return txorderManager.findAllTxorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 TX订单
	 * @param id
	 * @return
	 */
	public Txorder findTxorder(long id){
		return txorderManager.findTxorder(id);
	}
	
	/** 
	 * 查找 TX订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTxorder(String where, String orderby,PageInfo pageinfo){
		return txorderManager.findAllTxorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找TX订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxorder(String sql,int limit,int offset){
		return txorderManager.findAllTxorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql TX订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTxorderBySql(String sql){
		return txorderManager.excuteTxorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTxorderBySql(String sql){
		return txorderManager.countTxorderBySql(sql);
	}
}

