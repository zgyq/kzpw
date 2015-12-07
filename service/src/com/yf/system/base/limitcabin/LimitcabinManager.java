
 
package com.yf.system.base.limitcabin;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class LimitcabinManager extends  SqlMapClientDaoSupport  implements ILimitcabinManager{ 
	
  
 	/**
	 * 创建 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public Limitcabin createLimitcabin(Limitcabin limitcabin) throws SQLException{
	
		if(limitcabin.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		limitcabin.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_LIMITCABIN"));
		getSqlMapClientTemplate().insert("createLimitcabin",limitcabin);
		return limitcabin;
	}
	/**
	 * 删除 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLimitcabin(long id){
	
		return getSqlMapClientTemplate().delete("deleteLimitcabin", id);
	}
	
	
	/**
	 * 修改 限制仓位
	 * @param id
	 * @return updated count 
	 */
	public int updateLimitcabin(Limitcabin limitcabin){
		return getSqlMapClientTemplate().update("updateLimitcabin",limitcabin);
	
	}

		
	/**
	 * 修改 限制仓位但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLimitcabinIgnoreNull(Limitcabin limitcabin){
		Limitcabin tmp = findLimitcabin(limitcabin.getId());
		int flag =0;
		
		
		if(limitcabin.getName()!=null){
			tmp.setName(limitcabin.getName());
			
			flag++;
		}
		
		if(limitcabin.getCabin()!=null){
			tmp.setCabin(limitcabin.getCabin());
			
			flag++;
		}
		
		if(limitcabin.getCreatetime()!=null){
			tmp.setCreatetime(limitcabin.getCreatetime());
			
			flag++;
		}
		
		if(limitcabin.getStime()!=null){
			tmp.setStime(limitcabin.getStime());
			
			flag++;
		}
		
		if(limitcabin.getEndtime()!=null){
			tmp.setEndtime(limitcabin.getEndtime());
			
			flag++;
		}
		
		if(limitcabin.getState()!=null){
			tmp.setState(limitcabin.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateLimitcabin",tmp);
		}
	}
	
	/**
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllLimitcabin",map, offset, limit);
	}
		
	
	/**
	 * 查找 限制仓位
	 * @param id
	 * @return
	 */
	public Limitcabin findLimitcabin(long id){
		return (Limitcabin)(getSqlMapClientTemplate().queryForObject("findLimitcabin",id));
	}
	
	/** 
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLimitcabinBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllLimitcabin",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找限制仓位
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllLimitcabinBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 限制仓位
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLimitcabinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteLimitcabinBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLimitcabinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLimitcabinBySql",map).toString()));
	}
}

