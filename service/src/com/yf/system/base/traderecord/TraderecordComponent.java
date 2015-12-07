/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traderecord;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TraderecordComponent   implements ITraderecordComponent{ 
	
	
	private ITraderecordManager traderecordManager;
   
   
 	public ITraderecordManager getTraderecordManager() {
		return traderecordManager;
	}

	public void setTraderecordManager(ITraderecordManager traderecordManager) {
		this.traderecordManager = traderecordManager;
	}
  
 	/**
	 * 创建 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public Traderecord createTraderecord(Traderecord traderecord) throws SQLException{
	
		return traderecordManager.createTraderecord(traderecord);
	}
	/**
	 * 删除 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraderecord(long id){
	
		return traderecordManager.deleteTraderecord(id);
	}
	
	
	/**
	 * 修改 交易记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTraderecord(Traderecord traderecord){
		return traderecordManager.updateTraderecord(traderecord);
	
	}

		
	/**
	 * 修改 交易记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraderecordIgnoreNull(Traderecord traderecord){
			return traderecordManager.updateTraderecordIgnoreNull(traderecord);
	
	}
	
	/**
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,int limit,int offset){
		return traderecordManager.findAllTraderecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 交易记录
	 * @param id
	 * @return
	 */
	public Traderecord findTraderecord(long id){
		return traderecordManager.findTraderecord(id);
	}
	
	/** 
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,PageInfo pageinfo){
		return traderecordManager.findAllTraderecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找交易记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String sql,int limit,int offset){
		return traderecordManager.findAllTraderecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 交易记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraderecordBySql(String sql){
		return traderecordManager.excuteTraderecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraderecordBySql(String sql){
		return traderecordManager.countTraderecordBySql(sql);
	}
}

