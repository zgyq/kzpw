/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.information;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class InformationComponent   implements IInformationComponent{ 
	
	
	private IInformationManager informationManager;
   
   
 	public IInformationManager getInformationManager() {
		return informationManager;
	}

	public void setInformationManager(IInformationManager informationManager) {
		this.informationManager = informationManager;
	}
  
 	/**
	 * 创建 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public Information createInformation(Information information) throws SQLException{
	
		return informationManager.createInformation(information);
	}
	/**
	 * 删除 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformation(long id){
	
		return informationManager.deleteInformation(id);
	}
	
	
	/**
	 * 修改 资讯中心
	 * @param id
	 * @return updated count 
	 */
	public int updateInformation(Information information){
		return informationManager.updateInformation(information);
	
	}

		
	/**
	 * 修改 资讯中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationIgnoreNull(Information information){
			return informationManager.updateInformationIgnoreNull(information);
	
	}
	
	/**
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String where, String orderby,int limit,int offset){
		return informationManager.findAllInformation(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 资讯中心
	 * @param id
	 * @return
	 */
	public Information findInformation(long id){
		return informationManager.findInformation(id);
	}
	
	/** 
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformation(String where, String orderby,PageInfo pageinfo){
		return informationManager.findAllInformation(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找资讯中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String sql,int limit,int offset){
		return informationManager.findAllInformation(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 资讯中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationBySql(String sql){
		return informationManager.excuteInformationBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationBySql(String sql){
		return informationManager.countInformationBySql(sql);
	}
}

