/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rebaterecord;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RebaterecordComponent   implements IRebaterecordComponent{ 
	
	
	private IRebaterecordManager rebaterecordManager;
   
   
 	public IRebaterecordManager getRebaterecordManager() {
		return rebaterecordManager;
	}

	public void setRebaterecordManager(IRebaterecordManager rebaterecordManager) {
		this.rebaterecordManager = rebaterecordManager;
	}
  
 	/**
	 * 创建 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterecord createRebaterecord(Rebaterecord rebaterecord) throws SQLException{
	
		return rebaterecordManager.createRebaterecord(rebaterecord);
	}
	/**
	 * 删除 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterecord(long id){
	
		return rebaterecordManager.deleteRebaterecord(id);
	}
	
	
	/**
	 * 修改 返佣记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterecord(Rebaterecord rebaterecord){
		return rebaterecordManager.updateRebaterecord(rebaterecord);
	
	}

		
	/**
	 * 修改 返佣记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebaterecordIgnoreNull(Rebaterecord rebaterecord){
			return rebaterecordManager.updateRebaterecordIgnoreNull(rebaterecord);
	
	}
	
	/**
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,int limit,int offset){
		return rebaterecordManager.findAllRebaterecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 返佣记录表
	 * @param id
	 * @return
	 */
	public Rebaterecord findRebaterecord(long id){
		return rebaterecordManager.findRebaterecord(id);
	}
	
	/** 
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,PageInfo pageinfo,String...sql){
		return rebaterecordManager.findAllRebaterecord(where, orderby,pageinfo,sql);
	}
		
	/** 
	 * 根据Sql查找返佣记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String sql,int limit,int offset){
		return rebaterecordManager.findAllRebaterecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 返佣记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebaterecordBySql(String sql){
		return rebaterecordManager.excuteRebaterecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebaterecordBySql(String sql){
		return rebaterecordManager.countRebaterecordBySql(sql);
	}
}

