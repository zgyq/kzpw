/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airfee;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AirfeeManager extends  SqlMapClientDaoSupport  implements IAirfeeManager{ 
	
  
 	/**
	 * 创建 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public Airfee createAirfee(Airfee airfee) throws SQLException{
	
		if(airfee.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		airfee.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRFEE"));
		getSqlMapClientTemplate().insert("createAirfee",airfee);
		if(airfee.getUcode()==null||airfee.getUcode()<1)
		{
			airfee.setUcode(airfee.getId());
			updateAirfeeIgnoreNull(airfee);
		}
		return airfee;
	}
	/**
	 * 删除 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirfee(long id){
	
		return getSqlMapClientTemplate().delete("deleteAirfee", id);
	}
	
	
	/**
	 * 修改 燃油费机建费表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirfee(Airfee airfee){
		return getSqlMapClientTemplate().update("updateAirfee",airfee);
	
	}

		
	/**
	 * 修改 燃油费机建费表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirfeeIgnoreNull(Airfee airfee){
		Airfee tmp = findAirfee(airfee.getId());
		int flag =0;
		
		
		if(airfee.getAdultairportfee()!=null){
			tmp.setAdultairportfee(airfee.getAdultairportfee());
			
			flag++;
		}
		
		if(airfee.getChdairportfee()!=null){
			tmp.setChdairportfee(airfee.getChdairportfee());
			
			flag++;
		}
		
		if(airfee.getBabyairportfee()!=null){
			tmp.setBabyairportfee(airfee.getBabyairportfee());
			
			flag++;
		}
		
		if(airfee.getNearadultairpotyfee()!=null){
			tmp.setNearadultairpotyfee(airfee.getNearadultairpotyfee());
			
			flag++;
		}
		
		if(airfee.getNearchdairpotyfee()!=null){
			tmp.setNearchdairpotyfee(airfee.getNearchdairpotyfee());
			
			flag++;
		}
		
		if(airfee.getNearbabyairportfee()!=null){
			tmp.setNearbabyairportfee(airfee.getNearbabyairportfee());
			
			flag++;
		}
		
		if(airfee.getAdultfuelfee()!=null){
			tmp.setAdultfuelfee(airfee.getAdultfuelfee());
			
			flag++;
		}
		
		if(airfee.getChdfuelfee()!=null){
			tmp.setChdfuelfee(airfee.getChdfuelfee());
			
			flag++;
		}
		
		if(airfee.getBabyfuelfee()!=null){
			tmp.setBabyfuelfee(airfee.getBabyfuelfee());
			
			flag++;
		}
		
		if(airfee.getNearadultfuelfee()!=null){
			tmp.setNearadultfuelfee(airfee.getNearadultfuelfee());
			
			flag++;
		}
		
		if(airfee.getNearchdfuelfee()!=null){
			tmp.setNearchdfuelfee(airfee.getNearchdfuelfee());
			
			flag++;
		}
		
		if(airfee.getNearbabyfuelfee()!=null){
			tmp.setNearbabyfuelfee(airfee.getNearbabyfuelfee());
			
			flag++;
		}
		
		if(airfee.getCreateuser()!=null){
			tmp.setCreateuser(airfee.getCreateuser());
			
			flag++;
		}
		
		if(airfee.getCreatetime()!=null){
			tmp.setCreatetime(airfee.getCreatetime());
			
			flag++;
		}
		
		if(airfee.getModifyuser()!=null){
			tmp.setModifyuser(airfee.getModifyuser());
			
			flag++;
		}
		
		if(airfee.getModifytime()!=null){
			tmp.setModifytime(airfee.getModifytime());
			
			flag++;
		}
		
		if(airfee.getUcode()!=null){
			tmp.setUcode(airfee.getUcode());
			
			flag++;
		}
		
		if(airfee.getLanguage()!=null){
			tmp.setLanguage(airfee.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAirfee",tmp);
		}
	}
	
	/**
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Airfee.COL_language+" = 0 OR "+Airfee.COL_language+" is NULL)";
		}
		else if(where.indexOf(Airfee.COL_language)<0)
		{
			where+=" and ("+Airfee.COL_language+" = 0 OR "+Airfee.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAirfee",map, offset, limit);
	}
		
	
	/**
	 * 查找 燃油费机建费表
	 * @param id
	 * @return
	 */
	public Airfee findAirfee(long id){
		return (Airfee)(getSqlMapClientTemplate().queryForObject("findAirfee",id));
	}
	/**
	 * 查找 燃油费机建费表 by language
	 * @param id
	 * @return
	 */
	public Airfee findAirfeebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Airfee.COL_ucode+" = "+id+" and "+Airfee.COL_language+" = "+language;	
		List list=findAllAirfee(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Airfee)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Airfee.COL_language+" = 0";
		}
		else if(where.indexOf(Airfee.COL_language)<0)
		{
			where+=" and "+Airfee.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirfeeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAirfee",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找燃油费机建费表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAirfeeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 燃油费机建费表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirfeeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAirfeeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirfeeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirfeeBySql",map).toString()));
	}
}

