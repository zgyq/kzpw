/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.city;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CityManager extends  SqlMapClientDaoSupport  implements ICityManager{ 
	
  
 	/**
	 * 创建 地级市
	 * @param id
	 * @return deleted count 
	 */
	public City createCity(City city) throws SQLException{
	
		if(city.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		city.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CITY"));
		getSqlMapClientTemplate().insert("createCity",city);
		if(city.getUcode()==null||city.getUcode()<1)
		{
			city.setUcode(city.getId());
			updateCityIgnoreNull(city);
		}
		return city;
	}
	/**
	 * 删除 地级市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCity(long id){
	
		return getSqlMapClientTemplate().delete("deleteCity", id);
	}
	
	
	/**
	 * 修改 地级市
	 * @param id
	 * @return updated count 
	 */
	public int updateCity(City city){
		return getSqlMapClientTemplate().update("updateCity",city);
	
	}

		
	/**
	 * 修改 地级市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityIgnoreNull(City city){
		City tmp = findCity(city.getId());
		int flag =0;
		
		
		if(city.getName()!=null){
			tmp.setName(city.getName());
			
			flag++;
		}
		
		if(city.getEnname()!=null){
			tmp.setEnname(city.getEnname());
			
			flag++;
		}
		if(city.getCarcode()!=null){
			tmp.setCarcode(city.getCarcode());
			
			flag++;
		}
		if(city.getIscode()!=null){
			tmp.setIscode(city.getIscode());
			
			flag++;
		}
		if(city.getType()!=null){
			tmp.setType(city.getType());
			
			flag++;
		}
		if(city.getSname()!=null){
			tmp.setSname(city.getSname());
			
			flag++;
		}
		
		if(city.getSort()!=null){
			tmp.setSort(city.getSort());
			
			flag++;
		}
		
		if(city.getProvinceid()!=null){
			tmp.setProvinceid(city.getProvinceid());
			
			flag++;
		}
		
		if(city.getAreacode()!=null){
			tmp.setAreacode(city.getAreacode());
			
			flag++;
		}
		
		if(city.getUcode()!=null){
			tmp.setUcode(city.getUcode());
			
			flag++;
		}
		
		if(city.getLanguage()!=null){
			tmp.setLanguage(city.getLanguage());
			
			flag++;
		}
		
		if(city.getLountryid()!=null){
			tmp.setLountryid(city.getLountryid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCity",tmp);
		}
	}
	
	/**
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String where, String orderby,int limit,int offset){
		/*if(where==null||where.trim().length()==0)
		{
			where=" where ("+City.COL_language+" = 0 OR "+City.COL_language+" is NULL)";
		}
		else if(where.indexOf(City.COL_language)<0)
		{
			where+=" and ("+City.COL_language+" = 0 OR "+City.COL_language+" is NULL)";
		}*/
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCity",map, offset, limit);
	}
		
	
	/**
	 * 查找 地级市
	 * @param id
	 * @return
	 */
	public City findCity(long id){
		return (City)(getSqlMapClientTemplate().queryForObject("findCity",id));
	}
	/**
	 * 查找 地级市 by language
	 * @param id
	 * @return
	 */
	public City findCitybylanguage(long id,Integer language){
		String where = " where 1=1 and "+City.COL_ucode+" = "+id+" and "+City.COL_language+" = "+language;	
		List list=findAllCity(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (City)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCity(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+City.COL_language+" = 0";
		}
		else if(where.indexOf(City.COL_language)<0)
		{
			where+=" and "+City.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找地级市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 地级市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCityBySql",map).toString()));
	}
}

