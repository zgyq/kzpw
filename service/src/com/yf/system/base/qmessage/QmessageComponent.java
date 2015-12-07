/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qmessage;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class QmessageComponent   implements IQmessageComponent{ 
	
	
	private IQmessageManager qmessageManager;
   
   
 	public IQmessageManager getQmessageManager() {
		return qmessageManager;
	}

	public void setQmessageManager(IQmessageManager qmessageManager) {
		this.qmessageManager = qmessageManager;
	}
  
 	/**
	 * 创建 Q信箱
	 * @param id
	 * @return deleted count 
	 */
	public Qmessage createQmessage(Qmessage qmessage) throws SQLException{
	
		return qmessageManager.createQmessage(qmessage);
	}
	/**
	 * 删除 Q信箱
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQmessage(long id){
	
		return qmessageManager.deleteQmessage(id);
	}
	
	
	/**
	 * 修改 Q信箱
	 * @param id
	 * @return updated count 
	 */
	public int updateQmessage(Qmessage qmessage){
		return qmessageManager.updateQmessage(qmessage);
	
	}

		
	/**
	 * 修改 Q信箱但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQmessageIgnoreNull(Qmessage qmessage){
			return qmessageManager.updateQmessageIgnoreNull(qmessage);
	
	}
	
	/**
	 * 查找 Q信箱
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmessage(String where, String orderby,int limit,int offset){
		return qmessageManager.findAllQmessage(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 Q信箱
	 * @param id
	 * @return
	 */
	public Qmessage findQmessage(long id){
		return qmessageManager.findQmessage(id);
	}
	
	/** 
	 * 查找 Q信箱
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQmessage(String where, String orderby,PageInfo pageinfo){
		return qmessageManager.findAllQmessage(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找Q信箱
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmessage(String sql,int limit,int offset){
		return qmessageManager.findAllQmessage(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql Q信箱
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQmessageBySql(String sql){
		return qmessageManager.excuteQmessageBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQmessageBySql(String sql){
		return qmessageManager.countQmessageBySql(sql);
	}
}

