/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tickettype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TickettypeManager extends  SqlMapClientDaoSupport  implements ITickettypeManager{ 
	
  
 	/**
	 * 创建 机票类型
	 * @param id
	 * @return deleted count 
	 */
	public Tickettype createTickettype(Tickettype tickettype) throws SQLException{
	
		if(tickettype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		tickettype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TICKETTYPE"));
		getSqlMapClientTemplate().insert("createTickettype",tickettype);
		return tickettype;
	}
	/**
	 * 删除 机票类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTickettype(long id){
	
		return getSqlMapClientTemplate().delete("deleteTickettype", id);
	}
	
	
	/**
	 * 修改 机票类型
	 * @param id
	 * @return updated count 
	 */
	public int updateTickettype(Tickettype tickettype){
		return getSqlMapClientTemplate().update("updateTickettype",tickettype);
	
	}

		
	/**
	 * 修改 机票类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTickettypeIgnoreNull(Tickettype tickettype){
		Tickettype tmp = findTickettype(tickettype.getId());
		int flag =0;
		
		
		if(tickettype.getTypename()!=null){
			tmp.setTypename(tickettype.getTypename());
			
			flag++;
		}
		
		if(tickettype.getTypedesc()!=null){
			tmp.setTypedesc(tickettype.getTypedesc());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTickettype",tmp);
		}
	}
	
	/**
	 * 查找 机票类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickettype(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTickettype",map, offset, limit);
	}
		
	
	/**
	 * 查找 机票类型
	 * @param id
	 * @return
	 */
	public Tickettype findTickettype(long id){
		return (Tickettype)(getSqlMapClientTemplate().queryForObject("findTickettype",id));
	}
	
	/** 
	 * 查找 机票类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickettype(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTickettypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTickettype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机票类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickettype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTickettypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机票类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTickettypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTickettypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTickettypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTickettypeBySql",map).toString()));
	}
}

