/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dnsmaintenance;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IDnsmaintenanceManager{ 
	
  
 	/**
	 * 创建 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public Dnsmaintenance createDnsmaintenance(Dnsmaintenance dnsmaintenance) throws SQLException;
	
	/**
	 * 删除 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDnsmaintenance(long id);
	
	
	/**
	 * 修改 分销商DNSLOGO维护
	 * @param id
	 * @return updated count 
	 */
	public int updateDnsmaintenance(Dnsmaintenance dnsmaintenance);

		
	/**
	 * 修改 分销商DNSLOGO维护但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDnsmaintenanceIgnoreNull(Dnsmaintenance dnsmaintenance);
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param id
	 * @return
	 */
	public Dnsmaintenance findDnsmaintenance(long id);
	
	
	/** 
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找分销商DNSLOGO维护
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 分销商DNSLOGO维护
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDnsmaintenanceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDnsmaintenanceBySql(String sql);
	
}

