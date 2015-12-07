/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelcontract;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelcontractManager extends  SqlMapClientDaoSupport  implements IHotelcontractManager{ 
	
  
 	/**
	 * 创建 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public Hotelcontract createHotelcontract(Hotelcontract hotelcontract) throws SQLException{
	
		if(hotelcontract.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelcontract.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "C_HOTELCONTRACT"));
		getSqlMapClientTemplate().insert("createHotelcontract",hotelcontract);
		if(hotelcontract.getUcode()==null||hotelcontract.getUcode()<1)
		{
			hotelcontract.setUcode(hotelcontract.getId());
			updateHotelcontractIgnoreNull(hotelcontract);
		}
		return hotelcontract;
	}
	/**
	 * 删除 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelcontract(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelcontract", id);
	}
	
	
	/**
	 * 修改 酒店合同
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelcontract(Hotelcontract hotelcontract){
		return getSqlMapClientTemplate().update("updateHotelcontract",hotelcontract);
	
	}

		
	/**
	 * 修改 酒店合同但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelcontractIgnoreNull(Hotelcontract hotelcontract){
		Hotelcontract tmp = findHotelcontract(hotelcontract.getId());
		int flag =0;
		
		
		if(hotelcontract.getHotelid()!=null){
			tmp.setHotelid(hotelcontract.getHotelid());
			
			flag++;
		}
		
		if(hotelcontract.getCode()!=null){
			tmp.setCode(hotelcontract.getCode());
			
			flag++;
		}
		
		if(hotelcontract.getSigndate()!=null){
			tmp.setSigndate(hotelcontract.getSigndate());
			
			flag++;
		}
		
		if(hotelcontract.getEnddate()!=null){
			tmp.setEnddate(hotelcontract.getEnddate());
			
			flag++;
		}
		
		if(hotelcontract.getHotelsigner()!=null){
			tmp.setHotelsigner(hotelcontract.getHotelsigner());
			
			flag++;
		}
		
		if(hotelcontract.getCompsigner()!=null){
			tmp.setCompsigner(hotelcontract.getCompsigner());
			
			flag++;
		}
		
		if(hotelcontract.getContent()!=null){
			tmp.setContent(hotelcontract.getContent());
			
			flag++;
		}
		
		if(hotelcontract.getFilepath()!=null){
			tmp.setFilepath(hotelcontract.getFilepath());
			
			flag++;
		}
		
		if(hotelcontract.getState()!=null){
			tmp.setState(hotelcontract.getState());
			
			flag++;
		}
		
		if(hotelcontract.getDescription()!=null){
			tmp.setDescription(hotelcontract.getDescription());
			
			flag++;
		}
		
		if(hotelcontract.getUcode()!=null){
			tmp.setUcode(hotelcontract.getUcode());
			
			flag++;
		}
		
		if(hotelcontract.getLanguage()!=null){
			tmp.setLanguage(hotelcontract.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelcontract",tmp);
		}
	}
	
	/**
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotelcontract.COL_language+" = 0 OR "+Hotelcontract.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotelcontract.COL_language)<0)
		{
			where+=" and ("+Hotelcontract.COL_language+" = 0 OR "+Hotelcontract.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelcontract",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店合同
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontract(long id){
		return (Hotelcontract)(getSqlMapClientTemplate().queryForObject("findHotelcontract",id));
	}
	/**
	 * 查找 酒店合同 by language
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontractbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotelcontract.COL_ucode+" = "+id+" and "+Hotelcontract.COL_language+" = "+language;	
		List list=findAllHotelcontract(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotelcontract)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotelcontract.COL_language+" = 0";
		}
		else if(where.indexOf(Hotelcontract.COL_language)<0)
		{
			where+=" and "+Hotelcontract.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelcontractBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelcontract",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店合同
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelcontractBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店合同
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelcontractBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelcontractBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelcontractBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelcontractBySql",map).toString()));
	}
}

