/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.scenicspot;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ScenicspotManager extends  SqlMapClientDaoSupport  implements IScenicspotManager{ 
	
  
 	/**
	 * 创建 景点
	 * @param id
	 * @return deleted count 
	 */
	public Scenicspot createScenicspot(Scenicspot scenicspot) throws SQLException{
	
		if(scenicspot.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		scenicspot.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SCENICSPOT"));
		getSqlMapClientTemplate().insert("createScenicspot",scenicspot);
		if(scenicspot.getUcode()==null||scenicspot.getUcode()<1)
		{
			scenicspot.setUcode(scenicspot.getId());
			updateScenicspotIgnoreNull(scenicspot);
		}
		return scenicspot;
	}
	/**
	 * 删除 景点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScenicspot(long id){
	
		return getSqlMapClientTemplate().delete("deleteScenicspot", id);
	}
	
	
	/**
	 * 修改 景点
	 * @param id
	 * @return updated count 
	 */
	public int updateScenicspot(Scenicspot scenicspot){
		return getSqlMapClientTemplate().update("updateScenicspot",scenicspot);
	
	}

		
	/**
	 * 修改 景点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScenicspotIgnoreNull(Scenicspot scenicspot){
		Scenicspot tmp = findScenicspot(scenicspot.getId());
		int flag =0;
		
		
		if(scenicspot.getName()!=null){
			tmp.setName(scenicspot.getName());
			
			flag++;
		}
		
		if(scenicspot.getDescription()!=null){
			tmp.setDescription(scenicspot.getDescription());
			
			flag++;
		}
		
		if(scenicspot.getImage()!=null){
			tmp.setImage(scenicspot.getImage());
			
			flag++;
		}
		
		if(scenicspot.getCreateuser()!=null){
			tmp.setCreateuser(scenicspot.getCreateuser());
			
			flag++;
		}
		
		if(scenicspot.getCreatetime()!=null){
			tmp.setCreatetime(scenicspot.getCreatetime());
			
			flag++;
		}
		
		if(scenicspot.getModifyuser()!=null){
			tmp.setModifyuser(scenicspot.getModifyuser());
			
			flag++;
		}
		
		if(scenicspot.getModifytime()!=null){
			tmp.setModifytime(scenicspot.getModifytime());
			
			flag++;
		}
		
		if(scenicspot.getPrice()!=null){
			tmp.setPrice(scenicspot.getPrice());
			
			flag++;
		}
		
		if(scenicspot.getSort()!=null){
			tmp.setSort(scenicspot.getSort());
			
			flag++;
		}
		
		if(scenicspot.getUcode()!=null){
			tmp.setUcode(scenicspot.getUcode());
			
			flag++;
		}
		
		if(scenicspot.getLanguage()!=null){
			tmp.setLanguage(scenicspot.getLanguage());
			
			flag++;
		}
		
		if(scenicspot.getRegionid()!=null){
			tmp.setRegionid(scenicspot.getRegionid());
			
			flag++;
		}
		
		if(scenicspot.getCityid()!=null){
			tmp.setCityid(scenicspot.getCityid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateScenicspot",tmp);
		}
	}
	
	/**
	 * 查找 景点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspot(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Scenicspot.COL_language+" = 0 OR "+Scenicspot.COL_language+" is NULL)";
		}
		else if(where.indexOf(Scenicspot.COL_language)<0)
		{
			where+=" and ("+Scenicspot.COL_language+" = 0 OR "+Scenicspot.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllScenicspot",map, offset, limit);
	}
		
	
	/**
	 * 查找 景点
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspot(long id){
		return (Scenicspot)(getSqlMapClientTemplate().queryForObject("findScenicspot",id));
	}
	/**
	 * 查找 景点 by language
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspotbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Scenicspot.COL_ucode+" = "+id+" and "+Scenicspot.COL_language+" = "+language;	
		List list=findAllScenicspot(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Scenicspot)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 景点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScenicspot(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Scenicspot.COL_language+" = 0";
		}
		else if(where.indexOf(Scenicspot.COL_language)<0)
		{
			where+=" and "+Scenicspot.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countScenicspotBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllScenicspot",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspot(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllScenicspotBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScenicspotBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteScenicspotBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScenicspotBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countScenicspotBySql",map).toString()));
	}
}

