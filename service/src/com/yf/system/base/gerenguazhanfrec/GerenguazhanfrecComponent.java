/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.gerenguazhanfrec;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class GerenguazhanfrecComponent   implements IGerenguazhanfrecComponent{ 
	
	
	private IGerenguazhanfrecManager gerenguazhanfrecManager;
   
   
 	public IGerenguazhanfrecManager getGerenguazhanfrecManager() {
		return gerenguazhanfrecManager;
	}

	public void setGerenguazhanfrecManager(IGerenguazhanfrecManager gerenguazhanfrecManager) {
		this.gerenguazhanfrecManager = gerenguazhanfrecManager;
	}
  
 	/**
	 * 创建 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public Gerenguazhanfrec createGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec) throws SQLException{
	
		return gerenguazhanfrecManager.createGerenguazhanfrec(gerenguazhanfrec);
	}
	/**
	 * 删除 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGerenguazhanfrec(long id){
	
		return gerenguazhanfrecManager.deleteGerenguazhanfrec(id);
	}
	
	
	/**
	 * 修改 个人挂账记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec){
		return gerenguazhanfrecManager.updateGerenguazhanfrec(gerenguazhanfrec);
	
	}

		
	/**
	 * 修改 个人挂账记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGerenguazhanfrecIgnoreNull(Gerenguazhanfrec gerenguazhanfrec){
			return gerenguazhanfrecManager.updateGerenguazhanfrecIgnoreNull(gerenguazhanfrec);
	
	}
	
	/**
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,int limit,int offset){
		return gerenguazhanfrecManager.findAllGerenguazhanfrec(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 个人挂账记录表
	 * @param id
	 * @return
	 */
	public Gerenguazhanfrec findGerenguazhanfrec(long id){
		return gerenguazhanfrecManager.findGerenguazhanfrec(id);
	}
	
	/** 
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,PageInfo pageinfo){
		return gerenguazhanfrecManager.findAllGerenguazhanfrec(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找个人挂账记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String sql,int limit,int offset){
		return gerenguazhanfrecManager.findAllGerenguazhanfrec(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 个人挂账记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGerenguazhanfrecBySql(String sql){
		return gerenguazhanfrecManager.excuteGerenguazhanfrecBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGerenguazhanfrecBySql(String sql){
		return gerenguazhanfrecManager.countGerenguazhanfrecBySql(sql);
	}
}

