/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fsendticketcity;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FsendticketcityComponent   implements IFsendticketcityComponent{ 
	
	
	private IFsendticketcityManager fsendticketcityManager;
   
   
 	public IFsendticketcityManager getFsendticketcityManager() {
		return fsendticketcityManager;
	}

	public void setFsendticketcityManager(IFsendticketcityManager fsendticketcityManager) {
		this.fsendticketcityManager = fsendticketcityManager;
	}
  
 	/**
	 * 创建 国际机票送票城市
	 * @param id
	 * @return deleted count 
	 */
	public Fsendticketcity createFsendticketcity(Fsendticketcity fsendticketcity) throws SQLException{
	
		return fsendticketcityManager.createFsendticketcity(fsendticketcity);
	}
	/**
	 * 删除 国际机票送票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFsendticketcity(long id){
	
		return fsendticketcityManager.deleteFsendticketcity(id);
	}
	
	
	/**
	 * 修改 国际机票送票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateFsendticketcity(Fsendticketcity fsendticketcity){
		return fsendticketcityManager.updateFsendticketcity(fsendticketcity);
	
	}

		
	/**
	 * 修改 国际机票送票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFsendticketcityIgnoreNull(Fsendticketcity fsendticketcity){
			return fsendticketcityManager.updateFsendticketcityIgnoreNull(fsendticketcity);
	
	}
	
	/**
	 * 查找 国际机票送票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,int limit,int offset){
		return fsendticketcityManager.findAllFsendticketcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票送票城市
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcity(long id){
		return fsendticketcityManager.findFsendticketcity(id);
	}
	/**
	 * 查找 国际机票送票城市 by language
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcitybylanguage(long id,Integer language){
		return fsendticketcityManager.findFsendticketcitybylanguage(id,language);
	}
	/** 
	 * 查找 国际机票送票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,PageInfo pageinfo){
		return fsendticketcityManager.findAllFsendticketcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票送票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String sql,int limit,int offset){
		return fsendticketcityManager.findAllFsendticketcity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票送票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFsendticketcityBySql(String sql){
		return fsendticketcityManager.excuteFsendticketcityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFsendticketcityBySql(String sql){
		return fsendticketcityManager.countFsendticketcityBySql(sql);
	}
}

