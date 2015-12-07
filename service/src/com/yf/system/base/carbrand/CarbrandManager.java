/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carbrand;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarbrandManager extends  SqlMapClientDaoSupport  implements ICarbrandManager{ 
	
  
 	/**
	 * 创建 汽车品牌
	 * @param id
	 * @return deleted count 
	 */
	public Carbrand createCarbrand(Carbrand carbrand) throws SQLException{
	
		if(carbrand.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		carbrand.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARBRAND"));
		getSqlMapClientTemplate().insert("createCarbrand",carbrand);
		return carbrand;
	}
	/**
	 * 删除 汽车品牌
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarbrand(long id){
	
		return getSqlMapClientTemplate().delete("deleteCarbrand", id);
	}
	
	
	/**
	 * 修改 汽车品牌
	 * @param id
	 * @return updated count 
	 */
	public int updateCarbrand(Carbrand carbrand){
		return getSqlMapClientTemplate().update("updateCarbrand",carbrand);
	
	}

		
	/**
	 * 修改 汽车品牌但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarbrandIgnoreNull(Carbrand carbrand){
		Carbrand tmp = findCarbrand(carbrand.getId());
		int flag =0;
		
		
		if(carbrand.getCode()!=null){
			tmp.setCode(carbrand.getCode());
			
			flag++;
		}
		
		if(carbrand.getName()!=null){
			tmp.setName(carbrand.getName());
			
			flag++;
		}
		
		if(carbrand.getComment()!=null){
			tmp.setComment(carbrand.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCarbrand",tmp);
		}
	}
	
	/**
	 * 查找 汽车品牌
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarbrand(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCarbrand",map, offset, limit);
	}
		
	
	/**
	 * 查找 汽车品牌
	 * @param id
	 * @return
	 */
	public Carbrand findCarbrand(long id){
		return (Carbrand)(getSqlMapClientTemplate().queryForObject("findCarbrand",id));
	}
	
	/** 
	 * 查找 汽车品牌
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarbrand(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarbrandBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCarbrand",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找汽车品牌
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarbrand(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarbrandBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 汽车品牌
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarbrandBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarbrandBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarbrandBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarbrandBySql",map).toString()));
	}
}

