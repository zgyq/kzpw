/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tuipiao;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITuipiaoComponent{ 
	
  
 	/**
	 * 创建 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public Tuipiao createTuipiao(Tuipiao tuipiao) throws SQLException;
	
	/**
	 * 删除 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTuipiao(long id);
	
	
	/**
	 * 修改 退票报表
	 * @param id
	 * @return updated count 
	 */
	public int updateTuipiao(Tuipiao tuipiao);

		
	/**
	 * 修改 退票报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTuipiaoIgnoreNull(Tuipiao tuipiao);
		
	
	/**
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 退票报表
	 * @param id
	 * @return
	 */
	public Tuipiao findTuipiao(long id);
	
	
	/** 
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找退票报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 退票报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTuipiaoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTuipiaoBySql(String sql);
	
}

