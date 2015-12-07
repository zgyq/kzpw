/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rebaterule;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RebateruleManager extends  SqlMapClientDaoSupport  implements IRebateruleManager{ 
	
  
 	/**
	 * 创建 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterule createRebaterule(Rebaterule rebaterule) throws SQLException{
	
		if(rebaterule.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rebaterule.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_REBATERULE"));
		getSqlMapClientTemplate().insert("createRebaterule",rebaterule);
		return rebaterule;
	}
	/**
	 * 删除 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterule(long id){
	
		return getSqlMapClientTemplate().delete("deleteRebaterule", id);
	}
	
	
	/**
	 * 修改 返佣规则
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterule(Rebaterule rebaterule){
		return getSqlMapClientTemplate().update("updateRebaterule",rebaterule);
	
	}

		
	/**
	 * 修改 返佣规则但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebateruleIgnoreNull(Rebaterule rebaterule){
		Rebaterule tmp = findRebaterule(rebaterule.getId());
		int flag =0;
		
		
		if(rebaterule.getRuletypeid()!=null){
			tmp.setRuletypeid(rebaterule.getRuletypeid());
			
			flag++;
		}
		
		if(rebaterule.getAgenttypeid()!=null){
			tmp.setAgenttypeid(rebaterule.getAgenttypeid());
			
			flag++;
		}
		
		if(rebaterule.getRebatvalue()!=null){
			tmp.setRebatvalue(rebaterule.getRebatvalue());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRebaterule",tmp);
		}
	}
	
	/**
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRebaterule",map, offset, limit);
	}
		
	
	/**
	 * 查找 返佣规则
	 * @param id
	 * @return
	 */
	public Rebaterule findRebaterule(long id){
		return (Rebaterule)(getSqlMapClientTemplate().queryForObject("findRebaterule",id));
	}
	
	/** 
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRebateruleBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRebaterule",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找返佣规则
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRebateruleBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 返佣规则
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebateruleBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRebateruleBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebateruleBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRebateruleBySql",map).toString()));
	}
}

