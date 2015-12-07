/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqtypenew;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class QqtypenewComponent   implements IQqtypenewComponent{ 
	
	
	private IQqtypenewManager qqtypenewManager;
   
   
 	public IQqtypenewManager getQqtypenewManager() {
		return qqtypenewManager;
	}

	public void setQqtypenewManager(IQqtypenewManager qqtypenewManager) {
		this.qqtypenewManager = qqtypenewManager;
	}
  
 	/**
	 * 创建 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public Qqtypenew createQqtypenew(Qqtypenew qqtypenew) throws SQLException{
	
		return qqtypenewManager.createQqtypenew(qqtypenew);
	}
	/**
	 * 删除 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqtypenew(long id){
	
		return qqtypenewManager.deleteQqtypenew(id);
	}
	
	
	/**
	 * 修改 QQ类型
	 * @param id
	 * @return updated count 
	 */
	public int updateQqtypenew(Qqtypenew qqtypenew){
		return qqtypenewManager.updateQqtypenew(qqtypenew);
	
	}

		
	/**
	 * 修改 QQ类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqtypenewIgnoreNull(Qqtypenew qqtypenew){
			return qqtypenewManager.updateQqtypenewIgnoreNull(qqtypenew);
	
	}
	
	/**
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypenew(String where, String orderby,int limit,int offset){
		return qqtypenewManager.findAllQqtypenew(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ类型
	 * @param id
	 * @return
	 */
	public Qqtypenew findQqtypenew(long id){
		return qqtypenewManager.findQqtypenew(id);
	}
	
	/** 
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqtypenew(String where, String orderby,PageInfo pageinfo){
		return qqtypenewManager.findAllQqtypenew(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypenew(String sql,int limit,int offset){
		return qqtypenewManager.findAllQqtypenew(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqtypenewBySql(String sql){
		return qqtypenewManager.excuteQqtypenewBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqtypenewBySql(String sql){
		return qqtypenewManager.countQqtypenewBySql(sql);
	}
}

