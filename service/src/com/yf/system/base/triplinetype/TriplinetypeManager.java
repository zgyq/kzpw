/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triplinetype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriplinetypeManager extends  SqlMapClientDaoSupport  implements ITriplinetypeManager{ 
	
  
 	/**
	 * 创建 旅游线路类型表
	 * @param id
	 * @return deleted count 
	 */
	public Triplinetype createTriplinetype(Triplinetype triplinetype) throws SQLException{
	
		if(triplinetype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		triplinetype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPLINETYPE"));
		getSqlMapClientTemplate().insert("createTriplinetype",triplinetype);
		if(triplinetype.getUcode()==null||triplinetype.getUcode()<1)
		{
			triplinetype.setUcode(triplinetype.getId());
			updateTriplinetypeIgnoreNull(triplinetype);
		}
		return triplinetype;
	}
	/**
	 * 删除 旅游线路类型表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriplinetype(long id){
	
		return getSqlMapClientTemplate().delete("deleteTriplinetype", id);
	}
	
	
	/**
	 * 修改 旅游线路类型表
	 * @param id
	 * @return updated count 
	 */
	public int updateTriplinetype(Triplinetype triplinetype){
		return getSqlMapClientTemplate().update("updateTriplinetype",triplinetype);
	
	}

		
	/**
	 * 修改 旅游线路类型表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplinetypeIgnoreNull(Triplinetype triplinetype){
		Triplinetype tmp = findTriplinetype(triplinetype.getId());
		int flag =0;
		
		
		if(triplinetype.getName()!=null){
			tmp.setName(triplinetype.getName());
			
			flag++;
		}
		
		if(triplinetype.getCreateuser()!=null){
			tmp.setCreateuser(triplinetype.getCreateuser());
			
			flag++;
		}
		
		if(triplinetype.getCreatetime()!=null){
			tmp.setCreatetime(triplinetype.getCreatetime());
			
			flag++;
		}
		
		if(triplinetype.getModifyuser()!=null){
			tmp.setModifyuser(triplinetype.getModifyuser());
			
			flag++;
		}
		
		if(triplinetype.getModifytime()!=null){
			tmp.setModifytime(triplinetype.getModifytime());
			
			flag++;
		}
		
		if(triplinetype.getUcode()!=null){
			tmp.setUcode(triplinetype.getUcode());
			
			flag++;
		}
		
		if(triplinetype.getLanguage()!=null){
			tmp.setLanguage(triplinetype.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTriplinetype",tmp);
		}
	}
	
	/**
	 * 查找 旅游线路类型表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetype(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Triplinetype.COL_language+" = 0 OR "+Triplinetype.COL_language+" is NULL)";
		}
		else if(where.indexOf(Triplinetype.COL_language)<0)
		{
			where+=" and ("+Triplinetype.COL_language+" = 0 OR "+Triplinetype.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTriplinetype",map, offset, limit);
	}
		
	
	/**
	 * 查找 旅游线路类型表
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetype(long id){
		return (Triplinetype)(getSqlMapClientTemplate().queryForObject("findTriplinetype",id));
	}
	/**
	 * 查找 旅游线路类型表 by language
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetypebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Triplinetype.COL_ucode+" = "+id+" and "+Triplinetype.COL_language+" = "+language;	
		List list=findAllTriplinetype(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Triplinetype)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 旅游线路类型表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinetype(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Triplinetype.COL_language+" = 0";
		}
		else if(where.indexOf(Triplinetype.COL_language)<0)
		{
			where+=" and "+Triplinetype.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriplinetypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTriplinetype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找旅游线路类型表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriplinetypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 旅游线路类型表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplinetypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriplinetypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplinetypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriplinetypeBySql",map).toString()));
	}
}

