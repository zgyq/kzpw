/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.template;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITemplateComponent{ 
	
  
 	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Template createTemplate(Template template) throws SQLException;
	
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplate(long id);
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplate(Template template);

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTemplateIgnoreNull(Template template);
		
	
	/**
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplate(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Template findTemplate(long id);
	
	/**
	 * 查找 模板 by language
	 * @param id
	 * @return
	 */
	public Template findTemplatebylanguage(long id,Integer language);
	
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTemplate(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplate(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTemplateBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTemplateBySql(String sql);
	
}

