/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.province;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ProvinceManager extends  SqlMapClientDaoSupport  implements IProvinceManager{ 
	
  
 	/**
	 * 创建 省份
	 * @param id
	 * @return deleted count 
	 */
	public Province createProvince(Province province) throws SQLException{
	
		if(province.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		province.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PROVINCE"));
		getSqlMapClientTemplate().insert("createProvince",province);
		if(province.getUcode()==null||province.getUcode()<1)
		{
			province.setUcode(province.getId());
			updateProvinceIgnoreNull(province);
		}
		return province;
	}
	/**
	 * 删除 省份
	 * @param id
	 * @return deleted count 
	 */
	public int deleteProvince(long id){
	
		return getSqlMapClientTemplate().delete("deleteProvince", id);
	}
	
	
	/**
	 * 修改 省份
	 * @param id
	 * @return updated count 
	 */
	public int updateProvince(Province province){
		return getSqlMapClientTemplate().update("updateProvince",province);
	
	}

		
	/**
	 * 修改 省份但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateProvinceIgnoreNull(Province province){
		Province tmp = findProvince(province.getId());
		int flag =0;
		
		
		if(province.getName()!=null){
			tmp.setName(province.getName());
			
			flag++;
		}
		
		if(province.getEnname()!=null){
			tmp.setEnname(province.getEnname());
			
			flag++;
		}
		if(province.getType()!=null){
			tmp.setType(province.getType());
			
			flag++;
		}
		
		if(province.getCode()!=null){
			tmp.setCode(province.getCode());
			
			flag++;
		}
		
		if(province.getUcode()!=null){
			tmp.setUcode(province.getUcode());
			
			flag++;
		}
		
		if(province.getLanguage()!=null){
			tmp.setLanguage(province.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateProvince",tmp);
		}
	}
	
	/**
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvince(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Province.COL_language+" = 0 OR "+Province.COL_language+" is NULL)";
		}
		else if(where.indexOf(Province.COL_language)<0)
		{
			where+=" and ("+Province.COL_language+" = 0 OR "+Province.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllProvince",map, offset, limit);
	}
		
	
	/**
	 * 查找 省份
	 * @param id
	 * @return
	 */
	public Province findProvince(long id){
		return (Province)(getSqlMapClientTemplate().queryForObject("findProvince",id));
	}
	/**
	 * 查找 省份 by language
	 * @param id
	 * @return
	 */
	public Province findProvincebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Province.COL_ucode+" = "+id+" and "+Province.COL_language+" = "+language;	
		List list=findAllProvince(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Province)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllProvince(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Province.COL_language+" = 0";
		}
		else if(where.indexOf(Province.COL_language)<0)
		{
			where+=" and "+Province.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countProvinceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllProvince",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找省份
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvince(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllProvinceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 省份
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteProvinceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteProvinceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countProvinceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countProvinceBySql",map).toString()));
	}
}

