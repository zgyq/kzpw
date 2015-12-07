/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insuranceinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class InsuranceinfoComponent   implements IInsuranceinfoComponent{ 
	
	
	private IInsuranceinfoManager insuranceinfoManager;
   
   
 	public IInsuranceinfoManager getInsuranceinfoManager() {
		return insuranceinfoManager;
	}

	public void setInsuranceinfoManager(IInsuranceinfoManager insuranceinfoManager) {
		this.insuranceinfoManager = insuranceinfoManager;
	}
  
 	/**
	 * 创建 保险
	 * @param id
	 * @return deleted count 
	 */
	public Insuranceinfo createInsuranceinfo(Insuranceinfo insuranceinfo) throws SQLException{
	
		return insuranceinfoManager.createInsuranceinfo(insuranceinfo);
	}
	/**
	 * 删除 保险
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsuranceinfo(long id){
	
		return insuranceinfoManager.deleteInsuranceinfo(id);
	}
	
	
	/**
	 * 修改 保险
	 * @param id
	 * @return updated count 
	 */
	public int updateInsuranceinfo(Insuranceinfo insuranceinfo){
		return insuranceinfoManager.updateInsuranceinfo(insuranceinfo);
	
	}

		
	/**
	 * 修改 保险但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsuranceinfoIgnoreNull(Insuranceinfo insuranceinfo){
			return insuranceinfoManager.updateInsuranceinfoIgnoreNull(insuranceinfo);
	
	}
	
	/**
	 * 查找 保险
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuranceinfo(String where, String orderby,int limit,int offset){
		return insuranceinfoManager.findAllInsuranceinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 保险
	 * @param id
	 * @return
	 */
	public Insuranceinfo findInsuranceinfo(long id){
		return insuranceinfoManager.findInsuranceinfo(id);
	}
	
	/** 
	 * 查找 保险
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsuranceinfo(String where, String orderby,PageInfo pageinfo){
		return insuranceinfoManager.findAllInsuranceinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找保险
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuranceinfo(String sql,int limit,int offset){
		return insuranceinfoManager.findAllInsuranceinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 保险
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsuranceinfoBySql(String sql){
		return insuranceinfoManager.excuteInsuranceinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsuranceinfoBySql(String sql){
		return insuranceinfoManager.countInsuranceinfoBySql(sql);
	}
}

