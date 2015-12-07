/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ticketnumber;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TicketnumberManager extends  SqlMapClientDaoSupport  implements ITicketnumberManager{ 
	
  
 	/**
	 * 创建 机票票号
	 * @param id
	 * @return deleted count 
	 */
	public Ticketnumber createTicketnumber(Ticketnumber ticketnumber) throws SQLException{
	
		if(ticketnumber.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		ticketnumber.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TICKETNUMBER"));
		getSqlMapClientTemplate().insert("createTicketnumber",ticketnumber);
		return ticketnumber;
	}
	/**
	 * 删除 机票票号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketnumber(long id){
	
		return getSqlMapClientTemplate().delete("deleteTicketnumber", id);
	}
	
	
	/**
	 * 修改 机票票号
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketnumber(Ticketnumber ticketnumber){
		return getSqlMapClientTemplate().update("updateTicketnumber",ticketnumber);
	
	}

		
	/**
	 * 修改 机票票号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketnumberIgnoreNull(Ticketnumber ticketnumber){
		Ticketnumber tmp = findTicketnumber(ticketnumber.getId());
		int flag =0;
		
		
		if(ticketnumber.getTickettypeid()!=null){
			tmp.setTickettypeid(ticketnumber.getTickettypeid());
			
			flag++;
		}
		
		if(ticketnumber.getBeginnumber()!=null){
			tmp.setBeginnumber(ticketnumber.getBeginnumber());
			
			flag++;
		}
		
		if(ticketnumber.getEndnumber()!=null){
			tmp.setEndnumber(ticketnumber.getEndnumber());
			
			flag++;
		}
		
		if(ticketnumber.getDescription()!=null){
			tmp.setDescription(ticketnumber.getDescription());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTicketnumber",tmp);
		}
	}
	
	/**
	 * 查找 机票票号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketnumber(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTicketnumber",map, offset, limit);
	}
		
	
	/**
	 * 查找 机票票号
	 * @param id
	 * @return
	 */
	public Ticketnumber findTicketnumber(long id){
		return (Ticketnumber)(getSqlMapClientTemplate().queryForObject("findTicketnumber",id));
	}
	
	/** 
	 * 查找 机票票号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketnumber(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTicketnumberBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTicketnumber",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机票票号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketnumber(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTicketnumberBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机票票号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketnumberBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTicketnumberBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketnumberBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTicketnumberBySql",map).toString()));
	}
}

