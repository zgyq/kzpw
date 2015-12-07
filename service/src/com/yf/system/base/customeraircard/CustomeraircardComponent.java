/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeraircard;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CustomeraircardComponent   implements ICustomeraircardComponent{ 
	
	
	private ICustomeraircardManager customeraircardManager;
   
   
 	public ICustomeraircardManager getCustomeraircardManager() {
		return customeraircardManager;
	}

	public void setCustomeraircardManager(ICustomeraircardManager customeraircardManager) {
		this.customeraircardManager = customeraircardManager;
	}
  
 	/**
	 * 创建 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public Customeraircard createCustomeraircard(Customeraircard customeraircard) throws SQLException{
	
		return customeraircardManager.createCustomeraircard(customeraircard);
	}
	/**
	 * 删除 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeraircard(long id){
	
		return customeraircardManager.deleteCustomeraircard(id);
	}
	
	
	/**
	 * 修改 里程卡
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeraircard(Customeraircard customeraircard){
		return customeraircardManager.updateCustomeraircard(customeraircard);
	
	}

		
	/**
	 * 修改 里程卡但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeraircardIgnoreNull(Customeraircard customeraircard){
			return customeraircardManager.updateCustomeraircardIgnoreNull(customeraircard);
	
	}
	
	/**
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,int limit,int offset){
		return customeraircardManager.findAllCustomeraircard(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 里程卡
	 * @param id
	 * @return
	 */
	public Customeraircard findCustomeraircard(long id){
		return customeraircardManager.findCustomeraircard(id);
	}
	
	/** 
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,PageInfo pageinfo){
		return customeraircardManager.findAllCustomeraircard(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找里程卡
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String sql,int limit,int offset){
		return customeraircardManager.findAllCustomeraircard(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 里程卡
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeraircardBySql(String sql){
		return customeraircardManager.excuteCustomeraircardBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeraircardBySql(String sql){
		return customeraircardManager.countCustomeraircardBySql(sql);
	}
}

