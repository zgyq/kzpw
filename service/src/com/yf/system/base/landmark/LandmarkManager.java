/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.landmark;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class LandmarkManager extends  SqlMapClientDaoSupport  implements ILandmarkManager{ 
	
  
 	/**
	 * 创建 地标
	 * @param id
	 * @return deleted count 
	 */
	public Landmark createLandmark(Landmark landmark) throws SQLException{
	
		if(landmark.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		landmark.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_LANDMARK"));
		getSqlMapClientTemplate().insert("createLandmark",landmark);
		if(landmark.getUcode()==null||landmark.getUcode()<1)
		{
			landmark.setUcode(landmark.getId());
			updateLandmarkIgnoreNull(landmark);
		}
		return landmark;
	}
	/**
	 * 删除 地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLandmark(long id){
	
		return getSqlMapClientTemplate().delete("deleteLandmark", id);
	}
	
	
	/**
	 * 修改 地标
	 * @param id
	 * @return updated count 
	 */
	public int updateLandmark(Landmark landmark){
		return getSqlMapClientTemplate().update("updateLandmark",landmark);
	
	}

		
	/**
	 * 修改 地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLandmarkIgnoreNull(Landmark landmark){
		Landmark tmp = findLandmark(landmark.getId());
		int flag =0;
		
		
		if(landmark.getName()!=null){
			tmp.setName(landmark.getName());
			
			flag++;
		}
		
		if(landmark.getCityid()!=null){
			tmp.setCityid(landmark.getCityid());
			
			flag++;
		}
		
		if(landmark.getType()!=null){
			tmp.setType(landmark.getType());
			
			flag++;
		}
		
		if(landmark.getRegionid()!=null){
			tmp.setRegionid(landmark.getRegionid());
			
			flag++;
		}
		
		if(landmark.getUcode()!=null){
			tmp.setUcode(landmark.getUcode());
			
			flag++;
		}
		
		if(landmark.getLanguage()!=null){
			tmp.setLanguage(landmark.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateLandmark",tmp);
		}
	}
	
	/**
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Landmark.COL_language+" = 0 OR "+Landmark.COL_language+" is NULL)";
		}
		else if(where.indexOf(Landmark.COL_language)<0)
		{
			where+=" and ("+Landmark.COL_language+" = 0 OR "+Landmark.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllLandmark",map, offset, limit);
	}
		
	
	/**
	 * 查找 地标
	 * @param id
	 * @return
	 */
	public Landmark findLandmark(long id){
		return (Landmark)(getSqlMapClientTemplate().queryForObject("findLandmark",id));
	}
	/**
	 * 查找 地标 by language
	 * @param id
	 * @return
	 */
	public Landmark findLandmarkbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Landmark.COL_ucode+" = "+id+" and "+Landmark.COL_language+" = "+language;	
		List list=findAllLandmark(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Landmark)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Landmark.COL_language+" = 0";
		}
		else if(where.indexOf(Landmark.COL_language)<0)
		{
			where+=" and "+Landmark.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLandmarkBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllLandmark",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllLandmarkBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLandmarkBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteLandmarkBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLandmarkBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLandmarkBySql",map).toString()));
	}
}

