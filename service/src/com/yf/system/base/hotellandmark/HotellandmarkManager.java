/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotellandmark;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotellandmarkManager extends  SqlMapClientDaoSupport  implements IHotellandmarkManager{ 
	
  
 	/**
	 * 创建 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public Hotellandmark createHotellandmark(Hotellandmark hotellandmark) throws SQLException{
	
		if(hotellandmark.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotellandmark.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELLANDMARK"));
		getSqlMapClientTemplate().insert("createHotellandmark",hotellandmark);
		if(hotellandmark.getUcode()==null||hotellandmark.getUcode()<1)
		{
			hotellandmark.setUcode(hotellandmark.getId());
			updateHotellandmarkIgnoreNull(hotellandmark);
		}
		return hotellandmark;
	}
	/**
	 * 删除 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellandmark(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotellandmark", id);
	}
	
	
	/**
	 * 修改 酒店地标
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellandmark(Hotellandmark hotellandmark){
		return getSqlMapClientTemplate().update("updateHotellandmark",hotellandmark);
	
	}

		
	/**
	 * 修改 酒店地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellandmarkIgnoreNull(Hotellandmark hotellandmark){
		Hotellandmark tmp = findHotellandmark(hotellandmark.getId());
		int flag =0;
		
		
		if(hotellandmark.getLandmarkid()!=null){
			tmp.setLandmarkid(hotellandmark.getLandmarkid());
			
			flag++;
		}
		
		if(hotellandmark.getHotelid()!=null){
			tmp.setHotelid(hotellandmark.getHotelid());
			
			flag++;
		}
		
		if(hotellandmark.getDescription()!=null){
			tmp.setDescription(hotellandmark.getDescription());
			
			flag++;
		}
		
		if(hotellandmark.getRange()!=null){
			tmp.setRange(hotellandmark.getRange());
			
			flag++;
		}
		
		if(hotellandmark.getUcode()!=null){
			tmp.setUcode(hotellandmark.getUcode());
			
			flag++;
		}
		
		if(hotellandmark.getLanguage()!=null){
			tmp.setLanguage(hotellandmark.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotellandmark",tmp);
		}
	}
	
	/**
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotellandmark.COL_language+" = 0 OR "+Hotellandmark.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotellandmark.COL_language)<0)
		{
			where+=" and ("+Hotellandmark.COL_language+" = 0 OR "+Hotellandmark.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotellandmark",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店地标
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmark(long id){
		return (Hotellandmark)(getSqlMapClientTemplate().queryForObject("findHotellandmark",id));
	}
	/**
	 * 查找 酒店地标 by language
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmarkbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotellandmark.COL_ucode+" = "+id+" and "+Hotellandmark.COL_language+" = "+language;	
		List list=findAllHotellandmark(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotellandmark)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotellandmark.COL_language+" = 0";
		}
		else if(where.indexOf(Hotellandmark.COL_language)<0)
		{
			where+=" and "+Hotellandmark.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotellandmarkBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotellandmark",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotellandmarkBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellandmarkBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotellandmarkBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellandmarkBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotellandmarkBySql",map).toString()));
	}
}

