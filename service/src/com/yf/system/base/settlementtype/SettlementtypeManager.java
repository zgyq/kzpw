/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.settlementtype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SettlementtypeManager extends  SqlMapClientDaoSupport  implements ISettlementtypeManager{ 
	
  
 	/**
	 * 创建 结算分类表
	 * @param id
	 * @return deleted count 
	 */
	public Settlementtype createSettlementtype(Settlementtype settlementtype) throws SQLException{
	
		if(settlementtype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		settlementtype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SETTLEMENTTYPE"));
		getSqlMapClientTemplate().insert("createSettlementtype",settlementtype);
		return settlementtype;
	}
	/**
	 * 删除 结算分类表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSettlementtype(long id){
	
		return getSqlMapClientTemplate().delete("deleteSettlementtype", id);
	}
	
	
	/**
	 * 修改 结算分类表
	 * @param id
	 * @return updated count 
	 */
	public int updateSettlementtype(Settlementtype settlementtype){
		return getSqlMapClientTemplate().update("updateSettlementtype",settlementtype);
	
	}

		
	/**
	 * 修改 结算分类表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSettlementtypeIgnoreNull(Settlementtype settlementtype){
		Settlementtype tmp = findSettlementtype(settlementtype.getId());
		int flag =0;
		
		
		if(settlementtype.getTypename()!=null){
			tmp.setTypename(settlementtype.getTypename());
			
			flag++;
		}
		
		if(settlementtype.getLiudianid()!=null){
			tmp.setLiudianid(settlementtype.getLiudianid());
			
			flag++;
		}
		
		if(settlementtype.getCreateuser()!=null){
			tmp.setCreateuser(settlementtype.getCreateuser());
			
			flag++;
		}
		
		if(settlementtype.getCreatetime()!=null){
			tmp.setCreatetime(settlementtype.getCreatetime());
			
			flag++;
		}
		
		
		if(settlementtype.getAgentid()!=null){
			tmp.setAgentid(settlementtype.getAgentid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSettlementtype",tmp);
		}
	}
	
	/**
	 * 查找 结算分类表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSettlementtype(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where 1=1";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSettlementtype",map, offset, limit);
	}
		
	
	/**
	 * 查找 结算分类表
	 * @param id
	 * @return
	 */
	public Settlementtype findSettlementtype(long id){
		return (Settlementtype)(getSqlMapClientTemplate().queryForObject("findSettlementtype",id));
	}
	/**
	 * 查找 结算分类表 by language
	 * @param id
	 * @return
	 */
	public Settlementtype findSettlementtypebylanguage(long id,Integer language){
		String where = " where 1=1 ";	
		List list=findAllSettlementtype(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Settlementtype)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 结算分类表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSettlementtype(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where 1=1";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSettlementtypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSettlementtype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找结算分类表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSettlementtype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSettlementtypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 结算分类表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSettlementtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSettlementtypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSettlementtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSettlementtypeBySql",map).toString()));
	}
}

