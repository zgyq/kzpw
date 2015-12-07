/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemaction;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SystemactionManager extends  SqlMapClientDaoSupport  implements ISystemactionManager{ 
	
  
 	/**
	 * 创建 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public Systemaction createSystemaction(Systemaction systemaction) throws SQLException{
	
		if(systemaction.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		systemaction.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SYSTEMACTION"));
		getSqlMapClientTemplate().insert("createSystemaction",systemaction);
		return systemaction;
	}
	/**
	 * 删除 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemaction(long id){
	
		return getSqlMapClientTemplate().delete("deleteSystemaction", id);
	}
	
	
	/**
	 * 修改 系统用户行为
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemaction(Systemaction systemaction){
		return getSqlMapClientTemplate().update("updateSystemaction",systemaction);
	
	}

		
	/**
	 * 修改 系统用户行为但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemactionIgnoreNull(Systemaction systemaction){
		Systemaction tmp = findSystemaction(systemaction.getId());
		int flag =0;
		
		
		if(systemaction.getUsername()!=null){
			tmp.setUsername(systemaction.getUsername());
			
			flag++;
		}
		
		if(systemaction.getActionname()!=null){
			tmp.setActionname(systemaction.getActionname());
			
			flag++;
		}
		
		if(systemaction.getCode()!=null){
			tmp.setCode(systemaction.getCode());
			
			flag++;
		}
		
		if(systemaction.getPara()!=null){
			tmp.setPara(systemaction.getPara());
			
			flag++;
		}
		
		if(systemaction.getCreatetime()!=null){
			tmp.setCreatetime(systemaction.getCreatetime());
			
			flag++;
		}
		
		if(systemaction.getIp()!=null){
			tmp.setIp(systemaction.getIp());
			
			flag++;
		}
		
		if(systemaction.getDescription()!=null){
			tmp.setDescription(systemaction.getDescription());
			
			flag++;
		}
		
		if(systemaction.getLever()!=null){
			tmp.setLever(systemaction.getLever());
			
			flag++;
		}
		
		if(systemaction.getType()!=null){
			tmp.setType(systemaction.getType());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSystemaction",tmp);
		}
	}
	
	/**
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSystemaction",map, offset, limit);
	}
		
	
	/**
	 * 查找 系统用户行为
	 * @param id
	 * @return
	 */
	public Systemaction findSystemaction(long id){
		return (Systemaction)(getSqlMapClientTemplate().queryForObject("findSystemaction",id));
	}
	
	/** 
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSystemactionBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSystemaction",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找系统用户行为
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSystemactionBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 系统用户行为
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemactionBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSystemactionBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemactionBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSystemactionBySql",map).toString()));
	}
}

