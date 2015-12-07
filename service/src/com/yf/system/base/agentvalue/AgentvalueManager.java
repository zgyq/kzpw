/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.agentvalue;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AgentvalueManager extends  SqlMapClientDaoSupport  implements IAgentvalueManager{ 
	
  
 	/**
	 * 创建 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public Agentvalue createAgentvalue(Agentvalue agentvalue) throws SQLException{
	
		if(agentvalue.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		agentvalue.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AGENTVALUE"));
		getSqlMapClientTemplate().insert("createAgentvalue",agentvalue);
		return agentvalue;
	}
	/**
	 * 删除 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentvalue(long id){
	
		return getSqlMapClientTemplate().delete("deleteAgentvalue", id);
	}
	
	
	/**
	 * 修改 加盟商固定返点
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentvalue(Agentvalue agentvalue){
		return getSqlMapClientTemplate().update("updateAgentvalue",agentvalue);
	
	}

		
	/**
	 * 修改 加盟商固定返点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentvalueIgnoreNull(Agentvalue agentvalue){
		Agentvalue tmp = findAgentvalue(agentvalue.getId());
		int flag =0;
		
		
		if(agentvalue.getName()!=null){
			tmp.setName(agentvalue.getName());
			
			flag++;
		}
		
		if(agentvalue.getAngentid()!=null){
			tmp.setAngentid(agentvalue.getAngentid());
			
			flag++;
		}
		
		if(agentvalue.getCreatetime()!=null){
			tmp.setCreatetime(agentvalue.getCreatetime());
			
			flag++;
		}
		
		if(agentvalue.getMemberid()!=null){
			tmp.setMemberid(agentvalue.getMemberid());
			
			flag++;
		}
		
		if(agentvalue.getRvalue()!=null){
			tmp.setRvalue(agentvalue.getRvalue());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAgentvalue",tmp);
		}
	}
	
	/**
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAgentvalue",map, offset, limit);
	}
		
	
	/**
	 * 查找 加盟商固定返点
	 * @param id
	 * @return
	 */
	public Agentvalue findAgentvalue(long id){
		return (Agentvalue)(getSqlMapClientTemplate().queryForObject("findAgentvalue",id));
	}
	
	/** 
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAgentvalueBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAgentvalue",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找加盟商固定返点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAgentvalueBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 加盟商固定返点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentvalueBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAgentvalueBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentvalueBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAgentvalueBySql",map).toString()));
	}
}

