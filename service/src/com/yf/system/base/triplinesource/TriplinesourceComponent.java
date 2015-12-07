/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triplinesource;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriplinesourceComponent   implements ITriplinesourceComponent{ 
	
	
	private ITriplinesourceManager triplinesourceManager;
   
   
 	public ITriplinesourceManager getTriplinesourceManager() {
		return triplinesourceManager;
	}

	public void setTriplinesourceManager(ITriplinesourceManager triplinesourceManager) {
		this.triplinesourceManager = triplinesourceManager;
	}
  
 	/**
	 * 创建 旅游线路来源
	 * @param id
	 * @return deleted count 
	 */
	public Triplinesource createTriplinesource(Triplinesource triplinesource) throws SQLException{
	
		return triplinesourceManager.createTriplinesource(triplinesource);
	}
	/**
	 * 删除 旅游线路来源
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriplinesource(long id){
	
		return triplinesourceManager.deleteTriplinesource(id);
	}
	
	
	/**
	 * 修改 旅游线路来源
	 * @param id
	 * @return updated count 
	 */
	public int updateTriplinesource(Triplinesource triplinesource){
		return triplinesourceManager.updateTriplinesource(triplinesource);
	
	}

		
	/**
	 * 修改 旅游线路来源但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplinesourceIgnoreNull(Triplinesource triplinesource){
			return triplinesourceManager.updateTriplinesourceIgnoreNull(triplinesource);
	
	}
	
	/**
	 * 查找 旅游线路来源
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesource(String where, String orderby,int limit,int offset){
		return triplinesourceManager.findAllTriplinesource(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 旅游线路来源
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesource(long id){
		return triplinesourceManager.findTriplinesource(id);
	}
	/**
	 * 查找 旅游线路来源 by language
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesourcebylanguage(long id,Integer language){
		return triplinesourceManager.findTriplinesourcebylanguage(id,language);
	}
	/** 
	 * 查找 旅游线路来源
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinesource(String where, String orderby,PageInfo pageinfo){
		return triplinesourceManager.findAllTriplinesource(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找旅游线路来源
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesource(String sql,int limit,int offset){
		return triplinesourceManager.findAllTriplinesource(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 旅游线路来源
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplinesourceBySql(String sql){
		return triplinesourceManager.excuteTriplinesourceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplinesourceBySql(String sql){
		return triplinesourceManager.countTriplinesourceBySql(sql);
	}
}

