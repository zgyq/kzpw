/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.filecabindir;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FilecabindirComponent   implements IFilecabindirComponent{ 
	
	
	private IFilecabindirManager filecabindirManager;
   
   
 	public IFilecabindirManager getFilecabindirManager() {
		return filecabindirManager;
	}

	public void setFilecabindirManager(IFilecabindirManager filecabindirManager) {
		this.filecabindirManager = filecabindirManager;
	}
  
 	/**
	 * 创建 文件柜目录
	 * @param id
	 * @return deleted count 
	 */
	public Filecabindir createFilecabindir(Filecabindir filecabindir) throws SQLException{
	
		return filecabindirManager.createFilecabindir(filecabindir);
	}
	/**
	 * 删除 文件柜目录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFilecabindir(long id){
	
		return filecabindirManager.deleteFilecabindir(id);
	}
	
	
	/**
	 * 修改 文件柜目录
	 * @param id
	 * @return updated count 
	 */
	public int updateFilecabindir(Filecabindir filecabindir){
		return filecabindirManager.updateFilecabindir(filecabindir);
	
	}

		
	/**
	 * 修改 文件柜目录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFilecabindirIgnoreNull(Filecabindir filecabindir){
			return filecabindirManager.updateFilecabindirIgnoreNull(filecabindir);
	
	}
	
	/**
	 * 查找 文件柜目录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabindir(String where, String orderby,int limit,int offset){
		return filecabindirManager.findAllFilecabindir(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 文件柜目录
	 * @param id
	 * @return
	 */
	public Filecabindir findFilecabindir(long id){
		return filecabindirManager.findFilecabindir(id);
	}
	
	/** 
	 * 查找 文件柜目录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFilecabindir(String where, String orderby,PageInfo pageinfo){
		return filecabindirManager.findAllFilecabindir(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找文件柜目录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabindir(String sql,int limit,int offset){
		return filecabindirManager.findAllFilecabindir(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 文件柜目录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFilecabindirBySql(String sql){
		return filecabindirManager.excuteFilecabindirBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFilecabindirBySql(String sql){
		return filecabindirManager.countFilecabindirBySql(sql);
	}
}

