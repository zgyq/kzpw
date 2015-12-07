/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.prizeinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class PrizeinfoComponent   implements IPrizeinfoComponent{ 
	
	
	private IPrizeinfoManager prizeinfoManager;
   
   
 	public IPrizeinfoManager getPrizeinfoManager() {
		return prizeinfoManager;
	}

	public void setPrizeinfoManager(IPrizeinfoManager prizeinfoManager) {
		this.prizeinfoManager = prizeinfoManager;
	}
  
 	/**
	 * 创建 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public Prizeinfo createPrizeinfo(Prizeinfo prizeinfo) throws SQLException{
	
		return prizeinfoManager.createPrizeinfo(prizeinfo);
	}
	/**
	 * 删除 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizeinfo(long id){
	
		return prizeinfoManager.deletePrizeinfo(id);
	}
	
	
	/**
	 * 修改 积分礼品信息
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizeinfo(Prizeinfo prizeinfo){
		return prizeinfoManager.updatePrizeinfo(prizeinfo);
	
	}

		
	/**
	 * 修改 积分礼品信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizeinfoIgnoreNull(Prizeinfo prizeinfo){
			return prizeinfoManager.updatePrizeinfoIgnoreNull(prizeinfo);
	
	}
	
	/**
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,int limit,int offset){
		return prizeinfoManager.findAllPrizeinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分礼品信息
	 * @param id
	 * @return
	 */
	public Prizeinfo findPrizeinfo(long id){
		return prizeinfoManager.findPrizeinfo(id);
	}
	
	/** 
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,PageInfo pageinfo){
		return prizeinfoManager.findAllPrizeinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分礼品信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String sql,int limit,int offset){
		return prizeinfoManager.findAllPrizeinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分礼品信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizeinfoBySql(String sql){
		return prizeinfoManager.excutePrizeinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizeinfoBySql(String sql){
		return prizeinfoManager.countPrizeinfoBySql(sql);
	}
}

