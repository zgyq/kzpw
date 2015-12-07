/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.flightmodel;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FlightmodelManager extends  SqlMapClientDaoSupport  implements IFlightmodelManager{ 
	
  
 	/**
	 * 创建 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public Flightmodel createFlightmodel(Flightmodel flightmodel) throws SQLException{
	
		if(flightmodel.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		flightmodel.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FLIGHTMODEL"));
		getSqlMapClientTemplate().insert("createFlightmodel",flightmodel);
		if(flightmodel.getUcode()==null||flightmodel.getUcode()<1)
		{
			flightmodel.setUcode(flightmodel.getId());
			updateFlightmodelIgnoreNull(flightmodel);
		}
		return flightmodel;
	}
	/**
	 * 删除 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightmodel(long id){
	
		return getSqlMapClientTemplate().delete("deleteFlightmodel", id);
	}
	
	
	/**
	 * 修改 机型信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightmodel(Flightmodel flightmodel){
		return getSqlMapClientTemplate().update("updateFlightmodel",flightmodel);
	
	}

		
	/**
	 * 修改 机型信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightmodelIgnoreNull(Flightmodel flightmodel){
		Flightmodel tmp = findFlightmodel(flightmodel.getId());
		int flag =0;
		
		
		if(flightmodel.getModelnum()!=null){
			tmp.setModelnum(flightmodel.getModelnum());
			
			flag++;
		}
		
		if(flightmodel.getModelname()!=null){
			tmp.setModelname(flightmodel.getModelname());
			
			flag++;
		}
		
		if(flightmodel.getRidenum()!=null){
			tmp.setRidenum(flightmodel.getRidenum());
			
			flag++;
		}
		
		if(flightmodel.getModeldesc()!=null){
			tmp.setModeldesc(flightmodel.getModeldesc());
			
			flag++;
		}
		
		if(flightmodel.getIsbig()!=null){
			tmp.setIsbig(flightmodel.getIsbig());
			
			flag++;
		}
		
		if(flightmodel.getPicpath()!=null){
			tmp.setPicpath(flightmodel.getPicpath());
			
			flag++;
		}
		
		if(flightmodel.getUcode()!=null){
			tmp.setUcode(flightmodel.getUcode());
			
			flag++;
		}
		
		if(flightmodel.getLanguage()!=null){
			tmp.setLanguage(flightmodel.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFlightmodel",tmp);
		}
	}
	
	/**
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Flightmodel.COL_language+" = 0 OR "+Flightmodel.COL_language+" is NULL)";
		}
		else if(where.indexOf(Flightmodel.COL_language)<0)
		{
			where+=" and ("+Flightmodel.COL_language+" = 0 OR "+Flightmodel.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFlightmodel",map, offset, limit);
	}
		
	
	/**
	 * 查找 机型信息表
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodel(long id){
		return (Flightmodel)(getSqlMapClientTemplate().queryForObject("findFlightmodel",id));
	}
	/**
	 * 查找 机型信息表 by language
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodelbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Flightmodel.COL_ucode+" = "+id+" and "+Flightmodel.COL_language+" = "+language;	
		List list=findAllFlightmodel(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Flightmodel)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Flightmodel.COL_language+" = 0";
		}
		else if(where.indexOf(Flightmodel.COL_language)<0)
		{
			where+=" and "+Flightmodel.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFlightmodelBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFlightmodel",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机型信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFlightmodelBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机型信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightmodelBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFlightmodelBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightmodelBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFlightmodelBySql",map).toString()));
	}
}

