/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.biguserprice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class BiguserpriceComponent   implements IBiguserpriceComponent{ 
	
	
	private IBiguserpriceManager biguserpriceManager;
   
   
 	public IBiguserpriceManager getBiguserpriceManager() {
		return biguserpriceManager;
	}

	public void setBiguserpriceManager(IBiguserpriceManager biguserpriceManager) {
		this.biguserpriceManager = biguserpriceManager;
	}
  
 	/**
	 * 创建 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public Biguserprice createBiguserprice(Biguserprice biguserprice) throws SQLException{
	
		return biguserpriceManager.createBiguserprice(biguserprice);
	}
	/**
	 * 删除 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguserprice(long id){
	
		return biguserpriceManager.deleteBiguserprice(id);
	}
	
	
	/**
	 * 修改 大客户还款金额记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguserprice(Biguserprice biguserprice){
		return biguserpriceManager.updateBiguserprice(biguserprice);
	
	}

		
	/**
	 * 修改 大客户还款金额记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserpriceIgnoreNull(Biguserprice biguserprice){
			return biguserpriceManager.updateBiguserpriceIgnoreNull(biguserprice);
	
	}
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,int limit,int offset){
		return biguserpriceManager.findAllBiguserprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param id
	 * @return
	 */
	public Biguserprice findBiguserprice(long id){
		return biguserpriceManager.findBiguserprice(id);
	}
	
	/** 
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,PageInfo pageinfo){
		return biguserpriceManager.findAllBiguserprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找大客户还款金额记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String sql,int limit,int offset){
		return biguserpriceManager.findAllBiguserprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 大客户还款金额记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserpriceBySql(String sql){
		return biguserpriceManager.excuteBiguserpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserpriceBySql(String sql){
		return biguserpriceManager.countBiguserpriceBySql(sql);
	}
}

