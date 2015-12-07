/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.jinribaobiao;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class JinribaobiaoComponent   implements IJinribaobiaoComponent{ 
	
	
	private IJinribaobiaoManager jinribaobiaoManager;
   
   
 	public IJinribaobiaoManager getJinribaobiaoManager() {
		return jinribaobiaoManager;
	}

	public void setJinribaobiaoManager(IJinribaobiaoManager jinribaobiaoManager) {
		this.jinribaobiaoManager = jinribaobiaoManager;
	}
  
 	/**
	 * 创建 今日报表
	 * @param id
	 * @return deleted count 
	 */
	public Jinribaobiao createJinribaobiao(Jinribaobiao jinribaobiao) throws SQLException{
	
		return jinribaobiaoManager.createJinribaobiao(jinribaobiao);
	}
	/**
	 * 删除 今日报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteJinribaobiao(long id){
	
		return jinribaobiaoManager.deleteJinribaobiao(id);
	}
	
	
	/**
	 * 修改 今日报表
	 * @param id
	 * @return updated count 
	 */
	public int updateJinribaobiao(Jinribaobiao jinribaobiao){
		return jinribaobiaoManager.updateJinribaobiao(jinribaobiao);
	
	}

		
	/**
	 * 修改 今日报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateJinribaobiaoIgnoreNull(Jinribaobiao jinribaobiao){
			return jinribaobiaoManager.updateJinribaobiaoIgnoreNull(jinribaobiao);
	
	}
	
	/**
	 * 查找 今日报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllJinribaobiao(String where, String orderby,int limit,int offset){
		return jinribaobiaoManager.findAllJinribaobiao(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 今日报表
	 * @param id
	 * @return
	 */
	public Jinribaobiao findJinribaobiao(long id){
		return jinribaobiaoManager.findJinribaobiao(id);
	}
	
	/** 
	 * 查找 今日报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllJinribaobiao(String where, String orderby,PageInfo pageinfo){
		return jinribaobiaoManager.findAllJinribaobiao(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找今日报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllJinribaobiao(String sql,int limit,int offset){
		return jinribaobiaoManager.findAllJinribaobiao(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 今日报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteJinribaobiaoBySql(String sql){
		return jinribaobiaoManager.excuteJinribaobiaoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countJinribaobiaoBySql(String sql){
		return jinribaobiaoManager.countJinribaobiaoBySql(sql);
	}
}

