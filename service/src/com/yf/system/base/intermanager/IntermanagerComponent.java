/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.intermanager;

import java.sql.SQLException;

import java.util.List;

import com.yf.system.base.util.PageInfo;

public class IntermanagerComponent   implements IIntermanagerComponent{ 
	
	
	public List findMapResultPageByProcedure(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo ){
		return this.intermanagerManager.findMapResultPageByProcedure(tableName, fldName, fldSort, sort, where, fldID, pageinfo);
	}
	
	private IIntermanagerManager intermanagerManager;
   
   
 	public IIntermanagerManager getIntermanagerManager() {
 	
		return intermanagerManager;
	}

	public void setIntermanagerManager(IIntermanagerManager intermanagerManager) {
		this.intermanagerManager = intermanagerManager;
	}
  
 	/**
	 * 创建 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public Intermanager createIntermanager(Intermanager intermanager) throws SQLException{
	
		return intermanagerManager.createIntermanager(intermanager);
	}
	/**
	 * 删除 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntermanager(long id){
	
		return intermanagerManager.deleteIntermanager(id);
	}
	
	
	/**
	 * 修改 接口管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntermanager(Intermanager intermanager){
		return intermanagerManager.updateIntermanager(intermanager);
	
	}

		
	/**
	 * 修改 接口管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntermanagerIgnoreNull(Intermanager intermanager){
			return intermanagerManager.updateIntermanagerIgnoreNull(intermanager);
	
	}
	
	/**
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,int limit,int offset){
		return intermanagerManager.findAllIntermanager(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 接口管理
	 * @param id
	 * @return
	 */
	public Intermanager findIntermanager(long id){
		return intermanagerManager.findIntermanager(id);
	}
	
	/** 
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,PageInfo pageinfo){
		return intermanagerManager.findAllIntermanager(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找接口管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String sql,int limit,int offset){
		return intermanagerManager.findAllIntermanager(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 接口管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntermanagerBySql(String sql){
		return intermanagerManager.excuteIntermanagerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntermanagerBySql(String sql){
		return intermanagerManager.countIntermanagerBySql(sql);
	}
	
	
	/**
	 * 执行sql返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultBySql(String sql,PageInfo pageinfo){
		return intermanagerManager.findMapResultBySql(sql,pageinfo);
	}
	
	/**
	 * 执行存贮过程返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultByProcedure(String procedure){
			return intermanagerManager.findMapResultByProcedure(procedure);
	}

	@Override
	public List findMapResultSortBySql(String sql, String orderby, PageInfo pageinfo) {
		return intermanagerManager.findMapResultSortBySql(sql,orderby,pageinfo);
	}

	@Override
	public <T> T getTObject(Class<T> cls,long id, String... clos) {
		return this.intermanagerManager.getTObject(cls, id, clos);
	}
	
	
}

