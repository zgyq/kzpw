/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.infotype;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class InfotypeComponent   implements IInfotypeComponent{ 
	
	
	private IInfotypeManager infotypeManager;
   
   
 	public IInfotypeManager getInfotypeManager() {
		return infotypeManager;
	}

	public void setInfotypeManager(IInfotypeManager infotypeManager) {
		this.infotypeManager = infotypeManager;
	}
  
 	/**
	 * 创建 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public Infotype createInfotype(Infotype infotype) throws SQLException{
	
		return infotypeManager.createInfotype(infotype);
	}
	/**
	 * 删除 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfotype(long id){
	
		return infotypeManager.deleteInfotype(id);
	}
	
	
	/**
	 * 修改 信息类型
	 * @param id
	 * @return updated count 
	 */
	public int updateInfotype(Infotype infotype){
		return infotypeManager.updateInfotype(infotype);
	
	}

		
	/**
	 * 修改 信息类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfotypeIgnoreNull(Infotype infotype){
			return infotypeManager.updateInfotypeIgnoreNull(infotype);
	
	}
	
	/**
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotype(String where, String orderby,int limit,int offset){
		return infotypeManager.findAllInfotype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 信息类型
	 * @param id
	 * @return
	 */
	public Infotype findInfotype(long id){
		return infotypeManager.findInfotype(id);
	}
	/**
	 * 查找 信息id
	 */
	public Long findInfoId(String typename){
		return null;
	}
	/** 
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfotype(String where, String orderby,PageInfo pageinfo){
		return infotypeManager.findAllInfotype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找信息类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotype(String sql,int limit,int offset){
		return infotypeManager.findAllInfotype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 信息类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfotypeBySql(String sql){
		return infotypeManager.excuteInfotypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfotypeBySql(String sql){
		return infotypeManager.countInfotypeBySql(sql);
	}
}

