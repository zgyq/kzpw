/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dcampaign;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class DcampaignComponent   implements IDcampaignComponent{ 
	
	
	private IDcampaignManager dcampaignManager;
   
   
 	public IDcampaignManager getDcampaignManager() {
		return dcampaignManager;
	}

	public void setDcampaignManager(IDcampaignManager dcampaignManager) {
		this.dcampaignManager = dcampaignManager;
	}
  
 	/**
	 * 创建 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public Dcampaign createDcampaign(Dcampaign dcampaign) throws SQLException{
	
		return dcampaignManager.createDcampaign(dcampaign);
	}
	/**
	 * 删除 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDcampaign(long id){
	
		return dcampaignManager.deleteDcampaign(id);
	}
	
	
	/**
	 * 修改 电子优惠卷活动
	 * @param id
	 * @return updated count 
	 */
	public int updateDcampaign(Dcampaign dcampaign){
		return dcampaignManager.updateDcampaign(dcampaign);
	
	}

		
	/**
	 * 修改 电子优惠卷活动但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDcampaignIgnoreNull(Dcampaign dcampaign){
			return dcampaignManager.updateDcampaignIgnoreNull(dcampaign);
	
	}
	
	/**
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,int limit,int offset){
		return dcampaignManager.findAllDcampaign(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 电子优惠卷活动
	 * @param id
	 * @return
	 */
	public Dcampaign findDcampaign(long id){
		return dcampaignManager.findDcampaign(id);
	}
	
	/** 
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,PageInfo pageinfo){
		return dcampaignManager.findAllDcampaign(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找电子优惠卷活动
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String sql,int limit,int offset){
		return dcampaignManager.findAllDcampaign(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 电子优惠卷活动
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDcampaignBySql(String sql){
		return dcampaignManager.excuteDcampaignBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDcampaignBySql(String sql){
		return dcampaignManager.countDcampaignBySql(sql);
	}
}

