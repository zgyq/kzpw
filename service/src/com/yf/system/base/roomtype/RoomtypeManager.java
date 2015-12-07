/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomtype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RoomtypeManager extends  SqlMapClientDaoSupport  implements IRoomtypeManager{ 
	
  
 	/**
	 * 创建 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public Roomtype createRoomtype(Roomtype roomtype) throws SQLException{
	
		if(roomtype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		roomtype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ROOMTYPE"));
		getSqlMapClientTemplate().insert("createRoomtype",roomtype);
		if(roomtype.getUcode()==null||roomtype.getUcode()<1)
		{
			roomtype.setUcode(roomtype.getId());
			updateRoomtypeIgnoreNull(roomtype);
		}
		return roomtype;
	}
	/**
	 * 删除 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomtype(long id){
	
		return getSqlMapClientTemplate().delete("deleteRoomtype", id);
	}
	
	
	/**
	 * 修改 酒店房型
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomtype(Roomtype roomtype){
		return getSqlMapClientTemplate().update("updateRoomtype",roomtype);
	
	}

		
	/**
	 * 修改 酒店房型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomtypeIgnoreNull(Roomtype roomtype){
		Roomtype tmp = findRoomtype(roomtype.getId());
		int flag =0;
		
		
		if(roomtype.getName()!=null){
			tmp.setName(roomtype.getName());
			
			flag++;
		}
		
		if(roomtype.getAreadesc()!=null){
			tmp.setAreadesc(roomtype.getAreadesc());
			
			flag++;
		}
		
		if(roomtype.getRoomdesc()!=null){
			tmp.setRoomdesc(roomtype.getRoomdesc());
			
			flag++;
		}
		if(roomtype.getRoomcode()!=null){
			tmp.setRoomcode(roomtype.getRoomcode());
			
			flag++;
		}
		
		if(roomtype.getBed()!=null){
			tmp.setBed(roomtype.getBed());
			
			flag++;
		}
		
		if(roomtype.getRoomset()!=null){
			tmp.setRoomset(roomtype.getRoomset());
			
			flag++;
		}
		
		if(roomtype.getState()!=null){
			tmp.setState(roomtype.getState());
			
			flag++;
		}
		
		if(roomtype.getHotelid()!=null){
			tmp.setHotelid(roomtype.getHotelid());
			
			flag++;
		}
		
		if(roomtype.getLayer()!=null){
			tmp.setLayer(roomtype.getLayer());
			
			flag++;
		}
		
		if(roomtype.getBreakfast()!=null){
			tmp.setBreakfast(roomtype.getBreakfast());
			
			flag++;
		}
		
		if(roomtype.getWideband()!=null){
			tmp.setWideband(roomtype.getWideband());
			
			flag++;
		}
		
		if(roomtype.getUcode()!=null){
			tmp.setUcode(roomtype.getUcode());
			
			flag++;
		}
		
		if(roomtype.getLanguage()!=null){
			tmp.setLanguage(roomtype.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRoomtype",tmp);
		}
	}
	
	/**
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Roomtype.COL_language+" = 0 OR "+Roomtype.COL_language+" is NULL)";
		}
		else if(where.indexOf(Roomtype.COL_language)<0)
		{
			where+=" and ("+Roomtype.COL_language+" = 0 OR "+Roomtype.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRoomtype",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店房型
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtype(long id){
		return (Roomtype)(getSqlMapClientTemplate().queryForObject("findRoomtype",id));
	}
	/**
	 * 查找 酒店房型 by language
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtypebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Roomtype.COL_ucode+" = "+id+" and "+Roomtype.COL_language+" = "+language;	
		List list=findAllRoomtype(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Roomtype)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Roomtype.COL_language+" = 0";
		}
		else if(where.indexOf(Roomtype.COL_language)<0)
		{
			where+=" and "+Roomtype.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRoomtypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRoomtype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店房型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRoomtypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店房型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRoomtypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRoomtypeBySql",map).toString()));
	}
}

