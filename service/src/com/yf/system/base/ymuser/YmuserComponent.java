/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymuser;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class YmuserComponent   implements IYmuserComponent{ 
	
	
	private IYmuserManager ymuserManager;
   
   
 	public IYmuserManager getYmuserManager() {
		return ymuserManager;
	}

	public void setYmuserManager(IYmuserManager ymuserManager) {
		this.ymuserManager = ymuserManager;
	}
  
 	/**
	 * 创建 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public Ymuser createYmuser(Ymuser ymuser) throws SQLException{
	
		return ymuserManager.createYmuser(ymuser);
	}
	/**
	 * 删除 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmuser(long id){
	
		return ymuserManager.deleteYmuser(id);
	}
	
	
	/**
	 * 修改 短信用户账号
	 * @param id
	 * @return updated count 
	 */
	public int updateYmuser(Ymuser ymuser){
		return ymuserManager.updateYmuser(ymuser);
	
	}

		
	/**
	 * 修改 短信用户账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmuserIgnoreNull(Ymuser ymuser){
			return ymuserManager.updateYmuserIgnoreNull(ymuser);
	
	}
	
	/**
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,int limit,int offset){
		return ymuserManager.findAllYmuser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信用户账号
	 * @param id
	 * @return
	 */
	public Ymuser findYmuser(long id){
		return ymuserManager.findYmuser(id);
	}
	
	/** 
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,PageInfo pageinfo){
		return ymuserManager.findAllYmuser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信用户账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String sql,int limit,int offset){
		return ymuserManager.findAllYmuser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信用户账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmuserBySql(String sql){
		return ymuserManager.excuteYmuserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmuserBySql(String sql){
		return ymuserManager.countYmuserBySql(sql);
	}
}

