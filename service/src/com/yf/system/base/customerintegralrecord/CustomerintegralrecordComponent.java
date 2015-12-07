/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customerintegralrecord;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CustomerintegralrecordComponent   implements ICustomerintegralrecordComponent{ 
	
	
	private ICustomerintegralrecordManager customerintegralrecordManager;
   
   
 	public ICustomerintegralrecordManager getCustomerintegralrecordManager() {
		return customerintegralrecordManager;
	}

	public void setCustomerintegralrecordManager(ICustomerintegralrecordManager customerintegralrecordManager) {
		this.customerintegralrecordManager = customerintegralrecordManager;
	}
  
 	/**
	 * 创建 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public Customerintegralrecord createCustomerintegralrecord(Customerintegralrecord customerintegralrecord) throws SQLException{
	
		return customerintegralrecordManager.createCustomerintegralrecord(customerintegralrecord);
	}
	/**
	 * 删除 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerintegralrecord(long id){
	
		return customerintegralrecordManager.deleteCustomerintegralrecord(id);
	}
	
	
	/**
	 * 修改 会员积分记录
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerintegralrecord(Customerintegralrecord customerintegralrecord){
		return customerintegralrecordManager.updateCustomerintegralrecord(customerintegralrecord);
	
	}

		
	/**
	 * 修改 会员积分记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerintegralrecordIgnoreNull(Customerintegralrecord customerintegralrecord){
			return customerintegralrecordManager.updateCustomerintegralrecordIgnoreNull(customerintegralrecord);
	
	}
	
	/**
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,int limit,int offset){
		return customerintegralrecordManager.findAllCustomerintegralrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员积分记录
	 * @param id
	 * @return
	 */
	public Customerintegralrecord findCustomerintegralrecord(long id){
		return customerintegralrecordManager.findCustomerintegralrecord(id);
	}
	
	/** 
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,PageInfo pageinfo){
		return customerintegralrecordManager.findAllCustomerintegralrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员积分记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String sql,int limit,int offset){
		return customerintegralrecordManager.findAllCustomerintegralrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员积分记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerintegralrecordBySql(String sql){
		return customerintegralrecordManager.excuteCustomerintegralrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerintegralrecordBySql(String sql){
		return customerintegralrecordManager.countCustomerintegralrecordBySql(sql);
	}
}

