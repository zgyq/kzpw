/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymsend;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class YmsendComponent   implements IYmsendComponent{ 
	
	
	private IYmsendManager ymsendManager;
   
   
 	public IYmsendManager getYmsendManager() {
		return ymsendManager;
	}

	public void setYmsendManager(IYmsendManager ymsendManager) {
		this.ymsendManager = ymsendManager;
	}
  
 	/**
	 * 创建 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public Ymsend createYmsend(Ymsend ymsend) throws SQLException{
	
		return ymsendManager.createYmsend(ymsend);
	}
	/**
	 * 删除 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmsend(long id){
	
		return ymsendManager.deleteYmsend(id);
	}
	
	
	/**
	 * 修改 短信发送表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmsend(Ymsend ymsend){
		return ymsendManager.updateYmsend(ymsend);
	
	}

		
	/**
	 * 修改 短信发送表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmsendIgnoreNull(Ymsend ymsend){
			return ymsendManager.updateYmsendIgnoreNull(ymsend);
	
	}
	
	/**
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsend(String where, String orderby,int limit,int offset){
		return ymsendManager.findAllYmsend(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信发送表
	 * @param id
	 * @return
	 */
	public Ymsend findYmsend(long id){
		return ymsendManager.findYmsend(id);
	}
	
	/** 
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmsend(String where, String orderby,PageInfo pageinfo){
		return ymsendManager.findAllYmsend(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信发送表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsend(String sql,int limit,int offset){
		return ymsendManager.findAllYmsend(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信发送表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmsendBySql(String sql){
		return ymsendManager.excuteYmsendBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmsendBySql(String sql){
		return ymsendManager.countYmsendBySql(sql);
	}
}

