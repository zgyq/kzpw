/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.withbank;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class WithbankComponent   implements IWithbankComponent{ 
	
	
	private IWithbankManager withbankManager;
   
   
 	public IWithbankManager getWithbankManager() {
		return withbankManager;
	}

	public void setWithbankManager(IWithbankManager withbankManager) {
		this.withbankManager = withbankManager;
	}
  
 	/**
	 * 创建 提现
	 * @param id
	 * @return deleted count 
	 */
	public Withbank createWithbank(Withbank withbank) throws SQLException{
	
		return withbankManager.createWithbank(withbank);
	}
	/**
	 * 删除 提现
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWithbank(long id){
	
		return withbankManager.deleteWithbank(id);
	}
	
	
	/**
	 * 修改 提现
	 * @param id
	 * @return updated count 
	 */
	public int updateWithbank(Withbank withbank){
		return withbankManager.updateWithbank(withbank);
	
	}

		
	/**
	 * 修改 提现但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWithbankIgnoreNull(Withbank withbank){
			return withbankManager.updateWithbankIgnoreNull(withbank);
	
	}
	
	/**
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,int limit,int offset){
		return withbankManager.findAllWithbank(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 提现
	 * @param id
	 * @return
	 */
	public Withbank findWithbank(long id){
		return withbankManager.findWithbank(id);
	}
	
	/** 
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,PageInfo pageinfo){
		return withbankManager.findAllWithbank(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找提现
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String sql,int limit,int offset){
		return withbankManager.findAllWithbank(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 提现
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWithbankBySql(String sql){
		return withbankManager.excuteWithbankBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWithbankBySql(String sql){
		return withbankManager.countWithbankBySql(sql);
	}
}

