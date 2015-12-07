/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fcountry;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FcountryManager extends  SqlMapClientDaoSupport  implements IFcountryManager{ 
	
  
 	/**
	 * 创建 国际机票国家
	 * @param id
	 * @return deleted count 
	 */
	public Fcountry createFcountry(Fcountry fcountry) throws SQLException{
	
		if(fcountry.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fcountry.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FCOUNTRY"));
		getSqlMapClientTemplate().insert("createFcountry",fcountry);
		if(fcountry.getUcode()==null||fcountry.getUcode()<1)
		{
			fcountry.setUcode(fcountry.getId());
			updateFcountryIgnoreNull(fcountry);
		}
		return fcountry;
	}
	/**
	 * 删除 国际机票国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcountry(long id){
	
		return getSqlMapClientTemplate().delete("deleteFcountry", id);
	}
	
	
	/**
	 * 修改 国际机票国家
	 * @param id
	 * @return updated count 
	 */
	public int updateFcountry(Fcountry fcountry){
		return getSqlMapClientTemplate().update("updateFcountry",fcountry);
	
	}

		
	/**
	 * 修改 国际机票国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFcountryIgnoreNull(Fcountry fcountry){
		Fcountry tmp = findFcountry(fcountry.getId());
		int flag =0;
		
		
		if(fcountry.getCountrycode()!=null){
			tmp.setCountrycode(fcountry.getCountrycode());
			
			flag++;
		}
		
		if(fcountry.getCountryname()!=null){
			tmp.setCountryname(fcountry.getCountryname());
			
			flag++;
		}
		
		if(fcountry.getUcode()!=null){
			tmp.setUcode(fcountry.getUcode());
			
			flag++;
		}
		
		if(fcountry.getLanguage()!=null){
			tmp.setLanguage(fcountry.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFcountry",tmp);
		}
	}
	
	/**
	 * 查找 国际机票国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountry(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Fcountry.COL_language+" = 0 OR "+Fcountry.COL_language+" is NULL)";
		}
		else if(where.indexOf(Fcountry.COL_language)<0)
		{
			where+=" and ("+Fcountry.COL_language+" = 0 OR "+Fcountry.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFcountry",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票国家
	 * @param id
	 * @return
	 */
	public Fcountry findFcountry(long id){
		return (Fcountry)(getSqlMapClientTemplate().queryForObject("findFcountry",id));
	}
	/**
	 * 查找 国际机票国家 by language
	 * @param id
	 * @return
	 */
	public Fcountry findFcountrybylanguage(long id,Integer language){
		String where = " where 1=1 and "+Fcountry.COL_ucode+" = "+id+" and "+Fcountry.COL_language+" = "+language;	
		List list=findAllFcountry(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Fcountry)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 国际机票国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcountry(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Fcountry.COL_language+" = 0";
		}
		else if(where.indexOf(Fcountry.COL_language)<0)
		{
			where+=" and "+Fcountry.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFcountryBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFcountry",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountry(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFcountryBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcountryBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFcountryBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcountryBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFcountryBySql",map).toString()));
	}
}

