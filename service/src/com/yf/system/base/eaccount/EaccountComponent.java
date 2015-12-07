/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.eaccount;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class EaccountComponent   implements IEaccountComponent{ 
	
	
	private IEaccountManager eaccountManager;
   
   
 	public IEaccountManager getEaccountManager() {
		return eaccountManager;
	}

	public void setEaccountManager(IEaccountManager eaccountManager) {
		this.eaccountManager = eaccountManager;
	}
  
 	/**
	 * 创建 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public Eaccount createEaccount(Eaccount eaccount) throws SQLException{
	
		return eaccountManager.createEaccount(eaccount);
	}
	/**
	 * 删除 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEaccount(long id){
	
		return eaccountManager.deleteEaccount(id);
	}
	
	
	/**
	 * 修改 外部账号
	 * @param id
	 * @return updated count 
	 */
	public int updateEaccount(Eaccount eaccount){
		return eaccountManager.updateEaccount(eaccount);
	
	}

		
	/**
	 * 修改 外部账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEaccountIgnoreNull(Eaccount eaccount){
			return eaccountManager.updateEaccountIgnoreNull(eaccount);
	
	}
	
	/**
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,int limit,int offset){
		return eaccountManager.findAllEaccount(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 外部账号
	 * @param id
	 * @return
	 */
	public Eaccount findEaccount(long id){
		return eaccountManager.findEaccount(id);
	}
	
	/** 
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,PageInfo pageinfo){
		return eaccountManager.findAllEaccount(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找外部账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String sql,int limit,int offset){
		return eaccountManager.findAllEaccount(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 外部账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEaccountBySql(String sql){
		return eaccountManager.excuteEaccountBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEaccountBySql(String sql){
		return eaccountManager.countEaccountBySql(sql);
	}
}

