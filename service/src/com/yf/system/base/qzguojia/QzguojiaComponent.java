/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzguojia;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class QzguojiaComponent   implements IQzguojiaComponent{ 
	
	
	private IQzguojiaManager qzguojiaManager;
   
   
 	public IQzguojiaManager getQzguojiaManager() {
		return qzguojiaManager;
	}

	public void setQzguojiaManager(IQzguojiaManager qzguojiaManager) {
		this.qzguojiaManager = qzguojiaManager;
	}
  
 	/**
	 * 创建 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public Qzguojia createQzguojia(Qzguojia qzguojia) throws SQLException{
	
		return qzguojiaManager.createQzguojia(qzguojia);
	}
	/**
	 * 删除 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzguojia(long id){
	
		return qzguojiaManager.deleteQzguojia(id);
	}
	
	
	/**
	 * 修改 签证国家
	 * @param id
	 * @return updated count 
	 */
	public int updateQzguojia(Qzguojia qzguojia){
		return qzguojiaManager.updateQzguojia(qzguojia);
	
	}

		
	/**
	 * 修改 签证国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzguojiaIgnoreNull(Qzguojia qzguojia){
			return qzguojiaManager.updateQzguojiaIgnoreNull(qzguojia);
	
	}
	
	/**
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,int limit,int offset){
		return qzguojiaManager.findAllQzguojia(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 签证国家
	 * @param id
	 * @return
	 */
	public Qzguojia findQzguojia(long id){
		return qzguojiaManager.findQzguojia(id);
	}
	
	/** 
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,PageInfo pageinfo){
		return qzguojiaManager.findAllQzguojia(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找签证国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String sql,int limit,int offset){
		return qzguojiaManager.findAllQzguojia(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 签证国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzguojiaBySql(String sql){
		return qzguojiaManager.excuteQzguojiaBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzguojiaBySql(String sql){
		return qzguojiaManager.countQzguojiaBySql(sql);
	}
}

