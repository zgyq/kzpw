/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.region;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RegionManager extends  SqlMapClientDaoSupport  implements IRegionManager{ 
	
  
 	/**
	 * 创建 区域
	 * @param id
	 * @return deleted count 
	 */
	public Region createRegion(Region region) throws SQLException{
	
		if(region.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		region.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_REGION"));
		getSqlMapClientTemplate().insert("createRegion",region);
		if(region.getUcode()==null||region.getUcode()<1)
		{
			region.setUcode(region.getId());
			updateRegionIgnoreNull(region);
		}
		return region;
	}
	/**
	 * 删除 区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRegion(long id){
	
		return getSqlMapClientTemplate().delete("deleteRegion", id);
	}
	
	
	/**
	 * 修改 区域
	 * @param id
	 * @return updated count 
	 */
	public int updateRegion(Region region){
		return getSqlMapClientTemplate().update("updateRegion",region);
	
	}

		
	/**
	 * 修改 区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRegionIgnoreNull(Region region){
		Region tmp = findRegion(region.getId());
		int flag =0;
		
		
		if(region.getName()!=null){
			tmp.setName(region.getName());
			
			flag++;
		}
		
		if(region.getCityid()!=null){
			tmp.setCityid(region.getCityid());
			
			flag++;
		}
		
		if(region.getType()!=null){
			tmp.setType(region.getType());
			
			flag++;
		}
		
		if(region.getRegionid()!=null){
			tmp.setRegionid(region.getRegionid());
			
			flag++;
		}
		
		if(region.getUcode()!=null){
			tmp.setUcode(region.getUcode());
			
			flag++;
		}
		
		if(region.getLanguage()!=null){
			tmp.setLanguage(region.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRegion",tmp);
		}
	}
	
	/**
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegion(String where, String orderby,int limit,int offset){
		/*if(where==null||where.trim().length()==0)
		{
			where=" where ("+Region.COL_language+" = 0 OR "+Region.COL_language+" is NULL)";
		}
		else if(where.indexOf(Region.COL_language)<0)
		{
			where+=" and ("+Region.COL_language+" = 0 OR "+Region.COL_language+" is NULL)";
		}*/
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRegion",map, offset, limit);
	}
		
	
	/**
	 * 查找 区域
	 * @param id
	 * @return
	 */
	public Region findRegion(long id){
		return (Region)(getSqlMapClientTemplate().queryForObject("findRegion",id));
	}
	/**
	 * 查找 区域 by language
	 * @param id
	 * @return
	 */
	public Region findRegionbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Region.COL_ucode+" = "+id+" and "+Region.COL_language+" = "+language;	
		List list=findAllRegion(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Region)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRegion(String where, String orderby,PageInfo pageinfo){
		/*if(where==null||where.trim().length()==0)
		{
			where=" where "+Region.COL_language+" = 0";
		}
		else if(where.indexOf(Region.COL_language)<0)
		{
			where+=" and "+Region.COL_language+" = 0";
		}*/
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRegionBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRegion",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegion(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRegionBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRegionBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRegionBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRegionBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRegionBySql",map).toString()));
	}
}

