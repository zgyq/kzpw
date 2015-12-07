/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomstate;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RoomstateManager extends  SqlMapClientDaoSupport  implements IRoomstateManager{ 
	
  
 	/**
	 * 创建 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public Roomstate createRoomstate(Roomstate roomstate) throws SQLException{
	
		if(roomstate.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		roomstate.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ROOMSTATE"));
		getSqlMapClientTemplate().insert("createRoomstate",roomstate);
		if(roomstate.getUcode()==null||roomstate.getUcode()<1)
		{
			roomstate.setUcode(roomstate.getId());
			updateRoomstateIgnoreNull(roomstate);
		}
		return roomstate;
	}
	/**
	 * 删除 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstate(long id){
	
		return getSqlMapClientTemplate().delete("deleteRoomstate", id);
	}
	
	
	/**
	 * 修改 酒店房态
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstate(Roomstate roomstate){
		return getSqlMapClientTemplate().update("updateRoomstate",roomstate);
	
	}

		
	/**
	 * 修改 酒店房态但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstateIgnoreNull(Roomstate roomstate){
		Roomstate tmp = findRoomstate(roomstate.getId());
		int flag =0;
		
		
		if(roomstate.getRoomtypeid()!=null){
			tmp.setRoomtypeid(roomstate.getRoomtypeid());
			
			flag++;
		}
		
		if(roomstate.getStartdate()!=null){
			tmp.setStartdate(roomstate.getStartdate());
			
			flag++;
		}
		
		if(roomstate.getEnddate()!=null){
			tmp.setEnddate(roomstate.getEnddate());
			
			flag++;
		}
		
		if(roomstate.getState()!=null){
			tmp.setState(roomstate.getState());
			
			flag++;
		}
		
		if(roomstate.getConfirmmethod()!=null){
			tmp.setConfirmmethod(roomstate.getConfirmmethod());
			
			flag++;
		}
		
		if(roomstate.getType()!=null){
			tmp.setType(roomstate.getType());
			
			flag++;
		}
		
		if(roomstate.getNum()!=null){
			tmp.setNum(roomstate.getNum());
			
			flag++;
		}
		
		if(roomstate.getCreateuser()!=null){
			tmp.setCreateuser(roomstate.getCreateuser());
			
			flag++;
		}
		
		if(roomstate.getCreatetime()!=null){
			tmp.setCreatetime(roomstate.getCreatetime());
			
			flag++;
		}
		
		if(roomstate.getModifyuser()!=null){
			tmp.setModifyuser(roomstate.getModifyuser());
			
			flag++;
		}
		
		if(roomstate.getModifytime()!=null){
			tmp.setModifytime(roomstate.getModifytime());
			
			flag++;
		}
		
		if(roomstate.getUcode()!=null){
			tmp.setUcode(roomstate.getUcode());
			
			flag++;
		}
		
		if(roomstate.getLanguage()!=null){
			tmp.setLanguage(roomstate.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRoomstate",tmp);
		}
	}
	
	/**
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Roomstate.COL_language+" = 0 OR "+Roomstate.COL_language+" is NULL)";
		}
		else if(where.indexOf(Roomstate.COL_language)<0)
		{
			where+=" and ("+Roomstate.COL_language+" = 0 OR "+Roomstate.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRoomstate",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店房态
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstate(long id){
		return (Roomstate)(getSqlMapClientTemplate().queryForObject("findRoomstate",id));
	}
	/**
	 * 查找 酒店房态 by language
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstatebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Roomstate.COL_ucode+" = "+id+" and "+Roomstate.COL_language+" = "+language;	
		List list=findAllRoomstate(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Roomstate)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Roomstate.COL_language+" = 0";
		}
		else if(where.indexOf(Roomstate.COL_language)<0)
		{
			where+=" and "+Roomstate.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRoomstateBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRoomstate",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店房态
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRoomstateBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店房态
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRoomstateBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRoomstateBySql",map).toString()));
	}
}

