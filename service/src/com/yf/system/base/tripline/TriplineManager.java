/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tripline;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriplineManager extends  SqlMapClientDaoSupport  implements ITriplineManager{ 
	
  
 	/**
	 * 创建 旅行线路
	 * @param id
	 * @return deleted count 
	 */
	public Tripline createTripline(Tripline tripline) throws SQLException{
	
		if(tripline.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		tripline.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPLINE"));
		getSqlMapClientTemplate().insert("createTripline",tripline);
		if(tripline.getUcode()==null||tripline.getUcode()<1)
		{
			tripline.setUcode(tripline.getId());
			updateTriplineIgnoreNull(tripline);
		}
		return tripline;
	}
	/**
	 * 删除 旅行线路
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTripline(long id){
	
		return getSqlMapClientTemplate().delete("deleteTripline", id);
	}
	
	
	/**
	 * 修改 旅行线路
	 * @param id
	 * @return updated count 
	 */
	public int updateTripline(Tripline tripline){
		return getSqlMapClientTemplate().update("updateTripline",tripline);
	
	}

		
	/**
	 * 修改 旅行线路但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplineIgnoreNull(Tripline tripline){
		Tripline tmp = findTripline(tripline.getId());
		int flag =0;
		
		
		if(tripline.getName()!=null){
			tmp.setName(tripline.getName());
			
			flag++;
		}
		
		if(tripline.getCreateuser()!=null){
			tmp.setCreateuser(tripline.getCreateuser());
			
			flag++;
		}
		
		if(tripline.getCreatetime()!=null){
			tmp.setCreatetime(tripline.getCreatetime());
			
			flag++;
		}
		
		if(tripline.getModifyuser()!=null){
			tmp.setModifyuser(tripline.getModifyuser());
			
			flag++;
		}
		
		if(tripline.getModifytime()!=null){
			tmp.setModifytime(tripline.getModifytime());
			
			flag++;
		}
		
		if(tripline.getDescription()!=null){
			tmp.setDescription(tripline.getDescription());
			
			flag++;
		}
		
		if(tripline.getPrice()!=null){
			tmp.setPrice(tripline.getPrice());
			
			flag++;
		}
		
		if(tripline.getStartprice()!=null){
			tmp.setStartprice(tripline.getStartprice());
			
			flag++;
		}
		
		if(tripline.getProprice()!=null){
			tmp.setProprice(tripline.getProprice());
			
			flag++;
		}
		
		if(tripline.getPredesc()!=null){
			tmp.setPredesc(tripline.getPredesc());
			
			flag++;
		}
		
		if(tripline.getCityid()!=null){
			tmp.setCityid(tripline.getCityid());
			
			flag++;
		}
		
		if(tripline.getStartrange()!=null){
			tmp.setStartrange(tripline.getStartrange());
			
			flag++;
		}
		
		if(tripline.getCustomeragentid()!=null){
			tmp.setCustomeragentid(tripline.getCustomeragentid());
			
			flag++;
		}
		
		if(tripline.getStartdate()!=null){
			tmp.setStartdate(tripline.getStartdate());
			
			flag++;
		}
		
		if(tripline.getImage()!=null){
			tmp.setImage(tripline.getImage());
			
			flag++;
		}
		
		if(tripline.getEndcityid()!=null){
			tmp.setEndcityid(tripline.getEndcityid());
			
			flag++;
		}
		
		if(tripline.getUcode()!=null){
			tmp.setUcode(tripline.getUcode());
			
			flag++;
		}
		
		if(tripline.getLanguage()!=null){
			tmp.setLanguage(tripline.getLanguage());
			
			flag++;
		}
		
		if(tripline.getTypeid()!=null){
			tmp.setTypeid(tripline.getTypeid());
			
			flag++;
		}
		
		if(tripline.getLongname()!=null){
			tmp.setLongname(tripline.getLongname());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTripline",tmp);
		}
	}
	
	/**
	 * 查找 旅行线路
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Tripline.COL_language+" = 0 OR "+Tripline.COL_language+" is NULL)";
		}
		else if(where.indexOf(Tripline.COL_language)<0)
		{
			where+=" and ("+Tripline.COL_language+" = 0 OR "+Tripline.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTripline",map, offset, limit);
	}
		
	
	/**
	 * 查找 旅行线路
	 * @param id
	 * @return
	 */
	public Tripline findTripline(long id){
		return (Tripline)(getSqlMapClientTemplate().queryForObject("findTripline",id));
	}
	/**
	 * 查找 旅行线路 by language
	 * @param id
	 * @return
	 */
	public Tripline findTriplinebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Tripline.COL_ucode+" = "+id+" and "+Tripline.COL_language+" = "+language;	
		List list=findAllTripline(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Tripline)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 旅行线路
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripline(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Tripline.COL_language+" = 0";
		}
		else if(where.indexOf(Tripline.COL_language)<0)
		{
			where+=" and "+Tripline.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriplineBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTripline",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找旅行线路
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriplineBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 旅行线路
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplineBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriplineBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplineBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriplineBySql",map).toString()));
	}
}

