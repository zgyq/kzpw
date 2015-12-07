/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelspec;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelspecManager extends  SqlMapClientDaoSupport  implements IHotelspecManager{ 
	
  
 	/**
	 * 创建 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public Hotelspec createHotelspec(Hotelspec hotelspec) throws SQLException{
	
		if(hotelspec.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelspec.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "C_HOTELSPEC"));
		getSqlMapClientTemplate().insert("createHotelspec",hotelspec);
		if(hotelspec.getUcode()==null||hotelspec.getUcode()<1)
		{
			hotelspec.setUcode(hotelspec.getId());
			updateHotelspecIgnoreNull(hotelspec);
		}
		return hotelspec;
	}
	/**
	 * 删除 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelspec(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelspec", id);
	}
	
	
	/**
	 * 修改 酒店注意事项
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelspec(Hotelspec hotelspec){
		return getSqlMapClientTemplate().update("updateHotelspec",hotelspec);
	
	}

		
	/**
	 * 修改 酒店注意事项但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelspecIgnoreNull(Hotelspec hotelspec){
		Hotelspec tmp = findHotelspec(hotelspec.getId());
		int flag =0;
		
		
		if(hotelspec.getStartdate()!=null){
			tmp.setStartdate(hotelspec.getStartdate());
			
			flag++;
		}
		
		if(hotelspec.getEnddate()!=null){
			tmp.setEnddate(hotelspec.getEnddate());
			
			flag++;
		}
		
		if(hotelspec.getState()!=null){
			tmp.setState(hotelspec.getState());
			
			flag++;
		}
		
		if(hotelspec.getHotelid()!=null){
			tmp.setHotelid(hotelspec.getHotelid());
			
			flag++;
		}
		
		if(hotelspec.getDescription()!=null){
			tmp.setDescription(hotelspec.getDescription());
			
			flag++;
		}
		
		if(hotelspec.getCreateuser()!=null){
			tmp.setCreateuser(hotelspec.getCreateuser());
			
			flag++;
		}
		
		if(hotelspec.getCreatetime()!=null){
			tmp.setCreatetime(hotelspec.getCreatetime());
			
			flag++;
		}
		
		if(hotelspec.getModifyuser()!=null){
			tmp.setModifyuser(hotelspec.getModifyuser());
			
			flag++;
		}
		
		if(hotelspec.getModifytime()!=null){
			tmp.setModifytime(hotelspec.getModifytime());
			
			flag++;
		}
		
		if(hotelspec.getUcode()!=null){
			tmp.setUcode(hotelspec.getUcode());
			
			flag++;
		}
		
		if(hotelspec.getLanguage()!=null){
			tmp.setLanguage(hotelspec.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelspec",tmp);
		}
	}
	
	/**
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspec(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotelspec.COL_language+" = 0 OR "+Hotelspec.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotelspec.COL_language)<0)
		{
			where+=" and ("+Hotelspec.COL_language+" = 0 OR "+Hotelspec.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelspec",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店注意事项
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspec(long id){
		return (Hotelspec)(getSqlMapClientTemplate().queryForObject("findHotelspec",id));
	}
	/**
	 * 查找 酒店注意事项 by language
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspecbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotelspec.COL_ucode+" = "+id+" and "+Hotelspec.COL_language+" = "+language;	
		List list=findAllHotelspec(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotelspec)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelspec(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotelspec.COL_language+" = 0";
		}
		else if(where.indexOf(Hotelspec.COL_language)<0)
		{
			where+=" and "+Hotelspec.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelspecBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelspec",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店注意事项
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspec(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelspecBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店注意事项
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelspecBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelspecBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelspecBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelspecBySql",map).toString()));
	}
}

