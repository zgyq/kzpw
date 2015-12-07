/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rzhixiao;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RzhixiaoComponent   implements IRzhixiaoComponent{ 
	
	
	private IRzhixiaoManager rzhixiaoManager;
   
   
 	public IRzhixiaoManager getRzhixiaoManager() {
		return rzhixiaoManager;
	}

	public void setRzhixiaoManager(IRzhixiaoManager rzhixiaoManager) {
		this.rzhixiaoManager = rzhixiaoManager;
	}
  
 	/**
	 * 创建 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rzhixiao createRzhixiao(Rzhixiao rzhixiao) throws SQLException{
	
		return rzhixiaoManager.createRzhixiao(rzhixiao);
	}
	/**
	 * 删除 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRzhixiao(long id){
	
		return rzhixiaoManager.deleteRzhixiao(id);
	}
	
	
	/**
	 * 修改 直销汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRzhixiao(Rzhixiao rzhixiao){
		return rzhixiaoManager.updateRzhixiao(rzhixiao);
	
	}

		
	/**
	 * 修改 直销汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRzhixiaoIgnoreNull(Rzhixiao rzhixiao){
			return rzhixiaoManager.updateRzhixiaoIgnoreNull(rzhixiao);
	
	}
	
	/**
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,int limit,int offset){
		return rzhixiaoManager.findAllRzhixiao(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 直销汇总表
	 * @param id
	 * @return
	 */
	public Rzhixiao findRzhixiao(long id){
		return rzhixiaoManager.findRzhixiao(id);
	}
	
	/** 
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,PageInfo pageinfo){
		return rzhixiaoManager.findAllRzhixiao(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找直销汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String sql,int limit,int offset){
		return rzhixiaoManager.findAllRzhixiao(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 直销汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRzhixiaoBySql(String sql){
		return rzhixiaoManager.excuteRzhixiaoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRzhixiaoBySql(String sql){
		return rzhixiaoManager.countRzhixiaoBySql(sql);
	}
}

