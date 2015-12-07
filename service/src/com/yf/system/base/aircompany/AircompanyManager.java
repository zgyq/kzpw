/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.aircompany;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AircompanyManager extends  SqlMapClientDaoSupport  implements IAircompanyManager{ 
	
  
 	/**
	 * 创建 航空公司基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Aircompany createAircompany(Aircompany aircompany) throws SQLException{
	
		if(aircompany.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		aircompany.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRCOMPANY"));
		getSqlMapClientTemplate().insert("createAircompany",aircompany);
		if(aircompany.getUcode()==null||aircompany.getUcode()<1)
		{
			aircompany.setUcode(aircompany.getId());
			updateAircompanyIgnoreNull(aircompany);
		}
		return aircompany;
	}
	/**
	 * 删除 航空公司基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAircompany(long id){
	
		return getSqlMapClientTemplate().delete("deleteAircompany", id);
	}
	
	
	/**
	 * 修改 航空公司基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAircompany(Aircompany aircompany){
		return getSqlMapClientTemplate().update("updateAircompany",aircompany);
	
	}

		
	/**
	 * 修改 航空公司基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAircompanyIgnoreNull(Aircompany aircompany){
		Aircompany tmp = findAircompany(aircompany.getId());
		int flag =0;
		
		
		if(aircompany.getAircomcode()!=null){
			tmp.setAircomcode(aircompany.getAircomcode());
			
			flag++;
		}
		
		if(aircompany.getAircomcnname()!=null){
			tmp.setAircomcnname(aircompany.getAircomcnname());
			
			flag++;
		}
		if(aircompany.getIsair()!=null){
			tmp.setIsair(aircompany.getIsair());
			
			flag++;
		}
		
		if(aircompany.getAircomjname()!=null){
			tmp.setAircomjname(aircompany.getAircomjname());
			
			flag++;
		}
		
		if(aircompany.getAircomenname()!=null){
			tmp.setAircomenname(aircompany.getAircomenname());
			
			flag++;
		}
		
		if(aircompany.getAircomlogo()!=null){
			tmp.setAircomlogo(aircompany.getAircomlogo());
			
			flag++;
		}
		
		if(aircompany.getAircomdesc()!=null){
			tmp.setAircomdesc(aircompany.getAircomdesc());
			
			flag++;
		}
		
		if(aircompany.getCreateuser()!=null){
			tmp.setCreateuser(aircompany.getCreateuser());
			
			flag++;
		}
		
		if(aircompany.getCreatetime()!=null){
			tmp.setCreatetime(aircompany.getCreatetime());
			
			flag++;
		}
		
		if(aircompany.getModifyuser()!=null){
			tmp.setModifyuser(aircompany.getModifyuser());
			
			flag++;
		}
		
		if(aircompany.getModifytime()!=null){
			tmp.setModifytime(aircompany.getModifytime());
			
			flag++;
		}
		
		if(aircompany.getIsenable()!=null){
			tmp.setIsenable(aircompany.getIsenable());
			
			flag++;
		}
		
		if(aircompany.getUcode()!=null){
			tmp.setUcode(aircompany.getUcode());
			
			flag++;
		}
		
		if(aircompany.getLanguage()!=null){
			tmp.setLanguage(aircompany.getLanguage());
			
			flag++;
		}
		
		if(aircompany.getCountrycode()!=null){
			tmp.setCountrycode(aircompany.getCountrycode());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAircompany",tmp);
		}
	}
	
	/**
	 * 查找 航空公司基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAircompany(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Aircompany.COL_language+" = 0 OR "+Aircompany.COL_language+" is NULL)";
		}
		else if(where.indexOf(Aircompany.COL_language)<0)
		{
			where+=" and ("+Aircompany.COL_language+" = 0 OR "+Aircompany.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAircompany",map, offset, limit);
	}
		
	
	/**
	 * 查找 航空公司基础信息表
	 * @param id
	 * @return
	 */
	public Aircompany findAircompany(long id){
		return (Aircompany)(getSqlMapClientTemplate().queryForObject("findAircompany",id));
	}
	/**
	 * 查找 航空公司基础信息表 by language
	 * @param id
	 * @return
	 */
	public Aircompany findAircompanybylanguage(long id,Integer language){
		String where = " where 1=1 and "+Aircompany.COL_ucode+" = "+id+" and "+Aircompany.COL_language+" = "+language;	
		List list=findAllAircompany(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Aircompany)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 航空公司基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAircompany(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Aircompany.COL_language+" = 0";
		}
		else if(where.indexOf(Aircompany.COL_language)<0)
		{
			where+=" and "+Aircompany.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAircompanyBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAircompany",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航空公司基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAircompany(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAircompanyBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航空公司基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAircompanyBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAircompanyBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAircompanyBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAircompanyBySql",map).toString()));
	}
}

