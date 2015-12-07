/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.miscellaneous;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class MiscellaneousComponent   implements IMiscellaneousComponent{ 
	
	
	private IMiscellaneousManager miscellaneousManager;
   
   
 	public IMiscellaneousManager getMiscellaneousManager() {
		return miscellaneousManager;
	}

	public void setMiscellaneousManager(IMiscellaneousManager miscellaneousManager) {
		this.miscellaneousManager = miscellaneousManager;
	}
  
 	/**
	 * 创建 客户经理杂项列表
	 * @param id
	 * @return deleted count 
	 */
	public Miscellaneous createMiscellaneous(Miscellaneous miscellaneous) throws SQLException{
	
		return miscellaneousManager.createMiscellaneous(miscellaneous);
	}
	/**
	 * 删除 客户经理杂项列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMiscellaneous(long id){
	
		return miscellaneousManager.deleteMiscellaneous(id);
	}
	
	
	/**
	 * 修改 客户经理杂项列表
	 * @param id
	 * @return updated count 
	 */
	public int updateMiscellaneous(Miscellaneous miscellaneous){
		return miscellaneousManager.updateMiscellaneous(miscellaneous);
	
	}

		
	/**
	 * 修改 客户经理杂项列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMiscellaneousIgnoreNull(Miscellaneous miscellaneous){
			return miscellaneousManager.updateMiscellaneousIgnoreNull(miscellaneous);
	
	}
	
	/**
	 * 查找 客户经理杂项列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMiscellaneous(String where, String orderby,int limit,int offset){
		return miscellaneousManager.findAllMiscellaneous(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 客户经理杂项列表
	 * @param id
	 * @return
	 */
	public Miscellaneous findMiscellaneous(long id){
		return miscellaneousManager.findMiscellaneous(id);
	}
	
	/** 
	 * 查找 客户经理杂项列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMiscellaneous(String where, String orderby,PageInfo pageinfo){
		return miscellaneousManager.findAllMiscellaneous(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找客户经理杂项列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMiscellaneous(String sql,int limit,int offset){
		return miscellaneousManager.findAllMiscellaneous(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 客户经理杂项列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMiscellaneousBySql(String sql){
		return miscellaneousManager.excuteMiscellaneousBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMiscellaneousBySql(String sql){
		return miscellaneousManager.countMiscellaneousBySql(sql);
	}
}

