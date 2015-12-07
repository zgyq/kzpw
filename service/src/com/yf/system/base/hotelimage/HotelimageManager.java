/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelimage;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelimageManager extends  SqlMapClientDaoSupport  implements IHotelimageManager{ 
	
  
 	/**
	 * 创建 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public Hotelimage createHotelimage(Hotelimage hotelimage) throws SQLException{
	
		if(hotelimage.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelimage.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELIMAGE"));
		getSqlMapClientTemplate().insert("createHotelimage",hotelimage);
		if(hotelimage.getUcode()==null||hotelimage.getUcode()<1)
		{
			hotelimage.setUcode(hotelimage.getId());
			updateHotelimageIgnoreNull(hotelimage);
		}
		return hotelimage;
	}
	/**
	 * 删除 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelimage(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelimage", id);
	}
	
	
	/**
	 * 修改 酒店图片
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelimage(Hotelimage hotelimage){
		return getSqlMapClientTemplate().update("updateHotelimage",hotelimage);
	
	}

		
	/**
	 * 修改 酒店图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelimageIgnoreNull(Hotelimage hotelimage){
		Hotelimage tmp = findHotelimage(hotelimage.getId());
		int flag =0;
		
		
		if(hotelimage.getPath()!=null){
			tmp.setPath(hotelimage.getPath());
			
			flag++;
		}
		
		if(hotelimage.getType()!=null){
			tmp.setType(hotelimage.getType());
			
			flag++;
		}
		
		if(hotelimage.getDescription()!=null){
			tmp.setDescription(hotelimage.getDescription());
			
			flag++;
		}
		
		if(hotelimage.getHotelid()!=null){
			tmp.setHotelid(hotelimage.getHotelid());
			
			flag++;
		}
		
		if(hotelimage.getUcode()!=null){
			tmp.setUcode(hotelimage.getUcode());
			
			flag++;
		}
		
		if(hotelimage.getLanguage()!=null){
			tmp.setLanguage(hotelimage.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelimage",tmp);
		}
	}
	
	/**
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimage(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotelimage.COL_language+" = 0 OR "+Hotelimage.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotelimage.COL_language)<0)
		{
			where+=" and ("+Hotelimage.COL_language+" = 0 OR "+Hotelimage.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelimage",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店图片
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimage(long id){
		return (Hotelimage)(getSqlMapClientTemplate().queryForObject("findHotelimage",id));
	}
	/**
	 * 查找 酒店图片 by language
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimagebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotelimage.COL_ucode+" = "+id+" and "+Hotelimage.COL_language+" = "+language;	
		List list=findAllHotelimage(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotelimage)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelimage(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotelimage.COL_language+" = 0";
		}
		else if(where.indexOf(Hotelimage.COL_language)<0)
		{
			where+=" and "+Hotelimage.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelimageBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelimage",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimage(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelimageBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelimageBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelimageBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelimageBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelimageBySql",map).toString()));
	}
}

