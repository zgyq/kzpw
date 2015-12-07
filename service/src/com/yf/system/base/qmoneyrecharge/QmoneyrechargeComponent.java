/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qmoneyrecharge;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class QmoneyrechargeComponent   implements IQmoneyrechargeComponent{ 
	
	
	private IQmoneyrechargeManager qmoneyrechargeManager;
   
   
 	public IQmoneyrechargeManager getQmoneyrechargeManager() {
		return qmoneyrechargeManager;
	}

	public void setQmoneyrechargeManager(IQmoneyrechargeManager qmoneyrechargeManager) {
		this.qmoneyrechargeManager = qmoneyrechargeManager;
	}
  
 	/**
	 * 创建 Q币充值表
	 * @param id
	 * @return deleted count 
	 */
	public Qmoneyrecharge createQmoneyrecharge(Qmoneyrecharge qmoneyrecharge) throws SQLException{
	
		return qmoneyrechargeManager.createQmoneyrecharge(qmoneyrecharge);
	}
	/**
	 * 删除 Q币充值表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQmoneyrecharge(long id){
	
		return qmoneyrechargeManager.deleteQmoneyrecharge(id);
	}
	
	
	/**
	 * 修改 Q币充值表
	 * @param id
	 * @return updated count 
	 */
	public int updateQmoneyrecharge(Qmoneyrecharge qmoneyrecharge){
		return qmoneyrechargeManager.updateQmoneyrecharge(qmoneyrecharge);
	
	}

		
	/**
	 * 修改 Q币充值表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQmoneyrechargeIgnoreNull(Qmoneyrecharge qmoneyrecharge){
			return qmoneyrechargeManager.updateQmoneyrechargeIgnoreNull(qmoneyrecharge);
	
	}
	
	/**
	 * 查找 Q币充值表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmoneyrecharge(String where, String orderby,int limit,int offset){
		return qmoneyrechargeManager.findAllQmoneyrecharge(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 Q币充值表
	 * @param id
	 * @return
	 */
	public Qmoneyrecharge findQmoneyrecharge(long id){
		return qmoneyrechargeManager.findQmoneyrecharge(id);
	}
	
	/** 
	 * 查找 Q币充值表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQmoneyrecharge(String where, String orderby,PageInfo pageinfo){
		return qmoneyrechargeManager.findAllQmoneyrecharge(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找Q币充值表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmoneyrecharge(String sql,int limit,int offset){
		return qmoneyrechargeManager.findAllQmoneyrecharge(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql Q币充值表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQmoneyrechargeBySql(String sql){
		return qmoneyrechargeManager.excuteQmoneyrechargeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQmoneyrechargeBySql(String sql){
		return qmoneyrechargeManager.countQmoneyrechargeBySql(sql);
	}
}

