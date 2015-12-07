/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.conferencehotel;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ConferencehotelManager extends  SqlMapClientDaoSupport  implements IConferencehotelManager{ 
	
  
 	/**
	 * 创建 会议酒店
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehotel createConferencehotel(Conferencehotel conferencehotel) throws SQLException{
	
		if(conferencehotel.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		conferencehotel.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CONFERENCEHOTEL"));
		getSqlMapClientTemplate().insert("createConferencehotel",conferencehotel);
		if(conferencehotel.getUcode()==null||conferencehotel.getUcode()<1)
		{
			conferencehotel.setUcode(conferencehotel.getId());
			updateConferencehotelIgnoreNull(conferencehotel);
		}
		return conferencehotel;
	}
	/**
	 * 删除 会议酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehotel(long id){
	
		return getSqlMapClientTemplate().delete("deleteConferencehotel", id);
	}
	
	
	/**
	 * 修改 会议酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehotel(Conferencehotel conferencehotel){
		return getSqlMapClientTemplate().update("updateConferencehotel",conferencehotel);
	
	}

		
	/**
	 * 修改 会议酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehotelIgnoreNull(Conferencehotel conferencehotel){
		Conferencehotel tmp = findConferencehotel(conferencehotel.getId());
		int flag =0;
		
		
		if(conferencehotel.getName()!=null){
			tmp.setName(conferencehotel.getName());
			
			flag++;
		}
		
		if(conferencehotel.getStar()!=null){
			tmp.setStar(conferencehotel.getStar());
			
			flag++;
		}
		
		if(conferencehotel.getHallnum()!=null){
			tmp.setHallnum(conferencehotel.getHallnum());
			
			flag++;
		}
		
		if(conferencehotel.getCity()!=null){
			tmp.setCity(conferencehotel.getCity());
			
			flag++;
		}
		
		if(conferencehotel.getAddress()!=null){
			tmp.setAddress(conferencehotel.getAddress());
			
			flag++;
		}
		
		if(conferencehotel.getPhone()!=null){
			tmp.setPhone(conferencehotel.getPhone());
			
			flag++;
		}
		
		if(conferencehotel.getDesc()!=null){
			tmp.setDesc(conferencehotel.getDesc());
			
			flag++;
		}
		
		if(conferencehotel.getPic()!=null){
			tmp.setPic(conferencehotel.getPic());
			
			flag++;
		}
		
		if(conferencehotel.getUcode()!=null){
			tmp.setUcode(conferencehotel.getUcode());
			
			flag++;
		}
		
		if(conferencehotel.getLanguage()!=null){
			tmp.setLanguage(conferencehotel.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateConferencehotel",tmp);
		}
	}
	
	/**
	 * 查找 会议酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotel(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Conferencehotel.COL_language+" = 0 OR "+Conferencehotel.COL_language+" is NULL)";
		}
		else if(where.indexOf(Conferencehotel.COL_language)<0)
		{
			where+=" and ("+Conferencehotel.COL_language+" = 0 OR "+Conferencehotel.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllConferencehotel",map, offset, limit);
	}
		
	
	/**
	 * 查找 会议酒店
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotel(long id){
		return (Conferencehotel)(getSqlMapClientTemplate().queryForObject("findConferencehotel",id));
	}
	/**
	 * 查找 会议酒店 by language
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotelbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Conferencehotel.COL_ucode+" = "+id+" and "+Conferencehotel.COL_language+" = "+language;	
		List list=findAllConferencehotel(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Conferencehotel)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 会议酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehotel(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Conferencehotel.COL_language+" = 0";
		}
		else if(where.indexOf(Conferencehotel.COL_language)<0)
		{
			where+=" and "+Conferencehotel.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countConferencehotelBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllConferencehotel",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会议酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotel(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllConferencehotelBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会议酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehotelBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteConferencehotelBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehotelBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countConferencehotelBySql",map).toString()));
	}
}

