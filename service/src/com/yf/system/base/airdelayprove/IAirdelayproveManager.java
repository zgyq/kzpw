/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airdelayprove;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IAirdelayproveManager{ 
	
  
 	/**
	 * 创建 航班延误证明
	 * @param id
	 * @return deleted count 
	 */
	public Airdelayprove createAirdelayprove(Airdelayprove airdelayprove) throws SQLException;
	
	/**
	 * 删除 航班延误证明
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirdelayprove(long id);
	
	
	/**
	 * 修改 航班延误证明
	 * @param id
	 * @return updated count 
	 */
	public int updateAirdelayprove(Airdelayprove airdelayprove);

		
	/**
	 * 修改 航班延误证明但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirdelayproveIgnoreNull(Airdelayprove airdelayprove);
		
	
	/**
	 * 查找 航班延误证明
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirdelayprove(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 航班延误证明
	 * @param id
	 * @return
	 */
	public Airdelayprove findAirdelayprove(long id);
	
	
	/** 
	 * 查找 航班延误证明
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirdelayprove(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找航班延误证明
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirdelayprove(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 航班延误证明
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirdelayproveBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirdelayproveBySql(String sql);
	
}

