/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.conferencehall;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ConferencehallComponent   implements IConferencehallComponent{ 
	
	
	private IConferencehallManager conferencehallManager;
   
   
 	public IConferencehallManager getConferencehallManager() {
		return conferencehallManager;
	}

	public void setConferencehallManager(IConferencehallManager conferencehallManager) {
		this.conferencehallManager = conferencehallManager;
	}
  
 	/**
	 * 创建 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehall createConferencehall(Conferencehall conferencehall) throws SQLException{
	
		return conferencehallManager.createConferencehall(conferencehall);
	}
	/**
	 * 删除 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehall(long id){
	
		return conferencehallManager.deleteConferencehall(id);
	}
	
	
	/**
	 * 修改 会议厅
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehall(Conferencehall conferencehall){
		return conferencehallManager.updateConferencehall(conferencehall);
	
	}

		
	/**
	 * 修改 会议厅但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehallIgnoreNull(Conferencehall conferencehall){
			return conferencehallManager.updateConferencehallIgnoreNull(conferencehall);
	
	}
	
	/**
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,int limit,int offset){
		return conferencehallManager.findAllConferencehall(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会议厅
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehall(long id){
		return conferencehallManager.findConferencehall(id);
	}
	/**
	 * 查找 会议厅 by language
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehallbylanguage(long id,Integer language){
		return conferencehallManager.findConferencehallbylanguage(id,language);
	}
	/** 
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,PageInfo pageinfo){
		return conferencehallManager.findAllConferencehall(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会议厅
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String sql,int limit,int offset){
		return conferencehallManager.findAllConferencehall(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会议厅
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehallBySql(String sql){
		return conferencehallManager.excuteConferencehallBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehallBySql(String sql){
		return conferencehallManager.countConferencehallBySql(sql);
	}
}

