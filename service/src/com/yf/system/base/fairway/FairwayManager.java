/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fairway;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FairwayManager extends  SqlMapClientDaoSupport  implements IFairwayManager{ 
	
  
 	/**
	 * 创建 国际机票航空公司
	 * @param id
	 * @return deleted count 
	 */
	public Fairway createFairway(Fairway fairway) throws SQLException{
	
		if(fairway.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fairway.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FAIRWAY"));
		getSqlMapClientTemplate().insert("createFairway",fairway);
		if(fairway.getUcode()==null||fairway.getUcode()<1)
		{
			fairway.setUcode(fairway.getId());
			updateFairwayIgnoreNull(fairway);
		}
		return fairway;
	}
	/**
	 * 删除 国际机票航空公司
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairway(long id){
	
		return getSqlMapClientTemplate().delete("deleteFairway", id);
	}
	
	
	/**
	 * 修改 国际机票航空公司
	 * @param id
	 * @return updated count 
	 */
	public int updateFairway(Fairway fairway){
		return getSqlMapClientTemplate().update("updateFairway",fairway);
	
	}

		
	/**
	 * 修改 国际机票航空公司但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFairwayIgnoreNull(Fairway fairway){
		Fairway tmp = findFairway(fairway.getId());
		int flag =0;
		
		
		if(fairway.getAirlinername()!=null){
			tmp.setAirlinername(fairway.getAirlinername());
			
			flag++;
		}
		
		if(fairway.getAirlinercode()!=null){
			tmp.setAirlinercode(fairway.getAirlinercode());
			
			flag++;
		}
		
		if(fairway.getCountrycode()!=null){
			tmp.setCountrycode(fairway.getCountrycode());
			
			flag++;
		}
		
		if(fairway.getUcode()!=null){
			tmp.setUcode(fairway.getUcode());
			
			flag++;
		}
		
		if(fairway.getLanguage()!=null){
			tmp.setLanguage(fairway.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFairway",tmp);
		}
	}
	
	/**
	 * 查找 国际机票航空公司
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Fairway.COL_language+" = 0 OR "+Fairway.COL_language+" is NULL)";
		}
		else if(where.indexOf(Fairway.COL_language)<0)
		{
			where+=" and ("+Fairway.COL_language+" = 0 OR "+Fairway.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFairway",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票航空公司
	 * @param id
	 * @return
	 */
	public Fairway findFairway(long id){
		return (Fairway)(getSqlMapClientTemplate().queryForObject("findFairway",id));
	}
	/**
	 * 查找 国际机票航空公司 by language
	 * @param id
	 * @return
	 */
	public Fairway findFairwaybylanguage(long id,Integer language){
		String where = " where 1=1 and "+Fairway.COL_ucode+" = "+id+" and "+Fairway.COL_language+" = "+language;	
		List list=findAllFairway(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Fairway)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 国际机票航空公司
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairway(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Fairway.COL_language+" = 0";
		}
		else if(where.indexOf(Fairway.COL_language)<0)
		{
			where+=" and "+Fairway.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFairwayBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFairway",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票航空公司
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFairwayBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票航空公司
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairwayBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFairwayBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairwayBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFairwayBySql",map).toString()));
	}
}

