/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.agentroleref;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AgentrolerefManager extends  SqlMapClientDaoSupport  implements IAgentrolerefManager{ 
	
  
 	/**
	 * 创建 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public Agentroleref createAgentroleref(Agentroleref agentroleref) throws SQLException{
	
		if(agentroleref.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		agentroleref.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AGENTROLEREF"));
		getSqlMapClientTemplate().insert("createAgentroleref",agentroleref);
		return agentroleref;
	}
	/**
	 * 删除 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentroleref(long id){
	
		return getSqlMapClientTemplate().delete("deleteAgentroleref", id);
	}
	
	
	/**
	 * 修改 会员角色关联
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentroleref(Agentroleref agentroleref){
		return getSqlMapClientTemplate().update("updateAgentroleref",agentroleref);
	
	}

		
	/**
	 * 修改 会员角色关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentrolerefIgnoreNull(Agentroleref agentroleref){
		Agentroleref tmp = findAgentroleref(agentroleref.getId());
		int flag =0;
		
		
		if(agentroleref.getRoleid()!=null){
			tmp.setRoleid(agentroleref.getRoleid());
			
			flag++;
		}
		
		if(agentroleref.getCustomeruserid()!=null){
			tmp.setCustomeruserid(agentroleref.getCustomeruserid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAgentroleref",tmp);
		}
	}
	
	/**
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAgentroleref",map, offset, limit);
	}
		
	
	/**
	 * 查找 会员角色关联
	 * @param id
	 * @return
	 */
	public Agentroleref findAgentroleref(long id){
		return (Agentroleref)(getSqlMapClientTemplate().queryForObject("findAgentroleref",id));
	}
	
	/** 
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAgentrolerefBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAgentroleref",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会员角色关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAgentrolerefBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会员角色关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentrolerefBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAgentrolerefBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentrolerefBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAgentrolerefBySql",map).toString()));
	}
}

