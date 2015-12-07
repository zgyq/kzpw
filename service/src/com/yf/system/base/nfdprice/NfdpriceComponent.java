/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.nfdprice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class NfdpriceComponent   implements INfdpriceComponent{ 
	
	
	private INfdpriceManager nfdpriceManager;
   
   
 	public INfdpriceManager getNfdpriceManager() {
		return nfdpriceManager;
	}

	public void setNfdpriceManager(INfdpriceManager nfdpriceManager) {
		this.nfdpriceManager = nfdpriceManager;
	}
  
 	/**
	 * 创建 NFD价格
	 * @param id
	 * @return deleted count 
	 */
	public Nfdprice createNfdprice(Nfdprice nfdprice) throws SQLException{
	
		return nfdpriceManager.createNfdprice(nfdprice);
	}
	/**
	 * 删除 NFD价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteNfdprice(long id){
	
		return nfdpriceManager.deleteNfdprice(id);
	}
	
	
	/**
	 * 修改 NFD价格
	 * @param id
	 * @return updated count 
	 */
	public int updateNfdprice(Nfdprice nfdprice){
		return nfdpriceManager.updateNfdprice(nfdprice);
	
	}

		
	/**
	 * 修改 NFD价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateNfdpriceIgnoreNull(Nfdprice nfdprice){
			return nfdpriceManager.updateNfdpriceIgnoreNull(nfdprice);
	
	}
	
	/**
	 * 查找 NFD价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNfdprice(String where, String orderby,int limit,int offset){
		return nfdpriceManager.findAllNfdprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 NFD价格
	 * @param id
	 * @return
	 */
	public Nfdprice findNfdprice(long id){
		return nfdpriceManager.findNfdprice(id);
	}
	
	/** 
	 * 查找 NFD价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllNfdprice(String where, String orderby,PageInfo pageinfo){
		return nfdpriceManager.findAllNfdprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找NFD价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNfdprice(String sql,int limit,int offset){
		return nfdpriceManager.findAllNfdprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql NFD价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteNfdpriceBySql(String sql){
		return nfdpriceManager.excuteNfdpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countNfdpriceBySql(String sql){
		return nfdpriceManager.countNfdpriceBySql(sql);
	}
}

