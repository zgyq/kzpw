/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airflight;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AirflightManager extends  SqlMapClientDaoSupport  implements IAirflightManager{ 
	
  
 	/**
	 * 创建 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Airflight createAirflight(Airflight airflight) throws SQLException{
	
		if(airflight.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		airflight.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRFLIGHT"));
		getSqlMapClientTemplate().insert("createAirflight",airflight);
		if(airflight.getUcode()==null||airflight.getUcode()<1)
		{
			airflight.setUcode(airflight.getId());
			updateAirflightIgnoreNull(airflight);
		}
		return airflight;
	}
	/**
	 * 删除 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirflight(long id){
	
		return getSqlMapClientTemplate().delete("deleteAirflight", id);
	}
	
	
	/**
	 * 修改 航班基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirflight(Airflight airflight){
		return getSqlMapClientTemplate().update("updateAirflight",airflight);
	
	}

		
	/**
	 * 修改 航班基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirflightIgnoreNull(Airflight airflight){
		Airflight tmp = findAirflight(airflight.getId());
		int flag =0;
		
		
		if(airflight.getAircompanycode()!=null){
			tmp.setAircompanycode(airflight.getAircompanycode());
			
			flag++;
		}
		
		if(airflight.getFlightnumber()!=null){
			tmp.setFlightnumber(airflight.getFlightnumber());
			
			flag++;
		}
		
		if(airflight.getSairportcode()!=null){
			tmp.setSairportcode(airflight.getSairportcode());
			
			flag++;
		}
		
		if(airflight.getEairportcode()!=null){
			tmp.setEairportcode(airflight.getEairportcode());
			
			flag++;
		}
		
		if(airflight.getIsenable()!=null){
			tmp.setIsenable(airflight.getIsenable());
			
			flag++;
		}
		
		if(airflight.getCreateuser()!=null){
			tmp.setCreateuser(airflight.getCreateuser());
			
			flag++;
		}
		
		if(airflight.getCreateusertime()!=null){
			tmp.setCreateusertime(airflight.getCreateusertime());
			
			flag++;
		}
		
		if(airflight.getModifyuser()!=null){
			tmp.setModifyuser(airflight.getModifyuser());
			
			flag++;
		}
		
		if(airflight.getModifytime()!=null){
			tmp.setModifytime(airflight.getModifytime());
			
			flag++;
		}
		
		if(airflight.getUcode()!=null){
			tmp.setUcode(airflight.getUcode());
			
			flag++;
		}
		
		if(airflight.getLanguage()!=null){
			tmp.setLanguage(airflight.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAirflight",tmp);
		}
	}
	
	/**
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Airflight.COL_language+" = 0 OR "+Airflight.COL_language+" is NULL)";
		}
		else if(where.indexOf(Airflight.COL_language)<0)
		{
			where+=" and ("+Airflight.COL_language+" = 0 OR "+Airflight.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAirflight",map, offset, limit);
	}
		
	
	/**
	 * 查找 航班基础信息表
	 * @param id
	 * @return
	 */
	public Airflight findAirflight(long id){
		return (Airflight)(getSqlMapClientTemplate().queryForObject("findAirflight",id));
	}
	/**
	 * 查找 航班基础信息表 by language
	 * @param id
	 * @return
	 */
	public Airflight findAirflightbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Airflight.COL_ucode+" = "+id+" and "+Airflight.COL_language+" = "+language;	
		List list=findAllAirflight(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Airflight)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Airflight.COL_language+" = 0";
		}
		else if(where.indexOf(Airflight.COL_language)<0)
		{
			where+=" and "+Airflight.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirflightBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAirflight",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航班基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAirflightBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航班基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirflightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAirflightBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirflightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirflightBySql",map).toString()));
	}
}

