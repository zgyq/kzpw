/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemright;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SystemrightManager extends  SqlMapClientDaoSupport  implements ISystemrightManager{ 
	
  
 	/**
	 * 创建 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public Systemright createSystemright(Systemright systemright) throws SQLException{
	
		if(systemright.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		systemright.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SYSTEMRIGHT"));
		getSqlMapClientTemplate().insert("createSystemright",systemright);
		return systemright;
	}
	/**
	 * 删除 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemright(long id){
	
		return getSqlMapClientTemplate().delete("deleteSystemright", id);
	}
	
	
	/**
	 * 修改 系统权限
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemright(Systemright systemright){
		return getSqlMapClientTemplate().update("updateSystemright",systemright);
	
	}

		
	/**
	 * 修改 系统权限但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemrightIgnoreNull(Systemright systemright){
		Systemright tmp = findSystemright(systemright.getId());
		int flag =0;
		
		
		if(systemright.getName()!=null){
			tmp.setName(systemright.getName());
			
			flag++;
		}
		
		if(systemright.getCode()!=null){
			tmp.setCode(systemright.getCode());
			
			flag++;
		}
		
		if(systemright.getCreateuser()!=null){
			tmp.setCreateuser(systemright.getCreateuser());
			
			flag++;
		}
		
		if(systemright.getCreatetime()!=null){
			tmp.setCreatetime(systemright.getCreatetime());
			
			flag++;
		}
		
		if(systemright.getModifyuser()!=null){
			tmp.setModifyuser(systemright.getModifyuser());
			
			flag++;
		}
		
		if(systemright.getModifytime()!=null){
			tmp.setModifytime(systemright.getModifytime());
			
			flag++;
		}
		
		if(systemright.getState()!=null){
			tmp.setState(systemright.getState());
			
			flag++;
		}
		
		if(systemright.getParentid()!=null){
			tmp.setParentid(systemright.getParentid());
			
			flag++;
		}
		
		if(systemright.getParentstr()!=null){
			tmp.setParentstr(systemright.getParentstr());
			
			flag++;
		}
		
		if(systemright.getType()!=null){
			tmp.setType(systemright.getType());
			
			flag++;
		}
		
		if(systemright.getResource()!=null){
			tmp.setResource(systemright.getResource());
			
			flag++;
		}
		
		if(systemright.getOrderid()!=null){
			tmp.setOrderid(systemright.getOrderid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSystemright",tmp);
		}
	}
	
	/**
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemright(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSystemright",map, offset, limit);
	}
		
	
	/**
	 * 查找 系统权限
	 * @param id
	 * @return
	 */
	public Systemright findSystemright(long id){
		return (Systemright)(getSqlMapClientTemplate().queryForObject("findSystemright",id));
	}
	
	/** 
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemright(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSystemrightBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSystemright",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找系统权限
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemright(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSystemrightBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 系统权限
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemrightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSystemrightBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemrightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSystemrightBySql",map).toString()));
	}
}

