/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.biguser;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class BiguserComponent   implements IBiguserComponent{ 
	
	
	private IBiguserManager biguserManager;
   
   
 	public IBiguserManager getBiguserManager() {
		return biguserManager;
	}

	public void setBiguserManager(IBiguserManager biguserManager) {
		this.biguserManager = biguserManager;
	}
  
 	/**
	 * 创建 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public Biguser createBiguser(Biguser biguser) throws SQLException{
	
		return biguserManager.createBiguser(biguser);
	}
	/**
	 * 删除 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguser(long id){
	
		return biguserManager.deleteBiguser(id);
	}
	
	
	/**
	 * 修改 大客户关联金额表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguser(Biguser biguser){
		return biguserManager.updateBiguser(biguser);
	
	}

		
	/**
	 * 修改 大客户关联金额表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserIgnoreNull(Biguser biguser){
			return biguserManager.updateBiguserIgnoreNull(biguser);
	
	}
	
	/**
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,int limit,int offset){
		return biguserManager.findAllBiguser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param id
	 * @return
	 */
	public Biguser findBiguser(long id){
		return biguserManager.findBiguser(id);
	}
	
	/** 
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,PageInfo pageinfo){
		return biguserManager.findAllBiguser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找大客户关联金额表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String sql,int limit,int offset){
		return biguserManager.findAllBiguser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 大客户关联金额表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserBySql(String sql){
		return biguserManager.excuteBiguserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserBySql(String sql){
		return biguserManager.countBiguserBySql(sql);
	}
}

