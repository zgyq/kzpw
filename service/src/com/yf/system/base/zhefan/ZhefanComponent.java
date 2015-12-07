/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.zhefan;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ZhefanComponent   implements IZhefanComponent{ 
	
	
	private IZhefanManager zhefanManager;
   
   
 	public IZhefanManager getZhefanManager() {
		return zhefanManager;
	}

	public void setZhefanManager(IZhefanManager zhefanManager) {
		this.zhefanManager = zhefanManager;
	}
  
 	/**
	 * 创建 折返
	 * @param id
	 * @return deleted count 
	 */
	public Zhefan createZhefan(Zhefan zhefan) throws SQLException{
	
		return zhefanManager.createZhefan(zhefan);
	}
	/**
	 * 删除 折返
	 * @param id
	 * @return deleted count 
	 */
	public int deleteZhefan(long id){
	
		return zhefanManager.deleteZhefan(id);
	}
	
	
	/**
	 * 修改 折返
	 * @param id
	 * @return updated count 
	 */
	public int updateZhefan(Zhefan zhefan){
		return zhefanManager.updateZhefan(zhefan);
	
	}

		
	/**
	 * 修改 折返但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateZhefanIgnoreNull(Zhefan zhefan){
			return zhefanManager.updateZhefanIgnoreNull(zhefan);
	
	}
	
	/**
	 * 查找 折返
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZhefan(String where, String orderby,int limit,int offset){
		return zhefanManager.findAllZhefan(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 折返
	 * @param id
	 * @return
	 */
	public Zhefan findZhefan(long id){
		return zhefanManager.findZhefan(id);
	}
	
	/** 
	 * 查找 折返
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllZhefan(String where, String orderby,PageInfo pageinfo){
		return zhefanManager.findAllZhefan(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找折返
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZhefan(String sql,int limit,int offset){
		return zhefanManager.findAllZhefan(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 折返
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteZhefanBySql(String sql){
		return zhefanManager.excuteZhefanBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countZhefanBySql(String sql){
		return zhefanManager.countZhefanBySql(sql);
	}
}

