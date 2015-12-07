/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.vmoneyrecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IVmoneyrecordManager{ 
	
  
 	/**
	 * 创建 虚拟账户充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Vmoneyrecord createVmoneyrecord(Vmoneyrecord vmoneyrecord) throws SQLException;
	
	/**
	 * 删除 虚拟账户充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteVmoneyrecord(long id);
	
	
	/**
	 * 修改 虚拟账户充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateVmoneyrecord(Vmoneyrecord vmoneyrecord);

		
	/**
	 * 修改 虚拟账户充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateVmoneyrecordIgnoreNull(Vmoneyrecord vmoneyrecord);
		
	
	/**
	 * 查找 虚拟账户充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllVmoneyrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 虚拟账户充值记录
	 * @param id
	 * @return
	 */
	public Vmoneyrecord findVmoneyrecord(long id);
	
	
	/** 
	 * 查找 虚拟账户充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllVmoneyrecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找虚拟账户充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllVmoneyrecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 虚拟账户充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteVmoneyrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countVmoneyrecordBySql(String sql);
	
}

