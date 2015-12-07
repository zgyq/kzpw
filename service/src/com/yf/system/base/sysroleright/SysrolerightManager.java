/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysroleright;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SysrolerightManager extends  SqlMapClientDaoSupport  implements ISysrolerightManager{ 
	
  
 	/**
	 * 创建 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public Sysroleright createSysroleright(Sysroleright sysroleright) throws SQLException{
	
		if(sysroleright.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		sysroleright.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SYSROLERIGHT"));
		getSqlMapClientTemplate().insert("createSysroleright",sysroleright);
		return sysroleright;
	}
	/**
	 * 删除 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysroleright(long id){
	
		return getSqlMapClientTemplate().delete("deleteSysroleright", id);
	}
	
	
	/**
	 * 修改 系统角色权限关联
	 * @param id
	 * @return updated count 
	 */
	public int updateSysroleright(Sysroleright sysroleright){
		return getSqlMapClientTemplate().update("updateSysroleright",sysroleright);
	
	}

		
	/**
	 * 修改 系统角色权限关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysrolerightIgnoreNull(Sysroleright sysroleright){
		Sysroleright tmp = findSysroleright(sysroleright.getId());
		int flag =0;
		
		
		if(sysroleright.getRoleid()!=null){
			tmp.setRoleid(sysroleright.getRoleid());
			
			flag++;
		}
		
		if(sysroleright.getRightid()!=null){
			tmp.setRightid(sysroleright.getRightid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSysroleright",tmp);
		}
	}
	
	/**
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSysroleright",map, offset, limit);
	}
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param id
	 * @return
	 */
	public Sysroleright findSysroleright(long id){
		return (Sysroleright)(getSqlMapClientTemplate().queryForObject("findSysroleright",id));
	}
	
	/** 
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSysrolerightBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSysroleright",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找系统角色权限关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSysrolerightBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 系统角色权限关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysrolerightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSysrolerightBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysrolerightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSysrolerightBySql",map).toString()));
	}
}

