/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.liudianrefinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class LiudianrefinfoComponent   implements ILiudianrefinfoComponent{ 
	
	
	private ILiudianrefinfoManager liudianrefinfoManager;
   
   
 	public ILiudianrefinfoManager getLiudianrefinfoManager() {
		return liudianrefinfoManager;
	}

	public void setLiudianrefinfoManager(ILiudianrefinfoManager liudianrefinfoManager) {
		this.liudianrefinfoManager = liudianrefinfoManager;
	}
  
 	/**
	 * 创建 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrefinfo createLiudianrefinfo(Liudianrefinfo liudianrefinfo) throws SQLException{
	
		return liudianrefinfoManager.createLiudianrefinfo(liudianrefinfo);
	}
	/**
	 * 删除 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrefinfo(long id){
	
		return liudianrefinfoManager.deleteLiudianrefinfo(id);
	}
	
	
	/**
	 * 修改 留点设置关联表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrefinfo(Liudianrefinfo liudianrefinfo){
		return liudianrefinfoManager.updateLiudianrefinfo(liudianrefinfo);
	
	}

		
	/**
	 * 修改 留点设置关联表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrefinfoIgnoreNull(Liudianrefinfo liudianrefinfo){
			return liudianrefinfoManager.updateLiudianrefinfoIgnoreNull(liudianrefinfo);
	
	}
	
	/**
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,int limit,int offset){
		return liudianrefinfoManager.findAllLiudianrefinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 留点设置关联表
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfo(long id){
		return liudianrefinfoManager.findLiudianrefinfo(id);
	}
	/**
	 * 查找 留点设置关联表 by language
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfobylanguage(long id,Integer language){
		return liudianrefinfoManager.findLiudianrefinfobylanguage(id,language);
	}
	/** 
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,PageInfo pageinfo){
		return liudianrefinfoManager.findAllLiudianrefinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找留点设置关联表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String sql,int limit,int offset){
		return liudianrefinfoManager.findAllLiudianrefinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 留点设置关联表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrefinfoBySql(String sql){
		return liudianrefinfoManager.excuteLiudianrefinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrefinfoBySql(String sql){
		return liudianrefinfoManager.countLiudianrefinfoBySql(sql);
	}
}

