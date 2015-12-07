/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelorderrc;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelorderrcManager extends  SqlMapClientDaoSupport  implements IHotelorderrcManager{ 
	
  
 	/**
	 * 创建 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorderrc createHotelorderrc(Hotelorderrc hotelorderrc) throws SQLException{
	
		if(hotelorderrc.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelorderrc.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELORDERRC"));
		getSqlMapClientTemplate().insert("createHotelorderrc",hotelorderrc);
		if(hotelorderrc.getUcode()==null||hotelorderrc.getUcode()<1)
		{
			hotelorderrc.setUcode(hotelorderrc.getId());
			updateHotelorderrcIgnoreNull(hotelorderrc);
		}
		return hotelorderrc;
	}
	/**
	 * 删除 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorderrc(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelorderrc", id);
	}
	
	
	/**
	 * 修改 酒店订单状态日志
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorderrc(Hotelorderrc hotelorderrc){
		return getSqlMapClientTemplate().update("updateHotelorderrc",hotelorderrc);
	
	}

		
	/**
	 * 修改 酒店订单状态日志但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderrcIgnoreNull(Hotelorderrc hotelorderrc){
		Hotelorderrc tmp = findHotelorderrc(hotelorderrc.getId());
		int flag =0;
		
		
		if(hotelorderrc.getOrderid()!=null){
			tmp.setOrderid(hotelorderrc.getOrderid());
			
			flag++;
		}
		
		if(hotelorderrc.getHandleuser()!=null){
			tmp.setHandleuser(hotelorderrc.getHandleuser());
			
			flag++;
		}
		
		if(hotelorderrc.getContent()!=null){
			tmp.setContent(hotelorderrc.getContent());
			
			flag++;
		}
		
		if(hotelorderrc.getCreatetime()!=null){
			tmp.setCreatetime(hotelorderrc.getCreatetime());
			
			flag++;
		}
		
		if(hotelorderrc.getDescription()!=null){
			tmp.setDescription(hotelorderrc.getDescription());
			
			flag++;
		}
		
		if(hotelorderrc.getLinktell()!=null){
			tmp.setLinktell(hotelorderrc.getLinktell());
			
			flag++;
		}
		
		if(hotelorderrc.getState()!=null){
			tmp.setState(hotelorderrc.getState());
			
			flag++;
		}
		
		if(hotelorderrc.getUcode()!=null){
			tmp.setUcode(hotelorderrc.getUcode());
			
			flag++;
		}
		
		if(hotelorderrc.getLanguage()!=null){
			tmp.setLanguage(hotelorderrc.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelorderrc",tmp);
		}
	}
	
	/**
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotelorderrc.COL_language+" = 0 OR "+Hotelorderrc.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotelorderrc.COL_language)<0)
		{
			where+=" and ("+Hotelorderrc.COL_language+" = 0 OR "+Hotelorderrc.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelorderrc",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrc(long id){
		return (Hotelorderrc)(getSqlMapClientTemplate().queryForObject("findHotelorderrc",id));
	}
	/**
	 * 查找 酒店订单状态日志 by language
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrcbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotelorderrc.COL_ucode+" = "+id+" and "+Hotelorderrc.COL_language+" = "+language;	
		List list=findAllHotelorderrc(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotelorderrc)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotelorderrc.COL_language+" = 0";
		}
		else if(where.indexOf(Hotelorderrc.COL_language)<0)
		{
			where+=" and "+Hotelorderrc.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelorderrcBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelorderrc",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店订单状态日志
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelorderrcBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店订单状态日志
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderrcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelorderrcBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderrcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelorderrcBySql",map).toString()));
	}
}

