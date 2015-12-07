/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.kweifabu;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class KweifabuComponent   implements IKweifabuComponent{ 
	
	
	private IKweifabuManager kweifabuManager;
   
   
 	public IKweifabuManager getKweifabuManager() {
		return kweifabuManager;
	}

	public void setKweifabuManager(IKweifabuManager kweifabuManager) {
		this.kweifabuManager = kweifabuManager;
	}
  
 	/**
	 * 创建 K位特价发布表
	 * @param id
	 * @return deleted count 
	 */
	public Kweifabu createKweifabu(Kweifabu kweifabu) throws SQLException{
	
		return kweifabuManager.createKweifabu(kweifabu);
	}
	/**
	 * 删除 K位特价发布表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteKweifabu(long id){
	
		return kweifabuManager.deleteKweifabu(id);
	}
	
	
	/**
	 * 修改 K位特价发布表
	 * @param id
	 * @return updated count 
	 */
	public int updateKweifabu(Kweifabu kweifabu){
		return kweifabuManager.updateKweifabu(kweifabu);
	
	}

		
	/**
	 * 修改 K位特价发布表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateKweifabuIgnoreNull(Kweifabu kweifabu){
			return kweifabuManager.updateKweifabuIgnoreNull(kweifabu);
	
	}
	
	/**
	 * 查找 K位特价发布表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweifabu(String where, String orderby,int limit,int offset){
		return kweifabuManager.findAllKweifabu(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 K位特价发布表
	 * @param id
	 * @return
	 */
	public Kweifabu findKweifabu(long id){
		return kweifabuManager.findKweifabu(id);
	}
	
	/** 
	 * 查找 K位特价发布表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllKweifabu(String where, String orderby,PageInfo pageinfo){
		return kweifabuManager.findAllKweifabu(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找K位特价发布表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweifabu(String sql,int limit,int offset){
		return kweifabuManager.findAllKweifabu(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql K位特价发布表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteKweifabuBySql(String sql){
		return kweifabuManager.excuteKweifabuBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countKweifabuBySql(String sql){
		return kweifabuManager.countKweifabuBySql(sql);
	}
}

