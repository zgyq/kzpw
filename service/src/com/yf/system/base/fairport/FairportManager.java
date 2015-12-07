/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fairport;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FairportManager extends  SqlMapClientDaoSupport  implements IFairportManager{ 
	
  
 	/**
	 * 创建 国际机票机场
	 * @param id
	 * @return deleted count 
	 */
	public Fairport createFairport(Fairport fairport) throws SQLException{
	
		if(fairport.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fairport.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FAIRPORT"));
		getSqlMapClientTemplate().insert("createFairport",fairport);
		if(fairport.getUcode()==null||fairport.getUcode()<1)
		{
			fairport.setUcode(fairport.getId());
			updateFairportIgnoreNull(fairport);
		}
		return fairport;
	}
	/**
	 * 删除 国际机票机场
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairport(long id){
	
		return getSqlMapClientTemplate().delete("deleteFairport", id);
	}
	
	
	/**
	 * 修改 国际机票机场
	 * @param id
	 * @return updated count 
	 */
	public int updateFairport(Fairport fairport){
		return getSqlMapClientTemplate().update("updateFairport",fairport);
	
	}

		
	/**
	 * 修改 国际机票机场但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFairportIgnoreNull(Fairport fairport){
		Fairport tmp = findFairport(fairport.getId());
		int flag =0;
		
		
		if(fairport.getAirportname()!=null){
			tmp.setAirportname(fairport.getAirportname());
			
			flag++;
		}
		
		if(fairport.getCitycode()!=null){
			tmp.setCitycode(fairport.getCitycode());
			
			flag++;
		}
		
		if(fairport.getAirportcode()!=null){
			tmp.setAirportcode(fairport.getAirportcode());
			
			flag++;
		}
		
		if(fairport.getUcode()!=null){
			tmp.setUcode(fairport.getUcode());
			
			flag++;
		}
		
		if(fairport.getLanguage()!=null){
			tmp.setLanguage(fairport.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFairport",tmp);
		}
	}
	
	/**
	 * 查找 国际机票机场
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Fairport.COL_language+" = 0 OR "+Fairport.COL_language+" is NULL)";
		}
		else if(where.indexOf(Fairport.COL_language)<0)
		{
			where+=" and ("+Fairport.COL_language+" = 0 OR "+Fairport.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFairport",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票机场
	 * @param id
	 * @return
	 */
	public Fairport findFairport(long id){
		return (Fairport)(getSqlMapClientTemplate().queryForObject("findFairport",id));
	}
	/**
	 * 查找 国际机票机场 by language
	 * @param id
	 * @return
	 */
	public Fairport findFairportbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Fairport.COL_ucode+" = "+id+" and "+Fairport.COL_language+" = "+language;	
		List list=findAllFairport(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Fairport)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 国际机票机场
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairport(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Fairport.COL_language+" = 0";
		}
		else if(where.indexOf(Fairport.COL_language)<0)
		{
			where+=" and "+Fairport.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFairportBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFairport",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票机场
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFairportBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票机场
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFairportBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFairportBySql",map).toString()));
	}
}

