/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triplinesource;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriplinesourceManager extends  SqlMapClientDaoSupport  implements ITriplinesourceManager{ 
	
  
 	/**
	 * 创建 旅游线路来源
	 * @param id
	 * @return deleted count 
	 */
	public Triplinesource createTriplinesource(Triplinesource triplinesource) throws SQLException{
	
		if(triplinesource.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		triplinesource.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPLINESOURCE"));
		getSqlMapClientTemplate().insert("createTriplinesource",triplinesource);
		if(triplinesource.getUcode()==null||triplinesource.getUcode()<1)
		{
			triplinesource.setUcode(triplinesource.getId());
			updateTriplinesourceIgnoreNull(triplinesource);
		}
		return triplinesource;
	}
	/**
	 * 删除 旅游线路来源
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriplinesource(long id){
	
		return getSqlMapClientTemplate().delete("deleteTriplinesource", id);
	}
	
	
	/**
	 * 修改 旅游线路来源
	 * @param id
	 * @return updated count 
	 */
	public int updateTriplinesource(Triplinesource triplinesource){
		return getSqlMapClientTemplate().update("updateTriplinesource",triplinesource);
	
	}

		
	/**
	 * 修改 旅游线路来源但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplinesourceIgnoreNull(Triplinesource triplinesource){
		Triplinesource tmp = findTriplinesource(triplinesource.getId());
		int flag =0;
		
		
		if(triplinesource.getName()!=null){
			tmp.setName(triplinesource.getName());
			
			flag++;
		}
		
		if(triplinesource.getCreateuser()!=null){
			tmp.setCreateuser(triplinesource.getCreateuser());
			
			flag++;
		}
		
		if(triplinesource.getCreatetime()!=null){
			tmp.setCreatetime(triplinesource.getCreatetime());
			
			flag++;
		}
		
		if(triplinesource.getModifyuser()!=null){
			tmp.setModifyuser(triplinesource.getModifyuser());
			
			flag++;
		}
		
		if(triplinesource.getModifytime()!=null){
			tmp.setModifytime(triplinesource.getModifytime());
			
			flag++;
		}
		
		if(triplinesource.getUcode()!=null){
			tmp.setUcode(triplinesource.getUcode());
			
			flag++;
		}
		
		if(triplinesource.getLanguage()!=null){
			tmp.setLanguage(triplinesource.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTriplinesource",tmp);
		}
	}
	
	/**
	 * 查找 旅游线路来源
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesource(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Triplinesource.COL_language+" = 0 OR "+Triplinesource.COL_language+" is NULL)";
		}
		else if(where.indexOf(Triplinesource.COL_language)<0)
		{
			where+=" and ("+Triplinesource.COL_language+" = 0 OR "+Triplinesource.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTriplinesource",map, offset, limit);
	}
		
	
	/**
	 * 查找 旅游线路来源
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesource(long id){
		return (Triplinesource)(getSqlMapClientTemplate().queryForObject("findTriplinesource",id));
	}
	/**
	 * 查找 旅游线路来源 by language
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesourcebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Triplinesource.COL_ucode+" = "+id+" and "+Triplinesource.COL_language+" = "+language;	
		List list=findAllTriplinesource(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Triplinesource)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 旅游线路来源
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinesource(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Triplinesource.COL_language+" = 0";
		}
		else if(where.indexOf(Triplinesource.COL_language)<0)
		{
			where+=" and "+Triplinesource.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriplinesourceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTriplinesource",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找旅游线路来源
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesource(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriplinesourceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 旅游线路来源
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplinesourceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriplinesourceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplinesourceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriplinesourceBySql",map).toString()));
	}
}

