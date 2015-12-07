/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fguest;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FguestComponent   implements IFguestComponent{ 
	
	
	private IFguestManager fguestManager;
   
   
 	public IFguestManager getFguestManager() {
		return fguestManager;
	}

	public void setFguestManager(IFguestManager fguestManager) {
		this.fguestManager = fguestManager;
	}
  
 	/**
	 * 创建 国际机票乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Fguest createFguest(Fguest fguest) throws SQLException{
	
		return fguestManager.createFguest(fguest);
	}
	/**
	 * 删除 国际机票乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFguest(long id){
	
		return fguestManager.deleteFguest(id);
	}
	
	
	/**
	 * 修改 国际机票乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updateFguest(Fguest fguest){
		return fguestManager.updateFguest(fguest);
	
	}

		
	/**
	 * 修改 国际机票乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFguestIgnoreNull(Fguest fguest){
			return fguestManager.updateFguestIgnoreNull(fguest);
	
	}
	
	/**
	 * 查找 国际机票乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String where, String orderby,int limit,int offset){
		return fguestManager.findAllFguest(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票乘机人表
	 * @param id
	 * @return
	 */
	public Fguest findFguest(long id){
		return fguestManager.findFguest(id);
	}
	
	/** 
	 * 查找 国际机票乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFguest(String where, String orderby,PageInfo pageinfo){
		return fguestManager.findAllFguest(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String sql,int limit,int offset){
		return fguestManager.findAllFguest(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFguestBySql(String sql){
		return fguestManager.excuteFguestBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFguestBySql(String sql){
		return fguestManager.countFguestBySql(sql);
	}
}

