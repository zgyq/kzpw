/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rperformance;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RperformanceManager extends  SqlMapClientDaoSupport  implements IRperformanceManager{ 
	
  
 	/**
	 * 创建 绩效合约统计
	 * @param id
	 * @return deleted count 
	 */
	public Rperformance createRperformance(Rperformance rperformance) throws SQLException{
	
		if(rperformance.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rperformance.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_RPERFORMANCE"));
		getSqlMapClientTemplate().insert("createRperformance",rperformance);
		return rperformance;
	}
	/**
	 * 删除 绩效合约统计
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRperformance(long id){
	
		return getSqlMapClientTemplate().delete("deleteRperformance", id);
	}
	
	
	/**
	 * 修改 绩效合约统计
	 * @param id
	 * @return updated count 
	 */
	public int updateRperformance(Rperformance rperformance){
		return getSqlMapClientTemplate().update("updateRperformance",rperformance);
	
	}

		
	/**
	 * 修改 绩效合约统计但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRperformanceIgnoreNull(Rperformance rperformance){
		Rperformance tmp = findRperformance(rperformance.getId());
		int flag =0;
		
		
		if(rperformance.getLow()!=null){
			tmp.setLow(rperformance.getLow());
			
			flag++;
		}
		
		if(rperformance.getNormal()!=null){
			tmp.setNormal(rperformance.getNormal());
			
			flag++;
		}
		
		if(rperformance.getHigh()!=null){
			tmp.setHigh(rperformance.getHigh());
			
			flag++;
		}
		
		if(rperformance.getDepartment()!=null){
			tmp.setDepartment(rperformance.getDepartment());
			
			flag++;
		}
		
		if(rperformance.getType()!=null){
			tmp.setType(rperformance.getType());
			
			flag++;
		}
		
		if(rperformance.getDatetime()!=null){
			tmp.setDatetime(rperformance.getDatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRperformance",tmp);
		}
	}
	
	/**
	 * 查找 绩效合约统计
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRperformance(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRperformance",map, offset, limit);
	}
		
	
	/**
	 * 查找 绩效合约统计
	 * @param id
	 * @return
	 */
	public Rperformance findRperformance(long id){
		return (Rperformance)(getSqlMapClientTemplate().queryForObject("findRperformance",id));
	}
	
	/** 
	 * 查找 绩效合约统计
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRperformance(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRperformanceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRperformance",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找绩效合约统计
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRperformance(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRperformanceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 绩效合约统计
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRperformanceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRperformanceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRperformanceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRperformanceBySql",map).toString()));
	}
}

