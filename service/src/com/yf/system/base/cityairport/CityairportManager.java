/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cityairport;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CityairportManager extends  SqlMapClientDaoSupport  implements ICityairportManager{ 
	
  
 	/**
	 * 创建 机场城市
	 * @param id
	 * @return deleted count 
	 */
	public Cityairport createCityairport(Cityairport cityairport) throws SQLException{
	
		if(cityairport.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		cityairport.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CITYAIRPORT"));
		getSqlMapClientTemplate().insert("createCityairport",cityairport);
		if(cityairport.getUcode()==null||cityairport.getUcode()<1)
		{
			cityairport.setUcode(cityairport.getId());
			updateCityairportIgnoreNull(cityairport);
		}
		return cityairport;
	}
	/**
	 * 删除 机场城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCityairport(long id){
	
		return getSqlMapClientTemplate().delete("deleteCityairport", id);
	}
	
	
	/**
	 * 修改 机场城市
	 * @param id
	 * @return updated count 
	 */
	public int updateCityairport(Cityairport cityairport){
		return getSqlMapClientTemplate().update("updateCityairport",cityairport);
	
	}

		
	/**
	 * 修改 机场城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityairportIgnoreNull(Cityairport cityairport){
		Cityairport tmp = findCityairport(cityairport.getId());
		int flag =0;
		
		
		if(cityairport.getCityname()!=null){
			tmp.setCityname(cityairport.getCityname());
			
			flag++;
		}
		
		if(cityairport.getPinyin()!=null){
			tmp.setPinyin(cityairport.getPinyin());
			
			flag++;
		}
		
		if(cityairport.getShortpinyin()!=null){
			tmp.setShortpinyin(cityairport.getShortpinyin());
			
			flag++;
		}
		
		if(cityairport.getAirportcode()!=null){
			tmp.setAirportcode(cityairport.getAirportcode());
			
			flag++;
		}
		
		if(cityairport.getAirportname()!=null){
			tmp.setAirportname(cityairport.getAirportname());
			
			flag++;
		}
		
		if(cityairport.getCityindex()!=null){
			tmp.setCityindex(cityairport.getCityindex());
			
			flag++;
		}
		
		if(cityairport.getCreateuser()!=null){
			tmp.setCreateuser(cityairport.getCreateuser());
			
			flag++;
		}
		
		if(cityairport.getCreatetime()!=null){
			tmp.setCreatetime(cityairport.getCreatetime());
			
			flag++;
		}
		
		if(cityairport.getModifyuser()!=null){
			tmp.setModifyuser(cityairport.getModifyuser());
			
			flag++;
		}
		
		if(cityairport.getModifytime()!=null){
			tmp.setModifytime(cityairport.getModifytime());
			
			flag++;
		}
		
		if(cityairport.getIsenable()!=null){
			tmp.setIsenable(cityairport.getIsenable());
			
			flag++;
		}
		
		if(cityairport.getUcode()!=null){
			tmp.setUcode(cityairport.getUcode());
			
			flag++;
		}
		
		if(cityairport.getLanguage()!=null){
			tmp.setLanguage(cityairport.getLanguage());
			
			flag++;
		}
		
		if(cityairport.getCountrycode()!=null){
			tmp.setCountrycode(cityairport.getCountrycode());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCityairport",tmp);
		}
	}
	
	/**
	 * 查找 机场城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityairport(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Cityairport.COL_language+" = 0 OR "+Cityairport.COL_language+" is NULL)";
		}
		else if(where.indexOf(Cityairport.COL_language)<0)
		{
			where+=" and ("+Cityairport.COL_language+" = 0 OR "+Cityairport.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCityairport",map, offset, limit);
	}
		
	
	/**
	 * 查找 机场城市
	 * @param id
	 * @return
	 */
	public Cityairport findCityairport(long id){
		return (Cityairport)(getSqlMapClientTemplate().queryForObject("findCityairport",id));
	}
	/**
	 * 查找 机场城市 by language
	 * @param id
	 * @return
	 */
	public Cityairport findCityairportbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Cityairport.COL_ucode+" = "+id+" and "+Cityairport.COL_language+" = "+language;	
		List list=findAllCityairport(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Cityairport)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 机场城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCityairport(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Cityairport.COL_language+" = 0";
		}
		else if(where.indexOf(Cityairport.COL_language)<0)
		{
			where+=" and "+Cityairport.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCityairportBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCityairport",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机场城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityairport(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCityairportBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机场城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityairportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCityairportBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityairportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCityairportBySql",map).toString()));
	}
}

