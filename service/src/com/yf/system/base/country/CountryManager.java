/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.country;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CountryManager extends  SqlMapClientDaoSupport  implements ICountryManager{ 
	
  
 	/**
	 * 创建 国家表
	 * @param id
	 * @return deleted count 
	 */
	public Country createCountry(Country country) throws SQLException{
	
		if(country.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		country.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_COUNTRY"));
		getSqlMapClientTemplate().insert("createCountry",country);
		return country;
	}
	/**
	 * 删除 国家表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCountry(long id){
	
		return getSqlMapClientTemplate().delete("deleteCountry", id);
	}
	
	
	/**
	 * 修改 国家表
	 * @param id
	 * @return updated count 
	 */
	public int updateCountry(Country country){
		return getSqlMapClientTemplate().update("updateCountry",country);
	
	}

		
	/**
	 * 修改 国家表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCountryIgnoreNull(Country country){
		Country tmp = findCountry(country.getId());
		int flag =0;
		
		
		if(country.getName()!=null){
			tmp.setName(country.getName());
			
			flag++;
		}
		if(country.getZhname()!=null){
			tmp.setZhname(country.getZhname());
			
			flag++;
		}
		
		if(country.getDesc()!=null){
			tmp.setDesc(country.getDesc());
			
			flag++;
		}
		
		if(country.getCode3()!=null){
			tmp.setCode3(country.getCode3());
			
			flag++;
		}
		
		if(country.getCode2()!=null){
			tmp.setCode2(country.getCode2());
			
			flag++;
		}
		
		if(country.getFips()!=null){
			tmp.setFips(country.getFips());
			
			flag++;
		}
		
		if(country.getUn()!=null){
			tmp.setUn(country.getUn());
			
			flag++;
		}
		
		if(country.getCreatetime()!=null){
			tmp.setCreatetime(country.getCreatetime());
			
			flag++;
		}
		
		if(country.getType()!=null){
			tmp.setType(country.getType());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCountry",tmp);
		}
	}
	
	/**
	 * 查找 国家表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCountry(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCountry",map, offset, limit);
	}
		
	
	/**
	 * 查找 国家表
	 * @param id
	 * @return
	 */
	public Country findCountry(long id){
		return (Country)(getSqlMapClientTemplate().queryForObject("findCountry",id));
	}
	
	/** 
	 * 查找 国家表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCountry(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCountryBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCountry",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国家表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCountry(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCountryBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国家表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCountryBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCountryBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCountryBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCountryBySql",map).toString()));
	}
}

