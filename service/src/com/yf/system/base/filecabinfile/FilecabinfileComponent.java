/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.filecabinfile;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FilecabinfileComponent   implements IFilecabinfileComponent{ 
	
	
	private IFilecabinfileManager filecabinfileManager;
   
   
 	public IFilecabinfileManager getFilecabinfileManager() {
		return filecabinfileManager;
	}

	public void setFilecabinfileManager(IFilecabinfileManager filecabinfileManager) {
		this.filecabinfileManager = filecabinfileManager;
	}
  
 	/**
	 * 创建 文件
	 * @param id
	 * @return deleted count 
	 */
	public Filecabinfile createFilecabinfile(Filecabinfile filecabinfile) throws SQLException{
	
		return filecabinfileManager.createFilecabinfile(filecabinfile);
	}
	/**
	 * 删除 文件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFilecabinfile(long id){
	
		return filecabinfileManager.deleteFilecabinfile(id);
	}
	
	
	/**
	 * 修改 文件
	 * @param id
	 * @return updated count 
	 */
	public int updateFilecabinfile(Filecabinfile filecabinfile){
		return filecabinfileManager.updateFilecabinfile(filecabinfile);
	
	}

		
	/**
	 * 修改 文件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFilecabinfileIgnoreNull(Filecabinfile filecabinfile){
			return filecabinfileManager.updateFilecabinfileIgnoreNull(filecabinfile);
	
	}
	
	/**
	 * 查找 文件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabinfile(String where, String orderby,int limit,int offset){
		return filecabinfileManager.findAllFilecabinfile(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 文件
	 * @param id
	 * @return
	 */
	public Filecabinfile findFilecabinfile(long id){
		return filecabinfileManager.findFilecabinfile(id);
	}
	
	/** 
	 * 查找 文件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFilecabinfile(String where, String orderby,PageInfo pageinfo){
		return filecabinfileManager.findAllFilecabinfile(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找文件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabinfile(String sql,int limit,int offset){
		return filecabinfileManager.findAllFilecabinfile(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 文件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFilecabinfileBySql(String sql){
		return filecabinfileManager.excuteFilecabinfileBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFilecabinfileBySql(String sql){
		return filecabinfileManager.countFilecabinfileBySql(sql);
	}
}

