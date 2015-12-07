/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ympay;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class YmpayComponent   implements IYmpayComponent{ 
	
	
	private IYmpayManager ympayManager;
   
   
 	public IYmpayManager getYmpayManager() {
		return ympayManager;
	}

	public void setYmpayManager(IYmpayManager ympayManager) {
		this.ympayManager = ympayManager;
	}
  
 	/**
	 * 创建 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Ympay createYmpay(Ympay ympay) throws SQLException{
	
		return ympayManager.createYmpay(ympay);
	}
	/**
	 * 删除 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmpay(long id){
	
		return ympayManager.deleteYmpay(id);
	}
	
	
	/**
	 * 修改 短信充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateYmpay(Ympay ympay){
		return ympayManager.updateYmpay(ympay);
	
	}

		
	/**
	 * 修改 短信充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmpayIgnoreNull(Ympay ympay){
			return ympayManager.updateYmpayIgnoreNull(ympay);
	
	}
	
	/**
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,int limit,int offset){
		return ympayManager.findAllYmpay(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信充值记录
	 * @param id
	 * @return
	 */
	public Ympay findYmpay(long id){
		return ympayManager.findYmpay(id);
	}
	
	/** 
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,PageInfo pageinfo){
		return ympayManager.findAllYmpay(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String sql,int limit,int offset){
		return ympayManager.findAllYmpay(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmpayBySql(String sql){
		return ympayManager.excuteYmpayBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmpayBySql(String sql){
		return ympayManager.countYmpayBySql(sql);
	}
}

