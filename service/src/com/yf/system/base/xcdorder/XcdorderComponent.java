/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdorder;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class XcdorderComponent   implements IXcdorderComponent{ 
	
	
	private IXcdorderManager xcdorderManager;
   
   
 	public IXcdorderManager getXcdorderManager() {
		return xcdorderManager;
	}

	public void setXcdorderManager(IXcdorderManager xcdorderManager) {
		this.xcdorderManager = xcdorderManager;
	}
  
 	/**
	 * 创建 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdorder createXcdorder(Xcdorder xcdorder) throws SQLException{
	
		return xcdorderManager.createXcdorder(xcdorder);
	}
	/**
	 * 删除 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdorder(long id){
	
		return xcdorderManager.deleteXcdorder(id);
	}
	
	
	/**
	 * 修改 行程单订单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdorder(Xcdorder xcdorder){
		return xcdorderManager.updateXcdorder(xcdorder);
	
	}

		
	/**
	 * 修改 行程单订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdorderIgnoreNull(Xcdorder xcdorder){
			return xcdorderManager.updateXcdorderIgnoreNull(xcdorder);
	
	}
	
	/**
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,int limit,int offset){
		return xcdorderManager.findAllXcdorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单订单
	 * @param id
	 * @return
	 */
	public Xcdorder findXcdorder(long id){
		return xcdorderManager.findXcdorder(id);
	}
	
	/** 
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,PageInfo pageinfo){
		return xcdorderManager.findAllXcdorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String sql,int limit,int offset){
		return xcdorderManager.findAllXcdorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdorderBySql(String sql){
		return xcdorderManager.excuteXcdorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdorderBySql(String sql){
		return xcdorderManager.countXcdorderBySql(sql);
	}
}

