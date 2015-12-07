/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.peisong;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PeisongComponent   implements IPeisongComponent{ 
	
	
	private IPeisongManager peisongManager;
   
   
 	public IPeisongManager getPeisongManager() {
		return peisongManager;
	}

	public void setPeisongManager(IPeisongManager peisongManager) {
		this.peisongManager = peisongManager;
	}
  
 	/**
	 * 创建 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public Peisong createPeisong(Peisong peisong) throws SQLException{
	
		return peisongManager.createPeisong(peisong);
	}
	/**
	 * 删除 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePeisong(long id){
	
		return peisongManager.deletePeisong(id);
	}
	
	
	/**
	 * 修改 行程单配送记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePeisong(Peisong peisong){
		return peisongManager.updatePeisong(peisong);
	
	}

		
	/**
	 * 修改 行程单配送记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePeisongIgnoreNull(Peisong peisong){
			return peisongManager.updatePeisongIgnoreNull(peisong);
	
	}
	
	/**
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,int limit,int offset){
		return peisongManager.findAllPeisong(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单配送记录
	 * @param id
	 * @return
	 */
	public Peisong findPeisong(long id){
		return peisongManager.findPeisong(id);
	}
	
	/** 
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,PageInfo pageinfo){
		return peisongManager.findAllPeisong(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单配送记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String sql,int limit,int offset){
		return peisongManager.findAllPeisong(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单配送记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePeisongBySql(String sql){
		return peisongManager.excutePeisongBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPeisongBySql(String sql){
		return peisongManager.countPeisongBySql(sql);
	}
}

