/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.kweisq;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class KweisqComponent   implements IKweisqComponent{ 
	
	
	private IKweisqManager kweisqManager;
   
   
 	public IKweisqManager getKweisqManager() {
		return kweisqManager;
	}

	public void setKweisqManager(IKweisqManager kweisqManager) {
		this.kweisqManager = kweisqManager;
	}
  
 	/**
	 * 创建 K位特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Kweisq createKweisq(Kweisq kweisq) throws SQLException{
	
		return kweisqManager.createKweisq(kweisq);
	}
	/**
	 * 删除 K位特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteKweisq(long id){
	
		return kweisqManager.deleteKweisq(id);
	}
	
	
	/**
	 * 修改 K位特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateKweisq(Kweisq kweisq){
		return kweisqManager.updateKweisq(kweisq);
	
	}

		
	/**
	 * 修改 K位特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateKweisqIgnoreNull(Kweisq kweisq){
			return kweisqManager.updateKweisqIgnoreNull(kweisq);
	
	}
	
	/**
	 * 查找 K位特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweisq(String where, String orderby,int limit,int offset){
		return kweisqManager.findAllKweisq(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 K位特价申请表
	 * @param id
	 * @return
	 */
	public Kweisq findKweisq(long id){
		return kweisqManager.findKweisq(id);
	}
	
	/** 
	 * 查找 K位特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllKweisq(String where, String orderby,PageInfo pageinfo){
		return kweisqManager.findAllKweisq(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找K位特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweisq(String sql,int limit,int offset){
		return kweisqManager.findAllKweisq(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql K位特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteKweisqBySql(String sql){
		return kweisqManager.excuteKweisqBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countKweisqBySql(String sql){
		return kweisqManager.countKweisqBySql(sql);
	}
}

