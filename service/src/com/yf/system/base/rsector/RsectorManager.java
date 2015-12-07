/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rsector;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RsectorManager extends  SqlMapClientDaoSupport  implements IRsectorManager{ 
	
  
 	/**
	 * 创建 部门绩效表
	 * @param id
	 * @return deleted count 
	 */
	public Rsector createRsector(Rsector rsector) throws SQLException{
	
		if(rsector.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rsector.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_RSECTOR"));
		getSqlMapClientTemplate().insert("createRsector",rsector);
		return rsector;
	}
	/**
	 * 删除 部门绩效表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRsector(long id){
	
		return getSqlMapClientTemplate().delete("deleteRsector", id);
	}
	
	
	/**
	 * 修改 部门绩效表
	 * @param id
	 * @return updated count 
	 */
	public int updateRsector(Rsector rsector){
		return getSqlMapClientTemplate().update("updateRsector",rsector);
	
	}

		
	/**
	 * 修改 部门绩效表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRsectorIgnoreNull(Rsector rsector){
		Rsector tmp = findRsector(rsector.getId());
		int flag =0;
		
		
		if(rsector.getPerformanceid()!=null){
			tmp.setPerformanceid(rsector.getPerformanceid());
			
			flag++;
		}
		
		if(rsector.getMoney()!=null){
			tmp.setMoney(rsector.getMoney());
			
			flag++;
		}
		
		if(rsector.getDate()!=null){
			tmp.setDate(rsector.getDate());
			
			flag++;
		}
		
		if(rsector.getLow()!=null){
			tmp.setLow(rsector.getLow());
			
			flag++;
		}
		
		if(rsector.getNormal()!=null){
			tmp.setNormal(rsector.getNormal());
			
			flag++;
		}
		
		if(rsector.getHigh()!=null){
			tmp.setHigh(rsector.getHigh());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRsector",tmp);
		}
	}
	
	/**
	 * 查找 部门绩效表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRsector(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRsector",map, offset, limit);
	}
		
	
	/**
	 * 查找 部门绩效表
	 * @param id
	 * @return
	 */
	public Rsector findRsector(long id){
		return (Rsector)(getSqlMapClientTemplate().queryForObject("findRsector",id));
	}
	
	/** 
	 * 查找 部门绩效表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRsector(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRsectorBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRsector",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找部门绩效表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRsector(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRsectorBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 部门绩效表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRsectorBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRsectorBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRsectorBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRsectorBySql",map).toString()));
	}
}

