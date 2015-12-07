/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeruser;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CustomeruserComponent   implements ICustomeruserComponent{ 
	
	
	private ICustomeruserManager customeruserManager;
   
   
 	public ICustomeruserManager getCustomeruserManager() {
		return customeruserManager;
	}

	public void setCustomeruserManager(ICustomeruserManager customeruserManager) {
		this.customeruserManager = customeruserManager;
	}
  
 	/**
	 * 创建 会员
	 * @param id
	 * @return deleted count 
	 */
	public Customeruser createCustomeruser(Customeruser customeruser) throws SQLException{
	
		return customeruserManager.createCustomeruser(customeruser);
	}
	/**
	 * 删除 会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeruser(long id){
	
		return customeruserManager.deleteCustomeruser(id);
	}
	
	
	/**
	 * 修改 会员
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeruser(Customeruser customeruser){
		return customeruserManager.updateCustomeruser(customeruser);
	
	}

		
	/**
	 * 修改 会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeruserIgnoreNull(Customeruser customeruser){
			return customeruserManager.updateCustomeruserIgnoreNull(customeruser);
	
	}
	
	/**
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,int limit,int offset){
		return customeruserManager.findAllCustomeruser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员
	 * @param id
	 * @return
	 */
	public Customeruser findCustomeruser(long id){
		return customeruserManager.findCustomeruser(id);
	}
	
	/** 
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,PageInfo pageinfo){
		return customeruserManager.findAllCustomeruser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String sql,int limit,int offset){
		return customeruserManager.findAllCustomeruser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeruserBySql(String sql){
		return customeruserManager.excuteCustomeruserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeruserBySql(String sql){
		return customeruserManager.countCustomeruserBySql(sql);
	}
}

