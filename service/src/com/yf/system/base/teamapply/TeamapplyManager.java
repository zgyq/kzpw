/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.teamapply;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TeamapplyManager extends  SqlMapClientDaoSupport  implements ITeamapplyManager{ 
	
  
 	/**
	 * 创建 团队申请表
	 * @param id
	 * @return deleted count 
	 */
	public Teamapply createTeamapply(Teamapply teamapply) throws SQLException{
	
		if(teamapply.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		teamapply.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TEAMAPPLY"));
		getSqlMapClientTemplate().insert("createTeamapply",teamapply);
		return teamapply;
	}
	/**
	 * 删除 团队申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTeamapply(long id){
	
		return getSqlMapClientTemplate().delete("deleteTeamapply", id);
	}
	
	
	/**
	 * 修改 团队申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTeamapply(Teamapply teamapply){
		return getSqlMapClientTemplate().update("updateTeamapply",teamapply);
	
	}

		
	/**
	 * 修改 团队申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTeamapplyIgnoreNull(Teamapply teamapply){
		Teamapply tmp = findTeamapply(teamapply.getId());
		int flag =0;
		
		
		if(teamapply.getTypeid()!=null){
			tmp.setTypeid(teamapply.getTypeid());
			
			flag++;
		}
		
		if(teamapply.getFlighttype()!=null){
			tmp.setFlighttype(teamapply.getFlighttype());
			
			flag++;
		}
		
		if(teamapply.getUsertype()!=null){
			tmp.setUsertype(teamapply.getUsertype());
			
			flag++;
		}
		
		if(teamapply.getStartcity()!=null){
			tmp.setStartcity(teamapply.getStartcity());
			
			flag++;
		}
		
		if(teamapply.getEndcity()!=null){
			tmp.setEndcity(teamapply.getEndcity());
			
			flag++;
		}
		
		if(teamapply.getNumberpeople()!=null){
			tmp.setNumberpeople(teamapply.getNumberpeople());
			
			flag++;
		}
		
		if(teamapply.getCa()!=null){
			tmp.setCa(teamapply.getCa());
			
			flag++;
		}
		
		if(teamapply.getFlightnumber()!=null){
			tmp.setFlightnumber(teamapply.getFlightnumber());
			
			flag++;
		}
		
		if(teamapply.getStarttime()!=null){
			tmp.setStarttime(teamapply.getStarttime());
			
			flag++;
		}
		
		if(teamapply.getCreateuser()!=null){
			tmp.setCreateuser(teamapply.getCreateuser());
			
			flag++;
		}
		
		if(teamapply.getCreatetime()!=null){
			tmp.setCreatetime(teamapply.getCreatetime());
			
			flag++;
		}
		
		if(teamapply.getStatus()!=null){
			tmp.setStatus(teamapply.getStatus());
			
			flag++;
		}
		
		if(teamapply.getComment()!=null){
			tmp.setComment(teamapply.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTeamapply",tmp);
		}
	}
	
	/**
	 * 查找 团队申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTeamapply(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTeamapply",map, offset, limit);
	}
		
	
	/**
	 * 查找 团队申请表
	 * @param id
	 * @return
	 */
	public Teamapply findTeamapply(long id){
		return (Teamapply)(getSqlMapClientTemplate().queryForObject("findTeamapply",id));
	}
	
	/** 
	 * 查找 团队申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTeamapply(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTeamapplyBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTeamapply",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找团队申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTeamapply(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTeamapplyBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 团队申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTeamapplyBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTeamapplyBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTeamapplyBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTeamapplyBySql",map).toString()));
	}
}

