/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.informationinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class InformationinfoComponent   implements IInformationinfoComponent{ 
	
	
	private IInformationinfoManager informationinfoManager;
   
   
 	public IInformationinfoManager getInformationinfoManager() {
		return informationinfoManager;
	}

	public void setInformationinfoManager(IInformationinfoManager informationinfoManager) {
		this.informationinfoManager = informationinfoManager;
	}
  
 	/**
	 * 创建 资讯中心详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Informationinfo createInformationinfo(Informationinfo informationinfo) throws SQLException{
	
		return informationinfoManager.createInformationinfo(informationinfo);
	}
	/**
	 * 删除 资讯中心详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformationinfo(long id){
	
		return informationinfoManager.deleteInformationinfo(id);
	}
	
	
	/**
	 * 修改 资讯中心详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInformationinfo(Informationinfo informationinfo){
		return informationinfoManager.updateInformationinfo(informationinfo);
	
	}

		
	/**
	 * 修改 资讯中心详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationinfoIgnoreNull(Informationinfo informationinfo){
			return informationinfoManager.updateInformationinfoIgnoreNull(informationinfo);
	
	}
	
	/**
	 * 查找 资讯中心详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationinfo(String where, String orderby,int limit,int offset){
		return informationinfoManager.findAllInformationinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 资讯中心详细信息
	 * @param id
	 * @return
	 */
	public Informationinfo findInformationinfo(long id){
		return informationinfoManager.findInformationinfo(id);
	}
	
	/** 
	 * 查找 资讯中心详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformationinfo(String where, String orderby,PageInfo pageinfo){
		return informationinfoManager.findAllInformationinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找资讯中心详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationinfo(String sql,int limit,int offset){
		return informationinfoManager.findAllInformationinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 资讯中心详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationinfoBySql(String sql){
		return informationinfoManager.excuteInformationinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationinfoBySql(String sql){
		return informationinfoManager.countInformationinfoBySql(sql);
	}
}

