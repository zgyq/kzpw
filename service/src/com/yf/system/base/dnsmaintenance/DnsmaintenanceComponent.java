/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dnsmaintenance;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class DnsmaintenanceComponent   implements IDnsmaintenanceComponent{ 
	
	
	private IDnsmaintenanceManager dnsmaintenanceManager;
   
   
 	public IDnsmaintenanceManager getDnsmaintenanceManager() {
		return dnsmaintenanceManager;
	}

	public void setDnsmaintenanceManager(IDnsmaintenanceManager dnsmaintenanceManager) {
		this.dnsmaintenanceManager = dnsmaintenanceManager;
	}
  
 	/**
	 * 创建 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public Dnsmaintenance createDnsmaintenance(Dnsmaintenance dnsmaintenance) throws SQLException{
	
		return dnsmaintenanceManager.createDnsmaintenance(dnsmaintenance);
	}
	/**
	 * 删除 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDnsmaintenance(long id){
	
		return dnsmaintenanceManager.deleteDnsmaintenance(id);
	}
	
	
	/**
	 * 修改 分销商DNSLOGO维护
	 * @param id
	 * @return updated count 
	 */
	public int updateDnsmaintenance(Dnsmaintenance dnsmaintenance){
		return dnsmaintenanceManager.updateDnsmaintenance(dnsmaintenance);
	
	}

		
	/**
	 * 修改 分销商DNSLOGO维护但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDnsmaintenanceIgnoreNull(Dnsmaintenance dnsmaintenance){
			return dnsmaintenanceManager.updateDnsmaintenanceIgnoreNull(dnsmaintenance);
	
	}
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,int limit,int offset){
		return dnsmaintenanceManager.findAllDnsmaintenance(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param id
	 * @return
	 */
	public Dnsmaintenance findDnsmaintenance(long id){
		return dnsmaintenanceManager.findDnsmaintenance(id);
	}
	
	/** 
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,PageInfo pageinfo){
		return dnsmaintenanceManager.findAllDnsmaintenance(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找分销商DNSLOGO维护
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String sql,int limit,int offset){
		return dnsmaintenanceManager.findAllDnsmaintenance(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 分销商DNSLOGO维护
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDnsmaintenanceBySql(String sql){
		return dnsmaintenanceManager.excuteDnsmaintenanceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDnsmaintenanceBySql(String sql){
		return dnsmaintenanceManager.countDnsmaintenanceBySql(sql);
	}
}

