/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineimg;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpotlineimgComponent   implements ISpotlineimgComponent{ 
	
	
	private ISpotlineimgManager spotlineimgManager;
   
   
 	public ISpotlineimgManager getSpotlineimgManager() {
		return spotlineimgManager;
	}

	public void setSpotlineimgManager(ISpotlineimgManager spotlineimgManager) {
		this.spotlineimgManager = spotlineimgManager;
	}
  
 	/**
	 * 创建 景区线路图片信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineimg createSpotlineimg(Spotlineimg spotlineimg) throws SQLException{
	
		return spotlineimgManager.createSpotlineimg(spotlineimg);
	}
	/**
	 * 删除 景区线路图片信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineimg(long id){
	
		return spotlineimgManager.deleteSpotlineimg(id);
	}
	
	
	/**
	 * 修改 景区线路图片信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineimg(Spotlineimg spotlineimg){
		return spotlineimgManager.updateSpotlineimg(spotlineimg);
	
	}

		
	/**
	 * 修改 景区线路图片信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineimgIgnoreNull(Spotlineimg spotlineimg){
			return spotlineimgManager.updateSpotlineimgIgnoreNull(spotlineimg);
	
	}
	
	/**
	 * 查找 景区线路图片信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimg(String where, String orderby,int limit,int offset){
		return spotlineimgManager.findAllSpotlineimg(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路图片信息
	 * @param id
	 * @return
	 */
	public Spotlineimg findSpotlineimg(long id){
		return spotlineimgManager.findSpotlineimg(id);
	}
	
	/** 
	 * 查找 景区线路图片信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineimg(String where, String orderby,PageInfo pageinfo){
		return spotlineimgManager.findAllSpotlineimg(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路图片信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimg(String sql,int limit,int offset){
		return spotlineimgManager.findAllSpotlineimg(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路图片信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineimgBySql(String sql){
		return spotlineimgManager.excuteSpotlineimgBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineimgBySql(String sql){
		return spotlineimgManager.countSpotlineimgBySql(sql);
	}
}

