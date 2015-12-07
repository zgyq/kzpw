/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ticketapp;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TicketappManager extends  SqlMapClientDaoSupport  implements ITicketappManager{ 
	
  
 	/**
	 * 创建 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Ticketapp createTicketapp(Ticketapp ticketapp) throws SQLException{
	
		if(ticketapp.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		ticketapp.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TICKETAPP"));
		getSqlMapClientTemplate().insert("createTicketapp",ticketapp);
		return ticketapp;
	}
	/**
	 * 删除 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketapp(long id){
	
		return getSqlMapClientTemplate().delete("deleteTicketapp", id);
	}
	
	
	/**
	 * 修改 特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketapp(Ticketapp ticketapp){
		return getSqlMapClientTemplate().update("updateTicketapp",ticketapp);
	
	}

		
	/**
	 * 修改 特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketappIgnoreNull(Ticketapp ticketapp){
		Ticketapp tmp = findTicketapp(ticketapp.getId());
		int flag =0;
		
		
		if(ticketapp.getSname()!=null){
			tmp.setSname(ticketapp.getSname());
			
			flag++;
		}
		
		if(ticketapp.getEndname()!=null){
			tmp.setEndname(ticketapp.getEndname());
			
			flag++;
		}
		
		if(ticketapp.getStime()!=null){
			tmp.setStime(ticketapp.getStime());
			
			flag++;
		}
		
		if(ticketapp.getCopname()!=null){
			tmp.setCopname(ticketapp.getCopname());
			
			flag++;
		}
		
		if(ticketapp.getFnub()!=null){
			tmp.setFnub(ticketapp.getFnub());
			
			flag++;
		}
		
		if(ticketapp.getCnub()!=null){
			tmp.setCnub(ticketapp.getCnub());
			
			flag++;
		}
		
		if(ticketapp.getPnumber()!=null){
			tmp.setPnumber(ticketapp.getPnumber());
			
			flag++;
		}
		
		if(ticketapp.getUsername()!=null){
			tmp.setUsername(ticketapp.getUsername());
			
			flag++;
		}
		
		if(ticketapp.getMobile()!=null){
			tmp.setMobile(ticketapp.getMobile());
			
			flag++;
		}
		
		if(ticketapp.getMemberemail()!=null){
			tmp.setMemberemail(ticketapp.getMemberemail());
			
			flag++;
		}
		
		if(ticketapp.getCardnunber()!=null){
			tmp.setCardnunber(ticketapp.getCardnunber());
			
			flag++;
		}
		
		if(ticketapp.getDescription()!=null){
			tmp.setDescription(ticketapp.getDescription());
			
			flag++;
		}
		
		if(ticketapp.getCreatetime()!=null){
			tmp.setCreatetime(ticketapp.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTicketapp",tmp);
		}
	}
	
	/**
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTicketapp",map, offset, limit);
	}
		
	
	/**
	 * 查找 特价申请表
	 * @param id
	 * @return
	 */
	public Ticketapp findTicketapp(long id){
		return (Ticketapp)(getSqlMapClientTemplate().queryForObject("findTicketapp",id));
	}
	
	/** 
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTicketappBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTicketapp",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTicketappBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketappBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTicketappBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketappBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTicketappBySql",map).toString()));
	}
}

