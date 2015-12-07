/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starrecord;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class StarrecordComponent   implements IStarrecordComponent{ 
	
	
	private IStarrecordManager starrecordManager;
   
   
 	public IStarrecordManager getStarrecordManager() {
		return starrecordManager;
	}

	public void setStarrecordManager(IStarrecordManager starrecordManager) {
		this.starrecordManager = starrecordManager;
	}
  
 	/**
	 * 创建 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public Starrecord createStarrecord(Starrecord starrecord) throws SQLException{
	
		return starrecordManager.createStarrecord(starrecord);
	}
	/**
	 * 删除 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarrecord(long id){
	
		return starrecordManager.deleteStarrecord(id);
	}
	
	
	/**
	 * 修改 星级留点记录
	 * @param id
	 * @return updated count 
	 */
	public int updateStarrecord(Starrecord starrecord){
		return starrecordManager.updateStarrecord(starrecord);
	
	}

		
	/**
	 * 修改 星级留点记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarrecordIgnoreNull(Starrecord starrecord){
			return starrecordManager.updateStarrecordIgnoreNull(starrecord);
	
	}
	
	/**
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,int limit,int offset){
		return starrecordManager.findAllStarrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 星级留点记录
	 * @param id
	 * @return
	 */
	public Starrecord findStarrecord(long id){
		return starrecordManager.findStarrecord(id);
	}
	
	/** 
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,PageInfo pageinfo){
		return starrecordManager.findAllStarrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找星级留点记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String sql,int limit,int offset){
		return starrecordManager.findAllStarrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 星级留点记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarrecordBySql(String sql){
		return starrecordManager.excuteStarrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarrecordBySql(String sql){
		return starrecordManager.countStarrecordBySql(sql);
	}
}

