/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.flightstop;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FlightstopManager extends  SqlMapClientDaoSupport  implements IFlightstopManager{ 
	
  
 	/**
	 * 创建 航班经停信息
	 * @param id
	 * @return deleted count 
	 */
	public Flightstop createFlightstop(Flightstop flightstop) throws SQLException{
	
		if(flightstop.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		flightstop.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FLIGHTSTOP"));
		getSqlMapClientTemplate().insert("createFlightstop",flightstop);
		if(flightstop.getUcode()==null||flightstop.getUcode()<1)
		{
			flightstop.setUcode(flightstop.getId());
			updateFlightstopIgnoreNull(flightstop);
		}
		return flightstop;
	}
	/**
	 * 删除 航班经停信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightstop(long id){
	
		return getSqlMapClientTemplate().delete("deleteFlightstop", id);
	}
	
	
	/**
	 * 修改 航班经停信息
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightstop(Flightstop flightstop){
		return getSqlMapClientTemplate().update("updateFlightstop",flightstop);
	
	}

		
	/**
	 * 修改 航班经停信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightstopIgnoreNull(Flightstop flightstop){
		Flightstop tmp = findFlightstop(flightstop.getId());
		int flag =0;
		
		
		if(flightstop.getSairportcode()!=null){
			tmp.setSairportcode(flightstop.getSairportcode());
			
			flag++;
		}
		
		if(flightstop.getEairportcode()!=null){
			tmp.setEairportcode(flightstop.getEairportcode());
			
			flag++;
		}
		
		if(flightstop.getFlightnumber()!=null){
			tmp.setFlightnumber(flightstop.getFlightnumber());
			
			flag++;
		}
		
		if(flightstop.getStopnumber()!=null){
			tmp.setStopnumber(flightstop.getStopnumber());
			
			flag++;
		}
		
		if(flightstop.getCity()!=null){
			tmp.setCity(flightstop.getCity());
			
			flag++;
		}
		
		if(flightstop.getTime()!=null){
			tmp.setTime(flightstop.getTime());
			
			flag++;
		}
		
		if(flightstop.getCreateuser()!=null){
			tmp.setCreateuser(flightstop.getCreateuser());
			
			flag++;
		}
		
		if(flightstop.getCreatetime()!=null){
			tmp.setCreatetime(flightstop.getCreatetime());
			
			flag++;
		}
		
		if(flightstop.getModifyuser()!=null){
			tmp.setModifyuser(flightstop.getModifyuser());
			
			flag++;
		}
		
		if(flightstop.getModifytime()!=null){
			tmp.setModifytime(flightstop.getModifytime());
			
			flag++;
		}
		
		if(flightstop.getIsenable()!=null){
			tmp.setIsenable(flightstop.getIsenable());
			
			flag++;
		}
		
		if(flightstop.getUcode()!=null){
			tmp.setUcode(flightstop.getUcode());
			
			flag++;
		}
		
		if(flightstop.getLanguage()!=null){
			tmp.setLanguage(flightstop.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFlightstop",tmp);
		}
	}
	
	/**
	 * 查找 航班经停信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightstop(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Flightstop.COL_language+" = 0 OR "+Flightstop.COL_language+" is NULL)";
		}
		else if(where.indexOf(Flightstop.COL_language)<0)
		{
			where+=" and ("+Flightstop.COL_language+" = 0 OR "+Flightstop.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFlightstop",map, offset, limit);
	}
		
	
	/**
	 * 查找 航班经停信息
	 * @param id
	 * @return
	 */
	public Flightstop findFlightstop(long id){
		return (Flightstop)(getSqlMapClientTemplate().queryForObject("findFlightstop",id));
	}
	/**
	 * 查找 航班经停信息 by language
	 * @param id
	 * @return
	 */
	public Flightstop findFlightstopbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Flightstop.COL_ucode+" = "+id+" and "+Flightstop.COL_language+" = "+language;	
		List list=findAllFlightstop(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Flightstop)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 航班经停信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightstop(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Flightstop.COL_language+" = 0";
		}
		else if(where.indexOf(Flightstop.COL_language)<0)
		{
			where+=" and "+Flightstop.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFlightstopBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFlightstop",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航班经停信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightstop(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFlightstopBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航班经停信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightstopBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFlightstopBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightstopBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFlightstopBySql",map).toString()));
	}
}

