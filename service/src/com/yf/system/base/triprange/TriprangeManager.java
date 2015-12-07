/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triprange;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriprangeManager extends  SqlMapClientDaoSupport  implements ITriprangeManager{ 
	
  
 	/**
	 * 创建 行程
	 * @param id
	 * @return deleted count 
	 */
	public Triprange createTriprange(Triprange triprange) throws SQLException{
	
		if(triprange.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		triprange.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPRANGE"));
		getSqlMapClientTemplate().insert("createTriprange",triprange);
		if(triprange.getUcode()==null||triprange.getUcode()<1)
		{
			triprange.setUcode(triprange.getId());
			updateTriprangeIgnoreNull(triprange);
		}
		return triprange;
	}
	/**
	 * 删除 行程
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriprange(long id){
	
		return getSqlMapClientTemplate().delete("deleteTriprange", id);
	}
	
	
	/**
	 * 修改 行程
	 * @param id
	 * @return updated count 
	 */
	public int updateTriprange(Triprange triprange){
		return getSqlMapClientTemplate().update("updateTriprange",triprange);
	
	}

		
	/**
	 * 修改 行程但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriprangeIgnoreNull(Triprange triprange){
		Triprange tmp = findTriprange(triprange.getId());
		int flag =0;
		
		
		if(triprange.getTriplineid()!=null){
			tmp.setTriplineid(triprange.getTriplineid());
			
			flag++;
		}
		
		if(triprange.getName()!=null){
			tmp.setName(triprange.getName());
			
			flag++;
		}
		
		if(triprange.getCreateuser()!=null){
			tmp.setCreateuser(triprange.getCreateuser());
			
			flag++;
		}
		
		if(triprange.getCreatetime()!=null){
			tmp.setCreatetime(triprange.getCreatetime());
			
			flag++;
		}
		
		if(triprange.getModifyuser()!=null){
			tmp.setModifyuser(triprange.getModifyuser());
			
			flag++;
		}
		
		if(triprange.getModifytime()!=null){
			tmp.setModifytime(triprange.getModifytime());
			
			flag++;
		}
		
		if(triprange.getSort()!=null){
			tmp.setSort(triprange.getSort());
			
			flag++;
		}
		
		if(triprange.getDescription()!=null){
			tmp.setDescription(triprange.getDescription());
			
			flag++;
		}
		
		if(triprange.getType()!=null){
			tmp.setType(triprange.getType());
			
			flag++;
		}
		
		if(triprange.getUcode()!=null){
			tmp.setUcode(triprange.getUcode());
			
			flag++;
		}
		
		if(triprange.getLanguage()!=null){
			tmp.setLanguage(triprange.getLanguage());
			
			flag++;
		}
		
		if(triprange.getImagepath()!=null){
			tmp.setImagepath(triprange.getImagepath());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTriprange",tmp);
		}
	}
	
	/**
	 * 查找 行程
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Triprange.COL_language+" = 0 OR "+Triprange.COL_language+" is NULL)";
		}
		else if(where.indexOf(Triprange.COL_language)<0)
		{
			where+=" and ("+Triprange.COL_language+" = 0 OR "+Triprange.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTriprange",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程
	 * @param id
	 * @return
	 */
	public Triprange findTriprange(long id){
		return (Triprange)(getSqlMapClientTemplate().queryForObject("findTriprange",id));
	}
	/**
	 * 查找 行程 by language
	 * @param id
	 * @return
	 */
	public Triprange findTriprangebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Triprange.COL_ucode+" = "+id+" and "+Triprange.COL_language+" = "+language;	
		List list=findAllTriprange(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Triprange)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 行程
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprange(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Triprange.COL_language+" = 0";
		}
		else if(where.indexOf(Triprange.COL_language)<0)
		{
			where+=" and "+Triprange.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriprangeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTriprange",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriprangeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriprangeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriprangeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriprangeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriprangeBySql",map).toString()));
	}
}

