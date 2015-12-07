/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysconfig;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SysconfigManager extends  SqlMapClientDaoSupport  implements ISysconfigManager{ 
	
  
 	/**
	 * 创建 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public Sysconfig createSysconfig(Sysconfig sysconfig) throws SQLException{
	
		if(sysconfig.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		sysconfig.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SYSCONFIG"));
		getSqlMapClientTemplate().insert("createSysconfig",sysconfig);
		return sysconfig;
	}
	/**
	 * 删除 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysconfig(long id){
	
		return getSqlMapClientTemplate().delete("deleteSysconfig", id);
	}
	
	
	/**
	 * 修改 系统配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateSysconfig(Sysconfig sysconfig){
		return getSqlMapClientTemplate().update("updateSysconfig",sysconfig);
	
	}

		
	/**
	 * 修改 系统配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysconfigIgnoreNull(Sysconfig sysconfig){
		Sysconfig tmp = findSysconfig(sysconfig.getId());
		int flag =0;
		
		
		if(sysconfig.getName()!=null){
			tmp.setName(sysconfig.getName());
			
			flag++;
		}
		
		if(sysconfig.getValue()!=null){
			tmp.setValue(sysconfig.getValue());
			
			flag++;
		}
		
		if(sysconfig.getDescription()!=null){
			tmp.setDescription(sysconfig.getDescription());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSysconfig",tmp);
		}
	}
	
	/**
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSysconfig",map, offset, limit);
	}
		
	
	/**
	 * 查找 系统配置表
	 * @param id
	 * @return
	 */
	public Sysconfig findSysconfig(long id){
		return (Sysconfig)(getSqlMapClientTemplate().queryForObject("findSysconfig",id));
	}
	
	/** 
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSysconfigBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSysconfig",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找系统配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSysconfigBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 系统配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysconfigBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSysconfigBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysconfigBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSysconfigBySql",map).toString()));
	}
}

