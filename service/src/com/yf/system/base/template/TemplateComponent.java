/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.template;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TemplateComponent   implements ITemplateComponent{ 
	
	
	private ITemplateManager templateManager;
   
   
 	public ITemplateManager getTemplateManager() {
		return templateManager;
	}

	public void setTemplateManager(ITemplateManager templateManager) {
		this.templateManager = templateManager;
	}
  
 	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Template createTemplate(Template template) throws SQLException{
	
		return templateManager.createTemplate(template);
	}
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplate(long id){
	
		return templateManager.deleteTemplate(id);
	}
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplate(Template template){
		return templateManager.updateTemplate(template);
	
	}

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTemplateIgnoreNull(Template template){
			return templateManager.updateTemplateIgnoreNull(template);
	
	}
	
	/**
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplate(String where, String orderby,int limit,int offset){
		return templateManager.findAllTemplate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Template findTemplate(long id){
		return templateManager.findTemplate(id);
	}
	/**
	 * 查找 模板 by language
	 * @param id
	 * @return
	 */
	public Template findTemplatebylanguage(long id,Integer language){
		return templateManager.findTemplatebylanguage(id,language);
	}
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTemplate(String where, String orderby,PageInfo pageinfo){
		return templateManager.findAllTemplate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplate(String sql,int limit,int offset){
		return templateManager.findAllTemplate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTemplateBySql(String sql){
		return templateManager.excuteTemplateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTemplateBySql(String sql){
		return templateManager.countTemplateBySql(sql);
	}
}

