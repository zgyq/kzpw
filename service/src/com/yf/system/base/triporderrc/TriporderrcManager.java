/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triporderrc;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriporderrcManager extends  SqlMapClientDaoSupport  implements ITriporderrcManager{ 
	
  
 	/**
	 * 创建 旅行订单记录
	 * @param id
	 * @return deleted count 
	 */
	public Triporderrc createTriporderrc(Triporderrc triporderrc) throws SQLException{
	
		if(triporderrc.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		triporderrc.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPORDERRC"));
		getSqlMapClientTemplate().insert("createTriporderrc",triporderrc);
		if(triporderrc.getUcode()==null||triporderrc.getUcode()<1)
		{
			triporderrc.setUcode(triporderrc.getId());
			updateTriporderrcIgnoreNull(triporderrc);
		}
		return triporderrc;
	}
	/**
	 * 删除 旅行订单记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriporderrc(long id){
	
		return getSqlMapClientTemplate().delete("deleteTriporderrc", id);
	}
	
	
	/**
	 * 修改 旅行订单记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTriporderrc(Triporderrc triporderrc){
		return getSqlMapClientTemplate().update("updateTriporderrc",triporderrc);
	
	}

		
	/**
	 * 修改 旅行订单记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriporderrcIgnoreNull(Triporderrc triporderrc){
		Triporderrc tmp = findTriporderrc(triporderrc.getId());
		int flag =0;
		
		
		if(triporderrc.getOrderid()!=null){
			tmp.setOrderid(triporderrc.getOrderid());
			
			flag++;
		}
		
		if(triporderrc.getHandleuser()!=null){
			tmp.setHandleuser(triporderrc.getHandleuser());
			
			flag++;
		}
		
		if(triporderrc.getContent()!=null){
			tmp.setContent(triporderrc.getContent());
			
			flag++;
		}
		
		if(triporderrc.getCreatetime()!=null){
			tmp.setCreatetime(triporderrc.getCreatetime());
			
			flag++;
		}
		
		if(triporderrc.getDescription()!=null){
			tmp.setDescription(triporderrc.getDescription());
			
			flag++;
		}
		
		if(triporderrc.getLinktell()!=null){
			tmp.setLinktell(triporderrc.getLinktell());
			
			flag++;
		}
		
		if(triporderrc.getState()!=null){
			tmp.setState(triporderrc.getState());
			
			flag++;
		}
		
		if(triporderrc.getUcode()!=null){
			tmp.setUcode(triporderrc.getUcode());
			
			flag++;
		}
		
		if(triporderrc.getLanguage()!=null){
			tmp.setLanguage(triporderrc.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTriporderrc",tmp);
		}
	}
	
	/**
	 * 查找 旅行订单记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrc(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Triporderrc.COL_language+" = 0 OR "+Triporderrc.COL_language+" is NULL)";
		}
		else if(where.indexOf(Triporderrc.COL_language)<0)
		{
			where+=" and ("+Triporderrc.COL_language+" = 0 OR "+Triporderrc.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTriporderrc",map, offset, limit);
	}
		
	
	/**
	 * 查找 旅行订单记录
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrc(long id){
		return (Triporderrc)(getSqlMapClientTemplate().queryForObject("findTriporderrc",id));
	}
	/**
	 * 查找 旅行订单记录 by language
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrcbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Triporderrc.COL_ucode+" = "+id+" and "+Triporderrc.COL_language+" = "+language;	
		List list=findAllTriporderrc(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Triporderrc)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 旅行订单记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporderrc(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Triporderrc.COL_language+" = 0";
		}
		else if(where.indexOf(Triporderrc.COL_language)<0)
		{
			where+=" and "+Triporderrc.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriporderrcBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTriporderrc",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找旅行订单记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrc(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriporderrcBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 旅行订单记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriporderrcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriporderrcBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriporderrcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriporderrcBySql",map).toString()));
	}
}

