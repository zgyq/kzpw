/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triprangescenicspot;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriprangescenicspotManager extends  SqlMapClientDaoSupport  implements ITriprangescenicspotManager{ 
	
  
 	/**
	 * 创建 行程景点关联
	 * @param id
	 * @return deleted count 
	 */
	public Triprangescenicspot createTriprangescenicspot(Triprangescenicspot triprangescenicspot) throws SQLException{
	
		if(triprangescenicspot.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		triprangescenicspot.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPRANGESCENICSPOT"));
		getSqlMapClientTemplate().insert("createTriprangescenicspot",triprangescenicspot);
		if(triprangescenicspot.getUcode()==null||triprangescenicspot.getUcode()<1)
		{
			triprangescenicspot.setUcode(triprangescenicspot.getId());
			updateTriprangescenicspotIgnoreNull(triprangescenicspot);
		}
		return triprangescenicspot;
	}
	/**
	 * 删除 行程景点关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriprangescenicspot(long id){
	
		return getSqlMapClientTemplate().delete("deleteTriprangescenicspot", id);
	}
	
	
	/**
	 * 修改 行程景点关联
	 * @param id
	 * @return updated count 
	 */
	public int updateTriprangescenicspot(Triprangescenicspot triprangescenicspot){
		return getSqlMapClientTemplate().update("updateTriprangescenicspot",triprangescenicspot);
	
	}

		
	/**
	 * 修改 行程景点关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriprangescenicspotIgnoreNull(Triprangescenicspot triprangescenicspot){
		Triprangescenicspot tmp = findTriprangescenicspot(triprangescenicspot.getId());
		int flag =0;
		
		
		if(triprangescenicspot.getTriprangeid()!=null){
			tmp.setTriprangeid(triprangescenicspot.getTriprangeid());
			
			flag++;
		}
		
		if(triprangescenicspot.getScenicspotid()!=null){
			tmp.setScenicspotid(triprangescenicspot.getScenicspotid());
			
			flag++;
		}
		
		if(triprangescenicspot.getUcode()!=null){
			tmp.setUcode(triprangescenicspot.getUcode());
			
			flag++;
		}
		
		if(triprangescenicspot.getLanguage()!=null){
			tmp.setLanguage(triprangescenicspot.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTriprangescenicspot",tmp);
		}
	}
	
	/**
	 * 查找 行程景点关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspot(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Triprangescenicspot.COL_language+" = 0 OR "+Triprangescenicspot.COL_language+" is NULL)";
		}
		else if(where.indexOf(Triprangescenicspot.COL_language)<0)
		{
			where+=" and ("+Triprangescenicspot.COL_language+" = 0 OR "+Triprangescenicspot.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTriprangescenicspot",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程景点关联
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspot(long id){
		return (Triprangescenicspot)(getSqlMapClientTemplate().queryForObject("findTriprangescenicspot",id));
	}
	/**
	 * 查找 行程景点关联 by language
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspotbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Triprangescenicspot.COL_ucode+" = "+id+" and "+Triprangescenicspot.COL_language+" = "+language;	
		List list=findAllTriprangescenicspot(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Triprangescenicspot)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 行程景点关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprangescenicspot(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Triprangescenicspot.COL_language+" = 0";
		}
		else if(where.indexOf(Triprangescenicspot.COL_language)<0)
		{
			where+=" and "+Triprangescenicspot.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriprangescenicspotBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTriprangescenicspot",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程景点关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspot(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriprangescenicspotBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程景点关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriprangescenicspotBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriprangescenicspotBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriprangescenicspotBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriprangescenicspotBySql",map).toString()));
	}
}

