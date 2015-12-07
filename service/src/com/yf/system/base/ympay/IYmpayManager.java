/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ympay;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IYmpayManager{ 
	
  
 	/**
	 * 创建 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Ympay createYmpay(Ympay ympay) throws SQLException;
	
	/**
	 * 删除 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmpay(long id);
	
	
	/**
	 * 修改 短信充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateYmpay(Ympay ympay);

		
	/**
	 * 修改 短信充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmpayIgnoreNull(Ympay ympay);
		
	
	/**
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 短信充值记录
	 * @param id
	 * @return
	 */
	public Ympay findYmpay(long id);
	
	
	/** 
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找短信充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 短信充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmpayBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmpayBySql(String sql);
	
}

