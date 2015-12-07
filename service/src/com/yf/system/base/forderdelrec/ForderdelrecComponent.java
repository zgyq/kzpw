/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.forderdelrec;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ForderdelrecComponent   implements IForderdelrecComponent{ 
	
	
	private IForderdelrecManager forderdelrecManager;
   
   
 	public IForderdelrecManager getForderdelrecManager() {
		return forderdelrecManager;
	}

	public void setForderdelrecManager(IForderdelrecManager forderdelrecManager) {
		this.forderdelrecManager = forderdelrecManager;
	}
  
 	/**
	 * 创建 国际机票订单操作记录
	 * @param id
	 * @return deleted count 
	 */
	public Forderdelrec createForderdelrec(Forderdelrec forderdelrec) throws SQLException{
	
		return forderdelrecManager.createForderdelrec(forderdelrec);
	}
	/**
	 * 删除 国际机票订单操作记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderdelrec(long id){
	
		return forderdelrecManager.deleteForderdelrec(id);
	}
	
	
	/**
	 * 修改 国际机票订单操作记录
	 * @param id
	 * @return updated count 
	 */
	public int updateForderdelrec(Forderdelrec forderdelrec){
		return forderdelrecManager.updateForderdelrec(forderdelrec);
	
	}

		
	/**
	 * 修改 国际机票订单操作记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateForderdelrecIgnoreNull(Forderdelrec forderdelrec){
			return forderdelrecManager.updateForderdelrecIgnoreNull(forderdelrec);
	
	}
	
	/**
	 * 查找 国际机票订单操作记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,int limit,int offset){
		return forderdelrecManager.findAllForderdelrec(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票订单操作记录
	 * @param id
	 * @return
	 */
	public Forderdelrec findForderdelrec(long id){
		return forderdelrecManager.findForderdelrec(id);
	}
	
	/** 
	 * 查找 国际机票订单操作记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,PageInfo pageinfo){
		return forderdelrecManager.findAllForderdelrec(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票订单操作记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String sql,int limit,int offset){
		return forderdelrecManager.findAllForderdelrec(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票订单操作记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderdelrecBySql(String sql){
		return forderdelrecManager.excuteForderdelrecBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderdelrecBySql(String sql){
		return forderdelrecManager.countForderdelrecBySql(sql);
	}
}

