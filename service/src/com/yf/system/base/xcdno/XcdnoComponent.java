/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdno;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class XcdnoComponent   implements IXcdnoComponent{ 
	
	
	private IXcdnoManager xcdnoManager;
   
   
 	public IXcdnoManager getXcdnoManager() {
		return xcdnoManager;
	}

	public void setXcdnoManager(IXcdnoManager xcdnoManager) {
		this.xcdnoManager = xcdnoManager;
	}
  
 	/**
	 * 创建 行程单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdno createXcdno(Xcdno xcdno) throws SQLException{
	
		return xcdnoManager.createXcdno(xcdno);
	}
	/**
	 * 删除 行程单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdno(long id){
	
		return xcdnoManager.deleteXcdno(id);
	}
	
	
	/**
	 * 修改 行程单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdno(Xcdno xcdno){
		return xcdnoManager.updateXcdno(xcdno);
	
	}

		
	/**
	 * 修改 行程单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdnoIgnoreNull(Xcdno xcdno){
			return xcdnoManager.updateXcdnoIgnoreNull(xcdno);
	
	}
	
	/**
	 * 查找 行程单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdno(String where, String orderby,int limit,int offset){
		return xcdnoManager.findAllXcdno(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单
	 * @param id
	 * @return
	 */
	public Xcdno findXcdno(long id){
		return xcdnoManager.findXcdno(id);
	}
	
	/** 
	 * 查找 行程单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdno(String where, String orderby,PageInfo pageinfo){
		return xcdnoManager.findAllXcdno(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdno(String sql,int limit,int offset){
		return xcdnoManager.findAllXcdno(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdnoBySql(String sql){
		return xcdnoManager.excuteXcdnoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdnoBySql(String sql){
		return xcdnoManager.countXcdnoBySql(sql);
	}
}

