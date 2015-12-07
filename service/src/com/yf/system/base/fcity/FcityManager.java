/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fcity;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FcityManager extends  SqlMapClientDaoSupport  implements IFcityManager{ 
	
  
 	/**
	 * 创建 国际机票城市
	 * @param id
	 * @return deleted count 
	 */
	public Fcity createFcity(Fcity fcity) throws SQLException{
	
		if(fcity.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fcity.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FCITY"));
		getSqlMapClientTemplate().insert("createFcity",fcity);
		if(fcity.getUcode()==null||fcity.getUcode()<1)
		{
			fcity.setUcode(fcity.getId());
			updateFcityIgnoreNull(fcity);
		}
		return fcity;
	}
	/**
	 * 删除 国际机票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcity(long id){
	
		return getSqlMapClientTemplate().delete("deleteFcity", id);
	}
	
	
	/**
	 * 修改 国际机票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateFcity(Fcity fcity){
		return getSqlMapClientTemplate().update("updateFcity",fcity);
	
	}

		
	/**
	 * 修改 国际机票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFcityIgnoreNull(Fcity fcity){
		Fcity tmp = findFcity(fcity.getId());
		int flag =0;
		
		
		if(fcity.getCitycode()!=null){
			tmp.setCitycode(fcity.getCitycode());
			
			flag++;
		}
		
		if(fcity.getCityname()!=null){
			tmp.setCityname(fcity.getCityname());
			
			flag++;
		}
		
		if(fcity.getCitynameen()!=null){
			tmp.setCitynameen(fcity.getCitynameen());
			
			flag++;
		}
		
		if(fcity.getCountrycode()!=null){
			tmp.setCountrycode(fcity.getCountrycode());
			
			flag++;
		}
		
		if(fcity.getIndex()!=null){
			tmp.setIndex(fcity.getIndex());
			
			flag++;
		}
		
		if(fcity.getUcode()!=null){
			tmp.setUcode(fcity.getUcode());
			
			flag++;
		}
		
		if(fcity.getLanguage()!=null){
			tmp.setLanguage(fcity.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFcity",tmp);
		}
	}
	
	/**
	 * 查找 国际机票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcity(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Fcity.COL_language+" = 0 OR "+Fcity.COL_language+" is NULL)";
		}
		else if(where.indexOf(Fcity.COL_language)<0)
		{
			where+=" and ("+Fcity.COL_language+" = 0 OR "+Fcity.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFcity",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票城市
	 * @param id
	 * @return
	 */
	public Fcity findFcity(long id){
		return (Fcity)(getSqlMapClientTemplate().queryForObject("findFcity",id));
	}
	/**
	 * 查找 国际机票城市 by language
	 * @param id
	 * @return
	 */
	public Fcity findFcitybylanguage(long id,Integer language){
		String where = " where 1=1 and "+Fcity.COL_ucode+" = "+id+" and "+Fcity.COL_language+" = "+language;	
		List list=findAllFcity(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Fcity)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 国际机票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcity(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Fcity.COL_language+" = 0";
		}
		else if(where.indexOf(Fcity.COL_language)<0)
		{
			where+=" and "+Fcity.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFcityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFcity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFcityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFcityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFcityBySql",map).toString()));
	}
}

