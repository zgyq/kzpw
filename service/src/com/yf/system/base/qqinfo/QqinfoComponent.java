/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class QqinfoComponent   implements IQqinfoComponent{ 
	
	
	private IQqinfoManager qqinfoManager;
   
   
 	public IQqinfoManager getQqinfoManager() {
		return qqinfoManager;
	}

	public void setQqinfoManager(IQqinfoManager qqinfoManager) {
		this.qqinfoManager = qqinfoManager;
	}
  
 	/**
	 * 创建 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfo createQqinfo(Qqinfo qqinfo) throws SQLException{
	
		return qqinfoManager.createQqinfo(qqinfo);
	}
	/**
	 * 删除 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfo(long id){
	
		return qqinfoManager.deleteQqinfo(id);
	}	
	
	/**
	 * 修改 QQ信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfo(Qqinfo qqinfo){
		return qqinfoManager.updateQqinfo(qqinfo);
	
	}

		
	/**
	 * 修改 QQ信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfoIgnoreNull(Qqinfo qqinfo){
			return qqinfoManager.updateQqinfoIgnoreNull(qqinfo);
	
	}
	
	/**
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,int limit,int offset){
		return qqinfoManager.findAllQqinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ信息表
	 * @param id
	 * @return
	 */
	public Qqinfo findQqinfo(long id){
		return qqinfoManager.findQqinfo(id);
	}
	
	/** 
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,PageInfo pageinfo){
		return qqinfoManager.findAllQqinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String sql,int limit,int offset){
		return qqinfoManager.findAllQqinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfoBySql(String sql){
		return qqinfoManager.excuteQqinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfoBySql(String sql){
		return qqinfoManager.countQqinfoBySql(sql);
	}
}

