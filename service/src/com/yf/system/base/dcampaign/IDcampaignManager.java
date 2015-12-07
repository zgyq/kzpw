/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dcampaign;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IDcampaignManager{ 
	
  
 	/**
	 * 创建 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public Dcampaign createDcampaign(Dcampaign dcampaign) throws SQLException;
	
	/**
	 * 删除 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDcampaign(long id);
	
	
	/**
	 * 修改 电子优惠卷活动
	 * @param id
	 * @return updated count 
	 */
	public int updateDcampaign(Dcampaign dcampaign);

		
	/**
	 * 修改 电子优惠卷活动但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDcampaignIgnoreNull(Dcampaign dcampaign);
		
	
	/**
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 电子优惠卷活动
	 * @param id
	 * @return
	 */
	public Dcampaign findDcampaign(long id);
	
	
	/** 
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找电子优惠卷活动
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 电子优惠卷活动
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDcampaignBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDcampaignBySql(String sql);
	
}

