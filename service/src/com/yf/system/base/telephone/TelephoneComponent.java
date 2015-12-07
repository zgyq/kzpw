/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.telephone;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TelephoneComponent   implements ITelephoneComponent{ 
	
	
	private ITelephoneManager telephoneManager;
   
   
 	public ITelephoneManager getTelephoneManager() {
		return telephoneManager;
	}

	public void setTelephoneManager(ITelephoneManager telephoneManager) {
		this.telephoneManager = telephoneManager;
	}
  
 	/**
	 * 创建 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public Telephone createTelephone(Telephone telephone) throws SQLException{
	
		return telephoneManager.createTelephone(telephone);
	}
	/**
	 * 删除 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTelephone(long id){
	
		return telephoneManager.deleteTelephone(id);
	}
	
	
	/**
	 * 修改 其他电话
	 * @param id
	 * @return updated count 
	 */
	public int updateTelephone(Telephone telephone){
		return telephoneManager.updateTelephone(telephone);
	
	}

		
	/**
	 * 修改 其他电话但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTelephoneIgnoreNull(Telephone telephone){
			return telephoneManager.updateTelephoneIgnoreNull(telephone);
	
	}
	
	/**
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,int limit,int offset){
		return telephoneManager.findAllTelephone(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 其他电话
	 * @param id
	 * @return
	 */
	public Telephone findTelephone(long id){
		return telephoneManager.findTelephone(id);
	}
	
	/** 
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,PageInfo pageinfo){
		return telephoneManager.findAllTelephone(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找其他电话
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String sql,int limit,int offset){
		return telephoneManager.findAllTelephone(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 其他电话
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTelephoneBySql(String sql){
		return telephoneManager.excuteTelephoneBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTelephoneBySql(String sql){
		return telephoneManager.countTelephoneBySql(sql);
	}
}

