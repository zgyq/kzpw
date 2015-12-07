/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.template;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TemplateManager extends  SqlMapClientDaoSupport  implements ITemplateManager{ 
	
  
 	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Template createTemplate(Template template) throws SQLException{
	
		if(template.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		template.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TEMPLATE"));
		getSqlMapClientTemplate().insert("createTemplate",template);
		if(template.getUcode()==null||template.getUcode()<1)
		{
			template.setUcode(template.getId());
			updateTemplateIgnoreNull(template);
		}
		return template;
	}
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplate(long id){
	
		return getSqlMapClientTemplate().delete("deleteTemplate", id);
	}
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplate(Template template){
		return getSqlMapClientTemplate().update("updateTemplate",template);
	
	}

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTemplateIgnoreNull(Template template){
		Template tmp = findTemplate(template.getId());
		int flag =0;
		
		
		if(template.getCreateuser()!=null){
			tmp.setCreateuser(template.getCreateuser());
			
			flag++;
		}
		
		if(template.getCreatetime()!=null){
			tmp.setCreatetime(template.getCreatetime());
			
			flag++;
		}
		
		if(template.getModifyuser()!=null){
			tmp.setModifyuser(template.getModifyuser());
			
			flag++;
		}
		
		if(template.getModifytime()!=null){
			tmp.setModifytime(template.getModifytime());
			
			flag++;
		}
		
		if(template.getType()!=null){
			tmp.setType(template.getType());
			
			flag++;
		}
		
		if(template.getState()!=null){
			tmp.setState(template.getState());
			
			flag++;
		}
		
		if(template.getContent()!=null){
			tmp.setContent(template.getContent());
			
			flag++;
		}
		
		if(template.getPath()!=null){
			tmp.setPath(template.getPath());
			
			flag++;
		}
		
		if(template.getName()!=null){
			tmp.setName(template.getName());
			
			flag++;
		}
		
		if(template.getUcode()!=null){
			tmp.setUcode(template.getUcode());
			
			flag++;
		}
		
		if(template.getLanguage()!=null){
			tmp.setLanguage(template.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTemplate",tmp);
		}
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
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Template.COL_language+" = 0 OR "+Template.COL_language+" is NULL)";
		}
		else if(where.indexOf(Template.COL_language)<0)
		{
			where+=" and ("+Template.COL_language+" = 0 OR "+Template.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTemplate",map, offset, limit);
	}
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Template findTemplate(long id){
		return (Template)(getSqlMapClientTemplate().queryForObject("findTemplate",id));
	}
	/**
	 * 查找 模板 by language
	 * @param id
	 * @return
	 */
	public Template findTemplatebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Template.COL_ucode+" = "+id+" and "+Template.COL_language+" = "+language;	
		List list=findAllTemplate(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Template)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTemplate(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Template.COL_language+" = 0";
		}
		else if(where.indexOf(Template.COL_language)<0)
		{
			where+=" and "+Template.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTemplateBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTemplate",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplate(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTemplateBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTemplateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTemplateBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTemplateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTemplateBySql",map).toString()));
	}
}

