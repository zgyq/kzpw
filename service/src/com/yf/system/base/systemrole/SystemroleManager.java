/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemrole;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SystemroleManager extends  SqlMapClientDaoSupport  implements ISystemroleManager{ 
	
  
 	/**
	 * 创建 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public Systemrole createSystemrole(Systemrole systemrole) throws SQLException{
	
		if(systemrole.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		systemrole.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SYSTEMROLE"));
		getSqlMapClientTemplate().insert("createSystemrole",systemrole);
		return systemrole;
	}
	/**
	 * 删除 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemrole(long id){
	
		return getSqlMapClientTemplate().delete("deleteSystemrole", id);
	}
	
	
	/**
	 * 修改 系统角色
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemrole(Systemrole systemrole){
		return getSqlMapClientTemplate().update("updateSystemrole",systemrole);
	
	}

		
	/**
	 * 修改 系统角色但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemroleIgnoreNull(Systemrole systemrole){
		Systemrole tmp = findSystemrole(systemrole.getId());
		int flag =0;
		
		
		if(systemrole.getName()!=null){
			tmp.setName(systemrole.getName());
			
			flag++;
		}
		
		if(systemrole.getCreateuser()!=null){
			tmp.setCreateuser(systemrole.getCreateuser());
			
			flag++;
		}
		
		if(systemrole.getCreatetime()!=null){
			tmp.setCreatetime(systemrole.getCreatetime());
			
			flag++;
		}
		
		if(systemrole.getModifyuser()!=null){
			tmp.setModifyuser(systemrole.getModifyuser());
			
			flag++;
		}
		
		if(systemrole.getModifytime()!=null){
			tmp.setModifytime(systemrole.getModifytime());
			
			flag++;
		}
		
		if(systemrole.getBussinessid()>-1){
			tmp.setBussinessid(systemrole.getBussinessid());
			
			flag++;
		}
		
		if(systemrole.getCustomeragentid()!=null){
			tmp.setCustomeragentid(systemrole.getCustomeragentid());
			
			flag++;
		}
		
		if(systemrole.getType()!=null){
			tmp.setType(systemrole.getType());
			
			flag++;
		}
		
		if(systemrole.getCode()!=null){
			tmp.setCode(systemrole.getCode());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSystemrole",tmp);
		}
	}
	
	/**
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSystemrole",map, offset, limit);
	}
		
	
	/**
	 * 查找 系统角色
	 * @param id
	 * @return
	 */
	public Systemrole findSystemrole(long id){
		return (Systemrole)(getSqlMapClientTemplate().queryForObject("findSystemrole",id));
	}
	
	/** 
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSystemroleBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSystemrole",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找系统角色
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSystemroleBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 系统角色
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemroleBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSystemroleBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemroleBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSystemroleBySql",map).toString()));
	}
}

