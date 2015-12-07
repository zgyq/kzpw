/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.specialprice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpecialpriceComponent   implements ISpecialpriceComponent{ 
	
	
	private ISpecialpriceManager specialpriceManager;
   
   
 	public ISpecialpriceManager getSpecialpriceManager() {
		return specialpriceManager;
	}

	public void setSpecialpriceManager(ISpecialpriceManager specialpriceManager) {
		this.specialpriceManager = specialpriceManager;
	}
  
 	/**
	 * 创建 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public Specialprice createSpecialprice(Specialprice specialprice) throws SQLException{
	
		return specialpriceManager.createSpecialprice(specialprice);
	}
	/**
	 * 删除 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpecialprice(long id){
	
		return specialpriceManager.deleteSpecialprice(id);
	}
	
	
	/**
	 * 修改 特价机票信息（定期更新）
	 * @param id
	 * @return updated count 
	 */
	public int updateSpecialprice(Specialprice specialprice){
		return specialpriceManager.updateSpecialprice(specialprice);
	
	}

		
	/**
	 * 修改 特价机票信息（定期更新）但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpecialpriceIgnoreNull(Specialprice specialprice){
			return specialpriceManager.updateSpecialpriceIgnoreNull(specialprice);
	
	}
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,int limit,int offset){
		return specialpriceManager.findAllSpecialprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param id
	 * @return
	 */
	public Specialprice findSpecialprice(long id){
		return specialpriceManager.findSpecialprice(id);
	}
	
	/** 
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,PageInfo pageinfo){
		return specialpriceManager.findAllSpecialprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找特价机票信息（定期更新）
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String sql,int limit,int offset){
		return specialpriceManager.findAllSpecialprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 特价机票信息（定期更新）
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpecialpriceBySql(String sql){
		return specialpriceManager.excuteSpecialpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpecialpriceBySql(String sql){
		return specialpriceManager.countSpecialpriceBySql(sql);
	}
}

