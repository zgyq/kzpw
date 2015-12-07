/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqinfonew;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class QqinfonewComponent   implements IQqinfonewComponent{ 
	
	
	private IQqinfonewManager qqinfonewManager;
   
   
 	public IQqinfonewManager getQqinfonewManager() {
		return qqinfonewManager;
	}

	public void setQqinfonewManager(IQqinfonewManager qqinfonewManager) {
		this.qqinfonewManager = qqinfonewManager;
	}
  
 	/**
	 * 创建 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfonew createQqinfonew(Qqinfonew qqinfonew) throws SQLException{
	
		return qqinfonewManager.createQqinfonew(qqinfonew);
	}
	/**
	 * 删除 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfonew(long id){
	
		return qqinfonewManager.deleteQqinfonew(id);
	}
	
	
	/**
	 * 修改 QQ号码
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfonew(Qqinfonew qqinfonew){
		return qqinfonewManager.updateQqinfonew(qqinfonew);
	
	}

		
	/**
	 * 修改 QQ号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfonewIgnoreNull(Qqinfonew qqinfonew){
			return qqinfonewManager.updateQqinfonewIgnoreNull(qqinfonew);
	
	}
	
	/**
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,int limit,int offset){
		return qqinfonewManager.findAllQqinfonew(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ号码
	 * @param id
	 * @return
	 */
	public Qqinfonew findQqinfonew(long id){
		return qqinfonewManager.findQqinfonew(id);
	}
	
	/** 
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,PageInfo pageinfo){
		return qqinfonewManager.findAllQqinfonew(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String sql,int limit,int offset){
		return qqinfonewManager.findAllQqinfonew(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfonewBySql(String sql){
		return qqinfonewManager.excuteQqinfonewBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfonewBySql(String sql){
		return qqinfonewManager.countQqinfonewBySql(sql);
	}
}

