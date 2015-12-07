/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.huodonguser;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HuodonguserComponent   implements IHuodonguserComponent{ 
	
	
	private IHuodonguserManager huodonguserManager;
   
   
 	public IHuodonguserManager getHuodonguserManager() {
		return huodonguserManager;
	}

	public void setHuodonguserManager(IHuodonguserManager huodonguserManager) {
		this.huodonguserManager = huodonguserManager;
	}
  
 	/**
	 * 创建 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public Huodonguser createHuodonguser(Huodonguser huodonguser) throws SQLException{
	
		return huodonguserManager.createHuodonguser(huodonguser);
	}
	/**
	 * 删除 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHuodonguser(long id){
	
		return huodonguserManager.deleteHuodonguser(id);
	}
	
	
	/**
	 * 修改 活动会员
	 * @param id
	 * @return updated count 
	 */
	public int updateHuodonguser(Huodonguser huodonguser){
		return huodonguserManager.updateHuodonguser(huodonguser);
	
	}

		
	/**
	 * 修改 活动会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHuodonguserIgnoreNull(Huodonguser huodonguser){
			return huodonguserManager.updateHuodonguserIgnoreNull(huodonguser);
	
	}
	
	/**
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,int limit,int offset){
		return huodonguserManager.findAllHuodonguser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 活动会员
	 * @param id
	 * @return
	 */
	public Huodonguser findHuodonguser(long id){
		return huodonguserManager.findHuodonguser(id);
	}
	
	/** 
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,PageInfo pageinfo){
		return huodonguserManager.findAllHuodonguser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找活动会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String sql,int limit,int offset){
		return huodonguserManager.findAllHuodonguser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 活动会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHuodonguserBySql(String sql){
		return huodonguserManager.excuteHuodonguserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHuodonguserBySql(String sql){
		return huodonguserManager.countHuodonguserBySql(sql);
	}
}

